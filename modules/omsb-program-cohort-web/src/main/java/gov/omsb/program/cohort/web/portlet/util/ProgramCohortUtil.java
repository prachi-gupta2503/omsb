package gov.omsb.program.cohort.web.portlet.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletMode;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.ActionRequest;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.util.CommonUtil;
import gov.omsb.program.cohort.web.constants.OmsbProgramCohortWebPortletKeys;
import gov.omsb.program.cohort.web.dto.ProgramCohortRelationalDTO;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.common.util.OmsbTmsCommonUtil;
import gov.omsb.tms.custom.dto.ProgramCohortDTO;
import gov.omsb.tms.model.BlockWeekMetadataDetailsRel;
import gov.omsb.tms.model.BlocksMetadataDetailsRel;
import gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel;
import gov.omsb.tms.model.ProgramDurationDetails;
import gov.omsb.tms.service.BlockWeekMetadataDetailsRelLocalServiceUtil;
import gov.omsb.tms.service.BlocksMetadataDetailsRelLocalServiceUtil;
import gov.omsb.tms.service.ProgdurationTraineelevelBlocksLevelTypeRelLocalServiceUtil;
import gov.omsb.tms.service.ProgramDurationDetailsLocalServiceUtil;

public class ProgramCohortUtil {
	
	private ProgramCohortUtil() {}
	
