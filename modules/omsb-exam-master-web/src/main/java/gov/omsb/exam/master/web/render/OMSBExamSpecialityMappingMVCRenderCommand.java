package gov.omsb.exam.master.web.render;

import com.liferay.list.type.model.ListTypeDefinition;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeDefinitionLocalServiceUtil;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
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
import gov.omsb.exam.master.web.constants.MVCCommandNames;
import gov.omsb.exam.master.web.constants.OmsbExamMasterWebPortletKeys;
import gov.omsb.exam.master.web.portlet.dto.OMSBExamSpeciality;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbExamMasterWebPortletKeys.OMSBEXAMMASTERWEB,
		"mvc.command.name=" + MVCCommandNames.OMSB_EXAM_SPECIALITY_MAPPING_RENDER, }, service = MVCRenderCommand.class)

public class OMSBExamSpecialityMappingMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		List<OMSBExamSpeciality> listOmsbSpeciality = new ArrayList<OMSBExamSpeciality>();
		List<OMSBExamSpeciality> listOmsbSubSpeciality = new ArrayList<OMSBExamSpeciality>();
		ListTypeDefinition listTypeDefinitionSpeciality;
		ListTypeDefinition listTypeDefinitionSubSpeciality;
		try {
			listTypeDefinitionSpeciality = ListTypeDefinitionLocalServiceUtil
					.getListTypeDefinitionByExternalReferenceCode(OmsbExamMasterWebPortletKeys.SPECIALITY_MASTER_PL_ERC,
							themeDisplay.getCompanyId());

			listTypeDefinitionSubSpeciality = ListTypeDefinitionLocalServiceUtil
					.getListTypeDefinitionByExternalReferenceCode(
							OmsbExamMasterWebPortletKeys.SUB_SPECIALITY_MASTER_PL_ERC, themeDisplay.getCompanyId());

			if (Validator.isNotNull(listTypeDefinitionSpeciality)) {

				List<ListTypeEntry> listEntriesSpeciality = ListTypeEntryLocalServiceUtil
						.getListTypeEntries(listTypeDefinitionSpeciality.getListTypeDefinitionId(), -1, -1);

				List<String> languageCodes = new ArrayList<>();
				languageCodes.add(CommonConstants.LANGUAGE_CODE_ENGLISH);
				languageCodes.add(CommonConstants.LANGUAGE_CODE_ARABIC);

				for (ListTypeEntry entry : listEntriesSpeciality) {
					String key = entry.getKey();
					String en_Name = StringPool.BLANK, ar_Name = StringPool.BLANK;
					Map<Locale, String> nameMap = entry.getNameMap();
					Locale en_LanguageLocale = LocaleUtil.fromLanguageId(CommonConstants.LANGUAGE_CODE_ENGLISH);
					en_Name = nameMap.get(en_LanguageLocale);

					Locale ar_LanguageLocale = LocaleUtil.fromLanguageId(CommonConstants.LANGUAGE_CODE_ARABIC);
					ar_Name = nameMap.get(ar_LanguageLocale);

					OMSBExamSpeciality octNewTrainingSite = new OMSBExamSpeciality();
					octNewTrainingSite.setKey(key);
					octNewTrainingSite.setNameArabic(ar_Name);
					octNewTrainingSite.setNameEnglish(en_Name);
					octNewTrainingSite.setExternalReferenceCode(entry.getExternalReferenceCode());
					octNewTrainingSite.setId(entry.getListTypeEntryId());
					listOmsbSpeciality.add(octNewTrainingSite);
				}
			}

			// sub speciality
			if (Validator.isNotNull(listTypeDefinitionSubSpeciality)) {

				List<ListTypeEntry> listEntriesSubSpeciality = ListTypeEntryLocalServiceUtil
						.getListTypeEntries(listTypeDefinitionSubSpeciality.getListTypeDefinitionId(), -1, -1);

				List<String> languageCodes = new ArrayList<>();
				languageCodes.add(CommonConstants.LANGUAGE_CODE_ENGLISH);
				languageCodes.add(CommonConstants.LANGUAGE_CODE_ARABIC);

				for (ListTypeEntry entry : listEntriesSubSpeciality) {
					String key = entry.getKey();
					String en_Name = "", ar_Name = "";
					Map<Locale, String> nameMap = entry.getNameMap();
					Locale en_LanguageLocale = LocaleUtil.fromLanguageId(CommonConstants.LANGUAGE_CODE_ENGLISH);
					en_Name = nameMap.get(en_LanguageLocale);

					Locale ar_LanguageLocale = LocaleUtil.fromLanguageId(CommonConstants.LANGUAGE_CODE_ARABIC);
					ar_Name = nameMap.get(ar_LanguageLocale);

					OMSBExamSpeciality octNewTrainingSite = new OMSBExamSpeciality();
					octNewTrainingSite.setKey(key);
					octNewTrainingSite.setNameArabic(ar_Name);
					octNewTrainingSite.setNameEnglish(en_Name);
					octNewTrainingSite.setExternalReferenceCode(entry.getExternalReferenceCode());
					octNewTrainingSite.setId(entry.getListTypeEntryId());
					listOmsbSubSpeciality.add(octNewTrainingSite);
				}
			}
			renderRequest.setAttribute("listOmsbSpeciality", listOmsbSpeciality);
			renderRequest.setAttribute("listOmsbSubSpeciality", listOmsbSubSpeciality);

		} catch (PortalException e) {
			logger.error(e.getMessage());
		}
		return OmsbExamMasterWebPortletKeys.OMSB_EXAM_SPECIALITY_MAPPING_JSP;
	}

	private static final Log logger = LogFactoryUtil.getLog(OMSBExamSpecialityMappingMVCRenderCommand.class);

}
