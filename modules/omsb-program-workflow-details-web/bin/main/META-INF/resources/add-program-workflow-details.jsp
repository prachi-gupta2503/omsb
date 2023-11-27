<%@ include file="init.jsp" %>

<portlet:actionURL name="<%= OmsbProgramWorkflowDetailsConstant.ADD_PROGRAM_WORKFLOW_DETAILS_MVC_COMMAND_NAME %>" var="addProgramWorkflowURL" >
	<portlet:param name="redirect" value="${currentURL}"/>
</portlet:actionURL>

<liferay-ui:success key="workflow-details-added-success" message="workflow-details-added-successfully" />

<div class="row">
	<div class="col-md-12">
		<div class="omsb-card">
			<h4 class="omsb-card-title"><liferay-ui:message key="program-workflow-rel-heading" /></h4>
			<aui:form action="${addProgramWorkflowURL}" name="fm">
				<div class="row">
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<aui:select cssClass="custom-select form-control js-basic-single" label="program-name" id="programName" name="programName">
	                        	<aui:option value="" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-program-name" /></aui:option>
	                        	<c:forEach items="${programMasters}" var="programMaster">
									<aui:option value="${programMaster.programMasterId}">
										${programMaster.getProgramName(locale)}
									</aui:option>
								</c:forEach>
								<aui:validator name="required"></aui:validator>
							</aui:select>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<aui:select cssClass="custom-select form-control" label="approval-order" id="approvalOrder" name="approvalOrder">
	                        	<aui:option value="" selected="true" disabled= "true" cssClass="placeholder" ><liferay-ui:message key="please-select-approval-order" /></aui:option>
	                        	<aui:option value="CR-RS-PD"><liferay-ui:message key="Chief Resident->Rotation Supervisor->Program Director" /></aui:option>
	                        	<aui:option value="RS-CR-PD"><liferay-ui:message key="Rotation Supervisor->Chief Resident->Program Director" /></aui:option>
								<aui:validator name="required"></aui:validator>
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
	<jsp:include page="/view.jsp" />
</div>