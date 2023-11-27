/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package gov.omsb.tms.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CptCodeMasterService}.
 *
 * @author Brian Wing Shun Chan
 * @see CptCodeMasterService
 * @generated
 */
public class CptCodeMasterServiceWrapper
	implements CptCodeMasterService, ServiceWrapper<CptCodeMasterService> {

	public CptCodeMasterServiceWrapper() {
		this(null);
	}

	public CptCodeMasterServiceWrapper(
		CptCodeMasterService cptCodeMasterService) {

		_cptCodeMasterService = cptCodeMasterService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _cptCodeMasterService.getOSGiServiceIdentifier();
	}

	@Override
	public CptCodeMasterService getWrappedService() {
		return _cptCodeMasterService;
	}

	@Override
	public void setWrappedService(CptCodeMasterService cptCodeMasterService) {
		_cptCodeMasterService = cptCodeMasterService;
	}

	private CptCodeMasterService _cptCodeMasterService;

}