<%@ include file="init.jsp"%>
<%@page import="java.util.Iterator"%>
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

<div class="display-msg">

</div>

<%-- <div class="loader-container loaded d-flex">
     <div class="loader"><img src="${themeDisplay.getPathThemeImages()}/svg/loader.svg" alt="loader"></div>
</div> --%>
<div class="omsb-card">
	<div class="omsb-page-top-info">
		<div class="pagetitle">
			<liferay-ui:message key="procedure-setup" />
		</div>
	</div>
	<div class="row">
		<div class="col-lg-12">
			<ul class="nav nav-pills omsb-nav-pills justify-content-center"
				id="myTab" role="tablist">
				<li class="nav-item">
					<a class="nav-link active"
						id="procedureloggingparameters-tab" data-toggle="tab"
						href="#procedureloggingparameters" role="tab"
						aria-controls="procedureloggingparameters" aria-selected="true" 
						onclick="
							$('.loader-container').addClass('d-flex').removeClass('d-none');
							resetForm('<portlet:namespace/>form-role');
							resetForm('<portlet:namespace/>form-patient');
							resetForm('<portlet:namespace/>form-visit');resetProgramDurationDD();
							location.replace('${defaultRenderURL}');">
							<liferay-ui:message key="procedure-logging-parameters" />
					</a>
				</li>
				<li class="nav-item"><a class="nav-link"
					id="configureprocedures-tab" data-toggle="tab"
					href="#configureprocedures" role="tab"
					aria-controls="configureprocedures" aria-selected="false" onclick="resetForm('<portlet:namespace/>saveConfigureProcedureForm');resetProgramDurationDD();" ><liferay-ui:message
							key="configure-procedures" /></a></li>
			</ul>
		</div>
		<div class="col-lg-12 mt-4">
			<div class="tab-content" id="v-pills-tabContent">
				<div class="tab-pane fade show active"
					id="procedureloggingparameters" role="tabpanel"
					aria-labelledby="procedureloggingparameters-tab">

					<div class="pill-tab-nav">
						<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
							<li class="nav-item" role="presentation">
								<button class="nav-link active" id="pills-roletype-tab"
									data-toggle="pill" data-target="#pills-roletype" type="button"
									role="tab" aria-controls="pills-roletype" aria-selected="true" onclick="resetForm('<portlet:namespace/>form-patient');resetForm('<portlet:namespace/>form-visit');resetProgramDurationDD();">
									<liferay-ui:message key="role-type" />
								</button>
							</li>
							<li class="nav-item" role="presentation">
								<button class="nav-link" id="pills-patienttype-tab"
									data-toggle="pill" data-target="#pills-patienttype"
									type="button" role="tab" aria-controls="pills-patienttype"
									aria-selected="false" onclick="resetForm('<portlet:namespace/>form-role');resetForm('<portlet:namespace/>form-visit');resetProgramDurationDD();">
									<liferay-ui:message key="patient-type" />
								</button>
							</li>
							<li class="nav-item" role="presentation">
								<button class="nav-link" id="pills-visittype-tab"
                                    data-toggle="pill" data-target="#pills-visittype" type="button"
                                    role="tab" aria-controls="pills-visittype"
                                    aria-selected="false" onclick="resetForm('<portlet:namespace/>form-role');resetForm('<portlet:namespace/>form-patient');resetForm('<portlet:namespace/>saveConfigureProcedureForm');resetProgramDurationDD();">
										<liferay-ui:message key="visit-type" />
								</button>
							</li>
						</ul>
					</div>
					<div class="tab-content" id="pills-tabContent">
						<jsp:include page="/role-type.jsp" />
						<jsp:include page="/patient-type.jsp" />
						<jsp:include page="/visit-type.jsp" />
					</div>
				</div>
				<div class="tab-pane fade" id="configureprocedures" role="tabpanel" 
					aria-labelledby="configureprocedures-tab">
					<jsp:include page="/configure-procedures.jsp" />
				</div>
			</div>
		</div>
	</div>
</div>

<script>
$(".modal-backdrop").remove();
$( document ).ready(function() {
	clickProcedureTab('${masterName}');
});

</script>