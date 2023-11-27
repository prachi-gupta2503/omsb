package gov.omsb.oct.master.web.portlet.render;

import com.liferay.list.type.model.ListTypeDefinition;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeDefinitionLocalServiceUtil;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

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
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.oct.master.web.constants.MVCCommandNames;
import gov.omsb.oct.master.web.constants.OmsbOctMasterWebPortletKeys;
import gov.omsb.oct.master.web.portlet.dto.CodeItem;
import gov.omsb.oct.master.web.portlet.dto.OCTExamTitleCodeMapping;
import gov.omsb.oct.master.web.portlet.dto.OCTNewExamTitle;
import gov.omsb.oct.master.web.portlet.dto.OCTNewTrainingSite;
import gov.omsb.oct.master.web.portlet.dto.OCTTrainingSlotMaster;
import gov.omsb.oct.master.web.portlet.dto.OCTTrainingSlotMasterItems;
import gov.omsb.oct.master.web.portlet.dto.OCTrainingSiteSeatsMapping;
import gov.omsb.oct.master.web.portlet.dto.SeatsItem;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctMasterWebPortletKeys.OMSBOCTMASTERWEB,
		"mvc.command.name=" + MVCCommandNames.OCT_MASTER_SETUP, }, service = MVCRenderCommand.class)
public class OCTNewExamSetupMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		logger.info("OCT new exam setup render() started");

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		//fetching all oct Exam title 
		List<OCTNewExamTitle> listOctExamTitle = new ArrayList<OCTNewExamTitle>();
		ListTypeDefinition examTitlelistTypeDefinition;

		long titleId = ParamUtil.getLong(renderRequest, "titleId");
		try {
			if(Validator.isNotNull(titleId) && titleId > 0) {
				ListTypeEntry listEntry = ListTypeEntryLocalServiceUtil.getListTypeEntry(titleId);
				if(Validator.isNotNull(listEntry)) {
					logger.info("titleId  ===== ");
					logger.info(listEntry.toString());
					logger.info(listEntry.getName());
					renderRequest.setAttribute("titleId", titleId);
					renderRequest.setAttribute("titleNameMap", listEntry.getName());
				}
			}
			examTitlelistTypeDefinition = ListTypeDefinitionLocalServiceUtil
					.getListTypeDefinitionByExternalReferenceCode(OmsbOctMasterWebPortletKeys.EXAM_TITLE_PL_ERC, themeDisplay.getCompanyId());
			if (Validator.isNotNull(examTitlelistTypeDefinition)) {
				List<ListTypeEntry> listEntries = ListTypeEntryLocalServiceUtil
						.getListTypeEntries(examTitlelistTypeDefinition.getListTypeDefinitionId(), -1, -1);

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
					logger.info("entry id :::::::::::::::::::: " + entry.getListTypeEntryId());
					OCTExamTitleCodeMapping codeMapping = getexamCodeByTitleId(themeDisplay, entry.getListTypeEntryId());
					OCTNewExamTitle octNewExamTitle = new OCTNewExamTitle();
					octNewExamTitle.setKey(key);
					octNewExamTitle.setNameArabic(ar_Name);
					octNewExamTitle.setNameEnglish(en_Name);
					octNewExamTitle.setExternalReferenceCode(entry.getExternalReferenceCode());
					octNewExamTitle.setId(entry.getListTypeEntryId());
					if(Validator.isNotNull(codeMapping)) {
						octNewExamTitle.setExamCode(codeMapping.getCode());
						octNewExamTitle.setOctNewExamTitleId(codeMapping.getId());
					}
					listOctExamTitle.add(octNewExamTitle);
				}

			}
			renderRequest.setAttribute("listOctExamTitle", listOctExamTitle);
			
			//Fecteching all Training Slots
			List<OCTNewTrainingSite> listOctTrainingSite = new ArrayList<OCTNewTrainingSite>();
			long siteId = ParamUtil.getLong(renderRequest, "siteId");
			ListTypeDefinition trainingSlotlistTypeDefinition;
			
				if (Validator.isNotNull(siteId) && siteId > 0) {
					ListTypeEntry listEntry = ListTypeEntryLocalServiceUtil.getListTypeEntry(siteId);
					if (Validator.isNotNull(listEntry)) {
						renderRequest.setAttribute("siteId", siteId);
						renderRequest.setAttribute("siteNameMap", listEntry.getName());
						long trainingSiteId = ParamUtil.getLong(renderRequest, "trainingSiteId");
						///
						OCTrainingSiteSeatsMapping seatsMapping = getTrainingSiteBySiteId(themeDisplay, siteId);
						
						OCTrainingSiteSeatsMapping newTrainingSite = getStatusByTitleId(themeDisplay, siteId);
						if(Validator.isNotNull(newTrainingSite)) {
							renderRequest.setAttribute("seats", seatsMapping.getSeats());
							renderRequest.setAttribute("status", newTrainingSite.getStatusId());
							renderRequest.setAttribute("id", seatsMapping.getId());
						}
					}
				}
				trainingSlotlistTypeDefinition = ListTypeDefinitionLocalServiceUtil.getListTypeDefinitionByExternalReferenceCode(
						OmsbOctMasterWebPortletKeys.TRAINING_SITE_PL_ERC, themeDisplay.getCompanyId());
				if (Validator.isNotNull(trainingSlotlistTypeDefinition)) {

					List<ListTypeEntry> listEntries = ListTypeEntryLocalServiceUtil
							.getListTypeEntries(trainingSlotlistTypeDefinition.getListTypeDefinitionId(), -1, -1);

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
						OCTrainingSiteSeatsMapping seatsMapping = getTrainingSiteBySiteId(themeDisplay, entry.getListTypeEntryId());
						

						OCTrainingSiteSeatsMapping newTrainingSite = getStatusByTitleId(themeDisplay, entry.getListTypeEntryId());
						
						OCTNewTrainingSite octNewTrainingSite = new OCTNewTrainingSite();
						octNewTrainingSite.setKey(key);
						octNewTrainingSite.setNameArabic(ar_Name);
						octNewTrainingSite.setNameEnglish(en_Name);
						octNewTrainingSite.setExternalReferenceCode(entry.getExternalReferenceCode());
						octNewTrainingSite.setId(entry.getListTypeEntryId());
						
						if(Validator.isNotNull(seatsMapping)) {
							logger.info("seatsMapping"+seatsMapping);
							logger.info("seatsMapping"+seatsMapping.getSeats());
							octNewTrainingSite.setSeats(seatsMapping.getSeats());
							octNewTrainingSite.setOctNewTrainingSiteId(seatsMapping.getId());
						}
						
						if(Validator.isNotNull(newTrainingSite)) {
							logger.info("newTrainingSite========================="+newTrainingSite);
							logger.info("newTrainingSite========================="+newTrainingSite.getStatusId());
							octNewTrainingSite.setStatusId(newTrainingSite.getStatusId());
						
						}
						listOctTrainingSite.add(octNewTrainingSite);
					}
				}
				renderRequest.setAttribute("listOctTrainingSite", listOctTrainingSite);
				
				// Fetching Training Slot Mapping 
				
				///List<OCTNewTrainingSite> listOctTrainingSite = new ArrayList<OCTNewTrainingSite>();
