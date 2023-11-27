<%@ include file="/init.jsp" %>

<portlet:actionURL name="<%= OmsbVisitTypesWebPortletKeys.SAVE_VISIT_TYPE_MVC_ACTION_COMMAND %>" var="saveVisitType" >
	<portlet:param name="redirect" value="${currentURL}"/>
</portlet:actionURL>

<div class="row">
	<div class="col-md-12">
		<div class="omsb-card">
			<h4 class="omsb-card-title"><liferay-ui:message key="add-visit-type" /></h4>
			<aui:form action="${saveVisitType}" name="fm">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div class="form-group">
							<aui:input label="visit-type-name" type="text" name="visitTypeName" localized="true" placeholder="enter-visit-type-name" ignoreRequestValue="true">
								<aui:validator name="required" />
								<aui:validator name="maxLength">75</aui:validator>
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
	<jsp:include page="/visit-type-list.jsp" />
</div>