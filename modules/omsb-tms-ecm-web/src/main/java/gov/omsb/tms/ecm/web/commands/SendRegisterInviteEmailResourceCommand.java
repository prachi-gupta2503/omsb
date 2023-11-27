package gov.omsb.tms.ecm.web.commands;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.*;
import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.email.config.configuration.action.OmsbFromEmailConfigurationAction;
import gov.omsb.web.notification.configuration.action.OmsbInviteToRegisterNotificationConfigurationAction;

/**
 * @author Jinal Patel
 */
@Component(immediate = true, property = {
		"javax.portlet.name=" + ECMEMBERSHIPREQUEST,
		"mvc.command.name=/send/register-invite-email" 
	}, 
	service = MVCResourceCommand.class)
public class SendRegisterInviteEmailResourceCommand extends BaseMVCResourceCommand {
	
	private static final Log log = LogFactoryUtil.getLog(SendRegisterInviteEmailResourceCommand.class);
	
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
	
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		log.info("send Register Invite Email Resource Command");

		String cmd = ParamUtil.getString(resourceRequest, CMD2);
		String email = ParamUtil.getString(resourceRequest, "email");
		String RecipientName = ParamUtil.getString(resourceRequest, "name");
		JSONObject responseObj = JSONFactoryUtil.createJSONObject();

		if("sendRegisterInviteEmail".equalsIgnoreCase(cmd)) {
			String bodyTemplate = OmsbInviteToRegisterNotificationConfigurationAction.emailBody();
			String body = bodyTemplate.replace("${RecipientName}", RecipientName);
			omsbCommonApi.sendEmailNotification(OmsbFromEmailConfigurationAction.fromAdminEmail(), email, OmsbInviteToRegisterNotificationConfigurationAction.emailSubject(), body);
			responseObj.put(STATUS, SUCCESS);
		}
		
		JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, responseObj);
	}
}
