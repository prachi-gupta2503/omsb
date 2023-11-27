package gov.omsb.setup.procedures.web.mvcactions;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.setup.procedures.web.constants.OmsbSetupProceduresWebPortletKeys;
import gov.omsb.tms.model.ProgdurationRotationTraineelevelBlocksRel;
import gov.omsb.tms.model.TraineeLevelMaster;
import gov.omsb.tms.service.ProgdurationRotationTraineelevelBlocksRelLocalService;
import gov.omsb.tms.service.TraineeLevelMasterLocalService;

/**
 * 
 * @author Aditya Meghnathi
 *
 */
@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbSetupProceduresWebPortletKeys.OMSBSETUPPROCEDURESWEB,
		"mvc.command.name=/getTraineeLevelURL" }, service = MVCResourceCommand.class)
public class OmsbTraineeLevelMVCResourceCommand extends BaseMVCResourceCommand {

	@SuppressWarnings("deprecation")
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		_logger.info("OmsbTraineeLevelMVCResourceCommand doServeResource :::");
		String programDurationId = resourceRequest.getParameter(OmsbSetupProceduresWebPortletKeys.PROGRAM_DURATION);
		List<ProgdurationRotationTraineelevelBlocksRel> progdurationRotationTraineelevelBlocksRels = progdurationRotationTraineelevelBlocksRelLocalService
				.findTraineeLevelByDurationId(Long.parseLong(programDurationId));

		List<ProgdurationRotationTraineelevelBlocksRel> pdRotationTlBlocksRel = uniqueBy(
				progdurationRotationTraineelevelBlocksRels,
				ProgdurationRotationTraineelevelBlocksRel::getTraineeLevelId);
		pdRotationTlBlocksRel.sort(Comparator.comparing(ProgdurationRotationTraineelevelBlocksRel::getTraineeLevelId));

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (ProgdurationRotationTraineelevelBlocksRel pdRotationTraineelevel : pdRotationTlBlocksRel) {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			TraineeLevelMaster traineeLevelMasters = traineeLevelMasterLocalService
					.getTraineeLevelMaster(pdRotationTraineelevel.getTraineeLevelId());
			jsonObject.put("traineeLevelId", traineeLevelMasters.getTraineeLevelMasterId());
			jsonObject.put("traineeLevelName", traineeLevelMasters.getTraineeLevelName());
			jsonArray.put(jsonObject);
		}
		resourceResponse.getWriter().write(jsonArray.toString());
	}

	private static <T> List<T> uniqueBy(List<T> objects, Function<T, Object> keyExtractor) {
		return new ArrayList<>(objects.stream().sorted()
				.collect(Collectors.toMap(keyExtractor, Function.identity(), (a, b) -> a, LinkedHashMap::new))
				.values());
	}

	@Reference
	private TraineeLevelMasterLocalService traineeLevelMasterLocalService;

	@Reference
	private ProgdurationRotationTraineelevelBlocksRelLocalService progdurationRotationTraineelevelBlocksRelLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbTraineeLevelMVCResourceCommand.class.getName());

}
