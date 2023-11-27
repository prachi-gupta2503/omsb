package gov.omsb.training.sites.web.portlet.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.StringWriter;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.ResourceRequest;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;

import gov.omsb.common.dto.EmailObjects;
import gov.omsb.common.util.CommonUtil;
import gov.omsb.common.util.EmailUtil;
import gov.omsb.common.util.PortalNotification;
import gov.omsb.email.config.configuration.action.OmsbFromEmailConfigurationAction;
import gov.omsb.email.config.configuration.action.OmsbTrainingSitesEmailConfigurationAction;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.custom.dto.TrainingSiteStructureDTO;
import gov.omsb.tms.model.ProgramDurationDetails;
import gov.omsb.tms.model.RotationMaster;
import gov.omsb.tms.model.TrainingSitesMaster;
import gov.omsb.tms.service.ProgramDurationDetailsLocalServiceUtil;
import gov.omsb.tms.service.ProgramMasterLocalServiceUtil;
import gov.omsb.tms.service.RotationMasterLocalServiceUtil;
import gov.omsb.training.sites.web.constants.OmsbTrainingSitesWebPortletKeys;
import gov.omsb.training.sites.web.dto.OmsbTrainingSiteDetailsDTO;
import gov.omsb.web.notification.configuration.action.OmsbTrainingSitesWebNotificationConfigurationAction;

public class OmsbTrainingSitesUtil {

	private OmsbTrainingSitesUtil() {
	}

	/**
	 * 
	 * @return
	 */
	public static String getCurrentYear() {
		LocalDateTime localDate = LocalDateTime.now();
		int year = localDate.getYear();
		int nextYear = localDate.getYear() + 1;
		return year + OmsbTrainingSitesWebPortletKeys.HYPHEN + nextYear;
	}
	
