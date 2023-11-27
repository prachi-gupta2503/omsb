<%@ include file="init.jsp" %>

<portlet:actionURL name="<%= OmsbSetupProceduresWebPortletKeys.SAVE_SETUP_PROCEDURE_MVC_COMMAND_NAME %>" var="saveSetupProcedureURL" >
	<portlet:param name="redirect" value="${currentURL}"/>
</portlet:actionURL>

<%-- <portlet:resourceURL id="/getProgramDurationURL" var="getProgramDurationURL" /> --%>
<portlet:resourceURL id="/getTraineeLevelURL" var="getTraineeLevelURL" />
<portlet:resourceURL id="/getRotationURL" var="getRotationURL" />

<div class="row">
	<div class="col-md-12">
		<div class="omsb-card">
			<h4 class="omsb-card-title"><liferay-ui:message key="setup-procedure" /></h4>
			<aui:form action="${saveSetupProcedureURL}" name="fm">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div class="form-group">
							<aui:select cssClass="custom-select form-control" label="select-program" id="selectProgramForConfig" name="selectProgramForConfig"  onChange="getProgramDuration('selectProgramForConfig')" ignoreRequestValue = "true">
								<aui:option value="0" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-program" /></aui:option>
								<c:forEach items="${allProgramList}" var="selectProgramList">
									<aui:option value="${selectProgramList.programMasterId}">${selectProgramList.getProgramName(locale)}</aui:option>
								</c:forEach>
								<aui:validator name="required" />
							</aui:select>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<aui:select cssClass="custom-select form-control" label="program-cohort" id="programDurationForConfig" name="programDurationForConfig" onChange="getTraineeLevel()" ignoreRequestValue = "true">
								<aui:option value="0" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-program-duration" /></aui:option>
								<aui:validator name="required" />
							</aui:select>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<aui:select cssClass="custom-select form-control" label="trainee-level" id="traineeLevel" name="traineeLevel" onChange="getRotation()">
								<aui:option value="0"><liferay-ui:message key="please-select-trainee-level" /></aui:option>
							</aui:select>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<aui:select cssClass="custom-select form-control" label="rotation" id="rotation" name="rotation" >
								<aui:option value="0" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-rotation" /></aui:option>
								<c:forEach items="${allRotations}" var="allRotationsList">
									<aui:option value="${allRotationsList.rotationMasterId}">${allRotationsList.rotationName}</aui:option>
								</c:forEach>
								<aui:validator name="required" />
							</aui:select>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<div class="d-flex">
								<aui:select cssClass="custom-select form-control col-11" label="procedure-group" id="procedureGroup" name="procedureGroup">
									<aui:option value="0" selected="true"><liferay-ui:message key="please-select-procedure-group" /></aui:option>
									<c:forEach items="${allProcedureGroups}" var="procedureGroupList">
										<aui:option value="${procedureGroupList.procedureGroupMasterId}">${procedureGroupList.getProcedureGroupName(locale)}</aui:option>
									</c:forEach>
								</aui:select>
								<button type="button" class="omsb-bc-red-button add-master p-0 col-1" id="addProcedureGroup" data-master="procedureGroup" data-target="#addProcedureGroupMasterModal" data-toggle="modal"  onclick="resetForm('<portlet:namespace/>fm-procedure-group')" ><i class="fa fa-plus"></i></button>
						    </div>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<div class="d-flex">
								<aui:select cssClass="custom-select form-control col-11" label="procedures" id="procedures" name="procedures" >
									<aui:option value="0" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-procedure" /></aui:option>
									<c:forEach items="${allProcedures}" var="allProceduresList">
										<aui:option value="${allProceduresList.procedureMasterId}">${allProceduresList.getProcedureName(locale)}</aui:option>
									</c:forEach>
									<aui:validator name="required" />
								</aui:select>
								<button type="button" class="omsb-bc-red-button add-master p-0 col-1" id="addProcedures" data-master="procedures" data-target="#addProcedureMasterModal" data-toggle="modal"  onclick="resetForm('<portlet:namespace/>fm-procedure')"><i class="fa fa-plus"></i></button>
							</div>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<div class="d-flex">
								<aui:select cssClass="custom-select form-control col-11" label="cpt-code" id="cptCodes" name="cptCodes" >
									<aui:option value="0" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-cpt-code" /></aui:option>
									<c:forEach items="${allCptCodes}" var="allCptCodesList">
										<aui:option value="${allCptCodesList.cptCodeMasterId}">${allCptCodesList.getCptCodeName(locale)}</aui:option>
									</c:forEach>
								</aui:select>
								<button type="button" class="omsb-bc-red-button add-master p-0 col-1" id="addCptCode" data-master="cptCodes" data-target="#addCptCodesMasterModal" data-toggle="modal" ><i class="fa fa-plus"></i></button>
							</div>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<div class="d-flex">
								<aui:select cssClass="custom-select form-control col-11" label="participation-type" id="participationType" name="participationType">
									<aui:option value="0" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-participation-type" /></aui:option>
									<c:forEach items="${allParticipationType}" var="participationTypeList">
										<aui:option value="${participationTypeList.participationTypeMasterId}">${participationTypeList.getParticipationTypeName(locale)}</aui:option>
									</c:forEach>
									<aui:validator name="required" />
								</aui:select>
								<button type="button" class="omsb-bc-red-button add-master p-0 col-1" id="addParticipationType" data-master="participationType" data-target="#addParticipationTypeMasterModal" data-toggle="modal" ><i class="fa fa-plus"></i></button>
							</div>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<label><liferay-ui:message key="minimum-procedures" /></label>
							<input class="custom-select form-control" type="number" name="<portlet:namespace/>minimumProcedures" min="0" step="1" required />
						</div>
					</div>
				</div>
				<div class="bottom-backbtn-wrap m-0">
					<button class="btn omsb-bc-red-button" type="submit" title="Save" ><liferay-ui:message key="save" /></button>
					<button class="btn omsb-bc-red-button" type="reset" title="Cancel" ><liferay-ui:message key="cancel" /></button>
				</div>
			</aui:form>
		</div>
	</div>
