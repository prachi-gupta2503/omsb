<%@page import="gov.omsb.training.sites.web.constants.OmsbTrainingSitesWebPortletKeys"%>
<%@page import="gov.omsb.tms.common.constants.OmsbTmsCommonConstants"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="liferay-frontend" uri="http://liferay.com/tld/frontend" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<liferay-frontend:defineObjects />

<portlet:defineObjects />

<c:set var = "ADMIN_ADD_TRAINING_SITE" value = "ADMIN_ADD_TRAINING_SITE"/>
<c:set var = "ADMIN_UPDATE_TRAINING_SITE" value = "ADMIN_UPDATE_TRAINING_SITE"/>
<c:set var = "NON_ADMIN_TRAINING_SITE_VIEW" value = "NON_ADMIN_TRAINING_SITE_VIEW"/>
<c:set var = "ADMIN_TRAINING_SITE_VIEW" value = "ADMIN_TRAINING_SITE_VIEW"/>
<c:set var = "ADMIN_DELETE_TRAINING_SITE" value = "ADMIN_DELETE_TRAINING_SITE"/>

<portlet:renderURL var="allTrainingSites">
    <portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>

<portlet:resourceURL var="getSiteUserDetailMVCResourceURL" id="<%= OmsbTrainingSitesWebPortletKeys.TRAINING_SITES_PROGRAM_USER_DETAIL_MVC_RESOURCE_COMMAND %>" />

<portlet:resourceURL var="notifySiteRotationMVCResourceURL" id="<%= OmsbTrainingSitesWebPortletKeys.TRAINING_SITE_NOTIFY_SITES_MVC_RESOURCE_COMMAND %>" />