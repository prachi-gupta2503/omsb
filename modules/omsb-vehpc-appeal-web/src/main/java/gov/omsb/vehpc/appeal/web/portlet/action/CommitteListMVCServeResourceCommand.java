package gov.omsb.vehpc.appeal.web.portlet.action;

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
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyDecision;
import gov.omsb.vehpc.appeal.dto.web.EquivalencyLevel;
import gov.omsb.vehpc.appeal.util.HeaderUtil;
import gov.omsb.vehpc.appeal.web.constants.AppealConstants;
import gov.omsb.vehpc.appeal.web.constants.OmsbVehpcAppealWebPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbVehpcAppealWebPortletKeys.OMSBVEHPCAPPEALWEB,
		"mvc.command.name=" + AppealConstants.SEARCH_COMMITTE_LIST }, service = MVCResourceCommand.class

)
public class CommitteListMVCServeResourceCommand extends BaseMVCResourceCommand {
//declaring varibLE 

	String baseURL;
	String modifiedPersonUrl = null;
	String documentinfoResponse = null;

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		logger.info("serve resource() >>>> method started>>>>");
		JSONArray jsonArray = null;
//		retreiving the value from jsp 
		String dFFileName = ParamUtil.getString(resourceRequest, "certificate");
		String employer = ParamUtil.getString(resourceRequest, "employer");
		String employee = ParamUtil.getString(resourceRequest, "employee");
		String level = ParamUtil.getString(resourceRequest, "level");
		logger.info(
				dFFileName + " certificate" + employer + "    employer" + employee + "   employee" + level + "level");
//		url initializing		

		String url = themeDisplay.getPortalURL() + AppealConstants.EQUIVALENCY_DECISION_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + themeDisplay.getScopeGroupId();

		String response = omsbHttpConnector.executeGet(url, "", headerUtil.getHeaders());
		EquivalencyDecision equivalencyDecision = CustomObjectMapperUtil.readValue(response, EquivalencyDecision.class);
		EquivalencyLevel equivalencyLevel = equivalencyDecision.getEquivalencyLevelId();
		String Eqlevel = equivalencyLevel.getKey();
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(response);
		JSONArray jsonArr = JSONFactoryUtil.createJSONArray();
		if (level.equalsIgnoreCase(Eqlevel) && level != null) {
			jsonArr.put(jsonObject);

		}
		resourceResponse.getWriter().write(jsonArr.toString());
		logger.info(jsonArr.toString());

	}

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference(unbind = "-")
	private OMSBHttpConnector omsbHttpConnector;
	
	@Reference
	private HeaderUtil headerUtil;

	private static final Log logger = LogFactoryUtil.getLog(CommitteListMVCServeResourceCommand.class);

}
