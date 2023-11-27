<%@ include file="../init.jsp"%>
<portlet:renderURL var="viewRegistrationList">
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommands.ADMIN_REGISTRATION_LIST%>" />
</portlet:renderURL>
<portlet:resourceURL id="<%=MVCCommands.SPECIALITY_AND_SUBSPECIALITY_MVC_RESOURCE%>" var="specialityListURL" />	
<portlet:resourceURL var="fileUploadURL" id="<%=MVCCommands.UPLOAD_USER_PHOTO%>"></portlet:resourceURL>
<portlet:resourceURL id="<%=MVCCommands.FETCH_SPECIALITY_BY_PROFESSION%>" var="professionListURL" />
<div class="main-content">
	<section class="omsb-main-wrapper" id="omsb-main-wrapper">
		<div id="wrapper">
			<div class="container">
				<div class="omsb-card ">
					<liferay-portlet:actionURL name="<%=MVCCommands.SAVE_REGISTRATION_DETAILS%>" var="saveRDURL">
					</liferay-portlet:actionURL>
					<form action="${saveRDURL}" method="post" 
						name="<portlet:namespace/>rdFM" id="rdFM" autocomplete="off" enctype="multipart/form-data">
						<input type="hidden" value="${personId}" name="<portlet:namespace/>personId"/>
						<div class="reg_step1" id="reg_step1">
							<div class="omsb-card m-0 p-0">
								<div class="omsb-page-top-info mb-4">
									<div class="pagetitle">
									<liferay-ui:message key="edit-profile" /></div>
									<div class="profile_photo">
                                         <div class="upload-container">
                                            <input type="file" id="imageUpload" name="<portlet:namespace/>imageUpload" accept="image/*">
                                               <label for="imageUpload" class="upload-label">Edit</label>
                                                <c:if test="${not empty photoURL }"><img id="imagePreview" src="${photoURL}" alt="Preview"></c:if>
                                                <c:if test="${empty photoURL }"><img id="imagePreview" src="<%=themeDisplay.getPathThemeImages() %>/png/profile_img.png" alt="Preview"></c:if>
                                                <p class="error-container" id="profile-error-container"></p>
                                         </div>                       
                                    </div>
								</div>
								<div class="omsb-page-top-info">
			                        <c:choose>
				                        <c:when test="${userVerificationProfileStatus eq 'reject'}">
					                        <span class="btn omsb-rejected-bg"><liferay-ui:message key="rejected-profile"/></span>
					                        <div class="information">
					      	  					<button type="button" class="btn omsb-bc-red-button" id="profile_comments" data-target="#profile-comments-modal" data-toggle="modal"><liferay-ui:message key="profile-approval-comments"/></button>
											</div>
										</c:when>
										<c:when test="${userVerificationProfileStatus eq 'approve'}">
											<span class="btn omsb-complete-bg"><liferay-ui:message key="approve-profile"/></span>
										</c:when>
										<c:when test="${userVerificationProfileStatus eq 'Pending'}">
											<div class="d-flex align-items-center"><span class="btn omsb-rejected-bg"><liferay-ui:message key="under-approval"/></span><div class="tooltipp"><img src="<%=themeDisplay.getPathThemeImages()%>/svg/i-button.svg" alt="info" class="tooltipp" >
												<div class="tooltiptext"><ul class="cst_ul"><li><liferay-ui:message key="profile-pending-message" /></li></ul></div>
											</div>
											</div>
										</c:when>
									</c:choose>
		                    	</div>
							</div>												
						 	<%@ include file="edit-personal-detail.jspf"%>
							<input type="hidden" name="<portlet:namespace/>emailAddressOTPVerified" id="emailAddressOTPVerified" value="${user_.emailAddressVerified}">
							<input type="hidden" name="<portlet:namespace/>mobileNumberOTPVerified" id="mobileNumberOTPVerified" value="${personalDetails.mobileNumberVerified}">
							<input type="hidden" name="<portlet:namespace/>userId" id="userId" value="${user_.userId}">
							<input type="hidden" name="<portlet:namespace />countryCode" id="hiddenCountryCode" value="${personalDetails.countryCode}" />
							<input type="hidden" name="<portlet:namespace />countryIsoCode" id="hiddenCountryIsoCode" value="${personalDetails.countryIsoCode}" />
							<input type="hidden" name="<portlet:namespace />isMyProfile" id="isMyProfile" value="true" />
						</div>
						<div class="reg_step2 "  id="reg_step2">
							<div class="omsb-page-top-info mb-4">
								<h3 class="reg-form-title w-auto"><liferay-ui:message key="education-details" /></h3>
								<div class="information"><button type="button" class="btn omsb-bg-red-button" id="add_education_detail" onClick="openEduOpenAddModel(this)"  data-target="#add-education-confirm-modal" data-toggle="modal"><img src="../images/svg/plus_img.svg" alt=""> Add More</button></div>
							</div>
							<div id="edu_detail_area">
								<input type="hidden" value="1"  name="<portlet:namespace/>counter"  id="counter"/>
								<div id="educationDetailsList">
											<c:choose>
												<c:when test="${!empty educationalDetailItemList}">
													<table class="display omsb-datatables" id="work-detail-list" width="100%">
														<thead>
															<tr>
																<th><liferay-ui:message key="qualification-type" /></th>
																<th><liferay-ui:message key="institution" /></th>
																<th><liferay-ui:message key="country-of-institution" /></th>
																<th><liferay-ui:message key="year-of-graduation" /></th>
																<th><liferay-ui:message key="action" /></th>
															</tr>
														</thead>
														<tbody>
														<c:forEach var="educationalDetailItem" items="${educationalDetailItemList}">
															<tr>
																<td>${educationalDetailItem.qualificationAttained}</td>
																<td>${educationalDetailItem.issuingAuthorityName}</td>
																<td>${educationalDetailItem.issuingAuthorityCountry}</td>
																<td>${educationalDetailItem.yearOfGraduation}</td>
																<td>
																	<button class="btn delete_btn" value="Delete" type="button" data-toggle="modal" data-target="#delete-education-confirm-modal" data-rowcount="addPopUpRow" onclick="setDeleteID('${educationalDetailItem.id}')" ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/delete_icon.svg" style="cursor: default;"></button>
																	<button class="btn mx-2" value="view" type="button" data-toggle="modal" data-target="#add-education-confirm-modal" onclick="setEditID('${educationalDetailItem.id}')" ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg"></button>
																</td>
															</tr>
														</c:forEach>
													</tbody>
												</table>
												</c:when>
												<c:otherwise><liferay-ui:message key="no-records-found" /></c:otherwise>
											</c:choose>
										</div>
								<input type="hidden" value="${personId}" name="<portlet:namespace/>personId" id="personId"/>
								<input type="hidden" value="${lrUserId}" name="<portlet:namespace/>lrUserId" id="lrUserId"/>
							</div>
						</div>						
						<div class="reg_step3 mt-4"  id="reg_step3">
						    <h3 class="reg-form-title w-auto"><liferay-ui:message key="registration-work-details" /></h3>
							<input type="hidden" value="${lrUserId}" name="<portlet:namespace/>lrUserId" id="lrUserId" /> 
							<input type="hidden" value="${personId }" name="<portlet:namespace/>personId" id="personId">							
							<div class="omsb-main-div" id="work-detail-main">	
							<c:choose>
								<c:when test="${empty primaryworkDetail}">
									<div class="omsb-card omsb-card-graybg omsb-noBorderRadius work_detail" id="work_detail_1">
										<input type="hidden" name="<portlet:namespace/>id_1" id="<portlet:namespace/>id_1"> 
										<input type="hidden" name="<portlet:namespace/>isPrimary_1" id="<portlet:namespace/>isPrimary_1" value="true">
											<div class="">
												<label class="control-label"><liferay-ui:message key="primary-work-detail" /></label>
												<div class="row ">
													<div class="col-lg-4 col-md-6">
														<div class="form-group">
															<label class="control-label  required"><liferay-ui:message key="primary-workplace-sector-type" /></label> 
															<select name="<portlet:namespace/>workSectorType_1" id="workSectorType_1" class="form-control" onchange="getWorkSector(this.id)">
																<option value=""><liferay-ui:message key="select" /></option>
																<c:forEach var="workSectorType" items="${workSectorTypeList}">
																	<option value="${workSectorType.getListTypeEntryId()}"> <liferay-ui:message key="${workSectorType.getName(themeDisplay.getLocale())}" /></option>
																</c:forEach>
															</select>
															<p class="error-container" id="work-sector-type-error_1"></p>
														</div>
													</div>
													<div class="col-lg-4 col-md-6 d-none" id="worksectorTypediv_1">
														<div class="form-group">
															<label class="control-label "><liferay-ui:message key="primary-workplace-sector-type-other" /></label>
															 <input type="text" name="<portlet:namespace/>worksectortypeother_1" id="worksectortypeother_1" value="Other" class="form-control">
														</div>
													</div>
													<div class="col-lg-4 col-md-6" id="work-sector-div_1">
														<div class="form-group" >
															<label class="control-label required"><liferay-ui:message key="primary-sector-name" /></label>															  
															  <select name="<portlet:namespace/>worksector_1" id="worksector_1" class="form-control" onchange="getChildWorkSector(this.id,'first')" >
																<option value="" selected="selected"><liferay-ui:message key="select" /></option>
															</select>
															<p class="error-container" id="work-sector-error_1"></p>
														</div>
													</div>
													<div class="col-lg-4 col-md-6 d-none" id="div-o2-work-other_1">
														<div class="form-group">
															<label class="control-label "><liferay-ui:message key="primary-sector-name-other" /></label>
															 <input type="text" name="<portlet:namespace/>worksectorother_1" id="worksectorother_1" class="form-control"> 
														</div>
													</div>
													<div class="col-lg-4 col-md-6 d-none" id="div-first-sub-sector_1">
														<div class="form-group">
															<label class="control-label "></label>
															<select name="<portlet:namespace/>first-sub-worksector_1" id="first-sub-worksector_1" class="form-control" onchange="getChildWorkSector2(this.id,'second')">
																<option value=""><liferay-ui:message key="select" /></option>
																<option value="other" selected="selected"><liferay-ui:message key="other" /></option>
															</select>
														</div>
													</div>
													<div class="col-lg-4 col-md-6  d-none " id="div-o3-work-other_1">
														<div class="form-group">
															<label class="control-label "><%-- <liferay-ui:message key="primary-sub-sector-name-other" /> --%></label>
															 <input type="text" name="<portlet:namespace/>work_sub_sectorother_1" id="worksectorother_1" class="form-control" value="">
														</div>
													</div>
													<div class="col-lg-4 col-md-6 d-none" id="div-second-sub-sector_1">
														<div class="form-group">
															<label class="control-label "></label>
															<select name="<portlet:namespace/>second-sub-worksector_1" id="second-sub-worksector_1" class="form-control"   onchange="getChildWorkSector3(this.id,'second')">
																<option value=""><liferay-ui:message key="select" /></option>
																<option value="other" selected="selected"><liferay-ui:message key="other" /></option>
															</select>
														</div>
													</div>
													<div class="col-lg-4 col-md-6  d-none " id="div-o3-secons-work-other_1">
														<div class="form-group">
															<label class="control-label "></label>
															 <input type="text" name="<portlet:namespace/>work_second_sub_sectorother_1" id="worksecondsectorother_1" class="form-control" value="">
														</div>
													</div>
													<div class="col-lg-4 col-md-6">
														<div class="form-group">
															<label class="control-label required"><liferay-ui:message key="region-location-primary-institution" /></label> 
															<select name="<portlet:namespace/>wilayats_1" id="wilayats_1" class="form-control" onchange="validateField(this.id,'location-error_1','<liferay-ui:message key="please-enter-work-sector-location" />')">
																<option value=""><liferay-ui:message key="select" /></option>
																<c:forEach var="wilayats" items="${wilayats}">
																	<option value="${wilayats.getKey()}">
																		<liferay-ui:message key="${wilayats.getName(themeDisplay.getLocale())}" />
																	</option>
																</c:forEach>
															</select>
															<p class="error-container" id="location-error_1"></p>
														</div>
													</div>
													<div class="col-lg-4 col-md-6">
														<div class="form-group">
															<label class="control-label required"><liferay-ui:message key="designation" /></label>
															 <select name="<portlet:namespace/>designations_1" id="designations_1" onchange="showDesignationOther(this.id,'designation-error_1','<liferay-ui:message key="please-enter-designation" />')" class="form-control designation">
																<option value=""><liferay-ui:message key="select" /></option>
																<c:forEach var="designations" items="${designations}">
																	<option value="${designations.getKey()}">
																		<liferay-ui:message key="${designations.getName(themeDisplay.getLocale())}" />
																	</option>
																</c:forEach>
															</select>
															<p class="error-container" id="designation-error_1"></p>
														</div>
													</div>
													<div class="col-lg-4 col-md-6 d-none" id="designationotherdiv_1">
														<div class="form-group">
															<label class="control-label "><liferay-ui:message key="designation-other" /></label>
															 <input type="text" name="<portlet:namespace/>designationother_1" id="designationother_1" value="" class="form-control">
														</div>
													</div>
													<div class="col-lg-12 col-md-12">
														<div class="form-group">
															<label class="control-label"><liferay-ui:message key="staff-card-id" /></label>
															<div class="omsb-custom-html-file custom-file">
																<input id="staffIdCard_1" name="<portlet:namespace/>staffIdCard_1" type="file" label="" class="form-control custom-file-input"  onchange="validateFile(this.id,'file-size-error_1','<liferay-ui:message key="please-select-pdf-file" />')">
																<label class="custom-file-label" for="staffIdCard_1" id="customStaffIdCard_"> </label>
															</div>
															<p class="error-container" id="file-size-error_1"></p>
															<p class="error-container" id="errorContainer-work-detail-file_1"></p>
														</div>
													</div>
												</div>
												<div class="bottom-backbtn-wrap"></div>
											</div>
										</div>
									</c:when>
									<c:otherwise>
											<div class="omsb-card omsb-card-graybg omsb-noBorderRadius work_detail" id="work_detail_1">
												<input type="hidden" name="<portlet:namespace/>id_1" id="<portlet:namespace/>id_1" value="${primaryworkDetail.getId()}">	
												<div class="">
														<label class="control-label"><liferay-ui:message key="primary-work-detail" /></label>
														<input type="hidden" name="<portlet:namespace/>isPrimary_1" id="<portlet:namespace/>isPrimary_1" value="true">
													<div class="row ">
															<div class="col-lg-4 col-md-6">
																<div class="form-group">
																	<label class="control-label required"><liferay-ui:message key="primary-workplace-sector-type" /></label>
																		 <select name="<portlet:namespace/>workSectorType_1" id="workSectorType_1" class="form-control 3" onchange="getWorkSector(this.id)">
																				<option value=""><liferay-ui:message key="select" /></option>
																		<c:forEach var="workSectorType" items="${workSectorTypeList}">
																			<option value="${workSectorType.getListTypeEntryId()}" ${workSectorType.getListTypeEntryId() == primaryworkDetail.getWorkSectorType() ? 'selected="selected"' : ''}>
																				<liferay-ui:message key="${workSectorType.getName(themeDisplay.getLocale())}" />
																			</option>
																		</c:forEach>
																	</select>
																	<p class="error-container" id="work-sector-type-error_1"></p>
																</div>
															</div>															
															<c:choose>
																<c:when test="${not empty primaryworkDetail.getWorkSectorTypeOther()}">
																	<div class="col-lg-4 col-md-6 " id="worksectorTypediv_1">
																		<div class="form-group">
																			<label class="control-label "><liferay-ui:message key="primary-workplace-sector-type-other" /></label>
																			 <input type="text" name="<portlet:namespace/>worksectortypeother_1" id="worksectortypeother_1" value="Other" class="form-control">
																		</div>
																	</div>
																</c:when>
																<c:otherwise>
																	<div class="col-lg-4 col-md-6 d-none" id="worksectorTypediv_1">
																		<div class="form-group">
																			<label class="control-label "><liferay-ui:message key="primary-workplace-sector-type-other" /></label>
																			 <input type="text" name="<portlet:namespace/>worksectortypeother_1" id="worksectortypeother_1" value="Other" class="form-control">
																		</div>
																	</div>
																</c:otherwise>
															</c:choose>															
												<c:choose>													
														<c:when test="${primaryworkDetail.workSectorId>0}">
															<div class="col-lg-4 col-md-6" id="work-sector-div_1">
																<div class="form-group" >
																	<label class="control-label required"><liferay-ui:message key="primary-sector-name" /></label> 
																			<select name="<portlet:namespace/>worksector_1" id="worksector_1" class="form-control" onchange="getChildWorkSector(this.id,'first')" >
																				<option value=""><liferay-ui:message key="select" /></option>
																				<c:forEach var="workSector" items="${primaryworkDetail.workSectorItems.items}">
																					<option value="${workSector.getId()}" ${workSector.getId() == primaryworkDetail.getWorkSectorId() ? 'selected="selected"' : ''}>
																						${workSector.getWorkSector()}
																					</option>
																				</c:forEach>
																				<option value="other"><liferay-ui:message key="other" /></option>
																			</select>
																	<p class="error-container" id="work-sector-error_1"></p>
																</div>
															</div>
													</c:when>													
													<c:when test="${not empty primaryworkDetail.workSectorOther}">
														<div class="col-lg-4 col-md-6" id="work-sector-div_1">
															<div class="form-group " >
																<label class="control-label required"><liferay-ui:message key="primary-sector-name" /></label> 
																	<select name="<portlet:namespace/>worksector_1" id="worksector_1" class="form-control" onchange="getChildWorkSector(this.id,'first')" >
																		<option value=""><liferay-ui:message key="select" /></option>
																		<c:forEach var="workSector" items="${primaryworkDetail.workSectorItems.items}">
																			<option value="${workSector.getId()}" ${workSector.getId() == primaryworkDetail.getWorkSectorId() ? 'selected="selected"' : ''}>
																				${workSector.getWorkSector()}
																			</option>
																		</c:forEach>
																		<option value="other" selected="selected"><liferay-ui:message key="other"/></option>
																	</select>
																<p class="error-container" id="work-sector-error_1"></p>
															</div>
														</div>
													</c:when>
													<c:when test="${primaryworkDetail.workSectorId==0 && not empty primaryworkDetail.workSectorOther}">
														<div class="col-lg-4 col-md-6 " id="work-sector-div_1">
															<div class="form-group " >
																<label class="control-label required"><liferay-ui:message key="primary-sector-name" /></label> 
																	<select name="<portlet:namespace/>worksector_1" id="worksector_1" class="form-control" onchange="getChildWorkSector(this.id,'first')" >
																		<option value=""><liferay-ui:message key="select" /></option>
																		<option value="other" selected="selected"><liferay-ui:message key="other"/></option>
																	</select>
																<p class="error-container" id="work-sector-error_1"></p>
															</div>
														</div>
													</c:when>
													<c:otherwise>
														<div class="col-lg-4 col-md-6 d-none" id="work-sector-div_1">
															<div class="form-group " >
																<label class="control-label required"><liferay-ui:message key="primary-sector-name" /></label> 
																	<select name="<portlet:namespace/>worksector_1" id="worksector_1" class="form-control" onchange="getChildWorkSector(this.id,'first')" >
																		<option value=""><liferay-ui:message key="select" /></option>
																		<option value="other" selected="selected"><liferay-ui:message key="other"/></option>
																	</select>
																<p class="error-container" id="work-sector-error_1"></p>
															</div>
														</div>
													</c:otherwise>
												</c:choose>
												<c:choose>
													<c:when test="${primaryworkDetail.workSectorId==0 && not empty primaryworkDetail.workSectorOther}">
														<div class="col-lg-4 col-md-6" id="div-o2-work-other_1">
															<div class="form-group">
																<label class="control-label "><liferay-ui:message key="primary-sector-name-other" /></label>
																 <input type="text" name="<portlet:namespace/>worksectorother_1" id="worksectorother_1" class="form-control" value="${primaryworkDetail.workSectorOther}">
															</div>
														</div>
													</c:when>
													<c:when test="${primaryworkDetail.workSectorId==0 &&  empty primaryworkDetail.workSectorOther}">
														<div class="col-lg-4 col-md-6 d-none" id="div-o2-work-other_1">
															<div class="form-group">
																<label class="control-label "><liferay-ui:message key="primary-sector-name-other" /></label>
																 <input type="text" name="<portlet:namespace/>worksectorother_1" id="worksectorother_1" class="form-control" value="${primaryworkDetail.workSectorOther}">
															</div>
														</div>
													</c:when>
													<c:otherwise>
														<div class="col-lg-4 col-md-6 d-none" id="div-o2-work-other_1">
															<div class="form-group">
																<label class="control-label "><liferay-ui:message key="primary-sector-name-other" /></label>
																 <input type="text" name="<portlet:namespace/>worksectorother_1" id="worksectorother_1" class="form-control" value="">
															</div>
														</div>
													</c:otherwise>
												</c:choose>
												<c:choose>
													<c:when test="${primaryworkDetail.workSectorId>0 &&  primaryworkDetail.workSectorId2>0}">
														<div class="col-lg-4 col-md-6" id="div-first-sub-sector_1">
															<div class="form-group">
																<label class="control-label "></label>
																<select name="<portlet:namespace/>first-sub-worksector_1" id="first-sub-worksector_1" class="form-control" onchange="getChildWorkSector2(this.id,'second')">
																<option value=""><liferay-ui:message key="select" /></option>
																<c:forEach var="workSubSector" items="${primaryworkDetail.workSubSectorItems.items}">
																	<option value="${workSubSector.getId()}" ${workSubSector.getId() == primaryworkDetail.getWorkSectorId2() ? 'selected="selected"' : ''}>
																		${workSubSector.getWorkSector()}
																	</option>
																</c:forEach>
																<option value="other"><liferay-ui:message key="other" /></option>
																</select>
															</div>
														</div>
													</c:when>
													<c:when test="${primaryworkDetail.workSectorId2==0 && not empty primaryworkDetail.workSectorOther2}">
														<div class="col-lg-4 col-md-6" id="div-first-sub-sector_1">
															<div class="form-group">
																<label class="control-label "></label>
																<select name="<portlet:namespace/>first-sub-worksector_1" id="first-sub-worksector_1" class="form-control" onchange="getChildWorkSector2(this.id,'second')">
																	<option value=""><liferay-ui:message key="select" /></option>
																	<c:forEach var="workSubSector" items="${primaryworkDetail.workSubSectorItems.items}">
																		<option value="${workSubSector.getId()}" ${workSubSector.getId() == primaryworkDetail.getWorkSectorId2() ? 'selected="selected"' : ''}>
																			${workSubSector.getWorkSector()}
																		</option>
																</c:forEach>
																<option value="other" selected="selected"><liferay-ui:message key="other" /></option>
																</select>
															</div>
														</div>
													</c:when>
													<c:otherwise>
														<div class="col-lg-4 col-md-6 d-none" id="div-first-sub-sector_1">
															<div class="form-group">
																<label class="control-label "></label>
																<select name="<portlet:namespace/>first-sub-worksector_1" id="first-sub-worksector_1" class="form-control" onchange="getChildWorkSector2(this.id,'second')">
																	<option value=""><liferay-ui:message key="select" /></option>
																	<option value="other"><liferay-ui:message key="other" /></option>
																</select>
															</div>
														</div>
													</c:otherwise>
												</c:choose>
												<c:choose>
													<c:when test="${ not empty primaryworkDetail.workSectorOther2}">
													<div class="col-lg-4 col-md-6 " id="div-o3-work-other_1">
														<div class="form-group">
															<label class="control-label "></label>
															 <input type="text" name="<portlet:namespace/>work_sub_sectorother_1" id="worksectorother_1" class="form-control" value="${primaryworkDetail.workSectorOther2}">
														</div>
													</div>
													</c:when>
													<c:otherwise>
													<div class="col-lg-4 col-md-6  d-none " id="div-o3-work-other_1">
														<div class="form-group">
															<label class="control-label "></label>
															 <input type="text" name="<portlet:namespace/>work_sub_sectorother_1" id="worksectorother_1" class="form-control" value="">
														</div>
													</div>
													</c:otherwise>
												</c:choose>
												<c:choose>
													<c:when test="${primaryworkDetail.workSectorId2>0 &&  primaryworkDetail.workSectorId3>0}">
														<div class="col-lg-4 col-md-6 1" id="div-second-sub-sector_1">
															<div class="form-group">
																<label class="control-label "></label>
																<select name="<portlet:namespace/>second-sub-worksector_1" id="second-sub-worksector_1" class="form-control"   onchange="getChildWorkSector3(this.id,'second')">
																	<option value=""><liferay-ui:message key="select" /></option>
																	<c:forEach var="workSecondSubSector" items="${primaryworkDetail.workSecondSubSectorItems.items}">
																		<option value="${workSecondSubSector.getId()}" ${workSecondSubSector.getId() == primaryworkDetail.getWorkSectorId3() ? 'selected="selected"' : ''}>
																			${workSecondSubSector.getWorkSector()}
																		</option>
																</c:forEach>
																<option value="other"><liferay-ui:message key="other" /></option>
																</select>
															</div>
														</div>
													</c:when>
													<c:when test="${primaryworkDetail.workSectorId3==0 && not empty primaryworkDetail.workSectorOther3}">
															<div class="col-lg-4 col-md-6 2" id="div-second-sub-sector_1">
																<div class="form-group">
																	<label class="control-label "></label>
																	<select name="<portlet:namespace/>second-sub-worksector_1" id="second-sub-worksector_1" class="form-control"   onchange="getChildWorkSector3(this.id,'second')">
																	<option value=""><liferay-ui:message key="select" /></option>
																	<c:forEach var="workSecondSubSector" items="${primaryworkDetail.workSecondSubSectorItems.items}">
																		<option value="${workSecondSubSector.getId()}">
																			${workSecondSubSector.getWorkSector()}
																		</option>
																</c:forEach>
																<option value="other" selected="selected"><liferay-ui:message key="other" /></option>
																</select>
																</div>
															</div>
													</c:when>
													<c:otherwise>
														<div class="col-lg-4 col-md-6 3 d-none" id="div-second-sub-sector_1">
															<div class="form-group">
																<label class="control-label "></label>
																<select name="<portlet:namespace/>second-sub-worksector_1" id="second-sub-worksector_1" class="form-control"   onchange="getChildWorkSector3(this.id,'second')">
																	<option value=""><liferay-ui:message key="select" /></option>
																	<option value="other"><liferay-ui:message key="other" /></option>
																</select>
															</div>
														</div>
													</c:otherwise>
												</c:choose>
													<c:choose>
														<c:when test="${primaryworkDetail.workSectorId3==0 &&  not empty primaryworkDetail.workSectorOther3}">
														<div class="col-lg-4 col-md-6" id="div-o3-secons-work-other_1">
															<div class="form-group">
																<label class="control-label "></label>
																 <input type="text" name="<portlet:namespace/>work_second_sub_sectorother_1" id="worksecondsectorother_1" class="form-control" value="${primaryworkDetail.workSectorOther3}">
															</div>
														</div>
														</c:when>
														<c:otherwise>
														<div class="col-lg-4 col-md-6 d-none " id="div-o3-secons-work-other_1">
															<div class="form-group">
																<label class="control-label "></label>
																 <input type="text" name="<portlet:namespace/>work_second_sub_sectorother_1" id="worksecondsectorother_1" class="form-control" value="">
															</div>
														</div>
														</c:otherwise>
													</c:choose>
														<div class="col-lg-4 col-md-6">
															<div class="form-group">
																<label class="control-label required"><liferay-ui:message key="region-location-primary-institution" /></label>
																<select name="<portlet:namespace/>wilayats_1" id="wilayats_1" class="form-control" onchange="validateField(this.id,'location-error_1','<liferay-ui:message key="please-enter-work-sector-location" />')">
																	<option value=""><liferay-ui:message key="select" /></option>
																	<c:forEach var="wilayats" items="${wilayats}">
																		<option value="${wilayats.getKey()}" ${wilayats.getKey() == primaryworkDetail.getWorkSectorLocation() ? 'selected' : ''}>
																			<liferay-ui:message key="${wilayats.getName(themeDisplay.getLocale())}" />
																		</option>
																	</c:forEach>
																</select>
																<p class="error-container" id="location-error_1"></p>
															</div>
														</div>													
														<div class="col-lg-4 col-md-6">
															<div class="form-group">
																<label class="control-label required"><liferay-ui:message key="designation" /></label>
																	<select name="<portlet:namespace/>designations_1" id="designations_1" onchange="showDesignationOther(this.id,'designation-error_1','<liferay-ui:message key="please-enter-designation" />')" class="form-control designation">
																	<option value=""><liferay-ui:message key="select" /></option>
																	<c:forEach var="designations" items="${designations}">
																		<option value="${designations.getKey()}" ${designations.getKey() == primaryworkDetail.getDesignationId() ? 'selected="selected"' : ''}>
																			<liferay-ui:message key="${designations.getName(themeDisplay.getLocale())}" />
																		</option>
																	</c:forEach>
																</select>
																<p class="error-container" id="designation-error_1"></p>
															</div>
														</div>
														<div class="col-lg-4 col-md-6 d-none" id="designationotherdiv_1">
															<div class="form-group">
																<label class="control-label "><liferay-ui:message key="designation-other" /></label> 
																<input type="text" name="<portlet:namespace/>designationother_1" id="designationother_1" value="${primaryworkDetail.getDesignationOther() }" class="form-control">
															</div>
														</div>
														<div class="col-lg-12 col-md-12">
															<div class="row">
														      <div class="col-lg-10 col-md-10">
																	<div class="form-group">
																		<label class="control-label"><liferay-ui:message key="staff-card-id" /></label>
																		<div class="omsb-custom-html-file custom-file">
																			<input id="staffIdCard_1" name="<portlet:namespace/>staffIdCard_1"   type="file" label="" class="form-control custom-file-input" onchange="validateFile(this.id,'file-size-error_1','<liferay-ui:message key="please-select-pdf-file" />')">
																			<label class="custom-file-label" for="staffIdCard_1" id="customStaffIdCard_1">
																			 <c:if test="${not empty primaryworkDetail.getStaffIdCard()}">
																			      ${primaryworkDetail.getUploadFileName()}
																			 </c:if>
																			</label>
																			<c:choose>
																				<c:when test="${not empty primaryworkDetail.getStaffIdCard()}">
																					<input type="hidden" id="uploadFile_1" value="${primaryworkDetail.getStaffIdCard()}" name="<portlet:namespace/>uploadFile_1" />
																				</c:when>
																				<c:otherwise>
																					<input type="hidden" id="uploadFile_1" value="" name="<portlet:namespace/>uploadFile_1" />
																				</c:otherwise>
																			</c:choose>
																		</div>	
																		   <p class="error-container" id="file-size-error_1"></p>
																			<p class="error-container"id="errorContainer-work-detail-file_1"></p>
																	</div>
																</div>
																<div class="col-lg-2 col-md-2">
																   <div class="form-group">
																		<label class="control-label"></label>
																		<a class="btn view_btn text-danger"  title="<liferay-ui:message key="view" />" target="_blank" href="${primaryworkDetail.getDocumentUrl() }">
																			<img src="<%=themeDisplay.getPathThemeImages()%>/svg/view_icon.svg" alt=""> <liferay-ui:message key="view-file" />
																		</a>
																	</div>
														 		</div>
													 		</div>
														 </div>	
														</div>
													</div>
												</div>
										</c:otherwise>
									</c:choose>
	<c:choose>
		<c:when test="${empty secondaryWorkDetail}">
			<div class="omsb-card omsb-card-graybg omsb-noBorderRadius work_detail" id="work_detail_2">
				<input type="hidden" name="<portlet:namespace/>id_2" id="<portlet:namespace/>id_2"> 
				<input type="hidden" name="<portlet:namespace/>isPrimary_2" id="<portlet:namespace/>isPrimary_2" value="false">
					<div class="">
						<label class="control-label"><liferay-ui:message key="secondary-work-detail" /></label>
						<div class="row ">
							<div class="col-lg-4 col-md-6">
								<div class="form-group">
									<label class="control-label  required"><liferay-ui:message key="secondary-workplace-sector-type" /></label> 
									<select name="<portlet:namespace/>workSectorType_2" id="workSectorType_2" class="form-control" onchange="getWorkSector(this.id)">
										<option value=""><liferay-ui:message key="select" /></option>
										<c:forEach var="workSectorType" items="${workSectorTypeList}">
											<option value="${workSectorType.getListTypeEntryId()}"> <liferay-ui:message key="${workSectorType.getName(themeDisplay.getLocale())}" /></option>
										</c:forEach>
									</select>
									<p class="error-container" id="work-sector-type-error_2"></p>
								</div>
							</div>
							<div class="col-lg-4 col-md-6 d-none" id="worksectorTypediv_2">
								<div class="form-group">
									<label class="control-label "><liferay-ui:message key="secondary-workplace-sector-type-other" /></label>
									 <input type="text" name="<portlet:namespace/>worksectortypeother_2" id="worksectortypeother_2" value="Other" class="form-control">
								</div>
							</div>
							<div class="col-lg-4 col-md-6" id="work-sector-div_2">
								<div class="form-group" >
									<label class="control-label required"><liferay-ui:message key="secondary-sector-name" /></label>
									  <select name="<portlet:namespace/>worksector_2" id="worksector_2" class="form-control" onchange="getChildWorkSector(this.id,'first')" >
										<option value="" selected="selected"><liferay-ui:message key="select" /></option>
									</select>
									<p class="error-container" id="work-sector-error_2"></p>
								</div>
							</div>
							<div class="col-lg-4 col-md-6 d-none" id="div-o2-work-other_2">
								<div class="form-group">
									<label class="control-label "><liferay-ui:message key="secondary-sector-name-other" /></label>
									 <input type="text" name="<portlet:namespace/>worksectorother_2" id="worksectorother_2" class="form-control"> 
								</div>
							</div>
							<div class="col-lg-4 col-md-6 d-none" id="div-first-sub-sector_2">
								<div class="form-group">
									<label class="control-label "></label>
									<select name="<portlet:namespace/>first-sub-worksector_2" id="first-sub-worksector_2" class="form-control" onchange="getChildWorkSector2(this.id,'second')">
										<option value=""><liferay-ui:message key="select" /></option>
										<option value="other" selected="selected"><liferay-ui:message key="other" /></option>
									</select>
								</div>
							</div>
							<div class="col-lg-4 col-md-6  d-none " id="div-o3-work-other_2">
								<div class="form-group">
									<label class="control-label "></label>
									 <input type="text" name="<portlet:namespace/>work_sub_sectorother_2" id="worksectorother_2" class="form-control" value="">
								</div>
							</div>
								<div class="col-lg-4 col-md-6 d-none" id="div-second-sub-sector_2">
									<div class="form-group">
										<label class="control-label "></label>
										<select name="<portlet:namespace/>second-sub-worksector_2" id="second-sub-worksector_2" class="form-control"   onchange="getChildWorkSector3(this.id,'second')">
											<option value=""><liferay-ui:message key="select" /></option>
											<option value="other" selected="selected"><liferay-ui:message key="other" /></option>
										</select>
									</div>
								</div>
								<div class="col-lg-4 col-md-6  d-none " id="div-o3-secons-work-other_2">
									<div class="form-group">
										<label class="control-label "></label>
										 <input type="text" name="<portlet:namespace/>work_second_sub_sectorother_2" id="worksecondsectorother_2" class="form-control" value="">
									</div>
								</div>
							<div class="col-lg-4 col-md-6">
								<div class="form-group">
									<label class="control-label required"><liferay-ui:message key="region-location-secondary-institution" /></label> 
									<select name="<portlet:namespace/>wilayats_2" id="wilayats_2" class="form-control" onchange="validateField(this.id,'location-error_2','<liferay-ui:message key="please-enter-work-sector-location" />')">
										<option value=""><liferay-ui:message key="select" /></option>
										<c:forEach var="wilayats" items="${wilayats}">
											<option value="${wilayats.getKey()}">
												<liferay-ui:message key="${wilayats.getName(themeDisplay.getLocale())}" />
											</option>
										</c:forEach>
									</select>
									<p class="error-container" id="location-error_2"></p>
								</div>
							</div>
							<div class="col-lg-4 col-md-6">
								<div class="form-group">
									<label class="control-label required"><liferay-ui:message key="designation" /></label>
									 <select name="<portlet:namespace/>designations_2" id="designations_2" onchange="showDesignationOther(this.id,'designation-error_2','<liferay-ui:message key="please-enter-designation" />')" class="form-control designation">
										<option value=""><liferay-ui:message key="select" /></option>
										<c:forEach var="designations" items="${designations}">
											<option value="${designations.getKey()}">
												<liferay-ui:message key="${designations.getName(themeDisplay.getLocale())}" />
											</option>
										</c:forEach>
									</select>
									<p class="error-container" id="designation-error_2"></p>
								</div>
							</div>
							<div class="col-lg-4 col-md-6 d-none" id="designationotherdiv_2">
								<div class="form-group">
									<label class="control-label "><liferay-ui:message key="designation-other" /></label>
									 <input type="text" name="<portlet:namespace/>designationother_2" id="designationother_2" value="" class="form-control">
								</div>
							</div>
							<div class="col-lg-12 col-md-12">
								<div class="form-group">
									<label class="control-label"><liferay-ui:message key="staff-card-id" /></label>
									<div class="omsb-custom-html-file custom-file">
										<input id="staffIdCard_2" name="<portlet:namespace/>staffIdCard_2" type="file" label="" class="form-control custom-file-input"  onchange="validateFile(this.id,'file-size-error_2','<liferay-ui:message key="please-select-pdf-file" />')">
										<label class="custom-file-label" for="staffIdCard_2" id="customStaffIdCard_"> </label>
									</div>
									<p class="error-container" id="file-size-error_2"></p>
									<p class="error-container" id="errorContainer-work-detail-file_2"></p>
								</div>
							</div>
						</div>
						<div class="bottom-backbtn-wrap"></div>
					</div>
				</div>
			</c:when>
			<c:otherwise>
					<div class="omsb-card omsb-card-graybg omsb-noBorderRadius work_detail" id="work_detail_2">
						<input type="hidden" name="<portlet:namespace/>id_2" id="<portlet:namespace/>id_2" value="${secondaryWorkDetail.getId()}">	
						<div class="">
								<label class="control-label"><liferay-ui:message key="secondary-work-detail" /></label>
								<input type="hidden" name="<portlet:namespace/>isPrimary_2" id="<portlet:namespace/>isPrimary_2" value="false">
							<div class="row ">
									<div class="col-lg-4 col-md-6">
										<div class="form-group">
											<label class="control-label required"><liferay-ui:message key="secondary-workplace-sector-type" /></label>
												 <select name="<portlet:namespace/>workSectorType_2" id="workSectorType_2" class="form-control 3" onchange="getWorkSector(this.id)">
														<option value=""><liferay-ui:message key="select" /></option>
												<c:forEach var="workSectorType" items="${workSectorTypeList}">
													<option value="${workSectorType.getListTypeEntryId()}" ${workSectorType.getListTypeEntryId() == secondaryWorkDetail.getWorkSectorType() ? 'selected="selected"' : ''}>
														<liferay-ui:message key="${workSectorType.getName(themeDisplay.getLocale())}" />
													</option>
												</c:forEach>
											</select>
											<p class="error-container" id="work-sector-type-error_2"></p>
										</div>
									</div>									
									<c:choose>
										<c:when test="${not empty secondaryWorkDetail.getWorkSectorTypeOther()}">
											<div class="col-lg-4 col-md-6 " id="worksectorTypediv_2">
												<div class="form-group">
													<label class="control-label "><liferay-ui:message key="secondary-workplace-sector-type-other" /></label>
													 <input type="text" name="<portlet:namespace/>worksectortypeother_2" id="worksectortypeother_2" value="Other" class="form-control">
												</div>
											</div>
										</c:when>
										<c:otherwise>
											<div class="col-lg-4 col-md-6 d-none" id="worksectorTypediv_2">
												<div class="form-group">
													<label class="control-label "><liferay-ui:message key="secondary-workplace-sector-type-other" /></label>
													 <input type="text" name="<portlet:namespace/>worksectortypeother_2" id="worksectortypeother_2" value="Other" class="form-control">
												</div>
											</div>
										</c:otherwise>
									</c:choose>									
						<c:choose>
								<c:when test="${secondaryWorkDetail.workSectorId>0}">
									<div class="col-lg-4 col-md-6" id="work-sector-div_2">
										<div class="form-group" >
											<label class="control-label required"><liferay-ui:message key="secondary-sector-name" /></label> 
													<select name="<portlet:namespace/>worksector_2" id="worksector_2" class="form-control" onchange="getChildWorkSector(this.id,'first')" >
														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="workSector" items="${secondaryWorkDetail.workSectorItems.items}">
															<option value="${workSector.getId()}" ${workSector.getId() == secondaryWorkDetail.getWorkSectorId() ? 'selected="selected"' : ''}>
																${workSector.getWorkSector()}
															</option>
														</c:forEach>
														<option value="other"><liferay-ui:message key="other" /></option>
													</select>
											<p class="error-container" id="work-sector-error_2"></p>
										</div>
									</div>
							</c:when>								
							<c:when test="${not empty secondaryWorkDetail.workSectorOther}">
								<div class="col-lg-4 col-md-6" id="work-sector-div_2">
										<div class="form-group " >
											<label class="control-label required"><liferay-ui:message key="secondary-sector-name" /></label> 
													<select name="<portlet:namespace/>worksector_2" id="worksector_2" class="form-control" onchange="getChildWorkSector(this.id,'first')" >
														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="workSector" items="${secondaryWorkDetail.workSectorItems.items}">
															<option value="${workSector.getId()}" ${workSector.getId() == secondaryWorkDetail.getWorkSectorId() ? 'selected="selected"' : ''}>
																${workSector.getWorkSector()}
															</option>
														</c:forEach>
														<option value="other" selected="selected"><liferay-ui:message key="other"/></option>
													</select>
											<p class="error-container" id="work-sector-error_2"></p>
										</div>
									</div>						
							</c:when>
							<c:when test="${secondaryWorkDetail.workSectorId==0 && not empty secondaryWorkDetail.workSectorOther}">
								<div class="col-lg-4 col-md-6 " id="work-sector-div_2">
										<div class="form-group " >
											<label class="control-label required"><liferay-ui:message key="secondary-sector-name" /></label> 
											<select name="<portlet:namespace/>worksector_2" id="worksector_2" class="form-control" onchange="getChildWorkSector(this.id,'first')" >
												<option value=""><liferay-ui:message key="select" /></option>
												<option value="other" selected="selected"><liferay-ui:message key="other"/></option>
											</select>
											<p class="error-container" id="work-sector-error_2"></p>
										</div>
									</div>
							</c:when>
							<c:otherwise>
									<div class="col-lg-4 col-md-6 d-none" id="work-sector-div_2">
										<div class="form-group " >
											<label class="control-label required"><liferay-ui:message key="secondary-sector-name" /></label> 
											<select name="<portlet:namespace/>worksector_2" id="worksector_2" class="form-control" onchange="getChildWorkSector(this.id,'first')" >
												<option value=""><liferay-ui:message key="select" /></option>
												<option value="other" selected="selected"><liferay-ui:message key="other"/></option>
											</select>
											<p class="error-container" id="work-sector-error_2"></p>
										</div>
									</div>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${secondaryWorkDetail.workSectorId==0 && not empty secondaryWorkDetail.workSectorOther}">
								<div class="col-lg-4 col-md-6" id="div-o2-work-other_2">
									<div class="form-group">
										<label class="control-label "><liferay-ui:message key="secondary-sector-name-other" /></label>
										 <input type="text" name="<portlet:namespace/>worksectorother_2" id="worksectorother_2" class="form-control" value="${secondaryWorkDetail.workSectorOther}">
									</div>
								</div>
							</c:when>
							<c:when test="${secondaryWorkDetail.workSectorId==0 &&  empty secondaryWorkDetail.workSectorOther}">
								<div class="col-lg-4 col-md-6 d-none" id="div-o2-work-other_2">
									<div class="form-group">
										<label class="control-label "><liferay-ui:message key="secondary-sector-name-other" /></label>
										 <input type="text" name="<portlet:namespace/>worksectorother_2" id="worksectorother_2" class="form-control" value="${secondaryWorkDetail.workSectorOther}">
									</div>
								</div>
							</c:when>
							<c:otherwise>
								<div class="col-lg-4 col-md-6 d-none" id="div-o2-work-other_2">
										<div class="form-group">
											<label class="control-label "><liferay-ui:message key="secondary-sector-name-other" /></label>
											 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
											 <input type="text" name="<portlet:namespace/>worksectorother_2" id="worksectorother_2" class="form-control" value="">
										</div>
									</div>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${secondaryWorkDetail.workSectorId>0 &&  secondaryWorkDetail.workSectorId2>0}">
								<div class="col-lg-4 col-md-6" id="div-first-sub-sector_2">
									<div class="form-group">
										<label class="control-label "><%-- <liferay-ui:message key="secondary-first-sub-sector-name" /> --%></label>
										<select name="<portlet:namespace/>first-sub-worksector_2" id="first-sub-worksector_2" class="form-control" onchange="getChildWorkSector2(this.id,'second')">
										<option value=""><liferay-ui:message key="select" /></option>
										<c:forEach var="workSubSector" items="${secondaryWorkDetail.workSubSectorItems.items}">
											<option value="${workSubSector.getId()}" ${workSubSector.getId() == secondaryWorkDetail.getWorkSectorId2() ? 'selected="selected"' : ''}>
												${workSubSector.getWorkSector()}
											</option>
										</c:forEach>
										<option value="other"><liferay-ui:message key="other" /></option>
										</select>
									</div>
								</div>
							</c:when>
							<c:when test="${secondaryWorkDetail.workSectorId2==0 && not empty secondaryWorkDetail.workSectorOther2}">
								<div class="col-lg-4 col-md-6" id="div-first-sub-sector_2">
									<div class="form-group">
										<label class="control-label "></label>
										<select name="<portlet:namespace/>first-sub-worksector_2" id="first-sub-worksector_2" class="form-control" onchange="getChildWorkSector2(this.id,'second')">
											<option value=""><liferay-ui:message key="select" /></option>
											<c:forEach var="workSubSector" items="${secondaryWorkDetail.workSubSectorItems.items}">
												<option value="${workSubSector.getId()}" ${workSubSector.getId() == secondaryWorkDetail.getWorkSectorId2() ? 'selected="selected"' : ''}>
													${workSubSector.getWorkSector()}
												</option>
										</c:forEach>
										<option value="other" selected="selected"><liferay-ui:message key="other" /></option>
										</select>
									</div>
								</div>
							</c:when>
							<c:otherwise>
									<div class="col-lg-4 col-md-6 d-none" id="div-first-sub-sector_2">
										<div class="form-group">
											<label class="control-label "></label>
											<select name="<portlet:namespace/>first-sub-worksector_2" id="first-sub-worksector_2" class="form-control" onchange="getChildWorkSector2(this.id,'second')">
												<option value=""><liferay-ui:message key="select" /></option>
												<option value="other"><liferay-ui:message key="other" /></option>
											</select>
										</div>
									</div>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${ not empty secondaryWorkDetail.workSectorOther2}">
							<div class="col-lg-4 col-md-6 " id="div-o3-work-other_2">
								<div class="form-group">
									<label class="control-label "><%-- <liferay-ui:message key="secondary-sub-sector-name-other" /> --%></label>
									 <input type="text" name="<portlet:namespace/>work_sub_sectorother_2" id="worksectorother_2" class="form-control" value="${secondaryWorkDetail.workSectorOther2}">
								</div>
							</div>
							</c:when>
							<c:otherwise>
							<div class="col-lg-4 col-md-6  d-none " id="div-o3-work-other_2">
								<div class="form-group">
									<label class="control-label "><%-- <liferay-ui:message key="secondary-sub-sector-name-other" /> --%></label>
									 <input type="text" name="<portlet:namespace/>work_sub_sectorother_2" id="worksectorother_2" class="form-control" value="">
								</div>
							</div>
							</c:otherwise>
						</c:choose>
						<c:choose>
							<c:when test="${secondaryWorkDetail.workSectorId2>0 &&  secondaryWorkDetail.workSectorId3>0}">
								<div class="col-lg-4 col-md-6 1" id="div-second-sub-sector_2">
									<div class="form-group">
										<label class="control-label "></label>
										<select name="<portlet:namespace/>second-sub-worksector_2" id="second-sub-worksector_2" class="form-control"   onchange="getChildWorkSector3(this.id,'second')">
											<option value=""><liferay-ui:message key="select" /></option>
											<c:forEach var="workSecondSubSector" items="${secondaryWorkDetail.workSecondSubSectorItems.items}">
													<option value="${workSecondSubSector.getId()}" ${workSecondSubSector.getId() == secondaryWorkDetail.getWorkSectorId3() ? 'selected="selected"' : ''}>
														${workSecondSubSector.getWorkSector()}
													</option>
										</c:forEach>
										<option value="other"><liferay-ui:message key="other" /></option>
										</select>
									</div>
								</div>
							</c:when>
							<c:when test="${secondaryWorkDetail.workSectorId3==0 && not empty secondaryWorkDetail.workSectorOther3}">
									<div class="col-lg-4 col-md-6 2" id="div-second-sub-sector_2">
										<div class="form-group">
											<label class="control-label "></label>
											<select name="<portlet:namespace/>second-sub-worksector_2" id="second-sub-worksector_2" class="form-control"   onchange="getChildWorkSector3(this.id,'second')">
											<option value=""><liferay-ui:message key="select" /></option>
											<c:forEach var="workSecondSubSector" items="${secondaryWorkDetail.workSecondSubSectorItems.items}">
												<option value="${workSecondSubSector.getId()}">
													${workSecondSubSector.getWorkSector()}
												</option>
										</c:forEach>
										<option value="other" selected="selected"><liferay-ui:message key="other" /></option>
										</select>
										</div>
									</div>
							</c:when>
							<c:otherwise>
								<div class="col-lg-4 col-md-6 3 d-none" id="div-second-sub-sector_2">
									<div class="form-group">
										<label class="control-label "></label>
										<select name="<portlet:namespace/>second-sub-worksector_2" id="second-sub-worksector_2" class="form-control"   onchange="getChildWorkSector3(this.id,'second')">
											<option value=""><liferay-ui:message key="select" /></option>
											<option value="other"><liferay-ui:message key="other" /></option>
										</select>
									</div>
								</div>
							</c:otherwise>									
						</c:choose>
							<c:choose>
								<c:when test="${secondaryWorkDetail.workSectorId3==0 &&  not empty secondaryWorkDetail.workSectorOther3}">
								<div class="col-lg-4 col-md-6" id="div-o3-secons-work-other_2">
									<div class="form-group">
										<label class="control-label "></label>
										 <input type="text" name="<portlet:namespace/>work_second_sub_sectorother_2" id="worksecondsectorother_2" class="form-control" value="${secondaryWorkDetail.workSectorOther3}">
									</div>
								</div>
								</c:when>
								<c:otherwise>
								<div class="col-lg-4 col-md-6 d-none " id="div-o3-secons-work-other_2">
									<div class="form-group">
										<label class="control-label "></label>
										 <input type="text" name="<portlet:namespace/>work_second_sub_sectorother_2" id="worksecondsectorother_2" class="form-control" value="">
									</div>
								</div>
								</c:otherwise>
							</c:choose>
								<div class="col-lg-4 col-md-6">
									<div class="form-group">
										<label class="control-label required"><liferay-ui:message key="region-location-secondary-institution" /></label>
												<select name="<portlet:namespace/>wilayats_2" id="wilayats_2" class="form-control" onchange="validateField(this.id,'location-error_2','<liferay-ui:message key="please-enter-work-sector-location" />')">											
											<option value=""><liferay-ui:message key="select" /></option>
											<c:forEach var="wilayats" items="${wilayats}">
												<option value="${wilayats.getKey()}" ${wilayats.getKey() == secondaryWorkDetail.getWorkSectorLocation() ? 'selected' : ''}>
													<liferay-ui:message key="${wilayats.getName(themeDisplay.getLocale())}" />
												</option>
											</c:forEach>
										</select>
										<p class="error-container" id="location-error_2"></p>
									</div>
								</div>								
								<div class="col-lg-4 col-md-6">
									<div class="form-group">
										<label class="control-label required"><liferay-ui:message key="designation" /></label>
											<select name="<portlet:namespace/>designations_2" id="designations_2" onchange="showDesignationOther(this.id,'designation-error_2','<liferay-ui:message key="please-enter-designation" />')" class="form-control designation">
											<option value=""><liferay-ui:message key="select" /></option>
											<c:forEach var="designations" items="${designations}">
												<option value="${designations.getKey()}" ${designations.getKey() == secondaryWorkDetail.getDesignationId() ? 'selected="selected"' : ''}>
													<liferay-ui:message key="${designations.getName(themeDisplay.getLocale())}" />
												</option>
											</c:forEach>
										</select>
										<p class="error-container" id="designation-error_2"></p>
									</div>
								</div>								
								<div class="col-lg-4 col-md-6 d-none" id="designationotherdiv_2">
									<div class="form-group">
										<label class="control-label "><liferay-ui:message key="designation-other" /></label> 
										<input type="text" name="<portlet:namespace/>designationother_2" id="designationother_2" value="${secondaryWorkDetail.getDesignationOther() }" class="form-control">
									</div>
								</div>							
								<div class="col-lg-12 col-md-12">
									<div class="row">
									  <div class="col-lg-10 col-md-10">
											<div class="form-group">
												<label class="control-label"><liferay-ui:message key="staff-card-id" /></label>
												<div class="omsb-custom-html-file custom-file">
													<input id="staffIdCard_2" name="<portlet:namespace/>staffIdCard_2"   type="file" label="" class="form-control custom-file-input" onchange="validateFile(this.id,'file-size-error_2','<liferay-ui:message key="please-select-pdf-file" />')">
													<label class="custom-file-label" for="staffIdCard_2" id="customStaffIdCard_2">
													 <c:if test="${not empty secondaryWorkDetail.getStaffIdCard()}">
														  ${secondaryWorkDetail.getUploadFileName()}
													 </c:if>
													</label>
													<c:choose>
														<c:when test="${not empty secondaryWorkDetail.getStaffIdCard()}">
															<input type="hidden" id="uploadFile_2" value="${secondaryWorkDetail.getStaffIdCard()}" name="<portlet:namespace/>uploadFile_2" />
														</c:when>
														<c:otherwise>
															<input type="hidden" id="uploadFile_2" value="" name="<portlet:namespace/>uploadFile_2" />
														</c:otherwise>
													</c:choose>
												</div>	
												   <p class="error-container" id="file-size-error_2"></p>
													<p class="error-container"id="errorContainer-work-detail-file_2"></p>
											</div>
										</div>
										<div class="col-lg-2 col-md-2">
										   <div class="form-group">
											<label class="control-label"></label>
												<a class="btn view_btn text-danger"  title="<liferay-ui:message key="view" />" target="_blank" href="${secondaryWorkDetail.getDocumentUrl() }">
													<img src="<%=themeDisplay.getPathThemeImages()%>/svg/view_icon.svg" alt=""> <liferay-ui:message key="view-file" />
												</a>
											</div>
										</div>
									</div>
								 </div>	
								</div>
							</div>
						</div>
				</c:otherwise>
			</c:choose>								
			 <div class="omsb-page-top-info mb-4">
				<h3 class="reg-form-title w-auto"></h3>
				<div class="information"><button type="button" class="btn omsb-bg-red-button" id="add_work_detail" onClick="openWorkDetailOpenAddModel(this)"  data-target="#add-work-detail-confirm-modal" data-toggle="modal"><img src="../images/svg/plus_img.svg" alt=""> Add More</button></div>
			</div> 
		</div>							
							 <div id="workDetailList">
								<c:choose>
									<c:when test="${!empty pastWorkDetails}">
										<table class="display omsb-datatables" id="work-detail-list1" width="100%">
											<thead>
												<tr>
													<th><liferay-ui:message key="workplace-sector-type" /></th>
													<th><liferay-ui:message key="sector-name" /></th>
													<th><liferay-ui:message key="region-locationS-institution" /></th>
													<th><liferay-ui:message key="designation" /></th>
													<th><liferay-ui:message key="action" /></th>
												</tr>
											</thead>
											<tbody>
											 <c:forEach var="pastWorkDetail" items="${pastWorkDetails}"> 
												<tr>
													<td>${pastWorkDetail.getWorkSectorType()}</td>
													<td>${pastWorkDetail.getWorkSector()}</td>
													<td>${pastWorkDetail.getWorkSectorLocation()}</td>
													<td>${pastWorkDetail.getDesignationId()}</td>
													<td>
														<button class="btn delete_btn" value="Delete" type="button" data-toggle="modal" data-target="#delete-work-confirm-modal" data-rowcount="addPopUpRow" onclick="setDeleteID('${pastWorkDetail.id}')" ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/delete_icon.svg" style="cursor: default;"></button>
														<button class="btn mx-2" value="view" type="button" data-toggle="modal" data-target="#add-work-detail-confirm-modal" onclick="setWorkDetailEditID('${pastWorkDetail.id}')" ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg"></button>
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
						</div>						
                        <div class="col-lg-12 col-md-12">
                             <div class="row">
                                     <div class="col-lg-10 col-md-10">
                                         <div class="form-group">
                                                 <label class="control-label required"><liferay-ui:message key="cv-document" /></label>
                                                 <div class="custom-file">
                                                         <input type="file" name="<portlet:namespace/>cvDocument" id="cvDocument" class="form-control custom-file-input" value="${cvDocument}"
                                                                 onchange="validateFile(this.id,'errorContainer-cvDocument','cvDocument','<liferay-ui:message key="please-select-pdf-file" />')">
                                                         <label class="custom-file-label" for="cvDocument"> ${cvDocument} </label>
                                                 </div>
                                         </div>
                                         <p id="errorContainer-cvDocument" class="error-container"></p>
                                     </div>
                                  <div class="col-lg-2 col-md-2">
                                      <div class="form-group">
                                              <label class="control-label"></label>
                                              <c:if test="${not empty cvDocumentURL}">
                                                      <a href="${cvDocumentURL}" class="btn view_btn text-danger" target="_blank"><img src="<%=themeDisplay.getPathThemeImages()%>/svg/view_icon.svg" alt="">
                                                      <liferay-ui:message key="view" /></a>
                                              </c:if>
                                      </div>
                                  </div>
                             </div>                                               
                         </div>
						<div class="reg_step4 mt-4" id="reg_step4">
							<div class="omsb-page-top-info mb-4">
								<h3 class="reg-form-title w-auto"><liferay-ui:message key="role-service" /></h3>
								<c:if test="${not hasPendingRole}"> 
										<div class="information"><button type="button" class="btn omsb-bg-red-button" id="add_role-service" onClick="openRoleServiceOpenAddModel(this)"  data-target="#add-role-service-confirm-modal" data-toggle="modal"><liferay-ui:message key="add-more"/></button></div>	
								 </c:if> 
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
									</c:when>
									<c:otherwise>
										<liferay-ui:message key="no-records-found" />
									</c:otherwise>
								</c:choose>
						</div>
						</div>
						 <div class="bottom-backbtn-wrap">
							<c:choose>
								<c:when test="${userVerificationProfileStatus eq 'reject' || userVerificationProfileStatus eq 'approve' || userVerificationProfileStatus eq 'NA' || userVerificationRoleStatus eq 'reject' || userVerificationRoleStatus eq 'approve' || userVerificationRoleStatus eq 'NA'}">
									<button class="btn omsb-bc-red-button" id="save-btn" onClick="validateAndSaveFormData('save')" type="button" title="<liferay-ui:message key='resubmit' />"><liferay-ui:message key="resubmit" /></button>
								</c:when>
								<c:otherwise>
								<button  disabled="disabled" class="btn omsb-bc-red-button" onClick="validateAndSaveFormData('save')" type="button" title="<liferay-ui:message key='save' />"><liferay-ui:message key="save" /></button>
								</c:otherwise>
							</c:choose>			
							<button class="btn omsb-bg-red-button" id="registration-cancel" type="button" title="<liferay-ui:message key='back' />"><liferay-ui:message key="back" /></button>
						</div> 
					</form>
				</div>
			</div>
		</div>
	</section>
