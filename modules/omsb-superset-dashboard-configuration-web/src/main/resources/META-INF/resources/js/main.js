(function($, customSystemSettingPortlet) {
	
	function saveRolesDashboardConfig(config){
		var	rolesDashboardConfigCntJEl = config.rolesDashboardConfigCntJEl,
			rolesDashboardConfigRow_1JEl = config.rolesDashboardConfigRow_1JEl,
			rolesDashboardConfigRowLengthJEl = config.rolesDashboardConfigRowLengthJEl,
			saveBtnJEl = config.saveBtnJEl,
			rolesDashboardConfigFormJEl = config.rolesDashboardConfigFormJEl,
			deletedConfigIdsJEl = config.deletedConfigIdsJEl,
			deletedIds = [];
		
		validateForm = function(){
			$(saveBtnJEl).click(function(){
				if(true){
					$(rolesDashboardConfigRowLengthJEl).val($('.roles-dashboard-config-row').length);
					deletedIdsStr = deletedIds.join();
					$(deletedConfigIdsJEl).val(deletedIdsStr);
					$(rolesDashboardConfigFormJEl).submit();
				}
			});
		};
		
		updateRolesDashboardConfigAttrs = function(addCounter){
			
			$('.roles-dashboard-config-row').each(function(index, obj){
				var counter;
				counter = index + 1;
				if(counter > 1){
					$(this).attr('id', 'rolesDashboardConfigRow_' + counter);
					$(this).find('.roles-list').attr('id', 'role_' + counter);
					$(this).find('.roles-list').attr('name', 'role_' + counter);
					$(this).find('.roles-list').attr('for', 'role_' + counter);
					$(this).find('.dashboardId-list').attr('id', 'dashboardId_' + counter);
					$(this).find('.dashboardId-list').attr('name', 'dashboardId_' + counter);
					$(this).find('.dashboardId-list').attr('for', 'dashboardId_' + counter);
					$(this).find('.role-dashboard-config-id').attr('id', 'rolesDashboardConfigId_' + counter);
					$(this).find('.role-dashboard-config-id').attr('name', 'rolesDashboardConfigId_' + counter);
					$(this).find('.add-roles-dashboardId-config-btn').attr('id', 'addRoleDashboardConfig_' + counter);
					$(this).find('.add-roles-dashboardId-config-btn').attr('name', 'addRoleDashboardConfig_' + counter);
					$(this).find('.delete-roles-dashboardId-config-btn').attr('id', 'deleteRoleDashboardConfig_' + counter);
					$(this).find('.delete-roles-dashboardId-config-btn').attr('name', 'deleteRoleDashboardConfig_' + counter);
					$(this).find('.delete-roles-dashboardId-config-btn').attr('onclick', 'customSystemSettingPortlet.saveRolesDashboardConfig.deleteRoleDashboardConfig('+ counter +');');
					$(this).find('.add-roles-dashboardId-config-btn').hide();
					$(this).find('.delete-roles-dashboardId-config-btn').show();
				}
			});
		};
		
		addRoleDashboardConfig = function(){
			var rolesDashboardConfigClonedJEl, rolesDashboardConfigRowsLen, addCounter;
			destroySelect2Els();
			rolesDashboardConfigRowsLen = $('.roles-dashboard-config-row').length;
			addCounter = rolesDashboardConfigRowsLen + 1;
			rolesDashboardConfigClonedJEl = $(rolesDashboardConfigRow_1JEl).clone();
			$(rolesDashboardConfigCntJEl).append(rolesDashboardConfigClonedJEl);
			updateRolesDashboardConfigAttrs(addCounter);
			$('#rolesDashboardConfigId_'+addCounter).val('');
			
			$('select#role_'+addCounter).removeAttr('data-select2-id');
			$('select#dashboardId_'+addCounter).removeAttr('data-select2-id');
			$("select#role_"+addCounter+" option").each(function () {
				$(this).removeAttr('selected');
				$(this).removeAttr('data-select2-id');    
            });
			$("select#dashboardId_"+addCounter+" option").each(function () {
				$(this).removeAttr('selected');
				$(this).removeAttr('data-select2-id');    
            });
			initSelect2Els();
			$('select#dashboardId_'+addCounter).val('').trigger('change');
			$('select#role_'+addCounter).val('').trigger('change');

		};
		
		deleteRoleDashboardConfig = function(ind){
			var deletedId;
			if(ind > 1){
				deletedId = $('#rolesDashboardConfigId_' + ind).val();
				if(!deletedIds.includes(deletedId)){
					deletedIds.push(deletedId);
				}
				$('#rolesDashboardConfigRow_' + ind).remove();
				updateRolesDashboardConfigAttrs();
			}
		};
		
		initSelect2Els = function(){
			$('.custom-select2').select2({
				allowClear : true
			});
			
		};
		
		destroySelect2Els = function(){
			$('.custom-select2').select2('destroy');
		};
		
		init = function() {
			console.log("Initailizing Roles Dashboard Config...");
			 initSelect2Els();
        };
       
        validateForm();
        init();
        
        saveRolesDashboardConfig.addRoleDashboardConfig = addRoleDashboardConfig;
        saveRolesDashboardConfig.deleteRoleDashboardConfig = deleteRoleDashboardConfig;
        
	};
	
	customSystemSettingPortlet.saveRolesDashboardConfig = saveRolesDashboardConfig;
	
})($, (window.customSystemSettingPortlet = window.customSystemSettingPortlet || {}));