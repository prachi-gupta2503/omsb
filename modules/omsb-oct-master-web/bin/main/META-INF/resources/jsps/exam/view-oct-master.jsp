<%@ include file="../../init.jsp"%>

<portlet:renderURL var="octExamSetup">
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.OCT_MASTER_SETUP%>" />
	<portlet:param name="cmd" value="addExam" />
</portlet:renderURL>

<portlet:renderURL var="newTrainingSiteSlot">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MVCCommandNames.OCT_TRAINING_SITE_SLOT_MAPPING_RENDER%>" />
</portlet:renderURL>

<portlet:renderURL var="newTrainingSite">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MVCCommandNames.OCT_NEW_TRAINING_SITE_RENDER%>" />
</portlet:renderURL>

<portlet:renderURL var="newExamTitle">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MVCCommandNames.OCT_NEW_EXAM_TITLE_RENDER%>" />
</portlet:renderURL>

<div id="wrapper">
	<div class="container">
		<div class="omsb-card">
			<div class="master-rotation_tab">
				<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
					<li class="nav-item" role="presentation">
						<button class="nav-link active" id="pills-trainees-tab" data-toggle="pill"
								data-target="#pills-trainees" type="button" role="tab"
								aria-controls="pills-trainees" aria-selected="true" onclick="openExamTittleView()">
								<span></span>
						<liferay-ui:message key="new-exam-title" /><a href="${newExamTitle}"></a></button>
					</li>
					<li class="nav-item" role="presentation">
						<button class="nav-link" id="pills-rotation-tab" data-toggle="pill"
								data-target="#pills-rotation" type="button" role="tab"
								aria-controls="pills-rotation" aria-selected="false" onclick="openTrainingSiteView()">
								<span></span>
							<liferay-ui:message key="oct-training-site" /></button>
					</li>
					
					<li class="nav-item" role="presentation">
						<button class="nav-link" id="pills-rotation-tab" data-toggle="pill"
								data-target="#pills-rotation" type="button" role="tab"
								aria-controls="pills-rotation" aria-selected="false" onclick="openTrainingSiteMapping()">
								<span></span>
							<liferay-ui:message key="new-training-site-slot-mapping" /></button>
					</li>
											
					</ul>
				</div>
				
			 <div id="exam-tittle-view">
   				<%@ include file="/jsps/exam/oct-exam-title.jsp"%>
 			 </div>
 			  <div id="training-site-view" class="d-none">
   				   <%@ include file="/jsps/exam/oct-training-site.jsp"%>
 			 </div>	
 			 <div id="training-site-mapping-view" class="d-none">
   				   <%@ include file="/jsps/exam/training-site-slot-mapping.jsp"%>
 			 </div>	
		</div>
		
	</div>
</div>	




<script>

function openTrainingSiteView(){
	
	 $('#exam-tittle-view').addClass('d-none');
	 $('#training-site-view').removeClass('d-none');
	 $('#training-site-mapping-view').addClass('d-none');
}
  
 function openExamTittleView() {
	 $('#training-site-view').addClass('d-none');
	 $('#exam-tittle-view').removeClass('d-none');
	 $('#training-site-mapping-view').addClass('d-none');
  }
 
 function openTrainingSiteMapping() {
	 $('#training-site-view').addClass('d-none');
	 $('#exam-tittle-view').addClass('d-none');
	 $('#training-site-mapping-view').removeClass('d-none');
	 
  }
</script>