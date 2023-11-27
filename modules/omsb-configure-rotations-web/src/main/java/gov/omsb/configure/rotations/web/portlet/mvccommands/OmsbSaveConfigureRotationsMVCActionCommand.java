package gov.omsb.configure.rotations.web.portlet.mvccommands;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.configure.rotations.web.constants.OmsbConfigureRotationsWebPortletKeys;
import gov.omsb.configure.rotations.web.dto.ValidateRotationDTO;
import gov.omsb.tms.custom.dto.ConfigureRotationEditDetailsDTO;
import gov.omsb.tms.model.ProgdurationRotationTraineelevelBlocksRel;
import gov.omsb.tms.service.ProgdurationRotationTraineelevelBlocksRelLocalService;

/**
 * @author Komal Gajera
 */
@Component(immediate = true, property = {"javax.portlet.name=" + OmsbConfigureRotationsWebPortletKeys.OMSBCONFIGUREROTATIONSWEB,
		"mvc.command.name="	+ OmsbConfigureRotationsWebPortletKeys.SAVE_CONFIGURE_ROTATIONS_MVC_ACTION_COMMAND }, service = MVCActionCommand.class)
public class OmsbSaveConfigureRotationsMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		_logger.info("ProcessAction Invoked ::: ");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long configureRotationCount = ParamUtil.getLong(actionRequest,
				OmsbConfigureRotationsWebPortletKeys.CONFIGURE_ROTATION_COUNT);
		long programDurationId = ParamUtil.getLong(actionRequest, OmsbConfigureRotationsWebPortletKeys.PROGRAM_DURATION,
				GetterUtil.DEFAULT_LONG);
		long traineeLevelId = ParamUtil.getLong(actionRequest, OmsbConfigureRotationsWebPortletKeys.TRAINEE_LEVEL,
				GetterUtil.DEFAULT_LONG);
		long programId = ParamUtil.getLong(actionRequest, OmsbConfigureRotationsWebPortletKeys.PROGRAM_MASTER_ID,
				GetterUtil.DEFAULT_LONG);
		List<ConfigureRotationEditDetailsDTO> rotationEditDetailsDTOs = progdurationRotationTraineelevelBlocksRelLocalService.getConfigureRotationDetailsByProgramAndDuration(
				programId, traineeLevelId, programDurationId);
		if(!rotationEditDetailsDTOs.isEmpty()) {
			 SessionErrors.add(actionRequest, OmsbConfigureRotationsWebPortletKeys.DUPLICATE_ENTRY_ERROR);
	    	 SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	         return false;
		}
		
		List<ValidateRotationDTO> rotationDTOs = new ArrayList<>();
		
		for (int i = 0; i <= configureRotationCount; i++) {
			ValidateRotationDTO dto= new ValidateRotationDTO();
			long rotationId = ParamUtil.getLong(actionRequest,
					OmsbConfigureRotationsWebPortletKeys.ROTATION + i, GetterUtil.DEFAULT_LONG);
			if(rotationId == 0) {
				continue;
			}
			long rotationType = ParamUtil.getLong(actionRequest,
					OmsbConfigureRotationsWebPortletKeys.ROTATIONTYPE + i,
					GetterUtil.DEFAULT_LONG);
			Integer noOfBlocks = (int) ParamUtil.getLong(actionRequest,
					OmsbConfigureRotationsWebPortletKeys.BLOCKS + i,
					GetterUtil.DEFAULT_INTEGER);
			
			dto.setRotationId(rotationId);
			dto.setRotationTypeId(rotationType);
			dto.setNoOfBlock(noOfBlocks);
			for (ValidateRotationDTO validateRotationDTO : rotationDTOs) {
				if(validateRotationDTO.equals(dto)) {
					 SessionErrors.add(actionRequest, OmsbConfigureRotationsWebPortletKeys.DUPLICATE_ROTATION_ERROR);
			    	 SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			         return false;
				}
			}
			rotationDTOs.add(dto);

		}
		for (ValidateRotationDTO validateRotationDTO : rotationDTOs) {
			long masterId = counterLocalService.increment(getClass().getName(), 1);
			ProgdurationRotationTraineelevelBlocksRel progdurationRotationTraineelevelBlocksRel = progdurationRotationTraineelevelBlocksRelLocalService
					.createProgdurationRotationTraineelevelBlocksRel(masterId);
			progdurationRotationTraineelevelBlocksRel.setRotationType(validateRotationDTO.getRotationTypeId());
			progdurationRotationTraineelevelBlocksRel.setRotationId(validateRotationDTO.getRotationId());
			progdurationRotationTraineelevelBlocksRel.setNoOfBlocks(validateRotationDTO.getNoOfBlock());
			progdurationRotationTraineelevelBlocksRel.setGroupId(themeDisplay.getScopeGroupId());
			progdurationRotationTraineelevelBlocksRel.setCreatedBy(themeDisplay.getUserId());
			progdurationRotationTraineelevelBlocksRel.setProgramDurationId(programDurationId);
			progdurationRotationTraineelevelBlocksRel.setTraineeLevelId(traineeLevelId);
			progdurationRotationTraineelevelBlocksRel.setModifiedBy(themeDisplay.getUserId());
			progdurationRotationTraineelevelBlocksRelLocalService.addProgdurationRotationTraineelevelBlocksRel(progdurationRotationTraineelevelBlocksRel);
			
		}
		_logger.info("ProcessAction Exit ::: ");
		return true;
	}
	
	@Reference
	private ProgdurationRotationTraineelevelBlocksRelLocalService progdurationRotationTraineelevelBlocksRelLocalService;

	@Reference
	private CounterLocalService counterLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbSaveConfigureRotationsMVCActionCommand.class.getName());

}
