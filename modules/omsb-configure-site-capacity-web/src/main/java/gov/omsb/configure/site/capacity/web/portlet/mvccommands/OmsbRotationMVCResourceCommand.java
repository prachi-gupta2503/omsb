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
import gov.omsb.tms.custom.dto.RotationListDTO;
import gov.omsb.tms.service.ProgdurationRotationTrainingsitesRelLocalService;

/**
 * 
 * @author Aditya Meghnathi
 *
 */
@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbConfigureSiteCapacityWebPortletKeys.OMSBCONFIGURESITECAPACITYWEB,
		"mvc.command.name=/getRotationsURL" }, service = MVCResourceCommand.class)
public class OmsbRotationMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		_logger.info("OmsbRotationMVCResourceCommand doServeResource :::");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long trainingSiteId = ParamUtil.get(resourceRequest, OmsbConfigureSiteCapacityWebPortletKeys.TRAINING_SITE, 0);
		_logger.debug("trainingSiteId" + trainingSiteId);
		List<RotationListDTO> rotationListDTOs = progdurationRotationTrainingsitesRelLocalService
				.getNotSharedRotationsByTrainingSitesId(trainingSiteId, themeDisplay.getLocale().toString());

		rotationListDTOs = rotationListDTOs.stream().sorted((first,second)->{
	        String rotationFirst = first.getRotationName().toLowerCase();
	        String rotationSecond = second.getRotationName().toLowerCase();
	        return rotationFirst.compareTo(rotationSecond);
		}).collect(Collectors.toList());
		JSONArray resultJsonArray = JSONFactoryUtil.createJSONArray();
		rotationListDTOs.forEach(rotationMaster -> {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put(OmsbConfigureSiteCapacityWebPortletKeys.ROTATION_MASTER_ID,
					rotationMaster.getRotationMasterId());
			jsonObject.put(OmsbConfigureSiteCapacityWebPortletKeys.ROTATION_NAME, rotationMaster.getRotationName());
			resultJsonArray.put(jsonObject);
		});
		JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, resultJsonArray);
	}

	@Reference
	private ProgdurationRotationTrainingsitesRelLocalService progdurationRotationTrainingsitesRelLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbRotationMVCResourceCommand.class.getName());
}
