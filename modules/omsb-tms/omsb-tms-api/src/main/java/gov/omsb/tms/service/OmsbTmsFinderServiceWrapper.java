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
 * Provides a wrapper for {@link OmsbTmsFinderService}.
 *
 * @author Brian Wing Shun Chan
 * @see OmsbTmsFinderService
 * @generated
 */
public class OmsbTmsFinderServiceWrapper
	implements OmsbTmsFinderService, ServiceWrapper<OmsbTmsFinderService> {

	public OmsbTmsFinderServiceWrapper() {
		this(null);
	}

	public OmsbTmsFinderServiceWrapper(
		OmsbTmsFinderService omsbTmsFinderService) {

		_omsbTmsFinderService = omsbTmsFinderService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _omsbTmsFinderService.getOSGiServiceIdentifier();
	}

	@Override
	public OmsbTmsFinderService getWrappedService() {
		return _omsbTmsFinderService;
	}

	@Override
	public void setWrappedService(OmsbTmsFinderService omsbTmsFinderService) {
		_omsbTmsFinderService = omsbTmsFinderService;
	}

	private OmsbTmsFinderService _omsbTmsFinderService;

}