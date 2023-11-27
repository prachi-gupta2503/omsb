<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib prefix="liferay-frontend" uri="http://liferay.com/tld/frontend" %>

<%@page import="gov.omsb.setup.procedures.web.constants.OmsbSetupProceduresWebPortletKeys"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors"%>

<liferay-frontend:defineObjects />

<liferay-theme:defineObjects />

<portlet:defineObjects />

<portlet:resourceURL id="/getRoleType" var="getRoleTypesURL" />
<portlet:resourceURL id="/getPatientType" var="getPatientTypesURL" />
<portlet:resourceURL id="/getVisitType" var="getVisitTypesURL" />

<portlet:resourceURL id="/getProgramDurationURL" var="getProgramDurationURL" />

<portlet:actionURL name="<%=OmsbSetupProceduresWebPortletKeys.SAVE_PROCEDURE_LOGGING_PARAMETER_MVC_ACTION_COMMAND%>" var="saveProcedureLoggingParameters" >
	<portlet:param name="redirect" value="${currentURL}"/>
</portlet:actionURL>

<portlet:renderURL var="defaultRenderURL">
    <portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>

<portlet:renderURL var="resetConfigureProcedureForm">
    <portlet:param name="mvcRenderCommandName" value="/" />
    <portlet:param name="<%=OmsbSetupProceduresWebPortletKeys.MASTER_VALUE%>" value="<%=OmsbSetupProceduresWebPortletKeys.PROCEDURES%>" />
</portlet:renderURL>

<c:set var = "ADD_ROLE_TYPE" value = "ADD_ROLE_TYPE"/>
<c:set var = "EDIT_ROLE_TYPE" value = "EDIT_ROLE_TYPE"/>
<c:set var = "DELETE_ROLE_TYPE" value = "DELETE_ROLE_TYPE"/>
<c:set var = "VIEW_ROLE_TYPE" value = "VIEW_ROLE_TYPE"/>
<c:set var = "ADD_PATIENT_TYPE" value = "ADD_PATIENT_TYPE"/>
<c:set var = "EDIT_PATIENT_TYPE" value = "EDIT_PATIENT_TYPE"/>
<c:set var = "DELETE_PATIENT_TYPE" value = "DELETE_PATIENT_TYPE"/>
<c:set var = "VIEW_PATIENT_TYPE" value = "VIEW_PATIENT_TYPE"/>
<c:set var = "ADD_VISIT_TYPE" value = "ADD_VISIT_TYPE"/>
<c:set var = "EDIT_VISIT_TYPE" value = "EDIT_VISIT_TYPE"/>
<c:set var = "DELETE_VISIT_TYPE" value = "DELETE_VISIT_TYPE"/>
<c:set var = "VIEW_VISIT_TYPE" value = "VIEW_VISIT_TYPE"/>
<c:set var = "ADD_PROCEDURE_GROUP" value = "ADD_PROCEDURE_GROUP"/>
<c:set var = "ADD_PROCEDURE" value = "ADD_PROCEDURE"/>
<c:set var = "ADD_CONFIGURED_PROCEDURE" value = "ADD_CONFIGURED_PROCEDURE"/>
<c:set var = "EDIT_CONFIGURED_PROCEDURE" value = "EDIT_CONFIGURED_PROCEDURE"/>
<c:set var = "DELETE_CONFIGURED_PROCEDURE" value = "DELETE_CONFIGURED_PROCEDURE"/>
<c:set var = "VIEW_CONFIGURED_PROCEDURE" value = "VIEW_CONFIGURED_PROCEDURE"/>

<script>
var defaultConfigureProcedureView = $("#<portlet:namespace/>saveConfigureProcedureForm").html();

