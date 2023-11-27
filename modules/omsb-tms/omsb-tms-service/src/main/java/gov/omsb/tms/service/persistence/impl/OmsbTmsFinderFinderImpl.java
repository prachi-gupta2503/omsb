package gov.omsb.tms.service.persistence.impl;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.common.util.OmsbTmsCommonUtil;
import gov.omsb.tms.custom.dto.ConfigureRotationBlockDetailsDTO;
import gov.omsb.tms.custom.dto.ConfigureRotationDetailsDTO;
import gov.omsb.tms.custom.dto.ConfigureRotationEditDetailsDTO;
import gov.omsb.tms.custom.dto.DutyLogDTO;
import gov.omsb.tms.custom.dto.DutyLogHoursDTO;
import gov.omsb.tms.custom.dto.DutyLogViolationDTO;
import gov.omsb.tms.custom.dto.DutyTypeDTO;
import gov.omsb.tms.custom.dto.ECMembershipRequestListDTO;
import gov.omsb.tms.custom.dto.ECMembershipRequestStateDTO;
import gov.omsb.tms.custom.dto.FacultyRequestDTO;
import gov.omsb.tms.custom.dto.FacultySiteCompensationDTO;
import gov.omsb.tms.custom.dto.ProgdurationRotationTrainingSiteDTO;
import gov.omsb.tms.custom.dto.ProgramCohortDTO;
import gov.omsb.tms.custom.dto.ProgramDTO;
import gov.omsb.tms.custom.dto.ProgramStructureDTO;
import gov.omsb.tms.custom.dto.ResidentReportDTO;
import gov.omsb.tms.custom.dto.RotationDTO;
import gov.omsb.tms.custom.dto.RotationListDTO;
import gov.omsb.tms.custom.dto.RotationStructureDTO;
import gov.omsb.tms.custom.dto.RotationTraineeBlockRelationDTO;
import gov.omsb.tms.custom.dto.SetupProcedureDTO;
import gov.omsb.tms.custom.dto.SiteCapacityDTO;
import gov.omsb.tms.custom.dto.TraineeLevelListDTO;
import gov.omsb.tms.custom.dto.TraineeLoggedProcedureDetailsDTO;
import gov.omsb.tms.custom.dto.TrainingSiteByPdDTO;
import gov.omsb.tms.custom.dto.TrainingSiteByProgramDTO;
import gov.omsb.tms.custom.dto.TrainingSiteByRotationsDTO;
import gov.omsb.tms.custom.dto.TrainingSiteNameWithRotationDTO;
import gov.omsb.tms.custom.dto.TrainingSiteStructureDTO;
import gov.omsb.tms.custom.dto.TrainingSitesCapacityDTO;
import gov.omsb.tms.model.TrainingSitesMaster;
import gov.omsb.tms.service.TrainingSitesMasterLocalServiceUtil;
import gov.omsb.tms.service.persistence.OmsbTmsFinderFinder;

@Component(service = OmsbTmsFinderFinder.class)
public class OmsbTmsFinderFinderImpl extends OmsbTmsFinderFinderBaseImpl implements OmsbTmsFinderFinder {

	// The code commented as this details not required as received feedback from the
	// client on 16-08-2023
	public List<ProgramDTO> getAllPrograms(String languageCode) {
		List<ProgramDTO> programList = new ArrayList<>();
		String sql = customSQL.get(getClass(), OmsbTmsCommonConstants.GET_ALL_PROGRAMS);
		if (Validator.isNotNull(sql)) {
			Session session = openSession();
			try {
				Query query = session.createSQLQuery(sql);
				query.setCacheable(false);
				List<Object[]> data = query.list();
				if (Validator.isNotNull(data)) {
					for (Object[] objects : data) {
						ProgramDTO programDTO = new ProgramDTO();
						programDTO.setProgramMasterId(((BigInteger) objects[0]).longValue());
						programDTO.setProgramTypeMasterId(((BigInteger) objects[1]).longValue());
//						programDTO.setEligibilityDegreeMasterId(((BigInteger) objects[2]).longValue());
						programDTO.setProgramName(OmsbTmsCommonUtil.getValueByLanguage((String) objects[2],
								OmsbTmsCommonConstants.PROGRAM_NAME, languageCode));
						programDTO.setProgramCode(OmsbTmsCommonUtil.getValueByLanguage((String) objects[3],
								OmsbTmsCommonConstants.PROGRAM_CODE, languageCode));
						programDTO.setProgramType(OmsbTmsCommonUtil.getValueByLanguage((String) objects[4],
								OmsbTmsCommonConstants.PROGRAM_TYPE, languageCode));
//						programDTO.setEligibilityDegree(OmsbTmsCommonUtil.getValueByLanguage((String) objects[6],
//								OmsbTmsCommonConstants.ELIGIBILITY_DEGREE, languageCode));
						programDTO.setProgramObjectives(OmsbTmsCommonUtil.getValueByLanguage((String) objects[5],
								OmsbTmsCommonConstants.PROGRAM_OBJECTIVES, languageCode));
						programDTO.setProgramAdmissionRequirements(
								OmsbTmsCommonUtil.getValueByLanguage((String) objects[6],
										OmsbTmsCommonConstants.PROGRAM_ADMISSION_REQUIREMENTS, languageCode));
						programDTO.setProgramDescription(OmsbTmsCommonUtil.getValueByLanguage((String) objects[7],
								OmsbTmsCommonConstants.PROGRAM_DESCRIPTION, languageCode));
						programDTO.setProgramVision(OmsbTmsCommonUtil.getValueByLanguage((String) objects[8],
								OmsbTmsCommonConstants.PROGRAM_VISION, languageCode));
						programDTO.setProgramMission(OmsbTmsCommonUtil.getValueByLanguage((String) objects[9],
								OmsbTmsCommonConstants.PROGRAM_MISSION, languageCode));
						programDTO.setProgramStatus((Boolean) objects[10]);
						programDTO.setEstablishmentDate((Date) objects[11]);
						programList.add(programDTO);
					}
				}
			} catch (Exception e) {
				_logger.error(e);
			} finally {
				closeSession(session);
			}
		}
		return programList;
	}

	public ProgramDTO getProgramDetails(long programId, String languageCode) {
		ProgramDTO programDTO = new ProgramDTO();
		String sql = customSQL.get(getClass(), OmsbTmsCommonConstants.GET_PROGRAM_DETAILS);
		if (Validator.isNotNull(sql)) {
			Session session = openSession();
			try {
				Query query = session.createSQLQuery(sql);
				query.setCacheable(false);
				QueryPos queryPos = QueryPos.getInstance(query);
				queryPos.add(programId);
				List<Object[]> data = query.list();
				if (Validator.isNotNull(data)) {
					for (Object[] objects : data) {
						programDTO.setProgramMasterId(((BigInteger) objects[0]).longValue());
						programDTO.setProgramTypeMasterId(((BigInteger) objects[1]).longValue());
						programDTO.setEligibilityDegreeMasterId(((BigInteger) objects[2]).longValue());
						programDTO.setProgramName(OmsbTmsCommonUtil.getValueByLanguage((String) objects[3],
								OmsbTmsCommonConstants.PROGRAM_NAME, languageCode));
						programDTO.setProgramCode(OmsbTmsCommonUtil.getValueByLanguage((String) objects[4],
								OmsbTmsCommonConstants.PROGRAM_CODE, languageCode));
						programDTO.setProgramType(OmsbTmsCommonUtil.getValueByLanguage((String) objects[5],
								OmsbTmsCommonConstants.PROGRAM_TYPE, languageCode));
						programDTO.setEligibilityDegree(OmsbTmsCommonUtil.getValueByLanguage((String) objects[6],
								OmsbTmsCommonConstants.ELIGIBILITY_DEGREE, languageCode));
						programDTO.setProgramObjectives(OmsbTmsCommonUtil.getValueByLanguage((String) objects[7],
								OmsbTmsCommonConstants.PROGRAM_OBJECTIVES, languageCode));
						programDTO.setProgramAdmissionRequirements(
								OmsbTmsCommonUtil.getValueByLanguage((String) objects[8],
										OmsbTmsCommonConstants.PROGRAM_ADMISSION_REQUIREMENTS, languageCode));
						programDTO.setProgramDescription(OmsbTmsCommonUtil.getValueByLanguage((String) objects[9],
								OmsbTmsCommonConstants.PROGRAM_DESCRIPTION, languageCode));
						programDTO.setProgramVision(OmsbTmsCommonUtil.getValueByLanguage((String) objects[10],
								OmsbTmsCommonConstants.PROGRAM_VISION, languageCode));
						programDTO.setProgramMission(OmsbTmsCommonUtil.getValueByLanguage((String) objects[11],
								OmsbTmsCommonConstants.PROGRAM_MISSION, languageCode));
						programDTO.setProgramStatus((Boolean) objects[12]);
						programDTO.setEstablishmentDate((Date) objects[13]);
					}
				}
			} catch (Exception e) {
				_logger.error(e);
			} finally {
				closeSession(session);
			}
		}
		return programDTO;
	}

	public List<RotationStructureDTO> getRotationStructure(long rotationId, String languageCode) {
		List<RotationStructureDTO> programList = new ArrayList<>();
		String sql = customSQL.get(getClass(), OmsbTmsCommonConstants.GET_ROTATION_STRUCTURE);
		if (Validator.isNotNull(sql)) {
			Session session = openSession();
			try {

				Query query = session.createSQLQuery(sql);
				query.setCacheable(false);
				QueryPos queryPos = QueryPos.getInstance(query);
				queryPos.add(rotationId);

				List<Object[]> data = query.list();
				if (Validator.isNotNull(data)) {
					for (Object[] objects : data) {
						RotationStructureDTO rotationStructureDTO = new RotationStructureDTO();
						rotationStructureDTO
								.setProgdurationRotationTlBlocksRelId(((BigInteger) objects[0]).longValue());
						rotationStructureDTO.setProgDurationId(((BigInteger) objects[1]).longValue());
						rotationStructureDTO.setRotationId(((BigInteger) objects[2]).longValue());
						rotationStructureDTO.setProgramId(((BigInteger) objects[3]).longValue());
						rotationStructureDTO.setTraineeLevelMasterId(((BigInteger) objects[4]).longValue());
						rotationStructureDTO.setTraineeLevelName(OmsbTmsCommonUtil.getValueByLanguage(
								(String) objects[5], OmsbTmsCommonConstants.TRAINEE_LEVEL_NAME, languageCode));
						rotationStructureDTO.setNoOfBlocks(((Integer) objects[6]).longValue());
						rotationStructureDTO.setProgramName(OmsbTmsCommonUtil.getValueByLanguage((String) objects[7],
								OmsbTmsCommonConstants.PROGRAM_NAME, languageCode));
						programList.add(rotationStructureDTO);
					}
				}
			} catch (Exception e) {
				_logger.info(e);
			} finally {
				closeSession(session);
			}
		}
		return programList;
	}

	public List<TrainingSiteStructureDTO> getTrainingSiteStructure(List<Long> programMasterIds, String programDuration,
			long trainingSiteId, String languageCode) {
		List<TrainingSiteStructureDTO> programList = new ArrayList<>();
		String sql = customSQL.get(getClass(), OmsbTmsCommonConstants.GET_TRAINING_SITE_STRUCTURE);

		if (Validator.isNotNull(sql) && Validator.isNotNull(programMasterIds)) {
			StringBuilder sb = new StringBuilder(sql);
			if (Validator.isNotNull(programMasterIds) && !programMasterIds.isEmpty()) {
				String programIdsString = programMasterIds.stream().map(String::valueOf)
						.collect(Collectors.joining(StringPool.COMMA));
				sb.append(" AND PM1.PROGRAM_MASTER_ID in (" + programIdsString + ")");
			}
			Session session = openSession();
			try {
				Query query = session.createSQLQuery(sb.toString());
				query.setCacheable(false);
				QueryPos queryPos = QueryPos.getInstance(query);
				queryPos.add(trainingSiteId);
				queryPos.add(programDuration);

				List<Object[]> data = query.list();
				if (Validator.isNotNull(data)) {
					for (Object[] objects : data) {
						TrainingSiteStructureDTO trainingSiteStructureDTO = new TrainingSiteStructureDTO();
						trainingSiteStructureDTO.setRotationId(((BigInteger) objects[0]).longValue());
						trainingSiteStructureDTO.setNoOfSlots(((Integer) objects[1]).longValue());
						trainingSiteStructureDTO.setTrainingSiteId(((BigInteger) objects[2]).longValue());
						trainingSiteStructureDTO.setTrainingSiteName(OmsbTmsCommonUtil
								.getValueByLanguage((String) objects[3], "TrainingSiteName", languageCode));
						trainingSiteStructureDTO.setRotationName(OmsbTmsCommonUtil
								.getValueByLanguage((String) objects[4], "RotationName", languageCode));
						trainingSiteStructureDTO.setProgarmName(
								OmsbTmsCommonUtil.getValueByLanguage((String) objects[5], "ProgramName", languageCode));
						programList.add(trainingSiteStructureDTO);
					}
				}
			} catch (Exception e) {
				_logger.info(e);
			} finally {
				closeSession(session);
			}
		}
		return programList;
	}

