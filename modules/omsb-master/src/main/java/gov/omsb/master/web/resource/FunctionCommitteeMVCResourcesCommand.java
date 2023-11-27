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
import gov.omsb.master.web.portlet.dto.SectionFunction;
import gov.omsb.master.web.portlet.dto.SectionFunctionItems;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbMasterPortletKeys.OMSBMASTER,
		"mvc.command.name="
				+ MVCCommandNames.COMMITTE_FUNCTION_RESOURCE_COMMAND}, service = MVCResourceCommand.class)
public class FunctionCommitteeMVCResourcesCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		logger.info("FunctionCommitteeMVCResourcesCommand Started()");
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String functionId = ParamUtil.getString(resourceRequest, "functionId");
		logger.info("functionId "+functionId);
		SectionFunctionItems functionCommitteeItems = getCommitteeByfunction(themeDisplay, functionId);
		logger.info("functionCommitteeItems "+functionCommitteeItems);
		if (Validator.isNotNull(functionCommitteeItems) && Validator.isNotNull(functionCommitteeItems.getItems())
				&& !functionCommitteeItems.getItems().isEmpty()) {
			for (SectionFunction items : functionCommitteeItems.getItems()) {
				JSONObject object = JSONFactoryUtil.createJSONObject();
				ListTypeEntry entry = omsbCommonApi.getListTypeEntryByListTypeItemKey(MVCCommandNames.PL_COMMITTEE,
						items.getCommitteeId(), themeDisplay.getCompanyId());
				if (Validator.isNotNull(entry)) {
					object.put("committeeId", entry.getName(themeDisplay.getLocale()));
					object.put("committeeKey", entry.getKey() );
					jsonArray.put(object);
				}
			}
			logger.info("jsonArray   " + jsonArray.toJSONString());
		}
		resourceResponse.getWriter().write(jsonArray.toString());
		
	}
	
	public SectionFunctionItems getCommitteeByfunction(ThemeDisplay themeDisplay, String functionId)
			throws UnsupportedEncodingException {
		String functionCommitteeUrl = themeDisplay.getPortalURL() + MVCCommandNames.SECTION_FUNCTION_URL
				+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION
				+ "filter=functionId" + URLEncoder.encode(" eq " + "'" + functionId + "'", StandardCharsets.UTF_8);
		String functionCommitteeUrlResponse = omsbCommonApi.getData(functionCommitteeUrl);
		logger.info("functionCommitteeUrl::" + functionCommitteeUrl);
		logger.info("functionCommitteeUrlResponse===============" + functionCommitteeUrlResponse);
		return CustomObjectMapperUtil.readValue(functionCommitteeUrlResponse, SectionFunctionItems.class);
	}

	private static final Log logger = LogFactoryUtil.getLog(FunctionCommitteeMVCResourcesCommand.class);
	
	@Reference(unbind = "-")
	private OMSBHttpConnector oMSBHttpConnector;
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
}
