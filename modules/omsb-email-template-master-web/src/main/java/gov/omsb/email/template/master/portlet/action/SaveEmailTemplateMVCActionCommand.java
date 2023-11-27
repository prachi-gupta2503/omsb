package gov.omsb.email.template.master.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.email.template.master.common.api.OMSBEmailTemplateMasterCommonApi;
import gov.omsb.email.template.master.common.constants.OMSBEmailTemplateMasterCommonConstants;
import gov.omsb.email.template.master.constants.EmailTemplateMasterConstants;
import gov.omsb.email.template.master.constants.EmailTemplateMasterPortletKeys;
import gov.omsb.email.template.master.portlet.util.EmailTemplateMasterUtil;
import gov.omsb.email.template.master.service.EmailTemplateMasterLocalService;

/**
 * The Class SaveEmailTemplateMVCActionCommand.
 * 
 * @author Niddhi Thacker
 */
@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + EmailTemplateMasterPortletKeys.OMSB_EMAIL_TEMPLATE_MASTER_PORTLET,
	        "mvc.command.name=/save/emailTemplate",
	    }, 
	    service = MVCActionCommand.class
)
public class SaveEmailTemplateMVCActionCommand extends BaseMVCActionCommand {

	/** The Constant log. */
	private static final Log log = LogFactoryUtil.getLog(SaveEmailTemplateMVCActionCommand.class);

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException {

		new EmailTemplateMasterUtil(getEmailTemplateMasterLocalService());
		
		boolean isEmailTemplateSaved = false;
		long templateId = ParamUtil.getLong(actionRequest, EmailTemplateMasterConstants.TEMPLATE_IDX, 0);
		String redirect=ParamUtil.getString(actionRequest, EmailTemplateMasterConstants.REDIRECT_URL);
		
		try {
			isEmailTemplateSaved = EmailTemplateMasterUtil.saveEmailTemplate(actionRequest, actionResponse);
		} catch (SystemException | PortalException e) {
			log.error("Error while saving emailTemplate. Error message : " + e.getMessage());
		}
		
		if (isEmailTemplateSaved) {
			log.info("Email template saved successfully");
			String successMessageKey = templateId > 0 ? "email-template-update-success" : "email-template-create-success";
			SessionMessages.add(actionRequest, successMessageKey);
			actionResponse.sendRedirect(redirect);
		} else {
			String errorMessageKey = templateId > 0 ? "email-template-update-error" : "email-template-create-error";
			if(!isEmailTemplateSaved) {
				errorMessageKey = "email-template-exists-error-msg";
			} 
			SessionErrors.add(actionRequest, errorMessageKey);
			hideDefaultErrorMessage(actionRequest);
			hideDefaultSuccessMessage(actionRequest);
			actionResponse.setRenderParameter(OMSBEmailTemplateMasterCommonConstants.ACTION, OMSBEmailTemplateMasterCommonConstants.EDIT);
			actionResponse.setRenderParameter(EmailTemplateMasterConstants.TEMPLATE_IDX, String.valueOf(templateId));
		}
	}
	
	/** The emailTemplate master local service. */
	@Reference
	private volatile EmailTemplateMasterLocalService emailTemplateMasterLocalService;
	
	@Reference
	private OMSBEmailTemplateMasterCommonApi omsbEmailTemplateMasterCommonApi;
	/**
	 * Gets the emailTemplate master local service.
	 *
	 * @return the emailTemplate master local service
	 */
	public EmailTemplateMasterLocalService getEmailTemplateMasterLocalService() {
		return emailTemplateMasterLocalService;
	}
}
