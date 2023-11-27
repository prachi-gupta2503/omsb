package gov.omsb.master.web.render;

import com.liferay.list.type.model.ListTypeDefinition;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeDefinitionLocalServiceUtil;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.model.ListType;
import com.liferay.portal.kernel.model.ListTypeModel;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.CountryLocalService;
import com.liferay.portal.kernel.service.CountryLocalServiceUtil;
import com.liferay.portal.kernel.service.ListTypeLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
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
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.master.web.constants.MVCCommandNames;
import gov.omsb.master.web.constants.OmsbMasterPortletKeys;
import gov.omsb.master.web.portlet.dto.InstitutionItems;
import gov.omsb.master.web.portlet.dto.OMSBExamSpeciality;
import gov.omsb.master.web.portlet.dto.OMSBInstitutionMapping;
import gov.omsb.master.web.portlet.dto.OMSBSpecialityMapping;
import gov.omsb.master.web.portlet.dto.OmsbProfessionSpeciality;
import gov.omsb.master.web.portlet.dto.OmsbProfessionSpecialityItems;
import gov.omsb.master.web.portlet.dto.SectionDepartment;
import gov.omsb.master.web.portlet.dto.SectionDepartmentItems;
import gov.omsb.master.web.portlet.dto.SectionFunction;
import gov.omsb.master.web.portlet.dto.SectionFunctionItems;
import gov.omsb.master.web.portlet.dto.SubSpecialityItems;
import gov.omsb.master.web.portlet.dto.WorksectorsItems;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbMasterPortletKeys.OMSBMASTER,
		"mvc.command.name=/", }, service = MVCRenderCommand.class)
