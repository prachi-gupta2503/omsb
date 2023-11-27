<%@include file ="../../init.jsp" %>
<portlet:resourceURL id="<%=MVCCommands.NEW_EXAM_SETUP_RESOURCE%>" var="getExistExamURL">
	<portlet:param name="cmd" value="getExistExam" />
</portlet:resourceURL>

<%-- <portlet:resourceURL id="<%=MVCCommands.NEW_EXAM_SETUP_RESOURCE%>" var="getTraineeLevelURL">
	<portlet:param name="cmd" value="getEligibility" />
</portlet:resourceURL> --%>

<portlet:resourceURL id="<%=MVCCommands.NEW_EXAM_SETUP_RESOURCE%>" var="getProgramIdURL">
	<portlet:param name="cmd" value="getProgram" />
</portlet:resourceURL>

<portlet:resourceURL id="<%=MVCCommands.NEW_EXAM_SETUP_RESOURCE%>" var="getExamTypeURL">
	<portlet:param name="cmd" value="getExamType" />
</portlet:resourceURL>

<portlet:resourceURL id="<%=MVCCommands.NEW_EXAM_SETUP_RESOURCE%>" var="getByLawRuleUrl">
	<portlet:param name="cmd" value="getByLawRule" />
</portlet:resourceURL>

<portlet:resourceURL id="<%=MVCCommands.NEW_EXAM_SETUP_RESOURCE%>" var="getSuggestedRulesURL">
	<portlet:param name="cmd" value="getSuggestedRules" />
</portlet:resourceURL>



<portlet:actionURL name="exam/save_exam_setup" var="saveExamsURL" />

