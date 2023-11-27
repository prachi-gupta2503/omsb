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
 * Provides a wrapper for {@link RoleTypeMasterService}.
 *
 * @author Brian Wing Shun Chan
 * @see RoleTypeMasterService
 * @generated
 */
public class RoleTypeMasterServiceWrapper
	implements RoleTypeMasterService, ServiceWrapper<RoleTypeMasterService> {

	public RoleTypeMasterServiceWrapper() {
		this(null);
	}

	public RoleTypeMasterServiceWrapper(
		RoleTypeMasterService roleTypeMasterService) {

		_roleTypeMasterService = roleTypeMasterService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _roleTypeMasterService.getOSGiServiceIdentifier();
	}

	@Override
	public RoleTypeMasterService getWrappedService() {
		return _roleTypeMasterService;
	}

	@Override
	public void setWrappedService(RoleTypeMasterService roleTypeMasterService) {
		_roleTypeMasterService = roleTypeMasterService;
	}

	private RoleTypeMasterService _roleTypeMasterService;

}