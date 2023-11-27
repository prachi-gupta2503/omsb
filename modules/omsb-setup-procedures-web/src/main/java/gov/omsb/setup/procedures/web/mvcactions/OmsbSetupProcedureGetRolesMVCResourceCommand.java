package gov.omsb.setup.procedures.web.mvcactions;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.setup.procedures.web.constants.OmsbSetupProceduresWebPortletKeys;
import gov.omsb.setup.procedures.web.portlet.util.OmsbSetupProcedureUtil;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.model.ProgramDurationDetails;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.model.RoleTypeMaster;
import gov.omsb.tms.model.RoleTypeProgDurationRel;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;
import gov.omsb.tms.service.RoleTypeMasterLocalService;
import gov.omsb.tms.service.RoleTypeProgDurationRelLocalService;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbSetupProceduresWebPortletKeys.OMSBSETUPPROCEDURESWEB, "mvc.command.name="
				+ OmsbSetupProceduresWebPortletKeys.GET_ROLE_TYPE_MVC_RESOURCE_COMMAND_NAME }, service = MVCResourceCommand.class)
public class OmsbSetupProcedureGetRolesMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		_logger.info("OmsbRolesMVCResourceCommand doServeResource :::");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long programDurationId = ParamUtil.get(resourceRequest, OmsbSetupProceduresWebPortletKeys.PROGRAM_DURATION,
				GetterUtil.DEFAULT_LONG);

		String programNameCohortMap = genrateProgramNameAndCohortString(programDurationId, themeDisplay.getLocale());

		List<RoleTypeProgDurationRel> roleTypeProgDurationRels = roleTypeProgDurationRelLocalService
				.findByProgramDurationId(programDurationId).stream()
				.sorted(Comparator.comparing(RoleTypeProgDurationRel::getModifiedDate).reversed())
				.collect(Collectors.toList());

		Map<Long, String> roleTypeMapping = roleTypeProgDurationRelLocalService.getOtherRoleTypesFromRoleMaster(
				programDurationId, OmsbTmsCommonConstants.ROLE_TYPE_NAME, themeDisplay.getLanguageId());
		roleTypeMapping = OmsbSetupProcedureUtil.sortMapByValues(roleTypeMapping);

		JSONObject resultObject = createJsonObjectForRoleTypesDropDown(roleTypeMapping);
		resultObject.put(OmsbSetupProceduresWebPortletKeys.ROLE_TYPE_TABLE_LIST, createJsonObjectForRoleTypes(
				roleTypeProgDurationRels, programNameCohortMap, themeDisplay, resourceRequest));
		resultObject.put(CommonConstants.SUCCESS, true);
		JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, resultObject);

	}

	private JSONObject createJsonObjectForRoleTypesDropDown(Map<Long, String> roleTypeMapping) {
		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (Entry<Long, String> visitType : roleTypeMapping.entrySet()) {
			JSONObject jsonObj = JSONFactoryUtil.createJSONObject();
			jsonObj.put(OmsbSetupProceduresWebPortletKeys.ROLE_TYPE_ID, visitType.getKey());
			jsonObj.put(OmsbSetupProceduresWebPortletKeys.ROLE_TYPE_NAME, visitType.getValue());
			jsonArray.put(jsonObj);
		}
		resultJson.put(OmsbSetupProceduresWebPortletKeys.ROLE_TYPE_DROPDOWN_LIST, jsonArray);
		return resultJson;
	}

	@SuppressWarnings("deprecation")
	private JSONObject createJsonObjectForRoleTypes(List<RoleTypeProgDurationRel> roleTypeProgDurationRels,
			String programNameCohortMap, ThemeDisplay themeDisplay, ResourceRequest resourceRequest) {

		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (RoleTypeProgDurationRel roleTypeProgDurationRel : roleTypeProgDurationRels) {
			RoleTypeMaster roleTypeMaster;
			try {
				roleTypeMaster = roleTypeMasterLocalService
						.getRoleTypeMaster(roleTypeProgDurationRel.getRoleTypeMasterId());
				SimpleDateFormat sdf = new SimpleDateFormat(OmsbSetupProceduresWebPortletKeys.DATE_FORMAT_DD_MM_YYYY);
				JSONObject codesJson = JSONFactoryUtil.createJSONObject();
				codesJson.put(OmsbSetupProceduresWebPortletKeys.ROLE_TYPE_PROG_DURATION_REL_ID,
						roleTypeProgDurationRel.getRoleTypeProgDurationRelId());
				codesJson.put(OmsbSetupProceduresWebPortletKeys.ROLE_TYPE_ID, roleTypeMaster.getRoleTypeMasterId());
				codesJson.put(OmsbSetupProceduresWebPortletKeys.ROLE_TYPE_NAME,
						roleTypeMaster.getRoleTypeName(themeDisplay.getLocale()));
				codesJson.put(OmsbSetupProceduresWebPortletKeys.CREATE_DATE,
						sdf.format(roleTypeProgDurationRel.getCreateDate()));
				codesJson.put(OmsbSetupProceduresWebPortletKeys.MODIFIED_DATE,
						sdf.format(roleTypeProgDurationRel.getModifiedDate()));
				codesJson.put(OmsbSetupProceduresWebPortletKeys.MODIFIED_BY,
						userLocalService.getUser(roleTypeProgDurationRel.getModifiedBy()).getFullName());
				codesJson.put(OmsbSetupProceduresWebPortletKeys.PROGRAM_NAME_COHORT, programNameCohortMap);

				PortletURL renderUrl = PortletURLFactoryUtil.create(resourceRequest,
						themeDisplay.getPortletDisplay().getId(), themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
				renderUrl.setWindowState(WindowState.NORMAL);
				renderUrl.setPortletMode(PortletMode.VIEW);
				renderUrl.setParameter("mvcRenderCommandName", "/edit-procedure-logging-parameters-form");
				renderUrl.setParameter("editProcedureName", OmsbSetupProceduresWebPortletKeys.SELECT_PROGRAM_FOR_ROLE);
				renderUrl.setParameter("procedureTypeProgDurationRelId",
						String.valueOf(roleTypeProgDurationRel.getRoleTypeProgDurationRelId()));
				renderUrl.setParameter("procedureTypeProgDurationRelName",
						roleTypeMaster.getRoleTypeName(themeDisplay.getLocale()));
				codesJson.put(OmsbSetupProceduresWebPortletKeys.EDIT_URL, renderUrl.toString());

				jsonArray.put(codesJson);
			} catch (PortalException | WindowStateException | PortletModeException e) {
				_logger.error(e);
			}
		}
		resultJson.put(OmsbSetupProceduresWebPortletKeys.ROLE_TYPE_MAPPING, jsonArray);
		return resultJson;
	}

	private String genrateProgramNameAndCohortString(long programDurationId, Locale locale) {
		String programNameCohortMap = StringPool.BLANK;
		ProgramDurationDetails programDuration;
		try {
			programDuration = programDurationDetailsLocalService.getProgramDurationDetails(programDurationId);
			ProgramMaster programMaster = programMasterLocalService.getProgramMaster(programDuration.getProgramId());
			programNameCohortMap = programMaster.getProgramName(locale) + StringPool.SPACE + StringPool.OPEN_PARENTHESIS
					+ programDuration.getAyApplicableForm() + StringPool.CLOSE_PARENTHESIS;
		} catch (PortalException e) {
			_logger.error(e);
		}

		return programNameCohortMap;
	}

	@Reference
	private ProgramMasterLocalService programMasterLocalService;

	@Reference
	private ProgramDurationDetailsLocalService programDurationDetailsLocalService;

	@Reference
	private RoleTypeMasterLocalService roleTypeMasterLocalService;

	@Reference
	private RoleTypeProgDurationRelLocalService roleTypeProgDurationRelLocalService;

	@Reference
	private UserLocalService userLocalService;

	public static final Log _logger = LogFactoryUtil.getLog(OmsbSetupProcedureGetRolesMVCResourceCommand.class);
}
