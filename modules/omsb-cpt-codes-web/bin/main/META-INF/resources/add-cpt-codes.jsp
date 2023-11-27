<%@ include file="init.jsp" %>

<portlet:actionURL name="<%= OmsbCptCodesConstants.SAVE_CPT_CODES_COMMAND_NAME %>" var="addCptCodesURL" >
	<portlet:param name="redirect" value="${currentURL}"/>
</portlet:actionURL>

<div class="row">
	<div class="col-md-12">
		<div class="omsb-card">
			<h4 class="omsb-card-title"><liferay-ui:message key="add-cpt-codes" /></h4>
			<aui:form action="${addCptCodesURL}" name="fm">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div class="form-group">
							<aui:input label="cpt-code" type="text" name="cptCodeName" localized="true" placeholder="enter-cpt-code-name" ignoreRequestValue="true">
								<aui:validator name="required" />
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

<div>
	<jsp:include page="/view.jsp" />
</div>