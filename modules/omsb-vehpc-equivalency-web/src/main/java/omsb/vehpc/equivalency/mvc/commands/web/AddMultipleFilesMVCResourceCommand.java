package omsb.vehpc.equivalency.mvc.commands.web;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import omsb.vehpc.equivalency.web.constants.MVCCommandNames;
import omsb.vehpc.equivalency.web.constants.OmsbVehpcEquivalencyWebPortletKeys;

@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbVehpcEquivalencyWebPortletKeys.OMSBVEHPCEQUIVALENCYWEB,
	        "mvc.command.name="+MVCCommandNames.ADD_MULTIPLE_FILES_TABLE_DATA_RESOURCE
	    }, 
	    service = MVCResourceCommand.class
)

public class AddMultipleFilesMVCResourceCommand extends BaseMVCResourceCommand{

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		logger.info("doServeResource >>>Invoked>>>");
		String fileName = ParamUtil.getString(resourceRequest, "fileName");
		logger.info(">>>fileName>>>" + fileName);
		String tableId = ParamUtil.getString(resourceRequest, "tableId");
		String index = ParamUtil.getString(resourceRequest, "index");
		String finalFileId = ParamUtil.getString(resourceRequest, "finalFileId");
		resourceRequest.setAttribute("fileName", fileName);
		resourceRequest.setAttribute("index", index);
		resourceRequest.setAttribute("tableId", tableId);
		resourceRequest.setAttribute("finalFileId", finalFileId);
		try {
			PortletRequestDispatcher dispatcher = resourceRequest.getPortletSession().getPortletContext().
					getRequestDispatcher(OmsbVehpcEquivalencyWebPortletKeys.ADD_FILES_TABLE_ROW_DATA_JSP);
			dispatcher.include(resourceRequest, resourceResponse);
		} catch (PortletException | IOException e) {
			logger.info("Error while setting dispatcher, "+e.getMessage());
		}
	}
	private static final Log logger = LogFactoryUtil.getLog(EquivalencyPersonSearchMVCResourceCommand.class);

}

