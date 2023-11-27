package gov.omsb.oct.web.portlet.portlet.action;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.liferay.calendar.service.CalendarBookingLocalService;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserNotificationEventLocalService;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.dto.OCTExam;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamBlueprint;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamCancellationFees;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamDefinition;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamDefinitionItems;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamDetails;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamFormNumber;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamItems;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamJsonFields;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamSchedule;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamScheduleItems;
import gov.omsb.oct.exam.web.portlet.dto.OCTRegularFees;
import gov.omsb.oct.exam.web.portlet.dto.OCTRescheduleFees;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;
import gov.omsb.oct.exam.web.portlet.util.OCTNotificationUtil;
import gov.omsb.oct.exam.web.portlet.util.OCTScheduleUtil;
/*
 * separate class created 
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name=" + MVCCommandNames.EXAM_SCHEDULE_ACTIONS }, service = MVCActionCommand.class)
public class AddOCTExamScheduleMVCActionCommand extends BaseMVCActionCommand {

	@Override
	public void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		logger.info("doProcessAction() started ");
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long ocExamScheduleId = ParamUtil.getLong(actionRequest, "examScheduleId");
			String status = ParamUtil.getString(actionRequest, "status");
			long octExamId = ParamUtil.getLong(actionRequest, "octExamId");
			String portalURL = themeDisplay.getPortalURL();
			Locale locale = themeDisplay.getLocale();
			long scopeGroupId = themeDisplay.getScopeGroupId();
			long companyId = themeDisplay.getCompanyId();
			boolean isSuccess = false;

			Role role = RoleLocalServiceUtil.getRole(companyId, RoleNameConstants.EXAM_APPLICANT);
			long roleId = 0;
			if (Validator.isNotNull(role)) {

				roleId = role.getRoleId();
			}

			if (ocExamScheduleId > 0 && status.equalsIgnoreCase("block")) {

				changeExamScheduleStatusAsBlocked(ocExamScheduleId, themeDisplay, actionResponse);

			} else if (ocExamScheduleId > 0 && status.equalsIgnoreCase("cancel")) {

				changeExamScheduleStatusAsCanceled(ocExamScheduleId, themeDisplay, actionResponse);

			} else if (ocExamScheduleId > 0 && status.equalsIgnoreCase("reschedule")) {

				rescheduleExam(ocExamScheduleId, themeDisplay, actionResponse);
			}

			String repeatedInstanceDuplicateRowValues = ParamUtil.getString(actionRequest,
					"repeatedInstanceDuplicateRowValues");
			long examDefinitionId = createOCTExamDefinition(octExamId, portalURL, locale, scopeGroupId, companyId);

			if (examDefinitionId <= 0) {
				OCTExamDefinition octExamDefinition = octExamUtil.getOCTExamDefintionByOCTExamId(portalURL,
						scopeGroupId, octExamId);
				if (Validator.isNotNull(octExamDefinition)) {
					examDefinitionId = octExamDefinition.getId();
				}
			}

			if (!repeatedInstanceDuplicateRowValues.isEmpty()) {

				saveOCTExamScheduleRepeatedInstance(examDefinitionId, octExamId, actionRequest, actionResponse,
						portalURL, scopeGroupId, repeatedInstanceDuplicateRowValues, locale, companyId, roleId);
				isSuccess = true;
			} else {
				saveOCTExamScheduleSingleInstance(examDefinitionId, octExamId, actionRequest, actionResponse, portalURL,
						scopeGroupId, repeatedInstanceDuplicateRowValues, locale, companyId, roleId, themeDisplay);
				isSuccess = true;
			}
			if (isSuccess)
				SessionMessages.add(actionRequest, OmsbOctExamWebPortletKeys.SET_EXAM_SCHEDULE_SUCCESS);
//			actionResponse.sendRedirect(OmsbOctExamWebPortletKeys.REDIRECT_URL);

		} catch (Exception e) {
			//SessionErrors.add(actionRequest, OmsbOctExamWebPortletKeys.SET_EXAM_SCHEDULE_ERROR);
			logger.error(e.getMessage(), e);
		}
		logger.info("doProcessAction() ended ");
	}

	private void saveOCTExamScheduleSingleInstance(long examDefinitionId, long octExamId, ActionRequest actionRequest,
			ActionResponse actionResponse, String portalURL, long scopeGroupId,
			String repeatedInstanceDuplicateRowValues, Locale locale, long companyId, long roleId, ThemeDisplay themeDisplay) {

		try {
			logger.info("Single Instance method .... " + examDefinitionId);
			String registrationStartDate = ParamUtil.getString(actionRequest, "siRegistrationStartDate");
			String registrationEndDate = ParamUtil.getString(actionRequest, "siRegistrationEndDate");
			String examStartDate = ParamUtil.getString(actionRequest, "siExamDate");
			int noOfSeats = ParamUtil.getInteger(actionRequest, "siNoOfSeats");
			String examStatus = ParamUtil.getString(actionRequest, "siCMD");
			String locationOnGoogleMap = ParamUtil.getString(actionRequest, "siLocationOnGoogleMap");
			String venue = ParamUtil.getString(actionRequest, "siVenue");

			String department = ParamUtil.getString(actionRequest, "siDepartmentId");
			String section = ParamUtil.getString(actionRequest, "siSectionId");
			String[] examSlotList = ParamUtil.getStringValues(actionRequest, "siExamSlotList");
			long examCenter = ParamUtil.getLong(actionRequest, "siTrainingSite");

			for (String examSlot : examSlotList) {

				String[] examTime = examSlot.split("-");
				String examStartTime = getExamStartTimeByExamTime(examTime);
				String examEndTime = getExamEndTimeByExamTime(examTime);
				logger.info(examEndTime + "  " + examStartTime);

				ListTypeEntry listEntry = omsbCommonApi
						.getListTypeEntryByListTypeItemKey(LRPicklistConstants.DEPARTMENT, department, companyId);

				ListTypeEntry listTypeEntry = omsbCommonApi
						.getListTypeEntryByListTypeItemKey(LRPicklistConstants.SECTION, section, companyId);

				long departmentListTypeEntryId = 0;
				long sectionListTypeEntryId = 0;
				if (Validator.isNotNull(listEntry)) {
					departmentListTypeEntryId = listEntry.getListTypeEntryId();
				}
				if (Validator.isNotNull(listTypeEntry)) {
					sectionListTypeEntryId = listTypeEntry.getListTypeEntryId();
				}
				long ocExamScheduleAdminId = saveOCExamScheduleAdmin(examStartTime,examEndTime, null, false, examStartDate, null, locationOnGoogleMap, venue, departmentListTypeEntryId, sectionListTypeEntryId, actionRequest, themeDisplay);
				OCTExamSchedule octExamSchedule = prepareOCTExamSchedule(registrationStartDate, registrationEndDate,
						examStartDate, examStartTime, examEndTime, noOfSeats, examStatus, examDefinitionId,
						locationOnGoogleMap, venue, departmentListTypeEntryId, sectionListTypeEntryId, locale,
						companyId, examCenter, ocExamScheduleAdminId);

				logger.info("####################################################");
				logger.info("Schedule Id ..." + octExamSchedule.getId());
				
				String octScheduleResponse = octExamUtil.saveOCTExamSchedule(octExamSchedule, portalURL, scopeGroupId);

				logger.info("Exam Schedule Response = ... " + octScheduleResponse);
				if (examStatus.equalsIgnoreCase("Announced")) {

					octNotificationUtil.sendNotificationToUsers(portalURL, examStatus, scopeGroupId, companyId, locale,
							roleId, octExamSchedule);

					try {
						if (Validator.isNotNull(octScheduleResponse)) {
							OCTExamSchedule examScheduleItems = CustomObjectMapperUtil.readValue(octScheduleResponse,
									OCTExamSchedule.class);
							ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
							octScheduleUtil.addCalenderEvent(serviceContext, examScheduleItems);
						}
					} catch (PortalException e) {
						logger.info(e.getMessage());
					}
				}
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}

	}

	private String getExamEndTimeByExamTime(String[] examTime) {
		String examEndTime = examTime[1].substring(1, examTime[1].length());
		examEndTime = convert12HourTo24Hour(examEndTime);
		return examEndTime;
	}

	private String getExamStartTimeByExamTime(String[] examTime) {
		String examStartTime = examTime[0].substring(0, examTime[0].length());
		examStartTime = convert12HourTo24Hour(examStartTime);
		return examStartTime;
	}

	private String convert12HourTo24Hour(String time12) {
		SimpleDateFormat format12 = new SimpleDateFormat("hh:mm a");
		SimpleDateFormat format24 = new SimpleDateFormat("HH:mm");

		try {
			Date date = format12.parse(time12);
			return format24.format(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return "";
		}
	}

	private void saveOCTExamScheduleRepeatedInstance(long examDefinitionId, long octExamId, ActionRequest actionRequest,
			ActionResponse actionResponse, String portalURL, long scopeGroupId,
			String repeatedInstanceDuplicateRowValues, Locale locale, long companyId, long roleId) {
//		String registrationStartDate = ParamUtil.getString(actionRequest, "riRegistrationStartDate");
//		String registrationEndDate = ParamUtil.getString(actionRequest, "riRegistrationEndDate");
		String examStartDate = ParamUtil.getString(actionRequest, "riExamStartDate");
		String examEndDate = ParamUtil.getString(actionRequest, "riExamEndDate");

		String locationOnGoogleMap = ParamUtil.getString(actionRequest, "riLocationOnGoogleMap");
		String venue = ParamUtil.getString(actionRequest, "riVenue");

		String department = ParamUtil.getString(actionRequest, "riDepartmentId");
		String section = ParamUtil.getString(actionRequest, "riSectionId");

		ListTypeEntry listEntry = omsbCommonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.DEPARTMENT,
				department, companyId);

		ListTypeEntry listTypeEntry = omsbCommonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.SECTION,
				section, companyId);

		long departmentListTypeEntryId = 0;
		long sectionListTypeEntryId = 0;
		if (Validator.isNotNull(listEntry)) {
			departmentListTypeEntryId = listEntry.getListTypeEntryId();
		}
		if (Validator.isNotNull(listTypeEntry)) {
			sectionListTypeEntryId = listTypeEntry.getListTypeEntryId();
		}
		String examStatus = ParamUtil.getString(actionRequest, "riCMD");
		logger.info("exam status:"+ examStatus);
		try {
			JSONArray jsonArray = JSONFactoryUtil.createJSONArray(repeatedInstanceDuplicateRowValues);
			logger.info("JSONArray  JSONArray  ....  " + jsonArray.length());
			if (Validator.isNotNull(jsonArray)) {

				Date octExamStartDate = omsbCommonApi.convertStringToDate(examStartDate);
				LocalDate examStartLocalDate = octExamStartDate.toInstant().atZone(ZoneId.systemDefault())
						.toLocalDate();
				Date octExamEndDate = omsbCommonApi.convertStringToDate(examEndDate);
				LocalDate examEndLocalDate = octExamEndDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				long numOfDays = ChronoUnit.DAYS.between(examStartLocalDate, examEndLocalDate);
				logger.info("examStartLocalDate ..  " + examStartLocalDate + " ,,, examEndLocalDate ... "
						+ examEndLocalDate);
				for (int i = 0; i <= jsonArray.length(); i++) {
					JSONObject valueJson = jsonArray.getJSONObject(i);
					JSONArray daysOfWeekJsonArray = valueJson.getJSONArray("riDaysOfWeek");
					for (int j = 0; j < daysOfWeekJsonArray.length(); j++) {
						if (numOfDays > 0) {
							List<LocalDate> daysRange = Stream.iterate(examStartLocalDate, date -> date.plusDays(1))
									.limit(numOfDays)
									.filter(date -> date
											.getDayOfWeek() == getDayOfWeek(valueJson.getString("dayOfWeek")))
									.collect(Collectors.toList());
							logger.info("daysRange ... " + daysRange);
							if (daysRange.size() > 0) {
								for (LocalDate examDate : daysRange) {
									String newExamDate = omsbCommonApi.convertYYYYMMDDLocalDatetoObjectDate(examDate);
									examStartDate = omsbCommonApi.convertObjectDateToDDMMYYYYDate(newExamDate);
									int noOfSeats = valueJson.getInt("noOfSeats");
									JSONArray examSlotList = valueJson.getJSONArray("examSlotList");

									for (Object examSlotObject : examSlotList) {

										String examSlot = String.valueOf(examSlotObject);
										String[] examTime = examSlot.split("-");
										String examStartTime = getExamStartTimeByExamTime(examTime);
										String examEndTime = getExamEndTimeByExamTime(examTime);

//										long ocExamScheduleAdminId = saveOCExamScheduleAdmin(examStartTime,examEndTime, null, false, examStartDate, null, locationOnGoogleMap, venue, departmentListTypeEntryId, sectionListTypeEntryId, actionRequest, themeDisplay);
										OCTExamSchedule octExamSchedule = prepareOCTRIExamSchedule(examStartDate,
												examStartTime, examEndTime, noOfSeats, examStatus, examDefinitionId,
												locationOnGoogleMap, venue, departmentListTypeEntryId,
												sectionListTypeEntryId, locale, companyId);
										logger.info(octExamSchedule);
										logger.info("exam status"+octExamSchedule.getExamStatusId());
										
										String octScheduleResponse = octExamUtil.saveOCTExamSchedule(octExamSchedule,
												portalURL, scopeGroupId);
											logger.info("response:"+octScheduleResponse);
										if (examStatus.equalsIgnoreCase("Announced")) {

											octNotificationUtil.sendNotificationToUsers(portalURL, examStatus,
													scopeGroupId, companyId, locale, roleId, octExamSchedule);

											try {
												if (Validator.isNotNull(octScheduleResponse)) {
													OCTExamSchedule examScheduleItems = CustomObjectMapperUtil
															.readValue(octScheduleResponse, OCTExamSchedule.class);
													ServiceContext serviceContext = ServiceContextFactory
															.getInstance(actionRequest);
													octScheduleUtil.addCalenderEvent(serviceContext, examScheduleItems);
												}
											} catch (PortalException e) {
												logger.info(e.getMessage());
											}

										}
									}
								}
							}
						}
					}
				}

//				actionResponse.getRenderParameters().setValue("mvcRenderCommandName",
//						MVCCommandNames.VIEW_OCT_EXAM_SCHEDULE_LIST_RENDER);
			}
		} catch (JSONException e) {
			logger.info("JSON Exception >>>" + e.getMessage());
		}
//		actionResponse.getRenderParameters().setValue("mvcRenderCommandName",
//				MVCCommandNames.VIEW_OCT_EXAM_SCHEDULE_LIST_RENDER);
	}

	private long createOCTExamDefinition(long octExamId, String portalURL, Locale locale, long scopeGroupId,
			long companyId) {
		long examDefinitionId = 0L;

		try {
			OCTExamDetails octExamDetails = octExamUtil.getOCTExamDetailsListByExamId(octExamId, companyId,
					scopeGroupId, portalURL, locale);
			if (Validator.isNotNull(octExamDetails)) {
				if (octExamDetails.isModified()) {
					OCTExamJsonFields octExamJsonFields = octExamDetails.getExamJson();

					if (Validator.isNotNull(octExamJsonFields)) {
						OCTExamDefinition octExamDefinition = prepareExamDefinition(octExamJsonFields, octExamId);
						String createOCTExamDefinitionResponse = octExamUtil.saveExamDefition(octExamDefinition,
								octExamId, portalURL, scopeGroupId);
						if (Validator.isNotNull(createOCTExamDefinitionResponse)) {
							OCTExamDefinition createdOCTExamDefinition = CustomObjectMapperUtil
									.readValue(createOCTExamDefinitionResponse, OCTExamDefinition.class);
							examDefinitionId = createdOCTExamDefinition.getId();

							// save value in exam regular fees
							if (octExamJsonFields.getOctRegularFees().size() > 0) {
								for (OCTRegularFees octRegularFees : octExamJsonFields.getOctRegularFees()) {
									octRegularFees.setOctExamDefinitionId(examDefinitionId);
									octExamUtil.saveRegularFees(octRegularFees, examDefinitionId, portalURL,
											scopeGroupId);
								}
							}

							// save value in exam cancellation fees
							if (octExamJsonFields.getOctExamCancellationFees().size() > 0) {
								for (OCTExamCancellationFees octExamCancellationFees : octExamJsonFields
										.getOctExamCancellationFees()) {
									octExamCancellationFees.setOctExamDefinitionId(examDefinitionId);
									octExamUtil.saveOCTExamCancellationFees(octExamCancellationFees, examDefinitionId,
											portalURL, scopeGroupId);
								}
							}

							// save value in exam rescheduling fees
							if (octExamJsonFields.getOctRescheduleFees().size() > 0) {
								for (OCTRescheduleFees octRescheduleFees : octExamJsonFields.getOctRescheduleFees()) {
									octRescheduleFees.setOctExamDefinitionId(examDefinitionId);
									octExamUtil.saveRescheduleFees(octRescheduleFees, examDefinitionId, portalURL,
											scopeGroupId);
								}
							}

							// save value in exam blue print
							if (octExamJsonFields.getOctExamBlueprints().size() > 0) {
								for (OCTExamBlueprint octExamBlueprint : octExamJsonFields.getOctExamBlueprints()) {
									octExamBlueprint.setOctExamDefinitionId(examDefinitionId);
									octExamUtil.saveExamBlueprint(octExamBlueprint, examDefinitionId, portalURL,
											scopeGroupId);
								}
							}

							// save exam form number
							if (octExamJsonFields.getOctExamFormNumbers().size() > 0) {
								for (OCTExamFormNumber octExamFormNumber : octExamJsonFields.getOctExamFormNumbers()) {
									octExamFormNumber.setOctExamDefinitionId(examDefinitionId);
									octExamUtil.saveOCTExamFormNumber(octExamFormNumber, examDefinitionId, portalURL,
											scopeGroupId);
								}
							}

							// update oct exam modify false
							OCTExam octExam = octExamUtil.getOCTExamByUserId(octExamId, portalURL);
							if (Validator.isNotNull(octExam)) {
								octExam.setModified(false);
								octExamUtil.updateOCTExam(octExam, octExamId, octExamDetails, portalURL);
							}
						}
					}
				}
			}
		} catch (JsonProcessingException e) {

			logger.error(e.getMessage(), e);

		}

		return examDefinitionId;
	}

	private OCTExamDefinition prepareExamDefinition(OCTExamJsonFields octExamJsonFields, long octExamId) {
		OCTExamDefinition octExamDefinition = new OCTExamDefinition();

		octExamDefinition.setoCExamId(octExamId);
		octExamDefinition.setoCExamTitleId(octExamJsonFields.getExamTitleId());
		octExamDefinition.setExamDuration(octExamJsonFields.getExamDuration());
		octExamDefinition.setCutScore(octExamJsonFields.getCutScore());
		octExamDefinition.setScoreValidity(octExamJsonFields.getScoreValidity());
		octExamDefinition.setCutOffWindow(octExamJsonFields.getCutOffWindow());
		octExamDefinition.setResultSource(octExamJsonFields.getResultSource());
		octExamDefinition.setExamFormNumber(octExamJsonFields.getExamFormNo());
		octExamDefinition.setVenue(octExamJsonFields.getVenue());
		octExamDefinition.setLocationOnGoogleMap(octExamJsonFields.getLocationOnGoogleMap());
		octExamDefinition.setAppealWindow(octExamJsonFields.getAppealWindow());
		octExamDefinition.setAppealFees(octExamJsonFields.getAppealFees());
		octExamDefinition.setReAppealWindow(octExamJsonFields.getReAppealWindow());
		octExamDefinition.setReAppealFees(octExamJsonFields.getReAppealFees());
		octExamDefinition.setEarlyBirdFees(octExamJsonFields.getEarlyBirdFees());
		octExamDefinition.setEarlyBirdFeesDate(octExamJsonFields.getEarlyBirdFeesDate());
		// octExamDefinition.setEarlyBirdFeesDate(
		// omsbCommonApi.convertDDMMYYYYDateToObjectDate(octExamJsonFields.getEarlyBirdFeesDate()));
		octExamDefinition.setAutoSchedulingPeriod(octExamJsonFields.getAutoSchedulingPeriod());
		octExamDefinition.setEligibilityCheck(octExamJsonFields.isEligibilityCheck());
		octExamDefinition.setApplyEligibility(octExamJsonFields.isApplyEligibility());
		octExamDefinition.setOmaniMaxAttempts(octExamJsonFields.getOmaniMaxAttempts());
		octExamDefinition.setOmaniMaxTimePeriod(octExamJsonFields.getOmaniTimePeriod());
		octExamDefinition.setOmaniTimePeriod(octExamJsonFields.getOmaniMaxTimePeriod());
		octExamDefinition.setNonOmaniMaxAttempts(octExamJsonFields.getNonOmaniMaxAttempts());
		octExamDefinition.setNonOmaniMaxTimePeriod(octExamJsonFields.getNonOmaniMaxTimePeriod());
		octExamDefinition.setNonOmaniTimePeriod(octExamJsonFields.getNonOmaniTimePeriod());
		logger.info("return oct Exam definition ");
		return octExamDefinition;

	}

	private OCTExamSchedule prepareOCTExamSchedule(String registrationStartDate, String registrationEndDate,
			String examStartDate, String examStartTime, String examEndTime, int noOfSeats, String examStatus,
			long examDefinitionId, String locationOnGoogleMap, String venue, long octExamDepartmentId,
			long octExamSectionId, Locale locale, long companyId, long examCenter, long octExamScheduleAdminId) {
		OCTExamSchedule octExamSchedule = new OCTExamSchedule();
		if (Validator.isNotNull(registrationStartDate)) {
			octExamSchedule
					.setRegistrationStartDate(omsbCommonApi.convertDDMMYYYYDateToObjectDate(registrationStartDate));
		}

		if (Validator.isNotNull(registrationEndDate)) {
			octExamSchedule.setRegistrationEndDate(omsbCommonApi.convertDDMMYYYYDateToObjectDate(registrationEndDate));
		}

		if (Validator.isNotNull(examStartDate)) {
			octExamSchedule.setExamDate(omsbCommonApi.convertDDMMYYYYDateToObjectDate(examStartDate));
		}

//		octExamSchedule.setExamTime(examStartTime);
//		octExamSchedule.setExamEndTime(examEndTime);
		octExamSchedule.setNoOfSeats(noOfSeats);
		octExamSchedule.setLocationOnGoogleMap(locationOnGoogleMap);
		octExamSchedule.setVenue(venue);
		octExamSchedule.setDepartmentId(octExamDepartmentId);
		octExamSchedule.setSectionId(octExamSectionId);
		octExamSchedule.setSectionId(octExamSectionId);
		octExamSchedule.setExamCenter(examCenter);
		octExamSchedule.setoCExamScheduleAdminId(octExamScheduleAdminId);

		if (Validator.isNotNull(examStatus)) {
			List<ListTypeEntry> listTypeEntry = omsbCommonApi
					.getListTypeEntriesByERC(LRPicklistConstants.PL_EXAM_STATUS, PortalUtil.getDefaultCompanyId());
			if (Validator.isNotNull(listTypeEntry)) {
				for (ListTypeEntry entry : listTypeEntry) {
					if (entry.getName(locale).equalsIgnoreCase(examStatus)) {
						octExamSchedule.setExamStatusId(entry.getListTypeEntryId());
					}

				}
			}
		}
		octExamSchedule.setOctExamDefinitionId(examDefinitionId);
		return octExamSchedule;
	}

	private OCTExamSchedule prepareOCTRIExamSchedule(String examStartDate, String examStartTime, String examEndTime,
			int noOfSeats, String examStatus, long examDefinitionId, String locationOnGoogleMap, String venue,
			long octExamDepartmentId, long octExamSectionId, Locale locale, long companyId) {
		OCTExamSchedule octExamSchedule = new OCTExamSchedule();

		if (Validator.isNotNull(examStartDate)) {
			octExamSchedule.setExamDate(omsbCommonApi.convertDDMMYYYYDateToObjectDate(examStartDate));
		}

//		octExamSchedule.setExamTime(examStartTime);
//		octExamSchedule.setExamEndTime(examEndTime);
		octExamSchedule.setNoOfSeats(noOfSeats);
		octExamSchedule.setLocationOnGoogleMap(locationOnGoogleMap);
		octExamSchedule.setVenue(venue);
		octExamSchedule.setDepartmentId(octExamDepartmentId);
		octExamSchedule.setSectionId(octExamSectionId);

		if (Validator.isNotNull(examStatus)) {
			List<ListTypeEntry> listTypeEntry = omsbCommonApi
					.getListTypeEntriesByERC(LRPicklistConstants.PL_EXAM_STATUS, PortalUtil.getDefaultCompanyId());
			if (Validator.isNotNull(listTypeEntry)) {
				for (ListTypeEntry entry : listTypeEntry) {
					if (entry.getName(locale).equalsIgnoreCase(examStatus)) {
						octExamSchedule.setExamStatusId(entry.getListTypeEntryId());
					}

				}
			}
		}
		octExamSchedule.setOctExamDefinitionId(examDefinitionId);
		return octExamSchedule;
	}

	public DayOfWeek getDayOfWeek(String dayOfWeek) {
		Map<String, DayOfWeek> dayOfWeekMap = new HashMap<>();
		dayOfWeekMap.put("monday", DayOfWeek.MONDAY);
		dayOfWeekMap.put("tuesday", DayOfWeek.TUESDAY);
		dayOfWeekMap.put("wednesday", DayOfWeek.WEDNESDAY);
		dayOfWeekMap.put("thursday", DayOfWeek.THURSDAY);
		dayOfWeekMap.put("friday", DayOfWeek.FRIDAY);
		dayOfWeekMap.put("saturday", DayOfWeek.SATURDAY);
		dayOfWeekMap.put("sunday", DayOfWeek.SATURDAY);
		return dayOfWeekMap.get(dayOfWeek);
	}


	private void changeExamScheduleStatusAsBlocked(long ocExamScheduleId, ThemeDisplay themeDisplay,
			ActionResponse actionResponse) {

		String examScheduleURL = themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_SCHEDULE + CommonConstants.SCOPES
				+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=id"
				+ URLEncoder.encode(" eq " + "'" + ocExamScheduleId + "'", StandardCharsets.UTF_8);

		String examScheduleResponse = omsbHttpConnector.executeGet(examScheduleURL, "",
				omsbCommonApi.getHttpHeaderInfoAndBasicAuth());

		if (Validator.isNotNull(examScheduleResponse)) {

			OCTExamScheduleItems scheduleItems = CustomObjectMapperUtil.readValue(examScheduleResponse,
					OCTExamScheduleItems.class);

			if (Validator.isNotNull(scheduleItems)) {

				OCTExamSchedule examSchedule = new OCTExamSchedule();

				examSchedule.setDepartmentId(scheduleItems.getItems().get(0).getDepartmentId());
				examSchedule.setSectionId(scheduleItems.getItems().get(0).getSectionId());
				examSchedule.setExamDate(scheduleItems.getItems().get(0).getExamDate());
//				examSchedule.setExamEndTime(scheduleItems.getItems().get(0).getExamEndTime());
//				examSchedule.setExamTime(scheduleItems.getItems().get(0).getExamTime());
				examSchedule.setId(scheduleItems.getItems().get(0).getId());
				examSchedule.setLocationOnGoogleMap(scheduleItems.getItems().get(0).getLocationOnGoogleMap());
				examSchedule.setNoOfSeats(scheduleItems.getItems().get(0).getNoOfSeats());
				examSchedule.setOctExamDefinitionId(scheduleItems.getItems().get(0).getOctExamDefinitionId());

				ListTypeEntry listTypeEntry = omsbCommonApi.getListTypeEntryByListTypeItemKey(
						LRPicklistConstants.PL_EXAM_STATUS, "blocked", themeDisplay.getCompanyId());

				examSchedule.setExamStatusId(listTypeEntry.getListTypeEntryId());

				String examScheduleUrl = themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_SCHEDULE
						+ scheduleItems.getItems().get(0).getId();
				String examScheduleMapper = CustomObjectMapperUtil.writeValueAsString(examSchedule, null);
				omsbHttpConnector.executePut(examScheduleUrl, examScheduleMapper,
						omsbCommonApi.getHttpHeaderInfoAndBasicAuth());

				actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommandNames.VIEW_OCT_EXAM_SCHEDULE_LIST_RENDER);
			}
		}
	}

	private void changeExamScheduleStatusAsCanceled(long ocExamScheduleId, ThemeDisplay themeDisplay,
			ActionResponse actionResponse) {

		String examScheduleURL = themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_SCHEDULE + CommonConstants.SCOPES
				+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=id"
				+ URLEncoder.encode(" eq " + "'" + ocExamScheduleId + "'", StandardCharsets.UTF_8);

		String examScheduleResponse = omsbHttpConnector.executeGet(examScheduleURL, "",
				omsbCommonApi.getHttpHeaderInfoAndBasicAuth());

		if (Validator.isNotNull(examScheduleResponse)) {

			OCTExamScheduleItems scheduleItems = CustomObjectMapperUtil.readValue(examScheduleResponse,
					OCTExamScheduleItems.class);

			if (Validator.isNotNull(scheduleItems)) {

				OCTExamSchedule examSchedule = new OCTExamSchedule();

				examSchedule.setDepartmentId(scheduleItems.getItems().get(0).getDepartmentId());
				examSchedule.setSectionId(scheduleItems.getItems().get(0).getSectionId());
				examSchedule.setExamDate(scheduleItems.getItems().get(0).getExamDate());
//				examSchedule.setExamEndTime(scheduleItems.getItems().get(0).getExamEndTime());
//				examSchedule.setExamTime(scheduleItems.getItems().get(0).getExamTime());
				examSchedule.setId(scheduleItems.getItems().get(0).getId());
				examSchedule.setLocationOnGoogleMap(scheduleItems.getItems().get(0).getLocationOnGoogleMap());
				examSchedule.setNoOfSeats(scheduleItems.getItems().get(0).getNoOfSeats());
				examSchedule.setOctExamDefinitionId(scheduleItems.getItems().get(0).getOctExamDefinitionId());

				ListTypeEntry listTypeEntry = omsbCommonApi.getListTypeEntryByListTypeItemKey(
						LRPicklistConstants.PL_EXAM_STATUS, "cancelled", themeDisplay.getCompanyId());

				examSchedule.setExamStatusId(listTypeEntry.getListTypeEntryId());

				String examScheduleUrl = themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_SCHEDULE
						+ scheduleItems.getItems().get(0).getId();
				String examScheduleMapper = CustomObjectMapperUtil.writeValueAsString(examSchedule, null);
				omsbHttpConnector.executePut(examScheduleUrl, examScheduleMapper,
						omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
				actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommandNames.VIEW_OCT_EXAM_SCHEDULE_LIST_RENDER);
			}
		}
	}

	private void rescheduleExam(long ocExamScheduleId, ThemeDisplay themeDisplay, ActionResponse actionResponse) {

		String examScheduleURL = themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_SCHEDULE + CommonConstants.SCOPES
				+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=id"
				+ URLEncoder.encode(" eq " + "'" + ocExamScheduleId + "'", StandardCharsets.UTF_8);

		String examScheduleResponse = omsbHttpConnector.executeGet(examScheduleURL, "",
				omsbCommonApi.getHttpHeaderInfoAndBasicAuth());

		if (Validator.isNotNull(examScheduleResponse)) {

			OCTExamScheduleItems scheduleItems = CustomObjectMapperUtil.readValue(examScheduleResponse,
					OCTExamScheduleItems.class);

			if (Validator.isNotNull(scheduleItems)) {

				String examDefinitionURL = themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_DEFINITION
						+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId()
						+ StringPool.QUESTION + "filter=id"
						+ URLEncoder.encode(
								" eq " + "'" + scheduleItems.getItems().get(0).getOctExamDefinitionId() + "'",
								StandardCharsets.UTF_8);

				String examDefinitionResponse = omsbHttpConnector.executeGet(examDefinitionURL, "",
						omsbCommonApi.getHttpHeaderInfoAndBasicAuth());

				if (Validator.isNotNull(examDefinitionResponse)) {

					OCTExamDefinitionItems definitionItems = CustomObjectMapperUtil.readValue(examDefinitionResponse,
							OCTExamDefinitionItems.class);

					if (Validator.isNotNull(definitionItems)) {

						String examURL = themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM + CommonConstants.SCOPES
								+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=id"
								+ URLEncoder.encode(
										" eq " + "'" + definitionItems.getItems().get(0).getoCExamId() + "'",
										StandardCharsets.UTF_8);

						String examResponse = omsbHttpConnector.executeGet(examURL, "",
								omsbCommonApi.getHttpHeaderInfoAndBasicAuth());

						if (Validator.isNotNull(examResponse)) {

							OCTExamItems examItems = CustomObjectMapperUtil.readValue(examResponse, OCTExamItems.class);

							if (Validator.isNotNull(examItems)) {

								String examJson = examItems.getItems().get(0).getExamJson();

								try {

									JSONObject jsonObject = JSONFactoryUtil.createJSONObject(examJson);

									long autoReschedulingDays = Long
											.parseLong(jsonObject.getString("autoSchedulingPeriod"));

									String examDate = scheduleItems.getItems().get(0).getExamDate();

									Instant instant = Instant.parse(examDate);

									LocalDate examLocalDate = instant.atZone(ZoneId.of("UTC")).toLocalDate();

									LocalDate rescheduledDate = examLocalDate.plusDays(autoReschedulingDays);

									Instant rescheduledInstant = rescheduledDate.atStartOfDay(ZoneId.of("UTC"))
											.toInstant();

									String rescheduledDateString = rescheduledInstant.toString();

									OCTExamSchedule examSchedule = new OCTExamSchedule();

									examSchedule.setDepartmentId(scheduleItems.getItems().get(0).getDepartmentId());
									examSchedule.setSectionId(scheduleItems.getItems().get(0).getSectionId());
									examSchedule.setExamDate(rescheduledDateString);
									examSchedule.setId(scheduleItems.getItems().get(0).getId());
									examSchedule.setLocationOnGoogleMap(
											scheduleItems.getItems().get(0).getLocationOnGoogleMap());
									examSchedule.setNoOfSeats(scheduleItems.getItems().get(0).getNoOfSeats());
									examSchedule.setOctExamDefinitionId(
											scheduleItems.getItems().get(0).getOctExamDefinitionId());

									ListTypeEntry listTypeEntry = omsbCommonApi.getListTypeEntryByListTypeItemKey(
											LRPicklistConstants.PL_EXAM_STATUS, "announced",
											themeDisplay.getCompanyId());

									examSchedule.setExamStatusId(listTypeEntry.getListTypeEntryId());

									String examScheduleUrl = themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_SCHEDULE
											+ scheduleItems.getItems().get(0).getId();
									String examScheduleMapper = CustomObjectMapperUtil.writeValueAsString(examSchedule,
											null);
									omsbHttpConnector.executePut(examScheduleUrl, examScheduleMapper,
											omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
									actionResponse.getRenderParameters().setValue("mvcRenderCommandName",
											MVCCommandNames.VIEW_OCT_EXAM_SCHEDULE_LIST_RENDER);

								} catch (Exception e) {

									logger.error("JSON Exception " + e.getMessage());
								}
							}
						}
					}
				}
			}
		}
	}

	private String readXMLData(String content, String Key) {
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

	private String getBeforeExamTime(String examTime) {

		int minutesToSubtract = 30;
		SimpleDateFormat inputFormat = new SimpleDateFormat("hh:mm a");
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		try {
			Date parsedDate = inputFormat.parse(examTime);
			calendar.setTime(parsedDate);
			calendar.add(java.util.Calendar.MINUTE, -minutesToSubtract);
			return inputFormat.format(calendar.getTime());
		} catch (ParseException e) {
			logger.info(e.getMessage());
		}

		return examTime;
	}

	public long saveOCExamScheduleAdmin(String examTime, String examEndTime, String daysOfWeek,
			boolean repeatedInstance, String examStartDate, String examEndDate, String locationOnGoogleMap,
			String venue, long octExamDepartmentId, long octExamSectionId, ActionRequest actionRequest,
			ThemeDisplay themeDisplay) {
		try {
			OCTExamSchedule examSchedule = new OCTExamSchedule();

			examSchedule.setDepartmentId(octExamDepartmentId);
			examSchedule.setSectionId(octExamSectionId);
			if (Validator.isNotNull(examStartDate)) {
				examSchedule.setExamStartDate(omsbCommonApi.convertDDMMYYYYDateToObjectDate(examStartDate));
			}
			if (Validator.isNotNull(examEndDate)) {
				examSchedule.setExamEndDate(omsbCommonApi.convertDDMMYYYYDateToObjectDate(examEndDate));
			}
//			examSchedule.setExamTime(examTime);
//			examSchedule.setExamEndTime(examEndTime);
			examSchedule.setLocationOnGoogleMap(locationOnGoogleMap);
			examSchedule.setOctExamDefinitionId(octExamDepartmentId);
			examSchedule.setVenue(venue);
			String examScheduleMapper = CustomObjectMapperUtil.writeValueAsString(examSchedule, null);
			String url = themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_SCHEDULE_ADMIN_URL+ CommonConstants.SCOPES + StringPool.SLASH
					+ themeDisplay.getScopeGroupId();
			logger.info("url for exam schedule admin:"+url);
			String response = omsbHttpConnector.executePost(url, examScheduleMapper,
					omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
			logger.info("response for exam schedule admin:"+response);
			OCTExamSchedule octExamSchedule = CustomObjectMapperUtil.readValue(response,
					OCTExamSchedule.class);
			if (Validator.isNotNull(octExamSchedule)) {
				logger.info("exam schedule admin id:"+octExamSchedule.getId());
				return octExamSchedule.getId();
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return 0;
	}

	@Reference(unbind = "-")
	private OMSBHttpConnector omsbHttpConnector;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference(unbind = "-")
	private OCTScheduleUtil octScheduleUtil;

	@Reference(unbind = "-")
	private OCTExamUtil octExamUtil;

	@Reference(unbind = "-")
	private OCTNotificationUtil octNotificationUtil;

	@Reference
	UserNotificationEventLocalService userNotificationEventLocalService;

	@Reference
	private CalendarBookingLocalService _calendarBookingLocalService;

	private Log logger = LogFactoryUtil.getLog(AddOCTExamScheduleMVCActionCommand.class);
}
