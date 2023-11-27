package gov.omsb.tms.ecm.web.commands;

import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.AND;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.CIVIL_ID;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.CMD2;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.DATE_OF_BIRTH;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.DATE_OF_BIRTH_EQ;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.DD_MM_YYYY;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.ECMEMBERSHIPREQUEST;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.EQ;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.FILTER;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.FILTER_PERSON_ID;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.GET_PERSONS_FILTERED_DATA;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.PASSPORT_NO;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.PASSPORT_NUMBER;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.PASSPORT_NUMBER_EQ;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.PERSON_DETAILS_LIST;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.SINGLE_QUOTE;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.STATUS;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.SUCCESS;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.UNICODE_TRANSFORMATION_FORMAT;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.dto.Person;
import gov.omsb.common.dto.PersonItem;
import gov.omsb.common.dto.PersonalDetail;
import gov.omsb.common.dto.PersonalDetailItem;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.tms.ecm.web.dto.PersonDetails;

/**
 * @author Jinal Patel
 */
@Component(immediate = true, property = {
		"javax.portlet.name=" + ECMEMBERSHIPREQUEST,
		"mvc.command.name=/get/persons-data" 
	}, 
	service = MVCResourceCommand.class)
public class GetPersonsDataMVCResourceCommand extends BaseMVCResourceCommand {
	
	
	private static final Log log = LogFactoryUtil.getLog(GetPersonsDataMVCResourceCommand.class);
	
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
		
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		log.info("Get Persons Filtered Data Serve Resource");
		String cmd = ParamUtil.getString(resourceRequest, CMD2);
		JSONObject responseObj = JSONFactoryUtil.createJSONObject();
		PrintWriter writer = null;
		if(GET_PERSONS_FILTERED_DATA.equalsIgnoreCase(cmd)) {
			String civilId = ParamUtil.getString(resourceRequest, CIVIL_ID);
			String name = ParamUtil.getString(resourceRequest, "name");
			String email = ParamUtil.getString(resourceRequest, "email");
			
			JSONObject personResultJson = getFilteredPersonsDetails(civilId, name, email, resourceRequest, resourceResponse);
			log.info("personResultJson : " + personResultJson);
			responseObj.put(STATUS, SUCCESS);
			responseObj.put("resultJson", personResultJson);
			try {
				writer = resourceResponse.getWriter();
			} catch (IOException io) {
				log.info("Error while getting writer");
			} finally {
				writer.write(responseObj.toString());
				writer.close();
			}
		}
	}
		
	// ------------------------------------START ----------------------------------------------------------------------------------------------------
	
	private JSONObject getFilteredPersonsDetails(String civilId,String name,String email, ResourceRequest request, ResourceResponse response) throws UnsupportedEncodingException, PortalException {
		log.info("getFilteredPersonsDetails >>>Invoked>>>");
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		String personWithScopeURL = generateScopeListURL(LRObjectURL.PERSONAL_DETAIL_URL,themeDisplay.getScopeGroupId());
		String personUrl="";
		boolean isEmailResult = false;
		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		
		if(Validator.isNotNull(email)) {
			personUrl = personWithScopeURL + StringPool.QUESTION + FILTER+"email" + URLEncoder.encode(EQ + SINGLE_QUOTE + email + SINGLE_QUOTE, UNICODE_TRANSFORMATION_FORMAT);
		}
		
		String personResponse = omsbCommonApi.getData(personUrl);
		PersonalDetailItem personalDetailItem = CustomObjectMapperUtil.readValue(personResponse, PersonalDetailItem.class);
		List<PersonDetails> personsDetailsList = new ArrayList<>();
		User user = null;
		if(Validator.isNotNull(personalDetailItem) && Validator.isNotNull(personalDetailItem.getItems()) && personalDetailItem.getItems().size() > 0) {
			for(PersonalDetail personalDetail : personalDetailItem.getItems()) {
				long lrUserId = personalDetail.getLrUserId();
				user = UserLocalServiceUtil.getUser(lrUserId);
				PersonDetails personDetails = new PersonDetails();
				String dateOfBirth=StringPool.BLANK;
				if(Validator.isNotNull(personalDetail) && name.equalsIgnoreCase(user.getFullName())){
					log.info("person search by name & email");
					Person person = fetchPersonDetailsByPersonId(personalDetail.getPersonId(),themeDisplay);
					if(Validator.isNotNull(person) && (civilId.isBlank() || person.getCivilId().equalsIgnoreCase(civilId))) {
						personDetails.setEmail(personalDetail.getEmail());
						personDetails.setGivenNameAsPassport(user.getFullName());
						personDetails.setPersonId(person.getId());
						personDetails.setCivilId(person.getCivilId());
						personDetails.setLrUserId(person.getLrUserId());
						personDetails.setPassportNumber(person.getPassportNumber());
						personDetails.setId(person.getId());
						try {
							Date dob=new SimpleDateFormat(DataflowConstants.OBJECT_DATE_FORMAT).parse(person.getDateOfBirth());
							SimpleDateFormat sdf = new SimpleDateFormat(DD_MM_YYYY);
							dateOfBirth = sdf.format(dob);
							personDetails.setDateOfBirth(dateOfBirth);
						} catch (ParseException e) {
							log.info("Error while parsing dob string to date, "+e.getMessage());
						}
						personsDetailsList.add(personDetails);
					} 
					else {
						personUrl = personWithScopeURL + StringPool.QUESTION + FILTER+"email" + URLEncoder.encode(" eq '" + email + "'", UNICODE_TRANSFORMATION_FORMAT);
						String emailPersonResponse = omsbCommonApi.getData(personUrl);
						PersonalDetailItem emailPersonalDetailItem = CustomObjectMapperUtil.readValue(emailPersonResponse, PersonalDetailItem.class);
						if(Validator.isNotNull(emailPersonalDetailItem) && Validator.isNotNull(emailPersonalDetailItem.getItems()) && emailPersonalDetailItem.getItems().size() > 0) {
							isEmailResult = true;
							for(PersonalDetail personalDetailCur : emailPersonalDetailItem.getItems()) {
								PersonDetails personDetailsCur = new PersonDetails();
								String dateOfBirthCur=StringPool.BLANK;
								if(Validator.isNotNull(personalDetailCur)){
									Person personCur = fetchPersonDetailsByPersonId(personalDetailCur.getPersonId(),themeDisplay);
									personDetailsCur.setEmail(personalDetailCur.getEmail());
									personDetailsCur.setGivenNameAsPassport(user.getFullName());
									personDetailsCur.setPersonId(personCur.getId());
									personDetailsCur.setCivilId(personCur.getCivilId());
									personDetailsCur.setLrUserId(personCur.getLrUserId());
									personDetailsCur.setPassportNumber(personCur.getPassportNumber());
									personDetailsCur.setId(personCur.getId());
									try {
										Date dob=new SimpleDateFormat(DataflowConstants.OBJECT_DATE_FORMAT).parse(personCur.getDateOfBirth());
										SimpleDateFormat sdf = new SimpleDateFormat(DD_MM_YYYY);
										dateOfBirthCur = sdf.format(dob);
										personDetailsCur.setDateOfBirth(dateOfBirthCur);
									} catch (ParseException e) {
										log.info("Error while parsing dob string to date, "+e.getMessage());
									}
									personsDetailsList.add(personDetailsCur);
								}
							}
						}
					}
				}
				else {
					log.info("person search by email ");
					isEmailResult = true;
					Person person = fetchPersonDetailsByPersonId(personalDetail.getPersonId(),themeDisplay);
					personDetails.setEmail(personalDetail.getEmail());
					personDetails.setGivenNameAsPassport(user.getFullName());
					personDetails.setPersonId(person.getId());
					personDetails.setCivilId(person.getCivilId());
					personDetails.setLrUserId(person.getLrUserId());
					personDetails.setPassportNumber(person.getPassportNumber());
					personDetails.setId(person.getId());
					try {
						Date dob=new SimpleDateFormat(DataflowConstants.OBJECT_DATE_FORMAT).parse(person.getDateOfBirth());
						SimpleDateFormat sdf = new SimpleDateFormat(DD_MM_YYYY);
						dateOfBirth = sdf.format(dob);
						personDetails.setDateOfBirth(dateOfBirth);
					} catch (ParseException e) {
						log.info("Error while parsing dob string to date, "+e.getMessage());
					}
					personsDetailsList.add(personDetails);
				}
			}
		} else {
			personUrl = personWithScopeURL + StringPool.QUESTION + FILTER+"email" + URLEncoder.encode(" eq '" + email + "'", UNICODE_TRANSFORMATION_FORMAT);
			String emailPersonResponse = omsbCommonApi.getData(personUrl);
			PersonalDetailItem emailPersonalDetailItem = CustomObjectMapperUtil.readValue(emailPersonResponse, PersonalDetailItem.class);
			if(Validator.isNotNull(emailPersonalDetailItem) && Validator.isNotNull(emailPersonalDetailItem.getItems()) && emailPersonalDetailItem.getItems().size() > 0) {
				isEmailResult = true;
				for(PersonalDetail personalDetail : emailPersonalDetailItem.getItems()) {
					PersonDetails personDetails = new PersonDetails();
					String dateOfBirth=StringPool.BLANK;
					if(Validator.isNotNull(personalDetail)){
						Person person = fetchPersonDetailsByPersonId(personalDetail.getPersonId(),themeDisplay);
						personDetails.setEmail(personalDetail.getEmail());
						personDetails.setGivenNameAsPassport(user.getFullName());
						personDetails.setPersonId(person.getId());
						personDetails.setCivilId(person.getCivilId());
						personDetails.setLrUserId(person.getLrUserId());
						personDetails.setPassportNumber(person.getPassportNumber());
						personDetails.setId(person.getId());
						try {
							Date dob=new SimpleDateFormat(DataflowConstants.OBJECT_DATE_FORMAT).parse(person.getDateOfBirth());
							SimpleDateFormat sdf = new SimpleDateFormat(DD_MM_YYYY);
							dateOfBirth = sdf.format(dob);
							personDetails.setDateOfBirth(dateOfBirth);
						} catch (ParseException e) {
							log.info("Error while parsing dob string to date, "+e.getMessage());
						}
						personsDetailsList.add(personDetails);
					}
				}
			}
		}
		resultJson.put("isEmailResult", isEmailResult);
		resultJson.put("personsDetailsList", personsDetailsList);
		return resultJson;
	}
	
	// --------------------------------------END ----------------------------------------------------------------------------------------------------
	
	private String generateScopeListURL(String personRequestsUrl, long siteId) {
		return omsbCommonApi.getBaseURL() + personRequestsUrl.replace(DataflowConstants.SCOPE_ID_VAR, String.valueOf(siteId));
	}
	
	private Person fetchPersonDetailsByPersonId(long personId, ThemeDisplay themeDisplay) throws UnsupportedEncodingException {
		String personDetailsUrl = generateScopeListURL(LRObjectURL.GET_PERSON_BY_ID_URL,themeDisplay.getScopeGroupId()) + StringPool.QUESTION + "filter=id" + URLEncoder.encode(EQ + "'"+ personId + "'" , UNICODE_TRANSFORMATION_FORMAT);
		String personDetailsResponse = omsbCommonApi.getData(personDetailsUrl);
		PersonItem personItems = CustomObjectMapperUtil.readValue(personDetailsResponse, PersonItem.class);
		Person person = null;
		if(Validator.isNotNull(personItems) && Validator.isNotNull(personItems.getItems()) && personItems.getItems().size()>0) {
			person = personItems.getItems().get(0);
		}
		return person;
	}
}
