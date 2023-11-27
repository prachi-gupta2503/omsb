<%@ include file="init.jsp"%>

<div class="tab-pane fade show active" id="pills-all"
	aria-labelledby="pills-all-tab">
	<div class="omsb-list-view table-responsive">
		<table id="allProceduresTable" class="display omsb-datatables">
			<caption></caption>
			<thead>
				<tr>
					<th class="no-sort">
						<div class="custom-control custom-checkbox">
							<input type="checkbox"
								class="custom-control-input custom-checkbox" id="checkAll"
								name="checkAll"> <label class="custom-control-label"
								for="checkAll"></label>
						</div>
					</th>
					<th><liferay-ui:message key="procedure-name" /></th>
					<th><liferay-ui:message key="procedure-group-name" /></th>
					<th><liferay-ui:message key="program-name" /></th>
					<th><liferay-ui:message key="cpt-code" /></th>
					<th><liferay-ui:message key="trainee-name" /></th>
					<th><liferay-ui:message key="patient-id" /></th>
					<th><liferay-ui:message key="training-site" /></th>
					<th><liferay-ui:message key="role" /></th>
					<th><liferay-ui:message key="procedure-status" /></th>
					<th><liferay-ui:message key="procedure-date" /></th>
					<th><liferay-ui:message key="action" /></th>
				</tr>
			</thead>
			<tbody id="allProcedureBody">
				<c:set var="isUnconfirmStatusPresent" value="${false}" />
				<c:forEach items="${traineeLoggedProcedureDetailsDTOs}"
					var="traineeLoggedProcedureDetails">
					<liferay-portlet:renderURL var="viewProcedure">
						<liferay-portlet:param name="mvcRenderCommandName"
							value="<%=OmsbViewProceduresSupervisorWebPortletKeys.VIEW_PROCEDURE_DETAIL%>" />
						<liferay-portlet:param name="traineeLoggedProcedureDetailsId"
							value="${traineeLoggedProcedureDetails.traineeLoggedProcedureDetailsId}" />
					</liferay-portlet:renderURL>
					<tr>
						<td class="text-center"><c:if
								test="${traineeLoggedProcedureDetails.procedureStatus == 'UNCONFIRMED'}">
								<c:set var="isUnconfirmStatusPresent" value="${true}" />
								<div class="custom-control custom-checkbox">
									<input type="checkbox"
										class="custom-control-input custom-checkbox"
										id="${traineeLoggedProcedureDetails.traineeLoggedProcedureDetailsId}"
										name="procedureCheckbox"> <label
										class="custom-control-label"
										for="${traineeLoggedProcedureDetails.traineeLoggedProcedureDetailsId}"></label>
								</div>
							</c:if></td>
						<%
							TraineeLoggedProcedureDetailsDTO traineeLoggedProcedureDetails = (TraineeLoggedProcedureDetailsDTO) pageContext
										.getAttribute("traineeLoggedProcedureDetails");
								String traineeName = StringPool.BLANK;
								User traineeUser = UserLocalServiceUtil.fetchUser(traineeLoggedProcedureDetails.getTraineeId());
								if (Validator.isNotNull(traineeUser)) {
									traineeName = traineeUser.getFullName();
								}
						%>
						<td><a href="${viewProcedure}" class="clickable clickable_underline">${traineeLoggedProcedureDetails.procedureName}</a></td>
						<td>${traineeLoggedProcedureDetails.procedureGroupName}</td>
						<td>${traineeLoggedProcedureDetails.programName}</td>
						<td>${traineeLoggedProcedureDetails.cptCode}</td>
						<td><%=traineeName%></td>
						<td>${traineeLoggedProcedureDetails.patientId}</td>
						<td>${traineeLoggedProcedureDetails.trainingSiteName}</td>
						<td>${traineeLoggedProcedureDetails.roleTypeName}</td>
						<c:choose>
							<c:when
								test="${traineeLoggedProcedureDetails.procedureStatus == 'PASS'}">
								<td><span class="omsb-pass-bg">${traineeLoggedProcedureDetails.procedureStatus}</span></td>
							</c:when>
							<c:when
								test="${traineeLoggedProcedureDetails.procedureStatus == 'REFUSE'}">
								<td><span class="omsb-refuse-bg">${traineeLoggedProcedureDetails.procedureStatus}</span></td>

							</c:when>
							<c:when
								test="${traineeLoggedProcedureDetails.procedureStatus == 'NOT PASS'}">
								<td><span class="omsb-notpass-bg">${traineeLoggedProcedureDetails.procedureStatus}</span></td>
							</c:when>
							<c:otherwise>
								<td><span class="omsb-uncofirm-bg">${traineeLoggedProcedureDetails.procedureStatus}</span></td>
							</c:otherwise>
						</c:choose>

						<td><fmt:formatDate
								pattern="<%= OmsbViewProceduresSupervisorWebPortletKeys.STORE_DATE_FORMAT %>"
								value="${traineeLoggedProcedureDetails.procedurePerformedDate}" /></td>
						<td class="text-center" style="width: 100px">
							<div class="dropdown ">
								<button class="btn fa fa-ellipsis-v dropdown-toggle"
									type="button" data-toggle="dropdown" aria-expanded="false">
									<i class=""></i>
								</button>
								<ul class="dropdown-menu">
									<li><a href="${viewProcedure}" class="dropdown-item">
											<img
											src="${themeDisplay.getPathThemeImages()}/svg/fi-rr-eye.svg"
											alt="view"> <liferay-ui:message key="view" />
									</a></li>
									<c:if test="${traineeLoggedProcedureDetails.procedureStatus == 'UNCONFIRMED'}">
										<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, PASS_LOG_PROCEDURE)}">
											<li><a href="javascript:void(0)"
												class="dropdown-item openPassModel"
												id="${traineeLoggedProcedureDetails.traineeLoggedProcedureDetailsId}"
												data-id="${traineeLoggedProcedureDetails.traineeLoggedProcedureDetailsId}"
												data-target="#passModalCenter" data-toggle="modal"> <img
													src="${themeDisplay.getPathThemeImages()}/svg/completed.svg"
													alt="pass"> <liferay-ui:message key="pass" />
											</a></li>
										</c:if>
										<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, NOT_PASS_LOG_PROCEDURE)}">
											<li><a href="javascript:void(0)"
												class="dropdown-item openNotPassModel"
												id="${traineeLoggedProcedureDetails.traineeLoggedProcedureDetailsId}"
												data-id="${traineeLoggedProcedureDetails.traineeLoggedProcedureDetailsId}"
												data-target="#notPassModalCenter" data-toggle="modal"> <img
													src="${themeDisplay.getPathThemeImages()}/svg/fi-rr-edit.svg"
													alt="not pass"> <liferay-ui:message key="not-pass" />
											</a></li>
										</c:if>
										<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, REFUSE_LOG_PROCEDURE)}">
											<li><a href="javascript:void(0)"
												class="dropdown-item openRefuseModel"
												id="${traineeLoggedProcedureDetails.traineeLoggedProcedureDetailsId}"
												data-id="${traineeLoggedProcedureDetails.traineeLoggedProcedureDetailsId}"
												data-target="#refuseModalCenter" data-toggle="modal"> <img
													src="${themeDisplay.getPathThemeImages()}/svg/fi-rr-delete.svg"
													alt="refuse"> <liferay-ui:message key="refuse" />
											</a></li>
										</c:if>
									</c:if>
								</ul>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="omsb-card bottom-backbtn-wrap">
		<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, PASS_LOG_PROCEDURE)}">
			<a class="btn omsb-bc-red-button" href="#" id="passAll"
				data-target="#passModalCenter" data-toggle="modal"><liferay-ui:message
					key="pass-all-selected" /></a>
		</c:if>
		<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, NOT_PASS_LOG_PROCEDURE)}">
			<a class="btn omsb-bc-red-button" href="#" id="notPassAll"
				data-target="#notPassModalCenter" data-toggle="modal"><liferay-ui:message
					key="not-pass-all-selected" /></a>
		</c:if>
		<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, REFUSE_LOG_PROCEDURE)}">
			<a class="btn omsb-bc-red-button"
				href="#" id="refuseAll" data-target="#refuseModalCenter"
				data-toggle="modal"><liferay-ui:message key="refuse-all-selected" /></a>
		</c:if>
	</div>
