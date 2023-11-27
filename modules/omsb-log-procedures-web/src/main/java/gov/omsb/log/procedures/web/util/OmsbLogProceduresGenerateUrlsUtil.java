package gov.omsb.log.procedures.web.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;

import gov.omsb.common.util.CommonUtil;
import gov.omsb.log.procedures.web.constants.OmsbLogProceduresConstants;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;

public class OmsbLogProceduresGenerateUrlsUtil {

	private OmsbLogProceduresGenerateUrlsUtil() {
	}

	public static String createViewLogProcedureRenderUrl(ThemeDisplay themeDisplay, ActionRequest request,
			long traineeLoggedProcedureDetailsId, boolean showModal) {
		_logger.info("createViewLogProcedureRenderUrl Invoked ::: ");
		Map<String, String> parameters = new HashMap<>();
		parameters.put(OmsbLogProceduresConstants.TRAINEE_LOGGED_PROCEDURE_DETAILS_ID,
				String.valueOf(traineeLoggedProcedureDetailsId));
		parameters.put(OmsbLogProceduresConstants.SHOW_MODAL, String.valueOf(showModal));
		parameters.put(OmsbLogProceduresConstants.MVC_RENDER_COMMAND_NAME, StringPool.SLASH);
		return CommonUtil.generateRenderURL(PortalUtil.getHttpServletRequest(request),
				themeDisplay.getScopeGroupId(), OmsbTmsCommonConstants.VIEW_PROCEDURES_SUPERVISOR_PORTLET_NAME,
				parameters);
	}

	private static final Log _logger = LogFactoryUtil.getLog(OmsbLogProceduresGenerateUrlsUtil.class.getName());
}
