<%@ include file="init.jsp"%>

<portlet:actionURL name="<%= OmsbProgramTypeConstants.UPDATE_PROGRAM_TYPE_MVC_COMMAND_NAME %>" var="updateProgramTypeActionURL">
	<portlet:param name="redirect" value="${addProgramPageURL}"/>
</portlet:actionURL>

<portlet:renderURL var="addProgramPageURL">
    <portlet:param name="mvcPath" value="<%=OmsbProgramTypeConstants.ADD_PROGRAM_TYPE_JSP_NAME %>" />
</portlet:renderURL>


<aui:form action="<%=updateProgramTypeActionURL%>" name="fm" method="POST"/>
 
<%
    String programTypeId = renderRequest.getParameter("programTypeId");
    String programTypeName = renderRequest.getParameter("programTypeName");
%>

<div class="row">
	<div class="col-md-12">
		<div class="omsb-card">
			<h4 class="omsb-card-title"><liferay-ui:message key="program-type" /></h4>
			<aui:form action="${updateProgramTypeActionURL}" method="post">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div class="form-group">
							<aui:input label="program-type-id" type="hidden" name="programTypeId"  value="<%=Long.parseLong(programTypeId)%>" />
						</div>
					</div>
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div class="form-group">
							<aui:input label="program-type" type="text" name="programTypeName" localized="true" value="${pt.programTypeName}" placeholder="enter-program-type-name">
								<aui:validator name="required" />
							</aui:input>
						</div>
					</div>
				</div>
				<div class="bottom-backbtn-wrap m-0">
					<button class="btn omsb-bc-red-button" type="submit" title="Save" ><liferay-ui:message key="update" /></button>
					<a class="btn omsb-btn omsb-bg-red-button" href="${addProgramPageURL}" title="Cancel"><liferay-ui:message key="cancel" /></a>
				</div>
			</aui:form>
		</div>
	</div>
</div>

<div>
	<jsp:include page="/view.jsp" />
</div>