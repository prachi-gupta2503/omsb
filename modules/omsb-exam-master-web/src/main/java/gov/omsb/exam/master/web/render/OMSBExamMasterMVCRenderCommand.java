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
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
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
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.common.util.CommonUtil;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.exam.master.web.constants.MVCCommandNames;
import gov.omsb.exam.master.web.constants.OmsbExamMasterWebPortletKeys;
import gov.omsb.exam.master.web.portlet.dto.ExamType;
import gov.omsb.exam.master.web.portlet.dto.ExamTypeEligibilityMapping;
import gov.omsb.exam.master.web.portlet.dto.ExamTypeEligibilityMappingItem;
import gov.omsb.exam.master.web.portlet.dto.ExamTypeItem;
import gov.omsb.exam.master.web.portlet.dto.OMSBExamSpeciality;
import gov.omsb.exam.master.web.portlet.dto.ProgramExamType;
import gov.omsb.exam.master.web.portlet.dto.ProgramExamTypeItems;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.tms.model.ProgramTypeMaster;
import gov.omsb.tms.service.ProgramTypeMasterLocalServiceUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbExamMasterWebPortletKeys.OMSBEXAMMASTERWEB,
		"mvc.command.name=/", }, service = MVCRenderCommand.class)
public class OMSBExamMasterMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		logger.info("render method started");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
//		getexamTypeEligibilities(themeDisplay);
		List<OMSBExamSpeciality> listSpecialityMaster = new ArrayList<OMSBExamSpeciality>();
		ListTypeDefinition listTypeDefinition;

		long titleId = ParamUtil.getLong(renderRequest, "titleId");
		try {
			if (Validator.isNotNull(titleId) && titleId > 0) {
				ListTypeEntry listEntry = ListTypeEntryLocalServiceUtil.getListTypeEntry(titleId);
				if (Validator.isNotNull(listEntry)) {
					renderRequest.setAttribute("titleId", titleId);
					renderRequest.setAttribute("titleNameMap", listEntry.getName());
					
				}
			}
			listTypeDefinition = ListTypeDefinitionLocalServiceUtil.getListTypeDefinitionByExternalReferenceCode(
					OmsbExamMasterWebPortletKeys.SPECIALITY_MASTER_PL_ERC, themeDisplay.getCompanyId());
			if (Validator.isNotNull(listTypeDefinition)) {
				List<ListTypeEntry> listEntries = ListTypeEntryLocalServiceUtil
						.getListTypeEntries(listTypeDefinition.getListTypeDefinitionId(), -1, -1);

				List<String> languageCodes = new ArrayList<>();
				languageCodes.add(CommonConstants.LANGUAGE_CODE_ENGLISH);
				languageCodes.add(CommonConstants.LANGUAGE_CODE_ARABIC);

				for (ListTypeEntry entry : listEntries) {
					String key = entry.getKey();
					String en_Name = StringPool.BLANK, ar_Name = StringPool.BLANK;
					Map<Locale, String> nameMap = entry.getNameMap();
					Locale en_LanguageLocale = LocaleUtil.fromLanguageId(CommonConstants.LANGUAGE_CODE_ENGLISH);
					en_Name = nameMap.get(en_LanguageLocale);

					Locale ar_LanguageLocale = LocaleUtil.fromLanguageId(CommonConstants.LANGUAGE_CODE_ARABIC);
					ar_Name = nameMap.get(ar_LanguageLocale);

					OMSBExamSpeciality omsbSpecialityMaster = new OMSBExamSpeciality();
					omsbSpecialityMaster.setKey(key);
					omsbSpecialityMaster.setNameArabic(ar_Name);
					omsbSpecialityMaster.setNameEnglish(en_Name);
					omsbSpecialityMaster.setExternalReferenceCode(entry.getExternalReferenceCode());
					omsbSpecialityMaster.setId(entry.getListTypeEntryId());
					listSpecialityMaster.add(omsbSpecialityMaster);
				}

			}
			renderRequest.setAttribute("listSpecialityMaster", listSpecialityMaster);
			// Speciality Mapping Render Command
			List<OMSBExamSpeciality> listOmsbSpeciality = new ArrayList<OMSBExamSpeciality>();
			List<OMSBExamSpeciality> listOmsbSubSpeciality = new ArrayList<OMSBExamSpeciality>();
			ListTypeDefinition listTypeDefinitionSpeciality;
			ListTypeDefinition listTypeDefinitionSubSpeciality;

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

			/// Institution Render Command

			ListTypeDefinition definition = null;
			List<OMSBExamSpeciality> listUniversity = new ArrayList<OMSBExamSpeciality>();
			definition = ListTypeDefinitionLocalServiceUtil.getListTypeDefinitionByExternalReferenceCode(
					OmsbExamMasterWebPortletKeys.PL_UNIVERSITY_ERC, PortalUtil.getDefaultCompanyId());

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
					listUniversity.add(octNewTrainingSite);
				}

			}

			List<com.liferay.portal.kernel.model.Country> countries = CountryLocalServiceUtil
					.getCountries(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			if (Validator.isNotNull(countries)) {
				renderRequest.setAttribute("countries", countries);
			}

			renderRequest.setAttribute("listUniversity", listUniversity);

			/// certificate Render Command

			ListTypeDefinition certificateDefinition = null;
			List<OMSBExamSpeciality> listCategories = new ArrayList<OMSBExamSpeciality>();

			certificateDefinition = ListTypeDefinitionLocalServiceUtil.getListTypeDefinitionByExternalReferenceCode(
					OmsbExamMasterWebPortletKeys.PL_EXAM_CATEGORY_ERC, PortalUtil.getDefaultCompanyId());

			if (Validator.isNotNull(certificateDefinition)) {

				List<ListTypeEntry> listEntriesSpeciality = ListTypeEntryLocalServiceUtil
						.getListTypeEntries(certificateDefinition.getListTypeDefinitionId(), -1, -1);

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

			List<com.liferay.portal.kernel.model.Country> countryList = CountryLocalServiceUtil
					.getCountries(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			if (Validator.isNotNull(countries)) {
				renderRequest.setAttribute("countries", countryList);
			}

			renderRequest.setAttribute("listCategories", listCategories);

			/// subSpecilaity Master
//						List<OMSBExamSpeciality> listSpecialityMaster = new ArrayList<OMSBExamSpeciality>();
//						ListTypeDefinition listTypeDefinition;
//
//						long titleId = ParamUtil.getLong(renderRequest, "titleId");
//						try {
//							if (Validator.isNotNull(titleId) && titleId > 0) {
//								ListTypeEntry listEntry = ListTypeEntryLocalServiceUtil.getListTypeEntry(titleId);
//								if (Validator.isNotNull(listEntry)) {
//									renderRequest.setAttribute("titleId", titleId);
//									renderRequest.setAttribute("titleNameMap", listEntry.getName());
//								}
//							}
//							listTypeDefinition = ListTypeDefinitionLocalServiceUtil.getListTypeDefinitionByExternalReferenceCode(
//									OmsbExamMasterWebPortletKeys.SPECIALITY_MASTER_PL_ERC, themeDisplay.getCompanyId());
//							if (Validator.isNotNull(listTypeDefinition)) {
//								List<ListTypeEntry> listEntries = ListTypeEntryLocalServiceUtil
//										.getListTypeEntries(listTypeDefinition.getListTypeDefinitionId(), -1, -1);
//
//								List<String> languageCodes = new ArrayList<>();
//								languageCodes.add(CommonConstants.LANGUAGE_CODE_ENGLISH);
//								languageCodes.add(CommonConstants.LANGUAGE_CODE_ARABIC);
//
//								for (ListTypeEntry entry : listEntries) {
//									String key = entry.getKey();
//									String en_Name = StringPool.BLANK, ar_Name = StringPool.BLANK;
//									Map<Locale, String> nameMap = entry.getNameMap();
//									Locale en_LanguageLocale = LocaleUtil.fromLanguageId(CommonConstants.LANGUAGE_CODE_ENGLISH);
//									en_Name = nameMap.get(en_LanguageLocale);
//
//									Locale ar_LanguageLocale = LocaleUtil.fromLanguageId(CommonConstants.LANGUAGE_CODE_ARABIC);
//									ar_Name = nameMap.get(ar_LanguageLocale);
//
//									OMSBExamSpeciality omsbSpecialityMaster = new OMSBExamSpeciality();
//									omsbSpecialityMaster.setKey(key);
//									omsbSpecialityMaster.setNameArabic(ar_Name);
//									omsbSpecialityMaster.setNameEnglish(en_Name);
//									omsbSpecialityMaster.setExternalReferenceCode(entry.getExternalReferenceCode());
//									omsbSpecialityMaster.setId(entry.getListTypeEntryId());
//									listSpecialityMaster.add(omsbSpecialityMaster);
//								}
//
//							}
//							renderRequest.setAttribute("listSpecialityMaster", listSpecialityMaster);

			/// Exam Type and Exam Eligibility

			List<ListTypeEntry> examTypeList = getPickListEntries(MVCCommandNames.EXAM_TYPE_MASTER_PL,
					themeDisplay.getCompanyId());
			renderRequest.setAttribute("examTypeList", examTypeList);
		//	renderRequest.setAttribute("allexamTypeEligibilities", getexamTypeEligibilities(themeDisplay));

			/// program Type and Exam Type
			
				List<ProgramTypeMaster> programDTO = getProgramType(themeDisplay);
				renderRequest.setAttribute("ProgramTypeList", getProgramType(themeDisplay));
				renderRequest.setAttribute("programExamTypes", getAllProgramExamType(themeDisplay));
				
			// Exam TypePicKlist 
				
				List<ListTypeEntry> examTypeEntries=commonApi.getListTypeEntriesByERC(MVCCommandNames.EXAM_TYPE_MASTER_PL, themeDisplay.getCompanyId());
				renderRequest.setAttribute("examTypeEntries", examTypeEntries);
				
				List<ListTypeEntry> examTypeListEntries=commonApi.getListTypeEntriesByERC(MVCCommandNames.EXAM_TYPE_MASTER_PL, themeDisplay.getCompanyId());
				renderRequest.setAttribute("examTypeListEntries", examTypeListEntries);
				
				

		} catch (PortalException e) {
			logger.error(e.getMessage(), e);
		}
		logger.info("render method ended");
		return OmsbExamMasterWebPortletKeys.VIEW_OMSB_EXAMS_JSP;
	}

	public List<ListTypeEntry> getPickListEntries(String pickListName, long companyId) {
		try {
			return ListTypeEntryLocalServiceUtil.getListTypeEntries(ListTypeDefinitionLocalServiceUtil
					.getListTypeDefinitionByExternalReferenceCode(pickListName, companyId).getListTypeDefinitionId());
		} catch (PortalException e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	public List<ProgramTypeMaster> getProgramType(ThemeDisplay themeDisplay) {
		logger.info("getProgramType() started");
		List<ProgramTypeMaster> programTypeMasters = new ArrayList<>();
		try {
			programTypeMasters = ProgramTypeMasterLocalServiceUtil.getProgramTypeMasters(-1, -1);
			for (ProgramTypeMaster programTypeMaster : programTypeMasters)

			{
				programTypeMaster
						.setProgramTypeName(CommonUtil.getValueByLanguage(programTypeMaster.getProgramTypeName(),
								OmsbExamMasterWebPortletKeys.PROGRAM_TYPE, themeDisplay.getLocale().toString()));
			}
		} catch (Exception e) {
			logger.error("error while fetching program type:" + e.getMessage(), e);
		}
		logger.info("getProgramType() ended");
		return programTypeMasters;
	}

//	public List<ExamTypeEligibilityMapping> getexamTypeEligibilities(ThemeDisplay themeDisplay) {
//		try {
//			logger.info("getexamTypeEligibilities() started");
//		String url = themeDisplay.getPortalURL() + MVCCommandNames.EXAM_ELIGIBILITY_URL + CommonConstants.SCOPES
//				+ StringPool.SLASH + themeDisplay.getScopeGroupId();
//		logger.info("ExamTypeEligibilityMasterUrl::" + url);
//		String ExamTypeEligibilityMasterUrlResponse = commonApi.getData(url);
//		logger.info("ExamTypeEligibilityMasterUrlResponse===============" + ExamTypeEligibilityMasterUrlResponse);
//		ExamTypeEligibilityMappingItem examTypeEligibilityMappingItem = CustomObjectMapperUtil
//				.readValue(ExamTypeEligibilityMasterUrlResponse, ExamTypeEligibilityMappingItem.class);
//		if (Validator.isNotNull(examTypeEligibilityMappingItem)
//				&& Validator.isNotNull(examTypeEligibilityMappingItem.getItems())
//				&& !examTypeEligibilityMappingItem.getItems().isEmpty()) {
//			for (ExamTypeEligibilityMapping examTypeEligibilityMapping : examTypeEligibilityMappingItem.getItems()) {
//				examTypeEligibilityMapping .setExamTypeName(commonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.PL_EXAM_TYPE,
//										examTypeEligibilityMapping.getExamType(), themeDisplay.getCompanyId())
//								.getName());
//				examTypeEligibilityMapping.setExamEligibilityName(commonApi
//						.getListTypeEntryByListTypeItemKey(LRPicklistConstants.PL_EXAM_ELIGIBILITY_ERC,
//								examTypeEligibilityMapping.getExamEligibility(), themeDisplay.getCompanyId())
//						.getName());
//			}
//			return examTypeEligibilityMappingItem.getItems();
//		}
//		}catch (Exception e) {
//			logger.error(e.getMessage(), e);
//		}
//		logger.info("getexamTypeEligibilities() ended");
//		return null;
//	}

	
	public List<ExamType> getAllProgramExamType(ThemeDisplay themeDisplay) {
		try {
			logger.info("getAllProgramExamType() started");
		String url = themeDisplay.getPortalURL() + LRObjectURL.EXAM_TYPE_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + themeDisplay.getScopeGroupId();
		logger.info("ProgramExamType url::" + url);
		String ExamTypeEligibilityMasterUrlResponse = commonApi.getData(url);
		logger.info("ProgramExamType response===============" + ExamTypeEligibilityMasterUrlResponse);
		ExamTypeItem programExamTypeItems = CustomObjectMapperUtil.readValue(ExamTypeEligibilityMasterUrlResponse, ExamTypeItem.class);
		if (Validator.isNotNull(programExamTypeItems)&& Validator.isNotNull(programExamTypeItems.getItems())&& !programExamTypeItems.getItems().isEmpty()) {
			for (ExamType programExamTypeItem : programExamTypeItems.getItems()) {
				programExamTypeItem.setExamTypeName(commonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.PL_EXAM_TYPE,
						programExamTypeItem.getExamType(), themeDisplay.getCompanyId()).getName(themeDisplay.getLocale()));
				programExamTypeItem.setProgramTypeName(getProgramTypeByProgramTypeId(programExamTypeItem.getProgramTypeId(), themeDisplay));
				programExamTypeItem.setId(programExamTypeItem.getId());
			}
			return programExamTypeItems.getItems();
		}
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.info("getexamTypeEligibilities() ended");
		return null;
	}
	
	

	public String getProgramTypeByProgramTypeId(long programTypeId, ThemeDisplay themeDisplay) {
		try {
			if (programTypeId > 0) {
				ProgramTypeMaster programTypeMaster = ProgramTypeMasterLocalServiceUtil.getProgramTypeMaster(programTypeId);
				if (Validator.isNotNull(programTypeMaster)) {
					return CommonUtil.getValueByLanguage(programTypeMaster.getProgramTypeName(),
							OmsbExamMasterWebPortletKeys.PROGRAM_TYPE, themeDisplay.getLocale().toString());
				}
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return "";
	}
	private static final Log logger = LogFactoryUtil.getLog(OMSBExamMasterMVCRenderCommand.class);
	@Reference
	private OMSBCommonApi commonApi;

	@Reference
	private OMSBHttpConnector omsbHttpConnector;

}