</div>

<script>
$(document).ready(function(){
	checkBox();
	$('#allProceduresTable').DataTable({
	    "sDom": 'Rfrtlip',
		"order": [],
	    "columnDefs": [ {
	      "targets"  : 'no-sort',
	      "orderable": false,
	    }],
	    dom: 'Bfrtip',
	    buttons: [
    		{
              extend: 'colvis',
              text: '<liferay-ui:message key="column-visibility" />',
              columns: ":not(':first, :last')"
            },
    	    {
    	        extend: 'collection',
    	        text: '<liferay-ui:message key="export-as" />',
    	        buttons: [
    	            {
    	                extend: 'csv',
    	                exportOptions: {
    	                    columns: ":visible:not(':first, :last')"
    	                }
    	            },
    	            {
    	                extend: 'pdf',
    	                exportOptions: {
    	                    columns: ":visible:not(':first, :last')"
    	                }
    	            },
    	            {
    	                extend: 'excel',
    	                exportOptions: {
    	                    columns: ":visible:not(':first, :last')"
    	                }
    	            },
    	            {
    	                extend: 'print',
    	                exportOptions: {
    	                    columns: ":visible:not(':first, :last')"
    	                }
    	            }
    	        ]
    	    }
    	]
	});
	$(".modal-backdrop").remove();
	 $('#checkAll').click(function() {
	    var checked = $(this).prop('checked');
	    $('#allProcedureBody input:checkbox[name=procedureCheckbox]').prop('checked', checked);
	  });
	 
		if(${showModal})
		{
			$('#omsb-notification-sidebar').addClass('open')
		}
});

