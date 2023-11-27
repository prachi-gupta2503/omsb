package omsb.vehpc.equivalency.util;

import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletRequestModel;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = NotificationUtil.class)
public class NotificationUtil {
	private static final String NOTIFICATION_TEMPLATE = "vehpc-notification";
	
	public void getNotificationContent(ThemeDisplay themeDisplay, PortletRequest portletRequest, PortletResponse portletResponse) {
		try {
		JournalArticle article = journalArticleLocalService.getLatestArticleByUrlTitle(themeDisplay.getScopeGroupId(), 
				NOTIFICATION_TEMPLATE, WorkflowConstants.STATUS_APPROVED);
		PortletRequestModel portletRequestModel = new PortletRequestModel(portletRequest, portletResponse);
		if (Validator.isNotNull(article)) {
			String content = article.getContentByLocale("ar_SA");
			logger.info("language is ?? " + themeDisplay.getLocale().getLanguage() );
			logger.info("content is ?? " + content );
		}
		} catch (PortalException e) {
			logger.error("Excpetion while getting the journal article ::", e);
		}
	}
	
	@Reference
	private JournalArticleLocalService journalArticleLocalService;
	
	private static final Log logger = LogFactoryUtil.getLog(NotificationUtil.class);
}
