package gov.omsb.exam.master.web.resource;

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
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.exam.master.web.constants.MVCCommandNames;
import gov.omsb.exam.master.web.constants.OmsbExamMasterWebPortletKeys;
import gov.omsb.exam.master.web.portlet.dto.ExamTypeEligibilityMapping;
import gov.omsb.exam.master.web.portlet.dto.ExamTypeEligibilityMappingItem;
import gov.omsb.http.connector.api.OMSBHttpConnector;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbExamMasterWebPortletKeys.OMSBEXAMMASTERWEB,
		"mvc.command.name=" + MVCCommandNames.EXAM_ELIGIBILITY_RESOURCES_COMMAND }, service = MVCResourceCommand.class)
public class ExamEligibilityMVCResourceCommand extends BaseMVCResourceCommand{

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		logger.info("ExamEligibilityMVCResourceCommand started");
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String examType = ParamUtil.getString(resourceRequest, "examTypeValue");
		logger.info("examType   "+examType);
		ExamTypeEligibilityMappingItem eligibilityMappingItem = getWorkSectorNameItemsKey(themeDisplay, examType);
		logger.info("worksectorsItems  "+eligibilityMappingItem);
		if (Validator.isNotNull(eligibilityMappingItem) && Validator.isNotNull(eligibilityMappingItem.getItems())
				&& !eligibilityMappingItem.getItems().isEmpty()) {
			for (ExamTypeEligibilityMapping items : eligibilityMappingItem.getItems()) {
				JSONObject object = JSONFactoryUtil.createJSONObject();
				object.put("examEligibility", items.getExamEligibility());
				object.put("examEligibilityName", commonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.PL_EXAM_ELIGIBILITY_ERC, items.getExamEligibility(), themeDisplay.getCompanyId()).getName());
				jsonArray.put(object);
			}
			logger.info("jsonArray   "+jsonArray.toJSONString());
		}
		resourceResponse.getWriter().write(jsonArray.toString());
		
	}
	
	public ExamTypeEligibilityMappingItem getWorkSectorNameItemsKey(ThemeDisplay themeDisplay, String examType)
			throws UnsupportedEncodingException {
		String ExamTypeEligibilityMasterUrl =  themeDisplay.getPortalURL() + MVCCommandNames.EXAM_ELIGIBILITY_URL  + CommonConstants.SCOPES + StringPool.SLASH + 
				themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=examType" 
				+URLEncoder.encode(" eq '" + examType + "'", StandardCharsets.UTF_8);
				String ExamTypeEligibilityMasterUrlResponse = commonApi.getData(ExamTypeEligibilityMasterUrl);
		logger.info("ExamTypeEligibilityMasterUrl::" + ExamTypeEligibilityMasterUrl);
		logger.info("ExamTypeEligibilityMasterUrlResponse==============="+ExamTypeEligibilityMasterUrlResponse);
		return CustomObjectMapperUtil.readValue(ExamTypeEligibilityMasterUrlResponse, ExamTypeEligibilityMappingItem.class);
	}

	@Reference
	private OMSBCommonApi commonApi;

	@Reference
	private OMSBHttpConnector omsbHttpConnector;

	private static final Log logger = LogFactoryUtil.getLog(ExamEligibilityMVCResourceCommand.class);
}
