package gov.omsb.duty.logging.web.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import gov.omsb.duty.logging.web.constants.DutyLoggingConstants;
import gov.omsb.tms.model.BlocksMetadataDetailsRel;
import gov.omsb.tms.model.DutyAssignment;
import gov.omsb.tms.model.DutyLog;
import gov.omsb.tms.model.DutyTypes;
import gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel;
import gov.omsb.tms.model.ProgramDutyAssignment;
import gov.omsb.tms.model.TraineeAdmissionDetailsRel;
import gov.omsb.tms.model.TraineeCohortDetails;
import gov.omsb.tms.service.BlocksMetadataDetailsRelLocalServiceUtil;
import gov.omsb.tms.service.DutyAssignmentLocalServiceUtil;
import gov.omsb.tms.service.DutyTypesLocalServiceUtil;
import gov.omsb.tms.service.ProgdurationTraineelevelBlocksLevelTypeRelLocalServiceUtil;
import gov.omsb.tms.service.ProgramDutyAssignmentLocalServiceUtil;
import gov.omsb.tms.service.TraineeAdmissionDetailsRelLocalServiceUtil;
import gov.omsb.tms.service.TraineeCohortDetailsLocalServiceUtil;

public class DutyLoggingUtil {
	
	public static JSONArray getDutyLogsJSONArray(List<DutyLog> dutyLogs) {

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (DutyLog dutyLog : dutyLogs) {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

			String title = getAssignmentTitleFromPgDutyAssignmentId(dutyLog.getProgramDutyAssignmentId());
			String colorCode = getAssignmentColorCodeFromPgDutyAssignmentId(dutyLog.getProgramDutyAssignmentId());

			jsonObject.put(DutyLoggingConstants.ID_KEY, dutyLog.getDutyLogId());
			jsonObject.put(DutyLoggingConstants.TITLE_KEY, title);
			jsonObject.put(DutyLoggingConstants.START_KEY, dutyLog.getStartDate());
			jsonObject.put(DutyLoggingConstants.END_KEY, dutyLog.getEndDate());
			jsonObject.put(DutyLoggingConstants.COLOR_KEY, colorCode);
			jsonObject.put(DutyLoggingConstants.OVERLAP_KEY, false);

			jsonArray.put(jsonObject);
		}

		return jsonArray;

	}

	public static String getAssignmentTitleFromPgDutyAssignmentId(long pgDutyAssignmentId) {

		String assignmentName = StringPool.BLANK, dutyTypeName = StringPool.BLANK;
		try {
			ProgramDutyAssignment programDutyAssignment = ProgramDutyAssignmentLocalServiceUtil
					.getProgramDutyAssignment(pgDutyAssignmentId);
			DutyAssignment dutyAssignment = DutyAssignmentLocalServiceUtil
					.getDutyAssignment(programDutyAssignment.getDutyAssignmentId());
			if (Validator.isNotNull(dutyAssignment)) {
				assignmentName = dutyAssignment.getAssignment();
				DutyTypes dutyTypes = DutyTypesLocalServiceUtil.getDutyTypes(dutyAssignment.getDutyTypeId());
				if (Validator.isNotNull(dutyTypes)) {
					dutyTypeName = dutyTypes.getDutyType();
				} else {
					log.info("Duty Types Getting NULL");
				}
			} else {
				log.info("Duty Assignment Getting NULL");
			}

		} catch (PortalException e) {
			log.error(
					"Portal Exception While Fetching Assignment Name From programDutyAssignmentId - " + e.getMessage());
		}

		return dutyTypeName + StringPool.SPACE + StringPool.DASH + StringPool.SPACE + assignmentName;

	}

	public static String getAssignmentColorCodeFromPgDutyAssignmentId(long pgDutyAssignmentId) {

		String assignmentColorCode = StringPool.BLANK;
		try {
			ProgramDutyAssignment programDutyAssignment = ProgramDutyAssignmentLocalServiceUtil
					.getProgramDutyAssignment(pgDutyAssignmentId);
			DutyAssignment dutyAssignment = DutyAssignmentLocalServiceUtil
					.getDutyAssignment(programDutyAssignment.getDutyAssignmentId());
			if (Validator.isNotNull(dutyAssignment)) {
				assignmentColorCode = dutyAssignment.getColorCode();
			} else {
				log.info("Duty Assignment Getting NULL");
			}
		} catch (PortalException e) {
			log.error(
					"Portal Exception While Fetching Assignment Name From programDutyAssignmentId - " + e.getMessage());
		}

		return assignmentColorCode;

	}

