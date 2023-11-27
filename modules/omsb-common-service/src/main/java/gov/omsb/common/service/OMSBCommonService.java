package gov.omsb.common.service;

import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.list.type.model.ListTypeDefinition;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeDefinitionLocalServiceUtil;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.object.model.ObjectDefinition;
import com.liferay.object.model.ObjectEntry;
import com.liferay.object.service.ObjectDefinitionService;
import com.liferay.object.service.ObjectEntryLocalService;
import com.liferay.object.service.ObjectEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.module.configuration.ConfigurationProvider;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;

import java.io.File;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Timer;

import javax.mail.internet.InternetAddress;
import javax.portlet.PortletRequest;
import javax.ws.rs.core.MediaType;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.DataflowService;
import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.dto.CaseRequest;
import gov.omsb.common.dto.EmploymentDetail;
import gov.omsb.common.dto.EmploymentDetailItem;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.service.util.CaseDetailUtil;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.endpoint.configuration.api.LiferayConfiguration;
import gov.omsb.http.connector.api.OMSBHttpConnector;

/**
 * @author HabeebT
 */
@Component(immediate = true, service = OMSBCommonApi.class)
public class OMSBCommonService implements OMSBCommonApi {

	public List<CaseRequest> getCaseRequest(String personId, String groupId) {
		Map<String, String> headers = new HashMap<>();
		headers.put("Authorization", "Basic dGVzdEBsaWZlcmF5LmNvbTp0ZXN0MQ==");
		headers.put("content-type", ContentTypes.APPLICATION_JSON);
		String url = getBaseURL() + LRObjectURL.CASE_REQUEST_URL.replace(DataflowConstants.SCOPE_ID_VAR, groupId);
		try {
			if (!personId.isEmpty()) {
				url += StringPool.QUESTION + "filter="
						+ URLEncoder.encode("personId eq " + personId, DataflowConstants.UTF_8);
			}
		} catch (UnsupportedEncodingException e) {
			_log.debug("Error while encoding url , " + e.getMessage());
		}
		return getCaseRequestDetailsList(omsbHttpConnector.executeGet(url, StringPool.BLANK, headers));
	}

	private List<CaseRequest> getCaseRequestDetailsList(String response) {
		List<CaseRequest> caseRequestList = new ArrayList<>();
		try {
			JSONObject json = JSONFactoryUtil.createJSONObject(response);
			JSONArray itemArray = json.getJSONArray("items");
			CaseRequest caseRequest;
			for (int i = 0; i < itemArray.length(); i++) {
				caseRequest = new CaseRequest();
				JSONObject itemJson = itemArray.getJSONObject(i);
				caseRequest.setCaseNumber(itemJson.getString("caseNumber"));
				caseRequest.setCaseTypeId(itemJson.getLong("caseTypeId"));
				caseRequest.setCaseStageID(itemJson.getLong("caseStageID"));
				caseRequest.setCaseStatusId(itemJson.getLong("caseStatusId"));
				caseRequest.setPersonId(itemJson.getLong("personId"));
				caseRequest.setCrn(itemJson.getString("crn"));
				caseRequest.setMessage(itemJson.getString("message"));
				caseRequest.setId(itemJson.getLong("id"));
				caseRequestList.add(caseRequest);
			}
		} catch (JSONException e) {
			_log.error("Error while converting caseRequestDetail response, " + e.getMessage());
		}

		return caseRequestList;
	}

	@Override
	public String getData(String url) {
		Map<String, String> headers = new HashMap<>();
		String token = RefreshLiferayAuthToken.getToken();
		_log.debug("token is ?? " + token);
		headers.put("Authorization", "Bearer " + token);
		return omsbHttpConnector.executeGet(url, StringPool.BLANK, headers);
	}

