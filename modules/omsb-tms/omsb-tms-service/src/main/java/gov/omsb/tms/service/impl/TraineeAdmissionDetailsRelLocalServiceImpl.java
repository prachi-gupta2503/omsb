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
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import gov.omsb.tms.exception.NoSuchTraineeAdmissionDetailsRelException;
import gov.omsb.tms.model.TraineeAdmissionDetailsRel;
import gov.omsb.tms.service.TraineeAdmissionDetailsRelLocalServiceUtil;
import gov.omsb.tms.service.base.TraineeAdmissionDetailsRelLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=gov.omsb.tms.model.TraineeAdmissionDetailsRel", service = AopService.class)
public class TraineeAdmissionDetailsRelLocalServiceImpl extends TraineeAdmissionDetailsRelLocalServiceBaseImpl {

	public List<TraineeAdmissionDetailsRel> findByProgramDurationId(long programDurationId) {
		return traineeAdmissionDetailsRelPersistence.findByProgramDurationId(programDurationId);
	}

	public List<TraineeAdmissionDetailsRel> findByTraineeAdmissionDetailsRelIds(
			List<Long> traineeAdmissionDetailsRelIds) {
		List<TraineeAdmissionDetailsRel> traineeAdmissionDetailsRelList = new ArrayList<>();
		try {
			DynamicQuery savedSearch = TraineeAdmissionDetailsRelLocalServiceUtil.dynamicQuery();
			savedSearch.add(RestrictionsFactoryUtil.in("traineeAdmissionDetailsRelId", traineeAdmissionDetailsRelIds));

			traineeAdmissionDetailsRelList = TraineeAdmissionDetailsRelLocalServiceUtil.dynamicQuery(savedSearch);
		} catch (Exception e) {
			_logger.info("findByTraineeAdmissionDetailsRelIds ::: " + e);
		}
		return traineeAdmissionDetailsRelList;
	}

	public TraineeAdmissionDetailsRel findByTraineeId(long traineeId) {
		try {
			return traineeAdmissionDetailsRelPersistence.findByTraineeId(traineeId);
		} catch (NoSuchTraineeAdmissionDetailsRelException e) {
			_logger.error(e);
			return null;
		}
	}
	
	public List<Long> getTraineeByProgramCohortAndTraineeLevel(long programDurationId,long traineeLevelId) {
		return omsbTmsFinderFinder.getTraineeByProgramCohortAndTraineeLevel(programDurationId,traineeLevelId);
	}

	private static final Log _logger = LogFactoryUtil
			.getLog(TraineeAdmissionDetailsRelLocalServiceImpl.class.getName());
}