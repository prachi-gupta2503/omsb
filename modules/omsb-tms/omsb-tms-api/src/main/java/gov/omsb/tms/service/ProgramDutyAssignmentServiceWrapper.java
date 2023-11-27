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
 * Provides a wrapper for {@link ProgramDutyAssignmentService}.
 *
 * @author Brian Wing Shun Chan
 * @see ProgramDutyAssignmentService
 * @generated
 */
public class ProgramDutyAssignmentServiceWrapper
	implements ProgramDutyAssignmentService,
			   ServiceWrapper<ProgramDutyAssignmentService> {

	public ProgramDutyAssignmentServiceWrapper() {
		this(null);
	}

	public ProgramDutyAssignmentServiceWrapper(
		ProgramDutyAssignmentService programDutyAssignmentService) {

		_programDutyAssignmentService = programDutyAssignmentService;
	}

	@Override
	public gov.omsb.tms.model.ProgramDutyAssignment deleteProgramDutyAssignment(
			long programDutyAssignmentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _programDutyAssignmentService.deleteProgramDutyAssignment(
			programDutyAssignmentId);
	}

	@Override
	public String findDutyTypeAssignmentStatus(long dutyAssignmentId) {
		return _programDutyAssignmentService.findDutyTypeAssignmentStatus(
			dutyAssignmentId);
	}

	@Override
	public String findProgramDutyAssignment(
		long programId, long cohortId, long dutyAssignmentId) {

		return _programDutyAssignmentService.findProgramDutyAssignment(
			programId, cohortId, dutyAssignmentId);
	}

	@Override
	public java.util.List<gov.omsb.tms.model.TraineeCohortDetails>
		getByProgramId(long programId) {

		return _programDutyAssignmentService.getByProgramId(programId);
	}

	@Override
	public java.util.List<gov.omsb.tms.custom.dto.UserDTO>
		getByProgramIdAndCohortId(long programId, long cohortId) {

		return _programDutyAssignmentService.getByProgramIdAndCohortId(
			programId, cohortId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _programDutyAssignmentService.getOSGiServiceIdentifier();
	}

	@Override
	public ProgramDutyAssignmentService getWrappedService() {
		return _programDutyAssignmentService;
	}

	@Override
	public void setWrappedService(
		ProgramDutyAssignmentService programDutyAssignmentService) {

		_programDutyAssignmentService = programDutyAssignmentService;
	}

	private ProgramDutyAssignmentService _programDutyAssignmentService;

}