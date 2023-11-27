package gov.omsb.faculty.membership.web.commands;

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

import gov.omsb.faculty.membership.web.constants.FacultyMembershipPortletKeys;
import gov.omsb.faculty.membership.web.constants.OmsbEcMembershipConstants;
import gov.omsb.faculty.membership.web.util.MembershipUtil;
@Component(immediate = true, property = { "javax.portlet.name=" + FacultyMembershipPortletKeys.FACULTYMEMBERSHIP,
		"mvc.command.name=submitReviewMemberDetailRequest"},
         service = MVCActionCommand.class)
public class ReviewMemberDetailsActionCommand extends BaseMVCActionCommand {
	private static final Log LOGGER = LogFactoryUtil.getLog(ReviewMemberDetailsActionCommand.class);

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		LOGGER.info("####### ReviewMemberDetailsActionCommand doProcessAction #######");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String workDetailsStr = ParamUtil.getString(actionRequest, OmsbEcMembershipConstants.WORKFLOW_DETAILS);
		
		LOGGER.info("workDetailsStr > " + workDetailsStr);
		JSONObject workflowDetails = JSONFactoryUtil.createJSONObject(workDetailsStr);
		String comment = ParamUtil.getString(actionRequest, OmsbEcMembershipConstants.POPUP_ADJUDICATE_COMMENT);
		long facultyRequestId = workflowDetails.getLong(OmsbEcMembershipConstants.REQUEST_ID);
		long workflowInstanceId = workflowDetails.getLong(OmsbEcMembershipConstants.WORKFLOW_INSTANCE_ID);
		long taskId = workflowDetails.getLong(OmsbEcMembershipConstants.WORKFLOW_TASK_ID);
		String nextTransitionName = workflowDetails.getString(OmsbEcMembershipConstants.TRANSITION_NAME);
		LOGGER.info("nextTransitionName ::: " + nextTransitionName);
//		FacultyRequestLocalServiceUtil.getPotentialFacultyUser(classPk)
		try {
			LOGGER.info("facultyRequestId > " + facultyRequestId);
			membershipUtil.submitTask(themeDisplay, workflowInstanceId, taskId, nextTransitionName, comment);
			if (nextTransitionName.equalsIgnoreCase(OmsbEcMembershipConstants.EC_SECTION_STAFF_REJECT)
					|| nextTransitionName.equalsIgnoreCase(OmsbEcMembershipConstants.EC_SECTION_HEAD_REJECT)
					|| nextTransitionName.equalsIgnoreCase(OmsbEcMembershipConstants.VPAA_REJECT)
					|| nextTransitionName.equalsIgnoreCase(OmsbEcMembershipConstants.GME_DIRECTOR_REJECT)) {
						SessionErrors.add(actionRequest,  "faculty-request-rejected-successfully");
			} else if (nextTransitionName.equalsIgnoreCase(OmsbEcMembershipConstants.EC_SECTION_STAFF_APPROVE)
					|| nextTransitionName.equalsIgnoreCase(OmsbEcMembershipConstants.EC_SECTION_HEAD_APPROVE)
					|| nextTransitionName.equalsIgnoreCase(OmsbEcMembershipConstants.MEMBER_DETAILS_REQUEST)
					|| nextTransitionName.equalsIgnoreCase(OmsbEcMembershipConstants.GME_DIRECTOR_APPROVE)
					|| nextTransitionName.equalsIgnoreCase(OmsbEcMembershipConstants.CHAIRMAN_APPROVE)){
				SessionMessages.add(actionRequest,  "faculty-request-approved-successfully");
			}else if(nextTransitionName.equalsIgnoreCase(OmsbEcMembershipConstants.MEMBER_DETAILS_REJECT)){
				SessionErrors.add(actionRequest,  "faculty-member-details-reject");
			}else if(nextTransitionName.equalsIgnoreCase(OmsbEcMembershipConstants.MEMBER_DETAILS_APPROVE)){
				SessionMessages.add(actionRequest,  "faculty-member-details-complete");
			}
		} catch (PortalException ex) {
			ex.printStackTrace();

		}
	}

	@Reference(unbind = "-")
	private MembershipUtil membershipUtil;
}

