package gov.omsb.view.procedures.supervisor.web.portlet;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
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
import gov.omsb.common.service.util.UserMetadataUtil;
import gov.omsb.common.util.CommonUtil;
import gov.omsb.tms.custom.dto.TraineeLoggedProcedureDetailsDTO;
import gov.omsb.tms.service.TraineeLoggedProcedureDetailsLocalService;
import gov.omsb.view.procedures.supervisor.web.constants.OmsbViewProceduresSupervisorWebPortletKeys;

/**
 * @author Jayesh Goswami
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.version=3.0",
		"com.liferay.portlet.display-category=OMSB",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.header-portlet-css=/css/custom_procedures.js",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=OmsbViewProceduresSupervisorWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template="+ OmsbViewProceduresSupervisorWebPortletKeys.PRODCEDURES_LIST_SUPERVISOR_JSP,
		"javax.portlet.name=" + OmsbViewProceduresSupervisorWebPortletKeys.OMSBVIEWPROCEDURESSUPERVISORWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class OmsbViewProceduresSupervisorWebPortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		_logger.info("render Invoked ::: ");

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();

		long traineeLoggedProcedureDetailsId = ParamUtil.getLong(renderRequest, "traineeLoggedProcedureDetailsId", 0);
		boolean isShowModal = ParamUtil.getBoolean(renderRequest, OmsbViewProceduresSupervisorWebPortletKeys.SHOW_MODAL, Boolean.FALSE);
		String tabName = ParamUtil.getString(renderRequest, OmsbViewProceduresSupervisorWebPortletKeys.TAB_NAME);

		List<TraineeLoggedProcedureDetailsDTO> traineeLoggedProcedureDetailsDTOs = new ArrayList<>();

		TraineeLoggedProcedureDetailsDTO traineeLoggedProcedureDetailsDTO = null;
		if(Validator.isNotNull(traineeLoggedProcedureDetailsId)) {
			traineeLoggedProcedureDetailsDTO = traineeLoggedProcedureDetailsLocalService.getTraineeLoggedProcedureDetail(themeDisplay.getUserId(), traineeLoggedProcedureDetailsId, themeDisplay.getLocale().toString());
			if(Validator.isNull(traineeLoggedProcedureDetailsDTO)) {
				isShowModal = Boolean.TRUE;	
			}
		} else {
			isShowModal = Boolean.FALSE;	
		}

		if (permissionChecker.hasPermission(themeDisplay.getScopeGroupId(),
				themeDisplay.getPortletDisplay().getRootPortletId(), themeDisplay.getPortletDisplay().getResourcePK(),
				OmsbViewProceduresSupervisorWebPortletKeys.VIEW_DEDICATED_LOG_PROCEDURE)) {
			
		    List<UserMetadata> userMetadataList = userMetadataUtil.getUserMetadataItemsByLrUserId(
		            themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), themeDisplay.getUserId()).getItems();
		    
		    StringBuilder programIds = new StringBuilder();
		    for (int i = 0; i < userMetadataList.size(); i++) {
		    	programIds.append(userMetadataList.get(i).getProgramId());
				if (i+1 != userMetadataList.size()) {
					programIds.append(StringPool.COMMA);
				}
			}

			if (CommonUtil.isFacultyUser(themeDisplay.getUser())) {
				traineeLoggedProcedureDetailsDTOs = traineeLoggedProcedureDetailsLocalService
						.getTraineeLoggedProcedureDetailsList(true, false, themeDisplay.getUserId(), programIds.toString(), themeDisplay.getLocale().toString());
			} else {
				traineeLoggedProcedureDetailsDTOs = traineeLoggedProcedureDetailsLocalService
						.getTraineeLoggedProcedureDetailsList(false, true, themeDisplay.getUserId(), programIds.toString(), themeDisplay.getLocale().toString());
			}
			
		} else if (permissionChecker.hasPermission(themeDisplay.getScopeGroupId(),
				themeDisplay.getPortletDisplay().getRootPortletId(), themeDisplay.getPortletDisplay().getResourcePK(),
				OmsbViewProceduresSupervisorWebPortletKeys.VIEW_ALL_LOG_PROCEDURE)) {
			traineeLoggedProcedureDetailsDTOs = traineeLoggedProcedureDetailsLocalService
					.getTraineeLoggedProcedureDetailsList(false, false, themeDisplay.getUserId(), null, themeDisplay.getLocale().toString());
		}

		List<TraineeLoggedProcedureDetailsDTO> unconfirmedTraineeLoggedProcedureDetailsDTOs = traineeLoggedProcedureDetailsDTOs.stream().filter(p -> p.getProcedureStatus().equalsIgnoreCase(OmsbViewProceduresSupervisorWebPortletKeys.STATUS_UNCONFIRMED)).collect(Collectors.toList());
		List<TraineeLoggedProcedureDetailsDTO> refuseTraineeLoggedProcedureDetailsDTOs = traineeLoggedProcedureDetailsDTOs.stream().filter(p -> p.getProcedureStatus().equalsIgnoreCase(OmsbViewProceduresSupervisorWebPortletKeys.STATUS_REFUSE)).collect(Collectors.toList());
		List<TraineeLoggedProcedureDetailsDTO> notPassTraineeLoggedProcedureDetailsDTOs = traineeLoggedProcedureDetailsDTOs.stream().filter(p -> p.getProcedureStatus().equalsIgnoreCase(OmsbViewProceduresSupervisorWebPortletKeys.STATUS_NOT_PASS)).collect(Collectors.toList());
		List<TraineeLoggedProcedureDetailsDTO> passTraineeLoggedProcedureDetailsDTOs = traineeLoggedProcedureDetailsDTOs.stream().filter(p -> p.getProcedureStatus().equalsIgnoreCase(OmsbViewProceduresSupervisorWebPortletKeys.STATUS_PASS)).collect(Collectors.toList());
		
		renderRequest.setAttribute("traineeLoggedProcedureDetailsDTOs", traineeLoggedProcedureDetailsDTOs);
		renderRequest.setAttribute("unconfirmedTraineeLoggedProcedureDetailsDTOs", unconfirmedTraineeLoggedProcedureDetailsDTOs);
		renderRequest.setAttribute("refuseTraineeLoggedProcedureDetailsDTOs", refuseTraineeLoggedProcedureDetailsDTOs);
		renderRequest.setAttribute("notPassTraineeLoggedProcedureDetailsDTOs", notPassTraineeLoggedProcedureDetailsDTOs);
		renderRequest.setAttribute("passTraineeLoggedProcedureDetailsDTOs", passTraineeLoggedProcedureDetailsDTOs);
		renderRequest.setAttribute(OmsbViewProceduresSupervisorWebPortletKeys.SHOW_MODAL, isShowModal);
		renderRequest.setAttribute("traineeLoggedProcedureDetailsDTO", traineeLoggedProcedureDetailsDTO);
		renderRequest.setAttribute(OmsbViewProceduresSupervisorWebPortletKeys.TAB_NAME, tabName);
		super.render(renderRequest, renderResponse);
		_logger.info("render Exit ::: ");
	}
	
	@Reference
	private TraineeLoggedProcedureDetailsLocalService traineeLoggedProcedureDetailsLocalService;

	@Reference
	private UserMetadataUtil userMetadataUtil;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbViewProceduresSupervisorWebPortlet.class.getName());
}