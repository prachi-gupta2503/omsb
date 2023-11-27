package gov.omsb.programs.web.portlet.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.util.CommonUtil;
import gov.omsb.programs.web.constants.OmsbProgramConstants;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;

/**
 * @author Jayesh Goswami
 */
public class OmsbProgramGenerateUrlsUtil {
	
	private OmsbProgramGenerateUrlsUtil() {}

	/**
	 * @param themeDisplay
	 * @param request
	 * @param programMasterId
	 * @return String
	 * This URL Returns the detauls page url for the program
	 */
	@SuppressWarnings("deprecation")
	public static String createProgrmDetailsRenderUrl(ThemeDisplay themeDisplay, ResourceRequest request, long programMasterId) {
		_logger.info("createProgrmDetailsRenderUrl Invoked ::: ");
		String renderUrlStr = StringPool.BLANK;
		try {
			PortletURL renderUrl = PortletURLFactoryUtil.create(request, themeDisplay.getPortletDisplay().getId(),
					themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
			renderUrl.setWindowState(WindowState.NORMAL);
			renderUrl.setPortletMode(PortletMode.VIEW);
			renderUrl.setParameter(CommonConstants.MVC_RENDER_COMMAND_NAME,
					OmsbProgramConstants.PROGRAM_DETAILS_MVC_RENDER_COMMAND);
			renderUrl.setParameter(CommonConstants.PROGRAM_MASTER_ID, String.valueOf(programMasterId));
			renderUrlStr = renderUrl.toString();
		} catch (PortletModeException | WindowStateException e) {
			_logger.error("createProgrmDetailsRenderUrl Error ::: " + e);
		}
		_logger.info("createProgrmDetailsRenderUrl Exit ::: ");
		return renderUrlStr;
	}
	
	@SuppressWarnings("deprecation")
	public static String createAddProgramCohortRenderUrl(ThemeDisplay themeDisplay, PortletRequest request, long programMasterId, String backURL) {
		_logger.info("createAddProgramCohortRenderUrl Invoked ::: ");
		long groupId = themeDisplay.getScopeGroupId();
		Layout trainingSiteLayout = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(groupId, true, OmsbTmsCommonConstants.ADD_PROGRAM_COHORT_PORTLET_FRAINDLY_URL);
		long plid = Validator.isNotNull(trainingSiteLayout) ? trainingSiteLayout.getPlid() : 0;
		
		String renderUrlStr = StringPool.BLANK;
		try {
			PortletURL renderUrl = PortletURLFactoryUtil.create(request, OmsbTmsCommonConstants.ADD_PROGRAM_COHORT_PORTLET_NAME, plid, PortletRequest.RENDER_PHASE);
			renderUrl.setWindowState(WindowState.NORMAL);
			renderUrl.setPortletMode(PortletMode.VIEW);
			renderUrl.setParameter(CommonConstants.MVC_RENDER_COMMAND_NAME, "/");
			renderUrl.setParameter(OmsbProgramConstants.PROGRAM_ID, String.valueOf(programMasterId));
			renderUrl.setParameter(CommonConstants.REDIRECT_COMMAND_URL, backURL);
			renderUrlStr = renderUrl.toString();
		} catch (PortletModeException | WindowStateException e) {
			_logger.error("createAddProgramCohortRenderUrl Error ::: " + e);
		}
		_logger.info("createAddProgramCohortRenderUrl Exit ::: ");
		return renderUrlStr;
	}
	
	
	@SuppressWarnings("deprecation")
	public static String getRotationRenderUrl(ThemeDisplay themeDisplay, ResourceRequest request, long programCohortId) {
		_logger.info("getRotationRenderUrl Invoked ::: ");
		long groupId = themeDisplay.getScopeGroupId();
		Layout trainingSiteLayout = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(groupId, true, OmsbTmsCommonConstants.ROTATION_PORTLET_FRAINDLY_URL);
		long plid = Validator.isNotNull(trainingSiteLayout) ? trainingSiteLayout.getPlid() : 0;
		
		String renderUrlStr = StringPool.BLANK;
		try {
			PortletURL renderUrl = PortletURLFactoryUtil.create(request, OmsbTmsCommonConstants.ROTATION_PORTLET_NAME, plid, PortletRequest.RENDER_PHASE);
			renderUrl.setWindowState(WindowState.NORMAL);
			renderUrl.setPortletMode(PortletMode.VIEW);
			renderUrl.setParameter(CommonConstants.MVC_RENDER_COMMAND_NAME, "/add-rotation-form");
			renderUrl.setParameter(OmsbTmsCommonConstants.PROGRAM_DURATION_ID, String.valueOf(programCohortId));
			renderUrl.setParameter("type", "add");
			renderUrlStr = renderUrl.toString();
		} catch (PortletModeException | WindowStateException e) {
			_logger.error("getRotationRenderUrl Error ::: " + e);
		}
		_logger.info("getRotationRenderUrl Exit ::: ");
		return renderUrlStr;
	}
	
	@SuppressWarnings("deprecation")
	public static String getRotationEditOrViewRenderUrl(ThemeDisplay themeDisplay, ResourceRequest request, long programCohortId, long rotationMasterId) {
		_logger.info("getRotationEditOrViewRenderUrl Invoked ::: ");
		long groupId = themeDisplay.getScopeGroupId();
		Layout trainingSiteLayout = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(groupId, true, OmsbTmsCommonConstants.ROTATION_PORTLET_FRAINDLY_URL);
		long plid = Validator.isNotNull(trainingSiteLayout) ? trainingSiteLayout.getPlid() : 0;
		
		String renderUrlStr = StringPool.BLANK;
		try {
			PortletURL renderUrl = PortletURLFactoryUtil.create(request, OmsbTmsCommonConstants.ROTATION_PORTLET_NAME, plid, PortletRequest.RENDER_PHASE);
			renderUrl.setWindowState(WindowState.NORMAL);
			renderUrl.setPortletMode(PortletMode.VIEW);
			renderUrl.setParameter(CommonConstants.MVC_RENDER_COMMAND_NAME, OmsbTmsCommonConstants.ROTATION_DETAILS_MVC_RENDER_COMMAND);
			renderUrl.setParameter(OmsbTmsCommonConstants.PROGRAM_DURATION_ID, String.valueOf(programCohortId));
			renderUrl.setParameter(OmsbTmsCommonConstants.ROTATION_MASTER_ID, String.valueOf(rotationMasterId));			
			renderUrl.setParameter("type", CommonUtil.isTraineeUser(themeDisplay.getUser()) ? "view" : "edit");
			renderUrlStr = renderUrl.toString();
		} catch (PortletModeException | WindowStateException e) {
			_logger.error("getRotationEditOrViewRenderUrl Error ::: " + e);
		}
		_logger.info("getRotationEditOrViewRenderUrl Exit ::: ");
		return renderUrlStr;
	}
	
	@SuppressWarnings("deprecation")
	public static String createViewProgramCohortRenderUrl(ThemeDisplay themeDisplay, ResourceRequest request, long programMasterId) {
		_logger.info("createViewProgramCohortRenderUrl Invoked ::: ");
		long groupId = themeDisplay.getScopeGroupId();
		Layout trainingSiteLayout = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(groupId, true, OmsbTmsCommonConstants.VIEW_PROGRAM_COHORT_PORTLET_FRAINDLY_URL);
		long plid = Validator.isNotNull(trainingSiteLayout) ? trainingSiteLayout.getPlid() : 0;
		
		String renderUrlStr = StringPool.BLANK;
		try {
			PortletURL renderUrl = PortletURLFactoryUtil.create(request, OmsbTmsCommonConstants.VIEW_PROGRAM_COHORT_PORTLET_NAME, plid, PortletRequest.RENDER_PHASE);
			renderUrl.setWindowState(WindowState.NORMAL);
			renderUrl.setPortletMode(PortletMode.VIEW);
			renderUrl.setParameter(CommonConstants.MVC_RENDER_COMMAND_NAME, "/");
			renderUrl.setParameter(CommonConstants.PROGRAM_MASTER_ID, String.valueOf(programMasterId));
			renderUrlStr = renderUrl.toString();
		} catch (PortletModeException | WindowStateException e) {
			_logger.error("createViewProgramCohortRenderUrl Error ::: " + e);
		}
		_logger.info("createViewProgramCohortRenderUrl Exit ::: ");
		return renderUrlStr;
	}
	
	@SuppressWarnings("deprecation")
	public static String createViewProgramCohortRenderUrl(ThemeDisplay themeDisplay, RenderRequest request, long programMasterId) {
		_logger.info("createViewProgramCohortRenderUrl Invoked ::: ");
		long groupId = themeDisplay.getScopeGroupId();
		Layout trainingSiteLayout = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(groupId, true, OmsbTmsCommonConstants.VIEW_PROGRAM_COHORT_PORTLET_FRAINDLY_URL);
		long plid = Validator.isNotNull(trainingSiteLayout) ? trainingSiteLayout.getPlid() : 0;
		
		String renderUrlStr = StringPool.BLANK;
		try {
			PortletURL renderUrl = PortletURLFactoryUtil.create(request, OmsbTmsCommonConstants.VIEW_PROGRAM_COHORT_PORTLET_NAME, plid, PortletRequest.RENDER_PHASE);
			renderUrl.setWindowState(WindowState.NORMAL);
			renderUrl.setPortletMode(PortletMode.VIEW);
			renderUrl.setParameter(CommonConstants.MVC_RENDER_COMMAND_NAME, "/");
			renderUrl.setParameter(CommonConstants.PROGRAM_MASTER_ID, String.valueOf(programMasterId));
			renderUrlStr = renderUrl.toString();
		} catch (PortletModeException | WindowStateException e) {
			_logger.error("createViewProgramCohortRenderUrl Error ::: " + e);
		}
		_logger.info("createViewProgramCohortRenderUrl Exit ::: ");
		return renderUrlStr;
	}
	
	@SuppressWarnings("deprecation")
	public static String createViewTrainingSiteDetailsRenderUrl(ThemeDisplay themeDisplay, ResourceRequest request, long trainingSiteId,long programCohortId) {
		_logger.info("createViewTrainingSiteDetailsRenderUrl Invoked ::: ");
		long groupId = themeDisplay.getScopeGroupId();
		Layout trainingSiteLayout = LayoutLocalServiceUtil.fetchLayoutByFriendlyURL(groupId, true, OmsbTmsCommonConstants.TRAINING_SITES_PORTLET_FRAINDLY_URL);
		long plid = Validator.isNotNull(trainingSiteLayout) ? trainingSiteLayout.getPlid() : 0;
		
		String renderUrlStr = StringPool.BLANK;
		try {
			PortletURL renderUrl = PortletURLFactoryUtil.create(request, OmsbTmsCommonConstants.TRAINING_SITES_PORTLET_NAME, plid, PortletRequest.RENDER_PHASE);
			renderUrl.setWindowState(WindowState.NORMAL);
			renderUrl.setPortletMode(PortletMode.VIEW);
			renderUrl.setParameter(CommonConstants.MVC_RENDER_COMMAND_NAME, OmsbTmsCommonConstants.TRAINING_SITE_DETAILS_MVC_RENDER_COMMAND);
			renderUrl.setParameter(OmsbTmsCommonConstants.TRAINING_SITE_MASTER_ID, String.valueOf(trainingSiteId));
			renderUrl.setParameter(OmsbTmsCommonConstants.PROG_DURATION_ID, String.valueOf(programCohortId));
			renderUrlStr = renderUrl.toString();
		} catch (PortletModeException | WindowStateException e) {
			_logger.error("createViewTrainingSiteDetailsRenderUrl Error ::: " + e);
		}
		_logger.info("createViewTrainingSiteDetailsRenderUrl Exit ::: ");
		return renderUrlStr;
	}
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbProgramUtil.class.getName());
}
