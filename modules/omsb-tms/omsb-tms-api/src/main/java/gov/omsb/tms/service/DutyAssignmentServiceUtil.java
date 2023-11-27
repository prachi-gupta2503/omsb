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

/**
 * Provides the remote service utility for DutyAssignment. This utility wraps
 * <code>gov.omsb.tms.service.impl.DutyAssignmentServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see DutyAssignmentService
 * @generated
 */
public class DutyAssignmentServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>gov.omsb.tms.service.impl.DutyAssignmentServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static java.lang.String fetchDutyTypeAssignmentStatus(
		long dutyTypeId, java.lang.String assignment, long dutyAssignmentId) {

		return getService().fetchDutyTypeAssignmentStatus(
			dutyTypeId, assignment, dutyAssignmentId);
	}

	public static java.lang.String findDutyTypeStatus(long dutyTypeId) {
		return getService().findDutyTypeStatus(dutyTypeId);
	}

	public static java.lang.String getDutyAssignmentsByDutyTypeId(
		long dutyTypeId) {

		return getService().getDutyAssignmentsByDutyTypeId(dutyTypeId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static DutyAssignmentService getService() {
		return _service;
	}

	private static volatile DutyAssignmentService _service;

}