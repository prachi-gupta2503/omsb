<%@ include file="/init.jsp"%>


<!-- Modal -->
<div class="modal fade" id="acceptConfirmationModel" role="dialog">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">
					<liferay-ui:message key="confirm-request" />
				</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<aui:form action="${reviewSharedRotations}" name="passfm"
				method="post">
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12 accept-model-data">
							<aui:input id="sharedRotationRequestId"
								name="sharedRotationRequestId" value="" type="hidden" />
							<aui:input id="status" name="status" value="" type="hidden" />
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-12 label-box">
									<aui:input label="no-of-trainees-requested" type="text" name="requestedTrainees"
										value="" readonly="true" />
								</div>
								<div class="col-lg-6 col-md-6 col-sm-12 label-box">
									<aui:input label="no-of-trainee-allowed" type="number" min="1" max="" name="allowedTrainees">
										<aui:validator name="required" />
										<aui:validator name="number" />
									</aui:input>
								</div>
								<div class="col-md-12">
									<aui:input label="comment" name="comment" type="textarea" >
										<aui:validator name="required" />
									</aui:input>
								</div>
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

