package gov.omsb.duty.logging.web.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.common.service.util.UserMetadataUtil;
import gov.omsb.duty.logging.web.constants.DutyLogConfigurationPortletKeys;
import gov.omsb.duty.logging.web.dto.CommonDTO;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.common.util.OmsbTmsCommonUtil;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.model.TraineeCohortDetails;
import gov.omsb.tms.model.TraineeLevelMaster;
import gov.omsb.tms.service.ProgramMasterLocalServiceUtil;
import gov.omsb.tms.service.TraineeCohortDetailsLocalServiceUtil;
import gov.omsb.tms.service.TraineeLevelMasterLocalServiceUtil;

/**
 * @author Dell
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=OMSB",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=DutyHoursConfiguration", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=" + DutyLogConfigurationPortletKeys.VIEW_DUTY_LOG_HOURS_ADMIN,
		"javax.portlet.name=" + DutyLogConfigurationPortletKeys.DUTYHOURSCONFIGURATION,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class DutyHoursConfigurationPortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		String languageCode = renderRequest.getLocale().toString();
		LOGGER.info("languageCode =====> " + languageCode);
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Role role = null;
		try {
			role = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleNameConstants.TRAINEE);
		} catch (PortalException e1) {
			e1.printStackTrace();
		}
		List<User> traineeUsersList = UserLocalServiceUtil.getRoleUsers(role.getRoleId());
		List<TraineeCohortDetails> traineeCohortDetailsList = TraineeCohortDetailsLocalServiceUtil
				.getTraineeCohortDetailses(-1, -1);
		renderRequest.setAttribute("programMastersList", getProgramMasterNameList(languageCode));
		//renderRequest.setAttribute("traineeUsersList", traineeUsersList);
		//renderRequest.setAttribute("traineeCohortDetailsList", traineeCohortDetailsList);
		//renderRequest.setAttribute("traineeLevelList", getTraineeLevelNameList(languageCode));
		LOGGER.info("End Of DutyHoursConfigurationPortlet");

		super.doView(renderRequest, renderResponse);
	}

	public List<CommonDTO> getProgramMasterNameList(String languageCode) {
		LOGGER.info("getProgramMasterNameList started ");

		List<CommonDTO> programList = new ArrayList<>();
		List<ProgramMaster> programMastersList = ProgramMasterLocalServiceUtil.getProgramMasters(-1, -1);
		for (ProgramMaster master : programMastersList) {
			LOGGER.info("Program Master : "+master);

			CommonDTO dto = new CommonDTO();
			String programName = OmsbTmsCommonUtil.getValueByLanguage(master.getProgramName(),
					OmsbTmsCommonConstants.PROGRAM_NAME, languageCode);
			dto.setId(master.getProgramMasterId());
			dto.setName(programName);
			programList.add(dto);
		}
		LOGGER.info("Program Master List : "+programList);
		return programList;
	}

	public List<CommonDTO> getTraineeLevelNameList(String languageCode) {
		LOGGER.info("getTraineeLevelNameList started ");
		
		List<CommonDTO> traineeLevelList = new ArrayList<>();
		List<TraineeLevelMaster> list = TraineeLevelMasterLocalServiceUtil.getTraineeLevelMasters(-1, -1);
		for (TraineeLevelMaster master : list) {
			LOGGER.info("Trainee Level  Master : "+master);
			CommonDTO dto = new CommonDTO();
			String traineeLevelName = OmsbTmsCommonUtil.getValueByLanguage(master.getTraineeLevelName(),
					OmsbTmsCommonConstants.TRAINEE_LEVEL_NAME, languageCode);
			dto.setId(master.getTraineeLevelMasterId());
			dto.setName(traineeLevelName);
			traineeLevelList.add(dto);
		}
		LOGGER.info("Trainee Level Master List : "+traineeLevelList);
		return traineeLevelList;
	}

	/*
	 * public List<DutyLogHoursDTO> getLogDutyDTOList(String languageCode) {
	 * List<DutyLogHoursDTO> dutyLogHoursDTOList = new ArrayList<>(); List<DutyLog>
	 * dutyLogs = DutyLogLocalServiceUtil.getDutyLogs(-1, -1); LOGGER.
	 * info("dutyLogs List ================================================== " +
	 * dutyLogs); for (DutyLog dutyLog : dutyLogs) { try { long dutyLogId =
	 * dutyLog.getDutyLogId();
	 * 
	 * TrainingSitesMaster trainingSitesMaster = TrainingSitesMasterLocalServiceUtil
	 * .getTrainingSitesMaster(dutyLog.getTraineeId());
	 * 
	 * ProgramDutyAssignment programDutyAssignment =
	 * ProgramDutyAssignmentLocalServiceUtil
	 * .getProgramDutyAssignment(dutyLog.getProgramDutyAssignmentId());
	 * ProgramMaster programMaster = ProgramMasterLocalServiceUtil
	 * .getProgramMaster(programDutyAssignment.getProgramId()); String programName =
	 * OmsbTmsCommonUtil.getValueByLanguage(programMaster.getProgramName(),
	 * OmsbTmsCommonConstants.PROGRAM_NAME, languageCode);
	 * LOGGER.info("programName =====> " + programName); DutyAssignment
	 * dutyAssignment = DutyAssignmentLocalServiceUtil
	 * .getDutyAssignment(programDutyAssignment.getDutyAssignmentId()); DutyTypes
	 * dutyTypes =
	 * DutyTypesLocalServiceUtil.getDutyTypes(dutyAssignment.getDutyTypeId());
	 * Boolean multiDays = dutyLog.getMultiDays(); Date startDate =
	 * dutyLog.getStartDate(); Date endDate = dutyLog.getEndDate(); long
	 * Time_difference = endDate.getTime() - startDate.getTime(); DateFormat
	 * dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss"); final int
	 * MILLI_TO_HOUR = 1000 * 60 * 60; int duration = (int) ((Time_difference) /
	 * MILLI_TO_HOUR); long Hours_difference =
	 * TimeUnit.MILLISECONDS.toHours(Time_difference) % 24;
	 * LOGGER.info("multiDays =====> " + multiDays); LOGGER.info("startDate =====> "
	 * + startDate); LOGGER.info("endDate =====> " + endDate);
	 * LOGGER.info("Time_difference =====> " + Time_difference);
	 * LOGGER.info("duration =====> " + duration);
	 * LOGGER.info("dateFormat.format(startDate) =====> " +
	 * dateFormat.format(startDate));
	 * LOGGER.info("dateFormat.format(endDate =====> " +
	 * dateFormat.format(endDate)); LOGGER.info("endDate =====> " + endDate);
	 * LOGGER.info("dutyTypes.getDutyType() =====> " + dutyTypes.getDutyType());
	 * LOGGER.info("dutyAssignment.getAssignment() =====> " +
	 * dutyAssignment.getAssignment());
	 * 
	 * DutyLogHoursDTO dutyLogHouursDTO = new DutyLogHoursDTO();
	 * dutyLogHouursDTO.setDutyLogId(dutyLogId);
	 * dutyLogHouursDTO.setProgram(OmsbTmsCommonUtil.getValueByLanguage(
	 * programMaster.getProgramName(), OmsbTmsCommonConstants.PROGRAM_NAME,
	 * languageCode)); dutyLogHouursDTO.setDutyType(dutyTypes.getDutyType());
	 * dutyLogHouursDTO.setAssignment(dutyAssignment.getAssignment());
	 * dutyLogHouursDTO.setStartDate(dateFormat.format(startDate));
	 * dutyLogHouursDTO.setEndDate(dateFormat.format(endDate));
	 * dutyLogHouursDTO.setDuration(duration);
	 * dutyLogHoursDTOList.add(dutyLogHouursDTO); } catch (PortalException e) {
	 * 
	 * e.printStackTrace(); }
	 * 
	 * } return dutyLogHoursDTOList;
	 * 
	 * }
	 * 
	 * public List<ProgramDTO> getProgramList(String languageCode) {
	 * LOGGER.info("====== getProgramList called =====> " + languageCode);
	 * 
	 * Role role =null; try { role =
	 * RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(),
	 * RoleNameConstants.TRAINEE); } catch (PortalException e1) { // TODO
	 * Auto-generated catch block e1.printStackTrace(); } List<ProgramMaster>
	 * programMasters = ProgramMasterLocalServiceUtil.getProgramMasters(-1, -1);
	 * List<User> roleUsers = UserLocalServiceUtil.getRoleUsers(role.getRoleId());
	 * List<DutyTypes> dutyTypeses =
	 * DutyTypesLocalServiceUtil.getDutyTypeses(-1,-1);
	 * 
	 * 
	 * List<ProgramDTO> programDTOList = new ArrayList<>(); List<DutyLog> dutyLogs =
	 * DutyLogLocalServiceUtil.getDutyLogs(-1, -1); for (DutyLog dutyLog : dutyLogs)
	 * { try {
	 * 
	 * ProgramDTO programDTO = new ProgramDTO(); long dutyLogId =
	 * dutyLog.getDutyLogId(); ProgramDutyAssignment programDutyAssignment =
	 * ProgramDutyAssignmentLocalServiceUtil
	 * .getProgramDutyAssignment(dutyLog.getProgramDutyAssignmentId());
	 * ProgramMaster programMaster = ProgramMasterLocalServiceUtil
	 * .getProgramMaster(programDutyAssignment.getProgramId()); String programName =
	 * OmsbTmsCommonUtil.getValueByLanguage(programMaster.getProgramName(),
	 * OmsbTmsCommonConstants.PROGRAM_NAME, languageCode);
	 * programDTO.setProgramId(programDutyAssignment.getProgramDutyAssignmentId());
	 * programDTO.setProgramName(programName); programDTOList.add(programDTO); }
	 * catch (PortalException e) {
	 * 
	 * e.printStackTrace(); }
	 * 
	 * } return programDTOList;
	 * 
	 * }
	 * 
	 */

	@Reference
	private UserMetadataUtil userMetadataUtil;

	private static final Log LOGGER = LogFactoryUtil.getLog(DutyHoursConfigurationPortlet.class);

}