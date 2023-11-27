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
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.common.util.OmsbTmsCommonUtil;
import gov.omsb.tms.custom.dto.DutyLogDTO;
import gov.omsb.tms.custom.dto.DutyLogHoursDTO;
import gov.omsb.tms.custom.dto.TraineeLevelListDTO;
import gov.omsb.tms.model.DutyLog;
import gov.omsb.tms.model.ProgramDutyAssignment;
import gov.omsb.tms.model.TraineeLevelMaster;
import gov.omsb.tms.model.impl.DutyLogImpl;
import gov.omsb.tms.service.TraineeLevelMasterLocalServiceUtil;
import gov.omsb.tms.service.base.DutyLogLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=gov.omsb.tms.model.DutyLog", service = AopService.class)
public class DutyLogLocalServiceImpl extends DutyLogLocalServiceBaseImpl {

	public List<DutyLogHoursDTO> getDutyLogHours(long programId, long traineeCohortId, long residencyLevelId,
			long traineeId, String stratDate, String endDate) {

		return omsbTmsFinderFinder.getDutyLogHours(programId, traineeCohortId, residencyLevelId, traineeId, stratDate,
				endDate);

	}

	
	public DutyLogDTO getDutyLogDTO(long traineeId, String startDate) {

		return omsbTmsFinderFinder.getDutyLogDTO(traineeId, startDate);

	}

	// Get List of dutyLog by TraineeIdAndBlockId
	public List<DutyLog> getDutyLogListByTraineeIdAndBlockId(long traineeId, long blocksMetadataDetailRelId) {
		List<DutyLog> dutyLogList = dutyLogPersistence.findByTranieeIdAndBlocksMetadataDetailRelId(traineeId,
				blocksMetadataDetailRelId);
		return dutyLogList;
	}

	public DutyLog getPreviousDutyLog(long dutyLogId) {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(DutyLogImpl.class,
				PortalClassLoaderUtil.getClassLoader());
		query.add(RestrictionsFactoryUtil.lt("dutyLogId", dutyLogId));
		query.addOrder(OrderFactoryUtil.desc("dutyLogId"));
		query.setLimit(0, 1);
		List<DutyLog> dutyLogs = dutyLogLocalService.dynamicQuery(query);
		return dutyLogs.isEmpty() ? null : dutyLogs.get(0);
	}

	public DutyLog getPreviousDutyLog(long dutyLogId, long traineeId, long blockId, Date startDate) {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(DutyLogImpl.class,
				PortalClassLoaderUtil.getClassLoader());
		query.add(RestrictionsFactoryUtil.le("endDate", startDate));
		query.add(RestrictionsFactoryUtil.eq("traineeId", traineeId));
		query.add(RestrictionsFactoryUtil.eq("blocksMetadataDetailRelId", blockId));
		query.addOrder(OrderFactoryUtil.desc("endDate"));
		query.setLimit(0, 1);
		List<DutyLog> dutyLogs = dutyLogLocalService.dynamicQuery(query);
		return dutyLogs.isEmpty() ? null : dutyLogs.get(0);
	}

	public DutyLogDTO getAcgmeCallRule48Hour(long dutyTypeId, long traineeId, long blockId, long dutyLogId) {
		return omsbTmsFinderFinder.getAcgmeCallRule48Hour(dutyTypeId, traineeId, blockId, dutyLogId);

	}

	public List<DutyLogDTO> getDutyLogs(Date startDate, Date endDate, long traineeId) {
		List<DutyLogDTO> dutyLogList = omsbTmsFinderFinder.getDutyLogs(startDate, endDate, traineeId);
		return dutyLogList;
	}

	public List<DutyLog> getByBlocksMetadataDetailRelId(long blocksMetadataDetailRelId) {
		try {
			return dutyLogPersistence.findByBlocksMetadataDetailRelId(blocksMetadataDetailRelId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public List<TraineeLevelListDTO> getByTranieeIdAndProgramDutyAssignmentId(long traineeId, long programId,
			long cohortId, String languageCode) {
		LOGGER.info("traineeId==>" + traineeId);
		LOGGER.info("programId==>" + programId);
		LOGGER.info("cohortId==>" + cohortId);
		List<TraineeLevelListDTO> traineeLevelList = new ArrayList<>();
		List<ProgramDutyAssignment> programDutyAssignments = programDutyAssignmentPersistence
				.findByProgramIdAndCohortId(programId, cohortId);
		LOGGER.info(
				"programDutyAssignments =============================================================================>"
						+ programDutyAssignments);
		for (ProgramDutyAssignment programDutyAssignment : programDutyAssignments) {
			LOGGER.info(
					"programDutyAssignment.getProgramDutyAssignmentId()==##########################################==>"
							+ programDutyAssignment.getProgramDutyAssignmentId());
			List<DutyLog> dutyLogs = dutyLogPersistence.findByTranieeIdAndProgramDutyAssignmentId(traineeId,
					programDutyAssignment.getProgramDutyAssignmentId());
			LOGGER.info("dutyLogs==>" + dutyLogs);
			traineeLevelList = addToTraineeLevelListDTO(dutyLogs, languageCode);

		}
		LOGGER.info("traineeLevelList==>" + traineeLevelList);
		return traineeLevelList;
	}

	public List<TraineeLevelListDTO> addToTraineeLevelListDTO(List<DutyLog> dutyLogs, String languageCode) {
		List<TraineeLevelListDTO> traineeLevelList = new ArrayList<>();
		for (DutyLog dutyLog : dutyLogs) {
			TraineeLevelMaster traineeLevelMaster = null;
			TraineeLevelListDTO dto = new TraineeLevelListDTO();
			try {
				LOGGER.info("dutyLog.getResidencyLevelId()==>" + dutyLog.getResidencyLevelId());
				traineeLevelMaster = TraineeLevelMasterLocalServiceUtil.getTraineeLevelMaster(dutyLog.getResidencyLevelId());
				LOGGER.info("traineeLevelMaster==>" + traineeLevelMaster);
				if(!isTraineeLevel(traineeLevelMaster, traineeLevelList)) {
					LOGGER.info("inside if");
					dto.setTraineeLevelId(traineeLevelMaster.getTraineeLevelMasterId());
					dto.setTraineeLevelName(
							OmsbTmsCommonUtil.getValueByLanguage(traineeLevelMaster.getTraineeLevelName(),
									OmsbTmsCommonConstants.TRAINEE_LEVEL_NAME, languageCode));
					traineeLevelList.add(dto);
				}

			} catch (PortalException e) {
				
				e.printStackTrace();
			}
			
		}
		return traineeLevelList;

	}

	public boolean isTraineeLevel(TraineeLevelMaster traineeLevelMaster, List<TraineeLevelListDTO> traineeLevelList) {
		for (TraineeLevelListDTO traineeLevelListDTO : traineeLevelList) {
			if (traineeLevelListDTO.getTraineeLevelId() == traineeLevelMaster.getTraineeLevelMasterId()) {
				return true;
			}
		}

		return false;

	}

	public List<DutyLog> getByProgramDutyAssignmentId(long programDutyAssignmentId) {
		return dutyLogPersistence.findByProgramDutyAssignmentId(programDutyAssignmentId);
	}

	private static final Log LOGGER = LogFactoryUtil.getLog(DutyLogLocalServiceImpl.class);
}