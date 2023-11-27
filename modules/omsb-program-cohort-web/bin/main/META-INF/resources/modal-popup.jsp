<%@page import="gov.omsb.program.cohort.web.constants.OmsbProgramCohortWebPortletKeys"%>
<%@ include file="init.jsp" %>

<portlet:actionURL name="<%=OmsbProgramCohortWebPortletKeys.DELETE_PROGRAM_COHORT_MVC_ACTION_COMMAND%>" var="deleteCohortRelationRecord" />

<!-- Modal -->
<div class="modal fade" id="deleteModal" role="dialog">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="confirmation" /></h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<aui:form action="${deleteCohortRelationRecord}" name="deletefm">
				<aui:input type="hidden" name="programId" value="${programId}" />
				<div class="modal-body">
					<div class="row">
							<div class="col-md-12">
								<aui:input id="progdurationTlBlocksLtId" name="progdurationTlBlocksLtId" value="" type="hidden" /> 
								<div>
									<p><liferay-ui:message key="are-you-sure-you-want-to-delete?" /></p>
								</div>
							</div>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn omsb-btn omsb-bc-red-button" type="submit" title="Confirm"><liferay-ui:message key="confirm" /></button>
					<button type="button" class="btn omsb-btn omsb-bg-red-button" data-dismiss="modal"><liferay-ui:message key="cancel" /></button>
				</div>
			</aui:form>
		</div>
	</div>
</div>
											
<div class="modal fade" id="allTraineeTakenLeaveForCurrentYearInformationModel" role="dialog">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="warning" /></h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-md-12">
						<div>
							<p><liferay-ui:message key="error-all-trainee-needs-to-book-annual-leave" /></p>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn omsb-btn omsb-bc-red-button" type="button" title="Confirm" data-dismiss="modal"><liferay-ui:message key="ok" /></button>
			</div>
		</div>
	</div>
</div>