<%@ include file="init.jsp" %>

<!-- Modal -->
<div class="modal fade omsb-masterrotation-modal" id="alertPopup" role="dialog">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title popup-alert-title" id="exampleModalLongTitle"></h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-md-12">
						<div>
							<p class="popup-alert-message"></p>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn omsb-btn omsb-bg-red-button popup-alert-button"
					data-dismiss="modal"></button>
			</div>
		</div>
	</div>
</div>


<div class="modal fade omsb-masterrotation-modal" id="alertPopupForLeave" role="dialog">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title popup-alert-title-leave" id="exampleModalLongTitle"></h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-md-12">
						<div>
							<p class="popup-alert-message-leave"><liferay-ui:message key="${leaveKey}" /></p>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn omsb-btn omsb-bg-red-button popup-alert-button-leave"
					data-dismiss="modal"></button>
			</div>
		</div>
	</div>
</div>
