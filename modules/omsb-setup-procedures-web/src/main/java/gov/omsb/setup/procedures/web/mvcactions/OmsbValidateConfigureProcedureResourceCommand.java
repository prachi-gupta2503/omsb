package gov.omsb.setup.procedures.web.mvcactions;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.setup.procedures.web.constants.OmsbSetupProceduresWebPortletKeys;
import gov.omsb.tms.model.ProgdurationRotationTlPgProcedurePtRel;
import gov.omsb.tms.service.ProcedurePgProgdurationRelLocalService;
import gov.omsb.tms.service.ProceduregroupProgdurationRelLocalService;
import gov.omsb.tms.service.ProgdurationRotationTlPgProcedurePtRelLocalService;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbSetupProceduresWebPortletKeys.OMSBSETUPPROCEDURESWEB,
		"mvc.command.name=/validateConfigureProcedure" }, service = MVCResourceCommand.class)
public class OmsbValidateConfigureProcedureResourceCommand extends BaseMVCResourceCommand {

	private static final Log _logger = LogFactoryUtil.getLog(OmsbValidateConfigureProcedureResourceCommand.class);

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		_logger.info("OmsbValidateConfigureProcedureResourceCommand Call ");

		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		String jsonData = ParamUtil.get(resourceRequest, "jsonData", StringPool.BLANK);

		boolean isError = false;

		if (!jsonData.equals(StringPool.BLANK)) {
			isError = handleUpdateSetupProcedure(jsonData, resourceRequest, resultJson);
		} else {
			isError = handleCreateSetupProcedure(resourceRequest, resultJson);
		}

