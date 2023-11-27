<%@ include file="/init.jsp"%>

<liferay-ui:error key="traineeLevelError" message="rotation-with-trainee-level-exist" />
<liferay-ui:error key="electiveRotationCountError" message="elective-rotation-count-limit" />


<portlet:actionURL
	name="<%=OmsbTraineeElectiveRotationsWebPortletKeys.SAVE_TRAINEE_ELECTIVE_ROTATIONS_MVC_ACTION_COMMAND%>"
	var="saveTraineeElectiveRotations">
	<portlet:param name="redirect" value="${currentURL}" />
</portlet:actionURL>

<portlet:resourceURL
	id="/get/electiverotations"
	var="fetchElectiveRotations" />

<liferay-ui:error key="levelTypeNameError"
	message="elective-rotation-selection-required" />


<div class="row">
	<div class="col-md-12">
		<div class="omsb-card">
			<h4 class="omsb-card-title">
				<liferay-ui:message key="my-elective-rotations" />
			</h4>
			<aui:form action="${saveTraineeElectiveRotations}" name="electiveRotationForm" >
				<div class="omsb-list-filter omsb-more-btn">
					<div class="row">
						<div class="col-lg-6 col-md-6 col-sm-12 label-box">
							<label class="label-name"><liferay-ui:message key="program" /></label>
							<label class="label-content">${programName}</label>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-12 label-box">
							<aui:input label="trainee-level" type="text" name="traineeLevelName"
								value="${traineeLevelName}" readonly="true" />
						</div>
						<div class="col-lg-6 col-md-6 col-sm-12">
							<div class="form-group">
								<label for="electiveRotationList"><liferay-ui:message key="select-elective-rotation" /><span style="color:red">*</span></label>
								<div class="elective_rotation_list_wrap" id="electiveRotationList">
									<c:forEach items="${availableTraineeRotationMap}" var="entry" varStatus="loop">
										<div class=elective_rotation_list">
											<div class="custom-control custom-checkbox">
												<input type="checkbox"
													onchange="changeElectiveRotations(this)"
													class="custom-control-input" data-id="${entry.key}"
													value="${entry.value}" id="elective${loop.index+1}"
													name="elective_srotation"><label
													class="custom-control-label" for="elective${loop.index+1}">${entry.value}</label>
											</div>
										</div>
									</c:forEach>
								</div>
								<label id="selected_list_items_error" class="error-container"
									style="display: none;"><liferay-ui:message key="this-field-is-required" /></label>
							</div>
							<div class="row">
								<div class="col-sm-12 form-group">
									<label class="error-container"><liferay-ui:message key="note-maximum-3-allowed" /></label>
								</div>
							</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-12 rightbar">
							<div class="form-group">												
								<div class="elective_rotation_selected_list_items">
									<ul id="sortlist">
										
									  </ul>
								</div>
							</div>
						</div>
					</div>
					<div id="selected-elective-rotations" style="display: none;">

					</div>
					<div class="bottom-backbtn-wrap m-0">
					<aui:input label="trainee-er-id" name="traineePdTlErDetailsId" type="hidden" value="${traineePdTlErDetailsId}" class="form-control" />
						<button class="btn omsb-bc-red-button" type="submit" title="Save" onclick="return generateInputsForElectiveRotations()" >
							<liferay-ui:message key="save" />
						</button>
						<a href="${addTraineeElectiveRotations}" class="btn omsb-bc-red-button"  type="reset" title="Cancel">
							<liferay-ui:message key="cancel" />
						</a>
					</div>
				</div>
			</aui:form>
		</div>
	</div>
</div>

<script type="text/javascript">

	var idData = [];
	var valData = [];
	
	function changeElectiveRotations(checkBox) {
		if($(checkBox).is(":checked")){
			document.getElementById('selected_list_items_error').style.display = "none";
			idData.push({name: $(checkBox).val()});
			valData.push({value: $(checkBox).data('id')});
			if(idData.length == 3){
				$("input[name='elective_srotation']").each(function(){
					if($(this).is(":checked") == false){
						$(this).addClass('disable');
						$(this).prop('disabled', true);
					}
 				});					
			}
			addedElectiveList(idData, valData);
		} else {
			const newData = idData.filter((item) => item.name != $(checkBox).val());
			idData = newData;
			const newValueData = valData.filter((item) => item.value != $(checkBox).data('id'));
			valData = newValueData;
			$(".elective_rotation_list_wrap .custom-control-input").prop('disabled', false);
			$(".elective_rotation_list_wrap .custom-control-input").removeClass('disable');
			addedElectiveList(idData, valData);
		}
	}

	function addedElectiveList(idData, valData){
		$("#sortlist").empty()
		$.each(idData, function( index, item ) {
			$("#sortlist").append("<li value='"+valData[index].value+"' class = 'selected-elective-rotation-list'>"+ item.name +"</li>")
		});
		slist(document.getElementById("sortlist"));
	}
	slist(document.getElementById("sortlist"));

	function generateInputsForElectiveRotations() {
		if(!validateSelectedElectiveRotations()) {
			return false;
		}
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
		return true;
	}
	
	function validateSelectedElectiveRotations()
	{
		if($('.custom-control-input:checked').length > 0){
			return true;
		}
		document.getElementById('selected_list_items_error').style.display = "block";
		return false;
	}
	
	$(document).ready(function() {
		
		var list = <%=request.getAttribute(OmsbTraineeElectiveRotationsWebPortletKeys.SELECTED_TRAINEE_ROTATION_LIST)%>;
		$.each(list, function(index, valueofSelectedCheckbox) {
			$("input[name='elective_srotation']").each(function(){
	            if($(this).data('id') == valueofSelectedCheckbox.rotationId){
	            	idData.push({name: $(this).val()});
	    			valData.push({value: $(this).data('id')});
	    			 $(this).prop('checked', true);
	    			if(idData.length == 3){
	    				$("input[name='elective_srotation']").each(function(){
	    					if($(this).is(":checked") == false){
	    						$(this).addClass('disable');
	    						$(this).prop('disabled', true);
	    					}
	     				});					
	    			}
	               
	    			addedElectiveList(idData, valData);
	            }
	        });
		});
	});
</script>