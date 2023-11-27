package gov.omsb.programs.web.portlet;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
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

import gov.omsb.common.constants.CommonConstants;
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
 * @author Aditya Meghnathi
 */
@Component(immediate = true, property = { "javax.portlet.version=3.0", "com.liferay.portlet.display-category=OMSB",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=OmsbProgramsWeb", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/program-list.jsp",
		"javax.portlet.name=" + OmsbProgramsWebPortletKeys.OMSBPROGRAMSWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class OmsbProgramsWebPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws PortletException, IOException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		boolean isSuperAdmin = CommonUtil.isSupeAdminUser(themeDisplay.getUser());
		boolean isTrainee = CommonUtil.isTraineeUser(themeDisplay.getUser());
		boolean isChairman = CommonUtil.isChairmanUser(themeDisplay.getUser());
		boolean isFaculty = CommonUtil.isFacultyUser(themeDisplay.getUser());

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

		List<ProgramTypeMaster> programTypeMasters = programTypeMasterLocalService.getProgramTypeMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		renderRequest.setAttribute(OmsbProgramConstants.IS_TRAINEE, isTrainee);
		renderRequest.setAttribute("isChairman", isChairman);
		renderRequest.setAttribute("isFaculty", isFaculty);
		renderRequest.setAttribute(OmsbProgramConstants.RENDER_PROGRAM_TYPE_LIST, programTypeMasters);
		renderRequest.setAttribute(OmsbProgramConstants.RENDER_ALL_PROGRAM_LIST, programList);
		renderRequest.setAttribute(CommonConstants.IS_TRAINEE_USER, CommonUtil.isTraineeUser(themeDisplay.getUser()));
		renderRequest.setAttribute("scopeGroupName", themeDisplay.getScopeGroup().getName(themeDisplay.getLocale()));
		super.render(renderRequest, renderResponse);
	}

	private static final Log _logger = LogFactoryUtil.getLog(OmsbProgramsWebPortlet.class.getName());

	@Reference
	private UserMetadataUtil userMetadataUtil;

	@Reference
	private ProgramMasterLocalService programMasterLocalService;

	@Reference
	private ProgramTypeMasterLocalService programTypeMasterLocalService;
}