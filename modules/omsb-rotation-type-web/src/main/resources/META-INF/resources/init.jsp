<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib prefix="liferay-frontend" uri="http://liferay.com/tld/frontend" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<liferay-frontend:defineObjects />

<%@page import="gov.omsb.rotation.type.web.constants.OmsbRotationTypeWebPortletKeys"%>
<%@page import="gov.omsb.tms.model.RotationTypeMaster"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>