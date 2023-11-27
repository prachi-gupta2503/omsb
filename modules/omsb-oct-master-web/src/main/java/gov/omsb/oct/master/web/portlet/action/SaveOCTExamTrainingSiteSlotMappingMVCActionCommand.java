package gov.omsb.oct.master.web.portlet.action;

import com.liferay.object.model.ObjectEntry;
import com.liferay.object.service.ObjectDefinitionService;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.oct.master.web.constants.OCTMasterConstants;
import gov.omsb.oct.master.web.constants.OmsbOctMasterWebPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbOctMasterWebPortletKeys.OMSBOCTMASTERWEB,
		"mvc.command.name=exam/save_training_slot", }, service = MVCActionCommand.class)
public class SaveOCTExamTrainingSiteSlotMappingMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		try {

			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

			long trainingSiteId = ParamUtil.getLong(actionRequest, OCTMasterConstants.TRAINING_SITE_ID);
		///	long noOfSlots = ParamUtil.getLong(actionRequest, OCTMasterConstants.NUMBER_OF_SLOTS);
			SimpleDateFormat _24HourSDF = new SimpleDateFormat("HH:mm");
			SimpleDateFormat _12HourSDF = new SimpleDateFormat("hh:mm a");

			if (Validator.isNotNull(trainingSiteId) ) {
				
					String start = ParamUtil.getString(actionRequest, OCTMasterConstants.START_TIME) ;
					String end = ParamUtil.getString(actionRequest, OCTMasterConstants.END_TIME) ;

					if (Validator.isNotNull(start) && Validator.isNotNull(end)) {
						Date _24HourDtStart = _24HourSDF.parse(start);
						Date _24HourDtEnd = _24HourSDF.parse(end);

						String timeSlot = _12HourSDF.format(_24HourDtStart) + StringPool.DASH + _12HourSDF.format(_24HourDtEnd);

						Map<String, Serializable> values = new HashMap<>();
						values.put(OCTMasterConstants.TRAINING_SITE_ID, trainingSiteId);
						values.put(OCTMasterConstants.TIME_SLOT, timeSlot);
						ObjectEntry objectEntry = omsbCommonApi.addObjectEntryByERC(
								OCTMasterConstants.OC_Exam_Training_Site_Slot_Master_ERC, values, actionRequest,
								themeDisplay);
						if (Validator.isNull(objectEntry)) {
							SessionErrors.add(actionRequest, OmsbOctMasterWebPortletKeys.SET_TRAINING_SITE_FORM_ERROR);
						}
					} else {
						SessionErrors.add(actionRequest, OmsbOctMasterWebPortletKeys.SET_TRAINING_SITE_FORM_ERROR);
					}
				
			} else {
				SessionErrors.add(actionRequest, OmsbOctMasterWebPortletKeys.SET_TRAINING_SITE_FORM_ERROR);
			}
		} catch (Exception e) {
			SessionErrors.add(actionRequest, OmsbOctMasterWebPortletKeys.SET_TRAINING_SITE_FORM_ERROR);
			if (logger.isErrorEnabled()) {
				logger.error(e.getMessage(), e);
			}
		}
	}

	@Reference
	private ObjectDefinitionService objectDefinitionService;

	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	private static final Log logger = LogFactoryUtil.getLog(SaveOCTExamTrainingSiteSlotMappingMVCActionCommand.class);
}
