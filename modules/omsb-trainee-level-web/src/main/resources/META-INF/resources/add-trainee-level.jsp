<%@ include file="init.jsp" %>

<portlet:actionURL name="<%=OmsbTraineeLevelConstants.SAVE_TRAINEE_LEVEL_COMMAND_NAME%>" var="addTraineeLevelURL" >
	<portlet:param name="redirect" value="${currentURL}"/>
</portlet:actionURL>

<div class="row">
	<div class="col-md-12">
		<div class="omsb-card">
			<h4 class="omsb-card-title"><liferay-ui:message key="trainee-level" /></h4>
			<aui:form action="${addTraineeLevelURL}" name="fm">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div class="form-group">
							<aui:input label="trainee-level-name" type="text" name="traineeLevelName" localized="true" placeholder="enter-trainee-level-name" ignoreRequestValue="true">
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