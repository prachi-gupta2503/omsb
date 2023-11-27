package gov.omsb.training.sites.web.portlet.util;

import com.liferay.dispatch.executor.BaseDispatchTaskExecutor;
import com.liferay.dispatch.executor.DispatchTaskExecutor;
import com.liferay.dispatch.executor.DispatchTaskExecutorOutput;
import com.liferay.dispatch.model.DispatchTrigger;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.service.util.UserMetadataUtil;
import gov.omsb.tms.custom.dto.ConfigureRotationBlockDetailsDTO;
import gov.omsb.tms.custom.dto.ProgdurationRotationTrainingSiteDTO;
import gov.omsb.tms.custom.dto.TrainingSiteStructureDTO;
import gov.omsb.tms.model.ProgramMasterModel;
import gov.omsb.tms.model.TrainingSitesMaster;
import gov.omsb.tms.service.ProgdurationRotationTraineelevelBlocksRelLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;
import gov.omsb.tms.service.TrainingSitesMasterLocalService;
import gov.omsb.training.sites.web.configurable.action.OmsbTrainingSitesConfigurableAction;
import gov.omsb.training.sites.web.constants.OmsbTrainingSitesWebPortletKeys;

@Component(property = {
		"dispatch.task.executor.name=" + OmsbTrainingSitesWebPortletKeys.OMSB_TRAINING_SITES_TASK_EXECUTOR,
		"dispatch.task.executor.type=Shortage-Checker" }, service = DispatchTaskExecutor.class)

public class OmsbTrainingSitesTaskExecutor extends BaseDispatchTaskExecutor {

	private static Map<Long, Boolean> shortageMap;

	public static Map<Long, Boolean> getShortageMap() {
		return shortageMap;
	}

	public static void setShortageMap(Map<Long, Boolean> shortageMap) {
		OmsbTrainingSitesTaskExecutor.shortageMap = shortageMap;
	}


	@Override
	public String getName() {
		return "OmsbTrainingSitesCheckShortageUtil";
	}

	@Override
	public void doExecute(DispatchTrigger dispatchTrigger, DispatchTaskExecutorOutput dispatchTaskExecutorOutput)
			throws Exception {
		_logger.debug("job scheduler for shortage called :::");
		setShortageMap(getShortageForTrainingSiteWithRotations());
	}

	public Map<Long, Boolean> getShortageForTrainingSiteWithRotations() {
		String currentYear = OmsbTrainingSitesUtil.getCurrentYear();
		Map<Long, Boolean> rotationShortageMap = new HashMap<>();

		List<Long> programIds = programMasterLocalService.getProgramMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS)
				.stream().map(ProgramMasterModel::getProgramMasterId).collect(Collectors.toList());

		List<TrainingSitesMaster> trainingSitesMasterList = trainingSitesMasterLocalService
				.getTrainingSitesMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		for (TrainingSitesMaster trainingSitesMaster : trainingSitesMasterList) {
			Map<Long, Long> rotationWiseSupplyMap = calculateRotationWiseSupplyMap(programIds, currentYear,
					trainingSitesMaster);

			Map<Long, Long> rotationWiseDemandMap = calculateRotationWiseDemandMap(programIds, currentYear,
					trainingSitesMaster);

			for (Long key : rotationWiseSupplyMap.keySet()) {
				boolean shortage = rotationWiseDemandMap.getOrDefault(key, 0L) > rotationWiseSupplyMap.getOrDefault(key,
						0L);
				rotationShortageMap.put(key, shortage);
			}
		}
		return rotationShortageMap;
	}

	private Map<Long, Long> calculateRotationWiseSupplyMap(List<Long> programIds, String currentYear,
			TrainingSitesMaster trainingSitesMaster) {
		Map<Long, Long> rotationWiseSupplyMap = new HashMap<>();
		List<TrainingSiteStructureDTO> trainingSiteStructureDTOList = trainingSitesMasterLocalService
				.getTrainingSiteStructure(programIds, currentYear, trainingSitesMaster.getTrainingSiteMasterId(),
						trainingSitesMaster.getTrainingSiteNameCurrentLanguageId());

		for (TrainingSiteStructureDTO trainingSiteStructureDTO : trainingSiteStructureDTOList) {
			long trainingSiteSupply = calculateTrainingSiteSupply(trainingSiteStructureDTO, currentYear,
					trainingSitesMaster);
			rotationWiseSupplyMap.put(trainingSiteStructureDTO.getRotationId(), trainingSiteSupply);
		}
		return rotationWiseSupplyMap;
	}

	private long calculateTrainingSiteSupply(TrainingSiteStructureDTO trainingSiteStructureDTO, String currentYear,
			TrainingSitesMaster trainingSitesMaster) {
		List<ProgdurationRotationTrainingSiteDTO> progdurationRotationTrainingSiteDTOs = trainingSitesMasterLocalService
				.getProgdurationRotationByRotationAndDuration(trainingSiteStructureDTO.getRotationId(), currentYear,
						trainingSitesMaster.getTrainingSiteNameCurrentLanguageId());

		return progdurationRotationTrainingSiteDTOs.stream()
				.mapToLong(
						progdurationRotationTrainingSiteDTO -> progdurationRotationTrainingSiteDTO.getNoOfSlots() * 13)
				.sum();
	}

	private Map<Long, Long> calculateRotationWiseDemandMap(List<Long> programIds, String currentYear,
			TrainingSitesMaster trainingSitesMaster) {
		Map<Long, Long> rotationWiseDemandMap = new HashMap<>();

		List<TrainingSiteStructureDTO> trainingSiteStructureDTOList = trainingSitesMasterLocalService
				.getTrainingSiteStructure(programIds, currentYear, trainingSitesMaster.getTrainingSiteMasterId(),
						trainingSitesMaster.getTrainingSiteNameCurrentLanguageId());

		for (TrainingSiteStructureDTO trainingSiteStructureDTO : trainingSiteStructureDTOList) {
			long trainingSiteDemand = calculateTrainingSiteDemand(trainingSiteStructureDTO, currentYear);
			rotationWiseDemandMap.put(trainingSiteStructureDTO.getRotationId(), trainingSiteDemand);
		}
		return rotationWiseDemandMap;
	}

	private long calculateTrainingSiteDemand(TrainingSiteStructureDTO trainingSiteStructureDTO, String currentYear) {
		long traineeCount = OmsbTrainingSitesConfigurableAction.traineeCount();

		ConfigureRotationBlockDetailsDTO configureRotationBlockDetailsDTO = null;
		try {
			configureRotationBlockDetailsDTO = progdurationRotationTraineelevelBlocksRelLocalService
					.getConfigureRotationDetailsByRotationAndDuration(trainingSiteStructureDTO.getRotationId(),
							currentYear);
		} catch (Exception e) {
			_logger.error(e.getMessage());
		}
		if (configureRotationBlockDetailsDTO != null) {
			long noOfBlocks = configureRotationBlockDetailsDTO.getNoOfBlocks();
			return noOfBlocks * traineeCount;
		}
		return 0;
	}

	@Reference
	private UserMetadataUtil userMetadataUtil;

	@Reference
	private TrainingSitesMasterLocalService trainingSitesMasterLocalService;

	@Reference
	private ProgramMasterLocalService programMasterLocalService;

	@Reference
	private ProgdurationRotationTraineelevelBlocksRelLocalService progdurationRotationTraineelevelBlocksRelLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbTrainingSitesTaskExecutor.class);

}
