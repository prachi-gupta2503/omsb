package gov.omsb.exam.web.portlet.util;

import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.UserNotificationEventLocalService;
import com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.dto.PersonalDetail;
import gov.omsb.common.dto.PersonalDetailItem;
import gov.omsb.exam.web.portlet.constants.MVCCommands;
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;
import gov.omsb.exam.web.portlet.dto.ExamPayment;
import gov.omsb.exam.web.portlet.dto.ExamSchedule;

@Component(immediate = true, service = ExamNotificationUtil.class)
public class ExamNotificationUtil {

//	public void sendExamNotification(long groupID, long userId, String templateName) {
//		logger.info("inside send email notification");
//		JournalArticle article = null;
//		try {
//			article = JournalArticleLocalServiceUtil.getArticleByUrlTitle(groupID, templateName);
//			String emailTitle = StringPool.BLANK;
//			String emailContent = StringPool.BLANK;
//			if (Validator.isNotNull(article)) {
//				String content = article.getContentByLocale("en_US");
//				emailTitle = examUtil.readXMLData(content, "emailTitle");
//				emailContent = examUtil.readXMLData(content, "emailContent");
//			}
//			logger.info("emailTitle ?? " + emailTitle);
//			logger.info("emailContent  ?? " + emailContent);
//			JSONObject notificationJSON = JSONFactoryUtil.createJSONObject();
//
//			notificationJSON.put("notificationText", emailTitle);
//			notificationJSON.put("emailTitle", emailTitle);
//			notificationJSON.put("emailContent", emailContent);
//
//			UserNotificationEvent u = UserNotificationEventLocalServiceUtil.sendUserNotificationEvents(userId,
//					OMSBExamWebPortletKeys.OMSBEXAMWEB, UserNotificationDeliveryConstants.TYPE_WEBSITE,
//					notificationJSON);
//			logger.info("SENDING NOTIFICATION ...." + u.getPayload());
//
//			String email = Validator.isNotNull(userLocalService.fetchUser(userId))
//					? userLocalService.fetchUser(userId).getEmailAddress()
//					: "";
//			sendEmail(email, emailTitle, emailContent);
//
//		} catch (PortalException e) {
//			logger.error(e.getMessage(), e);
//		}
//	}
//
//	public void sendEmail(String toAddress, String subject, String body) {
//		logger.info("sendEmail Invoked :::");
//		try {
//			InternetAddress from = new InternetAddress("testportal@omsb.org");
//			InternetAddress to = new InternetAddress(toAddress);
//			MailMessage mailMessage = new MailMessage();
//			mailMessage.setFrom(from);
//			mailMessage.setTo(to);
//			mailMessage.setSubject(subject);
//			mailMessage.setBody(body);
//			mailMessage.setHTMLFormat(true);
//			MailServiceUtil.sendEmail(mailMessage);
//		} catch (AddressException e) {
//			logger.error(e);
//		}
//		logger.info("sendEmail Exit :::");
//	}
//
//	public String readXMLData(String content, String Key) {
//		String fieldValue = StringPool.BLANK;
//		try {
//
//			Document document = SAXReaderUtil.read(content);
//
//			Node node = document
//					.selectSingleNode("/root/dynamic-element[@field-reference='" + Key + "']/dynamic-content");
//
//			if (Validator.isNotNull(node)) {
//				return fieldValue = node.getText();
//			}
//		} catch (Exception e) {
//			logger.error(e.getMessage());
//		}
//		return fieldValue;
//
//	}

