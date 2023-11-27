package gov.omsb.exam.master.web.resource;

import com.liferay.list.type.model.ListTypeDefinition;
import com.liferay.list.type.service.ListTypeDefinitionLocalService;
import com.liferay.list.type.service.ListTypeDefinitionLocalServiceUtil;
import com.liferay.list.type.service.ListTypeEntryLocalService;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
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
				+ MVCCommandNames.DELETE_PL_EXAM_TYPE_MVC_RESOURCE_COMMAND }, service = MVCResourceCommand.class)
public class DeleteExamTypePLMVCResourceCommand extends BaseMVCResourceCommand{

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String id = ParamUtil.getString(resourceRequest, "examTypeEntryId");
		long entryId = Long.valueOf(id);
		logger.info("entry id"+id);
		ListTypeDefinition listTypeDefinition;
		try {
			listTypeDefinition = listTypeDefinitionLocalService.getListTypeDefinitionByExternalReferenceCode(OmsbExamMasterWebPortletKeys.PL_EXAM_TYPE_ERC,
							themeDisplay.getCompanyId());
			if (Validator.isNotNull(listTypeDefinition)) {
				listTypeEntryLocalService.deleteListTypeEntry(entryId);
				JSONObject object = JSONFactoryUtil.createJSONObject();
				JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
				object.put("success", "deleted successfully");
				resourceResponse.getWriter().write(jsonArray.toString());
			}
			
		}catch(Exception e) {
			logger.error("error while deleting the EntryId of Exam type"+e.getMessage());
		}
	}

	private static final Log logger = LogFactoryUtil.getLog(DeleteExamTypePLMVCResourceCommand.class);
	@Reference(unbind = "-")
	private OMSBCommonApi commonApi;

	@Reference(unbind = "-")
	private OMSBHttpConnector omsbHttpConnector;
	
	@Reference(unbind = "-")
	private ListTypeEntryLocalService listTypeEntryLocalService;
	
	@Reference(unbind = "-")
	private ListTypeDefinitionLocalService listTypeDefinitionLocalService;
}
