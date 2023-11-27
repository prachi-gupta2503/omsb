<%@ include file="init.jsp"%>
<portlet:resourceURL id="<%=OmsbRotationsWebPortletKeys.ROTATION_LIST_MVC_RESOURCE_COMMAND%>" var="rotationsList" />

<portlet:renderURL var="addRotation">
    <portlet:param name="mvcRenderCommandName" value="<%=OmsbRotationsWebPortletKeys.ROTATION_ADD_MVC_RENDER_COMMAND%>" />
</portlet:renderURL>

<!-- Inner Wrapper Contents -->
<div class="omsb-page-top-info omsb-program-header-top">
	<div class="pagetitle"> <liferay-ui:message key="rotations" /> </div>
	<div class="rightbar-info">
		<c:if test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADMIN_ADD_ROTATION)}">
			<a class="btn omsb-bg-red-button"  href="${addRotation}" >
				<img src="${themeDisplay.getPathThemeImages()}/svg/plus_img.svg" alt=""> <liferay-ui:message key="add-rotation" />
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
	<div class="row" id="rotation-row">
	
	</div>
</div>
<script>
	$(document).ready(function() {
		$("#switch2").prop('checked', true);
		loadRotationCard(true, '${rotationsList}');
		$(".modal-backdrop").remove();
	});
	
	$('#switch2').change(function() {
		loadRotationCard(this.checked, '${rotationsList}');
	});

	function loadRotationCard(rotationStatus, resourceCommandUrl) {
		$.ajax({
			url : resourceCommandUrl,
			type : 'POST',
			data : {
				<portlet:namespace/>rotationStatus : rotationStatus
			},
			success : function(payload) {
				let rotationCard = '';
				if(payload.result.length > 0) {
					let div = '<div class="col-md-6 col-sm-6 col-xs-12 mb-cst">';
					let a2 = '" class="trans" title="">';
					let innderDiv = '<div class="card-info black-info-card">';
					let h5 = '<h5>';
					for (let i = 0; i < payload.result.length; i++) {
						rotationCard = rotationCard + div  + '<a href="' + payload.result[i].renderUrl + a2 + innderDiv + h5 + payload.result[i].rotationName + "</h5></div></a></div>";
					}
				} else {
					rotationCard = '<div class="col-md-12"><div class="omsb-no-data-found"><p>No Such Rotations Found.</p></div></div>';
				}
				
				$('#rotation-row').html(rotationCard);
			}
		});
	}
</script>