public class OMSBMasterMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		//specialityMaster Render 
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

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
					OmsbMasterPortletKeys.SPECIALITY_MASTER_PL_ERC, themeDisplay.getCompanyId());
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
						.getListTypeDefinitionByExternalReferenceCode(OmsbMasterPortletKeys.SPECIALITY_MASTER_PL_ERC,
								themeDisplay.getCompanyId());

				listTypeDefinitionSubSpeciality = ListTypeDefinitionLocalServiceUtil
						.getListTypeDefinitionByExternalReferenceCode(
								OmsbMasterPortletKeys.SUB_SPECIALITY_MASTER_PL_ERC, themeDisplay.getCompanyId());

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
				
				
				///Institution Render Command 
				
				ListTypeDefinition definition = null;
				List<OMSBExamSpeciality> listUniversity = new ArrayList<OMSBExamSpeciality>();
					definition = ListTypeDefinitionLocalServiceUtil.getListTypeDefinitionByExternalReferenceCode(
							OmsbMasterPortletKeys.PL_UNIVERSITY_ERC, PortalUtil.getDefaultCompanyId());

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
					
					///certificate Render Command 
					
					ListTypeDefinition certificateDefinition = null;
					List<OMSBExamSpeciality> listCategories = new ArrayList<OMSBExamSpeciality>();

				

						certificateDefinition = ListTypeDefinitionLocalServiceUtil.getListTypeDefinitionByExternalReferenceCode(
								OmsbMasterPortletKeys.PL_EXAM_CATEGORY_ERC, PortalUtil.getDefaultCompanyId());

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
						
						
						///work Sector Master 
						
						List<ListTypeEntry> workSectorTypes = getPickListEntries(MVCCommandNames.PL_WORK_SECTOR_TYPE, themeDisplay.getCompanyId());
						renderRequest.setAttribute("workSectorTypeList", workSectorTypes);
						
						List<ListTypeEntry> professionEntries=omsbCommonApi.getListTypeEntriesByERC(MVCCommandNames.PL_PROFESSION_ERC, themeDisplay.getCompanyId());
						renderRequest.setAttribute("professionEntries", professionEntries);
						
						List<ListTypeEntry> departmentEntries=omsbCommonApi.getListTypeEntriesByERC(MVCCommandNames.PL_DEPARTMENT, themeDisplay.getCompanyId());
						renderRequest.setAttribute("departmentEntries", departmentEntries);
						
						List<ListTypeEntry> sectionEntries=omsbCommonApi.getListTypeEntriesByERC(MVCCommandNames.PL_SECTION, themeDisplay.getCompanyId());
						renderRequest.setAttribute("sectionEntries", sectionEntries);
						
						SubSpecialityItems specialityItems=getSubSpecialityItems(themeDisplay);
						List<OMSBSpecialityMapping> omsbSpecialityMappings = new ArrayList<>();
						for(OMSBSpecialityMapping omsbSpecialityMapping : specialityItems.getItems()) {
							OMSBSpecialityMapping specialityMapping = new OMSBSpecialityMapping();
							specialityMapping.setSpecialityName(omsbCommonApi.getListTypeEntryNameBylistTypeEntryId(omsbSpecialityMapping.getSpeciality(), themeDisplay.getLocale()));
							specialityMapping.setSubSpecialityName(omsbCommonApi.getListTypeEntryNameBylistTypeEntryId(omsbSpecialityMapping.getSubSpeciality(), themeDisplay.getLocale()));
							specialityMapping.setId(omsbSpecialityMapping.getId());
							omsbSpecialityMappings.add(specialityMapping);
						}
						renderRequest.setAttribute("omsbSpecialityMappings", omsbSpecialityMappings);
						
						//getInstitutionList
						
						InstitutionItems institutionItems =getInstitutionList(themeDisplay);
						List<OMSBInstitutionMapping> institutionMappings = new ArrayList<>();
						for(OMSBInstitutionMapping omsbInstitutionMapping :institutionItems.getItems()) {
							OMSBInstitutionMapping institutionMapping = new OMSBInstitutionMapping();
							Country country =countryLocalService.getCountry(omsbInstitutionMapping.getCountry());
							institutionMapping.setCountryName(country.getName(themeDisplay.getLocale()));
							institutionMapping.setUniversityName(omsbCommonApi.getListTypeEntryNameBylistTypeEntryId(omsbInstitutionMapping.getUniversity(), themeDisplay.getLocale()));
							institutionMapping.setId(omsbInstitutionMapping.getId());
							institutionMappings.add(institutionMapping);
						}
						renderRequest.setAttribute("institutionMappings", institutionMappings);
						
						/// List of Countries
						List<Country> countriesList = countryLocalService.getCountries(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
						renderRequest.setAttribute("countriesList", countriesList);
						//proffession primary Speciality 
						OmsbProfessionSpecialityItems professionSpecialityItems = getProffesionSpecialityList(themeDisplay);
						List<OmsbProfessionSpeciality> omsbProfessionSpecialities = new ArrayList<>();
						for(OmsbProfessionSpeciality professionSpeciality : professionSpecialityItems.getItems()) {
							OmsbProfessionSpeciality omsbProfessionSpeciality = new OmsbProfessionSpeciality();
							omsbProfessionSpeciality.setId(professionSpeciality.getId());
							omsbProfessionSpeciality.setProfessionName(omsbCommonApi.getListTypeEntryNameBylistTypeEntryId(professionSpeciality.getProfession(), themeDisplay.getLocale()));
							omsbProfessionSpeciality.setSpecialityName(omsbCommonApi.getListTypeEntryNameBylistTypeEntryId(professionSpeciality.getSpeciality(), themeDisplay.getLocale()));
							omsbProfessionSpecialities.add(omsbProfessionSpeciality);
						}
						renderRequest.setAttribute("omsbProfessionSpecialities", omsbProfessionSpecialities);
						
						// deparment Section 
						SectionDepartmentItems departmentItems = getDepartmentSectionList(themeDisplay);
						List<SectionDepartment> sectionDepartments = new ArrayList<>();
						for(SectionDepartment sectionDepartment : departmentItems.getItems()) {
							SectionDepartment departmentMapping = new SectionDepartment();
							departmentMapping.setId(sectionDepartment.getId());
							ListTypeEntry entry=omsbCommonApi.getListTypeEntryByListTypeItemKey(MVCCommandNames.PL_DEPARTMENT, sectionDepartment.getDepartmentId(), themeDisplay.getCompanyId());
							if(entry  != null) {
								departmentMapping.setDepartmentId(entry.getName(themeDisplay.getLocale()));
							}else {
								departmentMapping.setDepartmentId("");
							}
							ListTypeEntry sectionEntry=omsbCommonApi.getListTypeEntryByListTypeItemKey(MVCCommandNames.PL_SECTION, sectionDepartment.getSectionId(), themeDisplay.getCompanyId());
							if(sectionEntry  != null) {
								departmentMapping.setSectionId(sectionEntry.getName(themeDisplay.getLocale()));
							}else {
								departmentMapping.setSectionId("");
							}
							sectionDepartments.add(departmentMapping);
						}
						renderRequest.setAttribute("sectionDepartments", sectionDepartments);
						
						//section Function Committee  
						SectionFunctionItems functionItems = getSectionFunctionList(themeDisplay);
						List<SectionFunction> sectionFunctions = new ArrayList<>();
						for(SectionFunction sectionFunction : functionItems.getItems()) {
							SectionFunction function = new SectionFunction();
							function.setId(sectionFunction.getId());
							ListTypeEntry entry=omsbCommonApi.getListTypeEntryByListTypeItemKey(MVCCommandNames.PL_SECTION, sectionFunction.getSectionId(), themeDisplay.getCompanyId());
							if(entry != null) {
								function.setSectionId(entry.getName(themeDisplay.getLocale()));
							}else {
								function.setSectionId("");
							}
							ListTypeEntry functionEntry =omsbCommonApi.getListTypeEntryByListTypeItemKey(MVCCommandNames.PL_FUNCTION, sectionFunction.getFunctionId(), themeDisplay.getCompanyId());
							if(functionEntry != null) {
								function.setFunctionId(functionEntry.getName(themeDisplay.getLocale()));
								}else {
								function.setFunctionId("");
								}
							ListTypeEntry committeeEntry =omsbCommonApi.getListTypeEntryByListTypeItemKey(MVCCommandNames.PL_COMMITTEE, sectionFunction.getCommitteeId(), themeDisplay.getCompanyId());
							if (committeeEntry != null) {
								function.setCommitteeId(committeeEntry.getName(themeDisplay.getLocale()));
							} else {
								function.setCommitteeId("");
							}
							sectionFunctions.add(function);
						}
						renderRequest.setAttribute("sectionFunctions", sectionFunctions);
			
						
		} catch (PortalException e) {
			logger.error(e.getMessage(),e);
		}
		return OmsbMasterPortletKeys.VIEW_OMSB_EXAMS_JSP;
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
	
     public String getNamebyEntryId(long listTypeEntryId,Locale locale ) {
    	 String name = omsbCommonApi.getListTypeEntryNameBylistTypeEntryId(listTypeEntryId, locale);
		return name;
     }
     
     public String getWorkSectorByParentId(ThemeDisplay themeDisplay, long workSectorTypeParentId)
 			throws UnsupportedEncodingException {
 		String workSectorMasterUrl =  themeDisplay.getPortalURL() + MVCCommandNames.WORK_SECTOR_TYPE_URL  + CommonConstants.SCOPES + StringPool.SLASH + 
 				themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=workSectorParentId" 
 				+URLEncoder.encode(" eq " + workSectorTypeParentId, StandardCharsets.UTF_8) + MVCCommandNames.FILTER_PARAMS ;
 		String workSectorMasterUrlResponse = omsbCommonApi.getData(workSectorMasterUrl);
// 		logger.info("workSectorMasterUrl::" + workSectorMasterUrl);
// 		logger.info("workSectorMasterUrlResponse==============="+workSectorMasterUrlResponse);
 		WorksectorsItems items = CustomObjectMapperUtil.readValue(workSectorMasterUrlResponse, WorksectorsItems.class);
 		if(Validator.isNotNull(items) && Validator.isNotNull(items.getItems()) ) {
 			return items.getItems().get(0).getWorkSector();
 		}
		return null;
 	}
     

     
	public WorksectorsItems getWorkSectorNameItemsKey(ThemeDisplay themeDisplay, long workSectorType) {
		String workSectorMasterUrl = themeDisplay.getPortalURL() + MVCCommandNames.WORK_SECTOR_TYPE_URL
				+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION
				+ "filter=workSectorType" + URLEncoder
						.encode(" eq " + "'" + workSectorType + "' and workSectorParentId eq 0", StandardCharsets.UTF_8)
				+ "&sort=workSector:asc&pageSize=0";
		String workSectorMasterUrlResponse = omsbCommonApi.getData(workSectorMasterUrl);
		logger.info("workSectorMasterUrl::" + workSectorMasterUrl);
		logger.info("workSectorMasterUrlResponse===============" + workSectorMasterUrlResponse);
		return CustomObjectMapperUtil.readValue(workSectorMasterUrlResponse, WorksectorsItems.class);
	}
     
	public SubSpecialityItems getSubSpecialityItems(ThemeDisplay themeDisplay) {
		String specialityMappingUrl = themeDisplay.getPortalURL() + MVCCommandNames.SPECIALITY_MAPPING_URL
				+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION
				+ MVCCommandNames.SORT_BY_ID_DESC;
		logger.info("specialityMappingUrl " + specialityMappingUrl);
		String response = omsbCommonApi.getData(specialityMappingUrl);
		logger.info("response" + response);
		return CustomObjectMapperUtil.readValue(response, SubSpecialityItems.class);
	}
     
	public InstitutionItems getInstitutionList(ThemeDisplay themeDisplay) {
		String institutionMappingUrl = themeDisplay.getPortalURL() + MVCCommandNames.INSTITUTION_UNIVERSITY_MAPPING_URL
				+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION
				+ MVCCommandNames.SORT_BY_ID_DESC;
		logger.info("institutionMappingUrl " + institutionMappingUrl);
		String response = omsbCommonApi.getData(institutionMappingUrl);
		logger.info("response" + response);
		return CustomObjectMapperUtil.readValue(response, InstitutionItems.class);
	}

	public OmsbProfessionSpecialityItems getProffesionSpecialityList(ThemeDisplay themeDisplay) {
		String professionSpecialityMappingUrl = themeDisplay.getPortalURL() + MVCCommandNames.PROFESSION_SPECIALITY_URL
				+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION
				+ MVCCommandNames.SORT_BY_ID_DESC;
		logger.info("professionSpecialityMappingUrl " + professionSpecialityMappingUrl);
		String response = omsbCommonApi.getData(professionSpecialityMappingUrl);
		logger.info("profession response" + response);
		return CustomObjectMapperUtil.readValue(response, OmsbProfessionSpecialityItems.class);
	}
	
	public SectionDepartmentItems getDepartmentSectionList(ThemeDisplay themeDisplay) {
		String departmentSectionMappingUrl = themeDisplay.getPortalURL() + MVCCommandNames.DEPARTMENT_SECTION_URL
				+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION
				+ MVCCommandNames.SORT_BY_ID_DESC;
		logger.info("professionSpecialityMappingUrl " + departmentSectionMappingUrl);
		String response = omsbCommonApi.getData(departmentSectionMappingUrl);
		logger.info("departmentSectionMappingUrl response" + response);
		return CustomObjectMapperUtil.readValue(response, SectionDepartmentItems.class);
	}
	
	public SectionFunctionItems getSectionFunctionList(ThemeDisplay themeDisplay) {
		String sectionFunctionMappingUrl = themeDisplay.getPortalURL() + MVCCommandNames.SECTION_FUNCTION_URL
				+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION
				+ MVCCommandNames.SORT_BY_ID_DESC;
		logger.info("sectionFunctionMappingUrl " + sectionFunctionMappingUrl);
		String response = omsbCommonApi.getData(sectionFunctionMappingUrl);
		logger.info("sectionFunctionMappingUrl response" + response);
		return CustomObjectMapperUtil.readValue(response, SectionFunctionItems.class);
	}
	
	
	
	
	
	
	private static final Log logger = LogFactoryUtil.getLog(OMSBMasterMVCRenderCommand.class);
	
	@Reference(unbind = "-")
	private OMSBHttpConnector oMSBHttpConnector;
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
	@Reference(unbind = "-")
	private CountryLocalService countryLocalService;

}
