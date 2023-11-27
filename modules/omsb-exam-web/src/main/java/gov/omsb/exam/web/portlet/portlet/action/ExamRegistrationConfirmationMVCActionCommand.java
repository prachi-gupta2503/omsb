package gov.omsb.exam.web.portlet.portlet.action;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.UserNotificationEventLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.exam.web.portlet.constants.MVCCommands;
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;
import gov.omsb.exam.web.portlet.dto.ExamMultiDates;
import gov.omsb.exam.web.portlet.dto.ExamMultiDatesItem;
import gov.omsb.exam.web.portlet.dto.ExamPayment;
import gov.omsb.exam.web.portlet.dto.ExamSchedule;
import gov.omsb.exam.web.portlet.dto.Registration;
import gov.omsb.exam.web.portlet.dto.RegistrationItem;
import gov.omsb.exam.web.portlet.util.ExamNotificationUtil;
import gov.omsb.exam.web.portlet.util.ExamUtil;
import gov.omsb.exam.web.portlet.util.ScheduleUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OMSBExamWebPortletKeys.OMSBEXAMWEB,
		"mvc.command.name=" + MVCCommands.REGISTRATION_CONFIRM_ACTION }, service = MVCActionCommand.class)

public class ExamRegistrationConfirmationMVCActionCommand implements MVCActionCommand {
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {

		logger.debug("RegistrationConfirmationMVCActionCommand acrion command started");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long lrUserId = ParamUtil.getLong(actionRequest, "lrUserId");
		long examFees = ParamUtil.getLong(actionRequest, "examFees");
		logger.info("lrUserId" + lrUserId);
		logger.debug(lrUserId);
		if (lrUserId == 0) {
			lrUserId = themeDisplay.getUserId();
		}
		long examScheduleId = ParamUtil.getLong(actionRequest, "examScheduleId");
		RegistrationItem registrationItem = null;
		try {

			registrationItem = examUtil.getRegistrationByUserIdAndScheduleId(themeDisplay.getPortalURL(),
					themeDisplay.getScopeGroupId(), lrUserId, examScheduleId);

			if (Validator.isNotNull(registrationItem) && Validator.isNotNull(registrationItem.getItems())
					&& !registrationItem.getItems().isEmpty()) {
				long paymentRecieptId = 0;
				ExamSchedule examSchedule = examUtil.getExamScheduleById(examScheduleId, themeDisplay.getPortalURL());
				if (Validator.isNotNull(examSchedule)) {
					examSchedule.setExamTypeName(examUtil.getExamType(examSchedule.getExamType(), themeDisplay.getCompanyId(),themeDisplay.getPortalURL(),themeDisplay.getLocale()));
					examSchedule.setProgramName(examUtil.getProgramByProgramId(examSchedule.getProgramId(), themeDisplay));
					if(examSchedule.isMultiDates()) {
					examSchedule = scheduleUtil.setSchedularWithMutiDates(examSchedule, themeDisplay.getScopeGroupId(),themeDisplay.getPortalURL());
				}else {
					if(Validator.isNotNull(examSchedule.getExamDate())) {
						examSchedule.setExamDate(omsbCommonApi.convertDateFormatToDDMMYYYY(examSchedule.getExamDate())+"[ "+ examSchedule.getStartTime() +"]" );
					}
				}

					logger.info("Registration Id" + registrationItem.getItems().get(0).getId());
					ExamPayment examPayment = null;
					if (examFees > 0) {
						examPayment = examUtil.getExamPaymentDetailByRegistrationId(themeDisplay.getPortalURL(),
								themeDisplay.getScopeGroupId(), registrationItem.getItems().get(0).getId());
						if (Validator.isNotNull(examPayment)) {
							examPayment.setPaymentStatus("paid");
							
							examUtil.updateExamPayment(examPayment, themeDisplay.getPortalURL(),themeDisplay.getScopeGroupId());

							DLFileEntry paymentReciept = null;
							String htmlReciept = examNotificationUtil.getPaymentRecieptContent(themeDisplay, lrUserId,MVCCommands.EXAM_PAYMENT_RECEIPT_TEMPLATE, examSchedule, examPayment);
							if (Validator.isNotNull(htmlReciept)) {
								paymentReciept = examUtil.generatePaymentReceipt(actionRequest, htmlReciept,
										registrationItem.getItems().get(0).getLrUserId());
							}

							if (Validator.isNotNull(paymentReciept)) {
								paymentRecieptId = paymentReciept.getFileEntryId();
							}
						}
					}
					updateRegistration(themeDisplay, examScheduleId, paymentRecieptId, actionRequest,
							registrationItem.getItems().get(0).getId(), examFees,
							registrationItem.getItems().get(0).getLrUserId());
					examNotificationUtil.SendRegistrationSuccessNotification(themeDisplay, lrUserId, examSchedule);
				}

			}
		} catch (Exception e) {
			examNotificationUtil.SendRegistrationFailedNotification(themeDisplay, lrUserId);
			logger.error(e.getMessage(), e);
			return false;

		}
		return true;
	}

	private void updateRegistration(ThemeDisplay themeDisplay, long examScheduleId, long paymentRecieptId,
			ActionRequest actionRequest, long registrationId, double fees, long lrUserId) {

		Map<String, Serializable> registrationMap = new HashMap<>();

		int noOfAttempt = examUtil.getNoOfAttempts(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(),
				examScheduleId, lrUserId);
		registrationMap.put("registrationStatus", OMSBExamWebPortletKeys.REGISTERED);
		registrationMap.put("noOfAttempt", ++noOfAttempt);
		registrationMap.put("dateOfPayment",
				omsbCommonApi.convertDateFormat(new SimpleDateFormat("dd/MM/yyyy ").format(new Date())));
		registrationMap.put("paymentComplete", true);
		registrationMap.put("feesPaid", fees);

		registrationMap.put("paymentReceiptFileEntryId", paymentRecieptId);
		omsbCommonApi.updateObjectEntryByERC(OMSBExamWebPortletKeys.OB_EXAM_REGISTRATION_ERC, registrationMap,
				actionRequest, themeDisplay, registrationId);

	}

	@Reference
	private ExamUtil examUtil;

	@Reference
	private ScheduleUtil scheduleUtil;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference
	UserNotificationEventLocalService userNotificationEventLocalService;

	@Reference(unbind = "-")
	private ExamNotificationUtil examNotificationUtil;

	private static final Log logger = LogFactoryUtil.getLog(ExamRegistrationConfirmationMVCActionCommand.class);
}
