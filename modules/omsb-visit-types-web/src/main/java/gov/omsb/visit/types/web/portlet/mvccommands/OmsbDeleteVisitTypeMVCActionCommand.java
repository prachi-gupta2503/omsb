package gov.omsb.visit.types.web.portlet.mvccommands;

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

import gov.omsb.tms.service.VisitTypeMasterLocalService;
import gov.omsb.visit.types.web.constants.OmsbVisitTypesWebPortletKeys;

/**
 * 
 * @author Jayesh Goswami
 *
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbVisitTypesWebPortletKeys.OMSBVISITTYPESWEB,
"mvc.command.name=" + OmsbVisitTypesWebPortletKeys.DELETE_VISIT_TYPE_MVC_ACTION_COMMAND }, service = MVCActionCommand.class)
public class OmsbDeleteVisitTypeMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		_logger.info("ProcessAction Invoked ::: ");
		long visitTypeMasterId = ParamUtil.getLong(actionRequest, OmsbVisitTypesWebPortletKeys.VISIT_TYPE_MASTER_ID, 0);
		try {
			visitTypeMasterLocalService.deleteVisitTypeMaster(visitTypeMasterId);
			_logger.debug("ProcessAction ::: Visit Type Master Record Deleted");
		} catch (PortalException e) {
			_logger.error(e);
			return false;
		}
		_logger.info("ProcessAction Exit ::: ");
		return true;
	}
	
	@Reference
	private VisitTypeMasterLocalService visitTypeMasterLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbDeleteVisitTypeMVCActionCommand.class.getName());


}
