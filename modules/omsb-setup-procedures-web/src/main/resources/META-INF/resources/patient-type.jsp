<%@page import="gov.omsb.tms.model.PatientTypeProgDurationRel"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@ include file="init.jsp"%>

<portlet:resourceURL id="/getPatientTypeURL" var="getPatientTypeURL" />

<div class="tab-pane fade" id="pills-patienttype" role="tabpanel"
	aria-labelledby="pills-patienttype-tab">
	<aui:form action="${saveProcedureLoggingParameters}" name="form-patient"
		method="post">
		<aui:input type="hidden"
			name="<%=OmsbSetupProceduresWebPortletKeys.MASTER_VALUE %>"
			value="<%=OmsbSetupProceduresWebPortletKeys.PATIENT_TYPE_NAME%>" />
		<aui:input type="hidden"
			name="<%=OmsbSetupProceduresWebPortletKeys.IS_CREATE%>"
			value="<%=Boolean.FALSE %>" />
		<div class="row">
			<div class="col-lg-6 col-md-6 col-sm-12">
				<div class="form-group">
					<aui:select cssClass="custom-select form-control js-basic-single"
						label="select-program" id="selectProgramForPatient"
						name="selectProgramForPatient"
						onChange="getProgramDuration('selectProgramForPatient')">
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
						label="program-cohort" id="programDurationForPatient"
						name="programDurationForPatient" onChange="getPatientType()">
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
						<label><liferay-ui:message key="patient-type" />
							<span class="reference-mark text-warning">
								<svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false">
									<use href="<%=themeDisplay.getPathThemeImages()%>/clay/icons.svg#asterisk"></use>
								</svg>
							</span>
						</label> 
						<select
							cssClass="custom-select form-control"
							id="patientType" onchange="validatePatientType();" name="<portlet:namespace/>patientType" multiple="multiple"
							data-live-search="true">
							<option value="0" selected="true" disabled="true"
								cssClass="placeholder">
								<liferay-ui:message key="please-select-patient-type" />
							</option>
						</select>
					</div>
					<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADD_PATIENT_TYPE)}">
						<button id="addPatientTypeModel" class="btn omsb-bc-red-button omsb-add-btn mb-3 ml-3"
							type="button" title="Add" data-target="#addPatientTypeMasterModal"
							data-toggle="modal" disabled="disabled"  onclick="resetForm('<portlet:namespace/>master-form-patient')">
							<img src="<%=themeDisplay.getPathThemeImages()%>/svg/add.svg"
								alt="<liferay-ui:message key="add-btn" />" />
						</button>
					</c:if>
				</div>

			</div>
		</div>
		<div class="bottom-backbtn-wrap">
			<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADD_PATIENT_TYPE)}">
				<button class="btn omsb-bc-red-button" id="savePatientTypeBtn" disabled="true" onclick='$(".loader-container").addClass("d-flex").removeClass("d-none");' type="submit" title="Save"><liferay-ui:message key="save" /></button>
			</c:if>
			<button class="btn omsb-bg-red-button" type="button" onclick="window.location.reload()" title="Reset"><liferay-ui:message key="reset" /></button>
		</div>
	</aui:form>
	<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, VIEW_PATIENT_TYPE)}">
		<div class="row mt-4">
			<div class="col-md-12">
				<div class="omsb-list-view table-responsive">
					<table id="patientTypeProgRelTable" class="display omsb-datatables">
						<thead>
							<tr>
								<th><liferay-ui:message key="program" /></th>
								<th><liferay-ui:message key="patient-type" /></th>
								<th><liferay-ui:message key="created-date" /></th>
								<th><liferay-ui:message key="modified-date" /></th>
								<th><liferay-ui:message key="modified-by" /></th>
								<th><liferay-ui:message key="action" /></th>
							</tr>
						</thead>
						<tbody id="patientTypeBody">
							<c:forEach items="${patientTypeProgDurationRelList}" var="patientTypeProgDuration"> 
							<%
							PatientTypeProgDurationRel patientTypeProgDurationRel= (PatientTypeProgDurationRel)pageContext.getAttribute("patientTypeProgDuration");
							%>
					            <tr>
					            	<td>${programNameCohotMapping.get(patientTypeProgDuration.getProgramDurationId())}</td>
					                <td>${patientTypeMapping.get(patientTypeProgDuration.getPatientTypeMasterId())}</td>
					                <td>${sdf.format(patientTypeProgDuration.getCreateDate())}</td>
					                <td>${sdf.format(patientTypeProgDuration.getModifiedDate())}</td>
	    				            <td><%=UserLocalServiceUtil.getUser(patientTypeProgDurationRel.getModifiedBy()).getFullName()%></td>
					                <td class="text-center" style="width:100px">
						            	<div class="dropdown">
					            			<button class="btn fa fa-ellipsis-v dropdown-toggle"
												type="button" data-toggle="dropdown" aria-expanded="false">
												<i class=""></i>
											</button>
											<portlet:renderURL var="editPatientTypeProgDuration">
											    <portlet:param name="mvcRenderCommandName" value="/edit-procedure-logging-parameters-form" />
											    <portlet:param name="editProcedureName" value="<%=OmsbSetupProceduresWebPortletKeys.SELECT_PROGRAM_FOR_PATIENT%>" />
											    <portlet:param name="procedureTypeProgDurationRelId" value="${patientTypeProgDuration.getPatientTypeProgDurationRelId()}" />
												<portlet:param name="procedureTypeProgDurationRelName" value="${patientTypeMapping.get(patientTypeProgDuration.getPatientTypeMasterId())}" />											    
											</portlet:renderURL>
											
											<ul class="dropdown-menu">
												<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, EDIT_PATIENT_TYPE)}">
													<li><a href="${editPatientTypeProgDuration}" onClick="$('.loader-container').addClass('d-flex').removeClass('d-none');" class="dropdown-item"><i
															class="fa fa-pencil"></i> <liferay-ui:message key="edit" />
														</a>
													</li>
												</c:if>
												<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, DELETE_PATIENT_TYPE)}">
													<li><a href="javascript:void(0)" class="dropdown-item openDeleteModal" id="${patientTypeProgDuration.getPatientTypeProgDurationRelId()}" data-parameter="<%=OmsbSetupProceduresWebPortletKeys.PATIENT_TYPE_NAME%>"  data-id="${patientTypeProgDuration.getPatientTypeProgDurationRelId()}" data-target="#deleteModal" data-toggle="modal" >
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
<h2>${procedureTabName}</h2>
<jsp:include page="/add-patient-type-modal-popup.jsp" />


