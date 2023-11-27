		<div class="omsb-card border mt-3">
													<div class="omsb-page-top-info mb-4">
														<div>Services Available</div>
													</div>
                                                    
													<div class="services-available-box-main">
													 <c:forEach var="service" items="${serviceList}">
															<div class="services-available-box">
															<img src="<%=themeDisplay.getPathThemeImages() %>/svg/${service.getImage()}" alt="">
															<p>${service.getServiceId()}</p>
														</div>
														</c:forEach>
														
		</div>
		</div>	