package gov.omsb.exam.web.portlet.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.object.model.ObjectDefinition;
import com.liferay.object.service.ObjectDefinitionService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowLog;

import java.io.Serializable;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.common.util.CustomWorkflowTaskUtil;
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;
import gov.omsb.exam.web.portlet.dto.Exam;
import gov.omsb.exam.web.portlet.dto.ExamItem;
import gov.omsb.exam.web.portlet.dto.ExamProgramMapping;
import gov.omsb.exam.web.portlet.dto.ExamProgramMappingItem;
import gov.omsb.exam.web.portlet.dto.ExamTypeEligibilityMapping;
import gov.omsb.exam.web.portlet.dto.ExamTypeEligibilityMappingItem;
import gov.omsb.exam.web.portlet.dto.ExamWithdrawal;
import gov.omsb.exam.web.portlet.dto.ExamWithdrawalStatus;
import gov.omsb.exam.web.portlet.dto.ExamWithdrawalStatusItem;
import gov.omsb.exam.web.portlet.dto.Program;
import gov.omsb.exam.web.portlet.dto.ProgramItem;
import gov.omsb.exam.web.portlet.dto.RegularFeeItem;
import gov.omsb.exam.web.portlet.dto.WithdrawalFeeItem;
import gov.omsb.exam.web.portlet.dto.WithdrawalFees;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.tms.service.ProgramMasterLocalService;

@Component(immediate = true, property = {}, service = ExamSetupUtil.class)
public class ExamSetupUtil {

	private long getGroupId() {
		Group group = GroupLocalServiceUtil.fetchGroup(PortalUtil.getDefaultCompanyId(),
				CommonConstants.GUEST_GROUP_KEY);
		if (Validator.isNotNull(group)) {
			logger.info("Guest Group Id is ?? " + group.getGroupId());
			return group.getGroupId();
		}
		return 0;
	}

