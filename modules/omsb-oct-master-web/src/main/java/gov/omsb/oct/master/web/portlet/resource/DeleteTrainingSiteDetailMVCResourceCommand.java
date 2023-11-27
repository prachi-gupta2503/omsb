package gov.omsb.oct.master.web.portlet.resource;

import com.liferay.list.type.model.ListTypeEntry;
import com.liferay.list.type.service.ListTypeEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.PrintWriter;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import gov.omsb.oct.master.web.constants.MVCCommandNames;
import gov.omsb.oct.master.web.constants.OmsbOctMasterWebPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctMasterWebPortletKeys.OMSBOCTMASTERWEB,
		"mvc.command.name=" + MVCCommandNames.DELETE_OCT_TRAINING_SITE_DETAILS }, service = MVCResourceCommand.class)

public class DeleteTrainingSiteDetailMVCResourceCommand extends BaseMVCResourceCommand {

	private static final Log logger = LogFactoryUtil.getLog(DeleteTrainingSiteDetailMVCResourceCommand.class);

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		logger.info("DeleteEducationDetailMVCResourceCommand Invoked");
		long id = ParamUtil.getLong(resourceRequest, "id");

		JSONArray response = JSONFactoryUtil.createJSONArray();
		JSONObject jsonData = JSONFactoryUtil.createJSONObject();
		try {
			ListTypeEntry listEntry = ListTypeEntryLocalServiceUtil.deleteListTypeEntry(id);
			if (Validator.isNotNull(listEntry)) {
				jsonData.put("status", "success");
			}
		} catch (PortalException e) {
			logger.error(e.getMessage());
			jsonData.put("status", "fail");
		}

		response.put(jsonData);
		resourceResponse.setContentType("application/json");
		PrintWriter writer = resourceResponse.getWriter();
		writer.println(jsonData.toString());
	}

}