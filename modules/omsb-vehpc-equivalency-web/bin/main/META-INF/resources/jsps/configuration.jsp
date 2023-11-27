<%@include file="./init.jsp" %>


<%
AppealConfiguration messageDisplayConfiguration = (AppealConfiguration) renderRequest
			.getAttribute(AppealConfiguration.class.getName());
	String tagName = StringPool.BLANK;
	String showEquivalencyCertificate = StringPool.BLANK;
	String showEquivalencyLevel = StringPool.BLANK;
	
	if (messageDisplayConfiguration != null) {
		tagName = portletPreferences.getValue("appealValidity",
				String.valueOf(messageDisplayConfiguration.appealValidity()));
		
		showEquivalencyCertificate = portletPreferences.getValue("showEquivalencyCertificate",
				String.valueOf(messageDisplayConfiguration.appealValidity()));
		
		showEquivalencyLevel = portletPreferences.getValue("showEquivalencyLevel",
				String.valueOf(messageDisplayConfiguration.appealValidity()));
	}
	int appealValidityValue = Integer.parseInt(tagName);
	boolean showEquivalencyCertificateValue = Boolean.parseBoolean(showEquivalencyCertificate); 
	boolean showEquivalencyLevelValue = Boolean.parseBoolean(showEquivalencyLevel); 
%>

<liferay-portlet:actionURL portletConfiguration="<%= true %>" var="configurationActionURL" />

<aui:form action="<%= configurationActionURL %>" method="post" name="fm">


	<aui:fieldset>
		<aui:input name="appealValidity" type="number" min="1" value="<%=appealValidityValue %>" />
		<aui:input name="showEquivalencyCertificate" type="checkbox" checked="<%=showEquivalencyCertificateValue %>" />
		<aui:input name="showEquivalencyLevel" type="checkbox" checked="<%=showEquivalencyLevelValue %>" />
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>
