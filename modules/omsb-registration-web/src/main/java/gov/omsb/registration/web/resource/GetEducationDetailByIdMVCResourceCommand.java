package gov.omsb.registration.web.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.util.DLURLHelperUtil;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.CountryLocalServiceUtil;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.dto.DocumentInfo;
import gov.omsb.common.dto.DocumentInfoItem;
import gov.omsb.common.dto.EducationDetail;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;
import gov.omsb.registration.web.dto.InstitutionItems;
import gov.omsb.registration.web.dto.OMSBInstitutionMapping;
import gov.omsb.registration.web.util.RegistrationUtil;

@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
	        "mvc.command.name="+MVCCommands.GET_REGISTRATION_EDUCATION_DETAILS_SR
	    }, 
	    service = MVCResourceCommand.class 
)
public class GetEducationDetailByIdMVCResourceCommand implements MVCResourceCommand {

	private static final Log _log = LogFactoryUtil.getLog(GetEducationDetailByIdMVCResourceCommand.class);
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		try {
			_log.info("GetEducationDetailByIdMVCResourceCommand Invoked");
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long id = ParamUtil.getLong(resourceRequest, "id");
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			JSONArray instituteArray =JSONFactoryUtil.createJSONArray();
			if(id>0) {
				EducationDetail educationDetail = registrationUtil.getItems(themeDisplay.getPortalURL() + LRObjectURL.REG_EDUCATION_DETAIL_URL + id, EducationDetail.class);
				
				String documentInfoUrl = themeDisplay.getPortalURL()
						+ LRObjectURL.REG_DOCUMENT_INFO_URL + CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId()
						+ StringPool.QUESTION + "filter=componentClassRefId"
						+ URLEncoder.encode(" eq " + educationDetail.getId(), DataflowConstants.UTF_8);
				DocumentInfoItem documentInfoItems = CustomObjectMapperUtil.readValue(omsbCommonApi.getData(documentInfoUrl), DocumentInfoItem.class);
				if(Validator.isNotNull(documentInfoItems) && documentInfoItems.getItems().size()>0) {
					DocumentInfo documentInfo = documentInfoItems.getItems().get(0);
					if(Validator.isNotNull(documentInfo.getFileEntryID()) && documentInfo.getFileEntryID()>0) {
						try {
							FileEntry entry = DLAppLocalServiceUtil.getFileEntry(documentInfo.getFileEntryID());
							String documentURL =DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay, StringPool.BLANK);
							documentInfo.setDocumentURL(documentURL);
						} catch (PortalException e) {
							_log.error("Error in  code :::" + e.getMessage());
						}
					}
					educationDetail.setDocumentInfo(documentInfo);
				}
				
				
				 if(Validator.isNotNull( educationDetail.getIssuingAuthorityCountryId())) {
					  instituteArray=getInstituteList(themeDisplay,educationDetail.getIssuingAuthorityCountryId());
				}
				
				_log.info("instituteArray :::::"+instituteArray);
				
				if(Validator.isNotNull(educationDetail) && educationDetail.getId()>0) {
						_log.info("inside educationDetail Found not null ::::");
					jsonObject.put("isValid", Boolean.TRUE);
					ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
					jsonObject.put("educationDetail", ow.writeValueAsString(educationDetail));
					jsonObject.put("instituteArray", instituteArray.toJSONString());
				}
			}
			_log.info("Serversource Response JSON : "+jsonObject);
			
			resourceResponse.getWriter().print(jsonObject.toJSONString());
			return Boolean.FALSE;
		} catch (Exception e) {	
			_log.error("Error ::, "+e.getMessage());
			return Boolean.TRUE;
		}
}
	
	
	
	private JSONArray getInstituteList(ThemeDisplay themeDisplay, long countryId) {

		String url = themeDisplay.getPortalURL() + LRObjectURL.INSTITUTION_MAPPING_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + getGroupId() + StringPool.QUESTION + "filter=country"
				+ URLEncoder.encode(" eq " + countryId, StandardCharsets.UTF_8);
		String response = httpConnector.executeGet(url, "", omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
		
		
		
		_log.info("countryId :getInstituteList :::" +countryId);
		_log.info("url :getInstituteList :::" +url);
		_log.info("response :getInstituteList :::" +response);
		
		
		InstitutionItems examList = CustomObjectMapperUtil.readValue(response, InstitutionItems.class);
		_log.info(examList.getItems().size());
		JSONArray array=JSONFactoryUtil.createJSONArray();
		try {
			if (Validator.isNotNull(examList) && Validator.isNotNull(examList.getItems())
					&& !examList.getItems().isEmpty()) {

				for (OMSBInstitutionMapping exam : examList.getItems()) {
					OMSBInstitutionMapping exam1 = exam;

					if (Validator.isNotNull(exam1) && Validator.isNotNull(exam1.getUniversity())) {
						List<com.liferay.portal.kernel.model.Country> countries = CountryLocalServiceUtil
								.getCountries(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

						if (Validator.isNotNull(countries)) {
							ListTypeEntry listEntry = ListTypeEntryLocalServiceUtil
									.fetchListTypeEntry(exam1.getUniversity());
							if (Validator.isNotNull(listEntry)) {
								Map<Locale, String> nameMap = listEntry.getNameMap();
								String en_Name = StringPool.BLANK, ar_Name = StringPool.BLANK;

								Locale en_LanguageLocale = LocaleUtil
										.fromLanguageId(CommonConstants.LANGUAGE_CODE_ENGLISH);
								en_Name = nameMap.get(en_LanguageLocale);

								Locale ar_LanguageLocale = LocaleUtil
										.fromLanguageId(CommonConstants.LANGUAGE_CODE_ARABIC);
								ar_Name = nameMap.get(ar_LanguageLocale);

								JSONObject jsonObject=JSONFactoryUtil.createJSONObject();
								jsonObject.put("arabicName",ar_Name);
								jsonObject.put("englishName",en_Name);
								jsonObject.put("externalReferenceCode",listEntry.getExternalReferenceCode());
								jsonObject.put("id",listEntry.getListTypeEntryId());
								_log.info("Jsonobject -->>"+jsonObject);
								array.put(jsonObject);
							}

						}
					}

				}
				return array;
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		return null;
	}
	
	private long getGroupId() {
		Group group = GroupLocalServiceUtil.fetchGroup(PortalUtil.getDefaultCompanyId(),
				CommonConstants.GUEST_GROUP_KEY);
		if (Validator.isNotNull(group)) {
			return group.getGroupId();
		}
		return 0;
	}
	
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference
	private OMSBHttpConnector httpConnector;
	
	@Reference(unbind="-")
	private RegistrationUtil registrationUtil;	
}
