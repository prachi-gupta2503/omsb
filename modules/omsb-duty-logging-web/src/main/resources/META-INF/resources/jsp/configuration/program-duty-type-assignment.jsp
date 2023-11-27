<%@page import="gov.omsb.duty.logging.web.constants.MVCCommandNames"%>
<%@ include file="../../init.jsp"%>

<portlet:resourceURL id="<%=MVCCommandNames.ADD_DUTY_TYPES%>"
	var="addDutyTypeURL" />
<portlet:resourceURL id="<%=MVCCommandNames.ADD_DUTY_ASSIGNMENT%>"
	var="addAssignmentURL" />
<portlet:resourceURL
	id="<%=MVCCommandNames.ADD_PROGRAM_DUTY_TYPE_ASSIGNMENT%>"
	var="addProgramDutyAssignment" />
<portlet:resourceURL
	id="<%=MVCCommandNames.ADD_PROGRAM_DUTY_TYPE_ASSIGNMENT%>"
	var="editProgramDutyAssignmentURL" />

<portlet:resourceURL id="<%=MVCCommandNames.GET_MASTER_DATA%>"
	var="getProgramCohortURL">
	<portlet:param name="cmd" value="Cohort" />
</portlet:resourceURL>

<portlet:resourceURL id="<%=MVCCommandNames.GET_MASTER_DATA%>"
	var="getAssignmentURL">
	<portlet:param name="cmd" value="Assignment" />
</portlet:resourceURL>

<portlet:resourceURL id="<%=MVCCommandNames.GET_MASTER_DATA%>"
	var="getDutyTypeURL">
	<portlet:param name="cmd" value="DutyType" />
</portlet:resourceURL>

<div id="wrapper">
	<div class="container">
		<div class="omsb-card">
			<div class="omsb-page-top-info">
				<div class="pagetitle">
					<%-- <liferay-ui:message
						key="duty-logging-configuration-add-program-duty-types-assignments" /> --%>
				</div>
			</div>
			<aui:form action="#" name="programDutyAssignment" method="post">
				<div class="omsb-list-filter pb-2">
					<div class="row">
						<div class="col-lg-6 col-md-6">
							<div class="form-group">
								<aui:select type="text" name="programMasterId"
									id="programMasterId" class="form-control"
									label="duty-logging-configuration-program">
									<aui:option value="">
										<liferay-ui:message key="duty-logging-configuration-select" />
									</aui:option>
									<c:forEach var="programMaster" items="${programMasterList}">
										<aui:option value="${programMaster.id}">${programMaster.name}</aui:option>
									</c:forEach>
									<aui:validator name="required"
										errorMessage="The program is required." />
								</aui:select>
							</div>
						</div>
						<div class="col-lg-6 col-md-6">
							<div class="form-group">
								<aui:select type="text" name="cohortId" id="cohortId"
									class="form-control" label="duty-logging-configuration-cohort">
									<aui:option value="">
										<liferay-ui:message key="duty-logging-configuration-select" />
									</aui:option>
									<aui:validator name="required"
										errorMessage="The cohort is required." />
								</aui:select>
							</div>
						</div>
					</div>
				</div>
				<div class="omsb-list-filter pb-2">
					<div class="row">
						<div class="col-lg-12 col-md-6">
							<div class="form-group">
								<aui:select type="text" name="dutyTypeMasterData"
									id="dutyTypeMasterData" class="form-control"
									label="duty-logging-configuration-dutytype"
									onChange="getAssignmentList()">
									<aui:validator name="required"
										errorMessage="The duty type is required." />
								</aui:select>
							</div>
						</div>
					</div>

					<div class="filter-button-wrap">
						<button class="btn omsb-bc-red-button" data-toggle="modal"
							data-target="#dutytypesadd" type="button">
							<liferay-ui:message key="duty-logging-configuration-add-more" />
						</button>
					</div>
				</div>
				<div class="omsb-list-filter pb-2">
					<div class="row">
						<div class="col-lg-12 col-md-6">
							<div class="form-group">
								<aui:select type="text" name="assignmentId" id="assignmentId"
									value="" class="form-control"
									label="duty-logging-configuration-assignment">
									<aui:option value="">
										<liferay-ui:message key="duty-logging-configuration-select" />
									</aui:option>
									<aui:validator name="required"
										errorMessage="The assignment is required." />
								</aui:select>
							</div>
						</div>
					</div>
					<div class="filter-button-wrap">
						<button class="btn omsb-bc-red-button" data-toggle="modal"
							onclick="dutyTypeIdOnAssignment()" type="button"
							data-target="#assignmentsadd">
							<liferay-ui:message key="duty-logging-configuration-add-more" />
						</button>
					</div>
				</div>
				<div class="omsb-list-filter pb-2">
 				<small id="programDutyAssignmentErrorMsg"  style="display:none; color: #dc3545;">
					<liferay-ui:message key ="duty-logging-configuration-program-assignment-already-exist-error-msg" />
				</small>
				</div>
				<div class="bottom-backbtn-wrap mt-2 mb-4">
					<button class="btn omsb-bc-red-button" type="button"
						title="Announce" onclick="submitProgramDutyAssignment()">
						<liferay-ui:message key="duty-logging-configuration-submit" />
					</button>
					<a class="btn omsb-btn btn-back" href="#"><i
						class="fi fi-sr-arrow-left"></i> <liferay-ui:message
							key="duty-logging-configuration-cancel-button" /></a>
				</div>
			</aui:form>

			<%-- table --%>
			<div class="omsb-list-view table-responsive">
				<table class="display omsb-datatables"
					id="programDutyAssignmentTable">
					<thead>
						<tr>
							<th><liferay-ui:message
									key="duty-logging-configuration-program" /></th>
							<th><liferay-ui:message
									key="duty-logging-configuration-cohort" /></th>
							<th><liferay-ui:message
									key="duty-logging-configuration-duty-type" /></th>
							<th><liferay-ui:message
									key="duty-logging-configuration-assignment" /></th>
							<th><liferay-ui:message
									key="duty-logging-configuration-status" /></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="programDutyAssignment"
							items="${programDutyAssignmentList}">
							<tr>
								<td data-toggle="modal" data-target="#assignmentconfiguration"
									onclick="viewProgramDutyAssignment(`${programDutyAssignment.getJson()}`)">${programDutyAssignment.program}</td>
								<td>${programDutyAssignment.cohort}</td>
								<td>${programDutyAssignment.dutyType}</td>
								<td>${programDutyAssignment.dutyAssignment}</td>
								<td>${programDutyAssignment.status}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<!--// Inner Wrapper Contents -->