	public List<ProgramStructureDTO> getProgramStructure(long programDurationId, String languageCode) {
		List<ProgramStructureDTO> programList = new ArrayList<>();
		String sql = customSQL.get(getClass(), OmsbTmsCommonConstants.GET_PROGRAM_STRUCTURE);
		if (Validator.isNotNull(sql)) {
			Session session = openSession();
			try {
				Query query = session.createSQLQuery(sql);
				query.setCacheable(false);
				QueryPos queryPos = QueryPos.getInstance(query);
				queryPos.add(programDurationId);

				List<Object[]> data = query.list();
				if (Validator.isNotNull(data)) {
					for (Object[] objects : data) {
						ProgramStructureDTO programStructureDTO = new ProgramStructureDTO();
						programStructureDTO.setProgDurationRotationTlBlocksRelId(((BigInteger) objects[0]).longValue());
						programStructureDTO.setRotationId(((BigInteger) objects[1]).longValue());
						programStructureDTO.setNoOfBlocks(((Integer) objects[2]).longValue());
						programStructureDTO.setRotationName(OmsbTmsCommonUtil.getValueByLanguage((String) objects[3],
								"RotationName", languageCode));
						programStructureDTO.setTraineeLevelMasterId(((BigInteger) objects[4]).longValue());
						programStructureDTO.setTraineeLevelName((String) objects[5]);
						programStructureDTO.setRotationType(((BigInteger) objects[6]).longValue());
						programList.add(programStructureDTO);
					}
				}
			} catch (Exception e) {
				_logger.info(e);
			} finally {
				closeSession(session);
			}
		}
		return programList;
	}

	public List<SetupProcedureDTO> getSetUpProcedureDetails(String languageCode) {
		List<SetupProcedureDTO> procedureList = new ArrayList<>();
		String sql = customSQL.get(getClass(), OmsbTmsCommonConstants.GET_SETUP_PROCEDURE_DETAILS);
		if (Validator.isNotNull(sql)) {
			Session session = openSession();
			try {
				Query query = session.createSQLQuery(sql);
				query.setCacheable(false);
				List<Object[]> data = query.list();
				if (Validator.isNotNull(data)) {
					for (Object[] objects : data) {
						SetupProcedureDTO setupProcedureDTO = new SetupProcedureDTO();
						setupProcedureDTO
								.setProgdurationRotationTlPgProcedurePtRelId(((BigInteger) objects[0]).longValue());
						setupProcedureDTO.setProgramDuration((String) objects[1]);
						setupProcedureDTO.setTraineeLevel(OmsbTmsCommonUtil.getValueByLanguage((String) objects[2],
								OmsbTmsCommonConstants.TRAINEE_LEVEL_NAME, languageCode));
						setupProcedureDTO.setRotation(OmsbTmsCommonUtil.getValueByLanguage((String) objects[3],
								OmsbTmsCommonConstants.ROTATION_NAME, languageCode));
						setupProcedureDTO.setProcedureGroup(OmsbTmsCommonUtil.getValueByLanguage((String) objects[4],
								OmsbTmsCommonConstants.PROCEDURE_GROUP_NAME, languageCode));
						setupProcedureDTO.setProcedures(OmsbTmsCommonUtil.getValueByLanguage((String) objects[5],
								OmsbTmsCommonConstants.PROCEDURE_NAME, languageCode));
						setupProcedureDTO.setProgramDurationId(((BigInteger) objects[6]).longValue());
						setupProcedureDTO.setCptCode(OmsbTmsCommonUtil.getValueByLanguage((String) objects[7],
								OmsbTmsCommonConstants.CPT_CODE, languageCode));
						if ((Integer) objects[8] != 0) {
							setupProcedureDTO.setMinimumProcedure((Integer) objects[8]);
						}
						if ((Integer) objects[9] != 0) {
							setupProcedureDTO.setTraineeLevelMinimumProcedure((Integer) objects[9]);
						}
						procedureList.add(setupProcedureDTO);
					}
				}
			} catch (Exception e) {
				_logger.info(e);
			} finally {
				closeSession(session);
			}
		}
		return procedureList;
	}

	public List<TraineeLevelListDTO> getTraineeLevelListByDurationId(long durationId) {
		List<TraineeLevelListDTO> traineeLevelList = new ArrayList<>();
		String sql = customSQL.get(getClass(), OmsbTmsCommonConstants.GET_TRAINEE_LEVEL_BY_PD_ID);
		if (Validator.isNotNull(sql)) {
			Session session = openSession();
			try {
				Query query = session.createSQLQuery(sql);
				query.setCacheable(false);
				QueryPos queryPos = QueryPos.getInstance(query);
				queryPos.add(durationId);

				List<Object[]> data = query.list();
				if (Validator.isNotNull(data)) {
					for (Object[] objects : data) {
						TraineeLevelListDTO traineeLevelListDTO = new TraineeLevelListDTO();
						traineeLevelListDTO.setTraineeLevelId(((BigInteger) objects[0]).longValue());
						traineeLevelListDTO.setTraineeLevelName((String) objects[1]);
						traineeLevelList.add(traineeLevelListDTO);
					}
				}
			} catch (Exception e) {
				_logger.info(e);
			} finally {
				closeSession(session);
			}
		}
		return traineeLevelList;
	}

	public List<RotationListDTO> getRotationsByTraineeLevelId(long traineeLevelId, String languageCode) {
		List<RotationListDTO> rotationList = new ArrayList<>();
		String sql = customSQL.get(getClass(), OmsbTmsCommonConstants.GET_ROTATIONS_BY_TL_ID);
		if (Validator.isNotNull(sql)) {
			Session session = openSession();
			try {
				Query query = session.createSQLQuery(sql);
				query.setCacheable(false);
				QueryPos queryPos = QueryPos.getInstance(query);
				queryPos.add(traineeLevelId);

				List<Object[]> data = query.list();
				if (Validator.isNotNull(data)) {
					for (Object[] objects : data) {
						RotationListDTO rotationListDTO = new RotationListDTO();
						rotationListDTO.setRotationMasterId(((BigInteger) objects[0]).longValue());
						rotationListDTO.setRotationName(OmsbTmsCommonUtil.getValueByLanguage((String) objects[1],
								OmsbTmsCommonConstants.ROTATION_NAME, languageCode));
						rotationList.add(rotationListDTO);
					}
				}
			} catch (Exception e) {
				_logger.info(e);
			} finally {
				closeSession(session);
			}
		}
		return rotationList;
	}

	public List<RotationListDTO> getRotationsByTraineeLevelIdAndProgramDurationId(long traineeLevelId,
			long programDurationId, String languageCode) {
		List<RotationListDTO> rotationList = new ArrayList<>();
		String sql = customSQL.get(getClass(), OmsbTmsCommonConstants.GET_ROTATIONS_BY_TL_ID_AND_PROGRAM_DURATION_ID);
		if (Validator.isNotNull(sql)) {
			Session session = openSession();
			try {
				Query query = session.createSQLQuery(sql);
				query.setCacheable(false);
				QueryPos queryPos = QueryPos.getInstance(query);
				queryPos.add(traineeLevelId);
				queryPos.add(programDurationId);

				List<Object[]> data = query.list();
				if (Validator.isNotNull(data)) {
					for (Object[] objects : data) {
						RotationListDTO rotationListDTO = new RotationListDTO();
						rotationListDTO.setRotationMasterId(((BigInteger) objects[0]).longValue());
						rotationListDTO.setRotationName(OmsbTmsCommonUtil.getValueByLanguage((String) objects[1],
								OmsbTmsCommonConstants.ROTATION_NAME, languageCode));
						rotationList.add(rotationListDTO);
					}
				}
			} catch (Exception e) {
				_logger.info(e);
			} finally {
				closeSession(session);
			}
		}
		return rotationList;
	}

	public List<TraineeLoggedProcedureDetailsDTO> getTraineeLoggedProcedureDetailsList(boolean isSuperVisor,
			boolean getByDedicatedProgram, long supervisorId, String programIds, String languageCode) {
		List<TraineeLoggedProcedureDetailsDTO> traineeLoggedProcedureDetailsDTOs = new ArrayList<>();
		String sql;
		if (isSuperVisor) {
			sql = customSQL.get(getClass(),
					OmsbTmsCommonConstants.GET_TRAINEE_LOGGED_PROCEDURE_DETAILS_LIST_BY_SUPPERVISOR);
			sql = sql.replace("$[PROGRAM_IDS]", programIds);
		} else if (getByDedicatedProgram) {
			sql = customSQL.get(getClass(),
					OmsbTmsCommonConstants.GET_TRAINEE_LOGGED_PROCEDURE_DETAILS_LIST_BY_PROGRAM);
			sql = sql.replace("$[PROGRAM_IDS]", programIds);
		} else {
			sql = customSQL.get(getClass(), OmsbTmsCommonConstants.GET_ALL_TRAINEE_LOGGED_PROCEDURE_DETAILS_LIST);
		}
		if (Validator.isNotNull(sql)) {
			Session session = openSession();
			try {
				Query query = session.createSQLQuery(sql);
				query.setCacheable(false);
				QueryPos queryPogetTraineeLoggedProcedureDetailsListBySupervisors = QueryPos.getInstance(query);
				if (isSuperVisor) {
					queryPogetTraineeLoggedProcedureDetailsListBySupervisors.add(supervisorId);
				}
				List<Object[]> data = query.list();
				if (Validator.isNotNull(data)) {
					for (Object[] objects : data) {
						TraineeLoggedProcedureDetailsDTO traineeLoggedProcedureDetailsDTO = new TraineeLoggedProcedureDetailsDTO();
						traineeLoggedProcedureDetailsDTO
								.setTraineeLoggedProcedureDetailsId(((BigInteger) objects[0]).longValue());
						traineeLoggedProcedureDetailsDTO.setTraineeId(((BigInteger) objects[1]).longValue());
						traineeLoggedProcedureDetailsDTO.setPatientId((String) objects[2]);
						traineeLoggedProcedureDetailsDTO.setTrainingSiteName(OmsbTmsCommonUtil
								.getValueByLanguage((String) objects[3], "TrainingSiteName", languageCode));
						traineeLoggedProcedureDetailsDTO.setRoleTypeName(OmsbTmsCommonUtil
								.getValueByLanguage((String) objects[4], "RoleTypeName", languageCode));
						traineeLoggedProcedureDetailsDTO.setProcedurePerformedDate((Date) objects[5]);
						traineeLoggedProcedureDetailsDTO.setDiagnosisDescription(OmsbTmsCommonUtil.getValueByLanguage(
								(String) objects[6], OmsbTmsCommonConstants.PROGRAM_NAME, languageCode));
						traineeLoggedProcedureDetailsDTO.setProcedureStatus((String) objects[7]);
						traineeLoggedProcedureDetailsDTO.setProcedureName(OmsbTmsCommonUtil.getValueByLanguage(
								(String) objects[8], OmsbTmsCommonConstants.PROCEDURE_NAME, languageCode));
						traineeLoggedProcedureDetailsDTO.setCptCode((String) objects[9]);
						traineeLoggedProcedureDetailsDTO.setProcedureGroupName(OmsbTmsCommonUtil.getValueByLanguage(
								(String) objects[10], OmsbTmsCommonConstants.PROCEDURE_GROUP_NAME, languageCode));
						traineeLoggedProcedureDetailsDTO
								.setProgramName(OmsbTmsCommonUtil.getValueByLanguage((String) objects[11],
										OmsbTmsCommonConstants.PROGRAM_NAME, languageCode) + StringPool.SPACE
										+ StringPool.OPEN_PARENTHESIS + (String) objects[12]
										+ StringPool.CLOSE_PARENTHESIS);
						traineeLoggedProcedureDetailsDTOs.add(traineeLoggedProcedureDetailsDTO);
					}
				}
			} catch (Exception e) {
				_logger.error(e);
			} finally {
				closeSession(session);
			}
		}
		return traineeLoggedProcedureDetailsDTOs;
	}

