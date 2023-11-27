package gov.omsb.faculty.membership.web.commands;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.dto.DocumentInfo;
import gov.omsb.common.dto.EducationDetail;
import gov.omsb.faculty.membership.web.constants.FacultyMembershipConstants;
import gov.omsb.faculty.membership.web.constants.FacultyMembershipPortletKeys;
import gov.omsb.faculty.membership.web.util.FacultyMemebershipUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + FacultyMembershipPortletKeys.FACULTYMEMBERSHIP,
		"mvc.command.name="
				+ FacultyMembershipConstants.ADD_EDUCATION_DETAILS_RESOURCE_COMMAND }, service = MVCResourceCommand.class)
public class AddEducationDetailsMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long personId = ParamUtil.getLong(resourceRequest, "personId");
		String title = ParamUtil.getString(resourceRequest, "addEducationTitle");
		String issuingAuthorityName = ParamUtil.getString(resourceRequest, "institution");
		long issuingAuthorityCountryId = ParamUtil.getLong(resourceRequest, "country");
		String gpa = ParamUtil.getString(resourceRequest, "gpa");
		long yearOfGraduation = ParamUtil.getLong(resourceRequest, "year");

		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
		File qualificationDocument = uploadPortletRequest.getFile("qualificationDocument");
		String qualificationDocumentFileName = uploadPortletRequest.getFileName("qualificationDocument");
		String qualificationDocumentContentType = uploadPortletRequest.getContentType();

		log.info("Person Id :: " + personId);
		log.info("Title :: " + title);
		log.info("Institution :: " + issuingAuthorityName);
		log.info("Country Id :: " + issuingAuthorityCountryId);
		log.info("GPA :: " + gpa);
		log.info("Year :: " + yearOfGraduation);
		log.info("FileName :: " + qualificationDocumentFileName);

		EducationDetail educationDetail = facultyMemebershipUtil.addEducationDetails(themeDisplay, title,
				issuingAuthorityName, gpa, issuingAuthorityCountryId, yearOfGraduation, personId);

		log.info("Education Detail Id :: " + educationDetail.getId());

		if (Validator.isNotNull(qualificationDocumentFileName)) {
			FileEntry fileEntry = facultyMemebershipUtil.uploadSingleFile(themeDisplay.getScopeGroupId(),
					facultyMemebershipUtil.generateFileName(qualificationDocumentFileName), StringPool.BLANK,
					themeDisplay.getUserId(), qualificationDocumentContentType, qualificationDocument);

			long fileEntryId = fileEntry.getFileEntryId();
			long componentClassRefId = educationDetail.getId();

			DocumentInfo documentInfo = facultyMemebershipUtil.saveQalificationDocument(themeDisplay,
					qualificationDocumentFileName, qualificationDocumentContentType, fileEntryId, componentClassRefId);

		}

		JSONObject responseJSONObj = JSONFactoryUtil.createJSONObject();

		if (Validator.isNotNull(educationDetail)) {
			responseJSONObj.put(FacultyMembershipConstants.STATUS_KEY, FacultyMembershipConstants.SUCCESS);
			responseJSONObj.put(FacultyMembershipConstants.MESSAGE_KEY, StringPool.BLANK);
		} else {
			responseJSONObj.put(FacultyMembershipConstants.STATUS_KEY, FacultyMembershipConstants.FAIL);
			responseJSONObj.put(FacultyMembershipConstants.MESSAGE_KEY, StringPool.BLANK);
		}

		resourceResponse.getWriter().write(responseJSONObj.toJSONString());

	}

	@Reference
	private FacultyMemebershipUtil facultyMemebershipUtil;

	private Log log = LogFactoryUtil.getLog(AddEducationDetailsMVCResourceCommand.class.getName());

}