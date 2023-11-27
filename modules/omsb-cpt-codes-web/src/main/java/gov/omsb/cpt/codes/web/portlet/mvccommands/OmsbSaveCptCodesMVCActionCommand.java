package gov.omsb.cpt.codes.web.portlet.mvccommands;

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
import gov.omsb.cpt.codes.web.constants.OmsbCptCodesConstants;
import gov.omsb.cpt.codes.web.constants.OmsbCptCodesWebPortletKeys;
import gov.omsb.tms.model.CptCodeMaster;
import gov.omsb.tms.service.CptCodeMasterLocalService;

/**
 * @author Aditya Meghnathi
 */

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbCptCodesWebPortletKeys.OMSBCPTCODESWEB,
		"mvc.command.name=" + OmsbCptCodesConstants.SAVE_CPT_CODES_COMMAND_NAME }, service = MVCActionCommand.class)

public class OmsbSaveCptCodesMVCActionCommand implements MVCActionCommand {
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		_logger.info("ProcessAction Invoked ::: ");
		boolean isSuccess = true;
		long cptCodeMasterId = ParamUtil.getLong(actionRequest, OmsbCptCodesConstants.CPT_CODE_MASTER_ID, 0);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			if (cptCodeMasterId != 0) {
				// Update CPT code master
				isSuccess = updateCptCodeMaster(actionRequest, cptCodeMasterId, themeDisplay);
			} else {
				// Create CPT code master
				isSuccess = createCptCodeMaster(actionRequest, themeDisplay);
			}
		} catch (PortalException e) {
			_logger.error(e);
			isSuccess = false;
		}
		_logger.info("ProcessAction Exit ::: ");
		return isSuccess;

	}

	private boolean createCptCodeMaster(ActionRequest actionRequest, ThemeDisplay themeDisplay) {
		try {
			if (!validateCptCode(actionRequest, null)) {
				return false;
			}
			long cptCodeMasterId = counterLocalService.increment(getClass().getName(), 1);
			CptCodeMaster cptCodeMaster = cptCodeMasterLocalService.createCptCodeMaster(cptCodeMasterId);
			Map<Locale, String> cptCodeName = LocalizationUtil.getLocalizationMap(actionRequest,
					OmsbCptCodesConstants.CPT_CODE_NAME);
			cptCodeMaster.setCreatedBy(themeDisplay.getUserId());
			cptCodeMaster.setModifiedBy(themeDisplay.getUserId());
			cptCodeMaster.setCptCodeNameMap(cptCodeName);
			cptCodeMaster.setGroupId(themeDisplay.getScopeGroupId());
			cptCodeMasterLocalService.addCptCodeMaster(cptCodeMaster);
			_logger.debug("createCptCodeMaster ::: CPT Code Master Record Created");
		} catch (Exception e) {
			_logger.error(e);
			return false;
		}
		return true;
	}

	private boolean updateCptCodeMaster(ActionRequest actionRequest, long cptCodeMasterId, ThemeDisplay themeDisplay)
			throws PortalException {
		CptCodeMaster cptCodeMaster = cptCodeMasterLocalService.getCptCodeMaster(cptCodeMasterId);
		if (Validator.isNotNull(cptCodeMaster)) {
			if (!validateCptCode(actionRequest, cptCodeMaster)) {
				return false;
			}
			Map<Locale, String> cptCodeName = LocalizationUtil.getLocalizationMap(actionRequest,
					OmsbCptCodesConstants.CPT_CODE_NAME);
			cptCodeMaster.setModifiedBy(themeDisplay.getUserId());
			cptCodeMaster.setCptCodeNameMap(cptCodeName);
			cptCodeMaster.setGroupId(themeDisplay.getScopeGroupId());
			cptCodeMasterLocalService.updateCptCodeMaster(cptCodeMaster);
			_logger.debug("updateCptCodeMaster ::: CPT Code Master Record Updated");
		} else {
			_logger.debug("updateCptCodeMaster ::: CPT Code Record Updated Not Found " + cptCodeMasterId);
			return false;
		}
		return true;
	}

	private boolean validateCptCode(ActionRequest actionRequest, CptCodeMaster cptCodeMaster) {
		List<String> cptCodeNames = new ArrayList<>();

		Map<Locale, String> cptCodeNameMap = LocalizationUtil.getLocalizationMap(actionRequest,
				OmsbCptCodesConstants.CPT_CODE_NAME);

		addLocalizedValue(cptCodeNameMap, cptCodeNames, CommonConstants.LANGUAGE_CODE_ENGLISH);
		addLocalizedValue(cptCodeNameMap, cptCodeNames, CommonConstants.LANGUAGE_CODE_ARABIC);
		return checkCptCodeNames(cptCodeNames, actionRequest, cptCodeMaster);
	}

	private void addLocalizedValue(Map<Locale, String> localizationMap, List<String> values, String languageCode) {
		Locale languageLocale = LocaleUtil.fromLanguageId(languageCode);
		String localizedValue = localizationMap.get(languageLocale);
		if (Validator.isNotNull(localizedValue)) {
			values.add(localizedValue);
		}
	}

	private boolean checkCptCodeNames(List<String> cptCodeNames, ActionRequest actionRequest,
			CptCodeMaster cptCodeMaster) {
		List<CptCodeMaster> cptCodeMasters;
		for (String cptCodeName : cptCodeNames) {
			String likeCptCodeName = StringPool.PERCENT + StringPool.GREATER_THAN + cptCodeName + StringPool.LESS_THAN
					+ StringPool.PERCENT;
			cptCodeMasters = new ArrayList<>(cptCodeMasterLocalService.findByCptCodeNameByLike(likeCptCodeName));
			if (Validator.isNotNull(cptCodeMaster) && cptCodeMasters.contains(cptCodeMaster)) {
				cptCodeMasters.remove(cptCodeMaster);
			}
			if (!cptCodeMasters.isEmpty()) {
				SessionErrors.add(actionRequest, OmsbCptCodesConstants.CPT_CODE_NAME_ERROR);
				SessionMessages.add(actionRequest,
						PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				return true;
			}
		}
		return false;
	}

	@Reference
	private CptCodeMasterLocalService cptCodeMasterLocalService;

	@Reference
	private CounterLocalService counterLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbSaveCptCodesMVCActionCommand.class.getName());

}
