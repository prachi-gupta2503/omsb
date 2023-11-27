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
 * Provides a wrapper for {@link DutyLogViolationService}.
 *
 * @author Brian Wing Shun Chan
 * @see DutyLogViolationService
 * @generated
 */
public class DutyLogViolationServiceWrapper
	implements DutyLogViolationService,
			   ServiceWrapper<DutyLogViolationService> {

	public DutyLogViolationServiceWrapper() {
		this(null);
	}

	public DutyLogViolationServiceWrapper(
		DutyLogViolationService dutyLogViolationService) {

		_dutyLogViolationService = dutyLogViolationService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dutyLogViolationService.getOSGiServiceIdentifier();
	}

	@Override
	public DutyLogViolationService getWrappedService() {
		return _dutyLogViolationService;
	}

	@Override
	public void setWrappedService(
		DutyLogViolationService dutyLogViolationService) {

		_dutyLogViolationService = dutyLogViolationService;
	}

	private DutyLogViolationService _dutyLogViolationService;

}