<form action="${saveExamsURL}" method="post" name="saveExams" id="save_exam">
			<div id="wrapper">
				<div class="container">
					<div class="omsb-card">
						<div class="omsb-page-top-info m-0">
							<div class="pagetitle"><liferay-ui:message key="set-up-exam"/></div>
						</div>
						<div class="omsb-list-filter omsb-more-btn">
						
							<div class="row">
								<div class="col-lg-4 col-md-6">
									<div class="form-group">
									<input type="hidden" value="" name="<portlet:namespace/>existExam" id="exist_exam">
									<input type="hidden" value="${exam.id}" name="<portlet:namespace/>examId">
									<input type="hidden" value="${searchProgramId}" name="<portlet:namespace/>searchProgramId">
									<input type="hidden" value="${searchExamTypeId}" name="<portlet:namespace/>searchExamTypeId">
									<input type="text" name="<portlet:namespace/>programJsonData" id="program_json_data" class="d-none">
									<input type="text" name="<portlet:namespace/>examEligiblityJsonData" id="examElg_json_data" class="d-none">
										<label><liferay-ui:message key="program-type"/></label>
										<select  onchange="getProgramId();getExamType();" name="<portlet:namespace/>programType" id="program_type"  class="custom-select form-control">
											<option value=""><liferay-ui:message key="select-program-type"/></option>
											<c:forEach var="programTypeMasters"items="${programTypeMasters}" varStatus="status" >
											<c:set var="selected" value="${exam != null && exam.programTypeId == programTypeMasters.programTypeMasterId}" />
									            <option value="${programTypeMasters.programTypeMasterId}" <c:if test="${selected}">selected="selected"</c:if>>${programTypeMasters.programTypeName}</option>
									        </c:forEach>
										</select>
										<span class="text-danger d-none" id="program_type_val_error" ><liferay-ui:message key="the-program-type-field-is-required"/></span>
									</div>
								</div>
								<div class="col-lg-4 col-md-6">
									<div class="form-group">
										<label><liferay-ui:message key="program-name"/></label>
										<select  multiple name="<portlet:namespace/>program" id="program"  class="custom-select form-control">
											<option value=""><liferay-ui:message key="select-program-name"/></option>
										</select>
										<span class="text-danger d-none" id="program_name_val_error" ><liferay-ui:message key="the-program-name-field-is-required"/></span>
									</div>
								</div>
								<div class="col-lg-4 col-md-6">
									<div class="form-group">
										<label class="required"><liferay-ui:message key="exam-type"/></label>
										<select  onchange="validateSelectAndInputField('exam_type','et_error'); checkedRule();"  name="<portlet:namespace/>examType" id="exam_type"  class="custom-select form-control">
										  <%-- <option value=""><liferay-ui:message key="select-exam-type"/></option> --%>
										  <option value="${examTypeId}">${examTypeName}</option>
										</select>
										<span class="text-danger d-none" id="et_error" ><liferay-ui:message key="the-exam-type-field-is-required"/></span>
									</div>
								</div>
								<div class="col-lg-4 col-md-6">
									<div class="form-group">
										<label class="required"><liferay-ui:message key="exam-eligibility"/></label>
										<select onchange="validateSelectAndInputField('exam_eligibility','elg_val_error'); getbyLawRule();" name="<portlet:namespace/>examEligibility" id="exam_eligibility"  class="custom-select form-control">
											<option value=""><liferay-ui:message key="select-exam-eligibility"/></option>
											 <c:forEach var="rule" items="${rules}">
											 <c:set var="selected" value="${exam != null && exam.examEligibility == rule.id}" />
												<option value="${rule.id}" <c:if test="${selected}">selected="selected"</c:if>>${rule.ruleKeyName}</option>
											</c:forEach> 
										</select>
										<span class="text-danger d-none" id="elg_val_error" ><liferay-ui:message key="the-exam-eligibility-field-is-required"/></span>
									</div>
								</div>
								<div class="col-lg-4 col-md-6">
									<div class="form-group">
										<label class="required"><liferay-ui:message key="result-source"/></label>
										<select onchange="validateSelectAndInputField('result_source','res_val_error');" name="<portlet:namespace/>resultSource" id="result_source"  class="custom-select form-control">
											<option value=""><liferay-ui:message key="select-result-source"/></option>
											<c:forEach var="resultSources" items="${resultSources}">
											<c:set var="selected" value="${exam != null && exam.resultSource == resultSources.getKey()}" />
												<option value="${resultSources.getKey() }"<c:if test="${selected}">selected="selected"</c:if>>${resultSources.getName(themeDisplay.getLocale())}</option>
											</c:forEach>
										</select>
										<span class="text-danger d-none" id="res_val_error" ><liferay-ui:message key="the-result-source-field-is-required"/></span>
									</div>
								</div>
								<div class="col-lg-4 col-md-6">
									<div class="form-group">
										<label><liferay-ui:message key="allowed-no-of-attempt"/></label>
										<input id="allowedAttempt" placeholder="<liferay-ui:message key="allowed-no-of-attempt"/>"value="${exam.allowedNoOfAttempt}" type="text" name="<portlet:namespace/>allowedNoOfAttempt" class="form-control">
										<%-- <span class="text-danger d-none" id="early_bd_val_error" ><liferay-ui:message key="the-applicable-days-field-is-required"/></span> --%>
									</div>
								</div>
								
							</div>
						</div>
						<div class="omsb-card omsb-card-graybg ">
						    <div class="row">
						    <div class="col-lg-4 col-md-6">
									<div class="form-group">
										<label id="bylawrule"></label>
									</div>
								</div>
								<div class="col-lg-4 col-md-6">
									<div class="form-group">
										<label id="suggestedRule"></label>
									</div>
								</div>
						    </div>
						</div>

						<div class="omsb-card omsb-card-graybg ">
							<h4 class="omsb-card-title"><liferay-ui:message key="early-bird-fees"/>
								</h4>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label class="required"><liferay-ui:message key="applicable-days"/>  <img src="<%=themeDisplay.getPathThemeImages()%>/svg/i-button.svg" alt="info" data-toggle="tooltip" data-placement="top" title="Number of Days Before Exam Start Date"></label>
										<input id="applicable_days" placeholder="<liferay-ui:message key="early-bird-fees"/>"  onkeyup="validateSelectAndInputField('applicable_days','early_bd_val_error')" maxlength="10" value="${exam.earlyBirdFeesDate}" onkeypress="return event.charCode >= 48 && event.charCode <= 57" type="text" name="<portlet:namespace/>applicableDays" class="form-control">
										<span class="text-danger d-none" id="early_bd_val_error" ><liferay-ui:message key="the-applicable-days-field-is-required"/></span>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label class="required"><liferay-ui:message key="fee-amount-in-omr"/></label>
										<input id="fee_amount" placeholder="<liferay-ui:message key="fee-amount-in-omr"/>" value="${exam.earlyBirdFees}" type="text"  onkeyup="validateSelectAndInputField('fee_amount','eb_fee_val_error')"
										 onkeypress="return event.charCode >= 48 && event.charCode <= 57" name="<portlet:namespace/>feeAmount" class="form-control">
										<span class="text-danger d-none" id="eb_fee_val_error" ><liferay-ui:message key="the-fee-amount-field-is-required"/></span>
									</div>
								</div>
							</div>
						</div>

						<div class="omsb-card omsb-card-graybg ">
							<h4 class="omsb-card-title"><liferay-ui:message key="regular-exam-fee"/>
								<button class="btn omsb-bg-red-button" onclick="regularFeeCount()" data-toggle="modal" data-target="#regular_fee_modal"
								type="button">
								<img src="<%=themeDisplay.getPathThemeImages()%>/svg/plus_img.svg" alt="" />
								<liferay-ui:message key="add-row"/>
							</button>
							</h4>
							<div class="omsb-list-view table-responsive">
								 <input type="text" name="<portlet:namespace/>regularExamJsonData" id="regularExam_json_data" class="d-none">
								 <span class="d-none text-danger" id="regular_em_tb"><liferay-ui:message key="the-regular-fee-field-is-required"/></span>
								<table class="display omsb-datatables" id="regularExam_table">
									<thead>
										<tr>
											<th name="noOfAttempts"><liferay-ui:message key="attempt-number"/></th>
											<th name="regularFee"><liferay-ui:message key="regular-fees-amount-in-omr"/></th>
											<th name="actions"><liferay-ui:message key="action"/></th>
										</tr>
									</thead>
									<c:if test="${cmd == 'addExam'}">
									<tbody>
									</tbody>
									</c:if>
									<c:if test="${cmd == 'editExam'}">
									<tbody>
									<c:forEach var="regularFee"items="${exam.regularFees}" >
									<tr>
										<td data-value="${regularFee.noOfAttempts}">${regularFee.noOfAttempts}</td>
										<td data-value="${examEligibility2.examEligibility}">${regularFee.regularFee}</td>									      
										<td>
											<div class="dropdown ">
												<button class="btn fa fa-ellipsis-v dropdown-toggle" type="button"
													data-toggle="dropdown" aria-expanded="false">
													<i class=""></i>
												</button>
												<ul class="dropdown-menu">
													<li><a href="#" class="dropdown-item" data-toggle ="modal" data-target ="#regular_fee_modal" onclick="editregfee(this);"><img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg"><liferay-ui:message key="edit"/></a></li>
													<li><a href="#" class="dropdown-item" data-toggle ="modal" data-target ="#delete_row" onclick="setData(this)"><img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-delete.svg"> <liferay-ui:message key="delete"/></a>
													</li>
												</ul>
											</div>
										</td>									      
									 </tr>
									 </c:forEach>
									</tbody>
									</c:if>
								</table>
							</div>
						</div>

						<div class="omsb-card omsb-card-graybg ">
							<h4 class="omsb-card-title"><span><liferay-ui:message key="cancellation-fees"/>  <img src="<%=themeDisplay.getPathThemeImages()%>/svg/i-button.svg" alt="info" data-toggle="tooltip" data-placement="top" title="Number of Days Before Exam Start Date"></span>
								<button class="btn omsb-bg-red-button" data-toggle="modal" data-target="#withdrawlfees" type="button">
									<img src="<%=themeDisplay.getPathThemeImages()%>/svg/plus_img.svg" alt="" />
									<liferay-ui:message key="add-row"/>
								</button>
							</h4>
							<div class="omsb-list-view table-responsive">
							<input type="text" name="<portlet:namespace/>withdrawalFeeJsonData" id="withdrawal_fee_json_data" class="d-none">
							<span class="d-none text-danger" id="withdrawal_em_tb"><liferay-ui:message key="the-withdrawal-fee-field-is-required"/></span>
								<table class="display omsb-datatables" id="withdrawal_fee_table">
									<thead>
										<tr>
											<th name="noOfDaysText"><liferay-ui:message key="days-before-exam"/></th>
											<th name="noOfDays" class="d-none"></th>
											<th name="withdrawalFeesPercentage"><liferay-ui:message key="refund-percentage"/></th>
											<th name="actions"><liferay-ui:message key="action"/></th>
										</tr>
									</thead>
									<c:if test="${cmd == 'addExam'}">
										<tbody>
										</tbody>
										</c:if>
										<c:if test="${cmd == 'editExam'}">
										<tbody>
										<c:forEach var="withdrawalFee"items="${exam.withdrawalFees}"  >
										<tr>
											<td data-value="${withdrawalFee.noOfDaysText}">${withdrawalFee.noOfDaysText}</td>
											<td data-value="${withdrawalFee.noOfDays}">${withdrawalFee.noOfDays}</td>
											<td data-value="${withdrawalFee.withdrawalFeesPercentage}">${withdrawalFee.withdrawalFeesPercentage}</td>									      
											<td>
												<div class="dropdown ">
													<button class="btn fa fa-ellipsis-v dropdown-toggle" type="button"
														data-toggle="dropdown" aria-expanded="false">
														<i class=""></i>
													</button>
													<ul class="dropdown-menu">
														<li><a href="#" class="dropdown-item" data-toggle ="modal" data-target ="#withdrawlfees" onclick="editwithfee(this);"><img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg"><liferay-ui:message key="edit"/></a></li>
														<li><a href="#" class="dropdown-item" data-toggle ="modal" data-target ="#delete_row" onclick="setData(this)"><img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-delete.svg"> <liferay-ui:message key="delete"/></a>
														</li>
													</ul>
												</div>
											</td>									      
										 </tr>
										 </c:forEach>
										</tbody>
									</c:if>
								</table>
							</div>
						</div>

						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label class="required"><liferay-ui:message key="appeal-window"/>  <img src="<%=themeDisplay.getPathThemeImages()%>/svg/i-button.svg" alt="info" data-toggle="tooltip" data-placement="top" title="Number of Days After Results Are Announced In Working Days"></label>
									<input id="appeal_window" placeholder="<liferay-ui:message key="appeal-window"/>" onkeyup= "validateSelectAndInputField('appeal_window','appeal_wnd_val_error')" onkeypress="return event.charCode >= 48 && event.charCode <= 57"
									value="${exam.appealWindow}" type="text" name="<portlet:namespace/>appealWindow" class="form-control">
									<span class="text-danger d-none" id="appeal_wnd_val_error" ><liferay-ui:message key="the-appeal-window-field-is-required"/></span>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label class="required"><liferay-ui:message key="appeal-fees-in-omr"/></label>
									<input id="appeal_fees" placeholder="<liferay-ui:message key="appeal-fees-in-omr"/>" onkeyup= "validateSelectAndInputField('appeal_fees','appeal_fees_val_error')" onkeypress="return event.charCode >= 48 && event.charCode <= 57"
									value="${exam.appealFees}" type="text" onkeypress="return event.charCode >= 48 && event.charCode <= 57"
									name="<portlet:namespace/>appealFees" class="form-control">
							<span class="text-danger d-none" id="appeal_fees_val_error" ><liferay-ui:message key="the-appeal-fees-field-is-required"/></span>
								</div>
							</div>
							
							<div class="col-md-6">
								<div class="form-group">
									<label class="required"><liferay-ui:message key="re-appeal-window"/>  <img src="<%=themeDisplay.getPathThemeImages()%>/svg/i-button.svg" alt="info" data-toggle="tooltip" data-placement="top" title="Number of Days After Results Are Announced In Working Days"></label>
									<input id="re_appeal_window" placeholder="<liferay-ui:message key="re-appeal-window"/>" onkeyup= "validateSelectAndInputField('re_appeal_window','re_app_wnd_val_error')" value="${exam.reAppealWindow}" type="text" name="<portlet:namespace/>reAppealWindow" class="form-control">
									<span class="text-danger d-none" id="re_app_wnd_val_error" ><liferay-ui:message key="the-reappeal-window-field-is-required"/></span>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label class="required"><liferay-ui:message key="re-appeal-fees-in-omr"/></label>
									<input id="re_appeal_fees" placeholder="<liferay-ui:message key="re-appeal-fees-in-omr"/>" onkeyup= "validateSelectAndInputField('re_appeal_fees','re_app_fees_val_error')"  value="${exam.reAppealFees}" onkeypress="return event.charCode >= 48 && event.charCode <= 57"
									name="<portlet:namespace/>reAppealFees" class="form-control">
									<span class="text-danger d-none" id="re_app_fees_val_error" ><liferay-ui:message key="the-reappeal-fees-field-is-required"/></span>
								</div>
							</div>
						</div>
						<portlet:renderURL var="examHomeURL">
							<portlet:param name="mvcRenderCommandName" value="/" />
							<portlet:param name="searchProgramId" value="${searchProgramId}" />
							<portlet:param name="searchExamTypeId" value="${searchExamTypeId}" />
						</portlet:renderURL>

				<div class="bottom-backbtn-wrap">
						<c:if test="${cmd == 'editExam'}">
							<button class="btn omsb-bc-red-button" type="submit" onclick="saveRegularFee(event);saveWithdrawalFee(event)" title="Save"><liferay-ui:message key="update"/></button>				
						</c:if>
						<c:if test="${cmd != 'editExam'}">
							<button class="btn omsb-bc-red-button" type="submit" onclick="saveRegularFee(event);saveWithdrawalFee(event)" title="Save"><liferay-ui:message key="save"/></button>
						</c:if>
							<button class="btn omsb-bc-red-button" data-toggle="modal" data-target="#exam-setup-discard" type="button" title="Discard"><liferay-ui:message key="discard" /></button>
							<a class="btn omsb-btn btn-back" href="${examHomeURL}"><i class="fi fi-sr-arrow-left"></i><liferay-ui:message key="back"/></a>
						</div>
					</div>
				</div>
			</div>


		<div class="modal fade omsb-modal" id="regular_fee_modal" tabindex="-1" role="dialog"
			aria-labelledby="earlybirdfeesTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="regular-fees"/></h5>
						<button type="button" class="close close-regular-fee" data-dismiss="modal" aria-label="Close" >
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-lg-12 col-md-12">
								<div class="form-group">
									<label class="required"><liferay-ui:message key="attempt-number"/></label>
									<input type="text" onkeyup="validateSelectAndInputField('attempt_number','attempt_number_error')" onkeypress="return event.charCode >= 48 && event.charCode <= 57"
									 id="attempt_number" name="<portlet:namespace/>attemptNumber" class="form-control">
									<span class="text-danger d-none" id="attempt_number_error" ><liferay-ui:message key="the-attempt-number-field-is-required"/></span>
									<span class="text-danger d-none" id="number_format_error" ><liferay-ui:message key="accepts-only-numbers"/></span>
								</div>
							</div>
							<div class="col-lg-12 col-md-12">
								<div class="form-group">
									<label class="required"><liferay-ui:message key="regular-fees-amount"/></label>
									<input placeholder="<liferay-ui:message key="regular-fees-amount"/>" type="text" onkeyup="validateSelectAndInputField('regular_fee','regular_fee_error')" onkeypress="return event.charCode >= 48 && event.charCode <= 57"
									id="regular_fee" name="<portlet:namespace/>regularFeeAmount" class="form-control">
									<span class="text-danger d-none" id="regular_fee_error" ><liferay-ui:message key="the-regular-fee-amount-field-is-required"/></span>
									<span class="text-danger d-none" id="regular_fee_number_error" ><liferay-ui:message key="accepts-only-numbers"/></span>
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button class="btn omsb-bc-red-button" type="button" onclick="addRegularFee()" title="Add"><liferay-ui:message key="add"/></button>
						<button class="btn omsb-bc-red-button" type="button" onclick="discardPopupReg()" title="Discard"><liferay-ui:message key="discard"/></button>
						<button type="button" class="btn omsb-btn omsb-bg-red-button close-regular-fee" onclick="discardValues()"
							data-dismiss="modal"><liferay-ui:message key="close"/></button>
					</div>
				</div>
			</div>
		</div>
		<!--// regular Fees report -->

		
		<div class="modal fade omsb-modal" id="withdrawlfees" tabindex="-1" role="dialog"
			aria-labelledby="withdrawlfeesTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="cancellation-fees"/></h5>
						<button type="button" class="close close-withdrawal-fee" data-dismiss="modal" aria-label="Close" id="close-cancellation-fees">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="row">
								<div class="col-lg-4">
									<label class="required"><liferay-ui:message key="range"/></label>
									<select name="<portlet:namespace/>daysBeforeExamSelct" onchange="hideAndShowInputFields()"
									id="cancellationfees_days_range" class="form-control cancellationfeesInputs">
	                                	<option value=""><liferay-ui:message key="select"/></option>
			                            <option value="-"><liferay-ui:message key="range-between"/></option>
			                            <option value=">"><liferay-ui:message key="range-greater-than"/></option>
			                            <option value="<"><liferay-ui:message key="range-less-than"/></option>
									</select>
									<span class="text-danger d-none" id="cancellationFeeSelectedText-error" ><liferay-ui:message key="the-range-field-is-required"/></span>
								</div>
								<div class="col-lg-4" id="no_of_days_from">
										<label class="required"><liferay-ui:message key="no-of-days-from"/></label>
										<input type="text" placeholder="<liferay-ui:message key="no-of-days"/>" 
										class="form-control cancellationfeesInputs" value="" id="cancellationfees_no_of_days_from" maxlength="2"
									onkeypress="return event.charCode >= 48 && event.charCode <= 57">
									<span class="text-danger d-none" id="noOfDaysFrom-error" ><liferay-ui:message key="the-days-from-field-is-required"/></span>	
								</div>
								<div class="col-lg-4" id="no_of_days_to">
									<label class="required"><liferay-ui:message key="no-of-days-to"/></label>
								 	<input type="text" placeholder="<liferay-ui:message key="no-of-days"/>" class="form-control cancellationfeesInputs" value="" id="cancellationfees_no_of_days_to" maxlength="2"
										onkeypress="return event.charCode >= 48 && event.charCode <= 57">
									<span class="text-danger d-none" id="noOfDaysTo-error" ><liferay-ui:message key="the-days-to-field-is-required"/></span>
								</div>
								<div class="col-lg-4 d-none" id="no_of_days">
									<label class="required"><liferay-ui:message key="no-of-days"/></label>
								 	<input type="text" placeholder="<liferay-ui:message key="no-of-days"/>" class="form-control cancellationfeesInputs" value="" id="cancellationfees_no_of_days" maxlength="2"
										onkeypress="return event.charCode >= 48 && event.charCode <= 57">
									<span class="text-danger d-none" id="noOfDays-error" ><liferay-ui:message key="the-days-field-is-required"/></span>
								</div>
						
						
						
							<div class="col-lg-12 col-md-12">
								<div class="form-group">
									<input type="hidden" placeholder="<liferay-ui:message key="no-of-days"/>" type="text" id="days_before_c"  name="<portlet:namespace/>daysBeforeExam" class="form-control" >
									<input type="hidden" id="days_before_exam_value"  >
									
										
									<span class="text-danger d-none" id="days_before_c_error" ><liferay-ui:message key="the-days-before-field-is-required"/></span>
									<span class="text-danger d-none" id="days_before_number_error_c" ><liferay-ui:message key="accepts-only-numbers"/></span>
								</div>
							</div>
							<div class="col-lg-12 col-md-12">
				  				<div class="form-group">
									<label class="required"><liferay-ui:message key="refund-percentage"/></label>
									<input placeholder="<liferay-ui:message key="refund-percentage"/>" type="text" onkeyup="validateSelectAndInputField('refund_percentage','refund_percentage_error')" onkeypress="return event.charCode >= 48 && event.charCode <= 57"
									id="refund_percentage" name="<portlet:namespace/>refundPercentage" class="form-control">
									<span class="text-danger d-none" id="refund_percentage_error" ><liferay-ui:message key="the-refund-percentage-field-is-required"/></span>
									<span class="text-danger d-none" id="refund_number_error" ><liferay-ui:message key="accepts-only-numbers"/></span>
									<span class="text-danger d-none" id="refund_percentage_range_error" ><liferay-ui:message key="percentage-should-be-between-0-and-100"/></span>
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button class="btn omsb-bc-red-button" type="button" onclick="validateAndAddWithdrawalFee()" title="Add"><liferay-ui:message key="add"/></button>
						<button class="btn omsb-bc-red-button" type="button" onclick="discardPopupWith()" title="Discard"><liferay-ui:message key="discard"/></button>
						<button type="button" class="btn omsb-btn omsb-bg-red-button close-withdrawal-fee" onclick="discardWithdrawalFeesValues()"
							data-dismiss="modal"><liferay-ui:message key="close"/></button>
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
	</form>
		<!--// withdrawal -->
		
		
		
		
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
		                    <liferay-ui:message key="oc-exam-with" />
		                </h5>
                  </div>
	                <div class="col-md-12">
	                	<p class='m-0'></p>
	                </div>
	                <div class="col-md-12">
	             		 <h5 class="modal-title" id="exampleModalLongTitle">
	             			 <liferay-ui:message key="already-exist." />
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

