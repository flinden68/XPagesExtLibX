package com.ibm.xsp.extlibx.cloudant.util;

import java.sql.SQLException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.ibm.commons.util.StringUtil;
import com.ibm.xsp.FacesExceptionEx;
import com.ibm.xsp.extlibx.cloudant.component.connection.ICloudantConnectionManager;
import com.ibm.xsp.util.FacesUtil;

public class CloudantUtil {

	/**
	 * Find a connection manager by name
	 *
	 * @param context
	 * @param name
	 * @param shared
	 * @return
	 * @throws SQLException
	 */
	public static ICloudantConnectionManager findConnectionManager(final FacesContext context, final UIComponent from, final String name) {
		final UIComponent c = FacesUtil.getComponentFor(from, name);
		if (c != null) {
			return (ICloudantConnectionManager) c;
		}
		return null;
	}

	public static CloudantClient createManagedConnection(final FacesContext context, UIComponent from, final String name){
		if (from == null) {
			from = context.getViewRoot();
		}
		final ICloudantConnectionManager manager = findConnectionManager(context, from, name);
		if (manager == null) {
			throw new FacesExceptionEx(null, StringUtil.format("Unknown ConnectionManager {0}", name)); // $NLX-JdbcUtil.Unknown01-1$
		}
		return manager.getCloudantClient();
	}

	public static  boolean databaseExist(final CloudantClient client, final String dbName){
		final Database db = client.database(dbName,false);
		return db != null;
	}

	public static Database findDatabase(final CloudantClient client, final String dbName){
		return client.database(dbName,false);
	}
}
