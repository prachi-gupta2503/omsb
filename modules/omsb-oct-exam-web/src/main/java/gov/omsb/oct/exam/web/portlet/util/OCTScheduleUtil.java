package gov.omsb.oct.exam.web.portlet.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.liferay.calendar.model.Calendar;
import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.model.CalendarResource;
import com.liferay.calendar.service.CalendarBookingLocalService;
import com.liferay.calendar.service.CalendarBookingLocalServiceUtil;
import com.liferay.calendar.service.CalendarLocalServiceUtil;
import com.liferay.calendar.service.CalendarResourceLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
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
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.portlet.dto.OCTExam;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamBlueprint;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamCancellationFees;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamDefinition;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamDefinitionItem;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamDetails;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamFormNumber;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamJsonFields;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamMultiDates;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamSchedule;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamScheduleAdmin;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamScheduleAdminItems;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamScheduleItems;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamScheduleMultiDatesItem;
import gov.omsb.oct.exam.web.portlet.dto.OCTMultiDateItems;
import gov.omsb.oct.exam.web.portlet.dto.OCTRegularFees;
import gov.omsb.oct.exam.web.portlet.dto.OCTRescheduleFees;

@Component(immediate = true, service = OCTScheduleUtil.class)
public class OCTScheduleUtil {

	public OCTExamDefinitionItem getExamDefinitionById(ThemeDisplay themeDisplay, long examDefinitionId) {

		log.info("---getExamDefinitionById");
		String getUrl = themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_DEFINITION_URL + examDefinitionId;
		String response = commonApi.getData(getUrl);
		log.info("response of getExamDefinitionById ??" + response);
		return CustomObjectMapperUtil.readValue(response, OCTExamDefinitionItem.class);
	}

