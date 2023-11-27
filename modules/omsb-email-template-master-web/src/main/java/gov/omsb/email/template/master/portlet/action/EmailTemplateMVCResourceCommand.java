/**
 * 
 */
package gov.omsb.email.template.master.portlet.action;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.email.template.master.common.api.OMSBEmailTemplateMasterCommonApi;
import gov.omsb.email.template.master.common.constants.OMSBEmailTemplateMasterCommonConstants;
import gov.omsb.email.template.master.constants.EmailTemplateMasterConstants;
import gov.omsb.email.template.master.constants.EmailTemplateMasterPortletKeys;
import gov.omsb.email.template.master.model.EmailTemplateMaster;
import gov.omsb.email.template.master.service.EmailTemplateMasterLocalService;

/**
 * @author Niddhi Thacker
 *
 */
@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + EmailTemplateMasterPortletKeys.OMSB_EMAIL_TEMPLATE_MASTER_PORTLET,
	        "mvc.command.name=/view/emailTemplate",
	    }, 
	    service = MVCResourceCommand.class
)
public class EmailTemplateMVCResourceCommand extends BaseMVCResourceCommand{

	private static final Log log = LogFactoryUtil.getLog(EmailTemplateMVCResourceCommand.class);
	
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		log.info("Fetching EmailTemplate data ...");
		
		HashMap<String, String> dataTableParams = omsbEmailTemplateMasterCommonApi.getDataTableParams(resourceRequest);
		int draw = Integer.parseInt(dataTableParams.get(OMSBEmailTemplateMasterCommonConstants.DRAW));
		long total = 0;
		JSONObject responseObj = JSONFactoryUtil.createJSONObject();
		JSONArray emailTemplateMastersArray = JSONFactoryUtil.createJSONArray();
		PrintWriter writer = null;
		try {
			writer = resourceResponse.getWriter();
			
			List<EmailTemplateMaster> emailTemplateMasterList = emailTemplateMasterLocalService.getEmailTemplateMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			if(!emailTemplateMasterList.isEmpty()) {
				total = emailTemplateMasterLocalService.getEmailTemplateMastersCount();
				JSONObject emailTemplateMasterObj;
				for (EmailTemplateMaster emailTemplateMaster : emailTemplateMasterList) {
					emailTemplateMasterObj = JSONFactoryUtil.createJSONObject();
					emailTemplateMasterObj.put(OMSBEmailTemplateMasterCommonConstants.ID, emailTemplateMaster.getTemplateId());
					emailTemplateMasterObj.put(EmailTemplateMasterConstants.TEMPLATE_NAME, emailTemplateMaster.getTemplateName());
					emailTemplateMasterObj.put(OMSBEmailTemplateMasterCommonConstants.CREATED_BY, omsbEmailTemplateMasterCommonApi.getUserName(emailTemplateMaster.getCreatedBy()));
					emailTemplateMasterObj.put(OMSBEmailTemplateMasterCommonConstants.CREATED_DATE_TIME,omsbEmailTemplateMasterCommonApi.getFormatedDateTime(emailTemplateMaster.getCreatedDate()));
					emailTemplateMasterObj.put(OMSBEmailTemplateMasterCommonConstants.MODIFIED_BY, omsbEmailTemplateMasterCommonApi.getUserName(emailTemplateMaster.getModifiedBy()));
					emailTemplateMasterObj.put(OMSBEmailTemplateMasterCommonConstants.MODIFIED_DATE_TIME, omsbEmailTemplateMasterCommonApi.getFormatedDateTime(emailTemplateMaster.getModifiedDate()));
					emailTemplateMasterObj.put(OMSBEmailTemplateMasterCommonConstants.ACTION, StringPool.BLANK);
					emailTemplateMastersArray.put(emailTemplateMasterObj);
				}
			}
			responseObj.put(OMSBEmailTemplateMasterCommonConstants.RECORDS_TOTAL, total);
			responseObj.put(OMSBEmailTemplateMasterCommonConstants.RECORDS_FILTERED, total);
			responseObj.put(OMSBEmailTemplateMasterCommonConstants.DATA, emailTemplateMastersArray.toString());
			responseObj.put(OMSBEmailTemplateMasterCommonConstants.DRAW, draw);
			responseObj.put(OMSBEmailTemplateMasterCommonConstants.STATUS, OMSBEmailTemplateMasterCommonConstants.SUCCESS);
		} catch (IOException e) {
			log.error("Error occured while fetching email templates -> " + e.getMessage());
			responseObj.put(OMSBEmailTemplateMasterCommonConstants.STATUS, "error");
			responseObj.put(OMSBEmailTemplateMasterCommonConstants.MESSAGE, "Error occured while fetching email templates.");
		} finally {
			writer.write(responseObj.toString());
			writer.close();
			
			log.info("Email template data retrieved successfully");
		}
		
	}
	
	@Reference
	private volatile EmailTemplateMasterLocalService emailTemplateMasterLocalService;
	
	@Reference
	private OMSBEmailTemplateMasterCommonApi omsbEmailTemplateMasterCommonApi;

}
