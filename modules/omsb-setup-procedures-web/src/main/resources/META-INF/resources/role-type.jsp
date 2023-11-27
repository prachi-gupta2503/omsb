<%@page import="gov.omsb.tms.model.RoleTypeProgDurationRel"%>
<%@ include file="init.jsp"%>

<div class="tab-pane fade show active" id="pills-roletype"
	role="tabpanel" aria-labelledby="pills-roletype-tab">
	<aui:form action="${saveProcedureLoggingParameters}" name="form-role"
		method="post">
		<aui:input type="hidden"
			name="<%=OmsbSetupProceduresWebPortletKeys.MASTER_VALUE%>"
			value="<%=OmsbSetupProceduresWebPortletKeys.ROLE_TYPE_NAME%>" />
		<aui:input type="hidden"
			name="<%=OmsbSetupProceduresWebPortletKeys.IS_CREATE%>"
			value="<%=Boolean.FALSE%>" />
		<div class="row">
			<div class="col-lg-6 col-md-6 col-sm-12">
				<div class="form-group">
					<aui:select cssClass="custom-select form-control js-basic-single"
						label="select-program" id="selectProgramForRole"
						name="selectProgramForRole"
						onChange="getProgramDuration('selectProgramForRole')"
						ignoreRequestValue="true">
						<aui:option selected="true" disabled="true"
							cssClass="placeholder">
							<liferay-ui:message key="please-select-program" />
						</aui:option>
						<c:forEach items="${allProgramList}" var="selectProgramList">
							<aui:option value="${selectProgramList.programMasterId}">${selectProgramList.getProgramName(locale)}</aui:option>
						</c:forEach>
						<aui:validator name="required" />
					</aui:select>
				</div>
			</div>
			<div class="col-lg-6 col-md-6 col-sm-12">
				<div class="form-group">
					<aui:select cssClass="custom-select form-control js-basic-single"
						label="program-cohort" id="programDurationForRole"
						name="programDurationForRole" ignoreRequestValue="true"
						onChange="getRoles()">
						<aui:option selected="true" disabled="true"
							cssClass="placeholder">
							<liferay-ui:message key="please-select-program-duration" />
						</aui:option>
						<aui:validator name="required" />
					</aui:select>
				</div>
			</div>
			<div class="col-lg-12 col-md-12 col-sm-12">
				<div class="d-flex align-items-end">
					<div class="form-group">
						<label><liferay-ui:message key="role-type" />
							<span class="reference-mark text-warning">
								<svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false">
									<use href="<%=themeDisplay.getPathThemeImages()%>/clay/icons.svg#asterisk"></use>
								</svg>
							</span>
						</label> 
						<select
							cssClass="custom-select form-control" id="roleType"
							name="<portlet:namespace/>roleType" multiple="multiple"
							data-live-search="true" onchange="validateRoleType();">
							<option value="0" disabled="true" cssClass="placeholder">
								<liferay-ui:message key="please-select-role-type" />
							</option>
						</select>
					</div>
					<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADD_ROLE_TYPE)}">
						<button class="btn omsb-bc-red-button omsb-add-btn mb-3 ml-3"
							type="button" title="Add" id="addRoleTypeModel"
							data-target="#addRoleTypeMasterModal" data-toggle="modal"
							disabled="disabled"  onclick="resetForm('<portlet:namespace/>master-form-role')">
							<img src="<%=themeDisplay.getPathThemeImages()%>/svg/add.svg"
								alt="<liferay-ui:message key="add-btn" />" />
						</button>
					</c:if>
				</div>

			</div>
		</div>
		<div class="bottom-backbtn-wrap">
			<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADD_ROLE_TYPE)}">
				<button class="btn omsb-bc-red-button" type="submit" onclick='$(".loader-container").addClass("d-flex").removeClass("d-none");' title="Save"
					disabled="true" id="saveRoleTypeBtn">
					<liferay-ui:message key="save" />
				</button>
			</c:if>	
			<button class="btn omsb-bg-red-button" type="button"
				onclick="window.location.reload()" title="Reset">
				<liferay-ui:message key="reset" />
			</button>
		</div>
	</aui:form>
	<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, VIEW_ROLE_TYPE)}">
		<div class="row mt-4">
			<div class="col-md-12">
				<div class="omsb-list-view table-responsive">
					<table id="roleTypeProgRelTable" class="display omsb-datatables">
						<thead>
							<tr>
								<th><liferay-ui:message key="program" /></th>
								<th><liferay-ui:message key="role-type" /></th>
								<th><liferay-ui:message key="created-date" /></th>
								<th><liferay-ui:message key="modified-date" /></th>
								<th><liferay-ui:message key="modified-by" /></th>
								<th><liferay-ui:message key="action" /></th>
							</tr>
						</thead>
						<tbody id="roleTypeBody">
							<c:forEach items="${roleTypeProgDurationRelList}"
								var="roleTypeProgDuration">
								<%
									RoleTypeProgDurationRel roleTypeProgDurationRel = (RoleTypeProgDurationRel) pageContext
												.getAttribute("roleTypeProgDuration");
								%>
								<tr>
									<td>${programNameCohotMapping.get(roleTypeProgDuration.getProgramDurationId())}</td>
									<td>${roleTypeMapping.get(roleTypeProgDuration.getRoleTypeMasterId())}</td>
									<td>${sdf.format(roleTypeProgDuration.getCreateDate())}</td>
									<td>${sdf.format(roleTypeProgDuration.getModifiedDate())}</td>
									<td><%=UserLocalServiceUtil.getUser(roleTypeProgDurationRel.getModifiedBy()).getFullName()%></td>
									<td class="text-center" style="width: 100px">
										<div class="dropdown">
											<button class="btn fa fa-ellipsis-v dropdown-toggle"
												type="button" data-toggle="dropdown" aria-expanded="false">
												<i class=""></i>
											</button>
											<portlet:renderURL var="editRoleTypeProgDuration">
											    <portlet:param name="mvcRenderCommandName" value="/edit-procedure-logging-parameters-form" />
											    <portlet:param name="editProcedureName" value="<%=OmsbSetupProceduresWebPortletKeys.SELECT_PROGRAM_FOR_ROLE%>" />
											    <portlet:param name="procedureTypeProgDurationRelId" value="${roleTypeProgDuration.getRoleTypeProgDurationRelId()}" />
												<portlet:param name="procedureTypeProgDurationRelName" value="${roleTypeMapping.get(roleTypeProgDuration.getRoleTypeMasterId())}" />
											</portlet:renderURL>
											<ul class="dropdown-menu">
												<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, EDIT_ROLE_TYPE)}">
													<li><a href="${editRoleTypeProgDuration}" onClick="$('.loader-container').addClass('d-flex').removeClass('d-none');" class="dropdown-item"><i
															class="fa fa-pencil"></i> <liferay-ui:message key="edit" />
														</a>
													</li>
												</c:if>
												<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, DELETE_ROLE_TYPE)}">
													<li><a href="javascript:void(0)" class="dropdown-item openDeleteModal"  id="${roleTypeProgDuration.getRoleTypeProgDurationRelId()}"  data-parameter="<%=OmsbSetupProceduresWebPortletKeys.ROLE_TYPE_NAME%>"  data-id="${roleTypeProgDuration.getRoleTypeProgDurationRelId()}" data-target="#deleteModal" data-toggle="modal" >
															<i class="fa fa-trash-o"></i> <liferay-ui:message key="delete" />
														</a>
													</li>
												</c:if>
											</ul>
										</div>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</c:if>
