<%@ include file="../init.jsp"%>
<style>
.ec-request-file .has-error .form-feedback-item {
    position: absolute !important; 
    margin-top: 9% !important;
}
</style>


<portlet:resourceURL id="/get/persons-data"
	var="getPersonsDataResourceURL" />
<portlet:resourceURL id="/get/dependent-data"
	var="getDependentDataResourceURLJEL" />	

<portlet:renderURL  var="backURL" >
	<portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>

<portlet:actionURL var="updateEcMembershipRequestActionURL"  
	name="/update/ec-membership-request" />
	
<div class="omsb-card">
	<div class="omsb-page-top-info mb-4">
		<div class="pagetitle"><liferay-ui:message key="ec-member-request-edit-ec-membership-request" /></div>
	</div>
	<div class="row">
		<div class="col-lg-4 col-md-6 col-sm-12 label-box">
			<label class="label-name"><liferay-ui:message key="ec-member-request-potential-member-name" /></label> <label
				class="label-content">${editData.givenNameAsPassport}</label>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-4 col-md-6 col-sm-12 label-box">
			<label class="label-name"><liferay-ui:message key="ec-member-request-civil-id" /></label> <label
				class="label-content">${editData.civilId}</label>
		</div>
		<div class="col-lg-4 col-md-6 col-sm-12 label-box">
			<label class="label-name"><liferay-ui:message key="ec-member-request-passport-no" /></label> <label
				class="label-content">${editData.passportNumber}</label>
		</div>
		<div class="col-lg-4 col-md-6 col-sm-12 label-box">
			<label class="label-name"><liferay-ui:message key="ec-member-request-dob" /></label> <label
				class="label-content">${editData.dateOfBirth}</label>
		</div>
	</div>

	<aui:form action="${updateEcMembershipRequestActionURL}" method="post" name="addNewEcMemberRequest" 
				id="addNewEcMemberRequest" enctype="multipart/form-data">
		<aui:input type="hidden" name="personId" id="personId" value="${editData.personId}"/>
		<aui:input type="hidden" name="ecMemberRequestId" id="ecMemberRequestId" value="${ecMemberRequestId}"/>
		<aui:input type="hidden" name="workflowTaskDetails" />
		<div class="row mt-4">
			<div class="col-md-6 col-sm-6 col-xs-12">
				<div class="form-group">
					<aui:select name="programName" id="programName" class="form-control" label="ec-member-request-program-name">
						<aui:validator name="required"></aui:validator>
						<option value=""><liferay-ui:message key="ec-member-request-select" /></option>
						<c:forEach items="${programList}" var="program">
							<c:if test="${program.programMasterId == editData.programId}">
								<option value="${program.programMasterId}" selected="selected">${program.programName}</option>
	                        </c:if>
	                        <c:if test="${program.programMasterId != editData.programId}">
	                            <option value="${program.programMasterId}">${program.programName}</option>
	                        </c:if>
						</c:forEach>
					</aui:select>
				</div>
			</div>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<div class="form-group">
					<aui:select name="membershipRole" id="membershipRole" class="form-control" label="ec-member-request-membership-role">
						<aui:validator name="required"></aui:validator>
							<option value=""><liferay-ui:message key="ec-member-request-select" /></option>
							<c:forEach items="${roleList}" var="role">
								<c:if test="${role.roleId == editData.membershipRoleId}">
									<option value="${role.roleId}" selected="selected">${role.name}</option>
		                        </c:if>
		                        <c:if test="${role.roleId != editData.membershipRoleId}">
		                            <option value="${role.roleId}">${role.name}</option>
		                        </c:if>
							</c:forEach>
						</aui:select>
				</div>
			</div>
	
		</div>
	
		<div class="row">
			<div class="col-md-6 col-sm-6 col-xs-12">
				<div class="form-group">
					<div class="custom-file ec-request-file mb-3">
						<aui:input id="coveringLetter" label="ec-member-request-covering-letter" name="coveringLetter" type="file" value="${editData.coveringLetterUrl}">
							<aui:validator name="acceptFiles">'pdf,docx,doc'</aui:validator>
						</aui:input>
						<label class="custom-file-label" for="<portlet:namespace/>coveringLetter">${editData.coveringLetterName}</label>
					</div>
				</div>
			</div>
			<div class="col-md-6 col-sm-6 col-xs-12">
				<div class="form-group">
					<div class="custom-file ec-request-file mb-3">
						<aui:input id="curriculamVitae" label="ec-member-request-curriculam-vitae" name="curriculamVitae" type="file" value="${editData.cvUrl}">
							<aui:validator name="acceptFiles">'pdf,docx,doc'</aui:validator>
						</aui:input>
						<label class="custom-file-label" for="<portlet:namespace/>curriculamVitae">${editData.cvName}</label>
					</div>
				</div>
			</div>
			<div class="col-md-12 col-sm-12 col-xs-12">
					<%-- <label>Comments</label>
					<textarea name="comments" class="form-control" id="comments_item">${editData.comment}</textarea> --%>
					<aui:input name="comments" id="comments" type="textarea" value="${editData.comment}"></aui:input>
			</div>
		</div>
	
		<div class="bottom-backbtn-wrap mt-4">
		<c:choose>
		<c:when test="${not empty workflowTaskDetail.actionList }">
			<button class="btn omsb-bc-red-button" type="submit" title="Resend Request" id="submitBtn"
					onClick="saveAndSubmit(`${workflowTaskDetail.taskId }`,
												`${workflowTaskDetail.firstTransitionName}`,`${workflowTaskDetail.workflowInstanceId }`)">
						<liferay-ui:message key="ec-member-request-resend-request" />
				</button>
		</c:when>
		<c:otherwise>
			<button class="btn omsb-bc-red-button" type="submit" title="Resend Request" id="submitBtn">
					<liferay-ui:message key="ec-member-request-save" />
			</button>
			
		</c:otherwise>
		
		</c:choose>
			<!-- <button class="btn omsb-bc-red-button" type="button"
				title="Create Request">Resend Request</button> -->
			<a class="btn omsb-btn btn-back" href="${backURL}"><i
				class="fi fi-sr-arrow-left"></i><liferay-ui:message key="ec-member-request-cancel" /></a>
		</div>
	</aui:form>
