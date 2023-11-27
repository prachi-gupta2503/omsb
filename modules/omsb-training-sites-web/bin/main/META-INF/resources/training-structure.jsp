<%@ include file="init.jsp"%>
<div class="col-md-12">
	<div class="omsb-pediatrics-trainingdetails">
		<%-- <h4 class="omsb-card-title">${trainingSite.getTrainingSiteName(locale)} </h4> --%>
		<div class="row">
			<c:forEach var="trainingSiteStructure" items="${trainingSiteStructureList}">
				<div class="col-lg-4 col-md-4 col-sm-4 col-xs-12 mb-cst">
					<div class="omsb-pediatrics-box">
						<h6><liferay-ui:message key="training-site" /></h6>
						<h3>${trainingSite.getTrainingSiteName(locale)}</h3>
						<div class="program-dtls">
							<h6><liferay-ui:message key="program" /></h6>
							<h4>${trainingSiteStructure.key}</h4>
						</div>
						<ul>
							<c:forEach var="rotation" items="${trainingSiteStructure.value}">
								<c:if test="${ rotationShortageMap != null && rotationShortageMap.get(rotationNameAndKeyMap.get(rotation.key)) == true}">
									<li class="bg-red">
										<div class="row">
											<div class="col-md-5 col-sm-5 col-xs-12">
												<div class="title"><liferay-ui:message key="rotation" /></div>
												<div class="title-value">${rotation.key}</div>
											</div>
											<div class="col-md-5 col-sm-5 col-xs-12">
												<div class="title"><liferay-ui:message key="no-of-slots" /></div>
												<div class="title-value">${rotation.value}</div>
											</div>
											<div class="col-md-2 col-sm-2 col-xs-12 notification-box">
												<div class="notification-img" onclick="getSiteUserDetail(${trainingSite.trainingSiteMasterId},${rotationNameAndKeyMap.get(rotation.key)})" 
													id="${trainingSite.trainingSiteMasterId}"
													data-id="${trainingSite.trainingSiteMasterId}"
													data-target="#notifyauthorizeduser" data-toggle="modal" >
													<img src="${themeDisplay.getPathThemeImages()}/svg/notification-bell.svg" alt="<liferay-ui:message key="notification-bell-icon"/>"> 
												</div>
											</div>
										</div>
									</li>
								</c:if>
								<c:if test="${rotationShortageMap == null or rotationShortageMap.get(rotationNameAndKeyMap.get(rotation.key)) == false}">
									<li>
										<div class="row">
											<div class="col-md-6 col-sm-6 col-xs-12">
												<div class="title"><liferay-ui:message key="rotation" /></div>
												<div class="title-value">${rotation.key}</div>
											</div>
											<div class="col-md-6 col-sm-6 col-xs-12">
												<div class="title"><liferay-ui:message key="no-of-slots" /></div>
												<div class="title-value">${rotation.value}</div>
											</div>
										</div>
									</li>
								</c:if>
							</c:forEach>
						</ul>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>
<div>
	<jsp:include page="/notify-user-modal-popup.jsp" />
</div>

<script type="text/javascript">
function getSiteUserDetail(trainingSiteMasterId, rotationId){
	console.log("siteId : " , trainingSiteMasterId);
    $.ajax({
        url: '<%=getSiteUserDetailMVCResourceURL%>',
			type : 'POST',
			data : {
				<portlet:namespace/>trainingSiteMasterId : trainingSiteMasterId
			},
			success : function(programUserDetails) {
				if (programUserDetails.success) {
					console.log("programUserDetails : " , programUserDetails);
					$("#userList").html("");
					$('#rotationId').val(rotationId);
					let programUserDetailsArray = programUserDetails.result;
					let userIds = "";
					var userLists = "";
					var svgImage = '<img src="' + Liferay.ThemeDisplay.getPathThemeImages() + '/svg/notification-bell.svg" alt="' + Liferay.Language.get("notification-bell-icon") + '">';
					for(let i=0; i<programUserDetailsArray.length; i++){
						userLists +=
							"<li class=\"omsb-comment-box mb-1\">\r\n" + 
                            "    <div class=\"omsb-notification-box justify-content-between\">\r\n" +
                            "    <div class='d-flex notification-img-name'> " +	
                            "        <div class=\"omsb-notification-img\" >\r\n" + 
                            "            <img src=\""+ programUserDetailsArray[i].requestRaisedToUserImage +"\" alt=\"\">\r\n" + 
                            "        </div>\r\n" + 
                            "        <div class=\"omsb-notification-user-name\" >\r\n" + 
                            "            <h6> "+ programUserDetailsArray[i].requestRaisedToUserDetail +" </h6>\r\n" + 
                            "        </div></div>\r\n " +   
                            "        <div class=\"notification-img\" data-dismiss=\"modal\" onclick=\"notifySitesRotations( " + rotationId +  ", "+ programUserDetailsArray[i].requestRaisedTo +" )\" >\r\n" + 
                            svgImage + 
                            "        </div>\r\n" +                             
                            "    </div>\r\n" + 
                            "</li>";
						userIds = userIds + programUserDetailsArray[i].requestRaisedTo +",";
					}
					$("#notifyAll").val(userIds);
					$("#userList").html(userLists);
				}
			}
		});
	}

</script>