package gov.omsb.patient.types.web.portlet.mvccommands;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.patient.types.web.constants.OmsbPatientTypesWebPortletKeys;
import gov.omsb.tms.model.PatientTypeMaster;
import gov.omsb.tms.service.PatientTypeMasterLocalService;

/**
 * @author Jayesh Goswami
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbPatientTypesWebPortletKeys.OMSBPATIENTTYPESWEB,
"mvc.command.name=" + OmsbPatientTypesWebPortletKeys.EDIT_PATIENT_TYPE_MVC_RENDER_COMMAND }, service = MVCRenderCommand.class)
public class OmsbEditPatientTypeMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		_logger.info("render Invoked ::: ");
		long patientTypeMasterId = ParamUtil.getLong(renderRequest, OmsbPatientTypesWebPortletKeys.PATIENT_TYPE_MASTER_ID, 0);
		SimpleDateFormat sdf = new SimpleDateFormat(OmsbPatientTypesWebPortletKeys.DATE_FORMAT_DD_MM_YYYY);
		
		try {
			PatientTypeMaster patientTypeMaster = patientTypeMasterLocalService.getPatientTypeMaster(patientTypeMasterId);
			renderRequest.setAttribute(OmsbPatientTypesWebPortletKeys.PATIENT_TYPE, patientTypeMaster);

			List<PatientTypeMaster> patientTypeMasterList = patientTypeMasterLocalService.getPatientTypeMasters(-1, -1);
			renderRequest.setAttribute(OmsbPatientTypesWebPortletKeys.PATIENT_TYPE_MASTER_LIST, patientTypeMasterList);
			renderRequest.setAttribute(OmsbPatientTypesWebPortletKeys.DATE_FORMAT_VARIABLE, sdf);
		} catch (PortalException e) {
			_logger.error(e);
		}
		
		_logger.info("render Exit ::: ");
		return OmsbPatientTypesWebPortletKeys.EDIT_PATIENT_TYPE_JSP;
	}
	
	@Reference
	private PatientTypeMasterLocalService patientTypeMasterLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbEditPatientTypeMVCRenderCommand.class.getName());
}
