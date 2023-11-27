package gov.omsb.my.schedule.web.portlet.mvccommands;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.dto.UserMetadata;
import gov.omsb.common.dto.UserMetadataItem;
import gov.omsb.common.service.util.UserMetadataUtil;
import gov.omsb.common.util.CommonUtil;
import gov.omsb.my.schedule.web.constants.OmsbMyScheduleWebPortletKeys;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.model.BlocksMetadataDetailsRel;
import gov.omsb.tms.model.FacultyRotationTsBlockDetailsRel;
import gov.omsb.tms.model.LeaveMaster;
import gov.omsb.tms.model.LeaveTypes;
import gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel;
import gov.omsb.tms.model.TraineeRotationTsBlockDetailsRel;
import gov.omsb.tms.service.BlocksMetadataDetailsRelLocalService;
import gov.omsb.tms.service.FacultyRotationTsBlockDetailsRelLocalService;
import gov.omsb.tms.service.LeaveMasterLocalService;
import gov.omsb.tms.service.LeaveTypesLocalService;
import gov.omsb.tms.service.ProgdurationRotationTrainingsitesRelLocalService;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;
import gov.omsb.tms.service.TraineeRotationTsBlockDetailsRelLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbMyScheduleWebPortletKeys.OMSBMYSCHEDULEWEB,
		"mvc.command.name=/" }, service = MVCRenderCommand.class)
public class OmsbMyScheduleDefaultMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		boolean isFacultyUser = CommonUtil.isFacultyUser(themeDisplay.getUser());

		Map<Long, List<String>> progdurationRotationTrainingsitesRelBlocksMapping = new HashMap<>();
		Map<Long, String> progdurationRotationTrainingsitesRelCodeMapping = new HashMap<>();
		Map<Long, List<Long>> progdurationRotationTrainingsitesRelIdBlockIdMapping = new HashMap<>();

		if (isFacultyUser) {
			List<FacultyRotationTsBlockDetailsRel> facultyRotationTsBlockDetailsRelList = facultyRotationTsBlockDetailsRelLocalService
					.findByFacultyIdAndStatus(themeDisplay.getUserId(), OmsbTmsCommonConstants.STATUS_COMPLETED);

			_logger.debug("Faculty List :: " + facultyRotationTsBlockDetailsRelList);

			Map<Long, String> programMapping = new HashMap<>();

			try {
				UserMetadataItem metadataItem = userMetadataUtil.getUserMetadataItemsByLrUserId(
						themeDisplay.getPortalURL(), themeDisplay.getSiteGroupId(), themeDisplay.getUserId());
				List<Long> programIds = metadataItem.getItems().stream().map(UserMetadata::getProgramId)
						.collect(Collectors.toList());

				programMasterLocalService.getProgramListByIds(programIds)
						.forEach(programMaster -> programMapping.put(programMaster.getProgramMasterId(),
								programMaster.getProgramName(themeDisplay.getLocale())));

			} catch (Exception e) {
				_logger.error(e);
			}

			facultyRotationTsBlockDetailsRelList.forEach(
					facultyRotationTsBlockDetailsRel -> progdurationRotationTrainingsitesRelIdBlockIdMapping.put(
							facultyRotationTsBlockDetailsRel.getProgDurationRotationTsRelId(),
							facultyRotationTsBlockDetailsRelLocalService
									.findByProgDurationRotationTsRelId(
											facultyRotationTsBlockDetailsRel.getProgDurationRotationTsRelId())
									.stream().map(FacultyRotationTsBlockDetailsRel::getBlocksMetadataDetailsRelId)
									.collect(Collectors.toList())));

			getUserProgdurationRotationTrainingsitesRelBlockAndCodeMapping(themeDisplay,
					progdurationRotationTrainingsitesRelIdBlockIdMapping,
					progdurationRotationTrainingsitesRelCodeMapping, progdurationRotationTrainingsitesRelBlocksMapping);

			renderRequest.setAttribute(OmsbMyScheduleWebPortletKeys.PROGRAM_MAPPING_MAP, programMapping);

			renderRequest.setAttribute(
					OmsbMyScheduleWebPortletKeys.PROG_DRATION_ROTATION_TRAINING_SITES_REL_BLOCK_MAPPING,
					progdurationRotationTrainingsitesRelBlocksMapping);
			renderRequest.setAttribute(
					OmsbMyScheduleWebPortletKeys.PROG_DRATION_ROTATION_TRAINING_SITES_REL_CODE_MAPPING,
					progdurationRotationTrainingsitesRelCodeMapping);

			renderRequest.setAttribute(OmsbMyScheduleWebPortletKeys.FACULTY_ROTATION_TS_BLOCK_DETAILS_REL_LIST,
					facultyRotationTsBlockDetailsRelList);

			return OmsbMyScheduleWebPortletKeys.FACULTY_SCHEDULE_WEB_JSP;
		} else {
			List<TraineeRotationTsBlockDetailsRel> traineeRotationTsBlockDetailsRelList = traineeRotationTsBlockDetailsRelLocalService
					.findByTraineeIdAndStatus(themeDisplay.getUserId(), OmsbTmsCommonConstants.STATUS_COMPLETED);

			_logger.debug("Trainee List :: " + traineeRotationTsBlockDetailsRelList);

			traineeRotationTsBlockDetailsRelList.forEach(
					traineeRotationTsBlockDetailsRel -> progdurationRotationTrainingsitesRelIdBlockIdMapping.put(
							traineeRotationTsBlockDetailsRel.getProgDurationRotationTsRelId(),
							traineeRotationTsBlockDetailsRelLocalService
									.findByProgDurationRotationTsRelId(
											traineeRotationTsBlockDetailsRel.getProgDurationRotationTsRelId())
									.stream().map(TraineeRotationTsBlockDetailsRel::getBlocksMetadataDetailsRelId)
									.collect(Collectors.toList())));

			getUserProgdurationRotationTrainingsitesRelBlockAndCodeMapping(themeDisplay,
					progdurationRotationTrainingsitesRelIdBlockIdMapping,
					progdurationRotationTrainingsitesRelCodeMapping, progdurationRotationTrainingsitesRelBlocksMapping);

			renderRequest.setAttribute(
					OmsbMyScheduleWebPortletKeys.PROG_DRATION_ROTATION_TRAINING_SITES_REL_BLOCK_MAPPING,
					progdurationRotationTrainingsitesRelBlocksMapping);
			renderRequest.setAttribute(
					OmsbMyScheduleWebPortletKeys.PROG_DRATION_ROTATION_TRAINING_SITES_REL_CODE_MAPPING,
					progdurationRotationTrainingsitesRelCodeMapping);
			renderRequest.setAttribute(OmsbMyScheduleWebPortletKeys.TRAINEE_ROTATION_TS_BLOCK_DETAILS_REL_LIST,
					traineeRotationTsBlockDetailsRelList);

			return OmsbMyScheduleWebPortletKeys.TRAINEE_SCHEDULE_WEB_JSP;
		}

	}

	private void getUserProgdurationRotationTrainingsitesRelBlockAndCodeMapping(ThemeDisplay themeDisplay,
			Map<Long, List<Long>> progdurationRotationTrainingsitesRelIdBlockIdMapping,
			Map<Long, String> progdurationRotationTrainingsitesRelCodeMapping,
			Map<Long, List<String>> progdurationRotationTrainingsitesRelBlocksMapping) {

		progdurationRotationTrainingsitesRelIdBlockIdMapping
				.forEach((progdurationRotationTrainingsitesRelId, blockIds) -> {
					ProgdurationRotationTrainingsitesRel progdurationRotationTrainingsitesRel = null;
					try {

						progdurationRotationTrainingsitesRel = progdurationRotationTrainingsitesRelLocalService
								.getProgdurationRotationTrainingsitesRel(progdurationRotationTrainingsitesRelId);
						progdurationRotationTrainingsitesRelCodeMapping.put(progdurationRotationTrainingsitesRelId,
								progdurationRotationTrainingsitesRel.getProgCodeRsnSiteCode() + StringPool.SPACE
										+ StringPool.OPEN_PARENTHESIS
										+ progdurationRotationTrainingsitesRel.getNoOfSlots()
										+ StringPool.CLOSE_PARENTHESIS);

						List<String> blockDetails = new ArrayList<>();
						getBlockDetails(blockDetails, blockIds);

						getMapProgdurationRotationTrainingsitesRelBlocksMapping(progdurationRotationTrainingsitesRelId,
								blockDetails, progdurationRotationTrainingsitesRelBlocksMapping, themeDisplay);

					} catch (PortalException e) {
						_logger.error(e);
					}
				});

	}

	private Map<String, String> getLeavesOfBlock(ThemeDisplay themeDisplay) {

		Map<String, String> blockLeaveMapping = new HashMap<>();
		boolean isTrainee = CommonUtil.isTraineeUser(themeDisplay.getUser());
		if (isTrainee) {
			List<LeaveMaster> leaveMasters = leaveMasterLocalService
					.findLeaveDetailsByTraineeId(themeDisplay.getUserId());
			for (LeaveMaster leaveMaster : leaveMasters) {
				LeaveTypes leaveTypes;
				try {
					leaveTypes = leaveTypesLocalService.getLeaveTypes(leaveMaster.getLeaveTypeId());
					// block name will be there like block-1
					if (Validator.isNotNull(leaveMaster.getBlockName())) {
						blockLeaveMapping.put(leaveMaster.getBlockName().split("-")[1], leaveTypes.getLeaveCode());
						_logger.debug("Leave block and type :: " + leaveMaster.getBlockName().split("-")[1] + " , "
								+ leaveTypes.getLeaveCode());
					}
				} catch (PortalException e) {
					_logger.error(e);
				}
			}
		}
		return blockLeaveMapping;
	}

	private void getBlockDetails(List<String> blockDetails, List<Long> blockIds) {

		blockIds.forEach(id -> {
			BlocksMetadataDetailsRel blocksMetadataDetailsRel;
			try {
				blocksMetadataDetailsRel = blocksMetadataDetailsRelLocalService.getBlocksMetadataDetailsRel(id);
				String blockNo = blocksMetadataDetailsRel.getBlockNo().split(StringPool.DASH)[1];
				blockDetails.add(blockNo);
			} catch (PortalException e) {
				_logger.error(e);
			}
		});
	}

	private Map<Long, List<String>> getMapProgdurationRotationTrainingsitesRelBlocksMapping(
			Long progdurationRotationTrainingsitesRelId, List<String> blockDetails,
			Map<Long, List<String>> progdurationRotationTrainingsitesRelBlocksMapping, ThemeDisplay themeDisplay) {
		List<String> blockDetailStringList = new ArrayList<>();
		Map<String, String> leaveMapping = getLeavesOfBlock(themeDisplay);
		for (int i = 1; i <= 13; i++) {
			String blockDetail = getBlockDetail(i, blockDetails, leaveMapping);
			blockDetailStringList.add(blockDetail);
		}
		progdurationRotationTrainingsitesRelBlocksMapping.put(progdurationRotationTrainingsitesRelId,
				blockDetailStringList);
		return progdurationRotationTrainingsitesRelBlocksMapping;
	}

	private String getBlockDetail(int blockNumber, List<String> blockDetails, Map<String, String> leaveMapping) {
		if (blockDetails.contains(String.valueOf(blockNumber))) {
			return Boolean.TRUE.toString();
		} else {
			String leaveType = leaveMapping.get(String.valueOf(blockNumber));
			if (leaveType != null) {
				if (leaveType.equalsIgnoreCase("AL")) {
					return "AL";
				} else if (leaveType.equalsIgnoreCase("ML")) {
					return "ML";
				} else if (!leaveType.isBlank()) {
					return leaveType;
				}
			}
			return Boolean.FALSE.toString();
		}
	}

	private static final Log _logger = LogFactoryUtil.getLog(OmsbMyScheduleDefaultMVCRenderCommand.class);

	@Reference
	private UserMetadataUtil userMetadataUtil;

	@Reference
	private LeaveMasterLocalService leaveMasterLocalService;

	@Reference
	private LeaveTypesLocalService leaveTypesLocalService;

	@Reference
	private ProgramMasterLocalService programMasterLocalService;

	@Reference
	private ProgramDurationDetailsLocalService programDurationDetailsLocalService;

	@Reference
	private BlocksMetadataDetailsRelLocalService blocksMetadataDetailsRelLocalService;

	@Reference
	private ProgdurationRotationTrainingsitesRelLocalService progdurationRotationTrainingsitesRelLocalService;

	@Reference
	private TraineeRotationTsBlockDetailsRelLocalService traineeRotationTsBlockDetailsRelLocalService;

	@Reference
	private FacultyRotationTsBlockDetailsRelLocalService facultyRotationTsBlockDetailsRelLocalService;

}
