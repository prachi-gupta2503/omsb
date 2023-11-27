<%@ include file="../../init.jsp"%>

<style>

.work-td-action  {
	width :150px !important;
	text-align: center;
}
</style>
<portlet:renderURL var="viewRegistrationURL">
			<portlet:param name="mvcRenderCommandName" value="/" />
 </portlet:renderURL>
<div class="main-content">
	<div id="wrapper">
		<div class="container">
			<div class="omsb-card ">
				<div class="omsb-card m-0 p-0">
					<div class="omsb-page-top-info mb-4">
						<div class="pagetitle"><liferay-ui:message key="my-profile" /></div>
						<div class="profile_photo">
                                                <div class="upload-container">
                                                     <c:if test="${not empty photoURL }">                                             
                                                     <img id="imagePreview" src="${photoURL}" alt="Preview">
                                                     </c:if>
                                                     <c:if test="${empty photoURL }">
                                                     <img id="imagePreview" src="<%=themeDisplay.getPathThemeImages() %>/png/profile_img.png" alt="Preview">
                                                     </c:if>
                                                </div>
                                            </div>
					</div>
				</div>
				<h3 class="reg-form-title d-flex justify-content-between align-items-center">
				<div class="d-flex" >
								<liferay-ui:message key="personal-details" />
								<c:choose>
									<c:when test="${personalDetails.personalDetailVerified}">
										<span style="" id="verifyDetails" class="status-text-verified justify-content-between align-items-center"> <img src="<%=themeDisplay.getPathThemeImages() %>/svg/verified_green.svg"><liferay-ui:message key="verified" /></span>
										<span id="unverifyDetails" style="display: none;" class="status-text-un-verified  justify-content-between align-items-center"><img src="<%=themeDisplay.getPathThemeImages() %>/svg/unverified_red.svg"><liferay-ui:message key="un-verified" /></span>
									</c:when>
									<c:otherwise>
										<span style="display: none;" id="verifyDetails" class="status-text-verified justify-content-between align-items-center"> <img src="<%=themeDisplay.getPathThemeImages() %>/svg/verified_green.svg"> <liferay-ui:message key="verified" /></span>
										<span id="unverifyDetails" class="status-text-un-verified d-flex justify-content-between align-items-center"><img src="<%=themeDisplay.getPathThemeImages() %>/svg/unverified_red.svg"> <liferay-ui:message key="un-verified" /></span>
									</c:otherwise>
								</c:choose>
							</div>
				<c:if test="${isProfileApprover}">
				<div class="form-group m-0 w-auto">
					<div class="custom-control custom-checkbox ">
						<c:choose>
							<c:when test="${personalDetails.personalDetailVerified}">
								<input type="checkbox" class="custom-control-input" id="personalverify" checked="checked" name="personalverify">
							</c:when>
							<c:otherwise>
								<input type="checkbox" class="custom-control-input" id="personalverify" name="personalverify">
							</c:otherwise>
						</c:choose>
						<label class="custom-control-label m-0" for="personalverify"><liferay-ui:message key="verify" /></label>
					</div>
				</div>	
				</c:if>
							</h3>		
				<div class="row">
					<div class="col-md-4 label-box">
						<label class="label-name"><liferay-ui:message key="username" /></label>
						<label class="label-content">${user_.screenName}</label>
					</div>
					<c:if test="${ not empty person.civilId}">
					<div class="col-md-4 label-box">
						<label class="label-name"><liferay-ui:message key="omani-civil-id-or-omani-resident-id" /></label>
						<label class="label-content">${person.civilId}</label>
					</div>
					</c:if>
					<div class="col-md-4 label-box">
						<label class="label-name"><liferay-ui:message key="date-of-birth" /></label>
						<label class="label-content">${person.dateOfBirth}</label>
					</div>
					<c:if test="${ not empty person.passportNumber}">
					<div class="col-md-4 label-box">
						<label class="label-name"><liferay-ui:message key="passport-no" /></label>
						<label class="label-content">${person.passportNumber}</label>
					</div>
					</c:if>
					<div class="col-md-4 label-box">
						<label class="label-name"><liferay-ui:message key="country-of-issue" /></label>
						<label class="label-content">${personalDetails.passportIssuingCountryName}</label>
					</div>
					<div class="col-md-4 label-box">
						<label class="label-name"><liferay-ui:message key="date-of-passport-exipry" /></label>
						<label class="label-content">${personalDetails.passportExpiryDate}</label>
					</div>
					<div class="col-md-4 label-box">
						<label class="label-name"><liferay-ui:message key="first-name" /></label>
						<label class="label-content">${user_.firstName}</label>
					</div>
					<div class="col-md-4 label-box">
						<label class="label-name"><liferay-ui:message key="family-name" /></label>
						<label class="label-content">${user_.lastName}</label>
					</div>
					<div class="col-md-4 label-box">
						<label class="label-name"><liferay-ui:message key="gender" /></label>
						<label class="label-content">${gender.genderName}</label>
					</div>
					<div class="col-md-4 label-box">
						<label class="label-name"><liferay-ui:message key="country-of-nationality" /></label>
						<label class="label-content">${personalDetails.nationalityCountryName}</label>
					</div>
					<div class="col-md-4 label-box">
						<label class="label-name"><liferay-ui:message key="email" /></label>
						<label class="label-content">${personalDetails.email} <c:choose><c:when test="${user_.emailAddressVerified}"><span class="status-text-verified"><img src="<%=themeDisplay.getPathThemeImages()%>/svg/verified_green.svg"><liferay-ui:message key="verified" /></span></c:when><c:otherwise><span class="status-text-un-verified"><img src="<%=themeDisplay.getPathThemeImages()%>/svg/unverified_red.svg"><liferay-ui:message key="un-verified" /></span></c:otherwise></c:choose></label>
					</div>
					<div class="col-md-4 label-box">
						<label class="label-name"><liferay-ui:message key="mobile" /></label>
						<label class="label-content"> 
					 	 <c:if test="${not empty personalDetails.countryCode}">
						+ ${personalDetails.countryCode}  
						</c:if>
						${personalDetails.mobileNumber} <c:choose><c:when test="${personalDetails.mobileNumberVerified}"><span class="status-text-verified"><img src="<%=themeDisplay.getPathThemeImages()%>/svg/verified_green.svg"><liferay-ui:message key="verified" /></span></c:when><c:otherwise><span class="status-text-un-verified"><img src="<%=themeDisplay.getPathThemeImages()%>/svg/unverified_red.svg"><liferay-ui:message key="un-verified" /></span></c:otherwise></c:choose></label>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4 label-box">
						<label class="label-name"><liferay-ui:message key="profession" /></label>
						<label class="label-content">${profession.getName(themeDisplay.getLocale())}</label>
					</div>
					<div class="col-md-4 label-box">
						<label class="label-name"><liferay-ui:message key="primary-speciality" /></label>
						<label class="label-content">${primarySpeciality}</label>
					</div>
					<div class="col-md-4 label-box">
						<label class="label-name"><liferay-ui:message key="secondary-speciality" /></label>
						<label class="label-content">${secondarySpeciality}</label>
					</div>
					<div class="col-lg-12 col-md-12">
						<div class="form-group">
							<label class="control-label label-file"><liferay-ui:message key="personal-photo" /></label>
							<div class="omsb-card-caserport">
								<div class="leftbar">
									<h4 class="casereport-title">${photo}</h4>
								</div>
								<div class="righbar">
									<a href="${photoURL}" target="_blank" class="btn view_btn">
											<img src="<%=themeDisplay.getPathThemeImages()%>/svg/view_icon.svg" alt=""><liferay-ui:message key="view" />
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="omsb-page-top-info mb-4">
							
							<h3 class="reg-form-title d-flex justify-content-between align-items-center">
									<liferay-ui:message key="education-details" />
							</h3>
						</div>

                    <div id="edu_detail_area">
								<input type="hidden" value="1"  name="<portlet:namespace/>counter"  id="counter"/>
								<!-- ==============================Education Data table =============================-->
								<div id="educationDetailsList">
											<c:choose>
												<c:when test="${!empty educationalDetailItemList}">
													<table class="display omsb-datatables" id="work-detail-list" width="100%">
														<thead>
															<tr>
																<th><liferay-ui:message key="qualification-type" /></th>
																<th><liferay-ui:message key="institution" /></th>
																<th><liferay-ui:message key="country-of-institution" /></th>
																<%-- <th><liferay-ui:message key="gpa" /></th> --%>
																<th><liferay-ui:message key="year-of-graduation" /></th>
																<th><liferay-ui:message key="verification-status" /></th>
																<c:if test="${isProfileApprover}">
																	<th><liferay-ui:message key="action" /></th>
																</c:if>
															</tr>
														</thead>
														<tbody>
														<c:forEach var="educationalDetailItem" items="${educationalDetailItemList}" varStatus="loopCounter">
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
																					<span style="" id="EducationverifyDetails" class="1 status-text-verified justify-content-between align-items-center"> <img src="<%=themeDisplay.getPathThemeImages() %>/svg/verified_green.svg">  <liferay-ui:message key="verified" /></span>
																					<span id="EducationunverifyDetails" class="d-none"><img src="<%=themeDisplay.getPathThemeImages() %>/svg/unverified_red.svg">  <liferay-ui:message key="un-verified" /></span>

																				</c:when>

																				<c:otherwise>

																					<span  id="EducationverifyDetails" style="display: none;" class="d-none"> <img src="<%=themeDisplay.getPathThemeImages() %>/svg/verified_green.svg">  <liferay-ui:message key="verified" /></span>

																					<span style="" id="EducationunverifyDetails" class="2 status-text-un-verified  justify-content-between align-items-center"><img src="<%=themeDisplay.getPathThemeImages() %>/svg/unverified_red.svg">  <liferay-ui:message key="un-verified" /></span>
																				</c:otherwise>
																			</c:choose>	
																	</div>
																</td>
																<c:if test="${isProfileApprover}">
																	<td>
																		<div class="form-group p-0 m-0 d-flex">
																			<div class="custom-control custom-checkbox w-auto">
																				<c:choose>
																					<c:when test="${educationalDetailItem.educationDetailVerified}">
																						<input type="checkbox"  value="${educationalDetailItem.id}" class="custom-control-input Educationverify" checked="checked" id="Educationverify_${loopCounter.count}" name="Educationverify" >
																					</c:when>
																					<c:otherwise>
																							<input type="checkbox"  value="${educationalDetailItem.id}" class="custom-control-input Educationverify" id="Educationverify_${loopCounter.count }" name="Educationverify" >
																					</c:otherwise>
																				</c:choose>
																				<label class="custom-control-label m-0" for="verify">Verify</label>						
																			</div>
																		</div>
																	</td>
																</c:if>
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

								<%-- <input type="hidden" value="${personId}" name="<portlet:namespace/>personId" id="personId"/>

								<input type="hidden" value="${lrUserId}" name="<portlet:namespace/>lrUserId" id="lrUserId"/> --%>

								<!-- ==============================Education Data table =============================-->

							</div>
						
						
						
						
				
				
				<%-- <div class="omsb-page-top-info mb-4">
					<h3 class="reg-form-title"><liferay-ui:message key="work-details" /></h3>
				</div> --%>
				<%-- <div class="d-flex">
					<div class="w-50">
						<label class="control-label"><liferay-ui:message key="are-you-currently-or-have-been-employed" /></label>
					</div>
					<div class="form-group yesorno">
					<c:choose>
						<c:when test="${workDetailItems.getItems().size() > 0}">
						<div class="custom-control custom-radio ">
							<input type="radio" name="<portlet:namespace/>employed" class="custom-control-input" id="employed_yes" checked disabled/>
							<label class="custom-control-label m-0" for="employed_yes"><liferay-ui:message key="yes" /></label>
						</div>
						<div class="custom-control custom-radio "> 
							<input type="radio" name="<portlet:namespace/>employed" class="custom-control-input" id="employed_no"  disabled />
							<label class="custom-control-label m-0" for="employed_no"><liferay-ui:message key="no" /></label>
						</div>
						</c:when>
						<c:otherwise>
						<div class="custom-control custom-radio ">
							<input type="radio" name="<portlet:namespace/>employed" class="custom-control-input" id="employed_yes"  disabled/>
							<label class="custom-control-label m-0" for="employed_yes"><liferay-ui:message key="yes" /></label>
						</div>
						<div class="custom-control custom-radio "> 
							<input type="radio" name="<portlet:namespace/>employed" class="custom-control-input" id="employed_no"  checked disabled />
							<label class="custom-control-label m-0" for="employed_no"><liferay-ui:message key="no" /></label>
						</div>
						</c:otherwise>
						</c:choose>
					</div>
				</div> --%>
					<div class="omsb-page-top-info mb-4">
							
							<h3 class="reg-form-title d-flex justify-content-between align-items-center">
									<liferay-ui:message key="work-details" />
							</h3>
						</div>


				<div id="workDetailList">
					<c:choose>
						<c:when test="${!empty workDetailItems.getItems()}">
							<table class="display omsb-datatables" id="work-detail-list1"
								width="100%">
								<thead>
									<tr>
										<th><liferay-ui:message key="workplace-sector-type" /></th>
										<%-- <th><liferay-ui:message key="workplace-sector-other" /></th> --%>
										<th><liferay-ui:message key="sector-name" /></th>
										<%-- <th><liferay-ui:message key="sector-name-other" /></th>
											<th><liferay-ui:message key="sector-name-2" /></th>
											<th><liferay-ui:message key="sector-name-2-other" /></th> --%>
										<th><liferay-ui:message
												key="region-locationS-institution" /></th>
										<th><liferay-ui:message key="designation" /></th>
										<th><liferay-ui:message key="verification-status" /></th>
										<c:if test="${isProfileApprover}">		
											<th><liferay-ui:message key="action" /></th>
										</c:if>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="pastWorkDetail"
										items="${workDetailItems.getItems()}">
										<tr>
											<td>${pastWorkDetail.getWorkSectorType()}</td>
											<%-- <td>${pastWorkDetail.getWorkSectorTypeOther()}</td> --%>
											<td>${pastWorkDetail.getWorkSector()}</td>
											<%-- <td>${pastWorkDetail.getWorkSectorOther()}</td>
												<td>${pastWorkDetail.getWorkSector2()}</td>
												<td>${pastWorkDetail.getWorkSectorOther2()}</td> --%>
											<td>${pastWorkDetail.getWorkSectorLocation()}</td>
											<td>${pastWorkDetail.getDesignationId()}</td>
											<td>
												<div class="d-flex">
													<c:choose>
														<c:when
															test="${pastWorkDetail.isEmploymentDetailVerified()}">
															<span style="" id="WorkverifyDetails"
																class="1 status-text-verified justify-content-between align-items-center">
																<img
																src="<%=themeDisplay.getPathThemeImages()%>/svg/verified_green.svg">
																<liferay-ui:message key="verified" />
															</span>
															<span id="WorkunverifyDetails" class="d-none"><img
																src="<%=themeDisplay.getPathThemeImages()%>/svg/unverified_red.svg">
																<liferay-ui:message key="un-verified" /></span>

															<%-- <span style="" id="verifyDetails" class="status-text-verified justify-content-between align-items-center"> <img src="<%=themeDisplay.getPathThemeImages() %>/svg/verified_green.svg"> Verified</span>
															<span id="unverifyDetails" style="display: none;" class="status-text-un-verified  justify-content-between align-items-center"><img src="<%=themeDisplay.getPathThemeImages() %>/svg/unverified_red.svg"> Un-verified</span> --%>
														</c:when>
														<c:otherwise>
															<span id="WorkverifyDetails" style="display: none;"
																class="d-none"> <img
																src="<%=themeDisplay.getPathThemeImages()%>/svg/verified_green.svg">
																<liferay-ui:message key="verified" />
															</span>
															<span style="" id="WorkverifyDetails"
																class="2 status-text-un-verified  justify-content-between align-items-center"><img
																src="<%=themeDisplay.getPathThemeImages()%>/svg/unverified_red.svg">
																<liferay-ui:message key="un-verified" /></span>
															<%-- <span style="display: none;" id="verifyDetails" class="status-text-verified justify-content-between align-items-center"> <img src="<%=themeDisplay.getPathThemeImages() %>/svg/verified_green.svg"> Verified</span> --%>
															<%-- <span id="unverifyDetails" class="status-text-un-verified d-flex justify-content-between align-items-center"><img src="<%=themeDisplay.getPathThemeImages() %>/svg/unverified_red.svg"> Un-verified</span> --%>
														</c:otherwise>
													</c:choose>
												</div>



											</td>
											<c:if test="${isProfileApprover}">
											<td class="work-td-action">
												<div class="form-group p-0 m-0 d-flex">
													<div class="custom-control custom-checkbox w-auto">
														<c:choose>
															<c:when
																test="${pastWorkDetail.isEmploymentDetailVerified()}">
																<input type="checkbox" value="${pastWorkDetail.id}"
																	class="custom-control-input Workverify"
																	checked="checked" id="Workverify" name="Workverify">
															</c:when>
															<c:otherwise>
																<input type="checkbox" value="${pastWorkDetail.id}"
																	class="custom-control-input Workverify" id="Workverify"
																	name="Workverify">
															</c:otherwise>
														</c:choose>
														<label class="custom-control-label m-0" for="verify"> <liferay-ui:message key="verify" /></label>
													</div>
												</div>
											</td>
											</c:if>
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

				
				<div class="reg_step4 mt-4"  id="reg_step4">						
					<div class="omsb-page-top-info mb-4">
						<h3 class="reg-form-title"><liferay-ui:message key="roles-service" /></h3>
					</div>
					<%-- <div class="d-flex">
						<div class="w-50">
							<label class="control-label"><liferay-ui:message key="are-you-associated-with-omsb" /></label>
						</div>
						<div class="form-group yesorno">
						<c:choose>
								 <c:when test="${userMetadata.associated}">
							<div class="custom-control custom-radio ">
								<input type="radio" name="associated" class="custom-control-input" id="associated_yes" value="1" checked="checked" disabled>
								<label class="custom-control-label m-0" for="associated_yes"><liferay-ui:message key="yes" /></label>
							</div>
							<div class="custom-control custom-radio ">
								<input type="radio" name="associated" class="custom-control-input" id="associated_no" value="0" disabled>
								<label class="custom-control-label m-0" for="associated_no"><liferay-ui:message key="no" /></label>
							</div>
							</c:when>
							<c:when test="${!userMetadata.associated}">
							<div class="custom-control custom-radio ">
								<input type="radio" name="associated" class="custom-control-input" id="associated_yes" value="0" disabled>
								<label class="custom-control-label m-0" for="associated_yes"><liferay-ui:message key="yes" /></label>
							</div>
							<div class="custom-control custom-radio ">
								<input type="radio" name="associated" class="custom-control-input" id="associated_no" value="1" checked="checked" disabled>
								<label class="custom-control-label m-0" for="associated_no"><liferay-ui:message key="no" /></label>
							</div>
							</c:when>
							</c:choose>
						</div>
					</div> --%>
					<div class="" id="registrant_detail_area" >
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
																 <th><liferay-ui:message key="status" /></th> 
																
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
																<td><liferay-ui:message key="${userMetadata.roleVerifiedStatus}"/></td>
																
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
						
						
								
					</div>
				</div>
				<div class="bottom-backbtn-wrap">
					<c:choose>
						<c:when test="${registration.workflowStatus eq 'Pending' && isServiceApprover && registration.assignedToMe}">
							<%-- <portlet:actionURL var="WorkflowAssignURL" name="<%=MVCCommands.SAVE_ADMIN_ASSIGN_DECISION%>">
								<portlet:param name="workflowTaskId" value="${registration.workflowTaskId}" />
								<portlet:param name="workflowInstanceId" value="${registration.workflowInstanceId}" />
							</portlet:actionURL>
							<a href="${WorkflowAssignURL}">
								<button class="btn omsb-bc-red-button" type="button" title="<liferay-ui:message key="assign-to-me" />"><liferay-ui:message key="assign-to-me" /></button>
							</a>
						</c:when>
						<c:when test="${registration.workflowStatus eq 'Pending' && isServiceApprover && !registration.assignedToMe}"> --%>
							<a onclick="setInputValues('sa', '${registration.getWorkflowTaskId()}', '${registration.workflowInstanceId}', '${registration.workflowId}')" data-toggle="modal" data-target="#adjuducate_service_popup">
								<button class="btn omsb-bc-red-button" type="button" title="<liferay-ui:message key="verify-service" />"><liferay-ui:message key="verify-service" /></button>
							</a>
						</c:when>
					</c:choose>
	
					<c:choose>
						<c:when test="${registration.workflowStatus eq 'Pending' && isRoleApprover && registration.assignedToMe}">
							<%-- <portlet:actionURL var="WorkflowAssignURL" name="<%=MVCCommands.SAVE_ADMIN_ASSIGN_DECISION%>">
								<portlet:param name="workflowTaskId" value="${registration.workflowTaskId}" />
								<portlet:param name="workflowInstanceId" value="${registration.workflowInstanceId}" />
							</portlet:actionURL>
							<a href="${WorkflowAssignURL}">
								<button class="btn omsb-bc-red-button" type="button" title="<liferay-ui:message key="assign-to-me" />"><liferay-ui:message key="assign-to-me" /></button>
							</a>
						</c:when>
						<c:when test="${registration.workflowStatus eq 'Pending' && isRoleApprover && !registration.assignedToMe}"> --%>
							<a onclick="setInputValues('ra', '${registration.getWorkflowTaskId()}', '${registration.workflowInstanceId}', '${registration.workflowId}')" data-toggle="modal" data-target="#adjuducate_role_popup">
								<button class="btn omsb-bc-red-button" type="button" title="<liferay-ui:message key="verify-role" />"><liferay-ui:message key="verify-role" /></button>
							</a>
						</c:when>
					</c:choose>
					
					<c:choose>
						<c:when test="${registration.workflowStatus eq 'Pending' && isProfileApprover && registration.assignedToMe}">
							<%-- <portlet:actionURL var="WorkflowAssignURL" name="<%=MVCCommands.SAVE_ADMIN_ASSIGN_DECISION%>">
								<portlet:param name="workflowTaskId" value="${registration.workflowTaskId}" />
								<portlet:param name="workflowInstanceId" value="${registration.workflowInstanceId}" />
							</portlet:actionURL>
							<a href="${WorkflowAssignURL}">
								<button class="btn omsb-bc-red-button" type="button" title="<liferay-ui:message key="assign-to-me" />"><liferay-ui:message key="assign-to-me" /></button>
							</a>
						</c:when>
						<c:when test="${registration.workflowStatus eq 'Pending' && isProfileApprover && !registration.assignedToMe}"> --%>
							<a onclick="setInputValues('pa', '${registration.getWorkflowTaskId()}', '${registration.workflowInstanceId}', '${registration.workflowId}')" data-toggle="modal" data-target="#adjuducate_profile_popup">
								<button class="btn omsb-bc-red-button" type="button" title="<liferay-ui:message key="verify-profile" />"><liferay-ui:message key="verify-profile" /></button>
							</a>
						</c:when>
					</c:choose>				
					<a class="btn omsb-btn btn-back" href="${viewRegistrationURL}"><i class="fi fi-sr-arrow-left"></i><liferay-ui:message key="back" /></a>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- Modal adjuducate_profile_popup -->
