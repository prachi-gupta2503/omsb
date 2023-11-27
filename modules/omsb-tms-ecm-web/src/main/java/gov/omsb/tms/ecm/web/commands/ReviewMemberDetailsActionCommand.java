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
		"mvc.command.name=" + MVCCommandNames.SUBMIT_REVIEW_MEMBER_DETAIL_ACTION }, service = MVCActionCommand.class)
public class ReviewMemberDetailsActionCommand extends BaseMVCActionCommand {
	private static final Log LOGGER = LogFactoryUtil.getLog(ReviewMemberDetailsActionCommand.class);

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String workDetailsStr = ParamUtil.getString(actionRequest, OmsbEcMembershipConstants.WORKFLOW_DETAILS);
		LOGGER.info("workDetails > " + workDetailsStr);
		JSONObject workflowDetails = JSONFactoryUtil.createJSONObject(workDetailsStr);
		String comment = ParamUtil.getString(actionRequest, OmsbEcMembershipConstants.POPUP_ADJUDICATE_COMMENT);
		long ecMemberRequestId = workflowDetails.getLong(OmsbEcMembershipConstants.REQUEST_ID);
		long workflowInstanceId = workflowDetails.getLong(OmsbEcMembershipConstants.WORKFLOW_INSTANCE_ID);
		long taskId = workflowDetails.getLong(OmsbEcMembershipConstants.WORKFLOW_TASK_ID);
		String nextTransitionName = workflowDetails.getString(OmsbEcMembershipConstants.TRANSITION_NAME);
		LOGGER.info("nextTransitionName ::: " + nextTransitionName);
		try {
			LOGGER.info("ecMemberRequestId > " + ecMemberRequestId);
			membershipUtil.submitTask(themeDisplay, workflowInstanceId, taskId, nextTransitionName, comment);
			if (nextTransitionName.equalsIgnoreCase(OmsbEcMembershipConstants.EC_SECTION_STAFF_REJECT)
					|| nextTransitionName.equalsIgnoreCase(OmsbEcMembershipConstants.EC_SECTION_HEAD_REJECT)
					|| nextTransitionName.equalsIgnoreCase(OmsbEcMembershipConstants.VPAA_REJECT)
					) {
						SessionErrors.add(actionRequest,  "ec-request-rejected-successfully");
			} else if (nextTransitionName.equalsIgnoreCase(OmsbEcMembershipConstants.EC_SECTION_STAFF_APPROVE)
					|| nextTransitionName.equalsIgnoreCase(OmsbEcMembershipConstants.EC_SECTION_HEAD_APPROVE)
					|| nextTransitionName.equalsIgnoreCase(OmsbEcMembershipConstants.VPAA_APPROVE)
					|| nextTransitionName.equalsIgnoreCase(OmsbEcMembershipConstants.PRESIDENT_APPROVE)) {
				SessionMessages.add(actionRequest,  "ec-request-approved-successfully");
			}else if(nextTransitionName.equalsIgnoreCase(OmsbEcMembershipConstants.MEMBER_DETAILS_REJECT)){
				SessionErrors.add(actionRequest,  "ec-member-details-reject");
			}else if(nextTransitionName.equalsIgnoreCase(OmsbEcMembershipConstants.MEMBER_DETAILS_APPROVE)){
				SessionMessages.add(actionRequest,  "ec-member-details-approve");
			}
		} catch (PortalException ex) {
			ex.printStackTrace();

		}
	}

	@Reference(unbind = "-")
	private MembershipUtil membershipUtil;
}