	public void SendRegistrationFailedNotification(ThemeDisplay themeDisplay, long userId) {

		logger.info("inside send email notification");
		JournalArticle article = null;
		try {
			article = JournalArticleLocalServiceUtil.getArticleByUrlTitle(themeDisplay.getScopeGroupId(),
					MVCCommands.EXAM_REGISTRATION_FAIL_TEMPLATE);
			String emailTitle = StringPool.BLANK;
			String emailContent = StringPool.BLANK;
			if (Validator.isNotNull(article)) {
				String content = article.getContentByLocale("en_US");
				emailTitle = examUtil.readXMLData(content, "emailTitle");
				emailContent = examUtil.readXMLData(content, "emailContent");
			}
			logger.info("emailTitle ?? " + emailTitle);
			logger.debug("emailContent ?? " + emailContent);
			JSONObject notificationJSON = JSONFactoryUtil.createJSONObject();

			notificationJSON.put("notificationText", emailTitle);
			notificationJSON.put("emailTitle", emailTitle);
			notificationJSON.put("emailContent", emailContent);

			UserNotificationEvent u = UserNotificationEventLocalServiceUtil.sendUserNotificationEvents(userId,
					OMSBExamWebPortletKeys.OMSBEXAMWEB, UserNotificationDeliveryConstants.TYPE_WEBSITE,
					notificationJSON);
			logger.info("SENDING NOTIFICATION ...." + u.getPayload());

			String email = Validator.isNotNull(userLocalService.fetchUser(userId))
					? userLocalService.fetchUser(userId).getEmailAddress()
					: "";
			sendEmail(email, emailTitle, emailContent);

		} catch (PortalException e) {
			logger.error(e.getMessage(), e);
		}
	}

	public void SendRegistrationSuccessNotification(ThemeDisplay themeDisplay, long userId, ExamSchedule examSchedule) {
		logger.info("inside send email notification");
		JournalArticle article = null;
		try {
			article = JournalArticleLocalServiceUtil.getArticleByUrlTitle(themeDisplay.getScopeGroupId(),
					MVCCommands.EXAM_REGISTRATION_SUCCESS_TEMPLATE);
			String emailTitle = StringPool.BLANK;
			String emailContent = StringPool.BLANK;
			if (Validator.isNotNull(article)) {
				String content = article.getContentByLocale("en_US");
				emailTitle = examUtil.readXMLData(content, "emailTitle");
				emailContent = examUtil.readXMLData(content, "emailContent");
			}
			logger.info("emailTitle ?? " + emailTitle);
			logger.debug("emailContent ?? " + emailContent);
			JSONObject notificationJSON = JSONFactoryUtil.createJSONObject();
			if (Validator.isNotNull(examSchedule)) {

				if (Validator.isNotNull(examSchedule.getExamDate())) {
					//String examDate = omsbCommonApi.convertDateFormatToDDMMYYYY(examSchedule.getExamDate());
					emailContent = emailContent.replace("[examDate]", examSchedule.getExamDate());
				}

				if (Validator.isNotNull(examSchedule.getStartTime())) {
					emailContent = emailContent.replace("[examTime]", examSchedule.getStartTime());
				}
				if (Validator.isNotNull(examSchedule.getExamTypeName())) {
					emailTitle = emailTitle.replace("[ExamType]", examSchedule.getExamTypeName());
					emailContent = emailContent.replace("[ExamType]", examSchedule.getExamTypeName());
				}
			}
			notificationJSON.put("notificationText", emailTitle);
			notificationJSON.put("emailTitle", emailTitle);
			notificationJSON.put("emailContent", emailContent);

			UserNotificationEvent u = UserNotificationEventLocalServiceUtil.sendUserNotificationEvents(userId,
					OMSBExamWebPortletKeys.OMSBEXAMWEB, UserNotificationDeliveryConstants.TYPE_WEBSITE,
					notificationJSON);
			logger.info("SENDING NOTIFICATION ...." + u.getPayload());
			String email = Validator.isNotNull(userLocalService.fetchUser(userId))
					? userLocalService.fetchUser(userId).getEmailAddress()
					: "";
			sendEmail(email, emailTitle, emailContent);

		} catch (PortalException e) {
			logger.error(e.getMessage(), e);
		}
	}

