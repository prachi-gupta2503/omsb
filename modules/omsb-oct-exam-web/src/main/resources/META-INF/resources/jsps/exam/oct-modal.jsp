<!-- Supporting Document Popup -->
	<div class="modal fade omsb-modal" id="addsupportingdocument" tabindex="-1" role="dialog"
			aria-labelledby="addsupportingdocumentTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="add-supporting-document"/></h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label class="required" ><liferay-ui:message key="document-title"/></label>
									<input type="text" onkeyup="validateSelectAndInputField('documentTitle','title-error')" maxlength="15"
									placeholder="<liferay-ui:message key="document-title"/>" name="Document Title" id="documentTitle" class="form-control">

									<input type="hidden" name="SuppDocAction" id="supp_doc_action" value="add" class="form-control">
									<input type="hidden" name="SuppRowClass" id="supp_doc_row_class" value="" class="form-control">
									<span class="text-danger d-none" id="title-error" ><liferay-ui:message key="the-document-title-field-is-required"/></span>
								</div>
							</div>
							<div class="col-md-12">
								<div class="form-group">
									<label class="required"><liferay-ui:message key="supporting-document"/></label>
									<div class="custom-file mb-3">
										<div>
											<input placeholder="<liferay-ui:message key="supporting-document"/>"  type="file" class="custom-file-input" id="supportingFile" name="supportingFile">
										</div>
										<label class="custom-file-label" id="popup_sd_file_label" for="supportingFile">
											<%-- <span class="uploader-value"></span>
											<span class="uploader-title"><liferay-ui:message key="select-file"/></span> --%>
										</label>
										<span class="text-danger d-none" id="file-error" ><liferay-ui:message key="the-supporting-document-is-required"/></span>
										<span class="text-danger d-none" id="file-type-error" ><liferay-ui:message key="Please enter valid File."/></span>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button class="btn omsb-bc-red-button" type="button" title="Add" onclick="addSupportingDocumentOCTExam();"><liferay-ui:message key="add"/></button>
						<!-- <button class="btn omsb-bc-red-button" type="button" title="Discrad"><liferay-ui:message key="discard"/></button> -->
						<button type="button" class="btn omsb-btn omsb-bg-red-button" onclick="closePopUp()"
							data-dismiss="modal"><liferay-ui:message key="close"/></button>
					</div>
				</div>
			</div>
		</div>
		<!-- Supporting Document Popup Ends -->	


<!--exam regular fee  Modal -->
<div class="modal fade omsb-modal" id=regular_fee_modal tabindex="-1" role="dialog" aria-labelledby="regularfeesTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="regular-fees"/></h5>
				<button type="button" class="close" data-dismiss="modal" onlcick="closePopUp()" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
						<div class="row">
							<div class="col-lg-12 col-md-12">
								<div class="form-group">
									<label class="required"><liferay-ui:message key="attempt-number"/></label>
									<input type="text" onkeypress="return event.charCode >= 48 && event.charCode <= 57"  onkeyup="validateSelectAndInputField('attempt_number','attempt_number_error')"
									maxlength="10" placeholder="<liferay-ui:message key="attempt-number"/>" id="attempt_number" name="<portlet:namespace/>attemptNumber" class="form-control">
									<span class="text-danger d-none" id="attempt_number_error" ><liferay-ui:message key="the-attempt-number-field-is-required"/></span>
									<span class="text-danger d-none" id="number_format_error" ><liferay-ui:message key="accepts-only-numbers"/></span>
								</div>
							</div>
							<div class="col-lg-12 col-md-12">
								<div class="form-group">
									<label class="required"><liferay-ui:message key="regular-fees-amount"/></label>
									<input type="text" maxlength="10" 
									placeholder="<liferay-ui:message key="regular-fees-amount"/>" id="regular_fee" name="<portlet:namespace/>regularFeeAmount" class="form-control">
									<span class="text-danger d-none" id="regular_fee_error" ><liferay-ui:message key="the-regular-fee-amount-field-is-required"/></span>
									<span class="text-danger d-none" id="regular_fee_number_error" ><liferay-ui:message key="accepts-only-numbers"/></span>
								</div>
							</div>
						</div>
					</div>
			<div class="modal-footer">
				<button class="btn omsb-bc-red-button" type="button" onclick="addRegularFee()" title="Add"><liferay-ui:message key="add"/></button>
				<button type="button" class="btn omsb-btn omsb-bg-red-button" onlcick="closePopUp()"
					data-dismiss="modal"><liferay-ui:message key="close"/></button>
			</div>
		</div>
	</div>
