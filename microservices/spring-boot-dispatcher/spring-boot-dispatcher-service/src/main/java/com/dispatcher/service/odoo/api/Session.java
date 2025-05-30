package com.dispatcher.service.odoo.api;

import com.googlecode.jsonrpc4j.*;
import com.dispatcher.service.odoo.api.OdooXmlRpcProxy.RPCProtocol;
import com.dispatcher.service.odoo.api.OdooXmlRpcProxy.RPCServices;
import org.apache.xmlrpc.XmlRpcException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.DatatypeConverter;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.*;

/**
 * *
 * Manages an Odoo session by holding context and initiating all calls to the
 * server.
 */
public class Session {

    private static final Logger logger = LoggerFactory.getLogger(Session.class);

    private static final String LINE_SEPARATOR_SYSTEM_PROPERTY = "line.separator";
    private static final String LINE_SEPARATOR = System.getProperty(LINE_SEPARATOR_SYSTEM_PROPERTY);
    private String host;
    private int port;
    private String databaseName;
    private String userName;
    private String password;
    private int userID;
    private com.dispatcher.service.odoo.api.Context context = new com.dispatcher.service.odoo.api.Context();
    private static boolean connecting = false;
    private RPCProtocol protocol;

    private com.dispatcher.service.odoo.api.OdooXmlRpcProxy objectClient;
    private com.dispatcher.service.odoo.api.Version serverVersion;

    private URL jsonurl;
    private JsonRpcHttpClient jsonRpcHttpClient;
    // private Object[] login_args;

    public URL getJsonurl(String entryPoint) {
        String protocol_str = "";
        switch (this.protocol) {
            case RPC_HTTP:
                protocol_str = "http";
                break;

            default:
                protocol_str = "https";
                break;
        }

        URL urljson;
        try {
            urljson = new URL(String.format("%s://%s:%s/%s", protocol_str, this.host, this.port, entryPoint));
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            urljson = null;
        }

        this.jsonurl = urljson;
        return this.jsonurl;
    }

