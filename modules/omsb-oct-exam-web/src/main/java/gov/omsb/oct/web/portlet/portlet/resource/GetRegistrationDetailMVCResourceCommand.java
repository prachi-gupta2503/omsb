package gov.omsb.oct.web.portlet.portlet.resource;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.PrintWriter;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.dto.OCTRegistration;
import gov.omsb.oct.exam.web.portlet.dto.OCTRegistrationItem;
import gov.omsb.oct.exam.web.portlet.dto.OCTTrainingSlotMaster;
import gov.omsb.oct.exam.web.portlet.dto.OCTTrainingSlotMasterItems;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
		"mvc.command.name=" + MVCCommandNames.GET_REGISTRATION_DETAIL }, service = MVCResourceCommand.class)
public class GetRegistrationDetailMVCResourceCommand implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		try {
			
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long userId = themeDisplay.getUserId();
			long scheduleId = ParamUtil.getLong(resourceRequest, "scheduleId");
			OCTRegistrationItem registrationByUserIdAndScheduleId = octExamUtil.getRegistrationByUserIdAndScheduleIdAndRegStatus(themeDisplay, userId, scheduleId);
			JSONObject responseJson = JSONFactoryUtil.createJSONObject();
			logger.info(registrationByUserIdAndScheduleId.getItems());
			
			long size=0;
			String status="";
			if(Validator.isNotNull(registrationByUserIdAndScheduleId) && Validator.isNotNull(registrationByUserIdAndScheduleId.getItems())) {
				size=registrationByUserIdAndScheduleId.getItems().size();
				if(Validator.isNotNull(registrationByUserIdAndScheduleId.getItems().get(0))) {
					
					status=registrationByUserIdAndScheduleId.getItems().get(0).getRegStatus();
				}
			}
			
			responseJson.put("id", size);
			responseJson.put("status", status);
			logger.info(status);
			PrintWriter out = resourceResponse.getWriter();
			out.println(responseJson);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return Boolean.FALSE;
	}

	
	
	@Reference(unbind = "-")
	private OCTExamUtil octExamUtil;
	
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	private static final Log logger = LogFactoryUtil.getLog(GetRegistrationDetailMVCResourceCommand.class);
}