	public void addCalenderEvent(ServiceContext serviceContext, OCTExamSchedule octExamSchedule) {

		try {
			log.info("octExamSchedule::" + octExamSchedule.getId());
			/* set event */
			String calenderTitle = "";
			OCTExamDefinition octExamDefinition = octExamUtil.getOCTExamDefinitionByDefinitionId(
					octExamSchedule.getOctExamDefinitionId(), serviceContext.getPortalURL());
			if (Validator.isNotNull(octExamSchedule)) {

				long getoCExamTitleId = octExamDefinition.getoCExamTitleId();
				if (getoCExamTitleId > 0) {
					ListTypeEntry entry = ListTypeEntryLocalServiceUtil
							.getListTypeEntry(octExamDefinition.getoCExamTitleId());
					if (Validator.isNotNull(entry)) {
						calenderTitle = entry.getName(serviceContext.getLocale());
						log.info("octExamSchedule.getId() ::" + octExamSchedule.getId());
						calenderTitle = calenderTitle + "_" + octExamSchedule.getId();
					}
				}
			}

			User user = UserLocalServiceUtil.getUser(serviceContext.getUserId());
			List<CalendarResource> calendarResources = CalendarResourceLocalServiceUtil
					.getCalendarResources(serviceContext.getScopeGroupId());
			if (!calendarResources.isEmpty()) {

				List<Calendar> calendars = CalendarLocalServiceUtil.getCalendarResourceCalendars(
						serviceContext.getScopeGroupId(), calendarResources.get(0).getCalendarResourceId());
				if (!calendars.isEmpty()) {

					CalendarBooking calendarBooking = CalendarBookingLocalServiceUtil
							.createCalendarBooking(CounterLocalServiceUtil.increment());

					calendarBooking.setCalendarId(calendars.get(0).getCalendarId());
					calendarBooking.setCalendarBookingId(calendarBooking.getCalendarBookingId());
					calendarBooking.setUserId(serviceContext.getUserId());
					calendarBooking.setUserName(user.getFullName());
					calendarBooking.setGroupId(user.getGroupId());
					calendarBooking.setCalendarResourceId(calendars.get(0).getCalendarResourceId());
					calendarBooking.setParentCalendarBookingId(calendarBooking.getCalendarBookingId());
					calendarBooking.setRecurringCalendarBookingId(calendarBooking.getCalendarBookingId());

//					calendarBooking.setTitle(calenderTitle+"_"+octExamSchedule.getoCExamScheduleId(), serviceContext.getLocale());
					// calendarBooking.setDescription(calenderTitle+"_"+octExamSchedule.getoCExamScheduleId());
					calendarBooking.setTitle(calenderTitle, serviceContext.getLocale());
					calendarBooking.setDescription(calenderTitle);

					String isoFormat = "yyyy-MM-dd'T'HH:mm:ss'Z'";
					String timeFormatwithAMPM = "hh:mm a";
					String timeFormat = "hh:mm";
					SimpleDateFormat isoSdf = new SimpleDateFormat(isoFormat);
					Date isoDateTime = isoSdf.parse(octExamSchedule.getExamDate());
					SimpleDateFormat timeSdf = null;
					if (octExamSchedule.getExamSlot().contains("Am") || octExamSchedule.getExamSlot().contains("PM")) {

						timeSdf = new SimpleDateFormat(timeFormatwithAMPM);
					} else {
						timeSdf = new SimpleDateFormat(timeFormat);
					}
					Date startTime = timeSdf.parse(octExamSchedule.getExamSlot());
//					Date endTime = timeSdf.parse(octExamSchedule.getExamEndTime());

					isoDateTime.setHours(startTime.getHours());
					isoDateTime.setMinutes(startTime.getMinutes());

					calendarBooking.setStartTime(isoDateTime.getTime());
//					isoDateTime.setHours(endTime.getHours());
//					isoDateTime.setMinutes(endTime.getMinutes());

					calendarBooking.setEndTime(isoDateTime.getTime());
					log.info("calendarBooking::" + calendarBooking.getTitle());
					_calendarBookingLocalService.updateCalendarBooking(calendarBooking);
				}
			}

		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}

	public long createOCTExamDefinition(long octExamId, ThemeDisplay themeDisplay) {
		long examDefinitionId = 0L;

		try {
			OCTExamDetails octExamDetails = octExamUtil.getOCTExamDetailsListByExamId(octExamId,
					themeDisplay.getCompanyId(), themeDisplay.getScopeGroupId(), themeDisplay.getPortalURL(),
					themeDisplay.getLocale());
			if (Validator.isNotNull(octExamDetails)) {
				if (octExamDetails.isModified()) {
					OCTExamJsonFields octExamJsonFields = octExamDetails.getExamJson();

					if (Validator.isNotNull(octExamJsonFields)) {
						OCTExamDefinition octExamDefinition = prepareExamDefinition(octExamJsonFields, octExamId);
						String createOCTExamDefinitionResponse = octExamUtil.saveExamDefition(octExamDefinition,
								octExamId, themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId());
						if (Validator.isNotNull(createOCTExamDefinitionResponse)) {
							OCTExamDefinition createdOCTExamDefinition = CustomObjectMapperUtil
									.readValue(createOCTExamDefinitionResponse, OCTExamDefinition.class);
							examDefinitionId = createdOCTExamDefinition.getId();

							// save value in exam regular fees
							if (octExamJsonFields.getOctRegularFees().size() > 0) {
								for (OCTRegularFees octRegularFees : octExamJsonFields.getOctRegularFees()) {
									octRegularFees.setOctExamDefinitionId(examDefinitionId);
									octExamUtil.saveRegularFees(octRegularFees, examDefinitionId,
											themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId());
								}
							}

							// save value in exam cancellation fees
							if (octExamJsonFields.getOctExamCancellationFees().size() > 0) {
								for (OCTExamCancellationFees octExamCancellationFees : octExamJsonFields
										.getOctExamCancellationFees()) {
									octExamCancellationFees.setOctExamDefinitionId(examDefinitionId);
									octExamUtil.saveOCTExamCancellationFees(octExamCancellationFees, examDefinitionId,
											themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId());
								}
							}

							// save value in exam rescheduling fees
							if (octExamJsonFields.getOctRescheduleFees().size() > 0) {
								for (OCTRescheduleFees octRescheduleFees : octExamJsonFields.getOctRescheduleFees()) {
									octRescheduleFees.setOctExamDefinitionId(examDefinitionId);
									octExamUtil.saveRescheduleFees(octRescheduleFees, examDefinitionId,
											themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId());
								}
							}

							// save value in exam blue print
							if (octExamJsonFields.getOctExamBlueprints().size() > 0) {
								for (OCTExamBlueprint octExamBlueprint : octExamJsonFields.getOctExamBlueprints()) {
									octExamBlueprint.setOctExamDefinitionId(examDefinitionId);
									octExamUtil.saveExamBlueprint(octExamBlueprint, examDefinitionId,
											themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId());
								}
							}

							// save exam form number
							if (octExamJsonFields.getOctExamFormNumbers().size() > 0) {
								for (OCTExamFormNumber octExamFormNumber : octExamJsonFields.getOctExamFormNumbers()) {
									octExamFormNumber.setOctExamDefinitionId(examDefinitionId);
									octExamUtil.saveOCTExamFormNumber(octExamFormNumber, examDefinitionId,
											themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId());
								}
							}

							// update oct exam modify false
							OCTExam octExam = octExamUtil.getOCTExamByUserId(octExamId, themeDisplay.getPortalURL());
							if (Validator.isNotNull(octExam)) {
								octExam.setModified(false);
								octExamUtil.updateOCTExam(octExam, octExamId, octExamDetails,
										themeDisplay.getPortalURL());
							}
						}
					}
				}
			}
		} catch (JsonProcessingException e) {

			log.error(e.getMessage(), e);

		}

		return examDefinitionId;
	}

	public OCTExamDefinition prepareExamDefinition(OCTExamJsonFields octExamJsonFields, long octExamId) {
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
		octExamDefinition.setAutoSchedulingPeriod(octExamJsonFields.getAutoSchedulingPeriod());
		octExamDefinition.setEligibilityCheck(octExamJsonFields.isEligibilityCheck());
		octExamDefinition.setApplyEligibility(octExamJsonFields.isApplyEligibility());
		octExamDefinition.setOmaniMaxAttempts(octExamJsonFields.getOmaniMaxAttempts());
		octExamDefinition.setOmaniMaxTimePeriod(octExamJsonFields.getOmaniTimePeriod());
		octExamDefinition.setOmaniTimePeriod(octExamJsonFields.getOmaniMaxTimePeriod());
		octExamDefinition.setNonOmaniMaxAttempts(octExamJsonFields.getNonOmaniMaxAttempts());
		octExamDefinition.setNonOmaniMaxTimePeriod(octExamJsonFields.getNonOmaniMaxTimePeriod());
		octExamDefinition.setNonOmaniTimePeriod(octExamJsonFields.getNonOmaniTimePeriod());
		log.info("return oct Exam definition ");
		return octExamDefinition;

	}

	public void saveOCTExamScheduleSingleInstance(long examDefinitionId, long octExamId, ActionRequest actionRequest,
			ActionResponse actionResponse, ThemeDisplay themeDisplay, String repeatedInstanceDuplicateRowValues,
			long roleId,long ocExamScheduleAdminId,long octScheduleId) {

		try {
			OCTExamSchedule examScheduleResp = new OCTExamSchedule();
			log.info("Single Instance method .... " + examDefinitionId);
			String registrationStartDate = ParamUtil.getString(actionRequest, "siRegistrationStartDate");
			String registrationEndDate = ParamUtil.getString(actionRequest, "siRegistrationEndDate");
			String examDate = ParamUtil.getString(actionRequest, "siExamDate");
			int noOfSeats = ParamUtil.getInteger(actionRequest, "siNoOfSeats");
			String examStatus = ParamUtil.getString(actionRequest, "siCMD");
			String locationOnGoogleMap = ParamUtil.getString(actionRequest, "siLocationOnGoogleMap");
			String venue = ParamUtil.getString(actionRequest, "siVenue");

			String department = ParamUtil.getString(actionRequest, "siDepartmentId");
			String section = ParamUtil.getString(actionRequest, "siSectionId");
			String[] examSlotList = ParamUtil.getStringValues(actionRequest, "siExamSlotList");
			long examCenter = ParamUtil.getLong(actionRequest, "siTrainingSite");
			String octScheduleResponse =StringPool.BLANK;
			ListTypeEntry listEntry = commonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.DEPARTMENT,
					department, themeDisplay.getCompanyId());

			ListTypeEntry listTypeEntry = commonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.SECTION,
					section, themeDisplay.getCompanyId());
			long departmentListTypeEntryId = 0;
			long sectionListTypeEntryId = 0;
			if (Validator.isNotNull(listEntry)) {
				departmentListTypeEntryId = listEntry.getListTypeEntryId();
			}
			if (Validator.isNotNull(listTypeEntry)) {
				sectionListTypeEntryId = listTypeEntry.getListTypeEntryId();
			}
			
			OCTExamScheduleAdmin ocExamScheduleAdmin = saveOCExamScheduleAdmin( registrationStartDate,  registrationEndDate,
					 examDate,  noOfSeats,  examStatus,  locationOnGoogleMap,
					 venue, departmentListTypeEntryId,  sectionListTypeEntryId,
					 examCenter,  ocExamScheduleAdminId,  examSlotList.toString(), themeDisplay);
			for (String examSlot : examSlotList) {

				OCTExamSchedule octExamSchedule=getOCExamScheduleByScheduleId(themeDisplay, octScheduleId);
				
				if(Validator.isNotNull(octExamSchedule) ) {
					
					 octExamSchedule = prepareOCTExamSchedule(registrationStartDate, registrationEndDate,
							 examDate, noOfSeats, examStatus, examDefinitionId, locationOnGoogleMap, venue,
							departmentListTypeEntryId, sectionListTypeEntryId, themeDisplay.getLocale(),
							themeDisplay.getCompanyId(), examCenter, ocExamScheduleAdmin.getId(), examSlot, octExamSchedule);
					String examScheduleMapper = CustomObjectMapperUtil
							.writeValueAsString(octExamSchedule, null);
					 octScheduleResponse = omsbHttpConnector.executePut(themeDisplay.getPortalURL()
							+ LRObjectURL.OC_EXAM_SCHEDULE + octExamSchedule.getId(),
							examScheduleMapper, commonApi.getHttpHeaderInfoAndBasicAuth());
					examScheduleResp = CustomObjectMapperUtil.readValue(octScheduleResponse,
							OCTExamSchedule.class);
					
				}else {
					octExamSchedule= new OCTExamSchedule();
					 octExamSchedule = prepareOCTExamSchedule(registrationStartDate, registrationEndDate,
							 examDate, noOfSeats, examStatus, examDefinitionId, locationOnGoogleMap, venue,
							departmentListTypeEntryId, sectionListTypeEntryId, themeDisplay.getLocale(),
							themeDisplay.getCompanyId(), examCenter, ocExamScheduleAdmin.getId(), examSlot,octExamSchedule);
					 octScheduleResponse = octExamUtil.saveOCTExamSchedule(octExamSchedule,
							themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId());
					examScheduleResp = CustomObjectMapperUtil.readValue(octScheduleResponse,
							OCTExamSchedule.class);
				}
				
				

				log.info("Exam Schedule Response = ... " + examScheduleResp);
				if (Validator.isNotNull(examScheduleResp) && examStatus.equalsIgnoreCase("Announced")) {

					octNotificationUtil.sendNotificationToUsers(themeDisplay.getPortalURL(), examStatus,
							themeDisplay.getScopeGroupId(), themeDisplay.getCompanyId(), themeDisplay.getLocale(),
							roleId, octExamSchedule);

					try {
						if (Validator.isNotNull(examScheduleResp)) {
							OCTExamSchedule examScheduleItems = CustomObjectMapperUtil.readValue(octScheduleResponse,
									OCTExamSchedule.class);
							ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
							addCalenderEvent(serviceContext, examScheduleItems);
						}
					} catch (PortalException e) {
						log.info(e.getMessage());
					}
					
					actionResponse.setRenderParameter("mvcRenderCommandName",MVCCommandNames.VIEW_OCT_EXAM_SCHEDULE_LIST_RENDER);
				}
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		}

	}

