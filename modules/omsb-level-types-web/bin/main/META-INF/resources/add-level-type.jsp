<%@ include file="/init.jsp" %>

<portlet:actionURL name="<%= OmsbLevelTypesWebPortletKeys.SAVE_LEVEL_TYPE_MVC_ACTION_COMMAND %>" var="saveLevelType" >
	<portlet:param name="redirect" value="${currentURL}"/>
</portlet:actionURL>

<liferay-ui:error key="levelTypeNameError" message="level-type-name-error" />

<div class="row">
	<div class="col-md-12">
		<div class="omsb-card">
			<h4 class="omsb-card-title"><liferay-ui:message key="add-level-type" /></h4>
			<aui:form action="${saveLevelType}" name="fm">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div class="form-group">
							<aui:input label="level-type-name" type="text" name="levelTypeName" localized="true" placeholder="enter-level-type-name" ignoreRequestValue="true">
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
	<jsp:include page="/level-type-list.jsp" />
</div>