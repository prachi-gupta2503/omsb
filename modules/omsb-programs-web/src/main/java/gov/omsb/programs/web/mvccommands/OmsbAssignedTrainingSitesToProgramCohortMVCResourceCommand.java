package gov.omsb.programs.web.mvccommands;

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
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.util.CommonUtil;
import gov.omsb.programs.web.constants.OmsbProgramConstants;
import gov.omsb.programs.web.constants.OmsbProgramsWebPortletKeys;
import gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel;
import gov.omsb.tms.service.ProgdurationRotationTrainingsitesRelLocalService;
import gov.omsb.tms.service.TrainingSitesMasterLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbProgramsWebPortletKeys.OMSBPROGRAMSWEB,
		"mvc.command.name=" + OmsbProgramConstants.SAVE_ASSIGNED_TRAINING_SITES_TO_PROGRAM_COHORT_MVC_RESOURCE_COMMAND }, service = MVCResourceCommand.class)
public class OmsbAssignedTrainingSitesToProgramCohortMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		_logger.info("doServeResource Invoked ::: ");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long programCohortId = ParamUtil.getLong(resourceRequest, OmsbProgramConstants.PROGRAM_COHORT_ID, 0l);
		long[] selectedTrainingSites = ParamUtil.getLongValues(resourceRequest, OmsbProgramConstants.TRAINING_SITE_IDS_ARRAY);
		boolean isSuccess = true;
		
		_logger.debug("doServeResource ::: programCohortId ::: " + programCohortId);
		_logger.debug("doServeResource ::: selectedTrainingSites ::: " + selectedTrainingSites);
		
		/* Convert long array to array list */
		 List<Long> selectedTrainingSiteIdsList = new ArrayList<>();
		 if(selectedTrainingSites.length > 0) {
			 for(long id : selectedTrainingSites) {
				 selectedTrainingSiteIdsList.add(id);
			 }
		 }
		
		
		List<Long> existingTrainingSiteIds = getExistingTrainingSiteIdsByProgramCohort(programCohortId);
		CommonUtil.removeDuplicateIds(existingTrainingSiteIds);
		
		if(Validator.isNotNull(existingTrainingSiteIds) && !existingTrainingSiteIds.isEmpty()) {
			 List<Long> deleteTrainingSiteIds = existingTrainingSiteIds.stream().filter(id -> !selectedTrainingSiteIdsList.contains(id)).collect(Collectors.toList());
			
			 _logger.debug("doServeResource ::: deleteTrainingSiteIds ::: " + deleteTrainingSiteIds.toString());
			 isSuccess = deleteTrainingSitesByProgramCohortIdAndTrainingSiteIds(programCohortId, deleteTrainingSiteIds);
			 
		}
		
		 List<Long> addTrainingSites = selectedTrainingSiteIdsList.stream().filter(id -> !existingTrainingSiteIds.contains(id)).collect(Collectors.toList());
		 _logger.debug("doServeResource ::: addTrainingSites ::: " + addTrainingSites.toString());
		 if(Validator.isNotNull(addTrainingSites) && !addTrainingSites.isEmpty()) {
			 List<ProgdurationRotationTrainingsitesRel> progdurationRotationTrainingsitesRels = addTrainingSitesByProgramCohort(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), programCohortId, addTrainingSites);
			 if(Validator.isNull(progdurationRotationTrainingsitesRels) || progdurationRotationTrainingsitesRels.isEmpty()) {
				 isSuccess = false;
			 }
		 }
		
		JSONObject resultJson = prepareJsonResponse(isSuccess);
		JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, resultJson);
		_logger.info("doServeResource Exit ::: ");
	}
	
	private boolean deleteTrainingSitesByProgramCohortIdAndTrainingSiteIds(long programCohortId, List<Long> deleteTrainingSiteIds) {
		return progdurationRotationTrainingsitesRelLocalService.deleteTrainingSitesByProgramCohortIdAndTrainingSiteIds(programCohortId, deleteTrainingSiteIds);
	}
	
	private List<ProgdurationRotationTrainingsitesRel> addTrainingSitesByProgramCohort(long createdBy, long groupId, long programCohortId, List<Long> addTrainingSites) {
		return progdurationRotationTrainingsitesRelLocalService.addTrainingSitesByProgramCohort(createdBy, groupId, programCohortId, addTrainingSites);
	}
	
	private List<Long> getExistingTrainingSiteIdsByProgramCohort(long programDurationId){
		List<Long> existingTrainingSiteIds;
		List<ProgdurationRotationTrainingsitesRel> existingTrainingSites = progdurationRotationTrainingsitesRelLocalService.findByProgramDurationId(programDurationId);
		existingTrainingSiteIds = existingTrainingSites.stream().map(ProgdurationRotationTrainingsitesRel::getTrainingSitesId).collect(Collectors.toList());
		return existingTrainingSiteIds;
	}
	
	private JSONObject prepareJsonResponse(boolean isSuccess) {
		_logger.info("prepareJsonResponse Invoked ::: ");
		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		resultJson.put(CommonConstants.SUCCESS, isSuccess);
		
		_logger.info("prepareJsonResponse Exit ::: ");
		return resultJson;
	}
	
	@Reference
	private TrainingSitesMasterLocalService trainingSitesMasterLocalService;
	
	@Reference
	private ProgdurationRotationTrainingsitesRelLocalService progdurationRotationTrainingsitesRelLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbAssignedTrainingSitesToProgramCohortMVCResourceCommand.class.getName());
}