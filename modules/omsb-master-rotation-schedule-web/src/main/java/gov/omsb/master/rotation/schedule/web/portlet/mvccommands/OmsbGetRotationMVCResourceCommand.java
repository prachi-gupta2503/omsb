package gov.omsb.master.rotation.schedule.web.portlet.mvccommands;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.liferay.portal.kernel.dao.orm.Conjunction;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.service.util.UserMetadataUtil;
import gov.omsb.master.rotation.schedule.web.constants.OmsbMasterRotationScheduleWebPortletKeys;
import gov.omsb.master.rotation.schedule.web.portlet.dto.ProgdurationRotationTrainingsitesRelDTO;
import gov.omsb.master.rotation.schedule.web.portlet.dto.TraineeElectiveRotationDTO;
import gov.omsb.master.rotation.schedule.web.portlet.dto.TraineeLeaveDetailsWithBlocksDTO;
import gov.omsb.master.rotation.schedule.web.portlet.dto.TraineeRotationTsBlockDetailsRelByRotationDTO;
import gov.omsb.master.rotation.schedule.web.portlet.dto.TrainingSiteByRotationsDeatilsDTO;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.custom.dto.RotationTraineeBlockRelationDTO;
import gov.omsb.tms.custom.dto.TraineeDetailsWithBlocksDTO;
import gov.omsb.tms.custom.dto.TrainingSiteByRotationsDTO;
import gov.omsb.tms.model.BlocksMetadataDetailsRel;
import gov.omsb.tms.model.LeaveMaster;
import gov.omsb.tms.model.LeaveTypes;
import gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel;
import gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel;
import gov.omsb.tms.model.TraineeElectiverotationPriorityDetails;
import gov.omsb.tms.model.TraineeProgdurationTraineelevelDetails;
import gov.omsb.tms.model.TraineeRotationTsBlockDetailsRel;
import gov.omsb.tms.service.BlocksMetadataDetailsRelLocalService;
import gov.omsb.tms.service.LeaveMasterLocalService;
import gov.omsb.tms.service.LeaveTypesLocalService;
import gov.omsb.tms.service.ProgdurationRotationTraineelevelBlocksRelLocalService;
import gov.omsb.tms.service.ProgdurationRotationTrainingsitesRelLocalService;
import gov.omsb.tms.service.ProgdurationTraineelevelBlocksLevelTypeRelLocalService;
import gov.omsb.tms.service.TraineeAdmissionDetailsRelLocalService;
import gov.omsb.tms.service.TraineeElectiverotationPriorityDetailsLocalService;
import gov.omsb.tms.service.TraineeProgdurationTraineelevelDetailsLocalService;
import gov.omsb.tms.service.TraineeRotationTsBlockDetailsRelLocalService;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbMasterRotationScheduleWebPortletKeys.OMSBMASTERROTATIONSCHEDULEWEB,
		"mvc.command.name="
				+ OmsbMasterRotationScheduleWebPortletKeys.GET_ROTATION_MVC_RESOURCE_COMMAND }, service = MVCResourceCommand.class)
