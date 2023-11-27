<%@ include file="/init.jsp" %>
<style>
	.procedure-master-name {
		color: #DC3545 !important;
		text-decoration: underline !important;
	}
</style>
<div class="omsb-card">
	<div class="omsb-page-top-info m-0">
		<div class="omsb-page-top-info">
			<div class="pagetitle"><liferay-ui:message key="confirm-procedures" /></div>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-12 mt-4">
			<div class="tab-content" id="v-pills-tabContent">
				<div class="pill-tab-nav">
					<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
						<li class="nav-item" role="presentation">
							<button class="nav-link active" id="pills-all-tab"
								data-toggle="pill" data-target="#pills-all" type="button"
								role="tab" aria-controls="pills-all" aria-selected="true" >
								<liferay-ui:message key="all" />
							</button>
						</li>
						<li class="nav-item" role="presentation">
							<button class="nav-link" id="pills-unconfirmed-tab"
								data-toggle="pill" data-target="#pills-unconfirmed"
								type="button" role="tab" aria-controls="pills-unconfirmed"
								aria-selected="false" >
								<liferay-ui:message key="unconfirmed" />
							</button>
						</li>
						<li class="nav-item" role="presentation">
							<button class="nav-link" id="pills-refused-tab"
								data-toggle="pill" data-target="#pills-refused" type="button"
								role="tab" aria-controls="pills-refused"
								aria-selected="false" >
								<liferay-ui:message key="refused" />
							</button>
						</li>
						<li class="nav-item" role="presentation">
							<button class="nav-link" id="pills-notpassed-tab"
								data-toggle="pill" data-target="#pills-notpassed"
								type="button" role="tab" aria-controls="pills-notpassed"
								aria-selected="false">
								<liferay-ui:message key="not-passed" />
							</button>
						</li>
						<li class="nav-item" role="presentation">
							<button class="nav-link" id="pills-passed-tab"
								data-toggle="pill" data-target="#pills-passed" type="button"
								role="tab" aria-controls="pills-passed"
								aria-selected="false">
								<liferay-ui:message key="passed" />
							</button>
						</li>
					</ul>
				</div>
				<div class="tab-content" id="pills-tabContent">
					<jsp:include page="/all-procedures-list-supervisor.jsp" />
					<jsp:include page="/unconfirmed-procedures-list-supervisor.jsp" />
					<jsp:include page="/refused-procedures-list-supervisor.jsp" />
					<jsp:include page="/notpassed-procedures-list-supervisor.jsp" />
					<jsp:include page="/passed-procedures-list-supervisor.jsp" />
				</div>
			</div>
		</div>
	</div>
</div>

<jsp:include page="/model-popup.jsp" />
<jsp:include page="/notification-sidebar.jsp" />
<script>
$(document).ready(function(){
	var tab = `${tab}`;
	if(tab) {
		$('#'+tab).click();
	}
});
</script>
<script src="<%=request.getContextPath()%>/css/custom_procedures.js" ></script>