package gov.omsb.duty.logging.web.portlet;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.duty.logging.web.constants.DutyLogConfigurationPortletKeys;
import gov.omsb.duty.logging.web.dto.CommonDTO;
import gov.omsb.duty.logging.web.dto.DutyAssignmementDTO;
import gov.omsb.duty.logging.web.dto.DutyRuleMasterDTO;
import gov.omsb.duty.logging.web.dto.DutyTypesDTO;
import gov.omsb.duty.logging.web.dto.ProgramDutyAssignmentDTO;
import gov.omsb.duty.logging.web.dto.ProgramDutyRuleDTO;
import gov.omsb.duty.logging.web.util.DutyLoggingService;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.common.util.OmsbTmsCommonUtil;
import gov.omsb.tms.model.DutyAssignment;
import gov.omsb.tms.model.DutyRule;
import gov.omsb.tms.model.DutyTypes;
import gov.omsb.tms.model.ProgramDurationDetails;
import gov.omsb.tms.model.ProgramDutyAssignment;
import gov.omsb.tms.model.ProgramDutyRule;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.service.DutyAssignmentLocalServiceUtil;
import gov.omsb.tms.service.DutyRuleLocalServiceUtil;
import gov.omsb.tms.service.DutyTypesLocalServiceUtil;
import gov.omsb.tms.service.ProgramMasterLocalServiceUtil;

