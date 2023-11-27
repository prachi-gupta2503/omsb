<%@page import="gov.omsb.bylaw.rules.constants.MVCCommands"%>
<%@ include file="../../init.jsp"%>	

<portlet:resourceURL id="<%=MVCCommands.MODULE_AND_PARAMETER_MAPPING%>" var="moduleMappingParameter" />	
<portlet:resourceURL id="<%=MVCCommands.PARAMETER_VALUE_MAPPING%>" var="parameterValueMappingParameter" />	
<portlet:actionURL name="<%=MVCCommands.SAVE_BYLAW_RULES_CONDITION%>" var="saveByLawCondition" />

<portlet:renderURL var="ViewandAddlistofNewCondition">
<portlet:param name="mvcRenderCommandName" value="<%=MVCCommands.BY_LAW_CONDITION%>" />
</portlet:renderURL>

<div id="wrapper">
				<div class="container">
					<div class="omsb-card">
						<div class="omsb-page-top-info">
							<div class="pagetitle">List of Rules</div>
							<!-- <div class="information">
								<button class="btn omsb-bc-red-button">Add New Rule</button>
							</div> -->
						</div>
						
						    <div class="omsb-card omsb-card-graybg omsb-BorderRadius-4 omsb-card-graybg-title">
					<form action="${saveByLawCondition}" method="post" name="saveRegistrationFm" id="saveRegistrationFm" enctype="multipart/form-data">
			
							<div class="pagetitle">Add New Rule</div>
                            <div class="row">
                                <div class="col-lg-6 col-md-6">
                               
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
                                
                                 <div class="col-lg-6 col-md-6">
                                    <div class="form-group">
                                        <label>Select</label>
                                        <select name="<portlet:namespace/>selectAllandIn" id="selectAllandIn"  class="custom-select form-control">
                                            <option value=""><liferay-ui:message key="select" /></option>
                                            <option value="MatchAll"><liferay-ui:message key="MatchAll" /></option>
											<option value="MatchIn"><liferay-ui:message key="MatchIn" /></option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            
                           
                            <div class="row">
                                <div class="col-lg-4 col-md-6">
                                    <div class="form-group">
                                        <label>Selected Parameter</label>
                                        <select name='<portlet:namespace/>parameterName' id="selectedParameter"  class="custom-select form-control" onclick="setParameterValue()">
                                            <option value=""><liferay-ui:message key="select"></liferay-ui:message> </option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-6">
                                    <div class="form-group">
                                        <label>Select</label>
                                        <select name="<portlet:namespace/>conditionType" id="selectIsandIn"  class="custom-select form-control">
                                            <option value="is">Is</option>
											<option value="in">In</option>
                                        </select>
                                    </div>
                                </div>
                              <%--   <div class="col-lg-4 col-md-6">
                                    <div class="form-group">
                                        <label>Enter Value</label>
                                        <select name="<portlet:namespace/>conditionValue" id="ExamType1"  class="custom-select form-control">                                            
                                            <option value="Part-1 Exam">Part-1 Exam</option>
                                            <option value="Part-2 Exam">Part-2 Exam</option>
                                        </select>
                                    </div>
                                </div> --%>
                                
                                <div class="col-lg-4 col-md-6" id="enter-value-dropdown">
                                    <div class="form-group">
                                        <label>Enter Value</label>
                                        <select name="<portlet:namespace/>conditionValue" id="enterValue"  class="custom-select form-control">                                            
                                         <option value="">select</option>
                                        </select>
                                    </div>
                                </div>
                                
                                <div class="col-lg-4 col-md-6 d-none" id="valueText">
                                    <div class="form-group">
                                        <label>Enter Value</label>
                                        <input name='<portlet:namespace/>enterValueInput' id="enterValueInput" class="form-control"></input> 
                                    </div>
                                </div>
                            </div>
                                
                                
                            </div>
                            <div class="bottom-backbtn-wrap m-0">
                                <button type="submit "class="btn omsb-bc-red-button m-0" id="table_search"><liferay-ui:message key="add-condition" /></button>
                            </div>
                            
                             <div class="bottom-backbtn-wrap m-0">
                               <a href="${ViewandAddlistofNewCondition }"> <button type="button "class="btn omsb-bc-red-button m-0"  id="table_search"><liferay-ui:message key="add-new-condition" /></button></a>
                            </div>
                            </form>
                        </div>
                        
                        <!-- Modal -->
						<div class="modal fade omsb-modal" id="addnewparameter" tabindex="-1"
							role="dialog" aria-labelledby="addnewparameterTitle"
							aria-hidden="true">
							<div class="modal-dialog modal-dialog-centered" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLongTitle">Add New
											Parameter</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">
										<div class="row">
											<div class="col-md-12">
												<div class="form-group">
													<label>Paramater</label> <input
														name='<portlet:namespace/>paramter' type="text"
														class="form-control" value="">
												</div>
											</div>
										</div>
									</div>
									<div class="modal-footer">
										<button class="btn omsb-bc-red-button" type="button" title="add"
											onclick="saveForm()">Add</button>
									</div>
								</div>
							</div>
						</div>

			<div class="omsb-list-view table-responsive hide_dt_filter">
							<table class="display omsb-datatables" id="exam_list">
								<thead>
									<tr>
										<th>Rules</th>
										<th>VALUE</th>
										<th>ACTIONS</th>

									</tr>
								</thead>
								<tbody>
									<tr>
										<td>RULE 001</td>
										<td>Max no of attempt is 2</td>
										<td width="229">
											<d	iv class="dropdown ">
												<button class="btn fa fa-ellipsis-v dropdown-toggle" type="button"
													data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
													<i class=""></i>
												</button>
												<ul class="dropdown-menu">												
													<li><a href="#" data-toggle="modal" data-target="#editrule" class="dropdown-item" ><img src="../images/svg/fi-rr-edit.svg"> Edit</a></li>
													<li><a href="#" class="dropdown-item"><img src="../images/svg/fi-rr-delete.svg"> Delete</a></li>
                                                </ul>
											</div>
										</td>
									</tr>
									<tr>
										<td>DIabetes</td>
										<td>Selection</td>
										<td width="229">
											<div class="dropdown ">
												<button class="btn fa fa-ellipsis-v dropdown-toggle" type="button"
													data-bs-toggle="dropdown" aria-expanded="false">
													<i class=""></i>
												</button>
												<ul class="dropdown-menu">												
													<li><a href="#" data-toggle="modal" data-target="#editrule" class="dropdown-item"><img src="../images/svg/fi-rr-edit.svg"> Edit</a></li>
													<li><a href="#" class="dropdown-item"><img src="../images/svg/fi-rr-delete.svg"> Delete</a></li>
                                                </ul>
											</div>
										</td>
									</tr>
									<tr>
										<td>DIabetes</td>
										<td>Filteration</td>
										<td width="229">
											<div class="dropdown ">
												<button class="btn fa fa-ellipsis-v dropdown-toggle" type="button"
													data-bs-toggle="dropdown" aria-expanded="false">
													<i class=""></i>
												</button>
												<ul class="dropdown-menu">												
													<li><a href="#" data-toggle="modal" data-target="#editrule" class="dropdown-item"><img src="../images/svg/fi-rr-edit.svg"> Edit</a></li>
													<li><a href="#" class="dropdown-item"><img src="../images/svg/fi-rr-delete.svg"> Delete</a></li>
                                                </ul>
											</div>
										</td>
									</tr>


								</tbody>
							</table>
						</div>
						<div class="bottom-backbtn-wrap">
							<a class="btn omsb-btn btn-back" href="#"><i class="fi fi-sr-arrow-left"></i>Back</a>
						</div>
					</div>



				</div>
			</div>
			<!--// Inner Wrapper Contents -->
			
			
		<!--// Comments pop up -->

		<!-- Modal -->
		<div class="modal fade omsb-modal" id="editrule" tabindex="-1" role="dialog"
			aria-labelledby="editruleTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle">Edit Rule 1</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="omsb-card omsb-card-graybg omsb-BorderRadius-4">
                            <div class="row">
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label>Selected Parameter</label>
                                        <select name="ExamType" id="ExamType"  class="custom-select form-control">
                                            <option value="">Max no of attempts</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label>Select</label>
                                        <select name="ExamType" id="ExamType"  class="custom-select form-control">
                                            <option value="">is</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label>Enter Value</label>
                                        <input type="text" class="form-control" value="02">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="omsb-card omsb-card-graybg omsb-BorderRadius-4">
                            <div class="row">
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label>Selected Parameter</label>
                                        <select name="ExamType" id="ExamType"  class="custom-select form-control">
                                            <option value="">Max no of attempts</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label>Select</label>
                                        <select name="ExamType" id="ExamType"  class="custom-select form-control">
                                            <option value="">is</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label>Enter Value</label>
                                        <input type="text" class="form-control" value="02">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="omsb-card omsb-card-graybg omsb-BorderRadius-4">
                            <div class="row">
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label>Selected Parameter</label>
                                        <select name="ExamType" id="ExamType"  class="custom-select form-control">
                                            <option value="">Max no of attempts</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label>Select</label>
                                        <select name="ExamType" id="ExamType"  class="custom-select form-control">
                                            <option value="">is</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-group">
                                        <label>Enter Value</label>
                                        <input type="text" class="form-control" value="02">
                                    </div>
                                </div>
                            </div>
                        </div>
					</div>
					<div class="modal-footer">
						<button class="btn omsb-bc-red-button" type="button" title="Update">Update</button>
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
			if(selectedParameter == 'text'){
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
		
		
		
		</script>
			
			
	<!--- Start JS files Here --->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.0.4/popper.js"></script>	
	<script type="text/javascript" src="https://cdn.usebootstrap.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		src="https://cdn.usebootstrap.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript" src=".././js/bootstrap-datepicker.min.js"></script>
	<script type="text/javascript" src=".././js/datatables/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src=".././js/datatables/dataTables.bootstrap4.min.js"></script>
	<script type="text/javascript" src=".././js/datatables/dataTables.responsive.min.js"></script>
	<script type="text/javascript" src=".././js/datatables/responsive.bootstrap4.min.js"></script>
	<script type="text/javascript" src=".././js/bootstrap-multiselect/bootstrap-multiselect.min.js"></script>
	<script type="text/javascript" src="../js/custom.js"></script>
	<script type="text/javascript">

	$("#selectIsandIn").change(function(){		
		if($(this).val() == "is"){
			$('#enterValue').removeAttr('multiple');
			$('#enterValue').multiselect('destroy');
		}else{
			$('#enterValue').prop('multiple', 'multiple');
			$('#enterValue').multiselect({includeSelectAllOption: true});
		}
	});
	
	/*======= End multiselection on change of select either value is "IS" or "IN" ======*/

    /*======= Start Drag and Drop Sorting JS ======*/

		let data = [];
		
		$("input[name='elective_srotation']").change(function(e){
			if ($(this).is(":checked")){
				data.push({name: $(this).val()});
				// if(data.length == 3){
				// 	$("input[name='elective_srotation']").each(function(){
				// 		if($(this).is(":checked") == false){
				// 			$(this).addClass('disable');
				// 			$(this).prop('disabled', true);
				// 		}
  				// 	});					
				// }
				addedElectiveList(data);
			}else{
				const newData = data.filter((item) => item.name != $(this).val());
				data = newData;
				$(".elective_rotation_list_wrap .custom-control-input").prop('disabled', false);;
				$(".elective_rotation_list_wrap .custom-control-input").removeClass('disable');
				addedElectiveList(data);
			}
		});

		function addedElectiveList(data){			
			$("#sortlist").empty()			
			$.each(data, function( index, item ) {
				$("#sortlist").append("<li>"+ item.name +"</li>")
			});
			//slist(document.getElementById("sortlist"));
		}

		

		/*=======// End Drag and Drop Sorting JS ======*/

		$('#examstartdate').datepicker({
			dateFormat: 'dd-mm-yyyy'
		});
	
		$("[data-bs-toggle='dropdown']").click(function () {
			$(this).siblings("ul.dropdown-menu").toggleClass("show");
		})

		$(document).ready(function () {
			var trigger = $('.hamburger'),
				overlay = $('.overlay'),
				isClosed = false;

			trigger.click(function () {
				hamburger_cross();
			});

			function hamburger_cross() {

				if (isClosed == true) {
					overlay.hide();
					trigger.removeClass('is-open');
					trigger.addClass('is-closed');
					isClosed = false;
				} else {
					overlay.show();
					trigger.removeClass('is-closed');
					trigger.addClass('is-open');
					isClosed = true;
				}
			}

			$('[data-toggle="offcanvas"]').click(function () {
				$('#omsb-main-wrapper').toggleClass('toggled');
			});
		});
		
	</script>
	<!--// End JS files Here --->