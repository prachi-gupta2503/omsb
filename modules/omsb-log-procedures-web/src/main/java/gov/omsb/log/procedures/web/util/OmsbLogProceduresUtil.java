package gov.omsb.log.procedures.web.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.email.template.master.common.api.OMSBEmailTemplateMasterCommonApi;
import gov.omsb.email.template.master.common.dto.EmailTemplateMasterDTO;
import gov.omsb.log.procedures.web.constants.OmsbLogProceduresConstants;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.model.ProcedureGroupMaster;
import gov.omsb.tms.model.ProcedureMaster;
import gov.omsb.tms.model.ProgdurationRotationTlPgProcedurePtRel;
import gov.omsb.tms.model.TraineeLoggedProcedureDetails;
import gov.omsb.tms.service.ProcedureGroupMasterLocalServiceUtil;
import gov.omsb.tms.service.ProcedureMasterLocalServiceUtil;
import gov.omsb.view.procedures.supervisor.web.constants.OmsbViewProceduresSupervisorWebPortletKeys;

@Component(immediate = true, service = OmsbLogProceduresUtil.class)
public class OmsbLogProceduresUtil {

	public OmsbLogProceduresUtil() {
		super();
	}

	public static JSONArray getMappedProcedureMastersJSON(
			List<ProgdurationRotationTlPgProcedurePtRel> progdurationRotationTlPgProcedurePtRels,
			ThemeDisplay themeDisplay) throws PortalException {

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (ProgdurationRotationTlPgProcedurePtRel procedureGroupProceduresCPTCodeRel : progdurationRotationTlPgProcedurePtRels) {
			long procedureId = procedureGroupProceduresCPTCodeRel.getProcedureId();
			if (Validator.isNotNull(procedureId)) {
				ProcedureMaster procedureMaster = ProcedureMasterLocalServiceUtil.getProcedureMaster(procedureId);
				JSONObject singleJSONObject = JSONFactoryUtil.createJSONObject();

				singleJSONObject.put(OmsbLogProceduresConstants.ID, procedureMaster.getProcedureMasterId());
				singleJSONObject.put(OmsbLogProceduresConstants.NAME,
						procedureMaster.getProcedureName(themeDisplay.getLanguageId()));

				jsonArray.put(singleJSONObject);
			}
		}

		log.debug("Fetched MappedProcedureMasters Record List Size :: " + jsonArray.length());

		return jsonArray;
	}

	public static JSONArray getProcedureMastersJSON(List<ProcedureMaster> procedureMasters, ThemeDisplay themeDisplay) {

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (ProcedureMaster procedureMaster : procedureMasters) {
			JSONObject singleJSONObject = JSONFactoryUtil.createJSONObject();

			singleJSONObject.put(OmsbLogProceduresConstants.ID, procedureMaster.getProcedureMasterId());
			singleJSONObject.put(OmsbLogProceduresConstants.NAME,
					procedureMaster.getProcedureName(themeDisplay.getLanguageId()));

			jsonArray.put(singleJSONObject);

		}

		log.debug("Fetched ProcedureMasters Record List Size :: " + jsonArray.length());

		return jsonArray;
	}

	public static JSONArray getProcedureGroupMastersJSON(List<ProcedureGroupMaster> procedureGroupMasters, ThemeDisplay themeDisplay) {

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (ProcedureGroupMaster procedureGroupMaster : procedureGroupMasters) {
			JSONObject singleJSONObject = JSONFactoryUtil.createJSONObject();

			singleJSONObject.put(OmsbLogProceduresConstants.ID, procedureGroupMaster.getProcedureGroupMasterId());
			singleJSONObject.put(OmsbLogProceduresConstants.NAME,
					procedureGroupMaster.getProcedureGroupName(themeDisplay.getLanguageId()));

			jsonArray.put(singleJSONObject);

		}

		log.debug("Fetched ProcedureGroupMasters Record List Size :: " + jsonArray.length());

		return jsonArray;
	}

