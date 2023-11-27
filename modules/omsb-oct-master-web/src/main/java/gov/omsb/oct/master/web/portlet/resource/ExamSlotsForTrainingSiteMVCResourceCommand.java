package gov.omsb.oct.master.web.portlet.resource;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.oct.master.web.constants.MVCCommandNames;
import gov.omsb.oct.master.web.constants.OmsbOctMasterWebPortletKeys;
import gov.omsb.oct.master.web.portlet.dto.OCTTrainingSlotMaster;
import gov.omsb.oct.master.web.portlet.dto.OCTTrainingSlotMasterItems;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctMasterWebPortletKeys.OMSBOCTMASTERWEB,
		"mvc.command.name=" + MVCCommandNames.GET_EXAM_SLOTS_FOR_TRAINING_SITES }, service = MVCResourceCommand.class)
public class ExamSlotsForTrainingSiteMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		
		logger.info("ExamSlotsForTrainingSiteMVCResourceCommand started");

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long scopeGroupId = themeDisplay.getScopeGroupId();
			String portalUrl = themeDisplay.getPortalURL();

			String resource = ParamUtil.getString(resourceRequest, "resourceName");

			if (Validator.isNotNull(resource)) {

				if (resource.equalsIgnoreCase("examSlotList")) {

					long trainingSiteId = ParamUtil.getLong(resourceRequest, "trainingSiteId");
					logger.info("trainingSiteId  "+trainingSiteId);

//					long trainingSiteId = 0l;
//					if (Validator.isNotNull(trainingSiteIdString)) {
//						trainingSiteId = Long.valueOf(trainingSiteIdString);
//					}

					List<OCTTrainingSlotMaster> octMapTrainingSiteList = getOCTMapTrainingSite(portalUrl,
							scopeGroupId, trainingSiteId);

					if (Validator.isNotNull(octMapTrainingSiteList)) {

					}
					JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

					if (Validator.isNotNull(octMapTrainingSiteList) && octMapTrainingSiteList.size() > 0) {
						for (OCTTrainingSlotMaster examSlot : octMapTrainingSiteList) {
							JSONObject object = JSONFactoryUtil.createJSONObject();
							object.put("name", examSlot.getTimeSlot());
							object.put("value", examSlot.getTimeSlot());
							jsonArray.put(object);
						}
					}

					resourceResponse.getWriter().print(jsonArray.toJSONString());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Boolean.FALSE;
	}

	
	public List<OCTTrainingSlotMaster> getOCTMapTrainingSite(String portalUrl, long scopeGroupId, long trainingSiteId) {
		String octMAPTrainingSiteURL = portalUrl + MVCCommandNames.OCT_EXAM_TRAINING_SITE_SLOT_MASTER + CommonConstants.SCOPES
				+ StringPool.SLASH + scopeGroupId + StringPool.QUESTION + "filter=trainingSiteId"
				+ URLEncoder.encode(" eq " + trainingSiteId, StandardCharsets.UTF_8);
		logger.info("octMAPTrainingSiteURL  "+octMAPTrainingSiteURL);
		
//		String octMAPTrainingSiteResponse = omsbHttpConnector.executeGet(octMAPTrainingSiteURL, StringPool.BLANK,
//				omsbCommonApi.getHttpHeaderInfoAndBasicAuth());
		
		String octMAPTrainingSiteResponse = omsbCommonApi.getData(octMAPTrainingSiteURL);
		logger.info("octMAPTrainingSiteResponse  "+octMAPTrainingSiteResponse);
		OCTTrainingSlotMasterItems octMapTrainingSiteItems = CustomObjectMapperUtil.readValue(octMAPTrainingSiteResponse,
				OCTTrainingSlotMasterItems.class);
	
		if (Validator.isNotNull(octMapTrainingSiteItems)) {
			List<OCTTrainingSlotMaster> octMapTrainingSiteList = octMapTrainingSiteItems.getItems();
			return octMapTrainingSiteList;
		}
		return null;
	}
	
	@Reference(unbind = "-")
	private OMSBHttpConnector omsbHttpConnector;
	
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
	
	private static final Log logger = LogFactoryUtil.getLog(ExamSlotsForTrainingSiteMVCResourceCommand.class);

	

}
