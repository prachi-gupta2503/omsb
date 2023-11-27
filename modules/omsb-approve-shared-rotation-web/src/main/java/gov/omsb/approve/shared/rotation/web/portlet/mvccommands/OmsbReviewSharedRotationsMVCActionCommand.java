package gov.omsb.approve.shared.rotation.web.portlet.mvccommands;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.approve.shared.rotation.web.constants.OmsbApproveSharedRotationWebPortletKeys;
import gov.omsb.approve.shared.rotation.web.portlet.util.OmsbApproveSharedRotationUtil;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.util.CommonUtil;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.model.SharedRotationApproverDetails;
import gov.omsb.tms.model.SharedRotationRequestDetails;
import gov.omsb.tms.service.SharedRotationApproverDetailsLocalService;
import gov.omsb.tms.service.SharedRotationRequestDetailsLocalService;

/**
 * @author Dhairya
 */

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbApproveSharedRotationWebPortletKeys.OMSBAPPROVESHAREDROTATIONWEB,
"mvc.command.name=" + OmsbApproveSharedRotationWebPortletKeys.RIVIEW_SHARED_ROTATIONS_MVC_ATION_COMMAND }, service = MVCActionCommand.class)
public class OmsbReviewSharedRotationsMVCActionCommand extends BaseMVCActionCommand {

	@Override
	public void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		_logger.debug("ProcessAction Invoked ::: ");

		long sharedRotationRequestId = ParamUtil.getLong(actionRequest, OmsbApproveSharedRotationWebPortletKeys.SHARED_ROTATION_ID);
		String status = ParamUtil.getString(actionRequest, OmsbApproveSharedRotationWebPortletKeys.STATUS);
		String comment = ParamUtil.getString(actionRequest, OmsbApproveSharedRotationWebPortletKeys.COMMENT);
		
		Calendar calendar = Calendar.getInstance();
		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		try {
			SharedRotationRequestDetails sharedRotationRequestDetails = sharedRotationRequestDetailsLocalService.getSharedRotationRequestDetails(sharedRotationRequestId);
			
			long sharedRotationApproverDetailsId = counterLocalService.increment(SharedRotationApproverDetails.class.getName(), -1);
			SharedRotationApproverDetails sharedRotationApproverDetails = sharedRotationApproverDetailsLocalService.createSharedRotationApproverDetails(sharedRotationApproverDetailsId);
			
			long requestedTrainees = sharedRotationRequestDetails.getNoOfTraineesRequested();
						
			if (CommonConstants.STATUS_ACCEPT.equalsIgnoreCase(status)) {
				long allowedTrainees = ParamUtil.getLong(actionRequest, OmsbApproveSharedRotationWebPortletKeys.ALLOWED_TRAINEES);
				sharedRotationRequestDetails.setStatus(requestedTrainees == allowedTrainees ? CommonConstants.STATUS_ACCEPT : CommonConstants.STATUS_ACCEPT_PARTIALLY);
				sharedRotationRequestDetails.setApprovedCount(allowedTrainees);
				sharedRotationRequestDetails.setRejectedCount(requestedTrainees-allowedTrainees);
				sharedRotationApproverDetails.setStatus(requestedTrainees == allowedTrainees ? CommonConstants.STATUS_ACCEPT : CommonConstants.STATUS_ACCEPT_PARTIALLY);
				sharedRotationApproverDetails.setApprovedTrainees(allowedTrainees);
				sharedRotationApproverDetails.setRejectedTrainees(requestedTrainees-allowedTrainees);
			} else if(OmsbApproveSharedRotationWebPortletKeys.STATUS_REJECT.equalsIgnoreCase(status)) {
				sharedRotationRequestDetails.setStatus(OmsbApproveSharedRotationWebPortletKeys.STATUS_REJECT);
				sharedRotationApproverDetails.setStatus(OmsbApproveSharedRotationWebPortletKeys.STATUS_REJECT);
				sharedRotationRequestDetails.setRejectedCount(requestedTrainees);
				sharedRotationApproverDetails.setRejectedTrainees(requestedTrainees);
			}
			sharedRotationApproverDetails.setSharedRotationRequestDetailsId(sharedRotationRequestDetails.getSharedRotationRequestDetailsId());
			sharedRotationApproverDetails.setGroupId(themeDisplay.getScopeGroupId());
			sharedRotationApproverDetails.setCompanyId(themeDisplay.getCompanyId());
			sharedRotationApproverDetails.setCreateDate(calendar.getTime());
			sharedRotationApproverDetails.setCreatedBy(themeDisplay.getUserId());
			sharedRotationApproverDetails.setModifiedDate(calendar.getTime());
			sharedRotationApproverDetails.setModifiedBy(themeDisplay.getUserId());
			sharedRotationApproverDetails.setApproversComment(comment);
			sharedRotationApproverDetails.setDecisionMakingDate(calendar.getTime());
			
			sharedRotationRequestDetails.setModifiedDate(calendar.getTime());
			sharedRotationRequestDetails.setModifiedBy(themeDisplay.getUserId());
			
			sharedRotationRequestDetailsLocalService.updateSharedRotationRequestDetails(sharedRotationRequestDetails);
			sharedRotationApproverDetailsLocalService.updateSharedRotationApproverDetails(sharedRotationApproverDetails);

			Map<String, String> parameters = new HashMap<>();
			parameters.put(OmsbApproveSharedRotationWebPortletKeys.SHOW_MODAL, Boolean.TRUE.toString());
			parameters.put(OmsbApproveSharedRotationWebPortletKeys.SHARED_ROTATION_ID,String.valueOf( sharedRotationRequestDetails.getSharedRotationRequestDetailsId()));
			String renderURL = CommonUtil.generateRenderURL(PortalUtil.getHttpServletRequest(actionRequest), themeDisplay.getScopeGroupId(), OmsbTmsCommonConstants.SHARED_ROTATION_REQUEST_PORTLET,parameters);
			
			omsbApproveSharedRotationUtil.prepareMailMessage(sharedRotationRequestDetails, themeDisplay.getUser(), renderURL, themeDisplay.getLocale());
			omsbApproveSharedRotationUtil.prepareNotificationMessage(sharedRotationRequestDetails, themeDisplay.getUser(), renderURL);
			String message = sharedRotationApproverDetails.getStatus().toLowerCase();
			if(sharedRotationApproverDetails.getStatus().equalsIgnoreCase("Approved & Partially Alloted")) {
				message = "approved-and-partially-alloted";
			}
			setSucessesMessage(actionRequest, "request-"+message+"-successfully");
		} catch (PortalException e) {
			_logger.error(e);
			setErrorMessage(actionRequest, e.getLocalizedMessage());
		}
		
		_logger.debug("ProcessAction Exit ::: ");
	}

	private void setErrorMessage(ActionRequest actionRequest, String message) {
		SessionErrors.add(actionRequest, message);
		hideDefaultErrorMessage(actionRequest);
	}

	private void setSucessesMessage(ActionRequest actionRequest, String message) {
		SessionMessages.add(actionRequest, message);
	}
	
	@Reference
	private OmsbApproveSharedRotationUtil omsbApproveSharedRotationUtil;
	
	@Reference
	private SharedRotationRequestDetailsLocalService sharedRotationRequestDetailsLocalService;

	@Reference
	private SharedRotationApproverDetailsLocalService sharedRotationApproverDetailsLocalService;
	
	@Reference
	private CounterLocalService counterLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbReviewSharedRotationsMVCActionCommand.class);
}
