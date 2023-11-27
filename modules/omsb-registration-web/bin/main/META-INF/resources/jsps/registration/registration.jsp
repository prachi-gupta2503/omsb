<%@page import="gov.omsb.registration.web.constants.MVCCommands"%>
<%@taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="wrapper">
	<div class="container">
		<div class="omsb-registration-card">
			<div class="omsb_register_tab">
				<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
					<%-- <input type="hidden" name="personalDetails" value="${empty personalDetails}"> --%>
					<li class="nav-item" id="personalDetail-li" role="presentation">
						<button class="nav-link active" id="pills-trainees-tab"
							data-toggle="pill" data-click="personalDetail"
							data-target="#pills-trainees" type="button" role="tab"
							aria-controls="pills-trainees" aria-selected="true"
							onclick="openPersonalDetail()">
							<span></span>
							<liferay-ui:message key="registration-personal-details" />
						</button>
					</li>

					<c:choose>
						<c:when test="${not empty personalDetails}">
							<li id="educationDetail-li" class="nav-item" role="presentation">
								<button class="nav-link" id="pills-rotation-tab"
									data-toggle="pill" data-click="educationDetail"
									data-target="#pills-rotation" type="button" role="tab"
									aria-controls="pills-rotation" aria-selected="false"
									onclick="openEducationDetails('educationTab')">
									<span></span>
									<liferay-ui:message key="education-details" />
								</button>
							</li>

							<li class="nav-item" id="workDetail-li" role="presentation">
								<button class="nav-link" id="pills-rotation-tab"
									data-toggle="pill" data-click="workDetail"
									data-target="#pills-rotation" type="button" role="tab"
									aria-controls="pills-rotation" aria-selected="false"
									onclick="openWorkDetails('true','yes')">
									<span></span>
									<liferay-ui:message key="registration-work-details" />
								</button>
							</li>

							<li class="nav-item" id="roleService-li" role="presentation">
								<button class="nav-link" id="pills-rotation-tab"
									data-toggle="pill" data-click="roleService"
									data-target="#pills-rotation" type="button" role="tab"
									aria-controls="pills-rotation" aria-selected="false"
									onclick="openRoleService('true')">
									<span></span>
									<liferay-ui:message key="registration-role-service" />
								</button>
							</li>
						</c:when>
						<c:otherwise>
							<li class="nav-item" role="presentation" id="educationDetail-oli" >
								<button class="nav-link" id="pills-rotation-tab" data-click="oEducationDetail" 
									type="button" onclick="showContent(true, false, false, false)">
									<span></span>
									<liferay-ui:message key="education-details" />
								</button>
							</li>

							<li class="nav-item" role="presentation" id="workDetail-oli" >
								<button class="nav-link" id="pills-rotation-tab" data-click="oWorkDetail" 
									type="button" onclick="showContent(true, false, false, false)">
									<span></span>
									<liferay-ui:message key="registration-work-details" />
								</button>
							</li>

							<li class="nav-item" role="presentation" id="roleService-oli" >
								<button class="nav-link" id="pills-rotation-tab" data-click="oRoleService" 
									type="button" onclick="showContent(true, false, false, false)">
									<span></span>
									<liferay-ui:message key="registration-role-service" />
								</button>
							</li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>

			<div id="personal-details">
				<%@ include file="/jsps/registration/personal-details.jsp"%>
			</div>
			<div id="education-details" class="d-none"></div>
			<div id="work-details" class="d-none"></div>
			<div id="role-service" class="d-none"></div>
		</div>
	</div>
</div>



<%-- <div class="loader-container d-none">
	<div class="loaded">
		<img src="<%=themeDisplay.getPathThemeImages()%>/svg/loader.svg"
			alt="loader">
	</div>
</div> --%>

<button hidden id="openModel" data-senna-off="true" data-toggle="modal"
	data-target="#personal-detail-required-model"
	data-rowcount="addPopUpRow"></button>
