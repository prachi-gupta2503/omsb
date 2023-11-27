<header id="banner" role="banner">
	<nav  id="navbar" class="navbar p-0 navbar-expand-xl navbar-landing">
		<div  class="container-fluid d-flex flex-column p-0 navbar-custom" id="heading">
			<div  class="navbar-brand d-flex justify-content-between w-100 px-4 py-2">
				<div  class="d-flex ">
					<div>
						<a class="${logo_css_class}" href="${site_default_url}" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
							<#--<img alt="king" class="mx-5 rounded-circle" src="${images_folder}/king_image.png"/> 
							<img alt="${logo_description}" height="${site_logo_height}" src="${site_logo}" width="${site_logo_width}" />-->
							<img alt="${logo_description}" height="${site_logo_height}" src="${images_folder}/logo.png" width="${site_logo_width}" />
						</a>
					</div>
					<#if show_site_name>
					<div  class="d-flex flex-column align-items-center justify-content-center">
						<h3  class="heading text-white p-3" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />" >${site_name}</h3>
					</div>
					</#if>
					
				</div>
				<#if !is_signed_in>
				<div  class="d-flex signIn-button">
					<a data-redirect="${is_login_redirect_required?string}" href="/login" class="btn btn-custom my-auto" id="sign-in" rel="nofollow">${sign_in_text}</a>
				</div>
				</#if>
			</div>
			
			<#if has_navigation && is_setup_complete>
			<#-- <#include "${full_templates_path}/pre_login_navigation.ftl" /> -->
			</#if>
			<div class="navbar-menu d-none"></div>
			
		</div>
	</nav>
</header>
<style>
.user-page-content #content {
  width: unset;
  margin-left: unset;
  margin-top: unset;
}

.portlet-language {
    display: none;
}
</style>