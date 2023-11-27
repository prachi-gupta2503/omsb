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
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.picklist.constants.LRPicklistConstants;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.exam.master.web.constants.MVCCommandNames;
import gov.omsb.exam.master.web.constants.OmsbExamMasterWebPortletKeys;
import gov.omsb.exam.master.web.portlet.dto.ExamTypeEligibilityMapping;
import gov.omsb.exam.master.web.portlet.dto.ExamTypeEligibilityMappingItem;
import gov.omsb.exam.master.web.portlet.dto.ProgramExamType;
import gov.omsb.exam.master.web.portlet.dto.ProgramExamTypeItems;
import gov.omsb.http.connector.api.OMSBHttpConnector;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbExamMasterWebPortletKeys.OMSBEXAMMASTERWEB,
		"mvc.command.name=" + MVCCommandNames.PROGRAM_EXAM_TYPE_RESOURCES_COMMAND }, service = MVCResourceCommand.class)
public class ExamProgramTypeMVCResourceCommand extends BaseMVCResourceCommand{

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		logger.info("ExamProgramTypeMVCResourceCommand started");
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long programType = ParamUtil.getLong(resourceRequest, "programType");
		logger.info("programType   "+programType);
		
		ProgramExamTypeItems programExamTypeItems  = getExamTypeKey(themeDisplay, programType);
		logger.info("programExamTypeItems  "+programExamTypeItems);
		if (Validator.isNotNull(programExamTypeItems) && Validator.isNotNull(programExamTypeItems.getItems())
				&& !programExamTypeItems.getItems().isEmpty()) {
			for (ProgramExamType items : programExamTypeItems.getItems()) {
				logger.info("items.getExamtype()"+items.getExamType());
				JSONObject object = JSONFactoryUtil.createJSONObject();
				object.put("examType", items.getExamType());
				object.put("examTypeName", commonApi.getListTypeEntryByListTypeItemKey(LRPicklistConstants.PL_EXAM_TYPE, items.getExamType(), themeDisplay.getCompanyId()).getName());
				jsonArray.put(object);
			}
			logger.info("jsonArray   "+jsonArray.toJSONString());
		}
		resourceResponse.getWriter().write(jsonArray.toString());
		
	}
	
	public ProgramExamTypeItems getExamTypeKey(ThemeDisplay themeDisplay, long programType)
			throws UnsupportedEncodingException {
		String programExamTypeMasterUrl =  themeDisplay.getPortalURL() + LRObjectURL.EXAM_TYPE_URL  + CommonConstants.SCOPES + StringPool.SLASH + 
				themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=programTypeId" 
				+URLEncoder.encode(" eq " + programType, StandardCharsets.UTF_8);
		String programExamTypeMasterUrlMasterUrlResponse = commonApi.getData(programExamTypeMasterUrl);
		logger.info("programExamTypeMasterUrlMasterUrlResponse::" + programExamTypeMasterUrl);
		logger.info("ExamTypeEligibilityMasterUrlResponse==============="+programExamTypeMasterUrlMasterUrlResponse);
		return CustomObjectMapperUtil.readValue(programExamTypeMasterUrlMasterUrlResponse, ProgramExamTypeItems.class);
	}

	@Reference
	private OMSBCommonApi commonApi;

	@Reference
	private OMSBHttpConnector omsbHttpConnector;

	private static final Log logger = LogFactoryUtil.getLog(ExamProgramTypeMVCResourceCommand.class);
}
