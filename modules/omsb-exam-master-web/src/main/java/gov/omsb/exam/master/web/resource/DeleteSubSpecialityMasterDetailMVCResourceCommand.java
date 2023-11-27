package gov.omsb.exam.master.web.resource;

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

import gov.omsb.exam.master.web.constants.MVCCommandNames;
import gov.omsb.exam.master.web.constants.OmsbExamMasterWebPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbExamMasterWebPortletKeys.OMSBEXAMMASTERWEB,
		"mvc.command.name="
				+ MVCCommandNames.DELETE_OMSB_EXAM_SUB_SPECIALITY_MASTER_DETAILS }, service = MVCResourceCommand.class)

public class DeleteSubSpecialityMasterDetailMVCResourceCommand extends BaseMVCResourceCommand {

	private static final Log logger = LogFactoryUtil.getLog(DeleteSubSpecialityMasterDetailMVCResourceCommand.class);

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

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
