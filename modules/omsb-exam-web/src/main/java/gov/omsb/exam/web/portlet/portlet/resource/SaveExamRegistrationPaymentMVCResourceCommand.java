package gov.omsb.exam.web.portlet.portlet.resource;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.UserNotificationEventLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.PrintWriter;
import java.util.Date;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.exam.web.portlet.constants.MVCCommands;
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;
import gov.omsb.exam.web.portlet.dto.ExamPayment;
import gov.omsb.exam.web.portlet.dto.Registration;
import gov.omsb.exam.web.portlet.dto.RegistrationItem;
import gov.omsb.exam.web.portlet.util.ExamUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OMSBExamWebPortletKeys.OMSBEXAMWEB,
		"mvc.command.name="
				+ MVCCommands.SAVE_EXAM_REGISTRATION_PAYMENT_RESOURCE, }, service = MVCResourceCommand.class)

public class SaveExamRegistrationPaymentMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		createExamPayment(resourceRequest, resourceResponse);
		return true;
	}

	private void createExamPayment(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String portalURL = themeDisplay.getPortalURL();
		long scopeGroupId = themeDisplay.getScopeGroupId();

		long registrationId = 0;
		long examScheduleId = ParamUtil.getLong(resourceRequest, "examScheduleId");
		double fees = ParamUtil.getDouble(resourceRequest, "examFees");
		long lrUserId = ParamUtil.getLong(resourceRequest, "lrUserId");
		if(lrUserId == 0) {
			lrUserId=themeDisplay.getUserId();
		}
		logger.info("lrUserId "+ lrUserId);
		long  loginUserId = themeDisplay.getUserId();
		
		boolean hasUserRole = omsbCommonApi.hasUserRole(themeDisplay.getCompanyId(), loginUserId, RoleNameConstants.TRAINEE);
		
		try {

			String orderId = generateOrderId(portalURL, scopeGroupId);
			String paymentStatus = OMSBExamWebPortletKeys.PENDING;
			String url = OMSBExamWebPortletKeys.PAYMENT_URL;
			long transactionId = new Date().getTime();
			String currency = OMSBExamWebPortletKeys.OMR;
			RegistrationItem restrationItem = examUtil.getRegistrationByUserIdAndScheduleId(themeDisplay.getPortalURL(),themeDisplay.getScopeGroupId(), lrUserId,
						examScheduleId);
				if (!restrationItem.getItems().isEmpty()) {
					Registration registration = restrationItem.getItems().get(0);
					registrationId = registration.getId();
				}

			ExamPayment examRegistrationPayment = prepareExamPayment(lrUserId, examScheduleId, registrationId,
					paymentStatus, orderId, transactionId, fees);
			examUtil.saveExamPayment(examRegistrationPayment, portalURL, scopeGroupId);

			JSONObject responseJson = JSONFactoryUtil.createJSONObject();

			logger.info("registrationId"+  registrationId);
			responseJson.put("url", url);
			responseJson.put("transactionId", transactionId);
			responseJson.put("lrUserId", lrUserId);
			responseJson.put("examScheduleId", examScheduleId);
			responseJson.put("registrationId", registrationId);
			responseJson.put("orderId", orderId);
			responseJson.put("paymentStatus", paymentStatus);
			responseJson.put("fees", fees);
			responseJson.put("currency", currency);
			if (hasUserRole) {
				responseJson.put("makePayement", true);
			} else {
				responseJson.put("makePayement", false);
			}
			PrintWriter out = resourceResponse.getWriter();
			out.println(responseJson);

		} catch (Exception e) {
			logger.error("Error while creating Exam Payment :" + e.getMessage(), e);
		}

	}

	private String generateOrderId(String portalURL, long scopeGroupId) {

		long max = 1000000000l;
		long min = 9999999999l;
		long range = max - min + 1;
		long rand = (long) (Math.random() * range) + min;
		String orderId = String.valueOf(rand);
		ExamPayment octExamPayment = examUtil.getExamPaymentByOrderId(orderId, portalURL, scopeGroupId);
		if (Validator.isNotNull(octExamPayment)) {
			orderId = generateOrderId(portalURL, scopeGroupId);
		}
		return orderId;
	}

	private ExamPayment prepareExamPayment(long applicantId, long scheduleId, long registrationId, String paymentStatus,
			String orderId, long tId, double examFees) {
		ExamPayment examPayment = new ExamPayment();
		examPayment.setApplicantId(applicantId);
		examPayment.setScheduleId(scheduleId);
		examPayment.setRegistrationId(registrationId);
		examPayment.setPaymentStatus(paymentStatus);
		examPayment.setOrderId(orderId);
		examPayment.settId(tId);
		examPayment.setPaymentStatus(OMSBExamWebPortletKeys.PENDING);
		examPayment.setCurrency(OMSBExamWebPortletKeys.OMR);
		examPayment.setFees(examFees);
		examPayment.setFeesType(OMSBExamWebPortletKeys.FEES_TYPE_EXAM_REGISTRATION);
		return examPayment;
	}

	@Reference
	UserNotificationEventLocalService userNotificationEventLocalService;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
	@Reference
	private ExamUtil examUtil;

	private static final Log logger = LogFactoryUtil.getLog(SaveExamRegistrationPaymentMVCResourceCommand.class);

}