	public static long getPgDutyAssignmentIdByAssignmentTitle(String loggedAssignmentTitle, long programId,
			ThemeDisplay themeDisplay) {

		long pgDutyAssignmentId = 0;

		String dutyTypeName = loggedAssignmentTitle.split(StringPool.SPACE + StringPool.DASH + StringPool.SPACE)[0];
		String assignmentName = loggedAssignmentTitle.split(StringPool.SPACE + StringPool.DASH + StringPool.SPACE)[1];

		// Fetching DutyTypes By Duty Type Name....
		DutyTypes dutyTypes = getDutyTypeByDutyTypeName(dutyTypeName);

		// Fetching DutyAssignments By Assignment Name & Duty Type Id....
		DutyAssignment dutyAssignment = null;
		if (Validator.isNotNull(dutyTypes)) {
			dutyAssignment = getDutyAssignmentByAssignmentNameDutyTypeId(assignmentName, dutyTypes.getDutyTypeId());
		} else {
			log.info("DutyTypes Getting Null");
		}

		// Fetching ProgramDutyAssignmentId By Duty Assignment Id....
		if (Validator.isNotNull(dutyAssignment)) {
			long dutyAssignmentId = dutyAssignment.getDutyAssignmentId();
			long cohortId = getProgramDurationIdFromTraineeId(themeDisplay.getUserId());

			ProgramDutyAssignment programDutyAssignment = getPgDutyAssignmentByPgIdDutyAssinmentIdCohortId(programId,
					dutyAssignmentId, cohortId);

			if (Validator.isNotNull(programDutyAssignment)) {
				pgDutyAssignmentId = programDutyAssignment.getProgramDutyAssignmentId();
			} else {
				log.info("ProgramDutyAssignment Getting NULL");
			}
		} else {
			log.info("DutyAssignment Getting Null");
		}

		return pgDutyAssignmentId;

	}

	public static DutyTypes getDutyTypeByDutyTypeName(String dutyTypeName) {

		DutyTypes dutyType = null;

		DynamicQuery dutyTypeDQ = DutyTypesLocalServiceUtil.dynamicQuery();

		dutyTypeDQ.add(RestrictionsFactoryUtil.eq(DutyLoggingConstants.DUTY_TYPE_COLUMN_NAME, dutyTypeName));

		List<DutyTypes> dutyTypes = DutyTypesLocalServiceUtil.dynamicQuery(dutyTypeDQ);

		if (Validator.isNotNull(dutyTypes) && !dutyTypes.isEmpty()) {
			dutyType = dutyTypes.get(0);
		}

		return dutyType;

	}

	public static DutyAssignment getDutyAssignmentByAssignmentNameDutyTypeId(String assignmentName, long dutyTypeId) {

		DutyAssignment dutyAssignment = null;

		DynamicQuery dutyAssignmentDQ = DutyAssignmentLocalServiceUtil.dynamicQuery();

		dutyAssignmentDQ
				.add(RestrictionsFactoryUtil.eq(DutyLoggingConstants.ASSIGNMENT_COLUMN_NAME, assignmentName.trim()));
		dutyAssignmentDQ.add(RestrictionsFactoryUtil.eq(DutyLoggingConstants.DUTY_TYPE_ID_COLUMN_NAME, dutyTypeId));

		List<DutyAssignment> dutyAssignments = DutyAssignmentLocalServiceUtil.dynamicQuery(dutyAssignmentDQ);

		if (Validator.isNotNull(dutyAssignments) && !dutyAssignments.isEmpty()) {
			dutyAssignment = dutyAssignments.get(0);
		}

		return dutyAssignment;

	}

