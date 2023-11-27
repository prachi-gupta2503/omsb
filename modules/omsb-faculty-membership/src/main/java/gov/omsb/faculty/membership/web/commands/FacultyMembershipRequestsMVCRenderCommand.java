package gov.omsb.faculty.membership.web.commands;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.faculty.membership.web.constants.FacultyMembershipPortletKeys;
import gov.omsb.faculty.membership.web.constants.FacultyRequestConstants;
import gov.omsb.faculty.membership.web.dto.FacultyRequestDetails;
import gov.omsb.faculty.membership.web.util.MasterDataUtil;
import gov.omsb.faculty.membership.web.util.MembershipUtil;
import gov.omsb.tms.custom.dto.FacultyRequestDTO;
import gov.omsb.tms.service.FacultyRequestLocalServiceUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + FacultyMembershipPortletKeys.FACULTYMEMBERSHIP,
		"mvc.command.name=/" }, service = MVCRenderCommand.class)
public class FacultyMembershipRequestsMVCRenderCommand implements MVCRenderCommand {
	private static final Log LOGGER = LogFactoryUtil.getLog(FacultyMembershipRequestsMVCRenderCommand.class.getName());

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		LOGGER.info("FacultyMembership request render called--------");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String viewPage = FacultyRequestConstants.VIEW_PAGE;
		long programId = 0;
		long facultyTypeId = 0;
		long facultyRequestStatusId = 0;
		List<FacultyRequestDTO> facultyRequestList = new ArrayList<>();
		try {
			programId = ParamUtil.getLong(renderRequest, FacultyRequestConstants.PROGRAM_MASTER_ID);
			facultyTypeId = ParamUtil.getLong(renderRequest, FacultyRequestConstants.FACULTY_TYPE_ID);
			facultyRequestStatusId = ParamUtil.getLong(renderRequest,
					FacultyRequestConstants.FACULTY_REQUEST_STATUS_ID);

			LOGGER.info("programId - " + programId + "facultyTypeId - " + facultyTypeId + "facultyRequestStatusId - "
					+ facultyRequestStatusId);

			if (programId > 0 || facultyTypeId > 0 || facultyRequestStatusId > 0) {
				facultyRequestList = FacultyRequestLocalServiceUtil.getFacultyRequestDataBySearch(programId,
						facultyTypeId, facultyRequestStatusId, themeDisplay.getLocale().toString());
			} else {
				facultyRequestList = FacultyRequestLocalServiceUtil
						.getFacultyRequestData(themeDisplay.getLocale().toString());

			}
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
		}
		renderRequest.setAttribute(FacultyRequestConstants.PROGRAM_MASTER_LIST,
				masterDataUtil.getProgramList(themeDisplay));
		renderRequest.setAttribute(FacultyRequestConstants.FACULTY_TYPE_LIST, masterDataUtil.getFacultyType());
		renderRequest.setAttribute(FacultyRequestConstants.FACULTY_REQUEST_STATUS_LIST,
				masterDataUtil.getFacultyRequestSatatus());
		renderRequest.setAttribute(FacultyRequestConstants.PROGRAM_ID, programId);
		renderRequest.setAttribute(FacultyRequestConstants.FACULTY_TYPE_ID, facultyTypeId);
		renderRequest.setAttribute(FacultyRequestConstants.FACULTY_REQUEST_STATUS_ID, facultyRequestStatusId);

		Boolean requester = isRequester(themeDisplay.getUser());
		renderRequest.setAttribute("requester", requester);
		List<FacultyRequestDetails> requestList = getRequestList(facultyRequestList, themeDisplay, renderRequest);
		renderRequest.setAttribute(FacultyRequestConstants.FACULTY_REQUEST_LIST, requestList);

		return viewPage;
	}

	public static Boolean isRequester(User user) {
		boolean isRequester = false;
		List<Role> userRoles = user.getRoles();
		for (Role role : userRoles) {
			if ("Program Admin".equalsIgnoreCase(role.getName()) || "Program Director".equalsIgnoreCase(role.getName())
					|| "Chairman".equalsIgnoreCase(role.getName())) {
				isRequester = true;
				break;
			}
		}
		return isRequester;
	}

	private List<FacultyRequestDetails> getRequestList(List<FacultyRequestDTO> facultyRequestList,
			ThemeDisplay themeDisplay, RenderRequest renderRequest) {
		LOGGER.info("################### getRequestList Called #######################");
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

	@Reference
	private MasterDataUtil masterDataUtil;

}
