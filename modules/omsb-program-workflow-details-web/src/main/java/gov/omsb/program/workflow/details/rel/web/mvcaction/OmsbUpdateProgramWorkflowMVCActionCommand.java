package gov.omsb.program.workflow.details.rel.web.mvcaction;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.program.workflow.details.rel.web.constants.OmsbProgramWorkflowDetailsConstant;
import gov.omsb.program.workflow.details.rel.web.constants.OmsbProgramWorkflowDetailsWebPortletKeys;
import gov.omsb.tms.model.ProgramWorkflowDetailsRel;
import gov.omsb.tms.service.ProgramWorkflowDetailsRelLocalService;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbProgramWorkflowDetailsWebPortletKeys.OMSBPROGRAMWORKFLOWDETAILSWEB,
		"mvc.command.name="
				+ OmsbProgramWorkflowDetailsConstant.UPDATE_PROGRAM_WORKFLOW_DETAILS_MVC_COMMAND_NAME }, service = MVCActionCommand.class)
public class OmsbUpdateProgramWorkflowMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String approvalOrder = ParamUtil.getString(actionRequest, OmsbProgramWorkflowDetailsConstant.APPROVAL_ORDER);

		long programWorkflowDetailsRelId = ParamUtil.getLong(actionRequest,
				OmsbProgramWorkflowDetailsConstant.PROGRAM_WORKFLOW_DETAILS_REL_ID);

		ProgramWorkflowDetailsRel programWorkflowDetailsRel = programWorkflowDetailsRelLocalService
				.getProgramWorkflowDetailsRel(programWorkflowDetailsRelId);

		programWorkflowDetailsRel.setModifiedDate(new Date());
		programWorkflowDetailsRel.setModifiedBy(themeDisplay.getUserId());

		programWorkflowDetailsRel.setWorkflowApprovalOrder(approvalOrder);

		programWorkflowDetailsRelLocalService.updateProgramWorkflowDetailsRel(programWorkflowDetailsRel);

		log.info("Record Updated Successfully");

		String portletName = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);

		PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest),
				portletName, themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);

		redirectURL.setParameter(OmsbProgramWorkflowDetailsConstant.MVC_PATH,
				OmsbProgramWorkflowDetailsConstant.ADD_PROGRAM_WORKFLOW_DETAILS_JSP_PAGE);

		SessionMessages.add(actionRequest, "workflow-details-updated-success");
		SessionMessages.add(actionRequest,
				PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		
		actionResponse.sendRedirect(redirectURL.toString());

	}

	@Reference
	ProgramWorkflowDetailsRelLocalService programWorkflowDetailsRelLocalService;

	private static final Log log = LogFactoryUtil.getLog(OmsbUpdateProgramWorkflowMVCActionCommand.class.getName());

}