	public TraineeLoggedProcedureDetailsDTO getTraineeLoggedProcedureDetail(long supervisorId,
			long traineeLoggedProcedureDetailsId, String languageCode) {
		List<TraineeLoggedProcedureDetailsDTO> traineeLoggedProcedureDetailsDTOs = new ArrayList<>();
		String sql = customSQL.get(getClass(),
				OmsbTmsCommonConstants.GET_TRAINEE_LOGGED_PROCEDURE_DETAIL_BY_SUPPERVISOR_AND_TRAINEE_LOGGED_PROCEDURE_DETAIL_ID);
		if (Validator.isNotNull(sql)) {
			Session session = openSession();
			try {
				Query query = session.createSQLQuery(sql);
				query.setCacheable(false);
				QueryPos queryPogetTraineeLoggedProcedureDetailsListBySupervisors = QueryPos.getInstance(query);
				queryPogetTraineeLoggedProcedureDetailsListBySupervisors.add(supervisorId);
				queryPogetTraineeLoggedProcedureDetailsListBySupervisors.add(traineeLoggedProcedureDetailsId);

				List<Object[]> data = query.list();
				if (Validator.isNotNull(data)) {
					for (Object[] objects : data) {
						TraineeLoggedProcedureDetailsDTO traineeLoggedProcedureDetailsDTO = new TraineeLoggedProcedureDetailsDTO();
						traineeLoggedProcedureDetailsDTO
								.setTraineeLoggedProcedureDetailsId(((BigInteger) objects[0]).longValue());
						traineeLoggedProcedureDetailsDTO.setTraineeId(((BigInteger) objects[1]).longValue());
						traineeLoggedProcedureDetailsDTO.setPatientId((String) objects[2]);
						traineeLoggedProcedureDetailsDTO.setTrainingSiteName(OmsbTmsCommonUtil
								.getValueByLanguage((String) objects[3], "TrainingSiteName", languageCode));
						traineeLoggedProcedureDetailsDTO.setRoleTypeName(OmsbTmsCommonUtil
								.getValueByLanguage((String) objects[4], "RoleTypeName", languageCode));
						traineeLoggedProcedureDetailsDTO.setProcedurePerformedDate((Date) objects[5]);
						traineeLoggedProcedureDetailsDTO.setDiagnosisDescription(OmsbTmsCommonUtil
								.getValueByLanguage((String) objects[6], "DiagnosisDescription", languageCode));
						traineeLoggedProcedureDetailsDTO.setProcedureStatus((String) objects[7]);
						traineeLoggedProcedureDetailsDTO.setProcedureName(OmsbTmsCommonUtil
								.getValueByLanguage((String) objects[8], "ProcedureName", languageCode));
						traineeLoggedProcedureDetailsDTOs.add(traineeLoggedProcedureDetailsDTO);
					}
				}
			} catch (Exception e) {
				_logger.error(e);
			} finally {
				closeSession(session);
			}
		}
		if (Validator.isNotNull(traineeLoggedProcedureDetailsDTOs) && !traineeLoggedProcedureDetailsDTOs.isEmpty()) {
			return traineeLoggedProcedureDetailsDTOs.get(0);
		} else {
			return null;
		}
	}

	public List<ProgramStructureDTO> getTraineeLevel(long programMasterId) {
		List<ProgramStructureDTO> programList = new ArrayList<>();
		String sql = customSQL.get(getClass(), OmsbTmsCommonConstants.GET_TRAINEE_LEVEL);
		if (Validator.isNotNull(sql)) {
			Session session = openSession();
			try {
				Query query = session.createSQLQuery(sql);
				query.setCacheable(false);
				QueryPos queryPos = QueryPos.getInstance(query);
				queryPos.add(programMasterId);

				List<Object[]> traineeLevelData = query.list();
				_logger.info("size of query list::" + traineeLevelData.size());
				if (!traineeLevelData.isEmpty()) {
					for (Object[] traineeLevel : traineeLevelData) {
						ProgramStructureDTO programStructureDTO = new ProgramStructureDTO();
						programStructureDTO.setTraineeLevelName((String) traineeLevel[0]);
						programStructureDTO.setTraineeLevelMasterId(((BigInteger) traineeLevel[1]).longValue());
						programList.add(programStructureDTO);
					}
				}
				_logger.info("traineeLevels::" + programList.size());
			} catch (Exception e) {
				_logger.info(e);
			} finally {
				closeSession(session);
			}
		}
		_logger.info("getTraineeLevel() ended");
		return programList;
	}

	public List<ProgramCohortDTO> getProgramCohorts(List<Long> programIds, List<String> yearRange,
			String languageCode) {
		List<ProgramCohortDTO> programCohortDTOs = new ArrayList<>();
		String sql = customSQL.get(getClass(), OmsbTmsCommonConstants.GET_PROGRAM_COHORTS);
		if (Validator.isNotNull(sql) && Validator.isNotNull(programIds)) {
			StringBuilder sb = new StringBuilder(sql);
			if (Validator.isNotNull(programIds) && !programIds.isEmpty()) {
				String programIdsString = programIds.stream().map(String::valueOf)
						.collect(Collectors.joining(StringPool.COMMA));
				sb.append(" and pm.program_master_id in (" + programIdsString + ")");
			}

			if (Validator.isNotNull(yearRange) && !yearRange.isEmpty()) {
				String yearRangeString = yearRange.stream().map(String::valueOf)
						.collect(Collectors.joining(StringPool.APOSTROPHE + StringPool.COMMA + StringPool.APOSTROPHE));
				sb.append(" and pdd.ay_applicable_form in ('" + yearRangeString + "')");
			}

			Session session = openSession();
			try {
				Query query = session.createSQLQuery(sb.toString());
				query.setCacheable(false);
				@SuppressWarnings("unchecked")
				List<Object[]> programCohortData = query.list();
				if (!programCohortData.isEmpty()) {
					for (Object[] objects : programCohortData) {
						ProgramCohortDTO programCohortDTO = new ProgramCohortDTO();
						programCohortDTO.setProgdurationTlBlocksLtId(((BigInteger) objects[0]).longValue());
						programCohortDTO.setProgramName(
								OmsbTmsCommonUtil.getValueByLanguage((String) objects[1], "ProgramName", languageCode));
						programCohortDTO.setAyApplicableForm((String) objects[2]);
						programCohortDTO.setNoOfBlocks(((Integer) objects[3]).longValue());
						programCohortDTO.setTraineeLevelName(OmsbTmsCommonUtil.getValueByLanguage((String) objects[4],
								OmsbTmsCommonConstants.TRAINEE_LEVEL_NAME, languageCode));
						programCohortDTO.setLevelTypeName(OmsbTmsCommonUtil.getValueByLanguage((String) objects[5],
								OmsbTmsCommonConstants.LEVEL_TYPE_NAME, languageCode));
						programCohortDTO.setProgramMasterId(((BigInteger) objects[6]).longValue());
						programCohortDTO.setProgramDurationId(((BigInteger) objects[7]).longValue());
						programCohortDTO.setModifiedDate((Date) objects[8]);
						programCohortDTO.setTraineeLevelId(((BigInteger) objects[9]).longValue());
						programCohortDTOs.add(programCohortDTO);
					}
				}
			} catch (Exception e) {
				_logger.info(e);
			} finally {
				closeSession(session);
			}
		}
		return programCohortDTOs;
	}

	public List<SiteCapacityDTO> getSiteCapacityDetails(String languageCode) {
		List<SiteCapacityDTO> setupCapacityList = new ArrayList<>();
		String sql = customSQL.get(getClass(), OmsbTmsCommonConstants.GET_SITE_CAPACITY_DETAILS);
		if (Validator.isNotNull(sql)) {
			Session session = openSession();
			try {
				Query query = session.createSQLQuery(sql);
				query.setCacheable(false);
				List<Object[]> data = query.list();
				if (Validator.isNotNull(data)) {
					for (Object[] objects : data) {
						SiteCapacityDTO siteCapacityDTO = new SiteCapacityDTO();
						siteCapacityDTO.setProgdurationRotationTsRelId(((BigInteger) objects[0]).longValue());
						siteCapacityDTO.setTrainingSite(OmsbTmsCommonUtil.getValueByLanguage((String) objects[1],
								OmsbTmsCommonConstants.TRAINING_SITE_NAME, languageCode));
						siteCapacityDTO.setRotation(OmsbTmsCommonUtil.getValueByLanguage((String) objects[2],
								OmsbTmsCommonConstants.ROTATION_NAME, languageCode));
						siteCapacityDTO.setNoOfSlots((Integer) objects[3]);
						siteCapacityDTO.setCohort((String) objects[4]);
						siteCapacityDTO.setCohortId(((BigInteger) objects[5]).longValue());
						setupCapacityList.add(siteCapacityDTO);
					}
				}
			} catch (Exception e) {
				_logger.info(e);
			} finally {
				closeSession(session);
			}
		}
		return setupCapacityList;
	}

	public List<Long> getSharedRotationIdForApprover(long userId) {
		List<Long> sharedRotationIds = new ArrayList<>();
		String sql = customSQL.get(getClass(), OmsbTmsCommonConstants.GET_SHARED_ROTATIONS_ID_FOR_APPROVER);
		if (Validator.isNotNull(sql)) {
			Session session = openSession();
			try {
				Query query = session.createSQLQuery(sql);
				query.setCacheable(false);
				QueryPos queryPos = QueryPos.getInstance(query);
				queryPos.add(String.valueOf(userId));

				List<BigInteger> data = query.list();
				for (BigInteger objects : data) {
					sharedRotationIds.add(objects.longValue());
				}
			} catch (Exception e) {
				_logger.error(e);
			} finally {
				closeSession(session);
			}
		}
		return sharedRotationIds;
	}

	public List<ConfigureRotationDetailsDTO> getConfigureRotationDetails(String languageCode) {
		List<ConfigureRotationDetailsDTO> configureRotationList = new ArrayList<>();
		String sql = customSQL.get(getClass(), OmsbTmsCommonConstants.GET_CONFIGURE_ROTATION_DETAILS);
		if (Validator.isNotNull(sql)) {
			Session session = openSession();
			try {
				Query query = session.createSQLQuery(sql);
				query.setCacheable(false);
				List<Object[]> data = query.list();
				if (Validator.isNotNull(data)) {
					for (Object[] objects : data) {
						ConfigureRotationDetailsDTO configureRotationDto = new ConfigureRotationDetailsDTO();
						configureRotationDto
								.setProgdurationRotationTlBlocksRelId(((BigInteger) objects[0]).longValue());
						configureRotationDto.setProgramName(OmsbTmsCommonUtil.getValueByLanguage((String) objects[1],
								OmsbTmsCommonConstants.PROGRAM_NAME, languageCode));
						configureRotationDto.setProgramDuration((String) objects[2]);
						configureRotationDto.setTraineeLevelName(OmsbTmsCommonUtil.getValueByLanguage(
								(String) objects[3], OmsbTmsCommonConstants.TRAINEE_LEVEL_NAME, languageCode));
						configureRotationDto.setRotationName(OmsbTmsCommonUtil.getValueByLanguage((String) objects[4],
								OmsbTmsCommonConstants.ROTATION_NAME, languageCode));
						configureRotationDto.setRotationTypeName(OmsbTmsCommonUtil.getValueByLanguage(
								(String) objects[5], OmsbTmsCommonConstants.ROTATION_TYPE, languageCode));
						configureRotationDto.setNoOfBlocks(((Integer) objects[6]).intValue());

						configureRotationList.add(configureRotationDto);
					}
				}
			} catch (Exception e) {
				_logger.info(e);
			} finally {
				closeSession(session);
			}
		}
		return configureRotationList;
	}

	public List<ConfigureRotationEditDetailsDTO> getConfigureRotationDetailsByProgramAndDuration(long programId,
			long traineeLevelId, long programDurationId) {
		List<ConfigureRotationEditDetailsDTO> configureRotationList = new ArrayList<>();
		String sql = customSQL.get(getClass(), OmsbTmsCommonConstants.GET_CONFIGURE_ROTATION_EDIT_DETAILS);
		if (Validator.isNotNull(sql)) {
			Session session = openSession();
			try {
				Query query = session.createSQLQuery(sql);
				query.setCacheable(false);
				QueryPos queryPos = QueryPos.getInstance(query);
				queryPos.add(programId);
				queryPos.add(traineeLevelId);
				queryPos.add(programDurationId);
				List<Object[]> data = query.list();
				if (Validator.isNotNull(data)) {
					for (Object[] objects : data) {
						ConfigureRotationEditDetailsDTO configureRotationDto = new ConfigureRotationEditDetailsDTO();
						configureRotationDto
								.setProgdurationRotationTlBlocksRelId(((BigInteger) objects[0]).longValue());
						configureRotationDto.setRotationId(((BigInteger) objects[1]).longValue());
						configureRotationDto.setProgramDurationId(((BigInteger) objects[2]).longValue());
						configureRotationDto.setTraineeLevelId(((BigInteger) objects[3]).longValue());
						configureRotationDto.setRotationTypeId(((BigInteger) objects[4]).longValue());
						configureRotationDto.setNoOfBlocks(((Integer) objects[5]));

						configureRotationList.add(configureRotationDto);
					}
				}
			} catch (Exception e) {
				_logger.info(e);
			} finally {
				closeSession(session);
			}
		}
		return configureRotationList;
	}