/**
 * @author Admin
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=OMSB",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=DutyLogConfiguration", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/jsp/configuration/view.jsp",
		"javax.portlet.name=" + DutyLogConfigurationPortletKeys.DUTYLOGCONFIGURATION,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class DutyLogConfigurationPortlet extends MVCPortlet {
	private static final Log LOGGER = LogFactoryUtil.getLog(DutyLogConfigurationPortlet.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		LOGGER.info("doView in portelt");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Locale locale = themeDisplay.getLocale();
		List<DutyTypes> dutyTypesList;
		List<DutyTypesDTO> dutyTypesDtoList = null;
		String cmd = "DutyType";
		cmd = ParamUtil.getString(renderRequest, "cmd");
		LOGGER.info("cmd-----------" + cmd);
		switch (cmd) {
		case "DutyType":
			dutyTypesDtoList = getDutyTypesList();
			renderRequest.setAttribute("dutyTypesDtoList", dutyTypesDtoList);
			renderRequest.setAttribute("jspName", DutyLogConfigurationPortletKeys.DUTY_TYPE);
			break;
		case "DutyAssignment":
			List<DutyTypes>dutyTypes = dutyLoggingService.getDutyTypesList();
			List<DutyAssignmementDTO> dutyAssignmementDTOList = getDutyAssignmementDTO();
			LOGGER.info("dutyAssignmementDTOList ------ " + dutyAssignmementDTOList);
			renderRequest.setAttribute("dutyTypes", dutyTypes);
			renderRequest.setAttribute("dutyAssignmementDTOList", dutyAssignmementDTOList);
			renderRequest.setAttribute("jspName", DutyLogConfigurationPortletKeys.NEW_ASSIGNMENT);
			break;
		case "ProgramDutyType":
			LOGGER.info("ProgramDutyType");
			
			renderRequest.setAttribute("jspName", DutyLogConfigurationPortletKeys.PROGRAM_DUTY_TYPE);
			dutyTypesList = dutyLoggingService.getDutyTypesList();
			//List<ProgramMaster> programMasterList = dutyLoggingService.getProgramMasterList();
			List<CommonDTO> programMasterList = getProgramMasterNameList(themeDisplay.getLocale().toString());
			renderRequest.setAttribute("dutyTypesList", dutyTypesList);
			renderRequest.setAttribute("programMasterList", programMasterList);
			List<ProgramDutyAssignmentDTO> programDutyAssignmentList = getProgramDutyAssignmentDTOList(locale);
			renderRequest.setAttribute("programDutyAssignmentList", programDutyAssignmentList);
			break;
		case "DutyRulesForProgram":
			LOGGER.info(cmd.equals("DutyRulesForProgram"));
			//List<ProgramMaster> programMaster = dutyLoggingService.getProgramMasterList();
			List<CommonDTO> programMaster = getProgramMasterNameList(themeDisplay.getLocale().toString());
			List<DutyRuleMasterDTO> dutyRuleList =  getDutyRules();
			renderRequest.setAttribute("dutyRuleList", dutyRuleList);
			renderRequest.setAttribute("programMasterList", programMaster);
			List<ProgramDutyRuleDTO> programDutyRuleList = getProgramDutyRuleDTOList(locale);
			renderRequest.setAttribute("programDutyRuleList", programDutyRuleList);
			renderRequest.setAttribute("jspName", DutyLogConfigurationPortletKeys.DUTY_RULE_FOR_PROGRAM);
			break;
		default:
			dutyTypesDtoList = getDutyTypesList();
			renderRequest.setAttribute("dutyTypesDtoList", dutyTypesDtoList);
			renderRequest.setAttribute("jspName", DutyLogConfigurationPortletKeys.DUTY_TYPE);
			break;
		}
		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		LOGGER.info("Render in portelt");
		super.render(renderRequest, renderResponse);
	}

	public List<DutyAssignmementDTO> getDutyAssignmementDTO() {
		List<DutyAssignmementDTO> dutyAssignmementDTOList = new ArrayList<>();
		List<DutyAssignment> dutyAssignments = DutyAssignmentLocalServiceUtil.getDutyAssignments(-1, -1);
		for (DutyAssignment dutyAssignment : dutyAssignments) {
			if(dutyAssignment.getStatus().equalsIgnoreCase("Active")) {
			DutyAssignmementDTO dutyAssignmementDTO = new DutyAssignmementDTO();
			dutyAssignmementDTO.setDutyAssignmentId(dutyAssignment.getDutyAssignmentId());
			dutyAssignmementDTO.setAssignment(dutyAssignment.getAssignment());
			dutyAssignmementDTO.setColorCode(dutyAssignment.getColorCode());
			DutyTypes dutyTypes = null;
			try {
				dutyTypes = DutyTypesLocalServiceUtil.getDutyTypes(dutyAssignment.getDutyTypeId());
			} catch (PortalException e) {
				e.printStackTrace();
			}
			dutyAssignmementDTO.setDutyType(dutyTypes.getDutyType());
			dutyAssignmementDTOList.add(dutyAssignmementDTO);
		}
		}
		return dutyAssignmementDTOList;
		
	}

	public List<DutyTypesDTO> getDutyTypesList() {
		List<DutyTypesDTO> dutyTypesDtoList = new ArrayList<>();
		List<DutyTypes> dutyTypesList = DutyTypesLocalServiceUtil.getDutyTypeses(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		for (DutyTypes dutyTypes : dutyTypesList) {
			DutyTypesDTO dutyTypesDTO = new DutyTypesDTO();
			if(dutyTypes.getStatus().equalsIgnoreCase("Active")) {
			User user;
			try {
				user = userLocalService.getUser(dutyTypes.getCreatedBy());
				String createdBy = user.getScreenName();
				dutyTypesDTO.setDutyTypeId(dutyTypes.getDutyTypeId());
				dutyTypesDTO.setDutyType(dutyTypes.getDutyType());
				dutyTypesDTO.setCreatedBy(createdBy);
				dutyTypesDtoList.add(dutyTypesDTO);
			} catch (PortalException e) {
				e.printStackTrace();
			}
		}
	}
		return dutyTypesDtoList;
	}

	public List<ProgramDutyAssignmentDTO> getProgramDutyAssignmentDTOList(Locale locale) {
		List<ProgramDutyAssignmentDTO> programDutyAssignmentDTOList = new ArrayList<>();
		List<ProgramDutyAssignment> programDutyAssignmentList = dutyLoggingService.getProgramDutyAssignmentList();
		for (ProgramDutyAssignment programDutyAssignment : programDutyAssignmentList) {
			ProgramDutyAssignmentDTO programDutyAssignmentDTO = new ProgramDutyAssignmentDTO();
			programDutyAssignmentDTO.setProgramDutyAssignmentId(programDutyAssignment.getProgramDutyAssignmentId());
			// get program
			ProgramMaster programMaster = null;
			ProgramDurationDetails cohort = null;
			DutyAssignment dutyAssignment = null;
			DutyTypes dutyTypes = null;
			try {

				programMaster = dutyLoggingService.getProgramByProgramId(programDutyAssignment.getProgramId());
				programDutyAssignmentDTO.setProgram(programMaster.getProgramName(locale));
				// get cohort
				cohort = dutyLoggingService.getCohortListByCohortId(programDutyAssignment.getCohortId());
				programDutyAssignmentDTO.setCohort(cohort.getAyApplicableForm());
				// get assignment
				dutyAssignment = dutyLoggingService
						.getAssignmentListByAssignmentId(programDutyAssignment.getDutyAssignmentId());
				programDutyAssignmentDTO.setDutyAssignment(dutyAssignment.getAssignment());
				// get duty type
				dutyTypes = dutyLoggingService.getDutyTypes(dutyAssignment.getDutyTypeId());
				programDutyAssignmentDTO.setDutyType(dutyTypes.getDutyType());
				programDutyAssignmentDTO.setStatus(programDutyAssignment.getStatus());
				programDutyAssignmentDTOList.add(programDutyAssignmentDTO);
			} catch (PortalException e) {
				e.printStackTrace();
			}

		}
		return programDutyAssignmentDTOList;
	}
	public List<ProgramDutyRuleDTO>getProgramDutyRuleDTOList(Locale locale){
		List<ProgramDutyRuleDTO> programDutyRuleDTOList = new ArrayList<>();
		List<ProgramDutyRule>programDutyRuleList =dutyLoggingService.getProgramDutyRuleList();
		for(ProgramDutyRule programDutyRule:programDutyRuleList) {
			
			ProgramDutyRuleDTO programDutyRuleDTO =new ProgramDutyRuleDTO();
			programDutyRuleDTO.setProgramDutyRuleId(programDutyRule.getProgramDutyRuleId());
			ProgramMaster programMaster = null;
			ProgramDurationDetails cohort = null;
			DutyRule dutyRule =null;
			try {
				programMaster = dutyLoggingService.getProgramByProgramId(programDutyRule.getProgramId());
				programDutyRuleDTO.setProgram(programMaster.getProgramName(locale));
				cohort = dutyLoggingService.getCohortListByCohortId(programDutyRule.getCohortId());
				programDutyRuleDTO.setCohort(cohort.getAyApplicableForm());
				programDutyRuleDTO.setStatus(programDutyRule.getStatus());
				dutyRule=dutyLoggingService.getDutyRule(programDutyRule.getDutyRuleId());
				programDutyRuleDTO.setDutyRule(dutyRule.getRule());
				programDutyRuleDTOList.add(programDutyRuleDTO);
			} catch (PortalException e) {
				e.printStackTrace();
			}
		}
		return programDutyRuleDTOList;
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
			LOGGER.info("programName"+programName);
			
		}
		return programList;
	}
	
	public List<DutyRuleMasterDTO> getDutyRules(){
		List<DutyRuleMasterDTO> dutyRuleList = new ArrayList<DutyRuleMasterDTO>();
		List<DutyRule> dutyRules = DutyRuleLocalServiceUtil.getDutyRules(-1, -1);
		LOGGER.info("DutyRuleMasterDTO List"+dutyRules.size());
		for(DutyRule duty:dutyRules) {
			if(duty.getParentId()==0) {
				DutyRuleMasterDTO dutyRuleMasterDto=new DutyRuleMasterDTO();
				dutyRuleMasterDto.setId(duty.getDutyRuleId());
				dutyRuleMasterDto.setName(duty.getDescription());
				dutyRuleList.add(dutyRuleMasterDto);
			}
		}
		
		for(DutyRuleMasterDTO dutyRuleMasterDto : dutyRuleList) {
			List<DutyRuleMasterDTO> options = new ArrayList<DutyRuleMasterDTO>();
			for(DutyRule duty:dutyRules) {
				if(duty.getParentId() != 0 && dutyRuleMasterDto.getId() == duty.getParentId()) {
					DutyRuleMasterDTO option=new DutyRuleMasterDTO();
					option.setId(duty.getDutyRuleId());
					option.setName(duty.getDescription());
					options.add(option);
				}
			}
			dutyRuleMasterDto.setOptions(options);
		}
			
		return dutyRuleList;
		
	}

	@Reference
	private DutyLoggingService dutyLoggingService;

	@Reference
	private UserLocalService userLocalService;
}