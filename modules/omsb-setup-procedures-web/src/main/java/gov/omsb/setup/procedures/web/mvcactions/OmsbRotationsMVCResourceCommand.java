package gov.omsb.setup.procedures.web.mvcactions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.setup.procedures.web.constants.OmsbSetupProceduresWebPortletKeys;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.custom.dto.RotationListDTO;
import gov.omsb.tms.model.RotationMaster;
import gov.omsb.tms.service.ProgdurationRotationTraineelevelBlocksRelLocalService;
import gov.omsb.tms.service.RotationMasterLocalService;

/**
 * 
 * @author Aditya Meghnathi
 *
 */
@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbSetupProceduresWebPortletKeys.OMSBSETUPPROCEDURESWEB,
		"mvc.command.name=/getRotationURL" }, service = MVCResourceCommand.class)
public class OmsbRotationsMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		_logger.info("OmsbRotationsMVCResourceCommand doServeResource :::");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long traineeLevelMasterId = ParamUtil.getLong(resourceRequest, OmsbSetupProceduresWebPortletKeys.TRAINEE_LEVEL,
				0);
		long programDurationId = ParamUtil.getLong(resourceRequest, OmsbTmsCommonConstants.PROGRAM_DURATION_ID, 0);

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		String json;
		if (traineeLevelMasterId == 0) {
			List<RotationMaster> rotationMasters = rotationMasterLocalService.getRotationMasters(-1, -1);
			rotationMasters = rotationMasters.stream().sorted((first,second)->{
		        String objectFirst = first.getRotationName(themeDisplay.getLocale()).toLowerCase();
		        String objectSecond = second.getRotationName(themeDisplay.getLocale()).toLowerCase();
		        return objectFirst.compareTo(objectSecond);
			}).collect(Collectors.toList()); 
			json = mapper.writeValueAsString(rotationMasters);
		} else {
			List<RotationListDTO> rotationListDTOs = rotationMasterLocalService
					.getRotationsByTraineeLevelIdAndProgramDurationId(traineeLevelMasterId, programDurationId,
							themeDisplay.getLocale().toString());
			rotationListDTOs = rotationListDTOs.stream().sorted((first,second)->{
		        String objectFirst = first.getRotationName().toLowerCase();
		        String objectSecond = second.getRotationName().toLowerCase();
		        return objectFirst.compareTo(objectSecond);
			}).collect(Collectors.toList()); 
			json = mapper.writeValueAsString(rotationListDTOs);
		}
		resourceResponse.getWriter().write(json);

	}

	@Reference
	private RotationMasterLocalService rotationMasterLocalService;

	@Reference
	private ProgdurationRotationTraineelevelBlocksRelLocalService progdurationRotationTraineelevelBlocksRelLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbRotationsMVCResourceCommand.class.getName());
}
