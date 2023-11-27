package gov.omsb.programs.web.mvccommands;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.programs.web.constants.OmsbProgramConstants;
import gov.omsb.programs.web.constants.OmsbProgramsWebPortletKeys;
import gov.omsb.tms.model.ProgdurationRotationTraineelevelBlocksRel;
import gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel;
import gov.omsb.tms.service.ProgdurationRotationTraineelevelBlocksRelLocalService;
import gov.omsb.tms.service.ProgdurationRotationTrainingsitesRelLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbProgramsWebPortletKeys.OMSBPROGRAMSWEB,
		"mvc.command.name=/delete/rotation-from-program-cohort" }, service = MVCResourceCommand.class)
public class OmsbDeleteRotationFromProgramCohortMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		_logger.info("doServeResource Invoked ::: ");

		long rotationMasterId = ParamUtil.getLong(resourceRequest, "rotationMasterId", 0l);
		long programCohortId = ParamUtil.getLong(resourceRequest, OmsbProgramConstants.PROG_DURARION_ID, 0l);
		
		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		resultJson.put(CommonConstants.SUCCESS, true);
		
		try {
			List<ProgdurationRotationTraineelevelBlocksRel>  progdurationRotationTraineelevelBlocksRels = progdurationRotationTraineelevelBlocksRelLocalService.findByProgramDurationIdAndRotationId(programCohortId,rotationMasterId);
			_logger.debug("doServeResource progdurationRotationTraineelevelBlocksRels Size : " + progdurationRotationTraineelevelBlocksRels.size());
			
			for(ProgdurationRotationTraineelevelBlocksRel  progdurationRotationTraineelevelBlocksRel : progdurationRotationTraineelevelBlocksRels) {
				ProgdurationRotationTraineelevelBlocksRel  blocksRel = progdurationRotationTraineelevelBlocksRelLocalService.deleteProgdurationRotationTraineelevelBlocksRel(progdurationRotationTraineelevelBlocksRel.getProgdurationRotationTlBlocksRelId());
				_logger.debug("doServeResource ProgdurationRotationTraineelevelBlocksRel Id: " + progdurationRotationTraineelevelBlocksRel.getProgdurationRotationTlBlocksRelId() + " Deleted");
				
				if(Validator.isNull(blocksRel)) {
					resultJson.put(CommonConstants.SUCCESS, false);
				}
			}
			Boolean isSharedRotation = true;
			List<ProgdurationRotationTrainingsitesRel> progdurationRotationTrainingsitesRels = progdurationRotationTrainingsitesRelLocalService.findByProgramDurationIdAndRotationIdAndIsSharedRotation(programCohortId, rotationMasterId, isSharedRotation);
			for(ProgdurationRotationTrainingsitesRel progdurationRotationTrainingsitesRel : progdurationRotationTrainingsitesRels) {
				progdurationRotationTrainingsitesRelLocalService.deleteProgdurationRotationTrainingsitesRel(progdurationRotationTrainingsitesRel);
			}
		} catch(Exception e) {
			_logger.error(e);
		}
		JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, resultJson);
		_logger.info("doServeResource Exit ::: ");
	}
	
	@Reference
	private ProgdurationRotationTraineelevelBlocksRelLocalService progdurationRotationTraineelevelBlocksRelLocalService;
	
	@Reference
	private ProgdurationRotationTrainingsitesRelLocalService progdurationRotationTrainingsitesRelLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbDeleteRotationFromProgramCohortMVCResourceCommand.class.getName());
}