	/**
	 * 
	 * @param themeDisplay
	 * @param request
	 * @param programMasterId
	 * @return
	 */
	public static String createProgramDetailsPageRenderUrl(ThemeDisplay themeDisplay, PortletRequest request, long programMasterId) {
		_logger.info("createProgramDetailsPageRenderUrl Invoked ::: ");
		String renderUrlStr = StringPool.BLANK;
		try {
			String portletId = OmsbProgramCohortWebPortletKeys.OMSBPROGRAMSWEB;
			long plId = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), portletId);
			PortletURL programListRenderUrl = PortletURLFactoryUtil.getPortletURLFactory().create(request, portletId, plId,
					PortletRequest.RENDER_PHASE);
			programListRenderUrl.getRenderParameters().setValue("p_p_state", "normal");
			programListRenderUrl.getRenderParameters().setValue("p_p_mode", "view");
			programListRenderUrl.getRenderParameters().setValue(OmsbProgramCohortWebPortletKeys.MVC_RENDER_COMMAND_NAME, "/program-details");
			programListRenderUrl.getRenderParameters().setValue("programMasterId", String.valueOf(programMasterId));
			renderUrlStr = programListRenderUrl.toString();
		} catch (PortalException e) {
			_logger.error("createProgramDetailsPageRenderUrl Error ::: " + e);
		}
		_logger.info("createProgramDetailsPageRenderUrl Exit ::: ");
		return renderUrlStr;
	}
	
	/**
	 * 
	 * @param themeDisplay
	 * @param request
	 * @param programId
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static String createAddProgramCohortRenderUrl(ThemeDisplay themeDisplay, PortletRequest request, long programId) {
		_logger.info("createAddRotationRenderUrl Invoked ::: ");
		String renderUrlStr = StringPool.BLANK;
		try {
			PortletURL renderUrl = PortletURLFactoryUtil.create(request,
					themeDisplay.getPortletDisplay().getId(), themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
			renderUrl.setWindowState(LiferayWindowState.NORMAL);
			renderUrl.setPortletMode(LiferayPortletMode.VIEW);
			renderUrl.setParameter(OmsbProgramCohortWebPortletKeys.PROGRAM_ID, String.valueOf(programId));
			renderUrl.setParameter(OmsbProgramCohortWebPortletKeys.MVC_RENDER_COMMAND_NAME,
					StringPool.SLASH);
		   renderUrlStr = renderUrl.toString();
		} catch (PortletModeException | WindowStateException e) {
			_logger.error("createAddRotationRenderUrl Error ::: " + e);
		}
		_logger.info("createAddRotationRenderUrl Exit ::: ");
		return renderUrlStr;
	}
	
	public static void prepareActionData(List<ProgramCohortDTO> programCohortDTOs, ThemeDisplay themeDisplay, ResourceRequest request) {
		SimpleDateFormat sdf = new SimpleDateFormat(OmsbTmsCommonConstants.DATE_FORMAT_DD_MM_YYYY);
		long currentYear = (Calendar.getInstance()).get(Calendar.YEAR);
		for(ProgramCohortDTO dto : programCohortDTOs) {
			
			JSONObject action = JSONFactoryUtil.createJSONObject();
			action.put(OmsbTmsCommonConstants.PROGDURATION_TLBLOCKS_LT_ID, dto.getProgdurationTlBlocksLtId());
			action.put(OmsbTmsCommonConstants.EDIT_RENDER_URL, createRenderUrl(themeDisplay, request, dto));
			action.put(OmsbTmsCommonConstants.LAST_MODIFIED_DATE, sdf.format(dto.getModifiedDate()));
			
			boolean isCurrentYearTraineeLevel = isCurrentYearTraineeLevel(currentYear, dto);
			action.put(OmsbTmsCommonConstants.IS_ALL_TRAINEE_TAKEN_LEAVE_FOR_CURRENT_YEAR, OmsbTmsCommonUtil.isAllTraineeTakenLeaveForCurrentYear(dto.getProgramDurationId(), dto.getTraineeLevelId()));
			action.put(OmsbTmsCommonConstants.IS_CURRENT_YEAR_TRAINEE_LEVEL,  isCurrentYearTraineeLevel);
			if(isCurrentYearTraineeLevel) {
				action.put(OmsbTmsCommonConstants.SCHEDULE_MASTER_ROTATION_RENDER_URL, createRenderUrlForDifferentPortlet(themeDisplay, request, dto));
			}
			
			action.put(OmsbTmsCommonConstants.PROGRAM_MASTER_ID, dto.getProgramMasterId());
			
			dto.setActions(action.toJSONString());
		}
	}
	
	private static boolean isCurrentYearTraineeLevel(long currentYear, ProgramCohortDTO dto) {
		ProgramDurationDetails durationDetails = null;
		try {
			durationDetails = ProgramDurationDetailsLocalServiceUtil.getProgramDurationDetails(dto.getProgramDurationId());
			if(Validator.isNotNull(durationDetails)) {
				long durationYear = Long.parseLong(durationDetails.getAyApplicableForm().split(StringPool.DASH)[0]);
				List<ProgdurationTraineelevelBlocksLevelTypeRel> blocksLevelTypeRels = ProgdurationTraineelevelBlocksLevelTypeRelLocalServiceUtil.findByProgramDurationId(durationDetails.getProgDurationId());
				if(Validator.isNotNull(blocksLevelTypeRels) && !blocksLevelTypeRels.isEmpty() && currentYear >= durationYear) {
					blocksLevelTypeRels = blocksLevelTypeRels.stream().sorted((o1, o2)-> Long.compare(o1.getTraineeLevelId(), o2.getTraineeLevelId())).collect(Collectors.toList());
					for (ProgdurationTraineelevelBlocksLevelTypeRel progdurationTraineelevelBlocksLevelTypeRel : blocksLevelTypeRels) {
						if(progdurationTraineelevelBlocksLevelTypeRel.getTraineeLevelId() == dto.getTraineeLevelId() && durationYear == currentYear) {
							return true;
						}
						durationYear++;
					}
				}
			}
		} catch (PortalException e) {
			_logger.error(e);
		}
		return false;
	}

	@SuppressWarnings("deprecation")
	public static String createRenderUrl(ThemeDisplay themeDisplay, ResourceRequest request, ProgramCohortDTO dto) {
		_logger.info("createRenderUrl Invoked ::: ");
		String renderUrlStr = StringPool.BLANK;
		long programId = ParamUtil.getLong(request, OmsbProgramCohortWebPortletKeys.PROGRAM_ID, 0);
		try {
			PortletURL renderUrl = PortletURLFactoryUtil.create(request, themeDisplay.getPortletDisplay().getId(),
					themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
			renderUrl.setWindowState(WindowState.NORMAL);
			renderUrl.setPortletMode(PortletMode.VIEW);
			renderUrl.setParameter(CommonConstants.MVC_RENDER_COMMAND_NAME, OmsbProgramCohortWebPortletKeys.EDIT_PROGRAM_COHORT_MVC_RENDER_COMMAND);
			//programId - programId from programDetails page
			renderUrl.setParameter(OmsbProgramCohortWebPortletKeys.PROGRAM_ID, String.valueOf(programId));
			renderUrl.setParameter(CommonConstants.PROGRAM_MASTER_ID, String.valueOf(dto.getProgramMasterId()));
			renderUrl.setParameter(OmsbTmsCommonConstants.PROGRAM_DURATION_ID, String.valueOf(dto.getProgramDurationId()));
			renderUrl.setParameter(OmsbTmsCommonConstants.PROGDURATION_TLBLOCKS_LT_ID, String.valueOf(dto.getProgdurationTlBlocksLtId()));
			renderUrl.setParameter(CommonConstants.REDIRECT_COMMAND_URL, themeDisplay.getURLCurrent().replace("p_p_lifecycle=2", "p_p_lifecycle=0"));
			renderUrlStr = renderUrl.toString();
		} catch (PortletModeException | WindowStateException e) {
			_logger.error("createRenderUrl Error ::: " + e);
		}
		_logger.info("createRenderUrl Exit ::: ");
		return renderUrlStr;
	}
	
	@SuppressWarnings("deprecation")
	public static String createRenderUrlForDifferentPortlet(ThemeDisplay themeDisplay, ResourceRequest request, ProgramCohortDTO dto) {
		_logger.info("createRenderUrlForDifferentPortlet Invoked ::: ");
		long groupId = themeDisplay.getScopeGroupId();
		Layout trainingSiteLayout = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(groupId, true, OmsbTmsCommonConstants.SCHEDULE_MASTER_ROTATION_FRAINDLY_URL);
		long plid = Validator.isNotNull(trainingSiteLayout) ? trainingSiteLayout.getPlid() : 0;
		
		
		String renderUrlStr = StringPool.BLANK;
		try {
			PortletURL renderUrl = PortletURLFactoryUtil.create(request, OmsbTmsCommonConstants.SCHEDULE_MASTER_ROTATION_PORTLET_NAME, plid, PortletRequest.RENDER_PHASE);
			renderUrl.setWindowState(WindowState.NORMAL);
			renderUrl.setPortletMode(PortletMode.VIEW);
			renderUrl.setParameter(CommonConstants.MVC_RENDER_COMMAND_NAME, "/");
			renderUrl.setParameter(CommonConstants.PROGRAM_MASTER_ID, String.valueOf(dto.getProgramMasterId()));
			renderUrl.setParameter(OmsbTmsCommonConstants.PROGDURATION_TLBLOCKS_LT_ID, String.valueOf(dto.getProgdurationTlBlocksLtId()));
			renderUrlStr = renderUrl.toString();
		} catch (PortletModeException | WindowStateException e) {
			_logger.error("createRenderUrlForDifferentPortlet Error ::: " + e);
		}
		_logger.info("createRenderUrlForDifferentPortlet Exit ::: ");
		return renderUrlStr;
	}
	
	public static List<String> getYearRangeForSearch(long totalProgramDurationCount, ResourceRequest resourceRequest) {
		_logger.info("getYearRangeForSearch Invoked :::");
		
		long yearFrom = ParamUtil.getLong(resourceRequest, OmsbProgramCohortWebPortletKeys.YEAR_FROM, 0);
		long yearTo = ParamUtil.getLong(resourceRequest, OmsbProgramCohortWebPortletKeys.YEAR_TO, 0);
		long yearDiff = 0;
		
		if(Validator.isNotNull(yearFrom) && Validator.isNotNull(yearTo)) {
			yearDiff = yearTo - yearFrom;
		} else if(Validator.isNotNull(yearFrom) && Validator.isNull(yearTo)) {
			 yearDiff = totalProgramDurationCount;
		} else if(Validator.isNull(yearFrom) && Validator.isNotNull(yearTo)) {
			yearDiff = totalProgramDurationCount;
			yearFrom = yearTo - totalProgramDurationCount;
		}
		
		_logger.info("getYearRangeForSearch Exit :::");
		return CommonUtil.getYearRangeList(yearFrom, yearDiff);
	}
	
	public static List<ProgramCohortRelationalDTO> prepareProgramCohortRelationalDTOs(ActionRequest actionRequest){
		List<ProgramCohortRelationalDTO> programCohortRelationalDTOs = new ArrayList<>();
		long count = ParamUtil.getLong(actionRequest, OmsbProgramCohortWebPortletKeys.COUNT, 0);
		_logger.info("prepareProgramCohortRelationalDTOs ::: count ::: " + count+1);
		for(int i=0;i<=count;i++) {
			long progdurationTlBlocksLtId = ParamUtil.getLong(actionRequest, "progdurationTlBlocksLtId"+i, 0);
			long traineeLevelId = ParamUtil.getLong(actionRequest, "traineeLevel"+i, 0);
			int noOfBlocks = ParamUtil.getInteger(actionRequest, "noOfBlocks"+i, 0);
			long levelTypeId = ParamUtil.getLong(actionRequest, "levelType"+i, 0);
			
			if(traineeLevelId != 0 && noOfBlocks != 0 && levelTypeId != 0) {
				ProgramCohortRelationalDTO programCohortRelationalDTO = new ProgramCohortRelationalDTO();
				programCohortRelationalDTO.setProgdurationTlBlocksLtId(progdurationTlBlocksLtId);
				programCohortRelationalDTO.setLevelTypeId(levelTypeId);
				programCohortRelationalDTO.setNoOfBlocks(noOfBlocks);
				programCohortRelationalDTO.setTraineeLevelId(traineeLevelId);
				programCohortRelationalDTOs.add(programCohortRelationalDTO);
			}
		}
		return programCohortRelationalDTOs;
	}
	
	public static boolean prepareResponseJsonForProgramCohortDTOs(ResourceRequest resourceRequest, ResourceResponse resourceResponse, List<ProgramCohortDTO> programCohortDTOs) {
		_logger.info("prepareResponseJsonForProgramCohortDTOs Invoked :::");
		boolean isSuccess = true;
		try {
			String jsonString = (new ObjectMapper()).writeValueAsString((programCohortDTOs));
			JSONArray jsonArray = JSONFactoryUtil.createJSONArray(jsonString);
			JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, jsonArray);
		} catch (JSONException | IOException e) {
			_logger.error(e);
			isSuccess = false;
		}
		_logger.info("prepareResponseJsonForProgramCohortDTOs Exit :::");
		return isSuccess;
	}
	
	public static boolean deleteBlocks(long progdurationTlBlocksLtId) {
		_logger.info("deleteBlocks Invoked ::: ");
		boolean isSuccess = false;
		try {
			List<BlocksMetadataDetailsRel> blocksMetadataDetailsRels = BlocksMetadataDetailsRelLocalServiceUtil.findByProgDurationTlBlocksLtId(progdurationTlBlocksLtId);
			if(Validator.isNotNull(blocksMetadataDetailsRels) && !blocksMetadataDetailsRels.isEmpty()) {
				for(BlocksMetadataDetailsRel detailsRel : blocksMetadataDetailsRels) {
					deleteWeekBlocks(detailsRel.getBlocksMetadataDetailsRelId());
					BlocksMetadataDetailsRelLocalServiceUtil.deleteBlocksMetadataDetailsRel(detailsRel.getBlocksMetadataDetailsRelId());
				}
			}
		} catch(Exception e) {
			_logger.error("deleteBlocks :::" + e);
		}
		_logger.info("deleteBlocks Exit ::: ");
		return isSuccess;
	}

	public static void deleteWeekBlocks(long blocksMetadataDetailRelId) {
		_logger.info("deleteWeekBlocks Invoked ::: ");
		List<BlockWeekMetadataDetailsRel> blockWeekMetadataDetailsRels = BlockWeekMetadataDetailsRelLocalServiceUtil.findByBlocksMetadataDetailRelId(blocksMetadataDetailRelId);
		for (BlockWeekMetadataDetailsRel blockWeekMetadataDetailsRel : blockWeekMetadataDetailsRels) {
			try {
				BlockWeekMetadataDetailsRelLocalServiceUtil.deleteBlockWeekMetadataDetailsRel(blockWeekMetadataDetailsRel);
			} catch (Exception e) {
				_logger.error(e.getMessage(), e);
			}
		}
		_logger.info("deleteWeekBlocks Exit ::: ");
	}

	private static final Log _logger = LogFactoryUtil.getLog(ProgramCohortUtil.class);
}