</div>

<script type="text/javascript">
$(document).ready(function () {
 var config = new Object({}),
	namespace = '<portlet:namespace />',
	civilIdJEL = '#' + namespace + 'civilId',
	passportNoJEL = '#' + namespace + 'passportNo',
	dateofbirthJEL = '#' + namespace + 'dateofbirth',
	personIdJEL = '#' + namespace + 'personId',
	personsDatatableJEL = '#personsDatatable',
	searchPersonsBtnJEL = '#' + namespace + 'searchPersonsBtn',
	programNameJEL = '#' + namespace + 'programName',
	trainingSiteJEL = '#' + namespace + 'trainingSite',
	rotationJEL = '#' + namespace + 'rotation',
	membershipRoleJEL = '#' + namespace + 'membershipRole',
	coveringLetterJEL = '#' + namespace + 'coveringLetter',
	curriculamVitaeJEL = '#' + namespace + 'curriculamVitae',
	civilIdPassportErrorJEL = '#' + namespace + 'civilIdPassportError',
	dobErrorJEL = '#' + namespace + 'dobError';
	addNewEcMemberRequestJEL = '#' + namespace + 'addNewEcMemberRequest',
	getPersonsDataResourceURLJEL = '${getPersonsDataResourceURL}',
	submitBtnJEL = '#' + 'submitBtn',
	getDependentDataResourceURLJEL = '${getDependentDataResourceURLJEL}';
	
	config.namespace = namespace;
	config.civilIdJEL = civilIdJEL;
	config.passportNoJEL = passportNoJEL;
	config.dateofbirthJEL = dateofbirthJEL;
	config.personIdJEL = personIdJEL;
	config.personsDatatableJEL = personsDatatableJEL;
	config.searchPersonsBtnJEL = searchPersonsBtnJEL;
	config.programNameJEL = programNameJEL;
	config.trainingSiteJEL = trainingSiteJEL;
	config.rotationJEL = rotationJEL;
	config.membershipRoleJEL = membershipRoleJEL;
	config.coveringLetterJEL = coveringLetterJEL;
	config.curriculamVitaeJEL = curriculamVitaeJEL;
	config.civilIdPassportErrorJEL = civilIdPassportErrorJEL;
	config.dobErrorJEL = dobErrorJEL;
	config.getPersonsDataResourceURLJEL = getPersonsDataResourceURLJEL;
	config.addNewEcMemberRequestJEL = addNewEcMemberRequestJEL;
	config.getDependentDataResourceURLJEL = getDependentDataResourceURLJEL;
	config.submitBtnJEL = submitBtnJEL;
	
	ecmrPortlet.renderECMR(config);

});

function saveAndSubmit(workflowTaskId,transitionName,workflowInstanceId ){
	let details ="{workflowInstanceId:"+workflowInstanceId+", workflowTaskId:"+workflowTaskId+",transitionName:"+transitionName+"}"; 
	$("#<portlet:namespace />workflowTaskDetails").val(details);
	return true;
}
</script>
