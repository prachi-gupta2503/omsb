package gov.omsb.raise.share.rotation.request.web.mvccommands;

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

import java.util.Arrays;
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
import gov.omsb.raise.share.rotation.request.web.constants.OmsbRaiseShareRotationRequestWebPortletKeys;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbRaiseShareRotationRequestWebPortletKeys.OMSBRAISESHAREROTATIONREQUESTWEB,
		"mvc.command.name="
				+ OmsbRaiseShareRotationRequestWebPortletKeys.GET_SHARE_ROTATION_PROGRAM_USER_DETAIL_MVC_RESOURCE_COMMAND }, service = MVCResourceCommand.class)
public class OmsbGetUserDetailsRaiseShareRotationRequestMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		_logger.info("ServeResource Invoked ::: ");

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long programDurationId = ParamUtil.get(resourceRequest,
				OmsbRaiseShareRotationRequestWebPortletKeys.PROGRAM_DURATION_ID, 0);

		long programId = programDurationDetailsLocalService.getProgramDurationDetails(programDurationId).getProgramId();
		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		JSONArray requestRaisedToUserArray = JSONFactoryUtil.createJSONArray();
		try {
			// Get ProgramIds from User metadata from userId
			List<UserMetadata> userMetadataList = userMetadataUtil.getUserMetadataItemsByProgramId(
					themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), programId).getItems();
			long[] chairmanUserIds = roleLocalService.getUserPrimaryKeys(
					roleLocalService.fetchRole(themeDisplay.getCompanyId(), CommonConstants.ROLE_CHAIRMAN).getRoleId());
			Set<Long> userIds = Arrays.stream(chairmanUserIds).boxed().collect(Collectors.toSet());
			userIds.addAll(userMetadataList.stream().map(UserMetadata::getLrUserId).collect(Collectors.toSet()));
			_logger.info("UserIds : " + userIds.toString());
			Set<String> relevantRoles = new HashSet<>();
			relevantRoles.add(CommonConstants.ROLE_PROGRAM_ADMINISTRATOR);
			relevantRoles.add(CommonConstants.ROLE_PROGRAM_DIRECTOR);
			relevantRoles.add(CommonConstants.ROLE_CHAIRMAN);

			for (long userId : userIds) {
				if (userId != themeDisplay.getUserId()) {
					User requestRaisedToUser = userLocalservice.getUser(userId);
					List<Role> userRoleList = roleLocalService.getUserRoles(userId);

					boolean isPaPdCh = userRoleList.stream().map(Role::getName).anyMatch(relevantRoles::contains);

					if (isPaPdCh) {
						String roleName = userRoleList.stream().map(Role::getName).filter(relevantRoles::contains)
								.findFirst().orElse(StringPool.BLANK);

						String requestRaisedToUserDetail = requestRaisedToUser.getFullName() + " (" + roleName + ")";
						String requestRaisedToUserImage = requestRaisedToUser.getPortraitURL(themeDisplay);

						JSONObject requestRaisedToUserObject = JSONFactoryUtil.createJSONObject();
						requestRaisedToUserObject.put(OmsbRaiseShareRotationRequestWebPortletKeys.REQUEST_RAISED_TO,
								userId);
						requestRaisedToUserObject.put(
								OmsbRaiseShareRotationRequestWebPortletKeys.REQUEST_RAISED_TO_USER_DETAIL,
								requestRaisedToUserDetail);
						requestRaisedToUserObject.put(
								OmsbRaiseShareRotationRequestWebPortletKeys.REQUEST_RAISED_TO_USER_IMAGE,
								requestRaisedToUserImage);

						requestRaisedToUserArray.put(requestRaisedToUserObject);
					}
				}
			}
			resultJson.put(CommonConstants.SUCCESS, true);
		} catch (Exception e) {
			_logger.error(e);
			resultJson.put(CommonConstants.SUCCESS, false);
		}

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
	private ProgramDurationDetailsLocalService programDurationDetailsLocalService;

	private static final Log _logger = LogFactoryUtil
			.getLog(OmsbGetUserDetailsRaiseShareRotationRequestMVCResourceCommand.class);

}
