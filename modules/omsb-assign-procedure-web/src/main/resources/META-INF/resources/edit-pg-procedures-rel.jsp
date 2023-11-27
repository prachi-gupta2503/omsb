<%@ include file="init.jsp"%>

<portlet:actionURL name="<%= OmsbAssignProcedureConstants.EDIT_ASSIGN_PROCEDURE_MVC_COMMAND_NAME %>" var="updateAssignProcedureURL" >
	<portlet:param name="redirect" value="${currentURL}"/>
</portlet:actionURL>

<%
	String assignProcedureId = renderRequest.getParameter(OmsbAssignProcedureConstants.PG_PROCEDURES_CPT_REL_ID);
	ProcedureGroupProceduresCPTCodeRel procedureGroupProceduresCPTCodeRel = ProcedureGroupProceduresCPTCodeRelLocalServiceUtil.getProcedureGroupProceduresCPTCodeRel(Long.valueOf(assignProcedureId));
	long procedureGroupId = procedureGroupProceduresCPTCodeRel.getProcedureGroupId();
	long procedureId = procedureGroupProceduresCPTCodeRel.getProcedureId();
	long cptCodeId = procedureGroupProceduresCPTCodeRel.getCptCodeId();
%>

<div class="row">
	<div class="col-md-12">
		<div class="omsb-card">
			<h4 class="omsb-card-title"><liferay-ui:message key="assign-procedure-details" /></h4>
			<aui:form action="${updateAssignProcedureURL}" name="fm">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div class="form-group">
							<aui:input label="procedure-id" type="hidden" name="pgProceduresCPTCodeRelId"  value="<%=Long.parseLong(assignProcedureId)%>" />
						</div>
					</div>
                    <div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">							
							<aui:select cssClass="custom-select form-control" label="procedure-group-name" id="procedureGroupName" 
								name="procedureGroupName" value="<%= procedureGroupId %>">
                                <aui:option value=""><liferay-ui:message key="default-empty-selected-option" /></aui:option>
                                <c:forEach items="${procedureGroupMasters}" var="procedureGroupMaster">
									<aui:option value="${procedureGroupMaster.procedureGroupMasterId}">
										${procedureGroupMaster.getProcedureGroupName(languageId)}
									</aui:option>
								</c:forEach>
								<aui:validator name="required" />
							</aui:select>
						</div>
					</div>
                    <div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<aui:select cssClass="custom-select form-control" label="procedure-name" id="procedureName" name="procedureName"
								value="<%= procedureId %>" >
                                <aui:option value=""><liferay-ui:message key="default-empty-selected-option" /></aui:option>
                                <c:forEach items="${procedureMasters}" var="procedureMaster">
									<aui:option value="${procedureMaster.procedureMasterId}">
										${procedureMaster.getProcedureName(languageId)}
									</aui:option>
								</c:forEach>
								<aui:validator name="required" />
							</aui:select>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<aui:select cssClass="custom-select form-control" label="cpt-code-name" id="cptCodeName" name="cptCodeName"
								value="<%= cptCodeId %>">
                                <aui:option value=""><liferay-ui:message key="default-empty-selected-option" /></aui:option>
                                <c:forEach items="${cptCodeMasters}" var="cptCodeMaster">
									<aui:option value="${cptCodeMaster.cptCodeMasterId}">
										${cptCodeMaster.getCptCodeName(languageId)}
									</aui:option>
								</c:forEach>
							</aui:select>
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

<div>
	<jsp:include page="<%= OmsbAssignProcedureConstants.VIEW_ASSIGN_PROCEDURES_JSP_NAME %>" />
</div>