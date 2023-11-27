package gov.omsb.leave.status.web.mvcaction;

import com.liferay.asset.kernel.service.AssetEntryLocalService;
import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.service.LayoutLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.leave.management.web.constants.OmsbLeaveManagementWebPortletKeys;
import gov.omsb.leave.status.web.constants.OmsbLeaveStatusConstants;
import gov.omsb.leave.status.web.constants.OmsbLeaveStatusWebPortletKeys;
import gov.omsb.leave.status.web.util.OmsbAddLeaveUtil;
import gov.omsb.tms.model.BlocksMetadataDetailsRel;
import gov.omsb.tms.model.LeaveAnnualRule;
import gov.omsb.tms.model.LeaveMaster;
import gov.omsb.tms.model.LeaveProgramMaster;
import gov.omsb.tms.model.LeaveTraineeMaster;
import gov.omsb.tms.service.LeaveAnnualRuleLocalService;
import gov.omsb.tms.service.LeaveMasterLocalService;
import gov.omsb.tms.service.LeaveProgramMasterLocalService;
import gov.omsb.tms.service.LeaveTraineeMasterLocalService;
import gov.omsb.tms.service.LeaveTypesLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;
import gov.omsb.tms.service.ProgramWorkflowDetailsRelLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbLeaveStatusWebPortletKeys.OMSBLEAVESTATUSWEB,
		"mvc.command.name=" + OmsbLeaveStatusConstants.ADD_LEAVE_ACTION_COMMAND }, service = MVCActionCommand.class)
