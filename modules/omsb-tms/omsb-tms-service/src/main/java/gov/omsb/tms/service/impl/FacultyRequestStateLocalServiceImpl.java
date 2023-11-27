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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import gov.omsb.tms.model.FacultyRequestState;
import gov.omsb.tms.service.base.FacultyRequestStateLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=gov.omsb.tms.model.FacultyRequestState", service = AopService.class)
public class FacultyRequestStateLocalServiceImpl extends FacultyRequestStateLocalServiceBaseImpl {

	public List<FacultyRequestState> findByFacultyRequestId(long facultyRequestId) {
		return this.facultyRequestStatePersistence.findByfacultyRequestId(facultyRequestId);
	}
	public FacultyRequestState addFacultyRequestState(String comment, long facultyRequestId, long facultyRequestStatusId, long userId, long roleId, boolean isPublic) {
		_logger.info("add faculty request state method");
		long facultyRequestStateId = counterLocalService.increment(FacultyRequestState.class.getName());
		FacultyRequestState facultyRequestState = createFacultyRequestState(facultyRequestStateId);
		facultyRequestState.setFacultyRequestStateId(facultyRequestStateId);
	//	facultyRequestState.setGroupId(groupId);
		facultyRequestState.setCreatedBy(userId);
		facultyRequestState.setCreateDate(new Date());
		facultyRequestState.setFacultyRequestId(facultyRequestId);
		facultyRequestState.setFacultyRequestStatusId(facultyRequestStatusId);
		facultyRequestState.setComments(comment);
		facultyRequestState = super.addFacultyRequestState(facultyRequestState);
		_logger.info("added faculty request state "+facultyRequestState);
		return facultyRequestState;
	}
		
	public FacultyRequestState findByRequestIdAndCreatedBy(long facultyRequestId,long createdBy) {
		List<FacultyRequestState> list = facultyRequestStatePersistence.findByfacultyRequestIdAndCreatedBy(facultyRequestId, createdBy);
		_logger.info(list);
		FacultyRequestState facultyRequestState = list.get(list.size()-1);
		_logger.info("------------->    "+facultyRequestState);
		return facultyRequestState;
	}
	
	
	private static final Log _logger = LogFactoryUtil.getLog(FacultyRequestStateLocalServiceImpl.class.getName());

}