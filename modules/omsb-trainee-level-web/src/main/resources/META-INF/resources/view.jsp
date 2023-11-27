<%@page import="gov.omsb.tms.model.TraineeLevelMaster"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@ include file="init.jsp" %>

<liferay-ui:error key="traineeLevelError" message="trainee-level-duplication-error" />

<div class="omsb-card">
	<div class="omsb-list-view table-responsive">
		<table id="traineeLevelTable" class="display omsb-datatables">
		<caption></caption>
			<thead>
				<tr>
					<th><liferay-ui:message key="trainee-level-name" /></th>
					<th><liferay-ui:message key="create-date" /></th>
					<th><liferay-ui:message key="modified-date" /></th>
					<th><liferay-ui:message key="last-modified-by" /></th>
					<th><liferay-ui:message key="action" /></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${traineeLevelMasterList}" var="traineeLevel"> 
					<portlet:renderURL var="editTraineeLevelActionURL">
			            <portlet:param name="mvcRenderCommandName" value="<%=OmsbTraineeLevelConstants.EDIT_TRAINEE_LEVEL_MVC_COMMAND_NAME%>" />
			            <portlet:param name="traineeLevelMasterId" value="${traineeLevel.getTraineeLevelMasterId()}"/>
			        </portlet:renderURL>
					<portlet:actionURL name="<%= OmsbTraineeLevelConstants.DELETE_TRAINEE_LEVEL_MVC_COMMAND_NAME %>" var="deleteTraineeLevelActionURL">
						<portlet:param name="traineeLevelMasterId" value="${traineeLevel.getTraineeLevelMasterId()}" />
					</portlet:actionURL>
					<%
					    TraineeLevelMaster traineeLevelMaster = (TraineeLevelMaster)pageContext.getAttribute("traineeLevel");
					%>
			            <tr>	
			                <td>${traineeLevel.getTraineeLevelName(locale)}</td>
			                <td>${sdf.format(traineeLevel.getCreateDate())}</td>
			                <td>${sdf.format(traineeLevel.getModifiedDate())}</td>
			            	<td><%=UserLocalServiceUtil.getUser(traineeLevelMaster.getModifiedBy()).getFullName() %></td>
			                <td class="text-center" style="width:50px">
				            	<div class="dropdown ">
									<button class="btn fa fa-ellipsis-v dropdown-toggle"
										type="button" data-toggle="dropdown" aria-expanded="false">
										<i class=""></i>
									</button>
									<ul class="dropdown-menu">
										<li><a href="${editTraineeLevelActionURL}" class="dropdown-item"><i
												class="fa fa-pencil"></i> <liferay-ui:message key="edit" />
											</a>
										</li>
										<li><a href="javascript:void(0)" class="dropdown-item openDeleteModal" id="${traineeLevel.getTraineeLevelMasterId()}" data-id="${traineeLevel.getTraineeLevelMasterId()}" data-target="#myModal" data-toggle="modal"><i
												class="fa fa-trash-o"></i> <liferay-ui:message key="delete" />
											</a>
										</li>
									</ul>
								</div>
			            	</td>                  
			            </tr>
	        	</c:forEach>	
			</tbody>
		</table>
	</div>
</div>
<jsp:include page="/modal-popup.jsp" />
<script>
	$(document).on("click",".openDeleteModal", function(){
		$('#<portlet:namespace/>traineeLevelMasterId').val($(this).data('id'));
	});
	
	$(document).ready(function(){
		$('#traineeLevelTable').DataTable({
			"sDom": 'Rfrtlip',
			"order": [[2,"desc"]]
		});
		$(".modal-backdrop").remove();
	});
</script>
