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
import gov.omsb.tms.model.PatientTypeMaster;
import gov.omsb.tms.model.PatientTypeProgDurationRel;
import gov.omsb.tms.model.ProgramDurationDetails;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.service.PatientTypeMasterLocalService;
import gov.omsb.tms.service.PatientTypeProgDurationRelLocalService;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbSetupProceduresWebPortletKeys.OMSBSETUPPROCEDURESWEB,
		"mvc.command.name=/getPatientTypeURL" }, service = MVCResourceCommand.class)
public class OmsbPatientTypeMVCResourceCommand extends BaseMVCResourceCommand {

	private static final Log _logger = LogFactoryUtil.getLog("OmsbPatientTypeMVCResourceCommand");

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		_logger.info("OmsbPatientTypeMVCResourceCommand :: Invoked");

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long programDurationId = ParamUtil.get(resourceRequest, OmsbSetupProceduresWebPortletKeys.PROGRAM_DURATION,
				GetterUtil.DEFAULT_LONG);

		String programNameCohortMap = genrateProgramNameAndCohortString(programDurationId, themeDisplay.getLocale());

		List<PatientTypeProgDurationRel> patientTypeProgDurationRels = patientTypeProgDurationRelLocalService
				.findByProgramDurationId(programDurationId).stream()
				.sorted(Comparator.comparing(PatientTypeProgDurationRel::getModifiedDate).reversed())
				.collect(Collectors.toList());

		Map<Long, String> patientTypeMapping = patientTypeProgDurationRelLocalService
				.getOtherPatientTypesFromPatientMaster(programDurationId, OmsbTmsCommonConstants.PATIENT_TYPE_NAME,
						themeDisplay.getLanguageId());
		patientTypeMapping = OmsbSetupProcedureUtil.sortMapByValues(patientTypeMapping);
		JSONObject resultJson = createJsonObjectForPatientTypesDropDown(patientTypeMapping);
		resultJson.put(OmsbSetupProceduresWebPortletKeys.PATIENT_TYPE_TABLE_LIST, createJsonObjectForPatientTypes(
				patientTypeProgDurationRels, programNameCohortMap, themeDisplay, resourceRequest));
		resultJson.put(CommonConstants.SUCCESS, true);

		JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, resultJson);

		_logger.info("OmsbPatientTypeMVCResourceCommand :: Exit");

	}

	private JSONObject createJsonObjectForPatientTypesDropDown(Map<Long, String> patientTypeMapping) {
		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (Entry<Long, String> patientType : patientTypeMapping.entrySet()) {
			JSONObject jsonObj = JSONFactoryUtil.createJSONObject();
			jsonObj.put(OmsbSetupProceduresWebPortletKeys.PATIENT_TYPE_ID, patientType.getKey());
			jsonObj.put(OmsbSetupProceduresWebPortletKeys.PATIENT_TYPE_NAME, patientType.getValue());
			jsonArray.put(jsonObj);
		}
		resultJson.put(OmsbSetupProceduresWebPortletKeys.PATIENT_TYPE_DROPDOWN_LIST, jsonArray);
		return resultJson;
	}

	@SuppressWarnings("deprecation")
	private JSONObject createJsonObjectForPatientTypes(List<PatientTypeProgDurationRel> patientTypeProgDurationRels,
			String programNameCohortMap, ThemeDisplay themeDisplay, ResourceRequest resourceRequest) {
		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (PatientTypeProgDurationRel patientTypeProgDurationRel : patientTypeProgDurationRels) {
			JSONObject jsonObj = JSONFactoryUtil.createJSONObject();

			PatientTypeMaster patientTypeMaster;
			try {
				patientTypeMaster = patientTypeMasterLocalService
						.getPatientTypeMaster(patientTypeProgDurationRel.getPatientTypeMasterId());
				SimpleDateFormat sdf = new SimpleDateFormat(OmsbSetupProceduresWebPortletKeys.DATE_FORMAT_DD_MM_YYYY);
				jsonObj.put(OmsbSetupProceduresWebPortletKeys.PATIENT_TYPE_PROG_DURATION_REL_NAME,
						patientTypeProgDurationRel.getPatientTypeProgDurationRelId());
				jsonObj.put(OmsbSetupProceduresWebPortletKeys.PATIENT_TYPE_ID,
						patientTypeMaster.getPatientTypeMasterId());
				jsonObj.put(OmsbSetupProceduresWebPortletKeys.PATIENT_TYPE_NAME,
						patientTypeMaster.getPatientTypeName(themeDisplay.getLocale()));
				jsonObj.put(OmsbSetupProceduresWebPortletKeys.PROGRAM_NAME_COHORT, programNameCohortMap);
				jsonObj.put(OmsbSetupProceduresWebPortletKeys.CREATE_DATE,
						sdf.format(patientTypeProgDurationRel.getCreateDate()));
				jsonObj.put(OmsbSetupProceduresWebPortletKeys.MODIFIED_DATE,
						sdf.format(patientTypeProgDurationRel.getModifiedDate()));
				jsonObj.put(OmsbSetupProceduresWebPortletKeys.MODIFIED_BY,
						userLocalService.getUser(patientTypeProgDurationRel.getModifiedBy()).getFullName());

				PortletURL renderUrl = PortletURLFactoryUtil.create(resourceRequest,
						themeDisplay.getPortletDisplay().getId(), themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
				renderUrl.setWindowState(WindowState.NORMAL);
				renderUrl.setPortletMode(PortletMode.VIEW);
				renderUrl.setParameter("mvcRenderCommandName", "/edit-procedure-logging-parameters-form");
				renderUrl.setParameter("editProcedureName",
						OmsbSetupProceduresWebPortletKeys.SELECT_PROGRAM_FOR_PATIENT);
				renderUrl.setParameter("procedureTypeProgDurationRelId",
						String.valueOf(patientTypeProgDurationRel.getPatientTypeProgDurationRelId()));
				renderUrl.setParameter("procedureTypeProgDurationRelName",
						patientTypeMaster.getPatientTypeName(themeDisplay.getLocale()));

				jsonObj.put(OmsbSetupProceduresWebPortletKeys.EDIT_URL, renderUrl.toString());
				jsonArray.put(jsonObj);
			} catch (PortalException | WindowStateException | PortletModeException e) {
				_logger.error(e);
			}
		}
		resultJson.put(OmsbSetupProceduresWebPortletKeys.PATIENT_TYPE_MAPPING, jsonArray);
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
	private PatientTypeMasterLocalService patientTypeMasterLocalService;

	@Reference
	private PatientTypeProgDurationRelLocalService patientTypeProgDurationRelLocalService;

	@Reference
	private UserLocalService userLocalService;

}
