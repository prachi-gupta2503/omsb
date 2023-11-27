package gov.omsb.view.procedures.supervisor.web.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;

import gov.omsb.common.util.CommonUtil;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.view.procedures.supervisor.web.constants.OmsbViewProceduresSupervisorWebPortletKeys;

public class OmsbViewProcedureSuperVisorGenerateUrlsUtil {

	private OmsbViewProcedureSuperVisorGenerateUrlsUtil() {
	}

	public static String createViewLogProcedureRenderUrl(ThemeDisplay themeDisplay, ActionRequest actionRequest,
			long procedureDetailsId, boolean showModal) {
		_logger.info("createViewLogProcedureRenderUrl Invoked ::: ");
		Map<String, String> parameters = new HashMap<>();
		parameters.put(OmsbViewProceduresSupervisorWebPortletKeys.TRAINEE_LOGGED_PROCEDURE_DETAILS_ID,
				String.valueOf(procedureDetailsId));
		parameters.put(OmsbViewProceduresSupervisorWebPortletKeys.SHOW_MODAL, String.valueOf(showModal));
		parameters.put(OmsbTmsCommonConstants.JSP_PAGE, OmsbViewProceduresSupervisorWebPortletKeys.VIEW_JSP);
		return CommonUtil.generateRenderURL(PortalUtil.getHttpServletRequest(actionRequest),
				themeDisplay.getScopeGroupId(), OmsbTmsCommonConstants.VIEW_LOG_PROCEDURES_PORTLET_NAME, parameters);
	}

	private static final Log _logger = LogFactoryUtil
			.getLog(OmsbViewProcedureSuperVisorGenerateUrlsUtil.class.getName());
}
