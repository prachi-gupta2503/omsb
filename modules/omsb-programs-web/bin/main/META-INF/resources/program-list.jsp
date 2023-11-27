<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>
<%@ include file="init.jsp"%>

<portlet:resourceURL id="/program-list" var="programList" />

<portlet:renderURL var="addProgram">
    <portlet:param name="mvcRenderCommandName" value="/add-program-form" />
</portlet:renderURL>

<div class="loader-container loaded d-flex">
     <div class="loader"><img src="${themeDisplay.getPathThemeImages()}/svg/loader.svg" alt="loader"></div>
</div>

<c:if
	test="<%=!SessionErrors.isEmpty(renderRequest) && SessionMessages.isEmpty(renderRequest)%>">
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
					<span>
					<liferay-ui:message
							key="<%=SessionMessages.keySet(renderRequest).iterator().next()%>" /></span>
				</h4>
			</div>
		</div>
	</div>
</c:if>
<div id="scopeGroupName" data-name="${scopeGroupName}"></div>

<!-- Inner Wrapper Contents -->
<div class="omsb-page-top-info omsb-program-header-top">
	<div class="pagetitle">
	<c:choose> 
		 <c:when test="${isTraineeUser}">  
	        <liferay-ui:message key="my-programs" />
	    </c:when>  
	    <c:otherwise>  
	       <liferay-ui:message key="programs" />
	    </c:otherwise>   
	</c:choose> 
	</div>
	<div class="rightbar-info">
		<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_ADD_PROGRAM)}">
			<a data-senna-off="true" class="btn omsb-bg-red-button"  href="${addProgram}" >
				<img src="${themeDisplay.getPathThemeImages()}/svg/plus_img.svg" alt=""> <liferay-ui:message key="add-program" />
			</a>
		</c:if>
		<div class="colors-info">
			<ul>
				<li><span style="background: #DC3545;"></span><liferay-ui:message key="program-type-speciality" /></li>
				<li><span style="background: #57B6B5;"></span><liferay-ui:message key="program-type-general-foundation-program" /></li>
				<li><span style="background: #222931;"></span><liferay-ui:message key="program-type-fellowship" /></li>
			</ul>
		</div>
		<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_PROGRAM_ACTIVATION)}">
			<div class="switch">
				<div class="custom-control custom-switch">
					<input type="checkbox" class="custom-control-input" id="switch2" name="example"> 
					<label class="custom-control-label" for="switch2"> 
						<span class="active"><liferay-ui:message key="active" /></span> 
						<span class="inactive"><liferay-ui:message key="inactive" /></span>
					</label>
				</div>
			</div>
		</c:if>
	</div>
</div>

<div class="omsb-cards-wrap">
	<div class="row" id="program-row"></div>
</div>

<script>

	$(document).ready(function() {
		$("#switch2").prop('checked', true);
		let programStatus = true;
		loadProgramCard(programStatus, '${programList}');
		$(".modal-backdrop").remove();
	});

	$('#switch2').change(function() {
		loadProgramCard(this.checked, '${programList}');
	});

	function loadProgramCard(programStatus, resourceCommandUrl) {
		$('.loader-container').addClass('d-flex').removeClass('d-none');
		console.log("TEST");
		$.ajax({
			url : resourceCommandUrl,
			type : 'POST',
			data : {
				<portlet:namespace/>programStatus : programStatus
			},
			success : function(payload) {
				$('.loader-container').removeClass('d-flex').addClass('d-none');
				let programCard = '';
				if(payload.result.length > 0) {
					for (let i = 0; i < payload.result.length; i++) {
						
						programCard = programCard + `<div class="col-md-3 col-sm-6 col-xs-12 mb-cst">
							<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_PROGRAM_LIST_VIEW)}">
										<div class="card-info \${getProgramCardColor(payload.result[i].programType)}-info-card">
											<a data-senna-off="true" href="\${payload.result[i].renderUrl}"><span><liferay-ui:message key="view-program-details" /></span></a>
											<h5>\${payload.result[i].programName}</h5>
											<div class="buttons-wrap">
												<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_ADD_COHORT)}"> 
													<a href="\${payload.result[i].addProgramCohortRenderUrl}" class="add_cohort_button"><i class="fa fa-plus-circle" aria-hidden="true"></i> <liferay-ui:message key="add-cohort" /></a>
												</c:if>
												<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_VIEW_COHORT)}">	
													<a href="\${payload.result[i].viewProgramCohortRenderUrl}" class="view_cohort_button"><i class="fa fa-eye" aria-hidden="true"></i> <liferay-ui:message key="view-cohort" /></a>
												</c:if>
											</div>
										</div> 
							</c:if>
							<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, NON_ADMIN_PROGRAM_LIST_VIEW) && !permissionChecker.isOmniadmin()}">
									 <div class="card-info \${getProgramCardColor(payload.result[i].programType)}-info-card">
										<h5>\${payload.result[i].programName}</h5>
										<div class="buttons-wrap">
											<a href="\${payload.result[i].renderUrl}" class="view_program_details_button"> <i class="fa fa-eye" aria-hidden="true"></i> <liferay-ui:message key="view-program-details" /></a>
										</div>
									</div>
							</c:if>	 
							</div>`;
					}
				} else {
					programCard = `<div class="col-md-12"><div class="omsb-no-data-found"><p><liferay-ui:message key="no-such-programs-found" /></p></div></div>`;
				}
				$('#program-row').html(programCard);
				fixedButtom();
			}
		});
	}

	function getProgramCardColor(programType) {
		let card = "black";
		if (programType == 1) {
			card = "red";
		} else if (programType == 2) {
			card = "blue";
		}
		return card;
	}
</script>