
	<header  id="page-topbar">
		<div  class="layout-width">
			<div  class="navbar-header">
				<div  class="d-flex">
					<div  class="navbar-brand-box mt-3 horizontal-logo d-none">
						<a  href="" class="logo logo-dark">
							<span  class="logo-sm">
								<img  src="${images_folder}/logo.png" alt="" height="50">
							</span>
							<span  class="logo-lg">
								<img  src="${images_folder}/logo.png" alt="" height="17">
							</span>
						</a>
						<a  href="" class="logo logo-light">
							<span  class="logo-sm">
								<img  src="${images_folder}/logo.png" alt="" height="50">
							</span>
							<span  class="logo-lg">
								<img  src="${images_folder}/logo.png" alt="" height="17">
							</span>y
						</a>
					</div>
					<button  type="button" id="topnav-hamburger-icon" class="btn btn-sm px-3 fs-16 header-item vertical-menu-btn topnav-hamburger">
					<span  class="hamburger-icon closed">
						<span >
						</span>
						<span >
						</span>
						<span >
						</span>
					</span>
					</button>
				</div>
				<div  class="d-flex align-items-center">
					<div class="language-selector">
						<@liferay_portlet["runtime"]   portletName="com_liferay_site_navigation_language_web_portlet_SiteNavigationLanguagePortlet"/>
					</div>
					<div class="d-flex align-items-center font-select ">
						<a  href="#" class="ri-font-sized fontsizer normal" title="Font Decreaser" data-font-size="decrease">
						<i class="mdi mdi-format-font-size-decrease"></i>
						</a>
						
						<a  href="#" class="ri-font-sized fontsizer large" title="Font Increaser" data-font-size="increase">
						<i class="mdi mdi-format-font-size-increase"></i>
						</a>
					</div>
					<div  ngbdropdown="" class="d-none topbar-head-dropdown header-item dropdown">
						<button  type="button" id="page-header-search-dropdown" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false" ngbdropdowntoggle="" class="dropdown-toggle btn btn-icon btn-topbar btn-ghost-secondary rounded-circle">
						<i  class="bx bx-search fs-22">
						</i>
						</button>
						<div  aria-labelledby="page-header-search-dropdown" ngbdropdownmenu="" class="dropdown-menu dropdown-menu-lg dropdown-menu-end p-0 d-nones" x-placement="bottom-left">
							<form  novalidate="" class="p-3 ng-untouched ng-pristine ng-valid">
								<div  class="form-group m-0">
									<div  class="input-group">
										<input  type="text" placeholder="Search ..." aria-label="Recipient's username" class="form-control">
										<button  type="submit" class="btn btn-primary">
										<i  class="mdi mdi-magnify">
										</i>
										</button>
									</div>
								</div>
							</form>
						</div>
					</div>
					<div  class="ms-1 header-item  d-sm-flex">
						<button  type="button" data-toggle="fullscreen" class="btn btn-icon btn-topbar btn-ghost-secondary rounded-circle">
						<i  class="bx bx-fullscreen fs-22">
						</i>
						</button>
					</div>
					<div class="ms-1 header-item d-sm-flex">
	                    <button type="button" class="btn btn-icon btn-topbar btn-ghost-secondary rounded-circle omsb-light-dark-mode">
	                        <i class="bx bx-moon fs-22"></i>
	                    </button>
	                </div>
					<!-- <div  class="ms-1 header-item">
						<div  class="form-check form-switch form-switch-md">
							<input  type="checkbox" role="switch" id="rtl-checked1" class="form-check-input ng-untouched ng-pristine ng-valid">
							<label  for="rtl-checked" class="form-check-label">RTL</label>
						</div>
					</div> 

				onclick="window.location.href='${themeDisplay.getPortalURL()}/manage?p_p_id=com_liferay_notifications_web_portlet_NotificationsPortlet&p_p_lifecycle=0&p_p_auth=wWfkZOnp';"

			-->
					<div  ngbdropdown="" class="topbar-head-dropdown ms-1 header-item dropdown d-none">
						<button  type="button" id="page-header-notifications-dropdown" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false" ngbdropdowntoggle="" class="dropdown-toggle btn btn-icon btn-topbar btn-ghost-secondary rounded-circle">
							<i  class="bx bx-bell fs-22">
							</i>
							<span  class="position-absolute topbar-badge fs-10 translate-middle badge rounded-pill bg-danger">3<span  class="visually-hidden">unread messages</span>
							</span>
						</button>
					<div  aria-labelledby="page-header-notifications-dropdown" ngbdropdownmenu="" class="dropdown-menu dropdown-menu-lg dropdown-menu-end p-0" x-placement="bottom-left">
						<div  class="dropdown-head bg-primary bg-pattern rounded-top">
							<div  class="p-3">
								<div  class="row align-items-center">
									<div  class="col">
										<h6  class="m-0 fs-16 fw-semibold text-white"> Notifications </h6>
									</div>
									<div  class="col-auto dropdown-tabs">
										<span  class="badge badge-soft-light fs-13"> 4 New</span>
									</div>
								</div>
							</div>
							<div  class="px-2 pt-2">
								<ul  ngbnav="" id="notificationItemsTab" class="nav nav-tabs dropdown-tabs nav-tabs-custom" role="tablist">
									<li  class="nav-item">
										<a  href="" ngbnavlink="" id="ngb-nav-3" role="tab" aria-controls="ngb-nav-3-panel" aria-selected="true" aria-disabled="false" class="nav-link active"> All (4) </a>
									</li>
									<li  class="nav-item">
										<a  href="" ngbnavlink="" id="ngb-nav-4" role="tab" aria-selected="false" aria-disabled="false" class="nav-link"> Alerts </a>
									</li>
								</ul>
							</div>
						</div>
						<div  id="notificationItemsTabContent" class="tab-content">
							<div  class="tab-content text-muted">
								<div  class="tab-content">
									<div ngbnavpane="" class="tab-pane fade show active" id="ngb-nav-3-panel" role="tabpanel" aria-labelledby="ngb-nav-3">
										<div  id="all-noti-tab" role="tabpanel" class="tab-pane fade show active py-2 ps-2">
											<ngx-simplebar  data-simplebar="init" style="max-height: 300px;">
											<div class="simplebar-wrapper" style="margin: 0px;">
												<div class="simplebar-height-auto-observer-wrapper">
													<div class="simplebar-height-auto-observer">
														
													</div>
												</div>
												<div class="simplebar-mask">
													<div class="simplebar-offset" style="right: 0px; bottom: 0px;">
														<div class="simplebar-content-wrapper" tabindex="0" role="region" aria-label="scrollable content" style="height: auto; overflow: hidden;">
															<div class="simplebar-content" style="padding: 0px;">
																<div  class="pe-2">
																	<div  class="text-reset notification-item d-block dropdown-item position-relative">
																		<div  class="d-flex">
																			<div  class="avatar-xs me-3">
																				<span  class="avatar-title bg-soft-info text-info rounded-circle fs-16">
																					<i  class="bx bx-badge-check">
																					</i>
																				</span>
																			</div>
																			<div  class="flex-1">
																				<a  href="javascript:void(0);" class="stretched-link">
																					<h6  class="mt-0 mb-2 lh-base">Your <b >Elite</b> author Graphic Optimization <span  class="text-secondary">reward</span> is ready! </h6>
																				</a>
																				<p  class="mb-0 fs-11 fw-medium text-uppercase text-muted">
																					<span >
																						<i  class="mdi mdi-clock-outline">
																					</i> Just 30 sec ago</span>
																				</p>
																			</div>
																			<div  class="px-2 fs-15">
																				<input  type="checkbox" class="form-check-input">
																			</div>
																		</div>
																	</div>
																	<div  class="text-reset notification-item d-block dropdown-item position-relative">
																		<div  class="d-flex">
																			<img  src="o/omsb-theme/images/users/avatar-2.jpg" alt="user-pic" class="me-3 rounded-circle avatar-xs">
																			<div  class="flex-1">
																				<a  href="javascript:void(0);" class="stretched-link">
																					<h6  class="mt-0 mb-1 fs-13 fw-semibold">Angela Bernier</h6>
																				</a>
																				<div  class="fs-13 text-muted">
																					<p  class="mb-1">Answered to your comment on the cash flow forecast's graph 🔔.</p>
																				</div>
																				<p  class="mb-0 fs-11 fw-medium text-uppercase text-muted">
																					<span >
																						<i  class="mdi mdi-clock-outline">
																					</i> 48 min ago</span>
																				</p>
																			</div>
																			<div  class="px-2 fs-15">
																				<input  type="checkbox" class="form-check-input">
																			</div>
																		</div>
																	</div>
																	<div  class="text-reset notification-item d-block dropdown-item position-relative">
																		<div  class="d-flex">
																			<div  class="avatar-xs me-3">
																				<span  class="avatar-title bg-soft-danger text-danger rounded-circle fs-16">
																					<i  class="bx bx-message-square-dots">
																					</i>
																				</span>
																			</div>
																			<div  class="flex-1">
																				<a  href="javascript:void(0);" class="stretched-link">
																					<h6  class="mt-0 mb-2 fs-13 lh-base">You have received <b  class="text-success">20</b> new messages in the conversation</h6>
																				</a>
																				<p  class="mb-0 fs-11 fw-medium text-uppercase text-muted">
																					<span >
																						<i  class="mdi mdi-clock-outline">
																					</i> 2 hrs ago</span>
																				</p>
																			</div>
																			<div  class="px-2 fs-15">
																				<input  type="checkbox" class="form-check-input">
																			</div>
																		</div>
																	</div>
																	<div  class="text-reset notification-item d-block dropdown-item position-relative">
																		<div  class="d-flex">
																			<img  src="o/omsb-theme/images/users/avatar-8.jpg" alt="user-pic" class="me-3 rounded-circle avatar-xs">
																			<div  class="flex-1">
																				<a  href="javascript:void(0);" class="stretched-link">
																					<h6  class="mt-0 mb-1 fs-13 fw-semibold">Maureen Gibson</h6>
																				</a>
																				<div  class="fs-13 text-muted">
																					<p  class="mb-1">We talked about a project on linkedin.</p>
																				</div>
																				<p  class="mb-0 fs-11 fw-medium text-uppercase text-muted">
																					<span >
																						<i  class="mdi mdi-clock-outline">
																					</i> 4 hrs ago</span>
																				</p>
																			</div>
																			<div  class="px-2 fs-15">
																				<input  type="checkbox" class="form-check-input">
																			</div>
																		</div>
																	</div>
																	<div  class="my-3 text-center">
																		<button  type="button" class="btn btn-soft-success waves-effect waves-light">View All Notifications <i  class="ri-arrow-right-line align-middle">
																		</i>
																		</button>
																	</div>
																</div>
															</div>
														</div>
													</div>
												</div>
												<div class="simplebar-placeholder" style="width: 0px; height: 0px;">
												</div>
											</div>
											<div class="simplebar-track simplebar-horizontal" style="visibility: hidden;">
												<div class="simplebar-scrollbar" style="width: 0px; display: none;">
												</div>
											</div>
											<div class="simplebar-track simplebar-vertical" style="visibility: hidden;">
												<div class="simplebar-scrollbar" style="height: 0px; display: none;">
												</div>
											</div>
											</ngx-simplebar>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div  ngbdropdown="" class="ms-sm-3 header-item topbar-user dropdown">
					<button  type="button" id="page-header-user-dropdown" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false" ngbdropdowntoggle="" class="dropdown-toggle btn btn-ghost-secondary">
					<span  class="d-flex align-items-center">
					<i class="ri-user-fill header-profile-user fs-32"></i>
					
						<img  src="${images_folder}/users/avatar-1.jpg" alt="Header Avatar" class="rounded-circle header-profile-user d-none">
						<span  class="text-start ms-xl-2">
							<span  class="d-none d-xl-inline-block ms-1 fw-medium user-name-text">${user_first_name}</span>
						</span>
					</span>
					</button>
					<div  ngbdropdownmenu="" class="dropdown-menu dropdown-menu-end" x-placement="bottom-left">
						<h6  class="dropdown-header d-none">Welcome Abbas!</h6>
						<a  href="/profile" class="dropdown-item">
							<i  class="mdi mdi-account-circle text-muted fs-16 align-middle me-1">
							</i>
							<span  class="align-middle">Profile</span>
						</a>
						<a  href="/c/portal/logout" class="dropdown-item">
							<i  class="mdi mdi-logout text-muted fs-16 align-middle me-1">
							</i>
							<span  data-key="t-logout" class="align-middle">Logout</span>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</header>