</div>


<!-- Modal -->

<!-- Modal -->
	<div class="modal fade omsb-modal" id="cancellationfees" tabindex="-1" role="dialog" aria-labelledby="cancellationfeesTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="cancellation-fees"/></h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-lg-12 col-md-12">
							<div class="form-group">
								<div class="row">
								
									<div class="col-lg-4">
										<label class="required"><liferay-ui:message key="range"/></label>
										<select name="<portlet:namespace/>daysBeforeExamSelct" onchange="hideAndShowInputFields()"
										id="cancellationfees_input_2" class="form-control cancellationfeesInputs">
		                                	<option value=""><liferay-ui:message key="select"/></option>
			                            <option value="-"><liferay-ui:message key="range-between"/></option>
			                            <option value=">"><liferay-ui:message key="range-greater-than"/></option>
			                            <option value="<"><liferay-ui:message key="range-less-than"/></option>
										</select>
									</div>
									
									<div class="col-lg-4" id="no_of_days_from">
										<label class="required"><liferay-ui:message key="no-of-days-from"/></label>
										<input type="text" placeholder="<liferay-ui:message key="no-of-days"/>" 
										class="form-control cancellationfeesInputs" value="" id="cancellationfees_input_1" maxlength="2"
										onkeypress="return event.charCode >= 48 && event.charCode <= 57">
									
									</div>
									
									<div class="col-lg-4" id="no_of_days_to">
										<label class="required"><liferay-ui:message key="no-of-days-to"/></label>
									 	<input type="text" placeholder="<liferay-ui:message key="no-of-days"/>" class="form-control cancellationfeesInputs" value="" id="cancellationfees_input_3" maxlength="2"
											onkeypress="return event.charCode >= 48 && event.charCode <= 57">
									</div>
									
									<div class="col-lg-4 d-none" id="no_of_days">
										<label class="required"><liferay-ui:message key="no-of-days"/></label>
									 	<input type="text" placeholder="<liferay-ui:message key="no-of-days"/>" class="form-control cancellationfeesInputs" value="" id="cancellationfees_no_of_days" maxlength="2"
											onkeypress="return event.charCode >= 48 && event.charCode <= 57">
										<span class="text-danger d-none" id="noOfDays-error" ><liferay-ui:message key="the-days-field-is-required"/></span>
									</div>
									
								</div>
								
								<div class="col-lg-4">
									<input type="hidden" placeholder="<liferay-ui:message key="no-of-days"/>" id="days_before_c"  name="<portlet:namespace/>daysBeforeExamCancellation" class="form-control" >
									<input type="hidden" id="days_before_exam_value" >
									<span class="text-danger d-none" id="days_before_c_error" ><liferay-ui:message key="the-days-before-field-is-required"/></span>
									<span class="text-danger d-none" id="days_before_number_error_c" ><liferay-ui:message key="accepts-only-numbers"/></span>
								</div>
								
							</div>
							
							
							<div class="col-lg-12 col-md-12">
								<div class="form-group">
									<label class="required"><liferay-ui:message key="refund-percentage"/></label>
									<input type="text" placeholder="<liferay-ui:message key="refund-percentage"/>" id="refund_percentage_c" onkeyup="validateSelectAndInputField('refund_percentage','refund_percentage_error')" onkeypress="return event.charCode >= 48 && event.charCode <= 57"
									 name="<portlet:namespace/>refundPercentageCancellation" class="form-control">
									<span class="text-danger d-none" id="refund_percentage_c_error" ><liferay-ui:message key="the-refund-percentage-field-is-required"/></span>
									<span class="text-danger d-none" id="refund_number_error_c" ><liferay-ui:message key="accepts-only-numbers"/></span>
									<span class="text-danger d-none" id="refund_percentage_range_error_c" ><liferay-ui:message key="percentage-should-be-between-0-and-100"/></span>
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button class="btn omsb-bc-red-button" onclick="addCancellationFee()" type="button" title="Send to committee"><liferay-ui:message key="add"/></button>
						<button type="button" class="btn omsb-btn omsb-bg-red-button" onlcick="closePopUp()"
							data-dismiss="modal"><liferay-ui:message key="close"/></button>
					</div>
				</div>
			
		</div>
	</div>
	</div>
	<!-- Modal -->
	
	<!-- Modal -->
	<div class="modal fade omsb-modal" id="reschedulingfees" tabindex="-1" role="dialog" aria-labelledby="reschedulingfeesTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="rescheduling-fees"/></h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
						<div class="row">
							<div class="col-lg-12 col-md-12">
								<div class="form-group">
									<div class="row">
									<div class="col-lg-4">
											<label class="required"><liferay-ui:message key="range"/></label>
											<select name="<portlet:namespace/>daysBeforeExam" onchange="hideAndShowRescheduleInputFields()"
											 id="rescheduling_input_2" class="form-control reschedulingInputs">
												<option value=""><liferay-ui:message key="select"/></option>
					                            <option value="-"><liferay-ui:message key="range-between"/></option>
					                            <option value=">"><liferay-ui:message key="range-greater-than"/></option>
					                            <option value="<"><liferay-ui:message key="range-less-than"/></option>
											</select>
										</div>
										
										<div class="col-lg-4"  id="reschedule_no_of_days_from">
											<label class="required"><liferay-ui:message key="no-of-days-from"/></label>
											<input type="text" placeholder="<liferay-ui:message key="no-of-days"/>" 
												class="form-control reschedulingInputs" value="" id="rescheduling_input_1" maxlength="2"
												onkeypress="return event.charCode >= 48 && event.charCode <= 57" >
										</div>
										<div class="col-lg-4" id="reschedule_no_of_days_to">
											<label class="required"><liferay-ui:message key="no-of-days-to"/></label>
											 <input type="text" placeholder="<liferay-ui:message key="no-of-days"/>" 
											 class="form-control reschedulingInputs" value="" id="rescheduling_input_3" maxlength="2"
											onkeypress="return event.charCode >= 48 && event.charCode <= 57" >
										</div>
									
									<div class="col-lg-4 d-none" id="reschedule_no_of_days">
										<label class="required"><liferay-ui:message key="no-of-days"/></label>
									 	<input type="text" placeholder="<liferay-ui:message key="no-of-days"/>" class="form-control cancellationfeesInputs" value="" id="reschedule_fees_no_of_days" maxlength="2"
											onkeypress="return event.charCode >= 48 && event.charCode <= 57">
										<span class="text-danger d-none" id="noOfDays-error" ><liferay-ui:message key="the-days-field-is-required"/></span>
									</div>
									<div class="form-group">
										<input type="hidden"  id="days_before"  name="<portlet:namespace/>daysBeforeExam" class="form-control" >
										<input type="hidden" id="days_before_reschedule_exam_value" >
										<span class="text-danger d-none" id="days_before_error" ><liferay-ui:message key="the-days-before-field-is-required"/></span>
										<span class="text-danger d-none" id="days_before_number_error" ><liferay-ui:message key="accepts-only-numbers"/></span>
									</div>
								</div>
							</div>
							<div class="col-lg-12 col-md-12">
								<div class="form-group">
									<label class="required"><liferay-ui:message key="refund-percentage"/></label>
									<input type="text" placeholder="<liferay-ui:message key="refund-percentage"/>" 
									id="refund_percentage" name="<portlet:namespace/>refundPercentage" class="form-control">

									<span class="text-danger d-none" id="refund_percentage_error" ><liferay-ui:message key="the-refund-percentage-field-is-required"/></span>
									<span class="text-danger d-none" id="refund_number_error" ><liferay-ui:message key="accepts-only-numbers"/></span>
									<span class="text-danger d-none" id="refund_percentage_range_error" ><liferay-ui:message key="percentage-should-be-between-0-and-100"/></span>
								</div>
							</div>
						</div>
					</div>
				<div class="modal-footer">
					<button class="btn omsb-bc-red-button" type="button" onclick="addReschedulingFee()" title="<liferay-ui:message key="add"/>"><liferay-ui:message key="add"/></button>
					<button type="button" class="btn omsb-btn omsb-bg-red-button"
						data-dismiss="modal"><liferay-ui:message key="close"/></button>
				</div>
			</div>
		</div>
	</div>

	</div>
	<!--delete popup  -->
		<div class="modal fade omsb-modal" id="delete_row" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered w-50" role="document">
				<div class="modal-content">
					<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle">
						<liferay-ui:message key="delete-confirmation" />
					</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form name="uploadresultpopupform" id="uploadresultpopupform" method="post" ></form>
						<div class="omsb-card omsb-card-graybg row">
							<div>
								<liferay-ui:message key="delete-examsetup-confirmation" />
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button class="btn omsb-bc-red-button" type="button" onclick="deleteRow()" title="ok" ><liferay-ui:message key="yes" /></button>
						<button type="button" class="btn omsb-btn omsb-bg-red-button"
							data-dismiss="modal" id="uploadcancel"><liferay-ui:message key="no" /></button>
					</div>
				</div>
			</div>
		</div>
		<!--delete popup  -->
		
		<!--discard exam-setup popup  -->
