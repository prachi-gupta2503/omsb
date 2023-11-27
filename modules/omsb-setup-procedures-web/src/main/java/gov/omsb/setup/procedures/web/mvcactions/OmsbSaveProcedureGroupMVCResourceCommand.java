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
import gov.omsb.tms.model.ProcedureGroupMaster;
import gov.omsb.tms.model.ProceduregroupProgdurationRel;
import gov.omsb.tms.service.ProcedureGroupMasterLocalService;
import gov.omsb.tms.service.ProceduregroupProgdurationRelLocalService;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbSetupProceduresWebPortletKeys.OMSBSETUPPROCEDURESWEB,
		"mvc.command.name="+OmsbSetupProceduresWebPortletKeys.SAVE_PROCEDURE_GROUP_MVC_RESOURCE_COMMAND_NAME }, service = MVCResourceCommand.class)
public class OmsbSaveProcedureGroupMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long progDurationId = ParamUtil.getLong(resourceRequest, OmsbSetupProceduresWebPortletKeys.PROGRAM_DURATION_ID);
		String procedureGroupName = ParamUtil.getString(resourceRequest, OmsbSetupProceduresWebPortletKeys.PROCEDURE_GROUP_NAME);
		Map<Locale, String> procedureGroupNameMap;
		ObjectMapper objectMapper = new ObjectMapper();
		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		try {
			procedureGroupNameMap = objectMapper.readValue(procedureGroupName, new TypeReference<Map<Locale, String>>(){});
			ProcedureGroupMaster procedureGroupMaster = procedureGroupMasterLocalService.createProcedureGroupMaster(counterLocalService.increment(ProcedureGroupMaster.class.getName(), 1));
			procedureGroupMaster.setProcedureGroupNameMap(procedureGroupNameMap);
			procedureGroupMaster.setCreatedBy(themeDisplay.getUserId());
			procedureGroupMaster.setModifiedBy(themeDisplay.getUserId());
			procedureGroupMaster.setGroupId(themeDisplay.getScopeGroupId());
			procedureGroupMaster = procedureGroupMasterLocalService.addUpdateProcedureGroupMaster(procedureGroupMaster, new ArrayList<>(procedureGroupNameMap.values()), true);
			if(Validator.isNotNull(procedureGroupMaster)) {
				if(Validator.isNull(proceduregroupProgdurationRelLocalService.findByProgramDurationIdAndProcedureGroupMasterId(progDurationId, procedureGroupMaster.getProcedureGroupMasterId()))) {
					ProceduregroupProgdurationRel proceduregroupProgdurationRel = proceduregroupProgdurationRelLocalService.createProceduregroupProgdurationRel(counterLocalService.increment(ProceduregroupProgdurationRel.class.getName() ,1));
					proceduregroupProgdurationRel.setProcedureGroupMasterId(procedureGroupMaster.getProcedureGroupMasterId());
					proceduregroupProgdurationRel.setProgramDurationId(progDurationId);
					proceduregroupProgdurationRel.setGroupId(themeDisplay.getScopeGroupId());
					proceduregroupProgdurationRel.setCreatedBy(themeDisplay.getUserId());
					proceduregroupProgdurationRel.setModifiedBy(themeDisplay.getUserId());
					proceduregroupProgdurationRelLocalService.addProceduregroupProgdurationRel(proceduregroupProgdurationRel);
					resultJson.put(CommonConstants.SUCCESS, true);
					resultJson.put(OmsbSetupProceduresWebPortletKeys.PROCEDURE_GROUP_ID, procedureGroupMaster.getProcedureGroupMasterId());
					resultJson.put(OmsbSetupProceduresWebPortletKeys.PROCEDURE_GROUP_NAME, procedureGroupNameMap.get(themeDisplay.getLocale()));
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
		
	private static final Log _logger = LogFactoryUtil.getLog(OmsbSaveProcedureGroupMVCResourceCommand.class);

	@Reference
	private CounterLocalService counterLocalService;
	
	@Reference
	private ProcedureGroupMasterLocalService procedureGroupMasterLocalService;
	
	@Reference
	private ProceduregroupProgdurationRelLocalService proceduregroupProgdurationRelLocalService;
}