<div class="modal fade omsb-modal" id="adjuducate_profile_popup" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<liferay-portlet:actionURL name="<%=MVCCommands.SAVE_ADMIN_DECISION%>" var="saveProfileApproverDecisionURL" />
		
			<div class="modal-content">
			<form action="${saveProfileApproverDecisionURL}" method="post" 
						name="<portlet:namespace/>paFM" id="paFM" autocomplete="off">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="adjuducate-profile" /></h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label><liferay-ui:message key="comments" /></label>
								<textarea class="form-control paComments" name="<portlet:namespace/>comments" id="paComments" ></textarea>
							</div>
							<p id="errorContainer-pa-comments" class="error-container"></p>
						</div>
					</div>
				</div>
				<input type="hidden" name="<portlet:namespace/>userRegistrationStatusId" id="paUserRegistrationStatusId" >
				<input type="hidden" name="<portlet:namespace/>decision" id="paDecision" >
				<input type="hidden" name="<portlet:namespace/>workflowInstanceId" id="paWorkflowInstanceId" >
				<input type="hidden" name="<portlet:namespace/>workflowTaskId" id="paWorkflowTaskId" >
				<div class="modal-footer omsb-popup-buttons-3">
					<button onClick="validateAndSaveFormData('approve', 'pa')" class="btn omsb-bc-red-button" type="button" title="<liferay-ui:message key="approve" />"><liferay-ui:message key="approve" /></button>
					<button onClick="validateAndSaveFormData('reject', 'pa')" class="btn omsb-bc-red-button" type="button" title="<liferay-ui:message key="reject" />"><liferay-ui:message key="reject" /></button>
					<button class="btn omsb-bg-red-button" id="btn-close-popup" type="button" title="<liferay-ui:message key="close" />"><liferay-ui:message key="close" /></button>
				</div>
				</form>
			</div>
		
	</div>
