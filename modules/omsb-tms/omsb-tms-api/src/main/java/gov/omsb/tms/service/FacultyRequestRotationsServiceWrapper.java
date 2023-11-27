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
 * Provides a wrapper for {@link FacultyRequestRotationsService}.
 *
 * @author Brian Wing Shun Chan
 * @see FacultyRequestRotationsService
 * @generated
 */
public class FacultyRequestRotationsServiceWrapper
	implements FacultyRequestRotationsService,
			   ServiceWrapper<FacultyRequestRotationsService> {

	public FacultyRequestRotationsServiceWrapper() {
		this(null);
	}

	public FacultyRequestRotationsServiceWrapper(
		FacultyRequestRotationsService facultyRequestRotationsService) {

		_facultyRequestRotationsService = facultyRequestRotationsService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _facultyRequestRotationsService.getOSGiServiceIdentifier();
	}

	@Override
	public FacultyRequestRotationsService getWrappedService() {
		return _facultyRequestRotationsService;
	}

	@Override
	public void setWrappedService(
		FacultyRequestRotationsService facultyRequestRotationsService) {

		_facultyRequestRotationsService = facultyRequestRotationsService;
	}

	private FacultyRequestRotationsService _facultyRequestRotationsService;

}