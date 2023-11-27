<%@page import="gov.omsb.role.types.web.constants.OmsbRoleTypesWebPortletKeys"%>
<%@ include file="/init.jsp" %>

<portlet:actionURL name="<%= OmsbRoleTypesWebPortletKeys.SAVE_ROLE_TYPE_MVC_ACTION_COMMAND %>" var="saveRoleType" >
	<portlet:param name="redirect" value="${currentURL}"/>
</portlet:actionURL>

<div class="row">
	<div class="col-md-12">
		<div class="omsb-card">
			<h4 class="omsb-card-title"><liferay-ui:message key="add-role-type" /></h4>
			<aui:form action="${saveRoleType}" name="fm">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div class="form-group">
							<aui:input label="role-type-name" type="text" name="roleTypeName" localized="true" ignoreRequestValue="true" placeholder="enter-role-type-name">
								<aui:validator name="required" />
								<aui:validator name="maxLength">200</aui:validator>
							</aui:input>
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

<div class="row">
	<jsp:include page="/role-type-list.jsp" />
</div>