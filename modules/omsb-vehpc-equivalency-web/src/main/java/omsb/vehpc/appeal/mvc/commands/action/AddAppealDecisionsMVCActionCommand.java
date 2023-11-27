package omsb.vehpc.appeal.mvc.commands.action;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import omsb.vehpc.equivalency.dto.web.EquivalencyCertificate;
import omsb.vehpc.equivalency.dto.web.EquivalencyDecision;
import omsb.vehpc.equivalency.util.AppealUtil;
import omsb.vehpc.equivalency.util.HeaderUtil;
import omsb.vehpc.equivalency.web.constants.AppealConstants;
import omsb.vehpc.equivalency.web.constants.CertificateHtmlConstants;
import omsb.vehpc.equivalency.web.constants.EquivalencyCertificateConstants;
import omsb.vehpc.equivalency.web.constants.OmsbVehpcEquivalencyWebPortletKeys;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbVehpcEquivalencyWebPortletKeys.OMSBVEHPCEQUIVALENCYWEB,
		"mvc.command.name=" + AppealConstants.ADD_APPEAL_DECISIONS_ACTION, }, service = MVCActionCommand.class)
public class AddAppealDecisionsMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		logger.info("invoking doProcessAction :::::::::");

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long size = ParamUtil.getLong(actionRequest, "size");

		// long equivalencyDecisionLevelId = ParamUtil.getLong(actionRequest,
		// "equivalencyDecisionLevelId");
		long appealId = ParamUtil.getLong(actionRequest, "appealId");
		long equivalencyRequestId = ParamUtil.getLong(actionRequest, "equivalencyRequestId");
		long decisiondocinfo = ParamUtil.getLong(actionRequest, "decisiondocinfo");
		String roleName = ParamUtil.getString(actionRequest, "roleName");
		long workflowTaskId = ParamUtil.getLong(actionRequest, "workflowTaskId");
		long instanceId = ParamUtil.getLong(actionRequest, "workflowInstanceId");
		long personId = ParamUtil.getLong(actionRequest, "personId");
		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		String transitionName = ParamUtil.getString(actionRequest, "transitionName");
		List<Long> eqDecisionIdList = new ArrayList<Long>();
		String htmlCertificateDiv = ParamUtil.getString(actionRequest, "htmlDivData");
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);

		long statusId = 0;
		String key = "";
		String eqDecisionResponse = StringPool.BLANK;
		if (roleName.equalsIgnoreCase(RoleNameConstants.VEHPC_RAPPORTEUR)) {
			key = AppealConstants.PL_EQ_APPEAL_STATUS_ITEM_EQUATED;
			ListTypeEntry statusEntry = omsbCommonApi.getListTypeEntryByListTypeItemKey(AppealConstants.PL_EQ_APPEAL_STATUS, key,
					themeDisplay.getCompanyId());
			if (Validator.isNotNull(statusEntry)) {
				statusId = statusEntry.getListTypeEntryId();
			}
			for (int i = 1; i <= size; i++) {
				//long equivalencyDecisionLevelId = ParamUtil.getLong(actionRequest, "equivalencyDecisionLevelId" + i);
				String comments = ParamUtil.getString(actionRequest, "committeeComments" + i);
				String equivalencyLevelKey = ParamUtil.getString(actionRequest, "committeeNewLevel" + i);
				String equivalencyLevelReasonKey = ParamUtil.getString(actionRequest, "equivalencyLevelReason" + i);
				
				long equivalencyLevelId = 0l;
//			long equivalencyLevelReasonId=0l;
				if (Validator.isNotNull(equivalencyLevelKey) && !equivalencyLevelKey.equals(StringPool.BLANK)) {
					ListTypeEntry equivalencyLevelListTypeEntry = omsbCommonApi.getListTypeEntryByListTypeItemKey(
							OmsbVehpcEquivalencyWebPortletKeys.PL_EQUIVALENCY_LEVEL_ERC, equivalencyLevelKey,
							themeDisplay.getCompanyId());
					equivalencyLevelId = equivalencyLevelListTypeEntry.getListTypeEntryId();
				}
//			if(Validator.isNotNull(equivalencyLevelReasonKey) && !equivalencyLevelReasonKey.equals(StringPool.BLANK)) {
//				ListTypeEntry equivalencyLevelReasonListTypeEntry = omsbCommonApi.getListTypeEntryByListTypeItemKey(OmsbVehpcEquivalencyWebPortletKeys.PL_EQUIVALENCY_LEVEL_REASON_ERC, equivalencyLevelReasonKey, themeDisplay.getCompanyId());
//				equivalencyLevelReasonId = equivalencyLevelReasonListTypeEntry.getListTypeEntryId();
//			}

//				updatedecisionLevel(equivalencyDecisionLevelId, themeDisplay, comments, equivalencyLevelId,
//						equivalencyLevelReasonKey);
				eqDecisionResponse = appealUtil.saveEquivalencyDecision(themeDisplay, equivalencyLevelId,
						equivalencyLevelReasonKey, equivalencyRequestId, comments, decisiondocinfo);
				appealUtil.saveAppealStatus(themeDisplay, roleName, comments, appealId, statusId, equivalencyLevelKey,
						equivalencyLevelReasonKey, "", themeDisplay.getUserId());
				if (Validator.isNotNull(eqDecisionResponse)) {
					EquivalencyDecision equivalencyDecision = CustomObjectMapperUtil.readValue(eqDecisionResponse,
							EquivalencyDecision.class);
					eqDecisionIdList.add(equivalencyDecision.getId());
				}

			}
		}

		else {
			key = AppealConstants.PL_EQ_APPEAL_STATUS_ITEM_COMPLETED;
			ListTypeEntry statusEntry = omsbCommonApi.getListTypeEntryByListTypeItemKey(AppealConstants.PL_EQ_APPEAL_STATUS, key,
					themeDisplay.getCompanyId());
			if (Validator.isNotNull(statusEntry)) {
				statusId = statusEntry.getListTypeEntryId();
			}
			for (int i = 1; i <= size; i++) {
				String comments = ParamUtil.getString(actionRequest, "adminComments" + i);
				String adminAppealLevelKey = ParamUtil.getString(actionRequest, "adminNewLevel" + i);
				String adminAppealLevelReasonKey = ParamUtil.getString(actionRequest, "adminAppealLevelReason" + i);
				long adminAppealLevel = 0l;
				if (Validator.isNotNull(adminAppealLevelKey) && !adminAppealLevelKey.equals(StringPool.BLANK)) {
					ListTypeEntry equivalencyLevelListTypeEntry = omsbCommonApi.getListTypeEntryByListTypeItemKey(
							OmsbVehpcEquivalencyWebPortletKeys.PL_EQUIVALENCY_LEVEL_ERC, adminAppealLevelKey,
							themeDisplay.getCompanyId());
					adminAppealLevel = equivalencyLevelListTypeEntry.getListTypeEntryId();
				}
				long equivalencyDecisionLevelId = ParamUtil.getLong(actionRequest, "equivalencyDecisionLevelId" + i);
				logger.info("admin commnets" + comments);
				logger.info("adminAppealLevel" + adminAppealLevel);
				appealUtil.updatedecisionLevel(equivalencyDecisionLevelId, themeDisplay, comments, adminAppealLevel,
						adminAppealLevelReasonKey);
				eqDecisionResponse = appealUtil.saveEquivalencyDecision(themeDisplay, adminAppealLevel,
						adminAppealLevelReasonKey, equivalencyRequestId, comments, decisiondocinfo);
//				appealUtil.saveAppealStatus(themeDisplay, roleName, comments, appealId, statusId, adminAppealLevelKey,
//						adminAppealLevelReasonKey, "", themeDisplay.getUserId());
				if (Validator.isNotNull(eqDecisionResponse)) {
					EquivalencyDecision equivalencyDecision = CustomObjectMapperUtil.readValue(eqDecisionResponse,
							EquivalencyDecision.class);
					eqDecisionIdList.add(equivalencyDecision.getId());
				}
			}
		}

		for (int i = 1; i <= size; i++) {
			if (Validator.isNotNull(eqDecisionIdList) && eqDecisionIdList.size() == size) {
				appealUtil.uploadDocuments(equivalencyRequestId, themeDisplay, actionRequest, personId, appealId,
						eqDecisionIdList.get(i - 1), "decisionAdditionalAttachment" + i,
						OmsbVehpcEquivalencyWebPortletKeys.ADDITIONAL_DOCUMENTS_TYPE);
			}
		}

		appealUtil.updateEquivalencyAppeal(themeDisplay, appealId, statusId);
		WorkflowInstance workflowInstance = null;
		try {
			workflowInstance = WorkflowInstanceManagerUtil.getWorkflowInstance(themeDisplay.getCompanyId(), instanceId);
			if (Validator.isNotNull(workflowInstance)) {
				logger.info("CMD is " + cmd);
				appealUtil.assignOrCompleteWorkflow(transitionName, cmd, themeDisplay, workflowInstance,
						workflowTaskId);
			}
			
			if (roleName.equalsIgnoreCase(RoleNameConstants.VEHPC_ADMIN)) {
				String htmlData = CertificateHtmlConstants.HTML_HEAD + htmlCertificateDiv + CertificateHtmlConstants.HTML_FOOT;
				DLFileEntry fileEntry = null;
				if (Validator.isNotNull(htmlCertificateDiv) && !htmlCertificateDiv.equals(StringPool.BLANK)) {
					// Generate and Save ceritificate
					fileEntry = appealUtil.createDecisionLevelCertificate(actionRequest, equivalencyRequestId, htmlData);
				} else {
					// Upload Certificate
					long folderId = 0;
					ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), actionRequest);
					File file = uploadPortletRequest.getFile("certificateUploadFile");
					try (InputStream is = new FileInputStream(file)) {
						serviceContext.setAddGroupPermissions(true);
						serviceContext.setAddGuestPermissions(true);
						long timeStamp = new Date().getTime();
						String fileName = EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE + "_" + timeStamp + ".pdf";
						fileEntry = DLFileEntryLocalServiceUtil.addFileEntry(StringPool.BLANK, themeDisplay.getUserId(),
								themeDisplay.getScopeGroupId(), themeDisplay.getScopeGroupId(), folderId, fileName,
								ContentTypes.APPLICATION_PDF,
								EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE + "_" + timeStamp,
								EquivalencyCertificateConstants.EQUIVALENCY_CERTIFICATE_URL,
								EquivalencyCertificateConstants.CERTIFICATE, StringPool.BLANK, 0L, null, file, is,
								file.length(), null, null, serviceContext);
					} catch (Exception e) {
						logger.error("Exception while uploading the equivalency certificate:::::", e);
					}
				}
				ObjectMapper objectMapper = new ObjectMapper();
				objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				/**
				 * Add Certificate to Table
				 */
				if (Validator.isNotNull(fileEntry)) {
					EquivalencyCertificate equivalencyCertificate = new EquivalencyCertificate();
					equivalencyCertificate.setEquivalencyRequestId(equivalencyRequestId);
					equivalencyCertificate.setEquivalencyAppealId(appealId);
					equivalencyCertificate.setFileEntryId(String.valueOf(fileEntry.getFileEntryId()));
					equivalencyCertificate.setFileName(fileEntry.getFileName());
					appealUtil.addCertificateToEquivalencyCetrificateTable(themeDisplay.getScopeGroupId(), equivalencyCertificate,
							omsbCommonApi.getHttpHeaderInfoAndBasicAuth(), objectMapper);
				}
			}
		} catch (Exception e) {
			logger.error("exception while calling the workflow :: ", e);
		}
	}
	@Reference(unbind = "-")
	private OMSBHttpConnector omsbHttpConnector;

	@Reference(unbind = "-")
	private HeaderUtil headerUtil;

	@Reference(unbind = "-")
	private AppealUtil appealUtil;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	private static final Log logger = LogFactoryUtil.getLog(AddAppealDecisionsMVCActionCommand.class);

}
