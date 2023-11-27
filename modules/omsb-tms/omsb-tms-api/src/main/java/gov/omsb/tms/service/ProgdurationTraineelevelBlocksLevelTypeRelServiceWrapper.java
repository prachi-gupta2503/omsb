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
 * Provides a wrapper for {@link ProgdurationTraineelevelBlocksLevelTypeRelService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProgdurationTraineelevelBlocksLevelTypeRelService
 * @generated
 */
public class ProgdurationTraineelevelBlocksLevelTypeRelServiceWrapper
	implements ProgdurationTraineelevelBlocksLevelTypeRelService,
			   ServiceWrapper
				   <ProgdurationTraineelevelBlocksLevelTypeRelService> {

	public ProgdurationTraineelevelBlocksLevelTypeRelServiceWrapper() {
		this(null);
	}

	public ProgdurationTraineelevelBlocksLevelTypeRelServiceWrapper(
		ProgdurationTraineelevelBlocksLevelTypeRelService
			progdurationTraineelevelBlocksLevelTypeRelService) {

		_progdurationTraineelevelBlocksLevelTypeRelService =
			progdurationTraineelevelBlocksLevelTypeRelService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _progdurationTraineelevelBlocksLevelTypeRelService.
			getOSGiServiceIdentifier();
	}

	@Override
	public ProgdurationTraineelevelBlocksLevelTypeRelService
		getWrappedService() {

		return _progdurationTraineelevelBlocksLevelTypeRelService;
	}

	@Override
	public void setWrappedService(
		ProgdurationTraineelevelBlocksLevelTypeRelService
			progdurationTraineelevelBlocksLevelTypeRelService) {

		_progdurationTraineelevelBlocksLevelTypeRelService =
			progdurationTraineelevelBlocksLevelTypeRelService;
	}

	private ProgdurationTraineelevelBlocksLevelTypeRelService
		_progdurationTraineelevelBlocksLevelTypeRelService;

}