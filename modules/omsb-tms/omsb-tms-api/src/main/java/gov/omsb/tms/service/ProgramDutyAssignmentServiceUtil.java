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

import com.liferay.portal.kernel.exception.PortalException;

import gov.omsb.tms.model.ProgramDutyAssignment;

import java.util.List;

/**
 * Provides the remote service utility for ProgramDutyAssignment. This utility wraps
 * <code>gov.omsb.tms.service.impl.ProgramDutyAssignmentServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see ProgramDutyAssignmentService
 * @generated
 */
public class ProgramDutyAssignmentServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.ProgramDutyAssignmentServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static ProgramDutyAssignment deleteProgramDutyAssignment(
			long programDutyAssignmentId)
		throws PortalException {

		return getService().deleteProgramDutyAssignment(
			programDutyAssignmentId);
	}

	public static String findDutyTypeAssignmentStatus(long dutyAssignmentId) {
		return getService().findDutyTypeAssignmentStatus(dutyAssignmentId);
	}

	public static String findProgramDutyAssignment(
		long programId, long cohortId, long dutyAssignmentId) {

		return getService().findProgramDutyAssignment(
			programId, cohortId, dutyAssignmentId);
	}

	public static List<gov.omsb.tms.model.TraineeCohortDetails> getByProgramId(
		long programId) {

		return getService().getByProgramId(programId);
	}

	public static List<gov.omsb.tms.custom.dto.UserDTO>
		getByProgramIdAndCohortId(long programId, long cohortId) {

		return getService().getByProgramIdAndCohortId(programId, cohortId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static ProgramDutyAssignmentService getService() {
		return _service;
	}

	private static volatile ProgramDutyAssignmentService _service;

}