	public void sendLRUserNotification(long groupId, long userId, String templateName, boolean sendEmail,
			ExamSchedule examSchedule) {

		logger.info("inside send email notification");
		JournalArticle article = null;
		try {
			article = JournalArticleLocalServiceUtil.getArticleByUrlTitle(groupId, templateName);
			String emailTitle = StringPool.BLANK;
			String emailContent = StringPool.BLANK;
			if (Validator.isNotNull(article)) {
				String content = article.getContentByLocale("en_US");
				emailTitle = examUtil.readXMLData(content, "emailTitle");
				emailContent = examUtil.readXMLData(content, "emailContent");
			}
			logger.info("emailTitle ?? " + emailTitle);
			logger.debug("emailContent ?? " + emailContent);
			JSONObject notificationJSON = JSONFactoryUtil.createJSONObject();
			if (Validator.isNotNull(examSchedule)) {

				if (Validator.isNotNull(examSchedule.getExamDate())) {
					//String examDate = omsbCommonApi.convertDateFormatToDDMMYYYY(examSchedule.getExamDate());
					emailContent = emailContent.replace("[examDate]", examSchedule.getExamDate());
				}
				if(Validator.isNotNull(examSchedule.getStartTime())) {
					emailContent = emailContent.replace("[examTime]", examSchedule.getStartTime());
				}
				if (Validator.isNotNull(examSchedule.getExamTypeName())) {
					emailTitle = emailTitle.replace("[ExamType]", examSchedule.getExamTypeName());
					emailContent = emailContent.replace("[ExamType]", examSchedule.getExamTypeName());
				}

				emailContent = emailContent.replace("[programId]", String.valueOf(examSchedule.getProgramId()));
				emailContent = emailContent.replace("[examTypeId]", String.valueOf(examSchedule.getExamType()));
				emailContent = emailContent.replace("[examScheduleId]", String.valueOf(examSchedule.getId()));

			}

			notificationJSON.put("notificationText", emailTitle);
			notificationJSON.put("emailTitle", emailTitle);
			notificationJSON.put("emailContent", emailContent);

			UserNotificationEvent u = UserNotificationEventLocalServiceUtil.sendUserNotificationEvents(userId,
					OMSBExamWebPortletKeys.OMSBEXAMWEB, UserNotificationDeliveryConstants.TYPE_WEBSITE,
					notificationJSON);
			logger.info("SENDING NOTIFICATION ...." + u.getPayload());
			String email = Validator.isNotNull(userLocalService.fetchUser(userId))
					? userLocalService.fetchUser(userId).getEmailAddress()
					: "";
			sendEmail(email, emailTitle, emailContent);

		} catch (PortalException e) {
			logger.error(e.getMessage(), e);
		}
	}

	public void sendExamWithdrawNotification(String templateName, long userId, long groupId, String programName,
			String examType) {
		JournalArticle article = null;
		try {
			article = JournalArticleLocalServiceUtil.getArticleByUrlTitle(groupId, templateName);

			String emailTitle = StringPool.BLANK;
			String emailContent = StringPool.BLANK;
			if (Validator.isNotNull(article)) {
				logger.debug("article..." + article.getArticleId());
				logger.debug("Content   ::: " + article.getContentByLocale("en_US"));
				String content = article.getContentByLocale("en_US");
				emailTitle = examUtil.readXMLData(content, "emailTitle");
				emailContent = examUtil.readXMLData(content, "emailContent");
				JSONObject notificationJSON = JSONFactoryUtil.createJSONObject();

				emailTitle = emailTitle.replace("{programName}", programName);
				emailTitle = emailTitle.replace("{examType}", examType);

				notificationJSON.put("emailTitle", emailTitle);
				notificationJSON.put("emailContent", emailContent);
				// send user Noditication
				userNotificationEventLocalService.sendUserNotificationEvents(userId, OMSBExamWebPortletKeys.OMSBEXAMWEB,
						UserNotificationDeliveryConstants.TYPE_WEBSITE, notificationJSON);

				logger.debug("email send succefully");
				// sending email
				User user = UserLocalServiceUtil.getUser(userId);

				omsbCommonApi.sendEmailNotification(MVCCommands.SENDER_EMAIL, user.getEmailAddress(), emailTitle,
						emailContent);
			}
		} catch (PortalException e) {
			e.printStackTrace();
		}

		/* notification End */
		catch (Exception e) {

		}

	}

