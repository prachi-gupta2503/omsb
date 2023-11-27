package omsb.vehpc.equivalency.mvc.commands.web;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
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
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.common.util.PortalNotification;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.web.notification.configuration.action.OmsbVehpcEquivalencyWebNotificationConfigurationAction;
import omsb.vehpc.equivalency.dto.web.EquivalencyRequest;
import omsb.vehpc.equivalency.dto.web.EquivalencyRequestStatus;
import omsb.vehpc.equivalency.dto.web.EquivalencyStatus;
import omsb.vehpc.equivalency.util.EquivalencyUtil;
import omsb.vehpc.equivalency.web.constants.MVCCommandNames;
import omsb.vehpc.equivalency.web.constants.OmsbVehpcEquivalencyWebPortletKeys;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbVehpcEquivalencyWebPortletKeys.OMSBVEHPCEQUIVALENCYWEB,
		"mvc.command.name=" + MVCCommandNames.ADDITIONAL_COMMENTS_RESOURCE }, service = MVCActionCommand.class)
public class AdditionalCommentsMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		logger.info("calling this resource::::::::");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		/** ===== Add New Record === **/
		String comments = ParamUtil.getString(actionRequest, "additionalComments");
		boolean informCommitteeMembers = ParamUtil.getBoolean(actionRequest, "addCheckbox");
		Map<String, String> headersInfo = commonApi.getHttpHeaderInfoAndBasicAuth();

		long classPK = ParamUtil.getLong(actionRequest, "classPK");

		EquivalencyRequest eqRequest = equivalencyUtil.getEquivalencyRequestById(classPK);
		long personId = 0;
		if (Validator.isNotNull(eqRequest)) {
			personId = eqRequest.getPersonId();
		}
		EquivalencyStatus equivalencyStatus = new EquivalencyStatus();
		equivalencyStatus.setKey(ParamUtil.getString(actionRequest, "eqStatusKey"));
		equivalencyStatus.setName(ParamUtil.getString(actionRequest, "eqStatusName"));
		EquivalencyRequestStatus equivalencyRequestStatus = new EquivalencyRequestStatus();
		equivalencyRequestStatus.setComments(comments);
		equivalencyRequestStatus.setCommenterUserId(themeDisplay.getUserId());
		equivalencyRequestStatus.setEquivalencyRequestId(classPK);
		equivalencyRequestStatus.setEquivalencyStatusId(equivalencyStatus);
		EquivalencyRequestStatus status = equivalencyUtil.updateEqStatusToEqRequestStatus(equivalencyRequestStatus,
				themeDisplay.getScopeGroupId(), headersInfo);
		long equivalencyRequestStatusId = 0;
		if (Validator.isNotNull(status)) {
			equivalencyRequestStatusId = status.getId();
		}
		equivalencyUtil.uploadDocuments(classPK, 0, themeDisplay, actionRequest, personId, equivalencyRequestStatusId,
				"additionalCommentsFile", OmsbVehpcEquivalencyWebPortletKeys.ADDITIONAL_DOCUMENTS_TYPE);
		
		if (informCommitteeMembers) {
			sendNotification(themeDisplay);
		}
		PortletURL renderUrl = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(),
				themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
		renderUrl.setWindowState(LiferayWindowState.NORMAL);
		renderUrl.setParameter("mvcRenderCommandName", MVCCommandNames.EQUIVALENCY_VIEW);
		renderUrl.setParameter("equivalencyRequestId", String.valueOf(classPK));
		actionResponse.sendRedirect(renderUrl.toString());
	}


	private void sendNotification(ThemeDisplay themeDisplay) {
		String value = OmsbVehpcEquivalencyWebNotificationConfigurationAction.additionalCommentsTemplate();
		String subject = "New Comments Added!!";
		JSONObject payload = JSONFactoryUtil.createJSONObject();
		payload.put("message", value);
		Role role = null;
		List<User> roleUsers = new ArrayList<>();
		try {
			role = roleLocalService.getRole(themeDisplay.getCompanyId(), RoleNameConstants.VEHPC_COMMITTEE);
		} catch (PortalException e) {
			logger.error("Exception while getting the VEHPC_RAPPORTEUR role::::: ", e);
		}
		if (Validator.isNotNull(role)) {
			roleUsers = userLocalService.getRoleUsers(role.getRoleId());
		}

		for (User user : roleUsers) {
			PortalNotification.sendPortalNotification(user.getUserId(),
					OmsbVehpcEquivalencyWebPortletKeys.OMSBVEHPCEQUIVALENCYWEB, payload);
			commonApi.sendEmailNotification("testportal@omsb.org", user.getEmailAddress(), subject, value);
		}
		logger.info("temlate values is:::::::" + value);
	}

	private static final Log logger = LogFactoryUtil.getLog(AdditionalCommentsMVCActionCommand.class);

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
