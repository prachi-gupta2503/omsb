<%@ include file="../../init.jsp"%>

<div id="workDetailList">
	<c:choose>
		<c:when test="${!empty workDetailItems.getItems()}">
			<table class="display omsb-datatables" id="work-detail-list1" width="100%">
				<thead>
					<tr>
						<th><liferay-ui:message key="workplace-sector-type" /></th>
						<%-- <th><liferay-ui:message key="workplace-sector-other" /></th> --%>
						<th><liferay-ui:message key="sector-name" /></th>
						<%-- <th><liferay-ui:message key="sector-name-other" /></th>
						<th><liferay-ui:message key="sector-name-2" /></th>
						<th><liferay-ui:message key="sector-name-2-other" /></th> --%>
						<th><liferay-ui:message key="region-locationS-institution" /></th>
						<th><liferay-ui:message key="designation" /></th>
						<th><liferay-ui:message key="verification-status" /></th>
						
						<th><liferay-ui:message key="action" /></th>
					</tr>
				</thead>
				<tbody>
					 <c:forEach var="pastWorkDetail" items="${workDetailItems.getItems()}"> 
							<tr>
								<td>${pastWorkDetail.getWorkSectorType()}</td>
								<%-- <td>${pastWorkDetail.getWorkSectorTypeOther()}</td> --%>
								<td>${pastWorkDetail.getWorkSector()}</td>
								<%-- <td>${pastWorkDetail.getWorkSectorOther()}</td>
								<td>${pastWorkDetail.getWorkSector2()}</td>
								<td>${pastWorkDetail.getWorkSectorOther2()}</td> --%>
								<td>${pastWorkDetail.getWorkSectorLocation()}</td>
								<td>${pastWorkDetail.getDesignationId()}</td>
								<td>
									<div class="d-flex" >
											<c:choose>
													<c:when test="${pastWorkDetail.isEmploymentDetailVerified()}">
														<span style="" id="WorkverifyDetails" class="1 status-text-verified justify-content-between align-items-center"> <img src="<%=themeDisplay.getPathThemeImages() %>/svg/verified_green.svg"> Verified</span>
														<span id="WorkunverifyDetails" class="d-none"><img src="<%=themeDisplay.getPathThemeImages() %>/svg/unverified_red.svg"> Un-verified</span>
														
														<%-- <span style="" id="verifyDetails" class="status-text-verified justify-content-between align-items-center"> <img src="<%=themeDisplay.getPathThemeImages() %>/svg/verified_green.svg"> Verified</span>
														<span id="unverifyDetails" style="display: none;" class="status-text-un-verified  justify-content-between align-items-center"><img src="<%=themeDisplay.getPathThemeImages() %>/svg/unverified_red.svg"> Un-verified</span> --%>
													</c:when>
													<c:otherwise>
														<span  id="WorkverifyDetails" style="display: none;" class="d-none"> <img src="<%=themeDisplay.getPathThemeImages() %>/svg/verified_green.svg"> Verified</span>
														<span style="" id="WorkverifyDetails" class="2 status-text-un-verified  justify-content-between align-items-center"><img src="<%=themeDisplay.getPathThemeImages() %>/svg/unverified_red.svg"> Un-verified</span>
														<%-- <span style="display: none;" id="verifyDetails" class="status-text-verified justify-content-between align-items-center"> <img src="<%=themeDisplay.getPathThemeImages() %>/svg/verified_green.svg"> Verified</span> --%>
														<%-- <span id="unverifyDetails" class="status-text-un-verified d-flex justify-content-between align-items-center"><img src="<%=themeDisplay.getPathThemeImages() %>/svg/unverified_red.svg"> Un-verified</span> --%>
													</c:otherwise>
												</c:choose>	
										</div>
								</td>
								<td>
									<div class="form-group m-0 w-auto">
										<div class="custom-control custom-checkbox w-auto">
									<c:choose>
										<c:when test="${pastWorkDetail.isEmploymentDetailVerified()}">
										<input type="checkbox"  value="${pastWorkDetail.id}" class="custom-control-input Workverify" checked="checked" id="Workverify" name="verify">
										</c:when>
										<c:otherwise>
												<input type="checkbox"  value="${pastWorkDetail.id}" class="custom-control-input Workverify" id="Workverify" name="verify">
										</c:otherwise>
									</c:choose>
										<label class="custom-control-label m-0" for="verify">Verify</label>						
										</div>
									</div>
								</td>
						</tr>
					 </c:forEach>
				</tbody>
			</table>
		</c:when>
		<c:otherwise>
			<liferay-ui:message key="no-records-found" />
		</c:otherwise>
	</c:choose>
</div>

