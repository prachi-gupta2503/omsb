<%@page import="gov.omsb.master.web.constants.MVCCommandNames"%>
<%@ include file="../../init.jsp"%>


<portlet:renderURL var="omsbExamSpecialityMaster">
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.OMSB_EXAM_SPECIALITY_MASTER_RENDER%>" />
	<portlet:param name="cmd" value="addExam" />
</portlet:renderURL>

<portlet:renderURL var="omsbExamSubSpecialityMaster">
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.OMSB_EXAM_SUB_SPECIALITY_MASTER_RENDER%>" />
	<portlet:param name="cmd" value="addExam" />
</portlet:renderURL>

<portlet:renderURL var="omsbExamSpecialityMapping">
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.OMSB_EXAM_SPECIALITY_MAPPING_RENDER%>" />
	<portlet:param name="cmd" value="addExam" />
</portlet:renderURL>

<portlet:renderURL var="omsbInstitutionMaster">
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.OMSB_INSTITUTION_MASTER_RENDER%>" />
	<portlet:param name="cmd" value="addExam" />
</portlet:renderURL>

<portlet:renderURL var="omsbCertificationMaster">
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.OMSB_CERTIFICATION_MASTER_RENDER%>" />
	<portlet:param name="cmd" value="addExam" />
</portlet:renderURL>



<div id="wrapper">
	<div class="container">
		<div class="omsb-card">
			<div class="master-rotation_tab">
				<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
					<li class="nav-item" role="presentation">
						<button class="nav-link active" id="pills-trainees-tab"
							data-toggle="pill" data-target="#pills-trainees" type="button"
							role="tab" aria-controls="pills-trainees" aria-selected="true"
							onclick="openSpecialityView()">
							<span></span>
							<liferay-ui:message key="speciality-master" />
						</button>
					</li>
					<li class="nav-item" role="presentation">
						<button class="nav-link" id="pills-rotation-tab"
							data-toggle="pill" data-target="#pills-rotation" type="button"
							role="tab" aria-controls="pills-rotation" aria-selected="false"
							onclick="openSpecialityMappingView()">
							<span></span>
							<liferay-ui:message key="speciality-mapping" />
						</button>
					</li>

					<li class="nav-item" role="presentation">
						<button class="nav-link" id="pills-rotation-tab"
							data-toggle="pill" data-target="#pills-rotation" type="button"
							role="tab" aria-controls="pills-rotation" aria-selected="false"
							onclick="openInstitutionMapping()">
							<span></span>
							<liferay-ui:message key="institution-mapping" />
						</button>
					</li>

					<li class="nav-item" role="presentation">
						<button class="nav-link" id="pills-rotation-tab"
							data-toggle="pill" data-target="#pills-rotation" type="button"
							role="tab" aria-controls="pills-rotation" aria-selected="false"
							onclick="openCertificationMapping()">
							<span></span>
							<liferay-ui:message key="certification-mapping" />
						</button>
					</li>
					
					<li class="nav-item" role="presentation">
						<button class="nav-link" id="pills-rotation-tab"
							data-toggle="pill" data-target="#pills-rotation" type="button"
							role="tab" aria-controls="pills-rotation" aria-selected="false"
							onclick="openWorkSectorMapping()">
							<span></span>
							<liferay-ui:message key="work-sector-mapping" />
						</button>
					</li>
					
					<li class="nav-item" role="presentation">
						<button class="nav-link" id="pills-rotation-tab"
							data-toggle="pill" data-target="#pills-rotation" type="button"
							role="tab" aria-controls="pills-rotation" aria-selected="false"
							onclick="openProfessionMapping()">
							<span></span>
							<liferay-ui:message key="profession-speciality-mapping" />
						</button>
					</li>
					
					<li class="nav-item" role="presentation">
						<button class="nav-link" id="pills-rotation-tab"
							data-toggle="pill" data-target="#pills-rotation" type="button"
							role="tab" aria-controls="pills-rotation" aria-selected="false"
							onclick="openDepartmentSectionMapping()">
							<span></span>
							<liferay-ui:message key="department-section-mapping" />
						</button>
					</li>
					
					<li class="nav-item" role="presentation">
						<button class="nav-link" id="pills-rotation-tab"
							data-toggle="pill" data-target="#pills-rotation" type="button"
							role="tab" aria-controls="pills-rotation" aria-selected="false"
							onclick="openSectionFunctionMapping()">
							<span></span>
							<liferay-ui:message key="section-function-mapping" />
						</button>
					</li>
					
					<li class="nav-item" role="presentation">
						<button class="nav-link" id="pills-rotation-tab"
							data-toggle="pill" data-target="#pills-rotation" type="button"
							role="tab" aria-controls="pills-rotation" aria-selected="false"
							onclick="openCountryMapping()">
							<span></span>
							<liferay-ui:message key="country-master" />
						</button>
					</li>

				</ul>
			</div>
				
			<div>	
				  <div id="exam-speciality-view" >
	   			<%@ include file="/jsps/exam/omsb-exam-speciality-master.jsp"%> 
	 			 </div>
	 			  <div id="speciality-mapping-view" class="d-none">
	   				   <%@ include file="/jsps/exam/omsb-exam-speciality-mapping.jsp"%>
	 			 </div>	
	 			 <div id="institution-master-view" class="d-none">
	   				   <%@ include file="/jsps/exam/omsb-institution-master.jsp"%> 
	 			 </div>
	 			  <div id="certification-master-view" class="d-none">
	   				   <%@ include file="/jsps/exam/omsb-certification-master.jsp"%> 
	 			 </div>
	 			 <div id="work-sector-master-view" class="d-none">
	   				   <%@ include file="/jsps/exam/work-sector-master.jsp"%> 
	 			 </div> 
	 			 
	 			  <div id="profession-specilaity-view" class="d-none" >
	   				  <%@ include file="/jsps/exam/omsb-profession-speciality-mapping.jsp"%> 
	 			 </div>
	 			 
	 			  <div id="department-section-view" class="d-none" >
	   				  <%@ include file="/jsps/exam/deparment-section.jsp"%> 
	 			 </div>
	 			 
	 			 <div id="section-function-view" class="d-none" >
	   				  <%@ include file="/jsps/exam/department-section-function.jsp"%> 
	 			 </div>
	 			 
	 			  <div id="country-view" class="d-none" >
	   				  <%@ include file="/jsps/exam/country-master.jsp"%> 
	 			 </div>
 			 </div>
		</div>
	</div>
