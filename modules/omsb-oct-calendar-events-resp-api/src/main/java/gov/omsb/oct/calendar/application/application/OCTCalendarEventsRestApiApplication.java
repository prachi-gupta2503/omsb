package gov.omsb.oct.calendar.application.application;

import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.service.CalendarBookingLocalServiceUtil;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.object.service.ObjectEntryLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.Validator;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamDefinition;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamDefinitionItems;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamItems;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamSchedule;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamScheduleItems;
import gov.omsb.oct.exam.web.portlet.dto.OCTRegistration;
import gov.omsb.oct.exam.web.portlet.dto.OCTRegistrationItem;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;
import gov.omsb.oct.exam.web.portlet.util.OCTNotificationUtil;
import gov.omsb.oct.rest.api.OmsbOctRestServiceImpl;

/**
 * @author jiten
 */
@Component(
		property = {
				JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/oct-calendar-events-api",
				JaxrsWhiteboardConstants.JAX_RS_NAME + "=OMSB.OCT" ,"liferay.auth.verifier=false",
				"liferay.oauth2=false"
		},
		service = Application.class
		)
public class OCTCalendarEventsRestApiApplication extends Application {

	private Log logger = LogFactoryUtil.getLog(OCTCalendarEventsRestApiApplication.class);

	@Reference(unbind = "-")
	private OMSBHttpConnector omsbHttpConnector;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference
	private ObjectEntryLocalService objectEntryLocalService;

	@Reference(unbind = "-")
	private OCTExamUtil octExamUtil;

	
	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	@GET
	@Produces("text/plain")
	public String working() {
		return "It works!";
	}

	@GET
	@Path("/morning")
	@Produces("text/plain")
	public String hello() {
		return "Good morning!";
	}

	@GET
	@Path("/event-action/")
	@Produces("text/plain")
	public String eventAction(
			@QueryParam("action") String action,@QueryParam("content") String content,@QueryParam("portalURL") String portalURL,@QueryParam("groupId") long groupId,
			@QueryParam("companyId") long companyId,@QueryParam("date") String date,@QueryParam("scheduleId") long scheduleId
			) {
		
		logger.debug("Action = "+action +" & content ="+content+ " & date = " +date+ " & scheduleId="+scheduleId);

		long ocExamScheduleId=scheduleId;
		
		logger.debug("ocExamScheduleId = "+ocExamScheduleId);
		
		if (ocExamScheduleId > 0 && action.equalsIgnoreCase("block")) {
			
			changeExamScheduleStatusAsBlocked(ocExamScheduleId,portalURL,groupId,companyId);

		} else if (ocExamScheduleId > 0 && action.equalsIgnoreCase("cancel")) {

			changeExamScheduleStatusAsCanceled(ocExamScheduleId,portalURL,groupId,companyId);

		} else if (ocExamScheduleId > 0 && action.equalsIgnoreCase("reschedule")) {

			rescheduleExam(ocExamScheduleId,portalURL,groupId,companyId);
		} else if (ocExamScheduleId > 0 && action.equalsIgnoreCase("cancelForWholeDay")) {

			cancelForWholeDayExam(ocExamScheduleId,portalURL,groupId,companyId);
		} else if (ocExamScheduleId > 0 && action.equalsIgnoreCase("blockForWholeDay")) {

			blockForWholeDayExam(ocExamScheduleId,portalURL,groupId,companyId);
		}else if(ocExamScheduleId > 0 && action.equalsIgnoreCase("rescheduleForWholeDay"))  {
			rescheduleForWholeDay(ocExamScheduleId, portalURL, groupId, companyId);
		}

		return action+date+content;
	}



