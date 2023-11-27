package gov.omsb.master.rotation.schedule.web.portlet.mvccommands;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
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

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.dto.RoleMapping;
import gov.omsb.common.dto.UserMetadata;
import gov.omsb.common.service.util.RoleMappingUtil;
import gov.omsb.common.service.util.UserMetadataUtil;
import gov.omsb.master.rotation.schedule.web.constants.OmsbMasterRotationScheduleWebPortletKeys;
import gov.omsb.master.rotation.schedule.web.portlet.model.SaveFacultyMasterRotationScheduleDTO;
import gov.omsb.master.rotation.schedule.web.portlet.model.SaveFacultyMasterRotationScheduleDTO.FacultyDetail;
import gov.omsb.master.rotation.schedule.web.util.OmsbMasterRotationScheduleUtil;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.custom.dto.TrainingSiteByRotationsDTO;
import gov.omsb.tms.model.BlocksMetadataDetailsRel;
import gov.omsb.tms.model.FacultyRotationTsBlockDetailsRel;
import gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel;
import gov.omsb.tms.service.BlocksMetadataDetailsRelLocalService;
import gov.omsb.tms.service.FacultyRotationTsBlockDetailsRelLocalService;
import gov.omsb.tms.service.ProgdurationTraineelevelBlocksLevelTypeRelLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;
import gov.omsb.tms.service.TraineeLevelMasterLocalService;
import gov.omsb.tms.service.TraineeRotationTsBlockDetailsRelLocalService;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbMasterRotationScheduleWebPortletKeys.OMSBMASTERROTATIONSCHEDULEWEB,
		"mvc.command.name="
				+ OmsbMasterRotationScheduleWebPortletKeys.SAVE_FACULTY_MASTER_ROTATION_SCHEDULE_MVC_RESOURCE_COMMAND }, service = MVCResourceCommand.class)
public class OmsbSaveFacultyMasterRotationScheduleMVCResourceCommand extends BaseMVCResourceCommand {

	JSONObject resultJson = JSONFactoryUtil.createJSONObject();

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		_logger.info("ServeResource Invoked ::: ");

		resultJson.put(CommonConstants.SUCCESS, true);

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long progdurationTlBlocksLtId = ParamUtil.get(resourceRequest,
				OmsbMasterRotationScheduleWebPortletKeys.PROGDURATIONTLBLOCKSLTID, 0);
		long programMasterId = ParamUtil.get(resourceRequest,
				OmsbMasterRotationScheduleWebPortletKeys.PROGRAM_MASTER_ID, 0);
		List<Long> programIdList = Collections.singletonList(programMasterId);
		ProgdurationTraineelevelBlocksLevelTypeRel rotationTsBlockDetailsReldata = progdurationTraineelevelBlocksLevelTypeRelLocalService.fetchProgdurationTraineelevelBlocksLevelTypeRel(progdurationTlBlocksLtId);

		List<TrainingSiteByRotationsDTO> siteByRotationsDTOs = traineeRotationTsBlockDetailsRelLocalService
				.getTrainingSiteByRotation(programIdList, themeDisplay.getLocale().toString(),rotationTsBlockDetailsReldata.getProgramDurationId());
		List<BlocksMetadataDetailsRel> blocksMetadataDetailsRels = blocksMetadataDetailsRelLocalService
				.findByProgDurationTlBlocksLtId(progdurationTlBlocksLtId);

		String jsonFacultyMasterRotationString = ParamUtil.getString(resourceRequest,
				"facultyMasterRotationScheduleData");
		List<SaveFacultyMasterRotationScheduleDTO> facultyMasterRotationScheduleList = parseJson(
				jsonFacultyMasterRotationString);
		List<SaveFacultyMasterRotationScheduleDTO> facultyMasterRotationScheduleOldList = new ArrayList<>();
		for (TrainingSiteByRotationsDTO trainingSiteByRotationsDTO : siteByRotationsDTOs) {
			for (BlocksMetadataDetailsRel blocksMetadataDetailsRel : blocksMetadataDetailsRels) {
				SaveFacultyMasterRotationScheduleDTO facultyMasterRotationScheduleDTO = createFacultyMasterRotationScheduleDTO(
						blocksMetadataDetailsRel, trainingSiteByRotationsDTO);
				facultyMasterRotationScheduleOldList.add(facultyMasterRotationScheduleDTO);
			}
		}

