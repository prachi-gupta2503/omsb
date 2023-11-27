package gov.omsb.leave.management.web.commands;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionList;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.workflow.kaleo.model.KaleoTaskInstanceToken;
import com.liferay.portal.workflow.kaleo.service.KaleoTaskInstanceTokenLocalService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.leave.management.web.constants.OmsbLeaveManagementWebConstants;
import gov.omsb.leave.management.web.constants.OmsbLeaveManagementWebPortletKeys;
import gov.omsb.tms.model.LeaveAnnualRule;
import gov.omsb.tms.model.LeaveMaster;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.service.LeaveAnnualMasterLocalService;
import gov.omsb.tms.service.LeaveAnnualRuleLocalService;
import gov.omsb.tms.service.LeaveMasterLocalService;
import gov.omsb.tms.service.LeaveProgramMasterLocalService;
import gov.omsb.tms.service.ProgramMasterLocalService;

@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbLeaveManagementWebPortletKeys.OMSBLEAVEMANAGEMENTWEB,
		"mvc.command.name=/", }, service = MVCRenderCommand.class)
public class LeaveRuleListMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		SimpleDateFormat sdf = new SimpleDateFormat(OmsbLeaveManagementWebConstants.VIEW_DATE_FORMAT);

		DynamicQuery dynamicQuery = leaveProgramMasterLocalService.dynamicQuery();

		ProjectionList projectionList = ProjectionFactoryUtil.projectionList();
		projectionList.add(ProjectionFactoryUtil
				.distinct(ProjectionFactoryUtil.property(OmsbLeaveManagementWebConstants.PROGRAM_MASTER_ID)));
		projectionList.add(PropertyFactoryUtil.forName(OmsbLeaveManagementWebConstants.CREATED_BY));
		projectionList.add(PropertyFactoryUtil.forName(OmsbLeaveManagementWebConstants.CREATED_DATE));

		dynamicQuery.setProjection(projectionList);
		
		List<Object[]> leaveProgramMasterList = leaveProgramMasterLocalService.dynamicQuery(dynamicQuery);

		HashMap<Long, Long> idsMap = new HashMap<>();
		HashMap<ProgramMaster, String> nameMap = new HashMap<>();
		for (Object[] leaveProgramMaster : leaveProgramMasterList) {

			long programId = (Long) leaveProgramMaster[0];
			long createdBy = (Long) leaveProgramMaster[1];

			if (!idsMap.keySet().contains(programId)) {
				try {
					ProgramMaster programMaster = programMasterLocalService.getProgramMaster(programId);
					User user = userLocalService.getUser(createdBy);
					if (Validator.isNotNull(programMaster) && Validator.isNotNull(user)) {
						nameMap.put(programMaster, user.getFullName());
					}
					idsMap.put(programId, createdBy);
				} catch (PortalException e) {
					logger.debug(e.getMessage());
				}
			}
		}

		List<LeaveMaster> leaveMasters = getPendingLeaveMasters(themeDisplay);
		
		DynamicQuery annualLeaveDQ = leaveAnnualRuleLocalService.dynamicQuery();
		
		annualLeaveDQ.addOrder(OrderFactoryUtil.desc(OmsbLeaveManagementWebConstants.CREATED_DATE));
		
		List<LeaveAnnualRule> leaveAnnualRules = leaveAnnualRuleLocalService.dynamicQuery(annualLeaveDQ);

		renderRequest.setAttribute(OmsbLeaveManagementWebConstants.LEAVE_MASTER_LIST, leaveMasters);
		renderRequest.setAttribute(OmsbLeaveManagementWebConstants.SDF, sdf);
		renderRequest.setAttribute(OmsbLeaveManagementWebConstants.PROGRAM_LIST, nameMap);
		renderRequest.setAttribute(OmsbLeaveManagementWebConstants.LEAVE_ANNUAL_MASTER_LIST, leaveAnnualRules);
		
		renderRequest.setAttribute(OmsbLeaveManagementWebConstants.TAB_NAME, OmsbLeaveManagementWebConstants.LEAVE_TAB);

		return OmsbLeaveManagementWebConstants.LEAVE_MANAGEMENT_TAB;
	}

	private List<LeaveMaster> getPendingLeaveMasters(ThemeDisplay themeDisplay) {

		List<LeaveMaster> leaveMasters = new ArrayList<>();

		boolean isRotationSupervisor = false;
		boolean	isChiefResident = false;
		boolean isProgramDirector = false;

		List<Role> roles = themeDisplay.getUser().getRoles();

		for (Role role : roles) {
			if (OmsbLeaveManagementWebConstants.ROTATION_SUPERVISOR_ROLE.equalsIgnoreCase(role.getName())) {
				isRotationSupervisor = true;
				break;
			} else if (OmsbLeaveManagementWebConstants.CHIEF_RESIDENT_ROLE.equalsIgnoreCase(role.getName())) {
				isChiefResident = true;
				break;
			} else if (OmsbLeaveManagementWebConstants.PROGRAM_DIRECTOR_ROLE.equalsIgnoreCase(role.getName())) {
				isProgramDirector = true;
				break;
			}
		}

		DynamicQuery kaleoTaskInstanceTokenDQ = kaleoTaskInstanceTokenLocalService.dynamicQuery();

		kaleoTaskInstanceTokenDQ.add(
				RestrictionsFactoryUtil.eq(OmsbLeaveManagementWebConstants.CLASS_NAME, LeaveMaster.class.getName()));
		kaleoTaskInstanceTokenDQ.add(RestrictionsFactoryUtil.eq(OmsbLeaveManagementWebConstants.COMPLETED, false));

		if (isRotationSupervisor) {
			Junction junction = RestrictionsFactoryUtil.disjunction();
			junction.add(PropertyFactoryUtil.forName(OmsbLeaveManagementWebConstants.KALEO_TASK_NAME)
					.eq(OmsbLeaveManagementWebConstants.ROTATION_SUPERVISOR_TASK_NAME));
			junction.add(PropertyFactoryUtil.forName(OmsbLeaveManagementWebConstants.KALEO_TASK_NAME)
					.eq(OmsbLeaveManagementWebConstants.DIRECT_ROTATION_SUPERVISOR_TASK_NAME));
			kaleoTaskInstanceTokenDQ.add(junction);
		} else if (isChiefResident) {
			Junction junction = RestrictionsFactoryUtil.disjunction();
			junction.add(PropertyFactoryUtil.forName(OmsbLeaveManagementWebConstants.KALEO_TASK_NAME)
					.eq(OmsbLeaveManagementWebConstants.CHIEF_RESIDENT_TASK_NAME));
			junction.add(PropertyFactoryUtil.forName(OmsbLeaveManagementWebConstants.KALEO_TASK_NAME)
					.eq(OmsbLeaveManagementWebConstants.DIRECT_CHIEF_RESIDENT_TASK_NAME));
			kaleoTaskInstanceTokenDQ.add(junction);
		} else if (isProgramDirector) {
			kaleoTaskInstanceTokenDQ.add(RestrictionsFactoryUtil.eq(OmsbLeaveManagementWebConstants.KALEO_TASK_NAME,
					OmsbLeaveManagementWebConstants.PROGRAM_DIRECTOR_TASK_NAME));
		}

		kaleoTaskInstanceTokenDQ.addOrder(OrderFactoryUtil.desc(OmsbLeaveManagementWebConstants.CREATED_DATE));
		List<KaleoTaskInstanceToken> kaleoTaskInstanceTokens = kaleoTaskInstanceTokenLocalService
				.dynamicQuery(kaleoTaskInstanceTokenDQ);

		for (KaleoTaskInstanceToken kaleoTaskInstanceToken : kaleoTaskInstanceTokens) {
			long leaveMasterId = kaleoTaskInstanceToken.getClassPK();
			LeaveMaster leaveMaster;
			try {
				leaveMaster = leaveMasterLocalService.getLeaveMaster(leaveMasterId);
				if(Validator.isNotNull(leaveMaster)) {
					leaveMasters.add(leaveMaster);
				}
			} catch (PortalException e) {
				logger.error("Error While Fetching Leave Master Record - " + e.getMessage());
			}
		}

		return leaveMasters;

	}

	@Reference
	private LeaveProgramMasterLocalService leaveProgramMasterLocalService;

	@Reference
	private UserLocalService userLocalService;

	@Reference
	private ProgramMasterLocalService programMasterLocalService;

	@Reference
	private LeaveMasterLocalService leaveMasterLocalService;

	@Reference
	private LeaveAnnualMasterLocalService leaveAnnualMasterLocalService;
	
	@Reference
	private LeaveAnnualRuleLocalService leaveAnnualRuleLocalService;

	@Reference
	private KaleoTaskInstanceTokenLocalService kaleoTaskInstanceTokenLocalService;

	private Log logger = LogFactoryUtil.getLog(LeaveRuleListMVCRenderCommand.class);

}
