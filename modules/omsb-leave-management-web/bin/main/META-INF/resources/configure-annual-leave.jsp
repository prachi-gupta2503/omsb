<%@ include file="init.jsp" %>


<portlet:renderURL var="viewLeaveManagementTabURL">
    <portlet:param name="jspPage" value="<%= OmsbLeaveManagementWebConstants.LEAVE_MANAGEMENT_TAB %>"/>
    <portlet:param name="isAnnualLeaveTab" value="true"/>
</portlet:renderURL>

<portlet:renderURL var="viewAnnualLeaveRuleRenderCommand">
	<portlet:param name="mvcRenderCommandName"
		value="<%=OmsbLeaveManagementWebConstants.ANNUAL_LEAVE_ADD_EDIT_VIEW_PAGE%>" />
</portlet:renderURL>

<portlet:resourceURL id="<%=OmsbLeaveManagementWebConstants.ADD_NEW_ANNUAL_LEAVE_RULE_FOR_PROGRAM %>" var="addNewAnnualLeaveRuleForProgram" />

<portlet:resourceURL id="<%=OmsbLeaveManagementWebConstants.EDIT_MAX_TRAINEE_TO_ANNUAL_LEAVE_RULE %>" var="editMaxTraineeToAnnualLeaveRule" />

<portlet:resourceURL id="<%=OmsbLeaveManagementWebConstants.UPDATE_LEAVE_RULE %>" var="updateLeaveAnnualRule" />

<portlet:resourceURL id="<%=OmsbLeaveManagementWebConstants.POPULATE_BLOCKS_DD %>" var="populateBlocksDropDown" />

<portlet:actionURL name="<%= OmsbLeaveManagementWebConstants.ADD_NEW_ANNUAL_LEAVE_RULE_FOR_PROGRAM %>" var="addEditLeaveTypeActionCommand" ></portlet:actionURL>

<% boolean isFromEditTab = ParamUtil.getBoolean(request, "isEditConfigureAnnualLeaveRule");%>


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

