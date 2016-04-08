package com.ibm.xsp.extlibx.cloudant.component.connection;

import com.cloudant.client.api.CloudantClient;

public interface ICloudantConnectionManager {

	public CloudantClient getCloudantClient();

}
