<%@ include file="init.jsp" %>

<!-- Modal -->
<div class="modal fade omsb-masterrotation-modal" id="saveAsDraftSuccessModal" role="dialog">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="success" /></h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-md-12">
						<div>
							<p><liferay-ui:message key="master-rotation-scheduled-as-draft-successfully" /></p>
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

<div class="modal fade omsb-masterrotation-modal" id="submitRotationSuccessModal" role="dialog">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="success" /></h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-md-12">
						<div>
							<p><liferay-ui:message key="master-rotation-scheduled-successfully" /></p>
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


<div class="modal fade omsb-masterrotation-modal" id="dataExistModal" role="dialog">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="Error" /></h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-md-12">
						<div>
							<p><liferay-ui:message key="master-rotation-data-exist" /></p>
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

<div class="modal fade omsb-masterrotation-modal" id="deleteLeaveSucessModal" role="dialog">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="success" /></h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-md-12">
						<div>
							<p><liferay-ui:message key="leave-deleted-sucessfully" /></p>
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

<div class="modal fade omsb-masterrotation-modal" id="saveLeaveSucessModal" role="dialog">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="success" /></h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-md-12">
						<div>
							<p><liferay-ui:message key="leave-saved-sucessfully" /></p>
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


<div class="modal fade omsb-masterrotation-modal" id="confirmationModalForElective" role="dialog">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="confirmation" /></h5>
			</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12">
							<div>
								<p class="confirmation-elective-title"><liferay-ui:message key="is-elective-rotation" /></p>
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