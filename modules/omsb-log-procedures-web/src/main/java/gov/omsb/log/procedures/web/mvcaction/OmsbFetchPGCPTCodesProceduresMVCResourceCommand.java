package gov.omsb.log.procedures.web.mvcaction;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.log.procedures.web.constants.OmsbLogProceduresConstants;
import gov.omsb.log.procedures.web.constants.OmsbLogProceduresWebPortletKeys;
import gov.omsb.log.procedures.web.util.OmsbLogProceduresUtil;
import gov.omsb.tms.model.ProcedureGroupMaster;
import gov.omsb.tms.model.ProcedureMaster;
import gov.omsb.tms.service.ProcedureGroupMasterLocalService;
import gov.omsb.tms.service.ProcedureGroupProceduresCPTCodeRelLocalService;
import gov.omsb.tms.service.ProcedureMasterLocalService;
import gov.omsb.tms.service.ProcedurePgProgdurationRelLocalService;
import gov.omsb.tms.service.ProgdurationRotationTlPgProcedurePtRelLocalService;
import gov.omsb.tms.service.TraineeAdmissionDetailsRelLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbLogProceduresWebPortletKeys.OMSBLOGPROCEDURESWEB,
		"mvc.command.name="
				+ OmsbLogProceduresConstants.FETCH_PG_CPT_CODE_PROCEDURE_RESOURCE_COMMAND }, service = MVCResourceCommand.class)
public class OmsbFetchPGCPTCodesProceduresMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		JSONObject finalJSONObj = JSONFactoryUtil.createJSONObject();

		long id = ParamUtil.getLong(resourceRequest, OmsbLogProceduresConstants.ID);
		boolean isCptId = ParamUtil.getBoolean(resourceRequest, OmsbLogProceduresConstants.IS_CPT_ID);
		boolean isPgId = ParamUtil.getBoolean(resourceRequest, OmsbLogProceduresConstants.IS_PG_ID);
		boolean isProcedureId = ParamUtil.getBoolean(resourceRequest, OmsbLogProceduresConstants.IS_PROCEDURE_ID);

		if (isCptId || isProcedureId) {
			if (id != GetterUtil.DEFAULT_LONG) {
				ProcedureMaster procedureMaster = procedureMasterLocalService.fetchProcedureMaster(id);
				ProcedureGroupMaster procedureGroupMaster = null;
				if(Validator.isNotNull(procedureMaster) && Validator.isNotNull(procedureMaster.getProcedureGroupMasterId())) {
					procedureGroupMaster = procedureGroupMasterLocalService.fetchProcedureGroupMaster(procedureMaster.getProcedureGroupMasterId());
					finalJSONObj.put(OmsbLogProceduresConstants.ID, procedureGroupMaster.getProcedureGroupMasterId());
					finalJSONObj.put(OmsbLogProceduresConstants.NAME, procedureGroupMaster.getProcedureGroupName(themeDisplay.getLocale()));
				}
			}
		} else if (isPgId) {
			List<ProcedureMaster> procedureMasters = procedureMasterLocalService.findByProcedureGroupMasterId(id);
			Map<Long, String> cptCodeMasters = new LinkedHashMap<>();
			for (ProcedureMaster procedureMaster : procedureMasters) {
				if(Validator.isNotNull(procedureMaster.getCptCode())) {
					cptCodeMasters.put(procedureMaster.getProcedureMasterId(), procedureMaster.getCptCode(themeDisplay.getLocale()));
				}
			}
			finalJSONObj.put(OmsbLogProceduresConstants.CPT_CODE_MASTER_LIST, OmsbLogProceduresUtil.getCptCodesMastersJSON(cptCodeMasters));
			JSONArray procedureMasterJSON = OmsbLogProceduresUtil
					.getProcedureMastersJSON(procedureMasters, themeDisplay);
			finalJSONObj.put(OmsbLogProceduresConstants.PROCEDURE_MASTER_LIST, procedureMasterJSON);

		}
		log.debug("Selected Id :: " + id);

		resourceResponse.getWriter().write(finalJSONObj.toString());

	}

	@Reference
	ProgdurationRotationTlPgProcedurePtRelLocalService progdurationRotationTlPgProcedurePtRelLocalService;

	@Reference
	ProcedureGroupProceduresCPTCodeRelLocalService procedureGroupProceduresCPTCodeRelLocalService;

	@Reference
	ProcedureMasterLocalService procedureMasterLocalService;

	@Reference
	ProcedureGroupMasterLocalService procedureGroupMasterLocalService;

	@Reference
	TraineeAdmissionDetailsRelLocalService traineeAdmissionDetailsRelLocalService;
	
	@Reference
	ProcedurePgProgdurationRelLocalService procedurePgProgdurationRelLocalService;

	private Log log = LogFactoryUtil.getLog(OmsbFetchPGCPTCodesProceduresMVCResourceCommand.class.getName());
}