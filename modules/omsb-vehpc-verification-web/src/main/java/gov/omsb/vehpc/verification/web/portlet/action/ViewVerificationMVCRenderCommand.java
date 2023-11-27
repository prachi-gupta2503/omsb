package gov.omsb.vehpc.verification.web.portlet.action;

import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.util.DLURLHelperUtil;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.vehpc.verification.util.VerificationUtil;
import gov.omsb.verification.dto.CaseReport;
import gov.omsb.verification.dto.CaseStatus;
import gov.omsb.verification.dto.DocumentDetailCertificate;
import gov.omsb.verification.dto.DocumentInfo;
import gov.omsb.verification.dto.DocumentInfoItem;
import gov.omsb.verification.dto.EducationalDetail;
import gov.omsb.verification.dto.EducationalDetailItem;
import gov.omsb.verification.dto.EmploymentDetail;
import gov.omsb.verification.dto.EmploymentDetailItem;
import gov.omsb.verification.dto.HealthLicenceDetail;
import gov.omsb.verification.dto.HealthLicenceDetailItem;
import gov.omsb.verification.dto.PaymentDetail;
import gov.omsb.verification.dto.PaymentDetailItem;
import gov.omsb.verification.dto.PersonItem;
import gov.omsb.verification.dto.PersonalDetail;
import gov.omsb.verification.dto.PersonalDetailItem;
import gov.omsb.verification.dto.ReferencialDetail;
import omsb.vehpc.verification.web.constants.MVCCommands;
import omsb.vehpc.verification.web.constants.OmsbVehpcVerificationWebPortletKeys;
import omsb.vehpc.verification.web.constants.VerificationJSPPath;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbVehpcVerificationWebPortletKeys.OMSBVEHPCVERIFICATIONWEB,
		"mvc.command.name=" + MVCCommands.VIEW_PERSONAL_DETAILS }, service = MVCRenderCommand.class

)
public class ViewVerificationMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		_log.info("render()>>ViewVerification>>started>>>>");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String groupId = String.valueOf(themeDisplay.getScopeGroupId());
		String caseRequestID = String.valueOf(ParamUtil.getString(renderRequest, "caseRequestId"));
		try {
			String personalDetailUrl = themeDisplay.getPortalURL() + LRObjectURL.PERSONAL_DETAIL_URL.replace(DataflowConstants.SCOPE_ID_VAR, groupId) + StringPool.QUESTION + "filter=caseRequestId" + URLEncoder.encode(" eq " + caseRequestID, DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
			String personalDetailResponse = omsbCommonApi.getData(personalDetailUrl);
		PersonalDetail personalDetails = CustomObjectMapperUtil.readValue(personalDetailResponse, PersonalDetail.class);
		PersonItem persons=null;
		CaseStatus caseStatus = null;
		
		if(Validator.isNotNull(personalDetails) && personalDetails.getItems().size()>0) {
			for(PersonalDetailItem personalDetail : personalDetails.getItems()) {
				if(personalDetail.getCountryId()>0) {
					personalDetail.setCountryName(verificationUtil.getCountryName(themeDisplay, personalDetail.getCountryId()));
				}
				if(personalDetail.getNationalityCountryId()>0) {
					personalDetail.setNationalityCountryName(verificationUtil.getCountryName(themeDisplay, personalDetail.getNationalityCountryId()));
				}
				String caseRequestUrl = themeDisplay.getPortalURL() + LRObjectURL.CASE_REQUEST_BY_PK_URL+StringPool.FORWARD_SLASH+personalDetail.getCaseRequestId();
				String caseRequestResponse = omsbCommonApi.getData(caseRequestUrl);
				_log.info(caseRequestUrl+":::::::::::::caseRequestResponse:::::::::"+caseRequestResponse);
				
				gov.omsb.common.dto.CaseRequest caseRequest = CustomObjectMapperUtil.readValue(caseRequestResponse, gov.omsb.common.dto.CaseRequest.class);
				if(Validator.isNotNull(caseRequest.getPersonId())) {
					
					String personsUrl = themeDisplay.getPortalURL() + LRObjectURL.PERSON_BY_PK_URL+StringPool.FORWARD_SLASH+caseRequest.getPersonId();
					String personsResponse = omsbCommonApi.getData(personsUrl);
					_log.info(personsUrl+":::::::::::::personsResponse:::::::::"+personsResponse);
					persons = CustomObjectMapperUtil.readValue(personsResponse, PersonItem.class);
					persons.setDateOfBirth(omsbCommonApi.convertObjectDateToDDMMYYYYDate(persons.getDateOfBirth()));
					String caseStatusId =String.valueOf(Validator.isNotNull(caseRequest.getCaseStatusId()) ? caseRequest.getCaseStatusId() : "");
					String caseStatusUrl =  themeDisplay.getPortalURL() + LRObjectURL.CASE_STATUS_URL.replace(DataflowConstants.SCOPE_ID_VAR, groupId) + StringPool.QUESTION + "filter=id" + URLEncoder.encode(" eq " + "'"+ caseStatusId +"'", DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
					String caseStatusResponse = omsbCommonApi.getData(caseStatusUrl);
					_log.info(caseStatusUrl+":::::::::::::caseStatusResponse:::::::::"+caseStatusResponse);
					caseStatus = CustomObjectMapperUtil.readValue(caseStatusResponse, CaseStatus.class);
					String componentClassRefId =String.valueOf(Validator.isNotNull(personalDetail.getId())? (personalDetail.getId()):"");
					String documentInfoUrl = themeDisplay.getPortalURL() + LRObjectURL.DOCUMENT_INFO_URL.replace(DataflowConstants.SCOPE_ID_VAR, groupId) + StringPool.QUESTION + "filter=componentClassRefId" + URLEncoder.encode(" eq " + componentClassRefId, DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
					String documentInfoResponse = omsbCommonApi.getData(documentInfoUrl);
					_log.info(componentClassRefId+" , documentInfoUrl : "+documentInfoUrl+"  , ,documentInfoResponse :  :"+documentInfoResponse);
					DocumentInfo documentInfos = CustomObjectMapperUtil.readValue(documentInfoResponse, DocumentInfo.class);
					if(Validator.isNotNull(documentInfos) && Validator.isNotNull(documentInfos.getItems())) {
						List<DocumentDetailCertificate> certificates = new ArrayList<>();
						for(DocumentInfoItem documentInfoItem: documentInfos.getItems()) {
							String personalUrl = Validator.isNotNull(getFileEntry(documentInfoItem.getFileEntryID())) ? getFileEntry(documentInfoItem.getFileEntryID()) : "";
							DocumentDetailCertificate certificate = new DocumentDetailCertificate();
			                certificate.setPersonalCertificateUrl(personalUrl);
			                certificate.setPersonalCertificateName(documentInfoItem.getDocumentType());
			                certificates.add(certificate);
							_log.info("ed cert url>>>>>>>>>>>>>>"+(Validator.isNotNull(getFileEntry(documentInfoItem.getFileEntryID())) ? getFileEntry(documentInfoItem.getFileEntryID()):""));
						}
						personalDetail.setItems(certificates);
					
					}
				}
			}
		}
		
		renderRequest.setAttribute("personalDetail", personalDetails.getItems().get(0));
		renderRequest.setAttribute("person", persons);
		if(Validator.isNotNull(caseStatus) && Validator.isNotNull(caseStatus.getItems())) {
		renderRequest.setAttribute("caseStatusItem", Validator.isNotNull(caseStatus.getItems().get(0).getCaseStatus().getName()) ? caseStatus.getItems().get(0).getCaseStatus().getName() : "");
		}
		} catch (Exception e) {
			_log.error(e.getMessage());
			_log.trace(e);
		}
		
		
		try {
			String educationDetailUrl = themeDisplay.getPortalURL() + LRObjectURL.EDUCATION_DETAIL_URL.replace(DataflowConstants.SCOPE_ID_VAR, groupId) + StringPool.QUESTION + "filter=caseRequestId" + URLEncoder.encode(" eq " + caseRequestID, DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
		
		String educationDetailResponse = omsbCommonApi.getData(educationDetailUrl);
		EducationalDetail educationDetails = CustomObjectMapperUtil.readValue(educationDetailResponse, EducationalDetail.class);
		if(Validator.isNotNull(educationDetails) && Validator.isNotNull(educationDetails.getItems())&& !educationDetails.getItems().isEmpty()) {
			_log.debug("educationDetailResponse>>>>>>>educationDetailResponse>>"+educationDetailResponse);
			_log.debug("inside education if consdition>>>>>>>size>>"+educationDetails.getItems().size());
			for(EducationalDetailItem educationDetail : educationDetails.getItems()) {
				String qualificationConferredDate = omsbCommonApi.convertObjectDateToDDMMYYYYDate(educationDetail.getQualificationConferredDate());
				educationDetail.setQualificationConferredDate(Validator.isNotNull(qualificationConferredDate) ? qualificationConferredDate : "");
				if(educationDetail.getIssuingAuthorityCountryId()>0) {
					educationDetail.setIssuingAuthorityCountryName(verificationUtil.getCountryName(themeDisplay, educationDetail.getIssuingAuthorityCountryId()));	
				} 
				educationDetail = setEducation(educationDetail, themeDisplay);
				
				_log.info("mode of study ?? " + educationDetail.getModeOfStudy());
				String componentClassRefId =String.valueOf(Validator.isNotNull(educationDetail.getId())? (educationDetail.getId()):"");
				String documentInfoUrl = themeDisplay.getPortalURL() + LRObjectURL.DOCUMENT_INFO_URL.replace(DataflowConstants.SCOPE_ID_VAR, groupId) + StringPool.QUESTION + "filter=componentClassRefId" + URLEncoder.encode(" eq " + componentClassRefId, DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
				String documentInfoResponse = omsbCommonApi.getData(documentInfoUrl);
				_log.info("componentClassRefId : "+componentClassRefId+" , documentInfoUrl  "+documentInfoUrl+":::documentInfoResponse"+documentInfoResponse);
				DocumentInfo documentInfos = CustomObjectMapperUtil.readValue(documentInfoResponse, DocumentInfo.class);
				if(Validator.isNotNull(documentInfos) && Validator.isNotNull(documentInfos.getItems())) {
					List<DocumentDetailCertificate> certificates = new ArrayList<>();
					for(DocumentInfoItem documentInfoItem: documentInfos.getItems()) {
						 String educationCertificateUrl = Validator.isNotNull(getFileEntry(documentInfoItem.getFileEntryID())) ? getFileEntry(documentInfoItem.getFileEntryID()) : "";
						DocumentDetailCertificate certificate = new DocumentDetailCertificate();
		                certificate.setEducationCertificateUrl(educationCertificateUrl);
		                certificate.setEducationCertificateName(documentInfoItem.getDocumentType());
		                certificates.add(certificate);
						_log.debug("ed cert url>>>>>>>>>>>>>>"+(Validator.isNotNull(getFileEntry(documentInfoItem.getFileEntryID())) ? getFileEntry(documentInfoItem.getFileEntryID()):""));
					}
					educationDetail.setItems(certificates);
				}
			}
			
			renderRequest.setAttribute("educationDetail", educationDetails.getItems());
		}
		} catch (Exception e) {
			_log.error(e.getMessage());
			_log.trace(e);
		}
		

		try {
			String employmentUrl = themeDisplay.getPortalURL() + LRObjectURL.EMPLOYMENT_DETAIL_URL.replace(DataflowConstants.SCOPE_ID_VAR, groupId) + StringPool.QUESTION + "filter=caseRequestID" + URLEncoder.encode(" eq " + caseRequestID, DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
		
		String employmentResponse = omsbCommonApi.getData(employmentUrl);
		EmploymentDetail employmentDetails = CustomObjectMapperUtil.readValue(employmentResponse, EmploymentDetail.class);
		if(Validator.isNotNull(employmentDetails)) {
			for(EmploymentDetailItem employmentDetail : employmentDetails.getItems()) {
				String employmentPeriodFrom = omsbCommonApi.convertObjectDateToDDMMYYYYDate(employmentDetail.getEmploymentPeriodFrom());
				employmentDetail.setEmploymentPeriodFrom(employmentPeriodFrom);
				String employmentPeriodTo = omsbCommonApi.convertObjectDateToDDMMYYYYDate(employmentDetail.getEmploymentPeriodTo());
				employmentDetail.setEmploymentPeriodTo(employmentPeriodTo);
				if(employmentDetail.getIssuingAuthorityCountryId()>0) {
					employmentDetail.setIssuingAuthorityCountryName(verificationUtil.getCountryName(themeDisplay, employmentDetail.getIssuingAuthorityCountryId()));
				}
				String componentClassRefId =String.valueOf(Validator.isNotNull(employmentDetail.getId())? (employmentDetail.getId()):"");
				String documentInfoUrl = themeDisplay.getPortalURL() + LRObjectURL.DOCUMENT_INFO_URL.replace(DataflowConstants.SCOPE_ID_VAR, groupId) + StringPool.QUESTION + "filter=componentClassRefId" + URLEncoder.encode(" eq " + componentClassRefId, DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
				String documentInfoResponse = omsbCommonApi.getData(documentInfoUrl);
				DocumentInfo documentInfos = CustomObjectMapperUtil.readValue(documentInfoResponse, DocumentInfo.class);
				if(Validator.isNotNull(documentInfos) && Validator.isNotNull(documentInfos.getItems())) {
					List<DocumentDetailCertificate> certificates = new ArrayList<>();
					for(DocumentInfoItem documentInfoItem: documentInfos.getItems()) {
						String employmentCertificateUrl = Validator.isNotNull(getFileEntry(documentInfoItem.getFileEntryID())) ? getFileEntry(documentInfoItem.getFileEntryID()) : "";
						DocumentDetailCertificate certificate = new DocumentDetailCertificate();
						certificate.setEmploymentCertificateUrl(employmentCertificateUrl);
						certificate.setEmploymentCertificateName(documentInfoItem.getDocumentType());
		                certificates.add(certificate);
				     }
					employmentDetail.setItems(certificates);
			}
			}
			renderRequest.setAttribute("employmentDetail", employmentDetails.getItems());
		}
		} catch (Exception e) {
			_log.error(e.getMessage());
			_log.trace(e);
		}
		
		try {
			String healthLicenceDetailUrl = themeDisplay.getPortalURL() + LRObjectURL.HEALTH_LICENSE_DETAIL_URL.replace(DataflowConstants.SCOPE_ID_VAR, groupId) + StringPool.QUESTION + "filter=caseRequestID" + URLEncoder.encode(" eq " + caseRequestID, DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
		
		String healthLicenceDetailResponse = omsbCommonApi.getData(healthLicenceDetailUrl);
		_log.info("healthLicenceDetailResponse::::::::::"+healthLicenceDetailResponse);
		HealthLicenceDetail healthLicenceDetails = CustomObjectMapperUtil.readValue(healthLicenceDetailResponse, HealthLicenceDetail.class);
		if(Validator.isNotNull(healthLicenceDetails)) {
			for(HealthLicenceDetailItem healthLicence : healthLicenceDetails.getItems()) {
				String licenseConferredDate = omsbCommonApi.convertObjectDateToDDMMYYYYDate(healthLicence.getLicenseConferredDate());
				healthLicence.setLicenseConferredDate(licenseConferredDate);
				String licenseExpiryDate = omsbCommonApi.convertObjectDateToDDMMYYYYDate(healthLicence.getLicenseExpiryDate());
				healthLicence.setLicenseExpiryDate(licenseExpiryDate);
				
				String componentClassRefId =String.valueOf(Validator.isNotNull(healthLicence.getId())? (healthLicence.getId()):"");
				String documentInfoUrl = themeDisplay.getPortalURL() + LRObjectURL.DOCUMENT_INFO_URL.replace(DataflowConstants.SCOPE_ID_VAR, groupId) + StringPool.QUESTION + "filter=componentClassRefId" + URLEncoder.encode(" eq " + componentClassRefId, DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
				String documentInfoResponse = omsbCommonApi.getData(documentInfoUrl);
				DocumentInfo documentInfos = CustomObjectMapperUtil.readValue(documentInfoResponse, DocumentInfo.class);
				if(Validator.isNotNull(documentInfos) && Validator.isNotNull(documentInfos.getItems())) {
					List<DocumentDetailCertificate> certificates = new ArrayList<>();
					for(DocumentInfoItem documentInfoItem: documentInfos.getItems()) {
						String healthCertificateUrl = Validator.isNotNull(getFileEntry(documentInfoItem.getFileEntryID())) ? getFileEntry(documentInfoItem.getFileEntryID()) : "";
						DocumentDetailCertificate certificate = new DocumentDetailCertificate();
						certificate.setHealthCertificateUrl(healthCertificateUrl);
						certificate.setHealthCertificateName(documentInfoItem.getDocumentType());
		                certificates.add(certificate);
				     }
					healthLicence.setItems(certificates);
			}

			}
			renderRequest.setAttribute("healthLicenceDetail", healthLicenceDetails.getItems());
		}
		} catch (Exception e) {
			_log.error(e.getMessage(),e );
			_log.trace(e);
		}
		

		String referenceUrl = null;
		try {
			referenceUrl = themeDisplay.getPortalURL() + LRObjectURL.REFERENCE_DETAIL_URL.replace(DataflowConstants.SCOPE_ID_VAR, groupId) + StringPool.QUESTION + "filter=caseRequestId" + URLEncoder.encode(" eq " + caseRequestID, DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
		} catch (Exception e) {
			_log.error(e.getMessage());
			_log.trace(e);
		}
		
		String referenceResponse = omsbCommonApi.getData(referenceUrl);
		ReferencialDetail referencialDetail = CustomObjectMapperUtil.readValue(referenceResponse, ReferencialDetail.class);
		if(Validator.isNotNull(referencialDetail)) {
		renderRequest.setAttribute("referencialDetail", referencialDetail.getItems());
		}

		try {
			String paymentDetailUrl = themeDisplay.getPortalURL() + LRObjectURL.PAYMENT_DETAIL_URL.replace(DataflowConstants.SCOPE_ID_VAR, groupId) + StringPool.QUESTION + "filter=caseRequestId" + URLEncoder.encode(" eq " + caseRequestID, DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
			String paymentDetailResponse = omsbCommonApi.getData(paymentDetailUrl);
			
			PaymentDetail paymentDetails = CustomObjectMapperUtil.readValue(paymentDetailResponse, PaymentDetail.class);
			_log.info(paymentDetailUrl+"  , paymentDetailResponse : "+paymentDetailResponse+",,,,,,,,,,"+paymentDetails.getItems().get(0).getPaymentDate());
			if(Validator.isNotNull(paymentDetails) && paymentDetails.getItems().size()>0) {
			renderRequest.setAttribute("paymentDetail", paymentDetails.getItems());
		}
		} catch (Exception e) {
			_log.error(e.getMessage());
			_log.trace(e);
		}
		
		try {
			String caseReportUrl = themeDisplay.getPortalURL() + LRObjectURL.CASE_REPORTS_URL + CommonConstants.SCOPES + StringPool.SLASH + groupId + StringPool.QUESTION + "filter=caseRequestId" + URLEncoder.encode(" eq " + caseRequestID, DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
			String caseReportUrlResponse = omsbCommonApi.getData(caseReportUrl);
			CaseReport caseReports = CustomObjectMapperUtil.readValue(caseReportUrlResponse, CaseReport.class);
			String caseReportsFileURL = "";
			if(Validator.isNotNull(caseReports) &&  caseReports.getItems().size()>0 ) {
				_log.debug("inside if of case report>>>>");
				caseReportsFileURL = getFileEntry(caseReports.getItems().get(0).getFileEntryId());
				renderRequest.setAttribute("caseReportsFileURL", caseReportsFileURL);
				renderRequest.setAttribute("fileName", caseReports.getItems().get(0).getFileName());
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
			_log.trace(e);
		}
		
		_log.info("render()>>ViewVerification>>method ended>>>>");
		return VerificationJSPPath.VIEW_PERSONAL_DETAILS_JSP;
	}

	private String getFileEntry(long fileEntryId) {
        try {
        	FileEntry fileEntry = DLAppServiceUtil.getFileEntry(fileEntryId);
            String url = DLURLHelperUtil.getPreviewURL(fileEntry, fileEntry.getLatestFileVersion(), null, "");
            _log.debug("url ?? " + url);
            return url;
        } catch (PortalException e) {
        	_log.error(e.getMessage());
			_log.trace(e);
        }
        return null;
	}
	
	private EducationalDetailItem setEducation(EducationalDetailItem educationDetail, ThemeDisplay themeDisplay) {
		ListTypeEntry university = null;
		ListTypeEntry qualification = null;
		try {
			university = omsbCommonApi.getListTypeEntryBylistTypeEntryId(Long.parseLong(educationDetail.getIssuingAuthorityName()));
		} catch (NumberFormatException e) {
			_log.error("Excpetion while getting the IssuingAuthorityName ::: ", e);
		}
		if (Validator.isNotNull(university)) {
			educationDetail.setIssuingAuthorityName(university.getName(themeDisplay.getLocale()));
		}
		
		qualification = omsbCommonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.QUALIFICATION, educationDetail.getQualificationAttained(),
				themeDisplay.getCompanyId());
		if (Validator.isNotNull(qualification)) {
			educationDetail.setQualificationAttained(qualification.getName(themeDisplay.getLocale()));
		}
		return educationDetail;
	}
	@Reference(unbind = "_")
	private VerificationUtil verificationUtil;
	@Reference(unbind="-")
	private OMSBCommonApi omsbCommonApi;
	@Reference(unbind="-")
	private OMSBCommonApi oMSBCommonService;
	private static final Log _log = LogFactoryUtil.getLog(ViewVerificationMVCRenderCommand.class);

}
