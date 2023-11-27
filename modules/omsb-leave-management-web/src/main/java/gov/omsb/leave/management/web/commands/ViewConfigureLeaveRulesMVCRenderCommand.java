package gov.omsb.leave.management.web.commands;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.leave.management.web.constants.OmsbLeaveManagementWebConstants;
import gov.omsb.leave.management.web.constants.OmsbLeaveManagementWebPortletKeys;
import gov.omsb.tms.model.LeaveProgramMaster;
import gov.omsb.tms.model.LeaveTypes;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.service.LeaveProgramMasterLocalService;
import gov.omsb.tms.service.LeaveTypesLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbLeaveManagementWebPortletKeys.OMSBLEAVEMANAGEMENTWEB, "mvc.command.name="
				+ OmsbLeaveManagementWebConstants.VIEW_CONFIGURELEAVE_PAGE }, service = MVCRenderCommand.class)
public class ViewConfigureLeaveRulesMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		long programMasterId = ParamUtil.getLong(renderRequest, OmsbLeaveManagementWebConstants.PROGRAM_MASTER_ID);
		boolean isAddConfigureLeaveRule = ParamUtil.getBoolean(renderRequest, OmsbLeaveManagementWebConstants.IS_ADDCONFIGURELEAVERULE, false);
		boolean isEditConfigureLeaveRule = ParamUtil.getBoolean(renderRequest, OmsbLeaveManagementWebConstants.IS_EDITCONFIGURELEAVERULE, false);
		boolean isViewConfigureLeaveRule = ParamUtil.getBoolean(renderRequest,OmsbLeaveManagementWebConstants.IS_VIEWCONFIGURELEAVERULE, false);

		try {
			ProgramMaster programMaster = programMasterLocalService.getProgramMaster(programMasterId);
			renderRequest.setAttribute(OmsbLeaveManagementWebConstants.PROGRAM, programMaster);
		} catch (PortalException e) {
			logger.debug(e.getMessage());
		}

		List<LeaveTypes> allLeaveTypeList = leaveTypesLocalService.getLeaveTypeses(-1, -1);

		if (isAddConfigureLeaveRule) {
			DynamicQuery dqForLeaveProgramMaster = leaveProgramMasterLocalService.dynamicQuery();
			dqForLeaveProgramMaster.setProjection(ProjectionFactoryUtil.property(OmsbLeaveManagementWebConstants.PROGRAM_MASTER_ID));

			DynamicQuery dqForProgramMaster = programMasterLocalService.dynamicQuery();
			dqForProgramMaster.add(PropertyFactoryUtil.forName(OmsbLeaveManagementWebConstants.PROGRAM_MASTER_ID).notIn(dqForLeaveProgramMaster));
			List<ProgramMaster> programMasterList = programMasterLocalService.dynamicQuery(dqForProgramMaster);
			renderRequest.setAttribute(OmsbLeaveManagementWebConstants.PROGRAM_MASTER_LIST, programMasterList);

			renderRequest.setAttribute(OmsbLeaveManagementWebConstants.ALL_LEAVE_TYPE_LIST, allLeaveTypeList);

		} else {
			Map<LeaveTypes, Integer> leaveTypeMap = new HashMap<>();
			for (LeaveTypes leaveType : allLeaveTypeList) {
				LeaveProgramMaster leaveProgramMaster = leaveProgramMasterLocalService
						.getLeaveProgramMasterByProgramMasterIdLeaveTypesId(programMasterId,
								leaveType.getLeaveTypesId());

				if (Validator.isNotNull(leaveProgramMaster)) {
					leaveTypeMap.put(leaveType, leaveProgramMaster.getNoOfLeaves());
				} else {
					leaveTypeMap.put(leaveType, 0);
				}
			}
			renderRequest.setAttribute(OmsbLeaveManagementWebConstants.LEAVE_TYPE_MAP, leaveTypeMap);
		}

		renderRequest.setAttribute(OmsbLeaveManagementWebConstants.IS_VIEW, isViewConfigureLeaveRule);
		renderRequest.setAttribute(OmsbLeaveManagementWebConstants.IS_EDIT, isEditConfigureLeaveRule);
		renderRequest.setAttribute(OmsbLeaveManagementWebConstants.IS_ADD, isAddConfigureLeaveRule);

		return OmsbLeaveManagementWebConstants.CONFIGURE_LEAVE_RULES;
	}

	@Reference
	private LeaveProgramMasterLocalService leaveProgramMasterLocalService;

	@Reference
	private LeaveTypesLocalService leaveTypesLocalService;

	@Reference
	private ProgramMasterLocalService programMasterLocalService;

	private Log logger = LogFactoryUtil.getLog(ViewConfigureLeaveRulesMVCRenderCommand.class);

}
