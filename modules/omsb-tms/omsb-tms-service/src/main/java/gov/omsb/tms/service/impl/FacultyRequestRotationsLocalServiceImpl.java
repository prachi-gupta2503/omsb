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

import org.osgi.service.component.annotations.Component;

import gov.omsb.tms.exception.NoSuchFacultyRequestRotationsException;
import gov.omsb.tms.model.FacultyRequestRotations;
import gov.omsb.tms.model.FacultyRequestState;
import gov.omsb.tms.service.base.FacultyRequestRotationsLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=gov.omsb.tms.model.FacultyRequestRotations", service = AopService.class)
public class FacultyRequestRotationsLocalServiceImpl extends FacultyRequestRotationsLocalServiceBaseImpl {

	public FacultyRequestRotations addFacultyRequestRotations(long groupId, long userId, long facultyRequestId,
			long trainingSiteId, boolean isActive) {
		_logger.info("add faculty request rotations method");
		long facultyRequestRotationId = counterLocalService.increment(FacultyRequestRotations.class.getName());
		FacultyRequestRotations facultyRequestRotation = createFacultyRequestRotations(facultyRequestRotationId);
		facultyRequestRotation.setFacultyRequestRotationsId(facultyRequestRotationId);
		facultyRequestRotation.setGroupId(groupId);
		facultyRequestRotation.setCreatedBy(userId);
		facultyRequestRotation.setCreateDate(new Date());
		facultyRequestRotation.setFacultyRequestId(facultyRequestId);
		facultyRequestRotation.setTrainingSiteId(trainingSiteId);
		facultyRequestRotation.setIsActive(isActive);
		facultyRequestRotation = super.addFacultyRequestRotations(facultyRequestRotation);
		_logger.info("added faculty request rotation " + facultyRequestRotation);
		return facultyRequestRotation;
	}

	public FacultyRequestRotations findByFacultyRequestIdAndIsActive(long facultyRequestId, boolean isActive) {
		FacultyRequestRotations facultyRequestRotations = null;
		try {
			facultyRequestRotations = this.facultyRequestRotationsPersistence
					.findByfacultyRequestIdAndIsActive(facultyRequestId, isActive);
		} catch (NoSuchFacultyRequestRotationsException e) {
			_logger.error(e);
		}
		return facultyRequestRotations;
	}

	private static final Log _logger = LogFactoryUtil.getLog(FacultyRequestRotationsLocalServiceImpl.class.getName());

}