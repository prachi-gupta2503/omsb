package gov.omsb.exam.web.portlet.util;

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
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.document.library.util.DLURLHelperUtil;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.CountryLocalService;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.UserNotificationEventLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.portlet.PortletRequest;

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
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.common.util.CommonUtil;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.exam.web.portlet.constants.MVCCommands;
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;
import gov.omsb.exam.web.portlet.dto.ByLawCondition;
import gov.omsb.exam.web.portlet.dto.ByLawConditionItem;
import gov.omsb.exam.web.portlet.dto.ByLawRule;
import gov.omsb.exam.web.portlet.dto.ByLawRuleItem;
import gov.omsb.exam.web.portlet.dto.Exam;
import gov.omsb.exam.web.portlet.dto.ExamAppeal;
import gov.omsb.exam.web.portlet.dto.ExamAppealItem;
import gov.omsb.exam.web.portlet.dto.ExamDefinition;
import gov.omsb.exam.web.portlet.dto.ExamMultiDates;
import gov.omsb.exam.web.portlet.dto.ExamMultiDatesItem;
import gov.omsb.exam.web.portlet.dto.ExamPayment;
import gov.omsb.exam.web.portlet.dto.ExamPaymentItems;
import gov.omsb.exam.web.portlet.dto.ExamResult;
import gov.omsb.exam.web.portlet.dto.ExamResultItem;
import gov.omsb.exam.web.portlet.dto.ExamSchedule;
import gov.omsb.exam.web.portlet.dto.ExamScheduleItem;
import gov.omsb.exam.web.portlet.dto.ExamType;
import gov.omsb.exam.web.portlet.dto.ExamTypeItem;
import gov.omsb.exam.web.portlet.dto.ExamWithdrawal;
import gov.omsb.exam.web.portlet.dto.ExamWithdrawalItem;
import gov.omsb.exam.web.portlet.dto.ExamWithdrawalStatus;
import gov.omsb.exam.web.portlet.dto.ExamWithdrawalStatusItem;
import gov.omsb.exam.web.portlet.dto.Registration;
import gov.omsb.exam.web.portlet.dto.RegistrationItem;
import gov.omsb.exam.web.portlet.dto.RegularFeeItem;
import gov.omsb.exam.web.portlet.dto.RegularFees;
import gov.omsb.exam.web.portlet.dto.Trainee;
import gov.omsb.exam.web.portlet.dto.TraineeItem;
import gov.omsb.exam.web.portlet.dto.WithdrawalFeeItem;
import gov.omsb.exam.web.portlet.dto.WithdrawalFees;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.model.GenderMaster;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.model.ProgramTypeMaster;
import gov.omsb.tms.model.TraineeAdmissionDetailsRel;
import gov.omsb.tms.model.TraineeCohortDetails;
import gov.omsb.tms.service.GenderMasterLocalServiceUtil;
import gov.omsb.tms.service.ProgramMasterLocalService;
import gov.omsb.tms.service.ProgramMasterLocalServiceUtil;
import gov.omsb.tms.service.ProgramTypeMasterLocalServiceUtil;
import gov.omsb.tms.service.TraineeAdmissionDetailsRelLocalServiceUtil;
import gov.omsb.tms.service.TraineeCohortDetailsLocalServiceUtil;
import gov.omsb.web.notification.configuration.action.OCTRegistrationNotificationConfigurationAction;

@Component(immediate = true, service = ExamUtil.class)
public class ExamUtil {