</div>	



<script>

function openSpecialityView(){
	
	 $('#exam-speciality-view').removeClass('d-none');
	 $('#speciality-mapping-view').addClass('d-none');
	 $('#institution-master-view').addClass('d-none');
	 $('#certification-master-view').addClass('d-none');
	 $('#work-sector-master-view').addClass('d-none');
	 $('#profession-specilaity-view').addClass('d-none');
	 $('#department-section-view').addClass('d-none');
	 $('#section-function-view').addClass('d-none');
	 $('#country-view').addClass('d-none');
}
  
 function openSpecialityMappingView() {
	 $('#exam-speciality-view').addClass('d-none');
	 $('#speciality-mapping-view').removeClass('d-none');
	 $('#institution-master-view').addClass('d-none');
	 $('#certification-master-view').addClass('d-none');
	 $('#work-sector-master-view').addClass('d-none');
	 $('#profession-specilaity-view').addClass('d-none');
	 $('#department-section-view').addClass('d-none'); 
	 $('#section-function-view').addClass('d-none');
	 $('#country-view').addClass('d-none');
 }
 
 function openInstitutionMapping() {
	 $('#exam-speciality-view').addClass('d-none');
	 $('#speciality-mapping-view').addClass('d-none');
	 $('#institution-master-view').removeClass('d-none');
	 $('#certification-master-view').addClass('d-none');
	 $('#work-sector-master-view').addClass('d-none');
	 $('#profession-specilaity-view').addClass('d-none');
	 $('#department-section-view').addClass('d-none'); 
	 $('#section-function-view').addClass('d-none');
	 $('#country-view').addClass('d-none');
  }
 
 function openCertificationMapping() {
	 $('#exam-speciality-view').addClass('d-none');
	 $('#speciality-mapping-view').addClass('d-none');
	 $('#institution-master-view').addClass('d-none');
	 $('#certification-master-view').removeClass('d-none');
	 $('#work-sector-master-view').addClass('d-none');
	 $('#profession-specilaity-view').addClass('d-none');
	 $('#department-section-view').addClass('d-none');
	 $('#section-function-view').addClass('d-none');
	 $('#country-view').addClass('d-none');
  }
 
 function openWorkSectorMapping() {
	 $('#exam-speciality-view').addClass('d-none');
	 $('#speciality-mapping-view').addClass('d-none');
	 $('#institution-master-view').addClass('d-none');
	 $('#certification-master-view').addClass('d-none');
	 $('#work-sector-master-view').removeClass('d-none');
	 $('#profession-specilaity-view').addClass('d-none');
	 $('#department-section-view').addClass('d-none');
	 $('#section-function-view').addClass('d-none');
	 $('#country-view').addClass('d-none');
  }
 function openProfessionMapping() {
	 console.log("openProfessionMapping() started")
	 $('#profession-specilaity-view').removeClass('d-none');
	 $('#exam-speciality-view').addClass('d-none');
	 $('#speciality-mapping-view').addClass('d-none');
	 $('#institution-master-view').addClass('d-none');
	 $('#certification-master-view').addClass('d-none');
	 $('#work-sector-master-view').addClass('d-none');
	 $('#department-section-view').addClass('d-none');
	 $('#section-function-view').addClass('d-none');
	 $('#country-view').addClass('d-none');
	 
  }
 
 function openDepartmentSectionMapping() {
	 console.log("openProfessionMapping() started")
	 $('#profession-specilaity-view').addClass('d-none');
	 $('#exam-speciality-view').addClass('d-none');
	 $('#speciality-mapping-view').addClass('d-none');
	 $('#institution-master-view').addClass('d-none');
	 $('#certification-master-view').addClass('d-none');
	 $('#work-sector-master-view').addClass('d-none');
	 $('#department-section-view').removeClass('d-none');
	 $('#section-function-view').addClass('d-none');
	 $('#country-view').addClass('d-none');
	 
  }
 
 function openSectionFunctionMapping() {
	 console.log("openProfessionMapping() started")
	 $('#profession-specilaity-view').addClass('d-none');
	 $('#exam-speciality-view').addClass('d-none');
	 $('#speciality-mapping-view').addClass('d-none');
	 $('#institution-master-view').addClass('d-none');
	 $('#certification-master-view').addClass('d-none');
	 $('#work-sector-master-view').addClass('d-none');
	 $('#department-section-view').addClass('d-none');
	 $('#section-function-view').removeClass('d-none');
	 $('#country-view').addClass('d-none');
	 
  }
 
 function openCountryMapping() {
	 console.log("openProfessionMapping() started")
	 $('#profession-specilaity-view').addClass('d-none');
	 $('#exam-speciality-view').addClass('d-none');
	 $('#speciality-mapping-view').addClass('d-none');
	 $('#institution-master-view').addClass('d-none');
	 $('#certification-master-view').addClass('d-none');
	 $('#work-sector-master-view').addClass('d-none');
	 $('#department-section-view').addClass('d-none');
	 $('#section-function-view').addClass('d-none');
	 $('#country-view').removeClass('d-none');
	 
  }
 
 $('#workSector').DataTable({
		"bLengthChange": false,
		"bFilter": false,
		"ordering": false
	});
 $('.speciality-table-list').DataTable({
		"bLengthChange": false,
		"bFilter": false,
		"ordering": false
	});
</script>