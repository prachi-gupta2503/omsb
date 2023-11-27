package gov.omsb.rotations.web.portlet.mvccommands;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.rotations.web.constants.OmsbRotationsWebPortletKeys;
import gov.omsb.rotations.web.portlet.util.OmsbRotationsUtil;
import gov.omsb.tms.model.ProgdurationRotationTraineelevelBlocksRel;
import gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel;
import gov.omsb.tms.model.RotationCompetenciesRequirementsRel;
import gov.omsb.tms.model.RotationMaster;
import gov.omsb.tms.model.RotationObjectivesRel;
import gov.omsb.tms.service.ProgdurationRotationTraineelevelBlocksRelLocalService;
import gov.omsb.tms.service.RotationCompetenciesRequirementsRelLocalService;
import gov.omsb.tms.service.RotationMasterLocalService;
import gov.omsb.tms.service.RotationObjectivesRelLocalService;

/**
 * 
 * @author Jayesh Goswami
 *
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbRotationsWebPortletKeys.OMSBROTATIONSWEB,
		"mvc.command.name="
				+ OmsbRotationsWebPortletKeys.ROTATION_SAVE_MVC_ACTION_COMMAND }, service = MVCActionCommand.class)
public class OmsbSaveRotationMVCActionCommand implements MVCActionCommand {

	private long rotationId;

	public long getRotationId() {
		return rotationId;
	}

	public void setRotationId(long rotationId) {
		this.rotationId = rotationId;
	}

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		_logger.info("ProcessAction Invoked ::: ");
		boolean isSuccess = true;
		Locale arLocale = new Locale("ar", "SA");

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long rotationMasterId = ParamUtil.getLong(actionRequest, OmsbRotationsWebPortletKeys.ROTATION_MASTER_ID, 0);
		String redirect = ParamUtil.getString(actionRequest, CommonConstants.REDIRECT_COMMAND_URL);
		String type = ParamUtil.getString(actionRequest, "type");
		long progDurationId = ParamUtil.getLong(actionRequest, OmsbRotationsWebPortletKeys.PROG_DURARION_ID);

		try {
			isSuccess = rotationMasterId != 0 ? updateRotationMaster(actionRequest, rotationMasterId)
					: createRotationMaster(actionRequest);

			if (isSuccess) {
				deletedObjectives(actionRequest);
				deletedSpecificObjectives(actionRequest);
				createOrUpdateRotationObjectives(actionRequest, arLocale);
				isSuccess = createOrUpdateSpecificObjectives(actionRequest, arLocale);
			}

			if (!isSuccess) {
				rotationMasterLocalService.deleteRotationMaster(getRotationId());
			} else {
				List<ProgdurationTraineelevelBlocksLevelTypeRel> blocksLevelTypeRels = OmsbRotationsUtil
						.getProgdurationTraineelevelBlocksLevelTypeRel(progDurationId);
				if (type.equals("add") && (!blocksLevelTypeRels.isEmpty())) {
					for (ProgdurationTraineelevelBlocksLevelTypeRel blocksLevelTypeRel : blocksLevelTypeRels) {
						createRotationTraineeLevelBlocks(actionRequest, blocksLevelTypeRel.getTraineeLevelId(),
								rotationId);
					}
				}
			}
		} catch (PortalException e) {
			_logger.error("Error while creating/updating rotation master" + e);
		}

		if (!isSuccess) {
			actionResponse.getRenderParameters().setValue(CommonConstants.MVC_RENDER_COMMAND_NAME, redirect);
		} else {
			try {
				actionResponse.sendRedirect(
						OmsbRotationsUtil.createAddRotationRenderUrl(themeDisplay, actionRequest, progDurationId));
			} catch (IOException e) {
				_logger.error(e);
			}
		}

		_logger.info("ProcessAction Exit ::: ");
		return isSuccess;
	}

	private void deletedObjectives(ActionRequest actionRequest) {
		String deletedObjectives = ParamUtil.getString(actionRequest, "deletedObjective");
		if (!deletedObjectives.isEmpty()) {
			String[] deleteObjectiveIds = deletedObjectives.split(StringPool.COMMA);
			for (String objectiveId : deleteObjectiveIds) {
				try {
					_logger.debug("OmsbSaveRotationMVCActionCommand ::: delete :::" + Long.parseLong(objectiveId));
					rotationObjectivesRelLocalService.deleteRotationObjectivesRel(Long.parseLong(objectiveId));
				} catch (Exception e) {
					_logger.error(e);
				}
			}
		}
	}

	private void deletedSpecificObjectives(ActionRequest actionRequest) {
		String deletedSpecificObjectives = ParamUtil.getString(actionRequest, "deletedSpecificObjective");
		if (!deletedSpecificObjectives.isEmpty()) {
			String[] deleteSpecificObjectiveIds = deletedSpecificObjectives.split(StringPool.COMMA);
			for (String speObjectiveId : deleteSpecificObjectiveIds) {
				try {
					_logger.debug("OmsbSaveRotationMVCActionCommand ::: delete :::" + Long.parseLong(speObjectiveId));
					competenciesRequirementsRelLocalService
							.deleteRotationCompetenciesRequirementsRel(Long.parseLong(speObjectiveId));
				} catch (Exception e) {
					_logger.error(e);
				}
			}
		}
	}

	private boolean createOrUpdateRotationObjectives(ActionRequest actionRequest, Locale arLocale) {
		long rotationObjectivesCount = ParamUtil.getLong(actionRequest, "programObjectivesCount");
		boolean isSuccess = false;
		for (int i = 1; i <= rotationObjectivesCount; i++) {
			String rotationObjectivesUSString = ParamUtil.getString(actionRequest, "programObjectivesUS-" + i,
					StringPool.BLANK);
			String rotationObjectivesARString = ParamUtil.getString(actionRequest, "programObjectivesSA-" + i,
					StringPool.BLANK);
			long programObjectivesMasterId = ParamUtil.getLong(actionRequest, "programObjectivesMasterId-" + i);

			Map<Locale, String> languageValueMap = new HashMap<>();
			languageValueMap.put(Locale.US, rotationObjectivesUSString);
			languageValueMap.put(arLocale, rotationObjectivesARString);
			if (StringPool.BLANK.equals(rotationObjectivesUSString)
					&& StringPool.BLANK.equals(rotationObjectivesARString)) {
				continue;
			}

			if (programObjectivesMasterId == 0) {
				isSuccess = createRotationObjectives(actionRequest, languageValueMap, getRotationId());
			} else {
				isSuccess = updateRotationObjectives(actionRequest, programObjectivesMasterId, languageValueMap,
						getRotationId());
			}
		}
		return isSuccess;
	}

	private boolean createOrUpdateSpecificObjectives(ActionRequest actionRequest, Locale arLocale) {
		long specificObjectivesCount = ParamUtil.getLong(actionRequest, "specificObjectivesCount");
		boolean isSuccess = false;

		for (int i = 1; i <= specificObjectivesCount; i++) {
			long specificObjectivesTabCount = ParamUtil.getLong(actionRequest, "specificObjectivesCount-" + i);
			long competencyMasterId = ParamUtil.getLong(actionRequest, "competencyMasterId-" + i,
					GetterUtil.DEFAULT_INTEGER);

			for (var j = 1; j <= specificObjectivesTabCount; j++) {
				String requirementsUSString = ParamUtil.getString(actionRequest, "requirementsUS-" + i + "-" + j,
						StringPool.BLANK);
				String requirementsARString = ParamUtil.getString(actionRequest, "requirementsSA-" + i + "-" + j,
						StringPool.BLANK);
				long compentencyObjectiveMasterId = ParamUtil.getLong(actionRequest,
						"objectivesMasterId-" + i + "-" + j, GetterUtil.DEFAULT_INTEGER);

				Map<Locale, String> languageValueMap = new HashMap<>();
				languageValueMap.put(Locale.US, requirementsUSString);
				languageValueMap.put(arLocale, requirementsARString);
				if (StringPool.BLANK.equals(requirementsUSString) && StringPool.BLANK.equals(requirementsARString)) {
					continue;
				}

				if (compentencyObjectiveMasterId == 0) {
					isSuccess = createCompentenciesRequirements(actionRequest, competencyMasterId, languageValueMap,
							getRotationId());
				} else {
					isSuccess = updateCompentenciesRequirements(actionRequest, competencyMasterId,
							compentencyObjectiveMasterId, languageValueMap, getRotationId());
				}
			}
		}
		return isSuccess;
	}

	private boolean createRotationMaster(ActionRequest actionRequest) {
		try {
			// validate Rotation
			if (!validateRotation(actionRequest, null)) {
				return false;
			}
			long rotationMasterId = counterLocalService.increment(getClass().getName(), 1);
			RotationMaster rotationMaster = rotationMasterLocalService.createRotationMaster(rotationMasterId);
			RotationMaster createdRotationMaster = rotationMasterLocalService
					.addRotationMaster(OmsbRotationsUtil.createRotationMasterObject(actionRequest, rotationMaster));
			rotationId = createdRotationMaster.getRotationMasterId();

			setRotationId(rotationMasterId);
			_logger.debug("createRotationMaster ::: Rotation Master Record Created");
		} catch (Exception e) {
			_logger.error(e);
			return false;
		}
		return true;
	}

	private boolean updateRotationMaster(ActionRequest actionRequest, long rotationMasterId) throws PortalException {
		RotationMaster rotationsMaster = rotationMasterLocalService.getRotationMaster(rotationMasterId);
		if (Validator.isNotNull(rotationsMaster)) {
			// validate Rotation
			if (!validateRotation(actionRequest, rotationsMaster)) {
				return false;
			}
			rotationMasterLocalService
					.updateRotationMaster(OmsbRotationsUtil.createRotationMasterObject(actionRequest, rotationsMaster));
			setRotationId(rotationMasterId);
			_logger.debug("updateRotationMaster ::: Rotation Master Record Updated");
		} else {
			_logger.debug("updateRotationMaster ::: Rotation Master Record Updated Not Found " + rotationMasterId);
			return false;
		}
		return true;
	}

	private boolean validateRotation(ActionRequest actionRequest, RotationMaster rotationMaster) {
		List<String> rotationNames = new ArrayList<>();
		List<String> rotationCodes = new ArrayList<>();
		boolean isValid = true;

		Map<Locale, String> rotationNameMap = LocalizationUtil.getLocalizationMap(actionRequest,
				OmsbRotationsWebPortletKeys.ROTATION_NAME);
		Map<Locale, String> rotationCodeMap = LocalizationUtil.getLocalizationMap(actionRequest,
				OmsbRotationsWebPortletKeys.ROTATION_CODE);

		addLocalizedValue(rotationNameMap, rotationNames, CommonConstants.LANGUAGE_CODE_ENGLISH);
		addLocalizedValue(rotationNameMap, rotationNames, CommonConstants.LANGUAGE_CODE_ARABIC);

		addLocalizedValue(rotationCodeMap, rotationCodes, CommonConstants.LANGUAGE_CODE_ENGLISH);
		addLocalizedValue(rotationCodeMap, rotationCodes, CommonConstants.LANGUAGE_CODE_ARABIC);

		List<String> languageCodes = new ArrayList<>();
		languageCodes.add(CommonConstants.LANGUAGE_CODE_ENGLISH);
		languageCodes.add(CommonConstants.LANGUAGE_CODE_ARABIC);

		if (checkRotationNames(rotationNames, actionRequest, rotationMaster)
				|| checkRotationCodes(rotationCodes, actionRequest, rotationMaster)) {
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

	private boolean checkRotationNames(List<String> rotationNames, ActionRequest actionRequest,
			RotationMaster rotationMaster) {
		List<RotationMaster> rotationMasters;
		for (String rotationName : rotationNames) {
			String likeRotationName = StringPool.PERCENT + StringPool.GREATER_THAN + rotationName + StringPool.LESS_THAN
					+ StringPool.PERCENT;
			rotationMasters = new ArrayList<>(rotationMasterLocalService.findByRotationNameByLike(likeRotationName));
			if (Validator.isNotNull(rotationMaster) && rotationMasters.contains(rotationMaster)) {
				rotationMasters.remove(rotationMaster);
			}
			if (!rotationMasters.isEmpty()) {
				SessionErrors.add(actionRequest, OmsbRotationsWebPortletKeys.ROTATION_NAME_ERROR);
				SessionMessages.add(actionRequest,
						PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				return true;
			}
		}
		return false;
	}

	private boolean checkRotationCodes(List<String> rotationCodes, ActionRequest actionRequest,
			RotationMaster rotationMaster) {
		List<RotationMaster> rotationMasters;
		for (String rotationCode : rotationCodes) {
			String likeRotationCode = StringPool.PERCENT + StringPool.GREATER_THAN + rotationCode + StringPool.LESS_THAN
					+ StringPool.PERCENT;
			rotationMasters = new ArrayList<>(rotationMasterLocalService.findByRotationCodeByLike(likeRotationCode));
			if (Validator.isNotNull(rotationMaster) && rotationMasters.contains(rotationMaster)) {
				rotationMasters.remove(rotationMaster);
			}
			if (!rotationMasters.isEmpty()) {
				SessionErrors.add(actionRequest, OmsbRotationsWebPortletKeys.ROTATION_CODE_ERROR);
				SessionMessages.add(actionRequest,
						PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
				return true;
			}
		}
		return false;
	}

	private boolean createRotationObjectives(ActionRequest actionRequest, Map<Locale, String> rotationObjectives,
			long rotationId) {
		// Create ProgdurationObjectivesRel
		long pDObjectivesId = counterLocalService.increment(getClass().getName(), 1);
		RotationObjectivesRel rotationObjectivesRel = rotationObjectivesRelLocalService
				.createRotationObjectivesRel(pDObjectivesId);
		rotationObjectivesRelLocalService.addRotationObjectivesRel(OmsbRotationsUtil.createRotationObjectiveObject(
				actionRequest, rotationObjectivesRel, rotationObjectives, rotationId, Boolean.TRUE));
		_logger.debug("rotationObjectivesRel Record Created");

		return true;
	}

	private boolean updateRotationObjectives(ActionRequest actionRequest, long programObjectivesMasterId,
			Map<Locale, String> rotationObjectives, long rotationId) {

		long progDurationId = ParamUtil.getLong(actionRequest, OmsbRotationsWebPortletKeys.PROG_DURARION_ID, 0);
		List<RotationObjectivesRel> rotationObjectivesRels = OmsbRotationsUtil
				.getRotationObjectivesListByProgDurationIdAndRotationId(progDurationId, rotationId);

		if (Validator.isNotNull(rotationObjectivesRels) && !rotationObjectivesRels.isEmpty()) {
			// Update ProgdurationObjectivesRel
			for (RotationObjectivesRel rotationObjectivesRel : rotationObjectivesRels) {
				if (rotationObjectivesRel.getRotationObjectivesRelId() == programObjectivesMasterId) {
					rotationObjectivesRelLocalService
							.updateRotationObjectivesRel(OmsbRotationsUtil.createRotationObjectiveObject(actionRequest,
									rotationObjectivesRel, rotationObjectives, rotationId, Boolean.FALSE));
				}
			}
			_logger.debug("rotationObjectivesRel Records Updated ");
		} else {
			return false;
		}
		return true;
	}

	private boolean createCompentenciesRequirements(ActionRequest actionRequest, long competencyMasterId,
			Map<Locale, String> requirements, long rotationId) {
		long competenciesRequirementsRelId = counterLocalService.increment(getClass().getName(), 1);
		RotationCompetenciesRequirementsRel competenciesRequirementsRel = competenciesRequirementsRelLocalService
				.createRotationCompetenciesRequirementsRel(competenciesRequirementsRelId);
		competenciesRequirementsRelLocalService.addRotationCompetenciesRequirementsRel(
				OmsbRotationsUtil.createCompetenciesRequirementsRelObject(actionRequest, competenciesRequirementsRel,
						competencyMasterId, requirements, rotationId, Boolean.TRUE));
		_logger.debug("RotationCompetenciesRequirementsRel Record Created");

		return true;
	}

	private boolean updateCompentenciesRequirements(ActionRequest actionRequest, long competencyMasterId,
			long compentencyObjectiveMasterId, Map<Locale, String> requirements, long rotationId) {

		long progDurationId = ParamUtil.getLong(actionRequest, OmsbRotationsWebPortletKeys.PROG_DURARION_ID, 0);
		List<RotationCompetenciesRequirementsRel> competenciesRequirementsRels = OmsbRotationsUtil
				.getCompetenciesRequirementsListByProgDurationIdAndRotationId(progDurationId, rotationId);

		if (Validator.isNotNull(competenciesRequirementsRels) && !competenciesRequirementsRels.isEmpty()) {
			// Update ProgdurationCompetenciesRequirementsRel
			for (RotationCompetenciesRequirementsRel competenciesRequirementsRel : competenciesRequirementsRels) {
				if (competenciesRequirementsRel.getRotationCompetenciesRelId() == compentencyObjectiveMasterId) {
					competenciesRequirementsRelLocalService.updateRotationCompetenciesRequirementsRel(OmsbRotationsUtil
							.createCompetenciesRequirementsRelObject(actionRequest, competenciesRequirementsRel,
									competencyMasterId, requirements, rotationId, Boolean.FALSE));
				}
			}
			_logger.debug("RotationCompetenciesRequirementsRel Records Updated ");
		} else {
			return false;
		}

		return true;
	}

	private boolean createRotationTraineeLevelBlocks(ActionRequest actionRequest, long traineeLevelId,
			long rotationId) {
		long rotationTraineeLevelBlocksId = counterLocalService.increment(getClass().getName(), 1);
		ProgdurationRotationTraineelevelBlocksRel traineelevelBlocksLevelTypeRel = rotationTraineelevelBlocksRelLocalService
				.createProgdurationRotationTraineelevelBlocksRel(rotationTraineeLevelBlocksId);
		rotationTraineelevelBlocksRelLocalService.addProgdurationRotationTraineelevelBlocksRel(
				OmsbRotationsUtil.createProgdurationRotationTraineelevelBlocksRelObject(actionRequest,
						traineelevelBlocksLevelTypeRel, traineeLevelId, rotationId, Boolean.TRUE));

		return true;
	}

	@Reference
	private RotationObjectivesRelLocalService rotationObjectivesRelLocalService;

	@Reference
	private RotationCompetenciesRequirementsRelLocalService competenciesRequirementsRelLocalService;

	@Reference
	private RotationMasterLocalService rotationMasterLocalService;

	@Reference
	private CounterLocalService counterLocalService;

	@Reference
	private ProgdurationRotationTraineelevelBlocksRelLocalService rotationTraineelevelBlocksRelLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbSaveRotationMVCActionCommand.class.getName());

}
