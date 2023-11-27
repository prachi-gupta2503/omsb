package gov.omsb.tms.ecm.web.commands;

import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.EQ;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.FILTER;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.UNICODE_TRANSFORMATION_FORMAT;

import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.util.DLURLHelperUtil;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeDefinitionLocalServiceUtil;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.CountryLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys;
import gov.omsb.tms.ecm.web.dto.CustomCountryItems;
import gov.omsb.tms.ecm.web.dto.DocumentInfo;
import gov.omsb.tms.ecm.web.dto.DocumentInfoItem;
import gov.omsb.tms.ecm.web.dto.EducationDetail;
import gov.omsb.tms.ecm.web.dto.EducationalDetailsItem;
import gov.omsb.tms.model.EcMemberRequest;
import gov.omsb.tms.service.EcMemberRequestLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + ECMembershipRequestPortletKeys.ECMEMBERSHIPREQUEST,
		"mvc.command.name=/educationDetails/data"

}, service = MVCResourceCommand.class)

public class EducationDetailViewMVCResourceActionCommand implements MVCResourceCommand {
	private static final Log LOGGER = LogFactoryUtil.getLog(EducationDetailViewMVCResourceActionCommand.class);

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		LOGGER.info("do serve resource----------");
		long ecMemberRequestId = ParamUtil.getLong(resourceRequest, "ecMemberRequestId");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		EcMemberRequest ecMemberRequest = null;
		try {
			ecMemberRequest = ecMemberRequestLocalService.getEcMemberRequest(ecMemberRequestId);
		} catch (PortalException e3) {
			e3.printStackTrace();
		}
		String url = LRObjectURL.EDUCATION_DETAIL_URL;
		String completeURL = generateScopeListURL(url, themeDisplay.getScopeGroupId());

