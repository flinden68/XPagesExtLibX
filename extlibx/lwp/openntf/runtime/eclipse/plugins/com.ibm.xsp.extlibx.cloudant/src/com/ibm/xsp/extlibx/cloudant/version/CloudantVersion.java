package com.ibm.xsp.extlibx.cloudant.version;

import com.ibm.xsp.core.Version;
import com.ibm.xsp.extlibx.cloudant.logger.CloudantLogger;

public class CloudantVersion {
	private static String s_currentVersion;
	public static String getCurrentVersionString(){
		if( null == s_currentVersion ){
			final Version currentVersionObj = computeCurrentVersion();
			s_currentVersion = currentVersionObj.toString();
		}
		return s_currentVersion;
	}
	private static Version computeCurrentVersion(){
		String versionStr;
		/* Note this value is different in the openNTF stream
		 * from Notes/Domino in-development stream. */
		final boolean isOpenNTFRelease = true;
		if( isOpenNTFRelease ){
			versionStr = "9.0.1.v00_16"; // $NON-NLS-1$
			if( CloudantLogger.CLOUDANT.isTraceDebugEnabled() ){
				CloudantLogger.CLOUDANT.traceDebugp(CloudantVersion.class, "computeCurrentVersion", //$NON-NLS-1$
						"Current Relational version is "+versionStr); //$NON-NLS-1$
			}
		}else{
			versionStr = "9.0.1.v00_00"; // $NON-NLS-1$
		}
		return Version.parseVersion(versionStr);
	}
}
