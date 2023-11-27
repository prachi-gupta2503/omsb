package gov.omsb.oct.master.web.portlet.render;

import com.liferay.list.type.model.ListTypeDefinition;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeDefinitionLocalServiceUtil;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.oct.master.web.constants.MVCCommandNames;
import gov.omsb.oct.master.web.constants.OmsbOctMasterWebPortletKeys;
import gov.omsb.oct.master.web.portlet.dto.OCTNewTrainingSite;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctMasterWebPortletKeys.OMSBOCTMASTERWEB,
		"mvc.command.name=" + MVCCommandNames.OCT_TRAINING_SITE_SLOT_MAPPING_RENDER, }, service = MVCRenderCommand.class)

public class OCTExamTrainingSiteSlotMappingMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		List<OCTNewTrainingSite> listOctTrainingSite = new ArrayList<OCTNewTrainingSite>();
		ListTypeDefinition listTypeDefinition;
		try {
			listTypeDefinition = ListTypeDefinitionLocalServiceUtil.getListTypeDefinitionByExternalReferenceCode(
					OmsbOctMasterWebPortletKeys.TRAINING_SITE_PL_ERC, themeDisplay.getCompanyId());
			if (Validator.isNotNull(listTypeDefinition)) {

				List<ListTypeEntry> listEntries = ListTypeEntryLocalServiceUtil
						.getListTypeEntries(listTypeDefinition.getListTypeDefinitionId(), -1, -1);

				List<String> languageCodes = new ArrayList<>();
				languageCodes.add(CommonConstants.LANGUAGE_CODE_ENGLISH);
				languageCodes.add(CommonConstants.LANGUAGE_CODE_ARABIC);

				for (ListTypeEntry entry : listEntries) {
					String key = entry.getKey();
					String en_Name = "", ar_Name = "";
					Map<Locale, String> nameMap = entry.getNameMap();
					Locale en_LanguageLocale = LocaleUtil.fromLanguageId(CommonConstants.LANGUAGE_CODE_ENGLISH);
					en_Name = nameMap.get(en_LanguageLocale);

					Locale ar_LanguageLocale = LocaleUtil.fromLanguageId(CommonConstants.LANGUAGE_CODE_ARABIC);
					ar_Name = nameMap.get(ar_LanguageLocale);

					OCTNewTrainingSite octNewTrainingSite = new OCTNewTrainingSite();
					octNewTrainingSite.setKey(key);				
					octNewTrainingSite.setNameArabic(ar_Name);
					octNewTrainingSite.setNameEnglish(en_Name);
					octNewTrainingSite.setExternalReferenceCode(entry.getExternalReferenceCode());
					octNewTrainingSite.setId(entry.getListTypeEntryId());
					listOctTrainingSite.add(octNewTrainingSite);
				}
			}
			renderRequest.setAttribute("listOctTrainingSite", listOctTrainingSite);

		} catch (PortalException e) {
			logger.error(e.getMessage());
		}
		return OmsbOctMasterWebPortletKeys.OCT_TRAINING_SITE_SLOT_MAPPING_JSP;
	}

	private static final Log logger = LogFactoryUtil.getLog(OCTExamTrainingSiteSlotMappingMVCRenderCommand.class);

}
