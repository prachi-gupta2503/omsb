package gov.omsb.patient.types.web.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.Portlet;
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
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=OMSB",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=OmsbPatientTypesWeb",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=" + OmsbPatientTypesWebPortletKeys.ADD_PATIENT_TYPE_JSP,
		"javax.portlet.name=" + OmsbPatientTypesWebPortletKeys.OMSBPATIENTTYPESWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class OmsbPatientTypesWebPortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		_logger.info("render Invoked ::: ");
		SimpleDateFormat sdf = new SimpleDateFormat(OmsbPatientTypesWebPortletKeys.DATE_FORMAT_DD_MM_YYYY);
		List<PatientTypeMaster> patientTypeMasterList = patientTypeMasterLocalService.getPatientTypeMasters(-1, -1).stream()
				.sorted(Comparator.comparing(PatientTypeMaster::getModifiedDate).reversed()).collect(Collectors.toList());
		
		renderRequest.setAttribute(OmsbPatientTypesWebPortletKeys.PATIENT_TYPE_MASTER_LIST, patientTypeMasterList);
		renderRequest.setAttribute(OmsbPatientTypesWebPortletKeys.DATE_FORMAT_VARIABLE, sdf);
		
		super.render(renderRequest, renderResponse);
		_logger.info("render Exit ::: ");
	}
	
	@Reference
	private PatientTypeMasterLocalService patientTypeMasterLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbPatientTypesWebPortlet.class.getName());
}