	public List<ProgramCohortDTO> getProgramAndCohortsFromProgramDuration(List<Long> programIds, List<String> yearRange,
			String languageCode) {
		List<ProgramCohortDTO> programCohortDTOs = new ArrayList<>();
		String sql = customSQL.get(getClass(), OmsbTmsCommonConstants.GET_PROGRAM_AND_COHORTS_FROM_PROGRAM_DURATION);
		if (Validator.isNotNull(sql)) {

			StringBuilder sb = new StringBuilder(sql);
			if (Validator.isNotNull(programIds) && !programIds.isEmpty()) {
				String programIdsString = programIds.stream().map(String::valueOf)
						.collect(Collectors.joining(StringPool.COMMA));
				sb.append(" and pm.program_master_id in (" + programIdsString + ")");
			}

			if (Validator.isNotNull(yearRange) && !yearRange.isEmpty()) {
				String yearRangeString = yearRange.stream().map(String::valueOf)
						.collect(Collectors.joining(StringPool.APOSTROPHE + StringPool.COMMA + StringPool.APOSTROPHE));
				sb.append(" and pdd.ay_applicable_form in ('" + yearRangeString + "')");
			}

			Session session = openSession();
			try {
				Query query = session.createSQLQuery(sb.toString());
				query.setCacheable(false);
				@SuppressWarnings("unchecked")
				List<Object[]> programCohortData = query.list();
				if (!programCohortData.isEmpty()) {
					for (Object[] objects : programCohortData) {
						ProgramCohortDTO programCohortDTO = new ProgramCohortDTO();
						programCohortDTO.setProgramName(
								OmsbTmsCommonUtil.getValueByLanguage((String) objects[0], "ProgramName", languageCode));
						programCohortDTO.setAyApplicableForm((String) objects[1]);
						programCohortDTO.setNoOfBlocks(((Integer) objects[2]).longValue());
						programCohortDTO.setProgramMasterId(((BigInteger) objects[3]).longValue());
						programCohortDTO.setProgramName(
								programCohortDTO.getProgramName() + "(" + programCohortDTO.getAyApplicableForm() + ")");
						programCohortDTO.setProgramDurationId(((BigInteger) objects[4]).longValue());
						programCohortDTOs.add(programCohortDTO);
					}
				}
			} catch (Exception e) {
				_logger.info(e);
			} finally {
				closeSession(session);
			}
		}
		return programCohortDTOs;
	}

	public List<ProgramCohortDTO> getProgramCohortsRelationalDataByProgramDurationId(long programDurationId,
			String languageCode) {
		List<ProgramCohortDTO> programCohortDTOs = new ArrayList<>();
		String sql = customSQL.get(getClass(), OmsbTmsCommonConstants.GET_PROGRAM_COHORTS);
		if (Validator.isNotNull(sql) && Validator.isNotNull(programDurationId)) {
			StringBuilder sb = new StringBuilder(sql);
			sb.append(" and ptblr.program_duration_id =" + programDurationId);
			Session session = openSession();
			try {
				Query query = session.createSQLQuery(sb.toString());
				query.setCacheable(false);
				@SuppressWarnings("unchecked")
				List<Object[]> programCohortData = query.list();
				if (!programCohortData.isEmpty()) {
					for (Object[] objects : programCohortData) {
						ProgramCohortDTO programCohortDTO = new ProgramCohortDTO();
						programCohortDTO.setProgdurationTlBlocksLtId(((BigInteger) objects[0]).longValue());
						programCohortDTO.setProgramName(
								OmsbTmsCommonUtil.getValueByLanguage((String) objects[1], "ProgramName", languageCode));
						programCohortDTO.setAyApplicableForm((String) objects[2]);
						programCohortDTO.setNoOfBlocks(((Integer) objects[3]).longValue());
						programCohortDTO.setTraineeLevelName(OmsbTmsCommonUtil.getValueByLanguage((String) objects[4],
								OmsbTmsCommonConstants.TRAINEE_LEVEL_NAME, languageCode));
						programCohortDTO.setLevelTypeName(OmsbTmsCommonUtil.getValueByLanguage((String) objects[5],
								OmsbTmsCommonConstants.LEVEL_TYPE_NAME, languageCode));
						programCohortDTO.setProgramMasterId(((BigInteger) objects[6]).longValue());
						programCohortDTO.setProgramDurationId(((BigInteger) objects[7]).longValue());
						programCohortDTO.setModifiedDate((Date) objects[8]);
						programCohortDTO.setProgramName(
								programCohortDTO.getProgramName() + "(" + programCohortDTO.getAyApplicableForm() + ")");
						programCohortDTO.setTraineeLevelId(((BigInteger) objects[9]).longValue());
						programCohortDTOs.add(programCohortDTO);
					}
				}
			} catch (Exception e) {
				_logger.info(e);
			} finally {
				closeSession(session);
			}
		}
		return programCohortDTOs;
	}

	public List<TrainingSiteByPdDTO> getTrainingSitesByProgramDuration(long programId, String programDuration,
			String languageCode) {
		List<TrainingSiteByPdDTO> trainingSiteList = new ArrayList<>();
		String sql = customSQL.get(getClass(), OmsbTmsCommonConstants.GET_TRAINING_SITES_BY_PD);
		if (Validator.isNotNull(sql)) {
			Session session = openSession();
			try {
				Query query = session.createSQLQuery(sql);
				query.setCacheable(false);
				QueryPos queryPos = QueryPos.getInstance(query);
				queryPos.add(programId);
				queryPos.add(programDuration);

				List<Object[]> data = query.list();
				if (Validator.isNotNull(data)) {
					for (Object[] objects : data) {
						TrainingSiteByPdDTO trainingSiteByPdDTO = new TrainingSiteByPdDTO();
						trainingSiteByPdDTO.setTrainingSiteId(((BigInteger) objects[0]).longValue());
						trainingSiteByPdDTO.setTrainingSiteName(OmsbTmsCommonUtil.getValueByLanguage(
								(String) objects[1], OmsbTmsCommonConstants.TRAINING_SITE_NAME, languageCode));
						trainingSiteList.add(trainingSiteByPdDTO);
					}
				}
			} catch (Exception e) {
				_logger.info(e);
			} finally {
				closeSession(session);
			}
		}
		return trainingSiteList;
	}

	public List<TrainingSitesCapacityDTO> getProgramTrainingSitesCapacityDetails(String languageCode) {
		List<TrainingSitesCapacityDTO> trainingSitesCapacityList = new ArrayList<>();
		String sql = customSQL.get(getClass(), OmsbTmsCommonConstants.GET_TRAINING_SITES_CAPACITY_DETAILS);
		if (Validator.isNotNull(sql)) {
			Session session = openSession();
			try {
				Query query = session.createSQLQuery(sql);
				query.setCacheable(false);

				List<Object[]> data = query.list();
				if (Validator.isNotNull(data)) {
					for (Object[] objects : data) {
						TrainingSitesCapacityDTO trainingSitesCapacityDTO = new TrainingSitesCapacityDTO();
						trainingSitesCapacityDTO.setProgdurationRotationTsRelId(((BigInteger) objects[0]).longValue());
						trainingSitesCapacityDTO.setTrainingSiteId(((BigInteger) objects[1]).longValue());
						trainingSitesCapacityDTO.setTrainingSiteName(OmsbTmsCommonUtil.getValueByLanguage(
								(String) objects[2], OmsbTmsCommonConstants.TRAINING_SITE_NAME, languageCode));
						trainingSitesCapacityDTO.setRotationName(OmsbTmsCommonUtil.getValueByLanguage(
								(String) objects[3], OmsbTmsCommonConstants.ROTATION_NAME, languageCode));
						trainingSitesCapacityDTO.setNoOfSlots((Integer) objects[4]);
						trainingSitesCapacityList.add(trainingSitesCapacityDTO);
					}
				}
			} catch (Exception e) {
				_logger.info(e);
			} finally {
				closeSession(session);
			}
		}
		return trainingSitesCapacityList;
	}

	public List<RotationListDTO> getRotationsByTrainingSitesId(long trainingSiteId, String languageCode) {
		List<RotationListDTO> rotationList = new ArrayList<>();
		String sql = customSQL.get(getClass(), OmsbTmsCommonConstants.GET_ROTATIONS_BY_TS_ID);
		if (Validator.isNotNull(sql)) {
			Session session = openSession();
			try {
				Query query = session.createSQLQuery(sql);
				query.setCacheable(false);
				QueryPos queryPos = QueryPos.getInstance(query);
				queryPos.add(trainingSiteId);
				List<Object[]> data = query.list();
				if (Validator.isNotNull(data)) {
					for (Object[] objects : data) {
						RotationListDTO rotationListDTO = new RotationListDTO();
						rotationListDTO.setRotationMasterId(((BigInteger) objects[0]).longValue());
						rotationListDTO.setRotationName(OmsbTmsCommonUtil.getValueByLanguage((String) objects[1],
								OmsbTmsCommonConstants.ROTATION_NAME, languageCode));
						rotationList.add(rotationListDTO);
					}
				}
			} catch (Exception e) {
				_logger.info(e);
			} finally {
				closeSession(session);
			}
		}
		return rotationList;
	}

	public List<ProgdurationRotationTrainingSiteDTO> getProgdurationRotationByRotationAndDuration(long rotationId,
			String duration, String languageCode) {
		List<ProgdurationRotationTrainingSiteDTO> progdurationRotationTrainingSiteDTOs = new ArrayList<>();
		String sql = customSQL.get(getClass(),
				OmsbTmsCommonConstants.GET_PROGDURATION_ROTATION_BY_ROTATION_AND_DURATION);
		if (Validator.isNotNull(sql)) {
			Session session = openSession();
			try {
				Query query = session.createSQLQuery(sql);
				query.setCacheable(false);
				QueryPos queryPos = QueryPos.getInstance(query);
				queryPos.add(rotationId);
				queryPos.add(duration);
				List<Object[]> data = query.list();
				if (Validator.isNotNull(data)) {
					for (Object[] objects : data) {
						ProgdurationRotationTrainingSiteDTO progdurationRotationTrainingSiteDTO = new ProgdurationRotationTrainingSiteDTO();
						progdurationRotationTrainingSiteDTO.setRotationId(((BigInteger) objects[0]).longValue());
						progdurationRotationTrainingSiteDTO.setNoOfSlots(((Integer) objects[1]));
						progdurationRotationTrainingSiteDTO.setTrainingSiteId(((BigInteger) objects[2]).longValue());
						progdurationRotationTrainingSiteDTO.setProgDurationId(((BigInteger) objects[3]).longValue());
						progdurationRotationTrainingSiteDTOs.add(progdurationRotationTrainingSiteDTO);
					}
				}
			} catch (Exception e) {
				_logger.info(e);
			} finally {
				closeSession(session);
			}
		}
		return progdurationRotationTrainingSiteDTOs;
	}

	public ConfigureRotationBlockDetailsDTO getConfigureRotationDetailsByRotationAndDuration(long rotationId,
			String duration) {
		ConfigureRotationBlockDetailsDTO configureRotationDto = new ConfigureRotationBlockDetailsDTO();
		String sql = customSQL.get(getClass(),
				OmsbTmsCommonConstants.GET_CONFIGURE_ROTATION_DETAILS_BY_ROTATION_AND_DURATION);
		if (Validator.isNotNull(sql)) {
			Session session = openSession();
			try {
				Query query = session.createSQLQuery(sql);
				query.setCacheable(false);
				QueryPos queryPos = QueryPos.getInstance(query);
				queryPos.add(rotationId);
				queryPos.add(duration);
				List<Object> data = query.list();
				if (Validator.isNotNull(data) && !data.isEmpty()) {
					for (Object objects : data) {
						configureRotationDto.setNoOfBlocks(((BigInteger) objects).longValue());
					}
				}
			} catch (Exception e) {
				_logger.info(e);
			} finally {
				closeSession(session);
			}
		}
		return configureRotationDto;
	}

