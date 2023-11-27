package gov.omsb.eligibility.degree.web.portlet.mvccommands;

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

import gov.omsb.eligibility.degree.web.constants.OmsbEligibilityDegreeWebPortletKeys;
import gov.omsb.tms.service.EligibilityDegreeMasterLocalService;

/**
 * 
 * @author Komal Gajera
 *
 */
@Component(immediate = true, property = { "javax.portlet.name=" + OmsbEligibilityDegreeWebPortletKeys.OMSBELIGIBILITYDEGREEWEB,
"mvc.command.name=" + OmsbEligibilityDegreeWebPortletKeys.DELETE_ELIGIBILITY_DEGREE_MVC_ACTION_COMMAND }, service = MVCActionCommand.class)
public class OmsbDeleteEligibilityDegreeMVCActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		_logger.info("ProcessAction Invoked ::: ");
		long eligibilityDegreeMasterId = ParamUtil.getLong(actionRequest, OmsbEligibilityDegreeWebPortletKeys.ELIGIBILITY_DEGREE_MASTER_ID, 0);
		try {
			eligibilityDegreeMasterLocalService.deleteEligibilityDegreeMaster(eligibilityDegreeMasterId);
			_logger.debug("ProcessAction ::: Eligibility Degree Master Record Deleted");
		} catch (PortalException e) {
			_logger.error(e);
			return false;
		}
		_logger.info("ProcessAction Exit ::: ");
		return true;
	}
	
	@Reference
	private EligibilityDegreeMasterLocalService eligibilityDegreeMasterLocalService;
	
	private static final Log _logger = LogFactoryUtil.getLog(OmsbDeleteEligibilityDegreeMVCActionCommand.class.getName());


}
