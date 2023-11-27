<%@ include file="init.jsp"%>

<div class="omsb-card">
	<div class="omsb-page-top-info">
		<div class="pagetitle">
			<liferay-ui:message key="edit" />
			<c:if test="${procedureName eq 'selectProgramForRole'}">
				<liferay-ui:message key="role-type" />
			</c:if>
			<c:if test="${procedureName eq 'selectProgramForPatient'}">
				<liferay-ui:message key="patient-type" />
			</c:if>
			<c:if test="${procedureName eq 'selectProgramForVisit'}">
				<liferay-ui:message key="visit-type" />
			</c:if>
		</div>
	</div>
	<div class="row">
		<div class="col">
			<portlet:resourceURL id="/getPatientTypeURL" var="getPatientTypeURL" />
			<aui:form action="${saveProcedureLoggingParameters}"
				name="master-form" method="post">
				<aui:input name="programDuration" type="hidden" value="${programDurationId}"/>
				<div class="row">
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<aui:select cssClass="custom-select form-control js-basic-single"
								label="select-program" name="selectProgram" disabled="true"
								onChange="getProgramDuration('selectProgramForPatient')">
								<c:forEach items="${allProgramList}" var="selectProgramList">
									<option value="${selectProgramList.programMasterId}"
										${programId eq selectProgramList.programMasterId ? 'selected' : ''}>${selectProgramList.getProgramName(locale)}</option>
								</c:forEach>
								<aui:validator name="required" />
							</aui:select>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<aui:select cssClass="custom-select form-control js-basic-single"
								label="program-cohort" name="editProgramDuration"
								disabled="true" onChange="getPatientType()">
								<c:forEach items="${programDurationDetailsList}"
									var="selectProgramDurationList">
									<option
										value="${selectProgramDurationList.getProgDurationId()}"
										${programDurationId eq selectProgramDurationList.getProgDurationId() ? 'selected' : ''}>${selectProgramDurationList.getAyApplicableForm()}</option>
								</c:forEach>
								<aui:validator name="required" />
							</aui:select>
						</div>
					</div>

					<!-- FOR PATIENT TYPE -->
					<c:if test="${procedureName eq 'selectProgramForPatient'}">

						<aui:input type="hidden"
							name="<%=OmsbSetupProceduresWebPortletKeys.MASTER_VALUE %>"
							value="<%=OmsbSetupProceduresWebPortletKeys.PATIENT_TYPE_NAME%>" />
						<aui:input type="hidden"
							name="<%=OmsbSetupProceduresWebPortletKeys.IS_EDIT%>"
							value="<%=Boolean.TRUE %>" />
						<aui:input type="hidden" name="patientTypeProgDurationRelId"
							value="${patientTypeProgDurationRelId}" />
						<div class="col-lg-12 col-md-12 col-sm-12">
							<div class="d-flex align-items-end">
								<div class="form-group">
									<label><liferay-ui:message key="patient-type" />*</label> <select
										cssClass="custom-select form-control" id="patientType"
										name="<portlet:namespace/>patientType" multiple="multiple"
										data-live-search="true">
										<option value="1" selected="true" disabled="true"
											cssClass="placeholder">
											<liferay-ui:message key="please-select-patient-type" />
										</option>
									</select>
								</div>
							</div>
						</div>
					</c:if>

					<!-- FOR ROLE TYPE -->
					<c:if test="${procedureName eq 'selectProgramForRole'}">
						<aui:input type="hidden"
							name="<%=OmsbSetupProceduresWebPortletKeys.MASTER_VALUE %>"
							value="<%=OmsbSetupProceduresWebPortletKeys.ROLE_TYPE_NAME%>" />
						<aui:input type="hidden"
							name="<%=OmsbSetupProceduresWebPortletKeys.IS_EDIT%>"
							value="<%=Boolean.TRUE %>" />
						<aui:input type="hidden" name="roleTypeProgDurationRelId"
							value="${roleTypeProgDurationRelId}" />
						<div class="col-lg-12 col-md-12 col-sm-12">
							<div class="d-flex align-items-end">
								<div class="form-group">
									<label><liferay-ui:message key="role-type" />*</label> <select
										cssClass="custom-select form-control" id="roleType"
										name="<portlet:namespace/>roleType" multiple="multiple"
										data-live-search="true">
										<option value="0" selected="true" disabled="true"
											cssClass="placeholder">
											<liferay-ui:message key="please-select-role-type" />
										</option>
									</select>
								</div>
							</div>
						</div>
					</c:if>

					<!-- FOR VISIT TYPE -->
					<c:if test="${procedureName eq 'selectProgramForVisit'}">
						<aui:input type="hidden"
							name="<%=OmsbSetupProceduresWebPortletKeys.MASTER_VALUE %>"
							value="<%=OmsbSetupProceduresWebPortletKeys.VISIT_TYPE_NAME%>" />
						<aui:input type="hidden"
							name="<%=OmsbSetupProceduresWebPortletKeys.IS_EDIT%>"
							value="<%=Boolean.TRUE %>" />
						<aui:input type="hidden" name="visitTypeProgDurationRelId"
							value="${visitTypeProgDurationRelId}" />
						<div class="col-lg-12 col-md-12 col-sm-12">
							<div class="d-flex align-items-end">
								<div class="form-group">
									<label><liferay-ui:message key="visit-type" />*</label> <select
										cssClass="custom-select form-control" id="visitType"
										name="<portlet:namespace/>visitType" multiple="multiple"
										data-live-search="true">
										<option value="0" selected="true" disabled="true"
											cssClass="placeholder">
											<liferay-ui:message key="please-select-visit-type" />
										</option>
									</select>
								</div>
							</div>
						</div>
					</c:if>
				</div>

				<div class="bottom-backbtn-wrap">
					<button class="btn omsb-bc-red-button" type="submit" onclick='$(".loader-container").addClass("d-flex").removeClass("d-none");' title="Save"><liferay-ui:message key="save" /></button>
					<button onclick="clickProcedureTab('${procedureName}')" class="btn omsb-bg-red-button" ><liferay-ui:message key="back" /></button>
				</div>
			</aui:form>
		</div>
	</div>
