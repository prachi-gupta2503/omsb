<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="../../init.jsp"%>
<%
long roleId = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), "OCT Applicant").getRoleId();

boolean isValidRole=UserLocalServiceUtil.hasRoleUser(roleId, themeDisplay.getUserId());
%>

<% if(isValidRole){ %>
	<%@ include file="../calendar/applicant-calendar.jsp"%>
<%}else{ %>
	<%@ include file="../calendar/calendar.jsp"%>
<%} %>
<%-- <liferay-portlet:runtime portletName="com_liferay_calendar_web_portlet_CalendarPortlet">
</liferay-portlet:runtime> --%>

<%-- <%

String examTitleName=ParamUtil.getString(request, "examTitleName");

%>
<script>

$(document).ready(()=>{
	
	console.log("<%=examTitleName%>");
	
	var examDate="${examDate}";
	var oldOcExamScheduleId="${oldOcExamScheduleId}";
	var examTitle="<%=examTitleName%>";
	
	console.log("oldOcExamScheduleId"+ oldOcExamScheduleId);
	
	$("#examtitleText").val(examTitle);
	$("#oldOcExamScheduleId").val(oldOcExamScheduleId);
	$("#calendarExamDate").val(examDate);
});

</script> --%>