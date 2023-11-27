<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="gov.omsb.notify.sau.web.constants.OmsbNotifySauWebPortletKeys"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<portlet:actionURL name="<%= OmsbNotifySauWebPortletKeys.NOTIFY_SAU_USER_ACTION %>" var="notifySauUserAction" >
	<portlet:param name="redirect" value="${currentURL}"/>
</portlet:actionURL>
