package gov.omsb.notify.sau.web.mvcactions;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.dto.SauTrainingSites;
import gov.omsb.common.dto.SauTrainingSitesItem;
import gov.omsb.common.service.util.UserMetadataUtil;
import gov.omsb.notify.sau.web.constants.OmsbNotifySauWebPortletKeys;
import gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel;
import gov.omsb.tms.service.ProgdurationRotationTrainingsitesRelLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbNotifySauWebPortletKeys.OMSBNOTIFYSAUWEB,
		"mvc.command.name=/getProgramUserDetailMVCResourceURL" }, service = MVCResourceCommand.class)
public class OmsbGetDetailsForNotifyMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		_logger.debug("ServeResource Invoked ::: ");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long progdurationRotationTsRelId = ParamUtil.get(resourceRequest,
				OmsbNotifySauWebPortletKeys.PROGDURATION_ROTATION_TS_REL_ID, 0);
		ProgdurationRotationTrainingsitesRel progdurationRotationTrainingsitesRel = progdurationRotationTrainingsitesRelLocalService
				.getProgdurationRotationTrainingsitesRel(progdurationRotationTsRelId);
		long trainingSiteId = progdurationRotationTrainingsitesRel.getTrainingSitesId();
		int noOfSlots = progdurationRotationTrainingsitesRel.getNoOfSlots();
		SauTrainingSitesItem sauTrainingSitesItem = userMetadataUtil.getSauUserListByTrainingSite(
				themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), trainingSiteId);
		List<Long> sauUsers = new ArrayList<>();
		if (Validator.isNotNull(sauTrainingSitesItem) && sauTrainingSitesItem.getItems() != null) {
			sauUsers = (sauTrainingSitesItem.getItems()).stream().map(SauTrainingSites::getSauUserId)
					.collect(Collectors.toList());
		}
		JSONObject notifyDetailsObject = JSONFactoryUtil.createJSONObject();
		JSONArray sauUserArray = JSONFactoryUtil.createJSONArray();
		JSONArray noOfSlotsArray = JSONFactoryUtil.createJSONArray();
		JSONObject noOfSlotsObject = JSONFactoryUtil.createJSONObject();
		noOfSlotsObject.put("noOfSlot", noOfSlots);
		noOfSlotsObject.put("trainingSiteId", trainingSiteId);
		noOfSlotsObject.put("currentUser", themeDisplay.getUserId());
		noOfSlotsArray.put(noOfSlotsObject);
		if (!sauUsers.isEmpty()) {
			for (int i = 0; i < sauUsers.size(); i++) {
				JSONObject sauUserObject = JSONFactoryUtil.createJSONObject();
				User user = UserLocalServiceUtil.getUser(sauUsers.get(i));
				String userDetail = user.getFullName() + "(SAU)";
				String userImage = user.getPortraitURL(themeDisplay);
				sauUserObject.put("sauUserId", user.getUserId());
				sauUserObject.put("sauUserName", userDetail);
				sauUserObject.put("sauUserImage", userImage);
				sauUserArray.put(sauUserObject);
			}
		}
		notifyDetailsObject.put("sauUserDetails", sauUserArray);
		notifyDetailsObject.put("noOfSlots", noOfSlotsArray);
		_logger.debug("notifyDetailsObject" + notifyDetailsObject);
		resourceResponse.getWriter().write(notifyDetailsObject.toString());
	}

	@Reference
	private UserMetadataUtil userMetadataUtil;

	@Reference
	private ProgdurationRotationTrainingsitesRelLocalService progdurationRotationTrainingsitesRelLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbGetDetailsForNotifyMVCResourceCommand.class);
}
