<%@ include file="/init.jsp"%>
<table class="display omsb-datatables" id="traineeTable">
			<thead>
				<tr>
					 <th class="no_sorting">
						<div class="custom-control custom-checkbox ">
						 <input type="checkbox" class="custom-control-input" id="authorize" name="authorize">
						 <label class="custom-control-label m-0" for="authorize"></label>
					   </div>
					   
				    </th>
				    <th><liferay-ui:message key="program-name" /></th>
					<th><liferay-ui:message key="trainee-name"/></th>
					<th><liferay-ui:message key="omsb-id"/></th>
					<th><liferay-ui:message key="action"/></th>

				</tr>
			</thead>
			<tbody>
			<c:forEach var ="trainee" items="${trainees}">
				<tr>
					<td><div class="custom-control custom-checkbox ">
						<input type="checkbox" class="custom-control-input" id="authorize" name="authorize">
						<label class="custom-control-label m-0" for="authorize"></label>
					  </div></td>
					  <td></td>
					<td>${trainee.name}</td>
					<td>${trainee.lrUserId}</td>
					<td><portlet:renderURL var="registrationFormURl">
										<portlet:param name="mvcRenderCommandName" value="<%=MVCCommands.SAVE_REGISTRATION%>" />
										<portlet:param name="programId" value="${trainee.programId}" />
										<portlet:param name="examTypeId" value="${trainee.examTypeId}" />
										<portlet:param name="examScheduleId" value="${trainee.examSchedule.id}" />
										<portlet:param name="lrUserId" value="${trainee.lrUserId}" />
										<portlet:param name="regCmd" value="regCmd" />
										<portlet:param name="cmd" value="registration" />
										<portlet:param name="role" value="admin" />
									</portlet:renderURL>
									<div class="buttons_wrap">
									<c:choose>
										<c:when test="${trainee.registrationStatus eq 'Registered' or trainee.registrationStatus eq 'Withdrawn' or trainee.registrationStatus eq 'Pending'}">
											<button disabled class="btn register_btn" title="Register">
												<img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-register.svg">
													<liferay-ui:message key="registered" />
											</button>
										</c:when>
										<c:when test="${trainee.registrationStatus eq 'Pending'}">
											<button disabled class="btn register_btn" title="Registration Pending">
												<img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-register.svg">
													<liferay-ui:message key="registration-pending" />
											</button>
										</c:when>
										<c:otherwise>
											  <a href="${registrationFormURl}">
													<button class="btn register_btn" title="Register">
														<img src="<%=themeDisplay.getPathThemeImages()%>/svg/fi-rr-register.svg">
															<liferay-ui:message key="register" />
													</button>
											  </a>
										</c:otherwise>
									</c:choose>	
									</div></td>
				</tr>
				</c:forEach>
			</tbody>
</table>