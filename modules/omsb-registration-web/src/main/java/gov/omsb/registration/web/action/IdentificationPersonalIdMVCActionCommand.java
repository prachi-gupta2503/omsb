package gov.omsb.registration.web.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.CountryLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.dto.CaseRequestItem;
import gov.omsb.common.dto.Person;
import gov.omsb.common.dto.PersonItem;
import gov.omsb.common.dto.PersonalDetailItem;
import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;
import gov.omsb.registration.web.util.RegistrationUtil;

@Component(immediate = true, 
			property = { 
					"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
					"mvc.command.name="+ MVCCommands.IDENTIFICATION_PERSONAL_ID_MVCACTION},
			service = MVCActionCommand.class)
public class IdentificationPersonalIdMVCActionCommand implements MVCActionCommand {
	
	public static final Log _log=LogFactoryUtil.getLog(IdentificationPersonalIdMVCActionCommand.class);
	
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Date dob=ParamUtil.getDate(actionRequest, "dob", new SimpleDateFormat(DataflowConstants.DATE_FORMAT_NEW));
		
		String passportNo=ParamUtil.getString(actionRequest, "passportno");
		String dfrn=ParamUtil.getString(actionRequest, "dfrn");
        boolean isActiveUser=false;
		boolean isPersonExist=false;
		boolean isPassportTab=false;
		boolean isDFRNExist=false;
		boolean isDFRNTab=false;
		_log.debug("passport ::" + passportNo + ":: Dob :::" + dob);
		
		String dobValue = new SimpleDateFormat(DataflowConstants.DATE_FORMAT).format(dob);
		_log.debug("dobValue ::::"+dobValue);
		
		PersonItem personItem=null;
		Person person=null;
		//PersonalDetailItem personDetailItem=null;
		//PersonalDetail personalDetail=null;
		CaseRequestItem caseRequestItem=null;
		
