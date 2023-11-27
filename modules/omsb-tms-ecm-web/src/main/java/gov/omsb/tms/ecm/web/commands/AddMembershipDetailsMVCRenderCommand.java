package gov.omsb.tms.ecm.web.commands;

import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.util.DLURLHelperUtil;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeDefinitionLocalServiceUtil;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.CountryLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.dto.Person;
import gov.omsb.common.dto.PersonalDetail;
import gov.omsb.common.dto.PersonalDetailItem;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys;
import gov.omsb.tms.ecm.web.constants.MVCCommandNames;
import gov.omsb.tms.ecm.web.constants.OmsbEcMembershipConstants;
import gov.omsb.tms.ecm.web.dto.CustomCountry;
import gov.omsb.tms.ecm.web.dto.CustomCountryItems;
import gov.omsb.tms.ecm.web.dto.DocumentInfo;
import gov.omsb.tms.ecm.web.dto.DocumentInfoItem;
import gov.omsb.tms.ecm.web.dto.EducationDetail;
import gov.omsb.tms.ecm.web.dto.EducationalDetailsItem;
import gov.omsb.tms.ecm.web.dto.ViewEcMemberRequestDTO;
import gov.omsb.tms.ecm.web.dto.WorkflowTaskDetail;
import gov.omsb.tms.ecm.web.util.MembershipUtil;
import gov.omsb.tms.model.BankDetails;
import gov.omsb.tms.model.EcMemberRequest;
import gov.omsb.tms.service.BankDetailsLocalService;
import gov.omsb.tms.service.EcMemberRequestLocalService;
import gov.omsb.tms.service.EcMemberRequestStateLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + ECMembershipRequestPortletKeys.ECMEMBERSHIPREQUEST,
		"mvc.command.name=" + MVCCommandNames.ADD_MEMBERSHIP_DETAILS_VIEW }, service = MVCRenderCommand.class

)
public class AddMembershipDetailsMVCRenderCommand implements MVCRenderCommand {
	private static final Log log = LogFactoryUtil.getLog(AddMembershipDetailsMVCRenderCommand.class);

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		log.info(" render invoked :: ");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String objectName = OmsbEcMembershipConstants.CUSTOM_COUNTRY_OBJECT_TABLE_NAME;
		long ecMemberRequestId = ParamUtil.getLong(renderRequest, "ecMemberRequestId");
		log.info("AddMembershipDetailsMVCRenderCommand  ecMemberRequestId--" + ecMemberRequestId);
		renderRequest.setAttribute("ecMemberRequestId", ecMemberRequestId);
		long lruserId = themeDisplay.getUserId();
		EcMemberRequest ecMemberRequest = null;
		try {
			ecMemberRequest = ecMemberRequestLocalService.getEcMemberRequest(ecMemberRequestId);
		} catch (PortalException e1) {
			log.error(e1);
			throw new PortletException(e1);
		}
		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		WorkflowTaskDetail workflowTaskDetail = MembershipUtil.getMemberRequestWorkflowDetail(httpRequest, themeDisplay,
				ecMemberRequest);

		renderRequest.setAttribute("workflowTaskDetail", workflowTaskDetail);
		List<ListTypeEntry> qualificationList = getPickListEntries(LRPicklistConstants.QUALIFICATION,
				themeDisplay.getCompanyId());
		renderRequest.setAttribute("qualificationList", qualificationList);

