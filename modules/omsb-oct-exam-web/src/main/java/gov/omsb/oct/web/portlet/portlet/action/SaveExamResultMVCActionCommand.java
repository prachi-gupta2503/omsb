package gov.omsb.oct.web.portlet.portlet.action;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Arrays;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamResult;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamResultItem;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name=" + MVCCommandNames.SAVE_OCT_EXAM_RESULT, }, service = MVCActionCommand.class)
public class SaveExamResultMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		logger.info("save exam result action () started");
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long examScheduleId = ParamUtil.getLong(actionRequest, "examScheduleId");
			long examDefinitionId = ParamUtil.getLong(actionRequest, "examDefinitionId");
			long lrUserId = ParamUtil.getLong(actionRequest, "lrUserId");
			ParamUtil.getStringValues(actionRequest, "trainee");
			String[] trainee = ParamUtil.getStringValues(actionRequest, "trainee");

			logger.info("Trainee Array ... " + Arrays.toString(trainee));

			String[] result = ParamUtil.getStringValues(actionRequest, "result");
			String[] percentage = ParamUtil.getStringValues(actionRequest, "percentage");
			String[] appeared = ParamUtil.getStringValues(actionRequest, "appeared");
			boolean isSuccess = false;

			for (int i = 0; i < trainee.length; i++) {
				logger.info("result: " + result[i] + "percentage: " + percentage[i] + "appeard: " + appeared[i]);
				OCTExamResultItem examResult = new OCTExamResultItem();
				examResult.setResult(result[i]);
				examResult.setPercentage((long) (Double.parseDouble(percentage[i])));
				boolean appearedValue = "true".equals(appeared[i]);
				logger.info("appearedValue:" + appearedValue);
				examResult.setAppeared(Boolean.TRUE);
				logger.info("appeared::" + examResult.isAppeared());
				examResult.setoCExamDefinitionId(examDefinitionId);
				examResult.setoCExamScheduleId(examScheduleId);
				examResult.setLrUserId(lrUserId);
				logger.info("Trainee Id ... "+trainee[i]);
				logger.info("lr user id::" + lrUserId);
				String examResultResponse = CustomObjectMapperUtil.writeValueAsString(examResult, null);
				Map<String, String> headers = omsbCommonApi.getHttpHeaderInfoAndBasicAuth();

				OCTExamResult octExamResult = examUtil.getExamResultByUserId(lrUserId, themeDisplay, examScheduleId);
				if (Validator.isNotNull(octExamResult) && Validator.isNotNull(octExamResult.getItems())
						&& octExamResult.getItems().size() > 0) {

					OCTExamResultItem examResultItem = octExamResult.getItems().get(0);

					if (examResultItem.getId() > 0) {
						logger.info((themeDisplay.getPortalURL() + LRObjectURL.EXAM_RESULT_URL + StringPool.SLASH
								+ examResultItem.getId()));
						String executePut = omsbHttpConnector.executePut((themeDisplay.getPortalURL()
								+ LRObjectURL.OC_EXAM_RESULTS + StringPool.SLASH + examResultItem.getId()),
								examResultResponse, headers);
						logger.info(executePut);
						isSuccess = true;

					}
				} else {
					String executePost = omsbHttpConnector.executePost(
							(themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_RESULTS + CommonConstants.SCOPES
									+ StringPool.SLASH + String.valueOf(themeDisplay.getScopeGroupId())),
							examResultResponse, headers);
					logger.info(executePost);
					isSuccess = true;
				}
			}

			if (isSuccess)
				SessionMessages.add(actionRequest, OmsbOctExamWebPortletKeys.SET_EXAM_RESULT_SUCCESS);
			logger.info("save exam result action () ended");
		} catch (Exception e) {
			SessionErrors.add(actionRequest, OmsbOctExamWebPortletKeys.SET_EXAM_RESULT_ERROR);
			logger.error(e.getMessage(), e);
		}
	}

	@Reference(unbind = "-")
	private OMSBHttpConnector omsbHttpConnector;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
	@Reference
	private OCTExamUtil examUtil;
	private static final Log logger = LogFactoryUtil.getLog(SaveExamResultMVCActionCommand.class);
}
