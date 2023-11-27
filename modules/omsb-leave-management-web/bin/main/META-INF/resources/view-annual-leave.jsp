<%@ include file="init.jsp"%>

<portlet:renderURL var="viewLeaveManagementTabURL">
    <portlet:param name="jspPage" value="<%= OmsbLeaveManagementWebConstants.LEAVE_MANAGEMENT_TAB %>"/>
    <portlet:param name="isAnnualLeaveTab" value="true"/>
</portlet:renderURL>

<portlet:resourceURL id="<%=OmsbLeaveManagementWebConstants.VIEW_BLOCK_BY_TRAINEE_LEVEL %>" var="viewBlockByTraineeLevel" />


<div class="omsb-card">
	<div class="omsb-page-top-info mb-3">
		<div class="pagetitle"><liferay-ui:message key="view-annual-leave-rules" /></div>							
	</div>
	
	<div class="row">
		<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
			<div class="form-group">
				<label><liferay-ui:message key="program-name" /></label>
				<span class="value">${programName}</span>
			</div>
		</div>
		<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
			<div class="form-group">
				<label><liferay-ui:message key="availableAt" /></label>
				<span class="value">${availableAt}</span>
			</div>
		</div>
        <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12">
			<div class="form-group">
				<aui:select cssClass="custom-select form-control" onChange="populateBlockByTraineeLevel()" label="trainee-level" id="traineeLevelList" name="traineeLevelList">
					<c:forEach var="traineeLevel" items="${traineeLevels}">
						<aui:option value="${traineeLevel}">${traineeLevel}</aui:option>
					</c:forEach>
				</aui:select>
			</div>
		</div>
		
		<aui:input name="leaveAnnualRuleId" id="leaveAnnualRuleId" value="${leaveAnnualRuleId}" type="hidden" />
		
		
	</div>
	<div class="omsb-card omsb-card-border">
	    <h4 class="omsb-card-title"><liferay-ui:message key="current-leave-available-status" />
	        <ul>
	            <li><span class="availablestatus"></span><liferay-ui:message key="available" /></li>
	            <li><span class="notavailablestatus"></span><liferay-ui:message key="not-available" /></li>
	        </ul>
	    </h4>
	    <div class="row" id="block-details-container">
	    	
	    	
	    
	    </div>
		</div>
	    <div class="bottom-backbtn-wrap">
	        <a class="btn omsb-btn btn-back" href="${viewLeaveManagementTabURL}"><i class="fi fi-sr-arrow-left"></i><liferay-ui:message key="back" /></a>
	    </div>
</div>

	
</div>

<script>

$(document).ready(function(){
	populateBlockByTraineeLevel();
});

function populateBlockByTraineeLevel(){
	$.ajax({
		url: '<%=viewBlockByTraineeLevel%>',
		type: 'POST',
		data:
			{
				<portlet:namespace/>leaveAnnualRuleId: $('#<portlet:namespace/>leaveAnnualRuleId').val(),
				<portlet:namespace/>traineeLevelName : $('#<portlet:namespace/>traineeLevelList').val(),
			},
		success: function(data)
		{
			let jsonData = JSON.parse(data);
			console.log("jsonDaata::::"+ jsonData);
			var blockObj = '';
			if(jsonData.length!=0){
				$("#block-details-container").empty();
				for(var i = 0; i < jsonData.length ; i++){
					if(jsonData[i].allowed <= 0){
						var blockObj = blockObj + '<div class="col-lg-3 col-md-6 col-sm-6 mb-cst"> <div class="omsb-view-result-box not-available"> <h6>' + jsonData[i].block + '</h6>' +
						'<div class="row"><div class="col-lg-12 col-md-12"><div class="form-group-dtls"><label><liferay-ui:message key="max-allowed" /> : ' + jsonData[i].maxAllowed  + '</label>' +
						'</div></div><div class="col-lg-12 col-md-12"><div class="form-group-dtls"><label><liferay-ui:message key="available" /> :  ' + jsonData[i].allowed + '</label>' + 
						'</div></div></div></div></div>'
					}
					else{
						var blockObj = blockObj + '<div class="col-lg-3 col-md-6 col-sm-6 mb-cst"> <div class="omsb-view-result-box available"> <h6>' + jsonData[i].block + '</h6>' +
						'<div class="row"><div class="col-lg-12 col-md-12"><div class="form-group-dtls"><label><liferay-ui:message key="max-allowed" /> : ' + jsonData[i].maxAllowed  + '</label>' +
						'</div></div><div class="col-lg-12 col-md-12"><div class="form-group-dtls"><label><liferay-ui:message key="available" /> :  ' + jsonData[i].allowed + '</label>' + 
						'</div></div></div></div></div>'
					}
				 }
				
				$("#block-details-container").append(blockObj);
			}
			else{
				$("#block-details-container").empty();
			}
		}
	});
}

</script>