package gov.omsb.oct.exam.web.portlet.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.font.FontProvider;
import com.liferay.adaptive.media.exception.AMRuntimeException.UnsupportedEncodingException;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.document.library.util.DLURLHelperUtil;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.list.type.model.ListTypeDefinition;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeDefinitionLocalServiceUtil;
import com.liferay.list.type.service.ListTypeEntryLocalService;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.object.model.ObjectDefinition;
import com.liferay.object.model.ObjectEntry;
import com.liferay.object.service.ObjectDefinitionService;
import com.liferay.object.service.ObjectEntryLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.UserNotificationEventLocalService;
import com.liferay.portal.kernel.service.UserNotificationEventLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowLog;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import javax.portlet.ActionRequest;
import javax.portlet.PortletRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.common.dto.Country;
import gov.omsb.common.dto.CountryItem;
import gov.omsb.common.dto.DocumentInfo;
import gov.omsb.common.dto.DocumentInfoItem;
import gov.omsb.common.dto.EducationDetail;
import gov.omsb.common.dto.EducationDetailItem;
import gov.omsb.common.dto.EmergencyContact;
import gov.omsb.common.dto.EmergencyContactItem;
import gov.omsb.common.dto.Person;
import gov.omsb.common.dto.PersonItem;
import gov.omsb.common.dto.PersonalDetail;
import gov.omsb.common.dto.PersonalDetailItem;
import gov.omsb.common.dto.UserMetadata;
import gov.omsb.common.dto.UserMetadataItem;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.common.util.CustomWorkflowTaskUtil;
import gov.omsb.common.util.FileUploadUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OCTExamConstants;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.dto.OCTCancellationFeesItem;
import gov.omsb.oct.exam.web.portlet.dto.OCTExam;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamAppeal;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamAppealItem;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamBlueprint;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamBlueprintItem;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamCancellationFees;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamCancellationFeesItem;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamDefinition;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamDefinitionItems;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamDetails;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamFormNumber;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamFormNumberItem;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamItems;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamJsonFields;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamPayment;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamPaymentItems;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamRegistrationTemp;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamRegistrationTempItem;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamReschedule;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamReschedulingFees;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamReschedulingFeesItem;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamResult;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamResultItem;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamSchedule;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamScheduleItems;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamTitle;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamTitleItem;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamType;
import gov.omsb.oct.exam.web.portlet.dto.OCTMapTrainingSite;
import gov.omsb.oct.exam.web.portlet.dto.OCTMapTrainingSiteItems;
import gov.omsb.oct.exam.web.portlet.dto.OCTRegistration;
import gov.omsb.oct.exam.web.portlet.dto.OCTRegistrationItem;
import gov.omsb.oct.exam.web.portlet.dto.OCTRegularFees;
import gov.omsb.oct.exam.web.portlet.dto.OCTRegularFeesItem;
import gov.omsb.oct.exam.web.portlet.dto.OCTRescheduleFees;
import gov.omsb.oct.exam.web.portlet.dto.OCTRescheduleFeesItem;
import gov.omsb.oct.exam.web.portlet.dto.OCTTrainingSite;
import gov.omsb.oct.exam.web.portlet.dto.OCTTrainingSiteItems;
import gov.omsb.oct.exam.web.portlet.dto.SectionDepartmentItems;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.model.GenderMaster;
import gov.omsb.tms.service.GenderMasterLocalServiceUtil;
import gov.omsb.web.notification.configuration.action.OCTRegistrationNotificationConfigurationAction;

@Component(immediate = true, service = OCTExamUtil.class)
public class OCTExamUtil {

	/**
	 * Get All OCT Exams
	 * 
	 * @param companyId
	 * @param groupId
	 * @param portalURL
	 * @param locale
	 * @return
	 * @throws PortalException
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	public List<OCTExamDetails> getOCTExamDetailsList(long companyId, long groupId, String portalURL, Locale locale)
			throws PortalException, JsonMappingException, JsonProcessingException {

		String url = portalURL + LRObjectURL.OC_EXAM + CommonConstants.SCOPES + StringPool.SLASH + groupId
				+ StringPool.QUESTION + OCTExamConstants.SORT_BY_ID_DESC;
		String response = omsbHttpConnector.executeGet(url, "", omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
		//logger.info("Response ... " + response);

		List<OCTExamDetails> octExamDetailsList = getOCTExamDetailsListByResponse(response, locale);

//		logger.info("OCTExamDetails .... " + octExamDetailsList.toString());

		return octExamDetailsList;

	}

	/**
	 * Get OCT Exam By Title
	 * 
	 * @param companyId
	 * @param scopeGroupId
	 * @param portalURL
	 * @param examTitleId
	 * @return
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	public List<OCTExamDetails> getOCTExamDetailsListByExamTitle(long companyId, long scopeGroupId, String portalURL,
			long examTitleId, Locale locale) throws JsonMappingException, JsonProcessingException {

		String url = portalURL + LRObjectURL.OC_EXAM + CommonConstants.SCOPES + StringPool.SLASH + scopeGroupId
				+ StringPool.QUESTION + OCTExamConstants.SORT_BY_ID_DESC + StringPool.AMPERSAND
				+ OCTExamConstants.OC_EXAM_TITLE_ID_FILTER + examTitleId;
		String response = omsbHttpConnector.executeGet(url, "", omsbCommonApi.getHttpHeaderInfoAndBasicAuth());

		List<OCTExamDetails> octExamDetailsList = getOCTExamDetailsListByResponse(response, locale);

		return octExamDetailsList;
	}

	/**
	 * Get OCT Exam List from Object Api response
	 * 
	 * @param response
	 * @param locale
	 * @return List<OCExam> List of OC Exam
	 * @throws JsonMappingException
	 * @throws JsonProcessingException
	 */
	public List<OCTExamDetails> getOCTExamDetailsListByResponse(String response, Locale locale)
			throws JsonMappingException, JsonProcessingException {
		List<OCTExamDetails> octExamDetailsList = new ArrayList<OCTExamDetails>();
		if (Validator.isNotNull(response)) {
			OCTExamItems octExamItems = CustomObjectMapperUtil.readValue(response, OCTExamItems.class);
			if (Validator.isNotNull(octExamItems) && Validator.isNotNull(octExamItems.getItems())
					&& !octExamItems.getItems().isEmpty()) {
//				logger.info("octExamItems .." + octExamItems);
				List<OCTExam> octExamList = octExamItems.getItems();
				for (OCTExam octExam : octExamList) {

//					logger.info("octExam .." + octExam);
					ObjectMapper objectMapper = new ObjectMapper();
					OCTExamJsonFields oCTExamJsonFields = new OCTExamJsonFields();
					oCTExamJsonFields = objectMapper.readValue(octExam.getExamJson(),
							new TypeReference<OCTExamJsonFields>() {
							});

					if (Validator.isNotNull(oCTExamJsonFields.getResultSource())
							&& oCTExamJsonFields.getResultSource() > 0) {
						String resultSourceName = omsbCommonApi
								.getListTypeEntryNameBylistTypeEntryId(oCTExamJsonFields.getResultSource(), locale);
						oCTExamJsonFields.setResultSourceName(resultSourceName);
					}
					logger.info("Out Side The If Condition ..");
					OCTExamDetails octExamDetails = new OCTExamDetails();
					octExamDetails.setId(octExam.getId());
					octExamDetails.setExamJson(oCTExamJsonFields);
					octExamDetails.setModified(octExam.isModified());

					if (Validator.isNotNull(octExam.getOctExamTitleId()) && octExam.getOctExamTitleId() > 0) {
						String ocExamTitle = omsbCommonApi
								.getListTypeEntryNameBylistTypeEntryId(octExam.getOctExamTitleId(), locale);
						logger.info("ocExamTitle .." + ocExamTitle);
						octExamDetails.setOCTExamTitle(ocExamTitle);
						octExamDetails.setoCExamTitleId(octExam.getOctExamTitleId());

					}

					octExamDetailsList.add(octExamDetails);
				}

			}
		}
		return octExamDetailsList;
	}

