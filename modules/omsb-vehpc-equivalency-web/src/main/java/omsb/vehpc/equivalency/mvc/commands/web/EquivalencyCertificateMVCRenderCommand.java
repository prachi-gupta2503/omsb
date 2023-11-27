package omsb.vehpc.equivalency.mvc.commands.web;

import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import omsb.vehpc.equivalency.web.constants.EquivalencyJSPPathConstants;
import omsb.vehpc.equivalency.web.constants.MVCCommandNames;
import omsb.vehpc.equivalency.web.constants.OmsbVehpcEquivalencyWebPortletKeys;
/**
 * @author Mahaboob
 */
@Component(
		immediate=true,
	    property = { 
	    	"javax.portlet.name=" + OmsbVehpcEquivalencyWebPortletKeys.OMSBVEHPCEQUIVALENCYWEB,
	        "mvc.command.name=" +MVCCommandNames.EQUIVALENCY_CERTIFICATE
	    }, 
	    service = MVCRenderCommand.class
)
public class EquivalencyCertificateMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

	        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
	        String friendlyURL = "equivalency-certificate";
	        String articalId = "";
	        String ddmTemplateKey = "";
	        JournalArticle article = null;
	        try {
	            article = JournalArticleLocalServiceUtil.getArticleByUrlTitle(themeDisplay.getScopeGroupId(), friendlyURL);
	            articalId = article.getArticleId();
	            ddmTemplateKey = article.getDDMTemplateKey();
	        } catch (PortalException e) {
	            e.printStackTrace();
	        }

	        renderRequest.setAttribute("ddmTemplateKey", ddmTemplateKey);
	        renderRequest.setAttribute("articalId", articalId);
	    
		return EquivalencyJSPPathConstants.EQUIVALENCY_CERTIFICATE_JSP;
	}

}
