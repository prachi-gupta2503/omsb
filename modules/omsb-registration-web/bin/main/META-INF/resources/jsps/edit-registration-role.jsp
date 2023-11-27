<%@ include file="../init.jsp"%>
<style>
    .bottom-backbtn-wrap{
        display: flex;
        margin-top: 15px;
        justify-content: flex-end;
    }

    .omsb-list-filter{
        padding-bottom:0;
    }
</style>
<portlet:renderURL var="viewRegistrationList">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MVCCommands.ADMIN_REGISTRATION_LIST%>" />
</portlet:renderURL>

<div class="main-content">
	<!--- Start Main Content Section Here --->
	<section class="omsb-main-wrapper" id="omsb-main-wrapper">
		<!-- Inner Wrapper Contents -->
		<div id="wrapper">
			<div class="container">
				<div class="omsb-card ">
					<liferay-portlet:actionURL name="<%=MVCCommands.SAVE_REGISTRATION_DETAILS%>" var="saveRDURL">
					<%-- <portlet:param name="personId" value="${ personId}"/> --%>
					</liferay-portlet:actionURL>
					<form action="${saveRDURL}" method="post" 
						name="<portlet:namespace/>rdFM" id="rdFM" autocomplete="off" enctype="multipart/form-data">
						<input type="hidden" value="${personId }" name="<portlet:namespace/>personId_"/>
						<div class="reg_step1" id="reg_step1">
							<div class="omsb-card m-0 p-0">
								<div class="omsb-page-top-info mb-4">
									<div class="pagetitle">
										<c:choose>
										<c:when test="${isRoleApprover}">
											<liferay-ui:message key="edit-role" />
										</c:when>
										<c:when test="${isServiceApprover}">
											<liferay-ui:message key="edit-service" />
										</c:when>
										<c:otherwise>
											<liferay-ui:message key="edit-profile" />
										</c:otherwise>
									</c:choose>
									</div>
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
							
							
						<c:if test="${isRoleApprover || isProfileApprover || isServiceApprover}">
						<div class="omsb-card m-0 p-0">
								<div class="omsb-page-top-info mb-4">
									<a href="<%=viewRegistrationList%>"><button
											class="btn omsb-bc-red-button">
											<liferay-ui:message key="view-registration-list" />
									</button></a>
								</div>
							</div>
						</c:if>
							
							<h3 class="reg-form-title"><liferay-ui:message key="personal-details" /></h3>
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
						<label class="label-content">${primarySpeciality.getName(themeDisplay.getLocale())}</label>
					</div>
					<div class="col-md-4 label-box">
						<label class="label-name"><liferay-ui:message key="secondary-speciality" /></label>
						<label class="label-content">${secondarySpeciality.getName(themeDisplay.getLocale())}</label>
					</div>
					<div class="col-lg-12 col-md-12">
						<div class="form-group">
							<label class="control-label label-file"><liferay-ui:message key="photo" /></label>
							<div class="omsb-card-caserport">
								<div class="leftbar">
									<h4 class="casereport-title">${photo}</h4>
								</div>
								<div class="righbar">
									<a href="${photoURL}" target="_blank" class="btn view_btn">
									<%-- 	<button class="btn view_btn" title="<liferay-ui:message key="title" />View" > --%>
											<img src="<%=themeDisplay.getPathThemeImages()%>/svg/view_icon.svg" alt=""><liferay-ui:message key="view" />
										<!-- </button> -->
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="omsb-page-top-info mb-4">
					<h3 class="reg-form-title"><liferay-ui:message key="education-details" /></h3>
				</div>
				
				<c:forEach var="educationalDetailItem" items="${educationalDetailItemList}" varStatus="loop">
				
				<div class="omsb-card omsb-card-graybg omsb-noBorderRadius edu_detail"  >
					<div class="row">
						<div class="col-md-4 label-box">
							<label class="label-name"><liferay-ui:message key="qualification-title" /></label>
							<label class="label-content">${educationalDetailItem.qualificationAttained}</label>
						</div>
						<div class="col-md-4 label-box">
							<label class="label-name"><liferay-ui:message key="institution" /></label>
							<label class="label-content">${educationalDetailItem.issuingAuthorityName}</label>
						</div>
						<div class="col-md-4 label-box">
							<label class="label-name"><liferay-ui:message key="country-of-institution" /></label>
							<label class="label-content">${educationalDetailItem.issuingAuthorityCountry}</label>
						</div>
						<div class="col-lg-12 col-md-12">
							<div class="form-group">
								<label class="control-label label-file"><liferay-ui:message key="qualification-document" /></label>
								<div class="omsb-card-caserport">
									<div class="leftbar">
										<h4 class="casereport-title">${educationalDetailItem.documentInfo.dFFileName}</h4>
									</div>
									<div class="righbar">
										<a href="${educationalDetailItem.documentInfo.documentURL}" class="btn view_btn" title="<liferay-ui:message key="view" />">
											<img src="<%=themeDisplay.getPathThemeImages()%>/svg/view_icon.svg" alt=""><liferay-ui:message key="view" />
										</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				</c:forEach>
				
				<div class="omsb-page-top-info mb-4">
					<h3 class="reg-form-title"><liferay-ui:message key="work-details" /></h3>
				</div>
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
				<c:forEach  var="workDetail" items="${workDetailItems.getItems() }" varStatus="loop"> 
					<div class="">
				   		<div class="omsb-card omsb-card-graybg omsb-noBorderRadius work_detail" id="work_detail_1" >
				   			<c:if test="${loop.count==1}">
								<label class="control-label"><liferay-ui:message key="primary-work-detail" /></label>
							</c:if>
							<c:if test="${loop.count==2}">
								<label class="control-label"><liferay-ui:message key="secondary-work-detail" /></label>
							</c:if>
				   			<div class="row ">
				   				<c:if test="${ not empty workDetail.getWorkSectorType() }">
				     				<div class="col-md-4 label-box">
										<label class="label-name"><liferay-ui:message key="${loop.count==1?'primary-workplace-sector-type':'secondary-workplace-sector-type'}" /></label>
										<label class="label-content">${workDetail.getWorkSectorType()}</label>
									</div>
								</c:if>
								<c:if test="${ not empty workDetail.getWorkSectorTypeOther() }">
				     				<div class="col-md-4 label-box">
										<label class="label-name"><liferay-ui:message key="${loop.count==1?'primary-workplace-sector-type-other':'secondary-workplace-sector-type-other'}" /></label>
										<label class="label-content">${workDetail.getWorkSectorTypeOther()}</label>
									</div>
								</c:if>
					
								<c:if test="${ not empty workDetail.getWorkSector() }">
								<div class="col-md-4 label-box">
								<label class="label-name"><liferay-ui:message key="${loop.count==1?'primary-sector-name':'secondary-sector-name'}" /></label>
								<label class="label-content">${workDetail.getWorkSector()}</label>
							</div>
						</c:if>
						
						<c:if test="${ not empty workDetail.getWorkSectorOther() }">
						<div class="col-md-4 label-box">
							<label class="label-name"><liferay-ui:message key="${loop.count==1?'primary-sector-name-other':'secondary-sector-name-other'}" /></label>
							<label class="label-content">${workDetail.getWorkSectorOther() }</label>
						</div>
						</c:if>
						
						<c:if test="${ not empty workDetail.getWorkSector2() }">
						 <div class="col-md-4 label-box">
								<label class="label-name"><liferay-ui:message key="${loop.count==1?'primary-sector-2-name':'secondary-sector-2-name'}" /></label>
								<label class="label-content">${workDetail.getWorkSector2()}</label>
							</div>
						</c:if>
						
						<c:if test="${ not empty workDetail.getWorkSectorOther2() }">
						<div class="col-md-4 label-box">
							<label class="label-name"><liferay-ui:message key="${loop.count==1?'primary-sector-name-2-other':'secondary-sector-name-2-other'}" /></label>
							<label class="label-content">${workDetail.getWorkSectorOther2() }</label>
						</div>
						</c:if>
						
						
						
						<c:if test="${ not empty workDetail.getWorkSector3() }">
						 <div class="col-md-4 label-box">
								<label class="label-name"><liferay-ui:message key="${loop.count==1?'primary-sector-3-name':'secondary-sector-3-name'}" /></label>
								<label class="label-content">${workDetail.getWorkSector3()}</label>
							</div>
						</c:if>
						
						<c:if test="${ not empty workDetail.getWorkSectorOther3() }">
						<div class="col-md-4 label-box">
							<label class="label-name"><liferay-ui:message key="${loop.count==1?'primary-sector-3-name-other':'secondary-sector-3-name-other'}" /></label>
							<label class="label-content">${workDetail.getWorkSectorOther3()}</label>
						</div>
						</c:if>
						
						<c:if test="${ not empty workDetail.getWorkSectorLocation() }">
						<div class="col-md-4 label-box">
							<label class="label-name"><liferay-ui:message key="${loop.count==1?'region-location-primary-institution':'region-location-secondary-institution'}" /></label>
							<label class="label-content">${workDetail.getWorkSectorLocation() }</label>
						</div>
						</c:if>
						
						<c:if test="${ not empty workDetail.getDesignationId() }">
						<div class="col-md-4 label-box">
							<label class="label-name"><liferay-ui:message key="designation" /></label>
							<label class="label-content">${workDetail.getDesignationId()}</label>
						</div>
						</c:if>
						<c:if test="${ not empty workDetail.getDesignationOther() }">
						<div class="col-md-4 label-box">
							<label class="label-name"><liferay-ui:message key="designation-other" /></label>
							<label class="label-content">${workDetail.getDesignationOther() }</label>
						</div>
						</c:if>
						
						 <c:if test="${ not empty workDetail.getUploadFileName() }">
						<div class="col-lg-12 col-md-12">
							<div class="form-group">
								<label class="control-label label-file"><liferay-ui:message key="staff-id-document" /></label>
								<div class="omsb-card-caserport">
									<div class="leftbar">
										<h4 class="casereport-title">${workDetail.getUploadFileName() }</h4>
									</div>
									<div class="righbar">
										<a target="_blank" href="${workDetail.getDocumentUrl() }">
										<button class="btn view_btn"  title="<liferay-ui:message key="view" />">
											<img src="<%=themeDisplay.getPathThemeImages()%>/svg/view_icon.svg" alt=""><liferay-ui:message key="view" />
										</button>
										</a>
									</div>
								</div>
							</div>
						</div>
						 </c:if>
						</div>
						</div>
						</div>
				 </c:forEach>
						<!-- =============================== Work Details Ends ==================================================== -->
						
						
						<div class="reg_step4 mt-4"  id="reg_step4">
							<div class="omsb-page-top-info mb-4">
								<h3 class="reg-form-title"><liferay-ui:message key="role-service" /></h3>
								<div class="information"><button type="button" class="btn omsb-bg-red-button" id="add_role-service" onClick="openRoleServiceOpenAddModel(this)"  data-target="#add-role-service-confirm-modal" data-toggle="modal"><img src="../images/svg/plus_img.svg" alt=""> Add More</button></div>
							</div>
							
							<div class="d-none">
							 	<div class="w-50">
									<label class="control-label"><liferay-ui:message key="are-you-associated-with-omsb" /></label>
								</div>
								<div class="form-group yesorno">
									<div class="custom-control custom-radio ">
										<input type="radio" name="<portlet:namespace/>associated" class="custom-control-input" id="associated_yes" value="1" checked>
										<label class="custom-control-label m-0" for="associated_yes"><liferay-ui:message key="yes" /></label>
									</div>
									<div class="custom-control custom-radio ">
										<input type="radio" name="<portlet:namespace/>associated" class="custom-control-input" id="associated_no" value="0">
										<label class="custom-control-label m-0" for="associated_no"><liferay-ui:message key="no" /></label>
									</div>
								</div>
							</div>
								<div id="roleServiceList">
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
																<%-- <th><liferay-ui:message key="action" /></th> --%>
															</tr>
														</thead>
														<tbody>
														 <c:forEach var="userMetadata" items="${userMetadataItem.items}"> 
															<tr>
																<td>${userMetadata.roleName}</td>
																<td>${userMetadata.departmentId}</td>
																<td>${userMetadata.sectionId}</td>
																<%-- <td>${userMetadata.committeeId}</td> 
																 <td>${userMetadata.functionId}</td>  --%>
																<td>${userMetadata.programTypeName}</td>
																<td>${userMetadata.programName}</td>
																
																<%-- <td>
																	<c:if test="${not userMetadata.roleRequestedByAdmin}">
																		<button class="btn delete_btn" value="Delete" type="button" data-toggle="modal" data-target="#delete-role-service-modal" data-rowcount="addPopUpRow" onclick="setDeleteID('${userMetadata.id}')" ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/delete_icon.svg" style="cursor: default;"></button>
																		<button class="btn mx-2" value="view" type="button" data-toggle="modal" data-target="#add-role-service-confirm-modal" onclick="setRoleServiceID('${userMetadata.id}')" ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg"></button>
																	</c:if>
																</td> --%>
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
							<button class="btn omsb-bc-red-button" onClick="validateAndSaveFormData('save')" type="button" title="<liferay-ui:message key='save-at-this-stage' />"><liferay-ui:message key="Save" /></button>
							<button class="btn omsb-bg-red-button" id="registration-cancel" type="button" title="<liferay-ui:message key='cancel' />"><liferay-ui:message key="cancel" /></button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!--// Inner Wrapper Contents -->
	</section>
	<!---// End Main Content Section Here --->