<!-- add duty Modal -->
<div class="modal fade omsb-modal" id="dutytypesadd" tabindex="-1"
	role="dialog" aria-labelledby="dutytypesaddTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">
					<liferay-ui:message key="duty-logging-configuration-add-duty-types" />
				</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close" onclick="resetForm('dutyTypesForm')">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<aui:form action="#" name="dutyTypesForm" method="post">
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<aui:input type="text" name="dutyType" id="dutyType" value=""
									class="form-control" oninput="handleInput(this)"
									label="duty-logging-configuration-dutytype">
									<aui:validator name="required"
										errorMessage="The duty type is required." />
								</aui:input>
								<small id="dutyTypeErrorMessage" style="color: #dc3545;"></small>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn omsb-bc-red-button" type="button" title="Add"
						onclick="saveDutyType()">
						<liferay-ui:message key="duty-logging-configuration-add-button" />
					</button>
					<button type="button" class="btn omsb-btn omsb-bg-red-button"
						onclick="resetForm('dutyTypesForm')" data-dismiss="modal">
						<liferay-ui:message key="duty-logging-configuration-cancel-button" />
					</button>
				</div>
			</aui:form>
		</div>
	</div>
</div>

<!-- Add Duty Assignment Modal -->
<div class="modal fade omsb-modal" id="assignmentsadd" tabindex="-1"
	role="dialog" aria-labelledby="assignmentsaddTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">
					<liferay-ui:message key="duty-logging-configuration-add-assignment" />
				</h5>
				<button type="button" class="close" data-dismiss="modal"
					onclick="resetForm('dutyAssignmentForm')" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<aui:form action="#" name="dutyAssignmentForm" method="post">
				<div class="modal-body">
					<div class="row">
						<aui:input cssClass="form-control" type="hidden" name="dutyAssignmentId" id="dutyAssignmentId" value=""/>
						<div class="col-md-12">
							<div class="form-group">
								<aui:select name="dutyTypeId" id="dutyTypeId"
									cssClass="form-control"
									label="duty-logging-configuration-dutytype">
									<aui:option value="">
										<liferay-ui:message key="duty-logging-configuration-select" />
									</aui:option>
									<aui:validator name="required"
										errorMessage="The duty type is required." />
								</aui:select>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<aui:input type="text" name="assignment" id="assignment"
									value="" class="form-control" oninput="handleInput(this)"
									label="duty-logging-configuration-assignment">
									<aui:validator name="required"
										errorMessage="The assignment is required." />
								</aui:input>
							     <small id="dutyAssignmentErrorMsg"  style="display:none; color: #dc3545;">
							        <liferay-ui:message key ="duty-logging-configuration-already-exist-error-msg" />
							     </small>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<aui:input type="color" name="colorCode" id="colorCode" value=""
									class="form-control" label="duty-logging-configuration-color-code">
								<aui:validator name="required"></aui:validator>
						</aui:input>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn omsb-bc-red-button" type="button"
						onclick="saveAssignment()" title="Add">
						<liferay-ui:message key="duty-logging-configuration-add-button" />
					</button>
					<button type="button" class="btn omsb-btn omsb-bg-red-button"
						data-dismiss="modal" onclick="resetForm('dutyAssignmentForm')">
						<liferay-ui:message key="duty-logging-configuration-cancel-button" />
					</button>
				</div>
			</aui:form>
		</div>
	</div>
