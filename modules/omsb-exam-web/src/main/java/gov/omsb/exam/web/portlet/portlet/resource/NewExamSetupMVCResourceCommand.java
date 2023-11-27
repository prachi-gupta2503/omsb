package gov.omsb.exam.web.portlet.portlet.resource;

import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.exam.web.portlet.constants.MVCCommands;
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;
import gov.omsb.exam.web.portlet.dto.ExamType;
import gov.omsb.exam.web.portlet.dto.ExamTypeEligibilityMapping;
import gov.omsb.exam.web.portlet.util.ExamSetupUtil;
import gov.omsb.exam.web.portlet.util.ExamUtil;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.service.ProgramMasterLocalService;
import gov.omsb.tms.service.ProgramMasterLocalServiceUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OMSBExamWebPortletKeys.OMSBEXAMWEB,
		"mvc.command.name=" + MVCCommands.NEW_EXAM_SETUP_RESOURCE }, service = MVCResourceCommand.class)
public class NewExamSetupMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		logger.info("new exam serveResource () started");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			String cmd = ParamUtil.getString(resourceRequest, "cmd");
			long programId = ParamUtil.getLong(resourceRequest, "programId");
			long programTypeId = ParamUtil.getLong(resourceRequest, "programTypeId");
			long examTypeId = ParamUtil.getLong(resourceRequest, "examTypeId");
			long examEligibility = ParamUtil.getLong(resourceRequest, "examEligibility");