</div>

<div class="row">
	<jsp:include page="/setup-procedure-table-listing.jsp" />
</div>
<jsp:include page="/add-procedure-group-modal-popup.jsp" />
<jsp:include page="/add-procedure-modal-popup.jsp" />
<jsp:include page="/add-role-type-modal-popup.jsp" />
<jsp:include page="/add-visit-type-modal-popup.jsp" />
<jsp:include page="/add-patient-type-modal-popup.jsp" />

<script>

/* $(".add-master").on("click",function() {
    $("#addMasterModal .modal-title").empty();
    $("#addMasterModal .form-field").empty();
    masterName = $(this).data('master');
    console.log("masterName :: " , masterName);
    $("#addMasterModal .modal-body .procedureGroup").addClass("d-none");
    $("#addMasterModal .modal-body .procedures").addClass("d-none");
    $("#addMasterModal .modal-body .cptCodes").addClass("d-none");
    $("#addMasterModal .modal-body .participationType").addClass("d-none");
    if(masterName == "procedureGroup") {
        $("#addMasterModal .modal-title").html(`<liferay-ui:message key="add-procedure-group" />`);
    } else if (masterName == "procedures") {
        $("#addMasterModal .modal-title").html(`<liferay-ui:message key="add-procedure" />`);
    } else if (masterName == "cptCodes") {
        $("#addMasterModal .modal-title").html(`<liferay-ui:message key="add-cpt-codes" />`);
    } else if (masterName == "participationType") {
        $("#addMasterModal .modal-title").html(`<liferay-ui:message key="add-participation-type" />`);
    }
    $("#addMasterModal .modal-body ." + masterName).removeClass("d-none");
});
 */
 
 function getTraineeLevel(){
		let programDuration = $("#<portlet:namespace/>programDuration").val();
		$.ajax({
			url: '<%=getTraineeLevelURL%>',
			type: 'POST',
			data:
				{
					<portlet:namespace/>programDuration: programDuration
				},
			success: function(data)	
			{
				let traineeLevelJson = JSON.parse(data);
				$("#<portlet:namespace/>traineeLevel").empty();
				$("#<portlet:namespace/>traineeLevel").append(`<aui:option value="0"><liferay-ui:message key="please-select-trainee-level" /></aui:option>`);
				for(let i=0; i<traineeLevelJson.length; i++){
					$("#<portlet:namespace/>traineeLevel").append("<option value='"+traineeLevelJson[i].traineeLevelId+"'>" + traineeLevelJson[i].traineeLevelName + "</option>");
				}
			}
		});
	}

	function getRotation(){
		let traineeLevel = $("#<portlet:namespace/>traineeLevel").val();
		let programDurationId = $("#<portlet:namespace/>programDuration").val();
		$.ajax({
			url: '<%=getRotationURL%>',
			type: 'POST',
			data:
				{
					<portlet:namespace/>traineeLevel: traineeLevel,
					<portlet:namespace/>programDurationId: programDurationId
				},
			success: function(data)	
			{
				let rotationJson = JSON.parse(data);
				$("#<portlet:namespace/>rotation").empty();
				$("#<portlet:namespace/>rotation").append(`<aui:option value="0" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-rotation" /></aui:option>`);
				for(let i=0; i<rotationJson.length; i++){
					$("#<portlet:namespace/>rotation").append("<option value='"+rotationJson[i].rotationMasterId+"'>" + rotationJson[i].rotationName + "</option>");
				}
			}
		});
	}


</script>