	private void rescheduleForWholeDay(long ocExamScheduleId, String portalURL, long groupId, long companyId) {
		String examScheduleURL = portalURL + LRObjectURL.OC_EXAM_SCHEDULE + CommonConstants.SCOPES
				+ StringPool.SLASH + groupId+ StringPool.QUESTION + "filter=id"
				+ URLEncoder.encode(" eq " + "'" + ocExamScheduleId + "'", StandardCharsets.UTF_8);
		String examScheduleResponse = omsbHttpConnector.executeGet(examScheduleURL, "",
				omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
		if (Validator.isNotNull(examScheduleResponse)) {

			OCTExamScheduleItems scheduleItems = CustomObjectMapperUtil.readValue(examScheduleResponse,
					OCTExamScheduleItems.class);

			if (Validator.isNotNull(scheduleItems)) {

				OCTExamSchedule examSchedule = new OCTExamSchedule();
				examSchedule.setDepartmentId(scheduleItems.getItems().get(0).getDepartmentId());
				String date= scheduleItems.getItems().get(0).getExamDate();
				Date dateFormat=new Date();
				try {
					dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(date);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				examScheduleURL = portalURL + LRObjectURL.OC_EXAM_SCHEDULE + CommonConstants.SCOPES
						+ StringPool.SLASH + groupId;

				examScheduleResponse = omsbHttpConnector.executeGet(examScheduleURL, "",
						omsbCommonApi.getHttpHeaderInfoAndBasicAuth());


				if (Validator.isNotNull(examScheduleResponse)) {

					scheduleItems = CustomObjectMapperUtil.readValue(examScheduleResponse,
							OCTExamScheduleItems.class);

					if (Validator.isNotNull(scheduleItems)) {
						List<OCTExamSchedule> items = scheduleItems.getItems();
						for(OCTExamSchedule octExamSchedule:items) {
							Date oCTExamDate;
							try {
								oCTExamDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(octExamSchedule.getExamDate());
								if(dateFormat.equals(oCTExamDate))
									rescheduleExam(octExamSchedule.getId(), portalURL, groupId, companyId);
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						}
					}
				}

			}
		}
		
	}
	private void blockForWholeDayExam(long ocExamScheduleId, String portalURL, long groupId, long companyId) {
		// TODO Auto-generated method stub
		String examScheduleURL = portalURL + LRObjectURL.OC_EXAM_SCHEDULE + CommonConstants.SCOPES
				+ StringPool.SLASH + groupId+ StringPool.QUESTION + "filter=id"
				+ URLEncoder.encode(" eq " + "'" + ocExamScheduleId + "'", StandardCharsets.UTF_8);

		String examScheduleResponse = omsbHttpConnector.executeGet(examScheduleURL, "",
				omsbCommonApi.getHttpHeaderInfoAndBasicAuth());

		if (Validator.isNotNull(examScheduleResponse)) {

			OCTExamScheduleItems scheduleItems = CustomObjectMapperUtil.readValue(examScheduleResponse,
					OCTExamScheduleItems.class);

			if (Validator.isNotNull(scheduleItems)) {

				OCTExamSchedule examSchedule = new OCTExamSchedule();
				examSchedule.setDepartmentId(scheduleItems.getItems().get(0).getDepartmentId());
				String date= scheduleItems.getItems().get(0).getExamDate();
				Date dateFormat=new Date();
				try {
					dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(date);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				examScheduleURL = portalURL + LRObjectURL.OC_EXAM_SCHEDULE + CommonConstants.SCOPES
						+ StringPool.SLASH + groupId;

				examScheduleResponse = omsbHttpConnector.executeGet(examScheduleURL, "",
						omsbCommonApi.getHttpHeaderInfoAndBasicAuth());


				if (Validator.isNotNull(examScheduleResponse)) {

					scheduleItems = CustomObjectMapperUtil.readValue(examScheduleResponse,
							OCTExamScheduleItems.class);

					if (Validator.isNotNull(scheduleItems)) {
						List<OCTExamSchedule> items = scheduleItems.getItems();
						for(OCTExamSchedule octExamSchedule:items) {
							Date oCTExamDate;
							try {
								oCTExamDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(octExamSchedule.getExamDate());
								if(dateFormat.equals(oCTExamDate))
									changeExamScheduleStatusAsBlocked(octExamSchedule.getId(), portalURL, groupId, companyId);
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						}
					}
				}

			}
		}
	}

	private void cancelForWholeDayExam(long ocExamScheduleId, String portalURL, long groupId, long companyId) {
		// TODO Auto-generated method stub
		String examScheduleURL = portalURL + LRObjectURL.OC_EXAM_SCHEDULE + CommonConstants.SCOPES
				+ StringPool.SLASH + groupId+ StringPool.QUESTION + "filter=id"
				+ URLEncoder.encode(" eq '"  + ocExamScheduleId +"'", StandardCharsets.UTF_8);

		String examScheduleResponse = omsbHttpConnector.executeGet(examScheduleURL, "",
				omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
		logger.info(examScheduleResponse);
		if (Validator.isNotNull(examScheduleResponse)) {

			OCTExamScheduleItems scheduleItems = CustomObjectMapperUtil.readValue(examScheduleResponse,
					OCTExamScheduleItems.class);
			logger.info(scheduleItems);
			if (Validator.isNotNull(scheduleItems) && !scheduleItems.getItems().isEmpty()) {
//				OCTExamSchedule examSchedule = new OCTExamSchedule();
//				examSchedule.setDepartmentId(scheduleItems.getItems().get(0).getDepartmentId());
				String date= scheduleItems.getItems().get(0).getExamDate();
				logger.info(date);
				Date dateFormat=new Date();
				try {
					dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(date);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				examScheduleURL = portalURL + LRObjectURL.OC_EXAM_SCHEDULE + CommonConstants.SCOPES
						+ StringPool.SLASH + groupId;

				examScheduleResponse = omsbHttpConnector.executeGet(examScheduleURL, "",
						omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
				if (Validator.isNotNull(examScheduleResponse)) {

					scheduleItems = CustomObjectMapperUtil.readValue(examScheduleResponse,
							OCTExamScheduleItems.class);

					if (Validator.isNotNull(scheduleItems)) {
						List<OCTExamSchedule> items = scheduleItems.getItems();
						for(OCTExamSchedule octExamSchedule:items) {
							Date oCTExamDate;
							try {
								oCTExamDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(octExamSchedule.getExamDate());
								if(dateFormat.equals(oCTExamDate))
									changeExamScheduleStatusAsCanceled(octExamSchedule.getId(), portalURL, groupId, companyId);
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						}
					}
				}


			}
		}

	}

	private void changeExamScheduleStatusAsBlocked(long ocExamScheduleId,String portalUrl,long groupId,long companyId) {
		String examScheduleURL = portalUrl + LRObjectURL.OC_EXAM_SCHEDULE + CommonConstants.SCOPES
				+ StringPool.SLASH +groupId + StringPool.QUESTION + "filter=id"
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
						LRPicklistConstants.PL_EXAM_STATUS, "blocked", companyId);

				examSchedule.setExamStatusId(listTypeEntry.getListTypeEntryId());

				String examScheduleUrl = portalUrl + LRObjectURL.OC_EXAM_SCHEDULE
						+ scheduleItems.getItems().get(0).getId();
				String examScheduleMapper = CustomObjectMapperUtil.writeValueAsString(examSchedule, null);
				omsbHttpConnector.executePut(examScheduleUrl, examScheduleMapper,
						omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
				//				actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommandNames.VIEW_OCT_EXAM_SCHEDULE_LIST_RENDER);
			}
		}
	}





	private void changeExamScheduleStatusAsCanceled(long ocExamScheduleId, String portalUrl,long groupId,long companyId) {

		String examScheduleURL = portalUrl + LRObjectURL.OC_EXAM_SCHEDULE + CommonConstants.SCOPES
				+ StringPool.SLASH + groupId + StringPool.QUESTION + "filter=id"
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
						LRPicklistConstants.PL_EXAM_STATUS, "cancelled", companyId);

				examSchedule.setExamStatusId(listTypeEntry.getListTypeEntryId());

				String examScheduleUrl =portalUrl + LRObjectURL.OC_EXAM_SCHEDULE
						+ scheduleItems.getItems().get(0).getId();
				String examScheduleMapper = CustomObjectMapperUtil.writeValueAsString(examSchedule, null);
				omsbHttpConnector.executePut(examScheduleUrl, examScheduleMapper,
						omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
			}
		}
	}
	

	private void rescheduleExam(long ocExamScheduleId,String portalUrl,long groupId,long companyId) {

		String examScheduleURL = portalUrl + LRObjectURL.OC_EXAM_SCHEDULE + CommonConstants.SCOPES
				+ StringPool.SLASH + groupId + StringPool.QUESTION + "filter=id"
				+ URLEncoder.encode(" eq " + "'" + ocExamScheduleId + "'", StandardCharsets.UTF_8);

		String examScheduleResponse = omsbHttpConnector.executeGet(examScheduleURL, "",
				omsbCommonApi.getHttpHeaderInfoAndBasicAuth());

		if (Validator.isNotNull(examScheduleResponse)) {

			OCTExamScheduleItems scheduleItems = CustomObjectMapperUtil.readValue(examScheduleResponse,
					OCTExamScheduleItems.class);

			if (Validator.isNotNull(scheduleItems)) {

				String examDefinitionURL = portalUrl + LRObjectURL.OC_EXAM_DEFINITION
						+ CommonConstants.SCOPES + StringPool.SLASH + groupId
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

						String examURL = portalUrl + LRObjectURL.OC_EXAM + CommonConstants.SCOPES
								+ StringPool.SLASH + groupId + StringPool.QUESTION + "filter=id"
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

									logger.info("DATE ..." + rescheduledDateString);

									OCTExamSchedule examSchedule = new OCTExamSchedule();

									examSchedule.setDepartmentId(scheduleItems.getItems().get(0).getDepartmentId());
									examSchedule.setSectionId(scheduleItems.getItems().get(0).getSectionId());
									examSchedule.setExamDate(rescheduledDateString);
//									examSchedule.setExamEndTime(scheduleItems.getItems().get(0).getExamEndTime());
//									examSchedule.setExamTime(scheduleItems.getItems().get(0).getExamTime());
									examSchedule.setId(scheduleItems.getItems().get(0).getId());
									examSchedule.setLocationOnGoogleMap(
											scheduleItems.getItems().get(0).getLocationOnGoogleMap());
									examSchedule.setNoOfSeats(scheduleItems.getItems().get(0).getNoOfSeats());
									examSchedule.setOctExamDefinitionId(
											scheduleItems.getItems().get(0).getOctExamDefinitionId());

									ListTypeEntry listTypeEntry = omsbCommonApi.getListTypeEntryByListTypeItemKey(
											LRPicklistConstants.PL_EXAM_STATUS, "announced",
											companyId);

									examSchedule.setExamStatusId(listTypeEntry.getListTypeEntryId());

									String examScheduleUrl = portalUrl + LRObjectURL.OC_EXAM_SCHEDULE
											+ scheduleItems.getItems().get(0).getId();
									String examScheduleMapper = CustomObjectMapperUtil.writeValueAsString(examSchedule,
											null);
									omsbHttpConnector.executePut(examScheduleUrl, examScheduleMapper,
											omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
//									actionResponse.getRenderParameters().setValue("mvcRenderCommandName",
//											MVCCommandNames.VIEW_OCT_EXAM_SCHEDULE_LIST_RENDER);

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

	@GET
	@Path("/get-exam-list")
	@Produces(ContentTypes.APPLICATION_JSON)
	public Response getAllExamsList(

			@QueryParam("portalURL") String portalURL, @QueryParam("groupId") long groupId,
			@QueryParam("companyId") long companyId/* ,@QueryParam("locale") Locale locale */) {
		String response=StringPool.BLANK;

		try {

			OmsbOctRestServiceImpl octRestServiceImpl= new OmsbOctRestServiceImpl();
			response= octRestServiceImpl.getExamList(portalURL, groupId, Locale.getDefault(), omsbCommonApi, omsbHttpConnector);
			return  Response.status(Response.Status.OK).entity(response).build();

		} catch (Exception e) {
			logger.info(e);
		}
		return null;

	}
	@Reference
	OCTNotificationUtil oCTNotificationUtil;
}