<script>
$('#program').multiselect();
/* $('#exam_eligibility').multiselect(); */

var theme_image_path = '<%=themeDisplay.getPathThemeImages()%>';

function discardEligibilityValues(){
	console.log("Eligibility Values ...");
	document.getElementById('eligibility').value = "";
	 document.getElementById('exam_type_popUp').value = "";
	
}

function discardWithdrawalFeesValues(){
	console.log("Withdrawal Fee ...");
	document.getElementById('refund_percentage').value = '';
	document.getElementById('days_before').value = '';
}

 function discardValues(){
	 console.log("Regular Fee ...");
	 document.getElementById('attempt_number').value = '';
	 document.getElementById('regular_fee').value = '';
 }

 var reg_table = $('#regularExam_table').DataTable({
	    "bLengthChange": false,
	    "bFilter": false,
	    "pageLength": 2
	});
 
 var wit_table = $('#withdrawal_fee_table').DataTable({
	    "bLengthChange": false,
	    "bFilter": false,
	    "pageLength": 2,
	    "columnDefs": [ { target: 1,
	    	"createdCell": function(td) {
	    		$(td).attr('class','d-none');
	    	}
	    }]
	});
 var elig_table = $('#eligibility_table').DataTable({
	    "bLengthChange": false,
	    "bFilter": false,
	    "pageLength": 2
	});
 
