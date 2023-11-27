<%@ include file="../../init.jsp"%>

<portlet:renderURL var="backURL">
	<portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>

<div id="wrapper">
	<div class="container">
		<div class="omsb-card">
			<div class="omsb-page-top-info m-0">
				<div class="pagetitle"><liferay-ui:message key="view-results" /></div>
				<div class="information"></div>
			</div>

			<div class="omsb-list-view table-responsive">
				<table class="display omsb-datatables" id="trainee-result-table">
					<thead>
						<tr>
							<th><liferay-ui:message key="program-name" /></th>
							<th><liferay-ui:message key="exam-type" /></th>
							<th><liferay-ui:message key="result" /></th>
							<th><liferay-ui:message key="percentage" /></th>
							<th><liferay-ui:message key="trainee-level" /></th>
							<th><liferay-ui:message key="admin-comments" /></th>
							<th><liferay-ui:message key="admin-document" /></th>
							
							<th><liferay-ui:message key="actions" /></th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="examResult" items="${examResult}">
						<tr>
							<td>${examResult.programName}</td>
							<td>${examResult.examType}</td>
							<td>${examResult.result}</td>
							<td>${examResult.percentage}</td>
							<td>${examResult.traineeLevelId}</td>
							<td>${examResult.adminComments}</td>
					<%--  <c:when test="${not empty examResult.appealStatusList}"> --%>
							<c:forEach var="appealStatus" items="${documentList}" varStatus="counter">
								<c:forEach var="document" items="${appealStatus.examDocuments}">
									<td><a class="btn upload_btn" title="download" href="${document.fileURL }"> <img src="../images/svg/download_icon.svg" alt="" />${document.fileName }</a>
										</td>
								</c:forEach>
							</c:forEach>
					<%-- </c:when>
					<c:otherwise>
						<td></td>
					</c:otherwise> --%>
								
								<td>
								<div class="dropdown ">
									<button class="btn fa fa-ellipsis-v dropdown-toggle"
										type="button" data-toggle="dropdown" aria-expanded="false">
										<i class=""></i>
									</button>
									
									
									<portlet:renderURL var="viewParticularExamResultURL">
										<portlet:param name="mvcRenderCommandName" value="<%=MVCCommands.VIEW_PARTICULAR_EXAM_RESULT%>" />
										<portlet:param name="examScheduleId" value="${examResult.examScheduleId}" />
										<portlet:param name="examDefinitionId" value="${examResult.examDefinitionId}" />
										<portlet:param name="examResultId" value="${examResult.id}" />
										<portlet:param name="programName" value="${examResult.programName}" />
										<portlet:param name="examType" value="${examResult.examType}" />
									</portlet:renderURL> 
									
									
									<ul class="dropdown-menu">
										 <portlet:renderURL var="viewAppealURL">
											<portlet:param name="mvcRenderCommandName"
												value="<%=MVCCommands.TRAINEE_APPEAL_RENDER_COMMAND %>" />
											<portlet:param name="examResultId"
												value="${examResult.id}" />
										</portlet:renderURL> 
										<c:choose>
											<c:when test="${examResult.appealCount eq '0' && examResult.appealStatus eq ''}">
												<li><a data-toggle="modal" data-target="#adjuducate_appeal_popup" class="dropdown-item" onclick="setModalValues('appeal', '${examResult.appealFees}')">
														<img src="<%=themeDisplay.getPathThemeImages()%>/images/svg/appeal.svg" alt="" >
														<liferay-ui:message key="appeal" /></a>
												</li>
											</c:when>
											<c:when test="${examResult.appealCount eq '1' && (examResult.appealStatus eq 'accepted' or examResult.appealStatus eq 'rejected')}">
												<li><a data-toggle="modal" data-target="#adjuducate_reappeal_popup" class="dropdown-item" onclick="setModalValues('reappeal', '${examResult.reAppealFees}')">
														<img src="<%=themeDisplay.getPathThemeImages()%>/images/svg/appeal.svg" alt="">
														<liferay-ui:message key="re-appeal" /></a>
												</li>
											</c:when>
										</c:choose>
										<li><a href="${viewParticularExamResultURL}" class="dropdown-item"><img
												src="<%=themeDisplay.getPathThemeImages()%>/images/svg/fi-rr-eye.svg" alt=""> <liferay-ui:message key="view-result" /></a></li>
									</ul>
								</div>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="bottom-backbtn-wrap">
				<a class="btn omsb-btn btn-back" href="${backURL}"><i
					class="fi fi-sr-arrow-left"></i><liferay-ui:message key="back" /></a>
			</div>
		</div>
	</div>
