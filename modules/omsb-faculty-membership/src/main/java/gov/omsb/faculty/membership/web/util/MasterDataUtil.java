package gov.omsb.faculty.membership.web.util;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.tms.custom.dto.ProgramDTO;
import gov.omsb.tms.custom.dto.TrainingSiteByProgramDTO;
import gov.omsb.tms.model.FacultyRequestStatus;
import gov.omsb.tms.model.FacultyType;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.service.FacultyRequestStatusLocalService;
import gov.omsb.tms.service.FacultyTypeLocalService;
import gov.omsb.tms.service.ProgdurationRotationTrainingsitesRelLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;

@Component(immediate = true, service = MasterDataUtil.class)
public class MasterDataUtil {
	private static final Log LOGGER = LogFactoryUtil.getLog(MasterDataUtil.class.getName());

	public List<ProgramDTO> getProgramList(ThemeDisplay themeDisplay) {
		LOGGER.info("MasterDataUtil called--------");
		List<ProgramMaster> programMasterList = programMasterLocalService.getProgramMasters(QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);
		List<ProgramDTO> programDTOList = new ArrayList<>();
		for (ProgramMaster programMaster : programMasterList) {
			LOGGER.info("programMaster--" + programMaster.getProgramName());
			ProgramDTO programDTO = new ProgramDTO();
			programDTO.setProgramMasterId(programMaster.getProgramMasterId());
			programDTO.setProgramName(programMaster.getProgramName(themeDisplay.getLocale()));
			programDTO.setProgramCode(programMaster.getProgramCode(themeDisplay.getLocale()));
			programDTOList.add(programDTO);
		}
		return programDTOList;
	}

	public List<FacultyType> getFacultyType() {
		List<FacultyType> facultyTypeList = facultyTypeLocalService.getFacultyTypes(QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);
		return facultyTypeList;
	}

	public List<FacultyRequestStatus> getFacultyRequestSatatus() {
		List<FacultyRequestStatus> facultyRequestStatusList = facultyRequestStatusLocalService
				.getFacultyRequestStatuses(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		return facultyRequestStatusList;
	}

	private String generateScopeListURL(String userMetadataRequestsUrl, long siteId) {
		return omsbCommonApi.getBaseURL() + userMetadataRequestsUrl + "scopes/" + String.valueOf(siteId);
	}

	public List<TrainingSiteByProgramDTO> getTrainingSiteByProgram(long programId, String languageCode) {
		return progdurationRotationTSRelLocalService.getTrainingSiteDetailsByProgramMaster(programId, languageCode);
	}


	@Reference
	private ProgramMasterLocalService programMasterLocalService;

	@Reference
	private ProgdurationRotationTrainingsitesRelLocalService progdurationRotationTSRelLocalService;

	@Reference(unbind = "-")
	private RoleLocalService roleLocalService;

	@Reference(unbind = "-")
	private OMSBHttpConnector oMSBHttpConnector;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference(unbind = "-")
	private FacultyTypeLocalService facultyTypeLocalService;

	@Reference(unbind = "-")
	private FacultyRequestStatusLocalService facultyRequestStatusLocalService;

}