	public static List<User> fetchTraineeListByRole(ThemeDisplay themeDisplay) {
		logger.info("fetchTraineeListByRole() started:::");
		List<User> users = new ArrayList<>();
		try {
			long roleId = 0;
			Role role = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleNameConstants.TRAINEE);
			if (Validator.isNotNull(role)) {
				roleId = role.getRoleId();
				logger.info("roleId :::" + roleId);
			}
			users = UserLocalServiceUtil.getRoleUsers(roleId);
			logger.info("users::" + users.size());
		} catch (Exception e) {
			logger.error("error while fetching user ::" + e.getMessage(), e);
		}
		logger.info("fetchTraineeListByRole() ended:::");
		return users;

	}

	public static ExamResultItem getExamResultByExamTypeAndProgramId() {

		return null;

	}

	public ExamResult getExamResultByUserId(ThemeDisplay themeDisplay, long lrUserId) {
		String examResultUrl = themeDisplay.getPortalURL() + LRObjectURL.EXAM_RESULT_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=lrUserId"
				+ URLEncoder.encode(" eq " + lrUserId, StandardCharsets.UTF_8);
		String examResultresponse = commonApi.getData(examResultUrl);
		return CustomObjectMapperUtil.readValue(examResultresponse, ExamResult.class);

	}

	public RegistrationItem getRegistrationByUserIdAndScheduleId(String portalUrl,long groupId, long userId,
			long examScheduleId) {
		logger.info("getRegistrationByUserIdProgramAndExamType() started ");
		String registrationUrl = portalUrl
				+ LRObjectURL.EXAM_REGISTERATION_URL + CommonConstants.SCOPES + StringPool.SLASH
				+ groupId + StringPool.QUESTION + "filter=lrUserId" + URLEncoder
						.encode(" eq " + userId + " and examScheduleId eq " + examScheduleId, StandardCharsets.UTF_8)
				+ "&sort=dateCreated:desc";
		logger.info("registration url " + registrationUrl);
		String registrationResponse = commonApi.getData(registrationUrl);
		logger.debug("registration registrationResponse " + registrationResponse);
		logger.info("getRegistrationByUserIdProgramAndExamType() ended ");
		return CustomObjectMapperUtil.readValue(registrationResponse, RegistrationItem.class);

	}

	public List<ExamType> getExams(ThemeDisplay themeDisplay) {
		logger.info("getExams() started ");
		String examTypeurl = themeDisplay.getPortalURL() + LRObjectURL.EXAM_TYPE_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + themeDisplay.getScopeGroupId();
		String examTypeResponse = commonApi.getData(examTypeurl);
		ExamTypeItem examTypeItems = CustomObjectMapperUtil.readValue(examTypeResponse, ExamTypeItem.class);
		List<ExamType> examTypes = new ArrayList<>();
		if (Validator.isNotNull(examTypeItems) && Validator.isNotNull(examTypeItems.getItems())
				&& !examTypeItems.getItems().isEmpty()) {
			examTypes = examTypeItems.getItems();
		}
		logger.info("getExams() ended ");
		return examTypes;
	}

	public List<ExamType> getExamByProgramtype(ThemeDisplay themeDisplay, long programTypeId) {
		logger.info("getExamByProgramtype() started ");
		List<ExamType> examTypes = new ArrayList<>();
		try {
			String examTypeurl = themeDisplay.getPortalURL() + LRObjectURL.EXAM_TYPE_URL + CommonConstants.SCOPES
					+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=programTypeId"
					+ URLEncoder.encode(" eq " + programTypeId, DataflowConstants.UTF_8);
			logger.info("examTypeurl::" + examTypeurl);
			String examTypeResponse = commonApi.getData(examTypeurl);
			logger.info("examTypeResponse" + examTypeResponse);
			ExamTypeItem examTypeItems = CustomObjectMapperUtil.readValue(examTypeResponse, ExamTypeItem.class);
			if (Validator.isNotNull(examTypeItems) && Validator.isNotNull(examTypeItems.getItems())
					&& !examTypeItems.getItems().isEmpty()) {
				examTypes = examTypeItems.getItems();
			}
		} catch (Exception e) {
			logger.error("error while fetching exams ::" + e.getMessage(), e);
		}
		logger.info("getExamByProgramtype() ended ");
		return examTypes;
	}

	public ExamType getExamTypeByExamTypeName(ThemeDisplay themeDisplay, String examTypeName) {
		logger.info("getExamByProgramtype() started ");
		try {
			String examTypeurl = themeDisplay.getPortalURL() + LRObjectURL.EXAM_TYPE_URL + CommonConstants.SCOPES
					+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "search="
					+ examTypeName;
			String examTypeResponse = commonApi.getData(examTypeurl);
			logger.info("examTypeResponse" + examTypeResponse);
			if (examTypeResponse.contains("examType")) {
				ExamTypeItem examTypeItems = CustomObjectMapperUtil.readValue(examTypeResponse, ExamTypeItem.class);
				if (Validator.isNotNull(examTypeItems) && Validator.isNotNull(examTypeItems.getItems())
						&& !examTypeItems.getItems().isEmpty()) {
					return examTypeItems.getItems().get(0);
				}
			}
		} catch (Exception e) {
			logger.error("error while fetching exams ::" + e.getMessage(), e);
		}
		logger.info("getExamByProgramtype() ended ");
		return null;
	}

	public List<ProgramTypeMaster> getProgramType(ThemeDisplay themeDisplay) {
		logger.info("getProgramType() started");
		List<ProgramTypeMaster> programTypeMasters = new ArrayList<>();
		try {
			programTypeMasters = ProgramTypeMasterLocalServiceUtil.getProgramTypeMasters(-1, -1);
			for (ProgramTypeMaster programTypeMaster : programTypeMasters) {
				programTypeMaster
						.setProgramTypeName(CommonUtil.getValueByLanguage(programTypeMaster.getProgramTypeName(),
								OMSBExamWebPortletKeys.PROGRAM_TYPE, themeDisplay.getLocale().toString()));
			}
		} catch (Exception e) {
			logger.error("error while fetching program type:" + e.getMessage(), e);
		}
		logger.info("getProgramType() ended");
		return programTypeMasters;
	}

	public List<ProgramMaster> getProgram(ThemeDisplay themeDisplay) {
		logger.info("getProgramType() started");
		List<ProgramMaster> programMasters = new ArrayList<>();
		try {
			programMasters = programMasterLocalService.getProgramMasters(-1, -1);
			if (Validator.isNotNull(programMasters)) {
				for (ProgramMaster programMaster : programMasters) {
					programMaster.setProgramName(CommonUtil.getValueByLanguage(programMaster.getProgramName(),
							OMSBExamWebPortletKeys.PROGRAM_NAME, themeDisplay.getLocale().toString()));
				}
			}
		} catch (Exception e) {
			logger.error("error while fetching program type:" + e.getMessage(), e);
		}
		logger.info("getProgramType() ended");
		return programMasters;
	}

	public Exam getExamById(long examId, String portalUrl) {
		String url = portalUrl + LRObjectURL.EXAM_URL + examId;
		String response = commonApi.getData(url);
		return CustomObjectMapperUtil.readValue(response, Exam.class);
	}

	public List<ExamType> getExamTypes(String portalURL, long groupId, ThemeDisplay themeDisplay) {
		String url = portalURL + LRObjectURL.EXAM_TYPE_URL + CommonConstants.SCOPES + StringPool.SLASH + groupId;
		String response = httpConnector.executeGet(url, "", commonApi.getHttpHeaderInfoAndBasicAuth());
		logger.info("response::" + response);
		ExamTypeItem examTypeItems = CustomObjectMapperUtil.readValue(response, ExamTypeItem.class);
		if (Validator.isNotNull(examTypeItems)) {
			for (ExamType examType : examTypeItems.getItems()) {
				ListTypeEntry listTypeEntryByListTypeItemKey = omsbCommonApi.getListTypeEntryByListTypeItemKey(
						LRPicklistConstants.PL_EXAM_TYPE, examType.getExamType(), themeDisplay.getCompanyId());
				examType.setExamTypeName(Validator.isNotNull(listTypeEntryByListTypeItemKey)
						? listTypeEntryByListTypeItemKey.getName(themeDisplay.getLocale())
						: "");
			}
			return examTypeItems.getItems();
		}
		return new ArrayList<>();
	}

	public String getProgramByProgramId(long programId, ThemeDisplay themeDisplay) {
		try {
			if (programId > 0) {
				ProgramMaster programMaster = ProgramMasterLocalServiceUtil.getProgramMaster(programId);
				if (Validator.isNotNull(programMaster)) {
					return CommonUtil.getValueByLanguage(programMaster.getProgramName(),
							OMSBExamWebPortletKeys.PROGRAM_NAME, themeDisplay.getLocale().toString());
				}
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return "";
	}

	public ProgramMaster getProgramsByProgramId(long programId, ThemeDisplay themeDisplay) {
		try {
			if (programId > 0) {
				ProgramMaster programMaster = ProgramMasterLocalServiceUtil.getProgramMaster(programId);
				if (Validator.isNotNull(programMaster)) {
					programMaster.setProgramName(CommonUtil.getValueByLanguage(programMaster.getProgramName(),
							OMSBExamWebPortletKeys.PROGRAM_NAME, themeDisplay.getLocale().toString()));
				}
				return programMaster;
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	public List<Person> getPersonDetail(ThemeDisplay themeDisplay, long userId) {
		String personDetailUrl = themeDisplay.getPortalURL() + LRObjectURL.PERSON_DETAIL_URL.replace("{scope-id}",
				themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=lrUserId"
						+ URLEncoder.encode(" eq " + userId, StandardCharsets.UTF_8));
		String personDetailResponse = commonApi.getData(personDetailUrl);
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
		String personalDetailResponse = commonApi.getData(personalDetailUrl);
		PersonalDetailItem personalDetailItem = CustomObjectMapperUtil.readValue(personalDetailResponse,
				PersonalDetailItem.class);
		if (Validator.isNotNull(personalDetailItem) && Validator.isNotNull(personalDetailItem.getItems())
				&& !personalDetailItem.getItems().isEmpty()) {
			return personalDetailItem.getItems();
		}
		return new ArrayList<>();
	}

	public List<Country> getCountryDetails(ThemeDisplay themeDisplay, long countryId) {
		String countryUrl = themeDisplay.getPortalURL() + LRObjectURL.CUSTOM_COUNTRY_URL.replace("{scope-id}",
				themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=countryID"
						+ URLEncoder.encode(" eq '" + countryId + "'", StandardCharsets.UTF_8));
		String countryResponse = commonApi.getData(countryUrl);
		CountryItem countryItem = CustomObjectMapperUtil.readValue(countryResponse, CountryItem.class);
		if (Validator.isNotNull(countryItem) && Validator.isNotNull(countryItem.getItems())
				&& !countryItem.getItems().isEmpty()) {
			return countryItem.getItems();
		}
		return new ArrayList<>();
	}

	public ExamResultItem getExamResultByScheduleIdAndDefnId(ThemeDisplay themeDisplay, long userId,
			long examDefinitionId, long examScheduleId) {
		String url = themeDisplay.getPortalURL() + LRObjectURL.EXAM_RESULT_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=lrUserId"
				+ URLEncoder.encode(" eq " + userId + " and examDefinitionId eq " + examDefinitionId
						+ " and examScheduleId eq " + examScheduleId, StandardCharsets.UTF_8);
		logger.info("url for result:" + url);
		String resultResponse = commonApi.getData(url);
		logger.debug("response for result::" + resultResponse);
		if (Validator.isNotNull(resultResponse) && !resultResponse.isEmpty()) {
			ExamResult examResult = CustomObjectMapperUtil.readValue(resultResponse, ExamResult.class);
			if (Validator.isNotNull(examResult) && Validator.isNotNull(examResult.getItems())
					&& !examResult.getItems().isEmpty()) {
				logger.info("inside if condn");
				return examResult.getItems().get(0);
			}
		}
		return null;
	}

	public List<Registration> getRegistrationByScheduleId(ThemeDisplay themeDisplay, long examTypeId, long programId,
			long examScheduleId, long examDefinitionId) {
		logger.info("getRegistrationByUserIdProgramAndExamType() started ");
		List<Registration> registrations = new ArrayList<>();
		try {
			String registrationUrl = themeDisplay.getPortalURL() + LRObjectURL.EXAM_REGISTERATION_URL
					+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION
					+ "filter=examScheduleId" + URLEncoder.encode(" eq " + examScheduleId, StandardCharsets.UTF_8);
			logger.info("registration url " + registrationUrl);
			String registrationResponse = commonApi.getData(registrationUrl);
			logger.info("registration registrationResponse " + registrationResponse);

			RegistrationItem registration = CustomObjectMapperUtil.readValue(registrationResponse,
					RegistrationItem.class);
			if (Validator.isNotNull(registration) && !registration.getItems().isEmpty()) {
				logger.info("size of exam reg::" + registration.getItems().size());
				for (Registration registrationItem : registration.getItems()) {
					if (registrationItem.getRegistrationStatus().equalsIgnoreCase(OMSBExamWebPortletKeys.REGISTERED)) {
						User user = UserLocalServiceUtil.getUser(registrationItem.getLrUserId());
						if (Validator.isNotNull(user)) {
							registrationItem.setName(user.getFullName());
						}

						ExamResultItem examResultItem = getExamResultByUserId(registrationItem.getLrUserId(),
								themeDisplay, examScheduleId, examDefinitionId);
						if (Validator.isNotNull(examResultItem)) {
							registrationItem.setAppeared(examResultItem.getResult());
							registrationItem.setPercentage(examResultItem.getPercentage());
							registrationItem.setResult(examResultItem.getResult());
							logger.info("registartion : result from exam result:" + examResultItem.getResult());
						}
						registrationItem.setExamDefinitionId(examDefinitionId);
						registrationItem.setExamScheduleId(examScheduleId);
						registrationItem.setProgramName(getProgramByProgramId(programId, themeDisplay));
						registrationItem.setExamTypeName(getExamType(examTypeId, themeDisplay.getCompanyId(),themeDisplay.getPortalURL(),themeDisplay.getLocale()));
						registrationItem.setExamTypeId(examTypeId);
						registrationItem.setProgramId(programId);
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
	}

	public ExamDefinition getExamDefByScheduleId(String portalURL, String examDefinitionId) {
		String examDefinitionURL = portalURL + LRObjectURL.EXAM_DEFINITION_URL + examDefinitionId;
		Map<String, String> headers = commonApi.getHttpHeaderInfoAndBasicAuth();
		String examDefinitionResponse = httpConnector.executeGet(examDefinitionURL, "", headers);
		return CustomObjectMapperUtil.readValue(examDefinitionResponse, ExamDefinition.class);

	}

	public String getExamType(long examTypeId,long companyId,String portalURL,Locale locale) {
		try {
			String url = portalURL + LRObjectURL.EXAM_TYPE_URL + examTypeId;
			String response = httpConnector.executeGet(url, "", commonApi.getHttpHeaderInfoAndBasicAuth());
			ExamType examType = CustomObjectMapperUtil.readValue(response, ExamType.class);
			if (!response.isEmpty() && Validator.isNotNull(examType) && (response.contains("examType"))) {
				ListTypeEntry listTypeEntryByListTypeItemKey = omsbCommonApi.getListTypeEntryByListTypeItemKey(
						LRPicklistConstants.PL_EXAM_TYPE, examType.getExamType(), companyId);
				if (Validator.isNotNull(listTypeEntryByListTypeItemKey)) {
					logger.info("Exam Type Name by Exam Type ID :: getExamType :: ExamUtill Class :: "
							+ listTypeEntryByListTypeItemKey.getName());
					return listTypeEntryByListTypeItemKey.getName(locale);

				}

			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return "";
	}

	public ExamResultItem getExamResultByUserId(long userId, ThemeDisplay themeDisplay, long examScheduleId,
			long examDefinitionId) {
		try {
			String examResultURL = themeDisplay.getPortalURL() + LRObjectURL.EXAM_RESULT_URL + CommonConstants.SCOPES
					+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=lrUserId"
					+ URLEncoder.encode(" eq " + userId + " and examScheduleId eq " + examScheduleId
							+ " and examDefinitionId eq " + examDefinitionId, DataflowConstants.UTF_8);
			String examResultResponse = commonApi.getData(examResultURL);
			logger.info("result response:" + examResultResponse);
			ExamResult examResult = CustomObjectMapperUtil.readValue(examResultResponse, ExamResult.class);
			if (Validator.isNotNull(examResult) && !examResult.getItems().isEmpty()) {
				return examResult.getItems().get(0);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

//	trainee by role and program id
	public List<TraineeItem> getTraineeByRoleAndProgram(ThemeDisplay themeDisplay, long programId, long examTypeId,
			long examDefinitionId, ExamSchedule examSchedule) {
		List<TraineeItem> traineeItems = new ArrayList<>();
		try {
			logger.info("programId in getTrainee:::" + programId);
			String url = themeDisplay.getPortalURL() + LRObjectURL.REG_USER_METADATA_URL + CommonConstants.SCOPES
					+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=programId"
					+ URLEncoder.encode(" eq " + programId , StandardCharsets.UTF_8) + "&pageSize=0" ;
//			ObjectDefinition objectDefinition = ObjectDefinitionLocalServiceUtil
//					.getObjectDefinitionByExternalReferenceCode(LRObjectURL.OBJ_USER_META_DATA_ERC,
//							themeDisplay.getCompanyId());
//			if (Validator.isNotNull(objectDefinition) && objectDefinition.getObjectDefinitionId() > 0) {
//				List<ObjectEntry> objectEntries = ObjectEntryLocalServiceUtil.getObjectEntries(
//						themeDisplay.getScopeGroupId(), objectDefinition.getObjectDefinitionId(), -1, -1);
//				if (Validator.isNotNull(objectEntries) && !objectEntries.isEmpty()) {
//					logger.info("size of object entry: " + objectEntries.size());
//				}
//			}
			logger.info("url:" + url);
			String response = httpConnector.executeGet(url, "", commonApi.getHttpHeaderInfoAndBasicAuth());
			logger.info("response for user:" + response);
			Trainee trainees = CustomObjectMapperUtil.readValue(response, Trainee.class);
			if (Validator.isNotNull(trainees) && Validator.isNotNull(trainees.getItems())
					&& !trainees.getItems().isEmpty()) {
				List<String> allRuleConditionText = geAllByLawRuleConditionText(themeDisplay);
				for (TraineeItem traineeItem : trainees.getItems()) {
					logger.info("trainee roleid" + traineeItem.getRoleId());
					User user = UserLocalServiceUtil.getUser(traineeItem.getLrUserId());

					if (Validator.isNotNull(user)) {
						List<String> roleNames = user.getRoles().stream().map(Role::getName)
								.collect(Collectors.toList());
						logger.info("user name after filter: "+user.getFullName());
						String traineeLevel = "R" + getTraineeLevelId(user.getUserId());
						traineeLevel = traineeLevel.toLowerCase();
						for (int i = 0; i < allRuleConditionText.size(); i++) {
							logger.info("ruleConditionText: " + allRuleConditionText.get(i));
							if (roleNames.contains(RoleNameConstants.TRAINEE)
									&& allRuleConditionText.get(i).toLowerCase().contains(traineeLevel)) {	
								logger.info("true: " + i);
								traineeItem.setName(user.getFullName());
								traineeItem.setEmailAddress(user.getEmailAddress());
								traineeItems.add(traineeItem);
								Registration registration = getRegistrationByProgramIdAndUserId(themeDisplay, programId,
										user.getUserId());
								if (Validator.isNotNull(registration)) {

									long paymentReceiptFileEntryId = registration.getPaymentReceiptFileEntryId();
									if (paymentReceiptFileEntryId > 0) {
										String payemtReceiptUrl = getFileDownloadUrl(themeDisplay,
												paymentReceiptFileEntryId, themeDisplay.getPathContext());
										logger.info("payemtReceiptUrl" + payemtReceiptUrl);
										if (Validator.isNotNull(payemtReceiptUrl)) {
											traineeItem.setPaymentReceiptUrl(payemtReceiptUrl);
										}
									}
								}
								break;
							}
							continue;
						}
						traineeItem.setRegistrationStatus(
								getRegistrationStatus(themeDisplay, programId, user.getUserId()));

						logger.info("registartion status:::" + traineeItem.getRegistrationStatus());
						traineeItem.setExamDefinitionId(examDefinitionId);
						traineeItem.setExamTypeId(examTypeId);
						traineeItem.setExamTypeName(getExamType(examTypeId, themeDisplay.getCompanyId(),themeDisplay.getPortalURL(),themeDisplay.getLocale()));
						traineeItem.setProgramName(getProgramByProgramId(programId, themeDisplay));
						List<Person> personDetail = getPersonDetail(themeDisplay, traineeItem.getLrUserId());
						if (Validator.isNotNull(personDetail) && !personDetail.isEmpty()) {
							String dateOfBirth = omsbCommonApi
									.convertDateFormatToDDMMYYYY(personDetail.get(0).getDateOfBirth());
							logger.info("dateOfBirth::" + dateOfBirth);
							traineeItem.setDateOfBirth(Validator.isNotNull(dateOfBirth) ? dateOfBirth : "");
							List<PersonalDetail> personalDetail = getPersonalDetail(themeDisplay,
									personDetail.get(0).getId());
							if (Validator.isNotNull(personalDetail) && !personalDetail.isEmpty()) {
								long countryId = personalDetail.get(0).getCountryId();
								if (countryId > 0) {
									logger.info("country id:" + countryId);
									try {
										traineeItem.setNationality(countryLocalService.getCountry(countryId)
												.getName(themeDisplay.getLocale()));
									} catch (Exception e) {
										logger.error("no country exist with this country id:" + countryId);
									}
								}
								traineeItem.setGender(getGenderName(personalDetail));
								traineeItem.setPassportNumber(personalDetail.get(0).getPassportNumber());

							}
						}

						traineeItem.setExamSchedule(examSchedule);
						traineeItem.setExamSchedule(examSchedule);
					}
				}

			}
		} catch (

		Exception e) {
			logger.error(e.getMessage(), e);
		}
		return traineeItems;
	}

	public String getRegistrationStatus(ThemeDisplay themeDisplay, long programId, long userId) {
		logger.info("getRegistrationStatus() started ");
		try {
			String registrationUrl = themeDisplay.getPortalURL() + LRObjectURL.EXAM_REGISTERATION_URL
					+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION
					+ "filter=programId"
					+ URLEncoder.encode(" eq " + programId + " and lrUserId eq " + userId, StandardCharsets.UTF_8);
			logger.info("registration url " + registrationUrl);
			String registrationResponse = commonApi.getData(registrationUrl);
			logger.info("registration registrationResponse " + registrationResponse);

			RegistrationItem registration = CustomObjectMapperUtil.readValue(registrationResponse,
					RegistrationItem.class);
			if (Validator.isNotNull(registration) && Validator.isNotNull(registration.getItems())
					&& !registration.getItems().isEmpty()) {
				return registration.getItems().get(0).getRegistrationStatus();
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.info("getRegistrationStatus() ended ");
		return "Not Registered";
	}

	public List<TraineeItem> getTraineeByRegistrationstatus(String status, ThemeDisplay themeDisplay, long programId,
			long examTypeId, long examDefinitionId) {
		List<TraineeItem> traineeItems = new ArrayList<>();
		try {
			String registrationUrl = themeDisplay.getPortalURL() + LRObjectURL.EXAM_REGISTERATION_URL
					+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION
					+ "filter=registrationStatus" + URLEncoder
							.encode(" eq '" + status + "'" + " and programId eq " + programId, StandardCharsets.UTF_8);
			String registrationResponse = commonApi.getData(registrationUrl);
			logger.info("registration registrationResponse " + registrationResponse);
			RegistrationItem registrationItems = CustomObjectMapperUtil.readValue(registrationResponse,
					RegistrationItem.class);
			if (Validator.isNotNull(registrationItems) && Validator.isNotNull(registrationItems.getItems())) {
				for (Registration registration : registrationItems.getItems()) {
					TraineeItem traineeItem = new TraineeItem();
					User user = UserLocalServiceUtil.getUser(registration.getLrUserId());
					if (Validator.isNotNull(user)) {
						traineeItem.setLrUserId(user.getUserId());
						traineeItem.setName(user.getFullName());
						traineeItem.setRegistrationStatus(registration.getRegistrationStatus());
						traineeItem.setExamDefinitionId(examDefinitionId);
						traineeItem.setExamTypeId(examTypeId);
						traineeItem.setProgramId(programId);
						traineeItems.add(traineeItem);
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return traineeItems;
	}

	public List<TraineeItem> getTraineeByNonRegistered(ThemeDisplay themeDisplay, long programId, long examTypeId,
			long examDefinitionId) {
		List<TraineeItem> traineeItems = new ArrayList<>();
		try {
			String url = themeDisplay.getPortalURL() + LRObjectURL.REG_USER_METADATA_URL + CommonConstants.SCOPES
					+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=programId"
					+ URLEncoder.encode(" eq " + programId, StandardCharsets.UTF_8);
			logger.info("url:" + url);
			String response = commonApi.getData(url);
			logger.info("response for user:" + response);
			Trainee trainees = CustomObjectMapperUtil.readValue(response, Trainee.class);
			if (Validator.isNotNull(trainees) && Validator.isNotNull(trainees.getItems())
					&& !trainees.getItems().isEmpty()) {

				for (TraineeItem traineeItem : trainees.getItems()) {
					logger.info("trainee roleid" + traineeItem.getRoleId());
					Role role = RoleLocalServiceUtil.fetchRole(Long.valueOf(traineeItem.getRoleId()));
					User user = UserLocalServiceUtil.getUser(traineeItem.getLrUserId());
					logger.info("role name:" + role.getName());
					if (Validator.isNotNull(user) && Validator.isNotNull(role)
							&& role.getName().contains(RoleNameConstants.TRAINEE)
							&& getRegistrationStatus(themeDisplay, programId, user.getUserId())
									.equalsIgnoreCase("Not Registered")) {
						traineeItem.setName(user.getFullName());
						traineeItems.add(traineeItem);
						logger.info(
								"status return:" + getRegistrationStatus(themeDisplay, programId, user.getUserId()));
						traineeItem.setRegistrationStatus(
								getRegistrationStatus(themeDisplay, programId, user.getUserId()));
						traineeItem.setExamDefinitionId(examDefinitionId);
						traineeItem.setExamTypeId(examTypeId);
						traineeItem.setExamTypeName(getExamType(examTypeId, themeDisplay.getCompanyId(),themeDisplay.getPortalURL(),themeDisplay.getLocale()));
						traineeItem.setProgramName(getProgramByProgramId(programId, themeDisplay));
						traineeItem.setProgramId(programId);
					}
				}

			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return traineeItems;
	}

	public List<User> getUsersByName(String firstName, String lastName) {
		List<User> userList = new ArrayList<>();
		try {
			logger.info("first name:" + firstName);
			DynamicQuery query = UserLocalServiceUtil.dynamicQuery();
			Criterion criterion = RestrictionsFactoryUtil.ilike("firstName",
					StringPool.PERCENT + firstName + StringPool.PERCENT);
			criterion = RestrictionsFactoryUtil.or(criterion,
					RestrictionsFactoryUtil.ilike("lastName", StringPool.PERCENT + lastName + StringPool.PERCENT));
			query.add(criterion);
			userList = UserLocalServiceUtil.dynamicQuery(query);
			logger.info("size of user:" + userList.size());
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return userList;
	}

	public List<TraineeItem> getTraineeByNameRegistered(ThemeDisplay themeDisplay, String traineeName, long programId,
			String status, long examTypeId, long examDefinitionId) {
		logger.info("getTraineeByName() started");
		List<TraineeItem> traineeItems = new ArrayList<>();
		try {
			List<User> users = getUsersByName(traineeName, traineeName);
			if (Validator.isNotNull(users) && !users.isEmpty()) {
				for (User user : users) {
					logger.info("user id:" + user.getUserId());
					TraineeItem traineeItem = new TraineeItem();
					String url = themeDisplay.getPortalURL() + LRObjectURL.REG_USER_METADATA_URL
							+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId()
							+ StringPool.QUESTION + "filter=programId"
							+ URLEncoder.encode(" eq " + programId + " and lrUserId eq " + user.getUserId(),
									StandardCharsets.UTF_8);
					logger.info("url:" + url);
					String response = commonApi.getData(url);
					logger.info("response for trainee:" + response);
					Trainee trainees = CustomObjectMapperUtil.readValue(response, Trainee.class);
					if (Validator.isNotNull(trainees) && Validator.isNotNull(trainees.getItems())
							&& !trainees.getItems().isEmpty() && trainees.getItems().get(0).getLrUserId() > 0
							&& !getRegistrationStatus(themeDisplay, programId, trainees.getItems().get(0).getLrUserId())
									.equals(OMSBExamWebPortletKeys.NOT_REGISTERED)) {
						logger.info("inside if");
						traineeItem.setRegistrationStatus(getRegistrationStatus(themeDisplay, programId,
								trainees.getItems().get(0).getLrUserId()));
						traineeItem = setTraineeDetails(traineeItem, programId, examTypeId, examDefinitionId, user);
						traineeItems.add(traineeItem);
					}

				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.info("getTraineeByName() ended");
		return traineeItems;
	}

	public List<TraineeItem> getTraineeByOMSBId(long oMSBId, long programId, ThemeDisplay themeDisplay, long examTypeId,
			long examDefinitionId) {
		List<TraineeItem> traineeItems = new ArrayList<>();
		try {
			String url = themeDisplay.getPortalURL() + LRObjectURL.REG_USER_METADATA_URL + CommonConstants.SCOPES
					+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=programId"
					+ URLEncoder.encode(" eq " + programId + " and lrUserId eq " + oMSBId, StandardCharsets.UTF_8);
			String response = commonApi.getData(url);
			logger.info("response for trainee:" + response);
			Trainee trainees = CustomObjectMapperUtil.readValue(response, Trainee.class);
			if (Validator.isNotNull(trainees) && Validator.isNotNull(trainees.getItems())
					&& !trainees.getItems().isEmpty()) {
				for (TraineeItem traineeItem : trainees.getItems()) {
					User user = UserLocalServiceUtil.getUser(traineeItem.getLrUserId());
					traineeItem.setRegistrationStatus(
							getRegistrationStatus(themeDisplay, programId, traineeItem.getLrUserId()));
					if (Validator.isNotNull(user)) {
						traineeItem = setTraineeDetails(traineeItem, programId, examTypeId, examDefinitionId, user);
						traineeItems.add(traineeItem);
					}

				}
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return traineeItems;
	}

	public List<TraineeItem> getTraineeByDateOfBirth(String dateOfBirth, long programId, ThemeDisplay themeDisplay,
			long examTypeId, long examDefinitionId) {
		List<TraineeItem> traineeItems = new ArrayList<>();
		try {
			String url = themeDisplay.getPortalURL() + LRObjectURL.REG_USER_METADATA_URL + CommonConstants.SCOPES
					+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=programId"
					+ URLEncoder.encode(" eq " + programId, StandardCharsets.UTF_8);
			String response = commonApi.getData(url);
			logger.info("response for trainee:" + response);
			Trainee trainees = CustomObjectMapperUtil.readValue(response, Trainee.class);
			if (Validator.isNotNull(trainees) && Validator.isNotNull(trainees.getItems())
					&& !trainees.getItems().isEmpty()) {
				for (TraineeItem traineeItem : trainees.getItems()) {
					List<Person> personDetail = getPersonDetail(themeDisplay, traineeItem.getLrUserId());
					if (Validator.isNotNull(personDetail) && !personDetail.isEmpty()) {
						String birthDate = commonApi
								.convertObjectDateToDDMMYYYYDate(personDetail.get(0).getDateOfBirth());
						User user = UserLocalServiceUtil.getUser(traineeItem.getLrUserId());
						traineeItem.setRegistrationStatus(
								getRegistrationStatus(themeDisplay, programId, traineeItem.getLrUserId()));
						if (birthDate.equalsIgnoreCase(dateOfBirth) && Validator.isNotNull(user)) {
							logger.info("birthdates are matched");
							traineeItem = setTraineeDetails(traineeItem, programId, examTypeId, examDefinitionId, user);
							traineeItems.add(traineeItem);
						}
					}
				}
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return traineeItems;
	}

	public ExamResultItem getExamResultById(ThemeDisplay themeDisplay, long examResultId) {
		String examResultUrl = themeDisplay.getPortalURL() + LRObjectURL.EXAM_RESULT_URL + examResultId;
		String examResultresponse = commonApi.getData(examResultUrl);
		logger.info(examResultresponse);
		ExamResultItem examResult = CustomObjectMapperUtil.readValue(examResultresponse, ExamResultItem.class);
		if (Validator.isNotNull(examResult)) {
			return examResult;
		}
		return examResult;
	}

	public List<TraineeItem> getTraineeByName(ThemeDisplay themeDisplay, String traineeName, long programId,
			long examTypeId, long examDefinitionId) {
		logger.info("getTraineeByName() started");
		List<TraineeItem> traineeItems = new ArrayList<>();
		try {
			List<User> users = getUsersByName(traineeName, traineeName);
			if (Validator.isNotNull(users) && !users.isEmpty()) {
				for (User user : users) {
					logger.info("user id:" + user.getUserId());
					TraineeItem traineeItem = new TraineeItem();
					String url = themeDisplay.getPortalURL() + LRObjectURL.REG_USER_METADATA_URL
							+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId()
							+ StringPool.QUESTION + "filter=programId"
							+ URLEncoder.encode(" eq " + programId + " and lrUserId eq " + user.getUserId(),
									StandardCharsets.UTF_8);
					logger.info("url:" + url);
					String response = commonApi.getData(url);
					logger.info("response for trainee:" + response);
					Trainee trainees = CustomObjectMapperUtil.readValue(response, Trainee.class);
					logger.info("inside if");
					traineeItem.setRegistrationStatus(
							getRegistrationStatus(themeDisplay, programId, trainees.getItems().get(0).getLrUserId()));
					traineeItem = setTraineeDetails(traineeItem, programId, examTypeId, examDefinitionId, user);
					traineeItems.add(traineeItem);

				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.info("getTraineeByName() ended");
		return traineeItems;
	}

	public List<TraineeItem> getTraineeByNameAndOmsbId(ThemeDisplay themeDisplay, String traineeName, long programId,
			long examTypeId, long examDefinitionId, long oMSBId) {
		logger.info("getTraineeByName() started");
		List<TraineeItem> traineeItems = new ArrayList<>();
		try {
			List<User> users = getUsersByName(traineeName, traineeName);
			if (Validator.isNotNull(users) && !users.isEmpty()) {
				for (User user : users) {
					logger.info("user id:" + user.getUserId());
					TraineeItem traineeItem = new TraineeItem();
					String url = themeDisplay.getPortalURL() + LRObjectURL.REG_USER_METADATA_URL
							+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId()
							+ StringPool.QUESTION + "filter=programId" + URLEncoder
									.encode(" eq " + programId + " and lrUserId eq " + oMSBId, StandardCharsets.UTF_8);
					logger.info("url:" + url);
					String response = commonApi.getData(url);
					logger.info("response for trainee:" + response);
					Trainee trainees = CustomObjectMapperUtil.readValue(response, Trainee.class);
					logger.info("inside if");
					traineeItem.setRegistrationStatus(
							getRegistrationStatus(themeDisplay, programId, trainees.getItems().get(0).getLrUserId()));
					traineeItem = setTraineeDetails(traineeItem, programId, examTypeId, examDefinitionId, user);
					traineeItems.add(traineeItem);

				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.info("getTraineeByName() ended");
		return traineeItems;
	}

	public List<TraineeItem> getTraineeByNameAndNotRegistered(ThemeDisplay themeDisplay, String traineeName,
			long programId, long examTypeId, long examDefinitionId) {
		logger.info("getTraineeByName() started");
		List<TraineeItem> traineeItems = new ArrayList<>();
		try {
			List<User> users = getUsersByName(traineeName, traineeName);
			if (Validator.isNotNull(users) && !users.isEmpty()) {
				for (User user : users) {
					logger.info("user id:" + user.getUserId());
					TraineeItem traineeItem = new TraineeItem();
					String url = themeDisplay.getPortalURL() + LRObjectURL.REG_USER_METADATA_URL
							+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId()
							+ StringPool.QUESTION + "filter=programId"
							+ URLEncoder.encode(" eq " + programId + " and lrUserId eq " + user.getUserId(),
									StandardCharsets.UTF_8);
					logger.info("url:" + url);
					String response = commonApi.getData(url);
					logger.info("response for trainee:" + response);
					Trainee trainees = CustomObjectMapperUtil.readValue(response, Trainee.class);
					if (Validator.isNotNull(trainees) && Validator.isNotNull(trainees.getItems())
							&& !trainees.getItems().isEmpty() && trainees.getItems().get(0).getLrUserId() > 0
							&& getRegistrationStatus(themeDisplay, programId, trainees.getItems().get(0).getLrUserId())
									.equals(OMSBExamWebPortletKeys.NOT_REGISTERED)) {
						logger.info("inside if");
						traineeItem.setRegistrationStatus(getRegistrationStatus(themeDisplay, programId,
								trainees.getItems().get(0).getLrUserId()));
						traineeItem = setTraineeDetails(traineeItem, programId, examTypeId, examDefinitionId, user);
						traineeItems.add(traineeItem);
					}

				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.info("getTraineeByName() ended");
		return traineeItems;
	}

	public List<TraineeItem> getTraineeByNameAndDOB(String dateOfBirth, long programId, ThemeDisplay themeDisplay,
			long examTypeId, long examDefinitionId, String traineeName) {
		List<TraineeItem> traineeItems = new ArrayList<>();
		try {
			List<User> users = getUsersByName(traineeName, traineeName);
			if (Validator.isNotNull(users) && !users.isEmpty()) {
				for (User user : users) {
					logger.info("user id:" + user.getUserId());
					String url = themeDisplay.getPortalURL() + LRObjectURL.REG_USER_METADATA_URL
							+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId()
							+ StringPool.QUESTION + "filter=programId"
							+ URLEncoder.encode(" eq " + programId + " and lrUserId eq " + user.getUserId(),
									StandardCharsets.UTF_8);
					logger.info("url:" + url);
					String response = commonApi.getData(url);
					logger.info("response for trainee:" + response);
					Trainee trainees = CustomObjectMapperUtil.readValue(response, Trainee.class);
					logger.info("inside if");
					for (TraineeItem traineeItem : trainees.getItems()) {
						List<Person> personDetail = getPersonDetail(themeDisplay, traineeItem.getLrUserId());
						if (Validator.isNotNull(personDetail) && !personDetail.isEmpty()) {
							String birthDate = commonApi
									.convertObjectDateToDDMMYYYYDate(personDetail.get(0).getDateOfBirth());
							traineeItem.setRegistrationStatus(
									getRegistrationStatus(themeDisplay, programId, traineeItem.getLrUserId()));
							if (birthDate.equalsIgnoreCase(dateOfBirth) && Validator.isNotNull(user)) {
								logger.info("birthdates are matched");
								traineeItem = setTraineeDetails(traineeItem, programId, examTypeId, examDefinitionId,
										user);
								traineeItems.add(traineeItem);
							}
						}
					}
				}
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return traineeItems;
	}

	public List<TraineeItem> getTraineeByNameAndStatusAndoMSBIdReg(ThemeDisplay themeDisplay, String traineeName,
			long programId, long examTypeId, long examDefinitionId, long oMSBId) {
		logger.info("getTraineeByName() started");
		List<TraineeItem> traineeItems = new ArrayList<>();
		try {
			List<User> users = getUsersByName(traineeName, traineeName);
			if (Validator.isNotNull(users) && !users.isEmpty()) {
				for (User user : users) {
					logger.info("user id:" + user.getUserId());
					TraineeItem traineeItem = new TraineeItem();
					String url = themeDisplay.getPortalURL() + LRObjectURL.REG_USER_METADATA_URL
							+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId()
							+ StringPool.QUESTION + "filter=programId" + URLEncoder
									.encode(" eq " + programId + " and lrUserId eq " + oMSBId, StandardCharsets.UTF_8);
					logger.info("url:" + url);
					String response = commonApi.getData(url);
					logger.info("response for trainee:" + response);
					Trainee trainees = CustomObjectMapperUtil.readValue(response, Trainee.class);
					for (TraineeItem trainee : trainees.getItems()) {
						if (Validator.isNotNull(trainees) && Validator.isNotNull(trainees.getItems())
								&& !trainees.getItems().isEmpty() && trainee.getLrUserId() > 0
								&& !getRegistrationStatus(themeDisplay, programId, trainee.getLrUserId())
										.equals(OMSBExamWebPortletKeys.NOT_REGISTERED)) {

							logger.info("inside if");

							traineeItem.setRegistrationStatus(
									getRegistrationStatus(themeDisplay, programId, trainee.getLrUserId()));
							traineeItem = setTraineeDetails(traineeItem, programId, examTypeId, examDefinitionId, user);
							traineeItems.add(traineeItem);
						}
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.info("getTraineeByName() ended");
		return traineeItems;
	}

	public List<TraineeItem> getTraineeByNameAndStatusAndoMSBIdNONReg(ThemeDisplay themeDisplay, String traineeName,
			long programId, long examTypeId, long examDefinitionId, long oMSBId) {
		logger.info("getTraineeByName() started");
		List<TraineeItem> traineeItems = new ArrayList<>();
		try {
			List<User> users = getUsersByName(traineeName, traineeName);
			if (Validator.isNotNull(users) && !users.isEmpty()) {
				for (User user : users) {
					logger.info("user id:" + user.getUserId());
					TraineeItem traineeItem = new TraineeItem();
					String url = themeDisplay.getPortalURL() + LRObjectURL.REG_USER_METADATA_URL
							+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId()
							+ StringPool.QUESTION + "filter=programId" + URLEncoder
									.encode(" eq " + programId + " and lrUserId eq " + oMSBId, StandardCharsets.UTF_8);
					logger.info("url:" + url);
					String response = commonApi.getData(url);
					logger.info("response for trainee:" + response);
					Trainee trainees = CustomObjectMapperUtil.readValue(response, Trainee.class);
					for (TraineeItem trainee : trainees.getItems()) {
						if (Validator.isNotNull(trainees) && Validator.isNotNull(trainees.getItems())
								&& !trainees.getItems().isEmpty() && trainee.getLrUserId() > 0
								&& getRegistrationStatus(themeDisplay, programId, trainee.getLrUserId())
										.equals(OMSBExamWebPortletKeys.NOT_REGISTERED)) {

							logger.info("inside if");

							traineeItem.setRegistrationStatus(
									getRegistrationStatus(themeDisplay, programId, trainee.getLrUserId()));
							traineeItem = setTraineeDetails(traineeItem, programId, examTypeId, examDefinitionId, user);
							traineeItems.add(traineeItem);
						}
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.info("getTraineeByName() ended");
		return traineeItems;
	}

	public TraineeItem setTraineeDetails(TraineeItem traineeItem, long programId, long examTypeId,
			long examDefinitionId, User user) {
		traineeItem.setName(user.getFullName());
		traineeItem.setLrUserId(user.getUserId());
		traineeItem.setProgramId(programId);
		traineeItem.setExamTypeId(examTypeId);
		return traineeItem;

	}

	public ExamResultItem getExamResultById(long examResultId, ThemeDisplay themeDisplay) {
		ExamResultItem examResult = null;
		String examResultsUrl = themeDisplay.getPortalURL() + LRObjectURL.EXAM_RESULT_URL + examResultId;
		String examResultsResponse = commonApi.getData(examResultsUrl);
		if (examResultsResponse.contains("lrUserId")) {
			examResult = CustomObjectMapperUtil.readValue(examResultsResponse, ExamResultItem.class);
		}
		return examResult;
	}
	
	public ExamAppeal getExamAppealByExamResultId(ThemeDisplay themeDisplay, long examResultId) {
		ExamAppeal appeal = null;
		String getUrl = themeDisplay.getPortalURL() + LRObjectURL.EXAM_APPEAL_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=examResultId"
				+ URLEncoder.encode(" eq " + examResultId, StandardCharsets.UTF_8);

		String appealResponse = commonApi.getData(getUrl);
		if (appealResponse.contains("examResultId")) {
			ExamAppealItem appealItem = CustomObjectMapperUtil.readValue(appealResponse, ExamAppealItem.class);
			if (Validator.isNotNull(appealItem) && Validator.isNotNull(appealItem.getItems())
					&& !appealItem.getItems().isEmpty()) {
				appeal = appealItem.getItems().get(0);
			}
		}
		return appeal;
	}

	public List<TraineeItem> getTraineeByomsbIdAndStatus(long programId, ThemeDisplay themeDisplay, long examTypeId,
			long examDefinitionId, String status, long oMSBId) {
		List<TraineeItem> traineeItems = new ArrayList<>();
		try {
			String url = themeDisplay.getPortalURL() + LRObjectURL.REG_USER_METADATA_URL + CommonConstants.SCOPES
					+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=programId"
					+ URLEncoder.encode(" eq " + programId + " and lrUserId eq " + oMSBId, StandardCharsets.UTF_8);
			String response = commonApi.getData(url);
			logger.info("response for trainee:" + response);
			Trainee trainees = CustomObjectMapperUtil.readValue(response, Trainee.class);
			if (Validator.isNotNull(trainees) && Validator.isNotNull(trainees.getItems())
					&& !trainees.getItems().isEmpty()) {
				for (TraineeItem traineeItem : trainees.getItems()) {
					User user = UserLocalServiceUtil.getUser(traineeItem.getLrUserId());
					if (Validator.isNotNull(user) && Validator.isNotNull(trainees)
							&& Validator.isNotNull(trainees.getItems()) && !trainees.getItems().isEmpty()
							&& traineeItem.getLrUserId() > 0
							&& !getRegistrationStatus(themeDisplay, programId, traineeItem.getLrUserId())
									.equals(OMSBExamWebPortletKeys.NOT_REGISTERED)) {
						traineeItem.setRegistrationStatus(
								getRegistrationStatus(themeDisplay, programId, traineeItem.getLrUserId()));
						traineeItem = setTraineeDetails(traineeItem, programId, examTypeId, examDefinitionId, user);
						traineeItems.add(traineeItem);
					}

				}
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return traineeItems;
	}

	public List<TraineeItem> getTraineeByomsbIdAndStatusNonReg(long programId, ThemeDisplay themeDisplay,
			long examTypeId, long examDefinitionId, long oMSBId) {
		List<TraineeItem> traineeItems = new ArrayList<>();
		try {
			String url = themeDisplay.getPortalURL() + LRObjectURL.REG_USER_METADATA_URL + CommonConstants.SCOPES
					+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=programId"
					+ URLEncoder.encode(" eq " + programId + " and lrUserId eq " + oMSBId, StandardCharsets.UTF_8);
			String response = commonApi.getData(url);
			logger.info("response for trainee:" + response);
			Trainee trainees = CustomObjectMapperUtil.readValue(response, Trainee.class);
			if (Validator.isNotNull(trainees) && Validator.isNotNull(trainees.getItems())
					&& !trainees.getItems().isEmpty()) {
				for (TraineeItem traineeItem : trainees.getItems()) {
					User user = UserLocalServiceUtil.getUser(traineeItem.getLrUserId());
					if (Validator.isNotNull(user) && Validator.isNotNull(trainees)
							&& Validator.isNotNull(trainees.getItems()) && !trainees.getItems().isEmpty()
							&& traineeItem.getLrUserId() > 0
							&& getRegistrationStatus(themeDisplay, programId, traineeItem.getLrUserId())
									.equals(OMSBExamWebPortletKeys.NOT_REGISTERED)) {
						traineeItem.setRegistrationStatus(
								getRegistrationStatus(themeDisplay, programId, traineeItem.getLrUserId()));
						traineeItem = setTraineeDetails(traineeItem, programId, examTypeId, examDefinitionId, user);
						traineeItems.add(traineeItem);
					}

				}
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return traineeItems;
	}

	public List<TraineeItem> getTraineeByDOBAndOmsbId(long programId, ThemeDisplay themeDisplay, long examTypeId,
			long examDefinitionId, String dateOfBirth, long oMSBId) {
		List<TraineeItem> traineeItems = new ArrayList<>();
		try {
			String url = themeDisplay.getPortalURL() + LRObjectURL.REG_USER_METADATA_URL + CommonConstants.SCOPES
					+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=programId"
					+ URLEncoder.encode(" eq " + programId + " and lrUserId eq " + oMSBId, StandardCharsets.UTF_8);
			String response = commonApi.getData(url);
			logger.info("response for trainee:" + response);
			Trainee trainees = CustomObjectMapperUtil.readValue(response, Trainee.class);
			if (Validator.isNotNull(trainees) && Validator.isNotNull(trainees.getItems())
					&& !trainees.getItems().isEmpty()) {
				for (TraineeItem traineeItem : trainees.getItems()) {
					User user = UserLocalServiceUtil.getUser(traineeItem.getLrUserId());
					List<Person> personDetail = getPersonDetail(themeDisplay, traineeItem.getLrUserId());
					if (Validator.isNotNull(personDetail) && !personDetail.isEmpty()) {
						String birthDate = commonApi
								.convertObjectDateToDDMMYYYYDate(personDetail.get(0).getDateOfBirth());
						traineeItem.setRegistrationStatus(
								getRegistrationStatus(themeDisplay, programId, traineeItem.getLrUserId()));
						if (birthDate.equalsIgnoreCase(dateOfBirth) && Validator.isNotNull(user)) {
							logger.info("birthdates are matched");
							traineeItem = setTraineeDetails(traineeItem, programId, examTypeId, examDefinitionId, user);
							traineeItems.add(traineeItem);
						}
					}
				}
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return traineeItems;
	}

	public List<TraineeItem> getTraineeByDOBAndStatus(long programId, ThemeDisplay themeDisplay, long examTypeId,
			long examDefinitionId, String dateOfBirth) {
		List<TraineeItem> traineeItems = new ArrayList<>();
		try {
			String url = themeDisplay.getPortalURL() + LRObjectURL.REG_USER_METADATA_URL + CommonConstants.SCOPES
					+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=programId"
					+ URLEncoder.encode(" eq " + programId, StandardCharsets.UTF_8);
			String response = commonApi.getData(url);
			logger.info("response for trainee:" + response);
			Trainee trainees = CustomObjectMapperUtil.readValue(response, Trainee.class);
			if (Validator.isNotNull(trainees) && Validator.isNotNull(trainees.getItems())
					&& !trainees.getItems().isEmpty()) {
				for (TraineeItem traineeItem : trainees.getItems()) {
					User user = UserLocalServiceUtil.getUser(traineeItem.getLrUserId());
					List<Person> personDetail = getPersonDetail(themeDisplay, traineeItem.getLrUserId());
					if (Validator.isNotNull(personDetail) && !personDetail.isEmpty()) {
						String birthDate = commonApi
								.convertObjectDateToDDMMYYYYDate(personDetail.get(0).getDateOfBirth());
						if (birthDate.equalsIgnoreCase(dateOfBirth) && Validator.isNotNull(user)
								&& !getRegistrationStatus(themeDisplay, programId, traineeItem.getLrUserId())
										.equals(OMSBExamWebPortletKeys.NOT_REGISTERED)) {
							logger.info("birthdates are matched");
							traineeItem.setRegistrationStatus(
									getRegistrationStatus(themeDisplay, programId, traineeItem.getLrUserId()));
							traineeItem = setTraineeDetails(traineeItem, programId, examTypeId, examDefinitionId, user);
							traineeItems.add(traineeItem);
						}
					}
				}
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return traineeItems;
	}

	public List<TraineeItem> getTraineeByDOBAndStatusNonReg(long programId, ThemeDisplay themeDisplay, long examTypeId,
			long examDefinitionId, String dateOfBirth) {
		List<TraineeItem> traineeItems = new ArrayList<>();
		try {
			String url = themeDisplay.getPortalURL() + LRObjectURL.REG_USER_METADATA_URL + CommonConstants.SCOPES
					+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=programId"
					+ URLEncoder.encode(" eq " + programId, StandardCharsets.UTF_8);
			String response = commonApi.getData(url);
			logger.info("response for trainee:" + response);
			Trainee trainees = CustomObjectMapperUtil.readValue(response, Trainee.class);
			if (Validator.isNotNull(trainees) && Validator.isNotNull(trainees.getItems())
					&& !trainees.getItems().isEmpty()) {
				for (TraineeItem traineeItem : trainees.getItems()) {
					User user = UserLocalServiceUtil.getUser(traineeItem.getLrUserId());
					List<Person> personDetail = getPersonDetail(themeDisplay, traineeItem.getLrUserId());
					if (Validator.isNotNull(personDetail) && !personDetail.isEmpty()) {
						String birthDate = commonApi
								.convertObjectDateToDDMMYYYYDate(personDetail.get(0).getDateOfBirth());
						if (birthDate.equalsIgnoreCase(dateOfBirth) && Validator.isNotNull(user)
								&& getRegistrationStatus(themeDisplay, programId, traineeItem.getLrUserId())
										.equals(OMSBExamWebPortletKeys.NOT_REGISTERED)) {
							logger.info("birthdates are matched");
							traineeItem.setRegistrationStatus(
									getRegistrationStatus(themeDisplay, programId, traineeItem.getLrUserId()));
							traineeItem = setTraineeDetails(traineeItem, programId, examTypeId, examDefinitionId, user);
							traineeItems.add(traineeItem);
						}
					}
				}
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return traineeItems;
	}

	public List<TraineeItem> getTraineeByDOBndStatusAndoMSBIdReg(ThemeDisplay themeDisplay, String dateOfBirth,
			long programId, long examTypeId, long examDefinitionId, long oMSBId) {
		logger.info("getTraineeByName() started");
		List<TraineeItem> traineeItems = new ArrayList<>();
		try {
			String url = themeDisplay.getPortalURL() + LRObjectURL.REG_USER_METADATA_URL + CommonConstants.SCOPES
					+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=programId"
					+ URLEncoder.encode(" eq " + programId + " and lrUserId eq " + oMSBId, StandardCharsets.UTF_8);
			logger.info("url:" + url);
			String response = commonApi.getData(url);
			logger.info("response for trainee:" + response);
			Trainee trainees = CustomObjectMapperUtil.readValue(response, Trainee.class);
			for (TraineeItem trainee : trainees.getItems()) {
				User user = UserLocalServiceUtil.getUser(trainee.getLrUserId());
				List<Person> personDetail = getPersonDetail(themeDisplay, trainee.getLrUserId());
				if (Validator.isNotNull(personDetail) && !personDetail.isEmpty()) {
					String birthDate = commonApi.convertObjectDateToDDMMYYYYDate(personDetail.get(0).getDateOfBirth());
					if (birthDate.equalsIgnoreCase(dateOfBirth) && Validator.isNotNull(trainee.getLrUserId())
							&& !getRegistrationStatus(themeDisplay, programId, trainee.getLrUserId())
									.equals(OMSBExamWebPortletKeys.NOT_REGISTERED)) {

						trainee.setRegistrationStatus(
								getRegistrationStatus(themeDisplay, programId, trainee.getLrUserId()));
						trainee = setTraineeDetails(trainee, programId, examTypeId, examDefinitionId, user);
						traineeItems.add(trainee);
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.info("getTraineeByName() ended");
		return traineeItems;
	}

	public List<TraineeItem> getTraineeByDOBAndStatusAndoMSBIdNONReg(ThemeDisplay themeDisplay, String dateOfBirth,
			long programId, long examTypeId, long examDefinitionId, long oMSBId) {
		logger.info("getTraineeByName() started");
		List<TraineeItem> traineeItems = new ArrayList<>();
		try {
			String url = themeDisplay.getPortalURL() + LRObjectURL.REG_USER_METADATA_URL + CommonConstants.SCOPES
					+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=programId"
					+ URLEncoder.encode(" eq " + programId + " and lrUserId eq " + oMSBId, StandardCharsets.UTF_8);
			logger.info("url:" + url);
			String response = commonApi.getData(url);
			logger.info("response for trainee:" + response);
			Trainee trainees = CustomObjectMapperUtil.readValue(response, Trainee.class);
			for (TraineeItem trainee : trainees.getItems()) {
				User user = UserLocalServiceUtil.getUser(trainee.getLrUserId());
				List<Person> personDetail = getPersonDetail(themeDisplay, trainee.getLrUserId());
				if (Validator.isNotNull(personDetail) && !personDetail.isEmpty()) {
					String birthDate = commonApi.convertObjectDateToDDMMYYYYDate(personDetail.get(0).getDateOfBirth());
					if (birthDate.equalsIgnoreCase(dateOfBirth) && Validator.isNotNull(trainee.getLrUserId())
							&& getRegistrationStatus(themeDisplay, programId, trainee.getLrUserId())
									.equals(OMSBExamWebPortletKeys.NOT_REGISTERED)) {

						trainee.setRegistrationStatus(
								getRegistrationStatus(themeDisplay, programId, trainee.getLrUserId()));
						trainee = setTraineeDetails(trainee, programId, examTypeId, examDefinitionId, user);
						traineeItems.add(trainee);
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.info("getTraineeByName() ended");
		return traineeItems;
	}

	public List<TraineeItem> getTraineeByAll(ThemeDisplay themeDisplay, String traineeName, long programId,
			long examTypeId, long examDefinitionId, long oMSBId, String dateOfBirth) {
		logger.info("getTraineeByName() started");
		List<TraineeItem> traineeItems = new ArrayList<>();
		try {
			List<User> users = getUsersByName(traineeName, traineeName);
			if (Validator.isNotNull(users) && !users.isEmpty()) {
				for (User user : users) {
					logger.info("user id:" + user.getUserId());
					TraineeItem traineeItem = new TraineeItem();
					String url = themeDisplay.getPortalURL() + LRObjectURL.REG_USER_METADATA_URL
							+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId()
							+ StringPool.QUESTION + "filter=programId" + URLEncoder
									.encode(" eq " + programId + " and lrUserId eq " + oMSBId, StandardCharsets.UTF_8);
					logger.info("url:" + url);
					String response = commonApi.getData(url);
					logger.info("response for trainee:" + response);
					Trainee trainees = CustomObjectMapperUtil.readValue(response, Trainee.class);
					for (TraineeItem trainee : trainees.getItems()) {
						List<Person> personDetail = getPersonDetail(themeDisplay, trainee.getLrUserId());
						if (Validator.isNotNull(personDetail) && !personDetail.isEmpty()) {
							String birthDate = commonApi
									.convertObjectDateToDDMMYYYYDate(personDetail.get(0).getDateOfBirth());
							if (birthDate.equalsIgnoreCase(dateOfBirth)
									&& !getRegistrationStatus(themeDisplay, programId, trainee.getLrUserId())
											.equals(OMSBExamWebPortletKeys.NOT_REGISTERED)) {
								traineeItem.setRegistrationStatus(
										getRegistrationStatus(themeDisplay, programId, trainee.getLrUserId()));
								traineeItem = setTraineeDetails(traineeItem, programId, examTypeId, examDefinitionId,
										user);
								traineeItems.add(traineeItem);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.info("getTraineeByName() ended");
		return traineeItems;
	}

	public List<TraineeItem> getTraineeByAllNonReg(ThemeDisplay themeDisplay, String traineeName, long programId,
			long examTypeId, long examDefinitionId, long oMSBId, String dateOfBirth) {
		logger.info("getTraineeByName() started");
		List<TraineeItem> traineeItems = new ArrayList<>();
		try {
			List<User> users = getUsersByName(traineeName, traineeName);
			if (Validator.isNotNull(users) && !users.isEmpty()) {
				for (User user : users) {
					logger.info("user id:" + user.getUserId());
					TraineeItem traineeItem = new TraineeItem();
					String url = themeDisplay.getPortalURL() + LRObjectURL.REG_USER_METADATA_URL
							+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId()
							+ StringPool.QUESTION + "filter=programId" + URLEncoder
									.encode(" eq " + programId + " and lrUserId eq " + oMSBId, StandardCharsets.UTF_8);
					logger.info("url:" + url);
					String response = commonApi.getData(url);
					logger.info("response for trainee:" + response);
					Trainee trainees = CustomObjectMapperUtil.readValue(response, Trainee.class);
					for (TraineeItem trainee : trainees.getItems()) {
						List<Person> personDetail = getPersonDetail(themeDisplay, trainee.getLrUserId());
						String birthDate = commonApi
								.convertObjectDateToDDMMYYYYDate(personDetail.get(0).getDateOfBirth());
						if (Validator.isNotNull(personDetail) && !personDetail.isEmpty()
								&& birthDate.equalsIgnoreCase(dateOfBirth)
								&& getRegistrationStatus(themeDisplay, programId, trainee.getLrUserId())
										.equals(OMSBExamWebPortletKeys.NOT_REGISTERED)
								&& (birthDate.equalsIgnoreCase(dateOfBirth)
										&& Validator.isNotNull(trainee.getLrUserId())
										&& getRegistrationStatus(themeDisplay, programId, trainee.getLrUserId())
												.equals(OMSBExamWebPortletKeys.NOT_REGISTERED))) {
							traineeItem.setRegistrationStatus(
									getRegistrationStatus(themeDisplay, programId, trainee.getLrUserId()));
							traineeItem = setTraineeDetails(traineeItem, programId, examTypeId, examDefinitionId, user);
							traineeItems.add(traineeItem);

						}
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.info("getTraineeByName() ended");
		return traineeItems;
	}

	public List<ExamSchedule> getExamScheduleDataList(String portalUrl, long groupId) {

		String examScheduleURL = portalUrl + LRObjectURL.EXAM_SCHEDULE_URL + CommonConstants.SCOPES + StringPool.SLASH
				+ groupId + StringPool.QUESTION +"&pageSize=0";
		logger.info(examScheduleURL);
		String examScheduleResponse = httpConnector.executeGet(examScheduleURL, "",
				commonApi.getHttpHeaderInfoAndBasicAuth());
		logger.info(examScheduleURL);
		ExamScheduleItem examSchedules = CustomObjectMapperUtil.readValue(examScheduleResponse, ExamScheduleItem.class);
		logger.info(examSchedules.getItems().size());
		return examSchedules.getItems();
	}

	public void updateExamScheduleStatus(String portalUrl, long companyId, ExamSchedule examSchedule) {
		// TODO Auto-generated method stub
		ListTypeEntry listTypeEntry = commonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.PL_EXAM_STATUS,
				"completed", companyId);
		logger.info("listTypeEntry id"+ listTypeEntry.getListTypeEntryId());
		examSchedule.setExamStatus("Completed");
		String examResultResponse = CustomObjectMapperUtil.writeValueAsString(examSchedule, null);
		logger.debug(examResultResponse);
		Map<String, String> headers = commonApi.getHttpHeaderInfoAndBasicAuth();
		logger.info((portalUrl + LRObjectURL.EXAM_SCHEDULE_URL + examSchedule.getId()));
		String executePut = httpConnector.executePut((portalUrl + LRObjectURL.EXAM_SCHEDULE_URL + examSchedule.getId()),
				examResultResponse, headers);
		logger.info(executePut);

	}

//  exam schedular code 
	public void examScheduleSchedular(String portalURL, long groupId, long comaplyId, Locale locale) {

		String examDate = getTommorowsdate();
		logger.info("EXAM DATE ...  ...." + examDate);

		String date = getYesterdaysdate();
		logger.info("EXAM DATE ...  ...." + date);

		ExamSchedule scheduleItems = getOCTExamScheduleByYesterdaysDate(portalURL, groupId, date);
		logger.info("OCTExamScheduleItems ..... " + scheduleItems.getId());

		if (scheduleItems.getId() > 0) {
			examStatusCompleted(scheduleItems, date, portalURL, groupId, comaplyId);
		}

		ExamSchedule examScheduleItems = getOCTExamScheduleByExamDate(portalURL, groupId, examDate);

		if (Validator.isNotNull(examScheduleItems)) {

			logger.info("ID ID ID ... " + examScheduleItems.getId());
			RegistrationItem examRegistrationItems = getExamRegistrationByScheduleId(portalURL, groupId,
					examScheduleItems.getId());

			for (int i = 0; i < examRegistrationItems.getItems().size(); i++) {
				logger.info("STATUS ... " + examRegistrationItems.getItems().get(i).getRegistrationStatus());

				if (examRegistrationItems.getItems().get(i).getRegistrationStatus().equalsIgnoreCase("registered")) {

					JSONObject object = JSONFactoryUtil.createJSONObject();
					String payload = OCTRegistrationNotificationConfigurationAction
							.getScheduleExamNotificationTemplate();
					String subjectPayload = OCTRegistrationNotificationConfigurationAction
							.getScheduleExamNotificationSubject();

					User user;
					try {
						user = UserLocalServiceUtil.getUser(examRegistrationItems.getItems().get(i).getLrUserId());
						logger.info("ExamNotificationTemplate payload" + payload);

						if (Validator.isNotNull(subjectPayload) && Validator.isNotNull(payload)) {

//							payload = payload.replace("[Exam Title]", omsbCommonApi.getListTypeEntryNameBylistTypeEntryId(
//									getOCtExamDefinitionbyDefinitionId(portalURL, groupId, 
//									examScheduleItems.getItems().get(0).getOctExamDefinitionId()), locale));

							payload = payload.replace("[Exam Date]", examDate);
							payload = payload.replace("[Full Name]", user.getFullName());
							payload = payload.replace("[Exam Time]", examScheduleItems.getStartTime());
							String time = examScheduleItems.getStartTime();

							LocalTime originalTime = LocalTime.parse(time);
							LocalTime modifiedTime = originalTime.minusHours(1);
							payload = payload.replace("[Entry Time]", modifiedTime.toString());
						}
						object.put(OmsbTmsCommonConstants.NOTIFICATION_TEXT, payload);

						userNotificationEventLocalService.sendUserNotificationEvents(
								examRegistrationItems.getItems().get(i).getLrUserId(),
								OMSBExamWebPortletKeys.OMSBEXAMWEB, UserNotificationDeliveryConstants.TYPE_WEBSITE,
								object);

						omsbCommonApi.sendEmailNotification(MVCCommands.SENDER_EMAIL, user.getEmailAddress(),
								subjectPayload, payload);

					} catch (Exception e) {
						logger.error(e.getMessage());
					}
				}
			}
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

	public ExamSchedule getOCTExamScheduleByExamDate(String portalURL, Long groupId, String examDate) {

		String examScheduleURL = portalURL + LRObjectURL.EXAM_SCHEDULE_URL + CommonConstants.SCOPES + StringPool.SLASH
				+ groupId + StringPool.QUESTION + "filter=examDate"
				+ URLEncoder.encode(" eq " + examDate, StandardCharsets.UTF_8);
		String examScheduleResponse = commonApi.getData(examScheduleURL);

		logger.info("Exam Schedule Response ...." + examScheduleResponse);

		if (Validator.isNotNull(examScheduleResponse)) {

			ExamScheduleItem examScheduleItem = CustomObjectMapperUtil.readValue(examScheduleResponse,
					ExamScheduleItem.class);

			if (Validator.isNotNull(examScheduleItem) && examScheduleItem.getItems().size() > 0) {
				ExamSchedule examSchedule = new ExamSchedule();

				examSchedule.setId(examScheduleItem.getItems().get(0).getId());
				examSchedule.setExamDate(examScheduleItem.getItems().get(0).getExamDate());
				examSchedule.setStartTime(examScheduleItem.getItems().get(0).getStartTime());
				examSchedule.setEndTime(examScheduleItem.getItems().get(0).getEndTime());

				return examSchedule;

			} else {

				String examMultidatesURL = portalURL + LRObjectURL.EXAM_MULTIDATES_URL + CommonConstants.SCOPES
						+ StringPool.SLASH + groupId + StringPool.QUESTION + "filter=examDate"
						+ URLEncoder.encode(" eq " + examDate, StandardCharsets.UTF_8);
				String examMultidatesResponse = commonApi.getData(examMultidatesURL);

				if (Validator.isNotNull(examMultidatesResponse)) {

					ExamMultiDatesItem examMultiDatesItem = CustomObjectMapperUtil.readValue(examMultidatesResponse,
							ExamMultiDatesItem.class);
					ExamSchedule examSchedule = new ExamSchedule();

					examSchedule.setId(examMultiDatesItem.getItems().get(0).getExamScheduleId());
					examSchedule.setExamDate(examMultiDatesItem.getItems().get(0).getExamDate());
					examSchedule.setStartTime(examMultiDatesItem.getItems().get(0).getStartTime());
					examSchedule.setEndTime(examMultiDatesItem.getItems().get(0).getEndTime());

					return examSchedule;
				}
			}
		}
		return null;
	}

	public RegistrationItem getExamRegistrationByScheduleId(String portalURL, long groupId, long ocExamScheduleId) {

		String examRegistrationURL = portalURL + LRObjectURL.EXAM_REGISTERATION_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + groupId + StringPool.QUESTION + "filter=examScheduleId"
				+ URLEncoder.encode(" eq " + ocExamScheduleId, StandardCharsets.UTF_8);
		String examRegistrationResponse = commonApi.getData(examRegistrationURL);

		if (Validator.isNotNull(examRegistrationResponse)) {
			return CustomObjectMapperUtil.readValue(examRegistrationResponse, RegistrationItem.class);
		}
		return null;
	}

	public ExamSchedule getOCTExamScheduleByYesterdaysDate(String portalURL, Long groupId, String examDate) {

		String examScheduleURL = portalURL + LRObjectURL.EXAM_SCHEDULE_URL + CommonConstants.SCOPES + StringPool.SLASH
				+ groupId + StringPool.QUESTION + "filter=examDate"
				+ URLEncoder.encode(" eq " + examDate, StandardCharsets.UTF_8);
		String examScheduleResponse = commonApi.getData(examScheduleURL);

		if (Validator.isNotNull(examScheduleResponse)) {

			ExamScheduleItem examScheduleItem = CustomObjectMapperUtil.readValue(examScheduleResponse,
					ExamScheduleItem.class);

			if (Validator.isNotNull(examScheduleItem) && examScheduleItem.getItems().size() > 0) {
				ExamSchedule examSchedule = new ExamSchedule();

				examSchedule.setId(examScheduleItem.getItems().get(0).getId());
				examSchedule.setExamDate(examScheduleItem.getItems().get(0).getExamDate());
				examSchedule.setStartTime(examScheduleItem.getItems().get(0).getStartTime());
				examSchedule.setEndTime(examScheduleItem.getItems().get(0).getEndTime());
				examSchedule.setNoOfSeats(examScheduleItem.getItems().get(0).getNoOfSeats());
				examSchedule.setExamDefinitionId(examScheduleItem.getItems().get(0).getExamDefinitionId());
				examSchedule.setMultiDates(examScheduleItem.getItems().get(0).isMultiDates());
				examSchedule.setApplicationStartDate(examScheduleItem.getItems().get(0).getApplicationStartDate());
				examSchedule.setApplicationEndDate(examScheduleItem.getItems().get(0).getApplicationEndDate());

				return examSchedule;

			} else {

				String examMultidatesURL = portalURL + LRObjectURL.EXAM_MULTIDATES_URL + CommonConstants.SCOPES
						+ StringPool.SLASH + groupId + StringPool.QUESTION + "filter=examDate"
						+ URLEncoder.encode(" eq " + examDate, StandardCharsets.UTF_8);
				String examMultidatesResponse = commonApi.getData(examMultidatesURL);

				if (Validator.isNotNull(examMultidatesResponse)) {

					ExamMultiDatesItem examMultiDatesItem = CustomObjectMapperUtil.readValue(examMultidatesResponse,
							ExamMultiDatesItem.class);
					ExamSchedule examSchedule = new ExamSchedule();

					ExamScheduleItem scheduleItem = getExamScheduleByScheduleId(portalURL, groupId,
							examMultiDatesItem.getItems().get(0).getExamScheduleId());

					examSchedule.setId(examMultiDatesItem.getItems().get(0).getExamScheduleId());
					examSchedule.setExamDate(examMultiDatesItem.getItems().get(0).getExamDate());
					examSchedule.setStartTime(examMultiDatesItem.getItems().get(0).getStartTime());
					examSchedule.setEndTime(examMultiDatesItem.getItems().get(0).getEndTime());

					examSchedule.setMultiDates(scheduleItem.getItems().get(0).isMultiDates());
					examSchedule.setApplicationStartDate(scheduleItem.getItems().get(0).getApplicationStartDate());
					examSchedule.setApplicationEndDate(scheduleItem.getItems().get(0).getApplicationEndDate());
					examSchedule.setExamDefinitionId(scheduleItem.getItems().get(0).getExamDefinitionId());
					examSchedule.setNoOfSeats(scheduleItem.getItems().get(0).getNoOfSeats());
					examSchedule.setExamStatus(scheduleItem.getItems().get(0).getExamStatus());

					return examSchedule;

				}
			}
		}
		return null;
	}

	public ExamScheduleItem getExamScheduleByScheduleId(String portalURL, long groupId, long examScheduleId) {

		String examScheduleURL = portalURL + LRObjectURL.EXAM_SCHEDULE_URL + CommonConstants.SCOPES + StringPool.SLASH
				+ groupId + StringPool.QUESTION + "filter=id"
				+ URLEncoder.encode(" eq " + "'" + examScheduleId + "'", StandardCharsets.UTF_8);
		String examScheduleResponse = commonApi.getData(examScheduleURL);

		if (Validator.isNotNull(examScheduleResponse)) {

			ExamScheduleItem examScheduleItem = CustomObjectMapperUtil.readValue(examScheduleResponse,
					ExamScheduleItem.class);
			if (examScheduleItem.getItems().size() > 0) {

				return examScheduleItem;
			}

		}
		return null;
	}

	public void examStatusCompleted(ExamSchedule examScheduleItem, String date, String portalURL, long groupId,
			long comapnyId) {

		ExamSchedule examSchedule = new ExamSchedule();
		if (examScheduleItem.isMultiDates()) {

			examSchedule.setId(examScheduleItem.getId());
			examSchedule.setApplicationStartDate(examScheduleItem.getApplicationStartDate());
			examSchedule.setApplicationEndDate(examScheduleItem.getApplicationEndDate());
			examSchedule.setExamDefinitionId(examScheduleItem.getExamDefinitionId());
			examSchedule.setNoOfSeats(examScheduleItem.getNoOfSeats());
			examSchedule.setExamStatus("Completed");
			examSchedule.setMultiDates(examScheduleItem.isMultiDates());

			String examScheduleUrl = portalURL + LRObjectURL.EXAM_SCHEDULE_URL + examSchedule.getId();
			String scheduleMapper = CustomObjectMapperUtil.writeValueAsString(examSchedule, null);
			httpConnector.executePut(examScheduleUrl, scheduleMapper, omsbCommonApi.getHttpHeaderInfoAndBasicAuth());

		} else if (!examScheduleItem.isMultiDates()) {

			examSchedule.setId(examScheduleItem.getId());
			examSchedule.setExamDate(examScheduleItem.getExamDate());
			examSchedule.setEndTime(examScheduleItem.getEndTime());
			examSchedule.setExamStatus("Completed");
			examSchedule.setStartTime(examScheduleItem.getStartTime());
			examSchedule.setLocationOnGoogleMap(examScheduleItem.getLocationOnGoogleMap());
			examSchedule.setNoOfSeats(examScheduleItem.getNoOfSeats());
			examSchedule.setExamDefinitionId(examScheduleItem.getExamDefinitionId());
			examSchedule.setApplicationStartDate(examScheduleItem.getApplicationStartDate());
			examSchedule.setApplicationEndDate(examScheduleItem.getApplicationEndDate());
			examSchedule.setVenue(examScheduleItem.getVenue());
			examSchedule.setMultiDates(examScheduleItem.isMultiDates());

			String examScheduleUrl = portalURL + LRObjectURL.EXAM_SCHEDULE_URL + examSchedule.getId();
			String scheduleMapper = CustomObjectMapperUtil.writeValueAsString(examSchedule, null);
			httpConnector.executePut(examScheduleUrl, scheduleMapper, omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
		}

	}

	public ExamPayment getExamPaymentByOrderId(String orderId, String portalURL, long scopeGroupId) {
		String examPaymentURL = portalURL + LRObjectURL.EXAM_PAYMENTS_URL + CommonConstants.SCOPES + StringPool.SLASH
				+ scopeGroupId + StringPool.QUESTION + "filter=orderId" + URLEncoder.encode(
						" eq " + StringPool.APOSTROPHE + orderId + StringPool.APOSTROPHE, StandardCharsets.UTF_8);
		String examPaymentResponse = omsbCommonApi.getData(examPaymentURL);
		if (Validator.isNotNull(examPaymentResponse)) {
			ExamPaymentItems examPaymentItems = CustomObjectMapperUtil.readValue(examPaymentResponse,
					ExamPaymentItems.class);
			if (Validator.isNotNull(examPaymentItems) && examPaymentItems.getItems().size() > 0) {
				return examPaymentItems.getItems().get(0);
			}
		}
		return null;
	}

	public String saveExamPayment(ExamPayment examPayment, String portalURL, long scopeGroupId) {
		String examPaymentUrl = portalURL + LRObjectURL.EXAM_PAYMENTS_URL + CommonConstants.SCOPES + StringPool.SLASH
				+ scopeGroupId;
		String scheduleMapper = CustomObjectMapperUtil.writeValueAsString(examPayment, null);
		String examPaymentresponse = httpConnector.executePost(examPaymentUrl, scheduleMapper,
				omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
		return examPaymentresponse;
	}

	public String updateExamPayment(ExamPayment examPayment, String portalURL, long scopeGroupId) {
		String examPaymentUrl = portalURL + LRObjectURL.EXAM_PAYMENTS_URL + examPayment.getId();
		String scheduleMapper = CustomObjectMapperUtil.writeValueAsString(examPayment, null);
		String examPaymentresponse = httpConnector.executePut(examPaymentUrl, scheduleMapper,
				omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
		return examPaymentresponse;
	}

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	public ExamSchedule getExamScheduleById(long examScheduleId, String portalURL) {
		String examScheduleUrl = portalURL + LRObjectURL.EXAM_SCHEDULE_URL + examScheduleId;
		logger.info("ExamScheduleUrl ::" + examScheduleUrl);
		String examScheduleResponse = httpConnector.executeGet(examScheduleUrl, StringPool.BLANK,
				commonApi.getHttpHeaderInfoAndBasicAuth());
		logger.info("ExamScheduleResponse ::" + examScheduleResponse);
		if (Validator.isNotNull(examScheduleResponse)) {
			ExamSchedule octExamSchedule = CustomObjectMapperUtil.readValue(examScheduleResponse, ExamSchedule.class);
			return octExamSchedule;
		}
		return null;
	}

	public List<WithdrawalFees> getExamWithdrawalFeesByDefinationId(long examDefinitionId, String portalURL,
			long scopeGroupId) {

		String withdrawalFeesUrl = portalURL + LRObjectURL.EXAM_WITHDRAWAL_FEES_URL + "scopes/" + scopeGroupId
				+ StringPool.QUESTION + "filter=examDefinitionId"
				+ URLEncoder.encode(" eq " + examDefinitionId, StandardCharsets.UTF_8);
		String withdrawalFeesUrlResponse = commonApi.getData(withdrawalFeesUrl);

		logger.info("octExamCancellationFeesResponse::::" + withdrawalFeesUrlResponse);
		logger.info("withdrawalFeesUrl::::" + withdrawalFeesUrl);
		if (Validator.isNotNull(withdrawalFeesUrlResponse)) {

			WithdrawalFeeItem withdrawalFeeItem = CustomObjectMapperUtil.readValue(withdrawalFeesUrlResponse,
					WithdrawalFeeItem.class);
			if (Validator.isNotNull(withdrawalFeeItem) && Validator.isNotNull(withdrawalFeeItem.getItems())
					&& !withdrawalFeeItem.getItems().isEmpty()) {
				return withdrawalFeeItem.getItems();
			}
		}

		return new ArrayList<>();

	}

	public List<DocumentInfo> getEducationCentificate(ThemeDisplay themeDisplay, long componentClassRefId) {
		String documentInfoUrl = themeDisplay.getPortalURL() + LRObjectURL.DOCUMENT_INFO_URL.replace("{scope-id}",
				themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=componentClassRefId"
						+ URLEncoder.encode(" eq " + componentClassRefId, StandardCharsets.UTF_8));
		String documentInfoResponse = commonApi.getData(documentInfoUrl);

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

	public List<EducationDetail> getEducationDetail(ThemeDisplay themeDisplay, long personId) {
		String personDetailUrl = themeDisplay.getPortalURL() + LRObjectURL.EDUCATION_DETAIL_URL.replace("{scope-id}",
				themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=personId"
						+ URLEncoder.encode(" eq " + personId, StandardCharsets.UTF_8));
		String personDetailResponse = commonApi.getData(personDetailUrl);
		logger.info("personDetailResponse::::" + personDetailResponse);
		EducationDetailItem educationDetailItem = CustomObjectMapperUtil.readValue(personDetailResponse,
				EducationDetailItem.class, new SimpleDateFormat(DataflowConstants.OBJECT_DATE_FORMAT));
		if (Validator.isNotNull(educationDetailItem) && Validator.isNotNull(educationDetailItem.getItems())
				&& !educationDetailItem.getItems().isEmpty()) {
			return educationDetailItem.getItems();
		}
		return new ArrayList<>();
	}

	public ExamDefinition getExamDefinitionByDefinitionId(long examDefinitionId, String portalURL) {
		try {
			String octExamDefinitionUrl = portalURL + LRObjectURL.EXAM_DEFINITION_URL + examDefinitionId;
			String octExamDefinitionResponse = httpConnector.executeGet(octExamDefinitionUrl, StringPool.BLANK,
					commonApi.getHttpHeaderInfoAndBasicAuth());
			if (Validator.isNotNull(octExamDefinitionResponse)) {
				ExamDefinition octExamDefinition = CustomObjectMapperUtil.readValue(octExamDefinitionResponse,
						ExamDefinition.class);
				return octExamDefinition;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	public RegularFees getRegularFeesByDefinitionId(long examDefinitionId, ThemeDisplay themeDisplay,
			long noOfAttempt) {
		try {

			String regularFeesURL = themeDisplay.getPortalURL() + LRObjectURL.EXAM_REGULAR_FEES_URL
					+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION
					+ "filter=examDefinitionId" + URLEncoder.encode(" eq " + examDefinitionId, StandardCharsets.UTF_8)
					+ "&sort=noOfAttempts:desc";
			;
			logger.info("regularFeesURL::::" + regularFeesURL);
			String regularFeesResponse = commonApi.getData(regularFeesURL);
			logger.debug("regularFeesResponse::::" + regularFeesResponse);
			RegularFeeItem regularFeesItem = CustomObjectMapperUtil.readValue(regularFeesResponse,
					RegularFeeItem.class);
			if (Validator.isNotNull(regularFeesItem) && Validator.isNotNull(regularFeesItem.getItems())
					&& !regularFeesItem.getItems().isEmpty()) {
				List<RegularFees> octRegularFeesList = regularFeesItem.getItems();
				Optional<RegularFees> regularFees = octRegularFeesList.stream()
						.filter(OCTRegularFee -> OCTRegularFee.getNoOfAttempts() <= noOfAttempt + 1).findFirst();
				if (regularFees.isPresent()) {
					regularFees.get();
				}
				return null;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	public String getExamTypeNameByExamTypeId(ThemeDisplay themeDisplay, long examTypeId) {
		logger.info("getExamByProgramtype() started ");
		try {
			String examTypeurl = themeDisplay.getPortalURL() + LRObjectURL.EXAM_TYPE_URL + CommonConstants.SCOPES
					+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=id"
					+ URLEncoder.encode(" eq " + "'" + examTypeId + "'", StandardCharsets.UTF_8);
			String examTypeResponse = commonApi.getData(examTypeurl);
			logger.info("examTypeResponse" + examTypeResponse);
			if (examTypeResponse.contains("examType")) {
				ExamTypeItem examTypeItems = CustomObjectMapperUtil.readValue(examTypeResponse, ExamTypeItem.class);
				if (Validator.isNotNull(examTypeItems) && Validator.isNotNull(examTypeItems.getItems())
						&& !examTypeItems.getItems().isEmpty()) {
					return examTypeItems.getItems().get(0).getExamType();
				}
			}
		} catch (Exception e) {
			logger.error("error while fetching exams ::" + e.getMessage(), e);
		}
		logger.info("getExamByProgramtype() ended ");
		return "";
	}

	/**
	 * @param examAnnouncedDate
	 * @return the Difference between given date and today date.
	 */
	public int getDateDifferenceWithCurrentDate(String examAnnouncedDate) {
		int daysDiffernce = 0;
		try {
			if (Validator.isNotNull(examAnnouncedDate)) {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DataflowConstants.OBJECT_DATE_FORMAT,
						Locale.ENGLISH);
				LocalDate examDate = LocalDate.parse(examAnnouncedDate, formatter);

				LocalDate todatDate = LocalDate.now();

				daysDiffernce = (int) ChronoUnit.DAYS.between(examDate, todatDate);

			}
		} catch (Exception e) {
			if (logger.isDebugEnabled()) {
				daysDiffernce = 0;
				logger.debug(
						"Exception while calculating the diffecrence in date in getDateDifferenceWithCurrentDate :: ExamUtill :: "
								+ e);
			}
		}

		return daysDiffernce;
	}

	/**
	 * @param themeDisplay
	 * @param examResult
	 * @return the string having output from updating the Exam Result
	 */
	public String updateExamResultObject(ThemeDisplay themeDisplay, ExamResultItem examResult) {
		String response = StringPool.BLANK;
		try {
			String examResultMapper = CustomObjectMapperUtil.writeValueAsString(examResult, null);
			Map<String, String> headers = commonApi.getHttpHeaderInfoAndBasicAuth();
			response = httpConnector.executePut(
					themeDisplay.getPortalURL() + LRObjectURL.EXAM_RESULT_URL + examResult.getId(), examResultMapper,
					headers);
		} catch (Exception e) {
			if (logger.isDebugEnabled()) {
				logger.debug(
						"Exception while updating  the Exam Result Object updateExamResultObject :: ExamUtill :: " + e);
			}

		}
		return response;
	}

	public float calculateExamFee(ThemeDisplay themeDisplay, ExamSchedule examSchedule) {
		float examFee = 0;
		if (Validator.isNotNull(examSchedule)) {
			ExamDefinition examDefinition = getExamDefinitionByDefinitionId(examSchedule.getExamDefinitionId(),
					themeDisplay.getPortalURL());

			if (Validator.isNotNull(examDefinition)) {
				float regFee = 0;
				RegularFees regularFees = getRegularFeesByDefinitionId(examDefinition.getId(), themeDisplay,
						examSchedule.getNoOfAttempts());

				if (Validator.isNotNull(regularFees)) {
					regFee = regularFees.getRegularFee();
				}
				logger.info("regFee fee::" + regFee);
				if (Validator.isNotNull(examDefinition.getEarlyBirdFeesDate())) {
					String applicationStartDate = examSchedule.getApplicationStartDate();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DataflowConstants.OBJECT_DATE_FORMAT,
							themeDisplay.getLocale());
					LocalDateTime date = LocalDateTime.parse(applicationStartDate, formatter);
					LocalDate todayDate = LocalDate.now();
					long noOfDays = ChronoUnit.DAYS.between(todayDate, date);

					int earlyBirdFeesDays = examDefinition.getEarlyBirdFeesDate();
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

	public ExamPayment getExamPaymentByUserIdAndScheduleId(ThemeDisplay themeDisplay, long lrUserId,
			long examScheduleId) {

		String paymentUrl = themeDisplay.getPortalURL() + LRObjectURL.EXAM_PAYMENTS_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=applicantId"
				+ URLEncoder.encode(" eq " + lrUserId + " and scheduleId eq " + examScheduleId, StandardCharsets.UTF_8)
				+ "&sort=dateCreated:desc";
		String paymentResponse = commonApi.getData(paymentUrl);
		ExamPaymentItems examPaymentItems = CustomObjectMapperUtil.readValue(paymentResponse, ExamPaymentItems.class);

		if (Validator.isNotNull(examPaymentItems) && examPaymentItems.getItems().size() > 0) {
			return examPaymentItems.getItems().get(0);
		} else {
			return null;
		}

	}

	public String getUserMobileNumber(ThemeDisplay themeDisplay, long userId) {

		try {
			String personalDetailsUrl = themeDisplay.getPortalURL() + LRObjectURL.PERSONAL_DETAILS
					+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION
					+ "filter=lrUserId" + URLEncoder.encode(" eq " + userId, DataflowConstants.UTF_8);

			String personalDetailsResponse = commonApi.getData(personalDetailsUrl);

			if (Validator.isNotNull(personalDetailsResponse)) {

				PersonalDetailItem personalDetailItem = CustomObjectMapperUtil.readValue(personalDetailsResponse,
						PersonalDetailItem.class);

				if (Validator.isNotNull(personalDetailItem) && Validator.isNotNull(personalDetailItem.getItems())
						&& personalDetailItem.getItems().size() > 0) {

					return personalDetailItem.getItems().get(0).getMobileNumber();
				}
			}

		} catch (UnsupportedEncodingException e) {
			logger.error(e);
		}

		return null;
	}

	public PersonalDetailItem getPersonalDetailsByUserId(ThemeDisplay themeDisplay, long userId) {

		try {
			String personalDetailsUrl = themeDisplay.getPortalURL() + LRObjectURL.PERSONAL_DETAILS
					+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION
					+ "filter=lrUserId" + URLEncoder.encode(" eq " + userId, DataflowConstants.UTF_8);

			String personalDetailsResponse = commonApi.getData(personalDetailsUrl);
			logger.info("personalDetailsUrl" + personalDetailsUrl);
			logger.info("personalDetailsResponse" + personalDetailsResponse);
			if (Validator.isNotNull(personalDetailsResponse)) {

				PersonalDetailItem personalDetailItem = CustomObjectMapperUtil.readValue(personalDetailsResponse,
						PersonalDetailItem.class);

				if (Validator.isNotNull(personalDetailItem) && Validator.isNotNull(personalDetailItem.getItems())
						&& personalDetailItem.getItems().size() > 0) {

					return personalDetailItem;
				}
			}

		} catch (UnsupportedEncodingException e) {
			logger.error(e);
		}

		return null;
	}

	public RegistrationItem getExamRegistrationByUserId(ThemeDisplay themeDisplay, long userId) {

		try {
			String examRegistrationUrl = themeDisplay.getPortalURL() + LRObjectURL.EXAM_REGISTERATION_URL
					+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION
					+ "filter=lrUserId" + URLEncoder.encode(" eq " + userId, DataflowConstants.UTF_8);

			String examRegistrationResponse = commonApi.getData(examRegistrationUrl);

			if (Validator.isNotNull(examRegistrationResponse)) {

				RegistrationItem registrationItem = CustomObjectMapperUtil.readValue(examRegistrationResponse,
						RegistrationItem.class);

				if (Validator.isNotNull(registrationItem) && Validator.isNotNull(registrationItem.getItems())
						&& registrationItem.getItems().size() > 0) {

					return registrationItem;
				}
			}

		} catch (UnsupportedEncodingException e) {
			logger.error(e);
		}

		return null;
	}

	public PersonItem getPersonByUserId(ThemeDisplay themeDisplay, long userId) {

		try {
			String personUrl = themeDisplay.getPortalURL() + LRObjectURL.PERSON + CommonConstants.SCOPES
					+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=lrUserId"
					+ URLEncoder.encode(" eq " + userId, DataflowConstants.UTF_8);

			String personResponse = commonApi.getData(personUrl);

			if (Validator.isNotNull(personResponse)) {

				PersonItem personItem = CustomObjectMapperUtil.readValue(personResponse, PersonItem.class);

				if (Validator.isNotNull(personItem) && Validator.isNotNull(personItem.getItems())
						&& personItem.getItems().size() > 0) {

					return personItem;
				}
			}

		} catch (UnsupportedEncodingException e) {
			logger.error(e);
		}

		return null;
	}

	public String getExamTypeKey(long examTypeId, String portalURL) {
		try {
			String url = portalURL + LRObjectURL.EXAM_TYPE_URL + examTypeId;
			String response = httpConnector.executeGet(url, "", commonApi.getHttpHeaderInfoAndBasicAuth());
			logger.info("response:" + response);
			ExamType examType = CustomObjectMapperUtil.readValue(response, ExamType.class);
			if (!response.isEmpty() && Validator.isNotNull(examType) && (response.contains("examType"))) {
				logger.info("examType key:" + examType.getExamType());
				return examType.getExamType();

			}
		} catch (Exception e) {
			logger.error(e);
		}
		return "";
	}

	public int getNoOfAttempts(String portalUrl,long groupId, long examScheduleId, long userId) {
		int noOfAttempt=0;
		try {
		ExamSchedule examSchedule = getExamScheduleById(examScheduleId, portalUrl);
		List<ExamSchedule> examScheduleList=new ArrayList<>();
		
		if(Validator.isNotNull(examSchedule)) {
			
			examScheduleList = getscheduleExamListByExamTypeIdAndProgramId(portalUrl,groupId, examSchedule.getExamType(), examSchedule.getProgramId());
			logger.info("examScheduleList size "+examScheduleList.size() );
			for(ExamSchedule schedule:examScheduleList) {
				RegistrationItem reg = getRegistrationByUserIdAndScheduleId(portalUrl, groupId, userId, schedule.getId());
				if (Validator.isNotNull(reg) && Validator.isNotNull(reg.getItems()) && !(reg.getItems()).isEmpty()) {
					if(OMSBExamWebPortletKeys.REGISTERED.equalsIgnoreCase(reg.getItems().get(0).getRegistrationStatus())) {
						noOfAttempt++;
					}
					 logger.info("noOfAttempt"+ noOfAttempt);
				}
			}
		}
		
			
		} catch (Exception e) {
				logger.error(e.getMessage(), e);
			
		}
		return noOfAttempt;
	}

	public EmergencyContact getEmergancyContactDetailByLrUserId(ThemeDisplay themeDisplay, long lrUserId) {
		String emergencyContactUrl = themeDisplay.getPortalURL() + LRObjectURL.EMERGENCY_CONTACT_URL + "scopes/"
				+ themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=lrUserID"
				+ URLEncoder.encode(" eq " + lrUserId, StandardCharsets.UTF_8);
		String emergencyContactResponse = omsbCommonApi.getData(emergencyContactUrl);

		logger.info("emergencyContactURL::::" + emergencyContactUrl);
		logger.info("emergencyContactResponse::::" + emergencyContactResponse);
		if (Validator.isNotNull(emergencyContactResponse)) {

			logger.info("new EmergencyContact();" + new EmergencyContact().toString());
			EmergencyContactItem emergancyContactItem = CustomObjectMapperUtil.readValue(emergencyContactResponse,
					EmergencyContactItem.class);

			if (Validator.isNotNull(emergancyContactItem) && Validator.isNotNull(emergancyContactItem.getItems())
					&& !emergancyContactItem.getItems().isEmpty()) {
				return emergancyContactItem.getItems().get(0);
			}

		}
		return null;
	}

	public List<TraineeItem> getTraineeByNameAndEmail(String name, String email, ThemeDisplay themeDisplay,
			long examScheduleId) {
		try {
			List<TraineeItem> traineeItem = new ArrayList<>();
			List<User> userByScreenName = getUsersByName(name, name);
			for (User user : userByScreenName) {
				User userByEmailAddress = userLocalService.getUserByEmailAddress(themeDisplay.getCompanyId(), email);
				if (user.getUserId() == userByEmailAddress.getUserId()) {
					TraineeItem trainee = setUserDetails(user, themeDisplay, examScheduleId);
					traineeItem.add(trainee);
				}
			}
			return traineeItem;
		} catch (PortalException e) {
			logger.error(e.getMessage(), e);
		}
		return new ArrayList<>();

	}

	public TraineeItem setUserDetails(User user, ThemeDisplay themeDisplay, long examScheduleId) {
		try {
			TraineeItem trainee = new TraineeItem();
			trainee.setName(user.getFullName());
			trainee.setLrUserId(user.getUserId());
			RegistrationItem registration = getRegistrationByUserIdAndScheduleId(themeDisplay.getPortalURL(),themeDisplay.getScopeGroupId(), user.getUserId(),
					examScheduleId);
			if (Validator.isNotNull(registration) && Validator.isNotNull(registration.getItems())
					&& !registration.getItems().isEmpty()) {
				trainee.setRegistrationStatus(registration.getItems().get(0).getRegistrationStatus());
			}
			logger.info("trainee item:" + trainee.getName());
			return trainee;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;

	}

	public String getGenderName(List<PersonalDetail> personalDetailItem) {
		GenderMaster genderMaster = null;
		try {
			genderMaster = GenderMasterLocalServiceUtil.getGenderMaster(personalDetailItem.get(0).getGenderId());
		} catch (PortalException e) {
			logger.error(e.getMessage(), e);
		}
		if (Validator.isNotNull(genderMaster)) {
			return genderMaster.getGenderName();
		}
		return "";
	}

	public List<ExamSchedule> getScheduleExamsByDate(String portalURL, long groupId, String examDate) {

//		String examScheduleURL = portalURL + LRObjectURL.EXAM_SCHEDULE_URL + CommonConstants.SCOPES + StringPool.SLASH
//				+ groupId + StringPool.QUESTION + "filter=examDate"
//				+ URLEncoder.encode(" eq " + examDate, StandardCharsets.UTF_8);
		
		String examScheduleURL = portalURL + LRObjectURL.EXAM_SCHEDULE_URL + CommonConstants.SCOPES + StringPool.SLASH + groupId;
		
		String examScheduleResponse = commonApi.getData(examScheduleURL);
		ExamScheduleItem examScheduleItem = CustomObjectMapperUtil.readValue(examScheduleResponse,
				ExamScheduleItem.class);
		if (Validator.isNotNull(examScheduleItem) && Validator.isNotNull(examScheduleItem.getItems())) {

			for (ExamSchedule examSchedule : examScheduleItem.getItems()) {

				if(examSchedule.isMultiDates()) {
					
					String ExamMutiDateUrl = portalURL + LRObjectURL.EXAM_MULTIDATES_URL + CommonConstants.SCOPES
							+ StringPool.SLASH + groupId + StringPool.QUESTION + "filter=examScheduleAdminId"
							+ URLEncoder.encode(" eq " + examSchedule.getExamScheduleAdminId(), StandardCharsets.UTF_8)
							+ "&sort=examDate:desc";

					
					String examMultiDatesResponse = commonApi.getData(ExamMutiDateUrl);
					ExamMultiDatesItem examMultiDatesItem = CustomObjectMapperUtil.readValue(examMultiDatesResponse,
							ExamMultiDatesItem.class);
					if (Validator.isNotNull(examMultiDatesItem) && Validator.isNotNull(examMultiDatesItem.getItems())
							&& examMultiDatesItem.getItems().size() > 0) {
						ExamMultiDates examMultiDates = examMultiDatesItem.getItems().get(0);

						examSchedule.setExamDate(commonApi.convertObjectDateToDDMMYYYYDate(examMultiDates.getExamDate()));
						examSchedule.setStartTime(examMultiDates.getStartTime());
						
					}
				}
				
				
				ExamDefinition examDefinition = getExamDefinitionByDefinitionId(examSchedule.getExamDefinitionId(),
						portalURL);
				if (Validator.isNotNull(examDefinition)) {
					examSchedule.setExamTypeName(omsbCommonApi.getListTypeEntryNameBylistTypeEntryId(
							examDefinition.getExamTypeId(), Locale.getDefault()));
					examSchedule.setExamType(examDefinition.getExamTypeId());
				}
			}

			return examScheduleItem.getItems();
		}

		return new ArrayList<>();
	}

	public List<Registration> getExamRegistrationByScheduleIdAndStatus(String portalURL, long groupId,
			long examScheduleId, String status) {
		String examRegistrationURL = portalURL + LRObjectURL.EXAM_REGISTERATION_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + groupId + StringPool.QUESTION + "filter=examScheduleId" + URLEncoder.encode(
						" eq " + examScheduleId + " and registrationStatus eq '" + status+"'", StandardCharsets.UTF_8);

		String examRegistrationResponse = commonApi.getData(examRegistrationURL);
		logger.info("examRegistrationURL"+ examRegistrationURL);
		RegistrationItem registrationItem = CustomObjectMapperUtil.readValue(examRegistrationResponse,
				RegistrationItem.class);
		if (Validator.isNotNull(registrationItem) && Validator.isNotNull(registrationItem.getItems())) {
			logger.info("registrationItem size::   "+ registrationItem.getItems().size());
			return registrationItem.getItems();
		}
		return new ArrayList<>();

	}

	public ExamPayment getExamPaymentDetailByRegistrationId(String portalURL, long scopeGroupId, long registrationId) {
		String examPaymentURL = portalURL + LRObjectURL.EXAM_PAYMENTS_URL + CommonConstants.SCOPES + StringPool.SLASH
				+ scopeGroupId + StringPool.QUESTION + "filter=registrationId"
				+ URLEncoder.encode(" eq " + registrationId, StandardCharsets.UTF_8);
		logger.info("examPaymentURL" + examPaymentURL);
		String examPaymentResponse = omsbCommonApi.getData(examPaymentURL);
		logger.info("examPaymentResponse" + examPaymentResponse);
		if (Validator.isNotNull(examPaymentResponse)) {
			ExamPaymentItems examPaymentItems = CustomObjectMapperUtil.readValue(examPaymentResponse,
					ExamPaymentItems.class);
			if (Validator.isNotNull(examPaymentItems) && Validator.isNotNull(examPaymentItems.getItems())
					&& !examPaymentItems.getItems().isEmpty()) {
				return examPaymentItems.getItems().get(0);
			}
		}
		return null;
	}

	public Registration getRegistrationByProgramIdAndUserId(ThemeDisplay themeDisplay, long programId, long userId) {

		try {
			String registrationUrl = themeDisplay.getPortalURL() + LRObjectURL.EXAM_REGISTERATION_URL
					+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION
					+ "filter=programId"
					+ URLEncoder.encode(" eq " + programId + " and lrUserId eq " + userId, StandardCharsets.UTF_8);
			logger.info("registration url " + registrationUrl);
			String registrationResponse = commonApi.getData(registrationUrl);
			logger.debug("registration registrationResponse " + registrationResponse);

			RegistrationItem registration = CustomObjectMapperUtil.readValue(registrationResponse,
					RegistrationItem.class);
			if (Validator.isNotNull(registration) && Validator.isNotNull(registration.getItems())
					&& !registration.getItems().isEmpty()) {
				return registration.getItems().get(0);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
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

	public ExamWithdrawalItem getExamWithdrawalList(String portalURL, long scopeGroupId) {

		String examWithdrawalUrl = portalURL + LRObjectURL.EXAM_WITHDRAWAL_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + scopeGroupId + StringPool.QUESTION +"&pageSize=0";
		logger.info("examWithdrawalUrl..."+ examWithdrawalUrl);
		String examWithdrawalResponse = commonApi.getData(examWithdrawalUrl);
		if (Validator.isNotNull(examWithdrawalResponse)) {
			return CustomObjectMapperUtil.readValue(examWithdrawalResponse, ExamWithdrawalItem.class);

		}
		return null;
	}

	public ExamWithdrawal getExamWithdrawalByScheduleIdAndLrUserId(long examScheduleId, String portalURL,
			long scopeGroupId, long lrUserId) {

		String withdrawalUrl = portalURL + LRObjectURL.EXAM_WITHDRAWAL_URL + "scopes/" + scopeGroupId
				+ StringPool.QUESTION + "filter=examScheduleId"
				+ URLEncoder.encode(" eq " + examScheduleId + " and lrUserId eq " + lrUserId, StandardCharsets.UTF_8);
		String withdrawalUrlResponse = commonApi.getData(withdrawalUrl);

		logger.info("withdrawalUrlresponse::::" + withdrawalUrlResponse);
		logger.debug("withdrawalFeesUrl::::" + withdrawalUrl);
		if (Validator.isNotNull(withdrawalUrlResponse)) {

			ExamWithdrawalItem examWithdrawalItem = CustomObjectMapperUtil.readValue(withdrawalUrlResponse,
					ExamWithdrawalItem.class);
			if (Validator.isNotNull(examWithdrawalItem) && Validator.isNotNull(examWithdrawalItem.getItems())
					&& !examWithdrawalItem.getItems().isEmpty()) {
				return examWithdrawalItem.getItems().get(0);
			}
		}

		return null;

	}

	public ExamWithdrawalStatus getExamWithdrawalStatusByWithdrawId(long examWithdrawalId, String portalURL,
			long scopeGroupId) {

		String withdrawalStatusUrl = portalURL + LRObjectURL.EXAM_WITHDRAWAL_STATUS_URL + "scopes/" + scopeGroupId
				+ StringPool.QUESTION + "filter=examWithdrawalId"
				+ URLEncoder.encode(" eq " + examWithdrawalId, StandardCharsets.UTF_8);
		String withdrawalUrlResponse = commonApi.getData(withdrawalStatusUrl);

		logger.info("withdrawalStatusUrl::::" + withdrawalUrlResponse);
		logger.debug("withdrawalFeesUrl::::" + withdrawalStatusUrl);
		if (Validator.isNotNull(withdrawalUrlResponse)) {

			ExamWithdrawalStatusItem examWithdrawalStatusItem = CustomObjectMapperUtil.readValue(withdrawalUrlResponse,
					ExamWithdrawalStatusItem.class);
			if (Validator.isNotNull(examWithdrawalStatusItem)
					&& Validator.isNotNull(examWithdrawalStatusItem.getItems())
					&& !examWithdrawalStatusItem.getItems().isEmpty()) {
				return examWithdrawalStatusItem.getItems().get(0);
			}
		}

		return null;

	}

	public ExamScheduleItem getExamScheduleByDefinitionId(String portalURL, long scopeGroupId, long examDefinitionId) {

		String examScheduleURL = portalURL + LRObjectURL.EXAM_SCHEDULE_URL + CommonConstants.SCOPES + StringPool.SLASH
				+ scopeGroupId + StringPool.QUESTION + "filter=examDefinitionId"
				+ URLEncoder.encode(" eq " + "'" + examDefinitionId + "'", StandardCharsets.UTF_8);
		logger.info("examScheduleURL " + examScheduleURL);
		String examScheduleResponse = commonApi.getData(examScheduleURL);
		if (Validator.isNotNull(examScheduleResponse)) {
			return CustomObjectMapperUtil.readValue(examScheduleResponse, ExamScheduleItem.class);
		}
		return null;

	}

	public List<ByLawRule> getByLawRules(ThemeDisplay themeDisplay) {
		List<ByLawRule> byLawRules = new ArrayList<>();
		try {
			String url = themeDisplay.getPortalURL() + LRObjectURL.BYLAW_RULES_OBJECT_URL + CommonConstants.SCOPES
					+ StringPool.SLASH + getGroupId();
			String response = httpConnector.executeGet(url, "", commonApi.getHttpHeaderInfoAndBasicAuth());
			ByLawRuleItem byLawRuleItem = CustomObjectMapperUtil.readValue(response, ByLawRuleItem.class);
			if (Validator.isNotNull(byLawRuleItem) && Validator.isNotNull(byLawRuleItem.getItems())
					&& !byLawRuleItem.getItems().isEmpty()) {

				for (ByLawRule byLawRule : byLawRuleItem.getItems()) {
					byLawRule.setRuleKeyName("Rule" + byLawRule.getRuleKey());
					byLawRules.add(byLawRule);
				}
				return byLawRules;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return byLawRules;
	}

	public JSONArray getByRuleCondition(ThemeDisplay themeDisplay, long byLawRuleId) {
		JSONArray ByLawRuleJsonArray = JSONFactoryUtil.createJSONArray();
		JSONObject ByLawRuleson = JSONFactoryUtil.createJSONObject();
		String url = themeDisplay.getPortalURL() + LRObjectURL.BYLAW_RULES_OBJECT_URL + byLawRuleId;
		String response = httpConnector.executeGet(url, "", commonApi.getHttpHeaderInfoAndBasicAuth());
		ByLawRule byLawRule = CustomObjectMapperUtil.readValue(response, ByLawRule.class);
		String byLawConditionIds = byLawRule.getByLawConditionIds();
		boolean isMatchAll = byLawRule.isMatchAll();
		if (Validator.isNotNull(byLawConditionIds)) {

			String[] byLawConditionIdstr = byLawConditionIds.split(",");
			String conditionValue = getConditionValue(themeDisplay, isMatchAll, byLawConditionIdstr);
			byLawRule.setByLawCondition(conditionValue);
		}
		logger.info("condition value::" + byLawRule.getByLawCondition());
		ByLawRuleson.put("examEligibility", byLawRule.getByLawCondition());
		ByLawRuleJsonArray.put(ByLawRuleson);
		return ByLawRuleJsonArray;
	}

	private String getConditionValue(ThemeDisplay themeDisplay, boolean isMatchAll, String[] byLawConditionIdstr) {
		List<String> conditionList = new ArrayList<String>();

		if (Validator.isNotNull(conditionList)) {
			for (String byLawConditionId : byLawConditionIdstr) {

				ByLawCondition byLawCondition = getByLawConditionById(themeDisplay,
						Long.parseUnsignedLong(byLawConditionId));
				if (Validator.isNotNull(byLawCondition)) {
					conditionList.add(byLawCondition.getConditionValue());
				}
			}
			if (isMatchAll) {
				return String.join(" And ", conditionList);
			}
			return String.join(" Or ", conditionList);
		}
		return null;
	}

	public ByLawCondition getByLawConditionById(ThemeDisplay themeDisplay, long id) {

		String byRuleConditionUrl = themeDisplay.getPortalURL() + LRObjectURL.BYLAW_CONDITION_OBJECT_URL
				+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION
				+ "filter=id" + URLEncoder.encode(" eq " + "'" + id + "'", StandardCharsets.UTF_8);
		String byRuleConditionResponse = commonApi.getData(byRuleConditionUrl);
		logger.info("byRuleConditionUrl::" + byRuleConditionUrl);
//		logger.info("byRuleConditionResponse===============" + byRuleConditionResponse);
		ByLawConditionItem byLawConditionItem = CustomObjectMapperUtil.readValue(byRuleConditionResponse,
				ByLawConditionItem.class);
		if (Validator.isNotNull(byLawConditionItem) && Validator.isNotNull(byLawConditionItem.getItems())
				&& !byLawConditionItem.getItems().isEmpty()) {
			return byLawConditionItem.getItems().get(0);
		}
		return null;
	}

	public String getruleKeyByRuleId(ThemeDisplay themeDisplay, long byLawRuleId) {
		try {
			String url = themeDisplay.getPortalURL() + LRObjectURL.BYLAW_RULES_OBJECT_URL + byLawRuleId;
			String response = httpConnector.executeGet(url, "", commonApi.getHttpHeaderInfoAndBasicAuth());
			ByLawRule byLawRule = CustomObjectMapperUtil.readValue(response, ByLawRule.class);
			if (Validator.isNotNull(byLawRule)) {
				return "Rule" + byLawRule.getRuleKey();
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return "";
	}

	public String getByRuleConditionText(ThemeDisplay themeDisplay, long byLawRuleId) {
		String conditionValue = StringPool.BLANK;
		String url = themeDisplay.getPortalURL() + LRObjectURL.BYLAW_RULES_OBJECT_URL + byLawRuleId;
		String response = httpConnector.executeGet(url, "", commonApi.getHttpHeaderInfoAndBasicAuth());
		ByLawRule byLawRule = CustomObjectMapperUtil.readValue(response, ByLawRule.class);
		String byLawConditionIds = byLawRule.getByLawConditionIds();
		boolean isMatchAll = byLawRule.isMatchAll();
		if (Validator.isNotNull(byLawConditionIds)) {

			String[] byLawConditionIdstr = byLawConditionIds.split(",");
			conditionValue = getConditionValue(themeDisplay, isMatchAll, byLawConditionIdstr);
		}

		return conditionValue;
	}

	public List<ByLawRule> geAllByLaw(ThemeDisplay themeDisplay) {
		String conditionValue = StringPool.BLANK;
		String url = themeDisplay.getPortalURL() + LRObjectURL.BYLAW_RULES_OBJECT_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + getGroupId();
		logger.info("by law url :" + url);
		String response = httpConnector.executeGet(url, "", commonApi.getHttpHeaderInfoAndBasicAuth());
		ByLawRuleItem byLawRuleItem = CustomObjectMapperUtil.readValue(response, ByLawRuleItem.class);
		if (Validator.isNotNull(byLawRuleItem) && Validator.isNotNull(byLawRuleItem.getItems())
				&& !byLawRuleItem.getItems().isEmpty()) {
			return byLawRuleItem.getItems();
		}
		return new ArrayList<>();
	}

	public JSONArray isExamTypeRuleKeyMatch(ThemeDisplay themeDisplay, String examType) {
		JSONArray byLawRuleJsonArray = JSONFactoryUtil.createJSONArray();
		try {
			
			JSONObject byLawRuleson = JSONFactoryUtil.createJSONObject();
			String conditionValue = StringPool.BLANK;
			List<ByLawRule> byLawRuleItem = geAllByLaw(themeDisplay);
			if(Validator.isNotNull(byLawRuleItem) ) {
			logger.info("size of item: "+byLawRuleItem.size());
			for (ByLawRule byLawRule : byLawRuleItem) {
				logger.info("by law  id:"+byLawRule.getId());
				String byLawConditionIds = byLawRule.getByLawConditionIds();
				boolean isMatchAll = byLawRule.isMatchAll();
				if (Validator.isNotNull(byLawConditionIds)) {
					logger.info("byLawRuleId:" + byLawRule.getId());
					String[] byLawConditionIdstr = byLawConditionIds.split(",");
					conditionValue = getConditionValue(themeDisplay, isMatchAll, byLawConditionIdstr);
					String value = getByRuleConditionText(themeDisplay, byLawRule.getId());
					
					logger.info("value is:" + value);
					logger.info("exam type:: " + examType);
					logger.info("value contains ? " + value.contains(examType));
					
					if (value.contains(examType)) {
						
						logger.info("rule key: " + byLawRule.getRuleKey());
						byLawRuleson.put("suggestedRule", "Rule" + byLawRule.getRuleKey());
						byLawRuleJsonArray.put(byLawRuleson);
					}
				}
				
			}
			logger.info("array size::" + byLawRuleJsonArray);
			return byLawRuleJsonArray;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return byLawRuleJsonArray;
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

	public List<String> geAllByLawRuleConditionText(ThemeDisplay themeDisplay) {
		try {
			String conditionValue = StringPool.BLANK;
			String url = themeDisplay.getPortalURL() + LRObjectURL.BYLAW_RULES_OBJECT_URL + CommonConstants.SCOPES
					+ StringPool.SLASH + getGroupId();
			logger.info("by law url :" + url);
			String response = httpConnector.executeGet(url, "", commonApi.getHttpHeaderInfoAndBasicAuth());
			ByLawRuleItem byLawRuleItem = CustomObjectMapperUtil.readValue(response, ByLawRuleItem.class);
			if (Validator.isNotNull(byLawRuleItem) && Validator.isNotNull(byLawRuleItem.getItems())
					&& !byLawRuleItem.getItems().isEmpty()) {
				List<String> conditionValues = new ArrayList<>();
				for (ByLawRule byLawRule : byLawRuleItem.getItems()) {
					String byLawConditionIds = byLawRule.getByLawConditionIds();
					boolean isMatchAll = byLawRule.isMatchAll();
					if (Validator.isNotNull(byLawConditionIds)) {

						String[] byLawConditionIdstr = byLawConditionIds.split(",");
						conditionValue = getConditionValue(themeDisplay, isMatchAll, byLawConditionIdstr);
						conditionValues.add(conditionValue);
						logger.info("size of ruleConditionText :" + conditionValues.size());
					}

				}
				return conditionValues;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return new ArrayList<>();
	}

	public long getTraineeLevelId(long userId) {
		long traineeLevelId = 0;
		try {

			TraineeAdmissionDetailsRel admissionDetailsRel = TraineeAdmissionDetailsRelLocalServiceUtil
					.findByTraineeId(userId);
			if (Validator.isNotNull(admissionDetailsRel)) {
				List<TraineeCohortDetails> cohortDetails = TraineeCohortDetailsLocalServiceUtil
						.findByTraineeAdmissionDetailsRelId(admissionDetailsRel.getTraineeAdmissionDetailsRelId());
				if (Validator.isNotNull(cohortDetails)) {
					cohortDetails = cohortDetails.stream().filter(n -> n.getIsCurrentCohort().equals(true))
							.collect(Collectors.toList());
					traineeLevelId = cohortDetails.size() > 0 ? cohortDetails.get(0).getTraineeLevelId() : 0;
				}

			}
		} catch (Exception e) {
			traineeLevelId = 0;
		}
		return traineeLevelId;
	}
	
	public  List<Registration> getRegistrationByScheduleIdAndStatus(String portalUrl, long groupId,long examScheduleId,String status) {
		logger.info("getRegistrationByUserIdProgramAndExamType() started ");
		
		try {
			String registrationUrl = portalUrl + LRObjectURL.EXAM_REGISTERATION_URL
					+ CommonConstants.SCOPES + StringPool.SLASH + groupId + StringPool.QUESTION
					+ "filter=registrationStatus" + URLEncoder.encode(" eq '" + status + "'" + " and examScheduleId eq " + examScheduleId, StandardCharsets.UTF_8);
			logger.info("registration url " + registrationUrl);
			String registrationResponse = commonApi.getData(registrationUrl);
			logger.info("registration registrationResponse " + registrationResponse);

			RegistrationItem registrationItem = CustomObjectMapperUtil.readValue(registrationResponse,
					RegistrationItem.class);
			
			if(Validator.isNotNull(registrationItem) && Validator.isNotNull(registrationItem.getItems())) {
				return registrationItem.getItems();
			}
			
			
		}catch(Exception e) {
			logger.info(e.getMessage(), e);
			new ArrayList<>();
		}
			
		return new ArrayList<>();
	}
	public String getProgramTypeByProgramTypeId(ThemeDisplay themeDisplay, long programTypeMasterId) {
		logger.info("getProgramType() started");
		try {
			ProgramTypeMaster programTypeMaster = ProgramTypeMasterLocalServiceUtil
					.getProgramTypeMaster(programTypeMasterId);
			if (Validator.isNotNull(programTypeMaster)) {
				programTypeMaster
						.setProgramTypeName(CommonUtil.getValueByLanguage(programTypeMaster.getProgramTypeName(),
								OMSBExamWebPortletKeys.PROGRAM_TYPE, themeDisplay.getLocale().toString()));
				return programTypeMaster.getProgramTypeName();
			}
		} catch (Exception e) {
			logger.error("error while fetching program type:" + e.getMessage(), e);
		}
		logger.info("getProgramType() ended");
		return "";
	}
	
	
	
	
	public List<ExamSchedule> getScheduleExamsByYesterdaysDate(String portalURL, long groupId, String examDate) {

//		String examScheduleURL = portalURL + LRObjectURL.EXAM_SCHEDULE_URL + CommonConstants.SCOPES + StringPool.SLASH
//				+ groupId + StringPool.QUESTION + "filter=examDate"
//				+ URLEncoder.encode(" eq " + examDate, StandardCharsets.UTF_8);
//		
		String examScheduleURL = portalURL + LRObjectURL.EXAM_SCHEDULE_URL + CommonConstants.SCOPES + StringPool.SLASH + groupId;
		
		String examScheduleResponse = commonApi.getData(examScheduleURL);
		ExamScheduleItem examScheduleItem = CustomObjectMapperUtil.readValue(examScheduleResponse,
				ExamScheduleItem.class);
		if (Validator.isNotNull(examScheduleItem) && Validator.isNotNull(examScheduleItem.getItems())) {

			for (ExamSchedule examSchedule : examScheduleItem.getItems()) {

				if(examSchedule.isMultiDates()) {
					
					String ExamMutiDateUrl = portalURL + LRObjectURL.EXAM_MULTIDATES_URL + CommonConstants.SCOPES
							+ StringPool.SLASH + groupId + StringPool.QUESTION + "filter=examScheduleAdminId"
							+ URLEncoder.encode(" eq " + examSchedule.getExamScheduleAdminId(), StandardCharsets.UTF_8)
							+ "&sort=examDate:desc";

					
					String examMultiDatesResponse = commonApi.getData(ExamMutiDateUrl);
					ExamMultiDatesItem examMultiDatesItem = CustomObjectMapperUtil.readValue(examMultiDatesResponse,
							ExamMultiDatesItem.class);
					if (Validator.isNotNull(examMultiDatesItem) && Validator.isNotNull(examMultiDatesItem.getItems())
							&& examMultiDatesItem.getItems().size() > 0) {
						ExamMultiDates examMultiDates = examMultiDatesItem.getItems().get(0);

						examSchedule.setExamDate(commonApi.convertObjectDateToDDMMYYYYDate(examMultiDates.getExamDate()));
						examSchedule.setStartTime(examMultiDates.getStartTime());
						
					}
				}
				
				
				ExamDefinition examDefinition = getExamDefinitionByDefinitionId(examSchedule.getExamDefinitionId(),
						portalURL);
				if (Validator.isNotNull(examDefinition)) {
					examSchedule.setExamTypeName(omsbCommonApi.getListTypeEntryNameBylistTypeEntryId(
							examDefinition.getExamTypeId(), Locale.getDefault()));
					examSchedule.setExamType(examDefinition.getExamTypeId());
				}
			}

			return examScheduleItem.getItems();
		}

		return new ArrayList<>();
	}
	
	

	public List <ExamSchedule> getscheduleExamListByExamTypeIdAndProgramId(String portalURL, long groupId, long examTypeId,
			long programId) {
		ExamScheduleItem examScheduleItem = new ExamScheduleItem();
		List <ExamSchedule> ec = null;
		try {
			//Date date=new SimpleDateFormat(DataflowConstants.OBJECT_DATE_FORMAT).parse(examDate);
		
		String examScheduleURL = portalURL + LRObjectURL.EXAM_SCHEDULE_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + groupId + StringPool.QUESTION + "filter=examType"
					+ URLEncoder.encode(" eq " + examTypeId +  " and programId eq " + programId, StandardCharsets.UTF_8);
		logger.info("examScheduleURL" + examScheduleURL);
		String examScheduleResponse = commonApi.getData(examScheduleURL);
		
		examScheduleItem= CustomObjectMapperUtil.readValue(examScheduleResponse, ExamScheduleItem.class);
		if(Validator.isNotNull(examScheduleItem) && Validator.isNotNull(examScheduleItem.getItems())) {
			return examScheduleItem.getItems();
		}
		
		} catch (Exception e) {
			logger.info(e.getMessage(), e);
		}
		
		return new ArrayList<>();
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
			// TODO Auto-generated catch block
			e.printStackTrace();
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
			folderQuery.add(PropertyFactoryUtil.forName("name").eq("exam"));
			folderQuery.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()));
			folderQuery
					.add(PropertyFactoryUtil.forName("parentFolderId").eq(DLFolderConstants.DEFAULT_PARENT_FOLDER_ID));
			List<DLFolder> folderList = DLFolderLocalServiceUtil.dynamicQuery(folderQuery);
			List<String> folderNameList = folderList.parallelStream().map(DLFolder::getName)
					.collect(Collectors.toList());
			if (!folderNameList.contains("exam")) {
				examFolder = DLFolderLocalServiceUtil.addFolder(StringPool.BLANK, themeDisplay.getUserId(),
						themeDisplay.getScopeGroupId(), themeDisplay.getScopeGroupId(), Boolean.FALSE,
						DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,"exam",
						"User" + " exam", Boolean.FALSE, serviceContext);
			} else {
				folderQuery = DynamicQueryFactoryUtil.forClass(DLFolder.class, PortalClassLoaderUtil.getClassLoader());
				folderQuery.add(PropertyFactoryUtil.forName("name").eq("exam"));
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
						examFolder.getFolderId(), String.valueOf(userId), userId + " exams", Boolean.FALSE,
						serviceContext);
			} else {
				folderQuery = DynamicQueryFactoryUtil.forClass(DLFolder.class, PortalClassLoaderUtil.getClassLoader());
				folderQuery.add(PropertyFactoryUtil.forName("name").eq(String.valueOf(userId)));
				folderQuery.add(PropertyFactoryUtil.forName("groupId").eq(themeDisplay.getScopeGroupId()));
				folderQuery.add(PropertyFactoryUtil.forName("parentFolderId").eq(examFolder.getFolderId()));
				userFolder = (DLFolder) DLFolderLocalServiceUtil.dynamicQuery(folderQuery).get(0);
			}

			File file = generatePdfDocument(htmlReciept, themeDisplay,MVCCommands.EXAM_PAYMENT_RECIEPT_PATH,MVCCommands.EXAM_PAYMENT_RECIEPT_NAME);
			if (Validator.isNotNull(file)) {
				InputStream inputStream = new FileInputStream(file);
				long timeStamp = new Date().getTime();
				fileEntry = DLFileEntryLocalServiceUtil.addFileEntry(StringPool.BLANK, themeDisplay.getUserId(),
						themeDisplay.getScopeGroupId(), themeDisplay.getScopeGroupId(), userFolder.getFolderId(),
						MVCCommands.EXAM_PAYMENT_RECIEPT_NAME + "_" + timeStamp + ".pdf", ContentTypes.APPLICATION_PDF,
						MVCCommands.EXAM_PAYMENT_RECIEPT_NAME + "_" + timeStamp, MVCCommands.EXAM_PAYMENT_RECIEPT_URL,
						"Payment Receipt", StringPool.BLANK, 0L, null, file, inputStream, file.length(), null, null,
						serviceContext);
				String download = themeDisplay.getPortalURL() + themeDisplay.getPathContext() + "/exam/"
						+ fileEntry.getGroupId() + StringPool.SLASH + fileEntry.getFolderId() + StringPool.SLASH
						+ URLEncoder.encode(HtmlUtil.unescape(fileEntry.getTitle()), DataflowConstants.UTF_8)
						+ StringPool.SLASH + fileEntry.getUuid() + "?version=" + fileEntry.getVersion();
				logger.debug("Download >>>>>" + download);
				logger.debug("fileEntry >>>>>" + fileEntry.getFileEntryId());

			}

		} catch (Exception e) {
			logger.error(e);
		}
		return fileEntry;
	}


	
	@Reference(unbind = "-")
	private UserLocalService userLocalService;

	@Reference(unbind = "-")
	private OMSBCommonApi commonApi;

	@Reference(unbind = "-")
	private OMSBHttpConnector httpConnector;

	@Reference
	UserNotificationEventLocalService userNotificationEventLocalService;

	@Reference(unbind = "-")
	private ProgramMasterLocalService programMasterLocalService;

	private static final Log logger = LogFactoryUtil.getLog(ExamUtil.class);

	@Reference(unbind = "-")
	private CountryLocalService countryLocalService;

}
