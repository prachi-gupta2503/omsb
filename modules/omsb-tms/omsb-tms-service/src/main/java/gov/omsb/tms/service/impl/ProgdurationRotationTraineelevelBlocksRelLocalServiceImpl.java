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

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import gov.omsb.tms.custom.dto.ConfigureRotationBlockDetailsDTO;
import gov.omsb.tms.custom.dto.ConfigureRotationDetailsDTO;
import gov.omsb.tms.custom.dto.ConfigureRotationEditDetailsDTO;
import gov.omsb.tms.custom.dto.RotationTraineeBlockRelationDTO;
import gov.omsb.tms.exception.NoSuchProgdurationRotationTraineelevelBlocksRelException;
import gov.omsb.tms.model.ProgdurationRotationTraineelevelBlocksRel;
import gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel;
import gov.omsb.tms.service.base.ProgdurationRotationTraineelevelBlocksRelLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=gov.omsb.tms.model.ProgdurationRotationTraineelevelBlocksRel", service = AopService.class)
public class ProgdurationRotationTraineelevelBlocksRelLocalServiceImpl
		extends ProgdurationRotationTraineelevelBlocksRelLocalServiceBaseImpl {

	public List<ProgdurationRotationTraineelevelBlocksRel> findTraineeLevelByDurationId(long durationId) {
		return this.progdurationRotationTraineelevelBlocksRelPersistence.findByProgramDurationId(durationId);
	}

	public List<ProgdurationRotationTraineelevelBlocksRel> findRotationByTraineeLevelId(long traineeLevelId) {
		return this.progdurationRotationTraineelevelBlocksRelPersistence.findByTraineeLevelId(traineeLevelId);
	}

	public List<ConfigureRotationDetailsDTO> getConfigureRotationDetails(String languageCode) {
		return omsbTmsFinderFinder.getConfigureRotationDetails(languageCode);
	}

	public List<ConfigureRotationEditDetailsDTO> getConfigureRotationDetailsByProgramAndDuration(long programId,
			long traineeLevelId, long programDurationId) {
		return omsbTmsFinderFinder.getConfigureRotationDetailsByProgramAndDuration(programId, traineeLevelId,
				programDurationId);
	}

	public ConfigureRotationBlockDetailsDTO getConfigureRotationDetailsByRotationAndDuration(long rotationId,
			String duration) {
		return omsbTmsFinderFinder.getConfigureRotationDetailsByRotationAndDuration(rotationId, duration);
	}

	public List<ProgdurationRotationTraineelevelBlocksRel> findByProgramDurationIdAndTraineeLevelId(
			long programDurationId, long traineeLevelId) {
		return this.progdurationRotationTraineelevelBlocksRelPersistence
				.findByProgramDurationIdAndTraineeLevelId(programDurationId, traineeLevelId);
	}

	public List<ProgdurationRotationTraineelevelBlocksRel> findByTraineeLevelIdAndRotationType(long traineeLevelId, long rotationType) {
		return this.progdurationRotationTraineelevelBlocksRelPersistence.findByTraineeLevelIdAndRotationType(traineeLevelId, rotationType);
	}
	
	public List<RotationTraineeBlockRelationDTO> getTraineeNoofBlocks(long programDurationId,long traineeLevelId, String languageCode) {
		return omsbTmsFinderFinder.getTraineeNoofBlocks(programDurationId,traineeLevelId,languageCode);
	}
	
	public ProgdurationRotationTraineelevelBlocksRel findByProgramDurationIdAndTraineeLevelIdAndRotationId(long traineeLevelId, long programDurationId, long rotationId) throws NoSuchProgdurationRotationTraineelevelBlocksRelException {
		return this.progdurationRotationTraineelevelBlocksRelPersistence.findByProgramDurationIdAndTraineeLevelIdAndRotationId(traineeLevelId, programDurationId, rotationId);
	}
	
	public List<ProgdurationRotationTraineelevelBlocksRel> findByProgramDurationIdAndRotationId(long programDurationId, long rotationId) {
		return this.progdurationRotationTraineelevelBlocksRelPersistence.findByProgramDurationIdAndRotationId(programDurationId, rotationId);
	}
	
	public List<ProgdurationRotationTraineelevelBlocksRel> addProgdurationRotationTraineelevelBlocksRel(List<ProgdurationTraineelevelBlocksLevelTypeRel> progdurationTraineelevelBlocksLevelTypeRels,long rotationId,long groupId,long createdBy){
		List<ProgdurationRotationTraineelevelBlocksRel> progdurationRotationTraineelevelBlocksRels = new ArrayList<>();
		
		for (ProgdurationTraineelevelBlocksLevelTypeRel progdurationTraineelevelBlocksLevelTypeRel : progdurationTraineelevelBlocksLevelTypeRels) {
			
			long progdurationRotationTraineelevelBlocksRelId = counterLocalService.increment(getClass().getName(), 1);
			
			ProgdurationRotationTraineelevelBlocksRel progdurationRotationTraineelevelBlocksRel = super.createProgdurationRotationTraineelevelBlocksRel(progdurationRotationTraineelevelBlocksRelId);
			
			progdurationRotationTraineelevelBlocksRel.setProgramDurationId(progdurationTraineelevelBlocksLevelTypeRel.getProgramDurationId());
			progdurationRotationTraineelevelBlocksRel.setRotationId(rotationId);
			progdurationRotationTraineelevelBlocksRel.setRotationType(1);
			progdurationRotationTraineelevelBlocksRel.setTraineeLevelId(progdurationTraineelevelBlocksLevelTypeRel.getTraineeLevelId());
			progdurationRotationTraineelevelBlocksRel.setGroupId(groupId);
			progdurationRotationTraineelevelBlocksRel.setCreatedBy(createdBy);
			progdurationRotationTraineelevelBlocksRel.setModifiedBy(createdBy);
			progdurationRotationTraineelevelBlocksRel.setNoOfBlocks(0);
			
			progdurationRotationTraineelevelBlocksRels.add(super.addProgdurationRotationTraineelevelBlocksRel(progdurationRotationTraineelevelBlocksRel));
			
			 _logger.info("doServeResource ::: progdurationRotationTraineelevelBlocksRels ::: " + progdurationRotationTraineelevelBlocksRels);
		}
		
		return progdurationRotationTraineelevelBlocksRels;
	}
	private static final Log _logger = LogFactoryUtil.getLog(ProgdurationRotationTraineelevelBlocksRelLocalServiceImpl.class.getName());
}