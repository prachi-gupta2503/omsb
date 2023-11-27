package gov.omsb.view.program.cohort.web.mvccommands;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.util.CommonUtil;
import gov.omsb.tms.custom.dto.ProgramCohortDTO;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;
import gov.omsb.view.program.cohort.web.constants.OmsbViewProgramCohortWebPortletKeys;

/**
 * @author Jayesh Goswami
 */
@Component(immediate = 	true, property = { "javax.portlet.name=" + OmsbViewProgramCohortWebPortletKeys.OMSBVIEWPROGRAMCOHORTWEB,
"mvc.command.name=" + OmsbViewProgramCohortWebPortletKeys.GET_DISTINCT_COHORT_MVC_RESOURCE_COMMAND }, service = MVCResourceCommand.class)
public class OmsbGetDistinctCohortMVCResourceCommand extends BaseMVCResourceCommand{

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		_logger.info("serveResource Invoked ::: ");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long programMasterId = ParamUtil.getLong(resourceRequest,"programMasterId", 0);
		List<Long>programMasterIds = new ArrayList<>();
		programMasterIds.add(programMasterId);
	
		List<String> yearRange = CommonUtil.getYearRangeList(Calendar.getInstance().get(Calendar.YEAR), 10l);
		
		List<ProgramCohortDTO> programCohortDTOs = programDurationDetailsLocalService.getProgramAndCohortsFromProgramDuration(programMasterIds, yearRange, themeDisplay.getLocale().toString());
		List<String> selectedYearRange = new ArrayList<>();
		
		for (ProgramCohortDTO programCohortDTO : programCohortDTOs) {
			selectedYearRange.add(programCohortDTO.getAyApplicableForm());
		}
		
		yearRange = yearRange.stream().filter(id -> !selectedYearRange.contains(id)).collect(Collectors.toList());
		JSONObject resultJson = prepareJsonResponse(yearRange);
		
		JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, resultJson);
		_logger.info("doServeResource Exit ::: ");

		
	}
	private JSONObject prepareJsonResponse(List<String> yearRange) {
		_logger.info("prepareJsonResponse Invoked ::: ");
		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		JSONArray yearRangeJSONArray = JSONFactoryUtil.createJSONArray();
	
		for (String year: yearRange) {
			JSONObject yearRangeJson = JSONFactoryUtil.createJSONObject();
			yearRangeJson.put( "year", year);
			yearRangeJSONArray.put(yearRangeJson);
		}
		resultJson.put(CommonConstants.SUCCESS, true);
		resultJson.put(CommonConstants.RESULT, yearRangeJSONArray);

		_logger.info("prepareJsonResponse Exit ::: ");
		return resultJson;
	}
	
	@Reference
	ProgramMasterLocalService programMasterLocalService;
	
	@Reference
	ProgramDurationDetailsLocalService programDurationDetailsLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbGetDistinctCohortMVCResourceCommand.class.getName());


}
