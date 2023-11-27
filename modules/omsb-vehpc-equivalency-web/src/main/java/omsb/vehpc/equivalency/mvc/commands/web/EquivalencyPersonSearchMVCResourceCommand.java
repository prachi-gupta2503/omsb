package omsb.vehpc.equivalency.mvc.commands.web;

import com.liferay.petra.string.StringPool;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import omsb.vehpc.equivalency.dto.web.DocumentInfoItems;
import omsb.vehpc.equivalency.dto.web.EducationalDetail;
import omsb.vehpc.equivalency.dto.web.EducationalDetailItem;
import omsb.vehpc.equivalency.dto.web.EquivalencyDto;
import omsb.vehpc.equivalency.dto.web.EquivalencyDtoItem;
import omsb.vehpc.equivalency.dto.web.EquivalencyPassingData;
import omsb.vehpc.equivalency.web.constants.MVCCommandNames;
import omsb.vehpc.equivalency.web.constants.OmsbVehpcEquivalencyWebPortletKeys;
/**
 * @author Mahaboob
 */
@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbVehpcEquivalencyWebPortletKeys.OMSBVEHPCEQUIVALENCYWEB,
	        "mvc.command.name="+MVCCommandNames.EQUIVALENCY_PERSON_SEARCH
	    }, 
	    service = MVCResourceCommand.class
)
public class EquivalencyPersonSearchMVCResourceCommand extends BaseMVCResourceCommand{
	
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		LOGGER.info("doServeResource >>>Invoked>>>");
		String empDfrn = ParamUtil.getString(resourceRequest, "employeeDfrn");
		String empCivilId = ParamUtil.getString(resourceRequest, "employeeCivilId");
		String empPassport = ParamUtil.getString(resourceRequest, "employeePassportNumber");
		String empDateOfBirth = ParamUtil.getString(resourceRequest, "employeeDateOfBirth");
		
		String convertedEmployeeDateOfBirth="";
		if(Validator.isNotNull(empDateOfBirth)) {
			convertedEmployeeDateOfBirth = omsbCommonApi.convertDateFormat(empDateOfBirth);	
		}
		
		LOGGER.info("employeeCivilId : " +empCivilId +" employeePassportNumber : "+empPassport+" employeeDateOfBirth : " +empDateOfBirth);
		
