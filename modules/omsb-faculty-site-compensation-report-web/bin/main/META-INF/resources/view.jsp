<%@page import="com.liferay.portal.kernel.json.*"%>
<%@ include file="/init.jsp"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="java.util.HashMap"%>

<%@page import="java.util.HashSet"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="gov.omsb.faculty.site.compensation.report.web.dto.FacultySiteCompensationListDTO"%>

<html lang="en">
<head>

<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<style>
th, td {
	padding: 5px;
}

th {
	background-color: #AEAAAA;
}

.dark-blue-color {
	background-color: #B4C6E7;
}

.light-blue-color {
	background-color: #DDEBF7;
}

.yellow-color {
	background-color: #FFFFCC;
}

.green-color {
	background-color: #beffc7;
}
</style>


</head>



<body
	style="font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;">
	<h3 style="margin-bottom: 30px;margin-top: 30px;"><liferay-ui:message key="faculty-site-compensation-report"/> <%=request.getAttribute("ProgramName") %></h3>
	
	<table style="width: 100%;" cellpadding="0" cellspacing="0">
		<tr>
			<td>
				<table style="width: 100%;" cellpadding="0" cellspacing="0"
					border="1">
					<thead>
						<%
                     long total=0;
						try{
                     Map<String,List<String>> TrainingSiteAndRotationmap=(Map<String,List<String>>)request.getAttribute("TrainingSiteAndRotationmap");
                     Map<String,List<FacultySiteCompensationListDTO>> FacultySiteCompensationListDTOMap=(Map<String, List<FacultySiteCompensationListDTO>>)request.getAttribute("FacultySiteCompensationListDTOMap");
                     for(Map.Entry facultySiteCompensation:FacultySiteCompensationListDTOMap.entrySet()){  %>
						<tr>
							<th class="dark-blue-color"><h5><%= facultySiteCompensation.getKey() %></h5></th>
							<th class="dark-blue-color"><b><liferay-ui:message key="faculty-site-compensation-current-position"/></b></th>
							<th class="dark-blue-color"><b><liferay-ui:message key="faculty-site-compensation-current-payment"/></b></th>
							<% 
								for(String rotation:TrainingSiteAndRotationmap.get(facultySiteCompensation.getKey())){
							%>
								<th><b><%=rotation%></b></th>
							<% };
							%>
						</tr>
						<%
		             List<FacultySiteCompensationListDTO> values= (List<FacultySiteCompensationListDTO>) facultySiteCompensation.getValue();
						for(FacultySiteCompensationListDTO value:values){
							  total=total+value.getAmountInOmr();
						  %>
					           <tr>
					           		<td><%= value.getFullName()%></td>
									<td><%= value.getRoleName() %></td>
									<td><%= value.getAmountInOmr()  %></td>
									
									
									    <% 
											for(String trainingRotation:TrainingSiteAndRotationmap.get(facultySiteCompensation.getKey())){
											int i=0;
												for(String rotation:value.getRotationName()){
													if(rotation.equalsIgnoreCase(trainingRotation)){ 
														i++;
										%>
											<td><p class="text-center">&check;</p></td>
										<% 
												       }
												}
													if(i==0){
														%>
														<td></td>
													<% }
													
										};
										%>
							</tr>
						    <%	} 
							 }
							}catch(Exception e){
								
							}
	                        %>
							<tr>
									<td>
									<td><b>Total Incentive :</b></td>
									<td><b><%=total%></b></td>
						</tr>
					</thead>
				</table>
			</td>
		</tr>

	</table>
	


</body>
</html>