<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="gov.omsb.tms.model.VisitTypeProgDurationRel"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@ include file="init.jsp"%>

<div class="tab-pane fade" id="pills-visittype" visit="tabpanel"
	aria-labelledby="pills-visittype-tab">
	<aui:form action="${saveProcedureLoggingParameters}" name="form-visit"
		method="post">
		<aui:input type="hidden"
			name="<%=OmsbSetupProceduresWebPortletKeys.MASTER_VALUE%>"
			value="<%=OmsbSetupProceduresWebPortletKeys.VISIT_TYPE_NAME%>" />
		<aui:input type="hidden"
			name="<%=OmsbSetupProceduresWebPortletKeys.IS_CREATE%>"
			value="<%=Boolean.FALSE%>" />
		<div class="row">

			<div class="col-lg-6 col-md-6 col-sm-12">
				<div class="form-group">
					<aui:select cssClass="custom-select form-control js-basic-single"
						label="select-program" id="selectProgramForVisit"
						name="selectProgramForVisit"
						onChange="getProgramDuration('selectProgramForVisit')">
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
						label="program-cohort" id="programDurationForVisit"
						name="programDurationForVisit"
						onChange="getVisitTypes(this.value)">
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
						<label><liferay-ui:message key="visit-type" />
							<span class="reference-mark text-warning">
								<svg aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk" focusable="false">
									<use href="<%=themeDisplay.getPathThemeImages()%>/clay/icons.svg#asterisk"></use>
								</svg>
							</span>
						</label> 
						<select cssClass="custom-select form-control" id="visitType"
							name="<portlet:namespace/>visitType" onchange="validateVisitType()" multiple="multiple" data-live-search="true">
							<option value="0" selected="true" disabled="true"
								cssClass="placeholder">
								<liferay-ui:message key="please-select-visit-type" />
							</option>
						</select>
					</div>
					<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADD_VISIT_TYPE)}">
						<button class="btn omsb-bc-red-button omsb-add-btn mb-3 ml-3"
							type="button" title="Add" id="addVisitTypeModel"
							data-target="#addVisitTypeMasterModal" data-toggle="modal"
							disabled="disabled"  onclick="resetForm('<portlet:namespace/>master-form-visit')">
							<img src="<%=themeDisplay.getPathThemeImages()%>/svg/add.svg"
								alt="<liferay-ui:message key="add-btn" />" />
						</button>
					</c:if>
				</div>
			</div>
		</div>
		<div class="bottom-backbtn-wrap">
			<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADD_VISIT_TYPE)}">
				<button class="btn omsb-bc-red-button" id="saveVisitTypeBtn" type="submit" onclick='$(".loader-container").addClass("d-flex").removeClass("d-none");' title="Save" disabled="true"><liferay-ui:message key="save" /></button>
			</c:if>
			<button class="btn omsb-bg-red-button" type="button" onclick="window.location.reload()" title="Reset"><liferay-ui:message key="reset" /></button>
		</div>
	</aui:form>
	<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, VIEW_VISIT_TYPE)}">
		<div class="row mt-4">
			<div class="col-md-12">
				<div class="omsb-list-view table-responsive">
					<table id="visitTypeProgRelTable" class="display omsb-datatables">
						<thead>
							<tr>
								<th><liferay-ui:message key="program" /></th>
								<th><liferay-ui:message key="visit-type" /></th>
								<th><liferay-ui:message key="created-date" /></th>
								<th><liferay-ui:message key="modified-date" /></th>
								<th><liferay-ui:message key="modified-by" /></th>
								<th><liferay-ui:message key="action" /></th>
							</tr>
						</thead>
						<tbody id="visitTypeBody">
							<c:forEach items="${visitTypeProgDurationRelList}"
								var="visitTypeProgDuration">
							<%
							VisitTypeProgDurationRel visitTypeProgDurationRel= (VisitTypeProgDurationRel)pageContext.getAttribute("visitTypeProgDuration");
							%>			
								<tr>
									<td>${programNameCohotMapping.get(visitTypeProgDuration.getProgramDurationId())}</td>
									<td>${visitTypeMapping.get(visitTypeProgDuration.getVisitTypeMasterId())}</td>
									<td>${sdf.format(visitTypeProgDuration.getCreateDate())}</td>
					                <td>${sdf.format(visitTypeProgDuration.getModifiedDate())}</td>
					                <td><%=UserLocalServiceUtil.getUser(visitTypeProgDurationRel.getModifiedBy()).getFullName()%></td>
									<td class="text-center" style="width: 100px" id="action">
										<div class="dropdown">
											<button class="btn fa fa-ellipsis-v dropdown-toggle"
												type="button" data-toggle="dropdown" aria-expanded="false">
												<i class=""></i>
											</button>
											<portlet:renderURL var="editVisitTypeProgDuration">
												 <portlet:param name="mvcRenderCommandName" value="/edit-procedure-logging-parameters-form" />
											    <portlet:param name="editProcedureName" value="<%=OmsbSetupProceduresWebPortletKeys.SELECT_PROGRAM_FOR_VISIT%>" />
											    <portlet:param name="procedureTypeProgDurationRelId" value="${visitTypeProgDuration.getVisitTypeProgDurationRelId()}" />
												<portlet:param name="procedureTypeProgDurationRelName" value="${visitTypeMapping.get(visitTypeProgDuration.getVisitTypeMasterId())}" />
											</portlet:renderURL>
											<ul class="dropdown-menu">
												<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, EDIT_VISIT_TYPE)}">
													<li><a href="${editVisitTypeProgDuration}" onClick="$('.loader-container').addClass('d-flex').removeClass('d-none');" class="dropdown-item"><i
															class="fa fa-pencil"></i> <liferay-ui:message key="edit" />
														</a>
													</li>
												</c:if>
												<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, DELETE_VISIT_TYPE)}">
													<li><a href="javascript:void(0)" class="dropdown-item openDeleteModal" id="${visitTypeProgDuration.getVisitTypeProgDurationRelId()}" data-parameter="<%=OmsbSetupProceduresWebPortletKeys.VISIT_TYPE_NAME%>" data-id="${visitTypeProgDuration.getVisitTypeProgDurationRelId()}" data-target="#deleteModal" data-toggle="modal" >
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

