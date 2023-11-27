package gov.omsb.configure.rotations.web.portlet.mvccommands;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.configure.rotations.web.constants.OmsbConfigureRotationsWebPortletKeys;
import gov.omsb.tms.model.ProgramDurationDetails;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;

/**
 * @author Komal Gajera
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbConfigureRotationsWebPortletKeys.OMSBCONFIGUREROTATIONSWEB,
"mvc.command.name=" + OmsbConfigureRotationsWebPortletKeys.GET_PROGRAM_DURATION_MVC_RESOURCE_COMMAND }, service = MVCResourceCommand.class)
public class OmsbGetProgramDurationsMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		_logger.info("ServeResource Invoked ::: ");
		Long programMasterId = ParamUtil.getLong(resourceRequest, OmsbConfigureRotationsWebPortletKeys.PROGRAM_MASTER_ID);
		List<ProgramDurationDetails> programDurationDetails =  new ArrayList<>(programDurationDetailsLocalService.findProgramDurationByProgramId(programMasterId));
        Collections.sort(programDurationDetails, Comparator.comparing(ProgramDurationDetails::getAyApplicableForm));
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		String json = mapper.writeValueAsString(programDurationDetails);
		resourceResponse.getWriter().write(json);
		_logger.info("ServeResource Exit ::: ");
	}

	@Reference
	private ProgramDurationDetailsLocalService programDurationDetailsLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbGetProgramDurationsMVCResourceCommand.class.getName());
}
