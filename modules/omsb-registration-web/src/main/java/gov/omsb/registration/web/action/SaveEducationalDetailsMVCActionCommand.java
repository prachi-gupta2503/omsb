package gov.omsb.registration.web.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.registration.web.constants.MVCCommands;
import gov.omsb.registration.web.constants.OmsbRegistrationWebPortletKeys;
import gov.omsb.registration.web.util.RegistrationUtil;

@Component(immediate = true, 
			property = { 
					"javax.portlet.name=" + OmsbRegistrationWebPortletKeys.OMSBREGISTRATIONWEB,
					"mvc.command.name="+ MVCCommands.EDUCATION_DETAILS_MVCACTION},
			service = MVCActionCommand.class)
public class SaveEducationalDetailsMVCActionCommand implements MVCActionCommand {
	
	public static final Log _log=LogFactoryUtil.getLog(SaveEducationalDetailsMVCActionCommand.class);
	
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		//registrationUtil.saveEducation(actionRequest);
		
		actionResponse.getRenderParameters().setValue("lrUserId", ParamUtil.getString(actionRequest, "lrUserId"));
		actionResponse.getRenderParameters().setValue("personId", ParamUtil.getString(actionRequest, "personId"));
		boolean isNext = ParamUtil.getBoolean(actionRequest, "isNext");
		if(isNext) {
		  	actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommands.VIEW_REGISTRATION_WORK_DETAILS);
		} else {
		  	actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommands.VIEW_REGISTRATION_EDUCATION_DETAILS);
		}
	//	SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	//	SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
		 SessionMessages.add(actionRequest,"success-education-detail");
		return false;
	}
	
	@Reference(unbind = "_")
	private RegistrationUtil registrationUtil;
}