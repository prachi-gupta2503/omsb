<%@ include file="../../init.jsp"%>

<portlet:resourceURL id="<%=AppealConstants.VIEW_APPEAL_ADMIN_LIST%>" var="searchURL"></portlet:resourceURL>

<div class="container" id="wrapper">
	<div class="omsb-card">
		<div class="omsb-list-filter ">
			<div class="row">
				<div class="col-lg-4 col-md-6">
					<div class="form-group">
						<label><liferay-ui:message key="employer" /></label> <input
							type="text" name='<portlet:namespace/>employer' class="form-control" id="employer"
							placeholder="<liferay-ui:message key="enter-employer-name"/>" >
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="form-group">
						<label><liferay-ui:message key="employee" /></label> <input
							type="text" name='<portlet:namespace/>employee' class="form-control" id="employee"
							placeholder="<liferay-ui:message key="enter-employee-name"/>">
					</div>
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="form-group">
						<aui:select name="level" id="level" label="level">
							<aui:option value=""><liferay-ui:message key="select" /></aui:option>
							<c:forEach var="equivalencyLevelvalues"
								items="${equivalencyLevelList}">
								<aui:option value="${equivalencyLevelvalues.getKey()}">
									<liferay-ui:message
										key="${equivalencyLevelvalues.getName(themeDisplay.getLocale())}" />
								</aui:option>
							</c:forEach>
						</aui:select>
					</div>
				</div>
			</div>
			<div class="filter-button-wrap">
			<button class="btn omsb-bc-red-button" onclick="searchData()"><liferay-ui:message key="search" /></button>
			</div>
		</div>


		<div class="omsb-list-view" id="appeal-data">
			<%@ include file="./admin-list.jsp"%>
				</div>
		</div>
</div>

<style>
tbody .dropdown.show {
        width: 200px !important;
        z-index: 1 !important;
    }	
</style>




<script type="text/javascript">
	$(document).ready(function() {
		console.log('search data starts');
		console.log('search data ends');
		
	});
	
	
	$('.modal-backdrop').removeClass('modal-backdrop'); 
	$(".custom-model").on('click', function(){
		$('#<portlet:namespace/>comments').val('');
		console.log('clicking the model');
		var trName = $(this).attr('data-tr-name');
		var appealId = $(this).attr('data-appeal-id');
		var taskId = $(this).attr('data-task-id');
		var instanceId = $(this).attr('data-instance-id');
		var assigneToMe = $(this).attr('data-assign-to-me');
		$('#<portlet:namespace/>transitionName').val(trName);
		$('#<portlet:namespace/>workflowTaskId').val(taskId);
		$('#<portlet:namespace/>eqAppealId').val(appealId);
		$('#<portlet:namespace/>workflowInstanceId').val(instanceId);
		$('#<portlet:namespace/>assignedToMe').val(assigneToMe);
		console.log('data-tr-name', trName);
		console.log('data-tr-appealId', appealId);
		console.log('data-tr-taskId', taskId);
		console.log('data-tr-instanceId', instanceId);
		console.log('data-tr-assigneToMe', assigneToMe);
		if (trName == 'Decline') {
		    $('.tr-name-btn').html('Reject'); 
		}else{
			$('.tr-name-btn').html(trName);	
		}
				
	})	;	
	
	function validate() {
	    var Appealformvalid = 0;
	    var app_textarea = $('#comments').siblings('.richText-editor').text(); // Use trim() to remove whitespace
	    console.log('app_textarea ' + app_textarea + ' Appealformvalid ' + Appealformvalid);

	    if (app_textarea !== '' && app_textarea !== undefined) {
	        Appealformvalid = 1;
	        $('#comment-error').addClass('d-none');
	        console.log('app_textarea if ' + app_textarea + ' Appealformvalid ' + Appealformvalid);
	    } else {
	        $('#comment-error').removeClass('d-none');
	    }

	    console.log('Appealformvalid ' + Appealformvalid);
	    if (Appealformvalid) {
	    	submitForm(document.<portlet:namespace />edit_eq_appeal_fm);
	    } else {
	        return false;
	    }
	}
	
	
	function searchData(){
	  	var employer = $("#employer").val();
	   	var level = $("#<portlet:namespace />level").val();
	   	var employee = $("#employee").val();
	   console.log("employer  "+employer);
	   console.log("level  "+level);
	   console.log("employee  "+ employee);
		$.ajax({
			url: '<%=searchURL.toString()%>',
				async : false,
				data : {
						<portlet:namespace />employer : employer,
						<portlet:namespace />level : level,
						<portlet:namespace />employee : employee,
						},
					type : 'POST',
					success : function(data) {
						$("#appeal-data").html(data);
						
						$('#admin-list').DataTable({
					    	"bLengthChange": false,
					    	"bFilter": false
					    });
						$('.comments').richText();
						
						$('.modal-backdrop').removeClass('modal-backdrop'); 
						$(".custom-model").on('click', function(){
							$('#<portlet:namespace/>comments').val('');
							console.log('clicking the model');
							var trName = $(this).attr('data-tr-name');
							var appealId = $(this).attr('data-appeal-id');
							var taskId = $(this).attr('data-task-id');
							var instanceId = $(this).attr('data-instance-id');
							var assigneToMe = $(this).attr('data-assign-to-me');
							$('#<portlet:namespace/>transitionName').val(trName);
							$('#<portlet:namespace/>workflowTaskId').val(taskId);
							$('#<portlet:namespace/>eqAppealId').val(appealId);
							$('#<portlet:namespace/>workflowInstanceId').val(instanceId);
							$('#<portlet:namespace/>assignedToMe').val(assigneToMe);
							console.log('data-tr-name', trName);
							console.log('data-tr-appealId', appealId);
							console.log('data-tr-taskId', taskId);
							console.log('data-tr-instanceId', instanceId);
							console.log('data-tr-assigneToMe', assigneToMe);
							
							if (trName == 'Decline') {
							    $('.tr-name-btn').html('Reject'); 
							}else{
								$('.tr-name-btn').html(trName);	
							}		
						})	;	
						
					}
		});
	};
	
	$('.comments').richText();	
	
	$('#admin-list').DataTable({
    	"bLengthChange": false,
    	"bFilter": false,
    	"ordering": false
    });
</script>