<div class="modal fade omsb-modal" id="personal-detail-required-model"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered w-50" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="omsb-card omsb-card-graybg row d-none"
					id="personal-details-required-content">
					<div>
						<liferay-ui:message key="personal-details-required" />
					</div>
				</div>

				<div class="omsb-card omsb-card-graybg row d-none"
					id="education-details-required-content">
					<div>
						<liferay-ui:message key="education-details-required" />
					</div>
				</div>

				<div class="omsb-card omsb-card-graybg row d-none"
					id="employment-details-required-content">
					<div>
						<liferay-ui:message key="employment-details-required" />
					</div>
				</div>

				<div class="omsb-card omsb-card-graybg row d-none"
					id="role-service-required-content">
					<div>
						<liferay-ui:message key="role-service-required" />
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<button hidden class="btn omsb-btn btn-red" data-toggle="modal"
	data-target="#examConformationPopUpBox"
	id="openExamConformationPopUpBox"></button>
<div class="modal fade omsb-modal" id="examConformationPopUpBox"
	tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">
					<liferay-ui:message key="Conformation" />
				</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body"></div>
			<div class="modal-footer">
				<button class="btn omsb-bg-red-button" id="confirmExamButtonNext"
					onclick="openWorkDetails('true','no')" title="Confirm">
					<liferay-ui:message key="confirm" />
				</button>
				<button type="button" id="educationPopUpCancelbutton"
					class="btn omsb-btn omsb-bg-red-button" data-dismiss="modal">
					<liferay-ui:message key="cancel" />
				</button>
			</div>
		</div>
	</div>
</div>

<portlet:resourceURL id="<%=MVCCommands.EDUCATION_DETAIL_RESOURCE%>" var="getEduDetailsURL" />
<portlet:resourceURL id="<%=MVCCommands.WORK_DETAIL_RESOURCE%>" var="getWorkDetailsURL" />
<portlet:resourceURL id="<%=MVCCommands.ROLE_SERVICE_RESOURCE%>" var="getRoleServiceURL" />
<portlet:resourceURL id="<%=MVCCommands.PERSONAL_DETAIL_RESOURCE%>" var="getPersonalDetailURL" />

<script>
	function openPersonalDetail() {
		addLoader();
		setTimeout(function() {
			var personId = $('#personId').val();
			var lrUserId = $('#lrUserId').val();
			var formData = new FormData();
			formData.append('<portlet:namespace />personId', personId);
			formData.append('<portlet:namespace />lrUserId', lrUserId);
			$.ajax({
				url : '${getPersonalDetailURL}',
				async : false,
				dataType : "json",
				contentType : false,
				cache : false,
				data : formData,
				processData : false,
				type : 'POST',
				success : function(data) {
					$("#personal-details").html(data);
					$('#education-details').html('');
					$('#work-details').html('');
					$('#role-service').html('');
	
					$('#personal-details').removeClass('d-none');
					$('#education-details').addClass('d-none');
					$('#work-details').addClass('d-none');
					$('#role-service').addClass('d-none');
					
					$("[data-click=personalDetail]").addClass('active');
					$("[data-click=roleService]").removeClass('active');
					$("[data-click=workDetail]").removeClass('active');
					$("[data-click=educationDetail]").removeClass('active');
				},
				complete : function(data) {
					$("#personal-details").html(data.responseText);
					$('#education-details').html('');
					$('#work-details').html('');
					$('#role-service').html('');
	
					$('#personal-details').removeClass('d-none');
					$('#education-details').addClass('d-none');
					$('#work-details').addClass('d-none');
					$('#role-service').addClass('d-none');
					
					$("[data-click=personalDetail]").addClass('active');
					$("[data-click=roleService]").removeClass('active');
					$("[data-click=workDetail]").removeClass('active');
					$("[data-click=educationDetail]").removeClass('active');
					
					$("[data-click=oEducationDetail]").removeClass('active');
					$("[data-click=oWorkDetail]").removeClass('active');
					$("[data-click=oRoleService]").removeClass('active');
					//removeLoader();
					setTimeout(function() {
						removeLoader();
					}, 200);
				},
			})
		
		}, 300);
		
		
	}

	function openEducationDetails(educationTab) {
		addLoader();
		setTimeout(function() {
		
		var personId = $('#personId').val();
		var lrUserId = $('#lrUserId').val();
		var formData = new FormData();
		formData.append('<portlet:namespace />personId', personId);
		formData.append('<portlet:namespace />lrUserId', lrUserId);
		$.ajax({
			url : '${getEduDetailsURL}',
			async : false,
			dataType : "json",
			contentType : false,
			cache : false,
			data : formData,
			processData : false,
			type : 'POST',
			success : function(data) {
				$("#personal-details").html('');
				$("#education-details").html(data);
				$('#work-details').html('');
				$('#role-service').html('');

				$('#personal-details').addClass('d-none');
				$('#education-details').removeClass('d-none');
				$('#work-details').addClass('d-none');
				$('#role-service').addClass('d-none');
				
				$("[data-click=personalDetail]").removeClass('active');
				$("[data-click=educationDetail]").addClass('active');
				$("[data-click=workDetail]").removeClass('active');
				$("[data-click=roleService]").removeClass('active');
				
				$("[data-click=oEducationDetail]").addClass('active');
				$("[data-click=oWorkDetail]").removeClass('active');
				$("[data-click=oRoleService]").removeClass('active');
			},
			complete : function(data) {
				$("#personal-details").html('');
				$("#education-details").html(data.responseText);
				$('#work-details').html('');
				$('#role-service').html('');

				$('#personal-details').addClass('d-none');
				$('#education-details').removeClass('d-none');
				$('#work-details').addClass('d-none');
				$('#role-service').addClass('d-none');
				
				$("[data-click=personalDetail]").removeClass('active');
				$("[data-click=educationDetail]").addClass('active');
				$("[data-click=workDetail]").removeClass('active');
				$("[data-click=roleService]").removeClass('active');
				
				$("[data-click=oEducationDetail]").addClass('active');
				$("[data-click=oWorkDetail]").removeClass('active');
				$("[data-click=oRoleService]").removeClass('active');
				setTimeout(function() {
					removeLoader();
				}, 200);
			},
		})
		
		}, 300);
		
	}

