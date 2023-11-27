<%@ include file="/init.jsp"%>

<c:if test = "${rotationStructureList != null &&  rotationStructureList.size() != 0}">
<div class="row">
	<div class="col-md-12">
		<div class="omsb-pediatrics-rotationdetails">
			<h4 class="omsb-card-title">${rotation.getRotationName(locale)}
				<c:if test="${isSharedRotation}">
					<span class="omsb-complete-bg"> <liferay-ui:message key="shared" /></span>
				</c:if>
			</h4>
			<div class="row">
			<c:forEach var="rotationStructure" items="${rotationStructureList}">
				<div class="col-lg-3 col-md-3 col-sm-4 col-xs-12 mb-cst">
					<div class="omsb-pediatrics-box">
						<h6><liferay-ui:message key="program" /></h6>
						<h3>${rotationStructure.value.programName}</h3>
						
						<ul>
							<c:forEach var="traineeLevel" items="${rotationStructure.value.rotationTrainingLevel}">
							<li>
								<div class="Program-dtls">
									<div class="title">${traineeLevel.key}</div>
									<div class="title-value">${traineeLevel.value == 0 ? "-" : traineeLevel.value}</div>
								</div>
							</li>
							</c:forEach>
						</ul>
						
					</div>
				</div>
			</c:forEach>
			</div>
		</div>
	</div>
</div>
</c:if>