package gov.omsb.log.procedures.web.mvcaction;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.log.procedures.web.constants.OmsbLogProceduresConstants;
import gov.omsb.log.procedures.web.constants.OmsbLogProceduresWebPortletKeys;
import gov.omsb.tms.model.TrainingSitesMaster;
import gov.omsb.tms.service.TrainingSitesMasterLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbLogProceduresWebPortletKeys.OMSBLOGPROCEDURESWEB,
		"mvc.command.name="
				+ OmsbLogProceduresConstants.FETCH_TRAINING_SITE_RESOURCE_COMMAND }, service = MVCResourceCommand.class)
public class OmsbFetchTrainingSiteMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		JSONObject finalJSONObj = JSONFactoryUtil.createJSONObject();
		
		String datePerformed = ParamUtil.getString(resourceRequest, OmsbLogProceduresConstants.PROCEDURE_PERFORMED_DATE);
		SimpleDateFormat inputFormat = new SimpleDateFormat(OmsbLogProceduresConstants.STORE_DATE_FORMAT);
		Date date = inputFormat.parse(datePerformed);
		SimpleDateFormat outputFormat = new SimpleDateFormat(OmsbLogProceduresConstants.GET_DATE_FORMAT);
		String formatPerformedDate = outputFormat.format(date);

		_logger.debug("datePerformed----------------- " + formatPerformedDate);
		
		TrainingSitesMaster trainingSitesMaster = trainingSitesMasterLocalService.getTrainingSiteByDatePerformed(formatPerformedDate, themeDisplay.getUserId());
		
		_logger.debug("found trainingSitesMaster----------------- " + Validator.isNotNull(trainingSitesMaster));
		
		if (Validator.isNotNull(trainingSitesMaster)) {
			finalJSONObj.put(OmsbLogProceduresConstants.ID, trainingSitesMaster.getTrainingSiteMasterId());
			finalJSONObj.put(OmsbLogProceduresConstants.NAME, trainingSitesMaster.getTrainingSiteName(themeDisplay.getLocale()));
		}
		resourceResponse.getWriter().write(finalJSONObj.toString());
	}
	
	@Reference
	private TrainingSitesMasterLocalService trainingSitesMasterLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbFetchTrainingSiteMVCResourceCommand.class);
}
