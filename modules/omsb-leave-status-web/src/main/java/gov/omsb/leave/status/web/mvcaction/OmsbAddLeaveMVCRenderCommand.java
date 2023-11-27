package gov.omsb.leave.status.web.mvcaction;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.dto.UserMetadata;
import gov.omsb.common.dto.UserMetadataItem;
import gov.omsb.common.service.util.UserMetadataUtil;
import gov.omsb.leave.status.web.constants.OmsbLeaveStatusConstants;
import gov.omsb.leave.status.web.constants.OmsbLeaveStatusWebPortletKeys;
import gov.omsb.tms.model.LeaveTypes;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.model.TraineeAdmissionDetailsRel;
import gov.omsb.tms.model.TraineeCohortDetails;
import gov.omsb.tms.model.TraineeLevelMaster;
import gov.omsb.tms.model.TraineeSponsorDetails;
import gov.omsb.tms.model.TrainingSitesMaster;
import gov.omsb.tms.service.LeaveTypesLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;
import gov.omsb.tms.service.TraineeAdmissionDetailsRelLocalService;
import gov.omsb.tms.service.TraineeCohortDetailsLocalService;
import gov.omsb.tms.service.TraineeLevelMasterLocalService;
import gov.omsb.tms.service.TraineeSponsorDetailsLocalService;
import gov.omsb.tms.service.TrainingSitesMasterLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbLeaveStatusWebPortletKeys.OMSBLEAVESTATUSWEB,
		"mvc.command.name=" + OmsbLeaveStatusConstants.ADD_LEAVE_JSP }, service = MVCRenderCommand.class)