function openWorkDetails(isNext,tab) {
	console.log("called isNext openWorkDetails");
	addLoader();
	console.log("called 2 openWorkDetails");	
	setTimeout(function() {
		var personId = $('#personId').val();
		var lrUserId = $('#lrUserId').val();
		console.log("personId :::",personId);
		console.log("lrUserId :::",lrUserId);
		console.log("isNext :::",isNext);
		var formData = new FormData();
		formData.append('<portlet:namespace />personId', personId);
		formData.append('<portlet:namespace />lrUserId', lrUserId);
		formData.append('<portlet:namespace />isNext', isNext);
		console.log("formData ::::",formData);
		
		$.ajax({
			url : '${getWorkDetailsURL}',
			async : false,
			dataType : "json",
			contentType : false,
			cache : false,
			data : formData,
			processData : false,
			type : 'POST',
			success : function(data) {
				 console.log("inside success");
				$("#personal-details").html('');
				$("#education-details").html('');
				$('#work-details').html(data);
				$('#role-service').html('');

				$('#personal-details').addClass('d-none');
				$('#education-details').addClass('d-none');
				$('#work-details').removeClass('d-none');
				$('#role-service').addClass('d-none');
				
				$("[data-click=personalDetail]").removeClass('active');
				$("[data-click=educationDetail]").removeClass('active');
				$("[data-click=workDetail]").addClass('active');
				$("[data-click=roleService]").removeClass('active');
				
				$("[data-click=oEducationDetail]").removeClass('active');
				$("[data-click=oWorkDetail]").addClass('active');
				$("[data-click=oRoleService]").removeClass('active'); 
			},
			complete : function(data) {
				console.log("inside complete");
				
				
				
				console.log("isNext  ::::",isNext==='false');
				console.log("isNext  ::::",isNext==='true');
				
				if(isNext==='true'){
					 console.log("is next clicked ::::;");
					$("#personal-details").html('');
					$("#education-details").html('');
					$('#work-details').html(data.responseText);
					$('#role-service').html('');
					$('#personal-details').addClass('d-none');
					$('#education-details').addClass('d-none');
					$('#work-details').removeClass('d-none');
					$('#role-service').addClass('d-none');
					$("[data-click=personalDetail]").removeClass('active');
					$("[data-click=educationDetail]").removeClass('active');
					$("[data-click=workDetail]").addClass('active');
					$("[data-click=roleService]").removeClass('active');
					
					$("[data-click=oEducationDetail]").removeClass('active');
					$("[data-click=oWorkDetail]").addClass('active');
					$("[data-click=oRoleService]").removeClass('active'); 
				}else{
					console.log("is save at this stage called ::: clicked ::::;");
					/* $("#personal-details").html('');
					$("#education-details").html('');
					$('#work-details').html(data.responseText);
					$('#role-service').html('');

					$('#personal-details').addClass('d-none');
					$('#education-details').removeClass('d-none');
					$('#work-details').addClass('d-none');
					$('#role-service').addClass('d-none');
					$("[data-click=personalDetail]").removeClass('active');
					$("[data-click=educationDetail]").addClass('active');
					$("[data-click=workDetail]").removeClass('active');
					$("[data-click=roleService]").removeClass('active');
					
					$("[data-click=oEducationDetail]").addClass('active');
					$("[data-click=oWorkDetail]").removeClass('active');
					$("[data-click=oRoleService]").removeClass('active'); */
				}
				
				if(tab=="no"){
					$("#educationDetailSuccess").removeClass("d-none");
				}
				
				//removeLoader();
				setTimeout(function() {
					removeLoader();
				}, 200);
			}
		})
		$('#examConformationPopUpBox').modal('hide');
		
		//close time out
		},300);
	}

	function openRoleService(isNext) {
		addLoader();
		setTimeout(function() {
		
			var personId = $('#personId').val();
			var lrUserId = $('#lrUserId').val();
			var formData = new FormData();
			formData.append('<portlet:namespace />personId', personId);
			formData.append('<portlet:namespace />lrUserId', lrUserId);
			formData.append('<portlet:namespace />isNext', isNext);
			$.ajax({
				url : '${getRoleServiceURL}',
				async : false,
				dataType : "json",
				contentType : false,
				cache : false,
				data : formData,
				processData : false,
				type : 'POST',
				success : function(data) {
					$("#personal-details").html('');
					$("#education-details").html('');
					$('#work-details').html('');
					$('#role-service').html(data);
	
					$('#personal-details').addClass('d-none');
					$('#education-details').addClass('d-none');
					$('#work-details').addClass('d-none');
					$('#role-service').removeClass('d-none');
					
					$("[data-click=personalDetail]").removeClass('active');
					$("[data-click=educationDetail]").removeClass('active');
					$("[data-click=workDetail]").removeClass('active');
					$("[data-click=roleService]").addClass('active');
					
					$("[data-click=oEducationDetail]").removeClass('active');
					$("[data-click=oWorkDetail]").removeClass('active');
					$("[data-click=oRoleService]").addClass('active');
				},
				complete : function(data) {
					$("#personal-details").html('');
					$("#education-details").html('');
					$('#work-details').html('');
					$('#role-service').html(data.responseText);
	
					$('#personal-details').addClass('d-none');
					$('#education-details').addClass('d-none');
					$('#work-details').addClass('d-none');
					$('#role-service').removeClass('d-none');
					
					$("[data-click=personalDetail]").removeClass('active');
					$("[data-click=educationDetail]").removeClass('active');
					$("[data-click=workDetail]").removeClass('active');
					$("[data-click=roleService]").addClass('active');
					
					$("[data-click=oEducationDetail]").removeClass('active');
					$("[data-click=oWorkDetail]").removeClass('active');
					$("[data-click=oRoleService]").addClass('active');
					setTimeout(function() {
						removeLoader();
					}, 200);
				},
			})
		},300);
		
	}

	function showContent(viewPSD, viewEDD, viewEMD, viewRSD) {
		if (viewPSD) {
			$('#personal-details-required-content').removeClass('d-none');
		} else {
			$('#personal-details-required-content').addClass('d-none');
		}
		if (viewEDD) {
			$('#education-details-required-content').removeClass('d-none');
		} else {
			$('#education-details-required-content').addClass('d-none');
		}
		if (viewEMD) {
			$('#employment-details-required-content').removeClass('d-none');
		} else {
			$('#employment-details-required-content').addClass('d-none');
		}
		if (viewRSD) {
			$('#role-service-required-content').removeClass('d-none');
		} else {
			$('#role-service-required-content').addClass('d-none');
		}
		if (viewPSD || viewEDD || viewEMD || viewRSD) {
			$("#openModel").click();
		}
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