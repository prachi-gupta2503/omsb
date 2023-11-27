package gov.omsb.trainee.elective.rotations.web.portlet;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.dto.UserMetadata;
import gov.omsb.common.service.util.UserMetadataUtil;
import gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel;
import gov.omsb.tms.model.ProgramDurationDetails;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.model.RotationMaster;
import gov.omsb.tms.model.TraineeAdmissionDetailsRel;
import gov.omsb.tms.model.TraineeElectiverotationPriorityDetails;
import gov.omsb.tms.model.TraineeLevelMaster;
import gov.omsb.tms.model.TraineeProgdurationTraineelevelDetails;
import gov.omsb.tms.service.ProgdurationTraineelevelBlocksLevelTypeRelLocalService;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;
import gov.omsb.tms.service.RotationMasterLocalService;
import gov.omsb.tms.service.TraineeAdmissionDetailsRelLocalService;
import gov.omsb.tms.service.TraineeElectiverotationPriorityDetailsLocalService;
import gov.omsb.tms.service.TraineeLevelMasterLocalService;
import gov.omsb.tms.service.TraineeProgdurationTraineelevelDetailsLocalService;
import gov.omsb.trainee.elective.rotations.web.constants.OmsbTraineeElectiveRotationsWebPortletKeys;
import gov.omsb.trainee.elective.rotations.web.portlet.model.TraineeElectiveRotation;