</div>

<!-- Add Role Service Model Popup -->
		<div class="modal fade omsb-modal" id="add-role-service-confirm-modal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered w-50" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="add-role-details" /></h5>
						<button type="button" onClick="clearForm()"  class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						
				<portlet:actionURL name="<%=MVCCommands.ROLE_SERVICE_MVCACTION%>" var="roleServiceMVCActionURL"/>
					<form name="<portlet:namespace/>rnsFM" class="" id="rnsFM" action="${roleServiceMVCActionURL}" method="post">
						<div class="reg_step4 "  id="reg_step4">
							<div class="omsb-card m-0 p-0">
								<div class="omsb-page-top-info mb-4">
									<div class="pagetitle"><liferay-ui:message key="registration-role-service"/></div>
									<div class="information"><label class="reg-form-title"><%-- <liferay-ui:message key="step-four-of-four"/> --%></label></div>
								</div>
								
							</div>
							
							<div class="d-flex">
								<div class="w-50 role-section-1 d-none">
									<label class="control-label"><liferay-ui:message key="are-you-associated-with-omsb" /></label>
								</div>
								<div class="form-group  yesorno role-section-1 d-none">
									<div class="custom-control custom-radio ">
										<input type="radio" name="<portlet:namespace/>associated" class="custom-control-input" id="associated_yes" value="1" checked>
										<label class="custom-control-label m-0" for="associated_yes"><liferay-ui:message key="yes" /></label>
									</div>
									
									<div class="custom-control custom-radio ">
										<input type="radio" name="<portlet:namespace/>associated" class="custom-control-input" id="associated_no" value="0">
										<label class="custom-control-label m-0" for="associated_no"><liferay-ui:message key="no" /></label>
									</div>
								</div>
							</div>
									
							 <div class="omsb-card omsb-card-graybg omsb-noBorderRadius " id="associated_detail_area" >
										<div class="row ">
											<div class="col-lg-4 col-md-6">
												<div class="form-group">
													<label class="control-label "><liferay-ui:message key="role"/></label>
													<select  name="<portlet:namespace/>role_1" id="role_1" class="form-control">
														<option value=""><liferay-ui:message key="select" /></option>
															<c:forEach var="omsbRoles" items="${omsbRoleList}">
																<%-- <option value="${omsbRoles.roleId}" <c:if test="${userMetadata.roleId == omsbRoles.roleId}">selected="selected"</c:if>> --%>
																<option value="${omsbRoles.roleId}">
																	${omsbRoles.name}
																</option>
															</c:forEach>
													</select>
													<p id="errorContainer-role_1" class="error-container"></p>
												</div>
											</div>
											
											<div class="col-lg-4 col-md-6 d-none" id="roleOtherDiv_1">
													<div class="form-group">
														<label class="control-label required"><liferay-ui:message key="role-other" /></label>
														<input  type="text" name="<portlet:namespace/>roleOther_1" id="roleOther_1" class="form-control" value="${qualificationOther}" >
													</div>
													<p id="errorContainer-roleOther_1" class="error-container"></p>
											</div>
											<div class="col-lg-4 col-md-6">
												<div class="form-group">
													<label class="control-label required"><liferay-ui:message key="department" /></label>
													<select  name="<portlet:namespace/>department_1" id="department_1" class="form-control" onchange="validateField(this.id,'errorContainer-department_1','<liferay-ui:message key="please-select-department" />')">
														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="department" items="${departmentList}">
																<option value="${department.getKey()}"  <c:if test="${userMetadata.departmentId == department.getKey()}">selected="selected"</c:if>>
																	<liferay-ui:message key="${department.getName(themeDisplay.getLocale())}" />
																</option>
															</c:forEach>
													</select>
													<p id="errorContainer-department_1" class="error-container"></p>
												</div>
											</div>
											<div class="col-lg-4 col-md-6 d-none" id="departmentOtherDiv_1">
												<div class="form-group">
													<label class="control-label required"><liferay-ui:message key="department-other" /></label>
													<input  type="text" name="<portlet:namespace/>departmentOther_1" id="departmentOther_1" class="form-control" value="${qualificationOther}" >
												</div>
												<p id="errorContainer-departmentOther_1" class="error-container"></p>
											</div>
											<div class="col-lg-4 col-md-6">
												<div class="form-group">
													<label class="control-label required"><liferay-ui:message key="section" /></label>
													<select  name="<portlet:namespace/>section_1" id="section_1" class="form-control" onchange="validateField(this.id,'errorContainer-section_1','<liferay-ui:message key="please-select-section" />')">
														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="section" items="${sectionList}">
																<option value="${section.getKey()}"  <c:if test="${userMetadata.sectionId == section.getKey()}">selected="selected"</c:if>>
																	<liferay-ui:message key="${section.getName(themeDisplay.getLocale())}" />
																</option>
															</c:forEach>
													</select>
													<p id="errorContainer-section_1" class="error-container"></p>
												</div>
											</div>
											<div class="col-lg-4 col-md-6 d-none" id="sectionOtherDiv_1">
												<div class="form-group">
													<label class="control-label required"><liferay-ui:message key="section-other" /></label>
													<input  type="text" name="<portlet:namespace/>sectionOther_1" id="sectionOther_1" class="form-control" value="${qualificationOther}" >
												</div>
												<p id="errorContainer-sectionOther_1" class="error-container"></p>
											</div>
											<div class="col-lg-4 col-md-6">
												<div class="form-group">
													<label class="control-label required"><liferay-ui:message key="function" /></label>
													<select  name="<portlet:namespace/>function_1" id="function_1" class="form-control" onchange="validateField(this.id,'errorContainer-function_1','<liferay-ui:message key="please-select-function" />')">
														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="function" items="${functionList}">
																<option value="${function.getKey()}" <c:if test="${userMetadata.functionId == function.getKey()}">selected="selected"</c:if>>
																	<liferay-ui:message key="${function.getName(themeDisplay.getLocale())}" />
																</option>
															</c:forEach>
														
													</select>
													<p id="errorContainer-function_1" class="error-container"></p>
												</div>
											</div>
											<div class="col-lg-4 col-md-6 d-none" id="functionOtherDiv_1">
												<div class="form-group">
													<label class="control-label required"><liferay-ui:message key="function-other" /></label>
													<input  type="text" name="<portlet:namespace/>functionOther_1" id="functionOther_1" class="form-control" value="${qualificationOther}" >
												</div>
												<p id="errorContainer-functionOther_1" class="error-container"></p>
											</div>
											<div class="col-lg-4 col-md-6">
												<div class="form-group">
													<label class="control-label required"><liferay-ui:message key="program-type" /></label>
													<select  name="<portlet:namespace/>programtype_1" id="programtype_1" class="form-control" onchange="validateField(this.id,'errorContainer-programtype_1','<liferay-ui:message key="please-select-program-type" />')">

														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="programTypeMaster" items="${programTypeMasterList}">
																<%-- <option value="${programTypeMaster.programTypeMasterId}" <c:if test="${userMetadata.programTypeId == programTypeMaster.programTypeMasterId}">selected="selected"</c:if>> --%>
																<option value="${programTypeMaster.programTypeMasterId}" >
																	<liferay-ui:message key="${programTypeMaster.programTypeName}" />
																</option>
															</c:forEach>
													</select>
													<p id="errorContainer-programtype_1" class="error-container"></p>
												</div>

											</div>
											
												
											<div class="col-lg-4 col-md-6 d-none" id="programtypeOtherDiv_1">
												<div class="form-group">
													<label class="control-label required"><liferay-ui:message key="program-type-other" /></label>
													<input  type="text" name="<portlet:namespace/>programtypeOther_1" id="programtypeOther_1" class="form-control" value="${qualificationOther}" >
												</div>
												<p id="errorContainer-programtypeOther_1" class="error-container"></p>
											</div>
												
											<div class="col-lg-4 col-md-6">
												<div class="form-group">
													<label class="control-label required"><liferay-ui:message key="program" /> </label>
													<select  name="<portlet:namespace/>program_1" id="program_1" class="form-control" onchange="validateField(this.id,'errorContainer-program_1','<liferay-ui:message key="please-select-program" />')">

														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="program" items="${programList}">
																<%-- <option value="${program.programMasterId}" <c:if test="${userMetadata.programId == program.programMasterId}">selected="selected"</c:if>> --%>
																<%-- <option value="${program.programMasterId}"> --%>
																<option value="${program.programMasterId}">
																	<liferay-ui:message key="${program.programName}" />
																</option>
															</c:forEach>
													</select>
													<p id="errorContainer-program_1" class="error-container"></p>
												</div>
											</div>
											<div class="col-lg-4 col-md-6 d-none" id="programOtherDiv_1">
												<div class="form-group">
													<label class="control-label required"><liferay-ui:message key="program-other" /></label>
													<input  type="text" name="<portlet:namespace/>programOther_1" id="programOther_1" class="form-control" value="${qualificationOther}" >
												</div>
												<p id="errorContainer-programOther_1" class="error-container"></p>
											</div>
											
										</div>
									</div> 
									
							 <div class="d-none" id="registrant_detail_area" >
										<div class="d-flex">
											<div class="w-50 role-section-2 d-none">
												<label class="control-label"><liferay-ui:message key="are-you-registering-for-role-or-service" /></label>
											</div>
											<div class="form-group yesorno role-section-2 d-none">
												<div class="custom-control custom-radio ">
													<input type="radio" name="<portlet:namespace/>registering" class="custom-control-input" id="registering_yes" value="1" checked>
													<label class="custom-control-label m-0" for="registering_yes"><liferay-ui:message key="role" /></label>
												</div>
												
												<%-- <div class="custom-control custom-radio ">
													<input type="radio" name="<portlet:namespace/>registering" class="custom-control-input" id="registering_no" value="0">
													<label class="custom-control-label m-0" for="registering_no"><liferay-ui:message key="service" /></label>
												</div> --%>
											</div>
										</div>

									<div class="omsb-card omsb-card-graybg omsb-noBorderRadius " id="role_detail_area">
										<div class="row ">
											<div class="col-lg-4 col-md-6">
												<div class="form-group">
													<label class="control-label "><liferay-ui:message key="role" /></label>
													
													<select  name="<portlet:namespace/>role_2" id="role" class="form-control">
														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="omsbRoles" items="${omsbRoleList}">
																<%-- <option value="${omsbRoles.roleId}" <c:if test="${userMetadata.roleId == omsbRoles.roleId}">selected="selected"</c:if>> --%>
																<option value="${omsbRoles.roleId}">
																	${omsbRoles.name}
																</option>
															</c:forEach>
													</select>
													<p id="errorContainer-role_2" class="error-container"></p>
												</div>
											</div>
											<div class="col-lg-4 col-md-6 d-none" id="roleOtherDiv_2">
													<div class="form-group">
														<label class="control-label required"><liferay-ui:message key="role-other" /></label>
														<input  type="text" name="<portlet:namespace/>roleOther_2" id="roleOther_2" class="form-control" value="${qualificationOther}" >
													</div>
													<p id="errorContainer-roleOther_2" class="error-container"></p>
											</div>
											<div class="col-lg-4 col-md-6">
												<div class="form-group">
													<label class="control-label"><liferay-ui:message key="department" /></label>
													<select  name="<portlet:namespace/>department_2" id="department_2" class="form-control">
														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="department" items="${departmentList}">
																<%-- <option value="${department.getKey()}" <c:if test="${userMetadata.departmentId == department.getKey()}">selected="selected"</c:if>> --%>
																<option value="${department.getKey()}">
																	<liferay-ui:message key="${department.getName(themeDisplay.getLocale())}" />
																</option>
															</c:forEach>
													</select>
													<p id="errorContainer-department_2" class="error-container"></p>
												</div>
											</div>
											<div class="col-lg-4 col-md-6 d-none" id="departmentOtherDiv_2">
													<div class="form-group">
														<label class="control-label required"><liferay-ui:message key="department-other" /></label>
														<input  type="text" name="<portlet:namespace/>departmentOther_2" id="departmentOther_2" class="form-control" value="${qualificationOther}" >
													</div>
													<p id="errorContainer-departmentOther_2" class="error-container"></p>
											</div>
											<div class="col-lg-4 col-md-6">
												<div class="form-group">
													<label class="control-label"><liferay-ui:message key="section" /></label>
													<select  name="<portlet:namespace/>section_2" id="section_2" class="form-control">
														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="section" items="${sectionList}">
																<%-- <option value="${section.getKey()}" <c:if test="${userMetadata.sectionId == section.getKey()}">selected="selected"</c:if>> --%>
																<option value="${section.getKey()}">
																	<liferay-ui:message key="${section.getName(themeDisplay.getLocale())}" />
																</option>
															</c:forEach>
													</select>
													<p id="errorContainer-section_2" class="error-container"></p>
												</div>
											</div>
											<div class="col-lg-4 col-md-6 d-none" id="sectionOtherDiv_2">
													<div class="form-group">
														<label class="control-label required"><liferay-ui:message key="section-other" /></label>
														<input  type="text" name="<portlet:namespace/>sectionOther_2" id="sectionOther_2" class="form-control" value="${qualificationOther}" >
													</div>
													<p id="errorContainer-sectionOther_2" class="error-container"></p>
											</div>
											<div class="col-lg-4 col-md-6">
												<div class="form-group">
													<label class="control-label"><liferay-ui:message key="Committee" /></label>
													<select  name="<portlet:namespace/>committe_2" id="committe" class="form-control">
														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="committe" items="${committeList}">
																<%-- <option value="${committe.getKey()}"  <c:if test="${userMetadata.committeeId == committe.getKey()}">selected="selected"</c:if>> --%>
																<option value="${committe.getKey()}"  >
																	<liferay-ui:message key="${committe.getName(themeDisplay.getLocale())}" />
																</option>
															</c:forEach>
													</select>
													<p id="errorContainer-committe_2" class="error-container"></p>
												</div>
											</div>
											<div class="col-lg-4 col-md-6 d-none" id="committeOtherDiv_2">
													<div class="form-group">
														<label class="control-label required"><liferay-ui:message key="committe-other" /></label>
														<input  type="text" name="<portlet:namespace/>committeOther_2" id="committeOther_2" class="form-control" value="${qualificationOther}" >
													</div>
													<p id="errorContainer-committeOther_2" class="error-container"></p>
											</div>
											<div class="col-lg-4 col-md-6">
												<div class="form-group">
													<label class="control-label">Function</label>
													<select  name="<portlet:namespace/>function_2" id="function_2" class="form-control">
														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="function" items="${functionList}">
																<%-- <option value="${function.getKey()}" <c:if test="${userMetadata.functionId == function.getKey()}">selected="selected"</c:if>> --%>
																<option value="${function.getKey()}">
																	<liferay-ui:message key="${function.getName(themeDisplay.getLocale())}" />
																</option>
															</c:forEach>
													</select>
													<p id="errorContainer-function_2" class="error-container"></p>
												</div>
											</div>
											<div class="col-lg-4 col-md-6 d-none" id="functionOtherDiv_2">
													<div class="form-group">
														<label class="control-label required"><liferay-ui:message key="function-other" /></label>
														<input  type="text" name="<portlet:namespace/>functionOther_2" id="functionOther_2" class="form-control" value="${functionOther}" >
													</div>
													<p id="errorContainer-functionOther_2" class="error-container"></p>
											</div>
											<div class="col-lg-4 col-md-6">
												<div class="form-group">
													<label class="control-label"><liferay-ui:message key="program-type" /></label>
													<select  name="<portlet:namespace/>programtype_2" id="programtype_2" class="form-control">
														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="programTypeMaster" items="${programTypeMasterList}">
																<%-- <option value="${programTypeMaster.programTypeMasterId}" <c:if test="${userMetadata.programTypeId == programTypeMaster.programTypeMasterId}">selected="selected"</c:if>> --%>
																<option value="${programTypeMaster.programTypeMasterId}">
																	<liferay-ui:message key="${programTypeMaster.programTypeName}" />
																</option>
															</c:forEach>
													</select>
													<p id="errorContainer-programtype_2" class="error-container"></p>
												</div>
											</div>
											<div class="col-lg-4 col-md-6 d-none" id="programtypeOtherDiv_2">
													<div class="form-group">
														<label class="control-label required"><liferay-ui:message key="programtype-other" /></label>
														<input  type="text" name="<portlet:namespace/>programtypeOther_2" id="programtypeOther_2" class="form-control" value="${programtypeOther}" >
													</div>
													<p id="errorContainer-programtypeOther_2" class="error-container"></p>
											</div>
											<div class="col-lg-4 col-md-6 ">
												<div class="form-group">
													<label class="control-label"><liferay-ui:message key="program" /> </label>
													<select  name="<portlet:namespace/>program_2" id="program_2" class="form-control">
														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="program" items="${programList}">
																<%-- <option value="${program.programMasterId}" <c:if test="${userMetadata.programId == program.programMasterId}">selected="selected"</c:if>> --%>
																<option value="${program.programMasterId}" >
																	${program.programName}
																</option>
															</c:forEach>
													</select>
													<p id="errorContainer-program_2" class="error-container"></p>
												</div>
											</div>
											<div class="col-lg-4 col-md-6 d-none" id="programOtherDiv_2">
												<div class="form-group">
													<label class="control-label required"><liferay-ui:message key="program-other" /></label>
													<input  type="text" name="<portlet:namespace/>programOther_2" id="programtypeOther_2" class="form-control" value="${programtypeOther}" >
												</div>
												<p id="errorContainer-programtypeOther_2" class="error-container"></p>
											</div>									
										</div>
									</div>
									 
								</div> 
							</div>
								
									 <div class="bottom-backbtn-wrap">
										<button class="btn omsb-bc-red-button"  onClick="saveRoleService()"  type="button" title="<liferay-ui:message key='save-update' />"><liferay-ui:message key="save-update" /></button> 
										<%-- <button class="btn omsb-bc-red-button" onClick="validateAndSaveFormData('next')" type="button" title="<liferay-ui:message key='next' />"><liferay-ui:message key='next' /></button> --%>
										<button id="role-service-back-button" class="go-pervious btn omsb-btn omsb-bg-red-button " type="button" title="<liferay-ui:message key='back' />" data-pervious="reg_step3"><i class="fi fi-sr-arrow-left"></i> <liferay-ui:message key='back' /></button>
									</div> 
			


							
									<input type="hidden" name="<portlet:namespace/>isNext" id="isNext" value="false">
									<input id="lrUserId" type="hidden" name="<portlet:namespace/>lrUserId" value="${lrUserId}"/>
									<input id="txtIndex" type="hidden" name="<portlet:namespace/>index" value="1"/>
									<input id="isAssosiated" type="hidden" name="<portlet:namespace/>assosiated" value="true"/>
									<input type="hidden" name="id" id="id">
									<input type="hidden" value="${personId}" name="<portlet:namespace/>personId" id="personId"/>
									<input type="hidden" value="" name="deleteID" id="deleteID"/>
							</form>
					</div>
				</div>
			</div>
		</div>
		<!-- Add Role Service Model Popup -->
		
		<!--delete popup for role  service -->
		<div class="modal fade omsb-modal" id="delete-role-service-modal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered w-50" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="delete-confirmation" /></h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form name="uploadresultpopupform" id="uploadresultpopupform" method="post" ></form>
						<div class="omsb-card omsb-card-graybg row">
							<div>
								<liferay-ui:message key="do-you-want-to-delete-this-record"/>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button class="btn omsb-bc-red-button" type="button" onclick="deleteRoleServiceSection()" title="<liferay-ui:message key='ok'/>" ><liferay-ui:message key="yes" /></button>
						<button type="button" class="btn omsb-btn omsb-bg-red-button"
							data-dismiss="modal" id="uploadcancel"><liferay-ui:message key="no" /></button>
					</div>
				</div>
			</div>
		</div>
		<!--delete popup role  service -->
