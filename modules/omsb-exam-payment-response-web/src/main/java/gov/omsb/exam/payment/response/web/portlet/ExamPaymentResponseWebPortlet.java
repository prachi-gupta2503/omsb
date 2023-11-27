package gov.omsb.exam.payment.response.web.portlet;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserNotificationEventLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.Serializable;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.exam.payment.response.web.constants.ExamPaymentResponseWebPortletKeys;
import gov.omsb.exam.web.portlet.constants.MVCCommands;
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;
import gov.omsb.exam.web.portlet.dto.ExamAppeal;
import gov.omsb.exam.web.portlet.dto.ExamAppealItem;
import gov.omsb.exam.web.portlet.dto.ExamPayment;
import gov.omsb.exam.web.portlet.dto.ExamSchedule;
import gov.omsb.exam.web.portlet.dto.Registration;
import gov.omsb.exam.web.portlet.dto.RegistrationItem;
import gov.omsb.exam.web.portlet.util.ExamAppealUtil;
import gov.omsb.exam.web.portlet.util.ExamNotificationUtil;
import gov.omsb.exam.web.portlet.util.ExamUtil;
import gov.omsb.exam.web.portlet.util.ScheduleUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.oct.exam.web.constants.OCTExamConstants;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamAppeal;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamAppealItem;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamDefinition;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamPayment;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamSchedule;
import gov.omsb.oct.exam.web.portlet.dto.OCTRegistration;
import gov.omsb.oct.exam.web.portlet.dto.OCTRegistrationItem;
import gov.omsb.oct.exam.web.portlet.util.OCTExamAppealUtil;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;
import gov.omsb.oct.exam.web.portlet.util.OCTNotificationUtil;

