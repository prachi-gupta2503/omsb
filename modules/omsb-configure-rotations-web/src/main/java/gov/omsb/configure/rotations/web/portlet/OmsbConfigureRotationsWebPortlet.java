package gov.omsb.configure.rotations.web.portlet;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.dto.UserMetadata;
import gov.omsb.common.dto.UserMetadataItem;
import gov.omsb.common.service.util.UserMetadataUtil;
import gov.omsb.configure.rotations.web.constants.OmsbConfigureRotationsWebPortletKeys;
import gov.omsb.tms.custom.dto.ConfigureRotationDetailsDTO;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.model.RotationTypeMaster;
import gov.omsb.tms.service.ProgdurationRotationTraineelevelBlocksRelLocalService;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;
import gov.omsb.tms.service.RotationMasterLocalService;
import gov.omsb.tms.service.RotationTypeMasterLocalService;
import gov.omsb.tms.service.TraineeLevelMasterLocalService;

/**
 * @author HP
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=OMSB",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=OmsbConfigureRotationsWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=" + OmsbConfigureRotationsWebPortletKeys.ADD_CONFIGURE_ROTATIONS_JSP,
		"javax.portlet.name=" + OmsbConfigureRotationsWebPortletKeys.OMSBCONFIGUREROTATIONSWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class OmsbConfigureRotationsWebPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		_logger.info("render Invoked ::: ");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		UserMetadataItem metadataItem = metadataUtil.getUserMetadataItemsByLrUserId(themeDisplay.getPortalURL(), themeDisplay.getSiteGroupId(), themeDisplay.getUserId());
		
		List<Long> ids = metadataItem.getItems().stream()
		        .map(UserMetadata::getProgramId)
		        .collect(Collectors.toList());
		
		DynamicQuery query = programMasterLocalService.dynamicQuery();
		query.add(PropertyFactoryUtil.forName("programMasterId").in(ids));
		List<ProgramMaster> programMasters = programMasterLocalService.dynamicQuery(query);
		programMasters = programMasters.stream().sorted((first,second)->{
	        String programFirst = first.getProgramName(themeDisplay.getLocale()).toLowerCase();
	        String programSecond = second.getProgramName(themeDisplay.getLocale()).toLowerCase();
	        return programFirst.compareTo(programSecond);
		}).collect(Collectors.toList());
		List<RotationTypeMaster> rotationTypeMasters = rotationTypeMasterLocalService.getRotationTypeMasters(-1, -1);
		
		rotationTypeMasters = rotationTypeMasters.stream().sorted((first,second)->{
	        String rotationFirst = first.getRotationTypeName(themeDisplay.getLocale()).toLowerCase();
	        String rotationSecond = second.getRotationTypeName(themeDisplay.getLocale()).toLowerCase();
	        return rotationFirst.compareTo(rotationSecond);
		}).collect(Collectors.toList());
		renderRequest.setAttribute(OmsbConfigureRotationsWebPortletKeys.RENDER_PROGRAM_LIST, programMasters);
		renderRequest.setAttribute(OmsbConfigureRotationsWebPortletKeys.RENDER_ROTATION_TYPE_LIST, rotationTypeMasters);
		List<ConfigureRotationDetailsDTO> configureRotationList = progdurationRotationTraineelevelBlocksRelLocalService.getConfigureRotationDetails(themeDisplay.getLocale().toString());
		renderRequest.setAttribute(OmsbConfigureRotationsWebPortletKeys.CONFIGURE_ROTATIONS_LIST, configureRotationList); 
		super.render(renderRequest, renderResponse);
		_logger.info("render Exit ::: ");

	}
	
	@Reference
	private RotationTypeMasterLocalService rotationTypeMasterLocalService;
	
	@Reference
	private ProgdurationRotationTraineelevelBlocksRelLocalService progdurationRotationTraineelevelBlocksRelLocalService;
	
	@Reference
	private TraineeLevelMasterLocalService traineeLevelMasterLocalService;
	
	@Reference
	private RotationMasterLocalService rotationMasterLocalService;

	@Reference
	private ProgramMasterLocalService programMasterLocalService;
	
	@Reference
	private ProgramDurationDetailsLocalService programDurationDetailsLocalService;
	
	@Reference
	private UserMetadataUtil metadataUtil;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbConfigureRotationsWebPortlet.class.getName());
}