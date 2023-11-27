<%@ include file="/init.jsp"%>

<style>
#dashboard{
	width: 100%;
	height: 100vh;
	opacity: 0;
}

#dashboard.visible{
	opacity: 1;
}
</style>

<c:if test="${isError}">
        <div class="alert alert-light alert-danger-text" role="alert">
		<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
		<div class="alert-box">
			<span><img src="<%= themeDisplay.getPathThemeImages() %>/svg/reject.svg" alt="reject"></span>
			<div class="alert-text">
				<h4 class="alert-heading"><span><liferay-ui:message key="${errorMessage}" /></span></h4>
			</div>
		</div>
	</div>
</c:if>

<div id="root"></div>
<div id="dashboard"></div>
<div class="loader-container loaded">
	<div class="loader"><img src="<%= themeDisplay.getPathThemeImages() %>/svg/loader.svg" alt="loader"></div>
</div>

<script>
if(${isError}){
	document.querySelector(".loader-container").classList.add("d-none");
}
</script>