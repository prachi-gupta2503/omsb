<%@ include file="../../init.jsp"%>
<link rel="stylesheet" type="text/css"
	href="<%=themeDisplay.getPathThemeCss()%>/datatables/dataTables.bootstrap4.min.css">
<link rel="stylesheet" type="text/css"
	href="<%=themeDisplay.getPathThemeCss()%>/datatables/responsive.bootstrap4.min.css">
<script type="text/javascript"
	src="<%=themeDisplay.getPathThemeJavaScript()%>/datepicker/bootstrap-datepicker.min.js"></script>
<script type="text/javascript"
	src="<%=themeDisplay.getPathThemeJavaScript()%>/datatables/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src="<%=themeDisplay.getPathThemeJavaScript()%>/datatables/dataTables.bootstrap4.min.js"></script>
<script type="text/javascript"
	src="<%=themeDisplay.getPathThemeJavaScript()%>/datatables/dataTables.responsive.min.js"></script>
<script type="text/javascript"
	src="<%=themeDisplay.getPathThemeJavaScript()%>/datatables/responsive.bootstrap4.min.js"></script>

<portlet:renderURL var="addDutyTypeURL">
	<portlet:param name="cmd" value="DutyType" />
</portlet:renderURL>
<portlet:renderURL var="addNewAssignmentURL">
	<portlet:param name="cmd" value="DutyAssignment" />
</portlet:renderURL>

<portlet:renderURL var="addProgramDutyTypeAssignmentURL">
	<portlet:param name="cmd" value="ProgramDutyType" />
</portlet:renderURL>

<portlet:renderURL var="addDutyRulesForProgramURL">
	<portlet:param name="cmd" value="DutyRulesForProgram" />
</portlet:renderURL>

<% String cmd = request.getParameter("cmd");
	if(cmd==null){
		cmd="DutyType";
	}

%>
<style>
.nav-color {
	color: Tomato; /* Set the background color for the active link */
}
</style>
<div id="wrapper">
	<div class="container">
		<div class="omsb-card">
			<div class="row">
				<div class="col-lg-12">
					<ul class="nav nav-pills omsb-nav-pills justify-content-center"
						id="myTab" role="tablist">
						<li class="nav-item"><a href="<%=addDutyTypeURL%>"
							class="nav-link b1 nav-color"><liferay-ui:message key="duty-logging-configuration-nav-duty-types"/></a></li>
						<li class="nav-item"><a href="<%=addNewAssignmentURL%>"
							class="nav-link b2 nav-color"><liferay-ui:message key="duty-logging-configuration-nav-duty-type-assignment"/></a></li>
						<li class="nav-item"><a
							href="<%=addProgramDutyTypeAssignmentURL%>" class="nav-link b3 nav-color"><liferay-ui:message key="duty-logging-configuration-nav-program-duty-type-assignment"/></a></li>
						<li class="nav-item"><a href="<%=addDutyRulesForProgramURL%>"
							class="nav-link b4 nav-color"><liferay-ui:message key="duty-logging-configuration-nav-program-duty-type-rules"/></a></li>
					</ul>
				</div>


			</div>

		</div>
	</div>
</div>
<% String viewPage= (String)renderRequest.getAttribute("jspName"); %>
<jsp:include page="<%= viewPage %>" />

<%-- <% if(renderRequest.getAttribute("jspName").equals("duty-type.jsp")){ %>
            <%@ include file="duty-type.jsp" %>
			<%}else if(renderRequest.getAttribute("jspName").equals("new-assignment.jsp")){ %>
			 <%@ include file="new-assignment.jsp" %>
			 <%}else if(renderRequest.getAttribute("jspName").equals("program-duty-type-assignment.jsp")){ %>
			 <%@ include file="program-duty-type-assignment.jsp" %>
			 <%}else{%>
			 <%@ include file="program-duty-type-assignment.jsp" %>
			 <%}%> --%>
        <script>
			 $(document).ready(function() {
				 var cmd = '<%= cmd%>';
				 if(cmd==="DutyType"){
					  $(".b1").addClass("active");  
					  // Remove the "active" class from all anchor tags
					  $(".b4 .b2 .b3").removeClass("active");
							
				 }else if(cmd === "DutyAssignment"){
					   $(".b2").addClass("active");  
					   // Remove the "active" class from all anchor tags
					   $(".b4 .b1 .b3").removeClass("active");
						
				 }else if(cmd === "ProgramDutyType"){
					   $(".b3").addClass("active");  
					   // Remove the "active" class from all anchor tags
					   $(".b1 .b2 .b4").removeClass("active");
					  
				 }else if(cmd === "DutyRulesForProgram"){
					   $(".b4").addClass("active");  
					   // Remove the "active" class from all anchor tags
					    $(".b1 .b2 .b3").removeClass("active");
					  
				 }
				});
				
			</script>
