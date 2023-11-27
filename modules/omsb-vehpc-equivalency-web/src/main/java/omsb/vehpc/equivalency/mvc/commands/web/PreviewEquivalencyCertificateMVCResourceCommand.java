package omsb.vehpc.equivalency.mvc.commands.web;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.common.api.OMSBCommonApi;
import gov.omsb.http.connector.api.OMSBHttpConnector;
import omsb.vehpc.equivalency.util.CertificateUtil;
import omsb.vehpc.equivalency.web.constants.ArabicConstant;
import omsb.vehpc.equivalency.web.constants.MVCCommandNames;
import omsb.vehpc.equivalency.web.constants.OmsbVehpcEquivalencyWebPortletKeys;

/**
 * @author Tayyaba MM
 */
@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbVehpcEquivalencyWebPortletKeys.OMSBVEHPCEQUIVALENCYWEB,
	        "mvc.command.name="+MVCCommandNames.PREVIEW_CERTIFICATE_RESOURCE
	    }, 
	    service = MVCResourceCommand.class
)

public class PreviewEquivalencyCertificateMVCResourceCommand extends BaseMVCResourceCommand{
	
	@Override
	protected void doServeResource(ResourceRequest request, ResourceResponse resourceResponse)
			throws Exception {
		logger.info(" PreviewEquivalencyCertificateMVCResourceCommand doServeResource::: Invoked >>> ");
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long equivalencyRequestId = ParamUtil.getLong(request, "equivalencyRequestId"); 
		String nameTitle = ParamUtil.getString(request, "en_name");
		String nameTitleAr = ParamUtil.getString(request, "ar_name");
		String name = ParamUtil.getString(request, "name");
		String passportTitle = ParamUtil.getString(request, "en_passport");
		String passportTitleAr = ParamUtil.getString(request, "ar_passport");
		String passport = ParamUtil.getString(request, "passport");
		String dobTitle = ParamUtil.getString(request, "en_dob");
		String dobTitleAr = ParamUtil.getString(request, "ar_dob");
		String dob = ParamUtil.getString(request, "dob");
		String certificateNameTitle = ParamUtil.getString(request, "en_certificateName");
		String certificateNameTitleAr = ParamUtil.getString(request, "ar_certificateName");
		String certificateName = ParamUtil.getString(request, "certificateName");
		String issueCountryTitle = ParamUtil.getString(request, "en_issueCountry");
		String issueCountryTitleAr = ParamUtil.getString(request, "ar_issueCountry");
		String issueCountry = ParamUtil.getString(request, "issueCountry");
		String graduateYearTitle = ParamUtil.getString(request, "en_graduateYear");
		String graduateYearTitleAr = ParamUtil.getString(request, "ar_graduateYear");
		String graduateYear = ParamUtil.getString(request, "graduateYear");
		String decisionTitle = ParamUtil.getString(request, "en_decision");
		String decisionTitleAr = ParamUtil.getString(request, "ar_decision");
		String decision = ParamUtil.getString(request, "decision");
		String remarksTitle = ParamUtil.getString(request, "en_remarks");
		String remarksTitleAr = ParamUtil.getString(request, "ar_remarks");
		String remarks = ParamUtil.getString(request, "remarks");
		
		logger.info("Name title is ?" + nameTitle);
		logger.info("Name title ar is ?" + nameTitleAr);
		String data = certificateUtil.getSingleCertificateValueByJournalArticle(themeDisplay.getScopeGroupId());
		String[] oldSubs = {"$[name-title]","$[passport-title]", "$[dob-title]", "$[certificateName-title]","$[issueCountry-title]","$[graduationYear-title]","$[eqLevel-title]","$[remarks-title]"};
		String[] newArSubs = {nameTitleAr, passportTitleAr,dobTitleAr, certificateNameTitleAr, issueCountryTitleAr, graduateYearTitleAr, decisionTitleAr, remarksTitleAr};
		String[] newEnSubs = {nameTitle, passportTitle, passportTitle, certificateNameTitle, issueCountryTitle, graduateYearTitle, decisionTitle, remarksTitle};
		
		data = StringUtil.replace(data, oldSubs, newArSubs);
		String newData = certificateUtil.getValues(equivalencyRequestId, themeDisplay, data);
		resourceResponse.getWriter().write(newData);
		StringBuilder buf = new StringBuilder();
		for (int i = 0; i < newData.length(); i++) {
		    char ch = newData.charAt(i);
		    if (ch >= 32 && ch < 127)
		        buf.append(ch);
		    else
		        buf.append(String.format("\\u%04x", (int) ch));
		}
		String result = buf.toString();
		String customHtml = "<html><style><link rel=\"preconnect\" href=\"https://fonts.googleapis.com\"><link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin><link href=\"https://fonts.googleapis.com/css2?family=Noto+Naskh+Arabic&display=swap\" rel=\"stylesheet\"></style><table><tr><td>Lawrence of Arabia</td><td dir=\"rtl\" style=\"font-family: Noto Naskh Arabic\">"+ ArabicConstant.CERTIFICATE_NAME_TITLE+"</td></tr></table></html>";
		certificateUtil.createCertificate(request, equivalencyRequestId, newData);
		logger.info(" PreviewEquivalencyCertificateMVCResourceCommand doServeResource::: Invoked Successful >>> ");
	}
	
	
	@Reference(unbind = "-")
	private OMSBHttpConnector oMSBHttpConnector;
	@Reference(unbind = "-")
	private OMSBCommonApi omsbCommonApi;
	@Reference(unbind = "-")
	private CertificateUtil certificateUtil;
	private static final Log logger = LogFactoryUtil.getLog(EquivalencyPersonSearchMVCResourceCommand.class);
}
