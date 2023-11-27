package gov.omsb.tms.ecm.web.commands;

import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.COMMENTS_PARAM;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.COVERING_LETTER;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.COVERING_LETTER_FOLDER_NAME;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.CURRICULAM_VITAE;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.CURRICULAM_VITAE_FOLDER_NAME;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.ECMEMBERSHIPREQUEST;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.EC_MEMBER_REQUEST;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.EC_MEMBER_REQUEST_ID;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.MEMBERSHIP_ROLE;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.PERSON_ID;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.PROGRAM_NAME;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.ROTATION2;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.TRAINING_SITE;
import static gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys.UPDATE_EC_MEMBERSHIP_REQUEST;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.tms.ecm.web.constants.OmsbEcMembershipConstants;
import gov.omsb.tms.ecm.web.util.MembershipUtil;
import gov.omsb.tms.model.EcMemberRequest;
import gov.omsb.tms.model.EcMemberRequestRotations;
import gov.omsb.tms.service.EcMemberRequestLocalService;
import gov.omsb.tms.service.EcMemberRequestRotationsLocalService;
import gov.omsb.tms.service.EcMemberRequestStateLocalService;
import gov.omsb.tms.service.EcMemberRequestStatusLocalService;

/**
 * @author jinal.patel
 *
 */
@Component(immediate = true, property = {
		"javax.portlet.name=" + ECMEMBERSHIPREQUEST,
		"mvc.command.name="+UPDATE_EC_MEMBERSHIP_REQUEST }, service = MVCActionCommand.class)
public class UpdateEcMembershipRequestMVCActionCommand extends BaseMVCActionCommand {

	private static final Log log = LogFactoryUtil.getLog(UpdateEcMembershipRequestMVCActionCommand.class);
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		log.info("Update ec member request action called");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String ecMemberRequestIdStr = ParamUtil.getString(actionRequest, EC_MEMBER_REQUEST_ID);
		if(Validator.isNotNull(ecMemberRequestIdStr) && !ecMemberRequestIdStr.isBlank() && !ecMemberRequestIdStr.isEmpty()) {
			long ecMemberRequestId = Long.valueOf(ecMemberRequestIdStr);
			EcMemberRequest ecMemberRequest = ecMemberRequestLocalService.fetchEcMemberRequest(ecMemberRequestId);
			UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			String programName = ParamUtil.getString(actionRequest, PROGRAM_NAME);
			String personId = ParamUtil.getString(actionRequest, PERSON_ID);
			String trainingSite = ParamUtil.getString(actionRequest, TRAINING_SITE);
			String[] rotation = ParamUtil.getStringValues(actionRequest, ROTATION2);
			String membershipRole = ParamUtil.getString(actionRequest, MEMBERSHIP_ROLE);
			File coveringLetter = uploadPortletRequest.getFile(COVERING_LETTER);
			File curriculamVitae = uploadPortletRequest.getFile(CURRICULAM_VITAE);
			String coveringLetterName = uploadPortletRequest.getFileName(COVERING_LETTER);
			String curriculamVitaeName = uploadPortletRequest.getFileName(CURRICULAM_VITAE);
			String comments = ParamUtil.getString(actionRequest, COMMENTS_PARAM);
			
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);
			serviceContext.setAddGuestPermissions(true);
			
			setEcMemberRequestObject(actionRequest, themeDisplay, programName, personId, membershipRole, coveringLetter,
					curriculamVitae, coveringLetterName, curriculamVitaeName, serviceContext, ecMemberRequest, comments);
			
			ecMemberRequest = ecMemberRequestLocalService.updateRequest(ecMemberRequest);
			
			List<EcMemberRequestRotations> ecMemberRequestRotationsList = ecMemberRequestRotationsLocalService.findByEcMemberRequestId(ecMemberRequestId); 
			
			for(EcMemberRequestRotations ecMemberRequestRotation : ecMemberRequestRotationsList) {
				ecMemberRequestRotationsLocalService.deleteEcMemberRequestRotations(ecMemberRequestRotation);
			}
			
			if(Validator.isNotNull(rotation) && rotation.length>0) {
				for(String rotationId : rotation) {
					EcMemberRequestRotations ecMemberRequestRotations = ecMemberRequestRotationsLocalService.createEcMemberRequestRotations(CounterLocalServiceUtil.increment(EcMemberRequestRotations.class.getName()));
					setEcMemberRequestRotationsObject(themeDisplay, trainingSite, rotationId, ecMemberRequest.getEcMemberRequestId(),ecMemberRequestRotations);
					ecMemberRequestRotationsLocalService.addEcMemberRequestRotations(ecMemberRequestRotations);
				}
			}
			/*
			 * EcMemberRequestRotations ecMemberRequestRotations =
			 * ecMemberRequestRotationsLocalService.findByEcMemberRequestId(
			 * ecMemberRequestId); setEcMemberRequestRotationsObject(trainingSite, rotation,
			 * ecMemberRequestRotations);
			 * ecMemberRequestRotationsLocalService.updateEcMemberRequestRotations(
			 * ecMemberRequestRotations);
			 */
			 
			
			
