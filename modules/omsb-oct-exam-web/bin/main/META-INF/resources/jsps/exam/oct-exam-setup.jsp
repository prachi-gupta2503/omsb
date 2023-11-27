<%@include file = "/init.jsp" %>
<portlet:resourceURL id="<%=MVCCommandNames.GET_OCT_EXAM_FORM%>" var="getExamURL">
	<portlet:param name="cmd" value="getExamForm" />
</portlet:resourceURL>

<portlet:resourceURL id="<%=MVCCommandNames.GET_OCT_EXAM_FORM%>" var="getExistExamURL">
	<portlet:param name="cmd" value="getExistExam" />
</portlet:resourceURL>

<portlet:actionURL name="exam/save_exam_setup" var="saveExamsURL" />
<form action="${saveExamsURL}" method="post" name="saveExams" id="save_exam" enctype="multipart/form-data">
<div id="wrapper">
	<div class="container">
		<div class="omsb-card">
			<div class="omsb-page-top-info">
				<div class="pagetitle"><liferay-ui:message key="set-up-exam"/></div>
			</div>
			<div class="omsb-list-filter">
				<div class="row">
					<div class="col-lg-4 col-md-6">
						<div class="form-group">
						 <input type="hidden" value="" name="<portlet:namespace/>existExam" id="exist_exam">
						 <input type="hidden" value="${examJsonFields.id }" name="<portlet:namespace/>octExamId" >
							<label class="required"><liferay-ui:message key="exam-title"/></label>
                                     <select name="<portlet:namespace/>examTitle" onchange="validateSelectAndInputField('exam_title','exam_title_error');" id="exam_title" class="form-control">
	                                      <option value=""><liferay-ui:message key="select-exam-title"/></option>
	                                         <c:forEach var="examTitle" items="${examTitles}" >
		                                         <c:set var="selected" value="${examJsonFields != null && examJsonFields.examTitleId == examTitle.listTypeEntryId}" />
                                         		<option value="${examTitle.listTypeEntryId}" <c:if test="${selected}">selected="selected"</c:if>>${examTitle.name}</option>
                                         	</c:forEach>
                                     </select>
                            <span class="d-none text-danger" id="exam_title_error"><liferay-ui:message key="the-exam-title-field-is-required"/></span>
						</div>
					</div>
                    <div class="col-lg-4 col-md-6">
						<div class="form-group">
                             <label class="required"><liferay-ui:message key="duration-of-exam-in-hours"/></label>
							     <input type="text" value="${examJsonFields.examDuration }"   onkeyup="validateSelectAndInputField('duration_of_exam','duration_of_exam_error')"  
	                             onkeypress="return /[1-9]+$/i.test(event.key)" maxlength="1"
	                             name="<portlet:namespace/>durationOfExam" id="duration_of_exam" placeholder="<liferay-ui:message key="duration-of-exam"/>" class="form-control">
                             <span class="d-none text-danger" id="duration_of_exam_error"><liferay-ui:message key="the-duration-of-exam-field-is-required"/></span>
						</div>
					</div>
                    <div class="col-lg-4 col-md-6">
						<div class="form-group">
							<label class="required"><liferay-ui:message key="cut-score"/></label>
	                            <input type="text" value="${examJsonFields.cutScore }" onkeyup="validateSelectAndInputField('cut_score','cut_score_error')" 
	                            onkeypress="return /[0-9]+$/i.test(event.key)" maxlength="3"
	                            name="<portlet:namespace/>cutScore" id="cut_score" placeholder="<liferay-ui:message key="cut-score"/>" class="form-control">
                            <span class="d-none text-danger" id="cut_score_error"><liferay-ui:message key="the-cut-score-field-is-required"/></span>
						</div>
					</div>
                    <div class="col-lg-4 col-md-6">
						<div class="form-group">
							<!-- class="required" -->
							<label ><liferay-ui:message key="score-validity"/></label>
								<!-- onkeyup="validateSelectAndInputField('score_validity','score_validity_error')" -->
	                            <input type="text" value="${examJsonFields.scoreValidity }" 
	                            onkeypress="return /[0-9]+$/i.test(event.key)" maxlength="3"
	                            name="<portlet:namespace/>scoreValidity" id="score_validity" placeholder="<liferay-ui:message key="score-validity"/>" class="form-control">
                            <span class="d-none text-danger" id="score_validity_error"><liferay-ui:message key="the-score-validity-field-is-required"/></span>
						</div>
					</div>
                    <div class="col-lg-4 col-md-6">
						<div class="form-group">
							<!-- class="required" -->
							<label><liferay-ui:message key="registration-cut-off-window-in-hours"/><img src="<%=themeDisplay.getPathThemeImages()%>/svg/i-button.svg" alt="info" data-toggle="tooltip" data-placement="top" title="registration-cut-off"></label>
								 <!-- onkeyup="validateSelectAndInputField('reg_cut_off','reg_cut_off_error')" -->
	                            <input type="text" value="${examJsonFields.cutOffWindow }"  
	                            onkeypress="return /[0-9]+$/i.test(event.key)" maxlength="3"
	                            name="<portlet:namespace/>registrationCutOfWindow" id="reg_cut_off" placeholder="<liferay-ui:message key="registration-cut-off"/>" class="form-control">
                            <span class="d-none text-danger" id="reg_cut_off_error"><liferay-ui:message key="the-cut-off-field-is-required"/></span>
						</div>
					</div>
                    <div class="col-lg-4 col-md-6">
						<div class="form-group">
							<label class="required"><liferay-ui:message key="result-source"/></label>
                                  <select name="<portlet:namespace/>resultSource" id="result_source" onchange="validateSelectAndInputField('result_source','result_source_error');" class="form-control">
                                       <option value=""><liferay-ui:message key="select-result-source"/></option>
	                                       	<c:forEach var="resultSource" items="${resultSource}" >
		                                        <c:set var="selected" value="${examJsonFields != null && examJsonFields.resultSource == resultSource.listTypeEntryId}" />
		                                         <option value="${resultSource.listTypeEntryId}"<c:if test="${selected}">selected="selected"</c:if>>${resultSource.name}</option>
	                                        </c:forEach>
                                  </select>
                             <span class="d-none text-danger" id="result_source_error"><liferay-ui:message key="the-result-source-field-is-required"/></span>
						</div>
					</div>
	                <div class="col-lg-4 col-md-6">
                        <div class="form-group">
                         	<!-- class="required" -->
                            <label><liferay-ui:message key="auto-rescheduling-period"/></label>
                            	<!-- onkeyup="validateSelectAndInputField('reschedule_period','reschedule_period_error');" --> 	
	                            <input type="text" value="${examJsonFields.autoSchedulingPeriod }" maxlength="3"
	                            onkeypress="return event.charCode >= 48 && event.charCode <= 57"
	                            placeholder="<liferay-ui:message key="auto-rescheduling-period"/>" name="<portlet:namespace/>reSchedulePeriod" id="reschedule_period"  class="form-control">
                            <span class="d-none text-danger" id="reschedule_period_error"><liferay-ui:message key="the-resheduling-period-field-is-required"/></span>
                        </div>
		            </div>
				</div>						
			</div>
                     
			<div class="omsb-card omsb-card-graybg">
				<h4 class="omsb-card-title"><liferay-ui:message key="exam-blueprint"/>
                   <button class="btn omsb-bg-red-button" data-toggle="modal" data-target="#addsupportingdocument" type="button"><img src="<%=themeDisplay.getPathThemeImages()%>/svg/plus_img.svg" alt=""><liferay-ui:message key="add-row"/></button>
                </h4>
				<div class="omsb-list-view table-responsive">
					<input type="hidden" name="<portlet:namespace/>blueprint" id="<portlet:namespace/>blueprint" class="d-none">
                           <table class="omsb-datatables dataTable" id="supporting-documents-tb">
								<thead>
									<tr>
										<th data-name="blueprintTitle"><liferay-ui:message key="document-title"/></th>
										<th data-name="name"><liferay-ui:message key="supporting-document"/></th>
										<th data-name="file" class="d-none"><liferay-ui:message key="document-file"/></th>
										<th data-name=rowNumber class="d-none"><liferay-ui:message key="document-file"/></th>
										<th data-name="actions"><liferay-ui:message key="action"/></th>
									</tr>
								</thead>
								 <c:if test="${cmd == 'addExam'}">
									<tbody>
									</tbody>
								</c:if>
								<c:if test="${cmd == 'editExam'}">
									<tbody>
										<c:forEach var="octExamBlueprint" items="${examJsonFields.octExamBlueprints}" >
											<tr>
												<td data-name="${octExamBlueprint.blueprintTitle}">${octExamBlueprint.blueprintTitle}</td>
												<td data-name="${octExamBlueprint.name}">${octExamBlueprint.name}</td>									      
												<td>
													<div class="dropdown ">
														<button class="btn fa fa-ellipsis-v dropdown-toggle" type="button"
															data-toggle="dropdown" aria-expanded="false">
															<i class=""></i>
														</button>
														<ul class="dropdown-menu">
															<li><a href="#" class="dropdown-item" data-toggle ="modal" data-target ="#addsupportingdocument" onclick="addTableRow()"><img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg"><liferay-ui:message key="edit"/></a></li>
															<li><a href="#" class="dropdown-item" data-toggle ="modal" data-target ="#delete_row" onclick="setData(this)"><img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-delete.svg"> <liferay-ui:message key="delete"/></a></li>
														</ul>
													</div>
												</td>									      
											 </tr>
										</c:forEach>
									</tbody>
								</c:if>
						</table>
                   </div>
                   <span class="text-danger d-none" id="examBluePrintTable_error" ><liferay-ui:message key="the-blueprint-document-field-is-required"/></span>
			</div>

            <div class="omsb-list-filter">
				<div class="row">
					<input type="hidden" name="<portlet:namespace/>examForms" id="exam_form_nos">
					<div class="col-lg-12 col-md-12">
						<div class="form-group">
							<label class="required"><liferay-ui:message key="exam-form-no"/></label>
	                             <input type="text" placeholder="<liferay-ui:message key="exam-form-no"/>" onkeyup="validateSelectAndInputField('exam_form_no','exam_form_no_error');" 
	                             onkeypress="return /[0-9]+$/i.test(event.key)" maxlength="3"
	                             value="${examJsonFields.examFormNo }" name="<portlet:namespace/>examFormNo" oninput="checkFormNumber()" id="exam_form_no" class="form-control">
                             <span class="d-none text-danger" id="exam_form_no_error"><liferay-ui:message key="the-exam-form-no-field-is-required"/></span>
						</div>
					</div>
                    <div class="col-lg-6 col-md-6">
						<div class="form-group">
							<label class="required"><liferay-ui:message key="exam-form-nos"/></label>
                                <select name="<portlet:namespace/>examFormNos" id="exam_form"  class="form-control">
                                  <option value=""><liferay-ui:message key="select-exam-form"/></option>
                                </select>
                            <span class="d-none text-danger" id="exam_form_error"><liferay-ui:message key="the-exam-form-field-is-required"/></span>
						</div>
					</div>
                    <div class="col-lg-6 col-md-6">
						<div class="form-group">
							<label class="required"><liferay-ui:message key="status"/></label>
                               <select name="<portlet:namespace/>status" onchange="getStatus()" id="status" class="form-control">
                                   <c:forEach var="examStatus" items="${examStatus}" >
                                  	 <option value="${examStatus.listTypeEntryId}">${examStatus.name}</option>
                                   </c:forEach>
                               </select>
                            <span class="d-none text-danger" id="status_error"><liferay-ui:message key="the-status-field-is-required"/></span>
						</div>
					</div>
				</div>						
			</div>

            <div class="omsb-card omsb-card-graybg">
                <div class="row">
                      <div class="col-lg-6 col-md-6 col-sm-12">
                           <div class="form-group">
                                 <label class="required"><liferay-ui:message key="locate-in-google"/></label>
                                   <input type="text" placeholder="<liferay-ui:message key="locate-google"/>" name="<portlet:namespace/>k"
									id="locateOnGoogleMap"  onkeyup="validateSelectAndInputField('locateOnGoogleMap','locateOnGoogleMap_error')"  
                         			data-place="${examJsonFields.locationOnGoogleMap}" class="form-control autocompleteMap">
									<input type="hidden" name="<portlet:namespace />locationOnGoogleMap" class="placeIdMap"
									id="<portlet:namespace />locationOnGoogleMap" value="${examJsonFields.locationOnGoogleMap}">
                                 <span class="d-none text-danger" id="locateOnGoogleMap_error"><liferay-ui:message key="the-locate-field-is-required"/></span>
                             </div>
                       </div>
                       <div class="col-lg-6 col-md-6 col-sm-12">
                           <div class="form-group">
                               <label class="required"><liferay-ui:message key="venue"/></label>
                                   <input type="text" placeholder="<liferay-ui:message key="venue"/>" onkeyup="validateSelectAndInputField('venue','venue_error')" 
                                   value="${examJsonFields.venue }" name="<portlet:namespace/>venue" id="venue" class="form-control">
                                <span class="d-none text-danger" id="venue_error"><liferay-ui:message key="the-venue-field-is-required"/></span>
                           </div>
                        </div>
                        <div class="col-lg-12 col-md-12 col-sm-12">
							<div id="map" class="omsb-map-h250"></div>
							<div id="infoWindowContent">
					    		<span id="place-name" class="label-name"></span><br />
								<span id="place-address"></span>
					    	</div>
						</div>
                   </div>
              </div>

              <div class="omsb-card omsb-card-graybg">
                  <h4 class="omsb-card-title"><liferay-ui:message key="early-bird-fees"/></h4>
                      <div class="row">
                            <div class="col-lg-6 col-md-6 col-sm-12">
                                <div class="form-group">
                                    <label class="required" ><liferay-ui:message key="applicable-days"/><img src="<%=themeDisplay.getPathThemeImages()%>/svg/i-button.svg" alt="info" data-toggle="tooltip" data-placement="top" title="Number of Days Before Exam Start Date"></label>
	                                    <input value="${examJsonFields.earlyBirdFeesDate }"  onkeyup="validateSelectAndInputField('applicabledate','applicabledate_error');" maxlength="3"
	                                    onkeypress="return /[0-9]+$/i.test(event.key)" maxlength="3"
	                                     placeholder="<liferay-ui:message key="early-bird-fees"/>" type="text" name="<portlet:namespace/>applicableDays" id="applicabledate"  class="form-control">
                                    <span class="d-none text-danger" id="applicabledate_error"><liferay-ui:message key="the-applicable-days-field-is-required"/></span>
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-12">
                                <div class="form-group">
                                    <label class="required"><liferay-ui:message key="fee-amount-in-omr"/></label>
                                    <input type="text" value="${examJsonFields.earlyBirdFees }" maxlength="10"
                                    placeholder="<liferay-ui:message key="fee-amount-in-omr"/>" name="<portlet:namespace/>feeAmount" id="fee_amount"  class="form-control">
                                    <span class="d-none text-danger" id="fee_amount_error"><liferay-ui:message key="the-fee-amount-field-is-required"/></span>
                                </div>
                            </div>
                        </div>
               </div>

               <div class="omsb-card omsb-card-graybg">
				<div class="omsb-card-title">
                   <h4 ><liferay-ui:message key="regular-fees"/></h4>
                   <button class="btn omsb-bg-red-button" data-toggle="modal" onclick="regularFeeCount()" data-target="#regular_fee_modal" type="button"><img src="<%=themeDisplay.getPathThemeImages()%>/svg/plus_img.svg" alt=""><liferay-ui:message key="add-row"/></button>
                </div>
				<div class="omsb-list-view table-responsive">
			 		<input type="text" name="<portlet:namespace/>regularFeeJsonData" id="regularExam_json_data" class="d-none">
			 		 <span class="d-none text-danger" id="regular_em_tb"><liferay-ui:message key="the-regular-fee-field-is-required"/></span>
                            <table class="display omsb-datatables" id="regularExam_table">
                                <thead>
                                    <tr>
                                        <th name="noOfAttempt"><liferay-ui:message key="attempt-number"/></th>
                                        <th name="regularFees"><liferay-ui:message key="regular-fees-amount-in-omr"/></th>
                                        <th><liferay-ui:message key="action"/></th>                                            
                                    </tr>
                                </thead>
                                <c:if test="${cmd == 'addExam'}">
									<tbody>
									</tbody>
							    </c:if>
								<c:if test="${cmd == 'editExam'}">
									<tbody>
										<c:forEach var="octRegularFee"items="${examJsonFields.octRegularFees}" >
											<tr>
												<td data-value="${octRegularFee.noOfAttempt}">${octRegularFee.noOfAttempt}</td>
												<td data-value="${octRegularFee.regularFees}">${octRegularFee.regularFees}</td>									      
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
                    <span class="text-danger d-none" id="regularTable_error" ><liferay-ui:message key="the-regular-fees-field-is-required"/></span>
				</div>

                <div class="omsb-card omsb-card-graybg">
					<h4 class="omsb-card-title"><liferay-ui:message key="rescheduling-fees"/>
                        <button class="btn omsb-bg-red-button" data-toggle="modal" data-target="#reschedulingfees" type="button"><img src="<%=themeDisplay.getPathThemeImages()%>/svg/plus_img.svg" alt=""><liferay-ui:message key="add-row"/></button>
                    </h4>
			           <div class="omsb-list-view table-responsive">
			            <input type="text" name="<portlet:namespace/>rescheduleFeeJsonData" id="reschedule_fee_json_data" class="d-none">
			            <span class="d-none text-danger" id="reschedule_em_tb"><liferay-ui:message key="the-resheduling-fee-field-is-required"/></span>
                            <table class="display omsb-datatables" id="rescheduling_table">
                                <thead>
                                    <tr>
                                        <th name="noOfDaysText"><liferay-ui:message key="days-before-exam"/></th>
                                        <th name="noOfDays" class="d-none"></th>
                                        <th name="reschedulingFeesPercentage"><liferay-ui:message key="refund-percentage"/></th>
                                        <th name="action"><liferay-ui:message key="action"/></th>                                            
                                    </tr>
                                </thead>
                               <c:if test="${cmd == 'addExam'}">
										<tbody>
										</tbody>
								</c:if>
									<c:if test="${cmd == 'editExam'}">
										<tbody>
											<c:forEach var="octRescheduleFee"items="${examJsonFields.octRescheduleFees}" >
												<tr>
													<td data-value="${octRescheduleFee.noOfDaysText}">${octRescheduleFee.noOfDaysText}</td>
													<td data-value="${octRescheduleFee.noOfDays}">${octRescheduleFee.noOfDays}</td>
													<td data-value="${octRescheduleFee.reschedulingFeesPercentage}">${octRescheduleFee.reschedulingFeesPercentage}</td>									      
													<td>
														<div class="dropdown ">
															<button class="btn fa fa-ellipsis-v dropdown-toggle" type="button"
																data-toggle="dropdown" aria-expanded="false">
																<i class=""></i>
															</button>
															<ul class="dropdown-menu">
																<li><a href="#" class="dropdown-item" data-toggle ="modal" data-target ="#reschedulingfees" onclick="reschedulefees(this);"><img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg"><liferay-ui:message key="edit"/></a></li>
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
                        <span class="text-danger d-none" id="rescheduleTable_error" ><liferay-ui:message key="the-reschedule-fees-field-is-required"/></span>
				</div>

                <div class="omsb-card omsb-card-graybg">
					<h4 class="omsb-card-title"><liferay-ui:message key="cancellation-fees"/>    
                       <button class="btn omsb-bg-red-button" data-toggle="modal" data-target="#cancellationfees" type="button"><img src="<%=themeDisplay.getPathThemeImages()%>/svg/plus_img.svg" alt=""><liferay-ui:message key="add-row"/></button>
                     </h4>
			<div class="omsb-list-view table-responsive">
				<input type="text" name="<portlet:namespace/>cancellationFeeJsonData" id="cancellation_fee_json_data" class="d-none">
				<span class="d-none text-danger" id="cancellation_em_tb"><liferay-ui:message key="the-cancellation-fee-field-is-required"/></span>
                	 <table class="display omsb-datatables" id="cancellationFee_table">
	                     <thead>
	                         <tr>
	                            <th name="noOfDaysText"><liferay-ui:message key="days-before-exam"/></th>
								<th name="noOfDays" class="d-none"></th>
	                            <th name="cancellationFeesPercentage" ><liferay-ui:message key="refund-percentage"/></th>
	                            <th name="actions"><liferay-ui:message key="action"/></th>                                             
	                         </tr>
	                     </thead>
                    	 <c:if test="${cmd == 'addExam'}">
								<tbody>
								</tbody>
						</c:if>
						<c:if test="${cmd == 'editExam'}">
							<tbody>
								<c:forEach var="octExamCancellationFee"items="${examJsonFields.octExamCancellationFees}" >
									<tr>
										<td data-value="${octExamCancellationFee.noOfDaysText}">${octExamCancellationFee.noOfDaysText}</td>
										<td data-value="${octExamCancellationFee.noOfDays}">${octExamCancellationFee.noOfDays}</td>
										<td data-value="${octExamCancellationFee.cancellationFeesPercentage}">${octExamCancellationFee.cancellationFeesPercentage}</td>		
										<td>
											<div class="dropdown ">
												<button class="btn fa fa-ellipsis-v dropdown-toggle" type="button"
													data-toggle="dropdown" aria-expanded="false">
													<i class=""></i>
												</button>
												<ul class="dropdown-menu">
													<li><a href="#" class="dropdown-item" data-toggle ="modal" data-target ="#cancellationfees" onclick="cancellationfees(this);"><img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg"><liferay-ui:message key="edit"/></a></li>
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
               <span class="text-danger d-none" id="cancellationFee_table_error" ><liferay-ui:message key="the-cancellation-fees-field-is-required"/></span>
		</div>
        <div class="omsb-list-filter">
			<div class="row">
				<div class="col-lg-6 col-md-6">
					<div class="form-group">
						<label class="required"><liferay-ui:message key="appeal-window"/><img src="<%=themeDisplay.getPathThemeImages()%>/svg/i-button.svg" alt="info" data-toggle="tooltip" data-placement="top" title="Number of Days After Results Are Announced"> </label>
	                         <input value="${examJsonFields.appealWindow }" onkeyup="validateSelectAndInputField('appeal_window','appeal_window_error')" maxlength="10" 
	                         onkeypress="return event.charCode >= 48 && event.charCode <= 57" placeholder="<liferay-ui:message key="appeal-window"/>" type="text" id="appeal_window" name="<portlet:namespace/>appealWindow" class="form-control">
	                      <span class="d-none text-danger" id="appeal_window_error"><liferay-ui:message key="the-appeal-window-field-is-required"/></span>
					</div>
				</div>
                <div class="col-lg-6 col-md-6">
					<div class="form-group">
						<label class="required"><liferay-ui:message key="appeal-fees-in-omr"/> </label>
                             <input type="text" value="${examJsonFields.appealFees }" onkeyup="validateSelectAndInputField('appeal_fees','appeal_fee_error')" maxlength="10"  
                             onkeypress="return event.charCode >= 48 && event.charCode <= 57" placeholder="<liferay-ui:message key="appeal-fees-in-omr"/>" name="<portlet:namespace/>appealFees" id="appeal_fees" class="form-control" >
	                    <span class="d-none text-danger" id="appeal_fee_error"><liferay-ui:message key="the-appeal-fees-field-is-required"/></span>
					</div>
				</div>
                <div class="col-lg-6 col-md-6">
					<div class="form-group">
						<label class="required"><liferay-ui:message key="re-appeal-window"/><img src="<%=themeDisplay.getPathThemeImages()%>/svg/i-button.svg" alt="info" data-toggle="tooltip" data-placement="top" title="Number of Days After Results Are Announced"> </label>
	                        <input type="text" value="${examJsonFields.reAppealWindow }"  onkeyup="validateSelectAndInputField('reappeal_window','reappeal_window_error')" maxlength="10"
	                         onkeypress="return event.charCode >= 48 && event.charCode <= 57" placeholder="<liferay-ui:message key="re-appeal-window"/>" name="<portlet:namespace/>reAppealWindow" id="reappeal_window" class="form-control">
		                <span class="d-none text-danger" id="reappeal_window_error"><liferay-ui:message key="the-re-appeal-window-field-is-required"/></span>
					</div>
				</div>
                <div class="col-lg-6 col-md-6">
					<div class="form-group">
						<label class="required"><liferay-ui:message key="re-appeal-fees-in-omr"/> </label>
                             <input type="text" value="${examJsonFields.reAppealFees }" onkeyup="validateSelectAndInputField('re_appeal_fees','re_appeal_fees_error')" maxlength="10"
                             onkeypress="return event.charCode >= 48 && event.charCode <= 57" placeholder="<liferay-ui:message key="re-appeal-fees-in-omr"/>" name="<portlet:namespace/>reAppealFees" id="re_appeal_fees" class="form-control">
                        <span class="d-none text-danger" id="re_appeal_fees_error"><liferay-ui:message key="the-re-appeal-fees-field-is-required"/></span>
					</div>
				</div>
			</div>						
		</div>

        <div class="omsb-list-filter">
			<div class="row">
				<div class="col-lg-12 col-md-12">
					<div class="d-flex">
						<div class="w-50">
							<label class="control-label required"><liferay-ui:message key="eligibility-check"/> </label>
						</div>
						<div class="form-group yesorno">
							<div class="custom-control custom-radio ">
								<input type="radio" value="1" name="<portlet:namespace/>eligibilityCheck" class="custom-control-input eligibility_check" id="eligibility_yes" onchange="eligibilityConfirmation()" onload="eligibilityConfirmation()"
								  <c:if test="${examJsonFields.eligibilityCheck eq true}"> checked="checked"</c:if>>
								<label class="custom-control-label m-0" for="eligibility_yes"><liferay-ui:message key="yes"/></label>
							</div>
							
							<div class="custom-control custom-radio ">
								<input type="radio" value="0" name="<portlet:namespace/>eligibilityCheck" class="custom-control-input " id="eligibility_no" onchange="eligibilityConfirmationNo()" onload="eligibilityConfirmationNo()"
								<c:if test="${examJsonFields.eligibilityCheck eq false}"> checked="checked"</c:if>>
								<label class="custom-control-label m-0" for="eligibility_no"><liferay-ui:message key="no"/></label>
							</div>
						</div>
						</div>
						<span class="d-none text-danger" id="eligibility_Check_error"><liferay-ui:message key="the-eligibility-is-required"/></span>
				</div>
                <div class="col-lg-12 col-md-12">
					<div class="d-flex">
						<div class="w-50">
							<label class="control-label required"><liferay-ui:message key="does-eportal-apply-eligibility"/> </label>
						</div>
						<div class="form-group yesorno">
							<div class="custom-control custom-radio ">
								<input type="radio" value="1" name="<portlet:namespace/>applyEligibility" class="custom-control-input apply_Eligibility" id="eportal_yes"
								 <c:if test="${examJsonFields.applyEligibility eq true}"> checked="checked"</c:if>>
								<label class="custom-control-label m-0" for="eportal_yes"><liferay-ui:message key="yes"/></label>
							</div>
							
							<div class="custom-control custom-radio ">
								<input type="radio" value="0" name="<portlet:namespace/>applyEligibility" class="custom-control-input apply_Eligibility" id="eportal_no"
								 <c:if test="${examJsonFields.applyEligibility eq false}"> checked="checked"</c:if>>
								<label class="custom-control-label m-0" for="eportal_no"><liferay-ui:message key="no"/></label>
							</div>
						</div>
					</div>
					<span class="d-none text-danger" id="apply_Eligibility_error"><liferay-ui:message key="the-eportal-apply-eligibility-is-required"/></span>
				</div>
			</div>						
		</div>
	<c:if test="${empty examJsonFields.applyEligibility or not empty examJsonFields.applyEligibility or  examJsonFields.applyEligibility eq true}">
	<div class="omsb-card omsb-card-graybg d-none" id="eligiblity-check-confirmation">
				<h4 class="omsb-card-title"><liferay-ui:message key="number-of-attempts-and-the-time-period-for-the-attempts"/> </h4>
					<div class="omsb-list-view table-responsive">
		                <table class="display omsb-datatables" id="attempt_details">
		                    <thead>
		                        <tr>
		                            <th><liferay-ui:message key="nationality"/> </th>
		                            <th><liferay-ui:message key="max-no-of-attempts"/> </th>
		                            <th><liferay-ui:message key="max-time-period-to-complete-all-attempts"/> </th>                                            
		                            <th><liferay-ui:message key="time-period-between-attempts"/> </th>                                            
		                        </tr>
		                    </thead>
		                    <tbody>
		                        <tr>
		                            <td><liferay-ui:message key="omani"/></td>
		                            <td><input type="text" maxlength="7" onkeypress="return event.charCode >= 48 && event.charCode <= 57" value="${examJsonFields.omaniMaxAttempts }" placeholder="<liferay-ui:message key="maximum-no-of-attempts"/>" name="<portlet:namespace/>omaniMaxAttempts" id="om_max_at" class="form-control omaniMaxAttempt"></td>
		                            <td><input type="text" maxlength="7" onkeypress="return event.charCode >= 48 && event.charCode <= 57" value="${examJsonFields.omaniMaxTimePeriod }" placeholder="<liferay-ui:message key="maximum-time-period"/>" name="<portlet:namespace/>omaniMaxTimePeriod" id="om_max_time" class="form-control omaniMaxAttempt"></td>
		                            <td><input type="text" maxlength="7" onkeypress="return event.charCode >= 48 && event.charCode <= 57" value="${examJsonFields.omaniTimePeriod }" placeholder="<liferay-ui:message key="time-period-between-attempts"/>" name="<portlet:namespace/>omaniTimePeriod" id="om_time" class="form-control omaniMaxAttempt"></td>
		                        </tr>
		                        <tr>
		                            <td><liferay-ui:message key="non-omani"/></td>
		                            <td><input type="text" maxlength="7" onkeypress="return event.charCode >= 48 && event.charCode <= 57" value="${examJsonFields.nonOmaniMaxAttempts }" placeholder="<liferay-ui:message key="maximum-no-of-attempts"/>" name="<portlet:namespace/>nonomaniMaxAttempts" id="n_om_max_at" class="form-control omaniMaxAttempt"></td>
		                            <td><input type="text" maxlength="7" onkeypress="return event.charCode >= 48 && event.charCode <= 57" value="${examJsonFields.nonOmaniMaxTimePeriod }" placeholder="<liferay-ui:message key="maximum-time-period"/>" name="<portlet:namespace/>nonomaniMaxTimePeriod" id="n_om_max_time" class="form-control omaniMaxAttempt"></td>
		                            <td><input type="text" maxlength="7" onkeypress="return event.charCode >= 48 && event.charCode <= 57" value="${examJsonFields.nonOmaniTimePeriod }" placeholder="<liferay-ui:message key="time-period-between-attempts"/>" name="<portlet:namespace/>nonomaniTimePeriod" id="n_om_time"  class="form-control omaniMaxAttempt"></td>
		                        </tr>
		                    </tbody>
		                </table>
		              </div>
	             	  <span class="d-none text-danger" id="attempt_details_error"><liferay-ui:message key="the-attempt-details-field-is-required"/></span>
			</div>
	</c:if>
	        
		<portlet:renderURL var="OCTHomeURL">
			<portlet:param name="mvcRenderCommandName" value="/" />
		</portlet:renderURL>
       <div class="bottom-backbtn-wrap mt-2">
           <button class="btn omsb-bc-red-button" id="save_exam" type="submit" onclick="saveExamForm();saveRegularFee(event);saveReschedulingFee(event);saveCancellationFee(event);saveExamBlueprint(event)"  title="${not empty examJsonFields.id ?'update':'save'}"><liferay-ui:message key="${not empty examJsonFields.id ?'update':'save'}"/></button>
           <button class="btn omsb-bc-red-button" type="button" data-toggle="modal"  data-target="#exam-setup-discard" title="Discard" ><liferay-ui:message key="discard"/></button>
           <a class="btn omsb-btn btn-back" href="${OCTHomeURL }"><i class="fi fi-sr-arrow-left"></i><liferay-ui:message key="back"/></a>
       </div>

	</div>
  </div>
