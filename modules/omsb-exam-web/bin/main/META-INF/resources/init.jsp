<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/clay" prefix="clay"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page import="gov.omsb.exam.web.portlet.constants.MVCCommands"%>
<%@page import="gov.omsb.exam.web.portlet.constants.OMSBExamWebPortletKeys"%>
<%@page import="gov.omsb.common.constants.DataflowConstants"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="gov.omsb.common.constants.CommonConstants"%>
<liferay-theme:defineObjects />

<portlet:defineObjects />
<liferay-ui:success key="setExamFormSuccess" message="Exam Created successfuly."/>
<liferay-ui:error key="setExamFormError" message="Exam Created unsuccessfuly."/>

<liferay-ui:success key="appealRequestSuccess" message="Congratulation ! your request has been completed successfuly."/>
<liferay-ui:error key="appealRequestFailure" message="Your request has been not been completed due to failure"/>
<script type="text/javascript">
	var namespace = "<portlet:namespace/>";
	var imagePath = '<%=themeDisplay.getPathThemeImages()%>';
	console.log("namespace  in init "+ namespace);
	console.log("imagePath  in init "+ imagePath);
</script>

<style>
.dataTables_filter, .dataTables_info, .dataTables_length {
    display: none;
}
</style>