<div class="modal fade omsb-modal" id="previewCertificateModal" tabindex="-1" role="dialog"
	aria-labelledby="previewCertificateModalTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<aui:form name="sccFM" action="${saveCommitteeCommentsURL}" method="post" enctype="multipart/form-data">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="previewCertificateModalTitle"><liferay-ui:message key="equivalency-certificate" /></h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="row">
                    	<div class="col-md-12 preview-cert">
                           
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn omsb-bc-red-button cmtSubmit" type="button" title="save-comments" >
                        <liferay-ui:message key="save" />
                    </button>
                    <button type="button" class="btn omsb-btn omsb-bg-red-button"
                        data-dismiss="modal">
                        <liferay-ui:message key="cancel" />
                    </button>
                </div>
            </div>
        </aui:form>
	</div>
</div>