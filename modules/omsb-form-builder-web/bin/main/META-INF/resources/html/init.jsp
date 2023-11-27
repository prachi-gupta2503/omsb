<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="gov.omsb.form.builder.constants.MVCCommandNames"%>
<%@ page import="gov.omsb.form.builder.constants.FormBuilderConstants"%>

<%@page import="gov.omsb.form.builder.model.FormDefinition"%>
<%@page import="gov.omsb.form.builder.service.FormDefinitionLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.Constants" %>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%
	String formName = StringPool.BLANK, formVersion = StringPool.BLANK, formDefinitionId = StringPool.BLANK, mode = StringPool.BLANK;

	if (Validator.isNotNull((String)portletPreferences.getValue(FormBuilderConstants.FORM_MODE, StringPool.BLANK))) {
		mode = (String)portletPreferences.getValue(FormBuilderConstants.FORM_MODE, StringPool.BLANK);
	}

	if (Validator.isNotNull((String)portletPreferences.getValue(FormBuilderConstants.FORM_NAME, StringPool.BLANK))) {
		formName = (String)portletPreferences.getValue(FormBuilderConstants.FORM_NAME, StringPool.BLANK);
	}
	
	if (Validator.isNotNull((String)portletPreferences.getValue(FormBuilderConstants.FORM_VERSION, StringPool.BLANK))) {
		formVersion = (String)portletPreferences.getValue(FormBuilderConstants.FORM_VERSION, StringPool.BLANK);
	}
	
	if (Validator.isNotNull((String)portletPreferences.getValue(FormBuilderConstants.FORM_DEFINITION_ID, StringPool.BLANK))) {
		formDefinitionId = (String)portletPreferences.getValue(FormBuilderConstants.FORM_DEFINITION_ID, StringPool.BLANK);
	}
%>