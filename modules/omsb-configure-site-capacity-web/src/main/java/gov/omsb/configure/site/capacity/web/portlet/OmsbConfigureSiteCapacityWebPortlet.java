package gov.omsb.configure.site.capacity.web.portlet;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
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
import java.util.Map;
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
import gov.omsb.configure.site.capacity.web.constants.OmsbConfigureSiteCapacityWebPortletKeys;
import gov.omsb.tms.custom.dto.SiteCapacityDTO;
import gov.omsb.tms.model.ProgramDurationDetails;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.model.RotationMaster;
import gov.omsb.tms.model.TrainingSitesMaster;
import gov.omsb.tms.service.ProgdurationRotationTrainingsitesRelLocalService;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;
import gov.omsb.tms.service.RotationMasterLocalService;
import gov.omsb.tms.service.TrainingSitesMasterLocalService;

/**
 * @author Aditya Meghnathi
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.OMSB",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=OmsbConfigureSiteCapacityWeb", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=" + OmsbConfigureSiteCapacityWebPortletKeys.ADD_SITE_CAPACITY_JSP,
		"javax.portlet.name=" + OmsbConfigureSiteCapacityWebPortletKeys.OMSBCONFIGURESITECAPACITYWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class OmsbConfigureSiteCapacityWebPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		UserMetadataItem userMetadataItem = userMetadataUtil.getUserMetadataItemsByLrUserId(themeDisplay.getPortalURL(),
				themeDisplay.getScopeGroupId(), themeDisplay.getUserId());
		List<Long> programMasterIds = new ArrayList<>();
		if (Validator.isNotNull(userMetadataItem) && Validator.isNotNull(userMetadataItem.getItems())) {
			programMasterIds = (userMetadataItem.getItems()).stream().map(UserMetadata::getProgramId)
					.collect(Collectors.toList());
		}

		List<ProgramMaster> programMasterList = programMasterLocalService.findByProgramMasterId(programMasterIds);
		List<ProgramDurationDetails> programDurationDetails = programDurationDetailsLocalService
				.getProgramDurationDetailses(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		programMasterList = programMasterList.stream().sorted((first,second)->{
	        String programFirst = first.getProgramName(themeDisplay.getLocale()).toLowerCase();
	        String programSecond = second.getProgramName(themeDisplay.getLocale()).toLowerCase();
	        return programFirst.compareTo(programSecond);
		}).collect(Collectors.toList());

		Map<Long, String> programNameCohotMapping = new HashMap<>();
		for (ProgramDurationDetails programDuration : programDurationDetails) {
			try {
				ProgramMaster programMaster = programMasterLocalService
						.getProgramMaster(programDuration.getProgramId());
				programNameCohotMapping.put(programDuration.getProgDurationId(),
						programMaster.getProgramName(themeDisplay.getLocale()) + StringPool.SPACE + StringPool.OPEN_PARENTHESIS
								+ programDuration.getAyApplicableForm() + StringPool.CLOSE_PARENTHESIS);
			} catch (PortalException e) {
				_logger.debug(e);
			}
		}

		List<TrainingSitesMaster> trainingSitesMasters = trainingSitesMasterLocalService
				.getTrainingSitesMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		trainingSitesMasters = trainingSitesMasters.stream().sorted((first,second)->{
	        String siteFirst = first.getTrainingSiteName(themeDisplay.getLocale()).toLowerCase();
	        String siteSecond = second.getTrainingSiteName(themeDisplay.getLocale()).toLowerCase();
	        return siteFirst.compareTo(siteSecond);
		}).collect(Collectors.toList());
		List<RotationMaster> rotationMasters = rotationMasterLocalService.getRotationMasters(QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);
		rotationMasters = rotationMasters.stream().sorted((first,second)->{
	        String siteFirst = first.getRotationName(themeDisplay.getLocale()).toLowerCase();
	        String siteSecond = second.getRotationName(themeDisplay.getLocale()).toLowerCase();
	        return siteFirst.compareTo(siteSecond);
		}).collect(Collectors.toList());
		List<SiteCapacityDTO> siteCapacityDTOs = pdRotationTrainingsitesRelLocalService
				.getSiteCapacityDetails(themeDisplay.getLocale().toString());

		renderRequest.setAttribute(OmsbConfigureSiteCapacityWebPortletKeys.PROGRAM_NAME_COHORT_MAP,
				programNameCohotMapping);
		renderRequest.setAttribute(OmsbConfigureSiteCapacityWebPortletKeys.ALL_PROGRAM_LIST, programMasterList);
		renderRequest.setAttribute(OmsbConfigureSiteCapacityWebPortletKeys.ALL_TRAINING_SITE_LIST,
				trainingSitesMasters);
		renderRequest.setAttribute(OmsbConfigureSiteCapacityWebPortletKeys.ALL_ROTATION_LIST, rotationMasters);
		renderRequest.setAttribute(OmsbConfigureSiteCapacityWebPortletKeys.ALL_SITE_CAPACITIES, siteCapacityDTOs);
		super.render(renderRequest, renderResponse);
	}

	private static final Log _logger = LogFactoryUtil.getLog(OmsbConfigureSiteCapacityWebPortlet.class);

	@Reference
	private UserMetadataUtil userMetadataUtil;

	@Reference
	private ProgramMasterLocalService programMasterLocalService;

	@Reference
	private ProgramDurationDetailsLocalService programDurationDetailsLocalService;

	@Reference
	private TrainingSitesMasterLocalService trainingSitesMasterLocalService;

	@Reference
	private RotationMasterLocalService rotationMasterLocalService;

	@Reference
	private ProgdurationRotationTrainingsitesRelLocalService pdRotationTrainingsitesRelLocalService;
}