<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="init.jsp"%>

<portlet:resourceURL
	id="<%= OmsbMasterRotationScheduleWebPortletKeys.GET_ROTATION_MVC_RESOURCE_COMMAND %>"
	var="getRotationResourceCommandUrl">
</portlet:resourceURL>

<portlet:resourceURL
	id="<%=OmsbMasterRotationScheduleWebPortletKeys.GET_FACULTY_MVC_RESOURCE_COMMAND%>"
	var="getFacultyForMasterRotationSchedule" />

<portlet:resourceURL
	id="<%=OmsbMasterRotationScheduleWebPortletKeys.GET_DATA_BY_FACULTY_MVC_RESOURCE_COMMAND%>"
	var="getDataByFacultyForMasterRotationSchedule" />

<portlet:resourceURL
	id="<%=OmsbMasterRotationScheduleWebPortletKeys.SAVE_FACULTY_MASTER_ROTATION_SCHEDULE_MVC_RESOURCE_COMMAND%>"
	var="saveFacultyMasterRotationSchedule" />

<portlet:resourceURL
	id="<%=OmsbMasterRotationScheduleWebPortletKeys.GET_TRAINEE_MVC_RESOURCE_COMMAND%>"
	var="getTraineeDataURL" />
	
<portlet:resourceURL
	id="<%=OmsbMasterRotationScheduleWebPortletKeys.SAVE_TRAINEE_MASTER_ROTATION_SCHEDULE_MVC_RESOURCE_COMMAND%>"
	var="saveTraineeMasterRotationSchedule" />
	
<portlet:resourceURL
	id="<%=OmsbMasterRotationScheduleWebPortletKeys.SAVE_ROTATION_MASTER_ROTATION_SCHEDULE_MVC_RESOURCE_COMMAND%>"
	var="saveRotationMasterRotationSchedule" />
	
<portlet:resourceURL
	id="<%=OmsbMasterRotationScheduleWebPortletKeys.SAVE_TRAINEE_LEAVE_MVC_RESOURCE_COMMAND%>"
	var="saveTraineeLeave" />
	
<portlet:resourceURL
	id="<%=OmsbMasterRotationScheduleWebPortletKeys.DELETE_TRAINEE_LEAVE_MVC_RESOURCE_COMMAND%>"
	var="deleteTraineeLeave" />
	
<div class="loader-container d-none">
<div class="loaded"><img src="<%=themeDisplay.getPathThemeImages()%>/svg/loader.svg" alt="loader"></div>
</div>


<div id="wrapper">
	<div class="container-fuild">
		<div class="row">
			<div class="col-md-12">
				<div class="omsb-card">
					<div class="omsb-page-top-info mb-4">
						<div class="pagetitle">
							<liferay-ui:message key="master-rotation-by-trainee" />
						</div>
					</div>
					<aui:input label="program-master-id" id="programMasterId" name="programMasterId" type="hidden" value="${programMasterId}" class="form-control"  />
					<aui:input label="program-master-data" id="programMasterData" name="programMasterData" type="hidden" value="${programMasterDataId}" class="form-control"  />
					<aui:input label="progduration-tl-blocks-lt-id" id="progdurationTlBlocksLtId" name="progdurationTlBlocksLtId" type="hidden" value="${progdurationTlBlocksLtId}" class="form-control"  />
					<div class="master-rotation_tab">
						<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
							<li class="nav-item" role="presentation">
								<button class="nav-link d-none" id="pills-trainees-tab"
									data-toggle="pill" data-target="#pills-trainees" type="button"
									role="tab" aria-controls="pills-trainees" aria-selected="true" onClick="getTrainee()"/>
								<button class="nav-link active" type="button" data-id="pills-trainees-tab" onClick="showConfirmation(this);">
									<span></span> <liferay-ui:message key="by-trainee" />
								</button>
							</li>
							<li class="nav-item" role="presentation">
								<button class="nav-link d-none" id="pills-rotation-tab"
									data-toggle="pill" data-target="#pills-rotation" type="button"
									role="tab" aria-controls="pills-rotation" aria-selected="false" onClick="getRotation()"/>
								<button class="nav-link" type="button" data-id="pills-rotation-tab" onClick="showConfirmation(this);">
									<span></span> <liferay-ui:message key="by-rotation" />
								</button>
							</li>
							<li class="nav-item" role="presentation">
								<button class="nav-link d-none" id="pills-faculty-tab"
									data-toggle="pill" data-target="#pills-faculty" type="button"
									role="tab" aria-controls="pills-faculty" aria-selected="false"/>
								<button class="nav-link" type="button" data-id="pills-faculty-tab" onClick="showConfirmation(this);">
									<span></span> <liferay-ui:message key="by-faculty" />
								</button>
							</li>
							<li class="nav-item" role="presentation">
								<button class="nav-link d-none" id="pills-trainee-faculty-tab" data-toggle="pill"
										data-target="#pills-trainee-faculty" type="button" role="tab"
										aria-controls="pills-trainee-faculty" aria-selected="false" onClick="getTraineeRotation()">
								<button class="nav-link" type="button" data-id="pills-trainee-faculty-tab" onClick="showConfirmation(this);">
								<span></span> <liferay-ui:message key="by-trainee-faculty" /></button>
							</li>
						</ul>
						<div class="tab-content" id="pills-tabContent">
							<div class="tab-pane fade show active" id="pills-trainees"
								role="tabpanel" aria-labelledby="pills-trainees-tab">
								<div class="d-block text-right">
                                                <p class="text-right w-auto note-omsb-mr"><liferay-ui:message
										key="drag-the-selection-master-rotation-schedule" /></p>
                                                <div class="identified-area justify-content-end">
                                                    <div class="identified-list">
                                                        <img class="icon-identify" src="<%=themeDisplay.getPathThemeImages()%>/svg/elective-rotation.svg" alt="">
                                                       - <liferay-ui:message key="elective-rotation" />
                                                    </div>
                                                    <div class="identified-list">
                                                        <img class="icon-identify" src="<%=themeDisplay.getPathThemeImages()%>/svg/shared-rotation.svg" alt="">
                                                       - <liferay-ui:message key="shared-rotation" />
                                                    </div>
                                                </div>
                                            </div>
								<div class="row">
									<div class="col-lg-3">
										<div class="table-responsive">
											<table class="display omsb-tables table-bordered"
												id="rotation-by-trainee">
												<thead>
													<tr>
														<th><liferay-ui:message key="by-trainee" /></th>
													</tr>
												</thead>
												<tbody>
												</tbody>
											</table>
										</div>
									</div>
									<div class="col-lg-9">
										<div class="table-responsive">
											<table class="display omsb-tables table-bordered"
												id="rotation-by-trainee-to-rotation">
												<thead>
													<tr>
													</tr>
												</thead>
												<tbody>
												</tbody>
											</table>
										</div>
									</div>
								</div>
								<div class="bottom-backbtn-wrap mt-0 pt-3">
									<a href="javascript:void(0)"
										class="btn omsb-bc-red-button save-trainee-master-rotation-schedule"
										data-draft="0"> <liferay-ui:message key="submit" /></a> <a
										href="javascript:void(0)"
										class="btn omsb-bc-red-button save-trainee-master-rotation-schedule"
										data-draft="1"> <liferay-ui:message key="save-as-draft" /></a>
									<button class="btn omsb-btn btn-back" onclick="history.back()"><i class="fi fi-sr-arrow-left"></i><liferay-ui:message key="back" /></button>
								</div>
							</div>
							<div class="tab-pane fade" id="pills-rotation" role="tabpanel"
								aria-labelledby="pills-rotation-tab">
								<div class="d-block text-right">
                                                <p class="text-right w-auto note-omsb-mr"><liferay-ui:message
										key="drag-the-selection-master-rotation-schedule" /></p>
                                                <div class="identified-area justify-content-end">
                                                    <div class="identified-list">
                                                        <img class="icon-identify" src="<%=themeDisplay.getPathThemeImages()%>/svg/elective-rotation.svg" alt="">
                                                       - <liferay-ui:message key="elective-rotation" />
                                                    </div>
                                                    <div class="identified-list">
                                                        <img class="icon-identify" src="<%=themeDisplay.getPathThemeImages()%>/svg/shared-rotation.svg" alt="">
                                                       - <liferay-ui:message key="shared-rotation" />
                                                    </div>
                                                </div>
                                 </div>
								<div class="row">
									<div class="col-lg-3">
										<div class="table-responsive">
											<table class="display omsb-tables table-bordered"
												id="rotation-by-rotation">
												<thead>
													<tr>
														<th><liferay-ui:message key="by-rotation" /></th>
													</tr>
												</thead>
												<tbody>
												</tbody>
											</table>
										</div>
									</div>
									<div class="col-lg-9">
										<div class="table-responsive">
											<table class="display omsb-tables table-bordered"
												id="trainee-by-rotation">
												<thead>
													<tr>
													</tr>
												</thead>
												<tbody>
												</tbody>
											</table>
										</div>
									</div>
								</div>
								<div class="bottom-backbtn-wrap mt-0 pt-3">
									<a href="javascript:void(0)"
										class="btn omsb-bc-red-button save-rotation-master-rotation-schedule"
										data-draft="0"> <liferay-ui:message key="submit" /></a> <a
										href="javascript:void(0)"
										class="btn omsb-bc-red-button save-rotation-master-rotation-schedule"
										data-draft="1"> <liferay-ui:message key="save-as-draft" /></a>
									<button class="btn omsb-btn btn-back" onclick="history.back()"><i class="fi fi-sr-arrow-left"></i><liferay-ui:message key="back" /></button>

								</div>
							</div>
							<div class="tab-pane fade" id="pills-faculty" role="tabpanel"
								aria-labelledby="pills-faculty-tab">
								<p class="redtext text-right">
									<liferay-ui:message
										key="drag-the-selection-master-rotation-schedule" />
								</p>
								<div class="row">
									<div class="col-lg-3">
										<div class="table-responsive">
											<table class="display omsb-tables table-bordered"
												id="rotation-by-faculty-side">
												<thead>
													<tr>
														<th><liferay-ui:message key="by-faculty" /></th>
													</tr>
												</thead>
												<tbody>

												</tbody>
											</table>
										</div>
									</div>
									<div class="col-lg-9">
										<div class="table-responsive">
											<table class="display omsb-tables table-bordered"
												id="rotation-by-faculty-master">
												<thead>
													<tr>
														<th><liferay-ui:message key="rotation" /></th>
													</tr>
												</thead>
												<tbody>

												</tbody>
											</table>
										</div>
									</div>
								</div>
								<div class="bottom-backbtn-wrap mt-0 pt-3">
									<a href="javascript:void(0)"
										class="btn omsb-bc-red-button save-faculty-master-rotation-schedule"
										data-draft="0"> <liferay-ui:message key="submit" /></a> <a
										href="javascript:void(0)"
										class="btn omsb-bc-red-button save-faculty-master-rotation-schedule"
										data-draft="1"> <liferay-ui:message key="save-as-draft" /></a>
									<button class="btn omsb-btn btn-back" onclick="history.back()"><i class="fi fi-sr-arrow-left"></i><liferay-ui:message key="back" /></button>
								</div>
							</div>
							<div class="tab-pane fade" id="pills-trainee-faculty" role="tabpanel"
											aria-labelledby="pills-trainee-faculty-tab">
								<div class="d-block text-right">
                                                <p class="text-right w-auto note-omsb-mr"><liferay-ui:message
										key="drag-the-selection-master-rotation-schedule" /></p>
                                                <div class="identified-area justify-content-end">
                                                    <div class="identified-list">
                                                        <img class="icon-identify" src="<%=themeDisplay.getPathThemeImages()%>/svg/elective-rotation.svg" alt="">
                                                       - <liferay-ui:message key="elective-rotation" />
                                                    </div>
                                                    <div class="identified-list">
                                                        <img class="icon-identify" src="<%=themeDisplay.getPathThemeImages()%>/svg/shared-rotation.svg" alt="">
                                                       - <liferay-ui:message key="shared-rotation" />
                                                    </div>
                                                </div>
                                 </div>
								<div class="row">
									<div class="col-lg-3">
									<div class="accordion">
										   <div class="card" id="accordionExample">
										      <div class="card-header" id="headingOne">
										         <h2 class="mb-0">
										            <button class="btn btn-link btn-block text-left" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
										               <liferay-ui:message key="by-trainee" />
										               <span><img src="<%=themeDisplay.getPathThemeImages()%>/svg/select_arrow.svg" alt=""></span>
										            </button>
										         </h2>
										      </div>
										      <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
										         <div class="table-responsive">
										            <table class="display omsb-tables table-bordered"
										               id="rotation-by-trainee-faculty">
										               <tbody>
										               </tbody>
										            </table>
										         </div>
										      </div>
										   </div>
										   <div class="card" id="accordionExample2">
										      <div class="card-header" id="headingTwo">
										         <h2 class="mb-0">
										            <button class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
										               <liferay-ui:message key="by-faculty" />
										               <span><img src="<%=themeDisplay.getPathThemeImages()%>/svg/select_arrow.svg" alt=""></span>
										            </button>
										         </h2>
										      </div>
										      <div id="collapseTwo" class="collapse show" aria-labelledby="headingTwo" data-parent="#accordionExample2">
										         <div class="table-responsive">
										            <table class="display omsb-tables table-bordered"
										               id="rotation-by-faculty-trainee">
										               <tbody>
										               </tbody>
										            </table>
										         </div>
										      </div>
										   </div>
										</div>
									</div>
									<div class="col-lg-9">
										<div class="table-responsive">
											<table class="display omsb-tables table-bordered"
												id="rotation-by-trainee-to-rotation-faculty">
												<thead>
													<tr>
													</tr>
												</thead>
												<tbody>
												</tbody>
											</table>
										</div>
									</div>
								</div>
								<div class="bottom-backbtn-wrap mt-0 pt-3">
									<a href="javascript:void(0)"
										class="btn omsb-bc-red-button save-trainee-faculty-master-rotation-schedule"
										data-draft="0"> <liferay-ui:message key="submit" /></a> <a
										href="javascript:void(0)"
										class="btn omsb-bc-red-button save-trainee-faculty-master-rotation-schedule"
										data-draft="1"> <liferay-ui:message key="save-as-draft" /></a>
									<button class="btn omsb-btn btn-back" onclick="history.back()"><i class="fi fi-sr-arrow-left"></i>Back</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="/modal-popup-block-detail.jsp" />
<jsp:include page="/modal-popup-faculty.jsp" />
<jsp:include page="/modal-popup-alert.jsp" />
<jsp:include page="/modal-popup-confirm.jsp" />
<jsp:include page="/modal-popup-assignment-details.jsp" />
<jsp:include page="/modal-popup-particular-rotation-details.jsp" />
<jsp:include page="/all-modal-popup.jsp" />
<jsp:include page="/modal-popup-apply-leave.jsp" />
<jsp:include page="/modal-popup-trainee-leave-details.jsp" />
<jsp:include page="/modal-popup-trainee-leave-details-rotation.jsp" />


<button type="button" id="blockDetailListPopup"
	data-target="#blockdetail" data-toggle="modal" hidden="true" />

<script>
var tempArray = [];
var tempFacultyArray;
var facultyMasterRotationScheduleData = [];
var rotationMasterRotationScheduleData = [];
var traineeMasterRotationScheduleData = [];
var traineeTotalBlock;
var rotationtraineeBlock;
var removeBlockData = [];
var programMasterData;
var leaveMaterDataForRotation;
var leaveTypes;
var traineeElectiveRotationDTOs = [];
var isElectiveRotation = false;
var traineeSharedRotationDTOs = [];
var isTraineeSharedRotation = false;
var leaveDataId = "";
var saveleaveType = "";
var blocksMetadataDetailsRelsData = [];
var isChanged = false;
var issharedRotation = "false";
var trainingSiteByRotationsDTOsOuter = [];

/* trainee code start*/
$(document).ready(function(){
	addLoader();
	getTrainee();
});

$( window ).on( "load", function() {
    console.log( "window loaded" );
});

function formatDate(date) {
    var d = new Date(date),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();

    if (month.length < 2) 
        month = '0' + month;
    if (day.length < 2) 
        day = '0' + day;

    return [year, month, day].join('-');
}

