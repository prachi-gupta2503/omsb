package gov.omsb.programs.web.mvccommands;

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

import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.programs.web.constants.OmsbProgramConstants;
import gov.omsb.programs.web.constants.OmsbProgramsWebPortletKeys;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.model.ProgramDurationDetails;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbProgramsWebPortletKeys.OMSBPROGRAMSWEB,
		"mvc.command.name=/get/all-programs" }, service = MVCResourceCommand.class)
public class OmsbGetAllProgramsMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		_logger.info("doServeResource Invoked ::: ");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long programCohortId = ParamUtil.getLong(resourceRequest, OmsbProgramConstants.PROGRAM_COHORT_ID, 0l);
		long currentProgramId = 0;
		ProgramDurationDetails programDurationDetails = programDurationDetailsLocalService.getProgramDurationDetails(programCohortId);
		if(Validator.isNotNull(programDurationDetails)) {
			currentProgramId = programDurationDetails.getProgramId();
		}
		
		List<ProgramMaster> programMasters = programMasterLocalService.getProgramMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		if(currentProgramId != 0) {
			final long currentProgramMasterId = currentProgramId;
			programMasters = programMasters.stream().filter(program -> program.getProgramMasterId() != currentProgramMasterId).collect(Collectors.toList());
		}
		
		JSONObject resultJson = prepareJsonResponse(programMasters, themeDisplay);
		
		JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, resultJson);
		_logger.info("doServeResource Exit ::: ");
	}
	
	private JSONObject prepareJsonResponse(List<ProgramMaster> programMasters, ThemeDisplay themeDisplay) {
		_logger.info("prepareJsonResponse Invoked ::: ");
		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		JSONArray programMasterJSONArray = JSONFactoryUtil.createJSONArray();
		
		for (ProgramMaster program: programMasters) {
			JSONObject programMasterJson = JSONFactoryUtil.createJSONObject();
			programMasterJson.put( "programName", program.getProgramName(themeDisplay.getLocale()));
			programMasterJson.put(OmsbTmsCommonConstants.PROGRAM_MASTER_ID, program.getProgramMasterId());
			programMasterJSONArray.put(programMasterJson);
		}
		resultJson.put(CommonConstants.SUCCESS, true);
		resultJson.put(CommonConstants.RESULT, programMasterJSONArray);
		
		_logger.info("prepareJsonResponse Exit ::: ");
		return resultJson;
	}
	
	@Reference
	private ProgramMasterLocalService programMasterLocalService;
	
	@Reference
	private ProgramDurationDetailsLocalService programDurationDetailsLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbGetAllProgramsMVCResourceCommand.class.getName());
}

