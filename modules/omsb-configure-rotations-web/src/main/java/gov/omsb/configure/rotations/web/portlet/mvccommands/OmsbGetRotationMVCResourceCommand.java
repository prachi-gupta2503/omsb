package gov.omsb.configure.rotations.web.portlet.mvccommands;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.configure.rotations.web.constants.OmsbConfigureRotationsWebPortletKeys;
import gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel;
import gov.omsb.tms.model.RotationMaster;
import gov.omsb.tms.service.ProgdurationRotationTrainingsitesRelLocalService;
import gov.omsb.tms.service.RotationMasterLocalService;

/**
 * @author Komal Gajera
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbConfigureRotationsWebPortletKeys.OMSBCONFIGUREROTATIONSWEB,
"mvc.command.name=" + OmsbConfigureRotationsWebPortletKeys.GET_ROTATION_MVC_RESOURCE_COMMAND }, service = MVCResourceCommand.class)
public class OmsbGetRotationMVCResourceCommand extends BaseMVCResourceCommand  {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		_logger.info("ServeResource Invoked ::: ");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Long programDurationId = ParamUtil.getLong(resourceRequest, OmsbConfigureRotationsWebPortletKeys.PROGRAM_DURATION);
		List<ProgdurationRotationTrainingsitesRel> progdurationRotationTraineelevelBlocksRels = progdurationRotationTrainingsitesRelLocalService.findByProgramDurationId(programDurationId);
        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		List<Long> rotationIds = progdurationRotationTraineelevelBlocksRels.stream().map(ProgdurationRotationTrainingsitesRel::getRotationId).collect(Collectors.toList());
		List<RotationMaster> rotationMasters = new ArrayList<>();
		for (Long rotationId : rotationIds) {
			rotationMasters.add(rotationMasterLocalService.getRotationMaster(rotationId));
		}
		rotationMasters = rotationMasters.stream().sorted((first,second)->{
	        String rotationFirst = first.getRotationName(themeDisplay.getLocale()).toLowerCase();
	        String rotationSecond = second.getRotationName(themeDisplay.getLocale()).toLowerCase();
	        return rotationFirst.compareTo(rotationSecond);
		}).collect(Collectors.toList());
		for (RotationMaster rotationMaster : rotationMasters) {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("rotationMasterId", rotationMaster.getRotationMasterId());
			jsonObject.put("rotationName", rotationMaster.getRotationName(themeDisplay.getLocale()));
			jsonArray.put(jsonObject);
		}
		resourceResponse.getWriter().write(jsonArray.toString());
		_logger.info("ServeResource Exit ::: ");

	}
	
	@Reference
	private RotationMasterLocalService rotationMasterLocalService;
	
	@Reference
	private ProgdurationRotationTrainingsitesRelLocalService progdurationRotationTrainingsitesRelLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbGetRotationMVCResourceCommand.class.getName());

}
