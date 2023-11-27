package gov.omsb.programs.web.mvccommands;

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

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.programs.web.constants.OmsbProgramsWebPortletKeys;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel;
import gov.omsb.tms.service.ProgdurationRotationTrainingsitesRelLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbProgramsWebPortletKeys.OMSBPROGRAMSWEB,
"mvc.command.name=/save/slots-to-rotation-and-training-site" }, service = MVCResourceCommand.class)
public class OmsbSaveSlotsToRoationAndTrainingSiteResourceCommand extends BaseMVCResourceCommand {
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
		_logger.info("doServeResource Invoked ::: ");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long progDurationRotationTsRelId = ParamUtil.getLong(resourceRequest, "progDurationRotationTsRelId", 0l);
		int noOfSlots = ParamUtil.getInteger(resourceRequest, OmsbTmsCommonConstants.No_OF_SLOTS, 0);
		
		boolean isSuccess = false;
		_logger.debug("doServeResource ::: noOfSlots ::: " + noOfSlots);
		_logger.debug("doServeResource ::: progDurationRotationTsRelId ::: " + progDurationRotationTsRelId);
		
		ProgdurationRotationTrainingsitesRel progdurationRotationTrainingsitesRel  = progdurationRotationTrainingsitesRelLocalService.getProgdurationRotationTrainingsitesRel(progDurationRotationTsRelId);
		if(Validator.isNotNull(progdurationRotationTrainingsitesRel)) {
			progdurationRotationTrainingsitesRel.setNoOfSlots(noOfSlots);
			progdurationRotationTrainingsitesRel.setModifiedBy(themeDisplay.getUserId());
			progdurationRotationTrainingsitesRelLocalService.updateProgdurationRotationTrainingsitesRel(progdurationRotationTrainingsitesRel);
			isSuccess = true;
			_logger.debug("progdurationRotationTrainingsitesRel Updated ::: ");
			
		}
		
		JSONObject resultJson = prepareJsonResponse(isSuccess);
		JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, resultJson);
		
		_logger.info("doServeResource Exit ::: ");
	}
	
	private JSONObject prepareJsonResponse(boolean isSuccess) {
		_logger.info("prepareJsonResponse Invoked ::: ");
		
		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		resultJson.put(CommonConstants.SUCCESS, isSuccess);
		
		_logger.info("prepareJsonResponse Exit ::: ");
		return resultJson;
	}
	
	@Reference
	private ProgdurationRotationTrainingsitesRelLocalService progdurationRotationTrainingsitesRelLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbSaveSlotsToRoationAndTrainingSiteResourceCommand.class);
}