//				ListTypeDefinition listTypeDefinition;
			
//					listTypeDefinition = ListTypeDefinitionLocalServiceUtil.getListTypeDefinitionByExternalReferenceCode(
//							OmsbOctMasterWebPortletKeys.TRAINING_SITE_PL_ERC, themeDisplay.getCompanyId());
//					if (Validator.isNotNull(listTypeDefinition)) {

//						List<ListTypeEntry> listEntries = ListTypeEntryLocalServiceUtil
//								.getListTypeEntries(listTypeDefinition.getListTypeDefinitionId(), -1, -1);
//
//						List<String> languageCodes = new ArrayList<>();
//						languageCodes.add(CommonConstants.LANGUAGE_CODE_ENGLISH);
//						languageCodes.add(CommonConstants.LANGUAGE_CODE_ARABIC);
//
//						for (ListTypeEntry entry : listEntries) {
//							String key = entry.getKey();
//							String en_Name = "", ar_Name = "";
//							Map<Locale, String> nameMap = entry.getNameMap();
//							Locale en_LanguageLocale = LocaleUtil.fromLanguageId(CommonConstants.LANGUAGE_CODE_ENGLISH);
//							en_Name = nameMap.get(en_LanguageLocale);
//
//							Locale ar_LanguageLocale = LocaleUtil.fromLanguageId(CommonConstants.LANGUAGE_CODE_ARABIC);
//							ar_Name = nameMap.get(ar_LanguageLocale);
//
//							OCTNewTrainingSite octNewTrainingSite = new OCTNewTrainingSite();
//							octNewTrainingSite.setKey(key);				
//							octNewTrainingSite.setNameArabic(ar_Name);
//							octNewTrainingSite.setNameEnglish(en_Name);
//							octNewTrainingSite.setExternalReferenceCode(entry.getExternalReferenceCode());
//							octNewTrainingSite.setId(entry.getListTypeEntryId());
//							listOctTrainingSite.add(octNewTrainingSite);
//						}
//					}
				//	renderRequest.setAttribute("listOctTrainingSite", listOctTrainingSite);
				
			OCTTrainingSlotMasterItems octTrainingSlotMasterItems =getTrainingSlotList(themeDisplay);
				List<OCTTrainingSlotMaster> octTrainingSlotMasters = new ArrayList<>();
				for(OCTTrainingSlotMaster octTrainingSlotMaster : octTrainingSlotMasterItems.getItems()) {
					OCTTrainingSlotMaster slotMaster = new OCTTrainingSlotMaster();
					slotMaster.setId(octTrainingSlotMaster.getId());
					slotMaster.setTimeSlot(octTrainingSlotMaster.getTimeSlot());
					String entryName=commonApi.getListTypeEntryNameBylistTypeEntryId(octTrainingSlotMaster.getTrainingSiteId(), themeDisplay.getLocale());
					slotMaster.setTrainingSiteIdName(entryName);
					octTrainingSlotMasters.add(slotMaster);
				}
				renderRequest.setAttribute("octTrainingSlotMasters", octTrainingSlotMasters);
				

		} catch (PortalException e) {
			logger.error(e.getMessage());
		} 
		
		return OmsbOctMasterWebPortletKeys.OCT_EXAM_SETUP_JSP;
	}

	private OCTExamTitleCodeMapping getexamCodeByTitleId(ThemeDisplay themeDisplay, long titleId) {
		String url = themeDisplay.getPortalURL() + LRObjectURL.EXAM_TITLE_MAPPING_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + getGroupId() + StringPool.QUESTION + "filter=picklistId"
				+ URLEncoder.encode(" eq " + titleId, StandardCharsets.UTF_8) + "&sort=id:desc&pageSize=0";

		String response = omsbHttpConnector.executeGet(url, "", commonApi.getHttpHeaderInfoAndBasicAuth());
		OCTExamTitleCodeMapping exam1 = null;
		CodeItem examList = CustomObjectMapperUtil.readValue(response, CodeItem.class);
		for (OCTExamTitleCodeMapping exam : examList.getItems()) {
			exam1 = exam;
		}
		return exam1;
	}
	
	private OCTrainingSiteSeatsMapping getStatusByTitleId(ThemeDisplay themeDisplay, long titleId) {
		String url = themeDisplay.getPortalURL() + MVCCommandNames.OC_TRAINING_SITE_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=picklistId"
				+ URLEncoder.encode(" eq " + titleId, StandardCharsets.UTF_8) + "&sort=id:desc&pageSize=0";
		logger.info("url ==================== " + url);
		String response = omsbHttpConnector.executeGet(url, "", commonApi.getHttpHeaderInfoAndBasicAuth());
		logger.info("response ==================== " + response);
		OCTrainingSiteSeatsMapping trainingSite = null;
		SeatsItem seatsList = CustomObjectMapperUtil.readValue(response, SeatsItem.class);
		for (OCTrainingSiteSeatsMapping seats : seatsList.getItems()) {
			trainingSite = seats;
		}
		return trainingSite;
	}
	
	private long getGroupId() {
		Group group = GroupLocalServiceUtil.fetchGroup(PortalUtil.getDefaultCompanyId(),
				CommonConstants.GUEST_GROUP_KEY);
		if (Validator.isNotNull(group)) {
			logger.info("Guest Group Id is ?? " + group.getGroupId());
			return group.getGroupId();
		}
		return 0;
	}
	
	private OCTrainingSiteSeatsMapping getTrainingSiteBySiteId(ThemeDisplay themeDisplay, long titleId) {
		String url = themeDisplay.getPortalURL() + LRObjectURL.OC_TRAINING_SITE_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + getGroupId() + StringPool.QUESTION + "filter=picklistId"
				+ URLEncoder.encode(" eq " + titleId, StandardCharsets.UTF_8) + "&sort=id:desc&pageSize=0";

		logger.info("url ==================== " + url);
		String response = omsbHttpConnector.executeGet(url, "", commonApi.getHttpHeaderInfoAndBasicAuth());
		logger.info("response ==================== " + response);
		OCTrainingSiteSeatsMapping trainingSite = null;
		SeatsItem seatsList = CustomObjectMapperUtil.readValue(response, SeatsItem.class);
		for (OCTrainingSiteSeatsMapping seats : seatsList.getItems()) {
			trainingSite = seats;
		}
		return trainingSite;
	}
	
	private OCTTrainingSlotMasterItems getTrainingSlotList(ThemeDisplay themeDisplay) {
		String trainingSlotMasterUrl = themeDisplay.getPortalURL() + MVCCommandNames.OCT_EXAM_TRAINING_SITE_SLOT_MASTER
				+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION
				+ "&sort=id:desc&pageSize=0";
		logger.info("trainingSlotMasterUrl " + trainingSlotMasterUrl);
		String response = commonApi.getData(trainingSlotMasterUrl);
		logger.info("trainingSlotMasterUrl response" + response);
		return CustomObjectMapperUtil.readValue(response, OCTTrainingSlotMasterItems.class);
	}
	
	@Reference
	private OMSBCommonApi commonApi;

	@Reference
	private OMSBHttpConnector omsbHttpConnector;
	private static final Log logger = LogFactoryUtil.getLog(OCTNewExamSetupMVCRenderCommand.class);
}
