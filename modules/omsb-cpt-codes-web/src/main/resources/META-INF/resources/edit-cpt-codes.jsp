<%@ include file="init.jsp"%>

<portlet:renderURL var="renderCptCodeURL">
    <portlet:param name="mvcPath" value="<%=OmsbCptCodesConstants.ADD_JSP_PAGE %>" />
</portlet:renderURL>
<portlet:actionURL name="<%=OmsbCptCodesConstants.SAVE_CPT_CODES_COMMAND_NAME%>" var="editCptCodesURL">
	<portlet:param name="mvcPath" value="${OmsbCptCodesConstants.ADD_JSP_PAGE }"/>
</portlet:actionURL>

<%
    String cptCodeMasterId = renderRequest.getParameter("cptCodeMasterId");
    String cptCodeName = renderRequest.getParameter("cptCodeName");
%>
<div class="row">
	<div class="col-md-12">
		<div class="omsb-card">
			<h4 class="omsb-card-title"><liferay-ui:message key="edit-cpt-codes" /></h4>
			<aui:form action="${editCptCodesURL}" method="post">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div class="form-group">
							<aui:input label="cpt-code" type="text" name="cptCodeName" value="${cptCode.cptCodeName}" localized="true" placeholder="enter-cpt-code-name">
								<aui:validator name="required" />
							</aui:input>
						</div>
					</div>
				</div>
				<div class="bottom-backbtn-wrap m-0">
					<aui:input label="cpt-code-master-id" name="cptCodeMasterId" type="hidden" value="<%=Long.parseLong(cptCodeMasterId)%>" class="form-control"  />
					<button class="btn omsb-bc-red-button" type="submit" title="Update" ><liferay-ui:message key="update" /></button>
					<a class="btn omsb-btn omsb-bg-red-button" href="${renderCptCodeURL}" title="Cancel"><liferay-ui:message key="cancel" /></a>
				</div>
			</aui:form>
		</div>
	</div>
</div>

<div>
	<jsp:include page="/view.jsp" />
</div>