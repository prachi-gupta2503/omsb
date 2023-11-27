package gov.osmb.dashboard.notification.portlet;

import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.util.DLURLHelperUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.UserNotificationEventLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.osmb.dashboard.notification.constants.OmsbDashboardNotificationPortletKeys;
import gov.osmb.dashboard.notification.dto.NotificationDto;

/**
 * @author AdjLT3
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=OmsbDashboardNotification", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + OmsbDashboardNotificationPortletKeys.OMSBDASHBOARDNOTIFICATION,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class OmsbDashboardNotificationPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			List<UserNotificationEvent> letestNotifications = getLetestNotifications(themeDisplay.getUserId());
			log.debug("letestNotifications" + letestNotifications);
			List<NotificationDto> notifications = new ArrayList<>();
			for (UserNotificationEvent userNotificationEvent : letestNotifications) {
				String payload = userNotificationEvent.getPayload();
				JSONObject payloadJSON = JSONFactoryUtil.createJSONObject(payload);

				NotificationDto notification = new NotificationDto();
				log.debug("payload " + payloadJSON.getString(OmsbDashboardNotificationPortletKeys.NOTIFICATION_TEXT));

				boolean notificationText = payloadJSON.has(OmsbDashboardNotificationPortletKeys.NOTIFICATION_TEXT);
				boolean notificationMessage = payloadJSON.has(OmsbDashboardNotificationPortletKeys.NOTIFICATION_MESSAGE);
				boolean emailTitle = payloadJSON.has(OmsbDashboardNotificationPortletKeys.EMAIL_TITLE);
				
				log.debug("notificationText boolean" + notificationText);
				boolean emailContent = payloadJSON.has(OmsbDashboardNotificationPortletKeys.EMAIL_CONTENT);
				if (emailContent) {
					notification.setEmailContent(payloadJSON.getString(OmsbDashboardNotificationPortletKeys.EMAIL_CONTENT));
				}
				if (notificationText) {
					notification.setNotificationText(payloadJSON.getString(OmsbDashboardNotificationPortletKeys.NOTIFICATION_TEXT));
				}else if(notificationMessage) {
					notification.setNotificationText(payloadJSON.getString(OmsbDashboardNotificationPortletKeys.NOTIFICATION_MESSAGE));
				}else if(emailTitle) {
					notification.setNotificationText(payloadJSON.getString(OmsbDashboardNotificationPortletKeys.EMAIL_TITLE));
				}

				long timestamp = userNotificationEvent.getTimestamp();
				Date dateTime = new Date(timestamp);
				log.info("dateTime" + dateTime);

				notification.setDateTime(setDateTime(timestamp, themeDisplay.getLocale()));
				try {
					log.debug("themeDisplay.getUser().getPortraitId()  "+ themeDisplay.getUser().getPortraitId());
					FileEntry entry = DLAppLocalServiceUtil.getFileEntry(themeDisplay.getUser().getPortraitId());
					//DLAppLocalServiceUtil.get
					log.debug("entry "+ entry);
					if (Validator.isNotNull(entry)) {

						String imageUrl = DLURLHelperUtil.getPreviewURL(entry, entry.getFileVersion(), themeDisplay,
								"");
						log.debug("imageUrl" + imageUrl);
						notification.setImage(imageUrl);
					}
				} catch (Exception e) {
					log.error("profile image not found");
				}

				notifications.add(notification);
			}

			renderRequest.setAttribute("notifications", notifications);
			super.render(renderRequest, renderResponse);
		} catch (

		Exception e) {
			log.error(e.getMessage());
		}

	}

	private List<UserNotificationEvent> getLetestNotifications(long userId) {
		try {

			DynamicQuery dynamicQuery = userNotificationEventLocalService.dynamicQuery();

			dynamicQuery.add(PropertyFactoryUtil.forName("userId").eq(userId));
			Order orderByCreateDateDesc = OrderFactoryUtil.desc("userNotificationEventId");
			dynamicQuery.addOrder(orderByCreateDateDesc);
			dynamicQuery.setLimit(0, 5); // Limit the result to the latest 5 notifications
			List<UserNotificationEvent> userNotificationEvents = userNotificationEventLocalService
					.dynamicQuery(dynamicQuery);
			return userNotificationEvents;
		} catch (Exception e) {
			log.error(e.getMessage());
		}

		return null;

	}

	private String setDateTime(long timestamp, Locale locale) {
		Instant instant = Instant.ofEpochMilli(timestamp);
		LocalDateTime currentDate = LocalDateTime.now();
		LocalDateTime dateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
		Duration duration = Duration.between(dateTime, currentDate);
		long daysDifference = ChronoUnit.DAYS.between(dateTime.toLocalDate(), currentDate.toLocalDate());
		long hoursDiff = duration.toHours();
		long minutesDiff = duration.toMinutes() % 60;

		if (daysDifference > 0) {
			return omsbCommonApi.convertDateToDDMMYYYYString(new Date(timestamp));
		} else if (hoursDiff > 0) {
			return LanguageUtil.format(locale, "about-hour-ago", hoursDiff);
		} else {
			if (minutesDiff > 1) {
				return LanguageUtil.format(locale, "about-minute-ago", hoursDiff);
			}
			return LanguageUtil.get(locale, "about-a-minute-ago");
		}

	}

	@Reference
	UserNotificationEventLocalService userNotificationEventLocalService;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	private final Log log = LogFactoryUtil.getLog(OmsbDashboardNotificationPortlet.class);
}