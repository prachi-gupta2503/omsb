package gov.omsb.define.rotation.and.shared.rotations.web.mvccommands;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.define.rotation.and.shared.rotations.web.constants.OmsbDefineRotationAndSharedRotationsWebPortletKeys;
import gov.omsb.define.rotation.and.shared.rotations.web.util.OmsbDefineRotationAndSharedRotationsUtil;
import gov.omsb.tms.common.constants.OmsbTmsCommonConstants;
import gov.omsb.tms.model.ProgramMaster;
import gov.omsb.tms.service.ProgramMasterLocalService;


/**
 * @author Jayesh Goswami
 */
@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbDefineRotationAndSharedRotationsWebPortletKeys.OMSBDEFINEROTATIONANDSHAREDROTATIONSWEB,
		"mvc.command.name=/getPrograms" }, service = MVCResourceCommand.class)
public class OmsbGetProgramListMVCResourceCommand implements MVCResourceCommand {
	
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException {
		_logger.info("doServeResource Invoked :::");
		
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		long programMasterId = ParamUtil.getLong(resourceRequest, OmsbTmsCommonConstants.PROGRAM, 0);
		List<ProgramMaster> programMasterList =  omsbDefineRotationAndSharedRotationsUtil.getLoggedInUsersProgram(themeDisplay);
		
		try {
			JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
			for (ProgramMaster program : programMasterList) {
				if(program.getProgramMasterId() != programMasterId) {
					JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
					jsonObject.put(OmsbTmsCommonConstants.PROGRAM_MASTER_ID, program.getProgramMasterId());
					jsonObject.put(OmsbTmsCommonConstants.PROGRAM_NAME, program.getProgramName(themeDisplay.getLocale()));
					jsonArray.put(jsonObject);	
				}
			}
			resourceResponse.getWriter().write(jsonArray.toJSONString());
		} catch (IOException e) {
			_logger.error(e);
		}
		
		_logger.info("doServeResource Exit :::");
		return true;
	}
	
	@Reference(unbind = "_")
	OmsbDefineRotationAndSharedRotationsUtil omsbDefineRotationAndSharedRotationsUtil;
	
	@Reference
	private ProgramMasterLocalService programMasterLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbGetProgramListMVCResourceCommand.class.getName());

}