	public String getPaymentRecieptContent(ThemeDisplay themeDisplay, long lrUserId, String templateName,
			ExamSchedule examSchedule, ExamPayment examPayment) {
		String htmlReciept = StringPool.BLANK;
		try {
			JournalArticle article = JournalArticleLocalServiceUtil.getArticleByUrlTitle(themeDisplay.getScopeGroupId(),
					templateName);
			htmlReciept = StringPool.BLANK;
			if (Validator.isNotNull(article)) {
				String content = article.getContentByLocale("en_US");
				htmlReciept = examUtil.readXMLData(content, "receipt");

				User user = UserLocalServiceUtil.getUser(lrUserId);
				PersonalDetailItem personalDetailItem = examUtil.getPersonalDetailsByUserId(themeDisplay, lrUserId);
				if (Validator.isNotNull(personalDetailItem) && Validator.isNotNull(personalDetailItem.getItems())
						&& !personalDetailItem.getItems().isEmpty()) {
					logger.info("personalDetailItem.getItems()::  " + personalDetailItem.getItems().size());
					PersonalDetail personalDetail = personalDetailItem.getItems().get(0);
					htmlReciept = htmlReciept.replace("[phoneNumber]", personalDetail.getMobileNumber());

					logger.info("phoneNumber::  " + personalDetail.getMobileNumber());

				}
				htmlReciept = htmlReciept.replace("[email]", user.getEmailAddress());
				htmlReciept = htmlReciept.replace("[candidateName]", user.getFullName());
				if(Validator.isNotNull(examSchedule)) {
					htmlReciept = htmlReciept.replace("[programName]", examSchedule.getProgramName());
					if(Validator.isNotNull(examSchedule.getExamDate())) {
						htmlReciept = htmlReciept.replace("[examDate]", examSchedule.getExamDate());
					}
					if(Validator.isNotNull(examSchedule.getApplicationStartDate())) {
						htmlReciept = htmlReciept.replace("[applicationDate]", omsbCommonApi.convertDateFormatToDDMMYYYY(examSchedule.getApplicationStartDate()));
					}
				}
				
				
				htmlReciept = htmlReciept.replace("[paymentDate]",
						omsbCommonApi.convertDateFormat(new SimpleDateFormat("dd/MM/yyyy ").format(new Date())));
				htmlReciept = htmlReciept.replace("[paymentNumber]", examPayment.getOrderId());
				if (Validator.isNotNull(examPayment.getFees())) {
					htmlReciept = htmlReciept.replace("[amountPaid]", String.valueOf(examPayment.getFees()));
				}
			}
		} catch (PortalException e) {
			logger.error(e);
		}

		return htmlReciept;
	}

	public void sendEmail(String toAddress, String subject, String body) {
		logger.info("sendEmail Invoked :::");
		try {
			InternetAddress from = new InternetAddress("testportal@omsb.org");
			InternetAddress to = new InternetAddress(toAddress);
			MailMessage mailMessage = new MailMessage();
			mailMessage.setFrom(from);
			mailMessage.setTo(to);
			mailMessage.setSubject(subject);
			mailMessage.setBody(body);
			mailMessage.setHTMLFormat(true);
			MailServiceUtil.sendEmail(mailMessage);
		} catch (AddressException e) {
			logger.error(e);
		}
		logger.info("sendEmail Exit :::");
	}

	private static final Log logger = LogFactoryUtil.getLog(ExamNotificationUtil.class);

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference
	private ExamUtil examUtil;

	@Reference
	UserNotificationEventLocalService userNotificationEventLocalService;

	@Reference
	private UserLocalService userLocalService;

}
