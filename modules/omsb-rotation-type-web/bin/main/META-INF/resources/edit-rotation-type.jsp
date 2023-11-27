<%@ include file="init.jsp" %>

<portlet:renderURL var="addRotationTypePageURL">
    <portlet:param name="mvcPath" value="<%=OmsbRotationTypeWebPortletKeys.ADD_ROTATION_TYPE_JSP %>" />
</portlet:renderURL>

<portlet:actionURL name="<%= OmsbRotationTypeWebPortletKeys.SAVE_ROTATION_TYPE_MVC_ACTION_COMMAND %>" var="saveRotationType" >
	<portlet:param name="redirect" value="${addRotationTypePageURL}"/>
</portlet:actionURL>

<div class="row">
	<div class="col-md-12">
		<div class="omsb-card">
			<h4 class="omsb-card-title"><liferay-ui:message key="edit-rotation-type" /></h4>
			<aui:form action="${saveRotationType}" name="fm">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div class="form-group">
							<aui:input label="rotation-type-name" type="text" name="rotationTypeName" localized="true" value="${rotationType.rotationTypeName}" placeholder="enter-rotation-type-name">
								<aui:validator name="required" />
								<aui:validator name="maxLength">200</aui:validator>
							</aui:input>
						</div>
					</div>
				</div>
				<div class="bottom-backbtn-wrap m-0">
					<aui:input label="rotation-type-master-id" name="rotationTypeMasterId" type="hidden" value="${rotationType.rotationTypeMasterId}" class="form-control"  />
					<button class="btn omsb-bc-red-button" type="submit" title="Update" ><liferay-ui:message key="update" /></button>
					<a class="btn omsb-btn omsb-bg-red-button" href="${addRotationTypePageURL}" title="Cancel"><liferay-ui:message key="cancel" /></a>
				</div>
			</aui:form>
		</div>
	</div>
</div>

<div class="row">
	<jsp:include page="/rotation-type-list.jsp" />
</div>