<script>
function validatePatientType(){
	$('#savePatientTypeBtn').prop('disabled', $("#patientType").val().length > 0 ? false : true);
}

$('#patientType').multiselect({
	enableFiltering: true
});

$('#patientTypeProgRelTable').DataTable({
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

$("#addPatientTypeModel").click(function(){
    let programDuration = $("#<portlet:namespace/>programDurationForPatient").val();
    $(".modal-body #<portlet:namespace/>programDurationForPatient").val(programDuration);
    
    const programName =  $("#<portlet:namespace/>selectProgramForPatient :selected").text();
	const programCohort =	$("#<portlet:namespace/>programDurationForPatient :selected").text();
	 
	 $("#addPatientTypeMasterModal #progName .label-content").html(programName);
	 $("#addPatientTypeMasterModal #progCohort .label-content").html(programCohort);
	 
});


function getPatientType(){

	let programDuration = $("#<portlet:namespace/>programDurationForPatient").val();
	$.ajax({
		url: '<%=getPatientTypeURL%>',
		type: 'POST',
		data:
			{
				<portlet:namespace/>programDuration: programDuration
			},
		success: function(resultObj)	
		{
			if(resultObj)
			{
				addPatientTypeButtonEnable();		

				$("#patientType").empty();			 	
				validatePatientType();
 				let patientTypeDropdownList = resultObj.patientTypeDropdownList;
				for(let i=0; i<patientTypeDropdownList.length; i++){
					$('#patientType').multiselect('destroy');
					$("#patientType").append("<option value='"+patientTypeDropdownList[i].patientTypeId+"'>" + patientTypeDropdownList[i].patientTypeName + "</option>").multiselect({enableFiltering: true});
				}
				$('#patientTypeProgRelTable').DataTable().destroy();
				$("#patientTypeBody").empty();
				let patientTypeTableList = resultObj.patientTypeTableList.patientTypeMapping;
					
				for(let i=0; i<patientTypeTableList.length; i++){
					let rowHTML = `<tr>
						<td>\${patientTypeTableList[i].programNameCohortMap}</td>
						<td>\${patientTypeTableList[i].patientTypeName}</td>
						<td>\${patientTypeTableList[i].createdDate}</td>
						<td>\${patientTypeTableList[i].modifiedDate}</td>
						<td>\${patientTypeTableList[i].modifiedBy}</td>
						<td class="text-center" style="width: 100px">
							<div class="dropdown">
								<button class="btn fa fa-ellipsis-v dropdown-toggle"
									type="button" data-toggle="dropdown" aria-expanded="false">
									<i class=""></i>
								</button>
								<ul class="dropdown-menu">
									<li><a href="\${patientTypeTableList[i].editURL}" onClick="$('.loader-container').addClass('d-flex').removeClass('d-none');" class="dropdown-item"><i
											class="fa fa-pencil"></i> <liferay-ui:message key="edit" />
										</a>
									</li>
									<li><a href="javascript:void(0)" class="dropdown-item openDeleteModal"  id="\${patientTypeTableList[i].patientTypeProgDurationRelName}"  data-parameter="<%=OmsbSetupProceduresWebPortletKeys.PATIENT_TYPE_NAME%>"  data-id="\${patientTypeTableList[i].patientTypeProgDurationRelName}" data-target="#deleteModal" data-toggle="modal" >
											<i class="fa fa-trash-o"></i> <liferay-ui:message key="delete" />
										</a>
									</li>
								</ul>
							</div>
						</td>
					</tr>`;
	    		 	$("#patientTypeBody").append(rowHTML);	
				}
				$('#patientTypeProgRelTable').DataTable({
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

function addPatientTypeButtonEnable()
{
	let programDuration = $("#<portlet:namespace/>programDurationForPatient").val();
	let programName = $("#<portlet:namespace/>selectProgramForPatient").val();
	if(programDuration > 0 && programName > 0)
	{
		$('#addPatientTypeModel').removeAttr('disabled');
	}else
	{
		$('#addPatientTypeModel').attr('disabled','disabled')
	}
	
}

$(document).on("click",".openDeleteModal", function(){
	$('.parameter-modal-body #<portlet:namespace/>procedureLoggingParamterId').val($(this).data('id'));
	$('.parameter-modal-body #<portlet:namespace/>masterValue').val($(this).data('parameter'));
	
});



</script>