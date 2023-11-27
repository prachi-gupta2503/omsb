package gov.omsb.leave.status.web.portlet;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import gov.omsb.leave.status.web.constants.OmsbLeaveStatusConstants;
import gov.omsb.leave.status.web.constants.OmsbLeaveStatusWebPortletKeys;
import gov.omsb.tms.model.LeaveMaster;
import gov.omsb.tms.service.LeaveMasterLocalService;

/**
 * @author taher.mohammed
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=OMSB",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=OmsbLeaveStatusWeb", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=" + OmsbLeaveStatusConstants.VIEW_LEAVE_JSP,
		"javax.portlet.name=" + OmsbLeaveStatusWebPortletKeys.OMSBLEAVESTATUSWEB,
		"javax.portlet.resource-bundle=content.Language", "javax.portlet.security-role-ref=power-user,user",
		"javax.portlet.version=3.0" }, service = Portlet.class)
public class OmsbLeaveStatusWebPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		SimpleDateFormat sdf = new SimpleDateFormat(OmsbLeaveStatusConstants.VIEW_DATE_FORMAT);

		DynamicQuery dynamicQuery = leaveMasterLocalService.dynamicQuery();

		dynamicQuery.add(RestrictionsFactoryUtil.eq(OmsbLeaveStatusConstants.CREATED_BY, themeDisplay.getUserId()));
		dynamicQuery.addOrder(OrderFactoryUtil.desc("createDate"));

		List<LeaveMaster> leaveMasters = leaveMasterLocalService.dynamicQuery(dynamicQuery);

		renderRequest.setAttribute(OmsbLeaveStatusConstants.LEAVE_MASTERS_LIST, leaveMasters);
		renderRequest.setAttribute(OmsbLeaveStatusConstants.SDF, sdf);

		super.render(renderRequest, renderResponse);
	}

	@Reference
	LeaveMasterLocalService leaveMasterLocalService;

	private Log log = LogFactoryUtil.getLog(OmsbLeaveStatusWebPortlet.class.getName());

}