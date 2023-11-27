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
import gov.omsb.programs.web.constants.OmsbProgramConstants;
import gov.omsb.programs.web.constants.OmsbProgramsWebPortletKeys;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel;
import gov.omsb.tms.model.TrainingSitesMaster;
import gov.omsb.tms.service.ProgdurationRotationTrainingsitesRelLocalService;
import gov.omsb.tms.service.TrainingSitesMasterLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbProgramsWebPortletKeys.OMSBPROGRAMSWEB,
		"mvc.command.name=" + OmsbProgramConstants.DELETE_ROTATION_FROM_TRAINING_SITE_MVC_RESOURCE_COMMAND }, service = MVCResourceCommand.class)
public class OmsbDeleteRotationFromTrainingSiteMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		_logger.info("doServeResource Invoked ::: ");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long progdurationRotationTsRelId = ParamUtil.getLong(resourceRequest, OmsbProgramConstants.PROGDURATION_ROTATION_TS_REL_ID, 0l);
		long trainingSiteId = ParamUtil.getLong(resourceRequest, "trainingSiteId", 0l);
		
		TrainingSitesMaster trainingSitesMaster = trainingSitesMasterLocalService.getTrainingSitesMaster(trainingSiteId);
		String trainingSiteName = trainingSitesMaster.getTrainingSiteName(themeDisplay.getLocale());
		
		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		resultJson.put(CommonConstants.SUCCESS, false);
		
		try {
			ProgdurationRotationTrainingsitesRel progdurationRotationTrainingsitesRel  = progdurationRotationTrainingsitesRelLocalService.deleteProgdurationRotationTrainingsitesRel(progdurationRotationTsRelId);
			_logger.debug("doServeResource progdurationRotationTrainingsitesRel Id : " + progdurationRotationTrainingsitesRel.getProgdurationRotationTsRelId() + " Deleted");
			if(Validator.isNotNull(progdurationRotationTrainingsitesRel)) {
				JSONObject trainingSiteJson = JSONFactoryUtil.createJSONObject();
				trainingSiteJson.put( OmsbProgramConstants.TRAINING_SITE_NAME,trainingSiteName);
				trainingSiteJson.put(OmsbTmsCommonConstants.TRAINING_SITE_MASTER_ID,trainingSiteId);
				
				resultJson.put(CommonConstants.SUCCESS, true);
				resultJson.put(CommonConstants.RESULT, trainingSiteJson);
			}
		} catch(Exception e) {
			_logger.error(e);
		}
		JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, resultJson);
		_logger.info("doServeResource Exit ::: ");
	}
	
	@Reference
	private TrainingSitesMasterLocalService trainingSitesMasterLocalService;
		
	@Reference
	private ProgdurationRotationTrainingsitesRelLocalService progdurationRotationTrainingsitesRelLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbDeleteRotationFromTrainingSiteMVCResourceCommand.class.getName());
}

