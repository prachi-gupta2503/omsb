<%@ include file="init.jsp" %>

<body>
    <div id="wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="omsb-card">	
					<div class=" trainee-distribution-table">
	                    <div class="pagetitle text-center">
	                        <h3>${programName} <liferay-ui:message key="training.program" /> <liferay-ui:message key="annual.year" /> ${academicYear}</h3>
	                        <p><liferay-ui:message key="no.of.residents.rotating.in.each.site.per.block" /></p>
	                        
	                    </div>
                        <div class="table-responsive">
                          <table class="table table-bordered" id="resident-report-datatable" cellpadding="0" cellspacing="0">
                            <thead>
                              <tr class="headings">
                              	
                                <th><liferay-ui:message key="training.sites" /></th>
                                <th><liferay-ui:message key="post" /></th>
                                <th><liferay-ui:message key="sn" /></th>
                                <th colspan="3"><liferay-ui:message key="faculty.per.rotation" /></th>
                                <th colspan="3"><liferay-ui:message key="block1" /></th>
                                <th colspan="3"><liferay-ui:message key="block2" /></th>
                                <th colspan="3"><liferay-ui:message key="block3" /></th>
                                <th colspan="3"><liferay-ui:message key="block4" /></th>
                                <th colspan="3"><liferay-ui:message key="block5" /></th>
                                <th colspan="3"><liferay-ui:message key="block6" /></th>
                                <th colspan="3"><liferay-ui:message key="block7" /></th>
                                <th colspan="3"><liferay-ui:message key="block8" /></th>
                                <th colspan="3"><liferay-ui:message key="block9" /></th>
                                <th colspan="3"><liferay-ui:message key="block10" /></th>
                                <th colspan="3"><liferay-ui:message key="block11" /></th>
                                <th colspan="3"><liferay-ui:message key="block12" /></th>
                                <th colspan="3"><liferay-ui:message key="block13" /></th>
                                <th class="dark-blue-color"><liferay-ui:message key="subtotal" /></th>
                                <th class="dark-blue-color"><liferay-ui:message key="total" /></th>
                              </tr>
                            </thead>
                            <tbody>
					        	<c:forEach var="residentRotatingPerTrainingSiteDTO" items="${residentsRotatingPerTrainingSiteDTOList}" varStatus="trainingSiteLoop">
					        	
					        		<c:set value="${residentRotatingPerTrainingSiteDTO.getFacultyTypeAndCountDTOList()}" var="facultyTypeAndCountDTOList" ></c:set>
						            <c:forEach var="facultiesAndTraineesPerRotationDTO" items="${residentRotatingPerTrainingSiteDTO.getfacultiesAndTraineesPerRotationDTOList()}" varStatus="rotationLoop">
						            <c:set var='rotationCount' value="${residentRotatingPerTrainingSiteDTO.getfacultiesAndTraineesPerRotationDTOList().size()}"></c:set>
							           <tr class="rotation-row">
							           	
							           	<c:if test="${rotationLoop.index == 0}">
							            	<td class="training-site-name" style="font-weight: 600;" rowspan="${rotationCount}">${residentRotatingPerTrainingSiteDTO.getTrainingSiteName()}</td>
							            </c:if>
							            
							            
							            
							            <c:choose>
										  <c:when test="${rotationLoop.index < facultyTypeAndCountDTOList.size()}">
										    <td class="facultyType">${facultyTypeAndCountDTOList.get(rotationLoop.index).getFacultyType()}</td>
						            		<td class="facultyCount">${facultyTypeAndCountDTOList.get(rotationLoop.index).getFacultyCount()}</td>
										  </c:when>
										  <c:when test="${rotationLoop.index == facultyTypeAndCountDTOList.size()}">
										    <td class=totalFaculty colspan="2" style="background-color: #D9D9D9; font-weight: 600" >${residentRotatingPerTrainingSiteDTO.getTotalFacultyCount()}</td>
										  </c:when>
										  <c:otherwise>
										   	<td colspan="2" ></td>
										  </c:otherwise>
										</c:choose>
							            	
							            
							            <td class="rotation-name smallfonts">${facultiesAndTraineesPerRotationDTO.getRotationName()}</td>
							            <td class="light-blue-color facultyCount smallfonts">${facultiesAndTraineesPerRotationDTO.getFacultyNameList().size()}</td>
							            <td class="light-blue-color smallfonts  facultyName">
							            	<c:forEach var="facultyName" items="${facultiesAndTraineesPerRotationDTO.getFacultyNameList()}">
							            		${facultyName}
							            	</c:forEach>
							            </td>
							            
							            <td class="smallfonts">${facultiesAndTraineesPerRotationDTO.getTraineesInProgramBlock1()}</td>
							            <td class="yellow-color smallfonts smallfonts">${facultiesAndTraineesPerRotationDTO.getTraineesNotInProgramBlock1()}</td>
							            <c:if test="${rotationLoop.index == 0}">
							            	<td style="background-color: #D9D9D9; font-weight: 600" class="block1" rowspan="${rotationCount}">${residentRotatingPerTrainingSiteDTO.getTotalTraineesBlock1()}</td>
							            </c:if>
							            
							            <td class="smallfonts">${facultiesAndTraineesPerRotationDTO.getTraineesInProgramBlock2()}</td>
							            <td class="yellow-color block2 smallfonts">${facultiesAndTraineesPerRotationDTO.getTraineesNotInProgramBlock2()}</td>
							            <c:if test="${rotationLoop.index == 0}">
							            	<td style="background-color: #D9D9D9; font-weight: 600" class="block2" rowspan="${rotationCount}">${residentRotatingPerTrainingSiteDTO.getTotalTraineesBlock2()}</td>
							            </c:if>
							            
							            <td class="smallfonts">${facultiesAndTraineesPerRotationDTO.getTraineesInProgramBlock3()}</td>
							            <td class="yellow-color block3 smallfonts">${facultiesAndTraineesPerRotationDTO.getTraineesNotInProgramBlock3()}</td>
							            <c:if test="${rotationLoop.index == 0}">
							            	<td style="background-color: #D9D9D9; font-weight: 600" class="block3" rowspan="${rotationCount}">${residentRotatingPerTrainingSiteDTO.getTotalTraineesBlock3()}</td>
							            </c:if>
							            
							            <td class="smallfonts">${facultiesAndTraineesPerRotationDTO.getTraineesInProgramBlock4()}</td>
							            <td class="yellow-color block4 smallfonts">${facultiesAndTraineesPerRotationDTO.getTraineesNotInProgramBlock4()}</td>
							            <c:if test="${rotationLoop.index == 0}">
							            	<td style="background-color: #D9D9D9; font-weight: 600" class="block4" rowspan="${rotationCount}">${residentRotatingPerTrainingSiteDTO.getTotalTraineesBlock4()}</td>
							            </c:if>
							            
							            <td class="smallfonts">${facultiesAndTraineesPerRotationDTO.getTraineesInProgramBlock5()}</td>
							            <td class="yellow-color block5 smallfonts">${facultiesAndTraineesPerRotationDTO.getTraineesNotInProgramBlock5()}</td>
							            <c:if test="${rotationLoop.index == 0}">
							            	<td style="background-color: #D9D9D9; font-weight: 600" class="block5" rowspan="${rotationCount}">${residentRotatingPerTrainingSiteDTO.getTotalTraineesBlock5()}</td>
							            </c:if>
							            
							            <td class="smallfonts">${facultiesAndTraineesPerRotationDTO.getTraineesInProgramBlock6()}</td>
							            <td class="yellow-color block6 smallfonts">${facultiesAndTraineesPerRotationDTO.getTraineesNotInProgramBlock6()}</td>
							            <c:if test="${rotationLoop.index == 0}">
							            	<td style="background-color: #D9D9D9; font-weight: 600" class="block6" rowspan="${rotationCount}">${residentRotatingPerTrainingSiteDTO.getTotalTraineesBlock6()}</td>
							            </c:if>
							            
							            <td class="smallfonts">${facultiesAndTraineesPerRotationDTO.getTraineesInProgramBlock7()}</td>
							            <td class="yellow-color block7 smallfonts">${facultiesAndTraineesPerRotationDTO.getTraineesNotInProgramBlock7()}</td>
							            <c:if test="${rotationLoop.index == 0}">
							            	<td style="background-color: #D9D9D9; font-weight: 600" class="block7" rowspan="${rotationCount}">${residentRotatingPerTrainingSiteDTO.getTotalTraineesBlock7()}</td>
							            </c:if>
							            
							            <td class="smallfonts">${facultiesAndTraineesPerRotationDTO.getTraineesInProgramBlock8()}</td>
							            <td class="yellow-color block8 smallfonts">${facultiesAndTraineesPerRotationDTO.getTraineesNotInProgramBlock8()}</td>
							            <c:if test="${rotationLoop.index == 0}">
							            	<td style="background-color: #D9D9D9; font-weight: 600" class="block8" rowspan="${rotationCount}">${residentRotatingPerTrainingSiteDTO.getTotalTraineesBlock8()}</td>
							            </c:if>
							            
							            <td class="smallfonts">${facultiesAndTraineesPerRotationDTO.getTraineesInProgramBlock9()}</td>
							            <td class="yellow-color block9 smallfonts">${facultiesAndTraineesPerRotationDTO.getTraineesNotInProgramBlock9()}</td>
							            <c:if test="${rotationLoop.index == 0}">
							            	<td style="background-color: #D9D9D9; font-weight: 600" class="block9" rowspan="${rotationCount}">${residentRotatingPerTrainingSiteDTO.getTotalTraineesBlock9()}</td>
							            </c:if>
							            
							            <td class="smallfonts">${facultiesAndTraineesPerRotationDTO.getTraineesInProgramBlock10()}</td>
							            <td class="yellow-color block10 smallfonts">${facultiesAndTraineesPerRotationDTO.getTraineesNotInProgramBlock10()}</td>
							            <c:if test="${rotationLoop.index == 0}">
							            	<td style="background-color: #D9D9D9; font-weight: 600" class="block10" rowspan="${rotationCount}">${residentRotatingPerTrainingSiteDTO.getTotalTraineesBlock10()}</td>
							            </c:if>
							            
							            <td class="smallfonts">${facultiesAndTraineesPerRotationDTO.getTraineesInProgramBlock11()}</td>
							            <td class="yellow-color block11 smallfonts">${facultiesAndTraineesPerRotationDTO.getTraineesNotInProgramBlock11()}</td>
							            <c:if test="${rotationLoop.index == 0}">
							            	<td style="background-color: #D9D9D9; font-weight: 600" class="block11" rowspan="${rotationCount}">${residentRotatingPerTrainingSiteDTO.getTotalTraineesBlock11()}</td>
							            </c:if>
							            
							            <td class="smallfonts">${facultiesAndTraineesPerRotationDTO.getTraineesInProgramBlock12()}</td>
							            <td class="yellow-color block12 smallfonts">${facultiesAndTraineesPerRotationDTO.getTraineesNotInProgramBlock12()}</td>
							            <c:if test="${rotationLoop.index == 0}">
							            	<td style="background-color: #D9D9D9; font-weight: 600" class="block12" rowspan="${rotationCount}">${residentRotatingPerTrainingSiteDTO.getTotalTraineesBlock12()}</td>
							            </c:if>
							            
							            <td>${facultiesAndTraineesPerRotationDTO.getTraineesInProgramBlock13()}</td>
							            <td class="yellow-color block13">${facultiesAndTraineesPerRotationDTO.getTraineesNotInProgramBlock13()}</td>
							            <c:if test="${rotationLoop.index == 0}">
							            	<td style="background-color: #D9D9D9; font-weight: 600" class="block13" rowspan="${rotationCount}">${residentRotatingPerTrainingSiteDTO.getTotalTraineesBlock13()}</td>
							            </c:if>
							            
							            <td>${facultiesAndTraineesPerRotationDTO.getTotalTraineesInRotation()}</td>
							            
							            <c:if test="${rotationLoop.index == 0}">
							            	<td rowspan="${rotationCount}" class="smallfonts">${residentRotatingPerTrainingSiteDTO.getTotalTraineeCountInTrainingSite()}</td>
							            </c:if>
							            
							            </tr>
						             </c:forEach>
					        	</c:forEach>
                            </tbody>
                         </table>
                         </div>
                    	</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
