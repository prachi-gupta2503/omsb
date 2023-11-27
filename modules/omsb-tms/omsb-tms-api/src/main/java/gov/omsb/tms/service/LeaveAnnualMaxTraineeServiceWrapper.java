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
 * Provides a wrapper for {@link LeaveAnnualMaxTraineeService}.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveAnnualMaxTraineeService
 * @generated
 */
public class LeaveAnnualMaxTraineeServiceWrapper
	implements LeaveAnnualMaxTraineeService,
			   ServiceWrapper<LeaveAnnualMaxTraineeService> {

	public LeaveAnnualMaxTraineeServiceWrapper() {
		this(null);
	}

	public LeaveAnnualMaxTraineeServiceWrapper(
		LeaveAnnualMaxTraineeService leaveAnnualMaxTraineeService) {

		_leaveAnnualMaxTraineeService = leaveAnnualMaxTraineeService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _leaveAnnualMaxTraineeService.getOSGiServiceIdentifier();
	}

	@Override
	public LeaveAnnualMaxTraineeService getWrappedService() {
		return _leaveAnnualMaxTraineeService;
	}

	@Override
	public void setWrappedService(
		LeaveAnnualMaxTraineeService leaveAnnualMaxTraineeService) {

		_leaveAnnualMaxTraineeService = leaveAnnualMaxTraineeService;
	}

	private LeaveAnnualMaxTraineeService _leaveAnnualMaxTraineeService;

}