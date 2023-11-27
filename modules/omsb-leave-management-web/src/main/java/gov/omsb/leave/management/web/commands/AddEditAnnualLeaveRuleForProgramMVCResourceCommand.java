package gov.omsb.leave.management.web.commands;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import gov.omsb.leave.management.web.constants.OmsbLeaveManagementWebConstants;
import gov.omsb.leave.management.web.constants.OmsbLeaveManagementWebPortletKeys;
import gov.omsb.tms.model.LeaveAnnualRule;
import gov.omsb.tms.model.TraineeLevelMaster;
import gov.omsb.tms.service.LeaveAnnualRuleLocalService;
import gov.omsb.tms.service.ProgdurationTraineelevelBlocksLevelTypeRelLocalService;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;
import gov.omsb.tms.service.TraineeLevelMasterLocalService;


@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbLeaveManagementWebPortletKeys.OMSBLEAVEMANAGEMENTWEB,
	        "mvc.command.name="+ OmsbLeaveManagementWebConstants.ADD_NEW_ANNUAL_LEAVE_RULE_FOR_PROGRAM
	    }, 
	    service = MVCResourceCommand.class
)
public class AddEditAnnualLeaveRuleForProgramMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		SimpleDateFormat sdf = new SimpleDateFormat(OmsbLeaveManagementWebConstants.DD_MM_YYYY_FORMAT);
		
		long programId = ParamUtil.getLong(resourceRequest, OmsbLeaveManagementWebConstants.PROGRAM_ID);
		Date lastDateOfSubmission = ParamUtil.getDate(resourceRequest, OmsbLeaveManagementWebConstants.LAST_DATE_OF_SUBMISSION, sdf);
		String availableAt = ParamUtil.getString(resourceRequest, OmsbLeaveManagementWebConstants.AVAILABLE_AT);
		
		LeaveAnnualRule leaveAnnualRule = leaveAnnualRuleLocalService.createLeaveAnnualRule(CounterLocalServiceUtil.increment(LeaveAnnualRule.class.getName(),1));
		leaveAnnualRule.setProgramMasterId(programId);
		leaveAnnualRule.setLastDateForSubmission(lastDateOfSubmission);
		leaveAnnualRule.setAnnualLeaveAvailableAt(availableAt);
		leaveAnnualRule.setCreatedBy(themeDisplay.getUserId());
		leaveAnnualRule.setModifiedBy(themeDisplay.getUserId());
		leaveAnnualRule.setGroupId(themeDisplay.getScopeGroupId());
		leaveAnnualRule.setModifiedDate(new Date());
		leaveAnnualRule.setCreateDate(new Date());
		LeaveAnnualRule leaveAnnualRuleNew =  leaveAnnualRuleLocalService.addLeaveAnnualRule(leaveAnnualRule);
		
		
		//get trainee levels for that particular program
		List<Long> programDurationIdList = programDurationDetailsLocalService.getProgramDurationIdFromProgramIds(Arrays.asList(programId)); 
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

		JSONArray jsonArr = JSONFactoryUtil.createJSONArray();
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		jsonObject.put(OmsbLeaveManagementWebConstants.LEAVE_ANNUAL_RULE_ID,String.valueOf(leaveAnnualRuleNew.getLeaveAnnualRuleId()));
		jsonArr.put(jsonObject);
		
		if(!traineeLevelList.isEmpty()) {
			for(int i=0;i<traineeLevelList.size();i++) {
				JSONObject jsonObj = JSONFactoryUtil.createJSONObject();
				jsonObj.put("traineeLevelMasterId",traineeLevelList.get(i).getTraineeLevelMasterId());
				jsonObj.put("traineeLevelName",traineeLevelList.get(i).getTraineeLevelName(themeDisplay.getLocale()));
				jsonArr.put(jsonObj);
			}
		}
		log.info(jsonArr.toString());
		resourceResponse.getWriter().write(jsonArr.toString());
	}

	@Reference
	private TraineeLevelMasterLocalService traineeLevelMasterLocalService;
	
	@Reference
	private ProgramDurationDetailsLocalService programDurationDetailsLocalService;
	
	@Reference
	private ProgdurationTraineelevelBlocksLevelTypeRelLocalService progdurationTraineelevelBlocksLevelTypeRelLocalService;
	
	
	private Log log = LogFactoryUtil.getLog(AddEditAnnualLeaveRuleForProgramMVCResourceCommand.class.getName());
	
	@Reference
	private LeaveAnnualRuleLocalService leaveAnnualRuleLocalService;

}
