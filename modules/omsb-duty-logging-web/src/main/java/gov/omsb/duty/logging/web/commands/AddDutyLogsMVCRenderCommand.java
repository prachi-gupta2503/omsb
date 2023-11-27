package gov.omsb.duty.logging.web.commands;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.dto.UserMetadata;
import gov.omsb.common.dto.UserMetadataItem;
import gov.omsb.common.service.util.UserMetadataUtil;
import gov.omsb.duty.logging.web.constants.DutyLogConfigurationPortletKeys;
import gov.omsb.duty.logging.web.constants.DutyLoggingConstants;
import gov.omsb.duty.logging.web.util.DutyLoggingUtil;
import gov.omsb.tms.model.DutyLog;
import gov.omsb.tms.model.ProgramDutyAssignment;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.model.TraineeCohortDetails;
import gov.omsb.tms.service.DutyLogLocalService;
import gov.omsb.tms.service.ProgramDutyAssignmentLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + DutyLogConfigurationPortletKeys.DUTYLOGHOURS,
		"mvc.command.name=/" }, service = MVCRenderCommand.class)
public class AddDutyLogsMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String programName = StringPool.BLANK;
		long programId = 0;

		UserMetadataItem userMetadataItem = userMetadataUtil.getUserMetadataItemsByLrUserId(themeDisplay.getPortalURL(),
				themeDisplay.getScopeGroupId(), themeDisplay.getUserId());
		if (Validator.isNotNull(userMetadataItem) && Validator.isNotNull(userMetadataItem.getItems())) {
			List<Long> programMasterIds = (userMetadataItem.getItems()).stream().map(UserMetadata::getProgramId)
					.collect(Collectors.toList());
			if (Validator.isNotNull(programMasterIds) && !programMasterIds.isEmpty()) {
				ProgramMaster programMaster;
				try {
					programMaster = programMasterLocalService.getProgramMaster(programMasterIds.get(0));
					if (Validator.isNotNull(programMaster)) {
						programName = programMaster.getProgramName(themeDisplay.getLocale());
						programId = programMaster.getProgramMasterId();
					}
				} catch (PortalException e) {
					log.error("Error While Fetching ProgramMaster - " + e.getMessage());
				}
			}
		}

		// Fetching ProgramDutyAssignment Of The Current Trainee Program & Current
		// Cohort...
		long programDurationId = DutyLoggingUtil.getProgramDurationIdFromTraineeId(themeDisplay.getUserId());

		DynamicQuery programDutyAssignmentDQ = programDutyAssignmentLocalService.dynamicQuery();

		programDutyAssignmentDQ.add(RestrictionsFactoryUtil.eq(DutyLoggingConstants.PROGRAM_ID_COLUMN_NAME, programId));
		programDutyAssignmentDQ
				.add(RestrictionsFactoryUtil.eq(DutyLoggingConstants.COHORT_ID_COLUMN_NAME, programDurationId));

		List<ProgramDutyAssignment> programDutyAssignments = programDutyAssignmentLocalService
				.dynamicQuery(programDutyAssignmentDQ);

		// Fetching Duty Logs Of The Current Trainee...
		DynamicQuery dutyLogsDQ = dutyLogLocalService.dynamicQuery();

		dutyLogsDQ.add(RestrictionsFactoryUtil.eq(DutyLoggingConstants.TRAINEE_ID, themeDisplay.getUserId()));

		List<DutyLog> dutyLogs = dutyLogLocalService.dynamicQuery(dutyLogsDQ);

		JSONArray jsonArray = DutyLoggingUtil.getDutyLogsJSONArray(dutyLogs);

		// Fetchng Trainee Cohort Details Of Current Logged-In Trainee
		String cohortYear = StringPool.BLANK;

		TraineeCohortDetails traineeCohortDetails = DutyLoggingUtil
				.getTraineeCohortDetailsByTraineeId(themeDisplay.getUserId());

		if (Validator.isNotNull(traineeCohortDetails)) {
			cohortYear = traineeCohortDetails.getCohortYear();
		}

		renderRequest.setAttribute(DutyLoggingConstants.LOGGED_EVENTS, jsonArray);
		renderRequest.setAttribute(DutyLoggingConstants.PROGRAM_DUTY_ASSIGNMENT_LIST, programDutyAssignments);
		renderRequest.setAttribute(DutyLoggingConstants.PROGRAM_NAME, programName);
		renderRequest.setAttribute(DutyLoggingConstants.PROGRAM_ID_COLUMN_NAME, programId);
		renderRequest.setAttribute(DutyLoggingConstants.COHORT_YEAR_COLUMN_NAME, cohortYear);

		return DutyLoggingConstants.LOG_DUTY_HOURS_PAGE;
	}

	@Reference
	DutyLogLocalService dutyLogLocalService;

	@Reference
	private UserMetadataUtil userMetadataUtil;

	@Reference
	private ProgramMasterLocalService programMasterLocalService;

	@Reference
	private ProgramDutyAssignmentLocalService programDutyAssignmentLocalService;

	private Log log = LogFactoryUtil.getLog(AddDutyLogsMVCRenderCommand.class.getName());

}