</div>
		<div class="modal fade omsb-modal" id="delete-education-confirm-modal" tabindex="-1" role="dialog"
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
						<button class="btn omsb-bc-red-button" type="button" onclick="deleteEduSection()" title="<liferay-ui:message key='ok'/>" ><liferay-ui:message key="yes" /></button>
						<button type="button" class="btn omsb-btn omsb-bg-red-button"
							data-dismiss="modal" id="uploadcancel"><liferay-ui:message key="no" /></button>
					</div>
				</div>
			</div>
		</div>
		<div class="modal fade omsb-modal" id="add-education-confirm-modal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered w-50" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle"></h5>
						<button type="button" onClick="clearForm()"  class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<portlet:actionURL name="<%=MVCCommands.EDUCATION_DETAILS_MVCACTION%>" var="educationalDetailMVCActionURL"/>
						<form  class="" name="<portlet:namespace/>edFM"  id="edFM" action="${educationalDetailMVCActionURL}" method="post" enctype="multipart/form-data">
								<div class="reg_step2"  id="reg_step2">
									<div class="omsb-page-top-info mb-4">
										<h3 class="reg-form-title w-auto"><liferay-ui:message key="education-details" /> </h3>
									</div>
									<div id="edu_detail_area">
										<div class="omsb-card omsb-card-graybg omsb-noBorderRadius edu_detail element bottom-backbtn-wrap pt-4" id="edu_detail" >
											<div class="row ">
												<div class="col-lg-6 col-md-6">
													<div class="form-group">
														<label class="control-label required"><liferay-ui:message key="qualification-title" />  </label>
														<select  name="<portlet:namespace/>qualification" id="qualification" class="form-control">
															<option value=""><liferay-ui:message key="select" /></option>
															<c:forEach var="qualification" items="${qualificationList}">
																<option value="${qualification.getKey()}">
																	<liferay-ui:message key="${qualification.getName(themeDisplay.getLocale())}" />
																</option>
															</c:forEach>
														</select>
														<p id="errorContainer-qualification" class="error-container"></p>
													</div>
												</div>												
												<div class="col-lg-6 col-md-6 d-none" id="qualificationOtherDiv">
													<div class="form-group">
														<label class="control-label required"><liferay-ui:message key="qualification-other" /></label>
														<input  type="text" name="<portlet:namespace/>qualificationOther" id="qualificationOther" class="form-control" value="${qualificationOther}" >
													</div>
													<p id="errorContainer-qualification" class="error-container"></p>
												</div>
												<div class="col-lg-6 col-md-6">
													<div class="form-group">
														<label class="control-label"><liferay-ui:message key="country-of-institution" /></label>
														<select  name="<portlet:namespace/>country" id="country" class="form-control" onchange="getInstitutionDetails(this.value);">
															<option value=""><liferay-ui:message key="select" /></option>
															<c:forEach var="country" items="${countries}">
																<option value="${country.countryId}">
																	<liferay-ui:message key="${country.getName(themeDisplay.getLocale())}" />
																</option>
															</c:forEach>
														</select>
														<p id="errorContainer-country" class="error-container"></p>
													</div>
												</div>	
												<div class="col-lg-6 col-md-6">
													<div class="form-group">
														<label class="control-label"><liferay-ui:message key="institution" /></label>
														<select  name="<portlet:namespace/>institution" id="institution" class="form-control">
															<option value=""><liferay-ui:message key="select" /></option>
															<c:forEach var="institution" items="${institutionList}">
																<option value="${institution.getKey() }">
																	<liferay-ui:message key="${institution.getName(themeDisplay.getLocale())}" />
																</option>
															</c:forEach>
														</select>
														<p id="errorContainer-institution" class="error-container"></p>
													</div>
												</div>												
												<div class="col-lg-6 col-md-6 d-none" id="institutionOtherDiv">
													<div class="form-group">
														<label class="control-label required"><liferay-ui:message key="institution-other" /></label>
														<input  type="text" name="<portlet:namespace/>institutionOther" id="institutionOther" class="form-control" value="${institutionOther}" >
													</div>
													<p id="errorContainer-institution" class="error-container"></p>
												</div>
												<input type="hidden" name="id" id="id">
												<div class="col-lg-6 col-md-6">
													<div class="form-group">
														<label class="control-label"><liferay-ui:message key="year-of-graduation" /></label>
														<select  name="<portlet:namespace/>year" id="year" class="form-control">
															<option value=""><liferay-ui:message key="select"/></option>
															<% int currentYear = Calendar.getInstance().get(Calendar.YEAR); %>
															<c:forEach  begin="1970"  end="${year}" step="1" var="age">
															    <c:set var="decr" value="${(year-age)+1970}"/>
															    <option value="${decr}"}>${decr}</option>
															</c:forEach>
														</select>
														<p id="errorContainer-year-of-graducation" class="error-container"></p>
													</div>
												</div>
												<div class="col-lg-12 col-md-12">
													<div class="d-flex align-items-center">
													<div class="form-group">
														<label class="control-label"><liferay-ui:message key="qualification-document" /></label>
														<div class="custom-file">
															<div>
																<input type="file" name="qualificationdoc" id="qualificationdoc" value=""
																class="form-control custom-file-input">
															</div>
															<label class="custom-file-label" for="qualificationdoc" id="qualificationdoclbl"></label>
														</div>
														 <p id="errorContainer-qualification-document" class="error-container"></p> 
													</div>
													<div class="text-right d-none" id="view-div" style="width:140px;">
														<a class="btn view_btn text-danger p-0"  id="view-file" title="<liferay-ui:message key="view" />" target="_blank" href="#">
																<img src="<%=themeDisplay.getPathThemeImages()%>/svg/view_icon.svg" alt=""> <liferay-ui:message key="view-file" />
															</a>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>
									<div class="bottom-backbtn-wrap">
										<button class="btn omsb-bc-red-button" onClick="saveEducationDetails()" type="button" title="<liferay-ui:message key='add-update'/>"><liferay-ui:message key="add-update"/></button>
									</div>
								</div>
								<input type="hidden" name="<portlet:namespace/>isNext" id="isNext" value="false">
								<input type="hidden" value="${personId}" name="<portlet:namespace/>personId" id="personId"/>
								<input type="hidden" value="${lrUserId}" name="<portlet:namespace/>lrUserId" id="lrUserId"/>
								<input type="hidden" value="" name="deleteID" id="deleteID"/>
							</form>
					</div>
				</div>
			</div>
		</div>
		<div class="modal fade omsb-modal" id="add-work-detail-confirm-modal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered w-50" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="add-work-details" /></h5>
						<button type="button" onClick="clearForm()"  class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form  class="" name="<portlet:namespace/>workDetailFM"  id="workDetailFM" action="${educationalDetailMVCActionURL}" method="post" enctype="multipart/form-data">
								<div class="reg_step2"  id="reg_step2">
									<div class="omsb-page-top-info mb-4">
										<h3 class="reg-form-title w-auto"><liferay-ui:message key="work-details" /> </h3>
									</div>	
									<div class="omsb-card omsb-card-graybg omsb-noBorderRadius work_detail" id="work_detail_3">
										<input type="hidden" name="<portlet:namespace/>id_3" id="<portlet:namespace/>id_3"> 
										<input type="hidden" name="<portlet:namespace/>isPrimary_3" id="<portlet:namespace/>isPrimary_3" value="true">
											<div class="">
												<label class="control-label"><liferay-ui:message key="primary-work-detail" /></label>
												<div class="row ">
													<div class="col-lg-4 col-md-6">
														<div class="form-group">
															<label class="control-label  required"><liferay-ui:message key="workplace-sector-type" /></label> 
															<select name="<portlet:namespace/>workSectorType_3" id="workSectorType_3" class="form-control" onchange="getWorkSector(this.id)">
																<option value=""><liferay-ui:message key="select" /></option>
																<c:forEach var="workSectorType" items="${workSectorTypeList}">
																	<option value="${workSectorType.getListTypeEntryId()}"> <liferay-ui:message key="${workSectorType.getName(themeDisplay.getLocale())}" /></option>
																</c:forEach>
															</select>
															<p class="error-container" id="work-sector-type-error_3"></p>
														</div>
													</div>
													<div class="col-lg-4 col-md-6 d-none" id="worksectorTypediv_3">
																<div class="form-group">
																	<label class="control-label "><liferay-ui:message key="workplace-sector-type-other" /></label>
																	 <input type="text" name="<portlet:namespace/>worksectortypeother_3" id="worksectortypeother_3" value="Other" class="form-control">
																</div>
													</div>
													<div class="col-lg-4 col-md-6" id="work-sector-div_3">
														<div class="form-group" >
															<label class="control-label required"><liferay-ui:message key="sector-name" /></label>
															<select name="<portlet:namespace/>worksector_3" id="worksector_3" class="form-control" onchange="getChildWorkSector(this.id,'first')" >
																<option value="" selected="selected"><liferay-ui:message key="select" /></option>
															</select>
															<p class="error-container" id="work-sector-error_3"></p>
														</div>
													</div>
													<div class="col-lg-4 col-md-6 d-none" id="div-o2-work-other_3">
														<div class="form-group">
															<label class="control-label "><liferay-ui:message key="sector-name-other" /></label>
															 <input type="text" name="<portlet:namespace/>worksectorother_3" id="worksectorother_3" class="form-control"> 
														</div>
													</div>
													<div class="col-lg-4 col-md-6 d-none" id="div-first-sub-sector_3">
															<div class="form-group">
																<label class="control-label "><%-- <liferay-ui:message key="first-sub-sector-name" /> --%></label>
																<select name="<portlet:namespace/>first-sub-worksector_3" id="first-sub-worksector_3" class="form-control" onchange="getChildWorkSector2(this.id,'second')">
																	<option value=""><liferay-ui:message key="select" /></option>
																	<option value="other" selected="selected"><liferay-ui:message key="other" /></option>
																</select>
															</div>
													</div>
													<div class="col-lg-4 col-md-6  d-none " id="div-o3-work-other_3">
															<div class="form-group">
																<label class="control-label "><%-- <liferay-ui:message key="sub-sector-name-other" /> --%></label>
																 <input type="text" name="<portlet:namespace/>work_sub_sectorother_3" id="work_sub_sectorother_3" class="form-control" value="">
															</div>
													</div>
														<div class="col-lg-4 col-md-6 d-none" id="div-second-sub-sector_3">
															<div class="form-group">
																<label class="control-label "><%-- <liferay-ui:message key="second-sub-sector-name" /> --%></label>
																<select name="<portlet:namespace/>second-sub-worksector_3" id="second-sub-worksector_3" class="form-control"   onchange="getChildWorkSector3(this.id,'second')">
																	<option value=""><liferay-ui:message key="select" /></option>
																	<option value="other" selected="selected"><liferay-ui:message key="other" /></option>
																</select>
															</div>
														</div>
														<div class="col-lg-4 col-md-6  d-none " id="div-o3-secons-work-other_3">
																<div class="form-group">
																	<label class="control-label "><%-- <liferay-ui:message key="second-sub-sector-name-other" /> --%></label>
																	 <input type="text" name="<portlet:namespace/>work_second_sub_sectorother_3" id="worksecondsectorother_3" class="form-control" value="">
																</div>
														</div>
													<div class="col-lg-4 col-md-6">
														<div class="form-group">
															<label class="control-label required"><liferay-ui:message key="region-location-institution" /></label> 
															<select name="<portlet:namespace/>wilayats_3" id="wilayats_3" class="form-control" onchange="validateField(this.id,'location-error_3','<liferay-ui:message key="please-enter-work-sector-location" />')">
																<option value=""><liferay-ui:message key="select" /></option>
																<c:forEach var="wilayats" items="${wilayats}">
																	<option value="${wilayats.getKey()}">
																		<liferay-ui:message key="${wilayats.getName(themeDisplay.getLocale())}" />
																	</option>
																</c:forEach>
															</select>
															<p class="error-container" id="location-error_3"></p>
														</div>
													</div>
													<div class="col-lg-4 col-md-6">
														<div class="form-group">
															<label class="control-label required"><liferay-ui:message key="designation" /></label>
															 <select name="<portlet:namespace/>designations_3" id="designations_3" onchange="showDesignationOther(this.id,'designation-error_3','<liferay-ui:message key="please-enter-designation" />')" class="form-control designation">
																<option value=""><liferay-ui:message key="select" /></option>
																<c:forEach var="designations" items="${designations}">
																	<option value="${designations.getKey()}">
																		<liferay-ui:message key="${designations.getName(themeDisplay.getLocale())}" />
																	</option>
																</c:forEach>
															</select>
															<p class="error-container" id="designation-error_3"></p>
														</div>
													</div>
													<div class="col-lg-4 col-md-6 d-none" id="designationotherdiv_3">
														<div class="form-group">
															<label class="control-label "><liferay-ui:message key="designation-other" /></label>
															 <input type="text" name="<portlet:namespace/>designationother_3" id="designationother_3" value="" class="form-control">
														</div>
													</div>
													<div class="col-lg-12 col-md-12">
														<div class="form-group">
															<label class="control-label"><liferay-ui:message key="staff-card-id" /></label>
															<div class="omsb-custom-html-file custom-file">
																<input id="staffIdCard_3" name="<portlet:namespace/>staffIdCard_3" type="file" label="" class="form-control custom-file-input"  onchange="validateFile(this.id,'file-size-error_3','<liferay-ui:message key="please-select-pdf-file" />')">
																<label class="custom-file-label" for="staffIdCard_3" id="customStaffIdCard_3"> </label>
															</div>
															<p class="error-container" id="file-size-error_3"></p>
															<p class="error-container" id="errorContainer-work-detail-file_3"></p>
														</div>
													</div>
												</div>
												<div class="bottom-backbtn-wrap"></div>
											</div>
										</div>
									<div class="bottom-backbtn-wrap">
										<button class="btn omsb-bc-red-button" onClick="saveWorkDetailsDetails()" type="button" title="<liferay-ui:message key='add-update'/>"><liferay-ui:message key="add-update"/></button>
									</div>
								</div>
								<input type="hidden" name="<portlet:namespace/>isNext" id="isNext" value="false">
								<input type="hidden" value="${personId}" name="<portlet:namespace/>personId" id="personId"/>
								<input type="hidden" value="${lrUserId}" name="<portlet:namespace/>lrUserId" id="lrUserId"/>
								<input type="hidden" value="" name="deleteID" id="deleteID"/>
							</form>
					</div>
				</div>
			</div>
		</div>
		<div class="modal fade omsb-modal" id="delete-work-confirm-modal" tabindex="-1" role="dialog"
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
						<button class="btn omsb-bc-red-button" type="button" onclick="deleteWorkSection()" title="<liferay-ui:message key='ok'/>" ><liferay-ui:message key="yes" /></button>
						<button type="button" class="btn omsb-btn omsb-bg-red-button"
							data-dismiss="modal" id="uploadcancel"><liferay-ui:message key="no" /></button>
					</div>
				</div>
			</div>
		</div>
		<div class="modal fade omsb-modal" id="add-role-service-confirm-modal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered w-50" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="registration-role-service"/></h5>
						<button type="button" onClick="clearForm()"  class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">						
				<portlet:actionURL name="<%=MVCCommands.ROLE_SERVICE_MVCACTION%>" var="roleServiceMVCActionURL"/>
					<form name="<portlet:namespace/>rnsFM" class="" id="rnsFM" action="${roleServiceMVCActionURL}" method="post">
						<div class="reg_step4" id="reg_step4">
							<div class="d-flex">
								<div class="w-50 role-section-1">
									<label class="control-label"><liferay-ui:message key="are-you-associated-with-omsb" /></label>
								</div>
								<div class="form-group  yesorno role-section-1">
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
							 <div class="omsb-card omsb-card-graybg omsb-noBorderRadius" id="associated_detail_area" >
								<div class="row ">
									<div class="col-lg-4 col-md-6" id="roleDiv_1">
										<div class="form-group">
											<label class="control-label "><liferay-ui:message key="role"/></label>
											<select  name="<portlet:namespace/>role_1" id="role_1" class="form-control">
												<option value=""><liferay-ui:message key="select" /></option>
												<c:forEach var="omsbRoles" items="${omsbRoleList}">
													<option value="${omsbRoles.roleId}">
														${omsbRoles.name}
													</option>
												</c:forEach>
											</select>
											<p id="errorContainer-role_1" class="error-container"></p>
										</div>
									</div>									
									<div class="col-lg-4 col-md-6" id="departmentDiv_1">
										<div class="form-group">
											<label class="control-label"><liferay-ui:message key="department"/></label>
											<select  name="<portlet:namespace/>department_1" id="department_1" class="form-control">
												<option value=""><liferay-ui:message key="select" /></option>
												<c:forEach var="department" items="${departmentList}">
													<%-- <option value="${department.getKey()}"  <c:if test="${userMetadata.departmentId == department.getKey()}">selected="selected"</c:if>> --%>
													<option value="${department.getKey()}">
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
											<input type="text" name="<portlet:namespace/>departmentOther_1" id="departmentOther_1" class="form-control" value="${departmentOther}" >
										</div>
										<p id="errorContainer-departmentOther_1" class="error-container"></p>
									</div>									
									<div class="col-lg-4 col-md-6" id="sectionDiv_1">
										<div class="form-group">
											<label class="control-label"><liferay-ui:message key="section"/></label>
											<select  name="<portlet:namespace/>section_1" id="section_1" class="form-control">
												<option value=""><liferay-ui:message key="select"/></option>
												<c:forEach var="section" items="${sectionList}">
													<option value="${section.getKey()}" >
														<liferay-ui:message key="${section.getName(themeDisplay.getLocale())}" />
													</option>
												</c:forEach>
											</select>
											<p id="errorContainer-section_1" class="error-container"></p>
										</div>
									</div>									
									<div class="col-lg-4 col-md-6" id="committeDiv_1" >
										<div class="form-group">
											<label class="control-label"><liferay-ui:message key="committe" /></label>
											<select name="<portlet:namespace/>committe_1" id="committe_1" class="form-control">
												<option value=""><liferay-ui:message key="select" /></option>
												<c:forEach var="committe" items="${committeList}">
														<option value="${committe.getKey()}"  <c:if test="${userMetadata.committeeId == committe.getKey()}">selected="selected"</c:if>>
															${committe.getName(themeDisplay.getLocale())}
														</option>
													</c:forEach>
											</select>
											<p id="errorContainer-committe_1" class="error-container"></p>
										</div>
									</div>
									<div class="col-lg-4 col-md-6 d-none" id="committeOtherDiv_1">
										<div class="form-group">
											<label class="control-label required"><liferay-ui:message key="committe-other" /></label>
											<input  type="text" name="<portlet:namespace/>committeOther_1" id="committeOther_1" class="form-control" value="${committeOther}" >
										</div>
										<p id="errorContainer-committeOther_1" class="error-container"></p>
									</div>									
									<div class="col-lg-4 col-md-6" id="functionDiv_1">
										<div class="form-group">
											<label class="control-label"><liferay-ui:message key="function"/></label>
											<select  name="<portlet:namespace/>function_1" id="function_1" class="form-control">
												<option value=""><liferay-ui:message key="select" /></option>
												<c:forEach var="function" items="${functionList}">
													<option value="${function.getKey()}">
														<liferay-ui:message key="${function.getName(themeDisplay.getLocale())}" />
													</option>
												</c:forEach>
											</select>
											<p id="errorContainer-function_1" class="error-container"></p>
										</div>
									</div>									
									<div class="col-lg-4 col-md-6" id="programtypeDiv_1">
										<div class="form-group">
											<label class="control-label"><liferay-ui:message key="program-type" /></label>
											<select  name="<portlet:namespace/>programtype_1" id="programtype_1" class="form-control" >
												<option value=""><liferay-ui:message key="select" /></option>
												<c:forEach var="programTypeMaster" items="${programTypeMasterList}">
													<option value="${programTypeMaster.programTypeMasterId}" >
														<liferay-ui:message key="${programTypeMaster.programTypeName}" />
													</option>
												</c:forEach>
											</select>
											<p id="errorContainer-programtype_1" class="error-container"></p>
										</div>
									</div>									
									<div class="col-lg-4 col-md-6" id="programDiv_1">
										<div class="form-group">
											<label class="control-label"><liferay-ui:message key="program" /> </label>
											<select  name="<portlet:namespace/>program_1" id="program_1" class="form-control" >
												<option value=""><liferay-ui:message key="select" /></option>
												<c:forEach var="program" items="${programList}">
													<option value="${program.programMasterId}">
														<liferay-ui:message key="${program.programName}" />
													</option>
												</c:forEach>
											</select>
											<p id="errorContainer-program_1" class="error-container"></p>
										</div>
									</div>									
									<div class="col-lg-4 col-md-6" id="programPositionDiv_1">
										<div class="form-group">
											<label class="control-label"><liferay-ui:message key="program-position" /> </label>
											<select name="<portlet:namespace/>programPosition_1" id="programPosition_1" class="form-control" >
												<option value=""><liferay-ui:message key="select" /></option>
												<c:forEach var="programPosition" items="${programPositionList}">
													<option value="${programPosition.getKey()}" <c:if test="${userMetadata.programPositionId == programPosition.getKey()}">selected="selected"</c:if>>
														${programPosition.getName(themeDisplay.getLocale())}
													</option>
												</c:forEach>
											</select>
											<p id="errorContainer-program-position_1" class="error-container"></p>
										</div>
									</div>									
									<div class="col-lg-4 col-md-6" id="purposeDiv_1">
										<div class="form-group">
											<label class="control-label"><liferay-ui:message key="purpose" /> </label>
											<select name="<portlet:namespace/>purpose_1" id="purpose_1" class="form-control" >
												<option value=""><liferay-ui:message key="select" /></option>
												<c:forEach var="purpose" items="${purposeList}">
													<option value="${purpose.getKey()}" <c:if test="${userMetadata.purposeId == purpose.getKey()}">selected="selected"</c:if>>
														${purpose.getName(themeDisplay.getLocale())}
													</option>
												</c:forEach>
											</select>
											<p id="errorContainer-purpose_1" class="error-container"></p>
										</div>
									</div>
								</div>
								</div>
							</div> 									
							 <div class="d-none" id="registrant_detail_area" >
								<div class="d-flex">
									<div class="w-50 role-section-2">
										<label class="control-label"><liferay-ui:message key="are-you-registering-for-role-or-service" /></label>
									</div>
									<div class="form-group yesorno role-section-2">
										<div class="custom-control custom-radio ">
											<input type="radio" name="<portlet:namespace/>registering" class="custom-control-input" id="registering_yes" value="1" checked>
											<label class="custom-control-label m-0" for="registering_yes"><liferay-ui:message key="role" /></label>
										</div>
										<div class="custom-control custom-radio ">
													<input type="radio" name="<portlet:namespace/>registering" class="custom-control-input" id="registering_no" value="0">
													<label class="custom-control-label m-0" for="registering_no"><liferay-ui:message key="service" /></label>
												</div>
									</div>
								</div>
									<div class="omsb-card omsb-card-graybg omsb-noBorderRadius " id="role_detail_area">
										<div class="row ">
											<div class="col-lg-4 col-md-6" id="roleDiv_2">
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
											<div class="col-lg-4 col-md-6" id="departmentDiv_2">
												<div class="form-group">
													<label class="control-label"><liferay-ui:message key="department" /></label>
													<select  name="<portlet:namespace/>department_2" id="department_2" class="form-control">
														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="department" items="${departmentList}">
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
													<input  type="text" name="<portlet:namespace/>departmentOther_2" id="departmentOther_2" class="form-control" value="${departmentOther}" >
												</div>
												<p id="errorContainer-departmentOther_2" class="error-container"></p>
											</div>											
											<div class="col-lg-4 col-md-6" id="sectionDiv_2">
												<div class="form-group">
													<label class="control-label"><liferay-ui:message key="section" /></label>
													<select  name="<portlet:namespace/>section_2" id="section_2" class="form-control">
														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="section" items="${sectionList}">
															<option value="${section.getKey()}">
																<liferay-ui:message key="${section.getName(themeDisplay.getLocale())}" />
															</option>
														</c:forEach>
													</select>
													<p id="errorContainer-section_2" class="error-container"></p>
												</div>
											</div>											
											<div class="col-lg-4 col-md-6" id="committeDiv_2">
												<div class="form-group">
													<label class="control-label"><liferay-ui:message key="committee" /></label>
													<select  name="<portlet:namespace/>committe_2" id="committe_2" class="form-control">
														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="committe" items="${committeList}">
															<option value="${committe.getKey()}"  >
																<liferay-ui:message key="${committe.getName(themeDisplay.getLocale())}" />
															</option>
														</c:forEach>
													</select>
													<p id="errorContainer-committe_2" class="error-container"></p>
												</div>
											</div>											
											<div class="col-lg-4 col-md-6" id="functionDiv_2">
												<div class="form-group">
													<label class="control-label"><liferay-ui:message key="function" /></label>
													<select  name="<portlet:namespace/>function_2" id="function_2" class="form-control">
														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="function" items="${functionList}">
															<option value="${function.getKey()}">
																<liferay-ui:message key="${function.getName(themeDisplay.getLocale())}" />
															</option>
														</c:forEach>
													</select>
													<p id="errorContainer-function_2" class="error-container"></p>
												</div>
											</div>											
											<div class="col-lg-4 col-md-6" id="programtypeDiv_2">
												<div class="form-group">
													<label class="control-label"><liferay-ui:message key="program-type" /></label>
													<select  name="<portlet:namespace/>programtype_2" id="programtype_2" class="form-control">
														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="programTypeMaster" items="${programTypeMasterList}">
															<option value="${programTypeMaster.programTypeMasterId}">
																<liferay-ui:message key="${programTypeMaster.programTypeName}" />
															</option>
														</c:forEach>
													</select>
													<p id="errorContainer-programtype_2" class="error-container"></p>
												</div>
											</div>											
											<div class="col-lg-4 col-md-6" id="programDiv_2">
												<div class="form-group">
													<label class="control-label"><liferay-ui:message key="program" /> </label>
													<select  name="<portlet:namespace/>program_2" id="program_2" class="form-control">
														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="program" items="${programList}">
															<option value="${program.programMasterId}" >${program.programName}
															</option>
														</c:forEach>
													</select>
													<p id="errorContainer-program_2" class="error-container"></p>
												</div>
											</div>											
											<div class="col-lg-4 col-md-6" id="programPositionDiv_2">
												<div class="form-group">
													<label class="control-label"><liferay-ui:message key="program-position" /> </label>
													<select name="<portlet:namespace/>programPosition_2" id="programPosition_2" class="form-control" >
														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="programPosition" items="${programPositionList}">
															<option value="${programPosition.getKey()}" <c:if test="${userMetadata.programPositionId == programPosition.getKey()}">selected="selected"</c:if>>
																${programPosition.getName(themeDisplay.getLocale())}
															</option>
														</c:forEach>
													</select>
													<p id="errorContainer-program-position_2" class="error-container"></p>
												</div>
											</div>
											<div class="col-lg-4 col-md-6" id="purposeDiv_2">
												<div class="form-group">
													<label class="control-label"><liferay-ui:message key="purpose" /> </label>
													<select name="<portlet:namespace/>purpose_2" id="purpose_2" class="form-control" >
														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="purpose" items="${purposeList}">
															<option value="${purpose.getKey()}" <c:if test="${userMetadata.purposeId == purpose.getKey()}">selected="selected"</c:if>>
																${purpose.getName(themeDisplay.getLocale())}
															</option>
														</c:forEach>
													</select>
													<p id="errorContainer-purpose_2" class="error-container"></p>
												</div>
											</div>
										</div>
									</div>
									<div class="omsb-card omsb-card-graybg omsb-noBorderRadius d-none" id="service_detail_area">			
					                       <%@ include file="registration/services-list.jsp"%>
			                       	</div>
								</div> 
									<div class="bottom-backbtn-wrap">
										<button class="btn omsb-bc-red-button" onClick="saveRoleService()" type="button" title="<liferay-ui:message key='add-update' />"><liferay-ui:message key="add-update" /></button> 
									</div> 
								</div>
								<input type="hidden" name="<portlet:namespace/>isNext" id="isNext" value="false">
								<input id="lrUserId" type="hidden" name="<portlet:namespace/>lrUserId" value="${lrUserId}"/>
								<input id="txtIndex" type="hidden" name="<portlet:namespace/>index" value="1"/>
								<input id="isAssosiated" type="hidden" name="<portlet:namespace/>assosiated" value="true"/>
							</form>
					</div>
				</div>
			</div>
		</div>
		<div class="modal fade omsb-modal" id="view-role-service-comments-modal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered w-50" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="comments" /></h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form name="uploadresultpopupform" id="uploadresultpopupform" method="post" ></form>
						<div class="omsb-card omsb-card-graybg row role-comments">
							<span id="role-comments-span"></span>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="modal fade omsb-modal" id="profile-comments-modal" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered w-50" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="comments" /></h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form name="uploadresultpopupform" id="uploadresultpopupform" method="post" ></form>
						<div class="omsb-card omsb-card-graybg row">
							<span id="">${userVerificationProfileComments}</span>
						</div>
					</div>
				</div>
			</div>
		</div>