<portlet:resourceURL id="<%=MVCCommands.VERIFY_USERNAME%>" var="verifyUsernameURL" />
<portlet:resourceURL id="<%=MVCCommands.SEND_OTP%>" var="sendOTPURL" />



<portlet:resourceURL id="<%=MVCCommands.SECTION_DEPARTMENT_MVC_RESOURCE%>" var="sectionDepartmentURL" />		
<portlet:resourceURL id="<%=MVCCommands.FUNCTION_SECTION_COMMITTEE_MVC_RESOURCE%>" var="functionSectioncommitteURL" />		
<portlet:resourceURL id="<%=MVCCommands.PROGRAM_TYPE_MVC_RESOURCE%>" var="programTypeURL" />


<portlet:resourceURL id="<%=MVCCommands.SAVE_REGISTRATION_EDUCATION_DETAILS_SR%>" var="saveEducationDetailsURL" />
<portlet:resourceURL id="<%=MVCCommands.GET_REGISTRATION_EDUCATION_DETAILS_SR%>" var="getEducationDetailsURL" />
		<portlet:resourceURL id="<%=MVCCommands.DELETE_REGISTRATION_EDUCATION_DETAILS_SR%>" var="deleteEducationDetailsURL" />

<input id="userMetadataId" type="hidden" name="<portlet:namespace/>userMetadataId" value="${userMetadata.id}"/>
<input id="isAssociated" type="hidden" name="<portlet:namespace/>isAssociated" value="${userMetadata.associated}"/>
<input id="isregisteringForRole" type="hidden" name="<portlet:namespace/>isAssociated" value="${userMetadata.registeringForRole}"/>


