package gov.omsb.registration.web.resource;

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

import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;
import gov.omsb.registration.web.dto.UserRegistrationStatus;
import gov.omsb.registration.web.dto.UserRegistrationStatusItems;
import gov.omsb.registration.web.portlet.OmsbRegistrationWebPortlet;
import gov.omsb.registration.web.util.RegistrationUtil;

@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
	        "mvc.command.name="+MVCCommands.DELETE_REGISTRATION_ROLE_SERVICE_SR
	    }, 
	    service = MVCResourceCommand.class
)
public class DeleteRoleServiceMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		_log.info("DeleteRoleServiceMVCResourceCommand Invoked");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long id = ParamUtil.getLong(resourceRequest, "id");
		
		try {
			registrationUtil.deleteUserMetaData(themeDisplay, id);
		} catch (Exception e) {
			_log.error("Exception ::" +e.getMessage());
		}
		
		
		//Delete Role Status
		UserRegistrationStatusItems userRegistrationStatusItems=	registrationUtil.getRoleStatusByUserMetaDataId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), id);
		
		try {
			_log.info("userRegistrationStatus :::::>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.."+userRegistrationStatusItems.getItems().size());
			_log.info("userRegistrationStatus :::::>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.."+userRegistrationStatusItems.getItems().get(0));
			
			if(Validator.isNotNull(userRegistrationStatusItems) && Validator.isNotNull(userRegistrationStatusItems.getItems()) && userRegistrationStatusItems.getItems().size()>0) {
				UserRegistrationStatus userRegistrationStatus=	userRegistrationStatusItems.getItems().get(0);
				if(Validator.isNotNull(userRegistrationStatus)) {
					_log.info("inside delete role statuss :::");
					registrationUtil.deleteRoleStatus(themeDisplay, userRegistrationStatus.getId());
				}
			}
		} catch (Exception e) {
			_log.error("Exception in code :::" +e.getMessage());
		}
		
		
		
		registrationUtil.setRoleService(resourceRequest, resourceResponse);
		return Boolean.FALSE;
	}
		
	@Reference(unbind="-")
	private RegistrationUtil registrationUtil;
	
	private static final Log _log = LogFactoryUtil.getLog(OmsbRegistrationWebPortlet.class);
}
