package gov.omsb.oct.web.portlet.portlet.action;


import com.liferay.object.service.ObjectDefinitionService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.common.object.url.LRObjectURL;
import gov.omsb.common.util.CustomObjectMapperUtil;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.oct.exam.web.constants.MVCCommandNames;
import gov.omsb.oct.exam.web.constants.OCTExamConstants;
import gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys;
import gov.omsb.oct.exam.web.portlet.dto.OCTExamSchedule;
import gov.omsb.oct.exam.web.portlet.dto.OCTRegistration;
import gov.omsb.oct.exam.web.portlet.dto.Registration;
import gov.omsb.oct.exam.web.portlet.util.OCTExamUtil;

/**
 * 
 * @author TanusreeD
 *
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctExamWebPortletKeys.OMSBOCTEXAMWEB,
"mvc.command.name="+MVCCommandNames.UPDATE_EXAM_REGISTRATION_STATUS }, service = MVCActionCommand.class)
public class UpdateOCTRegistrationStatusMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		logger.info("doProcessAction () started::");
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long id=ParamUtil.getLong(actionRequest, "id");
		try {
			OCTRegistration registration = getItems(themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_REGISTRATION_URL + id, OCTRegistration.class);
			registration.setRegStatus(OCTExamConstants.REGISTERED_STATUS_KEY);
			
			String registrationMapper = CustomObjectMapperUtil.writeValueAsString(registration, null);
			Map<String, String> headers = omsbCommonApi.getHttpHeaderInfoAndBasicAuth();	
			omsbHttpConnector.executePut(
						themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_REGISTRATION_URL + id,
						registrationMapper, headers);
			
			OCTExamSchedule examSchedule = getItems(themeDisplay.getPortalURL() + LRObjectURL.OC_EXAM_SCHEDULE + registration.getExamScheduleId(), OCTExamSchedule.class);
			actionResponse.getRenderParameters().setValue("departmentId", String.valueOf(examSchedule.getDepartmentId()));
			actionResponse.getRenderParameters().setValue("sectionId", String.valueOf(examSchedule.getSectionId()));
			actionResponse.getRenderParameters().setValue("examDefinitionId", String.valueOf(examSchedule.getOctExamDefinitionId()));
			actionResponse.getRenderParameters().setValue("examScheduleId", String.valueOf(examSchedule.getId()));
			actionResponse.getRenderParameters().setValue("mvcRenderCommandName", MVCCommandNames.VIEW_ELIGIBLE_TRAINEES_LIST_RENDER);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}
		
	public <T> T getItems(String url, Class<T> clazz) {
		String response = omsbCommonApi.getData(url);
		if (Validator.isNotNull(response)) {
			return CustomObjectMapperUtil.readValue(response, clazz);
		}
		return null;
	}

	@Reference
	private ObjectDefinitionService objectDefinitionService;


	@Reference(unbind = "-")
	private OMSBHttpConnector omsbHttpConnector;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	@Reference(unbind = "-")
	
	private OCTExamUtil oCTExamUtil;

	private Log logger = LogFactoryUtil.getLog(UpdateOCTRegistrationStatusMVCActionCommand.class);
}
