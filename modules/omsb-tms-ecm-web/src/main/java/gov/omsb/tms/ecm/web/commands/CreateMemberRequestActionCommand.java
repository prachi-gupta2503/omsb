package gov.omsb.tms.ecm.web.commands;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys;
import gov.omsb.tms.ecm.web.constants.MVCCommandNames;
import gov.omsb.tms.ecm.web.constants.OmsbEcMembershipConstants;
import gov.omsb.tms.ecm.web.util.MembershipUtil;
import gov.omsb.tms.model.EcMemberRequest;
import gov.omsb.tms.service.EcMemberRequestLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + ECMembershipRequestPortletKeys.ECMEMBERSHIPREQUEST,
		"mvc.command.name=" + MVCCommandNames.CREATE_MEMBER_REQUEST_ACTION }, service = MVCActionCommand.class)
public class CreateMemberRequestActionCommand extends BaseMVCActionCommand {

	private static final Log LOGGER = LogFactoryUtil.getLog(CreateQararActionCommand.class);

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
	
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String workDetailsStr = ParamUtil.getString(actionRequest, OmsbEcMembershipConstants.MEMBER_REQUEST_TASK_DETAILS);
		LOGGER.info("workDetails > " + workDetailsStr);

		JSONObject workflowDetails = JSONFactoryUtil.createJSONObject(workDetailsStr);

		long ecMemberRequestId = workflowDetails.getLong(OmsbEcMembershipConstants.REQUEST_ID);
		long workflowInstanceId = workflowDetails.getLong(OmsbEcMembershipConstants.WORKFLOW_INSTANCE_ID);
		long taskId = workflowDetails.getLong(OmsbEcMembershipConstants.WORKFLOW_TASK_ID);
		String nextTransitionName = workflowDetails.getString(OmsbEcMembershipConstants.TRANSITION_NAME);

		String comment = ParamUtil.getString(actionRequest, OmsbEcMembershipConstants.MEMBER_REQUEST_COMMENT);
		LOGGER.info("nextTransitionName >>> " + nextTransitionName);
		try {
			EcMemberRequest ecMemberRequest = ecMemberRequestLocalService.getEcMemberRequest(ecMemberRequestId);

		//	EcMemberRequestLocalServiceUtil.updateRequest(ecMemberRequest);

			try {
				LOGGER.info("ecMemberRequestId > " + ecMemberRequestId);

				membershipUtil.submitTask(themeDisplay, workflowInstanceId, taskId,	nextTransitionName, comment);
				SessionMessages.add(actionRequest, "ec-send-req-for-member-details");
			} catch (PortalException ex) {
				LOGGER.debug(ex);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Reference
	private EcMemberRequestLocalService ecMemberRequestLocalService;
	
	@Reference(unbind = "-")
	private MembershipUtil membershipUtil;

}
