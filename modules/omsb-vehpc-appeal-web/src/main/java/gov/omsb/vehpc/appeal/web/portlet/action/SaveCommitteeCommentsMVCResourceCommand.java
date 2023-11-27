package gov.omsb.vehpc.appeal.web.portlet.action;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.vehpc.appeal.util.AppealUtil;
import gov.omsb.vehpc.appeal.web.constants.AppealConstants;
import gov.omsb.vehpc.appeal.web.constants.OmsbVehpcAppealWebPortletKeys;

@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbVehpcAppealWebPortletKeys.OMSBVEHPCAPPEALWEB,
	        "mvc.command.name="+AppealConstants.SAVE_COMMITTEE_COMMENTS
	    }, 
	    service = MVCResourceCommand.class
	    
)
public class SaveCommitteeCommentsMVCResourceCommand implements MVCResourceCommand {

	private static final Log _log = LogFactoryUtil.getLog(SaveCommitteeCommentsMVCResourceCommand.class);
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
	
		/** ===== Add New Record === **/
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String comments = ParamUtil.getString(resourceRequest, "comments");
		long classPK = ParamUtil.getLong(resourceRequest, "classPK");
		long statusId = ParamUtil.getLong(resourceRequest, "statusId");
		
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		appealUtil.saveAppealStatus(themeDisplay, RoleNameConstants.VEHPC_COMMITTEE, comments, classPK, statusId, 0);
		_log.info("Appeal Status Saved Successful ::::: ");
		return Boolean.FALSE;
	}
	
	@Reference(unbind = "-")
	private AppealUtil appealUtil;
}
