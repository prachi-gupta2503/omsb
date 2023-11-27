package gov.omsb.exam.web.portlet.portlet.resource;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.exam.web.portlet.constants.MVCCommands;
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;
import gov.omsb.exam.web.portlet.dto.ExamResultItem;
import gov.omsb.exam.web.portlet.util.ExamUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;

@Component(immediate = true, property = { "javax.portlet.name=" + OMSBExamWebPortletKeys.OMSBEXAMWEB,
		"mvc.command.name=" + MVCCommands.UPLOAD_EXAM_RESULT }, service = MVCResourceCommand.class

)
public class UploadExamResultMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		logger.info("doServeResource() started:::");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String cmd = ParamUtil.getString(resourceRequest, "cmd");
		if (cmd.equalsIgnoreCase(OMSBExamWebPortletKeys.CHECK_RESULT)) {
			checkExamResult(resourceResponse, resourceRequest);
		}
		if (cmd.equalsIgnoreCase(OMSBExamWebPortletKeys.UPLOAD_EXAM_RESULT)) {
			String jsonString = ParamUtil.getString(resourceRequest, OMSBExamWebPortletKeys.RESULT_RECORDS);
			logger.info("jsonString :::" + jsonString);
			jsonString = jsonString.replace("\\", "");
			jsonString = jsonString.substring(1, jsonString.length() - 1);
			logger.info("jsonString :::" + jsonString);
			JSONArray jsonArray = JSONFactoryUtil.createJSONArray(jsonString);
			JSONObject resultObject = jsonArray.getJSONObject(0);
			JSONArray examResultsArray = resultObject.getJSONArray(OMSBExamWebPortletKeys.EXAM_RESULTS);

			for (int i = 0; i < examResultsArray.length(); i++) {
				ExamResultItem examResultItems = new ExamResultItem();
				JSONObject examResultObject = examResultsArray.getJSONObject(i);
				String result = examResultObject.getString("result");
				double percentage = examResultObject.getDouble("percentage");
				boolean appeared = examResultObject.getBoolean("appeared");
				long examScheduleId = ParamUtil.getLong(resourceRequest, "examScheduleId");
				long examDefinitionId = ParamUtil.getLong(resourceRequest, "examDefinitionId");
				long lrUserId = examResultObject.getLong( "lrUserId");
				logger.info("result::" + result);
				logger.info("percentage::" + percentage);
				logger.info("lr user id::" + lrUserId);
				examResultItems.setResult(result.toLowerCase());
				examResultItems.setPercentage(percentage);
				examResultItems.setLrUserId(lrUserId);
				examResultItems.setExamDefinitionId(examDefinitionId);
				examResultItems.setExamScheduleId(examScheduleId);
				examResultItems.setAppeared(appeared);
				String examResultResponse = CustomObjectMapperUtil.writeValueAsString(examResultItems, null);
				Map<String, String> headers = omsbCommonApi.getHttpHeaderInfoAndBasicAuth();
				logger.info("examResultResponse::" + examResultResponse);
				ExamResultItem examResult = examUtil.getExamResultByScheduleIdAndDefnId(themeDisplay, lrUserId, examDefinitionId, examScheduleId);
				if(Validator.isNotNull(examResult)) {
					String executePut = omsbHttpConnector.executePut(
							(themeDisplay.getPortalURL() + LRObjectURL.EXAM_RESULT_URL 
									+ StringPool.SLASH +  examResult.getId()),
							examResultResponse, headers);
					logger.info(executePut);
				} else {
				omsbHttpConnector.executePost(
						(themeDisplay.getPortalURL() + LRObjectURL.EXAM_RESULT_URL + CommonConstants.SCOPES
								+ StringPool.SLASH + String.valueOf(themeDisplay.getScopeGroupId())),
						examResultResponse, headers);
				}
			}
		}
	}

	public void checkExamResult(ResourceResponse resourceResponse, ResourceRequest resourceRequest) {
		logger.info("checkExamResult() started:::");
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
		File file = uploadPortletRequest.getFile(OMSBExamWebPortletKeys.RESULT_FILE);
		String fileName = uploadPortletRequest.getFileName(OMSBExamWebPortletKeys.RESULT_FILE);
		logger.info("file name:::" + fileName);
		List<ExamResultItem> examResults = new ArrayList();

		try (FileInputStream inputStream = new FileInputStream(file);
				XSSFWorkbook workbook = new XSSFWorkbook(inputStream)) {
			JSONArray resultArray = JSONFactoryUtil.createJSONArray();
			XSSFSheet sheet = workbook.getSheetAt(0);
			int numRows = sheet.getLastRowNum();
			int successCount = 0;
			int failureCount = 0;
			for (int row = 1; row <= numRows; row++) {
				XSSFRow rows = sheet.getRow(row);
				if (rows != null) {
					long lrUserId = (long) rows.getCell(0).getNumericCellValue();
					String result = rows.getCell(10).getStringCellValue();
					double percentage = rows.getCell(11).getNumericCellValue();
					boolean appeared = rows.getCell(12).getBooleanCellValue();
					logger.info("result:::" + result);
					logger.info("percentage:::" + percentage);
					ExamResultItem examResult = new ExamResultItem();
					examResult.setResult(result);
					examResult.setPercentage(percentage);
					examResult.setAppeared(appeared);
					examResult.setLrUserId(lrUserId);

					if (result.equalsIgnoreCase(OMSBExamWebPortletKeys.PASS)
							|| (result.equalsIgnoreCase(OMSBExamWebPortletKeys.FAIL)) && (percentage >= 0
							&& percentage <= 100)) {
						successCount++;
					} else {
						failureCount++;
					}
					examResults.add(examResult);
				}
			}
			logger.info("successCount ::" + successCount);
			logger.info("failureCount ::" + failureCount);
			JSONObject resultCountObject = JSONFactoryUtil.createJSONObject();
			resultCountObject.put("successCount", successCount);
			resultCountObject.put("failureCount", failureCount);
			resultCountObject.put("examResults", examResults);
			resultArray.put(resultCountObject);
			resourceResponse.getWriter().write(resultArray.toString());
		} catch (Exception e) {
			logger.error("file error is:: " + e.getMessage(), e);
		}
		logger.info("doServeResource() ended:::");
	}

	@Reference(unbind = "-")
	private OMSBHttpConnector omsbHttpConnector;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
	
	@Reference
	private ExamUtil examUtil;

	private Log logger = LogFactoryUtil.getLog(UploadExamResultMVCResourceCommand.class);
}