		if(Validator.isNotNull(passportNo)) {
			isPassportTab=true;
			try {
				personItem=registrationUtil.fetchPersonByPassportAndDob(themeDisplay,passportNo,dobValue);
				if(Validator.isNotNull(personItem) && personItem.getItems().size()>0) {
					if(Validator.isNotNull(personItem.getItems().get(0).getLrUserId()) && personItem.getItems().get(0).getLrUserId()>0) {
						User user=null;
						try {
							user = UserLocalServiceUtil.getUser(personItem.getItems().get(0).getLrUserId());
							actionResponse.getRenderParameters().setValue("lrUserId", String.valueOf(user.getUserId()));
							isActiveUser=user.isActive();
						} catch (PortalException e) {
							_log.error("unable to get the user having user id "+personItem.getItems().get(0).getLrUserId()+" :::: "+e.getCause());
						}
					}
					
					actionResponse.getRenderParameters().setValue("personId", String.valueOf(personItem.getItems().get(0).getId()));
					_log.debug("person size ::" +personItem.getItems().size());
					person=personItem.getItems().get(0);
					PersonalDetailItem  personDetailItem = registrationUtil.fetchPersonalDetailsByPersonId(person.getId(), themeDisplay);
					
					_log.debug("CountryCode ::::"+personDetailItem.getItems().get(0).getCountryCode());
					_log.debug("NationalityCntyId ::::"+personDetailItem.getItems().get(0).getNationalityCountryId());
					
					if (Validator.isNull(personDetailItem.getItems().get(0).getCountryCode()) && Validator.isNotNull(personDetailItem.getItems().get(0).getNationalityCountryId()) && personDetailItem.getItems().get(0).getNationalityCountryId() >0) {
						
						try {
							if (Validator.isNotNull(CountryLocalServiceUtil.getCountry(personDetailItem.getItems().get(0).getNationalityCountryId()))) {								
								personDetailItem.getItems().get(0).setCountryCode(CountryLocalServiceUtil.getCountry(personDetailItem.getItems().get(0).getNationalityCountryId()).getIdd());
								personDetailItem.getItems().get(0).setCountryIsoCode(CountryLocalServiceUtil.getCountry(personDetailItem.getItems().get(0).getNationalityCountryId()).getA2());
								registrationUtil.savePersonalDetailData(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), personDetailItem.getItems().get(0));
							}
						}catch(PortalException e){
							_log.error("Error in code >>>>>>>>>>>>" +e.getMessage());
						}
					}
					
					if(Validator.isNotNull(personDetailItem) && personDetailItem.getItems().size()>0) {
						actionRequest.setAttribute("personalDetail", personDetailItem.getItems().get(0));
						_log.info("Email Address ::::::::::"+personDetailItem.getItems().get(0).getEmail());
					}
					isPersonExist=true;	
				}
			} catch (UnsupportedEncodingException e) {
				_log.error("Error in code ::"+e.getMessage());
			}
		}else if(Validator.isNotNull(dfrn)){
			isDFRNTab=true;
			try {
				caseRequestItem=registrationUtil.fetchCaseRequestByCRN(themeDisplay, dfrn, dobValue);
				if(Validator.isNotNull(caseRequestItem) && caseRequestItem.getItems().size()>0) {
					_log.info("personDetails ::" +caseRequestItem.getItems().size());
					_log.info("person Id in case request table ::" +caseRequestItem.getItems().get(0).getPersonId());
					person=registrationUtil.fetchPersonByPersonId(themeDisplay,caseRequestItem.getItems().get(0).getPersonId());
					_log.info("person ::" +person.getCivilId());
					if(Validator.isNotNull(person)) {
						_log.info("inside if condtion :"+person);
						if(Validator.isNotNull(person.getLrUserId()) && person.getLrUserId()>0) {
							User user=null;
							try {
								user = UserLocalServiceUtil.getUser(person.getLrUserId());
								_log.info("user ::: "+user);
								isActiveUser=user.isActive();
								_log.info("isActiveUser ::: "+isActiveUser);
							} catch (PortalException e) {
								_log.error("unable to get the user having user id "+person.getLrUserId()+" :::: "+e.getCause());
							}
						      
						}
						PersonalDetailItem personDetailItem =registrationUtil.fetchPersonalDetailsByPersonId(person.getId(), themeDisplay);
						if(Validator.isNotNull(personDetailItem) && personDetailItem.getItems().size()>0) {
							_log.info("personDetailItem:"+personDetailItem.getItems().get(0).getId());
							actionRequest.setAttribute("personalDetail", personDetailItem.getItems().get(0));
							isPersonExist=true;
							isDFRNExist=true;
							_log.info("DFRN Success ::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
						}
						
						if (Validator.isNull(personDetailItem.getItems().get(0).getCountryCode()) && Validator.isNotNull(personDetailItem.getItems().get(0).getNationalityCountryId()) && personDetailItem.getItems().get(0).getNationalityCountryId() >0) {
							try {
								if (Validator.isNotNull(CountryLocalServiceUtil.getCountry(personDetailItem.getItems().get(0).getNationalityCountryId()))) {
									_log.info("Idd >>>>>>>>>>>>>>>"+CountryLocalServiceUtil.getCountry(personDetailItem.getItems().get(0).getNationalityCountryId()).getIdd());
									_log.info("A2 >>>>>>>>>>>>>>"+CountryLocalServiceUtil.getCountry(personDetailItem.getItems().get(0).getNationalityCountryId()).getA2());
									personDetailItem.getItems().get(0).setCountryCode(CountryLocalServiceUtil.getCountry(personDetailItem.getItems().get(0).getNationalityCountryId()).getIdd());
									personDetailItem.getItems().get(0).setCountryIsoCode(CountryLocalServiceUtil.getCountry(personDetailItem.getItems().get(0).getNationalityCountryId()).getA2());
									registrationUtil.savePersonalDetailData(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), personDetailItem.getItems().get(0));
									_log.info("personDetailItem cc pass:"+personDetailItem.getItems().get(0).getCountryCode());
									_log.info("personDetailItem cic pass:"+personDetailItem.getItems().get(0).getCountryIsoCode());
								}
							}catch(PortalException e){
								_log.error("Error in code >>>>>>>>>>>>" +e.getMessage());
							}
						}
						
						
					}
				}
			} catch (UnsupportedEncodingException e) {
				_log.error("Error in code ::"+e.getMessage());
			}catch (Exception e) {
				_log.error("Error in code ::"+e.getMessage());
			}
		} 
		_log.info("isPersonExist ::::" +isPersonExist);
		_log.info("!isActiveUser ::::" +!isActiveUser);
		
		if(!isActiveUser && isPersonExist) {
			_log.info("personId ::::" +person.getId());
			actionResponse.getRenderParameters().setValue("mvcRenderCommandName",MVCCommands.VIEW_REGISTRATION_PERSONAL_DETAILS);
			//actionRequest.setAttribute("person",person);
			actionRequest.setAttribute("personId",person.getId());
		} else if(isActiveUser && isPersonExist) {
			  actionResponse.getRenderParameters().setValue("isAlreadyExist", "true");
	    	  actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommands.VIEW_REGISTRATION_THANK_YOU);
		} else {
			if(	!isPassportTab && isDFRNTab && !isDFRNExist) {
				SessionErrors.add(actionRequest, "dfrn-message-error");
			}else {				
				DateFormat sdf=new SimpleDateFormat(DataflowConstants.DATE_FORMAT_NEW);
				actionResponse.getRenderParameters().setValue("passportNumber", passportNo);
	            actionResponse.getRenderParameters().setValue("dateOfBirth", sdf.format(dob));
	            actionResponse.getRenderParameters().setValue("dfrn", dfrn);
			  	actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommands.VIEW_IDENTIFICATION_CONFIRMATION);
			}
		}
		return false;
	}
	
	@Reference(unbind = "_")
	private RegistrationUtil registrationUtil;
}