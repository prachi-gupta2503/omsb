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

import gov.omsb.tms.custom.dto.DutyLogViolationDTO;
import gov.omsb.tms.exception.NoSuchDutyLogViolationException;
import gov.omsb.tms.model.DutyLogViolation;
import gov.omsb.tms.service.base.DutyLogViolationLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=gov.omsb.tms.model.DutyLogViolation",
	service = AopService.class
)
public class DutyLogViolationLocalServiceImpl
	extends DutyLogViolationLocalServiceBaseImpl {
	
	public List<DutyLogViolationDTO> getDutyLogViolationList(long programId,long traineeCohortId,long residencyLevelId,long traineeId) {
		LOGGER.info("DutyLogViolationLocalServiceBaseImpl called------------");
		List<DutyLogViolationDTO> dutyLogViolationList = omsbTmsFinderFinder.getDutyLogViolationList(programId,traineeCohortId,residencyLevelId,traineeId);
		LOGGER.info("dutyLogViolationList "+dutyLogViolationList);;
		return dutyLogViolationList;
	}
	
	public List<DutyLogViolationDTO> getDutyLogViolationListByUserId(long traineeId) {
		LOGGER.info("getDutyLogViolationListByUserId called------------");
		List<DutyLogViolationDTO> dutyLogViolationList = omsbTmsFinderFinder.getDutyLogViolationListByUserId(traineeId);
		LOGGER.info("dutyLogViolationList "+dutyLogViolationList);;
		return dutyLogViolationList;
	}
	
	public DutyLogViolation findByTraineeId(long traineeId) {
		try {
			return dutyLogViolationPersistence.findByTraineeId(traineeId);
		} catch (NoSuchDutyLogViolationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; 
		
	}
	
	public DutyLogViolation findByDutyLogId(long dutyLogId) {
		try {
			return dutyLogViolationPersistence.findByDutyLogId(dutyLogId);
		} catch (NoSuchDutyLogViolationException e) {
			LOGGER.error("Error----- "+e.getMessage());
		}
		return null;
	}
	
	public List<DutyLogViolation> findByTraineeIdAndBlockId(long traineeId, long blockId) {
		return dutyLogViolationPersistence.findByTraineeIdAndBlockId(traineeId, blockId);
	}
	
	
	public DutyLogViolation addDutyLogViolation(long groupId, long companyId, long createdBy,long modifiedBy, long traineeId, long dutyLogId,
			long programMasterId, long residencyLevel, long rotationId, long trainingSiteId, long blockId,
			long blockWeekId, long programDutyRuleId) {
	
		long dutyLogViolationId = counterLocalService.increment(DutyLogViolation.class.getName());
		DutyLogViolation dutyLogViolation = dutyLogViolationLocalService.createDutyLogViolation(dutyLogViolationId);
		LOGGER.info("dutyLogViolationId-->"+dutyLogViolationId);
		dutyLogViolation.setGroupId(groupId); 
		dutyLogViolation.setCompanyId(companyId); 
		dutyLogViolation.setCreateDate(new Date());
		dutyLogViolation.setCreatedBy(createdBy); 
		dutyLogViolation.setModifiedDate(new Date());
		dutyLogViolation.setModifiedBy(modifiedBy); 
		dutyLogViolation.setTraineeId(traineeId); 
		dutyLogViolation.setDutyLogId(dutyLogId);
		dutyLogViolation.setProgramMasterId(programMasterId);
		dutyLogViolation.setResidencyLevel(residencyLevel);
		dutyLogViolation.setRotationId(rotationId);
		dutyLogViolation.setTrainingSiteId(trainingSiteId);
		dutyLogViolation.setBlockId(blockId);
		dutyLogViolation.setBlockWeekId(blockWeekId);
		dutyLogViolation.setProgramDutyRuleId(programDutyRuleId);
		dutyLogViolationLocalService.addDutyLogViolation(dutyLogViolation);
		return dutyLogViolation;

	}
	
	public DutyLogViolation findByTraineeAndBlockAndProgramAndDutyLogId(long traineeId, long blockId, long programMasterId, long dutyLogId) {
		try {
			return	dutyLogViolationPersistence.findByTraineeAndBlockAndProgramAndDutyLogId(traineeId, blockId, programMasterId, dutyLogId);
		} catch (NoSuchDutyLogViolationException e) {
			LOGGER.error(e.getMessage());
		}
		return null;
		
	}
	
	
	private static final Log LOGGER = LogFactoryUtil.getLog(DutyLogViolationLocalServiceImpl.class.getName());
	
}