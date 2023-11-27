package gov.omsb.bylaw.rules.resource;

import com.liferay.list.type.model.ListTypeDefinition;
import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeDefinitionLocalService;
import com.liferay.list.type.service.ListTypeEntryLocalService;
import com.liferay.object.model.ObjectDefinition;
import com.liferay.object.model.ObjectEntry;
import com.liferay.object.service.ObjectDefinitionLocalService;
import com.liferay.object.service.ObjectEntryLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.CountryLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.bylaw.rules.constants.MVCCommands;
import gov.omsb.bylaw.rules.constants.OmsbBylawRulesPortletKeys;
import gov.omsb.bylaw.rules.dto.ObjectColumnNameItems;
import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.common.util.OmsbTmsCommonUtil;
import gov.omsb.tms.model.TraineeLevelMaster;
import gov.omsb.tms.service.TraineeLevelMasterLocalServiceUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbBylawRulesPortletKeys.OMSBBYLAWRULES,
		"mvc.command.name=" + MVCCommands.PARAMETER_VALUE_MAPPING }, service = MVCResourceCommand.class)
public class ParameterValueMappingMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		logger.info("ParameterValueMappingMVCResourceCommand started ()");
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String selectedParameter = ParamUtil.getString(resourceRequest, "selectedParameter");
		logger.info("selectedParameter  " + selectedParameter);
		String parameterType = selectedParameter.split("_")[0];
		logger.info("parameterType " + parameterType);

		if (parameterType.equalsIgnoreCase("PL")) {
			ListTypeDefinition definition = listTypeDefinitionLocalService
					.fetchListTypeDefinitionByExternalReferenceCode(selectedParameter, themeDisplay.getCompanyId());
			if (Validator.isNotNull(definition)) {
				List<ListTypeEntry> entries = listTypeEntryLocalService
						.getListTypeEntries(definition.getListTypeDefinitionId());
				for (ListTypeEntry entry : entries) {
					JSONObject jsonObject = createJsonObject(entry.getName(themeDisplay.getLocale()), entry.getName(themeDisplay.getLocale()));
					jsonArray.put(jsonObject);
				}
			}
		} else if (parameterType.equalsIgnoreCase("TAB") && (selectedParameter.equalsIgnoreCase("TAB_Country"))) {
			logger.info("TAB_Country inside ()");
			List<Country> countries = CountryLocalServiceUtil.getCountries(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			for (Country country : countries) {
				JSONObject object = JSONFactoryUtil.createJSONObject();
				object.put("key", country.getName(themeDisplay.getLocale()));
				object.put("name", country.getName(themeDisplay.getLocale()));
				jsonArray.put(object);
			}

		} else if (parameterType.equalsIgnoreCase("TAB")
				&& (selectedParameter.equalsIgnoreCase("TAB_trainee_level_master"))) {
			logger.info("TAB_trainee_level_master inside ()");
			List<TraineeLevelMaster> list = TraineeLevelMasterLocalServiceUtil.getTraineeLevelMasters(-1, -1);
			for (TraineeLevelMaster master : list) {
				JSONObject object = JSONFactoryUtil.createJSONObject();
				String traineeLevelName = OmsbTmsCommonUtil.getValueByLanguage(master.getTraineeLevelName(),
						OmsbTmsCommonConstants.TRAINEE_LEVEL_NAME, themeDisplay.getLocale().toString());
				object.put("key", traineeLevelName);
				object.put("name", traineeLevelName);
				jsonArray.put(object);
			}

		} else {

			ObjectColumnNameItems objectColumnNameItems = getParameterName(themeDisplay, selectedParameter);
			ObjectDefinition objectDefinition = objectDefinitionLocalService
					.getObjectDefinitionByExternalReferenceCode(selectedParameter, themeDisplay.getCompanyId());
			if (Validator.isNotNull(objectDefinition)) {
				List<ObjectEntry> entries = objectEntryLocalService.getObjectEntries(themeDisplay.getScopeGroupId(),
						objectDefinition.getObjectDefinitionId(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
				for (ObjectEntry objectEntry : entries) {
					String value = objectEntry.getValues().get(objectColumnNameItems.getItems().get(0).getFieldName())
							.toString();
					JSONObject obj = createJsonObject(value, value);
					jsonArray.put(obj);
				}
			}

		}
		resourceResponse.getWriter().write(jsonArray.toString());

	}

	public ObjectColumnNameItems getParameterName(ThemeDisplay themeDisplay, String objectERC) {
		String objectColummnUrl = themeDisplay.getPortalURL() + MVCCommands.RULE_ENGINE_OBJECT_COLUMN_NAME_URL
				+ CommonConstants.SCOPES + StringPool.SLASH + themeDisplay.getScopeGroupId() + StringPool.QUESTION
				+ "filter=objectERC" + URLEncoder.encode(" eq " + "'" + objectERC + "'", StandardCharsets.UTF_8);
		logger.info("objectColumn URl " + objectColummnUrl);
		String response = commonApi.getData(objectColummnUrl);
		logger.info("objectColumn Response " + response);
		return CustomObjectMapperUtil.readValue(response, ObjectColumnNameItems.class);
	}

	private JSONObject createJsonObject(String key, String name) {
		JSONObject object = JSONFactoryUtil.createJSONObject();
		object.put("key", key);
		object.put("name", name);
		return object;
	}

	private static final Log logger = LogFactoryUtil.getLog(ModuleParameterMVCResourceCommand.class);

	@Reference(unbind = "-")
	private OMSBCommonApi commonApi;

	@Reference(unbind = "-")
	private OMSBHttpConnector omsbHttpConnector;

	@Reference(unbind = "-")
	private ListTypeEntryLocalService listTypeEntryLocalService;

	@Reference(unbind = "-")
	private ListTypeDefinitionLocalService listTypeDefinitionLocalService;

	@Reference(unbind = "-")
	private ObjectDefinitionLocalService objectDefinitionLocalService;

	@Reference(unbind = "-")
	private ObjectEntryLocalService objectEntryLocalService;

}