$( document ).ready(function() {
	console.log("11111111111111"+reg_table.data().count());
$('.omsb-datatables').find(".dataTables_empty").parents('tbody').empty();
/* for edit */
    console.log( "ready!" );
    var cmd = "${cmd}";
    if(cmd == 'editExam'){
    console.log(cmd)
    getProgramId(cmd);
    getExamType(cmd);
    /* getEligbility(cmd);  */
    handleProgramChange();
  /*   handleExamTypeChange(); */
  	getbyLawRule();
    }
    check_dropdown();
});

/* for add */
	
	function check_dropdown() {
		$("[data-toggle='dropdown']").click(function () {
			$(this).siblings("ul.dropdown-menu").toggleClass("show");
		})
	}
	 
		
	function addRegularFee(){
		var pattern = /^[0-9]+$/;
		var doublepattern = /^[0-9]+(\.\d+)?$/;
		var attemptNumber = $("#attempt_number").val();
		var regularFee = $("#regular_fee").val();
		console.log("attemptNumber :"+attemptNumber);
		var attempt_number=validateSelectAndInputField('attempt_number','attempt_number_error');
		var regular_fee=validateSelectAndInputField('regular_fee','regular_fee_error');
		
		if(regular_fee && attempt_number){
			var addExamModal = $("#regular_fee_modal");
			addExamModal.modal('hide');
			var editRow = $("#regular_fee_modal").data("editRow");
	        if (editRow){
				console.log("inside if condn");
				editRow.find("td:nth-child(1)").text(attemptNumber);
			    editRow.find("td:nth-child(2)").text(regularFee);
			  } else{
		 	 
		 	var newRow = $("<tr>");
			var attemptNoCell = $("<td>").text(attemptNumber);
			var regularFeeCell = $("<td>").text(regularFee);
			var actionCell = $("<td>");
			
			var dropdownDiv = $("<div>").addClass("dropdown");
			var dropdownBtn = $("<button>").addClass("btn fa fa-ellipsis-v dropdown-toggle").attr({
				"type": "button",
				"data-toggle": "dropdown",
				"aria-expanded": "false"
			});
			var dropdownMenu = $("<ul>").addClass("dropdown-menu");
			var editLink = $("<a>").addClass("dropdown-item").attr({
				"data-toggle": "modal",
				"data-target": "#regular_fee_modal",
				"onclick": "editregfee(this);"
			}).attr("href", "#").append($("<img>").attr("src", '<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-eye.svg')).append("Edit");
			var deleteLink = $("<a>").addClass("dropdown-item").attr({
				"data-toggle": "modal",
				"data-target": "#delete_row",
				"onclick": "setData(this)"
			}).attr("href", "#").append($("<img>").attr("src", '<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-equate.svg')).append("Delete")
			 dropdownMenu.append($("<li>").append(editLink), $("<li>").append(deleteLink));
			/*dropdownDiv.append(dropdownBtn, dropdownMenu);
			actionCell.append(dropdownDiv);
			 newRow.append(attemptNoCell, regularFeeCell, actionCell); 
			$("#regularExam_table tbody").append(newRow);  */
			
			var rgt_action ='<div class="dropdown"><button class="btn fa fa-ellipsis-v dropdown-toggle" type="button" data-toggle="dropdown" aria-expanded="false"></button><ul class="dropdown-menu"><li><a class="dropdown-item" data-toggle="modal" data-target="#regular_fee_modal" onclick="editregfee(this);" href="#"><img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg">Edit</a></li><li><a class="dropdown-item" data-toggle="modal" data-target="#delete_row" onclick="setData(this)" href="#"><img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-delete.svg">Delete</a></li></ul></div>';
			  
			reg_table.row.add( [ attemptNumber, regularFee, rgt_action ] ).draw();
			  
			}
	        $("#regular_fee_modal").removeData("editRow");
			  $("#attempt_number").val('');
			  $("#regular_fee").val('');
			  $('#attempt_number_error').addClass('d-none');
			  $('#regular_fee_error').addClass('d-none');
			  $('#number_format_error').addClass('d-none')
			  $('#regular_fee_number_error').addClass('d-none')
			  $('#regular_em_tb').addClass('d-none');
			}
		}
	function hideAndShowInputFields(){
		var withdrawFeeSelectedValue =$('#cancellationfees_days_range option:selected').val();
		if(withdrawFeeSelectedValue == '>' || withdrawFeeSelectedValue == '<'){
			$("#cancellationfees_no_of_days_from").val('');
			$("#cancellationfees_no_of_days_to").val('');
			$('#no_of_days').removeClass('d-none');
			$('#no_of_days_to').addClass('d-none');
			$('#no_of_days_from').addClass('d-none');	
		}else{
			$("#cancellationfees_no_of_days").val('');
			$('#no_of_days_to').removeClass('d-none');
			$('#no_of_days_from').removeClass('d-none');	
			$('#no_of_days').addClass('d-none');
		}
		
	}
	
	function validateAndAddWithdrawalFee(){
		if(!validateDaysPopupScreen('days_before_c','days_before_exam_value','days_before_c_error','cancellationfees_no_of_days_from','cancellationfees_days_range','cancellationfees_no_of_days_to','cancellationfees_no_of_days')){
			return false;
		}
		var pattern = /^[0-9]+$/;
		var doublepattern = /^[0-9]+(\.\d+)?$/;
		var daysBefore = $("#days_before_c").val();
		var daysBeforeExamValue = $("#days_before_exam_value").val();
		
		var refundPercentage = $("#refund_percentage").val();
		console.log("daysBefore :"+daysBefore);
		
		if (refundPercentage.trim() === '' || !doublepattern.test(refundPercentage)) {
		    $('#refund_percentage_error').removeClass('d-none');
		    $('#refund_number_error').addClass('d-none');
		    $('#refund_percentage_range_error').addClass('d-none');
		    $('#days_before_c_error').addClass('d-none');
		    $('#days_before_number_error_c').addClass('d-none');
		    return;
		}

		var refundPercentageValue = parseFloat(refundPercentage);

		if (isNaN(refundPercentageValue) || refundPercentageValue < 0 || refundPercentageValue > 100) {
		    $('#refund_percentage_error').addClass('d-none');
		    $('#refund_number_error').addClass('d-none');
		    $('#refund_percentage_range_error').removeClass('d-none');
		    $('#days_before_c_error').addClass('d-none');
		    $('#days_before_number_error_c').addClass('d-none');
		    return;
		}
		var refund_percentage=validateSelectAndInputField('refund_percentage','refund_percentage_error');
		var days_before= validateSelectAndInputField('days_before_c','days_before_c_error');
		var days_before_exam_value= validateSelectAndInputField('days_before_exam_value','days_before_c_error');
		if(days_before && refund_percentage && days_before_exam_value){
			var addExamModal = $("#withdrawlfees");
			addExamModal.modal('hide');
			var editRow = $("#withdrawlfees").data("editRow");
	        if (editRow){
				console.log("inside if condn");
				editRow.find("td:nth-child(1)").text(daysBefore);
				editRow.find("td:nth-child(2)").text(daysBeforeExamValue);
			    editRow.find("td:nth-child(3)").text(refundPercentage);
			  } 
	        else{
	        var newRow = $("<tr>");
			var daysBeforeCell = $("<td>").text(daysBefore);
			var refundPercentageCell = $("<td>").text(refundPercentage);
			var actionCell = $("<td>");
			var dropdownDiv = $("<div>").addClass("dropdown");
			var dropdownBtn = $("<button>").addClass("btn fa fa-ellipsis-v dropdown-toggle").attr({
				"type": "button",
				"data-toggle": "dropdown",
				"aria-expanded": "false"
			});
			var dropdownMenu = $("<ul>").addClass("dropdown-menu");
			var editLink = $("<a>").addClass("dropdown-item").attr({
				"data-toggle": "modal",
				"data-target": "#withdrawlfees",
				"onclick": "editwithfee(this); return false;"
			}).attr("href", "#").append($("<img>").attr("src", "<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-eye.svg")).append("Edit");
			var deleteLink = $("<a>").addClass("dropdown-item").attr({
				"data-toggle": "modal",
				"data-target": "#delete_row",
				"onclick": "setData(this)"
			}).attr("href", "#").append($("<img>").attr("src", "<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-equate.svg")).append("Delete")
				dropdownMenu.append($("<li>").append(editLink), $("<li>").append(deleteLink));
				/* dropdownDiv.append(dropdownBtn, dropdownMenu);
				 actionCell.append(dropdownDiv); 
				newRow.append(daysBeforeCell, refundPercentageCell, actionCell);
			  	$("#withdrawal_fee_table tbody").append(newRow);  */
			  	
			  var wft_action ='<div class="dropdown"><button class="btn fa fa-ellipsis-v dropdown-toggle" type="button" data-toggle="dropdown" aria-expanded="false"></button><ul class="dropdown-menu"><li><a class="dropdown-item" data-toggle="modal" data-target="#withdrawlfees" onclick="editwithfee(this);" href="#"><img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg">Edit</a></li><li><a class="dropdown-item" data-toggle="modal" data-target="#delete_row" onclick="setData(this)" href="#"><img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-delete.svg">Delete</a></li></ul></div>';
			  wit_table.row.add( [ daysBefore, daysBeforeExamValue, refundPercentage, wft_action ] ).draw();
			  /* $('#withdrawal_fee_table td:nth-child(2)').hide(); */
	        }
	        $("#withdrawlfees").removeData("editRow");
			$("#days_before_c").val('');
			$("#days_before_exam_value").val('');
			$("#cancellationfees_no_of_days_to").val('');
			$("#cancellationfees_no_of_days_from").val('');
			$("#cancellationfees_days_range").val('');
			$('#cancellationfees_no_of_days').val('')
			$("#refund_percentage").val('');
			$('#no_of_days_to').removeClass('d-none');
			$('#no_of_days_from').removeClass('d-none');	
			$('#no_of_days').addClass('d-none');
			$('#days_before_c_error').addClass('d-none');
			$('#refund_percentage_error').addClass('d-none');
			$('#days_before_number_error_c').addClass('d-none');
			$('#refund_number_error').addClass('d-none');
			$('#withdrawal_em_tb').addClass('d-none');
			}
		
		
		}
	 function saveRegularFee(event) {
		 var columnNames = [];
			$("#regularExam_table thead th").each(function(index) {
			   var columnName = $(this).attr('name');
			   columnNames.push(columnName);
			});
			 
			var tableData = [];
			var regularFeesData = reg_table.rows().data();
			regularFeesData.each(function(row,index) {
				console.log("row : ",row);
				var rowData = {};
				row.forEach(function(columnData, index2) {
		    		var columnName = columnNames[index2];
		    		if(columnName != "" || columnName != "actions")
			        rowData[columnName] = columnData;
				});
				tableData.push(rowData);
				
				$('#regular_em_tb').addClass('d-none')
			    var json = JSON.stringify({items:tableData});
			    console.log("jsonData"+json);
			    $("#regularExam_json_data").val(json);
			}); 
	 }
	 
	 function saveWithdrawalFee(event) {
		 
		var columnNames = [];
		$("#withdrawal_fee_table thead th").each(function(index) {
		   var columnName = $(this).attr('name');
		   columnNames.push(columnName);
		});
		 
		var tableData = [];
		var withdrawalFeesData = wit_table.rows().data();
		withdrawalFeesData.each(function(row,index) {
			console.log("row : ",row);
			var rowData = {};
			row.forEach(function(columnData, index2) {
				if(index2 != 0){
		    		var columnName = columnNames[index2];
		    		if(columnName != "" || columnName != "actions")
			        rowData[columnName] = columnData;		    		
		    	}
			});
			tableData.push(rowData);
			
			$('#withdrawal_em_tb').addClass('d-none')
		    var json = JSON.stringify({items:tableData});
		    console.log("jsonData"+json);
		    $("#withdrawal_fee_json_data").val(json);
		});
	 }
	 
	 function discardChanges(){
		 location.reload(true);
		 $("#exam-setup-discard").modal("hide");
	 }
	 function discardPopupElg() {
			$('#eligibility').val("");
			$('#exam_type_popUp').val("");
			$('#exam_type_error').addClass('d-none');
			$('#eligibility_error').addClass('d-none');
		}
		function discardPopupReg() {
			$('#regular_fee').val("");
			$('#regular_fee_error').addClass('d-none');
			$('#attempt_number_error').addClass('d-none');
		}
		function discardPopupWith() {
			$('#days_before').val("");
			$('#cancellationfees_no_of_days_from').val("");
			$('#cancellationfees_days_range').val("");
			$('#cancellationfees_no_of_days').val("");
			$('#cancellationfees_no_of_days_to').val("");
			$('#refund_percentage').val("");
			$('#refund_percentage_error').addClass('d-none');
			$('#days_before_error').addClass('d-none');
		}
		 /* function getEligbility(cmd){
		 var examTypeId = $("#exam_type").val();
		
		 var getTraineeLevelURL = "${getTraineeLevelURL}";
		 $.ajax({
				url: getTraineeLevelURL,
				dataType : 'json',
				async : false,
				data : {
					<portlet:namespace />examTypeId : examTypeId,
				},
				type : 'POST',
				success : function(data) {
					console.log("data"+data);
					var eligibilityList = data;
					$('#exam_eligibility').empty().val();
					/* $('#exam_eligibility').append("<option value=''><liferay-ui:message key="select-exam-eligibility"/></option> "); */
					/* $.each(eligibilityList, function (i, item) {
						 var selectedEligibility = "";
						 if(cmd === 'editExam'){
						 var eligibilities = ${examEligbilities}
						$.each(eligibilities, function (i, eligibility) {
	             			  if (item.examEligibilityKey == eligibility.examEligibilityKey) {
	                   		  console.log("inside exam exam elg edit functionality");
	                   		selectedEligibility = "selected";
	               			 } 
						 });
						 }
						$('#exam_eligibility').append("<option value='" + item.examEligibilityKey + "'" +selectedEligibility + ">" + item.examEligibility + "</option> ");
					})
					$('#exam_eligibility').multiselect('rebuild');
					},
				})
			}   */
	 
	 function getProgramId(cmd){
	 	var programTypeId = $("#program_type").val();
	 	var programs = ${programs}
		 console.log("programTypeId::"+programTypeId);
		 console.log("program::", programs);
		 var getProgramIdURL = "${getProgramIdURL}";
		 $.ajax({
				url: getProgramIdURL,
				dataType : 'json',
				async : false,
				data : {
					<portlet:namespace />programTypeId : programTypeId,
				},
				type : 'POST',
				success : function(data) {
					console.log("data"+data);
					var programList = data;
					$('#exam_type').empty().val();
					$('#exam_type').append("<option value=''><liferay-ui:message key="select-exam-type"/></option> ");
					$('#program').empty();
					/* $('#program').append("<option value=''><liferay-ui:message key="select-program-name"/></option> "); */
					$.each(programList, function (i, item) {
						 var selectedProgram = "";
							 $.each(programs, function (i, program) {
		             			  if (item.programId == program.programId && cmd === 'editExam') {
		                   		  console.log("inside exam program edit functionality");
		                          selectedProgram = "selected";
		               			 } 
							 });
						$('#program').append("<option value='" + item.programId + "'"+ selectedProgram + ">" + item.programName + "</option> ");
					})
					$('#program').multiselect('rebuild');
					},
					
				})
			}
	 
	 function getExamType(cmd){
		 var programId = $("#program").val();
		 var examTypeId = '${exam.examTypeId}';
		 console.log("programId for ALL::"+programId);
		 var programTypeId = $("#program_type").val();
		 console.log("programTypeId::"+programTypeId);
		 var getExamTypeURL = "${getExamTypeURL}";
		 $.ajax({
				url: getExamTypeURL,
				dataType : 'json',
				async : false,
				data : {
					<portlet:namespace />programTypeId : programTypeId,
					<portlet:namespace />programId : programId,
				},
				type : 'POST',
				success : function(data) {
					console.log("datas"+data);
					var examTypeList = data;
					$('#exam_type').empty().val();
					$('#exam_type_popUp').empty();
					$('#exam_type').append("<option value=''><liferay-ui:message key="select-exam-type"/></option> ");
					$('#exam_type_popUp').append("<option value=''><liferay-ui:message key="select-exam-type"/></option> ");
					$.each(examTypeList, function (i, item) {
						var selectedExamType = "";
						 if (item.examTypeId === examTypeId && cmd == 'editExam') {
							  console.log("inside exam type edit functionality"); 
							 selectedExamType = "selected";
							  }
						$('#exam_type').append("<option value='" + item.examTypeId + "'"+ selectedExamType +">" + item.examTypeName + "</option> ");
						$('#exam_type_popUp').append("<option value='" + item.examTypeId + "' data-attribute='" + item.examTypeName +"'>" + item.examTypeName + "</option> ");
					})
				}
				})
			}
		 
	
	function editregfee(link) {
		  var row = $(link).closest("tr"); 
		  var attemptNoCell = row.find("td:nth-child(1)"); 
		  var regularFeeCell = row.find("td:nth-child(2)"); 
		  $(link).closest(".show").removeClass('show');
		  var attemptNumber = attemptNoCell.text(); 
		  var regularFee = regularFeeCell.text(); 

		  $("#attempt_number").val(attemptNumber);
		  $("#regular_fee").val(regularFee);
		  
		  $("#regular_fee_modal").data("editRow", row);
		}
	
	// Edit Cancellation Fees
	function editwithfee(link) {
		
		$('#days_before_c_error').addClass('d-none')
		  var row = $(link).closest("tr"); 
		  var daysBeforeTextCell = row.find("td:nth-child(1)"); 
		  var daysBeforeCell = row.find("td:nth-child(2)"); 
		  var refundPercentageCell = row.find("td:nth-child(3)"); 
		  
		  var daysBeforeArray = "";
		  var noOfDaysFrom = "";
		  var noOfDaysTo = "";
		  var noOfDays = "";
		  var selectedRangeOption = "";
		  
		  
			console.log("daysBeforeCell:"+daysBeforeCell)
		  	var daysBefore = daysBeforeCell.text().trim(); 
			var daysBeforeText = daysBeforeTextCell.text().trim();
			if(daysBefore.includes("-")){
				$('#no_of_days').addClass('d-none');
				$('#no_of_days_to').removeClass('d-none');
				$('#no_of_days_from').removeClass('d-none');
				
				daysBeforeArray = daysBefore.split("-");
				noOfDaysFrom = daysBeforeArray[0].trim();
		 		noOfDaysTo= daysBeforeArray[1].trim();
				selectedRangeOption = "-";
				$('#cancellationfees_no_of_days_from').val(noOfDaysFrom);
				$('#cancellationfees_no_of_days_to').val(noOfDaysTo);
			}else{
				$('#no_of_days').removeClass('d-none');
				$('#no_of_days_to').addClass('d-none');
				$('#no_of_days_from').addClass('d-none');
				
				daysBeforeArray = daysBefore.split(" ");
				selectedRangeOption = daysBeforeArray[0].trim();
				noOfDays =daysBeforeArray[1].trim();
				$('#cancellationfees_no_of_days').val(noOfDays);
			}
			
			
	 	 $('#cancellationfees_days_range').val(selectedRangeOption);
		 $("#days_before_c").val(daysBeforeText);
		 $("#days_before_exam_value").val(daysBefore);
		 
		 var refundPercentage = refundPercentageCell.text(); 
		  $(link).closest(".show").removeClass('show');
		  $("#days_before").val(daysBeforeText);
		  $("#days_before_exam_value").val(daysBefore);
		  $("#refund_percentage").val(refundPercentage);
		  
		  $("#withdrawlfees").data("editRow", row);
		}
	
	
	function setData(link){
		var row = $(link).closest("tr");
		$(link).closest("tr").addClass("select_delete_row");
		var tableId = $(link).closest("tr").closest("table").attr("id");
		$("#delete_row").attr("delete_table_id",tableId);
	 		$("#delete_row").data("row", row);
	}
	function deleteRow() {
		var rowId = $("#delete_row").attr("delete_table_id");
		const table = new DataTable('#'+rowId);
		var row = $("#delete_row").data("row");
		 // row.remove();
		  table.row('.select_delete_row').remove().draw(false);
		  var deleteModal = $("#delete_row");
			deleteModal.modal('hide');
	}
	
	function deleteMatchingRows(selectedEligibility, selectedExamType) {
	    $("#eligibility_table tbody tr").each(function () {
	        var rowExamType = $(this).find("td:nth-child(1)").attr("data-value");
	        var rowEligibility = $(this).find("td:nth-child(2)").attr("data-value");
	        console.log("rowExamType :"+rowExamType+"rowEligibility:"+rowEligibility);

	        if (rowEligibility === selectedEligibility && rowExamType === selectedExamType) {
	            $(this).remove();
	        }
	    });
	}
	var existExamConfirm = $("#exist-exam-setup");
	function getExistExam(event){
		 var getExistExamURL = "${getExistExamURL}";
		 var cmd = "${cmd}";
		 var programId = $("#program").val();
		 var examTypeId = $("#exam_type").val();
		 console.log("programId:"+programId, "examTypeId : ", examTypeId)
		 $.ajax({
				url: getExistExamURL,
				dataType : 'json',
				async : false,
				data : {
					<portlet:namespace />programId : programId,
					<portlet:namespace />examTypeId : examTypeId,
				},
				type : 'POST',
				success : function(data) {
					console.log("data"+data);
					var existExams = data;
					$.each(existExams, function (i, item) {
						console.log(item.existExam)
						if(item.existExam >0 && cmd == 'addExam'){
							existExamConfirm.find(".modal-content .modal-header p").text(item.examTypeName);
							existExamConfirm.modal('show');
							event.preventDefault();
							$("#exist_exam").val(item.existExam);
							console.log("exist exam id:"+$("#exist_exam").val())
							$("#yes_btn").on("click", function() {
								 document.getElementById("save_exam").submit();
							}) 
							$("#no_btn").on("click", function() {
								event.preventDefault();
							}) 
						} else{
							 document.getElementById("save_exam").submit();
						}
					});
					},
					error: function(jqXHR, textStatus, errorThrown) {
				        console.log("AJAX Error: " + textStatus + " - " + errorThrown);
				    }
				})
	}
 
	/*  Start Validate the Set UP Exam Form */
	
	function validateTableDataPresent(id,errorId){
		if( $('#'+id+' tbody tr').length > 0 ) {
			 $('#'+errorId).addClass('d-none');
			 return true;
		}else{
			 $('#'+errorId).removeClass('d-none');
			 return false;
		}
	}
	
	function validateSelectAndInputField(id,errorId){
		var keyVal = $('#'+id).val();
	    if (keyVal != undefined && keyVal != '') {
	        $('#'+errorId).addClass('d-none');
	        return true;
	    } else {
	        $('#'+errorId).removeClass('d-none');
	        return false;
	    }
	}
	
	function closePopUp(){
		 $('#exam_type_error').addClass('d-none');
		 $('#eligibility_error').addClass('d-none');
		 
		 $('#attempt_number_error').addClass('d-none');
		 $('#regular_fee_error').addClass('d-none');
		 
		 $('#days_before_error').addClass('d-none');
		 $('#refund_percentage_error').addClass('d-none');
		 
		// $('#refund_percentage').val('');
	}

	$('#regular_fee_modal , #addexam , #withdrawlfees ').on('hidden.bs.modal', function (e) {
		 closePopUp();
	})
	
	function validateSetUpExamForm() {
		
		/* var program_type = validateSelectAndInputField('program_type','program_type_val_error');
		var program = validateSelectAndInputField('program','program_name_val_error'); */
		var exam_type = validateSelectAndInputField('exam_type','et_error');
		/* var exam_eligibility = validateSelectAndInputField('exam_eligibility','elg_val_error'); */
		var result_source = validateSelectAndInputField('result_source','res_val_error');
		
		//Exam Eligibility 2
		/* var eligibility_table = validateTableDataPresent('eligibility_table','eligibility_table_error'); */
		
		var applicable_days = validateSelectAndInputField('applicable_days','early_bd_val_error');
		var fee_amount = validateSelectAndInputField('fee_amount','eb_fee_val_error');
		
		var regularExam_table = validateTableDataPresent('regularExam_table','regular_em_tb');
		var withdrawal_fee_table = validateTableDataPresent('withdrawal_fee_table','withdrawal_em_tb');
		
		var appeal_window = validateSelectAndInputField('appeal_window','appeal_wnd_val_error');
		var appeal_fees = validateSelectAndInputField('appeal_fees','appeal_fees_val_error');
		var re_appeal_window = validateSelectAndInputField('re_appeal_window','re_app_wnd_val_error');
		var re_appeal_fees = validateSelectAndInputField('re_appeal_fees','re_app_fees_val_error');
	/* 	&& exam_eligibility */
		if (exam_type
				&& result_source
				&& applicable_days && fee_amount
				&& regularExam_table && withdrawal_fee_table
				&& appeal_window && appeal_fees
				&& re_appeal_window && re_appeal_fees) {
			return true;

		} else {
			return false;
		}
	}
	/*  End Validate the Set UP Exam Form */
	$("#save_exam").submit(function (event) {
	    if (!validateSetUpExamForm()) {
	        event.preventDefault();
	    } else{
	    	event.preventDefault();
	    	 getExistExam(event);
	    }
	});
	function regularFeeCount(){
		console.log(" : : regularFeeCount ; : "+reg_table.data().rows().count());
		$("#attempt_number").val(reg_table.data().rows().count()+1);
	}
	
