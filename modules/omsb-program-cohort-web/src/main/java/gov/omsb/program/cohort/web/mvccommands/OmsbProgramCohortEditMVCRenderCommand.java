package gov.omsb.program.cohort.web.mvccommands;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.program.cohort.web.constants.OmsbProgramCohortWebPortletKeys;
import gov.omsb.program.cohort.web.portlet.util.ProgramCohortUtil;
import gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel;
import gov.omsb.tms.model.ProgramDurationDetails;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.service.ProgdurationTraineelevelBlocksLevelTypeRelLocalService;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;

/**
 * @author Jayesh Goswami
 */
@Component(immediate = 	true, property = { "javax.portlet.name=" + OmsbProgramCohortWebPortletKeys.OMSBPROGRAMCOHORTWEB,
"mvc.command.name=" + OmsbProgramCohortWebPortletKeys.EDIT_PROGRAM_COHORT_MVC_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class OmsbProgramCohortEditMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		_logger.info("render Invoked ::: ");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		//programId - programId from programDetails page
		long programId = ParamUtil.getLong(renderRequest, OmsbProgramCohortWebPortletKeys.PROGRAM_ID, 0);
		long programMasterId = ParamUtil.getLong(renderRequest, OmsbProgramCohortWebPortletKeys.PROGRAM_MASTER_ID, 0);
		long programDurationId = ParamUtil.getLong(renderRequest, OmsbProgramCohortWebPortletKeys.PROGRAM_DURATION_ID, 0);
		long progdurationTlBlocksLtId = ParamUtil.getLong(renderRequest, OmsbProgramCohortWebPortletKeys.PROGDURATION_TL_BLOCKS_TS_REL_ID, 0);
		
		try {
			ProgramMaster programMaster = programMasterLocalService.getProgramMaster(programMasterId);
			ProgramDurationDetails programDuration = programDurationDetailsLocalService.getProgramDurationDetails(programDurationId);
			ProgdurationTraineelevelBlocksLevelTypeRel traineelevelBlocksLevelTypeRel = traineelevelBlocksLevelTypeRelLocalService.getProgdurationTraineelevelBlocksLevelTypeRel(progdurationTlBlocksLtId);
			
			List<ProgdurationTraineelevelBlocksLevelTypeRel> progdurationTraineelevelBlocksLevelTypeRels = new ArrayList<>();
			progdurationTraineelevelBlocksLevelTypeRels.add(traineelevelBlocksLevelTypeRel);
			
			renderRequest.setAttribute("programMaster",programMaster);
			renderRequest.setAttribute("programDuration",programDuration);
			renderRequest.setAttribute("progdurationTraineelevelBlocksLevelTypeRelList",progdurationTraineelevelBlocksLevelTypeRels);
			renderRequest.setAttribute("programListRenderUrl", ProgramCohortUtil.createProgramDetailsPageRenderUrl(themeDisplay,
					renderRequest, programId));
		} catch (PortalException e) {
			_logger.error(e);
		}
		
		_logger.info("render Exit ::: ");
		return OmsbProgramCohortWebPortletKeys.EDIT_PROGRAM_COHORT_JSP;
	}
	
	@Reference
	ProgramMasterLocalService programMasterLocalService;
	
	@Reference
	ProgramDurationDetailsLocalService programDurationDetailsLocalService;
	
	@Reference
	ProgdurationTraineelevelBlocksLevelTypeRelLocalService traineelevelBlocksLevelTypeRelLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbProgramCohortEditMVCRenderCommand.class.getName());

}