	public List<TrainingSiteByPdDTO> getTrainingSitesByCohort(long programDuration, String languageCode) {
		List<TrainingSiteByPdDTO> trainingSiteList = new ArrayList<>();
		String sql = customSQL.get(getClass(), OmsbTmsCommonConstants.GET_TRAINING_SITES_BY_COHORT);
		if (Validator.isNotNull(sql)) {
			Session session = openSession();
			try {
				Query query = session.createSQLQuery(sql);
				query.setCacheable(false);
				QueryPos queryPos = QueryPos.getInstance(query);
				queryPos.add(programDuration);

				List<Object[]> data = query.list();
				if (Validator.isNotNull(data)) {
					for (Object[] objects : data) {
						TrainingSiteByPdDTO trainingSiteByPdDTO = new TrainingSiteByPdDTO();
						trainingSiteByPdDTO.setTrainingSiteId(((BigInteger) objects[0]).longValue());
						trainingSiteByPdDTO.setTrainingSiteName(OmsbTmsCommonUtil.getValueByLanguage(
								(String) objects[1], OmsbTmsCommonConstants.TRAINING_SITE_NAME, languageCode));
						trainingSiteList.add(trainingSiteByPdDTO);
					}
				}
			} catch (Exception e) {
				_logger.info(e);
			} finally {
				closeSession(session);
			}
		}
		return trainingSiteList;
	}

	public List<RotationListDTO> getNotSharedRotationsByTrainingSitesId(long trainingSiteId, String languageCode) {
		List<RotationListDTO> rotationList = new ArrayList<>();
		String sql = customSQL.get(getClass(), OmsbTmsCommonConstants.GET_NOT_SHARED_ROTATION_BY_TS_ID);
		if (Validator.isNotNull(sql)) {
			Session session = openSession();
			try {
				Query query = session.createSQLQuery(sql);
				query.setCacheable(false);
				QueryPos queryPos = QueryPos.getInstance(query);
				queryPos.add(trainingSiteId);
				List<Object[]> data = query.list();
				if (Validator.isNotNull(data)) {
					for (Object[] objects : data) {
						RotationListDTO rotationListDTO = new RotationListDTO();
						rotationListDTO.setRotationMasterId(((BigInteger) objects[0]).longValue());
						rotationListDTO.setRotationName(OmsbTmsCommonUtil.getValueByLanguage((String) objects[1],
								OmsbTmsCommonConstants.ROTATION_NAME, languageCode));
						rotationList.add(rotationListDTO);
					}
				}
			} catch (Exception e) {
				_logger.info(e);
			} finally {
				closeSession(session);
			}
		}
		return rotationList;
	}

	public List<ECMembershipRequestListDTO> getECMembershipRequestData(long programId, long roleId, long statusId,
			long potentialEcMemberLrUserid, String languageCode) {
		List<ECMembershipRequestListDTO> eCMembershipDataDTO = new ArrayList<>();
		String sql = customSQL.get(getClass(), OmsbTmsCommonConstants.GET_EC_MEMBERSHIP_REQUEST_DATA);
		if (Validator.isNotNull(sql)) {
			Session session = openSession();
			StringBuilder sb = new StringBuilder();
			String and = "";

			try {
				if (programId > 0) {
					sb.append(" pm.program_master_id = " + programId);
					and = " and ";
				}
				if (roleId > 0) {
					sb.append(and);
					sb.append(" r.roleid = " + roleId);
					and = " and ";
				}
				if (statusId > 0) {
					sb.append(and);
					sb.append(" emrst.ec_member_request_status_id  = " + statusId);
					and = " and ";
				}
				if (potentialEcMemberLrUserid > 0) {
					sb.append(and);
					sb.append(" emr.potential_ec_member_lruserid =" + potentialEcMemberLrUserid);
				}

				if (sb.length() > 0) {
					sql = sql + " where " + sb.toString();
				}
				sql = sql + " order by emr.ec_member_request_id desc ;";
				Query query = session.createSQLQuery(sql);
				query.setCacheable(false);
				QueryPos queryPos = QueryPos.getInstance(query);
				List<Object[]> data = query.list();
				if (Validator.isNotNull(data)) {
					for (Object[] objects : data) {
						ECMembershipRequestListDTO eCMembershipRequestListDTO = new ECMembershipRequestListDTO();
						eCMembershipRequestListDTO.setProgram(OmsbTmsCommonUtil.getValueByLanguage((String) objects[0],
								OmsbTmsCommonConstants.PROGRAM_NAME, languageCode));
						eCMembershipRequestListDTO.setPotentialECMember((String) objects[1]);
						eCMembershipRequestListDTO.setRole((String) objects[2]);
						
						String status = null;
						if(languageCode.equalsIgnoreCase("ar_SA")){
							status = (String) objects[4];
						}
						
						if(status == null || status.isBlank() ){
							status = (String) objects[3];
						}
						
						eCMembershipRequestListDTO.setStatus(status);
						
						BigInteger requestId = (BigInteger) objects[5];
						eCMembershipRequestListDTO.setEcMemberRequestId(requestId.longValue());
						eCMembershipRequestListDTO.setBankDetailsId(((BigInteger) objects[6]).longValue());
						eCMembershipRequestListDTO.setPassportCopyId(((BigInteger) objects[7]).longValue());
						eCMembershipRequestListDTO.setNationalIdCopyId(((BigInteger) objects[8]).longValue());
						eCMembershipRequestListDTO.setStatusCode((String) objects[9]);
						eCMembershipRequestListDTO.setStateId(((BigInteger) objects[10]).longValue());
						eCMembershipDataDTO.add(eCMembershipRequestListDTO);
					}
				}
			} catch (Exception e) {
				_logger.error(e);
			} finally {
				closeSession(session);
			}
		}
		return eCMembershipDataDTO;
	}

	public List<ECMembershipRequestStateDTO> getECMembershipRequestStateData(long emMemberRequestId) {
		List<ECMembershipRequestStateDTO> eCMembershipStateData = new ArrayList<>();
		String sql = customSQL.get(getClass(), OmsbTmsCommonConstants.GET_EC_MEMBERSHIP_REQUEST_State_DATA);
		if (Validator.isNotNull(sql)) {
			Session session = openSession();
			try {
				Query query = session.createSQLQuery(sql);
				QueryPos queryPos = QueryPos.getInstance(query);
				queryPos.add(emMemberRequestId);
				query.setCacheable(false);
				List<Object[]> data = query.list();
				if (Validator.isNotNull(data)) {
					for (Object[] objects : data) {
						ECMembershipRequestStateDTO eCMembershipRequestStateDTO = new ECMembershipRequestStateDTO();
						eCMembershipRequestStateDTO.setCreateDate((Date) objects[0]);
						eCMembershipRequestStateDTO.setPotentialECMember((String) objects[1]);
						eCMembershipRequestStateDTO.setComments((String) objects[2]);
						eCMembershipStateData.add(eCMembershipRequestStateDTO);
					}
				}
			} catch (Exception e) {
				_logger.error(e);
			} finally {
				closeSession(session);
			}
		}
		return eCMembershipStateData;

	}

	public List<TrainingSiteByProgramDTO> getTrainingSiteDetailsByProgram(long programId, String languageCode) {
		List<TrainingSiteByProgramDTO> trainingSiteByProgramDTOs = new ArrayList<>();
		String sql = customSQL.get(getClass(), OmsbTmsCommonConstants.GET_TRAINING_SITE_DETAILS_BY_PROGRAM);
		if (Validator.isNotNull(sql)) {
			Session session = openSession();
			try {
				Query query = session.createSQLQuery(sql);
				query.setCacheable(false);
				QueryPos queryPos = QueryPos.getInstance(query);
				queryPos.add(programId);

				List<Object[]> data = query.list();
				if (Validator.isNotNull(data)) {
					for (Object[] objects : data) {
						TrainingSiteByProgramDTO trainingSiteByProgramDTO = new TrainingSiteByProgramDTO();
						trainingSiteByProgramDTO.setTrainingSiteId(((BigInteger) objects[0]).longValue());
						trainingSiteByProgramDTO.setTrainingSiteName(OmsbTmsCommonUtil.getValueByLanguage(
								(String) objects[1], OmsbTmsCommonConstants.TRAINING_SITE_NAME, languageCode));
						trainingSiteByProgramDTO.setProgramName(OmsbTmsCommonUtil.getValueByLanguage(
								(String) objects[2], OmsbTmsCommonConstants.PROGRAM_NAME, languageCode));
						trainingSiteByProgramDTOs.add(trainingSiteByProgramDTO);
					}
				}
			} catch (Exception e) {
				_logger.info(e);
			} finally {
				closeSession(session);
			}
		}
		return trainingSiteByProgramDTOs;
	}

	public List<FacultySiteCompensationDTO> getFacultySiteCompensationReportDetailsOfEcMember(String languageCode,
			long programId) {
		List<FacultySiteCompensationDTO> facultySiteCompensationDTOList = new ArrayList<>();
		String sql = customSQL.get(getClass(),
				OmsbTmsCommonConstants.GET_FACULTY_SITE_COMPENSATION_REPORT_DETAILS_OF_EC_MEMBER);
		if (Validator.isNotNull(sql)) {
			Session session = openSession();
			try {

				Query query = session.createSQLQuery(sql);
				query.setCacheable(false);
				QueryPos queryPos = QueryPos.getInstance(query);
				queryPos.add(programId);
				List<Object[]> data = query.list();
				if (Validator.isNotNull(data)) {
					for (Object[] objects : data) {
						List<String> list = new ArrayList<String>();
						FacultySiteCompensationDTO facultySiteCompensationDTO = new FacultySiteCompensationDTO();
						facultySiteCompensationDTO.setFirstName((String) objects[0]);
						facultySiteCompensationDTO.setMiddleName((String) objects[1]);
						facultySiteCompensationDTO.setLastName((String) objects[2]);
						facultySiteCompensationDTO.setAmountInOmr(((BigInteger) objects[3]).longValue());
						_logger.info("ROTATION_NAME => " + OmsbTmsCommonUtil.getValueByLanguage((String) objects[4],
								OmsbTmsCommonConstants.ROTATION_NAME, languageCode));
						_logger.info("TRAINING_SITE_NAME => " + OmsbTmsCommonUtil.getValueByLanguage(
								(String) objects[5], OmsbTmsCommonConstants.TRAINING_SITE_NAME, languageCode));
						_logger.info("TRAINEE_SITE_CODE => " + OmsbTmsCommonUtil.getValueByLanguage((String) objects[6],
								OmsbTmsCommonConstants.TRAINEE_SITE_CODE, languageCode));

						facultySiteCompensationDTO.setRotationName(OmsbTmsCommonUtil.getValueByLanguage(
								(String) objects[4], OmsbTmsCommonConstants.ROTATION_NAME, languageCode));
						facultySiteCompensationDTO.setTrainingSiteName(OmsbTmsCommonUtil.getValueByLanguage(
								(String) objects[5], OmsbTmsCommonConstants.TRAINING_SITE_NAME, languageCode));
						facultySiteCompensationDTO.setTrainingSiteCode(OmsbTmsCommonUtil.getValueByLanguage(
								(String) objects[6], OmsbTmsCommonConstants.TRAINEE_SITE_CODE, languageCode));
						facultySiteCompensationDTO.setUserId(((BigInteger) objects[7]).longValue());
						facultySiteCompensationDTO.setRoleName((String) objects[8]);
						facultySiteCompensationDTOList.add(facultySiteCompensationDTO);
						_logger.info("facultySiteCompensationDTOList " + facultySiteCompensationDTOList);
					}
				}
			} catch (Exception e) {
				_logger.error(e);
			} finally {
				closeSession(session);
			}
		}
		return facultySiteCompensationDTOList;
	}

