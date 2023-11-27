<%@ include file="./init.jsp"%>
<portlet:actionURL name="<%=MVCCommandNames.WORKFLOW_UPDATE %>" var="quivalencyWorkflowURL" />
<portlet:renderURL var="equivalencyCertificateURL">
<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.EQUIVALENCY_CERTIFICATE%>" />
</portlet:renderURL>

<%-- <a href="<%=equivalencyCertificateURL%>"><button type="button">certificate</button></a> --%>

<portlet:resourceURL id="<%=MVCCommandNames.EQUIVALENCY_PERSON_SEARCH%>"
	var="personSearch">
</portlet:resourceURL>

<%@ include file="./equivalency-list.jspf"%>

