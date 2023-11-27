<%@page import="gov.omsb.trainee.elective.rotations.web.constants.OmsbTraineeElectiveRotationsWebPortletKeys"%>
<%@ include file="init.jsp" %>

<portlet:actionURL name="<%= OmsbTraineeElectiveRotationsWebPortletKeys.DELETE_TRAINEE_ELECTIVE_ROTATIONS_MVC_ACTION_COMMAND%>" var="deleteTraineeElectiveRotationsType"/>

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
			<aui:form action="${deleteTraineeElectiveRotationsType}" name="deleteTraineeElectiveRotationsTypefm">
				<div class="modal-body">
					<div class="row">
							<div class="col-md-12">
								<aui:input id="traineePdTlErDetailsId" name="traineePdTlErDetailsId" value="" type="hidden" /> 
								<div>
									<p><liferay-ui:message key="are-you-sure-you-want-to-delete?" /></p>
								</div>
							</div>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn omsb-btn omsb-bc-red-button" type="submit" title="Confirm"><liferay-ui:message key="confirm" /></button>
					<button type="button" class="btn omsb-btn omsb-bg-red-button"
						data-dismiss="modal"><liferay-ui:message key="cancel" /></button>
				</div>
			</aui:form>
		</div>
	</div>
</div>
											
