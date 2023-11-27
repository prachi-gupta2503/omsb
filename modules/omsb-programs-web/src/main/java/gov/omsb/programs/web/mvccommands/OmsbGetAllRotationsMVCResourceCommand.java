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
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.programs.web.constants.OmsbProgramsWebPortletKeys;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.custom.dto.ProgramStructureDTO;
import gov.omsb.tms.model.RotationMaster;
import gov.omsb.tms.service.ProgramMasterLocalService;
import gov.omsb.tms.service.RotationMasterLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbProgramsWebPortletKeys.OMSBPROGRAMSWEB,
		"mvc.command.name=/get/all-rotations" }, service = MVCResourceCommand.class)
public class OmsbGetAllRotationsMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		_logger.info("doServeResource Invoked ::: ");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long programDurationId = ParamUtil.getLong(resourceRequest, OmsbTmsCommonConstants.PROGRAM_DURATION_ID, 0l);
		
		List<ProgramStructureDTO> prgstrDTOs =  programMasterLocalService.getProgramStructure(programDurationId, themeDisplay.getLocale().toString());
		List<Long> rotationIdList = prgstrDTOs.stream().map(ProgramStructureDTO::getRotationId).collect(Collectors.toList());
		
		List<RotationMaster> rotationMasterList = rotationMasterLocalService.getRotationMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		rotationMasterList = rotationMasterList.stream().filter(rotaion -> !rotationIdList.contains(rotaion.getRotationMasterId())).collect(Collectors.toList());
			
		JSONObject resultJson = prepareJsonResponse(rotationMasterList, themeDisplay);
		
		JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, resultJson);
		_logger.info("doServeResource Exit ::: ");
	}
	
	private JSONObject prepareJsonResponse(List<RotationMaster> rotationMasterList, ThemeDisplay themeDisplay) {
		_logger.info("prepareJsonResponse Invoked ::: ");
		
		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		JSONArray rotationMasterJsonArray = JSONFactoryUtil.createJSONArray();
		for (RotationMaster rotationMaster: rotationMasterList) {
			if(!OmsbTmsCommonConstants.LEAVE.equalsIgnoreCase(rotationMaster.getRotationName(OmsbTmsCommonConstants.LANGUAGE_CODE_ENGLISH))) {
				JSONObject rotationMasterJson = JSONFactoryUtil.createJSONObject();
				rotationMasterJson.put( "rotationName", rotationMaster.getRotationName(themeDisplay.getLocale()));
				rotationMasterJson.put("rotationMasterId", rotationMaster.getRotationMasterId());
				rotationMasterJsonArray.put(rotationMasterJson);
			}
		}
		
		resultJson.put(CommonConstants.SUCCESS, true);
		resultJson.put(CommonConstants.RESULT, rotationMasterJsonArray);
		_logger.info("prepareJsonResponse Exit ::: ");
		return resultJson;
	}
	
	@Reference
	private ProgramMasterLocalService programMasterLocalService;
	
	@Reference
	private RotationMasterLocalService rotationMasterLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbGetAllRotationsMVCResourceCommand.class.getName());
}

