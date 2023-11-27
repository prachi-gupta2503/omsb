package gov.omsb.tms.ecm.web.commands;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.*;
import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.tms.custom.dto.TrainingSiteByPdDTO;
import gov.omsb.tms.ecm.web.util.MembershipUtil;
import gov.omsb.tms.model.ProgdurationRotationTrainingsitesRel;
import gov.omsb.tms.model.ProgramDurationDetails;
import gov.omsb.tms.model.RotationMaster;
import gov.omsb.tms.model.TrainingSitesMaster;
import gov.omsb.tms.service.ProgdurationRotationTrainingsitesRelLocalService;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;
import gov.omsb.tms.service.RotationMasterLocalService;
import gov.omsb.tms.service.TrainingSitesMasterLocalService;

/**
 * @author Jinal Patel
 */
@Component(immediate = true, property = {
		"javax.portlet.name=" + ECMEMBERSHIPREQUEST,
		"mvc.command.name=/get/dependent-data" 
	}, 
	service = MVCResourceCommand.class)
public class GetDependentDataMVCResourceCommand extends BaseMVCResourceCommand {
	
	private static final Log log = LogFactoryUtil.getLog(GetDependentDataMVCResourceCommand.class);
	
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
	
	@Reference(unbind = "-")
	private MembershipUtil membershipUtil;
	
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		log.info("get dependent data serve resource");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		String cmd = ParamUtil.getString(resourceRequest, CMD2);
		JSONObject responseObj = JSONFactoryUtil.createJSONObject();

		if(GET_TRAINING_SITES_DATA.equalsIgnoreCase(cmd)) {
			long selectedProgramId = ParamUtil.getLong(resourceRequest, SELECTED_PROGRAM);
			List<TrainingSiteByPdDTO> trainingSites = membershipUtil.getTrainingSitesDataByProgramId(themeDisplay, selectedProgramId);
			if(Validator.isNotNull(trainingSites) && !trainingSites.isEmpty()) {
				responseObj.put(STATUS, SUCCESS);
				responseObj.put(TRAINING_SITES, trainingSites);
			} else {
				responseObj.put(STATUS, FAILURE);
			}
		} else if(GET_ROTATIONS_DATA.equalsIgnoreCase(cmd)) {
			long selectedTrainingSiteId = ParamUtil.getLong(resourceRequest, SELECTED_TRAINING_SITE);
			List<RotationMaster> rotationMasters = membershipUtil.getRotationsOnTrainingSites(selectedTrainingSiteId);
			if(Validator.isNotNull(rotationMasters) && !rotationMasters.isEmpty()) {
				responseObj.put(STATUS, SUCCESS);
				responseObj.put(ROTATIONS, rotationMasters);
			} else {
				responseObj.put(STATUS, FAILURE);
			}
		}
		
		JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, responseObj);
	}
	
	@Reference
	private ProgdurationRotationTrainingsitesRelLocalService progDurRotTrainSitesRelLS;
	
	@Reference
	private TrainingSitesMasterLocalService trainingSitesMasterLocalService;
	
	@Reference
	private ProgramDurationDetailsLocalService programDurationDetailsLocalService;
	
	@Reference
	private RotationMasterLocalService rotationMasterLocalService;
}
