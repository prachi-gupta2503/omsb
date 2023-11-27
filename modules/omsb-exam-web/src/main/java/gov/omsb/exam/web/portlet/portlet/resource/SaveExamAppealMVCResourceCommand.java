
package gov.omsb.exam.web.portlet.portlet.resource;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.common.util.FileUploadUtil;
import gov.omsb.exam.web.portlet.constants.MVCCommands;
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;
import gov.omsb.exam.web.portlet.dto.ExamAppealStatus;
import gov.omsb.exam.web.portlet.util.ExamAppealUtil;
import gov.omsb.exam.web.portlet.util.ExamUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;

@Component(immediate = true, property = { "javax.portlet.name=" + OMSBExamWebPortletKeys.OMSBEXAMWEB,
		"mvc.command.name="+MVCCommands.EXAM_APPEAL_RESOURCE_COMMAND }, service = MVCResourceCommand.class)
public class SaveExamAppealMVCResourceCommand implements MVCResourceCommand {
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		logger.debug("Start Invoking save Exam Appeal doProcessAction method");
		long examResultId = ParamUtil.getLong(resourceRequest, "examResultId");
		String comments = ParamUtil.getString(resourceRequest, "appealComments");
		double examFees = ParamUtil.getDouble(resourceRequest, "appealFees");
		String jsonData = ParamUtil.getString(resourceRequest, "supportingDocJson");
		ExamAppealStatus examAppealStatus = saveAppealStatusData(themeDisplay, comments, 
				examAppealUtil.setStatus(OMSBExamWebPortletKeys.PL_EXAM_STATUS_KEY_PENDING, themeDisplay.getCompanyId()));
		try {
			JSONObject appealData = JSONFactoryUtil.createJSONObject(jsonData);
			JSONArray  array = appealData.getJSONArray("items");
			for (int index = 0; index < array.length(); index++) {
				JSONObject supportingvalues = array.getJSONObject(index);
				String fileName = supportingvalues.getString("fileName");
				String docTitle = supportingvalues.getString("docTitle");
				UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
				File file = uploadRequest.getFile(fileName);
				FileEntry entry = FileUploadUtil.addFileEntry(fileName, file, FileUtil.getExtension(fileName), themeDisplay.getScopeGroupId(), 0);
				if (Validator.isNotNull(entry) && examAppealStatus != null) {
					logger.debug("fileName ?? " + entry.getFileEntryId());
					saveAppealDocsData(themeDisplay, docTitle, examAppealStatus.getId(), entry.getFileEntryId());
				}
			}
		} catch (JSONException e) {
			logger.error("error while parsing JSON ::" + e.getLocalizedMessage());
			logger.debug(e);
		} 
		
		try {
			PrintWriter out = resourceResponse.getWriter();
			out.println(examAppealUtil.createExamPayment(themeDisplay, examResultId, examFees, examAppealStatus.getId(), OMSBExamWebPortletKeys.FEES_TYPE_EXAM_APPEAL));
		} catch (IOException e) {
			logger.error("error while setting PrintWriter :" + e.getLocalizedMessage());
			logger.debug(e);
		}
		logger.debug("Invoked save Exam Appeal doProcessAction method successful");
		return false;
	}
	
	private ExamAppealStatus saveAppealStatusData(ThemeDisplay themeDisplay, String reason, long statusId) {
		String url = themeDisplay.getPortalURL() + LRObjectURL.EXAM_APPEAL_STATUS_URL +
				CommonConstants.SCOPES+StringPool.SLASH + themeDisplay.getScopeGroupId();
		
		logger.info("url :" + url);
		JSONObject object = JSONFactoryUtil.createJSONObject();
		object.put("lrUserId", themeDisplay.getUserId());
		object.put("isAdmin", Boolean.FALSE);
		object.put("reason", reason);
		object.put("appealStatus", statusId);
		object.put("creator", themeDisplay.getUser().getFullName());
		String response = omsbHttpConnector.executePost(url , object.toString(),  omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
		logger.debug("response ?? " + response);
		return CustomObjectMapperUtil.readValue(response, ExamAppealStatus.class);
	}
	
	private void saveAppealDocsData(ThemeDisplay themeDisplay, String docTitle, long appealId, long fileEntryId) {
		String url = themeDisplay.getPortalURL() + LRObjectURL.EXAM_APPEAL_DOCUMENTS_URL +
				CommonConstants.SCOPES+StringPool.SLASH + themeDisplay.getScopeGroupId();
		JSONObject object = JSONFactoryUtil.createJSONObject();
		object.put("examAppealStatusId", appealId);
		object.put("documentTitle", docTitle);
		object.put("fileEntryId", fileEntryId);
		String response = omsbHttpConnector.executePost(url , object.toString(),  omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
		logger.debug("response ?? " + response);
	}
	
	@Reference
	private OMSBCommonApi omsbCommonApi;
	
	@Reference
	private OMSBHttpConnector omsbHttpConnector;
	
	@Reference
	private ExamAppealUtil examAppealUtil;
	
	@Reference
	private ExamUtil examUtil;

	private static final Log logger = LogFactoryUtil.getLog(SaveExamAppealMVCResourceCommand.class);
}