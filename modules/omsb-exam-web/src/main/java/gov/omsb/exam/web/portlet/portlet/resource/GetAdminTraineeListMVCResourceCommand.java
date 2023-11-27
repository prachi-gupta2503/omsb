package gov.omsb.exam.web.portlet.portlet.resource;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.exam.web.portlet.constants.MVCCommands;
import gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys;
import gov.omsb.exam.web.portlet.dto.ExamSchedule;
import gov.omsb.exam.web.portlet.dto.TraineeItem;
import gov.omsb.exam.web.portlet.portlet.render.ExaminationMVCRenderCommand;
import gov.omsb.exam.web.portlet.util.ExamSetupUtil;
import gov.omsb.exam.web.portlet.util.ExamUtil;
import gov.omsb.exam.web.portlet.util.ScheduleUtil;
import gov.omsb.tms.service.ProgramMasterLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + OMSBExamWebPortletKeys.OMSBEXAMWEB,
		"mvc.command.name=" + MVCCommands.GET_ADMIN_TRAINEE_LIST }, service = MVCResourceCommand.class)
public class GetAdminTraineeListMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		logger.info("admin trainee list serve resource () started");
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			String name = ParamUtil.getString(resourceRequest, "name");
			String email = ParamUtil.getString(resourceRequest, "email");
			long examScheduleId = ParamUtil.getLong(resourceRequest, "examScheduleId");
			List<TraineeItem> traineeItem = new ArrayList<>();
			TraineeItem trainee = new TraineeItem();
			List<User> users = null;
			if (!name.isEmpty() && !email.isEmpty()) {
				traineeItem = examUtil.getTraineeByNameAndEmail(name, email, themeDisplay, examScheduleId);
			} else if (!name.isEmpty() && email.isEmpty()) {
				logger.info("insdie name filter");
				users = examUtil.getUsersByName(name, name);
				for(User user: users) {
					 trainee = examUtil.setUserDetails(user, themeDisplay, examScheduleId);
					 traineeItem.add(trainee);
				}
				logger.info("traineeItem.size()"+traineeItem.size());
			} else if (name.isEmpty() && !email.isEmpty()) {
				logger.info("insdie email filter");
				User userEmail = userLocalService.getUserByEmailAddress(themeDisplay.getCompanyId(), email);
					trainee = examUtil.setUserDetails(userEmail, themeDisplay, examScheduleId);
					 traineeItem.add(trainee);
				
				logger.info("traineeItem.size()"+traineeItem.size());
			}
			resourceRequest.setAttribute("trainees", traineeItem);
			PortletRequestDispatcher dispatcher = resourceRequest.getPortletSession().getPortletContext()
					.getRequestDispatcher("/jsps/result/eligible-trainee-list.jsp");
			dispatcher.include(resourceRequest, resourceResponse);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.info("admin trainee list serve resource () ended");
		return false;
	}

	@Reference(unbind = "-")
	private UserLocalService userLocalService;

	@Reference
	private ExamSetupUtil examSetupUtil;

	@Reference
	private ScheduleUtil scheduleUtil;

	@Reference
	private ExamUtil examUtil;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference(unbind = "-")
	private ProgramMasterLocalService programMasterLocalService;

	private static final Log logger = LogFactoryUtil.getLog(GetAdminTraineeListMVCResourceCommand.class);
}
