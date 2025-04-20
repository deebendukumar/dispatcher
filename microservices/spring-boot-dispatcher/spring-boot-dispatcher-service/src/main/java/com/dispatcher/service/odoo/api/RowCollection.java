package com.dispatcher.service.odoo.api;

import com.dispatcher.service.base.entity.Auditable;

import java.util.ArrayList;
import java.util.HashMap;

/***
 * Row collection for OpenERP row data
 */
public class RowCollection extends ArrayList<com.dispatcher.service.odoo.api.Row> implements Auditable {

	private static final long serialVersionUID = -168965138153400087L;
	
	public RowCollection(){
	}

	@SuppressWarnings("unchecked")
	public RowCollection(Object [] openERPResultSet, com.dispatcher.service.odoo.api.FieldCollection fields) throws com.dispatcher.service.odoo.api.OdooApiException {
		for (int i = 0; i < openERPResultSet.length; i++){
			com.dispatcher.service.odoo.api.Row row = new com.dispatcher.service.odoo.api.Row((HashMap<String, Object>) openERPResultSet[i], fields);
			this.add(row);
		}
	}

	@Override
	public void add(int index, com.dispatcher.service.odoo.api.Row element) {
		super.add(index, element);
	}

	@Override
	public boolean add(com.dispatcher.service.odoo.api.Row e) {
		return super.add(e);
	}
}
