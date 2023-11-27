package gov.omsb.raise.share.rotation.request.web.mvccommands;

import com.liferay.portal.kernel.json.JSONArray;
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

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.raise.share.rotation.request.web.constants.OmsbRaiseShareRotationRequestWebPortletKeys;
import gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.service.ProgdurationRotationTrainingsitesRelLocalService;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbRaiseShareRotationRequestWebPortletKeys.OMSBRAISESHAREROTATIONREQUESTWEB,
		"mvc.command.name="
				+ OmsbRaiseShareRotationRequestWebPortletKeys.GET_RAISE_SHARE_ROTATION_REQUEST_PROGRAM_MVC_RESOURCE_COMMAND }, service = MVCResourceCommand.class)
public class OmsbGetProgramsRaiseShareRotationRequestMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		_logger.info("ServeResource Invoked ::: ");

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long rotationId = ParamUtil.get(resourceRequest, OmsbRaiseShareRotationRequestWebPortletKeys.ROTAION_ID, 0);

		_logger.debug("doServeResource ::: rotationID ::: " + rotationId);
		Set<ProgramMaster> programMasterList = new HashSet<>();
		List<ProgdurationRotationTrainingsitesRel> progdurationRotationTrainingsitesRels = progdurationRotationTrainingsitesRelLocalService
				.findByRotationId(rotationId);
		_logger.debug("doServeResource ::: progdurationRotationTrainingsitesRels size ::: "
				+ progdurationRotationTrainingsitesRels.size());
		for (ProgdurationRotationTrainingsitesRel progdurationRotationTrainingsitesRel : progdurationRotationTrainingsitesRels) {
			_logger.debug("doServeResource ::: getRotationOwningProgramId ::: "
					+ progdurationRotationTrainingsitesRel.getRotationOwningProgramId());
			if (Validator.isNotNull(progdurationRotationTrainingsitesRel.getRotationOwningProgramId())
					&& progdurationRotationTrainingsitesRel.getRotationOwningProgramId() != 0) {
				programMasterList.add(programMasterLocalService
						.getProgramMaster(progdurationRotationTrainingsitesRel.getRotationOwningProgramId()));
			}
		}

		programMasterList = programMasterList.stream().sorted((first, second) -> {
			String programFirst = first.getProgramName(themeDisplay.getLocale()).toLowerCase();
			String programSecond = second.getProgramName(themeDisplay.getLocale()).toLowerCase();
			return programFirst.compareTo(programSecond);
		}).collect(Collectors.toSet());

		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		JSONArray programMasterJSONArray = JSONFactoryUtil.createJSONArray();
		for (ProgramMaster program : programMasterList) {
			JSONObject programJson = JSONFactoryUtil.createJSONObject();
			programJson.put(CommonConstants.PROGRAM_NAME, program.getProgramName(themeDisplay.getLocale()));
			programJson.put(CommonConstants.PROGRAM_MASTER_ID, program.getProgramMasterId());
			programMasterJSONArray.put(programJson);
		}

		resultJson.put(CommonConstants.SUCCESS, true);
		resultJson.put(CommonConstants.RESULT, programMasterJSONArray);
		JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, resultJson);
		_logger.info("ServeResource Exit ::: ");
	}

	@Reference
	private ProgramMasterLocalService programMasterLocalService;

	@Reference
	private ProgramDurationDetailsLocalService programDurationDetailsLocalService;

	@Reference
	private ProgdurationRotationTrainingsitesRelLocalService progdurationRotationTrainingsitesRelLocalService;

	private static final Log _logger = LogFactoryUtil
			.getLog(OmsbGetProgramsRaiseShareRotationRequestMVCResourceCommand.class);

}
