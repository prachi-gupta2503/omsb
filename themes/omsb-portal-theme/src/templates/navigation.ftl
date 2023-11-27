<div class="omsb-sidebar-navigation" aria-label="<@liferay.language key="site-pages" />" >
	<ul class="omsb-navbar" >
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

		<li class="${nav_item_css_class} omsb-nav-item" id="layout_${nav_item.getLayoutId()}" role="presentation">
			<a ${nav_item_attr_has_popup}  href="${nav_item.getURL()}" ${nav_item.getTarget()} role="menuitem"><img class="nav-icon" src="${images_folder}/svg/examination_icon.svg" alt="Home" /> <span><@liferay_theme["layout-icon"] layout=nav_item_layout /> ${nav_item.getName()}</span></a>

			<#if nav_item.hasChildren()>
			<span class="submenu-icon"></span>
				<ul  class="sub-menu" role="menu">
					<#list nav_item.getChildren() as nav_child>
						<#assign
							nav_child_css_class = ""
						/>

						<#if nav_child.isSelected()>
							<#assign
								nav_child_css_class = "selected"
							/>
						</#if>

						<li class="${nav_child_css_class}" id="layout_${nav_child.getLayoutId()}" role="presentation">
							<a href="${nav_child.getURL()}" class="trans omsb-nav-link" ${nav_child.getTarget()} role="menuitem">${nav_child.getName()}</a>
						</li>
					</#list>
				</ul>
			</#if>
		</li>
	</#list>
	</ul>
</div>