	public List<OCTRegistration> getOCTRegistrationByScheduleIdAndStatus(ThemeDisplay themeDisplay, long examScheduleId,
			String statusRegisted) {
		List<OCTRegistration> registrations = new ArrayList<>();
		try {
			String registrationUrl = themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_REGISTRATIONS
					+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION
					+ "filter=oCExamScheduleId"
					+ URLEncoder.encode(" eq " + examScheduleId + " and regStatus eq '" + statusRegisted + "'",
							StandardCharsets.UTF_8)+ "&pageSize=0";
			logger.info("registration url " + registrationUrl);
			String registrationResponse = omsbCommonApi.getData(registrationUrl);
			logger.info("registration registrationResponse " + registrationResponse);

			OCTRegistrationItem registration = CustomObjectMapperUtil.readValue(registrationResponse,
					OCTRegistrationItem.class);

			if (Validator.isNotNull(registration) && !registration.getItems().isEmpty()) {
				logger.info("size of exam reg::" + registration.getItems().size());
				for (OCTRegistration registrationItem : registration.getItems()) {
					logger.info(registrationItem.getRegStatus());

					if (registrationItem.getRegStatus().equalsIgnoreCase("registered")) {
						User user = UserLocalServiceUtil.getUser(registrationItem.getLrUserId());
						if (Validator.isNotNull(user)) {
							registrationItem.setName(user.getFullName());
						}

						OCTExamResult examResult = getExamResultByUserId(registrationItem.getLrUserId(), themeDisplay,
								examScheduleId);
						if (Validator.isNotNull(examResult) && Validator.isNotNull(examResult.getItems())
								&& !examResult.getItems().isEmpty()) {
							logger.info(examResult.getItems());
							OCTExamResultItem examResultItem = examResult.getItems().get(0);
							if (Validator.isNotNull(examResultItem)) {
								registrationItem.setAppeared(String.valueOf(examResultItem.isAppeared()));
								registrationItem.setPercentage(examResultItem.getPercentage());
								registrationItem.setResult(examResultItem.getResult());
								logger.info("registartion : result from exam result:" + examResultItem.getResult());
							}
						}
						registrationItem.setExamScheduleId(examScheduleId);
						registrationItem.setLrUserId(user.getUserId());
						registrations.add(registrationItem);
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.info("getRegistrationByUserIdProgramAndExamType() ended ");
		return registrations;
		// TODO Auto-generated method stub
	}

	public OCTExamSchedule getOCTExamScheduleById(long octExamScheduleId, String portalURL) {
		String octExamScheduleUrl = portalURL + LRObjectURL.OC_EXAM_SCHEDULE + octExamScheduleId+ StringPool.QUESTION +"&pageSize=0";
		String octExamScheduleResponse = omsbHttpConnector.executeGet(octExamScheduleUrl, StringPool.BLANK,
				omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
		if (Validator.isNotNull(octExamScheduleResponse)) {
			OCTExamSchedule octExamSchedule = CustomObjectMapperUtil.readValue(octExamScheduleResponse,
					OCTExamSchedule.class);

			return octExamSchedule;
		}
		return null;
	}
	
	public OCTExamScheduleItems getOCTExamScheduleListByOCExamScheduleAdminId(long oCExamScheduleAdminId,
			String portalURL, long scopeGroupId) {
		String examScheduleURL = portalURL+ LRObjectURL.OC_EXAM_SCHEDULE + CommonConstants.SCOPES
				+ StringPool.SLASH + scopeGroupId + StringPool.QUESTION + "filter=oCExamScheduleAdminId"
				+ URLEncoder.encode(" eq " + oCExamScheduleAdminId, StandardCharsets.UTF_8);
		String examScheduleResponse = omsbHttpConnector.executeGet(examScheduleURL, "",
				omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
		OCTExamScheduleItems octExamScheduleItems = CustomObjectMapperUtil.readValue(examScheduleResponse,
				OCTExamScheduleItems.class);
		return octExamScheduleItems;
	}

	public OCTExamDefinition getOCTExamDefinitionByDefinitionId(long examDefinitionId, String portalURL) {
		try {
			String octExamDefinitionUrl = portalURL + LRObjectURL.OC_EXAM_DEFINITION + examDefinitionId+ StringPool.QUESTION +"&pageSize=0";
			String octExamDefinitionResponse = omsbHttpConnector.executeGet(octExamDefinitionUrl, StringPool.BLANK,
					omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
			if (Validator.isNotNull(octExamDefinitionResponse)) {
				OCTExamDefinition octExamDefinition = CustomObjectMapperUtil.readValue(octExamDefinitionResponse,
						OCTExamDefinition.class);
				return octExamDefinition;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	public List<OCTExamDefinition> getOCTExamDefinitionsByExamTitleId(long examTitleId, String portalURL,
			long scopeGroupId) {
		String octExamDefinitionUrl = portalURL + LRObjectURL.OC_EXAM_DEFINITION + CommonConstants.SCOPES
				+ StringPool.SLASH + scopeGroupId + StringPool.QUESTION + "filter=oCExamTitleId"
				+ URLEncoder.encode(" eq " + examTitleId, StandardCharsets.UTF_8)+ "&pageSize=0";
		String octExamDefinitionsResponse = omsbHttpConnector.executeGet(octExamDefinitionUrl, StringPool.BLANK,
				omsbCommonApi.getHttpHeaderInfoAndBasicAuth());

		if (Validator.isNotNull(octExamDefinitionsResponse)) {
			OCTExamDefinitionItems octExamDefinitionItems = CustomObjectMapperUtil.readValue(octExamDefinitionsResponse,
					OCTExamDefinitionItems.class);

			if (Validator.isNotNull(octExamDefinitionItems)) {
				return octExamDefinitionItems.getItems();
			}
		}

		return null;
	}

	public OCTExamTitle getExamTitleByPicklistId(long picklistId, String portalURL, long scopeGroupId) {
		String url = portalURL + LRObjectURL.OC_EXAM_TITLE + CommonConstants.SCOPES + StringPool.SLASH + scopeGroupId
				+ StringPool.QUESTION + "filter=picklistId"
				+ URLEncoder.encode(" eq " + picklistId, StandardCharsets.UTF_8)+ "&pageSize=0";
		;
		String response = omsbHttpConnector.executeGet(url, "", omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
		OCTExamTitleItem octExamTitleItem = CustomObjectMapperUtil.readValue(response, OCTExamTitleItem.class);
		if (Validator.isNotNull(octExamTitleItem)
				&& (Validator.isNotNull(octExamTitleItem.getItems()) && !octExamTitleItem.getItems().isEmpty())) {
			return octExamTitleItem.getItems().get(0);
		}
		return null;
	}

	public OCTExamDefinition getOCTExamDefintionByOCTExamId(String portalURL, long scopeGroupId, long octExamId) {

		String examDefinitionUrl = portalURL + LRObjectURL.OC_EXAM_DEFINITION + CommonConstants.SCOPES
				+ StringPool.SLASH + scopeGroupId + StringPool.QUESTION + OCTExamConstants.SORT_BY_ID_DESC + "&filter=oCExamId"
				+ URLEncoder.encode(" eq " + octExamId, StandardCharsets.UTF_8);
		String examDefinitionResponse = omsbCommonApi.getData(examDefinitionUrl);
		if (Validator.isNotNull(examDefinitionResponse)) {
			OCTExamDefinitionItems octExamDefinitionItems = CustomObjectMapperUtil.readValue(examDefinitionResponse,
					OCTExamDefinitionItems.class);
			if (Validator.isNotNull(octExamDefinitionItems) && Validator.isNotNull(octExamDefinitionItems.getItems())
					&& !octExamDefinitionItems.getItems().isEmpty()) {
				return octExamDefinitionItems.getItems().get(0);
			}
		}

		return null;
	}

	public void updateOCTExam(OCTExam octExam, long octExamId, OCTExamDetails octExamDetails, String portalURL)
			throws JsonProcessingException {

		String octExamMapper = CustomObjectMapperUtil.writeValueAsString(octExam, null);
		omsbHttpConnector.executePut(portalURL + LRObjectURL.OC_EXAM + octExam.getId(), octExamMapper,
				omsbCommonApi.getHttpHeaderInfoAndBasicAuth());

	}

	public OCTExamDetails getOCTExamDetailsListByExamId(long octExamId, long companyId, long scopeGroupId,
			String portalUrl, Locale locale) {
		try {
			String url = portalUrl + LRObjectURL.OC_EXAM + CommonConstants.SCOPES + StringPool.SLASH + scopeGroupId
					+ StringPool.QUESTION + OCTExamConstants.SORT_BY_ID_DESC + StringPool.AMPERSAND
					+ OCTExamConstants.OC_EXAM_ID_FILTER + StringPool.APOSTROPHE + octExamId + StringPool.APOSTROPHE;
			logger.info("url: "+url);
			String response = omsbHttpConnector.executeGet(url, "", omsbCommonApi.getHttpHeaderInfoAndBasicAuth());

			List<OCTExamDetails> octExamDetailsList = getOCTExamDetailsListByResponse(response, locale);
			if(Validator.isNotNull(octExamDetailsList) && !octExamDetailsList.isEmpty()) {
			return octExamDetailsList.get(0);
			}
		} catch (JsonProcessingException e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	public long getExamStatusIdByListTypeKey(String key, long companyId) {
		logger.info("calling set status method...........");
		ListTypeEntry entry = omsbCommonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.PL_EXAM_STATUS, key,
				companyId);
		logger.info("entry is ........" + entry);
		if (Validator.isNotNull(entry)) {
			return entry.getListTypeEntryId();
		}
		logger.info("calling set status method. ends..........");
		return 0;
	}

	public void saveOCTExamFormNumber(OCTExamFormNumber octExamFormNumber, long examDefinitionId, String portalURL,
			long scopeGroupId) {

		String examFormNumberMapper = CustomObjectMapperUtil.writeValueAsString(octExamFormNumber, null);
		String examFormNumberUrl = portalURL + LRObjectURL.OC_EXAM_FORM_NUMBERS + CommonConstants.SCOPES
				+ StringPool.SLASH + scopeGroupId;
		omsbHttpConnector.executePost(examFormNumberUrl, examFormNumberMapper,
				omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
	}

	public void saveExamBlueprint(OCTExamBlueprint octExamBlueprint, long examDefinitionId, String portalURL,
			long scopeGroupId) {

		String examBlueprintMapper = CustomObjectMapperUtil.writeValueAsString(octExamBlueprint, null);
		String examBlueprintUrl = portalURL + LRObjectURL.OC_EXAM_BLUE_PRINTS + CommonConstants.SCOPES
				+ StringPool.SLASH + scopeGroupId;
		omsbHttpConnector.executePost(examBlueprintUrl, examBlueprintMapper,
				omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
	}

	public String saveRescheduleFees(OCTRescheduleFees octRescheduleFees, long examDefinitionId, String portalURL,
			long scopeGroupId) {

		String rescheduleFeesMapper = CustomObjectMapperUtil.writeValueAsString(octRescheduleFees, null);
		String rescheduleFeesUrl = portalURL + LRObjectURL.OC_EXAM_RESCHEDULING_FEES + CommonConstants.SCOPES
				+ StringPool.SLASH + scopeGroupId;
		String response = omsbHttpConnector.executePost(rescheduleFeesUrl, rescheduleFeesMapper,
				omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
		return response;

	}

	public String saveOCTExamCancellationFees(OCTExamCancellationFees octExamCancellationFees, long examDefinitionId,
			String portalURL, long scopeGroupId) {

		String cancellationFeesMapper = CustomObjectMapperUtil.writeValueAsString(octExamCancellationFees, null);
		String cancellationFeesUrl = portalURL + LRObjectURL.OC_EXAM_CANCELLATION_FEES + CommonConstants.SCOPES
				+ StringPool.SLASH + scopeGroupId;
		String response = omsbHttpConnector.executePost(cancellationFeesUrl, cancellationFeesMapper,
				omsbCommonApi.getHttpHeaderInfoAndBasicAuth());

		return response;
	}

	public String saveRegularFees(OCTRegularFees octRegularFees, long examDefinitionId, String portalURL,
			long scopeGroupId) {

		String examRegularFeesMapper = CustomObjectMapperUtil.writeValueAsString(octRegularFees, null);
		String examRegularFeesUrl = portalURL + LRObjectURL.OC_EXAM_REGULAR_FEES + CommonConstants.SCOPES
				+ StringPool.SLASH + scopeGroupId;
		String response = omsbHttpConnector.executePost(examRegularFeesUrl, examRegularFeesMapper,
				omsbCommonApi.getHttpHeaderInfoAndBasicAuth());

		return response;
	}

	public String saveExamDefition(OCTExamDefinition octExamDefinition, long octExamId, String portalURL,
			long scopeGroupId) {

		String examDefinitionMapper = CustomObjectMapperUtil.writeValueAsString(octExamDefinition, null);
		String examDefinitionUrl = portalURL + LRObjectURL.OC_EXAM_DEFINITION + CommonConstants.SCOPES
				+ StringPool.SLASH + scopeGroupId;
		String octExamDefinitionPostStatus = omsbHttpConnector.executePost(examDefinitionUrl, examDefinitionMapper,
				omsbCommonApi.getHttpHeaderInfoAndBasicAuth());

		return octExamDefinitionPostStatus;
	}

	public String saveOCTExamSchedule(OCTExamSchedule octExamSchedule, String portalURL, long scopeGroupId) {
		String examScheduleUrl = portalURL + LRObjectURL.OC_EXAM_SCHEDULE + CommonConstants.SCOPES + StringPool.SLASH
				+ scopeGroupId;
		String scheduleMapper = CustomObjectMapperUtil.writeValueAsString(octExamSchedule, null);
		String response = omsbHttpConnector.executePost(examScheduleUrl, scheduleMapper,
				omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
		return response;
	}

	public String updateOCTExamSchedule(OCTExamSchedule octExamSchedule, String portalURL, long scopeGroupId) {
		String examScheduleUrl = portalURL + LRObjectURL.OC_EXAM_SCHEDULE + octExamSchedule.getId();
		String scheduleMapper = CustomObjectMapperUtil.writeValueAsString(octExamSchedule, null);
		String response = omsbHttpConnector.executePut(examScheduleUrl, scheduleMapper,
				omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
		return response;
	}

	// public static Object objectMapper(Object object){
	// ObjectMapper mapper = new ObjectMapper();
	// mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	// OCTExamDefinition octExamDefinition = mapper.convertValue(object,
	// OCTExamDefinition.class);
	// return octExamDefinition;
	// }

	public OCTExamResultItem getExamResultById(long examResultId, ThemeDisplay themeDisplay) {

		logger.info("--getExamResultById");
		OCTExamResultItem examResult = null;
		String examResultsUrl = themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_RESULT_URL + examResultId;
		String examResultsResponse = commonApi.getData(examResultsUrl);
		logger.info("--getExamResultById examResultsResponse" + examResultsResponse);

		if (examResultsResponse.contains("lrUserId")) {
			examResult = CustomObjectMapperUtil.readValue(examResultsResponse, OCTExamResultItem.class);
		}
		return examResult;
	}

	public String getName(long lrUserId) {

		logger.info("-----getName method");
		User user;
		try {
			user = UserLocalServiceUtil.getUser(lrUserId);
			if (Validator.isNotNull(user)) {
				return user.getFullName();
			}
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "NA";
	}

	public String getExamType(long examTypeId, String portalURL) {
		logger.info("--getExamType");

		String url = portalURL + LRObjectURL.OC_EXAM_TYPE_URL + examTypeId;
		String response = httpConnector.executeGet(url, "", commonApi.getHttpHeaderInfoAndBasicAuth());
		logger.info("--getExamType response" + response);

		OCTExamType examType = CustomObjectMapperUtil.readValue(response, OCTExamType.class);
		if (!response.isEmpty() && Validator.isNotNull(examType) && (response.contains("examType"))) {
			return examType.getExamType().getName();

		}
		return "";
	}

	public OCTExamAppeal getExamAppealByExamResultId(ThemeDisplay themeDisplay, long examResultId) {
		OCTExamAppeal appeal = null;
		String getUrl = themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_APPEAL_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=examResultId"
				+ URLEncoder.encode(" eq " + examResultId, StandardCharsets.UTF_8);

		String appealResponse = commonApi.getData(getUrl);
		if (appealResponse.contains("examResultId")) {
			OCTExamAppealItem appealItem = CustomObjectMapperUtil.readValue(appealResponse, OCTExamAppealItem.class);
			if (Validator.isNotNull(appealItem) && Validator.isNotNull(appealItem.getItems())
					&& !appealItem.getItems().isEmpty()) {
				appeal = appealItem.getItems().get(0);
			}
		}
		return appeal;
	}

	public OCTRegistration getExamRegistrationByRegistrationId(ThemeDisplay themeDisplay, long registrationId) {
		OCTRegistration registration = null;
		String getUrl = themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_REGISTRATIONS + registrationId;

		String registrationResponse = commonApi.getData(getUrl);
		logger.info("registrationResponse  " + registrationResponse);
		if (registrationResponse.contains("id")) {
			OCTRegistration registrationItem = CustomObjectMapperUtil.readValue(registrationResponse,
					OCTRegistration.class);
			if (Validator.isNotNull(registrationItem)) {
				logger.info("==================");
				registration = registrationItem;

			}
		}
		logger.info("registration  " + registration);
		return registration;
	}

	/*
	 * public String getProgramByProgramId(long programId, ThemeDisplay
	 * themeDisplay) { try { if (programId > 0) { ProgramMaster programMaster =
	 * ProgramMasterLocalServiceUtil.getProgramMaster(programId); if
	 * (Validator.isNotNull(programMaster)) { return
	 * CommonUtil.getValueByLanguage(programMaster.getProgramName(),
	 * OMSBExamWebPortletKeys.PROGRAM_NAME, themeDisplay.getLocale().toString()); }
	 * }
	 * 
	 * } catch (Exception e) { logger.error(e.getMessage(), e); } return ""; }
	 */

	@Reference(unbind = "-")
	private OMSBCommonApi commonApi;

	public OCTExamResult getExamResultByUserId(long lrUserId, ThemeDisplay themeDisplay, long examScheduleId) {
		String examResultUrl = themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_RESULTS + CommonConstants.SCOPES
				+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=lrUserId"
				+ URLEncoder.encode(" eq " + lrUserId + " and oCExamScheduleId eq " + examScheduleId,
						StandardCharsets.UTF_8);
		String examResultresponse = omsbCommonApi.getData(examResultUrl);
		logger.info(examResultUrl + "" + examResultresponse);
		return CustomObjectMapperUtil.readValue(examResultresponse, OCTExamResult.class);
	}

	public OCTExamResultItem getOCTExamResultByUserId(ThemeDisplay themeDisplay, long lrUserId) {
		try {
			String examResultUrl = themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_RESULTS + CommonConstants.SCOPES
					+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=lrUserId"
					+ URLEncoder.encode(" eq " + lrUserId, StandardCharsets.UTF_8);
			String examResultresponse = omsbCommonApi.getData(examResultUrl);
			OCTExamResult octExamResult = CustomObjectMapperUtil.readValue(examResultresponse, OCTExamResult.class);
			if (Validator.isNotNull(octExamResult) && Validator.isNotNull(octExamResult.getItems())
					&& !octExamResult.getItems().isEmpty()) {
				return octExamResult.getItems().get(0);
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	public OCTExam getOCTExamByUserId(long octExamId, String portalURL) {
		String examUrl = portalURL + LRObjectURL.OC_EXAM + octExamId;
		String examResponse = omsbCommonApi.getData(examUrl);
		OCTExam octExam = CustomObjectMapperUtil.readValue(examResponse, OCTExam.class);
		if (Validator.isNotNull(octExam)) {
			return octExam;
		}
		return null;
	}

	public List<OCTExamSchedule> getOCTExamScheduleList(String portalURL, long scopeGroupId) {
		String examScheduleURL = portalURL + LRObjectURL.OC_EXAM_SCHEDULE + CommonConstants.SCOPES + StringPool.SLASH
				+ scopeGroupId + StringPool.QUESTION + OCTExamConstants.SORT_BY_ID_DESC;
		String examScheduleResponse = omsbCommonApi.getData(examScheduleURL);
		if (Validator.isNotNull(examScheduleResponse)) {
			OCTExamScheduleItems octExamScheduleItems = CustomObjectMapperUtil.readValue(examScheduleResponse,
					OCTExamScheduleItems.class);
			if (Validator.isNotNull(octExamScheduleItems)) {
				return octExamScheduleItems.getItems();
			}
		}
		return null;
	}

	public OCTExamPayment getOCTExamPaymentByOrderId(String orderId, String portalURL, long scopeGroupId) {
		String examPaymentURL = portalURL + LRObjectURL.OC_EXAM_PAYMENTS_URL + CommonConstants.SCOPES + StringPool.SLASH
				+ scopeGroupId + StringPool.QUESTION + "filter=orderId" + URLEncoder.encode(
						" eq " + StringPool.APOSTROPHE + orderId + StringPool.APOSTROPHE, StandardCharsets.UTF_8);
		String examPaymentResponse = omsbCommonApi.getData(examPaymentURL);
		if (Validator.isNotNull(examPaymentResponse)) {
			OCTExamPaymentItems octExamPaymentItems = CustomObjectMapperUtil.readValue(examPaymentResponse,
					OCTExamPaymentItems.class);
			if (Validator.isNotNull(octExamPaymentItems) && octExamPaymentItems.getItems().size() > 0) {
				return octExamPaymentItems.getItems().get(0);
			}
		}
		return null;
	}

	public String generateOrderId(String portalURL, long scopeGroupId) {

		long max = 1000000000l;
		long min = 9999999999l;
		long range = max - min + 1;
		long rand = (long) (Math.random() * range) + min;
		String orderId = String.valueOf(rand);
		OCTExamPayment octExamPayment = getOCTExamPaymentByOrderId(orderId, portalURL, scopeGroupId);
		if (Validator.isNotNull(octExamPayment)) {
			orderId = generateOrderId(portalURL, scopeGroupId);
		}
		return orderId;
	}

	public String getObjectClassName(String erc, long companyId) {
		ObjectDefinition definition = null;
		try {
			definition = objectDefinitionService.getObjectDefinitionByExternalReferenceCode(erc, companyId);
			if (Validator.isNotNull(definition)) {
				return definition.getClassName();
			}
		} catch (PortalException e) {
			logger.error(e.getMessage());
		}
		return "";
	}
	
	public List<OCTExamSchedule> getOCTExamScheduleListByExamTitleId(String portalURL, long scopeGroupId,long examTitleId) {
		String examScheduleURL = portalURL + LRObjectURL.OC_EXAM_SCHEDULE + CommonConstants.SCOPES + StringPool.SLASH
				+ scopeGroupId + StringPool.QUESTION + "octExamTitleId="+examTitleId + OCTExamConstants.SORT_BY_EXAM_DATE_DESC;
		String examScheduleResponse = omsbCommonApi.getData(examScheduleURL);
		if (Validator.isNotNull(examScheduleResponse)) {
			OCTExamScheduleItems octExamScheduleItems = CustomObjectMapperUtil.readValue(examScheduleResponse,
					OCTExamScheduleItems.class);
			if (Validator.isNotNull(octExamScheduleItems)) {
				return octExamScheduleItems.getItems();
			}
		}
		return null;
	}
	
	public OCTExamJsonFields getExamJsonFields(ActionRequest actionRequest, ThemeDisplay themeDisplay,
			UploadPortletRequest uploadPortletRequest) {
		try {
			OCTExamJsonFields examJsonFields = new OCTExamJsonFields();
			examJsonFields.setExamTitleId(ParamUtil.getLong(actionRequest, "examTitle"));
			examJsonFields.setExamDuration(ParamUtil.getInteger(actionRequest, "durationOfExam"));
			examJsonFields.setCutScore(ParamUtil.getInteger(actionRequest, "cutScore"));
			examJsonFields.setScoreValidity(ParamUtil.getInteger(actionRequest, "scoreValidity"));
			examJsonFields.setResultSource(ParamUtil.getLong(actionRequest, "resultSource"));
			examJsonFields.setCutOffWindow(ParamUtil.getInteger(actionRequest, "registrationCutOfWindow"));
			examJsonFields.setExamFormNo(ParamUtil.getInteger(actionRequest, "examFormNo"));
			examJsonFields.setLocationOnGoogleMap(ParamUtil.getString(actionRequest, "locationOnGoogleMap"));
			examJsonFields.setVenue(ParamUtil.getString(actionRequest, "venue"));
			examJsonFields.setEarlyBirdFeesDate(ParamUtil.getInteger(actionRequest, "applicableDays"));
			examJsonFields.setEarlyBirdFees(ParamUtil.getFloat(actionRequest, "feeAmount"));
			examJsonFields.setAutoSchedulingPeriod(ParamUtil.getInteger(actionRequest, "reSchedulePeriod"));
			examJsonFields.setAppealWindow(ParamUtil.getInteger(actionRequest, "appealWindow"));
			examJsonFields.setReAppealWindow(ParamUtil.getInteger(actionRequest, "reAppealWindow"));
			examJsonFields.setAppealFees(ParamUtil.getFloat(actionRequest, "appealFees"));
			examJsonFields.setReAppealFees(ParamUtil.getFloat(actionRequest, "reAppealFees"));
			examJsonFields.setEligibilityCheck(ParamUtil.getBoolean(actionRequest, "eligibilityCheck"));
			examJsonFields.setApplyEligibility(ParamUtil.getBoolean(actionRequest, "applyEligibility"));
			examJsonFields.setOmaniMaxAttempts(ParamUtil.getInteger(actionRequest, "omaniMaxAttempts"));
			examJsonFields.setOmaniMaxTimePeriod(ParamUtil.getInteger(actionRequest, "omaniMaxTimePeriod"));
			examJsonFields.setOmaniTimePeriod(ParamUtil.getInteger(actionRequest, "omaniTimePeriod"));
			examJsonFields.setNonOmaniMaxAttempts(ParamUtil.getInteger(actionRequest, "nonomaniMaxAttempts"));
			examJsonFields.setNonOmaniMaxTimePeriod(ParamUtil.getInteger(actionRequest, "nonomaniMaxTimePeriod"));
			examJsonFields.setNonOmaniTimePeriod(ParamUtil.getInteger(actionRequest, "nonomaniTimePeriod"));
			examJsonFields.setModified(true);
			String examFormsResponse = ParamUtil.getString(actionRequest, "examForms");
			String regularFeeResponse = ParamUtil.getString(actionRequest, "regularFeeJsonData");
			String rescheduleFeeResponse = ParamUtil.getString(actionRequest, "rescheduleFeeJsonData");
			String cancellationFeeResponse = ParamUtil.getString(actionRequest, "cancellationFeeJsonData");
			String blueprintResponse = ParamUtil.getString(actionRequest, "blueprint");
			examJsonFields.setOctExamFormNumbers(getExamFormNumber(examFormsResponse));
			examJsonFields.setOctRegularFees(getoctRegularFees(regularFeeResponse));
			examJsonFields.setOctRescheduleFees(getoctRescheduleFees(rescheduleFeeResponse));
			examJsonFields.setOctExamCancellationFees(getoctCancellationFees(cancellationFeeResponse));
			examJsonFields.setOctExamBlueprints(
					getoctExamBlueprint(blueprintResponse, actionRequest, themeDisplay, uploadPortletRequest));
			return examJsonFields;
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	public List<OCTExamFormNumber> getExamFormNumber(String examFormsResponse) {
		try {

			OCTExamFormNumberItem examFormItem = CustomObjectMapperUtil.readValue(examFormsResponse,
					OCTExamFormNumberItem.class);
			if (Validator.isNotNull(examFormItem) && Validator.isNotNull(examFormItem.getItems())
					&& !examFormItem.getItems().isEmpty()) {
				logger.info("size of examFormItem:" + examFormItem.getItems().size());
				return examFormItem.getItems();
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	public List<OCTRegularFees> getoctRegularFees(String regularFeeResponse) {
		try {
			OCTRegularFeesItem octRegularFeesItem = CustomObjectMapperUtil.readValue(regularFeeResponse,
					OCTRegularFeesItem.class);

			if (Validator.isNotNull(octRegularFeesItem) && Validator.isNotNull(octRegularFeesItem.getItems())
					&& !octRegularFeesItem.getItems().isEmpty()) {
				return octRegularFeesItem.getItems();
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	public List<OCTRescheduleFees> getoctRescheduleFees(String rescheduleFeeResponse) {
		try {
			OCTRescheduleFeesItem octRescheduleFeesItem = CustomObjectMapperUtil.readValue(rescheduleFeeResponse,
					OCTRescheduleFeesItem.class);
			if (Validator.isNotNull(octRescheduleFeesItem) && Validator.isNotNull(octRescheduleFeesItem.getItems())
					&& !octRescheduleFeesItem.getItems().isEmpty()) {
				return octRescheduleFeesItem.getItems();
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	public List<OCTExamCancellationFees> getoctCancellationFees(String cancellationFeeResponse) {
		try {
			OCTCancellationFeesItem octCancellationFeesItem = CustomObjectMapperUtil.readValue(cancellationFeeResponse,
					OCTCancellationFeesItem.class);
			if (Validator.isNotNull(octCancellationFeesItem) && Validator.isNotNull(octCancellationFeesItem.getItems())
					&& !octCancellationFeesItem.getItems().isEmpty()) {
				return octCancellationFeesItem.getItems();
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	public OCTExam getExamById(long examId, String portalURL) {
		String url = portalURL + LRObjectURL.OC_EXAM + examId;
		String response = commonApi.getData(url);
		return CustomObjectMapperUtil.readValue(response, OCTExam.class);
	}

	public String getLatesDateAndTime() {

		Timestamp ts = new Timestamp(new Date().getTime());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date fechaNueva = null;
		try {
			fechaNueva = format.parse(ts.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String dtTm = format.format(fechaNueva).replace("-", "_");
		dtTm = dtTm.replace(":", "_");
		dtTm = dtTm.replace(" ", "_");
		return dtTm;
	}

	public Folder getFolder(long groupId, String folderName) {
		try {
			return DLAppLocalServiceUtil.getFolder(groupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, folderName);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	public static Folder createNewFolder(UploadPortletRequest uploadPortletRequest, String folderName) {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) uploadPortletRequest.getAttribute(WebKeys.THEME_DISPLAY);
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(),
					uploadPortletRequest);
			return DLAppLocalServiceUtil.addFolder(folderName, themeDisplay.getUserId(),
					serviceContext.getScopeGroupId(), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, folderName,
					ROOT_FOLDER_DESCRIPTION, serviceContext);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	public List<OCTExamBlueprint> getoctExamBlueprint(String blueprintResponse, ActionRequest actionRequest,
			ThemeDisplay themeDisplay, UploadPortletRequest uploadPortletRequest) {
		try {
			String folderName = "Exam Title";
			Folder folder = getFolder(themeDisplay.getScopeGroupId(), folderName);
			if (Validator.isNull(folder)) {
				folder = createNewFolder(uploadPortletRequest, folderName);
			}
//			long folderId = 0;
//			if (Validator.isNotNull(folder)) {
//				folderId = folder.getFolderId();
//			}
			OCTExamBlueprintItem octExamBlueprintItem = CustomObjectMapperUtil.readValue(blueprintResponse,
					OCTExamBlueprintItem.class);
			if (Validator.isNotNull(octExamBlueprintItem) && Validator.isNotNull(octExamBlueprintItem.getItems())
					&& !octExamBlueprintItem.getItems().isEmpty()) {
				logger.info("name: " + octExamBlueprintItem.getItems().get(0).getBlueprintTitle());
				logger.info("item size:" + octExamBlueprintItem.getItems().size());
				for (OCTExamBlueprint octExamBlueprint : octExamBlueprintItem.getItems()) {
					logger.info("blueprint to string " + octExamBlueprint.toString());
//					String fileName = octExamBlueprint.getName();
					String fileName = getLatesDateAndTime() + "_" + octExamBlueprint.getName();
					String rowNumber = octExamBlueprint.getName();
					logger.info("file name:" + fileName);
					UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
					File file = uploadRequest.getFile("docInput_" + rowNumber);
					FileEntry entry = FileUploadUtil.addDocument(fileName, file, FileUtil.getExtension(fileName),
							themeDisplay.getScopeGroupId(), 0);
					if (Validator.isNotNull(entry)) {
						logger.info("file entry id:" + entry.getFileEntryId());
						octExamBlueprint.setdLFileEntry(entry.getFileEntryId());
					}
				}
				return octExamBlueprintItem.getItems();
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	public long getoctExamByExamTitleId(ThemeDisplay themeDisplay, long examTitleId) {
		try {
			List<OCTExamDetails> octExamDetails = getOCTExamDetailsListByExamTitle(themeDisplay.getCompanyId(),
					themeDisplay.getScopeGroupId(), themeDisplay.getPortalURL(), examTitleId, themeDisplay.getLocale());
			if (Validator.isNotNull(octExamDetails) && !octExamDetails.isEmpty())
				return octExamDetails.get(0).getId();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return 0;
	}

	public void getOCTExamTitle(int examFormNo, ResourceResponse resourceResponse, long examTitleId,
			ThemeDisplay themeDisplay) {
		JSONArray examFormJsonArray = JSONFactoryUtil.createJSONArray();
		try {
			OCTExamTitle octExamTitle = getExamTitleByPicklistId(examTitleId, themeDisplay.getPortalURL(),
					themeDisplay.getScopeGroupId());
			if (Validator.isNotNull(octExamTitle)) {
				for (int index = 1; index <= examFormNo; index++) {
					JSONObject examFormJson = JSONFactoryUtil.createJSONObject();
					String threeDigitNumber = String.format("%03d", index);
					String generatedCode = octExamTitle.getCode() + "-" + threeDigitNumber;
					logger.info("Generated Exam Form Nos: " + generatedCode);
					examFormJson.put("examForm", generatedCode);
					examFormJsonArray.put(examFormJson);
				}
			}
			resourceResponse.getWriter().write(examFormJsonArray.toString());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	public void getExistOCTExam(long examTitleId, ResourceResponse resourceResponse, ThemeDisplay themeDisplay) {
		JSONArray existExamJsonArray = JSONFactoryUtil.createJSONArray();
		try {
			JSONObject existExamJson = JSONFactoryUtil.createJSONObject();
			long existExam = getoctExamByExamTitleId(themeDisplay, examTitleId);
			logger.info("inside update");
			existExamJson.put("existExam", existExam);
			existExamJson.put("examTypeName",
					omsbCommonApi.getListTypeEntryNameBylistTypeEntryId(examTitleId, themeDisplay.getLocale()));
			existExamJsonArray.put(existExamJson);
			resourceResponse.getWriter().write(existExamJsonArray.toJSONString());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	public ObjectDefinition getObjectDefinition(ThemeDisplay themeDisplay, String erc) {
		try {
			return objectDefinitionService.getObjectDefinitionByExternalReferenceCode(erc, themeDisplay.getCompanyId());
		} catch (PortalException e) {
			logger.error("Exception while calling getObjectDefinition :::: " + e);
		}
		return null;
	}

	public String getAppealStatusColor(boolean isAppeal, long statusId) {
		// TODO Auto-generated method stub
		try {
			ListTypeEntry entry = listTypeEntryLocalService.getListTypeEntry(statusId);
			if (Validator.isNotNull(entry)) {
				if (isAppeal) {
					return getColorMap("appeal " + entry.getKey());
				} else {
					return getColorMap("reappeal " + entry.getKey());
				}

			}
		} catch (PortalException e) {
			logger.error("Exception while getting the color code::", e);
		}
		return null;
	}

	public String getCancellatoinColor(long statusId) {
		try {
			ListTypeEntry entry = listTypeEntryLocalService.getListTypeEntry(statusId);
			if (Validator.isNotNull(entry)) {
				return getColorMap(entry.getKey());
			}
		} catch (PortalException e) {
			logger.error("Exception while getting the color code::", e);
		}
		return "";
	}

	public String getColorMap(String key) {
		Map<String, String> colorMap = new HashMap<>();
		colorMap.put(OmsbOctExamWebPortletKeys.PL_EXAM_STATUS_KEY_PENDING, "omsb-created-bg");
		colorMap.put(OmsbOctExamWebPortletKeys.PL_EXAM_STATUS_KEY_ACCEPTED, "omsb-completed-bg");
		colorMap.put(OmsbOctExamWebPortletKeys.PL_EXAM_STATUS_KEY_REJECTED, "omsb-stop-bg");

		colorMap.put(OmsbOctExamWebPortletKeys.PL_APPEAL_STATUS_KEY_PENDING, "omsb-created-bg");
		colorMap.put(OmsbOctExamWebPortletKeys.PL_APPEAL_STATUS_KEY_ACCEPTED, "omsb-completed-bg");
		colorMap.put(OmsbOctExamWebPortletKeys.PL_APPEAL_STATUS_KEY_REJECTED, "omsb-stop-bg");

		colorMap.put(OmsbOctExamWebPortletKeys.PL_REAPPEAL_STATUS_KEY_PENDING, "omsb-created-bg");
		colorMap.put(OmsbOctExamWebPortletKeys.PL_REAPPEAL_STATUS_KEY_ACCEPTED, "omsb-completed-bg");
		colorMap.put(OmsbOctExamWebPortletKeys.PL_REAPPEAL_STATUS_KEY_REJECTED, "omsb-stop-bg");

		colorMap.put(OmsbOctExamWebPortletKeys.PL_EXAM_STATUS_KEY_REGISTERED, "omsb-completed-bg");

		return colorMap.get(key);
	}

	public String getExamTitleById(long titleId, ThemeDisplay themeDisplay) {
		try {
			ObjectEntry entry = objectEntryLocalService.getObjectEntry(titleId);
			long pickListId = (long) entry.getValues().get(OCTExamConstants.FIELD_OC_EXAM_PICK_LIST_ID);
			return omsbCommonApi.getListTypeEntryNameBylistTypeEntryId(pickListId, themeDisplay.getLocale());
		} catch (PortalException e) {
			logger.error("exception while getting the object definition:::::", e);
		}
		return "";
	}

	public OCTExamReschedule getOCTExamRescheduleByExamDefinitionId(long examDefinitionId, ThemeDisplay themeDisplay,
			long lrUserId) {

		String examResultUrl = themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_RESCHEDULE + CommonConstants.SCOPES
				+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=lrUserId"
				+ URLEncoder.encode(" eq " + lrUserId, StandardCharsets.UTF_8);
		String examResultresponse = omsbCommonApi.getData(examResultUrl);
		return CustomObjectMapperUtil.readValue(examResultresponse, OCTExamReschedule.class);
	}

	public List<Person> getPersonDetail(ThemeDisplay themeDisplay, long userId) {
		String personDetailUrl = themeDisplay.getPortalURL() + LRObjectURL.PERSON_DETAIL_URL.replace("{scope-id}",
				themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=lrUserId"
						+ URLEncoder.encode(" eq " + userId, StandardCharsets.UTF_8));
		String personDetailResponse = omsbCommonApi.getData(personDetailUrl);
		logger.info("personDetailResponse::::" + personDetailResponse);
		PersonItem personItem = CustomObjectMapperUtil.readValue(personDetailResponse, PersonItem.class,
				new SimpleDateFormat(DataflowConstants.OBJECT_DATE_FORMAT));
		if (Validator.isNotNull(personItem) && Validator.isNotNull(personItem.getItems())
				&& !personItem.getItems().isEmpty()) {
			return personItem.getItems();
		}
		return new ArrayList<>();
	}

	public List<PersonalDetail> getPersonalDetail(ThemeDisplay themeDisplay, long personId) {
		String personalDetailUrl = themeDisplay.getPortalURL() + LRObjectURL.PERSONAL_DETAIL_URL.replace("{scope-id}",
				themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=personId"
						+ URLEncoder.encode(" eq " + personId, StandardCharsets.UTF_8));
		String personalDetailResponse = omsbCommonApi.getData(personalDetailUrl);
		PersonalDetailItem personalDetailItem = CustomObjectMapperUtil.readValue(personalDetailResponse,
				PersonalDetailItem.class);
		if (Validator.isNotNull(personalDetailItem) && Validator.isNotNull(personalDetailItem.getItems())
				&& !personalDetailItem.getItems().isEmpty()) {
			return personalDetailItem.getItems();
		}
		return new ArrayList<>();
	}

	public List<Country> getCountryDetails(ThemeDisplay themeDisplay, long countryId) {
		logger.info("getCountryDetails----");

		String countryUrl = themeDisplay.getPortalURL() + LRObjectURL.CUSTOM_COUNTRY_URL.replace("{scope-id}",
				themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=countryID"
						+ URLEncoder.encode(" eq " + countryId, StandardCharsets.UTF_8));
		logger.info(countryUrl);
		String countryResponse = omsbCommonApi.getData(countryUrl);
		logger.info("countryResponse" + countryResponse);
		CountryItem countryItem = CustomObjectMapperUtil.readValue(countryResponse, CountryItem.class);
		if (Validator.isNotNull(countryItem) && Validator.isNotNull(countryItem.getItems())
				&& !countryItem.getItems().isEmpty()) {
			return countryItem.getItems();
		}
		return new ArrayList<>();
	}

	public List<DocumentInfo> getEducationCentificate(ThemeDisplay themeDisplay, long componentClassRefId) {
		String documentInfoUrl = themeDisplay.getPortalURL() + LRObjectURL.DOCUMENT_INFO_URL.replace("{scope-id}",
				themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=componentClassRefId"
						+ URLEncoder.encode(" eq " + componentClassRefId, StandardCharsets.UTF_8));
		String documentInfoResponse = omsbCommonApi.getData(documentInfoUrl);

		logger.info("documentInfoUrl::::" + documentInfoUrl);
		logger.info("documentInfoResponse::::" + documentInfoResponse);
		DocumentInfoItem documeInfoItem = CustomObjectMapperUtil.readValue(documentInfoResponse, DocumentInfoItem.class,
				new SimpleDateFormat(DataflowConstants.OBJECT_DATE_FORMAT));
		if (Validator.isNotNull(documeInfoItem) && Validator.isNotNull(documeInfoItem.getItems())
				&& !documeInfoItem.getItems().isEmpty()) {
			return documeInfoItem.getItems();
		}
		return new ArrayList<>();
	}

	public OCTRegistrationItem getRegistrationByUserIdAndScheduleId(ThemeDisplay themeDisplay, long userId,
			long examScheduleId) {
		logger.info("getRegistrationByUserIdProgramAndExamType() started ");
		String registrationUrl = themeDisplay.getPortalURL()
				+ LRObjectURL.OC_EXAM_REGISTRATIONS + CommonConstants.SCOPES + StringPool.SLASH
				+ themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=lrUserId" + URLEncoder
						.encode(" eq " + userId + " and oCExamScheduleId eq " + examScheduleId, StandardCharsets.UTF_8)
				+ "&sort=dateCreated:desc";
		logger.info("registration url " + registrationUrl);
		String registrationResponse = omsbCommonApi.getData(registrationUrl);
		logger.info("registration registrationResponse " + registrationResponse);
		logger.info("getRegistrationByUserIdProgramAndExamType() ended ");
		OCTRegistrationItem OCTRegistrationItem = CustomObjectMapperUtil.readValue(registrationResponse,
				OCTRegistrationItem.class);
		return OCTRegistrationItem;

	}
	public OCTRegistrationItem getRegistrationByUserIdAndScheduleIdAndRegStatus(ThemeDisplay themeDisplay, long userId,
			long examScheduleId) {
		logger.info("getRegistrationByUserIdProgramAndExamType() started ");
		String registrationUrl = themeDisplay.getPortalURL()
				+ LRObjectURL.OC_EXAM_REGISTRATIONS + CommonConstants.SCOPES + StringPool.SLASH
				+ themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=lrUserId" + URLEncoder
						.encode(" eq " + userId + " and oCExamScheduleId eq " + examScheduleId + " and regStatus ne '" + "Pending" + "'", StandardCharsets.UTF_8)
				+ "&sort=dateCreated:desc&pageSize=0";
		logger.info("registration url " + registrationUrl);
		String registrationResponse = omsbCommonApi.getData(registrationUrl);
		logger.info("registration registrationResponse " + registrationResponse);
		logger.info("getRegistrationByUserIdProgramAndExamType() ended ");
		OCTRegistrationItem OCTRegistrationItem = CustomObjectMapperUtil.readValue(registrationResponse,
				OCTRegistrationItem.class);
		return OCTRegistrationItem;

	}

	public OCTRegistration getOCTRestrationById(String portalURL, long registrationId) {
		String octRegURL = portalURL + LRObjectURL.OC_EXAM_REGISTRATIONS + registrationId;
		String octRegResponse = omsbHttpConnector.executeGet(octRegURL, StringPool.BLANK,
				omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
		if (Validator.isNotNull(octRegResponse)) {
			OCTRegistration oCTRegistration = CustomObjectMapperUtil.readValue(octRegResponse, OCTRegistration.class);
			return oCTRegistration;
		}
		return null;
	}

	public List<OCTExamFormNumber> getOCTExamFormnumberByDefinitionId(ThemeDisplay themeDisplay,
			long examDefinitionId) {
		String oCTExamFormNumberUrl = themeDisplay.getPortalURL() + LRObjectURL.DOCUMENT_INFO_URL.replace("{scope-id}",
				themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=oCExamDefinitionId"
						+ URLEncoder.encode(" eq " + examDefinitionId, StandardCharsets.UTF_8));
		String oCTExamFormNumberResponse = omsbCommonApi.getData(oCTExamFormNumberUrl);
		OCTExamFormNumberItem oCTExamFormNumberItem = CustomObjectMapperUtil.readValue(oCTExamFormNumberResponse,
				OCTExamFormNumberItem.class);
		if (Validator.isNotNull(oCTExamFormNumberItem) && Validator.isNotNull(oCTExamFormNumberItem.getItems())
				&& !oCTExamFormNumberItem.getItems().isEmpty()) {
			return oCTExamFormNumberItem.getItems();
		}
		return new ArrayList<>();
	}

	// public String registrationStatus(long examScheduleId, ThemeDisplay
	// themeDisplay) {
	// String examRegURL = themeDisplay.getPortalURL() +
	// LRObjectURL.OC_EXAM_REGISTRATIONS + CommonConstants.SCOPES
	// + StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION +
	// "filter=oCExamScheduleId"
	// + URLEncoder.encode(" eq " + examScheduleId, StandardCharsets.UTF_8);
	// String examRegResponse = omsbHttpConnector.executeGet(examRegURL, "",
	// omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
	// if (Validator.isNotNull(examRegResponse)) {
	// OCTRegistrationItem examRegistrationItem =
	// CustomObjectMapperUtil.readValue(examRegResponse,
	// OCTRegistrationItem.class);
	// if (Validator.isNotNull(examRegistrationItem) &&
	// Validator.isNotNull(examRegistrationItem.getItems())
	// && !examRegistrationItem.getItems().isEmpty()) {
	// ListTypeEntry listTypeEntry =
	// omsbCommonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.OCT_EXAM_REG_STATUS,
	// examRegistrationItem.getItems().get(0).getRegStatus(),
	// themeDisplay.getScopeGroupId());
	// return
	//
	// }
	// }
	// }

	public OCTExamResultItem getTraineeExamResult(ThemeDisplay themeDisplay, long examResultId) {
		if (Validator.isNotNull(examResultId)) {
			OCTExamResultItem examResultItem = getExamResultById(examResultId, themeDisplay);
			OCTExamResultItem resultItem = new OCTExamResultItem();
			if (Validator.isNotNull(examResultItem)) {
				OCTExamDefinition examDefinition = getOCTExamDefinitionByDefinitionId(
						examResultItem.getoCExamDefinitionId(), themeDisplay.getPortalURL());

				resultItem.setoCExamScheduleId(examResultItem.getoCExamScheduleId());
				resultItem.setLrUserId(examResultItem.getLrUserId());
				resultItem.setPercentage(examResultItem.getPercentage());
				resultItem.setResult(examResultItem.getResult());
				if (Validator.isNotNull(examDefinition)) {
					resultItem.setExamtitle(omsbCommonApi.getListTypeEntryNameBylistTypeEntryId(
							examDefinition.getoCExamTitleId(), themeDisplay.getLocale()));

					return resultItem;
				}
			}
		}
		return null;
	}

	public String getregistrationStatus(long examScheduleId, String portalURL, long groupId, Locale locale,
			long companyId) {
		String examRegURL = portalURL + LRObjectURL.OC_EXAM_REGISTRATIONS + CommonConstants.SCOPES + StringPool.SLASH
				+ groupId + StringPool.QUESTION + "filter=oCExamScheduleId"
				+ URLEncoder.encode(" eq " + examScheduleId, StandardCharsets.UTF_8);
		String examRegResponse = omsbHttpConnector.executeGet(examRegURL, "",
				omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
		if (Validator.isNotNull(examRegResponse)) {
			OCTRegistrationItem examRegistrationItem = CustomObjectMapperUtil.readValue(examRegResponse,
					OCTRegistrationItem.class);
			logger.info("============================" + examRegistrationItem.getItems().get(0));
			logger.info("key::" + examRegistrationItem.getItems().get(0).getRegStatus());
			logger.info("companyId ==== " + companyId);
			if (Validator.isNotNull(examRegistrationItem) && Validator.isNotNull(examRegistrationItem.getItems())
					&& !examRegistrationItem.getItems().get(0).getRegStatus().isEmpty()
					&& !examRegistrationItem.getItems().isEmpty()) {

				ListTypeEntry listTypeEntry = omsbCommonApi.getListTypeEntryByListTypeItemKey(
						LRPicklistConstants.OCT_EXAM_REG_STATUS, examRegistrationItem.getItems().get(0).getRegStatus(),
						companyId);
				if (Validator.isNotNull(listTypeEntry)) {
					return listTypeEntry.getName(locale);
				}
			}
		}
		return "";
	}

	public OCTRegistration getExamRegistrationWorkflowData(ThemeDisplay themeDisplay, OCTRegistration registration) {
		logger.info("<------inside getExamRegistrationWorkflowData------>>>");

		String className = getObjectClassName(OmsbOctExamWebPortletKeys.OC_EXAM_REGISTRATION_TEMP_OBJECT_ERC,
				themeDisplay.getCompanyId());
		boolean assignedToRole = false;
		long workflowTaskId = 0;
		long workflowInstanceId = 0;

		long registrationId = registration.getId();

		logger.info("registrationId------>>>" + registrationId);
		OCTExamRegistrationTemp examRegistrationTemp = getExamRegistrationTempById(themeDisplay, registrationId);

		if (Validator.isNotNull(examRegistrationTemp)) {
			logger.info("  examRegistrationTemp   " + examRegistrationTemp.toString());

			try {
				WorkflowInstance instance = CustomWorkflowTaskUtil.getWorkflowInstace(className, themeDisplay,
						examRegistrationTemp.getId());
				if (Validator.isNotNull(instance)) {
					workflowInstanceId = instance.getWorkflowInstanceId();
				}
				List<WorkflowLog> logs = CustomWorkflowTaskUtil.getWorkflowLogs(themeDisplay.getCompanyId(), instance);
				if (!logs.isEmpty()) {
					long assigneeRoleId = CustomWorkflowTaskUtil.getWorkflowAssigneeRoleIdByLogs(logs);
					assignedToRole = CustomWorkflowTaskUtil.isWorkFlowTaskAssignedToRole(themeDisplay, assigneeRoleId);
					workflowTaskId = CustomWorkflowTaskUtil.getWorkflowTaskIdByLogs(logs);
				}
				List<String> transitionNames = CustomWorkflowTaskUtil.getTransitionNames(themeDisplay, workflowTaskId);
				registration.setAssignedToMe(assignedToRole);
				registration.setWorkflowInstanceId(workflowInstanceId);
				registration.setWorkflowTaskId(workflowTaskId);
				registration.setTransitionNames(transitionNames);
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}

		return registration;
	}

	public OCTExamRegistrationTemp getExamRegistrationTempById(ThemeDisplay themeDisplay, long registrationId) {

		String url = themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_REGISTRATION_TEMP_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION
				+ "filter=oCExamRegistrationId" + URLEncoder.encode(" eq " + registrationId, StandardCharsets.UTF_8);

		String response = omsbCommonApi.getData(url);

		logger.info("response of OCTExamRegistrationTemp::::" + response);

		OCTExamRegistrationTempItem octExamRegTempItem = CustomObjectMapperUtil.readValue(response,
				OCTExamRegistrationTempItem.class);
		if (Validator.isNotNull(octExamRegTempItem)
				&& (Validator.isNotNull(octExamRegTempItem.getItems()) && !octExamRegTempItem.getItems().isEmpty())) {
			return octExamRegTempItem.getItems().get(0);
		}
		return null;

	}

	// public OCTRegistration getOCTRestrationById(String portalURL, long
	// registrationId) {
	// String octRegURL = portalURL + LRObjectURL.OC_EXAM_REGISTRATIONS +
	// registrationId;
	// String octRegResponse = omsbHttpConnector.executeGet(octRegURL,
	// StringPool.BLANK,
	// omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
	// if (Validator.isNotNull(octRegResponse)) {
	// OCTRegistration oCTRegistration =
	// CustomObjectMapperUtil.readValue(octRegResponse, OCTRegistration.class);
	// return oCTRegistration;
	// }
	// return null;
	// }

	public List<EducationDetail> getEducationDetail(ThemeDisplay themeDisplay, long personId) {
		String personDetailUrl = themeDisplay.getPortalURL() + LRObjectURL.EDUCATION_DETAIL_URL.replace("{scope-id}",
				themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=personId"
						+ URLEncoder.encode(" eq " + personId, StandardCharsets.UTF_8));
		String personDetailResponse = omsbCommonApi.getData(personDetailUrl);
		logger.info("personDetailResponse::::" + personDetailResponse);
		EducationDetailItem educationDetailItem = CustomObjectMapperUtil.readValue(personDetailResponse,
				EducationDetailItem.class, new SimpleDateFormat(DataflowConstants.OBJECT_DATE_FORMAT));
		if (Validator.isNotNull(educationDetailItem) && Validator.isNotNull(educationDetailItem.getItems())
				&& !educationDetailItem.getItems().isEmpty()) {
			return educationDetailItem.getItems();
		}
		return new ArrayList<>();
	}

	public void assignOrCompleteWorkflow(String tName, String cmd, ThemeDisplay themeDisplay,
			WorkflowInstance workflowInstance, long workflowTaskId) {
		logger.info("transitionName ?? " + tName);
		logger.info("cmd ?? " + cmd);
		logger.info("workflowInstance ?? " + workflowInstance.getWorkflowInstanceId());
		logger.info("workflowTaskId ?? " + workflowTaskId);
		if (CommonConstants.CMD_ASSIGN_TO_ME.equalsIgnoreCase(cmd)) {
			CustomWorkflowTaskUtil.assignWorkflowToUser(themeDisplay, workflowInstance, workflowTaskId);
			logger.info("work flow taskId :::::::::: " + workflowTaskId + "   has assigned to user ::: :: "
					+ themeDisplay.getUserId());
		} else {
			logger.info("transition Name " + tName);
			CustomWorkflowTaskUtil.completeWorkflowTask(themeDisplay, workflowInstance, workflowTaskId, "", tName);
		}
	}

	public OCTRegistration updateExamRegistrationById(ThemeDisplay themeDisplay, long registrationId, String payload) {
		String url = themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_REGISTRATION_URL + registrationId;
		String response = omsbHttpConnector.executePut(url, payload, omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
		if (response.contains("lrUserId")) {
			return CustomObjectMapperUtil.readValue(response, OCTRegistration.class);
		}

		return null;
	}

	public List<ObjectEntry> getAllObjectEntryByDefinitionERC(ThemeDisplay themeDisplay, String erc) {
		ObjectDefinition objectDefinition = getObjectDefinition(themeDisplay, erc);
		if (Validator.isNotNull(objectDefinition)) {
			return objectEntryLocalService.getObjectEntries(themeDisplay.getScopeGroupId(),
					objectDefinition.getObjectDefinitionId(), -1, -1);
		}
		return new ArrayList<>();
	}

	public List<OCTExamSchedule> getOCTExamScheduleDataList(String portalUrl, long groupId) {

		String examScheduleURL = portalUrl + LRObjectURL.OC_EXAM_SCHEDULE + CommonConstants.SCOPES + StringPool.SLASH
				+ groupId;
		logger.info(examScheduleURL);
		String examScheduleResponse = omsbHttpConnector.executeGet(examScheduleURL, "",
				omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
		logger.info(examScheduleResponse);
		OCTExamScheduleItems examSchedules = CustomObjectMapperUtil.readValue(examScheduleResponse,
				OCTExamScheduleItems.class);
		logger.info(examSchedules.getItems().size());
		return examSchedules.getItems();
	}

	public void updateOCTExamScheduleStatus(String portalUrl, long companyId, OCTExamSchedule oCTExamSchedule) {
		// TODO Auto-generated method stub
		ListTypeEntry listTypeEntry = omsbCommonApi
				.getListTypeEntryByListTypeItemKey(LRPicklistConstants.PL_EXAM_STATUS, "completed", companyId);
		oCTExamSchedule.setExamStatusId(listTypeEntry.getListTypeEntryId());
		String examResultResponse = CustomObjectMapperUtil.writeValueAsString(oCTExamSchedule, null);
		logger.info(examResultResponse);
		Map<String, String> headers = omsbCommonApi.getHttpHeaderInfoAndBasicAuth();
		logger.info((portalUrl + LRObjectURL.OC_EXAM_SCHEDULE + oCTExamSchedule.getId()));
		String executePut = omsbHttpConnector.executePut(
				(portalUrl + LRObjectURL.OC_EXAM_SCHEDULE + oCTExamSchedule.getId()), examResultResponse, headers);
		logger.info(executePut);

	}

	public List<OCTExamSchedule> getOCTFutureExamScheduleList(long groupId, String portalURL, long octExamDefinitionId,
			long scheduleId, Locale locale, long companyId) {
		try {

			OCTExamSchedule octExamScheduleById = getOCTExamScheduleById(scheduleId, portalURL);
			ListTypeEntry listTypeEntry = omsbCommonApi
					.getListTypeEntryByListTypeItemKey(LRPicklistConstants.PL_EXAM_STATUS, "announced", companyId);

			String examScheduleURL = portalURL + LRObjectURL.OC_EXAM_SCHEDULE + CommonConstants.SCOPES
					+ StringPool.SLASH + groupId + StringPool.QUESTION + "filter=examStatusId"
					+ URLEncoder.encode(" eq " + listTypeEntry.getListTypeEntryId() + " and oCExamDefinitionId eq "
							+ octExamDefinitionId, StandardCharsets.UTF_8);
			logger.info(examScheduleURL);
			String examScheduleResponse = omsbHttpConnector.executeGet(examScheduleURL, "",
					omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
			logger.info(examScheduleResponse);
			OCTExamScheduleItems examSchedules = CustomObjectMapperUtil.readValue(examScheduleResponse,
					OCTExamScheduleItems.class);
			logger.info(examSchedules);
			Date examDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(octExamScheduleById.getExamDate());
			List<OCTExamSchedule> schedules = new ArrayList<OCTExamSchedule>();
			for (int i = 0; i < examSchedules.getItems().size(); i++) {
				Date dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
						.parse(examSchedules.getItems().get(i).getExamDate());
				logger.info(dateFormat);
				if (examDate.before(dateFormat)) {
					logger.info("Inside the if condition");

					String userMetaDateURL = portalURL + LRObjectURL.REG_USER_METADATA_URL + CommonConstants.SCOPES
							+ StringPool.SLASH + groupId + StringPool.QUESTION + "filter=departmentId"
							+ URLEncoder.encode(
									" eq " + "'" + examSchedules.getItems().get(i).getDepartmentId()
											+ "' and sectionId eq " + "'"
											+ examSchedules.getItems().get(i).getSectionId() + "'",
									StandardCharsets.UTF_8);
					logger.info(userMetaDateURL);
					String userMetaDateResponse = omsbHttpConnector.executeGet(userMetaDateURL, "",
							omsbCommonApi.getHttpHeaderInfoAndBasicAuth());

					logger.info(userMetaDateResponse);
					if (Validator.isNotNull(userMetaDateResponse) && userMetaDateResponse.length() > 0) {

						UserMetadata userMetadata = CustomObjectMapperUtil.readValue(userMetaDateResponse,
								UserMetadata.class);
						logger.info(userMetadata);
						if (Validator.isNotNull(userMetadata)) {

							OCTExamSchedule examSchedule = new OCTExamSchedule();

							examSchedule.setId(examSchedules.getItems().get(i).getId());
							logger.info(examSchedules.getItems().get(i).getId());
							examSchedule.setRegistrationStartDate(commonApi.convertObjectDateToDDMMYYYYDate(
									examSchedules.getItems().get(i).getRegistrationStartDate()));
							logger.info(examSchedules.getItems().get(i).getId());
							examSchedule.setRegistrationEndDate(commonApi.convertObjectDateToDDMMYYYYDate(
									examSchedules.getItems().get(i).getRegistrationEndDate()));
							logger.info(examSchedules.getItems().get(i).getId());
							examSchedule.setExamDate(commonApi
									.convertObjectDateToDDMMYYYYDate(examSchedules.getItems().get(i).getExamDate()));
							logger.info(examSchedules.getItems().get(i).getId());
//							examSchedule.setRegStatus(getregistrationStatus(examSchedules.getItems().get(i).getId(),
//									portalURL, groupId, locale, companyId));
							schedules.add(examSchedule);
						}
					}
				}
			}

			logger.info(schedules.size());
			return schedules;
		} catch (Exception e) {

			logger.error(e.getMessage());
		}
		return null;
	}

//  List Of Announced Exam List For OC Exam Applicant
	public List<OCTExamSchedule> getOCTExamScheduleList(long groupId, String portalURL, Locale locale, long companyId) {

		try {
			ListTypeEntry listTypeEntry = omsbCommonApi
					.getListTypeEntryByListTypeItemKey(LRPicklistConstants.PL_EXAM_STATUS, "announced", companyId);

			String examScheduleURL = portalURL + LRObjectURL.OC_EXAM_SCHEDULE + CommonConstants.SCOPES
					+ StringPool.SLASH + groupId + StringPool.QUESTION + "filter=examStatusId"
					+ URLEncoder.encode(" eq " + listTypeEntry.getListTypeEntryId(), StandardCharsets.UTF_8);

			String examScheduleResponse = omsbHttpConnector.executeGet(examScheduleURL, "",
					omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
			OCTExamScheduleItems examSchedules = CustomObjectMapperUtil.readValue(examScheduleResponse,
					OCTExamScheduleItems.class);

			List<OCTExamSchedule> schedules = new ArrayList<OCTExamSchedule>();
			for (int i = 0; i < examSchedules.getItems().size(); i++) {

				if (Validator.isNotNull(examSchedules.getItems().get(i))) {

					String userMetaDateURL = portalURL + LRObjectURL.REG_USER_METADATA_URL + CommonConstants.SCOPES
							+ StringPool.SLASH + groupId + StringPool.QUESTION + "filter=departmentId"
							+ URLEncoder.encode(
									" eq " + "'" + examSchedules.getItems().get(i).getDepartmentId()
											+ "' and sectionId eq " + "'"
											+ examSchedules.getItems().get(i).getSectionId() + "'",
									StandardCharsets.UTF_8);

					String userMetaDateResponse = omsbHttpConnector.executeGet(userMetaDateURL, "",
							omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
					if (Validator.isNotNull(userMetaDateResponse)) {

						UserMetadata userMetadata = CustomObjectMapperUtil.readValue(userMetaDateResponse,
								UserMetadata.class);
						if (Validator.isNotNull(userMetadata)) {

							OCTExamSchedule examSchedule = new OCTExamSchedule();

							examSchedule.setId(examSchedules.getItems().get(i).getId());
							examSchedule.setRegistrationStartDate(commonApi.convertObjectDateToDDMMYYYYDate(
									examSchedules.getItems().get(i).getRegistrationStartDate()));
							examSchedule.setRegistrationEndDate(commonApi.convertObjectDateToDDMMYYYYDate(
									examSchedules.getItems().get(i).getRegistrationEndDate()));
							examSchedule.setExamDate(commonApi
									.convertObjectDateToDDMMYYYYDate(examSchedules.getItems().get(i).getExamDate()));
							examSchedule.setRegStatus(getregistrationStatus(examSchedules.getItems().get(i).getId(),
									portalURL, groupId, locale, companyId));
							schedules.add(examSchedule);
						}
					}
				}
			}
			return schedules;
		} catch (Exception e) {

			logger.error(e.getMessage());
		}
		return null;
	}

	public UserMetadataItem getUserMetaDateByDepartmentIdAndSectionId(String portalURL, long groupId, long roleId) {

		String userMetaDateURL = portalURL + LRObjectURL.REG_USER_METADATA_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + groupId + StringPool.QUESTION + "filter=roleId"
				+ URLEncoder.encode(" eq " + "'" + roleId + "'", StandardCharsets.UTF_8);
		String userMetaDateResponse = omsbHttpConnector.executeGet(userMetaDateURL, "",
				omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
		if (Validator.isNotNull(userMetaDateResponse) && userMetaDateResponse.length() > 0) {
			UserMetadataItem userMetadataItem = CustomObjectMapperUtil.readValue(userMetaDateResponse,
					UserMetadataItem.class);
			return userMetadataItem;
		}
		return null;
	}

	public UserMetadataItem getUserMetaDateByDepartmentIdSectionIdAndUserId(String portalURL, long groupId,
			long lrUserId, long companyId) {

		Role role = null;
		long roleId = 0;
		try {
			role = RoleLocalServiceUtil.getRole(companyId, RoleNameConstants.EXAM_APPLICANT);

			if (Validator.isNotNull(role)) {

				roleId = role.getRoleId();
			}
		} catch (PortalException e) {
			logger.error(e.getMessage());
		}

		String userMetaDateURL = portalURL + LRObjectURL.REG_USER_METADATA_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + groupId + StringPool.QUESTION + "filter=roleId"
				+ URLEncoder.encode(" eq " + "'" + roleId + "'", StandardCharsets.UTF_8);

		String userMetaDateResponse = omsbHttpConnector.executeGet(userMetaDateURL, "",
				omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
		// logger.info("userMetaDateResponse .... " + userMetaDateResponse);

		if (Validator.isNotNull(userMetaDateResponse) && userMetaDateResponse.length() > 0) {
			UserMetadataItem userMetadataItem = CustomObjectMapperUtil.readValue(userMetaDateResponse,
					UserMetadataItem.class);
			return userMetadataItem;
		}
		return null;
	}

//  List Of Announced Exam List For OC Exam Applicant
	public List<OCTExamSchedule> getOCTExamScheduleList(ThemeDisplay themeDisplay) {

		try {
			ListTypeEntry listTypeEntryAnnounced = omsbCommonApi.getListTypeEntryByListTypeItemKey(
					LRPicklistConstants.PL_EXAM_STATUS, "announced", themeDisplay.getCompanyId());

			ListTypeEntry listTypeEntryReschedule = omsbCommonApi.getListTypeEntryByListTypeItemKey(
					LRPicklistConstants.PL_EXAM_STATUS, "reschedule", themeDisplay.getCompanyId());

			ListTypeEntry listTypeEntryCompleted = omsbCommonApi.getListTypeEntryByListTypeItemKey(
					LRPicklistConstants.PL_EXAM_STATUS, "completed", themeDisplay.getCompanyId());

			String examScheduleURL = themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_SCHEDULE + CommonConstants.SCOPES
					+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=";

			if (Validator.isNotNull(listTypeEntryAnnounced)) {
				examScheduleURL = examScheduleURL + "examStatusId" + URLEncoder
						.encode(" eq " + listTypeEntryAnnounced.getListTypeEntryId(), StandardCharsets.UTF_8) + "+or+";
			}
			if (Validator.isNotNull(listTypeEntryReschedule)) {
				examScheduleURL = examScheduleURL + "examStatusId" + URLEncoder
						.encode(" eq " + listTypeEntryReschedule.getListTypeEntryId(), StandardCharsets.UTF_8)+ "+or+";
			}
			if (Validator.isNotNull(listTypeEntryCompleted)) {
				examScheduleURL = examScheduleURL + "examStatusId" + URLEncoder
						.encode(" eq " + listTypeEntryCompleted.getListTypeEntryId(), StandardCharsets.UTF_8) + "+or+";
			}
			if (examScheduleURL.lastIndexOf("+or+") > 0) {
				examScheduleURL = examScheduleURL.substring(0, examScheduleURL.lastIndexOf("+or+"));
			} else {
				examScheduleURL = examScheduleURL.substring(0, examScheduleURL.lastIndexOf("?filter="));

			}
			examScheduleURL = examScheduleURL  + "&sort=examDate:desc&pageSize=0";

			logger.info("examScheduleURL ..... " + examScheduleURL);
			String examScheduleResponse = omsbHttpConnector.executeGet(examScheduleURL, "",
					omsbCommonApi.getHttpHeaderInfoAndBasicAuth());

			if (Validator.isNotNull(examScheduleResponse)) {

				OCTExamScheduleItems examSchedules = CustomObjectMapperUtil.readValue(examScheduleResponse,
						OCTExamScheduleItems.class);

				// logger.info("examSchedules " + examSchedules.getItems());
				List<OCTExamSchedule> schedules = new ArrayList<OCTExamSchedule>();
				if (Validator.isNotNull(examSchedules) && Validator.isNotNull(examSchedules.getItems()) && examSchedules.getItems().size() > 0) {

					logger.info("Size .... " + examSchedules.getItems().size());

					for (OCTExamSchedule oCTExamSchedule : examSchedules.getItems()) {

						logger.info("OC Exam Schedule Id ... " + oCTExamSchedule.getId());

						/*
						 * UserMetadataItem userMetadataItem =
						 * getUserMetaDateByDepartmentIdSectionIdAndUserId( themeDisplay.getPortalURL(),
						 * themeDisplay.getScopeGroupId(), themeDisplay.getUserId(),
						 * themeDisplay.getCompanyId());
						 */

						// logger.info("userMetadataItem ." + userMetadataItem.toString());
						// if (Validator.isNotNull(userMetadataItem)) {
						//List<UserMetadata> userMetadata = userMetadataItem.getItems();
						// if (!userMetadata.isEmpty()) {

						OCTRegistrationItem oCTRegistrationItem = getRegistrationByUserIdAndScheduleIdAndStatus(
								themeDisplay, themeDisplay.getUserId(), oCTExamSchedule.getId());
						if (Validator.isNotNull(oCTRegistrationItem)) {
							if (Validator.isNotNull(oCTRegistrationItem) && oCTRegistrationItem.getItems().size() > 0) {
								OCTRegistration octRegistration = oCTRegistrationItem.getItems().get(0);
								oCTExamSchedule.setRegStatus(octRegistration.getRegStatus());
								if (octRegistration.isPaymentComplete()) {
									logger.info("Date Of Payment ... " + octRegistration.getDateOfPayment());
									oCTExamSchedule.setDateOfPayment(commonApi
											.convertObjectDateToDDMMYYYYDate(octRegistration.getDateOfPayment()));
								}
								oCTExamSchedule.setRegistrationStartDate(commonApi
										.convertObjectDateToDDMMYYYYDate(oCTExamSchedule.getRegistrationStartDate()));
								oCTExamSchedule.setRegistrationEndDate(commonApi
										.convertObjectDateToDDMMYYYYDate(oCTExamSchedule.getRegistrationEndDate()));

								logger.info("Exam Date ... " + oCTExamSchedule.getExamDate());
								oCTExamSchedule.setExamDate(
										commonApi.convertObjectDateToDDMMYYYYDate(oCTExamSchedule.getExamDate()));

								oCTExamSchedule.setRegistrationStartDate(commonApi
										.convertObjectDateToDDMMYYYYDate(oCTExamSchedule.getRegistrationStartDate()));
								oCTExamSchedule.setRegistrationEndDate(commonApi
										.convertObjectDateToDDMMYYYYDate(oCTExamSchedule.getRegistrationEndDate()));

								OCTExamDefinition octExamDefinition = getOCTExamDefinitionByDefinitionId(
										oCTExamSchedule.getOctExamDefinitionId(), themeDisplay.getPortalURL());
								if (Validator.isNotNull(octExamDefinition)) {

									ListTypeEntry examTilele = omsbCommonApi
											.getListTypeEntryBylistTypeEntryId(octExamDefinition.getoCExamTitleId());
									oCTExamSchedule.setOctExamTitleName(examTilele.getName(themeDisplay.getLocale()));
									oCTExamSchedule.setoCExamTitleKey(examTilele.getKey());
									oCTExamSchedule.setOctExamTitleId(octExamDefinition.getoCExamTitleId());
									oCTExamSchedule.setExamFees(calculateExamFee(themeDisplay, oCTExamSchedule));
									
									logger.info("Exam Fees . "+calculateExamFee(themeDisplay, oCTExamSchedule));
								}

								long paymentReceiptFileEntryId = octRegistration.getPaymentReceiptFileEntryId();
								if (paymentReceiptFileEntryId > 0) {
									String payemtReceiptUrl = getFileDownloadUrl(themeDisplay,
											paymentReceiptFileEntryId, themeDisplay.getPathContext());
									logger.info("payemtReceiptUrl" + payemtReceiptUrl);
									if (Validator.isNotNull(payemtReceiptUrl)) {
										oCTExamSchedule.setPaymentReceiptUrl(payemtReceiptUrl);
									}
								}
								logger.info(" "+octRegistration.getRegStatus().equalsIgnoreCase("registered")
										+"  "+ octRegistration.getRegStatus().equalsIgnoreCase("Pending"));

								if (octRegistration.getRegStatus().equalsIgnoreCase("registered")
										|| octRegistration.getRegStatus().equalsIgnoreCase("Pending")) {

									schedules.add(oCTExamSchedule);

								}
							}
						}
					}
					logger.info("schedules  ." + schedules.size());
					return schedules;
				}
			}
		} catch (Exception e) {

			logger.trace(e);
			logger.error(e.getMessage());
		}
		return null;
	}

	public OCTRegistrationItem getRegistrationByUserIdAndScheduleIdAndStatus(ThemeDisplay themeDisplay, long userId,
			long examScheduleId) {
		logger.info("getRegistrationByUserIdProgramAndExamType() started ");
		String registrationUrl = themeDisplay.getPortalURL()
				+ LRObjectURL.OC_EXAM_REGISTRATIONS + CommonConstants.SCOPES + StringPool.SLASH
				+ themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=lrUserId" + URLEncoder
						.encode(" eq " + userId + " and oCExamScheduleId eq " + examScheduleId + " and regStatus eq '" + "registered" + "'", StandardCharsets.UTF_8)
				+ "&sort=dateCreated:desc&pageSize=0";
		logger.info("registration url " + registrationUrl);
		String registrationResponse = omsbCommonApi.getData(registrationUrl);
		logger.info("registration registrationResponse " + registrationResponse);
		logger.info("getRegistrationByUserIdProgramAndExamType() ended ");
		OCTRegistrationItem OCTRegistrationItem = CustomObjectMapperUtil.readValue(registrationResponse,
				OCTRegistrationItem.class);
		return OCTRegistrationItem;

	}

	public OCTExamDefinition getOCtExamDefinitionById(long examDefinitionId, ThemeDisplay themeDisplay) {

		String examDefinitionURL = themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_DEFINITION_URL
				+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION
				+ "filter=id" + URLEncoder.encode(" eq " + "'" + examDefinitionId + "'", StandardCharsets.UTF_8)+ "&pageSize=0";

		String examDefinitionResponse = omsbHttpConnector.executeGet(examDefinitionURL, "",
				omsbCommonApi.getHttpHeaderInfoAndBasicAuth());

		OCTExamDefinition definition = new OCTExamDefinition();
		if (Validator.isNotNull(examDefinitionResponse)) {
			OCTExamDefinitionItems examDefinition = CustomObjectMapperUtil.readValue(examDefinitionResponse,
					OCTExamDefinitionItems.class);
			definition.setoCExamId(examDefinition.getItems().get(0).getoCExamId());
		}
		return definition;
	}

	public List<OCTTrainingSite> getOCTTrainingSite(String portalUrl, long scopeGroupId) {
		String octTrainingSiteURL = portalUrl + LRObjectURL.OC_EXAM_TRAINING_SITES_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + scopeGroupId;
		String octTrainingSiteResponse = omsbHttpConnector.executeGet(octTrainingSiteURL, StringPool.BLANK,
				omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
		OCTTrainingSiteItems octTrainingSiteItems = CustomObjectMapperUtil.readValue(octTrainingSiteResponse,
				OCTTrainingSiteItems.class);
		if (Validator.isNotNull(octTrainingSiteItems)) {
			List<OCTTrainingSite> octTrainingSiteList = octTrainingSiteItems.getItems();
			return octTrainingSiteList;
		}

		return null;
	}

	public List<OCTMapTrainingSite> getOCTMapTrainingSite(String portalUrl, long scopeGroupId, long trainingSiteId) {
		String octMAPTrainingSiteURL = portalUrl + LRObjectURL.OC_EXAM_MAP_TRAINING_SITES_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + scopeGroupId + StringPool.QUESTION + "filter=octTrainingSiteId"
				+ URLEncoder.encode(" eq " + trainingSiteId, StandardCharsets.UTF_8)+ "&pageSize=0";
		;
		String octMAPTrainingSiteResponse = omsbHttpConnector.executeGet(octMAPTrainingSiteURL, StringPool.BLANK,
				omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
		OCTMapTrainingSiteItems octMapTrainingSiteItems = CustomObjectMapperUtil.readValue(octMAPTrainingSiteResponse,
				OCTMapTrainingSiteItems.class);
		if (Validator.isNotNull(octMapTrainingSiteItems)) {
			List<OCTMapTrainingSite> octMapTrainingSiteList = octMapTrainingSiteItems.getItems();
			return octMapTrainingSiteList;
		}

		return null;
	}

	public void getBlueprintFileURL(OCTExamJsonFields examJsonFields) {
		try {
			if (Validator.isNotNull(examJsonFields.getOctExamBlueprints())) {
				List<OCTExamBlueprint> octExamBlueprint = examJsonFields.getOctExamBlueprints();
				if (Validator.isNotNull(octExamBlueprint)) {
					for (OCTExamBlueprint octblueprint : octExamBlueprint) {
						if (octblueprint.getdLFileEntry() > 0) {
							FileEntry fileEntry = DLAppServiceUtil.getFileEntry(octblueprint.getdLFileEntry());
							if (Validator.isNotNull(fileEntry)) {
								String fileUrl = DLURLHelperUtil.getPreviewURL(fileEntry,
										fileEntry.getLatestFileVersion(), null, "");
								logger.info("url:" + fileUrl);
								octblueprint.setUrl(fileUrl);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

	public SectionDepartmentItems getSectionByDepartmentKey(ThemeDisplay themeDisplay, String departmentId)
			throws UnsupportedEncodingException {
		String sectionDepartmentUrl;
		try {
			sectionDepartmentUrl = themeDisplay.getPortalURL() + LRObjectURL.REG_SECTION_DEPARTMENT_URL + "scopes/"
					+ themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=departmentId"
					+ URLEncoder.encode(" eq " + "'" + departmentId + "'", DataflowConstants.UTF_8)+ "&pageSize=0";

			String sectionDepartmentResponse = commonApi.getData(sectionDepartmentUrl);
			logger.info("getSectionByDepartmentKey::" + sectionDepartmentUrl
					+ ":::::::sectionDepartmentResponse::::::::::" + sectionDepartmentResponse);
			return CustomObjectMapperUtil.readValue(sectionDepartmentResponse, SectionDepartmentItems.class);

		} catch (java.io.UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ListTypeEntry getPickListEntriesByMappingId(String pickListName, long companyId, String key) {
		try {
			ListTypeDefinition definition = ListTypeDefinitionLocalServiceUtil
					.getListTypeDefinitionByExternalReferenceCode(pickListName, companyId);
			return ListTypeEntryLocalServiceUtil.getListTypeEntry(definition.getListTypeDefinitionId(), key);
		} catch (PortalException e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	public OCTRegularFees getRegularFeesByDefinitionId(long ocExamDefinitionId, ThemeDisplay themeDisplay,
			long noOfAttempt) {
		String regularFeesURL = themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_REGULAR_FEES + "scopes/"
				+ themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=ocExamDefinitionId"
				+ URLEncoder.encode(" eq " + ocExamDefinitionId, StandardCharsets.UTF_8)+ "&sort=noOfAttempt:desc&pageSize=0";

		String regularFeesResponse = omsbCommonApi.getData(regularFeesURL);
	/*	logger.info("personDetailResponse::::" + regularFeesResponse);*/
		OCTRegularFeesItem octRegularFeesItem = CustomObjectMapperUtil.readValue(regularFeesResponse,
				OCTRegularFeesItem.class);
		
		logger.info("Regular Fee Item .."+octRegularFeesItem.getItems().size());
		
		if (Validator.isNotNull(octRegularFeesItem) && Validator.isNotNull(octRegularFeesItem.getItems())
				&& !octRegularFeesItem.getItems().isEmpty()) {
			
			logger.info("octRegularFeesItem .. "+octRegularFeesItem.getItems().size());
			
			List<OCTRegularFees> octRegularFeesList = octRegularFeesItem.getItems();
//			OCTRegularFees octRegularFees = octRegularFeesList.stream()
//					.filter(OCTRegularFee -> OCTRegularFee.getNoOfAttempt() <= noOfAttempt).findFirst().get();


			for(OCTRegularFees regularFees : octRegularFeesList){
                if(regularFees.getNoOfAttempt() <= noOfAttempt){
                    return regularFees;
                }
            }
			
//			logger.info("Regular Fee . "+octRegularFees);
//			
//			return octRegularFees;
		}
		return null;
	}

	public String getExamTitle(ThemeDisplay themeDisplay, long examDefinitionId, String portalURL) {
		try {
			OCTExamDefinition octExamDefinition = getOCTExamDefinitionByDefinitionId(examDefinitionId, portalURL);
			return omsbCommonApi.getListTypeEntryNameBylistTypeEntryId(octExamDefinition.getoCExamTitleId(),
					themeDisplay.getLocale());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return "";
	}

//  send notification to the registered applicants	
	public void sendNotificationToRegisteredApplicants(ThemeDisplay themeDisplay, long ocExamScheduleId) {

		String examRegistrationURL = themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_REGISTRATION_URL + "scopes/"
				+ themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=regStatus"
				+ URLEncoder.encode(" eq " + "'" + "registered" + "'", StandardCharsets.UTF_8)+ "&pageSize=0";

		String examRegistrationResponse = omsbCommonApi.getData(examRegistrationURL);

		if (Validator.isNotNull(examRegistrationResponse)) {

			OCTRegistrationItem registrationItem = CustomObjectMapperUtil.readValue(examRegistrationResponse,
					OCTRegistrationItem.class);

			logger.info("REGISTRATION ITEM ..... " + registrationItem.getItems().size());
			if (registrationItem.getItems().size() > 0) {

				for (int i = 0; i < registrationItem.getItems().size(); i++) {

					if (registrationItem.getItems().get(i).getoCExamScheduleId() == ocExamScheduleId) {

						JSONObject object = JSONFactoryUtil.createJSONObject();

						String payload = OCTRegistrationNotificationConfigurationAction
								.getExamRescheduleNotificationTemplate();
						String subjectPayload = OCTRegistrationNotificationConfigurationAction
								.getExamRescheduleNotificationSubject();

						object.put(OmsbTmsCommonConstants.NOTIFICATION_TEXT, payload);
						logger.info("ExamNotificationTemplate payload" + payload);

						try {
							userNotificationEventLocalService.sendUserNotificationEvents(
									registrationItem.getItems().get(i).getLrUserId(),
									OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
									UserNotificationDeliveryConstants.TYPE_WEBSITE, object);

							User user = UserLocalServiceUtil.getUser(registrationItem.getItems().get(i).getLrUserId());

							omsbCommonApi.sendEmailNotification(MVCCommandNames.SENDER_EMAIL, user.getEmailAddress(),
									subjectPayload, payload);

						} catch (PortalException e) {
							logger.error(e.getMessage());
						}
					}
				}
			}
		}

	}

//  exam schedular code 
	public void examScheduleSchedular(String portalURL, long groupId, long comaplyId, Locale locale) {

		String examDate = getTommorowsdate();

		String date = getYesterdaysdate();

		OCTExamScheduleItems scheduleItems = getOCTExamScheduleByYesterdaysDate(portalURL, groupId, date);

		logger.info("OCTExamScheduleItems ..... " + scheduleItems.getItems().size());

		if (scheduleItems.getItems().size() > 0) {

			examAndRegistrationIsCompleted(scheduleItems, portalURL, groupId, comaplyId);
		}

		logger.info("AFTER AFTER AFTER ....");

		OCTExamScheduleItems examScheduleItems = getOCTExamScheduleByExamDate(portalURL, groupId, examDate);

		if (examScheduleItems.getItems().size() > 0) {

			OCTRegistrationItem examRegistrationItems = getOCTExamRegistrationByScheduleId(portalURL, groupId,
					examScheduleItems.getItems().get(0).getId());

			for (int i = 0; i < examRegistrationItems.getItems().size(); i++) {

				logger.info("STATUS ... " + examRegistrationItems.getItems().get(i).getRegStatus());

				if (examRegistrationItems.getItems().get(i).getRegStatus().equalsIgnoreCase("registered")) {

//					JSONObject object = JSONFactoryUtil.createJSONObject();
//
//					String payload = OCTRegistrationNotificationConfigurationAction
//							.getScheduleExamNotificationTemplate();
//					String subjectPayload = OCTRegistrationNotificationConfigurationAction
//							.getScheduleExamNotificationSubject();

					User user;
					try {
						user = UserLocalServiceUtil.getUser(examRegistrationItems.getItems().get(i).getLrUserId());

//						logger.info("ExamNotificationTemplate payload" + payload);

//						if (Validator.isNotNull(subjectPayload) && Validator.isNotNull(payload)) {
//
//							payload = payload.replace("[Exam Title]",
//									omsbCommonApi.getListTypeEntryNameBylistTypeEntryId(
//											getOCtExamDefinitionbyDefinitionId(portalURL, groupId,
//													examScheduleItems.getItems().get(0).getOctExamDefinitionId()),
//											locale));
//							payload = payload.replace("[Exam Date]", examDate);
//							payload = payload.replace("[Full Name]", user.getFullName());
//							payload = payload.replace("[Exam Time]", examScheduleItems.getItems().get(0).getExamTime());
//							String time = examScheduleItems.getItems().get(0).getExamTime();
//
//							LocalTime originalTime = LocalTime.parse(time);
//							LocalTime modifiedTime = originalTime.minusHours(1);
//
//							payload = payload.replace("[Entry Time]", modifiedTime.toString());
//						}
//						object.put(OmsbTmsCommonConstants.NOTIFICATION_TEXT, payload);
//
//						userNotificationEventLocalService.sendUserNotificationEvents(
//								examRegistrationItems.getItems().get(i).getLrUserId(),
//								OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
//								UserNotificationDeliveryConstants.TYPE_WEBSITE, object);
//
//						omsbCommonApi.sendNotification(MVCCommandNames.SENDER_EMAIL, user.getEmailAddress(),
//								subjectPayload, payload);

						sendExamNotification(groupId, user.getUserId(), OCTExamConstants.EXAM_SCHEDULAR);

					} catch (Exception e) {
						logger.error(e.getMessage());
					}
				}
			}
		}
	}

	public void sendExamNotification(long groupID, long userId, String templateName) {
		logger.info("inside send email notification");
		JournalArticle article = null;
		try {
			article = JournalArticleLocalServiceUtil.getArticleByUrlTitle(groupID, templateName);
			String emailTitle = StringPool.BLANK;
			String emailContent = StringPool.BLANK;
			if (Validator.isNotNull(article)) {
				String content = article.getContentByLocale("en_US");
				emailTitle = readXMLData(content, "emailTitle");
				emailContent = readXMLData(content, "emailContent");
			}
			logger.info("emailTitle ?? " + emailTitle);
			logger.info("emailContent  ?? " + emailContent);
			JSONObject notificationJSON = JSONFactoryUtil.createJSONObject();

			notificationJSON.put("emailTitle", emailTitle);
			notificationJSON.put("emailContent", emailContent);

			UserNotificationEvent u = UserNotificationEventLocalServiceUtil.sendUserNotificationEvents(userId,
					OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB, UserNotificationDeliveryConstants.TYPE_WEBSITE,
					notificationJSON);
			logger.info("SENDING NOTIFICATION ...." + u.getPayload());

			String email = Validator.isNotNull(userLocalService.fetchUser(userId))
					? userLocalService.fetchUser(userId).getEmailAddress()
					: "";

			omsbCommonApi.sendEmailNotification(MVCCommandNames.SENDER_EMAIL, email, "Exam Notification", emailContent);

		} catch (PortalException e) {
			logger.error(e.getMessage(), e);
		}
	}

	public String readXMLData(String content, String Key) {
		String fieldValue = StringPool.BLANK;
		try {

			Document document = SAXReaderUtil.read(content);

			Node node = document
					.selectSingleNode("/root/dynamic-element[@field-reference='" + Key + "']/dynamic-content");

			if (Validator.isNotNull(node)) {
				return fieldValue = node.getText();
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return fieldValue;

	}

	public void examAndRegistrationIsCompleted(OCTExamScheduleItems examScheduleItems, String portalURL, long groupId,
			long comapnyId) {

		for (int i = 0; i < examScheduleItems.getItems().size(); i++) {

			OCTExamSchedule octExamSchedule = new OCTExamSchedule();

			octExamSchedule.setId(examScheduleItems.getItems().get(i).getId());
			octExamSchedule.setDepartmentId(examScheduleItems.getItems().get(i).getDepartmentId());
			octExamSchedule.setExamDate(examScheduleItems.getItems().get(i).getExamDate());

			ListTypeEntry listTypeEntry = omsbCommonApi
					.getListTypeEntryByListTypeItemKey(LRPicklistConstants.PL_EXAM_STATUS, "completed", comapnyId);
			octExamSchedule.setExamStatusId(listTypeEntry.getListTypeEntryId());

//			octExamSchedule.setExamTime(examScheduleItems.getItems().get(i).getExamTime());
			octExamSchedule.setLocationOnGoogleMap(examScheduleItems.getItems().get(i).getLocationOnGoogleMap());
			octExamSchedule.setNoOfSeats(examScheduleItems.getItems().get(i).getNoOfSeats());
			octExamSchedule.setOctExamDefinitionId(examScheduleItems.getItems().get(i).getOctExamDefinitionId());
			octExamSchedule.setOctExamTitleId(examScheduleItems.getItems().get(i).getOctExamTitleId());
			octExamSchedule.setRegistrationEndDate(examScheduleItems.getItems().get(i).getRegistrationEndDate());
			octExamSchedule.setRegistrationStartDate(examScheduleItems.getItems().get(i).getRegistrationStartDate());
			octExamSchedule.setSectionId(examScheduleItems.getItems().get(i).getSectionId());
			octExamSchedule.setVenue(examScheduleItems.getItems().get(i).getVenue());

			String examScheduleUrl = portalURL + LRObjectURL.OC_EXAM_SCHEDULE + octExamSchedule.getId();
			String scheduleMapper = CustomObjectMapperUtil.writeValueAsString(octExamSchedule, null);
			omsbHttpConnector.executePut(examScheduleUrl, scheduleMapper,
					omsbCommonApi.getHttpHeaderInfoAndBasicAuth());

			logger.info("EXAM SCHEDULE ID EXAM SCHEDULE ID ...." + examScheduleItems.getItems().get(i).getId());

			OCTRegistrationItem octRegistrationItem = getOCTExamRegistrationByScheduleId(portalURL, groupId,
					examScheduleItems.getItems().get(i).getId());
			registrationStatusCompleted(octRegistrationItem, portalURL);
		}

	}

	public void registrationStatusCompleted(OCTRegistrationItem octRegistrationItem, String portalURL) {

		for (int i = 0; i < octRegistrationItem.getItems().size(); i++) {

			OCTRegistration octRegistration = new OCTRegistration();

			octRegistration.setId(octRegistrationItem.getItems().get(i).getId());
			octRegistration.setDateOfPayment(octRegistrationItem.getItems().get(i).getDateOfPayment());
			octRegistration.setFeesPaid(octRegistrationItem.getItems().get(i).getFeesPaid());
			octRegistration.setLrUserId(octRegistrationItem.getItems().get(i).getLrUserId());
			octRegistration.setNoOfAttempt(octRegistrationItem.getItems().get(i).getNoOfAttempt());
			octRegistration.setoCExamDefinitionId(octRegistrationItem.getItems().get(i).getoCExamDefinitionId());
			octRegistration.setoCExamFormNumberId(octRegistrationItem.getItems().get(i).getoCExamFormNumberId());
			octRegistration.setoCExamScheduleId(octRegistrationItem.getItems().get(i).getoCExamScheduleId());
			octRegistration.setoCExamTitleId(octRegistrationItem.getItems().get(i).getoCExamTitleId());
			octRegistration.setUserEligibility(octRegistrationItem.getItems().get(i).getUserEligibility());
			octRegistration.setUserRegNumber(octRegistrationItem.getItems().get(i).getUserRegNumber());
			octRegistration.setRegStatus("completed");

			String examRegistrationUrl = portalURL + LRObjectURL.OC_EXAM_REGISTRATION_URL + octRegistration.getId();
			String scheduleMapper = CustomObjectMapperUtil.writeValueAsString(octRegistration, null);
			omsbHttpConnector.executePut(examRegistrationUrl, scheduleMapper,
					omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
		}
	}

	public String getTommorowsdate() {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy ");
		Date date = new Date();

		String examDate = formatter.format(date);
		String scheduleExamDate = omsbCommonApi.convertDDMMYYYYDateToObjectDate(examDate);
		Instant instant = Instant.parse(scheduleExamDate);
		LocalDate examLocalDate = instant.atZone(ZoneId.of("UTC")).toLocalDate();
		LocalDate tommorowsDate = examLocalDate.plusDays(1);
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return tommorowsDate.format(outputFormatter);
	}

	public String getYesterdaysdate() {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy ");
		Date date = new Date();

		String examDate = formatter.format(date);
		String scheduleExamDate = omsbCommonApi.convertDDMMYYYYDateToObjectDate(examDate);
		Instant instant = Instant.parse(scheduleExamDate);
		LocalDate examLocalDate = instant.atZone(ZoneId.of("UTC")).toLocalDate();
		LocalDate yesterdaysDate = examLocalDate.minusDays(1);
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return yesterdaysDate.format(outputFormatter);
	}

	public OCTExamScheduleItems getOCTExamScheduleByExamDate(String portalURL, Long groupId, String examDate) {

		String examScheduleURL = portalURL + LRObjectURL.OC_EXAM_SCHEDULE + CommonConstants.SCOPES + StringPool.SLASH
				+ groupId + StringPool.QUESTION + "filter=examDate"
				+ URLEncoder.encode(" eq " + examDate, StandardCharsets.UTF_8)+ "&pageSize=0";
		String examScheduleResponse = commonApi.getData(examScheduleURL);

		if (Validator.isNotNull(examScheduleResponse)) {
			return CustomObjectMapperUtil.readValue(examScheduleResponse, OCTExamScheduleItems.class);
		}
		return null;
	}

	public OCTExamScheduleItems getOCTExamScheduleByYesterdaysDate(String portalURL, Long groupId, String examDate) {

		String examScheduleURL = portalURL + LRObjectURL.OC_EXAM_SCHEDULE + CommonConstants.SCOPES + StringPool.SLASH
				+ groupId + StringPool.QUESTION + "filter=examDate"
				+ URLEncoder.encode(" eq " + examDate, StandardCharsets.UTF_8)+ "&pageSize=0";
		String examScheduleResponse = commonApi.getData(examScheduleURL);

		if (Validator.isNotNull(examScheduleResponse)) {
			return CustomObjectMapperUtil.readValue(examScheduleResponse, OCTExamScheduleItems.class);
		}
		return null;
	}

	public OCTRegistrationItem getOCTExamRegistrationByScheduleId(String portalURL, long groupId,
			long ocExamScheduleId) {

		String examRegistrationURL = portalURL + LRObjectURL.OC_EXAM_REGISTRATION_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + groupId + StringPool.QUESTION + "filter=oCExamScheduleId"
				+ URLEncoder.encode(" eq " + ocExamScheduleId, StandardCharsets.UTF_8)+ "&pageSize=0";
		String examRegistrationResponse = commonApi.getData(examRegistrationURL);

		if (Validator.isNotNull(examRegistrationResponse)) {
			return CustomObjectMapperUtil.readValue(examRegistrationResponse, OCTRegistrationItem.class);
		}
		return null;
	}

	public long getOCtExamDefinitionbyDefinitionId(String portalURL, long groupId, long examDefinitionId) {

		String examDefinitionURL = portalURL + LRObjectURL.OC_EXAM_DEFINITION_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + groupId + StringPool.QUESTION + "filter=id"
				+ URLEncoder.encode(" eq " + "'" + examDefinitionId + "'", StandardCharsets.UTF_8)+ "&pageSize=0";
		String examDefinitionResponse = commonApi.getData(examDefinitionURL);

		if (Validator.isNotNull(examDefinitionResponse)) {
			OCTExamDefinitionItems definitionItems = CustomObjectMapperUtil.readValue(examDefinitionResponse,
					OCTExamDefinitionItems.class);
			return definitionItems.getItems().get(0).getoCExamTitleId();
		}
		return 0;
	}

	public List<OCTExamCancellationFees> getOCTExamCancellationFeesByDefinationId(long examDefinitionId,
			String portalURL, long scopeGroupId) {

		String octExamCancellationFeesUrl = portalURL + LRObjectURL.OC_EXAM_CANCELLATION_FEES + "scopes/" + scopeGroupId
				+ StringPool.QUESTION + "filter=ocExamDefinitionId"
				+ URLEncoder.encode(" eq " + examDefinitionId, StandardCharsets.UTF_8)+ "&pageSize=0";
		String octExamCancellationFeesResponse = omsbCommonApi.getData(octExamCancellationFeesUrl);

		logger.info("octExamCancellationFeesResponse::::" + octExamCancellationFeesResponse);
		logger.info("octExamCancellationFeesUrl::::" + octExamCancellationFeesUrl);
		OCTExamCancellationFeesItem octExamCancellationFeesItem = CustomObjectMapperUtil
				.readValue(octExamCancellationFeesResponse, OCTExamCancellationFeesItem.class);
		if (Validator.isNotNull(octExamCancellationFeesItem)
				&& Validator.isNotNull(octExamCancellationFeesItem.getItems())
				&& !octExamCancellationFeesItem.getItems().isEmpty()) {
			return octExamCancellationFeesItem.getItems();
		}

		return new ArrayList<>();

	}

	public List<OCTExamReschedulingFees> getOCTExamRescheduleFessByDefinationId(long examDefinitionId, String portalURL,
			long scopeGroupId) {

		String octExamReschedulingFeessUrl = portalURL + LRObjectURL.OC_EXAM_RESCHEDULING_FEES + "scopes/"
				+ scopeGroupId + StringPool.QUESTION + "filter=ocExamDefinitionId"
				+ URLEncoder.encode(" eq " + examDefinitionId, StandardCharsets.UTF_8)+ "&pageSize=0";
		String octExamReschedulingFeesResponse = omsbCommonApi.getData(octExamReschedulingFeessUrl);

		logger.info("octExamReschedulingFeesResponse::::" + octExamReschedulingFeesResponse);
		logger.info("octExamReschedulingFeessUrl::::" + octExamReschedulingFeessUrl);
		OCTExamReschedulingFeesItem octExamReschedulingFeesItem = CustomObjectMapperUtil
				.readValue(octExamReschedulingFeesResponse, OCTExamReschedulingFeesItem.class);
		if (Validator.isNotNull(octExamReschedulingFeesItem)
				&& Validator.isNotNull(octExamReschedulingFeesItem.getItems())
				&& !octExamReschedulingFeesItem.getItems().isEmpty()) {
			return octExamReschedulingFeesItem.getItems();
		}

		return new ArrayList<>();

	}

	public EmergencyContactItem getEmergancyContactByRegistrationId(long ocExamRegistrationId, String portalURL,
			long scopeGroupId) {

		String emergencyContactUrl = portalURL + LRObjectURL.EMERGENCY_CONTACT_URL + "scopes/" + scopeGroupId
				+ StringPool.QUESTION + "filter=oCExamRegistrationId"
				+ URLEncoder.encode(" eq " + ocExamRegistrationId, StandardCharsets.UTF_8)+ "&pageSize=0";
		String emergencyContactResponse = omsbCommonApi.getData(emergencyContactUrl);

		logger.info("emergencyContactURL::::" + emergencyContactUrl);
		logger.info("emergencyContactResponse::::" + emergencyContactResponse);
		if (Validator.isNotNull(emergencyContactResponse)) {

			logger.info("new EmergencyContact();" + new EmergencyContact().toString());
			EmergencyContactItem emergencyContactItem = CustomObjectMapperUtil.readValue(emergencyContactResponse,
					EmergencyContactItem.class);
			return emergencyContactItem;
		}
		return null;
	}

	public boolean isRegistrationAllowed(int cutOff, String examDate, String examTime) {
		String examDateAndTime = examDate + StringPool.SPACE + examTime;
		String formatPattern = "dd/MM/yyyy HH:mm";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatPattern);
		try {
			LocalDateTime localDateTime = LocalDateTime.parse(examDateAndTime, formatter);
			LocalDateTime cutOffDateTime = localDateTime.minus(cutOff, ChronoUnit.HOURS);
			LocalDateTime currentDateTime = LocalDateTime.now();
			if (currentDateTime.isAfter(cutOffDateTime)) {
				return false;
			}
		} catch (DateTimeParseException e) {
			System.out.println("Error parsing date: " + e.getMessage());
			return false;
		}

		return true;
	}

	public String saveOCTExamPayment(OCTExamPayment octExamPayment, String portalURL, long scopeGroupId) {
		String examPaymentUrl = portalURL + LRObjectURL.OC_EXAM_PAYMENTS_URL + CommonConstants.SCOPES + StringPool.SLASH
				+ scopeGroupId;
		String scheduleMapper = CustomObjectMapperUtil.writeValueAsString(octExamPayment, null);
		String examPaymentResponse = omsbHttpConnector.executePost(examPaymentUrl, scheduleMapper,
				omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
		return examPaymentResponse;
	}

	public String updateOCTExamPayment(OCTExamPayment octExamPayment, String portalURL, long scopeGroupId) {
		String examPaymentUrl = portalURL + LRObjectURL.OC_EXAM_PAYMENTS_URL + octExamPayment.getId();
		String scheduleMapper = CustomObjectMapperUtil.writeValueAsString(octExamPayment, null);
		String examPaymentResponse = omsbHttpConnector.executePut(examPaymentUrl, scheduleMapper,
				omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
		return examPaymentResponse;
	}

	public OCTExamPayment getPaymentByUserIdAndScheduleId(ThemeDisplay themeDisplay, long lrUserId,
			long oCExamScheduleId) {

		String paymentUrl = themeDisplay.getPortalURL()
				+ LRObjectURL.OC_EXAM_PAYMENTS_URL + CommonConstants.SCOPES + StringPool.SLASH
				+ themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=applicantId" + URLEncoder
						.encode(" eq " + lrUserId + " and scheduleId eq " + oCExamScheduleId, StandardCharsets.UTF_8)
				+ "&sort=dateCreated:desc&pageSize=0";
		String paymentResponse = commonApi.getData(paymentUrl);
		OCTExamPaymentItems examPaymentItems = CustomObjectMapperUtil.readValue(paymentResponse,
				OCTExamPaymentItems.class);

		if (Validator.isNotNull(examPaymentItems) && examPaymentItems.getItems().size() > 0) {
			return examPaymentItems.getItems().get(0);
		} else {
			return null;
		}

	}

	public float calculateExamFee(ThemeDisplay themeDisplay, OCTExamSchedule octExamSchedule) {
		float examFee = 0;
		if (Validator.isNotNull(octExamSchedule)) {
			OCTExamDefinition examDefinition = getOCTExamDefinitionByDefinitionId(
					octExamSchedule.getOctExamDefinitionId(), themeDisplay.getPortalURL());

			if (Validator.isNotNull(examDefinition)) {
				float regFee = 0;
				int noOfAttemp = getNoOfAttempts(themeDisplay, themeDisplay.getUserId(), octExamSchedule.getId());
				OCTRegularFees regularFees = getRegularFeesByDefinitionId(examDefinition.getId(), themeDisplay,
						++noOfAttemp);

				if (Validator.isNotNull(regularFees)) {
					regFee = regularFees.getRegularFees();
				}
				logger.info("regFee fee::" + regFee);
				if (Validator.isNotNull(octExamSchedule.getRegistrationStartDate())) {
					
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DataflowConstants.OBJECT_DATE_FORMAT,
							themeDisplay.getLocale());
					String registrationStartDate = octExamSchedule.getRegistrationStartDate();
					LocalDateTime date = LocalDateTime.parse(registrationStartDate, formatter);
					LocalDate todayDate = LocalDate.now();
					long noOfDays = ChronoUnit.DAYS.between(todayDate, date);
					
					int earlyBirdFeesDays=examDefinition.getEarlyBirdFeesDate();
					if (noOfDays <= earlyBirdFeesDays) {
						if (logger.isDebugEnabled()) {
							logger.debug("octExamDefinition.getEarlyBirdFees()" + examDefinition.getEarlyBirdFees());
						}
						examFee = (float) examDefinition.getEarlyBirdFees();
					} else {
						examFee = regFee;
					}

				} else {
					examFee = regFee;
				}

			}

		}

		return examFee;
	}

	public OCTExamPayment getRegistrationPaymentByScheduleIdAndUserId(long scheduleId, long userId, String portalURL,

			long scopeGroupId) {

		String examPaymentURL = portalURL + LRObjectURL.OC_EXAM_PAYMENTS_URL + CommonConstants.SCOPES + StringPool.SLASH

				+ scopeGroupId + StringPool.QUESTION + "filter=applicantId"

				+ URLEncoder.encode(" eq " + userId + " and scheduleId eq " + scheduleId

						+ " and paymentStatus eq 'paid' and feesType eq 'registration'", StandardCharsets.UTF_8);

		String examPaymentResponse = omsbCommonApi.getData(examPaymentURL);

		if (Validator.isNotNull(examPaymentResponse)) {

			OCTExamPaymentItems octExamPaymentItems = CustomObjectMapperUtil.readValue(examPaymentResponse,

					OCTExamPaymentItems.class);

			if (Validator.isNotNull(octExamPaymentItems) && octExamPaymentItems.getItems().size() > 0) {

				return octExamPaymentItems.getItems().get(0);

			}

		}

		return null;

	}

	public EmergencyContact getEmergancyContactDetailByLrUserId(ThemeDisplay themeDisplay, long lrUserId) {
		String emergencyContactUrl = themeDisplay.getPortalURL() + LRObjectURL.EMERGENCY_CONTACT_URL + "scopes/"
				+ themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=lrUserID"
				+ URLEncoder.encode(" eq " + lrUserId, StandardCharsets.UTF_8)+ "&pageSize=0";
		String emergencyContactResponse = omsbCommonApi.getData(emergencyContactUrl);

		logger.info("emergencyContactURL::::" + emergencyContactUrl);
		logger.info("emergencyContactResponse::::" + emergencyContactResponse);
		if (Validator.isNotNull(emergencyContactResponse)) {

			logger.info("new EmergencyContact();" + new EmergencyContact().toString());
			EmergencyContactItem emergancyContactItem = CustomObjectMapperUtil.readValue(emergencyContactResponse,
					EmergencyContactItem.class);
			if (Validator.isNotNull(emergancyContactItem) && Validator.isNotNull(emergancyContactItem.getItems())
					&& !emergancyContactItem.getItems().isEmpty()) {
				logger.info("emengancy" + emergancyContactItem.getItems().get(0));
				return emergancyContactItem.getItems().get(0);
			}

		}
		return null;
	}

	public int getNoOfAttempts(ThemeDisplay themeDisplay, long lrUserId, long ocExamScheduleId) {
		try {

			OCTRegistrationItem reg = getRegistrationByUserIdAndScheduleId(themeDisplay, lrUserId, ocExamScheduleId);
			if (Validator.isNotNull(reg) && Validator.isNotNull(reg.getItems()) && !(reg.getItems()).isEmpty()) {
				int noOfAttempt = reg.getItems().get(0).getNoOfAttempt();
				logger.info("no of attempt :::" + noOfAttempt);
				return noOfAttempt;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return 0;
	}

	public OCTRegistrationItem getRegistrationByScheduleId(String portalURL, long scopeGroupId, long examScheduleId) {
		logger.info("getRegistrationByUserIdProgramAndExamType() started ");
		String registrationUrl = portalURL + LRObjectURL.OC_EXAM_REGISTRATIONS + CommonConstants.SCOPES
				+ StringPool.SLASH + scopeGroupId + StringPool.QUESTION + "filter=oCExamScheduleId"
				+ URLEncoder.encode(" eq " + examScheduleId, StandardCharsets.UTF_8)+ "&pageSize=0";

		logger.info("registration url " + registrationUrl);
		String registrationResponse = omsbCommonApi.getData(registrationUrl);
		logger.info("registration registrationResponse " + registrationResponse);
		logger.info("getRegistrationByUserIdProgramAndExamType() ended ");
		OCTRegistrationItem OCTRegistrationItem = CustomObjectMapperUtil.readValue(registrationResponse,
				OCTRegistrationItem.class);
		return OCTRegistrationItem;

	}


	public OCTRegistrationItem getExamRegistrationByUserId(ThemeDisplay themeDisplay, long userId) {

		try {
			String examRegistrationUrl = themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_REGISTRATION_URL
					+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION
					+ "filter=lrUserId" + URLEncoder.encode(" eq " + userId, DataflowConstants.UTF_8)+ "&pageSize=0";

			String examRegistrationResponse = commonApi.getData(examRegistrationUrl);

			if (Validator.isNotNull(examRegistrationResponse)) {

				OCTRegistrationItem registrationItem = CustomObjectMapperUtil.readValue(examRegistrationResponse,
						OCTRegistrationItem.class);

				if (Validator.isNotNull(registrationItem) && Validator.isNotNull(registrationItem.getItems())
						&& !registrationItem.getItems().isEmpty()) {

					return registrationItem;
				}
			}

		} catch (Exception e) {
			logger.error(e);
		}

		return null;
	}

	public PersonalDetailItem getPersonalDetailsByUserId(ThemeDisplay themeDisplay, long userId) {

		try {
			String personalDetailsUrl = themeDisplay.getPortalURL() + LRObjectURL.PERSONAL_DETAILS
					+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION
					+ "filter=lrUserId" + URLEncoder.encode(" eq " + userId, DataflowConstants.UTF_8)+ "&pageSize=0";

			String personalDetailsResponse = commonApi.getData(personalDetailsUrl);

			if (Validator.isNotNull(personalDetailsResponse)) {

				PersonalDetailItem personalDetailItem = CustomObjectMapperUtil.readValue(personalDetailsResponse,
						PersonalDetailItem.class);

				if (Validator.isNotNull(personalDetailItem) && Validator.isNotNull(personalDetailItem.getItems())
						&& !personalDetailItem.getItems().isEmpty()) {

					return personalDetailItem;
				}
			}

		} catch (Exception e) {
			logger.error(e);
		}

		return null;
	}

	public String getGenderByGenderId(long genderId) {
		try {
			if (genderId > 0) {
				GenderMaster gender = GenderMasterLocalServiceUtil.getGenderMaster(genderId);
				if (Validator.isNotNull(gender)) {
					return gender.getGenderName();
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return "";
	}
	
	public  OCTExamReschedulingFees getOCTExamRescheduleFee(OCTExamSchedule octExamSchedule,ThemeDisplay themeDisplay) {
		List<OCTExamReschedulingFees> octExamRescheduleFees = getOCTExamRescheduleFessByDefinationId(
				octExamSchedule.getOctExamDefinitionId(), themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId());
		
		String examDateStr = octExamSchedule.getExamDate();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DataflowConstants.OBJECT_DATE_FORMAT,
				Locale.ENGLISH);
		LocalDate examDate = LocalDate.parse(examDateStr, formatter);

		LocalDate todatDate = LocalDate.now();
		long noOfDays = ChronoUnit.DAYS.between(todatDate, examDate);
		logger.info("noOfDays"+ noOfDays);
		for (OCTExamReschedulingFees octExamRescheduleFee : octExamRescheduleFees) {

			
			String noOfDaystr=octExamRescheduleFee.getNoOfDays();
			int first=0;
			int second=0;
			noOfDaystr=noOfDaystr.trim();
			logger.info("noOfDaystr "+noOfDaystr);
			if(noOfDaystr.contains("-")) {
				String noOfDayArr[]=noOfDaystr.split("-");
				 first=Integer.parseInt(noOfDayArr[0].trim());
				 second=Integer.parseInt(noOfDayArr[1].trim());
				
				if(second >= noOfDays && first <= noOfDays ) {
					return octExamRescheduleFee;
				}
			}else if(noOfDaystr.contains(">=")) {
				String noOfDayArr[]=noOfDaystr.split(">=");
				 first=Integer.parseInt(noOfDayArr[0].trim());
				 second=Integer.parseInt(noOfDayArr[1].trim());
				
				if(second >= noOfDays && first < noOfDays ) {
					return octExamRescheduleFee;
				}
			}else if(noOfDaystr.contains("<=")) {
				String noOfDayArr[]=noOfDaystr.split("<=");
				 first=Integer.parseInt(noOfDayArr[0].trim());
				 second=Integer.parseInt(noOfDayArr[1].trim());
				
				if(second <= noOfDays && first > noOfDays ) {
					return octExamRescheduleFee;
				}
				
			}else if(noOfDaystr.contains("<")) {
				String noOfDayArr[]=noOfDaystr.split("<");
				// first=Integer.parseInt(noOfDayArr[0]);
				 second=Integer.parseInt(noOfDayArr[1].trim());
				
				if(second > noOfDays ) {
					return octExamRescheduleFee;
				}
				
			}else if(noOfDaystr.contains(">")) {
				String noOfDayArr[]=noOfDaystr.split(">");
				 //first=Integer.parseInt(noOfDayArr[0]);
				 second=Integer.parseInt(noOfDayArr[1].trim());
				
				if(second < noOfDays ) {
					return octExamRescheduleFee;
				}
			}
			
			
		}
		return null;
	}
	
	public OCTExamResultItem getOCTExamResultById(ThemeDisplay themeDisplay, long octExamResultId) {
		String octExamResultUrl = themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_RESULT_URL + octExamResultId;
		String octExamResultresponse = commonApi.getData(octExamResultUrl);
		OCTExamResultItem examResult = CustomObjectMapperUtil.readValue(octExamResultresponse, OCTExamResultItem.class);
		if (Validator.isNotNull(examResult)) {
			return examResult;
		}
		return examResult;
	}
	public File generatePdfDocument(String certHTML, ThemeDisplay themeDisplay,String path,String fileName) {
		try {
			Path dirPath = Paths.get(path);
			if (!Files.exists(dirPath)) {

				Files.createDirectory(dirPath);

				Path filePath = dirPath.resolve(fileName);
				if (!Files.exists(filePath)) {
					Files.createFile(filePath);
				}
			}
			File file = new File(path + fileName);
			PdfDocument pdfDocument = new PdfDocument(new PdfWriter(file));
			ConverterProperties properties = new ConverterProperties();
			Rectangle rect = new Rectangle(1200, 1600);
			pdfDocument.setDefaultPageSize(new PageSize(rect));
			properties.setBaseUri(path);
			FontProvider fontProvider = new DefaultFontProvider(false, false, false);
			FontProgram fontProgram = FontProgramFactory
					.createFont(themeDisplay.getPathThemeCss() + "/fonts/Lateef/Lateef-Regular.ttf");
			fontProvider.addFont(fontProgram);
			FontProgram fontProgram2 = FontProgramFactory
					.createFont(themeDisplay.getPathThemeCss() + "/certificate-fonts/FontEnglish.ttf");
			fontProvider.addFont(fontProgram2);

			properties.setFontProvider(fontProvider);

			com.itextpdf.layout.Document document = HtmlConverter.convertToDocument(certHTML, pdfDocument, properties);
			document.setMargins(0, 0, 0, 0);
			document.close();
			pdfDocument.close();

			return file;
		} catch (IOException e) {
			logger.error(e);
		}
		return null;
	}
	
	public DLFileEntry generatePaymentReceipt(PortletRequest actionRequest, String htmlReciept, long userId) {
		DLFileEntry fileEntry = null;
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), actionRequest);
			serviceContext.setAddGroupPermissions(true);
			DLFolder examFolder = null, userFolder = null;
			DynamicQuery folderQuery;

			folderQuery = DynamicQueryFactoryUtil.forClass(DLFolder.class, PortalClassLoaderUtil.getClassLoader());
			folderQuery.add(PropertyFactoryUtil.forName("name").eq("oct"));
			folderQuery.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()));
			folderQuery
					.add(PropertyFactoryUtil.forName("parentFolderId").eq(DLFolderConstants.DEFAULT_PARENT_FOLDER_ID));
			List<DLFolder> folderList = DLFolderLocalServiceUtil.dynamicQuery(folderQuery);
			List<String> folderNameList = folderList.parallelStream().map(DLFolder::getName)
					.collect(Collectors.toList());
			if (!folderNameList.contains("oct")) {
				examFolder = DLFolderLocalServiceUtil.addFolder(StringPool.BLANK, themeDisplay.getUserId(),
						themeDisplay.getScopeGroupId(), themeDisplay.getScopeGroupId(), Boolean.FALSE,
						DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,"oct",
						"User" + " oct", Boolean.FALSE, serviceContext);
			} else {
				folderQuery = DynamicQueryFactoryUtil.forClass(DLFolder.class, PortalClassLoaderUtil.getClassLoader());
				folderQuery.add(PropertyFactoryUtil.forName("name").eq("oct"));
				folderQuery.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()));
				folderQuery.add(
						PropertyFactoryUtil.forName("parentFolderId").eq(DLFolderConstants.DEFAULT_PARENT_FOLDER_ID));
				examFolder = (DLFolder) DLFolderLocalServiceUtil.dynamicQuery(folderQuery).get(0);
			}

			folderQuery = DynamicQueryFactoryUtil.forClass(DLFolder.class, PortalClassLoaderUtil.getClassLoader());
			folderQuery.add(PropertyFactoryUtil.forName("name").eq(String.valueOf(userId)));
			folderQuery.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()));
			folderQuery.add(PropertyFactoryUtil.forName("parentFolderId").eq(examFolder.getFolderId()));
			List<DLFolder> equivalencyFolderList = DLFolderLocalServiceUtil.dynamicQuery(folderQuery);
			List<String> equivalencyFolderNameList = equivalencyFolderList.parallelStream().map(DLFolder::getName)
					.collect(Collectors.toList());
			if (!equivalencyFolderNameList.contains(String.valueOf(userId))) {
				userFolder = DLFolderLocalServiceUtil.addFolder(StringPool.BLANK, themeDisplay.getUserId(),
						themeDisplay.getScopeGroupId(), themeDisplay.getScopeGroupId(), Boolean.FALSE,
						examFolder.getFolderId(), String.valueOf(userId), userId + " oct", Boolean.FALSE,
						serviceContext);
			} else {
				folderQuery = DynamicQueryFactoryUtil.forClass(DLFolder.class, PortalClassLoaderUtil.getClassLoader());
				folderQuery.add(PropertyFactoryUtil.forName("name").eq(String.valueOf(userId)));
				folderQuery.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()));
				folderQuery.add(PropertyFactoryUtil.forName("parentFolderId").eq(examFolder.getFolderId()));
				userFolder = (DLFolder) DLFolderLocalServiceUtil.dynamicQuery(folderQuery).get(0);
			}

			File file = generatePdfDocument(htmlReciept, themeDisplay,OCTExamConstants.OCT_PAYMENT_RECIEPT_PATH,OCTExamConstants.OCT_PAYMENT_RECIEPT_NAME);
			if (Validator.isNotNull(file)) {
				InputStream inputStream = new FileInputStream(file);
				long timeStamp = new Date().getTime();
				fileEntry = DLFileEntryLocalServiceUtil.addFileEntry(StringPool.BLANK, themeDisplay.getUserId(),
						themeDisplay.getScopeGroupId(), themeDisplay.getScopeGroupId(), userFolder.getFolderId(),
						OCTExamConstants.OCT_PAYMENT_RECIEPT_NAME + "_" + timeStamp + ".pdf", ContentTypes.APPLICATION_PDF,
						OCTExamConstants.OCT_PAYMENT_RECIEPT_NAME + "_" + timeStamp, OCTExamConstants.OCT_PAYMENT_RECIEPT_URL,
						"Payment Receipt", StringPool.BLANK, 0L, null, file, inputStream, file.length(), null, null,
						serviceContext);
			}

		} catch (Exception e) {
			logger.error(e);
		}
		return fileEntry;
	}

	public OCTExamPayment getExamPaymentDetailByRegistrationId(String portalURL, long scopeGroupId, long registrationId) {
		String examPaymentURL = portalURL + LRObjectURL.OC_EXAM_PAYMENTS_URL + CommonConstants.SCOPES + StringPool.SLASH
				+ scopeGroupId + StringPool.QUESTION + "filter=registrationId"
				+ URLEncoder.encode(" eq " + registrationId, StandardCharsets.UTF_8);
		logger.info("examPaymentURL" + examPaymentURL);
		String examPaymentResponse = omsbCommonApi.getData(examPaymentURL);
		logger.info("examPaymentResponse" + examPaymentResponse);
		if (Validator.isNotNull(examPaymentResponse)) {
			OCTExamPaymentItems examPaymentItems = CustomObjectMapperUtil.readValue(examPaymentResponse,
					OCTExamPaymentItems.class);
			if (Validator.isNotNull(examPaymentItems) && Validator.isNotNull(examPaymentItems.getItems())
					&& !examPaymentItems.getItems().isEmpty()) {
				return examPaymentItems.getItems().get(0);
			}
		}
		return null;
	}
	
	public String getFileDownloadUrl(ThemeDisplay themeDisplay, long fileEntryId, String pathContext) {
		FileEntry fileEntry = null;
		try {
			fileEntry = DLAppLocalServiceUtil.getFileEntry(fileEntryId);
			if (Validator.isNotNull(fileEntry)) {
				return DLURLHelperUtil.getPreviewURL(fileEntry, fileEntry.getFileVersion(), themeDisplay, "");
			}
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
		return null;
	}

	@Reference
	private ObjectDefinitionService objectDefinitionService;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference
	private OMSBHttpConnector omsbHttpConnector;

	@Reference(unbind = "-")
	private OMSBHttpConnector httpConnector;

	@Reference
	private ListTypeEntryLocalService listTypeEntryLocalService;

	@Reference
	UserNotificationEventLocalService userNotificationEventLocalService;

	@Reference
	private ObjectEntryLocalService objectEntryLocalService;

	@Reference
	private UserLocalService userLocalService;

	private static String ROOT_FOLDER_DESCRIPTION = "This folder is create for Upload documents";

	private static final Log logger = LogFactoryUtil.getLog(OCTExamUtil.class);

}
