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
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import gov.omsb.tms.custom.dto.UserDTO;
import gov.omsb.tms.exception.NoSuchProgramDutyAssignmentException;
import gov.omsb.tms.model.DutyLog;
import gov.omsb.tms.model.ProgramDutyAssignment;
import gov.omsb.tms.model.TraineeCohortDetails;
import gov.omsb.tms.service.DutyLogLocalServiceUtil;
import gov.omsb.tms.service.TraineeCohortDetailsLocalServiceUtil;
import gov.omsb.tms.service.base.ProgramDutyAssignmentLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=gov.omsb.tms.model.ProgramDutyAssignment", service = AopService.class)
public class ProgramDutyAssignmentLocalServiceImpl extends ProgramDutyAssignmentLocalServiceBaseImpl {
	private static final Log LOGGER = LogFactoryUtil.getLog(ProgramDutyAssignmentLocalServiceImpl.class.getName());
	
	public ProgramDutyAssignment addProgramDutyAssignment(long programId, long dutyAssignmentId, long cohortId,
			ServiceContext serviceContext) throws PortalException {
		// Get Group(Site) and User Information
		long groupId = serviceContext.getScopeGroupId();
		long createdBy = serviceContext.getUserId();
		long programDutyAssignmentId = counterLocalService.increment(ProgramDutyAssignment.class.getName());
		// Using The Generated Key To Create A New DutyType Entity
		ProgramDutyAssignment programDutyAssignment = createProgramDutyAssignment(programDutyAssignmentId);
		programDutyAssignment.setProgramId(programId);
		programDutyAssignment.setDutyAssignmentId(dutyAssignmentId);
		programDutyAssignment.setCohortId(cohortId);
		programDutyAssignment.setCreateDate(serviceContext.getCreateDate(new Date()));
		programDutyAssignment.setModifiedDate(serviceContext.getCreateDate(new Date()));
		programDutyAssignment.setGroupId(groupId);
		programDutyAssignment.setModifiedBy(createdBy);
		programDutyAssignment.setStatus("Active");
		programDutyAssignment = super.addProgramDutyAssignment(programDutyAssignment);
		return programDutyAssignment;
	}
	public List<ProgramDutyAssignment> getProgramDutyAssignmentList() {
		return super.getProgramDutyAssignments(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}
	public ProgramDutyAssignment editProgramDutyAssignment(long programDutyAssignmentId, String status) throws PortalException {
		ProgramDutyAssignment programDutyAssignment = getProgramDutyAssignment(programDutyAssignmentId);
		if(programDutyAssignment!=null) {
		programDutyAssignment.setStatus(status);
		programDutyAssignment = super.updateProgramDutyAssignment(programDutyAssignment);
		}
		return programDutyAssignment;
	}
	public String findDutyTypeAssignmentStatus(long dutyAssignmentId) {
		List<ProgramDutyAssignment> list = programDutyAssignmentPersistence.findByDutyAssignmentIdAndStatus(dutyAssignmentId,"Active");
		JSONObject jsonObject=null;
		if (list.size()> 0) {
			jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("status", "409");
		}else if(list.size()== 0) {
			jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("status", "200");
		}
		return jsonObject.toString();
	}
	public String findProgramDutyAssignment(long programId, long cohortId, long dutyAssignmentId) {
		ProgramDutyAssignment programDutyAssignment =null;
		JSONObject jsonObject =null;
		try {
			 programDutyAssignment = programDutyAssignmentPersistence.findByProgramIdDutyAssignmentIdCohortId(programId, dutyAssignmentId, cohortId);
			 if(programDutyAssignment.getStatus().equalsIgnoreCase("Active")) {
				 jsonObject = JSONFactoryUtil.createJSONObject();
				 jsonObject.put("status", "409");
			 }else {
				
				 programDutyAssignment.setStatus("Active");
				 super.updateProgramDutyAssignment(programDutyAssignment);
				 jsonObject = JSONFactoryUtil.createJSONObject();
				 jsonObject.put("status", "Edit");
			 }
			
		}catch (NoSuchProgramDutyAssignmentException e) {
			LOGGER.error("Error ::::>"+e.getMessage());
			 jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("status", "200");
			
		}
		return jsonObject.toString();
	}
	
	public List<TraineeCohortDetails> getByProgramId(long programId) {
		List<TraineeCohortDetails> list = new ArrayList<>();
		List<ProgramDutyAssignment> programDutyAssignments = programDutyAssignmentPersistence
				.findByProgramId(programId);
		LOGGER.info("programDutyAssignments====> :"+programDutyAssignments);
		for (ProgramDutyAssignment programDutyAssignment : programDutyAssignments) {
			try {
				LOGGER.info("programDutyAssignment====> :"+programDutyAssignment);
				LOGGER.info("programDutyAssignment.getCohortId====> :"+programDutyAssignment.getCohortId());
				
				TraineeCohortDetails traineeCohortDetails = TraineeCohortDetailsLocalServiceUtil
						.getTraineeCohortDetails(programDutyAssignment.getCohortId());
				if (!list.contains(traineeCohortDetails)) {
					list.add(traineeCohortDetails);
				}
			} catch (PortalException e) {

				e.printStackTrace();
			}
		}
		LOGGER.info("Cohort List====> :"+list);
		return list;
	}

	public List<UserDTO> getByProgramIdAndCohortId(long programId, long cohortId) {
		List<UserDTO> userList = new ArrayList<>();
		List<ProgramDutyAssignment> programDutyAssignments = programDutyAssignmentPersistence
				.findByProgramIdAndCohortId(programId, cohortId);
		LOGGER.info("programDutyAssignments====> :"+programDutyAssignments);
		for (ProgramDutyAssignment programDutyAssignment : programDutyAssignments) {
			LOGGER.info("programDutyAssignment.getProgramDutyAssignmentId()====> :"+programDutyAssignment.getProgramDutyAssignmentId());
			List<DutyLog> dutyLoglist = DutyLogLocalServiceUtil
					.getByProgramDutyAssignmentId(programDutyAssignment.getProgramDutyAssignmentId());
			LOGGER.info("dutyLoglist====> :"+dutyLoglist);
			for (DutyLog dutyLog : dutyLoglist) {
				User user = null;
				UserDTO userDTO=new UserDTO();
				try {
					user = UserLocalServiceUtil.getUser(dutyLog.getTraineeId());
					userDTO.setUserId(user.getUserId());
					userDTO.setUserFullName(user.getFullName());
					if(!isUserAvailable(user, userList)) {
					userList.add(userDTO);
					}
					LOGGER.info("user====> :"+user);
				} catch (PortalException e) {
					e.printStackTrace();
				}
				
			}

		}
		return userList;
	}
	
	public boolean isUserAvailable(User user,List<UserDTO> userList ) {
		for (UserDTO userDTO : userList) {
			if (userDTO.getUserId()==user.getUserId()) {
				return true;
			}
		}

		return false;

	}
}