<portlet:resourceURL id="<%=MVCCommands.GET_WORKSECTOR_BY_WORKSECTOR_TYPE%>" var="getWorkSectorByWorkSectorType" />
<portlet:resourceURL id="<%=MVCCommands.GET_WORKSECTOR_BY_PARENT_WORK_SECTOR%>" var="getWorkSectorByParentWorkSector" />


<!-- Role Service URL'S -->
<portlet:resourceURL id="<%=MVCCommands.SAVE_REGISTRATION_ROLE_SERVICE_SR%>" var="saveRoleServiceURL" />	
<portlet:resourceURL id="<%=MVCCommands.DELETE_REGISTRATION_ROLE_SERVICE_SR%>" var="deleteRoleServiceURL" />
<portlet:resourceURL id="<%=MVCCommands.GET_REGISTRATION_ROLE_SERVICE_SR%>" var="getRoleServiceURL" />
<!-- Role Service URL'S -->
	
<script type="text/javascript">

 /* var phone1 = document.querySelector("#mobileNumber");
var hiddenCountryInput = document.querySelector("#hiddenCountryCode");
var hiddenCountryIsoCode = document.querySelector("#hiddenCountryIsoCode");
var itl = '';

console.log("hiddenCountryIsoCode ::::",hiddenCountryIsoCode.value);

var initialCountryVal="om";
if(hiddenCountryIsoCode.value!=''){
	console.log("inside in ::::;");
	initialCountryVal=hiddenCountryIsoCode.value;
}
setTimeout(function() {
	itl = window.intlTelInput(phone1,({initialCountry:initialCountryVal, separateDialCode: "true", showFlags:"false"}));
	var selectedCountry = itl.getSelectedCountryData();
	hiddenCountryInput.value = selectedCountry.dialCode;
	hiddenCountryIsoCode.value = selectedCountry.iso2;
	
}, 100);

phone1.addEventListener("countrychange",function() {
	var selectedCountry = itl.getSelectedCountryData();
	console.log("selectedCountry :::",selectedCountry);
	hiddenCountryInput.value = selectedCountry.dialCode;
	hiddenCountryIsoCode.value = selectedCountry.iso2;
}); 
 */
 
 



var index=1;
$(document).ready(function() {
	/* if ( window.history.replaceState ) {
        window.history.replaceState( null, null, window.location.href );
    } */
    
    $("#department_1").select2();
	 $("#role_1").select2();
	 $("#section_1").select2();
	 $("#function_1").select2();
	 $("#programtype_1").select2();
	 $("#program_1").select2();
	 $("#role").select2();
	 $("#department_2").select2();
	 $("#section_2").select2();
	 $("#committe").select2();
	 $("#function_2").select2();
	 $("#programtype_2").select2();
	 $("#program_2").select2();
	 $("#service").select2();
	 $("#department_2").select2();
	 $("#section_2").select2();
	 
    $("#registration-cancel").click(function(){
    	console.log('${themeDisplay.getPortalURL()}'+'/group/guest/dashboard');
		window.location.href='${themeDisplay.getPortalURL()}'+'/group/guest/dashboard';
	});
	
	const minDate = new Date();
	minDate.setDate(minDate.getDate() + 1);
	/* $('#passportExpiryDate').datepicker({
		format: "dd-mm-yyyy",
		orientation: "bottom auto",
		autoclose: true,
		startDate: minDate
	}).on('change', function(){
		let ds = $(this).val();
		if(ds.length){
			let [day, month, year] = ds.split('-')
			const dateObj = new Date(+year, +month - 1, +day)
			if (dateObj < new Date()) {
		    	$(this).val('');
		    }
		}
		$('.datepicker').hide();
	}); */
	
 	$("#role_1").select2();
    $("#department_1").select2();
    $("#section_1").select2();
    $("#function_1").select2();
    $("#programtype_1").select2();
    $("#program_1").select2();
    $("#role").select2();
    $("#department_2").select2();
    $("#section_2").select2();
    $("#committe").select2();
    $("#function_2").select2();
    $("#programtype_2").select2();
    $("#program_2").select2();
	
	
});

function showOtherField(id,errorId,errorMessage){
	 var substring=substring=id;
	
	 let selectedValue= $("#"+id).find('option:selected').val();
	 if(selectedValue.trim() === 'other'){
		 $('#'+id+other).removeClass('d-none');
	 }
	 else{
		 $('#'+id+other).addClass('d-none');
		}
	 validateField(id,errorId,errorMessage);
	
	 
}
var isEditable = false;
$( document ).ready(function() {
 //var data=${workSectors};
  console.log( "ready!" );
  //console.log(data);
  //var value1=  $("#worksector_1").val();
  //var worksectorother1=  $("#worksectorother_1").val();
  
	/* if(worksectorother1.length>0){
	  console.log("inside other value is greater");
	  value1="Other";
	  $("#div-work-other_1").removeClass("d-none");
  	} */
	 /* else{
		 $("#worksectorother_1").val('');
			$("#div-work-other_1").addClass("d-none");
	  } */
  
  //var value2=  $("#worksector_2").val();
  //var worksectorother2=  $("#worksectorother_2").val();
  
  /* if(worksectorother2.length>0){
	  console.log("inside other value is greater");
	  value2="Other";
	  $("#div-work-other_2").removeClass("d-none");
  }
  else{
	  $("#worksectorother_2").val('');
		$("#div-work-other_2").addClass("d-none");
  } */
  
  /* console.log("worksectorother2 :::::",worksectorother2);
	    $("#worksector_1").comboTree({
		source : data,
		isMultiple: false,
		collapse:true,
		selected: [value1]
	}); 
    $("#worksector_2").comboTree({
		source : data,
		isMultiple: false,
		collapse:true,
		selected : [value2]
	}); */
    
    
    
var designation_1=$("#designations_1").val();
var designation_2=$("#designations_2").val();
if(designation_1=="other"){
	 $('#designationotherdiv_1').removeClass('d-none');
}
else{
	  $("#designationother_1").val('');
	 $('#designationotherdiv_1').addClass('d-none');
}
if(designation_2=="other"){
	 $('#designationotherdiv_2').removeClass('d-none');
}
else{
	$("#designationother_2").val('');
	 $('#designationotherdiv_2').addClass('d-none');
}
});

