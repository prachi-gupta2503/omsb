package gov.omsb.form.builder.friendlyURLMapper;

import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;

import org.osgi.service.component.annotations.Component;

import gov.omsb.form.builder.constants.FormBuilderConstants;
import gov.omsb.form.builder.constants.FormBuilderWebPortletKeys;

@Component(
	    property = {
	        "com.liferay.portlet.friendly-url-routes=META-INF/friendly-url-routes/routes.xml",
	        "javax.portlet.name=" + FormBuilderWebPortletKeys.OMSB_FORM_BUILDER
	    },
	    service = FriendlyURLMapper.class
	)

public class FormFriendlyURLMapper extends DefaultFriendlyURLMapper {
	
    @Override
    public String getMapping() {
        return _MAPPING;
    }
    private static final String _MAPPING = FormBuilderConstants.FORM_DEFINITION_ID;
}