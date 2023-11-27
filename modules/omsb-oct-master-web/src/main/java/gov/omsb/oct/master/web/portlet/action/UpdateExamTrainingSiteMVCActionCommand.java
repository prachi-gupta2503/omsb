package gov.omsb.oct.master.web.portlet.action;

import com.liferay.list.type.model.ListTypeDefinition;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeDefinitionLocalServiceUtil;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocaleUtil;
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
import gov.omsb.oct.master.web.constants.MVCCommandNames;
import gov.omsb.oct.master.web.constants.OCTMasterConstants;
import gov.omsb.oct.master.web.constants.OmsbOctMasterWebPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctMasterWebPortletKeys.OMSBOCTMASTERWEB,
		"mvc.command.name="
				+ MVCCommandNames.UPDATE_EXAM_TRAINING_SITE_MVC_ACTION_COMMAND, }, service = MVCActionCommand.class)
public class UpdateExamTrainingSiteMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		logger.info("save exam result action () started");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long siteId = ParamUtil.getLong(actionRequest, "siteId");
		int seatsObjectId = ParamUtil.getInteger(actionRequest, "seatsObjectId");
		String value_ar_SA = ParamUtil.getString(actionRequest, "siteValue_ar_SA","");
		String value_en_US = ParamUtil.getString(actionRequest, "siteValue_en_US");
		int seats = ParamUtil.getInteger(actionRequest, "seats");
		String statusId = ParamUtil.getString(actionRequest, "statusId");
		
		long objectId = ParamUtil.getLong(actionRequest, "objectId");
		long trainingSite = ParamUtil.getLong(actionRequest, "trainingSite");
		if (Validator.isNull(value_en_US) || Validator.isNull(seats)) {
			return false;
		} else {
			String key = value_en_US.toLowerCase().replace(StringPool.SPACE, StringPool.BLANK);
			Map<Locale, String> nameMap = new HashMap<>();
			Locale arLanguageLocale = LocaleUtil.fromLanguageId("ar_SA");
			Locale enLanguageLocale = LocaleUtil.fromLanguageId("en_US");

			nameMap.put(arLanguageLocale, value_ar_SA);
			nameMap.put(enLanguageLocale, value_en_US);

			ListTypeDefinition listTypeDefinition;
			try {
				if (Validator.isNotNull(siteId)) {
					listTypeDefinition = ListTypeDefinitionLocalServiceUtil
							.getListTypeDefinitionByExternalReferenceCode(
									OmsbOctMasterWebPortletKeys.TRAINING_SITE_PL_ERC, themeDisplay.getCompanyId());
					if (Validator.isNotNull(listTypeDefinition)) {
						ListTypeEntry listEntry = ListTypeEntryLocalServiceUtil.fetchListTypeEntry(siteId);
						if (Validator.isNotNull(listEntry)) {
							listEntry.setNameMap(nameMap);
							ListTypeEntryLocalServiceUtil.updateListTypeEntry(listEntry);
						}
					}
					// updating object
					if (Validator.isNotNull(seatsObjectId)) {
						Map<String, Serializable> values = new HashMap<>();
						values.put(OCTMasterConstants.TRAINING_SITE_KEY, siteId);
						values.put(OCTMasterConstants.SITE_SEATS, seats);
						values.put(OCTMasterConstants.OC_STATUS_ID, statusId);
						if (seatsObjectId == 0) {
							omsbCommonApi.addObjectEntryByERC(OCTMasterConstants.OC_TRAINING_SITE_ERC, values,
									actionRequest, themeDisplay);
						} else {
							omsbCommonApi.updateObjectEntryByERC(OCTMasterConstants.OC_TRAINING_SITE_ERC, values,
									actionRequest, themeDisplay, seatsObjectId);

						}
					}
				} else {
					//for saving data
					long trainingSiteKey = 0l;
					listTypeDefinition = ListTypeDefinitionLocalServiceUtil
							.getListTypeDefinitionByExternalReferenceCode(
									OmsbOctMasterWebPortletKeys.TRAINING_SITE_PL_ERC, themeDisplay.getCompanyId());

					if (Validator.isNotNull(listTypeDefinition)) {
						ListTypeEntry examTitleEntry = ListTypeEntryLocalServiceUtil.addListTypeEntry(null, themeDisplay.getUserId(),
								listTypeDefinition.getListTypeDefinitionId(), key, nameMap);
						trainingSiteKey = examTitleEntry.getListTypeEntryId();
					}
					if (trainingSiteKey > 0) {
						logger.info("SEATS ================" + seats);
						Map<String, Serializable> values = new HashMap<>();
						values.put(OCTMasterConstants.TRAINING_SITE_KEY, trainingSiteKey);
						values.put(OCTMasterConstants.SITE_SEATS, seats);
						values.put(OCTMasterConstants.OC_STATUS_ID, statusId);
						omsbCommonApi.addObjectEntryByERC(OCTMasterConstants.OC_TRAINING_SITE_ERC, values, actionRequest,
								themeDisplay);
					}

					
				}
			} catch (PortalException e) {
				logger.error(e.getMessage());
			}
		}
		actionRequest.setAttribute("siteId", 0);
		actionResponse.getRenderParameters().setValue("siteId", "0");
		logger.info("end of action method================");
		return true;
	}
	
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
	private static final Log logger = LogFactoryUtil.getLog(UpdateExamTrainingSiteMVCActionCommand.class);
}