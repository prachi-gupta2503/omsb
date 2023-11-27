package gov.omsb.program.type.web.mvccommands;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.program.type.web.constants.OmsbProgramTypeConstants;
import gov.omsb.program.type.web.constants.OmsbProgramTypeWebPortletKeys;
import gov.omsb.tms.service.ProgramTypeMasterLocalService;

@Component(property = { "javax.portlet.name=" + OmsbProgramTypeWebPortletKeys.OMSBPROGRAMTYPEWEB, "mvc.command.name="
		+ OmsbProgramTypeConstants.ADD_PROGRAM_TYPE_MVC_COMMAND_NAME }, service = MVCActionCommand.class)
public class OmsbAddProgramTypeMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		_logger.debug("doProcessAction Invoked ::: ");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		programTypeMasterLocalService.createProgramTypeMaster(actionRequest, themeDisplay);
		_logger.debug("doProcessAction Exit ::: ");
	}

	@Reference
	private ProgramTypeMasterLocalService programTypeMasterLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbAddProgramTypeMVCActionCommand.class.getName());
}
