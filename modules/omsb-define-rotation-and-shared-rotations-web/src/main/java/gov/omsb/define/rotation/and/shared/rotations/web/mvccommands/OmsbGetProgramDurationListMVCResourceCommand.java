package gov.omsb.define.rotation.and.shared.rotations.web.mvccommands;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.define.rotation.and.shared.rotations.web.constants.OmsbDefineRotationAndSharedRotationsWebPortletKeys;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.model.ProgramDurationDetails;
import gov.omsb.tms.service.ProgramDurationDetailsLocalService;


/**
 * @author Jayesh Goswami
 */
@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbDefineRotationAndSharedRotationsWebPortletKeys.OMSBDEFINEROTATIONANDSHAREDROTATIONSWEB,
		"mvc.command.name=/getProgramDurationURL" }, service = MVCResourceCommand.class)
public class OmsbGetProgramDurationListMVCResourceCommand implements MVCResourceCommand {
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException {
		_logger.info("doServeResource Invoked :::");
		
		long programMasterId = ParamUtil.getLong(resourceRequest, OmsbTmsCommonConstants.PROGRAM, 0);
		List<ProgramDurationDetails> programDurationDetails = programDurationDetailsLocalService.findProgramDurationByProgramId(programMasterId);
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		try {
			String json = mapper.writeValueAsString(programDurationDetails);
			resourceResponse.getWriter().write(json);
		} catch (IOException e) {
			_logger.error(e);
		}
		
		_logger.info("doServeResource Exit :::");
		return true;
	}
	@Reference
	private ProgramDurationDetailsLocalService programDurationDetailsLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbGetProgramDurationListMVCResourceCommand.class.getName());

}
