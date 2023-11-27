package gov.omsb.my.schedule.web.portlet.mvccommands;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.my.schedule.web.constants.OmsbMyScheduleWebPortletKeys;
import gov.omsb.tms.model.ProgramDurationDetails;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbMyScheduleWebPortletKeys.OMSBMYSCHEDULEWEB,
		"mvc.command.name="
				+ OmsbMyScheduleWebPortletKeys.GET_COHORT_LIST_MVC_RESOURCE_COMMAND }, service = MVCResourceCommand.class)
public class OmsbMyScheduleGetCohortMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		long programId = ParamUtil.get(resourceRequest, OmsbMyScheduleWebPortletKeys.PROGRAM_ID,
				GetterUtil.DEFAULT_LONG);

		List<ProgramDurationDetails> cohortList = programDurationDetailsLocalService
				.findProgramDurationByProgramId(programId);

		JSONObject resultObject = getCohortresultJson(cohortList);
		JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, resultObject);
	}

	/**
	 * 
	 * @param cohortList
	 * @return
	 */
	private JSONObject getCohortresultJson(List<ProgramDurationDetails> cohortList) {

		JSONObject resultObject = JSONFactoryUtil.createJSONObject();
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (ProgramDurationDetails cohortDetail : cohortList) {
			JSONObject cohortJson = JSONFactoryUtil.createJSONObject();
			cohortJson.put(OmsbMyScheduleWebPortletKeys.COHORT_ID, cohortDetail.getProgDurationId());
			cohortJson.put(OmsbMyScheduleWebPortletKeys.COHORT_NAME, cohortDetail.getAyApplicableForm());
			jsonArray.put(cohortJson);
		}
		resultObject.put(CommonConstants.SUCCESS, true);
		resultObject.put(CommonConstants.RESULT, jsonArray);
		return resultObject;
	}

	@Reference
	private ProgramDurationDetailsLocalService programDurationDetailsLocalService;

}
