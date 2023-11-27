<%@ include file="init.jsp"%>

<div id="wrapper">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="omsb-card">
					<div class="omsb-page-top-info mb-4">
						<div class="pagetitle">
							<liferay-ui:message key="faculty-view-master-rotation" />
						</div>
					</div>
					<div class="row">
						<div class="col-lg-4 col-md-6">
							<div class="form-group">
								<aui:select cssClass="custom-select form-control" label="program" name="programId"
									onChange="getProgramDurations(this.value)">
									<aui:option value="" selected="true" disabled="true"
										cssClass="placeholder">
										<liferay-ui:message key="please-select-program" />
									</aui:option>
									<c:forEach items="${programMapping}" var="program">
										<aui:option value="${program.key}">${program.value}	</aui:option>
									</c:forEach>
									<aui:validator name="required" />
								</aui:select>
							</div>
						</div>
						<div class="col-lg-4 col-md-6">
							<div class="form-group">
								<aui:select cssClass="custom-select form-control" label="program-duration" name="programDurationId"
									onChange="getTrainees(this.value)">
									<aui:option value="" selected="true" disabled="true"
										cssClass="placeholder">
										<liferay-ui:message key="please-select-program-duration" />
									</aui:option>
									<aui:validator name="required" />
								</aui:select>
							</div>
						</div>
						<div class="col-lg-4 col-md-6">
							<div class="form-group">
								<aui:select cssClass="custom-select form-control" label="trainee-level" name="traineeLevelId"
									onChange="getFacultyScheduleByFilterView(this.value)">
									<aui:option value="" selected="true" disabled="true"
										cssClass="placeholder">
										<liferay-ui:message key="please-select-trainee-level" />
									</aui:option>
									<aui:validator name="required" />
								</aui:select>
							</div>
						</div>
					</div>
					
					 <div class="table-responsive">
			            <table class="display omsb-tables table-bordered">
			              <thead>
			                <tr>
			                  <th><liferay-ui:message key="rotation" /></th>
								<c:forEach begin="1" end="13" step="1" var="index" >
									<th><liferay-ui:message key="block" />&nbsp;${index}</th>
								</c:forEach>
			                </tr>
			              </thead>
			              <tbody id="rotationBlocksBody">
			               	<c:forEach items="${progdurationRotationTrainingsitesRelCodeMapping}" var="progdurationRotationTrainingsitesRelCode">
			               		<tr>
			               			<td><a href="javascript:void(0)" id="${progdurationRotationTrainingsitesRelCode.key}" 
			               				data-id="${progdurationRotationTrainingsitesRelCode.key}" class="text-reset" data-target="#rotationModal" data-toggle="modal"
			               				onclick="getRotationTrainingSiteRelModal(${progdurationRotationTrainingsitesRelCode.key})"	>
			               					${progdurationRotationTrainingsitesRelCode.value}
			               				</a>
			               			</td>
			               			<c:forEach items="${progdurationRotationTrainingsitesRelBlocksMapping.get(progdurationRotationTrainingsitesRelCode.key)}" var="blocks">
			               				<td>
											<c:if test="${blocks eq 'true'}">
												<img src="<%=themeDisplay.getPathThemeImages()%>/svg/Right.svg" alt="right-check" />
											</c:if>
										</td>
			               			</c:forEach>
			               		</tr>
			               	</c:forEach>
			              </tbody>
			            </table>
			          </div>

					<div class="bottom-backbtn-wrap mt-0 pt-3">
						<a class="btn omsb-btn omsb-bg-red-button" href="javascript:void(0)" onclick="history.back()" title="Close">Close</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/faculty-rotation-detail-popup-modal.jsp" />
        
