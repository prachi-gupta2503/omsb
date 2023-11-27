package gov.omsb.dataflow.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.dataflow.constants.OmsbDataflowPortletKeys;


/**
 * @author Shaik Ali
 */
@Component(immediate = true, property = {
		"javax.portlet.name=" + OmsbDataflowPortletKeys.OMSBDATAFLOW,
		"mvc.command.name=" + "caseNumber" }, service = MVCActionCommand.class)
public class DFAddCaseNumberMVCActionCommand extends BaseMVCActionCommand {


	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		String caseNumber = ParamUtil.getString(actionRequest, "caseNumber");
		LOGGER.info("caseNumber:::"+caseNumber);
		omsbCommonApi.addCaseDetail(caseNumber);
		LOGGER.info("caseNumber::Successfully Added:");
	}
	
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	private static final Log LOGGER = LogFactoryUtil.getLog(DFAddCaseNumberMVCActionCommand.class);

}
