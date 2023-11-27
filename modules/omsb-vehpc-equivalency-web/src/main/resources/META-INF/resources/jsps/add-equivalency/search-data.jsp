<%@ include file="../init.jsp"%>

<c:set var="isChecked" value="false" />
<c:if test="${equivalencyDtoList.size() eq 1}">
  <c:set var="isChecked" value="true" />  
  <script>
  	populatePersonData('${equivalencyDtoList.get(0).getPersonName()}','${equivalencyDtoList.get(0).getDob()}','${equivalencyDtoList.get(0).getPersonId()}', '${equivalencyDtoList.get(0).getCaseNumber()}');
  </script>
</c:if>
<c:choose>
	<c:when test="${!empty equivalencyDtoList}">
		<table class="display omsb-datatables" id="employee-tabel">
			<thead>
				<tr>
					<th><liferay-ui:message key="dfrn" /></th>
					<th><liferay-ui:message key="name" /></th>
					<th><liferay-ui:message key="date-of-birth" /></th>
					<th><liferay-ui:message key="email" /></th>
					<th><liferay-ui:message key="action" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="equivalencyDto" items="${equivalencyDtoList}">
					<tr>
						<td>${equivalencyDto.caseNumber}</td>	
						<td>${equivalencyDto.personName}</td>
						<td>${equivalencyDto.dob}</td>
						<td>${equivalencyDto.email}</td>
						<td><input type="checkbox" value="${equivalencyDto.personId}"
							onClick="handleSelectEmployee(this)" <c:if test="${isChecked == 'true'}">checked="checked"</c:if>/></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</c:when>
	<c:otherwise>
		<liferay-ui:message key="no-records-found" />
	</c:otherwise>
</c:choose>
<script>
$('#employee-tabel').DataTable({
    "bLengthChange": false,
    "bFilter": false
});
</script>