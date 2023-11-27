package gov.omsb.vehpc.verification.web.portlet.action;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.verification.dto.CaseRequest;
import gov.omsb.verification.dto.CaseRequestItem;
import gov.omsb.verification.dto.CaseStatus;
import gov.omsb.verification.dto.Person;
import gov.omsb.verification.dto.PersonalDetail;
import omsb.vehpc.verification.web.constants.MVCCommands;
import omsb.vehpc.verification.web.constants.OmsbVehpcVerificationWebPortletKeys;
import omsb.vehpc.verification.web.portlet.OmsbVehpcVerificationWebPortlet;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbVehpcVerificationWebPortletKeys.OMSBVEHPCVERIFICATIONWEB,
		"mvc.command.name=" + MVCCommands.VIEW_VERIFICATION }, service = MVCResourceCommand.class

)

public class VerificationMVCResourceCommand extends BaseMVCResourceCommand {

	public void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws JSONException, IOException {
		
		_log.info("serve resource() >>>> method started>>>>");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		_log.debug("group id >>>>>>"+themeDisplay.getScopeGroupId());
		
		String civilId = ParamUtil.getString(resourceRequest, "civilId");

		String dfrn = ParamUtil.getString(resourceRequest, "dfrn");

		String passportNumber = ParamUtil.getString(resourceRequest, "passportNumber");
		
		String dateOfBirth = ParamUtil.getString(resourceRequest, "dateOfBirth");	
		String convertedDate = convertDateFormat(dateOfBirth);	
		_log.debug("dateOfBirth " + dateOfBirth+" civilId "+civilId+" ,dfrn "+dfrn+" , passportNumber "+passportNumber+" date : "+convertedDate);
		
		Person person = getPersonDetails(dfrn, resourceRequest,resourceResponse);
		String personCivilId = "";
		String personPassportNumber = "";
		if (person.getItems().size() > 0) {
			personCivilId = person.getItems().get(0).getCivilId();
			personPassportNumber = person.getItems().get(0).getPassportNumber();
		}
		_log.debug("personCivilId " + personCivilId);
		if (((Validator.isNotNull(dfrn)) && (!dfrn.isEmpty()) && (civilId.isEmpty()) && (passportNumber.isEmpty()))
				|| ((!dfrn.isEmpty()) && (personCivilId.equals(civilId)) && (Validator.isNotNull(personCivilId))
						&& (!civilId.isEmpty()) && (passportNumber.isEmpty()))
				|| ((!dfrn.isEmpty()) && (personPassportNumber.equals(passportNumber))
						&& (Validator.isNotNull(personPassportNumber)) && (!passportNumber.isEmpty())
						&& (civilId.isEmpty())) || ((!dfrn.isEmpty()) && (Validator.isNotNull(convertedDate)) && (!convertedDate.isEmpty()))) {
			_log.debug("inside dfrn condition>>>>");
			getPersonalDetailsBydfrn(dfrn, convertedDate,resourceRequest, resourceResponse);
		} else if (dfrn.isEmpty() && (!civilId.isEmpty()) && (passportNumber.isEmpty())) {
			_log.debug("inside ,civil cndn>>>>>>>>>>>");
			getPersonDetailsByCivilID(civilId, convertedDate,resourceRequest, resourceResponse);
		} else if (dfrn.isEmpty() && civilId.isEmpty() && !passportNumber.isEmpty() || ((!dfrn.isEmpty()) && (Validator.isNotNull(convertedDate)) && (!convertedDate.isEmpty()))) {
			_log.debug("inside passport condition");
			getPersonalDetailsByPassportNumber(passportNumber,convertedDate,resourceRequest, resourceResponse);
		}
		_log.debug("persons"+resourceRequest.getAttribute("persons"));
		resourceRequest.setAttribute("persons1", resourceRequest.getAttribute("persons"));
		
		/*PortletRequestDispatcher dispatcher = resourceRequest.getPortletSession().getPortletContext().getRequestDispatcher("/jsps/verification/search-table-data.jsp");
		_log.debug("dispatcher : "+dispatcher);
		try {
			dispatcher.include(resourceRequest, resourceResponse);
		} catch (PortletException | IOException e) {
			e.printStackTrace();
		}*/

		_log.info("serve resource() >>>> method ended>>>>");
	}

