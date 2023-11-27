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
 * Provides a wrapper for {@link RoleTypeProgDurationRelService}.
 *
 * @author Brian Wing Shun Chan
 * @see RoleTypeProgDurationRelService
 * @generated
 */
public class RoleTypeProgDurationRelServiceWrapper
	implements RoleTypeProgDurationRelService,
			   ServiceWrapper<RoleTypeProgDurationRelService> {

	public RoleTypeProgDurationRelServiceWrapper() {
		this(null);
	}

	public RoleTypeProgDurationRelServiceWrapper(
		RoleTypeProgDurationRelService roleTypeProgDurationRelService) {

		_roleTypeProgDurationRelService = roleTypeProgDurationRelService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _roleTypeProgDurationRelService.getOSGiServiceIdentifier();
	}

	@Override
	public RoleTypeProgDurationRelService getWrappedService() {
		return _roleTypeProgDurationRelService;
	}

	@Override
	public void setWrappedService(
		RoleTypeProgDurationRelService roleTypeProgDurationRelService) {

		_roleTypeProgDurationRelService = roleTypeProgDurationRelService;
	}

	private RoleTypeProgDurationRelService _roleTypeProgDurationRelService;

}