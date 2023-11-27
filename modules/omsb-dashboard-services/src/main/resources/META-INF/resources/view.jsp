<%@ include file="/init.jsp"%>

<div class="omsb-card-body">
	<div class="servicesweoffer">
		<ul>
			<c:forEach var="service" items="${serviceList}">
			<li>
				<a href="${service.serviceURL}" >
					<span class="servicesweoffer-icon">
						<img src="<%=themeDisplay.getPathThemeImages() %>/svg/${service.getImage()}" alt="">
					</span>
					<p>${service.serviceId}</p>
				</a>
			</li>
			</c:forEach>
			
		</ul>
	</div>
</div>