function validateAndSaveFormData(button) {
	
	var errorMessages = [];	
	
	

	
/* ----------------------employment detail field validation end------------------------- */	
	
//For role service 
	
	/* var isOMSBAssociated=false;
	 var roleRegistration=false;
	 if(document.getElementById('associated_yes').checked) {
		 isOMSBAssociated=true;
		}else if(document.getElementById('associated_no').checked) {
			isOMSBAssociated=false;
		}
	 
	 	console.log("isOMSBAssociated ::::",isOMSBAssociated);
	 	if(isOMSBAssociated){
	 		var role_1 = document.getElementById("role_1").value;
			if (!role_1) {
				errorMessages.push("<liferay-ui:message key='please-select-role' />");
				document.getElementById("errorContainer-role_1").textContent = "<liferay-ui:message key='please-select-role' />";
			} else {
				document.getElementById("errorContainer-role_1").textContent = "";
			}
	 		
			var department_1 = document.getElementById("department_1").value;
			if (!department_1) {
				errorMessages.push("<liferay-ui:message key='please-select-department' />");
				document.getElementById("errorContainer-department_1").textContent = "<liferay-ui:message key='please-select-department' />";
			} else {
				document.getElementById("errorContainer-department_1").textContent = "";
			}
			
			
			var section_1 = document.getElementById("section_1").value;
			if (!section_1) {
				errorMessages.push("<liferay-ui:message key='please-select-section' />");
				document.getElementById("errorContainer-section_1").textContent = "<liferay-ui:message key='please-select-section' />";
			} else {
				document.getElementById("errorContainer-section_1").textContent = "";
			}
			
			
			var function_1 = document.getElementById("function_1").value;
			if (!function_1) {
				errorMessages.push("<liferay-ui:message key='please-select-function' />");
				document.getElementById("errorContainer-function_1").textContent = "<liferay-ui:message key='please-select-function' />";
			} else {
				document.getElementById("errorContainer-function_1").textContent = "";
			}
			
			
			var programtype_1 = document.getElementById("programtype_1").value;
			if (!programtype_1) {
				errorMessages.push("<liferay-ui:message key='please-select-program-type' />");
				document.getElementById("errorContainer-programtype_1").textContent = "<liferay-ui:message key='please-select-program-type' />";
			} else {
				document.getElementById("errorContainer-programtype_1").textContent = "";
			}
			
			var program_1 = document.getElementById("program_1").value;
			if (!program_1) {
				errorMessages.push("<liferay-ui:message key='please-select-program' />");
				document.getElementById("errorContainer-program_1").textContent = "<liferay-ui:message key='please-select-program' />";
			} else {
				document.getElementById("errorContainer-program_1").textContent = "";
			}
	 		
	 	}else{
	 		var roleRegistration=false;
	 		
		 	if(document.getElementById('registering_yes').checked) {
			roleRegistration=true;
			}else if(document.getElementById('registering_no').checked) {
				roleRegistration=false;
			}
	 		
		 	
		 	if(roleRegistration){
		 		var role = document.getElementById("role").value;
				if (!role) {
					errorMessages.push("<liferay-ui:message key='please-select-role' />");
					document.getElementById("errorContainer-role_2").textContent = "<liferay-ui:message key='please-select-role' />";
				} else {
					document.getElementById("errorContainer-role_2").textContent = "";
				}
		 		
				var department_2 = document.getElementById("department_2").value;
				if (!department_2) {
					errorMessages.push("<liferay-ui:message key='please-select-department' />");
					document.getElementById("errorContainer-department_2").textContent = "<liferay-ui:message key='please-select-department' />";
				} else {
					document.getElementById("errorContainer-department_2").textContent = "";
				}
				
				
				var section_2 = document.getElementById("section_2").value;
				if (!section_2) {
					errorMessages.push("<liferay-ui:message key='please-select-section' />");
					document.getElementById("errorContainer-section_2").textContent = "<liferay-ui:message key='please-select-section' />";
				} else {
					document.getElementById("errorContainer-section_2").textContent = "";
				}
				
				
				var committe = document.getElementById("committe").value;
				if (!committe) {
					errorMessages.push("<liferay-ui:message key='please-select-committe' />");
					document.getElementById("errorContainer-committe_2").textContent = "<liferay-ui:message key='please-select-committe' />";
				} else {
					document.getElementById("errorContainer-committe_2").textContent = "";
				}
				
				
				var function_2 = document.getElementById("function_2").value;
				if (!function_2) {
					errorMessages.push("<liferay-ui:message key='please-select-function' />");
					document.getElementById("errorContainer-function_2").textContent = "<liferay-ui:message key='please-select-function' />";
				} else {
					document.getElementById("errorContainer-function_2").textContent = "";
				}
				
				
				var programtype_2 = document.getElementById("programtype_2").value;
				if (!programtype_2) {
					errorMessages.push("<liferay-ui:message key='please-select-program-type' />");
					document.getElementById("errorContainer-programtype_2").textContent = "<liferay-ui:message key='please-select-program-type' />";
				} else {
					document.getElementById("errorContainer-programtype_2").textContent = "";
				}
				
				var program_2 = document.getElementById("program_2").value;
				if (!program_2) {
					errorMessages.push("<liferay-ui:message key='please-select-program' />");
					document.getElementById("errorContainer-program_2").textContent = "<liferay-ui:message key='please-select-program' />";
				} else {
					document.getElementById("errorContainer-program_2").textContent = "";
				}
				
		 		
		 	}else{
		 		var service = document.getElementById("service").value;
				if (!service) {
					errorMessages.push("<liferay-ui:message key='please-select-service' />");
					document.getElementById("errorContainer-service").textContent = "<liferay-ui:message key='please-select-service' />";
				} else {
					document.getElementById("errorContainer-service").textContent = "";
				}
		 	}
	 		
	 	}
	 */
	
	

	console.log(errorMessages);
	console.log("------------------tt ----");
	
	if (errorMessages.length > 0) {
		event.preventDefault();
	} else {
		console.log("*inside else :::");
		//For Educational Details element counter
		elementCount();
		document.getElementById("rdFM").submit();
	}
}



//Educational Detail 
function elementCount(){
	$('.element').each(function() {
    	 var id = $(this).attr('id');
    	 console.log("id ::::::::",id);
    	var split_id = id.split("_");
      console.log("split_id :::",split_id);
      var index = Number(split_id[2]);
      console.log("index :::",index);
      rowIndexer.push(index);
    });
	console.log("rowIndexer :::::",rowIndexer);
	$('#counter').val(rowIndexer.join(","));
	
	console.log("rowIndexer :::::",$('#counter').val());
}



var list = ${qualificationArray};
var institutionList=${institutionList};
//var customCountries=${countryArray};
var rowIndexer=[];
var imagePath=$('#imagePath').val();
var qualificationHtml='';
var institutionHtml='';
var countryHtml='';

$(document).on('change','.custom-file-input', function () {
	var fileName = $(this).val().split("\\").pop();
	
	console.log("fileName ::::",fileName);
	$(this).siblings(".custom-file-label").html(`<span>\${fileName}</span>`);
});


/* $('input[name="<portlet:namespace/>associated"]').change(function() {
	var passoc = $("input[name='<portlet:namespace/>associated']:checked").val();
	console.log("passoc"+passoc);
	if(passoc == 0 || passoc == "0" ) {
		$("#txtIndex").val("2");
		console.log("card");
		$('#registrant_detail_area').removeClass("d-none");
		$('#associated_detail_area').addClass("d-none");
	}
	else{
		console.log("mobile");
		$("#txtIndex").val("1");
		$('#associated_detail_area').removeClass("d-none");
		$('#registrant_detail_area').addClass("d-none");
	}
});

$('input[name="<portlet:namespace/>registering"]').change(function() {
	var preg = $("input[name='<portlet:namespace/>registering']:checked").val();
	console.log("preg"+preg);
	if(preg == 0 || preg == "0" ) {
		$('#service_detail_area').removeClass("d-none");
		$('#role_detail_area').addClass("d-none");
	}
	else{
		$("#txtIndex").val("2");
		$('#role_detail_area').removeClass("d-none");
		$('#service_detail_area').addClass("d-none");
	}
}); */


// Education Detail
$(document).ready(function() {
			$(function() {
			    $('input:radio[name="<portlet:namespace/>employed"]').change(function() {
			    	 if ($(this).val() == '1') {
				            $("#work-detail-main").removeClass("d-none");
				        } else {
				            $("#work-detail-main").addClass('d-none');
				        }
			    });
			});
			
			/* function showDesignationOther(id,errorId,errorMessage){
				console.log(id);
				 var substring=id.substr ( id.indexOf ( '_' ) + 1 );
				
				 let selectedDesignation= $("#"+id).find('option:selected').val();
				 console.log("after substring :"+selectedDesignation);
				 if(selectedDesignation.trim() === 'other'){
					 console.log("inside if condition +++++ ");
					 $('#designationotherdiv_'+substring).removeClass('d-none');
				 }
				 else{
					 console.log("inside else condtion ++++ ");
					 $('#designationotherdiv_'+substring).addClass('d-none');
					}
			if(id=="designations_1"){
				console.log("inside if condition");
				 validateField(id,errorId,errorMessage);
			}
				 
			} */
			
			  $(document).on('change','#worksector_1',function(){
					var workSectorValue=$(this).val();
					if(workSectorValue == 'Other'){
					      $("#div-work-other_1").removeClass("d-none");
					}else{
						console.log("workSectorValue",workSectorValue);
						$("#worksectorother_1").val('');
						$("#div-work-other_1").addClass("d-none");
					}
					
				});
			
			   $(document).on('change','#worksector_2',function(){
					var workSectorValue=$(this).val();
					if(workSectorValue == 'Other'){
					      $("#div-work-other_2").removeClass("d-none");
					}else{
						console.log("workSectorValue",workSectorValue);
						$("#worksectorother_2").val('');
						$("#div-work-other_2").addClass("d-none");
					}
					
				});
			
			//on Chnage function for work sector to display other
			$(document).on('change','.worksector_',function(){
				console.log("Change called::::::");
				var workSectorValue=$(this).val();
				var id = $(this).attr('id');
				 var split_id = id.split("_");
				console.log("split_id ::::",split_id);
				var index = Number(split_id[1]);
			      console.log("index :::",index);
				if(workSectorValue == 'Other'){
				      $("#div-work-other_"+index).removeClass("d-none");
				}else{
					console.log("workSectorValue",workSectorValue);
					$("#worksectorother_"+index).val('');
					$("#div-work-other_"+index).addClass("d-none");
				}
				
			});
		});


function showDesignationOther(id,errorId,errorMessage){
	console.log(id);
	 var substring=substring=id.substr ( id.indexOf ( '_' ) + 1 );
	
	 let selectedDesignation= $("#"+id).find('option:selected').val();
	 console.log("after substring :"+selectedDesignation);
	 if(selectedDesignation.trim() === 'other'){
		 console.log("inside if condition +++++ ");
		 $('#designationotherdiv_'+substring).removeClass('d-none');
	 }
	 else{
		 console.log("inside else condtion ++++ ");
		 $('#designationotherdiv_'+substring).addClass('d-none');
		}
	// }
	 validateField(id,errorId,errorMessage);
	 
}


//Role Service 

/* function setSection(departmentId,sectionId){
		var inputDepartmentId=$("#"+departmentId).val();
		console.log("inputDepartmentId ::::",inputDepartmentId);
		
		
		$.ajax({
			url: '${sectionDepartmentURL}',
			async : false,
			dataType:"json",
			data : {
				<portlet:namespace />departmentId : inputDepartmentId,
			},
			type : 'POST',
			success : function(data) {
				console.log("success :::::",data);
				console.log("success :::::",data.length);
				 var response=data;
				 console.log("response :::::",response.length);
				var sectionData="<option value=''><liferay-ui:message key='select'/></option>";
				
				$.each(response, function( index, value ) {
					sectionData=sectionData+"<option value='"+value.key+"'><liferay-ui:message key='"+value.name+"'/></option>";
			    });
				$("#"+sectionId).html("").append(sectionData);
			},
		})
	}
		
		
	$(document).on('change','#department_1',function(){
		console.log("change");	
		var departmentId=$('#department_1').val();
		console.log("departmentId :::::::::::",departmentId);
			setSection("department_1","section_1");
		
	});
	
	
	$(document).on('change','#department_2',function(){
		console.log("change");	
		var departmentId=$('#department_2').val();
		console.log("departmentId :::::::::::",departmentId);
			setSection("department_2","section_2");
	});
	

	$(document).on('change','#section_1',function(){
		var sectionId=$('#section_1').val();
		console.log("sectionId :::::::::::",sectionId);
		setFunctionCommitee("section_1","function_1","");
	});
	
	$(document).on('change','#section_2',function(){
		var sectionId=$('#section_2').val();
		console.log("sectionId :::::::::::",sectionId);
		setFunctionCommitee("section_2","function_2","committe");
	});
			
			
	function setFunctionCommitee(sectionId,functionId,committeId){
		var inputsectionId=$("#"+sectionId).val();
		$.ajax({
			url: '${functionSectioncommitteURL}',
			dataType:"json",
			async : false,
			data : {
				<portlet:namespace />sectionId : inputsectionId,
			},
			type : 'POST',
			success : function(data) {
				console.log("success :::::");
				var response=data;
				var functionData="<option value=''><liferay-ui:message key='select'/></option>";
				$.each(response.functionObj, function( index, value ) {
					functionData=functionData+"<option value='"+value.key+"'><liferay-ui:message key='"+value.name+"'/></option>";
			    });
				$("#"+functionId).html("").append(functionData);
				
				if(committeId !== null && committeId !== ''){
					var committeData="<option value=''><liferay-ui:message key='select'/></option>";
					$.each(response.committeObj, function( index, value ) {
						committeData=committeData+"<option value='"+value.key+"'><liferay-ui:message key='"+value.name+"'/></option>";
				    });
					$("#"+committeId).html("").append(functionData);
				}
			},
		})
	}
			
			
	$(document).on('change','#programtype_1',function(){
		var programTypeId=$('#programtype_1').val();
		console.log("programTypeId ::::::::",programTypeId);
		setProgram("programtype_1","program_1");
	});
	
	
	$(document).on('change','#programtype_2',function(){
		var programTypeId=$('#programtype_2').val();
		console.log("programTypeId ::::::::",programTypeId);
		setProgram("programtype_2","program_2");
	});
			
	function setProgram(programTypeId,programId){
		var inputprogramTypeId=$("#"+programTypeId).val();
		$.ajax({
			url: '${programTypeURL}',
			dataType:"json",
			async : false,
			data : {
				<portlet:namespace />programTypeId : inputprogramTypeId,
			},
			type : 'POST',
			success : function(data) {
				console.log("success :::::",data);
				 console.log("success :::::",data.length);
				 var response=data;
				 console.log("response :::::",response.length);
				var programData="<option value=''><liferay-ui:message key='select'/></option>";
				
				$.each(response, function( index, value ) {
					programData=programData+"<option value='"+value.id+"'><liferay-ui:message key='"+value.name+"'/></option>";
			    });
				$("#"+programId).html("").append(programData);
			},
		})
	} */


	
