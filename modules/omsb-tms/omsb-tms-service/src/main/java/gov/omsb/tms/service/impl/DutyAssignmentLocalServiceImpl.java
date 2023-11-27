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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import gov.omsb.tms.model.DutyAssignment;
import gov.omsb.tms.service.base.DutyAssignmentLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=gov.omsb.tms.model.DutyAssignment", service = AopService.class)
public class DutyAssignmentLocalServiceImpl extends DutyAssignmentLocalServiceBaseImpl {
	private static final Log LOGGER = LogFactoryUtil.getLog(DutyAssignmentLocalServiceImpl.class.getName());

	//
	public List<DutyAssignment> findAssignmentByDutyTypeId(long dutyTypeId) {
		List<DutyAssignment> dutyAssignmentList = dutyAssignmentPersistence.findByDutyTypeId(dutyTypeId);
		List<DutyAssignment> assignmentList = new ArrayList<>();
		for (DutyAssignment dutyAssignment : dutyAssignmentList) {
			if (dutyAssignment.getStatus().equalsIgnoreCase("Active")) {
				assignmentList.add(dutyAssignment);
			}
		}
		return assignmentList;
	}

	public String fetchDutyTypeAssignmentStatus(long dutyTypeId, String assignment, long dutyAssignmentId) {
		List<DutyAssignment> dutyAssignmentList = dutyAssignmentPersistence.findByDutyTypeIdAndAssignment(dutyTypeId,
				assignment);
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		if (dutyAssignmentId == 0) {
			LOGGER.info("true--------------");
			fetchStatusForAdd(dutyAssignmentList, jsonObject);
		} else {
			LOGGER.info("true------09090--------");
			fetchStatusForUpdate(assignment, dutyAssignmentId, dutyAssignmentList, jsonObject);
		}
		return jsonObject.toString();
	}

	private void fetchStatusForUpdate(String assignment, long dutyAssignmentId,
			List<DutyAssignment> dutyAssignmentList, JSONObject jsonObject) {
		try {
			DutyAssignment dutyAssignment = getDutyAssignment(dutyAssignmentId);
			String status = ((dutyAssignment.getAssignment().equalsIgnoreCase(assignment)
					|| dutyAssignmentList.isEmpty()) ? "200" : "409");
			jsonObject.put("status", status);
		} catch (PortalException e) {
			LOGGER.error("Duty assignment is not found");
		}
	}

	private void fetchStatusForAdd(List<DutyAssignment> dutyAssignmentList, JSONObject jsonObject) {
	
			for (DutyAssignment dutyAssignment : dutyAssignmentList) {
				String status = ((!dutyAssignmentList.isEmpty() && dutyAssignment.getStatus().equalsIgnoreCase("Active")) ? "409":"200");
				jsonObject.put("status", status);	
			}
		
	}

	public String getAssignmentListByDutyTypeId(long dutyTypeId) {
		List<DutyAssignment> dutyAssignmentList = dutyAssignmentPersistence.findByDutyTypeId(dutyTypeId);
		JSONObject jsonObject = null;
		if (dutyAssignmentList.size() > 0) {
			jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("status", "409");
			jsonObject.put("error", "Cannot delete the entity because it is still referenced by another entity.*");
		} else if (dutyAssignmentList.size() == 0) {
			jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("status", "202");
			jsonObject.put("success", "Duty Type Deleted successfully");
		}
		return jsonObject.toString();
	}

	public String findDutyTypeStatus(long dutyTypeId) {
		List<DutyAssignment> dutyAssignmentList = dutyAssignmentPersistence.findByDutyTypeIdAndStatus(dutyTypeId,
				"Active");
		JSONObject jsonObject = null;
		if (dutyAssignmentList.size() > 0) {
			jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("status", "409");
		} else if (dutyAssignmentList.size() == 0) {
			jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("status", "202");
		}
		return jsonObject.toString();
	}

	public DutyAssignment deleteDutyAssignment(long dutyAssignmentId) {
		DutyAssignment dutyAssignment = null;
		try {
			dutyAssignment = getDutyAssignment(dutyAssignmentId);
			dutyAssignment.setStatus("Inactive");
			dutyAssignment = super.updateDutyAssignment(dutyAssignment);
		} catch (PortalException e) {
			LOGGER.error("Error message" + e.getMessage());
		}
		return dutyAssignment;
	}

	// get List by findByDutyTypeIdAndAssignment
	public List<DutyAssignment> findByDutyTypeIdAndAssignment(long dutyTypeId, String assignment) {
		return dutyAssignmentPersistence.findByDutyTypeIdAndAssignment(dutyTypeId, assignment);
	}

}