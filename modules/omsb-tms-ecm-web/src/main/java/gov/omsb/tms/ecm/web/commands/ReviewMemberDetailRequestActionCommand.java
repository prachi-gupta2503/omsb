package gov.omsb.tms.ecm.web.commands;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
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
/**
 * 
 * @author Rohini Gaud
 *
 */
@Component(immediate = true, property = { "javax.portlet.name=" + ECMembershipRequestPortletKeys.ECMEMBERSHIPREQUEST,
"mvc.command.name=" + MVCCommandNames.REVIEW_MEMBER_DETAIL_ACTION }, service = MVCActionCommand.class)
public class ReviewMemberDetailRequestActionCommand extends BaseMVCActionCommand {
	private static final Log LOGGER = LogFactoryUtil.getLog(ReviewMemberDetailRequestActionCommand.class);
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		String  workDetailsStr = ParamUtil.getString(actionRequest, OmsbEcMembershipConstants.GME_REQUEST_DETAILS);
		LOGGER.info("workDetails > "+workDetailsStr);
		
		JSONObject workflowDetails  = JSONFactoryUtil.createJSONObject(workDetailsStr);

		long ecMemberRequestId = workflowDetails.getLong(OmsbEcMembershipConstants.REQUEST_ID);
		long workflowInstanceId = workflowDetails.getLong(OmsbEcMembershipConstants.WORKFLOW_INSTANCE_ID);
		long taskId = workflowDetails.getLong(OmsbEcMembershipConstants.WORKFLOW_TASK_ID);
		String nextTransitionName = workflowDetails.getString(OmsbEcMembershipConstants.TRANSITION_NAME);
	//	WorflowTaskRequest worflowTaskRequest =
		
		String comment = ParamUtil.getString(actionRequest, OmsbEcMembershipConstants.POPUP_ADJUDICATE_COMMENT);
			LOGGER.info("nextTransitionName :::  "+nextTransitionName);
		
		try {
			LOGGER.info("ecMemberRequestId > "+ecMemberRequestId);
			
			membershipUtil.submitTask(themeDisplay,workflowInstanceId, taskId,nextTransitionName, comment );
			if (nextTransitionName.equalsIgnoreCase(OmsbEcMembershipConstants.GME_REJECT)) {
				SessionErrors.add(actionRequest,  "ec-request-rejected-successfully");
			} else if (nextTransitionName.equalsIgnoreCase(OmsbEcMembershipConstants.GME_DIRECTOR_SEND_TO_PRESIDENT)
					|| nextTransitionName.equalsIgnoreCase(OmsbEcMembershipConstants.GME_DIRECTOR_SEND_TO_VPAA)) {
				SessionMessages.add(actionRequest,  "ec-request-approved-successfully");
			}	
		} catch (PortalException ex) {
			LOGGER.debug(ex);;
		}
		
	}
	
	@Reference(unbind = "-")
	private MembershipUtil membershipUtil;
	
}
