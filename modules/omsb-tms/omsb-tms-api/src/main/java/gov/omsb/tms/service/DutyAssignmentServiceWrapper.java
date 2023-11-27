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
 * Provides a wrapper for {@link DutyAssignmentService}.
 *
 * @author Brian Wing Shun Chan
 * @see DutyAssignmentService
 * @generated
 */
public class DutyAssignmentServiceWrapper
	implements DutyAssignmentService, ServiceWrapper<DutyAssignmentService> {

	public DutyAssignmentServiceWrapper() {
		this(null);
	}

	public DutyAssignmentServiceWrapper(
		DutyAssignmentService dutyAssignmentService) {

		_dutyAssignmentService = dutyAssignmentService;
	}

	@Override
	public String fetchDutyTypeAssignmentStatus(
		long dutyTypeId, String assignment, long dutyAssignmentId) {

		return _dutyAssignmentService.fetchDutyTypeAssignmentStatus(
			dutyTypeId, assignment, dutyAssignmentId);
	}

	@Override
	public String findDutyTypeStatus(long dutyTypeId) {
		return _dutyAssignmentService.findDutyTypeStatus(dutyTypeId);
	}

	@Override
	public String getDutyAssignmentsByDutyTypeId(long dutyTypeId) {
		return _dutyAssignmentService.getDutyAssignmentsByDutyTypeId(
			dutyTypeId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dutyAssignmentService.getOSGiServiceIdentifier();
	}

	@Override
	public DutyAssignmentService getWrappedService() {
		return _dutyAssignmentService;
	}

	@Override
	public void setWrappedService(DutyAssignmentService dutyAssignmentService) {
		_dutyAssignmentService = dutyAssignmentService;
	}

	private DutyAssignmentService _dutyAssignmentService;

}