</div>

<!-- Modal adjuducate_appeal_popup -->
<div class="modal fade omsb-modal" id="adjuducate_appeal_popup" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<form action="${viewAppealURL}" method="post" name="<portlet:namespace/>aFM" id="aFM" autocomplete="off">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="adjuducate-appeal" /></h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label><liferay-ui:message key="are-you-sure-you-want-to-create-appeal-request" /></label>
								<label><liferay-ui:message key="appeal-fees" /></label><div id="appealFees"></div>
								<button class="btn omsb-bc-red-button" type="submit" title="<liferay-ui:message key="yes" />"><liferay-ui:message key="yes" /></button>
								<button class="btn omsb-bg-red-button" type="button" title="<liferay-ui:message key="no" />" class="close" data-dismiss="modal" ><liferay-ui:message key="no" /></button>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<!--// adjuducate_appeal_popup pop up -->

<!-- Modal adjuducate_reappeal_popup -->
<div class="modal fade omsb-modal" id="adjuducate_reappeal_popup" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<form action="${viewAppealURL}" method="post" name="<portlet:namespace/>aFM" id="aFM" autocomplete="off">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle"><liferay-ui:message key="adjuducate-reappeal" /></h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<label><liferay-ui:message key="are-you-sure-you-want-to-create-reappeal-request" /></label>
								<label><liferay-ui:message key="reappeal-fees" /></label><div id="reAppealFees"></div>
								<button class="btn omsb-bc-red-button" type="submit" title="<liferay-ui:message key="yes" />"><liferay-ui:message key="yes" /></button>
								<button class="btn omsb-bg-red-button" type="button" title="<liferay-ui:message key="no" />" class="close" data-dismiss="modal" ><liferay-ui:message key="no" /></button>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
<!--// adjuducate_reappeal_popup pop up -->


<script type="text/javascript">

	function setModalValues(feesType, fees){
		if(feesType == "appeal"){
			$('#appealFees').text(fees);
			$('#reAppealFees').text('');
		} else if (feesType == "reappeal"){
			$('#reAppealFees').text(fees);
			$('#appealFees').text('');
		}
	}

	$('#trainee-result-table').DataTable({
			"bLengthChange": false,
			dom: 'Bfrtip',
	    	buttons: [
	    		{
	              extend: 'colvis',
	              text: '<liferay-ui:message key="column-visibility" />',
	              columns: ":not(':last')"
	            },
	    	    {
	    	        extend: 'collection',
	    	        text: '<liferay-ui:message key="export-as" />',
	    	        buttons: [
	    	            {
	    	                extend: 'csv',
	    	                exportOptions: {
	    	                    columns: ":visible:not(':last')"
	    	                }
	    	            },
	    	            {
	    	                extend: 'pdf',
	    	                exportOptions: {
	    	                    columns: ":visible:not(':last')"
	    	                }
	    	            },
	    	            {
	    	                extend: 'excel',
	    	                exportOptions: {
	    	                    columns: ":visible:not(':last')"
	    	                }
	    	            },
	    	            {
	    	                extend: 'print',
	    	                exportOptions: {
	    	                    columns: ":visible:not(':last')"
	    	                }
	    	            }
	    	        ]
	    	    }
	    	],
		});
</script>
<style>
#trainee-result-table_wrapper .dataTables_filter {display: none;}
</style>