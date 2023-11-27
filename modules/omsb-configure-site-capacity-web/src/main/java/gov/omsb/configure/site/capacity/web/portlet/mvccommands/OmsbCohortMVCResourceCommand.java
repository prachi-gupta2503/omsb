package gov.omsb.configure.site.capacity.web.portlet.mvccommands;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.configure.site.capacity.web.constants.OmsbConfigureSiteCapacityWebPortletKeys;
import gov.omsb.tms.model.ProgramDurationDetails;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;

/**
 * 
 * @author Aditya Meghnathi
 *
 */
@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbConfigureSiteCapacityWebPortletKeys.OMSBCONFIGURESITECAPACITYWEB,
		"mvc.command.name=/getCohortURL" }, service = MVCResourceCommand.class)
public class OmsbCohortMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		_logger.info("OmsbCohortMVCResourceCommand doServeResource :::");
		long programMasterId = ParamUtil.get(resourceRequest, OmsbConfigureSiteCapacityWebPortletKeys.PROGRAM, 0);
		List<ProgramDurationDetails> programDurationDetails = new ArrayList<>(programDurationDetailsLocalService
				.findProgramDurationByProgramId(programMasterId));
		
        Collections.sort(programDurationDetails, Comparator.comparing(ProgramDurationDetails::getAyApplicableForm));
        
		JSONArray resultJsonArray = JSONFactoryUtil.createJSONArray();
		programDurationDetails.forEach(programDuration -> {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put(OmsbConfigureSiteCapacityWebPortletKeys.PROG_DURATION_ID,
					programDuration.getProgDurationId());
			jsonObject.put(OmsbConfigureSiteCapacityWebPortletKeys.AY_APPLICATION_FORM,
					programDuration.getAyApplicableForm());
			resultJsonArray.put(jsonObject);
		});
		JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, resultJsonArray);
	}

	@Reference
	private ProgramDurationDetailsLocalService programDurationDetailsLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbCohortMVCResourceCommand.class.getName());

}
