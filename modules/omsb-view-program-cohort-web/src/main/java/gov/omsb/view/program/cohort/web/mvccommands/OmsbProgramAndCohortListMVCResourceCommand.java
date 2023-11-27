package gov.omsb.view.program.cohort.web.mvccommands;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
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
import com.liferay.portal.kernel.util.Validator;
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
import gov.omsb.common.dto.UserMetadataItem;
import gov.omsb.common.service.util.UserMetadataUtil;
import gov.omsb.common.util.CommonUtil;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.service.ProgramMasterLocalService;
import gov.omsb.view.program.cohort.web.constants.OmsbViewProgramCohortWebPortletKeys;

/**
 * @author Jayesh Goswami
 */
@Component(immediate = 	true, property = { "javax.portlet.name=" + OmsbViewProgramCohortWebPortletKeys.OMSBVIEWPROGRAMCOHORTWEB,
"mvc.command.name=" + OmsbViewProgramCohortWebPortletKeys.PROGRAM_AND_COHORT_LIST_MVC_RESOURCE_COMMAND }, service = MVCResourceCommand.class)
public class OmsbProgramAndCohortListMVCResourceCommand extends BaseMVCResourceCommand{

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
	_logger.info("serveResource Invoked ::: ");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long programMasterId = ParamUtil.getLong(resourceRequest, OmsbViewProgramCohortWebPortletKeys.PROGRAM_ID, 0);
		boolean isSuperAdmin = CommonUtil.isSupeAdminUser(themeDisplay.getUser());
		boolean isChairman = CommonUtil.isChairmanUser(themeDisplay.getUser());

		List<Long> programMasterIds = new ArrayList<>();
		List<ProgramMaster> programMasterList = new ArrayList<>();
		if(Validator.isNull(programMasterId)) {
			if (isSuperAdmin || isChairman) {
				_logger.debug("serveResource ::: isSuperAdmin " + isSuperAdmin);
				_logger.debug("serveResource ::: isChairman " + isChairman);
				programMasterList = programMasterLocalService.getProgramMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
				programMasterIds =  programMasterList.stream().map(ProgramMaster::getProgramMasterId).collect(Collectors.toList());
			} else {
				try {
					UserMetadataItem userMetadataItem = userMetadataUtil.getUserMetadataItemsByLrUserId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), themeDisplay.getUserId());
					programMasterIds = CommonUtil.getProgramIdsFromUsermetadataItems(userMetadataItem);
				} catch (Exception e) {
					_logger.error(e);
				}
			}
		} else {
			programMasterIds.add(programMasterId);
		}
		
		_logger.debug("serveResource ::: programMasterIds " + programMasterIds.toString());
		
		programMasterList = programMasterList.stream()
			    .sorted((first, second) -> {
			        String programNameFirst = first.getProgramName(themeDisplay.getLocale()).toLowerCase();
			        String programNameSecond = second.getProgramName(themeDisplay.getLocale()).toLowerCase();
			        return programNameFirst.compareTo(programNameSecond);
			    })
			    .collect(Collectors.toList());
		
		List<String> yearRange = CommonUtil.getYearRangeList(Calendar.getInstance().get(Calendar.YEAR), 10l);

		JSONObject resultJson = prepareJsonResponse(programMasterList, themeDisplay,yearRange);
		
		JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, resultJson);
		_logger.info("doServeResource Exit ::: ");

		
	}
	private JSONObject prepareJsonResponse(List<ProgramMaster> programMasters, ThemeDisplay themeDisplay,List<String> yearRange) {
		_logger.info("prepareJsonResponse Invoked ::: ");
		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		JSONArray programMasterJSONArray = JSONFactoryUtil.createJSONArray();
		JSONArray yearRangeJSONArray = JSONFactoryUtil.createJSONArray();
		
		for (ProgramMaster program: programMasters) {
			JSONObject programMasterJson = JSONFactoryUtil.createJSONObject();
			programMasterJson.put(OmsbTmsCommonConstants.PROGRAM_NAME, program.getProgramName(themeDisplay.getLocale()));
			programMasterJson.put(OmsbTmsCommonConstants.PROGRAM_MASTER_ID, program.getProgramMasterId());
			programMasterJSONArray.put(programMasterJson);
		}
		for (String year: yearRange) {
			JSONObject yearRangeJson = JSONFactoryUtil.createJSONObject();
			yearRangeJson.put( "year", year);
			yearRangeJSONArray.put(yearRangeJson);
		}
		resultJson.put(CommonConstants.SUCCESS, true);
		resultJson.put(CommonConstants.RESULT, programMasterJSONArray);
		resultJson.put("yearRange", yearRangeJSONArray);
		
		_logger.info("prepareJsonResponse Exit ::: ");
		return resultJson;
	}
	
	@Reference(unbind = "_")
	private UserMetadataUtil userMetadataUtil;
	
	@Reference
	ProgramMasterLocalService programMasterLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbProgramAndCohortListMVCResourceCommand.class.getName());


}