</div>
<!--// adjuducate_profile_popup pop up -->

<!-- Modal adjuducate_role_popup -->
<div class="modal fade omsb-modal" id="adjuducate_role_popup" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<liferay-portlet:actionURL name="<%=MVCCommands.SAVE_ADMIN_DECISION%>" var="saveRoleApproverDecisionURL" />
		
			<div class="modal-content">
			<form action="${saveRoleApproverDecisionURL}" method="post" name="<portlet:namespace/>raFM" id="raFM" autocomplete="off">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="adjuducate-role" /></h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label><liferay-ui:message key="comments" /></label>
								<textarea class="form-control raComments" name="<portlet:namespace/>comments" id="raComments" ></textarea>
							</div>
							<p id="errorContainer-ra-comments" class="error-container"></p>
						</div>
					</div>
				</div>
				<input type="hidden" name="<portlet:namespace/>userRegistrationStatusId" id="raUserRegistrationStatusId" >
				<input type="hidden" name="<portlet:namespace/>decision" id="raDecision" >
				<input type="hidden" name="<portlet:namespace/>workflowInstanceId" id="raWorkflowInstanceId" >
				<input type="hidden" name="<portlet:namespace/>workflowTaskId" id="raWorkflowTaskId" >
				<div class="modal-footer omsb-popup-buttons-3">
					<button onClick="validateAndSaveFormData('approve', 'ra')" class="btn omsb-bc-red-button" type="button" title="<liferay-ui:message key="approve" />"><liferay-ui:message key="approve" /></button>
					<button onClick="validateAndSaveFormData('reject', 'ra')" class="btn omsb-bc-red-button" type="button" title="<liferay-ui:message key="reject" />"><liferay-ui:message key="reject" /></button>
					<button class="btn omsb-bg-red-button" type="button" title="<liferay-ui:message key="close" />" class="close" data-dismiss="modal" ><liferay-ui:message key="close" /></button>
				</div>
				</form>
			</div>
	
	</div>
