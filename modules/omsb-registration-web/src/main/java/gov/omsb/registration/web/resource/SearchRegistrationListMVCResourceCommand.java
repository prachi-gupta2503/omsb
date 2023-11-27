package gov.omsb.registration.web.resource;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.text.ParseException;
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
import gov.omsb.common.dto.Person;
import gov.omsb.common.dto.PersonItem;
import gov.omsb.common.dto.PersonItemsResponse;
import gov.omsb.common.dto.PersonalDetail;
import gov.omsb.common.dto.PersonalDetailItem;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;
import gov.omsb.registration.web.dto.Registration;
import gov.omsb.registration.web.util.RegistrationUtil;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
		"mvc.command.name=" +MVCCommands.ADMIN_SEARCH_REGISTRATION }, service = MVCResourceCommand.class)
public class SearchRegistrationListMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {

		searchRegistrations(resourceRequest);

		PortletRequestDispatcher dispatcher = resourceRequest.getPortletSession().getPortletContext()
				.getRequestDispatcher(OmsbRegistrationWebPortletKeys.ADMIN_SEARCH_DATA_JSP);

		try {
			dispatcher.include(resourceRequest, resourceResponse);
		} catch (PortletException | IOException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	private void searchRegistrations(ResourceRequest resourceRequest) {

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String name = ParamUtil.getString(resourceRequest, "name");
		String civilId = ParamUtil.getString(resourceRequest, "civilId");
		String passportNumber = ParamUtil.getString(resourceRequest, "passportNumber");
		String dateOfBirth = ParamUtil.getString(resourceRequest, "dateOfBirth");
		
		List<Registration> registrationList = new ArrayList<>();
		
		String registrationDetailsURL = themeDisplay.getPortalURL()
				+ LRObjectURL.PERSON_URL.replace(DataflowConstants.SCOPE_ID_VAR,
						String.valueOf(themeDisplay.getScopeGroupId()))
				+ StringPool.QUESTION + MVCCommands.URL_SORT_DESCENDENDING_WITH_FILTER;

		if (Validator.isNotNull(name)) {
			registrationDetailsURL = updateRegistrationURLWithNameFilter(name,registrationDetailsURL,
					themeDisplay, resourceRequest);
		}
		if (Validator.isNotNull(civilId)) {
			registrationDetailsURL = updateRegistrationURLWithCivilIdFilter(civilId,registrationDetailsURL,
					themeDisplay, resourceRequest);
		}
		if (Validator.isNotNull(passportNumber)) {
			registrationDetailsURL = updateRegistrationURLWithPassportNumberFilter(passportNumber,registrationDetailsURL,
					themeDisplay, resourceRequest);
		}
		if (Validator.isNotNull(dateOfBirth)) {
			registrationDetailsURL = updateRegistrationURLWithDateOfBirthFilter(dateOfBirth,registrationDetailsURL,
					themeDisplay, resourceRequest);
		}
		
		if (registrationDetailsURL.lastIndexOf("+and+") > 0) {
			registrationDetailsURL = registrationDetailsURL.substring(0, registrationDetailsURL.lastIndexOf("+and+"));
		}
		
		registrationDetailsURL = registrationDetailsURL+"&pageSize=0";

		String registrationDetailsURLResponse = omsbCommonApi.getData(registrationDetailsURL);
		PersonItem personItem = CustomObjectMapperUtil.readValue(registrationDetailsURLResponse,PersonItemsResponse.class);
			
		if (Validator.isNotNull(personItem) && Validator.isNotNull(personItem.getItems()) && personItem.getItems().size()>0) {
			for (Person person : personItem.getItems()) {
				Registration registration = new Registration();
				PersonalDetailItem personalDetailItem = registrationUtil.getPersonalDetailsItems(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), person.getId(), null);
				
				if (Validator.isNotNull(personalDetailItem) && personalDetailItem.getItems().size()>0) {
					registration.setRegistrationStatus(Validator.isNotNull(personalDetailItem.getItems().get(0).getRegistrationStatus())?personalDetailItem.getItems().get(0).getRegistrationStatus():OmsbRegistrationWebPortletKeys.NOT_STARTED );
					registration.setRegistrationStatusColor(registrationUtil.getRegistrationStatusColor(Validator.isNotNull(personalDetailItem.getItems().get(0).getRegistrationStatus())?personalDetailItem.getItems().get(0).getRegistrationStatus():OmsbRegistrationWebPortletKeys.NOT_STARTED));
				} else {								
					registration.setRegistrationStatus(OmsbRegistrationWebPortletKeys.NOT_STARTED);
					registration.setRegistrationStatusColor(registrationUtil.getRegistrationStatusColor(OmsbRegistrationWebPortletKeys.NOT_STARTED));
				}
				
				try {
					User user = UserLocalServiceUtil.getUser(person.getLrUserId());
					if(Validator.isNotNull(user.getUserId()) && user.getUserId() > 0) {
						registration.setPersonName(user.getFirstName()+" "+ user.getLastName());
					}
				} catch (PortalException e) {
					LOGGER.error(e.getMessage(), e);
				}
				
				registration.setDateCreated(Validator.isNotNull(person.getDateCreated())? omsbCommonApi.convertObjectDateToNewDDMMYYYYDate(person.getDateCreated()):null);
				if (Validator.isNotNull(person.getCivilId())) {
					registration.setCivilId(person.getCivilId());
				}
				if (Validator.isNotNull(person.getPassportNumber())) {
					registration.setPassportNo(person.getPassportNumber());
				}
				registration.setPersonId(person.getId());
				registrationList.add(registration);
			}
		}
		resourceRequest.setAttribute("registrationList", registrationList);
	}

