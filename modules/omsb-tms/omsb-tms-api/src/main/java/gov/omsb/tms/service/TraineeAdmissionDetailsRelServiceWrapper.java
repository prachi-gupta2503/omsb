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
 * Provides a wrapper for {@link TraineeAdmissionDetailsRelService}.
 *
 * @author Brian Wing Shun Chan
 * @see TraineeAdmissionDetailsRelService
 * @generated
 */
public class TraineeAdmissionDetailsRelServiceWrapper
	implements ServiceWrapper<TraineeAdmissionDetailsRelService>,
			   TraineeAdmissionDetailsRelService {

	public TraineeAdmissionDetailsRelServiceWrapper() {
		this(null);
	}

	public TraineeAdmissionDetailsRelServiceWrapper(
		TraineeAdmissionDetailsRelService traineeAdmissionDetailsRelService) {

		_traineeAdmissionDetailsRelService = traineeAdmissionDetailsRelService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _traineeAdmissionDetailsRelService.getOSGiServiceIdentifier();
	}

	@Override
	public TraineeAdmissionDetailsRelService getWrappedService() {
		return _traineeAdmissionDetailsRelService;
	}

	@Override
	public void setWrappedService(
		TraineeAdmissionDetailsRelService traineeAdmissionDetailsRelService) {

		_traineeAdmissionDetailsRelService = traineeAdmissionDetailsRelService;
	}

	private TraineeAdmissionDetailsRelService
		_traineeAdmissionDetailsRelService;

}