function validateField(elementId,errorId,error){
	var fieldValue=$("#"+elementId).val();
	console.log(elementId+" ---  "+errorId+ " --- "+error);
	if(elementId.indexOf("_") !== -1){
		var divId=elementId.substring(elementId.indexOf("_") + 1);
		errorId=errorId.substring(0,errorId.indexOf("_")+1)+divId;
		console.log(errorId);
	}
	if(fieldValue==''){
		$("#"+errorId).text(error);
	}
	else{
		$("#"+errorId).html("");
	}
}

function openDeleteModal(id){
	console.log("id :: "+id);
	$("#delete-confirm-modal").data("id",id);
}
function openEduOpenDeleteModal(id){
	console.log("id :: "+id);
	$("#delete-education-confirm-modal").data("id",id);
}




$('#work-detail-list').DataTable({	
    "bLengthChange": false,	
    "bFilter": false,
    "ordering": false
});




function setDeleteID(id){
	document.getElementById("deleteID").value = id;
}



function setEditID(id){
	if(id){
		document.getElementById("qualification").value = '';
		document.getElementById("institution").value = '';
		document.getElementById("country").value = '';
		//document.getElementById("gpa").value = '';
		document.getElementById("year").value = '';
		document.getElementById("id").value = '';
		document.getElementById("qualificationdoclbl").innerHTML = '';
		$("#view-div").removeClass("d-none");
		$.ajax({
			url: '${getEducationDetailsURL}',
			async : false,
			data : {
				<portlet:namespace />id : id,
			},
			type : 'POST',
			success : function(data) {
				const response = JSON.parse(data);
				if(response.isValid){
					const educationDetails = JSON.parse(response.educationDetail);
					console.log(educationDetails);
					console.log("line 2442");
					console.log(educationDetails.documentInfo.documentURL);
					document.getElementById("qualification").value = educationDetails.qualificationAttained;
					document.getElementById("institution").value = educationDetails.issuingAuthorityName;
					document.getElementById("country").value = educationDetails.issuingAuthorityCountryId;
					//document.getElementById("gpa").value = educationDetails.gpa;
					document.getElementById("year").value = educationDetails.yearOfGraduation;
					document.getElementById("id").value = educationDetails.id;
					document.getElementById("view-file").setAttribute("href",educationDetails.documentInfo.documentURL);
					if(educationDetails!=null){
						if(educationDetails.documentInfo!=null){
							if(educationDetails.documentInfo.dFFileName!=null){
								document.getElementById("qualificationdoclbl").innerHTML = educationDetails.documentInfo.dFFileName;
								isEdit=true;
							}
						}
					}
				}
			}
		})
	}
}



let isEdit = false;



function clearForm(){
	document.getElementById("qualification").value = '';
	document.getElementById("institution").value = '';
	document.getElementById("country").value = '';
	//document.getElementById("gpa").value = '';
	document.getElementById("year").value = '';
	document.getElementById("id").value = '';
	document.getElementById("qualificationdoc").value='';
	
	document.getElementById("errorContainer-qualification").textContent = "";
	document.getElementById("errorContainer-institution").textContent = "";
	document.getElementById("errorContainer-country").textContent = "";
	//document.getElementById("errorContainer-gpa").textContent = "";
	document.getElementById("errorContainer-year-of-graducation").textContent = "";
	document.getElementById("errorContainer-qualification-document").textContent = "";
	isEdit=false;
}

function clearEmploymentFormFields(){
	document.getElementById("workSectorType_1").value = '';
	document.getElementById("workSectorType_2").value = '';
	document.getElementById("worksector_1").value = '';
	document.getElementById("worksector_2").value = '';
	document.getElementById("worksectorother_1").value = '';
	document.getElementById("worksectorother_2").value = '';
	document.getElementById("wilayats_1").value = '';
	document.getElementById("wilayats_2").value = '';
	document.getElementById("designations_1").value = '';
	document.getElementById("designations_2").value = '';
	document.getElementById("uploadFile_1").value = '';
	document.getElementById("uploadFile_2").value='';
	
	document.getElementById("work-sector-type-error_1").textContent = "";
	document.getElementById("work-sector-type-error_2").textContent = "";
	document.getElementById("work-sector-error_1").textContent = "";
	document.getElementById("work-sector-error_2").textContent = "";
	document.getElementById("location-error_1").textContent = "";
	document.getElementById("location-error_2").textContent = "";
	document.getElementById("designation-error_1").textContent = "";
	document.getElementById("designation-error_2").textContent = "";
	document.getElementById("file-size-error_1").textContent = "";
	document.getElementById("file-size-error_2").textContent = "";
	document.getElementById("errorContainer-work-detail-file_1").textContent = "";
	document.getElementById("errorContainer-work-detail-file_2").textContent = "";
	isEditable=false;
}
function validateFile(id,errorId,field,errorMessage){
    var allowedExtensionsReg;
    if(id.indexOf("_") !== -1){
		var divId=id.substring(id.indexOf("_") + 1);
		errorId=errorId.substring(0,errorId.indexOf("_")+1)+divId;
		console.log(errorId);
	}
	 var filename = document.getElementById(id).files[0].name;
    var extension = filename.substr(filename.lastIndexOf("."));
    if(field=='photo'){
    allowedExtensionsReg = /(\.jpg|\.jpeg|\.png)$/i;
    }
    else{
   	 //allowedExtensionsReg=new RegExp("(.*?)\.(pdf)$");
    	allowedExtensionsReg = /(\.jpg|\.jpeg|\.png|\.pdf)$/i;
    }
    var isAllowed = allowedExtensionsReg.test(extension);

    if(isAllowed){
   	 $("#"+errorId).html("");
    }else{
   	 $("#"+errorId).text(errorMessage);
    }
}


//Work detail functions


function getWorkSector(id){
	        	var substring=id.substr ( id.indexOf ( '_' ) + 1 );			
				 var selectedValue= $("#"+id).find('option:selected').val();
				 console.log("selectedvlaue ");
				 console.log(selectedValue);
				 if(selectedValue){
					 console.log("selectedValue :: "+selectedValue);
					 //else{
						 $('#worksectorTypediv_'+substring).addClass('d-none'); 
					 $.ajax({
							url: '${getWorkSectorByWorkSectorType}',
							async : false,
							data : {
								<portlet:namespace />workSectorType : selectedValue
							},
							type : 'POST',
							success : function(data) {
								console.log(data);
								var options = JSON.parse(data);
								console.log("options ::::::",options[0].id);
								
								 
								if(options[0].id=="other"){
									 console.log(substring+" --------------");
									 $('#worksectorTypediv_'+substring).removeClass('d-none');
									 $('#work-sector-div_'+substring).addClass('d-none');
									 $('#div-first-sub-sector_'+substring).addClass('d-none');
									 $('#div-o3-work-other_'+substring).addClass('d-none');
									 $('#div-o2-work-other_'+substring).addClass('d-none');
									 
								 }else{
									 updateOtherDropdown(options,"worksector_"+substring);
									 $('#work-sector-div_'+substring).removeClass('d-none');   
								 }
								
							}
					 });
					 //}
				 }else{
						console.log("inside else ::::"); 
					 var otherDropdown = document.getElementById("worksector_"+substring); 
					  otherDropdown.innerHTML = '';
			            var optElement = document.createElement('option');
			            optElement.value="";
			            optElement.textContent = '<liferay-ui:message key="select" />';
			            otherDropdown.appendChild(optElement);
			            $('#worksectorTypediv_'+substring).addClass('d-none');   
			            $('#work-sector-div_'+substring).removeClass('d-none');   
				 }
	        }
	        
	        
	        
		function updateOtherDropdown(options,field) {
			console.log("field : "+field);
		    var otherDropdown = document.getElementById(field);
		    
		    console.log("otherDropdown :::",otherDropdown);
		    
		    otherDropdown.innerHTML = '';
		    var optElement = document.createElement('option');
		    optElement.value="";
		    optElement.textContent = '<liferay-ui:message key="select" />';
		    otherDropdown.appendChild(optElement);
		    options.forEach(function(option) {
		        var optionElement = document.createElement('option');
		        optionElement.value = option.id;
		        optionElement.textContent = option.value;
		        otherDropdown.appendChild(optionElement);
		    });
		}
		
		
		
		function getChildWorkSector(id,field){
	    	   var substring=id.substr ( id.indexOf ( '_' ) + 1 );			
				 var selectedValue= $("#"+id).find('option:selected').val();
				 console.log("selectedvlaue ");
				 console.log(selectedValue);
				 console.log("field :::::",field);
				 if(selectedValue){
				 console.log("selectedValue :: "+selectedValue);
				 console.log("substring :: "+substring);
				 
				 
				 if(selectedValue =='other'){
					 console.log("inside other ::::::::");
					 //$('#div-work-other_'+substring).removeClass('d-none'); 
					 //div-work-other_1
					 
					 
					 $("#div-o2-work-other_"+substring).removeClass("d-none");
					
					 $("#div-first-sub-sector_"+substring).addClass("d-none");
					 $("#div-o3-work-other_"+substring).addClass('d-none');	
					 
				 }else{
					 $.ajax({
							url: '${ getWorkSectorByParentWorkSector}',
							async : false,
							data : {
								<portlet:namespace />parentWorkSectorId : selectedValue
							},
							type : 'POST',
							success : function(data) {
								$("#div-o2-work-other_"+substring).addClass('d-none');
								$("#div-first-sub-sector_"+substring).removeClass("d-none");
								$("#div-o3-work-other_"+substring).addClass('d-none');
								
								console.log(data);
								var options = JSON.parse(data);
								console.log(options);
								if(field=="first"){
									console.log("if");
								updateOtherDropdown(options,"first-sub-worksector_"+substring);
								}
								else if(field=="second"){
									console.log("else");
								updateOtherDropdown(options,"second-sub-worksector_"+substring);	
								}
							}
					 });
				 }
			 	}
	       }
		
		
		 //For second child 
        
        function getChildWorkSector2(id,field){
	    	   var substring=id.substr ( id.indexOf ( '_' ) + 1 );			
				 var selectedValue= $("#"+id).find('option:selected').val();
				 console.log("selectedvlaue ");
				 console.log(selectedValue);
				 console.log("field :::::",field);
				 if(selectedValue){
				 console.log("selectedValue :: "+selectedValue);
				 console.log("substring :: "+substring);
				 
				 
				 	if(selectedValue =='other'){
						 console.log("inside other ::::::::");
						 //$('#div-work-other_'+substring).removeClass('d-none'); 
						 //div-work-other_1
						 $("#div-o3-work-other_"+substring).removeClass("d-none");
						
						 //$("#div-first-sub-sector_"+substring).addClass("d-none");
						 
				 	}else{
					 $("#div-o3-work-other_"+substring).addClass('d-none');
				 	}
			 	}else{
			 		 $("#div-o3-work-other_"+substring).addClass('d-none');
			 	}
	       }

