<%@page import="gov.omsb.notify.sau.web.constants.OmsbNotifySauWebPortletKeys"%>
<%@ include file="init.jsp"%>

<div class="modal fade omsb-modal" id="notifyauthorizeduser" tabindex="-1" role="dialog"
        aria-labelledby="notifyauthorizeduserTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
	    <div class="modal-content">
	    <aui:form action="${notifySauUserAction}" method="post" name="refm">
	        <div class="modal-header">
	            <h5 class="modal-title" id="exampleModalLongTitle">Notify Site Authorised User</h5>
	            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	                <span aria-hidden="true">&times;</span>
	            </button>
	        </div>
	        <div class="modal-body">
	            <div class="row">
	            	<aui:input id="trainingSiteId" name="trainingSiteId" type="hidden"/>
					<aui:input id="currentUser" name="currentUser" type="hidden" />
	                <ul class="omsb-notification-lists" id="userList">
					</ul>
	              </div>
				<div class="row pt-3">
		            <div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
							<aui:input label="current-capacity" disabled="true" id="currentCapacity" name="currentCapacity" />
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
				<button class="btn omsb-bc-red-button notify-sau-button" type="Submit" title="Notify selected" disabled="true">Notify selected</button>
				<button type="button" class="btn omsb-btn omsb-bg-red-button cancel-notify-sau-button" data-dismiss="modal">Cancel</button>
		    </div>
		   </aui:form>
    	</div>
    </div>
</div>