$(document).on("click","#sidebar-close-btn",function(){
	$('#omsb-notification-sidebar').removeClass('open')
}) 

$(document).on("click",".openPassModel", function(){
	$('#<portlet:namespace/>traineeLoggedProcedureDetailsIdsForPass').val(''+($(this).data('id')));
	$('#<portlet:namespace/>tab').val('');
});

$(document).on("click",".openNotPassModel", function(){
	$('#<portlet:namespace/>traineeLoggedProcedureDetailsIdsForNotPass').val(''+($(this).data('id')));
	$('#<portlet:namespace/>tab').val('');
});

$(document).on("click",".openRefuseModel", function(){
	$('#<portlet:namespace/>traineeLoggedProcedureDetailsIdsForRefuse').val(''+($(this).data('id')));
	$('#<portlet:namespace/>tab').val('');
});

$(document).on("click","#passAll", function(){
	var selectedIds=[];
	$("#allProcedureBody input:checkbox[name=procedureCheckbox]:checked").each(function(){
	    var $this = $(this);
	    if($this.is(":checked")){
	    	selectedIds.push($this.attr("id"));
	    }
	});
	$('#<portlet:namespace/>traineeLoggedProcedureDetailsIdsForPass').val(''+(selectedIds.join(",")));
	$('#<portlet:namespace/>tab').val('');
});

$(document).on("click","#notPassAll", function(){
	var selectedIds=[];
	$("#allProcedureBody input:checkbox[name=procedureCheckbox]:checked").each(function(){
	    var $this = $(this);
	    if($this.is(":checked")){
	    	selectedIds.push($this.attr("id"));
	    }
	});
	$('#<portlet:namespace/>traineeLoggedProcedureDetailsIdsForNotPass').val(''+(selectedIds.join(",")));
	$('#<portlet:namespace/>tab').val('');
});

$(document).on("click","#refuseAll", function(){
	var selectedIds=[];
	$("#allProcedureBody input:checkbox[name=procedureCheckbox]:checked").each(function(){
	    var $this = $(this);
	    if($this.is(":checked")){
	    	selectedIds.push($this.attr("id"));
	    }
	});
	$('#<portlet:namespace/>traineeLoggedProcedureDetailsIdsForRefuse').val(''+(selectedIds.join(",")));
	$('#<portlet:namespace/>tab').val('');
});

function clearCommentboxe(commentboxId) {
    $(commentboxId).val("");
}

function checkBox(){
	 var checkVal = ${isUnconfirmStatusPresent};
	 if (checkVal == false){
		 $("#checkAll").attr("disabled", true);
	 }
	 else{
		 $("#checkAll").attr("disabled", false);
	 }
}

</script>
