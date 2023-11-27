package gov.omsb.setup.procedures.web.mvcactions;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.setup.procedures.web.constants.OmsbSetupProceduresWebPortletKeys;
import gov.omsb.tms.model.ProcedureMaster;
import gov.omsb.tms.service.ProcedureMasterLocalService;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbSetupProceduresWebPortletKeys.OMSBSETUPPROCEDURESWEB, "mvc.command.name="
				+ OmsbSetupProceduresWebPortletKeys.GET_PROCEDURE_MASTER_MVC_RESOURCE_COMMAND_NAME }, service = MVCResourceCommand.class)
public class OmsbSetupProcedureGetProceduresMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long procedureGroupId = ParamUtil.get(resourceRequest, OmsbSetupProceduresWebPortletKeys.PROCEDURE_GROUP,
				GetterUtil.DEFAULT_LONG);

		List<ProcedureMaster> procedureMasterList = procedureMasterLocalService
				.findByProcedureGroupMasterId(procedureGroupId);
		procedureMasterList = procedureMasterList.stream().sorted((first,second)->{
	        String objectFirst = first.getProcedureName(themeDisplay.getLocale()).toLowerCase();
	        String objectSecond = second.getProcedureName(themeDisplay.getLocale()).toLowerCase();
	        return objectFirst.compareTo(objectSecond);
		}).collect(Collectors.toList()); 
		JSONObject resultObject = createJsonObjectForProceduresDropDown(procedureMasterList, themeDisplay);
		resultObject.put(CommonConstants.SUCCESS, true);
		JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, resultObject);
	}

	private JSONObject createJsonObjectForProceduresDropDown(List<ProcedureMaster> procedureMasterList,
			ThemeDisplay themeDisplay) {
		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (ProcedureMaster procedureMaster : procedureMasterList) {
			JSONObject jsonObj = JSONFactoryUtil.createJSONObject();
			jsonObj.put(OmsbSetupProceduresWebPortletKeys.PROCEDURE_ID, procedureMaster.getProcedureMasterId());
			jsonObj.put(OmsbSetupProceduresWebPortletKeys.PROCEDURE_NAME,
					procedureMaster.getProcedureName(themeDisplay.getLocale()));
			jsonArray.put(jsonObj);
		}
		resultJson.put(OmsbSetupProceduresWebPortletKeys.PROGRAM_MASTER_DROPDOWN_LIST, jsonArray);
		return resultJson;
	}

	@Reference
	private ProcedureMasterLocalService procedureMasterLocalService;

	public static final Log _logger = LogFactoryUtil.getLog(OmsbSetupProcedureGetRolesMVCResourceCommand.class);
}
