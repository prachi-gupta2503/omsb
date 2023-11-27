package gov.omsb.eligibility.degree.web.portlet.mvccommands;

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
import gov.omsb.eligibility.degree.web.constants.OmsbEligibilityDegreeWebPortletKeys;
import gov.omsb.eligibility.degree.web.portlet.util.OmsbEligibilityDegreeUtil;
import gov.omsb.tms.model.EligibilityDegreeMaster;
import gov.omsb.tms.service.EligibilityDegreeMasterLocalService;

/**
 * @author Komal Gajera
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbEligibilityDegreeWebPortletKeys.OMSBELIGIBILITYDEGREEWEB,
"mvc.command.name=" + OmsbEligibilityDegreeWebPortletKeys.SAVE_ELIGIBILITY_DEGREE_MVC_ACTION_COMMAND }, service = MVCActionCommand.class)
public class OmsbSaveEligibilityDegreeMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		_logger.info("ProcessAction Invoked ::: ");
		boolean isSuccess = true;
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long eligibilityDegreeMasterId = ParamUtil.getLong(actionRequest, OmsbEligibilityDegreeWebPortletKeys.ELIGIBILITY_DEGREE_MASTER_ID, 0);
		
		try {
			if(eligibilityDegreeMasterId != 0) {
				// Update Eligibility Degree Master
				isSuccess =  updateEligibilityDegreeMaster(actionRequest, eligibilityDegreeMasterId, themeDisplay);
			} else {
				// Create Eligibility Degree Master
				isSuccess = createEligibilityDegreeMaster(actionRequest, themeDisplay);
			}
		} catch (PortalException e) {
			_logger.error(e);
			isSuccess = false;
		}
		_logger.info("ProcessAction Exit ::: ");
		return isSuccess;
	}
	

	private boolean updateEligibilityDegreeMaster(ActionRequest actionRequest, long eligibilityDegreeMasterId, ThemeDisplay themeDisplay)
			throws PortalException {
		EligibilityDegreeMaster eligibilityDegreeMaster = eligibilityDegreeMasterLocalService.getEligibilityDegreeMaster(eligibilityDegreeMasterId);
		if(Validator.isNotNull(eligibilityDegreeMaster)) {
			
			// validate Eligibility Degree
			if (!validateEligibilityDegree(actionRequest,eligibilityDegreeMaster)) {
				return false;
			}
			eligibilityDegreeMasterLocalService.updateEligibilityDegreeMaster(OmsbEligibilityDegreeUtil.createEligibilityDegreeMasterObject(actionRequest, eligibilityDegreeMaster, Boolean.FALSE, themeDisplay));
			_logger.debug("updateEligibilityDegreeMaster ::: Eligibility Degree Master Record Updated");
		} else {
			_logger.debug("updateEligibilityDegreeMaster ::: Eligibility Degree Master Record Not Found " + eligibilityDegreeMasterId);
			return false;
		}
		return true;
		
	}
	
	
	private boolean validateEligibilityDegree(ActionRequest actionRequest,
			EligibilityDegreeMaster eligibilityDegreeMaster) {
		List<String> eligibilityDegreeName = new ArrayList<>();
		boolean isValid = true;
		Map<Locale, String> eligibilityDegreeNameMap = LocalizationUtil.getLocalizationMap(actionRequest, OmsbEligibilityDegreeWebPortletKeys.ELIGIBILITY_DEGREE_NAME);

		addLocalizedValue(eligibilityDegreeNameMap, eligibilityDegreeName, CommonConstants.LANGUAGE_CODE_ENGLISH);
		addLocalizedValue(eligibilityDegreeNameMap, eligibilityDegreeName, CommonConstants.LANGUAGE_CODE_ARABIC);
		
		if (checkEligibilityDegree(eligibilityDegreeName, actionRequest, eligibilityDegreeMaster)) {
			isValid = false;
		}

		return isValid;
	}
	
	private boolean checkEligibilityDegree(List<String> eligibilityDegreeNames, ActionRequest actionRequest,
			EligibilityDegreeMaster eligibilityDegreeMaster) {
		List<EligibilityDegreeMaster> eligibilityDegreeMasters;
		for (String eligibilityDegreeName : eligibilityDegreeNames) {
			String likeEligibilityDegreeName = StringPool.PERCENT + StringPool.GREATER_THAN + eligibilityDegreeName + StringPool.LESS_THAN
					+ StringPool.PERCENT;
			eligibilityDegreeMasters = new ArrayList<>(eligibilityDegreeMasterLocalService.findByeligibilityDegreeByLike(likeEligibilityDegreeName));
			if (Validator.isNotNull(eligibilityDegreeMaster) && eligibilityDegreeMasters.contains(eligibilityDegreeMaster)) {
				eligibilityDegreeMasters.remove(eligibilityDegreeMaster);
			}
			if (!eligibilityDegreeMasters.isEmpty()) {
				SessionErrors.add(actionRequest, OmsbEligibilityDegreeWebPortletKeys.DEGREE_NAME_ERROR);
				SessionMessages.add(actionRequest,
						PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				return true;
			}
		}
		return false;
	}


	private void addLocalizedValue(Map<Locale, String> localizationMap, List<String> values, String languageCode) {
		Locale languageLocale = LocaleUtil.fromLanguageId(languageCode);
		String localizedValue = localizationMap.get(languageLocale);
		if (Validator.isNotNull(localizedValue)) {
			values.add(localizedValue);
		}
	}

	private boolean createEligibilityDegreeMaster(ActionRequest actionRequest, ThemeDisplay themeDisplay) {
		long eligibilityDegreeMasterId = counterLocalService.increment(getClass().getName(), 1);
		try {
			
			// validate Eligibility Degree
			if (!validateEligibilityDegree(actionRequest, null)) {
				return false;
			}
			EligibilityDegreeMaster eligibilityDegreeMaster = eligibilityDegreeMasterLocalService.createEligibilityDegreeMaster(eligibilityDegreeMasterId);
			eligibilityDegreeMasterLocalService.addEligibilityDegreeMaster(OmsbEligibilityDegreeUtil.createEligibilityDegreeMasterObject(actionRequest, eligibilityDegreeMaster, Boolean.FALSE, themeDisplay));
			_logger.debug("createEligibilityDegreeMaster ::: Eligibility Degree Master Record Created");
		} catch (Exception e) {
			_logger.error(e);
			return false;
		}
		return true;
	}
	
	@Reference
	private EligibilityDegreeMasterLocalService eligibilityDegreeMasterLocalService;
	
	@Reference
	private CounterLocalService counterLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbSaveEligibilityDegreeMVCActionCommand.class.getName());

}
