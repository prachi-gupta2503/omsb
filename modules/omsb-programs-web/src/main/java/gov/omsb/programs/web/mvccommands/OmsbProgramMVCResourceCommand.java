package gov.omsb.programs.web.mvccommands;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.dto.UserMetadata;
import gov.omsb.common.dto.UserMetadataItem;
import gov.omsb.common.service.util.UserMetadataUtil;
import gov.omsb.common.util.CommonUtil;
import gov.omsb.programs.web.constants.OmsbProgramConstants;
import gov.omsb.programs.web.constants.OmsbProgramsWebPortletKeys;
import gov.omsb.programs.web.portlet.util.OmsbProgramGenerateUrlsUtil;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.service.ProgramMasterLocalService;
import gov.omsb.tms.service.ProgramTypeMasterLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbProgramsWebPortletKeys.OMSBPROGRAMSWEB,
		"mvc.command.name=/program-list" }, service = MVCResourceCommand.class)
public class OmsbProgramMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		_logger.info("ServeResource Invoked ::: ");

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Boolean programStatus = ParamUtil.getBoolean(resourceRequest, CommonConstants.PROGRAM_STATUS, Boolean.TRUE);

		boolean isSuperAdmin = CommonUtil.isSupeAdminUser(themeDisplay.getUser());
		boolean isChairman = CommonUtil.isChairmanUser(themeDisplay.getUser());

		List<ProgramMaster> programMasterList = new ArrayList<>();
		if (isSuperAdmin || isChairman) {
			programMasterList = programMasterLocalService.findByProgramStatus(programStatus);
		} else {
			try {
				UserMetadataItem metadataItem = userMetadataUtil.getUserMetadataItemsByLrUserId(
						themeDisplay.getPortalURL(), themeDisplay.getSiteGroupId(), themeDisplay.getUserId());
				List<Long> ids = metadataItem.getItems().stream().map(UserMetadata::getProgramId)
						.collect(Collectors.toList());

				_logger.debug("Program Id :: " + ids.toString());

				programMasterList = programMasterLocalService.getProgramListByIdsAndStatus(ids, programStatus);

				_logger.debug("programMasterList size :: " + programMasterList.size());
			} catch (Exception e) {
				_logger.error(e);
			}
		}

		resourceRequest.setAttribute(OmsbProgramConstants.PROGRAM_MASTER_LIST, programMasterList);

		JSONObject resultJson = JSONFactoryUtil.createJSONObject();
		JSONArray createJSONArray = JSONFactoryUtil.createJSONArray();
		for (ProgramMaster program : programMasterList) {
			JSONObject programJson = JSONFactoryUtil.createJSONObject();
			programJson.put(CommonConstants.PROGRAM_NAME, program.getProgramName(themeDisplay.getLocale()));
			programJson.put(CommonConstants.PROGRAM_MASTER_ID, program.getProgramMasterId());
			programJson.put(CommonConstants.PROGRAM_TYPE, program.getProgramTypeId());
			programJson.put(CommonConstants.RENDER_URL,	OmsbProgramGenerateUrlsUtil.createProgrmDetailsRenderUrl(themeDisplay, resourceRequest, program.getProgramMasterId()));
			programJson.put(OmsbTmsCommonConstants.VIEW_PROGRAM_COHORT_RENDER_URL_LABEL, OmsbProgramGenerateUrlsUtil.createViewProgramCohortRenderUrl(themeDisplay, resourceRequest, program.getProgramMasterId()));
			programJson.put(OmsbTmsCommonConstants.ADD_PROGRAM_COHORT_RENDER_URL_LABEL, OmsbProgramGenerateUrlsUtil.createAddProgramCohortRenderUrl(themeDisplay, resourceRequest, program.getProgramMasterId(), themeDisplay.getURLCurrent().replace("p_p_lifecycle=2", "p_p_lifecycle=0")));
			createJSONArray.put(programJson);
		}

		resultJson.put(CommonConstants.SUCCESS, true);
		resultJson.put(CommonConstants.RESULT, createJSONArray);
		JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, resultJson);
		_logger.info("ServeResource Exit ::: ");
	}

	@Reference
	private UserMetadataUtil userMetadataUtil;

	@Reference
	private ProgramMasterLocalService programMasterLocalService;

	@Reference
	private ProgramTypeMasterLocalService programTypeMasterLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbProgramMVCResourceCommand.class.getName());
}
