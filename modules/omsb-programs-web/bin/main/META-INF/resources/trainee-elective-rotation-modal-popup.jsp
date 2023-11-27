<%@ include file="init.jsp"%>

<portlet:actionURL
	name="<%=OmsbProgramConstants.SAVE_TRAINEE_ELECTIVE_ROTATIONS_MVC_ACTION_COMMAND%>"
	var="saveTraineeElectiveRotations" copyCurrentRenderParameters="false">
	<portlet:param name="redirect" value="${currentURL}" />
</portlet:actionURL>

<portlet:resourceURL
	id="<%=OmsbProgramConstants.GET_ELECTIVE_ROTATIONS_MVC_RESOURCE_COMMAND%>"
	var="fetchElectiveRotations" />

<!-- Modal -->
<div class="modal fade omsb-modal" id="configure-elective-rotation"
	tabindex="-1" role="dialog"
	aria-labelledby="configure-elective-rotationTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">
					<liferay-ui:message key="configure-elective-rotations" />
				</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body pb-0">
				<aui:form action="${saveTraineeElectiveRotations}"
					name="electiveRotationForm">
					<div class="row elective-rotation-row">
						<div class="col-lg-6 col-md-6 col-sm-12">
							<div class="form-group-view">
								<div class="label-name">
									<liferay-ui:message key="program" />
								</div>
								<div class="label-content">${programName}</div>
							</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-12">
							<div class="form-group">
								<aui:input label="trainee-er-id" name="traineePdTlErDetailsId"
									type="hidden" value="" class="form-control" />
								<label><liferay-ui:message key="trainee-level" /> <span
									class="reference-mark text-warning"> <svg
											aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk"
											focusable="false">
											<use
												href="<%=themeDisplay.getPathThemeImages()%>/clay/icons.svg#asterisk"></use>
										</svg>
								</span> </label> <select class="custom-select form-control"
									id="<portlet:namespace/>traineeLevelId"
									name="<portlet:namespace/>traineeLevelId">
									<aui:option value="">
										<liferay-ui:message key="please-select-trainee-level" />
									</aui:option>
									<c:forEach items="${traineeLevelMap}" var="entry">
										<aui:option value="${entry.key}">${entry.value}</aui:option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-12 leftbar">
							<div class="form-group">
								<label><liferay-ui:message
										key="select-elective-rotation" /> <span
									class="reference-mark text-warning"> <svg
											aria-hidden="true" class="lexicon-icon lexicon-icon-asterisk"
											focusable="false">
											<use
												href="<%=themeDisplay.getPathThemeImages()%>/clay/icons.svg#asterisk"></use>
										</svg>
								</span> </label>
								<div class="elective_rotation_list_wrap"
									id="electiveRotationList"></div>
								<p class="note">
									<liferay-ui:message key="note-maximum-3-allowed" />
								</p>
							</div>
						</div>

						<div class="col-lg-6 col-md-6 col-sm-12 rightbar">
							<div class="form-group">
								<div class="elective_rotation_selected_list_items">
									<ul id="ersortlist">

									</ul>
								</div>
							</div>
						</div>
					</div>
					<div id="selected-elective-rotations" style="display: none;">
		
					</div>
				</aui:form>
			</div>
			<div class="modal-footer">
				<button class="btn omsb-bc-red-button" type="button" title="Save"
					onclick="generateInputsForElectiveRotations()">
					<liferay-ui:message key="save" />
				</button>
				<button class="btn omsb-bg-red-button " type="button" title="Reset"
					onclick="resetElectiveRotationForm()">
					<liferay-ui:message key="Reset" />
				</button>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	
	var erdata = [];
	var ervalueData = [];
	function changeElectiveRotationsForTrainee(checkBox) {
		$('#<portlet:namespace/>rotationHelper').remove();
		if($(checkBox).is(":checked")) {
			erdata.push({name: $(checkBox).val()});
			ervalueData.push({value: $(checkBox).data('id')});
			if(erdata.length == 3) {
				$("input[name='elective_srotation']").each(function(){
					if($(this).is(":checked") == false){
						$(this).addClass('disable');
						$(this).prop('disabled', true);
					}
 				});					
			}
			addedElectiveList(erdata, ervalueData);
		} else {
			const newData = erdata.filter((item) => item.name != $(checkBox).val());
			erdata = newData;
			const newValueData = ervalueData.filter((item) => item.value != $(checkBox).data('id'));
			ervalueData = newValueData;
			$(".elective_rotation_list_wrap .custom-control-input").prop('disabled', false);
			$(".elective_rotation_list_wrap .custom-control-input").removeClass('disable');
			addedElectiveList(erdata, ervalueData);
		}
	}

	function addedElectiveList(erdata, ervalueData) {
		$("#ersortlist").empty()
		$.each(erdata, function( index, item ) {
			$("#ersortlist").append("<li value='"+ervalueData[index].value+"' class = 'selected-elective-rotation-list'>"+ item.name +"</li>")
		});
		slist(document.getElementById("ersortlist"));
	}

	slist(document.getElementById("ersortlist"));

	$('#configure-elective-rotation #<portlet:namespace/>traineeLevelId').change(function() {
		var traineeLevelId = $(this).val();
		if (traineeLevelId) {
			erdata = [];
			ervalueData = [];
			$('#<portlet:namespace/>traineeLevelIdHelper').remove();
			loadElectiveRotations(traineeLevelId, 0, '${fetchElectiveRotations}');
		}
		else {
			resetElectiveRotationForm();
		}
	});

	function loadElectiveRotations(traineeLevelId, traineePdTlErDetailsId, fetchElectiveRotationsURL) {
		$("#ersortlist").empty();
		erdata.length = 0
		$.ajax({
			url : fetchElectiveRotationsURL,
			type : 'POST',
			data : {
				<portlet:namespace/>selectedTraineeLevelId : traineeLevelId,
				<portlet:namespace/>traineePdTlErDetailsId : traineePdTlErDetailsId
			},
			success : function(payload) {
				if(traineePdTlErDetailsId) {
					$('#<portlet:namespace/>traineeLevelId').val(traineeLevelId);
				}
				if (payload.success) {
					$('#configure-elective-rotation #<portlet:namespace/>traineePdTlErDetailsId').val(payload.traineePdTlErDetailsId);
					$('#configure-elective-rotation .elective_rotation_list_wrap').html("");
					var index = 1;
					var electiveRotationDiv = "";
					$.each(payload.availableTraineeRotationMap, function(key, value) {
						electiveRotationDiv += "<div class='elective_rotation_list'><div class='custom-control custom-checkbox'><input type='checkbox' onchange='changeElectiveRotationsForTrainee(this)' class='custom-control-input' data-id='"+key+"' value='"+value+"' id='elective"+index+"' name='elective_srotation'><label class='custom-control-label' for='elective"+index+"'>"+value+"</label></div></div>";
						index++;
					});
					$('#configure-elective-rotation .elective_rotation_list_wrap').html(electiveRotationDiv);

					$.each(payload.selectedTraineeRotationList, function(index, valueofSelectedCheckbox) {
						$("#configure-elective-rotation input[name='elective_srotation']").each(function(){
				            if($(this).data('id') == valueofSelectedCheckbox.rotationId){
				            	erdata.push({name: $(this).val()});
				            	ervalueData.push({value: $(this).data('id')});
				    			 $(this).prop('checked', true);
				    			if(erdata.length == 3){
				    				$("#configure-elective-rotation input[name='elective_srotation']").each(function(){
				    					if($(this).is(":checked") == false){
				    						$(this).addClass('disable');
				    						$(this).prop('disabled', true);
				    					}
				     				});					
				    			}
				    			addedElectiveList(erdata, ervalueData);
				            }
				        });
					});
				}
			}
		});
	}

	function generateInputsForElectiveRotations() {
		if(validateElectiveRotationForm()) {
			$('#selected-elective-rotations').html();
			var liList = document.getElementsByClassName('selected-elective-rotation-list');
			for (var i = 0; i < liList.length; i++) {
				var li = liList[i];
			  	var input = document.createElement('input');
			  	input.type = 'hidden';
			  	input.value = li.value;
			  	input.name = '<portlet:namespace/>selectedElectiveRotations';
				$('#selected-elective-rotations').append(input);
			}
			$('#<portlet:namespace/>electiveRotationForm').submit();
		}
	}
		
	function validateElectiveRotationForm() {
		$('.help-block').remove();
		isValidate = true;
		if(!$('#<portlet:namespace/>traineeLevelId').val().trim()) {
 			let errorMsg = `<div class="form-feedback-item form-validator-stack help-block" id='<portlet:namespace/>traineeLevelIdHelper'>
 				<div role="alert" class="text-danger"><liferay-ui:message key="trainee-level-field-required" /></div>
 			</div>`
 			$('#<portlet:namespace/>traineeLevelId').closest('.form-group').append(errorMsg);
 			isValidate = false;
 		}
		if(!$('.custom-control-input:checked').length) {
			let errorMsg = `<div class="form-feedback-item form-validator-stack help-block" id='<portlet:namespace/>rotationHelper'>
 				<div role="alert" class="text-danger"><liferay-ui:message key="rotation-field-required" /></div>
 			</div>`
 			$('.elective_rotation_list_wrap').after(errorMsg);
 			isValidate = false;
		}
		return isValidate;
	}

	function resetElectiveRotationForm() {
		$('.help-block').remove();
		$('#configure-elective-rotation #<portlet:namespace/>traineeLevelId').val('');
		$('#configure-elective-rotation #<portlet:namespace/>traineePdTlErDetailsId').val('');
		$('#electiveRotationList').empty();
		$('#ersortlist').empty();
		erdata = [];
		ervalueData = [];
	}
	
</script>