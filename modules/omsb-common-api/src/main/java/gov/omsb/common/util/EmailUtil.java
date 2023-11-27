package gov.omsb.common.util;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringUtil;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import gov.omsb.common.dto.EmailObjects;
import gov.omsb.email.config.configuration.action.OmsbFromEmailConfigurationAction;

public class EmailUtil {
	private static final Log _log = LogFactoryUtil.getLog(EmailUtil.class);
	
	 private EmailUtil() {}
	
	public static void sendEmail(EmailObjects emailObjects) {
		_log.info("sendEmail Invoked :::");
		try {
			InternetAddress from = new InternetAddress(OmsbFromEmailConfigurationAction.fromAdminEmail());
			_log.info(emailObjects.getToAddress());
			InternetAddress to = new InternetAddress(emailObjects.getToAddress());
			MailMessage mailMessage = new MailMessage();
			mailMessage.setFrom(from);
			mailMessage.setTo(to);
			mailMessage.setSubject(emailObjects.getSubject());
			mailMessage.setBody(emailObjects.getBody());
			mailMessage.setHTMLFormat(true);
			MailServiceUtil.sendEmail(mailMessage);
		} catch (AddressException e) {
			_log.error(e);
		}
		_log.info("sendEmail Exit :::");
	}
	
	public static void sendEmailNotification(EmailObjects emailObjects){
        String subject = StringUtil.replace(emailObjects.getSubject(), emailObjects.getOldSubstitute() , emailObjects.getNewSubstitute());
        String body = StringUtil.replace(emailObjects.getBody(), emailObjects.getOldSubstitute() , emailObjects.getNewSubstitute());
        emailObjects.setSubject(subject);
        emailObjects.setBody(body);
        EmailUtil.sendEmail(emailObjects);
        
    }
}