		List<Country> countries = CountryLocalServiceUtil.getCountries(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		renderRequest.setAttribute("countryList", countries);
		ViewEcMemberRequestDTO viewEcMemberRequestDTO = new ViewEcMemberRequestDTO();
		Role role = membershipUtil.setRoleAndProgramData(viewEcMemberRequestDTO, themeDisplay, ecMemberRequest);
		membershipUtil.setCommentsSectionData(viewEcMemberRequestDTO, ecMemberRequestId, role, themeDisplay.getUser(),
				ecMemberRequest);
		renderRequest.setAttribute("memberDetails", viewEcMemberRequestDTO);
		long personId = ecMemberRequest.getPotentialEcMemberId();
		FileEntry fileEntry = null;
		String civilCardBackPhotoUrl = null;
		String civilCardFrontPhotoUrl = null;
		String passportDocumentUrl = null;
		Person person=null;
		PersonalDetail personalDetail=null;
		try {
			 personalDetail = membershipUtil.fetchPersonalDetailsByPersonId(themeDisplay, lruserId);
			log.info("personalDetail " + personalDetail);
			 person = membershipUtil.getPersonById(themeDisplay, personalDetail.getPersonId());
			log.info("person " + person);
			if(person.getCivilId()!=null || !person.getCivilId().isBlank()) {
			renderRequest.setAttribute("civilId", person.getCivilId());
			fileEntry = DLAppServiceUtil.getFileEntry(personalDetail.getCivilCardFrontPhotoId());
			civilCardFrontPhotoUrl = DLURLHelperUtil.getPreviewURL(fileEntry, fileEntry.getLatestFileVersion(), null,
					"");
			log.info("civilCardFrontPhotoUrl " + civilCardFrontPhotoUrl);
			renderRequest.setAttribute("civilCardFrontPhotoUrl", civilCardFrontPhotoUrl);
			fileEntry = DLAppServiceUtil.getFileEntry(personalDetail.getCivilCardBackPhotoId());
			civilCardBackPhotoUrl = DLURLHelperUtil.getPreviewURL(fileEntry, fileEntry.getLatestFileVersion(), null,
					"");
			log.info("civilCardBackPhotoUrl " + civilCardBackPhotoUrl);
			renderRequest.setAttribute("civilCardBackPhotoUrl", civilCardBackPhotoUrl);
			}
		} catch (UnsupportedEncodingException | PortalException e1) {
			log.error("Error " + e1);
		}
		try {
			if(person.getPassportNumber()!=null || !person.getPassportNumber().isBlank()) {
				renderRequest.setAttribute("passportNumber", person.getPassportNumber());
			log.info("passportId " +personalDetail.getPassportPhotoId());
			fileEntry = DLAppServiceUtil.getFileEntry(personalDetail.getPassportPhotoId());
			passportDocumentUrl = DLURLHelperUtil.getPreviewURL(fileEntry, fileEntry.getLatestFileVersion(), null, "");
			log.info("passportDocumentUrl " +passportDocumentUrl);
			renderRequest.setAttribute("passportDocumentUrl", passportDocumentUrl);
			}
		} catch (Exception e1) {
			log.error("Error " + e1);
		}

		try {

			BankDetails bankDetails = bankDetailsLocalService.findByEcMemberRequestId(ecMemberRequestId);
			log.error("bankDetails " + bankDetails);
			renderRequest.setAttribute("bankDetails", bankDetails);
		} catch (Exception e) {
			log.error("Error in fetching documment info id" + e);
		}
		return OmsbEcMembershipConstants.EDIT_MEMBERSHIP_DETAILS_URL;

	}

	public String getCountryName(ThemeDisplay themeDisplay, long countryId) {
		CustomCountryItems countryItemResponse = null;
		String countryName = null;
		try {
			String url = themeDisplay.getPortalURL() + LRObjectURL.REG_CUSTOM_COUNTRY_URL + countryId;
			String customCuntryResponse = omsbCommonApi.getData(url);

			countryItemResponse = CustomObjectMapperUtil.readValue(customCuntryResponse, CustomCountryItems.class);
			if (countryItemResponse != null) {
				countryName = countryItemResponse.getNationality();
			}
		} catch (NullPointerException e) {
			log.info(e.getMessage());
		}
		return countryName;
	}

	public EducationalDetailsItem fetchEducationDetailsItem(ThemeDisplay themeDisplay, long personId)
			throws UnsupportedEncodingException {
		String educationDetailUrl = themeDisplay.getPortalURL()
				+ LRObjectURL.EDUCATION_DETAIL_URL.replace(DataflowConstants.SCOPE_ID_VAR,
						String.valueOf(themeDisplay.getScopeGroupId()))
				+ StringPool.QUESTION + "filter=personId"
				+ URLEncoder.encode(" eq " + personId, DataflowConstants.UTF_8);
		String educationDetailResponse = omsbCommonApi.getData(educationDetailUrl);
		EducationDetail educationDetails = CustomObjectMapperUtil.readValue(educationDetailResponse,
				EducationDetail.class);
		EducationalDetailsItem educationalDetailsItem = null;
		if (Validator.isNotNull(educationDetails) && Validator.isNotNull(educationDetails.getItems())
				&& educationDetails.getItems().size() > 0) {
			educationalDetailsItem = educationDetails.getItems().get(0);
		}
		return educationalDetailsItem;

	}

