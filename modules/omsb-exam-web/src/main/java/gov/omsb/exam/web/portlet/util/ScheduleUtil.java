package gov.omsb.exam.web.portlet.util;

import com.liferay.object.model.ObjectEntry;
import com.liferay.object.service.ObjectEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.portlet.ActionRequest;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.exam.web.portlet.constants.MVCCommands;
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;
import gov.omsb.exam.web.portlet.dto.Exam;
import gov.omsb.exam.web.portlet.dto.ExamDefinition;
import gov.omsb.exam.web.portlet.dto.ExamDefinitionItem;
import gov.omsb.exam.web.portlet.dto.ExamEligibility;
import gov.omsb.exam.web.portlet.dto.ExamItem;
import gov.omsb.exam.web.portlet.dto.ExamMultiDates;
import gov.omsb.exam.web.portlet.dto.ExamMultiDatesItem;
import gov.omsb.exam.web.portlet.dto.ExamResultItem;
import gov.omsb.exam.web.portlet.dto.ExamSchedule;
import gov.omsb.exam.web.portlet.dto.ExamScheduleAdmin;
import gov.omsb.exam.web.portlet.dto.ExamScheduleItem;
import gov.omsb.exam.web.portlet.dto.ExamTypeItem;
import gov.omsb.exam.web.portlet.dto.ExamWithdrawal;
import gov.omsb.exam.web.portlet.dto.RegistrationItem;
import gov.omsb.exam.web.portlet.dto.RegularFees;
import gov.omsb.exam.web.portlet.dto.Trainee;
import gov.omsb.exam.web.portlet.dto.TraineeItem;
import gov.omsb.exam.web.portlet.dto.WithdrawalFees;
import gov.omsb.http.connector.api.OMSBHttpConnector;

@Component(immediate = true, service = ScheduleUtil.class)
public class ScheduleUtil {

	public ExamScheduleItem fetchScheduledExamItemList(ThemeDisplay themeDisplay, long programId, long examTypeId,
			String examStartDate, String examEndDate, String status) {
		StringBuilder sbScheduledExam = new StringBuilder(themeDisplay.getPortalURL() + LRObjectURL.EXAM_SCHEDULE_URL
				+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId());
		if (Validator.isNotNull(status)) {
			try {
				sbScheduledExam.append(StringPool.QUESTION + "filter=examStatus"
						+ URLEncoder.encode(" eq " + "'" + status + "'", DataflowConstants.UTF_8) + "&pageSize=0");
			} catch (UnsupportedEncodingException e) {
				log.error("Error while setting status in scheduledExamURL, " + e.getMessage());
			}
		}
		String examScheduleResponse = commonApi.getData(sbScheduledExam.toString());
		log.debug("examScheduleResponse :" + examScheduleResponse);
		if (Validator.isNotNull(examScheduleResponse)) {
			ExamScheduleItem examScheduleItem = CustomObjectMapperUtil.readValue(examScheduleResponse,
					ExamScheduleItem.class);
			Set<Long> idToBeRemove = new HashSet<>();
			int index = 0;
			for (ExamSchedule examSchedule : examScheduleItem.getItems()) {
				if (Validator.isNotNull(examStartDate) && Validator.isNotNull(examEndDate)) {
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					try {
						Date examDate = commonApi.convertObjectStringDateToDate(examSchedule.getExamDate());
						if (examDate.before(sdf.parse(examStartDate)) && examDate.after(sdf.parse(examEndDate))) {
							idToBeRemove.add(examSchedule.getId());
						}
					} catch (ParseException e) {
						log.error("Error while parsing exam start & end date, " + e.getMessage());
					}
				}
				if (Validator.isNotNull(examSchedule.getExamDefinitionId())) {

					try {
						ObjectEntry entry = ObjectEntryLocalServiceUtil
								.getObjectEntry(examSchedule.getExamDefinitionId());
						Map<String, Serializable> map = entry.getValues();
						log.info("Map . " + map.get("programId"));
						log.info("Map . " + map.get("examTypeId"));

						if (programId != 0) {
							if (Validator.isNotNull(map.get("programId"))) {
								if ((Long) map.get("programId") == programId) {
									examScheduleItem.getItems().get(index).setProgramName(
											examUtil.getProgramByProgramId((Long) map.get("programId"), themeDisplay));
								} else {
									idToBeRemove.add(examSchedule.getId());
								}
							} else {
								idToBeRemove.add(examSchedule.getId());
							}
						} else {
							examScheduleItem.getItems().get(index).setProgramName(
									examUtil.getProgramByProgramId((Long) map.get("programId"), themeDisplay));
						}
						if (examTypeId != 0) {
							if (Validator.isNotNull(map.get("examTypeId"))) {
								if ((Long) map.get("examTypeId") == examTypeId) {
									examScheduleItem.getItems().get(index).setExamTypeName(
											examUtil.getExamType((Long) map.get("examTypeId"), themeDisplay.getCompanyId(),themeDisplay.getPortalURL(),themeDisplay.getLocale()));
								} else {
									idToBeRemove.add(examSchedule.getId());
								}
							} else {
								idToBeRemove.add(examSchedule.getId());
							}
						} else {
							examScheduleItem.getItems().get(index)
									.setExamTypeName(examUtil.getExamType((Long) map.get("examTypeId"), themeDisplay.getCompanyId(),themeDisplay.getPortalURL(),themeDisplay.getLocale()));
						}
					} catch (PortalException e) {
						e.printStackTrace();
					}
				}
				if (!idToBeRemove.contains(examSchedule.getId())) {
					examSchedule.setApplicationStartDate(
							commonApi.convertObjectDateToDDMMYYYYDate(examSchedule.getApplicationStartDate()));
					examSchedule.setApplicationEndDate(
							commonApi.convertObjectDateToDDMMYYYYDate(examSchedule.getApplicationEndDate()));

					if (!examSchedule.isMultiDates()) {

						examSchedule.setExamDate(commonApi.convertObjectDateToDDMMYYYYDate(examSchedule.getExamDate()));
					}

					else if (examSchedule.isMultiDates()) {
						// ExamMultiDatesItem examMultiDatesItem =
						// getExamMultiByDesc(themeDisplay,examSchedule.getId());

//						String examMultiDatesUrl = themeDisplay.getPortalURL()
//								+ LRObjectURL.EXAM_MULTIDATES_URL.replace("{scope-id}", themeDisplay.getScopeGroupId()
//										+ StringPool.QUESTION + "filter=examScheduleId"
//										+ URLEncoder.encode(" eq " + examSchedule.getId(), StandardCharsets.UTF_8));

						String examMultiDatesUrl = themeDisplay.getPortalURL() + LRObjectURL.EXAM_MULTIDATES_URL
								+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId()
								+ StringPool.QUESTION + "filter=examScheduleAdminId" + URLEncoder
										.encode(" eq " + examSchedule.getExamScheduleAdminId(), StandardCharsets.UTF_8)
								+ "&pageSize=0";
						log.info("examMultiDatesUrl =============" + examMultiDatesUrl);
						String examMultiDatesResponse = commonApi.getData(examMultiDatesUrl);
						ExamMultiDatesItem examMultiDatesItem = CustomObjectMapperUtil.readValue(examMultiDatesResponse,
								ExamMultiDatesItem.class);
//
//						examMultiDatesItem.sortByIdInReverseOrder();

						examSchedule.setExamDate(commonApi
								.convertObjectDateToDDMMYYYYDate(examMultiDatesItem.getItems().get(0).getExamDate()));

					}

				}
				index++;
			}
			for (long id : idToBeRemove) {
				examScheduleItem.getItems().removeIf(element -> (Objects.equals(element.getId(), id)));
			}
			return examScheduleItem;
		}
		return null;
	}

	private ExamItem getExamItem(String portalURL, long groupId, long examDefinitionId) {
		try {
			StringBuilder sbExamDefination = new StringBuilder(
					portalURL + LRObjectURL.EXAM_DEFINITION_URL + CommonConstants.SCOPES + StringPool.SLASH + groupId);
			sbExamDefination.append(StringPool.QUESTION + "filter=id"
					+ URLEncoder.encode(" eq " + "'" + examDefinitionId + "'", DataflowConstants.UTF_8)
					+ "&pageSize=0");
			String examDefinationResponse = commonApi.getData(sbExamDefination.toString());
			if (Validator.isNotNull(examDefinationResponse)) {
				log.debug("examDefinationResponse :" + examDefinationResponse);
				return CustomObjectMapperUtil.readValue(examDefinationResponse, ExamItem.class);
			}
		} catch (UnsupportedEncodingException e) {
			log.error("Error while executing getExamItem, " + e.getMessage());
		}
		return null;
	}

	private ExamTypeItem getExamTypeItems(String portalURL, long groupId, long examTypeId, String examType) {
		try {
			StringBuilder sbExamType = new StringBuilder(
					portalURL + LRObjectURL.EXAM_TYPE_URL + CommonConstants.SCOPES + StringPool.SLASH + groupId);
			if (Validator.isNotNull(examTypeId)) {
				sbExamType.append(StringPool.QUESTION + "filter=id"
						+ URLEncoder.encode(" eq " + "'" + examTypeId + "'", DataflowConstants.UTF_8) + "&pageSize=0");
			}
			if (Validator.isNotNull(examType) && Validator.isNotNull(examTypeId)) {
				sbExamType.append(URLEncoder.encode(" and examType eq " + "'" + examType + "'", DataflowConstants.UTF_8)
						+ "&pageSize=0");
			} else if (Validator.isNotNull(examType)) {
				sbExamType.append(StringPool.QUESTION + "filter=examType"
						+ URLEncoder.encode(" eq " + "'" + examType + "'", DataflowConstants.UTF_8) + "&pageSize=0");
			}
			String examTypeResponse = commonApi.getData(sbExamType.toString());
			if (Validator.isNotNull(examTypeResponse)) {
				log.debug("examDefinationResponse :" + examTypeResponse);
				return CustomObjectMapperUtil.readValue(examTypeResponse, ExamTypeItem.class);
			}
		} catch (UnsupportedEncodingException e) {
			log.error("Error while executing getExamTypeItems, " + e.getMessage());
		}
		return null;
	}

	public ExamScheduleItem getExamScheduleItem(String portalURL, long groupId, long examScheduleId) {

		try {
			StringBuilder sbScheduledExamURL = new StringBuilder(
					portalURL + LRObjectURL.EXAM_SCHEDULE_URL + CommonConstants.SCOPES + StringPool.SLASH + groupId);
			if (examScheduleId != 0) {
				sbScheduledExamURL.append(StringPool.QUESTION + "filter=id"
						+ URLEncoder.encode(" eq " + "'" + examScheduleId + "'", DataflowConstants.UTF_8)
						+ "&pageSize=0");
			}
			String scheduledExamResponse = commonApi.getData(sbScheduledExamURL.toString());
			if (Validator.isNotNull(scheduledExamResponse)) {
				log.debug("scheduledExamResponse :" + scheduledExamResponse);
				return CustomObjectMapperUtil.readValue(scheduledExamResponse, ExamScheduleItem.class);
			}
		} catch (UnsupportedEncodingException e) {
			log.error("Error while executing getScheduledExamItem, " + e.getMessage());
		}
		return null;
	}