	public static JSONArray getCptCodesMastersJSON(Map<Long, String> cptCodeMasters) {

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (Map.Entry<Long, String> cptCodeMaster : cptCodeMasters.entrySet()) {
			JSONObject singleJSONObject = JSONFactoryUtil.createJSONObject();

			singleJSONObject.put(OmsbLogProceduresConstants.ID, cptCodeMaster.getKey());
			singleJSONObject.put(OmsbLogProceduresConstants.NAME, cptCodeMaster.getValue());

			jsonArray.put(singleJSONObject);

		}

		log.debug("Fetched CptCodesMasters Record List Size :: " + jsonArray.length());

		return jsonArray;
	}

	public static JSONArray getMappedPgMastersJSON(
			List<ProgdurationRotationTlPgProcedurePtRel> progdurationRotationTlPgProcedurePtRels,
			ThemeDisplay themeDisplay) throws PortalException {

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (ProgdurationRotationTlPgProcedurePtRel procedureGroupProceduresCPTCodeRel : progdurationRotationTlPgProcedurePtRels) {
			long procedureGroupId = procedureGroupProceduresCPTCodeRel.getProcedureGroupId();
			if (Validator.isNotNull(procedureGroupId)) {
				ProcedureGroupMaster procedureGroupMaster = ProcedureGroupMasterLocalServiceUtil
						.getProcedureGroupMaster(procedureGroupId);
				JSONObject singleJSONObject = JSONFactoryUtil.createJSONObject();

				singleJSONObject.put(OmsbLogProceduresConstants.ID, procedureGroupMaster.getProcedureGroupMasterId());
				singleJSONObject.put(OmsbLogProceduresConstants.NAME,
						procedureGroupMaster.getProcedureGroupName(themeDisplay.getLanguageId()));

				jsonArray.put(singleJSONObject);
			}
		}

		log.debug("Fetched MappedPgMasters Record List Size :: " + jsonArray.length());

		return jsonArray;

	}

	public static JSONArray createProcedureMasterJSON(List<ProcedureMaster> procedureMasters,
			ThemeDisplay themeDisplay) {

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (ProcedureMaster procedureMaster : procedureMasters) {
			JSONObject singleJSONObject = JSONFactoryUtil.createJSONObject();

			singleJSONObject.put(OmsbLogProceduresConstants.ID, procedureMaster.getProcedureMasterId());
			singleJSONObject.put(OmsbLogProceduresConstants.NAME,
					procedureMaster.getProcedureName(themeDisplay.getLanguageId()));

			jsonArray.put(singleJSONObject);
		}

		return jsonArray;

	}

	public static List<User> getUsersByRoleName(long companyId, String roleName) throws PortalException {

		Role role = RoleLocalServiceUtil.getRole(companyId, roleName);

		return UserLocalServiceUtil.getRoleUsers(role.getRoleId());

	}

