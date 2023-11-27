<%@ include file="init.jsp"%>
<portlet:resourceURL id="<%=OmsbTrainingSitesWebPortletKeys.TRAINING_SITES_LIST_MVC_RESOURCE_COMMAND%>" var="trainingSitesList" />

<portlet:renderURL var="addTrainingSite">
    <portlet:param name="mvcRenderCommandName" value="<%=OmsbTrainingSitesWebPortletKeys.TRAINING_SITE_ADD_MVC_RENDER_COMMAND%>" />
</portlet:renderURL>

<!-- Inner Wrapper Contents -->
<div class="omsb-page-top-info omsb-program-header-top">
	<div class="pagetitle"> <liferay-ui:message key="training-sites" /> </div>
	<div class="rightbar-info">
		<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_ADD_TRAINING_SITE)}">
			<a class="btn omsb-bg-red-button"  href="${addTrainingSite}" >
				 <img src="${themeDisplay.getPathThemeImages()}/svg/plus_img.svg" alt=""> <liferay-ui:message key="add-training-site" />
			</a>
			<div class="switch">
				<div class="custom-control custom-switch">
					<input type="checkbox" class="custom-control-input" id="switch2" name="example"> 
					<label class="custom-control-label" for="switch2"> 
						<span class="active"><liferay-ui:message key="active" /></span> 
						<span class="inactive"><liferay-ui:message key="inactive" /></span>
					</label>
				</div>
			</div>
		</c:if>
	</div>
</div>

<div class="omsb-cards-wrap">
	<div class="row" id="training-row">
	</div>
</div>

<script>
	$(document).ready(function() {
		$("#switch2").prop('checked', true);
		let trainingSiteStatus = true;
		loadTrainingSitesCard(trainingSiteStatus, '${trainingSitesList}');
		$(".modal-backdrop").remove();
	});

	$('#switch2').change(function() {
		loadTrainingSitesCard(this.checked, '${trainingSitesList}');
	});

	function loadTrainingSitesCard(trainingSiteStatus, resourceCommandUrl) {
		$.ajax({
			url : resourceCommandUrl,
			type : 'POST',
			data : {
				<portlet:namespace/>trainingSiteStatus : trainingSiteStatus
			},
			success : function(payload) {
				let trainingCard = '';
					if(payload.result.length > 0) {
					let div = '<div class="col-md-6 col-sm-6 col-xs-12 mb-cst">';
					let a2 = '" class="trans" title="">';
					let innderDiv = '<div class="card-info black-info-card">';
					let h5 = '<h5>';
					for (let i = 0; i < payload.result.length; i++) {
						trainingCard = trainingCard + div  + '<a href="' + payload.result[i].renderUrl + a2 + innderDiv + h5 + payload.result[i].trainingSiteName + "</h5></div></a></div>";
					}
				} else {
					trainingCard = '<div class="col-md-12"><div class="omsb-no-data-found"><p>No Such Training Site Found.</p></div></div>';
				}
				$('#training-row').html(trainingCard);
			}
		});
	}
</script>