function getTraineeRotation(){
	$(".pagetitle").empty();
	$(".pagetitle").html(`<liferay-ui:message key="master-rotation-by-trainee-faculty" />`);
	let programMasterId = $("#<portlet:namespace/>programMasterId").val();
    let progdurationTlBlocksLtId = $("#<portlet:namespace/>progdurationTlBlocksLtId").val();
	programMasterData = $("#<portlet:namespace/>programMasterData").val();
	let saveFacultyMasterRotationScheduleDTOs;
	 $.ajax({
	        url: "<%=getDataByFacultyForMasterRotationSchedule%>",
	        type: 'POST',
	        data: {
				<portlet:namespace/>progdurationTlBlocksLtId : progdurationTlBlocksLtId,
				<portlet:namespace/>programMasterId : programMasterId
	        },
	        success: function(data) {
	            let jsondata = JSON.parse(data);
				saveFacultyMasterRotationScheduleDTOs= jsondata.saveFacultyMasterRotationScheduleDTOs;
				getTraineeFacultyRotationDeatils(saveFacultyMasterRotationScheduleDTOs,programMasterId,progdurationTlBlocksLtId,programMasterData);
	        }
	});	
	
   
}
function getTraineeFacultyRotationDeatils(saveFacultyMasterRotationScheduleDTOs,programMasterId,progdurationTlBlocksLtId,programMasterData){
	 $.ajax({
	        url : '<%=getTraineeDataURL%>',
	        type : 'POST',
	        data : {
				<portlet:namespace/>programMasterId : programMasterId,
				<portlet:namespace/>progdurationTlBlocksLtId : progdurationTlBlocksLtId
	        },
	        success : function(data) {
	        	isChanged = false;
	        	traineeMasterRotationScheduleData = [];
	    		tempTraineeArray = [];  
	    		tempLeaveTraineeArray = [];
	            let jsondata = JSON.parse(data);
	            let siteByRotationsDTOs= jsondata.siteByRotationsDTOs;
	            let traineeDetailsWithBlocksDTOs= jsondata.traineeDetailsWithBlocksDTOs;
	            let blocksMetadataDetailsRels= jsondata.blocksMetadataDetailsRels;
	            let detailsRelByTraineeDTOs= jsondata.detailsRelByTraineeDTOs;
	            let leaveDetailsWithBlocksDTOs = jsondata.leaveDetailsWithBlocksDTOs;
	            let rotationTraineeBlockRelationDTOs = jsondata.rotationTraineeBlockRelationDTOs;
				traineeElectiveRotationDTOs = jsondata.traineeElectiveRotationDTOs;
	            leaveTypes = jsondata.leaveType;
	            traineeTotalBlock = blocksMetadataDetailsRels.length;
	            rotationtraineeBlock = rotationTraineeBlockRelationDTOs;
	            facultyMasterRotationScheduleData = saveFacultyMasterRotationScheduleDTOs;
	            let facultyData;
	            let s = 0;
	            let n = blocksMetadataDetailsRels.length;
	                $("#rotation-by-trainee-faculty tbody").empty();
	                for(let i=0; i<traineeDetailsWithBlocksDTOs.length; i++){
	                	let leaveBlockNo = "";
	                	if(traineeDetailsWithBlocksDTOs[i].leaveBlockNo){
	                		leaveBlockNo = traineeDetailsWithBlocksDTOs[i].leaveBlockNo;
	                	}
	                    $("#rotation-by-trainee-faculty tbody").append("<tr><td "+
	                    		" data-leave="+traineeDetailsWithBlocksDTOs[i].leaveBlocks+" class='trainee-details' data-value='"+traineeDetailsWithBlocksDTOs[i].traineeName+"' data-id='"+traineeDetailsWithBlocksDTOs[i].traineeId+"'>"+
	                    			"<div class='draggable-wrap'><img src='<%=themeDisplay.getPathThemeImages()%>/svg/drag-icon.svg' alt='drag'>"+
	                    				"<div draggable='true' ondragstart='traineedrag(event)' data-leave-block-id='"+ leaveBlockNo +"' "+
	                    					" data-allocatedBlocks='"+traineeDetailsWithBlocksDTOs[i].allocatedBlocks+"' data-id='"+traineeDetailsWithBlocksDTOs[i].traineeId+"' class='drag-rotation-item linktag'>"
	                            + traineeDetailsWithBlocksDTOs[i].traineeName +"<span> ("
	                                    +traineeDetailsWithBlocksDTOs[i].allocatedBlocks+")</span></div></div></td></tr>");
	                }
	                $('#rotation-by-faculty-trainee tbody').empty();
	            	$.ajax({
	            		url: "<%=getFacultyForMasterRotationSchedule%>",
	            		type: 'POST',
	            		data: {
	            			<portlet:namespace/>programMasterId : programMasterId
	            		},
	            		success: function(fdata)	{
	            			facultyData = fdata;
	            			if (facultyData.success) {
	            				var facultyList = "";
	            				$.each(facultyData.result, function(key, value) {
	            					facultyList += "<tr><td class='faculty-details' data-value='"+value+"' data-id='"+key+"'><div class='draggable-wrap'><img src='<%=themeDisplay.getPathThemeImages()%>/svg/drag-icon.svg' alt='drag'><div class='linktag' draggable='true' ondragstart='dragFaculty(event)' class='drag-rotation-item' data-id='"+key+"'>"+value+"</div></div></td></tr>";
	            				});
	            				$('#rotation-by-faculty-trainee tbody').append(facultyList);
	            			}
	            		}
	            	});
	    			
	                $("#rotation-by-trainee-to-rotation-faculty thead tr").empty();
	                $("#rotation-by-trainee-to-rotation-faculty thead tr").append("<th>Rotation</th>");
	                for(let i=0; i<blocksMetadataDetailsRels.length; i++){
	                	var startD = blocksMetadataDetailsRels[i].blockStartDate;
	                	var endD = blocksMetadataDetailsRels[i].blockEndDate;
	                	var newDate = new Date(startD);
	                	var newEndDate = new Date(endD);
	                	var getYear = newDate.toLocaleString("default", { year: "numeric" });
	                	var getMonth = newDate.toLocaleString("default", { month: "2-digit" });
	                	var getDay = newDate.toLocaleString("default", { day: "2-digit" });
	                	var getEndYear = newEndDate.toLocaleString("default", { year: "numeric" });
	                	var getEndMonth = newEndDate.toLocaleString("default", { month: "2-digit" });
	                	var getEndDay = newEndDate.toLocaleString("default", { day: "2-digit" });
	                	var blockStartDate = getDay + "-" + getMonth + "-" + getYear;
	                	var blockEndDate = getEndDay + "-" + getEndMonth + "-" + getEndYear;
	                    $("#rotation-by-trainee-to-rotation-faculty thead tr").append("<th id='traineeRotationMasterblock"+blocksMetadataDetailsRels[i].blocksMetadataDetailsRelId+"'>"+blocksMetadataDetailsRels[i].blockNo+"<br/> ("+blockStartDate+" to "+blockEndDate+")</th>");
	                    
	                }
	                $("#rotation-by-trainee-to-rotation-faculty tbody").empty();
	                var count = 1;
	                for(let i=0; i<siteByRotationsDTOs.length; i++){
	                    var row = $("<tr>");
	                    let rotationData = "<td><div class='title-header' id='traineeRotationMasterrotation"+siteByRotationsDTOs[i].progDurationRotationTsRelId+"'>"+siteByRotationsDTOs[i].progCodeRsnSiteCode+"";
	                    if(parseInt(siteByRotationsDTOs[i].noOfslots) !== 0){
							rotationData = rotationData + "<span> ("+siteByRotationsDTOs[i].noOfslots+")</span>";
						}
	                    if(siteByRotationsDTOs[i].sharedRotationType){
	                    	rotationData = rotationData +"<span class='omsb-complete-bg'>S</span>";
	    				}
						rotationData = rotationData + "</td></div>";
						row.append(rotationData)
						if(siteByRotationsDTOs[i].progCodeRsnSiteCode == "LEAVE"){
							for(let j=0; j<leaveDetailsWithBlocksDTOs.length; j++){
		                    	let traineeId = 0;
		                        let traineeNamedata = "";
		                        if(leaveDetailsWithBlocksDTOs[j].detailsWithBlocksDTOs.length !== 0){
		                        tempArray = [];
		                        traineeMasterRotationScheduleData.push({
		            				"blockId" : parseInt(blocksMetadataDetailsRels[j].blocksMetadataDetailsRelId),
		            				"rotationId" : parseInt(siteByRotationsDTOs[i].progDurationRotationTsRelId),
		            				"rotationMasterId" : parseInt(siteByRotationsDTOs[i].rotationId),
		            				"progCodeRsnSiteCode" : siteByRotationsDTOs[i].progCodeRsnSiteCode,
		            				"traineeDetails" : []
		            			})
		                        for(let k=0; k<leaveDetailsWithBlocksDTOs[j].detailsWithBlocksDTOs.length; k++){
		                        	
		                        	var foundObject = traineeMasterRotationScheduleData.find(obj => obj.blockId === parseInt(blocksMetadataDetailsRels[j].blocksMetadataDetailsRelId) && obj.rotationId === parseInt(siteByRotationsDTOs[i].progDurationRotationTsRelId));
		    						if (foundObject) {
		    							  foundObject.traineeDetails.push({traineeId:leaveDetailsWithBlocksDTOs[j].detailsWithBlocksDTOs[k].traineeId,traineeName:leaveDetailsWithBlocksDTOs[j].detailsWithBlocksDTOs[k].traineeName});
		    						}
		    						let traineeId = leaveDetailsWithBlocksDTOs[j].detailsWithBlocksDTOs[k].traineeId;
		    						let leaveMasterId = leaveDetailsWithBlocksDTOs[j].detailsWithBlocksDTOs[k].leaveMasterId;
		                            let traineeName = leaveDetailsWithBlocksDTOs[j].detailsWithBlocksDTOs[k].traineeName;
		                            let leaveTypeName = leaveDetailsWithBlocksDTOs[j].detailsWithBlocksDTOs[k].leaveTypeName;
		                            var newDate = new Date(leaveDetailsWithBlocksDTOs[j].detailsWithBlocksDTOs[k].fromDate);
		                        	var newEndDate = new Date(leaveDetailsWithBlocksDTOs[j].detailsWithBlocksDTOs[k].toDate);
		                        	var getYear = newDate.toLocaleString("default", { year: "numeric" });
		                        	var getMonth = newDate.toLocaleString("default", { month: "2-digit" });
		                        	var getDay = newDate.toLocaleString("default", { day: "2-digit" });
		                        	var getEndYear = newEndDate.toLocaleString("default", { year: "numeric" });
		                        	var getEndMonth = newEndDate.toLocaleString("default", { month: "2-digit" });
		                        	var getEndDay = newEndDate.toLocaleString("default", { day: "2-digit" });
		                        	var leaveStartDate = getDay + "-" + getMonth + "-" + getYear;
		                        	var leaveEndDate = getEndDay + "-" + getEndMonth + "-" + getEndYear;
		                            let obj = { traineeId,traineeName,leaveTypeName,leaveStartDate,leaveEndDate,leaveMasterId}
		                            tempArray.push(obj);
		                            traineeId = leaveDetailsWithBlocksDTOs[j].detailsWithBlocksDTOs[k].traineeId;
		                            traineeNamedata = leaveDetailsWithBlocksDTOs[j].detailsWithBlocksDTOs[k].traineeName; 
		                        }
		                         if (tempArray.length > 1) {
		                             let length = tempArray.length - 1;
		                                row.append("<td data-noofslots='"+siteByRotationsDTOs[i].noOfslots+"' data-startdate='"+new Date(blocksMetadataDetailsRels[j].blockStartDate)+"' data-enddate='"+new Date(blocksMetadataDetailsRels[j].blockEndDate)+"' data-leave='leave' data-rotationmaster='"+siteByRotationsDTOs[i].rotationId+"' data-progcodersnsitecode='"
		                                		+siteByRotationsDTOs[i].progCodeRsnSiteCode+"' data-rotation='"
		                                		+siteByRotationsDTOs[i].progDurationRotationTsRelId+"' data-block='"
		                                		+blocksMetadataDetailsRels[j].blocksMetadataDetailsRelId+"' id='trainee_faculty_row_"
		                                		+count+"' ondrop='traineefacultydrop(event)' ondragover='allowDrop(event)'><span data-value='"
		                                		+JSON.stringify(tempArray)+"' class='omsb-complete-bg omsb-complete-bg-flex'>"+
		                                        traineeNamedata+"</span> <span onclick='traineeLeaveList("+JSON.stringify(tempArray)+", \"popup\", trainee_faculty_row_"
		                                        		+count+")' class='omsb-complete-bg linktag'>+"+length+"</span></td>");
		                                
		                            } else {
		                            	let data = tempArray[0];
		                                row.append("<td data-noofslots='"+siteByRotationsDTOs[i].noOfslots+"' data-startdate='"+new Date(blocksMetadataDetailsRels[j].blockStartDate)+"' data-enddate='"+new Date(blocksMetadataDetailsRels[j].blockEndDate)+"' data-leave='leave' data-rotationmaster='"+siteByRotationsDTOs[i].rotationId+"' data-progcodersnsitecode='"
		                                		+siteByRotationsDTOs[i].progCodeRsnSiteCode+"' data-rotation='"+siteByRotationsDTOs[i].progDurationRotationTsRelId+"' data-block='"
		                                		+blocksMetadataDetailsRels[j].blocksMetadataDetailsRelId+"' id='trainee_faculty_row_"
		                                		+count+"' ondrop='traineefacultydrop(event)' ondragover='allowDrop(event)'><span data-value='"
		                                		+JSON.stringify(tempArray)+"' onclick='traineeLeaveList("+JSON.stringify(tempArray)+", \"popup\", trainee_faculty_row_"
	                                    		+count+")' class='omsb-complete-bg omsb-complete-bg-flex linktag'>"
		                                		+traineeNamedata+"</span></td>");
		                            }
		                        
		                        }else{
		                            row.append("<td data-noofslots='"+siteByRotationsDTOs[i].noOfslots+"' data-startdate='"+new Date(blocksMetadataDetailsRels[j].blockStartDate)+"' data-enddate='"+new Date(blocksMetadataDetailsRels[j].blockEndDate)+"' data-leave='leave' data-rotationmaster='"+siteByRotationsDTOs[i].rotationId+"' data-progcodersnsitecode='"
		                            		+siteByRotationsDTOs[i].progCodeRsnSiteCode+"' data-rotation='"+siteByRotationsDTOs[i].progDurationRotationTsRelId+"' data-block='"
		                            		+blocksMetadataDetailsRels[j].blocksMetadataDetailsRelId+"' id='trainee_faculty_row_"+count+"' ondrop='traineefacultydrop(event)' ondragover='allowDrop(event)'>"+traineeNamedata+"</td>");

		                        }
		                        count++;
		                    }
						}else{
							let facultyRotation = saveFacultyMasterRotationScheduleDTOs.slice(s, n);
							let traineeRotation = detailsRelByTraineeDTOs.slice(s, n);
		                    for(let j=0; j<traineeRotation.length; j++){
		                    	let traineeId = 0;
		                    	let facultyId = 0;
		                        let traineeNamedata = "";
		                        let facultyNamedata = "";
		                        if(traineeRotation[j].traineeDetailsWithBlocksDTO || facultyRotation[j].facultyDetails.length !== 0){
		                        tempArray = [];
		                        let facultyArray = [];
		                        traineeMasterRotationScheduleData.push({
		            				"blockId" : parseInt(blocksMetadataDetailsRels[j].blocksMetadataDetailsRelId),
		            				"rotationId" : parseInt(siteByRotationsDTOs[i].progDurationRotationTsRelId),
		            				"rotationMasterId" : parseInt(siteByRotationsDTOs[i].rotationId),
		            				"progCodeRsnSiteCode" : siteByRotationsDTOs[i].progCodeRsnSiteCode,
		            				"traineeDetails" : []
		            			})
		            			if(traineeRotation[j].traineeDetailsWithBlocksDTO){
		            				 for(let k=0; k<traineeRotation[j].traineeDetailsWithBlocksDTO.length; k++){
		 	                        	
		 	                        	var foundObject = traineeMasterRotationScheduleData.find(obj => obj.blockId === parseInt(blocksMetadataDetailsRels[j].blocksMetadataDetailsRelId) && obj.rotationId === parseInt(siteByRotationsDTOs[i].progDurationRotationTsRelId));
		 	    						if (foundObject) {
		 	    							  foundObject.traineeDetails.push({traineeId:traineeRotation[j].traineeDetailsWithBlocksDTO[k].traineeId,traineeName:traineeRotation[j].traineeDetailsWithBlocksDTO[k].traineeName});
		 	    						}
		 	                            let traineeName = traineeRotation[j].traineeDetailsWithBlocksDTO[k].traineeName;
		 	                            traineeId = traineeRotation[j].traineeDetailsWithBlocksDTO[k].traineeId;
		 	                            traineeNamedata = traineeRotation[j].traineeDetailsWithBlocksDTO[k].traineeName; 
		 	                            let obj = { traineeName,traineeId}
		 	                           tempArray.push(obj);
		 	                        }
		            			}
		                       	if(facultyRotation[j].facultyDetails){
		                    	   for(let p=0; p<facultyRotation[j].facultyDetails.length; p++) {
			                            let facultyName = facultyRotation[j].facultyDetails[p].facultyName;
			                            facultyId = facultyRotation[j].facultyDetails[p].facultyId;
			                            facultyNamedata = facultyRotation[j].facultyDetails[p].facultyName;
			                            let obj = { facultyName,facultyId}
			                            facultyArray.push(obj);
			                    	}
		                       	}
		                    	let rowData = "<td data-noofslots='"+siteByRotationsDTOs[i].noOfslots+"' data-startdate='"+new Date(blocksMetadataDetailsRels[j].blockStartDate)+"' data-enddate='"+new Date(blocksMetadataDetailsRels[j].blockEndDate)+"' data-leave='data' data-rotationmaster='"+siteByRotationsDTOs[i].rotationId+"' data-progcodersnsitecode='"+siteByRotationsDTOs[i].progCodeRsnSiteCode+"' data-rotation='"+siteByRotationsDTOs[i].progDurationRotationTsRelId+"' data-block='"+blocksMetadataDetailsRels[j].blocksMetadataDetailsRelId+"' id='trainee_faculty_row_"+count+"' ondrop='traineefacultydrop(event)' ondragover='allowDrop(event)'>";
		                         if (tempArray.length > 1) {
		                             let length = tempArray.length - 1;
		                             rowData = rowData +"<span data-value='"+JSON.stringify(tempArray)+"' data-faculty='"+JSON.stringify(facultyArray)+"' class='omsb-complete-bg omsb-complete-bg-flex'>"+
		                                        traineeNamedata+"</span> <span onclick='traineeList("+JSON.stringify(tempArray)+", \"popup\", trainee_faculty_row_"+count+",\"traineeFaculty\")' class='omsb-complete-bg linktag'>+"+length+"</span>";
		                                
		                        } else if(tempArray.length === 1) {
		                           	 rowData = rowData +"<span data-value='"+JSON.stringify(tempArray)+"' data-faculty='"+JSON.stringify(facultyArray)+"' class='omsb-complete-bg omsb-complete-bg-flex'>"
		                                		+traineeNamedata+"<a href='javascript:void(0)' onclick='traineeremoveItem(\"singleItem\",\"traineeFaculty\", trainee_faculty_row_"+count+","+traineeId+")' ><img src='<%=themeDisplay.getPathThemeImages()%>/svg/table_reject.svg' alt=''></a></span>";
		                        }
		                        if (facultyArray.length > 1) {
		                             let length = facultyArray.length - 1;
		                             rowData = rowData +"<span data-value='"+JSON.stringify(tempArray)+"' data-faculty='"+JSON.stringify(facultyArray)+"' class='omsb-initiated-bg omsb-complete-bg-flex'>"+
		                             facultyNamedata+"</span> <span onclick='facultyList("+JSON.stringify(facultyArray)+", \"popup\", trainee_faculty_row_"+count+",\"traineeFaculty\")' class='omsb-initiated-bg linktag'>+"+length+"</span>";
		                                
		                        } else if(facultyArray.length === 1) {
		                           	 rowData = rowData +"<span data-value='"+JSON.stringify(tempArray)+"' data-faculty='"+JSON.stringify(facultyArray)+"' class='omsb-initiated-bg omsb-complete-bg-flex'>"
		                                		+facultyNamedata+"<a href='javascript:void(0)' onclick='removeFacultyItem(\"singleItem\",\"traineeFaculty\", trainee_faculty_row_"+count+","+facultyId+")' ><img src='<%=themeDisplay.getPathThemeImages()%>/svg/table_reject.svg' alt=''></a></span>";
		                        }
		                         rowData = rowData + "</td>";
		                         row.append(rowData);
		                        }else{
		                            row.append("<td data-noofslots='"+siteByRotationsDTOs[i].noOfslots+"' data-startdate='"+new Date(blocksMetadataDetailsRels[j].blockStartDate)+"' data-enddate='"+new Date(blocksMetadataDetailsRels[j].blockEndDate)+"' data-leave='data' data-rotationmaster='"+siteByRotationsDTOs[i].rotationId+"' data-progcodersnsitecode='"+siteByRotationsDTOs[i].progCodeRsnSiteCode+"' data-rotation='"+siteByRotationsDTOs[i].progDurationRotationTsRelId+"' data-block='"+blocksMetadataDetailsRels[j].blocksMetadataDetailsRelId+"' id='trainee_faculty_row_"+count+"' ondrop='traineefacultydrop(event)' ondragover='allowDrop(event)'>"+traineeNamedata+"</td>");
		                        }
		                        count++;
		                    }
		                    s = n;
		                    n = s + blocksMetadataDetailsRels.length;
						}
	                    $("#rotation-by-trainee-to-rotation-faculty tbody").append(row);
	                }
	                removeLoader();
	        }
		});
}

function traineefacultydrop(ev){
	isChanged = true;
    var drageeventData = ev.dataTransfer.getData("drageeventData");
	if(drageeventData.toUpperCase() === "traineedrag".toUpperCase()){
		traineedrop(ev,"traineeFaculty");
	}else{
		dropFacultyWithTrainee(ev, true);
	}
}

function dropFacultyWithTrainee(ev, isCreate) {
	isChanged = true;
	ev.preventDefault();
	let dataId;
	let data;
	let blockId;
	let rotationId;
	let id;
	let facultyavailableonblock = false;
    if(ev.currentTarget.dataset.leave.toUpperCase() === "leave".toUpperCase()){
		$(".popup-alert-title").empty();
	    $(".popup-alert-title").html(`<liferay-ui:message key="leave-alert" />`);
	    $(".popup-alert-message").empty();
	    $(".popup-alert-message").html(`<liferay-ui:message key="faculty-not-allow" />`);
	    $(".popup-alert-button").empty();
	    $(".popup-alert-button").html(`<liferay-ui:message key="back" />`);
	    $("#alertPopup").modal("show");
	}else{
		if(isCreate) {
			dataId = parseInt(ev.dataTransfer.getData("facultyId"));
			data = ev.dataTransfer.getData("facultyName");
			blockId = parseInt(ev.currentTarget.dataset.block);
			rotationId = parseInt(ev.currentTarget.dataset.rotation);
			if (ev.target.id) {
				id = ev.target.id;
			} else {
				id = ev.target.parentElement.id;
			}
			if(isFacultyAvailableOnSameBlock(parseInt(ev.currentTarget.dataset.block), parseInt(ev.currentTarget.dataset.rotation), parseInt(dataId))){
				facultyavailableonblock = true;
			}
		} else {
			dataId = parseInt(ev.detail.dataTransfer.facultyId);
			data = ev.detail.dataTransfer.facultyName;
			blockId = parseInt(ev.detail.currentTarget.dataset.block);
			rotationId = parseInt(ev.detail.currentTarget.dataset.rotation);
			id = ev.detail.target.id;
		}
		if(facultyavailableonblock){
			$(".popup-alert-title").empty();
	        $(".popup-alert-title").html(`<liferay-ui:message key="block-alert" />`);
	        $(".popup-alert-message").empty();
	        $(".popup-alert-message").html(`<liferay-ui:message key="faculty-exists-in-same-block" />`);
	        $(".popup-alert-button").empty();
	        $(".popup-alert-button").html(`<liferay-ui:message key="back" />`);
	        $("#alertPopup").modal("show");
		}else{
			if(!isRecordPresentForFaculty(blockId, rotationId, dataId)) {
				let traineeList;
				let facultyList;
				elementID = document.getElementById(id);
				if (elementID.childNodes.length > 0) {
					traineeList = JSON.parse(elementID.childNodes[0].getAttribute("data-value"));
					facultyList = JSON.parse(elementID.childNodes[0].getAttribute("data-faculty"));
				} else {
					traineeList = [];
					facultyList = [];
				}
				var foundObject = facultyMasterRotationScheduleData.find(obj => obj.blockId === blockId && obj.rotationId === rotationId);
				if (foundObject) {
					  foundObject.facultyDetails.push({facultyId: dataId, facultyName: data});
				}
				facultyList = [...facultyList, { facultyName: data, facultyId: dataId}];
				traineeFacultycellItem(id,traineeList, facultyList);
			} else {
				$(".popup-alert-title").empty();
				$(".popup-alert-title").html(`<liferay-ui:message key="faculty-alert" />`);
				$(".popup-alert-message").empty();
				$(".popup-alert-message").html(data +` <liferay-ui:message key="faculty-already-assigned" />`);
				$(".popup-alert-button").empty();
				$(".popup-alert-button").html(`<liferay-ui:message key="back" />`);
				$("#alertPopup").modal("show");
			}
		}
	}
}

function traineeFacultycellItem(id, traineeList,facultyList) {
	elementID = document.getElementById(id);
	elementID.innerHTML = "";
	let traineefacultydata = "";
	if (traineeList.length) {
		if (traineeList.length > 1) {
			traineefacultydata = traineefacultydata + `<span  data-value='\${JSON.stringify(traineeList)}' data-faculty='\${JSON.stringify(facultyList)}'  class="omsb-complete-bg omsb-complete-bg-flex" data-id="\${traineeList[traineeList.length-1].traineeId}">\${traineeList[traineeList.length-1].traineeName}</span>
																<span onclick='traineeList(\${JSON.stringify(traineeList)}, "popup", \${id},\"traineeFaculty\")'   class="omsb-complete-bg linktag">+\${traineeList.length - 1}</span>`;
		} else if(traineeList.length === 1) {
			traineefacultydata = traineefacultydata + `<span  data-value='\${JSON.stringify(traineeList)}' data-faculty='\${JSON.stringify(facultyList)}'  class="omsb-complete-bg omsb-complete-bg-flex" data-id="\${traineeList[traineeList.length-1].traineeId}">\${traineeList[traineeList.length-1].traineeName} <a href="javascript:void(0)" onclick='traineeremoveItem("singleItem","traineeFaculty", \${id}, \${traineeList[traineeList.length-1].traineeId})' ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/table_reject.svg" alt=""></a></span>`;
		}
	}
	
	if (facultyList.length) {
		if (facultyList.length > 1) {
			traineefacultydata = traineefacultydata + `<span  data-value='\${JSON.stringify(traineeList)}' data-faculty='\${JSON.stringify(facultyList)}'  class="omsb-initiated-bg omsb-complete-bg-flex" data-id="\${facultyList[facultyList.length-1].facultyId}">\${facultyList[facultyList.length-1].facultyName}</span>
																<span onclick='facultyList(\${JSON.stringify(facultyList)}, "popup", \${id},\"traineeFaculty\")'   class="omsb-initiated-bg linktag">+\${facultyList.length - 1}</span>`;
		} else if(facultyList.length === 1) {
			traineefacultydata = traineefacultydata + `<span  data-value='\${JSON.stringify(traineeList)}' data-faculty='\${JSON.stringify(facultyList)}'  class="omsb-initiated-bg omsb-complete-bg-flex" data-id="\${facultyList[facultyList.length-1].facultyId}">\${facultyList[facultyList.length-1].facultyName} <a href="javascript:void(0)" onclick='removeFacultyItem("singleItem","traineeFaculty", \${id}, \${facultyList[facultyList.length-1].facultyId})' ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/table_reject.svg" alt=""></a></span>`;
		}
	}
	elementID.innerHTML = traineefacultydata;

}