</div>

<%@ include file="/add-role-type-modal-popup.jsp"%>

<script>
function validateRoleType() {
	$('#saveRoleTypeBtn').prop('disabled', $("#roleType").val().length > 0 ? false : true);
}

$(document).ready(function(){
	$('#roleTypeProgRelTable').DataTable({
	    "sDom": 'Rfrtlip',
	    "order":[],
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
    	                    columns: ":visible:not(':last')"
    	                }
    	            },
    	            {
    	                extend: 'pdf',
    	                exportOptions: {
    	                    columns: ":visible:not(':last')"
    	                }
    	            },
    	            {
    	                extend: 'excel',
    	                exportOptions: {
    	                    columns: ":visible:not(':last')"
    	                }
    	            },
    	            {
    	                extend: 'print',
    	                exportOptions: {
    	                    columns: ":visible:not(':last')"
    	                }
    	            }
    	        ]
    	    }
    	]
	});
})

$('#roleType').multiselect({
    enableFiltering: true
});

$("#addRoleTypeModel").click(function() {
	 let programDuration = $("#<portlet:namespace/>programDurationForRole").val();
	 $(".modal-body #<portlet:namespace/>programDurationForRole").val(programDuration);
	 
	 const programName =  $("#<portlet:namespace/>selectProgramForRole :selected").text();
	 const programCohort =	$("#<portlet:namespace/>programDurationForRole :selected").text();
	 
	 $("#addRoleTypeMasterModal #progName .label-content").html(programName);
	 $("#addRoleTypeMasterModal #progCohort .label-content").html(programCohort);
	 
});