	public static ProgramDutyAssignment getPgDutyAssignmentByPgIdDutyAssinmentIdCohortId(long programId,
			long dutyAssignmentId, long cohortId) {

		ProgramDutyAssignment programDutyAssignment = null;

		DynamicQuery programDutyAssignmentDQ = ProgramDutyAssignmentLocalServiceUtil.dynamicQuery();

		programDutyAssignmentDQ.add(RestrictionsFactoryUtil.eq(DutyLoggingConstants.PROGRAM_ID_COLUMN_NAME, programId));
		programDutyAssignmentDQ
				.add(RestrictionsFactoryUtil.eq(DutyLoggingConstants.DUTY_ASSIGNMENT_ID_COLUMN_NAME, dutyAssignmentId));
		programDutyAssignmentDQ.add(RestrictionsFactoryUtil.eq(DutyLoggingConstants.COHORT_ID_COLUMN_NAME, cohortId));

		List<ProgramDutyAssignment> programDutyAssignments = ProgramDutyAssignmentLocalServiceUtil
				.dynamicQuery(programDutyAssignmentDQ);

		if (Validator.isNotNull(programDutyAssignments) && !programDutyAssignments.isEmpty()) {
			programDutyAssignment = programDutyAssignments.get(0);
		}

		return programDutyAssignment;

	}

	public static long getProgramDurationIdFromTraineeId(long traineeId) {

		long programDurationId = 0;

		TraineeAdmissionDetailsRel traineeAdmissionDetailsRel = TraineeAdmissionDetailsRelLocalServiceUtil
				.findByTraineeId(traineeId);

		if (Validator.isNotNull(traineeAdmissionDetailsRel)) {
			programDurationId = traineeAdmissionDetailsRel.getProgramDurationId();
		} else {
			log.info("UNABLE TO FETCH TRAINEEADMISSIONDETAILS BY TRAINEE ID");
		}

		return programDurationId;

	}

	public static long getCohortIdFromTraineeId(long traineeId) {

		long cohortId = 0;

		TraineeCohortDetails traineeCohortDetails = getTraineeCohortDetailsByTraineeId(traineeId);

		if (Validator.isNotNull(traineeCohortDetails)) {
			cohortId = traineeCohortDetails.getTraineeCohortDetailsId();
		}

		return cohortId;

	}

	public static TraineeCohortDetails getTraineeCohortDetailsByTraineeId(long traineeId) {

		TraineeCohortDetails traineeCohortDetail = null;

		TraineeAdmissionDetailsRel traineeAdmissionDetailsRel = TraineeAdmissionDetailsRelLocalServiceUtil
				.findByTraineeId(traineeId);

		if (Validator.isNotNull(traineeAdmissionDetailsRel)) {
			DynamicQuery traineeCohortDetailsDQ = TraineeCohortDetailsLocalServiceUtil.dynamicQuery();

			traineeCohortDetailsDQ
					.add(RestrictionsFactoryUtil.eq(DutyLoggingConstants.TRAINEE_ADDMISSION_DETAILS_REL_ID_COLUMN_NAME,
							traineeAdmissionDetailsRel.getTraineeAdmissionDetailsRelId()));
			traineeCohortDetailsDQ
					.add(RestrictionsFactoryUtil.eq(DutyLoggingConstants.IS_CURRENT_COHORT_COLUMN_NAME, true));

			List<TraineeCohortDetails> traineeCohortDetails = TraineeCohortDetailsLocalServiceUtil
					.dynamicQuery(traineeCohortDetailsDQ);

			if (Validator.isNotNull(traineeCohortDetails) && !traineeCohortDetails.isEmpty()) {
				traineeCohortDetail = traineeCohortDetails.get(0);
			}
		} else {
			log.info("Trainee Addmission Details Not Available");
		}

		return traineeCohortDetail;

	}

