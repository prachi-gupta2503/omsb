package gov.omsb.leave.management.web.commands;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.leave.management.web.constants.OmsbLeaveManagementWebConstants;
import gov.omsb.leave.management.web.constants.OmsbLeaveManagementWebPortletKeys;
import gov.omsb.tms.model.LeaveProgramMaster;
import gov.omsb.tms.service.LeaveProgramMasterLocalService;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbLeaveManagementWebPortletKeys.OMSBLEAVEMANAGEMENTWEB,
		"javax.portlet.init-param.add-process-action-success-action=false",
		"mvc.command.name=" + OmsbLeaveManagementWebConstants.ADD_EDIT_LEAVE_TYPES }, service = MVCActionCommand.class)
public class EditNoOfLeavesMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String action = ParamUtil.getString(actionRequest, OmsbLeaveManagementWebConstants.ACTION_STATUS);
		long programMasterId = 0;

		if (action.equalsIgnoreCase(OmsbLeaveManagementWebConstants.ADD)) {
			programMasterId = ParamUtil.getLong(actionRequest, OmsbLeaveManagementWebConstants.PROGRAMS);
		} else {
			programMasterId = ParamUtil.getLong(actionRequest, OmsbLeaveManagementWebConstants.PROGRAM_MASTER_ID);
		}

		long[] arrLeaveTypeId = ParamUtil.getLongValues(actionRequest, OmsbLeaveManagementWebConstants.LEAVE_TYPE_ID);
		int[] arrNoOfLeave = ParamUtil.getIntegerValues(actionRequest, OmsbLeaveManagementWebConstants.NO_OF_LEAVES);

		for (int i = 0; i < arrLeaveTypeId.length; i++) {
			if (Validator.isNotNull(programMasterId)) {
			
				LeaveProgramMaster leaveProgramMaster = leaveProgramMasterLocalService
						.getLeaveProgramMasterByProgramMasterIdLeaveTypesId(programMasterId, arrLeaveTypeId[i]);
				if (Validator.isNotNull(leaveProgramMaster)) {
					leaveProgramMaster.setNoOfLeaves(arrNoOfLeave[i]);
					leaveProgramMaster.setModifiedBy(themeDisplay.getUserId());
					leaveProgramMaster.setModifiedDate(new Date());
					leaveProgramMasterLocalService.updateLeaveProgramMaster(leaveProgramMaster);
					
					SessionMessages.add(actionRequest, "leave-configuration-update-success-msg");
				} else {
					LeaveProgramMaster newLeaveProgramMaster = leaveProgramMasterLocalService.createLeaveProgramMaster(
							counterLocalService.increment(LeaveProgramMaster.class.getName(), 1));
					newLeaveProgramMaster.setProgramMasterId(programMasterId);
					newLeaveProgramMaster.setLeaveTypesId(arrLeaveTypeId[i]);
					newLeaveProgramMaster.setNoOfLeaves(arrNoOfLeave[i]);
					newLeaveProgramMaster.setCreatedBy(themeDisplay.getUserId());
					newLeaveProgramMaster.setGroupId(themeDisplay.getScopeGroupId());
					newLeaveProgramMaster.setModifiedBy(themeDisplay.getUserId());
					newLeaveProgramMaster.setCreateDate(new Date());
					newLeaveProgramMaster.setModifiedDate(new Date());
					leaveProgramMasterLocalService.addLeaveProgramMaster(newLeaveProgramMaster);
					

					SessionMessages.add(actionRequest, "leave-configuration-add-success-msg");
				}
				
				
			} else {
				log.info("programMasterId GETTING NULL");
			}
		}
		
		log.info("LEAVE HAS BEEN SUCCESSFULLY CONFIGURED FOR THIS PROGRAM");
	}
	
	
	@Reference
	private LeaveProgramMasterLocalService leaveProgramMasterLocalService;
	
	@Reference
	private CounterLocalService counterLocalService;
	
	private Log log = LogFactoryUtil.getLog(EditNoOfLeavesMVCActionCommand.class.getName());
}
