package gov.omsb.vehpc.verification.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.CountryLocalService;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.service.util.CaseDetailUtil;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.verification.dto.CaseRequest;
import gov.omsb.verification.dto.CaseRequestItem;
import gov.omsb.verification.dto.CaseStatus;
import gov.omsb.verification.dto.CaseStatusItem;
import gov.omsb.verification.dto.CustomCountry;
import gov.omsb.verification.dto.DocumentTypesItem;
import gov.omsb.verification.dto.Person;
import gov.omsb.verification.dto.PersonItem;
import gov.omsb.verification.dto.PersonalDetail;
import gov.omsb.verification.dto.PersonalDetailItem;
import omsb.vehpc.verification.web.constants.OmsbVehpcVerificationWebPortletKeys;

@Component(immediate = true, service = VerificationUtil.class)
public class VerificationUtil {

	public Map<String, Long> getCaseStatusCount(String groupId) {

		String url = omsbCommonApi.getBaseURL()
				+ LRObjectURL.CASE_STATUS_URL.replace(DataflowConstants.SCOPE_ID_VAR, groupId);
		String reponse = omsbCommonApi.getData(url);
		return getStatusMap(reponse, groupId);
	}

	private Map<String, Long> getStatusMap(String responseObject, String groupId) {

		logger.info("getStatusMap ResponseObject :" + responseObject);
		Map<String, Long> caseRequestStatusMap = new HashMap<>();
		try {
			if (Validator.isNotNull(responseObject)) {
				JSONObject json = JSONFactoryUtil.createJSONObject(responseObject);
				logger.info("Json :" + json);
				JSONArray itemArray = json.getJSONArray("items");
				logger.info("Item :" + itemArray);
				logger.info("ItemArray :" + itemArray.length());

				if (Validator.isNotNull(itemArray) && itemArray.length() > 0) {
					for (int i = 0; i < itemArray.length(); i++) {
						JSONObject itemJson = itemArray.getJSONObject(i);
						caseRequestStatusMap.put(itemJson.getJSONObject("caseStatus").getString("key"),
								getCaseRequestStatusMap(itemJson.getLong("id"), groupId));
					}
				}
			}
		} catch (JSONException | NullPointerException e) {
			logger.error("Error while converting personalDetails response, " + e.getMessage());
		}
		return caseRequestStatusMap;
	}

