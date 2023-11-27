package gov.omsb.form.builder.portlet.action;

import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.TempFileEntryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.form.builder.constants.FormBuilderConstants;
import gov.omsb.form.builder.constants.FormBuilderWebPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + FormBuilderWebPortletKeys.OMSB_FORM_BUILDER,
"mvc.command.name=/omsb/dropzone/createTempFile" }, service = MVCResourceCommand.class)
public class CreateTempFileMVCResourceCommand extends BaseMVCResourceCommand{

	Log log = LogFactoryUtil.getLog(CreateTempFileMVCResourceCommand.class.getName());
	
	@Reference
	private DLAppService dlAppService;
	
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
		log.info("inside serve resource");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
		JSONObject responseObj = JSONFactoryUtil.createJSONObject();
		PrintWriter writer = null;
		
		try {
			writer = resourceResponse.getWriter();
			int totalFiles = ParamUtil.getInteger(uploadPortletRequest, "totalFiles", 10);
			InputStream inputStream = null;
			JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
			for (int i = 0; i < totalFiles; i++) {
				String sourceFileName = uploadPortletRequest.getFileName(FormBuilderConstants.ATTACHMENT + i + "]");
				if(Validator.isNotNull(sourceFileName)) {
					inputStream = uploadPortletRequest.getFileAsStream(FormBuilderConstants.ATTACHMENT + i + "]");
					String tempFileName = TempFileEntryUtil.getTempFileName(sourceFileName);
					
					log.info("SourceFileName " + sourceFileName);
					log.info("tempFileName " + tempFileName);
					
					String mimeType = uploadPortletRequest.getContentType(FormBuilderConstants.ATTACHMENT + i + "]");
					
					FileEntry fileEntry = dlAppService.addTempFileEntry(themeDisplay.getScopeGroupId(), 0L, "tempAttachments", tempFileName, inputStream, mimeType);
					jsonArray.put(onSuccess(uploadPortletRequest, fileEntry));
				}
			}
			
			responseObj.put(FormBuilderConstants.DATA, jsonArray);
			responseObj.put(FormBuilderConstants.STATUS, "success");
			log.info("Attachments uploaded successfully");
		} catch (IOException | PortalException e) {
			log.error("Error occured while uploading insurance check document -> " + e.getMessage());
			responseObj.put(FormBuilderConstants.STATUS, "error");
			responseObj.put(FormBuilderConstants.STATUS, "Error occured while uploading attachments.");
		} finally {
			writer.write(responseObj.toString());
			writer.close();
		}
	}
	
	private JSONObject onSuccess(UploadPortletRequest uploadPortletRequest, FileEntry fileEntry) throws PortalException {

		String sourceFileName = uploadPortletRequest.getFileName("file");

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put("groupId", fileEntry.getGroupId());
		jsonObject.put("name", fileEntry.getTitle());
		jsonObject.put("title", sourceFileName);
		jsonObject.put("uuid", fileEntry.getUuid());

		return jsonObject;
	}
	
}
