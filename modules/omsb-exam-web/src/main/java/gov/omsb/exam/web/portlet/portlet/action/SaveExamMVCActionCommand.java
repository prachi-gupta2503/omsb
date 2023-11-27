package gov.omsb.exam.web.portlet.portlet.action;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;
import gov.omsb.exam.web.portlet.dto.Exam;
import gov.omsb.exam.web.portlet.dto.ExamItem;
import gov.omsb.exam.web.portlet.util.ExamSetupUtil;
import gov.omsb.exam.web.portlet.util.ExamUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;

@Component(immediate = true, property = { "javax.portlet.name=" + OMSBExamWebPortletKeys.OMSBEXAMWEB,
		"mvc.command.name=exam/save_exam_setup", }, service = MVCActionCommand.class)
public class SaveExamMVCActionCommand extends BaseMVCActionCommand {

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference
	private ExamUtil examUtil;

	@Reference
	private ExamSetupUtil examSetupUtil;

	@Reference(unbind = "-")
	private OMSBHttpConnector omsbHttpConnector;

	private static final Log logger = LogFactoryUtil.getLog(SaveExamMVCActionCommand.class);

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		logger.info("Save Exam Form details Action Call :: doProcessAction :: SaveExamMVCActionCommand ");

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			String regularFeeResponse = ParamUtil.getString(actionRequest, OMSBExamWebPortletKeys.REGULAR_EXAM_JSON_DATA);
			String withdrawalFeeResponse = ParamUtil.getString(actionRequest, OMSBExamWebPortletKeys.WITHDRAWL_FEE_JSON_DATA);
			String programListResponse = ParamUtil.getString(actionRequest, OMSBExamWebPortletKeys.PROGRAM_JSON_DATA);
//			String examEligibilityResponse = ParamUtil.getString(actionRequest, OMSBExamWebPortletKeys.EXAM_ELIGIBLITY_JSON_DATA);
			Exam exam = examSetupUtil.setExam(actionRequest);
			exam = examSetupUtil.setExamObjectWithItems(programListResponse, regularFeeResponse, withdrawalFeeResponse, exam);
			exam.setChanged(true);

			if (logger.isDebugEnabled())
				logger.debug("Exam Object in :: doProcessAction :: SaveExamMVCActionCommand ::" + exam.toString());

			String examResponse = examSetupUtil.convertObjectToString(exam);

			if (logger.isDebugEnabled())
				logger.debug("Exam Response object :: doProcessAction :: SaveExamMVCActionCommand :: " + examResponse);

			examSetupUtil.getExamObject(examResponse, programListResponse, withdrawalFeeResponse,
					regularFeeResponse);

			long examId = ParamUtil.getLong(actionRequest, OMSBExamWebPortletKeys.EXAM_ID);
			long existExam = ParamUtil.getLong(actionRequest, OMSBExamWebPortletKeys.EXIST_EXAM);
			
			if (logger.isDebugEnabled())
				logger.debug(
						"Exam Id from action request in :: doProcessAction :: SaveExamMVCActionCommand :: " + examId);
			Map<String, String> headers = omsbCommonApi.getHttpHeaderInfoAndBasicAuth();

			long existExamId = (examId > 0) ? examId : existExam;
			
			if (existExamId > 0) {
				boolean checkExamJson = examSetupUtil.checkExamJson(existExamId, themeDisplay.getPortalURL(), exam);
				
				if (checkExamJson) {
					exam.setChanged(true);
					examResponse = examSetupUtil.convertObjectToString(exam);
					JSONObject examObject = examSetupUtil.getExamObject(examResponse, programListResponse,
							withdrawalFeeResponse, regularFeeResponse);
					exam.setExamJson(examObject.toJSONString());
					String resultExamResponse = examSetupUtil.convertObjectToString(exam);
					omsbHttpConnector.executePut(
							(themeDisplay.getPortalURL() + LRObjectURL.EXAM_URL + StringPool.SLASH + existExamId),
							resultExamResponse, headers);
				}
			} else {
				JSONObject examObject = examSetupUtil.getExamObject(examResponse, programListResponse,
						withdrawalFeeResponse, regularFeeResponse);
				exam.setExamJson(examObject.toJSONString());
				String resultExamResponse = examSetupUtil.convertObjectToString(exam);
			
				if (logger.isDebugEnabled())
					logger.debug(
							"Exam response from action request in :: doProcessAction :: SaveExamMVCActionCommand :: "
									+ resultExamResponse);
				String output = omsbHttpConnector.executePost(
						(themeDisplay.getPortalURL() + LRObjectURL.EXAM_URL + CommonConstants.SCOPES + StringPool.SLASH
								+ themeDisplay.getScopeGroupId()), resultExamResponse, headers);
				examSetupUtil.saveExamProgramMapping(programListResponse, output, actionRequest, themeDisplay);
				logger.info("output Object is ::" + output + " && exam json is ::" + exam.getExamJson());

			}
			SessionMessages.add(actionRequest, OMSBExamWebPortletKeys.EXAM_SETUP_SUCCESS_MESSAGE);
			actionResponse.sendRedirect(OMSBExamWebPortletKeys.REDIRECT_URL);
		} catch (Exception e) {
			logger.error("Error in Saving Exam---"+e);
			SessionErrors.add(actionRequest, OMSBExamWebPortletKeys.EXAM_SETUP_FAILURE_MESSAGE);
		}
		/* If Form Submitted Successfuly */

	}

}
