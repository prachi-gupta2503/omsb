package gov.omsb.tms.ecm.web.commands;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.UnsupportedEncodingException;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import gov.omsb.tms.ecm.web.constants.ECMembershipRequestPortletKeys;
import gov.omsb.tms.ecm.web.constants.MVCCommandNames;
import gov.omsb.tms.ecm.web.dto.EducationalDetailsItem;
import gov.omsb.tms.ecm.web.util.MembershipUtil;

@Component(immediate = true, property = { "javax.portlet.name=" + ECMembershipRequestPortletKeys.ECMEMBERSHIPREQUEST,
		"mvc.command.name="+MVCCommandNames.DELETE_EDUCATION_DETAILS_URL
}, service = MVCResourceCommand.class)
public class DeleteEducationDetailMVCResourceCommand implements MVCResourceCommand {

private  static final Log LOGGER =  LogFactoryUtil.getLog(DeleteEducationDetailMVCResourceCommand.class);

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		LOGGER.info("delete education details resource------ ");
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long educationDetailId=ParamUtil.getLong(resourceRequest, "id");
		LOGGER.info("id "+educationDetailId);
		try {
			EducationalDetailsItem educationalDetailsItem = membershipUtil.fetchEducationDetailsItemByEducationId(themeDisplay,educationDetailId);
			if (Validator.isNotNull(educationalDetailsItem)) {
				omsbCommonApi.deleteObjectEntryEntryId(educationalDetailsItem.getId());
			}
		} catch (UnsupportedEncodingException e) {
			LOGGER.info("Error in  "+e.getMessage());

		}
		return false;
	}

	@Reference
	private OMSBCommonApi omsbCommonApi;
	@Reference
	private OMSBHttpConnector httpConnector;
	@Reference(unbind = "-")
	private MembershipUtil membershipUtil;

}