<script type="text/javascript">

	function getFacultyScheduleByFilterView(traineeLevel) {
		let cohortId = $('#<portlet:namespace/>programDurationId').val();
		console.log("Cohort Id: " , cohortId);
	    $.ajax({
	        url: '<%=getFacultyScheduleViewMVCResourceURL%>',
				type : 'POST',
				data : {
					<portlet:namespace/>cohortId : cohortId,
					<portlet:namespace/>traineeLevel : traineeLevel
				},
				success : function(traineeData) {
					if (traineeData.success) {
						console.log("traineeData : " , traineeData);
						$("#rotationBlocksBody").empty();
						let blocksDataObjArray = traineeData.progDurationRotationTrainingSiteObj.progdurationRotationTrainingsitesRelObjArray;
						for (let i = 0; i < blocksDataObjArray.length; i++) {
					        let progCodeBlockArray = blocksDataObjArray[i].progCodeBlocksArray;
					        let rowHTML = "<tr>\r\n" +
						                      "<td><a href='javascript:void(0)' id='" 
						                      + blocksDataObjArray[i].progdurationRotationTsRelId + 
						                      "'data-id='" + blocksDataObjArray[i].progdurationRotationTsRelId + "' class='text-reset' data-target='#rotationModal' "+
						                      " data-toggle='modal' onclick='getRotationTrainingSiteRelModal(" + blocksDataObjArray[i].progdurationRotationTsRelId + ")'>" 
						                      + blocksDataObjArray[i].progRotationTSCode + "</a></td>";
					                      
							for (let j = 0; j < progCodeBlockArray.length; j++) {
					            if (progCodeBlockArray[j] == "true") {
					                rowHTML += "    <td><img src='<%=themeDisplay.getPathThemeImages()%>/svg/Right.svg' alt='right-check'/></td>";
					            }else {
					                rowHTML += "    <td></td>";
					            }
					        }
					        rowHTML += "</tr>";
					        $("#rotationBlocksBody").append(rowHTML);
					    }
					}
				}
			});
		}
	
	function getRotationTrainingSiteRelModal(progdurationRotationTrainingsitesRelId){
		$.ajax({
			url: '<%=getRotationDetailResourceURL%>',
			     type : 'POST',
			     data : {
			    	 <portlet:namespace/>progdurationRotationTrainingsitesRelId : progdurationRotationTrainingsitesRelId
			     },
			     success: function(rotationDetail){
			    	if (rotationDetail.success){
			    		console.log("rotationDetail : " , rotationDetail);
			    		$("#rotationModalBody").empty();
			    		let rotationDetailArray = rotationDetail.result;
			    		for(let i=0; i<rotationDetailArray.length;i++){
			    			let rowHTML = "<tr>\r\n" +
			    				"<td>" + rotationDetailArray[i].rotationTrainingCode + "</td>" + 
			    				"<td>" + rotationDetailArray[i].count + "</td>" + 
			    				"</tr>";
			    		 	$("#rotationModalBody").append(rowHTML);	
			    		}
			    	}  	 
			     }
		});
	}
	
	function getProgramDurations(programId){
		console.log("Program Master Id : " , programId);
	    $.ajax({
	        url: '<%=getCohortListMVCResourceURL%>',
				type : 'POST',
				data : {
					<portlet:namespace/>programId : programId
				},
				success : function(programDuraionData) {
					if (programDuraionData.success) {
						console.log("programDuraionData : " , programDuraionData);
						$("#<portlet:namespace/>traineeLevelId").empty();
						$("#<portlet:namespace/>programDurationId").empty();
						$("#<portlet:namespace/>traineeLevelId").append("<option value='0'><liferay-ui:message key='please-select-trainee-level' /></option>");
						$("#<portlet:namespace/>programDurationId").append("<option value='0'><liferay-ui:message key='please-select-program-duration' /></option>");
						let programDurationMasterDataArray = programDuraionData.result;
						for(let i=0; i<programDurationMasterDataArray.length; i++){
							$("#<portlet:namespace/>programDurationId").append("<option value='"+programDurationMasterDataArray[i].cohortId+"'>" + programDurationMasterDataArray[i].cohortName + "</option>");
						}
					}
				}
			});
		}
	
	function getTrainees(cohortId){
		console.log("Cohort Id: " , cohortId);
	    $.ajax({
	        url: '<%=getTraineeListMVCResourceURL%>',
				type : 'POST',
				data : {
					<portlet:namespace/>cohortId : cohortId
				},
				success : function(traineeData) {
					if (traineeData.success) {
						console.log("traineeData : " , traineeData);
						$("#<portlet:namespace/>traineeLevelId").empty();
						$("#<portlet:namespace/>traineeLevelId").append("<option value='0'><liferay-ui:message key='please-select-trainee-level' /></option>");
						let traineeDataArray = traineeData.result;
						for(let i=0; i<traineeDataArray.length; i++){
							$("#<portlet:namespace/>traineeLevelId").append("<option value='"+traineeDataArray[i].traineeId+"'>" + traineeDataArray[i].traineeLevel + "</option>");
						}
					}
				}
			});
		}
</script>
