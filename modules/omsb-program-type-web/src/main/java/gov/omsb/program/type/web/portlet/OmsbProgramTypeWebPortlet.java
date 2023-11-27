package gov.omsb.program.type.web.portlet;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import gov.omsb.program.type.web.constants.OmsbProgramTypeConstants;
import gov.omsb.program.type.web.constants.OmsbProgramTypeWebPortletKeys;
import gov.omsb.tms.model.ProgramTypeMaster;
import gov.omsb.tms.service.ProgramTypeMasterLocalServiceUtil;

/**
 * @author Aditya Meghnathi
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=OMSB",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=OmsbProgramTypeWeb", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=" + OmsbProgramTypeConstants.ADD_PROGRAM_TYPE_JSP_NAME,
		"javax.portlet.name=" + OmsbProgramTypeWebPortletKeys.OMSBPROGRAMTYPEWEB,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class OmsbProgramTypeWebPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		_logger.info("render Invoked ::: ");
		SimpleDateFormat sdf = new SimpleDateFormat(OmsbProgramTypeWebPortletKeys.DATE_FORMAT_DD_MM_YYYY);
		List<ProgramTypeMaster> programTypeList = ProgramTypeMasterLocalServiceUtil
				.getProgramTypeMasters(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		renderRequest.setAttribute(OmsbProgramTypeConstants.PROGRAM_TYPE_LIST, programTypeList);
		renderRequest.setAttribute(OmsbProgramTypeWebPortletKeys.DATE_FORMAT_VARIABLE, sdf);
		super.render(renderRequest, renderResponse);
		_logger.info("render Exit ::: ");
	}

	private static final Log _logger = LogFactoryUtil.getLog(OmsbProgramTypeWebPortlet.class.getName());
}