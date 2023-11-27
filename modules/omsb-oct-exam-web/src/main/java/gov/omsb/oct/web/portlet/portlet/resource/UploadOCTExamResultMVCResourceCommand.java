package gov.omsb.oct.web.portlet.portlet.resource;

import com.liferay.object.model.ObjectDefinition;
import com.liferay.object.model.ObjectEntry;
import com.liferay.object.service.ObjectDefinitionService;
import com.liferay.object.service.ObjectEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
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
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamDefinition;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamResultItem;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamSchedule;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name=" + MVCCommandNames.UPLOAD_OCT_EXAM_RESULT }, service = MVCResourceCommand.class

)
public class UploadOCTExamResultMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		logger.info("doServeResource() started:::");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String cmd = ParamUtil.getString(resourceRequest, "cmd");
		if (cmd.equalsIgnoreCase(OmsbOctExamWebPortletKeys.CHECK_OCT_RESULT)) {
			checkExamResult(resourceResponse, resourceRequest);
		}
		if (cmd.equalsIgnoreCase(OmsbOctExamWebPortletKeys.UPLOAD_OCT_EXAM_RESULT)) {
			String jsonString = ParamUtil.getString(resourceRequest, OmsbOctExamWebPortletKeys.RESULT_RECORDS);
			logger.info("jsonString :::" + jsonString);
			jsonString = jsonString.replace("\\", "");
			jsonString = jsonString.substring(1, jsonString.length() - 1);
			logger.info("jsonString :::" + jsonString);
			JSONArray jsonArray = JSONFactoryUtil.createJSONArray(jsonString);
			JSONObject resultObject = jsonArray.getJSONObject(0);
			JSONArray examResultsArray = resultObject.getJSONArray(OmsbOctExamWebPortletKeys.EXAM_RESULTS);
			logger.info("exam result array::"+examResultsArray.toString()+ "size"+examResultsArray.length());
			for (int i = 0; i < examResultsArray.length(); i++) {
				OCTExamResultItem examResultItems = new OCTExamResultItem();
				JSONObject examResultObject = examResultsArray.getJSONObject(i);
				String result = examResultObject.getString("result");
				double percentage = examResultObject.getDouble("percentage");
				boolean appeared = examResultObject.getBoolean("appeared");
				long examScheduleId = ParamUtil.getLong(resourceRequest, "examScheduleId");
				
				long lrUserId = examResultObject.getLong("lrUserId");
				logger.info("result::" + result);
				logger.info("percentage::" + percentage);
				
//				examResultItems=examUtil.getOCTExamResultByUserId(themeDisplay, lrUserId);
				examResultItems.setResult(result.toLowerCase());
				examResultItems.setPercentage(percentage);
				examResultItems.setLrUserId(lrUserId);
				examResultItems.setoCExamScheduleId(examScheduleId);
				OCTExamSchedule octExamSchedule = examUtil.getOCTExamScheduleById(examScheduleId, themeDisplay.getPortalURL());
			     if(Validator.isNotNull(octExamSchedule)) {
				   OCTExamDefinition octExamDefinition = examUtil.getOCTExamDefinitionByDefinitionId(octExamSchedule.getOctExamDefinitionId(), themeDisplay.getPortalURL());
				   	if(Validator.isNotNull(octExamDefinition)) {
				long examDefinitionId = octExamDefinition.getId();
				examResultItems.setoCExamDefinitionId(examDefinitionId);
				logger.info("exam defn id::"+examDefinitionId);
			     }
			     }
				
				examResultItems.setAppeared(appeared);
				
				logger.info(examResultItems);
				JSONObject createJSONObject = JSONFactoryUtil.createJSONObject();
//				createJSONObject.put("id", examResultItems.getId());
				createJSONObject.put("oCExamDefinitionId", examResultItems.getoCExamDefinitionId());
				createJSONObject.put("oCExamScheduleId", examResultItems.getoCExamScheduleId());
				createJSONObject.put("lrUserId", examResultItems.getLrUserId());
				createJSONObject.put("percentage", examResultItems.getPercentage());
				createJSONObject.put("result", examResultItems.getResult());
				createJSONObject.put("appeared", examResultItems.isAppeared());
				String examResultResponse = CustomObjectMapperUtil.writeValueAsString(examResultItems, null);
				Map<String, String> headers = omsbCommonApi.getHttpHeaderInfoAndBasicAuth();
				logger.info("examResultResponse::" + examResultResponse);
				logger.info("examResultResponse::" + createJSONObject.toJSONString());
				logger.info(themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_RESULTS +  StringPool.SLASH +  examResultItems.getId());
				
				
				OCTExamResultItem octExamResultItem = examUtil.getOCTExamResultByUserId(themeDisplay, lrUserId);
				if(Validator.isNotNull(octExamResultItem)) {
					
				String executePut = omsbHttpConnector.executePut(
						(themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_RESULTS 
								+ StringPool.SLASH +  octExamResultItem.getId()),
						createJSONObject.toJSONString(), headers);
				logger.info(executePut);
				} else {
					
					String executePost = omsbHttpConnector.executePost(
							(themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_RESULTS + CommonConstants.SCOPES
									+ StringPool.SLASH + String.valueOf(themeDisplay.getScopeGroupId())),
							examResultResponse, headers);
					logger.info("url::"+ (themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_RESULTS + CommonConstants.SCOPES
							+ StringPool.SLASH + String.valueOf(themeDisplay.getScopeGroupId())));
					logger.info("executePost::"+executePost);
				}
					}
		}
	}

	public void checkExamResult(ResourceResponse resourceResponse, ResourceRequest resourceRequest) {
		logger.info("checkExamResult() started:::");
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
		File file = uploadPortletRequest.getFile(OmsbOctExamWebPortletKeys.RESULT_FILE);
		String fileName = uploadPortletRequest.getFileName(OmsbOctExamWebPortletKeys.RESULT_FILE);
		logger.info("file name:::" + fileName);
		List<OCTExamResultItem> examResults = new ArrayList();

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
					String result = rows.getCell(2).getStringCellValue();
					double percentage = rows.getCell(3).getNumericCellValue();
					boolean appeared = rows.getCell(4).getBooleanCellValue();
					long lrUserId = (long) rows.getCell(0).getNumericCellValue();
					logger.info("result:::" + result);
					logger.info("percentage:::" + percentage);
					logger.info("lrUserId:::" + lrUserId);
					OCTExamResultItem examResult = new OCTExamResultItem();
					examResult.setResult(result);
					examResult.setPercentage(percentage);
					examResult.setAppeared(appeared);
					examResult.setLrUserId(lrUserId);
					if (result.equalsIgnoreCase(OmsbOctExamWebPortletKeys.PASS)
							|| (result.equalsIgnoreCase(OmsbOctExamWebPortletKeys.FAIL))
									&& (percentage >= 0 && percentage <= 100)) {
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

	public ObjectEntry addObjectEntryByERC(String erc, Map<String, Serializable> values, PortletRequest request,
			ThemeDisplay themeDisplay) {
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
			ObjectDefinition definition = objectDefinitionService.getObjectDefinitionByExternalReferenceCode(erc,
					themeDisplay.getCompanyId());
			if (definition != null) {
				return ObjectEntryLocalServiceUtil.addObjectEntry(themeDisplay.getUserId(),
						themeDisplay.getScopeGroupId(), definition.getObjectDefinitionId(), values, serviceContext);
			}
		} catch (PortalException e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	@Reference
	private ObjectDefinitionService objectDefinitionService;
	@Reference(unbind = "-")
	private OMSBHttpConnector omsbHttpConnector;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference(unbind = "-")
	private OCTExamUtil examUtil;

	private Log logger = LogFactoryUtil.getLog(UploadOCTExamResultMVCResourceCommand.class);
}
