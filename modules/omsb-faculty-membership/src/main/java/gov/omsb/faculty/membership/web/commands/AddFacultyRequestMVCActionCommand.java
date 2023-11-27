package gov.omsb.faculty.membership.web.commands;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.faculty.membership.web.constants.FacultyMembershipPortletKeys;
import gov.omsb.faculty.membership.web.constants.FacultyRequestConstants;
import gov.omsb.faculty.membership.web.dto.DocumentInfoDTO;
import gov.omsb.faculty.membership.web.util.FacultyDocumentUtil;
import gov.omsb.faculty.membership.web.util.MembershipUtil;
import gov.omsb.tms.model.FacultyRequest;
import gov.omsb.tms.service.FacultyRequestLocalService;
import gov.omsb.tms.service.FacultyRequestRotationsLocalService;
import gov.omsb.tms.service.FacultyRequestStateLocalService;
import gov.omsb.tms.service.FacultyRequestStatusLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + FacultyMembershipPortletKeys.FACULTYMEMBERSHIPREQUEST,
		"mvc.command.name="
				+ FacultyRequestConstants.ADD_FACULTY_REQUEST_ACTION_COMMAND }, service = MVCActionCommand.class)
public class AddFacultyRequestMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		log.info("**********************AddFacultyRequestMVCActionCommand Called*********************");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();
		long personId = ParamUtil.getLong(actionRequest, FacultyRequestConstants.PERSON_ID);
		long programId = ParamUtil.getLong(actionRequest, FacultyRequestConstants.PROGRAM_ID);
		long trainingSiteId = ParamUtil.getLong(actionRequest, FacultyRequestConstants.TRAINING_SITE_ID);
		String comments = ParamUtil.getString(actionRequest, FacultyRequestConstants.COMMENTS);
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		File file = uploadPortletRequest.getFile(FacultyRequestConstants.CURRICULAM_VITAE_KEY);
		String fileName = uploadPortletRequest.getFileName(FacultyRequestConstants.CURRICULAM_VITAE_KEY);
		String contentType = uploadPortletRequest.getContentType();

		DocumentInfoDTO documentInfoDTO = facultyDocumentUtil.addDocument(groupId, themeDisplay.getUserId(), file,
				fileName, contentType, fileName, personId);

		log.info("groupId " + groupId + "lrUserId " + themeDisplay.getUserId() + "personId " + personId + "programId "
				+ programId + "programId " + programId + "trainingSiteId " + trainingSiteId + "comments " + comments
				+ "documentInfoDTO " + documentInfoDTO);
		
		FacultyRequest facultyRequest = facultyRequestLocalService.addFacultyRequest(themeDisplay.getScopeGroupId(),
				themeDisplay.getUserId(), programId, documentInfoDTO.getFileEntryID());
		
		facultyRequestRotationsLocalService.addFacultyRequestRotations(themeDisplay.getScopeGroupId(),
				themeDisplay.getUserId(), facultyRequest.getFacultyRequestId(), trainingSiteId, true);
		
		String portletId = themeDisplay.getPortletDisplay().getId();
		PortletURL renderURL = PortletURLFactoryUtil.create(actionRequest, portletId, themeDisplay.getPlid(),
				PortletRequest.RENDER_PHASE);
		/*
		 * renderURL.getRenderParameters().setValue("mvcRenderCommandName",
		 * FacultyRequestConstants.VIEW_PAGE);
		 * renderURL.getRenderParameters().setValue(FacultyRequestConstants.
		 * FACULTY_REQUEST_ID, String.valueOf(facultyRequest.getFacultyRequestId()));
		 */
		membershipUtil.createNewRequest(facultyRequest, themeDisplay.getUser(), renderURL.toString());
		SessionMessages.add(actionRequest, "faculty-request-added-successfully");
	}

	private final Log log = LogFactoryUtil.getLog(AddFacultyRequestMVCActionCommand.class);

	@Reference
	private FacultyDocumentUtil facultyDocumentUtil;

	@Reference
	private FacultyRequestRotationsLocalService facultyRequestRotationsLocalService;

	@Reference
	private FacultyRequestLocalService facultyRequestLocalService;

	@Reference
	private FacultyRequestStateLocalService facultyRequestStateLocalService;

	@Reference
	private FacultyRequestStatusLocalService facultyRequestStatusLocalService;
	
	@Reference
	private MembershipUtil membershipUtil;

}
