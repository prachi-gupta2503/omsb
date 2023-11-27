package gov.omsb.leave.management.web.commands;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.leave.management.web.constants.OmsbLeaveManagementWebConstants;
import gov.omsb.leave.management.web.constants.OmsbLeaveManagementWebPortletKeys;
import gov.omsb.tms.model.LeaveAnnualMaxTrainee;
import gov.omsb.tms.service.LeaveAnnualMaxTraineeLocalService;

@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbLeaveManagementWebPortletKeys.OMSBLEAVEMANAGEMENTWEB,
	        "mvc.command.name="+ OmsbLeaveManagementWebConstants.VIEW_BLOCK_BY_TRAINEE_LEVEL
	    }, 
	    service = MVCResourceCommand.class
)
public class ViewBlockDetailsByTrainingLevelMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		String traineeLevelName = ParamUtil.getString(resourceRequest, OmsbLeaveManagementWebConstants.TRAINEE_LEVEL_NAME);
		long leaveAnnualRuleId = ParamUtil.getLong(resourceRequest, OmsbLeaveManagementWebConstants.LEAVE_ANNUAL_RULE_ID);
		
		DynamicQuery dq = leaveAnnualMaxTraineeLocalService.dynamicQuery();
		dq.add(RestrictionsFactoryUtil.eq(OmsbLeaveManagementWebConstants.LEAVE_ANNUAL_RULE_ID,leaveAnnualRuleId));
		dq.add(RestrictionsFactoryUtil.like(OmsbLeaveManagementWebConstants.TRAINING_LEVEL,StringPool.PERCENT + traineeLevelName + StringPool.PERCENT));

		
		List<LeaveAnnualMaxTrainee> blockDetailList = leaveAnnualMaxTraineeLocalService.dynamicQuery(dq);
		
		JSONArray jsonArr = JSONFactoryUtil.createJSONArray();
		if(Validator.isNotNull(blockDetailList) && !blockDetailList.isEmpty()) {
			for (LeaveAnnualMaxTrainee leaveAnnualMaxTrainee : blockDetailList) {
				JSONObject jsonObj = JSONFactoryUtil.createJSONObject();
				
				StringBuilder block = new StringBuilder("Block" + StringPool.SPACE);
				block.append(leaveAnnualMaxTrainee.getBlock());
				
				if(leaveAnnualMaxTrainee.getWeek()!=0) {
					block.append(StringPool.SPACE + "Week" + StringPool.SPACE);
					block.append(leaveAnnualMaxTrainee.getWeek());
				}
					
				jsonObj.put("block",block.toString());
				jsonObj.put("maxAllowed", String.valueOf(leaveAnnualMaxTrainee.getMaxTraineeApplyLeave()));
				jsonObj.put("allowed", String.valueOf(leaveAnnualMaxTrainee.getMaxTraineeApplyLeave() - leaveAnnualMaxTrainee.getNoOfTraineeTakenLeave()));
				
				jsonArr.put(jsonObj);
			}
		}
		
		resourceResponse.getWriter().write(jsonArr.toString());
		
	}

	
	@Reference
	private LeaveAnnualMaxTraineeLocalService leaveAnnualMaxTraineeLocalService;
}