		try {
			completeURL = completeURL + StringPool.QUESTION + FILTER + "personId"
					+ URLEncoder.encode(EQ + ecMemberRequest.getPotentialEcMemberId(), UNICODE_TRANSFORMATION_FORMAT);
		} catch (UnsupportedEncodingException e2) {
			e2.printStackTrace();
		}
		String educationDetailsResponse = omsbCommonApi.getData(completeURL);
		EducationDetail educationDetail = CustomObjectMapperUtil.readValue(educationDetailsResponse,
				EducationDetail.class);
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		List<EducationalDetailsItem> items = educationDetail.getItems();
		for (EducationalDetailsItem item : items) {
			DocumentInfoItem fetchQualificationDocument = null;
			JSONObject responseObj = JSONFactoryUtil.createJSONObject();
			try {
				fetchQualificationDocument = fetchQualificationDocument(themeDisplay, item.getId());
			} catch (UnsupportedEncodingException e1) {
				e1.getMessage();
			}

			FileEntry fileEntry = null;
			String documentUrl = null;
			try {
				if(fetchQualificationDocument != null) {
					fileEntry = DLAppServiceUtil.getFileEntry(fetchQualificationDocument.getFileEntryID());
					documentUrl = DLURLHelperUtil.getPreviewURL(fileEntry, fileEntry.getLatestFileVersion(), null, "");
				}
			} catch (Exception e) {
				LOGGER.error("error in getting file-----");

			}
			String countryName = getCountryName(themeDisplay, item.getIssuingAuthorityCountryId());
			String title = getQualificationTitle(item.getQualificationAttained(), themeDisplay);
			String university = getUniversityName(item.getIssuingAuthorityName(), themeDisplay);
			responseObj.put("documentUrl", documentUrl);
			responseObj.put("gpa", item.getGpa());
			responseObj.put("qualificationAttained", title);
			responseObj.put("issuingAuthorityCountryName", countryName);
			responseObj.put("issuingAuthorityName", university);
			responseObj.put("yearOfGraduation", item.getYearOfGraduation());
			responseObj.put("id", item.getId());
			responseObj.put("qualificationDocumentId", fetchQualificationDocument!=null?fetchQualificationDocument.getId():0);
			jsonArray.put(responseObj);

		}
		try {
			JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, jsonArray);
		} catch (IOException e) {

		}

		return true;
	}

	private String getQualificationTitle(String key, ThemeDisplay themeDisplay) {

		if (Validator.isNotNull(key)) {
			String qualificationAttained = null;
			try {
				qualificationAttained = omsbCommonApi
						.getListTypeEntryByListTypeItemKey(LRPicklistConstants.QUALIFICATION, key,
								themeDisplay.getCompanyId())
						.getName(themeDisplay.getLocale());

			} catch (Exception e) {
				LOGGER.error(e.getMessage());
			}

			if (Validator.isNull(qualificationAttained)) {
				try {
					List<ListTypeEntry> pickListEntries = getPickListEntries(LRPicklistConstants.QUALIFICATION,
							themeDisplay.getCompanyId());
					for (ListTypeEntry listTypeEntry : pickListEntries) {
						if (listTypeEntry.getKey().equals(key)) {
							return listTypeEntry.getName(themeDisplay.getLocale());
						}
					}
				} catch (Exception e) {
					// no need to handle..

				}
			} else {
				return qualificationAttained;
			}
		}

		return key;
	}

	private String getUniversityName(String university, ThemeDisplay themeDisplay) {
		try {
			long universityId = Long.parseLong(university);
			List<ListTypeEntry> pickListEntries = getPickListEntries(LRPicklistConstants.UNIVERSITY,
					themeDisplay.getCompanyId());
			for (ListTypeEntry listTypeEntry : pickListEntries) {
				if (listTypeEntry.getListTypeEntryId() == universityId) {
					return listTypeEntry.getName(themeDisplay.getLocale());
				}
			}
		} catch (Exception e) {
			// no need to handle..
		}

		return university;
	}

	public List<ListTypeEntry> getPickListEntries(String pickListName, long companyId) {
		try {
			return ListTypeEntryLocalServiceUtil.getListTypeEntries(ListTypeDefinitionLocalServiceUtil
					.getListTypeDefinitionByExternalReferenceCode(pickListName, companyId).getListTypeDefinitionId());
		} catch (PortalException e) {
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<ListTypeEntry>();
	}

	public EducationalDetailsItem fetchEducationDetailsItemByEducationId(ThemeDisplay themeDisplay, long educationId)
			throws UnsupportedEncodingException {
		String educationDetailUrl = themeDisplay.getPortalURL() + LRObjectURL.EDUCATION_URL + educationId;
		String educationDetailResponse = omsbCommonApi.getData(educationDetailUrl);
		EducationalDetailsItem educationalDetailsItem = CustomObjectMapperUtil.readValue(educationDetailResponse,
				EducationalDetailsItem.class);
		return educationalDetailsItem;
	}

	private DocumentInfoItem fetchQualificationDocumentBydocumentInfoId(ThemeDisplay themeDisplay, long documentId)
			throws UnsupportedEncodingException {
		String qualificationDocumentInfoUrl = themeDisplay.getPortalURL() + LRObjectURL.DELETE_DOCINFO + documentId;
		String qualificationDocumentInfoResponse = omsbCommonApi.getData(qualificationDocumentInfoUrl);
		DocumentInfoItem qualificationDocumentInfos = CustomObjectMapperUtil
				.readValue(qualificationDocumentInfoResponse, DocumentInfoItem.class);
		return qualificationDocumentInfos;
	}

	private DocumentInfoItem fetchQualificationDocument(ThemeDisplay themeDisplay, long educationDetailId)
			throws UnsupportedEncodingException {
		String documentInfoUrl = null;

		try {
			documentInfoUrl = themeDisplay.getPortalURL() + LRObjectURL.REG_DOCUMENT_INFO_URL + CommonConstants.SCOPES
					+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION
					+ "filter=componentClassRefId"
					+ URLEncoder.encode(" eq " + educationDetailId, DataflowConstants.UTF_8);
		} catch (UnsupportedEncodingException e1) {

			e1.printStackTrace();
		}
		String documentInfoUrlResponse = omsbCommonApi.getData(documentInfoUrl);
		DocumentInfo documentInfo = CustomObjectMapperUtil.readValue(documentInfoUrlResponse, DocumentInfo.class);
		DocumentInfoItem documentInfoItem = null;
		if (Validator.isNotNull(documentInfo) && documentInfo.getItems().size() > 0) {
			documentInfoItem = documentInfo.getItems().get(0);
		}
		return documentInfoItem;
	}

	private String getCountryName(ThemeDisplay themeDisplay, long countryId) {

		String countryName = null;

		com.liferay.portal.kernel.model.Country country = null;
		try {
			country = CountryLocalServiceUtil.getCountry(countryId);
			countryName = country.getName(themeDisplay.getLocale());
		} catch (PortalException e) {
			LOGGER.error("unable to get the country having id :: " + countryId + " :::: " + e.getMessage());
		}

		if (Validator.isNull(countryName)) {
			CustomCountryItems countryItemResponse = null;

			try {
				String url = themeDisplay.getPortalURL() + LRObjectURL.REG_CUSTOM_COUNTRY_URL + countryId;
				String customCuntryResponse = omsbCommonApi.getData(url);

				countryItemResponse = CustomObjectMapperUtil.readValue(customCuntryResponse, CustomCountryItems.class);
				if (countryItemResponse != null) {
					countryName = countryItemResponse.getNationality();
				}
			} catch (NullPointerException e) {
				LOGGER.info(e.getMessage());
			}
		}
		return countryName;
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

}
