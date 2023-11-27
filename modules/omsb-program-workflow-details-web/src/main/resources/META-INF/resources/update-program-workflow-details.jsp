<%@ include file="init.jsp"%>

<portlet:actionURL name="<%= OmsbProgramWorkflowDetailsConstant.UPDATE_PROGRAM_WORKFLOW_DETAILS_MVC_COMMAND_NAME %>" var="updateProgramWorkflowDetailsActionURL">
	<portlet:param name="redirect" value="${addProgramWorkflowPageURL}"/>
</portlet:actionURL>

<portlet:renderURL var="addProgramWorkflowPageURL">
    <portlet:param name="mvcPath" value="<%=OmsbProgramWorkflowDetailsConstant.ADD_PROGRAM_WORKFLOW_DETAILS_JSP_PAGE %>" />
</portlet:renderURL>
 
<liferay-ui:success key="workflow-details-updated-success" message="workflow-details-updated-successfully" />
<%
    String programId = renderRequest.getParameter("programId");
    String approvalOrder = renderRequest.getParameter("approvalOrder");
    String programWorkflowDetailsRelId = renderRequest.getParameter("programWorkflowDetailsRelId");
    
    ProgramMaster programMaster = ProgramMasterLocalServiceUtil.getProgramMaster(Long.valueOf(programId));
%>

<div class="row">
	<div class="col-md-12">
		<div class="omsb-card">
			<h4 class="omsb-card-title"><liferay-ui:message key="program-type" /></h4>
			<aui:form action="${updateProgramWorkflowDetailsActionURL}" method="post">
				<div class="row">
					<div class="col-lg-6 col-md-6 col-sm-12">
						<aui:input cssClass="form-control" type="hidden" id="programWorkflowDetailsRelId" name="programWorkflowDetailsRelId"
							value="<%=programWorkflowDetailsRelId %>"/>
						<aui:input cssClass="form-control" type="text" label="program-name" id="programName" name="programName"
							value="<%=programMaster.getProgramName(locale) %>" readOnly="true"/>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<aui:select cssClass="custom-select form-control js-basic-single" label="approval-order" id="approvalOrder" name="approvalOrder" value="<%= approvalOrder %>">
                        	<aui:option value="" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-approval-order" /></aui:option>
                        	<aui:option value="CR-RS-PD"><liferay-ui:message key="Chief Resident->Rotation Supervisor->Program Director" /></aui:option>
                        	<aui:option value="RS-CR-PD"><liferay-ui:message key="Rotation Supervisor->Chief Resident->Program Director" /></aui:option>
						</aui:select>
					</div>
				</div>
				<div class="bottom-backbtn-wrap m-0">
					<button class="btn omsb-bc-red-button" type="submit" title="Save" ><liferay-ui:message key="update" /></button>
					<a class="btn omsb-btn omsb-bg-red-button" href="${addProgramWorkflowPageURL}" title="Cancel"><liferay-ui:message key="cancel" /></a>
				</div>
			</aui:form>
		</div>
	</div>
</div>

<div>
	<jsp:include page="/view.jsp" />
</div>