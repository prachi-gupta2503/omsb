package gov.omsb.oct.web.portlet.portlet.action;

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
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamPayment;
import gov.omsb.oct.exam.web.portlet.dto.OCTRegistration;
import gov.omsb.oct.exam.web.portlet.dto.OCTRegistrationItem;
import gov.omsb.oct.exam.web.portlet.dto.PaymentRefundResponse;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name=" + MVCCommandNames.REGISTRATION_CANCEL_ACTION }, service = MVCActionCommand.class)

public class OCTRegistrationCancellationMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {

		logger.info("OCTRegistrationCancellationMVCActionCommand started");
		logger.info("OCTRegistrationConfirmationMVCActionCommand acrion command started");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long lrUserId = ParamUtil.getLong(actionRequest, "lrUserId");
		if (lrUserId <= 0) {
			lrUserId = themeDisplay.getUserId();
		}
		long oCExamScheduleId = ParamUtil.getLong(actionRequest, "octExamScheduleId");
		String trackingId = ParamUtil.getString(actionRequest, "trackingId");
		String refundRefNo = ParamUtil.getString(actionRequest, "refundRefNo");
		double cancellationFees = ParamUtil.getDouble(actionRequest, "cancellationFees");
		long registrationId = 0;

		try {
			if (cancellationFees > 0) {
				String refundUrl = "https://stage.omsb.gov.om/pki/bank-muscat/bank-muscat-refund-amount?refund_amount="

						+ cancellationFees + "&reference_no=" + trackingId + "&refund_ref_no=" + refundRefNo;

				String refundResponse = omsbHttpConnector.executePost(refundUrl, "", new HashMap<>());

				if (Validator.isNotNull(refundResponse)) {

					PaymentRefundResponse paymentRefundResponse = CustomObjectMapperUtil.readValue(refundResponse,

							PaymentRefundResponse.class);

					if (Validator.isNotNull(paymentRefundResponse.getErrorCode())

							|| !paymentRefundResponse.getErrorCode().isEmpty()) {

						throw new PortletException("Refund Failed : " + paymentRefundResponse.getReason());

					}

				}
			}
			OCTRegistrationItem octRestrationItem = octExamUtil.getRegistrationByUserIdAndScheduleId(themeDisplay,
					lrUserId, oCExamScheduleId);
			if (!octRestrationItem.getItems().isEmpty()) {
				OCTRegistration octRegistration = octRestrationItem.getItems().get(0);
				registrationId = octRegistration.getId();
			}
			OCTExamPayment octExamPayment = prepareOCTExamCancellationPayment(lrUserId, oCExamScheduleId,
					registrationId, cancellationFees, refundRefNo);

			octExamUtil.saveOCTExamPayment(octExamPayment, themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId());

			if (!octRestrationItem.getItems().isEmpty()) {
				Map<String, Serializable> registrationMap = new HashMap();
				ListTypeEntry listTypeEntryByListTypeItemKey = omsbCommonApi.getListTypeEntryByListTypeItemKey(
						LRPicklistConstants.OCT_EXAM_REG_STATUS, "cancelled", themeDisplay.getCompanyId());
				int noOfAttempt = noOfAttempts(themeDisplay, lrUserId, oCExamScheduleId);
				registrationMap.put("regStatus", listTypeEntryByListTypeItemKey.getName(Locale.getDefault()));
				registrationMap.put("noOfAttempts", noOfAttempt);
				// List<OCTRegistration> OCTRegistrations = octRestrationByIdItem.getItems();
				omsbCommonApi.updateObjectEntryByERC(OmsbOctExamWebPortletKeys.OB_OC_EXAM_REGISTRATION_ERC,
						registrationMap, actionRequest, themeDisplay, octRestrationItem.getItems().get(0).getId());

				logger.info("Registration cancelled successfully");
			}
		} catch (Exception e) {

		}

		return true;
	}

	private int noOfAttempts(ThemeDisplay themeDisplay, long lrUserId, long ocExamScheduleId) {
		try {
			// long userId = themeDisplay.getUserId();
			OCTRegistrationItem reg = octExamUtil.getRegistrationByUserIdAndScheduleId(themeDisplay, lrUserId,
					ocExamScheduleId);
			if (Validator.isNotNull(reg) && Validator.isNotNull(reg.getItems()) && !(reg.getItems()).isEmpty()) {
				int noOfAttempt = reg.getItems().get(0).getNoOfAttempt();
				logger.info("no of attempt :::" + noOfAttempt);
				noOfAttempt--;
				return noOfAttempt;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return 1;
	}

	private OCTExamPayment prepareOCTExamCancellationPayment(long applicantId, long scheduleId, long registrationId,
			double cancellationFees, String refundRefNo) {

		OCTExamPayment octExamPayment = new OCTExamPayment();
		octExamPayment.setApplicantId(applicantId);
		octExamPayment.setScheduleId(scheduleId);
		octExamPayment.setRegistrationId(registrationId);
		octExamPayment.setFees(cancellationFees);
		octExamPayment.setRefundRefNo(refundRefNo);
		octExamPayment.setPaymentStatus(OmsbOctExamWebPortletKeys.PAID);
		octExamPayment.setCurrency(OmsbOctExamWebPortletKeys.OMR);
		octExamPayment.setFeesType("cancellation");
		octExamPayment.setPaymentMode("Card");
		octExamPayment.setTransactionType("debit");
		return octExamPayment;

	}

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference
	private OCTExamUtil octExamUtil;

	@Reference
	UserNotificationEventLocalService userNotificationEventLocalService;

	@Reference
	private OMSBHttpConnector omsbHttpConnector;
	private static final Log logger = LogFactoryUtil.getLog(OCTRegistrationCancellationMVCActionCommand.class);

}