</div>
	
<%@ include file="/jsps/exam/oct-modal.jsp"%>


	
</form>

<script>

$(document).ready(function() {
	eligibilityConfirmation();
});

var rftable = $('#regularExam_table').DataTable({
	"aaSorting": [],
    "bLengthChange": false,
    "pageLength": 2
});
var rsftable = $('#rescheduling_table').DataTable({
	"aaSorting": [],
    "bLengthChange": false,
    "pageLength": 2,
    "columnDefs": [ { target: 1,
    	"createdCell": function(td) {
    		$(td).attr('class','d-none');
    	}
    }]
});
var cftable = $('#cancellationFee_table').DataTable({
	"aaSorting": [],
    "bLengthChange": false,
    "pageLength": 2,
    "columnDefs": [ { target: 1,
    	"createdCell": function(td) {
    		$(td).attr('class','d-none');
    	}
    }]
});

function check_dropdown() {
	/* $("[data-toggle='dropdown']").click(function () {
		$(this).siblings("ul.dropdown-menu").toggleClass("show");
	}) */
}

/* $(document).on('change','#eligibility_yes',function(){ 
	eligiblityConfirmation();
});
 */
 function eligibilityConfirmation(){
	var eligibility_yes = null;
	if(document.getElementById('eligibility_yes').checked) {
		eligibility_yes = document.getElementById('eligibility_yes').value;
		 console.log("eligibility_yes  "+eligibility_yes);
		}
	if(eligibility_yes == "1"){
		$("#eligiblity-check-confirmation").removeClass("d-none");
	}
	else{
		$("#eligiblity-check-confirmation").addClass("d-none");
		
	}
} 
 
 function eligibilityConfirmationNo(){
		var eligibility_no = $("#eligibility_no").val();
		if(eligibility_no != ""){
			$("#eligiblity-check-confirmation").addClass("d-none");
		}
		else{
			$("#eligiblity-check-confirmation").removeClass("d-none");
		}
	} 