	public OCTExamScheduleAdmin addOrUpdateOCTExamScheduleAdmin(long octExamScheduleAdminId, long examDefinitionId,
			String riExamStartDate, String riExamEndDate, long riDepartmentId, long riSectionId,
			String riLocationOnGoogleMap, String riVenue, boolean isRepeatedInstance, ThemeDisplay themeDisplay,
			Date applicationStartDate, Date applicationEndDate) {

		OCTExamScheduleAdmin examScheduleAdmin = new OCTExamScheduleAdmin();
		OCTExamScheduleAdmin examScheduleAdminResponseObj = new OCTExamScheduleAdmin();

		try {

			
			examScheduleAdmin.setDepartmentId(riDepartmentId);
			examScheduleAdmin.setSectionId(riSectionId);
			examScheduleAdmin.setExamStartDate(commonApi.convertDDMMYYYYDateToObjectDate(riExamStartDate));
			examScheduleAdmin.setExamEndDate(commonApi.convertDDMMYYYYDateToObjectDate(riExamEndDate));
			examScheduleAdmin.setLocationOnGoogleMap(riLocationOnGoogleMap);
			examScheduleAdmin.setoCExamDefinitionId(examDefinitionId);
			examScheduleAdmin.setVenue(riVenue);
			examScheduleAdmin.setRepeatedInstance(isRepeatedInstance);
			examScheduleAdmin.setRegistrationStartDate(commonApi.convertDateToObjectDateString(applicationStartDate));
			examScheduleAdmin.setRegistrationEndDate(commonApi.convertDateToObjectDateString(applicationEndDate));
			 
			

			if (octExamScheduleAdminId == 0) {

				String examScheduleAdminMapper = CustomObjectMapperUtil.writeValueAsString(examScheduleAdmin, null);

				String examScheduleAdminURL = themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_SCHEDULE_ADMIN_URL
						+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId();

				String examScheduleAdminResponse = omsbHttpConnector.executePost(examScheduleAdminURL,
						examScheduleAdminMapper, commonApi.getHttpHeaderInfoAndBasicAuth());

				examScheduleAdminResponseObj = CustomObjectMapperUtil.readValue(examScheduleAdminResponse,
						OCTExamScheduleAdmin.class);

			} else if (octExamScheduleAdminId > 0) {

				String examScheduleAdminMapper = CustomObjectMapperUtil.writeValueAsString(examScheduleAdmin, null);

				String examScheduleAdminResponse = omsbHttpConnector.executePut(
						themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_SCHEDULE_ADMIN_URL + octExamScheduleAdminId,
						examScheduleAdminMapper, commonApi.getHttpHeaderInfoAndBasicAuth());

				examScheduleAdminResponseObj = CustomObjectMapperUtil.readValue(examScheduleAdminResponse,
						OCTExamScheduleAdmin.class);

			}
		} catch (Exception e) {
			return null;
		}
		return examScheduleAdminResponseObj;
	}

