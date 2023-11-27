package gov.omsb.form.builder.portlet.action;

import static gov.omsb.form.builder.constants.FormBuilderConstants.DATA;
import static gov.omsb.form.builder.constants.FormBuilderConstants.ERROR;
import static gov.omsb.form.builder.constants.FormBuilderConstants.MESSAGE;
import static gov.omsb.form.builder.constants.FormBuilderConstants.STATUS;
import static gov.omsb.form.builder.constants.FormBuilderConstants.SUCCESS;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.form.builder.constants.FormBuilderConstants;
import gov.omsb.form.builder.constants.FormBuilderWebPortletKeys;
import gov.omsb.form.builder.constants.MVCCommandNames;
import gov.omsb.form.builder.model.RangeOptionMaster;
import gov.omsb.form.builder.portlet.util.DateUtil;
import gov.omsb.form.builder.portlet.util.RangeOptionMasterUtil;
import gov.omsb.form.builder.service.RangeOptionMasterLocalService;

@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + FormBuilderWebPortletKeys.OMSB_FORM_BUILDER,
	        "mvc.command.name=" + MVCCommandNames.GET_RANGE_OPTIONS
	    }, 
	    service = MVCResourceCommand.class
)


public class GetRangeOptionsMVCResourceCommand extends BaseMVCResourceCommand{

	private static final Log log = LogFactoryUtil.getLog(GetRangeOptionsMVCResourceCommand.class);
	
	public static final String MONTH_DATE_FORMAT = "MMM-dd-yyyy";
	
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		log.info("### Getting range Options ###");
		JSONObject responseObj = JSONFactoryUtil.createJSONObject();
		PrintWriter writer = null;
		List<RangeOptionMaster> rangeOptionMasterList = rangeOptionMasterLocalService.getRangeOptionMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		try {
			writer = resourceResponse.getWriter();
			if(Validator.isNotNull(rangeOptionMasterList) && rangeOptionMasterList.size() > 0) {
				JSONArray rangeOptionsArr = JSONFactoryUtil.createJSONArray();
				JSONObject rangeOptionJsonObj = null;
				int index = 1;
				for(RangeOptionMaster rangeOption : rangeOptionMasterList) {
					rangeOptionJsonObj = JSONFactoryUtil.createJSONObject();
					rangeOptionJsonObj.put(FormBuilderConstants.RANGE_OPTION_ID, rangeOption.getRangeOptionId());
					rangeOptionJsonObj.put(FormBuilderConstants.SR_NO, index);
					rangeOptionJsonObj.put(FormBuilderConstants.RANGE_OPTION_NAME, rangeOption.getRangeOptionName());
					rangeOptionJsonObj.put(FormBuilderConstants.CREATEDBY, RangeOptionMasterUtil.getUserName(rangeOption.getCreatedBy()));
					rangeOptionJsonObj.put(FormBuilderConstants.CREATEDDATE, DateUtil.formatDate(rangeOption.getCreatedDate(), MONTH_DATE_FORMAT));
					rangeOptionJsonObj.put(FormBuilderConstants.MODIFIEDBY, RangeOptionMasterUtil.getUserName(rangeOption.getModifiedBy()));
					rangeOptionJsonObj.put(FormBuilderConstants.MODIFIEDDATE, DateUtil.formatDate(rangeOption.getModifiedDate(), MONTH_DATE_FORMAT));
					rangeOptionJsonObj.put(FormBuilderConstants.RANGE_OPTIONS, rangeOption.getRangeOptions());
					rangeOptionsArr.put(rangeOptionJsonObj);
					index++;
				}
				responseObj.put(DATA, rangeOptionsArr.toJSONString());
				responseObj.put(STATUS, SUCCESS);
			}
		} catch (IOException io) {
			log.error("Error while getting writer");
			responseObj.put(STATUS, ERROR);
			responseObj.put(MESSAGE, "Error occured while fetching range option data.");
		} finally {
			writer.write(responseObj.toString());
			writer.close();
		}
	}

	@Reference
	private RangeOptionMasterLocalService rangeOptionMasterLocalService;
}