var examFormNumberArray=[];
function checkFormNumber(){
	var examFormNo = $("#exam_form_no").val();
	console.log("examFormNo:"+examFormNo)
	var numericPattern = /^[0-9]*$/;
	if(examFormNo && numericPattern.test(examFormNo)){
		examFormNumberArray=[];
		getExamForm();
	}
}
var cmd = "${cmd}";
if(cmd == 'editExam'){
    console.log(cmd)
    getExamForm();
    }
function getExamForm(callback){
	var defaultStatus = $("#status").val();
	console.log("default status:"+defaultStatus)
	var examFormArray = [];
	 var examFormNo = $("#exam_form_no").val();
	 var examTitleId = $("#exam_title").val();
	 console.log("examTitleId::"+examTitleId);
	 var getExamURL = "${getExamURL}";
	 $.ajax({
			url: getExamURL,
			dataType : 'json',
			async : false,
			data : {
				<portlet:namespace />examTitleId : examTitleId,
				<portlet:namespace />examFormNo : examFormNo,
			},
			type : 'POST',
			success : function(data) {
				console.log("data"+data);
				var examTitleList = data;
				$('#exam_form').empty();
				$('#exam_form_no').empty();
				$.each(examTitleList, function (i, item) {
					var selectedForm = "";
					 if (cmd == 'editExam') {
						  console.log("inside exam edit functionality"); 
						  selectedForm = "selected";
						  }
				$('#exam_form').append("<option value='" + item.examForm +"'"+ selectedForm +"'>" + item.examForm + "</option> ");
				examFormNumberArray.push({
					examForm: item.examForm,
					examFormStatus: defaultStatus,
					});
				
				})
				console.log('examFormNumberArray ??? ', examFormNumberArray);
				if (typeof callback === 'function') {
					console.log("call back function")
	                callback(examFormArray);
	            }
				},
			})
		}
		
