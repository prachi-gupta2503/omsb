package gov.omsb.oct.master.web.portlet.resource;

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
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.oct.master.web.constants.MVCCommandNames;
import gov.omsb.oct.master.web.constants.OmsbOctMasterWebPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctMasterWebPortletKeys.OMSBOCTMASTERWEB,
		"mvc.command.name=" + MVCCommandNames.DELETE_TRAINING_SLOT }, service = MVCResourceCommand.class)
public class DeleteTrainingSlotMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String id = ParamUtil.getString(resourceRequest, "primaryTrainingSlotId");
		logger.info("id"+id);
		
		String url = themeDisplay.getPortalURL()+ MVCCommandNames.OCT_EXAM_TRAINING_SITE_SLOT_MASTER + id;
		oMSBHttpConnector.executeDelete(url, omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
		JSONObject object = JSONFactoryUtil.createJSONObject();
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		object.put("success", "deleted successfully");
		resourceResponse.getWriter().write(jsonArray.toString());
		
	}
	
	private static final Log logger = LogFactoryUtil.getLog(DeleteTrainingSlotMVCResourceCommand.class);
	
	@Reference(unbind = "-")
	private OMSBHttpConnector oMSBHttpConnector;
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

}
