package gov.omsb.oct.exam.web.portlet.util;

import com.liferay.calendar.service.CalendarBookingLocalService;
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
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.dto.PersonalDetail;
import gov.omsb.common.dto.PersonalDetailItem;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.oct.exam.web.constants.OCTExamConstants;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamPayment;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamSchedule;
import gov.omsb.oct.exam.web.portlet.dto.OCTRegistration;
import gov.omsb.oct.exam.web.portlet.dto.OCTRegistrationItem;
import gov.omsb.oct.web.portlet.portlet.action.AddOCTExamScheduleMVCActionCommand;

@Component(immediate = true, service = OCTNotificationUtil.class)

public class OCTNotificationUtil {

	public void sendNotificationToUsers(String portalURL, String examStatus, long scopeGroupId, long companyId,
			Locale locale, long roleId, OCTExamSchedule octExamSchedule) {
		
		OCTRegistrationItem octRegistrationItem = octExamUtil.getRegistrationByScheduleId(portalURL,scopeGroupId, octExamSchedule.getId());
		List<OCTRegistration> registrations=new ArrayList<>();
		if(Validator.isNotNull(octRegistrationItem) && Validator.isNotNull(octRegistrationItem.getItems())) {
			registrations = octRegistrationItem.getItems();
		}
		try {

			for (OCTRegistration registration : registrations) {
				try {
					JournalArticle article = JournalArticleLocalServiceUtil.getArticleByUrlTitle(scopeGroupId, OCTExamConstants.OCT_EXAM_ANNOUNCEMENT);

//					logger.info("article..." + article.getArticleId());
//					logger.info("Content   ::: " + article.getContentByLocale("en_US"));

					String emailTitle = StringPool.BLANK;
					String emailContent = StringPool.BLANK;
					if (Validator.isNotNull(article)) {

						String content = article.getContentByLocale("en_US");
						emailTitle = readXMLData(content, "emailTitle");
						emailContent = readXMLData(content, "emailContent");
					}

					JSONObject notificationJSON = JSONFactoryUtil.createJSONObject();

					notificationJSON.put("notificationText", emailTitle);
					notificationJSON.put("emailTitle", emailTitle);
					notificationJSON.put("emailContent", emailContent);

					UserNotificationEvent u = UserNotificationEventLocalServiceUtil.sendUserNotificationEvents(
							registration.getLrUserId(), OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB, UserNotificationDeliveryConstants.TYPE_WEBSITE, notificationJSON);
					logger.info("SENDING NOTIFICATION ...." + u.getPayload());
					String email = Validator.isNotNull(userLocalService.fetchUser(registration.getLrUserId()))
							? userLocalService.fetchUser(registration.getLrUserId()).getEmailAddress()
									: "";
							sendEmail(email, emailTitle, emailContent);
				} catch (PortalException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {

		}
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




	private static String readXMLData(String content, String Key) {
		String fieldValue = StringPool.BLANK;
		try {
			Document document = SAXReaderUtil.read(content);

			Node node = document
					.selectSingleNode("/root/dynamic-element[@field-reference='" + Key + "']/dynamic-content");

			if (Validator.isNotNull(node)) {
				return fieldValue = node.getText();
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return fieldValue;

	}

	public void sendExamNotification(long groupID, long userId, String templateName) {
		logger.info("inside send email notification");
		JournalArticle article = null;
		try {
			article = JournalArticleLocalServiceUtil.getArticleByUrlTitle(groupID, templateName);
			String emailTitle = StringPool.BLANK;
			String emailContent = StringPool.BLANK;
			if (Validator.isNotNull(article)) {
				String content = article.getContentByLocale("en_US");
				emailTitle = octExamUtil.readXMLData(content, "emailTitle");
				emailContent = octExamUtil.readXMLData(content, "emailContent");
			}
			logger.info("emailTitle ?? " + emailTitle);
			logger.info("emailContent ?? " + emailContent);
			JSONObject notificationJSON = JSONFactoryUtil.createJSONObject();

			notificationJSON.put("notificationText", emailTitle);
			notificationJSON.put("emailTitle", emailTitle);
			notificationJSON.put("emailContent", emailContent);

			UserNotificationEvent u = UserNotificationEventLocalServiceUtil.sendUserNotificationEvents(userId,
					OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB, UserNotificationDeliveryConstants.TYPE_WEBSITE,
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
  public void SendRegistrationFailedNotification(ThemeDisplay themeDisplay, long userId, OCTExamSchedule octExamSchedule) {
	
	  logger.info("inside send email notification");
		JournalArticle article = null;
		try {
			article = JournalArticleLocalServiceUtil.getArticleByUrlTitle(themeDisplay.getScopeGroupId(), OCTExamConstants.OCT_EXAM_REGISTRATION_FAIL);
			String emailTitle = StringPool.BLANK;
			String emailContent = StringPool.BLANK;
			if (Validator.isNotNull(article)) {
				String content = article.getContentByLocale("en_US");
				emailTitle = octExamUtil.readXMLData(content, "emailTitle");
				emailContent = octExamUtil.readXMLData(content, "emailContent");
			}
			logger.info("emailTitle ?? " + emailTitle);
			logger.info("emailContent ?? " + emailContent);
			JSONObject notificationJSON = JSONFactoryUtil.createJSONObject();

			if (Validator.isNotNull(octExamSchedule)) {
				emailTitle=emailTitle.replace("[examTitle]", octExamSchedule.getOctExamTitleName());
				emailContent = emailContent.replace("[examTitle]", octExamSchedule.getOctExamTitleName());
			}
			notificationJSON.put("notificationText", emailTitle);
			notificationJSON.put("emailTitle", emailTitle);
			notificationJSON.put("emailContent", emailContent);

			UserNotificationEvent u = UserNotificationEventLocalServiceUtil.sendUserNotificationEvents(userId,
					OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB, UserNotificationDeliveryConstants.TYPE_WEBSITE,
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

  public  void SendRegistrationSuccessNotification(ThemeDisplay themeDisplay, long userId,  OCTExamSchedule octExamSchedule) {
	  logger.info("inside send email notification");
		JournalArticle article = null;
		try {
			article = JournalArticleLocalServiceUtil.getArticleByUrlTitle(themeDisplay.getScopeGroupId(), OCTExamConstants.OCT_EXAM_REGISTRATION_SUCCESS);
			String emailTitle = StringPool.BLANK;
			String emailContent = StringPool.BLANK;
			if (Validator.isNotNull(article)) {
				String content = article.getContentByLocale("en_US");
				emailTitle = octExamUtil.readXMLData(content, "emailTitle");
				emailContent = octExamUtil.readXMLData(content, "emailContent");
			}
			logger.info("emailTitle ?? " + emailTitle);
			logger.debug("emailContent ?? " + emailContent);
			JSONObject notificationJSON = JSONFactoryUtil.createJSONObject();
			if (Validator.isNotNull(octExamSchedule)) {
				emailTitle=emailTitle.replace("[examTitle]", octExamSchedule.getOctExamTitleName());
				emailContent = emailContent.replace("[examTitle]", octExamSchedule.getOctExamTitleName());
				if(Validator.isNotNull(octExamSchedule.getExamDate())) {
					String examDate = omsbCommonApi.convertDateFormatToDDMMYYYY(octExamSchedule.getExamDate());
					emailContent = emailContent.replace("[examDate]", examDate);
				}
				if(Validator.isNotNull(octExamSchedule.getExamTime())) {
					emailContent = emailContent.replace("[examTime]", octExamSchedule.getExamTime());
				}
			}
			notificationJSON.put("notificationText", emailTitle);
			notificationJSON.put("emailTitle", emailTitle);
			notificationJSON.put("emailContent", emailContent);

			UserNotificationEvent u = UserNotificationEventLocalServiceUtil.sendUserNotificationEvents(userId,
					OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB, UserNotificationDeliveryConstants.TYPE_WEBSITE,
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
  
  public void SendRescheduleFailedNotification(ThemeDisplay themeDisplay, long userId) {
		
	  logger.info("inside send email notification");
		JournalArticle article = null;
		try {
			article = JournalArticleLocalServiceUtil.getArticleByUrlTitle(themeDisplay.getScopeGroupId(), OCTExamConstants.OCT_RESCHEDULE_EXAM_FAIL_TEMPLATE);
			String emailTitle = StringPool.BLANK;
			String emailContent = StringPool.BLANK;
			if (Validator.isNotNull(article)) {
				String content = article.getContentByLocale("en_US");
				emailTitle = octExamUtil.readXMLData(content, "emailTitle");
				emailContent = octExamUtil.readXMLData(content, "emailContent");
			}
			logger.info("emailTitle ?? " + emailTitle);
			logger.info("emailContent ?? " + emailContent);
			JSONObject notificationJSON = JSONFactoryUtil.createJSONObject();

			notificationJSON.put("notificationText", emailTitle);
			notificationJSON.put("emailTitle", emailTitle);
			notificationJSON.put("emailContent", emailContent);

			UserNotificationEvent u = UserNotificationEventLocalServiceUtil.sendUserNotificationEvents(userId,
					OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB, UserNotificationDeliveryConstants.TYPE_WEBSITE,
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

  
  public void SendRescheduleSuccessNotification(ThemeDisplay themeDisplay, long userId) {
		
	  logger.info("inside send email notification");
		JournalArticle article = null;
		try {
			article = JournalArticleLocalServiceUtil.getArticleByUrlTitle(themeDisplay.getScopeGroupId(), OCTExamConstants.OCT_RESCHEDULE_EXAM_SUCCESS_TEMPLATE);
			String emailTitle = StringPool.BLANK;
			String emailContent = StringPool.BLANK;
			if (Validator.isNotNull(article)) {
				String content = article.getContentByLocale("en_US");
				emailTitle = octExamUtil.readXMLData(content, "emailTitle");
				emailContent = octExamUtil.readXMLData(content, "emailContent");
			}
			logger.info("emailTitle ?? " + emailTitle);
			logger.info("emailContent ?? " + emailContent);
			JSONObject notificationJSON = JSONFactoryUtil.createJSONObject();

			notificationJSON.put("notificationText", emailTitle);
			notificationJSON.put("emailTitle", emailTitle);
			notificationJSON.put("emailContent", emailContent);

			UserNotificationEvent u = UserNotificationEventLocalServiceUtil.sendUserNotificationEvents(userId,
					OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB, UserNotificationDeliveryConstants.TYPE_WEBSITE,
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

  public String getPaymentRecieptContent(ThemeDisplay themeDisplay, long userId, String templateName,
			OCTExamSchedule octExamSchedule, OCTExamPayment octExamPayment) {
	  String htmlReciept = StringPool.BLANK;
		try {
			JournalArticle article = JournalArticleLocalServiceUtil.getArticleByUrlTitle(themeDisplay.getScopeGroupId(),
					templateName);
			htmlReciept = StringPool.BLANK;
			if (Validator.isNotNull(article)) {
				String content = article.getContentByLocale("en_US");
				htmlReciept = octExamUtil.readXMLData(content, "receipt");

				User user = UserLocalServiceUtil.getUser(userId);
				PersonalDetailItem personalDetailItem = octExamUtil.getPersonalDetailsByUserId(themeDisplay, userId);
				if (Validator.isNotNull(personalDetailItem) && Validator.isNotNull(personalDetailItem.getItems())
						&& !personalDetailItem.getItems().isEmpty()) {
					logger.info("personalDetailItem.getItems()::  " + personalDetailItem.getItems().size());
					PersonalDetail personalDetail = personalDetailItem.getItems().get(0);
					htmlReciept = htmlReciept.replace("[phoneNumber]", personalDetail.getMobileNumber());

					logger.info("phoneNumber::  " + personalDetail.getMobileNumber());

				}
				htmlReciept = htmlReciept.replace("[email]", user.getEmailAddress());
				htmlReciept = htmlReciept.replace("[candidateName]", user.getFullName());
				if(Validator.isNotNull(octExamSchedule)) {
					htmlReciept = htmlReciept.replace("[examTitle]", octExamSchedule.getOctExamTitleName());
					if(Validator.isNotNull(octExamSchedule.getExamDate())) {
						String examDate = omsbCommonApi.convertDateFormatToDDMMYYYY(octExamSchedule.getExamDate());
						htmlReciept = htmlReciept.replace("[examDate]", examDate);
					}
				}
				htmlReciept = htmlReciept.replace("[paymentDate]",
						omsbCommonApi.convertDateFormat(new SimpleDateFormat("dd/MM/yyyy ").format(new Date())));
				htmlReciept = htmlReciept.replace("[paymentNumber]", octExamPayment.getOrderId());
				if (Validator.isNotNull(octExamPayment.getFees())) {
					htmlReciept = htmlReciept.replace("[amountPaid]", String.valueOf(octExamPayment.getFees()));
				}
			}
		} catch (PortalException e) {
			logger.error(e);
		}

		return htmlReciept;
	}
	
	@Reference(unbind = "-")
	private OMSBHttpConnector omsbHttpConnector;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference(unbind = "-")
	private OCTExamUtil octExamUtil;

	private static Log logger = LogFactoryUtil.getLog(OCTNotificationUtil.class);

	@Reference
	UserLocalService userLocalService;

	@Reference
	UserNotificationEventLocalService userNotificationEventLocalService;

	@Reference
	private CalendarBookingLocalService _calendarBookingLocalService;

	

}
