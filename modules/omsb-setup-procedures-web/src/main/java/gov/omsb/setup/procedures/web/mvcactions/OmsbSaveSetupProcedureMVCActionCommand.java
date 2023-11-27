package gov.omsb.setup.procedures.web.mvcactions;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Objects;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.setup.procedures.web.constants.OmsbSetupProceduresWebPortletKeys;
import gov.omsb.setup.procedures.web.portlet.util.OmsbSetupProcedureUtil;
import gov.omsb.tms.model.ProcedurePgProgdurationRel;
import gov.omsb.tms.model.ProceduregroupProgdurationRel;
import gov.omsb.tms.model.ProgdurationRotationTlPgProcedurePtRel;
import gov.omsb.tms.service.ProcedurePgProgdurationRelLocalService;
import gov.omsb.tms.service.ProceduregroupProgdurationRelLocalService;
import gov.omsb.tms.service.ProgdurationRotationTlPgProcedurePtRelLocalService;

/**
 * 
 * @author Aditya Meghnathi
 *
 */
@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbSetupProceduresWebPortletKeys.OMSBSETUPPROCEDURESWEB, "mvc.command.name="
				+ OmsbSetupProceduresWebPortletKeys.SAVE_SETUP_PROCEDURE_MVC_COMMAND_NAME }, service = MVCActionCommand.class)
public class OmsbSaveSetupProcedureMVCActionCommand extends BaseMVCActionCommand {

	@SuppressWarnings("deprecation")
	@Override
	public void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		_logger.info("OmsbSaveSetupProcedureMVCActionCommand ProcessAction Invoked ::: ");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long masterId = ParamUtil.getLong(actionRequest,
				OmsbSetupProceduresWebPortletKeys.PROGDURATION_TS_ROTATION_TL_PG_PROCEDURE_PT_REL_ID,
				GetterUtil.DEFAULT_LONG);
		try {
			if (masterId != GetterUtil.DEFAULT_LONG) {
				// Update Setup Procedure
				updateSetProcedure(actionRequest, masterId, themeDisplay);
			} else {
				// Create Setup Procedure
				createSetProcedure(actionRequest, themeDisplay);
			}
		} catch (PortalException e) {
			_logger.error(e);
			setErrorMessage(actionRequest, e.getLocalizedMessage());
		}

		PortletURL renderUrl = PortletURLFactoryUtil.create(actionRequest, themeDisplay.getPortletDisplay().getId(),
				themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
		renderUrl.setWindowState(WindowState.NORMAL);
		renderUrl.setPortletMode(PortletMode.VIEW);
		renderUrl.setParameter(OmsbSetupProceduresWebPortletKeys.MVC_COMMAND_NAME, StringPool.FORWARD_SLASH);
		renderUrl.setParameter(OmsbSetupProceduresWebPortletKeys.MASTER_VALUE,
				OmsbSetupProceduresWebPortletKeys.PROCEDURES);
		actionResponse.sendRedirect(renderUrl.toString());

		_logger.info("ProcessAction Exit ::: ");
	}

