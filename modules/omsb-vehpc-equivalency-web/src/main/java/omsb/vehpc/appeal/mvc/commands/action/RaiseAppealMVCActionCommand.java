package omsb.vehpc.appeal.mvc.commands.action;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.list.type.model.ListTypeDefinition;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeDefinitionLocalServiceUtil;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.object.model.ObjectEntry;
import com.liferay.petra.string.StringPool;
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
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.common.util.FileUploadUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import omsb.vehpc.equivalency.dto.web.EquivalencyDecision;
import omsb.vehpc.equivalency.dto.web.EquivalencyDecisionItems;
import omsb.vehpc.equivalency.dto.web.EquivalencyLevel;
import omsb.vehpc.equivalency.dto.web.EquivalencyRequest;
import omsb.vehpc.equivalency.util.AppealUtil;
import omsb.vehpc.equivalency.util.HeaderUtil;
import omsb.vehpc.equivalency.web.constants.AppealConstants;
import omsb.vehpc.equivalency.web.constants.OmsbVehpcEquivalencyWebPortletKeys;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbVehpcEquivalencyWebPortletKeys.OMSBVEHPCEQUIVALENCYWEB,
		"mvc.command.name=saveFormAppeal", }, service = MVCActionCommand.class)
public class RaiseAppealMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		logger.info("ACtion MVC Commnad is Started=======");

		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long equivalencyRequestId = ParamUtil.getLong(actionRequest, "equivalencyRequestId");
		long equivalencyAppealId = ParamUtil.getLong(actionRequest, "equivalencyAppealId");
		long decisionLevelCount = ParamUtil.getLong(actionRequest, "decisionLevelCount");
		String comments = ParamUtil.getString(actionRequest, "comments");
		String supportingDocs = ParamUtil.getString(actionRequest, "supportingDocsAndType");
		String command = ParamUtil.getString(actionRequest, "cmd");

		logger.info("equivalencyRequestId -------------------------" + equivalencyRequestId);
		logger.info("decisionLevelCount -------------------------" + decisionLevelCount);

		long appealStatusId = 0;
		long personId = 0;
		String level = StringPool.BLANK;
		try {

			String equivalencyUrl = themeDisplay.getPortalURL() + AppealConstants.REQUEST_URL + equivalencyRequestId;
			String equivalencyResponse = omsbHttpConnector.executeGet(equivalencyUrl, "", headerUtil.getHeaders());
			EquivalencyRequest equivalencyRequest = CustomObjectMapperUtil.readValue(equivalencyResponse,
					EquivalencyRequest.class);
			if (Validator.isNotNull(equivalencyRequest)) {
				personId = equivalencyRequest.getPersonId();
			}
			String equivalencyDecisionUrl = themeDisplay.getPortalURL() + AppealConstants.EQUIVALENCY_DECISION_URL+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId() + "?filter=equivalencyRequestId"+ URLEncoder.encode(" eq " + equivalencyRequestId, DataflowConstants.UTF_8) +AppealConstants.PAGE_SIZE;
			String equivalencyDecisionResponse = omsbHttpConnector.executeGet(equivalencyDecisionUrl, "", headerUtil.getHeaders());
			EquivalencyDecisionItems equivalencyDecisionItems= CustomObjectMapperUtil.readValue(equivalencyDecisionResponse,
					EquivalencyDecisionItems.class);
			if(Validator.isNotNull(equivalencyDecisionItems) && equivalencyDecisionItems.getItems().size() > 0) {
				EquivalencyLevel equivalencyLevel = equivalencyDecisionItems.getItems().get(0).getEquivalencyLevelId();
				if(Validator.isNotNull(equivalencyLevel)) {
					level =equivalencyLevel.getKey();	
				}
			}
			ListTypeEntry statusEntry = null;
			if ("saveAsDraft".equalsIgnoreCase(command)) {
				statusEntry = getListTypeEntryByListTypeItemKey(AppealConstants.PL_EQ_APPEAL_STATUS,
						AppealConstants.PL_EQ_APPEAL_STATUS_ITEM_CREATED_EMPLOYER_DRAFT, themeDisplay.getCompanyId());
			} else {
				statusEntry = getListTypeEntryByListTypeItemKey(AppealConstants.PL_EQ_APPEAL_STATUS,
						AppealConstants.PL_EQ_APPEAL_STATUS_ITEM_CREATED, themeDisplay.getCompanyId());
			}

			if (Validator.isNotNull(statusEntry)) {
				appealStatusId = statusEntry.getListTypeEntryId();
			}

			Map<String, Serializable> values = new HashMap<>();
			values.put("eQRequestedId", equivalencyRequestId);
			values.put("comments", comments);
			values.put("appellantUserId", themeDisplay.getUserId());
			values.put("statusID", appealStatusId);
			values.put("employeePersonId", personId);
			values.put("eqLevelId", level);
			
			

			ObjectEntry objectEntry = null;
			if (equivalencyAppealId == 0) {
				objectEntry = omsbCommonApi.addObjectEntryByERC(AppealConstants.APPEAL_REQUEST_SAVE_ERC, values,
						actionRequest, themeDisplay);
			} else {
				objectEntry = omsbCommonApi.updateObjectEntryById(AppealConstants.APPEAL_REQUEST_SAVE_ERC, themeDisplay,
						equivalencyAppealId, values, actionRequest);
				removeOldDecisionDocumentEntries(equivalencyAppealId, themeDisplay);
			}

			String appealId = String.valueOf(objectEntry.getObjectEntryId());

			// Save Decision Documents
			String decisionDocumentUrl = themeDisplay.getPortalURL() + AppealConstants.EQUIVALENCY_APPEAL_DOCUMENTS_URL
					+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId();
			for (int i = 0; i < decisionLevelCount; i++) {
				JSONObject decisionDocument = JSONFactoryUtil.createJSONObject();
				boolean checkBox = ParamUtil.getBoolean(actionRequest, "certCheckBox" + i);
				if (checkBox) {
					decisionDocument.put("eQAppealId", appealId);
					decisionDocument.put("eqDecisionLevelId",
							ParamUtil.getString(actionRequest, "decisionLevelId" + i));
					decisionDocument.put("eqLevel", ParamUtil.getString(actionRequest, "decisionLevelKey" + i));
					decisionDocument.put("equivalencyRequestId", equivalencyRequestId);
				}
				omsbHttpConnector.executePost(decisionDocumentUrl, decisionDocument.toString(),
						omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
			}

			// Save Supporting Documents
			DLFolder folder = appealUtil.createFolderStructure(themeDisplay.getScopeGroupId(), personId, themeDisplay);

			JSONObject appealDocsData = JSONFactoryUtil.createJSONObject(supportingDocs);
			JSONArray appealSupportingDocuments = appealDocsData.getJSONArray("appealSupportingDocuments");
			for (int index = 0; index < appealSupportingDocuments.length(); index++) {
				JSONObject supportingvalues = appealSupportingDocuments.getJSONObject(index);
				Object optionValues = supportingvalues.get("optionvalue");
				Object documentValues = supportingvalues.get("documentInputValue");
				String optionValue = optionValues.toString();
				String documentName = documentValues.toString();
				Object otherDocTypeObject = supportingvalues.get("otherDocType");
				String otherDocType = null;
				if (Validator.isNotNull(otherDocTypeObject)) {
					otherDocType = otherDocTypeObject.toString();
				}

				String fileName = uploadPortletRequest.getFileName(documentName);
				File file = uploadPortletRequest.getFile(documentName);
				byte[] fileContent = Files.readAllBytes(file.toPath());
				String mimeType = uploadPortletRequest.getContentType(documentName);

				FileEntry fileEntry = FileUploadUtil.createFileEntry(themeDisplay.getScopeGroupId(),
						folder.getFolderId(), fileName, mimeType, "", fileContent);

				// Save Supporting Docuement Details In Document Info
				if (Validator.isNotNull(fileEntry)) {
					long fileEntryId = fileEntry.getFileEntryId();
					JSONObject docsobject = JSONFactoryUtil.createJSONObject();
					docsobject.put("fileEntryID", fileEntryId);
					docsobject.put("documentType", optionValue);
					docsobject.put("caseRequestId", "0"); ///
					docsobject.put("componentClassRefId", appealId);
					docsobject.put("componentId", "0"); ///
					docsobject.put("dFDocumentId", "0"); //
					docsobject.put("dFFileKey", "0"); ///
					docsobject.put("dFFileName", fileName);
					docsobject.put("personId", personId); /// store personId here
					docsobject.put("equivalencyRequestId", equivalencyRequestId);
					docsobject.put("equivalencyAppealId", appealId);
					if (optionValue.equalsIgnoreCase("others")) {
						docsobject.put("otherDocType", otherDocType);
					}
					String documenturl = themeDisplay.getPortalURL()
							+ AppealConstants.DOCUMENT_INFO_APPEAL_REQUEST_SAVE_URL
							+ themeDisplay.getLayout().getGroupId();
					omsbHttpConnector.executePost(documenturl, docsobject.toString(), headerUtil.getHeaders());
				}
			}
		} catch (JSONException e) {
			logger.error(e.getMessage(), e);
		}
	}

	private void removeOldDecisionDocumentEntries(long appealId, ThemeDisplay themeDisplay) {
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

			// Delete Decision Documents
			String decisionDocumentUrl = themeDisplay.getPortalURL() + AppealConstants.EQUIVALENCY_APPEAL_DOCUMENTS_URL
					+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId();

			decisionDocumentUrl = decisionDocumentUrl + StringPool.QUESTION + "filter=eQAppealId" + URLEncoder
					.encode(" eq " + appealId, OmsbVehpcEquivalencyWebPortletKeys.UNICODE_TRANSFORMATION_FORMAT);

			String decisionDocumentResponse = omsbHttpConnector.executeGet(decisionDocumentUrl, "",
					omsbCommonApi.getHttpHeaderInfoAndBasicAuth());

			EquivalencyDecisionItems equivalencyDecisionItems = objectMapper
					.readValue(decisionDocumentResponse.toString(), new TypeReference<EquivalencyDecisionItems>() {
					});
			if (Validator.isNotNull(equivalencyDecisionItems) && equivalencyDecisionItems.getItems().size() > 0) {
				for (int i = 0; i < equivalencyDecisionItems.getItems().size(); i++) {

					EquivalencyDecision equivalencyDecision = equivalencyDecisionItems.getItems().get(i);
					long equivalencyDecisionId = equivalencyDecision.getId();

					String decisionDocumentDeleteUrl = themeDisplay.getPortalURL()
							+ AppealConstants.EQUIVALENCY_APPEAL_DOCUMENTS_URL + equivalencyDecisionId;
					omsbHttpConnector.executeDelete(decisionDocumentDeleteUrl,
							omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
				}
			}
		} catch (UnsupportedEncodingException | JsonProcessingException e) {
			e.printStackTrace();
		}

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
				logger.error("exception while getting the list type item", e);
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
