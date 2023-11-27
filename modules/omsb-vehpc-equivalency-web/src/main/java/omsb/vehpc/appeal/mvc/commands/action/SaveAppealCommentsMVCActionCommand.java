package omsb.vehpc.appeal.mvc.commands.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.common.util.PortalNotification;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyAppealStatus;
import gov.omsb.web.notification.configuration.action.OmsbVehpcEquivalencyWebNotificationConfigurationAction;
import omsb.vehpc.equivalency.util.AppealUtil;
import omsb.vehpc.equivalency.web.constants.AppealConstants;
import omsb.vehpc.equivalency.web.constants.MVCCommandNames;
import omsb.vehpc.equivalency.web.constants.OmsbVehpcEquivalencyWebPortletKeys;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbVehpcEquivalencyWebPortletKeys.OMSBVEHPCEQUIVALENCYWEB,
		"mvc.command.name=" + MVCCommandNames.SAVE_APPEAL_COMMENTS }, service = MVCActionCommand.class)
public class SaveAppealCommentsMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {

		/** ===== Add New Record === **/
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long userId = themeDisplay.getUserId();
		String comments = ParamUtil.getString(actionRequest, "additionalComments");
		long eqRequestId = ParamUtil.getLong(actionRequest, "classPK");
		long eqAppealId = ParamUtil.getLong(actionRequest, "appealId");
		long statusId = ParamUtil.getLong(actionRequest, "statusId");
		long personId = ParamUtil.getLong(actionRequest, "personId");
		String equivalencyLevelKey = ParamUtil.getString(actionRequest, "equivalencyLevel");
		String equivalencyLevelReason = ParamUtil.getString(actionRequest, "equivalencyLevelReason");
		String equivalencyCertificate = ParamUtil.getString(actionRequest, "equivalencyCertificate");
		boolean informCommitteeMembers  = ParamUtil.getBoolean(actionRequest, "addCheckbox");
		String commentType = ParamUtil.getString(actionRequest, "commentType");

		EquivalencyAppealStatus equivalencyAppealStatus = null;
		if(commentType.equals(OmsbVehpcEquivalencyWebPortletKeys.ADDITIONAL_DOCUMENTS_TYPE)) {
			equivalencyAppealStatus = appealUtil.saveAppealStatus(themeDisplay,
					RoleNameConstants.VEHPC_ADMIN, comments, eqAppealId, statusId, equivalencyLevelKey,
					equivalencyLevelReason, equivalencyCertificate, userId);
			long equivalencyAppealStatusId =getEquivalencyAppealStatusId(equivalencyAppealStatus);
			appealUtil.uploadDocuments(eqRequestId, themeDisplay, actionRequest, personId, eqAppealId,equivalencyAppealStatusId,
					"additionalCommentsFile",commentType);
		}
		else if(commentType.equals(OmsbVehpcEquivalencyWebPortletKeys.COMMITTEE_COMMENTS_DOCUMENTS_TYPE)) {
			equivalencyAppealStatus = appealUtil.saveAppealStatus(themeDisplay,
					RoleNameConstants.VEHPC_COMMITTEE, comments, eqAppealId, statusId, equivalencyLevelKey,
					equivalencyLevelReason, equivalencyCertificate, userId);
			long equivalencyAppealStatusId =getEquivalencyAppealStatusId(equivalencyAppealStatus);
			appealUtil.uploadDocuments(eqRequestId, themeDisplay, actionRequest, personId, eqAppealId,equivalencyAppealStatusId,
					"committeeCommentsFile",commentType);
		}
		
		
		
		if (informCommitteeMembers) {
			sendNotification(themeDisplay);
		}
		
		PortletURL renderUrl = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(),
				themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
		renderUrl.setWindowState(LiferayWindowState.NORMAL);
		renderUrl.setParameter("mvcRenderCommandName", AppealConstants.VIEW_APPEAL_ALL);
		renderUrl.setParameter("equivalencyRequestId", String.valueOf(eqRequestId));
		try {
			actionResponse.sendRedirect(renderUrl.toString());
		} catch (IOException e) {
			_log.error("Error in Redirection >>>>>>" + e.getMessage());
		}
		
		return true;
	}
	
	private long getEquivalencyAppealStatusId(EquivalencyAppealStatus equivalencyAppealStatus) {
		long equivalencyAppealStatusId = 0;
		if (Validator.isNotNull(equivalencyAppealStatus)) {
			equivalencyAppealStatusId = equivalencyAppealStatus.getId();
		}
		return equivalencyAppealStatusId;
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
			_log.error("Exception while getting the VEHPC_RAPPORTEUR role::::: ", e);
		}
		if 
		(Validator.isNotNull(role)) {
			roleUsers = userLocalService.getRoleUsers(role.getRoleId());
		}
		
		for (User user :roleUsers) {
			PortalNotification.sendPortalNotification(user.getUserId(), OmsbVehpcEquivalencyWebPortletKeys.OMSBVEHPCEQUIVALENCYWEB, payload);
			omsbCommonApi.sendEmailNotification("testportal@omsb.org", user.getEmailAddress(), subject, value);
		}
		
	}
	
	@Reference
	private RoleLocalService roleLocalService;
	
	@Reference
	private UserLocalService userLocalService;
	
	@Reference(unbind = "-")
	private AppealUtil appealUtil;
	
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
	
	private static final Log _log = LogFactoryUtil.getLog(SaveAppealCommentsMVCActionCommand.class);

}
