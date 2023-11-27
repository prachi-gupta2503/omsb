<%@ include file="/init.jsp"%>

<portlet:actionURL
	name="<%=OmsbApproveSharedRotationWebPortletKeys.RIVIEW_SHARED_ROTATIONS_MVC_ATION_COMMAND%>"
	var="reviewSharedRotations" />

<!-- Modal -->
<div class="modal fade" id="rejectConfirmationModel" role="dialog">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">
					<liferay-ui:message key="confirm-rejection" />
				</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<aui:form action="${reviewSharedRotations}" name="rejfm"
				method="post">
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12 reject-model-data">
							<aui:input id="sharedRotationRequestId"
								name="sharedRotationRequestId" value="" type="hidden" />
							<aui:input id="status" name="status" value="" type="hidden" />
							<div>
								<aui:input label="rejection-reason-comment" name="comment"
									type="textarea">
									<aui:validator name="required" />
								</aui:input>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn omsb-btn omsb-bc-red-button" type="submit"
						title="Confirm">
						<liferay-ui:message key="confirm" />
					</button>
					<button type="button" class="btn omsb-btn omsb-bg-red-button"
						data-dismiss="modal"><liferay-ui:message key="cancel" /></button>
				</div>
			</aui:form>
		</div>
	</div>
</div>

