package com.dispatcher.odoo;

import com.dispatcher.common.base.Auditable;
import com.dispatcher.odoo.exception.OdooApiException;

import java.util.ArrayList;
import java.util.HashMap;

/***
 * Row collection for OpenERP row data
 */
public class RowCollection extends ArrayList<Row> implements Auditable {

    private static final long serialVersionUID = -168965138153400087L;

    public RowCollection() {
    }

    @SuppressWarnings("unchecked")
    public RowCollection(Object[] openERPResultSet, FieldCollection fields) throws OdooApiException {
        for (int i = 0; i < openERPResultSet.length; i++) {
            Row row = new Row((HashMap<String, Object>) openERPResultSet[i], fields);
            this.add(row);
        }
    }

    @Override
    public void add(int index, Row element) {
        super.add(index, element);
    }

    @Override
    public boolean add(Row e) {
        return super.add(e);
    }
}
