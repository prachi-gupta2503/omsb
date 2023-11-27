<%@ include file="../../init.jsp"%>
<portlet:renderURL var="backURL">
	<portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>
<div class="omsb-main-wrapper" id="omsb-main-wrapper">
	<div class="container" id="wrapper">
		<div class="omsb-card">
			<div class="omsb-page-top-info">
				<div class="pagetitle"><liferay-ui:message key="dataflow-verification" /> ${personalDetail.givenNameAsPassport}</div>
			</div>
			<div class="omsb-label-view ">
				<div class="label-group-header row omsb-page-top-info">
				<div><liferay-ui:message key="personal-details" /></div>
					<div class="information status-info">
					<label class="label-name"><liferay-ui:message key="status" /></label>
					<label class="label-content">${caseStatusItem}</label>
				</div>
				</div>
				
				<div class="row">

					<div class="col-md-3 label-box">
						<label class="label-name"><liferay-ui:message key="given-name-as-passport" /></label> 
						<label class="label-content">${personalDetail.givenNameAsPassport}</label>
					</div>
					<div class="col-md-3 label-box">
						<label class="label-name"><liferay-ui:message key="applicant-surname" /></label> 
						<label class="label-content">${personalDetail.applicantSurname}</label>
					</div>
					<div class="col-md-3 label-box">
						<label class="label-name"><liferay-ui:message key="date-of-birth" /></label> 
						<label class="label-content">${person.dateOfBirth}</label>
					</div>
					<div class="col-md-3 label-box">
						<label class="label-name"><liferay-ui:message key="country" /></label> 
						<label class="label-content">${personalDetail.countryName}</label>
					</div>
					<div class="col-md-3 label-box">
						<label class="label-name"><liferay-ui:message key="nationality" /></label> 
						<label class="label-content">${personalDetail.nationalityCountryName}</label>
					</div>
					<div class="col-md-3 label-box">
						<label class="label-name"><liferay-ui:message key="passport-number" /></label> 
						<label class="label-content">${person.passportNumber}</label>
					</div>
					 <div class="col-md-3 label-box">
						
					<c:set var="caseReport" value="" />
				<c:set var="caseReport" value="${caseReportsFileURL};" />
					<label class="label-name"><liferay-ui:message key="case-report" /></label>
					<%-- <button class="clickable-row dropdown-item download-link" data-toggle="modal" data-edd="${caseReport}" 
						data-State="${caseReportsFileURL}" data-target="#case-report"> <liferay-ui:message key="preview-case-report" /></button> --%>
						 <a target="_blank" class="download-link" href="${caseReportsFileURL}"><liferay-ui:message key="preview-case-report" /></a>
					</div> 
					<%-- <div class="col-md-3 label-box">
						   
				    	<c:forEach var="cert" items="${personalDetail.items}">	
				    	 <label class="label-name"><liferay-ui:message key="passport-certificate" /></label> 
				 		 <label class="label-content education-certificate">					    	
				            <a download class="download-link" href="${cert.educationCertificateUrl}"><liferay-ui:message key="download-passport" /></a>
			             </label>
				    	</c:forEach>
					</div>  --%>
					<div class="col-md-3 label-box">
						 <label class="label-name"><liferay-ui:message key="personal-certificate" /></label>   
				    	<c:forEach var="cert" items="${personalDetail.items}">	
				 		 <label class="label-content">					    	
				            <a target="_blank" class="download-link" href="${cert.personalCertificateUrl}">${cert.personalCertificateName}</a>
			             </label>
				    	</c:forEach>
					</div> 
				</div>

				<ul class="nav nav-pills mb-3 tabview" id="pills-tab" role="tablist">
					<li class="nav-item" role="presentation">
						<button class="nav-link active" id="education-tab" data-toggle="pill" data-target="#education-detail" type="button"
							role="tab" aria-controls="education-detail" aria-selected="true">
							<liferay-ui:message key="education-details" /></button>
					</li>
					<li class="nav-item" role="presentation">
						<button class="nav-link" id="employment-tab" data-toggle="pill" data-target="#employment-detail" type="button" role="tab"
							aria-controls="employment-detail" aria-selected="false">
							<liferay-ui:message key="employment-detail" /></button>
					</li>
					<li class="nav-item" role="presentation">
						<button class="nav-link" id="health-tab" data-toggle="pill" data-target="#health-detail" type="button" role="tab"
							aria-controls="health-detail" aria-selected="false">
							<liferay-ui:message key="health-license-detail" /></button>
					</li>
					<li class="nav-item" role="presentation">
						<button class="nav-link" id="reference-tab" data-toggle="pill" data-target="#reference-detail" type="button" role="tab"
							aria-controls="reference-detail" aria-selected="false">
							<liferay-ui:message key="reference-detail" /></button>
					</li>
					<li class="nav-item" role="presentation">
						<button class="nav-link" id="payment-tab" data-toggle="pill" data-target="#payment-detail" type="button" role="tab"
							aria-controls="payment-detail" aria-selected="false">
							<liferay-ui:message key="payment-detail" /></button>
					</li>
				</ul>

				<div class="tab-content" id="pills-tabContent">
					<div class="tab-pane fade show active" id="education-detail" role="tabpanel" aria-labelledby="education-tab">
						<%@ include file="/jsps/view-verification/view-education-detail.jspf"%>
					</div>
					<div class="tab-pane fade" id="employment-detail" role="tabpanel" aria-labelledby="employment-tab">
						<%@ include file="/jsps/view-verification/view-employment-detail.jspf"%>
					</div>

					<div class="tab-pane fade" id="health-detail" role="tabpanel" aria-labelledby="health-tab">
						<%@ include file="/jsps/view-verification/view-health-license-detail.jspf"%>
					</div>

					<div class="tab-pane fade" id="reference-detail" role="tabpanel" aria-labelledby="reference-tab">
						<%@ include file="/jsps/view-verification/view-reference-detail.jspf"%>
					</div>
					<div class="tab-pane fade" id="payment-detail" role="tabpanel" aria-labelledby="payment-tab">
						<%@ include file="/jsps/view-verification/view-payment-detail.jspf"%>
					</div>

					<div class="tab-pane fade" id="case-detail" role="tabpanel" aria-labelledby="case-tab">
						<%@ include file="/jsps/view-verification/view-case-report.jspf"%>
					</div>
				</div>
			</div>
			<div class="omsb-top-buttons omsb-card">
				<button class="btn omsb-btn btn-back d-none"> <i class="fi fi-sr-arrow-left"></i> <liferay-ui:message key="back" /></button>
				<a class="btn omsb-btn btn-back" href="<%=backURL%>"><i class="fi fi-sr-arrow-left"></i> <liferay-ui:message key="back" /></a>
			</div>
		</div>
		
	</div>
