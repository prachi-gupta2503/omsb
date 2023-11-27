package gov.omsb.notify.sau.web.mvcactions;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.notify.sau.web.constants.OmsbNotifySauWebPortletKeys;
import gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel;
import gov.omsb.tms.service.ProgdurationRotationTrainingsitesRelLocalService;

/**
 * 
 * @author Aditya Meghnathi
 *
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbNotifySauWebPortletKeys.OMSBNOTIFYSAUWEB,
		"mvc.command.name=/getNoOfSlotsURL" }, service = MVCResourceCommand.class)
public class OmsbNoOfSlotsMVCResourceCommand extends BaseMVCResourceCommand {

	@SuppressWarnings("deprecation")
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		_logger.debug("OmsbNoOfSlotsMVCResourceCommand doServeResource :::");
		String trainingSitesId = resourceRequest.getParameter(OmsbNotifySauWebPortletKeys.TRAINING_SITE);
		String rotationId = resourceRequest.getParameter(OmsbNotifySauWebPortletKeys.ROTATION);
		ProgdurationRotationTrainingsitesRel progdurationRotationTrainingsitesRel = progdurationRotationTrainingsitesRelLocalService
				.findSlotsByTrainingSitesAndRotationId(Long.parseLong(trainingSitesId), Long.parseLong(rotationId));
		int noOfSlots = progdurationRotationTrainingsitesRel.getNoOfSlots();
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		jsonObject.put("noOfSlots", noOfSlots);
		resourceResponse.getWriter().write(jsonObject.toString());
	}

	@Reference
	private ProgdurationRotationTrainingsitesRelLocalService progdurationRotationTrainingsitesRelLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbNoOfSlotsMVCResourceCommand.class.getName());
}
