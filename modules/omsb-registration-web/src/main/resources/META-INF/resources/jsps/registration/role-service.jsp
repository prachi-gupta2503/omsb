<%@ include file="../../init.jsp"%>
<portlet:actionURL name="<%=MVCCommands.ROLE_SERVICE_MVCACTION%>" var="roleServiceMVCActionURL"/>
<portlet:renderURL var="workDetailRenderURL">
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommands.VIEW_REGISTRATION_WORK_DETAILS%>" />
	<portlet:param name="personId" value="${personId}" />
	<portlet:param name="lrUserId" value="${lrUserId}" />
 </portlet:renderURL>
		<div class="main-content id-box" style="margin-top: 0px;">
			<div class="omsb-main-wrapper" id="omsb-main-wrapper">
				
				<div class=" row bg-white">
					
					<div class="col-12 login-right">
						<div class="omsb-card ">
							<div class="omsb-pre-login header">
								<div>
									<img src="<%=themeDisplay.getPathThemeImages()%>/svg/logo.svg">
								</div>
								<div>
									<p class="logo-text-arabic"><liferay-ui:message key="oman-medical-specialty-board-arabic"/></p>
									<p class="logo-text-english"><liferay-ui:message key="oman-medical-specialty-board" /></p>
								</div>
							</div>
							
							<form name="<portlet:namespace/>rnsFM" class="" id="rnsFM" action="${roleServiceMVCActionURL}" method="post">
								<div class="reg_step4 "  id="reg_step4">
								<div class="alert alert-light alert-success-text d-none" id="workDetailSuccess" role="alert">
									<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
									<div class="alert-box">
										<span><img
											src="<%=themeDisplay.getPathThemeImages()%>/svg/Right.svg"
											alt="Right"></span>
										<div class="alert-text">
											<h4 class="alert-heading">
												<span> <liferay-ui:message
														key="work-details-are-saved-successfully" /></span>
											</h4>
										</div>
									</div>
								</div>
									<div class="omsb-card m-0 p-0">
										<div class="omsb-page-top-info mb-4">
											<div class="pagetitle"><liferay-ui:message key="registration-role-service"/></div>
											<div class="information"><label class="reg-form-title"><liferay-ui:message key="step-four-of-four"/></label></div>
										</div>
										
									</div>
									
									<div class="d-flex">
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
									
									<div class="omsb-card omsb-card-graybg omsb-noBorderRadius " id="associated_detail_area" >
										<div class="row ">
											<div class="col-lg-4 col-md-6">
												<div class="form-group">
													<label class="control-label "><liferay-ui:message key="role"/></label>
													<select  name="<portlet:namespace/>role_1" id="role_1" class="form-control">
														<option value=""><liferay-ui:message key="select" /></option>
															<c:forEach var="omsbRoles" items="${omsbRoleList}">
																<option value="${omsbRoles.roleId}" <c:if test="${userMetadata.roleId == omsbRoles.roleId}">selected="selected"</c:if>>
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
													<input  type="text" name="<portlet:namespace/>roleOther_1" id="roleOther_1" class="form-control" >
												</div>
												<p id="errorContainer-roleOther_1" class="error-container"></p>
											</div>
											
											<div class="col-lg-4 col-md-6" id="departmentDiv_1" >
												<div class="form-group" >
													<label class="control-label"><liferay-ui:message key="department"/></label>
													<select  name="<portlet:namespace/>department_1" id="department_1" class="form-control">
														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="department" items="${departmentList}">
																<option value="${department.getKey()}"  <c:if test="${userMetadata.departmentId == department.getKey()}">selected="selected"</c:if>>
																	${department.getName(themeDisplay.getLocale())}
																</option>
															</c:forEach>
													</select>
													<p id="errorContainer-department_1" class="error-container"></p>
												</div>
											</div>
											<div class="col-lg-4 col-md-6 d-none" id="departmentOtherDiv_1">
												<div class="form-group">
													<label class="control-label required"><liferay-ui:message key="department-other" /></label>
													<input type="text" name="<portlet:namespace/>departmentOther_1" id="departmentOther_1" class="form-control">
												</div>
												<p id="errorContainer-departmentOther_1" class="error-container"></p>
											</div>
											
											<div class="col-lg-4 col-md-6" id="sectionDiv_1" >
												<div class="form-group">
													<label class="control-label"><liferay-ui:message key="section"/></label>
													<select  name="<portlet:namespace/>section_1" id="section_1" class="form-control">
														<option value=""><liferay-ui:message key="select"/></option>
														<c:forEach var="section" items="${sectionList}">
																<option value="${section.getKey()}"  <c:if test="${userMetadata.sectionId == section.getKey()}">selected="selected"</c:if>>
																	${section.getName(themeDisplay.getLocale())}
																</option>
															</c:forEach>
													</select>
													<p id="errorContainer-section_1" class="error-container"></p>
												</div>
											</div>
											<div class="col-lg-4 col-md-6 d-none" id="sectionOtherDiv_1">
												<div class="form-group">
													<label class="control-label required"><liferay-ui:message key="section-other" /></label>
													<input  type="text" name="<portlet:namespace/>sectionOther_1" id="sectionOther_1" class="form-control">
												</div>
												<p id="errorContainer-sectionOther_1" class="error-container"></p>
											</div>
											
											<div class="col-lg-4 col-md-6" id="committeDiv_1" >
												<div class="form-group">
													<label class="control-label"><liferay-ui:message key="committe" /></label>
													<select name="<portlet:namespace/>committe_1" id="committe_1" class="form-control">
														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="committe" items="${committeList}">
																<option value="${committe.getKey()}" <c:if test="${userMetadata.committeeId == committe.getKey()}">selected="selected"</c:if>>
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
													<input  type="text" name="<portlet:namespace/>committeOther_1" id="committeOther_1" class="form-control">
												</div>
												<p id="errorContainer-committeOther_1" class="error-container"></p>
											</div>
											
											<div class="col-lg-4 col-md-6" id="functionDiv_1">
												<div class="form-group">
													<label class="control-label"><liferay-ui:message key="function"/></label>
													<select  name="<portlet:namespace/>function_1" id="function_1" class="form-control">
														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="function" items="${functionList}">
															<option value="${function.getKey()}" <c:if test="${userMetadata.functionId == function.getKey()}">selected="selected"</c:if>>
																${function.getName(themeDisplay.getLocale())}
															</option>
														</c:forEach>
													</select>
													<p id="errorContainer-function_1" class="error-container"></p>
												</div>
											</div>
											<div class="col-lg-4 col-md-6 d-none" id="functionOtherDiv_1">
												<div class="form-group">
													<label class="control-label required"><liferay-ui:message key="function-other" /></label>
													<input  type="text" name="<portlet:namespace/>functionOther_1" id="functionOther_1" class="form-control">
												</div>
												<p id="errorContainer-functionOther_1" class="error-container"></p>
											</div>
											
											<div class="col-lg-4 col-md-6" id="programtypeDiv_1">
												<div class="form-group">
													<label class="control-label"><liferay-ui:message key="program-type" /></label>
													<select  name="<portlet:namespace/>programtype_1" id="programtype_1" class="form-control" >
														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="programTypeMaster" items="${programTypeMasterList}">
															<option value="${programTypeMaster.programTypeMasterId}" <c:if test="${userMetadata.programTypeId == programTypeMaster.programTypeMasterId}">selected="selected"</c:if>>
																${programTypeMaster.programTypeName}
															</option>
														</c:forEach>
													</select>
													<p id="errorContainer-programtype_1" class="error-container"></p>
												</div>
											</div>
											<div class="col-lg-4 col-md-6 d-none" id="programtypeOtherDiv_1">
												<div class="form-group">
													<label class="control-label required"><liferay-ui:message key="program-type-other" /></label>
													<input  type="text" name="<portlet:namespace/>programtypeOther_1" id="programtypeOther_1" class="form-control" >
												</div>
												<p id="errorContainer-programtypeOther_1" class="error-container"></p>
											</div>
											
											<div class="col-lg-4 col-md-6" id="programDiv_1">
												<div class="form-group">
													<label class="control-label"><liferay-ui:message key="program" /> </label>
													<select  name="<portlet:namespace/>program_1" id="program_1" class="form-control" >
														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="program" items="${programList}">
															<option value="${program.programMasterId}" <c:if test="${userMetadata.programId == program.programMasterId}">selected="selected"</c:if>>
																${program.programName}
															</option>
														</c:forEach>
													</select>
													<p id="errorContainer-program_1" class="error-container"></p>
												</div>
											</div>
											<div class="col-lg-4 col-md-6 d-none" id="programOtherDiv_1">
												<div class="form-group">
													<label class="control-label required"><liferay-ui:message key="program-other" /></label>
													<input  type="text" name="<portlet:namespace/>programOther_1" id="programOther_1" class="form-control">
												</div>
												<p id="errorContainer-programOther_1" class="error-container"></p>
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
											<div class="col-lg-4 col-md-6 d-none" id="programPositionOtherDiv_1">
												<div class="form-group">
													<label class="control-label required"><liferay-ui:message key="program-position-other" /></label>
													<input type="text" name="<portlet:namespace/>programOther_1" id="programPositionOther_1" class="form-control" value="${programPositionOther}" >
												</div>
												<p id="errorContainer-programPositionOther_1" class="error-container"></p>
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
											<div class="col-lg-4 col-md-6 d-none" id="purposeOtherDiv_1">
												<div class="form-group">
													<label class="control-label required"><liferay-ui:message key="purpose-other" /></label>
													<input type="text" name="<portlet:namespace/>purposeOther_1" id="purposeOther_1" class="form-control" value="${purposeOther}" >
												</div>
												<p id="errorContainer-purposeOther_1" class="error-container"></p>
											</div>
										</div>
									</div>
									
									<div class="d-none" id="registrant_detail_area" >
										<div class="d-flex">
											<div class="w-50">
												<label class="control-label"><liferay-ui:message key="are-you-registering-for-role-or-service" /></label>
											</div>
											<div class="form-group yesorno">
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

										<div class="omsb-card omsb-card-graybg omsb-noBorderRadius" id="role_detail_area">
											<div class="row ">
												<div class="col-lg-4 col-md-6">
													<div class="form-group">
														<label class="control-label "><liferay-ui:message key="role" /></label>
														<select name="<portlet:namespace/>role_2" id="role" class="form-control">
															<option value=""><liferay-ui:message key="select" /></option>
															<c:forEach var="omsbRoles" items="${omsbRoleList}">
																<option value="${omsbRoles.roleId}" <c:if test="${userMetadata.roleId == omsbRoles.roleId}">selected="selected"</c:if>>
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
													<input type="text" name="<portlet:namespace/>roleOther_2" id="roleOther_2" class="form-control">
												</div>
												<p id="errorContainer-roleOther_2" class="error-container"></p>
											</div>
											
											<div class="col-lg-4 col-md-6" id="departmentDiv_2">
												<div class="form-group">
													<label class="control-label"><liferay-ui:message key="department" /></label>
													<select  name="<portlet:namespace/>department_2" id="department_2" class="form-control">
														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="department" items="${departmentList}">
															<option value="${department.getKey()}" <c:if test="${userMetadata.departmentId == department.getKey()}">selected="selected"</c:if>>
																${department.getName(themeDisplay.getLocale())}
															</option>
														</c:forEach>
													</select>
													<p id="errorContainer-department_2" class="error-container"></p>
												</div>
											</div>
											<div class="col-lg-4 col-md-6 d-none" id="departmentOtherDiv_2">
												<div class="form-group">
													<label class="control-label required"><liferay-ui:message key="department-other" /></label>
													<input  type="text" name="<portlet:namespace/>departmentOther_2" id="departmentOther_2" class="form-control">
												</div>
												<p id="errorContainer-departmentOther_2" class="error-container"></p>
											</div>
											
											<div class="col-lg-4 col-md-6" id="sectionDiv_2">
												<div class="form-group">
													<label class="control-label"><liferay-ui:message key="section" /></label>
													<select  name="<portlet:namespace/>section_2" id="section_2" class="form-control">
														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="section" items="${sectionList}">
															<option value="${section.getKey()}" <c:if test="${userMetadata.sectionId == section.getKey()}">selected="selected"</c:if>>
																${section.getName(themeDisplay.getLocale())}
															</option>
														</c:forEach>
													</select>
													<p id="errorContainer-section_2" class="error-container"></p>
												</div>
											</div>
											<div class="col-lg-4 col-md-6 d-none" id="sectionOtherDiv_2">
												<div class="form-group">
													<label class="control-label required"><liferay-ui:message key="section-other" /></label>
													<input  type="text" name="<portlet:namespace/>sectionOther_2" id="sectionOther_2" class="form-control">
												</div>
												<p id="errorContainer-sectionOther_2" class="error-container"></p>
											</div>
											
											<div class="col-lg-4 col-md-6" id="committeDiv_2">
												<div class="form-group">
													<label class="control-label"><liferay-ui:message key="committe" /></label>
													<select name="<portlet:namespace/>committe_2" id="committe_2" class="form-control">
														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="committe" items="${committeList}">
															<option value="${committe.getKey()}" <c:if test="${userMetadata.committeeId == committe.getKey()}">selected="selected"</c:if>>
																${committe.getName(themeDisplay.getLocale())}
															</option>
														</c:forEach>
													</select>
													<p id="errorContainer-committe_2" class="error-container"></p>
												</div>
											</div>
											<div class="col-lg-4 col-md-6 d-none" id="committeOtherDiv_2">
												<div class="form-group">
													<label class="control-label required"><liferay-ui:message key="committe-other" /></label>
													<input  type="text" name="<portlet:namespace/>committeOther_2" id="committeOther_2" class="form-control">
												</div>
												<p id="errorContainer-committeOther_2" class="error-container"></p>
											</div>
											
											<div class="col-lg-4 col-md-6" id="functionDiv_2">
												<div class="form-group">
													<label class="control-label"><liferay-ui:message key="function" /></label>
													<select  name="<portlet:namespace/>function_2" id="function_2" class="form-control">
														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="function" items="${functionList}">
															<option value="${function.getKey()}" <c:if test="${userMetadata.functionId == function.getKey()}">selected="selected"</c:if>>
																${function.getName(themeDisplay.getLocale())}
															</option>
														</c:forEach>
													</select>
													<p id="errorContainer-function_2" class="error-container"></p>
												</div>
											</div>
											<div class="col-lg-4 col-md-6 d-none" id="functionOtherDiv_2">
												<div class="form-group">
													<label class="control-label required"><liferay-ui:message key="function-other" /></label>
													<input type="text" name="<portlet:namespace/>functionOther_2" id="functionOther_2" class="form-control">
												</div>
												<p id="errorContainer-functionOther_2" class="error-container"></p>
											</div>
											
											<div class="col-lg-4 col-md-6" id="programtypeDiv_2">
												<div class="form-group">
													<label class="control-label"><liferay-ui:message key="program-type" /></label>
													<select  name="<portlet:namespace/>programtype_2" id="programtype_2" class="form-control">
														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="programTypeMaster" items="${programTypeMasterList}">
															<option value="${programTypeMaster.programTypeMasterId}" <c:if test="${userMetadata.programTypeId == programTypeMaster.programTypeMasterId}">selected="selected"</c:if>>
																${programTypeMaster.programTypeName}
															</option>
														</c:forEach>
													</select>
													<p id="errorContainer-programtype_2" class="error-container"></p>
												</div>
											</div>
											<div class="col-lg-4 col-md-6 d-none" id="programtypeOtherDiv_2">
												<div class="form-group">
													<label class="control-label required"><liferay-ui:message key="programtype-other" /></label>
													<input  type="text" name="<portlet:namespace/>programtypeOther_2" id="programtypeOther_2" class="form-control">
												</div>
												<p id="errorContainer-programtypeOther_2" class="error-container"></p>
											</div>
											
											<div class="col-lg-4 col-md-6" id="programDiv_2">
												<div class="form-group">
													<label class="control-label"><liferay-ui:message key="program" /> </label>
													<select  name="<portlet:namespace/>program_2" id="program_2" class="form-control">
														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="program" items="${programList}">
															<option value="${program.programMasterId}" <c:if test="${userMetadata.programId == program.programMasterId}">selected="selected"</c:if>>
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
													<input type="text" name="<portlet:namespace/>programOther_2" id="programOther_2" class="form-control">
												</div>
												<p id="errorContainer-programOther_2" class="error-container"></p>
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
											<div class="col-lg-4 col-md-6 d-none" id="programPositionOtherDiv_2">
												<div class="form-group">
													<label class="control-label required"><liferay-ui:message key="program-position-other" /></label>
													<input type="text" name="<portlet:namespace/>programPositionOther_2" id="programPositionOther_2" class="form-control">
												</div>
												<p id="errorContainer-programPositionOther_2" class="error-container"></p>
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
											<div class="col-lg-4 col-md-6 d-none" id="purposeOtherDiv_2">
												<div class="form-group">
													<label class="control-label required"><liferay-ui:message key="purpose-other" /></label>
													<input type="text" name="<portlet:namespace/>purposeOther_2" id="purposeOther_2" class="form-control">
												</div>
												<p id="errorContainer-purposeOther_2" class="error-container"></p>
											</div>
										</div>
									</div>
						<div class="omsb-card omsb-card-graybg omsb-noBorderRadius d-none" id="service_detail_area">			
                       <%@ include file="/jsps/registration/services-list.jsp"%>
                       </div>
									<%-- <div class="omsb-card omsb-card-graybg omsb-noBorderRadius d-none" id="service_detail_area">
										<div class="row">
											<div class="col-lg-12 col-md-12">
												<div class="form-group">
													<label class="control-label "><liferay-ui:message key="service" /></label>
													<select  name="<portlet:namespace/>service" id="service" class="form-control">
														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="service" items="${serviceList}">
															<option value="${service.getKey()}" <c:if test="${userMetadata.service == service.getKey()}">selected="selected"</c:if>>
																${service.getName(themeDisplay.getLocale())}
															</option>
														</c:forEach>
													</select>
													<p id="errorContainer-service" class="error-container"></p>
												</div>
											</div>
											<div class="col-lg-4 col-md-6 d-none" id="serviceOtherDiv">
												<div class="form-group">
													<label class="control-label required"><liferay-ui:message key="service-other" /></label>
													<input  type="text" name="<portlet:namespace/>serviceOther" id="serviceOther" class="form-control" value="${serviceOther}" >
												</div>
												<p id="errorContainer-serviceOther" class="error-container"></p>
											</div>	
										</div>
									</div> --%>
								</div>

								<div class="bottom-backbtn-wrap">
									<button class="btn omsb-bc-red-button"  onClick="validateAndSaveFormData('save')"  type="button" title="<liferay-ui:message key='save-at-this-stage' />"><liferay-ui:message key="save-at-this-stage" /></button> 
									<button class="btn omsb-bc-red-button" onClick="validateAndSaveFormData('next')" type="button" title="<liferay-ui:message key='next' />"><liferay-ui:message key='save' /></button>
									<%-- <button id="role-service-back-button" class="go-pervious btn omsb-btn omsb-bg-red-button "  data-toggle="modal" data-target="#conformationPopUp" type="button" title="<liferay-ui:message key='back' />" data-pervious="reg_step3"><i class="fi fi-sr-arrow-left"></i> <liferay-ui:message key='back' /></button> --%>
								</div>
							</div>
							<input id="isNext" type="hidden" name="<portlet:namespace/>isNext" value="false">
							<input id="lrUserId" type="hidden" name="<portlet:namespace/>lrUserId" value="${lrUserId}"/>
							<input id="personId" type="hidden" name="<portlet:namespace/>personId" value="${personId}"/>
							<input id="txtIndex" type="hidden" name="<portlet:namespace/>index" value="1"/>
							<input id="requestForService" type="hidden" name="<portlet:namespace/>requestForService" value="false"/>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="loader-container d-none">
	<div class="loaded">
		<img src="<%=themeDisplay.getPathThemeImages()%>/svg/loader.svg"
			alt="loader">
	</div>
