<!-- Inner Wrapper Contents -->
<div id="wrapper">
	<div class="container">
		<div class="omsb-card">
			<div class="omsb-page-top-info m-0">
				<div class="omsb-page-top-info">
					<div class="pagetitle">Admin Upload Result Screen</div>
					<div class="information">
						<button class="btn omsb-bg-red-button" type="button">Allow
							Notification</button>
					</div>
				</div>
			</div>
			<div class="omsb-list-filter omsb-more-btn">
				<div class="row">
					<div class="col-lg-4 col-md-6">
						<div class="form-group">
							<label>Exam Title</label> <input type="text" name="examTitle"
								class="form-control">
						</div>
					</div>
					<div class="col-lg-4 col-md-6">
						<div class="form-group">
							<label>Exam Start Date</label> <input type="text"
								name="verification_date" id="examstartdate"
								placeholder="DD/MM/YYYY" class="form-control datePicker">
						</div>
					</div>
					<div class="col-lg-4 col-md-6">
						<div class="form-group">
							<label>Exam End Date</label> <input type="text"
								name="verification_date" id="examenddate"
								placeholder="DD/MM/YYYY" class="form-control datePicker">
						</div>
					</div>
				</div>
				<div class="filter-button-wrap">
					<button class="btn omsb-bc-red-button">Download Result
						template</button>
					<button class="btn omsb-bc-red-button">Choose File</button>
					<button class="btn omsb-btn btn-red" id="uresultbtn">Upload
						Result</button>
				</div>

			</div>

			<div class="omsb-list-view table-responsive">
				<table class="display omsb-datatables">
					<thead>
						<tr>
							<th>Name</th>
							<th>FInal result</th>
							<th>Percentage</th>
							<th>Appeared</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>Diabetes</td>
							<td><div class="form-group">
									<select name="profession" id="profession"
										class="custom-select form-control">
										<option></option>
										<option value="Pass">Pass</option>
										<option value="Fail">Fail</option>
									</select>
								</div></td>
							<td>
								<div class="form-group">
									<input type="text" name="ExamType" class="form-control">
								</div>
							</td>
							<td><div class="form-group">
									<select name="profession" id="profession"
										class="custom-select form-control">
										<option></option>
										<option value="Pass">Pass</option>
										<option value="Fail">Fail</option>
									</select>
								</div></td>
						</tr>
						<tr>
							<td>Mohammed saleh</td>
							<td><div class="form-group">
									<select name="profession" id="profession"
										class="custom-select form-control">
										<option></option>
										<option value="Pass">Pass</option>
										<option value="Fail">Fail</option>
									</select>
								</div></td>
							<td>
								<div class="form-group">
									<input type="text" name="ExamType" class="form-control">
								</div>
							</td>
							<td><div class="form-group">
									<select name="profession" id="profession"
										class="custom-select form-control">
										<option></option>
										<option value="Pass">Pass</option>
										<option value="Fail">Fail</option>
									</select>
								</div></td>
						</tr>
					</tbody>
				</table>
			</div>

			<div class="bottom-backbtn-wrap">
				<button class="btn omsb-bc-red-button" title="Save">Save</button>
				<a class="btn omsb-btn btn-back" href="#"><i
					class="fi fi-sr-arrow-left"></i>Back</a>
			</div>
		</div>
	</div>
</div>
<!--// Inner Wrapper Contents -->


<!--// Uploaded Results pop up -->

<div class="modal fade omsb-modal" id="uploadresultpopup" tabindex="-1"
	role="dialog" aria-labelledby="exampleModalCenterTitle"
	aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered w-50" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLongTitle">Uploaded
					Results</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<form name="uploadresultpopupform" id="uploadresultpopupform"
					method="post"></form>
				<div class="omsb-card omsb-card-graybg row">
					<div class="col-md-12">
						<div class="form-group">
							<label>Number of success Record: <span>12</span></label>
						</div>
					</div>
					<div class="col-md-12 mt-5">
						<hr>
					</div>

					<div class="col-md-12">
						<div class="form-group">
							<label>Number of Fail Record: <span>03</span></label>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn omsb-bc-red-button" type="button"
					title="Mark Insufficient" id="confirm">ok</button>
				<button type="button" class="btn omsb-btn omsb-bg-red-button"
					data-dismiss="modal">cancel</button>
			</div>
		</div>
	</div>
</div>

<!--// Uploaded Results pop up -->

<!--- Start JS files Here --->
<script type="text/javascript" src=".././js/popper.min.js"></script>
<script type="text/javascript"
	src="https://cdn.usebootstrap.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="https://cdn.usebootstrap.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src=".././js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript"
	src=".././js/datatables/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src=".././js/datatables/dataTables.bootstrap4.min.js"></script>
<script type="text/javascript"
	src=".././js/datatables/dataTables.responsive.min.js"></script>
<script type="text/javascript"
	src=".././js/datatables/responsive.bootstrap4.min.js"></script>
<script type="text/javascript" src="../js/custom.js"></script>
<script type="text/javascript">
	$('#examstartdate').datepicker({
		dateFormat : 'dd-mm-yyyy'
	});

	$('#examenddate').datepicker({
		dateFormat : 'dd-mm-yyyy'
	});

	$("[data-bs-toggle='dropdown']").click(function() {
		$(this).siblings("ul.dropdown-menu").toggleClass("show");
	})

	$(document)
			.ready(
					function() {
						var trigger = $('.hamburger'), overlay = $('.overlay'), isClosed = false;

						trigger.click(function() {
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

						$('[data-toggle="offcanvas"]').click(function() {
							$('#omsb-main-wrapper').toggleClass('toggled');
						});
					});

	$('#uresultbtn').on('click', function(e) {
		var $form = $(this).closest('form');
		e.preventDefault();
		$('#uploadresultpopup').modal({
			backdrop : 'static',
			keyboard : false
		}).on('click', '#confirm', function(e) {
			$form.trigger('submit');
			console.log("confirm by user");
			$('#uploadresultpopup').modal("hide");
		});
		$("#cancel").on('click', function(e) {
			e.preventDefault();
			$('#uploadresultpopup').modal("hide");
		});
	});
</script>
<!--// End JS files Here --->