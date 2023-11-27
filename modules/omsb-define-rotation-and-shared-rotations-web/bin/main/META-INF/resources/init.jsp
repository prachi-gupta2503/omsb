<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib prefix="liferay-frontend" uri="http://liferay.com/tld/frontend" %>

<%@page import="gov.omsb.define.rotation.and.shared.rotations.web.constants.OmsbDefineRotationAndSharedRotationsWebPortletKeys"%>


<liferay-frontend:defineObjects />

<liferay-theme:defineObjects />

<portlet:defineObjects />

<portlet:renderURL var="home">
    <portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>