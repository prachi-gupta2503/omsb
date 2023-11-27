<%@ include file="/init.jsp" %>

<portlet:actionURL name="<%= OmsbRoleTypesWebPortletKeys.SAVE_ROLE_TYPE_MVC_ACTION_COMMAND %>" var="saveRoleType" >
	<portlet:param name="redirect" value="${addRoleTypePageURL}"/>
</portlet:actionURL>

<portlet:renderURL var="addRoleTypePageURL">
    <portlet:param name="mvcPath" value="<%=OmsbRoleTypesWebPortletKeys.ADD_ROLE_TYPE_JSP %>" />
</portlet:renderURL>

<div class="row">
	<div class="col-md-12">
		<div class="omsb-card">
			<h4 class="omsb-card-title"><liferay-ui:message key="edit-role-type" /></h4>
			<aui:form action="${saveRoleType}" name="fm">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div class="form-group">
							<aui:input label="role-type-name" type="text" name="roleTypeName" localized="true" value="${roleType.roleTypeName}" placeholder="enter-role-type-name">
								<aui:validator name="required" />
								<aui:validator name="maxLength">200</aui:validator>
							</aui:input>
						</div>
					</div>
				</div>
				<div class="bottom-backbtn-wrap m-0">
					<aui:input label="role-type-master-id" name="roleTypeMasterId" type="hidden" value="${roleType.roleTypeMasterId}" class="form-control"  />
					<button class="btn omsb-bc-red-button" type="submit" title="Update" ><liferay-ui:message key="update" /></button>
					<a class="btn omsb-btn omsb-bg-red-button" href="${addRoleTypePageURL}" title="Cancel"><liferay-ui:message key="cancel" /></a>
				</div>
			</aui:form>
		</div>
	</div>
</div>

<div class="row">
	<jsp:include page="/role-type-list.jsp" />
</div>