	public ExamMultiDatesItem getExamMultiDatesItem(String portalURL, long groupId, long examScheduleId) {

		try {
			StringBuilder sbExamMultiDatesURL = new StringBuilder(
					portalURL + LRObjectURL.EXAM_MULTIDATES_URL + CommonConstants.SCOPES + StringPool.SLASH + groupId);
			if (examScheduleId != 0) {
				sbExamMultiDatesURL.append(StringPool.QUESTION + "filter=examScheduleId"
						+ URLEncoder.encode(" eq " + "'" + examScheduleId + "'", DataflowConstants.UTF_8)
						+ "&pageSize=0");
			}
			String examMultiDatesResponse = commonApi.getData(sbExamMultiDatesURL.toString());
			if (Validator.isNotNull(examMultiDatesResponse)) {
				log.debug("scheduledExamResponse :" + examMultiDatesResponse);
				return CustomObjectMapperUtil.readValue(examMultiDatesResponse, ExamMultiDatesItem.class);
			}
		} catch (UnsupportedEncodingException e) {
			log.error("Error while executing getScheduledExamItem, " + e.getMessage());
		}
		return null;
	}

//	need to change from all exam schedule to trainee related after TMS implementation
	public List<ExamSchedule> getTraineeExamList(ThemeDisplay themeDisplay) {
		log.info("get trainee exam list method started");
		try {
			long userProgramId = getUserProgramId(themeDisplay);

			String scheduleExamUrl = themeDisplay.getPortalURL() + LRObjectURL.EXAM_SCHEDULE_URL
					+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION
					+ "filter=examStatus"
					+ URLEncoder.encode(" eq '" + "Announced' or " + "examStatus eq '" + "Completed'",
							StandardCharsets.UTF_8)+ "&pageSize=0";
					
			
			log.info("scheduleExam url"+ scheduleExamUrl);
			String scheduleExamResponse = commonApi.getData(scheduleExamUrl);
			log.debug("scheduleExamResponse"+ scheduleExamResponse);
			ExamScheduleItem examSchedules = CustomObjectMapperUtil.readValue(scheduleExamResponse,
					ExamScheduleItem.class);
			List<ExamSchedule> schedules = new ArrayList<>();
			log.info("examSchedules.getItems()"+ examSchedules.getItems().size());
			if (Validator.isNotNull(examSchedules) && Validator.isNotNull(examSchedules.getItems())
					&& !examSchedules.getItems().isEmpty()) {
				for (ExamSchedule examSchedule : examSchedules.getItems()) {
					RegistrationItem registrationItem = examUtil.getRegistrationByUserIdAndScheduleId(themeDisplay.getPortalURL(),themeDisplay.getScopeGroupId(),
							themeDisplay.getUserId(), examSchedule.getId());
					if(examSchedule.getExamStatus().equalsIgnoreCase("completed")) {
						if(Validator.isNull(registrationItem) || registrationItem.getItems().isEmpty()) {
							continue;
						}
					}
					
					ExamDefinition examDefinition = examUtil.getExamDefinitionByDefinitionId(examSchedule.getExamDefinitionId(), themeDisplay.getPortalURL());
					if(Validator.isNotNull(examDefinition)) {
						examSchedule.setExamId(examDefinition.getExamId());
					}
					examSchedule.setExamTypeName(examUtil.getExamType(examSchedule.getExamType(), themeDisplay.getCompanyId(),themeDisplay.getPortalURL(),themeDisplay.getLocale()));
					log.info("exam schedule id:" + examSchedule.getId());

					int noOfRegisteredUsers = getNumberOfRegisteredUSers(themeDisplay.getPortalURL(),themeDisplay.getScopeGroupId(), examSchedule.getId(),
							OMSBExamWebPortletKeys.REGISTERED);

					log.info("no of registered trainees ... " + noOfRegisteredUsers);

					log.info("examSchedule.getNoOfSeats()... " + examSchedule.getNoOfSeats());

					log.info("Exam date .. " + examSchedule.getExamDate());

					if (examSchedule.getNoOfSeats() == noOfRegisteredUsers) {

						examSchedule.setSeatsFilled(true);

					} else {
						examSchedule.setSeatsFilled(false);
					}
					
						//examSchedule.setProgram(programId);
					examSchedule.setNoOfAttempts(examUtil.getNoOfAttempts(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), examSchedule.getId(), themeDisplay.getUserId()));
						examSchedule.setProgramName(examUtil.getProgramByProgramId(examSchedule.getProgramId(), themeDisplay));
						
						if (Validator.isNotNull(registrationItem) && !registrationItem.getItems().isEmpty()) {

							examSchedule
									.setRegistrationStatus(registrationItem.getItems().get(0).getRegistrationStatus());
							long paymentReceiptFileEntryId = registrationItem.getItems().get(0).getPaymentReceiptFileEntryId();
							if (paymentReceiptFileEntryId > 0) {
								String payemtReceiptUrl = examUtil.getFileDownloadUrl(themeDisplay,
										paymentReceiptFileEntryId, themeDisplay.getPathContext());
								log.info("payemtReceiptUrl" + payemtReceiptUrl);
								if (Validator.isNotNull(payemtReceiptUrl)) {
									examSchedule.setPaymentReceiptUrl(payemtReceiptUrl);
								}
							}
							if(OMSBExamWebPortletKeys.WITHDRAWN.equalsIgnoreCase(registrationItem.getItems().get(0).getRegistrationStatus())) {
								ExamWithdrawal examWithdrawal = examUtil.getExamWithdrawalByScheduleIdAndLrUserId(examSchedule.getId(), themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(),registrationItem.getItems().get(0).getLrUserId());
								if(Validator.isNotNull(examWithdrawal)) {
									
									long statusId = examWithdrawal.getWithdrawalStatus();
									String withdrawStatus = commonApi.getListTypeEntryNameBylistTypeEntryId(statusId, themeDisplay.getLocale());
									log.info("statusId"+ statusId);
									log.info("withdrawStatus"+ withdrawStatus);
									log.info("examWithdrawal id"+ examWithdrawal.getId());
									
									examSchedule.setWithdrawStatus(withdrawStatus);
									examWithdrawal.setWithdrawalStatusValue(withdrawStatus);
									examSchedule.setExamWithdrawal(examWithdrawal);
									
								}
							}
							log.info("registered??" + examSchedule.getRegistrationStatus());
							log.info("send::::::::");
						}
						examSchedule.setExamFees(examUtil.calculateExamFee(themeDisplay, examSchedule));
						String applicationStartDate = commonApi
								.convertDateFormatToDDMMYYYY(examSchedule.getApplicationStartDate());
						String applicationEndDate = commonApi
								.convertDateFormatToDDMMYYYY(examSchedule.getApplicationEndDate());
						examSchedule.setApplicationStartDate(applicationStartDate);
						examSchedule.setApplicationEndDate(applicationEndDate);
						if (examSchedule.getExamStatus().equalsIgnoreCase("completed")) {
							ExamResultItem examResult = examUtil.getExamResultByScheduleIdAndDefnId(themeDisplay,
									themeDisplay.getUserId(), examSchedule.getExamDefinitionId(), examSchedule.getId());
							
							if (Validator.isNotNull(examResult)) {
								log.info("inside if result count");
								examSchedule.setResult(true);
							}
							
						}
						if (!examSchedule.isMultiDates()) {
							examSchedule
									.setExamDate(commonApi.convertObjectDateToDDMMYYYYDate(examSchedule.getExamDate()));
						} else {
							ExamMultiDatesItem examMultiDatesItem = getExamMultiByDesc(themeDisplay.getScopeGroupId(),themeDisplay.getPortalURL(),
									examSchedule.getExamScheduleAdminId());
							if (Validator.isNotNull(examMultiDatesItem)
									&& Validator.isNotNull(examMultiDatesItem.getItems())
									&& !examMultiDatesItem.getItems().isEmpty()) {

								examSchedule.setExamStartDate(
										commonApi.convertObjectDateToDDMMYYYYDate(examMultiDatesItem.getItems()
												.get(examMultiDatesItem.getItems().size() - 1).getExamDate()));
								examSchedule.setExamEndDate(commonApi.convertObjectDateToDDMMYYYYDate(
										examMultiDatesItem.getItems().get(0).getExamDate()));
								examSchedule.setExamDate(commonApi.convertObjectDateToDDMMYYYYDate(
										examMultiDatesItem.getItems().get(0).getExamDate()));
								examSchedule.setStartTime(examMultiDatesItem.getItems().get(0).getStartTime());
								examSchedule.setEndTime(examMultiDatesItem.getItems().get(0).getEndTime());
								examSchedule.setLocationOnGoogleMap(examMultiDatesItem.getItems().get(0).getLocationOnGoogleMap());
								examSchedule.setLocationOnGoogleMap(examMultiDatesItem.getItems().get(0).getVenue());
							}
						}
					log.info("==========================================================");
					log.info("User Program Id ... " + userProgramId);
					log.info("Program Id .... " + examSchedule.getProgramId());
					if (examSchedule.getProgramId() == userProgramId) {
						log.info("exam scheduled for " + examSchedule.toString());
						schedules.add(examSchedule);
					}
				}
				log.info("size of schedule::" + schedules.size());
				return schedules;
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		log.info("get trainee exam list method ended");
		return new ArrayList<>();
	}


	public long getUserProgramId(ThemeDisplay themeDisplay) {
		String url = themeDisplay.getPortalURL() + LRObjectURL.REG_USER_METADATA_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=lrUserId"
				+ URLEncoder.encode(" eq " + themeDisplay.getUserId(), StandardCharsets.UTF_8) + "&pageSize=0";
		log.info("URL ... " + url);
		String response = httpConnector.executeGet(url, "", commonApi.getHttpHeaderInfoAndBasicAuth());
		log.info("response" + response);
		Trainee trainees = CustomObjectMapperUtil.readValue(response, Trainee.class);
		if (Validator.isNotNull(trainees) && Validator.isNotNull(trainees.getItems())
				&& !trainees.getItems().isEmpty()) {
			log.info("Program Id ... " + trainees.getItems().get(0).getProgramId());

			return trainees.getItems().get(0).getProgramId();
		}

		return 0;
	}

	public int getNumberOfRegisteredUSers(String portalUrl, long groupId, long examScheduleId, String status) {

		String examRegistrationUrl = portalUrl + LRObjectURL.EXAM_REGISTERATION_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + groupId + StringPool.QUESTION + "filter=examScheduleId"
				+ URLEncoder.encode(" eq " + examScheduleId + " and registrationStatus eq " + "'" + status + "'",
						StandardCharsets.UTF_8)
				+ "&pageSize=0";

		log.info("/URL   " + examRegistrationUrl);
		String examRegistrationResponse = commonApi.getData(examRegistrationUrl);

		if (Validator.isNotNull(examRegistrationResponse)) {

			RegistrationItem registrationItem = CustomObjectMapperUtil.readValue(examRegistrationResponse,
					RegistrationItem.class);

			if (Validator.isNotNull(registrationItem) && Validator.isNotNull(registrationItem.getItems())
					&& registrationItem.getItems().size() > 0) {

				log.info("Size .... " + registrationItem.getItems().size());
				return registrationItem.getItems().size();
			}

		}
		return 0;

	}

	public ExamDefinition setExamDefinition(String portalURL, long groupId, long examId, String examJson) {

		try {
			JSONObject examJsonObject = JSONFactoryUtil.createJSONObject(examJson);
			log.info("examJson::" + examJson);
			log.info("reAppealWindow::" + examJsonObject.getString("reAppealWindow"));
			log.info("reAppealFees::" + examJsonObject.getString("reAppealFees"));
			JSONObject examDefinitionJsonObject = JSONFactoryUtil.createJSONObject();
			examDefinitionJsonObject.put("examId", examId);
			examDefinitionJsonObject.put("resultSource", examJsonObject.getString("resultSource"));
			examDefinitionJsonObject.put("earlyBirdFees", examJsonObject.getString("earlyBirdFees"));
			examDefinitionJsonObject.put("reappealWindow", examJsonObject.getString("reAppealWindow"));
			examDefinitionJsonObject.put("reappealFees", examJsonObject.getString("reAppealFees"));
			examDefinitionJsonObject.put("appealFees", examJsonObject.getString("appealFees"));
			examDefinitionJsonObject.put("appealWindow", examJsonObject.getString("appealWindow"));
			examDefinitionJsonObject.put("examEligibility", examJsonObject.getString("examEligibility"));
			examDefinitionJsonObject.put("examTypeId", examJsonObject.getString("examTypeId"));
			examDefinitionJsonObject.put("earlyBirdFeesDate", examJsonObject.getString("earlyBirdFeesDate"));
 			
			log.info("examDefinitionJsonObject:::" + examDefinitionJsonObject);
			return saveExamDefinition(portalURL, groupId, examDefinitionJsonObject.toString());

		} catch (JSONException e) {
			log.info(e.getMessage());
		}
		return null;

	}

	public ExamDefinition saveExamDefinition(String portalURL, long groupId, String examDefinitionJsonObject) {

		Map<String, String> headers = commonApi.getHttpHeaderInfoAndBasicAuth();

		String examDefinitionURL = portalURL + LRObjectURL.EXAM_DEFINITION_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + groupId;
		String examDefinitionResponse = httpConnector.executePost(examDefinitionURL, examDefinitionJsonObject, headers);
		log.info("examDefinitionResponse::?" + examDefinitionResponse);
		if (Validator.isNotNull(examDefinitionResponse)) {
			return CustomObjectMapperUtil.readValue(examDefinitionResponse, ExamDefinition.class);

		}
		return null;
	}

	public void setExamRegularFees(String portalURL, long groupId, long examDefinitionId, String examJson) {
		log.info("setExamRegularFees() started");
		log.info("exam defn id: setexam regular fee::" + examDefinitionId);
		if (examDefinitionId > 0 && Validator.isNotNull(examJson)) {
			try {
				JSONObject examRegularFeesJsonObject = JSONFactoryUtil.createJSONObject();
				examRegularFeesJsonObject.put("examDefinitionId", examDefinitionId);

				JSONObject examJsonObject = JSONFactoryUtil.createJSONObject(examJson);

				JSONArray regularFeesJsonArray = JSONFactoryUtil
						.createJSONArray(examJsonObject.getString("regularFees"));
				if (Validator.isNotNull(regularFeesJsonArray) && regularFeesJsonArray.length() > 0) {
					for (int i = 0; i < regularFeesJsonArray.length(); i++) {

						JSONObject regularFeesJson = regularFeesJsonArray.getJSONObject(i);
						log.info("regularFeesJson:::" + regularFeesJson);
						examRegularFeesJsonObject.put("noOfAttempts", regularFeesJson.getString("noOfAttempts"));
						examRegularFeesJsonObject.put("regularFee", regularFeesJson.getString("regularFee"));
						saveExamRegularFees(portalURL, groupId, examRegularFeesJsonObject.toString());
					}
				}
				log.info("setExamRegularFees() ended");
			} catch (JSONException e) {
				log.info(e.getMessage());
			}
		}
	}

	public RegularFees saveExamRegularFees(String portalURL, long groupId, String examRegularFeesJsonObject) {

		if (Validator.isNotNull(examRegularFeesJsonObject)) {
			Map<String, String> headers = commonApi.getHttpHeaderInfoAndBasicAuth();
			String examRegularFeesURL = portalURL + LRObjectURL.EXAM_REGULAR_FEES_URL + CommonConstants.SCOPES
					+ StringPool.SLASH + groupId;
			String examRegularFeesResponse = httpConnector.executePost(examRegularFeesURL, examRegularFeesJsonObject,
					headers);
			if (Validator.isNotNull(examRegularFeesResponse)) {
				return CustomObjectMapperUtil.readValue(examRegularFeesResponse, RegularFees.class);
			}
		}
		return null;
	}

	public void setExamWithdrawlFees(String portalURL, long groupId, long examDefinitionId, String examJson) {
		log.info("setExamWithdrawlFees() started");
		log.info("exam defn id: setexam regular fee::" + examDefinitionId);
		if (examDefinitionId > 0 && Validator.isNotNull(examJson)) {
			try {
				JSONObject withdrawalFeesJsonObject = JSONFactoryUtil.createJSONObject();
				withdrawalFeesJsonObject.put("examDefinitionId", examDefinitionId);

				JSONObject examJsonObject = JSONFactoryUtil.createJSONObject(examJson);
				JSONArray withdrawalFeesJsonArray = JSONFactoryUtil
						.createJSONArray(examJsonObject.getString("withdrawalFees"));
				if (Validator.isNotNull(withdrawalFeesJsonArray) && withdrawalFeesJsonArray.length() > 0) {
					for (int i = 0; i < withdrawalFeesJsonArray.length(); i++) {

						JSONObject withdrawalFeesJson = withdrawalFeesJsonArray.getJSONObject(i);

						withdrawalFeesJsonObject.put("noOfDays", withdrawalFeesJson.getString("noOfDays"));
						withdrawalFeesJsonObject.put("withdrawalFeesPercentage",
								withdrawalFeesJson.getString("withdrawalFeesPercentage"));
						log.info("withdrawalFeesJson::" + withdrawalFeesJsonObject);
						saveExamWithdrawalFees(portalURL, groupId, withdrawalFeesJsonObject.toString());
					}
				}
				log.info("setExamWithdrawlFees() ended");
			} catch (JSONException e) {
				log.info(e.getMessage());
			}
		}
	}

	public WithdrawalFees saveExamWithdrawalFees(String portalURL, long groupId, String examwithdrawlFeesJsonObject) {

		Map<String, String> headers = commonApi.getHttpHeaderInfoAndBasicAuth();
		String examWithdrawalFeesURL = portalURL + LRObjectURL.EXAM_WITHDRAWAL_FEES_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + groupId;
		log.info("examWithdrawalFeesURL:" + examWithdrawalFeesURL);
		String examWithdrawalFeesResponse = httpConnector.executePost(examWithdrawalFeesURL,
				examwithdrawlFeesJsonObject, headers);
		log.info("examWithdrawalFeesResponse::" + examWithdrawalFeesResponse);
		if (Validator.isNotNull(examWithdrawalFeesResponse)) {
			return CustomObjectMapperUtil.readValue(examWithdrawalFeesResponse, WithdrawalFees.class);
		}
		return null;
	}

	public void setExamEligibility(String portalURL, long groupId, long examDefinitionId, String examJson) {
		log.info("setExamEligibility() started");
		log.info("exam defn id: setexam regular fee::" + examDefinitionId);
		try {
			JSONObject examEligibilityJsonObject = JSONFactoryUtil.createJSONObject();
			examEligibilityJsonObject.put("examDefinitionId", examDefinitionId);

			JSONObject examJsonObject = JSONFactoryUtil.createJSONObject(examJson);
			JSONArray examEligibilityJsonArray = JSONFactoryUtil
					.createJSONArray(examJsonObject.getString("examEligibility2"));

			if (Validator.isNotNull(examEligibilityJsonArray) && examEligibilityJsonArray.length() > 0) {
				for (int i = 0; i < examEligibilityJsonArray.length(); i++) {

					JSONObject examEligibilityJson = examEligibilityJsonArray.getJSONObject(i);
					log.info("examEligibilityJson::" + examEligibilityJson);
					examEligibilityJsonObject.put("examTypeId", examEligibilityJson.getString("examType"));
					examEligibilityJsonObject.put("examEligibility", examEligibilityJson.getString("examEligibility"));
					saveExamEligibility(portalURL, groupId, examEligibilityJsonObject.toString());

				}
			}
			log.info("setExamEligibility() ended");
		} catch (JSONException e) {
			log.info(e.getMessage());
		}

	}

	public ExamEligibility saveExamEligibility(String portalURL, long groupId, String examEligibilityJsonObject) {

		Map<String, String> headers = commonApi.getHttpHeaderInfoAndBasicAuth();

		String examExamEligibilityURL = portalURL + LRObjectURL.EXAM_ELIGIBILITY_MAPPING_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + groupId;

		String examExamEligibilityResponse = httpConnector.executePost(examExamEligibilityURL,
				examEligibilityJsonObject, headers);

		if (Validator.isNotNull(examExamEligibilityResponse)) {
			ExamEligibility examEligibility = CustomObjectMapperUtil.readValue(examExamEligibilityResponse,
					ExamEligibility.class);
			return examEligibility;
		}
		return null;
	}

	public ExamMultiDatesItem getExamMultiByDesc(long scopeGroupId,String portalURL, long examScheduleAdminId) {
		try {
			String url = portalURL + LRObjectURL.EXAM_MULTIDATES_URL + CommonConstants.SCOPES
					+ StringPool.SLASH + scopeGroupId + StringPool.QUESTION
					+ "filter=examScheduleAdminId"
					+ URLEncoder.encode(" eq " + examScheduleAdminId, StandardCharsets.UTF_8) + "&sort=examDate:desc";

			log.info("url for multi:" + url);
			String examMultiDatesResponse = commonApi.getData(url);
			if (Validator.isNotNull(examMultiDatesResponse)) {
				log.debug("multischeduledExamResponse :" + examMultiDatesResponse);
				return CustomObjectMapperUtil.readValue(examMultiDatesResponse, ExamMultiDatesItem.class);
			}
		} catch (Exception e) {
			log.info(e.getMessage(), e);
		}
		return null;
	}

	public List<ExamSchedule> getExamScheduleList(ThemeDisplay themeDisplay) {
		List<ExamSchedule> examSchedules = new ArrayList<>();
		try {
			Map<String, String> headers = commonApi.getHttpHeaderInfoAndBasicAuth();
			String scheduleExamUrl = themeDisplay.getPortalURL() + LRObjectURL.EXAM_SCHEDULE_URL
					+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId()
					+ "?sort=examDate:desc&pageSize=0";
			String examScheduleResponse = commonApi.getData(scheduleExamUrl);
			log.info("scheduleExamUrl:: " + examScheduleResponse);
			if (Validator.isNotNull(examScheduleResponse)) {
				ExamScheduleItem examScheduleItem = CustomObjectMapperUtil.readValue(examScheduleResponse,
						ExamScheduleItem.class);
				if (Validator.isNotNull(examScheduleItem) && Validator.isNotNull(examScheduleItem.getItems())) {
					examSchedules = examScheduleItem.getItems();
					for (ExamSchedule examSchedule : examSchedules) {

						String examDefinitionURL = themeDisplay.getPortalURL() + LRObjectURL.EXAM_DEFINITION_URL
								+ examSchedule.getExamDefinitionId() + StringPool.QUESTION + "&pageSize=0";
						log.info("examDefinitionURL::" + examDefinitionURL);
						String examDefinitionResponse = httpConnector.executeGet(examDefinitionURL, "", headers);
						if (Validator.isNotNull(examDefinitionResponse)) {

							log.info("inside defn:::::");
							ExamDefinition examDefinitionItem = CustomObjectMapperUtil.readValue(examDefinitionResponse,
									ExamDefinition.class);
							log.info("defn response::" + examDefinitionResponse);

							if (Validator.isNotNull(examDefinitionItem)) {
								Exam exam = examUtil.getExamById(examDefinitionItem.getExamId(),
										themeDisplay.getPortalURL());

								examSchedule.setExamId(exam.getId());
								examSchedule.setExamTypeName(
										examUtil.getExamType(examSchedule.getExamType(), themeDisplay.getCompanyId(),themeDisplay.getPortalURL(),themeDisplay.getLocale()));
								// examSchedule.setExamDefinitionId(examDefinitionItem.getId());

							}
							String programName = examUtil.getProgramByProgramId(examSchedule.getProgramId(),
									themeDisplay);
							examSchedule.setProgramName(programName);
							// examSchedule.setId(examSchedules.getItems().get(i).getId());

							examSchedule.setApplicationStartDate(
									commonApi.convertObjectDateToDDMMYYYYDate(examSchedule.getApplicationStartDate()));
							examSchedule.setApplicationEndDate(
									commonApi.convertObjectDateToDDMMYYYYDate(examSchedule.getApplicationEndDate()));
							examSchedule.setExamDate(
										commonApi.convertObjectDateToDDMMYYYYDate(examSchedule.getExamDate()));
						}
					}
				}
			}

		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return examSchedules;
	}

	public ExamSchedule getScheduleById(long scheduleId, ThemeDisplay themeDisplay) {
		try {
			String scheduleExamUrl = themeDisplay.getPortalURL() + LRObjectURL.EXAM_SCHEDULE_URL + scheduleId
					+ StringPool.QUESTION + "&pageSize=0";
			String examScheduleResponse = commonApi.getData(scheduleExamUrl);
			log.info("examScheduleResponse :" + examScheduleResponse);
			ExamSchedule examSchedule = new ExamSchedule();
			if (Validator.isNotNull(examScheduleResponse)) {
				ExamSchedule examScheduleItem = CustomObjectMapperUtil.readValue(examScheduleResponse,
						ExamSchedule.class);
				examSchedule.setId(examScheduleItem.getId());
				if (!examScheduleItem.isMultiDates()) {
					examSchedule.setExamDate(commonApi.convertObjectDateToDDMMYYYYDate(examScheduleItem.getExamDate()));
				} else {
					ExamMultiDatesItem examMultiDatesItem = getExamMultiByDesc(themeDisplay.getScopeGroupId(),themeDisplay.getPortalURL(), examScheduleItem.getId());
					if (Validator.isNotNull(examMultiDatesItem) && Validator.isNotNull(examMultiDatesItem.getItems())
							&& !examMultiDatesItem.getItems().isEmpty()) {
						examSchedule.setExamEndDate(commonApi
								.convertObjectDateToDDMMYYYYDate(examMultiDatesItem.getItems().get(0).getExamDate()));
						examSchedule.setExamStartDate(commonApi.convertObjectDateToDDMMYYYYDate(examMultiDatesItem
								.getItems().get(examMultiDatesItem.getItems().size() - 1).getExamDate()));
						log.info("start date::" + examSchedule.getExamStartDate() + "end date"
								+ examSchedule.getExamEndDate());
					}
				}
				return examSchedule;
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return null;
	}

	public ExamDefinition getExamDefinitionById(ThemeDisplay themeDisplay, long examDefinitionId) {
		String getUrl = themeDisplay.getPortalURL() + LRObjectURL.EXAM_DEFINITION_URL + examDefinitionId;
		String response = commonApi.getData(getUrl);
		log.info("response of getExamDefinitionById ??" + response);
		return CustomObjectMapperUtil.readValue(response, ExamDefinition.class);
	}

	public JSONObject getEditedMultObjDetails(ThemeDisplay themeDisplay, long examMultiDateId) {
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		try {

			ExamMultiDatesItem multiDatesItem = getExamMultiDatesItemBasedOnMultExamDateId(themeDisplay,
					examMultiDateId);
			if (Validator.isNotNull(multiDatesItem)) {

				ExamMultiDates dates = multiDatesItem.getItems().get(0);
				jsonObject.put("examDate", dates.getExamDate());
				jsonObject.put("startTime", dates.getStartTime());
				jsonObject.put("endTime", dates.getEndTime());
				jsonObject.put("locationOnGoogleMap", dates.getLocationOnGoogleMap());
				jsonObject.put("locationPinOnGoogleMap", dates.getLocationPinOnGoogleMap());
				jsonObject.put("venue", dates.getVenue());

			}

		} catch (Exception e) {
			return null;
		}
		return jsonObject;
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

	public ExamMultiDatesItem getExamMultiDatesItemBasedOnMultExamDateId(ThemeDisplay themeDisplay,
			long examMultiDateId) {
		ExamMultiDatesItem multiDatesItem = new ExamMultiDatesItem();
		try {
			String examMultidatesURL = themeDisplay.getPortalURL() + LRObjectURL.EXAM_MULTIDATES_URL
					+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION
					+ "filter=id" + URLEncoder.encode(" eq " + "'" + examMultiDateId + "'", StandardCharsets.UTF_8)
					+ "&pageSize=0";
			String examMultidatesResponse = commonApi.getData(examMultidatesURL);

			if (Validator.isNotNull(examMultidatesResponse)) {
				multiDatesItem = CustomObjectMapperUtil.readValue(examMultidatesResponse, ExamMultiDatesItem.class);

				ExamMultiDates dates = multiDatesItem.getItems().get(0);
				dates.setExamDate(commonApi.convertObjectDateToDDMMYYYYDate(dates.getExamDate()));

			}
			return multiDatesItem;
		} catch (Exception e) {
			return null;
		}
	}

	public ExamMultiDatesItem getExamMultiDatesItemBasedOnScheduleId(ThemeDisplay themeDisplay, long scheduleId) {
		ExamMultiDatesItem multiDatesItem = new ExamMultiDatesItem();
		try {
			String examMultidatesURL = themeDisplay.getPortalURL() + LRObjectURL.EXAM_MULTIDATES_URL
					+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION
					+ "filter=examScheduleId" + URLEncoder.encode(" eq " + scheduleId, StandardCharsets.UTF_8)
					+ "&pageSize=0";
			String examMultidatesResponse = commonApi.getData(examMultidatesURL);

			if (Validator.isNotNull(examMultidatesResponse)) {
				multiDatesItem = CustomObjectMapperUtil.readValue(examMultidatesResponse, ExamMultiDatesItem.class);
				for (int i = 0; i < multiDatesItem.getItems().size(); i++) {
					ExamMultiDates dates = multiDatesItem.getItems().get(i);
					dates.setExamDate(commonApi.convertObjectDateToDDMMYYYYDate(dates.getExamDate()));
				}

			}
			return multiDatesItem;
		} catch (Exception e) {
			return null;
		}
	}

	public ExamMultiDatesItem getExamMultiDatesItemBasedOnScheduleAdminId(ThemeDisplay themeDisplay,
			long scheduleAdminId) {
		ExamMultiDatesItem multiDatesItem = new ExamMultiDatesItem();
		try {
			String examMultidatesURL = themeDisplay.getPortalURL() + LRObjectURL.EXAM_MULTIDATES_URL
					+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION
					+ "filter=examScheduleAdminId" + URLEncoder.encode(" eq " + scheduleAdminId, StandardCharsets.UTF_8)
					+ "&pageSize=0";
			String examMultidatesResponse = commonApi.getData(examMultidatesURL);

			if (Validator.isNotNull(examMultidatesResponse)) {
				multiDatesItem = CustomObjectMapperUtil.readValue(examMultidatesResponse, ExamMultiDatesItem.class);
				for (int i = 0; i < multiDatesItem.getItems().size(); i++) {
					ExamMultiDates dates = multiDatesItem.getItems().get(i);
					dates.setExamDate(commonApi.convertObjectDateToDDMMYYYYDate(dates.getExamDate()));
				}

			}
			return multiDatesItem;
		} catch (Exception e) {
			return null;
		}
	}

	public void setEducationDetails(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

		PortletRequestDispatcher dispatcher = resourceRequest.getPortletSession().getPortletContext()
				.getRequestDispatcher("/jsps/schedule/multiple-date-exam-list.jsp");
		try {
			dispatcher.include(resourceRequest, resourceResponse);
		} catch (PortletException | IOException e) {
			log.error(e.getMessage(), e);
		}
	}

	public ExamSchedule updateExamScheduleAndExamMultiDatesObject(long examId, long mdExamScheduleAdmnId,
			String valuesArray, String mdApplicationStartDate, String mdApplicationEndDate, int mdNoOfSeats,
			String status, ThemeDisplay themeDisplay, String selectedValues, long examScheduleAdminId) {

		ExamSchedule schedule = new ExamSchedule();
		try {
			long definationId = 0;

			JSONArray programArray = JSONFactoryUtil.createJSONArray(selectedValues);
			log.info("programArray >>>> "+programArray);
			Map<String, String> headers = commonApi.getHttpHeaderInfoAndBasicAuth();
			String url = themeDisplay.getPortalURL() + LRObjectURL.EXAM_SCHEDULE_URL + CommonConstants.SCOPES
					+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION
					+ "filter=examScheduleAdminId"
					+ URLEncoder.encode(" eq " + mdExamScheduleAdmnId, DataflowConstants.UTF_8) + "&pageSize=0";
			String response = httpConnector.executeGet(url, "", headers);
			ExamSchedule examSchedule = CustomObjectMapperUtil.readValue(response, ExamSchedule.class);

			String examObjectUrl = themeDisplay.getPortalURL() + LRObjectURL.EXAM_URL + CommonConstants.SCOPES
					+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=id"
					+ URLEncoder.encode(" eq " + "'" + examId + "'", DataflowConstants.UTF_8) + "&pageSize=0";
			String examResponse = commonApi.getData(examObjectUrl);

			if (Validator.isNotNull(examResponse)) {
				ExamItem examItem = CustomObjectMapperUtil.readValue(examResponse, ExamItem.class);
				Exam exam = CustomObjectMapperUtil.readValue(examResponse, Exam.class);
				if (Validator.isNotNull(examItem)) {
					String examJson = examItem.getItems().get(0).getExamJson();
					JSONObject examJsonJsonObject = JSONFactoryUtil.createJSONObject(examJson);
					ExamDefinition definitionItem = null;
					if (examItem.getItems().get(0).getChanged()) {
						// Dusring scheduling of Exam Changed Value will be updated to False from true.
						exam.setChanged(false);

						String examMapper = CustomObjectMapperUtil.writeValueAsString(exam, null);
						httpConnector.executePut(themeDisplay.getPortalURL() + LRObjectURL.EXAM_URL + exam.getId(),
								examMapper, headers);
						if (Validator.isNotNull(examJson)) {

							definitionItem = setExamDefinition(themeDisplay.getPortalURL(),
									themeDisplay.getScopeGroupId(), examItem.getItems().get(0).getId(), examJson);

							if (Validator.isNotNull(definitionItem)) {
								examSchedule.setExamDefinitionId(definitionItem.getId());
								definationId = definitionItem.getId();
								setExamRegularFees(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(),
										definitionItem.getId(), examJson);

								setExamWithdrawlFees(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(),
										definitionItem.getId(), examJson);

								setExamEligibility(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(),
										definitionItem.getId(), examJson);
							}
						}
					} else if (!examItem.getItems().get(0).getChanged()) {

						String examDefinitionUrl = themeDisplay.getPortalURL() + LRObjectURL.EXAM_DEFINITION_URL
								+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId()
								+ StringPool.QUESTION + "filter=examId" + URLEncoder
										.encode(" eq " + examItem.getItems().get(0).getId(), DataflowConstants.UTF_8)
								+ "&pageSize=0";
						String examDefinitionResponse = commonApi.getData(examDefinitionUrl);
						log.info("examDefinitionUrl::" + examDefinitionUrl);
						ExamDefinitionItem definition = CustomObjectMapperUtil.readValue(examDefinitionResponse,
								ExamDefinitionItem.class);
						definition.sortByIdInReverseOrder();

						definitionItem = definition.getItems().get(0);
						examSchedule.setExamDefinitionId(definitionItem.getId());
						definationId = definitionItem.getId();
					}

					ExamScheduleItem examScheduleItem = new ExamScheduleItem();

					if (examScheduleAdminId > 0) {

						examScheduleItem = getExamSchedulesByAdminId(examScheduleAdminId, themeDisplay);

					}

					// Update ExamScheduleAdmin object
					ExamScheduleAdmin admin = updateExamScheduleAdmin(0, 0, examScheduleAdminId, definationId,
							mdNoOfSeats, selectedValues, themeDisplay, headers, Boolean.TRUE);

					// update multidate Object
					if (Validator.isNotNull(admin)) {
						updateExamMultiDateObject(valuesArray, examSchedule, admin, themeDisplay, headers);
					}

					if (programArray.length() > 0) {
						for (int j = 0; j < programArray.length(); j++) {
							log.info("programArray.get(j)>>>>>>>>>>  " + programArray.get(j));
							log.info("Long.valueOf((String) programArray.get(j)) >>>> "
									+ Long.valueOf((String) programArray.get(j)));
							schedule = updateExamScheduleObj(themeDisplay, examSchedule, admin, mdApplicationStartDate,
									mdApplicationEndDate, mdNoOfSeats, status, mdExamScheduleAdmnId, headers,
									examScheduleItem, Long.valueOf((String) programArray.get(j)), examJsonJsonObject);
							
						}
					}
					if (Validator.isNotNull(schedule)) {
						ExamMultiDatesItem examMultiDateItem = getExamMultiByDesc(themeDisplay.getScopeGroupId(),themeDisplay.getPortalURL(),
								examScheduleAdminId);
						if (Validator.isNotNull(examMultiDateItem)
								&& Validator.isNotNull(examMultiDateItem.getItems())
								&& !examMultiDateItem.getItems().isEmpty()) {
							ExamMultiDates examMultiDates = examMultiDateItem.getItems().get(0);
							schedule.setExamDate(examMultiDates.getExamDate());
							schedule.setStartTime(examMultiDates.getStartTime());
							schedule.setEndTime(examMultiDates.getEndTime());
							schedule.setLocationOnGoogleMap(examMultiDates.getLocationOnGoogleMap());
							schedule.setLocationPinOnGoogleMap(examMultiDates.getLocationPinOnGoogleMap());
							schedule.setVenue(examMultiDates.getVenue());
						}
						schedule.setExamTypeName(examUtil.getExamType(schedule.getExamType(), themeDisplay.getCompanyId(),themeDisplay.getPortalURL(),themeDisplay.getLocale()));
						if (schedule.getExamStatus().equalsIgnoreCase(OMSBExamWebPortletKeys.ANNOUNCED)) {
							log.info("examSchedule notification trainee list ::" + schedule.getProgramId() + " "
									+ exam.getExamTypeId() + " " + definitionItem.getId());
							List<TraineeItem> traineeItem = examUtil.getTraineeByRoleAndProgram(themeDisplay,
									schedule.getProgramId(), exam.getExamTypeId(), definitionItem.getId(), schedule);
							
							
							log.info("traineeItem size ::" + traineeItem.size());
							schedule=setSchedularWithMutiDates(schedule, themeDisplay.getScopeGroupId(),themeDisplay.getPortalURL());
							for (TraineeItem trainee : traineeItem) {

								examNotificationUtil.sendLRUserNotification(themeDisplay.getScopeGroupId(),
										trainee.getLrUserId(), MVCCommands.EXAM_SCHEDULE_ANNOUNCEMENT_NOTFICATION, true,
										schedule);
								commonApi.sendMobileNotification(
										examUtil.getUserMobileNumber(themeDisplay, trainee.getLrUserId()),
										"Exam Announced");
							}
						}

						String examScheduleMapper = CustomObjectMapperUtil.writeValueAsString(schedule, null);
						String examScheduleResponse = httpConnector.executePut(
								themeDisplay.getPortalURL() + LRObjectURL.EXAM_SCHEDULE_URL + schedule.getId(),
								examScheduleMapper, headers);
						schedule = CustomObjectMapperUtil.readValue(examScheduleResponse, ExamSchedule.class);

					}
				}
			}
			return schedule;
		} catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}
	}

	public ExamScheduleItem getExamSchedulesByAdminId(long examScheduleAdminId, ThemeDisplay themeDisplay) {

		String examScheduleURL;
		try {
			examScheduleURL = themeDisplay.getPortalURL() + LRObjectURL.EXAM_SCHEDULE_URL + CommonConstants.SCOPES
					+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION
					+ "filter=examScheduleAdminId"
					+ URLEncoder.encode(" eq " + examScheduleAdminId, DataflowConstants.UTF_8) + "&pageSize=0";

			String examScheduleResponse = commonApi.getData(examScheduleURL);

			if (Validator.isNotNull(examScheduleResponse)) {

				ExamScheduleItem examScheduleItem = CustomObjectMapperUtil.readValue(examScheduleResponse,
						ExamScheduleItem.class);

				if (Validator.isNotNull(examScheduleItem) && Validator.isNotNull(examScheduleItem.getItems())
						&& examScheduleItem.getItems().size() > 0) {

					return examScheduleItem;
				}
			}

		} catch (UnsupportedEncodingException e) {
			log.error(e);
		}
		return null;
	}

	public ExamScheduleAdmin updateExamScheduleAdmin(long applicantionStartFromNoOfDays, long applicationEndAtNoOfDays,
			long examScheduleAdminId, long definationId, long mdNoOfSeats, String selectedValues,
			ThemeDisplay themeDisplay, Map<String, String> headers, boolean isMultiDates) {
		ExamScheduleAdmin examScheduleAdmin = new ExamScheduleAdmin();
		ExamScheduleAdmin examScheduleAdminResponseObj = new ExamScheduleAdmin();

		try {

			examScheduleAdmin.setApplicationStartFromNoOfDays(
					(applicantionStartFromNoOfDays > 0) ? applicantionStartFromNoOfDays : 0);
			examScheduleAdmin
					.setApplicationEndAtNoOfDays((applicationEndAtNoOfDays > 0) ? applicationEndAtNoOfDays : 0);

			examScheduleAdmin.setExamDefinitionId(definationId);
			examScheduleAdmin.setMultiDates(isMultiDates);
			examScheduleAdmin.setNoOfSeats((mdNoOfSeats > 0) ? mdNoOfSeats : 0);
			examScheduleAdmin.setProgramIds(selectedValues);

			if (examScheduleAdminId == 0) {

				String examScheduleAdminMapper = CustomObjectMapperUtil.writeValueAsString(examScheduleAdmin, null);

				String examScheduleAdminURL = themeDisplay.getPortalURL() + LRObjectURL.EXAM_SCHEDULE_ADMIN_URL
						+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId();

				String examScheduleAdminResponse = httpConnector.executePost(examScheduleAdminURL,
						examScheduleAdminMapper, headers);

				examScheduleAdminResponseObj = CustomObjectMapperUtil.readValue(examScheduleAdminResponse,
						ExamScheduleAdmin.class);

			} else if (examScheduleAdminId > 0) {

				String examScheduleAdminMapper = CustomObjectMapperUtil.writeValueAsString(examScheduleAdmin, null);

				String examScheduleAdminResponse = httpConnector.executePut(
						themeDisplay.getPortalURL() + LRObjectURL.EXAM_SCHEDULE_ADMIN_URL + examScheduleAdminId,
						examScheduleAdminMapper, headers);

				examScheduleAdminResponseObj = CustomObjectMapperUtil.readValue(examScheduleAdminResponse,
						ExamScheduleAdmin.class);

			}
		} catch (Exception e) {
			return null;
		}
		return examScheduleAdminResponseObj;
	}

	public void updateExamMultiDateObject(String valuesArray, ExamSchedule schedule, ExamScheduleAdmin admin,
			ThemeDisplay themeDisplay, Map<String, String> headers) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		try {
			ExamMultiDates examMultiDate = new ExamMultiDates();
			jsonArray = JSONFactoryUtil.createJSONArray(valuesArray);
			if (jsonArray.length() > 0) {
				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject valueJson = jsonArray.getJSONObject(i);
					long multExmId = valueJson.getLong("id");

					if (multExmId == 0) {
						// Add Data if Not present in DB
						examMultiDate = setMultiExamDatesValueFromObj(examMultiDate, valueJson, schedule,
								admin.getId());

						String examMultiDatesMapper = CustomObjectMapperUtil.writeValueAsString(examMultiDate, null);
						String examMultiDatesURL = themeDisplay.getPortalURL() + LRObjectURL.EXAM_MULTIDATES_URL
								+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId();
						httpConnector.executePost(examMultiDatesURL, examMultiDatesMapper, headers);
					} else {
						// update Data if already present in DB
						ExamMultiDatesItem multiDatesItem = getExamMultiDatesItemBasedOnMultExamDateId(themeDisplay,
								multExmId);

						if (Validator.isNotNull(multiDatesItem)) {
							examMultiDate = setMultiExamDatesValueFromObj(multiDatesItem.getItems().get(0), valueJson,
									schedule, admin.getId());

							String multiDateMap = CustomObjectMapperUtil.writeValueAsString(examMultiDate, null);

							httpConnector.executePut(themeDisplay.getPortalURL() + LRObjectURL.EXAM_MULTIDATES_URL
									+ examMultiDate.getId(), multiDateMap, headers);
						}
					}

				}
			}
		} catch (Exception e) {

		}

	}

	public ExamSchedule updateExamScheduleObj(ThemeDisplay themeDisplay, ExamSchedule examSchedule,
			ExamScheduleAdmin admin, String mdApplicationStartDate, String mdApplicationEndDate, int mdNoOfSeats,
			String status, long examScheduleId, Map<String, String> headers, ExamScheduleItem examScheduleItem,
			long programId, JSONObject examJsonJsonObject) {
		ExamSchedule examScheduleRespObj = new ExamSchedule();
		try {

			log.info("mdcmd::" + status);
			long examTypId = Validator.isNotNull(examJsonJsonObject.getString("examTypeId"))
					? Long.parseLong(examJsonJsonObject.getString("examTypeId"))
					: 0;
			if (Validator.isNotNull(examScheduleItem) && Validator.isNotNull(examScheduleItem.getItems())) {

				for (int i = 0; i < examScheduleItem.getItems().size(); i++) {
					if (examScheduleItem.getItems().get(i).getProgramId() == programId) {
						ExamSchedule schedule = new ExamSchedule();

						schedule.setId(examScheduleItem.getItems().get(i).getId());
						schedule.setApplicationStartDate(
								commonApi.convertDDMMYYYYDateToObjectDate(mdApplicationStartDate));
						schedule.setApplicationEndDate(commonApi.convertDDMMYYYYDateToObjectDate(mdApplicationEndDate));
						schedule.setNoOfSeats(mdNoOfSeats);
						schedule.setMultiDates(Boolean.TRUE);
						schedule.setExamStatus(status);
						schedule.setProgramId(programId);
						schedule.setExamScheduleAdminId(admin.getId());
						schedule.setExamType(examTypId);
						schedule.setExamDefinitionId(admin.getExamDefinitionId());
						schedule.setExamTypeName(examUtil.getExamType(examTypId, themeDisplay.getCompanyId(), themeDisplay.getPortalURL(), themeDisplay.getLocale()));
						log.info("examScheduleId::" + examScheduleItem.getItems().get(i).getId());
						String examScheduleMapper = CustomObjectMapperUtil.writeValueAsString(schedule, null);
						String examScheduleResponse = httpConnector
								.executePut(
										themeDisplay.getPortalURL() + LRObjectURL.EXAM_SCHEDULE_URL
												+ examScheduleItem.getItems().get(i).getId(),
										examScheduleMapper, headers);
						examScheduleRespObj = CustomObjectMapperUtil.readValue(examScheduleResponse,
								ExamSchedule.class);
					}
				}

			} else {

				examSchedule.setId(examSchedule.getId());
				examSchedule.setApplicationStartDate(commonApi.convertDDMMYYYYDateToObjectDate(mdApplicationStartDate));
				examSchedule.setApplicationEndDate(commonApi.convertDDMMYYYYDateToObjectDate(mdApplicationEndDate));
				examSchedule.setNoOfSeats(mdNoOfSeats);
				examSchedule.setMultiDates(Boolean.TRUE);
				examSchedule.setExamStatus(status);
				examSchedule.setProgramId(programId);
				examSchedule.setExamScheduleAdminId(admin.getId());
				examSchedule.setExamType(examTypId);
				examSchedule.setExamTypeName(examUtil.getExamType(examTypId, themeDisplay.getCompanyId(), themeDisplay.getPortalURL(), themeDisplay.getLocale()));				examSchedule.setExamDefinitionId(admin.getExamDefinitionId());
				String examScheduleMapper = CustomObjectMapperUtil.writeValueAsString(examSchedule, null);

				String examScheduleURL = themeDisplay.getPortalURL() + LRObjectURL.EXAM_SCHEDULE_URL
						+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId();
				String examScheduleResponse = httpConnector.executePost(examScheduleURL, examScheduleMapper, headers);
				examScheduleRespObj = CustomObjectMapperUtil.readValue(examScheduleResponse, ExamSchedule.class);

			}

		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return examScheduleRespObj;
	}

	public ExamMultiDates setMultiExamDatesValueFromObj(ExamMultiDates examMultiDatesObj, JSONObject valueJson,
			ExamSchedule schedule, long examScheduleAdminid) {
		examMultiDatesObj.setExamDate(commonApi.convertDDMMYYYYDateToObjectDate(valueJson.getString("examDate")));
		examMultiDatesObj.setStartTime(convertTimeForObject(valueJson.getString("startTime")));
		examMultiDatesObj.setEndTime(convertTimeForObject(valueJson.getString("endTime")));
		examMultiDatesObj.setVenue(valueJson.getString("venue"));
		examMultiDatesObj.setLocationOnGoogleMap(valueJson.getString("locationOnGoogleMap"));
		examMultiDatesObj.setLocationPinOnGoogleMap(valueJson.getString("locationPinOnGoogleMap"));
		examMultiDatesObj.setExamScheduleId(schedule.getId());
		examMultiDatesObj.setExamScheduleAdminId(examScheduleAdminid);
		return examMultiDatesObj;
	}

	public ExamSchedule saveAndUpdateRepeatedInstanceObject(String status, String riExamStartFrom, String riExamEndOn,
			long riApplicationStartDaysBefore, long riApplicationEndsDaysBefore, long examTypeId, long examId,
			String saveRepeatedInstance, ThemeDisplay themeDisplay, long examScheduleAdminId, String selectedValues,
			long mdNoOfSeats) {
		ExamSchedule examSchedule = new ExamSchedule();
		ExamSchedule examScheduleResponseObj = new ExamSchedule();
		log.info("status-- >" + status + " examTypeId >> " + examTypeId + " examScheduleAdminId >> "
				+ examScheduleAdminId + " riExamStartFrom >> " + riExamStartFrom + " riExamEndOn >> " + riExamEndOn
				+ " examId >> " + examId);
		log.info("selectedValues-- >" + selectedValues + " saveRepeatedInstance >> " + saveRepeatedInstance);
		long examTypId = 0;
		try {

			JSONArray programArray = JSONFactoryUtil.createJSONArray(selectedValues);

			Map<String, String> headers = commonApi.getHttpHeaderInfoAndBasicAuth();
			String examUrl = themeDisplay.getPortalURL() + LRObjectURL.EXAM_URL + CommonConstants.SCOPES
					+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=id"
					+ URLEncoder.encode(" eq " + "'" + examId + "'", DataflowConstants.UTF_8) + "&pageSize=0";
			String examResponse = commonApi.getData(examUrl);
			long definitionId = 0;
			ExamDefinition definitionItem = null;
			if (Validator.isNotNull(examResponse)) {
				ExamItem examItem = CustomObjectMapperUtil.readValue(examResponse, ExamItem.class);
				Exam exam = CustomObjectMapperUtil.readValue(examResponse, Exam.class);
				if (Validator.isNotNull(examItem)) {
					log.info("examItem.size >> " + examItem);
					String examJson = examItem.getItems().get(0).getExamJson();
					JSONObject examJsonJsonObject = JSONFactoryUtil.createJSONObject(examJson);
					examTypId = Validator.isNotNull(examJsonJsonObject.getString("examTypeId"))
							? Long.parseLong(examJsonJsonObject.getString("examTypeId"))
							: 0;
					if (examItem.getItems().get(0).getChanged()) {
						exam.setId(examItem.getItems().get(0).getId());
						exam.setChanged(false);
						exam.setExamJson(examJson);
						exam.setExamTypeId(examItem.getItems().get(0).getExamTypeId());
						exam.setProgram(examItem.getItems().get(0).getProgram());
						String examMapper = CustomObjectMapperUtil.writeValueAsString(exam, null);
						httpConnector.executePut(themeDisplay.getPortalURL() + LRObjectURL.EXAM_URL + exam.getId(),
								examMapper, headers);

						if (Validator.isNotNull(examJson)) {
							definitionItem = setExamDefinition(themeDisplay.getPortalURL(),
									themeDisplay.getScopeGroupId(), examItem.getItems().get(0).getId(), examJson);
							definitionId = definitionItem.getId();

							if (Validator.isNotNull(definitionItem)) {
								setExamRegularFees(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(),
										definitionItem.getId(), examJson);
								setExamWithdrawlFees(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(),
										definitionItem.getId(), examJson);
								setExamEligibility(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(),
										definitionItem.getId(), examJson);
							}
						}
					} else if (!examItem.getItems().get(0).getChanged()) {
						String examDefinitionUrl = themeDisplay.getPortalURL() + LRObjectURL.EXAM_DEFINITION_URL
								+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId()
								+ StringPool.QUESTION + "filter=examId" + URLEncoder
										.encode(" eq " + examItem.getItems().get(0).getId(), DataflowConstants.UTF_8)
								+ "&pageSize=0";
						String examDefinitionResponse = commonApi.getData(examDefinitionUrl);
						ExamDefinitionItem definition = CustomObjectMapperUtil.readValue(examDefinitionResponse,
								ExamDefinitionItem.class);
						definition.sortByIdInReverseOrder();
						definitionId = definition.getItems().get(0).getId();
					}

					// Update ExamScheduleAdmin object
					ExamScheduleAdmin admin = updateExamScheduleAdmin(riApplicationStartDaysBefore,
							riApplicationEndsDaysBefore, examScheduleAdminId, definitionId, mdNoOfSeats, selectedValues,
							themeDisplay, headers, Boolean.FALSE);
					log.info("ExamScheduleAdmin Object >> " + admin);
					try {
						if (Validator.isNotNull(admin)) {
							updateExamMultiDate(saveRepeatedInstance, examSchedule, admin, themeDisplay, headers);
						}

					} catch (Exception e) {
						log.info("Excdption during saving of multidateObject " + e);
						log.error("Excdption during saving of multidateObject " + e);
					}

					JSONArray jsonArray = JSONFactoryUtil.createJSONArray(saveRepeatedInstance);
					log.info("JSONArray  JSONArray  ....  " + jsonArray.length());
					if (Validator.isNotNull(jsonArray)) {

						Date examStartDate = commonApi.convertStringToDate(riExamStartFrom);
						LocalDate examStartLocalDate = examStartDate.toInstant().atZone(ZoneId.systemDefault())
								.toLocalDate();
						Date examEndDate = commonApi.convertStringToDate(riExamEndOn);
						LocalDate examEndLocalDate = examEndDate.toInstant().atZone(ZoneId.systemDefault())
								.toLocalDate();
						LocalDate applicationStartLocalDate = examStartDate.toInstant().atZone(ZoneId.systemDefault())
								.toLocalDate().minusDays(riApplicationStartDaysBefore);
						Date applicationStartDate = Date
								.from(applicationStartLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
						LocalDate applicationEndLocalDate = examStartDate.toInstant().atZone(ZoneId.systemDefault())
								.toLocalDate().minusDays(riApplicationEndsDaysBefore);
						Date applicationEndDate = Date
								.from(applicationEndLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
						long numOfDays = ChronoUnit.DAYS.between(examStartLocalDate, examEndLocalDate);

						log.info("JSON Array---" + jsonArray);
						for (int i = 0; i < jsonArray.length(); i++) {
							JSONObject valueJson = jsonArray.getJSONObject(i);

							String arrayOfWeek = valueJson.getString("riDaysOfWeek");
							arrayOfWeek = arrayOfWeek.replace("\\", "");
							JSONArray daysOfWeekJsonArray = JSONFactoryUtil.createJSONArray(arrayOfWeek);
							log.info(" daysOfWeekJsonArray JSON Array---" + daysOfWeekJsonArray);
							for (int j = 0; j < daysOfWeekJsonArray.length(); j++) {
								log.info(" daysOfWeekJsonArray JSON Array length---" + daysOfWeekJsonArray.length());
								if (numOfDays > 0) {
									final String weekDays = daysOfWeekJsonArray.getString(j);
									List<LocalDate> daysRange = Stream
											.iterate(examStartLocalDate, date -> date.plusDays(1)).limit(numOfDays)
											.filter(date -> date.getDayOfWeek() == getDayOfWeek(weekDays))
											.collect(Collectors.toList());
									log.info("daysRange ---" + daysRange);
									if (daysRange.size() > 0) {

										for (LocalDate examDate : daysRange) {
											String convertedExamDate = commonApi
													.convertYYYYMMDDLocalDatetoObjectDate(examDate);
											if (programArray.length() > 0) {
												log.info("programArray ---" + programArray);
												for (int k = 0; k < programArray.length(); k++) {
													log.info("programArray length ---" + programArray.length());

													List<ExamSchedule> ec = getscheduleExamListByScheduleAdminIdAndProgramId(
															themeDisplay, admin.getId(),
															Long.parseLong(programArray.get(k).toString()),
															convertedExamDate);
													log.info("ExamSchedule list size ---" + ec.size());

													if (Validator.isNotNull(ec) && ec.size() > 0) {
														examSchedule = ec.get(0);
														log.info("ExamSchedule object ---" + examSchedule);
														examSchedule = setExamScheduleObjectValue(
																examScheduleResponseObj, valueJson, definitionId,
																programArray, admin, examDate, status, examTypeId,
																applicationStartDate, applicationEndDate, themeDisplay,
																k);
														String examScheduleMapper = CustomObjectMapperUtil
																.writeValueAsString(examSchedule, null);
														String examScheduleResponse = httpConnector.executePut(
																themeDisplay.getPortalURL()
																		+ LRObjectURL.EXAM_SCHEDULE_URL
																		+ ec.get(i).getId(),
																examScheduleMapper, headers);
														examScheduleResponseObj = CustomObjectMapperUtil
																.readValue(examScheduleResponse, ExamSchedule.class);
													} else {
														examSchedule = new ExamSchedule();
														examSchedule = setExamScheduleObjectValue(
																examScheduleResponseObj, valueJson, definitionId,
																programArray, admin, examDate, status, examTypeId,
																applicationStartDate, applicationEndDate, themeDisplay,
																k);
														String examScheduleMapper = CustomObjectMapperUtil
																.writeValueAsString(examSchedule, null);
														String examScheduleResponse = httpConnector
																.executePost(
																		(themeDisplay.getPortalURL()
																				+ LRObjectURL.EXAM_SCHEDULE_URL
																				+ CommonConstants.SCOPES
																				+ StringPool.SLASH
																				+ String.valueOf(themeDisplay
																						.getScopeGroupId())),
																		examScheduleMapper, headers);

														examScheduleResponseObj = CustomObjectMapperUtil
																.readValue(examScheduleResponse, ExamSchedule.class);

													}
													log.info("examScheduleResponseObj object ---"
															+ examScheduleResponseObj);

													if (Validator.isNotNull(examScheduleResponseObj)) {
														try {
															if (examScheduleResponseObj.getExamStatus()
																	.equalsIgnoreCase(
																			OMSBExamWebPortletKeys.ANNOUNCED)) {
																log.info("examSchedule notification trainee list ::"
																		+ examScheduleResponseObj.getProgramId() + " "
																		+ exam.getExamTypeId() + " "
																		+ definitionItem.getId());
																List<TraineeItem> traineeItem = examUtil
																		.getTraineeByRoleAndProgram(themeDisplay,
																				examScheduleResponseObj.getProgramId(),
																				exam.getExamTypeId(),
																				definitionItem.getId(),
																				examScheduleResponseObj);
																ExamMultiDatesItem examMultiDateItem = getExamMultiByDesc(
																		themeDisplay.getScopeGroupId(),themeDisplay.getPortalURL(), examScheduleAdminId);
																if (Validator.isNotNull(examMultiDateItem)
																		&& Validator
																				.isNotNull(examMultiDateItem.getItems())
																		&& !examMultiDateItem.getItems().isEmpty()) {
																	ExamMultiDates examMultiDates = examMultiDateItem
																			.getItems().get(0);
																	examScheduleResponseObj
																			.setExamDate(examMultiDates.getExamDate());
																	examScheduleResponseObj.setStartTime(
																			examMultiDates.getStartTime());
																}

																log.info("traineeItem size ::" + traineeItem.size());
																for (TraineeItem trainee : traineeItem) {

																	examNotificationUtil.sendLRUserNotification(
																			themeDisplay.getScopeGroupId(),
																			trainee.getLrUserId(),
																			MVCCommands.EXAM_SCHEDULE_ANNOUNCEMENT_NOTFICATION,
																			true, examScheduleResponseObj);
																	commonApi.sendMobileNotification(
																			examUtil.getUserMobileNumber(themeDisplay,
																					trainee.getLrUserId()),
																			"Exam Announced");
																}
															}
														} catch (Exception e) {
															log.info("Exception during sending notification" + e);
														}

													}

												}

											}
										}
									}

								}

							}
						}

					}
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			return examScheduleResponseObj;
		}
		return examScheduleResponseObj;
	}

	public ExamSchedule setExamScheduleObjectValue(ExamSchedule examSchedule, JSONObject valueJson, long definitionId,
			JSONArray programArray, ExamScheduleAdmin admin, LocalDate examDate, String status, long examTypeId,
			Date applicationStartDate, Date applicationEndDate, ThemeDisplay themeDisplay, int k) {
		examSchedule.setExamDate(commonApi.convertYYYYMMDDLocalDatetoObjectDate(examDate));
		examSchedule.setStartTime(valueJson.getString("riExamStartTime"));
		examSchedule.setEndTime(valueJson.getString("riExamEndTime"));
		examSchedule.setVenue(valueJson.getString("mdVenue"));
		examSchedule.setLocationOnGoogleMap(valueJson.getString("riLocationOnGoogleMap"));
		examSchedule.setLocationPinOnGoogleMap(valueJson.getString("riLocationPinOnGoogleMap"));
		examSchedule.setNoOfSeats(Integer.parseInt(valueJson.getString("riNoOfSeats")));
		examSchedule.setMultiDates(Boolean.FALSE);
		examSchedule.setRegistered(Boolean.FALSE);
		examSchedule.setExamDefinitionId(definitionId);
		examSchedule.setProgramId(Long.valueOf((String) programArray.get(k)));
		examSchedule.setExamScheduleAdminId(admin.getId());
		examSchedule.setExamStatus(status);
		examSchedule.setApplicationStartDate(commonApi.convertDateToObjectDateString(applicationStartDate));
		examSchedule.setApplicationEndDate(commonApi.convertDateToObjectDateString(applicationEndDate));
		examSchedule.setExamType(examTypeId);
		examSchedule
				.setExamTypeName(commonApi.getListTypeEntryNameBylistTypeEntryId(examTypeId, themeDisplay.getLocale()));
		examSchedule.setExamDefinitionId(definitionId);
		return examSchedule;
	}

	public ExamScheduleItem getscheduleExamByStatusAndMultiDates(ThemeDisplay themeDisplay, String status,
			boolean isMultiDates) {

		String examScheduleURL = themeDisplay.getPortalURL() + LRObjectURL.EXAM_SCHEDULE_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=examStatus"
				+ URLEncoder.encode(" eq " + status + " and multiDates eq " + isMultiDates, StandardCharsets.UTF_8)
				+ "&pageSize=0";
		String examScheduleResponse = commonApi.getData(examScheduleURL);

		return CustomObjectMapperUtil.readValue(examScheduleResponse, ExamScheduleItem.class);

	}

	public List<ExamSchedule> getscheduleExamListByScheduleAdminIdAndProgramId(ThemeDisplay themeDisplay,
			long examScheduleAdminId, long programId, String examDate) {
		ExamScheduleItem examScheduleItem = new ExamScheduleItem();
		List<ExamSchedule> ec = null;
		try {
			// Date date=new
			// SimpleDateFormat(DataflowConstants.OBJECT_DATE_FORMAT).parse(examDate);

			String examScheduleURL = themeDisplay.getPortalURL() + LRObjectURL.EXAM_SCHEDULE_URL
					+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION
					+ "filter=examScheduleAdminId"
					+ URLEncoder.encode(" eq " + examScheduleAdminId + " and programId eq " + programId,
							StandardCharsets.UTF_8)
					+ "&pageSize=0";
			String examScheduleResponse = commonApi.getData(examScheduleURL);
			examScheduleItem = CustomObjectMapperUtil.readValue(examScheduleResponse, ExamScheduleItem.class);
			if (Validator.isNotNull(examScheduleItem)) {
				ec = examScheduleItem.getItems().stream().filter(n -> n.getExamDate().equalsIgnoreCase(examDate))
						.collect(Collectors.toList());

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		return ec;
	}

	private void updateExamMultiDate(String saveRepeatedInstance, ExamSchedule examSchedule, ExamScheduleAdmin admin,
			ThemeDisplay themeDisplay, Map<String, String> headers) {

		try {
			JSONArray jsonArray = JSONFactoryUtil.createJSONArray(saveRepeatedInstance);

			for (int i = 0; i < jsonArray.length(); i++) {

				ExamMultiDates examMultiDates = new ExamMultiDates();

				JSONObject valueJson = jsonArray.getJSONObject(i);

				long multExmId = valueJson.getLong("id");

				if (multExmId == 0) {

					examMultiDates.setExamScheduleAdminId(admin.getId());
					examMultiDates.setStartTime(convertTimeForObject(valueJson.getString("riExamStartTime")));
					examMultiDates.setEndTime(convertTimeForObject(valueJson.getString("riExamEndTime")));
					examMultiDates.setVenue(valueJson.getString("mdVenue"));
					examMultiDates.setLocationOnGoogleMap(valueJson.getString("riLocationOnGoogleMap"));
					examMultiDates.setLocationPinOnGoogleMap(valueJson.getString("riLocationPinOnGoogleMap"));
					examMultiDates.setNoOfSeats(valueJson.getInt("riNoOfSeats"));
					examMultiDates.setDaysOfWeek(valueJson.getString("riDaysOfWeek"));

					String examMultiDateMapper = CustomObjectMapperUtil.writeValueAsString(examMultiDates, null);

					httpConnector.executePost(
							(themeDisplay.getPortalURL() + LRObjectURL.EXAM_MULTIDATES_URL + CommonConstants.SCOPES
									+ StringPool.SLASH + String.valueOf(themeDisplay.getScopeGroupId())),
							examMultiDateMapper, headers);

				} else {

					ExamMultiDatesItem multiDatesItem = getExamMultiDatesItemBasedOnMultExamDateId(themeDisplay,
							multExmId);

					if (Validator.isNotNull(multiDatesItem)) {
						examMultiDates = multiDatesItem.getItems().get(0);
						examMultiDates.setExamScheduleAdminId(admin.getId());
						examMultiDates.setStartTime(convertTimeForObject(valueJson.getString("riExamStartTime")));
						examMultiDates.setEndTime(convertTimeForObject(valueJson.getString("riExamEndTime")));
						examMultiDates.setVenue(valueJson.getString("mdVenue"));
						examMultiDates.setLocationOnGoogleMap(valueJson.getString("riLocationOnGoogleMap"));
						examMultiDates.setLocationPinOnGoogleMap(valueJson.getString("riLocationPinOnGoogleMap"));
						examMultiDates.setNoOfSeats(valueJson.getInt("riNoOfSeats"));
						examMultiDates.setDaysOfWeek(valueJson.getString("riDaysOfWeek"));

						String multiDateMap = CustomObjectMapperUtil.writeValueAsString(examMultiDates, null);

						httpConnector.executePut(
								themeDisplay.getPortalURL() + LRObjectURL.EXAM_MULTIDATES_URL + examMultiDates.getId(),
								multiDateMap, headers);
					}
				}
			}
		} catch (JSONException e) {
			log.error(e);
		}
	}

	public String convertTimeForObject(String tm) {
		String time = "";
		if (tm.indexOf(':') != 2) {
			tm = 0 + tm;
		}

		if (tm.indexOf(' ') == 6) {
			StringBuilder builder = new StringBuilder(tm);
			builder.deleteCharAt(5);
			time = builder.toString();
		} else {
			time = tm;
		}
		return time;
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

	public void saveSingleInstanceObj(ActionRequest actionRequest, ThemeDisplay themeDisplay, long examTypeId,
			long examId, String status) {
		Map<String, String> headers = commonApi.getHttpHeaderInfoAndBasicAuth();
		long examScheduleId = ParamUtil.getLong(actionRequest, "examScheduleId");
		String url = themeDisplay.getPortalURL() + LRObjectURL.EXAM_SCHEDULE_URL + examScheduleId;
		String response = httpConnector.executeGet(url, "", headers);
		ExamSchedule examScheduleItem = CustomObjectMapperUtil.readValue(response, ExamSchedule.class);

		examScheduleItem.setId(examScheduleItem.getId());
		examScheduleItem.setApplicationStartDate(commonApi
				.convertDDMMYYYYDateToObjectDate(ParamUtil.getString(actionRequest, "siApplicationStartDate")));
		examScheduleItem.setApplicationEndDate(
				commonApi.convertDDMMYYYYDateToObjectDate(ParamUtil.getString(actionRequest, "siApplicationEndDate")));
		examScheduleItem.setExamDate(
				commonApi.convertDDMMYYYYDateToObjectDate(ParamUtil.getString(actionRequest, "siExamDate")));
		examScheduleItem.setStartTime(ParamUtil.getString(actionRequest, "siExamStartTime"));
		examScheduleItem.setEndTime(ParamUtil.getString(actionRequest, "siExamEndTime"));
		examScheduleItem.setVenue(ParamUtil.getString(actionRequest, "siVenue"));
		examScheduleItem.setLocationOnGoogleMap(ParamUtil.getString(actionRequest, "siLocateOnGoogleMap"));
		examScheduleItem.setLocationPinOnGoogleMap(ParamUtil.getString(actionRequest, "siLocationOnGoogleMap"));
		examScheduleItem.setExamStatus(status);
		log.info("examScheduleId::" + examScheduleId);
		String examScheduleMapper = CustomObjectMapperUtil.writeValueAsString(examScheduleItem, null);
		String examScheduleResponse = httpConnector.executePut(
				themeDisplay.getPortalURL() + LRObjectURL.EXAM_SCHEDULE_URL + examScheduleItem.getId(),
				examScheduleMapper, headers);
		log.info("---------------" + examScheduleResponse);

	}

	public void deleteEntryFromList(List<ExamSchedule> examScheduleList, ExamSchedule examSchedule,
			ThemeDisplay themeDisplay, long traineeLevelId) {
		ExamDefinition definition = examUtil.getExamDefinitionByDefinitionId(examSchedule.getExamDefinitionId(),
				themeDisplay.getPortalURL());
		String byLawRuleConditionText = StringPool.BLANK;
		Exam exam = examUtil.getExamById(definition.getExamId(), themeDisplay.getPortalURL());
		try {
			if (Validator.isNotNull(exam)) {
				byLawRuleConditionText = examUtil.getByRuleConditionText(themeDisplay, exam.getExamEligibility());

				String traineeLevelNum = "R" + traineeLevelId;
				if (byLawRuleConditionText != "" && traineeLevelId != 0) {
					traineeLevelNum = traineeLevelNum.toLowerCase();

					byLawRuleConditionText = byLawRuleConditionText.toLowerCase();

					if (byLawRuleConditionText.contains("trainee")
							&& byLawRuleConditionText.contains(traineeLevelNum)) {

					} else {
						examScheduleList.remove(examSchedule);
					}
				}

			}
		} catch (Exception e) {
			log.error("Error in deleting Object from Exam Schedule List" + e);
		}

	}

	public void setExamStartAndEndTime(ExamSchedule examSchedule) {
		String newStTim = StringPool.BLANK;
		String newEndTime = StringPool.BLANK;
		String startTime = examSchedule.getStartTime();
		String endTime = examSchedule.getEndTime();
		try {
			if (Validator.isNotNull(startTime) && Validator.isNotNull(endTime) && startTime != "" && endTime != "") {
				if (startTime.contains(" ") && endTime.contains(" ")) {
					startTime = startTime.substring(0, startTime.indexOf(' '));
					endTime = endTime.substring(0, endTime.indexOf(' '));

					if (startTime.indexOf(":") == 1) {
						newStTim = 0 + startTime;
					} else {
						newStTim = startTime;
					}
					if (endTime.indexOf(":") == 1) {
						newEndTime = 0 + endTime;
					} else {
						newEndTime = endTime;
					}
					examSchedule.setStartTime(newStTim);
					examSchedule.setEndTime(newEndTime);
				}

			}
		} catch (Exception e) {
			examSchedule.setStartTime(StringPool.BLANK);
			examSchedule.setEndTime(StringPool.BLANK);
		}

	}

public ExamSchedule setSchedularWithMutiDates(ExamSchedule examSchedule, long scopeGroupId,String portalURL) {
try {
		if (Validator.isNotNull(examSchedule)) {
				ExamMultiDatesItem examMultiDatesItem = getExamMultiByDesc(scopeGroupId,portalURL,
						examSchedule.getExamScheduleAdminId());
				if (Validator.isNotNull(examMultiDatesItem) && Validator.isNotNull(examMultiDatesItem.getItems())
						&& !examMultiDatesItem.getItems().isEmpty()) {
					
					String[] mutiDateandTime = new String[examMultiDatesItem.getItems().size()];
					var i = 0;
					for (ExamMultiDates examMultiDates : examMultiDatesItem.getItems()) {
						log.info("examMultiDates::"+ examMultiDates);
						log.info("examMultiDates.getExamDate()::"+ examMultiDates.getExamDate());
						if (Validator.isNotNull(examMultiDates.getExamDate())) {
							mutiDateandTime[i++] = commonApi.convertDateFormatToDDMMYYYY(
									examMultiDates.getExamDate()) + "[ " + examMultiDates.getStartTime() + " ]";
						}
					}
					examSchedule.setExamDate(String.join(",", mutiDateandTime));
					log.info("mutiDateandTime"+ mutiDateandTime);
				}
		}
		
	}catch(Exception e) {
		log.error(e);
	}	
		return examSchedule;
	}
	
	@Reference(unbind = "_")
	private OMSBCommonApi commonApi;

	@Reference(unbind = "_")
	private ExamUtil examUtil;

	@Reference
	private ExamSetupUtil examSetupUtil;

	@Reference(unbind = "_")
	private OMSBHttpConnector httpConnector;

	@Reference(unbind = "-")
	private ExamNotificationUtil examNotificationUtil;

	private static final Log log = LogFactoryUtil.getLog(ScheduleUtil.class);
}