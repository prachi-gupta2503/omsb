package gov.omsb.notify.sau.web.mvcactions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.dto.SauTrainingSites;
import gov.omsb.common.dto.SauTrainingSitesItem;
import gov.omsb.common.service.util.UserMetadataUtil;
import gov.omsb.notify.sau.web.constants.OmsbNotifySauWebPortletKeys;
import gov.omsb.tms.custom.dto.RotationListDTO;
import gov.omsb.tms.service.ProgdurationRotationTrainingsitesRelLocalService;
import gov.omsb.tms.service.RotationMasterLocalService;

/**
 * 
 * @author Aditya Meghnathi
 *
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbNotifySauWebPortletKeys.OMSBNOTIFYSAUWEB,
		"mvc.command.name=/getRotationByTsURL" }, service = MVCResourceCommand.class)
public class OmsbGetRotationsMVCResourceCommand extends BaseMVCResourceCommand {

	@SuppressWarnings("deprecation")
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		_logger.debug("OmsbGetRotationsMVCResourceCommand doServeResource :::");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String trainingSitesId = resourceRequest.getParameter(OmsbNotifySauWebPortletKeys.TRAINING_SITE);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		List<RotationListDTO> rotationListDTOs = progdurationRotationTrainingsitesRelLocalService
				.getRotationsByTrainingSitesId(Long.parseLong(trainingSitesId), themeDisplay.getLocale().toString()).stream()
			    .filter(distinctByKey(RotationListDTO::getRotationMasterId))
			    .collect(Collectors.toList());

		JSONObject rotationAndSauUserJson = JSONFactoryUtil.createJSONObject();
		JSONArray rotationListJson = JSONFactoryUtil.createJSONArray();
		JSONArray sauUserJson = JSONFactoryUtil.createJSONArray();
		for (RotationListDTO rotations : rotationListDTOs) {
			JSONObject rotationObject = JSONFactoryUtil.createJSONObject();
			rotationObject.put("rotationMasterId", rotations.getRotationMasterId());
			rotationObject.put("rotationName", rotations.getRotationName());
			rotationListJson.put(rotationObject);
		}
		rotationAndSauUserJson.put("rotationListJson", rotationListJson);

		SauTrainingSitesItem sauTrainingSitesItem = userMetadataUtil.getSauUserListByTrainingSite(
				themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), Long.parseLong(trainingSitesId));
		List<Long> sauUsers = new ArrayList<>();
		if (Validator.isNotNull(sauTrainingSitesItem) && sauTrainingSitesItem.getItems() != null) {
			sauUsers = (sauTrainingSitesItem.getItems()).stream().map(SauTrainingSites::getSauUserId)
					.collect(Collectors.toList());
		}
		if (!sauUsers.isEmpty()) {
			for (int i = 0; i < sauUsers.size(); i++) {
				JSONObject sauUserObject = JSONFactoryUtil.createJSONObject();
				User user = UserLocalServiceUtil.getUser(sauUsers.get(i));
				String userImage = user.getPortraitURL(themeDisplay);				
				sauUserObject.put("sauUserId", sauUsers.get(i));
				sauUserObject.put("sauUserName", user.getFullName());
				sauUserObject.put("sauUserImage", userImage);
				sauUserJson.put(sauUserObject);
			}
		}
		rotationAndSauUserJson.put("sauUserJson", sauUserJson);
		_logger.debug("rotationAndSauUserJson" + rotationAndSauUserJson);
		resourceResponse.getWriter().write(rotationAndSauUserJson.toString());
	}

	private static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
	    Map<Object, Boolean> seen = new ConcurrentHashMap<>();
	    return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}

	@Reference
	private UserMetadataUtil userMetadataUtil;

	@Reference
	private ProgdurationRotationTrainingsitesRelLocalService progdurationRotationTrainingsitesRelLocalService;

	@Reference
	private RotationMasterLocalService rotationMasterLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbGetRotationsMVCResourceCommand.class.getName());
}
