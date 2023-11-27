<%@page import="gov.omsb.bylaw.rules.constants.MVCCommands"%>
<%@ include file="../../init.jsp"%>	

<portlet:resourceURL id="<%=MVCCommands.MODULE_AND_PARAMETER_MAPPING%>" var="moduleMappingParameter" />	
<portlet:resourceURL id="<%=MVCCommands.PARAMETER_VALUE_MAPPING%>" var="parameterValueMappingParameter" />
<portlet:resourceURL id="<%=MVCCommands.DELETE_CONDITION%>" var="deleteBylawCondition" />

<portlet:actionURL name="<%=MVCCommands.SAVE_BYLAW_RULES_CONDITION%>" var="saveByLawCondition" />

<portlet:renderURL var="ByLawHomeURL">
	<portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>

<div id="wrapper">
				<div class="container">
					<div class="omsb-card">
						<div class="omsb-card omsb-card-graybg omsb-BorderRadius-4 omsb-card-graybg-title">
							<form action="${saveByLawCondition}" method="post" name="saveRegistrationFm" id="saveRegistrationFm" enctype="multipart/form-data">
								<div class="omsb-page-top-info">
										<div class="pagetitle"><liferay-ui:message key="add-new-condition" /></div>
								</div>
									<div class="row">
										<div class="col-lg-3 col-md-6">
		                                    <div class="form-group">
		                                        <label>Select Value</label>
		                                        <select name='<portlet:namespace/>ruleEngineModuleParameterId' id="moduleValue"  class="custom-select form-control" >
		                                            <option value=""><liferay-ui:message key="select" /> </option>
		                                            <c:forEach var="engineModuleParamter" items="${ruleEngineModuleParamters}">
												<option value="${engineModuleParamter.id}">
													<liferay-ui:message
														key="${engineModuleParamter.moduleName}" /></option>
											</c:forEach>
		                                        </select>
		                                    </div>
		                                </div>
		                                <div class="col-lg-3 col-md-6">
		                                    <div class="form-group">
		                                        <label><liferay-ui:message key="selected-parameter" /></label>
		                                        <select name='<portlet:namespace/>parameterName' id="selectedParameter"  class="custom-select form-control" onclick="setParameterValue()">
		                                            <option value=""><liferay-ui:message key="select"></liferay-ui:message> </option>
		                                        </select>
		                                    </div>
		                                </div>
		                                <div class="col-lg-3 col-md-6">
		                                    <div class="form-group">
		                                        <label><liferay-ui:message key="select"></liferay-ui:message></label>
		                                        <select name="<portlet:namespace/>conditionType" id="selectIsandIn" class="custom-select form-control">
		                                            <option value="is"><liferay-ui:message key="is" /></option>
													<option value="in"><liferay-ui:message key="in" /></option>
		                                        </select>
		                                    </div>
		                                </div>
		                                <div class="col-lg-3 col-md-6" id="enter-value-dropdown">
		                                   <div class="form-group">
		                                        <label><liferay-ui:message key="enter-value" /></label>
		                                        <select name="<portlet:namespace/>conditionValue" id="enterValue"  class="custom-select form-control">                                            
		                                         <option value=""><liferay-ui:message key="select"></liferay-ui:message></option>
		                                        </select>
		                                    </div>
		                                </div>
		                                
		                                 
		                                <div class="col-lg-3 col-md-6 d-none" id="valueText">
		                                    <div class="form-group">
		                                        <label><liferay-ui:message key="enter-value" /></label>
		                                        <input name='<portlet:namespace/>enterValueInput' id="enterValueInput" class="form-control"></input> 
		                                    </div>
		                                </div>
		                            </div>
							
							<div class="bottom-backbtn-wrap m-0">
								<button type="submit" class="btn omsb-bc-red-button m-0" id="Save"><liferay-ui:message key="save" /></button>
							</div>
						</div>
						
					</form>


						<div class="omsb-list-view table-responsive hide_dt_filter">
							<table class="display omsb-datatables" id="exam_list">
								<thead>
									<tr>
										<th><liferay-ui:message key="rules" /></th>
										<th><liferay-ui:message key="modulename" /></th>
										<th><liferay-ui:message key="value" /></th>
										<th><liferay-ui:message key="actions" /></th>

									</tr>
								</thead>
								<tbody>
									<c:forEach var="byLawConditions" items="${byLawConditions}" varStatus="count">
										<tr id="${byLawConditions.id }">
										<%-- 	<td>CONDITION ${count.index + 1 }</td> --%>
											<td>CONDITION ${byLawConditions.conditionKey}</td>
											<td>${byLawConditions.moduleName }</td>
											<td>${byLawConditions.conditionValue }</td>
											<td width="229">
												<button class="btn delete_btn" value="Delete"
													type="button" data-toggle="modal" data-target="#delete_row"
													onclick="delelte('${byLawConditions.id}')"
													data-rowcount="addPopUpRow">
													<img
														src="<%=themeDisplay.getPathThemeImages()%>/svg/delete_icon.svg"
														style="cursor: default;">
												</button>
												</div>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>

						<div class="bottom-backbtn-wrap">
							<a class="btn omsb-btn btn-back" href="${ByLawHomeURL }"><i class="fi fi-sr-arrow-left"></i>Back</a>
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
						<div class="omsb-card omsb-card-graybg row">
							<div>
								<liferay-ui:message key="are-you-want-to-delete" />
							</div>
						</div>
					</div>
					<input type="hidden" name='<portlet:namespace/>primaryId' id="primaryId" >
					<div class="modal-footer">
						<button class="btn omsb-bc-red-button" type="button" onclick="setDeleteID()" title="ok" ><liferay-ui:message key="yes" /></button>
						<button type="button" class="btn omsb-btn omsb-bg-red-button"
							data-dismiss="modal" id="uploadcancel"><liferay-ui:message key="no" /></button>
					</div>
				</div>
			</div>
		</div>
			
			
			
		<script>
		$('#moduleValue').change(function() {
			
			
			var ruleEngineModuleParameterId=$(this).val();
			console.log("moduleValue   :::")
			console.log(ruleEngineModuleParameterId);
			$.ajax({
				url: '${moduleMappingParameter}',
				async : false,
				dataType:"json",
				data : {
					'<portlet:namespace />ruleEngineModuleParameterId' : ruleEngineModuleParameterId,
				},
				type : 'POST',
				success : function(data) {
		            $('#selectedParameter').empty();
		            $('#selectedParameter').append("<option value=''><liferay-ui:message key="select"/></option> ");
		            $.each(data, function (i, item) {
		            	   $('#selectedParameter').append("<option value='" + item.parameterType + "'>" + item.parameterName + "</option> ");

		            })
		            },
			})
		})
			
		
		
		function setParameterValue(){

			var selectedParameter=$('#selectedParameter').val();
			 
			
			if(selectedParameter.split("_")[0] == 'text'){
				$('#enter-value-dropdown').addClass('d-none')
				$('#valueText').removeClass('d-none')
				console.log("selectedParameter   :::"+selectedParameter)
			}else{
				$('#valueText').addClass('d-none')
				$('#enter-value-dropdown').removeClass('d-none')
				
				console.log("selectedParameter   :::"+selectedParameter)
					$.ajax({
						url: '${parameterValueMappingParameter}',
						async : false,
						dataType:"json",
						data : {
							<portlet:namespace />selectedParameter : selectedParameter,
						},
						type : 'POST',
						success : function(data) {
				            $('#enterValue').empty();
				            $('#enterValue').append("<option value=''><liferay-ui:message key="select"/></option> ");
				            $.each(data, function (i, item) {
				            	
				            	   $('#enterValue').append("<option value='" + item.key + "'>" + item.name + "</option> ");
		
				            })
				            },
					})
					}
			
		}
		
		$("#selectAllandIn").change(function(){		
			if($(this).val() == "MatchIn"){
				$('#selectedParameter').removeAttr('multiple');
				$('#selectedParameter').multiselect('destroy');
			}else{
				$('#selectedParameter').prop('multiple', 'multiple');
				$('#selectedParameter').multiselect({includeSelectAllOption: true});
			}
		});
		
		function saveForm(){
			
			var value = document.getElementById("moduleValue").value;
			if(value != ""){
				document.getElementById("byLawForm").submit();
			}
			
		}
		
		$("#selectIsandIn").change(function(){		
			if($(this).val() == "is"){
				$('#enterValue').removeAttr('multiple');
				$('#enterValue').multiselect('destroy');
			}else{
				$('#enterValue').prop('multiple', 'multiple');
				$('#enterValue').multiselect({includeSelectAllOption: true});
			}
		});
		
		function delelte(id){
			console.log("id IIDDD"+id)
		var inputElement = document.getElementById("primaryId"); // Set the value of the input 
		console.log("inputElement "+ inputElement)
		$('#primaryId').val(id);
	}
		
	function setDeleteID(){
		var primId = $('#primaryId').val();
		console.log("primId  "+primId)
		$.ajax({
			url: '${deleteBylawCondition}',
			async : false,
			dataType:"json",
			data : {
				<portlet:namespace />primId : primId,
			},
			type : 'POST',
			success : function(data) {
				location.reload(true);
	            },
		})
		
	} 

		
		
		</script>