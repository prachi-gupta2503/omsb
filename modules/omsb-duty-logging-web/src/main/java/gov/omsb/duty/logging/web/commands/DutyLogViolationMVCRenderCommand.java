package gov.omsb.duty.logging.web.commands;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.duty.logging.web.constants.DutyLogConfigurationPortletKeys;
import gov.omsb.duty.logging.web.constants.MVCCommandNames;
import gov.omsb.duty.logging.web.dto.CommonDTO;
import gov.omsb.duty.logging.web.util.LogViolationManager;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.common.util.OmsbTmsCommonUtil;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.model.TraineeCohortDetails;
import gov.omsb.tms.model.TraineeLevelMaster;
import gov.omsb.tms.service.ProgramMasterLocalServiceUtil;
import gov.omsb.tms.service.TraineeCohortDetailsLocalServiceUtil;
import gov.omsb.tms.service.TraineeLevelMasterLocalServiceUtil;

@Component(immediate = true, property = {
		"javax.portlet.name=" + DutyLogConfigurationPortletKeys.DUTYHOURSCONFIGURATION,
		"mvc.command.name=" + MVCCommandNames.VIEW_DUTY_LOG_VIOLATION }, service = MVCRenderCommand.class)
public class DutyLogViolationMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		LOGGER.info("DutyLogViolationMVCRenderCommand called");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String languageCode = renderRequest.getLocale().toString();
		LOGGER.info("languageCode =====> " + languageCode);

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
        return DutyLogConfigurationPortletKeys.VIEW_DUTY_LOG_VIOLATIONS;
	}

	public List<CommonDTO> getProgramMasterNameList(String languageCode) {
		List<CommonDTO> programList = new ArrayList<>();
		List<ProgramMaster> programMastersList = ProgramMasterLocalServiceUtil.getProgramMasters(-1, -1);
		for (ProgramMaster master : programMastersList) {
			CommonDTO dto = new CommonDTO();
			String programName = OmsbTmsCommonUtil.getValueByLanguage(master.getProgramName(),
					OmsbTmsCommonConstants.PROGRAM_NAME, languageCode);
			dto.setId(master.getProgramMasterId());
			dto.setName(programName);
			programList.add(dto);
		}
		return programList;
	}

	public List<CommonDTO> getTraineeLevelNameList(String languageCode) {
		List<CommonDTO> traineeLevelList = new ArrayList<>();
		List<TraineeLevelMaster> list = TraineeLevelMasterLocalServiceUtil.getTraineeLevelMasters(-1, -1);
		for (TraineeLevelMaster master : list) {
			CommonDTO dto = new CommonDTO();
			String traineeLevelName = OmsbTmsCommonUtil.getValueByLanguage(master.getTraineeLevelName(),
					OmsbTmsCommonConstants.TRAINEE_LEVEL_NAME, languageCode);
			dto.setId(master.getTraineeLevelMasterId());
			dto.setName(traineeLevelName);
			traineeLevelList.add(dto);
		}
		return traineeLevelList;
	}

	private static final Log LOGGER = LogFactoryUtil.getLog(DutyLogViolationMVCRenderCommand.class);

}