	public List<Exam> viewExamList(ThemeDisplay themeDisplay) {
		String url = themeDisplay.getPortalURL() + LRObjectURL.EXAM_URL + CommonConstants.SCOPES + StringPool.SLASH
				+ getGroupId() + "?sort=id:desc&pageSize=0";
		String response = omsbHttpConnector.executeGet(url, "", commonApi.getHttpHeaderInfoAndBasicAuth());
		logger.debug("response for all exams list::" + response);
		ExamItem examList = CustomObjectMapperUtil.readValue(response, ExamItem.class);
		try {
			if (Validator.isNotNull(examList) && Validator.isNotNull(examList.getItems())
					&& !examList.getItems().isEmpty()) {
				List<Exam> viewExams = new ArrayList<>();
				for (Exam exam : examList.getItems()) {
					Exam exam1 = exam;
					String examJson = exam1.getExamJson();
					logger.info("exam json::" + examJson);
					Exam exams = CustomObjectMapperUtil.readValue(examJson, Exam.class);
					exams.setId(exam.getId());
					exams.setExamType(examUtil.getExamType(exam1.getExamTypeId(), themeDisplay.getCompanyId(),themeDisplay.getPortalURL(),themeDisplay.getLocale()));
					viewExams.add(exams);
				}
				return viewExams;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;

	}

	public List<Exam> viewExamListByprogramAndExamType(ThemeDisplay themeDisplay, long program, long examTypeId) {
		try {
			String url = themeDisplay.getPortalURL() + LRObjectURL.EXAM_PROGRAM_MAPPINGS + CommonConstants.SCOPES
					+ StringPool.SLASH + getGroupId() + StringPool.QUESTION + "filter=programId"
					+ URLEncoder.encode(" eq " + program, StandardCharsets.UTF_8);
			logger.info("exam url by program and exam type" + url);
			String response = omsbHttpConnector.executeGet(url, "", commonApi.getHttpHeaderInfoAndBasicAuth());
			logger.debug("reponse::" + response);
			ExamProgramMappingItem examProgramMappingItems = CustomObjectMapperUtil.readValue(response,
					ExamProgramMappingItem.class);
			if (Validator.isNotNull(examProgramMappingItems) && Validator.isNotNull(examProgramMappingItems.getItems())
					&& !examProgramMappingItems.getItems().isEmpty()) {
				List<Exam> viewExams = new ArrayList<>();
				for (ExamProgramMapping examProgramMappingItem : examProgramMappingItems.getItems()) {
					String examUrl = themeDisplay.getPortalURL() + LRObjectURL.EXAM_URL + CommonConstants.SCOPES
							+ StringPool.SLASH + getGroupId() + StringPool.QUESTION + "filter=id"
							+ URLEncoder.encode(
									" eq '" + examProgramMappingItem.getExamId() + "' and examTypeId eq " + examTypeId,
									StandardCharsets.UTF_8);
					logger.info("exam url by program and exam type" + examUrl);
					String examResponse = omsbHttpConnector.executeGet(examUrl, "",
							commonApi.getHttpHeaderInfoAndBasicAuth());
					ExamItem examList = CustomObjectMapperUtil.readValue(examResponse, ExamItem.class);
					if (Validator.isNotNull(examList) && Validator.isNotNull(examList.getItems())
							&& !examList.getItems().isEmpty()) {
						for (Exam exam : examList.getItems()) {
							Exam exam1 = exam;
							String examJson = exam1.getExamJson();
							logger.info("exam json::" + examJson);
							Exam exams = CustomObjectMapperUtil.readValue(examJson, Exam.class);
							exams.setId(exam.getId());
							exams.setExamType(examUtil.getExamType(exam1.getExamTypeId(), themeDisplay.getCompanyId(),themeDisplay.getPortalURL(),themeDisplay.getLocale()));
							viewExams.add(exams);
						}
					}
				}
				logger.info("size of exam :" + viewExams.size());
				return viewExams;
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	public List<Exam> viewExamListByprogram(ThemeDisplay themeDisplay, long program) {
		try {
			String url = themeDisplay.getPortalURL() + LRObjectURL.EXAM_PROGRAM_MAPPINGS + CommonConstants.SCOPES
					+ StringPool.SLASH + getGroupId() + StringPool.QUESTION + "filter=programId"
					+ URLEncoder.encode(" eq " + program, StandardCharsets.UTF_8);
			logger.info("exam url by program" + url);
			String response = omsbHttpConnector.executeGet(url, "", commonApi.getHttpHeaderInfoAndBasicAuth());
			logger.debug("reponse::" + response);
			ExamProgramMappingItem examProgramMappingItems = CustomObjectMapperUtil.readValue(response,
					ExamProgramMappingItem.class);
			if (Validator.isNotNull(examProgramMappingItems) && Validator.isNotNull(examProgramMappingItems.getItems())
					&& !examProgramMappingItems.getItems().isEmpty()) {
				List<Exam> viewExams = new ArrayList<>();
				for (ExamProgramMapping examProgramMappingItem : examProgramMappingItems.getItems()) {
					String examUrl = themeDisplay.getPortalURL() + LRObjectURL.EXAM_URL
							+ examProgramMappingItem.getExamId();
					logger.info("exam url by program and exam type" + examUrl);
					String examResponse = omsbHttpConnector.executeGet(examUrl, "",
							commonApi.getHttpHeaderInfoAndBasicAuth());
					Exam exam = CustomObjectMapperUtil.readValue(examResponse, Exam.class);
					if (Validator.isNotNull(exam)) {
						Exam exam1 = exam;
						String examJson = exam1.getExamJson();
						logger.info("exam json::" + examJson);
						Exam exams = CustomObjectMapperUtil.readValue(examJson, Exam.class);
						exams.setId(exam.getId());
						exams.setExamType(examUtil.getExamType(exam1.getExamTypeId(), themeDisplay.getCompanyId(),themeDisplay.getPortalURL(),themeDisplay.getLocale()));
						logger.info("exam id:" + exams.getId());
						viewExams.add(exams);
					}
				}
				logger.info("size of exam :" + viewExams.size());
				return viewExams;
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	public List<Exam> viewExamListByExamTypeId(ThemeDisplay themeDisplay, long examTypeId) {
		String url = themeDisplay.getPortalURL() + LRObjectURL.EXAM_URL + CommonConstants.SCOPES + StringPool.SLASH
				+ getGroupId() + StringPool.QUESTION + "filter=examTypeId"
				+ URLEncoder.encode(" eq " + examTypeId, StandardCharsets.UTF_8);
		logger.info("exam url by program and exam type" + url);
		String response = omsbHttpConnector.executeGet(url, "", commonApi.getHttpHeaderInfoAndBasicAuth());
		ExamItem examList = CustomObjectMapperUtil.readValue(response, ExamItem.class);
		try {
			if (Validator.isNotNull(examList) && Validator.isNotNull(examList.getItems())
					&& !examList.getItems().isEmpty()) {
				List<Exam> viewExams = new ArrayList<>();
				for (Exam exam : examList.getItems()) {
					Exam exam1 = exam;
					String examJson = exam1.getExamJson();
					logger.info("exam json::" + examJson);
					Exam exams = CustomObjectMapperUtil.readValue(examJson, Exam.class);
					exams.setId(exam.getId());
					exams.setExamType(examUtil.getExamType(exam1.getExamTypeId(), themeDisplay.getCompanyId(),themeDisplay.getPortalURL(),themeDisplay.getLocale()));
					viewExams.add(exams);
				}
				return viewExams;
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	public String getExamTypes(String portalURL) {
		String url = portalURL + LRObjectURL.EXAM_TYPE_URL;
		String response = omsbHttpConnector.executeGet(url, "", commonApi.getHttpHeaderInfoAndBasicAuth());
		Exam exam = CustomObjectMapperUtil.readValue(response, Exam.class);
		if (!response.isEmpty() && Validator.isNotNull(exam)) {
			return exam.getExamType();
		}
		return "";
	}

	public Exam getExamById(RenderRequest renderRequest, ThemeDisplay themeDisplay, String cmd) {
		try {
			long id = ParamUtil.getLong(renderRequest, "examId");
			logger.info("exam id in render::" + id);
			Exam exam = examUtil.getExamById(id, themeDisplay.getPortalURL());
			String jsonResponse = exam.getExamJson();
			logger.info("check exam json::" + jsonResponse);
			exam = CustomObjectMapperUtil.readValue(jsonResponse, Exam.class);
			logger.info("exam type id:" + exam.getExamTypeId());
			exam.setExamType(examUtil.getExamType(exam.getExamTypeId(), themeDisplay.getCompanyId(),themeDisplay.getPortalURL(),themeDisplay.getLocale()));
			exam.setExamEligibilityName(examUtil.getruleKeyByRuleId(themeDisplay, exam.getExamEligibility()));
			exam.setRuleName(examUtil.getByRuleConditionText(themeDisplay, exam.getExamEligibility()));
			exam.setId(id);
			logger.info("program name:" + exam.getProgram());
			ObjectMapper objectMapper = new ObjectMapper();
			String programJson = objectMapper.writeValueAsString(exam.getProgram());
			String examEligbilityJson = objectMapper.writeValueAsString(exam.getExamEligibility());
//			List<Program> programList = getExamEligibility(exam, themeDisplay);\
		
			//processing no of days text according to no of days 
			List<WithdrawalFees> examWithdrawalFeesList =null;
			if(Validator.isNotNull(exam.getWithdrawalFees()) && exam.getWithdrawalFees().size()>0 ) {
			      examWithdrawalFeesList = processExamWithdrawalFees(exam.getWithdrawalFees(),themeDisplay);
			      if(Validator.isNotNull(examWithdrawalFeesList) && examWithdrawalFeesList.size() >0) {
			    	  exam.setWithdrawalFees(examWithdrawalFeesList);
			      }
			}
			
			renderRequest.setAttribute("exam", exam);
			renderRequest.setAttribute("programs", programJson);
//			renderRequest.setAttribute("examEligbilities", examEligbilityJson);
//			renderRequest.setAttribute("examEligibility2List", examEligibility2List);
			renderRequest.setAttribute("cmd", cmd);
			return exam;
		} catch (Exception e) {
			logger.error("error while fetching data for edit:" + e);
		}
		return null;
	}
	/*
	 * Get no of days text for each cancellation fees
	 * @input List<WithdrawalFees> examWithdrawalFeesList
	 * @input ThemeDisplay themeDisplay
	 */
	public List<WithdrawalFees> processExamWithdrawalFees(List<WithdrawalFees> examWithdrawalFeesList,ThemeDisplay themeDisplay) {
		List<WithdrawalFees> processedExamWithdrawalFeesList = new ArrayList<>();
		for(WithdrawalFees examWithdrawalFees : examWithdrawalFeesList) {
			if(Validator.isNotNull(examWithdrawalFees.getNoOfDays())) {
				String noOfDaysText=StringPool.BLANK;
				if(examWithdrawalFees.getNoOfDays().contains("-")) {
					noOfDaysText = LanguageUtil.get(themeDisplay.getLocale(), "range-between");
					String noOfDaysList[] =examWithdrawalFees.getNoOfDays().split("-");
					noOfDaysText = noOfDaysText + StringPool.SPACE + noOfDaysList[0] + StringPool.SPACE + StringPool.AMPERSAND 
										+ StringPool.SPACE + noOfDaysList[1];
					examWithdrawalFees.setNoOfDaysText(noOfDaysText);
				}else {
					String noOfDaysList[] =examWithdrawalFees.getNoOfDays().split(" ");
					if(examWithdrawalFees.getNoOfDays().contains(">")){
						noOfDaysText = LanguageUtil.get(themeDisplay.getLocale(), "range-greater-than");		
					}
					else if(examWithdrawalFees.getNoOfDays().contains("<")){
						noOfDaysText = LanguageUtil.get(themeDisplay.getLocale(), "range-less-than");
					}
					noOfDaysText = noOfDaysText + StringPool.SPACE +noOfDaysList[1];
					examWithdrawalFees.setNoOfDaysText(noOfDaysText);
				}
			}
			processedExamWithdrawalFeesList.add(examWithdrawalFees);
		}
		return processedExamWithdrawalFeesList;
		
	}

//	public List<ExamEligibility2> getExamEligibility(Exam exam, ThemeDisplay themeDisplay) {
//		try {
//			List<ExamEligibility2> examEligibility2List = exam.getExamEligibility2();
//			List<ExamEligibility2> eligibility2List = new ArrayList<>();
//			logger.info("size of exam elg::" + examEligibility2List.size());
//			if (Validator.isNotNull(examEligibility2List) && !examEligibility2List.isEmpty()) {
//				for (ExamEligibility2 examEligibility2 : examEligibility2List) {
//					examEligibility2.setExamTypeName(
//							examUtil.getExamType(examEligibility2.getExamType(), themeDisplay.getPortalURL()));
//					TraineeLevelMaster traineeLevelMaster = TraineeLevelMasterLocalServiceUtil
//							.getTraineeLevelMaster(examEligibility2.getExamEligibility());
//					logger.info("trainee level name::" + traineeLevelMaster.getTraineeLevelName());
//					examEligibility2.setExamEligibilityName(traineeLevelMaster.getTraineeLevelName());
//					eligibility2List.add(examEligibility2);
//				}
//				return eligibility2List;
//			}
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//		}
//		return new ArrayList<>();
//	}

	public List<Exam> getListOfExam(List<Exam> viewExams, ThemeDisplay themeDisplay) {
		List<Exam> examDetails = new ArrayList<>();
		if (Validator.isNotNull(viewExams) && !viewExams.isEmpty()) {
			for (Exam viewExam : viewExams) {
				String jsonResponse = viewExam.getExamJson();
				Exam exam = CustomObjectMapperUtil.readValue(jsonResponse, Exam.class);
				logger.info("exam json ::" + jsonResponse);
				logger.info("exam type id:" + exam.getExamTypeId());
				exam.setId(viewExam.getId());
				exam.setExamType(examUtil.getExamType(exam.getExamTypeId(), themeDisplay.getCompanyId(),themeDisplay.getPortalURL(),themeDisplay.getLocale()));
				examDetails.add(exam);
			}
		}
		return examDetails;
	}

	public Exam getProgramName(Exam exam) {
		try {
//			if (exam.getProgram() != 0) {
//				ProgramMaster programMaster = programMasterLocalService.getProgramMaster(exam.getProgram());
//				if (Validator.isNotNull(programMaster)) {
//					logger.info("program::" + programMaster.getProgramName());
//					exam.setProgramName(programMaster.getProgramName());
//				}
//				return exam;
//			}
		} catch (Exception e) {
			logger.error("error while fetching program from exam ::" + e);
		}
		return null;
	}

	public ExamWithdrawal getExamWithdrawalById(ThemeDisplay themeDisplay, long examWithdrawalId) {
		ExamWithdrawal withdrawal = null;
		String getUrl = themeDisplay.getPortalURL() + LRObjectURL.EXAM_WITHDRAWAL_URL + examWithdrawalId;
		String response = commonApi.getData(getUrl);
		if (response.contains("lrUserId")) {
			withdrawal = CustomObjectMapperUtil.readValue(response, ExamWithdrawal.class);

		}
		return withdrawal;
	}

	public List<ExamWithdrawalStatus> getExamWithdrawalStatusByWithdrawalId(ThemeDisplay themeDisplay,
			long withdrawalId) {
		String url = themeDisplay.getPortalURL() + LRObjectURL.EXAM_WITHDRAWAL_STATUS_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=examWithdrawalId"
				+ URLEncoder.encode(" eq " + withdrawalId, StandardCharsets.UTF_8);
		String response = commonApi.getData(url);
		ExamWithdrawalStatusItem statusItems = CustomObjectMapperUtil.readValue(response,
				ExamWithdrawalStatusItem.class);
		if (Validator.isNotNull(statusItems) && Validator.isNotNull(statusItems.getItems())
				&& !statusItems.getItems().isEmpty()) {
			return statusItems.getItems();
		}
		return new ArrayList<>();
	}

	public ExamWithdrawal getWorkflowData(ThemeDisplay themeDisplay, ExamWithdrawal withdrawal) {
		String className = getObjectClassName(themeDisplay.getCompanyId());
		boolean assignedToRole = false;
		long workflowTaskId = 0;
		long workflowInstanceId = 0;
		try {
			WorkflowInstance instance = CustomWorkflowTaskUtil.getWorkflowInstace(className, themeDisplay,
					withdrawal.getId());
			if (Validator.isNotNull(instance)) {
				workflowInstanceId = instance.getWorkflowInstanceId();
				List<WorkflowLog> logs = CustomWorkflowTaskUtil.getWorkflowLogs(themeDisplay.getCompanyId(), instance);
				if (!logs.isEmpty()) {
					long assigneeRoleId = CustomWorkflowTaskUtil.getWorkflowAssigneeRoleIdByLogs(logs);
					assignedToRole = CustomWorkflowTaskUtil.isWorkFlowTaskAssignedToRole(themeDisplay, assigneeRoleId);
					workflowTaskId = CustomWorkflowTaskUtil.getWorkflowTaskIdByLogs(logs);
				}
			}
			List<String> transitionNames = CustomWorkflowTaskUtil.getTransitionNames(themeDisplay, workflowTaskId);
			withdrawal.setAssignedToMe(assignedToRole);
			withdrawal.setWorkflowInstanceId(workflowInstanceId);
			withdrawal.setWorkflowTaskId(workflowTaskId);
			withdrawal.setTransitionNames(transitionNames);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return withdrawal;
	}

	private String getObjectClassName(long companyId) {
		ObjectDefinition definition = null;
		try {
			definition = objectDefinitionService.getObjectDefinitionByExternalReferenceCode(
					OMSBExamWebPortletKeys.EXAM_WITHDRAWAL_OBJ_ERC, companyId);
			if (Validator.isNotNull(definition)) {
				return definition.getClassName();
			}
		} catch (PortalException e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	public Exam setExamObjectWithItems(String programListResponse, String regularFeeResponse,
			String withdrawalFeeResponse, Exam exam) {
		try {
//			exam = setEligibilityItemsInExam(examEligibilityResponse, exam);
			exam = setRegularFeeItemInExam(regularFeeResponse, exam);
			exam = setWithdrawalFeeItem(withdrawalFeeResponse, exam);
			exam = setProgramItemInExam(programListResponse, exam);
		} catch (Exception e) {
			if (logger.isDebugEnabled()) {
				logger.debug("Exception in setting Exam Object in setExamObjectWithItems :: ExamSetupUtill :: ");
			}
		}
		return exam;
	}

//	public Exam setEligibilityItemsInExam(String examEligibilityResponse, Exam exam) {
//		try {
//			logger.info("exam elg response::" + examEligibilityResponse);
//			ExamEligibilityItem examEligibilityItem = CustomObjectMapperUtil.readValue(examEligibilityResponse,
//					ExamEligibilityItem.class);
//			if (Validator.isNotNull(examEligibilityItem) && Validator.isNotNull(examEligibilityItem.getItems())
//					&& !examEligibilityItem.getItems().isEmpty()) {
//				logger.info("Size of examEligibility2Item Object setRegularFeeItemInExam :: ExamSetupUtill :: "
//						+ examEligibilityItem.getItems().size());
//				exam.setExamEligibility(examEligibilityItem.getItems());
//			}
//		} catch (Exception e) {
//			if (logger.isDebugEnabled()) {
//				logger.debug(
//						"Exception in setting Eligibility Item in setEligibilityItemsInExam :: ExamSetupUtill :: " + e);
//			}
//		}
//		return exam;
//	}

	public Exam setRegularFeeItemInExam(String regularFeeResponse, Exam exam) {
		try {
			RegularFeeItem regularFeeItem = CustomObjectMapperUtil.readValue(regularFeeResponse, RegularFeeItem.class);
			if (Validator.isNotNull(regularFeeItem) && Validator.isNotNull(regularFeeItem.getItems())
					&& !regularFeeItem.getItems().isEmpty()) {
				logger.debug("Size of regularFeeItem :: setRegularFeeItemInExam :: ExamSetupUtill :: "
						+ regularFeeItem.getItems().size());
				exam.setRegularFees(regularFeeItem.getItems());
			}
		} catch (Exception e) {
			if (logger.isDebugEnabled()) {
				logger.debug(
						"Exception in setting Regular Fee Item in setRegularFeeItemInExam :: ExamSetupUtill :: " + e);
			}
		}
		return exam;
	}

	public Exam setProgramItemInExam(String programListResponse, Exam exam) {
		try {
			ProgramItem programItem = CustomObjectMapperUtil.readValue(programListResponse, ProgramItem.class);
			if (Validator.isNotNull(programItem) && Validator.isNotNull(programItem.getItems())
					&& !programItem.getItems().isEmpty()) {
				logger.debug("Size of regularFeeItem :: setRegularFeeItemInExam :: ExamSetupUtill :: "
						+ programItem.getItems().size());
				logger.info("programItem size::" + programItem.getItems().size());
				exam.setProgram(programItem.getItems());
			}
		} catch (Exception e) {
			if (logger.isDebugEnabled()) {
				logger.debug("Exception in setting Reg	ular Fee Item in setRegularFeeItemInExam :: ExamSetupUtill :: "
						+ e);
			}
		}
		return exam;
	}

	public Exam setWithdrawalFeeItem(String withdrawalFeeResponse, Exam exam) {
		try {
			WithdrawalFeeItem withdrawalFeeItem = CustomObjectMapperUtil.readValue(withdrawalFeeResponse,
					WithdrawalFeeItem.class);
			if (Validator.isNotNull(withdrawalFeeItem) && Validator.isNotNull(withdrawalFeeItem.getItems())
					&& !withdrawalFeeItem.getItems().isEmpty()) {
				logger.debug("Size of withdrawalFeeItem Object " + withdrawalFeeItem.getItems().size());
				exam.setWithdrawalFees(withdrawalFeeItem.getItems());
			}
		} catch (Exception e) {
			if (logger.isDebugEnabled()) {
				logger.debug(
						"Exception in setting Withdrawl Fee Item in setWithdrawalFeeItem :: ExamSetupUtill :: " + e);
			}
		}
		return exam;
	}

	public String convertObjectToString(Exam exam) {
		String response = StringPool.BLANK;
		try {
			response = CustomObjectMapperUtil.writeValueAsString(exam, null);
		} catch (Exception e) {
			if (logger.isDebugEnabled()) {
				response = StringPool.BLANK;
				logger.debug("Exception in Exam object to String in convertObjectToString :: ExamSetupUtill :: " + e);
			}
		}
		return response;
	};

	public Exam setExam(ActionRequest actionRequest) {
		Exam exam = new Exam();
		try {
			exam.setEarlyBirdFeesDate(ParamUtil.getString(actionRequest, OMSBExamWebPortletKeys.APPLICABLE_DAYS));
			exam.setEarlyBirdFees(ParamUtil.getFloat(actionRequest, OMSBExamWebPortletKeys.FEE_AMOUNT));
			exam.setAppealFees(ParamUtil.getFloat(actionRequest, OMSBExamWebPortletKeys.APPEAL_FEE));
			exam.setReAppealFees(ParamUtil.getFloat(actionRequest, OMSBExamWebPortletKeys.RE_APPEAL_FEES));
			exam.setAppealWindow(ParamUtil.getInteger(actionRequest, OMSBExamWebPortletKeys.APPEAL_WINDOW));
			exam.setReAppealWindow(ParamUtil.getInteger(actionRequest, OMSBExamWebPortletKeys.RE_APPEAL_WINDOW));
			exam.setExamTypeId(ParamUtil.getLong(actionRequest, OMSBExamWebPortletKeys.EXAM_TYPE_CAMELCASE));
//			exam.setProgram(ParamUtil.getLong(actionRequest, OMSBExamWebPortletKeys.PROGRAM_CAMELCASE));
			exam.setProgramTypeId(ParamUtil.getLong(actionRequest, OMSBExamWebPortletKeys.PROGRAM_TYPE_CAMELCASE));
//			exam.setExamEligibility(ParamUtil.getLong(actionRequest, OMSBExamWebPortletKeys.EXAM_ELIGIBILITY));
			exam.setResultSource(ParamUtil.getString(actionRequest, OMSBExamWebPortletKeys.RESULT_SOURCE));
			exam.setExamEligibility(ParamUtil.getLong(actionRequest, OMSBExamWebPortletKeys.EXAM_ELIGIBILITY));
			exam.setAllowedNoOfAttempt(
					ParamUtil.getString(actionRequest, OMSBExamWebPortletKeys.ALLOWED_NO_OF_ATTEMPT));
			return exam;
		} catch (Exception e) {
			if (logger.isDebugEnabled()) {
				logger.debug("Exception in setting Exam setExam Method  :: SaveExamMVCActionCommand :: " + e);
			}
		}
		return exam;
	}

	public boolean checkExamJson(long examId, String portalUrl, Exam editExam) {
		Exam saveExam = examUtil.getExamById(examId, portalUrl);
		String saveJson = saveExam.getExamJson();
		String editJson = editExam.getExamJson();
		logger.info("Save json string :: " + saveJson + " && Edit json Value string:" + editJson);
		if (!saveJson.equalsIgnoreCase(editJson)) {
			return true;
		}
		return false;
	}

	public JSONObject getExamObject(String examResponse, String programListResponse, String withdrawalFeeResponse,
			String regularFeeResponse) {
		JSONObject examObject = JSONFactoryUtil.createJSONObject();
		try {
			examObject = JSONFactoryUtil.createJSONObject(examResponse);
			logger.debug("ExamObject from Exam Response is :: getExamObject Method::  SaveExamMVCActionCommand "
					+ examObject);
			examObject.remove(OMSBExamWebPortletKeys.ID);
			examObject.remove(OMSBExamWebPortletKeys.EXAM_JSON);
			examObject.remove(OMSBExamWebPortletKeys.EXAM_TYPE_CAMELCASE);
			examObject.remove(OMSBExamWebPortletKeys.PROGRAM_TYPE_NAME);
			examObject.remove(OMSBExamWebPortletKeys.PROGRAM_NAME);
			examObject.remove(OMSBExamWebPortletKeys.EXAM_ELIGIBILITY_NAME);
//			if (Validator.isNotNull(examEligibilityResponse) && !examEligibilityResponse.isEmpty()) {
//				JSONArray eligibilityArray = examObject.getJSONArray(OMSBExamWebPortletKeys.EXAM_ELIGIBILITY);
//				for (int index = 0; index < eligibilityArray.length(); index++) {
//					JSONObject eligibilityJsonObject = eligibilityArray.getJSONObject(index);
//					eligibilityJsonObject.remove(OMSBExamWebPortletKeys.EXAM_DEFINITION_ID);
//					eligibilityJsonObject.remove(OMSBExamWebPortletKeys.ID);
//					logger.debug(
//							"eligibilityJsonObject JSON Object in :: getExamObject Method::  SaveExamMVCActionCommand "
//									+ eligibilityJsonObject);
//				}
//			}
			if (Validator.isNotNull(withdrawalFeeResponse) && !withdrawalFeeResponse.isEmpty()) {
				JSONArray withdrawalArray = examObject.getJSONArray(OMSBExamWebPortletKeys.WITHDRAWL_FEES);
				for (int index = 0; index < withdrawalArray.length(); index++) {
					JSONObject jsonObject = withdrawalArray.getJSONObject(index);
					jsonObject.remove(OMSBExamWebPortletKeys.EXAM_DEFINITION_ID);
					jsonObject.remove(OMSBExamWebPortletKeys.ID);
					jsonObject.remove(OMSBExamWebPortletKeys.NO_OF_DAYS_TEXT);
//					String noOfDays = (String) jsonObject.get("noOfDays");
//					noOfDays = noOfDays.trim();
//					logger.debug("no of days :"+ noOfDays);
//					 int startIndex = noOfDays.indexOf("(");
//				     int endIndex = noOfDays.lastIndexOf(")");
//				     if (startIndex != -1 && endIndex != -1 && endIndex > startIndex) {
//				            String textInsideParentheses = noOfDays.substring(startIndex + 1, endIndex);
//				            String[] parts = noOfDays.split(" ");
//				            String firstValue = "" ;
//				            String lastValue = "";
//				            if (parts.length >= 2) {
//				                firstValue = parts[0];
//				                lastValue = parts[parts.length - 1];
//				            }
//				            noOfDays = firstValue + " " + textInsideParentheses + " " + lastValue;
//				            logger.debug("no of days: "+noOfDays);
//				            jsonObject.put("noOfDays", noOfDays);
//				     } else {
//				        	logger.debug("No valid parentheses found.");
//				     }
					logger.debug(
							"JSON Object from withdrawalFeeResponse in :: getExamObject Method::  SaveExamMVCActionCommand \"::"
									+ jsonObject);
				}
			}
			if (Validator.isNotNull(regularFeeResponse) && !regularFeeResponse.isEmpty()) {
				JSONArray regularFeeArray = examObject.getJSONArray(OMSBExamWebPortletKeys.REGULAR_FEES);
				for (int index = 0; index < regularFeeArray.length(); index++) {
					JSONObject jsonObject = regularFeeArray.getJSONObject(index);
					jsonObject.remove(OMSBExamWebPortletKeys.EXAM_DEFINITION_ID);
					jsonObject.remove(OMSBExamWebPortletKeys.ID);
					logger.debug(
							"JSON Object from regularFeeResponse in :: getExamObject Method::  SaveExamMVCActionCommand \"::"
									+ jsonObject);
				}
			}
			logger.debug("Final Exam Object  in :: getExamObject Method::  SaveExamMVCActionCommand " + examObject);
		} catch (Exception e) {
			logger.debug(
					"Exception in getting Json object from differnet input resource :: getExamObject Method::  SaveExamMVCActionCommand::  ");
		}
		return examObject;
	}

	public long getExamByProgramAndExamType(long programId, long examTypeId, ThemeDisplay themeDisplay) {
		try {
			String url = themeDisplay.getPortalURL() + LRObjectURL.EXAM_URL + CommonConstants.SCOPES + StringPool.SLASH
					+ getGroupId() + StringPool.QUESTION + "filter=program" + URLEncoder
							.encode(" eq " + programId + " and examTypeId eq " + examTypeId, StandardCharsets.UTF_8);
			logger.info("exam url by program and exam type" + url);
			String response = omsbHttpConnector.executeGet(url, "", commonApi.getHttpHeaderInfoAndBasicAuth());
			logger.info("reponse::" + response);
			ExamItem examList = CustomObjectMapperUtil.readValue(response, ExamItem.class);
			if (Validator.isNotNull(examList) && Validator.isNotNull(examList.getItems())
					&& !examList.getItems().isEmpty()) {
				return examList.getItems().get(0).getId();
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return 0;
	}

	public JSONArray getExistExam(long programId, long examTypeId, ThemeDisplay themeDisplay) {
		logger.info("getExistExam() started");
		JSONArray existExamJsonArray = JSONFactoryUtil.createJSONArray();
		try {
			JSONObject existExamJson = JSONFactoryUtil.createJSONObject();
			long existExam = getExamByProgramAndExamType(programId, examTypeId, themeDisplay);
			logger.info("inside update");
			existExamJson.put("existExam", existExam);
			existExamJson.put("examTypeName", examUtil.getExamTypeNameByExamTypeId(themeDisplay, examTypeId));
			existExamJson.put("programName", examUtil.getProgramByProgramId(programId, themeDisplay));
			return existExamJsonArray.put(existExamJson);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.info("getExistExam() ended");
		return existExamJsonArray;
	}

	public List<ExamTypeEligibilityMapping> getexamEligibilityByExamType(ThemeDisplay themeDisplay,
			String examTypeKey) {
		String url = themeDisplay.getPortalURL() + LRObjectURL.EXAM_TYPE_ELIGIBILITY_MAPPINGS + CommonConstants.SCOPES
				+ StringPool.SLASH + getGroupId() + StringPool.QUESTION + "filter=examType"
				+ URLEncoder.encode(" eq '" + examTypeKey + "'", StandardCharsets.UTF_8);
		logger.info("exam eligibility mapping url " + url);
		String response = omsbHttpConnector.executeGet(url, "", commonApi.getHttpHeaderInfoAndBasicAuth());
		logger.info("reponse::" + response);
		ExamTypeEligibilityMappingItem eligibilityMappingItem = CustomObjectMapperUtil.readValue(response,
				ExamTypeEligibilityMappingItem.class);
		if (Validator.isNotNull(eligibilityMappingItem) && Validator.isNotNull(eligibilityMappingItem.getItems())
				&& !eligibilityMappingItem.getItems().isEmpty()) {
			return eligibilityMappingItem.getItems();
		}
		return null;
	}

	public void saveExamProgramMapping(String programListResponse, String examResponse, ActionRequest actionRequest,
			ThemeDisplay themeDisplay) {
		try {
			logger.info("saveExamProgramMapping () started");
			ProgramItem programItems = CustomObjectMapperUtil.readValue(programListResponse, ProgramItem.class);
			if (Validator.isNotNull(programItems) && Validator.isNotNull(programItems.getItems())
					&& !programItems.getItems().isEmpty()) {
				for (Program programItem : programItems.getItems()) {

					Map<String, Serializable> values = new HashMap<>();
					values.put(OMSBExamWebPortletKeys.PROGRAM_ID, programItem.getProgramId());
					Exam exam = CustomObjectMapperUtil.readValue(examResponse, Exam.class);
					if (Validator.isNotNull(exam)) {
						values.put(OMSBExamWebPortletKeys.EXAM_ID, exam.getId());
						commonApi.addObjectEntryByERC(OMSBExamWebPortletKeys.OB_EXAM_PROGRAM_MAPPING_ERC, values,
								actionRequest, themeDisplay);
					}
				}
			}
			logger.info("saveExamProgramMapping () ended");
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	
	@Reference
	private ObjectDefinitionService objectDefinitionService;

	@Reference(unbind = "-")
	private ProgramMasterLocalService programMasterLocalService;

	@Reference
	private OMSBCommonApi commonApi;

	@Reference
	private ExamUtil examUtil;

	@Reference
	private OMSBHttpConnector omsbHttpConnector;

	private static final Log logger = LogFactoryUtil.getLog(ExamSetupUtil.class);
}