	@Override
	public void postData(String url) {
		Map<String, String> headers = new HashMap<>();
		headers.put("Authorization", "Basic dGVzdEBsaWZlcmF5LmNvbTp0ZXN0MQ==");
		headers.put("content-type", ContentTypes.APPLICATION_JSON);
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		jsonObject.put("givenNameAsPassport", "Alex");
		jsonObject.put("email", "Alex@yopmail.com");
		jsonObject.put("mobileNumber", "9113884083");
		omsbHttpConnector.executePost(url, jsonObject.toString(), headers);
	}

	@Override
	public String addCaseDetail(String caseNumber) {
		String caseResponse = dataflowService.getCaseDetail(caseNumber);
		caseDetailUtil.addCaseDetail(caseResponse);
		return caseResponse;
	}

	@Override
	public String addCaseReport(String caseNumber) {
		String caseReportResponse = dataflowService.getCaseReport(caseNumber);
		caseDetailUtil.addCaseReport(caseNumber, caseReportResponse);
		return caseReportResponse;
	}

	@Override
	public String convertDate(String date) {
		try {
			return new SimpleDateFormat(DataflowConstants.DFS_DATE_FORMAT)
					.format(new SimpleDateFormat(DataflowConstants.OBJECT_DATE_FORMAT).parse(date));
		} catch (ParseException e) {
			_log.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Date convertStringYYYYMMDDToDate(String date) {
		try {
			return new SimpleDateFormat(DataflowConstants.DATE_FORMAT_YYYYMMDD).parse(date);
		} catch (ParseException e) {
			_log.error(e.getMessage(), e);
		}
		return null;
	}

	@Override
	public Map<String, String> getHttpHeaderInfoAndBasicAuth() {
		Map<String, String> headers = new HashMap<>();
		String token = RefreshLiferayAuthToken.getToken();
		_log.debug("token in getHttpHeaderInfoAndBasicAuth" + token);
		headers.put("Authorization", "Bearer " + token);
		headers.put(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);
		return headers;
	}

	public Map<String, String> getStaticHttpHeaderInfoAndBasicAuth() {
		return getHttpHeaderInfoAndBasicAuth();
	}

	@Override
	public String getBaseURL() {
		try {
			Company company = CompanyLocalServiceUtil.getCompanyById(PortalUtil.getDefaultCompanyId());
			Group group = GroupLocalServiceUtil.fetchGroup(PortalUtil.getDefaultCompanyId(),
					CommonConstants.GUEST_GROUP_KEY);
			return company.getPortalURL(group.getGroupId());
		} catch (PortalException e) {
			_log.error(e.getMessage());
		}
		return null;
	}

	public String convertDateFormat(String date) {
		try {
			return new SimpleDateFormat(DataflowConstants.DATE_FORMAT)
					.format(new SimpleDateFormat(DataflowConstants.DATE_FORMAT_OLD).parse(date));
		} catch (ParseException e) {
			_log.error(e.getMessage());
		}
		return null;
	}

	public String convertNewDateFormat(String date) {
		try {
			return new SimpleDateFormat(DataflowConstants.DATE_FORMAT)
					.format(new SimpleDateFormat(DataflowConstants.DATE_FORMAT_NEW).parse(date));
		} catch (ParseException e) {
			_log.error(e.getMessage());
		}
		return null;
	}

	@Override
	public String getLiferayAuthorizationToken() {
		_log.info("getToken >>>>> method started>>>>>>");
		JSONObject jsonResponse = null;
		try {
			LiferayConfiguration liferayConfiguration = provider.getSystemConfiguration(LiferayConfiguration.class);
			String tokenEndpoint = liferayConfiguration.getTokenEndPoint();
			String clientId = liferayConfiguration.getClientId();
			String clientSecret = liferayConfiguration.getClientSecret();
			_log.debug("tokenEndpoint >>>>  " + tokenEndpoint + "clientId >>>>  " + clientId + "clientSecret >>>>  "
					+ clientSecret);

			String payload = null;
			payload = String.format("grant_type=client_credentials&client_id=%s&client_secret=%s", clientId,
					clientSecret);

			Map<String, String> headers = new HashMap<>();
			headers.put(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED);
			String tokenResponse = omsbHttpConnector.tokenExecutePost(tokenEndpoint, payload, headers);
			_log.debug("tokenResponse>>>>>>>> " + tokenResponse);

			jsonResponse = JSONFactoryUtil.createJSONObject(tokenResponse);
		} catch (JSONException | ConfigurationException e) {
			_log.error(e.getMessage());
		}
		_log.debug("jsonResponse>>>>>>>>>> " + jsonResponse);
		String accessToken = jsonResponse.getString("access_token");
		_log.debug("accessToken>>>>>>>>> " + accessToken);
		_log.info("getToken >>>>> method ended>>>>>>");
		return accessToken;
	}

	@Override
	public boolean checkLoggedInUserByRoleName(String roleName, long userId) {
		return roleLocalService.getUserRoles(userId).stream()
				.anyMatch(userRL -> roleName.equalsIgnoreCase(userRL.getName()));
	}

	/**
	 * @param externalReferenceCode
	 * @param companyId
	 * @return List<ListTypeEntry>
	 * @apiNote Get the List of ListTypeEntry(PickList) data using the External
	 *          Reference Code
	 */
	@Override
	public List<ListTypeEntry> getListTypeEntriesByERC(String externalReferenceCode, long companyId) {
		try {
			ListTypeDefinition definition = ListTypeDefinitionLocalServiceUtil
					.getListTypeDefinitionByExternalReferenceCode(externalReferenceCode, companyId);
			if (Validator.isNotNull(definition)) {
				return ListTypeEntryLocalServiceUtil.getListTypeEntries(definition.getListTypeDefinitionId());
			}
		} catch (PortalException e) {
			_log.error("Exception while getListTypeEntriesByERC :: ", e);
		}
		return null;
	}

	@Override
	public ListTypeEntry getListTypeEntryByListTypeItemKey(String listTypeDefinitionERC, String listTypItemeKey,
			long companyId) {
		try {
			ListTypeDefinition definition = ListTypeDefinitionLocalServiceUtil
					.getListTypeDefinitionByExternalReferenceCode(listTypeDefinitionERC, companyId);
			if (Validator.isNotNull(definition)) {
				return ListTypeEntryLocalServiceUtil.getListTypeEntry(definition.getListTypeDefinitionId(),
						listTypItemeKey);
			}
		} catch (PortalException e) {
			_log.info(e.getMessage());
		}
		return null;
	}

	public void sendEmailNotification(String senderEmail, String recieverEmail, String subject, String body) {
		try {
			MailMessage mailMessage = new MailMessage();
			mailMessage.setFrom(new InternetAddress(senderEmail));
			mailMessage.setTo(new InternetAddress(recieverEmail));
			mailMessage.setSubject(subject);
			mailMessage.setBody(body);
			mailMessage.setHTMLFormat(true);
			MailServiceUtil.sendEmail(mailMessage);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
	}
	
	public void sendEmailNotificationWithAttachments(String senderEmail, String recieverEmail, String subject, String body, List<File> attachments) {
		try {
			MailMessage mailMessage = new MailMessage();
			mailMessage.setFrom(new InternetAddress(senderEmail));
			mailMessage.setTo(new InternetAddress(recieverEmail));
			mailMessage.setSubject(subject);
			mailMessage.setBody(body);
			mailMessage.setHTMLFormat(true);
			if(Validator.isNotNull(attachments) && attachments.size()>0) {
				for(File file : attachments) {
					mailMessage.addFileAttachment(file);
				}
			}
			MailServiceUtil.sendEmail(mailMessage);
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
	}
	
	public String replaceEmailTemplate(String emailTemplate, Map<String, String> keyValueMap) {
		for(Entry<String, String> entry: keyValueMap.entrySet()) {
			emailTemplate = StringUtil.replace(emailTemplate, "[$" + entry.getKey() + "$]", entry.getValue());
		}
		return emailTemplate;
	}

	public JSONObject sendMobileNotification(String mobileNumber, String messageBody) {
		try {
			String url = CommonConstants.MOBILE_NOTIFICATION_URL + CommonConstants.MOBILE_NOTIFICATION_PARAM_PHONE_NO
					+ StringPool.EQUAL + mobileNumber + StringPool.AMPERSAND
					+ CommonConstants.MOBILE_NOTIFICATION_PARAM_MESSAGE + StringPool.EQUAL
					+ URLEncoder.encode(messageBody, DataflowConstants.UTF_8);
			_log.info("Mobile Send Notification URL : " + url);

			String response = omsbHttpConnector.executePostWithTimeout(url, StringPool.BLANK, 120000,
					new HashMap<String, String>());
			_log.info("Send Mobile Notification Response : " + response);

			JSONObject jsonResponse = new JSONFactoryUtil().createJSONObject(response);
			_log.info("PKI Response JSON : " + jsonResponse);

			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			int statusCode = jsonResponse.getInt("status");
			if (statusCode == 200) {
				jsonObject.put("message", jsonResponse.getString(CommonConstants.MOBILE_NOTIFICATION_PARAM_MESSAGE));
				jsonObject.put("isValid", Boolean.TRUE);
			} else {
				jsonObject.put("message", jsonResponse.getString(CommonConstants.MOBILE_NOTIFICATION_PARAM_MESSAGE));
				jsonObject.put("isValid", Boolean.FALSE);
			}
			_log.info("Serversource Response JSON : " + jsonObject);

			return jsonObject;
		} catch (JSONException | UnsupportedEncodingException e) {
			_log.info(e.getMessage(), e);
		}
		return null;
	}

	@Override
	public String convertDateFormatToDDMMYYYY(String date) {
		try {
			return new SimpleDateFormat(DataflowConstants.DATE_FORMAT_OLD)
					.format(new SimpleDateFormat(DataflowConstants.OBJECT_DATE_FORMAT).parse(date));
		} catch (ParseException e) {
			_log.error(e.getMessage());
		}
		return null;
	}

	@Override
	public Date convertStringToDate(String date) {
		try {
			return new SimpleDateFormat(DataflowConstants.DATE_FORMAT_OLD).parse(date);
		} catch (ParseException e) {
			_log.error(e.getMessage(), e);
		}
		return null;
	}

	@Override
	public Date convertNewStringDateToDate(String date) {
		try {
			return new SimpleDateFormat(DataflowConstants.DATE_FORMAT_NEW).parse(date);
		} catch (ParseException e) {
			_log.error(e.getMessage(), e);
		}
		return null;
	}

	public Date convertObjectStringDateToDate(String objectDate) {
		try {
			return new SimpleDateFormat(DataflowConstants.OBJECT_DATE_FORMAT).parse(objectDate);
		} catch (ParseException e) {
			_log.error(e.getMessage());
		}
		return null;
	}

	@Override
	public String convertDDMMYYYYDateToObjectDate(String inputDate) {
		try {
			return new SimpleDateFormat(DataflowConstants.OBJECT_DATE_FORMAT)
					.format(new SimpleDateFormat(DataflowConstants.DATE_FORMAT_OLD).parse(inputDate));
		} catch (ParseException e) {
			_log.error(e.getMessage());
		}
		return null;
	}

	@Override
	public String convertNewDDMMYYYYDateToObjectDate(String inputDate) {
		try {
			return new SimpleDateFormat(DataflowConstants.OBJECT_DATE_FORMAT)
					.format(new SimpleDateFormat(DataflowConstants.DATE_FORMAT_NEW).parse(inputDate));
		} catch (ParseException e) {
			_log.error(e.getMessage());
		}
		return null;
	}

	public String convertNewDDMMYYYYStringToYYYYDDMMString(String inputDate) {
		try {
			return new SimpleDateFormat(DataflowConstants.DATE_FORMAT)
					.format(new SimpleDateFormat(DataflowConstants.DATE_FORMAT_NEW).parse(inputDate));
		} catch (ParseException e) {
			_log.error(e.getMessage());
		}
		return null;
	}

	public String convertObjectDateToDDMMYYYYDate(String inputDate) {
		try {
			if (Validator.isNotNull(inputDate))
				return new SimpleDateFormat(DataflowConstants.DATE_FORMAT_OLD)
						.format(new SimpleDateFormat(DataflowConstants.OBJECT_DATE_FORMAT).parse(inputDate));
			else
				return StringPool.BLANK;
		} catch (ParseException e) {
			_log.error(e.getMessage());
		}
		return StringPool.BLANK;
	}

	public String convertObjectDateToNewDDMMYYYYDate(String inputDate) {
		SimpleDateFormat sdf = new SimpleDateFormat(DataflowConstants.DATE_FORMAT_NEW);
		try {
			return sdf.format(new SimpleDateFormat(DataflowConstants.OBJECT_DATE_FORMAT).parse(inputDate));
		} catch (ParseException e) {
			_log.error(e.getMessage());
		}
		return null;
	}

	@Override
	public String convertYYYYMMDDLocalDatetoObjectDate(LocalDate inputDate) {
		Date date = Date.from(inputDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		return new SimpleDateFormat(DataflowConstants.OBJECT_DATE_FORMAT).format(date);
	}

	@Override
	public String convertDateToDDMMYYYYString(Date date) {
		return new SimpleDateFormat(DataflowConstants.DATE_FORMAT_OLD).format(date);
	}

	@Override
	public String convertDateToYYYYDDMMString(Date date) {
		return new SimpleDateFormat(DataflowConstants.DATE_FORMAT).format(date);
	}

	@Override
	public String convertDateToNewDDMMYYYYString(Date date) {
		return new SimpleDateFormat(DataflowConstants.DATE_FORMAT_NEW).format(date);
	}

	@Override
	public String convertDateToObjectDateString(Date date) {
		return new SimpleDateFormat(DataflowConstants.OBJECT_DATE_FORMAT).format(date);
	}

	@Override
	public boolean hasUserRole(long companyId, long userId, String roleName) {
		Role role = roleLocalService.fetchRole(companyId, roleName);
		if (Validator.isNotNull(role)) {
			return roleLocalService.hasUserRole(userId, role.getRoleId());
		}
		return false;
	}

	@Override
	public String convertDate(String date, DateFormat oldFormat, DateFormat newFormat) {
		try {
			Date oldDate = oldFormat.parse(date);
			return newFormat.format(oldDate);
		} catch (ParseException e) {
			_log.error(e.getMessage());
		}
		return null;
	}

	public String getValueByLanguage(String xmlString, String attibuteName, String languageCode) {
		try {
			return SAXReaderUtil.read(xmlString)
					.selectSingleNode("/root/" + attibuteName + "[@language-id='" + languageCode + "']").getText();
		} catch (Exception e) {
			_log.error(e.getMessage() + xmlString);
			return xmlString;
		}
	}

	@Activate
	public void refreshTokenCode() {
		Timer timer = new Timer();
		timer.schedule(new RefreshLiferayAuthToken(), 0, 300000); // for 5 minutes
	}

	@Override
	public ObjectEntry addObjectEntryByERC(String erc, Map<String, Serializable> values, PortletRequest request,
			ThemeDisplay themeDisplay) {
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
			ObjectDefinition definition = objectDefinitionService.getObjectDefinitionByExternalReferenceCode(erc,
					themeDisplay.getCompanyId());
			if (definition != null) {
				return objectEntryLocalServiceUtil.addObjectEntry(themeDisplay.getUserId(),
						themeDisplay.getScopeGroupId(), definition.getObjectDefinitionId(), values, serviceContext);
			}
		} catch (PortalException e) {
			_log.error(e.getMessage(), e);
		}
		return null;
	}

	@Override
	public ObjectEntry updateObjectEntryById(String erc, ThemeDisplay themeDisplay, long objectEntryId,
			Map<String, Serializable> values, PortletRequest request) {
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
			ObjectDefinition definition = objectDefinitionService.getObjectDefinitionByExternalReferenceCode(erc,
					themeDisplay.getCompanyId());
			if (definition != null) {
				return objectEntryLocalServiceUtil.updateObjectEntry(themeDisplay.getUserId(), objectEntryId, values,
						serviceContext);
			}
		} catch (PortalException e) {
			_log.error(e.getMessage(), e);
		}
		return null;
	}

	@Override
	public String getListTypeEntryNameBylistTypeEntryId(long listTypeEntryId, Locale locale) {
		try {
			if (listTypeEntryId > 0) {
				ListTypeEntry listTypeEntry = ListTypeEntryLocalServiceUtil.getListTypeEntry(listTypeEntryId);
				if (Validator.isNotNull(listTypeEntry)) {
					return listTypeEntry.getName(locale);
				}
			}

		} catch (PortalException e) {
			_log.error("Exception while getListTypeEntriesByERC :: ", e);
		}
		return "";
	}

	@Override
	public ListTypeEntry getListTypeEntryBylistTypeEntryId(long listTypeEntryId) {
		try {
			if (listTypeEntryId > 0) {
				ListTypeEntry listTypeEntry = ListTypeEntryLocalServiceUtil.getListTypeEntry(listTypeEntryId);
				if (Validator.isNotNull(listTypeEntry)) {
					return listTypeEntry;
				}
			}

		} catch (PortalException e) {
			_log.error("Exception while getListTypeEntriesByERC :: ", e);
		}
		return null;
	}

	public String getObjectClassName(String objectERC, long companyId) {
		try {
			ObjectDefinition definition = objectDefinitionService.getObjectDefinitionByExternalReferenceCode(objectERC,
					companyId);
			if (Validator.isNotNull(definition)) {
				return definition.getClassName();
			}
		} catch (PortalException e) {
			_log.error(e.getMessage(), e);
		}
		return null;
	}

	@Override
	public ObjectEntry updateObjectEntryByERC(String erc, Map<String, Serializable> values, PortletRequest request,
			ThemeDisplay themeDisplay, long entryId) {
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
			return ObjectEntryLocalServiceUtil.updateObjectEntry(themeDisplay.getUserId(), entryId, values,
					serviceContext);

		} catch (PortalException e) {
			_log.error(e.getMessage(), e);
		}
		return null;
	}

	public long getGuestGroupId() {
		Group group = GroupLocalServiceUtil.fetchGroup(PortalUtil.getDefaultCompanyId(),
				CommonConstants.GUEST_GROUP_KEY);
		if (Validator.isNotNull(group)) {
			_log.info("Guest Group Id is ?? " + group.getGroupId());
			return group.getGroupId();
		}
		return 0;
	}

	@Override
	public void sendLRUserNotification(long groupID, long userId, String templateName, String portletKey, boolean sendEmail) {

		_log.info("inside send email notification");
		JournalArticle article = null;
		try {
			article = JournalArticleLocalServiceUtil.getArticleByUrlTitle(groupID, templateName);
			String emailTitle = StringPool.BLANK;
			String emailContent = StringPool.BLANK;
			if (Validator.isNotNull(article)) {
				String content = article.getContentByLocale("en_US");
				emailTitle = readXMLData(content, "emailTitle");
				emailContent = readXMLData(content, "emailContent");
			}
			_log.info("emailTitle ?? " + emailTitle);
			_log.debug("emailContent  ?? " + emailContent);
			JSONObject notificationJSON = JSONFactoryUtil.createJSONObject();
			User user=UserLocalServiceUtil.getUser(userId);
			emailContent=emailContent.replace("[candidate]", user.getFullName());
			notificationJSON.put("notificationText", emailTitle);
			notificationJSON.put("emailTitle", emailTitle);
			notificationJSON.put("emailContent", emailContent);

			UserNotificationEvent u = UserNotificationEventLocalServiceUtil.sendUserNotificationEvents(userId,
					portletKey, UserNotificationDeliveryConstants.TYPE_WEBSITE, notificationJSON);
			_log.info("SENDING NOTIFICATION ...." + u.getPayload());

			String email = Validator.isNotNull(userLocalService.fetchUser(userId))
					? userLocalService.fetchUser(userId).getEmailAddress()
					: "";
			if(sendEmail) {		
				sendEmailNotification(CommonConstants.SENDER_EMAIL, email, emailTitle, emailContent);
			}
		} catch (PortalException e) {
			_log.error(e.getMessage(), e);
		}
	}

	@Override
	public String readXMLData(String content, String Key) {

		String fieldValue = StringPool.BLANK;
		try {

			Document document = SAXReaderUtil.read(content);

			Node node = document
					.selectSingleNode("/root/dynamic-element[@field-reference='" + Key + "']/dynamic-content");

			if (Validator.isNotNull(node)) {
				return fieldValue = node.getText();
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
		return fieldValue;

	}

	@Override
	public ObjectEntry deleteObjectEntryEntryId( long entryId) {
		try {
		return ObjectEntryLocalServiceUtil.deleteObjectEntry(entryId);
		} catch (PortalException e) {
			_log.error(e.getMessage(), e);
		}
		return null;
	}
	
	@Override
	public long getWorkDetailsByPersonIdAndWorkDetailType(ThemeDisplay themeDisplay,long lrUserId,String isPrimaryWorkDetail) {
		_log.info("Entry into getWorkDetailsByPersonIdAndWorkDetailType ::");

		EmploymentDetailItem workDetailItems = null;

		long workSectorId=0;

		StringBuilder sbURL = new StringBuilder(themeDisplay.getPortalURL() + LRObjectURL.REG_EMPLOYEMENT_DETAIL_URL + themeDisplay.getScopeGroupId());

		if(Validator.isNotNull(lrUserId)) {
			try {
				sbURL.append(StringPool.QUESTION + "filter=lRUserId"
						+ URLEncoder.encode(" eq " + lrUserId + " and primaryWorkDetail eq '"+isPrimaryWorkDetail+"'", DataflowConstants.UTF_8));

			} catch (UnsupportedEncodingException e) {
				_log.error(e.getMessage());
			}
		}

		String response = getData(sbURL.toString());
		if (Validator.isNotNull(response)) {
			workDetailItems = CustomObjectMapperUtil.readValue(response, gov.omsb.common.dto.EmploymentDetailItem.class);
		}

		if(Validator.isNotNull(workDetailItems) && Validator.isNotNull(workDetailItems.getItems()) && workDetailItems.getItems().size()>0) {

			EmploymentDetail workDetail = workDetailItems.getItems().get(0);
			
			if(Validator.isNotNull(workDetail.getWorkSectorId3()) && workDetail.getWorkSectorId3()>0) {
				workSectorId = workDetail.getWorkSectorId3();
			}else if(Validator.isNotNull(workDetail.getWorkSectorId2()) && workDetail.getWorkSectorId2()>0) {
				workSectorId = workDetail.getWorkSectorId2();
			}else {
				workSectorId = workDetail.getWorkSectorId();
			}
		}
		_log.info("exit :: getWorkDetailsByPersonIdAndWorkDetailType ::" + workSectorId);		

		return workSectorId;
	}
	
	@Reference
	private ObjectDefinitionService objectDefinitionService;

	@Reference
	private ObjectEntryLocalService objectEntryLocalServiceUtil;

	@Reference(unbind = "-")
	private OMSBHttpConnector omsbHttpConnector;

	@Reference(unbind = "-")
	private DataflowService dataflowService;

	@Reference(unbind = "-")
	private CaseDetailUtil caseDetailUtil;

	@Reference(unbind = "-")
	private ConfigurationProvider provider;

	@Reference(unbind = "-")
	private RoleLocalService roleLocalService;

	@Reference
	private UserLocalService userLocalService;

	private static final Log _log = LogFactoryUtil.getLog(OMSBCommonService.class);

}