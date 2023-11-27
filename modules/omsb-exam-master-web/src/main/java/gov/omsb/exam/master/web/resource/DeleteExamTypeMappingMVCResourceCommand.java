package gov.omsb.exam.master.web.resource;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.exam.master.web.constants.MVCCommandNames;
import gov.omsb.exam.master.web.constants.OmsbExamMasterWebPortletKeys;
import gov.omsb.http.connector.api.OMSBHttpConnector;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbExamMasterWebPortletKeys.OMSBEXAMMASTERWEB,
		"mvc.command.name="
				+ MVCCommandNames.DELETE_EXAM_TYPE_MVC_RESOURCE_COMMAND }, service = MVCResourceCommand.class)
public class DeleteExamTypeMappingMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String id = ParamUtil.getString(resourceRequest, "primaryExamTypeId");
		logger.info("id"+id);
		
		String url = themeDisplay.getPortalURL()+ MVCCommandNames.EXAM_TYPE_URL + id;
		omsbHttpConnector.executeDelete(url, commonApi.getHttpHeaderInfoAndBasicAuth());
		JSONObject object = JSONFactoryUtil.createJSONObject();
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		object.put("success", "deleted successfully");
		resourceResponse.getWriter().write(jsonArray.toString());
		
	}
	
	private static final Log logger = LogFactoryUtil.getLog(DeleteExamTypeMappingMVCResourceCommand.class);
	@Reference(unbind = "-")
	private OMSBCommonApi commonApi;
	@Reference(unbind = "-")
	private OMSBHttpConnector omsbHttpConnector;

}
