package gov.omsb.define.rotation.and.shared.rotations.web.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.dto.UserMetadata;
import gov.omsb.common.dto.UserMetadataItem;
import gov.omsb.common.service.util.UserMetadataUtil;
import gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel;
import gov.omsb.tms.model.ProgramDurationDetails;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.service.ProgdurationRotationTrainingsitesRelLocalService;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;

/**
 * @author Jayesh Goswami
 */
@Component(immediate = true, service = OmsbDefineRotationAndSharedRotationsUtil.class)
public class OmsbDefineRotationAndSharedRotationsUtil {

	public List<ProgramMaster> getLoggedInUsersProgram(ThemeDisplay themeDisplay) {
		_logger.info("getLoggedInUsersProgram Invoked ::: ");
		UserMetadataItem userMetadataItem = userMetadataUtil.getUserMetadataItemsByLrUserId(themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), themeDisplay.getUserId());
		List<Long> programMasterIds = new ArrayList<>();
		if(Validator.isNotNull(userMetadataItem) && Validator.isNotNull(userMetadataItem.getItems())) {
			programMasterIds = (userMetadataItem.getItems()).stream().map(UserMetadata::getProgramId).collect(Collectors.toList());
		}
		_logger.info("getLoggedInUsersProgram Exit ::: ");
		return programMasterLocalService.findByProgramMasterId(programMasterIds);
	}
	
	public List<ProgramDurationDetails> getProgramDurationDetailsByPrograms(List<ProgramMaster> programMasters) {
		List<ProgramDurationDetails> programDurationDetails = new ArrayList<>();
		for (ProgramMaster programMaster : programMasters) {
			programDurationDetails.addAll(programDurationDetailsLocalService.findProgramDurationByProgramId(programMaster.getProgramMasterId()));
		}
		return programDurationDetails;
	}

	public List<ProgdurationRotationTrainingsitesRel> getProgdurationRotationTrainingsitesRelByProgramDurations(List<ProgramDurationDetails> programDurationDetails) {
		List<ProgdurationRotationTrainingsitesRel> progdurationRotationTrainingsitesRels = new ArrayList<>();
		for (ProgramDurationDetails programDurationDetail : programDurationDetails) {
			progdurationRotationTrainingsitesRels.addAll(progdurationRotationTrainingsitesRelLocalService.findByProgramDurationId(programDurationDetail.getProgDurationId()));
		}
		return progdurationRotationTrainingsitesRels;
	}

	@Reference(unbind = "_")
	private UserMetadataUtil userMetadataUtil;
	
	@Reference(unbind = "_")
	private ProgramMasterLocalService programMasterLocalService;

	@Reference(unbind = "_")
	private ProgramDurationDetailsLocalService programDurationDetailsLocalService;

	@Reference(unbind = "_")
	private ProgdurationRotationTrainingsitesRelLocalService progdurationRotationTrainingsitesRelLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbDefineRotationAndSharedRotationsUtil.class.getName());

}
