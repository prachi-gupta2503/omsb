			
<ul class="navbar-nav ${nav_css_class}" id="navbar-nav" aria-label="<@liferay.language key="site-pages" />">
<#assign mysideIcons = ["ri-dashboard-line", "ri-file-paper-line", "ri-archive-line", "ri-git-repository-line", "ri-briefcase-4-line", "ri-newspaper-line", "ri-todo-line", "ri-book-3-line", "ri-account-box-line", "ri-calendar-todo-fill", "ri-clapperboard-line", "ri-pantone-line", "ri-contacts-book-upload-line", "ri-file-paper-2-line", "ri-pages-line", "ri-window-2-line", "ri-archive-drawer-line", "ri-community-line", "ri-file-list-line", "ri-government-line", "ri-book-2-line", "ri-building-line", "ri-government-line", "ri-community-line", "ri-hotel-line", "ri-building-4-line", "ri-hospital-line", "ri-bank-line", "ri-archive-drawer-line", "ri-calculator-line", "ri-line-chart-line", "ri-discuss-line", "ri-git-repository-line", "ri-device-line", "ri-fingerprint-line", "ri-newspaper-line", "ri-booklet-line", "ri-ticket-2-line", "ri-coupon-line", "ri-bank-card-2-line", "ri-gift-line", "ri-passport-line", "ri-bus-2-line", "ri-settings-5-line", "ri-notification-badge-line", "ri-contacts-line", "ri-team-line", "ri-group-2-line", "ri-parent-line", "ri-open-arm-line", "ri-body-scan-line", "ri-reserved-line", "ri-scales-3-line"] >

	<#list nav_items as nav_item>
		<#assign
			nav_item_attr_has_popup = ""
			nav_item_css_class = ""
			nav_item_layout = nav_item.getLayout()
		/>

		<#if nav_item.isSelected()>
			<#assign
				nav_item_attr_has_popup = "aria-haspopup='true'"
				nav_item_css_class = "selected"
			/>
		</#if>
<#if nav_item.hasChildren()>
	<li class="nav-item ${nav_item_css_class}" id="layout_${nav_item.getLayoutId()}">
		<div class="remove-content">
		<a ${nav_item_attr_has_popup} class="nav-link menu-link collapsed" href="#menu_${nav_item.getLayoutId()}" data-bs-toggle="collapse" role="button" aria-expanded="false" aria-controls="layout_${nav_item.getLayoutId()}" ${nav_item.getTarget()}> 
			<i class="bx icon nav-icon ri-apps-line ${mysideIcons[nav_item?index]}"></i> <span data-key="t-advance-ui"><@liferay_theme["layout-icon"] layout=nav_item_layout /> ${nav_item.getName()}</span> </a>
	</div>
		<div class="collapse menu-dropdown" id="menu_${nav_item.getLayoutId()}">
			<#if nav_item.hasChildren()>
			<ul class="nav nav-sm flex-column">
				<#list nav_item.getChildren() as nav_child>
							<#assign
								nav_child_css_class = ""
							/>

							<#if nav_item.isSelected()>
								<#assign
									nav_child_css_class = "selected"
								/>
							</#if>
							<#if nav_child.hasChildren()>
								<li class="nav-item ${nav_child_css_class}" id="layout_${nav_child.getLayoutId()}">
									<div class="remove-content">
								<a  ${nav_item_attr_has_popup} class="nav-link menu-link collapsed" href="#menu_${nav_child.getLayoutId()}" data-bs-toggle="collapse" role="button" aria-expanded="false" aria-controls="layout_${nav_child.getLayoutId()}" ${nav_child.getTarget()}> 
									<i class="bx icon nav-icon ${mysideIcons[nav_child?index]}"></i> <span data-key="t-advance-ui"><@liferay_theme["layout-icon"] layout=nav_item_layout /> ${nav_child.getName()}</span> </a>
								</div>
		<div class="collapse menu-dropdown" id="menu_${nav_child.getLayoutId()}">
			<#if nav_child.hasChildren()>
			<ul class="nav nav-sm flex-column">
				<#list nav_child.getChildren() as nav_2_child>
							<#assign
								nav_2_child_css_class = ""
							/>

							<#if nav_child.isSelected()>
								<#assign
									nav_2_child_css_class = "selected"
								/>
							</#if>	
								<li class=" ${nav_2_child_css_class} nav-item" id="layout_${nav_2_child.getLayoutId()}"><a href="${nav_2_child.getURL()}" class="nav-link" data-key="t-sweet-alerts" ${nav_2_child.getTarget()}>${nav_2_child.getName()} </a></li>
							
							</#list>
			</ul>
			</#if>
		</div>

							<#else>

							<li class=" ${nav_child_css_class} nav-item" id="layout_${nav_child.getLayoutId()}"><a href="${nav_child.getURL()}" class="nav-link" data-key="t-sweet-alerts" ${nav_child.getTarget()}>${nav_child.getName()} </a></li>
							</#if>
				</#list>
			</ul>
			</#if>
		</div>
	</li>
<#else>
	<li class=" ${nav_item_css_class} nav-item" id="layout_${nav_item.getLayoutId()}"><a href="${nav_item.getURL()}" class="nav-link" data-key="t-sweet-alerts" ${nav_item.getTarget()}>  <i class="bx icon nav-icon ${mysideIcons[nav_item?index]}"></i><span data-key="t-advance-ui"> ${nav_item.getName()} </span></a></li>
</#if>

</#list>
	
</ul>
			
		




