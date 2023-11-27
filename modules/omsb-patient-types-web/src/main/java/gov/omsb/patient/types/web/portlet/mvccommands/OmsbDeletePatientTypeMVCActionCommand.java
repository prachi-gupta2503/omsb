package gov.omsb.patient.types.web.portlet.mvccommands;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.patient.types.web.constants.OmsbPatientTypesWebPortletKeys;
import gov.omsb.tms.service.PatientTypeMasterLocalService;

/**
 * 
 * @author Jayesh Goswami
 *
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbPatientTypesWebPortletKeys.OMSBPATIENTTYPESWEB,
"mvc.command.name=" + OmsbPatientTypesWebPortletKeys.DELETE_PATIENT_TYPE_MVC_ACTION_COMMAND }, service = MVCActionCommand.class)
public class OmsbDeletePatientTypeMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		_logger.info("ProcessAction Invoked ::: ");
		long patientTypeMasterId = ParamUtil.getLong(actionRequest, OmsbPatientTypesWebPortletKeys.PATIENT_TYPE_MASTER_ID, 0);
		try {
			patientTypeMasterLocalService.deletePatientTypeMaster(patientTypeMasterId);
			_logger.debug("ProcessAction ::: Patient Type Master Record Deleted");
		} catch (PortalException e) {
			_logger.error(e);
			return false;
		}
		_logger.info("ProcessAction Exit ::: ");
		return true;
	}
	
	@Reference
	private PatientTypeMasterLocalService patientTypeMasterLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbDeletePatientTypeMVCActionCommand.class.getName());


}
