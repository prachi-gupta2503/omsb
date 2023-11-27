<%@ include file="../init.jsp"%>

<portlet:actionURL name="<%=MVCCommandNames.SAVE_COMMITTEE_COMMENTS%>" var="saveCommitteeCommentsURL" />
<!--Modal -->
<div class="modal fade omsb-modal" id="committeeCommentsModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<aui:form name="sccFM" action="${saveCommitteeCommentsURL}" method="post" enctype="multipart/form-data">
		    <aui:input type="hidden" name="classPK" id="classPK" value="${equivalencyRequest.getEquivalencyRequestId()}" />
            <aui:input type="hidden" name="personId" id="personId" value="${equivalencyRequest.personId}" />
            <aui:input type="hidden" name="eqStatusKey" id="eqStatusKey" value="${equivalencyRequest.getStatusKey()}" />
            <aui:input type="hidden" name="eqStatusName" id="eqStatusName" value="${equivalencyRequest.getStatus()}" />
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="add-comments" /></h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="row">
                    	<div class="col-md-12">
                            <div class="form-group">
                                <label><liferay-ui:message key="equivalency-certificate" /></label>
                                <select name="<portlet:namespace />equivalencyCertificate" id="equivalencyCertificate" class="custom-select form-control">
                                    <option value=""><liferay-ui:message key="select" /></option>
                                    <c:forEach items="${evaluatedDocumentList}" var="eqCert">
                                        <option value="${eqCert.evaluateDocTypeKey}">
                                            <liferay-ui:message key="${eqCert.documentType}" />
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="col-md-12">
                            <div class="form-group">
                                <label><liferay-ui:message key="equivalency-level" /></label>
                                <select name="<portlet:namespace />equivalencyLevel" id="equivalencyLevel" class="custom-select form-control">
                                    <option value=""><liferay-ui:message key="select" /></option>
                                    <c:forEach items="${eqLevelList}" var="eqLevel">
                                        <option value="${eqLevel.getKey()}">
                                            <liferay-ui:message key="${eqLevel.getName(themeDisplay.getLocale())}" />
                                        </option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="col-md-12 d-none eq-level-reason">
                                <div class="form-group">
                                    <label><liferay-ui:message key="equivalency-level-reason" /></label>
                                    <select name="<portlet:namespace />equivalencyLevelReason" id="equivalencyLevelReason" class="custom-select form-control">
                                        <option value=""><liferay-ui:message key="select" /></option>
                                        <c:forEach items="${eqLevelReasonList}" var="eqLevelReason">
                                            <option value="${eqLevelReason.getKey()}">
                                                <liferay-ui:message key="${eqLevelReason.getName(themeDisplay.getLocale())}" />
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                        <div class="col-md-12">
                            <div class="form-group ">

                                <textarea onkeyup="countChar(this)" class="comments committee-comments" required="required"
                                        name="<portlet:namespace />committeeComments" rows="5" id="committeeComments">
                                </textarea>
                            </div>
                            <p id="errorContainer-committeeComments" class="error-container"></p>
                        </div>
                        <div class="col-md-12">
                            <div class="form-group">
                                <label><liferay-ui:message key="attachment"></liferay-ui:message></label>
                                <div class="custom-file">
                                    <aui:input id="additionalCommentsFile3" name="additionalCommentsFile" type="file" label=""
                                        cssClass="attachment form-control" required="" multiple="true"  >
                                        </aui:input>
                                        <label class="custom-file-label attach-file" for='<portlet:namespace/>additionalCommentsFile3'></label>
                                        <p class="d-none file" style="color:red;">
                                            <liferay-ui:message key="please-select-a-file" />
                                        </p>
                                </div>
                            </div>
                            <p id="errorContainer-committeeFile" class="error-container"></p>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn omsb-bc-red-button cmtSubmit" type="submit" title="save-comments" >
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
<!--Modal -->
<script>
	$(document).ready(function(){
		$('.committee-comments').richText();
		$('#committeeComments').siblings('.richText-editor').html('');
		$(".richText-editor").focusout(function(){
			var committeeComments = $('#committeeComments').siblings('.richText-editor').text().trim();
			console.log('committeeComments is ?', committeeComments);
			if (committeeComments != '') {
				console.log('committeeComments is not empty::');
				document.getElementById("errorContainer-committeeComments").textContent = "";	
			} else {
				console.log('committeeComments is empty :: ');
			}
		});
	});
	var _validFileExtensions = [".jpg", ".jpeg", ".pdf", ".png"];    

	$('#equivalencyLevel').on('change', function() {
		console.log('showReason() is invoking..');
		console.log('selected val is.', $(this).val());
		if ($(this).val() == 'none') {
		console.log(' inside selected val is.', $(this).val());
			$('.eq-level-reason').removeClass('d-none');
		} else {
		    $('.eq-level-reason').addClass('d-none');
		}
	});
	
	/* function validateCommentsAndSave(e) { */
		$(".cmtSubmit").on('click', function(e) {
		e.preventDefault();
		
		var error = false;
		/* var committeeComments = $('#committeeComments').siblings('.richText-editor').text().trim();
		console.log('comments are ??', committeeComments);
		if(committeeComments == '' ){
			console.log(" committeeComments inside ::" , committeeComments);
			document.getElementById("errorContainer-committeeComments").textContent = "<liferay-ui:message key='please-add-valid-comments' />";
			error = true;
		} */
			
	//	var files = document.getElementById('<portlet:namespace />additionalCommentsFile3').files;
	//	checkFileType(files);
	//	console.log('checkFileType isfjsdfjlsd ' , checkFileType(files));
		/* if (files.length <= 0) {
			document.getElementById('errorContainer-committeeFile').textContent = "<liferay-ui:message key='please-add-valid-file' />";
			error = true;
		} */
		
		if (!error) {
			$('#committeeCommentsModal').modal('hide');
			submitForm(document.<portlet:namespace />sccFM);
		}
	});
	
	
	var _validFileType= ["image/jpeg", "image/jpg", "application/pdf", "image/png"];
	
	$(':file').change(function(){
		var files = this.files;
		checkFileType(files);
	  });
	
	function checkFileType(files){
		 for(var i=0; i< files.length; i++){
		       var file = files[i];
		       var name = file.name.toLowerCase();
		       var size = file.size;
		       var type = file.type;
		       console.log('fileName is ',name);
	    	   console.log('file type is ',type);
		       if(jQuery.inArray(type, _validFileType) === -1){
		    	   console.log('Invalid file ');
		    	   $('#<portlet:namespace />additionalCommentsFile3').val('');
		    	   $('.attach-file').val('');
		    	   document.getElementById('errorContainer-committeeFile').textContent = "<liferay-ui:message key='please-add-valid-file-type' />";
		    	   return;
		       } else {
		    	   document.getElementById('errorContainer-committeeFile').textContent = "";
		       }
		       
		    }	
	}
</script>