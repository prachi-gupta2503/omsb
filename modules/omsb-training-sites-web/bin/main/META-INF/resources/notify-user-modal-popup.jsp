<%@ include file="init.jsp"%>

<div class="modal fade omsb-modal" id="notifyauthorizeduser"
	tabindex="-1" role="dialog" aria-labelledby="notifyauthorizeduserTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="notify-members"/></h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<input type="hidden" id="rotationId" name="rotationId" value="" />
				<div class="row">
					<ul class="omsb-notification-lists" id="userList">
					</ul>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn omsb-bc-red-button" id="notifyAll" type="button" value="" onclick="notifySitesRotations($('#rotationId').val(),this.value)" data-dismiss="modal">
					<liferay-ui:message key="notify-all" />
				</button>
				<button type="button" class="btn omsb-btn omsb-bg-red-button"
					data-dismiss="modal">
					<liferay-ui:message key="cancel" />
				</button>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
function notifySitesRotations(rotationId,userId){
	 $.ajax({
       url: '<%=notifySiteRotationMVCResourceURL%>',
			type : 'POST',
			data : {
				<portlet:namespace/>rotationId : rotationId,
				<portlet:namespace/>userId : userId
			},
			success : function(programMasterData) {
				
			}
		});
	}
</script>
