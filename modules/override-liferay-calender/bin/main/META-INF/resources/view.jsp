<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil"%>
<%@ include file="/init.jsp" %>

<style>

.exam_search{
    
    margin-top: 25px;;
}


</style>

<%
String tabs1 = ParamUtil.getString(request, "tabs1", "calendar");
		 

%>

<%

long roleId = RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), "OCT Applicant").getRoleId();

boolean isValidRole=UserLocalServiceUtil.hasRoleUser(roleId, themeDisplay.getUserId());

if(isValidRole){
%>

<div class="row">
	
	<div class="col-sm-4">
		<div class="examTitleList">
			<input type="hidden" id="examtitleText" >
			<input type="hidden" id="examDate" >
			<input type="hidden" id="oldOcExamScheduleId" name="<portlet:namespace/>oldOcExamScheduleId" >
			<input type="hidden" id="registrationId" >
			
		</div>
	</div>
	
</div>
<%} %>
<div id="<portlet:namespace />alert"></div>

<c:if test="<%= themeDisplay.isSignedIn() && !displaySchedulerOnly %>">
	<clay:navigation-bar
		navigationItems="<%= calendarDisplayContext.getNavigationItems() %>"
	/>
</c:if>

<c:choose>
	<c:when test='<%= tabs1.equals("calendar") %>'>
		<liferay-util:include page="/view_calendar.jsp" servletContext="<%= application %>" />
	</c:when>
	<c:when test='<%= tabs1.equals("resources") %>'>
		<liferay-util:include page="/view_calendar_resources.jsp" servletContext="<%= application %>" />
	</c:when>
</c:choose>


<script>
getOCTExamList();
function getOCTExamList() {
	
	var portalURL="<%=themeDisplay.getPortalURL()%>";
	var groupId="<%=themeDisplay.getScopeGroupId()%>";
	var companyId="<%=themeDisplay.getCompanyId()%>";
	var locale="<%=themeDisplay.getLocale()%>";
	
    
	var url="${themeDisplay.getPortalURL()}/o/oct-calendar-events-api/get-exam-list";
	console.log(url);
	
	$.ajax({
		<%-- url : '<%=calendarResUrl%>', --%>
		url: url,
		data: {
			
			"portalURL":portalURL,
			"groupId":groupId,
			"companyId":companyId,
			"locale":locale
			
		},
		type : 'GET',
		success : function(data) {
			var dataString=JSON.stringify(data);
			var dataArray=JSON.parse(dataString);
			  var sectionData = "<option value=''><liferay-ui:message key='select'/></option>";
			  for (var i = 0; i < dataArray.length; i++) {
	                sectionData += "<option value='" + dataArray[i].ocExamTitleName + "'>" + dataArray[i].ocExamTitleName + "</option>";
	            }
			
			  $("#examtitleList").html(sectionData); 
		}
	});
}

setInterval(function() {
	
	 $(".scheduler-event-content").each(function() {
		
		var spaceIndex=$(this).text().indexOf(" ");
		if(spaceIndex != undefined && spaceIndex != -1 ){
			
	    var cls=$(this).text().replaceAll(' ','_');
		    if(!$(this).hasClass(cls)){
		       $(this).addClass(cls);
		    }
		}

	});
	refineText();
	getExamEvent();
	
	
}, 100); 

function getExamEvent(){
	var oldOcExamScheduleId=$("#oldOcExamScheduleId").val();
	console.log("oldOcExamScheduleId-->>"+oldOcExamScheduleId)
	$(".scheduler-event-content").each(function() {
		var clsNm=$("#examtitleText").val();
		var cls="";
	
	if(clsNm != undefined && clsNm != ""){
		var indexOfUnderscore=clsNm.lastIndexOf('_');
		
		if(indexOfUnderscore != undefined && indexOfUnderscore != -1){
			cls=cls.substring(0,indexOfUnderscore);
		}else{
			cls = clsNm;
		}	
			if(cls != undefined && cls != "" ){
				var spaceIndex=cls.indexOf(" ");

				if(spaceIndex != undefined && spaceIndex != -1 ){
					cls=cls.replaceAll(' ','_');
				}
				var data_enddate=$(this).parent().attr("data-enddate");
				
				console.log(data_enddate);
				var g2 = new Date(data_enddate);
				var examDate = $("#examDate").val();
				var g1 =new Date(examDate);
				if(!$(this).hasClass(cls) || g1.getTime() > g2.getTime()){
						$(this).parent().hide();
						$(this).hide();	  
				}else{
					$(this).parent().show();
					$(this).show();	 
				}
				
			}
	}			
			});
		
}


function refineText(){
	$('.scheduler-event-recorder-content').each(function(){
		var key=$('.scheduler-event-recorder-content').text();
		var istrue=key.lastIndexOf('_');
		if(istrue !=undefined && istrue !="" && istrue != -1){
		    var newKey=key.substring(0,key.lastIndexOf('_'));
		$('.scheduler-event-recorder-content').text(newKey);
		var id=key.substring(key.indexOf("_")+1,key.length);
		$(this).attr("scheduleId",id)
		}
});
}
</script>
