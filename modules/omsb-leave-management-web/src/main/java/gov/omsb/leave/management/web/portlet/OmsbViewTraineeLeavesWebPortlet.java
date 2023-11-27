package gov.omsb.leave.management.web.portlet;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.workflow.kaleo.model.KaleoTaskInstanceToken;
import com.liferay.portal.workflow.kaleo.service.KaleoTaskInstanceTokenLocalService;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.dto.UserMetadata;
import gov.omsb.common.dto.UserMetadataItem;
import gov.omsb.common.service.util.UserMetadataUtil;
import gov.omsb.leave.management.web.constants.OmsbLeaveManagementWebConstants;
import gov.omsb.leave.management.web.constants.OmsbLeaveManagementWebPortletKeys;
import gov.omsb.tms.model.LeaveMaster;
import gov.omsb.tms.service.LeaveMasterLocalService;

@Component(immediate = true, property = { "com.liferay.portlet.display-category=OMSB",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=OmsbViewTraineeLeavesWeb",
		"javax.portlet.init-param.view-template=" + OmsbLeaveManagementWebConstants.VIEW_TRAINEE_LEAVE_REQUEST_JSP_PATH,
		"javax.portlet.name=" + OmsbLeaveManagementWebPortletKeys.OMSBVIEWTRAINEELEAVEWEB,
		"javax.portlet.resource-bundle=content.Language", "javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.version=3.0" }, service = Portlet.class)
public class OmsbViewTraineeLeavesWebPortlet extends MVCPortlet {
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		SimpleDateFormat sdf = new SimpleDateFormat(OmsbLeaveManagementWebConstants.VIEW_DATE_FORMAT);
		List<LeaveMaster> leaveMasters = getPendingLeaveMasters(themeDisplay);

		renderRequest.setAttribute(OmsbLeaveManagementWebConstants.LEAVE_MASTER_LIST, leaveMasters);
		renderRequest.setAttribute(OmsbLeaveManagementWebConstants.SDF, sdf);
		super.render(renderRequest, renderResponse);
	}

	private List<LeaveMaster> getPendingLeaveMasters(ThemeDisplay themeDisplay) {

		List<LeaveMaster> leaveMasters = new ArrayList<>();

		boolean isRotationSupervisor = false;
		boolean isChiefResident = false;
		boolean isProgramDirector = false;

		List<Role> roles = themeDisplay.getUser().getRoles();

		for (Role role : roles) {
			if(!isRotationSupervisor && !isChiefResident && !isProgramDirector) {
				if (OmsbLeaveManagementWebConstants.ROTATION_SUPERVISOR_ROLE.equalsIgnoreCase(role.getName())) {
					isRotationSupervisor = true;
				} else if (OmsbLeaveManagementWebConstants.CHIEF_RESIDENT_ROLE.equalsIgnoreCase(role.getName())) {
					isChiefResident = true;
				} else if (OmsbLeaveManagementWebConstants.PROGRAM_DIRECTOR_ROLE.equalsIgnoreCase(role.getName())) {
					isProgramDirector = true;
				}
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

		List<Long> programIds = getProgramIdFromUserId(themeDisplay);

		for (KaleoTaskInstanceToken kaleoTaskInstanceToken : kaleoTaskInstanceTokens) {
			long leaveMasterId = kaleoTaskInstanceToken.getClassPK();
			LeaveMaster leaveMaster;
			try {
				leaveMaster = leaveMasterLocalService.getLeaveMaster(leaveMasterId);
				if (Validator.isNotNull(programIds) && programIds.contains(leaveMaster.getProgramId())) {
					leaveMasters.add(leaveMaster);
				}
			} catch (PortalException e) {
				log.error("Error While Fetching Leave Master Record - " + e.getMessage());
			}
		}
		return leaveMasters;

	}

	private List<Long> getProgramIdFromUserId(ThemeDisplay themeDisplay) {

		UserMetadataItem metadataItem = userMetadataUtil.getUserMetadataItemsByLrUserId(themeDisplay.getPortalURL(),
				themeDisplay.getSiteGroupId(), themeDisplay.getUserId());

		List<Long> programList = new ArrayList<>();

		if (Validator.isNotNull(metadataItem)) {
			programList = metadataItem.getItems().stream().map(UserMetadata::getProgramId).collect(Collectors.toList());
		}
		return programList;
	}

	@Reference
	private LeaveMasterLocalService leaveMasterLocalService;

	@Reference
	private KaleoTaskInstanceTokenLocalService kaleoTaskInstanceTokenLocalService;

	@Reference
	private UserMetadataUtil userMetadataUtil;

	private Log log = LogFactoryUtil.getLog(OmsbViewTraineeLeavesWebPortlet.class.getName());
}
