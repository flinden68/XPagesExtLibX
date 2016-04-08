package com.ibm.xsp.extlibx.cloudant.model;

import java.util.List;

import javax.faces.context.FacesContext;

import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.ibm.commons.util.StringUtil;
import com.ibm.xsp.FacesExceptionEx;
import com.ibm.xsp.extlib.model.DataBlockAccessor;
import com.ibm.xsp.extlibx.cloudant.util.CloudantUtil;

public class CloudantDataBlockAccessor extends DataBlockAccessor {

	private String connectionManager;
	private String dbName;
	private String fullClassName;

	public CloudantDataBlockAccessor() {} // Serializable
	public CloudantDataBlockAccessor(final CloudantDataSource ds) {
		this.connectionManager = ds.getConnectionManager();
		this.dbName = ds.getDbName();
		this.fullClassName = ds.getFullClassName();
	}

	@Override
	protected Block loadBlock(int index, final int blockSize) {
		final CloudantClient client = findCloudantClient();
		if(!CloudantUtil.databaseExist(client,dbName)){
			return new EmptyBlock();
		}
		final Database db = CloudantUtil.findDatabase(client, dbName);

		try {
			final Object cls = Class.forName(fullClassName).newInstance();
			final List<?> rows = db.getAllDocsRequestBuilder().includeDocs(true).build().getResponse().getDocsAs(cls.getClass());
			index = rows.size();

			return new ArrayBlock(index,rows.toArray());

		} catch (final Exception ex) {
			final String msg = "Error while reading the cloudant data";
			throw new FacesExceptionEx(ex,msg);
		}

	}

	protected CloudantClient findCloudantClient(){

		if(StringUtil.isNotEmpty(connectionManager)) {
			return CloudantUtil.createManagedConnection(FacesContext.getCurrentInstance(),getDataSource()!=null?getDataSource().getComponent():null,connectionManager);
		}
		return null;
	}

}