<script>
$( document ).ready(function() {
	showPassportPhoto("passportNumber");
});
function validate() {debugger
	let isValid = false;
   if(${themeDisplay.isSignedIn()}){	
		var civilId = document.getElementById('civilId').value;
		var dateOfBirth = document.getElementById('dateOfBirth').value;
		var passportNumber = document.getElementById('passportNumber').value;
		if(dateOfBirth){
			if(validateDateOfBirth()){
				if(civilId && dateOfBirth || passportNumber && dateOfBirth || dateOfBirth && civilId || dateOfBirth && passportNumber) {
					isValid = true;
					var status=checkPersonExist(civilId,dateOfBirth,passportNumber);	 
				}				
				if(passportNumber){
					 $("#civilid-full-name").addClass("d-none");
					 $("#civilid-full-name-ar").addClass("d-none");
					 $("#civilid-first-div").removeClass("d-none");
					 $("#civilid-family-div").removeClass("d-none");
				}
				if(civilId){
					 $("#civilid-full-name").removeClass("d-none");
					 $("#civilid-full-name-ar").removeClass("d-none");
					 $("#civilid-first-div").addClass("d-none");
					 $("#civilid-family-div").addClass("d-none");
				}
				if(civilId.length<=0){
					document.getElementById("errorContainer-civilCardFrontPhoto").textContent = "";
					document.getElementById("errorContainer-civilCardBackPhoto").textContent = "";
				}
			}
		} else{
			document.getElementById("errorContainer-dateOfBirth").textContent = "<liferay-ui:message key='please-select-dateOfBirth' />";	 
		}
	}
}
function checkPersonExist(civilId,dateOfBirth,passportNumber){
	var isExist=false;
	$.ajax({
		url: '${verifyCivilPassportURL}',
		async : false,
		data : {
			<portlet:namespace />civilId : civilId,
			<portlet:namespace />dateOfBirth : dateOfBirth,
			<portlet:namespace />passportNumber : passportNumber
		},
		type : 'POST',
		success : function(data) {
			console.log(data);
			const response = JSON.parse(data);
			var isPersonIdExist=response.hasOwnProperty("personId");
			if(response.isExist){
				document.getElementById("errorContainer-user-exist").textContent = '<liferay-ui:message key="user-already-exist" />';
				isExist=true;
			} else{
				document.getElementById("errorContainer-user-exist").textContent = '';
			}
		},
	});
	return isExist;
}
$(document).ready(function() {
if(${empty person.getId()}){
	applyDobDatepicker();	
}
});
</script>		
<%@ include file="edit-registration-script.jsp"%> 
<script src="<%=request.getContextPath()%>/js/edit-registration.js"></script>