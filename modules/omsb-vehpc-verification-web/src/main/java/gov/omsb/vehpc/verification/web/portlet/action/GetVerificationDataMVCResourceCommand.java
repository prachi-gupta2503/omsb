package gov.omsb.vehpc.verification.web.portlet.action;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
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
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.vehpc.verification.util.VerificationUtil;
import gov.omsb.verification.dto.CaseRequest;
import gov.omsb.verification.dto.CaseRequestItem;
import gov.omsb.verification.dto.CaseStatus;
import gov.omsb.verification.dto.CaseStatusItem;
import gov.omsb.verification.dto.Person;
import gov.omsb.verification.dto.PersonItem;
import gov.omsb.verification.dto.PersonalDetail;
import omsb.vehpc.verification.web.constants.MVCCommands;
import omsb.vehpc.verification.web.constants.OmsbVehpcVerificationWebPortletKeys;
import omsb.vehpc.verification.web.portlet.OmsbVehpcVerificationWebPortlet;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbVehpcVerificationWebPortletKeys.OMSBVEHPCVERIFICATIONWEB,
		"mvc.command.name=" + MVCCommands.GET_VERIFICATION_DATA }, service = MVCResourceCommand.class
)

public class GetVerificationDataMVCResourceCommand extends BaseMVCResourceCommand {

