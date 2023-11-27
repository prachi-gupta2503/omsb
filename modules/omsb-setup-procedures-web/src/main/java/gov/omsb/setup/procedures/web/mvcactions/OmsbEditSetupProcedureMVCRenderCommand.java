package gov.omsb.setup.procedures.web.mvcactions;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.setup.procedures.web.constants.OmsbSetupProceduresWebPortletKeys;
import gov.omsb.tms.custom.dto.RotationListDTO;
import gov.omsb.tms.model.ProcedureMaster;
import gov.omsb.tms.model.ProgdurationRotationTlPgProcedurePtRel;
import gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel;
import gov.omsb.tms.model.ProgramDurationDetails;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.model.RotationMaster;
import gov.omsb.tms.model.TraineeLevelMaster;
import gov.omsb.tms.service.ProcedureMasterLocalService;
import gov.omsb.tms.service.ProgdurationRotationTlPgProcedurePtRelLocalService;
import gov.omsb.tms.service.ProgdurationRotationTraineelevelBlocksRelLocalService;
import gov.omsb.tms.service.ProgdurationTraineelevelBlocksLevelTypeRelLocalService;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;
import gov.omsb.tms.service.RotationMasterLocalService;
import gov.omsb.tms.service.TraineeLevelMasterLocalService;

/**
 * 
 * @author Aditya Meghnathi
 *
 */

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbSetupProceduresWebPortletKeys.OMSBSETUPPROCEDURESWEB, "mvc.command.name="
				+ OmsbSetupProceduresWebPortletKeys.RENDER_EDIT_SETUP_PROCEDURE_MVC_COMMAND_NAME }, service = MVCRenderCommand.class)
public class OmsbEditSetupProcedureMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		_logger.info("OmsbEditSetupProcedureMVCRenderCommand render Invoked ::: ");
		long progdurationRotationTlPgProcedurePtRelId = ParamUtil.getLong(renderRequest,
				OmsbSetupProceduresWebPortletKeys.PROGDURATION_TS_ROTATION_TL_PG_PROCEDURE_PT_REL_ID);
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			ProgdurationRotationTlPgProcedurePtRel progdurationRotationTlPgProcedurePtRel = progdurationRotationTlPgProcedurePtRelLocalService
					.getProgdurationRotationTlPgProcedurePtRel(progdurationRotationTlPgProcedurePtRelId);
			ProgramDurationDetails programDurationDetails = programDurationDetailsLocalService
					.getProgramDurationDetails(progdurationRotationTlPgProcedurePtRel.getProgramDurationId());
			ProgramMaster programMaster = programMasterLocalService
					.getProgramMaster(programDurationDetails.getProgramId());
			List<ProgramDurationDetails> programDurationDetailList = new ArrayList<>(programDurationDetailsLocalService
					.findProgramDurationByProgramId(programDurationDetails.getProgramId()));
	        Collections.sort(programDurationDetailList, Comparator.comparing(ProgramDurationDetails::getAyApplicableForm));

			List<ProcedureMaster> procedureMasters = procedureMasterLocalService.findByProcedureGroupMasterId(progdurationRotationTlPgProcedurePtRel.getProcedureGroupId());
			procedureMasters = procedureMasters.stream().sorted((first,second)->{
		        String groupFirst = first.getProcedureName(themeDisplay.getLocale()).toLowerCase();
		        String groupSecond = second.getProcedureName(themeDisplay.getLocale()).toLowerCase();
		        return groupFirst.compareTo(groupSecond);
			}).collect(Collectors.toList()); 
			List<ProgdurationTraineelevelBlocksLevelTypeRel> progdurationTraineelevelBlocksLevelTypeRels = progdurationTraineelevelBlocksLevelTypeRelLocalService
					.findByProgramDurationId(progdurationRotationTlPgProcedurePtRel.getProgramDurationId());

			List<TraineeLevelMaster> traineeLevelMasters = new ArrayList<>();
			for (ProgdurationTraineelevelBlocksLevelTypeRel blocksLevelTypeRel : progdurationTraineelevelBlocksLevelTypeRels) {
				traineeLevelMasters.add(
						traineeLevelMasterLocalService.getTraineeLevelMaster(blocksLevelTypeRel.getTraineeLevelId()));
			}

			if (progdurationRotationTlPgProcedurePtRel.getTraineeLevelId() == GetterUtil.DEFAULT_LONG) {
				List<RotationMaster> rotationMasters = rotationMasterLocalService.getRotationMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
				renderRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.RENDER_EDIT_ROTATION_LIST,
						rotationMasters);
			} else {
				List<RotationListDTO> rotationListDTOs = rotationMasterLocalService
						.getRotationsByTraineeLevelIdAndProgramDurationId(
								progdurationRotationTlPgProcedurePtRel.getTraineeLevelId(),
								progdurationRotationTlPgProcedurePtRel.getProgramDurationId(),
								themeDisplay.getLocale().toString());
				renderRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.RENDER_EDIT_ROTATION_LIST,
						rotationListDTOs);
			}
			renderRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.RENDER_EDIT_SETUP_PROCEDURE_DETAILS,
					progdurationRotationTlPgProcedurePtRel);
			renderRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.RENDER_EDIT_TRAINEE_LIST, traineeLevelMasters);
			renderRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.RENDER_EDIT_PROGRAM_LIST, programMaster);
			renderRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.RENDER_EDIT_PROGRAM_DURATION_LIST,
					programDurationDetails);
			renderRequest.setAttribute(OmsbSetupProceduresWebPortletKeys.RENDER_ALL_PROCEDURES,
					procedureMasters);
			renderRequest.setAttribute("programDurationDetailList", programDurationDetailList);
		} catch (PortalException e) {
			_logger.error(e);
		}

		_logger.info("OmsbEditSetupProcedureMVCRenderCommand render Exit ::: ");
		return OmsbSetupProceduresWebPortletKeys.EDIT_SETUP_PROCEDURE_JSP;
	}

	@Reference
	private ProgdurationRotationTraineelevelBlocksRelLocalService progdurationRotationTraineelevelBlocksRelLocalService;

	@Reference
	private ProgdurationTraineelevelBlocksLevelTypeRelLocalService progdurationTraineelevelBlocksLevelTypeRelLocalService;

	@Reference
	private ProgramMasterLocalService programMasterLocalService;

	@Reference
	private ProgramDurationDetailsLocalService programDurationDetailsLocalService;

	@Reference
	private RotationMasterLocalService rotationMasterLocalService;

	@Reference
	private TraineeLevelMasterLocalService traineeLevelMasterLocalService;

	@Reference
	private ProcedureMasterLocalService procedureMasterLocalService;

	@Reference
	private ProgdurationRotationTlPgProcedurePtRelLocalService progdurationRotationTlPgProcedurePtRelLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbEditSetupProcedureMVCRenderCommand.class.getName());

}
