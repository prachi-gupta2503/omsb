package gov.omsb.programs.web.mvccommands;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.dto.UserMetadata;
import gov.omsb.common.dto.UserMetadataItem;
import gov.omsb.common.service.util.UserMetadataUtil;
import gov.omsb.common.util.CommonUtil;
import gov.omsb.programs.web.constants.OmsbProgramConstants;
import gov.omsb.programs.web.constants.OmsbProgramsWebPortletKeys;
import gov.omsb.tms.custom.dto.ProgramDTO;
import gov.omsb.tms.model.ProgramTypeMaster;
import gov.omsb.tms.service.ProgramMasterLocalService;
import gov.omsb.tms.service.ProgramTypeMasterLocalService;

/**
 * 
 * @author Jayesh Goswami
 *
 */

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbProgramsWebPortletKeys.OMSBPROGRAMSWEB,
		"mvc.command.name=" + OmsbProgramConstants.ADD_PROGRAM_MVC_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class OmsbAddProgramMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		_logger.info("OmsbAddProgramMVCRenderCommand render invoked :::");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		boolean isSuperAdmin = CommonUtil.isSupeAdminUser(themeDisplay.getUser());
		boolean isChairman = CommonUtil.isChairmanUser(themeDisplay.getUser());

		List<ProgramDTO> programList = new ArrayList<>();
		if (isSuperAdmin || isChairman) {
			programList = programMasterLocalService.getAllProgramList(themeDisplay.getLanguageId());
		} else {
			try {
				UserMetadataItem metadataItem = userMetadataUtil.getUserMetadataItemsByLrUserId(
						themeDisplay.getPortalURL(), themeDisplay.getSiteGroupId(), themeDisplay.getUserId());
				List<Long> ids = metadataItem.getItems().stream().map(UserMetadata::getProgramId)
						.collect(Collectors.toList());
				programList = programMasterLocalService.getProgramDTOListByIds(ids, themeDisplay.getLanguageId());
			} catch (Exception e) {
				_logger.error(e);
			}
		}

		List<ProgramTypeMaster> programTypeMasters = programTypeMasterLocalService
				.getProgramTypeMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		renderRequest.setAttribute(OmsbProgramConstants.RENDER_PROGRAM_TYPE_LIST, programTypeMasters);
		renderRequest.setAttribute(OmsbProgramConstants.RENDER_ALL_PROGRAM_LIST, programList);

		return OmsbProgramConstants.ADD_PROGRAM_JSP;
	}

	private static final Log _logger = LogFactoryUtil.getLog(OmsbAddProgramMVCRenderCommand.class);

	@Reference
	private UserMetadataUtil userMetadataUtil;

	@Reference
	private ProgramMasterLocalService programMasterLocalService;

	@Reference
	private ProgramTypeMasterLocalService programTypeMasterLocalService;

}
