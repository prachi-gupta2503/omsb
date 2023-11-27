(function($, ecmrPortlet) {
	var namespace, civilIdJEL, emailJEL, nameJEL, searchPersonsBtnJEL, getPersonsDataResourceURLJEL, personsDatatableJEL, 
	personIdJEL, lrUserIdJEL, programNameJEL, getDependentDataResourceURLJEL, trainingSiteJEL, rotationJEL, addNewEcMemberRequestJEL, membershipRoleJEL,
	coveringLetterJEL, curriculamVitaeJEL,civilIdPassportErrorJEL, submitBtnJEL, dobErrorJEL, searchPersonFormJEL, createNewRequestBtnJEL, addEcMemberRequestURL,
	noRecordMessageJEL, emailIdRecordMessageJEL, personsDatatableDivJEL, ecRequestFormDivJEL, invitePersonBtnJEL, sendRegisterInviteEmailResourceURLJEL,
	getPersonsRelatedDataResourceURL,cancelButton,popupMessage,msgExistingEcRequestActiveStatus,msgExistingEcRequestInProcessStatus;
	
	function renderECMR(config){
		namespace = config.namespace;
		civilIdJEL = config.civilIdJEL;
		emailJEL = config.emailJEL;
		nameJEL = config.nameJEL;
		ecRequestFormDivJEL = config.ecRequestFormDivJEL;
		searchPersonsBtnJEL = config.searchPersonsBtnJEL;
		programNameJEL = config.programNameJEL;
		trainingSiteJEL = config.trainingSiteJEL;
		getPersonsDataResourceURLJEL = config.getPersonsDataResourceURLJEL;
		personsDatatableJEL = config.personsDatatableJEL;
		civilIdPassportErrorJEL = config.civilIdPassportErrorJEL;
		dobErrorJEL = config.dobErrorJEL;
		personIdJEL = config.personIdJEL;
		lrUserIdJEL = config.lrUserIdJEL;
		rotationJEL = config.rotationJEL;
		invitePersonBtnJEL = config.invitePersonBtnJEL;
		noRecordMessageJEL = config.noRecordMessageJEL;
		emailIdRecordMessageJEL = config.emailIdRecordMessageJEL;
		membershipRoleJEL = config.membershipRoleJEL;
		coveringLetterJEL = config.coveringLetterJEL;
		curriculamVitaeJEL = config.curriculamVitaeJEL;
		addNewEcMemberRequestJEL = config.addNewEcMemberRequestJEL;
		getDependentDataResourceURLJEL = config.getDependentDataResourceURLJEL;
		sendRegisterInviteEmailResourceURLJEL = config.sendRegisterInviteEmailResourceURLJEL;
		submitBtnJEL = config.submitBtnJEL;
		createNewRequestBtnJEL = config.createNewRequestBtnJEL;
		addEcMemberRequestURL = config.addEcMemberRequestURL;
		searchPersonFormJEL = config.searchPersonFormJEL;
		personsDatatableDivJEL = config.personsDatatableDivJEL;
		getPersonsRelatedDataResourceURL = config.getPersonsRelatedDataResourceURL;
		cancelButton=config.cancelButton;
		popupMessage=config.popupMessage;
		msgExistingEcRequestActiveStatus=config.msgExistingEcRequestActiveStatus;
		msgExistingEcRequestInProcessStatus=config.msgExistingEcRequestInProcessStatus;
		
		$(rotationJEL).attr('multiple', 'true');
		$(rotationJEL).multiselect();
		
		$(ecRequestFormDivJEL).hide();
		
		$(noRecordMessageJEL).hide();
		$(emailIdRecordMessageJEL).hide();
		$(personsDatatableDivJEL).hide();
		
		$(civilIdPassportErrorJEL).hide();
		
		$(dobErrorJEL).hide(); 
		
		$(submitBtnJEL).attr('disabled', true);
				
		$(personIdJEL).change(function() {
			var personId = $(personIdJEL).val();
			if(personId){
				$(ecRequestFormDivJEL).show();
				$(cancelButton).hide();
				$(submitBtnJEL).attr('disabled', false);
			} else {
				$(ecRequestFormDivJEL).hide();
				$(cancelButton).show();
				$(submitBtnJEL).attr('disabled', true);
			}
		});
		
		$(personIdJEL).trigger('change');
		
		console.log("---" , $(personIdJEL).val());
		
		/*$(dateofbirthJEL).datepicker({
			format: 'dd/mm/yyyy',
			endDate: new Date((new Date().getFullYear()-18) + '-' + (new Date().getMonth()+1) + '-' + new Date().getDate()),
			maxDate: new Date((new Date().getFullYear()-18) + '-' + (new Date().getMonth()+1) + '-' + new Date().getDate()),
		    changeMonth: true,
		    changeYear: true
		});*/
		
	    var res = null;
		$(document).on('click', '.personCheck', function () {
			$('.personCheck').prop('checked',false);
			$(this).prop('checked',true);
			$(personIdJEL).val($(this).data('personid'));
			$(lrUserIdJEL).val($(this).data('lruserid'));
			console.log('personId --- ' , $(personIdJEL).val());
			console.log('lrUserIdJEL --- ' , $(lrUserIdJEL).val());
			 $.ajax({
		            type: "POST",
		            url: getPersonsRelatedDataResourceURL, 
		            data: {
		                [namespace + 'personId']: $(personIdJEL).val()
		            },
		            success: function(response) {
		            	response = JSON.parse(response);
		            	res=response;
		            	if(response.length > 0){
		            		let div;
							for(let i = 0; i < response.length; i++){
								var person = response[i];
								div += '<tr><td>' + person.program+'</td><td>'+ person.role +'</td><td>'+ person.status +'</td></tr>';
							}
							$('#personsAffiliationDatatableDiv').show();
							$('#personsAffiliationDatatableBody').html(div);
							
						} else {
							$('#personsAffiliationDatatableDiv').hide();	
						}
		            	
		            },
		            error: function() {
		            }
		        });
			$(personIdJEL).trigger('change');
	    });
		
		
		$(submitBtnJEL).click(function(event){
		  console.log("response for existing affilation program  ",JSON.stringify(res));
		  var programId = $(programNameJEL).val();
		  $.each(res,function(key,value){
			  if (programId == value.programId) {
			      if (value.status == 'Active') {
			        $(popupMessage).text(msgExistingEcRequestActiveStatus);
			        $("#personAlreadyMap").modal();
			        event.preventDefault();
			      } else if (value.status == 'In Process') {
			        $(popupMessage).text(msgExistingEcRequestInProcessStatus);
			        $("#personAlreadyMap").modal();
			        event.preventDefault();
			      }
			    }
		  });		 
		});
		
		function initialisePersonDT(){
			$(personsDatatableJEL).DataTable({
			    "bLengthChange": false,
			    "bFilter": false,
			    "columnDefs": [{
			        "targets": 'no_sorting', // Use the class name you've assigned to the column
			        "orderable": false
			      }],
			    drawCallback: function(settings) {
			    	if($(this).find('tbody tr').length <= 20){
			            $('#personsDatatable_paginate').hide();
			            $('#personsDatatable_info').hide();
			        }
			      }
			});
		}
		
		/*$(createNewRequestBtnJEL).click(function(){
			window.location.href = addEcMemberRequestURL;
		});*/
		
		
		
		$(invitePersonBtnJEL).click(function(){
			console.log('invitePersonBtn clicked', sendRegisterInviteEmailResourceURLJEL);
			var email = $(emailJEL).val();
			var name = $(nameJEL).val();
			$.ajax({
			    url: sendRegisterInviteEmailResourceURLJEL,
			    type: "POST",
			    data:{
			    	[namespace + 'cmd']: 'sendRegisterInviteEmail',
			    	[namespace + 'email']: email,
			    	[namespace + 'name']: name
			    },
			    success:function(result){
					var resultObj;
					if(result){
						let div;
						console.log('result::::',result);
						if(result.status == 'success'){
							console.log('success while sending invite : ', resultObj);
							$('#inviteSentBtn').click();
						}else{
							console.log('Error while sending invite');
							
						}
					}
			    }
			});
		});
		
		$(searchPersonsBtnJEL).click(function(){
			console.log('searchPersonsBtnJEL : clicked');
			var civilId = $(civilIdJEL).val();
			var name = $(nameJEL).val();
			var email = $(emailJEL).val().toLowerCase();
			
			console.log('civilId : ', civilId);
			console.log('name : ', name);
			console.log('email : ', email);
			$(personIdJEL).val('');
			$(personIdJEL).trigger('change');
			
			/*if(dateOfBirth){
				$(dobErrorJEL).hide();
			} else {
				$(dobErrorJEL).show();
			}*/
			
			var validator = Liferay.Form.get(namespace + 'searchPersonForm').formValidator;
			validator.validate();
			var isValid = !validator.hasErrors();
			
			if(isValid){
				ajaxForFetchingFilteredPersons(civilId, name, email);
			}
			else{
				$(personsDatatableDivJEL).hide();
				$(emailIdRecordMessageJEL).hide();
			}
			/*if((civilId || passportNo) && dateOfBirth){
				ajaxForFetchingFilteredPersons(civilId, passportNo, dateOfBirth);
				$(civilIdPassportErrorJEL).hide();
				$(dobErrorJEL).hide();
			} else {
				if(dateOfBirth){
					//$(dobErrorJEL).hide();
				} else {
					$(dobErrorJEL).show();
				}
				$(civilIdPassportErrorJEL).show();
			}*/
		});
		
		function ajaxForFetchingFilteredPersons(civilId, name, email){
			$.ajax({
			    url: getPersonsDataResourceURLJEL,
			    type: "POST",
			    data:{
			    	[namespace + 'cmd']: 'getPersonsFilteredData',
			    	[namespace + 'civilId']: civilId,
			    	[namespace + 'name']: name,
			    	[namespace + 'email']: email
			    }, 
			    success:function(result){
			    	console.log("-----------------------",result);
					var resultObj;
					if(result){
						$('#personsDatatableBody').html('');
						let div;
						console.log('result::::',result);
						resultObj = JSON.parse(result);
						if(resultObj.status == 'success'){
							console.log('success while fetching persons : ', resultObj);
							if(resultObj.resultJson.personsDetailsList.length > 0){
								$(personsDatatableJEL).DataTable().destroy();
								initialisePersonDT();
								for(let i = 0; i < resultObj.resultJson.personsDetailsList.length; i++){
									var person = resultObj.resultJson.personsDetailsList[i];
									div += '<tr><td>' + person.givenNameAsPassport+'</td><td>'+ person.dateOfBirth +'</td><td>'+person.email+
									'</td><td><div><div class="custom-control custom-checkbox d-inline-block"><input type="checkbox" class="custom-control-input personCheck" data-lruserid="'+person.lrUserId+'" data-personid="'+person.id+'" id="person'+
									person.id+'" name="person'+person.id+'"> <label class="custom-control-label m-0" for="authorize5"></label></div></div></td></tr>';
								}
								$('#personsDatatableBody').html(div);
								$(personsDatatableDivJEL).show();
								$(noRecordMessageJEL).hide();
								if(resultObj.resultJson.isEmailResult == true){
									$(noRecordMessageJEL).hide();
									$(emailIdRecordMessageJEL).show();
								} else {
									$(emailIdRecordMessageJEL).hide();
									//$(personsDatatableDivJEL).hide();
								}
							} else {
								$(personsDatatableJEL).DataTable().destroy();
								$(emailIdRecordMessageJEL).hide();
								$(personsDatatableDivJEL).hide();
								$(noRecordMessageJEL).show();
								$(personsDatatableDivJEL).hide();
							}
						}else{
							$(personsDatatableJEL).DataTable().destroy();
							$(personsDatatableDivJEL).hide();
							$(emailIdRecordMessageJEL).hide();
							$(noRecordMessageJEL).show();
							console.log('Error while fetching persons');
						}
					}
			    }
			});
		}
	}
	 
	ecmrPortlet.renderECMR = renderECMR;
	
})($, (window.ecmrPortlet = window.ecmrPortlet || {}));