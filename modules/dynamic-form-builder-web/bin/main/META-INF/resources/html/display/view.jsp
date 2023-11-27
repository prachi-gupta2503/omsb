<%@page import="org.omsb.dynamic.form.builder.constants.MVCCommandNames"%>
<%@ include file="../init.jsp" %>

<portlet:renderURL var="addConfigurationURL">
		<portlet:param name="mvcRenderCommandName" value="<%= MVCCommandNames.FORM_CONFIGURATION_ADD %>"/>
</portlet:renderURL>

<a href="${addConfigurationURL}" class="btn btn-primary">Add/Edit Configuration</a>

<portlet:renderURL var="ddmFormJsonRenderURL">
		<portlet:param name="mvcRenderCommandName" value="<%= MVCCommandNames.FORM_RENDERER %>"/>
</portlet:renderURL>

<a href="${ddmFormJsonRenderURL}" class="btn btn-primary">View Form</a>