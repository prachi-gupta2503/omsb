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
import gov.omsb.master.web.portlet.dto.SectionFunction;
import gov.omsb.master.web.portlet.dto.SectionFunctionItems;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbMasterPortletKeys.OMSBMASTER,
		"mvc.command.name=" + MVCCommandNames.SECTION_RESOURCE_COMMAND }, service = MVCResourceCommand.class)
public class SectionFunctionMVCResourceCommad extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		logger.info("SectionFunctionMVCResourceCommad Started ()");
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String section = ParamUtil.getString(resourceRequest, "section");
		logger.info("section   " + section);
		SectionFunctionItems functionItems = getfunctionBySection(themeDisplay, section);
		logger.info("functionItems   " + functionItems);
		if (Validator.isNotNull(functionItems) && Validator.isNotNull(functionItems.getItems())
				&& !functionItems.getItems().isEmpty()) {
			for (SectionFunction items : functionItems.getItems()) {
				JSONObject object = JSONFactoryUtil.createJSONObject();
				ListTypeEntry entry = omsbCommonApi.getListTypeEntryByListTypeItemKey(MVCCommandNames.PL_FUNCTION,
						items.getFunctionId(), themeDisplay.getCompanyId());
				if (Validator.isNotNull(entry)) {
					object.put("functionId", entry.getName(themeDisplay.getLocale()));
					object.put("functionkey", entry.getKey());
					jsonArray.put(object);
				}
			}
			logger.info("jsonArray   " + jsonArray.toJSONString());
		}
		resourceResponse.getWriter().write(jsonArray.toString());
	}

	public SectionFunctionItems getfunctionBySection(ThemeDisplay themeDisplay, String section)
			throws UnsupportedEncodingException {
		String sectionFunctionUrl = themeDisplay.getPortalURL() + MVCCommandNames.SECTION_FUNCTION_URL
				+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION
				+ "filter=sectionId" + URLEncoder.encode(" eq " + "'" + section + "'", StandardCharsets.UTF_8);
		
		String sectionFunctionUrlResponse = omsbCommonApi.getData(sectionFunctionUrl);
		logger.info("sectionFunctionUrl::" + sectionFunctionUrl);
		logger.info("sectionFunctionUrlResponse===============" + sectionFunctionUrlResponse);
		return CustomObjectMapperUtil.readValue(sectionFunctionUrlResponse, SectionFunctionItems.class);
	}

	private static final Log logger = LogFactoryUtil.getLog(SectionFunctionMVCResourceCommad.class);

	@Reference(unbind = "-")
	private OMSBHttpConnector oMSBHttpConnector;
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

}
