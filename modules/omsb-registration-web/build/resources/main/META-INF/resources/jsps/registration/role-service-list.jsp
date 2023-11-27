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
																 <%-- <th><liferay-ui:message key="committee" /></th> 
																 <th><liferay-ui:message key="function" /></th> --%> 
																<th><liferay-ui:message key="program-type" /></th>
																<th><liferay-ui:message key="program" /></th>
																<th><liferay-ui:message key="action" /></th>
															</tr>
														</thead>
														<tbody>
														 <c:forEach var="userMetadata" items="${userMetadataItem.items}"> 
															<tr>
																<td>${userMetadata.roleName}</td>
																<td>${userMetadata.departmentId}</td>
																<td>${userMetadata.sectionId}</td>
																<%-- <td>${userMetadata.committeeId}</td> 
																 <td>${userMetadata.functionId}</td> --%> 
																<td>${userMetadata.programTypeName}</td>
																<td>${userMetadata.programName}</td>
																
																<td>
																	<c:if test="${not userMetadata.requestedByAdmin}">
																		<button class="btn delete_btn" value="Delete" type="button" data-toggle="modal" data-target="#delete-role-service-modal" data-rowcount="addPopUpRow" onclick="setDeleteID('${userMetadata.id}')" ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/delete_icon.svg" style="cursor: default;"></button>
																		<button class="btn mx-2" value="view" type="button" data-toggle="modal" data-target="#add-role-service-confirm-modal" onclick="setRoleServiceID('${userMetadata.id}')" ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg"></button>
																	</c:if>
																</td>
															</tr>
														 </c:forEach>
													</tbody>
												</table>
												</c:when>
												<c:otherwise>
													<liferay-ui:message key="no-records-found" />
												</c:otherwise>
									</c:choose>
</div>
