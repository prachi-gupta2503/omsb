package gov.omsb.raise.share.rotation.request.web.mvccommands;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.util.CommonUtil;
import gov.omsb.raise.share.rotation.request.web.constants.OmsbRaiseShareRotationRequestWebPortletKeys;
import gov.omsb.raise.share.rotation.request.web.util.OmsbRaiseShareRotationRequestUtil;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.model.SharedRotationRequestDetails;
import gov.omsb.tms.service.SharedRotationRequestDetailsLocalService;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbRaiseShareRotationRequestWebPortletKeys.OMSBRAISESHAREROTATIONREQUESTWEB,
		"mvc.command.name="
				+ OmsbRaiseShareRotationRequestWebPortletKeys.SAVE_RAISE_SHARE_ROTATION_REQUEST_MVC_ACTION_COMMAND }, service = MVCActionCommand.class)
public class OmsbSaveRaiseShareRotationRequestMVCActionCommand extends BaseMVCActionCommand {

	@Override
	public void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		_logger.debug("ProcessAction Invoked ::: ");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long sharedRotationRequestId = ParamUtil.getLong(actionRequest,
				OmsbRaiseShareRotationRequestWebPortletKeys.SHARE_ROTATION_REQUEST_ID, 0);
		boolean isRaisedAgain = ParamUtil.getBoolean(actionRequest, OmsbRaiseShareRotationRequestWebPortletKeys.IS_RAISED_AGAIN, Boolean.FALSE);
		try {
			if(isRaisedAgain) {
				long reSharedRotationRequestId = ParamUtil.getLong(actionRequest,
						OmsbRaiseShareRotationRequestWebPortletKeys.RE_SHARE_ROTATION_REQUEST_ID, 0); 
				createParticipationTypeMasterForRaisedAgain(actionRequest, reSharedRotationRequestId, themeDisplay);
			} else {
				if (sharedRotationRequestId != 0) {
					// Update Participation Type Master
					updateParticipationTypeMaster(actionRequest, sharedRotationRequestId, themeDisplay);
				} else {
					// Create Participation Type Master
					createParticipationTypeMaster(actionRequest, themeDisplay);
				}
			}
		} catch (PortalException e) {
			_logger.error(e);
		}
		_logger.debug("ProcessAction Exit ::: ");
	}

	/**
	 * 
	 * @param actionRequest
	 * @param sharedRotationRequestDetailId
	 * @param themeDisplay
	 * @return
	 * @throws PortalException
	 */
	private boolean updateParticipationTypeMaster(ActionRequest actionRequest, long sharedRotationRequestId,
			ThemeDisplay themeDisplay) throws PortalException {
		SharedRotationRequestDetails sharedRotationRequestDetail = sharedRotationRequestDetailsLocalService
				.getSharedRotationRequestDetails(sharedRotationRequestId);

		if (Validator.isNotNull(sharedRotationRequestDetail)) {
			sharedRotationRequestDetail = 
					omsbRaiseShareRotationRequestUtil.createSharedRotationRequestDetailsObject(actionRequest,
							sharedRotationRequestDetail, Boolean.FALSE, themeDisplay);
			sharedRotationRequestDetailsLocalService.updateSharedRotationRequestDetails(sharedRotationRequestDetail);
			
			Map<String, String> parameters = new HashMap<>();
			parameters.put(OmsbRaiseShareRotationRequestWebPortletKeys.SHOW_MODAL, Boolean.TRUE.toString());
			parameters.put(OmsbRaiseShareRotationRequestWebPortletKeys.SHARE_ROTATION_REQUEST_ID,String.valueOf(sharedRotationRequestId));
			String renderURL = CommonUtil.generateRenderURL(PortalUtil.getHttpServletRequest(actionRequest), themeDisplay.getScopeGroupId(), OmsbTmsCommonConstants.SHARED_ROTATION_APPROVE_PORTLET, parameters);

			omsbRaiseShareRotationRequestUtil.prepareMailMessage(sharedRotationRequestDetail, themeDisplay.getUser(), renderURL, themeDisplay.getLocale());
			omsbRaiseShareRotationRequestUtil.prepareNotificationMessage(sharedRotationRequestDetail, themeDisplay.getUser(), renderURL, themeDisplay.getLocale());
			setSucessesMessage(actionRequest, "raise-request-updated-successfully");
			_logger.debug("updateParticipationTypeMaster ::: SharedRotationRequestDetails Record Updated");
		} else {
			_logger.debug("updateParticipationTypeMaster ::: SharedRotationRequestDetails Record Not Found "
					+ sharedRotationRequestId);
			return false;
		}
		return true;

	}

	/**
	 * 
	 * @param actionRequest
	 * @param themeDisplay
	 * @return
	 */
	private boolean createParticipationTypeMaster(ActionRequest actionRequest, ThemeDisplay themeDisplay) {

		long sharedRotationRequestId = counterLocalService.increment(getClass().getName(), 1);
		try {
			SharedRotationRequestDetails sharedRotationRequestDetail = sharedRotationRequestDetailsLocalService
					.createSharedRotationRequestDetails(sharedRotationRequestId);
			sharedRotationRequestDetail = 
					omsbRaiseShareRotationRequestUtil.createSharedRotationRequestDetailsObject(actionRequest,
							sharedRotationRequestDetail, Boolean.TRUE, themeDisplay);
			sharedRotationRequestDetailsLocalService.addSharedRotationRequestDetails(sharedRotationRequestDetail);
			
			Map<String, String> parameters = new HashMap<>();
			parameters.put(OmsbRaiseShareRotationRequestWebPortletKeys.SHOW_MODAL, Boolean.TRUE.toString());
			parameters.put(OmsbRaiseShareRotationRequestWebPortletKeys.SHARE_ROTATION_REQUEST_ID,String.valueOf(sharedRotationRequestId));

			String renderURL = CommonUtil.generateRenderURL(PortalUtil.getHttpServletRequest(actionRequest), themeDisplay.getScopeGroupId(), OmsbTmsCommonConstants.SHARED_ROTATION_APPROVE_PORTLET, parameters);
			omsbRaiseShareRotationRequestUtil.prepareMailMessage(sharedRotationRequestDetail, themeDisplay.getUser(), renderURL, themeDisplay.getLocale());
			omsbRaiseShareRotationRequestUtil.prepareNotificationMessage(sharedRotationRequestDetail, themeDisplay.getUser(), renderURL, themeDisplay.getLocale());
			setSucessesMessage(actionRequest, "raise-request-added-successfully");
			_logger.debug("createParticipationTypeMaster ::: Participation Type Master Record Created");
		} catch (Exception e) {
			_logger.error(e);
			setErrorMessage(actionRequest, e.getLocalizedMessage());
			return false;
		}
		return true;
	}

	/**
	 * @param actionRequest
	 * @param reSharedRotationRequestId
	 * @param themeDisplay
	 * @return
	 */
	private boolean createParticipationTypeMasterForRaisedAgain(ActionRequest actionRequest, long reSharedRotationRequestId, ThemeDisplay themeDisplay) {
		try {
			SharedRotationRequestDetails reSharedRotationRequestDetail = sharedRotationRequestDetailsLocalService
					.getSharedRotationRequestDetails(reSharedRotationRequestId);
			long noOfTraineesRequested = ParamUtil.getLong(actionRequest,
					OmsbRaiseShareRotationRequestWebPortletKeys.RE_NO_OF_TRAINEES_REQUESTED, 0); 
			long sharedRotationRequestId = counterLocalService.increment(getClass().getName(), 1);
			SharedRotationRequestDetails sharedRotationRequestDetail = sharedRotationRequestDetailsLocalService
					.createSharedRotationRequestDetails(sharedRotationRequestId);
			sharedRotationRequestDetail = 
					omsbRaiseShareRotationRequestUtil.createSharedRotationRequestDetailsObject(actionRequest,
							sharedRotationRequestDetail, Boolean.TRUE, themeDisplay);
			sharedRotationRequestDetail.setNoOfTraineesRequested(noOfTraineesRequested);
			sharedRotationRequestDetail.setProgramDurationId(reSharedRotationRequestDetail.getProgramDurationId());
			sharedRotationRequestDetail.setRotationId(reSharedRotationRequestDetail.getRotationId());
			sharedRotationRequestDetail.setRequesterComment(reSharedRotationRequestDetail.getRequesterComment());
			
			sharedRotationRequestDetailsLocalService.addSharedRotationRequestDetails(sharedRotationRequestDetail);
			
			Map<String, String> parameters = new HashMap<>();
			parameters.put(OmsbRaiseShareRotationRequestWebPortletKeys.SHOW_MODAL, Boolean.TRUE.toString());
			parameters.put(OmsbRaiseShareRotationRequestWebPortletKeys.SHARE_ROTATION_REQUEST_ID,String.valueOf(sharedRotationRequestId));

			String renderURL = CommonUtil.generateRenderURL(PortalUtil.getHttpServletRequest(actionRequest), themeDisplay.getScopeGroupId(), OmsbTmsCommonConstants.SHARED_ROTATION_APPROVE_PORTLET, parameters);
			omsbRaiseShareRotationRequestUtil.prepareMailMessage(sharedRotationRequestDetail, themeDisplay.getUser(), renderURL, themeDisplay.getLocale());
			omsbRaiseShareRotationRequestUtil.prepareNotificationMessage(sharedRotationRequestDetail, themeDisplay.getUser(), renderURL, themeDisplay.getLocale());
			_logger.debug("reCreateParticipationTypeMaster ::: Participation Type Master Record Created");
			setSucessesMessage(actionRequest, "request-raised-again-successfully");
		} catch (PortalException e) {
			_logger.error(e);
			setErrorMessage(actionRequest, e.getLocalizedMessage());
			return false;
		}
		return true;
	}
	
	private void setErrorMessage(ActionRequest actionRequest, String message) {
		SessionErrors.add(actionRequest, message);
		hideDefaultErrorMessage(actionRequest);
	}

	private void setSucessesMessage(ActionRequest actionRequest, String message) {
		SessionMessages.add(actionRequest, message);
	}
	
	@Reference
	private OmsbRaiseShareRotationRequestUtil omsbRaiseShareRotationRequestUtil;

	@Reference
	private CounterLocalService counterLocalService;

	@Reference
	private SharedRotationRequestDetailsLocalService sharedRotationRequestDetailsLocalService;

	private static final Log _logger = LogFactoryUtil
			.getLog(OmsbSaveRaiseShareRotationRequestMVCActionCommand.class.getName());
}