	/**
	 * 
	 * @param actionRequest
	 * @param masterId
	 * @param themeDisplay
	 * @return
	 * @throws PortalException
	 */
	private void updateSetProcedure(ActionRequest actionRequest, long masterId, ThemeDisplay themeDisplay)
			throws PortalException {

		ProgdurationRotationTlPgProcedurePtRel progdurationRotationTlPgProcedurePtRel = progdurationRotationTlPgProcedurePtRelLocalService
				.getProgdurationRotationTlPgProcedurePtRel(masterId);

		long procedureGroupId = ParamUtil.getLong(actionRequest, OmsbSetupProceduresWebPortletKeys.PROCEDURE_GROUP,
				GetterUtil.DEFAULT_LONG);
		long procedureId = ParamUtil.getLong(actionRequest, OmsbSetupProceduresWebPortletKeys.PROCEDURES,
				GetterUtil.DEFAULT_LONG);

		addProcedureAndProcedureGroupRelation(progdurationRotationTlPgProcedurePtRel.getProgramDurationId(),
				procedureGroupId, procedureId, themeDisplay);

		long[] rotationId = ParamUtil.getLongValues(actionRequest, OmsbSetupProceduresWebPortletKeys.ROTATION,
				new long[GetterUtil.DEFAULT_INTEGER]);

		long[] traineeLevelId = ParamUtil.getLongValues(actionRequest, OmsbSetupProceduresWebPortletKeys.TRAINEE_LEVEL,
				new long[GetterUtil.DEFAULT_INTEGER]);
		int[] minimumProcedures = ParamUtil.getIntegerValues(actionRequest,
				OmsbSetupProceduresWebPortletKeys.MINIMUM_PROCEDURES, new int[GetterUtil.DEFAULT_INTEGER]);

		for (int i = GetterUtil.DEFAULT_INTEGER; i < rotationId.length; i++) {
			ProgdurationRotationTlPgProcedurePtRel pgProcedurePtRel = progdurationRotationTlPgProcedurePtRelLocalService
					.findByProgramDurationIdAndProcedureGroupIdAndProcedureIdAndRotationId(
							progdurationRotationTlPgProcedurePtRel.getProgramDurationId(), procedureGroupId,
							procedureId, rotationId[i]);

			if (Validator.isNotNull(pgProcedurePtRel)) {
				progdurationRotationTlPgProcedurePtRel.setRotationId(rotationId[i]);
				progdurationRotationTlPgProcedurePtRel.setTraineeLevelId(traineeLevelId[i]);
				if (traineeLevelId[i] != 0) {
					progdurationRotationTlPgProcedurePtRel.setTraineelevelMinimumProcedures(minimumProcedures[i]);
					progdurationRotationTlPgProcedurePtRel.setMinimumProcedures(0);
				} else {
					progdurationRotationTlPgProcedurePtRel.setMinimumProcedures(minimumProcedures[i]);
					progdurationRotationTlPgProcedurePtRel.setTraineelevelMinimumProcedures(0);
				}
				progdurationRotationTlPgProcedurePtRel = OmsbSetupProcedureUtil.createSetupProcedureObject(
						actionRequest, progdurationRotationTlPgProcedurePtRel, themeDisplay);
				progdurationRotationTlPgProcedurePtRelLocalService
						.updateProgdurationRotationTlPgProcedurePtRel(progdurationRotationTlPgProcedurePtRel);
			} else {
				long newProgdurationRotationTlPgProcedurePtRelId = counterLocalService
						.increment(ProgdurationRotationTlPgProcedurePtRel.class.getName(), 1);
				pgProcedurePtRel = progdurationRotationTlPgProcedurePtRelLocalService
						.createProgdurationRotationTlPgProcedurePtRel(newProgdurationRotationTlPgProcedurePtRelId);
				pgProcedurePtRel.setRotationId(rotationId[i]);
				pgProcedurePtRel.setTraineeLevelId(traineeLevelId[i]);
				if (traineeLevelId[i] != 0) {
					pgProcedurePtRel.setTraineelevelMinimumProcedures(minimumProcedures[i]);
					pgProcedurePtRel.setMinimumProcedures(0);
				} else {
					pgProcedurePtRel.setMinimumProcedures(minimumProcedures[i]);
					pgProcedurePtRel.setTraineelevelMinimumProcedures(0);
				}
				pgProcedurePtRel = OmsbSetupProcedureUtil.createSetupProcedureObject(actionRequest, pgProcedurePtRel,
						themeDisplay);

				progdurationRotationTlPgProcedurePtRelLocalService
						.addProgdurationRotationTlPgProcedurePtRel(pgProcedurePtRel);
			}
		}
		setSucessesMessage(actionRequest, OmsbSetupProceduresWebPortletKeys.CONFIGURE_PROCEDURE_EDIT_SUCCESS);
	}

	/**
	 * 
	 * @param actionRequest
	 * @param themeDisplay
	 * @return
	 */
	private void createSetProcedure(ActionRequest actionRequest, ThemeDisplay themeDisplay) {
		String configureProcedureRotationJsonString = ParamUtil.get(actionRequest,
				OmsbSetupProceduresWebPortletKeys.CONFIGURE_PROCEDURE_ROTATION_JSON, StringPool.BLANK);
		try {
			if (!Objects.equals(configureProcedureRotationJsonString, StringPool.BLANK)) {
				JSONArray configureProcedureJsonArray = JSONFactoryUtil
						.createJSONArray(configureProcedureRotationJsonString);
				long programDurationId = ParamUtil.getLong(actionRequest,
						OmsbSetupProceduresWebPortletKeys.PROGRAM_DURATION_FOR_CONFIG, GetterUtil.DEFAULT_LONG);

				for (Object object : configureProcedureJsonArray) {
					JSONObject obj = JSONFactoryUtil.createJSONObject(object.toString());

					Integer procedureNum = (Integer) obj.get(OmsbSetupProceduresWebPortletKeys.JSON_OBJ_KEY_PROCEDURE);

					long procedureGroupId = ParamUtil.getLong(actionRequest,
							OmsbSetupProceduresWebPortletKeys.PROCEDURE_GROUP + StringPool.DASH + procedureNum,
							GetterUtil.DEFAULT_LONG);
					long procedureId = ParamUtil.getLong(actionRequest,
							OmsbSetupProceduresWebPortletKeys.PROCEDURES + StringPool.DASH + procedureNum,
							GetterUtil.DEFAULT_LONG);

					addProcedureAndProcedureGroupRelation(programDurationId, procedureGroupId, procedureId,
							themeDisplay);

					_logger.debug(
							"Object Procedures : " + obj.get(OmsbSetupProceduresWebPortletKeys.JSON_OBJ_KEY_ROTATIONS));
					_logger.debug(
							"Object Rotations : " + obj.get(OmsbSetupProceduresWebPortletKeys.JSON_OBJ_KEY_PROCEDURE));

					obj.get(OmsbSetupProceduresWebPortletKeys.JSON_OBJ_KEY_ROTATIONS);
					JSONArray rotationArray = (JSONArray) obj
							.get(OmsbSetupProceduresWebPortletKeys.JSON_OBJ_KEY_ROTATIONS);
					for (Object rotationNum : rotationArray) {
						Integer rotNum = (Integer) rotationNum;

						ProgdurationRotationTlPgProcedurePtRel progdurationRotationTlPgProcedurePtRel;

						long masterId = counterLocalService
								.increment(ProgdurationRotationTlPgProcedurePtRel.class.getName(), 1);
						progdurationRotationTlPgProcedurePtRel = progdurationRotationTlPgProcedurePtRelLocalService
								.createProgdurationRotationTlPgProcedurePtRel(masterId);
						progdurationRotationTlPgProcedurePtRel = OmsbSetupProcedureUtil.createSetupProcedureObject(
								actionRequest, progdurationRotationTlPgProcedurePtRel, procedureNum, rotNum,
								themeDisplay);

						progdurationRotationTlPgProcedurePtRelLocalService
								.addProgdurationRotationTlPgProcedurePtRel(progdurationRotationTlPgProcedurePtRel);
					}
					setSucessesMessage(actionRequest, OmsbSetupProceduresWebPortletKeys.CONFIGURE_PROCEDURE_SUCCESS);
				}
			}
			_logger.info("createSetProcedure ::: set Procedure Master Record Created");

		} catch (Exception e) {
			setErrorMessage(actionRequest, e.getLocalizedMessage());
			_logger.error(e);
		}
	}

