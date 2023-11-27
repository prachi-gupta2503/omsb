package gov.omsb.master.rotation.schedule.web.portlet.mvccommands;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.JSONPortletResponseUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.dto.UserMetadata;
import gov.omsb.common.service.util.UserMetadataUtil;
import gov.omsb.master.rotation.schedule.web.constants.OmsbMasterRotationScheduleWebPortletKeys;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;

@Component(
    immediate = true,
    property = {
        "javax.portlet.name=" + OmsbMasterRotationScheduleWebPortletKeys.OMSBMASTERROTATIONSCHEDULEWEB,
        "mvc.command.name=" + OmsbMasterRotationScheduleWebPortletKeys.GET_FACULTY_MVC_RESOURCE_COMMAND
    },
    service = MVCResourceCommand.class
)
public class OmsbGetFacultyMVCResourceCommand extends BaseMVCResourceCommand {

    @Override
    protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
            throws Exception {
        _logger.info("ServeResource Invoked ::: ");

        JSONObject resultJson = JSONFactoryUtil.createJSONObject();
        Map<Long, String> facultyMap = new HashMap<>();

        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

        try {
            long programMasterId = ParamUtil.getLong(resourceRequest, OmsbTmsCommonConstants.PROGRAM_MASTER_ID);
            Role facultyRole = roleLocalService.getRole(PortalUtil.getDefaultCompanyId(), OmsbTmsCommonConstants.FACULTY_ROLE);
            List<UserMetadata> userMetadataList = userMetadataUtil.getUserMetadataItemsByProgramIdAndRoleId(
                themeDisplay.getPortalURL(), themeDisplay.getScopeGroupId(), programMasterId, facultyRole.getRoleId()
            ).getItems();

            for (UserMetadata userMetadata : userMetadataList) {
                User user = userLocalService.fetchUser(userMetadata.getLrUserId());
                if (Validator.isNotNull(user)) {
                    facultyMap.put(userMetadata.getLrUserId(), user.getFullName());
                }
            }
            resultJson.put(CommonConstants.SUCCESS, true);
        } catch (Exception e) {
            _logger.error("Error serving resource: " + e.getMessage(), e);
            resultJson.put(CommonConstants.SUCCESS, false);
        }

        resultJson.put(CommonConstants.RESULT, facultyMap);
        JSONPortletResponseUtil.writeJSON(resourceRequest, resourceResponse, resultJson);

        _logger.info("ServeResource Exit ::: ");
    }
    
    @Reference
    private RoleLocalService roleLocalService;
    
    @Reference
    private UserLocalService userLocalService;
    
    @Reference
    private UserMetadataUtil userMetadataUtil;

    private static final Log _logger = LogFactoryUtil.getLog(OmsbGetFacultyMVCResourceCommand.class);
}
