package gov.omsb.duty.logging.web.commands;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.duty.logging.web.constants.DutyLogConfigurationPortletKeys;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.common.util.OmsbTmsCommonUtil;
import gov.omsb.tms.custom.dto.DutyLogViolationDTO;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.model.RotationMaster;
import gov.omsb.tms.model.TraineeLevelMaster;
import gov.omsb.tms.model.TrainingSitesMaster;
import gov.omsb.tms.service.DutyLogViolationLocalService;
import gov.omsb.tms.service.ProgramMasterLocalServiceUtil;
import gov.omsb.tms.service.RotationMasterLocalServiceUtil;
import gov.omsb.tms.service.TraineeLevelMasterLocalServiceUtil;
import gov.omsb.tms.service.TrainingSitesMasterLocalServiceUtil;

@Component(immediate = true, property = {
		"javax.portlet.name=" + DutyLogConfigurationPortletKeys.DUTYHOURSCONFIGURATION,
		"mvc.command.name=/search/dutyLogViolationData" }, service = MVCResourceCommand.class)
public class SearchDutyLogViolationMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		LOGGER.info("<=================SearchDutyLogViolationMVCResourceCommand Called=======> ");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();
		long createdBy = themeDisplay.getUserId();

		Long traineeCohortDetailsId = ParamUtil.getLong(resourceRequest, "traineeCohortDetailsId");
		Long programMasterId = ParamUtil.getLong(resourceRequest, "programMasterId");
		Long traineeId = ParamUtil.getLong(resourceRequest, "traineeId");
		long traineeLevelId = ParamUtil.getLong(resourceRequest, "traineeLevelId");

		LOGGER.info("groupId : =======> " + groupId);
		LOGGER.info("createdBy : =======> " + createdBy);
		LOGGER.info("traineeLevelId : =======> " + traineeLevelId);
		LOGGER.info("programMasterId : =======> " + programMasterId);
		LOGGER.info("traineeId : =======> " + traineeId);
		LOGGER.info("traineeCohortDetailsId : =======> " + traineeCohortDetailsId);

		if (traineeLevelId == 0 && programMasterId == 0 && traineeId == 0 && traineeCohortDetailsId == 0) {
			LOGGER.info("Inside if");
		} else {
			List<DutyLogViolationDTO> dutyLogViolationList = dutyLogViolationLocalService
					.getDutyLogViolationList(programMasterId, traineeCohortDetailsId, traineeLevelId, traineeId);
			LOGGER.info("dutyLogViolationList" + dutyLogViolationList.size());
			LOGGER.info("dutyLogViolationList" + dutyLogViolationList);
			jsonArray = getDutyLogViolationDTOList(themeDisplay.getLocale().toString(), dutyLogViolationList);
			LOGGER.info("jsonArray  -----> " + jsonArray);
		}
		try {
			JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, jsonArray);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return true;
	}

	public JSONArray getDutyLogViolationDTOList(String languageCode,
			List<DutyLogViolationDTO> dutyLogViolationDTOList) {
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (DutyLogViolationDTO dutyLogViolationDTO : dutyLogViolationDTOList) {

			try {
				ProgramMaster programMaster = ProgramMasterLocalServiceUtil
						.getProgramMaster(dutyLogViolationDTO.getProgramId());
				TraineeLevelMaster traineeLevelMaster = TraineeLevelMasterLocalServiceUtil
						.getTraineeLevelMaster(dutyLogViolationDTO.getTraineeLevelId());
				RotationMaster rotationMaster = RotationMasterLocalServiceUtil
						.getRotationMaster(dutyLogViolationDTO.getRotationId());
				TrainingSitesMaster trainingSitesMaster = TrainingSitesMasterLocalServiceUtil
						.getTrainingSitesMaster(dutyLogViolationDTO.getTraineeSiteId());
				String blockNo = dutyLogViolationDTO.getBlockNo();
				String rotationName = OmsbTmsCommonUtil.getValueByLanguage(rotationMaster.getRotationName(),
						OmsbTmsCommonConstants.ROTATION_NAME, languageCode);
				String trainingSitesName = OmsbTmsCommonUtil.getValueByLanguage(
						trainingSitesMaster.getTrainingSiteName(), OmsbTmsCommonConstants.TRAINING_SITE_NAME,
						languageCode);
				DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
				String date = dateFormat.format(dutyLogViolationDTO.getBlockStartDate()) + "-"
						+ dateFormat.format(dutyLogViolationDTO.getBlockEndDate());
				JSONObject responseObj = JSONFactoryUtil.createJSONObject();
				
				LOGGER.info("acgme80HoursRule"+ dutyLogViolationDTO.getAcgme80HoursRule());
				LOGGER.info("acgme24HoursRule"+dutyLogViolationDTO.getAcgme24HoursRule());
				LOGGER.info("acgmeCallRuleOption1"+dutyLogViolationDTO.getAcgmeCallRuleOption1());
				LOGGER.info("acgmeCallRuleOption2"+dutyLogViolationDTO.getAcgmeCallRuleOption2());
				LOGGER.info("acgmeShortBreakRule"+ dutyLogViolationDTO.getAcgmeShortBreakRule());
				LOGGER.info("acgmeDayOffRule" +dutyLogViolationDTO.getAcgmeDayOffRule());
				responseObj.put("program", OmsbTmsCommonUtil.getValueByLanguage(programMaster.getProgramName(),
						OmsbTmsCommonConstants.PROGRAM_NAME, languageCode));
				responseObj.put("residencyLevel",
						OmsbTmsCommonUtil.getValueByLanguage(traineeLevelMaster.getTraineeLevelName(),
								OmsbTmsCommonConstants.TRAINEE_LEVEL_NAME, languageCode));
				responseObj.put("rotaionTrainingName", rotationName + "-" + trainingSitesName);
				responseObj.put("blockNo", blockNo);
				responseObj.put("date", date);
				responseObj.put("acgme80HoursRule", dutyLogViolationDTO.getAcgme80HoursRule());
				responseObj.put("acgme24HoursRule", dutyLogViolationDTO.getAcgme24HoursRule());
				responseObj.put("acgmeCallRuleOption1", dutyLogViolationDTO.getAcgmeCallRuleOption1());
				responseObj.put("acgmeCallRuleOption2", dutyLogViolationDTO.getAcgmeCallRuleOption2());
				responseObj.put("acgmeShortBreakRule", dutyLogViolationDTO.getAcgmeShortBreakRule());
				responseObj.put("acgmeDayOffRule", dutyLogViolationDTO.getAcgmeDayOffRule());
				// responseObj.put("dutyLogViolationId", dutyLogViolationId);
				jsonArray.put(responseObj);

			} catch (PortalException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return jsonArray;

	}

	private static final Log LOGGER = LogFactoryUtil.getLog(SearchDutyLogViolationMVCResourceCommand.class);

	@Reference
	private DutyLogViolationLocalService dutyLogViolationLocalService;
}
