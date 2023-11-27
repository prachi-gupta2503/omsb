<div class="modal fade omsb-modal" id="delete-confirm" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered w-50" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="delete-confirmation" /></h5>
					<button type="button" class="close no-delete" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form name="uploadresultpopupform" id="uploadresultpopupform" method="post" ></form>
					<div class="omsb-card omsb-card-graybg row">
						<div>
							<liferay-ui:message key="do-you-want-to-delete-this-record"/>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn omsb-bc-red-button delete-final" type="button"  title="ok" ><liferay-ui:message key="yes" /></button>
					<button type="button" class="btn omsb-btn omsb-bg-red-button no-delete"
						id="uploadcancel"><liferay-ui:message key="no" /></button>
				</div>
			</div>
		</div>
	</div>
	
<script>
	$('.no-delete').on('click', function(){
		$('#delete-confirm').modal('hide');	
	});
	
	$('.delete-final').on('click', function(){
		console.log('calling delete-final function');
		const row = $(this).attr('row-data');
		const tableId = $(this).attr('row-table-id');
		const finalFileId = $(this).attr('row-final-file-id');
		console.log('calling delete-final row is ?', row);
		console.log('calling delete-final tableId is ?', tableId);
		var input = document.getElementById(finalFileId);
		console.log('calling delete-final input file is ?', input);
		deleteMultiFile(input, tableId, row);
	});
	
</script>
