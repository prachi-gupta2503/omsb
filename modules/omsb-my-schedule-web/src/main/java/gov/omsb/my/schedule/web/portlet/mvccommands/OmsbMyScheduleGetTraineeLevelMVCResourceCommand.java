package gov.omsb.my.schedule.web.portlet.mvccommands;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.my.schedule.web.constants.OmsbMyScheduleWebPortletKeys;
import gov.omsb.tms.model.TraineeLevelMaster;
import gov.omsb.tms.service.ProgdurationTraineelevelBlocksLevelTypeRelLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbMyScheduleWebPortletKeys.OMSBMYSCHEDULEWEB,
		"mvc.command.name="
				+ OmsbMyScheduleWebPortletKeys.GET_TRAINEE_LIST_MVC_RESOURCE_COMMAND }, service = MVCResourceCommand.class)

public class OmsbMyScheduleGetTraineeLevelMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long cohortId = ParamUtil.get(resourceRequest, OmsbMyScheduleWebPortletKeys.COHORT_ID, GetterUtil.DEFAULT_LONG);

		List<TraineeLevelMaster> traineeLevelMasterList = progdurationTraineelevelBlocksLevelTypeRelLocalService
				.getTraineeLevelFromProgramDurationId(cohortId);

		JSONObject resultObject = getTraineeresultJson(traineeLevelMasterList,themeDisplay);

		JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, resultObject);
	}

	private JSONObject getTraineeresultJson(List<TraineeLevelMaster> traineeLevelMasterList,ThemeDisplay themeDisplay) {

		JSONObject resultObject = JSONFactoryUtil.createJSONObject();
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (TraineeLevelMaster traineeLevelMaster : traineeLevelMasterList) {
			JSONObject traineeJson = JSONFactoryUtil.createJSONObject();
			traineeJson.put(OmsbMyScheduleWebPortletKeys.TRAINEE_ID, traineeLevelMaster.getTraineeLevelMasterId());
			traineeJson.put(OmsbMyScheduleWebPortletKeys.TRAINEE_LEVEL, traineeLevelMaster.getTraineeLevelName(themeDisplay.getLocale()));
			jsonArray.put(traineeJson);
		}
		resultObject.put(CommonConstants.SUCCESS, true);
		resultObject.put(CommonConstants.RESULT, jsonArray);
		return resultObject;
	}

	@Reference
	private ProgdurationTraineelevelBlocksLevelTypeRelLocalService progdurationTraineelevelBlocksLevelTypeRelLocalService;

}
