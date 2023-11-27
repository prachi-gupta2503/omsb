package gov.omsb.setup.procedures.web.mvcactions;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.setup.procedures.web.constants.OmsbSetupProceduresWebPortletKeys;
import gov.omsb.tms.model.ProcedureMaster;
import gov.omsb.tms.model.ProcedurePgProgdurationRel;
import gov.omsb.tms.service.ProcedureMasterLocalService;
import gov.omsb.tms.service.ProcedurePgProgdurationRelLocalService;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbSetupProceduresWebPortletKeys.OMSBSETUPPROCEDURESWEB, "mvc.command.name="
				+ OmsbSetupProceduresWebPortletKeys.SAVE_PROCEDURE_MVC_RESOURCE_COMMAND_NAME }, service = MVCResourceCommand.class)
public class OmsbSaveProcedureMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long progDurationId = ParamUtil.getLong(resourceRequest, OmsbSetupProceduresWebPortletKeys.PROGRAM_DURATION_ID);
		long procedureGroupId = ParamUtil.getLong(resourceRequest,
				OmsbSetupProceduresWebPortletKeys.PROCEDURE_GROUP_ID);
		String procedureName = ParamUtil.getString(resourceRequest, OmsbSetupProceduresWebPortletKeys.PROCEDURE_NAME);
		String cptCodes = ParamUtil.getString(resourceRequest, OmsbSetupProceduresWebPortletKeys.CPT_CODES);

		Map<Locale, String> procedureNameMap;
		Map<Locale, String> cptCodesMap = null;
		ObjectMapper objectMapper = new ObjectMapper();
		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		try {
			procedureNameMap = objectMapper.readValue(procedureName, new TypeReference<Map<Locale, String>>() {});
			if(!cptCodes.isBlank())
				cptCodesMap = objectMapper.readValue(cptCodes, new TypeReference<Map<Locale, String>>() {});
			ProcedureMaster procedureMaster = procedureMasterLocalService
					.createProcedureMaster(counterLocalService.increment(ProcedureMaster.class.getName(), 1));
			procedureMaster.setProcedureNameMap(procedureNameMap);
			procedureMaster.setProcedureGroupMasterId(procedureGroupId);
			procedureMaster.setCreatedBy(themeDisplay.getUserId());
			procedureMaster.setModifiedBy(themeDisplay.getUserId());
			procedureMaster.setGroupId(themeDisplay.getScopeGroupId());
			if (Validator.isNotNull(cptCodesMap))
				procedureMaster.setCptCodeMap(cptCodesMap);
			procedureMaster = procedureMasterLocalService.addUpdateProcedureMaster(procedureMaster,
					new ArrayList<>(procedureNameMap.values()), true);
			if (Validator.isNotNull(procedureMaster)) {
				if (Validator.isNull(procedurePgProgdurationRelLocalService
						.findByProgramDurationIdAndProcedureGroupMasterIdAndProcedureMasterId(progDurationId,
								procedureGroupId, procedureMaster.getProcedureMasterId()))) {
					ProcedurePgProgdurationRel procedurePgProgdurationRel = procedurePgProgdurationRelLocalService
							.createProcedurePgProgdurationRel(
									counterLocalService.increment(ProcedurePgProgdurationRel.class.getName(), 1));
					procedurePgProgdurationRel.setProcedureGroupMasterId(procedureGroupId);
					procedurePgProgdurationRel.setProcedureMasterId(procedureMaster.getProcedureMasterId());
					procedurePgProgdurationRel.setProgramDurationId(progDurationId);
					procedurePgProgdurationRel.setGroupId(themeDisplay.getScopeGroupId());
					procedurePgProgdurationRel.setCreatedBy(themeDisplay.getUserId());
					procedurePgProgdurationRel.setModifiedBy(themeDisplay.getUserId());
					procedurePgProgdurationRelLocalService.addProcedurePgProgdurationRel(procedurePgProgdurationRel);
					resultJson.put(CommonConstants.SUCCESS, true);
					resultJson.put(OmsbSetupProceduresWebPortletKeys.PROCEDURE_GROUP_ID, procedureGroupId);
					resultJson.put(OmsbSetupProceduresWebPortletKeys.PROCEDURE_ID,
							procedureMaster.getProcedureMasterId());
					resultJson.put(OmsbSetupProceduresWebPortletKeys.PROCEDURE_NAME,
							procedureNameMap.get(themeDisplay.getLocale()));
				}
			} else {
				resultJson.put(CommonConstants.SUCCESS, false);
				resultJson.put(OmsbSetupProceduresWebPortletKeys.HAS_NAME_ERROR, true);
			}
		} catch (Exception e) {
			_logger.error(e);
			resultJson.put(CommonConstants.SUCCESS, false);
		}
		JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, resultJson);
	}

	private static final Log _logger = LogFactoryUtil.getLog(OmsbSaveProcedureMVCResourceCommand.class);

	@Reference
	private CounterLocalService counterLocalService;

	@Reference
	private ProcedureMasterLocalService procedureMasterLocalService;

	@Reference
	private ProcedurePgProgdurationRelLocalService procedurePgProgdurationRelLocalService;
}
