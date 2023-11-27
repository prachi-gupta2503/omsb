package gov.omsb.master.rotation.schedule.web.portlet.mvccommands;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.dto.RoleMapping;
import gov.omsb.common.dto.UserMetadata;
import gov.omsb.common.service.util.RoleMappingUtil;
import gov.omsb.common.service.util.UserMetadataUtil;
import gov.omsb.master.rotation.schedule.web.constants.OmsbMasterRotationScheduleWebPortletKeys;
import gov.omsb.master.rotation.schedule.web.portlet.model.SaveRotationMasterRotationScheduleDTO;
import gov.omsb.master.rotation.schedule.web.portlet.model.SaveRotationMasterRotationScheduleDTO.RotationDetails;
import gov.omsb.master.rotation.schedule.web.util.OmsbMasterRotationScheduleUtil;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.custom.dto.RotationTraineeBlockRelationDTO;
import gov.omsb.tms.model.BlocksMetadataDetailsRel;
import gov.omsb.tms.model.LeaveMaster;
import gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel;
import gov.omsb.tms.model.RotationTypeMaster;
import gov.omsb.tms.model.TraineeAdmissionDetailsRel;
import gov.omsb.tms.model.TraineeCohortDetails;
import gov.omsb.tms.model.TraineeRotationTsBlockDetailsRel;
import gov.omsb.tms.service.BlocksMetadataDetailsRelLocalService;
import gov.omsb.tms.service.LeaveMasterLocalService;
import gov.omsb.tms.service.ProgdurationRotationTraineelevelBlocksRelLocalService;
import gov.omsb.tms.service.ProgdurationTraineelevelBlocksLevelTypeRelLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;
import gov.omsb.tms.service.RotationTypeMasterLocalService;
import gov.omsb.tms.service.TraineeAdmissionDetailsRelLocalService;
import gov.omsb.tms.service.TraineeCohortDetailsLocalService;
import gov.omsb.tms.service.TraineeLevelMasterLocalService;
import gov.omsb.tms.service.TraineeRotationTsBlockDetailsRelLocalService;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbMasterRotationScheduleWebPortletKeys.OMSBMASTERROTATIONSCHEDULEWEB,
		"mvc.command.name="
				+ OmsbMasterRotationScheduleWebPortletKeys.SAVE_ROTATION_MASTER_ROTATION_SCHEDULE_MVC_RESOURCE_COMMAND }, service = MVCResourceCommand.class)