<div class="omsb-card">
	<div class="omsb-page-top-info">
		<div class="pagetitle"><liferay-ui:message key="configure-annual-leave-rules" /></div>
	</div>
	<aui:form name="configureAnnualLeaveRule" method="POST" action="${addEditLeaveTypeActionCommand}" >
		<div class="row">
			
			<div class="col-lg-4 col-md-12">
				<div class="form-group">
					
					<aui:select cssClass="custom-select form-control js-basic-single" label="program" id="programList" name="program" disabled="${isFromEdit}">
		               	<c:if test="${!isFromEdit}">
		               		<aui:option value="" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="select-program" /></aui:option>
		               	</c:if>
		               	
		                <c:forEach items="${programMasterList}" var="programMaster">
							<aui:option value="${programMaster.getProgramMasterId()}">
								${programMaster.getProgramName(themeDisplay.getLocale())}
							</aui:option>									
						</c:forEach>
						<aui:validator name="required" />
					</aui:select>
				</div>
			</div>
			<div class="col-lg-4 col-md-12">
				<div class="form-group">
					<c:choose>
					  <c:when test="${isFromEdit}">
					  	
					    <aui:input name="lastDateOfSubmission" id="lastDateOfSubmission" value="${sdf.format(lastDateForSubmission)}" label="last-date-of-submitting-leaves" required="true" type="text" cssClass="form-control datePicker" />
					  </c:when>
					  <c:otherwise>
					    <aui:input name="lastDateOfSubmission" id="lastDateOfSubmission" placeholder="select-last-date-of-leave-submission" label="last-date-of-submitting-leaves" required="true" type="text" cssClass="form-control datePicker" />
					  </c:otherwise>
					</c:choose>
				</div>
			</div>
			<div class="col-lg-4 col-md-12">
				<div class="form-group">
					<aui:select cssClass="custom-select form-control" disabled="${isFromEdit}" label="available-at" id="availableAt" name="availableAt">
						<c:choose>
						  <c:when test="${isFromEdit}">
							<aui:option value="${availableAt}">${availableAt}</aui:option>
						  </c:when>
						  <c:otherwise>
						 	<aui:option value="" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="select-available-at" /></aui:option>
						  	<aui:option value="Block">Block</aui:option>
							<aui:option value="Block-Week">Block-Week</aui:option>
						  </c:otherwise>
						</c:choose>
						<aui:validator name="required" />
					</aui:select>
				</div>
			</div>
		</div>
    
	    <div class="bottom-backbtn-wrap mb-4">
			  	<aui:button cssClass="btn omsb-bc-red-button" name="updateRule" onClick="updateAnnualLeaveRule()" id="updateRule" value="update-rule"></aui:button>
			  	<aui:button cssClass="btn omsb-bc-red-button" name="addRule" id="addRule"  value="add-rule" onClick="addEditAnnualLeaveRuleForNewProgram()"></aui:button>
			<aui:input name="leaveAnnualRuleId" id="leaveAnnualRuleId" label="" value="${leaveAnnualRuleId}" type="hidden" cssClass="form-control" />
			
			<a class="btn omsb-btn btn-back" href="${viewLeaveManagementTabURL}"><i class="fi fi-sr-arrow-left"></i><liferay-ui:message key="back" /></a>
		</div>
	

	<!-- Add Rule UI -->
	
	<div class="add-rule" id="add-rule-screen">
		<h4 class="omsb-card-title pb-3"> <liferay-ui:message key="configure-max-no-of-trainee" /> </h4>
		<div class="row" class="add-rule" >
			<div class="col-lg-4 col-md-12">
				<div class="form-group">
					<c:choose>
			  			<c:when test="${isFromEdit}">
			  				<aui:select cssClass="custom-select form-control" label="training-level" id="trainingLevel" name="trainingLevel">
								<aui:option value="" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="select-trainee-level" /></aui:option>
								<c:forEach items="${traineeLevelList}" var="traineeLevel">
									<aui:option value="${traineeLevel.getTraineeLevelMasterId()}">
										${traineeLevel.getTraineeLevelName(themeDisplay.getLocale()) }
									</aui:option>
								</c:forEach>
								<aui:validator name="required"></aui:validator>
							</aui:select>
			  			</c:when>
			  			<c:otherwise>
			  				<aui:select cssClass="custom-select form-control " onChange="populateBlocks()" label="training-level" id="trainingLevel" name="trainingLevel">
								<aui:option value="" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="select-trainee-level" /></aui:option>
								
								<aui:validator name="required"></aui:validator>
							</aui:select>
			  			</c:otherwise>
					</c:choose>
				</div>
			</div>
			<div class="col-lg-4 col-md-12">
				<div class="form-group">
					<aui:select cssClass="custom-select form-control js-basic-single" label="Blocks" id="blocks" name="blocks">
						<aui:option value="" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="select-block" /></aui:option>
						
						<aui:validator name="required"></aui:validator>
					</aui:select>
				</div>
			</div>
			<div class="col-lg-4 col-md-12">
				<div class="form-group">
					<aui:input name="maxNoOfTraineeApplyLeave" placeholder="enter-no-of-trainee" id="maxNoOfTraineeApplyLeave" min="0" label="max-no-of-trainee-apply-annual-leave" required="true" type="number" cssClass="form-control" >
						<aui:validator name="min" >0</aui:validator>
					</aui:input>
				</div>
			</div>
		</div>
		
	    <div class="bottom-backbtn-wrap mb-4">
			<aui:button cssClass="btn omsb-bc-red-button" id="addMaxTraineeBtn" name="submit" type="submit" value="add"></aui:button>
			
			<aui:input name="leaveAnnualMaxTraineeId" id="leaveAnnualMaxTraineeId" label="" type="hidden" cssClass="form-control" />
			
			<aui:button cssClass="btn omsb-bc-red-button" id="updateMaxTraineeBtn" value="update" onClick="updateMaxTraineeToAnnualLeaveRule()"></aui:button>
			<aui:button cssClass="btn omsb-bc-red-button" id="discardBtn" value="discard"></aui:button>
			
			<a class="btn omsb-btn btn-back" href="${viewLeaveManagementTabURL}"><i class="fi fi-sr-arrow-left"></i><liferay-ui:message key="back" /></a>
		
		</div>

	</div>
	<!-- Add Rule UI -->
	</aui:form>
	<hr/>
	
	<!-- View Counfigured Rules Table -->
	<div class="view-rules-grid" id="annualLeaveRulesGrid">
		<div class="omsb-list-view table-responsive">
			<table class="display omsb-datatables" id="configureAnnualLeaveRulesDatatables" >
				<caption></caption>
				<thead>
					<tr>
						<th><liferay-ui:message key="trainee-level" /></th>
						<th><liferay-ui:message key="available-at" /></th>
						<th><liferay-ui:message key="max-no-of-trainees-allowed" /></th>
						<th><liferay-ui:message key="actions" /></th>
					</tr>
				</thead>
				<tbody >
					
					<c:if test="${isFromEdit}">
						<c:forEach items="${leaveAnnualMaxTraineeList}" var="leaveAnnaulMaxTrainee">
							<tr>
								<td>${leaveAnnaulMaxTrainee.getTrainingLevel(themeDisplay.getLocale())}</td>
								<c:choose>
								  <c:when test="${leaveAnnaulMaxTrainee.getWeek() != 0}">
									<td>Block ${leaveAnnaulMaxTrainee.getBlock()} Week ${leaveAnnaulMaxTrainee.getWeek()}</td>
								  </c:when>
								  <c:otherwise>
								  	<td>Block ${leaveAnnaulMaxTrainee.getBlock()}</td>
								  </c:otherwise>
								</c:choose>
								<td>${leaveAnnaulMaxTrainee.getMaxTraineeApplyLeave()}</td>
								<td>
									<div class="dropdown">
										<button class="btn fa fa-ellipsis-v dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false"></button>
										<ul class="dropdown-menu">
											<li>
												<aui:a href="#" onClick="populateDropdownsForEdit(`${leaveAnnaulMaxTrainee.getTrainingLevel(themeDisplay.getLocale())}`,${leaveAnnaulMaxTrainee.getBlock()},${leaveAnnaulMaxTrainee.getWeek()},${leaveAnnaulMaxTrainee.getMaxTraineeApplyLeave()},${leaveAnnaulMaxTrainee.getLeaveAnnualMaxTraineeId()})" class="dropdown-item"><i class="fa fa-check-square"></i> Edit</aui:a>
											</li>
											<li>
												<portlet:actionURL name="<%= OmsbLeaveManagementWebConstants.DELETE_MAX_TRAINEE_TO_ANNUAL_LEAVE_RULE %>" var="deleteMaxTraineeToAnnualLeaveRule" >
													<portlet:param name="leaveAnnualMaxTraineeId" value="${leaveAnnaulMaxTrainee.getLeaveAnnualMaxTraineeId()}"/>
												</portlet:actionURL>
												<aui:a href="${deleteMaxTraineeToAnnualLeaveRule}" class="dropdown-item"><i class="fa fa-trash-o"></i> Delete</aui:a>
											</li>
										</ul>
									</div>
								</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
	
	</div>
	<!-- View Counfigured Rules Table -->
	
