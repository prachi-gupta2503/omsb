package gov.omsb.faculty.membership.web.commands;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.faculty.membership.web.constants.FacultyMembershipPortletKeys;
import gov.omsb.faculty.membership.web.constants.FacultyRequestConstants;
import gov.omsb.faculty.membership.web.dto.PersonalDetailsDTO;
import gov.omsb.faculty.membership.web.util.GetPersonDetailsUtil;
import gov.omsb.faculty.membership.web.util.MasterDataUtil;
import gov.omsb.tms.custom.dto.ProgramDTO;

@Component(immediate = true, property = { "javax.portlet.name=" + FacultyMembershipPortletKeys.FACULTYMEMBERSHIPREQUEST,
		"mvc.command.name=" + FacultyRequestConstants.NEW_FACULTY_REQUEST_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class AddFacultyRequestMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		log.info("add faculty request render method ---------");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PersonalDetailsDTO personalDetails = getPersonDetailsUtil.getPersonalDetails(themeDisplay, themeDisplay.getUserId());
		log.info("personDetails ---------" + personalDetails);
		renderRequest.setAttribute(FacultyRequestConstants.PERSONAL_DETAILS, personalDetails);
		List<ProgramDTO> programMasterList = masterDataUtil.getProgramList(themeDisplay);
		log.info("programMasterList size --" + programMasterList.size());
		renderRequest.setAttribute(FacultyRequestConstants.PROGRAM_MASTER_LIST, programMasterList);
		return FacultyRequestConstants.NEW_FACULTY_REQUEST_PAGE;
	}

	@Reference
	private GetPersonDetailsUtil getPersonDetailsUtil;

	@Reference
	private MasterDataUtil masterDataUtil;

	private final Log log = LogFactoryUtil.getLog(AddFacultyRequestMVCRenderCommand.class);
}
