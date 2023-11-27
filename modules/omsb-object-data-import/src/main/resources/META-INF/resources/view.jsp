<%@ include file="init.jsp" %>

<p>
	<b><liferay-ui:message key="omsbobjectdataimport.caption"/></b>
</p>
<portlet:actionURL var="importDataURL" name="importData"></portlet:actionURL>
<aui:form method="post" name="import_data_fm" action="<%=importDataURL %>">
	<aui:input name="erc" label="External Reference Code" type="text"></aui:input>
	<aui:input name="inputFile" label="Upload File" type="file"></aui:input>
	<aui:button value="Submit" type="submit"></aui:button>
</aui:form>