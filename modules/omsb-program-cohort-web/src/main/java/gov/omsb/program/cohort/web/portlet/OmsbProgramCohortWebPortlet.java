package gov.omsb.program.cohort.web.portlet;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.dto.UserMetadataItem;
import gov.omsb.common.service.util.UserMetadataUtil;
import gov.omsb.common.util.CommonUtil;
import gov.omsb.program.cohort.web.constants.OmsbProgramCohortWebPortletKeys;
import gov.omsb.program.cohort.web.portlet.util.ProgramCohortUtil;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.model.LevelTypeMaster;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.model.TraineeLevelMaster;
import gov.omsb.tms.service.LevelTypeMasterLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;
import gov.omsb.tms.service.TraineeLevelMasterLocalService;

/**
 * @author Jayesh Goswami
 */
@Component(immediate = true, property = { "javax.portlet.version=3.0","com.liferay.portlet.display-category=OMSB",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=OmsbProgramCohortWeb", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=" + OmsbProgramCohortWebPortletKeys.ADD_PROGRAM_COHORT_JSP,
		"javax.portlet.name=" + OmsbProgramCohortWebPortletKeys.OMSBPROGRAMCOHORTWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class OmsbProgramCohortWebPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		_logger.info("doProcessAction Invoked ::: ");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		//programMasterId - programId from programDetails page
		long programMasterId = ParamUtil.getLong(renderRequest, OmsbProgramCohortWebPortletKeys.PROGRAM_ID, 0l);
		String backURL = ParamUtil.getString(renderRequest, CommonConstants.REDIRECT_COMMAND_URL);

		boolean isSuperAdmin = CommonUtil.isSupeAdminUser(themeDisplay.getUser());
		boolean isChairman = CommonUtil.isChairmanUser(themeDisplay.getUser());

		List<ProgramMaster> programMasterList = new ArrayList<>();
		if (isSuperAdmin || isChairman) {
			programMasterList = programMasterLocalService.findByProgramStatus(Boolean.TRUE);
		} else {
			try {
				UserMetadataItem userMetadataItem = userMetadataUtil.getUserMetadataItemsByLrUserId(
						themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), themeDisplay.getUserId());
				List<Long> programMasterIds = CommonUtil.getProgramIdsFromUsermetadataItems(userMetadataItem);
				programMasterList = programMasterLocalService.findByProgramMasterId(programMasterIds);
			} catch (Exception e) {
				_logger.error(e);
			}
		}

		List<String> yearRange = CommonUtil.getYearRangeList(Calendar.getInstance().get(Calendar.YEAR), 10l);
		List<TraineeLevelMaster> traineeLevelMasters = traineeLevelMasterLocalService
				.getTraineeLevelMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		List<LevelTypeMaster> levelTypeMasters = levelTypeMasterLocalService
				.getLevelTypeMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS).stream()
				.sorted(Comparator.comparing(LevelTypeMaster::getLevelTypeName)).collect(Collectors.toList());

		programMasterList = programMasterList.stream()
			    .sorted((first, second) -> {
			        String programNameFirst = first.getProgramName(themeDisplay.getLocale()).toLowerCase();
			        String programNameSecond = second.getProgramName(themeDisplay.getLocale()).toLowerCase();
			        return programNameFirst.compareTo(programNameSecond);
			    }).collect(Collectors.toList());
		
		renderRequest.setAttribute(OmsbProgramCohortWebPortletKeys.PROGRAM_ID, programMasterId);
		renderRequest.setAttribute(OmsbTmsCommonConstants.PROGRAM_MASTER_LIST, programMasterList);
		renderRequest.setAttribute(OmsbTmsCommonConstants.YEAR_RANGE, yearRange);
		renderRequest.setAttribute(OmsbTmsCommonConstants.TRAINEE_LEVEL_MASTERS, traineeLevelMasters);
		renderRequest.setAttribute(OmsbTmsCommonConstants.LEVEL_TYPE_MASTERS, levelTypeMasters);
		renderRequest.setAttribute("programListRenderUrl", ProgramCohortUtil.createProgramDetailsPageRenderUrl(themeDisplay,
				renderRequest, programMasterId));
		renderRequest.setAttribute(CommonConstants.REDIRECT_COMMAND_URL, backURL);

		_logger.info("doProcessAction Exit ::: ");
		super.render(renderRequest, renderResponse);
	}

	@Reference(unbind = "_")
	private UserMetadataUtil userMetadataUtil;

	@Reference
	ProgramMasterLocalService programMasterLocalService;

	@Reference
	TraineeLevelMasterLocalService traineeLevelMasterLocalService;

	@Reference
	LevelTypeMasterLocalService levelTypeMasterLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbProgramCohortWebPortlet.class.getName());
}