	public List<DutyLogViolationDTO> getDutyLogViolationList(long programId, long traineeCohortId,
			long residencyLevelId, long traineeId) {
		List<DutyLogViolationDTO> list = new ArrayList<>();
		String sql = customSQL.get(getClass(), OmsbTmsCommonConstants.GET_DUTY_LOG_VIOLATION_LIST);
		if (Validator.isNotNull(sql)) {
			Session session = openSession();
			StringBuilder sb = new StringBuilder();
			String and = "";

			if (traineeId > 0) {
				sb.append(" u.userid = " + traineeId);
				and = " and ";
			}
			if (programId > 0) {
				sb.append(and);
				sb.append(" pm.program_master_id = " + programId);
				and = " and ";
			}
			if (traineeCohortId > 0) {
				sb.append(and);
				sb.append(" tcd.trainee_cohort_details_id=" + traineeCohortId);
				and = " and ";
			}

			if (residencyLevelId > 0) {
				sb.append(and);
				sb.append(" tlm.trainee_level_master_id= " + residencyLevelId);
				and = " and ";
			}

			if (sb.length() > 0) {
				sql = sql + "where " + sb.toString();
			}

			sql = sql
					+ " Group By dlv.block_id, tptd.trainee_level_id, prtl.rotation_id, prtl.training_sites_id, bmdr.block_no, bmdr.block_start_date, bmdr.block_end_date, dlv.program_master_id;";
			_logger.info("Sql---------------------> " + sql);
			Query query = session.createSQLQuery(sql);
			query.setCacheable(false);
			try {
				List<Object[]> data = query.list();
				_logger.info("data-------> " + data);
				if (Validator.isNotNull(data)) {
					for (Object[] objects : data) {

						DutyLogViolationDTO dto = new DutyLogViolationDTO();
						dto.setProgramId(((BigInteger) objects[0]).longValue());
						dto.setTraineeLevelId(((BigInteger) objects[1]).longValue());
						dto.setRotationId(((BigInteger) objects[2]).longValue());
						dto.setTraineeSiteId(((BigInteger) objects[3]).longValue());
						dto.setBlockNo((String) objects[4]);
						dto.setBlockStartDate(((Date) objects[5]));
						dto.setBlockEndDate(((Date) objects[6]));
						dto.setAcgme80HoursRule(((BigInteger) objects[7]).longValue());
						dto.setAcgmeCallRuleOption1(((BigInteger) objects[8]).longValue());
						dto.setAcgmeCallRuleOption2(((BigInteger) objects[9]).longValue());
						dto.setAcgmeShortBreakRule(((BigInteger) objects[10]).longValue());
						dto.setAcgme24HoursRule(((BigInteger) objects[11]).longValue());
						dto.setAcgmeDayOffRule(((BigInteger) objects[12]).longValue());
						list.add(dto);

					}

				}
			} catch (Exception e) {
				e.printStackTrace();

			}

		}
		_logger.info("List :" + list);

		return list;
	}

	public List<DutyLogViolationDTO> getDutyLogViolationListByUserId(long traineeId) {
		List<DutyLogViolationDTO> list = new ArrayList<>();
		String sql = customSQL.get(getClass(), OmsbTmsCommonConstants.GET_DUTY_LOG_VIOLATION_LIST_BY_USER_ID);
		if (Validator.isNotNull(sql)) {
			Session session = openSession();
			StringBuilder sb = new StringBuilder();

			_logger.info("Sql---------------------> " + sql);
			Query query = session.createSQLQuery(sql);
			query.setCacheable(false);
			QueryPos queryPos = QueryPos.getInstance(query);
			queryPos.add(traineeId);
			try {
				List<Object[]> data = query.list();
				_logger.info("data-------> " + data);
				if (Validator.isNotNull(data)) {
					for (Object[] objects : data) {

						DutyLogViolationDTO dto = new DutyLogViolationDTO();
						dto.setProgramId(((BigInteger) objects[0]).longValue());
						dto.setTraineeLevelId(((BigInteger) objects[1]).longValue());
						dto.setRotationId(((BigInteger) objects[2]).longValue());
						dto.setTraineeSiteId(((BigInteger) objects[3]).longValue());
						dto.setBlockNo((String) objects[4]);
						dto.setBlockStartDate(((Date) objects[5]));
						dto.setBlockEndDate(((Date) objects[6]));
						dto.setAcgme80HoursRule(((BigInteger) objects[7]).longValue());
						dto.setAcgmeCallRuleOption1(((BigInteger) objects[8]).longValue());
						dto.setAcgmeCallRuleOption1(((BigInteger) objects[9]).longValue());
						dto.setAcgmeShortBreakRule(((BigInteger) objects[10]).longValue());
						dto.setAcgme24HoursRule(((BigInteger) objects[11]).longValue());
						dto.setAcgmeDayOffRule(((BigInteger) objects[12]).longValue());
						list.add(dto);

					}

				}
			} catch (Exception e) {
				e.printStackTrace();

			}

		}
		_logger.info("List :" + list);

		return list;
	}

	public List<DutyLogHoursDTO> getDutyLogHours(long programId, long traineeCohortId, long residencyLevelId,
			long traineeId, String stratDate, String endDate) {
		List<DutyLogHoursDTO> dutyLogHoursList = new ArrayList<>();
		String sql = customSQL.get(getClass(), OmsbTmsCommonConstants.GET_DUTY_LOG_HOURS_LIST);
		if (Validator.isNotNull(sql)) {
			Session session = openSession();
			StringBuilder sb = new StringBuilder();
			String and = "";

			try {
				if (traineeId > 0) {
					sb.append(" u.userid = " + traineeId);
					and = " and ";
				}
				if (programId > 0) {
					sb.append(and);
					sb.append(" pm.program_master_id = " + programId);
					and = " and ";
				}
				if (traineeCohortId > 0) {
					sb.append(and);
					sb.append(" tcd.trainee_cohort_details_id  = " + traineeCohortId);
					and = " and ";
				}
				if (residencyLevelId > 0) {
					sb.append(and);
					sb.append(" tlm.trainee_level_master_id = " + residencyLevelId);
					and = " and ";
				}
				if (!stratDate.isEmpty()) {
					String[] date = stratDate.split("-");
					sb.append(and);
					sb.append("EXTRACT(YEAR FROM dl.start_date) = " + date[0]);
					and = " and ";
					sb.append(and);
					sb.append("EXTRACT(MONTH FROM dl.start_date) = " + date[1]);
					and = " and ";
					sb.append(and);
					sb.append("EXTRACT(DAY FROM dl.start_date) = " + date[2]);
					and = " and ";
				}

				if (!endDate.isEmpty()) {
					String[] date = endDate.split("-");
					sb.append(and);
					sb.append("EXTRACT(YEAR FROM end_date) = " + date[0]);
					and = " and ";
					sb.append(and);
					sb.append("EXTRACT(MONTH FROM end_date) = " + date[1]);
					and = " and ";
					sb.append(and);
					sb.append("EXTRACT(DAY FROM end_date) = " + date[2]);
					and = " and ";
				}
				if (sb.length() > 0) {
					sql = sql + " where " + sb.toString();
				}

				sql = sql + " order by dl.duty_log_id desc ;";
				_logger.info("Sql---------------------> " + sql);
				Query query = session.createSQLQuery(sql);
				query.setCacheable(false);
				QueryPos queryPos = QueryPos.getInstance(query);
				List<Object[]> data = query.list();
				_logger.info("data-------> " + data);
				if (Validator.isNotNull(data)) {
					for (Object[] objects : data) {
						DutyLogHoursDTO dutyLogHoursDTO = new DutyLogHoursDTO();

						dutyLogHoursDTO.setDutyLogId(((BigInteger) objects[0]).longValue());
						dutyLogHoursDTO.setTraineeId(((BigInteger) objects[1]).longValue());
						dutyLogHoursDTO.setProgramDutyAssignmentId(((BigInteger) objects[2]).longValue());
						dutyLogHoursDTO.setStartDate(((Date) objects[3]));
						dutyLogHoursDTO.setEndDate(((Date) objects[4]));
						dutyLogHoursList.add(dutyLogHoursDTO);
					}

				}

			} catch (Exception e) {
				_logger.error(e.getMessage());
			}

		}

		return dutyLogHoursList;
	}

	public List<TrainingSiteByRotationsDTO> getTrainingSiteByRotation(List<Long> programIds, String languageCode,
			long progDurationId) {
		List<TrainingSiteByRotationsDTO> trainingSiteByRotationsDTOs = new ArrayList<>();

		getTrainingSiteByRotationextracted(programIds, languageCode, trainingSiteByRotationsDTOs, progDurationId, 0,
				false);
		List<TrainingSiteByRotationsDTO> trainingSiteDTOs = new ArrayList<>(trainingSiteByRotationsDTOs);
		for (TrainingSiteByRotationsDTO trainingSiteDTO : trainingSiteDTOs) {
			if (trainingSiteDTO.isSharedRotation()) {
				List<Long> programIdList = Collections.singletonList(trainingSiteDTO.getRotationOwningProgramId());
				getTrainingSiteByRotationextracted(programIdList, languageCode, trainingSiteByRotationsDTOs,
						trainingSiteDTO.getOwningProgramDurationId(), trainingSiteDTO.getRotationId(), true);
			}
		}
		trainingSiteByRotationsDTOs = trainingSiteByRotationsDTOs.stream().filter(obj -> !obj.isSharedRotation())
				.collect(Collectors.toList());
		return trainingSiteByRotationsDTOs;
	}

	private void getTrainingSiteByRotationextracted(List<Long> programIds, String languageCode,
			List<TrainingSiteByRotationsDTO> trainingSiteByRotationsDTOs, long progDurationId, long rotationId,
			Boolean rotationType) {

		String sql = customSQL.get(getClass(), OmsbTmsCommonConstants.GET_TRAINING_SITE_BY_ROTATION);
		if (Validator.isNotNull(sql) && Validator.isNotNull(programIds)) {
			StringBuilder sb = new StringBuilder(sql);
			String programIdsString = programIds.stream().map(String::valueOf)
					.collect(Collectors.joining(StringPool.COMMA));
			sb.append(" AND pd.program_id in (" + programIdsString + ") AND pd.prog_duration_id = " + progDurationId);
			if (rotationId != 0) {
				sb.append(" AND prt.rotation_id = " + rotationId);
			}
			Session session = openSession();
			try {
				Query query = session.createSQLQuery(sb.toString());
				query.setCacheable(false);
				List<Object[]> data = query.list();
				if (Validator.isNotNull(data)) {
					for (Object[] objects : data) {
						String siteCode = (String) objects[1];
						TrainingSiteByRotationsDTO trainingSiteByRotationsDTO = new TrainingSiteByRotationsDTO();
						trainingSiteByRotationsDTO.setNoOfslots(((Integer) objects[0]));
						if (Validator.isNotNull(siteCode) && !siteCode.isBlank()) {
							trainingSiteByRotationsDTO.setProgCodeRsnSiteCode((String) objects[1]);
						} else {
							trainingSiteByRotationsDTO.setProgCodeRsnSiteCode("");
						}
						trainingSiteByRotationsDTO.setRotationOwningProgramId(((BigInteger) objects[2]).longValue());
						trainingSiteByRotationsDTO.setSharedRotation((Boolean) objects[3]);
						trainingSiteByRotationsDTO
								.setProgDurationRotationTsRelId(((BigInteger) objects[4]).longValue());
						trainingSiteByRotationsDTO.setTrainingSiteMasterId(((BigInteger) objects[5]).longValue());
						trainingSiteByRotationsDTO.setRotationId(((BigInteger) objects[6]).longValue());
						trainingSiteByRotationsDTO.setOwningProgramDurationId(((BigInteger) objects[7]).longValue());
						trainingSiteByRotationsDTO.setSharedRotationType(rotationType);
						trainingSiteByRotationsDTOs.add(trainingSiteByRotationsDTO);
					}

				}
			} catch (Exception e) {
				_logger.error(e);
			} finally {
				closeSession(session);
			}
		}
	}

	public List<TrainingSiteNameWithRotationDTO> getTrainingSiteNameWithRotation(String languageCode, long programId) {
		List<TrainingSiteNameWithRotationDTO> trainingSiteNameWithRotationDTOList = new ArrayList<>();
		String sql = customSQL.get(getClass(), OmsbTmsCommonConstants.GET_TRAINING_SITE_NAME_WITH_ROTATION);
		if (Validator.isNotNull(sql)) {
			Session session = openSession();
			try {
				Query query = session.createSQLQuery(sql);
				query.setCacheable(false);
				QueryPos queryPos = QueryPos.getInstance(query);
				queryPos.add(programId);
				List<Object[]> data = query.list();
				if (Validator.isNotNull(data)) {
					for (Object[] objects : data) {
						_logger.info("TRAINING_SITE_NAME: " + OmsbTmsCommonUtil.getValueByLanguage((String) objects[0],
								OmsbTmsCommonConstants.TRAINING_SITE_NAME, languageCode));
						_logger.info("ROTATION_NAME : " + OmsbTmsCommonUtil.getValueByLanguage((String) objects[1],
								OmsbTmsCommonConstants.ROTATION_NAME, languageCode));
						TrainingSiteNameWithRotationDTO trainingSiteNameWithRotationDTO = new TrainingSiteNameWithRotationDTO();
						trainingSiteNameWithRotationDTO.setTraining_site_name(OmsbTmsCommonUtil.getValueByLanguage(
								(String) objects[0], OmsbTmsCommonConstants.TRAINING_SITE_NAME, languageCode));
						trainingSiteNameWithRotationDTO.setRotation_name(OmsbTmsCommonUtil.getValueByLanguage(
								(String) objects[1], OmsbTmsCommonConstants.ROTATION_NAME, languageCode));
						trainingSiteNameWithRotationDTOList.add(trainingSiteNameWithRotationDTO);
					}
				}
			} catch (Exception e) {
				_logger.error(e);
			} finally {
				closeSession(session);
			}
		}
		return trainingSiteNameWithRotationDTOList;
	}

