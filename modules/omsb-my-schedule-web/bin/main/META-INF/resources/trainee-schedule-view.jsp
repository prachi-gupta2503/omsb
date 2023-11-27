<%@ include file="init.jsp"%>


<div id="wrapper">
  <div class="container">
    <div class="row">
      <div class="col-md-12">
        <div class="omsb-card">
          <div class="omsb-page-top-info mb-4">
            <div class="pagetitle"><liferay-ui:message key="trainee-view-master-rotation" /></div>
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
              <tbody>
               	<c:forEach items="${progdurationRotationTrainingsitesRelCodeMapping}" var="progdurationRotationTrainingsitesRelCode">
               		<tr>
               			<td><a href="javascript:void(0)"  onClick="getTrainingRotationDetailModal(${progdurationRotationTrainingsitesRelCode.key})" id="${progdurationRotationTrainingsitesRelCode.key}" 
               				data-id="${progdurationRotationTrainingsitesRelCode.key}" data-target="#assignmentdetails" data-toggle="modal">
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

<jsp:include page="/trainee-rotation-detail-popup-modal.jsp" />

<script  type="text/javascript">
function getTrainingRotationDetailModal(progdurationRotationTrainingsitesRelId){
	  $.ajax({
		  url: '<%=getTraineeRotationDetailResourceURL%>',
		     type : 'POST',
		     data : {
		    	 <portlet:namespace/>progdurationRotationTrainingsitesRelId : progdurationRotationTrainingsitesRelId
		     },
		  success: function(traineeRotationDetail){
			  if(traineeRotationDetail.success){
				 console.log("traineeRotationDetail :",traineeRotationDetail);
				 $("#traineeRotationModalBody").empty();
				 let traineeRotationDetailArray=traineeRotationDetail.result;
				 for (let i = 0; i < traineeRotationDetailArray.length; i++) {
				    let isSharedRotationHTML = "";
				    if (traineeRotationDetailArray[i].isSharedRotation) {
				        isSharedRotationHTML = "<span class='omsb-complete-bg'>"+Liferay.Language.get('shared')+"</span>";
				    }

				    let rowHTML = "<tr>\r\n" +
				        "<td>" + traineeRotationDetailArray[i].rotationTrainingCode + isSharedRotationHTML +
				        "</td>" +
				        "<td>" + traineeRotationDetailArray[i].trainingSiteCode + "</td>" +
				        "<td>" + traineeRotationDetailArray[i].count + "</td>" +
				        "</tr>";

				    $("#traineeRotationModalBody").append(rowHTML);
				}
			  }
		  }		  
	  });	   
 }
</script>
