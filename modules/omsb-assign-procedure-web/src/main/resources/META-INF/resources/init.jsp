<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<liferay-theme:defineObjects />

<portlet:defineObjects />

<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>

<%@page import="gov.omsb.tms.model.ProcedureGroupProceduresCPTCodeRel"%>
<%@page import="gov.omsb.tms.model.ProcedureGroupMaster"%>
<%@page import="gov.omsb.tms.model.ProcedureMaster"%>
<%@page import="gov.omsb.tms.service.ProcedureGroupProceduresCPTCodeRelLocalServiceUtil"%>
<%@page import="gov.omsb.tms.service.ProcedureGroupMasterLocalServiceUtil"%>
<%@page import="gov.omsb.tms.service.ProcedureMasterLocalServiceUtil"%>

<%@page import="gov.omsb.assign.procedure.web.constants.OmsbAssignProcedureConstants"%>