    /**
     * * Session constructor
     *
     * @param protocol     XML-RPC protocol to use. ex http/https.
     * @param host         Host name or IP address where the Odoo server is hosted
     * @param port         XML-RPC port number to connect to. Typically 8069.
     * @param databaseName Database name to connect to
     * @param userName     Username to log into the Odoo server
     * @param password     Password to log into the Odoo server
     * @throws MalformedURLException
     */
    public Session(RPCProtocol protocol, String host, int port, String databaseName, String userName, String password) {
        this.protocol = protocol;
        this.host = host;
        this.port = port;
        this.databaseName = databaseName;
        this.userName = userName;
        this.password = password;
        this.objectClient = new com.dispatcher.service.odoo.api.OdooXmlRpcProxy(protocol, host, port, RPCServices.RPC_OBJECT);
        try {
            setJsonClient();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private void setJsonClient() throws MalformedURLException {
        // TODO Auto-generated method stub
        JsonRpcHttpClient client = new JsonRpcHttpClient(getJsonurl(""));
        jsonRpcHttpClient = client;

    }

    /**
     * * Session constructor. Uses default http protocol to connect.
     *
     * @param host         Host name or IP address where the Odoo server is hosted
     * @param port         XML-RPC port number to connect to. Typically 8069.
     * @param databaseName Database name to connect to
     * @param userName     Username to log into the Odoo server
     * @param password     Password to log into the Odoo server
     */
    public Session(String host, int port, String databaseName, String userName, String password) {
        this(RPCProtocol.RPC_HTTP, host, port, databaseName, userName, password);
    }

    /**
     * Returns an initialized ObjectAdapter object for ease of reference. A
     * ObjectAdapter object does type conversions and error checking before making a
     * call to the server
     *
     * @return
     */
    public com.dispatcher.service.odoo.api.ObjectAdapter getObjectAdapter(String objectName) throws XmlRpcException, com.dispatcher.service.odoo.api.OdooApiException {
        return new com.dispatcher.service.odoo.api.ObjectAdapter(this, objectName);
    }

    /**
     * * Starts a session on the Odoo server and saves the UserID for use in later
     * calls
     *
     * @throws Exception upon failure to connect
     */
    public void startSession() throws Exception {

        /**
         * check if the database is present
         */
        checkDatabasePresenceSafe();

        // Synchronize all threads to login. If you login with the same user at
        // the same time you get concurrency
        // errors in the Odoo server (for example by running a multi threaded
        // ETL process like Kettle).
        Session.startConnecting();
        try {
            authenticate();
            checkVersionCompatibility();
        } finally {
            Session.connecting = false;
        }
        getRemoteContext();
    }

    private void checkVersionCompatibility() throws XmlRpcException, com.dispatcher.service.odoo.api.OdooApiException {

        if (this.getServerVersion().getMajor() < 8 || this.getServerVersion().getMajor() > 18) {
            throw new com.dispatcher.service.odoo.api.OdooApiException("Only Odoo Version from v8.x to 17.x are maintained. "
                    + "Please choose another version of the library");
        }
    }

    /**
     * @param reportName
     * @return reportAdapter initialized with
     * @throws com.dispatcher.service.odoo.api.OdooApiException
     * @throws XmlRpcException
     */
    public com.dispatcher.service.odoo.api.ReportAdapter getReportAdapter(String reportName) throws com.dispatcher.service.odoo.api.OdooApiException, XmlRpcException {
        com.dispatcher.service.odoo.api.ReportAdapter reportAdapter = new com.dispatcher.service.odoo.api.ReportAdapter(this);
        reportAdapter.setReport(reportName);
        return reportAdapter;
    }

    void getRemoteContext() throws XmlRpcException {
        this.context.clear();
        @SuppressWarnings("unchecked")
        HashMap<String, Object> odooContext = (HashMap<String, Object>) this.executeCommand("res.users", "context_get",
                new Object[]{});
        this.context.putAll(odooContext);

        // Standard behavior is web/gui clients.
        this.context.setActiveTest(true);
    }

    int authenticate() throws XmlRpcException, Exception {

        // XMLRPC part
        com.dispatcher.service.odoo.api.OdooXmlRpcProxy commonClient = new com.dispatcher.service.odoo.api.OdooXmlRpcProxy(protocol, host, port, RPCServices.RPC_COMMON);
        Object id = commonClient.execute("login", new Object[]{databaseName, userName, password});

        // JSONRPC part
        try {
            id = authenticate_json_rpc();
            if(authenticate_json_rpc() != -1) {
                logger.info("json rpc login");
                userID = (Integer) id;
            } else {
                throw new Exception("Incorrect username and/or password.  Login Failed.");
            }
        } catch (JsonRpcClientException e) {
            if (this.getServerVersion().getMajor() == 10) {
                System.out.println("ODOO 10.0 : Json rpc issue possibly caused by https://github.com/OCA/server-tools/issues/1237");
                e.printStackTrace();
                System.out.println("ODOO 10.0 : if the trace match the issue, you could ignore this message");
            }
        } catch (Throwable e) {
            System.out.println("General exception");
            e.printStackTrace();
        }
        return userID;
    }

    private int authenticate_json_rpc() throws Throwable {
        // TODO: fast and uggly implementation of json rpc, has to be refactored in the
        // future
        jsonRpcHttpClient.setServiceUrl(getJsonurl("jsonrpc"));
        Map<String, Object> jsonparams = new HashMap<>();
        jsonparams.put("service", "common");
        jsonparams.put("method", "login");

        ArrayList<Object> methodparams = new ArrayList<>();
        methodparams.add(databaseName);
        methodparams.add(userName);
        methodparams.add(password);
        //TODO : maybe also use the same syntax as reporting
        jsonparams.put("args", methodparams);

        var result = jsonRpcHttpClient.invoke("call", jsonparams, Object.class);
        if (result instanceof Integer)
            return (int) result;
        else
            return -1;
    }

    public Object[] call_report_jsonrpc(String reportModel, String reportMethod, ArrayList<Object> args)
            throws Throwable {
        // TODO: fast and uggly implementation of json rpc, has to be reafctored in the
        // future

        jsonRpcHttpClient.setServiceUrl(getJsonurl("jsonrpc"));
        Map<String, Object> jsonparams = new HashMap<>();
        jsonparams.put("service", "object");
        jsonparams.put("method", "execute_kw");

        ArrayList<Object> methodparams = new ArrayList<>();
        methodparams.add(databaseName);
        methodparams.add(userID);
        methodparams.add(password);
        methodparams.add(reportModel);
        methodparams.add(reportMethod);

        ArrayList<Object> empty_recordset_for_model_annotation_in_odoo = new ArrayList<>();
        //The render method is annotated @model in Odoo, so we must pass an empty value as the first
        //paramter otherwise Odoo will only interpret 1 parameter from the 2 given
        //TODO: find a way to identify if a metho is annotated with @api.model 
        args.add(0, empty_recordset_for_model_annotation_in_odoo);
        methodparams.add(args);
        jsonparams.put("args", methodparams);
        Object[] result = jsonRpcHttpClient.invoke("call", jsonparams, Object[].class);

        // methodparams.add(args);
        // jsonparams.put("args", methodparams);
        // Object[] result = jsonclient.invoke("call", jsonparams, Object[].class);
        return result;
    }

    void checkDatabasePresenceSafe() {
        try {
            checkDatabasePresence();
        } catch (Exception e) {
            logger.error("error ", e.getMessage());
        }
    }

    void checkDatabasePresence() throws XmlRpcException {
        ArrayList<String> dbList = getDatabaseList(protocol, host, port);
        if (!dbList.contains(databaseName)) {
            StringBuilder messageBuilder = new StringBuilder("Error while connecting to Odoo.  Database [")
                    .append(databaseName).append("]  was not found in the following list: ").append(LINE_SEPARATOR)
                    .append(LINE_SEPARATOR).append(String.join(LINE_SEPARATOR, dbList)).append(LINE_SEPARATOR);
            throw new IllegalStateException(messageBuilder.toString());
        }
    }

    private synchronized static void startConnecting() {
        while (Session.connecting) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Session.connecting = true;
    }

    /**
     * * Get a list of databases available on a specific host and port with the http
     * protocol.
     *
     * @param host Host name or IP address where the Odoo server is hosted
     * @param port XML-RPC port number to connect to
     * @return A list of databases available for the Odoo instance
     * @throws XmlRpcException
     */
    public static ArrayList<String> getDatabaseList(String host, int port) throws XmlRpcException {
        return getDatabaseList(RPCProtocol.RPC_HTTP, host, port);
    }

    /**
     * * Get a list of databases available on a specific host and port
     *
     * @param protocol Protocol to use when connecting to the RPC service ex.
     *                 http/https
     * @param host     Host name or IP address where the Odoo server is hosted
     * @param port     XML-RPC port number to connect to
     * @return A list of databases available for the Odoo instance
     * @throws XmlRpcException
     */
    public static ArrayList<String> getDatabaseList(RPCProtocol protocol, String host, int port)
            throws XmlRpcException {
        com.dispatcher.service.odoo.api.OdooXmlRpcProxy client = new com.dispatcher.service.odoo.api.OdooXmlRpcProxy(protocol, host, port, RPCServices.RPC_DATABASE);

        // Retrieve databases
        Object[] result = (Object[]) client.execute("list", new Object[]{});

        ArrayList<String> finalResults = new ArrayList<String>();
        for (Object res : result) {
            finalResults.add((String) res);
        }

        return finalResults;
    }

    /**
     * Executes any command on the server linked to the /xmlrpc/object service. All
     * parameters are prepended by: "databaseName,userID,password" This method
     * execute the command without the context parameter Its purpose is to be used
     * by Odoo version prior to v10 or for v10 methods that mustn't use the context
     *
     * @param objectName  Object or model name to execute the command on
     * @param commandName Command name to execute
     * @param parameters  List of parameters for the command. For easy of use,
     *                    consider the OdooCommand object or ObjectAdapter
     * @return The result of the call
     * @throws XmlRpcException
     */
    public Object executeCommand(final String objectName, final String commandName, final Object[] parameters)
            throws XmlRpcException {
        Object[] connectionParams = new Object[]{databaseName, userID, password, objectName, commandName};

        // Combine the connection parameters and command parameters
        Object[] params = new Object[connectionParams.length + (parameters == null ? 0 : parameters.length)];
        System.arraycopy(connectionParams, 0, params, 0, connectionParams.length);

        if (parameters != null && parameters.length > 0) {
            System.arraycopy(parameters, 0, params, connectionParams.length, parameters.length);
        }
        return objectClient.execute("execute", params);
    }

    /**
     * Executes any command on the server linked to the /xmlrpc/object service. All
     * parameters are prepended by: "databaseName,userID,password" This method
     * execute the command without the context parameter Its purpose is to be used
     * by Odoo version prior to v10 or for v10 methods that mustn't use the context
     *
     * @param objectName  Object or model name to execute the command on
     * @param commandName Command name to execute
     * @param parameters  List of parameters for the command. For easy of use,
     *                    consider the OdooCommand object or ObjectAdapter
     * @param context     The user context
     * @return The result of the call
     * @throws XmlRpcException
     */
    public Object executeCommandKw(final String objectName, final String commandName, final Object[] parameters,
                                   com.dispatcher.service.odoo.api.Context context) throws XmlRpcException {

        List<Object> paramsList = new ArrayList<>();
        paramsList.addAll(Arrays.asList(new Object[]{databaseName, userID, password, objectName, commandName}));
        if (parameters != null && parameters.length > 0) {
            paramsList.add(Arrays.asList(parameters));
        }

        Map<String, com.dispatcher.service.odoo.api.Context> c = new HashMap<>();
        c.put("context", context);
        paramsList.add(c);
        return objectClient.execute("execute_kw", paramsList);

    }

    /**
     * Executes any command on the server linked to the /xmlrpc/object service.
     * parameters and Context are prepended .The context MUST NOT have been already
     * passed in the parameters.
     *
     * @param objectName  Object or model name to execute the command on
     * @param commandName Command name to execute
     * @param parameters  List of parameters for the command. For easy of use,
     *                    consider the OdooCommand object or ObjectAdapter
     * @return The result of the call
     * @throws XmlRpcException
     */
    public Object executeCommandWithContext(final String objectName, final String commandName,
                                            final Object[] parameters) throws XmlRpcException {
        Object[] connectionParams = new Object[]{databaseName, userID, password, objectName, commandName};

        if (this.getServerVersion().getMajor() < 13) {
            // Combine the parameters with the context
            Object[] params = new Object[1 + (parameters == null ? 0 : parameters.length)];
            if (parameters != null && parameters.length > 0) {
                System.arraycopy(parameters, 0, params, 0, parameters.length);
            }
            System.arraycopy(new Object[]{getContext()}, 0, params, parameters.length, 1);
            return executeCommand(objectName, commandName, params);
        } else {
            return executeCommandKw(objectName, commandName, parameters, getContext());
        }

    }

    /**
     * Executes a workflow by sending a signal to the workflow engine for a specific
     * object. This functions calls the 'exec_workflow' method on the object All
     * parameters are prepended by: "databaseName,userID,password"
     *
     * @param objectName Object or model name to send the signal for
     * @param signal     Signal name to send, for example order_confirm
     * @param objectID   Specific object ID to send the signal for
     * @throws XmlRpcException
     */
    public void executeWorkflow(final String objectName, final String signal, final int objectID)
            throws XmlRpcException {

        if (serverVersion.getMajor() <= 10) {
            Object[] params = new Object[]{databaseName, userID, password, objectName, signal, objectID};
            objectClient.execute("exec_workflow", params);
        } else {
            System.out.println("exec_workflow is not supported in Odoo versions > 10");
        }
    }

    /**
     * Returns the Odoo server version for this session
     *
     * @return
     * @throws XmlRpcException
     */
    public com.dispatcher.service.odoo.api.Version getServerVersion() throws XmlRpcException {
        if (serverVersion == null) {
            // Cache server version
            serverVersion = com.dispatcher.service.odoo.api.OdooXmlRpcProxy.getServerVersion(protocol, host, port);
        }
        return serverVersion;
    }

    public byte[] executeReportService(String reportName, String reportMethod, Object[] ids) throws XmlRpcException {
        byte[] finalResults;

        Object[] reportParams = new Object[]{databaseName, userID, password, reportName, ids};
        if (getServerVersion().getMajor() < 11) {
            com.dispatcher.service.odoo.api.OdooXmlRpcProxy client = new com.dispatcher.service.odoo.api.OdooXmlRpcProxy(protocol, host, port, RPCServices.RPC_REPORT);
            Map<String, Object> result = (Map<String, Object>) client.execute(reportMethod, reportParams);
            finalResults = DatatypeConverter.parseBase64Binary((String) result.get("result"));

        } else {
            // Implement changes thanks to
            // https://github.com/OCA/odoorpc/issues/20
            com.dispatcher.service.odoo.api.OdooXmlRpcProxy client = new com.dispatcher.service.odoo.api.OdooXmlRpcProxy(protocol, host, port, RPCServices.RPC_OBJECT);
            ByteBuffer result = (ByteBuffer) this.executeCommandWithContext("ir.actions.report", reportMethod,
                    reportParams);
            finalResults = result.array();
        }
        return finalResults;

    }

    /**
     * Returns the current logged in User's UserID
     *
     * @return
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Retrieves the context object for the session to set properties on
     *
     * @return
     */
    public com.dispatcher.service.odoo.api.Context getContext() {
        return context;
    }

    public JsonRpcHttpClient getJsonRpcHttpClient() {
        return jsonRpcHttpClient;
    }

    public Object[] getLogin_args() {
        Object[] args = new Object[]{databaseName, userID, password};

        return args;
    }
}
