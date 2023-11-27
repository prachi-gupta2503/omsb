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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
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
import gov.omsb.tms.model.TraineeAdmissionDetailsRel;
import gov.omsb.tms.model.TraineeCohortDetails;
import gov.omsb.tms.model.TraineeLoggedProcedureDetails;
import gov.omsb.tms.service.ProcedureMasterLocalService;
import gov.omsb.tms.service.TraineeAdmissionDetailsRelLocalService;
import gov.omsb.tms.service.TraineeCohortDetailsLocalService;
import gov.omsb.tms.service.TraineeLoggedProcedureDetailsLocalService;
import gov.omsb.view.procedures.supervisor.web.util.OmsbViewProceduresSupervisorUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbLogProceduresWebPortletKeys.OMSBLOGPROCEDURESWEB,
		"mvc.command.name="
				+ OmsbLogProceduresConstants.ADD_LOG_PROCEDURE_ACTION_COMMAND }, service = MVCActionCommand.class)
public class OmsbAddLogProcedureMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long logProceduresCount = ParamUtil.getLong(actionRequest, OmsbLogProceduresConstants.LOG_PROCEDURES_COUNT);

		if (logProceduresCount == 0) {
			SessionErrors.add(actionRequest, "log-procedure-required");
			SessionMessages.add(actionRequest,
					PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		} else {
			long programDurationId = GetterUtil.DEFAULT_LONG;
			long traineeLevelId = GetterUtil.DEFAULT_LONG;
			TraineeAdmissionDetailsRel traineeAdmissionDetailsRel = traineeAdmissionDetailsRelLocalService.findByTraineeId(themeDisplay.getUserId());
			if(Validator.isNotNull(traineeAdmissionDetailsRel)) {
				programDurationId = traineeAdmissionDetailsRel.getProgramDurationId();
				TraineeCohortDetails traineeCohortDetails = traineeCohortDetailsLocalService.findByTraineeAdmissionDetailsRelIdAndIsCurrentTraineeLevel(traineeAdmissionDetailsRel.getTraineeAdmissionDetailsRelId());
				if(Validator.isNotNull(traineeCohortDetails)) {
					traineeLevelId = traineeCohortDetails.getTraineeLevelId();
				}
			}
			SimpleDateFormat inputFormat = new SimpleDateFormat(OmsbLogProceduresConstants.STORE_DATE_FORMAT);
			Date date = inputFormat.parse(ParamUtil.getString(actionRequest,
					OmsbLogProceduresConstants.PROCEDURE_PERFORMED_DATE));
			SimpleDateFormat outputFormat = new SimpleDateFormat(OmsbLogProceduresConstants.GET_DATE_FORMAT);
			String formatPerformedDate = outputFormat.format(date);
			long rotationId = traineeLoggedProcedureDetailsLocalService.getRotationIdByDatePerformed(formatPerformedDate, themeDisplay.getUserId());

			 for (int i = 0; i < logProceduresCount; i++) {
				 processLogProcedure(programDurationId, traineeLevelId, rotationId,themeDisplay, actionRequest, i); 
			 }

			log.debug("-----Procedures Loggged Successfully-----");

			actionResponse.getRenderParameters().setValue("mvcPath", OmsbLogProceduresConstants.VIEW_PROCEDURES_JSP);
			setSucessesMessage(actionRequest, "log-procedure-added");
		}

	}

	private void processLogProcedure(long programDurationId, long traineeLevelId, long rotationId, ThemeDisplay themeDisplay, ActionRequest actionRequest, int i) {
		
		String patientId = ParamUtil.getString(actionRequest, OmsbLogProceduresConstants.PATIENT_ID);
		long genderId = ParamUtil.getLong(actionRequest, OmsbLogProceduresConstants.PATIENT_GENDER);
		long patientTypeId = ParamUtil.getLong(actionRequest, OmsbLogProceduresConstants.PATIENT_TYPE);
		long visitTypeId = ParamUtil.getLong(actionRequest, OmsbLogProceduresConstants.VISIT_TYPE);
		String dateOfBirth = ParamUtil.getString(actionRequest, OmsbLogProceduresConstants.PATIENT_DOB);
		String datePerformed = ParamUtil.getString(actionRequest,
				OmsbLogProceduresConstants.PROCEDURE_PERFORMED_DATE);



		long traineeLoggedProcedureId = counterLocalService
				.increment(TraineeLoggedProcedureDetails.class.getName());
		TraineeLoggedProcedureDetails traineeLoggedProcedureDetails = traineeLoggedProcedureDetailsLocalService
				.createTraineeLoggedProcedureDetails(traineeLoggedProcedureId);
		traineeLoggedProcedureDetails.setProgramDurationId(programDurationId);
		traineeLoggedProcedureDetails.setTraineeLevelId(traineeLevelId);
		traineeLoggedProcedureDetails.setRotationId(rotationId);
		traineeLoggedProcedureDetails.setCompanyId(themeDisplay.getCompanyId());
		traineeLoggedProcedureDetails.setGroupId(themeDisplay.getScopeGroupId());
		traineeLoggedProcedureDetails.setCreateDate(new Date());
		traineeLoggedProcedureDetails.setCreatedBy(themeDisplay.getUserId());
		traineeLoggedProcedureDetails.setModifiedBy(themeDisplay.getUserId());
			traineeLoggedProcedureDetails.setPatientId(patientId);
		traineeLoggedProcedureDetails.setGenderId(genderId);
		traineeLoggedProcedureDetails.setPatientTypeId(patientTypeId);
		traineeLoggedProcedureDetails.setVisitTypeId(visitTypeId);
		try {
			traineeLoggedProcedureDetails.setPatientDOB(
					new SimpleDateFormat(OmsbLogProceduresConstants.STORE_DATE_FORMAT).parse(dateOfBirth));
		} catch (ParseException e) {
			log.error(e.getMessage(), e);
		}
		try {
			traineeLoggedProcedureDetails.setProcedurePerformedDate(
					new SimpleDateFormat(OmsbLogProceduresConstants.STORE_DATE_FORMAT).parse(datePerformed));
		} catch (ParseException e) {
			log.error(e.getMessage(), e);
		}
		traineeLoggedProcedureDetails.setProcedureGroupId(ParamUtil.getLong(actionRequest,
				OmsbLogProceduresConstants.PROCEDURE_GROUP + StringPool.DASH + (i + 1)));
		long procedureId = ParamUtil.getLong(actionRequest,
				OmsbLogProceduresConstants.PROCEDURE + StringPool.DASH + (i + 1));
		
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

		traineeLoggedProcedureDetails.setTraineeId(themeDisplay.getUserId());
		traineeLoggedProcedureDetails.setProcedureStatus(OmsbLogProceduresConstants.UNCONFIRMED_STATUS);

		traineeLoggedProcedureDetailsLocalService
				.addTraineeLoggedProcedureDetails(traineeLoggedProcedureDetails);


		String renderURL = OmsbLogProceduresGenerateUrlsUtil.createViewLogProcedureRenderUrl(themeDisplay,
				actionRequest, traineeLoggedProcedureId, Boolean.TRUE);

		omsbViewProceduresSupervisorUtil.sendStatusChangedEmailNotification(traineeLoggedProcedureDetails,
				procedureMaster, themeDisplay, renderURL);
		
		omsbLogProceduresUtil.sendEmailNotificationToSupervisor(traineeLoggedProcedureDetails, procedureMaster,
				themeDisplay, renderURL);
		
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

	@Reference
	TraineeAdmissionDetailsRelLocalService traineeAdmissionDetailsRelLocalService;
	
	@Reference
	TraineeCohortDetailsLocalService traineeCohortDetailsLocalService;

	private Log log = LogFactoryUtil.getLog(OmsbAddLogProcedureMVCActionCommand.class.getName());

}