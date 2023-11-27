<%@page import="omsb.vehpc.equivalency.web.constants.ArabicConstant"%>
<%@include file="../init.jsp"%>
<%-- <portlet:actionURL var="saveCertificateURL"
	name="<%=MVCCommandNames.SAVE_UPLOADED_CERTIFICATE_ACTION%>"></portlet:actionURL>
<portlet:actionURL var="editCertificateURL"
	name="<%=MVCCommandNames.SAVE_UPLOADED_CERTIFICATE_ACTION%>"></portlet:actionURL>
<portlet:resourceURL var="previewURL"
	id="<%=MVCCommandNames.PREVIEW_CERTIFICATE_RESOURCE%>"></portlet:resourceURL> --%>
<input type="hidden" name="<portlet:namespace/>htmlDivData" id="htmlDivData">
<div class="omsb-card">
	<h4 class="omsb-card-title">
		<liferay-ui:message key="equivalency-certificate" />
	</h4>
	<div class="row m-0">
		<div class="col-lg-4 col-md-6 col-sm-12">
			<div class="form-group">
				<div class="custom-control custom-radio ">
					<input type="radio" class="custom-control-input showCert"
						id="uploadCertificate" checked name="<portlet:namespace/>certType"
						value="1">
					<label class="custom-control-label m-0" for="uploadCertificate"><liferay-ui:message
							key="upload-eq-certificate" /></label>
				</div>
			</div>
		</div>

		<div class="col-lg-4 col-md-6 col-sm-12">
			<div class="form-group">
				<div class="custom-control custom-radio ">
					<div class="custom-control custom-radio ">
						<input type="radio" class="custom-control-input showCert"
							id="certificateInEnglish" name="<portlet:namespace/>certType"
							value="2">
						<label class="custom-control-label m-0" for="certificateInEnglish"><liferay-ui:message
								key="edit-certificate-in-english" /></label>
					</div>
				</div>
			</div>
		</div>
		<div class="col-lg-4 col-md-6 col-sm-12">
			<div class="form-group">
				<div class="custom-control custom-radio ">
					<div class="custom-control custom-radio ">
						<input type="radio" class="custom-control-input showCert"
							id="certificateInArabic" name="<portlet:namespace/>certType"
							value="3">
						<label class="custom-control-label m-0" for="certificateInArabic"><liferay-ui:message
								key="edit-certificate-in-arabic" /></label>
					</div>
				</div>
			</div>
		</div>
	</div>
	<aui:input name="equivalencyRequestId" type="hidden"
		value="${equivalencyRequestId}" />
	<div class="uploadCertificate d-none">
		<%@include file="./upload-certificate.jsp"%>
	</div>
	<div class="certificateInEnglish d-none">
		<%@include file="./english-certificate.jsp"%>
		<div class="saveCertificateInEnglish d-none">
			<%@include file="./save-english-certificate.jsp"%>
		</div>
		
	</div>
	<div class="certificateInArabic d-none">
		<%@include file="./arabic-certificate.jsp"%>
		<div class="saveCertificateInArabic d-none">
			<%@include file="./save-arabic-certificate.jsp"%>
		</div>
	</div>
	<%-- <div class="omsb-card">
		<div class="col-md-12 test">
			<%@include file="preview-certificate.jsp"%>
		</div>
	</div> --%>
</div>

<script type="text/javascript">
	$('#birthDate').datepicker({
		format : "dd/mm/yyyy",
		orientation : "bottom auto",
		autoclose : true
	}).on('change', function() {
		$('.datepicker').hide();
	});
	
	$('#birthDateArabic').datepicker({
		format : "dd/mm/yyyy",
		orientation : "bottom auto",
		autoclose : true
	}).on('change', function() {
		$('.datepicker').hide();
	});

	$('.uploadCertificate').removeClass('d-none');
	$(".showCert").on('click', function() {
		var value = $(this).val();
		if (value == 1) {
			$('.uploadCertificate').removeClass('d-none');
			$('.certificateInEnglish').addClass('d-none');
			$('.certificateInArabic').addClass('d-none');
		} else if (value == 2) {
			$('.certificateInEnglish').removeClass('d-none');
			$('.uploadCertificate').addClass('d-none');
			$('.certificateInArabic').addClass('d-none');
		} else if (value == 3) {
			$('.certificateInEnglish').addClass('d-none');
			$('.uploadCertificate').addClass('d-none');
			$('.certificateInArabic').removeClass('d-none');

		}
	});
	/* $(".preview-certificate").on('click', function() {
		var form = $('edit_certificate_fm');
		var div = $('.preview-cert');
		$.ajax({
			type : 'POST',
			url : '${previewURL}',
			async : false,
			data : $("#edit_certificate_fm").serialize(),
			success : function(data) {
				$('#previewCertificateModal').modal('show');
				console.log('data is ', data);
				div.html(data);
			},
		});
	}); */
	
	$('#certificateFullName').keyup(function(){
		document.getElementById('saveCertificateFullName').innerHTML = $('#certificateFullName').val();
	});
	$('#certificatePassportNumber').keyup(function(){
		document.getElementById('saveCertificatePassportNumber').innerHTML = $('#certificatePassportNumber').val();
	});
	$('#birthDate').on('change',function(){
		document.getElementById('saveBirthDate').innerHTML = $('#birthDate').val();
	});
	$('#certificateEmployer').keyup(function(){
		document.getElementById('saveCertificateEmployer').innerHTML = $('#certificateEmployer').val();
	});
	function updateCertificateName(count){
		document.getElementById('saveCertificateName'+count).innerHTML = $('#certificateName'+count).val();
	}
	function updateCertificateCountry(count){
		document.getElementById('saveCertificateCountry'+count).innerHTML = $('#certificateCountry'+count).val();
	}
	function updateCertificateYear(count){
		document.getElementById('saveCertificateYear'+count).innerHTML = $('#certificateYear'+count).val();
	}
	
	$('#certificateFullNameArabic').keyup(function(){
		document.getElementById('saveCertificateFullNameArabic').innerHTML = $('#certificateFullNameArabic').val();
	});
	$('#certificatePassportNumberArabic').keyup(function(){
		document.getElementById('saveCertificatePassportNumberArabic').innerHTML = $('#certificatePassportNumberArabic').val();
	});
	$('#birthDateArabic').on('change',function(){
		document.getElementById('saveBirthDateArabic').innerHTML = $('#birthDateArabic').val();
	});
	$('#certificateEmployerArabic').keyup(function(){
		document.getElementById('saveCertificateEmployerArabic').innerHTML = $('#certificateEmployerArabic').val();
	});
	function updateCertificateNameArabic(count){
		document.getElementById('saveCertificateNameArabic'+count).innerHTML = $('#certificateNameArabic'+count).val();
	}
	function updateCertificateCountryArabic(count){
		document.getElementById('saveCertificateCountryArabic'+count).innerHTML = $('#certificateCountryArabic'+count).val();
	}
	function updateCertificateYearArabic(count){
		document.getElementById('saveCertificateYearArabic'+count).innerHTML = $('#certificateYearArabic'+count).val();
	}
	
</script>
