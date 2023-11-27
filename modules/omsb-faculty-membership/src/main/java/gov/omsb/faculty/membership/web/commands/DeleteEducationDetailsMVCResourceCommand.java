package gov.omsb.faculty.membership.web.commands;

import com.liferay.object.service.ObjectEntryLocalService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.faculty.membership.web.constants.FacultyMembershipConstants;
import gov.omsb.faculty.membership.web.constants.FacultyMembershipPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + FacultyMembershipPortletKeys.FACULTYMEMBERSHIP,
		"mvc.command.name="
				+ FacultyMembershipConstants.DELETE_EDUCATION_DETAILS_RESOURCE_COMMAND }, service = MVCResourceCommand.class)
public class DeleteEducationDetailsMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
		
		String educationId = httpRequest.getParameter("educationId");
		String personId = httpRequest.getParameter("personId");
		
		long educationDetailsId = 0;
		
		if(Validator.isNotNull(educationId)) {
			educationDetailsId = Long.valueOf(educationId);
		}
		
		log.info("Education ID :: " + educationDetailsId);
		log.info("Person ID :: " + personId);
		

		JSONObject responseJSONObj = JSONFactoryUtil.createJSONObject();
		
		try {
			objectEntryLocalServiceUtil.deleteObjectEntry(educationDetailsId);
			log.info("=================Object Deleted Successfully=================");
			responseJSONObj.put(FacultyMembershipConstants.STATUS_KEY, FacultyMembershipConstants.SUCCESS);
			responseJSONObj.put(FacultyMembershipConstants.MESSAGE_KEY, StringPool.BLANK);
		} catch (PortalException e1) {
			log.error("==================Error While Deleting Object============================");
			responseJSONObj.put(FacultyMembershipConstants.STATUS_KEY, FacultyMembershipConstants.FAIL);
			responseJSONObj.put(FacultyMembershipConstants.MESSAGE_KEY, StringPool.BLANK);
		}
		
		resourceResponse.getWriter().write(responseJSONObj.toJSONString());
		
	}
	

	@Reference
	private ObjectEntryLocalService objectEntryLocalServiceUtil;
	
	private Log log = LogFactoryUtil.getLog(DeleteEducationDetailsMVCResourceCommand.class.getName());

}