	public boolean sendEmailNotificationToSupervisor(TraineeLoggedProcedureDetails loggedProcedureDetails,
			ProcedureMaster procedureMaster, ThemeDisplay themeDisplay, String renderUrl) {


		try {

			User supervisor = UserLocalServiceUtil.getUser(loggedProcedureDetails.getFacultyId());

			//Commented code due to email configuration modeule
//			EmailObjects emailObjects = new EmailObjects();
//			emailObjects.setToAddress(supervisor.getEmailAddress());
//			emailObjects.setBody(OmsbSupervisorEmailConfigurationAction.body());
//			emailObjects.setSubject(OmsbSupervisorEmailConfigurationAction.subject());

			User traineeUser = UserLocalServiceUtil.getUser(loggedProcedureDetails.getTraineeId());

//			String[] oldString = new String[] { OmsbTmsCommonConstants.EMAIL_TEMPLATE_TRAINEE_NAME,
//					OmsbTmsCommonConstants.EMAIL_TEMPLATE_PROCEDURE_NAME,
//					OmsbTmsCommonConstants.EMAIL_TEMPLATE_PROCEDURE_PERFORMED_DATE,
//					OmsbTmsCommonConstants.EMAIL_TEMPLATE_STATUS, OmsbTmsCommonConstants.EMAIL_TEMPLATE_REDIRECT_LINK,
//					OmsbTmsCommonConstants.EMAIL_TEMPLATE_TRAINEE_NAME };
//			
//			String[] newString = new String[] { supervisor.getFullName(),
//					procedureMaster.getProcedureName(themeDisplay.getLocale()),
//					loggedProcedureDetails.getProcedurePerformedDate().toString(),
//					getStatus(loggedProcedureDetails.getProcedureStatus()), renderUrl, traineeUser.getFullName() };

			Map<String,String> emailParameters = new HashMap<>();
			emailParameters.put(OmsbTmsCommonConstants.EMAIL_TEMPLATE_TRAINEE_NAME, traineeUser.getFullName());
			emailParameters.put(OmsbTmsCommonConstants.EMAIL_TEMPLATE_PROCEDURE_NAME, procedureMaster.getProcedureName(supervisor.getLanguageId()));
			emailParameters.put(OmsbTmsCommonConstants.EMAIL_TEMPLATE_PROCEDURE_PERFORMED_DATE, loggedProcedureDetails.getProcedurePerformedDate().toString());
			emailParameters.put(OmsbTmsCommonConstants.EMAIL_TEMPLATE_STATUS, getStatus(loggedProcedureDetails.getProcedureStatus()));
			emailParameters.put(OmsbTmsCommonConstants.EMAIL_TEMPLATE_REDIRECT_LINK, renderUrl);
			
			long templateId = omsbEmailTemplateMasterCommonApi.getTemplateIdByName(OmsbTmsCommonConstants.LOGGED_PROCEDURE_ACTION_STATUS_EMAIL_NOTIFICATION_FOR_SUPERVISOR);
			omsbEmailTemplateMasterCommonApi.sendEmailByTemplateId(templateId, supervisor.getEmailAddress(),
					supervisor.getLanguageId(), emailParameters);
//			emailObjects.setOldSubstitute(oldString);
//			emailObjects.setNewSubstitute(newString);
//
//			EmailUtil.sendEmailNotification(emailObjects);

		} catch (PortalException e) {
			log.error("Error While Sending Emails" + e);
			return false;
		}
		return true;

	}

