package com.ibm.xsp.extlibx.cloudant.component.connection;

import javax.faces.component.UIComponentBase;

import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;

public class UICloudantConnectionManager extends UIComponentBase implements ICloudantConnectionManager {

	public static final String COMPONENT_FAMILY = "com.ibm.xsp.extlib.cloudant.CloudantConnectionManager"; // $NON-NLS-1$
	public static final String COMPONENT_TYPE = "com.ibm.xsp.extlib.cloudant.CloudantConnectionManager"; // $NON-NLS-1$
	public static final String RENDERER_TYPE = "com.ibm.xsp.extlib.cloudant.CloudantConnectionManager"; // $NON-NLS-1$

	private String accountName;
	private String userName;
	private String password;

	public UICloudantConnectionManager(){
		super();
		// Should not exists as it never render anything.
		setRendererType(RENDERER_TYPE);
	}

	@Override
	public CloudantClient getCloudantClient(){
		return ClientBuilder.account(accountName)
				.username(userName)
				.password(password)
				.build();

	}

	@Override
	public String getFamily() {
		return COMPONENT_FAMILY;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(final String accountName) {
		this.accountName = accountName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(final String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

}
