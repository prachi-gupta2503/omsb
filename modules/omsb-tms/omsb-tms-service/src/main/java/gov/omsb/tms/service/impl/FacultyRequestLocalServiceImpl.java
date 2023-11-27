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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import gov.omsb.tms.custom.dto.FacultyRequestDTO;
import gov.omsb.tms.model.FacultyRequest;
import gov.omsb.tms.service.FacultyRequestLocalServiceUtil;
import gov.omsb.tms.service.base.FacultyRequestLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=gov.omsb.tms.model.FacultyRequest", service = AopService.class)
public class FacultyRequestLocalServiceImpl extends FacultyRequestLocalServiceBaseImpl {

	private static final Log LOGGER = LogFactoryUtil.getLog(FacultyRequestLocalServiceImpl.class.getName());

	public FacultyRequest addFacultyRequest(long groupId, long userId, long programId, long cvId)
			throws PortalException {
		LOGGER.info("add faculty request method");
		long facultyRequestId = counterLocalService.increment(FacultyRequest.class.getName());
		FacultyRequest facultyRequest = createFacultyRequest(facultyRequestId);
		facultyRequest.setFacultyRequestId(facultyRequestId);
		// set the faculty aduit field
		facultyRequest.setGroupId(groupId);
		facultyRequest.setCreatedBy(userId);
		facultyRequest.setCreateDate(new Date());
		// set field and save faculty request
		facultyRequest.setProgramId(programId);
		facultyRequest.setPotentialFacultyId(userId);
		facultyRequest.setCvId(cvId);
		facultyRequest = super.addFacultyRequest(facultyRequest);
		LOGGER.info("added faculty request " + facultyRequest);
		return facultyRequest;
	}

	public FacultyRequest updateLastestFacultyState(FacultyRequest facultyRequest, long lastestFacultyRequestStateId) {
		facultyRequest.setLastestFacultyRequestStateId(lastestFacultyRequestStateId);
		return facultyRequestLocalService.updateFacultyRequest(facultyRequest);
	}

	public List<FacultyRequest> getFacultyRequestList() {
		LOGGER.info("faculty request list");
		return super.getFacultyRequests(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}

	public FacultyRequest editFacultyRequest(long userId, long facultyRequestId, long potentialFacultyTypeId,
			long coveringLetterId) throws PortalException {
		LOGGER.info("edit faculty request method called ");
		FacultyRequest facultyRequest = getFacultyRequest(facultyRequestId);
		if (facultyRequest != null) {
			facultyRequest.setModifiedBy(userId);
			facultyRequest.setModifiedDate(new Date());
			facultyRequest.setPotentialFacultyTypeId(potentialFacultyTypeId);
			facultyRequest.setCoveringLetterId(coveringLetterId);
			facultyRequest = super.updateFacultyRequest(facultyRequest);
			LOGGER.info("edited faculty request " + facultyRequest);
		}
		return facultyRequest;
	}

	public List<FacultyRequestDTO> getFacultyRequestData(String languageCode) {
		return omsbTmsFinderFinder.getFacultyRequestData(languageCode);
	}

	public List<FacultyRequestDTO> getFacultyRequestDataBySearch(long programId, long facultyTypeId,
			long facultyRequestStatusId, String languageCode) {
		return omsbTmsFinderFinder.getFacultyRequestDataBySearch(programId, facultyTypeId, facultyRequestStatusId,
				languageCode);
	}

	public List<FacultyRequestDTO> getMyFacultyRequests(long potentialFacultyId, String languageCode) {
		List<FacultyRequestDTO> list = omsbTmsFinderFinder.getFacultyRequestDataByUserId(potentialFacultyId,
				languageCode);
		LOGGER.info(" faculty request " + potentialFacultyId + languageCode + list);
		return list;
	}

	public User getPotentialFacultyUser(long requestId) {
		LOGGER.info("*********************requestId > " + requestId);

		try {
			FacultyRequest request = FacultyRequestLocalServiceUtil.getFacultyRequest(requestId);
			// FacultyRequest request = getFacultyRequest(requestId);
			User user = UserLocalServiceUtil.getUser(request.getPotentialFacultyId());
			LOGGER.info("====================user=====================" + user);
			return UserLocalServiceUtil.getUser(request.getPotentialFacultyId());
		} catch (PortalException e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public FacultyRequest updateRequest(FacultyRequest facultyRequest) {
		LOGGER.info("updateRequest");
		try {
			facultyRequest = updateFacultyRequest(facultyRequest);
			facultyRequest = getFacultyRequest(facultyRequest.getFacultyRequestId());
		} catch (PortalException e) {
			LOGGER.error(e.getMessage());
		}
		return facultyRequest;

	}

	public FacultyRequest updateStatus(long userId, long facultyRequestId, int status, ServiceContext serviceContext)
			throws PortalException {
		LOGGER.info("updateStatus 2");
		User user = userLocalService.getUser(userId);
		FacultyRequest facultyRequest = facultyRequestLocalService.getFacultyRequest(facultyRequestId);

		facultyRequest.setStatus(status);
		facultyRequest.setStatusByUserId(userId);
		facultyRequest.setStatusByUserName(user.getFullName());
		facultyRequest.setStatusDate(new Date());
		updateFacultyRequest(facultyRequest);
		
		if (status == WorkflowConstants.STATUS_APPROVED) {
			assetEntryLocalService.updateVisible(FacultyRequest.class.getName(), facultyRequestId, true);
		} else {
			assetEntryLocalService.updateVisible(FacultyRequest.class.getName(), facultyRequestId, true);
		}

		return facultyRequest;

	}

}