function getTrainee(){
	$(".pagetitle").empty();
	$(".pagetitle").html(`<liferay-ui:message key="master-rotation-by-trainee" />`);
	let programMasterId = $("#<portlet:namespace/>programMasterId").val();
    let progdurationTlBlocksLtId = $("#<portlet:namespace/>progdurationTlBlocksLtId").val();
	programMasterData = $("#<portlet:namespace/>programMasterData").val();
    $.ajax({
        url : '<%=getTraineeDataURL%>',
        type : 'POST',
        data : {
			<portlet:namespace/>programMasterId : programMasterId,
			<portlet:namespace/>progdurationTlBlocksLtId : progdurationTlBlocksLtId
        },
        success : function(data) {
        		trainingSiteByRotationsDTOsOuter = [];
        		isChanged = false;
        		traineeMasterRotationScheduleData = [];
        		tempTraineeArray = [];  
        		tempLeaveTraineeArray = [];
                let jsondata = JSON.parse(data);
                let siteByRotationsDTOs= jsondata.siteByRotationsDTOs;
                let traineeDetailsWithBlocksDTOs= jsondata.traineeDetailsWithBlocksDTOs;
                let blocksMetadataDetailsRels= jsondata.blocksMetadataDetailsRels;
                let detailsRelByTraineeDTOs= jsondata.detailsRelByTraineeDTOs;
                let leaveDetailsWithBlocksDTOs = jsondata.leaveDetailsWithBlocksDTOs;
                let rotationTraineeBlockRelationDTOs = jsondata.rotationTraineeBlockRelationDTOs;
				traineeElectiveRotationDTOs = jsondata.traineeElectiveRotationDTOs;
				trainingSiteByRotationsDTOsOuter = siteByRotationsDTOs;
                leaveTypes = jsondata.leaveType;
                traineeTotalBlock = blocksMetadataDetailsRels.length;
                rotationtraineeBlock = rotationTraineeBlockRelationDTOs;
                let s = 0;
                let n = blocksMetadataDetailsRels.length;
                $("#rotation-by-trainee tbody").empty();
                for(let i=0; i<traineeDetailsWithBlocksDTOs.length; i++){
                	let leaveBlockNo = "";
                	if(traineeDetailsWithBlocksDTOs[i].leaveBlockNo){
                		leaveBlockNo = traineeDetailsWithBlocksDTOs[i].leaveBlockNo;
                	}
                    $("#rotation-by-trainee tbody").append("<tr><td "+
                    		" data-leave="+traineeDetailsWithBlocksDTOs[i].leaveBlocks+" class='trainee-details' data-value='"+traineeDetailsWithBlocksDTOs[i].traineeName+"' data-id='"+traineeDetailsWithBlocksDTOs[i].traineeId+"'>"+
                    			"<div class='draggable-wrap'><img src='<%=themeDisplay.getPathThemeImages()%>/svg/drag-icon.svg' alt='drag'>"+
                    				"<div draggable='true' ondragstart='traineedrag(event)' data-leave-block-id='"+ leaveBlockNo +"' "+
                    					" data-allocatedBlocks='"+traineeDetailsWithBlocksDTOs[i].allocatedBlocks+"' data-id='"+traineeDetailsWithBlocksDTOs[i].traineeId+"' class='drag-rotation-item linktag'>"
                            + traineeDetailsWithBlocksDTOs[i].traineeName +"<span> ("
                                    +traineeDetailsWithBlocksDTOs[i].allocatedBlocks+")</span></div></div></td></tr>");
                }
                $("#rotation-by-trainee-to-rotation thead tr").empty();
                $("#rotation-by-trainee-to-rotation thead tr").append("<th>Rotation</th>");
                for(let i=0; i<blocksMetadataDetailsRels.length; i++){
                	var startD = blocksMetadataDetailsRels[i].blockStartDate;
                	var endD = blocksMetadataDetailsRels[i].blockEndDate;
                	var newDate = new Date(startD);
                	var newEndDate = new Date(endD);
                	var getYear = newDate.toLocaleString("default", { year: "numeric" });
                	var getMonth = newDate.toLocaleString("default", { month: "2-digit" });
                	var getDay = newDate.toLocaleString("default", { day: "2-digit" });
                	var getEndYear = newEndDate.toLocaleString("default", { year: "numeric" });
                	var getEndMonth = newEndDate.toLocaleString("default", { month: "2-digit" });
                	var getEndDay = newEndDate.toLocaleString("default", { day: "2-digit" });
                	var blockStartDate = getDay + "-" + getMonth + "-" + getYear;
                	var blockEndDate = getEndDay + "-" + getEndMonth + "-" + getEndYear;
                    $("#rotation-by-trainee-to-rotation thead tr").append("<th id='traineeRotationMasterblock"+blocksMetadataDetailsRels[i].blocksMetadataDetailsRelId+"'>"+blocksMetadataDetailsRels[i].blockNo+"<br/> ("+blockStartDate+" to "+blockEndDate+")</th>");
                    
                }
                $("#rotation-by-trainee-to-rotation tbody").empty();
                var count = 1;
                for(let i=0; i<siteByRotationsDTOs.length; i++){
                    var row = $("<tr>");
                    let rotationData = "<td><div class='title-header' id='traineeRotationMasterrotation"+siteByRotationsDTOs[i].progDurationRotationTsRelId+"'>"+siteByRotationsDTOs[i].progCodeRsnSiteCode+"";
                    if(parseInt(siteByRotationsDTOs[i].noOfslots) !== 0){
						rotationData = rotationData + "<span> ("+siteByRotationsDTOs[i].noOfslots+")</span>";
					}
                    if(siteByRotationsDTOs[i].sharedRotationType){
                    	rotationData = rotationData +"<span class='omsb-complete-bg'>S</span>";
    				}
					rotationData = rotationData + "</td></div>";
					row.append(rotationData)
					if(siteByRotationsDTOs[i].progCodeRsnSiteCode == "LEAVE"){
						for(let j=0; j<leaveDetailsWithBlocksDTOs.length; j++){
	                    	let traineeId = 0;
	                        let traineeNamedata = "";
	                        if(leaveDetailsWithBlocksDTOs[j].detailsWithBlocksDTOs.length !== 0){
	                        tempArray = [];
	                        traineeMasterRotationScheduleData.push({
	            				"blockId" : parseInt(blocksMetadataDetailsRels[j].blocksMetadataDetailsRelId),
	            				"rotationId" : parseInt(siteByRotationsDTOs[i].progDurationRotationTsRelId),
	            				"rotationMasterId" : parseInt(siteByRotationsDTOs[i].rotationId),
	            				"progCodeRsnSiteCode" : siteByRotationsDTOs[i].progCodeRsnSiteCode,
	            				"traineeDetails" : []
	            			})
	                        for(let k=0; k<leaveDetailsWithBlocksDTOs[j].detailsWithBlocksDTOs.length; k++){
	                        	
	                        	var foundObject = traineeMasterRotationScheduleData.find(obj => obj.blockId === parseInt(blocksMetadataDetailsRels[j].blocksMetadataDetailsRelId) && obj.rotationId === parseInt(siteByRotationsDTOs[i].progDurationRotationTsRelId));
	    						if (foundObject) {
	    							  foundObject.traineeDetails.push({traineeId:leaveDetailsWithBlocksDTOs[j].detailsWithBlocksDTOs[k].traineeId,traineeName:leaveDetailsWithBlocksDTOs[j].detailsWithBlocksDTOs[k].traineeName});
	    						}
	    						let traineeId = leaveDetailsWithBlocksDTOs[j].detailsWithBlocksDTOs[k].traineeId;
	    						let leaveMasterId = leaveDetailsWithBlocksDTOs[j].detailsWithBlocksDTOs[k].leaveMasterId;
	                            let traineeName = leaveDetailsWithBlocksDTOs[j].detailsWithBlocksDTOs[k].traineeName;
	                            let leaveTypeName = leaveDetailsWithBlocksDTOs[j].detailsWithBlocksDTOs[k].leaveTypeName;
	                            var newDate = new Date(leaveDetailsWithBlocksDTOs[j].detailsWithBlocksDTOs[k].fromDate);
	                        	var newEndDate = new Date(leaveDetailsWithBlocksDTOs[j].detailsWithBlocksDTOs[k].toDate);
	                        	var getYear = newDate.toLocaleString("default", { year: "numeric" });
	                        	var getMonth = newDate.toLocaleString("default", { month: "2-digit" });
	                        	var getDay = newDate.toLocaleString("default", { day: "2-digit" });
	                        	var getEndYear = newEndDate.toLocaleString("default", { year: "numeric" });
	                        	var getEndMonth = newEndDate.toLocaleString("default", { month: "2-digit" });
	                        	var getEndDay = newEndDate.toLocaleString("default", { day: "2-digit" });
	                        	var leaveStartDate = getDay + "-" + getMonth + "-" + getYear;
	                        	var leaveEndDate = getEndDay + "-" + getEndMonth + "-" + getEndYear;
	                            let obj = { traineeId,traineeName,leaveTypeName,leaveStartDate,leaveEndDate,leaveMasterId}
	                            tempArray.push(obj);
	                            traineeId = leaveDetailsWithBlocksDTOs[j].detailsWithBlocksDTOs[k].traineeId;
	                            traineeNamedata = leaveDetailsWithBlocksDTOs[j].detailsWithBlocksDTOs[k].traineeName; 
	                        }
	                         if (tempArray.length > 1) {
	                             let length = tempArray.length - 1;
	                                row.append("<td data-noofslots='"+siteByRotationsDTOs[i].noOfslots+"' data-startdate='"+new Date(blocksMetadataDetailsRels[j].blockStartDate)+"' data-enddate='"+new Date(blocksMetadataDetailsRels[j].blockEndDate)+"' data-leave='leave' data-rotationmaster='"+siteByRotationsDTOs[i].rotationId+"' data-progcodersnsitecode='"
	                                		+siteByRotationsDTOs[i].progCodeRsnSiteCode+"' data-rotation='"
	                                		+siteByRotationsDTOs[i].progDurationRotationTsRelId+"' data-block='"
	                                		+blocksMetadataDetailsRels[j].blocksMetadataDetailsRelId+"' id='trainee_row_"
	                                		+count+"' ondrop='traineedrop(event,\"trainee\")' ondragover='allowDrop(event)'><span data-value='"
	                                		+JSON.stringify(tempArray)+"' class='omsb-complete-bg omsb-complete-bg-flex'>"+
	                                        traineeNamedata+"</span> <span onclick='traineeLeaveList("+JSON.stringify(tempArray)+", \"popup\", trainee_row_"
	                                        		+count+")' class='omsb-complete-bg linktag'>+"+length+"</span></td>");
	                                
	                            } else {
	                            	let data = tempArray[0];
	                                row.append("<td data-noofslots='"+siteByRotationsDTOs[i].noOfslots+"' data-startdate='"+new Date(blocksMetadataDetailsRels[j].blockStartDate)+"' data-enddate='"+new Date(blocksMetadataDetailsRels[j].blockEndDate)+"' data-leave='leave' data-rotationmaster='"+siteByRotationsDTOs[i].rotationId+"' data-progcodersnsitecode='"
	                                		+siteByRotationsDTOs[i].progCodeRsnSiteCode+"' data-rotation='"+siteByRotationsDTOs[i].progDurationRotationTsRelId+"' data-block='"
	                                		+blocksMetadataDetailsRels[j].blocksMetadataDetailsRelId+"' id='trainee_row_"
	                                		+count+"' ondrop='traineedrop(event,\"trainee\")' ondragover='allowDrop(event)'><span data-value='"
	                                		+JSON.stringify(tempArray)+"' onclick='traineeLeaveList("+JSON.stringify(tempArray)+", \"popup\", trainee_row_"
                                    		+count+")' class='omsb-complete-bg omsb-complete-bg-flex linktag'>"
	                                		+traineeNamedata+"</span></td>");
	                            }
	                        
	                        }else{
	                            row.append("<td data-noofslots='"+siteByRotationsDTOs[i].noOfslots+"' data-startdate='"+new Date(blocksMetadataDetailsRels[j].blockStartDate)+"' data-enddate='"+new Date(blocksMetadataDetailsRels[j].blockEndDate)+"' data-leave='leave' data-rotationmaster='"+siteByRotationsDTOs[i].rotationId+"' data-progcodersnsitecode='"
	                            		+siteByRotationsDTOs[i].progCodeRsnSiteCode+"' data-rotation='"+siteByRotationsDTOs[i].progDurationRotationTsRelId+"' data-block='"
	                            		+blocksMetadataDetailsRels[j].blocksMetadataDetailsRelId+"' id='trainee_row_"+count+"' ondrop='traineedrop(event,\"trainee\")' ondragover='allowDrop(event)'>"+traineeNamedata+"</td>");

	                        }
	                        count++;
	                    }
					}else{
						let traineeRotation = detailsRelByTraineeDTOs.slice(s, n);
	                    for(let j=0; j<traineeRotation.length; j++){
	                    	let traineeId = 0;
	                        let traineeNamedata = "";
	                        if(traineeRotation[j].traineeDetailsWithBlocksDTO){
	                        tempArray = [];
	                        traineeMasterRotationScheduleData.push({
	            				"blockId" : parseInt(blocksMetadataDetailsRels[j].blocksMetadataDetailsRelId),
	            				"rotationId" : parseInt(siteByRotationsDTOs[i].progDurationRotationTsRelId),
	            				"rotationMasterId" : parseInt(siteByRotationsDTOs[i].rotationId),
	            				"progCodeRsnSiteCode" : siteByRotationsDTOs[i].progCodeRsnSiteCode,
	            				"traineeDetails" : []
	            			})
	                        for(let k=0; k<traineeRotation[j].traineeDetailsWithBlocksDTO.length; k++){
	                        	
	                        	var foundObject = traineeMasterRotationScheduleData.find(obj => obj.blockId === parseInt(blocksMetadataDetailsRels[j].blocksMetadataDetailsRelId) && obj.rotationId === parseInt(siteByRotationsDTOs[i].progDurationRotationTsRelId));
	    						if (foundObject) {
	    							  foundObject.traineeDetails.push({traineeId:traineeRotation[j].traineeDetailsWithBlocksDTO[k].traineeId,traineeName:traineeRotation[j].traineeDetailsWithBlocksDTO[k].traineeName});
	    						}
	                            let traineeName = traineeRotation[j].traineeDetailsWithBlocksDTO[k].traineeName;
	                            traineeId = traineeRotation[j].traineeDetailsWithBlocksDTO[k].traineeId;
	                            let obj = { traineeName,traineeId }
	                            tempArray.push(obj);
	                            traineeNamedata = traineeRotation[j].traineeDetailsWithBlocksDTO[k].traineeName; 
	                        }
	                         if (tempArray.length > 1) {
	                             let length = tempArray.length - 1;
	                                row.append("<td data-noofslots='"+siteByRotationsDTOs[i].noOfslots+"' data-startdate='"+new Date(blocksMetadataDetailsRels[j].blockStartDate)+"' data-enddate='"+new Date(blocksMetadataDetailsRels[j].blockEndDate)+"' data-leave='data' data-rotationmaster='"+siteByRotationsDTOs[i].rotationId+"' data-progcodersnsitecode='"+siteByRotationsDTOs[i].progCodeRsnSiteCode+"' data-rotation='"+siteByRotationsDTOs[i].progDurationRotationTsRelId+"' data-block='"+blocksMetadataDetailsRels[j].blocksMetadataDetailsRelId+"' id='trainee_row_"+count+"' ondrop='traineedrop(event,\"trainee\")' ondragover='allowDrop(event)'><span data-value='"+JSON.stringify(tempArray)+"' class='omsb-complete-bg omsb-complete-bg-flex'>"+
	                                        traineeNamedata+"</span> <span onclick='traineeList("+JSON.stringify(tempArray)+", \"popup\", trainee_row_"+count+",\"trainee\")' class='omsb-complete-bg linktag'>+"+length+"</span></td>");
	                                
	                            } else {
	                                row.append("<td data-noofslots='"+siteByRotationsDTOs[i].noOfslots+"' data-startdate='"+new Date(blocksMetadataDetailsRels[j].blockStartDate)+"' data-enddate='"+new Date(blocksMetadataDetailsRels[j].blockEndDate)+"' data-leave='data' data-rotationmaster='"+siteByRotationsDTOs[i].rotationId+"' data-progcodersnsitecode='"+siteByRotationsDTOs[i].progCodeRsnSiteCode+"' data-rotation='"+siteByRotationsDTOs[i].progDurationRotationTsRelId+"' data-block='"+blocksMetadataDetailsRels[j].blocksMetadataDetailsRelId+"' id='trainee_row_"
	                                		+count+"' ondrop='traineedrop(event,\"trainee\")' ondragover='allowDrop(event)'><span data-value='"+JSON.stringify(tempArray)+"' class='omsb-complete-bg omsb-complete-bg-flex'>"
	                                		+traineeNamedata+"<a href='javascript:void(0)' onclick='traineeremoveItem(\"singleItem\",\"trainee\", trainee_row_"+count+","+traineeId+")' ><img src='<%=themeDisplay.getPathThemeImages()%>/svg/table_reject.svg' alt=''></a></span></td>");
	                            }
	                        
	                        }else{
	                            row.append("<td data-noofslots='"+siteByRotationsDTOs[i].noOfslots+"' data-startdate='"+new Date(blocksMetadataDetailsRels[j].blockStartDate)+"' data-enddate='"+new Date(blocksMetadataDetailsRels[j].blockEndDate)+"' data-leave='data' data-rotationmaster='"+siteByRotationsDTOs[i].rotationId+"' data-progcodersnsitecode='"+siteByRotationsDTOs[i].progCodeRsnSiteCode+"' data-rotation='"+siteByRotationsDTOs[i].progDurationRotationTsRelId+"' data-block='"+blocksMetadataDetailsRels[j].blocksMetadataDetailsRelId+"' id='trainee_row_"+count+"' ondrop='traineedrop(event,\"trainee\")' ondragover='allowDrop(event)'>"+traineeNamedata+"</td>");

	                        }
	                        count++;
	                    }
	                    s = n;
	                    n = s + blocksMetadataDetailsRels.length;
					}
                    $("#rotation-by-trainee-to-rotation tbody").append(row);
                }
                removeLoader();
        }
	});
}

