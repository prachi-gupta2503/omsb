package gov.omsb.leave.management.web.commands;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
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
		"mvc.command.name="+OmsbLeaveManagementWebConstants.VIEW_ANNUAL_LEAVE_RULE, }, service = MVCRenderCommand.class)
public class ViewAnnualLeaveMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long leaveAnnualRuleId = ParamUtil.getLong(renderRequest, OmsbLeaveManagementWebConstants.LEAVE_ANNUAL_RULE_ID);
		LeaveAnnualRule leaveAnnualRule;
		try {
			leaveAnnualRule = leaveAnnualRuleLocalService.getLeaveAnnualRule(leaveAnnualRuleId);
			long programMasterId = leaveAnnualRule.getProgramMasterId();
			ProgramMaster programMaster = programMasterLocalService.getProgramMaster(programMasterId);
			
			DynamicQuery dq = leaveAnnualMaxTraineeLocalService.dynamicQuery();
			dq.add(RestrictionsFactoryUtil.eq("leaveAnnualRuleId", leaveAnnualRule.getLeaveAnnualRuleId())).addOrder(OrderFactoryUtil.asc("block"));
			List<LeaveAnnualMaxTrainee> leaveAnnualMaxTraineeList = leaveAnnualMaxTraineeLocalService.dynamicQuery(dq);
			
			List<HashMap<String,String>> blockObjList = new ArrayList<>();
			
			for (LeaveAnnualMaxTrainee leaveAnnualMaxTrainee : leaveAnnualMaxTraineeList) {
				HashMap<String, String> blockObj=new HashMap<>();
				StringBuilder block = new StringBuilder("Block" + StringPool.SPACE);
				block.append(leaveAnnualMaxTrainee.getBlock());
				
				if(leaveAnnualMaxTrainee.getWeek()!=0) {
					block.append(StringPool.SPACE + "Week" + StringPool.SPACE);
					block.append(leaveAnnualMaxTrainee.getWeek());
				}
					
				blockObj.put("block",block.toString());
				blockObj.put("maxAllowed", String.valueOf(leaveAnnualMaxTrainee.getMaxTraineeApplyLeave()));
				blockObj.put("allowed", String.valueOf(leaveAnnualMaxTrainee.getMaxTraineeApplyLeave() - leaveAnnualMaxTrainee.getNoOfTraineeTakenLeave()));
				
				blockObjList.add(blockObj);
			}
			
			
			//get trainee levels for that particular program
			List<Long> programDurationIdList = programDurationDetailsLocalService.getProgramDurationIdFromProgramIds(Arrays.asList(programMasterId)); 
			long programDurationId = 0;
			List<String> traineeLevelList = new ArrayList<>();
			if(!programDurationIdList.isEmpty()) {
				programDurationId = programDurationIdList.get(0);
				
				DynamicQuery dqForTraineeLevels = progdurationTraineelevelBlocksLevelTypeRelLocalService.dynamicQuery();
				dqForTraineeLevels.add(RestrictionsFactoryUtil.eq("programDurationId", programDurationId));
				dqForTraineeLevels.setProjection(PropertyFactoryUtil.forName("traineeLevelId"));
				dqForTraineeLevels.addOrder(OrderFactoryUtil.asc("traineeLevelId"));
				List<Long> traineeLevelIds = progdurationTraineelevelBlocksLevelTypeRelLocalService.dynamicQuery(dqForTraineeLevels);
				
				for(Long traineeLevelMasterId : traineeLevelIds) {
					TraineeLevelMaster traineeLevelMaster = traineeLevelMasterLocalService.getTraineeLevelMaster(traineeLevelMasterId);
					traineeLevelList.add(traineeLevelMaster.getTraineeLevelName(themeDisplay.getLocale()));
				}
				Collections.sort(traineeLevelList);
			}
			
			renderRequest.setAttribute("traineeLevels",traineeLevelList);
			renderRequest.setAttribute("blockObjList", blockObjList);
			renderRequest.setAttribute("programName", programMaster.getProgramName(themeDisplay.getLocale()));
			renderRequest.setAttribute("availableAt", leaveAnnualRule.getAnnualLeaveAvailableAt());
			renderRequest.setAttribute("leaveAnnualRuleId", leaveAnnualRuleId);
			
		} catch (PortalException e) {
			log.debug(e.getMessage());
		}
		
		
		return OmsbLeaveManagementWebConstants.VIEW_ANNUAL_LEAVE_JSP;
	}
	
	@Reference
	private ProgramMasterLocalService programMasterLocalService;
	
	
	@Reference
	private LeaveAnnualRuleLocalService leaveAnnualRuleLocalService;
	
	@Reference
	private LeaveAnnualMaxTraineeLocalService leaveAnnualMaxTraineeLocalService;

	@Reference
	private ProgramDurationDetailsLocalService programDurationDetailsLocalService;
	
	@Reference
	private ProgdurationTraineelevelBlocksLevelTypeRelLocalService progdurationTraineelevelBlocksLevelTypeRelLocalService;
	
	@Reference
	private TraineeLevelMasterLocalService traineeLevelMasterLocalService;
	
	private Log log = LogFactoryUtil.getLog(ViewAnnualLeaveMVCRenderCommand.class.getName());
}