</div>
<%@ include file="confirmationPopUp.jsp"%>
<liferay-ui:success key="success-role-service" message="role-service-successfully-added" />
<liferay-ui:success key="success-work-detail" message="work-detail-successfully-added" />

<portlet:resourceURL id="<%=MVCCommands.IS_EDUCATION_AND_EMPLOYMENT_DETAILS_SAVED_MVC_RESOURCE%>" var="isEducationAndEmploymentDetailsSavedURL" />
<portlet:resourceURL id="<%=MVCCommands.SECTION_DEPARTMENT_MVC_RESOURCE%>" var="sectionDepartmentURL" />		
<portlet:resourceURL id="<%=MVCCommands.FUNCTION_SECTION_COMMITTEE_MVC_RESOURCE%>" var="functionSectioncommitteURL" />		
<portlet:resourceURL id="<%=MVCCommands.PROGRAM_TYPE_MVC_RESOURCE%>" var="programTypeURL" />		
<portlet:resourceURL id="<%=MVCCommands.SAVE_REGISTRATION_ROLE_AND_SERVICE%>" var="saveRoleAndService" />
<input id="userMetadataId" type="hidden" name="<portlet:namespace/>userMetadataId" value="${userMetadata.id}"/>
<input id="isAssociated" type="hidden" name="<portlet:namespace/>isAssociated" value="${userMetadata.associated}"/>
<input id="isregisteringForRole" type="hidden" name="<portlet:namespace/>isAssociated" value="${userMetadata.registeringForRole}"/>