	public static BlocksMetadataDetailsRel getBlockMetadataDetailsFromDate(Date date, long traineeId) {

		BlocksMetadataDetailsRel blocksMetadataDetailsRel = null;

		TraineeCohortDetails traineeCohortDetails = getTraineeCohortDetailsByTraineeId(traineeId);

		if (Validator.isNotNull(traineeCohortDetails)) {
			long traineeLevelId = traineeCohortDetails.getTraineeLevelId();
			long programDurationId = getProgramDurationIdFromTraineeId(traineeId);

			ProgdurationTraineelevelBlocksLevelTypeRel progdurationTraineelevelBlocksLevelTypeRel = ProgdurationTraineelevelBlocksLevelTypeRelLocalServiceUtil
					.findByProgramDurationIdAndTraineeLevelId(programDurationId, traineeLevelId);

			long progdurationTlBlocksLtId = progdurationTraineelevelBlocksLevelTypeRel.getProgdurationTlBlocksLtId();

			DynamicQuery blocksMetadataDetailsDQ = BlocksMetadataDetailsRelLocalServiceUtil.dynamicQuery();

			blocksMetadataDetailsDQ.add(RestrictionsFactoryUtil.eq(
					DutyLoggingConstants.PROG_DURATION_TRAINEE_LEVEL_BLOCKS_LEVEL_TYPE_ID_COLUMN_NAME,
					progdurationTlBlocksLtId));
			blocksMetadataDetailsDQ
					.add(PropertyFactoryUtil.forName(DutyLoggingConstants.BLOCK_START_DATE_COLUMN_NAME).le(date));
			blocksMetadataDetailsDQ
					.add(PropertyFactoryUtil.forName(DutyLoggingConstants.BLOCK_END_DATE_COLUMN_NAME).ge(date));

			List<BlocksMetadataDetailsRel> blocksMetadataDetailsRels = BlocksMetadataDetailsRelLocalServiceUtil
					.dynamicQuery(blocksMetadataDetailsDQ);

			if (Validator.isNotNull(blocksMetadataDetailsRels) && !blocksMetadataDetailsRels.isEmpty()) {
				blocksMetadataDetailsRel = blocksMetadataDetailsRels.get(0);
			} else {
				log.error("Blocks Metadata Details Not Available");
			}

		} else {
			log.info("UNABLE TO FETCH TRAINEE COHORT DETAILS");
		}

		return blocksMetadataDetailsRel;
	}

	public static String getSuccessMessage(HttpServletRequest httpRequest) {

		String successMessage = LanguageUtil.get(httpRequest,
				DutyLoggingConstants.DUTY_LOGGED_SUCCESS_MESSAGE_LANGUAGE_KEY);
		successMessage = successMessage.replace("[0]", DutyLoggingConstants.OPEN_STRONG_HTML_TAG).replace("[1]",
				DutyLoggingConstants.CLOSE_STRONG_HTML_TAG);

		return successMessage;

	}

	public static String getDutyLoggedErrorMessage(HttpServletRequest httpRequest, String dutyLoggedTitle) {

		String errorMessage = LanguageUtil.get(httpRequest,
				DutyLoggingConstants.DUTY_LOGGED_ERROR_MESSAGE_LANGUAGE_KEY);
		errorMessage = errorMessage.replace("[0]", DutyLoggingConstants.OPEN_STRONG_HTML_TAG)
				.replace("[1]", DutyLoggingConstants.CLOSE_STRONG_HTML_TAG).replace("[2]", dutyLoggedTitle);

		return errorMessage;

	}

	public static String getBlockDataNotFoundErrorMessage(HttpServletRequest httpRequest, String dutyLoggedTitle) {

		String errorMessage = LanguageUtil.get(httpRequest, DutyLoggingConstants.BLOCK_DATA_NOT_FOUND_LANGUAGE_KEY);
		errorMessage = errorMessage.replace("[0]", DutyLoggingConstants.OPEN_STRONG_HTML_TAG)
				.replace("[1]", DutyLoggingConstants.CLOSE_STRONG_HTML_TAG).replace("[2]", dutyLoggedTitle);

		return errorMessage;
	}

	public static String getBlockMismatchErrorMessage(HttpServletRequest httpRequest, String dutyLoggedTitle) {

		String errorMessage = LanguageUtil.get(httpRequest,
				DutyLoggingConstants.BLOCK_MISMATCH_ERROR_MESSAGE_LANGUAGE_KEY);
		errorMessage = errorMessage.replace("[0]", DutyLoggingConstants.OPEN_STRONG_HTML_TAG)
				.replace("[1]", DutyLoggingConstants.CLOSE_STRONG_HTML_TAG).replace("[2]", dutyLoggedTitle);

		return errorMessage;

	}

	public static String getDutyLoggedNotFoundErrorMessage(HttpServletRequest httpRequest, String dutyLoggedTitle) {

		String errorMessage = LanguageUtil.get(httpRequest, DutyLoggingConstants.DUTY_LOGGED_NOT_FOUND_LANGUAGE_KEY);
		errorMessage = errorMessage.replace("[0]", DutyLoggingConstants.OPEN_STRONG_HTML_TAG)
				.replace("[1]", DutyLoggingConstants.CLOSE_STRONG_HTML_TAG).replace("[2]", dutyLoggedTitle);

		return errorMessage;

	}

	public static Log log = LogFactoryUtil.getLog(DutyLoggingUtil.class.getName());

}
