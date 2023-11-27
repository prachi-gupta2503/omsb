package gov.omsb.email.template.master.portlet.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.email.template.master.constants.EmailTemplateMasterPortletKeys;
import gov.omsb.email.template.master.portlet.util.EmailTemplateMasterUtil;
import gov.omsb.email.template.master.service.EmailTemplateMasterLocalService;

/**
 * The Class DeleteEmailTemplateMVCActionCommand.
 * 
 * @author Niddhi Thacker
 * 
 */
@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + EmailTemplateMasterPortletKeys.OMSB_EMAIL_TEMPLATE_MASTER_PORTLET,
	        "mvc.command.name=deleteEmailTemplate",
	    }, 
	    service = MVCActionCommand.class
)
public class DeleteEmailTemplateMVCActionCommand extends BaseMVCActionCommand {

	/** The Constant log. */
	private static final Log log = LogFactoryUtil.getLog(DeleteEmailTemplateMVCActionCommand.class);
	
	/* (non-Javadoc)
	 * @see com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand#doProcessAction(javax.portlet.ActionRequest, javax.portlet.ActionResponse)
	 */
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) {
		
		new EmailTemplateMasterUtil(getEmailTemplateMasterLocalService());
		
		boolean isEmailTemplateDeleted = false;
		try {
			isEmailTemplateDeleted = EmailTemplateMasterUtil.deleteEmailTemplate(actionRequest, actionResponse);
		} catch (SystemException | PortalException  e) {
			log.error("Error while deleting emailTemplate. Error message ::: " + e.getMessage());
		}
		
		if (isEmailTemplateDeleted) {
			log.info("EmailTemplate deleted successfully");
			SessionMessages.add(actionRequest, "email-template-category-delete-success");
		} else {
			log.error("Error while deleting emailTemplate");
			SessionErrors.add(actionRequest, "email-template-category-delete-error");
			hideDefaultErrorMessage(actionRequest);
			hideDefaultSuccessMessage(actionRequest);
		}
		
	}
	
	/** The emailTemplate master local service. */
	@Reference
	private volatile EmailTemplateMasterLocalService emailTemplateMasterLocalService;
	
	/**
	 * Gets the emailTemplate master local service.
	 *
	 * @return the emailTemplate master local service
	 */
	public EmailTemplateMasterLocalService getEmailTemplateMasterLocalService() {
		return emailTemplateMasterLocalService;
	}
}