//==========================================================ROLE SERVICE SECTION START
     
	var isRoleApprover='${isRoleApprover}';
	
	console.log("isRoleApprover :::::",isRoleApprover);

	if(isRoleApprover){
		$(".role-section-2").removeClass("d-none");
		$(".role-section-1").removeClass("d-none");
	}
        
        $('input[name="<portlet:namespace/>associated"]').change(function() {
      	var passoc = $("input[name='<portlet:namespace/>associated']:checked").val();
      	console.log("passoc"+passoc);
      	if(passoc == 0 || passoc == "0" ) {
      		$("#txtIndex").val("2");
      		$("#isAssosiated").val("false");
      		console.log("card");
      		$('#registrant_detail_area').removeClass("d-none");
      		$('#associated_detail_area').addClass("d-none");
      	}
      	else{
      		console.log("mobile");
      		$("#txtIndex").val("1");
      		$("#isAssosiated").val("true");
      		$('#associated_detail_area').removeClass("d-none");
      		$('#registrant_detail_area').addClass("d-none");
      	}
      });

      $('input[name="<portlet:namespace/>registering"]').change(function() {
      	var preg = $("input[name='<portlet:namespace/>registering']:checked").val();
      	console.log("preg"+preg);
      	if(preg == 0 || preg == "0" ) {
      		$('#service_detail_area').removeClass("d-none");
      		$('#role_detail_area').addClass("d-none");
      	}
      	else{
      		$("#txtIndex").val("2");
      		$('#role_detail_area').removeClass("d-none");
      		$('#service_detail_area').addClass("d-none");
      	}
      });
        
        
       $('#role-service-list').DataTable({	
          "bLengthChange": false,	
          "bFilter": false,
          "ordering": false
      });
       


       function openRoleServiceOpenAddModel(id){
      		console.log("role service id :: "+id);
      		
      		document.getElementById('select2-role_1-container').innerHTML="select";
      		document.getElementById('select2-department_1-container').innerHTML="select";
      		document.getElementById('select2-section_1-container').innerHTML="select";
      		document.getElementById('select2-function_1-container').innerHTML="select";
      		document.getElementById('select2-programtype_1-container').innerHTML="select";
      		document.getElementById('select2-program_1-container').innerHTML="select";
      		
      		
      		
      		document.getElementById('select2-role-container').innerHTML="select";
      		document.getElementById('select2-department_2-container').innerHTML="select";
      		document.getElementById('select2-section_2-container').innerHTML="select";
      		document.getElementById('select2-committe-container').innerHTML="select";
      		document.getElementById('select2-function_2-container').innerHTML="select";
      		document.getElementById('select2-programtype_2-container').innerHTML="select";
      		document.getElementById('select2-program_2-container').innerHTML="select";
      		
      		
      		$("#registrant_detail_area").addClass("d-none");
      		$("#associated_detail_area").removeClass("d-none");
      		$("#txtIndex").val("1");
      		$("#add-role-service-confirm-modal").data("id",id);
      		
      		
      	}



      //Get Role Service By ID
      function setRoleServiceID(id){
      	console.log("id ::::",id);
      	if(id){
      		document.getElementById("role_1").value = '';
      		document.getElementById("department_1").value = '';
      		//document.getElementById("qualification").value = '';
      		//document.getElementById("institution").value = '';
      		//document.getElementById("country").value = '';
      		//document.getElementById("gpa").value = '';
      		//document.getElementById("year").value = '';
      		//document.getElementById("id").value = '';
      		//document.getElementById("qualificationdoclbl").innerHTML = '';
      		//$("#view-div").removeClass("d-none");
      		$.ajax({
      			url: '${getRoleServiceURL}',
      			async : false,
      			data : {
      				<portlet:namespace />id : id,
      			},
      			type : 'POST',
      			success : function(data) {
      				const response = JSON.parse(data);
      				console.log("response :::::",response);
      				const userMetadata = JSON.parse(response.userMetadata);
      				console.log("userMetadata :::",userMetadata);
      				console.log("userMetadata.roleId :::",userMetadata.roleId);
      				console.log("userMetadata.departmentId :::",userMetadata.departmentId);
      				console.log("userMetadata.functionId :::",userMetadata.functionId);
      				console.log("userMetadata.associated :::",userMetadata.associated);
      				
      				
      				if(userMetadata.associated){
      					console.log("inside 1");
      					$("#registrant_detail_area").addClass("d-none");
      					$("#associated_detail_area").removeClass("d-none");
      					$("#txtIndex").val("1");
      					
      					document.getElementById("role_1").value = userMetadata.roleId;
      					var selectionRole_1 = $('option:selected', $('#role_1'));
      					document.getElementById('select2-role_1-container').innerHTML=selectionRole_1.text().trim();
      					
      					//document.getElementById("role_1").value = userMetadata.roleId;
      					document.getElementById("department_1").value = userMetadata.departmentId;
      					var selectiondepartment_1 = $('option:selected', $('#department_1'));
      					document.getElementById('select2-department_1-container').innerHTML=selectiondepartment_1.text().trim();
      					
      					document.getElementById("id").value = userMetadata.id;
      					
      					document.getElementById("section_1").value = userMetadata.sectionId;
      					var selectionsection_1 = $('option:selected', $('#section_1'));
      					document.getElementById('select2-section_1-container').innerHTML=selectionsection_1.text().trim();
      					
      					
      					document.getElementById("function_1").value = userMetadata.functionId;
      					var selectionfunction_1 = $('option:selected', $('#function_1'));
      					document.getElementById('select2-function_1-container').innerHTML=selectionfunction_1.text().trim();
      					
      					
      					document.getElementById("programtype_1").value = userMetadata.programTypeId;
      					var selectionprogramtype_1 = $('option:selected', $('#programtype_1'));
      					document.getElementById('select2-programtype_1-container').innerHTML=selectionprogramtype_1.text().trim();
      					
      					
      					document.getElementById("program_1").value = userMetadata.programId;
      					var selectionprogram_1 = $('option:selected', $('#program_1'));
      					document.getElementById('select2-program_1-container').innerHTML=selectionprogram_1.text().trim();
      					
      					
      					
      				}else{
      					$("#txtIndex").val("2");
      					console.log("inside 2");
      					$("#registrant_detail_area").removeClass("d-none");
      					$("#associated_detail_area").addClass("d-none");
      					
      					document.getElementById("role").value = userMetadata.roleId;
      					var selectionRole = $('option:selected', $('#role'));
      					document.getElementById('select2-role-container').innerHTML=selectionRole.text().trim();
      					
      					
      					
      					document.getElementById("department_2").value = userMetadata.departmentId ;
      					var selectionDepartment_2 = $('option:selected', $('#department_2'));
      					document.getElementById('select2-department_2-container').innerHTML=selectionDepartment_2.text().trim();
      					
      					document.getElementById("section_2").value = userMetadata.sectionId;
      					var selectionSection_2 = $('option:selected', $('#section_2'));
      					document.getElementById('select2-section_2-container').innerHTML=selectionSection_2.text().trim();
      					
      					
      					document.getElementById("function_2").value = userMetadata.functionId;
      					var selectionFunction_2 = $('option:selected', $('#function_2'));
      					document.getElementById('select2-function_2-container').innerHTML=selectionFunction_2.text().trim();
      					
      					
      					document.getElementById("programtype_2").value = userMetadata.programTypeId;
      					var selectionprogramtype_2 = $('option:selected', $('#programtype_2'));
      					document.getElementById('select2-programtype_2-container').innerHTML=selectionprogramtype_2.text().trim();
      					
      					
      					document.getElementById("program_2").value = userMetadata.programId;
      					var selectionprogram_2 = $('option:selected', $('#program_2'));
      					document.getElementById('select2-program_2-container').innerHTML=selectionprogram_2.text().trim();
      					
      					document.getElementById("committe").value = userMetadata.committeeId;
      					var selectionCommitte = $('option:selected', $('#committe'));
      					document.getElementById('select2-committe-container').innerHTML=selectionCommitte.text().trim();
      					
      				}
      				
      			}
      		})
      	}
      }

      //Delete Role Service By Id
      function deleteRoleServiceSection(){

      	var deleteId = document.getElementById("deleteID").value;
      	var lrUserId = document.getElementById("lrUserId").value;
      	console.log("deleteRoleServiceSection() called ::");
      	console.log("deleteId",deleteId);
      	console.log("lrUserId",lrUserId);
      	
      	if(deleteId){
      		$.ajax({
      			url: '${deleteRoleServiceURL}',
      			async : false,
      			data : {
      				<portlet:namespace />id : deleteId,
      				<portlet:namespace />lrUserId : lrUserId 
      			},
      			type : 'POST',
      			success : function(data) {
      				isEdit=false;
      				$('#delete-role-service-modal').modal('hide');
      				//document.getElementById("qualification").value = "";
      				//document.getElementById("institution").value = "";
      				//document.getElementById("country").value = "";
      				//document.getElementById("gpa").value = "";
      				//document.getElementById("year").value = "";
      				//document.getElementById("id").value = '';
      				//document.getElementById("qualificationdoclbl").innerHTML = '';
      				$("#roleServiceList").html(data);
      				$('#role-service-list').DataTable({	
      				    "bLengthChange": false,	
      				    "bFilter": false,
      				    "ordering": false
      				});
      			},
      		})
      	}
      } 

      //Save Role Service 
      function saveRoleService(){
		//if(isValidVerificationField()){
      		
      		console.log("inside save role service called::");
      		
      		var isAssosiated = $("#isAssosiated").val().trim();
      		
      		
      		//Is OMSB Assosiated 
      		var role_1 = $("#role_1").val().trim();
      		var department_1 = $("#department_1").val().trim();
      		var section_1 = $("#section_1").val().trim();
      		var function_1 = $("#function_1").val().trim();
      		var programtype_1 = $("#programtype_1").val().trim();
      		var program_1 = $("#program_1").val().trim();
      		
      		//Not OMSB Assosiated 
      		var role_2 = $("#role").val().trim();
      		var department_2 = $("#department_2").val().trim();
      		var section_2 = $("#section_2").val().trim();
      		var committe = $("#committe").val().trim();
      		var function_2 = $("#function_2").val().trim();
      		var programtype_2 = $("#programtype_2").val().trim();
      		var program_2 = $("#program_2").val().trim();
      		var id = $("#id").val().trim();
      		var personId = $("#personId").val().trim();
      		var lrUserId = $("#lrUserId").val().trim();
      		var txtIndex = $("#txtIndex").val().trim();
      		var txtIndex = $("#txtIndex").val().trim();
      		
      		
      		console.log("isAssosiated :::",isAssosiated);
      		console.log("id :::",id);
      		console.log("role_1 :::",role_1);
      		console.log("department_1 :::",department_1);
      		console.log("section_1 :::",section_1);
      		console.log("function_1 :::",function_1);
      		console.log("programtype_1 :::",programtype_1);
      		console.log("program_1 :::",program_1);
      		console.log("lrUserId :::",lrUserId);
      		console.log("txtIndex :::",txtIndex);
      		console.log("role_2 :::",role_2);
      		console.log("department_2 :::",department_2);
      		console.log("section_2 :::",section_2);
      		console.log("committe :::",committe);
      		console.log("function_2 :::",function_2);
      		console.log("programtype_2 :::",programtype_2);
      		console.log("program_2 :::",program_2);
      		
      		//var uploadFile = document.getElementById("staffIdCard_3").files[0];
      		var formData = new FormData();
      		//formData.append('<portlet:namespace />staffIdCard_3', uploadFile);
      		formData.append('<portlet:namespace />associated',isAssosiated);
      		formData.append('<portlet:namespace />role_1', role_1);
      		formData.append('<portlet:namespace />department_1', department_1);
      		formData.append('<portlet:namespace />section_1', section_1);
      		formData.append('<portlet:namespace />function_1', function_1);
      		formData.append('<portlet:namespace />programtype_1', programtype_1);
      		formData.append('<portlet:namespace />program_1', program_1);
      		formData.append('<portlet:namespace />role_2', role_2);
      		formData.append('<portlet:namespace />department_2', department_2);
      		formData.append('<portlet:namespace />section_2', section_2);
      		formData.append('<portlet:namespace />committe_2', committe);
      		formData.append('<portlet:namespace />function_2', function_2);
      		formData.append('<portlet:namespace />programtype_2', programtype_2);
      		formData.append('<portlet:namespace />program_2', program_2);
      		formData.append('<portlet:namespace />index',txtIndex);
      		formData.append('<portlet:namespace />id', id);
      		formData.append('<portlet:namespace />personId', personId);
      		formData.append('<portlet:namespace />lrUserId', lrUserId);
      		console.log("save Role Service details  called :::");
      		$.ajax({
      			url: '${saveRoleServiceURL}',
      			type:'POST',
      	      	processData: false,
      	      	contentType: false,
      	      	async: false,
      	      	cache: false,
      	      	data : formData,
      			success : function(data) {
      				isEdit=false;
      				document.getElementById('select2-role_1-container').innerHTML="select";
      				document.getElementById('select2-department_1-container').innerHTML="select";
      				document.getElementById('select2-section_1-container').innerHTML="select";
      				document.getElementById('select2-function_1-container').innerHTML="select";
      				document.getElementById('select2-programtype_1-container').innerHTML="select";
      				document.getElementById('select2-program_1-container').innerHTML="select";
      				document.getElementById('select2-role-container').innerHTML="select";
      				document.getElementById('select2-department_2-container').innerHTML="select";
      				document.getElementById('select2-section_2-container').innerHTML="select";
      				document.getElementById('select2-committe-container').innerHTML="select";
      				document.getElementById('select2-function_2-container').innerHTML="select";
      				document.getElementById('select2-programtype_2-container').innerHTML="select";
      				document.getElementById('select2-program_2-container').innerHTML="select";
      				$("#roleServiceList").html(data);
      				$('#role-service-list').DataTable({	
      				    "bLengthChange": false,	
      				    "bFilter": false,
      				    "ordering": false
      				});
      				$("#add-role-service-confirm-modal").modal('hide');
      			},
      		})
      }
      //Role Service 
      function setSection(departmentId,sectionId){
      		var inputDepartmentId=$("#"+departmentId).val();
      		console.log("inputDepartmentId ::::",inputDepartmentId);
      		$.ajax({
      			url: '${sectionDepartmentURL}',
      			async : false,
      			dataType:"json",
      			data : {
      				<portlet:namespace />departmentId : inputDepartmentId,
      			},
      			type : 'POST',
      			success : function(data) {
      				console.log("success :::::",data);
      				console.log("success :::::",data.length);
      				 var response=data;
      				 console.log("response :::::",response.length);
      				var sectionData="<option value=''><liferay-ui:message key='select'/></option>";
      				
      				$.each(response, function( index, value ) {
      					sectionData=sectionData+"<option value='"+value.key+"'><liferay-ui:message key='"+value.name+"'/></option>";
      			    });
      				$("#"+sectionId).html("").append(sectionData);
      			},
      		})
      	}
      		
      		
      	$(document).on('change','#department_1',function(){
      		console.log("change");	
      		var departmentId=$('#department_1').val();
      		console.log("departmentId :::::::::::",departmentId);
      			setSection("department_1","section_1");
      		
      	});
      	
      	
      	$(document).on('change','#department_2',function(){
      		console.log("change");	
      		var departmentId=$('#department_2').val();
      		console.log("departmentId :::::::::::",departmentId);
      			setSection("department_2","section_2");
      	});
      	

      	$(document).on('change','#section_1',function(){
      		var sectionId=$('#section_1').val();
      		console.log("sectionId :::::::::::",sectionId);
      		setFunctionCommitee("section_1","function_1","");
      	});
      	
      	$(document).on('change','#section_2',function(){
      		var sectionId=$('#section_2').val();
      		console.log("sectionId :::::::::::",sectionId);
      		setFunctionCommitee("section_2","function_2","committe");
      	});
      			
      			
      	function setFunctionCommitee(sectionId,functionId,committeId){
      		var inputsectionId=$("#"+sectionId).val();
      		$.ajax({
      			url: '${functionSectioncommitteURL}',
      			dataType:"json",
      			async : false,
      			data : {
      				<portlet:namespace />sectionId : inputsectionId,
      			},
      			type : 'POST',
      			success : function(data) {
      				console.log("success :::::");
      				var response=data;
      				var functionData="<option value=''><liferay-ui:message key='select'/></option>";
      				$.each(response.functionObj, function( index, value ) {
      					functionData=functionData+"<option value='"+value.key+"'><liferay-ui:message key='"+value.name+"'/></option>";
      			    });
      				$("#"+functionId).html("").append(functionData);
      				
      				if(committeId !== null && committeId !== ''){
      					var committeData="<option value=''><liferay-ui:message key='select'/></option>";
      					$.each(response.committeObj, function( index, value ) {
      						committeData=committeData+"<option value='"+value.key+"'><liferay-ui:message key='"+value.name+"'/></option>";
      				    });
      					$("#"+committeId).html("").append(committeData);
      				}
      			},
      		})
      	}
      			
      	$(document).on('change','#programtype_1',function(){
      		var programTypeId=$('#programtype_1').val();
      		console.log("programTypeId ::::::::",programTypeId);
      		setProgram("programtype_1","program_1");
      	});
      	
      	$(document).on('change','#programtype_2',function(){
      		var programTypeId=$('#programtype_2').val();
      		console.log("programTypeId ::::::::",programTypeId);
      		setProgram("programtype_2","program_2");
      	});
      			
      	function setProgram(programTypeId,programId){
      		var inputprogramTypeId=$("#"+programTypeId).val();
      		$.ajax({
      			url: '${programTypeURL}',
      			dataType:"json",
      			async : false,
      			data : {
      				<portlet:namespace />programTypeId : inputprogramTypeId,
      			},
      			type : 'POST',
      			success : function(data) {
      				console.log("success :::::",data);
      				 console.log("success :::::",data.length);
      				 var response=data;
      				 console.log("response :::::",response.length);
      				var programData="<option value=''><liferay-ui:message key='select'/></option>";
      				
      				$.each(response, function( index, value ) {
      					programData=programData+"<option value='"+value.id+"'><liferay-ui:message key='"+value.name+"'/></option>";
      			    });
      				$("#"+programId).html("").append(programData);
      			},
      		})
      	}



      //Role service pre populate data
      /* var userMetadataId=$('#userMetadataId').val();
      var isAssociated=$('#isAssociated').val();
      var isregisteringForRole=$('#isregisteringForRole').val();
      console.log("isAssociated ::::",isAssociated);
      console.log("isregisteringForRole ::::",isregisteringForRole);
      console.log("userMetadataId ::::",userMetadataId);

      if(isAssociated == 'true'){
      	console.log("mobile");
      	$("#txtIndex").val("1");
      	$("#isAssosiated").val("true");
      	$('#associated_detail_area').removeClass("d-none");
      	$('#registrant_detail_area').addClass("d-none");
      }else if(isAssociated== 'false' && isregisteringForRole == 'true'){
      	$('#associated_yes').prop('checked', false);
      	$('#associated_no').prop('checked', true);
      	$('#registering_yes').prop('checked', true);
      	$('#registering_no').prop('checked', false);
      	$("#txtIndex").val("2");
      	$("#isAssosiated").val("false");
      	console.log("card");
      	$('#registrant_detail_area').removeClass("d-none");
      	$('#associated_detail_area').addClass("d-none");
      }else if(isAssociated =='false' && isregisteringForRole== 'false' && userMetadataId>0){
      	$('#associated_yes').prop('checked', false);
      	$('#associated_no').prop('checked', true);
      	$('#registering_yes').prop('checked', false);
      	$('#registering_no').prop('checked', true);
      	$('#service_detail_area').removeClass("d-none");
      	$('#associated_detail_area').addClass("d-none");
      	$('#registrant_detail_area').removeClass("d-none");
      	$('#role_detail_area').addClass("d-none");
      } */




        //====================================================================ROLE SERVICE SECTION ENDS

</script>