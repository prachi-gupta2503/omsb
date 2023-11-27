package gov.omsb.log.procedures.web.mvcaction;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.log.procedures.web.constants.OmsbLogProceduresConstants;
import gov.omsb.log.procedures.web.constants.OmsbLogProceduresWebPortletKeys;
import gov.omsb.tms.model.TraineeLoggedProcedureDetails;
import gov.omsb.tms.service.TraineeLoggedProcedureDetailsLocalService;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbLogProceduresWebPortletKeys.OMSBLOGPROCEDURESWEB,
		"mvc.command.name="
				+ OmsbLogProceduresConstants.FILTER_LOGGED_PROCEDURE_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class OmsbFilterLogProcedureMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		String tabName = ParamUtil.getString(renderRequest, OmsbLogProceduresConstants.TAB_NAME);
		String status = ParamUtil.getString(renderRequest, OmsbLogProceduresConstants.STATUS);
		String startDate = ParamUtil.getString(renderRequest,OmsbLogProceduresConstants.START_DATE);
		String endDate = ParamUtil.getString(renderRequest,OmsbLogProceduresConstants.END_DATE);
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		DynamicQuery dynamicQuery = traineeLoggedProcedureDetailsLocalService.dynamicQuery();

		try {

			if (Validator.isNotNull(startDate) && Validator.isNotNull(endDate)) {
				Date fromDate = getFormattedDate(startDate, true);
				Date toDate = getFormattedDate(endDate, false);
				dynamicQuery.add(RestrictionsFactoryUtil
						.between(OmsbLogProceduresConstants.PROCEDURE_PERFORMED_DATE_DB_COLUMN_NAME, fromDate, toDate));		
			} else if (Validator.isNotNull(startDate)) {
				Date fromDate = getFormattedDate(startDate, true);
				dynamicQuery.add(RestrictionsFactoryUtil
						.ge(OmsbLogProceduresConstants.PROCEDURE_PERFORMED_DATE_DB_COLUMN_NAME, fromDate));
			} else if (Validator.isNotNull(endDate)) {
				Date toDate = getFormattedDate(endDate, false);
				dynamicQuery.add(RestrictionsFactoryUtil
						.le(OmsbLogProceduresConstants.PROCEDURE_PERFORMED_DATE_DB_COLUMN_NAME, toDate));
			}
			dynamicQuery.add(RestrictionsFactoryUtil.eq("traineeId",themeDisplay.getUserId()));
			
			if(!status.isBlank()) {
				dynamicQuery.add(RestrictionsFactoryUtil.eq("procedureStatus", status));
			}
			
			List<TraineeLoggedProcedureDetails> loggedProcedureDetails = traineeLoggedProcedureDetailsLocalService
					.dynamicQuery(dynamicQuery);
		

			if(status.equalsIgnoreCase(OmsbLogProceduresConstants.STATUS_UNCONFIRMED)) {
				renderRequest.setAttribute(OmsbLogProceduresConstants.UNCONFIRMED_PROCEDURES_LIST, loggedProcedureDetails);				
			}
			else if(status.equalsIgnoreCase(OmsbLogProceduresConstants.STATUS_REFUSE)) {
				renderRequest.setAttribute(OmsbLogProceduresConstants.REFUSED_LOGGED_PROCEDURES_LIST, loggedProcedureDetails);
			}
			else if(status.equalsIgnoreCase(OmsbLogProceduresConstants.STATUS_NOT_PASS)) {
				renderRequest.setAttribute(OmsbLogProceduresConstants.NOT_PASS_LOGGED_PROCEDURES_LIST, loggedProcedureDetails);
			}
			else if(status.equalsIgnoreCase(OmsbLogProceduresConstants.STATUS_PASS)) {
				renderRequest.setAttribute(OmsbLogProceduresConstants.PASS_LOGGED_PROCEDURES_LIST, loggedProcedureDetails);
			} else {
				renderRequest.setAttribute(OmsbLogProceduresConstants.LOGGED_PROCEDURES, loggedProcedureDetails);
			}
			renderRequest.setAttribute(OmsbLogProceduresConstants.TAB_NAME, tabName);
			renderRequest.setAttribute(OmsbLogProceduresConstants.START_DATE, startDate);
			renderRequest.setAttribute(OmsbLogProceduresConstants.END_DATE, endDate);
		} catch (ParseException e) {
			log.error("Exception Occurred -> " + e.getMessage());
		}

		log.info("Filter Logged Procedure Command Invoked.....");

		return OmsbLogProceduresConstants.VIEW_PROCEDURES_JSP;
	}

	private Date getFormattedDate(String date, boolean isStartDate) throws ParseException {

		if (isStartDate) {
			date = date + " 00:00 AM";
		} else {
			date = date + " 11:59 PM";
		}

		DateFormat originalFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm a");
		Date dateOF = originalFormat.parse(date);

		DateFormat targetDateFormat = new SimpleDateFormat(OmsbLogProceduresConstants.STORE_DATE_FORMAT);
		String formattedDate = targetDateFormat.format(dateOF);

		return targetDateFormat.parse(formattedDate);

	}

	@Reference
	TraineeLoggedProcedureDetailsLocalService traineeLoggedProcedureDetailsLocalService;

	private Log log = LogFactoryUtil.getLog(OmsbFilterLogProcedureMVCRenderCommand.class.getName());

}