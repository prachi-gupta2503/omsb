package gov.omsb.common.api;

import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.object.model.ObjectEntry;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import java.io.File;
import java.io.Serializable;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;

import gov.omsb.common.dto.CaseRequest;

/**
 * @author HabeebT
 */
public interface OMSBCommonApi {

	List<CaseRequest> getCaseRequest(String personId, String groupId);

	String getData(String url);

	void postData(String url);

	String addCaseDetail(String caseNumber);

	String convertDate(String date);

	Map<String, String> getHttpHeaderInfoAndBasicAuth();

	String convertDateFormat(String date);

	String convertNewDateFormat(String date);

	String getBaseURL();

	String getLiferayAuthorizationToken();

	boolean checkLoggedInUserByRoleName(String roleName, long userId);

	List<ListTypeEntry> getListTypeEntriesByERC(String ERC, long companyId);

	ListTypeEntry getListTypeEntryByListTypeItemKey(String listTypeDefinitionERC, String listTypItemeKey,
			long companyId);

	String addCaseReport(String caseNumber);

	void sendEmailNotification(String senderEmail, String recieverEmail, String subject, String body);
	
	void sendEmailNotificationWithAttachments(String senderEmail, String recieverEmail, String subject, String body, List<File> attachments);
	
	
	/** This method is used to replace dynamic values in the email template 
	 * @param emailTemplate
	 * @param keyValueMap (keys will be the keys in the template which we want to replace dynamically with the values)
	 * @return
	 */
	String replaceEmailTemplate(String emailTemplate, Map<String, String> keyValueMap);

//	JSONObject sendMobileNotification(String mobileNumber, String messageBody);

	String convertDateFormatToDDMMYYYY(String date);

	Date convertStringToDate(String date);

	Date convertNewStringDateToDate(String date);

	String convertDDMMYYYYDateToObjectDate(String inputDate);

	String convertNewDDMMYYYYStringToYYYYDDMMString(String inputDate);

	String convertNewDDMMYYYYDateToObjectDate(String inputDate);

	String convertObjectDateToDDMMYYYYDate(String inputDate);

	String convertObjectDateToNewDDMMYYYYDate(String inputDate);

	Date convertObjectStringDateToDate(String objectDate);

	String convertYYYYMMDDLocalDatetoObjectDate(LocalDate inputDate);

	String convertDateToDDMMYYYYString(Date date);

//	String convertDateToNewDDMMYYYYString(Date date);

	String convertDateToObjectDateString(Date date);

	String convertDateToYYYYDDMMString(Date date);

	boolean hasUserRole(long companyId, long userId, String roleName);

	String convertDate(String date, DateFormat oldFormat, DateFormat newFormat);

	String getValueByLanguage(String xmlString, String attibuteName, String languageCode);

	ObjectEntry addObjectEntryByERC(String erc, Map<String, Serializable> values, PortletRequest request,
			ThemeDisplay themeDisplay);

	String getListTypeEntryNameBylistTypeEntryId(long listTypeEntryId, Locale locale);

	String getObjectClassName(String objectERC, long companyId);

	ObjectEntry updateObjectEntryByERC(String erc, Map<String, Serializable> values, PortletRequest request,
			ThemeDisplay themeDisplay, long entryId);

	ObjectEntry updateObjectEntryById(String erc, ThemeDisplay themeDisplay, long objectEntryId,
			Map<String, Serializable> values, PortletRequest request);

	ListTypeEntry getListTypeEntryBylistTypeEntryId(long listTypeEntryId);

	Date convertStringYYYYMMDDToDate(String date);

	String convertDateToNewDDMMYYYYString(Date date);

	JSONObject sendMobileNotification(String mobileNumber, String messageBody);

	public long getGuestGroupId();

	public void sendLRUserNotification(long groupID, long userId, String templateName, String portletKey, boolean sendEmail);

	public String readXMLData(String content, String Key);

	ObjectEntry deleteObjectEntryEntryId(long entryId);	
	
	public long getWorkDetailsByPersonIdAndWorkDetailType(ThemeDisplay themeDisplay,long lrUserId,String isPrimaryWorkDetail);
}