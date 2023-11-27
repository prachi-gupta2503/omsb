package omsb.vehpc.equivalency.mvc.commands.web;

import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Map;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import omsb.vehpc.equivalency.web.constants.MVCCommandNames;
import omsb.vehpc.equivalency.web.constants.OmsbVehpcEquivalencyWebPortletKeys;

/**
 * @author Tayyaba MM
 */
@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbVehpcEquivalencyWebPortletKeys.OMSBVEHPCEQUIVALENCYWEB,
	        "mvc.command.name="+MVCCommandNames.DELETE_OTHER_DOCUMENTS
	    }, 
	    service = MVCResourceCommand.class
)

public class DeleteOtherDocumentsMVCResourceCommand extends BaseMVCResourceCommand{
	
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		LOGGER.info(" deleteOtherDocumentsRow doServeResource::: Invoked >>> ");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long siteId = themeDisplay.getLayout().getGroupId();
		Map<String, String> headersInfo = omsbCommonApi.getHttpHeaderInfoAndBasicAuth();
		String cmd = ParamUtil.getString(resourceRequest, "cmd");
		long otherDocInfoId = ParamUtil.getLong(resourceRequest, "otherDocInfoId");
		long fileEntryId = ParamUtil.getLong(resourceRequest, "fileEntryId");
		LOGGER.info(" otherDocInfoId :: "+otherDocInfoId+ " fileEntryId :: "+fileEntryId);
		
		DLAppLocalServiceUtil.deleteFileEntry(fileEntryId);
		String deleteCertDocInfoURL = omsbCommonApi.getBaseURL() + LRObjectURL.DELETE_DOCINFO + otherDocInfoId;
		oMSBHttpConnector.executeDelete(deleteCertDocInfoURL, headersInfo);
	}
	
	@Reference(unbind = "-")
	private OMSBHttpConnector oMSBHttpConnector;
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
	
	private static final Log LOGGER = LogFactoryUtil.getLog(EquivalencyPersonSearchMVCResourceCommand.class);
}
