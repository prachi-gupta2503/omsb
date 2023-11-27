<%@ include file="./init.jsp" %>

<liferay-journal:journal-article articleId="${articalId}" ddmTemplateKey="${ddmTemplateKey}"
    groupId="<%=themeDisplay.getScopeGroupId() %>"></liferay-journal:journal-article>
    
<c:out value = "${articalId}"/>
<c:out value = "${ddmTemplateKey}"/>