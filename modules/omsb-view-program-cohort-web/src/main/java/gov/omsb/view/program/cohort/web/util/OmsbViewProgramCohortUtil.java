package gov.omsb.view.program.cohort.web.util;

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
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;

import org.osgi.service.component.annotations.Component;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.util.CommonUtil;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.custom.dto.ProgramCohortDTO;
import gov.omsb.tms.model.ProgramDurationDetails;
import gov.omsb.tms.service.ProgramDurationDetailsLocalServiceUtil;
import gov.omsb.view.program.cohort.web.constants.OmsbViewProgramCohortWebPortletKeys;

/**
 * @author Jayesh Goswami
 */
@Component(immediate = true, service = OmsbViewProgramCohortUtil.class)
public class OmsbViewProgramCohortUtil {
	
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
			String portletId = OmsbViewProgramCohortWebPortletKeys.OMSBPROGRAMSWEB;
			long plId = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), portletId);
			PortletURL programListRenderUrl = PortletURLFactoryUtil.getPortletURLFactory().create(request, portletId, plId,
					PortletRequest.RENDER_PHASE);
			programListRenderUrl.getRenderParameters().setValue("p_p_state", "normal");
			programListRenderUrl.getRenderParameters().setValue("p_p_mode", "view");
			programListRenderUrl.getRenderParameters().setValue(OmsbViewProgramCohortWebPortletKeys.MVC_RENDER_COMMAND_NAME, "/program-details");
			programListRenderUrl.getRenderParameters().setValue("programMasterId", String.valueOf(programMasterId));
			renderUrlStr = programListRenderUrl.toString();
		} catch (PortalException e) {
			_logger.error("createProgramDetailsPageRenderUrl Error ::: " + e);
		}
		_logger.info("createProgramDetailsPageRenderUrl Exit ::: ");
		return renderUrlStr;
	}
	
	public void prepareActionData(List<ProgramCohortDTO> programCohortDTOs, ThemeDisplay themeDisplay, ResourceRequest request) {
		_logger.info("prepareActionData Invoked ::: ");
		long currentYear = (Calendar.getInstance()).get(Calendar.YEAR);
		ProgramDurationDetails durationDetails = null;
		try {
			if(programCohortDTOs != null && !programCohortDTOs.isEmpty()) {
				durationDetails = ProgramDurationDetailsLocalServiceUtil.getProgramDurationDetails(programCohortDTOs.get(0).getProgramDurationId());
				if(Validator.isNotNull(durationDetails)) {
					long durationYear = Long.parseLong(durationDetails.getAyApplicableForm().split(StringPool.DASH)[0]);
					programCohortDTOs = programCohortDTOs.stream().sorted((o1, o2)-> Long.compare(o1.getTraineeLevelId(), o2.getTraineeLevelId())).collect(Collectors.toList());
					for(ProgramCohortDTO dto : programCohortDTOs) {
						JSONObject action = JSONFactoryUtil.createJSONObject();
						if(durationYear == currentYear) {
							// Temporary commented below line , removed it once leave module work properly
							// action.put(OmsbTmsCommonConstants.IS_ALL_TRAINEE_TAKEN_LEAVE_FOR_CURRENT_YEAR, OmsbTmsCommonUtil.isAllTraineeTakenLeaveForCurrentYear(dto.getProgramDurationId(), dto.getTraineeLevelId()));
							action.put(OmsbTmsCommonConstants.IS_ALL_TRAINEE_TAKEN_LEAVE_FOR_CURRENT_YEAR, Boolean.TRUE);
							
							action.put(OmsbTmsCommonConstants.PROGDURATION_TLBLOCKS_LT_ID, dto.getProgdurationTlBlocksLtId());
							action.put(OmsbTmsCommonConstants.PROGRAM_MASTER_ID, dto.getProgramMasterId());
							action.put(OmsbTmsCommonConstants.IS_CURRENT_YEAR_TRAINEE_LEVEL,  true);
								action.put(OmsbTmsCommonConstants.SCHEDULE_MASTER_ROTATION_RENDER_URL, createScheduleMasterRotationRenderUrl(themeDisplay, request, dto));
							dto.setActions(action.toJSONString());
						} else {
							action.put(OmsbTmsCommonConstants.IS_CURRENT_YEAR_TRAINEE_LEVEL,  false);
						}
						durationYear++;
						dto.setActions(action.toJSONString());
					}
				}
			}
		} catch (Exception e) {
			_logger.error(e);
		}
		_logger.info("prepareActionData Exit ::: ");
	}
	
	@SuppressWarnings("deprecation")
	public String createScheduleMasterRotationRenderUrl(ThemeDisplay themeDisplay, ResourceRequest request, ProgramCohortDTO dto) {
		_logger.info("createScheduleMasterRotationRenderUrl Invoked ::: ");
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
			_logger.error("createScheduleMasterRotationRenderUrl Error ::: " + e);
		}
		_logger.info("createScheduleMasterRotationRenderUrl Exit ::: ");
		return renderUrlStr;
	}
	
	public boolean prepareResponseJsonForProgramCohortDTOs(ResourceRequest resourceRequest, ResourceResponse resourceResponse, List<ProgramCohortDTO> programCohortDTOs) {
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
	
	public static List<String> getYearRangeForSearch(long totalProgramDurationCount, ResourceRequest resourceRequest) {
		_logger.info("getYearRangeForSearch Invoked :::");
		
		long yearFrom = ParamUtil.getLong(resourceRequest, OmsbViewProgramCohortWebPortletKeys.YEAR_FROM, 0);
		long yearTo = ParamUtil.getLong(resourceRequest, OmsbViewProgramCohortWebPortletKeys.YEAR_TO, 0);
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
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbViewProgramCohortUtil.class);
}