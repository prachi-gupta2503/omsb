package gov.omsb.vehpc.appeal.web.portlet.action;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.list.type.model.ListTypeDefinition;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeDefinitionLocalServiceUtil;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyCertificate;
import gov.omsb.vehpc.appeal.util.AppealUtil;
import gov.omsb.vehpc.appeal.util.HeaderUtil;
import gov.omsb.vehpc.appeal.web.constants.AppealConstants;
import gov.omsb.vehpc.appeal.web.constants.OmsbVehpcAppealWebPortletKeys;

@Component(immediate = true, 
property = { "javax.portlet.name=" + OmsbVehpcAppealWebPortletKeys.OMSBVEHPCAPPEALWEB,
			 "mvc.command.name=" + AppealConstants.SAVE_EQUIVALENCY_RESPONSE, 
			}, 
			service = MVCActionCommand.class)
public class SaveEquivalencyResponse extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		logger.info("invoking doProcessAction :::::::::");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long equivalencyDecisionLevelId = ParamUtil.getLong(actionRequest, "equivalencyDecisionLevelId");
		long appealId = ParamUtil.getLong(actionRequest, "appealId");
		long equivalencyRequestId = ParamUtil.getLong(actionRequest, "equivalencyRequestId");
		long decisiondocinfo = ParamUtil.getLong(actionRequest, "decisiondocinfo");
		String comments = "";
		long equivalencyLevel = 0;
		String roleName = ParamUtil.getString(actionRequest, "roleName");
		long workflowTaskId = ParamUtil.getLong(actionRequest, "workflowTaskId");
		long instanceId = ParamUtil.getLong(actionRequest, "workflowInstanceId");
		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		String transitionName = ParamUtil.getString(actionRequest, "transitionName");

		long statusId = 0;
		String key = "";
		if (roleName.equalsIgnoreCase(RoleNameConstants.VEHPC_COMMITTEE)) {
			key = AppealConstants.PL_EQ_APPEAL_STATUS_ITEM_EVALUATED;
			comments = ParamUtil.getString(actionRequest, "committeeComments");
			equivalencyLevel =  ParamUtil.getLong(actionRequest, "committeeNewLevel");
		
		} 
		
		else {
			key = AppealConstants.PL_EQ_APPEAL_STATUS_ITEM_COMPLETED;
			comments = ParamUtil.getString(actionRequest, "adminComments");
			equivalencyLevel	= ParamUtil.getLong(actionRequest, "adminNewLevel");
			logger.info("admin commnets"+comments);
			logger.info("equivalencyLevel"+equivalencyLevel);
			updatedecisionLevel(equivalencyDecisionLevelId, themeDisplay,comments,equivalencyLevel);
		}
		
		
		
		ListTypeEntry statusEntry = getListTypeEntryByListTypeItemKey(AppealConstants.PL_EQ_APPEAL_STATUS, key,
				themeDisplay.getCompanyId());
		if (Validator.isNotNull(statusEntry)) {
			statusId = statusEntry.getListTypeEntryId();
		}
		appealUtil.saveEquivalencyDecision(themeDisplay, equivalencyLevel, equivalencyRequestId, comments, decisiondocinfo);
		appealUtil.saveAppealStatus(themeDisplay, roleName, comments, appealId, statusId, equivalencyLevel);
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
				
				DLFileEntry fileEntry = appealUtil.createDecisionLevelCertificate(actionRequest, equivalencyRequestId);
				logger.info("fileEntry::::::VIEWAPPEAL::::" + fileEntry);
				if (Validator.isNotNull(fileEntry)) {
					EquivalencyCertificate equivalencyCertificate = new EquivalencyCertificate();
					equivalencyCertificate.setEquivalencyRequestId(equivalencyRequestId);
					equivalencyCertificate.setFileEntryId(fileEntry.getFileEntryId());
					equivalencyCertificate.setFileName(fileEntry.getFileName());
					appealUtil.addCertificateToEquivalencyCetrificateTable(themeDisplay, equivalencyCertificate);
				}
			
			} 
		} catch (Exception e) {
			logger.error("exception while calling the workflow :: ", e);
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
				logger.info("exception while getting the list type item", e);
			}
		}
		return null;
	}
	
	private void updatedecisionLevel(long equivalencyDecisionLevelId, ThemeDisplay themeDisplay, String comments, long equivalencyLevel ) {
		logger.info("equivalencyDecisionLevelId  update method calling  "+equivalencyDecisionLevelId);
		String url = themeDisplay.getPortalURL()+ AppealConstants.DECISION_LEVEL_URL + equivalencyDecisionLevelId;
		logger.info("updatedecisionLevel url"+url);
		JSONObject levelObject = JSONFactoryUtil.createJSONObject();
		ListTypeEntry entry = ListTypeEntryLocalServiceUtil.fetchListTypeEntry(equivalencyLevel);
		if (Validator.isNotNull(entry)) {
			levelObject.put("name", entry.getName(themeDisplay.getLocale()));
			levelObject.put("key", entry.getKey());
		}
		JSONObject decisionLevelobject = JSONFactoryUtil.createJSONObject();
		decisionLevelobject.put("comments", comments);
		decisionLevelobject.put("equivalencyLevelId", levelObject);
		 omsbHttpConnector.executePut(url, decisionLevelobject.toString(), headerUtil.getHeaders());
	}
	
	
	@Reference(unbind = "-")
	private OMSBHttpConnector omsbHttpConnector;
	
	@Reference(unbind = "-")
	private HeaderUtil headerUtil;

	@Reference(unbind = "-")
	private AppealUtil appealUtil;

	private static final Log logger = LogFactoryUtil.getLog(SaveEquivalencyResponse.class);

}