/* 	$("#program").on("change", function(){ */
		function handleProgramChange() {
		var selectedPrograms = [];
		var programButton = $("#program").next(".btn-group").find(".multiselect-option");
		programButton.addClass("programCheckbox");
		$(".programCheckbox").each(function(){
		console.log($(".programCheckbox").children().children().text());			
	    if($(this).hasClass('active')){
	    	console.log("it is active");
	      var programId = $(this).children().children().val();
	      var programName= $(this).children().children().text();
	      console.log("program name selected one ::"+programName);
	      selectedPrograms.push({ programId: programId, programName: programName });
 	 	}
	});
	console.log("selectedPrograms::"+selectedPrograms)
	 var json = JSON.stringify({items:selectedPrograms});
	console.log("json::"+json)
	$("#program_json_data").val(json);
};  

$("#program").on("change", handleProgramChange);

	
	
function handleExamTypeChange() {
	var examEligibility = [];
	var examEligibilityButton = $("#exam_eligibility").next(".btn-group").find(".multiselect-option");
	examEligibilityButton.addClass("examElgCheckbox");
	$(".examElgCheckbox").each(function(){
	if($(this).hasClass('active')){
	  var examEligibilityKey = $(this).children().children().val();
	  var examEligibilityName= $(this).children().children().text();
	  console.log("examEligibilityName selected one ::"+examEligibilityName);
	  examEligibility.push({ examEligibilityKey: examEligibilityKey, examEligibilityName: examEligibilityName });
		}
	});
	var json = JSON.stringify({items:examEligibility});
	console.log("json::"+json)
	$("#examElg_json_data").val(json);
	};