</div>


<script>

$(document).ready(function(){
	
	$(".js-basic-single").select2();
	
	$('#<portlet:namespace/>lastDateOfSubmission').datepicker({
		startDate: new Date(),
		format: 'dd-mm-yyyy',
		todayHighlight: true,
		orientation: "bottom left"
	});
	
	$('#<portlet:namespace/>updateMaxTraineeBtn').css("display","none");
	$('#<portlet:namespace/>updateRule').css("display","none");
	
	var isFromEditTab = '<%= isFromEditTab %>';
	if(isFromEditTab == 'true'){
		$(".add-rule").css("display","block");
		$(".view-rules-grid").css("display","block");
		$('#<portlet:namespace/>updateRule').css("display","block");
		$('#<portlet:namespace/>addRule').css("display","none");
	}
	else{
		$(".add-rule").css("display","none");
		$(".view-rules-grid").css("display","none");
	}
	
	$('#<portlet:namespace/>discardBtn').click(function(){
		location.reload();
	})
	
	$('#configureAnnualLeaveRulesDatatables').DataTable({
		"lengthChange": false,
		dom: 'Bfrtip',
		buttons: [
            {
              extend: 'colvis',
              text: '<liferay-ui:message key="column-visibility" />',
              columns: ":not(':last')"
            },
            {
                extend: 'collection',
                text: '<liferay-ui:message key="export-as" />',
                buttons: [
                    {
                        extend: 'csv',
                        exportOptions: {
                            columns: ':visible',
                            columns: ":not(':last')"
                        }
                    },
                    {
                        extend: 'pdf',
                        exportOptions: {
                            columns: ':visible',
                            columns: ":not(':last')"
                        }
                    },
                    {
                        extend: 'excel',
                        exportOptions: {
                            columns: ':visible',
                            columns: ":not(':last')"
                        }
                    },
                    {
                        extend: 'print',
                        exportOptions: {
                            columns: ':visible',
                            columns: ":not(':last')"
                        }
                    }
                ]
            }
        ]
	});
	$('#add-rule-screen').focus();
	
 	$(document).on('change','#<portlet:namespace/>trainingLevel',function(){
    	populateBlocks();
	});
});

