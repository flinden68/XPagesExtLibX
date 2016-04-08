package com.ibm.xsp.extlibx.cloudant.library;


import com.ibm.xsp.extlibx.cloudant.Activator;
import com.ibm.xsp.extlibx.cloudant.version.CloudantVersion;
import com.ibm.xsp.library.AbstractXspLibrary;

public class CloudantLibrary extends AbstractXspLibrary {

	public static final String LIBRARY_ID = CloudantLibrary.class.getName();

	public CloudantLibrary() {
		System.out.println("Loading Cloudant Connector ("+getPluginId()+")");
	}

	@Override
	public String getLibraryId() {
		// TODO Auto-generated method stub
		return LIBRARY_ID;
	}

	@Override
	public String getPluginId() {
		return Activator.PLUGIN_ID;
	}

	@Override
	public String[] getDependencies() {
		return new String[] { "com.ibm.xsp.core.library",
				"com.ibm.xsp.extsn.library", "com.ibm.xsp.domino.library",
		"com.ibm.xsp.designer.library" };
	}


	@Override
	public String[] getFacesConfigFiles() {
		final String[] files = new String[] { "META-INF/elstar-faces-config.xml"};
		return files;
	}

	@Override
	public String[] getXspConfigFiles() {
		return new String[]{
				"com/ibm/xsp/extlib/cloudant/config/cloudant.xsp-config"
		};
	}

	/* (non-Javadoc)
	 * @see com.ibm.xsp.library.AbstractXspLibrary#getTagVersion()
	 */
	@Override
	public String getTagVersion() {
		return CloudantVersion.getCurrentVersionString();
	}

}
