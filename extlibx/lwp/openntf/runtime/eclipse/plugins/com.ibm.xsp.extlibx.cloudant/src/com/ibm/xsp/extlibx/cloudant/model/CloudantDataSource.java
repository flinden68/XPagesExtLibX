package com.ibm.xsp.extlibx.cloudant.model;

import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;
import javax.faces.model.DataModel;

import com.ibm.xsp.extlib.model.DataAccessorBlockSource;
import com.ibm.xsp.extlib.model.DataBlockAccessor;
import com.ibm.xsp.model.TabularDataSource;

public class CloudantDataSource extends DataAccessorBlockSource implements TabularDataSource {

	private String connectionManager;
	private String dbName;
	private String fullClassName;

	public CloudantDataSource(){

	}


	@Override
	protected DataBlockAccessor createAccessor() {
		return new CloudantDataBlockAccessor(this);
	}

	@Override
	public DataModel getDataModel() {
		return new CloudantDataAccessorModel(this,(Container)getDataContainer());
	}


	public String getConnectionManager() {
		if (null != connectionManager) {
			return connectionManager;
		}
		final ValueBinding valueBinding = getValueBinding("connectionManager"); // $NON-NLS-1$
		if (valueBinding != null) {
			final String value = (String)valueBinding.getValue(getFacesContext());
			return value;
		}
		return null;
	}


	public void setConnectionManager(final String connectionManager) {
		this.connectionManager = connectionManager;
	}


	public String getDbName() {
		if (null != dbName) {
			return dbName;
		}
		final ValueBinding valueBinding = getValueBinding("dbName"); // $NON-NLS-1$
		if (valueBinding != null) {
			final String value = (String)valueBinding.getValue(getFacesContext());
			return value;
		}
		return null;
	}


	public void setDbName(final String dbName) {
		this.dbName = dbName;
	}


	public String getFullClassName() {
		if (null != fullClassName) {
			return fullClassName;
		}
		final ValueBinding valueBinding = getValueBinding("fullClassName"); // $NON-NLS-1$
		if (valueBinding != null) {
			final String value = (String)valueBinding.getValue(getFacesContext());
			return value;
		}
		return null;
	}


	public void setFullClassName(final String fullClassName) {
		this.fullClassName = fullClassName;
	}

	@Override
	public Object saveState(final FacesContext context) {
		if (isTransient()) {
			return null;
		}
		final Object[] state = new Object[12];
		state[0] = super.saveState(context);
		state[1] = connectionManager;
		state[2] = dbName;
		state[3] = fullClassName;

		return state;
	}
	@Override
	public void restoreState(final FacesContext context, final Object state) {
		final Object[] values = (Object[])state;
		super.restoreState(context, values[0]);
		this.connectionManager = (String)values[1];
		this.dbName = (String)values[2];
		this.fullClassName = (String)values[3];
	}

}
