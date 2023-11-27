<%@ include file="init.jsp" %>

<!-- Modal -->
<div class="modal fade omsb-masterrotation-modal" id="confirmationModal" role="dialog">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="confirmation" /></h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12">
							<div>
								<p class="confirmation-title"></p>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn omsb-btn omsb-bc-red-button confirmation-modal-confirm" type="button" data-dismiss="modal" title="Confirm"><liferay-ui:message key="confirm" /></button>
					<button type="button" class="btn omsb-btn omsb-bg-red-button"
						data-dismiss="modal"><liferay-ui:message key="cancel" /></button>
				</div>
		</div>
	</div>
</div>

<div class="modal fade omsb-masterrotation-modal" id="confirmationFacultyModal" role="dialog">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="confirmation" /></h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12">
							<div>
								<p class="confirmation-faculty-title"></p>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn omsb-btn omsb-bc-red-button confirmation-modal-faculty-confirm" type="button" data-dismiss="modal" title="Confirm"><liferay-ui:message key="confirm" /></button>
					<button type="button" class="btn omsb-btn omsb-bg-red-button"
						data-dismiss="modal"><liferay-ui:message key="cancel" /></button>
				</div>
		</div>
	</div>
</div>
											
