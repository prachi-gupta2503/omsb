package gov.omsb.configure.rotations.web.portlet.mvccommands;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.configure.rotations.web.constants.OmsbConfigureRotationsWebPortletKeys;
import gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel;
import gov.omsb.tms.model.TraineeLevelMaster;
import gov.omsb.tms.service.ProgdurationRotationTrainingsitesRelLocalService;
import gov.omsb.tms.service.ProgdurationTraineelevelBlocksLevelTypeRelLocalService;
import gov.omsb.tms.service.RotationMasterLocalService;
import gov.omsb.tms.service.TraineeLevelMasterLocalService;

/**
 * @author Komal Gajera
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbConfigureRotationsWebPortletKeys.OMSBCONFIGUREROTATIONSWEB,
"mvc.command.name=" + OmsbConfigureRotationsWebPortletKeys.GET_TRAINEE_LEVEL_MVC_RESOURCE_COMMAND }, service = MVCResourceCommand.class)
public class OmsbGetTarineeLevelMVCResourceCommand extends BaseMVCResourceCommand  {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		_logger.info("ServeResource Invoked ::: ");
		Long programDurationId = ParamUtil.getLong(resourceRequest, OmsbConfigureRotationsWebPortletKeys.PROGRAM_DURATION);
		List<ProgdurationTraineelevelBlocksLevelTypeRel> progdurationRotationTraineelevelBlocksRels = progdurationTraineelevelBlocksLevelTypeRelLocalService.findByProgramDurationId(programDurationId);
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (ProgdurationTraineelevelBlocksLevelTypeRel blocksLevelTypeRel : progdurationRotationTraineelevelBlocksRels) {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			TraineeLevelMaster traineeLevelMasters = traineeLevelMasterLocalService
					.getTraineeLevelMaster(blocksLevelTypeRel.getTraineeLevelId());
			jsonObject.put("traineeLevelId", traineeLevelMasters.getTraineeLevelMasterId());
			jsonObject.put("traineeLevelName", traineeLevelMasters.getTraineeLevelName());
			jsonArray.put(jsonObject);
		}
		
		resourceResponse.getWriter().write(jsonArray.toString());
		_logger.info("ServeResource Exit ::: ");
	}
	
	@Reference
	private TraineeLevelMasterLocalService traineeLevelMasterLocalService;
	
	@Reference
	private ProgdurationTraineelevelBlocksLevelTypeRelLocalService progdurationTraineelevelBlocksLevelTypeRelLocalService;
	
	@Reference
	private RotationMasterLocalService rotationMasterLocalService;
	
	@Reference
	private ProgdurationRotationTrainingsitesRelLocalService progdurationRotationTrainingsitesRelLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbGetTarineeLevelMVCResourceCommand.class.getName());

}
