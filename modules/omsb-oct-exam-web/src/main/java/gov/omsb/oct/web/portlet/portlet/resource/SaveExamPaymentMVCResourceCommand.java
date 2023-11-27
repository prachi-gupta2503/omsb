package gov.omsb.oct.web.portlet.portlet.resource;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
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
import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamPayment;
import gov.omsb.oct.exam.web.portlet.dto.OCTRegistration;
import gov.omsb.oct.exam.web.portlet.dto.OCTRegistrationItem;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name="
				+ MVCCommandNames.SAVE_EXAM_PAYMENT_RESOURCE, }, service = MVCResourceCommand.class)

public class SaveExamPaymentMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		createExamPayment(resourceRequest, resourceResponse);
		return true;
	}

	/**
	 * Create Payment Entry for exam 
	 *
	 * @param resourceRequest
	 * @param resourceResponse
	 */
	private void createExamPayment(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String portalURL = themeDisplay.getPortalURL();
		long scopeGroupId = themeDisplay.getScopeGroupId();
		long registrationId = 0;
		long oCExamScheduleId = ParamUtil.getLong(resourceRequest, "examScheduleId");
		double fees = ParamUtil.getDouble(resourceRequest, "fees");
		String feeType = ParamUtil.getString(resourceRequest, "feeType");
		long lrUserId = themeDisplay.getUserId();
		boolean hasUserRole = omsbCommonApi.hasUserRole(themeDisplay.getCompanyId(), lrUserId, RoleNameConstants.EXAM_APPLICANT);
		
		try {
			String orderId = octExamUtil.generateOrderId(portalURL, scopeGroupId);
			long transactionId = new Date().getTime();
			String currency = OmsbOctExamWebPortletKeys.OMR;
			String paymentPortalUrl = OmsbOctExamWebPortletKeys.PAYMENT_URL;

			OCTRegistrationItem octRegistrationItem = octExamUtil.getRegistrationByUserIdAndScheduleId(themeDisplay,
					lrUserId, oCExamScheduleId);
			if (!octRegistrationItem.getItems().isEmpty()) {
				OCTRegistration octRegistration = octRegistrationItem.getItems().get(0);
				registrationId = octRegistration.getId();
			}

			OCTExamPayment octExamPayment = prepareOCTExamPayment(lrUserId, oCExamScheduleId, registrationId, orderId,
					transactionId, fees, feeType);
			octExamUtil.saveOCTExamPayment(octExamPayment, portalURL, scopeGroupId);
			JSONObject responseJson = JSONFactoryUtil.createJSONObject();

			responseJson.put("url", paymentPortalUrl);
			responseJson.put("transactionId", transactionId);
			responseJson.put("lrUserId", lrUserId);
			responseJson.put("oCExamScheduleId", oCExamScheduleId);
			responseJson.put("registrationId", registrationId);
			responseJson.put("orderId", orderId);
			responseJson.put("fees", fees);
			responseJson.put("currency", currency);
			if(hasUserRole) {
			 responseJson.put("makePayement", true);
			}else {
				responseJson.put("makePayement", false);
			}
			PrintWriter out = resourceResponse.getWriter();
			out.println(responseJson);
			

		} catch (Exception e) {
			logger.error("Error while creating Exam Payment :" + e.getMessage(), e);
		}

	}

	private OCTExamPayment prepareOCTExamPayment(long applicantId, long scheduleId, long registrationId, String orderId,
			long transactionId, double examFees, String feeType) {
		OCTExamPayment octExamPayment = new OCTExamPayment();
		octExamPayment.setApplicantId(applicantId);
		octExamPayment.setScheduleId(scheduleId);
		octExamPayment.setRegistrationId(registrationId);
		octExamPayment.setOrderId(orderId);
		octExamPayment.settId(transactionId);
		octExamPayment.setPaymentStatus(OmsbOctExamWebPortletKeys.PENDING);
		octExamPayment.setCurrency(OmsbOctExamWebPortletKeys.OMR);
		octExamPayment.setFees(examFees);
		octExamPayment.setFeesType(feeType);

		return octExamPayment;
	}
	
	

	@Reference
	private OCTExamUtil octExamUtil;
	
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	private static final Log logger = LogFactoryUtil.getLog(SaveExamPaymentMVCResourceCommand.class);

}
