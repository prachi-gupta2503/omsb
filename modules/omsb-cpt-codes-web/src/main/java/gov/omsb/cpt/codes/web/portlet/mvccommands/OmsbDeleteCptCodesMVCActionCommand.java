package gov.omsb.cpt.codes.web.portlet.mvccommands;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.cpt.codes.web.constants.OmsbCptCodesConstants;
import gov.omsb.cpt.codes.web.constants.OmsbCptCodesWebPortletKeys;
import gov.omsb.tms.service.CptCodeMasterLocalService;

/**
 * @author Aditya Meghnathi
 */

@Component(property = { "javax.portlet.name=" + OmsbCptCodesWebPortletKeys.OMSBCPTCODESWEB, "mvc.command.name="
		+ OmsbCptCodesConstants.DELETE_CPT_CODES_MVC_COMMAND_NAME }, service = MVCActionCommand.class)
public class OmsbDeleteCptCodesMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		_logger.info("doProcessAction Invoked ::: ");
		long cptCodeMasterId = ParamUtil.getLong(actionRequest, OmsbCptCodesConstants.CPT_CODE_MASTER_ID,
				GetterUtil.DEFAULT_LONG);
		cptCodeMasterLocalService.deleteCptCodeMaster(cptCodeMasterId);
		_logger.debug("doProcessAction ::: CPT Code Master Record Deleted");
		_logger.info("doProcessAction Exit ::: ");
	}

	@Reference
	private CptCodeMasterLocalService cptCodeMasterLocalService;

	private static final Log _logger = LogFactoryUtil.getLog(OmsbDeleteCptCodesMVCActionCommand.class.getName());
}
