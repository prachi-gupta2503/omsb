package gov.omsb.form.builder.portlet.action;

import static gov.omsb.form.builder.constants.FormBuilderConstants.MAPPING;
import static gov.omsb.form.builder.constants.FormBuilderConstants.MAPPINGS;
import static gov.omsb.form.builder.constants.FormBuilderConstants.STATUS;
import static gov.omsb.form.builder.constants.FormBuilderConstants.SUCCESS;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.form.builder.constants.FormBuilderWebPortletKeys;
import gov.omsb.form.builder.portlet.util.FormDataUtil;
import gov.omsb.form.builder.service.FormDefinitionLocalService;


@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + FormBuilderWebPortletKeys.OMSB_FORM_BUILDER,
	        "mvc.command.name=" + "/get/master-data"
	    }, 
	    service = MVCResourceCommand.class
)
public class GetMasterDataValueMVCResourceCommand extends BaseMVCResourceCommand {

	private static final Log log = LogFactoryUtil.getLog(GetMasterDataValueMVCResourceCommand.class);
	
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		log.info("in serve resource");
		String cmd = ParamUtil.getString(resourceRequest, "cmd");
		JSONObject responseObj = JSONFactoryUtil.createJSONObject();
		PrintWriter writer = null;
		if("getMasterData".equalsIgnoreCase(cmd)) {
			String formName = ParamUtil.getString(resourceRequest, "formName");
			String tableName = ParamUtil.getString(resourceRequest, "tableName");
			String selectedValueName = ParamUtil.getString(resourceRequest, "valueName");
			String valueName = tableName + "_" + selectedValueName;
			String recordId = ParamUtil.getString(resourceRequest, "recordId");
			String formDefinitionIdStr = ParamUtil.getString(resourceRequest, "formDefinitionId");
			Long formDefinitionId = Long.parseLong(formDefinitionIdStr);
			boolean createNewMappingTable = ParamUtil.getBoolean(resourceRequest, "createNewMappingTable");
			boolean createFormMappingsTable = ParamUtil.getBoolean(resourceRequest, "createFormMappingsTable");
			
			String masterTableName = StringPool.BLANK;
			if(createNewMappingTable) {
				if(tableName.endsWith("_")) {
					masterTableName = (FormDataUtil.formatFormName(formName)+"_"+tableName+MAPPING);
				} else {
					masterTableName = (FormDataUtil.formatFormName(formName)+"_"+tableName+"_"+MAPPING);
				}
			} else if(createFormMappingsTable) {
				masterTableName = (FormDataUtil.formatFormName(formName)+"_"+MAPPINGS);
			}
			JSONArray dataJson = formDefinitionLocalService.getDataSelectQuery(masterTableName, valueName+",recordid", "where recordid='"+recordId+"' and formdefinitionid="+formDefinitionId);
			responseObj.put("selectedValues", dataJson);
			responseObj.put(STATUS, SUCCESS);
			try {
				writer = resourceResponse.getWriter();
			} catch (IOException io) {
				log.info("Error while getting writer");
			} finally {
				writer.write(responseObj.toString());
				writer.close();
			}
		}
	}
	
	@Reference
	private FormDefinitionLocalService formDefinitionLocalService;
}
