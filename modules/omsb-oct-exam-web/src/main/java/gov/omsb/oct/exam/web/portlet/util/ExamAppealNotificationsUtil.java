package gov.omsb.oct.exam.web.portlet.util;

import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.UserNotificationEventLocalService;
import com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.oct.exam.web.constants.OCTExamConstants;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;

@Component(immediate = true, property = {}, service = ExamAppealNotificationsUtil.class)
public class ExamAppealNotificationsUtil {

	public static void sendNotificationToUsers(String classPk, String companyId, String groupID, Long userId,
			String entryType, int roleId) throws PortalException {

		List<User> users = UserLocalServiceUtil.getRoleUsers(roleId);
		logger.info(users.get(0).getUserId());

		for (User user : users) {

			//
			JournalArticle article = null;
			try {
				article = JournalArticleLocalServiceUtil.getArticleByUrlTitle(Long.valueOf(groupID),
						OCTExamConstants.OMSB_EXAM_APPEAL);
				String emailTitle = StringPool.BLANK;
				String emailContent = StringPool.BLANK;
				if (Validator.isNotNull(article)) {
					String content = article.getContentByLocale("en_US");
					emailTitle = readXMLData(content, "emailTitle");
					emailContent = readXMLData(content, "emailContent");
				}

				JSONObject notificationJSON = JSONFactoryUtil.createJSONObject();

				notificationJSON.put(OmsbTmsCommonConstants.NOTIFICATION_TEXT, emailTitle);
				notificationJSON.put("emailContent", emailContent);

				UserNotificationEvent u = UserNotificationEventLocalServiceUtil.sendUserNotificationEvents(
						user.getUserId(), OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
						UserNotificationDeliveryConstants.TYPE_WEBSITE, notificationJSON);
				logger.info("SENDING NOTIFICATION ...." + u.getPayload());

			} catch (PortalException e) {
				logger.error(e.getMessage());
			}
		}
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

	private static final Log logger = LogFactoryUtil.getLog(ExamAppealNotificationsUtil.class);

	@Reference
	UserNotificationEventLocalService userNotificationEventLocalService;
}