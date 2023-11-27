package gov.omsb.leave.management.web.commands;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.leave.management.web.constants.OmsbLeaveManagementWebConstants;
import gov.omsb.leave.management.web.constants.OmsbLeaveManagementWebPortletKeys;
import gov.omsb.tms.model.LeaveAnnualMaster;
import gov.omsb.tms.model.LeaveProgramMaster;
import gov.omsb.tms.model.LeaveTypes;
import gov.omsb.tms.service.LeaveAnnualMasterLocalService;
import gov.omsb.tms.service.LeaveProgramMasterLocalService;
import gov.omsb.tms.service.LeaveTypesLocalService;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbLeaveManagementWebPortletKeys.OMSBLEAVEMANAGEMENTWEB, "mvc.command.name="
				+ OmsbLeaveManagementWebConstants.ADD_ANNUAL_LEAVE }, service = MVCActionCommand.class)
public class OmsbAddEditAnnualLeaveMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long programMasterId = ParamUtil.getLong(actionRequest, "program");
		String block = ParamUtil.getString(actionRequest, "blocks");
		int maxNoOfTrainee = ParamUtil.getInteger(actionRequest, "noOfTrainee");
		long trainingLevelId = ParamUtil.getLong(actionRequest, "trainingLevel");
		
		long leaveAnnualMasterId = ParamUtil.getLong(actionRequest,"leaveAnnualMasterId");
		if(leaveAnnualMasterId==0) {
			//Add new Annual Leave
			DynamicQuery dq = leaveTypesLocalService.dynamicQuery();
			dq.add(RestrictionsFactoryUtil.eq("leaveTypes","Annual Leave"));
			List<LeaveTypes> leaveTypeList = leaveTypesLocalService.dynamicQuery(dq);
			
			LeaveProgramMaster leaveProgramMaster = leaveProgramMasterLocalService.getLeaveProgramMasterByProgramMasterIdLeaveTypesId(programMasterId, leaveTypeList.get(0).getLeaveTypesId());
			
			LeaveAnnualMaster leaveAnnualMaster = leaveAnnualMasterLocalService.createLeaveAnnualMaster(counterLocalService.increment(LeaveAnnualMaster.class.getName()));
			leaveAnnualMaster.setLeaveProgramMasterId(leaveProgramMaster.getLeaveProgramMasterId());
			leaveAnnualMaster.setLeaveTypesId(leaveTypeList.get(0).getLeaveTypesId());
			leaveAnnualMaster.setTrainingLevelId(trainingLevelId);
			leaveAnnualMaster.setBlockName(block);
			leaveAnnualMaster.setMaxTraineeApplyLeave(maxNoOfTrainee);
			leaveAnnualMaster.setNoOfTraineeTakenLeave(0);
			leaveAnnualMaster.setCreatedBy(themeDisplay.getUserId());
			leaveAnnualMaster.setModifiedBy(themeDisplay.getUserId());
			
			leaveAnnualMasterLocalService.updateLeaveAnnualMaster(leaveAnnualMaster);
		}
		else {
			//Edit Annual Leave
			LeaveAnnualMaster leaveAnnualMaster = leaveAnnualMasterLocalService.getLeaveAnnualMaster(leaveAnnualMasterId);
			leaveAnnualMaster.setMaxTraineeApplyLeave(maxNoOfTrainee);
			leaveAnnualMasterLocalService.updateLeaveAnnualMaster(leaveAnnualMaster);
		}
		
		
		String portletName = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);

		PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest),
				portletName, themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);

		redirectURL.setParameter(OmsbLeaveManagementWebConstants.IS_ANNUAL_LEAVE_TAB, StringPool.TRUE);
		actionResponse.sendRedirect(redirectURL.toString());
	}

	
	@Reference
	private LeaveAnnualMasterLocalService leaveAnnualMasterLocalService;
	
	@Reference
	private CounterLocalService counterLocalService;
	
	@Reference
	private LeaveProgramMasterLocalService leaveProgramMasterLocalService;
	
	@Reference
	private LeaveTypesLocalService leaveTypesLocalService;
}