	private String updateRegistrationURLWithCivilIdFilter(String civilId, String registrationDetailsURL,
			ThemeDisplay themeDisplay, ResourceRequest resourceRequest) {
		registrationDetailsURL = registrationDetailsURL+"civilId+eq+"+StringPool.APOSTROPHE + civilId + StringPool.APOSTROPHE+ "+and+";
		return registrationDetailsURL;
	}
	
	private String updateRegistrationURLWithPassportNumberFilter(String passportNumber,
			String registrationDetailsURL, ThemeDisplay themeDisplay, ResourceRequest resourceRequest) {
		registrationDetailsURL = registrationDetailsURL+"passportNumber+eq+"+StringPool.APOSTROPHE + passportNumber + StringPool.APOSTROPHE+ "+and+";
		return registrationDetailsURL;
	}

	private String updateRegistrationURLWithDateOfBirthFilter(String dateOfBirth, String registrationDetailsURL,
			ThemeDisplay themeDisplay, ResourceRequest resourceRequest) {
		try {
			String convertedDateOfBirth = registrationUtil.convertDateOfBirth(dateOfBirth);
			registrationDetailsURL = registrationDetailsURL+"dateOfBirth+eq+"+ convertedDateOfBirth +"+and+";
		} catch (ParseException e) {
			LOGGER.error(e.getMessage());
		}	
		return registrationDetailsURL;
	}

	private String updateRegistrationURLWithNameFilter(String name, String registrationDetailsURL,
			ThemeDisplay themeDisplay, ResourceRequest resourceRequest) {
		
		String personalDetailsURL = themeDisplay.getPortalURL()
				+ LRObjectURL.PERSONAL_DETAIL_URL.replace(DataflowConstants.SCOPE_ID_VAR,
						String.valueOf(themeDisplay.getScopeGroupId()))
				+ StringPool.QUESTION + MVCCommands.URL_SORT_DESCENDENDING_WITH_FILTER +"givenNameAsPassport+eq+" +StringPool.APOSTROPHE+name+StringPool.APOSTROPHE;
		String personalDetailsURLResponse = omsbCommonApi.getData(personalDetailsURL);
		PersonalDetailItem pesonalDetailsRegistrationItems = CustomObjectMapperUtil.readValue(personalDetailsURLResponse,PersonalDetailItem.class);
		if (Validator.isNotNull(pesonalDetailsRegistrationItems) && Validator.isNotNull(pesonalDetailsRegistrationItems.getItems())
				&& !(pesonalDetailsRegistrationItems.getItems().isEmpty())) {
			boolean isFirstUser = true;
			for(PersonalDetail personaldetails : pesonalDetailsRegistrationItems.getItems()) {
				if (isFirstUser) {
					registrationDetailsURL = registrationDetailsURL + StringPool.OPEN_PARENTHESIS;
					isFirstUser = false;
				}
				registrationDetailsURL = registrationDetailsURL + "id+eq+" +StringPool.APOSTROPHE+ personaldetails.getPersonId()+StringPool.APOSTROPHE+ "+or+";
			}
		}
		if (registrationDetailsURL.lastIndexOf("+or+") > 0) {
			registrationDetailsURL = registrationDetailsURL.substring(0, registrationDetailsURL.lastIndexOf("+or+"));
		}

		registrationDetailsURL = registrationDetailsURL + StringPool.CLOSE_PARENTHESIS+"+and+";

		return registrationDetailsURL;
	}

	@Reference(unbind = "_")
	private OMSBCommonApi omsbCommonApi;

	@Reference(unbind = "_")
	private RegistrationUtil registrationUtil;

	private static final Log LOGGER = LogFactoryUtil.getLog(SearchRegistrationListMVCResourceCommand.class);

}
