<%@ include file="../../init.jsp"%>
<div id="wrapper">
	<div class="container">
		<div class="omsb-card">
			<div class="omsb-page-top-info m-0">
				<div class="omsb-page-top-info"></div>
			</div>
			<div class="master-rotation_tab">
				<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
					<li class="nav-item" role="presentation">
						<button class="nav-link active" id="pills-trainees-tab"
							data-toggle="pill" data-target="#pills-trainees" type="button"
							role="tab" aria-controls="pills-trainees" aria-selected="true" onclick="openExam()">
							<span></span>

							<liferay-ui:message key="exam-type" />
						</button>
					</li>
					<li class="nav-item" role="presentation">
						<button class="nav-link" id="pills-rotation-tab"
							data-toggle="pill" data-target="#pills-rotation" type="button"
							role="tab" aria-controls="pills-rotation" aria-selected="false" onclick="openProgram()">
							<span></span>
							<liferay-ui:message key="exam-type-mapping" />
						</button>
					</li>

				</ul>
			</div>
				<div  id="program-view" class="d-none">
   				   <%@ include file="/jsps/exam/omsb-program-exam-type.jsp"%>
 			 </div>	
			  <div id="exam-view" >
   				 <%@ include file="/jsps/exam/exam-type-eligibility.jsp"%>
 			 </div>  
 			    
		</div>
	</div>
</div>


<script>

function openExam(){
	
	 $('#exam-view').removeClass('d-none');
	 $('#program-view').addClass('d-none');
	
}
  
 function openProgram() {
	 $('#exam-view').addClass('d-none');
	 $('#program-view').removeClass('d-none');
  }
</script>

			