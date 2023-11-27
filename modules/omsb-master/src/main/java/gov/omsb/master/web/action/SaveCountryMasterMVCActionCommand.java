package gov.omsb.master.web.action;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Country;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.CountryLocalService;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.master.web.constants.MVCCommandNames;
import gov.omsb.master.web.constants.OmsbMasterPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + OmsbMasterPortletKeys.OMSBMASTER,
		"mvc.command.name="
				+ MVCCommandNames.SAVE_COUNTRY_MAPPING_MVC_ACTION_COMMAND, }, service = MVCActionCommand.class)
public class SaveCountryMasterMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		logger.info("SaveCountryMasterMVCActionCommand started()");
		String countryValue = ParamUtil.getString(actionRequest, "countryValue");
		logger.info("countryValue "+countryValue);
		Country country = countryLocalService.createCountry(CounterLocalServiceUtil.increment(Country.class.getName()));
		country.setName(countryValue);
		countryLocalService.addCountry(country);
	}
 
	private static final Log logger = LogFactoryUtil.getLog(SaveDepartmentSectionMVCActionCommand.class);
	
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
	
	@Reference(unbind = "-")
	private CountryLocalService countryLocalService;
}