	public OCTExamScheduleAdmin saveOCExamScheduleAdmin(String registrationStartDate, String registrationEndDate,
			String examDate, int noOfSeats, String examStatus, String locationOnGoogleMap,
			String venue, long octExamDepartmentId, long octExamSectionId,
			long examCenter, long octExamScheduleAdminId, String examSlot,ThemeDisplay themeDisplay) {

		try {
			OCTExamScheduleAdmin examScheduleAdminResponseObj = new OCTExamScheduleAdmin();

			OCTExamScheduleAdmin examScheduleadmin = new OCTExamScheduleAdmin();

			if (Validator.isNotNull(registrationStartDate)) {
				examScheduleadmin.setRegistrationStartDate(commonApi.convertDDMMYYYYDateToObjectDate(registrationStartDate));
			}if (Validator.isNotNull(registrationEndDate)) {
				examScheduleadmin.setRegistrationEndDate(commonApi.convertDDMMYYYYDateToObjectDate(registrationEndDate));
			}if (Validator.isNotNull(examDate)) {
				examScheduleadmin.setExamDate(commonApi.convertDDMMYYYYDateToObjectDate(examDate));
			}
			examScheduleadmin.setNoOfSeats(noOfSeats);
			examScheduleadmin.setExamCenter(examCenter);
			examScheduleadmin.setExamSlot(examSlot);
			examScheduleadmin.setDepartmentId(octExamDepartmentId);
			examScheduleadmin.setSectionId(octExamSectionId);
			examScheduleadmin.setLocationOnGoogleMap(locationOnGoogleMap);
			examScheduleadmin.setVenue(venue);
			
			
			if (octExamScheduleAdminId == 0) {

				String examScheduleAdminMapper = CustomObjectMapperUtil.writeValueAsString(examScheduleadmin, null);

				String examScheduleAdminURL = themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_SCHEDULE_ADMIN_URL
						+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId();

				String examScheduleAdminResponse = omsbHttpConnector.executePost(examScheduleAdminURL,
						examScheduleAdminMapper, commonApi.getHttpHeaderInfoAndBasicAuth());

				examScheduleAdminResponseObj = CustomObjectMapperUtil.readValue(examScheduleAdminResponse,
						OCTExamScheduleAdmin.class);

			} else if (octExamScheduleAdminId > 0) {

				String examScheduleAdminMapper = CustomObjectMapperUtil.writeValueAsString(examScheduleadmin, null);

				String examScheduleAdminResponse = omsbHttpConnector.executePut(
						themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_SCHEDULE_ADMIN_URL + octExamScheduleAdminId,
						examScheduleAdminMapper, commonApi.getHttpHeaderInfoAndBasicAuth());

				examScheduleAdminResponseObj = CustomObjectMapperUtil.readValue(examScheduleAdminResponse,
						OCTExamScheduleAdmin.class);

			}
			return examScheduleAdminResponseObj;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return null;
		}
		
	}

