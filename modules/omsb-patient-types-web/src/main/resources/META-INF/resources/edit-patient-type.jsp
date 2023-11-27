<%@ include file="/init.jsp" %>

<portlet:renderURL var="addPatientTypePageURL">
    <portlet:param name="mvcPath" value="<%=OmsbPatientTypesWebPortletKeys.ADD_PATIENT_TYPE_JSP %>" />
</portlet:renderURL>

<portlet:actionURL name="<%= OmsbPatientTypesWebPortletKeys.SAVE_PATIENT_TYPE_MVC_ACTION_COMMAND %>" var="savePatientType" >
	<portlet:param name="redirect" value="${addPatientTypePageURL}"/>
</portlet:actionURL>

<div class="row">
	<div class="col-md-12">
		<div class="omsb-card">
			<h4 class="omsb-card-title"><liferay-ui:message key="edit-patient-type" /></h4>
			<aui:form action="${savePatientType}" name="fm">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div class="form-group">
							<aui:input label="patient-type-name" type="text" name="patientTypeName" localized="true" value="${patientType.patientTypeName}" placeholder="enter-patient-type-name">
								<aui:validator name="required" />
								<aui:validator name="maxLength">200</aui:validator>
							</aui:input>
						</div>
					</div>
				</div>
				<div class="bottom-backbtn-wrap m-0">
					<aui:input label="patient-type-master-id" name="patientTypeMasterId" type="hidden" value="${patientType.patientTypeMasterId}" class="form-control"  />
					<button class="btn omsb-bc-red-button" type="submit" title="Update" ><liferay-ui:message key="update" /></button>
					<a class="btn omsb-btn omsb-bg-red-button" href="${addPatientTypePageURL}" title="Cancel"><liferay-ui:message key="cancel" /></a>
				</div>
			</aui:form>
		</div>
	</div>
</div>

<div class="row">
	<jsp:include page="/patient-type-list.jsp" />
</div>