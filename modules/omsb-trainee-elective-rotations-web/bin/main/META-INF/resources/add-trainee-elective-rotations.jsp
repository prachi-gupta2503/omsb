<%@ include file="/init.jsp"%>

<liferay-ui:error key="traineeLevelError"
	message="rotation-with-trainee-level-exist" />
<liferay-ui:error key="electiveRotationCountError"
	message="elective-rotation-count-limit" />

<portlet:actionURL
	name="<%=OmsbTraineeElectiveRotationsWebPortletKeys.SAVE_TRAINEE_ELECTIVE_ROTATIONS_MVC_ACTION_COMMAND%>"
	var="saveTraineeElectiveRotations" copyCurrentRenderParameters="false">
	
	<portlet:param name="redirect" value="${currentURL}" />
</portlet:actionURL>

<portlet:resourceURL id="/get/electiverotations"
	var="fetchElectiveRotations"/>

<liferay-ui:error key="levelTypeNameError"
	message="elective-rotation-selection-required" />

<div class="row">
	<div class="col-md-12">
		<div class="omsb-card">
			<h4 class="omsb-card-title">
				<liferay-ui:message key="my-elective-rotations" />
			</h4>
			<aui:form action="${saveTraineeElectiveRotations}"
				name="electiveRotationForm">
				<div class="omsb-list-filter omsb-more-btn">
					<div class="row">
						<div class="col-lg-6 col-md-6 col-sm-12 label-box">
							<label class="label-name"><liferay-ui:message key="program" /></label>
							<label class="label-content">${programName}</label>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-12 label-box">
							<div class="form-group">
								<aui:select cssClass="custom-select form-control"
									label="trainee-level" id="traineeLevelId" name="traineeLevelId"
									 ignoreRequestValue = "true">
									<aui:option value="0" selected="true" cssClass="placeholder" ><liferay-ui:message key="please-select-trainee-level" /></aui:option>
									<c:forEach items="${traineeLevelMap}" var="entry">
										<aui:option value="${entry.key}">${entry.value}</aui:option>
									</c:forEach>
									<aui:validator name="required" />
								</aui:select>
								<label id="traine_level_error" class="error-container"
									style="display: none;"><liferay-ui:message key="this-field-is-required" /></label>
							</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-12">
							<div class="form-group">
								<label for="electiveRotationList"><liferay-ui:message key="select-elective-rotation" /><span style="color:red">*</span></label>
								<div class="elective_rotation_list_wrap" id="electiveRotationList"></div>
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
						<button class="btn omsb-bc-red-button" type="submit" title="Save"
							onclick=" return generateInputsForElectiveRotations()">
							<liferay-ui:message key="save" />
						</button>
						<a href="${addTraineeElectiveRotations}"
							class="btn omsb-bc-red-button" type="reset" title="Reset"> <liferay-ui:message
								key="reset" />
						</a>
					</div>
				</div>
			</aui:form>
		</div>
	</div>
</div>

<div class="row">
	<jsp:include page="/trainee-elective-rotations-list.jsp" />
</div>

<script type="text/javascript">
	
	var data = [];
	var valueData = [];
	function changeElectiveRotations(checkBox) {
		if($(checkBox).is(":checked")){
			document.getElementById('selected_list_items_error').style.display = "none";
			data.push({name: $(checkBox).val()});
			valueData.push({value: $(checkBox).data('id')});
			if(data.length == 3){
				$("input[name='elective_srotation']").each(function(){
					if($(this).is(":checked") == false){
						$(this).addClass('disable');
						$(this).prop('disabled', true);
					}
 				});					
			}
			
			addedElectiveList(data, valueData);
		} else {
			const newData = data.filter((item) => item.name != $(checkBox).val());
			data = newData;
			const newValueData = valueData.filter((item) => item.value != $(checkBox).data('id'));
			valueData = newValueData;
			$(".elective_rotation_list_wrap .custom-control-input").prop('disabled', false);
			$(".elective_rotation_list_wrap .custom-control-input").removeClass('disable');
			addedElectiveList(data, valueData);
		}
	}

	function addedElectiveList(data, valueData){
		
		$("#sortlist").empty()
		$.each(data, function( index, item ) {
			$("#sortlist").append("<li value='"+valueData[index].value+"' class = 'selected-elective-rotation-list'>"+ item.name +"</li>")
		});
		slist(document.getElementById("sortlist"));
	}
	slist(document.getElementById("sortlist"));

	$('#<portlet:namespace/>traineeLevelId').change(function() {
		validateTraineLeavel();
		document.getElementById('selected_list_items_error').style.display = "none";
		var traineeLevelId = $(this).val();
		
		if (traineeLevelId != null || traineeLevelId != "" && traineeLevelId != 0 ) {
			loadElectiveRotations(traineeLevelId, '${fetchElectiveRotations}');
		}
		else
		{
			var emptyelectiveRotationDiv = "<div class='elective_rotation_list'></div>";
			$('.elective_rotation_list_wrap').html(emptyelectiveRotationDiv);
		}
	});

	function loadElectiveRotations(traineeLevelId, fetchElectiveRotationsURL) {
		
		validateTraineLeavel();
		$("#sortlist").empty();
		data.length = 0
		$.ajax({
			url : fetchElectiveRotationsURL,
			type : 'POST',
			data : {
				<portlet:namespace/>selectedTraineeLevelId : traineeLevelId
			},
			success : function(payload) {
				if (payload.success) {
					$('.elective_rotation_list_wrap').html("");
					var index = 1;
					var electiveRotationDiv = "";
					$.each(payload.result, function(key, value) {
						electiveRotationDiv += "<div class='elective_rotation_list'><div class='custom-control custom-checkbox'><input type='checkbox' onchange='changeElectiveRotations(this)' class='custom-control-input' data-id='"+key+"' value='"+value+"' id='elective"+index+"' name='elective_srotation'><label class='custom-control-label' for='elective"+index+"'>"+value+"</label></div></div>";
						index++;
					});
					$('.elective_rotation_list_wrap').html(electiveRotationDiv);
				}
			}
		});
	}

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
		validateTraineLeavel();
		if($('.custom-control-input:checked').length > 0){
			return true;
		}
		document.getElementById('selected_list_items_error').style.display = "block";
		return false;
	}
	
	function validateTraineLeavel()
	{
		
		let e = document.getElementById('<portlet:namespace/>traineeLevelId');
		let traineLevalValue = e.options[e.selectedIndex].value;
		
		if(traineLevalValue<=0 || traineLevalValue == '')
			{
			 document.getElementById('traine_level_error').style.display = "block";
			}
		else{
			document.getElementById('traine_level_error').style.display = "none";
		}
	}
</script>