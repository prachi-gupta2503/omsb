package gov.omsb.view.program.cohort.web.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.dto.UserMetadataItem;
import gov.omsb.common.service.util.UserMetadataUtil;
import gov.omsb.common.util.CommonUtil;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.service.ProgramMasterLocalService;
import gov.omsb.view.program.cohort.web.constants.OmsbViewProgramCohortWebPortletKeys;
import gov.omsb.view.program.cohort.web.util.OmsbViewProgramCohortUtil;

/**
 * @author Jayesh Goswami
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.version=3.0",
		"com.liferay.portlet.display-category=OMSB",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=OmsbViewProgramCohortWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + OmsbViewProgramCohortWebPortletKeys.OMSBVIEWPROGRAMCOHORTWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class OmsbViewProgramCohortWebPortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		_logger.info("render Invoked ::: ");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long programMasterId = ParamUtil.getLong(renderRequest, OmsbTmsCommonConstants.PROGRAM_MASTER_ID, 0l);
		
		boolean isSuperAdmin = CommonUtil.isSupeAdminUser(themeDisplay.getUser());
		boolean isChairman = CommonUtil.isChairmanUser(themeDisplay.getUser());

		_logger.debug("serveResource ::: programMasterId " + programMasterId);

		List<ProgramMaster> programMasterList = new ArrayList<>();
		if (isSuperAdmin || isChairman) {
			_logger.debug("serveResource ::: isSuperAdmin " + isSuperAdmin);
			_logger.debug("serveResource ::: isChairman " + isChairman);
			programMasterList = programMasterLocalService.findByProgramStatus(Boolean.TRUE);
		} else {
			try {
				UserMetadataItem userMetadataItem = userMetadataUtil.getUserMetadataItemsByLrUserId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), themeDisplay.getUserId());
				List<Long> programMasterIds = CommonUtil.getProgramIdsFromUsermetadataItems(userMetadataItem);
				programMasterList =  programMasterLocalService.findByProgramMasterId(programMasterIds);
			} catch (Exception e) {
				_logger.error(e);
			}
		}
		programMasterList = programMasterList.stream()
			    .sorted((first, second) -> {
			        String programNameFirst = first.getProgramName(themeDisplay.getLocale()).toLowerCase();
			        String programNameSecond = second.getProgramName(themeDisplay.getLocale()).toLowerCase();
			        return programNameFirst.compareTo(programNameSecond);
			    })
			    .collect(Collectors.toList());
		renderRequest.setAttribute(OmsbTmsCommonConstants.PROGRAM_MASTER_LIST, programMasterList);
		renderRequest.setAttribute(OmsbTmsCommonConstants.PROGRAM_MASTER_ID, programMasterId);
		
		List<String> yearRange = CommonUtil.getYearRangeList(Calendar.getInstance().get(Calendar.YEAR), 10l);
		renderRequest.setAttribute(OmsbTmsCommonConstants.YEAR_RANGE, yearRange);
		renderRequest.setAttribute("programListRenderUrl", OmsbViewProgramCohortUtil.createProgramDetailsPageRenderUrl(themeDisplay,
				renderRequest, programMasterId));
		
		_logger.info("render Exit ::: ");
		super.render(renderRequest, renderResponse);
	}
	
	@Reference(unbind = "_")
	private UserMetadataUtil userMetadataUtil;
	
	@Reference
	ProgramMasterLocalService programMasterLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbViewProgramCohortWebPortlet.class.getName());
}