	/**
	 * 
	 * @param themeDisplay
	 * @param request
	 * @param progDurationId
	 * @return
	 */
	public static String createProgramDetailsPageRenderUrl(ThemeDisplay themeDisplay, PortletRequest request, long progDurationId) {
		_logger.info("createProgramDetailsPageRenderUrl Invoked ::: ");
		String renderUrlStr = StringPool.BLANK;
		try {
			long programMasterId = ProgramDurationDetailsLocalServiceUtil.getProgramDurationDetails(progDurationId).getProgramId();
			String portletId = OmsbTrainingSitesWebPortletKeys.OMSBPROGRAMSWEB;
			long plId = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), portletId);
			PortletURL programListRenderUrl = PortletURLFactoryUtil.getPortletURLFactory().create(request, portletId, plId,
					PortletRequest.RENDER_PHASE);
			programListRenderUrl.getRenderParameters().setValue("p_p_state", "normal");
			programListRenderUrl.getRenderParameters().setValue("p_p_mode", "view");
			programListRenderUrl.getRenderParameters().setValue(OmsbTrainingSitesWebPortletKeys.MVC_RENDER_COMMAND_NAME, "/program-details");
			programListRenderUrl.getRenderParameters().setValue("programMasterId", String.valueOf(programMasterId));
			renderUrlStr = programListRenderUrl.toString();
		} catch (PortalException e) {
			_logger.error("createProgramDetailsPageRenderUrl Error ::: " + e);
		}
		_logger.info("createProgramDetailsPageRenderUrl Exit ::: ");
		return renderUrlStr;
	}
	
	/**
	 * 
	 * @param themeDisplay
	 * @param request
	 * @param rotationMasterId
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static String createAddTrainingSiteRenderUrl(ThemeDisplay themeDisplay, PortletRequest request, long progDurationId) {
		_logger.info("createAddRotationRenderUrl Invoked ::: ");
		String renderUrlStr = StringPool.BLANK;
		try {
			PortletURL renderUrl = PortletURLFactoryUtil.create(request,
					themeDisplay.getPortletDisplay().getId(), themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
			renderUrl.setWindowState(WindowState.NORMAL);
			renderUrl.setPortletMode(PortletMode.VIEW);
			renderUrl.setParameter(OmsbTrainingSitesWebPortletKeys.PROG_DURARION_ID, String.valueOf(progDurationId));
			renderUrl.setParameter(OmsbTrainingSitesWebPortletKeys.MVC_RENDER_COMMAND_NAME,
					OmsbTrainingSitesWebPortletKeys.TRAINING_SITE_ADD_MVC_RENDER_COMMAND);
		   renderUrlStr = renderUrl.toString();
		} catch (PortletModeException | WindowStateException e) {
			_logger.error("createAddRotationRenderUrl Error ::: " + e);
		}
		_logger.info("createAddRotationRenderUrl Exit ::: ");
		return renderUrlStr;
	}

	/**
	 * 
	 * @param themeDisplay
	 * @param request
	 * @param trainingSiteMasterId
	 * @return String Render URL
	 */
	@SuppressWarnings("deprecation")
	public static String createRenderUrl(ThemeDisplay themeDisplay, ResourceRequest request,
			long trainingSiteMasterId) {
		_logger.info("createRenderUrl Invoked ::: ");
		String renderUrlStr = StringPool.BLANK;
		try {
			PortletURL renderUrl = PortletURLFactoryUtil.create(request, themeDisplay.getPortletDisplay().getId(),
					themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
			renderUrl.setWindowState(WindowState.NORMAL);
			renderUrl.setPortletMode(PortletMode.VIEW);
			renderUrl.setParameter(OmsbTrainingSitesWebPortletKeys.MVC_RENDER_COMMAND_NAME,
					OmsbTmsCommonConstants.TRAINING_SITE_DETAILS_MVC_RENDER_COMMAND);
			renderUrl.setParameter(OmsbTrainingSitesWebPortletKeys.TRAINING_SITE_MASTER_ID,
					String.valueOf(trainingSiteMasterId));
			renderUrlStr = renderUrl.toString();
		} catch (PortletModeException | WindowStateException e) {
			_logger.error("createRenderUrl Error ::: " + e.getStackTrace());
		}
		_logger.info("createRenderUrl Exit ::: ");
		return renderUrlStr;
	}

	/**
	 * 
	 * @param actionRequest
	 * @param trainingSitesMaster
	 * @return TrainingSitesMaster
	 *
	 */
	public static TrainingSitesMaster createTrainingSiteMasterObject(ActionRequest actionRequest,
			TrainingSitesMaster trainingSitesMaster) {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		_logger.info("createTrainingSiteMasterObject Invoked ::: ");
		Map<Locale, String> trainingSiteCode = LocalizationUtil.getLocalizationMap(actionRequest,
				OmsbTrainingSitesWebPortletKeys.TRAINING_SITE_CODE);
		Map<Locale, String> trainingSiteName = LocalizationUtil.getLocalizationMap(actionRequest,
				OmsbTrainingSitesWebPortletKeys.TRAINING_SITE_NAME);
		Map<Locale, String> trainingSiteAddress = LocalizationUtil.getLocalizationMap(actionRequest,
				OmsbTrainingSitesWebPortletKeys.TRAINING_SITE_ADDRESS);
		Map<Locale, String> trainingSiteDescription = LocalizationUtil.getLocalizationMap(actionRequest,
				OmsbTrainingSitesWebPortletKeys.TRAINING_SITE_DESCRIPTION);
		Boolean trainingSiteStatus = ParamUtil.getBoolean(actionRequest,
				OmsbTrainingSitesWebPortletKeys.TRAINING_SITE_STATUS, Boolean.TRUE);

		trainingSitesMaster.setTrainingSiteCodeMap(trainingSiteCode);
		trainingSitesMaster.setTrainingSiteNameMap(trainingSiteName);
		trainingSitesMaster.setTrainingSiteAddressMap(trainingSiteAddress);
		trainingSitesMaster.setTrainingSiteDescriptionMap(trainingSiteDescription);
		trainingSitesMaster.setTrainingSiteStatus(trainingSiteStatus);
		trainingSitesMaster.setGroupId(themeDisplay.getScopeGroupId());
		_logger.info("createTrainingSiteMasterObject Exit ::: ");
		return trainingSitesMaster;
	}

	/**
	 * 
	 * @param resourceRequest
	 * @param themeDisplay
	 * @param trainingSiteMasterList
	 * @return JSONObject
	 */
	public static JSONObject prepareTrainingSiteResponseJson(ResourceRequest resourceRequest, ThemeDisplay themeDisplay,
			List<TrainingSitesMaster> trainingSiteMasterList) {
		_logger.info("prepareTrainingSiteResponseJson Invoked ::: ");
		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		JSONArray trainingSiteMasterListJSONArray = JSONFactoryUtil.createJSONArray();
		for (TrainingSitesMaster trainingSite : trainingSiteMasterList) {
			JSONObject programJson = JSONFactoryUtil.createJSONObject();
			programJson.put(OmsbTrainingSitesWebPortletKeys.TRAINING_SITE_NAME,
					trainingSite.getTrainingSiteName(themeDisplay.getLocale()));
			programJson.put(OmsbTrainingSitesWebPortletKeys.RENDER_URL, OmsbTrainingSitesUtil
					.createRenderUrl(themeDisplay, resourceRequest, trainingSite.getTrainingSiteMasterId()));
			trainingSiteMasterListJSONArray.put(programJson);
		}

		resultJson.put(OmsbTrainingSitesWebPortletKeys.SUCCESS, true);
		resultJson.put(OmsbTrainingSitesWebPortletKeys.RESULT, trainingSiteMasterListJSONArray);
		_logger.info("prepareTrainingSiteResponseJson Invoked ::: ");
		return resultJson;
	}

	public static Map<String, HashMap<String, Long>> getTrainingSiteStructure(
			List<TrainingSiteStructureDTO> trainingSiteStructureDTOList,
			Map<String, HashMap<String, Long>> programDTOList, Map<String, Long> rotationNameAndKeyMap) {
		_logger.info("getTrainingSiteStructure Invoked ::: ");
		for (TrainingSiteStructureDTO structureDTO : trainingSiteStructureDTOList) {
			RotationMaster rotationMaster = null; 
			try {
				rotationMaster = RotationMasterLocalServiceUtil.getRotationMaster(structureDTO.getRotationId());
				if (!OmsbTmsCommonConstants.LEAVE.equalsIgnoreCase(rotationMaster.getRotationName(OmsbTmsCommonConstants.LANGUAGE_CODE_ENGLISH))) {
					if (programDTOList.containsKey(structureDTO.getProgarmName())) {
						// Set Number of Blocks for the Residential level for exising program
						programDTOList.get(structureDTO.getProgarmName()).put(structureDTO.getRotationName(),
								structureDTO.getNoOfSlots());
					} else {
						// Set ProgramRotationDTO
						HashMap<String, Long> rotationMap = new LinkedHashMap<>();
						rotationMap.put(structureDTO.getRotationName(), structureDTO.getNoOfSlots());
						rotationNameAndKeyMap.put(structureDTO.getRotationName(), structureDTO.getRotationId());
						programDTOList.put(structureDTO.getProgarmName(), rotationMap);
					}
					
				}
			} catch (Exception e) {
				_logger.error(e);
			}
		}
		_logger.debug("rotationNameAndKeyMap ::: " + rotationNameAndKeyMap.toString());
		_logger.debug("getTrainingSiteStructure ::: Total Program : " + programDTOList.size());
		_logger.debug("getTrainingSiteStructure Exit ::: " + programDTOList.toString());
		return programDTOList;
	}

	public static void prepareMailMessage(OmsbTrainingSiteDetailsDTO omsbTrainingSiteDetailsDTO, User requesterUser,
			String renderURL) {
		try {
			String rawSubject = OmsbTrainingSitesEmailConfigurationAction.subject();
			String rawBody = OmsbTrainingSitesEmailConfigurationAction.body();

			Template subjectTemplate = CommonUtil.getTemplate(rawSubject);
			Template bodyTemplate = CommonUtil.getTemplate(rawBody);

			if (Validator.isNotNull(subjectTemplate) && Validator.isNotNull(bodyTemplate)) {

				StringWriter out = new StringWriter();
				subjectTemplate.processTemplate(out);

				String subject = out.toString();

				bodyTemplate.put(OmsbTmsCommonConstants.SHARED_ROTATION_REQUESTER_NAME, requesterUser.getFullName());
				bodyTemplate.put(OmsbTmsCommonConstants.TRAINING_SITES_TRAINING_SITE_NAME,
						omsbTrainingSiteDetailsDTO.getTrainingSiteName());
				bodyTemplate.put(OmsbTmsCommonConstants.SHARED_ROTATION_NAME,
						omsbTrainingSiteDetailsDTO.getRotationName());
				bodyTemplate.put(OmsbTmsCommonConstants.TRAINING_SITES_CURRENT_SLOTS,
						omsbTrainingSiteDetailsDTO.getCurrentSlots());
				bodyTemplate.put(OmsbTmsCommonConstants.TRAINING_SITES_DEMAND_SLOTS,
						omsbTrainingSiteDetailsDTO.getDemandSlots());
				bodyTemplate.put(OmsbTmsCommonConstants.SHARED_ROTATION_PROGRAM_NAME,
						omsbTrainingSiteDetailsDTO.getProgramName());
				bodyTemplate.put(OmsbTmsCommonConstants.LINK, renderURL);
				bodyTemplate.put(OmsbTmsCommonConstants.ROLE, StringPool.BLANK);

				String[] userIds = omsbTrainingSiteDetailsDTO.getUserIds().split(StringPool.COMMA);
				User approverUser;
				EmailObjects emailObjects = new EmailObjects();
				emailObjects.setSubject(subject);
				emailObjects.setFromAddress(OmsbFromEmailConfigurationAction.fromAdminEmail());
				for (int i = 0; i < userIds.length; i++) {
					approverUser = UserLocalServiceUtil.fetchUser(Long.parseLong(userIds[i]));
					if (Validator.isNotNull(approverUser)) {
						bodyTemplate.put(OmsbTmsCommonConstants.SHARED_ROTATION_APPROVER_NAME,
								approverUser.getFullName());
						StringWriter out2 = new StringWriter();
						bodyTemplate.processTemplate(out2);
						String body = out2.toString();

						emailObjects.setBody(body);
						emailObjects.setToAddress(approverUser.getEmailAddress());
						EmailUtil.sendEmail(emailObjects);

					}
				}
			}
		} catch (PortalException e) {
			_logger.error(e);
		}
	}

	public static void prepareNotificationMessage(OmsbTrainingSiteDetailsDTO omsbTrainingSiteDetailsDTO,
			User requesterUser, String renderURL) {

		try {
			String rawNotification = OmsbTrainingSitesWebNotificationConfigurationAction.notificationTemplate();
			Template notificationTemplate = CommonUtil.getTemplate(rawNotification);

			if (Validator.isNotNull(notificationTemplate)) {

				notificationTemplate.put(OmsbTmsCommonConstants.TRAINING_SITES_TRAINING_SITE_NAME,
						omsbTrainingSiteDetailsDTO.getTrainingSiteName());
				notificationTemplate.put(OmsbTmsCommonConstants.LINK, renderURL);

				String[] userIds = omsbTrainingSiteDetailsDTO.getUserIds().split(StringPool.COMMA);
				User approverUser;
				for (int i = 0; i < userIds.length; i++) {
					approverUser = UserLocalServiceUtil.fetchUser(Long.parseLong(userIds[i]));
					if (Validator.isNotNull(approverUser)) {

						notificationTemplate.put(OmsbTmsCommonConstants.SHARED_ROTATION_REQUESTER_NAME,
								requesterUser.getFullName());

						StringWriter out = new StringWriter();
						notificationTemplate.processTemplate(out);

						String notification = out.toString();
						JSONObject payload = JSONFactoryUtil.createJSONObject();
						payload.put(OmsbTmsCommonConstants.USER_ID, approverUser.getUserId());
						payload.put(OmsbTmsCommonConstants.NOTIFICATION_TEXT, notification);
						payload.put(OmsbTmsCommonConstants.SENDER_NAME, requesterUser.getFullName());

						PortalNotification.sendPortalNotification(approverUser.getUserId(),
								OmsbTrainingSitesWebPortletKeys.OMSBTRAININGSITESWEB, payload);
					}
				}
			}
		} catch (PortalException e) {
			_logger.error(e);
		}
	}
	
	public static String getProgramNameWithCohort(long programDurationId, ThemeDisplay themeDisplay) {
		ProgramDurationDetails programDurationDetails;
		String programNameWithCohort = StringPool.BLANK;
		try {
			programDurationDetails = ProgramDurationDetailsLocalServiceUtil
					.getProgramDurationDetails(programDurationId);
			programNameWithCohort = ProgramMasterLocalServiceUtil.getProgramMaster(programDurationDetails.getProgramId()).getProgramName(themeDisplay.getLocale())
					+ StringPool.SPACE + StringPool.OPEN_PARENTHESIS + programDurationDetails.getAyApplicableForm()
					+ StringPool.CLOSE_PARENTHESIS; 
		} catch (PortalException e) {
			_logger.error(e);
		}
		return programNameWithCohort;
	}
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbTrainingSitesUtil.class.getName());

}
