package gov.omsb.training.sites.web.portlet.mvccommands;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.tms.model.TrainingSitesMaster;
import gov.omsb.tms.service.TrainingSitesMasterLocalService;
import gov.omsb.training.sites.web.constants.OmsbTrainingSitesWebPortletKeys;
import gov.omsb.training.sites.web.portlet.util.OmsbTrainingSitesUtil;

/**
 * @author Jayesh Goswami
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbTrainingSitesWebPortletKeys.OMSBTRAININGSITESWEB,
"mvc.command.name=" + OmsbTrainingSitesWebPortletKeys.TRAINING_SITE_SAVE_MVC_ACTION_COMMAND }, service = MVCActionCommand.class)
public class OmsbSaveTrainingSiteMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		_logger.info("ProcessAction Invoked ::: ");
		boolean isSuccess = true;
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long progDurationId = ParamUtil.getLong(actionRequest, OmsbTrainingSitesWebPortletKeys.PROG_DURARION_ID);
		long trainingSiteMasterId = ParamUtil.getLong(actionRequest, OmsbTrainingSitesWebPortletKeys.TRAINING_SITE_MASTER_ID, 0);
		String redirect = ParamUtil.getString(actionRequest, CommonConstants.REDIRECT_COMMAND_URL);
		try {
			if(trainingSiteMasterId != 0) {
				// Update Training Site Master
				isSuccess =  updateTrainingSiteMaster(actionRequest, trainingSiteMasterId);
			} else {
				// Create Training Site Master
				isSuccess = createTrainingSiteMaster(actionRequest);
			}
		} catch (PortalException e) {
			_logger.error(e);
			isSuccess = false;
		}
		if(!isSuccess) {
			actionResponse.getRenderParameters().setValue(CommonConstants.MVC_RENDER_COMMAND_NAME, redirect);
		}else {
			try {
				actionResponse.sendRedirect(OmsbTrainingSitesUtil.createAddTrainingSiteRenderUrl(themeDisplay,
						actionRequest, progDurationId));
			} catch (IOException e) {
				_logger.error(e);
			}
		}
		_logger.info("ProcessAction Exit ::: ");
		return isSuccess;
	}

	/**
	 * 
	 * @param actionRequest
	 * @param trainingSiteMasterId
	 * @throws PortalException
	 */
	private boolean updateTrainingSiteMaster(ActionRequest actionRequest, long trainingSiteMasterId)
			throws PortalException {
		TrainingSitesMaster trainingSitesMaster = trainingSitesMasterLocalService.getTrainingSitesMaster(trainingSiteMasterId);
		if(Validator.isNotNull(trainingSitesMaster)) {
			//validate Training Site
			if(!validateTrainingSite(actionRequest, trainingSitesMaster)) {
				return false;
			}
			trainingSitesMasterLocalService.updateTrainingSitesMaster(OmsbTrainingSitesUtil.createTrainingSiteMasterObject(actionRequest, trainingSitesMaster));
			_logger.debug("updateTrainingSiteMaster ::: Training Site Master Record Updated");
		} else {
			_logger.debug("updateTrainingSiteMaster ::: Training Site Master Record Not Found " + trainingSiteMasterId);
			return false;
		}
		return true;
		
	}

	/**
	 * 
	 * @param actionRequest
	 */
	private boolean createTrainingSiteMaster(ActionRequest actionRequest) {
		long trainingSiteMasterId = counterLocalService.increment(getClass().getName(), 1);
		try {
			//validate Training Site
			if(!validateTrainingSite(actionRequest, null)) {
				return false;
			}
			
			TrainingSitesMaster trainingSitesMaster = trainingSitesMasterLocalService.createTrainingSitesMaster(trainingSiteMasterId);
			trainingSitesMasterLocalService.addTrainingSitesMaster(OmsbTrainingSitesUtil.createTrainingSiteMasterObject(actionRequest, trainingSitesMaster));
			_logger.debug("createTrainingSiteMaster ::: Training Site Master Record Created");
		} catch (Exception e) {
			_logger.error(e);
			return false;
		}
		return true;
	}

	private boolean validateTrainingSite(ActionRequest actionRequest, TrainingSitesMaster trainingSitesMaster) {
	    List<String> trainingSiteNames = new ArrayList<>();
	    List<String> trainingSiteCodes = new ArrayList<>();
	    boolean isValid = true;

	    Map<Locale, String> trainingSiteNameMap = LocalizationUtil.getLocalizationMap(actionRequest, OmsbTrainingSitesWebPortletKeys.TRAINING_SITE_NAME);
	    Map<Locale, String> trainingSiteCodeMap = LocalizationUtil.getLocalizationMap(actionRequest, OmsbTrainingSitesWebPortletKeys.TRAINING_SITE_CODE);
		Map<Locale, String> trainingSiteDescriptionMap = LocalizationUtil.getLocalizationMap(actionRequest, OmsbTrainingSitesWebPortletKeys.TRAINING_SITE_DESCRIPTION);

	    addLocalizedValue(trainingSiteNameMap, trainingSiteNames, CommonConstants.LANGUAGE_CODE_ENGLISH);
	    addLocalizedValue(trainingSiteNameMap, trainingSiteNames, CommonConstants.LANGUAGE_CODE_ARABIC);

	    addLocalizedValue(trainingSiteCodeMap, trainingSiteCodes, CommonConstants.LANGUAGE_CODE_ENGLISH);
	    addLocalizedValue(trainingSiteCodeMap, trainingSiteCodes, CommonConstants.LANGUAGE_CODE_ARABIC);
	    
	    List<String> languageCodes = new ArrayList<>();
		languageCodes.add(CommonConstants.LANGUAGE_CODE_ENGLISH);
		languageCodes.add(CommonConstants.LANGUAGE_CODE_ARABIC);

	    if (checkTrainingSiteNames(trainingSiteNames, actionRequest, trainingSitesMaster) || checkTrainingSiteCodes(trainingSiteCodes, actionRequest, trainingSitesMaster) || 
	    		Boolean.TRUE.equals(checkLocalizedValue(trainingSiteNameMap,trainingSiteDescriptionMap, OmsbTrainingSitesWebPortletKeys.TRAINING_SITE_DESCRIPTION_ERROR,languageCodes,actionRequest))) {
	    	isValid = false;
	    }

	    return isValid;
	}
	
	private Boolean checkLocalizedValue(Map<Locale, String> localizationMap, Map<Locale, String> localizationCompareMap,
			String error, List<String> languageCodes, ActionRequest actionRequest) {
		boolean result = false;
		for (String languageCode : languageCodes) {
			Locale languageLocale = LocaleUtil.fromLanguageId(languageCode);
			String localizedValue = localizationMap.get(languageLocale);
			String localizationCompareValue = localizationCompareMap.get(languageLocale);
			if (Validator.isNotNull(localizedValue)) {
				if (Validator.isNotNull(localizationCompareValue)) {
					result = false;
				} else {
					SessionErrors.add(actionRequest, error);
					SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest)
							+ SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
					return true;
				}
			}
		}
		return result;
	}

	private void addLocalizedValue(Map<Locale, String> localizationMap, List<String> values, String languageCode) {
	    Locale languageLocale = LocaleUtil.fromLanguageId(languageCode);
	    String localizedValue = localizationMap.get(languageLocale);
	    if (Validator.isNotNull(localizedValue)) {
	        values.add(localizedValue);
	    }
	}

	private boolean checkTrainingSiteNames(List<String> trainingSiteNames, ActionRequest actionRequest, TrainingSitesMaster trainingSitesMaster) {
		List<TrainingSitesMaster> trainingSitesMasters;
		for (String trainingSiteName : trainingSiteNames) {
	        String likeTrainingSiteName = StringPool.PERCENT + StringPool.GREATER_THAN + trainingSiteName + StringPool.LESS_THAN + StringPool.PERCENT;
	        trainingSitesMasters = new ArrayList<>(trainingSitesMasterLocalService.findByTrainingSiteNameByLike(likeTrainingSiteName));
	        if(Validator.isNotNull(trainingSitesMaster) && trainingSitesMasters.contains(trainingSitesMaster)) {
	        	trainingSitesMasters.remove(trainingSitesMaster);
	        }
	        if (!trainingSitesMasters.isEmpty()) {
	            SessionErrors.add(actionRequest, OmsbTrainingSitesWebPortletKeys.TRAINING_SITE_NAME_ERROR);
	            SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	            return true;
	        }
	    }
	    return false;
	}

	private boolean checkTrainingSiteCodes(List<String> trainingSiteCodes, ActionRequest actionRequest, TrainingSitesMaster trainingSitesMaster) {
		List<TrainingSitesMaster> trainingSitesMasters;
		for (String trainingSiteCode : trainingSiteCodes) {
	        String likeTrainingSiteCode = StringPool.PERCENT + StringPool.GREATER_THAN + trainingSiteCode + StringPool.LESS_THAN + StringPool.PERCENT;
	        trainingSitesMasters = new ArrayList<>(trainingSitesMasterLocalService.findByTrainingSiteCodeByLike(likeTrainingSiteCode));
	        if(Validator.isNotNull(trainingSitesMaster) && trainingSitesMasters.contains(trainingSitesMaster)) {
	        	trainingSitesMasters.remove(trainingSitesMaster);
	        }
	        if (!trainingSitesMasters.isEmpty()) {
	            SessionErrors.add(actionRequest, OmsbTrainingSitesWebPortletKeys.TRAINING_SITE_CODE_ERROR);
	            SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	            return true;
	        }
	    }
	    return false;
	}

			
	@Reference
	private TrainingSitesMasterLocalService trainingSitesMasterLocalService;
	
	@Reference
	private CounterLocalService counterLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbSaveTrainingSiteMVCActionCommand.class.getName());

}
