<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%@page import="gov.omsb.log.procedures.web.constants.OmsbLogProceduresConstants"%>
<%@page import="gov.omsb.tms.service.RoleTypeMasterLocalServiceUtil"%>
<%@page import="gov.omsb.tms.service.ProcedureMasterLocalServiceUtil"%>
<%@page import="gov.omsb.tms.model.TraineeLoggedProcedureDetails"%>
<%@page import="gov.omsb.view.procedures.supervisor.web.constants.OmsbViewProceduresSupervisorWebPortletKeys"%>

<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>

<%@page import="gov.omsb.tms.service.ProcedureGroupMasterLocalServiceUtil"%>
<%@page import="gov.omsb.tms.model.ProcedureGroupMaster"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="gov.omsb.tms.model.ProcedureMaster"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>

<%@page import="java.util.Locale"%>

<script src="https://cdn.ckeditor.com/4.10.0/standard/ckeditor.js"></script>

<portlet:actionURL name="<%= OmsbLogProceduresConstants.PASS_PRODCEDURE %>" var="passProcedure">
	<portlet:param name="redirect" value="<%=PortalUtil.getCurrentURL(request)%>"/>
</portlet:actionURL>

<portlet:actionURL name="<%= OmsbLogProceduresConstants.REFUSE_PRODCEDURE %>" var="refuseProcedure">
	<portlet:param name="redirect" value="<%=PortalUtil.getCurrentURL(request)%>"/>
</portlet:actionURL>

<portlet:actionURL name="<%= OmsbLogProceduresConstants.NOT_PASS_PRODCEDURE %>" var="notPassProcedure">
	<portlet:param name="redirect" value="<%=PortalUtil.getCurrentURL(request)%>"/>
</portlet:actionURL>

<portlet:renderURL var="filterLogProcedures">
    <portlet:param name="mvcRenderCommandName" value="<%= OmsbLogProceduresConstants.FILTER_LOGGED_PROCEDURE_RENDER_COMMAND %>"/>
</portlet:renderURL>

<portlet:actionURL name="<%= OmsbLogProceduresConstants.DELETE_LOG_PROCEDURE_ACTION_COMMAND %>" var="deleteProcedureLogURL"/>

<c:set var = "ADD_LOG_PROCEDURE" value = "ADD_LOG_PROCEDURE"/>
<c:set var = "EDIT_LOG_PROCEDURE" value = "EDIT_LOG_PROCEDURE"/>
<c:set var = "DELETE_LOG_PROCEDURE" value = "DELETE_LOG_PROCEDURE"/>
<c:set var = "VIEW_LOG_PROCEDURE" value = "VIEW_LOG_PROCEDURE"/>
