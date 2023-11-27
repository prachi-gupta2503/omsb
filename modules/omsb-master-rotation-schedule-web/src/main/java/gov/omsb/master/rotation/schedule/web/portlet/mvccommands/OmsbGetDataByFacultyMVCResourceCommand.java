package gov.omsb.master.rotation.schedule.web.portlet.mvccommands;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.master.rotation.schedule.web.constants.OmsbMasterRotationScheduleWebPortletKeys;
import gov.omsb.master.rotation.schedule.web.portlet.dto.TrainingSiteByRotationsDeatilsDTO;
import gov.omsb.master.rotation.schedule.web.portlet.model.SaveFacultyMasterRotationScheduleDTO;
import gov.omsb.master.rotation.schedule.web.portlet.model.SaveFacultyMasterRotationScheduleDTO.FacultyDetail;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.custom.dto.RotationTraineeBlockRelationDTO;
import gov.omsb.tms.custom.dto.TrainingSiteByRotationsDTO;
import gov.omsb.tms.model.BlocksMetadataDetailsRel;
import gov.omsb.tms.model.FacultyRotationTsBlockDetailsRel;
import gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel;
import gov.omsb.tms.service.BlocksMetadataDetailsRelLocalService;
import gov.omsb.tms.service.FacultyRotationTsBlockDetailsRelLocalService;
import gov.omsb.tms.service.ProgdurationRotationTraineelevelBlocksRelLocalService;
import gov.omsb.tms.service.ProgdurationTraineelevelBlocksLevelTypeRelLocalService;
import gov.omsb.tms.service.TraineeRotationTsBlockDetailsRelLocalService;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbMasterRotationScheduleWebPortletKeys.OMSBMASTERROTATIONSCHEDULEWEB,
		"mvc.command.name="
				+ OmsbMasterRotationScheduleWebPortletKeys.GET_DATA_BY_FACULTY_MVC_RESOURCE_COMMAND}, service = MVCResourceCommand.class)
public class OmsbGetDataByFacultyMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
    protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
            throws Exception {
        _logger.info("ServeResource Invoked ::: ");

        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

        long programMasterId = ParamUtil.getLong(resourceRequest, OmsbTmsCommonConstants.PROGRAM_MASTER_ID);
        long progDurationTlBlocksLtId = ParamUtil.getLong(resourceRequest, OmsbTmsCommonConstants.PROGDURATION_TLBLOCKS_LT_ID);

        List<Long> programIdList = Collections.singletonList(programMasterId);
        List<BlocksMetadataDetailsRel> blocksMetadataDetailsRels = blocksMetadataDetailsRelLocalService.findByProgDurationTlBlocksLtId(progDurationTlBlocksLtId);
        ProgdurationTraineelevelBlocksLevelTypeRel rotationTsBlockDetailsReldata = progdurationTraineelevelBlocksLevelTypeRelLocalService.fetchProgdurationTraineelevelBlocksLevelTypeRel(progDurationTlBlocksLtId);
        List<TrainingSiteByRotationsDTO> siteByRotationsDTOs = traineeRotationTsBlockDetailsRelLocalService.getTrainingSiteByRotation(programIdList, themeDisplay.getLocale().toString(),rotationTsBlockDetailsReldata.getProgramDurationId());
		List<RotationTraineeBlockRelationDTO> rotationTraineeBlockRelationDTOs = rotationTraineelevelBlocksRelLocalService.getTraineeNoofBlocks(rotationTsBlockDetailsReldata.getProgramDurationId(), rotationTsBlockDetailsReldata.getTraineeLevelId(), themeDisplay.getLocale().toString());

		List<Long> rotationIds = rotationTraineeBlockRelationDTOs.stream().filter(obj -> obj.getNoOfBlocks() != 0).map(RotationTraineeBlockRelationDTO::getRotationId).collect(Collectors.toList());
		
		siteByRotationsDTOs = siteByRotationsDTOs.stream().filter(obj -> rotationIds.contains(obj.getRotationId())).collect(Collectors.toList());
        siteByRotationsDTOs = siteByRotationsDTOs.stream().filter(obj -> !obj.getProgCodeRsnSiteCode().equalsIgnoreCase("leave")).collect(Collectors.toList());
        List<SaveFacultyMasterRotationScheduleDTO> facultyMasterRotationScheduleDTOs = generateFacultyMasterRotationScheduleDTOs(blocksMetadataDetailsRels, siteByRotationsDTOs);
        _logger.debug("facultyMasterRotationScheduleDTOs"+facultyMasterRotationScheduleDTOs.toString());
        TrainingSiteByRotationsDeatilsDTO trainingSiteByRotationsDeatilsDTO = new TrainingSiteByRotationsDeatilsDTO();
        trainingSiteByRotationsDeatilsDTO.setTrainingSiteByRotationsDTOs(siteByRotationsDTOs);
        trainingSiteByRotationsDeatilsDTO.setBlocksMetadataDetailsRels(blocksMetadataDetailsRels);
        trainingSiteByRotationsDeatilsDTO.setSaveFacultyMasterRotationScheduleDTOs(facultyMasterRotationScheduleDTOs);

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        String json = mapper.writeValueAsString(trainingSiteByRotationsDeatilsDTO);
        resourceResponse.getWriter().write(json);

        _logger.info("ServeResource Exit ::: ");
    }

    private List<SaveFacultyMasterRotationScheduleDTO> generateFacultyMasterRotationScheduleDTOs(List<BlocksMetadataDetailsRel> blocksMetadataDetailsRels,
                                                                                                 List<TrainingSiteByRotationsDTO> siteByRotationsDTOs) {
        List<SaveFacultyMasterRotationScheduleDTO> facultyMasterRotationScheduleDTOs = new ArrayList<>();
        for (TrainingSiteByRotationsDTO trainingSiteByRotationsDTO : siteByRotationsDTOs) {
        	for (BlocksMetadataDetailsRel blocksMetadataDetailsRel : blocksMetadataDetailsRels) {
                SaveFacultyMasterRotationScheduleDTO facultyMasterRotationScheduleDTO = createFacultyMasterRotationScheduleDTO(blocksMetadataDetailsRel, trainingSiteByRotationsDTO);
                facultyMasterRotationScheduleDTOs.add(facultyMasterRotationScheduleDTO);
            }
        }
        return facultyMasterRotationScheduleDTOs;
    }

    private SaveFacultyMasterRotationScheduleDTO createFacultyMasterRotationScheduleDTO(BlocksMetadataDetailsRel blocksMetadataDetailsRel,
                                                                                         TrainingSiteByRotationsDTO trainingSiteByRotationsDTO) {
        SaveFacultyMasterRotationScheduleDTO facultyMasterRotationScheduleDTO = new SaveFacultyMasterRotationScheduleDTO();
        List<FacultyDetail> facultyDetails = new ArrayList<>();

        List<FacultyRotationTsBlockDetailsRel> facultyRotationTsBlockDetailsRels = facultyRotationTsBlockDetailsRelLocalService.findByBlocksMetadataDetailsRelIdAndProgDurationRotationTsRelId(blocksMetadataDetailsRel.getBlocksMetadataDetailsRelId(), trainingSiteByRotationsDTO.getProgDurationRotationTsRelId());

        for (FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel : facultyRotationTsBlockDetailsRels) {
            FacultyDetail facultyDetail = createFacultyDetail(facultyRotationTsBlockDetailsRel);
            facultyDetails.add(facultyDetail);
        }

        facultyMasterRotationScheduleDTO.setFacultyDetails(facultyDetails);
        facultyMasterRotationScheduleDTO.setBlockId(blocksMetadataDetailsRel.getBlocksMetadataDetailsRelId());
        facultyMasterRotationScheduleDTO.setRotationId(trainingSiteByRotationsDTO.getProgDurationRotationTsRelId());

        return facultyMasterRotationScheduleDTO;
    }

    private FacultyDetail createFacultyDetail(FacultyRotationTsBlockDetailsRel facultyRotationTsBlockDetailsRel) {
        FacultyDetail facultyDetail = new FacultyDetail();
        facultyDetail.setFacultyId(facultyRotationTsBlockDetailsRel.getFacultyId());

        try {
            User facultyUser = userLocalService.getUser(facultyRotationTsBlockDetailsRel.getFacultyId());
            facultyDetail.setFacultyName(facultyUser.getFullName());
        } catch (PortalException e) {
            _logger.error(e);
        }
        return facultyDetail;
    }
    
    @Reference
	private ProgdurationRotationTraineelevelBlocksRelLocalService rotationTraineelevelBlocksRelLocalService;
	
	@Reference
	private ProgdurationTraineelevelBlocksLevelTypeRelLocalService progdurationTraineelevelBlocksLevelTypeRelLocalService;

	@Reference
	private TraineeRotationTsBlockDetailsRelLocalService traineeRotationTsBlockDetailsRelLocalService;

	@Reference
    private BlocksMetadataDetailsRelLocalService blocksMetadataDetailsRelLocalService;

	@Reference
	private FacultyRotationTsBlockDetailsRelLocalService facultyRotationTsBlockDetailsRelLocalService;

	@Reference
	private UserLocalService userLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbGetDataByFacultyMVCResourceCommand.class);
}
