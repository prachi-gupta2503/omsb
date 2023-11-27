package gov.omsb.setup.procedures.web.mvcactions;

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

import gov.omsb.setup.procedures.web.constants.OmsbSetupProceduresWebPortletKeys;
import gov.omsb.tms.model.ProgramDurationDetails;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;

/**
 * 
 * @author Aditya Meghnathi
 *
 */
@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbSetupProceduresWebPortletKeys.OMSBSETUPPROCEDURESWEB,
		"mvc.command.name=/getProgramDurationURL" }, service = MVCResourceCommand.class)
public class OmsbProgramDurationMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		_logger.info("OmsbProgramDurationMVCResourceCommand doServeResource :::");
		String programMasterId = ParamUtil.getString(resourceRequest, OmsbSetupProceduresWebPortletKeys.PROGRAM);
		List<ProgramDurationDetails> programDurationDetails = new ArrayList<>(programDurationDetailsLocalService
				.findProgramDurationByProgramId(Long.parseLong(programMasterId)));
        Collections.sort(programDurationDetails, Comparator.comparing(ProgramDurationDetails::getAyApplicableForm));

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		String json = mapper.writeValueAsString(programDurationDetails);
		resourceResponse.getWriter().write(json);
	}

	@Reference
	private ProgramDurationDetailsLocalService programDurationDetailsLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbProgramDurationMVCResourceCommand.class.getName());
}
