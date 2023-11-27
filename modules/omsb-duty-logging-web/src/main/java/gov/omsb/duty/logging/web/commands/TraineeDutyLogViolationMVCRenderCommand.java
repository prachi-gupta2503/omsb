package gov.omsb.duty.logging.web.commands;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.duty.logging.web.constants.DutyLogConfigurationPortletKeys;
import gov.omsb.duty.logging.web.constants.DutyLoggingConstants;
import gov.omsb.duty.logging.web.constants.MVCCommandNames;
import gov.omsb.duty.logging.web.dto.DutyLogViolationListDTO;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.common.util.OmsbTmsCommonUtil;
import gov.omsb.tms.custom.dto.DutyLogViolationDTO;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.model.RotationMaster;
import gov.omsb.tms.model.TraineeLevelMaster;
import gov.omsb.tms.model.TrainingSitesMaster;
import gov.omsb.tms.service.DutyLogViolationLocalService;
import gov.omsb.tms.service.ProgramMasterLocalServiceUtil;
import gov.omsb.tms.service.RotationMasterLocalServiceUtil;
import gov.omsb.tms.service.TraineeLevelMasterLocalServiceUtil;
import gov.omsb.tms.service.TrainingSitesMasterLocalServiceUtil;

@Component(immediate = true, property = {
		"javax.portlet.name=" + DutyLogConfigurationPortletKeys.DUTYHOURSCONFIGURATION,
		"javax.portlet.name=" + DutyLogConfigurationPortletKeys.DUTYLOGHOURS,
		"mvc.command.name=" + MVCCommandNames.TRAINEE_VIEW_DUTY_LOG_VIOLATION }, service = MVCRenderCommand.class)
public class TraineeDutyLogViolationMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		boolean isTraineeCalendarView = ParamUtil.getBoolean(renderRequest,
				DutyLoggingConstants.IS_TRAINEE_CALENDAR_VIEW);

		long userId = themeDisplay.getUserId();
		LOGGER.info("userId ------>" + userId);
		List<Role> userRoles = RoleLocalServiceUtil.getUserRoles(userId);
		List<DutyLogViolationDTO> dutyLogViolationList = dutyLogViolationLocalService
				.getDutyLogViolationListByUserId(userId);
		LOGGER.info("dutyLogViolationList" + dutyLogViolationList.size());
		LOGGER.info("dutyLogViolationList" + dutyLogViolationList);
		List<DutyLogViolationListDTO> dutyLogViolationDTOList = getDutyLogViolationDTOList(
				themeDisplay.getLocale().toString(), dutyLogViolationList);
		LOGGER.info("dutyLogViolationDTOList ===========> " + dutyLogViolationDTOList);
		renderRequest.setAttribute("dutyLogViolationDTOList", dutyLogViolationDTOList);
		renderRequest.setAttribute(DutyLoggingConstants.IS_TRAINEE_CALENDAR_VIEW, isTraineeCalendarView);
		return DutyLogConfigurationPortletKeys.TRAINEE_VIEW_DUTY_LOG_VIOLATIONS;
	}

	public List<DutyLogViolationListDTO> getDutyLogViolationDTOList(String languageCode,
			List<DutyLogViolationDTO> dutyLogViolationDTOList) {
		List<DutyLogViolationListDTO> list = new ArrayList<>();
		for (DutyLogViolationDTO dutyLogViolationDTO : dutyLogViolationDTOList) {

			try {
				ProgramMaster programMaster = ProgramMasterLocalServiceUtil
						.getProgramMaster(dutyLogViolationDTO.getProgramId());
				TraineeLevelMaster traineeLevelMaster = TraineeLevelMasterLocalServiceUtil
						.getTraineeLevelMaster(dutyLogViolationDTO.getTraineeLevelId());
				RotationMaster rotationMaster = RotationMasterLocalServiceUtil
						.getRotationMaster(dutyLogViolationDTO.getRotationId());
				TrainingSitesMaster trainingSitesMaster = TrainingSitesMasterLocalServiceUtil
						.getTrainingSitesMaster(dutyLogViolationDTO.getTraineeSiteId());
				String blockNo = dutyLogViolationDTO.getBlockNo();
				String rotationName = OmsbTmsCommonUtil.getValueByLanguage(rotationMaster.getRotationName(),
						OmsbTmsCommonConstants.ROTATION_NAME, languageCode);
				String trainingSitesName = OmsbTmsCommonUtil.getValueByLanguage(
						trainingSitesMaster.getTrainingSiteName(), OmsbTmsCommonConstants.TRAINING_SITE_NAME,
						languageCode);
				DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
				String date = dateFormat.format(dutyLogViolationDTO.getBlockStartDate()) + "-"
						+ dateFormat.format(dutyLogViolationDTO.getBlockEndDate());
				JSONObject responseObj = JSONFactoryUtil.createJSONObject();

				DutyLogViolationListDTO dto = new DutyLogViolationListDTO();
				dto.setProgram(OmsbTmsCommonUtil.getValueByLanguage(programMaster.getProgramName(),
						OmsbTmsCommonConstants.PROGRAM_NAME, languageCode));
				dto.setResidencyLevel(OmsbTmsCommonUtil.getValueByLanguage(traineeLevelMaster.getTraineeLevelName(),
						OmsbTmsCommonConstants.TRAINEE_LEVEL_NAME, languageCode));
				dto.setRotaionTrainingName(rotationName + "-" + trainingSitesName);
				dto.setBlockNo(blockNo);
				dto.setDate(date);

				LOGGER.info("acgme80HoursRule" + dutyLogViolationDTO.getAcgme80HoursRule());
				LOGGER.info("acgme24HoursRule" + dutyLogViolationDTO.getAcgme24HoursRule());
				LOGGER.info("acgmeCallRuleOption1" + dutyLogViolationDTO.getAcgmeCallRuleOption1());
				LOGGER.info("acgmeCallRuleOption2" + dutyLogViolationDTO.getAcgmeCallRuleOption2());
				LOGGER.info("acgmeShortBreakRule" + dutyLogViolationDTO.getAcgmeShortBreakRule());
				LOGGER.info("acgmeDayOffRule" + dutyLogViolationDTO.getAcgmeDayOffRule());

				dto.setAcgme80HoursRule(dutyLogViolationDTO.getAcgme80HoursRule());
				dto.setAcgme24HoursRule(dutyLogViolationDTO.getAcgme24HoursRule());
				dto.setAcgmeCallRuleOption1(dutyLogViolationDTO.getAcgmeCallRuleOption1());
				dto.setAcgmeCallRuleOption2(dutyLogViolationDTO.getAcgmeCallRuleOption2());
				dto.setAcgmeShortBreakRule(dutyLogViolationDTO.getAcgmeShortBreakRule());
				dto.setAcgmeDayOffRule(dutyLogViolationDTO.getAcgmeDayOffRule());

				list.add(dto);
				LOGGER.info("dto ----------->" + dto);
			} catch (PortalException e) {
				e.printStackTrace();
			}

		}

		return list;

	}

	@Reference
	private DutyLogViolationLocalService dutyLogViolationLocalService;
	private static final Log LOGGER = LogFactoryUtil.getLog(TraineeDutyLogViolationMVCRenderCommand.class);

}
