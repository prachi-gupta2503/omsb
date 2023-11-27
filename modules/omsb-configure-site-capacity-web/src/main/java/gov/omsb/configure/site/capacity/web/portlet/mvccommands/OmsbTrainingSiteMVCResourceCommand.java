package gov.omsb.configure.site.capacity.web.portlet.mvccommands;

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

import gov.omsb.configure.site.capacity.web.constants.OmsbConfigureSiteCapacityWebPortletKeys;
import gov.omsb.tms.custom.dto.TrainingSiteByPdDTO;
import gov.omsb.tms.service.ProgdurationRotationTrainingsitesRelLocalService;

/**
 * 
 * @author Aditya Meghnathi
 *
 */
@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbConfigureSiteCapacityWebPortletKeys.OMSBCONFIGURESITECAPACITYWEB,
		"mvc.command.name=/getTrainingSiteURL" }, service = MVCResourceCommand.class)
public class OmsbTrainingSiteMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		_logger.info("OmsbTrainingSiteMVCResourceCommand doServeResource :::");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long programDurationId = ParamUtil.get(resourceRequest, OmsbConfigureSiteCapacityWebPortletKeys.COHORT, 0);
		List<TrainingSiteByPdDTO> trainingSiteByPdDTOs = progdurationRotationTrainingsitesRelLocalService
				.getTrainingSitesByCohort(programDurationId, themeDisplay.getLocale().toString());
		
		trainingSiteByPdDTOs = trainingSiteByPdDTOs.stream().sorted((first,second)->{
	        String siteFirst = first.getTrainingSiteName().toLowerCase();
	        String siteSecond = second.getTrainingSiteName().toLowerCase();
	        return siteFirst.compareTo(siteSecond);
		}).collect(Collectors.toList());
		
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (TrainingSiteByPdDTO trainingSiteByPdDTO : trainingSiteByPdDTOs) {
			JSONObject programJson = JSONFactoryUtil.createJSONObject();
			programJson.put(OmsbConfigureSiteCapacityWebPortletKeys.TRAINING_SITE_ID,
					trainingSiteByPdDTO.getTrainingSiteId());
			programJson.put(OmsbConfigureSiteCapacityWebPortletKeys.TRAINING_SITE_NAME,
					trainingSiteByPdDTO.getTrainingSiteName());
			jsonArray.put(programJson);
		}
		JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, jsonArray);
	}

	@Reference
	private ProgdurationRotationTrainingsitesRelLocalService progdurationRotationTrainingsitesRelLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbTrainingSiteMVCResourceCommand.class.getName());
}
