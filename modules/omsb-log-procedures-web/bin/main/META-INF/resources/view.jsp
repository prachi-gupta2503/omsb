<%@ include file="init.jsp" %>
<style>
	.procedure-master-name {
		color: #DC3545 !important;
		text-decoration: underline !important;
	}
</style>

<portlet:renderURL var="addLogProcedures">
    <portlet:param name="mvcRenderCommandName" value="<%= OmsbLogProceduresConstants.ADD_LOG_PROCEDURES_JSP %>"/>
</portlet:renderURL>

<c:if
	test="<%=!SessionErrors.isEmpty(renderRequest) && !SessionMessages.isEmpty(renderRequest)%>">
	<div class="alert alert-light alert-danger-text" role="alert">
		<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
		<div class="alert-box">
			<span><img
				src="<%=themeDisplay.getPathThemeImages()%>/svg/reject.svg"
				alt="Reject"></span>
			<div class="alert-text">
				<h4 class="alert-heading">
					<span id="showError"><liferay-ui:message
							key="<%=SessionErrors.keySet(renderRequest).iterator().next()%>" /></span>
				</h4>
			</div>
		</div>
	</div>
</c:if>
<c:if
	test="<%=!SessionMessages.isEmpty(renderRequest) && SessionErrors.isEmpty(renderRequest)%>">
	<div class="alert alert-light alert-success-text" role="alert">
		<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
		<div class="alert-box">
			<span><img
				src="<%=themeDisplay.getPathThemeImages()%>/svg/Right.svg"
				alt="Right"></span>
			<div class="alert-text">
				<h4 class="alert-heading">
					<span>
					<liferay-ui:message
							key="<%=SessionMessages.keySet(renderRequest).iterator().next()%>" /></span>
				</h4>
			</div>
		</div>
	</div>
</c:if>

<div class="omsb-card">
	<div class="omsb-page-top-info omsb-program-header-top">
		<div class="pagetitle">
			<liferay-ui:message key="log-procedures" />
		</div>
		<div class="rightbar-info">
			<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADD_LOG_PROCEDURE)}">
				<a class="btn omsb-bg-red-button" href="${addLogProcedures}"> <liferay-ui:message
						key="log-procedure" />
				</a>
			</c:if>
		</div>
	</div>
	<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, VIEW_LOG_PROCEDURE)}">
		<div class="row">
			<div class="col-lg-12 mt-4">
				<div class="tab-content" id="v-pills-tabContent">
					<div class="pill-tab-nav">
						<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
							<li class="nav-item" role="presentation">
								<button class="nav-link active" id="pills-all-tab"
									data-toggle="pill" data-target="#pills-all" type="button"
									role="tab" aria-controls="pills-all" aria-selected="true">
									<liferay-ui:message key="all" />
								</button>
							</li>
							<li class="nav-item" role="presentation">
								<button class="nav-link" id="pills-unconfirmed-tab"
									data-toggle="pill" data-target="#pills-unconfirmed"
									type="button" role="tab" aria-controls="pills-unconfirmed"
									aria-selected="false">
									<liferay-ui:message key="unconfirmed" />
								</button>
							</li>
							<li class="nav-item" role="presentation">
								<button class="nav-link" id="pills-refused-tab"
									data-toggle="pill" data-target="#pills-refused" type="button"
									role="tab" aria-controls="pills-refused" aria-selected="false">
									<liferay-ui:message key="refused" />
								</button>
							</li>
							<li class="nav-item" role="presentation">
								<button class="nav-link" id="pills-notpassed-tab"
									data-toggle="pill" data-target="#pills-notpassed" type="button"
									role="tab" aria-controls="pills-notpassed" aria-selected="false">
									<liferay-ui:message key="not-passed" />
								</button>
							</li>
							<li class="nav-item" role="presentation">
								<button class="nav-link" id="pills-passed-tab" data-toggle="pill"
									data-target="#pills-passed" type="button" role="tab"
									aria-controls="pills-passed" aria-selected="false">
									<liferay-ui:message key="passed" />
								</button>
							</li>
						</ul>
					</div>
					<div class="tab-content" id="pills-tabContent">
						<jsp:include page="/all-procedures-list.jsp" />
						<jsp:include page="/unconfirmed-procedures-list.jsp" />
						<jsp:include page="/refused-procedures-list.jsp" />
						<jsp:include page="/notpassed-procedures-list.jsp" />
						<jsp:include page="/passed-procedures-list.jsp" />
					</div>
				</div>
			</div>
		</div>
	</c:if>
</div>
<jsp:include page="/modal-popup.jsp" />
<script>

$(document).ready(function(){
	
	var tab = `${tab}`;
	var filterStartDate = `${startDate}`;
	var filterEndDate = `${endDate}`;
	
	if(tab) {
		$('#'+tab).click();
	} else {
		tab = 'pills-all-tab';
	}
	
	if(filterStartDate) {
		$('#<portlet:namespace/>'+tab+'_form .filter-start-date').val(filterStartDate);
	}
	
	if(filterEndDate) {
		$('#<portlet:namespace/>'+tab+'_form .filter-end-date').val(filterEndDate);
	}

	$('#logProcedureTable').DataTable({
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
	    ]
	 });
	
	$(document).on("click",".openDeleteModal", function(){
		$('#<portlet:namespace/>deletefm #<portlet:namespace/>traineeLoggedProcedureDetailsId').val($(this).attr('id'));
		$('#<portlet:namespace/>deletefm #<portlet:namespace/>tab').val($(this).data('tab'));
	});

	$(".filter-start-date").datepicker({
		format: 'dd-mm-yyyy',
		startDate: new Date('1900-1-1'),
		autoclose: true,
		todayBtn: true,
		todayHighlight: true
	});
	
	$(".filter-end-date").datepicker({
		format: 'dd-mm-yyyy',
		startDate: new Date('1900-1-1'),
		autoclose: true,
		todayBtn: true,
		todayHighlight: true
	});
	
	$(".filter-start-date").on("change", function() {
		$(this).closest('form').submit();
	});
	
	$(".filter-end-date").on("change", function() {
		$(this).closest('form').submit();
	});
	
	$(".modal-backdrop").remove();
});
</script>