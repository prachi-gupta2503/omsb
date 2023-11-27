<!DOCTYPE html>

<#include init />

<html lang="en" class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${html_title}</title>

	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=0">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

	<@liferay_util["include"] page=top_head_include />

	<#include "${full_templates_path}/before_load_js.ftl" />
</head>

<body class="${css_class}">

<@liferay_ui["quick-access"] contentId="#main-content" />

<@liferay_util["include"] page=body_top_include />

<@liferay.control_menu />

	<div class="main-content">
		
		<div class="d-flex flex-column min-vh-100">
			
			<div class="d-flex flex-column flex-fill position-relative" id="wrapper">
				<header id="banner" class="omsb-header" role="banner">

					<div class="omsb-top-header">
						<div class="container">
							<div class="omsb-top-header-row">
								<div class="leftbar">
									<div class="buttons-wrap">
										<div class="button-col"><button class="btn "><i class="fa fa-microphone"></i> Voice</button></div>
										<div class="button-col"><button class="btn bw-button"><i class="fa fa-eye-slash"></i> Special colors</button></div>
										<div class="button-col"><button class="btn fontsizer" data-font-size="increase">A<i class="fa fa-plus sup"></i></button></div>
										<div class="button-col"><button class="btn fontsizer" data-font-size="decrease">A<i class="fa fa-minus sup"></i></button></div>
										<div class="button-col"><button class="btn "><i class="fa fa-sitemap"></i></button></div>
									</div>
								</div>
								<div class="rightbar">
									<div class="social-links-wrap">
										<div class="social-link"><a href="#" class="trans" title="Facebook"><img src="${images_folder}/svg/fb.svg"></a></div>
										<div class="social-link"><a href="#" class="trans" title="linkedin"><img src="${images_folder}/svg/linkedin.svg"></a></div>
										<div class="social-link"><a href="#" class="trans" title="Twitter"><img src="${images_folder}/svg/twitter.svg"></a></div>
										<div class="social-link"><a href="#" class="trans" title="Youtube"><img src="${images_folder}/svg/youtube.svg"></a></div>
										
									</div>
								</div>
							</div>
				
						</div>
					</div>
					<!--// End Top Header-->

					<#if themeDisplay.isSignedIn()>
					
					<div class="omsb-main-header">
						<div class="container">
							<div class="omsb-main-header-wrap">
								<div class="leftbar">
									<div class="humber-menu">
										
									</div>
									<a class="${logo_css_class}" href="${site_default_url}" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
										<div class="omsb-brand-logo">
											<img alt="${logo_description}" height="${site_logo_height}" src="${site_logo}" width="${site_logo_width}" />
											<div class="logo-texts">
												<span class="logo-text-arabic">المجلس العماني للاختصاصات الطبية </span>
												<span class="logo-text-english">Oman Medical Specialty Board</span>
											</div>
										</div>
									</a>
									
									
				
									<#if has_navigation && is_setup_complete>
										<#include "${full_templates_path}/navigation.ftl" />
									</#if>
				
								</div>
								<div class="rightbar">
									<div class="buttons-wrap">
										<div class="button-col">
											<div class="custom-control custom-switch">
												<label class="first-label" for="lang-selector" >English</label>										
												<input type="checkbox" class="custom-control-input" id="lang-selector" name="example">
												<label class="custom-control-label second-label" for="lang-selector">العربية</label>
											</div>
										</div>
										<#if themeDisplay.isSignedIn()>
											<div class="button-col">
												<a href="${server_url}/group/guest/notification" class="notification-block" title="Notifications">
													<span class="notification-alert"></span>
												</a>
											</div>
											<div class="button-col">
												<button type="button" class="profile-dtls dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" title="User Profile"><img class="profile-pic" src="${images_folder}/svg/profile.svg"></button>
												<ul class="profile-menu dropdown-menu">
													<li><a href="/group/guest/my-profile" class="dropdown-item"><@liferay.language key="my-profile" /></a>
														</li>
													<li><a href="/group/guest/my-workflow-tasks" class="dropdown-item"><@liferay.language key="my-workflow-tasks" /></a>
														</li>
													<li><a href="/c/portal/logout" class="dropdown-item"><@liferay.language key="eportal-logout" /></a>
														</li>
											</div>
										</#if>
									</div>
								</div>
							</div>
						</div>
					</div>
					
					</#if>
					
				</header>

				<!--- Start Main Content Section Here --->
				<section class="omsb-main-wrapper" id="omsb-main-wrapper">
				
				<#if themeDisplay.isSignedIn()>
					<!-- breadcrumbs -->
					<div class="omsb-breadcrumbs">
						<div class="container ">
							<div class="omsb-breadcrumbs-wrap">
								<div class="leftbar">
									<div class="breadcrumb-link">
										<ul>
											<li><a href="#" class="trans" title="Home">Home</a></li>
											<li>${the_title}</li>
										</ul>
									</div>
								</div>

							</div>
						</div>
					</div>
					<!-- breadcrumbs -->
				</#if>

					<section class="${portal_content_css_class} flex-fill" id="content">
						<h2 class="sr-only">${htmlUtil.escape(the_title)}</h2>

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

				</section>
				<#if show_footer>
					<!-- footer -->
					<div class="omsb-footer">
						<div class="container">
							<div class="row">
								<div class="col-md-12 ">
									<p class="copyright">&copy; Copyright 2023 All rights reserved to Oman medical specialty board</p>
								</div>
							</div>
						</div>
					</div>
					<!-- footer -->
				</#if>
			</div>
		</div>
	
	</div>
	<@liferay_util["include"] page=body_bottom_include />
	<@liferay_util["include"] page=bottom_include />
	<#include "${full_templates_path}/after_load_js.ftl" />
</body>

</html>