function getRoles() {
	programDuration = $("#<portlet:namespace/>programDurationForRole").val();	
	$.ajax({
		url: '<%=getRoleTypesURL%>',
		type: 'POST',
		data:
			{
				<portlet:namespace/>programDuration: programDuration
			},
		success: function(data)	
		{
			if(data.success){
				addRoleTypeButtonEnable();

				$("#roleType").empty();
				validateRoleType();				
				let roleTypeDropdownList = data.roleTypeDropdownList;
				for(let i=0; i<roleTypeDropdownList.length; i++) {
					$('#roleType').multiselect('destroy');
					$("#roleType").append("<option value='"+roleTypeDropdownList[i].roleTypeId+"'>" + roleTypeDropdownList[i].roleTypeName + "</option>").multiselect({enableFiltering: true});
				}
				$('#roleTypeProgRelTable').DataTable().destroy();
				$("#roleTypeBody").empty();
	    		let roleTypeTableList = data.roleTypeTableList.roleTypeMapping;
	    		for(let i=0;i<roleTypeTableList.length;i++) {   			
	    			let rowHTML = `<tr>
	    				<td>\${roleTypeTableList[i].programNameCohortMap}</td>
	    				<td>\${roleTypeTableList[i].roleTypeName}</td>
	    				<td>\${roleTypeTableList[i].createdDate}</td>
	    				<td>\${roleTypeTableList[i].modifiedDate}</td>
	    				<td>\${roleTypeTableList[i].modifiedBy}</td>
	    				<td class="text-center" style="width: 100px">
	    					<div class="dropdown">
	    						<button class="btn fa fa-ellipsis-v dropdown-toggle"
	    							type="button" data-toggle="dropdown" aria-expanded="false">
	    							<i class=""></i>
	    						</button>
	    						<ul class="dropdown-menu">
	    							<li><a href="\${roleTypeTableList[i].editURL}" onClick="$('.loader-container').addClass('d-flex').removeClass('d-none');" class="dropdown-item"><i
	    									class="fa fa-pencil"></i> <liferay-ui:message key="edit" />
	    								</a>
	    							</li>
	    							<li><a href="javascript:void(0)" class="dropdown-item openDeleteModal"  id="\${roleTypeTableList[i].roleTypeProgDurationRelId}"  data-parameter="<%=OmsbSetupProceduresWebPortletKeys.ROLE_TYPE_NAME%>"  data-id="\${roleTypeTableList[i].roleTypeProgDurationRelId}" data-target="#deleteModal" data-toggle="modal" >
	    									<i class="fa fa-trash-o"></i> <liferay-ui:message key="delete" />
	    								</a>
	    							</li>
	    						</ul>
	    					</div>
	    				</td>
	    			</tr>`;
	    		 	$("#roleTypeBody").append(rowHTML);	
	    		}
	    		$('#roleTypeProgRelTable').DataTable({
    		 	    "sDom": 'Rfrtlip',
    		 	   "order":[],
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
    		    	                    columns: ":visible:not(':last')"
    		    	                }
    		    	            },
    		    	            {
    		    	                extend: 'pdf',
    		    	                exportOptions: {
    		    	                    columns: ":visible:not(':last')"
    		    	                }
    		    	            },
    		    	            {
    		    	                extend: 'excel',
    		    	                exportOptions: {
    		    	                    columns: ":visible:not(':last')"
    		    	                }
    		    	            },
    		    	            {
    		    	                extend: 'print',
    		    	                exportOptions: {
    		    	                    columns: ":visible:not(':last')"
    		    	                }
    		    	            }
    		    	        ]
    		    	    }
    		    	]
    		 	});
			}
		}
	});	
}

function addRoleTypeButtonEnable() {
    let programDuration = $("#<portlet:namespace/>programDurationForRole").val();
    let programName = $("#<portlet:namespace/>selectProgramForRole").val();
    if(programDuration>0 && programName >0) {
        $('#addRoleTypeModel').removeAttr('disabled');
    } else {
        $('#addRoleTypeModel').attr('disabled','disabled')
    }
}

$(document).on("click",".openDeleteModal", function(){
	$('.parameter-modal-body #<portlet:namespace/>procedureLoggingParamterId').val($(this).data('id'));
	$('.parameter-modal-body #<portlet:namespace/>masterValue').val($(this).data('parameter'));
	
});

</script>
