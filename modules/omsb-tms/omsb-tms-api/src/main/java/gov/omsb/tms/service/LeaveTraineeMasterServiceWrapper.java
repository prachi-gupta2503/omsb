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
 * Provides a wrapper for {@link LeaveTraineeMasterService}.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveTraineeMasterService
 * @generated
 */
public class LeaveTraineeMasterServiceWrapper
	implements LeaveTraineeMasterService,
			   ServiceWrapper<LeaveTraineeMasterService> {

	public LeaveTraineeMasterServiceWrapper() {
		this(null);
	}

	public LeaveTraineeMasterServiceWrapper(
		LeaveTraineeMasterService leaveTraineeMasterService) {

		_leaveTraineeMasterService = leaveTraineeMasterService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _leaveTraineeMasterService.getOSGiServiceIdentifier();
	}

	@Override
	public LeaveTraineeMasterService getWrappedService() {
		return _leaveTraineeMasterService;
	}

	@Override
	public void setWrappedService(
		LeaveTraineeMasterService leaveTraineeMasterService) {

		_leaveTraineeMasterService = leaveTraineeMasterService;
	}

	private LeaveTraineeMasterService _leaveTraineeMasterService;

}