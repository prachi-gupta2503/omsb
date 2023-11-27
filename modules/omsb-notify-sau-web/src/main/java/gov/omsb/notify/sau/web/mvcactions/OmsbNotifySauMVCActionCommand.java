package gov.omsb.notify.sau.web.mvcactions;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import gov.omsb.notify.sau.web.constants.OmsbNotifySauWebPortletKeys;
import gov.omsb.notify.sau.web.util.OmsbNotifyToSauUtil;
import gov.omsb.tms.custom.dto.NotifySauDetailsDTO;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbNotifySauWebPortletKeys.OMSBNOTIFYSAUWEB,
		"mvc.command.name=" + OmsbNotifySauWebPortletKeys.NOTIFY_SAU_USER_ACTION }, service = MVCActionCommand.class)
public class OmsbNotifySauMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		_logger.debug("doProcessAction called");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long[] sauUserList = ParamUtil.getLongValues(actionRequest, "notifySau");
		int currentCapacity = ParamUtil.getInteger(actionRequest, "currentCapacity");
		int requiredCapacity = ParamUtil.getInteger(actionRequest, "requestedCapacity");
		long fromUserId = ParamUtil.getLong(actionRequest, "currentUser");
		long trainingSiteId = ParamUtil.getLong(actionRequest, "trainingSiteId");
		
		_logger.info("doProcessAction ::: SAU Users Ids are below :::  ");	
		for(long id : sauUserList) {
			_logger.info("doProcessAction ::: SAU Users Id :::  " + id);	
		}
		
		NotifySauDetailsDTO notifySauDetailsDTO = new NotifySauDetailsDTO();
		
		notifySauDetailsDTO.setSauUserIds(sauUserList);
		notifySauDetailsDTO.setCurrentCapacity(currentCapacity);
		notifySauDetailsDTO.setRequiredCapacity(requiredCapacity);
		notifySauDetailsDTO.setFromUserId(themeDisplay.getUserId());
		notifySauDetailsDTO.setTrainingSiteId(trainingSiteId);

		OmsbNotifyToSauUtil.prepareNotificationMessage(notifySauDetailsDTO);
		OmsbNotifyToSauUtil.prepareMailMessage(notifySauDetailsDTO);
	}

	private static final Log _logger = LogFactoryUtil.getLog(OmsbNotifySauMVCActionCommand.class.getName());
}