/**
 * @author Dhairya
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=OMSB",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=OmsbTraineeElectiveRotationsWeb", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template="
				+ OmsbTraineeElectiveRotationsWebPortletKeys.ADD_TRAINEE_ELECTIVE_ROTATIONS_JSP,
		"javax.portlet.name=" + OmsbTraineeElectiveRotationsWebPortletKeys.OMSBTRAINEEELECTIVEROTATIONSWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class OmsbTraineeElectiveRotationsWebPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
	        throws IOException, PortletException {

	    _logger.debug("render Invoked ::: ");

	    ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

	    long traineeId = themeDisplay.getUserId();
	    List<UserMetadata> userMetadataList = userMetadataUtil.getUserMetadataItemsByLrUserId(
	            themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), traineeId).getItems();

	    if (userMetadataList.isEmpty()) {
	        _logger.error("User metadata not found for userId: " + traineeId);
	        return;
	    }

	    UserMetadata userMetadata = userMetadataList.get(0);
	    long programId = userMetadata.getProgramId();
	    ProgramMaster programMaster = programMasterLocalService.fetchProgramMaster(programId);

	    if (Validator.isNull(programMaster)) {
	        _logger.error("ProgramMaster not found for programId: " + programId);
	        return;
	    }

	    String programName = programMaster.getProgramName(themeDisplay.getLocale());
	    _logger.debug("Program Name - " + programName);

	    List<TraineeElectiveRotation> traineeElectiveRotationsList = getTraineeElectiveRotations(traineeId, programName, themeDisplay.getLocale());
	    
	    renderRequest.setAttribute(OmsbTraineeElectiveRotationsWebPortletKeys.TRAINEE_ELECTIVE_ROTATIONS_LIST,
	            traineeElectiveRotationsList);
	    
	    renderRequest.setAttribute(OmsbTraineeElectiveRotationsWebPortletKeys.TRAINEE_LEVEL_MAP, getTraineeLevelsMap(programId, themeDisplay.getLocale()));
	    renderRequest.setAttribute(OmsbTraineeElectiveRotationsWebPortletKeys.PROGRAM_NAME, programName);

	    super.render(renderRequest, renderResponse);
	    _logger.debug("render Exit ::: ");
	}

	private List<TraineeElectiveRotation> getTraineeElectiveRotations(long traineeId, String programName, Locale currentLocale) {
	    List<TraineeElectiveRotation> traineeElectiveRotationsList = new ArrayList<>();
	    // Fetch traineeProgdurationTraineelevelDetails based on traineeId

	    List<TraineeProgdurationTraineelevelDetails> traineeProgdurationTraineelevelDetails =
	            traineeProgdurationTraineelevelDetailsLocalService.findByTraineeId(traineeId);

	    for (TraineeProgdurationTraineelevelDetails traineeProgdurationTraineelevelDetail : traineeProgdurationTraineelevelDetails) {
	        List<TraineeElectiverotationPriorityDetails> traineeElectiverotationPriorityDetails =
	                traineeElectiverotationPriorityDetailsLocalService.findByTraineePdTlErDetailsId(
	                        traineeProgdurationTraineelevelDetail.getTraineePdTlErDetailsId());

	        TraineeLevelMaster traineeLevelMaster = traineeLevelMasterLocalService
	                .fetchTraineeLevelMaster(traineeProgdurationTraineelevelDetail.getTraineeLevelId());
	        
	        TraineeAdmissionDetailsRel traineeAdmissionDetailsRel = traineeAdmissionDetailsRelLocalService.findByTraineeId(traineeId);

	        if (Validator.isNotNull(traineeLevelMaster)) {
	            TraineeElectiveRotation traineeElectiveRotation = new TraineeElectiveRotation();
	            traineeElectiveRotation.setTraineePdTlErDetailsId(traineeProgdurationTraineelevelDetail.getTraineePdTlErDetailsId());
	            traineeElectiveRotation.setElectiveRotation(getRotationNames(traineeElectiverotationPriorityDetails, currentLocale));
	            traineeElectiveRotation.setTraineeLevel(traineeLevelMaster.getTraineeLevelName(currentLocale));
	            if(Validator.isNotNull(traineeAdmissionDetailsRel)) {
	            	traineeElectiveRotation.setProgramStructure(programName + StringPool.BLANK + StringPool.OPEN_PARENTHESIS + traineeAdmissionDetailsRel.getAdmissionYear() + StringPool.CLOSE_PARENTHESIS);
	            }
	            traineeElectiveRotationsList.add(traineeElectiveRotation);
	        }
	    }

	    return traineeElectiveRotationsList;
	}

	private String getRotationNames(List<TraineeElectiverotationPriorityDetails> traineeElectiverotationPriorityDetails, Locale currentLocale) {
	    StringBuilder rotationNames = new StringBuilder();
	    for (int i = 0; i < traineeElectiverotationPriorityDetails.size(); i++) {
	        RotationMaster rotationMaster = rotationMasterLocalService
	                .fetchRotationMaster(traineeElectiverotationPriorityDetails.get(i).getRotationId());

	        if (Validator.isNotNull(rotationMaster)) {
	            if (i != 0) {
	                rotationNames.append(StringPool.COMMA);
	                rotationNames.append(StringPool.SPACE);
	            }
	            rotationNames.append(rotationMaster.getRotationName(currentLocale));
	        }
	    }
	    return rotationNames.toString();
	}

	private Map<Long, String> getTraineeLevelsMap(long programId, Locale currentLocale) {
	    Map<Long, String> traineeLevelsMap = new HashMap<>();

	    List<Long> programDurationIds = programDurationDetailsLocalService.findProgramDurationByProgramId(programId)
	            .stream().map(ProgramDurationDetails::getProgDurationId).collect(Collectors.toList());
	    List<Long> traineeLevelIds = new ArrayList<>();

	    for (Long programDurationId : programDurationIds) {
	        traineeLevelIds.addAll(progdurationTraineelevelBlocksLevelTypeRelLocalService
	                .findByProgramDurationId(programDurationId).stream()
	                .map(ProgdurationTraineelevelBlocksLevelTypeRel::getTraineeLevelId)
	                .collect(Collectors.toList()));
	    }

	    TraineeLevelMaster traineeLevelMaster;
	    for (Long traineeLevelId : traineeLevelIds) {
	        traineeLevelMaster = traineeLevelMasterLocalService.fetchTraineeLevelMaster(traineeLevelId);
	        if (Validator.isNotNull(traineeLevelMaster)) {
	            traineeLevelsMap.put(traineeLevelId,
	                    traineeLevelMaster.getTraineeLevelName(currentLocale));
	        }
	    }

	    _logger.debug("Trainee Level List - " + traineeLevelsMap.toString());
	    return traineeLevelsMap;
	}

	@Reference
	private UserMetadataUtil userMetadataUtil;

	@Reference
	private ProgramMasterLocalService programMasterLocalService;

	@Reference
	private ProgdurationTraineelevelBlocksLevelTypeRelLocalService progdurationTraineelevelBlocksLevelTypeRelLocalService;

	@Reference
	private TraineeLevelMasterLocalService traineeLevelMasterLocalService;
	
	@Reference
	private TraineeAdmissionDetailsRelLocalService traineeAdmissionDetailsRelLocalService;

	@Reference
	private ProgramDurationDetailsLocalService programDurationDetailsLocalService;

	@Reference
	private TraineeProgdurationTraineelevelDetailsLocalService traineeProgdurationTraineelevelDetailsLocalService;

	@Reference
	private TraineeElectiverotationPriorityDetailsLocalService traineeElectiverotationPriorityDetailsLocalService;

	@Reference
	private RotationMasterLocalService rotationMasterLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbTraineeElectiveRotationsWebPortlet.class);
}