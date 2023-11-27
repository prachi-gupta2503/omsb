package gov.omsb.oct.rest.utills;

import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.service.CalendarBookingLocalServiceUtil;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.osgi.service.component.annotations.Component;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamDefinition;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamDefinitionItems;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamItems;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamSchedule;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamScheduleItems;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;

@Component(immediate = true, service = OmsbRestUtill.class)
public class OmsbRestUtill {
	private Log logger = LogFactoryUtil.getLog(OmsbRestUtill.class);
	public void rescheduleExam(long ocExamScheduleId,String portalUrl,long groupId,long companyId,OMSBCommonApi omsbCommonApi, OMSBHttpConnector omsbHttpConnector,OCTExamUtil octExamUtil) {

		String examScheduleURL =portalUrl+ LRObjectURL.OC_EXAM_SCHEDULE + CommonConstants.SCOPES
				+ StringPool.SLASH + groupId + StringPool.QUESTION + "filter=id"
				+ URLEncoder.encode(" eq " + "'" + ocExamScheduleId + "'", StandardCharsets.UTF_8);

		String examScheduleResponse = omsbHttpConnector.executeGet(examScheduleURL, "", omsbCommonApi.getHttpHeaderInfoAndBasicAuth());

		if (Validator.isNotNull(examScheduleResponse)) {

			OCTExamScheduleItems scheduleItems = CustomObjectMapperUtil.readValue(examScheduleResponse, OCTExamScheduleItems.class);

			if (Validator.isNotNull(scheduleItems)) {

				String examDefinitionURL = portalUrl+ LRObjectURL.OC_EXAM_DEFINITION + CommonConstants.SCOPES
						+ StringPool.SLASH + groupId + StringPool.QUESTION + "filter=id"
						+ URLEncoder.encode(" eq " + "'" + scheduleItems.getItems().get(0).getOctExamDefinitionId() + "'", StandardCharsets.UTF_8);

				String examDefinitionResponse = omsbHttpConnector.executeGet(examDefinitionURL, "", omsbCommonApi.getHttpHeaderInfoAndBasicAuth());

				if(Validator.isNotNull(examDefinitionResponse)) {

					OCTExamDefinitionItems definitionItems = CustomObjectMapperUtil.readValue(examDefinitionResponse, OCTExamDefinitionItems.class);

					if(Validator.isNotNull(definitionItems)) {

						String examURL = portalUrl + LRObjectURL.OC_EXAM + CommonConstants.SCOPES
								+ StringPool.SLASH + groupId + StringPool.QUESTION + "filter=id"
								+ URLEncoder.encode(" eq " + "'" + definitionItems.getItems().get(0).getoCExamId() + "'", StandardCharsets.UTF_8);

						String examResponse = omsbHttpConnector.executeGet(examURL, "", omsbCommonApi.getHttpHeaderInfoAndBasicAuth());

						if(Validator.isNotNull(examResponse)) {

							OCTExamItems examItems = CustomObjectMapperUtil.readValue(examResponse, OCTExamItems.class);

							if(Validator.isNotNull(examItems)) {

								String examJson = examItems.getItems().get(0).getExamJson();

								try {

									JSONObject jsonObject = JSONFactoryUtil.createJSONObject(examJson);

									long autoReschedulingDays = Long.parseLong(jsonObject.getString("autoSchedulingPeriod"));

									String examDate = scheduleItems.getItems().get(0).getExamDate();

									Instant instant = Instant.parse(examDate);

									LocalDate examLocalDate = instant.atZone(ZoneId.of("UTC")).toLocalDate();

									LocalDate rescheduledDate = examLocalDate.plusDays(autoReschedulingDays);

									Instant rescheduledInstant = rescheduledDate.atStartOfDay(ZoneId.of("UTC")).toInstant();

									String rescheduledDateString = rescheduledInstant.toString();

									logger.info("DATE ..."+rescheduledDateString);


									OCTExamSchedule examSchedule = new OCTExamSchedule();

									examSchedule.setDepartmentId(scheduleItems.getItems().get(0).getDepartmentId());
									examSchedule.setSectionId(scheduleItems.getItems().get(0).getSectionId());
									examSchedule.setExamDate(rescheduledDateString);
									examSchedule.setExamSlot(scheduleItems.getItems().get(0).getExamSlot());
									examSchedule.setId(scheduleItems.getItems().get(0).getId());
									examSchedule.setLocationOnGoogleMap(scheduleItems.getItems().get(0).getLocationOnGoogleMap());
									examSchedule.setNoOfSeats(scheduleItems.getItems().get(0).getNoOfSeats());
									examSchedule.setOctExamDefinitionId(scheduleItems.getItems().get(0).getOctExamDefinitionId());

									ListTypeEntry listTypeEntry = 
											omsbCommonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.PL_EXAM_STATUS, "announced", companyId);

									examSchedule.setExamStatusId(listTypeEntry.getListTypeEntryId());

									String examTitle = "";
									OCTExamDefinition octExamDefinition = octExamUtil.getOCTExamDefinitionByDefinitionId(examSchedule.getOctExamDefinitionId(), portalUrl);


									if(Validator.isNotNull(octExamDefinition)) {
										logger.info("octExamDefinition..."+octExamDefinition.getoCExamTitleId());
										examTitle = omsbCommonApi.getListTypeEntryNameBylistTypeEntryId(octExamDefinition.getoCExamTitleId(), Locale.getDefault());
									}

									logger.info("EXAM TITLE .... "+examTitle);
									String examScheduleUrl = portalUrl + LRObjectURL.OC_EXAM_SCHEDULE + scheduleItems.getItems().get(0).getId();
									String examScheduleMapper = CustomObjectMapperUtil.writeValueAsString(examSchedule, null);
									omsbHttpConnector.executePut(examScheduleUrl, examScheduleMapper, omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
									DynamicQuery query = CalendarBookingLocalServiceUtil.dynamicQuery();
									query.add(PropertyFactoryUtil.forName("description").like(examTitle +"_"+scheduleItems.getItems().get(0).getId()));
									List<CalendarBooking> calendareBookings = CalendarBookingLocalServiceUtil.dynamicQuery(query);
									CalendarBooking booking=calendareBookings.get(0);
									String isoFormat = "yyyy-MM-dd'T'HH:mm:ss'Z'";
									String timeFormatwithAMPM = "hh:mm a";
									String timeFormat = "hh:mm";
									SimpleDateFormat isoSdf = new SimpleDateFormat(isoFormat);
									Date isoDateTime = isoSdf.parse(rescheduledDateString);
									SimpleDateFormat timeSdf = null;
									if (scheduleItems.getItems().get(0).getExamSlot().contains("Am") || scheduleItems.getItems().get(0).getExamSlot().contains("PM")) {

										timeSdf = new SimpleDateFormat(timeFormatwithAMPM);
									} else {
										timeSdf = new SimpleDateFormat(timeFormat);
									}
									Date startTime = timeSdf.parse(scheduleItems.getItems().get(0).getExamSlot());

									isoDateTime.setHours(startTime.getHours());
									isoDateTime.setMinutes(startTime.getMinutes());

									booking.setStartTime(isoDateTime.getTime());
//									isoDateTime.setHours(endTime.getHours());
//									isoDateTime.setMinutes(endTime.getMinutes());

									booking.setEndTime(isoDateTime.getTime());

									CalendarBookingLocalServiceUtil.updateCalendarBooking(booking);
									//						  				actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommandNames.VIEW_OCT_EXAM_SCHEDULE_LIST_RENDER);

								} catch (Exception e) {

									logger.error("JSON Exception "+e.getMessage());
								}
							}
						}
					}
				}
			}
		}
	}

}
