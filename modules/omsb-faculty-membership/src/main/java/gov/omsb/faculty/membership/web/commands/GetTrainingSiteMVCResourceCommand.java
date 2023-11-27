package gov.omsb.faculty.membership.web.commands;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.Writer;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.faculty.membership.web.constants.FacultyMembershipPortletKeys;
import gov.omsb.faculty.membership.web.constants.FacultyRequestConstants;
import gov.omsb.faculty.membership.web.util.MasterDataUtil;
import gov.omsb.tms.custom.dto.TrainingSiteByProgramDTO;

@Component(immediate = true, property = { "javax.portlet.name=" + FacultyMembershipPortletKeys.FACULTYMEMBERSHIPREQUEST,
		"mvc.command.name=" + FacultyRequestConstants.GET_TRAINING_SITE_RESOURCE_COMMMAND }, service = MVCResourceCommand.class)
public class GetTrainingSiteMVCResourceCommand extends BaseMVCResourceCommand {

	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		LOGGER.info("training site");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long programId = ParamUtil.getLong(resourceRequest, FacultyRequestConstants.PROGRAM_ID);
		List<TrainingSiteByProgramDTO> trainingSiteList = masterDataUtil.getTrainingSiteByProgram(programId,
				themeDisplay.getLanguageId());
		LOGGER.info("Training Site List" + trainingSiteList);
		Writer wtr = resourceResponse.getWriter();
		String request = JSONFactoryUtil.looseSerializeDeep(trainingSiteList);
		wtr.write(request);
	}

	private static final Log LOGGER = LogFactoryUtil.getLog(GetTrainingSiteMVCResourceCommand.class);

	@Reference
	private MasterDataUtil masterDataUtil;
}
