package gov.omsb.master.web.resource;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.master.web.constants.MVCCommandNames;
import gov.omsb.master.web.constants.OmsbMasterPortletKeys;
import gov.omsb.master.web.portlet.dto.Worksectors;
import gov.omsb.master.web.portlet.dto.WorksectorsItems;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbMasterPortletKeys.OMSBMASTER,
		"mvc.command.name=" + MVCCommandNames.WORK_SECTOR_TYPE_PARENT_RESOURCE_COMMAND }, service = MVCResourceCommand.class)
public class WorkSectorParentIDMVCResourcesCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		logger.info("WorkSectorParentIDMVCResourcesCommand Started () ()");
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		//long workSectorTypeNameId = ParamUtil.getLong(resourceRequest, "workSectorTypeNameId");
		long workSectorTypeName = ParamUtil.getLong(resourceRequest, "workSectorTypeName");
		logger.info("workSectorTypeName:"+workSectorTypeName);
		//logger.info("workSectorTypeNameId  "+workSectorTypeNameId);
		WorksectorsItems worksectorsItems = getWorkSectorByParentId(themeDisplay, workSectorTypeName);
		logger.info("worksectorsItems  "+worksectorsItems);
		if (Validator.isNotNull(worksectorsItems) && Validator.isNotNull(worksectorsItems.getItems())
				&& !worksectorsItems.getItems().isEmpty()) {
			for (Worksectors items : worksectorsItems.getItems()) {
				JSONObject object = JSONFactoryUtil.createJSONObject();
				object.put("workSectorParent", items.getWorkSector());
				object.put("workSectorId", items.getId());
				jsonArray.put(object);
			}
			logger.info("jsonArray   "+jsonArray.toJSONString());
		}
		resourceResponse.getWriter().write(jsonArray.toString());
	}
	
	
	public WorksectorsItems getWorkSectorByParentId(ThemeDisplay themeDisplay, long workSectorParentId)
			throws UnsupportedEncodingException {
		String workSectorMasterUrl =  themeDisplay.getPortalURL() + MVCCommandNames.WORK_SECTOR_TYPE_URL  + CommonConstants.SCOPES + StringPool.SLASH + 
				themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=workSectorParentId" 
				+URLEncoder.encode(" eq " + workSectorParentId, StandardCharsets.UTF_8) + "&sort=workSector:asc&pageSize=0";
		String workSectorMasterUrlResponse = commonApi.getData(workSectorMasterUrl);
		logger.info("workSectorMasterUrl::" + workSectorMasterUrl);
		logger.info("workSectorMasterUrlResponse==============="+workSectorMasterUrlResponse);
		return CustomObjectMapperUtil.readValue(workSectorMasterUrlResponse, WorksectorsItems.class);
	}
	
	
	@Reference
	private OMSBCommonApi commonApi;

	@Reference
	private OMSBHttpConnector omsbHttpConnector;
	
	private static final Log logger = LogFactoryUtil.getLog(WorkSectorParentIDMVCResourcesCommand.class);
}
