<%@page import="gov.omsb.rotations.web.constants.OmsbRotationsWebPortletKeys"%>
<%@page import="gov.omsb.tms.common.constants.OmsbTmsCommonConstants"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="liferay-frontend" uri="http://liferay.com/tld/frontend" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="java.util.Locale"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<liferay-theme:defineObjects />

<liferay-frontend:defineObjects />

<portlet:defineObjects />

<c:set var = "ADMIN_ADD_ROTATION" value = "ADMIN_ADD_ROTATION"/>
<c:set var = "ADMIN_UPDATE_ROTATION" value = "ADMIN_UPDATE_ROTATION"/>
<c:set var = "ADMIN_ROTATION_VIEW" value = "ADMIN_ROTATION_VIEW"/>
<c:set var = "NON_ADMIN_ROTATION_VIEW" value = "NON_ADMIN_ROTATION_VIEW"/>
<c:set var = "NON_ADMIN_ROTATION_OBJECTIVE" value = "NON_ADMIN_ROTATION_OBJECTIVE"/>
<c:set var = "ADMIN_ROTATION_OBJECTIVE" value = "ADMIN_ROTATION_OBJECTIVE"/>
<c:set var = "ADMIN_DELETE_ROTATION" value = "ADMIN_DELETE_ROTATION"/>

<portlet:renderURL var="allRotations">
    <portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/custom.js"></script>