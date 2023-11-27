<%@ include file="init.jsp"%>

<liferay-ui:error key="programNameError" message="program-name-error" />
<liferay-ui:error key="programCodeError" message="program-code-error" />
<liferay-ui:error key="programAdminRequirementsError" message="program-admin-requirements-error" />
<liferay-ui:error key="programVisionError" message="program-vision-error" />
<liferay-ui:error key="programMissionError" message="program-mission-error" />
<liferay-ui:error key="programObjectivesError" message="program-objective-error" />
<liferay-ui:error key="programRequirementError" message="program-requirement-error" />


<portlet:actionURL name="<%= OmsbProgramConstants.SAVE_PROGRAM_MVC_ACTION_COMMAND %>" var="updateProgramDetailActionURL">
	<portlet:param name="redirect" value="${currentURL}"/>
	<portlet:param name="redirectCommand" value="<%= OmsbProgramConstants.PROGRAM_DETAILS_MVC_RENDER_COMMAND %>"/>
</portlet:actionURL>

<portlet:renderURL var="addProgram">
    <portlet:param name="mvcRenderCommandName" value="/add-program-form" />
</portlet:renderURL>

<c:if
	test="<%=!SessionErrors.isEmpty(renderRequest)
						&& (!SessionMessages.isEmpty(renderRequest) )%>">
	<div class="alert alert-light alert-danger-text" role="alert">
		<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
		<div class="alert-box">
			<span><img
				src="<%=themeDisplay.getPathThemeImages()%>/svg/reject.svg"
				alt="Reject"></span>
			<div class="alert-text">
				<h4 class="alert-heading">
					<span id="showError"><liferay-ui:message
							key="<%=SessionErrors.keySet(renderRequest).iterator().next()%>" /></span>
				</h4>
			</div>
		</div>
	</div>
</c:if>
<c:if
	test="<%=!SessionMessages.isEmpty(renderRequest) && SessionErrors.isEmpty(renderRequest)%>">
	<div class="alert alert-light alert-success-text" role="alert">
		<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
		<div class="alert-box">
			<span><img
				src="<%=themeDisplay.getPathThemeImages()%>/svg/Right.svg"
				alt="Right"></span>
			<div class="alert-text">
				<h4 class="alert-heading">
					<span><liferay-ui:message
							key="<%=SessionMessages.keySet(renderRequest).iterator().next()%>" /></span>
				</h4>
			</div>
		</div>
	</div>
</c:if>
<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_PROGRAM_OBJECTIVE)}">
	<div class="loader-container loaded d-flex" id="pageLoaderContainerDetailsId">
	     <div class="loader"><img src="${themeDisplay.getPathThemeImages()}/svg/loader.svg" alt="loader"></div>
	</div>
</c:if>

