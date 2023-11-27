package gov.omsb.raise.share.rotation.request.web.mvccommands;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.raise.share.rotation.request.web.constants.OmsbRaiseShareRotationRequestWebPortletKeys;
import gov.omsb.tms.model.ProgramDurationDetails;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbRaiseShareRotationRequestWebPortletKeys.OMSBRAISESHAREROTATIONREQUESTWEB,
		"mvc.command.name="
				+ OmsbRaiseShareRotationRequestWebPortletKeys.GET_RAISE_SHARE_ROTATION_REQUEST_PROGRAM_DURATION_MVC_RESOURCE_COMMAND }, service = MVCResourceCommand.class)
public class OmsbGetProgramDurationsRaiseShareRotationRequestMVCResourceCommand  extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		_logger.info("ServeResource Invoked ::: ");
		long programId = ParamUtil.get(resourceRequest, OmsbRaiseShareRotationRequestWebPortletKeys.PROGRAM_ID, 0);
		
		List<ProgramDurationDetails> programDurationDetailList = new ArrayList<>(programDurationDetailsLocalService.findProgramDurationByProgramId(programId));
		Collections.sort(programDurationDetailList, Comparator.comparing(ProgramDurationDetails::getAyApplicableForm));
		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		JSONArray programDurationMasterJSONArray = JSONFactoryUtil.createJSONArray();
		for (ProgramDurationDetails programDurationDetail  : programDurationDetailList) {
			JSONObject programJson = JSONFactoryUtil.createJSONObject();
			programJson.put(OmsbRaiseShareRotationRequestWebPortletKeys.PROGRAM_DURATION_ID, programDurationDetail.getProgDurationId());
			programJson.put(OmsbRaiseShareRotationRequestWebPortletKeys.AY_APPLICABLE_FORM, programDurationDetail.getAyApplicableForm());
			programDurationMasterJSONArray.put(programJson);
		}
		resultJson.put(CommonConstants.SUCCESS, true);
		resultJson.put(CommonConstants.RESULT, programDurationMasterJSONArray);
		JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, resultJson);
		_logger.info("ServeResource Exit ::: ");
	}

	@Reference
	private ProgramDurationDetailsLocalService programDurationDetailsLocalService;
	
	private static final Log _logger = LogFactoryUtil
			.getLog(OmsbGetProgramDurationsRaiseShareRotationRequestMVCResourceCommand.class);
}
