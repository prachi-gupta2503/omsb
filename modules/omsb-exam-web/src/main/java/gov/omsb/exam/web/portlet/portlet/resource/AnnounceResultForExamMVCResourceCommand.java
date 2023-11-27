package gov.omsb.exam.web.portlet.portlet.resource;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.exam.web.portlet.constants.MVCCommands;
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;
import gov.omsb.exam.web.portlet.dto.ExamResult;
import gov.omsb.exam.web.portlet.dto.ExamResultItem;
import gov.omsb.exam.web.portlet.util.ExamUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;

@Component(immediate = true, property = { "javax.portlet.name=" + OMSBExamWebPortletKeys.OMSBEXAMWEB,
		"mvc.command.name=" + MVCCommands.ANNOUNCE_EXAM_RESULT }, service = MVCResourceCommand.class

)
public class AnnounceResultForExamMVCResourceCommand extends BaseMVCResourceCommand {
	private static final Log logger = LogFactoryUtil.getLog(AnnounceResultForExamMVCResourceCommand.class);

	@Reference(unbind = "-")
	private ExamUtil examUtil;
	@Reference(unbind = "-")
	private OMSBCommonApi commonApi;

	@Reference(unbind = "-")
	private OMSBHttpConnector httpConnector;

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long examScheduleId = ParamUtil.getLong(resourceRequest, OMSBExamWebPortletKeys.EXAM_SCHEDULE_ID);
		long examDefinitionId = ParamUtil.getLong(resourceRequest, OMSBExamWebPortletKeys.EXAM_DEFINITION_ID);
		long lrUserId = ParamUtil.getLong(resourceRequest, OMSBExamWebPortletKeys.LRUSER_ID);//52601;
		JSONObject responseObj = JSONFactoryUtil.createJSONObject();
		String response = StringPool.BLANK;
		try {
			if (logger.isDebugEnabled()) {
				logger.debug(OMSBExamWebPortletKeys.EXAM_SCHEDULE_ID + " = " + examScheduleId + ""
						+ OMSBExamWebPortletKeys.EXAM_DEFINITION_ID + " = " + examDefinitionId
						+ OMSBExamWebPortletKeys.LRUSER_ID + " = " + lrUserId);
			}

			ExamResultItem examResults = getExamResultByScheduleIdAndDefnId(themeDisplay,
					examDefinitionId, examScheduleId);

			if (logger.isDebugEnabled()) {
				logger.debug(OMSBExamWebPortletKeys.EXAM_RESULTS + " = " + examResults);
			}

			if (Validator.isNotNull(examResults)) {

				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy ");
				Date date = new Date();
				String announceDate = formatter.format(date);
				examResults.setExamAnnouncedDate(commonApi.convertDDMMYYYYDateToObjectDate(announceDate));

				response = examUtil.updateExamResultObject(themeDisplay, examResults);

				if (!response.isEmpty()) {
					responseObj.put(OMSBExamWebPortletKeys.SUCCESS, true);
				} else {
					responseObj.put(OMSBExamWebPortletKeys.SUCCESS, false);
				}

			}
		} catch (Exception e) {
			responseObj.put(OMSBExamWebPortletKeys.SUCCESS, false);
		}
		resourceResponse.getWriter().write(responseObj.toString());

	}
	public ExamResultItem getExamResultByScheduleIdAndDefnId(ThemeDisplay themeDisplay,
			long examDefinitionId, long examScheduleId) {
		String url = themeDisplay.getPortalURL() + LRObjectURL.EXAM_RESULT_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=examDefinitionId"
				+ URLEncoder.encode(" eq " + examDefinitionId + " and examScheduleId eq " + examScheduleId, StandardCharsets.UTF_8);
		logger.info("url for result:" + url);
		String resultResponse = commonApi.getData(url);
		logger.info("response for result::" + resultResponse);
		if (Validator.isNotNull(resultResponse) && !resultResponse.isEmpty()) {
			ExamResult examResult = CustomObjectMapperUtil.readValue(resultResponse, ExamResult.class);
			if (Validator.isNotNull(examResult) && Validator.isNotNull(examResult.getItems())
					&& !examResult.getItems().isEmpty()) {
				logger.info("inside if condn");
				return examResult.getItems().get(0);
			}
		}
		return null;
	}
}
