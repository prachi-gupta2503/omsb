<%@ include file="init.jsp" %>

<portlet:resourceURL var="getProgramUserDetailMVCResourceURL" id="/getProgramUserDetailMVCResourceURL" />

<div class="omsb-card">
	<h4 class="omsb-card-title"><liferay-ui:message key="currently-available-slots" /></h4>
	<div class="omsb-list-view table-responsive">
		<table id="trainingSiteCapacityTable" class="display omsb-datatables">
		<caption></caption>
			<thead>
				<tr>
					<th><liferay-ui:message key="training-sites" /></th>
					<th><liferay-ui:message key="rotation" /></th>
					<th><liferay-ui:message key="authorized-user" /></th>
					<th><liferay-ui:message key="current-slots" /></th>
					<th><liferay-ui:message key="action" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${trainingSitesCapacityList}" var="trainingSitesCapacity">
			            <tr>	
			                <td>${trainingSitesCapacity.getTrainingSiteName()}</td>
			                <td>${trainingSitesCapacity.getRotationName()}</td>
			                 <td>${trainingSitesCapacity.getSauUsers()}</td>
			                <td>${trainingSitesCapacity.getNoOfSlots()}</td>
			                <td class="text-center" style="width:50px">
			                	<button class="btn omsb-bc-red-button notify-sau-modal" type="button" data-target="#notifyauthorizeduser" data-toggle="modal" data-value="${trainingSitesCapacity.getProgdurationRotationTsRelId()}">
									<liferay-ui:message key="notify" />
								</button>
			            	</td>                  
			            </tr>
	        	</c:forEach>	
			</tbody>
		</table>
	</div>
</div>
<jsp:include page="/notify-sau-modal.jsp" />
<script>
	$(document).ready(function(){
		$('#trainingSiteCapacityTable').DataTable({
			"sDom": 'Rfrtlip'
		});
		$(".modal-backdrop").remove();
	});
	
	$(document).on("click",".notify-sau-modal", function(){
		getNotifyModalDetails($(this).data('value'));
	});
	function getNotifyModalDetails(progdurationRotationTsRelId){
		console.log("progdurationRotationTsRelId : " , progdurationRotationTsRelId);
	    $.ajax({
	        url: '<%=getProgramUserDetailMVCResourceURL%>',
				type : 'POST',
				data : {
					<portlet:namespace/>progdurationRotationTsRelId : progdurationRotationTsRelId
				},
				success : function(data) {
						$("#userList").html("");
						console.log("data :::: " + data);
						let programUserDetailsArray = JSON.parse(data);
						console.log("name : " , programUserDetailsArray.sauUserDetails[0].sauUserName);
						var userLists = "";
						for(let i=0; i<programUserDetailsArray.sauUserDetails.length; i++){
							userLists +=
								"<li class=\"omsb-comment-box mb-1\">\r\n" + 
								"	<div class=\"omsb-notification-box\">\r\n" + 
								"		<div class=\"custom-control custom-checkbox\">\r\n" + 
								"			<input type=\"checkbox\" class=\"custom-control-input checkbox-notify-sau\" onclick=\"updateSubmitButton(false)\" id=\"<portlet:namespace/>notifySau\" name=\"<portlet:namespace/>notifySau\" value=\""+programUserDetailsArray.sauUserDetails[i].sauUserId+"\">\r\n" + 
								"				<label class=\"custom-control-label\" for=\"<portlet:namespace/>notifySau\"></label>\r\n" + 
								"		</div>\r\n" + 
								"		<div class=\"omsb-notification-img\" >\r\n" + 
								"			<img src=\""+ programUserDetailsArray.sauUserDetails[i].sauUserImage +"\" alt=\"\">\r\n" + 
								"		</div>\r\n" + 
								"		<div class=\"omsb-notification-dtls\" >\r\n" + 
								"			<h6> "+ programUserDetailsArray.sauUserDetails[i].sauUserName +" </h6>\r\n" + 
								"		</div>\r\n" + 
								"	</div>\r\n" + 
								"</li>";
						}
						$("#userList").html(userLists);
						$("#<portlet:namespace/>currentCapacity").val(programUserDetailsArray.noOfSlots[0].noOfSlot);
						$("#<portlet:namespace/>currentUser").val(programUserDetailsArray.noOfSlots[0].currentUser);
						$("#<portlet:namespace/>trainingSiteId").val(programUserDetailsArray.noOfSlots[0].trainingSiteId);
				}
			});
		}
	
	$(".cancel-notify-sau-button").on("click",function(){
		$(".notify-sau-button").prop('disabled', true);
	})
	
    function updateSubmitButton(isCreate) {
        var checkboxes;
        if(isCreate) {
        	checkboxes = $('.checkbox-notify-sau-create');
        } else {
        	checkboxes = $('.checkbox-notify-sau');
        }
        let checkedCount = 0;

        checkboxes.each(function() {
            if ($(this).prop('checked')) {
                checkedCount++;
            }
        });
		console.log("checkedCount = ", checkedCount);
        if (checkedCount === 0) {
        	if (isCreate) {
        		$(".notify-sau-button-create").prop('disabled', true);
        	} else {
        		$(".notify-sau-button").prop('disabled', true);
        	}
        } else {
			if (isCreate) {
				$(".notify-sau-button-create").prop('disabled', false);
        	} else {
        		$(".notify-sau-button").prop('disabled', false);
        	}
            
        }
    }
</script>