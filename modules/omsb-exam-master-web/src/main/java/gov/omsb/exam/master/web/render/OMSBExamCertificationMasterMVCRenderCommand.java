package gov.omsb.exam.master.web.render;

import com.liferay.list.type.model.ListTypeDefinition;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeDefinitionLocalServiceUtil;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.CountryLocalServiceUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

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
		"mvc.command.name=" + MVCCommandNames.OMSB_CERTIFICATION_MASTER_RENDER, }, service = MVCRenderCommand.class)

public class OMSBExamCertificationMasterMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		ListTypeDefinition definition = null;
		List<OMSBExamSpeciality> listCategories = new ArrayList<OMSBExamSpeciality>();

		try {

			definition = ListTypeDefinitionLocalServiceUtil.getListTypeDefinitionByExternalReferenceCode(
					OmsbExamMasterWebPortletKeys.PL_EXAM_CATEGORY_ERC, PortalUtil.getDefaultCompanyId());

			if (Validator.isNotNull(definition)) {

				List<ListTypeEntry> listEntriesSpeciality = ListTypeEntryLocalServiceUtil
						.getListTypeEntries(definition.getListTypeDefinitionId(), -1, -1);

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
					listCategories.add(octNewTrainingSite);
				}

			}

			List<com.liferay.portal.kernel.model.Country> countries = CountryLocalServiceUtil
					.getCountries(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			if (Validator.isNotNull(countries)) {
				renderRequest.setAttribute("countries", countries);
			}

			renderRequest.setAttribute("listCategories", listCategories);

		} catch (PortalException e) {
			logger.error(e.getMessage());
		}
		return OmsbExamMasterWebPortletKeys.OMSB_CERTIFICATION_MASTER_JSP;
	}

	private static final Log logger = LogFactoryUtil.getLog(OMSBInstitutionMasterMVCRenderCommand.class);

}
