package gov.omsb.patient.types.web.portlet.mvccommands;

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
import gov.omsb.patient.types.web.constants.OmsbPatientTypesWebPortletKeys;
import gov.omsb.patient.types.web.portlet.util.OmsbPatientTypeUtil;
import gov.omsb.tms.model.PatientTypeMaster;
import gov.omsb.tms.service.PatientTypeMasterLocalService;

/**
 * @author Jayesh Goswami
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbPatientTypesWebPortletKeys.OMSBPATIENTTYPESWEB,
		"mvc.command.name="
				+ OmsbPatientTypesWebPortletKeys.SAVE_PATIENT_TYPE_MVC_ACTION_COMMAND }, service = MVCActionCommand.class)
public class OmsbSavePatientTypeMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		_logger.info("ProcessAction Invoked ::: ");
		boolean isSuccess = true;
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long patientTypeMasterId = ParamUtil.getLong(actionRequest,
				OmsbPatientTypesWebPortletKeys.PATIENT_TYPE_MASTER_ID, 0);

		try {
			if (patientTypeMasterId != 0) {
				// Update Patient Type Master
				isSuccess = updatePatientTypeMaster(actionRequest, patientTypeMasterId, themeDisplay);
			} else {
				// Create Patient Type Master
				isSuccess = createPatientTypeMaster(actionRequest, themeDisplay);
			}
		} catch (PortalException e) {
			_logger.error(e);
			isSuccess = false;
		}
		_logger.info("ProcessAction Exit ::: ");
		return isSuccess;
	}

	private boolean updatePatientTypeMaster(ActionRequest actionRequest, long patientTypeMasterId,
			ThemeDisplay themeDisplay) throws PortalException {
		PatientTypeMaster patientTypesMaster = patientTypeMasterLocalService.getPatientTypeMaster(patientTypeMasterId);
		if (Validator.isNotNull(patientTypesMaster)) {
			if (!validatePatientType(actionRequest, patientTypesMaster)) {
				return false;
			}
			patientTypeMasterLocalService.updatePatientTypeMaster(OmsbPatientTypeUtil
					.createPatientTypeMasterObject(actionRequest, patientTypesMaster, Boolean.FALSE, themeDisplay));
			_logger.debug("updatePatientTypeMaster ::: Patient Type Master Record Updated");
		} else {
			_logger.debug("updatePatientTypeMaster ::: Patient Type Master Record Not Found " + patientTypeMasterId);
			return false;
		}
		return true;

	}

	private boolean createPatientTypeMaster(ActionRequest actionRequest, ThemeDisplay themeDisplay) {
		long patientTypeMasterId = counterLocalService.increment(getClass().getName(), 1);
		try {
			if (!validatePatientType(actionRequest, null)) {
				return false;
			}
			PatientTypeMaster patientTypeMaster = patientTypeMasterLocalService
					.createPatientTypeMaster(patientTypeMasterId);
			patientTypeMasterLocalService.addPatientTypeMaster(OmsbPatientTypeUtil
					.createPatientTypeMasterObject(actionRequest, patientTypeMaster, Boolean.TRUE, themeDisplay));
			_logger.info("createPatientTypeMaster ::: Patient Type Master Record Created");
		} catch (Exception e) {
			_logger.error(e);
			return false;
		}
		return true;
	}

	private boolean validatePatientType(ActionRequest actionRequest, PatientTypeMaster patientTypeMaster) {
		List<String> patientTypeNames = new ArrayList<>();

		Map<Locale, String> patientTypeNameMap = LocalizationUtil.getLocalizationMap(actionRequest,
				OmsbPatientTypesWebPortletKeys.PATIENT_TYPE_NAME);

		addLocalizedValue(patientTypeNameMap, patientTypeNames, CommonConstants.LANGUAGE_CODE_ENGLISH);
		addLocalizedValue(patientTypeNameMap, patientTypeNames, CommonConstants.LANGUAGE_CODE_ARABIC);

		if (checkPatientTypeNames(patientTypeNames, actionRequest, patientTypeMaster)) {
			return false;
		}

		return true;
	}

	private void addLocalizedValue(Map<Locale, String> localizationMap, List<String> values, String languageCode) {
		Locale languageLocale = LocaleUtil.fromLanguageId(languageCode);
		String localizedValue = localizationMap.get(languageLocale);
		if (Validator.isNotNull(localizedValue)) {
			values.add(localizedValue);
		}
	}

	private boolean checkPatientTypeNames(List<String> patientTypeNames, ActionRequest actionRequest,
			PatientTypeMaster patientTypeMaster) {
		List<PatientTypeMaster> patientTypeMasters;
		for (String patientTypeName : patientTypeNames) {
			String likePatientTypeName = StringPool.PERCENT + StringPool.GREATER_THAN + patientTypeName
					+ StringPool.LESS_THAN + StringPool.PERCENT;
			patientTypeMasters = new ArrayList<>(
					patientTypeMasterLocalService.findByPatientTypeNameByLike(likePatientTypeName));
			if (Validator.isNotNull(patientTypeMaster) && patientTypeMasters.contains(patientTypeMaster)) {
				patientTypeMasters.remove(patientTypeMaster);
			}
			if (!patientTypeMasters.isEmpty()) {
				SessionErrors.add(actionRequest, OmsbPatientTypesWebPortletKeys.PATIENT_TYPE_NAME_ERROR);
				SessionMessages.add(actionRequest,
						PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				return true;
			}
		}
		return false;
	}

	@Reference
	private PatientTypeMasterLocalService patientTypeMasterLocalService;

	@Reference
	private CounterLocalService counterLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbSavePatientTypeMVCActionCommand.class.getName());

}
