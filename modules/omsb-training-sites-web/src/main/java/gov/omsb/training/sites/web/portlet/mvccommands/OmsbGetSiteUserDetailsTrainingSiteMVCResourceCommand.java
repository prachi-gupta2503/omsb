package gov.omsb.training.sites.web.portlet.mvccommands;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.dto.UserMetadata;
import gov.omsb.common.service.util.UserMetadataUtil;
import gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel;
import gov.omsb.tms.service.ProgdurationRotationTrainingsitesRelLocalService;
import gov.omsb.training.sites.web.constants.OmsbTrainingSitesWebPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbTrainingSitesWebPortletKeys.OMSBTRAININGSITESWEB,
		"mvc.command.name="
				+ OmsbTrainingSitesWebPortletKeys.TRAINING_SITES_PROGRAM_USER_DETAIL_MVC_RESOURCE_COMMAND }, service = MVCResourceCommand.class)
public class OmsbGetSiteUserDetailsTrainingSiteMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		_logger.info("ServeResource Invoked ::: ");

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long siteMasterId = ParamUtil.get(resourceRequest, OmsbTrainingSitesWebPortletKeys.TRAINING_SITE_MASTER_ID, 0);

		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		JSONArray requestRaisedToUserArray = JSONFactoryUtil.createJSONArray();

		List<Long> programIds = progdurationRotationTrainingsitesRelLocalService.findByTrainingSitesId(siteMasterId)
				.stream().map(ProgdurationRotationTrainingsitesRel::getProgramDurationId).collect(Collectors.toList());

		Set<Long> userIds = new HashSet<>();
		for (Long programId : programIds) {
			// Get ProgramIds from User metadata from userId
			List<UserMetadata> userMetadataList = userMetadataUtil.getUserMetadataItemsByProgramId(
					themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), programId).getItems();
			for (int i = 0; i < userMetadataList.size(); i++) {
				userIds.add(userMetadataList.get(i).getLrUserId());
			}
		}
		Set<String> relevantRoles = new HashSet<>();
		relevantRoles.add(CommonConstants.ROLE_PROGRAM_ADMINISTRATOR);
		relevantRoles.add(CommonConstants.ROLE_PROGRAM_DIRECTOR);
		relevantRoles.add(CommonConstants.ROLE_CHAIRMAN);

		for (long userId : userIds) {
			if (userId != themeDisplay.getUserId()) {
				List<Role> userRoleList = roleLocalService.getUserRoles(userId);
				boolean isPaPdCh = userRoleList.stream().map(Role::getName).anyMatch(relevantRoles::contains);

				if (isPaPdCh) {
					JSONObject requestRaisedToUserObject = JSONFactoryUtil.createJSONObject();
					String roleName = userRoleList.stream().map(Role::getName).filter(relevantRoles::contains)
							.findFirst().orElse(StringPool.BLANK);
					User requestRaisedToUser = userLocalservice.getUser(userId);
					String requestRaisedToUserDetail = requestRaisedToUser.getFullName() + " (" + roleName + ")";
					String requestRaisedToUserImage = requestRaisedToUser.getPortraitURL(themeDisplay);

					requestRaisedToUserObject.put(OmsbTrainingSitesWebPortletKeys.REQUEST_RAISED_TO, userId);
					requestRaisedToUserObject.put(OmsbTrainingSitesWebPortletKeys.REQUEST_RAISED_TO_USER_DETAIL,
							requestRaisedToUserDetail);
					requestRaisedToUserObject.put(OmsbTrainingSitesWebPortletKeys.REQUEST_RAISED_TO_USER_IMAGE,
							requestRaisedToUserImage);
					requestRaisedToUserArray.put(requestRaisedToUserObject);
				}
			}
		}

		resultJson.put(CommonConstants.SUCCESS, true);
		resultJson.put(CommonConstants.RESULT, requestRaisedToUserArray);
		JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, resultJson);
		_logger.info("ServeResource Exit ::: ");

	}

	@Reference
	private UserMetadataUtil userMetadataUtil;

	@Reference
	private RoleLocalService roleLocalService;

	@Reference
	private UserLocalService userLocalservice;

	@Reference
	private ProgdurationRotationTrainingsitesRelLocalService progdurationRotationTrainingsitesRelLocalService;

	private static final Log _logger = LogFactoryUtil
			.getLog(OmsbGetSiteUserDetailsTrainingSiteMVCResourceCommand.class);

}