		if (!isError) {
			resultJson.put(CommonConstants.SUCCESS, true);
		}
		JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, resultJson);
		_logger.info("Validate Resource Exit");
	}

	private boolean handleUpdateSetupProcedure(String jsonData, ResourceRequest resourceRequest, JSONObject resultJson) {

		// while update
		_logger.info(jsonData);

		boolean isError = false;
		Set<Long> set = new HashSet<>();

		try {
			long progdurationRotationTlPgProcedurePtRelId = ParamUtil.get(resourceRequest,
					OmsbSetupProceduresWebPortletKeys.PROGDURATION_TS_ROTATION_TL_PG_PROCEDURE_PT_REL_ID,
					GetterUtil.DEFAULT_INTEGER);
			JSONArray jsonArray = JSONFactoryUtil.createJSONArray(jsonData);

			for (Object object : jsonArray) {
				JSONObject obj = JSONFactoryUtil.createJSONObject(String.valueOf(object));
				ProgdurationRotationTlPgProcedurePtRel pgProcedurePtRel = progdurationRotationTlPgProcedurePtRelLocalService
						.findByProgramDurationIdAndProcedureGroupIdAndProcedureIdAndRotationId(
								obj.getLong(OmsbSetupProceduresWebPortletKeys.PROGRAM_DURATION_FOR_CONFIG),
								obj.getLong(OmsbSetupProceduresWebPortletKeys.PROCEDURE_GROUP_ID),
								obj.getLong(OmsbSetupProceduresWebPortletKeys.PROCEDURE_ID),
								obj.getLong(OmsbSetupProceduresWebPortletKeys.ROTATION));

				if (Validator.isNotNull(pgProcedurePtRel) && (pgProcedurePtRel
						.getProgdurationRotationTlPgProcedurePtRelId() != progdurationRotationTlPgProcedurePtRelId
						|| !set.add(obj.getLong(OmsbSetupProceduresWebPortletKeys.ROTATION)))) {
					resultJson.put(CommonConstants.SUCCESS, false);
					resultJson.put(OmsbSetupProceduresWebPortletKeys.HAS_DUPLICATE_DATA_ERROR, true);
					isError = true;
					break;
				}
			}
		} catch (Exception e) {
			resultJson.put(CommonConstants.SUCCESS, false);
			resultJson.put(OmsbSetupProceduresWebPortletKeys.ERROR, e.getLocalizedMessage());
			_logger.error(e);
		}

		return isError;
	}

	@SuppressWarnings("deprecation")
	public boolean handleCreateSetupProcedure(ResourceRequest resourceRequest, JSONObject resultJson) {
		
		// while create

		boolean isError = false;
		List<Long[]> idList = new ArrayList<>();
		Map<String, String[]> parameterMap = resourceRequest.getParameterMap();
		
		long programDurationId = Long
				.parseLong(parameterMap.get(OmsbSetupProceduresWebPortletKeys.PROGRAM_DURATION_FOR_CONFIG)[0]);

		String configureProcedureRotationJsonString = parameterMap
				.get(OmsbSetupProceduresWebPortletKeys.CONFIGURE_PROCEDURE_ROTATION_JSON)[0];

		try {
			JSONArray configureProcedureJsonArray = JSONFactoryUtil
					.createJSONArray(configureProcedureRotationJsonString);
			for (Object object : configureProcedureJsonArray) {
				JSONObject obj = JSONFactoryUtil.createJSONObject(object.toString());

				Integer procedureNum = (Integer) obj.get(OmsbSetupProceduresWebPortletKeys.JSON_OBJ_KEY_PROCEDURE);

				long procedureGroupId = Long.parseLong(parameterMap.get(
						OmsbSetupProceduresWebPortletKeys.PROCEDURE_GROUP + StringPool.DASH + procedureNum)[0]);
				long procedureId = Long.parseLong(parameterMap
						.get(OmsbSetupProceduresWebPortletKeys.PROCEDURES + StringPool.DASH + procedureNum)[0]);
				JSONArray rotationArray = (JSONArray) obj
						.get(OmsbSetupProceduresWebPortletKeys.JSON_OBJ_KEY_ROTATIONS);
				for (Object rotationNum : rotationArray) {
					Integer rotNum = (Integer) rotationNum;
					long rotationId = Long.parseLong(parameterMap.get(
							OmsbSetupProceduresWebPortletKeys.ROTATION + "-" + procedureNum + "-" + rotNum)[0]);

					Long[] ids = { programDurationId, procedureGroupId, procedureId, rotationId };
					ProgdurationRotationTlPgProcedurePtRel progdurationRotationTlPgProcedurePtRel = progdurationRotationTlPgProcedurePtRelLocalService
							.findByProgramDurationIdAndProcedureGroupIdAndProcedureIdAndRotationId(
									programDurationId, procedureGroupId, procedureId, rotationId);

					idList.add(ids);
					boolean isDuplicate = checkDuplicateIds(idList);
					if (Validator.isNotNull(progdurationRotationTlPgProcedurePtRel) || isDuplicate) {
						// relation Found
						resultJson.put(CommonConstants.SUCCESS, false);
						resultJson.put(OmsbSetupProceduresWebPortletKeys.HAS_DUPLICATE_DATA_ERROR, true);
						isError = true;
						break;
					}
				}
			}
		} catch (Exception e) {
			resultJson.put(CommonConstants.SUCCESS, false);
			resultJson.put(OmsbSetupProceduresWebPortletKeys.ERROR, e.getLocalizedMessage());
			_logger.error(e);
		}

		return isError;
	}

	private boolean checkDuplicateIds(List<Long[]> idList) {
		Set<List<Long>> set = new HashSet<>();
		for (Long[] array : idList) {
			List<Long> arrayList = new ArrayList<>(Arrays.asList(array));
			if (!set.add(arrayList)) {
				return true;
			}
		}
		return false;
	}

	@Reference
	private ProgdurationRotationTlPgProcedurePtRelLocalService progdurationRotationTlPgProcedurePtRelLocalService;

	@Reference
	private CounterLocalService counterLocalService;

	@Reference
	private ProceduregroupProgdurationRelLocalService proceduregroupProgdurationRelLocalService;

	@Reference
	private ProcedurePgProgdurationRelLocalService procedurePgProgdurationRelLocalService;

}
