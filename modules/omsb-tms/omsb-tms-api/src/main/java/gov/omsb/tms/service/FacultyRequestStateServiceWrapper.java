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
 * Provides a wrapper for {@link FacultyRequestStateService}.
 *
 * @author Brian Wing Shun Chan
 * @see FacultyRequestStateService
 * @generated
 */
public class FacultyRequestStateServiceWrapper
	implements FacultyRequestStateService,
			   ServiceWrapper<FacultyRequestStateService> {

	public FacultyRequestStateServiceWrapper() {
		this(null);
	}

	public FacultyRequestStateServiceWrapper(
		FacultyRequestStateService facultyRequestStateService) {

		_facultyRequestStateService = facultyRequestStateService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _facultyRequestStateService.getOSGiServiceIdentifier();
	}

	@Override
	public FacultyRequestStateService getWrappedService() {
		return _facultyRequestStateService;
	}

	@Override
	public void setWrappedService(
		FacultyRequestStateService facultyRequestStateService) {

		_facultyRequestStateService = facultyRequestStateService;
	}

	private FacultyRequestStateService _facultyRequestStateService;

}