//			long byLawId = ParamUtil.getLong(resourceRequest, "bylawId");
			String examType = ParamUtil.getString(resourceRequest, "examType");
			logger.info("cmd::" + cmd);
			JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
			if (cmd.equalsIgnoreCase(OMSBExamWebPortletKeys.GET_ELIGIBILITY)) {
				logger.info("programId:" + programId);
				jsonArray = getTraineeLevel(examTypeId, themeDisplay);
			}
			if (cmd.equalsIgnoreCase(OMSBExamWebPortletKeys.GET_PROGRAM)) {
				jsonArray = getprogramByProgramType(programTypeId, themeDisplay);
			}
			if (cmd.equalsIgnoreCase(OMSBExamWebPortletKeys.GET_EXAMTYPE)) {
				jsonArray = getExamTypeByProgramType(programId, programTypeId, themeDisplay);
			}
			if (cmd.equalsIgnoreCase(OMSBExamWebPortletKeys.GET_EXIST_EXAM)) {
				logger.info("inside exist exam" + cmd);
				jsonArray = examSetupUtil.getExistExam(programId, examTypeId, themeDisplay);
			}
			if (cmd.equalsIgnoreCase(OMSBExamWebPortletKeys.GET_EXAM_ELIGIBILITY)) {
				jsonArray = examUtil.getByRuleCondition(themeDisplay, examEligibility);
			}
			if (cmd.equalsIgnoreCase(OMSBExamWebPortletKeys.GET_SUGGESTED_RULES)) {
				jsonArray = examUtil.isExamTypeRuleKeyMatch(themeDisplay, examType);
				logger.info("jsonArray for by law: "+jsonArray.toJSONString());
			}
			resourceResponse.getWriter().write(jsonArray.toString());
		} catch (Exception e) {
			logger.error("error while fetching resource data " + e);
		}
		logger.info("new exam serveResource () ended");
		return false;
	}

	public JSONArray getTraineeLevel(long examTypeId, ThemeDisplay themeDisplay) {
		logger.info("getTraineeLevel () started");
		JSONArray traineeLevelArray = JSONFactoryUtil.createJSONArray();
		try {
			traineeLevelArray = JSONFactoryUtil.createJSONArray();

			String examType = examUtil.getExamTypeKey(examTypeId, themeDisplay.getPortalURL());
			logger.info("examType::" + examType);
			if (Validator.isNotNull(examType)) {
				List<ExamTypeEligibilityMapping> examEligibilityByExamTypes = examSetupUtil
						.getexamEligibilityByExamType(themeDisplay, examType);
				for (ExamTypeEligibilityMapping examEligibilityByExamType : examEligibilityByExamTypes) {
					ListTypeEntry listTypeEntryByListTypeItemKey = omsbCommonApi.getListTypeEntryByListTypeItemKey(
							LRPicklistConstants.PL_EXAM_ELIGIBILITY_ERC, examEligibilityByExamType.getExamEligibility(),
							themeDisplay.getCompanyId());
					JSONObject traineeLevelJSON = JSONFactoryUtil.createJSONObject();
					traineeLevelJSON.put("examEligibility", listTypeEntryByListTypeItemKey.getName());
					traineeLevelJSON.put("examEligibilityKey", listTypeEntryByListTypeItemKey.getKey());
					traineeLevelArray.put(traineeLevelJSON);
				}
			}
		} catch (Exception e) {
			logger.error("error while fetching trainee level master::" + e);
		}
		logger.info("getTraineeLevel () ended");
		return traineeLevelArray;
	}

	public JSONArray getprogramByProgramType(long programTypeId, ThemeDisplay themeDisplay) {
		logger.info("getprogramByProgramType () started");
		JSONArray programArray = JSONFactoryUtil.createJSONArray();
		try {
			programArray = JSONFactoryUtil.createJSONArray();
			List<ProgramMaster> programs = ProgramMasterLocalServiceUtil.findProgramByPorgramType(programTypeId);
			for (ProgramMaster program : programs) {
				JSONObject programJson = JSONFactoryUtil.createJSONObject();
				programJson.put("programId", program.getProgramMasterId());
				ProgramMaster programMaster = examUtil.getProgramsByProgramId(program.getProgramMasterId(), themeDisplay);
				String programName = "";
				if (Validator.isNotNull(programMaster)) {
					programName = programMaster.getProgramName();
				}
				programJson.put("programName", programName);
				if (Validator.isNotNull(programMaster)) {
					programJson.put("programTypeId", programMaster.getProgramTypeId());
					programJson.put("programId", programMaster.getProgramMasterId());
				}

				programArray.put(programJson);
			}
		} catch (Exception e) {
			logger.error("error while fetching program master::" + e);
		}
		logger.info("getprogramByProgramType () ended");
		return programArray;
	}

	public JSONArray getExamTypeByProgramType(long programId, long programTypeId, ThemeDisplay themeDisplay) {
		logger.info("getExamTypeByProgramType () started");
		JSONArray examTypeArray = JSONFactoryUtil.createJSONArray();
		try {
			ListTypeEntry selectionExamType = omsbCommonApi.getListTypeEntryByListTypeItemKey(
					LRPicklistConstants.PL_EXAM_TYPE, LRPicklistConstants.SELECTION_EXAM_KEY,
					themeDisplay.getCompanyId());
//			logger.info("selectionExamType::" + selectionExamType.getKey());

//			ProgramMaster programMaster = programMasterLocalService.fetchProgramMaster(programId);
//			logger.info("program id for ALL::" + programMaster.getProgramMasterId() + "program code for ALL::"
//					+ programMaster.getProgramCode());
			examTypeArray = JSONFactoryUtil.createJSONArray();
			logger.info("program id:" + programId + "program type id:" + programTypeId);
			if (programId == 0 && programTypeId == 0 && Validator.isNotNull(selectionExamType)) {
				ExamType examType = examUtil.getExamTypeByExamTypeName(themeDisplay, selectionExamType.getKey());

				examTypeArray.put(setExamTypeJson(examType, themeDisplay));
			} else {

				List<ExamType> examTypeItems = examUtil.getExamByProgramtype(themeDisplay, programTypeId);
				for (ExamType examTypeItem : examTypeItems) {
					ListTypeEntry listTypeEntryByListTypeItemKey = omsbCommonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.PL_EXAM_TYPE, examTypeItem.getExamType(), themeDisplay.getCompanyId());
					if (!listTypeEntryByListTypeItemKey.getKey().equalsIgnoreCase("selectionexam")
							&& programTypeId != 0 && Validator.isNotNull(listTypeEntryByListTypeItemKey)) {
						examTypeArray.put(setExamTypeJson(examTypeItem, themeDisplay));
					}
				}
			}
			logger.info("examTypeArray::" + examTypeArray);

		} catch (Exception e) {
			logger.error("error while fetching exam type::" + e.getMessage(), e);
		}
		logger.info("getExamTypeByProgramType () ended");
		return examTypeArray;
	}

	public JSONObject setExamTypeJson(ExamType examType, ThemeDisplay themeDisplay) {
		JSONObject examTypeJson = JSONFactoryUtil.createJSONObject();
		if (Validator.isNotNull(examType) && Validator.isNotNull(examType.getExamType())) {
			ListTypeEntry listTypeEntryByListTypeItemKey = omsbCommonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.PL_EXAM_TYPE, examType.getExamType(), themeDisplay.getCompanyId());
			if(Validator.isNotNull(listTypeEntryByListTypeItemKey)) {
			examTypeJson.put("examTypeName", listTypeEntryByListTypeItemKey.getName(themeDisplay.getLocale()));
			}
			examTypeJson.put("examTypeId", examType.getId());
		}
		return examTypeJson;
	}

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
	@Reference(unbind = "-")
	private ProgramMasterLocalService programMasterLocalService;
	@Reference
	private ExamUtil examUtil;
	@Reference
	private ExamSetupUtil examSetupUtil;
	private static final Log logger = LogFactoryUtil.getLog(NewExamSetupMVCResourceCommand.class);
}
