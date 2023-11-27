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
import gov.omsb.tms.model.VisitTypeMaster;
import gov.omsb.tms.model.VisitTypeProgDurationRel;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;
import gov.omsb.tms.service.VisitTypeMasterLocalService;
import gov.omsb.tms.service.VisitTypeProgDurationRelLocalService;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbSetupProceduresWebPortletKeys.OMSBSETUPPROCEDURESWEB, "mvc.command.name="
				+ OmsbSetupProceduresWebPortletKeys.GET_VISIT_TYPE_MVC_RESOURCE_COMMAND_NAME }, service = MVCResourceCommand.class)

public class OmsbSetupProcedureGetVisitTypesMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		_logger.info("OmsbSetupProcedureGetVisitTypesMVCResourceCommand :: Invoked");

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long programDurationId = ParamUtil.get(resourceRequest, OmsbSetupProceduresWebPortletKeys.PROGRAM_DURATION,
				GetterUtil.DEFAULT_LONG);

		String programNameCohortMap = genrateProgramNameAndCohortString(programDurationId, themeDisplay.getLocale());

		List<VisitTypeProgDurationRel> visitTypeProgDurationRels = visitTypeProgDurationRelLocalService
				.findByProgramDurationId(programDurationId).stream()
				.sorted(Comparator.comparing(VisitTypeProgDurationRel::getModifiedDate).reversed())
				.collect(Collectors.toList());

		Map<Long, String> visitTypeMapping = visitTypeProgDurationRelLocalService.getOtherVisitTypesFromVisitMaster(
				programDurationId, OmsbTmsCommonConstants.VISIT_TYPE_NAME, themeDisplay.getLanguageId());
		visitTypeMapping = OmsbSetupProcedureUtil.sortMapByValues(visitTypeMapping);

		JSONObject resultJson = createJsonObjectForVistTypesDropDown(visitTypeMapping);
		resultJson.put(OmsbSetupProceduresWebPortletKeys.VISIT_TYPE_TABLE_LIST, createJsonObjectForVistTypes(
				visitTypeProgDurationRels, programNameCohortMap, themeDisplay, resourceRequest));
		resultJson.put(CommonConstants.SUCCESS, true);

		JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, resultJson);
		_logger.info("OmsbSetupProcedureGetVisitTypesMVCResourceCommand :: Exit");
	}

	private JSONObject createJsonObjectForVistTypesDropDown(Map<Long, String> visitTypeMapping) {
		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (Entry<Long, String> visitType : visitTypeMapping.entrySet()) {
			JSONObject jsonObj = JSONFactoryUtil.createJSONObject();
			jsonObj.put(OmsbSetupProceduresWebPortletKeys.VISIT_TYPE_ID, visitType.getKey());
			jsonObj.put(OmsbSetupProceduresWebPortletKeys.VISIT_TYPE_NAME, visitType.getValue());
			jsonArray.put(jsonObj);
		}
		resultJson.put(OmsbSetupProceduresWebPortletKeys.VISIT_TYPE_DROPDOWN_LIST, jsonArray);
		return resultJson;
	}

	@SuppressWarnings("deprecation")
	private JSONObject createJsonObjectForVistTypes(List<VisitTypeProgDurationRel> visitTypeProgDurationRels,
			String programNameCohortMap, ThemeDisplay themeDisplay, ResourceRequest resourceRequest) {
		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (VisitTypeProgDurationRel visitTypeProgDurationRel : visitTypeProgDurationRels) {
			JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

			VisitTypeMaster visitTypeMaster;
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(OmsbSetupProceduresWebPortletKeys.DATE_FORMAT_DD_MM_YYYY);
				visitTypeMaster = visitTypeMasterLocalService
						.getVisitTypeMaster(visitTypeProgDurationRel.getVisitTypeMasterId());
				jsonObj.put(OmsbSetupProceduresWebPortletKeys.VISIT_TYPE_PROG_DURATION_REL_ID,
						visitTypeProgDurationRel.getVisitTypeProgDurationRelId());
				jsonObj.put(OmsbSetupProceduresWebPortletKeys.VISIT_TYPE_ID, visitTypeMaster.getVisitTypeMasterId());
				jsonObj.put(OmsbSetupProceduresWebPortletKeys.VISIT_TYPE_NAME,
						visitTypeMaster.getVisitTypeName(themeDisplay.getLocale()));
				jsonObj.put(OmsbSetupProceduresWebPortletKeys.PROGRAM_NAME_COHORT, programNameCohortMap);
				jsonObj.put(OmsbSetupProceduresWebPortletKeys.CREATE_DATE,
						sdf.format(visitTypeProgDurationRel.getCreateDate()));
				jsonObj.put(OmsbSetupProceduresWebPortletKeys.MODIFIED_DATE,
						sdf.format(visitTypeProgDurationRel.getModifiedDate()));
				jsonObj.put(OmsbSetupProceduresWebPortletKeys.MODIFIED_BY,
						userLocalService.getUser(visitTypeProgDurationRel.getModifiedBy()).getFullName());

				PortletURL renderUrl = PortletURLFactoryUtil.create(resourceRequest,
						themeDisplay.getPortletDisplay().getId(), themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
				renderUrl.setWindowState(WindowState.NORMAL);
				renderUrl.setPortletMode(PortletMode.VIEW);
				renderUrl.setParameter("mvcRenderCommandName", "/edit-procedure-logging-parameters-form");
				renderUrl.setParameter("editProcedureName", OmsbSetupProceduresWebPortletKeys.SELECT_PROGRAM_FOR_VISIT);
				renderUrl.setParameter("procedureTypeProgDurationRelId",
						String.valueOf(visitTypeProgDurationRel.getVisitTypeProgDurationRelId()));
				renderUrl.setParameter("procedureTypeProgDurationRelName",
						visitTypeMaster.getVisitTypeName(themeDisplay.getLocale()));

				jsonObj.put(OmsbSetupProceduresWebPortletKeys.EDIT_URL, renderUrl.toString());
				jsonArray.put(jsonObj);
			} catch (PortalException | WindowStateException | PortletModeException e) {
				_logger.error(e);
			}
		}
		resultJson.put(OmsbSetupProceduresWebPortletKeys.VISIT_TYPE_MAPPING, jsonArray);
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
	private VisitTypeMasterLocalService visitTypeMasterLocalService;

	@Reference
	private VisitTypeProgDurationRelLocalService visitTypeProgDurationRelLocalService;

	@Reference
	private UserLocalService userLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbSetupProcedureGetVisitTypesMVCResourceCommand.class);

}
