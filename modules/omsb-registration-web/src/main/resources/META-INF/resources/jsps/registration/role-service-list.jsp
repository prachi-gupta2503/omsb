<%@ include file="../../init.jsp"%>
<div class="table-responsive">
<c:choose>
	<c:when test="${!empty userMetadataItem}">
			<table class="display omsb-datatables" id="role-service-list" width="100%">
	<thead>
		<tr>
			<th><liferay-ui:message key="role" /></th>
		<th><liferay-ui:message key="department" /></th>
		<th><liferay-ui:message key="section" /></th>
		<th><liferay-ui:message key="program-type" /></th>
		<th><liferay-ui:message key="program" /></th>
		 <th><liferay-ui:message key="status" /></th> 
		<th><liferay-ui:message key="role-approver-comments" /></th> 
		</tr>
	</thead>
	<tbody>
	 <c:forEach var="userMetadata" items="${userMetadataItem.items}"> 
	<tr>
		<td>${userMetadata.roleName}</td>
		<td>${userMetadata.departmentId}</td>
		<td>${userMetadata.sectionId}</td>
		<td>${userMetadata.programTypeName}</td>
		<td>${userMetadata.programName}</td>
		 <td><liferay-ui:message key="${userMetadata.roleVerifiedStatus}"/></td>
		<td>
			<c:if test="${not empty userMetadata.roleVerifiedComments && userMetadata.roleVerifiedStatus != 'Pending'}">
				<div class="information"><img src="<%=themeDisplay.getPathThemeImages()%>/svg/view_icon.svg" alt="" type="button" data-toggle="modal" data-target="#view-role-service-comments-modal" data-rowcount="addPopUpRow" onclick="setRoleServiceCommentID('${userMetadata.roleVerifiedComments}')" ></div>
			</c:if>
		</td> 
	</tr>
	</c:forEach>
		</tbody>
	</table>
	</table>
				</c:when>
	<c:otherwise>
		<liferay-ui:message key="no-records-found" />
	</c:otherwise>
	</c:choose>
</div>