		String status = "DRAFT";
		boolean isDraft = ParamUtil.getBoolean(resourceRequest, OmsbTmsCommonConstants.IS_DRAFT);
		boolean isValidate = ParamUtil.getBoolean(resourceRequest, OmsbMasterRotationScheduleWebPortletKeys.IS_VALIDATE,true);
		boolean validataData = true;
		if(!isDraft && !isValidate) {
			validataData = validateFacultyData(facultyMasterRotationScheduleList,blocksMetadataDetailsRels.size());
		}
		if (validataData) {
			Map<String, Long> detailsMap = new HashMap<>();
			detailsMap.put(OmsbMasterRotationScheduleWebPortletKeys.PROGDURATIONTLBLOCKSLTID, progdurationTlBlocksLtId);
			detailsMap.put(OmsbMasterRotationScheduleWebPortletKeys.PROGRAM_MASTER_ID, programMasterId);
			setFacultyDetailsAndSendNotification(resourceRequest, themeDisplay, detailsMap,
					facultyMasterRotationScheduleList, facultyMasterRotationScheduleOldList, status, isDraft);
		}else {
			resultJson.put(CommonConstants.SUCCESS, false);
		}
		JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, resultJson);
		_logger.info("ServeResource Exit ::: ");
	}

	/**
	 * @param resourceRequest
	 * @param themeDisplay
	 * @param detailsMap
	 * @param facultyMasterRotationScheduleList
	 * @param facultyMasterRotationScheduleOldList
	 * @param status
	 * @param isDraft
	 */
	public void setFacultyDetailsAndSendNotification(ResourceRequest resourceRequest, ThemeDisplay themeDisplay,
			Map<String, Long> detailsMap,
			List<SaveFacultyMasterRotationScheduleDTO> facultyMasterRotationScheduleList,
			List<SaveFacultyMasterRotationScheduleDTO> facultyMasterRotationScheduleOldList, String status,
			boolean isDraft) {
		long progdurationTlBlocksLtId = detailsMap.get(OmsbMasterRotationScheduleWebPortletKeys.PROGDURATIONTLBLOCKSLTID);
		long programMasterId =  detailsMap.get(OmsbMasterRotationScheduleWebPortletKeys.PROGRAM_MASTER_ID);
		List<FacultyRotationTsBlockDetailsRel> facultyRotationTsBlockDetailsRels = extracted(progdurationTlBlocksLtId);
		if (!facultyRotationTsBlockDetailsRels.isEmpty()) {
			status = facultyRotationTsBlockDetailsRels.get(0).getStatus();
		}

		_logger.debug("facultyMasterRotationScheduleList size = " + facultyMasterRotationScheduleList.size());
		List<Long> facultyIds = new ArrayList<>();
		for (SaveFacultyMasterRotationScheduleDTO saveFacultyMasterRotationScheduleDTO : facultyMasterRotationScheduleList) {
			deleteFacultyRotationTsBlockDetails(saveFacultyMasterRotationScheduleDTO.getBlockId(),
					saveFacultyMasterRotationScheduleDTO.getRotationId());
			if (!saveFacultyMasterRotationScheduleDTO.getFacultyDetails().isEmpty()) {
				for (FacultyDetail facultyDetail : saveFacultyMasterRotationScheduleDTO.getFacultyDetails()) {
					facultyIds.add(facultyDetail.getFacultyId());
					createFacultyRotationTsBlockDetails(saveFacultyMasterRotationScheduleDTO, facultyDetail,
							themeDisplay, isDraft);
				}
			}
		}

		try {
			if (!isDraft) {
				Map<String, Long> facultyMap = new HashMap<>();
				facultyMap.put("progdurationTlBlocksLtId", progdurationTlBlocksLtId);
				facultyMap.put("programMasterId", programMasterId);
				sendNotificationToFaculty(resourceRequest, themeDisplay, facultyMap,
						facultyMasterRotationScheduleList, facultyMasterRotationScheduleOldList, status,
						facultyIds);
			}

		} catch (Exception e) {
			_logger.error("error while sending notification :::" + e.getMessage(), e);
		}
	}

	/**
	 * @param resourceRequest
	 * @param themeDisplay
	 * @param facultyMap
	 * @param facultyMasterRotationScheduleList
	 * @param facultyMasterRotationScheduleOldList
	 * @param status
	 * @param facultyIds
	 * @throws PortalException
	 */
	public void sendNotificationToFaculty(ResourceRequest resourceRequest, ThemeDisplay themeDisplay,
			Map<String, Long> facultyMap,
			List<SaveFacultyMasterRotationScheduleDTO> facultyMasterRotationScheduleList,
			List<SaveFacultyMasterRotationScheduleDTO> facultyMasterRotationScheduleOldList, String status,
			List<Long> facultyIds) throws PortalException {
		List<Long> facultyDataIds;
		if (status.equalsIgnoreCase("COMPLETED")) {
			facultyDataIds = new ArrayList<>(fetchFacultyDetails(facultyMasterRotationScheduleOldList,
					facultyMasterRotationScheduleList));
		} else {
			facultyDataIds = facultyIds;
		}
		sendNoftificationToFaculty(resourceRequest, themeDisplay,facultyMap.get("progdurationTlBlocksLtId"), facultyMap.get("programMasterId"),
				facultyDataIds);
	}

	private boolean validateFacultyData(List<SaveFacultyMasterRotationScheduleDTO> facultyMasterRotationScheduleList, int totalBlocks) {
		Map<Long, List<Long>> faculty = new HashMap<>();
		boolean isvalidateFaculty = true;
		for (SaveFacultyMasterRotationScheduleDTO facultyMaster : facultyMasterRotationScheduleList) {
			for (FacultyDetail facultyDetail : facultyMaster.getFacultyDetails()) {
				if (faculty.containsKey(facultyDetail.getFacultyId())) {
					List<Long> block = faculty.get(facultyDetail.getFacultyId());
					block.add(facultyMaster.getBlockId());
					faculty.replace(facultyDetail.getFacultyId(), block);
				} else {
					List<Long> block = new ArrayList<>();
					block.add(facultyMaster.getBlockId());
					faculty.put(facultyDetail.getFacultyId(), block);
				}
			}
		}
		for (Map.Entry<Long, List<Long>> data : faculty.entrySet()) {
			List<Long> blockId = data.getValue();
			if(blockId.size() != totalBlocks) {
				isvalidateFaculty = false;
			}
			_logger.info("Faculty Data==="+data.getKey()+"Value is:  "+blockId.size());
		}
		return isvalidateFaculty;
	}

	private List<FacultyRotationTsBlockDetailsRel> extracted(long progdurationTlBlocksLtId) {
		List<BlocksMetadataDetailsRel> blocksMetadataDetailsRels = blocksMetadataDetailsRelLocalService
				.findByProgDurationTlBlocksLtId(progdurationTlBlocksLtId);
		List<Long> blockIds = blocksMetadataDetailsRels.stream()
				.map(BlocksMetadataDetailsRel::getBlocksMetadataDetailsRelId).collect(Collectors.toList());
		DynamicQuery query = facultyRotationTsBlockDetailsRelLocalService.dynamicQuery();
		query.add(PropertyFactoryUtil.forName("blocksMetadataDetailsRelId").in(blockIds));
		return facultyRotationTsBlockDetailsRelLocalService.dynamicQuery(query);
	}

	private SaveFacultyMasterRotationScheduleDTO createFacultyMasterRotationScheduleDTO(
			BlocksMetadataDetailsRel blocksMetadataDetailsRel, TrainingSiteByRotationsDTO trainingSiteByRotationsDTO) {
		SaveFacultyMasterRotationScheduleDTO facultyMasterRotationScheduleDTO = new SaveFacultyMasterRotationScheduleDTO();
		List<FacultyDetail> facultyDetails = new ArrayList<>();

		List<FacultyRotationTsBlockDetailsRel> facultyRotationTsBlockDetailsRels = facultyRotationTsBlockDetailsRelLocalService
				.findByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId(
						blocksMetadataDetailsRel.getBlocksMetadataDetailsRelId(),
						trainingSiteByRotationsDTO.getProgDurationRotationTsRelId());

		for (FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel : facultyRotationTsBlockDetailsRels) {
			FacultyDetail facultyDetail = createFacultyDetail(facultyRotationTsBlockDetailsRel);
			facultyDetails.add(facultyDetail);
		}

		facultyMasterRotationScheduleDTO.setFacultyDetails(facultyDetails);
		facultyMasterRotationScheduleDTO.setBlockId(blocksMetadataDetailsRel.getBlocksMetadataDetailsRelId());
		facultyMasterRotationScheduleDTO.setRotationId(trainingSiteByRotationsDTO.getProgDurationRotationTsRelId());

		return facultyMasterRotationScheduleDTO;
	}

	private FacultyDetail createFacultyDetail(FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel) {
		FacultyDetail facultyDetail = new FacultyDetail();
		facultyDetail.setFacultyId(facultyRotationTsBlockDetailsRel.getFacultyId());

		try {
			User facultyUser = userLocalService.getUser(facultyRotationTsBlockDetailsRel.getFacultyId());
			facultyDetail.setFacultyName(facultyUser.getFullName());
		} catch (PortalException e) {
			_logger.error(e);
		}
		return facultyDetail;
	}

	private Set<Long> fetchFacultyDetails(
			List<SaveFacultyMasterRotationScheduleDTO> facultyMasterRotationScheduleOldList,
			List<SaveFacultyMasterRotationScheduleDTO> facultyMasterRotationScheduleList) {
		Set<Long> facultyIds = new HashSet<>();
		for (SaveFacultyMasterRotationScheduleDTO saveFacultyMasterRotationScheduleDTO : facultyMasterRotationScheduleList) {
			List<Long> facultyNewIds = saveFacultyMasterRotationScheduleDTO.getFacultyDetails().stream()
					.map(FacultyDetail::getFacultyId).collect(Collectors.toList());
			List<Long> facultyNewIdsBackup = new ArrayList<>();
			facultyNewIdsBackup.addAll(facultyNewIds);
			List<SaveFacultyMasterRotationScheduleDTO> masterfacultyScheduleDTOs = facultyMasterRotationScheduleOldList
					.stream()
					.filter(obj -> obj.getRotationId() == saveFacultyMasterRotationScheduleDTO.getRotationId()
							&& obj.getBlockId() == saveFacultyMasterRotationScheduleDTO.getBlockId())
					.collect(Collectors.toList());
			List<Long> facultyoldIds = new ArrayList<>();
			for (SaveFacultyMasterRotationScheduleDTO masterFacultyScheduleDTO : masterfacultyScheduleDTOs) {
				facultyoldIds = masterFacultyScheduleDTO.getFacultyDetails().stream().map(FacultyDetail::getFacultyId)
						.collect(Collectors.toList());
			}
			facultyNewIds.removeAll(facultyoldIds);
			facultyoldIds.removeAll(facultyNewIdsBackup);
			if (!facultyNewIds.isEmpty() || !facultyoldIds.isEmpty() || masterfacultyScheduleDTOs.isEmpty()) {
				facultyIds.addAll(facultyNewIds);
				facultyIds.addAll(facultyoldIds);
			}
		}
		return facultyIds;
	}

	private void sendNoftificationToFaculty(ResourceRequest resourceRequest, ThemeDisplay themeDisplay,
			long progdurationTlBlocksLtId, long programMasterId, List<Long> facultyIds) throws PortalException {
		String programName = programMasterLocalService.getProgramMaster(programMasterId).getProgramName(themeDisplay.getLocale());
		ProgdurationTraineelevelBlocksLevelTypeRel traineelevelBlocksLevelTypeRel = progdurationTraineelevelBlocksLevelTypeRelLocalService
				.fetchProgdurationTraineelevelBlocksLevelTypeRel(progdurationTlBlocksLtId);
		String traineeLevel = traineeLevelMasterLocalService
				.fetchTraineeLevelMaster(traineelevelBlocksLevelTypeRel.getTraineeLevelId())
				.getTraineeLevelName(themeDisplay.getLocale().toString());
		String renderURL = omsbMasterRotationScheduleUtil.createScheduleMasterRotationRenderUrl(themeDisplay, resourceRequest, programMasterId, progdurationTlBlocksLtId);

		Role paRole = roleLocalService.getRole(PortalUtil.getDefaultCompanyId(), OmsbTmsCommonConstants.PA_ROLE);

		List<UserMetadata> userMetadataList = userMetadataUtil
				.getUserMetadataItemsByProgramIdAndRoleId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(),
						programMasterId, paRole.getRoleId())
				.getItems();
		List<Long> userIds = userMetadataList.stream().map(e -> e.getLrUserId()).collect(Collectors.toList());

		List<Long> ecMemberIds = fetchEcMemberList(themeDisplay, programMasterId);
		
		removeDuplicateValue(userIds);
		removeDuplicateValue(facultyIds);
		removeDuplicateValue(ecMemberIds);
		for (Long facultyId : facultyIds) {
			User toUser = userLocalService.fetchUser(facultyId);
			omsbMasterRotationScheduleUtil.prepareMailForFacultyMessage(programName, traineeLevel,
					themeDisplay.getUser(), toUser, null);
			omsbMasterRotationScheduleUtil.prepareNotificationForFacultyMessage(programName, traineeLevel, themeDisplay.getUser(),
					toUser, null);

		}
		for (Long userId : userIds) {
			User topaUser = userLocalService.fetchUser(userId);

			_logger.debug("notification send to PA");

			omsbMasterRotationScheduleUtil.prepareMailForPaUserMessage(programName, traineeLevel,
					themeDisplay.getUser(), topaUser, renderURL);
			omsbMasterRotationScheduleUtil.prepareNotificationForPaUserMessage(programName, traineeLevel, themeDisplay.getUser(),
					topaUser, renderURL);
		}

		for (Long userId : ecMemberIds) {
			User topaUser = userLocalService.fetchUser(userId);

			_logger.debug("notification send to EC Member");

			omsbMasterRotationScheduleUtil.prepareMailForEcMemberMessage(programName, traineeLevel,
					themeDisplay.getUser(), topaUser, null);
			omsbMasterRotationScheduleUtil.prepareNotificationForEcMemberMessage(programName, traineeLevel, themeDisplay.getUser(),
					topaUser, null);
		}
	}

	private void removeDuplicateValue(List<Long> ids) {
		Set<Long> set = new HashSet<>(ids.size());
		ids.removeIf(p -> !set.add(p));		
	}

	private List<SaveFacultyMasterRotationScheduleDTO> parseJson(String jsonString) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.readValue(jsonString, new TypeReference<List<SaveFacultyMasterRotationScheduleDTO>>() {
			});
		} catch (JsonProcessingException e) {
			_logger.error(e);
			resultJson.put(CommonConstants.SUCCESS, false);
			return Collections.emptyList();
		}
	}

	private void createFacultyRotationTsBlockDetails(
			SaveFacultyMasterRotationScheduleDTO saveFacultyMasterRotationScheduleDTO, FacultyDetail facultyDetail,
			ThemeDisplay themeDisplay, boolean isDraft) {
		long facultyRotationTsBlockDetailsRelId = counterLocalService.increment(getClass().getName(), 1);
		Calendar calendar = Calendar.getInstance();
		FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel = facultyRotationTsBlockDetailsRelLocalService
				.createFacultyRotationTsBlockDetailsRel(facultyRotationTsBlockDetailsRelId);

		facultyRotationTsBlockDetailsRel
				.setBlocksMetadataDetailsRelId(saveFacultyMasterRotationScheduleDTO.getBlockId());
		facultyRotationTsBlockDetailsRel
				.setProgDurationRotationTsRelId(saveFacultyMasterRotationScheduleDTO.getRotationId());
		facultyRotationTsBlockDetailsRel.setFacultyId(facultyDetail.getFacultyId());
		facultyRotationTsBlockDetailsRel.setGroupId(themeDisplay.getScopeGroupId());
		facultyRotationTsBlockDetailsRel.setCompanyId(themeDisplay.getCompanyId());
		facultyRotationTsBlockDetailsRel.setCreateDate(calendar.getTime());
		facultyRotationTsBlockDetailsRel.setModifiedDate(calendar.getTime());
		facultyRotationTsBlockDetailsRel.setCreatedBy(themeDisplay.getUserId());
		facultyRotationTsBlockDetailsRel.setModifiedBy(themeDisplay.getUserId());
		facultyRotationTsBlockDetailsRel
				.setStatus(isDraft ? OmsbTmsCommonConstants.STATUS_DRAFT : OmsbTmsCommonConstants.STATUS_COMPLETED);
		facultyRotationTsBlockDetailsRelLocalService
				.addFacultyRotationTsBlockDetailsRel(facultyRotationTsBlockDetailsRel);

	}

	private void deleteFacultyRotationTsBlockDetails(long blocksMetadataDetailsRelId,
			long progDurationRotationTsRelId) {
		facultyRotationTsBlockDetailsRelLocalService
				.deleteFacultyRotationTsBlockDetailsRel(facultyRotationTsBlockDetailsRelLocalService
						.findByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId(blocksMetadataDetailsRelId,
								progDurationRotationTsRelId));
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
	private CounterLocalService counterLocalService;

	@Reference
	private FacultyRotationTsBlockDetailsRelLocalService facultyRotationTsBlockDetailsRelLocalService;

	@Reference
	private UserLocalService userLocalService;

	@Reference
	private TraineeLevelMasterLocalService traineeLevelMasterLocalService;

	@Reference
	private ProgdurationTraineelevelBlocksLevelTypeRelLocalService progdurationTraineelevelBlocksLevelTypeRelLocalService;

	@Reference
	private RoleLocalService roleLocalService;

	@Reference
	private UserMetadataUtil userMetadataUtil;

	@Reference
	private ProgramMasterLocalService programMasterLocalService;

	@Reference
	private TraineeRotationTsBlockDetailsRelLocalService traineeRotationTsBlockDetailsRelLocalService;

	@Reference
	private BlocksMetadataDetailsRelLocalService blocksMetadataDetailsRelLocalService;

	private static final Log _logger = LogFactoryUtil
			.getLog(OmsbSaveFacultyMasterRotationScheduleMVCResourceCommand.class);
}
