package gov.omsb.raise.share.rotation.request.web.portlet;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.portlet.Portlet;
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

/**
 * @author HP
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=OMSB",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=OmsbRaiseShareRotationRequestWeb", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template="
				+ OmsbRaiseShareRotationRequestWebPortletKeys.ADD_RAISE_SHARE_ROTATION_REQUEST_JSP,
		"javax.portlet.name=" + OmsbRaiseShareRotationRequestWebPortletKeys.OMSBRAISESHAREROTATIONREQUESTWEB,
		"javax.portlet.resource-bundle=content.Language", "javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.version=3.0" }, service = Portlet.class)

/**
 * 
 * @author HP
 *
 */
public class OmsbRaiseShareRotationRequestWebPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
	        throws IOException, PortletException {
	    ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
	    long userId = themeDisplay.getUserId();

	    List<SharedRotationRequestDetails> requestedShareRotationList = getRequestedShareRotationList(userId);

	    Map<Long, String> raisedRequestToUserMap = getRaisedRequestToUserMap(requestedShareRotationList);

	    Map<Long, String> cohortMap = getCohortMap(requestedShareRotationList, themeDisplay);

	    Map<Long, String> rotationMap = new HashMap<>();
	    
	    Set<RotationMaster> rotationMasterList = getSortedRotationMasterList(themeDisplay, rotationMap);

	    boolean showModal = ParamUtil.getBoolean(renderRequest, OmsbRaiseShareRotationRequestWebPortletKeys.SHOW_MODAL);
	    boolean isShowModel = false;
	    long sharedRotationRequestId = ParamUtil.getLong(renderRequest,
	            OmsbRaiseShareRotationRequestWebPortletKeys.SHARE_ROTATION_REQUEST_ID, 0);

	    if (showModal && sharedRotationRequestId != 0) {
	        isShowModel = tryShowModal(renderRequest, sharedRotationRequestId, userId);
	    }

	    renderRequest.setAttribute(OmsbRaiseShareRotationRequestWebPortletKeys.SHOW_MODAL, isShowModel);
	    renderRequest.setAttribute(OmsbRaiseShareRotationRequestWebPortletKeys.COHORT_MAP, cohortMap);
	    renderRequest.setAttribute(OmsbRaiseShareRotationRequestWebPortletKeys.RAISED_REQUEST_TO_USER_MAP,
	            raisedRequestToUserMap);
	    renderRequest.setAttribute(OmsbRaiseShareRotationRequestWebPortletKeys.ROTATION_MAP, rotationMap);
	    renderRequest.setAttribute(OmsbRaiseShareRotationRequestWebPortletKeys.ROTATION_MASTER_LIST,
	            rotationMasterList);
	    renderRequest.setAttribute(OmsbRaiseShareRotationRequestWebPortletKeys.REQUESTED_SHARE_ROTATION_LIST,
	            requestedShareRotationList);
	    renderRequest.setAttribute(OmsbRaiseShareRotationRequestWebPortletKeys.REQUEST_RAISED_TO_USER_LIST,
	            new ArrayList<>());

	    super.render(renderRequest, renderResponse);
	}

	private List<SharedRotationRequestDetails> getRequestedShareRotationList(long userId) {
	    return sharedRotationRequestDetailsLocalService
	            .findByRequestRaisedBy(String.valueOf(userId))
	            .stream()
	            .sorted(Comparator.comparing(SharedRotationRequestDetails::getModifiedDate).reversed())
	            .collect(Collectors.toList());
	}

	private Map<Long, String> getRaisedRequestToUserMap(List<SharedRotationRequestDetails> requestedShareRotationList) {
	    Map<Long, String> raisedRequestToUserMap = new HashMap<>();
	    for (SharedRotationRequestDetails raisedRequest : requestedShareRotationList) {
	        try {
	            String[] raisedRequestUserArray = raisedRequest.getRequestRaisedTo().split(StringPool.COMMA);
	            StringBuilder userNames = new StringBuilder();
	            for (String raisedRequestUserId : raisedRequestUserArray) {
	                if (Validator.isNotNull(raisedRequestUserId)) {
	                    userNames.append(userLocalService.getUser(Long.valueOf(raisedRequestUserId)).getFullName())
	                            .append(StringPool.COMMA);
	                }
	            }
	            if (userNames.length() > 0) {
	                userNames.deleteCharAt(userNames.length() - 1);
	            }
	            raisedRequestToUserMap.put(raisedRequest.getSharedRotationRequestDetailsId(), userNames.toString());
	        } catch (PortalException e) {
	            _logger.error(e);
	        }
	    }
	    return raisedRequestToUserMap;
	}

	private Map<Long, String> getCohortMap(List<SharedRotationRequestDetails> requestedShareRotationList, ThemeDisplay themeDisplay) {
	    Map<Long, String> cohortMap = new HashMap<>();
	    requestedShareRotationList.stream().map(SharedRotationRequestDetails::getProgramDurationId)
	            .collect(Collectors.toList()).forEach(cohortId -> {
	        try {
	            String cohortName = programMasterLocalService
	                    .getProgramMaster(programDurationDetailsLocalService.getProgramDurationDetails(cohortId)
	                            .getProgramId())
	                    .getProgramName(themeDisplay.getLanguageId()) + StringPool.SPACE
	                    + StringPool.OPEN_PARENTHESIS + programDurationDetailsLocalService
	                    .getProgramDurationDetails(cohortId).getAyApplicableForm()
	                    + StringPool.CLOSE_PARENTHESIS;
	            cohortMap.put(cohortId, cohortName);
	        } catch (PortalException e) {
	            _logger.error(e);
	        }
	    });
	    return cohortMap;
	}

	private Set<RotationMaster> getSortedRotationMasterList(ThemeDisplay themeDisplay, Map<Long, String> rotationMap) {
	    Set<RotationMaster> rotationMasterList = new HashSet<>();
	    getRotationMasterListFromUserMetaData(themeDisplay, rotationMasterList, rotationMap);
	    return rotationMasterList.stream().sorted((first, second) -> {
	        String rotationNameFirst = first.getRotationName(themeDisplay.getLocale()).toLowerCase();
	        String rotationNameSecond = second.getRotationName(themeDisplay.getLocale()).toLowerCase();
	        return rotationNameFirst.compareTo(rotationNameSecond);
	    }).collect(Collectors.toSet());
	}

	private boolean tryShowModal(RenderRequest renderRequest, long sharedRotationRequestId, long userId) {
	    SharedRotationRequestDetails sharedRotationRequestDetails = null;
	    try {
	        sharedRotationRequestDetails = sharedRotationRequestDetailsLocalService
	                .getSharedRotationRequestDetails(sharedRotationRequestId);
	        if (userId == Long.valueOf(sharedRotationRequestDetails.getRequestRaisedBy())) {
	            renderRequest.setAttribute(
	                    OmsbRaiseShareRotationRequestWebPortletKeys.SHARED_ROTATION_REQUEST_DETAILS,
	                    sharedRotationRequestDetails);
	            return true;
	        }
	    } catch (NumberFormatException | PortalException e) {
	        _logger.error(e);
	    }
	    return false;
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
	public void getRotationMasterListFromUserMetaData(ThemeDisplay themeDisplay,
			Set<RotationMaster> rotationMasterList, Map<Long, String> rotationMap) {
		// Get ProgramIds from User metadata from userId
		boolean isSuperAdmin = CommonUtil.isSupeAdminUser(themeDisplay.getUser());
		boolean isChairman = CommonUtil.isChairmanUser(themeDisplay.getUser());
		List<ProgramDurationDetails> programDurationDetailList = new ArrayList<>();
		try {
			if (isSuperAdmin || isChairman) {
				for (ProgramMaster program : programMasterLocalService.getProgramMasters(QueryUtil.ALL_POS,
						QueryUtil.ALL_POS)) {
					programDurationDetailList.addAll(programDurationDetailsLocalService
							.findProgramDurationByProgramId(program.getProgramMasterId()));
				}
			} else {
				List<UserMetadata> userMetadataList = userMetadataUtil
						.getUserMetadataItemsByLrUserId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(),
								themeDisplay.getUserId())
						.getItems();
				Long[] programIds = new Long[userMetadataList.size()];
				for (int i = 0; i < userMetadataList.size(); i++) {
					programIds[i] = userMetadataList.get(i).getProgramId();
				}
				DynamicQuery dynamicQuery = programDurationDetailsLocalService.dynamicQuery()
						.add(RestrictionsFactoryUtil.in("programId", programIds));
				programDurationDetailList = programDurationDetailsLocalService.dynamicQuery(dynamicQuery);
			}

			for (ProgramDurationDetails programDurationDetail : programDurationDetailList) {
				for (ProgdurationRotationTrainingsitesRel progdurationRotationTrainingsitesRel : progdurationRotationTrainingsitesRelLocalService
						.findByProgramDurationId(programDurationDetail.getProgDurationId())) {
					if (Boolean.TRUE.equals(progdurationRotationTrainingsitesRel.getIsSharedRotation())) {
						RotationMaster rotationMaster = rotationMasterLocalService
								.getRotationMaster(progdurationRotationTrainingsitesRel.getRotationId());
						rotationMap.put(rotationMaster.getRotationMasterId(),
								rotationMaster.getRotationName(themeDisplay.getLocale()));
						rotationMasterList.add(rotationMaster);
					}
				}
			}
		} catch (Exception e) {
			_logger.error(e);
		}
	}

	@Reference
	private UserMetadataUtil userMetadataUtil;

	@Reference
	private ProgramMasterLocalService programMasterLocalService;

	@Reference
	private RotationMasterLocalService rotationMasterLocalService;

	@Reference
	private ProgramDurationDetailsLocalService programDurationDetailsLocalService;

	@Reference
	private SharedRotationRequestDetailsLocalService sharedRotationRequestDetailsLocalService;

	@Reference
	private ProgdurationRotationTrainingsitesRelLocalService progdurationRotationTrainingsitesRelLocalService;

	@Reference
	private UserLocalService userLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbRaiseShareRotationRequestWebPortlet.class);
}