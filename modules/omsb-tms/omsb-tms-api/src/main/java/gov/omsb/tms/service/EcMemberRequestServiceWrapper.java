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
 * Provides a wrapper for {@link EcMemberRequestService}.
 *
 * @author Brian Wing Shun Chan
 * @see EcMemberRequestService
 * @generated
 */
public class EcMemberRequestServiceWrapper
	implements EcMemberRequestService, ServiceWrapper<EcMemberRequestService> {

	public EcMemberRequestServiceWrapper() {
		this(null);
	}

	public EcMemberRequestServiceWrapper(
		EcMemberRequestService ecMemberRequestService) {

		_ecMemberRequestService = ecMemberRequestService;
	}

	@Override
	public void deleteAllRequests() {
		_ecMemberRequestService.deleteAllRequests();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _ecMemberRequestService.getOSGiServiceIdentifier();
	}

	@Override
	public EcMemberRequestService getWrappedService() {
		return _ecMemberRequestService;
	}

	@Override
	public void setWrappedService(
		EcMemberRequestService ecMemberRequestService) {

		_ecMemberRequestService = ecMemberRequestService;
	}

	private EcMemberRequestService _ecMemberRequestService;

}