	/**
	 * @return Return jsonArray of PersonalDetails, Case Request, Case Status objects
	 * based on civil id
	 */
	public void getPersonDetailsByCivilID(String civilId,String convertedDate,ResourceRequest request, ResourceResponse response)
			throws JSONException, IOException {
		_log.info("getPersonDetailsByCivilID() >>>> method started >>>>");
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		String groupId =String.valueOf(themeDisplay.getScopeGroupId());
		List<Person> persons = new ArrayList<>();
		String personUrl="";
		if(Validator.isNull(convertedDate)) {
			personUrl = themeDisplay.getPortalURL() + LRObjectURL.PERSON_URL.replace("{scope-id}", groupId)
				+ StringPool.QUESTION + "filter=civilId" + URLEncoder.encode(" eq " + "'" + civilId + "'", DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
		}else {
			personUrl = themeDisplay.getPortalURL() + LRObjectURL.PERSON_URL.replace("{scope-id}", groupId)
			+ StringPool.QUESTION + "filter="+StringPool.OPEN_PARENTHESIS+"civilId" + URLEncoder.encode(" eq " + "'" + civilId + "'" +StringPool.CLOSE_PARENTHESIS+" and "+StringPool.OPEN_PARENTHESIS+"dateOfBirth"+ " eq " +  convertedDate+StringPool.CLOSE_PARENTHESIS , DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
		}
		String personResponse = omsbCommonApi.getData(personUrl);
		Person person = CustomObjectMapperUtil.readValue(personResponse, Person.class);
		
		String personId = String.valueOf(person.getItems().get(0).getId());
		String caseRequestUrl = themeDisplay.getPortalURL() + LRObjectURL.CASE_REQUEST_URL.replace("{scope-id}", groupId) + StringPool.QUESTION + "filter=personId"
				+ URLEncoder.encode(" eq " + personId, DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
		String caseRequestResponse = omsbCommonApi.getData(caseRequestUrl);
		CaseRequest caseRequest = CustomObjectMapperUtil.readValue(caseRequestResponse, CaseRequest.class);
		if(Validator.isNotNull(caseRequest) && caseRequest.getItems().size()>0) {
			for(CaseRequestItem caseRequestObj : caseRequest.getItems()) {
				String caseRequestId = String.valueOf(caseRequestObj.getId());
				String caseStatusId = String.valueOf(caseRequestObj.getCaseStatusId());
				String caseNumber = caseRequestObj.getCaseNumber();
				String personalDetails = themeDisplay.getPortalURL() + LRObjectURL.PERSONAL_DETAIL_URL.replace("{scope-id}", groupId) + StringPool.QUESTION + "filter=personId" + URLEncoder.encode(" eq " + personId, DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
				String caseStatusUrl = themeDisplay.getPortalURL() + LRObjectURL.CASE_STATUS_URL.replace("{scope-id}", groupId) + StringPool.QUESTION + "filter=id" + URLEncoder.encode(" eq " + "'" + caseStatusId + "'", DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
				String caseStatusResponse = omsbCommonApi.getData(caseStatusUrl);
				CaseStatus caseStatus =  CustomObjectMapperUtil.readValue(caseStatusResponse, CaseStatus.class);
				String personalDetailsResponse = omsbCommonApi.getData(personalDetails);
				System.out.println(personalDetails+"personalDetailsResponse:::"+personalDetailsResponse);
				PersonalDetail personDetails = CustomObjectMapperUtil.readValue(personalDetailsResponse, PersonalDetail.class);
				System.out.println("caseRequestResponse:::::::"+caseRequestResponse);
				String name = "";
				if(Validator.isNotNull(personDetails) && Validator.isNotNull(personDetails.getItems()) && !(personDetails.getItems().isEmpty())) {
					name = personDetails.getItems().get(0).getGivenNameAsPassport();
				}
				String status="";
				if(Validator.isNotNull(caseStatus) && Validator.isNotNull(caseStatus.getItems()) && Validator.isNotNull(caseStatus.getItems().get(0).getCaseStatus()) && !(caseStatus.getItems().get(0).getCaseStatus().getName().isEmpty())){
					status = caseStatus.getItems().get(0).getCaseStatus().getName();
				}
				Person personObj = addPersonDeatails(name,caseNumber,status,Long.valueOf(caseRequestId),omsbCommonApi.convertObjectDateToDDMMYYYYDate(caseRequestObj.getVerificationDate()));
				persons.add(personObj);
				System.out.println("personObj::::::::::::"+personObj.getCaseNumber());
				request.setAttribute("persons", persons);
			}
		}
		_log.info("getPersonDetailsByCivilID() >>>> method ended >>>>");
	}
	/**
	 * @return Return jsonArray of PersonalDetails, Case Request, Case Status objects
	 * based on passport number
	 */

	public void getPersonalDetailsByPassportNumber(String passportNumber, String convertedDate,ResourceRequest request, ResourceResponse response)
			throws JSONException, IOException {
		_log.info("getPersonalDetailsByPassportNumber() >>>> method started >>>>");
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		List<Person> persons = new ArrayList<>();
		String personUrl="";
		String groupId =String.valueOf(themeDisplay.getScopeGroupId());
		if(Validator.isNull(convertedDate)) {
			personUrl = themeDisplay.getPortalURL() + LRObjectURL.PERSON_URL.replace("{scope-id}", groupId) + StringPool.QUESTION + "filter=passportNumber" + URLEncoder.encode(" eq " + "'" + passportNumber + "'", DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
		}else {
			personUrl = themeDisplay.getPortalURL() + LRObjectURL.PERSON_URL.replace("{scope-id}", groupId) + StringPool.QUESTION + "filter="+StringPool.OPEN_PARENTHESIS+"passportNumber" + URLEncoder.encode(" eq " + "'" + passportNumber + "'" +StringPool.CLOSE_PARENTHESIS+" and "+StringPool.OPEN_PARENTHESIS+"dateOfBirth"+ " eq " +  convertedDate+StringPool.CLOSE_PARENTHESIS , DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;

		}
		String personResponse = omsbCommonApi.getData(personUrl);
		Person person = CustomObjectMapperUtil.readValue(personResponse, Person.class);
		String id="";
		if(Validator.isNotNull(person) && Validator.isNotNull(person.getItems()) && !(person.getItems().isEmpty())) {
			id = String.valueOf(person.getItems().get(0).getId());
		}
		_log.debug("id " + id);
		
		String caseRequestUrl = themeDisplay.getPortalURL() + LRObjectURL.CASE_REQUEST_URL.replace("{scope-id}", groupId) + StringPool.QUESTION + "filter=personId" + URLEncoder.encode(" eq " + id, DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
		String caseRequestResponse = omsbCommonApi.getData(caseRequestUrl);
		CaseRequest caseRequest = CustomObjectMapperUtil.readValue(caseRequestResponse, CaseRequest.class);

		String personalDetails = themeDisplay.getPortalURL() + LRObjectURL.PERSONAL_DETAIL_URL.replace("{scope-id}", groupId) + StringPool.QUESTION + "filter=personId" + URLEncoder.encode(" eq " + id, DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
		String personalDetailsResponse = omsbCommonApi.getData(personalDetails);
		PersonalDetail personDetails = CustomObjectMapperUtil.readValue(personalDetailsResponse, PersonalDetail.class);

		String caseStatusId = String.valueOf(caseRequest.getItems().get(0).getCaseStatusId());
		String caseStatusUrl = themeDisplay.getPortalURL() + LRObjectURL.CASE_STATUS_URL.replace("{scope-id}", groupId) + StringPool.QUESTION + "filter=id" + URLEncoder.encode(" eq " + "'" + caseStatusId + "'", DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
		String caseStatusResponse = omsbCommonApi.getData(caseStatusUrl);
		CaseStatus caseStatus =  CustomObjectMapperUtil.readValue(caseStatusResponse, CaseStatus.class);
		
		String caseNumber="";
		long caseRequestId=0;
		if(Validator.isNotNull(caseRequest) && caseRequest.getItems().size()>0) {
			for(CaseRequestItem caseRequestObj : caseRequest.getItems()) {
				caseNumber = caseRequestObj.getCaseNumber();
				caseRequestId = caseRequestObj.getId();
				String name = "";
				if(Validator.isNotNull(personDetails) && Validator.isNotNull(personDetails.getItems()) && !(personDetails.getItems().isEmpty())) {
					name = personDetails.getItems().get(0).getGivenNameAsPassport();
				}
				String status="";
				if(Validator.isNotNull(caseStatus) && Validator.isNotNull(caseStatus.getItems()) && Validator.isNotNull(caseStatus.getItems().get(0).getCaseStatus()) && !(caseStatus.getItems().get(0).getCaseStatus().getName().isEmpty())){
					status = caseStatus.getItems().get(0).getCaseStatus().getName();
				}
				Person personObj = addPersonDeatails(name,caseNumber,status,caseRequestId,omsbCommonApi.convertObjectDateToDDMMYYYYDate(caseRequestObj.getVerificationDate()));
				persons.add(personObj);
				request.setAttribute("persons", persons);
			}
		}
		
		
		
		
		
		

		_log.info("getPersonalDetailsByPassportNumber() >>>> method ended >>>>");
	}
	/**
	 * @return Return jsonArray of PersonalDetails, Case Request, Case Status objects
	 * based on dfrn number
	 */
	public void getPersonalDetailsBydfrn(String dfrn, String convertedDate,ResourceRequest request, ResourceResponse response)
			throws JSONException, IOException {
		_log.info("getPersonalDetailsBydfrn() >>>> method started >>>>");
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		List<Person> persons = new ArrayList<>();
		String groupId =String.valueOf(themeDisplay.getScopeGroupId());
		String caseRequestUrl = themeDisplay.getPortalURL() + LRObjectURL.CASE_REQUEST_URL.replace("{scope-id}", groupId) + StringPool.QUESTION + "filter=caseNumber" + URLEncoder.encode(" eq " + "'" + dfrn + "'", DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
		String caseRequestResponse = omsbCommonApi.getData(caseRequestUrl);
		CaseRequest caseRequest = CustomObjectMapperUtil.readValue(caseRequestResponse, CaseRequest.class);
		if(Validator.isNotNull(caseRequest) && caseRequest.getItems().size()>0) {
			for(CaseRequestItem caseRequestObj : caseRequest.getItems()) {
				long caseRequestId = caseRequestObj.getId();
				long casestatusId = caseRequestObj.getCaseStatusId();
				String caseNumber= caseRequestObj.getCaseNumber();
				String personalDetailsUrl="";
				if(Validator.isNull(convertedDate)) {
					personalDetailsUrl = themeDisplay.getPortalURL() + LRObjectURL.PERSONAL_DETAIL_URL.replace("{scope-id}", groupId) + StringPool.QUESTION + "filter=caseRequestId" + URLEncoder.encode(" eq " + caseRequestId, DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
				}else {
					personalDetailsUrl = themeDisplay.getPortalURL() + LRObjectURL.PERSONAL_DETAIL_URL.replace("{scope-id}", groupId) + StringPool.QUESTION + "filter="+StringPool.OPEN_PARENTHESIS+"caseRequestId" + URLEncoder.encode(" eq " + "'" + caseRequestId + "'" +StringPool.CLOSE_PARENTHESIS+" and "+StringPool.OPEN_PARENTHESIS+"dateOfBirth"+ " eq " +  convertedDate+StringPool.CLOSE_PARENTHESIS , DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
				}
				System.out.println("::::"+personalDetailsUrl);
				String personalDetailsResponse = omsbCommonApi.getData(personalDetailsUrl);
				PersonalDetail personDetails = CustomObjectMapperUtil.readValue(personalDetailsResponse, PersonalDetail.class);
				String caseStatusUrl = themeDisplay.getPortalURL() + LRObjectURL.CASE_STATUS_URL.replace("{scope-id}", groupId) + StringPool.QUESTION + "filter=id" + URLEncoder.encode(" eq " + "'" + casestatusId + "'", DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
				String caseStatusResponse = omsbCommonApi.getData(caseStatusUrl);
				CaseStatus caseStatus =  CustomObjectMapperUtil.readValue(caseStatusResponse, CaseStatus.class);
				
				String name = "";
				if(Validator.isNotNull(personDetails) && Validator.isNotNull(personDetails.getItems()) && !(personDetails.getItems().isEmpty())) {
					name = personDetails.getItems().get(0).getGivenNameAsPassport();
				}
				String status="";
				if(Validator.isNotNull(caseStatus) && Validator.isNotNull(caseStatus.getItems()) && Validator.isNotNull(caseStatus.getItems().get(0).getCaseStatus()) && !(caseStatus.getItems().get(0).getCaseStatus().getName().isEmpty())){
					status = caseStatus.getItems().get(0).getCaseStatus().getName();
				}
				Person person = addPersonDeatails(name,caseNumber,status,caseRequestId,omsbCommonApi.convertObjectDateToDDMMYYYYDate(caseRequestObj.getVerificationDate()));
				persons.add(person);
				System.out.println("person::::::::::::"+person.getPersonName());
				request.setAttribute("persons", persons);
			}
		}
		_log.info("getPersonalDetailsBydfrn() >>>> method ended >>>>");

	}
	/**
	 * @return Return person object
	 */
	public Person getPersonDetails(String dfrn, ResourceRequest request, ResourceResponse response) throws IOException {
		_log.info("getPersonDetails() >>>> method started >>>>");
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		String groupId =String.valueOf(themeDisplay.getScopeGroupId());
		String caseRequestUrl = themeDisplay.getPortalURL() + LRObjectURL.CASE_REQUEST_URL.replace("{scope-id}", groupId) + StringPool.QUESTION + "filter=caseNumber" + URLEncoder.encode(" eq " + "'" + dfrn + "'", DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
		String caseRequestResponse = omsbCommonApi.getData(caseRequestUrl);
		CaseRequest caseRequest = CustomObjectMapperUtil.readValue(caseRequestResponse, CaseRequest.class);
		long personId=0;	
		if(caseRequest.getItems().size()>0) {
			personId = caseRequest.getItems().get(0).getPersonId();
		}
		String personUrl = themeDisplay.getPortalURL() + LRObjectURL.PERSON_URL.replace("{scope-id}", groupId) + StringPool.QUESTION + "filter=id" + URLEncoder.encode(" eq " + "'" + personId + "'", DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
		String personResponse = omsbCommonApi.getData(personUrl);
		Person person = CustomObjectMapperUtil.readValue(personResponse, Person.class);
		_log.info("getPersonDetails() >>>> method ended >>>>");
		return person;

	}
	public String convertDateFormat(String date) {	
		String convertedDate="";	
		DateFormat oldDF = new SimpleDateFormat(DataflowConstants.DATE_FORMAT_OLD);	
		DateFormat newDF = new SimpleDateFormat(DataflowConstants.DATE_FORMAT);	
		Date oldDate;
		try {
			if (Validator.isNotNull(date) && date != "") {
				oldDate = oldDF.parse(date);
				convertedDate = newDF.format(oldDate); // check again is this required to set with new date format or can be used with above date format in object mapper
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}	
		_log.debug("convertedDate:::::::"+convertedDate);	
		return convertedDate;	
	}
	
	private Person addPersonDeatails(String name,String caseNumber,String caseStatus,long id, String verificationDate) {
		_log.info("addPersonDeatails:::::"+name+" ,caseNumber "+caseNumber+" , caseStatus : "+caseStatus+" , id "+id+" verificationDate "+verificationDate);
		Person person = new Person();
		person.setPersonName(name);
		person.setCaseNumber(caseNumber);
		person.setCaseStatus(caseStatus);
		person.setCaseRequestId(id);
		person.setVerificationDate(verificationDate);
		return person;
	}
	
	@Reference(unbind = "_")
	private OMSBCommonApi omsbCommonApi;
	private static final Log _log = LogFactoryUtil.getLog(OmsbVehpcVerificationWebPortlet.class);

}
