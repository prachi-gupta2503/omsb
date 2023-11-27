package gov.omsb.faculty.membership.web.commands;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
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

import gov.omsb.faculty.membership.web.constants.FacultyMembershipConstants;
import gov.omsb.faculty.membership.web.constants.FacultyMembershipPortletKeys;
import gov.omsb.faculty.membership.web.constants.FacultyRequestConstants;
import gov.omsb.faculty.membership.web.constants.OmsbEcMembershipConstants;
import gov.omsb.faculty.membership.web.util.FacultyMemebershipUtil;
import gov.omsb.faculty.membership.web.util.MembershipUtil;
import gov.omsb.tms.model.FacultyBankDetails;
import gov.omsb.tms.model.FacultyRequest;
import gov.omsb.tms.service.FacultyBankDetailsLocalService;
import gov.omsb.tms.service.FacultyRequestLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + FacultyMembershipPortletKeys.FACULTYMEMBERSHIP,
		"javax.portlet.name=" + FacultyMembershipPortletKeys.FACULTYMEMBERSHIPREQUEST, "mvc.command.name="
				+ FacultyMembershipConstants.UPDATE_FACULTY_REQUEST_DETAILS_ACTION_COMMAND }, service = MVCActionCommand.class)
public class AddEditFacultyRequestDetailsMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		log.info("######### AddEditFacultyRequestDetailsMVCActionCommand Invoked #########");

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);

		String bankName = ParamUtil.getString(actionRequest, "bankName");
		String accountNumber = ParamUtil.getString(actionRequest, "accountNumber");
		String branchName = ParamUtil.getString(actionRequest, "branchName");

		long facultyRequestId = ParamUtil.getLong(actionRequest, "facultyRequestId");
		long passport_FileEntryId = 0;
		long nationalIdPrrof_FileEntryId = 0;

		File passportCopy = uploadPortletRequest.getFile("passportCopy");
		String passportCopyFileName = uploadPortletRequest.getFileName("passportCopy");
		String passportCopyContentType = uploadPortletRequest.getContentType("passportCopy");

		File nationalId = uploadPortletRequest.getFile("nationalID");
		String nationalIdProofFileName = uploadPortletRequest.getFileName("nationalID");
		String nationalIdContentType = uploadPortletRequest.getContentType("nationalID");

		if (Validator.isNotNull(passportCopyFileName)) {
			FileEntry fileEntry = facultyMemebershipUtil.uploadSingleFile(themeDisplay.getScopeGroupId(),
					facultyMemebershipUtil.generateFileName(passportCopyFileName), StringPool.BLANK,
					themeDisplay.getUserId(), passportCopyContentType, passportCopy);
			passport_FileEntryId = fileEntry.getFileEntryId();
		}

		if (Validator.isNotNull(nationalIdProofFileName)) {
			FileEntry fileEntry = facultyMemebershipUtil.uploadSingleFile(themeDisplay.getScopeGroupId(),
					facultyMemebershipUtil.generateFileName(nationalIdProofFileName), StringPool.BLANK,
					themeDisplay.getUserId(), nationalIdContentType, nationalId);
			nationalIdPrrof_FileEntryId = fileEntry.getFileEntryId();
		}

		log.info("PassportCopy File Name :: " + passportCopyFileName + ", File Type :: " + passportCopyContentType);
		log.info(
				"NationalId Proof File Name :: " + nationalIdProofFileName + ", File Type :: " + nationalIdContentType);

		// Updating Faculty Bank Details....
		FacultyBankDetails facultyBankDetails = facultyBankDetailsLocalService.findByFacultyRequestId(facultyRequestId);

		facultyBankDetails.setBankName(bankName);
		facultyBankDetails.setAccountNo(accountNumber);
		facultyBankDetails.setBankBranch(branchName);

		facultyBankDetails = facultyBankDetailsLocalService.updateFacultyBankDetails(facultyBankDetails);

		log.info("---- FACULTY BANK DETAILS UPDATED SUCCESSFULLY ----");

		// Updating Faculty Request Details....
		FacultyRequest facultyRequest = facultyRequestLocalService.getFacultyRequest(facultyRequestId);

		if (Validator.isNotNull(passportCopyFileName)) {
			facultyRequest.setPassportCopyId(passport_FileEntryId);
		}

		if (Validator.isNotNull(nationalIdProofFileName)) {
			facultyRequest.setNotionalIdCopyId(nationalIdPrrof_FileEntryId);
		}

		facultyRequest = facultyRequestLocalService.updateFacultyRequest(facultyRequest);

		log.info("---- FACULTY REQUEST DETAILS UPDATED SUCCESSFULLY ----");

		String workDetailsStr = ParamUtil.getString(actionRequest, "workflowTaskDetails");
		log.info("+=================workDetailsStr ============" + workDetailsStr);
		if (Validator.isNotNull(workDetailsStr)) {
			log.info("workDetails > " + workDetailsStr);
			JSONObject workflowDetails = JSONFactoryUtil.createJSONObject(workDetailsStr);
			long workflowInstanceId = workflowDetails.getLong(OmsbEcMembershipConstants.WORKFLOW_INSTANCE_ID);
			long taskId = workflowDetails.getLong(OmsbEcMembershipConstants.WORKFLOW_TASK_ID);
			String nextTransitionName = workflowDetails.getString(OmsbEcMembershipConstants.TRANSITION_NAME);
			try {
				log.info("workflowInstanceId > " + facultyRequest);
				membershipUtil.submitTask(themeDisplay, workflowInstanceId, taskId, nextTransitionName, "");
			} catch (PortalException ex) {
				log.debug(ex);
			}
		}

		SessionMessages.add(actionRequest, "faculty-request-membership-added-successfully");
	}

	@Reference
	private FacultyRequestLocalService facultyRequestLocalService;

	@Reference
	private FacultyBankDetailsLocalService facultyBankDetailsLocalService;

	@Reference
	private FacultyMemebershipUtil facultyMemebershipUtil;

	@Reference
	private MembershipUtil membershipUtil;

	private Log log = LogFactoryUtil.getLog(AddEditFacultyRequestDetailsMVCActionCommand.class.getName());

}