</div>

<script>

$('#visitType').multiselect({
    enableFiltering: true
});

$('#patientType').multiselect({
    enableFiltering: true
});

$('#roleType').multiselect({
    enableFiltering: true
});


$(document).ready(function(){
	
	$('#<portlet:namespace/>selectProgramForPatient').attr('disabled', true);
	
	if(${procedureName eq 'selectProgramForPatient'}) {
		getPatientType();
	}
	if(${procedureName eq 'selectProgramForRole'}) {
		getRoles()
	}
	if(${procedureName eq 'selectProgramForVisit'})
	{
		getVisitTypes()
	}
});



function getRoles(){
	programDuration = $("#<portlet:namespace/>programDuration").val();
	$.ajax({
		url: '<%=getRoleTypesURL%>',
		type: 'POST',
		data: {
				<portlet:namespace/>programDuration: programDuration
			},
		success: function(data) {
			if(data.success) {
				$("#roleType").empty();
				/* SET DEFAULT TYPE SELECTED OPTION */
				if(programDuration == ${programDurationId}) {
					$('#roleType').multiselect('destroy');
					$("#roleType").append(`<option value='${roleTypeMasterId}'selected > ${roleTypeProgDurationRelName} </option>`).multiselect({enableFiltering: true});
				}
				let roleTypeDropdownList = data.roleTypeDropdownList;
				for(let i=0; i<roleTypeDropdownList.length; i++) {
					$('#roleType').multiselect('destroy');
					$("#roleType").append("<option value='"+roleTypeDropdownList[i].roleTypeId+"'>" + roleTypeDropdownList[i].roleTypeName + "</option>").multiselect({enableFiltering: true});
				}
				
			}
		}
	});	
}

function getPatientType(){
	let programDuration = $("#<portlet:namespace/>programDuration").val();
	$.ajax({
		url: '<%=getPatientTypeURL%>',
		type: 'POST',
		data: {
				<portlet:namespace/>programDuration: programDuration,				
			},
		success: function(resultObj) {
			if(resultObj) {
				$("#patientType").empty();
				
				/* SET DEFAULT TYPE SELECTED OPTION */
				if(programDuration == ${programDurationId}) {
					$('#patientType').multiselect('destroy');
					$("#patientType").append(`<option value='${patientTypeMasterId}'selected > ${patientTypeProgDurationRelName} </option>`).multiselect({enableFiltering: true});
				}	
				
				
 				let patientTypeDropdownList = resultObj.patientTypeDropdownList;
 				/* SET PATIENT TYPE LIST */
				for(let i=0; i<patientTypeDropdownList.length; i++){
					$('#patientType').multiselect('destroy');
					$("#patientType").append("<option value='"+patientTypeDropdownList[i].patientTypeId+"'>" + patientTypeDropdownList[i].patientTypeName + "</option>").multiselect({enableFiltering: true});
				}
			}
		}
	});
}

function getVisitTypes(){
	let programDuration = $("#<portlet:namespace/>programDuration").val();
	$.ajax({
		url: '<%=getVisitTypesURL%>',
		type: 'POST',
		data:{
			<portlet:namespace/>programDuration: programDuration
		},
		success: function(resultObj) {
			if (resultObj.success) {
				
				$("#visitType").empty();
				
				if(programDuration == ${programDurationId}) {
					$('#visitType').multiselect('destroy');
					$("#visitType").append(`<option value='${visitTypeMasterId}'selected > ${visitTypeProgDurationRelName} </option>`).multiselect({enableFiltering: true});
				}
				
				
				let visitTypeDropdownList = resultObj.visitTypeDropdownList;
				for(let i=0; i<visitTypeDropdownList.length; i++) {
					$('#visitType').multiselect('destroy');
					$("#visitType").append("<option value='"+visitTypeDropdownList[i].visitTypeId+"'>" + visitTypeDropdownList[i].visitTypeName + "</option>").multiselect({enableFiltering: true});
				}
			}	
		}
	});
}


</script>