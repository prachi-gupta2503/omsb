<%@ include file="init.jsp"%>

<div class="modal fade omsb-modal omsb-masterrotation-modal" id="traineeleavedetails" tabindex="-1" role="dialog" aria-labelledby="traineeleavedetailsTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle"><span class="trainee-detail-title"></span><liferay-ui:message key="leave-details" /></h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					</div>
					<div class="modal-body">
						<div class="blockdetail_table scroll-horizontal">
							<table class="table">
								<thead>
									<tr>
										<th scope="col"><liferay-ui:message key='trainee-name' /></th>
										<th scope="col"><liferay-ui:message key="leave-type" /></th>
										<th scope="col"><liferay-ui:message key="start-date" /></th>
										<th scope="col"><liferay-ui:message key="end-date" /></th>
										<th scope="col"><liferay-ui:message key="action" /></th>
									</tr>
								</thead>
								<tbody>
									
								</tbody>
							</table>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn omsb-btn omsb-bg-red-button"
							data-dismiss="modal"><liferay-ui:message key="cancel" /></button>
					</div>
		</div>
	</div>
</div>
