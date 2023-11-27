package gov.omsb.tms.ecm.web.commands;

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
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
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
import javax.servlet.http.HttpServletRequest;

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
import gov.omsb.tms.ecm.web.dto.DocumentInfo;
import gov.omsb.tms.ecm.web.dto.DocumentInfoItem;
import gov.omsb.tms.ecm.web.dto.EducationalDetailsItem;

@Component(immediate = true, property = { "javax.portlet.name=" + ECMembershipRequestPortletKeys.ECMEMBERSHIPREQUEST,
		"mvc.command.name=edit/educationDetails/"

}, service = MVCResourceCommand.class)
public class EditEducationDetailsMVCResourceCommand implements MVCResourceCommand {
	private static final Log LOGGER = LogFactoryUtil.getLog(EditEducationDetailsMVCResourceCommand.class);

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		LOGGER.info("edit do serve---------");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		String id = httpRequest.getParameter("id");
		long educationDetailsId = Long.parseLong(id);
		LOGGER.info("educationDetailsId---" + educationDetailsId);

		String educationDetailUrl = themeDisplay.getPortalURL() + LRObjectURL.EDUCATION_URL + educationDetailsId;
		LOGGER.info("fetch-------educationDetailUrl" + educationDetailUrl);
		String educationDetailResponse = omsbCommonApi.getData(educationDetailUrl);
		LOGGER.info("educationDetailResponse" + educationDetailResponse);
		EducationalDetailsItem educationalDetailsItem = CustomObjectMapperUtil.readValue(educationDetailResponse,
				EducationalDetailsItem.class);
		DocumentInfoItem documentInfoItem = null;
		try {
			documentInfoItem = fetchQualificationDocument(themeDisplay, educationalDetailsItem.getId());
			LOGGER.info("education document id ----" + documentInfoItem.getId());
		} catch (UnsupportedEncodingException e1) {
			LOGGER.info("Error in fetching qualification details");

		}
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		JSONObject responseObj = JSONFactoryUtil.createJSONObject();
		
		String universityName = getUniversityName(educationalDetailsItem.getIssuingAuthorityName(),themeDisplay);
		LOGGER.info("-----------------"+universityName);
		responseObj.put("gpa", educationalDetailsItem.getGpa());
		responseObj.put("qualificationAttained", educationalDetailsItem.getQualificationAttained());
		responseObj.put("yearOfGraduation", educationalDetailsItem.getYearOfGraduation());
		responseObj.put("issuingAuthorityCountryName", educationalDetailsItem.getIssuingAuthorityCountryId());
		responseObj.put("issuingAuthorityName",educationalDetailsItem.getIssuingAuthorityName());
		responseObj.put("universityName",universityName);
		responseObj.put("id", educationalDetailsItem.getId());
		responseObj.put("qualificationDocument", documentInfoItem.getdFFileName());
		responseObj.put("qualificationDocumentId", documentInfoItem.getId());
		try {
			JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, responseObj);
		} catch (IOException e) {
			e.getMessage();
		}
		return true;
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

	private String getUniversityName(String universityKey, ThemeDisplay themeDisplay) {
		
		try {
			long universityId =Long.parseLong(universityKey);
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

		return universityKey;
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
	private String getByIdURL(String requestsUrl, long id) {
		return omsbCommonApi.getBaseURL() + requestsUrl + id;
	}

	@Reference
	private OMSBCommonApi omsbCommonApi;

	@Reference
	private OMSBHttpConnector httpConnector;
}
