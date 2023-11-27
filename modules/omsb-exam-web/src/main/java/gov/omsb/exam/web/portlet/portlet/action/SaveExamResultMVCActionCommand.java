package gov.omsb.exam.web.portlet.portlet.action;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
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
import gov.omsb.exam.web.portlet.constants.MVCCommands;
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;
import gov.omsb.exam.web.portlet.dto.ExamResultItem;
import gov.omsb.exam.web.portlet.portlet.render.ExaminationMVCRenderCommand;
import gov.omsb.exam.web.portlet.util.ExamUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;

@Component(immediate = true, property = { "javax.portlet.name=" + OMSBExamWebPortletKeys.OMSBEXAMWEB,
		"mvc.command.name=" + MVCCommands.SAVE_EXAM_RESULT, }, service = MVCActionCommand.class)
public class SaveExamResultMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		logger.debug("save exam result action () started");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long examScheduleId = ParamUtil.getLong(actionRequest, "examScheduleId");
		long examDefinitionId = ParamUtil.getLong(actionRequest, "examDefinitionId");
		String[] lrUserId = actionRequest.getParameterValues("lrUserId");
		String[] trainee = actionRequest.getParameterValues("trainee");
		logger.info("trainee size :"+trainee.length);
		String[] result = actionRequest.getParameterValues("result");
		String[] percentage = actionRequest.getParameterValues("percentage");
		String[] appeard = actionRequest.getParameterValues("appeard");
		for (int i = 0; i < trainee.length; i++) {
			logger.debug("result: " + result[i] + "percentage: " + percentage[i] + "appeard: " + appeard[i] + "examScheduleId: "+examScheduleId +"examDefinitionId: "+examDefinitionId);
			ExamResultItem examResult = new ExamResultItem();
			examResult.setResult(result[i]);
			examResult.setPercentage(Float.parseFloat(percentage[i]));
			boolean appearedValue = "true".equals(appeard[i]);
			logger.debug("appearedValue:" + appearedValue);
			examResult.setAppeared(Boolean.TRUE);
			logger.debug("appeared::" + examResult.isAppeared());
			examResult.setExamDefinitionId(examDefinitionId);
			examResult.setExamScheduleId(examScheduleId);
			examResult.setLrUserId(Long.valueOf(lrUserId[i]));
			logger.debug("lr user id::" + lrUserId[i]);
			String examResultResponse = CustomObjectMapperUtil.writeValueAsString(examResult, null);
			Map<String, String> headers = omsbCommonApi.getHttpHeaderInfoAndBasicAuth();
			ExamResultItem examResultItem = examUtil.getExamResultByUserId(Long.valueOf(lrUserId[i]), themeDisplay, examScheduleId,
					examDefinitionId);
			if(Validator.isNotNull(examResultItem)) {
			logger.debug("exam result id:" + examResultItem.getId());
			if (examResultItem.getId() > 0) {
				omsbHttpConnector.executePut((themeDisplay.getPortalURL() + LRObjectURL.EXAM_RESULT_URL + StringPool.SLASH + examResultItem.getId()), examResultResponse, headers);
			}
			}else {
				omsbHttpConnector.executePost((themeDisplay.getPortalURL() + LRObjectURL.EXAM_RESULT_URL + CommonConstants.SCOPES
						+ StringPool.SLASH + String.valueOf(themeDisplay.getScopeGroupId())),examResultResponse, headers);
			}
		}
		logger.debug("save exam result action () ended");
	}

	@Reference(unbind = "-")
	private OMSBHttpConnector omsbHttpConnector;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
	@Reference
	private ExamUtil examUtil;
	
	private static final Log logger = LogFactoryUtil.getLog(ExaminationMVCRenderCommand.class);
}
