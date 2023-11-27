<%@ include file="init.jsp"%>

<div class="modal fade omsb-modal omsb-masterrotation-modal" id="applyleave" tabindex="-1" role="dialog"
        aria-labelledby="applyleaveTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
	    <div class="modal-content">
	    <aui:form action="#" method="post" name="refm">
	        <div class="modal-header">
	            <h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="leave" /></h5>
	            <button type="button" class="close" onclick="this.form.reset();" data-dismiss="modal" aria-label="Close">
	                <span aria-hidden="true">&times;</span>
	            </button>
	        </div>
	        <div class="modal-body">
				<div class="row pt-3">
		            <div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
								<aui:input type="text" cssClass="form-control leavedate" name="startDateValue" placeholder="DD/MM/YYYY" id="startDateValue" readonly="true">
									<aui:validator name="required" />
								</aui:input>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-12">
						<div class="form-group">
								<aui:input type="text" cssClass="form-control leavedate" name="endDateValue" placeholder="DD/MM/YYYY" id="endDateValue" readonly="true">
									<aui:validator name="required" />
								</aui:input>
						</div>
					</div>
					<div class="col-lg-12 col-md-12 col-sm-12">
						<div class="form-group">
							<aui:select id="leaveType" name="leaveType" label="leave-type" localized="true" class="custom-select form-control">
								<aui:validator name="required" />
							</aui:select>
						</div>
					</div>
				</div>
				<aui:input label="traineeId" type="hidden" name="traineeId" />
				<aui:input label="blockId" type="hidden" name="blockId" />
			</div>
			<div class="modal-footer">
				<button type="submit" class="btn omsb-bc-red-button" data-dismiss="modal" onclick="saveTraineeLeave()"><liferay-ui:message key="save" /></button>
						<button type="button" class="btn omsb-btn omsb-bg-red-button" onclick="this.form.reset();"
							data-dismiss="modal"><liferay-ui:message key="cancel" /></button>
		    </div>
		   </aui:form>
    	</div>
    </div>
</div>
