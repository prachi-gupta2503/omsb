package gov.omsb.form.builder.portlet.util;

import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class EmailUtil {
	
	private static final Log log = LogFactoryUtil.getLog(EmailUtil.class);
	
	public static void sendEmail(String fromAddress, String toAddress, String subject, String body) {
		
		try {
			InternetAddress from = new InternetAddress(fromAddress);
			InternetAddress to = new InternetAddress(toAddress);
			MailMessage mailMessage = new MailMessage();
			mailMessage.setFrom(from);
			mailMessage.setTo(to);
			mailMessage.setSubject(subject);
			mailMessage.setBody(body);
			mailMessage.setHTMLFormat(true);
			MailServiceUtil.sendEmail(mailMessage);
		} catch (AddressException e) {
			log.error("Error While Sending EMail :: " + e.getMessage());
		}
		
		log.info("Email Sent Successfully");
		
	}

}
