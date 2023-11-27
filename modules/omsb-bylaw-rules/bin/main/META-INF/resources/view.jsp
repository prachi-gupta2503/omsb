<%@ include file="/init.jsp" %>



<div id="wrapper">
				<div class="container">
					<div class="omsb-card">
						<div class="omsb-page-top-info">
							<div class="pagetitle">List of Rules</div>
							<div class="information">
								<button class="btn omsb-bc-red-button">Add New Rule</button>
							</div>
						</div>
                        
                        <div class="omsb-card omsb-card-graybg omsb-BorderRadius-4 omsb-card-graybg-title">
							<div class="pagetitle">Add New Rule</div>
                            <div class="row">
                                <div class="col-lg-12 col-md-12">
                                    <div class="form-group">
                                        <label>Select Value</label>
                                        <select name="ExamType" id="ExamType"  class="custom-select form-control">
                                            <option value="">Examination</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="row elective-rotation-row available-parameter-main">
								<div class="col-lg-6 col-md-6 col-sm-12 leftbar">
									<div class="form-group">
										<div class="available-parameter mb-1">
											<label>Available Parameter*</label>
											<a href="javascript:void(0)" class="mb-1" data-toggle="modal" data-target="#addnewparameter">+ Add new Parameter</a>
										</div>
										<div class="elective_rotation_list_wrap">
											<div class="elective_rotation_list">
												<div class="custom-control custom-checkbox">
													<input type="checkbox" class="custom-control-input" value="General pediatrics" id="elective1" name="elective_srotation">
													<label class="custom-control-label" for="elective1">General pediatrics</label>
												</div>
											</div>
											<div class="elective_rotation_list">
												<div class="custom-control custom-checkbox">
													<input type="checkbox" class="custom-control-input" value="CABC" id="elective2" name="elective_srotation">
													<label class="custom-control-label" for="elective2">CABC</label>
												</div>
											</div>
											<div class="elective_rotation_list">
												<div class="custom-control custom-checkbox">
													<input type="checkbox" class="custom-control-input" value="Heart:General" id="elective3" name="elective_srotation">
													<label class="custom-control-label" for="elective3">Heart:General</label>
												</div>
											</div>
											<div class="elective_rotation_list">
												<div class="custom-control custom-checkbox">
													<input type="checkbox" class="custom-control-input" value="General pediatrics 1" id="elective4" name="elective_srotation">
													<label class="custom-control-label" for="elective4">General pediatrics 1</label>
												</div>
											</div>
											<div class="elective_rotation_list">
												<div class="custom-control custom-checkbox">
													<input type="checkbox" class="custom-control-input" value="General pediatrics 2" id="elective5" name="elective_srotation">
													<label class="custom-control-label" for="elective5">General pediatrics 2</label>
												</div>
											</div>
											
											
										</div>
									</div>
									
								</div>

								<div class="col-lg-6 col-md-6 col-sm-12 rightbar">
									<div class="form-group">												
										<div class="elective_rotation_selected_list_items">
											<ul id="sortlist" class="slist">
												
											  </ul>
										</div>
									</div>
								</div>
							</div>
                            <div class="row">
                                <div class="col-lg-4 col-md-6">
                                    <div class="form-group">
                                        <label>Selected Parameter</label>
                                        <select name="ExamType" id="ExamType"  class="custom-select form-control">
                                            <option value="">Max no of attempts</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-6">
                                    <div class="form-group">
                                        <label>Select</label>
                                        <select name="selectIsandIn" id="selectIsandIn"  class="custom-select form-control">
                                            <option value="is">Is</option>
											<option value="in">In</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-6">
                                    <div class="form-group">
                                        <label>Enter Value</label>
                                        <select name="ExamType" id="ExamType1"  class="custom-select form-control">                                            
                                            <option value="Part-1 Exam">Part-1 Exam</option>
                                            <option value="Part-2 Exam">Part-2 Exam</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="bottom-backbtn-wrap m-0">
                                <button class="btn omsb-bc-red-button m-0" id="table_search">Search</button>
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
			
			<!-- Modal -->
		<div class="modal fade omsb-modal" id="addnewparameter" tabindex="-1" role="dialog"
			aria-labelledby="addnewparameterTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle">Add New Parameter</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label>Paramater</label>
									<input type="text" class="form-control" value="|">
								</div>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button class="btn omsb-bc-red-button" type="button" title="add">Add</button>
					</div>
				</div>
			</div>
		</div>

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
			$('#ExamType1').removeAttr('multiple');
			$('#ExamType1').multiselect('destroy');
		}else{
			$('#ExamType1').prop('multiple', 'multiple');
			$('#ExamType1').multiselect({includeSelectAllOption: true});
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