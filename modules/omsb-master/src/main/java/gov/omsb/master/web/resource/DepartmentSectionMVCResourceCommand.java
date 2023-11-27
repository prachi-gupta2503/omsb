package gov.omsb.master.web.resource;

import com.liferay.adaptive.media.exception.AMRuntimeException.UnsupportedEncodingException;
import com.liferay.list.type.model.ListTypeEntry;
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
import gov.omsb.master.web.portlet.dto.SectionDepartment;
import gov.omsb.master.web.portlet.dto.SectionDepartmentItems;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbMasterPortletKeys.OMSBMASTER,
		"mvc.command.name="
				+ MVCCommandNames.DEPARMENT_SECTION_RESOURCE_COMMAND}, service = MVCResourceCommand.class)
public class DepartmentSectionMVCResourceCommand extends BaseMVCResourceCommand{

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		logger.info("ProfessionSpecialityMVCResourceCommand Started ()");
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String department = ParamUtil.getString(resourceRequest, "department");
		SectionDepartmentItems departmentItems = getSectionByDepartment(themeDisplay, department);
		
		logger.info("departmentItems   "+ departmentItems);
		if (Validator.isNotNull(departmentItems) && Validator.isNotNull(departmentItems.getItems())
				&& !departmentItems.getItems().isEmpty()) {
			for (SectionDepartment items : departmentItems.getItems()) {
				JSONObject object = JSONFactoryUtil.createJSONObject();
				ListTypeEntry entry = omsbCommonApi.getListTypeEntryByListTypeItemKey("PL_SECTION", items.getSectionId(), themeDisplay.getCompanyId());
				if(Validator.isNotNull(entry)) {
					object.put("sectionId",entry.getName(themeDisplay.getLocale()));
					object.put("sectionKey",entry.getKey());
					jsonArray.put(object);
				}
				
			}
			logger.info("jsonArray   "+jsonArray.toJSONString());
		}
		resourceResponse.getWriter().write(jsonArray.toString());

		
	}
	
	public SectionDepartmentItems getSectionByDepartment(ThemeDisplay themeDisplay, String department)
			throws UnsupportedEncodingException {
		String sectionDepartmentUrl =  themeDisplay.getPortalURL() + MVCCommandNames.DEPARTMENT_SECTION_URL + CommonConstants.SCOPES + StringPool.SLASH + 
				themeDisplay.getScopeGroupId() + StringPool.QUESTION + "filter=departmentId" 
				+URLEncoder.encode(" eq " + "'" + department +"'", StandardCharsets.UTF_8);
		String sectionDepartmentUrlResponse = omsbCommonApi.getData(sectionDepartmentUrl);
		logger.info("sectionDepartmentUrl::" + sectionDepartmentUrl);
		logger.info("sectionDepartmentUrlResponse==============="+sectionDepartmentUrlResponse);
		return CustomObjectMapperUtil.readValue(sectionDepartmentUrlResponse, SectionDepartmentItems.class);
	}
	
	private static final Log logger = LogFactoryUtil.getLog(ProfessionSpecialityMVCResourceCommand.class);
	
	@Reference(unbind = "-")
	private OMSBHttpConnector oMSBHttpConnector;
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
}
