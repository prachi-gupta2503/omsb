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
		"mvc.command.name=" + MVCCommandNames.WORK_SECTOR_TYPE_RESOURCE_COMMAND }, service = MVCResourceCommand.class)

public class WorkSectorMVCResourceCommand extends BaseMVCResourceCommand{

	private static final Log logger = LogFactoryUtil.getLog(WorkSectorMVCResourceCommand.class);
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		logger.info("WorkSectorMVCResourceCommand started");
		
		try {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Long workSectorType = ParamUtil.getLong(resourceRequest, "workSectorType");
		logger.info("workSectorType   "+workSectorType);
		WorksectorsItems worksectorsItems = getWorkSectorNameItemsKey(themeDisplay, workSectorType);
		logger.info("worksectorsItems   "+ worksectorsItems);
		if (Validator.isNotNull(worksectorsItems) && Validator.isNotNull(worksectorsItems.getItems())
				&& !worksectorsItems.getItems().isEmpty()) {
			for (Worksectors items : worksectorsItems.getItems()) {
				JSONObject object = JSONFactoryUtil.createJSONObject();
				object.put("workSector", items.getWorkSector());
				object.put("workSectorId", items.getId());
				jsonArray.put(object);
			}
			logger.info("jsonArray   "+jsonArray.toJSONString());
		}
		resourceResponse.getWriter().write(jsonArray.toString());
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
	

	public WorksectorsItems getWorkSectorNameItemsKey(ThemeDisplay themeDisplay, long workSectorType)
			throws UnsupportedEncodingException {
		String workSectorMasterUrl =  themeDisplay.getPortalURL() + MVCCommandNames.WORK_SECTOR_TYPE_URL  + CommonConstants.SCOPES + StringPool.SLASH + 
				themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=workSectorType" 
				+URLEncoder.encode(" eq " + "'"+ workSectorType+ "' and workSectorParentId eq 0" , StandardCharsets.UTF_8) + "&sort=workSector:asc&pageSize=0";
		String workSectorMasterUrlResponse = commonApi.getData(workSectorMasterUrl);
		logger.info("workSectorMasterUrl::" + workSectorMasterUrl);
		logger.info("workSectorMasterUrlResponse==============="+workSectorMasterUrlResponse);
		return CustomObjectMapperUtil.readValue(workSectorMasterUrlResponse, WorksectorsItems.class);
	}
	
	@Reference
	private OMSBCommonApi commonApi;

	@Reference
	private OMSBHttpConnector omsbHttpConnector;
}