function populateBlocks(){
	
	console.log("Populate Blocks method callled....");
	var selectedTrainingLevelId = $('#<portlet:namespace/>trainingLevel').val();
	$.ajax({
		url: '<%=populateBlocksDropDown %>',
		type: 'POST',
		data:
			{
				<portlet:namespace/>programId: $('#<portlet:namespace/>programList').val(),
				<portlet:namespace/>traineeLevelId : selectedTrainingLevelId,
				<portlet:namespace/>availableAt: $('#<portlet:namespace/>availableAt').val(),
				
			},
		success: function(data)
		{
			$('#<portlet:namespace/>blocks').empty();
			let jsonData = JSON.parse(data);
			if(jsonData.length!=0){
				for(var i = 0; i < jsonData.length ; i++){
					$('#<portlet:namespace/>blocks').append('<option value="' + jsonData[i].blockName + '">' + jsonData[i].blockName + '</option>');
					console.log("BlockName ::::", jsonData[i].blockName);
				}
			}
		}
	});
}

function updateMaxTraineeToAnnualLeaveRule(){
	var maxTraineeToApply = $('#<portlet:namespace/>maxNoOfTraineeApplyLeave').val();
	if(maxTraineeToApply != ''){
		$.ajax({
			url: '<%=editMaxTraineeToAnnualLeaveRule%>',
			type: 'POST',
			data:
				{
					<portlet:namespace/>leaveAnnualMaxTraineeId: $('#<portlet:namespace/>leaveAnnualMaxTraineeId').val(),
					<portlet:namespace/>maxNoOfTraineeApplyLeave : $('#<portlet:namespace/>maxNoOfTraineeApplyLeave').val()
				},
			success: function(data)
			{
				location.reload();
			}
		});
	}
}