function traineedrag(ev) {
	isChanged = true;
	ev.dataTransfer.setData("traineeId", ev.target.dataset.id);
	ev.dataTransfer.setData("traineeName", ev.target.innerText);
	ev.dataTransfer.setData("traineedragevent", ev);
	ev.dataTransfer.setData("levelBlockId", ev.srcElement.getAttribute("data-leave-block-id"));
	ev.dataTransfer.setData("drageeventData", "traineedrag");
}
function getSubstring(str, start, end) {
	  char1 =  str.indexOf(start) + 1;
	  char2 =  str.lastIndexOf(end);
	  return str.substring(char1, char2);
}
function traineedrop(ev,istrainee) {
	isChanged = true;
    ev.preventDefault();
    isElectiveRotation = false;
    var dataId = ev.dataTransfer.getData("traineeId");
    var data = ev.dataTransfer.getData("traineeName").split("(")[0];
    let totalblocks = 0;
    if(/\([\d]+\)/.test(ev.dataTransfer.getData("traineeName"))){
        totalblocks = getSubstring(ev.dataTransfer.getData("traineeName"), '(', ')');
    }
    var leaveBlockDataId = ev.dataTransfer.getData("levelBlockId");
    $.each(traineeElectiveRotationDTOs, function (index, item) {
        const {traineeId , rotationId } = item;
                if(rotationId === parseInt(ev.currentTarget.dataset.rotationmaster) && traineeId === parseInt(dataId)){
                    isElectiveRotation = true;
                }
    });
    if(ev.currentTarget.dataset.leave.toUpperCase() === "leave".toUpperCase()){
         if (ev.target.id) {
        	 leaveDataId = ev.target.id;
         } else {
        	 leaveDataId = ev.target.parentElement.id;
         }
        saveleaveType = "trainee";
        let currentDate = new Date();
        $(".leavedate").datepicker("destroy");
        $(".leavedate").datepicker({
            format: 'dd/mm/yyyy',
            startDate : new Date(formatDate(ev.currentTarget.dataset.startdate)),
            autoclose:true,
            todayHighlight:true,
            endDate: new Date(formatDate(ev.currentTarget.dataset.enddate)),
            maxDate: currentDate
        }).val('');
        $("#<portlet:namespace/>leaveType").empty();
        $("#<portlet:namespace/>leaveType").append("<option value='0' selected='true' disabled='true' Class='placeholder'><liferay-ui:message key='please-select-leave-type' /> </option>");
        for(let i=0; i<leaveTypes.length; i++){
            $("#<portlet:namespace/>leaveType").append("<option value='"+leaveTypes[i].leaveTypesId+"'>" + leaveTypes[i].leaveTypes + "</option>");
        }
        $("#<portlet:namespace/>traineeId").val(dataId);
        $("#<portlet:namespace/>blockId").val(parseInt(ev.currentTarget.dataset.block));
        var traineeId = $("#<portlet:namespace/>traineeId").val();
        $("#applyleave").modal("show");
    }else if(parseInt(totalblocks) === 0){
    	 $(".popup-alert-title").empty();
         $(".popup-alert-title").html(`<liferay-ui:message key="trainee-block-alert-title" />`);
         $(".popup-alert-message").empty();
         $(".popup-alert-message").html(`<liferay-ui:message key="trainee-block-alert" />`);
         $(".popup-alert-button").empty();
         $(".popup-alert-button").html(`<liferay-ui:message key="back" />`);
         $("#alertPopup").modal("show");
    }else{      
		var trainingSiteName =  isRecordPresentForTraineeWithSite(parseInt(ev.currentTarget.dataset.block), parseInt(ev.currentTarget.dataset.rotation), parseInt(dataId),parseInt(ev.currentTarget.dataset.rotationmaster),ev.currentTarget.dataset.progcodersnsitecode);
    	if(trainingSiteName.toUpperCase() !== ev.currentTarget.dataset.progcodersnsitecode.toUpperCase()){
        	$(".popup-alert-title").empty();
				$(".popup-alert-title").html(`<liferay-ui:message key="alert" />`);
				$(".popup-alert-message").empty();
				var popupdata = `<liferay-ui:message key="trainee-available-same-rotation-with-different-traineesite" />`;
				popupdata = popupdata.replace("<liferay-ui:message key="trainee" />","<b>"+data+"</b>");
				popupdata = popupdata.replace("<liferay-ui:message key="trainee-site" />","<b>"+trainingSiteName+"</b>");
				$(".popup-alert-message").html(popupdata);
				$(".popup-alert-button").empty();
				$(".popup-alert-button").html(`<liferay-ui:message key="cancel" />`);
				$("#alertPopup").modal("show");
        }else{
	        if(parseInt(ev.currentTarget.dataset.block) == parseInt(leaveBlockDataId)){
	            $(".popup-alert-title").empty();
	            $(".popup-alert-title").html(`<liferay-ui:message key="leave-alert" />`);
	            $(".popup-alert-message").empty();
	            $(".popup-alert-message").html(`<liferay-ui:message key="leave-exists" />`);
	            $(".popup-alert-button").empty();
	            $(".popup-alert-button").html(`<liferay-ui:message key="back" />`);
	            $("#alertPopup").modal("show");
	        }else{
	            let traineeBlocks = 0;
	            $.each(rotationtraineeBlock, function (index, item) {
	                const {rotationId , noOfBlocks } = item;
	                        if(rotationId === parseInt(ev.currentTarget.dataset.rotationmaster)){
	                            traineeBlocks = noOfBlocks;
	                        }
	            });
	            let count = 0;
	            $.each(traineeMasterRotationScheduleData, function (index, item) {
	                const {rotationId , traineeDetails } = item;
	                    $.each(traineeDetails, function (index, trainee) {
	                        if(rotationId === parseInt(ev.currentTarget.dataset.rotation) && trainee.traineeId === parseInt(dataId)){
	                            count++;
	                        }
	                    });
	            });
	            if(traineeBlocks<=count){
	                $(".popup-alert-title").empty();
	                $(".popup-alert-title").html(`<liferay-ui:message key="block-alert" />`);
	                $(".popup-alert-message").empty();
	                $(".popup-alert-message").html(`<liferay-ui:message key="remaining-block-not-available" />`);
	                $(".popup-alert-button").empty();
	                $(".popup-alert-button").html(`<liferay-ui:message key="back" />`);
	                $("#alertPopup").modal("show");
	            }else{
	            	if(isTraineeAvailableOnSameBlock(parseInt(ev.currentTarget.dataset.block), parseInt(ev.currentTarget.dataset.rotation), parseInt(dataId))){
	                        $(".popup-alert-title").empty();
	                        $(".popup-alert-title").html(`<liferay-ui:message key="block-alert" />`);
	                        $(".popup-alert-message").empty();
	                        $(".popup-alert-message").html(`<liferay-ui:message key="trainee-exists-in-same-block" />`);
	                        $(".popup-alert-button").empty();
	                        $(".popup-alert-button").html(`<liferay-ui:message key="back" />`);
	                        $("#alertPopup").modal("show");
	                 }else{
	                    	   if(!isRecordPresentForTrainee(parseInt(ev.currentTarget.dataset.block), parseInt(ev.currentTarget.dataset.rotation), parseInt(dataId))) {
	                           	
	                           	let noOfTraineeBlocks = parseInt(ev.currentTarget.dataset.noofslots);
	                               let totalTrainee = noOfTraineeBlocks*traineeTotalBlock;
	                               let length =0;
	                               $.each(traineeMasterRotationScheduleData, function (index, item) {
	                                   const {rotationId , traineeDetails } = item;
	                                   if(parseInt(rotationId) === parseInt(ev.currentTarget.dataset.rotation))
	                                       {
	                                           length += traineeDetails.length;
	                                       }
	                               });
	                               if(length == totalTrainee)
	                               {
	                                    $(".popup-alert-title").empty();
	                                    $(".popup-alert-title").html(`<liferay-ui:message key="trainee-limit-alert" />`);
	                                    $(".popup-alert-message").empty();
	                                    $(".popup-alert-message").html(`<liferay-ui:message key="trainee-limit-exceeds-alert" />`);
	                                    $(".popup-alert-button").empty();
	                                    $(".popup-alert-button").html(`<liferay-ui:message key="back" />`);
	                                    $("#alertPopup").modal("show");
	                               }
	                               else{
	                               	if(isElectiveRotation){
	                               		$("#confirmationModalForElective").modal("show");
	                               	}
	                               		let traineeList;
	                               		let facultyList;
	                                       let id = "";
	                                       if (ev.target.id) {
	                                           id = ev.target.id;
	                                       } else {
	                                           id = ev.target.parentElement.id;
	                                       }
	                                       elementID = document.getElementById(id);
	                                       if (elementID.childNodes.length > 0) {
	                                           traineeList = JSON.parse(elementID.childNodes[0].getAttribute("data-value"));
	                                       } else {
	                                           traineeList = [];
	                                       }
	                                       var foundObject = traineeMasterRotationScheduleData.find(obj => obj.blockId === parseInt(ev.currentTarget.dataset.block) && obj.rotationId === parseInt(ev.currentTarget.dataset.rotation));
	                                       if (foundObject) {
	                                          foundObject.traineeDetails.push({traineeId:parseInt(dataId),traineeName:data});
	                                       }else{
	                                           traineeMasterRotationScheduleData.push({
	                                               "blockId" : parseInt(ev.currentTarget.dataset.block),
	                                               "rotationId" : parseInt(ev.currentTarget.dataset.rotation),
	                                               "progCodeRsnSiteCode" : ev.currentTarget.dataset.progcodersnsitecode,
	                                               "rotationMasterId" : parseInt(ev.currentTarget.dataset.rotationmaster),
	                                               "traineeDetails" : [{traineeId:parseInt(dataId),traineeName:data}]
	                                           })
	                                       }
	                                       traineeList = [...traineeList, { traineeName: data, traineeId: dataId}];
	                                       if(istrainee.toUpperCase() === "traineeFaculty".toUpperCase()){
	                                       	if (elementID.childNodes.length > 0) {
	                               				facultyList = JSON.parse(elementID.childNodes[0].getAttribute("data-faculty"));
	                               			} else {
	                               				facultyList = [];
	                               			}
	                               			traineeFacultycellItem(id,traineeList, facultyList);
	                                       }else{
	                                      		traineecellItem(id, traineeList, data,dataId);
	                                       }
	                                       var element = $("[data-id="+dataId+"] span");
	                                       let innerText = "";
	                                       if(parseInt(totalblocks) !== 1){
	                                           innerText = "("+ (parseInt(totalblocks)-1) + ")";
	                                       }
	                                       $.each(element, function (index, item) {
	                                       	item.innerHTML = innerText;
	                                       });
	                               }
	                           	
	                           }else{
	                               $('#dataExistModal').modal("show");
	                           }
	                    }
	            }
	
	        }
    	}
    }

}

function traineecellItem(id, traineeList, data,dataId) {
	elementID = document.getElementById(id);
	elementID.innerHTML = "";
	if (traineeList.length) {
		if (traineeList.length > 1) {
			elementID.innerHTML = `<span  data-value='\${JSON.stringify(traineeList)}'  class="omsb-complete-bg omsb-complete-bg-flex" data-id="\${dataId}">\${data}</span>
																<span onclick='traineeList(\${JSON.stringify(traineeList)}, "popup", \${id},\"trainee\")'   class="omsb-complete-bg linktag">+\${traineeList.length - 1}</span>`;
		} else {
			elementID.innerHTML = `<span  data-value='\${JSON.stringify(traineeList)}'  class="omsb-complete-bg omsb-complete-bg-flex" data-id="\${dataId}">\${data} <a href="javascript:void(0)" onclick='traineeremoveItem("singleItem","trainee", \${id}, \${dataId})' ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/table_reject.svg" alt=""></a></span>`;
		}
	}

}

function traineeList(parm1, parm2, parm3,parm4) {
	if(parm3.length >= 1){
		parm3 = parm3[0];
	}
	document.querySelector(".blockdetail_table table tbody").innerHTML = "";
	if (parm2 == "popup") {
        tempTraineeArray = [];
        tempTraineeArray = parm1
	} else if (parm1 == 'singleItem') {
    	tempTraineeArray = [];
    }
    else {
    	tempTraineeArray = tempTraineeArray.filter((item, index) => index != parm1);
    }
	let traineeList = '';
	let lastNameoftrainee = '';
	let lastIdoftrainee = '';
	tempTraineeArray.forEach(function (item, index) {
		traineeList = `<tr>
								<td>\${item.traineeName}</td>
								<td><a href="javascript:void(0)" onclick='traineeremoveItem(\${index},"\${parm4}", \${parm3.id}, \${item.traineeId})' ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/table_reject.svg" alt=""><liferay-ui:message key="remove" /></a></td>
							</tr>`;
		document.querySelector(".blockdetail_table table tbody").innerHTML += traineeList;
		if (tempTraineeArray.length == index + 1){
			lastNameoftrainee = item.traineeName;
			lastIdoftrainee = item.traineeId;
		}
	});
	if (parm2 == "popup") {
	    let blockId = parm3.dataset.block;
	    let rotationId = parm3.dataset.rotation;
	    let rotationName = $("#traineeRotationMasterrotation"+rotationId).text();
	    let blockName = $("#traineeRotationMasterblock"+blockId).text();
		$(".block-detail-title").empty();
		$(".block-detail-title").html(rotationName+" "+blockName);
		$(".block-detail-header").empty();
		$(".block-detail-header").html(`<liferay-ui:message key='trainee-name' />`);
		$("#blockDetailListPopup").click();
	} else {
        if(parm4.toUpperCase() === "traineeFaculty".toUpperCase()){
        	let facultyList;
        	if (parm3.childNodes.length > 0) {
				facultyList = JSON.parse(parm3.childNodes[0].getAttribute("data-faculty"));
			} else {
				facultyList = [];
			}
			traineeFacultycellItem(parm3.id,tempTraineeArray, facultyList);
        }else{
    		traineecellItem(parm3.id, tempTraineeArray, lastNameoftrainee, lastIdoftrainee)
        }
	}
}

function traineeremoveItem(dataIndex,traineeFaculty, parm3,traineeId) {
	isChanged = true;
	let blockId = parm3.getAttribute("data-block");
	let rotationId = parm3.getAttribute("data-rotation");
	var element = $("[data-id="+traineeId+"] span");
	if (element.length) {
		let totalblocks = 1;
		if(/\([\d]+\)/.test(element.html())){
			totalblocks = parseInt(element.html().replace("(","").replace(")","").replace(" ","")) + 1;
		}
		let innerText = "("+ totalblocks + ")";
		$.each(element, function (index, item) {
        	item.innerHTML = innerText;
        });
	}
	removeTraineeDetails(blockId, rotationId, traineeId)
	removeFacultyDetails(blockId, rotationId, traineeId);
	traineeList(dataIndex, "nonpopup", parm3, traineeFaculty);
}

function traineeLeaveList(parm1, parm2, parm3) {
	if(parm3.length >= 1){
		parm3 = parm3[0];
	}
	document.querySelector(".blockdetail_table table tbody").innerHTML = "";
	if (parm2 == "popup") {
        tempLeaveTraineeArray = [];
        tempLeaveTraineeArray = parm1
	} else if (parm1 == 'singleItem') {
		tempLeaveTraineeArray = [];
    }
    else {
    	tempLeaveTraineeArray = tempLeaveTraineeArray.filter((item, index) => index != parm1);
    }
	let traineeList = '';
	let lastNameoftrainee = '';
	let lastIdoftrainee = '';
	tempLeaveTraineeArray.forEach(function (item, index) {
		traineeList = traineeList + `<tr>
								<td>\${item.traineeName}</td><td>\${item.leaveTypeName}</td><td>\${item.leaveStartDate}</td><td>\${item.leaveEndDate}</td>
								<td><a href="javascript:void(0)" onclick='traineeremoveLeaveItem(\${index}, \${parm3.id}, \${item.traineeId}, \${item.leaveMasterId})' ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/table_reject.svg" alt=""><liferay-ui:message key="remove" /></a></td>
							</tr>`;
			
		document.querySelector(".blockdetail_table table tbody").innerHTML = traineeList;
		if (tempLeaveTraineeArray.length == index + 1){
			lastNameoftrainee = item.traineeName;
			lastIdoftrainee = item.traineeId;
		}
	});
	if (parm2 == "popup") {
	    let blockId = parm3.dataset.block;
	    let rotationId = parm3.dataset.rotation;
	    let rotationName = $("#traineeRotationMasterrotation"+rotationId).text();
	    let blockName = $("#traineeRotationMasterblock"+blockId).text().split("(")[0];
	    blockName = blockName.charAt(0).toUpperCase() + blockName.slice(1);
	    $(".trainee-detail-title").empty();
		$(".trainee-detail-title").html(blockName+" ");
		$(".blockdetail_table table tbody").empty();
		$(".blockdetail_table table tbody").html(traineeList);
		$("#traineeleavedetails").modal("show");
	} else {
		traineeleavecellItem(parm3.id, tempLeaveTraineeArray, lastNameoftrainee, lastIdoftrainee)
	}
}

function traineeremoveLeaveItem(dataIndex, parm3,traineeId,leaveMasterId) {
	let programMasterId = $("#<portlet:namespace/>programMasterId").val();
	$.ajax({
			url : '<%=deleteTraineeLeave%>',
			type : 'POST',
			data : {
				<portlet:namespace/>programMasterId : programMasterId,
				<portlet:namespace/>leaveMasterId : leaveMasterId,
			},
			success : function(data) {
				isChanged = true;
				let jsondata = JSON.parse(data);
				if(!jsondata){
					$("#traineeleavedetails").modal("hide");
					$(".popup-alert-title").empty();
					$(".popup-alert-title").html(`<liferay-ui:message key="delete-alert" />`);
					$(".popup-alert-message").empty();
					$(".popup-alert-message").html(`<liferay-ui:message key="delete-data-issue" />`);
					$(".popup-alert-button").empty();
					$(".popup-alert-button").html(`<liferay-ui:message key="back" />`);
					$("#alertPopup").modal("show");
				} else {
					let blockId = parm3.getAttribute("data-block");
					let rotationId = parm3.getAttribute("data-rotation");
					removeTraineeDetails(blockId, rotationId, traineeId)
					traineeLeaveList(dataIndex, "nonpopup", parm3);
					$("#traineeleavedetails").modal("hide");
					$("#deleteLeaveSucessModal").modal("show");
				}
				
			}
	 });
}

function traineeleavecellItem(id, traineeList, data,dataId) {
	elementID = document.getElementById(id);
	elementID.innerHTML = "";
	if (traineeList.length) {
		if (traineeList.length > 1) {
			elementID.innerHTML = `<span  data-value='\${JSON.stringify(traineeList)}'  class="omsb-complete-bg omsb-complete-bg-flex" data-id="\${dataId}">\${data}</span>
																<span onclick='traineeLeaveList(\${JSON.stringify(traineeList)}, "popup", \${id})'   class="omsb-complete-bg linktag">+\${traineeList.length - 1}</span>`;
		} else {
			let traineeData = traineeList[0];
			elementID.innerHTML = `<span onclick='traineeLeaveList(\${JSON.stringify(traineeList)}, "popup", \${id})'  data-value='\${JSON.stringify(traineeList)}'  class="omsb-complete-bg omsb-complete-bg-flex linktag" data-id="\${dataId}">\${data} </span>`;
		}
	}

}

function isRecordPresentForTrainee(blockId, rotationId, traineeId) {
	return traineeMasterRotationScheduleData.some(function (obj) {
		return (
			obj.blockId === blockId &&
			obj.rotationId === rotationId &&
			obj.traineeDetails.some(function (trainee) {
				return trainee.traineeId === traineeId;
			})
		);
	});
}

function isRecordPresentForTraineeWithSite(blockIdData, rotationIdData, traineeIdData,rotationMasterIdData,progcodersnsitecodeData) {
	var isRotationPresentInTrainingSite = progcodersnsitecodeData;
	$.each(traineeMasterRotationScheduleData, function (index, item) {
		const {rotationId , traineeDetails,rotationMasterId,progCodeRsnSiteCode } = item;
			$.each(traineeDetails, function (index, trainee) {
				if(trainee.traineeId === traineeIdData && rotationMasterId == rotationMasterIdData){
					if(rotationId != rotationIdData){
						isRotationPresentInTrainingSite = progCodeRsnSiteCode;
					}
				}

			});
	});
	return isRotationPresentInTrainingSite;
}
function isTraineeAvailableOnSameBlock(blockIddata, rotationId, traineeId) {
	if(parseInt(programMasterData) === 0){
		return traineeMasterRotationScheduleData.some(function (obj) {
			return (
				obj.blockId === blockIddata && obj.progCodeRsnSiteCode !== "leave".toUpperCase() &&
				obj.traineeDetails.some(function (trainee) {
					return trainee.traineeId === traineeId;
				})
			);
		});
	}else{
		let count = 0;
		$.each(traineeMasterRotationScheduleData, function (index, item) {
			const {blockId , traineeDetails,progCodeRsnSiteCode } = item;
				$.each(traineeDetails, function (index, trainee) {
					if(blockId === blockIddata && trainee.traineeId === traineeId && progCodeRsnSiteCode !== "leave".toUpperCase()){
						count++;
					}
	
				});
		});
		if (count === 2) {
			return true;
		}else{
			return false;
		}
	}

}

function removeTraineeDetails(blockId, rotationId, traineeId) {
	var jsonObject = traineeMasterRotationScheduleData.find(obj => obj.blockId === parseInt(blockId) && obj.rotationId === parseInt(rotationId));
	if (jsonObject) {
		jsonObject.traineeDetails = jsonObject.traineeDetails.filter(function(obj) {
			return obj.traineeId !== traineeId;
		});
	}
}

/* trainee code end */


