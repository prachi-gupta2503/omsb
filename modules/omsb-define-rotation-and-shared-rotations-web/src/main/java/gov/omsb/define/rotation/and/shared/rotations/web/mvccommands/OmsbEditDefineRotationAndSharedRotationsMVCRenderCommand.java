package gov.omsb.define.rotation.and.shared.rotations.web.mvccommands;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.define.rotation.and.shared.rotations.web.constants.OmsbDefineRotationAndSharedRotationsWebPortletKeys;
import gov.omsb.define.rotation.and.shared.rotations.web.util.OmsbDefineRotationAndSharedRotationsUtil;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel;
import gov.omsb.tms.model.ProgramDurationDetails;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.model.RotationMaster;
import gov.omsb.tms.model.TrainingSitesMaster;
import gov.omsb.tms.service.ProgdurationRotationTrainingsitesRelLocalService;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;
import gov.omsb.tms.service.RotationMasterLocalService;
import gov.omsb.tms.service.TrainingSitesMasterLocalService;

/**
 * @author Jayesh Goswami
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbDefineRotationAndSharedRotationsWebPortletKeys.OMSBDEFINEROTATIONANDSHAREDROTATIONSWEB,
		"mvc.command.name="	+ OmsbDefineRotationAndSharedRotationsWebPortletKeys.EDIT_DRASR_MVC_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class OmsbEditDefineRotationAndSharedRotationsMVCRenderCommand implements MVCRenderCommand   {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		_logger.info("render Invoked ::: ");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long progdurationRotationTrainingsitesRelId = ParamUtil.getLong(renderRequest, OmsbDefineRotationAndSharedRotationsWebPortletKeys.PROG_DURATION_ROTATION_TRAINING_SITE_REL_ID, 0);
		long programMasterId = 0;
		ProgdurationRotationTrainingsitesRel progdurationRotationTrainingsitesRel = null;
		
		try {
			progdurationRotationTrainingsitesRel = progdurationRotationTrainingsitesRelLocalService.getProgdurationRotationTrainingsitesRel(progdurationRotationTrainingsitesRelId);
			ProgramDurationDetails  programDurationDetail = programDurationDetailsLocalService.getProgramDurationDetails(progdurationRotationTrainingsitesRel.getProgramDurationId());
			if(Validator.isNotNull(programDurationDetail)) {
				programMasterId = programDurationDetail.getProgramId();
			}
		} catch (PortalException e) {
			_logger.error(e);
		}
		
		List<ProgramDurationDetails> programDurationDetailList = programDurationDetailsLocalService.findProgramDurationByProgramId(programMasterId);
		List<ProgramMaster> programMasterList =  omsbDefineRotationAndSharedRotationsUtil.getLoggedInUsersProgram(themeDisplay);
		programMasterList = programMasterList.stream().sorted((first,second)->{
	        String programNameFirst = first.getProgramName(themeDisplay.getLocale()).toLowerCase();
	        String programNameSecond = second.getProgramName(themeDisplay.getLocale()).toLowerCase();
	        return programNameFirst.compareTo(programNameSecond);
		}).collect(Collectors.toList());
		
		List<RotationMaster> rotationMasterList = rotationMasterLocalService.getRotationMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		rotationMasterList = rotationMasterList.stream().sorted((first,second)->{
	        String rotationNameFirst = first.getRotationName(themeDisplay.getLocale()).toLowerCase();
	        String rotationNameSecond = second.getRotationName(themeDisplay.getLocale()).toLowerCase();
	        return rotationNameFirst.compareTo(rotationNameSecond);
		}).collect(Collectors.toList());
		
		List<TrainingSitesMaster> trainingSitesMasterList = trainingSitesMasterLocalService.getTrainingSitesMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		trainingSitesMasterList = trainingSitesMasterList.stream().sorted((first,second)->{
	        String trainingSiteNameFirst = first.getTrainingSiteName(themeDisplay.getLocale()).toLowerCase();
	        String trainingSiteNameSecond = second.getTrainingSiteName(themeDisplay.getLocale()).toLowerCase();
	        return trainingSiteNameFirst.compareTo(trainingSiteNameSecond);
		}).collect(Collectors.toList());
		
		renderRequest.setAttribute("progdurationRotationTrainingsitesRel", progdurationRotationTrainingsitesRel);
		renderRequest.setAttribute(OmsbTmsCommonConstants.PROGRAM_MASTER_ID, programMasterId);
		renderRequest.setAttribute(OmsbTmsCommonConstants.PROGRAM_MASTER_LIST, programMasterList);
		renderRequest.setAttribute(OmsbTmsCommonConstants.ROTATION_MASER_LIST, rotationMasterList);
		renderRequest.setAttribute(OmsbTmsCommonConstants.TRAINING_SITE_MASTER_LIST, trainingSitesMasterList);
		renderRequest.setAttribute(OmsbTmsCommonConstants.PROGRAM_DURATION_DETAILS_LIST, programDurationDetailList);
		
		_logger.info("render Exit ::: ");
		return OmsbDefineRotationAndSharedRotationsWebPortletKeys.EDIT_DRASR_JSP;
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
	
	@Reference
	ProgdurationRotationTrainingsitesRelLocalService progdurationRotationTrainingsitesRelLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbEditDefineRotationAndSharedRotationsMVCRenderCommand.class.getName());

}
