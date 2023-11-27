<%@page import="gov.omsb.common.constants.CommonConstants"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.service.LayoutLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Layout"%>
<%@page import="gov.omsb.tms.common.constants.OmsbTmsCommonConstants"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib prefix="liferay-frontend" uri="http://liferay.com/tld/frontend" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@page import="gov.omsb.programs.web.constants.OmsbProgramConstants"%>
<%@page import="gov.omsb.tms.common.constants.OmsbTmsCommonConstants"%>
<%@page import="gov.omsb.tms.model.ProgramMaster"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>

<script src="https://cdn.ckeditor.com/4.10.0/standard/ckeditor.js"></script>


<liferay-frontend:defineObjects />

<liferay-theme:defineObjects />

<portlet:defineObjects />

<c:set var = "ADMIN_ADD_PROGRAM" value = "ADMIN_ADD_PROGRAM"/>
<c:set var = "ADMIN_ADD_COHORT" value = "ADMIN_ADD_COHORT"/>
<c:set var = "ADMIN_VIEW_COHORT" value = "ADMIN_VIEW_COHORT"/>
<c:set var = "ADMIN_PROGRAM_VIEW" value = "ADMIN_PROGRAM_VIEW"/>
<c:set var = "NON_ADMIN_PROGRAM_VIEW" value = "NON_ADMIN_PROGRAM_VIEW"/>
<c:set var = "ADMIN_PROGRAM_ACTIVATION" value = "ADMIN_PROGRAM_ACTIVATION"/>
<c:set var = "ADMIN_PROGRAM_OBJECTIVE" value = "ADMIN_PROGRAM_OBJECTIVE"/>
<c:set var = "NON_ADMIN_PROGRAM_OBJECTIVE" value = "NON_ADMIN_PROGRAM_OBJECTIVE"/>
<c:set var = "ADMIN_MANAGE_TRAINEE_SITE" value = "ADMIN_MANAGE_TRAINEE_SITE"/>
<c:set var = "ADMIN_CONFIGURE_ROTATION" value = "ADMIN_CONFIGURE_ROTATION"/>
<c:set var = "ADMIN_ADD_ROTATION" value = "ADMIN_ADD_ROTATION"/>
<c:set var = "ADMIN_ASSIGN_ROTATION" value = "ADMIN_ASSIGN_ROTATION"/>
<c:set var = "NON_ADMIN_ELECTIVE_ROTATION" value = "NON_ADMIN_ELECTIVE_ROTATION"/>
<c:set var = "NON_ADMIN_CONFIGURE_ELECTIVE_ROTATION" value = "NON_ADMIN_CONFIGURE_ELECTIVE_ROTATION"/>
<c:set var = "NON_ADMIN_ELECTIVE_ROTATION_DELETE" value = "NON_ADMIN_ELECTIVE_ROTATION_DELETE"/>
<c:set var = "ADMIN_CONFIGURE_SITE_CAPACITY" value = "ADMIN_CONFIGURE_SITE_CAPACITY"/>
<c:set var = "NON_ADMIN_VIEW_SITE_CAPACITY" value = "NON_ADMIN_VIEW_SITE_CAPACITY"/>
<c:set var = "ADMIN_UPDATE_CONFIGURE_SITE_CAPACITY" value = "ADMIN_UPDATE_CONFIGURE_SITE_CAPACITY"/>
<c:set var = "ADMIN_DELETE_CONFIGURE_SITE_CAPACITY" value = "ADMIN_DELETE_CONFIGURE_SITE_CAPACITY"/>
<c:set var = "ADMIN_EDIT_ASSIGN_ROTATION" value = "ADMIN_EDIT_ASSIGN_ROTATION"/>
<c:set var = "ADMIN_DELETE_ASSIGN_ROTATION" value = "ADMIN_DELETE_ASSIGN_ROTATION"/>
<c:set var = "ADMIN_SELECT_COHORT_FOR_OBJECTIVE" value = "ADMIN_SELECT_COHORT_FOR_OBJECTIVE"/>
<c:set var = "NON_ADMIN_ELECTIVE_ROTATION_EDIT" value = "NON_ADMIN_ELECTIVE_ROTATION_EDIT"/>
<c:set var = "ADMIN_PROGRAM_LIST_VIEW" value = "ADMIN_PROGRAM_LIST_VIEW"/>
<c:set var = "NON_ADMIN_PROGRAM_LIST_VIEW" value = "NON_ADMIN_PROGRAM_LIST_VIEW"/>
<portlet:renderURL var="allPrograms">
    <portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>