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
 * Provides a wrapper for {@link LeaveMasterService}.
 *
 * @author Brian Wing Shun Chan
 * @see LeaveMasterService
 * @generated
 */
public class LeaveMasterServiceWrapper
	implements LeaveMasterService, ServiceWrapper<LeaveMasterService> {

	public LeaveMasterServiceWrapper() {
		this(null);
	}

	public LeaveMasterServiceWrapper(LeaveMasterService leaveMasterService) {
		_leaveMasterService = leaveMasterService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _leaveMasterService.getOSGiServiceIdentifier();
	}

	@Override
	public LeaveMasterService getWrappedService() {
		return _leaveMasterService;
	}

	@Override
	public void setWrappedService(LeaveMasterService leaveMasterService) {
		_leaveMasterService = leaveMasterService;
	}

	private LeaveMasterService _leaveMasterService;

}