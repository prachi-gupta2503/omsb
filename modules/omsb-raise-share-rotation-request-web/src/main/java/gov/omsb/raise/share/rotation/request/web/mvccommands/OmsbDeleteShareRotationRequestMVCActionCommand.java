package gov.omsb.raise.share.rotation.request.web.mvccommands;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.raise.share.rotation.request.web.constants.OmsbRaiseShareRotationRequestWebPortletKeys;
import gov.omsb.tms.service.SharedRotationRequestDetailsLocalService;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbRaiseShareRotationRequestWebPortletKeys.OMSBRAISESHAREROTATIONREQUESTWEB,
		"mvc.command.name="
				+ OmsbRaiseShareRotationRequestWebPortletKeys.DELETE_RAISE_SHARE_ROTATION_REQUEST_MVC_ACTION_COMMAND }, service = MVCActionCommand.class)
public class OmsbDeleteShareRotationRequestMVCActionCommand extends BaseMVCActionCommand {

	@Override
	public void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse)throws PortletException {
		_logger.info("ProcessAction Invoked ::: ");
		// getting share rotation request id
		long sharedRotationRequestId = ParamUtil.getLong(actionRequest, "sharedRotationRequestId");
		try {
			// delete share rotation request
			sharedRotationRequestDetailsLocalService.deleteSharedRotationRequestDetails(sharedRotationRequestId);
			setSucessesMessage(actionRequest, "raise-request-deleted-successfully");
			_logger.debug("ProcessAction ::: Raised Share Rotation Request Record Deleted");
		} catch (PortalException e) {
			_logger.error(e);
			setErrorMessage(actionRequest, e.getLocalizedMessage());
		}
		_logger.info("ProcessAction Exit ::: ");
	}
	
	private void setErrorMessage(ActionRequest actionRequest, String message) {
		SessionErrors.add(actionRequest, message);
		hideDefaultErrorMessage(actionRequest);
	}

	private void setSucessesMessage(ActionRequest actionRequest, String message) {
		SessionMessages.add(actionRequest, message);
	}
	
	private static final Log _logger=LogFactoryUtil.getLog(OmsbDeleteShareRotationRequestMVCActionCommand.class);

	@Reference
	private SharedRotationRequestDetailsLocalService sharedRotationRequestDetailsLocalService;

}
