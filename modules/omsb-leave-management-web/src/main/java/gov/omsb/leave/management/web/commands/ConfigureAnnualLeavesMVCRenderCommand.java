package gov.omsb.leave.management.web.commands;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.leave.management.web.constants.OmsbLeaveManagementWebConstants;
import gov.omsb.leave.management.web.constants.OmsbLeaveManagementWebPortletKeys;
import gov.omsb.tms.model.LeaveAnnualMaxTrainee;
import gov.omsb.tms.model.LeaveAnnualRule;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.model.TraineeLevelMaster;
import gov.omsb.tms.service.LeaveAnnualMaxTraineeLocalService;
import gov.omsb.tms.service.LeaveAnnualRuleLocalService;
import gov.omsb.tms.service.ProgdurationTraineelevelBlocksLevelTypeRelLocalService;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;
import gov.omsb.tms.service.TraineeLevelMasterLocalService;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbLeaveManagementWebPortletKeys.OMSBLEAVEMANAGEMENTWEB,
		"mvc.command.name="+OmsbLeaveManagementWebConstants.ANNUAL_LEAVE_ADD_EDIT_VIEW_PAGE, }, service = MVCRenderCommand.class)
public class ConfigureAnnualLeavesMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		boolean isFromEdit = ParamUtil.getBoolean(renderRequest, "isEditConfigureAnnualLeaveRule");
		
		if(isFromEdit) {
			long leaveAnnualRuleId = ParamUtil.getLong(renderRequest, "leaveAnnualRuleId");
			
			try {
				LeaveAnnualRule leaveAnnualRule = leaveAnnualRuleLocalService.getLeaveAnnualRule(leaveAnnualRuleId);
				
				if(Validator.isNotNull(leaveAnnualRule)) {
					ProgramMaster programMaster = programMasterLocalService.getProgramMaster(leaveAnnualRule.getProgramMasterId());
					
					DynamicQuery dq = leaveAnnualMaxTraineeLocalService.dynamicQuery();
					dq.add(RestrictionsFactoryUtil.eq("leaveAnnualRuleId", leaveAnnualRule.getLeaveAnnualRuleId()));
					List<LeaveAnnualMaxTrainee> leaveAnnualMaxTraineeList = leaveAnnualMaxTraineeLocalService.dynamicQuery(dq);
					
					//get trainee levels for that particular program
					List<Long> programDurationIdList = programDurationDetailsLocalService.getProgramDurationIdFromProgramIds(Arrays.asList(leaveAnnualRule.getProgramMasterId())); 
					long programDurationId = 0;
					List<TraineeLevelMaster> traineeLevelList = new ArrayList<>();
					if(!programDurationIdList.isEmpty()) {
						programDurationId = programDurationIdList.get(0);
						
						DynamicQuery dqForTraineeLevels = progdurationTraineelevelBlocksLevelTypeRelLocalService.dynamicQuery();
						dqForTraineeLevels.add(RestrictionsFactoryUtil.eq("programDurationId", programDurationId));
						dqForTraineeLevels.setProjection(PropertyFactoryUtil.forName("traineeLevelId"));
						dqForTraineeLevels.addOrder(OrderFactoryUtil.asc("traineeLevelId"));
						List<Long> traineeLevelIds = progdurationTraineelevelBlocksLevelTypeRelLocalService.dynamicQuery(dqForTraineeLevels);
						for(Long traineeLevelMasterId : traineeLevelIds) {
							TraineeLevelMaster traineeLevelMaster = traineeLevelMasterLocalService.getTraineeLevelMaster(traineeLevelMasterId);
							traineeLevelList.add(traineeLevelMaster);
						}
					}
					
					renderRequest.setAttribute("traineeLevelList", traineeLevelList);
					
					renderRequest.setAttribute("leaveAnnualMaxTraineeList",leaveAnnualMaxTraineeList);
					
					SimpleDateFormat sdf = new SimpleDateFormat(OmsbLeaveManagementWebConstants.DD_MM_YYYY_FORMAT);
					renderRequest.setAttribute(OmsbLeaveManagementWebConstants.LEAVE_ANNUAL_RULE_ID,leaveAnnualRuleId);
					renderRequest.setAttribute(OmsbLeaveManagementWebConstants.PROGRAM_MASTER_LIST, Collections.singletonList(programMaster));
					renderRequest.setAttribute(OmsbLeaveManagementWebConstants.LAST_DATE_FOR_SUBMISSION, leaveAnnualRule.getLastDateForSubmission());
					renderRequest.setAttribute(OmsbLeaveManagementWebConstants.AVAILABLE_AT, leaveAnnualRule.getAnnualLeaveAvailableAt());
					renderRequest.setAttribute(OmsbLeaveManagementWebConstants.SDF,sdf);
				}
			
			} catch (PortalException e) {
				log.debug(e.getMessage());
			}
			renderRequest.setAttribute("isFromEdit", isFromEdit);
		}
		else {
			
			DynamicQuery dq = leaveAnnualRuleLocalService.dynamicQuery();
			dq.setProjection(PropertyFactoryUtil.forName(OmsbLeaveManagementWebConstants.PROGRAM_MASTER_ID));
			
			DynamicQuery dqForPrograms = programMasterLocalService.dynamicQuery();
			dqForPrograms.add(PropertyFactoryUtil.forName(OmsbLeaveManagementWebConstants.PROGRAM_MASTER_ID).notIn(dq));
			
			List<ProgramMaster> programMasterList = programMasterLocalService.dynamicQuery(dqForPrograms);
			
			renderRequest.setAttribute(OmsbLeaveManagementWebConstants.PROGRAM_MASTER_LIST, programMasterList);
		}
		
		
		return OmsbLeaveManagementWebConstants.CONFIGURE_ANNUAL_LEAVE_RULES;
	}

	@Reference
	private ProgramMasterLocalService programMasterLocalService;
	
	@Reference
	private TraineeLevelMasterLocalService traineeLevelMasterLocalService;
	
	@Reference
	private ProgramDurationDetailsLocalService programDurationDetailsLocalService;
	
	@Reference
	private ProgdurationTraineelevelBlocksLevelTypeRelLocalService progdurationTraineelevelBlocksLevelTypeRelLocalService;
	
	@Reference
	private LeaveAnnualMaxTraineeLocalService leaveAnnualMaxTraineeLocalService;
	
	@Reference
	private LeaveAnnualRuleLocalService leaveAnnualRuleLocalService;
	
	private Log log = LogFactoryUtil.getLog(ConfigureAnnualLeavesMVCRenderCommand.class.getName());

}