	private long getCaseRequestStatusMap(long caseStatusId, String groupId) {

		String url = omsbCommonApi.getBaseURL()
				+ LRObjectURL.CASE_REQUEST_URL.replace(DataflowConstants.SCOPE_ID_VAR, groupId);
		try {
			url += StringPool.QUESTION + "filter=caseStatusId"
					+ URLEncoder.encode(" eq " + caseStatusId, DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
		} catch (UnsupportedEncodingException e) {
			logger.debug("Error while encoding url , " + e.getMessage());
		}
		String reponse = omsbCommonApi.getData(url);
		return getCaseRequestStatusCount(reponse);
	}

	private long getCaseRequestStatusCount(String responseObject) {

		try {
			JSONObject json = JSONFactoryUtil.createJSONObject(responseObject);
			return json.getLong("totalCount");
		} catch (JSONException e) {
			logger.error("Error while converting personalDetails response, " + e.getMessage());
		}
		return 0;
	}

	public PersonalDetail fetchPersonalDetailsByPersonId(long personId, ThemeDisplay themeDisplay) {
		String personDetailsUrl = null;
		try {
			personDetailsUrl = themeDisplay.getPortalURL() + LRObjectURL.PERSONAL_DETAIL_URL.replace("{scope-id}", String.valueOf(themeDisplay.getScopeGroupId()))
					+ StringPool.QUESTION + "filter=personId" + URLEncoder.encode(" eq " + personId,DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String personDetailsResponse = omsbCommonApi.getData(personDetailsUrl);
		logger.info(personDetailsUrl+" ::fetchPersonalDetailsByPersonId :::personDetailsResponse:::::"+personDetailsResponse);
		return CustomObjectMapperUtil.readValue(personDetailsResponse, PersonalDetail.class);
	}

	public CaseStatusItem fetchCaseStatusByCaseStatusId(long caseStatusId, ThemeDisplay themeDisplay)
			throws UnsupportedEncodingException {
		String caseStatusUrl = themeDisplay.getPortalURL() + LRObjectURL.CASE_STATUS_BY_PK_URL
				+ StringPool.FORWARD_SLASH + caseStatusId;
		String caseStatusResponse = omsbCommonApi.getData(caseStatusUrl);
		return CustomObjectMapperUtil.readValue(caseStatusResponse, CaseStatusItem.class);
	}

	public Person addPersonDeatails(String name, String caseNumber, String caseStatus, long id, String verificationDate) {
		Person person = new Person();
		person.setPersonName(name);
		person.setCaseNumber(caseNumber);
		person.setCaseStatus(caseStatus);
		person.setCaseRequestId(id);
		person.setVerificationDate(verificationDate);
		logger.info("addPersonDeatails::person:"+person);
		return person;
	}

	public Person fetchPersonByloggedUserId(ThemeDisplay themeDisplay) throws UnsupportedEncodingException {
		String loggedUserPersonUrl = themeDisplay.getPortalURL()
				+ LRObjectURL.PERSON_URL.replace("{scope-id}", String.valueOf(themeDisplay.getScopeGroupId()))
				+ StringPool.QUESTION + "filter=lrUserId"
				+ URLEncoder.encode(" eq " + String.valueOf(themeDisplay.getUserId()),
						DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
		String loggedUserPersonResponse = omsbCommonApi.getData(loggedUserPersonUrl);
		logger.info("loggedUserPersonUrl:::" + loggedUserPersonUrl + " , , loggedUserPersonResponse::::::::"+ loggedUserPersonResponse);
		return CustomObjectMapperUtil.readValue(loggedUserPersonResponse, Person.class);
	}

	public Person fetchPersonByPassport(ThemeDisplay themeDisplay) throws UnsupportedEncodingException {
		String personUrl = themeDisplay.getPortalURL()
				+ LRObjectURL.PERSON_URL.replace("{scope-id}", String.valueOf(themeDisplay.getScopeGroupId()))
				+ StringPool.QUESTION + "filter=lrUserId"
				+ URLEncoder.encode(" eq " + themeDisplay.getUserId() , DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
		String personResponse = omsbCommonApi.getData(personUrl);
		logger.info("fetchPersonByPassport:::::::::::>>>>>>>>>"+personUrl + ":::::::personResponse::::::::::" + personResponse);
		Person person =  CustomObjectMapperUtil.readValue(personResponse, Person.class);
		
		if(Validator.isNotNull(person) && person.getItems().size()>0) {
			String person1Url1 = themeDisplay.getPortalURL()
					+ LRObjectURL.PERSON_URL.replace("{scope-id}", String.valueOf(themeDisplay.getScopeGroupId()))
					+ StringPool.QUESTION + "filter=" + StringPool.OPEN_PARENTHESIS + "lrUserId"
					+ URLEncoder.encode(" eq " + 0 + StringPool.CLOSE_PARENTHESIS + " and " + StringPool.OPEN_PARENTHESIS + " passportNumber eq " + "'" + person.getItems().get(0).getPassportNumber() + "'" + StringPool.CLOSE_PARENTHESIS, DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
			String personResponse1 = omsbCommonApi.getData(person1Url1);
			logger.info("fetchPersonByPassp 222:::::::::::>>>>>>>>>"+person1Url1 + ":::::::personResponse::::::::::" + personResponse1);
			return CustomObjectMapperUtil.readValue(personResponse1, Person.class);	
		}
		return null;
		
	}

	/**
	 * @param personId
	 * @param dfPersonalDetailDTO
	 * @param caseReqeustId
	 * @throws UnsupportedEncodingException
	 * @throws JSONException                This method is used to get list of users
	 *                                      in verification page person select
	 *                                      dropdown
	 */
	public List<PersonalDetailItem> getPersonalDetail(long groupId, String personName) {
		Map<String, String> headers = new HashMap<>();
		String authorizationToken = omsbCommonApi.getLiferayAuthorizationToken();
		headers.put("Authorization", "Bearer " + authorizationToken);
		headers.put("content-type", "application/json");
		String url = getBaseURL() + LRObjectURL.PERSONAL_DETAIL_URL.replace(DataflowConstants.SCOPE_ID_VAR, String.valueOf(groupId));
		try {
			if (!personName.isEmpty()) {
				url += StringPool.QUESTION + "filter=" + URLEncoder.encode("contains(givenNameAsPassport,'" + personName
						+ "') or contains(applicantSurname,'" + personName + "')", DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
			}
		} catch (UnsupportedEncodingException e) {
			logger.debug("Error while encoding url , " + e.getMessage());
		}
		// String personalResponse = omsbHttpConnector.executeGet(url, "", headers);
		logger.info("url::getPersonalDetail:::::" + url);
		return getPersonalDetailsObject(omsbHttpConnector.executeGet(url, StringPool.BLANK, headers));
	}

	/**
	 * @param responseObject
	 * @return
	 */
	private List<PersonalDetailItem> getPersonalDetailsObject(String responseObject) {
		logger.info("responseObject:::::" + responseObject);
		List<PersonalDetailItem> personalDetailList = new ArrayList<>();
		try {
			JSONObject json = JSONFactoryUtil.createJSONObject(responseObject);
			JSONArray itemArray = json.getJSONArray("items");
			PersonalDetailItem personalDetail = new PersonalDetailItem();
			for (int i = 0; i < itemArray.length(); i++) {
				
				  //personalDetail = PersonalDetailItem(); 
				  JSONObject itemJson =itemArray.getJSONObject(i);
				  personalDetail.setApplicantSurname(itemJson.getString("applicantSurname"));
				  personalDetail.setGivenNameAsPassport(itemJson.getString("givenNameAsPassport"));
				  personalDetail.setPersonId(itemJson.getLong("personId"));
				  personalDetailList.add(personalDetail);
				 
			}
		} catch (JSONException | NullPointerException e) {
			logger.error("Error while converting personalDetails response, " + e.getMessage());
		}
		return personalDetailList;
	}

	/**
	 * 
	 * @return Base URL of the Portal.
	 */
	private String getBaseURL() {
		Company company;
		String url = "";
		try {
			company = CompanyLocalServiceUtil.getCompanyById(PortalUtil.getDefaultCompanyId());
			Group group = GroupLocalServiceUtil.fetchGroup(PortalUtil.getDefaultCompanyId(), "Guest");
			url = company.getPortalURL(group.getGroupId());
			logger.info("home URL ?? " + company.getPortalURL(group.getGroupId()));
		} catch (PortalException e) {
			logger.error("Exception while getting the Base URL ::::: " + e);
		}
		return url;
	}
	
	public String getDocumentTypeName(ThemeDisplay themeDisplay , long documentTypeId){
		 String documentTypeUrl = themeDisplay.getPortalURL() + LRObjectURL.DOCUMENT_TYPE_URL+documentTypeId;
		 String documentTypeResponse = omsbCommonApi.getData(documentTypeUrl);
		 logger.info(documentTypeUrl+"documentTypeResponse::!!!!!!!!!!!!!!:"+documentTypeResponse);
		 DocumentTypesItem documentType = CustomObjectMapperUtil.readValue(documentTypeResponse, DocumentTypesItem.class);
		 return documentType.getType().getName();
	}
	public String getCountryName(ThemeDisplay themeDisplay , long countryId){
		try {
			
			Country country = countryLocalService.fetchCountry(countryId);
			if (Validator.isNotNull(country)) {
				return country.getName(themeDisplay.getLocale());
			}
			/*
			 * String url = themeDisplay.getPortalURL()+LRObjectURL.
			 * GET_CUSTOM_COUNTRY_BY_NATIONALITYCOUNTRYID_URL +
			 * themeDisplay.getScopeGroupId() + "?filter=countryID"+URLEncoder.encode(" eq "
			 * + countryId,DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.
			 * PAGE_SIZE_WITH_FILTER; String customCuntryResponse =
			 * omsbCommonApi.getData(url); CustomCountry countryItemResponse =
			 * CustomObjectMapperUtil.readValue(customCuntryResponse, CustomCountry.class);
			 * if(Validator.isNotNull(countryItemResponse) &&
			 * Validator.isNotNull(countryItemResponse.getItems()) &&
			 * countryItemResponse.getItems().size()>0) { return
			 * countryItemResponse.getItems().get(0).getNationality(); }
			 */
		} catch (NullPointerException e) {
			logger.info(e.getMessage());
		}
		return "";
	}
	public List<Person> getVerificationDetails(PortletRequest request, PortletResponse response) throws UnsupportedEncodingException {
		ThemeDisplay themeDisplay = (ThemeDisplay) ((PortletRequest) request).getAttribute(WebKeys.THEME_DISPLAY);
		logger.info("getVerificationDetails()>>>>method started>>>>");
		List<Person> persons = new ArrayList<>();
		String personId = ParamUtil.getString(request,"personId");
		logger.info("personId>>>>111111111>>>>"+personId);
		boolean isVehpcAdmin = omsbCommonApi.checkLoggedInUserByRoleName(RoleNameConstants.VEHPC_ADMIN , themeDisplay.getUserId());
		String personUrlByUserId="";
		Person person=new Person();
		if(isVehpcAdmin) {
			personUrlByUserId = themeDisplay.getPortalURL() + LRObjectURL.PERSON_URL.replace("{scope-id}", String.valueOf(themeDisplay.getScopeGroupId()))+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_FOR_SCOPE;
			String personResponse = omsbCommonApi.getData(personUrlByUserId);
			logger.info(personUrlByUserId+"getVerificationDetails personResponse : "+personResponse);
			person = CustomObjectMapperUtil.readValue(personResponse, Person.class, new SimpleDateFormat(DataflowConstants.OBJECT_DATE_FORMAT));
			//person = CustomObjectMapperUtil.readValue(personResponse, Person.class);
		}else {
			person = fetchPersonByloggedUserId(themeDisplay);
		}
		
		if(Validator.isNotNull(person)) {
			if (Validator.isNotNull(person.getItems()) && person.getItems().size()>0) {
				for(PersonItem personItem : person.getItems()) {
					Person personObj = getPersonalDetailsByPersonId(personItem.getId(),themeDisplay);
					if(Validator.isNotNull(personObj)) {
						persons.add(personObj);
					}
				}
			}
		}
		request.setAttribute("persons", persons);
		logger.info("persons::::"+persons);
		logger.info("getLoginUserDetails() >>>> method ended>>>>");
		return persons;
	}
	public Person getPersonalDetailsByPersonId(long personId,ThemeDisplay themeDisplay) throws UnsupportedEncodingException {
		String CaseRequestUrlByPersonId = themeDisplay.getPortalURL() + LRObjectURL.CASE_REQUEST_URL.replace("{scope-id}", String.valueOf(themeDisplay.getScopeGroupId())) + StringPool.QUESTION + "filter=personId" + URLEncoder.encode(" eq " + String.valueOf(personId), DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
		CaseRequest caseRequest = CustomObjectMapperUtil.readValue(omsbCommonApi.getData(CaseRequestUrlByPersonId), CaseRequest.class);
		List<CaseRequestItem> caseRequestItems=new ArrayList<>();
		if(Validator.isNotNull(caseRequest) && Validator.isNotNull(caseRequest.getItems())) {
			caseRequestItems = caseRequest.getItems();
			logger.info("getPersonalDetailsByPersonId caseRequest:size:::::::::"+caseRequest.getItems().size());
			if(caseRequestItems.size()>0) {
				String personalDetailsByPersonId = themeDisplay.getPortalURL() + LRObjectURL.PERSONAL_DETAIL_URL.replace("{scope-id}", String.valueOf(themeDisplay.getScopeGroupId())) + StringPool.QUESTION + "filter=personId" + URLEncoder.encode(" eq " + String.valueOf(personId), DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
				PersonalDetail personalDetail = CustomObjectMapperUtil.readValue(omsbCommonApi.getData(personalDetailsByPersonId), PersonalDetail.class);
				for(CaseRequestItem caseRequestItem : caseRequestItems) {
					String caseStatusUrl = themeDisplay.getPortalURL() + LRObjectURL.CASE_STATUS_URL.replace("{scope-id}", String.valueOf(themeDisplay.getScopeGroupId())) + StringPool.QUESTION + "filter=id" + URLEncoder.encode(" eq " + "'" + String.valueOf(caseRequestItem.getCaseStatusId()) + "'", "UTF-8")+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
					String caseStatusres = omsbCommonApi.getData(caseStatusUrl);
					logger.info("caseStatusUrl:::"+caseStatusUrl+" , caseStatusres : "+caseStatusres);		
					CaseStatus caseStatus = CustomObjectMapperUtil.readValue(omsbCommonApi.getData(caseStatusUrl), CaseStatus.class);
					String name="";
					if(Validator.isNotNull(personalDetail) && Validator.isNotNull(personalDetail.getItems()) && !(personalDetail.getItems().isEmpty())) {
						name = personalDetail.getItems().get(0).getGivenNameAsPassport();
					}
					String status="";
					if(Validator.isNotNull(caseStatus) && caseStatus.getItems().size()>0){
						status = caseStatus.getItems().get(0).getCaseStatus().getName();
					}
					return addPersonDeatails(name,caseRequestItem.getCaseNumber(),status,caseRequestItem.getId(),omsbCommonApi.convertObjectDateToDDMMYYYYDate(caseRequestItem.getVerificationDate()));
					
				}
			}
		}
		return null;
	}

	@Reference(unbind = "_")
	private OMSBCommonApi omsbCommonApi;

	@Reference(unbind = "_")
	private OMSBHttpConnector omsbHttpConnector;

	@Reference(unbind = "_")
	private CaseDetailUtil caseDetailUtil;

	@Reference
	private CountryLocalService countryLocalService;
	private static final Log logger = LogFactoryUtil.getLog(VerificationUtil.class);
}