function getProgramDuration(getProgramsFor){
	let defaultOption = '';
	if(getProgramsFor == '<%=OmsbSetupProceduresWebPortletKeys.SELECT_PROGRAM_FOR_PATIENT%>') {
		defaultOption = `<option value="0" selected="true" disabled="true"
			cssClass="placeholder">
			<liferay-ui:message key="please-select-patient-type" />
		</option>`
		$("#patientType").empty();
		$('#patientType').multiselect('destroy');
		$("#patientType").append(defaultOption).multiselect({enableFiltering: true});
	}
	if(getProgramsFor == '<%=OmsbSetupProceduresWebPortletKeys.SELECT_PROGRAM_FOR_ROLE%>') {
		defaultOption = `<option value="0" selected="true" disabled="true"
			cssClass="placeholder">
			<liferay-ui:message key="please-select-role-type" />
		</option>`
		$("#roleType").empty();
		$('#roleType').multiselect('destroy');
		$("#roleType").append(defaultOption).multiselect({enableFiltering: true});
	}
	if(getProgramsFor == '<%=OmsbSetupProceduresWebPortletKeys.SELECT_PROGRAM_FOR_VISIT%>') {
		defaultOption = `<option value="0" selected="true" disabled="true"
			cssClass="placeholder">
			<liferay-ui:message key="please-select-visit-type" />
		</option>`
		$("#visitType").empty();
		$('#visitType').multiselect('destroy');
		$("#visitType").append(defaultOption).multiselect({enableFiltering: true});
	}
	
	if(getProgramsFor == '<%=OmsbSetupProceduresWebPortletKeys.SELECT_PROGRAM_FOR_CONFIG%>') {
		removeError($('#<portlet:namespace/>selectProgramForConfig'));
	}

	let program = $("#<portlet:namespace/>"+getProgramsFor).val();
	$.ajax({
		url: '<%=getProgramDurationURL%>',
		type: 'POST',
		data: {
				<portlet:namespace/>program: program
			},
		success: function(data)	{
			let jsondata = JSON.parse(data);
			if(jsondata) {
				if(getProgramsFor == '<%=OmsbSetupProceduresWebPortletKeys.SELECT_PROGRAM_FOR_ROLE%>') {
					$("#<portlet:namespace/>programDurationForRole").empty().select2();
					$("#<portlet:namespace/>programDurationForRole").append(`<aui:option value="0" selected="true" disabled= "true" cssClass="placeholder"><liferay-ui:message key="please-select-program-duration" /></aui:option>`);
					for(let i=0; i<jsondata.length; i++){
						$("#<portlet:namespace/>programDurationForRole").append("<option value='"+jsondata[i].progDurationId+"'>" + jsondata[i].ayApplicableForm + "</option>");
					}
					addRoleTypeButtonEnable();
					validateRoleType();
				}
				if(getProgramsFor == '<%=OmsbSetupProceduresWebPortletKeys.SELECT_PROGRAM_FOR_PATIENT%>') {
					$("#<portlet:namespace/>programDurationForPatient").empty().select2();
					$("#<portlet:namespace/>programDurationForPatient").append(`<aui:option value="0" selected="true" disabled= "true" cssClass="placeholder"><liferay-ui:message key="please-select-program-duration" /></aui:option>`);
					for(let i=0; i<jsondata.length; i++){
						$("#<portlet:namespace/>programDurationForPatient").append("<option value='"+jsondata[i].progDurationId+"'>" + jsondata[i].ayApplicableForm + "</option>");
					}
					addPatientTypeButtonEnable();
					validatePatientType();
				}
				if(getProgramsFor == '<%=OmsbSetupProceduresWebPortletKeys.SELECT_PROGRAM_FOR_VISIT%>') {
					$("#<portlet:namespace/>programDurationForVisit").empty().select2();
					$("#<portlet:namespace/>visitType").empty();
					$("#<portlet:namespace/>visitType").append("<option value='0'><liferay-ui:message key='please-visit-type' /></option>");
					$("#<portlet:namespace/>programDurationForVisit").append(`<aui:option value="0" selected="true" disabled= "true" cssClass="placeholder"><liferay-ui:message key="please-select-program-duration" /></aui:option>`);
					for(let i=0; i<jsondata.length; i++){
						$("#<portlet:namespace/>programDurationForVisit").append("<option value='"+jsondata[i].progDurationId+"'>" + jsondata[i].ayApplicableForm + "</option>");
					}
					addVisitTypeButtonEnable();
					validateVisitType();
				}
				if(getProgramsFor == '<%=OmsbSetupProceduresWebPortletKeys.SELECT_PROGRAM_FOR_CONFIG%>') {
					$("#<portlet:namespace/>programDurationForConfig").empty().select2();
					$("#<portlet:namespace/>programDurationForConfig").append(`<aui:option value="0" selected="true" disabled= "true" cssClass="placeholder"><liferay-ui:message key="please-select-program-duration" /></aui:option>`);
					for(let i=0; i<jsondata.length; i++){
						$("#<portlet:namespace/>programDurationForConfig").append("<option value='"+jsondata[i].progDurationId+"'>" + jsondata[i].ayApplicableForm + "</option>");
					}
					addProcedureGroupAndProcedureButtonEnable();
				}
			}
		}
	});
}

