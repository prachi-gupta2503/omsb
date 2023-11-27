<%@ include file="/init.jsp" %>

<portlet:actionURL name="<%= OmsbVisitTypesWebPortletKeys.SAVE_VISIT_TYPE_MVC_ACTION_COMMAND %>" var="saveVisitType" >
	<portlet:param name="redirect" value="${addVisitTypePageURL}"/>
</portlet:actionURL>

<portlet:renderURL var="addVisitTypePageURL">
    <portlet:param name="mvcPath" value="<%=OmsbVisitTypesWebPortletKeys.ADD_VISIT_TYPE_JSP %>" />
</portlet:renderURL>

<div class="row">
	<div class="col-md-12">
		<div class="omsb-card">
			<h4 class="omsb-card-title"><liferay-ui:message key="edit-visit-type" /></h4>
			<aui:form action="${saveVisitType}" name="fm">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div class="form-group">
							<aui:input label="visit-type-name" type="text" name="visitTypeName" localized="true" value="${visitType.visitTypeName}" placeholder="enter-visit-type-name">
								<aui:validator name="required" />
								<aui:validator name="maxLength">75</aui:validator>
							</aui:input>
						</div>
					</div>
				</div>
				<div class="bottom-backbtn-wrap m-0">
					<aui:input label="visit-type-master-id" name="visitTypeMasterId" type="hidden" value="${visitType.visitTypeMasterId}" class="form-control"  />
					<button class="btn omsb-bc-red-button" type="submit" title="Update" ><liferay-ui:message key="update" /></button>
					<a class="btn omsb-btn omsb-bg-red-button" href="${addVisitTypePageURL}" title="Cancel"><liferay-ui:message key="cancel" /></a>		
				</div>
			</aui:form>
		</div>
	</div>
</div>

<div class="row">
	<jsp:include page="/visit-type-list.jsp" />
</div>