<div class="omsb-card">
	<div class="row">
		<div class="col-md-12">
			<div class="form-group">
				<label><liferay-ui:message key="attachment"></liferay-ui:message></label>
				<div class="custom-file">
					<aui:input id="file" name="certificateUploadFile" type="file"
						label="" cssClass="attachment form-control" required="true" />
					<label class="custom-file-label" for='<portlet:namespace/>file'></label>
					<p class="d-none file" style="color: red;">
						<liferay-ui:message key="please-select-a-file" />
					</p>
				</div>
			</div>
		</div>
	</div>
</div>