<div class="app-menu navbar-menu d-noness"><!-- LOGO -->
	<div class="navbar-brand-box"><!-- Dark Logo-->
	<a href="${site_default_url}" class="logo logo-dark">
		<span class="logo-sm">
			<img src="${images_folder}/logo.png" alt="" height="60">
		</span>
		<span class="logo-lg">
		<img src="${images_folder}/logo.png" alt="" height="100">
		</span> </a> <!-- Light Logo-->
		<a href="${site_default_url}" class="logo logo-light">
			<span class="logo-sm">
				<img src="${images_folder}/logo.png" alt="" height="50">
			</span>
			<span class="logo-lg">
				<img src="${images_folder}/logo.png" alt="" height="100">
			</span>
		</a>
		<button type="button" class="btn btn-sm p-0 fs-20 header-item float-end btn-vertical-sm-hover" id="vertical-hover"> <i class="ri-record-circle-line"></i> </button>
	</div>
	<div id="scrollbar">
		<div class="container-fluid">
			<div id="two-column-menu">
			</div>
	<#if has_navigation && is_setup_complete>
		<#include "${full_templates_path}/navigation_new_dynamic.ftl" />
	</#if>

		</div> <!-- Sidebar -->

	</div>
	<div class="sidebar-background-not"></div>
</div>

     <div class="vertical-overlay"></div>

<style type="text/css">

//after login side & topbar
[data-sidebar-size="lg"] .portlet-layout, .main-content, .user-page-content #content {
     width: 78%; 
     margin-left: 22% !important; 
}
.navbar-menu {
	width: 220px;
}

.controls-visible p-0{
	padding: relative !important;
}

.user-page-content .portlet-layout {
    /*width: 78%;*/
    /*margin-left: 20%;*/
}
.user-page-content {
	padding: calc(70px + 1.5rem) calc(1.5rem / 2) 60px calc(1.5rem / 2);
}
.remove-content a:before, .remove-content span:before {
	opacity: 0 !important;
}
.user-page-content #content {
    width: 78%;
    margin-left: 20%;
    margin-top: 75px;
}
[data-sidebar-size="sm"] .user-page-content #content {
    width: 88.5%;
    margin-left: 8.5%;
}

.vertical-sidebar-enable .user-page-content #content {
    width: 80%;
    margin-left: 10%;
}

</style>