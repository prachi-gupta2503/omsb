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

package gov.omsb.tms.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

import gov.omsb.tms.model.DutyAssignment;
import gov.omsb.tms.service.base.DutyAssignmentServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = { "json.web.service.context.name=omsbtms",
		"json.web.service.context.path=DutyAssignment" }, service = AopService.class)
public class DutyAssignmentServiceImpl extends DutyAssignmentServiceBaseImpl {
	private Log LOGGER = LogFactoryUtil.getLog(DutyAssignmentServiceImpl.class.getName());

	public String fetchDutyTypeAssignmentStatus(long dutyTypeId, String assignment, long dutyAssignmentId) {
		return dutyAssignmentLocalService.fetchDutyTypeAssignmentStatus(dutyTypeId, assignment,dutyAssignmentId);
	}
	public String getDutyAssignmentsByDutyTypeId(long dutyTypeId) {
		return dutyAssignmentLocalService.getAssignmentListByDutyTypeId(dutyTypeId);
	}
	public String findDutyTypeStatus(long dutyTypeId) {
		return dutyAssignmentLocalService.findDutyTypeStatus(dutyTypeId);
	}
}