</div>
<!-- popup 1 -->
<div class="modal fade" id="case-report" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog information-box" role="document">
		<div class="modal-content">
			<div class="modal-header d-none">
				<h5 class="modal-title" id="exampleModalLabel"><liferay-ui:message key="case-report" /></h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"> 
					<span aria-hidden="true">&times;</span> 
				</button>
			</div>
			<div class="modal-body">
				<div class="omsb-label-view ">
					<div class="label-group-header row">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
						<div class="row">
							<div class="col-md-12 label-box document-pageview">
							
								<iframe id="documentFrame" src="${caseReportsFileURL}" ></iframe>
								<label class="label-name"><liferay-ui:message key="case-report" /></label> 
								<label class="label-content"><a download href="${caseReportsFileURL}" ><liferay-ui:message key="download-case-report" /></a></label>
							</div>
						</div>
				</div>
			</div>
			<div class="modal-footer d-none">
				<button type="button" class="btn btn-secondary" data-dismiss="modal"><liferay-ui:message key="close" /></button>
				<button type="button" class="btn btn-primary"><liferay-ui:message key="save-changes" /></button>
			</div>
		</div>
	</div>
</div>
<!-- popup1 -->
<script type="text/javascript">
$('#case-report').on('show.bs.modal', function (event) {
	  var button = $(event.relatedTarget) // Button that triggered the modal
	  var rowContent = button.data('edd');
	  var recipientState = button.data('state');
	  var array = rowContent.split(";");
	  console.log("",array);
	  var modal = $(this)
	})
	
	$("[data-bs-toggle='dropdown']").click(function() {
		$(this).siblings("ul.dropdown-menu").toggleClass("show");
	})

	$(document).ready(
			function() {
				var trigger = $('.hamburger'), overlay = $('.overlay'), isClosed = false;
	
				trigger.click(function() {
					hamburger_cross();
				});
	
				function hamburger_cross() {
	
					if (isClosed == true) {
						overlay.hide();
						trigger.removeClass('is-open');
						trigger.addClass('is-closed');
						isClosed = false;
					} else {
						overlay.show();
						trigger.removeClass('is-closed');
						trigger.addClass('is-open');
						isClosed = true;
					}
				}
	
				$('[data-toggle="offcanvas"]').click(function() {
					$('#omsb-main-wrapper').toggleClass('toggled');
				});
			});
</script>