	public JSONObject prepareStatusChangedWebNotificationPayload(TraineeLoggedProcedureDetails details,
			ProcedureMaster procedureMaster, ThemeDisplay themeDisplay, String renderUrl) {
		log.debug("prepareStatusChangedWebNotificationPayload Invoked ::: " + details.getFacultyId());
		JSONObject payload = JSONFactoryUtil.createJSONObject();
		try {
			User traineeUser = UserLocalServiceUtil.getUser(details.getTraineeId());

			Map<String,String> notificationParamsEN = new HashMap<>();
			notificationParamsEN.put(OmsbTmsCommonConstants.EMAIL_TEMPLATE_PROCEDURE_NAME,procedureMaster.getProcedureName(OmsbTmsCommonConstants.LANGUAGE_CODE_ENGLISH));
			notificationParamsEN.put(OmsbTmsCommonConstants.EMAIL_TEMPLATE_PROCEDURE_PERFORMED_DATE,details.getProcedurePerformedDate().toString());
			notificationParamsEN.put(OmsbTmsCommonConstants.EMAIL_TEMPLATE_STATUS, getStatus(details.getProcedureStatus()));
			notificationParamsEN.put(OmsbTmsCommonConstants.EMAIL_TEMPLATE_SUPERVISOR_NAME, themeDisplay.getUser().getFullName());
			notificationParamsEN.put(OmsbTmsCommonConstants.EMAIL_TEMPLATE_TRAINEE_NAME, traineeUser.getFullName());
			
			Map<String,String> notificationParamsAR = new HashMap<>();
			notificationParamsAR.put(OmsbTmsCommonConstants.EMAIL_TEMPLATE_PROCEDURE_NAME,procedureMaster.getProcedureName(OmsbTmsCommonConstants.LANGUAGE_CODE_ARABIC));
			notificationParamsAR.put(OmsbTmsCommonConstants.EMAIL_TEMPLATE_PROCEDURE_PERFORMED_DATE,details.getProcedurePerformedDate().toString());
			notificationParamsAR.put(OmsbTmsCommonConstants.EMAIL_TEMPLATE_STATUS, getStatus(details.getProcedureStatus()));
			notificationParamsAR.put(OmsbTmsCommonConstants.EMAIL_TEMPLATE_SUPERVISOR_NAME, themeDisplay.getUser().getFullName());
			notificationParamsAR.put(OmsbTmsCommonConstants.EMAIL_TEMPLATE_TRAINEE_NAME, traineeUser.getFullName());
				
			//Commented code due to email configuration modeule
//			String[] oldString = new String[] { OmsbTmsCommonConstants.EMAIL_TEMPLATE_PROCEDURE_NAME,
//					OmsbTmsCommonConstants.EMAIL_TEMPLATE_PROCEDURE_PERFORMED_DATE,
//					OmsbTmsCommonConstants.EMAIL_TEMPLATE_STATUS, OmsbTmsCommonConstants.EMAIL_TEMPLATE_SUPERVISOR_NAME,
//					OmsbTmsCommonConstants.EMAIL_TEMPLATE_TRAINEE_NAME };
//			String[] newString = new String[] { procedureMaster.getProcedureName(themeDisplay.getLocale()),
//					details.getProcedurePerformedDate().toString(),getStatus(details.getProcedureStatus()),
//					themeDisplay.getUser().getFullName(), traineeUser.getFullName() };
//
//			String notificationText = StringUtil.replace(
//					OmsbSupervisorWebNotificationConfigurationAction.notificationTemplate(), oldString, newString);
			
			EmailTemplateMasterDTO emailTemplateMasterDTO = omsbEmailTemplateMasterCommonApi.getEmailTemplateMasterDTOByName(OmsbTmsCommonConstants.LOGGED_PROCEDURE_ACTION_STATUS_EMAIL_NOTIFICATION_FOR_SUPERVISOR);
			payload = omsbEmailTemplateMasterCommonApi.getNotificationPayloadWithLink(themeDisplay.getUser(), themeDisplay.getUser(), emailTemplateMasterDTO.getUserNotificationEnUS(),emailTemplateMasterDTO.getUserNotificationArSA(), renderUrl, notificationParamsEN,notificationParamsAR);
			/*
			 * payload.put(OmsbTmsCommonConstants.USER_ID, themeDisplay.getUserId());
			 * payload.put(OmsbTmsCommonConstants.NOTIFICATION_TEXT, notificationText);
			 * payload.put(OmsbTmsCommonConstants.SENDER_NAME,
			 * themeDisplay.getUser().getFullName());
			 * payload.put(OmsbTmsCommonConstants.VIEW_REDIRECT_LINK, renderUrl);
			 */

		} catch (PortalException e) {
			log.error(e);
		}

		log.debug("prepareStatusChangedWebNotificationPayload Exit ::: ");
		return payload;
	}
	
	private static String getStatus(String status) {
		switch (status) {
		case OmsbViewProceduresSupervisorWebPortletKeys.STATUS_PASS:
			return OmsbViewProceduresSupervisorWebPortletKeys.STATUS_PASSED;
		case OmsbViewProceduresSupervisorWebPortletKeys.STATUS_NOT_PASS:
			return OmsbViewProceduresSupervisorWebPortletKeys.STATUS_NOT_PASSED;
		case OmsbViewProceduresSupervisorWebPortletKeys.STATUS_REFUSE:
			return OmsbViewProceduresSupervisorWebPortletKeys.STATUS_REFUSED;
		case OmsbViewProceduresSupervisorWebPortletKeys.STATUS_UNCONFIRMED:
			return OmsbViewProceduresSupervisorWebPortletKeys.STATUS_UNCONFIRMED;
		default:
			return OmsbViewProceduresSupervisorWebPortletKeys.STATUS_UNCONFIRMED;
		}
	}

	@Reference
	private OMSBEmailTemplateMasterCommonApi omsbEmailTemplateMasterCommonApi;
	
	private static Log log = LogFactoryUtil.getLog(OmsbLogProceduresUtil.class.getName());
}
