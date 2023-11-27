package gov.omsb.programs.web.mvccommands;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
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
import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.programs.web.constants.OmsbProgramConstants;
import gov.omsb.programs.web.constants.OmsbProgramsWebPortletKeys;
import gov.omsb.programs.web.portlet.util.OmsbProgramUtil;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.service.ProgramMasterLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbProgramsWebPortletKeys.OMSBPROGRAMSWEB,
		"mvc.command.name=" + OmsbProgramConstants.SAVE_PROGRAM_MVC_ACTION_COMMAND }, service = MVCActionCommand.class)
public class OmsbSaveProgramMVCActionCommand implements MVCActionCommand {

	@SuppressWarnings("deprecation")
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		_logger.info("ProcessAction Invoked ::: ");
		boolean isSuccess = true;
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long programMasterId = ParamUtil.getLong(actionRequest, OmsbProgramConstants.PROGRAM_MASTER_ID, 0);
		String redirect = ParamUtil.getString(actionRequest, CommonConstants.REDIRECT_COMMAND_URL);
		try {
			if (programMasterId != 0) {
				// Update Program Master
				isSuccess = updateProgram(actionRequest, programMasterId);
			} else {
				// Create Program Master
				isSuccess = createProgram(actionRequest);
			}
		} catch (PortalException e) {
			setErrorMessage(actionRequest, e.getLocalizedMessage());
			_logger.error(e);
			isSuccess = false;
		}
		if (!isSuccess) {
			actionResponse.getRenderParameters().setValue(CommonConstants.MVC_RENDER_COMMAND_NAME, redirect);
		}else {
			PortletURL renderUrl = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(),
					themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
			renderUrl.setWindowState(WindowState.NORMAL);
			renderUrl.setPortletMode(PortletMode.VIEW);
			renderUrl.setParameter(CommonConstants.MVC_RENDER_COMMAND_NAME, StringPool.FORWARD_SLASH);
			try {
				actionResponse.sendRedirect(renderUrl.toString());
			} catch (IOException e) {
				_logger.error(e);
				actionResponse.getRenderParameters().setValue(CommonConstants.MVC_RENDER_COMMAND_NAME, StringPool.SLASH);
			}
		}
		_logger.info("ProcessAction Exit ::: ");
		return isSuccess;
	}

	private boolean createProgram(ActionRequest actionRequest) {
		try {

			// validate Program
			if (!validateProgram(actionRequest, null)) {
				return false;
			}

			// Create Program
			long programMasterId = counterLocalService.increment(ProgramMaster.class.getName());
			ProgramMaster programMaster = programMasterLocalService.createProgramMaster(programMasterId);
			programMasterLocalService.addProgramMaster(
					OmsbProgramUtil.createProgramMasterObject(actionRequest, programMaster, Boolean.TRUE));
			_logger.debug("createProgram ::: Program Master Record Created");
			setSucessesMessage(actionRequest, OmsbProgramConstants.PROGRAM_CREATED_SUCCESS_MESSAGE);

		} catch (Exception e) {
			 setErrorMessage(actionRequest, e.getLocalizedMessage());
			_logger.error(e);
			return false;
		}
		return true;
	}

	private boolean updateProgram(ActionRequest actionRequest, long programMasterId) throws PortalException {
		ProgramMaster programMaster = programMasterLocalService.getProgramMaster(programMasterId);
		if (Validator.isNotNull(programMaster)) {

			// validate Program
			if (!validateProgram(actionRequest, programMaster)) {
				return false;
			}

			// Update Program
			programMasterLocalService.updateProgramMaster(
					OmsbProgramUtil.createProgramMasterObject(actionRequest, programMaster, Boolean.FALSE));
			setSucessesMessage(actionRequest, OmsbProgramConstants.PROGRAM_UPDATED_SUCCESS_MESSAGE);
			_logger.debug("updateProgram ::: Program Master Record Updated");

		} else {
			_logger.debug("updateProgram ::: Program Master Record Updated Not Found " + programMasterId);
			return false;
		}
		return true;
	}

	private boolean validateProgram(ActionRequest actionRequest, ProgramMaster programMaster) {
		List<String> programNames = new ArrayList<>();
		List<String> programCodes = new ArrayList<>();
		boolean isValid = true;

		Map<Locale, String> programNameMap = LocalizationUtil.getLocalizationMap(actionRequest,	OmsbProgramConstants.PROGRAM_NAME);
		Map<Locale, String> programCodeMap = LocalizationUtil.getLocalizationMap(actionRequest, OmsbProgramConstants.PROGRAM_CODE);
		Map<Locale, String> programVisionMap = LocalizationUtil.getLocalizationMap(actionRequest, OmsbProgramConstants.PROGRAM_VISION);
		Map<Locale, String> programMissionMap = LocalizationUtil.getLocalizationMap(actionRequest, OmsbProgramConstants.PROGRAM_MISSION);
		Map<Locale, String> programAdmissionRequirementsMap = LocalizationUtil.getLocalizationMap(actionRequest, OmsbProgramConstants.PROGRAM_ADMISSION_REQUIREMENTS);


		addLocalizedValue(programNameMap, programNames, CommonConstants.LANGUAGE_CODE_ENGLISH);
		addLocalizedValue(programNameMap, programNames, CommonConstants.LANGUAGE_CODE_ARABIC);

		addLocalizedValue(programCodeMap, programCodes, CommonConstants.LANGUAGE_CODE_ENGLISH);
		addLocalizedValue(programCodeMap, programCodes, CommonConstants.LANGUAGE_CODE_ARABIC);
		
		List<String> languageCodes = new ArrayList<>();
		languageCodes.add(CommonConstants.LANGUAGE_CODE_ENGLISH);
		languageCodes.add(CommonConstants.LANGUAGE_CODE_ARABIC);
		if (checkProgramNames(programNames, actionRequest, programMaster)
				|| checkProgramCodes(programCodes, actionRequest, programMaster) || 
				Boolean.TRUE.equals(checkLocalizedValue(programNameMap,programVisionMap, OmsbProgramConstants.PROGRAM_VISION_ERROR,languageCodes,actionRequest)) ||
				Boolean.TRUE.equals(checkLocalizedValue(programNameMap,programMissionMap, OmsbProgramConstants.PROGRAM_MISSION_ERROR,languageCodes,actionRequest)) || 
				Boolean.TRUE.equals(checkLocalizedValue(programNameMap,programAdmissionRequirementsMap, OmsbProgramConstants.PROGRAM_ADMIN_REQUIREMENTS_ERROR,languageCodes,actionRequest))) {
			isValid = false;
		}

		return isValid;
	}

	private void addLocalizedValue(Map<Locale, String> localizationMap, List<String> values, String languageCode) {
		Locale languageLocale = LocaleUtil.fromLanguageId(languageCode);
		String localizedValue = localizationMap.get(languageLocale);
		if (Validator.isNotNull(localizedValue)) {
			values.add(localizedValue);
		}
	}
	private Boolean checkLocalizedValue(Map<Locale, String> localizationMap,Map<Locale, String> localizationCompareMap, String error, List<String> languageCodes,ActionRequest actionRequest) {
		boolean result = false;
		for (String languageCode : languageCodes) {
			Locale languageLocale = LocaleUtil.fromLanguageId(languageCode);
			String localizedValue = localizationMap.get(languageLocale);
			String localizationCompareValue = localizationCompareMap.get(languageLocale);
			if(Validator.isNotNull(localizedValue)) {
				if(Validator.isNotNull(localizationCompareValue)) {
					result = false;
				}else {
					setErrorMessage(actionRequest, error);
			        return true;
				}
			}
		}
		return result;
		
	}

	private boolean checkProgramNames(List<String> programNames, ActionRequest actionRequest,
			ProgramMaster programMaster) {
		List<ProgramMaster> programsMasters;
		for (String programName : programNames) {
			String likeProgramName = StringPool.PERCENT + StringPool.GREATER_THAN + programName + StringPool.LESS_THAN
					+ StringPool.PERCENT;
			programsMasters = new ArrayList<>(programMasterLocalService.findByProgramNameByLike(likeProgramName));
			if (Validator.isNotNull(programMaster) && programsMasters.contains(programMaster)) {
				programsMasters.remove(programMaster);
			}
			if (!programsMasters.isEmpty()) {
				setErrorMessage(actionRequest, OmsbProgramConstants.PROGRAM_NAME_ERROR);
				return true;
			}
		}
		return false;
	}

	private boolean checkProgramCodes(List<String> programCodes, ActionRequest actionRequest,
			ProgramMaster programMaster) {
		List<ProgramMaster> programsMasters;
		for (String programCode : programCodes) {
			String likeProgramCode = StringPool.PERCENT + StringPool.GREATER_THAN + programCode + StringPool.LESS_THAN
					+ StringPool.PERCENT;
			programsMasters = new ArrayList<>(programMasterLocalService.findByProgramCodeByLike(likeProgramCode));
			if (Validator.isNotNull(programMaster) && programsMasters.contains(programMaster)) {
				programsMasters.remove(programMaster);
			}
			if (!programsMasters.isEmpty()) {
				setErrorMessage(actionRequest, OmsbProgramConstants.PROGRAM_CODE_ERROR);
				return true;
			}
		}
		return false;
	}

	private void setErrorMessage(ActionRequest actionRequest, String message) {
		SessionErrors.add(actionRequest, message);
	}
	
	private void setSucessesMessage(ActionRequest actionRequest, String message) {
		SessionMessages.add(actionRequest, message);
	}
	
	@Reference
	private ProgramMasterLocalService programMasterLocalService;

	@Reference
	private CounterLocalService counterLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbSaveProgramMVCActionCommand.class.getName());
}
