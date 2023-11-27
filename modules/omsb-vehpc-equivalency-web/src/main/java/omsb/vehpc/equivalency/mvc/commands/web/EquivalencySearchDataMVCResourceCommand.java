package omsb.vehpc.equivalency.mvc.commands.web;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import omsb.vehpc.equivalency.web.constants.MVCCommandNames;
import omsb.vehpc.equivalency.web.constants.OmsbVehpcEquivalencyWebPortletKeys;

/**
 * @author Tayyaba MM
 */
/*@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbVehpcEquivalencyWebPortletKeys.OMSBVEHPCEQUIVALENCYWEB,
	        "mvc.command.name="+MVCCommandNames.EQUIVALENCY_SEARCH
	    }, 
	    service = MVCResourceCommand.class
)
public class EquivalencySearchDataMVCResourceCommand extends BaseMVCResourceCommand{

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		LOGGER.info("Equivalency details doServeResource()  >>>invoked");
			String status = ParamUtil.getString(resourceRequest, "status");
			String employer = ParamUtil.getString(resourceRequest, "employer");
			String employee = ParamUtil.getString(resourceRequest, "employee");
			String verificationdate = ParamUtil.getString(resourceRequest, "verificationdate");
			LOGGER.info("employer :: "+employer);
			LOGGER.info("employee :: "+employee);
			LOGGER.info("status :: "+status);
			LOGGER.info("verificationdate :: "+verificationdate);
			
			
			
		
	}

	private static final Log LOGGER = LogFactoryUtil.getLog(EquivalencyAddRequestMVCActionCommand.class);
}*/