function resetForm(formName) {
	document.getElementById(formName).reset();
	resetAllMultiSelectDropDown();
}

function resetAllMultiSelectDropDown() {
	/* for Patient  */
	let defaultOptionForPatient = `<option value="0" selected="true" disabled="true"
		cssClass="placeholder">
		<liferay-ui:message key="please-select-patient-type" />
	</option>`
	$("#patientType").empty();
	$('#patientType').multiselect('destroy');
	$("#patientType").append(defaultOptionForPatient).multiselect({enableFiltering: true});
	
	/* for role  */
	let defaultOptionForRole = `<option value="0" selected="true" disabled="true"
		cssClass="placeholder">
		<liferay-ui:message key="please-select-role-type" />
	</option>`
	$("#roleType").empty();
	$('#roleType').multiselect('destroy');
	$("#roleType").append(defaultOptionForRole).multiselect({enableFiltering: true});
	
	/* for visit  */
	let defaultOptionForVisit = `<option value="0" selected="true" disabled="true"
		cssClass="placeholder">
		<liferay-ui:message key="please-select-visit-type" />
	</option>`
	$("#visitType").empty();
	$('#visitType').multiselect('destroy');
	$("#visitType").append(defaultOptionForVisit).multiselect({enableFiltering: true});
}

function clickProcedureTab(procedureName) {
	if("<%=OmsbSetupProceduresWebPortletKeys.PATIENT_TYPE_NAME%>"== procedureName ) {
		$("#pills-patienttype-tab").click();
	}
	if("<%=OmsbSetupProceduresWebPortletKeys.VISIT_TYPE_NAME%>"== procedureName) {
		$("#pills-visittype-tab").click();
	}
	if("<%=OmsbSetupProceduresWebPortletKeys.PROCEDURES%>"== procedureName) {	
		$("#configureprocedures-tab").click();
	}
	resetProgramDurationDD();
}

function resetProgramDurationDD() {
    let defaultOptionForProgDuration = `<aui:option selected="true" disabled="true"
        cssClass="placeholder">
        <liferay-ui:message key="please-select-program-duration" />
    </aui:option>`
    $("#<portlet:namespace/>programDurationForPatient").empty().select2();
    $("#<portlet:namespace/>programDurationForPatient").append(defaultOptionForProgDuration);
    $("#<portlet:namespace/>programDurationForRole").empty().select2();
    $("#<portlet:namespace/>programDurationForRole").append(defaultOptionForProgDuration);
    $("#<portlet:namespace/>programDurationForVisit").empty().select2();
    $("#<portlet:namespace/>programDurationForVisit").append(defaultOptionForProgDuration);
    $("#<portlet:namespace/>programDurationForConfig").empty().select2();
    $("#<portlet:namespace/>programDurationForConfig").append(defaultOptionForProgDuration);
    
    $("#<portlet:namespace/>selectProgramForRole").val("").select2();
    $("#<portlet:namespace/>selectProgramForPatient").val("").select2();
    $("#<portlet:namespace/>selectProgramForVisit").val("").select2();
    $("#<portlet:namespace/>selectProgramForConfig").val("").select2();
}

$(document).ready(function() {
	$(".loader-container").addClass("d-none").removeClass("d-flex");
	$(".js-basic-single").select2();
})

</script>