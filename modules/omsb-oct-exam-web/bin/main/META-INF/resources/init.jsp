<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/clay" prefix="clay"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%><%@
taglib
	uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%><%@
taglib
	uri="http://liferay.com/tld/theme" prefix="liferay-theme"%><%@
taglib
	uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>

<%@page import="gov.omsb.oct.exam.web.constants.MVCCommandNames"%>
<%@page import="gov.omsb.common.constants.DataflowConstants"%>
<%@page import="gov.omsb.common.constants.RoleNameConstants"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="gov.omsb.common.constants.CommonConstants"%>
<%@page
	import="gov.omsb.oct.exam.web.constants.OmsbOctExamWebPortletKeys"%>

<%@page import="java.util.List" %>
<%@page import="java.util.stream.Collectors" %>
<%@page import="com.liferay.portal.kernel.model.Role" %>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay" %>


<liferay-theme:defineObjects />

<portlet:defineObjects />

<script type="text/javascript">
	var namespace = "<portlet:namespace/>";
	var imagePath = '<%=themeDisplay.getPathThemeImages()%>';
	console.log("namespace  in init " + namespace);
	console.log("imagePath  in init " + imagePath);
</script>
<style>
.dataTables_filter, .dataTables_info, .dataTables_length {
	display: none;
}
</style>
<liferay-ui:success key="setExamFormSuccess"
	message="Exam Created successfully." />
<liferay-ui:error key="setExamFormError"
	message="Exam Created unsuccessfully." />
	
<liferay-ui:success key="setExamScheduleFormSuccess"
	message="Exam Scheduled successfully." />
<liferay-ui:error key="setExamScheduleFormError"
	message="Exam Scheduled unsuccessfully." />
	
<liferay-ui:success key="setExamRegistrationFormSuccess"
	message="Exam Registration Created successfully." />
<liferay-ui:error key="setExamRegistrationFormError"
	message="Exam Registration Created unsuccessfully." />
	
<liferay-ui:success key="setExamResultFormSuccess"
	message="Exam Result Created successfully." />
<liferay-ui:error key="setExamResultFormError"
	message="Exam Result Created unsuccessfully." />