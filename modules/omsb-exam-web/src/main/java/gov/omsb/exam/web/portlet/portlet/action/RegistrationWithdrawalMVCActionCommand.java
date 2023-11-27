package gov.omsb.exam.web.portlet.portlet.action;

import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.exam.web.portlet.constants.MVCCommands;
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;
import gov.omsb.exam.web.portlet.dto.RegistrationItem;
import gov.omsb.exam.web.portlet.util.ExamUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OMSBExamWebPortletKeys.OMSBEXAMWEB,
		"mvc.command.name=" + MVCCommands.EXAM_WITHDRAWAL_ACTION }, service = MVCActionCommand.class)

public class RegistrationWithdrawalMVCActionCommand extends BaseMVCActionCommand {

	
	@Override
	protected void  doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {

		
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long lrUserId = ParamUtil.getLong(actionRequest, OMSBExamWebPortletKeys.LRUSER_ID);
		if (lrUserId <= 0) {
			lrUserId = themeDisplay.getUserId();
		}
		long examScheduleId = ParamUtil.getLong(actionRequest, OMSBExamWebPortletKeys.EXAM_SCHEDULE_ID);

		try {

			RegistrationItem octRestrationItem = examUtil.getRegistrationByUserIdAndScheduleId(themeDisplay.getPortalURL(),themeDisplay.getScopeGroupId(),
					lrUserId, examScheduleId);
			if (Validator.isNotNull(octRestrationItem) &&Validator.isNotNull(octRestrationItem.getItems())&& !octRestrationItem.getItems().isEmpty()) {
				Map<String, Serializable> registrationMap = new HashMap();
				ListTypeEntry listTypeEntryByListTypeItemKey = omsbCommonApi.getListTypeEntryByListTypeItemKey(
						LRPicklistConstants.OCT_EXAM_REG_STATUS, "withdrawn", themeDisplay.getCompanyId());
				int noOfAttempt = noOfAttempts(themeDisplay, lrUserId, examScheduleId);
				registrationMap.put(OMSBExamWebPortletKeys.REGISTRATION_STATUS, listTypeEntryByListTypeItemKey.getName(Locale.getDefault()));
				registrationMap.put(OMSBExamWebPortletKeys.NO_OF_ATTEMPT, noOfAttempt);
				
				omsbCommonApi.updateObjectEntryByERC(OMSBExamWebPortletKeys.OB_EXAM_REGISTRATION_ERC,
						registrationMap, actionRequest, themeDisplay, octRestrationItem.getItems().get(0).getId());

				if(logger.isDebugEnabled()) {
					logger.debug("Registration withdrawl successfully");
				}
				
				SessionMessages.add(actionRequest, "Registration withdrawal successfully");
			}
		}catch(Exception e) {
			if(logger.isDebugEnabled()) {
				logger.debug("Registration withdrawal fail");
			}
			SessionMessages.add(actionRequest, "Registration withdrawal fail");
		}

		
	}
	private int noOfAttempts(ThemeDisplay themeDisplay, long lrUserId, long ocExamScheduleId) {
		try {
			// long userId = themeDisplay.getUserId();
			RegistrationItem reg = examUtil.getRegistrationByUserIdAndScheduleId(themeDisplay.getPortalURL(),themeDisplay.getScopeGroupId(), lrUserId,
					ocExamScheduleId);
			if (Validator.isNotNull(reg) && Validator.isNotNull(reg.getItems()) && !(reg.getItems()).isEmpty()) {
				int noOfAttempt = reg.getItems().get(0).getNoOfAttempt();
				logger.debug("no of attempt :::" + noOfAttempt);
				noOfAttempt--;
				return noOfAttempt;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return 1;
	}
	
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
	
	@Reference
	private ExamUtil examUtil;

	

	private static final Log logger = LogFactoryUtil.getLog(RegistrationWithdrawalMVCActionCommand.class);


}