		if(Validator.isNotNull(empDfrn)) {
			getEquivalencyDetailsByDfrn(empDfrn,empCivilId,empPassport,convertedEmployeeDateOfBirth,resourceRequest,resourceResponse);
		}else {
			getEquivalencyDetails(empCivilId,empPassport,convertedEmployeeDateOfBirth,resourceRequest,resourceResponse);
		}
		try {
			PortletRequestDispatcher dispatcher = resourceRequest.getPortletSession().getPortletContext().getRequestDispatcher(OmsbVehpcEquivalencyWebPortletKeys.SEARCH_DATA_JSP);
			dispatcher.include(resourceRequest, resourceResponse);
		} catch (PortletException | IOException e) {
			LOGGER.info("Error while setting dispatcher, "+e.getMessage());
		}
		LOGGER.info("response >>>Invoked>>>");
	}
	
	private void getEquivalencyDetailsByDfrn(String empDfrn,String empCivilId,String empPassportNumber,String empDOB, ResourceRequest request, ResourceResponse response) throws UnsupportedEncodingException {
		LOGGER.info("getEquivalencyDetails >>>Invoked>>>");
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		List<EquivalencyPassingData> equivalencyList = new ArrayList<>();
		String caseRequestWithScopeUrl = generateScopeListURL(LRObjectURL.CASE_REQUEST_URL,themeDisplay.getScopeGroupId()) + StringPool.QUESTION + "filter=caseNumber" + URLEncoder.encode(" eq " + "'" + empDfrn + "'" , OmsbVehpcEquivalencyWebPortletKeys.UNICODE_TRANSFORMATION_FORMAT);
		String caseRequestResponse = omsbCommonApi.getData(caseRequestWithScopeUrl);
		LOGGER.info("caseRequestWithScopeUrl:::"+caseRequestWithScopeUrl+" ,caseRequestResponse, "+caseRequestResponse);
		EquivalencyDto caseRequests = CustomObjectMapperUtil.readValue(caseRequestResponse, EquivalencyDto.class);
		if(Validator.isNotNull(caseRequests) && Validator.isNotNull(caseRequests.getItems()) && !(caseRequests.getItems().isEmpty())) {
			long personId = caseRequests.getItems().get(0).getPersonId();
			String personUrl = themeDisplay.getPortalURL()+LRObjectURL.PERSON_BY_PK_URL + StringPool.FORWARD_SLASH + personId;
			String personResponse = omsbCommonApi.getData(personUrl);
			EquivalencyDtoItem equivalencyDto = CustomObjectMapperUtil.readValue(personResponse, EquivalencyDtoItem.class);
			if(Validator.isNotNull(equivalencyDto)) {
				EquivalencyDto personalDetail = fetchPersonDetailsByPersonId(personId,themeDisplay);
				String name=""; String email=""; String dateOfBirth="";
				if(Validator.isNotNull(personalDetail) && !(personalDetail.getItems().get(0).getGivenNameAsPassport().isEmpty())){
					name=personalDetail.getItems().get(0).getGivenNameAsPassport();
					email = personalDetail.getItems().get(0).getEmail();
					try {
						Date dob=new SimpleDateFormat(DataflowConstants.OBJECT_DATE_FORMAT).parse(equivalencyDto.getDateOfBirth());
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						dateOfBirth = sdf.format(dob);
					} catch (ParseException e) {
						LOGGER.info("Error while parsing dob string to date, "+e.getMessage());
					}
				}
				EquivalencyPassingData equivalencyPerson = addPersonDeatails(name, dateOfBirth, email, personId,empDfrn);
				equivalencyList.add(equivalencyPerson);
				LOGGER.info("::::::::::::"+equivalencyList.get(0).getDob()+equivalencyList.get(0).getPersonName()+equivalencyList.get(0).getPersonId());
			}
		}	
		
		LOGGER.info("equivalencyDtoList::::size::::::::::"+equivalencyList.size());
		request.setAttribute("equivalencyDtoList", equivalencyList);
	}
	
	private void getEquivalencyDetails(String empCivilId,String empPassportNumber,String empDOB, ResourceRequest request, ResourceResponse response) throws UnsupportedEncodingException {
		LOGGER.info("getEquivalencyDetails >>>Invoked>>>");
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		String personWithScopeURL = generateScopeListURL(LRObjectURL.PERSON_URL,themeDisplay.getScopeGroupId());
		String personUrl="";
		
		if(Validator.isNotNull(empCivilId) && Validator.isNotNull(empPassportNumber) && Validator.isNotNull(empDOB)) {
			personUrl = personWithScopeURL + StringPool.QUESTION + "filter="+StringPool.OPEN_PARENTHESIS+"civilId" + URLEncoder.encode(" eq " + "'" + empCivilId + "'" +StringPool.CLOSE_PARENTHESIS+" and "+StringPool.OPEN_PARENTHESIS + "passportNumber eq " + "'" + empPassportNumber + "'" + StringPool.CLOSE_PARENTHESIS +" and "+StringPool.OPEN_PARENTHESIS+ "dateOfBirth eq " + empDOB + StringPool.CLOSE_PARENTHESIS , OmsbVehpcEquivalencyWebPortletKeys.UNICODE_TRANSFORMATION_FORMAT);
		}else if(Validator.isNotNull(empPassportNumber) && Validator.isNotNull(empDOB)) {
			personUrl = personWithScopeURL + StringPool.QUESTION + "filter="+StringPool.OPEN_PARENTHESIS+"passportNumber" + URLEncoder.encode(" eq " + "'" + empPassportNumber + "'" +StringPool.CLOSE_PARENTHESIS+" and "+StringPool.OPEN_PARENTHESIS+"dateOfBirth eq " + empDOB + StringPool.CLOSE_PARENTHESIS , OmsbVehpcEquivalencyWebPortletKeys.UNICODE_TRANSFORMATION_FORMAT);
		}else if(Validator.isNotNull(empCivilId) && Validator.isNotNull(empDOB)) {
			personUrl = personWithScopeURL + StringPool.QUESTION + "filter="+StringPool.OPEN_PARENTHESIS+"civilId" + URLEncoder.encode(" eq " + "'" + empCivilId + "'" +StringPool.CLOSE_PARENTHESIS+" and "+StringPool.OPEN_PARENTHESIS+"dateOfBirth eq " + empDOB + StringPool.CLOSE_PARENTHESIS , OmsbVehpcEquivalencyWebPortletKeys.UNICODE_TRANSFORMATION_FORMAT);
		}else if(Validator.isNotNull(empCivilId) && Validator.isNotNull(empPassportNumber)) {
			personUrl = personWithScopeURL + StringPool.QUESTION + "filter="+StringPool.OPEN_PARENTHESIS+"civilId" + URLEncoder.encode(" eq " + "'" + empCivilId + "'" +StringPool.CLOSE_PARENTHESIS+" and "+StringPool.OPEN_PARENTHESIS+"passportNumber eq " + "'" + empPassportNumber + "'" + StringPool.CLOSE_PARENTHESIS , OmsbVehpcEquivalencyWebPortletKeys.UNICODE_TRANSFORMATION_FORMAT);
		}else if(Validator.isNotNull(empDOB)) {
			personUrl = personWithScopeURL + StringPool.QUESTION + "filter=dateOfBirth" + URLEncoder.encode(" eq " +  empDOB  , OmsbVehpcEquivalencyWebPortletKeys.UNICODE_TRANSFORMATION_FORMAT);
		}else if(Validator.isNotNull(empPassportNumber)) {
			personUrl = personWithScopeURL + StringPool.QUESTION + "filter=passportNumber" + URLEncoder.encode(" eq " + "'" + empPassportNumber + "'" , OmsbVehpcEquivalencyWebPortletKeys.UNICODE_TRANSFORMATION_FORMAT);
		}
//		else if(Validator.isNotNull(empCivilId)) {
//			personUrl = personWithScopeURL + StringPool.QUESTION + "filter=civilId" + URLEncoder.encode(" eq " + "'" + empCivilId + "'" , OmsbVehpcEquivalencyWebPortletKeys.UNICODE_TRANSFORMATION_FORMAT);
//		}
		LOGGER.info("personUrl::111111111111111111::"+personUrl);
		String personResponse = omsbCommonApi.getData(personUrl);
		LOGGER.info("personResponse:::22222222::::::::"+personResponse);
		EquivalencyDto equivalencyDtos = CustomObjectMapperUtil.readValue(personResponse, EquivalencyDto.class,new SimpleDateFormat(DataflowConstants.OBJECT_DATE_FORMAT));
		List<EquivalencyPassingData> equivalencyList = new ArrayList<>();
		if(Validator.isNotNull(equivalencyDtos) && Validator.isNotNull(equivalencyDtos.getItems()) && equivalencyDtos.getItems().size() > 0) {
			for(EquivalencyDtoItem equivalencyDto : equivalencyDtos.getItems()) {
				long personId = equivalencyDto.getId();
				
				String caseRequestWithScopeUrl = generateScopeListURL(LRObjectURL.CASE_REQUEST_URL,themeDisplay.getScopeGroupId()) + StringPool.QUESTION + "filter=personId" + URLEncoder.encode(" eq " + personId , OmsbVehpcEquivalencyWebPortletKeys.UNICODE_TRANSFORMATION_FORMAT);
				LOGGER.info("caseRequestWithScopeUrl:::"+caseRequestWithScopeUrl);
				String caseRequestResponse = omsbCommonApi.getData(caseRequestWithScopeUrl);
				LOGGER.info("caseRequestWithScopeUrl:::"+caseRequestWithScopeUrl+" ,caseRequestResponse, "+caseRequestResponse);
				EquivalencyDto caseRequests = CustomObjectMapperUtil.readValue(caseRequestResponse, EquivalencyDto.class);
				
				EquivalencyDto personalDetail = fetchPersonDetailsByPersonId(personId,themeDisplay);
				String name=""; String email=""; String dateOfBirth="";
				if(Validator.isNotNull(personalDetail) && Validator.isNotNull(personalDetail.getItems()) && personalDetail.getItems().size()>0){
					name = personalDetail.getItems().get(0).getGivenNameAsPassport();
					email = personalDetail.getItems().get(0).getEmail();
					try {
						Date dob=new SimpleDateFormat(DataflowConstants.OBJECT_DATE_FORMAT).parse(equivalencyDto.getDateOfBirth());
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						dateOfBirth = sdf.format(dob);
					} catch (ParseException e) {
						LOGGER.info("Error while parsing dob string to date, "+e.getMessage());
					}
				}
				String dfrn="";
				if(Validator.isNotNull(caseRequests) && caseRequests.getItems().size()>0) {
					dfrn=caseRequests.getItems().get(0).getCaseNumber();
					long caseRequestId = caseRequests.getItems().get(0).getId();
					String educationUrl = themeDisplay.getPortalURL()+LRObjectURL.EDUCATION_DETAIL_URL.replace(DataflowConstants.SCOPE_ID_VAR, String.valueOf(themeDisplay.getScopeGroupId())) + StringPool.QUESTION + "filter=caseRequestId" + URLEncoder.encode(" eq " + caseRequestId , OmsbVehpcEquivalencyWebPortletKeys.UNICODE_TRANSFORMATION_FORMAT);
					String educationResponse = omsbCommonApi.getData(educationUrl);
					LOGGER.info("educationResponse::"+educationResponse);
					EducationalDetail educations = CustomObjectMapperUtil.readValue(educationResponse, EducationalDetail.class);
					if(Validator.isNotNull(educations) && educations.getItems().size()>0) {
						for(EducationalDetailItem education : educations.getItems()) {
							long educationId = education.getId();
							String educationDocumentUrl = themeDisplay.getPortalURL()+LRObjectURL.DOCUMENT_INFO_URL.replace(DataflowConstants.SCOPE_ID_VAR, String.valueOf(themeDisplay.getScopeGroupId())) + StringPool.QUESTION + "filter=componentClassRefId" + URLEncoder.encode(" eq " + educationId , OmsbVehpcEquivalencyWebPortletKeys.UNICODE_TRANSFORMATION_FORMAT);
							String educationDocumentResponse = omsbCommonApi.getData(educationDocumentUrl);
							LOGGER.info("educationDocumentResponse:::333333333::::::::"+educationDocumentResponse);
							DocumentInfoItems educationDocuments = CustomObjectMapperUtil.readValue(educationDocumentResponse, DocumentInfoItems.class);
							
						}
					}
				}
				EquivalencyPassingData equivalencyPerson = addPersonDeatails(name, dateOfBirth, email, personId,dfrn);
				equivalencyList.add(equivalencyPerson);
				LOGGER.info("::::::passport::::::"+equivalencyList.get(0).getDob()+equivalencyList.get(0).getPersonName()+equivalencyList.get(0).getPersonId());
			}
		}
		LOGGER.info("equivalencyDtoList::::size::::::::::"+equivalencyList.size());
		request.setAttribute("equivalencyDtoList", equivalencyList);
	}

	private String generateScopeListURL(String equivalencyRequestsUrl, long siteId) {
		return omsbCommonApi.getBaseURL() + equivalencyRequestsUrl.replace(DataflowConstants.SCOPE_ID_VAR, String.valueOf(siteId));
	}
	
	public EquivalencyPassingData addPersonDeatails(String name, String dob, String email,long personId,String dfrn) {
		LOGGER.info("name::"+name+" , dob : "+dob+" , email : "+email+" , personId : "+personId);
		EquivalencyPassingData equivalencyDto = new EquivalencyPassingData();
		equivalencyDto.setPersonName(name);
		equivalencyDto.setPersonId(personId);
		equivalencyDto.setEmail(email);
		equivalencyDto.setDob(dob);
		equivalencyDto.setCaseNumber(dfrn);
		return equivalencyDto;
	}
	
	private EquivalencyDto fetchPersonDetailsByPersonId(long personId, ThemeDisplay themeDisplay) throws UnsupportedEncodingException {
		String personDetailsUrl = generateScopeListURL(LRObjectURL.GET_PERSONAL_DETAILS_BY_PERSONID_URL,themeDisplay.getScopeGroupId()) + StringPool.QUESTION + "filter=personId" + URLEncoder.encode(" eq " + personId  , OmsbVehpcEquivalencyWebPortletKeys.UNICODE_TRANSFORMATION_FORMAT);
		String personDetailsResponse = omsbCommonApi.getData(personDetailsUrl);
		return CustomObjectMapperUtil.readValue(personDetailsResponse, EquivalencyDto.class);
	}
	
	@Reference(unbind = "-")
	private OMSBHttpConnector omsbHttpConnector;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
	
	private static final Log LOGGER = LogFactoryUtil.getLog(EquivalencyPersonSearchMVCResourceCommand.class);
	
}