/**
 * @author HP
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=ExamPaymentResponseWeb", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ExamPaymentResponseWebPortletKeys.EXAMPAYMENTRESPONSEWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class ExamPaymentResponseWebPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String homePageUrl = themeDisplay.getPortalURL();
		HttpServletRequest httpReq = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		try {
			String payload = httpReq.getParameter("payload").replace(" ", "+");
			logger.info("payload :"+payload);
			if (Validator.isNotNull(payload)) {

				String decryptedResponse = decrypt(payload);
				logger.info("Decrypt payload :"+decryptedResponse);
				String[] responseParams = decryptedResponse.split("&");
				String orderId = null;
				String trackingId = null;
				if (responseParams.length > 0) {
					for (String responseParam : responseParams) {
						if (responseParam.contains("order_id")) {
							orderId = responseParam.split("=")[1];
						}
						if (responseParam.contains("tracking_id")) {
							trackingId = responseParam.split("=")[1];
						}
					}
				}
				if (Validator.isNotNull(orderId)) {

					long examScheduleId = 0l;
					long userId = 0L;

					// OCT Exam Payment
					OCTExamPayment octExamPayment = octExamUtil.getOCTExamPaymentByOrderId(orderId, themeDisplay.getPortalURL(),
							themeDisplay.getScopeGroupId());
					if (Validator.isNotNull(octExamPayment)) {
						
						if(octExamPayment.getFeesType().equalsIgnoreCase(ExamPaymentResponseWebPortletKeys.FEES_TYPE_OCT_EXAM_APPEAL) || octExamPayment.getFeesType().equalsIgnoreCase(ExamPaymentResponseWebPortletKeys.FEES_TYPE_OCT_EXAM_REAPPEAL)){
							if (decryptedResponse.contains("status_message=Approved")) {
								octExamPayment.setPaymentStatus("paid");
								octExamUtil.updateOCTExamPayment(octExamPayment, themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId());
								userId = octExamPayment.getApplicantId();
								
								saveOCTAppealData(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), octExamPayment.getApplicantId(), octExamPayment.getScheduleId(),
										examAppealUtil.setStatus(OMSBExamWebPortletKeys.PL_EXAM_STATUS_KEY_PENDING, themeDisplay.getCompanyId()));
								
								OCTExamAppealItem octExamAppealItem = octExamAppealUtil.getAppealByResultlId(themeDisplay, octExamPayment.getScheduleId());
								if(Validator.isNotNull(octExamAppealItem) && Validator.isNotNull(octExamAppealItem.getItems()) && octExamAppealItem.getItems().size()>0) {
									updateOCExamAppealStatus(themeDisplay, octExamPayment.getRegistrationId(), octExamAppealItem.getItems().get(0).getId());
								}
							}
							
							//examNotificationUtil.SendRegistrationSuccessNotification(themeDisplay, userId, examSchedule);
							renderRequest.setAttribute("paymentResponseStatus", "success");

						} else if(octExamPayment.getFeesType().equalsIgnoreCase(ExamPaymentResponseWebPortletKeys.FEES_TYPE_OCT_EXAM_REGISTRATION) || 
								octExamPayment.getFeesType().equalsIgnoreCase(ExamPaymentResponseWebPortletKeys.FEES_TYPE_OCT_EXAM_RESCHEDULE)){
							OCTExamSchedule octExamSchedule=null;
							if (decryptedResponse.contains("status_message=Approved")) {
								octExamPayment.setPaymentStatus("paid");
								octExamPayment.setTrackingId(trackingId);
								octExamUtil.updateOCTExamPayment(octExamPayment, themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId());
								examScheduleId = octExamPayment.getScheduleId();
								userId = octExamPayment.getApplicantId();
								
								if (examScheduleId > 0) {
									octExamSchedule = octExamUtil.getOCTExamScheduleById(examScheduleId, themeDisplay.getPortalURL());
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
								processOCTRegistrationConfirmation(octExamSchedule, userId, themeDisplay, renderRequest,octExamPayment);
								
								
								if(octExamPayment.getFeesType().equalsIgnoreCase(ExamPaymentResponseWebPortletKeys.FEES_TYPE_OCT_EXAM_REGISTRATION)){
									octNotificationUtil.SendRegistrationSuccessNotification(themeDisplay, userId, octExamSchedule);
								}else if(octExamPayment.getFeesType().equalsIgnoreCase(ExamPaymentResponseWebPortletKeys.FEES_TYPE_OCT_EXAM_RESCHEDULE)) {
									octNotificationUtil.SendRescheduleSuccessNotification(themeDisplay, userId);
								}
								renderRequest.setAttribute("paymentResponseStatus", "success");
							}	
						} else {
								
								deleteOCTRegistration(themeDisplay, userId, examScheduleId);
								if(octExamPayment.getFeesType().equalsIgnoreCase(ExamPaymentResponseWebPortletKeys.FEES_TYPE_OCT_EXAM_REGISTRATION)){
									octNotificationUtil.SendRegistrationFailedNotification(themeDisplay, userId,octExamSchedule);
								}else if(octExamPayment.getFeesType().equalsIgnoreCase(ExamPaymentResponseWebPortletKeys.FEES_TYPE_OCT_EXAM_RESCHEDULE)) {
									octNotificationUtil.SendRescheduleFailedNotification(themeDisplay, userId);

								}
								renderRequest.setAttribute("paymentResponseStatus", "failed");
							}
							if (octExamPayment.getFeesType()
									.equalsIgnoreCase(ExamPaymentResponseWebPortletKeys.FEES_TYPE_OCT_EXAM_REGISTRATION)) {
								homePageUrl = themeDisplay.getPortalURL() + "/group/guest/oct";
							} else if (octExamPayment.getFeesType()
									.equalsIgnoreCase(ExamPaymentResponseWebPortletKeys.FEES_TYPE_OCT_EXAM_RESCHEDULE)) {
								OCTExamSchedule octExamSchedule1 = octExamUtil
										.getOCTExamScheduleById(octExamPayment.getScheduleId(), themeDisplay.getPortalURL());
								String examDate = octExamSchedule1.getExamDate();
								String examStartTime = octExamSchedule1.getExamSlot();
								OCTExamDefinition octExamDefinition = octExamUtil.getOCTExamDefinitionByDefinitionId(
										octExamSchedule1.getOctExamDefinitionId(), themeDisplay.getPortalURL());
								long examTitleId = octExamDefinition.getoCExamTitleId();
								homePageUrl = themeDisplay.getPortalURL()
										+ OmsbOctExamWebPortletKeys.EXAM_RESCHEDULE_PAGE_URL + "&examDate=" + examDate
										+ "&examStartTime=" + examStartTime
										+ "&examTitleId=" + examTitleId;
							}
						}
					} else {
						// Exam Payment
						ExamPayment examPayment = examUtil.getExamPaymentByOrderId(orderId, themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId());
						homePageUrl = themeDisplay.getPortalURL() + "/group/guest/examination";
						logger.info("examPayment.getFeesType()"+ examPayment.getFeesType());
						if (Validator.isNotNull(examPayment)) {
							if(examPayment.getFeesType().equalsIgnoreCase(ExamPaymentResponseWebPortletKeys.FEES_TYPE_EXAM_APPEAL) || examPayment.getFeesType().equalsIgnoreCase(ExamPaymentResponseWebPortletKeys.FEES_TYPE_EXAM_REAPPEAL)){
								if (decryptedResponse.contains("status_message=Approved")) {
									examPayment.setPaymentStatus("paid");
									examUtil.updateExamPayment(examPayment, themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId());
									userId = examPayment.getApplicantId();
									
									saveAppealData(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), examPayment.getApplicantId(), examPayment.getScheduleId(), 
											examAppealUtil.setStatus(OMSBExamWebPortletKeys.PL_EXAM_STATUS_KEY_PENDING, themeDisplay.getCompanyId()));
									
									ExamAppealItem examAppealItem = examAppealUtil.getAppealByResultlId(themeDisplay, examPayment.getScheduleId());
									if(Validator.isNotNull(examAppealItem) && Validator.isNotNull(examAppealItem.getItems()) && examAppealItem.getItems().size()>0) {
										updateExamAppealStatus(themeDisplay, examPayment.getRegistrationId(), examAppealItem.getItems().get(0).getId());
									}
								}
								
								//examNotificationUtil.SendRegistrationSuccessNotification(themeDisplay, userId, examSchedule);
								renderRequest.setAttribute("paymentResponseStatus", "success");

							} else if(examPayment.getFeesType().equalsIgnoreCase(ExamPaymentResponseWebPortletKeys.FEES_TYPE_EXAM_REGISTRATION)){
								if (decryptedResponse.contains("status_message=Approved")) {
									examScheduleId = examPayment.getScheduleId();
									ExamSchedule examSchedule = examUtil.getExamScheduleById(examScheduleId, themeDisplay.getPortalURL());
									if (Validator.isNotNull(examSchedule)) {
										examSchedule.setExamTypeName(examUtil.getExamType(examSchedule.getExamType(), themeDisplay.getCompanyId(),themeDisplay.getPortalURL(),themeDisplay.getLocale()));
										examSchedule.setProgramName(examUtil.getProgramByProgramId(examSchedule.getProgramId(), themeDisplay));
									}
									examPayment.setPaymentStatus("paid");
									examUtil.updateExamPayment(examPayment, themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId());
									userId = examPayment.getApplicantId();
									if (examScheduleId > 0) {
										Registration registration = getExamRegistration(themeDisplay, userId, examScheduleId);
										if(Validator.isNotNull(registration)) {
											if(!registration.getRegistrationStatus().equalsIgnoreCase(ExamPaymentResponseWebPortletKeys.REGISTERED)) {
												
												DLFileEntry paymentReciept = null;
												String htmlReciept = examNotificationUtil.getPaymentRecieptContent(themeDisplay, registration.getLrUserId(),
															MVCCommands.EXAM_PAYMENT_RECEIPT_TEMPLATE, examSchedule, examPayment);
												if (Validator.isNotNull(htmlReciept)) {
													paymentReciept = examUtil.generatePaymentReceipt(renderRequest, htmlReciept,
																registration.getLrUserId());
												}
												long paymentRecieptId = 0;
												if (Validator.isNotNull(paymentReciept)) {
													paymentRecieptId = paymentReciept.getFileEntryId();
												}
												processRegistrationConfirmation(examScheduleId, userId, themeDisplay,
													registration.getId(),paymentRecieptId,renderRequest);
												logger.info("registration updated success ");
												if(examSchedule.isMultiDates()) {
													examSchedule = scheduleUtil.setSchedularWithMutiDates(examSchedule, themeDisplay.getScopeGroupId(),themeDisplay.getPortalURL());
													}else {
														if(Validator.isNotNull(examSchedule.getExamDate())) {
															examSchedule.setExamDate(omsbCommonApi.convertDateFormatToDDMMYYYY(examSchedule.getExamDate())+"[ "+ examSchedule.getStartTime() +"]" );
														}
												}
												examNotificationUtil.SendRegistrationSuccessNotification(themeDisplay, userId, examSchedule);
											}
										}			
									}
									renderRequest.setAttribute("paymentResponseStatus", "success");
								}else{
									renderRequest.setAttribute("paymentResponseStatus", "failed");
									examNotificationUtil.SendRegistrationFailedNotification(themeDisplay, userId);
								}
								
								if (examPayment.getFeesType().equalsIgnoreCase(ExamPaymentResponseWebPortletKeys.REGISTERED)) {
									homePageUrl = themeDisplay.getPortalURL() + "/group/guest/examination";
								}
							}
						} else {
							renderRequest.setAttribute("paymentResponseStatus", "failed");
							examNotificationUtil.SendRegistrationFailedNotification(themeDisplay, userId);
							renderRequest.setAttribute("paymentResponseStatus", "failed");
						}
					}
				}
			}
		} catch (Exception e) {
			renderRequest.setAttribute("paymentResponseStatus", "failed");
		//	examNotificationUtil.SendRegistrationFailedNotification(themeDisplay, userId);
			logger.error("Error in updating Exam Payment" + e.getMessage(), e);
			logger.debug(e);
		}
		renderRequest.setAttribute("homePageUrl", homePageUrl);
		renderRequest.setAttribute("loginUrl", themeDisplay.getPortalURL());
		super.render(renderRequest, renderResponse);
	}

	public static String decrypt(String strToDecrypt) {

		final String SECRET_KEY = "040111992";
		final String SALTVALUE = "vpwlaobzzacibfpugubx";

		try {
			/* Declare a byte array. */
			byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			IvParameterSpec ivspec = new IvParameterSpec(iv);
			/* Create factory for secret keys. */
			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
			/* PBEKeySpec class implements KeySpec interface. */
			KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(), SALTVALUE.getBytes(), 65536, 256);
			SecretKey tmp = factory.generateSecret(spec);
			SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
			/* Retruns decrypted value. */
			return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
		} catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException
				| InvalidKeySpecException | BadPaddingException | IllegalBlockSizeException
				| NoSuchPaddingException e) {
			logger.error("Error occured during decryption: " + e.toString());
		}
		return null;
	}

	private void processOCTRegistrationConfirmation(OCTExamSchedule octExamSchedule, long lrUserId, ThemeDisplay themeDisplay,
			RenderRequest renderRequest, OCTExamPayment octExamPayment) {

		String examRegistrationStatusKey = OmsbOctExamWebPortletKeys.EXAM_REGISTRATION_STATUS_KEY_REGISTERED;
		if (octExamPayment.getFeesType().equalsIgnoreCase(ExamPaymentResponseWebPortletKeys.FEES_TYPE_OCT_EXAM_RESCHEDULE)) {
			examRegistrationStatusKey = OmsbOctExamWebPortletKeys.EXAM_REGISTRATION_STATUS_KEY_RESCHEDULED;
		}
		try {

			DLFileEntry paymentReciept = null;
			String htmlReciept = octNotificationUtil.getPaymentRecieptContent(themeDisplay, lrUserId,
					OCTExamConstants.OCT_PAYMENT_RECEIPT_TEMPLATE, octExamSchedule, octExamPayment);
			if (Validator.isNotNull(htmlReciept)) {
				paymentReciept = octExamUtil.generatePaymentReceipt(renderRequest, htmlReciept, lrUserId);
			}
			long paymentRecieptId = 0;
			if (Validator.isNotNull(paymentReciept)) {
				paymentRecieptId = paymentReciept.getFileEntryId();
			}
			OCTRegistrationItem octRestrationItem = octExamUtil.getRegistrationByUserIdAndScheduleId(themeDisplay,
					lrUserId, octExamSchedule.getId());
			
			if (!octRestrationItem.getItems().isEmpty()) {
				Map<String, Serializable> registrationMap = new HashMap<>();
				if (octExamPayment.getFeesType().equalsIgnoreCase(ExamPaymentResponseWebPortletKeys.FEES_TYPE_OCT_EXAM_REGISTRATION)){
					int noOfAttempt = getOctExamNoOfAttempts(themeDisplay, lrUserId, octExamSchedule.getId());
					registrationMap.put("regStatus", examRegistrationStatusKey);
					registrationMap.put("noOfAttempts", noOfAttempt);
					registrationMap.put("paymentReceiptFileEntryId", paymentRecieptId);
					registrationMap.put("paymentComplete", true);
					registrationMap.put("dateOfPayment",omsbCommonApi.convertDateFormat(new SimpleDateFormat("dd/MM/yyyy ").format(new Date())));
				} else {
					registrationMap.put("regStatus", examRegistrationStatusKey);
				}

				omsbCommonApi.updateObjectEntryByERC(OmsbOctExamWebPortletKeys.OB_OC_EXAM_REGISTRATION_ERC,
						registrationMap, renderRequest, themeDisplay, octRestrationItem.getItems().get(0).getId());
			}

		} catch (Exception e) {
			logger.error("Error in Processing Registration Confirmation" + e.getMessage());
		}
	}

	private void processRegistrationConfirmation(long examScheduleId, long lrUserId, ThemeDisplay themeDisplay, long id,
			long paymentRecieptId, RenderRequest renderRequest) {

		try {
			Map<String, Serializable> registrationMap = new HashMap<>();
			int noOfAttempt = examUtil.getNoOfAttempts(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(),
					examScheduleId, lrUserId);
			registrationMap.put("registrationStatus", ExamPaymentResponseWebPortletKeys.REGISTERED);
			registrationMap.put("noOfAttempt", ++noOfAttempt);
			registrationMap.put("paymentReceiptFileEntryId", paymentRecieptId);
			registrationMap.put("dateOfPayment",
					omsbCommonApi.convertDateFormat(new SimpleDateFormat("dd/MM/yyyy ").format(new Date())));
			omsbCommonApi.updateObjectEntryByERC(OmsbOctExamWebPortletKeys.OB_EXAM_REGISTRATION_ERC, registrationMap,
					renderRequest, themeDisplay, id);
			registrationMap.put("paymentComplete", true);

		} catch (Exception e) {
			logger.error("Error in Processing Registration Confirmation" + e.getMessage());
		}
	}

	private int getOctExamNoOfAttempts(ThemeDisplay themeDisplay, long lrUserId, long ocExamScheduleId) {
		try {
			OCTRegistrationItem reg = octExamUtil.getRegistrationByUserIdAndScheduleId(themeDisplay, lrUserId,
					ocExamScheduleId);
			if (Validator.isNotNull(reg) && Validator.isNotNull(reg.getItems()) && !(reg.getItems()).isEmpty()) {
				int noOfAttempt = reg.getItems().get(0).getNoOfAttempt();
				noOfAttempt++;
				return noOfAttempt;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return 1;
	}

	private void deleteOCTRegistration(ThemeDisplay themeDisplay, long lrUserId, long examScheduleId) {
		OCTRegistration registration = getOCTRegistration(themeDisplay, lrUserId, examScheduleId);
		if (Validator.isNotNull(registration)) {
			omsbCommonApi.deleteObjectEntryEntryId(registration.getId());
		}
	}

	private OCTRegistration getOCTRegistration(ThemeDisplay themeDisplay, long lrUserId, long examScheduleId) {
		OCTRegistrationItem octRegistrationItem = octExamUtil.getRegistrationByUserIdAndScheduleId(themeDisplay,
				lrUserId, examScheduleId);
		OCTRegistration registration = null;
		if (Validator.isNotNull(octRegistrationItem) && Validator.isNotNull(octRegistrationItem.getItems())
				&& !octRegistrationItem.getItems().isEmpty()) {
			return octRegistrationItem.getItems().get(0);
		}
		return registration;
	}

	private Registration getExamRegistration(ThemeDisplay themeDisplay, long lrUserId, long examScheduleId) {
		RegistrationItem registrationItem = examUtil.getRegistrationByUserIdAndScheduleId(themeDisplay.getPortalURL(),
				themeDisplay.getScopeGroupId(), lrUserId, examScheduleId);
		Registration registration = null;
		if (Validator.isNotNull(registrationItem) && Validator.isNotNull(registrationItem.getItems())
				&& !registrationItem.getItems().isEmpty()) {
			return registrationItem.getItems().get(0);
		}
		return registration;
	}
	
	 private ExamAppeal saveAppealData(final String portalURL, final long scopeGroupId, final long userId, final long examResultId, final long statusId) {
		 String url = portalURL + LRObjectURL.EXAM_APPEAL_URL +
					CommonConstants.SCOPES+StringPool.SLASH + scopeGroupId;
		 JSONObject object = JSONFactoryUtil.createJSONObject();
		 object.put("examResultId", examResultId);
		 object.put("lrUserId", userId);
		 object.put("appealCount", 1);
		 object.put("appealStatus", statusId);
		 String response = omsbHttpConnector.executePost(url , object.toString(),  omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
		 return CustomObjectMapperUtil.readValue(response, ExamAppeal.class);
    }
	
	private void updateExamAppealStatus(ThemeDisplay themeDisplay, long appealStatusId, long appealId) {
		String url = themeDisplay.getPortalURL() + LRObjectURL.EXAM_APPEAL_STATUS_URL + appealStatusId;
	    JSONObject resultObject = JSONFactoryUtil.createJSONObject();
	    resultObject.put("examAppealId", appealId);
	    omsbHttpConnector.executePut(url, resultObject.toString(), omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
	}
	
	private void updateOCExamAppealStatus(ThemeDisplay themeDisplay, long appealStatusId, long appealId) {
		String url = themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_APPEAL_STATUS_URL + appealStatusId;
	    JSONObject resultObject = JSONFactoryUtil.createJSONObject();
	    resultObject.put("oCExamAppealId", appealId);
	    omsbHttpConnector.executePut(url, resultObject.toString(), omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
	}
	
	private OCTExamAppeal saveOCTAppealData(String portalURL, long scopeGroupId, long userId, long examResultId, long statusId) {
		String url = portalURL + LRObjectURL.OC_EXAM_APPEAL_URL +
					CommonConstants.SCOPES+StringPool.SLASH + scopeGroupId;
		JSONObject object = JSONFactoryUtil.createJSONObject();
		object.put("examResultId", examResultId);
		object.put("lrUserId", userId);
		object.put("appealCount", 1);
		object.put("appealStatus", statusId);
		String response = omsbHttpConnector.executePost(url , object.toString(),  omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
		return CustomObjectMapperUtil.readValue(response, OCTExamAppeal.class);
    } 
	
	@Reference
	private UserNotificationEventLocalService userNotificationEventLocalService;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
	
	@Reference(unbind = "-")
	private OMSBHttpConnector omsbHttpConnector;

	@Reference
	private OCTExamUtil octExamUtil;
	
	@Reference
	private OCTExamAppealUtil octExamAppealUtil;

	@Reference
	private ExamUtil examUtil;
	
	@Reference
	private ExamAppealUtil examAppealUtil;

	@Reference
	private ScheduleUtil scheduleUtil;

	@Reference(unbind = "-")
	private OCTNotificationUtil octNotificationUtil;

	@Reference(unbind = "-")
	private ExamNotificationUtil examNotificationUtil;

	private static final Log logger = LogFactoryUtil.getLog(ExamPaymentResponseWebPortlet.class);
}
