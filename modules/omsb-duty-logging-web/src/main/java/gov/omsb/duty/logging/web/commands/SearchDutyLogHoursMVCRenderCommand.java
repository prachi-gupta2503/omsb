package gov.omsb.duty.logging.web.commands;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.duty.logging.web.constants.DutyLogConfigurationPortletKeys;
import gov.omsb.duty.logging.web.dto.DutyLogDTO;
import gov.omsb.duty.logging.web.util.LogViolationManager;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.common.util.OmsbTmsCommonUtil;
import gov.omsb.tms.custom.dto.DutyLogHoursDTO;
import gov.omsb.tms.model.DutyAssignment;
import gov.omsb.tms.model.DutyTypes;
import gov.omsb.tms.model.ProgramDutyAssignment;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.service.DutyAssignmentLocalServiceUtil;
import gov.omsb.tms.service.DutyLogLocalService;
import gov.omsb.tms.service.DutyTypesLocalServiceUtil;
import gov.omsb.tms.service.ProgramDutyAssignmentLocalServiceUtil;
import gov.omsb.tms.service.ProgramMasterLocalServiceUtil;

@Component(immediate = true, property = {
		"javax.portlet.name=" + DutyLogConfigurationPortletKeys.DUTYHOURSCONFIGURATION,
		"mvc.command.name=/search/logDutyHoursData" }, service = MVCResourceCommand.class)
public class SearchDutyLogHoursMVCRenderCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		LOGGER.info("SearchDutyLogHoursMVCRenderCommand called");

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();
		long createdBy = themeDisplay.getUserId();

		String startDate = ParamUtil.getString(resourceRequest, "startDate");
		String endDate = ParamUtil.getString(resourceRequest, "endDate");
		Long traineeCohortDetailsId = ParamUtil.getLong(resourceRequest, "traineeCohortDetailsId");
		Long programMasterId = ParamUtil.getLong(resourceRequest, "programMasterId");
		Long traineeId = ParamUtil.getLong(resourceRequest, "traineeId");
		long traineeLevelId = ParamUtil.getLong(resourceRequest, "traineeLevelId");

		LOGGER.info("groupId : =======> " + groupId);
		LOGGER.info("createdBy : =======> " + createdBy);
		LOGGER.info("traineeLevelId : =======> " + traineeLevelId);
		LOGGER.info("programMasterId : =======> " + programMasterId);
		LOGGER.info("traineeId : =======> " + traineeId);
		LOGGER.info("traineeCohortDetailsId : =======> " + traineeCohortDetailsId);
		LOGGER.info("startDate : =======> " + startDate);
		LOGGER.info("endDate : =======> " + endDate);

		if (traineeLevelId == 0 && programMasterId == 0 && traineeId == 0 && traineeCohortDetailsId == 0
				&& startDate.isEmpty() && endDate.isEmpty() ) {
			LOGGER.info("Inside if");
		} else {

			List<DutyLogHoursDTO> dutyLogHours = dutyLogLocalService.getDutyLogHours(programMasterId,
					traineeCohortDetailsId, traineeLevelId, traineeId, startDate, endDate);
			LOGGER.info(" dutyLogHours------------->" + dutyLogHours);
			jsonArray = getLogDutyDTOList(themeDisplay.getLocale().toString(), dutyLogHours);
			LOGGER.info("jsonArray  -----> " + jsonArray);
		}
		try {
			JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, jsonArray);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	public JSONArray getLogDutyDTOList(String languageCode, List<DutyLogHoursDTO> dutyLogHoursDTOList) {
		List<DutyLogDTO> dutyLogDTOList = new ArrayList<>();
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (DutyLogHoursDTO dutyLog : dutyLogHoursDTOList) {
			try {
				long dutyLogId = dutyLog.getDutyLogId();

				/*
				 * TrainingSitesMaster trainingSitesMaster = TrainingSitesMasterLocalServiceUtil
				 * .getTrainingSitesMaster(dutyLog.getTraineeId());
				 */
				ProgramDutyAssignment programDutyAssignment = ProgramDutyAssignmentLocalServiceUtil
						.getProgramDutyAssignment(dutyLog.getProgramDutyAssignmentId());
				ProgramMaster programMaster = ProgramMasterLocalServiceUtil
						.getProgramMaster(programDutyAssignment.getProgramId());
				String programName = OmsbTmsCommonUtil.getValueByLanguage(programMaster.getProgramName(),
						OmsbTmsCommonConstants.PROGRAM_NAME, languageCode);
				LOGGER.info("programName =====> " + programName);
				DutyAssignment dutyAssignment = DutyAssignmentLocalServiceUtil
						.getDutyAssignment(programDutyAssignment.getDutyAssignmentId());
				DutyTypes dutyTypes = DutyTypesLocalServiceUtil.getDutyTypes(dutyAssignment.getDutyTypeId());
				Date startDate = dutyLog.getStartDate();
				Date endDate = dutyLog.getEndDate();
				long Time_difference = endDate.getTime() - startDate.getTime();
				DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
				final int MILLI_TO_HOUR = 1000 * 60 * 60;
				int duration = (int) ((Time_difference) / MILLI_TO_HOUR);
				long Hours_difference = TimeUnit.MILLISECONDS.toHours(Time_difference) % 24;

				LOGGER.info("startDate =====> " + startDate);
				LOGGER.info("endDate =====> " + endDate);
				LOGGER.info("Time_difference =====> " + Time_difference);
				LOGGER.info("duration =====> " + duration);
				LOGGER.info("dateFormat.format(startDate) =====> " + LogViolationManager.formateDate(startDate));
				LOGGER.info("dateFormat.format(endDate =====> " + LogViolationManager.formateDate(endDate));
				LOGGER.info("startDate =====> " + startDate);
				LOGGER.info("endDate =====> " + endDate);
				LOGGER.info("dutyTypes.getDutyType() =====> " + dutyTypes.getDutyType());
				LOGGER.info("dutyAssignment.getAssignment() =====> " + dutyAssignment.getAssignment());

				JSONObject responseObj = JSONFactoryUtil.createJSONObject();
				responseObj.put("dutyLogId", dutyLogId);
				responseObj.put("program", OmsbTmsCommonUtil.getValueByLanguage(programMaster.getProgramName(),
						OmsbTmsCommonConstants.PROGRAM_NAME, languageCode));
				responseObj.put("dutyType", dutyTypes.getDutyType());
				responseObj.put("assignment", dutyAssignment.getAssignment());
				responseObj.put("startDate", formateDate(startDate).toString());
				responseObj.put("endDate", formateDate(endDate));
				responseObj.put("duration", duration);
				responseObj.put("trainingCenter", "trainingCenter");
				jsonArray.put(responseObj);
				LOGGER.info("jsonArray =====> " + jsonArray);

			} catch (PortalException e) {

				e.printStackTrace();
			}

		}
		 
		LOGGER.info("jsonArray ===========>" + jsonArray);
		return jsonArray;

	}

	
	public String formateDate(Date date){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
		dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		SimpleDateFormat outputDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String formattedDate = null;
		try {
			formattedDate = outputDateFormat.format(dateFormat.parse(date.toString()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return formattedDate;
	   }
	   
	private static final Log LOGGER = LogFactoryUtil.getLog(SearchDutyLogHoursMVCRenderCommand.class);

	@Reference
	private DutyLogLocalService dutyLogLocalService;
}
