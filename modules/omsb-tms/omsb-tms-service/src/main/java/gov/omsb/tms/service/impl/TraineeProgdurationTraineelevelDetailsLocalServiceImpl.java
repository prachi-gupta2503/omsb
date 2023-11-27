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

import java.util.List;

import org.osgi.service.component.annotations.Component;

import gov.omsb.tms.exception.NoSuchTraineeProgdurationTraineelevelDetailsException;
import gov.omsb.tms.model.TraineeProgdurationTraineelevelDetails;
import gov.omsb.tms.service.base.TraineeProgdurationTraineelevelDetailsLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=gov.omsb.tms.model.TraineeProgdurationTraineelevelDetails",
	service = AopService.class
)
public class TraineeProgdurationTraineelevelDetailsLocalServiceImpl
	extends TraineeProgdurationTraineelevelDetailsLocalServiceBaseImpl {
	
	public List<TraineeProgdurationTraineelevelDetails> findByTraineeId(long traineeId) {
		return this.traineeProgdurationTraineelevelDetailsPersistence.findByTraineeId(traineeId);
	}

	public List<TraineeProgdurationTraineelevelDetails> findByTraineeIdAndProgramDurationId(long traineeId, long programDurationId) {
		return this.traineeProgdurationTraineelevelDetailsPersistence.findByTraineeIdAndProgramDurationId(traineeId, programDurationId);
	}

	public TraineeProgdurationTraineelevelDetails findByTraineeIdAndTraineeLevelId(long traineeId, long traineeLevelId) {
		TraineeProgdurationTraineelevelDetails traineeProgdurationTraineelevelDetails = null;
		try {
			traineeProgdurationTraineelevelDetails = this.traineeProgdurationTraineelevelDetailsPersistence.findByTraineeIdAndTraineeLevelId(traineeId, traineeLevelId);
		} catch (NoSuchTraineeProgdurationTraineelevelDetailsException e) {
			_logger.error("No TraineeProgdurationTraineelevelDetails exsist with traineeId = " + traineeId + " and traineeLevelId = " 	+ traineeLevelId);
		}
		return traineeProgdurationTraineelevelDetails;
	}

	private static final Log _logger = LogFactoryUtil.getLog(TraineeProgdurationTraineelevelDetailsLocalServiceImpl.class);
}