			String  workDetailsStr = ParamUtil.getString(actionRequest, "workflowTaskDetails");
			if(Validator.isNotNull(workDetailsStr)) {
				log.info("workDetails > "+workDetailsStr);
				
				JSONObject workflowDetails  = JSONFactoryUtil.createJSONObject(workDetailsStr);
	
				long workflowInstanceId = workflowDetails.getLong(OmsbEcMembershipConstants.WORKFLOW_INSTANCE_ID);
				long taskId = workflowDetails.getLong(OmsbEcMembershipConstants.WORKFLOW_TASK_ID);
				String nextTransitionName = workflowDetails.getString(OmsbEcMembershipConstants.TRANSITION_NAME);
			
				try {
					log.info("ecMemberRequestId > "+ecMemberRequestId);
					
					membershipUtil.submitTask(themeDisplay,workflowInstanceId, taskId, nextTransitionName, comments );
					
				} catch (PortalException ex) {
					log.debug(ex);;
				}
			}
		}
		SessionMessages.add(actionRequest, "ec-request-updated-successfully");
	}

	private void setEcMemberRequestRotationsObject(ThemeDisplay themeDisplay, String trainingSite, String rotation,
			Long requestId, EcMemberRequestRotations ecMemberRequestRotations) {
		ecMemberRequestRotations.setCompanyId(themeDisplay.getCompanyId());
		ecMemberRequestRotations.setCreateDate(new Date());
		ecMemberRequestRotations.setEcMemberRequestId(requestId);
		ecMemberRequestRotations.setGroupId(themeDisplay.getScopeGroupId());
		ecMemberRequestRotations.setIsActive(false);
		ecMemberRequestRotations.setModifiedDate(new Date());
		if(Validator.isNotNull(rotation) && !rotation.isBlank()) {
			ecMemberRequestRotations.setRotationId(Long.valueOf(rotation));
		}
		if(Validator.isNotNull(trainingSite) && !trainingSite.isBlank()) {
			ecMemberRequestRotations.setTrainingSiteId(Long.valueOf(trainingSite));
		}
	}

	@SuppressWarnings("deprecation")
	private void setEcMemberRequestObject(ActionRequest actionRequest, ThemeDisplay themeDisplay, String programName,
			String personId, String membershipRole, File coveringLetter, File curriculamVitae,
			String coveringLetterName, String curriculamVitaeName, ServiceContext serviceContext,
			EcMemberRequest ecMemberRequest, String comments) throws PortalException {
		if(Validator.isNotNull(coveringLetter) && Validator.isNotNull(coveringLetterName) && !coveringLetterName.isBlank()) {
			FileEntry coveringLetterFileEntry = DLAppLocalServiceUtil.addFileEntry(themeDisplay.getUserId(),
					themeDisplay.getScopeGroupId(), createCoveringLetterFolder(actionRequest, themeDisplay).getFolderId(), coveringLetterName,
					MimeTypesUtil.getContentType(coveringLetter), coveringLetterName, StringPool.BLANK, StringPool.BLANK, coveringLetter,
					serviceContext);
			ecMemberRequest.setCoveringLetterId(coveringLetterFileEntry.getFileEntryId());
		}
		if(Validator.isNotNull(curriculamVitae) && Validator.isNotNull(curriculamVitaeName) && !curriculamVitaeName.isBlank()) {
			FileEntry curriculamVitaeFileEntry = DLAppLocalServiceUtil.addFileEntry(themeDisplay.getUserId(),
					themeDisplay.getScopeGroupId(), createCurriculamVitaeFolder(actionRequest, themeDisplay).getFolderId(), curriculamVitaeName,
					MimeTypesUtil.getContentType(curriculamVitae), curriculamVitaeName, StringPool.BLANK, StringPool.BLANK, curriculamVitae,
					serviceContext);
			ecMemberRequest.setCvId(curriculamVitaeFileEntry.getFileEntryId());
		}
		ecMemberRequest.setModifiedDate(new Date());
		ecMemberRequest.setProgramId(Long.valueOf(programName));
		ecMemberRequest.setPotentialEcMemberRoleId(Long.valueOf(membershipRole));
		ecMemberRequest.setComments(comments, themeDisplay.getLocale());
	}
	
	public DLFolder createCoveringLetterFolder(ActionRequest actionRequest, ThemeDisplay themeDisplay){
		DLFolder ecMemberRequestFolder = membershipUtil.createDLFolder(actionRequest, themeDisplay, false, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, EC_MEMBER_REQUEST, StringPool.BLANK, false);
		DLFolder coveringLetterFolder = membershipUtil.createDLFolder(actionRequest, themeDisplay, false, ecMemberRequestFolder.getFolderId(), COVERING_LETTER_FOLDER_NAME, StringPool.BLANK, false);
		return coveringLetterFolder;
	}
	
	public DLFolder createCurriculamVitaeFolder(ActionRequest actionRequest, ThemeDisplay themeDisplay){
		DLFolder ecMemberRequestFolder = membershipUtil.createDLFolder(actionRequest, themeDisplay, false, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, EC_MEMBER_REQUEST, StringPool.BLANK, false);
		DLFolder curriculamVitaeFolder = membershipUtil.createDLFolder(actionRequest, themeDisplay, false, ecMemberRequestFolder.getFolderId(), CURRICULAM_VITAE_FOLDER_NAME, StringPool.BLANK, false);
		return curriculamVitaeFolder;
	}
	
	@Reference(unbind = "-")
	private MembershipUtil membershipUtil;
	
	@Reference
	private EcMemberRequestStatusLocalService ecMemberRequestStatusLocalService;
	
	@Reference
	private EcMemberRequestStateLocalService ecMemberRequestStateLocalService;
	
	@Reference
	private EcMemberRequestRotationsLocalService ecMemberRequestRotationsLocalService;
	
	@Reference
	private EcMemberRequestLocalService ecMemberRequestLocalService;
}
