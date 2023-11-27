<%@ include file="init.jsp"%>

<liferay-ui:error key="programNameError" message="program-name-error" />
<liferay-ui:error key="programCodeError" message="program-code-error" />
<liferay-ui:error key="programObjectivesError" message="program-objectives-error" />
<liferay-ui:error key="programAdminRequirementsError" message="program-admin-requirements-error" />
<liferay-ui:error key="programVisionError" message="program-vision-error" />
<liferay-ui:error key="programMissionError" message="program-mission-error" />

<portlet:renderURL var="addProgramPageURL">
    <portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>
<portlet:actionURL name="<%= OmsbProgramConstants.SAVE_PROGRAM_MVC_ACTION_COMMAND %>" var="updateProgramActionURL">
	<portlet:param name="redirect" value="${currentURL}"/>
	<portlet:param name="redirectCommand" value="<%= OmsbProgramConstants.EDIT_PROGRAM_MVC_RENDER_COMMAND %>"/>
</portlet:actionURL>

<div class="row">
	<div class="col-md-12">
		<div class="omsb-card">
			<h4 class="omsb-card-title"><liferay-ui:message key="edit-program" /></h4>
			<aui:form action="${updateProgramActionURL}" method="post">
				<div class="row">
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<aui:input cssClass="form-control" label="program-name" type="text" name="programName" localized="true" value="${program.programName}">
								<aui:validator name="required" />
								<aui:validator name="maxLength">200</aui:validator>
							</aui:input>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<aui:input cssClass="form-control" label="program-code" type="text" name="programCode" localized="true" value="${program.programCode}">
								<aui:validator name="required" />
								<aui:validator name="maxLength">75</aui:validator>
							</aui:input>	
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<aui:select cssClass="custom-select form-control" label="program-type" id="programTypeMasterId" name="programTypeMasterId" value="${program.programTypeId}">
								<aui:option value="" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-program-type" /></aui:option>
								<c:forEach items="${programTypes}" var="programTypeObj">
									<aui:option value="${programTypeObj.programTypeMasterId}">${programTypeObj.getProgramTypeName(locale)}</aui:option> 
								</c:forEach>
								<aui:validator name="required" />
							</aui:select>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
								<aui:input label="establishment-date" type="text" cssClass="form-control programEstablishmentDateValue" name="programEstablishmentDateValue" placeholder="DD/MM/YYYY" id="programEstablishmentDateValue" readonly="true" value="${estDate}">
									<aui:validator name="required" />
								</aui:input>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<aui:select id="programStatus" name="programStatus" label="program-status" localized="true"  value="${program.programStatus}" class="custom-select form-control">
								<aui:option value="" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-program-status" /></aui:option>
								<aui:option value="true"><liferay-ui:message key="active" /></aui:option>
								<aui:option value="false"><liferay-ui:message key="inactive" /></aui:option>
								<aui:validator name="required" />
							</aui:select>
						</div>
					</div>
					<!--  The code commented as this details not required  as received feedback from the client on 16-08-2023-->
					<%-- <div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<aui:select cssClass="custom-select form-control" label="eligibility-degree" id="eligibilityDegreeMasterId" name="eligibilityDegreeMasterId" value="${eligibilityDegreeMasterId}">
								<aui:option value="" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-eligibility-degree" /></aui:option>
								<c:forEach items="${eligibilityDegrees}" var="eligibilityDegreeObj">
									<aui:option value="${eligibilityDegreeObj.eligibilityDegreeMasterId}">${eligibilityDegreeObj.eligibilityDegree}</aui:option>
								</c:forEach>
								<aui:validator name="required" />
							</aui:select>
						</div>
					</div> --%> 
					<%-- <div class="col-lg-12 col-md-12 col-sm-12">
						<div class="form-group">
							<label for="programObjectives"><liferay-ui:message key="program-objectives" /><span style="color:red">*</span></label>
							<liferay-ui:input-localized name="programObjectives" xml="${program.programObjectives}" type="editor" cssClass="form-control"/>
						</div>
					</div> --%>
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div class="form-group">
							<label for="programAdmissionRequirements"><liferay-ui:message key="program-admission-requirements" /><span style="color:red">*</span></label>
							<liferay-ui:input-localized name="programAdmissionRequirements" xml="${program.programAdmissionRequirements}" type="editor" cssClass="form-control"/>
						</div>
					</div>
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div class="form-group">
							<label for="programDescription"><liferay-ui:message key="program-description" /><span style="color:red">*</span></label>
							<liferay-ui:input-localized name="programDescription" xml="${program.programDescription}" type="editor" cssClass="form-control"/>
						</div>
					</div>
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div class="form-group">
							<label for="programVision"><liferay-ui:message key="program-vision" /><span style="color:red">*</span></label>
							<liferay-ui:input-localized name="programVision" xml="${program.programVision}" type="editor" cssClass="form-control"/>
						</div>
					</div>
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div class="form-group">
							<label for="programMission"><liferay-ui:message key="program-mission" /><span style="color:red">*</span></label>
							<liferay-ui:input-localized name="programMission" xml="${program.programMission}" type="editor" cssClass="form-control"/>
						</div>
					</div>
				</div>
				<div class="bottom-backbtn-wrap m-0">
					<aui:input label="program-master-id" type="hidden" name="programMasterId"  value="${program.programMasterId}" />
					<button class="btn omsb-bc-red-button" type="submit" title="Save" ><liferay-ui:message key="update" /></button>
					<a class="btn omsb-btn omsb-bg-red-button" href="${currentURL}" title="Cancel"><liferay-ui:message key="cancel" /></a>
				</div>
			</aui:form>
		</div>
	</div>
</div>

<div>
	<jsp:include page="/view.jsp" />
</div>

<script type="text/javascript">
$(document).ready(function(){
	var estDate="${estDate}";
	let currentDate = new Date();
	$('#programEstablishmentDateValue').datepicker({
		format: 'dd/mm/yyyy',
		startDate : new Date('1900-1-1'),
		autoclose: true,
		todayBtn: true,
		todayHighlight: true,
		endDate: currentDate,
		maxDate: currentDate
	});
	$('#programEstablishmentDateValue').datepicker('update',new Date(estDate));
})
</script>