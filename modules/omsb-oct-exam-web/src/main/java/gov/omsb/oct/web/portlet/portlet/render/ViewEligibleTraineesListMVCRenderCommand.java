package gov.omsb.oct.web.portlet.portlet.render;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.constants.CommonConstants;
import gov.omsb.common.constants.RoleNameConstants;
import gov.omsb.common.dto.UserMetadataItem;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CommonUtil;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamSchedule;
import gov.omsb.oct.exam.web.portlet.dto.OCTRegistrationItem;
import gov.omsb.oct.exam.web.portlet.dto.RegistrationItem;
import gov.omsb.oct.exam.web.portlet.dto.Trainee;
import gov.omsb.oct.exam.web.portlet.dto.TraineeItems;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name=" + MVCCommandNames.VIEW_ELIGIBLE_TRAINEES_LIST_RENDER, }, service = MVCRenderCommand.class)
public class ViewEligibleTraineesListMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String portalUrl = themeDisplay.getPortalURL();
		Locale locale = themeDisplay.getLocale();
		long scopeGroupId = themeDisplay.getScopeGroupId();
		String departmentIdString = ParamUtil.getString(renderRequest, "departmentId");
		String sectionIdString = ParamUtil.getString(renderRequest, "sectionId");
		String examDefinitionIdString = ParamUtil.getString(renderRequest, "examDefinitionId");
		String examScheduleIdString = ParamUtil.getString(renderRequest, "examScheduleId");
		String examTitle = ParamUtil.getString(renderRequest, "examTitle");
		logger.info("examTitle:"+examTitle + "examScheduleIdString :"+examScheduleIdString);
		long departmentId = 0l;
		long sectionId = 0l;
		long examDefinitionId = 0l;
		long examScheduleId = 0l;
		if (Validator.isNotNull(departmentIdString)) {
			departmentId = Long.parseLong(departmentIdString);
		}
		if (Validator.isNotNull(sectionIdString)) {
			sectionId = Long.parseLong(sectionIdString);
		}
		if (Validator.isNotNull(examDefinitionIdString)) {
			examDefinitionId = Long.parseLong(examDefinitionIdString);
		}
		if (Validator.isNotNull(examScheduleIdString)) {
			examScheduleId = Long.parseLong(examScheduleIdString);
		}

		long roleId = 0;
		try {
			Role role = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), RoleNameConstants.EXAM_APPLICANT);

			if (Validator.isNotNull(role)) {

				roleId = role.getRoleId();
			}

		} catch (PortalException e) {
			logger.error(e.getMessage());
		}

		List<Trainee> trainees = getListOfTrainees(portalUrl, scopeGroupId, examScheduleId, roleId);

//		OCTRegistrationItem octRegistrationItem = octExamUtil.getOCTExamRegistrationByScheduleId(portalUrl,
//				scopeGroupId, examScheduleId);

//		List<Trainee> traineeList = getListOfTrainees(octRegistrationItem);

		renderRequest.setAttribute("traineeList", trainees);
		renderRequest.setAttribute("examTitle", examTitle);
		return OmsbOctExamWebPortletKeys.VIEW_ELIGIBLE_TRAINEES_LIST_JSP;
	}

	public List<Trainee> getListOfTrainees(String portalURL, long groupId, long examScheduleId, long roleId) {

		List<Trainee> trainees = new ArrayList<Trainee>();
		List<User> octapplicantUsers = UserLocalServiceUtil.getRoleUsers(roleId);
		for (User user : octapplicantUsers) {

			OCTRegistrationItem octRegistrationItem = getTraineeRegistrationStatus(portalURL, groupId,
					user.getUserId());
			if (Validator.isNotNull(octRegistrationItem) && octRegistrationItem.getItems().size() > 0) {

				for (int i = 0; i < octRegistrationItem.getItems().size(); i++) {

					Trainee trainee = new Trainee();
					trainee.setLrUserId(user.getUserId());
					trainee.setName(user.getFullName());

					logger.info("Status....." + octRegistrationItem.getItems().get(i).getRegStatus());
					trainee.setRegistrationId(octRegistrationItem.getItems().get(0).getId());
					trainee.setRegistrationStatus(octRegistrationItem.getItems().get(i).getRegStatus());
					trainee.setSectionId(user.getCompanyId());
					trainee.setRegistrationId(octRegistrationItem.getItems().get(i).getId());
					trainee.setScheduleId(examScheduleId);
					trainees.add(trainee);
				}
			}

		}
		return trainees;
	}

	public OCTRegistrationItem getTraineeRegistrationStatus(String portalURL, long groupId, long userId) {

		String examRegistrationURL = portalURL + LRObjectURL.OC_EXAM_REGISTRATION_URL + CommonConstants.SCOPES
				+ StringPool.SLASH + groupId + StringPool.QUESTION + "filter=lrUserId"
				+ URLEncoder.encode(" eq " + userId, StandardCharsets.UTF_8);
		logger.info("11111111111111111111111111111111111111111111111111111111" + examRegistrationURL);
		String examRegistrationResponse = commonApi.getData(examRegistrationURL);

		logger.info("examRegistrationResponse ... " + examRegistrationResponse);
		if (Validator.isNotNull(examRegistrationResponse)) {
			OCTRegistrationItem octRegistrationItem = CustomObjectMapperUtil.readValue(examRegistrationResponse,
					OCTRegistrationItem.class);
			if (octRegistrationItem.getItems().size() > 0) {
				return octRegistrationItem;
			}
		}
		return null;
	}

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference(unbind = "-")
	private OMSBCommonApi commonApi;

	@Reference(unbind = "-")
	private OCTExamUtil octExamUtil;

	private static final Log logger = LogFactoryUtil.getLog(ViewEligibleTraineesListMVCRenderCommand.class);
}