	public void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws JSONException, IOException {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		_log.info(">>>>serve resource() getVerificationData>>>> method started>>>>");
		String dfrn = ParamUtil.getString(resourceRequest, "dfrn");
		String verificationDate = ParamUtil.getString(resourceRequest, "verificationDate");
		String status = ParamUtil.getString(resourceRequest, "status");
		long personId = ParamUtil.getLong(resourceRequest, "personId");
		_log.info("personId:::"+personId);
		String convertedVerificationDate="";
		if(Validator.isNotNull(verificationDate)) {
			convertedVerificationDate = omsbCommonApi.convertDateFormat(verificationDate);	
		}
		if (!dfrn.isEmpty() && (Validator.isNull(status))) {
			getVerificationDetailsByDfrnAndDate(dfrn, convertedVerificationDate,personId, resourceRequest,resourceResponse);
		} else if (dfrn.isEmpty() && (Validator.isNotNull(status))) {
			getVerificationDetailsByStatusAndDate(status, convertedVerificationDate,personId, resourceRequest,resourceResponse);
		} else if (!dfrn.isEmpty() && (Validator.isNotNull(status))) {
			getVerificationDetailsByStatusAndDfrnAndDate(status, dfrn, convertedVerificationDate,personId,resourceRequest,resourceResponse);
		} else if(Validator.isNotNull(convertedVerificationDate) && dfrn.isEmpty() && Validator.isNull(status) ) {
			getVerificationDetailsByDate(convertedVerificationDate,personId,resourceRequest,resourceResponse);
		}else if(Validator.isNotNull(personId) && personId>0) {
			List<Person> persons = new ArrayList<>();
			Person person = verificationUtil.getPersonalDetailsByPersonId(personId,themeDisplay);
			persons.add(person);
			resourceRequest.setAttribute("persons", persons);
		}else if(dfrn.isEmpty() && Validator.isNull(status) && Validator.isNull(convertedVerificationDate)) {
			verificationUtil.getVerificationDetails(resourceRequest,resourceResponse);
		}
		_log.info("persons"+resourceRequest.getAttribute("persons"));
		resourceRequest.setAttribute("persons", resourceRequest.getAttribute("persons"));
		PortletRequestDispatcher dispatcher = resourceRequest.getPortletSession().getPortletContext().getRequestDispatcher("/jsps/verification/search-data.jsp");
		try {
			dispatcher.include(resourceRequest, resourceResponse);
		} catch (PortletException | IOException e) {
			e.printStackTrace();
		}

		_log.info("serve resource() getVerificationData>>>> method ended>>>>");
	}
	public void getVerificationDetailsByDfrnAndDate(String dfrn,String convertedVerificationDate,long personIdFromSearch, ResourceRequest request, ResourceResponse response)
			throws JSONException, IOException {
		_log.info("getPersonalDetailsByDfrn() >>>> method started >>>>");
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		boolean isVehpcAdmin = omsbCommonApi.checkLoggedInUserByRoleName(RoleNameConstants.VEHPC_ADMIN , themeDisplay.getUserId());
		Person loggedUserPerson = verificationUtil.fetchPersonByloggedUserId(themeDisplay);
		JSONArray jsonArr = JSONFactoryUtil.createJSONArray();
		List<Person> persons = new ArrayList<>();
		String caseRequestUrl="";
		if(isVehpcAdmin) {
			if(Validator.isNotNull(personIdFromSearch) && Long.valueOf(personIdFromSearch)>0 && Validator.isNotNull(convertedVerificationDate)) {
				caseRequestUrl = themeDisplay.getPortalURL() + LRObjectURL.CASE_REQUEST_URL.replace("{scope-id}", String.valueOf(themeDisplay.getScopeGroupId())) + StringPool.QUESTION + "filter="+StringPool.OPEN_PARENTHESIS+"caseNumber" + URLEncoder.encode(" eq " + "'" + dfrn + "'" +StringPool.CLOSE_PARENTHESIS+" and "+StringPool.OPEN_PARENTHESIS+"personId eq " + personIdFromSearch+StringPool.CLOSE_PARENTHESIS+" and "+StringPool.OPEN_PARENTHESIS+"verificationDate eq " + convertedVerificationDate+StringPool.CLOSE_PARENTHESIS , DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
			}else if(Validator.isNotNull(convertedVerificationDate)) {
				caseRequestUrl = themeDisplay.getPortalURL() + LRObjectURL.CASE_REQUEST_URL.replace("{scope-id}", String.valueOf(themeDisplay.getScopeGroupId())) + StringPool.QUESTION + "filter="+StringPool.OPEN_PARENTHESIS+"caseNumber" + URLEncoder.encode(" eq " + "'" + dfrn + "'" +StringPool.CLOSE_PARENTHESIS+" and "+StringPool.OPEN_PARENTHESIS+"verificationDate eq " + convertedVerificationDate+StringPool.CLOSE_PARENTHESIS , DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
			}else if(Validator.isNotNull(personIdFromSearch) && Long.valueOf(personIdFromSearch)>0) {
				caseRequestUrl = themeDisplay.getPortalURL() + LRObjectURL.CASE_REQUEST_URL.replace("{scope-id}", String.valueOf(themeDisplay.getScopeGroupId())) + StringPool.QUESTION + "filter="+StringPool.OPEN_PARENTHESIS+"caseNumber" + URLEncoder.encode(" eq " + "'" + dfrn + "'" +StringPool.CLOSE_PARENTHESIS+" and "+StringPool.OPEN_PARENTHESIS+"personId eq " + personIdFromSearch+StringPool.CLOSE_PARENTHESIS , DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
			}else {
				caseRequestUrl = themeDisplay.getPortalURL() + LRObjectURL.CASE_REQUEST_URL.replace("{scope-id}", String.valueOf(themeDisplay.getScopeGroupId())) + StringPool.QUESTION + "filter=caseNumber" + URLEncoder.encode(" eq " + "'" + dfrn + "'", DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
			}
		}else {
			if(Validator.isNotNull(loggedUserPerson) && loggedUserPerson.getItems().size()>0) {
				for(PersonItem personItem : loggedUserPerson.getItems()) {
					if(Validator.isNotNull(convertedVerificationDate)) {
						caseRequestUrl = themeDisplay.getPortalURL() + LRObjectURL.CASE_REQUEST_URL.replace("{scope-id}", String.valueOf(themeDisplay.getScopeGroupId())) + StringPool.QUESTION + "filter="+StringPool.OPEN_PARENTHESIS+"caseNumber" + URLEncoder.encode(" eq " + "'" + dfrn + "'" +StringPool.CLOSE_PARENTHESIS+" and "+StringPool.OPEN_PARENTHESIS+"verificationDate eq " + convertedVerificationDate+StringPool.CLOSE_PARENTHESIS+" and "+StringPool.OPEN_PARENTHESIS+"personId eq " + personItem.getId()+StringPool.CLOSE_PARENTHESIS , DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
					}else {
						caseRequestUrl = themeDisplay.getPortalURL() + LRObjectURL.CASE_REQUEST_URL.replace("{scope-id}", String.valueOf(themeDisplay.getScopeGroupId())) + StringPool.QUESTION + "filter="+StringPool.OPEN_PARENTHESIS+"caseNumber" + URLEncoder.encode(" eq " + "'" + dfrn + "'" +StringPool.CLOSE_PARENTHESIS+" and "+StringPool.OPEN_PARENTHESIS+"personId eq " + personItem.getId()+StringPool.CLOSE_PARENTHESIS , DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
					}
				}
			}
		}
		String caseRequestResponse = omsbCommonApi.getData(caseRequestUrl);
		_log.info(caseRequestUrl+" , caseRequestResponse >>>> method started >>>>"+caseRequestResponse);
		CaseRequest caseRequest = CustomObjectMapperUtil.readValue(caseRequestResponse, CaseRequest.class);
		if( Validator.isNotNull(caseRequest) && caseRequest.getItems().size()>0) {
			for(CaseRequestItem caseRequestObj : caseRequest.getItems()) {
				long personId=caseRequestObj.getPersonId();
				long caseStatusId=caseRequestObj.getCaseStatusId();
				PersonalDetail personDetails = verificationUtil.fetchPersonalDetailsByPersonId(personId, themeDisplay);
				CaseStatusItem caseStatusById = verificationUtil.fetchCaseStatusByCaseStatusId(caseStatusId,themeDisplay);
				
				String name = "";
				if(Validator.isNotNull(personDetails) && Validator.isNotNull(personDetails.getItems()) && !(personDetails.getItems().isEmpty())) {
					name = personDetails.getItems().get(0).getGivenNameAsPassport();
				}
				String caseNumber="";
				long caseRequestId=0;
				if(Validator.isNotNull(caseRequest) && Validator.isNotNull(caseRequest.getItems()) && !(caseRequest.getItems().isEmpty())) {
					caseNumber= caseRequestObj.getCaseNumber();
					caseRequestId = caseRequestObj.getId();
				}
				String status = "";
				if(Validator.isNotNull(caseStatusById) && Validator.isNotNull(caseStatusById.getCaseStatus())) {
					status = caseStatusById.getCaseStatus().getName();
				}
				
				Person person = verificationUtil.addPersonDeatails(name,caseNumber,status,caseRequestId,omsbCommonApi.convertObjectDateToDDMMYYYYDate(caseRequestObj.getVerificationDate()));
				persons.add(person);
			}
		}
		request.setAttribute("persons", persons);
		_log.info("getPersonalDetailsByDfrn() >>>> method End >>>>"+jsonArr);
	}
	
	
	public void getVerificationDetailsByStatusAndDate(String status, String convertedVerificationDate,long personIdFromSearch, ResourceRequest request, ResourceResponse response)
			throws JSONException, IOException {
		_log.info(">>>>getVerificationDetailsByStatus >>>> method started >>>>");
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		boolean isVehpcAdmin = omsbCommonApi.checkLoggedInUserByRoleName(RoleNameConstants.VEHPC_ADMIN , themeDisplay.getUserId());
		Person loggedUserPerson = verificationUtil.fetchPersonByloggedUserId(themeDisplay);
		String caseStatusUrl = themeDisplay.getPortalURL()+LRObjectURL.CASE_STATUS_URL.replace("{scope-id}", String.valueOf(themeDisplay.getScopeGroupId()))+StringPool.QUESTION + "filter=caseStatus"+URLEncoder.encode(" eq " + "'"+ status + "'" , DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
		String caseStatusResponse = omsbCommonApi.getData(caseStatusUrl);
		_log.info("getVerificationDetailsByStatusAndDate ::::caseStatusResponse::::"+caseStatusResponse);
		CaseStatus caseStatus =  CustomObjectMapperUtil.readValue(caseStatusResponse, CaseStatus.class);
		PersonalDetail personDetails=null;
		List<Person> persons = new ArrayList<>();
		if(!isVehpcAdmin) {
			if(Validator.isNotNull(caseStatus) && Validator.isNotNull(caseStatus.getItems()) && !(caseStatus.getItems().isEmpty()) && Validator.isNotNull(loggedUserPerson) && Validator.isNotNull(loggedUserPerson.getItems()) && !(loggedUserPerson.getItems().isEmpty())) {
				for(PersonItem loggedUserPersonObj : loggedUserPerson.getItems()) {
					long caseStatusId = caseStatus.getItems().get(0).getId();
					long personId = loggedUserPersonObj.getId();
					personDetails = verificationUtil.fetchPersonalDetailsByPersonId(personId, themeDisplay);
					String caseRequestUrl="";
					if(Validator.isNotNull(convertedVerificationDate)) {
						caseRequestUrl = themeDisplay.getPortalURL() + LRObjectURL.CASE_REQUEST_URL.replace("{scope-id}", String.valueOf(themeDisplay.getScopeGroupId()))+StringPool.QUESTION+"filter="+StringPool.OPEN_PARENTHESIS+"caseStatusId"+URLEncoder.encode(" eq "+caseStatusId+StringPool.CLOSE_PARENTHESIS + " and " +StringPool.OPEN_PARENTHESIS+"personId eq "+personId+StringPool.CLOSE_PARENTHESIS+" and "+StringPool.OPEN_PARENTHESIS+"verificationDate eq " + convertedVerificationDate + StringPool.CLOSE_PARENTHESIS  , DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
					}else {
						caseRequestUrl = themeDisplay.getPortalURL() + LRObjectURL.CASE_REQUEST_URL.replace("{scope-id}", String.valueOf(themeDisplay.getScopeGroupId()))+StringPool.QUESTION+"filter="+StringPool.OPEN_PARENTHESIS+"caseStatusId"+URLEncoder.encode(" eq "+caseStatusId+StringPool.CLOSE_PARENTHESIS + " and " +StringPool.OPEN_PARENTHESIS+"personId eq "+personId+StringPool.CLOSE_PARENTHESIS , DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;	
					}
					String caseRequestResponse = omsbCommonApi.getData(caseRequestUrl);
					_log.info(caseRequestUrl+" : caseRequestResponse:::::"+caseRequestResponse);		
					CaseRequest caseRequest =  CustomObjectMapperUtil.readValue(caseRequestResponse, CaseRequest.class);
					if(Validator.isNotNull(caseRequest) && caseRequest.getItems().size() > 0) {
						for(CaseRequestItem caseRequestObj : caseRequest.getItems()) {
							String name = "";
							if(Validator.isNotNull(personDetails) && Validator.isNotNull(personDetails.getItems()) && !(personDetails.getItems().isEmpty())) {
								name = personDetails.getItems().get(0).getGivenNameAsPassport();
							}
							Person person = verificationUtil.addPersonDeatails(name,caseRequestObj.getCaseNumber(),status,Long.valueOf(caseRequestObj.getId()), omsbCommonApi.convertObjectDateToDDMMYYYYDate(caseRequestObj.getVerificationDate()));
							persons.add(person);
						}
					}
					
				}
			}
		}else {
			if(Validator.isNotNull(caseStatus) && Validator.isNotNull(caseStatus.getItems()) && !(caseStatus.getItems().isEmpty())) {
				long caseStatusId = caseStatus.getItems().get(0).getId();
				String caseRequestUrl="";
				if(Validator.isNotNull(personIdFromSearch) && Long.valueOf(personIdFromSearch)>0 && Validator.isNotNull(convertedVerificationDate)) {
					caseRequestUrl = themeDisplay.getPortalURL() + LRObjectURL.CASE_REQUEST_URL.replace("{scope-id}", String.valueOf(themeDisplay.getScopeGroupId())) + StringPool.QUESTION + "filter="+StringPool.OPEN_PARENTHESIS+"caseStatusId" + URLEncoder.encode(" eq " + caseStatusId +StringPool.CLOSE_PARENTHESIS+" and "+StringPool.OPEN_PARENTHESIS+"personId eq " + personIdFromSearch+StringPool.CLOSE_PARENTHESIS+" and "+StringPool.OPEN_PARENTHESIS+"verificationDate eq " + convertedVerificationDate+StringPool.CLOSE_PARENTHESIS , DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
				}else if(Validator.isNotNull(convertedVerificationDate)) {
					caseRequestUrl = themeDisplay.getPortalURL() + LRObjectURL.CASE_REQUEST_URL.replace("{scope-id}", String.valueOf(themeDisplay.getScopeGroupId()))+StringPool.QUESTION+"filter="+StringPool.OPEN_PARENTHESIS+"caseStatusId"+URLEncoder.encode(" eq "+caseStatusId +StringPool.CLOSE_PARENTHESIS+" and "+StringPool.OPEN_PARENTHESIS+"verificationDate eq "+convertedVerificationDate+StringPool.CLOSE_PARENTHESIS, DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
				}else if(Validator.isNotNull(personIdFromSearch) && Long.valueOf(personIdFromSearch)>0) {
					caseRequestUrl = themeDisplay.getPortalURL() + LRObjectURL.CASE_REQUEST_URL.replace("{scope-id}", String.valueOf(themeDisplay.getScopeGroupId())) + StringPool.QUESTION + "filter="+StringPool.OPEN_PARENTHESIS+"caseStatusId" + URLEncoder.encode(" eq " + caseStatusId +StringPool.CLOSE_PARENTHESIS+" and "+StringPool.OPEN_PARENTHESIS+"personId eq " + personIdFromSearch+StringPool.CLOSE_PARENTHESIS , DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
				}else {
					caseRequestUrl = themeDisplay.getPortalURL() + LRObjectURL.CASE_REQUEST_URL.replace("{scope-id}", String.valueOf(themeDisplay.getScopeGroupId()))+StringPool.QUESTION+"filter=caseStatusId"+URLEncoder.encode(" eq "+caseStatusId , DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
				}
				String caseRequestResponse = omsbCommonApi.getData(caseRequestUrl);
				_log.info(" getVerificationDetailsByStatusAndDate, caseRequestResponse "+caseRequestResponse);
				CaseRequest caseRequest =  CustomObjectMapperUtil.readValue(caseRequestResponse, CaseRequest.class);
				
				if(Validator.isNotNull(caseRequest) && Validator.isNotNull(caseRequest.getItems()) && !(caseRequest.getItems().isEmpty())) {
					for(CaseRequestItem caseRequestobj : caseRequest.getItems()) {
						long personId=caseRequestobj.getPersonId();
						personDetails = verificationUtil.fetchPersonalDetailsByPersonId(personId, themeDisplay);
						
						String name = "";
						if(Validator.isNotNull(personDetails) && Validator.isNotNull(personDetails.getItems()) && !(personDetails.getItems().isEmpty())) {
							name = personDetails.getItems().get(0).getGivenNameAsPassport();
							_log.info("personDetails GivenNameAsPassport "+personDetails.getItems().get(0).getGivenNameAsPassport());
						}
						Person person = verificationUtil.addPersonDeatails(name,caseRequestobj.getCaseNumber(),status,caseRequestobj.getId(),omsbCommonApi.convertObjectDateToDDMMYYYYDate(caseRequestobj.getVerificationDate()));
						persons.add(person);
					}
				}
			}
		}
		request.setAttribute("persons", persons);
		_log.info(">>>>getVerificationDetailsByStatus >>>> method Ends >>>>");
	}
	
	public void getVerificationDetailsByStatusAndDfrnAndDate(String status,String dfrn ,String convertedVerificationDate ,long personIdFromSearch, ResourceRequest request, ResourceResponse response)
			throws JSONException, IOException {
		_log.info(">>>>getVerificationDetailsByStatusAndDfrn >>>> method started >>>>");
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		boolean isVehpcAdmin = omsbCommonApi.checkLoggedInUserByRoleName(RoleNameConstants.VEHPC_ADMIN , themeDisplay.getUserId());
		Person loggedUserPerson = verificationUtil.fetchPersonByloggedUserId(themeDisplay);
		List<Person> persons = new ArrayList<>();
		String caseStatusUrl = themeDisplay.getPortalURL()+LRObjectURL.CASE_STATUS_URL.replace("{scope-id}", String.valueOf(themeDisplay.getScopeGroupId()))+StringPool.QUESTION + "filter=caseStatus"+URLEncoder.encode(" eq " + "'"+ status + "'" , DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
		String caseStatusResponse = omsbCommonApi.getData(caseStatusUrl);
		CaseStatus caseStatus =  CustomObjectMapperUtil.readValue(caseStatusResponse, CaseStatus.class);
		if(Validator.isNotNull(caseStatus.getItems()) && !(caseStatus.getItems().isEmpty()) ) {
			long caseStatusId = caseStatus.getItems().get(0).getId();
			String caseRequestUrl="";
			if(isVehpcAdmin) {
				if(Validator.isNotNull(personIdFromSearch) && Long.valueOf(personIdFromSearch)>0){
					caseRequestUrl = themeDisplay.getPortalURL() + LRObjectURL.CASE_REQUEST_URL.replace("{scope-id}", String.valueOf(themeDisplay.getScopeGroupId()))+StringPool.QUESTION+"filter="+StringPool.OPEN_PARENTHESIS+"caseStatusId"+URLEncoder.encode(" eq "+caseStatusId+StringPool.CLOSE_PARENTHESIS + " and " +StringPool.OPEN_PARENTHESIS+"caseNumber eq "+ "'"+dfrn+"'"+StringPool.CLOSE_PARENTHESIS+" and "+StringPool.OPEN_PARENTHESIS+" verificationDate eq "+convertedVerificationDate+StringPool.CLOSE_PARENTHESIS+" and "+StringPool.OPEN_PARENTHESIS+"personId eq " + personIdFromSearch+StringPool.CLOSE_PARENTHESIS , DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
				}else {
					caseRequestUrl = themeDisplay.getPortalURL() + LRObjectURL.CASE_REQUEST_URL.replace("{scope-id}", String.valueOf(themeDisplay.getScopeGroupId()))+StringPool.QUESTION+"filter="+StringPool.OPEN_PARENTHESIS+"caseStatusId"+URLEncoder.encode(" eq "+caseStatusId+StringPool.CLOSE_PARENTHESIS + " and " +StringPool.OPEN_PARENTHESIS+"caseNumber eq "+ "'"+dfrn+"'"+StringPool.CLOSE_PARENTHESIS+" and "+StringPool.OPEN_PARENTHESIS+" verificationDate eq "+convertedVerificationDate+StringPool.CLOSE_PARENTHESIS , DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
				}
			}else {
				
			if(Validator.isNotNull(loggedUserPerson) && loggedUserPerson.getItems().size()>0) {
				
				for(PersonItem loggedUser : loggedUserPerson.getItems()) {
					if(Validator.isNotNull(convertedVerificationDate)) {
						caseRequestUrl = themeDisplay.getPortalURL() + LRObjectURL.CASE_REQUEST_URL.replace("{scope-id}", String.valueOf(themeDisplay.getScopeGroupId()))+StringPool.QUESTION+"filter="+StringPool.OPEN_PARENTHESIS+"caseStatusId"+URLEncoder.encode(" eq "+caseStatusId+StringPool.CLOSE_PARENTHESIS + " and " +StringPool.OPEN_PARENTHESIS+"caseNumber eq "+ "'"+dfrn+"'"+StringPool.CLOSE_PARENTHESIS+" and "+StringPool.OPEN_PARENTHESIS+" verificationDate eq "+convertedVerificationDate+StringPool.CLOSE_PARENTHESIS+" and "+StringPool.OPEN_PARENTHESIS+"personId eq " + loggedUser.getId()+StringPool.CLOSE_PARENTHESIS , DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
					}else {
						caseRequestUrl = themeDisplay.getPortalURL() + LRObjectURL.CASE_REQUEST_URL.replace("{scope-id}", String.valueOf(themeDisplay.getScopeGroupId()))+StringPool.QUESTION+"filter="+StringPool.OPEN_PARENTHESIS+"caseStatusId"+URLEncoder.encode(" eq "+caseStatusId+StringPool.CLOSE_PARENTHESIS + " and " +StringPool.OPEN_PARENTHESIS+"caseNumber eq "+ "'"+dfrn+"'"+StringPool.CLOSE_PARENTHESIS+" and "+StringPool.OPEN_PARENTHESIS+"personId eq " + loggedUser.getId()+StringPool.CLOSE_PARENTHESIS , DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
					}
				}
			}
				
			}
			
				
			String caseRequestResponse = omsbCommonApi.getData(caseRequestUrl);
			_log.info(caseRequestUrl+" ::caseRequestResponse:::::"+caseRequestResponse);
			CaseRequest caseRequest =  CustomObjectMapperUtil.readValue(caseRequestResponse, CaseRequest.class);
			PersonalDetail personDetails=null;
			if(Validator.isNotNull(caseRequest) && caseRequest.getItems().size()>0) {
				for(CaseRequestItem caseRequestObj : caseRequest.getItems()) {
					personDetails = verificationUtil.fetchPersonalDetailsByPersonId(caseRequestObj.getPersonId(), themeDisplay);
					String name = "";
					if(Validator.isNotNull(personDetails) && Validator.isNotNull(personDetails.getItems()) && !(personDetails.getItems().isEmpty())) {
						name = personDetails.getItems().get(0).getGivenNameAsPassport();
					}
					Person person = verificationUtil.addPersonDeatails(name,dfrn,status,caseRequestObj.getId(),omsbCommonApi.convertObjectDateToDDMMYYYYDate(caseRequestObj.getVerificationDate()));
					persons.add(person);
				}
			}
		}
			request.setAttribute("persons", persons);
		_log.info(">>>>getVerificationDetailsByStatusAndDfrn >>>> method Ends >>>>");
		
	}
	
	public void getVerificationDetailsByDate(String convertedVerificationDate ,long personIdFromSearch, ResourceRequest request, ResourceResponse response) throws UnsupportedEncodingException {

		_log.info(">>>>getVerificationDetailsByDate >>>> method started >>>>");
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		boolean isVehpcAdmin = omsbCommonApi.checkLoggedInUserByRoleName(RoleNameConstants.VEHPC_ADMIN , themeDisplay.getUserId());
		
		Person loggedUserPersons = verificationUtil.fetchPersonByloggedUserId(themeDisplay);
		PersonalDetail personDetails=null;
		
		if(!isVehpcAdmin) {
			List<Person> persons = new ArrayList<>();
			_log.info("isVehpcAdmin not");
			if(Validator.isNotNull(loggedUserPersons.getItems()) && !(loggedUserPersons.getItems().isEmpty())) {
				for(PersonItem loggedUserPerson : loggedUserPersons.getItems()) {
					long personId = loggedUserPerson.getId();
					personDetails = verificationUtil.fetchPersonalDetailsByPersonId(personId, themeDisplay);
					String caseRequestUrl= themeDisplay.getPortalURL() + LRObjectURL.CASE_REQUEST_URL.replace("{scope-id}", String.valueOf(themeDisplay.getScopeGroupId()))+StringPool.QUESTION+"filter="+StringPool.OPEN_PARENTHESIS+"verificationDate"+URLEncoder.encode(" eq "+convertedVerificationDate+StringPool.CLOSE_PARENTHESIS + " and " +StringPool.OPEN_PARENTHESIS+"personId eq "+personId+StringPool.CLOSE_PARENTHESIS  , DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
					String caseRequestResponse = omsbCommonApi.getData(caseRequestUrl);
					CaseRequest caseRequest =  CustomObjectMapperUtil.readValue(caseRequestResponse, CaseRequest.class);
					_log.info("::::caseRequestResponse not admin ::"+caseRequestResponse);
					if(Validator.isNotNull(caseRequest) && caseRequest.getItems().size()>0) {
						for(CaseRequestItem caseRequestObj : caseRequest.getItems()) {
							CaseStatusItem caseStatusItem= verificationUtil.fetchCaseStatusByCaseStatusId(caseRequestObj.getCaseStatusId(),themeDisplay);
							String name = "";
							if(Validator.isNotNull(personDetails) && Validator.isNotNull(personDetails.getItems()) && !(personDetails.getItems().isEmpty())) {
								name = personDetails.getItems().get(0).getGivenNameAsPassport();
							}
							String status="";
							if(Validator.isNotNull(caseStatusItem) && Validator.isNotNull(caseStatusItem.getCaseStatus()) && !(caseStatusItem.getCaseStatus().getName().isEmpty())){
								status = caseStatusItem.getCaseStatus().getName();
							}
							Person person = verificationUtil.addPersonDeatails(name,caseRequestObj.getCaseNumber(),status,caseRequestObj.getId(),omsbCommonApi.convertObjectDateToDDMMYYYYDate(caseRequestObj.getVerificationDate()));
							persons.add(person);
						
					}
				}
				request.setAttribute("persons", persons);
				_log.info("persons not admin"+persons);
			}	
			}
		}else {
				List<Person> persons = new ArrayList<>();
				String caseRequestUrl="";
				if(Validator.isNotNull(personIdFromSearch) && Long.valueOf(personIdFromSearch)>0){
					caseRequestUrl = themeDisplay.getPortalURL() + LRObjectURL.CASE_REQUEST_URL.replace("{scope-id}", String.valueOf(themeDisplay.getScopeGroupId()))+StringPool.QUESTION+"filter="+StringPool.OPEN_PARENTHESIS+"verificationDate"+URLEncoder.encode(" eq "+convertedVerificationDate +StringPool.CLOSE_PARENTHESIS+" and "+StringPool.OPEN_PARENTHESIS+"personId eq " + personIdFromSearch+StringPool.CLOSE_PARENTHESIS, DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
				}else {
					caseRequestUrl = themeDisplay.getPortalURL() + LRObjectURL.CASE_REQUEST_URL.replace("{scope-id}", String.valueOf(themeDisplay.getScopeGroupId()))+StringPool.QUESTION+"filter=verificationDate"+URLEncoder.encode(" eq "+convertedVerificationDate , DataflowConstants.UTF_8)+OmsbVehpcVerificationWebPortletKeys.PAGE_SIZE_WITH_FILTER;
				}
				
				String caseRequestResponse = omsbCommonApi.getData(caseRequestUrl);
				_log.info("caseRequestUrl :::"+caseRequestUrl+" vvvvvvvcaseRequestResponse :::::"+caseRequestResponse);
				CaseRequest caseRequests =  CustomObjectMapperUtil.readValue(caseRequestResponse, CaseRequest.class);
				if(Validator.isNotNull(caseRequests) && Validator.isNotNull(caseRequests.getItems()) && !(caseRequests.getItems().isEmpty())) {
					for(CaseRequestItem caseRequestItem : caseRequests.getItems()) {
						long personId=caseRequestItem.getPersonId();
						CaseStatusItem caseStatusItem= verificationUtil.fetchCaseStatusByCaseStatusId(caseRequestItem.getCaseStatusId(),themeDisplay);
						personDetails = verificationUtil.fetchPersonalDetailsByPersonId(personId, themeDisplay);
						
						String name="";
						if(Validator.isNotNull(personDetails) && Validator.isNotNull(personDetails.getItems()) && !(personDetails.getItems().isEmpty())) {
							name = personDetails.getItems().get(0).getGivenNameAsPassport();
						}
						String status="";
						if(Validator.isNotNull(caseStatusItem) && Validator.isNotNull(caseStatusItem.getCaseStatus()) && !(caseStatusItem.getCaseStatus().getName().isEmpty())){
							status = caseStatusItem.getCaseStatus().getName();
						}
						Person person = verificationUtil.addPersonDeatails(name,caseRequestItem.getCaseNumber(),status,caseRequestItem.getId(),omsbCommonApi.convertObjectDateToDDMMYYYYDate(caseRequestItem.getVerificationDate()));
						persons.add(person);
					}
					_log.info("persons:::::::"+persons.size());
					request.setAttribute("persons", persons);
				}
		} 
	}
	
	
	@Reference(unbind = "_")
	private OMSBCommonApi omsbCommonApi;
	
	@Reference(unbind = "_")
	private VerificationUtil verificationUtil;
	
	private static final Log _log = LogFactoryUtil.getLog(OmsbVehpcVerificationWebPortlet.class);

}
