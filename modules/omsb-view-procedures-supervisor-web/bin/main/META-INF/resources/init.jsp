<%@page import="gov.omsb.tms.common.constants.OmsbTmsCommonConstants"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib prefix="liferay-frontend" uri="http://liferay.com/tld/frontend" %>

<%@page import="gov.omsb.view.procedures.supervisor.web.constants.OmsbViewProceduresSupervisorWebPortletKeys"%>
<%@page import="gov.omsb.tms.custom.dto.TraineeLoggedProcedureDetailsDTO"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="gov.omsb.tms.common.constants.OmsbTmsCommonConstants"%>

<liferay-frontend:defineObjects />

<liferay-theme:defineObjects />

<portlet:defineObjects />

<portlet:renderURL var="allLoggedProcedures">
    <portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>

<c:set var = "PASS_LOG_PROCEDURE" value = "PASS_LOG_PROCEDURE"/>
<c:set var = "NOT_PASS_LOG_PROCEDURE" value = "NOT_PASS_LOG_PROCEDURE"/>
<c:set var = "REFUSE_LOG_PROCEDURE" value = "REFUSE_LOG_PROCEDURE"/>
