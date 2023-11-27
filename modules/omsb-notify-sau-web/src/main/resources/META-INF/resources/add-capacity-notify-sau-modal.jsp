<%@ include file="init.jsp"%>

<div class="modal fade omsb-modal" id="addCapacityNotifyAuthorizedUser" tabindex="-1" role="dialog"
        aria-labelledby="notifyauthorizeduserTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
	    <div class="modal-content">
	        <div class="modal-header">
	            <h5 class="modal-title" id="exampleModalLongTitle">Notify Site Authorised User</h5>
	            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	                <span aria-hidden="true">&times;</span>
	            </button>
	        </div>
	        <div class="modal-body">
	            <div class="row">
	                <ul class="omsb-notification-lists" id="userListAddToCapacity">
					</ul>
	              </div>
				<div class="row pt-3">
		            <div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<aui:input label="current-capacity" disabled="true" id="currentCapacityModal" name="currentCapacityModal" />
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<aui:input label="requested-capacity"
								class="custom-select form-control" type="number"
								name="requestedCapacity" min="1" step="1" max="">
								<aui:validator name="required" />
							</aui:input>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn omsb-bc-red-button notify-sau-button-create" type="Submit">Notify selected</button>
				<button type="button" class="btn omsb-btn omsb-bg-red-button" data-dismiss="modal">Cancel</button>
		    </div>
    	</div>
    </div>
</div>
