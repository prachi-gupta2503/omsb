<%@ include file="init.jsp"%>

<portlet:renderURL var="renderProcedureURL">
    <portlet:param name="mvcPath" value="<%=OmsbProcedureGroupsConstants.ADD_JSP_PAGE %>" />
</portlet:renderURL>

<portlet:actionURL name="<%=OmsbProcedureGroupsConstants.SAVE_PROCEDURE_GROUPS_COMMAND_NAME%>" var="editProcedureGroupsURL">
	<portlet:param name="mvcPath" value="${OmsbProcedureGroupsConstants.ADD_JSP_PAGE }"/>
</portlet:actionURL>

<div class="row">
	<div class="col-md-12">
		<div class="omsb-card">
			<h4 class="omsb-card-title"><liferay-ui:message key="procedure-groups" /></h4>
			<aui:form action="${editProcedureGroupsURL}" method="post">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div class="form-group">
							<aui:input label="procedure-group-name" type="text" name="procedureGroupName" value="${procedureGroup.procedureGroupName}" localized="true" placeholder="enter-procedure-group-name">
								<aui:validator name="required" />
							</aui:input>
						</div>
					</div>
				</div>
				<div class="bottom-backbtn-wrap m-0">
					<aui:input label="procedure-group-master-id" name="procedureGroupMasterId" type="hidden" value="${procedureGroup.procedureGroupMasterId}" class="form-control"  />
					<button class="btn omsb-bc-red-button" type="submit" title="Update" ><liferay-ui:message key="update" /></button>
					<a class="btn omsb-btn omsb-bg-red-button" href="${renderProcedureURL}" title="Cancel"><liferay-ui:message key="cancel" /></a>
				</div>
			</aui:form>
		</div>
	</div>
</div>

<div>
	<jsp:include page="/view.jsp" />
</div>