package gov.omsb.programs.web.mvccommands;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.HashMap;
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
import gov.omsb.tms.model.ProgdurationCompetenciesRequirementsRel;
import gov.omsb.tms.model.ProgdurationObjectivesRel;
import gov.omsb.tms.service.ProgdurationCompetenciesRequirementsRelLocalService;
import gov.omsb.tms.service.ProgdurationObjectivesRelLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbProgramsWebPortletKeys.OMSBPROGRAMSWEB,
		"mvc.command.name="
				+ OmsbProgramConstants.SAVE_OBJECTIVES_MVC_ACTION_COMMAND }, service = MVCActionCommand.class)
public class OmsbSaveObjectivesMVCActionCommand implements MVCActionCommand {

	@SuppressWarnings("deprecation")
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		_logger.info("OmsbSaveObjectivesMVCActionCommand ::: processAction :::");
		boolean isSuccess = true;
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		String redirect = ParamUtil.getString(actionRequest, CommonConstants.REDIRECT_COMMAND_URL);
		Locale arLocale = new Locale("ar", "SA");

		deletedObjectives(actionRequest);
		deletedSpecificObjectives(actionRequest);
		addOrUpdateProgramObjectives(actionRequest, arLocale);
		isSuccess = addOrUpdateSpecificObjectives(actionRequest, arLocale);
		

		if (!isSuccess) {
			actionResponse.getRenderParameters().setValue(CommonConstants.MVC_RENDER_COMMAND_NAME, redirect);
			 setErrorMessage(actionRequest,OmsbProgramConstants.PROGRAM_OBJECTIVES_CREATED_ERROR_MESSAGE);
		}else {
			setSucessesMessage(actionRequest, OmsbProgramConstants.PROGRAM_OBJECTIVES_CREATED_SUCCESS_MESSAGE);
			
			PortletURL renderUrl = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(),
					themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
			renderUrl.setWindowState(WindowState.NORMAL);
			renderUrl.setPortletMode(PortletMode.VIEW);
			renderUrl.setParameter(OmsbProgramConstants.MVC_COMMAND_NAME, StringPool.FORWARD_SLASH);
			try {
				actionResponse.sendRedirect(renderUrl.toString());
			} catch (IOException e) {
				_logger.error(e);
				actionResponse.getRenderParameters().setValue(OmsbProgramConstants.MVC_COMMAND_NAME, StringPool.SLASH);
			}
		}

