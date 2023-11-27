package gov.omsb.program.workflow.details.rel.web.mvcaction;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
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

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.program.workflow.details.rel.web.constants.OmsbProgramWorkflowDetailsConstant;
import gov.omsb.program.workflow.details.rel.web.constants.OmsbProgramWorkflowDetailsWebPortletKeys;
import gov.omsb.tms.model.ProgramWorkflowDetailsRel;
import gov.omsb.tms.service.ProgramWorkflowDetailsRelLocalService;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbProgramWorkflowDetailsWebPortletKeys.OMSBPROGRAMWORKFLOWDETAILSWEB,
		"mvc.command.name="
				+ OmsbProgramWorkflowDetailsConstant.ADD_PROGRAM_WORKFLOW_DETAILS_MVC_COMMAND_NAME }, service = MVCActionCommand.class)
public class OmsbAddProgramWorkflowMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long programId = ParamUtil.getLong(actionRequest, OmsbProgramWorkflowDetailsConstant.PROGRAM_NAME);
		String approvalOrder = ParamUtil.getString(actionRequest, OmsbProgramWorkflowDetailsConstant.APPROVAL_ORDER);

		long programWorkflowDetailsRelId = counterLocalService.increment(ProgramWorkflowDetailsRel.class.getName());

		ProgramWorkflowDetailsRel programWorkflowDetailsRel = programWorkflowDetailsRelLocalService
				.createProgramWorkflowDetailsRel(programWorkflowDetailsRelId);

		programWorkflowDetailsRel.setGroupId(themeDisplay.getScopeGroupId());
		programWorkflowDetailsRel.setCompanyId(themeDisplay.getCompanyId());
		programWorkflowDetailsRel.setCreateDate(new Date());
		programWorkflowDetailsRel.setCreatedBy(themeDisplay.getUserId());

		programWorkflowDetailsRel.setProgramId(programId);
		programWorkflowDetailsRel.setWorkflowApprovalOrder(approvalOrder);
		programWorkflowDetailsRel.setModifiedDate(new Date());
		programWorkflowDetailsRel.setModifiedBy(themeDisplay.getUserId());

		programWorkflowDetailsRelLocalService.addProgramWorkflowDetailsRel(programWorkflowDetailsRel);

		SessionMessages.add(actionRequest, "workflow-details-added-success");
		SessionMessages.add(actionRequest,
				PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		
		log.info("Record Added Successfully");

	}

	@Reference
	ProgramWorkflowDetailsRelLocalService programWorkflowDetailsRelLocalService;

	@Reference
	CounterLocalService counterLocalService;

	private static final Log log = LogFactoryUtil.getLog(OmsbAddProgramWorkflowMVCActionCommand.class.getName());

}