/* rotation code start */
 function getRotation(){
	 	$(".pagetitle").empty();
		$(".pagetitle").html(`<liferay-ui:message key="master-rotation-by-rotation" />`);
		let programMasterId = $("#<portlet:namespace/>programMasterId").val();
	    let progdurationTlBlocksLtId = $("#<portlet:namespace/>progdurationTlBlocksLtId").val();
		$.ajax({
			url: '<%=getRotationResourceCommandUrl%>',
			type: 'POST',
			data:
				{
				<portlet:namespace/>programMasterId : programMasterId,
				<portlet:namespace/>progdurationTlBlocksLtId : progdurationTlBlocksLtId
				},
			success: function(data)	
			{
				trainingSiteByRotationsDTOsOuter = [];
				isChanged = false;
				rotationMasterRotationScheduleData = [];
				tempRotationArray = [];
				leaveMaterDataForRotation = [];
				let jsondata = JSON.parse(data);
				let trainingSiteByRotationsDTOs= jsondata.trainingSiteByRotationsDTOs;
				let blocksMetadataDetailsRels= jsondata.blocksMetadataDetailsRels;
				let traineeDetailsWithBlocksDTOs= jsondata.traineeDetailsWithBlocksDTOs;
				let traineeRotationTsBlockDetailsRelByRotationDTOs= jsondata.traineeRotationTsBlockDetailsRelByRotationDTOs;
				let rotationTraineeBlockRelationDTOs= jsondata.rotationTraineeBlockRelationDTOs;
				traineeElectiveRotationDTOs = jsondata.traineeElectiveRotationDTOs;
				leaveTypes = jsondata.leaveTypes;
				traineeTotalBlock = blocksMetadataDetailsRels.length;
				rotationtraineeBlock = rotationTraineeBlockRelationDTOs;
				blocksMetadataDetailsRelsData = blocksMetadataDetailsRels;
				trainingSiteByRotationsDTOsOuter = trainingSiteByRotationsDTOs;
				let s = 0;
				let n = blocksMetadataDetailsRels.length;
				$("#rotation-by-rotation tbody").empty();
				for(let i=0; i<trainingSiteByRotationsDTOs.length; i++){
					var row = $("<tr>");
					let rotationData = "";
					if(trainingSiteByRotationsDTOs[i].progCodeRsnSiteCode.toUpperCase() === "leave".toUpperCase()){
						rotationData =rotationData + "<td class='rotation-leave-details'";
					}else{
						rotationData = rotationData +"<td class='rotation-details'";
					}
					rotationData = rotationData + "id='rotationRotationMasterRotation"+trainingSiteByRotationsDTOs[i].progDurationRotationTsRelId+"' data-value='"+trainingSiteByRotationsDTOs[i].progCodeRsnSiteCode+"' data-id='"+trainingSiteByRotationsDTOs[i].progDurationRotationTsRelId+"'><div class='draggable-wrap'><img src='<%=themeDisplay.getPathThemeImages()%>/svg/drag-icon.svg' alt=''><div data-rotationMasterId='"+trainingSiteByRotationsDTOs[i].rotationId+"' data-noofslots='"+trainingSiteByRotationsDTOs[i].noOfslots+"' draggable='true' ondragstart='drag(event)' class='drag-rotation-item linktag' data-id='"+trainingSiteByRotationsDTOs[i].progDurationRotationTsRelId+"'";
					if(trainingSiteByRotationsDTOs[i].sharedRotationType){
						traineeSharedRotationDTOs.push({"rotationId":trainingSiteByRotationsDTOs[i].rotationId});
						rotationData = rotationData +"data-isshared=true >"+ trainingSiteByRotationsDTOs[i].progCodeRsnSiteCode;
						if(parseInt(trainingSiteByRotationsDTOs[i].noOfslots) !== 0){
							rotationData = rotationData + "<span> ("+trainingSiteByRotationsDTOs[i].noOfslots+")</span><span class='omsb-complete-bg'>S</span>";
						}
					}else{
						rotationData = rotationData +"data-isshared=false >"+ trainingSiteByRotationsDTOs[i].progCodeRsnSiteCode;
						if(parseInt(trainingSiteByRotationsDTOs[i].noOfslots) !== 0){
							rotationData = rotationData + "<span> ("+trainingSiteByRotationsDTOs[i].noOfslots+")</span>";
						}
					}
					rotationData = rotationData + "</div></div></td>";
					row.append(rotationData);
					$("#rotation-by-rotation tbody").append(row);
				}
				$("#trainee-by-rotation thead tr").empty();
				$("#trainee-by-rotation thead tr").append("<th>trainee</th>");
				
				for(let i=0; i<blocksMetadataDetailsRels.length; i++){
	                var startRotationD = blocksMetadataDetailsRels[i].blockStartDate;
	                var endRotationD = blocksMetadataDetailsRels[i].blockEndDate;
	                var newRotationDate = new Date(startRotationD);
	                var newRotationEndDate = new Date(endRotationD);
	                var getRotationYear = newRotationDate.toLocaleString("default", { year: "numeric" });
	                var getRotationMonth = newRotationDate.toLocaleString("default", { month: "2-digit" });
	                var getRotationDay = newRotationDate.toLocaleString("default", { day: "2-digit" });
	                var getRotationEndYear = newRotationEndDate.toLocaleString("default", { year: "numeric" });
	                var getRotationEndMonth = newRotationEndDate.toLocaleString("default", { month: "2-digit" });
	                var getRotationEndDay = newRotationEndDate.toLocaleString("default", { day: "2-digit" });
	                var blockRotationStartDate = getRotationDay + "-" + getRotationMonth + "-" + getRotationYear;
	                var blockRotationEndDate = getRotationEndDay + "-" + getRotationEndMonth + "-" + getRotationEndYear;
	                $("#trainee-by-rotation thead tr").append("<th id='rotationRotationMasterBlock"+blocksMetadataDetailsRels[i].blocksMetadataDetailsRelId+"'>"+blocksMetadataDetailsRels[i].blockNo+"<br/> ("+blockRotationStartDate+" to "+blockRotationEndDate+")</th>");
	            }
				$("#trainee-by-rotation tbody").empty();
				var count = 1;
				for(let i=0; i<traineeDetailsWithBlocksDTOs.length; i++){
					var row = $("<tr>");
					row.append("<td data-rotationMasterId='"+rotationTraineeBlockRelationDTOs+"' data-leave="+traineeDetailsWithBlocksDTOs[i].leaveBlocks+" data-id="+traineeDetailsWithBlocksDTOs[i].traineeId+" data-value="+traineeDetailsWithBlocksDTOs[i].traineeName+" class='trainee-details-by-rotation linktag' id=rotationRotationMasterTrainee"+traineeDetailsWithBlocksDTOs[i].traineeId+">"+traineeDetailsWithBlocksDTOs[i].traineeName+"</td>");
					let traineeRotation = traineeRotationTsBlockDetailsRelByRotationDTOs.slice(s, n);
					for(let j=0; j<traineeRotation.length; j++){
						let rotationId= 0;
						let rotationNamedata = "";
						let rowData = "<td data-startdate='"+new Date(blocksMetadataDetailsRels[j].blockStartDate)+"' data-enddate='"+new Date(blocksMetadataDetailsRels[j].blockEndDate)+"' data-leave="+traineeDetailsWithBlocksDTOs[i].leaveBlockNo+" data-block="+blocksMetadataDetailsRels[j].blocksMetadataDetailsRelId+" data-trainee="+traineeDetailsWithBlocksDTOs[i].traineeId+" id='rotation_row_"+count+"' ondrop='drop(event)' ondragover='allowDrop(event)'>";
						if(traineeRotation[j].progdurationRotationTrainingsitesRels){
							tempArray = [];
							rotationMasterRotationScheduleData.push({
								"rowId" : "rotation_row_"+count,
		        				"blockId" : parseInt(blocksMetadataDetailsRels[j].blocksMetadataDetailsRelId),
		        				"traineeId" : parseInt(traineeDetailsWithBlocksDTOs[i].traineeId),
		        				"rotationDetails" : []
		        			});
		        			var electiveRotation = false;
		        			isTraineeSharedRotation = false;
							for(let k=0; k<traineeRotation[j].progdurationRotationTrainingsitesRels.length; k++){
								$.each(traineeSharedRotationDTOs, function (index, item) {
							        const {rotationId } = item;
							                if(rotationId === parseInt(traineeRotation[j].progdurationRotationTrainingsitesRels[k].rotationId)){
							                	isTraineeSharedRotation = true;
							                }
							    });
								$.each(traineeElectiveRotationDTOs, function (index, item) {
							        const {traineeId , rotationId } = item;
							                if(rotationId === parseInt(traineeRotation[j].progdurationRotationTrainingsitesRels[k].rotationId) && traineeId === parseInt(traineeDetailsWithBlocksDTOs[i].traineeId)){
							                	electiveRotation = true;
							                }
							    });
								var foundObject = rotationMasterRotationScheduleData.find(obj => obj.blockId === parseInt(blocksMetadataDetailsRels[j].blocksMetadataDetailsRelId) && obj.traineeId === parseInt(traineeDetailsWithBlocksDTOs[i].traineeId));
								if (foundObject) {
									  foundObject.rotationDetails.push({rotationId:traineeRotation[j].progdurationRotationTrainingsitesRels[k].progdurationRotationTsRelId,rotationName:traineeRotation[j].progdurationRotationTrainingsitesRels[k].progCodeRsnSiteCode,rotationMasterId:traineeRotation[j].progdurationRotationTrainingsitesRels[k].rotationId});
								}
								let rotationName = traineeRotation[j].progdurationRotationTrainingsitesRels[k].progCodeRsnSiteCode;
								tempArray.push({ rotationName });
								rotationId = traineeRotation[j].progdurationRotationTrainingsitesRels[k].progdurationRotationTsRelId;
								rotationNamedata = traineeRotation[j].progdurationRotationTrainingsitesRels[k].progCodeRsnSiteCode;
							}
							let leavetype = 0;
							
							if (tempArray.length > 1) {
								 let length = tempArray.length - 1;
								 rowData = rowData + "<span data-value='"+JSON.stringify(tempArray)+"' class='omsb-complete-bg omsb-complete-bg-flex'>"+
											rotationNamedata+"</span> <span onclick='rotationList("+JSON.stringify(tempArray)+",\"popup\", rotation_row_"+count+")' class='omsb-complete-bg linktag'>+"+length+"</span>";
									
								} else {
									rowData = rowData + "<span data-value='"+JSON.stringify(tempArray)+"' class='omsb-complete-bg omsb-complete-bg-flex'>"
											+rotationNamedata+"";
									if(isTraineeSharedRotation){
										rowData = rowData +"<span class='s-icon shared-rotation'>S</span>";
									}
									rowData = rowData + "<a href='javascript:void(0)' onclick='removeItem(0, rotation_row_"+count+","+rotationId+")' ><img src='<%=themeDisplay.getPathThemeImages()%>/svg/table_reject.svg' alt=''></a>";
									if(electiveRotation){
										rowData = rowData +"<span class='elective'>E</span>";
									}
									rowData = rowData + "</span>";
								}
							if(traineeRotation[j].detailsWithBlocksDTOs){
								for(let l=0; l<traineeRotation[j].detailsWithBlocksDTOs.length; l++){
									 var startRotationD = traineeRotation[j].detailsWithBlocksDTOs[l].fromDate;
						             var endRotationD = traineeRotation[j].detailsWithBlocksDTOs[l].toDate;
						             var newRotationDate = new Date(startRotationD);
						             var newRotationEndDate = new Date(endRotationD);
						             var getRotationYear = newRotationDate.toLocaleString("default", { year: "numeric" });
						             var getRotationMonth = newRotationDate.toLocaleString("default", { month: "2-digit" });
						             var getRotationDay = newRotationDate.toLocaleString("default", { day: "2-digit" });
						             var getRotationEndYear = newRotationEndDate.toLocaleString("default", { year: "numeric" });
						             var getRotationEndMonth = newRotationEndDate.toLocaleString("default", { month: "2-digit" });
						             var getRotationEndDay = newRotationEndDate.toLocaleString("default", { day: "2-digit" });
						             var leaveStartDate = getRotationDay + "-" + getRotationMonth + "-" + getRotationYear;
						             var leaveEndDate = getRotationEndDay + "-" + getRotationEndMonth + "-" + getRotationEndYear;
						             let leaveData = {
						            		 	"rowId" : "rotation_row_"+count,
												"traineeName" : traineeRotation[j].detailsWithBlocksDTOs[l].traineeName,
						        				"leaveTypeName" : traineeRotation[j].detailsWithBlocksDTOs[l].leaveTypeName,
						        				"leaveStartDate" : leaveStartDate,
						        				"leaveEndDate" : leaveEndDate,
						        				"traineeId" : parseInt(traineeRotation[j].detailsWithBlocksDTOs[l].traineeId),
						        				"blockNo" : blocksMetadataDetailsRels[j].blockNo,
						        				"blockId" : parseInt(blocksMetadataDetailsRels[j].blocksMetadataDetailsRelId),
						        				"leaveMasterId" : parseInt(traineeRotation[j].detailsWithBlocksDTOs[l].leaveMasterId)
						        	}
						             leaveMaterDataForRotation.push(leaveData)
					        		 let leaveDetailData = [];
						             leaveDetailData.push(leaveData)
						             rowData = rowData + "<span onclick='leaveDetails("+JSON.stringify(leaveDetailData)+")' id='leave_"+traineeRotation[j].detailsWithBlocksDTOs[l].leaveMasterId+"' class='omsb-al linktag'>";
                                     if(traineeRotation[j].detailsWithBlocksDTOs[l].leaveType.toUpperCase() === "AL".toUpperCase()){
                                            rowData = rowData + "<img src='<%=themeDisplay.getPathThemeImages()%>/svg/al.svg' alt=''>"
                                     }else if(traineeRotation[j].detailsWithBlocksDTOs[l].leaveType.toUpperCase() === "SKL".toUpperCase()){
                                            rowData = rowData + "<img src='<%=themeDisplay.getPathThemeImages()%>/svg/sl.svg' alt=''>"
                                     }else if(traineeRotation[j].detailsWithBlocksDTOs[l].leaveType.toUpperCase() === "EML".toUpperCase()){
                                            rowData = rowData + "<img src='<%=themeDisplay.getPathThemeImages()%>/svg/el.svg' alt=''>"
                                     }else if(traineeRotation[j].detailsWithBlocksDTOs[l].leaveType.toUpperCase() === "SCL".toUpperCase()){
                                            rowData = rowData + "<img src='<%=themeDisplay.getPathThemeImages()%>/svg/sci-l.svg' alt=''>"
                                     }else if(traineeRotation[j].detailsWithBlocksDTOs[l].leaveType.toUpperCase() === "MTL".toUpperCase()){
                                            rowData = rowData + "<img src='<%=themeDisplay.getPathThemeImages()%>/svg/ml.svg' alt=''>"
                                     }else{
                                            rowData = rowData + "<img src='<%=themeDisplay.getPathThemeImages()%>/svg/cl.svg' alt=''>"
                                     }
									 rowData = rowData+ "&nbsp;" +traineeRotation[j].detailsWithBlocksDTOs[l].leaveType+"</span>";								
								}
							}
								
						}else{
							if(traineeRotation[j].detailsWithBlocksDTOs){
								for(let l=0; l<traineeRotation[j].detailsWithBlocksDTOs.length; l++){
									var startRotationD = traineeRotation[j].detailsWithBlocksDTOs[l].fromDate;
						             var endRotationD = traineeRotation[j].detailsWithBlocksDTOs[l].toDate;
						             var newRotationDate = new Date(startRotationD);
						             var newRotationEndDate = new Date(endRotationD);
						             var getRotationYear = newRotationDate.toLocaleString("default", { year: "numeric" });
						             var getRotationMonth = newRotationDate.toLocaleString("default", { month: "2-digit" });
						             var getRotationDay = newRotationDate.toLocaleString("default", { day: "2-digit" });
						             var getRotationEndYear = newRotationEndDate.toLocaleString("default", { year: "numeric" });
						             var getRotationEndMonth = newRotationEndDate.toLocaleString("default", { month: "2-digit" });
						             var getRotationEndDay = newRotationEndDate.toLocaleString("default", { day: "2-digit" });
						             var leaveStartDate = getRotationDay + "-" + getRotationMonth + "-" + getRotationYear;
						             var leaveEndDate = getRotationEndDay + "-" + getRotationEndMonth + "-" + getRotationEndYear;
						             let leaveData = {
						            		 	"rowId" : "rotation_row_"+count,
												"traineeName" : traineeRotation[j].detailsWithBlocksDTOs[l].traineeName,
						        				"leaveTypeName" : traineeRotation[j].detailsWithBlocksDTOs[l].leaveTypeName,
						        				"leaveStartDate" : leaveStartDate,
						        				"leaveEndDate" : leaveEndDate,
						        				"traineeId" : parseInt(traineeRotation[j].detailsWithBlocksDTOs[l].traineeId),
						        				"blockNo" : blocksMetadataDetailsRels[j].blockNo,
						        				"blockId" : parseInt(blocksMetadataDetailsRels[j].blocksMetadataDetailsRelId),
						        				"leaveMasterId" : parseInt(traineeRotation[j].detailsWithBlocksDTOs[l].leaveMasterId)
						        	}
						             leaveMaterDataForRotation.push(leaveData)
					        		 let leaveDetailData = [];
						             leaveDetailData.push(leaveData)
						             rowData = rowData + "<span onclick='leaveDetails("+JSON.stringify(leaveDetailData)+")' id='leave_"+traineeRotation[j].detailsWithBlocksDTOs[l].leaveMasterId+"' class='omsb-al linktag'>";
                                     if(traineeRotation[j].detailsWithBlocksDTOs[l].leaveType.toUpperCase() === "AL".toUpperCase()){
                                            rowData = rowData + "<img src='<%=themeDisplay.getPathThemeImages()%>/svg/al.svg' alt=''>"
                                     }else if(traineeRotation[j].detailsWithBlocksDTOs[l].leaveType.toUpperCase() === "SKL".toUpperCase()){
                                            rowData = rowData + "<img src='<%=themeDisplay.getPathThemeImages()%>/svg/sl.svg' alt=''>"
                                     }else if(traineeRotation[j].detailsWithBlocksDTOs[l].leaveType.toUpperCase() === "EML".toUpperCase()){
                                            rowData = rowData + "<img src='<%=themeDisplay.getPathThemeImages()%>/svg/el.svg' alt=''>"
                                     }else if(traineeRotation[j].detailsWithBlocksDTOs[l].leaveType.toUpperCase() === "SCL".toUpperCase()){
                                            rowData = rowData + "<img src='<%=themeDisplay.getPathThemeImages()%>/svg/sci-l.svg' alt=''>"
                                     }else if(traineeRotation[j].detailsWithBlocksDTOs[l].leaveType.toUpperCase() === "MTL".toUpperCase()){
                                            rowData = rowData + "<img src='<%=themeDisplay.getPathThemeImages()%>/svg/ml.svg' alt=''>"
                                     }else{
                                            rowData = rowData + "<img src='<%=themeDisplay.getPathThemeImages()%>/svg/cl.svg' alt=''>"
                                     }
									 rowData = rowData+ "&nbsp;" +traineeRotation[j].detailsWithBlocksDTOs[l].leaveType+"</span>";								
									 }
							}
							else{
								rowData = rowData + rotationNamedata;
							}
						}
						count++;
						rowData = rowData + "</td>";
						row.append(rowData);
					}
					
					s = n;
					n = s + blocksMetadataDetailsRels.length;
					$("#trainee-by-rotation tbody").append(row);
				}
				removeLoader();
			}
		});
	}

function allowDrop(ev) {
	ev.preventDefault();
}

function drag(ev) {
	isChanged = true;
	ev.dataTransfer.setData("rotationId", ev.target.dataset.id);
	ev.dataTransfer.setData("rotationName", ev.target.innerText);
	ev.dataTransfer.setData("rotationMasterId", ev.srcElement.getAttribute("data-rotationMasterId"));
	ev.dataTransfer.setData("noofslots", ev.srcElement.getAttribute("data-noofslots"));
	ev.dataTransfer.setData("issharedRotation", ev.srcElement.getAttribute("data-isshared"));
}