<%@ include file="/add-visit-type-modal-popup.jsp"%>
<%@ include file="/modal-popup.jsp"%>

<script type="text/javascript">
	function validateVisitType() {
		$('#saveVisitTypeBtn').prop('disabled', $("#visitType").val().length > 0 ? false : true);
	}

	$('#visitType').multiselect({
	    enableFiltering: true
	});
	
	$('#visitTypeProgRelTable').DataTable({
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
	
	$("#addVisitTypeModel").click(function(){
		 let programDuration = $("#<portlet:namespace/>programDurationForVisit").val();
		 $(".modal-body #<portlet:namespace/>programDurationForVisit").val(programDuration);
		 
		 const programName =  $("#<portlet:namespace/>selectProgramForVisit :selected").text();
		 const programCohort =	$("#<portlet:namespace/>programDurationForVisit :selected").text();
		 
		 $("#addVisitTypeMasterModal #progName .label-content").html(programName);
		 $("#addVisitTypeMasterModal #progCohort .label-content").html(programCohort);
		 
	});
	
	function getVisitTypes(programDurationId){
		$.ajax({
			url: '<%=getVisitTypesURL%>',
			type: 'POST',
			data:{
				<portlet:namespace/>programDuration: programDurationId
			},
			success: function(resultObj)	
			{
				if (resultObj.success) {
					addVisitTypeButtonEnable();
					
					$("#visitType").empty();
					validateVisitType();
					let visitTypeDropdownList = resultObj.visitTypeDropdownList;
					for(let i=0; i<visitTypeDropdownList.length; i++){
						$('#visitType').multiselect('destroy');
						$("#visitType").append("<option value='"+visitTypeDropdownList[i].visitTypeId+"'>" + visitTypeDropdownList[i].visitTypeName + "</option>").multiselect({enableFiltering: true});
					}
					$('#visitTypeProgRelTable').DataTable().destroy();
					$("#visitTypeBody").empty();
					let visitTypeTableList = resultObj.visitTypeTableList.visitTypeMapping;
						                   
					for(let i=0; i<visitTypeTableList.length; i++){
						let rowHTML = `<tr>
							<td>\${visitTypeTableList[i].programNameCohortMap}</td>
							<td>\${visitTypeTableList[i].visitTypeName}</td>
							<td>\${visitTypeTableList[i].createdDate}</td>
							<td>\${visitTypeTableList[i].modifiedDate}</td>
							<td>\${visitTypeTableList[i].modifiedBy}</td>
							<td class="text-center" style="width: 100px">
								<div class="dropdown">
									<button class="btn fa fa-ellipsis-v dropdown-toggle"
										type="button" data-toggle="dropdown" aria-expanded="false">
										<i class=""></i>
									</button>
									<ul class="dropdown-menu">
										<li><a href="\${visitTypeTableList[i].editURL}" onClick="$('.loader-container').addClass('d-flex').removeClass('d-none');" class="dropdown-item"><i
												class="fa fa-pencil"></i> <liferay-ui:message key="edit" />
											</a>
										</li>
										<li><a href="javascript:void(0)" class="dropdown-item openDeleteModal"  id="\${visitTypeTableList[i].visitTypeProgDurationRelId}"  data-parameter="<%=OmsbSetupProceduresWebPortletKeys.VISIT_TYPE_NAME%>"  data-id="\${visitTypeTableList[i].visitTypeProgDurationRelId}" data-target="#deleteModal" data-toggle="modal" >
												<i class="fa fa-trash-o"></i> <liferay-ui:message key="delete" />
											</a>
										</li>
									</ul>
								</div>
							</td>
						</tr>`;
		    		 	$("#visitTypeBody").append(rowHTML);	
					}
					$('#visitTypeProgRelTable').DataTable({
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
	
	function addVisitTypeButtonEnable()
	{
	    let programDuration = $("#<portlet:namespace/>programDurationForVisit").val();
	    let programName = $("#<portlet:namespace/>selectProgramForVisit").val();
	    if(programDuration>0 && programName >0)
	    {
	        $('#addVisitTypeModel').removeAttr('disabled');
	    }else
	    {
	        $('#addVisitTypeModel').attr('disabled','disabled')
	    }

	}
	
	$(document).on("click",".openDeleteModal", function(){
		$('.parameter-modal-body #<portlet:namespace/>procedureLoggingParamterId').val($(this).data('id'));
		$('.parameter-modal-body #<portlet:namespace/>masterValue').val($(this).data('parameter'));
		
	});
	
</script>
