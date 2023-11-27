package omsb.vehpc.equivalency.mvc.commands.web;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import omsb.vehpc.equivalency.util.EquivalencyUtil;
import omsb.vehpc.equivalency.web.constants.EquivalencyCertificateConstants;
import omsb.vehpc.equivalency.web.constants.MVCCommandNames;
import omsb.vehpc.equivalency.web.constants.OmsbVehpcEquivalencyWebPortletKeys;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbVehpcEquivalencyWebPortletKeys.OMSBVEHPCEQUIVALENCYWEB,
		"mvc.command.name=" + MVCCommandNames.SAVE_UPLOADED_CERTIFICATE_ACTION }, 
		service = MVCActionCommand.class)
public class SaveUploadCertificateMVCActionCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		logger.info("invoking doProcessAction SaveUploadCertificateMVCActionCommand ");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long equivalencyRequestId = ParamUtil.getLong(actionRequest, "equivalencyRequestId");
		long folderId = 0;
		ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), actionRequest);
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		File file = uploadPortletRequest.getFile("certificateUploadFile");
		try (InputStream is = new FileInputStream(file)){
			serviceContext.setAddGroupPermissions(true);
			serviceContext.setAddGuestPermissions(true);
			long timeStamp = new Date().getTime();
			String fileName = EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE+"_"+timeStamp+".pdf";
			DLFileEntry fileEntry = DLFileEntryLocalServiceUtil.addFileEntry(StringPool.BLANK, themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), themeDisplay.getScopeGroupId(), 
					folderId, fileName , ContentTypes.APPLICATION_PDF, EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE+"_"+timeStamp, 
					EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE_URL, EquivalencyCertificateConstants.CERTIFICATE, StringPool.BLANK, 0L, null,
					file, is, file.length(), null, null, serviceContext);
			if (Validator.isNotNull(fileEntry)) {
				Map<String, Serializable> values = new HashMap<>();
				values.put("fileEntryId", fileEntry.getFileEntryId());
				values.put("equivalencyRequestId", equivalencyRequestId);
				values.put("fileName", fileName);
				
				omsbCommonApi.addObjectEntryByERC(OmsbVehpcEquivalencyWebPortletKeys.EQUIVALENCY_CERTIFICATE_ERC, values, actionRequest, themeDisplay);
			}
		} catch (Exception e) {
			logger.error("Exception while uploading the equivalency certificate:::::" , e);
		}
		logger.info("invoking doProcessAction  SaveUploadCertificateMVCActionCommand Ends ");
		
	}
	
	 private static final Log logger = LogFactoryUtil.getLog(SaveUploadCertificateMVCActionCommand.class);

	 @Reference(unbind = "-")
	 private EquivalencyUtil equivalencyUtill;
	 @Reference(unbind = "-")
	 private OMSBCommonApi omsbCommonApi;
}
