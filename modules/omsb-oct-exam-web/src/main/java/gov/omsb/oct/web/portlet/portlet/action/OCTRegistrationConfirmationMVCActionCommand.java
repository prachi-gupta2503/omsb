package gov.omsb.oct.web.portlet.portlet.action;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.UserNotificationEventLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OCTExamConstants;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamDefinition;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamPayment;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamSchedule;
import gov.omsb.oct.exam.web.portlet.dto.OCTRegistration;
import gov.omsb.oct.exam.web.portlet.dto.OCTRegistrationItem;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;
import gov.omsb.oct.exam.web.portlet.util.OCTNotificationUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name=" + MVCCommandNames.REGISTRATION_CONFIRM_ACTION }, service = MVCActionCommand.class)

public class OCTRegistrationConfirmationMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {

		logger.info("OCTRegistrationConfirmationMVCActionCommand acrion command started");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long lrUserId = ParamUtil.getLong(actionRequest, "lrUserId");
		if (lrUserId <= 0) {
			lrUserId = themeDisplay.getUserId();
		}
		long oCExamScheduleId = ParamUtil.getLong(actionRequest, "oCExamScheduleId");
		OCTExamPayment octExamPayment = null;
		OCTRegistrationItem octRestrationItem=null;
		OCTExamSchedule octExamSchedule=null;
		try {
			octExamSchedule = octExamUtil.getOCTExamScheduleById(oCExamScheduleId, themeDisplay.getPortalURL());
			if(Validator.isNotNull(octExamSchedule)) {
				OCTExamDefinition octExamDefinition = octExamUtil.getOCTExamDefinitionByDefinitionId(
						octExamSchedule.getOctExamDefinitionId(), themeDisplay.getPortalURL());
				if (Validator.isNotNull(octExamDefinition)) {
					long oCExamTitleId = octExamDefinition.getoCExamTitleId();
					if (oCExamTitleId > 0) {
						String examtitle = omsbCommonApi.getListTypeEntryNameBylistTypeEntryId(oCExamTitleId,
								themeDisplay.getLocale());
						octExamSchedule.setOctExamTitleName(examtitle);
				}
			 }	
			 octRestrationItem = octExamUtil.getRegistrationByUserIdAndScheduleId(themeDisplay,
					lrUserId, oCExamScheduleId);
			if (Validator.isNotNull(octRestrationItem) && Validator.isNotNull(octRestrationItem.getItems()) && !octRestrationItem.getItems().isEmpty()) {
				octExamPayment = octExamUtil.getExamPaymentDetailByRegistrationId(themeDisplay.getPortalURL(),
						themeDisplay.getScopeGroupId(), octRestrationItem.getItems().get(0).getId());
				if (Validator.isNotNull(octExamPayment)) {
					octExamPayment.setPaymentStatus("paid");
					octExamUtil.updateOCTExamPayment(octExamPayment, themeDisplay.getPortalURL(),themeDisplay.getScopeGroupId());
					UpdateRegistration(octExamSchedule, lrUserId, themeDisplay, actionRequest, octExamPayment);
					octNotificationUtil.SendRegistrationSuccessNotification(themeDisplay, lrUserId, octExamSchedule);
				
				}else{
					OCTRegistration octRegistration = octRestrationItem.getItems().get(0);
					if(Validator.isNotNull(octRegistration)) {
						omsbCommonApi.deleteObjectEntryEntryId(octRegistration.getId());
					}
					octNotificationUtil.SendRegistrationFailedNotification(themeDisplay, lrUserId,octExamSchedule);
				
				}
			}
		 }
				
		} catch (Exception e) {
			logger.info(e.getMessage());
			OCTRegistration octRegistration = octRestrationItem.getItems().get(0);
			if(Validator.isNotNull(octRegistration)) {
				omsbCommonApi.deleteObjectEntryEntryId(octRegistration.getId());
			}
			octNotificationUtil.SendRegistrationFailedNotification(themeDisplay, lrUserId,octExamSchedule);
			return false;

		}

		return true;
	}
	
	private void UpdateRegistration(OCTExamSchedule octExamSchedule, long lrUserId, ThemeDisplay themeDisplay,
			ActionRequest actionRequest, OCTExamPayment octExamPayment) {
		try {
			DLFileEntry paymentReciept = null;
			String htmlReciept = octNotificationUtil.getPaymentRecieptContent(themeDisplay, lrUserId,
					OCTExamConstants.OCT_PAYMENT_RECEIPT_TEMPLATE, octExamSchedule, octExamPayment);
			if (Validator.isNotNull(htmlReciept)) {
				paymentReciept = octExamUtil.generatePaymentReceipt(actionRequest, htmlReciept, lrUserId);
			}
			long paymentRecieptId = 0;
			if (Validator.isNotNull(paymentReciept)) {
				paymentRecieptId = paymentReciept.getFileEntryId();
			}
			OCTRegistrationItem octRestrationItem = octExamUtil.getRegistrationByUserIdAndScheduleId(themeDisplay,
					lrUserId, octExamSchedule.getId());
			if (Validator.isNotNull(octRestrationItem) && Validator.isNotNull(octRestrationItem.getItems()) && !octRestrationItem.getItems().isEmpty()) {
				Map<String, Serializable> registrationMap = new HashMap<>();
				int noOfAttempt = octExamUtil.getNoOfAttempts(themeDisplay, lrUserId, octExamSchedule.getId());
				registrationMap.put("regStatus", OCTExamConstants.REGISTERED_STATUS_KEY);
				registrationMap.put("paymentReceiptFileEntryId", paymentRecieptId);
				registrationMap.put("noOfAttempts", ++noOfAttempt);
				omsbCommonApi.updateObjectEntryByERC(OmsbOctExamWebPortletKeys.OB_OC_EXAM_REGISTRATION_ERC,
						registrationMap, actionRequest, themeDisplay, octRestrationItem.getItems().get(0).getId());
			}

		} catch (Exception e) {
			logger.error("Error in Processing Registration Confirmation" + e);
		}
	}

	@Reference
	private OCTExamUtil octExamUtil;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference
	UserNotificationEventLocalService userNotificationEventLocalService;

	@Reference(unbind = "-")
	private OCTNotificationUtil octNotificationUtil;

	private static final Log logger = LogFactoryUtil.getLog(OCTRegistrationConfirmationMVCActionCommand.class);

}
