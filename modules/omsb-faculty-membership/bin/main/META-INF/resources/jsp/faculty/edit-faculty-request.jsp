<%@include file="../../init.jsp"%>

<portlet:renderURL var="facultyRequestsURL">
	<portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>

<portlet:actionURL
	name="<%=FacultyRequestConstants.EDIT_FACULTY_REQUEST_ACTION_COMMAND%>"
	var="editFacultyRequestURL" />

<style>
.faculty-request-file .has-error .form-feedback-item {
	position: absolute !important;
	margin-top: 9.5% !important;
}
</style>

<div class="container" id="wrapper">
	<div class="omsb-card">
		<div class="omsb-page-top-info">
			<div class="pagetitle">
				<liferay-ui:message key="faculty-request-edit-faculty-request" />
			</div>
		</div>
		<c:set var="notAvailable">
			<liferay-ui:message key="not-available" />
		</c:set>
		<div class="row">
			<div class="col-lg-3 col-md-6">
				<div class="form-group-view">
					<div class="label-name">
						<liferay-ui:message key="faculty-request-potential-faculty-name" />
					</div>
					<div class="label-content">${not empty fn:trim(personalDetails.personName) ? personalDetails.personName : notAvailable}
					</div>
				</div>
			</div>
			<div class="col-lg-3 col-md-6">
				<div class="form-group-view">
					<div class="label-name">
						<liferay-ui:message key="program" />
					</div>
					<div class="label-content">
						${not empty fn:trim(facultyRequestDetails.programName) ? facultyRequestDetails.programName : notAvailable}
					</div>
				</div>
			</div>
			<div class="col-lg-3 col-md-6">
				<div class="form-group-view">
					<div class="label-name">
						<liferay-ui:message key="training-site" />
					</div>
					<div class="label-content">
						${not empty fn:trim(facultyRequestDetails.trainingSiteName) ? facultyRequestDetails.trainingSiteName : notAvailable}
					</div>
				</div>
			</div>
			<div class="col-lg-3 col-md-6">
				<div class="form-group-view">
					<div class="label-name">
						<liferay-ui:message key="civil-id" />
					</div>
					<div class="label-content">${not empty fn:trim(personalDetails.civilId) ? personalDetails.civilId : notAvailable}
					</div>
				</div>
			</div>
			<div class="col-lg-3 col-md-6">
				<div class="form-group-view">
					<div class="label-name">
						<liferay-ui:message key="faculty-request-passport-no" />
					</div>
					<div class="label-content">${not empty fn:trim(personalDetails.passportNumber) ? personalDetails.passportNumber : notAvailable}
					</div>
				</div>
			</div>
			<div class="col-lg-3 col-md-6">
				<div class="form-group-view">
					<div class="label-name">
						<liferay-ui:message key="date-of-birth" />
					</div>
					<div class="label-content">${not empty fn:trim(personalDetails.dateOfBirth) ? personalDetails.dateOfBirth : notAvailable}</div>
				</div>
			</div>
			<div class="col-lg-3 col-md-6">
				<div class="form-group-view">
					<div class="label-name">
						<liferay-ui:message key="mobile" />
					</div>
					<div class="label-content">${not empty fn:trim(personalDetails.mobile) ? personalDetails.mobile : notAvailable}
					</div>
				</div>
			</div>
			<div class="col-lg-3 col-md-6">
				<div class="form-group-view">
					<div class="label-name">
						<liferay-ui:message key="email" />
					</div>
					<div class="label-content">${not empty fn:trim(personalDetails.email)? personalDetails.email : notAvailable}</div>
				</div>
			</div>
		</div>
		<aui:form action="<%=editFacultyRequestURL%>" method="post" name="fm">
			<aui:input name="personId" id="personId" type="hidden"
				value="${personalDetails.personId}" />
			<aui:input name="facultyRequestId" id="facultyRequestId"
				type="hidden"
				value="${facultyRequestDetails.facultyRequestDetailsId}" />
			<aui:input type="hidden" name="workflowTaskDetails" />
			<div class="row">
				<div class="col-lg-12 col-md-6">
					<div class="form-group-view mt-2">
						<div class="label-name">
							<liferay-ui:message key="faculty-request-curriculum-vitae" />
						</div>
						<div class="label-content">
							<c:if test="${empty facultyRequestDetails.cvFileUrl}">
								<div class="label-content">NA</div>
							</c:if>
							<c:if test="${not empty facultyRequestDetails.cvFileUrl}">
								<div class="omsb-card-caserport ">
									<div class="leftbar">
										<h4 class="casereport-title">
											${facultyRequestDetails.cvFileName}</h4>
									</div>
									<div class="righbar">
										<a href="${facultyRequestDetails.cvFileUrl}" target="_blank">
											<button class="btn view_btn" title="View" type="button">
												<img
													src="<%=themeDisplay.getPathThemeImages()%>/svg/view_icon.svg"
													alt="">
												<liferay-ui:message key="view" />
											</button>
										</a>
									</div>
								</div>
							</c:if>
						</div>
					</div>
				</div>
				<div class="col-lg-6 col-md-6">
					<div class="form-group">
						<aui:select name="facultyTypeId" id="facultyTypeId"
							label="faculty-request-faculty-role"
							class="form-control js-basic-single">
							<aui:option value="">
								<liferay-ui:message key="common-select" />
							</aui:option>
							<c:forEach items="${facultyTypeList}" var="facultyType">
								<option value="${facultyType.facultyTypeId}"
								 ${facultyType.facultyTypeId eq facultyRequestDetails.facultyRoleId ? 'selected' : ''}>
									<c:choose>
										<c:when
											test="<%=FacultyMembershipConstants.ARABIC_LANGUAGE_CODE
											.equalsIgnoreCase(themeDisplay.getLanguageId())%>">
										${facultyType.nameAr}
									</c:when>
										<c:otherwise>
										${facultyType.nameEn}
									</c:otherwise>
									</c:choose>
								</option>
							</c:forEach>
							<aui:validator name="required"
								errorMessage="The faculty role is required." />
						</aui:select>
					</div>
				</div>
				<div class="col-lg-6 col-md-6">
					<div class="form-group">
						<div class="custom-file faculty-request-file">
							<aui:input type="file" class="custom-file-input"
								label="faculty-request-covering-letter" id="coveringLetter"
								name="coveringLetter" onChange="fileSize(this)">
								<aui:validator name="required"
									errorMessage="The covering letter is required." />
								<aui:validator name="acceptFiles"
									errorMessage="Please enter a file with a valid extension (pdf,docx,doc).">'pdf,docx,doc'</aui:validator>
								<aui:validator name="custom"
									errorMessage="File size should not be more than 2Mb">
									function(){
										if(!uploadSize){
											return true;
										}
									}
								</aui:validator>
							</aui:input>

							<label class="custom-file-label"
								for="<portlet:namespace/>coveringLetter">${facultyRequestDetails.coveringLetterFileName}</label>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12">
					<div class="form-group">
						<aui:input type="textarea" name="comments" id="comments"
							label="comments" value="${lastestComment}">
							<aui:validator name="maxLength">1000</aui:validator>
						</aui:input>
					</div>
				</div>
			</div>
			<div class="bottom-backbtn-wrap">
				<c:choose>
					<c:when test="${not empty workflowTaskDetail.actionList }">
						<button class="btn omsb-bc-red-button" type="submit"
							title="Resend Request" id="submitBtn"
							onClick="saveAndSubmit(`${workflowTaskDetail.taskId }`,
												`${workflowTaskDetail.firstTransitionName}`,
												`${workflowTaskDetail.workflowInstanceId }`,
												`${facultyRequestDetails.coveringLetterFileName}`); 
												">
							<liferay-ui:message key="faculty-request-save-and-approve-request" />
						</button>
					</c:when>
					<c:otherwise>
						<button class="btn omsb-bc-red-button" type="submit"
							title="Resend Request" id="submitBtn">
							<liferay-ui:message key="faculty-request-save" />
						</button>

					</c:otherwise>

				</c:choose>
				<a class="btn omsb-btn btn-back" href="${facultyRequestsURL}"><liferay-ui:message
						key="back" /></a>
			</div>
		</aui:form>
	</div>
</div>


<script>
	var uploadSize = true;
	function fileSize(fileInput) {
		console.log(fileInput);
		const maxSize = 2 * 1024 * 1024; // 2MB in bytes
		const file = fileInput.files[0];
		const size = file.size;
		if (size > maxSize) {
			uploadSize = true;
		} else {
			uploadSize = false;
		}
	}
	 
	function checkCoveringLExist(){
		console.log('dd');
		if(`${facultyRequestDetails.coveringLetterFileName}` != null){
			console.log('dd');
			$('#<portlet:namespace />coveringLetter').removeClass("has-error");	
		}
	}

	function saveAndSubmit(workflowTaskId, transitionName, workflowInstanceId, coverLetterName) {
		let details = "{workflowInstanceId:" + workflowInstanceId
				+ ", workflowTaskId:" + workflowTaskId + ",transitionName:"
				+ transitionName + "}";
		$("#<portlet:namespace />workflowTaskDetails").val(details);
		return true;
	}
</script>