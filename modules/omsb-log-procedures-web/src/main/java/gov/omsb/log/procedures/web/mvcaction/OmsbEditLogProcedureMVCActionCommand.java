package gov.omsb.log.procedures.web.mvcaction;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.UserNotificationEventLocalService;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.log.procedures.web.constants.OmsbLogProceduresConstants;
import gov.omsb.log.procedures.web.constants.OmsbLogProceduresWebPortletKeys;
import gov.omsb.log.procedures.web.util.OmsbLogProceduresGenerateUrlsUtil;
import gov.omsb.log.procedures.web.util.OmsbLogProceduresUtil;
import gov.omsb.tms.model.ProcedureMaster;
import gov.omsb.tms.model.TraineeLoggedProcedureDetails;
import gov.omsb.tms.service.ProcedureMasterLocalService;
import gov.omsb.tms.service.TraineeLoggedProcedureDetailsLocalService;
import gov.omsb.view.procedures.supervisor.web.util.OmsbViewProceduresSupervisorUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbLogProceduresWebPortletKeys.OMSBLOGPROCEDURESWEB,
		"mvc.command.name="
				+ OmsbLogProceduresConstants.EDIT_LOG_PROCEDURE_ACTION_COMMAND }, service = MVCActionCommand.class)
public class OmsbEditLogProcedureMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String tabName = ParamUtil.getString(actionRequest, OmsbLogProceduresConstants.TAB_NAME);

		long logCounts = ParamUtil.getLong(actionRequest, OmsbLogProceduresConstants.LOG_PROCEDURES_COUNT);

		if (logCounts == 0) {
			SessionErrors.add(actionRequest, "log-procedure-required");
		} else {
			String removedProcedureIds = ParamUtil.getString(actionRequest,
					OmsbLogProceduresConstants.REMOVED_LOG_PROCEDURE_IDS);

			if (Validator.isNotNull(removedProcedureIds)) {
				// Deleting Procedure Logs which has been removed...
				removeTraineeLoggedProcedures(removedProcedureIds);
			}

			for (int i = 0; i < logCounts; i++) {
				processLogProcedure(themeDisplay, actionRequest, i);
			}

			log.debug("---------Procedures Updated Successfully----------");

			actionResponse.getRenderParameters().setValue("mvcPath", OmsbLogProceduresConstants.VIEW_PROCEDURES_JSP);

			actionRequest.setAttribute(OmsbLogProceduresConstants.TAB_NAME, tabName);
			
			setSucessesMessage(actionRequest, "log-procedure-updated");
		}

	}

	private void processLogProcedure(ThemeDisplay themeDisplay, ActionRequest actionRequest, int i) {


		long loggedProcedureId = ParamUtil.getLong(actionRequest,
				OmsbLogProceduresConstants.LOGGED_PROCEDURE_ID + StringPool.DASH + (i + 1));
		log.debug("Logged Procedure Id --> " + loggedProcedureId);

		TraineeLoggedProcedureDetails traineeLoggedProcedureDetails;
		if (loggedProcedureId != 0) {
			traineeLoggedProcedureDetails = traineeLoggedProcedureDetailsLocalService
					.fetchTraineeLoggedProcedureDetails(loggedProcedureId);
		} else {
			long traineeLoggedProcedureId = counterLocalService
					.increment(TraineeLoggedProcedureDetails.class.getName());
			traineeLoggedProcedureDetails = traineeLoggedProcedureDetailsLocalService
					.createTraineeLoggedProcedureDetails(traineeLoggedProcedureId);
		}

		String patientId = ParamUtil.getString(actionRequest, OmsbLogProceduresConstants.PATIENT_ID);
		long genderId = ParamUtil.getLong(actionRequest, OmsbLogProceduresConstants.PATIENT_GENDER);
		long patientTypeId = ParamUtil.getLong(actionRequest, OmsbLogProceduresConstants.PATIENT_TYPE);
		long visitTypeId = ParamUtil.getLong(actionRequest, OmsbLogProceduresConstants.VISIT_TYPE);
		String dateOfBirth = ParamUtil.getString(actionRequest, OmsbLogProceduresConstants.PATIENT_DOB);
		String datePerformed = ParamUtil.getString(actionRequest,
				OmsbLogProceduresConstants.PROCEDURE_PERFORMED_DATE);
		
		traineeLoggedProcedureDetails.setPatientId(patientId);
		traineeLoggedProcedureDetails.setGenderId(genderId);
		traineeLoggedProcedureDetails.setPatientTypeId(patientTypeId);
		traineeLoggedProcedureDetails.setVisitTypeId(visitTypeId);
		try {
			traineeLoggedProcedureDetails.setPatientDOB(
					new SimpleDateFormat(OmsbLogProceduresConstants.STORE_DATE_FORMAT).parse(dateOfBirth));
		} catch (ParseException e) {
			log.error(e.getMessage(), e);
			setErrorMessage(actionRequest, e.getLocalizedMessage());
		}
		try {
			traineeLoggedProcedureDetails.setProcedurePerformedDate(
					new SimpleDateFormat(OmsbLogProceduresConstants.STORE_DATE_FORMAT).parse(datePerformed));
		} catch (ParseException e) {
			log.error(e.getMessage(), e);
			setErrorMessage(actionRequest, e.getLocalizedMessage());
		}
		traineeLoggedProcedureDetails.setProcedureGroupId(ParamUtil.getLong(actionRequest,
				OmsbLogProceduresConstants.PROCEDURE_GROUP + StringPool.DASH + (i + 1)));
		
		long procedureId = ParamUtil
				.getLong(actionRequest, OmsbLogProceduresConstants.PROCEDURE + StringPool.DASH + (i + 1));
		
		ProcedureMaster procedureMaster = procedureMasterLocalService.fetchProcedureMaster(procedureId);

		if(Validator.isNotNull(procedureMaster.getCptCode())) {
			traineeLoggedProcedureDetails.setCptCode(procedureMaster.getCptCode());
		}

		traineeLoggedProcedureDetails.setProcedureId(procedureId);

		Map<Locale, String> diagnosisMap = new LinkedHashMap<>();
		String diagnosisUS = ParamUtil.getString(actionRequest, OmsbLogProceduresConstants.DIAGNOSIS_US + StringPool.DASH + (i + 1));
		String diagnosisAR = ParamUtil.getString(actionRequest, OmsbLogProceduresConstants.DIAGNOSIS_SA + StringPool.DASH + (i + 1));
		if(Validator.isNotNull(diagnosisUS)) {
			diagnosisMap.put(Locale.US, diagnosisUS);
		}
		if(Validator.isNotNull(diagnosisAR)) {
			diagnosisMap.put(LocaleUtil.fromLanguageId(CommonConstants.LANGUAGE_CODE_ARABIC), diagnosisAR);
		}
		traineeLoggedProcedureDetails.setDiagnosisDescriptionMap(diagnosisMap);

		traineeLoggedProcedureDetails.setTrainingSitesId(ParamUtil.getLong(actionRequest,
				OmsbLogProceduresConstants.CASE_LOCATION + StringPool.DASH + (i + 1)));
		traineeLoggedProcedureDetails.setRoleTypeId(ParamUtil.getLong(actionRequest,
				OmsbLogProceduresConstants.ROLE_TYPE + StringPool.DASH + (i + 1)));
		traineeLoggedProcedureDetails.setFacultyId(ParamUtil.getLong(actionRequest,
				OmsbLogProceduresConstants.SUPERVISOR + StringPool.DASH + (i + 1)));

		Map<Locale, String> commentsMap = new LinkedHashMap<>();
		String commentsUS = ParamUtil.getString(actionRequest, OmsbLogProceduresConstants.COMMENTS_US + StringPool.DASH + (i + 1));
		String commentsAR = ParamUtil.getString(actionRequest, OmsbLogProceduresConstants.COMMENTS_SA + StringPool.DASH + (i + 1));
		if(Validator.isNotNull(commentsUS)) {
			commentsMap.put(Locale.US, commentsUS);
		}
		if(Validator.isNotNull(commentsAR)) {
			commentsMap.put(LocaleUtil.fromLanguageId(CommonConstants.LANGUAGE_CODE_ARABIC), commentsAR);
		}

		
		traineeLoggedProcedureDetails.setTraineeCommentsMap(commentsMap.isEmpty() ? null : commentsMap);

		if (loggedProcedureId != 0) {

			traineeLoggedProcedureDetails.setModifiedDate(new Date());
			traineeLoggedProcedureDetails.setModifiedBy(themeDisplay.getUserId());

			traineeLoggedProcedureDetailsLocalService
					.updateTraineeLoggedProcedureDetails(traineeLoggedProcedureDetails);
		} else {

			traineeLoggedProcedureDetails.setCreateDate(new Date());
			traineeLoggedProcedureDetails.setCreatedBy(themeDisplay.getUserId());
			traineeLoggedProcedureDetails.setModifiedBy(themeDisplay.getUserId());

			traineeLoggedProcedureDetails.setTraineeId(themeDisplay.getUserId());
			traineeLoggedProcedureDetails.setProcedureStatus(OmsbLogProceduresConstants.UNCONFIRMED_STATUS);

			traineeLoggedProcedureDetailsLocalService
					.addTraineeLoggedProcedureDetails(traineeLoggedProcedureDetails);

			String renderURL = OmsbLogProceduresGenerateUrlsUtil.createViewLogProcedureRenderUrl(themeDisplay,
					actionRequest, traineeLoggedProcedureDetails.getTraineeLoggedProcedureDetailsId(),
					Boolean.TRUE);

			omsbViewProceduresSupervisorUtil.sendStatusChangedEmailNotification(traineeLoggedProcedureDetails,
					procedureMaster, themeDisplay, renderURL);

			JSONObject payload = omsbLogProceduresUtil.prepareStatusChangedWebNotificationPayload(
					traineeLoggedProcedureDetails, procedureMaster, themeDisplay, renderURL);
			try {
				userNotificationEventLocalService.sendUserNotificationEvents(
						traineeLoggedProcedureDetails.getFacultyId(),
						OmsbLogProceduresWebPortletKeys.OMSBLOGPROCEDURESWEB,
						UserNotificationDeliveryConstants.TYPE_WEBSITE, payload);
			} catch (PortalException e) {
				log.error(e.getMessage(), e);
				setErrorMessage(actionRequest, e.getLocalizedMessage());
			}

		}
	
	}
	private void removeTraineeLoggedProcedures(String traineeLoggedProcedureIds)
			throws NumberFormatException, PortalException {

		String[] loggedProcedureIds = traineeLoggedProcedureIds.split(StringPool.COMMA);

		for (String loggedProcedureId : loggedProcedureIds) {
			traineeLoggedProcedureDetailsLocalService
					.deleteTraineeLoggedProcedureDetails(Long.valueOf(loggedProcedureId));
		}

		log.debug("---------Procedures Removed Successfully----------");

	}
	
	private void setErrorMessage(ActionRequest actionRequest, String message) {
		SessionErrors.add(actionRequest, message);
		hideDefaultErrorMessage(actionRequest);
	}

	private void setSucessesMessage(ActionRequest actionRequest, String message) {
		SessionMessages.add(actionRequest, message);
	}
	
	@Reference
	private OmsbViewProceduresSupervisorUtil omsbViewProceduresSupervisorUtil;
	
	@Reference
	private OmsbLogProceduresUtil omsbLogProceduresUtil;
	
	@Reference
	CounterLocalService counterLocalService;

	@Reference
	TraineeLoggedProcedureDetailsLocalService traineeLoggedProcedureDetailsLocalService;

	@Reference
	ProcedureMasterLocalService procedureMasterLocalService;

	@Reference
	UserNotificationEventLocalService userNotificationEventLocalService;

	private Log log = LogFactoryUtil.getLog(OmsbEditLogProcedureMVCActionCommand.class.getName());

}