<script type="text/javascript">

/* 
$("#role-service-back-button").click(function(){
	window.location.href='${workDetailRenderURL}';
}); */


var show_departmentDiv_1 = false;
var show_sectionDiv_1 = false;
var show_committeDiv_1 = false;
var show_functionDiv_1 = false;
var show_programtypeDiv_1 = false;
var show_programDiv_1 = false;
var show_programPositionDiv_1 = false;
var show_purposeDiv_1 = false;

var show_roleDiv_2 = false;
var show_departmentDiv_2 = false;
var show_sectionDiv_2 = false;
var show_committeDiv_2 = false;
var show_functionDiv_2 = false;
var show_programtypeDiv_2 = false;
var show_programDiv_2 = false;
var show_programPositionDiv_2 = false;
var show_purposeDiv_2 = false;

var show_serviceDiv = false;

var is_role_1_required = false;
var is_department_1_required = false;
var is_section_1_required = false;
var is_committe_1_required = false;
var is_function_1_required = false;
var is_programtype_1_required = false;
var is_program_1_required = false;
var is_programPosition_1_required = false;
var is_purpose_1_required = false;

var is_role_2_required = false;
var is_department_2_required = false;
var is_section_2_required = false;
var is_committe_2_required = false;
var is_function_2_required = false;
var is_programtype_2_required = false;
var is_program_2_required = false;
var is_programPosition_2_required = false;
var is_purpose_2_required = false;

