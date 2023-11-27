<%@ include file="init.jsp"%>

<portlet:renderURL var="renderTraineeLevelURL">
    <portlet:param name="mvcPath" value="<%=OmsbTraineeLevelConstants.ADD_JSP_PAGE %>" />
</portlet:renderURL>

<portlet:actionURL name="<%=OmsbTraineeLevelConstants.SAVE_TRAINEE_LEVEL_COMMAND_NAME%>" var="editTraineeLevelURL">
	<portlet:param name="redirect" value="${renderTraineeLevelURL}"/>
</portlet:actionURL>

<div class="row">
	<div class="col-md-12">
		<div class="omsb-card">
			<h4 class="omsb-card-title"><liferay-ui:message key="trainee-level" /></h4>
			<aui:form action="${editTraineeLevelURL}" method="post">
				<div class="row">
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div class="form-group">
							<aui:input label="trainee-level-name" name="traineeLevelName" type="text" value="${traineeLevel.traineeLevelName}" placeholder="enter-trainee-level-name" localized="true">
								<aui:validator name="required" />
							</aui:input>
						</div>
					</div>
				</div>
				<div class="bottom-backbtn-wrap m-0">
					<aui:input label="trainee-level-master-id" name="traineeLevelMasterId" type="hidden" value="${traineeLevel.traineeLevelMasterId}" class="form-control"  />
					<button class="btn omsb-bc-red-button" type="submit" title="Save" ><liferay-ui:message key="Update" /></button>
					<a class="btn omsb-btn omsb-bg-red-button" href="${renderTraineeLevelURL}" title="Cancel"><liferay-ui:message key="cancel" /></a>
				</div>
			</aui:form>
		</div>
	</div>
</div>

<div>
	<jsp:include page="/view.jsp" />
</div>