<%@ include file="/init.jsp" %>


<div id="wrapper">
				<div class="container">

					<div class="omsb-cards-wrap">
						<div class="row">
							
                        
                            <div class="col-md-12 col-sm-12 col-xs-12">								
                                <div class="omsb-card chart_box">
                                    <div class="omsb-page-top-info ocy-kpis-charts">
                                        <div class="pagetitle">Notifications</div>
                                    </div>
                                    <div class="omsb-card-body">
                                        <ul class="omsb-notification-lists">
                                        <c:forEach items="${notifications}" var="notification">
                                         
											<li>
												<div class="omsb-notification-box">
													<div class="omsb-notification-img">
													<c:choose>
														<c:when test="${notification.image ne null && notification.image ne ''}">
															<img src="${notification.image}" alt="" />
														</c:when> 
														<c:otherwise>
															<img src="<%= themeDisplay.getPathThemeImages() %>/svg/no_img.svg" />
														</c:otherwise>
													</c:choose>
													</div>
													 
													 
													<div class="omsb-notification-dtls">
													
											<c:choose>
												<c:when test="${notification.emailContent ne null && notification.emailContent ne ''}">
													<a href="void:javascript(0)" onclick='showContent(`${notification.emailContent}`)'>
														${notification.notificationText}
													</a>
												</c:when> 
												<c:otherwise>
													${notification.notificationText}
												</c:otherwise>
											</c:choose>
													
														<div class="omsb-posted-time">${notification.dateTime}</div>
													</div>
			
												</div>
											</li>
											</c:forEach>
											
										</ul>
										<div class="text-center all-notifications-button">
											<a href="/group/guest/notification">View All notifications</a>
										</div>
                                    </div>
                                </div>				
							</div>
						</div>
						
					</div>

				</div>
			</div>
			
<button hidden id="openModel" data-senna-off="true"  data-toggle="modal" data-target="#notification-content-model" data-rowcount="addPopUpRow">hhh</button>		  
	<div class="modal fade omsb-modal" id="notification-content-model" tabindex="-1" role="dialog"
			aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered w-50" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<div class="omsb-card omsb-card-graybg row">
						   <div id="notification-content12"></div>
						</div>
					</div>
				</div>
			</div>
		</div>		

<script>

function showContent(notificationContent){
	if(notificationContent!=''){
		$("#notification-content12").html(notificationContent)
		$("#openModel").click();
	}
	
}
</script>