	public List<RotationTraineeBlockRelationDTO> getTraineeNoofBlocks(long programDurationId, long traineeLevelId,
			String languageCode) {
		List<RotationTraineeBlockRelationDTO> rotationTraineeBlockRelationDTOs = new ArrayList<>();
		String sql = customSQL.get(getClass(), OmsbTmsCommonConstants.GET_TRAINEE_NO_OF_BLOCKS);
		if (Validator.isNotNull(sql)) {
			Session session = openSession();
			try {
				Query query = session.createSQLQuery(sql);
				QueryPos queryPos = QueryPos.getInstance(query);
				queryPos.add(programDurationId);
				queryPos.add(traineeLevelId);
				query.setCacheable(false);
				List<Object[]> data = query.list();
				if (Validator.isNotNull(data)) {
					for (Object[] objects : data) {
						RotationTraineeBlockRelationDTO rotationTraineeBlockRelationDTO = new RotationTraineeBlockRelationDTO();
						rotationTraineeBlockRelationDTO.setProgramDurationId(((BigInteger) objects[0]).longValue());
						rotationTraineeBlockRelationDTO.setRotationId(((BigInteger) objects[1]).longValue());
						rotationTraineeBlockRelationDTO.setTraineeLevelId(((BigInteger) objects[2]).longValue());
						rotationTraineeBlockRelationDTO.setNoOfBlocks(((Integer) objects[3]));
						rotationTraineeBlockRelationDTO.setRotationTypeId(((BigInteger) objects[4]).longValue());

						rotationTraineeBlockRelationDTOs.add(rotationTraineeBlockRelationDTO);
					}
				}
			} catch (Exception e) {
				_logger.error(e);
			} finally {
				closeSession(session);
			}
		}
		return rotationTraineeBlockRelationDTOs;
	}

	public List<RotationDTO> getRotationsByTrainingSiteAndCohort(long trainingSiteId, long cohortId,
			String languageCode) {
		List<RotationDTO> rotationList = new ArrayList<>();
		String sql = customSQL.get(getClass(), OmsbTmsCommonConstants.GET_ROTATIONS_BY_TRAINING_SITE_AND_COHORT);
		if (Validator.isNotNull(sql)) {
			Session session = openSession();
			try {
				Query query = session.createSQLQuery(sql);
				query.setCacheable(false);
				QueryPos queryPos = QueryPos.getInstance(query);
				queryPos.add(trainingSiteId);
				queryPos.add(cohortId);
				List<Object[]> data = query.list();
				if (Validator.isNotNull(data)) {
					for (Object[] objects : data) {
						RotationDTO rotationDTO = new RotationDTO();
						rotationDTO.setProgDurationRotationTsRelId(((BigInteger) objects[0]).longValue());
						rotationDTO.setProgramDurationId(((BigInteger) objects[1]).longValue());
						rotationDTO.setTrainingSiteId(((BigInteger) objects[2]).longValue());
						rotationDTO.setRotationMasterId(((BigInteger) objects[3]).longValue());
						rotationDTO.setRotationName(OmsbTmsCommonUtil.getValueByLanguage((String) objects[4],
								OmsbTmsCommonConstants.ROTATION_NAME, languageCode));
						rotationDTO.setNoOfslots(((int) objects[5]));
						rotationList.add(rotationDTO);
					}
				}
			} catch (Exception e) {
				_logger.info(e);
			} finally {
				closeSession(session);
			}
		}
		return rotationList;
	}

	public Map<Long, String> getProcedureMasterParameter(long programDurationId, String type, String languageCode) {
		Map<Long, String> parameterMap = new LinkedHashMap();
		String sql = StringPool.BLANK;
		if (OmsbTmsCommonConstants.ROLE_TYPE_NAME.equalsIgnoreCase(type)) {
			sql = customSQL.get(getClass(), OmsbTmsCommonConstants.GET_ROLE_TYPE_BY_PROGRAM_DURATION_ID);
		} else if (OmsbTmsCommonConstants.PATIENT_TYPE_NAME.equalsIgnoreCase(type)) {
			sql = customSQL.get(getClass(), OmsbTmsCommonConstants.GET_PATIENT_TYPE_BY_PROGRAM_DURATION_ID);
		} else {
			sql = customSQL.get(getClass(), OmsbTmsCommonConstants.GET_VISIT_TYPE_BY_PROGRAM_DURATION_ID);
		}
		if (!Objects.equals(sql, StringPool.BLANK)) {
			Session session = openSession();
			try {
				Query query = session.createSQLQuery(sql);
				query.setCacheable(false);
				QueryPos queryPos = QueryPos.getInstance(query);
				queryPos.add(programDurationId);

				List<Object[]> data = query.list();
				if (Validator.isNotNull(data)) {
					for (Object[] objects : data) {
						if (OmsbTmsCommonConstants.ROLE_TYPE_NAME.equalsIgnoreCase(type)) {
							parameterMap.put(((BigInteger) objects[0]).longValue(),
									OmsbTmsCommonUtil.getValueByLanguage((String) objects[1],
											OmsbTmsCommonConstants.ROLE_TYPE_NAME, languageCode));
						} else if (OmsbTmsCommonConstants.PATIENT_TYPE_NAME.equalsIgnoreCase(type)) {
							parameterMap.put(((BigInteger) objects[0]).longValue(),
									OmsbTmsCommonUtil.getValueByLanguage((String) objects[1],
											OmsbTmsCommonConstants.PATIENT_TYPE_NAME, languageCode));
						} else {
							parameterMap.put(((BigInteger) objects[0]).longValue(),
									OmsbTmsCommonUtil.getValueByLanguage((String) objects[1],
											OmsbTmsCommonConstants.VISIT_TYPE_NAME, languageCode));
						}
					}
				}
			} catch (Exception e) {
				_logger.error(e);
			} finally {
				closeSession(session);
			}
		}
		return parameterMap;
	}

	public TrainingSitesMaster getTrainingSiteByDatePerformed(String datePerformed, long traineeId) {
		TrainingSitesMaster trainingSitesMaster = null;
		String sql = customSQL.get(getClass(), OmsbTmsCommonConstants.GET_TRAINING_SITES_BY_DATE_PERFORMED);
		if (Validator.isNotNull(sql)) {
			sql = sql.replace("$[PERFORMED_DATE]", datePerformed);
			Session session = openSession();
			try {
				Query query = session.createSQLQuery(sql);
				QueryPos queryPos = QueryPos.getInstance(query);
				queryPos.add(traineeId);
				queryPos.add(traineeId);
				queryPos.add(traineeId);
				query.setCacheable(false);
				List<BigInteger> data = query.list();
				if (Validator.isNotNull(data)) {
					for (BigInteger trainingSiteId : data) {
						trainingSitesMaster = TrainingSitesMasterLocalServiceUtil
								.fetchTrainingSitesMaster(trainingSiteId.longValue());
					}
				}
			} catch (Exception e) {
				_logger.error(e);
			} finally {
				closeSession(session);
			}
		}
		return trainingSitesMaster;
	}

	public DutyLogDTO getDutyLogDTO(long traineeId, String startDate) {
		String sql = customSQL.get(getClass(), OmsbTmsCommonConstants.GET_DUTY_LOG);
		_logger.info("traineeId :: " + traineeId);
		_logger.info("startDate :: " + startDate);
		DutyLogDTO dto = new DutyLogDTO();
		if (Validator.isNotNull(sql)) {
			Session session = openSession();
			try {
				String[] date = startDate.split("/");
				_logger.info("sql  :: " + sql);
				Query query = session.createSQLQuery(sql);
				query.setCacheable(false);
				QueryPos queryPos = QueryPos.getInstance(query);
				queryPos.add(traineeId);
				queryPos.add(Long.parseLong(date[2]));
				queryPos.add(Long.parseLong(date[1]));
				queryPos.add(Long.parseLong(date[0]));
				List<Object[]> data = query.list();
				if (Validator.isNotNull(data)) {
					for (Object[] objects : data) {
						dto.setStartDate((Date) objects[11]);
						dto.setEndDate((Date) objects[12]);
					}
				}

			} catch (Exception e) {
				_logger.info(e);
			} finally {
				closeSession(session);
			}
		}
		return dto;
	}