	private void addProcedureAndProcedureGroupRelation(long programDurationId, long procedureGroupId, long procedureId,
			ThemeDisplay themeDisplay) {
		ProceduregroupProgdurationRel proceduregroupProgdurationRel = proceduregroupProgdurationRelLocalService
				.findByProgramDurationIdAndProcedureGroupMasterId(programDurationId, procedureGroupId);
		ProcedurePgProgdurationRel procedurePgProgdurationRel = procedurePgProgdurationRelLocalService
				.findByProgramDurationIdAndProcedureGroupMasterIdAndProcedureMasterId(programDurationId,
						procedureGroupId, procedureId);

		if (Validator.isNull(proceduregroupProgdurationRel)) {
			proceduregroupProgdurationRel = proceduregroupProgdurationRelLocalService
					.createProceduregroupProgdurationRel(
							counterLocalService.increment(ProceduregroupProgdurationRel.class.getName(), 1));
			proceduregroupProgdurationRel.setProcedureGroupMasterId(procedureGroupId);
			proceduregroupProgdurationRel.setProgramDurationId(programDurationId);
			proceduregroupProgdurationRel.setGroupId(themeDisplay.getScopeGroupId());
			proceduregroupProgdurationRel.setCreatedBy(themeDisplay.getUserId());
			proceduregroupProgdurationRel.setModifiedBy(themeDisplay.getUserId());
			proceduregroupProgdurationRelLocalService.addProceduregroupProgdurationRel(proceduregroupProgdurationRel);
			_logger.info("proceduregroupProgdurationRel added ::: ");

		}

		if (Validator.isNull(procedurePgProgdurationRel)) {
			procedurePgProgdurationRel = procedurePgProgdurationRelLocalService.createProcedurePgProgdurationRel(
					counterLocalService.increment(ProcedurePgProgdurationRel.class.getName(), 1));
			procedurePgProgdurationRel.setProcedureGroupMasterId(procedureGroupId);
			procedurePgProgdurationRel.setProcedureMasterId(procedureId);
			procedurePgProgdurationRel.setProgramDurationId(programDurationId);
			procedurePgProgdurationRel.setGroupId(themeDisplay.getScopeGroupId());
			procedurePgProgdurationRel.setCreatedBy(themeDisplay.getUserId());
			procedurePgProgdurationRel.setModifiedBy(themeDisplay.getUserId());
			procedurePgProgdurationRelLocalService.addProcedurePgProgdurationRel(procedurePgProgdurationRel);
			_logger.info("procedurePgProgdurationRel added ::: ");
		}
	}

	private void setErrorMessage(ActionRequest actionRequest, String message) {
		SessionErrors.add(actionRequest, message);
		hideDefaultErrorMessage(actionRequest);
	}

	private void setSucessesMessage(ActionRequest actionRequest, String message) {
		SessionMessages.add(actionRequest, message);
	}

	@Reference
	private ProgdurationRotationTlPgProcedurePtRelLocalService progdurationRotationTlPgProcedurePtRelLocalService;

	@Reference
	private CounterLocalService counterLocalService;

	@Reference
	private ProceduregroupProgdurationRelLocalService proceduregroupProgdurationRelLocalService;

	@Reference
	private ProcedurePgProgdurationRelLocalService procedurePgProgdurationRelLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbSaveSetupProcedureMVCActionCommand.class.getName());

}
