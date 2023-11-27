package gov.omsb.tms.ecm.web.commands;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys;
import gov.omsb.tms.ecm.web.constants.MVCCommandNames;
import gov.omsb.tms.ecm.web.dto.DocumentInfoItem;
import gov.omsb.tms.ecm.web.dto.EducationalDetailsItem;
import gov.omsb.tms.ecm.web.util.AddEditMemberDetailsUtil;
import gov.omsb.tms.ecm.web.util.MembershipUtil;
import gov.omsb.tms.model.EcMemberRequest;
import gov.omsb.tms.service.EcMemberRequestLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + ECMembershipRequestPortletKeys.ECMEMBERSHIPREQUEST,
		"mvc.command.name=" + MVCCommandNames.ADD_EC_MEMBER_EDUCATION_DETAILS

}, service = MVCResourceCommand.class)

public class AddEcMemberEducationDetailsMVCResourceCommand implements MVCResourceCommand {
	private final Log log = LogFactoryUtil.getLog(AddEcMemberEducationDetailsMVCResourceCommand.class);

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		log.info("resource invoked ::");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();
		long ecMemberRequestId = ParamUtil.getLong(resourceRequest, "ecMemberRequestId");
		log.info("AddEcMemberEducationDetailsMVCResourceCommand ecMemberRequestId--" + ecMemberRequestId);
		String title = ParamUtil.getString(resourceRequest, "title");
		String issuingAuthorityName = ParamUtil.getString(resourceRequest, "issuingAuthorityName");
		String gpa = ParamUtil.getString(resourceRequest, "gpa");
		long issuingAuthorityCountryId = ParamUtil.getLong(resourceRequest, "issuingAuthorityCountryName");
		int yearOfGraduation = ParamUtil.getInteger(resourceRequest, "yearOfGraduation");
		long educationDetailId = ParamUtil.getLong(resourceRequest, "educationDetailId");
		long qualificationDocumentId = ParamUtil.getLong(resourceRequest, "qualificationDocumentId");
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
		File file = uploadPortletRequest.getFile("qualificationDocument");
		String fileName = uploadPortletRequest.getFileName("qualificationDocument");
		String contentType = uploadPortletRequest.getContentType();
		String description = "QualificationDocument";
		EcMemberRequest ecMemberRequest = null;
		EducationalDetailsItem educationDetails = null;
		log.info("edit education---->>>> " + educationDetailId + "-----" + qualificationDocumentId);
		try {
			ecMemberRequest = ecMemberRequestLocalService.getEcMemberRequest(ecMemberRequestId);
			if (ecMemberRequest != null && educationDetailId > 0 && qualificationDocumentId > 0) {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(),
						resourceRequest);
				serviceContext.setAddGuestPermissions(true);
				long documentInfoId = 0;
				if (file.exists()) {
					DocumentInfoItem documentInfo = editQualificationDocument(qualificationDocumentId, themeDisplay,
							groupId, title, ecMemberRequest.getPotentialEcMemberLruserid(), file, fileName, contentType,
							description, ecMemberRequest);
				}
				educationDetails = editEducationDetails(educationDetailId, themeDisplay, groupId, title,
						issuingAuthorityName, gpa, issuingAuthorityCountryId, yearOfGraduation, ecMemberRequest);
			} else {
				educationDetails = addEducationDetails(themeDisplay, groupId, title, issuingAuthorityName, gpa,
						issuingAuthorityCountryId, yearOfGraduation, ecMemberRequest);
				DocumentInfoItem documentInfo = saveQalificationDocument(themeDisplay, groupId, title,
						ecMemberRequest.getPotentialEcMemberLruserid(), file, fileName, contentType, description,
						ecMemberRequest, educationDetails.getId());
			}

		} catch (PortalException e) {
			log.info("EcMember request not found");
		}

		return true;
	}

	// edit education and qualification details
	private DocumentInfoItem editQualificationDocument(long documentInfoId, ThemeDisplay themeDisplay, long groupId,
			String title, long userId, File file, String fileName, String contentType, String description,
			EcMemberRequest ecMemberRequest) {
		DocumentInfoItem documentInfo = null;
		try {
			FileEntry fileEntry = AddEditMemberDetailsUtil.uploadSingleFile(groupId, title,
					membershipUtil.generateFileName(fileName), description, userId, contentType, file);
			DocumentInfoItem documentInfoItem = fetchQualificationDocumentBydocumentInfoId(themeDisplay,
					documentInfoId);
			if (documentInfoItem != null) {
				documentInfoItem.setdFFileName(fileName);
				documentInfoItem.setDocumentType(description);
				documentInfoItem.setFileEntryID(fileEntry.getFileEntryId());
				documentInfoItem.setPersonId(ecMemberRequest.getPotentialEcMemberId());
				documentInfoItem.setId(documentInfoItem.getId());
				documentInfo = editDocumentInfo(documentInfoItem, documentInfoItem.getId(), themeDisplay);
			}
		} catch (UnsupportedEncodingException e) {
			log.error("Error in save and edit qualification document info:::");

		}

		return documentInfo;
	}

	public DocumentInfoItem editDocumentInfo(DocumentInfoItem documentInfoItem, long documentInfoId,
			ThemeDisplay themeDisplay) {
		String documentInfoUrl = omsbCommonApi.getBaseURL() + LRObjectURL.DELETE_DOCINFO + documentInfoId;
		Map<String, String> headers = omsbCommonApi.getHttpHeaderInfoAndBasicAuth();
		String personalDetailMapper = CustomObjectMapperUtil.writeValueAsString(documentInfoItem, null);
		String response = httpConnector.executePut(documentInfoUrl, personalDetailMapper, headers);
		return CustomObjectMapperUtil.readValue(response, DocumentInfoItem.class);
	}

	private DocumentInfoItem fetchQualificationDocumentBydocumentInfoId(ThemeDisplay themeDisplay, long documentId)
			throws UnsupportedEncodingException {
		String qualificationDocumentInfoUrl = themeDisplay.getPortalURL() + LRObjectURL.DELETE_DOCINFO + documentId;
		String qualificationDocumentInfoResponse = omsbCommonApi.getData(qualificationDocumentInfoUrl);
		DocumentInfoItem qualificationDocumentInfos = CustomObjectMapperUtil
				.readValue(qualificationDocumentInfoResponse, DocumentInfoItem.class);
		return qualificationDocumentInfos;
	}

	private EducationalDetailsItem editEducationDetails(long educationDetailId, ThemeDisplay themeDisplay, long groupId,
			String title, String issuingAuthorityName, String gpa, long issuingAuthorityCountryId, int yearOfGraduation,
			EcMemberRequest ecMemberRequest) {
		EducationalDetailsItem educationalDetailsItem = null;
		try {
			educationalDetailsItem = membershipUtil.fetchEducationDetailsItemByEducationId(themeDisplay,
					educationDetailId);
		} catch (UnsupportedEncodingException e) {
			log.info("Error" + e.getMessage());

		}
		if (educationalDetailsItem != null) {
			educationalDetailsItem.setGpa(gpa);
			educationalDetailsItem.setIssuingAuthorityCountryId(issuingAuthorityCountryId);
			educationalDetailsItem.setIssuingAuthorityName(issuingAuthorityName);
			educationalDetailsItem.setPersonId(ecMemberRequest.getPotentialEcMemberId());
			educationalDetailsItem.setQualificationAttained(title);
			educationalDetailsItem.setYearOfGraduation(yearOfGraduation);
			educationalDetailsItem.setId(educationDetailId);
			editEducationDetails(educationalDetailsItem, educationalDetailsItem.getId());
		}
		return educationalDetailsItem;
	}

	

	public EducationalDetailsItem editEducationDetails(EducationalDetailsItem educationalDetailsItem,
			long educationDetailId) {
		String educationDetailUrl = omsbCommonApi.getBaseURL() + LRObjectURL.PUT_EDUCATION_DETAIL_URL
				+ educationDetailId;
		Map<String, String> headers = omsbCommonApi.getHttpHeaderInfoAndBasicAuth();
		String educationDetailMapper = CustomObjectMapperUtil.writeValueAsString(educationalDetailsItem, null);
		String response = httpConnector.executePut(educationDetailUrl, educationDetailMapper, headers);
		return CustomObjectMapperUtil.readValue(response, EducationalDetailsItem.class);
	}

	// add education and qualification details
	private EducationalDetailsItem addEducationDetails(ThemeDisplay themeDisplay, long groupId, String title,
			String issuingAuthorityName, String gpa, long issuingAuthorityCountryId, int yearOfGraduation,
			EcMemberRequest ecMemberRequest) {
		EducationalDetailsItem educationalDetailItem = new EducationalDetailsItem();
		educationalDetailItem.setIssuingAuthorityName(issuingAuthorityName);
		educationalDetailItem.setGpa(gpa);
		educationalDetailItem.setIssuingAuthorityCountryId(issuingAuthorityCountryId);
		educationalDetailItem.setPersonId(ecMemberRequest.getPotentialEcMemberId());
		educationalDetailItem.setQualificationAttained(title);
		educationalDetailItem.setYearOfGraduation(yearOfGraduation);
		EducationalDetailsItem saveEducationDetails = saveEducationDetails(educationalDetailItem, groupId);
		return saveEducationDetails;

	}

	private EducationalDetailsItem saveEducationDetails(EducationalDetailsItem educationalDetailItem, long groupId) {
		String educationDetailUrl = generateScopeListURL(LRObjectURL.EDUCATION_DETAIL_URL, groupId);
		Map<String, String> headers = omsbCommonApi.getHttpHeaderInfoAndBasicAuth();
		String educationDetailMapper = CustomObjectMapperUtil.writeValueAsString(educationalDetailItem, null);
		String response = httpConnector.executePost(educationDetailUrl, educationDetailMapper, headers);
		return CustomObjectMapperUtil.readValue(response, EducationalDetailsItem.class);
	}

	private DocumentInfoItem saveQalificationDocument(ThemeDisplay themeDisplay, long groupId, String title,
			long userId, File file, String fileName, String contentType, String description,
			EcMemberRequest ecMemberRequest, long componentClassRefId) {
		FileEntry fileEntry = AddEditMemberDetailsUtil.uploadSingleFile(groupId, title,
				membershipUtil.generateFileName(fileName), description, userId, contentType, file);
		DocumentInfoItem saveDocumentInfo = new DocumentInfoItem();
		saveDocumentInfo.setId(saveDocumentInfo.getId());
		saveDocumentInfo.setdFFileName(fileName);
		saveDocumentInfo.setDocumentType(description);
		saveDocumentInfo.setFileEntryID(fileEntry.getFileEntryId());
		saveDocumentInfo.setPersonId(ecMemberRequest.getPotentialEcMemberId());
		saveDocumentInfo.setComponentClassRefId(componentClassRefId);
		DocumentInfoItem documentInfo = saveDocumentInfo(saveDocumentInfo, groupId);
		return documentInfo;
	}

	private DocumentInfoItem saveDocumentInfo(DocumentInfoItem documentInfoItem, long groupId) {
		String documentInfoUrl = generateScopeListURL(LRObjectURL.DOCUMENT_INFO_URL, groupId);
		Map<String, String> headers = omsbCommonApi.getHttpHeaderInfoAndBasicAuth();
		String documentDetailMapper = CustomObjectMapperUtil.writeValueAsString(documentInfoItem, null);
		String response = httpConnector.executePost(documentInfoUrl, documentDetailMapper, headers);
		return CustomObjectMapperUtil.readValue(response, DocumentInfoItem.class);
	}

	private String generateScopeListURL(String requestsUrl, long siteId) {
		return omsbCommonApi.getBaseURL() + requestsUrl.replace("{scope-id}", String.valueOf(siteId));
	}

	@Reference
	private OMSBCommonApi omsbCommonApi;
	@Reference
	private OMSBHttpConnector httpConnector;
	@Reference
	private EcMemberRequestLocalService ecMemberRequestLocalService;
	@Reference(unbind = "-")
	private MembershipUtil membershipUtil;

}