function drop(ev) {
	isChanged = true;
	ev.preventDefault();
    isElectiveRotation = false;
    issharedRotation = "false";
	var dataId = ev.dataTransfer.getData("rotationId");
	var data = ev.dataTransfer.getData("rotationName").split("(")[0];
	var rotationMasterId = ev.dataTransfer.getData("rotationMasterId");
	issharedRotation = ev.dataTransfer.getData("issharedRotation");
	if(issharedRotation.toUpperCase() === "true".toUpperCase()){
		data = data.slice(0,-1);
	}
	var noofslots = ev.dataTransfer.getData("noofslots");
	var leave = ev.currentTarget.dataset.leave;
	$.each(traineeElectiveRotationDTOs, function (index, item) {
        const {traineeId , rotationId } = item;
                if(rotationId === parseInt(rotationMasterId) && traineeId === parseInt(ev.currentTarget.dataset.trainee)){
                    isElectiveRotation = true;
                }
    });
	if(data.toUpperCase() === "leave".toUpperCase()){
		let currentDate = new Date();
        $(".leavedate").datepicker("destroy");
	    $(".leavedate").datepicker({
	        format: 'dd/mm/yyyy',
	        startDate : new Date(formatDate(ev.currentTarget.dataset.startdate)),
	        autoclose:true,
	        todayHighlight:true,
	        endDate: new Date(formatDate(ev.currentTarget.dataset.enddate)),
	        maxDate: currentDate
	    }).val('');
	    saveleaveType = "rotation";
		if (ev.target.id) {
			leaveDataId = ev.target.id;
		} else {
			leaveDataId = ev.target.parentElement.id;
		}
	    $("#<portlet:namespace/>leaveType").empty();
		$("#<portlet:namespace/>leaveType").append("<option value='0' selected='true' disabled='true' Class='placeholder'><liferay-ui:message key='please-select-leave-type' /> </option>");
		for(let i=0; i<leaveTypes.length; i++){
			$("#<portlet:namespace/>leaveType").append("<option value='"+leaveTypes[i].leaveTypesId+"'>" + leaveTypes[i].leaveTypes + "</option>");
		}
		$("#<portlet:namespace/>traineeId").val(ev.currentTarget.dataset.trainee);
		$("#<portlet:namespace/>blockId").val(parseInt(ev.currentTarget.dataset.block));
		$("#applyleave").modal("show");
	}else{
		var rotationTrainingSiteId = isRecordPresentForRotationWithSite(parseInt(ev.currentTarget.dataset.block), parseInt(ev.currentTarget.dataset.trainee), parseInt(dataId),parseInt(rotationMasterId));
		if(rotationTrainingSiteId !== parseInt(dataId)){
		    let rotationTrainingSiteName = $("#rotationRotationMasterRotation"+rotationTrainingSiteId).text().split("(")[0];
		    let TrainingSiteTraineeName = $("#rotationRotationMasterTrainee"+parseInt(ev.currentTarget.dataset.trainee)).text();
        	$(".popup-alert-title").empty();
				$(".popup-alert-title").html(`<liferay-ui:message key="alert" />`);
				$(".popup-alert-message").empty();
				var popupdata = `<liferay-ui:message key="trainee-available-same-rotation-with-different-traineesite" />`;
				popupdata = popupdata.replace("<liferay-ui:message key="trainee" />","<b>"+TrainingSiteTraineeName+"</b>");
				popupdata = popupdata.replace("<liferay-ui:message key="trainee-site" />","<b>"+rotationTrainingSiteName+"</b>");
				$(".popup-alert-message").html(popupdata);
				$(".popup-alert-button").empty();
				$(".popup-alert-button").html(`<liferay-ui:message key="cancel" />`);
				$("#alertPopup").modal("show");
        }else{
			if(leave == parseInt(ev.currentTarget.dataset.block)){
				$(".popup-alert-title").empty();
				$(".popup-alert-title").html(`<liferay-ui:message key="leave-alert" />`);
				$(".popup-alert-message").empty();
				$(".popup-alert-message").html(`<liferay-ui:message key="leave-exists" />`);
				$(".popup-alert-button").empty();
				$(".popup-alert-button").html(`<liferay-ui:message key="back" />`);
				$("#alertPopup").modal("show");
			}else{
				let traineeBlocks = 0;
	            $.each(rotationtraineeBlock, function (index, item) {
	                const {rotationId , noOfBlocks } = item;
	                        if(rotationId === parseInt(rotationMasterId)){
	                            traineeBlocks = noOfBlocks;
	                        }
	            });
	            let count = 0;
	            $.each(rotationMasterRotationScheduleData, function (index, item) {
	                const {traineeId , rotationDetails } = item;
	                    $.each(rotationDetails, function (index, rotation) {
	                        if(traineeId === parseInt(ev.currentTarget.dataset.trainee) && rotation.rotationId === parseInt(dataId)){
	                            count++;
	                        }
	                    });
	            });
	
	            if(traineeBlocks<=count){
	                $(".popup-alert-title").empty();
	                $(".popup-alert-title").html(`<liferay-ui:message key="block-alert" />`);
	                $(".popup-alert-message").empty();
	                $(".popup-alert-message").html(`<liferay-ui:message key="remaining-block-not-available" />`);
	                $(".popup-alert-button").empty();
	                $(".popup-alert-button").html(`<liferay-ui:message key="back" />`);
	                $("#alertPopup").modal("show");
	            }else{
					let id = "";
					if (ev.target.id) {
						id = ev.target.id;
					} else {
						id = ev.target.parentElement.id;
					}
						if(!isRecordPresentForRotation(id, parseInt(ev.currentTarget.dataset.block), parseInt(ev.currentTarget.dataset.trainee), parseInt(dataId))) {
							
							let noOfTraineeBlocks = parseInt(noofslots);
	                        let totalTrainee = noOfTraineeBlocks*traineeTotalBlock;
	                        let length =0;
	                        $.each(rotationMasterRotationScheduleData, function (index, item) {
	                        	const {rotationDetails } = item;
	                            $.each(rotationDetails, function (index, rotation) {
	                                if(rotation.rotationId === parseInt(dataId)){
	                                    length += 1;
	                                }
	                            });
	                        });
	                        if(length == totalTrainee)
	                        {
	                             $(".popup-alert-title").empty();
	                             $(".popup-alert-title").html(`<liferay-ui:message key="trainee-limit-alert" />`);
	                             $(".popup-alert-message").empty();
	                             $(".popup-alert-message").html(`<liferay-ui:message key="trainee-limit-exceeds-alert" />`);
	                             $(".popup-alert-button").empty();
	                             $(".popup-alert-button").html(`<liferay-ui:message key="back" />`);
	                             $("#alertPopup").modal("show");
	                        }else{
	                        	let rotationList;
	    						elementID = document.getElementById(id);
	    						if (elementID.childNodes.length > 0) {
	    							rotationList = JSON.parse(elementID.childNodes[0].getAttribute("data-value"));
	    							if(rotationList == null){
	    								rotationList = [];
	    							}
	    						} else {
	    							rotationList = [];
	    						}
	    						
	    						var foundObject = rotationMasterRotationScheduleData.find(obj => obj.blockId === parseInt(ev.currentTarget.dataset.block) && obj.traineeId === parseInt(ev.currentTarget.dataset.trainee) && obj.rowId === id);
	    						if (foundObject) {
	    							  foundObject.rotationDetails.push({rotationId : parseInt(dataId),rotationName : data,rotationMasterId : parseInt(rotationMasterId)});
	    						}else{
	    							rotationMasterRotationScheduleData.push({
	    								"rowId" : id,
	    								"blockId" : parseInt(ev.currentTarget.dataset.block),
	    								"traineeId" : parseInt(ev.currentTarget.dataset.trainee),
	    								"rotationDetails" : [{rotationId : parseInt(dataId),rotationName : data,rotationMasterId : parseInt(rotationMasterId)}]
	    							});
	    						}
	    						rotationList = [...rotationList, { rotationName: data , rotationId: dataId}];
	    						cellItem(id, rotationList, data,dataId);
	                        }
							
						}else{
								$(".popup-alert-title").empty();
								$(".popup-alert-title").html(`<liferay-ui:message key="rotation-alert" />`);
								$(".popup-alert-message").empty();
								$(".popup-alert-message").html(`<liferay-ui:message key="rotation-already-exists" />`);
								$(".popup-alert-button").empty();
								$(".popup-alert-button").html(`<liferay-ui:message key="back" />`);
								$("#alertPopup").modal("show");
						}
					}
				}
		}
	}
}

function cellItem(id, rotationList, data,dataId) {
	elementID = document.getElementById(id);
	/* rotationtraineeBlock = document.getElementById('leavedata'); */
	let oldData = '';
	elementID.childNodes.forEach(function (item, index) {
	    if(item.classList.contains('omsb-al')){
	    	oldData += item.outerHTML;
	    }
	})
	elementID.innerHTML = "";
	let newData = "";
	if (rotationList.length) {
		if (rotationList.length > 1) {
			newData = `<span  data-value='\${JSON.stringify(rotationList)}'  class="omsb-complete-bg omsb-complete-bg-flex" data-id="\${dataId}">\${data}</span>
																<span onclick='rotationList(\${JSON.stringify(rotationList)}, "popup", \${id})'   class="omsb-complete-bg linktag">+\${rotationList.length - 1}`;
		} else {
			newData = `<span  data-value='\${JSON.stringify(rotationList)}'  class="omsb-complete-bg omsb-complete-bg-flex" data-id="\${dataId}">\${data}`;
			if(issharedRotation.toUpperCase() === "true".toUpperCase()){
				newData = newData +`<span class="s-icon shared-rotation">S</span>`;
			}
			newData = newData +`<a href="javascript:void(0)" onclick='removeItem(0, \${id}, \${dataId})' ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/table_reject.svg" alt=""></a>`
		}
		if(isElectiveRotation){
			newData = newData +`<span class="elective">E</span>`;
		}
		
		newData = newData +`</span>`;
	}
	elementID.innerHTML = newData + oldData;
}

function rotationList(parm1, parm2, parm3) {
	document.querySelector(".blockdetail_table table tbody").innerHTML = "";
	if (parm2 == "popup") {
		tempArray = [];
		tempRotationArray = parm1
	} else if (parm1 == 'singleItem') {
		tempRotationArray = [];
	}
	else {
		tempRotationArray = tempRotationArray.filter((item, index) => index != parm1);

	}
	let rotationList = '';
	let lastNameofrotation = '';
	let lastIdofrotation = '';
	tempRotationArray.forEach(function (item, index) {
		rotationList = `<tr>
								<td>\${item.rotationName}</td>
								<td><a href="javascript:void(0)" onclick='removeItem(\${index}, \${parm3.id}, \${item.rotationId})' ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/table_reject.svg" alt=""><liferay-ui:message key="remove" /></a></td>
							</tr>`;
		document.querySelector(".blockdetail_table table tbody").innerHTML += rotationList;
		if (tempRotationArray.length == index + 1) {
			lastNameofrotation = item.rotationName;
			lastIdofrotation = item.rotationId;
		}
	});
	if (parm2 == "popup") {
	    let blockId = parm3.dataset.block;
	    let traineeId = parm3.dataset.trainee;
	    let traineeName = $("#rotationRotationMasterTrainee"+traineeId).text();
	    let blockName = $("#rotationRotationMasterBlock"+blockId).text().split("(")[0];
		$(".block-detail-title").empty();
		$(".block-detail-title").html(traineeName+" "+blockName);
		$(".block-detail-header").empty();
		$(".block-detail-header").html(`<liferay-ui:message key='rotation-name' />`);
		$("#blockDetailListPopup").click();
	} else {
		cellItem(parm3.id, tempRotationArray, lastNameofrotation, lastIdofrotation)
	}
}

function removeItem(dataIndex, parm3, rotationId) {
	isChanged = true;
	let blockId = parm3.getAttribute("data-block");
    let traineeId = parm3.getAttribute("data-trainee");
    removerotationDetails(blockId, traineeId, rotationId);
	rotationList(dataIndex, "nonpopup", parm3);
}

function removeBlockItem(dataIndex, parm3, rotationId,traineeId) {
	isChanged = true;
	var foundObject = removeBlockData.find(obj => obj.dataIndex === dataIndex && obj.traineeId === traineeId && obj.blockId === parm3.getAttribute("data-block") && obj.rotationId === rotationId);
	if (!foundObject) {
		removeBlockData.push({
			"dataIndex" : dataIndex,
			"blockId" : parm3.getAttribute("data-block"),
			"parm3" : parm3,
			"rotationId" : rotationId,
			"traineeId" : traineeId
		})
		
		if(event.currentTarget.parentElement.parentElement.childElementCount > 1){
			event.currentTarget.parentElement.outerHTML = "";
		}else{
			event.currentTarget.parentElement.parentElement.parentElement.outerHTML = ""
		}
	}
	
}

function removeBlockItemOnSave() {
	isChanged = true;
	$.each(removeBlockData, function (index, item) {
		const { dataIndex, parm3,rotationId } = item;
		let blockId = parm3.getAttribute("data-block");
	    let traineeId = parm3.getAttribute("data-trainee");
	    removerotationDetails(blockId, traineeId, rotationId);
		rotationList(dataIndex, "nonpopup", parm3);
	});
	removeBlockData = [];
}

function removeBlockItemOnCancel(){
	removeBlockData = [];
}

function isRecordPresentForRotation(rowId, blockId, traineeId, rotationId) {
var foundObject = rotationMasterRotationScheduleData.find(obj => obj.blockId === parseInt(blockId) && obj.traineeId === parseInt(traineeId) && obj.rowId === rowId);
	if (foundObject) {
		if(parseInt(programMasterData) === 0){
			if(foundObject.rotationDetails.length === 0){
				return false;
			}else{
				return true;
			}
		}else{
			if(foundObject.rotationDetails.length <= 1){
				return rotationMasterRotationScheduleData.some(function (obj) {
					return (
						obj.blockId === blockId &&
						obj.traineeId === traineeId &&
						obj.rotationDetails.some(function (rotation) {
							return rotation.rotationId === rotationId;
						})
					);
				});
			}else{
				return true;
			}
		}
	}else{
		return false;
	}
}


function isRecordPresentForRotationWithSite(blockIdData, traineeIdData, rotationIdData,rotationMasterIdData) {
	var isRotationPresentInTrainingSite = rotationIdData;
	$.each(rotationMasterRotationScheduleData, function (index, item) {
		const {traineeId , rotationDetails } = item;
			$.each(rotationDetails, function (index, rotation) {
				if(traineeId === traineeIdData && rotation.rotationMasterId == rotationMasterIdData){
					if(rotation.rotationId != rotationIdData){
						isRotationPresentInTrainingSite = rotation.rotationId;
					}
				}

			});
	});
	return isRotationPresentInTrainingSite;
}

function removerotationDetails(blockId, traineeId, rotationId) {
	let jsonObject = rotationMasterRotationScheduleData.find(obj => obj.blockId === parseInt(blockId) && obj.traineeId === parseInt(traineeId));	
	if (jsonObject) {
		jsonObject.rotationDetails = jsonObject.rotationDetails.filter(function(obj) {
			return obj.rotationId !== rotationId;
		});
	}
}

function leaveDetails(data){
	document.querySelector(".blockdetail_table table tbody").innerHTML = "";
	let traineeList = '';
	let blockName = '';
	data.forEach(function (item, index) {
	let blockId = item.blockId;
	blockName = $("#traineeRotationMasterblock"+item.blockId).text().split("(")[0];
	traineeList = traineeList + `<tr>
								<td>\${item.traineeName}</td><td>\${item.leaveTypeName}</td><td>\${item.leaveStartDate}</td><td>\${item.leaveEndDate}</td>
								<td><a href="javascript:void(0)" onclick="traineeremoveLeaveItemByRotation(\${item.leaveMasterId},\${item.rowId})" ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/table_reject.svg" alt=""><liferay-ui:message key="remove" /></a></td>
							</tr>`;
	});	
	document.querySelector(".blockdetail_table table tbody").innerHTML = traineeList;
	let rotationName = "Leave";
    blockName = blockName.charAt(0).toUpperCase() + blockName.slice(1);
	$(".trainee-detail-title").empty();
	$(".trainee-detail-title").html(blockName + " ");
	$(".blockdetail_table table tbody").empty();
	$(".blockdetail_table table tbody").html(traineeList);
	$("#traineeleavedetails").modal("show");
}

/* rotation code end */
 
function saveTraineeLeave(){
	
	 let programMasterId = $("#<portlet:namespace/>programMasterId").val();
	 let progdurationTlBlocksLtId = $("#<portlet:namespace/>progdurationTlBlocksLtId").val();
	 let startDateValue = $("#<portlet:namespace/>startDateValue").val();
	 let endDateValue = $("#<portlet:namespace/>endDateValue").val();
	 let traineeId = $("#<portlet:namespace/>traineeId").val();
	 let leaveType = $("#<portlet:namespace/>leaveType").val();
	 let blockId = $("#<portlet:namespace/>blockId").val();
	 $.ajax({
			url : '<%=saveTraineeLeave%>',
			type : 'POST',
			data : {
				<portlet:namespace/>programMasterId : programMasterId,
				<portlet:namespace/>progdurationTlBlocksLtId : progdurationTlBlocksLtId,
				<portlet:namespace/>startDateValue : startDateValue,
				<portlet:namespace/>endDateValue : endDateValue,
				<portlet:namespace/>traineeId : traineeId,
				<portlet:namespace/>leaveType : leaveType,
				<portlet:namespace/>blockId : blockId
			},
			success : function(data) {
				if(data.success != "success"){
					$(".popup-alert-title-leave").empty();
					$(".popup-alert-title-leave").html(`<liferay-ui:message key="save-alert" />`);
					addLeaveMessage(data.result);
					$(".popup-alert-button-leave").empty();
					$(".popup-alert-button-leave").html(`<liferay-ui:message key="back" />`);
					$("#applyleave").modal("hide");
					$("#alertPopupForLeave").modal("show");
				} else {
					let TraineeDetailsWithBlocksDTO = JSON.parse(data.result);
					 var startRotationD = TraineeDetailsWithBlocksDTO.fromDate;
		             var endRotationD = TraineeDetailsWithBlocksDTO.toDate;
		             var newRotationDate = new Date(startRotationD);
		             var newRotationEndDate = new Date(endRotationD);
		             var getRotationYear = newRotationDate.toLocaleString("default", { year: "numeric" });
		             var getRotationMonth = newRotationDate.toLocaleString("default", { month: "2-digit" });
		             var getRotationDay = newRotationDate.toLocaleString("default", { day: "2-digit" });
		             var getRotationEndYear = newRotationEndDate.toLocaleString("default", { year: "numeric" });
		             var getRotationEndMonth = newRotationEndDate.toLocaleString("default", { month: "2-digit" });
		             var getRotationEndDay = newRotationEndDate.toLocaleString("default", { day: "2-digit" });
		             var leaveStartDate = getRotationDay + "-" + getRotationMonth + "-" + getRotationYear;
		             var leaveEndDate = getRotationEndDay + "-" + getRotationEndMonth + "-" + getRotationEndYear;
					if(saveleaveType.toUpperCase() === "trainee".toUpperCase()){
	                    let elementID = document.getElementById(leaveDataId);
	                    let traineeList = [];
	                    if (elementID.childNodes.length > 0) {
	                        traineeList = JSON.parse(elementID.childNodes[0].getAttribute("data-value"));
	                    }
	                    traineeList = [...traineeList, { traineeId: TraineeDetailsWithBlocksDTO.traineeId, traineeName: TraineeDetailsWithBlocksDTO.traineeName,leaveTypeName:TraineeDetailsWithBlocksDTO.leaveTypeName,
	                    	leaveStartDate:leaveStartDate,leaveEndDate:leaveEndDate,leaveMasterId:TraineeDetailsWithBlocksDTO.leaveMasterId}];
	                    traineeleavecellItem(leaveDataId, traineeList, TraineeDetailsWithBlocksDTO.traineeName, TraineeDetailsWithBlocksDTO.traineeId);
						leaveDataId = "";
					}else{
	                    let elementID = document.getElementById(leaveDataId);
	                    let blockNo = "";
	                    var foundObject = blocksMetadataDetailsRelsData.find(obj => obj.blocksMetadataDetailsRelId === parseInt(elementID.getAttribute("data-block")));
						if (foundObject) {
							blockNo = foundObject.blockNo;
						}
	                    let olddata = elementID.innerHTML;
	                    elementID.innerHTML = "";
			             let leaveData = {
			            		 	"rowId" : leaveDataId,
									"traineeName" : TraineeDetailsWithBlocksDTO.traineeName,
			        				"leaveTypeName" : TraineeDetailsWithBlocksDTO.leaveTypeName,
			        				"leaveStartDate" : leaveStartDate,
			        				"leaveEndDate" : leaveEndDate,
			        				"traineeId" : parseInt(TraineeDetailsWithBlocksDTO.traineeId),
			        				"blockNo" : blockNo,
			        				"blockId" : parseInt(elementID.getAttribute("data-block")),
			        				"leaveMasterId" : parseInt(TraineeDetailsWithBlocksDTO.leaveMasterId)
			        	}
			             leaveMaterDataForRotation.push(leaveData)
		        		 let leaveDetailData = [];
			             leaveDetailData.push(leaveData)
			             olddata = olddata + "<span onclick='leaveDetails("+JSON.stringify(leaveDetailData)+")' id='leave_"+TraineeDetailsWithBlocksDTO.leaveMasterId+"' class='omsb-al linktag'>";
                        if(TraineeDetailsWithBlocksDTO.leaveType.toUpperCase() === "AL".toUpperCase()){
                        	olddata = olddata + "<img src='<%=themeDisplay.getPathThemeImages()%>/svg/al.svg' alt=''>"
                        }else if(TraineeDetailsWithBlocksDTO.leaveType.toUpperCase() === "SKL".toUpperCase()){
                        	olddata = olddata + "<img src='<%=themeDisplay.getPathThemeImages()%>/svg/sl.svg' alt=''>"
                        }else if(TraineeDetailsWithBlocksDTO.leaveType.toUpperCase() === "EML".toUpperCase()){
                        	olddata = olddata + "<img src='<%=themeDisplay.getPathThemeImages()%>/svg/el.svg' alt=''>"
                        }else if(TraineeDetailsWithBlocksDTO.leaveType.toUpperCase() === "SCL".toUpperCase()){
                        	olddata = olddata + "<img src='<%=themeDisplay.getPathThemeImages()%>/svg/sci-l.svg' alt=''>"
                        }else if(TraineeDetailsWithBlocksDTO.leaveType.toUpperCase() === "MTL".toUpperCase()){
                        	olddata = olddata + "<img src='<%=themeDisplay.getPathThemeImages()%>/svg/ml.svg' alt=''>"
                        }else{
                        	olddata = olddata + "<img src='<%=themeDisplay.getPathThemeImages()%>/svg/cl.svg' alt=''>"
                        }
                        olddata = olddata+ "&nbsp;" +TraineeDetailsWithBlocksDTO.leaveType+"</span>";
                        elementID.innerHTML = olddata;
                        leaveDataId = "";
					}

					$("#applyleave").modal("hide");
					$("#saveLeaveSucessModal").modal("show");
				}
				
			}
	 });
}

function addLeaveMessage(data){
	if(data.toUpperCase() == "please-select-appropriate-end-date".toUpperCase()){
		$(".popup-alert-message-leave").empty();
		$(".popup-alert-message-leave").html(`<liferay-ui:message key="please-select-appropriate-end-date" />`);
	}	else if(data.toUpperCase() == "leaves-not-remaining".toUpperCase()){
		$(".popup-alert-message-leave").empty();
		$(".popup-alert-message-leave").html(`<liferay-ui:message key="leaves-not-remaining" />`);
	}else if(data.toUpperCase() == "not-allowed-to-take-leaves".toUpperCase()){
		$(".popup-alert-message-leave").empty();
		$(".popup-alert-message-leave").html(`<liferay-ui:message key="not-allowed-to-take-leaves" />`);
	}else if(data.toUpperCase() == "maximum-trainees-already-applied".toUpperCase()){
		$(".popup-alert-message-leave").empty();
		$(".popup-alert-message-leave").html(`<liferay-ui:message key="maximum-trainees-already-applied" />`);
	}else if(data.toUpperCase() == "leaves-available-at-block-level".toUpperCase()){
		$(".popup-alert-message-leave").empty();
		$(".popup-alert-message-leave").html(`<liferay-ui:message key="leaves-available-at-block-level" />`);
	}else if(data.toUpperCase() == "leaves-available-at-block-week-level".toUpperCase()){
		$(".popup-alert-message-leave").empty();
		$(".popup-alert-message-leave").html(`<liferay-ui:message key="leaves-available-at-block-week-level" />`);
	}else if(data.toUpperCase() == "violating-attendance-criteria".toUpperCase()){
		$(".popup-alert-message-leave").empty();
		$(".popup-alert-message-leave").html(`<liferay-ui:message key="violating-attendance-criteria" />`);
	}else if(data.toUpperCase() == "less-days-configured".toUpperCase()){
		$(".popup-alert-message-leave").empty();
		$(".popup-alert-message-leave").html(`<liferay-ui:message key="less-days-configured" />`);
	}
	
}

/* faculty code start */

function dragFaculty(ev) {
	isChanged = true;
	ev.dataTransfer.setData("facultyId", ev.target.dataset.id);
	ev.dataTransfer.setData("facultyName", ev.target.innerText);
	ev.dataTransfer.setData("drageeventData", "facultydrag");

}

