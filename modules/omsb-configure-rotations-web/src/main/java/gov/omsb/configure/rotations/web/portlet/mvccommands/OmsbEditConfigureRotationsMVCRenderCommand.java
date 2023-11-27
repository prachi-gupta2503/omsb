package gov.omsb.configure.rotations.web.portlet.mvccommands;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.configure.rotations.web.constants.OmsbConfigureRotationsWebPortletKeys;
import gov.omsb.tms.custom.dto.ConfigureRotationEditDetailsDTO;
import gov.omsb.tms.model.ProgdurationRotationTraineelevelBlocksRel;
import gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel;
import gov.omsb.tms.model.ProgramDurationDetails;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.model.RotationMaster;
import gov.omsb.tms.model.RotationTypeMaster;
import gov.omsb.tms.model.TraineeLevelMaster;
import gov.omsb.tms.service.ProgdurationRotationTraineelevelBlocksRelLocalService;
import gov.omsb.tms.service.ProgdurationRotationTrainingsitesRelLocalService;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;
import gov.omsb.tms.service.RotationMasterLocalService;
import gov.omsb.tms.service.RotationTypeMasterLocalService;
import gov.omsb.tms.service.TraineeLevelMasterLocalService;

/**
 * @author Komal Gajera
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbConfigureRotationsWebPortletKeys.OMSBCONFIGUREROTATIONSWEB,
"mvc.command.name=" + OmsbConfigureRotationsWebPortletKeys.EDIT_CONFIGURE_ROTATIONS_MVC_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class OmsbEditConfigureRotationsMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		_logger.info("render Invoked ::: ");
		long configureRotationMasterId = ParamUtil.getLong(renderRequest, OmsbConfigureRotationsWebPortletKeys.CONFIGURE_ROTATIONS_MASTER_ID, 0);
		
		try {
			ProgdurationRotationTraineelevelBlocksRel progdurationRotationTraineelevelBlocksRel = progdurationRotationTraineelevelBlocksRelLocalService.getProgdurationRotationTraineelevelBlocksRel(configureRotationMasterId);			
			List<ProgdurationRotationTrainingsitesRel> progdurationRotationTraineelevelBlocksRels = progdurationRotationTrainingsitesRelLocalService.findByProgramDurationId(progdurationRotationTraineelevelBlocksRel.getProgramDurationId());			
			ProgramDurationDetails programDuration = programDurationDetailsLocalService.getProgramDurationDetails(progdurationRotationTraineelevelBlocksRel.getProgramDurationId());			
			ProgramMaster programMaster = programMasterLocalService.getProgramMaster(programDuration.getProgramId());			
			TraineeLevelMaster traineeLevelMaster = traineeLevelMasterLocalService.getTraineeLevelMaster(progdurationRotationTraineelevelBlocksRel.getTraineeLevelId());
			List<ConfigureRotationEditDetailsDTO> rotationEditDetailsDTOs = progdurationRotationTraineelevelBlocksRelLocalService.getConfigureRotationDetailsByProgramAndDuration(
					programMaster.getProgramMasterId(), traineeLevelMaster.getTraineeLevelMasterId(), programDuration.getProgDurationId());
			List<RotationMaster> rotationMasters = new ArrayList<>();
			for (ProgdurationRotationTrainingsitesRel blocksLevelTypeRel : progdurationRotationTraineelevelBlocksRels) {
				rotationMasters.add(rotationMasterLocalService.getRotationMaster(blocksLevelTypeRel.getRotationId()));
			}
			List<RotationTypeMaster> rotationTypeMasters = rotationTypeMasterLocalService.getRotationTypeMasters(-1, -1);

			renderRequest.setAttribute(OmsbConfigureRotationsWebPortletKeys.CONFIGURE_ROTATIONS, progdurationRotationTraineelevelBlocksRel);
			renderRequest.setAttribute(OmsbConfigureRotationsWebPortletKeys.PROGRAM_DURATIONS_MASTER, programDuration);
			renderRequest.setAttribute(OmsbConfigureRotationsWebPortletKeys.PROGRAM_MASTER, programMaster);
			renderRequest.setAttribute(OmsbConfigureRotationsWebPortletKeys.TRAINEE_LEVEL_MASTER, traineeLevelMaster);
			renderRequest.setAttribute(OmsbConfigureRotationsWebPortletKeys.CONFIGURE_ROTATION_DATA, rotationEditDetailsDTOs);
			renderRequest.setAttribute(OmsbConfigureRotationsWebPortletKeys.RENDER_ALL_ROTATIONS, rotationMasters);
			renderRequest.setAttribute(OmsbConfigureRotationsWebPortletKeys.RENDER_ROTATION_TYPE_LIST, rotationTypeMasters);
			renderRequest.setAttribute("totalrecord", rotationEditDetailsDTOs.size());

		} catch (PortalException e) {
			_logger.error(e);
		}
		
		_logger.info("render Exit ::: ");
		return OmsbConfigureRotationsWebPortletKeys.EDIT_CONFIGURE_ROTATIONS_JSP;
	}
	
	@Reference
	private RotationMasterLocalService rotationMasterLocalService;
	
	@Reference
	private RotationTypeMasterLocalService rotationTypeMasterLocalService;
	
	@Reference
	private ProgdurationRotationTraineelevelBlocksRelLocalService progdurationRotationTraineelevelBlocksRelLocalService;
	
	@Reference
	private ProgdurationRotationTrainingsitesRelLocalService progdurationRotationTrainingsitesRelLocalService;
	
	@Reference
	private ProgramMasterLocalService programMasterLocalService;
	
	@Reference
	private ProgramDurationDetailsLocalService programDurationDetailsLocalService;
	
	@Reference
	private TraineeLevelMasterLocalService traineeLevelMasterLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbEditConfigureRotationsMVCRenderCommand.class.getName());

}
