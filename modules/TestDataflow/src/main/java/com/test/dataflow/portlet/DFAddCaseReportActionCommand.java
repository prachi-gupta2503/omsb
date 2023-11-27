package com.test.dataflow.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.test.dataflow.constants.TestDataflowPortletKeys;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;

@Component(immediate = true, property = {
		"javax.portlet.name=" + TestDataflowPortletKeys.TESTDATAFLOW,
		"mvc.command.name=" + "caseReport" }, service = MVCActionCommand.class)
public class DFAddCaseReportActionCommand extends BaseMVCActionCommand {


	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		String caseNumber = ParamUtil.getString(actionRequest, "caseNumber");
		LOGGER.info("caseNumber:::"+caseNumber);
		omsbCommonApi.addCaseReport(caseNumber);
		LOGGER.info("caseReport::Successfully Added:");
	}
	
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;

	private static final Log LOGGER = LogFactoryUtil.getLog(DFAddCaseReportActionCommand.class);

}