</div>
<!--// adjuducate_role_popup pop up -->

<!-- Modal adjuducate_service_popup -->
<div class="modal fade omsb-modal" id="adjuducate_service_popup" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<liferay-portlet:actionURL name="<%=MVCCommands.SAVE_ADMIN_DECISION%>" var="saveServiceApproverDecisionURL" />
		
			<div class="modal-content">
			<form action="${saveServiceApproverDecisionURL}" method="post" 
						name="<portlet:namespace/>saFM" id="saFM" autocomplete="off">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="adjuducate-service" /></h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label><liferay-ui:message key="comments" /></label>
								<textarea class="form-control saComments" name="<portlet:namespace/>comments" id="saComments" ></textarea>
							</div>
							<p id="errorContainer-sa-comments" class="error-container"></p>
						</div>
					</div>
				</div>
				<input type="hidden" name="<portlet:namespace/>userRegistrationStatusId" id="saUserRegistrationStatusId" >
				<input type="hidden" name="<portlet:namespace/>decision" id="saDecision" >
				<input type="hidden" name="<portlet:namespace/>workflowInstanceId" id="saWorkflowInstanceId" >
				<input type="hidden" name="<portlet:namespace/>workflowTaskId" id="saWorkflowTaskId" >
				<div class="modal-footer omsb-popup-buttons-3">
					<button onClick="validateAndSaveFormData('approve', 'sa')" class="btn omsb-bc-red-button" type="button" title="<liferay-ui:message key="approve" />"><liferay-ui:message key="approve" /></button>
					<button onClick="validateAndSaveFormData('reject', 'sa')" class="btn omsb-bc-red-button" type="button" title="<liferay-ui:message key="reject" />"><liferay-ui:message key="reject" /></button>
					<button class="btn omsb-bg-red-button" type="button" title="<liferay-ui:message key="close" />" class="close" data-dismiss="modal" ><liferay-ui:message key="close" /></button>
				</div>
					</form>
			</div>
	</div>
