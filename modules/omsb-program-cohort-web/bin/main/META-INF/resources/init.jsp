<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib prefix="liferay-frontend" uri="http://liferay.com/tld/frontend" %>


<liferay-frontend:defineObjects />

<liferay-theme:defineObjects />

<portlet:defineObjects />

<c:set var = "ADMIN_ADD_COHORT" value = "ADMIN_ADD_COHORT"/>
<c:set var = "ADMIN_EDIT_COHORT" value = "ADMIN_EDIT_COHORT"/>
<c:set var = "ADMIN_DELETE_COHORT" value = "ADMIN_DELETE_COHORT"/>
<c:set var = "ADMIN_SCHEDULE_MASTER_ROTATION" value = "ADMIN_SCHEDULE_MASTER_ROTATION"/>

<portlet:renderURL var="home">
    <portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>