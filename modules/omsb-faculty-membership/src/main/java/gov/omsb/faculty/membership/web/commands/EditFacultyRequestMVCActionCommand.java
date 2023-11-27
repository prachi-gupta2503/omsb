package gov.omsb.faculty.membership.web.commands;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
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
import com.liferay.portal.kernel.util.Validator;
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
import gov.omsb.faculty.membership.web.constants.OmsbEcMembershipConstants;
import gov.omsb.faculty.membership.web.dto.DocumentInfoDTO;
import gov.omsb.faculty.membership.web.util.FacultyDocumentUtil;
import gov.omsb.faculty.membership.web.util.MembershipUtil;
import gov.omsb.tms.model.FacultyRequest;
import gov.omsb.tms.service.FacultyRequestLocalService;
import gov.omsb.tms.service.FacultyRequestStateLocalService;
import gov.omsb.tms.service.FacultyRequestStatusLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + FacultyMembershipPortletKeys.FACULTYMEMBERSHIP,
		"mvc.command.name="
				+ FacultyRequestConstants.EDIT_FACULTY_REQUEST_ACTION_COMMAND }, service = MVCActionCommand.class)
public class EditFacultyRequestMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		LOGGER.info("edit faculty request method called");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();
		long facultyRequestId = ParamUtil.getLong(actionRequest, FacultyRequestConstants.FACULTY_REQUEST_ID);
		long facultyTypeId = ParamUtil.getLong(actionRequest, FacultyRequestConstants.FACULTY_TYPE_ID);
		long personId = ParamUtil.getLong(actionRequest, FacultyRequestConstants.PERSON_ID);
		String comments = ParamUtil.getString(actionRequest, FacultyRequestConstants.COMMENTS);
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		File file = uploadPortletRequest.getFile(FacultyRequestConstants.COVERING_LETTER_KEY);
		String fileName = uploadPortletRequest.getFileName(FacultyRequestConstants.COVERING_LETTER_KEY);
		String contentType = uploadPortletRequest.getContentType();

		DocumentInfoDTO documentInfoDTO = facultyDocumentUtil.addDocument(groupId, themeDisplay.getUserId(), file,
				fileName, contentType, fileName, personId);
		
		String portletId = themeDisplay.getPortletDisplay().getId();
		PortletURL renderURL = PortletURLFactoryUtil.create(actionRequest, portletId, themeDisplay.getPlid(),
				PortletRequest.RENDER_PHASE);
		FacultyRequest facultyRequest = facultyRequestLocalService.editFacultyRequest(themeDisplay.getUserId(), facultyRequestId, facultyTypeId, documentInfoDTO.getFileEntryID());
		String workDetailsStr = ParamUtil.getString(actionRequest, "workflowTaskDetails");
		LOGGER.info("+=================workDetailsStr ============"+workDetailsStr);
		if (Validator.isNotNull(workDetailsStr)) {
			LOGGER.info("workDetails > " + workDetailsStr);

			JSONObject workflowDetails = JSONFactoryUtil.createJSONObject(workDetailsStr);

			long workflowInstanceId = workflowDetails.getLong(OmsbEcMembershipConstants.WORKFLOW_INSTANCE_ID);
			long taskId = workflowDetails.getLong(OmsbEcMembershipConstants.WORKFLOW_TASK_ID);
			String nextTransitionName = workflowDetails.getString(OmsbEcMembershipConstants.TRANSITION_NAME);

			try {
				LOGGER.info("workflowInstanceId > "+facultyRequest);
				
				membershipUtil.submitTask(themeDisplay,workflowInstanceId, taskId, nextTransitionName, "" );
								
			} catch (PortalException ex) {
				LOGGER.debug(ex);;
			}
		}
		SessionMessages.add(actionRequest, "faculty-request-added-successfully");

	
	}

	@Reference
	private FacultyDocumentUtil facultyDocumentUtil;

	@Reference
	private FacultyRequestStatusLocalService facultyRequestStatusLocalService;

	@Reference
	private FacultyRequestStateLocalService facultyRequestStateLocalService;

	@Reference
	private FacultyRequestLocalService facultyRequestLocalService;
	
	@Reference
	MembershipUtil membershipUtil;

	private final Log LOGGER = LogFactoryUtil.getLog(EditFacultyRequestMVCActionCommand.class.getName());

}