public class OmsbSaveRotationMasterRotationScheduleMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		_logger.info("ServeResource Invoked ::: ");

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		boolean isDraft = ParamUtil.getBoolean(resourceRequest, OmsbTmsCommonConstants.IS_DRAFT);
		long progdurationTlBlocksLtId = ParamUtil.get(resourceRequest,
				OmsbMasterRotationScheduleWebPortletKeys.PROGDURATIONTLBLOCKSLTID, 0);
		long programMasterId = ParamUtil.get(resourceRequest,
				OmsbMasterRotationScheduleWebPortletKeys.PROGRAM_MASTER_ID, 0);

		ProgdurationTraineelevelBlocksLevelTypeRel rotationTsBlockDetailsReldata = progdurationTraineelevelBlocksLevelTypeRelLocalService
				.fetchProgdurationTraineelevelBlocksLevelTypeRel(progdurationTlBlocksLtId);
		List<RotationTraineeBlockRelationDTO> rotationTraineeBlockRelationDTOs = rotationTraineelevelBlocksRelLocalService
				.getTraineeNoofBlocks(rotationTsBlockDetailsReldata.getProgramDurationId(),
						rotationTsBlockDetailsReldata.getTraineeLevelId(), themeDisplay.getLocale().toString());

		List<TraineeRotationTsBlockDetailsRel> traineeRotationTsBlockDetailsRels = extracted(progdurationTlBlocksLtId);
		String status = "DRAFT";
		if (!traineeRotationTsBlockDetailsRels.isEmpty()) {
			status = traineeRotationTsBlockDetailsRels.get(0).getStatus();
		}
		List<Long> traineeDataIds = traineeRotationTsBlockDetailsRels.stream().distinct()
				.map(TraineeRotationTsBlockDetailsRel::getTraineeId).collect(Collectors.toList());
		List<Long> ids = traineeRotationTsBlockDetailsRels.stream()
				.map(TraineeRotationTsBlockDetailsRel::getTraineeRotationTsBlockDetailsRelId)
				.collect(Collectors.toList());

		String jsonRotationMasterRotationString = ParamUtil.getString(resourceRequest,
				"rotationMasterRotationScheduleData");
		List<SaveRotationMasterRotationScheduleDTO> rotationMasterRotationScheduleList = parseJson(
				jsonRotationMasterRotationString);
		List<SaveRotationMasterRotationScheduleDTO> rotationMasterRotationScheduleOldList = filterData(
				progdurationTlBlocksLtId, traineeDataIds, traineeRotationTsBlockDetailsRels);
		_logger.debug("rotationMasterRotationScheduleList size = " + rotationMasterRotationScheduleList.size());
		boolean isValidate = true;
		if (!isDraft) {
			isValidate = validateData(rotationMasterRotationScheduleList, progdurationTlBlocksLtId,
					rotationTraineeBlockRelationDTOs,themeDisplay);
		}

		for (SaveRotationMasterRotationScheduleDTO saveRotationMasterRotationScheduleDTO : rotationMasterRotationScheduleList) {
			boolean draft = true;
			if (!isDraft && isValidate) {
				draft = false;
			}
			createTraineeRotationTsBlockDetails(saveRotationMasterRotationScheduleDTO, ids, themeDisplay, draft);
		}

		for (long rotationTsBlockDetailsRel : ids) {
			traineeRotationTsBlockDetailsRelLocalService
					.deleteTraineeRotationTsBlockDetailsRel(rotationTsBlockDetailsRel);
		}
		Boolean isSucess = true;
		if (!isDraft && isValidate) {

			String programName = programMasterLocalService.getProgramMaster(programMasterId).getProgramName(themeDisplay.getLocale());
			ProgdurationTraineelevelBlocksLevelTypeRel traineelevelBlocksLevelTypeRel = progdurationTraineelevelBlocksLevelTypeRelLocalService
					.fetchProgdurationTraineelevelBlocksLevelTypeRel(progdurationTlBlocksLtId);
			String traineeLevel = traineeLevelMasterLocalService
					.fetchTraineeLevelMaster(traineelevelBlocksLevelTypeRel.getTraineeLevelId())
					.getTraineeLevelName(themeDisplay.getLocale().toString());

			String renderURL = omsbMasterRotationScheduleUtil.createScheduleMasterRotationRenderUrl(themeDisplay, resourceRequest, programMasterId, progdurationTlBlocksLtId);
			_logger.debug("renderURL" + renderURL);

			List<Long> traineeIds;
			if (status.equalsIgnoreCase("COMPLETED")) {
				traineeIds = fetchTraineeDetails(rotationMasterRotationScheduleOldList,
						rotationMasterRotationScheduleList);
			} else {
				traineeIds = extracted(progdurationTlBlocksLtId).stream()
						.map(TraineeRotationTsBlockDetailsRel::getTraineeId).collect(Collectors.toList());

			}
			
			Role paRole = roleLocalService.getRole(PortalUtil.getDefaultCompanyId(), OmsbTmsCommonConstants.PA_ROLE);

			List<UserMetadata> userMetadataList = userMetadataUtil
					.getUserMetadataItemsByProgramIdAndRoleId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(),
							programMasterId, paRole.getRoleId())
					.getItems();
			List<Long> userIds = userMetadataList.stream().map(e -> e.getLrUserId()).collect(Collectors.toList());

			List<Long> ecMemberIds = fetchEcMemberList(themeDisplay, programMasterId);
			
			scheduleEmailAndNotification(traineeIds, themeDisplay.getUser(), renderURL, programName, traineeLevel,
					userIds, ecMemberIds);

		}
		if (!isDraft && !isValidate) {
			isSucess = false;
		}
		_logger.info("ServeResource Invoked ::: ");
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		String json = mapper.writeValueAsString(isSucess);
		resourceResponse.getWriter().write(json);

	}

	private List<SaveRotationMasterRotationScheduleDTO> filterData(long progdurationTlBlocksLtId, List<Long> traineeIds,
			List<TraineeRotationTsBlockDetailsRel> traineeRotationTsBlockDetailsRels) {
		List<SaveRotationMasterRotationScheduleDTO> rotationMasterRotationScheduleDTOs = new ArrayList<>();
		List<BlocksMetadataDetailsRel> blocksMetadataDetailsRels = metadataDetailsRelLocalService
				.findByProgDurationTlBlocksLtId(progdurationTlBlocksLtId);
		for (Long traineeId : traineeIds) {
			for (BlocksMetadataDetailsRel metadataDetailsRel : blocksMetadataDetailsRels) {

				List<TraineeRotationTsBlockDetailsRel> traineeRotBlockDetailsRels = traineeRotationTsBlockDetailsRels
						.stream()
						.filter(traineeRotation -> traineeRotation.getTraineeId() == traineeId && traineeRotation
								.getBlocksMetadataDetailsRelId() == metadataDetailsRel.getBlocksMetadataDetailsRelId())
						.collect(Collectors.toList());
				SaveRotationMasterRotationScheduleDTO saveRotationMasterRotationScheduleDTO = new SaveRotationMasterRotationScheduleDTO();
				saveRotationMasterRotationScheduleDTO.setBlockId(metadataDetailsRel.getBlocksMetadataDetailsRelId());
				saveRotationMasterRotationScheduleDTO.setTraineeId(traineeId);
				List<RotationDetails> rotationDetails = new ArrayList<>();
				for (TraineeRotationTsBlockDetailsRel traineeRotationTsBlockDetailsRel : traineeRotBlockDetailsRels) {
					RotationDetails details = new RotationDetails();
					details.setRotationId(traineeRotationTsBlockDetailsRel.getProgDurationRotationTsRelId());
					rotationDetails.add(details);
				}
				saveRotationMasterRotationScheduleDTO.setRotationDetails(rotationDetails);
				rotationMasterRotationScheduleDTOs.add(saveRotationMasterRotationScheduleDTO);
			}
		}
		return rotationMasterRotationScheduleDTOs;
	}

	private List<Long> fetchTraineeDetails(
			List<SaveRotationMasterRotationScheduleDTO> rotationMasterRotationScheduleOldList,
			List<SaveRotationMasterRotationScheduleDTO> rotationMasterRotationScheduleList) {
		Set<Long> traineeIds = new HashSet<>();
		for (SaveRotationMasterRotationScheduleDTO saveRotationMasterRotationScheduleDTO : rotationMasterRotationScheduleList) {
			List<Long> rotationNewIds = saveRotationMasterRotationScheduleDTO.getRotationDetails().stream()
					.map(RotationDetails::getRotationId).collect(Collectors.toList());
			List<Long> rotationNewIdsBackup = new ArrayList<>();
			rotationNewIdsBackup.addAll(rotationNewIds);
			List<SaveRotationMasterRotationScheduleDTO> masterRotationScheduleDTOs = rotationMasterRotationScheduleOldList
					.stream()
					.filter(obj -> obj.getTraineeId() == saveRotationMasterRotationScheduleDTO.getTraineeId()
							&& obj.getBlockId() == saveRotationMasterRotationScheduleDTO.getBlockId())
					.collect(Collectors.toList());
			List<Long> rotationoldIds = new ArrayList<>();
			for (SaveRotationMasterRotationScheduleDTO masterRotationScheduleDTO : masterRotationScheduleDTOs) {
				rotationoldIds = masterRotationScheduleDTO.getRotationDetails().stream()
						.map(RotationDetails::getRotationId).collect(Collectors.toList());
			}
			rotationNewIds.removeAll(rotationoldIds);
			rotationoldIds.removeAll(rotationNewIdsBackup);
			if (!rotationNewIds.isEmpty() || !rotationoldIds.isEmpty() || masterRotationScheduleDTOs.isEmpty()) {
				traineeIds.add(saveRotationMasterRotationScheduleDTO.getTraineeId());
			}
		}
		return new ArrayList<>(traineeIds);
	}

	private boolean validateData(List<SaveRotationMasterRotationScheduleDTO> rotationMasterRotationScheduleList,
			long progdurationTlBlocksLtId, List<RotationTraineeBlockRelationDTO> rotationTraineeBlockRelationDTOs, ThemeDisplay themeDisplay) {
		boolean isValidate = true;
		List<BlocksMetadataDetailsRel> blocksMetadataDetailsRels = metadataDetailsRelLocalService
				.findByProgDurationTlBlocksLtId(progdurationTlBlocksLtId);
		Map<Long, List<Long>> trainee = setTraineeDetails(rotationMasterRotationScheduleList);
		Map<Long, List<Long>> rotationData = setRotationDetails(rotationMasterRotationScheduleList);
		for (Map.Entry<Long, List<Long>> data : trainee.entrySet()) {
			long traineeId = data.getKey();
			List<Long> blockId = data.getValue();
			List<LeaveMaster> leaveMasters = leaveMasterLocalService.findLeaveDetailsByTraineeId(traineeId);
			int count = 0;
			for (LeaveMaster leaveMaster : leaveMasters) {
				Date leaveFrom = leaveMaster.getLeaveFrom();
				Date leaveTo = leaveMaster.getLeaveTo();
				for (BlocksMetadataDetailsRel blocksMetadataDetailsRel : blocksMetadataDetailsRels) {
					Date blockStartDate = blocksMetadataDetailsRel.getBlockStartDate();
					Date blockEndDate = blocksMetadataDetailsRel.getBlockEndDate();
					if (leaveFrom.equals(blockStartDate) && leaveTo.equals(blockEndDate)) {
						count++;
					}
				}
			}
			if (blocksMetadataDetailsRels.size() != blockId.size() + count) {
				isValidate = false;
			}
		}
		List<RotationTypeMaster> rotationTypeMasters=rotationTypeMasterLocalService.getRotationTypeMasters(-1, -1);
		List<Long> rotationTypeId = rotationTypeMasters.stream().filter(obj -> obj.getRotationTypeName(themeDisplay.getLocale()).equalsIgnoreCase("core"))
				.map(RotationTypeMaster::getRotationTypeMasterId).collect(Collectors.toList());
		long rotationTypeMasterId = rotationTypeId.get(0);
		isValidate = validateNumberOfBlocks(rotationTraineeBlockRelationDTOs, isValidate, rotationData,
				rotationTypeMasterId);
		return isValidate;
	}

	/**
	 * @param rotationTraineeBlockRelationDTOs
	 * @param isValidate
	 * @param rotationData
	 * @param rotationTypeMasterId
	 * @return
	 */
	public boolean validateNumberOfBlocks(List<RotationTraineeBlockRelationDTO> rotationTraineeBlockRelationDTOs,
			boolean isValidate, Map<Long, List<Long>> rotationData, long rotationTypeMasterId) {
		List<RotationTraineeBlockRelationDTO> blockRelationDTOs = rotationTraineeBlockRelationDTOs.stream()
				.filter(obj -> obj.getRotationTypeId() == rotationTypeMasterId && obj.getNoOfBlocks() != 0).collect(Collectors.toList());
		for (RotationTraineeBlockRelationDTO rotationTraineeBlockRelationDTO : blockRelationDTOs) {
			for (Map.Entry<Long, List<Long>> data : rotationData.entrySet()) {
				List<Long> rotation = data.getValue();
				List<Long> rotationcount = rotation.stream()
						.filter(obj -> obj == rotationTraineeBlockRelationDTO.getRotationId())
						.collect(Collectors.toList());
				if (rotationTraineeBlockRelationDTO.getNoOfBlocks() != rotationcount.size()) {
					isValidate = false;
				}
			}
		}
		return isValidate;
	}

	/**
	 * @param rotationMasterRotationScheduleList
	 * @return
	 */
	public Map<Long, List<Long>> setTraineeDetails(
			List<SaveRotationMasterRotationScheduleDTO> rotationMasterRotationScheduleList) {
		Map<Long, List<Long>> trainee = new HashMap<>();
		for (SaveRotationMasterRotationScheduleDTO dto : rotationMasterRotationScheduleList) {
			if (trainee.containsKey(dto.getTraineeId())) {
				List<Long> blocks = trainee.get(dto.getTraineeId());
				blocks.add(dto.getBlockId());
				trainee.replace(dto.getTraineeId(), blocks);
			} else {
				List<Long> block = new ArrayList<>();
				block.add(dto.getBlockId());
				trainee.replace(dto.getTraineeId(), block);
			}
		}
		return trainee;
	}

	/**
	 * @param rotationMasterRotationScheduleList
	 * @return
	 */
	public Map<Long, List<Long>> setRotationDetails(
			List<SaveRotationMasterRotationScheduleDTO> rotationMasterRotationScheduleList) {
		Map<Long, List<Long>> rotationData = new HashMap<>();
		for (SaveRotationMasterRotationScheduleDTO dto : rotationMasterRotationScheduleList) {
			for (RotationDetails rotationDetails : dto.getRotationDetails()) {
				if (rotationData.containsKey(dto.getTraineeId())) {
					List<Long> rotations = rotationData.get(dto.getTraineeId());
					rotations.add(rotationDetails.getRotationMasterId());
					rotationData.replace(dto.getTraineeId(), rotations);
				} else {
					List<Long> rotation = new ArrayList<>();
					rotation.add(rotationDetails.getRotationMasterId());
					rotationData.replace(dto.getTraineeId(), rotation);
				}
			}
		}
		return rotationData;
	}

	private void scheduleEmailAndNotification(List<Long> traineeIds, User fromUser, String renderURL,
			String programName, String traineeLevel, List<Long> userIds, List<Long> ecMemberIds) {
		
		removeDuplicateValue(userIds);
		removeDuplicateValue(traineeIds);
		removeDuplicateValue(ecMemberIds);

		for (Long traineeId : traineeIds) {
			User toUser = userLocalService.fetchUser(traineeId);

			omsbMasterRotationScheduleUtil.prepareMailForTraineeMessage(programName, traineeLevel, fromUser, toUser,
					null);
			omsbMasterRotationScheduleUtil.prepareNotificationForTraineeMessage(programName, traineeLevel, fromUser, toUser,
					null);
		}

		for (Long userId : userIds) {
			User toUser = userLocalService.fetchUser(userId);

			_logger.debug("notification send to PA");

			omsbMasterRotationScheduleUtil.prepareMailForPaUserMessage(programName, traineeLevel, fromUser, toUser,
					renderURL);
			omsbMasterRotationScheduleUtil.prepareNotificationForPaUserMessage(programName, traineeLevel, fromUser, toUser,
					renderURL);
		}

		for (Long userId : ecMemberIds) {
			User toUser = userLocalService.fetchUser(userId);

			_logger.debug("notification send to EC Member");

			omsbMasterRotationScheduleUtil.prepareMailForEcMemberMessage(programName, traineeLevel, fromUser, toUser,
					null);
			omsbMasterRotationScheduleUtil.prepareNotificationForEcMemberMessage(programName, traineeLevel, fromUser, toUser,
					null);
		}
	}

	private void removeDuplicateValue(List<Long> ids) {
		Set<Long> set = new HashSet<>(ids.size());
		ids.removeIf(p -> !set.add(p));		
	}

	private void createTraineeRotationTsBlockDetails(
			SaveRotationMasterRotationScheduleDTO saveRotationMasterRotationScheduleDTO, List<Long> ids,
			ThemeDisplay themeDisplay, boolean isDraft) {
		for (RotationDetails rotationDetails : saveRotationMasterRotationScheduleDTO.getRotationDetails()) {
			if (!rotationDetails.getRotationName().equalsIgnoreCase("LEAVE")) {
				setTraineeRotationTsDetails(saveRotationMasterRotationScheduleDTO, ids, themeDisplay, isDraft,
						rotationDetails);
			}
		}
	}

	/**
	 * @param saveRotationMasterRotationScheduleDTO
	 * @param ids
	 * @param themeDisplay
	 * @param isDraft
	 * @param rotationDetails
	 */
	public void setTraineeRotationTsDetails(SaveRotationMasterRotationScheduleDTO saveRotationMasterRotationScheduleDTO,
			List<Long> ids, ThemeDisplay themeDisplay, boolean isDraft, RotationDetails rotationDetails) {
		long masterId;
		TraineeRotationTsBlockDetailsRel blockDetailsRel;
		if (ids.isEmpty()) {
			masterId = counterLocalService.increment(getClass().getName(), 1);
			blockDetailsRel = traineeRotationTsBlockDetailsRelLocalService
					.createTraineeRotationTsBlockDetailsRel(masterId);
		} else {
			masterId = ids.get(0);
			blockDetailsRel = traineeRotationTsBlockDetailsRelLocalService
					.fetchTraineeRotationTsBlockDetailsRel(masterId);
		}
		blockDetailsRel.setCompanyId(themeDisplay.getCompanyId());
		blockDetailsRel.setGroupId(themeDisplay.getScopeGroupId());
		blockDetailsRel.setCreatedBy(themeDisplay.getUserId());
		blockDetailsRel.setModifiedBy(themeDisplay.getUserId());
		blockDetailsRel.setTraineeId(saveRotationMasterRotationScheduleDTO.getTraineeId());
		blockDetailsRel.setBlocksMetadataDetailsRelId(saveRotationMasterRotationScheduleDTO.getBlockId());
		blockDetailsRel.setProgDurationRotationTsRelId(rotationDetails.getRotationId());
		if (isDraft) {
			blockDetailsRel.setStatus("DRAFT");
		} else {
			blockDetailsRel.setStatus("COMPLETED");
		}
		TraineeAdmissionDetailsRel admissionDetailsRel = admissionDetailsRelLocalService.findByTraineeId(saveRotationMasterRotationScheduleDTO.getTraineeId());
		if(Validator.isNotNull(admissionDetailsRel)) {
			TraineeCohortDetails traineeCohortDetails = cohortDetailsLocalService.findByTraineeAdmissionDetailsRelIdAndIsCurrentTraineeLevel(admissionDetailsRel.getTraineeAdmissionDetailsRelId());
			if(Validator.isNotNull(traineeCohortDetails)) {
				blockDetailsRel.setTraineeCohortDetailsId(traineeCohortDetails.getTraineeCohortDetailsId());
			}
		}
		if (Validator.isNotNull(ids)) {
			traineeRotationTsBlockDetailsRelLocalService
					.updateTraineeRotationTsBlockDetailsRel(blockDetailsRel);
			ids.remove(masterId);
		} else {
			traineeRotationTsBlockDetailsRelLocalService.addTraineeRotationTsBlockDetailsRel(blockDetailsRel);
		}
	}

	private List<TraineeRotationTsBlockDetailsRel> extracted(long progdurationTlBlocksLtId) {
		List<BlocksMetadataDetailsRel> blocksMetadataDetailsRels = metadataDetailsRelLocalService
				.findByProgDurationTlBlocksLtId(progdurationTlBlocksLtId);

		List<Long> blockIds = blocksMetadataDetailsRels.stream()
				.map(BlocksMetadataDetailsRel::getBlocksMetadataDetailsRelId).collect(Collectors.toList());

		DynamicQuery query = traineeRotationTsBlockDetailsRelLocalService.dynamicQuery();
		query.add(PropertyFactoryUtil.forName("blocksMetadataDetailsRelId").in(blockIds));
		return traineeRotationTsBlockDetailsRelLocalService.dynamicQuery(query);
	}

	private List<SaveRotationMasterRotationScheduleDTO> parseJson(String jsonString) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.readValue(jsonString, new TypeReference<List<SaveRotationMasterRotationScheduleDTO>>() {
			});
		} catch (JsonProcessingException e) {
			_logger.error(e);
			return Collections.emptyList();
		}
	}
	
	public List<Long> fetchEcMemberList(ThemeDisplay themeDisplay, long programMasterId) {
		String roleTypeName = OmsbMasterRotationScheduleWebPortletKeys.EC_MEMBER_ROLE;
		List<RoleMapping> roleIdList = roleMappingUtil
				.getRoleIdsByRoleType(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), roleTypeName)
				.getItems();

		List<Long> roleIds = roleIdList.stream().map(e -> e.getRoleId()).collect(Collectors.toList());
		List<Long> ecUserIds = new ArrayList<>();
		for (Long roleId : roleIds) {
			List<User> user = userLocalService.getRoleUsers(roleId);
			for (User users : user) {
				ecUserIds.add(users.getUserId());
			}
		}
		List<Long> ecMemberList = new ArrayList<>();
		List<UserMetadata> userMetadataList = userMetadataUtil.getUserMetadataItemsByProgramId(
				themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), programMasterId).getItems();

		List<Long> userIds = userMetadataList.stream().map(e -> e.getLrUserId()).collect(Collectors.toList());

		for (Long ids : ecUserIds) {
			if (userIds.contains(ids)) {
				ecMemberList.add(ids);
			}
		}
		return ecMemberList;
	}
	
	@Reference
	private OmsbMasterRotationScheduleUtil omsbMasterRotationScheduleUtil;
	
	@Reference
	private RoleMappingUtil roleMappingUtil;
	
	@Reference
	private RotationTypeMasterLocalService rotationTypeMasterLocalService;

	@Reference
	private ProgdurationRotationTraineelevelBlocksRelLocalService rotationTraineelevelBlocksRelLocalService;

	@Reference
	private LeaveMasterLocalService leaveMasterLocalService;

	@Reference
	private UserLocalService userLocalService;

	@Reference
	private TraineeLevelMasterLocalService traineeLevelMasterLocalService;

	@Reference
	private ProgdurationTraineelevelBlocksLevelTypeRelLocalService progdurationTraineelevelBlocksLevelTypeRelLocalService;

	@Reference
	private ProgramMasterLocalService programMasterLocalService;

	@Reference
	private BlocksMetadataDetailsRelLocalService metadataDetailsRelLocalService;

	@Reference
	private TraineeRotationTsBlockDetailsRelLocalService traineeRotationTsBlockDetailsRelLocalService;

	@Reference
	private CounterLocalService counterLocalService;

	@Reference
	private RoleLocalService roleLocalService;

	@Reference
	private UserMetadataUtil userMetadataUtil;
	
	@Reference
	private TraineeAdmissionDetailsRelLocalService admissionDetailsRelLocalService;
	
	@Reference 
	private TraineeCohortDetailsLocalService cohortDetailsLocalService;

	private static final Log _logger = LogFactoryUtil
			.getLog(OmsbSaveRotationMasterRotationScheduleMVCResourceCommand.class);

}