public class OmsbAddLeaveMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(LeaveMaster.class.getName(), actionRequest);
		serviceContext.setScopeGroupId(themeDisplay.getScopeGroupId());

		SimpleDateFormat sdf = new SimpleDateFormat(OmsbLeaveStatusConstants.VIEW_DATE_FORMAT);

		String dateOfApplication = ParamUtil.getString(actionRequest, OmsbLeaveStatusConstants.DATE_OF_APPLICATION);
		String leaveFrom = ParamUtil.getString(actionRequest, OmsbLeaveStatusConstants.LEAVE_FROM);
		String leaveTo = ParamUtil.getString(actionRequest, OmsbLeaveStatusConstants.LEAVE_TO);
		String contactName = ParamUtil.getString(actionRequest, OmsbLeaveStatusConstants.CONTACT_NAME);
		String contactEmail = ParamUtil.getString(actionRequest, OmsbLeaveStatusConstants.CONTACT_EMAIL);
		String contactNumber = ParamUtil.getString(actionRequest, OmsbLeaveStatusConstants.CONTACT_NUMBER);
		String reasonForLeave = ParamUtil.getString(actionRequest, OmsbLeaveStatusConstants.REASON_FOR_LEAVE);
		String programName = ParamUtil.getString(actionRequest, OmsbLeaveStatusConstants.PROGRAM_NAME);
		String omsbNumber = ParamUtil.getString(actionRequest, OmsbLeaveStatusConstants.OMSB_NUMBER);
		String trainingLevel = ParamUtil.getString(actionRequest, OmsbLeaveStatusConstants.TRAINING_LEVEL);
		String trainingSite = ParamUtil.getString(actionRequest, OmsbLeaveStatusConstants.TRAINING_SITE);
		String sponsor = ParamUtil.getString(actionRequest, OmsbLeaveStatusConstants.SPONSOR);
		String address = ParamUtil.getString(actionRequest, OmsbLeaveStatusConstants.ADDRESS);

		long programId = ParamUtil.getLong(actionRequest, OmsbLeaveStatusConstants.PROGRAM_ID);
		long leaveTypeId = ParamUtil.getLong(actionRequest, OmsbLeaveStatusConstants.LEAVE_TYPE);

		int numberOfDays = ParamUtil.getInteger(actionRequest, OmsbLeaveStatusConstants.NUMBER_OF_DAYS);

		boolean isLeaveReSubmitted = ParamUtil.getBoolean(actionRequest, OmsbLeaveStatusConstants.IS_RESUBMIT);

		boolean isAppliedLeaveValid = false;
		boolean isWorkflowRequired = OmsbAddLeaveUtil.isWorkflowConfigured(programId);

		String leaveTypeName = OmsbAddLeaveUtil.getLeaveTypeNameFromLeaveTypeId(leaveTypeId, themeDisplay);

		LeaveProgramMaster leaveProgramMaster = OmsbAddLeaveUtil
				.getLeaveProgramMasterFromProgramIdLeaveTypeId(programId, leaveTypeId);

		if (Validator.isNull(leaveProgramMaster)) {
			isAppliedLeaveValid = true;
			isWorkflowRequired = false;
		} else if (OmsbLeaveStatusConstants.ANNUAL_LEAVE_TYPE.equals(leaveTypeName)
				&& Validator.isNotNull(programName)) {

			DynamicQuery leaveAnnualRuleDQ = leaveAnnualRuleLocalService.dynamicQuery();

			leaveAnnualRuleDQ
					.add(RestrictionsFactoryUtil.eq(OmsbLeaveStatusConstants.PROGRAM_MASTER_ID_COLUMN, programId));

			List<LeaveAnnualRule> leaveAnnualRules = leaveAnnualRuleLocalService.dynamicQuery(leaveAnnualRuleDQ);

			isAppliedLeaveValid = checkIsAppliedAnnualLeaveValid(actionRequest, themeDisplay, leaveProgramMaster,
					leaveAnnualRules, leaveFrom, leaveTo, numberOfDays);

		} else if (Validator.isNotNull(programName)) {

			isAppliedLeaveValid = checkIsAppliedLeaveValid(actionRequest, themeDisplay, leaveProgramMaster,
					numberOfDays);
		}
		
		boolean isLeaveAlreadyApplied = OmsbAddLeaveUtil.checkIfLeaveAlreadyApplied(leaveFrom,leaveTo,themeDisplay.getUserId());
		
		if(!isLeaveAlreadyApplied) {
			OmsbAddLeaveUtil.setLeaveAlreadyAppliedForTheseDays(actionRequest);
			isAppliedLeaveValid = false;
		}

		if (isAppliedLeaveValid) {

			long leaveMasterId = counterLocalService.increment(LeaveMaster.class.getName(), 1);

			LeaveMaster leaveMaster = leaveMasterLocalService.createLeaveMaster(leaveMasterId);

			leaveMaster.setCreateDate(new Date());
			leaveMaster.setCreatedBy(themeDisplay.getUserId());
			leaveMaster.setGroupId(themeDisplay.getScopeGroupId());
			leaveMaster.setCompanyId(themeDisplay.getCompanyId());

			leaveMaster.setTraineeId(themeDisplay.getUserId());
			leaveMaster.setLeaveTypeId(leaveTypeId);
			leaveMaster.setLeaveTraineeId(themeDisplay.getUserId());
			leaveMaster.setLeaveFrom(sdf.parse(leaveFrom));
			leaveMaster.setLeaveTo(sdf.parse(leaveTo));
			leaveMaster.setNoOfDays(numberOfDays);
			leaveMaster.setContactName(contactName);
			leaveMaster.setContactEmail(contactEmail);
			leaveMaster.setContactNo(contactNumber);
			leaveMaster.setApplicationDate(sdf.parse(dateOfApplication));
			leaveMaster.setProgramId(programId);
			leaveMaster.setReasonForLeave(reasonForLeave);
			leaveMaster.setModifiedBy(themeDisplay.getUserId());
			leaveMaster.setModifiedDate(new Date());
			leaveMaster.setBlockName(null);
			leaveMaster.setStatus(WorkflowConstants.STATUS_APPROVED);

			BlocksMetadataDetailsRel blocksMetadataDetailsRel = OmsbAddLeaveUtil
					.getBlocksMetadataDetailsRel(sdf.parse(leaveFrom), themeDisplay.getUserId());

			if (Validator.isNotNull(blocksMetadataDetailsRel)) {
				leaveMaster.setBlockName(String.valueOf(blocksMetadataDetailsRel.getBlocksMetadataDetailsRelId()));
			}

			if (isWorkflowRequired) {
				leaveMaster.setStatus(WorkflowConstants.STATUS_PENDING);
			}

			leaveMaster.setStatusByUserId(themeDisplay.getUserId());
			leaveMaster.setStatusDate(new Date());
			leaveMaster.setStatusByUserName(themeDisplay.getUser().getFullName());

			leaveMaster = leaveMasterLocalService.addLeaveMaster(leaveMaster);

			log.info("Leave Created Successfully.....");
			log.info("Is Workflow Required :: " + isWorkflowRequired);

			performWorkflowAction(actionRequest, themeDisplay, serviceContext, leaveMaster, isWorkflowRequired);

		} else {
			Date curDate = new Date();

			String portletName = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);

			PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest),
					portletName, themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);

			redirectURL.getRenderParameters().setValue(OmsbLeaveStatusConstants.MVC_PATH,
					OmsbLeaveStatusConstants.ADD_LEAVE_JSP);

			if (isLeaveReSubmitted) {
				redirectURL.getRenderParameters().setValue(OmsbLeaveStatusConstants.MVC_PATH,
						OmsbLeaveStatusConstants.VIEW_LEAVE_JSP);
			}

			redirectURL.getRenderParameters().setValue(OmsbLeaveStatusConstants.PROGRAM_NAME, programName);
			redirectURL.getRenderParameters().setValue(OmsbLeaveStatusConstants.PROGRAM_ID, String.valueOf(programId));
			redirectURL.getRenderParameters().setValue(OmsbLeaveStatusConstants.IS_LEAVE_CREATED, StringPool.FALSE);
			redirectURL.getRenderParameters().setValue(OmsbLeaveStatusConstants.DATE_OF_APPLICATION_VALUE,
					sdf.format(curDate));
			redirectURL.getRenderParameters().setValue(OmsbLeaveStatusConstants.OMSB_NUMBER, omsbNumber);
			redirectURL.getRenderParameters().setValue(OmsbLeaveStatusConstants.TRAINING_LEVEL, trainingLevel);
			redirectURL.getRenderParameters().setValue(OmsbLeaveStatusConstants.TRAINING_SITE, trainingSite);
			redirectURL.getRenderParameters().setValue(OmsbLeaveStatusConstants.SPONSOR, sponsor);
			redirectURL.getRenderParameters().setValue(OmsbLeaveStatusConstants.ADDRESS, address);
			redirectURL.getRenderParameters().setValue(OmsbLeaveStatusConstants.LEAVE_TYPE_VALUE,
					String.valueOf(leaveTypeId));
			redirectURL.getRenderParameters().setValue(OmsbLeaveStatusConstants.LEAVE_FROM_VALUE,
					sdf.format(sdf.parse(leaveFrom)));
			redirectURL.getRenderParameters().setValue(OmsbLeaveStatusConstants.LEAVE_TO_VALUE,
					sdf.format(sdf.parse(leaveTo)));
			redirectURL.getRenderParameters().setValue(OmsbLeaveStatusConstants.NUMBER_OF_DAYS_VALUE,
					String.valueOf(numberOfDays));
			redirectURL.getRenderParameters().setValue(OmsbLeaveStatusConstants.CONTACT_NAME_VALUE, contactName);
			redirectURL.getRenderParameters().setValue(OmsbLeaveStatusConstants.CONTACT_EMAIL_VALUE, contactEmail);
			redirectURL.getRenderParameters().setValue(OmsbLeaveStatusConstants.CONTACT_NUMBER_VALUE, contactNumber);
			redirectURL.getRenderParameters().setValue(OmsbLeaveStatusConstants.REASON_FOR_LEAVE_VALUE, reasonForLeave);

			actionResponse.sendRedirect(redirectURL.toString());
		}

	}

	private boolean checkIsAppliedAnnualLeaveValid(ActionRequest actionRequest, ThemeDisplay themeDisplay,
			LeaveProgramMaster leaveProgramMaster, List<LeaveAnnualRule> leaveAnnualRules, String leaveFrom,
			String leaveTo, int numberOfDays) throws ParseException, PortalException {

		boolean isAppliedLeaveValid = true;
		

		List<LeaveTraineeMaster> leaveTraineeMasters = OmsbAddLeaveUtil.getTraineeLeaveRecordsFromLeaveProgramMasterId(
				leaveProgramMaster.getLeaveProgramMasterId(), themeDisplay.getUserId());

		String programName = programMasterLocalService.getProgramMaster(leaveProgramMaster.getProgramMasterId())
				.getProgramName(themeDisplay.getLocale());

		if (Validator.isNotNull(leaveTraineeMasters) && !leaveTraineeMasters.isEmpty()) {

			LeaveTraineeMaster leaveTraineeMaster = leaveTraineeMasters.get(0);

			int numberOfLeavesRemaining = leaveTraineeMaster.getNoOfLeaveRemaining();

			if (numberOfLeavesRemaining >= numberOfDays) {

				isAppliedLeaveValid = checkIsValidAnnualLeaveCases(actionRequest, themeDisplay, leaveAnnualRules,
						programName, leaveFrom, leaveTo, numberOfDays);
			} else {
				isAppliedLeaveValid = false;
				OmsbAddLeaveUtil.setLeavesNotRemainingErrorMessage(actionRequest, numberOfDays,
						numberOfLeavesRemaining);
			}

		} else if (leaveProgramMaster.getNoOfLeaves() >= numberOfDays) {

			isAppliedLeaveValid = checkIsValidAnnualLeaveCases(actionRequest, themeDisplay, leaveAnnualRules,
					programName, leaveFrom, leaveTo, numberOfDays);

		} else {
			isAppliedLeaveValid = false;
			OmsbAddLeaveUtil.setLessDaysConfiguredErrorMessage(actionRequest);
		}

		return isAppliedLeaveValid;

	}

	private boolean checkIsValidAnnualLeaveCases(ActionRequest actionRequest, ThemeDisplay themeDisplay,
			List<LeaveAnnualRule> leaveAnnualRules, String programName, String leaveFrom, String leaveTo,
			int numberOfDays) throws ParseException {

		boolean isAppliedLeaveValid = true;

		if (numberOfDays <= 2) {
			isAppliedLeaveValid = OmsbAddLeaveUtil.checkIsAppliedLeaveValidForFirstCase(actionRequest, leaveAnnualRules,
					leaveFrom, leaveTo, themeDisplay.getUserId());
		} else if (numberOfDays > 2 && numberOfDays < 28) {

			isAppliedLeaveValid = OmsbAddLeaveUtil.checkIsAppliedLeaveValidForSecondCase(actionRequest,
					leaveAnnualRules, programName, leaveFrom, leaveTo, numberOfDays, themeDisplay.getUserId());

		} else if (numberOfDays >= 28 && numberOfDays <= 30) {

			isAppliedLeaveValid = OmsbAddLeaveUtil.checkIsAppliedLeaveValidForThirdCase(actionRequest, leaveAnnualRules,
					programName, leaveFrom, leaveTo, themeDisplay.getUserId());
		}

		return isAppliedLeaveValid;

	}

	private boolean checkIsAppliedLeaveValid(ActionRequest actionRequest, ThemeDisplay themeDisplay,
			LeaveProgramMaster leaveProgramMaster, int numberOfDays) {

		boolean isAppliedLeaveValid = true;
		

		List<LeaveTraineeMaster> leaveTraineeMasters = OmsbAddLeaveUtil.getTraineeLeaveRecordsFromLeaveProgramMasterId(
				leaveProgramMaster.getLeaveProgramMasterId(), themeDisplay.getUserId());

		if (Validator.isNotNull(leaveTraineeMasters) && !leaveTraineeMasters.isEmpty()) {

			LeaveTraineeMaster leaveTraineeMaster = leaveTraineeMasters.get(0);

			int numberOfLeavesRemaining = leaveTraineeMaster.getNoOfLeaveRemaining();

			if (numberOfLeavesRemaining >= numberOfDays) {
				isAppliedLeaveValid = true;
			} else {
				isAppliedLeaveValid = false;
				OmsbAddLeaveUtil.setLeavesNotRemainingErrorMessage(actionRequest, numberOfDays,
						numberOfLeavesRemaining);
			}

		} else {

			if (leaveProgramMaster.getNoOfLeaves() >= numberOfDays) {
				isAppliedLeaveValid = true;
			} else {
				isAppliedLeaveValid = false;
				OmsbAddLeaveUtil.setLessDaysConfiguredErrorMessage(actionRequest);
			}

		}

		return isAppliedLeaveValid;

	}

	private void performWorkflowAction(ActionRequest actionRequest, ThemeDisplay themeDisplay,
			ServiceContext serviceContext, LeaveMaster leaveMaster, boolean isWorkflowRequired) throws PortalException {

		if (isWorkflowRequired) {

			assetEntryLocalService.updateEntry(themeDisplay.getUserId(), serviceContext.getScopeGroupId(), new Date(),
					new Date(), LeaveMaster.class.getName(), leaveMaster.getLeaveMasterId(), leaveMaster.getUuid(), 0,
					null, null, true, false, new Date(), null, new Date(), null, ContentTypes.TEXT_HTML,
					OmsbLeaveStatusConstants.APPLIED_FOR_LEAVE, OmsbLeaveStatusConstants.APPLIED_FOR_LEAVE, null, null,
					null, 0, 0, null);

			Indexer<LeaveMaster> indexer = IndexerRegistryUtil.nullSafeGetIndexer(LeaveMaster.class);
			indexer.reindex(leaveMaster);

			Map<String, Serializable> workflowContext = new HashMap<>();

			// Create a PortletURL for the render phase for notification redirection
			long plid = layoutLocalService.getLayoutByFriendlyURL(themeDisplay.getScopeGroupId(), true,
					OmsbLeaveStatusConstants.VIEW_LEAVE_REQUESTS_COMMAND).getPlid();
			PortletURL renderURL = PortletURLFactoryUtil.create(actionRequest,
					OmsbLeaveManagementWebPortletKeys.OMSBVIEWTRAINEELEAVEWEB, plid, PortletRequest.RENDER_PHASE);

			renderURL.getRenderParameters().setValue("mvcRenderCommandName", OmsbLeaveStatusConstants.ADMIN_APPROVAL);
			renderURL.getRenderParameters().setValue(OmsbLeaveStatusConstants.LEAVE_MASTER_ID,
					String.valueOf(leaveMaster.getLeaveMasterId()));

			workflowContext.put("viewDetailsUrl", renderURL.toString());
			log.info("Notification Redirection URL :::::::::" + renderURL.toString());

			WorkflowHandlerRegistryUtil.startWorkflowInstance(leaveMaster.getCompanyId(), leaveMaster.getGroupId(),
					leaveMaster.getCreatedBy(), LeaveMaster.class.getName(), leaveMaster.getLeaveMasterId(),
					leaveMaster, serviceContext, workflowContext);

		}

	}

	@Reference
	CounterLocalService counterLocalService;

	@Reference
	LeaveMasterLocalService leaveMasterLocalService;

	@Reference
	ProgramMasterLocalService programMasterLocalService;

	@Reference
	LeaveProgramMasterLocalService leaveProgramMasterLocalService;

	@Reference
	LeaveTraineeMasterLocalService leaveTraineeMasterLocalService;

	@Reference
	LeaveTypesLocalService leaveTypesLocalService;

	@Reference
	LeaveAnnualRuleLocalService leaveAnnualRuleLocalService;

	@Reference
	AssetEntryLocalService assetEntryLocalService;

	@Reference
	ProgramWorkflowDetailsRelLocalService programWorkflowDetailsRelLocalService;

	@Reference
	LayoutLocalService layoutLocalService;

	private Log log = LogFactoryUtil.getLog(OmsbAddLeaveMVCActionCommand.class.getName());

}