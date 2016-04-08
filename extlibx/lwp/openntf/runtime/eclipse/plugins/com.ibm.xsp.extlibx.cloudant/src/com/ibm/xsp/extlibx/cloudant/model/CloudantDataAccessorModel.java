package com.ibm.xsp.extlibx.cloudant.model;

import com.ibm.xsp.extlib.model.DataAccessorModel;

public class CloudantDataAccessorModel extends DataAccessorModel {

	public CloudantDataAccessorModel(final CloudantDataSource data,
			final CloudantDataSource.Container dataContainer) {
		super(data, dataContainer);
	}

	@Override
	public CloudantDataSource.Container getDataContainer() {
		return super.getDataContainer();
	}

	@Override
	public CloudantDataBlockAccessor getDataAccessor() {
		return (CloudantDataBlockAccessor)getDataContainer().getDataAccessor();
	}

	@Override
	public String getRowId() {
		return Integer.toString(getRowIndex());
	}

}
