<%@ include file="../../init.jsp"%>
<div id="educationDetailsList">
											<c:choose>
												<c:when test="${!empty educationalDetailItemList}">
													<table class="display omsb-datatables" id="work-detail-list" width="100%">
														<thead>
															<tr>
																<th><liferay-ui:message key="qualification" /></th>
																<th><liferay-ui:message key="institution" /></th>
																<th><liferay-ui:message key="country-of-institution" /></th>
																<%-- <th><liferay-ui:message key="gpa" /></th> --%>
																<th><liferay-ui:message key="year-of-graduation" /></th>
																<th><liferay-ui:message key="verification-status" /></th>
																<th><liferay-ui:message key="action" /></th>
															</tr>
														</thead>
														<tbody>
														<c:forEach var="educationalDetailItem" items="${educationalDetailItemList}">
															<tr>
																<td>${educationalDetailItem.qualificationAttained}</td>
																<td>${educationalDetailItem.issuingAuthorityName}</td>
																<td>${educationalDetailItem.issuingAuthorityCountry}</td>
																<%-- <td>${educationalDetailItem.gpa}</td> --%>
																<td>${educationalDetailItem.yearOfGraduation}</td>
																<td>
																<div class="d-flex" >
																		<c:choose>
																				<c:when test="${educationalDetailItem.educationDetailVerified}">
																					<span style="" id="EducationverifyDetails" class="1 status-text-verified justify-content-between align-items-center"> <img src="<%=themeDisplay.getPathThemeImages() %>/svg/verified_green.svg"> Verified</span>
																					<span id="EducationunverifyDetails" class="d-none"><img src="<%=themeDisplay.getPathThemeImages() %>/svg/unverified_red.svg"> Un-verified</span>
																					
																					<%-- <span style="" id="verifyDetails" class="status-text-verified justify-content-between align-items-center"> <img src="<%=themeDisplay.getPathThemeImages() %>/svg/verified_green.svg"> Verified</span>
																					<span id="unverifyDetails" style="display: none;" class="status-text-un-verified  justify-content-between align-items-center"><img src="<%=themeDisplay.getPathThemeImages() %>/svg/unverified_red.svg"> Un-verified</span> --%>
																				</c:when>
																				<c:otherwise>
																					<span  id="EducationverifyDetails" style="display: none;" class="d-none"> <img src="<%=themeDisplay.getPathThemeImages() %>/svg/verified_green.svg"> Verified</span>
																					<span style="" id="EducationunverifyDetails" class="2 status-text-un-verified  justify-content-between align-items-center"><img src="<%=themeDisplay.getPathThemeImages() %>/svg/unverified_red.svg"> Un-verified</span>
																					<%-- <span style="display: none;" id="verifyDetails" class="status-text-verified justify-content-between align-items-center"> <img src="<%=themeDisplay.getPathThemeImages() %>/svg/verified_green.svg"> Verified</span> --%>
																					<%-- <span id="unverifyDetails" class="status-text-un-verified d-flex justify-content-between align-items-center"><img src="<%=themeDisplay.getPathThemeImages() %>/svg/unverified_red.svg"> Un-verified</span> --%>
																				</c:otherwise>
																			</c:choose>	
																	</div>
																</td>
																
																<td>
																	<%-- <button class="btn delete_btn" value="Delete" type="button" data-toggle="modal" data-target="#delete-education-confirm-modal" data-rowcount="addPopUpRow" onclick="setDeleteID('${educationalDetailItem.id}')" ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/delete_icon.svg" style="cursor: default;"></button> --%>
<%-- 																	<button class="btn mx-2" value="view" type="button" data-toggle="modal" data-target="#add-education-confirm-modal" onclick="setEditID('${educationalDetailItem.id}')" ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg"></button> --%>
																	<div class="form-group m-0 w-auto">
																	<div class="custom-control custom-checkbox ">
																<c:choose>
																	<c:when test="${educationalDetailItem.educationDetailVerified}">
																	<input type="checkbox"  value="${educationalDetailItem.id}" class="custom-control-input Educationverify" checked="checked" id="Educationverify" name="verify">
																	</c:when>
																	<c:otherwise>
																			<input type="checkbox"  value="${educationalDetailItem.id}" class="custom-control-input Educationverify" id="Educationverify" name="verify">
																	</c:otherwise>
																</c:choose>
																	<label class="custom-control-label m-0" for="verify">Verify</label>						
																	</div>
																</div>
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
					    