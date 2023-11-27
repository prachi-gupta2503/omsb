package gov.omsb.define.rotation.and.shared.rotations.web.portlet;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.define.rotation.and.shared.rotations.web.constants.OmsbDefineRotationAndSharedRotationsWebPortletKeys;
import gov.omsb.define.rotation.and.shared.rotations.web.portlet.model.DefineRotationAndSharedRotationsDTO;
import gov.omsb.define.rotation.and.shared.rotations.web.util.OmsbDefineRotationAndSharedRotationsUtil;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel;
import gov.omsb.tms.model.ProgramDurationDetails;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.model.RotationMaster;
import gov.omsb.tms.model.TrainingSitesMaster;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;
import gov.omsb.tms.service.RotationMasterLocalService;
import gov.omsb.tms.service.TrainingSitesMasterLocalService;

/**
 * @author Jayesh Goswami
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=OMSB",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=OmsbDefineRotationAndSharedRotationsWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=" + OmsbDefineRotationAndSharedRotationsWebPortletKeys.ADD_DRASR_JSP,
		"javax.portlet.name=" + OmsbDefineRotationAndSharedRotationsWebPortletKeys.OMSBDEFINEROTATIONANDSHAREDROTATIONSWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class OmsbDefineRotationAndSharedRotationsWebPortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		_logger.info("render Invoked ::: ");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		List<ProgramMaster> programMasterList =  omsbDefineRotationAndSharedRotationsUtil.getLoggedInUsersProgram(themeDisplay);
		programMasterList = programMasterList.stream().sorted((first,second)->{
	        String programNameFirst = first.getProgramName(themeDisplay.getLocale()).toLowerCase();
	        String programNameSecond = second.getProgramName(themeDisplay.getLocale()).toLowerCase();
	        return programNameFirst.compareTo(programNameSecond);
		}).collect(Collectors.toList());
		List<RotationMaster> rotationMasterList = rotationMasterLocalService.getRotationMasters(-1, -1);
		rotationMasterList = rotationMasterList.stream().sorted((first,second)->{
	        String rotationNameFirst = first.getRotationName(themeDisplay.getLocale()).toLowerCase();
	        String rotationNameSecond = second.getRotationName(themeDisplay.getLocale()).toLowerCase();
	        return rotationNameFirst.compareTo(rotationNameSecond);
		}).collect(Collectors.toList());
		
		List<TrainingSitesMaster> trainingSitesMasterList = trainingSitesMasterLocalService.getTrainingSitesMasters(-1, -1);
		
		trainingSitesMasterList = trainingSitesMasterList.stream().sorted((first,second)->{
	        String trainingSiteNameFirst = first.getTrainingSiteName(themeDisplay.getLocale()).toLowerCase();
	        String trainingSiteNameSecond = second.getTrainingSiteName(themeDisplay.getLocale()).toLowerCase();
	        return trainingSiteNameFirst.compareTo(trainingSiteNameSecond);
		}).collect(Collectors.toList());
		
		List<ProgramDurationDetails> programDurationDetailList  = omsbDefineRotationAndSharedRotationsUtil.getProgramDurationDetailsByPrograms(programMasterList);
		List<ProgdurationRotationTrainingsitesRel> progdurationRotationTrainingsitesRelsList =  omsbDefineRotationAndSharedRotationsUtil.getProgdurationRotationTrainingsitesRelByProgramDurations(programDurationDetailList);
		List<DefineRotationAndSharedRotationsDTO> defineRotationAndSharedRotationsList = new ArrayList<>();
		
		DefineRotationAndSharedRotationsDTO defineRotationAndSharedRotationsDTO;
		for (ProgdurationRotationTrainingsitesRel progdurationRotationTrainingsitesRel : progdurationRotationTrainingsitesRelsList) {
			try {
				ProgramDurationDetails programDurationDetails = programDurationDetailsLocalService.getProgramDurationDetails(progdurationRotationTrainingsitesRel.getProgramDurationId());
				ProgramMaster programMaster = programMasterLocalService.getProgramMaster(programDurationDetails.getProgramId());
				RotationMaster rotationMaster = rotationMasterLocalService.getRotationMaster(progdurationRotationTrainingsitesRel.getRotationId());
				TrainingSitesMaster trainingSitesMaster = trainingSitesMasterLocalService.fetchTrainingSitesMaster(progdurationRotationTrainingsitesRel.getTrainingSitesId());
				ProgramMaster owningProgramMaster = programMasterLocalService.fetchProgramMaster(progdurationRotationTrainingsitesRel.getRotationOwningProgramId());
				
				defineRotationAndSharedRotationsDTO = new DefineRotationAndSharedRotationsDTO();
				defineRotationAndSharedRotationsDTO.setCohort(programMaster.getProgramName(themeDisplay.getLocale())+StringPool.OPEN_PARENTHESIS+programDurationDetails.getAyApplicableForm()+StringPool.CLOSE_PARENTHESIS);
				defineRotationAndSharedRotationsDTO.setTrainingSite(Validator.isNotNull(trainingSitesMaster) ? trainingSitesMaster.getTrainingSiteName(themeDisplay.getLocale()) : StringPool.DASH);
				defineRotationAndSharedRotationsDTO.setRotation(rotationMaster.getRotationName(themeDisplay.getLocale()));
				defineRotationAndSharedRotationsDTO.setIsSharedRotation(progdurationRotationTrainingsitesRel.getIsSharedRotation() ? "Yes" : "No");
				defineRotationAndSharedRotationsDTO.setSlotes(progdurationRotationTrainingsitesRel.getNoOfSlots() !=0 ? StringPool.BLANK+progdurationRotationTrainingsitesRel.getNoOfSlots() : StringPool.DASH);
				defineRotationAndSharedRotationsDTO.setSharedRotationOwningProgram(Validator.isNotNull(owningProgramMaster) ? owningProgramMaster.getProgramName(themeDisplay.getLocale()) : StringPool.DASH);
				defineRotationAndSharedRotationsDTO.setProgdurationRotationTsRelId(progdurationRotationTrainingsitesRel.getProgdurationRotationTsRelId());
				defineRotationAndSharedRotationsList.add(defineRotationAndSharedRotationsDTO);
				
			} catch (PortalException e) {
				_logger.error(e);
			}
		}
		renderRequest.setAttribute(OmsbTmsCommonConstants.PROGRAM_MASTER_LIST, programMasterList);
		renderRequest.setAttribute(OmsbTmsCommonConstants.ROTATION_MASER_LIST, rotationMasterList);
		renderRequest.setAttribute(OmsbTmsCommonConstants.TRAINING_SITE_MASTER_LIST, trainingSitesMasterList);
		renderRequest.setAttribute(OmsbTmsCommonConstants.PROGRAM_DURATION_DETAILS_LIST, programDurationDetailList);
		renderRequest.setAttribute(OmsbTmsCommonConstants.DEFINE_ROTATION_AND_SHARED_ROTATIONS_LIST, defineRotationAndSharedRotationsList);
		
		_logger.info("render Exit ::: ");
		super.render(renderRequest, renderResponse);
	}
	
	@Reference(unbind = "_")
	OmsbDefineRotationAndSharedRotationsUtil omsbDefineRotationAndSharedRotationsUtil;
	
	@Reference
	ProgramMasterLocalService programMasterLocalService;
	
	@Reference
	RotationMasterLocalService rotationMasterLocalService;
	
	@Reference
	ProgramDurationDetailsLocalService programDurationDetailsLocalService;
	
	@Reference
	TrainingSitesMasterLocalService trainingSitesMasterLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbDefineRotationAndSharedRotationsWebPortlet.class.getName());
}