	public List<DutyTypeDTO> getAcgmeCallRule8Hour(long dutyTypeId, long traineeId, long blockId) {

		List<DutyTypeDTO> list = new ArrayList<DutyTypeDTO>();
		String sql = customSQL.get(getClass(), OmsbTmsCommonConstants.CHECK_ACGME_CALL_RULE_8HOURS);
		DutyTypeDTO dutyLogDTO = null;
		if (Validator.isNotNull(sql)) {
			Session session = openSession();
			try {
				Query query = session.createSQLQuery(sql);
				query.setCacheable(false);
				QueryPos queryPos = QueryPos.getInstance(query);
				queryPos.add(dutyTypeId);
				queryPos.add(traineeId);
				queryPos.add(blockId);
				List<Object[]> data = query.list();
				if (Validator.isNotNull(data)) {
					for (Object[] objects : data) {
						dutyLogDTO = new DutyTypeDTO();
						dutyLogDTO.setDutyType((String) objects[0]);
						dutyLogDTO.setDutyTypeId(((BigInteger) objects[1]).longValue());
						dutyLogDTO.setStartDate((Date) objects[2]);
						dutyLogDTO.setEndDate((Date) objects[3]);
						list.add(dutyLogDTO);
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				closeSession(session);
			}
		}
		return list;

	}

	public DutyLogDTO getAcgmeCallRule48Hour(long dutyTypeId, long traineeId, long blockId, long dutyLogId) {
		// List<DutyLogDTO> dutyLogDTOList = new ArrayList<>();
		String sql = customSQL.get(getClass(), OmsbTmsCommonConstants.CHECK_ACGME_CALL_RULE_48HOURS);
		DutyLogDTO dutyLogDTO = null;
		if (Validator.isNotNull(sql)) {
			Session session = openSession();
			try {
				Query query = session.createSQLQuery(sql);
				query.setCacheable(false);
				QueryPos queryPos = QueryPos.getInstance(query);
				queryPos.add(dutyTypeId);
				queryPos.add(traineeId);
				queryPos.add(blockId);
				queryPos.add(dutyLogId);
				List<Object[]> data = query.list();
				if (data == null) {
					return null;
				} else {

					for (Object[] objects : data) {
						dutyLogDTO = new DutyLogDTO();

						dutyLogDTO.setStartDate((Date) objects[0]);
						dutyLogDTO.setEndDate((Date) objects[1]);

					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				closeSession(session);
			}
		}

		return dutyLogDTO;

	}

	public List<DutyLogDTO> getDutyLogs(Date startDate, Date endDate, long traineeId) {
		List<DutyLogDTO> dutyLogDTOList = new ArrayList<>();
		String sql = customSQL.get(getClass(), OmsbTmsCommonConstants.GET_DUTY_LOGS);
		DutyLogDTO dutyLogDTO = null;
		if (Validator.isNotNull(sql)) {
			Session session = openSession();
			try {
				Query query = session.createSQLQuery(sql);
				query.setCacheable(false);
				QueryPos queryPos = QueryPos.getInstance(query);
				queryPos.add(startDate);
				queryPos.add(endDate);
				queryPos.add(traineeId);
				List<Object[]> data = query.list();
				if (Validator.isNotNull(data)) {
					for (Object[] objects : data) {
						dutyLogDTO = new DutyLogDTO();

						dutyLogDTO.setDutyLogId(((BigInteger) objects[0]).longValue());
						dutyLogDTO.setStartDate((Date) objects[1]);
						dutyLogDTO.setEndDate((Date) objects[2]);
						dutyLogDTO.setResidencyLevelId(((BigInteger) objects[3]).longValue());
						dutyLogDTO.setBlocksMetadataDetailRelId(((BigInteger) objects[4]).longValue());
						dutyLogDTO.setProgramDutyAssignmentId(((BigInteger) objects[5]).longValue());
						dutyLogDTO.setTraineeId(((BigInteger) objects[6]).longValue());
						dutyLogDTOList.add(dutyLogDTO);

					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			finally {
				closeSession(session);
			}
		}
		return dutyLogDTOList;

	}

	public long getRotationIdByDatePerformed(String datePerformed, long traineeId) {
		long rotationId = GetterUtil.DEFAULT_LONG;
		String sql = customSQL.get(getClass(), OmsbTmsCommonConstants.GET_ROTATION_ID_BY_DATE_PERFORMED);
		if (Validator.isNotNull(sql)) {
			sql = sql.replace("$[PERFORMED_DATE]", datePerformed);
			Session session = openSession();
			try {
				Query query = session.createSQLQuery(sql);
				QueryPos queryPos = QueryPos.getInstance(query);
				queryPos.add(traineeId);
				queryPos.add(traineeId);
				queryPos.add(traineeId);
				query.setCacheable(false);
				List<BigInteger> data = query.list();
				if (Validator.isNotNull(data)) {
					for (BigInteger rId : data) {
						rotationId = rId.longValue();
					}
				}
			} catch (Exception e) {
				_logger.error(e);
			} finally {
				closeSession(session);
			}
		}
		return rotationId;
	}

	public List<Long> getTraineeByProgramCohortAndTraineeLevel(long programDurationId, long traineeLevelId) {
		List<Long> trainees = new ArrayList<>();
		String sql = customSQL.get(getClass(), OmsbTmsCommonConstants.GET_TRAINEE_BY_PROGDURATION_AND_TRAINEE_LEVEL);
		if (Validator.isNotNull(sql)) {
			Session session = openSession();
			try {
				Query query = session.createSQLQuery(sql);
				query.setCacheable(false);
				QueryPos queryPos = QueryPos.getInstance(query);
				queryPos.add(programDurationId);
				queryPos.add(traineeLevelId);
				List<BigInteger> data = query.list();
				if (Validator.isNotNull(data)) {
					for (BigInteger rId : data) {
						trainees.add(rId.longValue());
					}
				}
			} catch (Exception e) {
				_logger.info(e);
			} finally {
				closeSession(session);
			}
		}
		return trainees;
	}

	public List<ResidentReportDTO> getResidentsInEachSitePerBlock(long programId, String annualYear,
			String languageCode) {
		List<ResidentReportDTO> residentReportDTOList = new ArrayList<>();
		// get faculty detail
		String sql = customSQL.get(getClass(), OmsbTmsCommonConstants.GET_RESIDENTS_IN_EACH_SITE_PER_BLOCK);
		if (Validator.isNotNull(sql)) {
			Session session = openSession();
			try {
				Query query = session.createSQLQuery(sql);
				query.setCacheable(false);
				QueryPos queryPos = QueryPos.getInstance(query);
				queryPos.add(programId);
				queryPos.add(annualYear);
				queryPos.add(programId);
				queryPos.add(annualYear);
				List<Object[]> data = query.list();

				if (Validator.isNotNull(data)) {

					for (Object[] objects : data) {
						ResidentReportDTO residentReportDTO = new ResidentReportDTO();
						residentReportDTO.setTrainingSiteId(Long.parseLong(String.valueOf(objects[0])));
						residentReportDTO.setTrainingSiteName(OmsbTmsCommonUtil.getValueByLanguage((String) objects[1],
								OmsbTmsCommonConstants.TRAINING_SITE_NAME, languageCode));
						residentReportDTO.setRotationId(Long.parseLong(String.valueOf(objects[2])));
						residentReportDTO.setRotationName(OmsbTmsCommonUtil.getValueByLanguage((String) objects[3],
								OmsbTmsCommonConstants.ROTATION_NAME, languageCode));
						residentReportDTO.setBlockNo(String.valueOf((objects[4])));
						residentReportDTO.setTraineesInProgram(Integer.parseInt(String.valueOf(objects[5])));
						residentReportDTO.setTraineesNotInProgram(Integer.parseInt(String.valueOf(objects[6])));
						residentReportDTO.setFacultyId(Long.parseLong(String.valueOf(objects[7])));
						residentReportDTO.setFirstName(String.valueOf(objects[8]));
						residentReportDTO.setLastName(String.valueOf(objects[9]));

						residentReportDTOList.add(residentReportDTO);
					}
				}

			} catch (Exception e) {
				_logger.info(e);
			} finally {
				closeSession(session);
			}
		}
		return residentReportDTOList;
	}

	public List<FacultyRequestDTO> getFacultyRequestData(String languageCode) {
		List<FacultyRequestDTO> list = new ArrayList<>();
		String sql = customSQL.get(getClass(), OmsbTmsCommonConstants.GET_FACULTY_REQUEST_DATA);
		if (Validator.isNotNull(sql)) {
			Session session = openSession();
			_logger.info("Sql---------------------> " + sql);
			Query query = session.createSQLQuery(sql);
			query.setCacheable(false);
			try {
				List<Object[]> data = query.list();
				_logger.info("data-------> " + data);
				if (Validator.isNotNull(data)) {
					for (Object[] objects : data) {
						User user = UserLocalServiceUtil.getUser(((BigInteger) objects[3]).longValue());
						FacultyRequestDTO dto = new FacultyRequestDTO();
						dto.setProgramName(OmsbTmsCommonUtil.getValueByLanguage((String) objects[0],
								OmsbTmsCommonConstants.PROGRAM_NAME, languageCode));
						dto.setTrainingSiteName(OmsbTmsCommonUtil.getValueByLanguage((String) objects[1],
								OmsbTmsCommonConstants.TRAINING_SITE_NAME, languageCode));
						dto.setRotationName(OmsbTmsCommonUtil.getValueByLanguage((String) objects[2],
								OmsbTmsCommonConstants.ROTATION_NAME, languageCode));
						dto.setPotentialFacultyName(user.getFullName());
						dto.setFacultyTypeEn((String) objects[4]);
						dto.setFacultyTypeAr((String) objects[5]);
						dto.setFaultyRequestStatusEn((String) objects[6]);
						dto.setFaultyRequestStatusAr((String) objects[7]);
						dto.setFacultyRequestId(((BigInteger) objects[8]).longValue());
						dto.setFaultyRequestStatusCode((String) objects[9]);
						list.add(dto);
					}

				}
			} catch (Exception e) {
				e.printStackTrace();

			}

		}
		return list;
	}

	
	public List<FacultyRequestDTO> getFacultyRequestDataBySearch(long programId, long facultyTypeId,
			long facultyRequestStatusId, String languageCode) {
		List<FacultyRequestDTO> list = new ArrayList<>();
		String sql = customSQL.get(getClass(), OmsbTmsCommonConstants.GET_FACULTY_REQUEST_DATA);
		if (Validator.isNotNull(sql)) {
			Session session = openSession();
			StringBuilder sb = new StringBuilder();
			String and = "";
			
			if (programId > 0) {
				sb.append(and);
				sb.append(" fr.program_id = " + programId);
				and = " and ";
			}
			if (facultyTypeId > 0) {
				sb.append(and);
				sb.append(" fr.potential_faculty_type_id =" + facultyTypeId);
				and = " and ";
			}
			if (facultyRequestStatusId > 0) {
				sb.append(and);
				sb.append(" fss.faculty_request_status_id = " + facultyRequestStatusId);
				and = " and ";
			}

			if (sb.length() > 0) {
				sql = sql + "where " + sb.toString();
			}

			Query query = session.createSQLQuery(sql);
			query.setCacheable(false);
			try {
				List<Object[]> data = query.list();
				_logger.info("data-------> " + data);
				if (Validator.isNotNull(data)) {
					for (Object[] objects : data) {

						User user = UserLocalServiceUtil.getUser(((BigInteger) objects[3]).longValue());
						FacultyRequestDTO dto = new FacultyRequestDTO();
						dto.setProgramName(OmsbTmsCommonUtil.getValueByLanguage((String) objects[0],
								OmsbTmsCommonConstants.PROGRAM_NAME, languageCode));
						dto.setTrainingSiteName(OmsbTmsCommonUtil.getValueByLanguage((String) objects[1],
								OmsbTmsCommonConstants.TRAINING_SITE_NAME, languageCode));
						dto.setRotationName(OmsbTmsCommonUtil.getValueByLanguage((String) objects[2],
								OmsbTmsCommonConstants.ROTATION_NAME, languageCode));
						dto.setPotentialFacultyName(user.getFullName());
						dto.setFacultyTypeEn((String) objects[4]);
						dto.setFacultyTypeAr((String) objects[5]);
						dto.setFaultyRequestStatusEn((String) objects[6]);
						dto.setFaultyRequestStatusAr((String) objects[7]);
						dto.setFacultyRequestId(((BigInteger) objects[8]).longValue());
						dto.setFaultyRequestStatusCode((String) objects[9]);
						list.add(dto);				
					}


				}
			} catch (Exception e) {
				e.printStackTrace();

			}

		}
					
		return list;
	}

	public List<FacultyRequestDTO> getFacultyRequestDataByUserId(long userId,String languageCode) {
		List<FacultyRequestDTO> list = new ArrayList<>();
		String sql = customSQL.get(getClass(), OmsbTmsCommonConstants.GET_FACULTY_REQUEST_DATA);
		if (Validator.isNotNull(sql)) {
			Session session = openSession();
			sql = sql+ "where u.userId = " + userId;
			Query query = session.createSQLQuery(sql);
			query.setCacheable(false);
			try {
				List<Object[]> data = query.list();
				if (Validator.isNotNull(data)) {
					for (Object[] objects : data) {
						
						FacultyRequestDTO dto = new FacultyRequestDTO();
						User user = UserLocalServiceUtil.getUser(((BigInteger) objects[3]).longValue());
						dto.setProgramName(OmsbTmsCommonUtil.getValueByLanguage((String) objects[0],
								OmsbTmsCommonConstants.PROGRAM_NAME, languageCode));
						dto.setTrainingSiteName(OmsbTmsCommonUtil.getValueByLanguage((String) objects[1],
								OmsbTmsCommonConstants.TRAINING_SITE_NAME, languageCode));
						dto.setRotationName(OmsbTmsCommonUtil.getValueByLanguage((String) objects[2],
								OmsbTmsCommonConstants.ROTATION_NAME, languageCode));
						dto.setPotentialFacultyName(user.getFullName());
						dto.setFacultyTypeEn((String) objects[4]);
						dto.setFacultyTypeAr((String) objects[5]);
						dto.setFaultyRequestStatusEn((String) objects[6]);
						dto.setFaultyRequestStatusAr((String) objects[7]);
						dto.setFacultyRequestId(((BigInteger) objects[8]).longValue());
						dto.setFaultyRequestStatusCode((String) objects[9]);
						list.add(dto);		
					}

				}
			} catch (Exception e) {
				_logger.error(e);
			} finally {
				closeSession(session);
			}
		}
		return list;
	}

	public List<TrainingSiteByProgramDTO> getTrainingSiteDetailsByProgramMaster(long programId, String languageCode) {
		List<TrainingSiteByProgramDTO> trainingSiteByProgramDTOs = new ArrayList<>();
		String sql = customSQL.get(getClass(), OmsbTmsCommonConstants.GET_TRAINING_SITE_DETAILS_BY_PROGRAM_MASTER);
		if (Validator.isNotNull(sql)) {
			Session session = openSession();
			try {
				Query query = session.createSQLQuery(sql);
				query.setCacheable(false);
				QueryPos queryPos = QueryPos.getInstance(query);
				queryPos.add(programId);

				List<Object[]> data = query.list();
				if (Validator.isNotNull(data)) {
					for (Object[] objects : data) {
						TrainingSiteByProgramDTO trainingSiteByProgramDTO = new TrainingSiteByProgramDTO();
						trainingSiteByProgramDTO.setTrainingSiteId(((BigInteger) objects[0]).longValue());
						trainingSiteByProgramDTO.setTrainingSiteName(OmsbTmsCommonUtil.getValueByLanguage(
								(String) objects[1], OmsbTmsCommonConstants.TRAINING_SITE_NAME, languageCode));
						trainingSiteByProgramDTO.setProgramName(OmsbTmsCommonUtil.getValueByLanguage(
								(String) objects[2], OmsbTmsCommonConstants.PROGRAM_NAME, languageCode));
						trainingSiteByProgramDTOs.add(trainingSiteByProgramDTO);
					}
				}
			} catch (Exception e) {
				_logger.info(e);
			} finally {
				closeSession(session);
			}
		}
		return trainingSiteByProgramDTOs;
	}

	
	@Reference
	private CustomSQL customSQL;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbTmsFinderFinderImpl.class.getName());
}
