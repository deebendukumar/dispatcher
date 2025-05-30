package com.dispatcher.service.odoo.api;

import org.apache.xmlrpc.XmlRpcException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 
 * Main class for managing reports with the server.
 */
public class ReportAdapter {

	private Session session;
	private Version serverVersion;
	private Object[] report;
	private String reportName;
	private String reportModel;
	private String reportMethod;
	private ObjectAdapter objectReportAdapter;

	/**
	 * @
	 */
	private static final HashMap<String, Object[]> reportListCache = new HashMap<String, Object[]>();

	public ReportAdapter(Session session) throws XmlRpcException {
		super();
		this.session = session;
		this.serverVersion = session.getServerVersion();
		try {
			getReportList();

		} catch (OdooApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Method listing the available report and their type Purpose is to use the list
	 * later to check the existence of the report and its type. Appropriate methods
	 * will be possible regarding the type
	 */
	private void getReportList() throws XmlRpcException, OdooApiException {
		reportListCache.clear();
		objectReportAdapter = this.session.getObjectAdapter(this.getReportModel());
		FilterCollection filters = new FilterCollection();
		String[] report_tuple = new String[] { "id", "report_name", "model", "name", "report_type" };
		RowCollection reports = objectReportAdapter.searchAndReadObject(filters, report_tuple);
		reports.forEach(report -> {
			Object[] repName = new Object[] { report.get("name"),
					report.get("model"),
					report.get("report_type"),
					report.get("id") };
			reportListCache.put(report.get("report_name").toString(), repName);
		});
	}

	/**
	 * This method is fully inspire by
	 * https://github.com/OCA/odoorpc/blob/master/odoorpc/report.py#L113 from
	 * https://github.com/sebalix
	 * 
	 * @return string representing the reportModel regarding the version
	 */
	public String getReportModel() {
		reportModel = "ir.actions.report";
		if (this.serverVersion.getMajor() < 11) {
			reportModel = "ir.actions.report.xml";
		}
		return reportModel;
	}

	public String getReportMethod() {
		/**
		 * Default value of the method for v11
		 */
		reportMethod = "render"; 
		if (this.serverVersion.getMajor() < 11) {
			reportMethod = "render_report";
		}
		return reportMethod;
	}

	/**
	 * @param reportName
	 * @param ids
	 * @return
	 * @throws Throwable
	 */
	public byte[] getPDFReportAsByte(String reportName, Object[] ids) throws Throwable {
		checkReportName(reportName);
		byte[] reportDatas;
		if (this.serverVersion.getMajor() < 11) {
			reportDatas = session.executeReportService(reportName, this.getReportMethod(), ids);
		} else {
			ArrayList<Object> reportParams = new ArrayList<Object>();
			reportParams.add( getReportID());
			reportParams.add( ids);
			Object[] result = session.call_report_jsonrpc(getReportModel(), getReportMethod(), reportParams);

			String pdf_string= (String) result[0]; 
			reportDatas = pdf_string.getBytes(StandardCharsets.ISO_8859_1);
		}
		return reportDatas;
	}

	/**
	 * 
	 * Method to prepare the report to be generated Make some usefull tests
	 * regarding the
	 * 
	 * @param reportName: can be found in Technical > report > report
	 * @throws OdooApiException
	 * @throws XmlRpcException
	 */
	private void checkReportName(String reportName) throws OdooApiException, XmlRpcException {
		// TODO Auto-generated method stub
		// refresh
		getReportList();
		if (reportName == null) {
			throw new OdooApiException("Report Name is mandatory.  Please read the Odoo help.");
		}
		Object[] report = reportListCache.get(reportName);
		if (report == null) {
			throw new OdooApiException(
					"Your report don't seems to exist in the Odoo Database." + "Please check your configuration");
		}
		if (!Arrays.asList("qweb-pdf", "qweb-html").contains(report[2])) {
			throw new OdooApiException(
					"Your report type is obsolete. Only QWEB report are allowed." + "Please check your configuration");
		}

	}

	public void setReport(String reportName) throws OdooApiException, XmlRpcException {
		checkReportName(reportName);
		Object[] report = reportListCache.get(reportName);
		this.report = report;
		this.reportName = reportName;
	}

	public String getReportType() {
		return this.report[2].toString();
	}

	public Integer getReportID() {
		return Integer.valueOf(this.report[3].toString());
	}

	public String PrintReportToFileName(Object[] ids) throws IOException, XmlRpcException, OdooApiException {

		File tmp_file = File.createTempFile("odoo-" + report[1].toString() + "-", getReportType().replace("qweb-", "."),
				null);

		byte[] report_bytes;
		FileOutputStream report_stream = new FileOutputStream(tmp_file);
		try {
			report_bytes = getPDFReportAsByte(reportName, ids);
			report_stream.write(report_bytes);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			report_stream.close();
		}

		return tmp_file.getAbsolutePath().toString();
	}

}