function populateDropdownsForEdit(trainingLevel,block,week,maxNoOfTraineeApplyLeave,leaveAnnualMaxTraineeId){
	
	var blockWeek = "";
	if(week!=0){
		blockWeek = blockWeek.concat("block-",block," week-",week);
	}
	else{
		blockWeek = blockWeek.concat("block-",block);
	}
	$('#<portlet:namespace/>blocks').empty();
	$('#<portlet:namespace/>blocks').append('<option value="' + blockWeek +'">' + blockWeek +'</option>')
	$('#<portlet:namespace/>blocks').val(blockWeek);
	$('#<portlet:namespace/>blocks').prop("disabled", true);
	
	var x = "#<portlet:namespace/>trainingLevel option:selected";
	$(String(x)).text(String(trainingLevel));
	$('#<portlet:namespace/>trainingLevel').prop("disabled", true);
	$('#<portlet:namespace/>maxNoOfTraineeApplyLeave').val(maxNoOfTraineeApplyLeave);
	$('#<portlet:namespace/>updateMaxTraineeBtn').css("display","block");
	$('#<portlet:namespace/>addMaxTraineeBtn').css("display","none");
	$('#<portlet:namespace/>leaveAnnualMaxTraineeId').val(leaveAnnualMaxTraineeId);
}

function addEditAnnualLeaveRuleForNewProgram(){
	
	var formValidator = Liferay.Form.get('<portlet:namespace />configureAnnualLeaveRule').formValidator;
	
	formValidator.validateField('<portlet:namespace />program');
	formValidator.validateField('<portlet:namespace />lastDateOfSubmission');
	formValidator.validateField('<portlet:namespace />availableAt');
	
	var lastDateOfSubmission = $('#<portlet:namespace/>lastDateOfSubmission').val();
	var programListVal = $('#<portlet:namespace/>programList').val();
	var availableAtVal = $('#<portlet:namespace/>availableAt').val();
	
	if(lastDateOfSubmission != '' && programListVal != null && availableAtVal != null ){
		$.ajax({
			url: '<%=addNewAnnualLeaveRuleForProgram%>',
			type: 'POST',
			data:
				{
					<portlet:namespace/>programId: $('#<portlet:namespace/>programList').val(),
					<portlet:namespace/>lastDateOfSubmission : $('#<portlet:namespace/>lastDateOfSubmission').val(),
					<portlet:namespace/>availableAt : $('#<portlet:namespace/>availableAt').val()
				},
			success: function(data)
			{
				let jsonData = JSON.parse(data);
				if(jsonData.length!=0){
					$('#<portlet:namespace/>leaveAnnualRuleId').val(jsonData[0].leaveAnnualRuleId);
					for(var i = 1; i < jsonData.length ; i++){
						$('#<portlet:namespace/>trainingLevel').append('<option value="' + jsonData[i].traineeLevelMasterId + '">' + jsonData[i].traineeLevelName + '</option>');
						console.log("traineeLevelName ::::", jsonData[i].traineeLevelName);
					}
				}
				$('#<portlet:namespace/>programList').prop('disabled', true);
				$('#<portlet:namespace/>availableAt').prop('disabled',true);
				$('#<portlet:namespace/>addRule').css("display","none");
				$('#<portlet:namespace/>updateRule').css("display","block");
				
				$('.add-rule').css("display","block");
				
			}
		});
	}
}



function updateAnnualLeaveRule(){
	var lastDateOfSubmission = $('#<portlet:namespace/>lastDateOfSubmission').val();
	if(lastDateOfSubmission != ''){
		$.ajax({
			url: '<%=updateLeaveAnnualRule%>',
			type: 'POST',
			data:
				{
					<portlet:namespace/>lastDateOfSubmission: $('#<portlet:namespace/>lastDateOfSubmission').val(),
					<portlet:namespace/>leaveAnnualRuleId : $('#<portlet:namespace/>leaveAnnualRuleId').val(),
				},
			success: function(data)
			{
				 $('#<portlet:namespace/>lastDateOfSubmission').val(data);
			}
		});
	}
}


</script>