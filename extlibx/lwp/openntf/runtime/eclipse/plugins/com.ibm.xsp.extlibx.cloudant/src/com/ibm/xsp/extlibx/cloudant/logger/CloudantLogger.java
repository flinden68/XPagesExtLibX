package com.ibm.xsp.extlibx.cloudant.logger;

import com.ibm.commons.log.Log;
import com.ibm.commons.log.LogMgr;

public class CloudantLogger extends Log {
	public static LogMgr CLOUDANT            = load("com.ibm.xsp.extlib.cloudant");
}
