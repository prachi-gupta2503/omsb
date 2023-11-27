package gov.omsb.master.rotation.schedule.web.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.master.rotation.schedule.web.constants.OmsbMasterRotationScheduleWebPortletKeys;
import gov.omsb.master.rotation.schedule.web.portlet.mvccommands.OmsbGetDataByFacultyMVCResourceCommand;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.service.ProgramMasterLocalService;

/**
 * @author Dhairya
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=OMSB",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=OmsbMasterRotationScheduleWeb", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template="+OmsbMasterRotationScheduleWebPortletKeys.VIEW_JSP,
		"javax.portlet.name=" + OmsbMasterRotationScheduleWebPortletKeys.OMSBMASTERROTATIONSCHEDULEWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class OmsbMasterRotationScheduleWebPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

        long programMasterId = ParamUtil.getLong(renderRequest, OmsbTmsCommonConstants.PROGRAM_MASTER_ID,201);
        long progDurationTlBlocksLtId = ParamUtil.getLong(renderRequest, OmsbTmsCommonConstants.PROGDURATION_TLBLOCKS_LT_ID,1);
        

		String programMasterName = "";
		try {
			ProgramMaster program = programMasterLocalService.getProgramMaster(programMasterId);
			programMasterName = program.getProgramName(themeDisplay.getLocale());
		} catch (PortalException e) {
			_logger.error(e.getMessage());
		}
		String programName = LanguageUtil.get(renderRequest.getLocale(), OmsbMasterRotationScheduleWebPortletKeys.PROGRAM_NAME_US_AR);
		if (programMasterName.equalsIgnoreCase(programName)) {
			renderRequest.setAttribute(OmsbMasterRotationScheduleWebPortletKeys.PROGRAM_MASTER_DATA_ID, 1);
		} else {
			renderRequest.setAttribute(OmsbMasterRotationScheduleWebPortletKeys.PROGRAM_MASTER_DATA_ID, 0);
		}	
	
		renderRequest.setAttribute(OmsbTmsCommonConstants.PROGRAM_MASTER_ID, programMasterId);
		renderRequest.setAttribute(OmsbTmsCommonConstants.PROGDURATION_TLBLOCKS_LT_ID, progDurationTlBlocksLtId);

		super.render(renderRequest, renderResponse);

	}
	
	@Reference
	private ProgramMasterLocalService programMasterLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbGetDataByFacultyMVCResourceCommand.class);

}