</div>
<!--// adjuducate_service_popup pop up -->
<input type="hidden" name="<portlet:namespace/>lrUserId" value="${user_.userId}" id="lrUserId">
<input type="hidden" name="<portlet:namespace/>personId" value="${personId}" id="personId">
<portlet:resourceURL id="<%=MVCCommands.VERIFY_REGISTRATION_PERSONAL_DETAILS%>" var="verifyPersonalDetailURL" />
<portlet:resourceURL id="<%=MVCCommands.VERIFY_REGISTRATION_EDUCATION_DETAILS%>" var="verifyEducationDetailURL" />
<portlet:resourceURL id="<%=MVCCommands.VERIFY_REGISTRATION_WORK_DETAILS%>" var="verifyWorkURL" />

<script>
	
	$('.paComments').richText();
	$('.raComments').richText();
	$('.saComments').richText();
	function setInputValues(modal, workflowTaskId, workflowInstanceId, userRegistrationStatusId) {
		document.getElementById(modal+"UserRegistrationStatusId").value = userRegistrationStatusId;
		document.getElementById(modal+"WorkflowTaskId").value = workflowTaskId;
		document.getElementById(modal+"WorkflowInstanceId").value = workflowInstanceId;
	}
	
	function validateAndSaveFormData(decision, modal) {
		
		var errorMessages = [];
		var paComments = document.getElementById(modal+"Comments").value;
		if (!paComments) {
			errorMessages.push("<liferay-ui:message key='please-enter-comments' />");
			document.getElementById("errorContainer-"+modal+"-comments").textContent = "<liferay-ui:message key='please-enter-comments' />";
		} else {
			document.getElementById("errorContainer-"+modal+"-comments").textContent = "";
		}
		
		if (errorMessages.length > 0) {
			event.preventDefault();
		} else {
			document.getElementById(modal+"Decision").value = decision;
			document.getElementById(modal+"FM").submit();
		}
	}
	
	 $('#role-service-list').DataTable({	
		    "bLengthChange": false,	
		    "bFilter": false,
		    "ordering": false
		});
	  $('#work-detail-list').DataTable({	
		    "bLengthChange": false,	
		    "bFilter": false,
		    "ordering": false
		});	

		$('#work-detail-list1').DataTable({	
		    "bLengthChange": false,	
		    "bFilter": false,
		    "ordering": false
		});
	 
	 $("#personalverify").click(function(){
			//debugger;
		console.log("inside personal detail function");	
			var isChecked=false;
			
			if($(this).is(':checked')){
				isChecked=true;
			}else{
				isChecked=false;
			}
			
			
			$.ajax({
				url: '${verifyPersonalDetailURL}',
				async : false,
				data : {
					<portlet:namespace />isChecked : isChecked,
					<portlet:namespace />lrUserId : $('#lrUserId').val(),
					<portlet:namespace />personId : $('#personId').val(),
				},
				type : 'POST',
				success : function(data) {
					const response = JSON.parse(data);
					console.log("Response :::",response);
					
					if(response== true){
						$("#verifyDetails").addClass('d-flex').show();
						$("#unverifyDetails").removeClass('d-flex').hide();
					}else{
						$("#verifyDetails").removeClass('d-flex').hide();
						$("#unverifyDetails").addClass('d-flex').show();
					}
					}
			})
		})
		
		$(document).on('click','.Educationverify',function(){		
			 console.log("Clicked ",$(this).val());
			var isChecked=false;
			if($(this).is(':checked')){
				isChecked=true;
			}else{
				isChecked=false;
			}
			console.log("isChecked :::: ",isChecked);
			 $.ajax({
				url: '${verifyEducationDetailURL}',
				async : false,
				data : {
<portlet:namespace />isChecked : isChecked,
<portlet:namespace />id : $(this).val(),
				},
				type : 'POST',
				success : function(data) {
					$("#educationDetailsList").html(data);
					$('#work-detail-list').DataTable({	
					    "bLengthChange": false,	
					    "bFilter": false,
					    "ordering": false
					});
					} 
			}) 

});
	 
	 $(document).on('click','.Workverify',function(){		
		 console.log("Workverify Clicked ",$(this).val());
		var isChecked=false;
		if($(this).is(':checked')){
			isChecked=true;
		}else{
			isChecked=false;
		}
		console.log("isChecked :::: ",isChecked);
		//console.log("verifyWorkURL :::: ",verifyWorkURL);
		 $.ajax({
			url: '${verifyWorkURL}',
			async : false,
			data : {
<portlet:namespace />isChecked : isChecked,
<portlet:namespace />id : $(this).val(),
			},
			type : 'POST',
			success : function(data) {
				$("#workDetailList").html(data);
				$('#work-detail-list1').DataTable({	
				    "bLengthChange": false,	
				    "bFilter": false,
				    "ordering": false
				});
				} 
		}) 

});
	 
$(document).on('click','#btn-close-popup',function(){
	console.log("close clicked ::: ");
 	$("#adjuducate_profile_popup").modal('hide');
});
</script>