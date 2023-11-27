<!DOCTYPE html>

<#include init />

<html class="${root_css_class} " data-preloader="enable" data-sidebar="gradient" data-sidebar-image="img-3" data-layout="vertical" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${html_title}</title>
	<meta charset="utf-8">
	<meta content="initial-scale=1.0, width=device-width" name="viewport" />

	<@liferay_util["include"] page=top_head_include />

	<#include "${full_templates_path}/pre_load_js.ftl" />

</head>

<#if permissionChecker.isOmniadmin()>
<#assign admin_class="control-theme"/>
<#else>
<#assign admin_class=""/>
</#if>
<body class="${css_class} ${admin_class}">

<@liferay_ui["quick-access"] contentId="#main-content" />

<@liferay_util["include"] page=body_top_include />

<@liferay.control_menu />





<div class="user-page-content container-fluid position-relatives p-0" id="wrapper" data-filename="">

	<#if !is_signed_in>
		<#include "${full_templates_path}/pre_login_header.ftl" />
	<#else>
		<#include "${full_templates_path}/header.ftl" />
	</#if>



	<section id="content">
		<h2 class="hide-accessible sr-only" role="heading" aria-level="1">${the_title}</h2>
		<#if is_signed_in>
<!--breadcrumb -->
<div class="row">
	<div class="col-12">
		<div class="portlet-layout page-title-box d-sm-flex align-items-center justify-content-between">
			<div class="page-title-left">
				<ol class="breadcrumb m-0">
					<li class="breadcrumb-item ng-star-inserted">
						<a href="${company_url}" ><@liferay.language key="home" /></a>
					</li>
					<li class="breadcrumb-item active ng-star-inserted">
						<span class="ng-star-inserted">${the_title}</span>
					</li>
				</ol>
			</div>
			<h4 class="mb-sm-0 d-none">${the_title}</h4>
			<div class="user_notifications">
				<@liferay_portlet["runtime"]
					portletName="com_omsb_tms_notification_web_NotificationPortlet"
				/>
			</div>
		</div>
	</div>
</div>
<!--breadcrumb -->
</#if>
		<#if selectable>
			<@liferay_util["include"] page=content_include />
		<#else>
			${portletDisplay.recycle()}

			${portletDisplay.setTitle(the_title)}

			<@liferay_theme["wrap-portlet"] page="portlet.ftl">
				<@liferay_util["include"] page=content_include />
			</@>
		</#if>
	
		
	</section>
	<button onclick="topFunction()" class="btn btn-danger-not btn-icon back-to-top" id="back-to-top" style="display: none;">
        <i class="ri-arrow-up-line"></i>
    </button>


	<div id="preloader" class="d-none" style="">
        <div id="status">
           <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" style="margin:auto;background:transparent;display:block;" width="200px" height="200px" viewBox="0 0 100 100" preserveAspectRatio="xMidYMid">
				<circle cx="50" cy="50" r="0" fill="none" stroke="#008100" stroke-width="2">
				  <animate attributeName="r" repeatCount="indefinite" dur="1.3513513513513513s" values="0;40" keyTimes="0;1" keySplines="0 0.2 0.8 1" calcMode="spline" begin="0s"></animate>
				  <animate attributeName="opacity" repeatCount="indefinite" dur="1.3513513513513513s" values="1;0" keyTimes="0;1" keySplines="0.2 0 0.8 1" calcMode="spline" begin="0s"></animate>
				</circle><circle cx="50" cy="50" r="0" fill="none" stroke="#dc0e14" stroke-width="2">
				  <animate attributeName="r" repeatCount="indefinite" dur="1.3513513513513513s" values="0;40" keyTimes="0;1" keySplines="0 0.2 0.8 1" calcMode="spline" begin="-0.6756756756756757s"></animate>
				  <animate attributeName="opacity" repeatCount="indefinite" dur="1.3513513513513513s" values="1;0" keyTimes="0;1" keySplines="0.2 0 0.8 1" calcMode="spline" begin="-0.6756756756756757s"></animate>
				</circle>
			</svg>
        </div>
    </div>
	

	<footer id="footer" role="contentinfo" class="d-none">
		<p class="powered-by">
			<@liferay.language_format
				arguments='<a href="http://www.liferay.com" rel="external">Liferay</a>'
				key="powered-by-x"
			/>
		</p>
	</footer>
</div>

<@liferay_util["include"] page=body_bottom_include />

<@liferay_util["include"] page=bottom_include />

<#include "${full_templates_path}/after_load_js.ftl" />

</body>

</html>