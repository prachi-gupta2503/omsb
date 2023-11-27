package gov.omsb.faculty.membership.web.commands;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import gov.omsb.faculty.membership.web.constants.FacultyMembershipPortletKeys;
import gov.omsb.faculty.membership.web.constants.FacultyRequestConstants;
import gov.omsb.faculty.membership.web.dto.FacultyRequestDetails;
import gov.omsb.faculty.membership.web.util.MembershipUtil;
import gov.omsb.tms.custom.dto.FacultyRequestDTO;
import gov.omsb.tms.service.FacultyRequestLocalServiceUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + FacultyMembershipPortletKeys.FACULTYMEMBERSHIPREQUEST,
		"mvc.command.name=/" }, service = MVCRenderCommand.class)
public class MyFacultyRequestsMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		LOGGER.info("=================my faculty requests render method===============");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<FacultyRequestDTO> facultyRequestList = new ArrayList<>();
		try {
			facultyRequestList = FacultyRequestLocalServiceUtil.getMyFacultyRequests(themeDisplay.getUserId(),
					themeDisplay.getLanguageId());
			LOGGER.info("my faculty --------->" + facultyRequestList);
		} catch (Exception e) {
			LOGGER.error(e);
		}
			
		List<FacultyRequestDetails> requestList = getRequestList(facultyRequestList, themeDisplay, renderRequest);
		
		renderRequest.setAttribute(FacultyRequestConstants.FACULTY_REQUEST_LIST, requestList);
		
		return FacultyRequestConstants.MY_FACULTY_REQUEST_PAGE;
	}
	
	
	private List<FacultyRequestDetails> getRequestList(List<FacultyRequestDTO> facultyRequestList,
			ThemeDisplay themeDisplay, RenderRequest renderRequest) {
		List<FacultyRequestDetails> listOfFacultyMember = new ArrayList<FacultyRequestDetails>();
		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		facultyRequestList.forEach(data -> {

			FacultyRequestDetails memberRequestDetail = MembershipUtil.getMemberRequestDetail(httpRequest, themeDisplay,
					data);

			listOfFacultyMember.add(memberRequestDetail);

		});
		return listOfFacultyMember;
	}

	private final Log LOGGER = LogFactoryUtil.getLog(MyFacultyRequestsMVCRenderCommand.class.getName());

}
