package gov.omsb.duty.logging.web.commands;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import gov.omsb.duty.logging.web.constants.DutyLogConfigurationPortletKeys;
import gov.omsb.duty.logging.web.constants.MVCCommandNames;
import gov.omsb.duty.logging.web.dto.DutyLogDTO;
import gov.omsb.duty.logging.web.dto.DutyLogHoursDTO;
import gov.omsb.duty.logging.web.util.LogViolationManager;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.common.util.OmsbTmsCommonUtil;
import gov.omsb.tms.model.DutyAssignment;
import gov.omsb.tms.model.DutyLog;
import gov.omsb.tms.model.DutyLogViolation;
import gov.omsb.tms.model.DutyTypes;
import gov.omsb.tms.model.ProgramDutyAssignment;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.model.TrainingSitesMaster;
import gov.omsb.tms.service.DutyAssignmentLocalServiceUtil;
import gov.omsb.tms.service.DutyLogLocalServiceUtil;
import gov.omsb.tms.service.DutyLogViolationLocalServiceUtil;
import gov.omsb.tms.service.DutyTypesLocalServiceUtil;
import gov.omsb.tms.service.ProgramDutyAssignmentLocalServiceUtil;
import gov.omsb.tms.service.ProgramMasterLocalServiceUtil;
import gov.omsb.tms.service.TrainingSitesMasterLocalServiceUtil;

@Component(immediate = true, property = {
		"javax.portlet.name=" + DutyLogConfigurationPortletKeys.DUTYHOURSCONFIGURATION,
		"mvc.command.name=" + MVCCommandNames.VIEW_DUTY_LOG_HOURS }, service = MVCRenderCommand.class)
public class ViewDutyLogHoursMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		LOGGER.info("ViewDutyLogHoursMVCRenderCommand called");
		long dutyLogId = ParamUtil.getLong(renderRequest, "dutyLogId");
		// long dutyLogId = ParamUtil.getLong(renderRequest, "dutyLogId");
		String languageCode = renderRequest.getLocale().toString();
		LOGGER.info("dutyLogId =====> " + dutyLogId);
		DutyLog dutyLog = null;
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		try {
			dutyLog = DutyLogLocalServiceUtil.getDutyLog(dutyLogId);
			DutyLogDTO dutyLogHoursDTO = getLogDutyDTOList(languageCode, dutyLog);
			LOGGER.info("dutyLogHoursDTO===============> " + dutyLogHoursDTO);
			renderRequest.setAttribute("dutyLogHoursDTO", dutyLogHoursDTO);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		LOGGER.info("After Try Catch");

		return DutyLogConfigurationPortletKeys.VIEW_DUTY_LOG_HOURS;
	}

	public DutyLogDTO getLogDutyDTOList(String languageCode, DutyLog dutyLog) {
		DutyLogDTO dutyLogDTO = new DutyLogDTO();
		LOGGER.info("dutyLogs List ================================================== " + dutyLog);

		try {
			long dutyLogId = dutyLog.getDutyLogId();
			DutyLogViolation dutyLogViolation = DutyLogViolationLocalServiceUtil.findByTraineeId(dutyLog.getTraineeId());
			
			  TrainingSitesMaster trainingSitesMaster = TrainingSitesMasterLocalServiceUtil
			  .getTrainingSitesMaster(dutyLogViolation.getTrainingSiteId());
			 
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
			Boolean multiDays = dutyLog.getMultiDays();
			Date startDate = dutyLog.getStartDate();
			Date endDate = dutyLog.getEndDate();
			long Time_difference = endDate.getTime() - startDate.getTime();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
			final int MILLI_TO_HOUR = 1000 * 60 * 60;
			int duration = (int) ((Time_difference) / MILLI_TO_HOUR);
			long Hours_difference = TimeUnit.MILLISECONDS.toHours(Time_difference) % 24;
			LOGGER.info("multiDays =====> " + multiDays);
			LOGGER.info("startDate =====> " + startDate);
			LOGGER.info("endDate =====> " + endDate);
			LOGGER.info("Time_difference =====> " + Time_difference);
			LOGGER.info("duration =====> " + duration);
			LOGGER.info("dateFormat.format(startDate) =====> " + LogViolationManager.formateDate(startDate));
			LOGGER.info("dateFormat.format(endDate =====> " + LogViolationManager.formateDate(startDate));
			LOGGER.info("endDate =====> " + endDate);
			LOGGER.info("dutyTypes.getDutyType() =====> " + dutyTypes.getDutyType());
			LOGGER.info("dutyAssignment.getAssignment() =====> " + dutyAssignment.getAssignment());

			dutyLogDTO.setDutyLogId(dutyLogId);
			dutyLogDTO.setProgram(OmsbTmsCommonUtil.getValueByLanguage(programMaster.getProgramName(),
					OmsbTmsCommonConstants.PROGRAM_NAME, languageCode));
			dutyLogDTO.setDutyType(dutyTypes.getDutyType());
			dutyLogDTO.setAssignment(dutyAssignment.getAssignment());
			dutyLogDTO.setStartDate(formateDate(startDate));
			dutyLogDTO.setEndDate(formateDate(endDate));
			dutyLogDTO.setDuration(duration);
			dutyLogDTO.setTrainingCenter(OmsbTmsCommonUtil.getValueByLanguage(trainingSitesMaster.getTrainingSiteName(),
					OmsbTmsCommonConstants.TRAINING_SITE_NAME, languageCode));

		} catch (PortalException e) {

			e.printStackTrace();
		}

		return dutyLogDTO;

	}
   public String formateDate(Date date){
	SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss 'GMT' yyyy", Locale.ENGLISH);
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
   
	private static final Log LOGGER = LogFactoryUtil.getLog(ViewDutyLogHoursMVCRenderCommand.class);

}
