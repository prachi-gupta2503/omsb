package gov.omsb.programs.web.mvccommands;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.programs.web.constants.OmsbProgramConstants;
import gov.omsb.programs.web.constants.OmsbProgramsWebPortletKeys;
import gov.omsb.tms.model.ProgramDurationDetails;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbProgramsWebPortletKeys.OMSBPROGRAMSWEB,
"mvc.command.name=/get/all-program-durations" }, service = MVCResourceCommand.class)
public class OmsbGetAllProgramDurationsMVCResourceCommand extends BaseMVCResourceCommand{
	
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		_logger.info("doServeResource Invoked ::: ");
		
		long programMasterId = ParamUtil.getLong(resourceRequest, OmsbProgramConstants.PROGRAM_MASTER_ID, 0l);
		List<ProgramDurationDetails> programDurationDetails = programDurationDetailsLocalService.findProgramDurationByProgramId(programMasterId);
		
		JSONObject resultJson = prepareJsonResponse(programDurationDetails);
		
		JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, resultJson);
		_logger.info("doServeResource Exit ::: ");
	}
	
	private JSONObject prepareJsonResponse(List<ProgramDurationDetails> programDurationDetails) {
		_logger.info("prepareJsonResponse Invoked ::: ");
		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		JSONArray programMasterJSONArray = JSONFactoryUtil.createJSONArray();
		
		for (ProgramDurationDetails durationDetails: programDurationDetails) {
			JSONObject programMasterJson = JSONFactoryUtil.createJSONObject();
			programMasterJson.put( "programDurationName", durationDetails.getAyApplicableForm());
			programMasterJson.put(OmsbProgramConstants.PROGRAM_COHORT_ID, durationDetails.getProgDurationId());
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

	private static final Log _logger = LogFactoryUtil.getLog(OmsbGetAllProgramDurationsMVCResourceCommand.class.getName());

}
