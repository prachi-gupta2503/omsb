package gov.omsb.registration.web.resource;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.dto.EducationDetailItem;
import gov.omsb.common.dto.PersonalDetailItem;
import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;
import gov.omsb.registration.web.dto.EmploymentDetail;
import gov.omsb.registration.web.dto.EmploymentDetailItem;
import gov.omsb.registration.web.util.RegistrationUtil;

@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
	        "mvc.command.name="+MVCCommands.IS_EDUCATION_AND_EMPLOYMENT_DETAILS_SAVED_MVC_RESOURCE
	    }, 
	    service = MVCResourceCommand.class
	    
)
public class IsEducationAndEmploymentDetailsSavedMVCResourceCommand implements MVCResourceCommand {

	private static final Log _log = LogFactoryUtil.getLog(IsEducationAndEmploymentDetailsSavedMVCResourceCommand.class);
		
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		try {
			_log.info("IsEducationAndEmploymentDetailsSavedMVCResourceCommand Invoked");
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long personId=ParamUtil.getLong(resourceRequest, "personId");
			_log.info("personId : "+personId);
			long lrUserId=ParamUtil.getLong(resourceRequest, "lrUserId");
			_log.info("lrUserId : "+lrUserId);
			
			EducationDetailItem educationDetailItems = registrationUtil.getEducationDetailItems(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), personId);
			EmploymentDetailItem employmentDetailItem = registrationUtil.getEmploymentDetailItems(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), personId);
			
			PersonalDetailItem personalDetailItem = registrationUtil.fetchPersonalDetailsByPersonId(personId, themeDisplay);
			_log.info("agreed : "+personalDetailItem.getItems().get(0).isAgreed());
			_log.info("declared : "+personalDetailItem.getItems().get(0).isDeclaration());
			
			boolean isAgreed=false;
			boolean isDeclaration=false;
			
			
			if(Validator.isNotNull(personalDetailItem) && Validator.isNotNull(personalDetailItem.getItems()) && Validator.isNotNull(personalDetailItem.getItems().get(0))) {
				isAgreed=personalDetailItem.getItems().get(0).isAgreed();
				isDeclaration=personalDetailItem.getItems().get(0).isDeclaration();
			}
			JSONObject obj =JSONFactoryUtil.createJSONObject();
			obj.put("isEducationDetailsExist", Boolean.FALSE);
			if(educationDetailItems.getItems().size()>0) {				
				obj.put("isEducationDetailsExist", Boolean.TRUE);
			}
			
			obj.put("isEmploymentDetailsExist", Boolean.FALSE);
			if(employmentDetailItem.getItems().size()>0) {
				for(EmploymentDetail employmentDetail : employmentDetailItem.getItems()) {
					if(employmentDetail.getPrimaryWorkDetail().equals("1")) {
						obj.put("isEmploymentDetailsExist", Boolean.TRUE);
						break;
					}
				}
			}else if(isAgreed && isDeclaration ) {
				obj.put("isEmploymentDetailsExist", Boolean.TRUE);
			}
			
			resourceResponse.getWriter().print(obj.toJSONString());
			return Boolean.FALSE;
		} catch (Exception e) {	
			_log.error("Error ::"+e.getMessage());
			return Boolean.TRUE;
		}
	}
		
	@Reference(unbind="-")
	private RegistrationUtil registrationUtil;
	
	
}
