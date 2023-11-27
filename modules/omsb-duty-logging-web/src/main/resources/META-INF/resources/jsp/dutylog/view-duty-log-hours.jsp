<%@ include file="../../init.jsp" %>

<section class="omsb-main-wrapper" id="omsb-main-wrapper">
	<div id="wrapper">
		<div class="container">
			<div class="omsb-card">
				<div class="omsb-page-top-info">
				</div>
				
				<aui:form action="#" name="add_Log_Duty_Hours" method="post" class="log-duty-hours-form">
					<aui:input cssClass="form-control" type="hidden" name="dutyLogId" id="dutyLogId" value=""/>
					
					<div class="row">
						<div class="col-sm-6">
							<div class="form-group">
								<aui:input type="text" class="form-control" name="programName" id="programName" value="${dutyLogHoursDTO.program}"  label="duty-log-hour-program-name"/>
							</div>
						</div>
						
						<div class="col-sm-6">
							<div class="form-group">
								<aui:input type="text" name="trainingCenter" id="trainingCenter" class="form-control" label="duty-log-hour-training-center" value="${dutyLogHoursDTO.trainingCenter}"/>																		
							</div>
						</div>
					</div>

					<div class="row">
							<div class="col-sm-6 ">
								<div class="form-group">
									<aui:input type="text" name="assignment" id="assignment" class="form-control" label="duty-log-hour-assignment" value="${dutyLogHoursDTO.assignment}"/>
								</div>
							</div>
							
							<div class="col-sm-6">
								<div class="form-group">
									<aui:input type="text" name="dutyType" id="dutyType" class="form-control" label="duty-log-hour-duty-type" value="${dutyLogHoursDTO.dutyType}"/>
								</div>
							</div>
					</div>

					<div class="row">								
							<div class="col-sm-6">
								<div class="form-group">
									<aui:input type="text"  class="form-control datepicker" name="startDate" id="startDate" label="duty-log-hour-start-date" value="${dutyLogHoursDTO.startDate}"/>
								</div>
							</div>
							
							<div class="col-sm-6">
								<div class="form-group">
									<aui:input  type="text" class="form-control datepicker" name="endDate" id="endDate"  label="duty-log-hour-end-date" value="${dutyLogHoursDTO.endDate}"/>
								</div>
							</div>
					</div>

					<div class="row">	
						<div class="col-sm-6">
							<div class="form-group">
								<aui:input  type="text" class="form-control" name="duration" id="duration"  label="duty-log-hour-duration" value="${dutyLogHoursDTO.duration}"/>
							</div>
						</div>	
					</div>

				</aui:form>
			</div>
		</div>
	</div>
</section>

	<!--- Start JS files Here --->
<script type="text/javascript" src=".././js/popper.min.js"></script>
<script type="text/javascript" src="https://cdn.usebootstrap.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://cdn.usebootstrap.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src=".././js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript" src=".././js/datatables/jquery.dataTables.min.js"></script>
<script type="text/javascript" src=".././js/datatables/dataTables.bootstrap4.min.js"></script>
<script type="text/javascript" src=".././js/datatables/dataTables.responsive.min.js"></script>
<script type="text/javascript" src=".././js/datatables/responsive.bootstrap4.min.js"></script>
<script type="text/javascript" src="../js/custom.js"></script>
    
<script type="text/javascript">

	$('#applicabledate').datepicker({
		dateFormat: 'dd-mm-yyyy'
	});

	$('#examenddate').datepicker({
		dateFormat: 'dd-mm-yyyy'
	});
	
	function validateForm(add_Log_Duty_Hours){
		var liferayForm = Liferay.Form.get(add_Log_Duty_Hours);
		if(liferayForm){
			var validator = liferayForm.formValidator;
			validator.validate();
			var hasErrors = validator.hasErrors();
			if(hasErrors){
				validator.focusInvalidField();
				return false;
			}
		}
		return true;
	}
	
</script>