function dropFaculty(ev, isCreate) {
	ev.preventDefault();
	let dataId;
	let data;
	let blockId;
	let rotationId;
	let id;
	let facultyavailableonblock = false;
	if(isCreate) {
		isChanged = true;
		dataId = parseInt(ev.dataTransfer.getData("facultyId"));
		data = ev.dataTransfer.getData("facultyName");
		blockId = parseInt(ev.currentTarget.dataset.block);
		rotationId = parseInt(ev.currentTarget.dataset.rotation);
		if (ev.target.id) {
			id = ev.target.id;
		} else {
			id = ev.target.parentElement.id;
		}
		if(isFacultyAvailableOnSameBlock(parseInt(ev.currentTarget.dataset.block), parseInt(ev.currentTarget.dataset.rotation), parseInt(dataId))){
			facultyavailableonblock = true;
		}
	} else {
		dataId = parseInt(ev.detail.dataTransfer.facultyId);
		data = ev.detail.dataTransfer.facultyName;
		blockId = parseInt(ev.detail.currentTarget.dataset.block);
		rotationId = parseInt(ev.detail.currentTarget.dataset.rotation);
		id = ev.detail.target.id;
	}
	if(facultyavailableonblock)	{
		$(".popup-alert-title").empty();
        $(".popup-alert-title").html(`<liferay-ui:message key="block-alert" />`);
        $(".popup-alert-message").empty();
        $(".popup-alert-message").html(`<liferay-ui:message key="faculty-exists-in-same-block" />`);
        $(".popup-alert-button").empty();
        $(".popup-alert-button").html(`<liferay-ui:message key="back" />`);
        $("#alertPopup").modal("show");
	}else{
		if(!isRecordPresentForFaculty(blockId, rotationId, dataId)) {
			let facultyList;
			elementID = document.getElementById(id);
			if (elementID.childNodes.length > 0) {
				facultyList = JSON.parse(elementID.childNodes[0].getAttribute("data-value"));
			} else {
				facultyList = [];
			}
			var foundObject = facultyMasterRotationScheduleData.find(obj => obj.blockId === blockId && obj.rotationId === rotationId);
			if (foundObject) {
				  foundObject.facultyDetails.push({facultyId: dataId, facultyName: data});
			}
			facultyList = [...facultyList, { facultyName: data, facultyId: dataId }];
			cellItemFaculty(id, facultyList, data, dataId);
		} else {
			$(".popup-alert-title").empty();
			$(".popup-alert-title").html(`<liferay-ui:message key="faculty-alert" />`);
			$(".popup-alert-message").empty();
			$(".popup-alert-message").html(data +` <liferay-ui:message key="faculty-already-assigned" />`);
			$(".popup-alert-button").empty();
			$(".popup-alert-button").html(`<liferay-ui:message key="back" />`);
			$("#alertPopup").modal("show");
		}
	}
}

function cellItemFaculty(id, facultyList, data, dataId) {
	elementID = document.getElementById(id);
	elementID.innerHTML = "";
	if (facultyList.length) {
		if (facultyList.length > 1) {
			elementID.innerHTML = `<span  data-value='\${JSON.stringify(facultyList)}'  class="omsb-initiated-bg omsb-complete-bg-flex" data-id="\${dataId}">\${data}</span>
																<span onclick='facultyList(\${JSON.stringify(facultyList)}, "popup", \${id},\"faculty\")'   class="omsb-initiated-bg linktag">+\${facultyList.length - 1}</span>`;
		} else {
			elementID.innerHTML = `<span  data-value='\${JSON.stringify(facultyList)}'  class="omsb-initiated-bg omsb-complete-bg-flex" data-id="\${dataId}">\${data} <a href="javascript:void(0)" onclick='removeFacultyItem("singleItem","faculty", \${id}, \${dataId})' ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/table_reject.svg" alt=""></a></span>`;
		}
	}
}

function facultyList(parm1, parm2, parm3, parm4) {
	document.querySelector(".blockdetail_table table tbody").innerHTML = "";
	if (parm2 == "popup") {
		tempFacultyArray = [];
		tempFacultyArray = parm1
	} else if (parm1 == 'singleItem') {
		tempFacultyArray = [];
	}
	else {
		tempFacultyArray = tempFacultyArray.filter((item, index) => index != parm1);

	}
	let facultyList = '';
	let lastNameOfFaculty = '';
	let lastIdOfFaculty = '';
	tempFacultyArray.forEach(function (item, index) {
		facultyList = `<tr>
								<td>\${item.facultyName}</td>
								<td><a href="javascript:void(0)" onclick='removeFacultyItem(\${index},"\${parm4}", \${parm3.id}, \${item.facultyId})' ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/table_reject.svg" alt=""><liferay-ui:message key="remove" /></a></td>
							</tr>`;
		document.querySelector(".blockdetail_table table tbody").innerHTML += facultyList;
		if (tempFacultyArray.length == index + 1) {
			lastNameOfFaculty = item.facultyName;
			lastIdOfFaculty = item.facultyId;
		}
	});
	if (parm2 == "popup") {
	    let blockId = parm3.dataset.block;
	    let rotationId = parm3.dataset.rotation;
	    let rotationName = $("#facultyRotationMaster"+rotationId).text();
	    let blockName = $("#facultyBlockMaster"+blockId).text();
		$(".block-detail-title").empty();
		$(".block-detail-title").html(rotationName+" "+blockName);
		$(".block-detail-header").empty();
		$(".block-detail-header").html(`<liferay-ui:message key='faculty-name' />`);
		$("#blockDetailListPopup").click();
	} else {
		 if(parm4.toUpperCase() === "traineeFaculty".toUpperCase()){
	        	let traineeList;
	        	if (parm3.childNodes.length > 0) {
	        		traineeList = JSON.parse(parm3.childNodes[0].getAttribute("data-value"));
				} else {
					traineeList = [];
				}
				traineeFacultycellItem(parm3.id,traineeList,tempFacultyArray);
	      }else{
	    		cellItemFaculty(parm3.id, tempFacultyArray, lastNameOfFaculty, lastIdOfFaculty)
	      }
	}
}

function removeFacultyItem(dataIndex,traineeFaculty, parm3, facultyId) {
	isChanged = true;
    let blockId = parm3.getAttribute("data-block");
    let rotationId = parm3.getAttribute("data-rotation");
    removeFacultyDetails(blockId, rotationId, facultyId);
	facultyList(dataIndex, "nonpopup", parm3,traineeFaculty);
}

function isRecordPresentForFaculty(blockId, rotationId, facultyId) {
	return facultyMasterRotationScheduleData.some(function (obj) {
		return (
			obj.blockId === blockId &&
			obj.rotationId === rotationId &&
			obj.facultyDetails.some(function (faculty) {
				return faculty.facultyId === facultyId;
			})
		);
	});
}

function isFacultyAvailableOnSameBlock(blockIddata, rotationId, facultyId) {
	if(parseInt(programMasterData) === 0){
		return facultyMasterRotationScheduleData.some(function (obj) {
			return (
				obj.blockId === blockIddata && obj.progCodeRsnSiteCode !== "leave".toUpperCase() &&
				obj.facultyDetails.some(function (faculty) {
					return faculty.facultyId === facultyId;
				})
			);
		});
	}else{
		let count = 0;
		$.each(facultyMasterRotationScheduleData, function (index, item) {
			const {blockId , facultyDetails,progCodeRsnSiteCode } = item;
				$.each(facultyDetails, function (index, faculty) {
					if(blockId === blockIddata && faculty.facultyId === facultyId && progCodeRsnSiteCode !== "leave".toUpperCase()){
						count++;
					}

				});
		});
		if (count === 2) {
			return true;
		}else{
			return false;
		}
	}
}

function removeFacultyDetails(blockId, rotationId, facultyId) {
	let jsonObject = facultyMasterRotationScheduleData.find(obj => obj.blockId === parseInt(blockId) && obj.rotationId === parseInt(rotationId));	
	if (jsonObject) {
		jsonObject.facultyDetails = jsonObject.facultyDetails.filter(function(obj) {
			return obj.facultyId !== facultyId;
		});
	}
}

$(".save-faculty-master-rotation-schedule").on("click", function() {
	if(! !!$(this).data("draft")){
		saveFacultyMasterRotationScheduleData(false, facultyMasterRotationScheduleData, "<%=saveFacultyMasterRotationSchedule%>",false);
	} else {
		saveFacultyMasterRotationScheduleData(true, facultyMasterRotationScheduleData, "<%=saveFacultyMasterRotationSchedule%>",true);
	}
})

$(".save-trainee-faculty-master-rotation-schedule").on("click", function() {
	if(! !!$(this).data("draft")){
		$(".confirmation-title").empty();
		$("#confirmationModal").removeAttr("data-name");
		$("#confirmationModal").removeAttr("data-value");
		$("#confirmationModal").data("name", "submit");
		$("#confirmationModal").data("value", "trainee-faculty");
		$(".confirmation-title").html(`<liferay-ui:message key='master-schedule-confirm-submit'/>`);
		$("#confirmationModal").modal("show");
	} else {
		let programMasterId = $("#<portlet:namespace/>programMasterId").val();
	    let progdurationTlBlocksLtId = $("#<portlet:namespace/>progdurationTlBlocksLtId").val();
		$.ajax({
			url : "<%=saveTraineeMasterRotationSchedule%>",
			type : 'POST',
			data : {
				<portlet:namespace/>isDraft : true,
				<portlet:namespace/>traineeMasterRotationScheduleData : JSON.stringify(traineeMasterRotationScheduleData),
				<portlet:namespace/>programMasterId : programMasterId,
				<portlet:namespace/>progdurationTlBlocksLtId : progdurationTlBlocksLtId,
				<portlet:namespace/>isFaculty : true
			},
			success : function(data) {
				isChanged = false;
				let jsondata = JSON.parse(data);
				if(!jsondata){
					$(".popup-alert-title").empty();
					$(".popup-alert-title").html(`<liferay-ui:message key="trainee-alert" />`);
					$(".popup-alert-message").empty();
					$(".popup-alert-message").html(`<liferay-ui:message key="scheduled-data-issue" />`);
					$(".popup-alert-button").empty();
					$(".popup-alert-button").html(`<liferay-ui:message key="back" />`);
					$("#alertPopup").modal("show");
				} else {
					$.ajax({
						url : "<%=saveFacultyMasterRotationSchedule%>",
						type : 'POST',
						data : {
							<portlet:namespace/>isDraft : true,
							<portlet:namespace/>facultyMasterRotationScheduleData : JSON.stringify(facultyMasterRotationScheduleData),
							<portlet:namespace/>programMasterId : programMasterId,
							<portlet:namespace/>progdurationTlBlocksLtId : progdurationTlBlocksLtId,
							<portlet:namespace/>isValidate : true
						},
						success : function(data) {
							if (data.success) {
								$("#saveAsDraftSuccessModal").modal("show");
							} else {
								$(".popup-alert-title").empty();
								$(".popup-alert-title").html(`<liferay-ui:message key="alert" />`);
								$(".popup-alert-message").empty();
								$(".popup-alert-message").html(`<liferay-ui:message key="something-went-wrong" />`);
								$(".popup-alert-button").empty();
								$(".popup-alert-button").html(`<liferay-ui:message key="ok" />`);
								$("#alertPopup").modal("show");
							}
						}
					});
				}
			}
		});
	}
})

$(".save-trainee-master-rotation-schedule").on("click", function() {
	if(! !!$(this).data("draft")){
		$(".confirmation-title").empty();
		$("#confirmationModal").removeAttr("data-name");
		$("#confirmationModal").removeAttr("data-value");
		$("#confirmationModal").data("name", "submit");
		$("#confirmationModal").data("value", "trainee");
		$(".confirmation-title").html(`<liferay-ui:message key='master-schedule-confirm-submit'/>`);
		$("#confirmationModal").modal("show");
	} else {
		saveTraineeMasterRotationScheduleData(true, traineeMasterRotationScheduleData, "<%=saveTraineeMasterRotationSchedule%>");
	}
})

$(".save-rotation-master-rotation-schedule").on("click", function() {
	if(! !!$(this).data("draft")){
		$(".confirmation-title").empty();
		$("#confirmationModal").removeAttr("data-name");
		$("#confirmationModal").removeAttr("data-value");
		$("#confirmationModal").data("name", "submit");
		$("#confirmationModal").data("value", "rotation");
		$(".confirmation-title").html(`<liferay-ui:message key='master-schedule-confirm-submit'/>`);
		$("#confirmationModal").modal("show");
	} else {
		saveRotationMasterRotationScheduleData(true, rotationMasterRotationScheduleData, "<%=saveRotationMasterRotationSchedule%>");
	}
})

$("#pills-faculty-tab").on("click", function() {
	$(".pagetitle").empty();
	$(".pagetitle").html(`<liferay-ui:message key="master-rotation-by-faculty" />`);
	isChanged = false;
	byFacultyGetFacultyList(${programMasterId}, "<%=getFacultyForMasterRotationSchedule%>");
	byFacultyGetTableHeaderAndData(${progdurationTlBlocksLtId}, ${programMasterId}, "<%=getDataByFacultyForMasterRotationSchedule%>");
	facultyMasterRotationScheduleData = [];
	tempFacultyArray = [];
	
})

function saveFacultyMasterRotationScheduleData(isDraft, facultyMasterRotationScheduleData, saveFacultyMasterRotationScheduleURL,isValidate) {
	let programMasterId = $("#<portlet:namespace/>programMasterId").val();
    let progdurationTlBlocksLtId = $("#<portlet:namespace/>progdurationTlBlocksLtId").val();
	$.ajax({
		url : saveFacultyMasterRotationScheduleURL,
		type : 'POST',
		data : {
			<portlet:namespace/>isDraft : isDraft,
			<portlet:namespace/>facultyMasterRotationScheduleData : JSON.stringify(facultyMasterRotationScheduleData),
			<portlet:namespace/>programMasterId : programMasterId,
			<portlet:namespace/>progdurationTlBlocksLtId : progdurationTlBlocksLtId,
			<portlet:namespace/>isValidate : isValidate
		},
		success : function(data) {
			isChanged = false;
			if (!isValidate && data.success) {
				$(".confirmation-title").empty();
				$("#confirmationModal").removeAttr("data-name");
				$("#confirmationModal").removeAttr("data-value");
				$("#confirmationModal").data("name", "submit");
				$("#confirmationModal").data("value", "faculty");
				$(".confirmation-title").html(`<liferay-ui:message key='master-schedule-confirm-submit'/>`);
				$("#confirmationModal").modal("show");
			} else if(isValidate && data.success) {
				$(".popup-alert-title").empty();
				$(".popup-alert-title").html(`<liferay-ui:message key="success" />`);
				$(".popup-alert-message").empty();
				$(".popup-alert-message").html(`<liferay-ui:message key="faculty-rotation-schedule-save" />`);
				$(".popup-alert-button").empty();
				$(".popup-alert-button").html(`<liferay-ui:message key="ok" />`);
				$("#alertPopup").modal("show");
			}else if(!isValidate && !data.success) {
				$(".confirmation-title").empty();
				$("#confirmationModal").removeAttr("data-name");
				$("#confirmationModal").removeAttr("data-value");
				$("#confirmationModal").data("name", "submit");
				$("#confirmationModal").data("value", "facultyissue");
				$(".confirmation-title").html(`<liferay-ui:message key='faculty-assign-block-data-issue'/>`);
				$("#confirmationModal").modal("show");
			}else{
				$(".popup-alert-title").empty();
				$(".popup-alert-title").html(`<liferay-ui:message key="alert" />`);
				$(".popup-alert-message").empty();
				$(".popup-alert-message").html(`<liferay-ui:message key="something-went-wrong" />`);
				$(".popup-alert-button").empty();
				$(".popup-alert-button").html(`<liferay-ui:message key="ok" />`);
				$("#alertPopup").modal("show");
			}
		}
	});
}

function byFacultyGetFacultyList(programMasterId, getFacultyForMasterRotationScheduleURL){
	$.ajax({
		url: getFacultyForMasterRotationScheduleURL,
		type: 'POST',
		data: {
			<portlet:namespace/>programMasterId : programMasterId
		},
		success: function(data)	{
			isChanged = false;
			$('#rotation-by-faculty-side tbody').empty();
			if (data.success) {
				var facultyList = "";
				$.each(data.result, function(key, value) {
					facultyList += "<tr><td class='faculty-details' data-value='"+value+"' data-id='"+key+"'><div class='draggable-wrap'><img src='<%=themeDisplay.getPathThemeImages()%>/svg/drag-icon.svg' alt='drag'><div draggable='true' ondragstart='dragFaculty(event)' class='drag-rotation-item linktag' data-id='"+key+"'>"+value+"</div></div></td></tr>";
				});
				$('#rotation-by-faculty-side tbody').append(facultyList);
			}
		}
	});
}

function byFacultyGetTableHeaderAndData(progdurationTlBlocksLtId, programMasterId, getHeaderDataURL){
    $.ajax({
        url: getHeaderDataURL,
        type: 'POST',
        data: {
			<portlet:namespace/>progdurationTlBlocksLtId : progdurationTlBlocksLtId,
			<portlet:namespace/>programMasterId : programMasterId
        },
        success: function(data) {
			isChanged = false;
            $('#rotation-by-faculty-master thead tr').children(':gt(0)').remove();
            $("#rotation-by-faculty-master tbody").empty();
            
            let jsondata = JSON.parse(data);
			let trainingSiteByRotationsDTOs= jsondata.trainingSiteByRotationsDTOs;
			let blocksMetadataDetailsRels= jsondata.blocksMetadataDetailsRels;
			let saveFacultyMasterRotationScheduleDTOs= jsondata.saveFacultyMasterRotationScheduleDTOs;
			var blockLength = blocksMetadataDetailsRels.length;
			
            for(let i=0; i<blockLength; i++) {
            	 	var startFacultyD = blocksMetadataDetailsRels[i].blockStartDate;
	                var endFacultyD = blocksMetadataDetailsRels[i].blockEndDate;
	                var newFacultyDate = new Date(startFacultyD);
	                var newFacultyEndDate = new Date(endFacultyD);
	                var getFacultyYear = newFacultyDate.toLocaleString("default", { year: "numeric" });
	                var getFacultyMonth = newFacultyDate.toLocaleString("default", { month: "2-digit" });
	                var getFacultyDay = newFacultyDate.toLocaleString("default", { day: "2-digit" });
	                var getFacultyEndYear = newFacultyEndDate.toLocaleString("default", { year: "numeric" });
	                var getFacultyEndMonth = newFacultyEndDate.toLocaleString("default", { month: "2-digit" });
	                var getFacultyEndDay = newFacultyEndDate.toLocaleString("default", { day: "2-digit" });
	                var blockFacultyStartDate = getFacultyDay + "-" + getFacultyMonth + "-" + getFacultyYear;
	                var blockFacultyEndDate = getFacultyEndDay + "-" + getFacultyEndMonth + "-" + getFacultyEndYear;
            	$('#rotation-by-faculty-master thead tr').append("<th id='facultyBlockMaster"+blocksMetadataDetailsRels[i].blocksMetadataDetailsRelId+"'>"+blocksMetadataDetailsRels[i].blockNo+"<br/> ("+blockFacultyStartDate+" to "+blockFacultyEndDate+")</th>");
            }
            
            for(let i=0; i<trainingSiteByRotationsDTOs.length; i++) {
				var dataRow = "";
            	dataRow += "<tr><td><label id='facultyRotationMaster"+trainingSiteByRotationsDTOs[i].progDurationRotationTsRelId+"'>"+ trainingSiteByRotationsDTOs[i].progCodeRsnSiteCode +"</label><span> ("+trainingSiteByRotationsDTOs[i].noOfslots+")</span></td>";
            	for(let j=0; j<blockLength; j++) {
            		dataRow += "<td id='faculty_row_"+blocksMetadataDetailsRels[j].blocksMetadataDetailsRelId+"_"+trainingSiteByRotationsDTOs[i].progDurationRotationTsRelId+"' data-rotation='"+trainingSiteByRotationsDTOs[i].progDurationRotationTsRelId+"' data-block='"+blocksMetadataDetailsRels[j].blocksMetadataDetailsRelId+"' ondrop='dropFaculty(event, true)' ondragover='allowDrop(event)'></td>";
            		facultyMasterRotationScheduleData.push({
        				"blockId" : parseInt(blocksMetadataDetailsRels[j].blocksMetadataDetailsRelId),
        				"rotationId" : parseInt(trainingSiteByRotationsDTOs[i].progDurationRotationTsRelId),
        				"facultyDetails" : []
        			})
            	}
            	dataRow += "</tr>";
				$("#rotation-by-faculty-master tbody").append(dataRow);
			}
            
            for(let i=0; i<saveFacultyMasterRotationScheduleDTOs.length; i++) {
            	for(let j=0; j<saveFacultyMasterRotationScheduleDTOs[i].facultyDetails.length; j++) {
            		let customEvent = new CustomEvent('myCustomEvent', {
            			detail: {
            				dataTransfer: {
            					facultyId: saveFacultyMasterRotationScheduleDTOs[i].facultyDetails[j].facultyId,
            					facultyName: saveFacultyMasterRotationScheduleDTOs[i].facultyDetails[j].facultyName
            				},
            				currentTarget: {
            					dataset: {
            						block: saveFacultyMasterRotationScheduleDTOs[i].blockId,
            						rotation: saveFacultyMasterRotationScheduleDTOs[i].rotationId
            					}
            				},
            				target: {
            					id: 'faculty_row_'+saveFacultyMasterRotationScheduleDTOs[i].blockId+'_'+saveFacultyMasterRotationScheduleDTOs[i].rotationId
            				}
            			}
            		});
            		
					dropFaculty(customEvent, false);
            	}
            }
            removeLoader();
        }
    });
}

