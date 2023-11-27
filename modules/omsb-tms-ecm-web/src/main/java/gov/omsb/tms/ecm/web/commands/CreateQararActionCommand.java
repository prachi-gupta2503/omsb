package gov.omsb.tms.ecm.web.commands;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.qarar.service.QararService;
import gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys;
import gov.omsb.tms.ecm.web.constants.MVCCommandNames;
import gov.omsb.tms.ecm.web.constants.OmsbEcMembershipConstants;
import gov.omsb.tms.ecm.web.util.MembershipUtil;
import gov.omsb.tms.model.EcMemberRequest;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.service.EcMemberRequestLocalService;
import gov.omsb.tms.service.EcMemberRequestLocalServiceUtil;
import gov.omsb.tms.service.ProgramMasterLocalServiceUtil;

/**
 * 
 * @author Rohini Gaud
 *
 */
@Component(immediate = true, property = { "javax.portlet.name=" + ECMembershipRequestPortletKeys.ECMEMBERSHIPREQUEST,
		"mvc.command.name=" + MVCCommandNames.CREATE_QARAR_ACTION }, service = MVCActionCommand.class)
public class CreateQararActionCommand extends BaseMVCActionCommand {

	private static final Log LOGGER = LogFactoryUtil.getLog(CreateQararActionCommand.class);

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String workDetailsStr = ParamUtil.getString(actionRequest, OmsbEcMembershipConstants.QARAR_TASK_DETAILS);
		LOGGER.info("workDetails > " + workDetailsStr);

		JSONObject workflowDetails = JSONFactoryUtil.createJSONObject(workDetailsStr);

		long ecMemberRequestId = workflowDetails.getLong(OmsbEcMembershipConstants.REQUEST_ID);
		long workflowInstanceId = workflowDetails.getLong(OmsbEcMembershipConstants.WORKFLOW_INSTANCE_ID);
		long taskId = workflowDetails.getLong(OmsbEcMembershipConstants.WORKFLOW_TASK_ID);
		String nextTransitionName = workflowDetails.getString(OmsbEcMembershipConstants.TRANSITION_NAME);
		LOGGER.info("nextTransitionName :: " + nextTransitionName);
		String comment = ParamUtil.getString(actionRequest, OmsbEcMembershipConstants.QARAR_COMMENT);

		try {
			EcMemberRequest ecMemberRequest = ecMemberRequestLocalService.getEcMemberRequest(ecMemberRequestId);

			ProgramMaster programMaster = ProgramMasterLocalServiceUtil
					.getProgramMaster(ecMemberRequest.getProgramId());

			User user = UserLocalServiceUtil.getUser(ecMemberRequest.getPotentialEcMemberLruserid());

			long qararRequestId = qararService.createECMembershipQarar(
					programMaster.getProgramName(themeDisplay.getLocale()), user.getFullName(), ecMemberRequestId,
					EcMemberRequest.class.getName(), themeDisplay.getUserId(), ecMemberRequest.getCompanyId(),
					ecMemberRequest.getGroupId());

			if (qararRequestId > 0) {

				ecMemberRequest.setQararRequestId(qararRequestId);
				EcMemberRequestLocalServiceUtil.updateRequest(ecMemberRequest);

				try {
					LOGGER.info("ecMemberRequestId > " + ecMemberRequestId);

					membershipUtil.submitTask(themeDisplay, workflowInstanceId, taskId, nextTransitionName, comment);
					if (nextTransitionName.equalsIgnoreCase(OmsbEcMembershipConstants.REQUEST_QARAR)) {
						SessionMessages.add(actionRequest, "ec-member-request-create-qarar");
					}
					else if (nextTransitionName.equalsIgnoreCase(OmsbEcMembershipConstants.MEMBER_DETAILS_REQUEST)) {
						SessionMessages.add(actionRequest, "ec-member-details-request");
					}
					
				} catch (PortalException ex) {
					LOGGER.debug(ex);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Reference
	private EcMemberRequestLocalService ecMemberRequestLocalService;

	@Reference(unbind = "-")
	private MembershipUtil membershipUtil;

	@Reference(unbind = "-")
	private QararService qararService;

}