var is_service_required = false;

$(document).ready(function() {
	$("#role").select2();
	$("#role_1").select2();
	$("#department_1").select2();
	$("#department_2").select2();
	$("#section_1").select2();
	$("#section_2").select2();
	$("#function_1").select2();
	$("#function_2").select2();
	$("#programtype_1").select2();
	$("#programtype_2").select2();
	$("#program_1").select2();
	$("#program_2").select2();
	$("#programPosition_1").select2();
	$("#programPosition_2").select2();
	$("#purpose_1").select2();
	$("#purpose_2").select2();
	$("#committe_1").select2();
	$("#committe_2").select2();
	$("#service").select2();
	 
	$('#departmentDiv_1').addClass("d-none");
	$('#sectionDiv_1').addClass("d-none");
	$('#functionDiv_1').addClass("d-none");
	$('#programtypeDiv_1').addClass("d-none");
	$('#programDiv_1').addClass("d-none");
	$('#programPositionDiv_1').addClass("d-none");
	$('#purposeDiv_1').addClass("d-none");
	$("#committeDiv_1").addClass("d-none");

	$('#departmentDiv_2').addClass("d-none");
	$('#sectionDiv_2').addClass("d-none");
	$('#functionDiv_2').addClass("d-none");
	$('#programtypeDiv_2').addClass("d-none");
	$('#programDiv_2').addClass("d-none");
	$('#programPositionDiv_2').addClass("d-none");	
	$('#purposeDiv_2').addClass("d-none");
	$("#committeDiv_2").addClass("d-none");
	
	if(isAssociated == 'true'){
		setRole_1($('option:selected', $('#role_1')).text().trim());
		/* $("#role").val("");
		document.getElementById('select2-role-container').innerHTML="<liferay-ui:message key='select' />";
		$("#department_2").val("");
		document.getElementById('select2-department_2-container').innerHTML="";
		$("#section_2").val("");
		document.getElementById('select2-section_2-container').innerHTML="";
		$("#function_2").val("");
		document.getElementById('select2-function_2-container').innerHTML="";
		$("#programtype_2").val("");
		document.getElementById('select2-programtype_2-container').innerHTML="";
		$("#program_2").val("");
		document.getElementById('select2-program_2-container').innerHTML="";
		$("#programPosition_2").val("");
		document.getElementById('select2-programPosition_2-container').innerHTML="";
		$("#purpose_2").val("");
		document.getElementById('select2-purpose_2-container').innerHTML="";
		$("#committe_2").val("");
		document.getElementById('select2-committe_2-container').innerHTML=""; */
	}else if(isAssociated== 'false' && isregisteringForRole == 'true'){
		setRole($('option:selected', $('#role')).text().trim());
		/* $("#role_1").val("");
		document.getElementById('select2-role_1-container').innerHTML="<liferay-ui:message key='select' />";
		$("#department_1").val("");
		document.getElementById('select2-department_1-container').innerHTML="";
		$("#section_1").val("");
		document.getElementById('select2-section_1-container').innerHTML="";
		$("#function_1").val("");
		document.getElementById('select2-function_1-container').innerHTML="";
		$("#programtype_1").val("");
		document.getElementById('select2-programtype_1-container').innerHTML="";
		$("#program_1").val("");
		document.getElementById('select2-program_1-container').innerHTML="";
		$("#programPosition_1").val("");
		document.getElementById('select2-programPosition_1-container').innerHTML="";
		$("#purpose_1").val("");
		document.getElementById('select2-purpose_1-container').innerHTML="";
		$("#committe_1").val("");
		document.getElementById('select2-committe_1-container').innerHTML=""; */
	}
});

function showOtherField(id, errorId, errorMessage){
	var index=substring=id.substr ( id.indexOf ( '_' ) + 1 ,id.length);
	var subStringOfId=id.substr ( 0,id.indexOf ( '_' ) );
	let selectedValue= $("#"+id).find('option:selected').val();
	if(selectedValue.trim() === 'other'){
		$('#'+subStringOfId+"OtherDiv_"+index).removeClass('d-none');
	} else{
		$('#'+subStringOfId+"OtherDiv_"+index).addClass('d-none');
	}	 
}

var errorMessages = [];
var userMetadataId=$('#userMetadataId').val();
var isAssociated=$('#isAssociated').val();
var isregisteringForRole=$('#isregisteringForRole').val();
if(isAssociated == 'true'){
	$("#txtIndex").val("1");
	$('#associated_detail_area').removeClass("d-none");
	$('#registrant_detail_area').addClass("d-none");
}else if(isAssociated== 'false' && isregisteringForRole == 'true'){
	$('#associated_yes').prop('checked', false);
	$('#associated_no').prop('checked', true);
	$('#registering_yes').prop('checked', true);
	$('#registering_no').prop('checked', false);
	$("#txtIndex").val("2");
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
}

