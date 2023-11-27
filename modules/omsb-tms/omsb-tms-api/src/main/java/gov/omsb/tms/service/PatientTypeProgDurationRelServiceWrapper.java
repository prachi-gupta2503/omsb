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
 * Provides a wrapper for {@link PatientTypeProgDurationRelService}.
 *
 * @author Brian Wing Shun Chan
 * @see PatientTypeProgDurationRelService
 * @generated
 */
public class PatientTypeProgDurationRelServiceWrapper
	implements PatientTypeProgDurationRelService,
			   ServiceWrapper<PatientTypeProgDurationRelService> {

	public PatientTypeProgDurationRelServiceWrapper() {
		this(null);
	}

	public PatientTypeProgDurationRelServiceWrapper(
		PatientTypeProgDurationRelService patientTypeProgDurationRelService) {

		_patientTypeProgDurationRelService = patientTypeProgDurationRelService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _patientTypeProgDurationRelService.getOSGiServiceIdentifier();
	}

	@Override
	public PatientTypeProgDurationRelService getWrappedService() {
		return _patientTypeProgDurationRelService;
	}

	@Override
	public void setWrappedService(
		PatientTypeProgDurationRelService patientTypeProgDurationRelService) {

		_patientTypeProgDurationRelService = patientTypeProgDurationRelService;
	}

	private PatientTypeProgDurationRelService
		_patientTypeProgDurationRelService;

}