package omsb.residents.rotating.per.training.site.report.web.portlet;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.tms.custom.dto.ResidentReportDTO;
import gov.omsb.tms.service.EcMemberRequestLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;
import omsb.residents.rotating.per.training.site.report.web.constants.OmsbResidentsRotatingPerTrainingSiteReportPortletKeys;
import omsb.residents.rotating.per.training.site.report.web.constants.OmsbResidentsRotatingPerTrainingSiteReportWebConstants;
import omsb.residents.rotating.per.training.site.report.web.dto.FacultiesAndTraineesPerRotationDTO;
import omsb.residents.rotating.per.training.site.report.web.dto.FacultyTypeAndCountDTO;
import omsb.residents.rotating.per.training.site.report.web.dto.ResidentsInEachSitePerBlockDTO;

/**
 * @author Admin
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=OmsbResidentsRotatingPerTrainingSiteReport",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + OmsbResidentsRotatingPerTrainingSiteReportPortletKeys.OMSBRESIDENTSROTATINGPERTRAININGSITEREPORT,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class OmsbResidentsRotatingPerTrainingSiteReportPortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		long programId = 0;
		String annualYear = StringPool.BLANK;
		String programName = StringPool.BLANK;
		
		try {
			if(Validator.isNotNull(httpRequest.getParameter(OmsbResidentsRotatingPerTrainingSiteReportWebConstants.PROGRAM_ID))) {
				programId = Long.parseLong(httpRequest.getParameter(OmsbResidentsRotatingPerTrainingSiteReportWebConstants.PROGRAM_ID));
			}
			if(Validator.isNotNull(httpRequest.getParameter(OmsbResidentsRotatingPerTrainingSiteReportWebConstants.ACADEMIC_YEAR))) {
				annualYear = httpRequest.getParameter(OmsbResidentsRotatingPerTrainingSiteReportWebConstants.ACADEMIC_YEAR);
			}
			programName = programMasterLocalService.getProgramMaster(programId).getProgramName(themeDisplay.getLocale());
		} catch (Exception e) {
			log.debug(e.getLocalizedMessage());
		}
		
		if(Validator.isBlank(annualYear)) {
			annualYear = String.valueOf(Year.now().getValue() + StringPool.DASH + (Year.now().getValue()+1));
		}
		
		
		List<ResidentReportDTO> residentReportDTOList;
		List<ResidentsInEachSitePerBlockDTO> residentsInEachSitePerBlockDTOList = new ArrayList<>();
		
		
		Map<Long, ResidentsInEachSitePerBlockDTO> reportViewMap = new HashMap<>();

		
		residentReportDTOList = ecMemberRequestLocalService.getResidentsInEachSitePerBlock(programId,annualYear,themeDisplay.getLocale().toString());

		for (ResidentReportDTO residentReportDTO : residentReportDTOList) {
			Long key = residentReportDTO.getTrainingSiteId();
			ResidentsInEachSitePerBlockDTO residentsInEachSitePerBlockDTO = reportViewMap.get(key);
			
			if(residentsInEachSitePerBlockDTO == null) {
				//code will be executed when row is for new training site
				
				
				//set training site details
				residentsInEachSitePerBlockDTO = new ResidentsInEachSitePerBlockDTO();
				residentsInEachSitePerBlockDTO.setTrainingSiteId(residentReportDTO.getTrainingSiteId());
				residentsInEachSitePerBlockDTO.setTrainingSiteName(residentReportDTO.getTrainingSiteName());
				
				//set Faculties Type Details
				List<FacultyTypeAndCountDTO> facultyTypeAndCountDTOList = new ArrayList<>();
				FacultyTypeAndCountDTO facultyTypeAndCountDTO = new FacultyTypeAndCountDTO();
				facultyTypeAndCountDTO.setFacultyCount(5);
				facultyTypeAndCountDTO.setFacultyType("Full Load");
				facultyTypeAndCountDTOList.add(facultyTypeAndCountDTO);
				
				FacultyTypeAndCountDTO facultyTypeAndCountDTO2 = new FacultyTypeAndCountDTO();
				facultyTypeAndCountDTO2.setFacultyCount(10);
				facultyTypeAndCountDTO2.setFacultyType("Partial Load");
				facultyTypeAndCountDTOList.add(facultyTypeAndCountDTO2);
				
				residentsInEachSitePerBlockDTO.setFacultyTypeAndCountDTOList(facultyTypeAndCountDTOList);
				
				
				//prepare List of FacultiesAndTraineesPerRotationDTO to add
				
				FacultiesAndTraineesPerRotationDTO facultyAndTraineeDTOObj = new FacultiesAndTraineesPerRotationDTO();
				facultyAndTraineeDTOObj.setRotationId(residentReportDTO.getRotationId());
				facultyAndTraineeDTOObj.setRotationName(residentReportDTO.getRotationName());
				
				String facultyName = residentReportDTO.getFirstName() +StringPool.SPACE+ residentReportDTO.getLastName();
				facultyAndTraineeDTOObj.addFaculty(facultyName);
				
				//add FacultiesAndTraineesPerRotationDTO in ResidentsInEachSitePerBlockDTO
				
				int blockNo = Integer.parseInt(residentReportDTO.getBlockNo().split(StringPool.DASH)[1]);
				
				facultyAndTraineeDTOObj.addBlockInfo(blockNo, residentReportDTO.getTraineesInProgram(), residentReportDTO.getTraineesNotInProgram());
				residentsInEachSitePerBlockDTO.addFacultiesAndTraineesPerRotationDTO(residentReportDTO.getRotationId(), facultyAndTraineeDTOObj);
				
				residentsInEachSitePerBlockDTOList.add(residentsInEachSitePerBlockDTO);
				
				reportViewMap.put(key, residentsInEachSitePerBlockDTO);
				
			}
			else {
				//code will be executed when row is for same training site 
				FacultiesAndTraineesPerRotationDTO facultiesAndTraineesPerRotationDTO = residentsInEachSitePerBlockDTO.getFacultiesAndTraineesPerRotationDTO(residentReportDTO.getRotationId());
				
				int index = residentsInEachSitePerBlockDTOList.indexOf(residentsInEachSitePerBlockDTO);
				if(facultiesAndTraineesPerRotationDTO == null) {
					
					//code will be executed when row is for different rotation
					facultiesAndTraineesPerRotationDTO = new FacultiesAndTraineesPerRotationDTO();
					facultiesAndTraineesPerRotationDTO.setRotationId(residentReportDTO.getRotationId());
					facultiesAndTraineesPerRotationDTO.setRotationName(residentReportDTO.getRotationName());
					String facultyName = residentReportDTO.getFirstName() + StringPool.SPACE + residentReportDTO.getLastName();
					facultiesAndTraineesPerRotationDTO.addFaculty(facultyName);
					
					
					//add FacultiesAndTraineesPerRotationDTO in ResidentsInEachSitePerBlockDTO
					
					int blockNo = Integer.parseInt(residentReportDTO.getBlockNo().split(StringPool.DASH)[1]);
					
					facultiesAndTraineesPerRotationDTO.addBlockInfo(blockNo, residentReportDTO.getTraineesInProgram(), residentReportDTO.getTraineesNotInProgram());
					residentsInEachSitePerBlockDTO.addFacultiesAndTraineesPerRotationDTO(residentReportDTO.getRotationId(), facultiesAndTraineesPerRotationDTO);
					
				}
				else {
					//code will be executed when row is for same rotation
					
					//set blockNo and trainees and faculties
					String facultyName = residentReportDTO.getFirstName() + StringPool.SPACE + residentReportDTO.getLastName();
					facultiesAndTraineesPerRotationDTO.addFaculty(facultyName);
					int blockNo = Integer.parseInt(residentReportDTO.getBlockNo().split(StringPool.DASH)[1]);
					facultiesAndTraineesPerRotationDTO.addBlockInfo(blockNo, residentReportDTO.getTraineesInProgram(), residentReportDTO.getTraineesNotInProgram());
					
					residentsInEachSitePerBlockDTO.addFacultiesAndTraineesPerRotationDTO(residentReportDTO.getRotationId(), facultiesAndTraineesPerRotationDTO);
					
				}
				//replace the object in our List
				residentsInEachSitePerBlockDTOList.set(index, residentsInEachSitePerBlockDTO);
			}
		}
		renderRequest.setAttribute(OmsbResidentsRotatingPerTrainingSiteReportWebConstants.RESIDENT_ROTATING_PER_TRAINING_SITE_DTO_LIST, residentsInEachSitePerBlockDTOList);
		renderRequest.setAttribute(OmsbResidentsRotatingPerTrainingSiteReportWebConstants.PROGRAM_NAME,programName);
		renderRequest.setAttribute(OmsbResidentsRotatingPerTrainingSiteReportWebConstants.ACADEMIC_YEAR, annualYear);
		
		super.render(renderRequest, renderResponse);
	}
	
	@Reference
	private EcMemberRequestLocalService ecMemberRequestLocalService;
	
	@Reference
	private ProgramMasterLocalService programMasterLocalService;
	
	private static final Log log = LogFactoryUtil.getLog(OmsbResidentsRotatingPerTrainingSiteReportPortlet.class);
}