	private PersonalDetail fetchPersonalDetailsByPersonId(ThemeDisplay themeDisplay, long lruserId)
			throws UnsupportedEncodingException {
		String personalDetailsUrl = themeDisplay.getPortalURL()
				+ LRObjectURL.DOCUMENT_INFO_URL.replace(DataflowConstants.SCOPE_ID_VAR,
						String.valueOf(themeDisplay.getScopeGroupId()))
				+ StringPool.QUESTION + "filter=personId"
				+ URLEncoder.encode(" eq " + lruserId, DataflowConstants.UTF_8);
		log.info("personalDetailsUrl=====>" + personalDetailsUrl);
		String personalDetailsResponse = omsbCommonApi.getData(personalDetailsUrl);
		log.info("personalDetailsResponse====>" + personalDetailsResponse);
		PersonalDetailItem personalDetailsItem = CustomObjectMapperUtil.readValue(personalDetailsResponse,
				PersonalDetailItem.class);
		PersonalDetail personalDetail = null;
		if (Validator.isNotNull(personalDetailsItem) && Validator.isNotNull(personalDetailsItem.getItems())
				&& personalDetailsItem.getItems().size() > 0) {
			personalDetail = personalDetailsItem.getItems().get(0);
			log.info("personDetail=====>" + personalDetail.getPassportPhotoId());

		}
		return personalDetail;
	}

	private DocumentInfoItem fetchDocumentInfoByDocumentInfoId(ThemeDisplay themeDisplay, long documentId)
			throws UnsupportedEncodingException {
		String documentInfoUrl = themeDisplay.getPortalURL() + LRObjectURL.DELETE_DOCINFO + documentId;
		log.info("documentInfoUrl---------" + documentInfoUrl);
		String documentInfoResponse = omsbCommonApi.getData(documentInfoUrl);
		log.info("qualificationDocumentInfoResponse" + documentInfoResponse);
		DocumentInfoItem documentInfo = CustomObjectMapperUtil.readValue(documentInfoResponse, DocumentInfoItem.class);
		return documentInfo;
	}

	private String generateScopeListURL(String requestsUrl, long siteId) {
		return omsbCommonApi.getBaseURL() + requestsUrl.replace("{scope-id}", String.valueOf(siteId));
	}

	private DocumentInfoItem fetchQualificationDocument(ThemeDisplay themeDisplay, long potentialEcMemberId)
			throws UnsupportedEncodingException {
		String qualificationDocumentInfoUrl = themeDisplay.getPortalURL()
				+ LRObjectURL.DOCUMENT_INFO_URL.replace(DataflowConstants.SCOPE_ID_VAR,
						String.valueOf(themeDisplay.getScopeGroupId()))
				+ StringPool.QUESTION + "filter=personId"
				+ URLEncoder.encode(" eq " + potentialEcMemberId + " and documentType eq 'QualificationDocument'",
						DataflowConstants.UTF_8);
		String qualificationDocumentInfoResponse = omsbCommonApi.getData(qualificationDocumentInfoUrl);
		DocumentInfo qualificationDocumentInfos = CustomObjectMapperUtil.readValue(qualificationDocumentInfoResponse,
				DocumentInfo.class);
		DocumentInfoItem qualificationDocumentInfoItem = null;
		if (Validator.isNotNull(qualificationDocumentInfos)
				&& Validator.isNotNull(qualificationDocumentInfos.getItems())
				&& qualificationDocumentInfos.getItems().size() > 0) {
			qualificationDocumentInfoItem = qualificationDocumentInfos.getItems().get(0);
		}
		return qualificationDocumentInfoItem;
	}

	private String getQualificationTitle(String key, ThemeDisplay themeDisplay) {
		try {
			List<ListTypeEntry> pickListEntries = getPickListEntries(LRPicklistConstants.QUALIFICATION,
					themeDisplay.getCompanyId());
			for (ListTypeEntry listTypeEntry : pickListEntries) {
				log.info("listTypeEntry===========" + listTypeEntry.getKey());
				if (listTypeEntry.getKey().equals(key)) {
					return listTypeEntry.getName();
				}
			}
		} catch (Exception e) {
			// no need to handle..

		}
		return key;
	}

	public List<ListTypeEntry> getPickListEntries(String pickListName, long companyId) {
		try {
			return ListTypeEntryLocalServiceUtil.getListTypeEntries(ListTypeDefinitionLocalServiceUtil
					.getListTypeDefinitionByExternalReferenceCode(pickListName, companyId).getListTypeDefinitionId());
		} catch (PortalException e) {
			log.error(e.getMessage());
		}
		return new ArrayList<ListTypeEntry>();
	}

	@Reference
	private EcMemberRequestStateLocalService ecMemberRequestStateLocalService;
	@Reference
	private BankDetailsLocalService bankDetailsLocalService;
	@Reference
	private EcMemberRequestLocalService ecMemberRequestLocalService;
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
	@Reference(unbind = "-")
	private UserLocalService userLocalService;
	@Reference(unbind = "-")
	private RoleLocalService roleLocalService;
	@Reference(unbind = "-")
	private MembershipUtil membershipUtil;

}
