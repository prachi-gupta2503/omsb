package gov.omsb.vehpc.appeal.web.portlet.action;

import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.list.type.model.ListTypeDefinition;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeDefinitionLocalServiceUtil;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.common.util.FileUploadUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyDecisionLevel;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyLevel;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyRequest;
import gov.omsb.vehpc.appeal.util.AppealUtil;
import gov.omsb.vehpc.appeal.util.HeaderUtil;
import gov.omsb.vehpc.appeal.web.constants.AppealConstants;
import gov.omsb.vehpc.appeal.web.constants.OmsbVehpcAppealWebPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbVehpcAppealWebPortletKeys.OMSBVEHPCAPPEALWEB,
		"mvc.command.name=saveFormAppeal", }, service = MVCActionCommand.class)
public class RaiseAppealMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		logger.info("ACtion MVC Commnad is Started=======");
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long decisionLevelId = ParamUtil.getLong(actionRequest, "decisionLevelId");
		logger.info("decisionLevelId -------------------------"+ decisionLevelId);
		String plkey = AppealConstants.PL_EQ_APPEAL_STATUS_ITEM_CREATED;
		 long statusId =0;
		ListTypeEntry statusEntry = getListTypeEntryByListTypeItemKey(AppealConstants.PL_EQ_APPEAL_STATUS, plkey,
				themeDisplay.getCompanyId());
		if (Validator.isNotNull(statusEntry)) {
		  statusId = statusEntry.getListTypeEntryId();
		}
		String decisionLevelsurl = themeDisplay.getPortalURL() + AppealConstants.DECISION_LEVEL_URL + decisionLevelId;
		/// for comments and level
		String commonApiresponse = omsbHttpConnector.executeGet(decisionLevelsurl, "", headerUtil.getHeaders());
		EquivalencyDecisionLevel equivalencyDecisionLevel = CustomObjectMapperUtil.readValue(commonApiresponse, EquivalencyDecisionLevel.class);
		EquivalencyLevel equivalencyLevelId = equivalencyDecisionLevel.getEquivalencyLevelId();
		String key = equivalencyLevelId.getKey();
		long equivalencyRequestId = equivalencyDecisionLevel.getEqRequestId();
		long docsInfoId =0;
		long employeePersonId =0;
		if(Validator.isNotNull(equivalencyDecisionLevel)) {
		 employeePersonId = getEmployeePersonByRequestId(equivalencyRequestId, themeDisplay);
		}
		if(Validator.isNotNull(equivalencyDecisionLevel)) {
		 docsInfoId = equivalencyDecisionLevel.getDocumentInfoId();
		}
		String url = themeDisplay.getPortalURL() + AppealConstants.APPEAL_REQUEST_SAVE_URL
				+ themeDisplay.getLayout().getGroupId();
		String comments = ParamUtil.getString(actionRequest, "comments");
		JSONObject object = JSONFactoryUtil.createJSONObject();
		String userId = String.valueOf(themeDisplay.getUserId());
		object.put("eQDecisionId", decisionLevelId);
		object.put("eQRequestedId", equivalencyRequestId);
		object.put("comments", comments);
		object.put("appellantUserId", userId);
		object.put("eqLevelId", key);
		object.put("documentInfoId", docsInfoId);
		object.put("statusID", statusId);
		object.put("employeePersonId", employeePersonId);
		String response = omsbHttpConnector.executePost(url, object.toString(), headerUtil.getHeaders());

		String requestUrl = themeDisplay.getPortalURL()+ AppealConstants.REQUEST_URL + equivalencyRequestId;
		String requestResponse = omsbHttpConnector.executeGet(requestUrl, "", headerUtil.getHeaders());
		EquivalencyRequest equivalencyRequest = CustomObjectMapperUtil.readValue(requestResponse, EquivalencyRequest.class);
		long personId =0;
		if(Validator.isNotNull(equivalencyRequest)) {
		 personId = equivalencyRequest.getPersonId();
		}
		JSONObject objectforId = JSONFactoryUtil.createJSONObject(response);
		String appealId = objectforId.getString("id");
		String supportingDocs = ParamUtil.getString(actionRequest, "supportingDocsAndType");
		logger.info("supportingDocs   "+supportingDocs.length());
		JSONObject appealDocsData;
		DLFolder folder = appealUtil.createFolderStructure(themeDisplay.getScopeGroupId(), personId, themeDisplay);
		
				
		try {
			logger.info("inside the try and catch of document ");
			appealDocsData = JSONFactoryUtil.createJSONObject(supportingDocs);
			JSONArray appealSupportingDocuments = appealDocsData.getJSONArray("appealSupportingDocuments");
			for (int index = 0; index < appealSupportingDocuments.length(); index++) {
				JSONObject supportingvalues = appealSupportingDocuments.getJSONObject(index);
				Object optionValues = supportingvalues.get("optionvalue");
				Object documentValues = supportingvalues.get("documentInputValue");
				String optionValue = optionValues.toString();
				logger.info(optionValue + "this is the option value whihc is type  name ");
				String documentName = documentValues.toString();
				logger.info(documentName + "this is the doucment name ");
				
				String fileName = uploadPortletRequest.getFileName(documentName);
				logger.info("fileName of the uploaded document" + fileName);
				logger.info("above file entry  line  the try and catch of document ");
				File file = uploadPortletRequest.getFile(documentName);
				logger.info("file "+file);
				String mimeType = uploadPortletRequest.getContentType(documentName);
				logger.info("mimeType "+mimeType);
				
				logger.info("folder  folder.getFolderId() -------  "+folder.getFolderId());
				long fileEntryId = 0;
				FileEntry fileEntry = FileUploadUtil.addDocument(fileName,file, mimeType, themeDisplay.getScopeGroupId(), folder.getFolderId());
				logger.info("fileEntry  "+fileEntry);
				if (Validator.isNotNull(fileEntry)) {
					fileEntryId = fileEntry.getFileEntryId();
				}
				logger.info("=this is the file entry id watch it ==================================================== " + fileEntryId);
				JSONObject docsobject = JSONFactoryUtil.createJSONObject();
				docsobject.put("fileEntryID", fileEntryId);
				docsobject.put("documentType", optionValue);
				docsobject.put("caseRequestId", "0"); ///
				docsobject.put("componentClassRefId", appealId);
				docsobject.put("componentId", "0"); /// this is pending
				docsobject.put("dFDocumentId", "0"); //
				docsobject.put("dFFileKey", "0"); ///
				docsobject.put("dFFileName", fileName);
				docsobject.put("personId", personId); /// store personId here
				docsobject.put("equivalencyRequestId", equivalencyRequestId);
				docsobject.put("equivalencyAppealId", appealId);
				logger.info(docsobject.toString() + "this is the json passing parameter");
				String documenturl = themeDisplay.getPortalURL() + AppealConstants.DOCUMENT_INFO_APPEAL_REQUEST_SAVE_URL
						+ themeDisplay.getLayout().getGroupId();
				omsbHttpConnector.executePost(documenturl, docsobject.toString(), headerUtil.getHeaders());
				
			}

		} catch (JSONException e) {
			logger.error(e.getMessage(),e);
		}

	}
	
	private long getEmployeePersonByRequestId(long requestId, ThemeDisplay themeDisplay) {
		String requestUrl = themeDisplay.getPortalURL()+ AppealConstants.REQUEST_URL+ requestId;
		String response  = omsbCommonApi.getData(requestUrl);
		EquivalencyRequest equivalencyRequest = CustomObjectMapperUtil.readValue(response, EquivalencyRequest.class);
		return equivalencyRequest.getPersonId();
	}
	
	private ListTypeEntry getListTypeEntryByListTypeItemKey(String listTypeDefinitionERC, String listTypItemeKey,
			long companyId) {
		ListTypeDefinition definition = ListTypeDefinitionLocalServiceUtil
				.fetchListTypeDefinitionByExternalReferenceCode(listTypeDefinitionERC, companyId);
		if (Validator.isNotNull(definition)) {
			try {
				return ListTypeEntryLocalServiceUtil.getListTypeEntry(definition.getListTypeDefinitionId(),
						listTypItemeKey);
			} catch (PortalException e) {
				logger.info("exception while getting the list type item", e);
			}
		}
		return null;
	}
	
	

	@Reference(unbind = "-")
	private OMSBHttpConnector omsbHttpConnector;
	
	@Reference(unbind = "-")
	private AppealUtil appealUtil;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
	
	@Reference
	private HeaderUtil headerUtil;
	private static final Log logger = LogFactoryUtil.getLog(RaiseAppealMVCActionCommand.class);
	

}
