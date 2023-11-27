package gov.omsb.my.schedule.web.portlet.mvccommands;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.my.schedule.web.constants.OmsbMyScheduleWebPortletKeys;
import gov.omsb.tms.model.BlocksMetadataDetailsRel;
import gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel;
import gov.omsb.tms.model.ProgdurationTraineelevelBlocksLevelTypeRel;
import gov.omsb.tms.service.BlocksMetadataDetailsRelLocalService;
import gov.omsb.tms.service.FacultyRotationTsBlockDetailsRelLocalService;
import gov.omsb.tms.service.ProgdurationRotationTrainingsitesRelLocalService;
import gov.omsb.tms.service.ProgdurationTraineelevelBlocksLevelTypeRelLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbMyScheduleWebPortletKeys.OMSBMYSCHEDULEWEB,
		"mvc.command.name="
				+ OmsbMyScheduleWebPortletKeys.GET_FACULTY_SCHEDULE_VIEW_MVC_RESOURCE_COMMAND }, service = MVCResourceCommand.class)

public class OmsbMyScheduleGetFilterScheduleMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long traineeLevelId = ParamUtil.get(resourceRequest, OmsbMyScheduleWebPortletKeys.TRAINEE_LEVEL,
				GetterUtil.DEFAULT_LONG);
		long cohortId = ParamUtil.get(resourceRequest, OmsbMyScheduleWebPortletKeys.COHORT_ID, GetterUtil.DEFAULT_LONG);

		Set<Long> progDurationRotationTsRelIdList = new HashSet<>();
		facultyRotationTsBlockDetailsRelLocalService.findByFacultyId(themeDisplay.getUserId())
				.forEach(facultyRotationTsBlockDetailsRel -> {
					ProgdurationRotationTrainingsitesRel progdurationRotationTrainingsitesRel;
					try {
						progdurationRotationTrainingsitesRel = progdurationRotationTrainingsitesRelLocalService
								.getProgdurationRotationTrainingsitesRel(
										facultyRotationTsBlockDetailsRel.getProgDurationRotationTsRelId());
						if (progdurationRotationTrainingsitesRel.getProgramDurationId() == cohortId) {
							progDurationRotationTsRelIdList
									.add(progdurationRotationTrainingsitesRel.getProgdurationRotationTsRelId());
						}
					} catch (PortalException e) {
						_logger.error(e);
					}
				});

		JSONObject resultObject = JSONFactoryUtil.createJSONObject();
		resultObject.put(OmsbMyScheduleWebPortletKeys.PROG_DURATION_ROTATION_TRAINING_SITE_OBJ,
				getFacultyProgdurationRotationTrainingsitesRelMapping(progDurationRotationTsRelIdList, traineeLevelId));
		resultObject.put(CommonConstants.SUCCESS, true);

		JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, resultObject);
	}

	/**
	 * 
	 * @param programIds
	 * @param themeDisplay
	 * @return
	 */
	private JSONObject getFacultyProgdurationRotationTrainingsitesRelMapping(Set<Long> progdurationTlBlocksLtIdList,
			long traineeLevelId) {

		JSONObject progdurationRotationTrainingsitesRelObject = JSONFactoryUtil.createJSONObject();
		JSONArray progdurationRotationTrainingsitesRelObjArray = JSONFactoryUtil.createJSONArray();
		for (Long progdurationTlBlocksLtId : progdurationTlBlocksLtIdList) {

			JSONObject progdurationRotationTrainingsitesRelObj = JSONFactoryUtil.createJSONObject();

			getProgdurationTlBlocksLtIdRotationCodeMapping(progdurationTlBlocksLtId,
					progdurationRotationTrainingsitesRelObj);

			List<String> blockDetails = new ArrayList<>();
			facultyRotationTsBlockDetailsRelLocalService.findByProgDurationRotationTsRelId(progdurationTlBlocksLtId)
					.stream().forEach(facultyRotationTsBlockDetailsRel -> {
						BlocksMetadataDetailsRel blocksMetadataDetailsRel;
						try {
							blocksMetadataDetailsRel = blocksMetadataDetailsRelLocalService.getBlocksMetadataDetailsRel(
									facultyRotationTsBlockDetailsRel.getBlocksMetadataDetailsRelId());

							ProgdurationTraineelevelBlocksLevelTypeRel progdurationTraineelevelBlocksLevelTypeRel = progdurationTraineelevelBlocksLevelTypeRelLocalService
									.getProgdurationTraineelevelBlocksLevelTypeRel(
											blocksMetadataDetailsRel.getProgDurationTlBlocksLtId());

							if (progdurationTraineelevelBlocksLevelTypeRel.getTraineeLevelId() == traineeLevelId) {
								String blockNo = blocksMetadataDetailsRel.getBlockNo().split(StringPool.DASH)[1];
								blockDetails.add(blockNo);
							}
						} catch (PortalException e) {
							_logger.error(e);
						}
					});

			JSONArray blockArray = JSONFactoryUtil.createJSONArray();
			for (long i = 1; i <= 13; i++) {
				if (blockDetails.contains(String.valueOf(i))) {
					blockArray.put(Boolean.TRUE.toString());
				} else {
					blockArray.put(Boolean.FALSE.toString());
				}
			}

			progdurationRotationTrainingsitesRelObj.put(OmsbMyScheduleWebPortletKeys.PROG_CODE_BLOCKS_ARRAY,
					blockArray);
			progdurationRotationTrainingsitesRelObjArray.put(progdurationRotationTrainingsitesRelObj);
		}

		progdurationRotationTrainingsitesRelObject.put(
				OmsbMyScheduleWebPortletKeys.PROG_DURATION_ROTATION_TRAINING_SITE_REL_OBJ_ARRAY,
				progdurationRotationTrainingsitesRelObjArray);

		return progdurationRotationTrainingsitesRelObject;

	}

	private JSONObject getProgdurationTlBlocksLtIdRotationCodeMapping(long progdurationTlBlocksLtId,
			JSONObject progdurationRotationTrainingsitesRelObj) {

		ProgdurationRotationTrainingsitesRel progdurationRotationTrainingsitesRel;
		try {
			progdurationRotationTrainingsitesRel = progdurationRotationTrainingsitesRelLocalService
					.getProgdurationRotationTrainingsitesRel(progdurationTlBlocksLtId);

			progdurationRotationTrainingsitesRelObj.put(OmsbMyScheduleWebPortletKeys.PROG_DURATION_ROTATION_TS_REL_ID,
					progdurationRotationTrainingsitesRel.getProgdurationRotationTsRelId());
			progdurationRotationTrainingsitesRelObj.put(OmsbMyScheduleWebPortletKeys.PROG_ROTATION_TS_CODE,
					progdurationRotationTrainingsitesRel.getProgCodeRsnSiteCode() + StringPool.SPACE
							+ StringPool.OPEN_PARENTHESIS + progdurationRotationTrainingsitesRel.getNoOfSlots()
							+ StringPool.CLOSE_PARENTHESIS);

		} catch (PortalException e) {
			_logger.info(e);
		}

		return progdurationRotationTrainingsitesRelObj;
	}

	private static final Log _logger = LogFactoryUtil.getLog(OmsbMyScheduleGetFilterScheduleMVCResourceCommand.class);

	@Reference
	private BlocksMetadataDetailsRelLocalService blocksMetadataDetailsRelLocalService;

	@Reference
	private FacultyRotationTsBlockDetailsRelLocalService facultyRotationTsBlockDetailsRelLocalService;

	@Reference
	private ProgdurationTraineelevelBlocksLevelTypeRelLocalService progdurationTraineelevelBlocksLevelTypeRelLocalService;

	@Reference
	private ProgdurationRotationTrainingsitesRelLocalService progdurationRotationTrainingsitesRelLocalService;

}