		return isSuccess;
	}

	private void deletedObjectives(ActionRequest actionRequest) {
		String deletedObjectives = ParamUtil.getString(actionRequest, "deletedObjective");
		if(!deletedObjectives.isEmpty()) {
			String[] deleteObjectiveIds = deletedObjectives.split(StringPool.COMMA);
			for (String objectiveId : deleteObjectiveIds) {
				try {
					_logger.debug("OmsbSaveObjectivesMVCActionCommand ::: delete :::"+Long.parseLong(objectiveId));
					progdurationObjectivesRelLocalService.deleteProgdurationObjectivesRel(Long.parseLong(objectiveId));
				} catch (Exception e) {
					_logger.error(e);
				}
			}
		}
	}

	private void deletedSpecificObjectives(ActionRequest actionRequest) {
		String deletedSpecificObjectives = ParamUtil.getString(actionRequest, "deletedSpecificObjective");
		if(!deletedSpecificObjectives.isEmpty()) {
			String[] deleteSpecificObjectiveIds = deletedSpecificObjectives.split(StringPool.COMMA);
			for (String speObjectiveId : deleteSpecificObjectiveIds) {
				try {
					_logger.debug("OmsbSaveObjectivesMVCActionCommand ::: delete :::"+Long.parseLong(speObjectiveId));
					competenciesRequirementsRelLocalService.deleteProgdurationCompetenciesRequirementsRel(Long.parseLong(speObjectiveId));
				} catch (Exception e) {
					_logger.error(e);
				}
			}
		}
	}
	
	private boolean addOrUpdateProgramObjectives(ActionRequest actionRequest, Locale arLocale) {
		long programObjectivesCount = ParamUtil.getLong(actionRequest, "programObjectivesCount");
		boolean isSuccess = false;
		for (int i = 1; i <= programObjectivesCount; i++) {
			String programObjectivesUSString = ParamUtil.getString(actionRequest, "programObjectivesUS-" + i);
			String programObjectivesARString = ParamUtil.getString(actionRequest, "programObjectivesSA-" + i);
			long programObjectivesMasterId = ParamUtil.getLong(actionRequest, "programObjectivesMasterId-" + i);

			Map<Locale, String> languageValueMap = new HashMap<>();
			languageValueMap.put(Locale.US, programObjectivesUSString);
			languageValueMap.put(arLocale, programObjectivesARString);
			if(StringPool.BLANK.equals(programObjectivesUSString) && StringPool.BLANK.equals(programObjectivesARString)) {
				continue;
			}
			
			if (programObjectivesMasterId == 0) {
				isSuccess = createProgramObjectives(actionRequest, languageValueMap);
			} else {
				isSuccess = updateProgramObjectives(actionRequest, programObjectivesMasterId, languageValueMap);
			}

		}
		return isSuccess;
	}
	
	private boolean addOrUpdateSpecificObjectives(ActionRequest actionRequest, Locale arLocale) {
		long specificObjectivesCount = ParamUtil.getLong(actionRequest, "specificObjectivesCount");
		boolean isSuccess = false;
		for (int i = 1; i <= specificObjectivesCount; i++) {
			long specificObjectivesTabCount = ParamUtil.getLong(actionRequest, "specificObjectivesCount-"+i);
			long competencyMasterId = ParamUtil.getLong(actionRequest, "competencyMasterId-"+i, GetterUtil.DEFAULT_INTEGER);

			for(var j = 1; j <= specificObjectivesTabCount; j++){
				String requirementsUSString = ParamUtil.getString(actionRequest, "requirementsUS-"+i+"-"+j, StringPool.BLANK);
				String requirementsARString = ParamUtil.getString(actionRequest, "requirementsSA-"+i+"-"+j, StringPool.BLANK);
				long compentencyObjectiveMasterId = ParamUtil.getLong(actionRequest, "objectivesMasterId-"+i+"-"+j, GetterUtil.DEFAULT_INTEGER);

				Map<Locale, String> languageValueMap = new HashMap<>();
				languageValueMap.put(Locale.US, requirementsUSString);
				languageValueMap.put(arLocale, requirementsARString);
				if(StringPool.BLANK.equals(requirementsUSString) && StringPool.BLANK.equals(requirementsARString)) {
					continue;
				}

				if (compentencyObjectiveMasterId == 0) {
					isSuccess = createCompentenciesRequirements(actionRequest, competencyMasterId, languageValueMap);
				} else {
					isSuccess = updateCompentenciesRequirements(actionRequest, competencyMasterId,
							compentencyObjectiveMasterId, languageValueMap);
				}
			}
		}
		return isSuccess;
	}

	private void setErrorMessage(ActionRequest actionRequest, String message) {
		SessionErrors.add(actionRequest, message);
	}
	
	private void setSucessesMessage(ActionRequest actionRequest, String message) {
		SessionMessages.add(actionRequest, message);
	}
	
	private boolean createProgramObjectives(ActionRequest actionRequest, Map<Locale, String> programObjectives) {

		// Create ProgdurationObjectivesRel
		_logger.debug("createProgramObjectives :::" + programObjectives);
		long pDObjectivesId = counterLocalService.increment(ProgdurationObjectivesRel.class.getName());
		ProgdurationObjectivesRel progdurationObjectivesRel = progdurationObjectivesRelLocalService
				.createProgdurationObjectivesRel(pDObjectivesId);
		progdurationObjectivesRelLocalService
				.addProgdurationObjectivesRel(OmsbProgramUtil.createProgDurationObjectiveObject(actionRequest,
						progdurationObjectivesRel, programObjectives, Boolean.TRUE));
		_logger.debug("ProgdurationObjectivesRel Record Created");

		return true;
	}

	private boolean updateProgramObjectives(ActionRequest actionRequest, long programObjectivesMasterId,
			Map<Locale, String> programObjectives) {

		long progDurationId = ParamUtil.getLong(actionRequest, "progDurationId", 0);
		List<ProgdurationObjectivesRel> progdurationObjectivesRels = OmsbProgramUtil
				.getProgdurationObjectivesListByProgDurationIdAndObjetiveType(progDurationId);

		if (Validator.isNotNull(progdurationObjectivesRels) && !progdurationObjectivesRels.isEmpty()) {
			// Update ProgdurationObjectivesRel
			for (ProgdurationObjectivesRel progdurationObjectivesRel : progdurationObjectivesRels) {
				if (progdurationObjectivesRel.getPDObjectivesId() == programObjectivesMasterId) {
					progdurationObjectivesRelLocalService.updateProgdurationObjectivesRel(
							OmsbProgramUtil.createProgDurationObjectiveObject(actionRequest, progdurationObjectivesRel,
									programObjectives, Boolean.FALSE));
				}
			}
			_logger.debug("ProgdurationObjectivesRel Records Updated ");
		} else {
			return false;
		}
		return true;
	}

	private boolean createCompentenciesRequirements(ActionRequest actionRequest, long competencyMasterId,
			Map<Locale, String> requirements) {

		// Create ProgdurationCompetenciesRequirementsRel
		long competenciesRequirementsRelId = counterLocalService.increment(ProgdurationCompetenciesRequirementsRel.class.getName());
		ProgdurationCompetenciesRequirementsRel competenciesRequirementsRel = competenciesRequirementsRelLocalService
				.createProgdurationCompetenciesRequirementsRel(competenciesRequirementsRelId);
		competenciesRequirementsRelLocalService.addProgdurationCompetenciesRequirementsRel(
				OmsbProgramUtil.createCompetenciesRequirementsRelObject(actionRequest, competenciesRequirementsRel,
						competencyMasterId, requirements, Boolean.TRUE));
		_logger.debug("ProgdurationCompetenciesRequirementsRel Record Created");

		return true;
	}

	private boolean updateCompentenciesRequirements(ActionRequest actionRequest, long competencyMasterId,
			long compentencyObjectiveMasterId, Map<Locale, String> requirements) {
		long progDurationId = ParamUtil.getLong(actionRequest, "progDurationId", 0);
		List<ProgdurationCompetenciesRequirementsRel> competenciesRequirementsRels = OmsbProgramUtil
				.getCompetenciesRequirementsListByProgDurationIdAndCompetencyType(progDurationId);

		if (Validator.isNotNull(competenciesRequirementsRels) && !competenciesRequirementsRels.isEmpty()) {
			// Update ProgdurationCompetenciesRequirementsRel
			for (ProgdurationCompetenciesRequirementsRel competenciesRequirementsRel : competenciesRequirementsRels) {
				if (competenciesRequirementsRel.getProgdurationCompetenciesRelId() == compentencyObjectiveMasterId) {
					competenciesRequirementsRelLocalService.updateProgdurationCompetenciesRequirementsRel(
							OmsbProgramUtil.createCompetenciesRequirementsRelObject(actionRequest,
									competenciesRequirementsRel, competencyMasterId, requirements, Boolean.FALSE));
				}
			}
			_logger.debug("ProgdurationCompetenciesRequirementsRel Records Updated ");
		} else {
			return false;
		}

		return true;
	}

	@Reference
	private CounterLocalService counterLocalService;

	@Reference
	private ProgdurationObjectivesRelLocalService progdurationObjectivesRelLocalService;

	@Reference
	private ProgdurationCompetenciesRequirementsRelLocalService competenciesRequirementsRelLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbSaveObjectivesMVCActionCommand.class.getName());
}
