(function($, ecmrPortlet) {
	var namespace, civilIdJEL, passportNoJEL, dateofbirthJEL, searchPersonsBtnJEL, getPersonsDataResourceURLJEL, personsDatatableJEL, 
	personIdJEL, programNameJEL, getDependentDataResourceURLJEL, trainingSiteJEL, rotationJEL, addNewEcMemberRequestJEL, membershipRoleJEL,
	coveringLetterJEL, curriculamVitaeJEL,civilIdPassportErrorJEL, submitBtnJEL, dobErrorJEL, createNewRequestBtnJEL, addEcMemberRequestURL;
	
	function renderECMR(config){
		namespace = config.namespace;
		civilIdJEL = config.civilIdJEL;
		passportNoJEL = config.passportNoJEL;
		dateofbirthJEL = config.dateofbirthJEL;
		searchPersonsBtnJEL = config.searchPersonsBtnJEL;
		programNameJEL = config.programNameJEL;
		trainingSiteJEL = config.trainingSiteJEL;
		getPersonsDataResourceURLJEL = config.getPersonsDataResourceURLJEL;
		personsDatatableJEL = config.personsDatatableJEL;
		civilIdPassportErrorJEL = config.civilIdPassportErrorJEL;
		dobErrorJEL = config.dobErrorJEL;
		personIdJEL = config.personIdJEL;
		rotationJEL = config.rotationJEL;
		membershipRoleJEL = config.membershipRoleJEL;
		coveringLetterJEL = config.coveringLetterJEL;
		curriculamVitaeJEL = config.curriculamVitaeJEL;
		addNewEcMemberRequestJEL = config.addNewEcMemberRequestJEL;
		getDependentDataResourceURLJEL = config.getDependentDataResourceURLJEL;
		submitBtnJEL = config.submitBtnJEL;
		createNewRequestBtnJEL = config.createNewRequestBtnJEL;
		addEcMemberRequestURL = config.addEcMemberRequestURL;
		
		$(civilIdPassportErrorJEL).hide();
		
		$(dobErrorJEL).hide(); 
		
		$(submitBtnJEL).attr('disabled', true);
		
		$(dateofbirthJEL).datepicker({
			format: 'dd/mm/yyyy',
			endDate: new Date((new Date().getFullYear()-18) + '-' + (new Date().getMonth()+1) + '-' + new Date().getDate()),
			maxDate: new Date((new Date().getFullYear()-18) + '-' + (new Date().getMonth()+1) + '-' + new Date().getDate()),
		    changeMonth: true,
		    changeYear: true
		});
		
		$(document).on('click', '.personCheck', function () {
			$('.personCheck').prop('checked',false);
			$(this).prop('checked',true);
			$(personIdJEL).val($(this).data('personid'));
			console.log('personId --- ' , $(personIdJEL).val());
			$(personIdJEL).trigger('change');
	    });
		
		$(personsDatatableJEL).DataTable({
		    "bLengthChange": false,
		    "bFilter": false
		});
		
		$(personIdJEL).change(function() {
			var personId = $(personIdJEL).val();
			if(personId){
				$(submitBtnJEL).attr('disabled', false);
			} else {
				$(submitBtnJEL).attr('disabled', true);
			}
		});
		
		$(programNameJEL).change(function(){
			var selectedProgram = $(programNameJEL).val();
			$.ajax({
			    url: getDependentDataResourceURLJEL,
			    type: "POST",
			    data:{
			    	[namespace + 'cmd']: 'getTrainingSitesData',
			    	[namespace + 'selectedProgram']: selectedProgram
			    }, 
			    success:function(result){
					var resultObj;
					if(result){
						let div;
						resultObj = JSON.parse(result);
						if(resultObj.status == 'success'){
							console.log('success while fetching trainings : ', resultObj);
							$(trainingSiteJEL).html('');
							$(rotationJEL).html('');
							div = '<option>Select</option>';
							for(let i = 0; i < resultObj.trainingSites.length; i++){
								var trainingSite = resultObj.trainingSites[i];
								div = div + '<option value="'+trainingSite.trainingSiteId+'">'+trainingSite.trainingSiteName+'</option>';
							}
							$(trainingSiteJEL).html(div);
						}else{
							$(trainingSiteJEL).html('');
							$(rotationJEL).html('');
							console.log('Error while fetching training sites');
						}
					}
			    }
			});
			
		});
		
		$(trainingSiteJEL).change(function(){
			var selectedtrainingSite = $(trainingSiteJEL).val();
			$.ajax({
			    url: getDependentDataResourceURLJEL,
			    type: "POST",
			    data:{
			    	[namespace + 'cmd']: 'getRotationsData',
			    	[namespace + 'selectedTrainingSite']: selectedtrainingSite
			    }, 
			    success:function(result){
					var resultObj;
					if(result){
						let div;
						resultObj = JSON.parse(result);
						if(resultObj.status == 'success'){
							console.log('success while fetching trainings : ', resultObj);
							$(rotationJEL).html('');
							div = '<option>Select</option>';
							for(let i = 0; i < resultObj.rotations.length; i++){
								var rotation = resultObj.rotations[i];
								div = div + '<option value="'+rotation.rotationMasterId+'">'+rotation.rotationName+'</option>';
							}
							$(rotationJEL).html(div);
						}else{
							$(rotationJEL).html('');
							console.log('Error while fetching training sites');
						}
					}
			    }
			});
			
		});
		
		$(createNewRequestBtnJEL).click(function(){
			window.location.href = addEcMemberRequestURL;
		});
		
		$(searchPersonsBtnJEL).click(function(){
			console.log('searchPersonsBtnJEL : clicked');
			var civilId = $(civilIdJEL).val();
			var passportNo = $(passportNoJEL).val();
			var dateOfBirth = $(dateofbirthJEL).val();
			
			console.log('civilId : ', civilId);
			console.log('passportNo : ', passportNo);
			console.log('dateOfBirth : ', dateOfBirth);
			$(personIdJEL).val('');
			$(personIdJEL).trigger('change');
			
			if(dateOfBirth){
				$(dobErrorJEL).hide();
			}
			
			if(civilId || passportNo){
				ajaxForFetchingFilteredPersons(civilId, passportNo, dateOfBirth);
				$(civilIdPassportErrorJEL).hide();
			} else {
				$(civilIdPassportErrorJEL).show();
			}
		});
		
		function ajaxForFetchingFilteredPersons(civilId, passportNo, dateOfBirth){
			$.ajax({
			    url: getPersonsDataResourceURLJEL,
			    type: "POST",
			    data:{
			    	[namespace + 'cmd']: 'getPersonsFilteredData',
			    	[namespace + 'civilId']: civilId,
			    	[namespace + 'passportNo']: passportNo,
			    	[namespace + 'dateOfBirth']: dateOfBirth
			    }, 
			    success:function(result){
					var resultObj;
					if(result){
						let div;
						resultObj = JSON.parse(result);
						if(resultObj.status == 'success'){
							console.log('success while fetching persons : ', resultObj);
							for(let i = 0; i < resultObj.personDetailsList.length; i++){
								var person = resultObj.personDetailsList[i];
								
								div += '<tr><td>' + person.givenNameAsPassport+'</td><td>'+ person.dateOfBirth +'</td><td>'+person.email+
								'</td><td><div class="custom-control custom-checkbox "><input type="checkbox" class="custom-control-input personCheck" data-personid="'+person.id+'" id="person'+
								person.id+'" name="person'+person.id+'"> <label class="custom-control-label m-0" for="authorize5"></label></div></td></tr>';
							}
							$('#personsDatatableBody').html(div);
						}else{
							console.log('Error while fetching persons');
						}
					}
			    }
			});
		}
	}
	 
	ecmrPortlet.renderECMR = renderECMR;
	
})($, (window.ecmrPortlet = window.ecmrPortlet || {}));