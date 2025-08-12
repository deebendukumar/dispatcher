package com.dispatcher.odoo;

import com.dispatcher.common.base.Auditable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/***
 * Array of Field objects.
 */
public class FieldCollection extends ArrayList<Field> implements Auditable {

	private static final long serialVersionUID = 470551054665276346L;
	
	/**
	 * Sorts the field entries in this field collection by Name
	 */
	public void SortByName(){
	  Collections.sort(this,new FieldByNameComparator());
	}
	
	private class FieldByNameComparator implements Comparator<Field> { 

	  @Override
	  public int compare(Field arg0, Field arg1) {
	    return arg0.getName().compareTo(arg1.getName());
	  }
	}
}
