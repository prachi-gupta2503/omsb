<%@ include file="/init.jsp" %>

<portlet:renderURL var="addLevelTypePageURL">
    <portlet:param name="mvcPath" value="<%=OmsbLevelTypesWebPortletKeys.ADD_LEVEL_TYPE_JSP %>" />
</portlet:renderURL>

<portlet:actionURL name="<%= OmsbLevelTypesWebPortletKeys.SAVE_LEVEL_TYPE_MVC_ACTION_COMMAND %>" var="saveLevelType" >
	<portlet:param name="redirect" value="${addLevelTypePageURL}"/>
</portlet:actionURL>

<liferay-ui:error key="levelTypeNameError" message="level-type-name-error" />

<div class="row">
	<div class="col-md-12">
		<div class="omsb-card">
			<h4 class="omsb-card-title"><liferay-ui:message key="edit-level-type" /></h4>
			<aui:form action="${saveLevelType}" name="fm">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div class="form-group">
							<aui:input label="level-type-name" type="text" name="levelTypeName" localized="true" value="${levelType.levelTypeName}" placeholder="enter-level-type-name">
								<aui:validator name="required" />
								<aui:validator name="maxLength">75</aui:validator>
							</aui:input>
						</div>
					</div>
				</div>
				<div class="bottom-backbtn-wrap m-0">
					<aui:input label="level-type-master-id" name="levelTypeMasterId" type="hidden" value="${levelType.levelTypeMasterId}" class="form-control"  />
					<button class="btn omsb-bc-red-button" type="submit" title="Update" ><liferay-ui:message key="update" /></button>
					<a class="btn omsb-btn omsb-bg-red-button" href="${addLevelTypePageURL}" title="Cancel"><liferay-ui:message key="cancel" /></a>
				</div>
			</aui:form>
		</div>
	</div>
</div>

<div class="row">
	<jsp:include page="/level-type-list.jsp" />
</div>