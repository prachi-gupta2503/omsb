package gov.omsb.vehpc.verification.web.portlet.action;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.DataflowConstants;
import gov.omsb.common.service.util.CaseDetailUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.vehpc.verification.util.VerificationUtil;
import omsb.vehpc.verification.web.constants.MVCCommands;
import omsb.vehpc.verification.web.constants.OmsbVehpcVerificationWebPortletKeys;
import omsb.vehpc.verification.web.portlet.OmsbVehpcVerificationWebPortlet;

@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbVehpcVerificationWebPortletKeys.OMSBVEHPCVERIFICATIONWEB,
	        "mvc.command.name="+MVCCommands.GET_PERSONAL_DETAILS
	    }, 
	    service = MVCResourceCommand.class
	    
)
public class GetPersonalDetailsMVCResourceCommand implements MVCResourceCommand {

	private static final Log _log = LogFactoryUtil.getLog(OmsbVehpcVerificationWebPortlet.class);
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		try {
			_log.info("personDetail:::::"+ParamUtil.getString(resourceRequest,"personDetail"));
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			ObjectMapper mapper = new ObjectMapper();
			mapper.setDateFormat(new SimpleDateFormat(DataflowConstants.OBJECT_DATE_FORMAT));
			resourceResponse.getWriter().print(mapper.writeValueAsString(verificationUtil.getPersonalDetail(themeDisplay.getScopeGroupId(), ParamUtil.getString(resourceRequest,"personDetail"))));
			return Boolean.FALSE;
		} catch (IOException e) {	
			e.printStackTrace();
			_log.error("Error while fetching personalDetails, "+e.getMessage());
			return Boolean.TRUE;
		}
	}
	
	@Reference 
	private CaseDetailUtil caseDetailUtil;	
	
	@Reference 
	private VerificationUtil verificationUtil;	
	
	@Reference(unbind = "_")
	private OMSBHttpConnector omsbHttpConnector;
	
	@Reference(unbind="-")
	private OMSBCommonApi omsbCommonApi;
	
	private static final Log logger = LogFactoryUtil.getLog(GetPersonalDetailsMVCResourceCommand.class);
}