function validateAndSaveFormData(button) {
	addLoader();
	
	setTimeout(function() {
	
	var isOMSBAssociated=false;
	var roleRegistration=false;
	if(document.getElementById('associated_yes').checked) {
		 isOMSBAssociated=true;
	}else if(document.getElementById('associated_no').checked) {
		isOMSBAssociated=false;
	}
	 
	console.log("isOMSBAssociated ::::",isOMSBAssociated);
	if(isOMSBAssociated){
		errorMessages = [];
	 	var role_1 = document.getElementById("role_1").value;
		if (!role_1) {
			errorMessages.push("<liferay-ui:message key='please-select-role' />");
			document.getElementById("errorContainer-role_1").textContent = "<liferay-ui:message key='please-select-role' />";
		} else {
			document.getElementById("errorContainer-role_1").textContent = "";
		}
	 		
		var department_1 = document.getElementById("department_1").value;
		if (!department_1 && show_departmentDiv_1 && is_department_1_required) {
			errorMessages.push("<liferay-ui:message key='please-select-department' />");
			document.getElementById("errorContainer-department_1").textContent = "<liferay-ui:message key='please-select-department' />";
		} else {
			document.getElementById("errorContainer-department_1").textContent = "";
			var departmentOther_1 = document.getElementById("departmentOther_1").value;
			if(department_1 == "other" && !departmentOther_1 && show_departmentDiv_1 && is_department_1_required){
				errorMessages.push("<liferay-ui:message key='please-add-other-department' />");
				document.getElementById("errorContainer-departmentOther_1").textContent = "<liferay-ui:message key='please-add-other-department' />";
			} else {
				document.getElementById("errorContainer-departmentOther_1").textContent = "";
			}
		}
		
		var section_1 = document.getElementById("section_1").value;
		if (!section_1 && show_sectionDiv_1 && is_section_1_required) {
			errorMessages.push("<liferay-ui:message key='please-select-section' />");
			document.getElementById("errorContainer-section_1").textContent = "<liferay-ui:message key='please-select-section' />";
		} else {
			document.getElementById("errorContainer-section_1").textContent = "";
			var sectionOther_1 = document.getElementById("sectionOther_1").value;
			if(section_1 == "other" && !sectionOther_1 && show_sectionDiv_1 && is_section_1_required){
				errorMessages.push("<liferay-ui:message key='please-add-other-section' />");
				document.getElementById("errorContainer-sectionOther_1").textContent = "<liferay-ui:message key='please-add-other-section' />";
			} else {
				document.getElementById("errorContainer-sectionOther_1").textContent = "";
			}
		}
		
		var committe_1 = document.getElementById("committe_1").value;
		if (!committe_1 && show_committeDiv_1 && is_committe_1_required) {
			errorMessages.push("<liferay-ui:message key='please-select-committe' />");
			document.getElementById("errorContainer-committe_1").textContent = "<liferay-ui:message key='please-select-committe' />";
		} else {
			document.getElementById("errorContainer-committe_1").textContent = "";
			var committeOther_1 = document.getElementById("committeOther_1").value;
			if(committe_1 == "other" && !committeOther_1 && show_committeDiv_1 && is_committe_1_required){
				errorMessages.push("<liferay-ui:message key='please-add-other-committe' />");
				document.getElementById("errorContainer-committeOther_1").textContent = "<liferay-ui:message key='please-add-other-committe' />";
			} else {
				document.getElementById("errorContainer-committeOther_1").textContent = "";
			}
		}
			
		var function_1 = document.getElementById("function_1").value;
		if (!function_1 && show_functionDiv_1 && is_function_1_required) {
			errorMessages.push("<liferay-ui:message key='please-select-function' />");
			document.getElementById("errorContainer-function_1").textContent = "<liferay-ui:message key='please-select-function' />";
		} else {
			document.getElementById("errorContainer-function_1").textContent = "";
			var functionOther_1 = document.getElementById("functionOther_1").value;
			if(function_1 == "other" && !functionOther_1 && show_functionDiv_1 && is_function_1_required){
				errorMessages.push("<liferay-ui:message key='please-add-other-function' />");
				document.getElementById("errorContainer-functionOther_1").textContent = "<liferay-ui:message key='please-add-other-function' />";
			} else {
				document.getElementById("errorContainer-functionOther_1").textContent = "";
			}
		}
			
		var programtype_1 = document.getElementById("programtype_1").value;
		if (!programtype_1 && show_programtypeDiv_1 && is_programtype_1_required) {
			errorMessages.push("<liferay-ui:message key='please-select-program-type' />");
			document.getElementById("errorContainer-programtype_1").textContent = "<liferay-ui:message key='please-select-program-type' />";
		} else {
			document.getElementById("errorContainer-programtype_1").textContent = "";
		}
		
		var program_1 = document.getElementById("program_1").value;
		if (!program_1 && show_programDiv_1 && is_program_1_required) {
			errorMessages.push("<liferay-ui:message key='please-select-program' />");
			document.getElementById("errorContainer-program_1").textContent = "<liferay-ui:message key='please-select-program' />";
		} else {
			document.getElementById("errorContainer-program_1").textContent = "";
		}
		
		var programPosition_1 = document.getElementById("programPosition_1").value;
		if (!programPosition_1 && show_programPositionDiv_1 && is_programPosition_1_required) {
			errorMessages.push("<liferay-ui:message key='please-select-program-position' />");
			document.getElementById("errorContainer-program-position_1").textContent = "<liferay-ui:message key='please-select-program-position' />";
		} else {
			document.getElementById("errorContainer-program-position_1").textContent = "";
		}
		
		var purpose_1 = document.getElementById("purpose_1").value;
		if (!purpose_1 && show_purposeDiv_1 && is_purpose_1_required) {
			errorMessages.push("<liferay-ui:message key='please-select-purpose' />");
			document.getElementById("errorContainer-purpose_1").textContent = "<liferay-ui:message key='please-select-purpose' />";
		} else {
			document.getElementById("errorContainer-purpose_1").textContent = "";
		}
	 }else{
	 	errorMessages = [];
 		var roleRegistration=false;
 		
		if(document.getElementById('registering_yes').checked) {
			roleRegistration=true;
		}else if(document.getElementById('registering_no').checked) {
			roleRegistration=false;
		}
	 		
		if(roleRegistration){
 			errorMessages = [];
 		 	var role = document.getElementById("role").value;
 			if (!role) {
 				errorMessages.push("<liferay-ui:message key='please-select-role' />");
 				document.getElementById("errorContainer-role_2").textContent = "<liferay-ui:message key='please-select-role' />";
 			} else {
 				document.getElementById("errorContainer-role_2").textContent = "";
 			}
 		 		
 			var department_2 = document.getElementById("department_2").value;
 			if (!department_2 && show_departmentDiv_2 && is_department_2_required) {
 				errorMessages.push("<liferay-ui:message key='please-select-department' />");
 				document.getElementById("errorContainer-department_2").textContent = "<liferay-ui:message key='please-select-department' />";
 			} else {
 				document.getElementById("errorContainer-department_2").textContent = "";
 				var departmentOther_2 = document.getElementById("departmentOther_2").value;
 				if(department_2 == "other" && !departmentOther_2 && show_departmentDiv_2 && is_department_2_required){
 					errorMessages.push("<liferay-ui:message key='please-add-other-department' />");
 					document.getElementById("errorContainer-departmentOther_2").textContent = "<liferay-ui:message key='please-add-other-department' />";
 				} else {
 					document.getElementById("errorContainer-departmentOther_2").textContent = "";
 				}
 			}
 			
 			var section_2 = document.getElementById("section_2").value;
 			if (!section_2 && show_sectionDiv_2 && is_section_2_required) {
 				if(department_2 !== "other" && show_departmentDiv_2){
 					errorMessages.push("<liferay-ui:message key='please-select-section' />");
 					document.getElementById("errorContainer-section_2").textContent = "<liferay-ui:message key='please-select-section' />";
 				} else {
 					document.getElementById("errorContainer-section_2").textContent = "";
 					var sectionOther_2 = document.getElementById("sectionOther_2").value;
 					if(section_2 == "other" && !sectionOther_2 && show_sectionDiv_2 && is_section_2_required){
 						errorMessages.push("<liferay-ui:message key='please-add-other-section' />");
 						document.getElementById("errorContainer-sectionOther_2").textContent = "<liferay-ui:message key='please-add-other-section' />";
 					} else {
 						document.getElementById("errorContainer-sectionOther_2").textContent = "";
 					}
 				}
 	 		}
 			
 			var committe_2 = document.getElementById("committe_2").value;
			if (!committe_2 && show_committeDiv_2 && is_committe_2_required) {
				errorMessages.push("<liferay-ui:message key='please-select-committe' />");
				document.getElementById("errorContainer-committe_2").textContent = "<liferay-ui:message key='please-select-committe' />";
			} else {
				document.getElementById("errorContainer-committe_2").textContent = "";
				var committeOther_2 = document.getElementById("committeOther_2").value;
				if(committe_2 == "other" && !committeOther_2 && show_committeDiv_2 && is_committe_2_required){
					errorMessages.push("<liferay-ui:message key='please-add-other-committe' />");
					document.getElementById("errorContainer-committeOther_2").textContent = "<liferay-ui:message key='please-add-other-committe' />";
				} else {
					document.getElementById("errorContainer-committeOther_2").textContent = "";
				}
			}
 			 				
			var function_2 = document.getElementById("function_2").value;
			if (!function_2 && show_functionDiv_2 && is_function_2_required) {
				errorMessages.push("<liferay-ui:message key='please-select-function' />");
				document.getElementById("errorContainer-function_2").textContent = "<liferay-ui:message key='please-select-function' />";
			} else {
				document.getElementById("errorContainer-function_2").textContent = "";
				var functionOther_2 = document.getElementById("functionOther_2").value;
				if(function_2 == "other" && !functionOther_2 && show_functionDiv_2 && is_function_2_required){
					errorMessages.push("<liferay-ui:message key='please-add-other-function' />");
					document.getElementById("errorContainer-functionOther_2").textContent = "<liferay-ui:message key='please-add-other-function' />";
				} else {
					document.getElementById("errorContainer-functionOther_2").textContent = "";
				}
			}
 			
			var programtype_2 = document.getElementById("programtype_2").value;
			if (!programtype_2 && show_programtypeDiv_2 && is_programtype_2_required) {
				errorMessages.push("<liferay-ui:message key='please-select-program-type' />");
				document.getElementById("errorContainer-programtype_2").textContent = "<liferay-ui:message key='please-select-program-type' />";
			} else {
				document.getElementById("errorContainer-programtype_2").textContent = "";
			}
 			
			var program_2 = document.getElementById("program_2").value;
			if (!program_2 && show_programDiv_2 && is_program_2_required) {
 				errorMessages.push("<liferay-ui:message key='please-select-program' />");
 				document.getElementById("errorContainer-program_2").textContent = "<liferay-ui:message key='please-select-program' />";
 			} else {
 				document.getElementById("errorContainer-program_2").textContent = "";
 			}
			
			var programPosition_2 = document.getElementById("programPosition_2").value;
			if (!programPosition_2 && show_programPositionDiv_2 && is_programPosition_2_required) {
				errorMessages.push("<liferay-ui:message key='please-select-program-position' />");
				document.getElementById("errorContainer-program-position_2").textContent = "<liferay-ui:message key='please-select-program-position' />";
			} else {
				document.getElementById("errorContainer-program-position_2").textContent = "";
			}
			
			var purpose_2 = document.getElementById("purpose_2").value;
			if (!purpose_2 && show_purposeDiv_2 && is_purpose_2_required) {
				errorMessages.push("<liferay-ui:message key='please-select-purpose' />");
				document.getElementById("errorContainer-purpose_2").textContent = "<liferay-ui:message key='please-select-purpose' />";
			} else {
				document.getElementById("errorContainer-purpose_2").textContent = "";
			}
 		 } 		
	}
	
	console.log("errorMessages ::::",errorMessages);
	if (errorMessages.length > 0) {
		setTimeout(function() {
			removeLoader();
		}, 200);
		event.preventDefault();
	} else {
		if(button=='next'){
			if(${themeDisplay.isSignedIn()}){
				debugger
				document.getElementById("isNext").value = "true";
				document.getElementById("rnsFM").submit();
				/* saveRoleAndService() */
			} else if(isEducationAndEmploymentDetailsSaved()){
				document.getElementById("isNext").value = "true";
				document.getElementById("rnsFM").submit();
				/* saveRoleAndService(); */
			}
		} else {
			saveRoleAndService();
		}
	}
	
	
	}, 300);
}	
	function saveRoleAndService(){
		console.log("Save Role Service called:::");
		let form =$("#rnsFM")[0];
		var formData = new FormData(form);
		
		
		console.log("formData :::::::",formData);
		
		
		$.ajax({
			url: '${saveRoleAndService}',
			async : false,
			dataType:"json",
			enctype: 'multipart/form-data',
		    contentType : false,
			cache : false,
			processData : false,
			data : formData,
			type : 'POST',
			complete: function(data) {
				debugger
				$('#personal-details').addClass('d-none');
				$('#education-details').addClass('d-none');
				$('#work-details').addClass('d-none');
				$('#role-service').removeClass('d-none');
				$('#personal-details').html('');
				$('#education-details').html('');
				$('#work-details').html('');
				$('#role-service').html('');
				$("#role-service").html(data.responseText);
				$("[data-click=personalDetail]").removeClass('active');
				$("[data-click=educationDetail]").removeClass('active');
				$("[data-click=workDetail]").removeClass('active');
				$("[data-click=roleService]").addClass('active');
				setTimeout(function() {
					removeLoader();
				}, 200);
			},
		})
	}

	function isEducationAndEmploymentDetailsSaved(){
		let isExist = false;
		let isSignedUser='${themeDisplay.isSignedIn()}';
		console.log("isSignedUser--->>"+isSignedUser);
		if(isSignedUser){
			isExist = true;
		}else{
			$.ajax({
				url: '${isEducationAndEmploymentDetailsSavedURL}',
				async : false,
				dataType:"json",
				data : {
					<portlet:namespace />personId : '${personId}',
					<portlet:namespace />lrUserId : '${lrUserId}'
				},
				type : 'POST',
				success : function(data) {
					var response=JSON.parse(JSON.stringify(data));
					showContent(false, !response.isEducationDetailsExist, !response.isEmploymentDetailsExist, false);
					if(response.isEducationDetailsExist && response.isEmploymentDetailsExist){
						isExist = true;
					}
				},
			})
		}
		return isExist;
	}
	
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
				var sectionData="<option value=''><liferay-ui:message key='select'/></option>";
				
				$.each(response, function( index, value ) {
					sectionData=sectionData+"<option value='"+value.key+"'><liferay-ui:message key='"+value.name+"'/></option>";
			    });
				$("#"+sectionId).html("").append(sectionData);
			},
		})
	}
	
	$(document).on('change','#role_1',function(){
		console.log("change role_1 & role");
		show_departmentDiv_1 = false;
		show_sectionDiv_1 = false;
		show_committeDiv_1 = false;
		show_functionDiv_1 = false;
		show_programtypeDiv_1 = false;
		show_programDiv_1 = false;
		show_programPositionDiv_1 = false;
		show_purposeDiv_1 = false;
		
		$('#departmentDiv_1').addClass("d-none");
		$('#sectionDiv_1').addClass("d-none");
		$('#committeDiv_1').addClass("d-none");
		$('#functionDiv_1').addClass("d-none");
		$('#programtypeDiv_1').addClass("d-none");
		$('#programDiv_1').addClass("d-none");
		$('#programPositionDiv_1').addClass("d-none");
		$('#purposeDiv_1').addClass("d-none");
		
		is_department_1_required = false;
		is_section_1_required = false;
		is_committe_1_required = false;
		is_function_1_required = false;
		is_programtype_1_required = false;
		is_program_1_required = false;
		is_programPosition_1_required = false;
		is_purpose_1_required = false;
		
		var selectedRole = $('option:selected', $('#role_1')).text().trim();
		setRole_1(selectedRole);
	});
	
	function setRole_1(selectedRole){
		if(selectedRole.toLowerCase() === 'Staff'.toLowerCase()){
			$('#departmentDiv_1').removeClass("d-none");
			$('#sectionDiv_1').removeClass("d-none");
			$('#functionDiv_1').removeClass("d-none");
			$('#programtypeDiv_1').removeClass("d-none");
			$('#programDiv_1').removeClass("d-none");
			
			show_departmentDiv_1 = true;
			show_sectionDiv_1 = true;
			show_functionDiv_1 = true;
			show_programtypeDiv_1 = true;
			show_programDiv_1 = true;
			
			is_department_1_required = true;
			is_section_1_required = true;
			is_function_1_required = true;
		
		} else if(selectedRole.toLowerCase() === 'GFP Trainee'.toLowerCase()){
			$('#programDiv_1').removeClass("d-none");
			
			show_programDiv_1 = true;
			
			is_program_1_required = true;
			
			$("#programtype_1 option:contains(Fellowship)").attr('selected', 'selected');
			setProgram("programtype_1","program_1");
		} else if(selectedRole.toLowerCase() === 'Fellowship Trainee'.toLowerCase()){
			$('#programDiv_1').removeClass("d-none");
			
			show_programDiv_1 = true;
			
			is_program_1_required = true;
			
			$("#programtype_1 option:contains(Genral Foundation program)").attr('selected', 'selected');
			setProgram("programtype_1","program_1");
		} else if(selectedRole.toLowerCase() === 'Residency Trainee'.toLowerCase()){
			$('#programDiv_1').removeClass("d-none");
			
			show_programDiv_1 = true;
			
			is_program_1_required = true;
			
			$("#programtype_1 option:contains(Speciality)").attr('selected', 'selected');
			setProgram("programtype_1","program_1");
		} else if(selectedRole.toLowerCase() === 'Subject Matter Expert'.toLowerCase()){
			$('#departmentDiv_1').removeClass("d-none");
			$('#sectionDiv_1').removeClass("d-none");
			$('#functionDiv_1').removeClass("d-none");
			
			show_departmentDiv_1 = true;
			show_sectionDiv_1 = true;
			show_functionDiv_1 = true;
			
			is_department_1_required = true;
			is_section_1_required = true;
			is_function_1_required = true;
		} else if(selectedRole.toLowerCase() === 'Authorized User from Medical Institutions'.toLowerCase()){
			$('#departmentDiv_1').removeClass("d-none");
			$('#sectionDiv_1').removeClass("d-none");
			$('#functionDiv_1').removeClass("d-none");
			
			show_departmentDiv_1 = true;
			show_sectionDiv_1 = true;
			show_functionDiv_1 = true;
			
			is_department_1_required = true;
			is_section_1_required = true;
			is_function_1_required = true;
		} else if(selectedRole.toLowerCase() === 'Education Committee member'.toLowerCase() || selectedRole.toLowerCase() === 'Faculty'.toLowerCase()){
			$('#programtypeDiv_1').removeClass("d-none");
			$('#programDiv_1').removeClass("d-none");
			$('#programPositionDiv_1').removeClass("d-none");
			
			show_programtypeDiv_1 = true;
			show_programDiv_1 = true;
			show_programPositionDiv_1 = true;
			
			is_programtype_1_required = true;
			is_program_1_required = true;
			is_programPosition_1_required = true;
		} else if(selectedRole.toLowerCase() === 'Counsellor'.toLowerCase()){
			$('#departmentDiv_1').removeClass("d-none");
			$('#sectionDiv_1').removeClass("d-none");
			$('#functionDiv_1').removeClass("d-none");
			
			show_departmentDiv_1 = true;
			show_sectionDiv_1 = true;
			show_functionDiv_1 = true;
			
			is_department_1_required = true;
			is_section_1_required = true;
			is_function_1_required = true;
		} else if(selectedRole.toLowerCase() === 'Taskforce member'.toLowerCase() || selectedRole.toLowerCase() === 'Team member'.toLowerCase() || selectedRole.toLowerCase() === 'Committee member'.toLowerCase()){
			$('#departmentDiv_1').removeClass("d-none");
			$('#sectionDiv_1').removeClass("d-none");
			$('#committeDiv_1').removeClass("d-none");
			$('#functionDiv_1').removeClass("d-none");
			
			show_departmentDiv_1 = true;
			show_sectionDiv_1 = true;
			show_committeDiv_1 = true;
			show_functionDiv_1 = true;
			
			is_department_1_required = true;
			is_section_1_required = true;
			is_committe_1_required = true;
			is_function_1_required = true;
		} else if(selectedRole.toLowerCase() === 'Interview or judging panel'.toLowerCase()){
			$('#departmentDiv_1').removeClass("d-none");
			$('#sectionDiv_1').removeClass("d-none");
			$('#functionDiv_1').removeClass("d-none");
			$('#purposeDiv_1').removeClass("d-none");
			
			show_departmentDiv_1 = true;
			show_sectionDiv_1 = true;
			show_functionDiv_1 = true;
			show_purposeDiv_1 = true;
			
			is_department_1_required = true;
			is_section_1_required = true;
			is_function_1_required = true;
			is_purpose_1_required = true;
		}
	}
	
	$(document).on('change','#role',function(){
		console.log("change role");
		show_departmentDiv_2 = false;
		show_sectionDiv_2 = false;
		show_committeDiv_2 = false;
		show_functionDiv_2 = false;
		show_programtypeDiv_2 = false;
		show_programDiv_2 = false;
		show_programPositionDiv_2 = false;
		show_purposeDiv_2 = false;
		
		$('#departmentDiv_2').addClass("d-none");
		$('#sectionDiv_2').addClass("d-none");
		$('#committeDiv_2').addClass("d-none");
		$('#functionDiv_2').addClass("d-none");
		$('#programtypeDiv_2').addClass("d-none");
		$('#programDiv_2').addClass("d-none");
		$('#programPositionDiv_2').addClass("d-none");
		$('#purposeDiv_2').addClass("d-none");
		
		is_department_2_required = false;
		is_section_2_required = false;
		is_committe_2_required = false;
		is_function_2_required = false;
		is_programtype_2_required = false;
		is_program_2_required = false;
		is_programPosition_2_required = false;
		is_purpose_2_required = false;
		
		var selectedRole = $('option:selected', $('#role')).text().trim();
		setRole(selectedRole);
	});
	
	function setRole(selectedRole){
		if(selectedRole.toLowerCase() === 'Staff'.toLowerCase()){
			$('#departmentDiv_2').removeClass("d-none");
			$('#sectionDiv_2').removeClass("d-none");
			$('#functionDiv_2').removeClass("d-none");
			$('#programtypeDiv_2').removeClass("d-none");
			$('#programDiv_2').removeClass("d-none");
			
			show_departmentDiv_2 = true;
			show_sectionDiv_2 = true;
			show_functionDiv_2 = true;
			show_programtypeDiv_2 = true;
			show_programDiv_2 = true;
			
			is_department_1_required = true;
			is_section_1_required = true;
			is_function_1_required = true;
		} else if(selectedRole.toLowerCase() === 'GFP Trainee'.toLowerCase()){
			$('#programDiv_2').removeClass("d-none");
			
			show_programDiv_2 = true;
			
			is_program_2_required = true;
			
			$("#programtype_2 option:contains(Fellowship)").attr('selected', 'selected');
			setProgram("programtype_2","program_2");
		} else if(selectedRole.toLowerCase() === 'Fellowship Trainee'.toLowerCase()){
			$('#programDiv_2').removeClass("d-none");
			
			show_programDiv_2 = true;
			
			is_program_2_required = true;
			
			$("#programtype_2 option:contains(Genral Foundation program)").attr('selected', 'selected');
			setProgram("programtype_2","program_2");
		} else if(selectedRole.toLowerCase() === 'Residency Trainee'.toLowerCase()){
			$('#programDiv_2').removeClass("d-none");
			
			show_programDiv_2 = true;
			
			is_program_2_required = true;
			
			$("#programtype_2 option:contains(Speciality)").attr('selected', 'selected');
			setProgram("programtype_2","program_2");
		} else if(selectedRole.toLowerCase() === 'Subject Matter Expert'.toLowerCase()){
			$('#departmentDiv_2').removeClass("d-none");
			$('#sectionDiv_2').removeClass("d-none");
			$('#functionDiv_2').removeClass("d-none");
			
			show_departmentDiv_2 = true;
			show_sectionDiv_2 = true;
			show_functionDiv_2 = true;
			
			is_department_2_required = true;
			is_section_2_required = true;
			is_function_2_required = true;
		} else if(selectedRole.toLowerCase() === 'Authorized User from Medical Institutions'.toLowerCase()){
			$('#departmentDiv_2').removeClass("d-none");
			$('#sectionDiv_2').removeClass("d-none");
			$('#functionDiv_2').removeClass("d-none");
			
			show_departmentDiv_2 = true;
			show_sectionDiv_2 = true;
			show_functionDiv_2 = true;
			
			is_department_2_required = true;
			is_section_2_required = true;
			is_function_2_required = true;
		} else if(selectedRole.toLowerCase() === 'Education Committee member'.toLowerCase() || selectedRole.toLowerCase() === 'Faculty'.toLowerCase()){
			$('#programtypeDiv_2').removeClass("d-none");
			$('#programDiv_2').removeClass("d-none");
			$('#programPositionDiv_2').removeClass("d-none");
			
			show_programtypeDiv_2 = true;
			show_programDiv_2 = true;
			show_programPositionDiv_2 = true;
			
			is_programtype_2_required = true;
			is_program_2_required = true;
			is_programPosition_2_required = true;
		} else if(selectedRole.toLowerCase() === 'Counsellor'.toLowerCase()){
			$('#departmentDiv_2').removeClass("d-none");
			$('#sectionDiv_2').removeClass("d-none");
			$('#functionDiv_2').removeClass("d-none");
			
			show_departmentDiv_2 = true;
			show_sectionDiv_2 = true;
			show_functionDiv_2 = true;
			
			is_department_2_required = true;
			is_section_2_required = true;
			is_function_2_required = true;
		} else if(selectedRole.toLowerCase() === 'Taskforce member'.toLowerCase() || selectedRole.toLowerCase() === 'Team member'.toLowerCase() || selectedRole.toLowerCase() === 'Committee member'.toLowerCase()){
			$('#departmentDiv_2').removeClass("d-none");
			$('#sectionDiv_2').removeClass("d-none");
			$('#committeDiv_2').removeClass("d-none");
			$('#functionDiv_2').removeClass("d-none");
			
			show_departmentDiv_2 = true;
			show_sectionDiv_2 = true;
			show_committeDiv_2 = true;
			show_functionDiv_2 = true;
			
			is_department_2_required = true;
			is_section_2_required = true;
			is_committe_2_required = true;
			is_function_2_required = true;
		} else if(selectedRole.toLowerCase() === 'Interview or judging panel'.toLowerCase()){
			$('#departmentDiv_2').removeClass("d-none");
			$('#sectionDiv_2').removeClass("d-none");
			$('#functionDiv_2').removeClass("d-none");
			$('#purposeDiv_2').removeClass("d-none");
			
			show_departmentDiv_2 = true;
			show_sectionDiv_2 = true;
			show_functionDiv_2 = true;
			show_purposeDiv_2 = true;
			
			is_department_2_required = true;
			is_section_2_required = true;
			is_function_2_required = true;
			is_purpose_2_required = true;
		}
	}

	$(document).on('change','#department_2',function(){
		$('#departmentOtherDiv_2').addClass("d-none");
		$('#departmentOther_2').val("");
		var departmentId=$('#department_2').val();
		if(departmentId !== "other"){
			$('#sectionDiv_2').removeClass("d-none");
			$('#functionDiv_2').removeClass("d-none");
			
			show_sectionDiv_2 = true;
			show_functionDiv_2 = true;
			
			setSection("department_2","section_2");
		} else {
			$('#sectionDiv_2').addClass("d-none");
			$('#functionDiv_2').addClass("d-none");
			
			show_sectionDiv_2 = false;
			show_functionDiv_2 = false;
			
			showOtherField("department_2");
		}
	});
		
	$(document).on('change','#department_1',function(){
		$('#departmentOtherDiv_1').addClass("d-none");
		$('#departmentOther_1').val("");
		var departmentId=$('#department_1').val();
		if(departmentId !== "other"){
			$('#sectionDiv_1').removeClass("d-none");
			$('#functionDiv_1').removeClass("d-none");
			
			show_sectionDiv_1 = true;
			show_functionDiv_1 = true;
			
			setSection("department_1","section_1");
		} else {
			$('#sectionDiv_1').addClass("d-none");
			$('#functionDiv_1').addClass("d-none");
			
			show_sectionDiv_1 = false;
			show_functionDiv_1 = false;
			
			showOtherField("department_1");
		}
	});

	$(document).on('change','#section_1',function(){
		var sectionId=$('#section_1').val();
		setFunctionCommitee("section_1","function_1","");
	});
	
	$(document).on('change','#section_2',function(){
		var sectionId=$('#section_2').val();
		setFunctionCommitee("section_2","function_2","committe");
	});
	
	$(document).on('change','#programtype_1',function(){
		var programTypeId=$('#programtype_1').val();
		setProgram("programtype_1","program_1");
	});
	
	$(document).on('change','#programtype_2',function(){
		var programTypeId=$('#programtype_2').val();
		setProgram("programtype_2","program_2");
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
				console.log("success :::::",data);
				var response=data;
				var functionData="<option value=''><liferay-ui:message key='select'/></option>";
				$.each(response.functionObj, function( index, value ) {
					functionData=functionData+"<option value='"+value.key+"'><liferay-ui:message key='"+value.name+"'/></option>";
			    });
				$("#"+functionId).html("").append(functionData);
				console.log("response.committeObj :::::",response.committeObj);
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
				var response=data;
				console.log("response :",response.length+" : data :"+data);
				var programData="<option value=''><liferay-ui:message key='select'/></option>";
				$.each(response, function( index, value ) {
					if(value.id == '${userMetadata.programId}'){
						programData=programData+"<option selected='selected' value='"+value.id+"'><liferay-ui:message key='"+value.name+"'/></option>";
					} else {
						programData=programData+"<option value='"+value.id+"'><liferay-ui:message key='"+value.name+"'/></option>";
					}
			    });
				$("#"+programId).html("").append(programData);
			},
		})
	}

	$('input[name="<portlet:namespace/>associated"]').change(function() {
		var passoc = $("input[name='<portlet:namespace/>associated']:checked").val();
		console.log("passoc"+passoc);
		if(passoc == 0 || passoc == "0" ) {
			$("#txtIndex").val("2");
			console.log("card");
			$('#registrant_detail_area').removeClass("d-none");
			$('#associated_detail_area').addClass("d-none");
			$('#requestForService').val(false);
		} else {
			$('#requestForService').val(false);
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
			$('#requestForService').val(true);
		} else {
			$("#txtIndex").val("2");
			$('#role_detail_area').removeClass("d-none");
		    $('#service_detail_area').addClass("d-none");
			$('#requestForService').val(false);
		}
	});
	
	function previousPage(){
		window.location.href='${workDetailRenderURL}';
	}
	
	$( document ).ready(function() {
		setPrimarySpecialty();
		setSecondarySpeciality();
		if(isAssociated == 'true'){
			setRole_1($('option:selected', $('#role_1')).text().trim());
			resetRoleForm();
		}else if(isAssociated== 'false' && isregisteringForRole == 'true'){
			setRole($('option:selected', $('#role')).text().trim());
			resetRole_1Form();
		}
	});

	function onlyNumberKey(evt) {
	    var ASCIICode = (evt.which) ? evt.which : evt.keyCode
	    if (ASCIICode > 31 && (ASCIICode < 48 || ASCIICode > 57))
	        return false;
	    return true;
	}
	
	function addLoader(){
		console.log("add loader called");
	    const loaderContainer = document.querySelector('.loader-container');
	    loaderContainer.classList.remove('d-none');
	    const loader = document.querySelector('.loaded');
	    loader.classList.add('loader');
	}

	function removeLoader(){
		console.log("remove called");
		const loaderContainer = document.querySelector('.loader-container');
		loaderContainer.classList.add('d-none');
		const loader = document.querySelector('.loaded');
		loader.classList.remove('loader');
		console.log("remove complete");
	}	
	
</script>