<div class="modal fade omsb-modal" id="exam-setup-discard" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered w-50" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">
					<liferay-ui:message key="discard-confirmation" />
				</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form name="uploadresultpopupform" id="uploadresultpopupform"
					method="post"></form>
				<div class="omsb-card omsb-card-graybg row">
					<div>
						<liferay-ui:message key="discard-examsetup-confirmation" />
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn omsb-bc-red-button" onclick="discardChanges()" type="button" title="ok">
					<liferay-ui:message key="yes" />
				</button>
				<button type="button" class="btn omsb-btn omsb-bg-red-button"
					data-dismiss="modal" id="uploadcancel">
					<liferay-ui:message key="no" />
				</button>
			</div>
		</div>
	</div>
</div>
<!--discard exam-setup popup  -->

	<!--duplicate exam popup  -->
<div class="modal fade omsb-modal" id="exist-exam-setup" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered w-50" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<div class="row">
					<div class="col-md-12">
						 <h5 class="modal-title" id="exampleModalLongTitle">
		                    <liferay-ui:message key="oc-exam-with" /> <span class='m-0 exist-exam'></span> <liferay-ui:message key="already-exist." />
		                </h5>
                  </div>
                </div>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form name="uploadresultpopupform" id="uploadresultpopupform"
					method="post"></form>
				<div class="omsb-card omsb-card-graybg">
					<div class="row">
						<div class="col-md-12">
							<liferay-ui:message key="exam-title-confirmation-text" />
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn omsb-bc-red-button"  type="button" id="yes_btn" title="ok">
					<liferay-ui:message key="yes" />
				</button>
				<button type="button" id="no_btn" class="btn omsb-btn omsb-bg-red-button"
					data-dismiss="modal" id="uploadcancel">
					<liferay-ui:message key="no" />
				</button>
			</div>
		</div>
	</div>
</div>
<!--discard exam-setup popup  -->
	