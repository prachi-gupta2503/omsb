package gov.omsb.programs.web.mvccommands;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.dto.UserMetadata;
import gov.omsb.common.dto.UserMetadataItem;
import gov.omsb.common.service.util.UserMetadataUtil;
import gov.omsb.common.util.CommonUtil;
import gov.omsb.programs.web.constants.OmsbProgramConstants;
import gov.omsb.programs.web.constants.OmsbProgramsWebPortletKeys;
import gov.omsb.programs.web.portlet.util.OmsbProgramUtil;
import gov.omsb.tms.custom.dto.ProgramStructureDTO;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.model.ProgramTypeMaster;
import gov.omsb.tms.model.TraineeLevelMaster;
import gov.omsb.tms.service.ProgramMasterLocalService;
import gov.omsb.tms.service.ProgramTypeMasterLocalService;
import gov.omsb.tms.service.TraineeLevelMasterLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbProgramsWebPortletKeys.OMSBPROGRAMSWEB,
		"mvc.command.name=" + OmsbProgramConstants.EDIT_PROGRAM_MVC_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class OmsbEditProgramMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		_logger.info("Render Invoked ::: ");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long programMasterId = ParamUtil.getLong(renderRequest, OmsbProgramConstants.PROGRAM_MASTER_ID);
		boolean isSuperAdmin = CommonUtil.isSupeAdminUser(themeDisplay.getUser());
		boolean isChairman = CommonUtil.isChairmanUser(themeDisplay.getUser());
		try {
			ProgramMaster programMaster = programMasterLocalService.getProgramMaster(programMasterId);
			
			List<ProgramMaster> otherProgramList;
			if (isSuperAdmin || isChairman) {
				otherProgramList = programMasterLocalService.getProgramMasters(QueryUtil.ALL_POS,QueryUtil.ALL_POS);
			} else {
				otherProgramList = getOtherProgramList(themeDisplay, programMaster);
			}

			List<ProgramTypeMaster> programTypeMasters = programTypeMasterLocalService.getProgramTypeMasters(-1, -1);

			SimpleDateFormat sdf = new SimpleDateFormat(OmsbProgramConstants.DATE_FORMAT);
			Date estDate = programMaster.getEstablishmentDate();
			sdf.format(estDate);
						
			renderRequest.setAttribute(CommonConstants.PROGRAM, programMaster);
			renderRequest.setAttribute(OmsbProgramConstants.RENDER_PROGRAM_TYPE_LIST, programTypeMasters);
			renderRequest.setAttribute(CommonConstants.OTHER_PROGRAM_LIST, otherProgramList);
			renderRequest.setAttribute(OmsbProgramConstants.RENDER_ESTABLISHMENT_DATE, estDate);

			List<TraineeLevelMaster> traineeLevelMasters = traineeLevelMasterLocalService.getTraineeLevelMasters(-1,
					-1);
			List<ProgramStructureDTO> programStructureDTOList = programMasterLocalService
					.getProgramStructure(programMasterId, themeDisplay.getLocale().toString());

			renderRequest.setAttribute(OmsbProgramConstants.PROGRAM_STRUCTURE_LIST,
					OmsbProgramUtil.getProgramStructure(programStructureDTOList, traineeLevelMasters, themeDisplay));
			renderRequest.setAttribute(OmsbProgramConstants.TRAINEE_LEVEL_MASTERS, traineeLevelMasters);

		} catch (PortalException e) {
			_logger.error(e);
		}
		_logger.info("Render Exit ::: ");
		return OmsbProgramConstants.UPDATE_PROGRAM_JSP;
	}

	/**
	 * 
	 * @param themeDisplay
	 * @param programMaster
	 * @return
	 */
	private List<ProgramMaster> getOtherProgramList(ThemeDisplay themeDisplay, ProgramMaster programMaster) {
		List<ProgramMaster> otherProgramList = new ArrayList<>();
		try {
			UserMetadataItem metadataItem = userMetadataUtil.getUserMetadataItemsByLrUserId(themeDisplay.getPortalURL(),
					themeDisplay.getSiteGroupId(), themeDisplay.getUserId());
			List<Long> ids = metadataItem.getItems().stream().map(UserMetadata::getProgramId)
					.collect(Collectors.toList());
			otherProgramList = programMasterLocalService.getProgramListByIdsAndStatus(ids,
					programMaster.getProgramStatus());

		} catch (Exception e) {
			_logger.error(e);
		}
		return otherProgramList;
	}

	@Reference
	private UserMetadataUtil userMetadataUtil;

	@Reference
	private ProgramMasterLocalService programMasterLocalService;

	@Reference
	private ProgramTypeMasterLocalService programTypeMasterLocalService;

	@Reference
	private TraineeLevelMasterLocalService traineeLevelMasterLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbEditProgramMVCRenderCommand.class.getName());

}
