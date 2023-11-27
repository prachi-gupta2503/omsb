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
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import gov.omsb.tms.custom.dto.ProgdurationRotationTrainingSiteDTO;
import gov.omsb.tms.custom.dto.TrainingSiteNameWithRotationDTO;
import gov.omsb.tms.custom.dto.TrainingSiteStructureDTO;
import gov.omsb.tms.model.TrainingSitesMaster;
import gov.omsb.tms.service.ProgramMasterLocalServiceUtil;
import gov.omsb.tms.service.TrainingSitesMasterLocalServiceUtil;
import gov.omsb.tms.service.base.TrainingSitesMasterLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=gov.omsb.tms.model.TrainingSitesMaster",
	service = AopService.class
)
public class TrainingSitesMasterLocalServiceImpl
	extends TrainingSitesMasterLocalServiceBaseImpl {
	
	public List<TrainingSitesMaster> findByProgramStatus(Boolean trainingSiteStatus) {
		return this.trainingSitesMasterPersistence.findByTrainingSiteStatus(trainingSiteStatus);
	}
	
	public List<TrainingSiteStructureDTO> getTrainingSiteStructure(List<Long> programMasterIds,String programDuration,long trainingSiteId, String languageCode) {
		return this.omsbTmsFinderFinder.getTrainingSiteStructure(programMasterIds,programDuration,trainingSiteId, languageCode);
	}
	
	public List<TrainingSitesMaster> findByTrainingSiteNameByLike(String trainingSiteName) {
		return this.trainingSitesMasterPersistence.findByTrainingSiteNameByLike(trainingSiteName);
	}

	public List<TrainingSitesMaster> findByTrainingSiteCodeByLike(String trainingSiteCode) {
		return this.trainingSitesMasterPersistence.findByTrainingSiteCodeByLike(trainingSiteCode);
	}
	
	public List<ProgdurationRotationTrainingSiteDTO> getProgdurationRotationByRotationAndDuration(long rotationId,String duration, String languageCode) {
		return this.omsbTmsFinderFinder.getProgdurationRotationByRotationAndDuration(rotationId,duration,languageCode);
	}
	
	public List<TrainingSiteNameWithRotationDTO> getTrainingSiteNameWithRotation(String languageCode, long programId) {
		return omsbTmsFinderFinder.getTrainingSiteNameWithRotation(languageCode,programId);
	}
	
	public List<TrainingSitesMaster> findByTrainingSiteMasterIds(List<Long> trainingSiteIds) {
		List<TrainingSitesMaster> trainingSitesMasterList = new ArrayList<>();
		try {
			DynamicQuery savedSearch = TrainingSitesMasterLocalServiceUtil.dynamicQuery();
			savedSearch.add(RestrictionsFactoryUtil.in("trainingSiteMasterId", trainingSiteIds));
			trainingSitesMasterList = ProgramMasterLocalServiceUtil.dynamicQuery(savedSearch);
		} catch (Exception e) {
			_logger.info("findByTrainingSiteMasterIds ::: " + e);
		}
		return trainingSitesMasterList;
	}
	
	public TrainingSitesMaster getTrainingSiteByDatePerformed(String datePerformed, long traineeId) {
		return this.omsbTmsFinderFinder.getTrainingSiteByDatePerformed(datePerformed, traineeId);
	}

	private static final Log _logger = LogFactoryUtil.getLog(TrainingSitesMasterLocalServiceImpl.class.getName());
	public List<TrainingSitesMaster> getTrainigSitesListByIdsAndStatus(List<Long> ids, Boolean status) {
		DynamicQuery query = TrainingSitesMasterLocalServiceUtil.dynamicQuery();
		query.add(RestrictionsFactoryUtil.eq("trainingSiteStatus", status))
				.add(PropertyFactoryUtil.forName("trainingSiteMasterId").in(ids));
		return TrainingSitesMasterLocalServiceUtil.dynamicQuery(query);
	}

}