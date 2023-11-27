<%@ include file="init.jsp"%>

<portlet:renderURL var="viewProceduresURL">
	<portlet:param name="mvcPath" value="<%= OmsbProceduresConstants.ADD_PROCEDURE_MASTER_JSP_NAME %>" />
</portlet:renderURL>

<portlet:actionURL name="<%= OmsbProceduresConstants.UPDATE_PROCEDURE_MASTER_MVC_COMMAND_NAME %>" var="updateProcedureURL" >
	<portlet:param name="redirect" value="${currentURL}"/>
</portlet:actionURL>

<%
	String procedureId = renderRequest.getParameter(OmsbProceduresConstants.PROCEDURE_ID);
	ProcedureMaster procedureMaster = ProcedureMasterLocalServiceUtil.getProcedureMaster(Long.valueOf(procedureId));
%>

<div class="row">
	<div class="col-md-12">
		<div class="omsb-card">
			<h4 class="omsb-card-title"><liferay-ui:message key="procedure-details" /></h4>
			<aui:form action="<%= updateProcedureURL.toString() %>" name="fm">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div class="form-group">
							<aui:input label="procedure-id" type="hidden" name="procedureMasterId"  value="<%=Long.parseLong(procedureId)%>" />
						</div>
					</div>
                    <div class="col-lg-12 col-md-12 col-sm-12">
						<div class="form-group">
							<aui:input cssClass="form-control" label="procedure-name" type="text" name="procedureName" localized="true" 
								value="<%= procedureMaster.getProcedureName() %>" placeholder="enter-procedure-name">
								<aui:validator name="required" />
								<aui:validator name="maxLength">500</aui:validator>
							</aui:input>
						</div>
					</div>
                </div>
				<div class="bottom-backbtn-wrap m-0">
					<button class="btn omsb-bc-red-button" type="submit" title="Save" ><liferay-ui:message key="update" /></button>
					<a class="btn omsb-btn omsb-bg-red-button" href="${viewProceduresURL}" title="Cancel"><liferay-ui:message key="cancel" /></a>
				</div>
			</aui:form>
		</div>
	</div>
</div>

<div>
	<jsp:include page="<%= OmsbProceduresConstants.VIEW_PROCEDURE_MASTERS_JSP_NAME %>" />
</div>