	public OCTExamSchedule prepareOCTExamSchedule(String registrationStartDate, String registrationEndDate,
			String examStartDate, int noOfSeats, String examStatus, long examDefinitionId, String locationOnGoogleMap,
			String venue, long octExamDepartmentId, long octExamSectionId, Locale locale, long companyId,
			long examCenter, long octExamScheduleAdminId, String examSlot,OCTExamSchedule octExamSchedule) {
		if (Validator.isNotNull(registrationStartDate)) {
			octExamSchedule.setRegistrationStartDate(commonApi.convertDDMMYYYYDateToObjectDate(registrationStartDate));
		}

		if (Validator.isNotNull(registrationEndDate)) {
			octExamSchedule.setRegistrationEndDate(commonApi.convertDDMMYYYYDateToObjectDate(registrationEndDate));
		}

		if (Validator.isNotNull(examStartDate)) {
			octExamSchedule.setExamDate(commonApi.convertDDMMYYYYDateToObjectDate(examStartDate));
		}

		octExamSchedule.setExamSlot(examSlot);
		octExamSchedule.setNoOfSeats(noOfSeats);
		octExamSchedule.setLocationOnGoogleMap(locationOnGoogleMap);
		octExamSchedule.setVenue(venue);
		octExamSchedule.setDepartmentId(octExamDepartmentId);
		octExamSchedule.setSectionId(octExamSectionId);
		octExamSchedule.setSectionId(octExamSectionId);
		octExamSchedule.setExamCenter(examCenter);
		octExamSchedule.setoCExamScheduleAdminId(octExamScheduleAdminId);
		octExamSchedule.setRepeatedInstance(false);
		if (Validator.isNotNull(examStatus)) {
			List<ListTypeEntry> listTypeEntry = commonApi.getListTypeEntriesByERC(LRPicklistConstants.PL_EXAM_STATUS,
					PortalUtil.getDefaultCompanyId());
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

	public OCTExamSchedule saveOCTExamScheduleRepeatedInstance(long examDefinitionId, long octExamId,
			long octExamScheduleAdminId, ThemeDisplay themeDisplay, long roleId, String repeatedInstanceArrayString,
			String riDepartmentId, String riSectionId, String riLocationOnGoogleMap, String riExamStartDate,
			String riExamEndDate, String riVenue, long riDaysOfWeek1, long examCenter, long riNoOfSeats,
			long riExamSlotsId, String status,String riApplicationStartDate,String riApplicationEndDate) {

		OCTExamSchedule examScheduleResp = new OCTExamSchedule();
		OCTExamSchedule octExamSchedule= new OCTExamSchedule();
		ListTypeEntry listEntry = commonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.DEPARTMENT,
				riDepartmentId, themeDisplay.getCompanyId());

		ListTypeEntry listTypeEntry = commonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.SECTION,
				riSectionId, themeDisplay.getCompanyId());

		long departmentListTypeEntryId = 0;
		long sectionListTypeEntryId = 0;
		if (Validator.isNotNull(listEntry)) {
			departmentListTypeEntryId = listEntry.getListTypeEntryId();
		}
		if (Validator.isNotNull(listTypeEntry)) {
			sectionListTypeEntryId = listTypeEntry.getListTypeEntryId();
		}

		try {
			JSONArray jsonArray = JSONFactoryUtil.createJSONArray(repeatedInstanceArrayString);
			log.info("JSONArray  JSONArray  ....  " + jsonArray.length());
			if (Validator.isNotNull(jsonArray)) {

				Date octExamStartDate = commonApi.convertStringToDate(riExamStartDate);
				LocalDate examStartLocalDate = octExamStartDate.toInstant().atZone(ZoneId.systemDefault())
						.toLocalDate();
				Date octExamEndDate = commonApi.convertStringToDate(riExamEndDate);
				LocalDate examEndLocalDate = octExamEndDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				long numOfDays = ChronoUnit.DAYS.between(examStartLocalDate, examEndLocalDate);
				Date applicationStartDate = commonApi.convertStringToDate(riApplicationStartDate);
				Date applicationEndDate = commonApi.convertStringToDate(riApplicationEndDate);
				
				
				// Update ExamScheduleAdmin object
				OCTExamScheduleAdmin admin = addOrUpdateOCTExamScheduleAdmin(octExamScheduleAdminId, examDefinitionId,
						riExamStartDate, riExamEndDate, departmentListTypeEntryId, sectionListTypeEntryId, riLocationOnGoogleMap, riVenue, true,
						themeDisplay,applicationStartDate,applicationEndDate);

				// update multidate Object
				String response = "";
				if (Validator.isNotNull(admin)) {
					response = updateExamMultiDateObject(repeatedInstanceArrayString, admin, themeDisplay,
							commonApi.getHttpHeaderInfoAndBasicAuth());
				}
				
				log.info("examStartLocalDate ..  " + examStartLocalDate + "  examEndLocalDate ... "
						+ examEndLocalDate);
				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject valueJson = jsonArray.getJSONObject(i);
					
					String arrayOfWeek=valueJson.getString("dayOfWeek");
					arrayOfWeek=arrayOfWeek.replace("\\", "");
					JSONArray daysOfWeekJsonArray = JSONFactoryUtil.createJSONArray(arrayOfWeek);
					
					log.info("length of array:" + daysOfWeekJsonArray);
					for (int j = 0; j < daysOfWeekJsonArray.length(); j++) {
						final String weekDays = daysOfWeekJsonArray.getString(j);
						if (numOfDays > 0) {
							List<LocalDate> daysRange = Stream.iterate(examStartLocalDate, date -> date.plusDays(1))
									.limit(numOfDays).filter(date -> date.getDayOfWeek() == getDayOfWeek(weekDays))
									.collect(Collectors.toList());
							log.info("daysRange ... " + daysRange);
							if (daysRange.size() > 0) {
								for (LocalDate examDate : daysRange) {
									String newExamDate = commonApi.convertYYYYMMDDLocalDatetoObjectDate(examDate);
									
									riExamStartDate = commonApi.convertObjectDateToDDMMYYYYDate(newExamDate);
									
									int noOfSeats = valueJson.getInt("noOfSeats");
									
									String arrayOfExamSlot=valueJson.getString("examSlotList");
									arrayOfExamSlot=arrayOfExamSlot.replace("\\", "");
									JSONArray examSlotList = JSONFactoryUtil.createJSONArray(arrayOfExamSlot);

									for (Object examSlotObject : examSlotList) {

										String examSlot = String.valueOf(examSlotObject);
										String convertedExamDate=commonApi.convertYYYYMMDDLocalDatetoObjectDate(examDate);
										List<OCTExamSchedule> ec=	getscheduleExamListByScheduleAdminIdAndExamDate(themeDisplay,
												octExamScheduleAdminId,convertedExamDate, examSlot);
										
										if(Validator.isNotNull(ec) && ec.size()>0 ) {
											octExamSchedule=ec.get(0);
											octExamSchedule=prepareOCTRIExamSchedule(riExamStartDate,
													noOfSeats, status, examDefinitionId, riLocationOnGoogleMap, riVenue,
													departmentListTypeEntryId, sectionListTypeEntryId,
													themeDisplay.getLocale(), themeDisplay.getCompanyId(), examSlot,
													admin.getId(),applicationStartDate,applicationEndDate,octExamSchedule);
											String examScheduleMapper = CustomObjectMapperUtil
													.writeValueAsString(octExamSchedule, null);
											String octScheduleResponse = omsbHttpConnector.executePut(themeDisplay.getPortalURL()
													+ LRObjectURL.OC_EXAM_SCHEDULE + ec.get(i).getId(),
													examScheduleMapper, commonApi.getHttpHeaderInfoAndBasicAuth());
											examScheduleResp = CustomObjectMapperUtil.readValue(octScheduleResponse,
													OCTExamSchedule.class);
											
										}else {
											octExamSchedule= new OCTExamSchedule();
											octExamSchedule=prepareOCTRIExamSchedule(riExamStartDate,
													noOfSeats, status, examDefinitionId, riLocationOnGoogleMap, riVenue,
													departmentListTypeEntryId, sectionListTypeEntryId,
													themeDisplay.getLocale(), themeDisplay.getCompanyId(), examSlot,
													admin.getId(),applicationStartDate,applicationEndDate,octExamSchedule);
											String octScheduleResponse = octExamUtil.saveOCTExamSchedule(octExamSchedule,
													themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId());
											examScheduleResp = CustomObjectMapperUtil.readValue(octScheduleResponse,
													OCTExamSchedule.class);
										}
										
										 

										
										if (status.equalsIgnoreCase("Announced")) {

											octNotificationUtil.sendNotificationToUsers(themeDisplay.getPortalURL(),
													status, themeDisplay.getScopeGroupId(), themeDisplay.getCompanyId(),
													themeDisplay.getLocale(), roleId, octExamSchedule);

											/*
											 * try { if (Validator.isNotNull(octScheduleResponse)) { OCTExamSchedule
											 * examScheduleItems = CustomObjectMapperUtil
											 * .readValue(octScheduleResponse, OCTExamSchedule.class); ServiceContext
											 * serviceContext = ServiceContextFactory .getInstance(resourceRequest);
											 * addCalenderEvent(serviceContext, examScheduleItems); } } catch
											 * (PortalException e) { log.info(e.getMessage()); }
											 */

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
			log.info("JSON Exception >>>" + e.getMessage());
		}
		
		return examScheduleResp;
	}

	public List <OCTExamSchedule> getscheduleExamListByScheduleAdminIdAndExamDate(ThemeDisplay themeDisplay, long examScheduleAdminId,
		String examDate,String examSlot) {
		OCTExamScheduleItems examScheduleItem = new OCTExamScheduleItems();
		List <OCTExamSchedule> ec = null;
		try {
			//Date date=new SimpleDateFormat(DataflowConstants.OBJECT_DATE_FORMAT).parse(examDate);
		
		String examScheduleURL = themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_SCHEDULE + CommonConstants.SCOPES
				+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=oCExamScheduleAdminId"
					+ URLEncoder.encode(" eq " + examScheduleAdminId, StandardCharsets.UTF_8)+ "&pageSize=0";
		String examScheduleResponse = commonApi.getData(examScheduleURL);
		examScheduleItem= CustomObjectMapperUtil.readValue(examScheduleResponse, OCTExamScheduleItems.class);
		if(Validator.isNotNull(examScheduleItem)) {
			ec=	examScheduleItem.getItems().stream().filter(n->(n.getExamDate().equalsIgnoreCase(examDate)
					&& n.getExamSlot().equalsIgnoreCase(examSlot))).collect(Collectors.toList());
			
		}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		return ec;
	}
	public DayOfWeek getDayOfWeek(String dayOfWeek) {
		Map<String, DayOfWeek> dayOfWeekMap = new HashMap<>();
		dayOfWeekMap.put("Monday", DayOfWeek.MONDAY);
		dayOfWeekMap.put("Tuesday", DayOfWeek.TUESDAY);
		dayOfWeekMap.put("Wednesday", DayOfWeek.WEDNESDAY);
		dayOfWeekMap.put("Thursday", DayOfWeek.THURSDAY);
		dayOfWeekMap.put("Friday", DayOfWeek.FRIDAY);
		dayOfWeekMap.put("Saturday", DayOfWeek.SATURDAY);
		dayOfWeekMap.put("Sunday", DayOfWeek.SATURDAY);
		return dayOfWeekMap.get(dayOfWeek);
	}

	private OCTExamSchedule prepareOCTRIExamSchedule(String examStartDate, int noOfSeats, String examStatus,
			long examDefinitionId, String locationOnGoogleMap, String venue, long octExamDepartmentId,
			long octExamSectionId, Locale locale, long companyId, String examSlot, long oCExamScheduleAdminId,
			Date applicationStartDate,Date applicationEndDate ,OCTExamSchedule octExamSchedule) {

		if (Validator.isNotNull(examStartDate)) {
			octExamSchedule.setExamDate(commonApi.convertDDMMYYYYDateToObjectDate(examStartDate));
		}

		octExamSchedule.setExamSlot(examSlot);
		octExamSchedule.setNoOfSeats(noOfSeats);
		octExamSchedule.setLocationOnGoogleMap(locationOnGoogleMap);
		octExamSchedule.setVenue(venue);
		octExamSchedule.setDepartmentId(octExamDepartmentId);
		octExamSchedule.setSectionId(octExamSectionId);
		octExamSchedule.setoCExamScheduleAdminId(oCExamScheduleAdminId);
		octExamSchedule.setRepeatedInstance(true);
		octExamSchedule.setRegistrationStartDate(commonApi.convertDateToObjectDateString(applicationStartDate));
		octExamSchedule.setRegistrationEndDate(commonApi.convertDateToObjectDateString(applicationEndDate));
		if (Validator.isNotNull(examStatus)) {
			List<ListTypeEntry> listTypeEntry = commonApi.getListTypeEntriesByERC(LRPicklistConstants.PL_EXAM_STATUS,
					PortalUtil.getDefaultCompanyId());
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

	public OCTExamMultiDates setMultiExamDatesValueFromObj(OCTExamMultiDates octExamMultiDatesObj, JSONObject valueJson,
			long oCExamScheduleAdminId) {
		octExamMultiDatesObj.setDaysOfWeek(valueJson.getString("dayOfWeek"));
		octExamMultiDatesObj.setExamSlot(valueJson.getString("examSlotList"));
		octExamMultiDatesObj.setExamCenter(valueJson.getLong("trainingSite"));
		octExamMultiDatesObj.setNoOfSeats(valueJson.getInt("noOfSeats"));
		octExamMultiDatesObj.setoCExamScheduleAdminId(oCExamScheduleAdminId);
		return octExamMultiDatesObj;
	}

	public String updateExamMultiDateObject(String repeatedInstanceArrayString, OCTExamScheduleAdmin admin,
			ThemeDisplay themeDisplay, Map<String, String> headers) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		String response = "";
		try {
			OCTExamMultiDates octExamMultiDates = new OCTExamMultiDates();
			jsonArray = JSONFactoryUtil.createJSONArray(repeatedInstanceArrayString);
			if (jsonArray.length() > 0) {
				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject valueJson = jsonArray.getJSONObject(i);
					long multExmId = valueJson.getLong("id");

					if (multExmId == 0) {
						// Add Data if Not present in DB
						octExamMultiDates = setMultiExamDatesValueFromObj(octExamMultiDates, valueJson, admin.getId());

						String examMultiDatesMapper = CustomObjectMapperUtil.writeValueAsString(octExamMultiDates,
								null);
						String examMultiDatesURL = themeDisplay.getPortalURL()
								+ LRObjectURL.OC_EXAM_SCHEDULE_MULTI_DATES + CommonConstants.SCOPES + StringPool.SLASH
								+ themeDisplay.getScopeGroupId();
						response = omsbHttpConnector.executePost(examMultiDatesURL, examMultiDatesMapper, headers);

					} else {
						// update Data if already present in DB
						OCTExamScheduleMultiDatesItem multiDatesItem = getExamMultiDatesItemBasedOnMultExamDateId(
								themeDisplay, multExmId);

						if (Validator.isNotNull(multiDatesItem)) {
							octExamMultiDates = setMultiExamDatesValueFromObj(multiDatesItem.getItems().get(0),
									valueJson, admin.getId());

							String multiDateMap = CustomObjectMapperUtil.writeValueAsString(octExamMultiDates, null);

							response = omsbHttpConnector.executePut(themeDisplay.getPortalURL()
									+ LRObjectURL.OC_EXAM_SCHEDULE_MULTI_DATES + octExamMultiDates.getId(),
									multiDateMap, headers);

						}
					}

				}
			}
		} catch (Exception e) {
			log.debug("Error in updating Multidates");
		}
		return response;
	}

	public OCTExamScheduleMultiDatesItem getExamMultiDatesItemBasedOnMultExamDateId(ThemeDisplay themeDisplay,
			long examMultiDateId) {
		OCTExamScheduleMultiDatesItem multiDatesItem = new OCTExamScheduleMultiDatesItem();
		try {
			String examMultidatesURL = themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_SCHEDULE_MULTI_DATES
					+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION
					+ "filter=id" + URLEncoder.encode(" eq " + "'" + examMultiDateId + "'", StandardCharsets.UTF_8)+ "&pageSize=0";
			String examMultidatesResponse = commonApi.getData(examMultidatesURL);

			if (Validator.isNotNull(examMultidatesResponse)) {
				multiDatesItem = CustomObjectMapperUtil.readValue(examMultidatesResponse,
						OCTExamScheduleMultiDatesItem.class);

			}
			return multiDatesItem;
		} catch (Exception e) {
			return null;
		}
	}

	public long saveOCExamRepeatedScheduleAdmin(String examSlot, String daysOfWeek, boolean repeatedInstance,
			String examStartDate, String examEndDate, String locationOnGoogleMap, String venue,
			long octExamDepartmentId, long octExamSectionId, ActionRequest actionRequest, ThemeDisplay themeDisplay,
			long examCenter, int noOfSeats) {
		try {
			OCTExamSchedule examSchedule = new OCTExamSchedule();

			examSchedule.setDepartmentId(octExamDepartmentId);
			examSchedule.setSectionId(octExamSectionId);
			if (Validator.isNotNull(examStartDate)) {
				examSchedule.setExamStartDate(commonApi.convertDDMMYYYYDateToObjectDate(examStartDate));
			}
			if (Validator.isNotNull(examEndDate)) {
				examSchedule.setExamEndDate(commonApi.convertDDMMYYYYDateToObjectDate(examEndDate));
			}
			examSchedule.setExamSlot(examSlot);
			examSchedule.setLocationOnGoogleMap(locationOnGoogleMap);
			examSchedule.setOctExamDefinitionId(octExamDepartmentId);
			examSchedule.setVenue(venue);
			examSchedule.setExamCenter(examCenter);
			examSchedule.setNoOfSeats(noOfSeats);
			String examScheduleMapper = CustomObjectMapperUtil.writeValueAsString(examSchedule, null);
			String url = themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_SCHEDULE_ADMIN_URL + CommonConstants.SCOPES
					+ StringPool.SLASH + themeDisplay.getScopeGroupId();
			log.info("url for exam schedule admin:" + url);
			String response = omsbHttpConnector.executePost(url, examScheduleMapper,
					commonApi.getHttpHeaderInfoAndBasicAuth());
			log.info("response for exam schedule admin:" + response);
			OCTExamSchedule octExamSchedule = CustomObjectMapperUtil.readValue(response, OCTExamSchedule.class);
			if (Validator.isNotNull(octExamSchedule)) {
				log.info("exam schedule admin id:" + octExamSchedule.getId());
				return octExamSchedule.getId();
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return 0;
	}

	public void loadScheduleExmListJSP(ResourceRequest resourceRequest, ResourceResponse resourceResponse, String jsp) {
		PortletRequestDispatcher dispatcher = resourceRequest.getPortletSession().getPortletContext()
				.getRequestDispatcher(jsp);
		try {
			dispatcher.include(resourceRequest, resourceResponse);
		} catch (PortletException | IOException e) {
			log.error(e.getMessage(), e);
		}
	}

	public OCTMultiDateItems getOCExamMultiDatesItemBasedOnScheduleAdminId(ThemeDisplay themeDisplay,
			long scheduleAdminId) {
		OCTMultiDateItems multiDatesItem = new OCTMultiDateItems();
		try {
			String examMultidatesURL = themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_SCHEDULE_MULTI_DATES
					+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION
					+ "filter=oCExamScheduleAdminId"
					+ URLEncoder.encode(" eq " + scheduleAdminId, StandardCharsets.UTF_8)+ "&pageSize=0";
			String examMultidatesResponse = commonApi.getData(examMultidatesURL);

			if (Validator.isNotNull(examMultidatesResponse)) {
				multiDatesItem = CustomObjectMapperUtil.readValue(examMultidatesResponse, OCTMultiDateItems.class);
				if (Validator.isNotNull(multiDatesItem) && Validator.isNotNull(multiDatesItem.getItems())
						&& !multiDatesItem.getItems().isEmpty()) {
					for (OCTExamMultiDates multidate : multiDatesItem.getItems()) {
						multidate.setExamCenterName(commonApi.getListTypeEntryNameBylistTypeEntryId(
								multidate.getExamCenter(), themeDisplay.getLocale()));
						multidate.setExamSlotList(multidate.getExamSlot());
						multidate.setDaysOfWeekList(multidate.getDaysOfWeek());
						multidate.setDaysOfWeek(removeSpecialCharacter(multidate.getDaysOfWeek()));
						multidate.setExamSlot(removeSpecialCharacter(multidate.getExamSlot()));
						
						
					}
				}
			}
			return multiDatesItem;
		} catch (Exception e) {
			return null;
		}
	}
	public String removeSpecialCharacter(String key) {
		if(!key.isEmpty()) {
			key=key.replace("[", " ");
			key=key.replace("]", " ");
			key=key.replaceAll("\"", " ");
		}
		
		return key;
	}
	public OCTMultiDateItems getOCExamMultiDatesItemBasedOnMultExamDateId(ThemeDisplay themeDisplay,
			long examMultiDateId) {
		OCTMultiDateItems multiDatesItem = new OCTMultiDateItems();
		try {
			String examMultidatesURL = themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_SCHEDULE_MULTI_DATES
					+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION
					+ "filter=id" + URLEncoder.encode(" eq " + "'" + examMultiDateId + "'", StandardCharsets.UTF_8)+ "&pageSize=0";
			String examMultidatesResponse = commonApi.getData(examMultidatesURL);
			log.info("multi response:" + examMultidatesResponse);
			if (Validator.isNotNull(examMultidatesResponse)) {
				multiDatesItem = CustomObjectMapperUtil.readValue(examMultidatesResponse, OCTMultiDateItems.class);
				log.info("exam center:" + multiDatesItem.getItems().get(0).getExamCenter());

			}
			return multiDatesItem;
		} catch (Exception e) {
			return null;
		}
	}

	public JSONObject getEditedMultObjDetails(ThemeDisplay themeDisplay, long examMultiDateId) {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		try {

			OCTMultiDateItems multiDatesItem = getOCExamMultiDatesItemBasedOnMultExamDateId(themeDisplay,
					examMultiDateId);
			if (Validator.isNotNull(multiDatesItem)) {

				OCTExamMultiDates dates = multiDatesItem.getItems().get(0);
				log.info("dates.getDaysOfWeek():" + dates.getDaysOfWeek() + "exam center:" + dates.getExamCenter()
						+ "examSlot" + dates.getExamSlot() + "no of seat:" + dates.getNoOfSeats() + "id"
						+ dates.getId());
				jsonObject.put("daysOfWeek", dates.getDaysOfWeek());
				jsonObject.put("examCenter", dates.getExamCenter());
				jsonObject.put("examSlot", dates.getExamSlot());
				jsonObject.put("noOfSeats", dates.getNoOfSeats());
				jsonObject.put("id", dates.getId());

			}

		} catch (Exception e) {
			return null;
		}
		return jsonObject;
	}

	
	public OCTExamScheduleAdmin getOCExamScheduleAdminByScheduleAdminId(ThemeDisplay themeDisplay,
			long scheduleAdminId) {
		OCTExamScheduleAdminItems scheduleAdminItems = new OCTExamScheduleAdminItems();
		OCTExamScheduleAdmin responseObject= new OCTExamScheduleAdmin();
		try {
			String examScheduleAdminFetchURL = 
					themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_SCHEDULE_ADMIN_URL
					+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION
					+ "filter=id" + URLEncoder.encode(" eq " + "'" + scheduleAdminId + "'", StandardCharsets.UTF_8)+ "&pageSize=0";
			log.info("examScheduleAdminFetchURL for fetching OCTExamScheduleAdmin object in getOCExamScheduleAdminByScheduleAdminId method :: "+examScheduleAdminFetchURL);	
			String examScheduleAdminResponse = commonApi.getData(examScheduleAdminFetchURL);

			if (Validator.isNotNull(examScheduleAdminResponse)) {
				scheduleAdminItems = CustomObjectMapperUtil.readValue(examScheduleAdminResponse, OCTExamScheduleAdminItems.class);
				responseObject=scheduleAdminItems.getItems().get(0);
			}
			return responseObject;
		} catch (Exception e) {
			log.info("Exception during fetching OCTExamScheduleAdmin object in getOCExamScheduleAdminByScheduleAdminId method"+e);
			return null;
		}
	}
	
	public OCTExamSchedule getOCExamScheduleByScheduleId(ThemeDisplay themeDisplay,
			long scheduleId) {
		OCTExamScheduleItems scheduleItems = new OCTExamScheduleItems();
		OCTExamSchedule responseObject= new OCTExamSchedule();
		try {
			String examScheduleFetchURL = 
					themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_SCHEDULE
					+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION
					+ "filter=id" + URLEncoder.encode(" eq " + "'" + scheduleId + "'", StandardCharsets.UTF_8)+ "&pageSize=0";
			log.info("examScheduleFetchURL for fetching OCTExamSchedule object in "
					+ "getOCExamScheduleByScheduleId method :: "+examScheduleFetchURL);	
			String examScheduleResponse = commonApi.getData(examScheduleFetchURL);

			if (Validator.isNotNull(examScheduleResponse)) {
				scheduleItems = CustomObjectMapperUtil.readValue(examScheduleResponse, OCTExamScheduleItems.class);
				responseObject=scheduleItems.getItems().get(0);
			}
			return responseObject;
		} catch (Exception e) {
			log.info("Exception during fetching OCTExamSchedule object in getOCExamScheduleAdminByScheduleId method"+e);
			return null;
		}
	}
	 
	@Reference(unbind = "-")
	private OMSBHttpConnector omsbHttpConnector;

	@Reference(unbind = "-")
	private OCTExamUtil octExamUtil;

	@Reference(unbind = "_")
	private OMSBCommonApi commonApi;

	@Reference
	private CalendarBookingLocalService _calendarBookingLocalService;
	@Reference(unbind = "-")
	private OCTNotificationUtil octNotificationUtil;

	private static final Log log = LogFactoryUtil.getLog(OCTScheduleUtil.class);
}
