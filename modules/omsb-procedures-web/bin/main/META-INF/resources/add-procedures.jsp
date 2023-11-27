<%@ include file="init.jsp"%>

<portlet:renderURL var="viewProceduresURL">
	<portlet:param name="jspPage" value="<%= OmsbProceduresConstants.VIEW_PROCEDURE_MASTERS_JSP_NAME %>" />
</portlet:renderURL>

<portlet:actionURL name="<%= OmsbProceduresConstants.ADD_PROCEDURE_MASTER_MVC_COMMAND_NAME %>" var="addProcedureURL" >
	<portlet:param name="redirect" value="${currentURL}"/>
</portlet:actionURL>

<div class="row">
	<div class="col-md-12">
		<div class="omsb-card">
			<h4 class="omsb-card-title"><liferay-ui:message key="procedure-details" /></h4>
			<aui:form action="${addProcedureURL}" name="fm">
				<div class="row">
                    <div class="col-lg-12 col-md-12 col-sm-12">
						<div class="form-group">
							<aui:input cssClass="form-control" label="procedure-name" type="text" name="procedureName" localized="true" placeholder="enter-procedure-name" ignoreRequestValue="true">
								<aui:validator name="required" />
								<aui:validator name="maxLength">500</aui:validator>
							</aui:input>
						</div>
					</div>
                </div>
				<div class="bottom-backbtn-wrap m-0">
					<button class="btn omsb-bc-red-button" type="submit" title="Save" ><liferay-ui:message key="save" /></button>
					<button class="btn omsb-bc-red-button" type="reset" title="Cancel" ><liferay-ui:message key="cancel" /></button>
					<%-- <aui:button type="button" class="" id="cancelBtn" value="Cancel" cssClass="btn omsb-bc-red-button"
						onClick="<%= viewProceduresURL.toString() %>"></aui:button> --%>
				</div>
			</aui:form>
		</div>
	</div>
</div>

<div>
	<jsp:include page="<%= OmsbProceduresConstants.VIEW_PROCEDURE_MASTERS_JSP_NAME %>" />
</div>