/* $("#exam_eligibility").on("change", handleExamTypeChange); */
	
$(".close-regular-fee").on("click", function(){
	 $("#regular_fee_modal").removeData("editRow");

	});	
	
$(".close-withdrawal-fee").on("click", function(){
	 $("#withdrawlfees").removeData("editRow");
	 $("#cancellationfees_input_3").val('');
	 $("#cancellationfees_no_of_days_from").val('');
	 $("#cancellationfees_days_range").val('');

	});
	
function getbyLawRule(){
	 var examEligibility = $("#exam_eligibility").val();
	 console.log("examEligibility::"+examEligibility);
	 var getByLawRuleUrl = "${getByLawRuleUrl}";
	 $.ajax({
			url: getByLawRuleUrl,
			dataType : 'json',
			async : false,
			data : {
				<portlet:namespace />examEligibility : examEligibility,
			},
			type : 'POST',
			success : function(data) {
				console.log("datas"+data);
				var bylawRule = data;
				$.each(bylawRule, function (i, item) {
					
				console.log("data to string",JSON.stringify(data));
				console.log("byLawCondition",item.examEligibility);
				$("#bylawrule").text(item.examEligibility);
				});
				}
			})
		}

function checkedRule(){
	 var examType = $("#exam_type option:selected").text();
	 var bylawId = $("#exam_eligibility").val();
	 console.log("examType::"+examType);
	 var getSuggestedRulesURL = "${getSuggestedRulesURL}";
	 $.ajax({
			url: getSuggestedRulesURL,
			dataType : 'json',
			async : false,
			data : {
				<portlet:namespace />examType : examType,
				<portlet:namespace />bylawId : bylawId,
			},
			type : 'POST',
			success : function(data) {
				console.log("datas"+data);
				var suggestedRule = data;
				var suggestedRules = data.map(function (item) {
	                return item.suggestedRule;
	            });
	            var commaSeparatedRules = suggestedRules.join(", "); 
	            console.log("suggestedRule", commaSeparatedRules);
	            $("#suggestedRule").text("Suggested Rule :"+commaSeparatedRules);
				}
			})
		}
	 
</script>
	
	
	