var existExamConfirm = $("#exist-exam-setup");
	function getExistExam(event){
		 var getExistExamURL = "${getExistExamURL}";
		 var cmd = "${cmd}";
		 var examTitleId = $("#exam_title").val();
		 console.log("examTitleId:"+examTitleId)
		 $.ajax({
				url: getExistExamURL,
				dataType : 'json',
				async : false,
				data : {
					<portlet:namespace />examTitleId : examTitleId,
				},
				type : 'POST',
				success : function(data) {
					console.log("data"+data);
					var existExams = data;
					$.each(existExams, function (i, item) {
						console.log(item.existExam)
						if(item.existExam >0 && cmd == 'addExam'){
							existExamConfirm.find(".modal-content .modal-header .exist-exam").text(item.examTypeName);
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
	
	
	function getStatus(){
		var selectedExamForm = $("#exam_form").val();
		var selectedStatus = $("#status").val();
		console.log("selectedStatus:  " , selectedStatus , "selectedExamForm:  " , selectedExamForm);
		var fIndex = examFormNumberArray.findIndex( x => x.examForm === selectedExamForm );
		console.log("index of selectedExamForm :  " , fIndex );
		var found = examFormNumberArray.filter(function(item) { return item.examForm === selectedExamForm; });
		console.log("value of selectedExamForm :  " , found );
		examFormNumberArray.splice(fIndex,1);
		console.log("old examFormNumberArray in get status :  " , examFormNumberArray );
		
		examFormNumberArray.push({
            examForm: selectedExamForm,
            examFormStatus: selectedStatus
        });
		console.log("new  examFormNumberArray in get status :  " , examFormNumberArray );
	}
	
	$("#exam_form").on('change', function(){
		var selectedExamForm = $("#exam_form").val();
		var formItem = examFormNumberArray.filter(function(item) { return item.examForm === selectedExamForm; });
		var formStatus = formItem[0].examFormStatus;
		console.log('formStatus ', formStatus);
		$("#status").val(formStatus);
		
	});
	function saveExamForm() {
		 var json = JSON.stringify({items:examFormNumberArray});
		 console.log("jsonData"+json);
		 $("#exam_form_nos").val(json);
	}
	
	/* for dynamic rows */
	/* add regular fees */
	function addRegularFee(){
		var pattern = /^[0-9]+$/;
		var doublepattern = /^[0-9]+(\.\d+)?$/;
		var attemptNumber = $("#attempt_number").val();
		var regularFee = $("#regular_fee").val();
		console.log("attemptNumber :"+attemptNumber);
		var isAttemptNumber=validateSelectAndInputField('attempt_number','attempt_number_error');
		var isAmountValid=validateSelectAndInputField('regular_fee','regular_fee_error');
		if(isAttemptNumber && isAmountValid){
			console.log("inside else");
			var regularFeeModal = $("#regular_fee_modal");
			regularFeeModal.modal('hide');
			var editRow = $("#regular_fee_modal").data("editRow");
	        if (editRow){
				console.log("inside if condn");
				editRow.find("td:nth-child(1)").text(attemptNumber);
			    editRow.find("td:nth-child(2)").text(regularFee);
			  } else{
				  console.log("inside add else");
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
			}).attr("href", "#").append($("<img>").attr("src", "<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-eye.svg")).append("Edit");
			var deleteLink = $("<a>").addClass("dropdown-item").attr({
				"data-toggle": "modal",
				"data-target": "#delete_row",
				"onclick": "setData(this)"
			}).attr("href", "#").append($("<img>").attr("src", "<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-equate.svg")).append("Delete")
			dropdownMenu.append($("<li>").append(editLink), $("<li>").append(deleteLink));
			/* dropdownDiv.append(dropdownBtn, dropdownMenu);
			actionCell.append(dropdownDiv);
			newRow.append(attemptNoCell, regularFeeCell, actionCell);
			  $("#regularExam_table tbody").append(newRow); */
			var rft_action ='<div class="dropdown"><button class="btn fa fa-ellipsis-v dropdown-toggle" type="button" data-toggle="dropdown" aria-expanded="false"></button><ul class="dropdown-menu"><li><a class="dropdown-item" data-toggle="modal" data-target="#regular_fee_modal" onclick="editregfee(this);" href="#"><img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg">Edit</a></li><li><a class="dropdown-item" data-toggle="modal" data-target="#delete_row" onclick="setData(this)" href="#"><img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-delete.svg">Delete</a></li></ul></div>';
			  
			 rftable.row.add( [ attemptNumber, regularFee, rft_action ] ).draw();
			}
	        $("#regular_fee_modal").removeData("editRow");
			  $("#attempt_number").val('');
			  $("#regular_fee").val('');
			  $('#attempt_number_error').addClass('d-none');
			  $('#regular_fee_error').addClass('d-none');
			  $('#number_format_error').addClass('d-none')
			  $('#regular_fee_number_error').addClass('d-none')
			  $('#regularTable_error').addClass('d-none')
			  
		}	
		check_dropdown();
		}
	/*  add reschedule fees*/
	function addReschedulingFee(){
		
		if(!validateDaysPopupScreenData('days_before','days_before_reschedule_exam_value','days_before_c_error','rescheduling_input_1','rescheduling_input_2','rescheduling_input_3','reschedule_fees_no_of_days')){
			return false;
		}
	
		var pattern = /^[0-9]+$/;
		var doublepattern = /^[0-9]+(\.\d+)?$/;
		var daysBefore = $("#days_before").val();
		var refundPercentage = $("#refund_percentage").val();
		var daysBeforeExamValue = $("#days_before_reschedule_exam_value").val();
		console.log("daysBefore :"+daysBefore);
		var isAttemptNumber=validateSelectAndInputField('days_before','days_before_error');
		var isAmountValid=validateSelectAndInputField('refund_percentage','refund_percentage_error');
		if(isAttemptNumber && isAmountValid){
			var reschedulingfeesModal = $("#reschedulingfees");
			reschedulingfeesModal.modal('hide');
			var editRow = $("#reschedulingfees").data("editRow");
	        if (editRow){
				console.log("inside if condn");
				editRow.find("td:nth-child(1)").text(daysBefore);
			    editRow.find("td:nth-child(2)").text(refundPercentage);
			} else{
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
					"data-target": "#reschedulingfees",
					"onclick": "reschedulefees(this);"
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
				  $("#rescheduling_table tbody").append(newRow); */
				var rsft_action ='<div class="dropdown"><button class="btn fa fa-ellipsis-v dropdown-toggle" type="button" data-toggle="dropdown" aria-expanded="false"></button><ul class="dropdown-menu"><li><a class="dropdown-item" data-toggle="modal" data-target="#reschedulingfees" onclick="reschedulefees(this);" href="#"><img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg">Edit</a></li><li><a class="dropdown-item" data-toggle="modal" data-target="#delete_row" onclick="setData(this)" href="#"><img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-delete.svg"><liferay-ui:message key='delete' /></a></li></ul></div>';
				rsftable.row.add( [ daysBefore,daysBeforeExamValue, refundPercentage, rsft_action ] ).draw();
	        }
	        $("#reschedulingfees").removeData("editRow");
			  $("#days_before").val('');
			  $("#refund_percentage").val('');
			  $('#days_before_error').addClass('d-none');
			  $('#refund_percentage_error').addClass('d-none');
			  $('#days_before_number_error').addClass('d-none')
			  $('#refund_number_error').addClass('d-none')
			}
		 $('#rescheduleTable_error').addClass('d-none')
		check_dropdown();
		}
	
	function validateDaysPopupScreenData(daysBeforeExam, daysBeforeExamValue,errorId,noOfDaysFrom,noOfDaysRange,noOfDaysTo,noOfDays){
		var isValid=true;
		var inputValue="";
		var inputText="";
		var selectedRangeValue =$('#'+noOfDaysRange +' option:selected').val();
		var selectedRange =$('#'+noOfDaysRange +' option:selected').text();
		if(selectedRangeValue == '>' || selectedRangeValue == '<') {
			
			// Validating No. of Days
			var noOfDaysValue =$('#'+noOfDays).val();
			if(noOfDaysValue ==undefined || noOfDaysValue == '') {
				$('#noOfDays-error').removeClass('d-none');
				isValid = false;
			}
			else{
				$('#noOfDays-error').addClass('d-none');
			}
		}
		else {
			// Validating Range 
			if(selectedRangeValue == undefined || selectedRangeValue == ''){
				$('#cancellationFeeSelectedText-error').removeClass('d-none');
				isValid = false;
			}
			else{
				$('#cancellationFeeSelectedText-error').addClass('d-none');
			}
			
			// Validating No. of Days From 
			var noOfDaysFromValue =$('#'+noOfDaysFrom).val();
			
			if(noOfDaysFromValue ==undefined || noOfDaysFromValue == ''){
				$('#noOfDaysFrom-error').removeClass('d-none');
				isValid = false;
			}
			else{
				$('#noOfDaysFrom-error').addClass('d-none');
			}
			
			// Validating No. of Days To
			var noOfDaysToValue =$('#'+ noOfDaysTo).val();
			if(noOfDaysToValue ==undefined || noOfDaysToValue == ''){
				$('#noOfDaysTo-error').removeClass('d-none');
				isValid = false;
			}
			else{
				$('#noOfDaysTo-error').addClass('d-none');
			}
		}
		if(!isValid){
			return isValid;
		}
		
		if(selectedRangeValue == '>' || selectedRangeValue == '<'){
			inputText = selectedRange + ' ' + $('#'+noOfDays).val();
			inputValue = selectedRangeValue + ' ' + $('#'+noOfDays).val();
		} else {
			inputText = selectedRange + ' ' + $('#'+noOfDaysFrom).val()+ ' & ' + $('#'+noOfDaysTo).val();
			inputValue =  $('#'+noOfDaysFrom).val()+ ' - ' + $('#'+noOfDaysTo).val();
		}
		
		if(inputValue ==''){
			isValid=false;
		}
		if(isValid){
			 $('#'+daysBeforeExam).val(inputText);
			 $('#'+daysBeforeExamValue).val(inputValue);
			 $('#'+errorId).addClass('d-none');
		}else{
			 $('#'+daysBeforeExam).val('');
			 $('#'+daysBeforeExamValue).val('');
			 $('#'+errorId).removeClass('d-none');
		}
		return isValid;
	}	

	
	/* cancellation fee */
	function addCancellationFee(){
		
		if(!validateDaysPopupScreenData('days_before_c','days_before_exam_value','days_before_c_error','cancellationfees_input_1','cancellationfees_input_2','cancellationfees_input_3','cancellationfees_no_of_days')){
			return false;
		}
		
		var pattern = /^[0-9]+$/;
		var doublepattern = /^[0-9]+(\.\d+)?$/;
		var daysBefore = $("#days_before_c").val();
		var refundPercentage = $("#refund_percentage_c").val();
		console.log("daysBefore :"+daysBefore);
		var daysBeforeExamValue = $("#days_before_exam_value").val();
		var days_before_c=validateSelectAndInputField('days_before_c','days_before_c_error');
		console.log(days_before_c);
		var refund_percentage_c=validateSelectAndInputField('refund_percentage_c','refund_percentage_c_error');
		
		if( refund_percentage_c && days_before_c){
			
		
			var cancellationfeesModal = $("#cancellationfees");
			cancellationfeesModal.modal('hide');
			var editRow = $("#cancellationfees").data("editRow");
	        if (editRow){
				console.log("inside if condn");
				editRow.find("td:nth-child(1)").text(daysBefore);
			    editRow.find("td:nth-child(2)").text(refundPercentage);
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
				"data-target": "#cancellationfees",
				"onclick": "cancellationfees(this); "
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
			  $("#cancellationFee_table tbody").append(newRow); */
			var cft_action ='<div class="dropdown"><button class="btn fa fa-ellipsis-v dropdown-toggle" type="button" data-toggle="dropdown" aria-expanded="false"></button><ul class="dropdown-menu"><li><a class="dropdown-item" data-toggle="modal" data-target="#cancellationfees" onclick="cancellationfees(this);" href="#"><img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-edit.svg">Edit</a></li><li><a class="dropdown-item" data-toggle="modal" data-target="#delete_row" onclick="setData(this)" href="#"><img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-delete.svg">Delete</a></li></ul></div>';
			  
			 cftable.row.add( [ daysBefore,daysBeforeExamValue, refundPercentage, cft_action ] ).draw();
	        }
	        $("#cancellationfees").removeData("editRow");
			  $("#days_before_c").val('');
			  $("#refund_percentage_c").val('');
			  $('#days_before_error_c').addClass('d-none');
			  $('#refund_percentage_error_c').addClass('d-none');
			  $('#days_before_number_error_c').addClass('d-none');
			  $('#refund_number_error_c').addClass('d-none');
			  $('#cancellationFee_table_error').addClass('d-none')
				
			}
		
		check_dropdown();
		}
	
	/*  blueprint==========*/
	var trCounter = 0;
var trClass = "support-doc-tr-"
function addSupportingDocumentOCTExam(){
	console.log('adding supporting docs starts::::');
	var validDocField=validSupportDocs();
	
	if(validDocField){
		var suppDocAction =  $("#supp_doc_action").val();
		var docTitle = $("#documentTitle").val();
		var docFile = document.getElementById("supportingFile").files[0];
		var docFileName = docFile.name;
		var editedClass = $("#supp_doc_row_class").val();
		
		if (suppDocAction == 'add') {
			console.log('adding row');
			console.log('title ', docTitle, 'fileName ', docFile, '  docFileName  ', docFileName);
			addTableRow("#addsupportingdocument", "supporting-documents-tb", docTitle, docFileName, docFile, trCounter);
			trCounter++;
		} else {
			console.log('editing row');
			updateTableRow(docTitle, docFile, editedClass);
			$("#supp_doc_action").val('add');
			$("#supp_doc_row_class").val('');
		}
		$(".dataTables_empty").remove();
		console.log('adding supporting docs ends');
		$("#addsupportingdocument").modal('hide');
		$("#documentTitle").val('');
		document.getElementById("supportingFile").value = null;
		$("#popup_sd_file_label").html('');
		  $('#examBluePrintTable_error').addClass('d-none');
	
	}
}

function saveExamBlueprint() {
	//	event.preventDefault();
	//	$(".appl-reason").removeClass("d-none");
	const columnNames = $("#supporting-documents-tb thead th").map(function() {
		  return $(this).attr('data-name');
		}).get();

	 console.log('columnNames ??' , columnNames);

	 const tableData = $("#supporting-documents-tb tbody tr").map(function() {
		  const rowData = {};
		  $(this).find("td").each(function(index) {
		    rowData[columnNames[index]] = $(this).text().trim();
		    console.log('index ??', index, '  columnName ', columnNames[index], ' rowData[columnNames[index]] ?', rowData[columnNames[index]]);
		  });
		  return rowData;
		}).get();
	  
	  const results = tableData.filter(element => Object.keys(element).length !== 0);

	  var json = JSON.stringify({items:results});
	  console.log("jsonData  "+json);
	  $('#' + namespace + 'blueprint').val(json);
 }

function addTableRow(modalId, tableId, title, fileName, docFile, trCounter){
	var className = trClass + trCounter;
	console.log('addTableRow >>>>>> title ', title, 'modalId ', modalId, 'fileName ', fileName, '  docFile   ', docFile, ' trCounter ', trCounter);
	var element = document.createElement("input");
	element.type = 'file';
	element.name = 'docInput_'+trCounter;
	element.id = className;
	var container = new DataTransfer();
	container.items.add(docFile);
	element.className = "form-control supp-docs";
	element.files = container.files;
	
	var newRow = $('<tr class="'+className+'">');
	var title = $("<td>").text(title);
	var fileName = $("<td>").text(fileName);
	var file = $("<td class='d-none'>").append(element);
	var rowNumber = $("<td class='d-none'>").text(trCounter);
	//file = file.text(docFile); 
	var actionCell = $("<td>");
	var dropdownDiv = $("<div>").addClass("dropdown");
	var dropdownBtn = $("<button>").addClass("btn fa fa-ellipsis-v dropdown-toggle").attr({
		"type": "button",
		"data-toggle": "dropdown",
		"aria-expanded": "false"
	});
	var dropdownMenu = $("<ul>").addClass("dropdown-menu");
	var editLink = $("<a>").addClass("dropdown-item");
	editLink = editLink.attr("data-toggle", "modal");
	editLink = editLink.attr("data-target", modalId);
	editLink = editLink.attr("onclick", "editSupportDocRow(this); return false;");
	editLink = editLink.attr("href", "#");
	editLink = editLink.append($("<img>").attr("src", imagePath + '/svg/fi-rr-eye.svg'));
	editLink = editLink.append("Edit");

	var deleteLink = $("<a>").addClass("dropdown-item").attr("onclick", "setData(this)").attr("href", "#");
	deleteLink = deleteLink.attr("data-toggle", "modal");
	deleteLink = deleteLink.attr("data-target", "#delete_row");
	deleteLink = deleteLink.append($("<img>").attr("src", imagePath + "/svg/fi-rr-equate.svg")).append("Delete");
	dropdownMenu.append($("<li>").append(editLink), $("<li>").append(deleteLink));
	dropdownDiv.append(dropdownBtn, dropdownMenu);
	actionCell.append(dropdownDiv);
	newRow.append(title, fileName, file, rowNumber, actionCell);
	console.log('tableId is ?? ', "#"+tableId);
	  $("#"+tableId).append(newRow);
}

function editSupportDocRow(id){
	console.log('calling is ?? ');
	//var rowFile = $(id).closest('tr').find("td:nth-child(3) input[type='file']").files[0];
	var editDocTitle = $(id).closest('tr').find("td:nth-child(1)").html();
	var editFileTitle = $(id).closest('tr').find("td:nth-child(2)").html();
	var rowClass= $(id).closest('tr').attr('class');
	var editFile = document.getElementById(rowClass).files[0];
	console.log('ss is ?? '+rowClass);
	console.log('editFile is ?? '+editFile.name);
	console.log('editDocTitle is ?? '+editDocTitle);
	$("#documentTitle").val(editDocTitle);
	$("#supp_doc_action").val('edit');
	$("#popup_sd_file_label").html(editFileTitle);
	$("#supp_doc_row_class").val(rowClass);
	var container1 = new DataTransfer();
	container1.items.add(editFile);
	document.getElementById("supportingFile").files = null;
	document.getElementById("supportingFile").files = container1.files;
}

function updateTableRow(docTitle, docFile, editedClass){
	
	console.log('calling updateTableRows ?? ', editedClass);
	var editDocTitle = $("."+editedClass).find("td:nth-child(1)").html(docTitle);
	var editFileTitle = $("."+editedClass).find("td:nth-child(2)").html(docFile.name);
}
	/*  blueprint==========*/

		/*  save data from table row*/
	 function saveRegularFee(event) {
		 var columnNames = [];
		 $("#regularExam_table thead th").each(function(index) {
			    var columnName = $(this).attr('name');
			    columnNames.push(columnName);
			  });
		  var tableData = [];
		  $("#regularExam_table tbody tr").each(function() {
		    var rowData = {};
		    $(this).find("td").each(function(index) {
		    	var columnName = columnNames[index];
		        rowData[columnName] = $(this).text();
		    });
		    tableData.push(rowData);
		 
			  $('#regular_em_tb').addClass('d-none')
		    var json = JSON.stringify({items:tableData});
		    console.log("jsonDataereg:"+json);
		    $("#regularExam_json_data").val(json);
		  }); 
	 }
	
	
	 function saveReschedulingFee(event) {
		 var columnNames = [];
		 $("#rescheduling_table thead th").each(function(index) {
			    var columnName = $(this).attr('name');
			    columnNames.push(columnName);
			  });
		  var tableData = [];
		  $("#rescheduling_table tbody tr").each(function() {
		    var rowData = {};
		    $(this).find("td").each(function(index) {
		    	var columnName = columnNames[index];
		        rowData[columnName] = $(this).text();
		    });
		    tableData.push(rowData);
		 
		   $('#reschedule_em_tb').addClass('d-none')
		    var json = JSON.stringify({items:tableData});
		    console.log("jsonDataresched: "+json);
		    $("#reschedule_fee_json_data").val(json);
		  });
	 }
	 
	 
	 function saveCancellationFee(event) {
		 var columnNames = [];
		 $("#cancellationFee_table thead th").each(function(index) {
			    var columnName = $(this).attr('name');
			    columnNames.push(columnName);
			  });
		  var tableData = [];
		  $("#cancellationFee_table tbody tr").each(function() {
		    var rowData = {};
		    $(this).find("td").each(function(index) {
		    	var columnName = columnNames[index];
		        rowData[columnName] = $(this).text();
		    });
		    tableData.push(rowData);
		 
		   $('#cancellation_em_tb').addClass('d-none')
		    var json = JSON.stringify({items:tableData});
		    console.log("jsonDatacanc: "+json);
		    $("#cancellation_fee_json_data").val(json);
		  });
	 }
	 
	 
	 
	 
	 /* discard functionality */
	 
	function discardChanges() {
    const elementsToClear = [
        "#exam_title", "#duration_of_exam", "#cut_score", "#score_validity", "#reg_cut_off",
        "#result_source", "#exam_form_no", "#exam_form", "#status", "#locate_error", "#venue_error",
        "#applicabledate", "#fee_amount", "#reschedule_period", "#appeal_window", "#appeal_fees",
        "#re_appeal_window", "#re_appeal_fees", "#om_max_at", "#om_time", "#om_max_time",
        "#n_om_max_at", "#n_om_max_time", "#n_om_time", '#locateOnGoogleMap', '#venue', '#reappeal_window'
    ];

    for (const element of elementsToClear) {
        $(element).val("");
    }
    const radioButtonsToClear = [
        "#eligibility_yes",
        "#eligibility_no",
        "#eportal_yes",
        "#eportal_no"
    ];
    for (const radioButton of radioButtonsToClear) {
        $(radioButton).prop("checked", false);
    }
    const tablesToClear = [
        "#supporting-documents-tb tbody tr", "#regularExam_table tbody tr",
        "#rescheduling_table tbody tr", "#cancellationFee_table tbody tr"
    ];

    for (const table of tablesToClear) {
        $(table).empty();
    }
    
    location.reload(true);
    
    $("#exam-setup-discard").modal("hide");
    
    location.reload(true);
    
}
/* this is for delete row with confirmation  */	 
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

/*  this is for edit regular fee from table*/
 function editregfee(link) {
		  var row = $(link).closest("tr"); 
		  var attemptNoCell = row.find("td:nth-child(1)"); 
		  var regularFeeCell = row.find("td:nth-child(2)"); 

		  var attemptNumber = attemptNoCell.text(); 
		  var regularFee = regularFeeCell.text(); 

		  $("#attempt_number").val(attemptNumber);
		  $("#regular_fee").val(regularFee);
		  
		  $("#regular_fee_modal").data("editRow", row);
		}
		
 /*  this is for edit rescheduling fee from table*/
 function reschedulefees(link) {
		  var row = $(link).closest("tr"); 
		  var daysBeforeCell = row.find("td:nth-child(1)"); 
		  var refundPercentageCell = row.find("td:nth-child(2)"); 

		  var daysBefore = daysBeforeCell.text(); 
		  var refundPercentage = refundPercentageCell.text(); 

		  $("#days_before").val(daysBefore);
		  $("#refund_percentage").val(refundPercentage);
		  
		  $("#reschedulingfees").data("editRow", row);
		}
 /*  this is for edit cancellation from table*/
/*  function cancellationfees(link) {
		  var row = $(link).closest("tr"); 
		  var daysBeforeCell = row.find("td:nth-child(1)"); 
		  var refundPercentageCell = row.find("td:nth-child(2)"); 

		  var daysBefore = daysBeforeCell.text(); 
		  var refundPercentage = refundPercentageCell.text(); 

		  $("#days_before_c").val(daysBefore);
		  $("#refund_percentage_c").val(refundPercentage);
		  
		  $("#cancellationfees").data("editRow", row);
		} */
		
		
		function reschedulefees(link) {
			
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
					$('#reschedule_no_of_days').addClass('d-none');
					$('#reschedule_no_of_days_to').removeClass('d-none');
					$('#reschedule_no_of_days_from').removeClass('d-none');
					
					daysBeforeArray = daysBefore.split("-");
					noOfDaysFrom = daysBeforeArray[0].trim();
			 		noOfDaysTo= daysBeforeArray[1].trim();
					selectedRangeOption = "-";
					$('#rescheduling_input_1').val(noOfDaysFrom);
					$('#rescheduling_input_3').val(noOfDaysTo);
				}else{
					$('#reschedule_no_of_days').removeClass('d-none');
					$('#reschedule_no_of_days_to').addClass('d-none');
					$('#reschedule_no_of_days_from').addClass('d-none');
					
					daysBeforeArray = daysBefore.split(" ");
					selectedRangeOption = daysBeforeArray[0].trim();
					noOfDays =daysBeforeArray[1].trim();
					$('#reschedule_fees_no_of_days').val(noOfDays);
				}
				
				
		 	 $('#rescheduling_input_2').val(selectedRangeOption);
			 $("#days_before").val(daysBeforeText);
			 $("#days_before_reschedule_exam_value").val(daysBefore);
			 
			 var refundPercentage = refundPercentageCell.text(); 
			  $(link).closest(".show").removeClass('show');
			  $("#days_before").val(daysBeforeText);
			  $("#days_before_reschedule_exam_value").val(daysBefore);
			  $("#refund_percentage").val(refundPercentage);
			  
			  $("#reschedulingfees").data("editRow", row);
			}
		
		
		function cancellationfees(link) {
			
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
					$('#cancellationfees_input_1').val(noOfDaysFrom);
					$('#cancellationfees_input_3').val(noOfDaysTo);
				}else{
					$('#no_of_days').removeClass('d-none');
					$('#no_of_days_to').addClass('d-none');
					$('#no_of_days_from').addClass('d-none');
					
					daysBeforeArray = daysBefore.split(" ");
					selectedRangeOption = daysBeforeArray[0].trim();
					noOfDays =daysBeforeArray[1].trim();
					$('#cancellationfees_no_of_days').val(noOfDays);
				}
				
				
		 	 $('#cancellationfees_input_2').val(selectedRangeOption);
			 $("#days_before_c").val(daysBeforeText);
			 $("#days_before_exam_value").val(daysBefore);
			 
			 var refundPercentage = refundPercentageCell.text(); 
			  $(link).closest(".show").removeClass('show');
			  $("#days_before").val(daysBeforeText);
			  $("#days_before_exam_value").val(daysBefore);
			  $("#refund_percentage_c").val(refundPercentage);
			  
			  $("#cancellationfees").data("editRow", row);
			}
 /*  this is for edit blueprint from table*/
 function examblueprint(link) {
		  var row = $(link).closest("tr"); 
		  var documentTitleCell = row.find("td:nth-child(1)"); 
		  var blueprintDocCell = row.find("td:nth-child(2)"); 

		  var blueprintTitle = documentTitleCell.text(); 
		  var blueprintDocFile = blueprintDocCell.text(); 

		  $("#blueprint_doc").val(blueprintTitle);
		  $("#<portlet:namespace/>customFile").val(blueprintDocFile);
		  
		  $("#examblueprint").data("editRow", row);
		}
 /* this is for whole form validation */
 
 function validRadioCheck(){
	var isChecked=false;
	if($('input[name="<portlet:namespace/>applyEligibility"]').is(":checked")){
		 $('#apply_Eligibility_error').addClass('d-none');
		isChecked=true;
	}else{
		 $('#apply_Eligibility_error').removeClass('d-none');
		 isChecked=false;
	}
	/* if($('input[name="<portlet:namespace/>eligibilityCheck"]').is(":checked")){
		  $('#eligibility_Check_error').addClass('d-none');
		 isChecked=true;
	}else{
		 $('#eligibility_Check_error').removeClass('d-none');
		 isChecked=false;
	} */
	return isChecked;
}
 </script>
 
<script>
 /* google map integration */
 
function initMap() {
	var options = {
		fields: ["place_id", "formatted_address", "geometry", "name"],
	   	strictBounds: false,
	   	types: ["establishment"],
	};
	const acInput = document.getElementById("locateOnGoogleMap");
	const infowindow = new google.maps.InfoWindow();
	const infowindowContent = document.getElementById("infoWindowContent");
	infowindow.setContent(infowindowContent);
	const map = new google.maps.Map(document.getElementById("map"), {
		center: { lat: 23.59100, lng:  58.38259 },
	   	zoom: 8
	});
	const marker = new google.maps.Marker({
		map,
	   	anchorPoint: new google.maps.Point(0, -29)
	});
	marker.addListener("click", () => {
		infowindow.open({
			anchor: marker,
		   	map
		});
	});
	const autocomplete = new google.maps.places.Autocomplete(acInput, options);
	autocomplete.inputId = "locateOnGoogleMap";
   	autocomplete.addListener("place_changed", () => {
	   	infowindow.close();
	   	marker.setVisible(false);
	   	const place = autocomplete.getPlace();
	   	if (!place.geometry || !place.geometry.location) {
	   		window.alert("No details available for input: '" + place.name + "'");
	   		return;
	   	} else {
	   		document.getElementById($("#locateOnGoogleMap").parent('div').find('input')[1].id).value = place.place_id;
	   	}
	   	if (place.geometry.viewport) {
	   		map.fitBounds(place.geometry.viewport);
	   	} else {
	   		map.setCenter(place.geometry.location);
	   		map.setZoom(8);
	   	}
	   	marker.setPosition(place.geometry.location);
	   	marker.setVisible(true);
	   	infowindowContent.children["place-name"].textContent = place.name;
	   	infowindowContent.children["place-address"].textContent = place.formatted_address;
	   	infowindow.open(map, marker);
	});
	 var placeId = document.getElementById("locateOnGoogleMap").getAttribute("data-place");
	if(placeId){
		var request = {
	  		placeId: placeId,
	   	    fields: ["name", "formatted_address", "place_id", "geometry"],
		};
	   	const service = new google.maps.places.PlacesService(map);
	   	service.getDetails(request, (place, status) => {
	   		if ( status === google.maps.places.PlacesServiceStatus.OK && place && place.geometry && place.geometry.location ) {
	   			document.getElementById("locateOnGoogleMap").value = place.name+', '+place.formatted_address;
				map.setCenter(place.geometry.location);
	   	        map.setZoom(8);
				marker.setPosition(place.geometry.location);
	   	        marker.setVisible(true);
	   	        infowindowContent.children["place-name"].textContent = place.name;
	   	        infowindowContent.children["place-address"].textContent = place.formatted_address;
	   	        infowindow.open(map, marker);
			}
		});
	} 
}

window.initMap = initMap;

function hideAndShowInputFields(){
	var withdrawFeeSelectedValue =$('#cancellationfees_input_2 option:selected').val();
	if(withdrawFeeSelectedValue == '>' || withdrawFeeSelectedValue == '<'){
		$("#cancellationfees_input_1").val('');
		$("#cancellationfees_input_3").val('');
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

function hideAndShowRescheduleInputFields(){
	var withdrawFeeSelectedValue =$('#rescheduling_input_2 option:selected').val();
	if(withdrawFeeSelectedValue == '>' || withdrawFeeSelectedValue == '<'){
		$("#rescheduling_input_1").val('');
		$("#rescheduling_input_3").val('');
		$('#reschedule_no_of_days').removeClass('d-none');
		$('#reschedule_no_of_days_to').addClass('d-none');
		$('#reschedule_no_of_days_from').addClass('d-none');	
	}else{
		$("#reschedule_fees_no_of_days").val('');
		$('#reschedule_no_of_days_to').removeClass('d-none');
		$('#reschedule_no_of_days_from').removeClass('d-none');	
		$('#reschedule_no_of_days').addClass('d-none');
	}
}
function regularFeeCount(){
	console.log(" : : regularFeeCount ; : "+rftable.data().rows().count());
	$("#attempt_number").val(rftable.data().rows().count()+1);
}
</script>

<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBKfirfSY1RoRHGNfYrRsOXJ_FyDkwXao0&callback=initMap&libraries=places&v=weekly"
	defer></script>

<!-- <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAM97fJa4kw2f6dSHQ3mFTmTdKyZ8FrbLw&callback=initMap&libraries=places&v=weekly" defer ></script> -->