public class OmsbGetRotationMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		_logger.info("ServeResource Invoked ::: ");

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long programMasterId = ParamUtil.getLong(resourceRequest, OmsbTmsCommonConstants.PROGRAM_MASTER_ID, 1);
		long progDurationTlBlocksLtId = ParamUtil.getLong(resourceRequest,
				OmsbTmsCommonConstants.PROGDURATION_TLBLOCKS_LT_ID, 1);
		ProgdurationTraineelevelBlocksLevelTypeRel rotationTsBlockDetailsReldata = progdurationTraineelevelBlocksLevelTypeRelLocalService
				.fetchProgdurationTraineelevelBlocksLevelTypeRel(progDurationTlBlocksLtId);
		_logger.debug("program duration id"+rotationTsBlockDetailsReldata.getProgramDurationId());
		_logger.debug("trainee level id"+rotationTsBlockDetailsReldata.getTraineeLevelId());

		List<Long> userIds = traineeAdmissionDetailsRelLocalService.getTraineeByProgramCohortAndTraineeLevel(rotationTsBlockDetailsReldata.getProgramDurationId(), rotationTsBlockDetailsReldata.getTraineeLevelId());
		_logger.debug("traineelist"+userIds.toString());
		List<Long> programIdList = Collections.singletonList(programMasterId);
	
		List<TrainingSiteByRotationsDTO> siteByRotationsDTOs = traineeRotationTsBlockDetailsRelLocalService
				.getTrainingSiteByRotation(programIdList, themeDisplay.getLocale().toString(),rotationTsBlockDetailsReldata.getProgramDurationId());
		
		List<RotationTraineeBlockRelationDTO> rotationTraineeBlockRelationDTOs = rotationTraineelevelBlocksRelLocalService
				.getTraineeNoofBlocks(rotationTsBlockDetailsReldata.getProgramDurationId(),
						rotationTsBlockDetailsReldata.getTraineeLevelId(), themeDisplay.getLocale().toString());

		List<Long> rotationIds = rotationTraineeBlockRelationDTOs.stream().filter(obj -> obj.getNoOfBlocks() != 0)
				.map(RotationTraineeBlockRelationDTO::getRotationId).collect(Collectors.toList());

		siteByRotationsDTOs = siteByRotationsDTOs.stream().filter(obj -> rotationIds.contains(obj.getRotationId()))
				.collect(Collectors.toList());
		List<BlocksMetadataDetailsRel> blocksMetadataDetailsRels = metadataDetailsRelLocalService
				.findByProgDurationTlBlocksLtId(progDurationTlBlocksLtId);
		_logger.debug("siteByRotationsDTOs" + siteByRotationsDTOs.toString());

		List<TraineeDetailsWithBlocksDTO> traineeDetailsWithBlocksDTOs = fetchLeaveDetailsByTrainee(userIds,
				blocksMetadataDetailsRels);
		List<TraineeLeaveDetailsWithBlocksDTO> leaveDetailsWithBlocksDTOs = fetchLeaveDetailsByTraineeBlock(userIds,
				blocksMetadataDetailsRels);
		_logger.debug("leaveDetailsWithBlocksDTOs" + leaveDetailsWithBlocksDTOs.toString());
		List<Long> trainneIds = traineeDetailsWithBlocksDTOs.stream().map(TraineeDetailsWithBlocksDTO::getTraineeId)
				.collect(Collectors.toList());
		DynamicQuery query = traineeRotationTsBlockDetailsRelLocalService.dynamicQuery();
		query.add(PropertyFactoryUtil.forName(OmsbMasterRotationScheduleWebPortletKeys.TRINEE_ID).in(trainneIds));
		List<TraineeRotationTsBlockDetailsRel> traineeRotationTsBlockDetailsRels = traineeRotationTsBlockDetailsRelLocalService
				.dynamicQuery(query);
		
		
		DynamicQuery traineeProgdurationTraineelevelDetailsQuery = traineeProgdurationTraineelevelDetailsLocalService.dynamicQuery();
		Conjunction conjunction = RestrictionsFactoryUtil.conjunction();
		conjunction.add(PropertyFactoryUtil.forName(OmsbMasterRotationScheduleWebPortletKeys.TRINEE_ID).in(userIds));
		conjunction.add(PropertyFactoryUtil.forName("programDurationId").eq(rotationTsBlockDetailsReldata.getProgramDurationId()));
		conjunction.add(PropertyFactoryUtil.forName("traineeLevelId").eq(rotationTsBlockDetailsReldata.getTraineeLevelId()));
		traineeProgdurationTraineelevelDetailsQuery.add(conjunction);
		List<TraineeProgdurationTraineelevelDetails> traineeProgdurationTraineelevelDetails = traineeProgdurationTraineelevelDetailsLocalService.dynamicQuery(traineeProgdurationTraineelevelDetailsQuery);
		
		List<TraineeRotationTsBlockDetailsRelByRotationDTO> detailsRelByRotationDTOs = new ArrayList<>();
		List<TraineeElectiveRotationDTO> traineeElectiveRotationDTOs = new ArrayList<>();
		for (Long userId : userIds) {
			List<Long> progdurationTraineelevelDetailsIds = traineeProgdurationTraineelevelDetails.stream().filter(obj -> obj.getTraineeId() == userId).map(TraineeProgdurationTraineelevelDetails::getTraineePdTlErDetailsId).collect(Collectors.toList());
			
			DynamicQuery traineeElectiverotationPriorityDetailsQuery = traineeElectiverotationPriorityDetailsLocalService.dynamicQuery();
			traineeElectiverotationPriorityDetailsQuery.add(PropertyFactoryUtil.forName("traineePdTlErDetailsId")
					.in(progdurationTraineelevelDetailsIds));
			List<TraineeElectiverotationPriorityDetails> traineeElectiverotationPriorityDetails = traineeElectiverotationPriorityDetailsLocalService.dynamicQuery(traineeElectiverotationPriorityDetailsQuery);
			
			for (TraineeElectiverotationPriorityDetails electiverotationPriorityDetails : traineeElectiverotationPriorityDetails) {
				TraineeElectiveRotationDTO traineeElectiveRotationDTO = new TraineeElectiveRotationDTO();
				traineeElectiveRotationDTO.setTraineeId(userId);
				traineeElectiveRotationDTO.setRotationId(electiverotationPriorityDetails.getRotationId());
				traineeElectiveRotationDTOs.add(traineeElectiveRotationDTO);
			}
			
			for (BlocksMetadataDetailsRel metadataDetailsRel : blocksMetadataDetailsRels) {
				TraineeRotationTsBlockDetailsRelByRotationDTO blockDetailsRelByRotationDTO = new TraineeRotationTsBlockDetailsRelByRotationDTO();
				List<TraineeLeaveDetailsWithBlocksDTO> detailsWithBlocksDTO = leaveDetailsWithBlocksDTOs.stream()
						.filter(obj -> obj.getBlockId() == metadataDetailsRel.getBlocksMetadataDetailsRelId())
						.collect(Collectors.toList());
				List<TraineeDetailsWithBlocksDTO> detailsWithBlocksDTOs = new ArrayList<>();
				for (TraineeLeaveDetailsWithBlocksDTO leaveDetailsWithBlocksDTO : detailsWithBlocksDTO) {
					detailsWithBlocksDTOs.addAll(leaveDetailsWithBlocksDTO.getDetailsWithBlocksDTOs().stream()
							.filter(obj -> obj.getTraineeId() == userId).collect(Collectors.toList()));
				}
				if(!detailsWithBlocksDTOs.isEmpty()) {
					blockDetailsRelByRotationDTO.setDetailsWithBlocksDTOs(detailsWithBlocksDTOs);
				}
				List<TraineeRotationTsBlockDetailsRel> traineeRotBlockDetailsRels = traineeRotationTsBlockDetailsRels
						.stream()
						.filter(traineeRotation -> traineeRotation.getTraineeId() == userId && traineeRotation
								.getBlocksMetadataDetailsRelId() == metadataDetailsRel.getBlocksMetadataDetailsRelId())
						.collect(Collectors.toList());
				if (!traineeRotBlockDetailsRels.isEmpty()) {
					List<Long> progDurationRotationTsRelIds = traineeRotBlockDetailsRels.stream()
							.map(TraineeRotationTsBlockDetailsRel::getProgDurationRotationTsRelId)
							.collect(Collectors.toList());
					DynamicQuery dynamicQuery = progdurationRotationTrainingsitesRelLocalService.dynamicQuery();
					dynamicQuery.add(PropertyFactoryUtil.forName("progdurationRotationTsRelId")
							.in(progDurationRotationTsRelIds));
					List<ProgdurationRotationTrainingsitesRel> progdurationRotationTrainingsitesRels = progdurationRotationTrainingsitesRelLocalService
							.dynamicQuery(dynamicQuery);
					List<ProgdurationRotationTrainingsitesRelDTO> progdurationRotationTrainingsitesRelsDto = mapperProgdurationRotationTrainingsitesRels(
							progdurationRotationTrainingsitesRels);

					blockDetailsRelByRotationDTO
							.setProgdurationRotationTrainingsitesRels(progdurationRotationTrainingsitesRelsDto);
				}
				detailsRelByRotationDTOs.add(blockDetailsRelByRotationDTO);
			}
		}
		
		_logger.debug("Rotation information is:" + rotationTraineeBlockRelationDTOs.toString());

		List<LeaveTypes> leaveType = leaveTypesLocalService.getLeaveTypeses(-1, -1);
		
		TrainingSiteByRotationsDeatilsDTO trainingSiteByRotationsDeatilsDTO = new TrainingSiteByRotationsDeatilsDTO();
		trainingSiteByRotationsDeatilsDTO.setTrainingSiteByRotationsDTOs(siteByRotationsDTOs);
		trainingSiteByRotationsDeatilsDTO.setBlocksMetadataDetailsRels(blocksMetadataDetailsRels);
		trainingSiteByRotationsDeatilsDTO.setTraineeDetailsWithBlocksDTOs(traineeDetailsWithBlocksDTOs);
		trainingSiteByRotationsDeatilsDTO.setTraineeRotationTsBlockDetailsRelByRotationDTOs(detailsRelByRotationDTOs);
		trainingSiteByRotationsDeatilsDTO.setRotationTraineeBlockRelationDTOs(rotationTraineeBlockRelationDTOs);
		trainingSiteByRotationsDeatilsDTO.setLeaveDetailsWithBlocksDTOs(leaveDetailsWithBlocksDTOs);
		trainingSiteByRotationsDeatilsDTO.setLeaveTypes(leaveType);
		trainingSiteByRotationsDeatilsDTO.setTraineeElectiveRotationDTOs(traineeElectiveRotationDTOs);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		String json = mapper.writeValueAsString(trainingSiteByRotationsDeatilsDTO);
		resourceResponse.getWriter().write(json);

		_logger.info("ServeResource Exit ::: ");

	}

	private List<ProgdurationRotationTrainingsitesRelDTO> mapperProgdurationRotationTrainingsitesRels(
			List<ProgdurationRotationTrainingsitesRel> progdurationRotationTrainingsitesRels) {
		List<ProgdurationRotationTrainingsitesRelDTO> progdurationRotationTrainingsitesRelDTOs = new ArrayList<>();

		for (ProgdurationRotationTrainingsitesRel rel : progdurationRotationTrainingsitesRels) {
			progdurationRotationTrainingsitesRelDTOs
					.add(new ProgdurationRotationTrainingsitesRelDTO(rel.getProgdurationRotationTsRelId(),
							rel.getRotationId(), rel.getTrainingSitesId(), rel.getIsSharedRotation(),
							rel.getRotationOwningProgramId(), rel.getProgCodeRsnSiteCode(), rel.getNoOfSlots()));
		}

		return progdurationRotationTrainingsitesRelDTOs;
	}

	public List<TraineeDetailsWithBlocksDTO> fetchLeaveDetailsByTrainee(List<Long> userIds,
			List<BlocksMetadataDetailsRel> blocksMetadataDetailsRels) throws PortalException {
		_logger.debug("fetchLeaveDetailsByTrainee ::: userIds ::: " + userIds.toString());

		List<TraineeDetailsWithBlocksDTO> traineeDetailsWithBlocksDTOs = new ArrayList<>();
		int totalBlocks = blocksMetadataDetailsRels.size();

		_logger.debug("fetchLeaveDetailsByTrainee ::: totalBlocks ::: " + totalBlocks);

		for (Long userId : userIds) {
			int blockNo = 0;
			int count = 0;
			TraineeDetailsWithBlocksDTO traineeDetailsWithBlocksDTO = new TraineeDetailsWithBlocksDTO();
			User user = userLocalService.fetchUser(userId);
			if (Validator.isNotNull(user)) {
				Map<String, Integer> paramMap = new HashMap<>();
				paramMap.put("blockNo", blockNo);
				paramMap.put("count", count);
				fetchLeaveDetails(blocksMetadataDetailsRels, traineeDetailsWithBlocksDTOs, totalBlocks, userId, paramMap, traineeDetailsWithBlocksDTO, user);
			}
		}
		return traineeDetailsWithBlocksDTOs;
	}

	/**
	 * @param blocksMetadataDetailsRels
	 * @param traineeDetailsWithBlocksDTOs
	 * @param totalBlocks
	 * @param userId
	 * @param paramMap
	 * @param traineeDetailsWithBlocksDTO
	 * @param user
	 * @throws PortalException
	 */
	public void fetchLeaveDetails(List<BlocksMetadataDetailsRel> blocksMetadataDetailsRels,
			List<TraineeDetailsWithBlocksDTO> traineeDetailsWithBlocksDTOs, int totalBlocks, Long userId, Map<String, Integer> paramMap, TraineeDetailsWithBlocksDTO traineeDetailsWithBlocksDTO, User user) throws PortalException {
		int count = paramMap.get("count");
		int blockNo = paramMap.get("blockNo");
		int availableBlocks = 0;
		int allocatedBlockSize = 0;
		_logger.debug("fetchLeaveDetailsByTrainee ::: User Found ::: " + user.getFullName());
		List<LeaveMaster> leaveMasters = leaveMasterLocalService.findLeaveDetailsByTraineeId(userId);

		_logger.debug("fetchLeaveDetailsByTrainee ::: Total Leaves ::: " + leaveMasters.size());

		for (LeaveMaster leaveMaster : leaveMasters) {
			count = 0;
			Date leaveFrom = leaveMaster.getLeaveFrom();
			Date leaveTo = leaveMaster.getLeaveTo();
			for (BlocksMetadataDetailsRel blocksMetadataDetailsRel : blocksMetadataDetailsRels) {
				Date blockStartDate = blocksMetadataDetailsRel.getBlockStartDate();
				Date blockEndDate = blocksMetadataDetailsRel.getBlockEndDate();
				_logger.debug("leaveFrom :: " + leaveFrom.toString() + " leaveTo :: " + leaveTo.toString()
						+ " blockStartDate :: " + blockStartDate.toString() + " blockEndDate :: "
						+ blockEndDate.toString());
				if (leaveFrom.compareTo(blockStartDate) == 0 && leaveTo.compareTo(blockEndDate) == 0) {
					_logger.debug(" DATE MATCHED ::: ");
					LeaveTypes leaveTypes = leaveTypesLocalService.getLeaveTypes(leaveMaster.getLeaveTypeId());
					traineeDetailsWithBlocksDTO.setLeaveMasterId(leaveMaster.getLeaveMasterId());
					traineeDetailsWithBlocksDTO.setLeaveTypeId(leaveMaster.getLeaveTypeId());
					traineeDetailsWithBlocksDTO.setLeaveType(leaveTypes.getLeaveCode());
					// Below Block is temporay to show ANL to AL for demo pupose, remove it once
					// demo over.
					setLeaveCode(traineeDetailsWithBlocksDTO, leaveTypes);
					blockNo = (int) blocksMetadataDetailsRel.getBlocksMetadataDetailsRelId();
					traineeDetailsWithBlocksDTO.setLeaveBlockName(blocksMetadataDetailsRel.getBlockNo());
					count++;
				}
			}
			traineeDetailsWithBlocksDTO.setLeaveBlocks(count);
			traineeDetailsWithBlocksDTO.setTotalBlocks(totalBlocks);
			traineeDetailsWithBlocksDTO.setLeaveBlocks(count);
		}

		DynamicQuery query = traineeRotationTsBlockDetailsRelLocalService.dynamicQuery();
		query.add(PropertyFactoryUtil.forName("traineeId").eq(userId));
		List<TraineeRotationTsBlockDetailsRel> traineeRotationTsBlockDetailsRels = traineeRotationTsBlockDetailsRelLocalService
				.dynamicQuery(query);
		allocatedBlockSize = traineeRotationTsBlockDetailsRels.size();
		availableBlocks = totalBlocks - count;
		traineeDetailsWithBlocksDTO.setAvailableBlocks(availableBlocks);
		int allocatedBlocks = availableBlocks - allocatedBlockSize;
		traineeDetailsWithBlocksDTO.setAllocatedBlocks(allocatedBlocks);
		traineeDetailsWithBlocksDTO.setLeaveBlockNo(blockNo);
		traineeDetailsWithBlocksDTO.setTraineeId(user.getUserId());
		traineeDetailsWithBlocksDTO.setTraineeName(user.getFullName());
		traineeDetailsWithBlocksDTOs.add(traineeDetailsWithBlocksDTO);
		_logger.debug("traineeDetailsWithBlocksDTOs ::: " + traineeDetailsWithBlocksDTOs.toString());
	}

	public List<TraineeLeaveDetailsWithBlocksDTO> fetchLeaveDetailsByTraineeBlock(List<Long> userIds,
			List<BlocksMetadataDetailsRel> blocksMetadataDetailsRels) throws PortalException {
		_logger.debug("fetchLeaveDetailsByTrainee ::: userIds ::: " + userIds.toString());
		List<TraineeLeaveDetailsWithBlocksDTO> traineeLeaveDetailsWithBlocksDTOs = new ArrayList<>();
		int totalBlocks = blocksMetadataDetailsRels.size();

		_logger.debug("fetchLeaveDetailsByTrainee ::: totalBlocks ::: " + totalBlocks);

		for (BlocksMetadataDetailsRel blocksMetadataDetailsRel : blocksMetadataDetailsRels) {
			int blockNo = 0;
			int availableBlocks = 0;
			int allocatedBlockSize = 0;
			int count = 0;
			TraineeLeaveDetailsWithBlocksDTO traineeLeaveDetailsWithBlocksDTO = new TraineeLeaveDetailsWithBlocksDTO();
			List<TraineeDetailsWithBlocksDTO> traineeDetailsWithBlocksDTOs = new ArrayList<>();
			Date blockStartDate = blocksMetadataDetailsRel.getBlockStartDate();
			Date blockEndDate = blocksMetadataDetailsRel.getBlockEndDate();
			// dynamic query for fetching leave data
			List<LeaveMaster> leaveMasters = leaveMasterLocalService.findLeaveDetailsByTraineeIdsWithStatus(userIds,
					blockStartDate, blockEndDate, 0);
			for (LeaveMaster leaveMaster : leaveMasters) {
				User user = userLocalService.fetchUser(leaveMaster.getTraineeId());
				TraineeDetailsWithBlocksDTO traineeDetailsWithBlocksDTO = new TraineeDetailsWithBlocksDTO();
				LeaveTypes leaveTypes = leaveTypesLocalService.getLeaveTypes(leaveMaster.getLeaveTypeId());
				traineeDetailsWithBlocksDTO.setLeaveMasterId(leaveMaster.getLeaveMasterId());
				traineeDetailsWithBlocksDTO.setLeaveTypeId(leaveMaster.getLeaveTypeId());
				traineeDetailsWithBlocksDTO.setLeaveType(leaveTypes.getLeaveCode());
				traineeDetailsWithBlocksDTO.setLeaveTypeName(leaveTypes.getLeaveTypes());
				// Below Block is temporay to show ANL to AL for demo pupose, remove it once
				// demo over.
				traineeDetailsWithBlocksDTO.setFromDate(leaveMaster.getLeaveFrom());
				traineeDetailsWithBlocksDTO.setToDate(leaveMaster.getLeaveTo());
				setLeaveCode(traineeDetailsWithBlocksDTO, leaveTypes);
				blockNo = (int) blocksMetadataDetailsRel.getBlocksMetadataDetailsRelId();
				traineeDetailsWithBlocksDTO.setLeaveBlockName(blocksMetadataDetailsRel.getBlockNo());
				traineeDetailsWithBlocksDTO.setLeaveBlocks(count);
				traineeDetailsWithBlocksDTO.setTotalBlocks(totalBlocks);
				traineeDetailsWithBlocksDTO.setLeaveBlocks(count);
				DynamicQuery query = traineeRotationTsBlockDetailsRelLocalService.dynamicQuery();
				query.add(PropertyFactoryUtil.forName("traineeId").eq(user.getUserId()));
				List<TraineeRotationTsBlockDetailsRel> traineeRotationTsBlockDetailsRels = traineeRotationTsBlockDetailsRelLocalService
						.dynamicQuery(query);
				allocatedBlockSize = traineeRotationTsBlockDetailsRels.size();
				availableBlocks = totalBlocks - count;
				traineeDetailsWithBlocksDTO.setAvailableBlocks(availableBlocks);
				int allocatedBlocks = availableBlocks - allocatedBlockSize;
				traineeDetailsWithBlocksDTO.setAllocatedBlocks(allocatedBlocks);
				traineeDetailsWithBlocksDTO.setLeaveBlockNo(blockNo);
				traineeDetailsWithBlocksDTO.setTraineeId(user.getUserId());
				traineeDetailsWithBlocksDTO.setTraineeName(user.getFullName());
				traineeDetailsWithBlocksDTOs.add(traineeDetailsWithBlocksDTO);
			}
			traineeLeaveDetailsWithBlocksDTO.setBlockName(blocksMetadataDetailsRel.getBlockNo());
			traineeLeaveDetailsWithBlocksDTO.setBlockId(blocksMetadataDetailsRel.getBlocksMetadataDetailsRelId());
			traineeLeaveDetailsWithBlocksDTO.setDetailsWithBlocksDTOs(traineeDetailsWithBlocksDTOs);
			traineeLeaveDetailsWithBlocksDTOs.add(traineeLeaveDetailsWithBlocksDTO);
		}
		return traineeLeaveDetailsWithBlocksDTOs;
	}

	private void setLeaveCode(TraineeDetailsWithBlocksDTO traineeDetailsWithBlocksDTO, LeaveTypes leaveTypes) {
		// Below Block is temporay to show ANL to AL for demo pupose, remove it once
		// demo over.
		String leaveCode = leaveTypes.getLeaveCode();
		if (leaveCode.equalsIgnoreCase("ANL"))
			leaveCode = "AL";
		traineeDetailsWithBlocksDTO.setLeaveType(leaveCode);

	}

	@Reference
	private ProgdurationRotationTraineelevelBlocksRelLocalService rotationTraineelevelBlocksRelLocalService;

	@Reference
	private RoleLocalService roleLocalService;

	@Reference
	private UserLocalService userLocalService;

	@Reference
	private UserMetadataUtil userMetadataUtil;

	@Reference
	private LeaveTypesLocalService leaveTypesLocalService;

	@Reference
	private LeaveMasterLocalService leaveMasterLocalService;

	@Reference
	private TraineeRotationTsBlockDetailsRelLocalService traineeRotationTsBlockDetailsRelLocalService;

	@Reference
	private BlocksMetadataDetailsRelLocalService metadataDetailsRelLocalService;

	@Reference
	private ProgdurationTraineelevelBlocksLevelTypeRelLocalService progdurationTraineelevelBlocksLevelTypeRelLocalService;

	@Reference
	private ProgdurationRotationTrainingsitesRelLocalService progdurationRotationTrainingsitesRelLocalService;
	
	@Reference
	private TraineeProgdurationTraineelevelDetailsLocalService traineeProgdurationTraineelevelDetailsLocalService;
	
	@Reference
	private TraineeElectiverotationPriorityDetailsLocalService traineeElectiverotationPriorityDetailsLocalService;
	
	@Reference
	private TraineeAdmissionDetailsRelLocalService traineeAdmissionDetailsRelLocalService; 

	private static final Log _logger = LogFactoryUtil.getLog(OmsbGetRotationMVCResourceCommand.class);

}