<aui:form action="${updateProgramDetailActionURL}" name="fm">
<div class="row">
	<div class="col-md-12">
		<div class="omsb-card">
			<h4 class="omsb-card-title"><liferay-ui:message key="program-details" /> - ${program.getProgramName(locale)}
			<%-- <div class="buttons-wrap">
				<a href="#" class="add_cohort_button"><i class="fa fa-plus-circle" aria-hidden="true"></i> <liferay-ui:message key="add-cohort" /></a>
				<a href="#" class="view_cohort_button"><i class="fa fa-eye" aria-hidden="true"></i> <liferay-ui:message key="view-cohort" /></a>
			</div> --%>
			<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_ADD_PROGRAM)}">
				<a class="btn omsb-bg-red-button"  href="${addProgram}" >
					 <img src="${themeDisplay.getPathThemeImages()}/svg/plus_img.svg" alt=""> <liferay-ui:message key="add-program" />
				</a>
			</c:if>
			</h4>
				<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_ADD_COHORT) || permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_VIEW_COHORT)}"> 
					<div class="buttons-wrap_program-details">
					<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_ADD_COHORT)}"> 
						<a href="${addProgramCohortRenderUrl}" class="view_cohart_details_button"><img src="${themeDisplay.getPathThemeImages()}/svg/add-icon.svg" alt="add-cohort"> <liferay-ui:message key="add-cohort" /></a>
					</c:if>
					<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_VIEW_COHORT)}"> 
						<a href="${viewProgramCohortRenderUrl}" class="view_cohort_details_button"><img src="${themeDisplay.getPathThemeImages()}/svg/view_eye_icon.svg" alt="view-cohort"> <liferay-ui:message key="view-cohort" /></a>
					</c:if>
					</div>
				</c:if>
			
			<aui:input label="program-master-id" type="hidden" name="programMasterId"  value="${program.programMasterId}" />
				  <c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_PROGRAM_VIEW)}">
					<div class="row">
						<div class="col-lg-6 col-md-6 col-sm-12">
							<div class="form-group">
								<aui:input cssClass="form-control" label="program-name" type="text" name="programName" localized="true" value="${program.programName}">
									<aui:validator name="required" />
									<aui:validator name="maxLength">200</aui:validator>
								</aui:input>
							</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-12">
							<div class="form-group">
								<aui:input cssClass="form-control" label="program-code" type="text" name="programCode" localized="true" value="${program.programCode}">
									<aui:validator name="required" />
									<aui:validator name="maxLength">75</aui:validator>
								</aui:input>
							</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-12">
							<div class="form-group">
								<aui:select cssClass="custom-select form-control" label="program-type" id="programTypeMasterId" name="programTypeMasterId" value="${program.programTypeId}" >
									<aui:option value="" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-program-type" /></aui:option>
									<c:forEach items="${programTypes}" var="programTypeObj">
										<aui:option value="${programTypeObj.programTypeMasterId}">${programTypeObj.getProgramTypeName(locale)}</aui:option> 
									</c:forEach>
								</aui:select>
							</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-12">
							<div class="form-group">
								<label><liferay-ui:message key="establishment-date" /></label>
								<input type="text" name="<portlet:namespace/>programEstablishmentDateValue" id="programEstablishmentDateValue" 
								placeholder="DD/MM/YYYY" class="form-control datePicker" >
							</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-12">
							<aui:select id="programStatus" name="programStatus" label="program-status" value="${program.programStatus}" class="custom-select form-control">
								<aui:option value="" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-program-status" /></aui:option>
								<aui:option value="true"><liferay-ui:message key="active" /></aui:option>
								<aui:option value="false"><liferay-ui:message key="inactive" /></aui:option>
								<aui:validator name="required" />
							</aui:select>
						</div>
						<!--  The code commented as this details not required  as received feedback from the client on 16-08-2023-->
						<%-- <div class="col-lg-6 col-md-6 col-sm-12">
							<aui:select cssClass="custom-select form-control" label="eligibility-degree" id="eligibilityDegreeMasterId" name="eligibilityDegreeMasterId" value="${eligibilityDegreeMasterId}">
								<aui:option value="" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-eligibility-degree" /></aui:option>
								<c:forEach items="${eligibilityDegrees}" var="eligibilityDegree">
									<aui:option value="${eligibilityDegree.eligibilityDegreeMasterId}">${eligibilityDegree.eligibilityDegree}</aui:option>
								</c:forEach>
							</aui:select>
						</div> --%>
						
						<div class="col-lg-12 col-md-12 col-sm-12">
							<div class="form-group">
								<label for="programAdmissionRequirements"><liferay-ui:message key="program-admission-requirements" /><span style="color:red">*</span></label>
								<liferay-ui:input-localized name="programAdmissionRequirements" xml="${program.programAdmissionRequirements}" type="editor" cssClass="form-control"/>
							</div>
						</div>
						<div class="col-lg-12 col-md-12 col-sm-12">
							<div class="form-group">
								<label for="programDescription"><liferay-ui:message key="program-description" /><span style="color:red">*</span></label>
								<liferay-ui:input-localized name="programDescription" xml="${program.programDescription}" type="editor" cssClass="form-control"/>
							</div>
						</div>
						<div class="col-lg-12 col-md-12 col-sm-12">
							<div class="form-group">
								<label for="programVision"><liferay-ui:message key="program-vision" /><span style="color:red">*</span></label>
								<liferay-ui:input-localized name="programVision" xml="${program.programVision}" type="editor" cssClass="form-control"/>
							</div>
						</div>
						<div class="col-lg-12 col-md-12 col-sm-12">
							<div class="form-group">
								<label for="programMission"><liferay-ui:message key="program-mission" /><span style="color:red">*</span></label>
								<liferay-ui:input-localized name="programMission" xml="${program.programMission}" type="editor" cssClass="form-control"/>
							</div>
						</div>
					</div>
				</c:if>
				<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, NON_ADMIN_PROGRAM_VIEW) && !permissionChecker.isOmniadmin()}">
					<div class="omsb-card omsb-card-graybg omsb-BorderRadius-4">
						<div class="row">
							<div class="col-lg-6 col-md-6 col-sm-12">
								<div class="form-group-view">
									<div class="label-name"><liferay-ui:message key="program-name" /></div>
									<div class="label-content">${program.getProgramName(locale)}</div>
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-12">
								<div class="form-group-view">
									<div class="label-name"><liferay-ui:message key="program-code" /></div>
									<div class="label-content">${program.getProgramCode(locale)}</div>
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-12">
								<div class="form-group-view">
									<div class="label-name"><liferay-ui:message key="program-type" /></div>
									<c:forEach items="${programTypes}" var="programTypeObj">
										<c:if test = "${programTypeObj.programTypeMasterId == program.programTypeId}">
											<div class="label-content">${programTypeObj.getProgramTypeName(locale)}</div>
										</c:if>
									</c:forEach>
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-12">
								<div class="form-group-view">
									<div class="label-name"><liferay-ui:message key="establishment-date" /></div>
									<div class="label-content" id="establishment-date"></div>
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-12">
								<div class="form-group-view">
									<div class="label-name"><liferay-ui:message key="program-status" /></div>
									<c:choose>       
										<c:when test = "${program.programStatus}">
											<div class="label-content"><liferay-ui:message key="active" /></div>
										</c:when>
										<c:otherwise>
											<div class="label-content"><liferay-ui:message key="inactive" /></div>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
							<!--  The code commented as this details not required  as received feedback from the client on 16-08-2023-->
							<%-- <div class="col-lg-6 col-md-6 col-sm-12">
								<div class="form-group-view">
									<div class="label-name"><liferay-ui:message key="eligibility-degree" /></div>
									<c:forEach items="${eligibilityDegrees}" var="eligibilityDegree">
										<c:if test = "${eligibilityDegree.eligibilityDegreeMasterId == eligibilityDegreeMasterId}">
											<div class="label-content">${eligibilityDegree.eligibilityDegree}</div>
										</c:if>
									</c:forEach>
								</div>
							</div> --%>
						</div>
					</div>

					<div class="omsb-card omsb-card-graybg omsb-BorderRadius-4">
						<div class="row">
							<%-- <jsp:include page="/program-objective.jsp" /> --%>
							<%-- <div class="col-lg-12 col-md-12 col-sm-12">
								 <div class="form-group-view white-bg">
									<div class="label-name"><liferay-ui:message key="program-objectives" /></div>
									<div class="label-content">${program.getProgramObjectives(locale)}</div>
								</div> 
							</div> --%>
							<div class="col-lg-12 col-md-12 col-sm-12 mb-4">
								<div class="form-group-view white-bg ">
									<div class="label-name"><liferay-ui:message key="program-admission-requirements" /></div>
									<div class="label-content">
										${program.getProgramAdmissionRequirements(locale)}
									</div>
								</div>
							</div>
							<div class="col-lg-12 col-md-12 col-sm-12 mb-4">
								<div class="form-group-view white-bg">
									<div class="label-name"><liferay-ui:message key="program-description" /></div>
									<div class="label-content">${program.getProgramDescription(locale)}</div>
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-12 mb-4">
								<div class="form-group-view white-bg">
									<div class="label-name"><liferay-ui:message key="program-vision" /></div>
									<div class="label-content">
										${program.getProgramVision(locale)}
									</div>
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-12 mb-4">
								<div class="form-group-view white-bg">
									<div class="label-name"><liferay-ui:message key="program-mission" /></div>
									<div class="label-content">
										${program.getProgramMission(locale)}
									</div>
								</div>
							</div>
						</div>
					</div>
			</c:if>
			
			<div class="bottom-backbtn-wrap">
				<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_PROGRAM_VIEW)}">
					<button class="btn omsb-bc-red-button" type="submit" title="Save" ><liferay-ui:message key="update" /></button>
				</c:if>
				<a class="btn omsb-btn btn-back" href="${allPrograms}" title="Back"><i class="fi fi-sr-arrow-left"></i><liferay-ui:message key="back" /></a>
			</div>
</div>
</div>
<div class="bottom-backbtn-wrap"> </div>
		
	
	<!--  The code commented as this details not required  as received feedback from the client on 16-08-2023-->
	<%-- <div class="col-md-4">
		<jsp:include page="/other-programs.jsp" />  
	</div> --%>
</div>
</aui:form>
<c:if test="${programDurationDetailList.size() gt 0}">
	<jsp:include page="/program-structure.jsp" />
</c:if>
<jsp:include page="/modal-popup.jsp" />

<script type="text/javascript">
	window.onload = function () {
	    $('#pageLoaderContainerDetailsId').removeClass('d-flex').addClass('d-none');
	};
	$(document).ready(function(){
		var estDate="${estDate}";
		let currentDate = new Date();
		$('#programEstablishmentDateValue').datepicker({
			format: 'dd/mm/yyyy',
			startDate : new Date('1900-1-1'),
			autoclose: true,
			todayBtn: true,
			todayHighlight: true,
			endDate: currentDate,
			maxDate: currentDate
		});
		$('#programEstablishmentDateValue').datepicker('update',new Date(estDate));
		$('#establishment-date').html("${formatedEstablishmentDate}");
	});
</script>