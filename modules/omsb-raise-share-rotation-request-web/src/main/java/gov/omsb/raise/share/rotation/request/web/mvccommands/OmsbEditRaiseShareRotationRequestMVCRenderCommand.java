package gov.omsb.raise.share.rotation.request.web.mvccommands;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.dto.UserMetadata;
import gov.omsb.common.service.util.UserMetadataUtil;
import gov.omsb.common.util.CommonUtil;
import gov.omsb.raise.share.rotation.request.web.constants.OmsbRaiseShareRotationRequestWebPortletKeys;
import gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel;
import gov.omsb.tms.model.ProgramDurationDetails;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.model.RotationMaster;
import gov.omsb.tms.model.SharedRotationRequestDetails;
import gov.omsb.tms.service.ProgdurationRotationTrainingsitesRelLocalService;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;
import gov.omsb.tms.service.RotationMasterLocalService;
import gov.omsb.tms.service.SharedRotationRequestDetailsLocalService;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbRaiseShareRotationRequestWebPortletKeys.OMSBRAISESHAREROTATIONREQUESTWEB,
		"mvc.command.name="
				+ OmsbRaiseShareRotationRequestWebPortletKeys.EDIT_RAISE_SHARE_ROTATION_REQUEST_MVC_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class OmsbEditRaiseShareRotationRequestMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long sharedRotationRequestId = ParamUtil.get(renderRequest,
				OmsbRaiseShareRotationRequestWebPortletKeys.SHARE_ROTATION_REQUEST_ID, 0);

		try {
			SharedRotationRequestDetails sharedRotationRequestDetail = getSharedRotationRequestDetail(
					sharedRotationRequestId);

			ProgramMaster programMaster = getProgramMaster(sharedRotationRequestDetail);
			Map<Long, String> programMap = getProgramMap(themeDisplay, programMaster);

			Map<Long, String> rotationMap = getRotationMap(themeDisplay, sharedRotationRequestDetail);

			Set<RotationMaster> rotationMasterList = new HashSet<>();

			getRotationMasterListFromUserMetaData(themeDisplay, rotationMasterList, rotationMap);

			Map<Long, Boolean> requestRaisedToUserMap = getRequestRaisedToUserMap(sharedRotationRequestDetail);
			Map<Long, String> programUserDetailsMap = getProgramUserDetailsMap(themeDisplay,
					sharedRotationRequestDetail);
			Map<Long, String> programUserImageMap = getProgramUserImageMap(themeDisplay, sharedRotationRequestDetail);

			ProgramDurationDetails programDurationDetails = getProgramDurationDetails(sharedRotationRequestDetail);

			rotationMasterList = rotationMasterList.stream().sorted((first, second) -> {
				String rotationNameFirst = first.getRotationName(themeDisplay.getLocale()).toLowerCase();
				String rotationNameSecond = second.getRotationName(themeDisplay.getLocale()).toLowerCase();
				return rotationNameFirst.compareTo(rotationNameSecond);
			}).collect(Collectors.toSet());

			renderRequest.setAttribute(OmsbRaiseShareRotationRequestWebPortletKeys.ROTATION_MASTER_LIST,
					rotationMasterList);
			renderRequest.setAttribute(OmsbRaiseShareRotationRequestWebPortletKeys.ROTATION_MAP, rotationMap);
			renderRequest.setAttribute(OmsbRaiseShareRotationRequestWebPortletKeys.PROGRAM_MAP, programMap);
			renderRequest.setAttribute(OmsbRaiseShareRotationRequestWebPortletKeys.PROGRAM_USER_DETAILS_MAP,
					programUserDetailsMap);
			renderRequest.setAttribute(OmsbRaiseShareRotationRequestWebPortletKeys.PROGRAM_USER_IMAGE_MAP,
					programUserImageMap);
			renderRequest.setAttribute(OmsbRaiseShareRotationRequestWebPortletKeys.REQUEST_RAISED_TO_USER_MAP,
					requestRaisedToUserMap);
			renderRequest.setAttribute(OmsbRaiseShareRotationRequestWebPortletKeys.PROGRAM_MASTER, programMaster);
			renderRequest.setAttribute(OmsbRaiseShareRotationRequestWebPortletKeys.PROGRAM_DURATION_DETAILS,
					programDurationDetails);
			renderRequest.setAttribute(OmsbRaiseShareRotationRequestWebPortletKeys.SHARED_ROTATION_REQUEST_DETAIL,
					sharedRotationRequestDetail);

		} catch (PortalException e) {
			_logger.error(e);
		}

		return OmsbRaiseShareRotationRequestWebPortletKeys.EDIT_RAISE_SHARE_ROTATION_REQUEST_JSP;
	}

	/**
	 * 
	 * @param sharedRotationRequestId
	 * @return
	 * @throws PortalException
	 */
	private SharedRotationRequestDetails getSharedRotationRequestDetail(long sharedRotationRequestId)
			throws PortalException {
		return sharedRotationRequestDetailsLocalService.getSharedRotationRequestDetails(sharedRotationRequestId);
	}

	/**
	 * 
	 * @param themeDisplay
	 * @param sharedRotationRequestDetail
	 * @param rotationMasterList
	 * @return
	 */
	private Map<Long, String> getRotationMap(ThemeDisplay themeDisplay,
			SharedRotationRequestDetails sharedRotationRequestDetail) {
		Map<Long, String> rotationMap = new HashMap<>();

		progdurationRotationTrainingsitesRelLocalService
				.findByProgramDurationId(sharedRotationRequestDetail.getProgramDurationId())
				.forEach(progdurationRotationTrainingsitesRel -> {
					try {
						RotationMaster rotationMaster = rotationMasterLocalService
								.getRotationMaster(progdurationRotationTrainingsitesRel.getRotationId());
						if (Boolean.TRUE.equals(progdurationRotationTrainingsitesRel.getIsSharedRotation())) {
							rotationMap.put(rotationMaster.getRotationMasterId(),
									rotationMaster.getRotationName(themeDisplay.getLanguageId()));
						}
					} catch (PortalException e) {
						_logger.error(e);
					}
				});

		return rotationMap;
	}

	/**
	 * 
	 * @param themeDisplay
	 * @param sharedRotationRequestDetail
	 * @return
	 * @throws PortalException
	 */
	private Map<Long, String> getProgramMap(ThemeDisplay themeDisplay, ProgramMaster programMaster) {
		Map<Long, String> programMap = new HashMap<>();
		programMap.put(programMaster.getProgramMasterId(), programMaster.getProgramName(themeDisplay.getLanguageId()));
		return programMap;
	}

	/**
	 * 
	 * @param sharedRotationRequestDetail
	 * @return
	 */
	private Map<Long, Boolean> getRequestRaisedToUserMap(SharedRotationRequestDetails sharedRotationRequestDetail) {
		Map<Long, Boolean> requestRaisedToUserMap = new HashMap<>();
		String[] raisedToUserIds = sharedRotationRequestDetail.getRequestRaisedTo().split(",");
		for (String raisedToUserId : raisedToUserIds) {
			requestRaisedToUserMap.put(Long.valueOf(raisedToUserId), true);
		}
		return requestRaisedToUserMap;
	}

	/**
	 * 
	 * @param themeDisplay
	 * @param sharedRotationRequestDetail
	 * @return
	 * @throws PortalException
	 */
	private Map<Long, String> getProgramUserDetailsMap(ThemeDisplay themeDisplay,
			SharedRotationRequestDetails sharedRotationRequestDetail) throws PortalException {
		Map<Long, String> programUserDetailsMap = new HashMap<>();
		List<UserMetadata> userMetadataList = getUserMetadataList(themeDisplay, sharedRotationRequestDetail);
		for (UserMetadata userMetadata : userMetadataList) {
			long userId = userMetadata.getLrUserId();
			User user = userLocalService.getUser(userId);
			String userDetail = user.getFullName() + " (" + user.getRoles().get(0).getName() + ")";
			programUserDetailsMap.put(userId, userDetail);
		}
		return programUserDetailsMap;
	}

	/**
	 * 
	 * @param themeDisplay
	 * @param sharedRotationRequestDetail
	 * @return
	 * @throws PortalException
	 */
	private Map<Long, String> getProgramUserImageMap(ThemeDisplay themeDisplay,
			SharedRotationRequestDetails sharedRotationRequestDetail) throws PortalException {
		Map<Long, String> programUserImageMap = new HashMap<>();
		List<UserMetadata> userMetadataList = getUserMetadataList(themeDisplay, sharedRotationRequestDetail);
		for (UserMetadata userMetadata : userMetadataList) {
			long userId = userMetadata.getLrUserId();
			User user = userLocalService.getUser(userId);
			programUserImageMap.put(userId, user.getPortraitURL(themeDisplay));
		}
		return programUserImageMap;
	}

	/**
	 * 
	 * @param themeDisplay
	 * @param sharedRotationRequestDetail
	 * @return
	 */
	private List<UserMetadata> getUserMetadataList(ThemeDisplay themeDisplay,
			SharedRotationRequestDetails sharedRotationRequestDetail) {
		return userMetadataUtil.getUserMetadataItemsByProgramId(themeDisplay.getPortalURL(),
				themeDisplay.getScopeGroupId(), sharedRotationRequestDetail.getProgramDurationId()).getItems();
	}

	/**
	 * 
	 * @param sharedRotationRequestDetail
	 * @return
	 * @throws PortalException
	 */
	private ProgramMaster getProgramMaster(SharedRotationRequestDetails sharedRotationRequestDetail)
			throws PortalException {
		long programId = programDurationDetailsLocalService
				.getProgramDurationDetails(sharedRotationRequestDetail.getProgramDurationId()).getProgramId();
		return programMasterLocalService.getProgramMaster(programId);
	}

	/**
	 * 
	 * @param sharedRotationRequestDetail
	 * @return
	 * @throws PortalException
	 */
	private ProgramDurationDetails getProgramDurationDetails(SharedRotationRequestDetails sharedRotationRequestDetail)
			throws PortalException {
		return programDurationDetailsLocalService
				.getProgramDurationDetails(sharedRotationRequestDetail.getProgramDurationId());
	}

	/**
	 * 
	 * @param portalUrl
	 * @param scopeGroupId
	 * @param userId
	 * @param locale
	 * @param rotationMasterList
	 * @param rotationMap
	 */
	public void getRotationMasterListFromUserMetaData(ThemeDisplay themeDisplay, Set<RotationMaster> rotationMasterList,
			Map<Long, String> rotationMap) {
		// Get ProgramIds from User metadata from userId

		boolean isSuperAdmin = CommonUtil.isSupeAdminUser(themeDisplay.getUser());
		boolean isChairman = CommonUtil.isChairmanUser(themeDisplay.getUser());

		Long[] programIds = null;
		if (isChairman || isSuperAdmin) {
			programIds = programMasterLocalService.getProgramMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS).stream()
					.map(ProgramMaster::getProgramMasterId).collect(Collectors.toSet()).toArray(new Long[0]);
		} else {
			List<UserMetadata> userMetadataList = userMetadataUtil.getUserMetadataItemsByLrUserId(
					themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), themeDisplay.getUserId()).getItems();
			programIds = new Long[userMetadataList.size()];
			for (int i = 0; i < userMetadataList.size(); i++) {
				programIds[i] = userMetadataList.get(i).getProgramId();
			}
		}

		DynamicQuery dynamicQuery = programDurationDetailsLocalService.dynamicQuery()
				.add(RestrictionsFactoryUtil.in("programId", programIds));
		List<ProgramDurationDetails> programDurationDetailList = programDurationDetailsLocalService
				.dynamicQuery(dynamicQuery);
		for (ProgramDurationDetails programDurationDetail : programDurationDetailList) {
			for (ProgdurationRotationTrainingsitesRel progdurationRotationTrainingsitesRel : progdurationRotationTrainingsitesRelLocalService
					.findByProgramDurationId(programDurationDetail.getProgDurationId())) {
				try {
					if (Boolean.TRUE.equals(progdurationRotationTrainingsitesRel.getIsSharedRotation())) {
						RotationMaster rotationMaster = rotationMasterLocalService
								.getRotationMaster(progdurationRotationTrainingsitesRel.getRotationId());
						rotationMap.put(rotationMaster.getRotationMasterId(),
								rotationMaster.getRotationName(themeDisplay.getLocale()));
						rotationMasterList.add(rotationMaster);
					}
				} catch (PortalException e) {
					_logger.error(e);
				}
			}
		}
	}

	@Reference
	private UserMetadataUtil userMetadataUtil;

	@Reference
	private UserLocalService userLocalService;

	@Reference
	private ProgramMasterLocalService programMasterLocalService;

	@Reference
	private ProgramDurationDetailsLocalService programDurationDetailsLocalService;

	@Reference
	private ProgdurationRotationTrainingsitesRelLocalService progdurationRotationTrainingsitesRelLocalService;

	@Reference
	private SharedRotationRequestDetailsLocalService sharedRotationRequestDetailsLocalService;

	@Reference
	private RotationMasterLocalService rotationMasterLocalService;

	public static final Log _logger = LogFactoryUtil.getLog(OmsbEditRaiseShareRotationRequestMVCRenderCommand.class);
}
