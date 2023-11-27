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

import gov.omsb.tms.exception.NoSuchTraineeCohortDetailsException;
import gov.omsb.tms.model.TraineeCohortDetails;
import gov.omsb.tms.service.base.TraineeCohortDetailsLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=gov.omsb.tms.model.TraineeCohortDetails",
	service = AopService.class
)
public class TraineeCohortDetailsLocalServiceImpl
	extends TraineeCohortDetailsLocalServiceBaseImpl {
	
	private static final Log _logger = LogFactoryUtil.getLog(TraineeCohortDetailsLocalServiceImpl.class);
	
	public List<TraineeCohortDetails> findByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId(long traineeAdmissionDetailsRelId, String cohortYear, long traineeLevelId) {
		return traineeCohortDetailsPersistence.findByTraineeAdmissionDetailsRelIdAndCohortYearAndTraineeLevelId(traineeAdmissionDetailsRelId, cohortYear, traineeLevelId);	
	}
	
	public TraineeCohortDetails findByTraineeAdmissionDetailsRelIdAndIsCurrentTraineeLevel(long traineeAdmissionDetailsRelId) {
		TraineeCohortDetails traineeCohortDetails = null;
		try {
			traineeCohortDetails = traineeCohortDetailsPersistence.findByTraineeAdmissionDetailsRelIdAndIsCurrentTraineeLevel(traineeAdmissionDetailsRelId, true);
		} catch (NoSuchTraineeCohortDetailsException e) {
			_logger.error(e.getMessage());
		}
		return traineeCohortDetails; 	
	}
	public  List<TraineeCohortDetails> findByTraineeAdmissionDetailsRelId(long traineeAdmissionDetailsRelId) {
		
		try {
			return traineeCohortDetailsPersistence.findByTraineeAdmissionDetailsRelId(traineeAdmissionDetailsRelId);
		} catch (Exception e) {
			_logger.error(e.getMessage());
			return null;
		}
		
	}
}