</div>

<!-- view/edit duty Assigment Modal -->
<div class="modal fade omsb-modal" id="assignmentconfiguration"
	tabindex="-1" role="dialog"
	aria-labelledby="assignmentconfigurationTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">
					<liferay-ui:message
						key="duty-logging-configuration-edit-program-duty-types-assignments" />
				</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close" onclick="resetForm('programDutyAssignmentForm')">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<aui:form action="#" name="programDutyAssignmentForm" method="post">
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<aui:input type="hidden" name="programDutyAssignmentId"
									id="programDutyAssignmentId" class="form-control">
								</aui:input>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<label><liferay-ui:message
										key="duty-logging-configuration-program" /></label> <input
									type="text" name="program" id="program" value=""
									class="form-control" readonly>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<label><liferay-ui:message
										key="duty-logging-configuration-cohort" /></label> <input type="text"
									name="cohort" id="cohort" value="" class="form-control"
									readonly>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<label><liferay-ui:message
										key="duty-logging-configuration-dutytype" /></label> <input
									type="text" name="dutyType" id="dutyType" value=""
									class="form-control" readonly>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<label><liferay-ui:message
										key="duty-logging-configuration-assignment" /></label> <input
									type="text" name="dutyAssignment" id="dutyAssignment" value=""
									class="form-control" readonly>
							</div>
						</div>
						<div class="col-md-12">
							<div class="form-group">
								<aui:select name="status" id="status" class="form-control"
									label="duty-logging-configuration-status">
									<aui:option value="">
										<liferay-ui:message key="duty-logging-configuration-select" />
									</aui:option>
									<aui:option value="Active">
										<liferay-ui:message key="duty-logging-configuration-active" />
									</aui:option>
									<aui:option value="Inactive">
										<liferay-ui:message key="duty-logging-configuration-inactive" />
									</aui:option>
								</aui:select>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn omsb-bc-red-button" type="button"
						onclick="editProgramDutyAssignment()">
						<liferay-ui:message key="duty-logging-configuration-submit" />
					</button>
					<button type="button" class="btn omsb-btn omsb-bg-red-button"
						data-dismiss="modal"
						onclick="resetForm('programDutyAssignmentForm')">
						<liferay-ui:message key="duty-logging-configuration-cancel-button" />
					</button>
				</div>
			</aui:form>
		</div>
	</div>
</div>