public class OmsbAddLeaveMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		SimpleDateFormat sdf = new SimpleDateFormat(OmsbLeaveStatusConstants.VIEW_DATE_FORMAT);
		SimpleDateFormat sdfFormatForTrainingSite = new SimpleDateFormat(OmsbLeaveStatusConstants.YYYY_MM_DD);
		Date curDate = new Date();

		String traineeName = themeDisplay.getUser().getFullName();
		String traineeEmailAddress = themeDisplay.getUser().getEmailAddress();

		List<LeaveTypes> leaveTypes = leaveTypesLocalService.getLeaveTypeses(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		String programName = StringPool.BLANK;
		long programId = 0;
		String traineeLevel = StringPool.BLANK;
		String omsbNumber = StringPool.BLANK;
		String traineeAddress = StringPool.BLANK;
		String sponsor = StringPool.BLANK;
		String trainingSiteName = StringPool.BLANK;
		try {
			// getting programId from current userId
			UserMetadataItem metadataItem = userMetadataUtil.getUserMetadataItemsByLrUserId(themeDisplay.getPortalURL(),
					themeDisplay.getSiteGroupId(), themeDisplay.getUserId());
			if (Validator.isNotNull(metadataItem)) {
				List<Long> ids = metadataItem.getItems().stream().map(UserMetadata::getProgramId)
						.collect(Collectors.toList());

				if (Validator.isNotNull(ids) && !ids.isEmpty()) {
					ProgramMaster programMaster = programMasterLocalService.getProgramMaster(ids.get(0));
					
					//get programName & ProgramId
					if (Validator.isNotNull(programMaster)) {
						programName = programMaster.getProgramName(themeDisplay.getLocale());
						programId = programMaster.getProgramMasterId();
					}					
				}
			}
			
			//get TrainingLevel && OmsbNumber
			DynamicQuery dqForTraineeAdmissionDetails = traineeAdmissionDetailsRelLocalService.dynamicQuery();
			dqForTraineeAdmissionDetails.add(RestrictionsFactoryUtil.eq("traineeId",themeDisplay.getUserId()));
			List<TraineeAdmissionDetailsRel> traineeAdmissionDetailsRelList = traineeAdmissionDetailsRelLocalService.dynamicQuery(dqForTraineeAdmissionDetails);
			
			long traineeAdmissionDetailsRelId = 0;
			if(!traineeAdmissionDetailsRelList.isEmpty()) {
				omsbNumber = traineeAdmissionDetailsRelList.get(0).getOmsbNumber();
				traineeAddress = traineeAdmissionDetailsRelList.get(0).getTraineeAddress(themeDisplay.getLocale());
				traineeAdmissionDetailsRelId = traineeAdmissionDetailsRelList.get(0).getTraineeAdmissionDetailsRelId();				
			}

			DynamicQuery dq = traineeCohortDetailsLocalService.dynamicQuery();
			dq.add(RestrictionsFactoryUtil.eq("traineeAdmissionDetailsRelId", traineeAdmissionDetailsRelId));
			dq.add(RestrictionsFactoryUtil.eq("isCurrentTraineeLevel", true));
			List<TraineeCohortDetails> traineeCohortDetailsList = traineeCohortDetailsLocalService.dynamicQuery(dq);
			
			if(!traineeCohortDetailsList.isEmpty()) {
				long traineeLevelMasterId = traineeCohortDetailsList.get(0).getTraineeLevelId();
				TraineeLevelMaster traineeLevelMaster = traineeLevelMasterLocalService.getTraineeLevelMaster(traineeLevelMasterId);
				if(Validator.isNotNull(traineeLevelMaster)) {
					traineeLevel = traineeLevelMaster.getTraineeLevelName(themeDisplay.getLocale());
				}
			}
			
			//get sponsor name
			TraineeSponsorDetails traineeSponsorDetails = traineeSponsorDetailsLocalService.getTraineeSponsorDetailsByTraineeId(themeDisplay.getUserId());
			if(Validator.isNotNull(traineeSponsorDetails)) {
				sponsor = traineeSponsorDetails.getSponsor(themeDisplay.getLocale());
			}
			
			TrainingSitesMaster trainingSiteMaster = trainingSitesMasterLocalService.getTrainingSiteByDatePerformed(sdfFormatForTrainingSite.format(new Date()), themeDisplay.getUserId());
			if(Validator.isNotNull(trainingSiteMaster)) {
				trainingSiteName = trainingSiteMaster.getTrainingSiteName(themeDisplay.getLocale());
			}
		} catch (PortalException e) {
			log.error(e.getMessage());
		}
		
		renderRequest.setAttribute(OmsbLeaveStatusConstants.TRAINEE_LEVEL, traineeLevel);
		renderRequest.setAttribute(OmsbLeaveStatusConstants.OMSB_NUMBER, omsbNumber);
		renderRequest.setAttribute(OmsbLeaveStatusConstants.TRAINEE_ADDRESS, traineeAddress);
		renderRequest.setAttribute(OmsbLeaveStatusConstants.SPONSOR, sponsor);
		renderRequest.setAttribute(OmsbLeaveStatusConstants.PROGRAM_ID, programId);
		renderRequest.setAttribute(OmsbLeaveStatusConstants.PROGRAM_NAME, programName);
		renderRequest.setAttribute(OmsbLeaveStatusConstants.TRAINEE_NAME, traineeName);
		renderRequest.setAttribute(OmsbLeaveStatusConstants.TRAINEE_EMAIL_ADDRESS, traineeEmailAddress);
		renderRequest.setAttribute(OmsbLeaveStatusConstants.DATE_OF_APPLICATION_VALUE, sdf.format(curDate));
		renderRequest.setAttribute(OmsbLeaveStatusConstants.LEAVE_TYPES_LIST, leaveTypes);
		renderRequest.setAttribute(OmsbLeaveStatusConstants.TRAINING_SITE_NAME, trainingSiteName);
		
		return OmsbLeaveStatusConstants.ADD_LEAVE_JSP;
	}

	@Reference
	LeaveTypesLocalService leaveTypesLocalService;

	@Reference
	private ProgramMasterLocalService programMasterLocalService;

	@Reference
	private UserMetadataUtil userMetadataUtil;

	@Reference
	private TraineeCohortDetailsLocalService traineeCohortDetailsLocalService;
	
	@Reference
	private TraineeAdmissionDetailsRelLocalService traineeAdmissionDetailsRelLocalService;

	@Reference
	private TraineeLevelMasterLocalService traineeLevelMasterLocalService;
	
	@Reference
	private TrainingSitesMasterLocalService trainingSitesMasterLocalService;
	
	@Reference
	private TraineeSponsorDetailsLocalService traineeSponsorDetailsLocalService;

	private Log log = LogFactoryUtil.getLog(OmsbAddLeaveMVCRenderCommand.class.getName());
	

}