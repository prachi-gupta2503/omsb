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

package gov.omsb.tms.service.persistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public interface OmsbTmsFinderFinder {

	public java.util.List<gov.omsb.tms.custom.dto.ProgramDTO> getAllPrograms(
		String languageCode);

	public gov.omsb.tms.custom.dto.ProgramDTO getProgramDetails(
		long programId, String languageCode);

	public java.util.List<gov.omsb.tms.custom.dto.RotationStructureDTO>
		getRotationStructure(long rotationId, String languageCode);

	public java.util.List<gov.omsb.tms.custom.dto.TrainingSiteStructureDTO>
		getTrainingSiteStructure(
			java.util.List<Long> programMasterIds, String programDuration,
			long trainingSiteId, String languageCode);

	public java.util.List<gov.omsb.tms.custom.dto.ProgramStructureDTO>
		getProgramStructure(long programDurationId, String languageCode);

	public java.util.List<gov.omsb.tms.custom.dto.SetupProcedureDTO>
		getSetUpProcedureDetails(String languageCode);

	public java.util.List<gov.omsb.tms.custom.dto.TraineeLevelListDTO>
		getTraineeLevelListByDurationId(long durationId);

	public java.util.List<gov.omsb.tms.custom.dto.RotationListDTO>
		getRotationsByTraineeLevelId(long traineeLevelId, String languageCode);

	public java.util.List<gov.omsb.tms.custom.dto.RotationListDTO>
		getRotationsByTraineeLevelIdAndProgramDurationId(
			long traineeLevelId, long programDurationId, String languageCode);

	public java.util.List
		<gov.omsb.tms.custom.dto.TraineeLoggedProcedureDetailsDTO>
			getTraineeLoggedProcedureDetailsList(
				boolean isSuperVisor, boolean getByDedicatedProgram,
				long supervisorId, String programIds, String languageCode);

	public gov.omsb.tms.custom.dto.TraineeLoggedProcedureDetailsDTO
		getTraineeLoggedProcedureDetail(
			long supervisorId, long traineeLoggedProcedureDetailsId,
			String languageCode);

	public java.util.List<gov.omsb.tms.custom.dto.ProgramStructureDTO>
		getTraineeLevel(long programMasterId);

	public java.util.List<gov.omsb.tms.custom.dto.ProgramCohortDTO>
		getProgramCohorts(
			java.util.List<Long> programIds, java.util.List<String> yearRange,
			String languageCode);

	public java.util.List<gov.omsb.tms.custom.dto.SiteCapacityDTO>
		getSiteCapacityDetails(String languageCode);

	public java.util.List<Long> getSharedRotationIdForApprover(long userId);

	public java.util.List<gov.omsb.tms.custom.dto.ConfigureRotationDetailsDTO>
		getConfigureRotationDetails(String languageCode);

	public java.util.List
		<gov.omsb.tms.custom.dto.ConfigureRotationEditDetailsDTO>
			getConfigureRotationDetailsByProgramAndDuration(
				long programId, long traineeLevelId, long programDurationId);

	public java.util.List<gov.omsb.tms.custom.dto.ProgramCohortDTO>
		getProgramAndCohortsFromProgramDuration(
			java.util.List<Long> programIds, java.util.List<String> yearRange,
			String languageCode);

	public java.util.List<gov.omsb.tms.custom.dto.ProgramCohortDTO>
		getProgramCohortsRelationalDataByProgramDurationId(
			long programDurationId, String languageCode);

	public java.util.List<gov.omsb.tms.custom.dto.TrainingSiteByPdDTO>
		getTrainingSitesByProgramDuration(
			long programId, String programDuration, String languageCode);

	public java.util.List<gov.omsb.tms.custom.dto.TrainingSitesCapacityDTO>
		getProgramTrainingSitesCapacityDetails(String languageCode);

	public java.util.List<gov.omsb.tms.custom.dto.RotationListDTO>
		getRotationsByTrainingSitesId(long trainingSiteId, String languageCode);

	public java.util.List
		<gov.omsb.tms.custom.dto.ProgdurationRotationTrainingSiteDTO>
			getProgdurationRotationByRotationAndDuration(
				long rotationId, String duration, String languageCode);

	public gov.omsb.tms.custom.dto.ConfigureRotationBlockDetailsDTO
		getConfigureRotationDetailsByRotationAndDuration(
			long rotationId, String duration);

	public java.util.List<gov.omsb.tms.custom.dto.TrainingSiteByPdDTO>
		getTrainingSitesByCohort(long programDuration, String languageCode);

	public java.util.List<gov.omsb.tms.custom.dto.RotationListDTO>
		getNotSharedRotationsByTrainingSitesId(
			long trainingSiteId, String languageCode);

	public java.util.List<gov.omsb.tms.custom.dto.ECMembershipRequestListDTO>
		getECMembershipRequestData(
			long programId, long roleId, long statusId,
			long potentialEcMemberLrUserid, String languageCode);

	public java.util.List<gov.omsb.tms.custom.dto.ECMembershipRequestStateDTO>
		getECMembershipRequestStateData(long emMemberRequestId);

	public java.util.List<gov.omsb.tms.custom.dto.TrainingSiteByProgramDTO>
		getTrainingSiteDetailsByProgram(long programId, String languageCode);

	public java.util.List<gov.omsb.tms.custom.dto.FacultySiteCompensationDTO>
		getFacultySiteCompensationReportDetailsOfEcMember(
			String languageCode, long programId);

	public java.util.List<gov.omsb.tms.custom.dto.DutyLogViolationDTO>
		getDutyLogViolationList(
			long programId, long traineeCohortId, long residencyLevelId,
			long traineeId);

	public java.util.List<gov.omsb.tms.custom.dto.DutyLogViolationDTO>
		getDutyLogViolationListByUserId(long traineeId);

	public java.util.List<gov.omsb.tms.custom.dto.DutyLogHoursDTO>
		getDutyLogHours(
			long programId, long traineeCohortId, long residencyLevelId,
			long traineeId, String stratDate, String endDate);

	public java.util.List<gov.omsb.tms.custom.dto.TrainingSiteByRotationsDTO>
		getTrainingSiteByRotation(
			java.util.List<Long> programIds, String languageCode,
			long progDurationId);

	public java.util.List
		<gov.omsb.tms.custom.dto.TrainingSiteNameWithRotationDTO>
			getTrainingSiteNameWithRotation(
				String languageCode, long programId);

	public java.util.List
		<gov.omsb.tms.custom.dto.RotationTraineeBlockRelationDTO>
			getTraineeNoofBlocks(
				long programDurationId, long traineeLevelId,
				String languageCode);

	public java.util.List<gov.omsb.tms.custom.dto.RotationDTO>
		getRotationsByTrainingSiteAndCohort(
			long trainingSiteId, long cohortId, String languageCode);

	public java.util.Map<Long, String> getProcedureMasterParameter(
		long programDurationId, String type, String languageCode);

	public gov.omsb.tms.model.TrainingSitesMaster
		getTrainingSiteByDatePerformed(String datePerformed, long traineeId);

	public gov.omsb.tms.custom.dto.DutyLogDTO getDutyLogDTO(
		long traineeId, String startDate);

	public java.util.List<gov.omsb.tms.custom.dto.DutyTypeDTO>
		getAcgmeCallRule8Hour(long dutyTypeId, long traineeId, long blockId);

	public gov.omsb.tms.custom.dto.DutyLogDTO getAcgmeCallRule48Hour(
		long dutyTypeId, long traineeId, long blockId, long dutyLogId);

	public java.util.List<gov.omsb.tms.custom.dto.DutyLogDTO> getDutyLogs(
		java.util.Date startDate, java.util.Date endDate, long traineeId);

	public long getRotationIdByDatePerformed(
		String datePerformed, long traineeId);

	public java.util.List<Long> getTraineeByProgramCohortAndTraineeLevel(
		long programDurationId, long traineeLevelId);

	public java.util.List<gov.omsb.tms.custom.dto.ResidentReportDTO>
		getResidentsInEachSitePerBlock(
			long programId, String annualYear, String languageCode);

	public java.util.List<gov.omsb.tms.custom.dto.FacultyRequestDTO>
		getFacultyRequestData(String languageCode);

	public java.util.List<gov.omsb.tms.custom.dto.FacultyRequestDTO>
		getFacultyRequestDataBySearch(
			long programId, long facultyTypeId, long facultyRequestStatusId,
			String languageCode);

	public java.util.List<gov.omsb.tms.custom.dto.FacultyRequestDTO>
		getFacultyRequestDataByUserId(long userId, String languageCode);

	public java.util.List<gov.omsb.tms.custom.dto.TrainingSiteByProgramDTO>
		getTrainingSiteDetailsByProgramMaster(
			long programId, String languageCode);

}