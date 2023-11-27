package gov.omsb.registration.web.resource;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.util.DLURLHelperUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.dto.Person;
import gov.omsb.common.dto.PersonItem;
import gov.omsb.common.dto.PersonalDetailItem;
import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;
import gov.omsb.registration.web.util.RegistrationUtil;

@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
	        "mvc.command.name="+MVCCommands.VERIFY_CIVILID_PASSPORT
	    }, 
	    service = MVCResourceCommand.class
)
public class VerifyCivilAndPassportnoMVCResourceCommand implements MVCResourceCommand{

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String civilId=ParamUtil.getString(resourceRequest, "civilId");
		String dateOfBirth=ParamUtil.getString(resourceRequest, "dateOfBirth");
		String passportNumber=ParamUtil.getString(resourceRequest, "passportNumber");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		boolean isExist=false;
		String convertedDob = omsbCommonApi.convertDate(dateOfBirth, df, dateFormatter);
		JSONObject object =JSONFactoryUtil.createJSONObject();
		if((Validator.isNotNull(civilId) || Validator.isNotNull(passportNumber)) && Validator.isNotNull(dateOfBirth)) {
		PersonItem personItems = registrationUtil.getPersonItems(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), civilId, passportNumber, convertedDob);
		Person person=null;
	//	object.put("personId",StringPool.BLANK);
		if(Validator.isNotNull(personItems.getItems()) && !personItems.getItems().isEmpty() ) {
			person=personItems.getItems().get(0);
			if(person.getLrUserId()>0) {
			long userId=person.getLrUserId();
			
			if(Validator.isNotNull(userId))
			{
				try {
					User user=UserLocalServiceUtil.getUser(userId);
					if(user.isActive()) {
						isExist=user.isActive();
					}
					else if(!user.isActive()){
						LOGGER.info("inside else if");
						object.put("personId", person.getId());
					}
				} catch (PortalException e) {
					LOGGER.info("error to get the user "+e.getMessage());
				}
			}
			}
						
		}
		
		}
		
		object.put("isExist", isExist);
		
		try {
			resourceResponse.getWriter().print(object);
		} catch (IOException e) {
			LOGGER.error("Error ::, "+e.getMessage());
		}
		return isExist;
	}
	

	
	@Reference(unbind="-")
	private RegistrationUtil registrationUtil;
	
	@Reference(unbind = "_")
	private OMSBCommonApi omsbCommonApi;
	
	private static final Log LOGGER = LogFactoryUtil.getLog(VerifyCivilAndPassportnoMVCResourceCommand.class);
}