$(document).on("click",".faculty-details", function(){
	$(".faculty-detail-title").empty();
	var facultyName = $(this).data('value')+'\'s ';
	$(".faculty-detail-title").html(facultyName);
	$(".blockdetail_table table tbody").empty();
	let rotationIdCount = {};
	var facultyIdToFind = $(this).data('id');
	$.each(facultyMasterRotationScheduleData, function (index, item) {
		const { rotationId, facultyDetails } = item;
		$.each(facultyDetails, function (index, faculty) {
			if (faculty.facultyId === facultyIdToFind) {
				rotationIdCount[rotationId] = (rotationIdCount[rotationId] || 0) + 1;
			}
		});
	});
	
	var facultycount = 0;
	$.each(rotationIdCount, function (rotationId, count) {
		var rotationName = $("#traineeRotationMasterrotation"+rotationId).text();
		if(rotationName === ""){
			rotationName = $("#traineeRotationMasterrotation"+rotationId).text();
		}
		$(".blockdetail_table table tbody").append("<tr><td>"+rotationName+"</td><td>"+count+"</td></tr>");
		facultycount++;
	});
	if(facultycount === 0){
		$(".popup-alert-title").empty();
		$(".popup-alert-title").html(`<liferay-ui:message key="no-data-alert" />`);
		$(".popup-alert-message").empty();
		$(".popup-alert-message").html(` <liferay-ui:message key="no-data-exists" />`);
		$(".popup-alert-button").empty();
		$(".popup-alert-button").html(`<liferay-ui:message key="back" />`);
		$("#alertPopup").modal("show");
	}else{
		$("#facultyassignment").modal("show");
	}
});

$(document).on("click",".trainee-details", function(){
	particularrotation=[];
	/* for(let i=0; i<trainingSiteByRotationsDTOsOuter.length; i++){
		if(trainingSiteByRotationsDTOsOuter[i].progCodeRsnSiteCode.toUpperCase() !== "leave".toUpperCase()){
			particularrotation.push({
				"rotationMasterId" : trainingSiteByRotationsDTOsOuter[i].rotationId,
				"rotationId" : trainingSiteByRotationsDTOsOuter[i].progDurationRotationTsRelId,
				"count" : 0
			})
		}
	} */
	$(".trainee-detail-title").empty();
	var traineeName = $(this).data('value')+'\'s ';
	$(".trainee-detail-title").html(traineeName);
	$(".blockdetail_table table tbody").empty();
	let rotationIdCount = {};
	var traineeIdToFind = $(this).data('id');
	
	var leave = $(this).data("leave");
	$.each(traineeMasterRotationScheduleData, function (index, item) {
		const { rotationId, traineeDetails,rotationMasterId,progCodeRsnSiteCode } = item;
		if(progCodeRsnSiteCode.toUpperCase() !== "leave".toUpperCase()){
			$.each(traineeDetails, function (index, trainee) {
				if (trainee.traineeId === traineeIdToFind) {
					var isElectiveRotation = false;
					var foundObject = particularrotation.find(obj => obj.rotationId === rotationId);
						if (foundObject) {
							  foundObject.count = foundObject.count + 1;
						}else{
							var electiveRotationObject = traineeElectiveRotationDTOs.find(obj => obj.rotationId === rotationMasterId && obj.traineeId === trainee.traineeId);
							if (electiveRotationObject) {
								 isElectiveRotation =  true;
							}
							if(isElectiveRotation){
								 particularrotation.push({
										"rotationMasterId" : rotationMasterId,
										"rotationId" :rotationId,
										"isElective" : true,
										"count" : 1
								 })
							}else{
								particularrotation.push({
									"rotationMasterId" : rotationMasterId,
									"rotationId" :rotationId,
									"isElective" : false,
									"count" : 1
								}) 
							}
						}
					}
			});
		}
	});

	if(particularrotation.length === 0){
		$(".popup-alert-title").empty();
		$(".popup-alert-title").html(`<liferay-ui:message key="no-data-alert" />`);
		$(".popup-alert-message").empty();
		$(".popup-alert-message").html(` <liferay-ui:message key="no-data-exists-trainee" />`);
		$(".popup-alert-button").empty();
		$(".popup-alert-button").html(`<liferay-ui:message key="back" />`);
		$("#alertPopup").modal("show");
	}else{
		$.each(particularrotation, function (index, item) {
			const {count,rotationMasterId,rotationId,isElective} = item;
		    let rotationName = $("#traineeRotationMasterrotation"+rotationId).text();
		    if(isElective){
		    	rotationName = rotationName + " E";
		    }
		    let noOfBlocks = 0;
		    for(let i=0; i<rotationtraineeBlock.length; i++){
		    	if (rotationMasterId === rotationtraineeBlock[i].rotationId) {
		    		noOfBlocks =  rotationtraineeBlock[i].noOfBlocks;
				}
		    }
		    let pendingdata= noOfBlocks - count;
			$(".blockdetail_table table tbody").append("<tr><td>"+rotationName+"</td><td>"+noOfBlocks+"</td><td>"+(count)+"</td><td>"+(pendingdata)+"</td></tr>");
		});
		$("#assignmentdetails").modal("show");
	}
});

$(document).on("click",".trainee-details-by-rotation", function(){
	particularrotation=[];
	/* for(let i=0; i<trainingSiteByRotationsDTOsOuter.length; i++){
		if(trainingSiteByRotationsDTOsOuter[i].progCodeRsnSiteCode.toUpperCase() !== "leave".toUpperCase()){
			particularrotation.push({
				"rotationMasterId" : trainingSiteByRotationsDTOsOuter[i].rotationId,
				"rotationId" : trainingSiteByRotationsDTOsOuter[i].progDurationRotationTsRelId,
				"count" : 0
			})
		}
	} */
	$(".trainee-detail-title").empty();
	var traineeName = $(this).data('value')+'\'s ';
	$(".trainee-detail-title").html(traineeName);
	$(".blockdetail_table table tbody").empty();
	let rotationIdCount = {};
	var traineeIdToFind = $(this).data('id');
	var leave = $(this).data("leave");
	$.each(rotationMasterRotationScheduleData, function (index, item) {
		const { traineeId, rotationDetails } = item;
    	if (traineeId === traineeIdToFind) {
			$.each(rotationDetails, function (index, rotation) {
				var isElectiveRotation = false;
				var foundObject = particularrotation.find(obj => obj.rotationId === rotation.rotationId);
				if (foundObject) {
					  foundObject.count = foundObject.count + 1;
				}else{
					var electiveRotationObject = traineeElectiveRotationDTOs.find(obj => obj.rotationId === rotation.rotationMasterId && obj.traineeId === traineeId);
					if (electiveRotationObject) {
						 isElectiveRotation =  true;
					}					
					if(isElectiveRotation){
						 particularrotation.push({
								"rotationMasterId" : rotation.rotationMasterId,
								"rotationId" : rotation.rotationId,
								"isElective" : true,
								"count" : 1
						})
					}else{
						particularrotation.push({
							"rotationMasterId" : rotation.rotationMasterId,
							"rotationId" : rotation.rotationId,
							"isElective" : false,
							"count" : 1
						})
					}
				}

			});
    	}
	});
	if(particularrotation.length === 0){
		$(".popup-alert-title").empty();
		$(".popup-alert-title").html(`<liferay-ui:message key="no-data-alert" />`);
		$(".popup-alert-message").empty();
		$(".popup-alert-message").html(` <liferay-ui:message key="no-data-exists-trainee" />`);
		$(".popup-alert-button").empty();
		$(".popup-alert-button").html(`<liferay-ui:message key="back" />`);
		$("#alertPopup").modal("show");
	}else{
		$.each(particularrotation, function (index, item) {
			const {count,rotationMasterId,rotationId,isElective} = item;
	
		    let rotationName = $("#rotationRotationMasterRotation"+rotationId).text();
		    if(isElective){
		    	rotationName = rotationName + " E";
		    }
		    let noOfBlocks = 0;
		    for(let i=0; i<rotationtraineeBlock.length; i++){
		    	if (rotationMasterId === rotationtraineeBlock[i].rotationId) {
		    		noOfBlocks =  rotationtraineeBlock[i].noOfBlocks;
				}
		    }
		    let pendingdata= noOfBlocks - count;
			$(".blockdetail_table table tbody").append("<tr><td>"+rotationName+"</td><td>"+noOfBlocks+"</td><td>"+(count)+"</td><td>"+(pendingdata)+"</td></tr>");
		});
		$("#assignmentdetails").modal("show");
	}
});

$(document).on("click",".rotation-details", function(){
	removeBlockData = [];
	particularrotation=[]
	$(".particularrotation-detail-title").empty();
	var rotationName = $(this).data('value');
	$(".particularrotation-detail-title").html(rotationName);
	$(".blockdetail_table table tbody").empty();
	let rotationIdCount = {};
	var rotationIdToFind = $(this).data('id');
	$.each(rotationMasterRotationScheduleData, function (index, item) {
		const { blockId , traineeId, rowId, rotationDetails } = item;
		$.each(rotationDetails, function (index, rotation) {
			if (rotation.rotationId === rotationIdToFind) {
				var foundObject = particularrotation.find(obj => obj.traineeId === traineeId);
				if (foundObject) {
					  foundObject.blockDetails.push({"blockId":blockId,"rowId" : rowId});
				}else{
				particularrotation.push({
					"traineeId" : traineeId,
					"rotationId" : rotation.rotationId,
					"blockDetails" : [{"blockId":blockId,"rowId" : rowId}]
				})
				}
				rotationIdCount[blockId] = (rotationIdCount[blockId]  ) + 1;
			}
		});
	});
	if(particularrotation.length === 0){
		$(".popup-alert-title").empty();
		$(".popup-alert-title").html(`<liferay-ui:message key="no-data-alert" />`);
		$(".popup-alert-message").empty();
		$(".popup-alert-message").html(` <liferay-ui:message key="no-data-exists-rotation" />`);
		$(".popup-alert-button").empty();
		$(".popup-alert-button").html(`<liferay-ui:message key="back" />`);
		$("#alertPopup").modal("show");
	}else{
		$.each(particularrotation, function (index, item) {
			var row = $("<tr>");
		   const { traineeId, rowId,  blockDetails,rotationId } = item;
		   let traineeName = $("#rotationRotationMasterTrainee"+traineeId).text();
		   let blockdata = "";
			rowdata = "<td>"+traineeName+"</td><td>";
			$.each(blockDetails, function (index, block) {
				   let blockName = $("#rotationRotationMasterBlock"+block.blockId).text().split("(")[0];
				   rowdata = rowdata +"<span class='badge badge-light'>	"+blockName.toUpperCase()+"<button onclick='removeBlockItem(0, "+block.rowId+","+rotationId+","+traineeId+")' type='button' class='close' aria-label='Dismiss'><img src='<%=themeDisplay.getPathThemeImages()%>/svg/badge_reject.svg' alt=''></button></span>"
			});
			rowdata = rowdata + "</td>";
			row.append(rowdata)
			$(".blockdetail_table table tbody").append(row);
		});
		$("#particularrotation").modal("show");
	}
});
		
$(document).on("click",".rotation-leave-details", function(){
	document.querySelector(".blockdetail_table table tbody").innerHTML = "";
	let traineeList = '';
	leaveMaterDataForRotation.forEach(function (item, index) {
	traineeList = traineeList + `<tr>
								<td>\${item.traineeName}</td><td>\${item.leaveTypeName}</td><td>\${item.leaveStartDate}</td><td>\${item.leaveEndDate}</td><td>\${item.blockNo}</td>
								<td><a href="javascript:void(0)" onclick="traineeremoveLeaveItemByRotation(\${item.leaveMasterId},\${item.rowId})" ><img src="<%=themeDisplay.getPathThemeImages()%>/svg/table_reject.svg" alt=""><liferay-ui:message key="remove" /></a></td>
							</tr>`;
	});	
	document.querySelector(".blockdetail_table table tbody").innerHTML = traineeList;
	let rotationName = "Leave";
	$(".trainee-detail-title").empty();
	$(".blockdetail_table table tbody").empty();
	$(".blockdetail_table table tbody").html(traineeList);
	$("#traineeleavedetailsrotations").modal("show");
});

function traineeremoveLeaveItemByRotation(leaveMasterId,rowId){
	let programMasterId = $("#<portlet:namespace/>programMasterId").val();
	$.ajax({
			url : '<%=deleteTraineeLeave%>',
			type : 'POST',
			data : {
				<portlet:namespace/>programMasterId : programMasterId,
				<portlet:namespace/>leaveMasterId : leaveMasterId,
			},
			success : function(data) {
				let jsondata = JSON.parse(data);
				if(!jsondata){
					$(".popup-alert-title").empty();
					$(".popup-alert-title").html(`<liferay-ui:message key="delete-alert" />`);
					$(".popup-alert-message").empty();
					$(".popup-alert-message").html(`<liferay-ui:message key="delete-data-issue" />`);
					$(".popup-alert-button").empty();
					$(".popup-alert-button").html(`<liferay-ui:message key="back" />`);
					$("#traineeleavedetailsrotations").modal("hide");
					$("#alertPopup").modal("show");
				} else {
	                 let newData = "";
	                 let leaveRemoveMasterId = "leave_"+leaveMasterId;
	                 rowId.childNodes.forEach(function (item, index) {
	                 if(item.classList.contains('omsb-al')){
	                	 if(item.id !== leaveRemoveMasterId){
		                	 newData += item.outerHTML;
	                	 }
	               		}else{
		                	 newData += item.outerHTML;
	               		}
	                })
	                 rowId.innerHTML = "";
	                 rowId.innerHTML = newData;
					$("#traineeleavedetails").modal("hide");
					$("#traineeleavedetailsrotations").modal("hide");
					$("#deleteLeaveSucessModal").modal("show");
				}
			}
	 });
}
/* facluty code end */
$(".confirmation-modal-faculty-confirm").on("click", function() {
	saveFacultyMasterRotationScheduleData(false, facultyMasterRotationScheduleData, "<%=saveFacultyMasterRotationSchedule%>",true);
});
$(".confirmation-modal-confirm").on("click", function() {
	if($("#confirmationModal").data("name") == "submit"){
		if($("#confirmationModal").data("value") == "trainee") {
			saveTraineeMasterRotationScheduleData(false, traineeMasterRotationScheduleData, "<%=saveTraineeMasterRotationSchedule%>");
		} else if($("#confirmationModal").data("value") == "rotation") {
			saveRotationMasterRotationScheduleData(false, rotationMasterRotationScheduleData, "<%=saveRotationMasterRotationSchedule%>");
		} else if($("#confirmationModal").data("value") == "faculty") {
			saveFacultyMasterRotationScheduleData(false, facultyMasterRotationScheduleData, "<%=saveFacultyMasterRotationSchedule%>",true);
		} else if($("#confirmationModal").data("value") == "facultyissue") {
			saveFacultyMasterRotationScheduleData(false, facultyMasterRotationScheduleData, "<%=saveFacultyMasterRotationSchedule%>",true);
		} else if($("#confirmationModal").data("value") == "trainee-faculty") {
			let programMasterId = $("#<portlet:namespace/>programMasterId").val();
		    let progdurationTlBlocksLtId = $("#<portlet:namespace/>progdurationTlBlocksLtId").val();
			$.ajax({
				url : "<%=saveTraineeMasterRotationSchedule%>",
				type : 'POST',
				data : {
					<portlet:namespace/>isDraft : false,
					<portlet:namespace/>traineeMasterRotationScheduleData : JSON.stringify(traineeMasterRotationScheduleData),
					<portlet:namespace/>programMasterId : programMasterId,
					<portlet:namespace/>progdurationTlBlocksLtId : progdurationTlBlocksLtId,
					<portlet:namespace/>isFaculty : true
				},
				success : function(data) {
					isChanged = false;
					let jsondata = JSON.parse(data);
					if(!jsondata){
						$(".popup-alert-title").empty();
						$(".popup-alert-title").html(`<liferay-ui:message key="trainee-alert" />`);
						$(".popup-alert-message").empty();
						$(".popup-alert-message").html(`<liferay-ui:message key="scheduled-data-issue" />`);
						$(".popup-alert-button").empty();
						$(".popup-alert-button").html(`<liferay-ui:message key="back" />`);
						$("#alertPopup").modal("show");
					} else {
						$.ajax({
							url : "<%=saveFacultyMasterRotationSchedule%>",
							type : 'POST',
							data : {
								<portlet:namespace/>isDraft : false,
								<portlet:namespace/>facultyMasterRotationScheduleData : JSON.stringify(facultyMasterRotationScheduleData),
								<portlet:namespace/>programMasterId : programMasterId,
								<portlet:namespace/>progdurationTlBlocksLtId : progdurationTlBlocksLtId,
								<portlet:namespace/>isValidate : false
							},
							success : function(data) {
								if (data.success) {
									$("#submitRotationSuccessModal").modal("show");
								} else {
									$(".confirmation-faculty-title").empty();
									$("#confirmationFacultyModal").removeAttr("data-name");
									$("#confirmationFacultyModal").removeAttr("data-value");
									$("#confirmationFacultyModal").data("name", "submit");
									$("#confirmationFacultyModal").data("value", "facultyissue");
									$(".confirmation-faculty-title").html(`<liferay-ui:message key='faculty-assign-block-data-issue'/>`);
									$("#confirmationFacultyModal").modal("show");
								}
							}
						});
					}
				}
			});
		}
	} else if ($("#confirmationModal").data("name") == "tab"){
		$(".pagetitle").empty();
		if($("#confirmationModal").data("value") == "pills-trainees-tab") {
			$(".pagetitle").html(`<liferay-ui:message key="master-rotation-by-trainee" />`);
		} else if($("#confirmationModal").data("value") == "pills-rotation-tab") {
			$(".pagetitle").html(`<liferay-ui:message key="master-rotation-by-rotation" />`);
		} else if($("#confirmationModal").data("value") == "pills-faculty-tab") {
			$(".pagetitle").html(`<liferay-ui:message key="master-rotation-by-faculty" />`);
		}else if($("#confirmationModal").data("value") == "pills-trainee-faculty-tab") {
			$(".pagetitle").html(`<liferay-ui:message key="master-rotation-by-trainee-faculty" />`);
		}
		$("#"+$("#confirmationModal").data("value")).click();
		addLoader();
		
	}
});

function saveTraineeMasterRotationScheduleData(isDraft, traineeMasterRotationScheduleData, saveTraineeMasterRotationSchedule) {
	let programMasterId = $("#<portlet:namespace/>programMasterId").val();
    let progdurationTlBlocksLtId = $("#<portlet:namespace/>progdurationTlBlocksLtId").val();
	$.ajax({
		url : saveTraineeMasterRotationSchedule,
		type : 'POST',
		data : {
			<portlet:namespace/>isDraft : isDraft,
			<portlet:namespace/>traineeMasterRotationScheduleData : JSON.stringify(traineeMasterRotationScheduleData),
			<portlet:namespace/>programMasterId : programMasterId,
			<portlet:namespace/>progdurationTlBlocksLtId : progdurationTlBlocksLtId
		},
		success : function(data) {
			isChanged = false;
			let jsondata = JSON.parse(data);
			if(!jsondata){
				$(".popup-alert-title").empty();
				$(".popup-alert-title").html(`<liferay-ui:message key="trainee-alert" />`);
				$(".popup-alert-message").empty();
				$(".popup-alert-message").html(`<liferay-ui:message key="scheduled-data-issue" />`);
				$(".popup-alert-button").empty();
				$(".popup-alert-button").html(`<liferay-ui:message key="back" />`);
				$("#alertPopup").modal("show");
			} else {
				if(isDraft){
					$("#saveAsDraftSuccessModal").modal("show");
				}else{
					$("#submitRotationSuccessModal").modal("show");
				}
			}
		}
	});
}

function saveRotationMasterRotationScheduleData(isDraft, rotationMasterRotationScheduleData, saveRotationMasterRotationSchedule) {
	let programMasterId = $("#<portlet:namespace/>programMasterId").val();
    let progdurationTlBlocksLtId = $("#<portlet:namespace/>progdurationTlBlocksLtId").val();
	$.ajax({
		url : saveRotationMasterRotationSchedule,
		type : 'POST',
		data : {
			<portlet:namespace/>isDraft : isDraft,
			<portlet:namespace/>rotationMasterRotationScheduleData : JSON.stringify(rotationMasterRotationScheduleData),
			<portlet:namespace/>programMasterId : programMasterId,
			<portlet:namespace/>progdurationTlBlocksLtId : progdurationTlBlocksLtId
		},
		success : function(data) {
			isChanged = false;
			let jsondata = JSON.parse(data);
			if(!jsondata){
				$(".popup-alert-title").empty();
				$(".popup-alert-title").html(`<liferay-ui:message key="trainee-alert" />`);
				$(".popup-alert-message").empty();
				$(".popup-alert-message").html(`<liferay-ui:message key="scheduled-data-issue" />`);
				$(".popup-alert-button").empty();
				$(".popup-alert-button").html(`<liferay-ui:message key="back" />`);
				$("#alertPopup").modal("show");
			} else {
				if(isDraft){
					$("#saveAsDraftSuccessModal").modal("show");
				}else{
					$("#submitRotationSuccessModal").modal("show");
				}
			}
		}
	});
}

function showConfirmation(e) {
	var buttonId = e.getAttribute("data-id");
	if(isChanged){
		$(".confirmation-title").empty();
		$("#confirmationModal").removeAttr("data-name");
		$("#confirmationModal").removeAttr("data-value");
		$("#confirmationModal").data("name", "tab");
		$("#confirmationModal").data("value", buttonId);
		$(".confirmation-title").html(`<liferay-ui:message key='master-schedule-data-may-loss'/>`);
		$("#confirmationModal").modal("show");
	}else{
		$("#"+buttonId).click();
		addLoader();
	}
	
}

function addLoader(){
    const loaderContainer = document.querySelector('.loader-container');
    loaderContainer.classList.remove('d-none');
    const loader = document.querySelector('.loaded');
    loader.classList.add('loader');
}
function removeLoader(){
	const loaderContainer = document.querySelector('.loader-container');
	loaderContainer.classList.add('d-none');
	const loader = document.querySelector('.loaded');
	loader.classList.remove('loader');
	fixedButtom();
}

</script>