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
 * Provides a wrapper for {@link ProgramTypeMasterService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProgramTypeMasterService
 * @generated
 */
public class ProgramTypeMasterServiceWrapper
	implements ProgramTypeMasterService,
			   ServiceWrapper<ProgramTypeMasterService> {

	public ProgramTypeMasterServiceWrapper() {
		this(null);
	}

	public ProgramTypeMasterServiceWrapper(
		ProgramTypeMasterService programTypeMasterService) {

		_programTypeMasterService = programTypeMasterService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _programTypeMasterService.getOSGiServiceIdentifier();
	}

	@Override
	public ProgramTypeMasterService getWrappedService() {
		return _programTypeMasterService;
	}

	@Override
	public void setWrappedService(
		ProgramTypeMasterService programTypeMasterService) {

		_programTypeMasterService = programTypeMasterService;
	}

	private ProgramTypeMasterService _programTypeMasterService;

}