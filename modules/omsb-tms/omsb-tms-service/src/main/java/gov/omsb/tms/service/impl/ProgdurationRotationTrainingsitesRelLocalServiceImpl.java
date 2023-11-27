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

import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.custom.dto.RotationListDTO;
import gov.omsb.tms.custom.dto.SiteCapacityDTO;
import gov.omsb.tms.custom.dto.TrainingSiteByPdDTO;
import gov.omsb.tms.custom.dto.TrainingSiteByProgramDTO;
import gov.omsb.tms.custom.dto.TrainingSitesCapacityDTO;
import gov.omsb.tms.exception.NoSuchProgdurationRotationTrainingsitesRelException;
import gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel;
import gov.omsb.tms.model.ProgramDurationDetails;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.model.RotationMaster;
import gov.omsb.tms.model.TrainingSitesMaster;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;
import gov.omsb.tms.service.RotationMasterLocalService;
import gov.omsb.tms.service.TrainingSitesMasterLocalService;
import gov.omsb.tms.service.base.ProgdurationRotationTrainingsitesRelLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel", service = AopService.class)
public class ProgdurationRotationTrainingsitesRelLocalServiceImpl
		extends ProgdurationRotationTrainingsitesRelLocalServiceBaseImpl {

	public List<SiteCapacityDTO> getSiteCapacityDetails(String languageCode) {
		return omsbTmsFinderFinder.getSiteCapacityDetails(languageCode);
	}

	public List<ProgdurationRotationTrainingsitesRel> findByProgramDurationId(long programDurationId) {
		return this.progdurationRotationTrainingsitesRelPersistence.findByProgramDurationId(programDurationId);
	}

	public List<ProgdurationRotationTrainingsitesRel> findByRotationId(long rotationId) {
		return this.progdurationRotationTrainingsitesRelPersistence.findByRotationId(rotationId);
	}

	public List<ProgdurationRotationTrainingsitesRel> findByRotationId(long rotationId, boolean isSharedRotation) {
		return this.progdurationRotationTrainingsitesRelPersistence.findByRotationIdAndIsSharedRotation(rotationId,
				isSharedRotation);
	}

	public List<ProgdurationRotationTrainingsitesRel> findByTrainingSitesId(long trainingSitesId) {
		return this.progdurationRotationTrainingsitesRelPersistence.findByTrainingSitesId(trainingSitesId);
	}

	public ProgdurationRotationTrainingsitesRel findByProgDurationAndTrainingSite(long trainingSitesId,long progDurationId) throws NoSuchProgdurationRotationTrainingsitesRelException  {
		return this.progdurationRotationTrainingsitesRelPersistence.findByProgDurationAndTrainingSite(trainingSitesId, progDurationId);
	}
	public List<TrainingSiteByPdDTO> getTrainingSitesByProgramDuration(long programId, String programDuration,
			String languageCode) {
		return omsbTmsFinderFinder.getTrainingSitesByProgramDuration(programId, programDuration, languageCode);
	}

	public ProgdurationRotationTrainingsitesRel findSlotsByTrainingSitesAndRotationId(long trainingSitesId,
			long rotationId) {
		ProgdurationRotationTrainingsitesRel progdurationRotationTrainingsitesRel = null;
		try {
			progdurationRotationTrainingsitesRel = this.progdurationRotationTrainingsitesRelPersistence
					.findByTrainingSiteAndRotationId(trainingSitesId, rotationId);
		} catch (NoSuchProgdurationRotationTrainingsitesRelException e) {
			_logger.error(e);
		}
		return progdurationRotationTrainingsitesRel;
	}

	public List<TrainingSitesCapacityDTO> getProgramTrainingSitesCapacityDetails(String languageCode) {
		return omsbTmsFinderFinder.getProgramTrainingSitesCapacityDetails(languageCode);
	}

	public List<RotationListDTO> getRotationsByTrainingSitesId(long trainingSiteId, String languageCode) {
		return omsbTmsFinderFinder.getRotationsByTrainingSitesId(trainingSiteId, languageCode);
	}

	public List<TrainingSiteByPdDTO> getTrainingSitesByCohort(long programDuration, String languageCode) {
		return omsbTmsFinderFinder.getTrainingSitesByCohort(programDuration, languageCode);
	}

	public List<RotationListDTO> getNotSharedRotationsByTrainingSitesId(long trainingSiteId, String languageCode) {
		return omsbTmsFinderFinder.getNotSharedRotationsByTrainingSitesId(trainingSiteId, languageCode);
	}

	public ProgdurationRotationTrainingsitesRel findByProgDurationTrainingSitesAndRotationId(long durationId,
			long trainingSitesId, long rotationId) {
		ProgdurationRotationTrainingsitesRel progdurationRotationTrainingsitesRel = null;
		try {
			progdurationRotationTrainingsitesRel = this.progdurationRotationTrainingsitesRelPersistence
					.findByProgDurationTrainingSiteAndRotationId(trainingSitesId, rotationId, durationId);
		} catch (NoSuchProgdurationRotationTrainingsitesRelException e) {
			_logger.error(e);
		}
		return progdurationRotationTrainingsitesRel;
	}
	
	public ProgdurationRotationTrainingsitesRel findByProgDurationRotationOwningProgramAndRotationId(long durationId,
			long rotationOwningProgramId, long rotationId) {
		ProgdurationRotationTrainingsitesRel progdurationRotationTrainingsitesRel = null;
		try {
			progdurationRotationTrainingsitesRel = this.progdurationRotationTrainingsitesRelPersistence
					.findByProgDurationRotationOwningProgramAndRotationId(rotationOwningProgramId, rotationId, durationId);
		} catch (NoSuchProgdurationRotationTrainingsitesRelException e) {
			_logger.error(e);
		}
		return progdurationRotationTrainingsitesRel;
	}
	
	public List<TrainingSiteByProgramDTO> getTrainingSiteDetailsByProgram(long programId, String languageCode) {
		return omsbTmsFinderFinder.getTrainingSiteDetailsByProgram(programId, languageCode);
	}
	
	public List<ProgdurationRotationTrainingsitesRel> findByProgramDurationIdAndTrainingSitesIds(long programDurationId, List<Long> trainingSiteIds) {
		DynamicQuery query = progdurationRotationTrainingsitesRelLocalService.dynamicQuery();
		query.add(RestrictionsFactoryUtil.eq("programDurationId", programDurationId))
				.add(PropertyFactoryUtil.forName("trainingSitesId").in(trainingSiteIds));
		return progdurationRotationTrainingsitesRelLocalService.dynamicQuery(query);
	}
	
	public List<ProgdurationRotationTrainingsitesRel> findByProgramDurationIdAndRotationIdAndIsSharedRotation(long programDurationId, long rotationId, boolean isSharedRotation) {
		DynamicQuery query = progdurationRotationTrainingsitesRelLocalService.dynamicQuery();
		query.add(RestrictionsFactoryUtil.eq("programDurationId", programDurationId))
				.add(RestrictionsFactoryUtil.eq("rotationId", rotationId))
				.add(RestrictionsFactoryUtil.eq("isSharedRotation", isSharedRotation));
		return progdurationRotationTrainingsitesRelLocalService.dynamicQuery(query);
	}
	
	public boolean deleteTrainingSitesByProgramCohortIdAndTrainingSiteIds(long programCohortId, List<Long> deleteTrainingSiteIds) {
		_logger.info("deleteTrainingSitesByProgramCohortIdAndTrainingSiteIds Invoked :::");
		boolean isSuccess = true;
		List<ProgdurationRotationTrainingsitesRel> deleteTrainingSites = findByProgramDurationIdAndTrainingSitesIds(programCohortId, deleteTrainingSiteIds);
		if(Validator.isNotNull(deleteTrainingSites) && !deleteTrainingSites.isEmpty()) {
			for(ProgdurationRotationTrainingsitesRel rel : deleteTrainingSites) {
				try {
					_logger.info(rel.getProgdurationRotationTsRelId());
					deleteProgdurationRotationTrainingsitesRel(rel.getProgdurationRotationTsRelId());
				} catch (Exception e) {
					isSuccess = false;
					_logger.error(e);
				}
			}
		}
		_logger.info("deleteTrainingSitesByProgramCohortIdAndTrainingSiteIds ::: isSuccess :: " + isSuccess);
		_logger.info("deleteTrainingSitesByProgramCohortIdAndTrainingSiteIds Exit :::");
		return isSuccess;
	}
	
	public List<ProgdurationRotationTrainingsitesRel> addTrainingSitesByProgramCohort(long createdBy, long groupId, long programCohortId, List<Long> addTrainingSites) {
		_logger.info("addTrainingSitesByProgramCohort Invoked :::");
		List<ProgdurationRotationTrainingsitesRel> progdurationRotationTrainingsitesRels = new ArrayList<>();
		if(Validator.isNotNull(addTrainingSites) && !addTrainingSites.isEmpty()) {
			try {
				for(long trainingSitesId : addTrainingSites) {
					long progdurationRotationTsRelId = counterLocalService.increment(getClass().getName(), 1);
					ProgdurationRotationTrainingsitesRel progdurationRotationTrainingsitesRel = createProgdurationRotationTrainingsitesRel(progdurationRotationTsRelId);
					progdurationRotationTrainingsitesRel.setIsSharedRotation(false);
					progdurationRotationTrainingsitesRel.setProgramDurationId(programCohortId);
					progdurationRotationTrainingsitesRel.setTrainingSitesId(trainingSitesId);
					progdurationRotationTrainingsitesRel.setCreatedBy(createdBy);
					progdurationRotationTrainingsitesRel.setModifiedBy(createdBy);
					progdurationRotationTrainingsitesRel.setGroupId(groupId);
					progdurationRotationTrainingsitesRels.add(addProgdurationRotationTrainingsitesRel(progdurationRotationTrainingsitesRel));
				}
			} catch (Exception e) {
				_logger.error(e);
				_logger.info("addTrainingSitesByProgramCohort ::: Reverting Changes");
				for(ProgdurationRotationTrainingsitesRel progdurationRotationTrainingsitesRel : progdurationRotationTrainingsitesRels) {
					deleteProgdurationRotationTrainingsitesRel(progdurationRotationTrainingsitesRel);
				}
				_logger.info("addTrainingSitesByProgramCohort ::: Changes Reverted");
			}
			
		}
		_logger.info("addTrainingSitesByProgramCohort Exit :::");
		return progdurationRotationTrainingsitesRels;
	}

	
	public List<ProgdurationRotationTrainingsitesRel> addRotationsAndSlotsToTrainingSite(JSONArray rotationJsonArray, long programDurationId,long trainingSiteId, long groupId,long createdBy){
	
		ProgramDurationDetails programDurationDetails;
		ProgramMaster programMaster = null ;
		TrainingSitesMaster trainingSitesMaster = null;
		RotationMaster rotationMaster;
		try {
			programDurationDetails = programDurationDetailsLocalService.getProgramDurationDetails(programDurationId);
			programMaster = programMasterLocalService.getProgramMaster(programDurationDetails.getProgramId());
			trainingSitesMaster = trainingSitesMasterLocalService.getTrainingSitesMaster(trainingSiteId);
		} catch (Exception e) {
			_logger.error(e.getMessage());
		}
		
		List<ProgdurationRotationTrainingsitesRel> progdurationRotationTrainingsitesRels = new ArrayList<>()	;
		for (int i = 0; i < rotationJsonArray.length(); i++) {  
			JSONObject rotationJsonObject = rotationJsonArray.getJSONObject(i);  
			long rotationMasterId = rotationJsonObject.getLong("rotation");
			
			String progcodeRsnSitecode = StringPool.BLANK;
			try {
			rotationMaster = rotationMasterLocalService.getRotationMaster(rotationMasterId);
			progcodeRsnSitecode = programMaster.getProgramCode(OmsbTmsCommonConstants.LANGUAGE_CODE_ENGLISH) + StringPool.COLON + rotationMaster.getRotationCode(OmsbTmsCommonConstants.LANGUAGE_CODE_ENGLISH) + StringPool.DASH + trainingSitesMaster.getTrainingSiteCode(OmsbTmsCommonConstants.LANGUAGE_CODE_ENGLISH);
			} catch (Exception e) {
				_logger.error(e.getMessage());
			}
            long progdurationRotationTsRelId = counterLocalService.increment(getClass().getName(), 1);
           
            ProgdurationRotationTrainingsitesRel progdurationRotationTrainingsitesRel = progdurationRotationTrainingsitesRelLocalService.createProgdurationRotationTrainingsitesRel(progdurationRotationTsRelId);
            
            progdurationRotationTrainingsitesRel.setProgramDurationId(programDurationId);
            progdurationRotationTrainingsitesRel.setRotationId(rotationMasterId);
            progdurationRotationTrainingsitesRel.setTrainingSitesId(trainingSiteId);
            progdurationRotationTrainingsitesRel.setProgCodeRsnSiteCode(progcodeRsnSitecode);
            progdurationRotationTrainingsitesRel.setGroupId(groupId);
            progdurationRotationTrainingsitesRel.setCreatedBy(createdBy);
            progdurationRotationTrainingsitesRel.setModifiedBy(createdBy);
            progdurationRotationTrainingsitesRel.setIsSharedRotation(false);
            progdurationRotationTrainingsitesRel.setRotationOwningProgramId(0);
            progdurationRotationTrainingsitesRel.setNoOfSlots(rotationJsonObject.getInt("noOfSlots"));
            
            progdurationRotationTrainingsitesRels.add(addProgdurationRotationTrainingsitesRel(progdurationRotationTrainingsitesRel));
            _logger.info("doServeResource ::: progdurationRotationTrainingsitesRel ::: " + progdurationRotationTrainingsitesRel);
          
		}
		
		return progdurationRotationTrainingsitesRels;
	}
	
	public List<TrainingSiteByProgramDTO> getTrainingSiteDetailsByProgramMaster(long programId, String languageCode) {
		return omsbTmsFinderFinder.getTrainingSiteDetailsByProgramMaster(programId, languageCode);
	}
	
	@Reference
	private ProgramMasterLocalService programMasterLocalService;
	
	@Reference
	private RotationMasterLocalService rotationMasterLocalService;
	
	@Reference
	private TrainingSitesMasterLocalService trainingSitesMasterLocalService;
	
	@Reference
	private ProgramDurationDetailsLocalService programDurationDetailsLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(ProgdurationRotationTrainingsitesRelLocalServiceImpl.class.getName());
}