<script>
	
	$('document').ready(()=>{
		getDutyTypeList();
		getDataTable();
	});

	/* For add duty Types  */
	function saveDutyType(){
		isDutyTypeExists();
	}
	/* For is duty Types exists */
	function isDutyTypeExists(){
    	var dutyTypeValue = $('#<portlet:namespace/>dutyType').val();
		Liferay.Service(
				'/omsbtms.dutytypes/get-duty-types-by-duty-type',
				{
				    dutyType: dutyTypeValue
				},
				function(obj) {
				    const response = JSON.parse(obj);
				    if(response.status === '409'){
				    	var errorMessage = response.error;
				    	$('#dutyTypeErrorMessage').text(errorMessage);
				    }else if(response.status === '200') {
			        	submitDutyType();
					}
				}
		);
	}
     /* For add duty Types  */
	function submitDutyType(){
        var form= $('#<portlet:namespace/>dutyTypesForm')[0];
		var formdata = new FormData(form);
        var url = '<%=addDutyTypeURL.toString()%>';
        if(validateForm('<portlet:namespace/>dutyTypesForm')){
			$.ajax({
				type : "post",
				url : url,
				data : formdata,
				contentType : false,
				cache : false,
				processData : false,
			}).done(function(response) {
				$("#<portlet:namespace/>dutyTypesForm").trigger("reset");
				$('#dutytypesadd').modal('hide');
				getDutyTypeList();
			}).fail(function(error) {
			})
        }else {
			return false;	
		}	
	}
	
	// for remove errormessage when input change 
	function handleInput(input){
		if(input.value.trim() !== ""){
			console.log(input.value.trim());
			$("#dutyTypeErrorMessage").text("");
			$('#dutyAssignmentErrorMsg').text("");
		}
	}

	/* For reset duty Types  */
	function resetForm(form) {
		$("#<portlet:namespace/>"+form).trigger("reset");
	}
	
	
	/* For add duty Types  */
	function saveAssignment(){
		isAssignmentExists();
	}
	
	/* For is duty Types exists */
	function isAssignmentExists(){
    	var dutyTypeId = $('#<portlet:namespace/>dutyTypeId').val();
    	var assignment = $('#<portlet:namespace/>assignment').val();
    	var dutyAssignmentId = $('#<portlet:namespace/>dutyAssignmentId').val();
		if(dutyAssignmentId.length<=0){
			dutyAssignmentId=0;
		}
    	Liferay.Service(
    			'/omsbtms.dutyassignment/find-by-duty-type-id-and-assignment',
    			{
    			    dutyTypeId: dutyTypeId,
    			    assignment: assignment,
    			    dutyAssignmentId: dutyAssignmentId
    			},
				function(object) {
				    const response = JSON.parse(object);
				    if(response.status === '409'){
				    	 $("#dutyAssignmentErrorMsg").css("display", "block");
				    }else if(response.status === '200') {
				    	addAssignment();
					}
				}
		);
	}
	
	/* For add Assignment  */
	function addAssignment(){
        var form= $('#<portlet:namespace/>dutyAssignmentForm')[0];
		var formdata = new FormData(form);
        var url = '<%=addAssignmentURL.toString()%>';
        if(validateForm('<portlet:namespace/>dutyAssignmentForm')){
			$.ajax({
				type : "post",
				url : url,
				data : formdata,
				contentType : false,
				cache : false,
				processData : false,
			}).done(function(response) {
				$("#<portlet:namespace/>dutyAssignmentForm").trigger("reset");
				$('#assignmentsadd').modal('hide');
				getAssignmentList();
			}).fail(function(error) {
			})
        }else {
			return false;	
		}
	}
	
	/* 	For new mapping */
	function submitProgramDutyAssignment() {
		isProgramDutyAssignmentExists();
		
	}
	function isProgramDutyAssignmentExists(){
		if(validateForm('<portlet:namespace/>programDutyAssignment')){
		let programId =$("#<portlet:namespace/>programMasterId").val();
		let cohortId =$("#<portlet:namespace/>cohortId").val();
		let dutyAssignmentId =$("#<portlet:namespace/>assignmentId").val();
		console.log("programId"+programId + "cohortId" +cohortId + "dutyAssignmentId" +dutyAssignmentId);
		Liferay.Service(
    			'/omsbtms.programdutyassignment/find-program-duty-assignment',
    			{
    				programId: programId,
    				cohortId: cohortId,
    				dutyAssignmentId: dutyAssignmentId
    			},
				function(object) {
    				console.log(object);
				    const response = JSON.parse(object);
				    if(response.status === '409'){
				    	 $("#programDutyAssignmentErrorMsg").css("display", "block");
				    }else if(response.status === '200') {
				    	addProgramDutyAssignment();
					}
				    else{
				    	location.reload(); 
				    	console.log("Update Status While Adding");
				    }
				});
		}else{
			return false;
		}
		
	}
	function addProgramDutyAssignment(){
		var form = $('#<portlet:namespace/>programDutyAssignment')[0];
		var formdata = new FormData(form);
		var url = '<%=addProgramDutyAssignment.toString()%>';
		if(validateForm('<portlet:namespace/>programDutyAssignment')){
			$.ajax({
				type : "post",
				url : url,
				data : formdata,
				contentType : false,
				cache : false,
				processData : false,
			}).done(function(response) {
				$("#<portlet:namespace/>programDutyAssignment").trigger("reset");
				location.reload(); 
			}).fail(function(error) {
			})
		}else {
			return false;	
		}
		
	}
	
	
	function editProgramDutyAssignment(){
		var form = $('#<portlet:namespace/>programDutyAssignmentForm')[0];
		var formdata = new FormData(form);
		var url = '<%=editProgramDutyAssignmentURL.toString()%>';
		$.ajax({
			type : "post",
			url : url,
			data : formdata,
			contentType : false,
			cache : false,
			processData : false,
		}).done(function(response) {
			$("#<portlet:namespace/>programDutyAssignmentForm").trigger("reset");
			$('#assignmentconfiguration').modal('hide');
			location.reload(); 
		}).fail(function(error) {
		})
	}
	/* master data of cohort*/
	$('#<portlet:namespace/>programMasterId').change(function(){
		var programMasterId=$('#<portlet:namespace/>programMasterId').val();
		$("#<portlet:namespace />cohortId").empty();
		var url = '<%=getProgramCohortURL.toString()%>';
		$.ajax({
			type : "GET",
			url : url+"&<portlet:namespace/>programMasterId="+programMasterId,
			contentType: "application/json",
			success: function(cohorts) {
				$("#<portlet:namespace/>cohortId").append(new Option('Select',""));
                $.each(JSON.parse(cohorts), function( index, cohort ){
                	$("#<portlet:namespace/>cohortId").append(new Option(cohort.ayApplicableForm,cohort.progDurationId));
                });
                
            },
            error: function() {}
		});
	});
	
	/* master data of assignment*/
	function getAssignmentList(){
		let dutyTypeId=$('#<portlet:namespace/>dutyTypeMasterData').val();
		$("#<portlet:namespace />assignmentId").empty();
		var url = '<%=getAssignmentURL.toString()%>';
		$.ajax({
			type : "GET",
			url : url+"&<portlet:namespace/>dutyTypeId="+dutyTypeId,
			contentType: "application/json",
			success: function(assignments) {
				$("#<portlet:namespace/>assignmentId").append(new Option('<liferay-ui:message key="duty-logging-configuration-select"/>',""));
                $.each(JSON.parse(assignments), function( index, assignment ){
                	$("#<portlet:namespace/>assignmentId").append(new Option(assignment.assignment,assignment.dutyAssignmentId));
                });
	       },
	       error: function() {}
		});
	};
	
	// For validate form 
	function validateForm(from) {
		var programDutyAssignmentForm = Liferay.Form.get(from);
		if (programDutyAssignmentForm) {
			var validator = programDutyAssignmentForm.formValidator;
			validator.validate();
			var hasErrors = validator.hasErrors();
			if (hasErrors) {
				validator.focusInvalidField();
				return false;
			}
		}
		return true;
	}
	
	/* select duty type id on assignment popup */
	function dutyTypeIdOnAssignment(){
		let dutyTypeValue = $('#<portlet:namespace/>dutyTypeMasterData').val();
		$('#<portlet:namespace/>dutyTypeId option[value="'+dutyTypeValue+'"]').attr("selected", "selected");
	}


	function getDutyTypeList(){
		$("#<portlet:namespace />dutyTypeId").empty();
		$("#<portlet:namespace />dutyTypeMasterData").empty();
		$("#<portlet:namespace />dutyTypeMasterData").append(new Option("Select",""));
		$("#<portlet:namespace />dutyTypeId").append(new Option("Select",""));
		var url = '<%=getDutyTypeURL.toString()%>';
		$.ajax({
			type : "GET",
			url : url,
			contentType: "application/json",
			success: function(dutyTypes) {
                $.each(JSON.parse(dutyTypes), function( index, dutyType ){
                	$("#<portlet:namespace/>dutyTypeMasterData").append(new Option(dutyType.dutyType,dutyType.dutyTypeId));
                	$("#<portlet:namespace/>dutyTypeId").append(new Option(dutyType.dutyType,dutyType.dutyTypeId));
                });
	       },
	       error: function() {}
		});
	}
	
	function getDataTable(){
		// Initialize the DataTable
		let table = $('#programDutyAssignmentTable').DataTable({
				"bLengthChange": false,
			    "bFilter": false,
			    "paging": true,
			    "pageLength": 10
		});
	}
	
	
	function viewProgramDutyAssignment(programDutyAssignment){
		console.log(programDutyAssignment);
		programDutyAssignment = programDutyAssignment.replace(/'/g, '"');
		data = JSON.parse(programDutyAssignment);
		$('#<portlet:namespace/>programDutyAssignmentId').val(data.programDutyAssignmentId);
		$('#program').val(data.program);
		$('#cohort').val(data.cohort);
		$('#dutyType').val(data.dutyType);
		$('#dutyAssignment').val(data.dutyAssignment);
		$('#<portlet:namespace/>status option[value="'+data.status+'"]').attr("selected", "selected");
		
	}
</script>