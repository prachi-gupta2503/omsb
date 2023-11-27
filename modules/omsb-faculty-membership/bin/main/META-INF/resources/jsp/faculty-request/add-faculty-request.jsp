<%@include file="../../init.jsp"%>
<style>
.faculty-request-file .has-error .form-feedback-item {
	position: absolute !important;
	margin-top: 23% !important;
}
</style>
<portlet:renderURL var="facultyRequestsURL">
	<portlet:param name="mvcRenderCommandName"
		value="/" />
</portlet:renderURL>
<portlet:resourceURL var="getTrainingSiteURL"
	id="<%=FacultyRequestConstants.GET_TRAINING_SITE_RESOURCE_COMMMAND%>" />
<portlet:actionURL
	name="<%=FacultyRequestConstants.ADD_FACULTY_REQUEST_ACTION_COMMAND%>"
	var="addFacultyRequestURL" />

<div class="container" id="wrapper">
	<div class="omsb-card">
		<div class="omsb-page-top-info">
			<div class="pagetitle">
				<liferay-ui:message key="faculty-request-new-faculty-request" />
			</div>
		</div>
		<c:set var="notAvailable"><liferay-ui:message key="not-available"/></c:set>
		<div class="row">
			<div class="col-lg-4 col-md-6">
				<div class="form-group-view">
					<div class="label-name">
						<liferay-ui:message key="faculty-request-potential-faculty-name" />
					</div>
					<div class="label-content">
						${personalDetails.personName != null ? personalDetails.personName : notAvailable}
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-md-6">
				<div class="form-group-view">
					<div class="label-name">
						<liferay-ui:message key="email" />
					</div>
					<div class="label-content">
						${personalDetails.email != null ? personalDetails.email : notAvailable}
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-md-6">
				<div class="form-group-view">
					<div class="label-name">
						<liferay-ui:message key="mobile" />
					</div>
					<div class="label-content">
						${personalDetails.mobile != null ? personalDetails.mobile : notAvailable}
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-md-6">
				<div class="form-group-view">
					<div class="label-name">
						<liferay-ui:message key="civil-id" />
					</div>
					<div class="label-content">
						${personalDetails.civilId != null ? personalDetails.civilId : notAvailable}
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-md-6">
				<div class="form-group-view">
					<div class="label-name">
						<liferay-ui:message key="faculty-request-passport-no" />
					</div>
					<div class="label-content">
						${personalDetails.passportNumber != null ? personalDetails.passportNumber : notAvailable}
					</div>
				</div>
			</div>
			<div class="col-lg-4 col-md-6">
				<div class="form-group-view">
					<div class="label-name">
						<liferay-ui:message key="date-of-birth" />
					</div>
					<div class="label-content">
						${personalDetails.dateOfBirth != null ? personalDetails.dateOfBirth : notAvailable}
					</div>
				</div>
			</div>
		</div>
		<aui:form action="<%=addFacultyRequestURL%>" method="post" name="fm">
			<aui:input name="personId" id="personId" type="hidden"
				value="${personalDetails.personId}" />
			<div class="row">
				<div class="col-lg-4 col-md-6">
					<div class="form-group">
						<aui:select class="form-control js-basic-single" id="programId"
							name="programId" label="program"
							onclick="getTrainingSite()">
							<aui:option value="">
								<liferay-ui:message key="common-select" />
							</aui:option>
							<c:forEach items="${programMasterList}" var="program">
								<aui:option value="${program.programMasterId }">${program.programName}</aui:option>
							</c:forEach>
							<aui:validator name="required" />
						</aui:select>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="form-group">
						<aui:select name="trainingSiteId" id="trainingSiteId"
							label="training-site" disabled="true">
							<aui:option value="">
								<liferay-ui:message key="common-select" />
							</aui:option>
							<aui:validator name="required" />
						</aui:select>
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="form-group">
						<div class="custom-file faculty-request-file">
							<aui:input type="file" class="custom-file-input"
								label="faculty-request-curriculum-vitae" id="curriculamVitae"
								name="curriculamVitae" onChange="fileSize(this)">
								<aui:validator name="required" />
								<aui:validator name="acceptFiles">'pdf,docx,doc'</aui:validator>
								<aui:validator name="custom" errorMessage="File size should not be more than 2Mb">
									function(){
										if(!uploadSize){
											return true;
										}
									}
								</aui:validator>
							</aui:input>
							<label class="custom-file-label"
								for="<portlet:namespace/>curriculamVitae"></label>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12">
					<div class="form-group">
						<aui:input type="textarea" name="comments" id="comments"
							label="comments">
							<aui:validator name="maxLength">1000</aui:validator>
						</aui:input>
					</div>
				</div>
			</div>
			<div class="bottom-backbtn-wrap">
				<button class="btn omsb-bc-red-button">
					<liferay-ui:message key="faculty-request-create-request" />
				</button>
				<a class="btn omsb-btn btn-back" href="${facultyRequestsURL}"><liferay-ui:message
						key="cancel" /> </a>
			</div>
		</aui:form>
	</div>
</div>

<script>
	
	function getTrainingSite(){
		let programId = $('#<portlet:namespace />programId').val();
		if(programId !=""){
			$("#<portlet:namespace />trainingSiteId").empty();
			$('#<portlet:namespace />trainingSiteId').removeAttr("disabled");
			$('#<portlet:namespace />trainingSiteId').removeClass('disabled');
			$("#<portlet:namespace />trainingSiteId").append(new Option("Select",""));
			let url = '<%=getTrainingSiteURL.toString()%>';
			$.ajax({
				type : "GET",
				url : url + "&<portlet:namespace/>programId=" + programId,
				contentType : "application/json",
				success : function(response) {
					$.each(JSON.parse(response), function(index, trainingSite) {
						$("#<portlet:namespace/>trainingSiteId").append(
								new Option(trainingSite.trainingSiteName,
										trainingSite.trainingSiteId));
					});
				},
				error : function() {
				}
			});
		} else {
			$('#<portlet:namespace />trainingSiteId').addClass("disabled");
			$('#<portlet:namespace />trainingSiteId').attr("disabled",
					"disabled");
		}
	}
	
	var uploadSize=true; 
	function fileSize(fileInput){
		const maxSize = 2* 1024 * 1024; // 2MB in bytes
		const file = fileInput.files[0];
		const size = file.size;
		if(size > maxSize){
			uploadSize=true;
		}else{
			uploadSize=false;
		}
	}
</script>