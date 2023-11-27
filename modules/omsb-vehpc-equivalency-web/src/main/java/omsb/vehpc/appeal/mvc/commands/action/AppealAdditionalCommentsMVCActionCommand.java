package omsb.vehpc.appeal.mvc.commands.action;

import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserNotificationEventLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.common.util.PortalNotification;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyAppealStatus;
import gov.omsb.web.notification.configuration.action.OmsbVehpcEquivalencyWebNotificationConfigurationAction;
import omsb.vehpc.equivalency.dto.web.EquivalencyRequest;
import omsb.vehpc.equivalency.util.AppealUtil;
import omsb.vehpc.equivalency.util.EquivalencyUtil;
import omsb.vehpc.equivalency.util.HeaderUtil;
import omsb.vehpc.equivalency.web.constants.AppealConstants;
import omsb.vehpc.equivalency.web.constants.OmsbVehpcEquivalencyWebPortletKeys;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbVehpcEquivalencyWebPortletKeys.OMSBVEHPCEQUIVALENCYWEB,
		"mvc.command.name=" + AppealConstants.APPEAL_ADDITIONAL_COMMENTS_RESOURCE }, service = MVCActionCommand.class)
public class AppealAdditionalCommentsMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		/** ===== Add New Record === **/
		boolean informCommitteeMembers = ParamUtil.getBoolean(actionRequest, "addCheckbox");
		String comments = ParamUtil.getString(actionRequest, "additionalComments");
		String roleName = appealUtil.getAppealRoleName(themeDisplay.getUser().getRoles());
		long eqRequestId = ParamUtil.getLong(actionRequest, "equivalencyRequestId");
		long appealId = ParamUtil.getLong(actionRequest, "appealId");
		String tName = ParamUtil.getString(actionRequest, "transitionName");
		String statusKey = getStatusItemKey(tName);
		long statusId = getStatusId(statusKey, themeDisplay.getCompanyId());
		String equivalencyLevelKey = ParamUtil.getString(actionRequest, "equivalencyLevel");
		String equivalencyLevelReason = ParamUtil.getString(actionRequest, "equivalencyLevelReason");
		String equivalencyCertificate = ParamUtil.getString(actionRequest, "equivalencyCertificate");
		long personId = ParamUtil.getLong(actionRequest, "personId");
		
		// Add Appeal status
		EquivalencyAppealStatus equivalencyAppealStatus = appealUtil.saveAppealStatus(themeDisplay, roleName, comments, appealId, statusId, equivalencyLevelKey, equivalencyLevelReason,equivalencyCertificate,themeDisplay.getUserId());

		//Get Persone Id
//		String equivalencyUrl = themeDisplay.getPortalURL() + AppealConstants.REQUEST_URL + eqRequestId;
//		String equivalencyResponse = httpConnector.executeGet(equivalencyUrl, "", headerUtil.getHeaders());
//		EquivalencyRequest equivalencyRequest = CustomObjectMapperUtil.readValue(equivalencyResponse,
//				EquivalencyRequest.class);
//		if (Validator.isNotNull(equivalencyRequest)) {
//			personId = equivalencyRequest.getPersonId();
//		}

		//Document upload
		if(Validator.isNotNull(equivalencyAppealStatus)) {
			equivalencyUtil.uploadDocuments(eqRequestId, appealId, themeDisplay,  actionRequest, personId, equivalencyAppealStatus.getId(),
				"additionalCommentsFile", OmsbVehpcEquivalencyWebPortletKeys.ADDITIONAL_DOCUMENTS_TYPE);
		}
	
		if (informCommitteeMembers) {
			sendNotification(themeDisplay);
		}

	}

	private void sendNotification(ThemeDisplay themeDisplay) {
		String value = OmsbVehpcEquivalencyWebNotificationConfigurationAction.additionalCommentsTemplate();
		String subject = "New Comments Added!!";
		JSONObject payload = JSONFactoryUtil.createJSONObject();
		logger.info("value :::::::::::::: " + value);
		payload.put("message", value);
		Role role = null;
		List<User> roleUsers = new ArrayList<>();
		try {
			role = roleLocalService.getRole(themeDisplay.getCompanyId(), RoleNameConstants.VEHPC_COMMITTEE);
			if (Validator.isNotNull(role)) {
				roleUsers = userLocalService.getRoleUsers(role.getRoleId());
			}

			for (User user : roleUsers) {

				PortalNotification.sendPortalNotification(user.getUserId(),
						OmsbVehpcEquivalencyWebPortletKeys.OMSBVEHPCEQUIVALENCYWEB, payload);
				commonApi.sendEmailNotification("testportal@omsb.org", user.getEmailAddress(), subject, value);
			}
		} catch (PortalException e) {
			logger.error("Exception while getting the VEHPC_RAPPORTEUR role::::: ", e);
		}

	}

	private String getStatusItemKey(String tName) {
		logger.info("tName" + tName);
		String key = "";
		if (AppealConstants.CREATED_KEY.equalsIgnoreCase(tName)) {
			key = AppealConstants.CREATED_KEY;
		} else if (AppealConstants.INSUFFICIENT_KEY.equalsIgnoreCase(tName)) {
			key = AppealConstants.INSUFFICIENT_KEY; // Changed the status to rejected on request of business.
		} else if (AppealConstants.INITIATED_VALUE.equalsIgnoreCase(tName)) {
			key = AppealConstants.INITIATED_KEY;
		} else if (AppealConstants.EQUATED_VALUE.equalsIgnoreCase(tName)) {
			key = AppealConstants.EQUATED_KEY;
		} else if (AppealConstants.COMPLETED_VALUE.equalsIgnoreCase(tName)) {
			key = AppealConstants.COMPLETED_KEY;
		} else {
			key = AppealConstants.COMPLETED_KEY;
		}
		logger.info("Key  " + key);
		return key;
	}

	private long getStatusId(String statusKey, long companyId) {
		ListTypeEntry entry = omsbCommonApi.getListTypeEntryByListTypeItemKey(AppealConstants.PL_Equivalency_Status,
				statusKey, companyId);
		if (Validator.isNotNull(entry)) {
			return entry.getListTypeEntryId();
		}
		return 0;
	}

	private static final Log logger = LogFactoryUtil.getLog(AppealAdditionalCommentsMVCActionCommand.class);

	@Reference
	private HeaderUtil headerUtil;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference(unbind = "-")
	private AppealUtil appealUtil;

	@Reference(unbind = "-")
	private OMSBCommonApi commonApi;

	@Reference(unbind = "-")
	private OMSBHttpConnector httpConnector;

	@Reference(unbind = "-")
	private EquivalencyUtil equivalencyUtil;

	@Reference
	private RoleLocalService roleLocalService;

	@Reference
	private UserLocalService userLocalService;

	@Reference
	private UserNotificationEventLocalService eventLocalService;
}
