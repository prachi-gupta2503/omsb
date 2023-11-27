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
 * Provides a wrapper for {@link DutyLogService}.
 *
 * @author Brian Wing Shun Chan
 * @see DutyLogService
 * @generated
 */
public class DutyLogServiceWrapper
	implements DutyLogService, ServiceWrapper<DutyLogService> {

	public DutyLogServiceWrapper() {
		this(null);
	}

	public DutyLogServiceWrapper(DutyLogService dutyLogService) {
		_dutyLogService = dutyLogService;
	}

	@Override
	public java.util.List<gov.omsb.tms.custom.dto.TraineeLevelListDTO>
		getByTranieeIdAndProgramDutyAssignmentId(
			long traineeId, long programId, long cohortId,
			String languageCode) {

		return _dutyLogService.getByTranieeIdAndProgramDutyAssignmentId(
			traineeId, programId, cohortId, languageCode);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _dutyLogService.getOSGiServiceIdentifier();
	}

	@Override
	public DutyLogService getWrappedService() {
		return _dutyLogService;
	}

	@Override
	public void setWrappedService(DutyLogService dutyLogService) {
		_dutyLogService = dutyLogService;
	}

	private DutyLogService _dutyLogService;

}