<%@page import="java.util.List"%>
<%@page import="com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil"%>
<%@ include file="../../init.jsp"%>
<liferay-portlet:actionURL name="<%=MVCCommands.ADD_WORK_DETAIL%>" var="addWorkDetailActionUrl">
</liferay-portlet:actionURL>
<portlet:renderURL var="educationDetailRenderURL">
	<portlet:param name="mvcRenderCommandName" value="<%=MVCCommands.VIEW_REGISTRATION_EDUCATION_DETAILS%>" />
	<portlet:param name="personId" value="${personId}" />
	<portlet:param name="lrUserId" value="${lrUserId}" />
</portlet:renderURL>


<portlet:resourceURL id="<%=MVCCommands.GET_WORKSECTOR_BY_WORKSECTOR_TYPE%>" var="getWorkSectorByWorkSectorType" />
<portlet:resourceURL id="<%=MVCCommands.GET_WORKSECTOR_BY_PARENT_WORK_SECTOR%>" var="getWorkSectorByParentWorkSector" />

<div class="main-content id-box" style="margin-top: 0px;">
	<div class="omsb-main-wrapper" id="omsb-main-wrapper">
		<div class=" row bg-white">
			<div class="col-12 login-right">
				<div class="omsb-card ">
					<div class="omsb-pre-login header">
						<div>
							<img alt="" src="<%=themeDisplay.getPathThemeImages()%>/svg/logo.svg">
						</div>
						<div>
							<p class="logo-text-arabic">
								<liferay-ui:message key="oman-medical-specialty-board-arabic" />
							</p>
							<p class="logo-text-english">
								<liferay-ui:message key="oman-medical-specialty-board" />
							</p>
						</div>
					</div>
					<div class="reg_step3" id="reg_step3">
						<div class="omsb-card m-0 p-0">
							<div class="omsb-page-top-info mb-4">
								<div class="pagetitle">
									<liferay-ui:message key="registration-work-details" />
								</div>
								<div class="information">
									<label class="reg-form-title"><liferay-ui:message key="step-three-of-four" /></label>
								</div>
							</div>

						</div>
						<form action="${addWorkDetailActionUrl}" method="post" name="<portlet:namespace/>work-detail-form" id="work-detail-form" enctype="multipart/form-data">
							<input type="hidden" value="${lrUserId}" name="<portlet:namespace/>lrUserId" id="lrUserId" />
							 <input type="hidden" value="${personId }" name="<portlet:namespace/>personId" id="personId">
							<div class="d-flex">
								<div class="w-50">
									<label class="control-label"><liferay-ui:message key="are-you-currently-or-have-been-employed" /></label>
								</div>
								<div class="form-group yesorno">
									<div class="custom-control custom-radio ">
										<input type="radio" name="<portlet:namespace/>employed" class="custom-control-input" id="employed_yes" checked="checked" value="1"> 
										<label class="custom-control-label m-0" for="employed_yes"><liferay-ui:message key="yes" /></label>
									</div>
									<div class="custom-control custom-radio ">
										<input type="radio" name="<portlet:namespace/>employed" class="custom-control-input" id="employed_no" value="0">
										<label class="custom-control-label m-0" for="employed_no"><liferay-ui:message key="no" /></label>
									</div>
								</div>
							</div>
							<div class="omsb-main-div" id="work-detail-main">
									<!--  primary work detail -->
									
							<c:choose>
								<c:when test="${empty primaryworkDetail}">
									<div class="omsb-card omsb-card-graybg omsb-noBorderRadius work_detail" id="work_detail_1">
										<input type="hidden" name="<portlet:namespace/>id_1" id="<portlet:namespace/>id_1"> 
										<input type="hidden" name="<portlet:namespace/>isPrimary_1" id="<portlet:namespace/>isPrimary_1" value="true">
											<div class="">
												<label class="control-label"><liferay-ui:message key="primary-work-detail" /></label>
												<div class="row ">
													<div class="col-lg-4 col-md-6">
														<div class="form-group">
															<label class="control-label  required"><liferay-ui:message key="primary-workplace-sector-type" /></label> 
															<select name="<portlet:namespace/>workSectorType_1" id="workSectorType_1" class="form-control" onchange="getWorkSector(this.id)">
																<option value=""><liferay-ui:message key="select" /></option>
																<c:forEach var="workSectorType" items="${workSectorTypeList}">
																	<option value="${workSectorType.getListTypeEntryId()}"> <liferay-ui:message key="${workSectorType.getName(themeDisplay.getLocale())}" /></option>
																</c:forEach>
															</select>
															<p class="error-container" id="work-sector-type-error_1"></p>
														</div>
													</div>
													<div class="col-lg-4 col-md-6 d-none" id="worksectorTypediv_1">
																<div class="form-group">
																	<label class="control-label "><liferay-ui:message key="primary-workplace-sector-type-other" /></label>
																	 <input type="text" name="<portlet:namespace/>worksectortypeother_1" id="worksectortypeother_1" value="Other" class="form-control">
																</div>
													</div>
													<div class="col-lg-4 col-md-6" id="work-sector-div_1">
														<div class="form-group" >
															<label class="control-label required"><liferay-ui:message key="primary-sector-name" /></label>
															  
															  <select name="<portlet:namespace/>worksector_1" id="worksector_1" class="form-control" onchange="getChildWorkSector(this.id,'first')" >
																				<option value="" selected="selected"><liferay-ui:message key="select" /></option>
															</select>
															 <%--  <input type="text" class="form-control worksector_1" id="worksector_1" name="<portlet:namespace/>worksector_1" placeholder="" autocomplete="off"/> --%>
															<p class="error-container" id="work-sector-error_1"></p>
														</div>
													</div>
													<div class="col-lg-4 col-md-6 d-none" id="div-o2-work-other_1">
														<div class="form-group">
															<label class="control-label "><liferay-ui:message key="please-specify" /></label>
															 <input type="text" name="<portlet:namespace/>worksectorother_1" id="worksectorother_1" class="form-control"> 
														</div>
													</div>
													<div class="col-lg-4 col-md-6 d-none" id="div-first-sub-sector_1">
															<div class="form-group">
																<label class="control-label "><liferay-ui:message key="please-specify" /></label>
																<select name="<portlet:namespace/>first-sub-worksector_1" id="first-sub-worksector_1" class="form-control" onchange="getChildWorkSector2(this.id,'second')">
																	<option value=""><liferay-ui:message key="select" /></option>
																	<option value="other" selected="selected"><liferay-ui:message key="other" /></option>
																</select>
															</div>
													</div>
													<div class="col-lg-4 col-md-6  d-none " id="div-o3-work-other_1">
															<div class="form-group">
																<label class="control-label "><liferay-ui:message key="please-specify" /></label>
																 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
																 <input type="text" name="<portlet:namespace/>work_sub_sectorother_1" id="worksectorother_1" class="form-control" value="">
															</div>
													</div>
													<!-- Third level -->
														<div class="col-lg-4 col-md-6 d-none" id="div-second-sub-sector_1">
															<div class="form-group">
																<label class="control-label "><liferay-ui:message key="please-specify" /></label>
																<select name="<portlet:namespace/>second-sub-worksector_1" id="second-sub-worksector_1" class="form-control"   onchange="getChildWorkSector3(this.id,'second')">
																	<option value=""><liferay-ui:message key="select" /></option>
																	<option value="other" selected="selected"><liferay-ui:message key="other" /></option>
																</select>
															</div>
														</div>
														<div class="col-lg-4 col-md-6  d-none " id="div-o3-secons-work-other_1">
																<div class="form-group">
																	<label class="control-label "><liferay-ui:message key="please-specify" /></label>
																	 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
																	 <input type="text" name="<portlet:namespace/>work_second_sub_sectorother_1" id="worksecondsectorother_1" class="form-control" value="">
																</div>
														</div>
													<!-- Third level -->
													
													
													<div class="col-lg-4 col-md-6">
														<div class="form-group">
															<label class="control-label required"><liferay-ui:message key="region-location-primary-institution" /></label> 
															<select name="<portlet:namespace/>wilayats_1" id="wilayats_1" class="form-control" onchange="validateField(this.id,'location-error_1','<liferay-ui:message key="please-enter-work-sector-location" />')">
																<option value=""><liferay-ui:message key="select" /></option>
																<c:forEach var="wilayats" items="${wilayats}">
																	<option value="${wilayats.getKey()}">
																		<liferay-ui:message key="${wilayats.getName(themeDisplay.getLocale())}" />
																	</option>
																</c:forEach>
															</select>
															<p class="error-container" id="location-error_1"></p>
														</div>
													</div>
													<div class="col-lg-4 col-md-6">
														<div class="form-group">
															<label class="control-label required"><liferay-ui:message key="designation" /></label>
															 <select name="<portlet:namespace/>designations_1" id="designations_1" onchange="showDesignationOther(this.id,'designation-error_1','<liferay-ui:message key="please-enter-designation" />')" class="form-control designation">
																<option value=""><liferay-ui:message key="select" /></option>
																<c:forEach var="designations" items="${designations}">
																	<option value="${designations.getKey()}">
																		<liferay-ui:message key="${designations.getName(themeDisplay.getLocale())}" />
																	</option>
																</c:forEach>
															</select>
															<p class="error-container" id="designation-error_1"></p>
														</div>
													</div>
													<div class="col-lg-4 col-md-6 d-none" id="designationotherdiv_1">
														<div class="form-group">
															<label class="control-label "><liferay-ui:message key="designation-other" /></label>
															 <input type="text" name="<portlet:namespace/>designationother_1" id="designationother_1" value="" class="form-control">
														</div>
													</div>
													<div class="col-lg-12 col-md-12">
														<div class="form-group">
															<label class="control-label"><liferay-ui:message key="staff-card-id" /></label>
															<div class="omsb-custom-html-file custom-file">
																<input id="staffIdCard_1" name="<portlet:namespace/>staffIdCard_1" type="file" label="" class="form-control custom-file-input"  onchange="validateFile(this.id,'file-size-error_1','<liferay-ui:message key="please-select-pdf-file" />')">
																<label class="custom-file-label" for="staffIdCard_1" id="customStaffIdCard_"> </label>
															</div>
															<p class="error-container" id="file-size-error_1"></p>
															<p class="error-container" id="errorContainer-work-detail-file_1"></p>
														</div>
													</div>
												</div>
												<div class="bottom-backbtn-wrap"></div>
											</div>
										</div>
									</c:when>
									<c:otherwise>
											<div class="omsb-card omsb-card-graybg omsb-noBorderRadius work_detail" id="work_detail_1">
												<input type="hidden" name="<portlet:namespace/>id_1" id="<portlet:namespace/>id_1" value="${primaryworkDetail.getId()}">	
												<div class="">
														<label class="control-label"><liferay-ui:message key="primary-work-detail" /></label>
														<input type="hidden" name="<portlet:namespace/>isPrimary_1" id="<portlet:namespace/>isPrimary_1" value="true">
													<div class="row ">
															<div class="col-lg-4 col-md-6">
																<div class="form-group">
																	<label class="control-label required"><liferay-ui:message key="primary-workplace-sector-type" /></label>
																		<!-- Changes Abhi  starts -->
																			 <%-- <select name="<portlet:namespace/>workSectorType_${loop.count }" id="workSectorType_${loop.count }" class="form-control" onchange="validateField(this.id,'work-sector-type-error_${loop.count }','<liferay-ui:message key="please-enter-work-sector-type" />')"> --%>
																		 <select name="<portlet:namespace/>workSectorType_1" id="workSectorType_1" class="form-control 3" onchange="getWorkSector(this.id)">
																				<option value=""><liferay-ui:message key="select" /></option>
																		<c:forEach var="workSectorType" items="${workSectorTypeList}">
																			<option value="${workSectorType.getListTypeEntryId()}" ${workSectorType.getListTypeEntryId() == primaryworkDetail.getWorkSectorType() ? 'selected="selected"' : ''}>
																				<liferay-ui:message key="${workSectorType.getName(themeDisplay.getLocale())}" />
																			</option>
																		</c:forEach>
																	</select>
																	<p class="error-container" id="work-sector-type-error_1"></p>
																</div>
															</div>
															
															<c:choose>
																<c:when test="${not empty primaryworkDetail.getWorkSectorTypeOther()}">
																	<div class="col-lg-4 col-md-6 " id="worksectorTypediv_1">
																		<div class="form-group">
																			<label class="control-label "><liferay-ui:message key="primary-workplace-sector-type-other" /></label>
																			 <input type="text" name="<portlet:namespace/>worksectortypeother_1" id="worksectortypeother_1" value="Other" class="form-control">
																		</div>
																	</div>
																</c:when>
																<c:otherwise>
																	<div class="col-lg-4 col-md-6 d-none" id="worksectorTypediv_1">
																		<div class="form-group">
																			<label class="control-label "><liferay-ui:message key="primary-workplace-sector-type-other" /></label>
																			 <input type="text" name="<portlet:namespace/>worksectortypeother_1" id="worksectortypeother_1" value="Other" class="form-control">
																		</div>
																	</div>
																</c:otherwise>
															</c:choose>
															
															<!-- For Work Sector div start-->
												<c:choose>
													
														<c:when test="${primaryworkDetail.workSectorId>0}">
															<div class="col-lg-4 col-md-6" id="work-sector-div_1">
																<div class="form-group" >
																	<label class="control-label required"><liferay-ui:message key="primary-sector-name" /></label> 
																			<select name="<portlet:namespace/>worksector_1" id="worksector_1" class="form-control" onchange="getChildWorkSector(this.id,'first')" >
																				<option value=""><liferay-ui:message key="select" /></option>
																				<c:forEach var="workSector" items="${primaryworkDetail.workSectorItems.items}">
																					<option value="${workSector.getId()}" ${workSector.getId() == primaryworkDetail.getWorkSectorId() ? 'selected="selected"' : ''}>
																						${workSector.getWorkSector()}
																					</option>
																				</c:forEach>
																				<option value="other"><liferay-ui:message key="other" /></option>
																			</select>
																	<p class="error-container" id="work-sector-error_1"></p>
																</div>
															</div>
													</c:when>
														
													<c:when test="${not empty primaryworkDetail.workSectorOther}">
														<div class="col-lg-4 col-md-6" id="work-sector-div_1">
																<div class="form-group " >
																	<label class="control-label required"><liferay-ui:message key="primary-sector-name" /></label> 
																			<select name="<portlet:namespace/>worksector_1" id="worksector_1" class="form-control" onchange="getChildWorkSector(this.id,'first')" >
																				<option value=""><liferay-ui:message key="select" /></option>
																				<c:forEach var="workSector" items="${primaryworkDetail.workSectorItems.items}">
																					<option value="${workSector.getId()}" ${workSector.getId() == primaryworkDetail.getWorkSectorId() ? 'selected="selected"' : ''}>
																						${workSector.getWorkSector()}
																					</option>
																				</c:forEach>
																				<option value="other" selected="selected"><liferay-ui:message key="other"/></option>
																			</select>
																	<p class="error-container" id="work-sector-error_1"></p>
																</div>
															</div>
														
													</c:when>
													<c:when test="${primaryworkDetail.workSectorId==0 && not empty primaryworkDetail.workSectorOther}">
														<div class="col-lg-4 col-md-6 " id="work-sector-div_1">
																<div class="form-group " >
																	<label class="control-label required"><liferay-ui:message key="primary-sector-name" /></label> 
																			<select name="<portlet:namespace/>worksector_1" id="worksector_1" class="form-control" onchange="getChildWorkSector(this.id,'first')" >
																				<option value=""><liferay-ui:message key="select" /></option>
																				<option value="other" selected="selected"><liferay-ui:message key="other"/></option>
																			</select>
																	<p class="error-container" id="work-sector-error_1"></p>
																</div>
															</div>
													</c:when>
													<c:otherwise>
															<div class="col-lg-4 col-md-6 d-none" id="work-sector-div_1">
																<div class="form-group " >
																	<label class="control-label required"><liferay-ui:message key="primary-sector-name" /></label> 
																			<select name="<portlet:namespace/>worksector_1" id="worksector_1" class="form-control" onchange="getChildWorkSector(this.id,'first')" >
																				<option value=""><liferay-ui:message key="select" /></option>
																				<option value="other" selected="selected"><liferay-ui:message key="other"/></option>
																			</select>
																	<p class="error-container" id="work-sector-error_1"></p>
																</div>
															</div>
													</c:otherwise>
												</c:choose>
														<!-- For Work Sector div start End-->
														
														<!-- For Work Sector other div start-->
												<c:choose>
													<c:when test="${primaryworkDetail.workSectorId==0 && not empty primaryworkDetail.workSectorOther}">
														<div class="col-lg-4 col-md-6" id="div-o2-work-other_1">
															<div class="form-group">
																<label class="control-label "><liferay-ui:message key="please-specify" /></label>
																 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
																 <input type="text" name="<portlet:namespace/>worksectorother_1" id="worksectorother_1" class="form-control" value="${primaryworkDetail.workSectorOther}">
															</div>
														</div>
													</c:when>
													<c:when test="${primaryworkDetail.workSectorId==0 &&  empty primaryworkDetail.workSectorOther}">
														<div class="col-lg-4 col-md-6 d-none" id="div-o2-work-other_1">
															<div class="form-group">
																<label class="control-label "><liferay-ui:message key="please-specify" /></label>
																 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
																 <input type="text" name="<portlet:namespace/>worksectorother_1" id="worksectorother_1" class="form-control" value="${primaryworkDetail.workSectorOther}">
															</div>
														</div>
													</c:when>
													<c:otherwise>
														<div class="col-lg-4 col-md-6 d-none" id="div-o2-work-other_1">
																<div class="form-group">
																	<label class="control-label "><liferay-ui:message key="please-specify" /></label>
																	 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
																	 <input type="text" name="<portlet:namespace/>worksectorother_1" id="worksectorother_1" class="form-control" value="">
																</div>
															</div>
													</c:otherwise>
												</c:choose>
														<!-- For Work Sector Other div end-->
														
														<!-- For Level 2 Work Sector div Start-->		
												<c:choose>
													<c:when test="${primaryworkDetail.workSectorId>0 &&  primaryworkDetail.workSectorId2>0}">
														<div class="col-lg-4 col-md-6" id="div-first-sub-sector_1">
															<div class="form-group">
																<label class="control-label "><liferay-ui:message key="please-specify" /></label>
																<select name="<portlet:namespace/>first-sub-worksector_1" id="first-sub-worksector_1" class="form-control" onchange="getChildWorkSector2(this.id,'second')">
																<option value=""><liferay-ui:message key="select" /></option>
																<c:forEach var="workSubSector" items="${primaryworkDetail.workSubSectorItems.items}">
																			<option value="${workSubSector.getId()}" ${workSubSector.getId() == primaryworkDetail.getWorkSectorId2() ? 'selected="selected"' : ''}>
																				${workSubSector.getWorkSector()}
																			</option>
																</c:forEach>
																<option value="other"><liferay-ui:message key="other" /></option>
																</select>
															</div>
														</div>
													</c:when>
													<c:when test="${primaryworkDetail.workSectorId2==0 && not empty primaryworkDetail.workSectorOther2}">
														<div class="col-lg-4 col-md-6" id="div-first-sub-sector_1">
															<div class="form-group">
																<label class="control-label "><liferay-ui:message key="please-specify" /></label>
																<select name="<portlet:namespace/>first-sub-worksector_1" id="first-sub-worksector_1" class="form-control" onchange="getChildWorkSector2(this.id,'second')">
																	<option value=""><liferay-ui:message key="select" /></option>
																	<c:forEach var="workSubSector" items="${primaryworkDetail.workSubSectorItems.items}">
																			<option value="${workSubSector.getId()}" ${workSubSector.getId() == primaryworkDetail.getWorkSectorId2() ? 'selected="selected"' : ''}>
																				${workSubSector.getWorkSector()}
																			</option>
																</c:forEach>
																<option value="other" selected="selected"><liferay-ui:message key="other" /></option>
																</select>
															</div>
														</div>
													</c:when>
													<c:otherwise>
															<div class="col-lg-4 col-md-6 d-none" id="div-first-sub-sector_1">
																<div class="form-group">
																	<label class="control-label "><liferay-ui:message key="please-specify" /></label>
																	<select name="<portlet:namespace/>first-sub-worksector_1" id="first-sub-worksector_1" class="form-control" onchange="getChildWorkSector2(this.id,'second')">
																		<option value=""><liferay-ui:message key="select" /></option>
																		<option value="other"><liferay-ui:message key="other" /></option>
																	</select>
																</div>
															</div>
													</c:otherwise>
												</c:choose>
														<!-- For Level 2 Work Sector div end-->
														
														<!-- For Level 2 Work Sector Other div Start-->
												<c:choose>
													<c:when test="${ not empty primaryworkDetail.workSectorOther2}">
													<div class="col-lg-4 col-md-6 " id="div-o3-work-other_1">
														<div class="form-group">
															<label class="control-label "><liferay-ui:message key="please-specify" /></label>
															 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
															 <input type="text" name="<portlet:namespace/>work_sub_sectorother_1" id="worksectorother_1" class="form-control" value="${primaryworkDetail.workSectorOther2}">
														</div>
													</div>
													</c:when>
													<c:otherwise>
													<div class="col-lg-4 col-md-6  d-none " id="div-o3-work-other_1">
														<div class="form-group">
															<label class="control-label "><liferay-ui:message key="please-specify" /></label>
															 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
															 <input type="text" name="<portlet:namespace/>work_sub_sectorother_1" id="worksectorother_1" class="form-control" value="">
														</div>
													</div>
													</c:otherwise>
												</c:choose>
													<!-- For Level 2 Work Sector Other div End-->
													
													<!-- Third Level Work Sector Start-->
												<c:choose>
													<c:when test="${primaryworkDetail.workSectorId2>0 &&  primaryworkDetail.workSectorId3>0}">
														<div class="col-lg-4 col-md-6 1" id="div-second-sub-sector_1">
															<div class="form-group">
																<label class="control-label "><liferay-ui:message key="please-specify" /></label>
																<select name="<portlet:namespace/>second-sub-worksector_1" id="second-sub-worksector_1" class="form-control"   onchange="getChildWorkSector3(this.id,'second')">
																	<option value=""><liferay-ui:message key="select" /></option>
																	<c:forEach var="workSecondSubSector" items="${primaryworkDetail.workSecondSubSectorItems.items}">
																			<option value="${workSecondSubSector.getId()}" ${workSecondSubSector.getId() == primaryworkDetail.getWorkSectorId3() ? 'selected="selected"' : ''}>
																				${workSecondSubSector.getWorkSector()}
																			</option>
																</c:forEach>
																<option value="other"><liferay-ui:message key="other" /></option>
																</select>
															</div>
														</div>
													</c:when>
													<c:when test="${primaryworkDetail.workSectorId3==0 && not empty primaryworkDetail.workSectorOther3}">
															<div class="col-lg-4 col-md-6 2" id="div-second-sub-sector_1">
																<div class="form-group">
																	<label class="control-label "><liferay-ui:message key="please-specify" /></label>
																	<select name="<portlet:namespace/>second-sub-worksector_1" id="second-sub-worksector_1" class="form-control"   onchange="getChildWorkSector3(this.id,'second')">
																	<option value=""><liferay-ui:message key="select" /></option>
																	<c:forEach var="workSecondSubSector" items="${primaryworkDetail.workSecondSubSectorItems.items}">
																			<option value="${workSecondSubSector.getId()}">
																				${workSecondSubSector.getWorkSector()}
																			</option>
																</c:forEach>
																<option value="other" selected="selected"><liferay-ui:message key="other" /></option>
																</select>
																</div>
															</div>
													</c:when>
													<c:otherwise>
															<div class="col-lg-4 col-md-6 3 d-none" id="div-second-sub-sector_1">
																<div class="form-group">
																	<label class="control-label "><liferay-ui:message key="please-specify" /></label>
																	<select name="<portlet:namespace/>second-sub-worksector_1" id="second-sub-worksector_1" class="form-control"   onchange="getChildWorkSector3(this.id,'second')">
																		<option value=""><liferay-ui:message key="select" /></option>
																		<option value="other"><liferay-ui:message key="other" /></option>
																	</select>
																</div>
															</div>
													</c:otherwise>
															
												</c:choose>
													<!-- Third Level Work Sector End-->
													
													<!-- Third Level Work Sector Other Start-->
													<c:choose>
														<c:when test="${primaryworkDetail.workSectorId3==0 &&  not empty primaryworkDetail.workSectorOther3}">
														<div class="col-lg-4 col-md-6" id="div-o3-secons-work-other_1">
																<div class="form-group">
																	<label class="control-label "><liferay-ui:message key="please-specify" /></label>
																	 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
																	 <input type="text" name="<portlet:namespace/>work_second_sub_sectorother_1" id="worksecondsectorother_1" class="form-control" value="${primaryworkDetail.workSectorOther3}">
																</div>
														</div>
														</c:when>
														<c:otherwise>
														<div class="col-lg-4 col-md-6 d-none " id="div-o3-secons-work-other_1">
																<div class="form-group">
																	<label class="control-label "><liferay-ui:message key="please-specify" /></label>
																	 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
																	 <input type="text" name="<portlet:namespace/>work_second_sub_sectorother_1" id="worksecondsectorother_1" class="form-control" value="">
																</div>
														</div>
														</c:otherwise>
													</c:choose>
													<!-- Third Level Work Sector Other Ends-->
													
													
														<div class="col-lg-4 col-md-6">
															<div class="form-group">
																<label class="control-label required"><liferay-ui:message key="region-location-primary-institution" /></label>
																		<select name="<portlet:namespace/>wilayats_1" id="wilayats_1" class="form-control" onchange="validateField(this.id,'location-error_1','<liferay-ui:message key="please-enter-work-sector-location" />')">
																	
																	<option value=""><liferay-ui:message key="select" /></option>
																	<c:forEach var="wilayats" items="${wilayats}">
																		<option value="${wilayats.getKey()}" ${wilayats.getKey() == primaryworkDetail.getWorkSectorLocation() ? 'selected' : ''}>
																			<liferay-ui:message key="${wilayats.getName(themeDisplay.getLocale())}" />
																		</option>
																	</c:forEach>
																</select>
																<p class="error-container" id="location-error_1"></p>
															</div>
														</div>
														
														<div class="col-lg-4 col-md-6">
															<div class="form-group">
																<label class="control-label required"><liferay-ui:message key="designation" /></label>
																	<select name="<portlet:namespace/>designations_1" id="designations_1" onchange="showDesignationOther(this.id,'designation-error_1','<liferay-ui:message key="please-enter-designation" />')" class="form-control designation">
																	<option value=""><liferay-ui:message key="select" /></option>
																	<c:forEach var="designations" items="${designations}">
																		<option value="${designations.getKey()}" ${designations.getKey() == primaryworkDetail.getDesignationId() ? 'selected="selected"' : ''}>
																			<liferay-ui:message key="${designations.getName(themeDisplay.getLocale())}" />
																		</option>
																	</c:forEach>
																</select>
																<p class="error-container" id="designation-error_1"></p>
															</div>
														</div>
														
														<div class="col-lg-4 col-md-6 d-none" id="designationotherdiv_1">
															<div class="form-group">
																<label class="control-label "><liferay-ui:message key="designation-other" /></label> 
																<input type="text" name="<portlet:namespace/>designationother_1" id="designationother_1" value="${primaryworkDetail.getDesignationOther() }" class="form-control">
															</div>
														</div>
														
														<div class="col-lg-12 col-md-12">
															<div class="row">
														      <div class="col-lg-10 col-md-10">
																	<div class="form-group">
																		<label class="control-label"><liferay-ui:message key="staff-card-id" /></label>
																		<div class="omsb-custom-html-file custom-file">
																			<input id="staffIdCard_1" name="<portlet:namespace/>staffIdCard_1"   type="file" label="" class="form-control custom-file-input" onchange="validateFile(this.id,'file-size-error_1','<liferay-ui:message key="please-select-pdf-file" />')">
																			<label class="custom-file-label" for="staffIdCard_1" id="customStaffIdCard_1">
																			 <c:if test="${not empty primaryworkDetail.getStaffIdCard()}">
																			      ${primaryworkDetail.getUploadFileName()}
																			 </c:if>
																			</label>
																			<c:choose>
																				<c:when test="${not empty primaryworkDetail.getStaffIdCard()}">
																					<input type="hidden" id="uploadFile_1" value="${primaryworkDetail.getStaffIdCard()}" name="<portlet:namespace/>uploadFile_1" />
																				</c:when>
																				<c:otherwise>
																					<input type="hidden" id="uploadFile_1" value="" name="<portlet:namespace/>uploadFile_1" />
																				</c:otherwise>
																			</c:choose>
																		</div>	
																		   <p class="error-container" id="file-size-error_1"></p>
																			<p class="error-container"id="errorContainer-work-detail-file_1"></p>
																	</div>
																</div>
																<div class="col-lg-2 col-md-2">
																	   <div class="form-group">
																			<label class="control-label"></label>
																				<a class="btn view_btn text-danger"  title="<liferay-ui:message key="view" />" target="_blank" href="${primaryworkDetail.getDocumentUrl() }">
																					<img src="<%=themeDisplay.getPathThemeImages()%>/svg/view_icon.svg" alt=""> <liferay-ui:message key="view-file" />
																				</a>
																		</div>
														 		</div>
													 		</div>
														 </div>	
														
														</div>
													</div>
												</div>
										</c:otherwise>
									</c:choose>
					
					<c:choose>
		<c:when test="${empty secondaryWorkDetail}">
			<div class="omsb-card omsb-card-graybg omsb-noBorderRadius work_detail" id="work_detail_2">
				<input type="hidden" name="<portlet:namespace/>id_2" id="<portlet:namespace/>id_2"> 
				<input type="hidden" name="<portlet:namespace/>isPrimary_2" id="<portlet:namespace/>isPrimary_2" value="false">
					<div class="">
						<label class="control-label"><liferay-ui:message key="secondary-work-detail" /></label>
						<div class="row ">
							<div class="col-lg-4 col-md-6">
								<div class="form-group">
									<label class="control-label  required"><liferay-ui:message key="secondary-workplace-sector-type" /></label> 
									<select name="<portlet:namespace/>workSectorType_2" id="workSectorType_2" class="form-control" onchange="getWorkSector(this.id)">
										<option value=""><liferay-ui:message key="select" /></option>
										<c:forEach var="workSectorType" items="${workSectorTypeList}">
											<option value="${workSectorType.getListTypeEntryId()}"> <liferay-ui:message key="${workSectorType.getName(themeDisplay.getLocale())}" /></option>
										</c:forEach>
									</select>
									<p class="error-container" id="work-sector-type-error_2"></p>
								</div>
							</div>
							<div class="col-lg-4 col-md-6 d-none" id="worksectorTypediv_2">
										<div class="form-group">
											<label class="control-label "><liferay-ui:message key="secondary-workplace-sector-type-other" /></label>
											 <input type="text" name="<portlet:namespace/>worksectortypeother_2" id="worksectortypeother_2" value="Other" class="form-control">
										</div>
							</div>
							<div class="col-lg-4 col-md-6" id="work-sector-div_2">
								<div class="form-group" >
									<label class="control-label required"><liferay-ui:message key="secondary-sector-name" /></label>
									  
									  <select name="<portlet:namespace/>worksector_2" id="worksector_2" class="form-control" onchange="getChildWorkSector(this.id,'first')" >
														<option value="" selected="selected"><liferay-ui:message key="select" /></option>
									</select>
									 <%--  <input type="text" class="form-control worksector_2" id="worksector_2" name="<portlet:namespace/>worksector_2" placeholder="" autocomplete="off"/> --%>
									<p class="error-container" id="work-sector-error_2"></p>
								</div>
							</div>
							<div class="col-lg-4 col-md-6 d-none" id="div-o2-work-other_2">
								<div class="form-group">
									<label class="control-label "><liferay-ui:message key="please-specify" /></label>
									 <input type="text" name="<portlet:namespace/>worksectorother_2" id="worksectorother_2" class="form-control"> 
								</div>
							</div>
							<div class="col-lg-4 col-md-6 d-none" id="div-first-sub-sector_2">
									<div class="form-group">
										<label class="control-label "><liferay-ui:message key="please-specify" /></label>
										<select name="<portlet:namespace/>first-sub-worksector_2" id="first-sub-worksector_2" class="form-control" onchange="getChildWorkSector2(this.id,'second')">
											<option value=""><liferay-ui:message key="select" /></option>
											<option value="other" selected="selected"><liferay-ui:message key="other" /></option>
										</select>
									</div>
							</div>
							<div class="col-lg-4 col-md-6  d-none " id="div-o3-work-other_2">
									<div class="form-group">
										<label class="control-label "><liferay-ui:message key="please-specify" /></label>
										 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
										 <input type="text" name="<portlet:namespace/>work_sub_sectorother_2" id="worksectorother_2" class="form-control" value="">
									</div>
							</div>
							<!-- Third level -->
								<div class="col-lg-4 col-md-6 d-none" id="div-second-sub-sector_2">
									<div class="form-group">
										<label class="control-label "><liferay-ui:message key="please-specify" /></label>
										<select name="<portlet:namespace/>second-sub-worksector_2" id="second-sub-worksector_2" class="form-control"   onchange="getChildWorkSector3(this.id,'second')">
											<option value=""><liferay-ui:message key="select" /></option>
											<option value="other" selected="selected"><liferay-ui:message key="other" /></option>
										</select>
									</div>
								</div>
								<div class="col-lg-4 col-md-6  d-none " id="div-o3-secons-work-other_2">
										<div class="form-group">
											<label class="control-label "><liferay-ui:message key="please-specify" /></label>
											 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
											 <input type="text" name="<portlet:namespace/>work_second_sub_sectorother_2" id="worksecondsectorother_2" class="form-control" value="">
										</div>
								</div>
							<!-- Third level -->
							
							
							<div class="col-lg-4 col-md-6">
								<div class="form-group">
									<label class="control-label required"><liferay-ui:message key="region-location-secondary-institution" /></label> 
									<select name="<portlet:namespace/>wilayats_2" id="wilayats_2" class="form-control" onchange="validateField(this.id,'location-error_2','<liferay-ui:message key="please-enter-work-sector-location" />')">
										<option value=""><liferay-ui:message key="select" /></option>
										<c:forEach var="wilayats" items="${wilayats}">
											<option value="${wilayats.getKey()}">
												<liferay-ui:message key="${wilayats.getName(themeDisplay.getLocale())}" />
											</option>
										</c:forEach>
									</select>
									<p class="error-container" id="location-error_2"></p>
								</div>
							</div>
							<div class="col-lg-4 col-md-6">
								<div class="form-group">
									<label class="control-label required"><liferay-ui:message key="designation" /></label>
									 <select name="<portlet:namespace/>designations_2" id="designations_2" onchange="showDesignationOther(this.id,'designation-error_2','<liferay-ui:message key="please-enter-designation" />')" class="form-control designation">
										<option value=""><liferay-ui:message key="select" /></option>
										<c:forEach var="designations" items="${designations}">
											<option value="${designations.getKey()}">
												<liferay-ui:message key="${designations.getName(themeDisplay.getLocale())}" />
											</option>
										</c:forEach>
									</select>
									<p class="error-container" id="designation-error_2"></p>
								</div>
							</div>
							<div class="col-lg-4 col-md-6 d-none" id="designationotherdiv_2">
								<div class="form-group">
									<label class="control-label "><liferay-ui:message key="designation-other" /></label>
									 <input type="text" name="<portlet:namespace/>designationother_2" id="designationother_2" value="" class="form-control">
								</div>
							</div>
							<div class="col-lg-12 col-md-12">
								<div class="form-group">
									<label class="control-label"><liferay-ui:message key="staff-card-id" /></label>
									<div class="omsb-custom-html-file custom-file">
										<input id="staffIdCard_2" name="<portlet:namespace/>staffIdCard_2" type="file" label="" class="form-control custom-file-input"  onchange="validateFile(this.id,'file-size-error_2','<liferay-ui:message key="please-select-pdf-file" />')">
										<label class="custom-file-label" for="staffIdCard_2" id="customStaffIdCard_"> </label>
									</div>
									<p class="error-container" id="file-size-error_2"></p>
									<p class="error-container" id="errorContainer-work-detail-file_2"></p>
								</div>
							</div>
						</div>
						<div class="bottom-backbtn-wrap"></div>
					</div>
				</div>
			</c:when>
			<c:otherwise>
					<div class="omsb-card omsb-card-graybg omsb-noBorderRadius work_detail" id="work_detail_2">
						<input type="hidden" name="<portlet:namespace/>id_2" id="<portlet:namespace/>id_2" value="${secondaryWorkDetail.getId()}">	
						<div class="">
								<label class="control-label"><liferay-ui:message key="secondary-work-detail" /></label>
								<input type="hidden" name="<portlet:namespace/>isPrimary_2" id="<portlet:namespace/>isPrimary_2" value="false">
							<div class="row ">
									<div class="col-lg-4 col-md-6">
										<div class="form-group">
											<label class="control-label required"><liferay-ui:message key="secondary-workplace-sector-type" /></label>
												<!-- Changes Abhi  starts -->
													 <%-- <select name="<portlet:namespace/>workSectorType_${loop.count }" id="workSectorType_${loop.count }" class="form-control" onchange="validateField(this.id,'work-sector-type-error_${loop.count }','<liferay-ui:message key="please-enter-work-sector-type" />')"> --%>
												 <select name="<portlet:namespace/>workSectorType_2" id="workSectorType_2" class="form-control 3" onchange="getWorkSector(this.id)">
														<option value=""><liferay-ui:message key="select" /></option>
												<c:forEach var="workSectorType" items="${workSectorTypeList}">
													<option value="${workSectorType.getListTypeEntryId()}" ${workSectorType.getListTypeEntryId() == secondaryWorkDetail.getWorkSectorType() ? 'selected="selected"' : ''}>
														<liferay-ui:message key="${workSectorType.getName(themeDisplay.getLocale())}" />
													</option>
												</c:forEach>
											</select>
											<p class="error-container" id="work-sector-type-error_2"></p>
										</div>
									</div>
									
									<c:choose>
										<c:when test="${not empty secondaryWorkDetail.getWorkSectorTypeOther()}">
											<div class="col-lg-4 col-md-6 " id="worksectorTypediv_2">
												<div class="form-group">
													<label class="control-label "><liferay-ui:message key="secondary-workplace-sector-type-other" /></label>
													 <input type="text" name="<portlet:namespace/>worksectortypeother_2" id="worksectortypeother_2" value="Other" class="form-control">
												</div>
											</div>
										</c:when>
										<c:otherwise>
											<div class="col-lg-4 col-md-6 d-none" id="worksectorTypediv_2">
												<div class="form-group">
													<label class="control-label "><liferay-ui:message key="secondary-workplace-sector-type-other" /></label>
													 <input type="text" name="<portlet:namespace/>worksectortypeother_2" id="worksectortypeother_2" value="Other" class="form-control">
												</div>
											</div>
										</c:otherwise>
									</c:choose>
									
									<!-- For Work Sector div start-->
						<c:choose>
							
								<c:when test="${secondaryWorkDetail.workSectorId>0}">
									<div class="col-lg-4 col-md-6" id="work-sector-div_2">
										<div class="form-group" >
											<label class="control-label required"><liferay-ui:message key="secondary-sector-name" /></label> 
													<select name="<portlet:namespace/>worksector_2" id="worksector_2" class="form-control" onchange="getChildWorkSector(this.id,'first')" >
														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="workSector" items="${secondaryWorkDetail.workSectorItems.items}">
															<option value="${workSector.getId()}" ${workSector.getId() == secondaryWorkDetail.getWorkSectorId() ? 'selected="selected"' : ''}>
																${workSector.getWorkSector()}
															</option>
														</c:forEach>
														<option value="other"><liferay-ui:message key="other" /></option>
													</select>
											<p class="error-container" id="work-sector-error_2"></p>
										</div>
									</div>
							</c:when>
								
							<c:when test="${not empty secondaryWorkDetail.workSectorOther}">
								<div class="col-lg-4 col-md-6" id="work-sector-div_2">
										<div class="form-group " >
											<label class="control-label required"><liferay-ui:message key="secondary-sector-name" /></label> 
													<select name="<portlet:namespace/>worksector_2" id="worksector_2" class="form-control" onchange="getChildWorkSector(this.id,'first')" >
														<option value=""><liferay-ui:message key="select" /></option>
														<c:forEach var="workSector" items="${secondaryWorkDetail.workSectorItems.items}">
															<option value="${workSector.getId()}" ${workSector.getId() == secondaryWorkDetail.getWorkSectorId() ? 'selected="selected"' : ''}>
																${workSector.getWorkSector()}
															</option>
														</c:forEach>
														<option value="other" selected="selected"><liferay-ui:message key="other"/></option>
													</select>
											<p class="error-container" id="work-sector-error_2"></p>
										</div>
									</div>
								
							</c:when>
							<c:when test="${secondaryWorkDetail.workSectorId==0 && not empty secondaryWorkDetail.workSectorOther}">
								<div class="col-lg-4 col-md-6 " id="work-sector-div_2">
										<div class="form-group " >
											<label class="control-label required"><liferay-ui:message key="secondary-sector-name" /></label> 
													<select name="<portlet:namespace/>worksector_2" id="worksector_2" class="form-control" onchange="getChildWorkSector(this.id,'first')" >
														<option value=""><liferay-ui:message key="select" /></option>
														<option value="other" selected="selected"><liferay-ui:message key="other"/></option>
													</select>
											<p class="error-container" id="work-sector-error_2"></p>
										</div>
									</div>
							</c:when>
							<c:otherwise>
									<div class="col-lg-4 col-md-6 d-none" id="work-sector-div_2">
										<div class="form-group " >
											<label class="control-label required"><liferay-ui:message key="secondary-sector-name" /></label> 
													<select name="<portlet:namespace/>worksector_2" id="worksector_2" class="form-control" onchange="getChildWorkSector(this.id,'first')" >
														<option value=""><liferay-ui:message key="select" /></option>
														<option value="other" selected="selected"><liferay-ui:message key="other"/></option>
													</select>
											<p class="error-container" id="work-sector-error_2"></p>
										</div>
									</div>
							</c:otherwise>
						</c:choose>
								<!-- For Work Sector div start End-->
								
								<!-- For Work Sector other div start-->
						<c:choose>
							<c:when test="${secondaryWorkDetail.workSectorId==0 && not empty secondaryWorkDetail.workSectorOther}">
								<div class="col-lg-4 col-md-6" id="div-o2-work-other_2">
									<div class="form-group">
										<label class="control-label "><liferay-ui:message key="please-specify" /></label>
										 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
										 <input type="text" name="<portlet:namespace/>worksectorother_2" id="worksectorother_2" class="form-control" value="${secondaryWorkDetail.workSectorOther}">
									</div>
								</div>
							</c:when>
							<c:when test="${secondaryWorkDetail.workSectorId==0 &&  empty secondaryWorkDetail.workSectorOther}">
								<div class="col-lg-4 col-md-6 d-none" id="div-o2-work-other_2">
									<div class="form-group">
										<label class="control-label "><liferay-ui:message key="please-specify" /></label>
										 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
										 <input type="text" name="<portlet:namespace/>worksectorother_2" id="worksectorother_2" class="form-control" value="${secondaryWorkDetail.workSectorOther}">
									</div>
								</div>
							</c:when>
							<c:otherwise>
								<div class="col-lg-4 col-md-6 d-none" id="div-o2-work-other_2">
										<div class="form-group">
											<label class="control-label "><liferay-ui:message key="please-specify" /></label>
											 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
											 <input type="text" name="<portlet:namespace/>worksectorother_2" id="worksectorother_2" class="form-control" value="">
										</div>
									</div>
							</c:otherwise>
						</c:choose>
								<!-- For Work Sector Other div end-->
								
								<!-- For Level 2 Work Sector div Start-->		
						<c:choose>
							<c:when test="${secondaryWorkDetail.workSectorId>0 &&  secondaryWorkDetail.workSectorId2>0}">
								<div class="col-lg-4 col-md-6" id="div-first-sub-sector_2">
									<div class="form-group">
										<label class="control-label "><%-- <liferay-ui:message key="secondary-first-sub-sector-name" /> --%></label>
										<select name="<portlet:namespace/>first-sub-worksector_2" id="first-sub-worksector_2" class="form-control" onchange="getChildWorkSector2(this.id,'second')">
										<option value=""><liferay-ui:message key="select" /></option>
										<c:forEach var="workSubSector" items="${secondaryWorkDetail.workSubSectorItems.items}">
													<option value="${workSubSector.getId()}" ${workSubSector.getId() == secondaryWorkDetail.getWorkSectorId2() ? 'selected="selected"' : ''}>
														${workSubSector.getWorkSector()}
													</option>
										</c:forEach>
										<option value="other"><liferay-ui:message key="other" /></option>
										</select>
									</div>
								</div>
							</c:when>
							<c:when test="${secondaryWorkDetail.workSectorId2==0 && not empty secondaryWorkDetail.workSectorOther2}">
								<div class="col-lg-4 col-md-6" id="div-first-sub-sector_2">
									<div class="form-group">
										<label class="control-label "><liferay-ui:message key="please-specify" /></label>
										<select name="<portlet:namespace/>first-sub-worksector_2" id="first-sub-worksector_2" class="form-control" onchange="getChildWorkSector2(this.id,'second')">
											<option value=""><liferay-ui:message key="select" /></option>
											<c:forEach var="workSubSector" items="${secondaryWorkDetail.workSubSectorItems.items}">
													<option value="${workSubSector.getId()}" ${workSubSector.getId() == secondaryWorkDetail.getWorkSectorId2() ? 'selected="selected"' : ''}>
														${workSubSector.getWorkSector()}
													</option>
										</c:forEach>
										<option value="other" selected="selected"><liferay-ui:message key="other" /></option>
										</select>
									</div>
								</div>
							</c:when>
							<c:otherwise>
									<div class="col-lg-4 col-md-6 d-none" id="div-first-sub-sector_2">
										<div class="form-group">
											<label class="control-label "><liferay-ui:message key="please-specify" /></label>
											<select name="<portlet:namespace/>first-sub-worksector_2" id="first-sub-worksector_2" class="form-control" onchange="getChildWorkSector2(this.id,'second')">
												<option value=""><liferay-ui:message key="select" /></option>
												<option value="other"><liferay-ui:message key="other" /></option>
											</select>
										</div>
									</div>
							</c:otherwise>
						</c:choose>
								<!-- For Level 2 Work Sector div end-->
								
								<!-- For Level 2 Work Sector Other div Start-->
						<c:choose>
							<c:when test="${ not empty secondaryWorkDetail.workSectorOther2}">
							<div class="col-lg-4 col-md-6 " id="div-o3-work-other_2">
								<div class="form-group">
									<label class="control-label "><liferay-ui:message key="please-specify" /></label>
									 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
									 <input type="text" name="<portlet:namespace/>work_sub_sectorother_2" id="worksectorother_2" class="form-control" value="${secondaryWorkDetail.workSectorOther2}">
								</div>
							</div>
							</c:when>
							<c:otherwise>
							<div class="col-lg-4 col-md-6  d-none " id="div-o3-work-other_2">
								<div class="form-group">
									<label class="control-label "><liferay-ui:message key="please-specify" /></label>
									 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
									 <input type="text" name="<portlet:namespace/>work_sub_sectorother_2" id="worksectorother_2" class="form-control" value="">
								</div>
							</div>
							</c:otherwise>
						</c:choose>
							<!-- For Level 2 Work Sector Other div End-->
							
							<!-- Third Level Work Sector Start-->
						<c:choose>
							<c:when test="${secondaryWorkDetail.workSectorId2>0 &&  secondaryWorkDetail.workSectorId3>0}">
								<div class="col-lg-4 col-md-6 1" id="div-second-sub-sector_2">
									<div class="form-group">
										<label class="control-label "><liferay-ui:message key="please-specify" /></label>
										<select name="<portlet:namespace/>second-sub-worksector_2" id="second-sub-worksector_2" class="form-control"   onchange="getChildWorkSector3(this.id,'second')">
											<option value=""><liferay-ui:message key="select" /></option>
											<c:forEach var="workSecondSubSector" items="${secondaryWorkDetail.workSecondSubSectorItems.items}">
													<option value="${workSecondSubSector.getId()}" ${workSecondSubSector.getId() == secondaryWorkDetail.getWorkSectorId3() ? 'selected="selected"' : ''}>
														${workSecondSubSector.getWorkSector()}
													</option>
										</c:forEach>
										<option value="other"><liferay-ui:message key="other" /></option>
										</select>
									</div>
								</div>
							</c:when>
							<c:when test="${secondaryWorkDetail.workSectorId3==0 && not empty secondaryWorkDetail.workSectorOther3}">
									<div class="col-lg-4 col-md-6 2" id="div-second-sub-sector_2">
										<div class="form-group">
											<label class="control-label "><liferay-ui:message key="please-specify" /></label>
											<select name="<portlet:namespace/>second-sub-worksector_2" id="second-sub-worksector_2" class="form-control"   onchange="getChildWorkSector3(this.id,'second')">
											<option value=""><liferay-ui:message key="select" /></option>
											<c:forEach var="workSecondSubSector" items="${secondaryWorkDetail.workSecondSubSectorItems.items}">
													<option value="${workSecondSubSector.getId()}">
														${workSecondSubSector.getWorkSector()}
													</option>
										</c:forEach>
										<option value="other" selected="selected"><liferay-ui:message key="other" /></option>
										</select>
										</div>
									</div>
							</c:when>
							<c:otherwise>
									<div class="col-lg-4 col-md-6 3 d-none" id="div-second-sub-sector_2">
										<div class="form-group">
											<label class="control-label "><liferay-ui:message key="please-specify" /></label>
											<select name="<portlet:namespace/>second-sub-worksector_2" id="second-sub-worksector_2" class="form-control"   onchange="getChildWorkSector3(this.id,'second')">
												<option value=""><liferay-ui:message key="select" /></option>
												<option value="other"><liferay-ui:message key="other" /></option>
											</select>
										</div>
									</div>
							</c:otherwise>
									
						</c:choose>
							<!-- Third Level Work Sector End-->
							
							<!-- Third Level Work Sector Other Start-->
							<c:choose>
								<c:when test="${secondaryWorkDetail.workSectorId3==0 &&  not empty secondaryWorkDetail.workSectorOther3}">
								<div class="col-lg-4 col-md-6" id="div-o3-secons-work-other_2">
										<div class="form-group">
											<label class="control-label "><liferay-ui:message key="please-specify" /></label>
											 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
											 <input type="text" name="<portlet:namespace/>work_second_sub_sectorother_2" id="worksecondsectorother_2" class="form-control" value="${secondaryWorkDetail.workSectorOther3}">
										</div>
								</div>
								</c:when>
								<c:otherwise>
								<div class="col-lg-4 col-md-6 d-none " id="div-o3-secons-work-other_2">
										<div class="form-group">
											<label class="control-label "><liferay-ui:message key="please-specify" /></label>
											 <%-- <input type="text" name="<portlet:namespace/>worksectorother_${loop.count }" id="worksectorother_${loop.count }" class="form-control" value="${workDetail.getWorkSectorOther() }"> --%>
											 <input type="text" name="<portlet:namespace/>work_second_sub_sectorother_2" id="worksecondsectorother_2" class="form-control" value="">
										</div>
								</div>
								</c:otherwise>
							</c:choose>
							<!-- Third Level Work Sector Other Ends-->
							
							
								<div class="col-lg-4 col-md-6">
									<div class="form-group">
										<label class="control-label required"><liferay-ui:message key="region-location-secondary-institution" /></label>
												<select name="<portlet:namespace/>wilayats_2" id="wilayats_2" class="form-control" onchange="validateField(this.id,'location-error_2','<liferay-ui:message key="please-enter-work-sector-location" />')">
											
											<option value=""><liferay-ui:message key="select" /></option>
											<c:forEach var="wilayats" items="${wilayats}">
												<option value="${wilayats.getKey()}" ${wilayats.getKey() == secondaryWorkDetail.getWorkSectorLocation() ? 'selected' : ''}>
													<liferay-ui:message key="${wilayats.getName(themeDisplay.getLocale())}" />
												</option>
											</c:forEach>
										</select>
										<p class="error-container" id="location-error_2"></p>
									</div>
								</div>
								
								<div class="col-lg-4 col-md-6">
									<div class="form-group">
										<label class="control-label required"><liferay-ui:message key="designation" /></label>
											<select name="<portlet:namespace/>designations_2" id="designations_2" onchange="showDesignationOther(this.id,'designation-error_2','<liferay-ui:message key="please-enter-designation" />')" class="form-control designation">
											<option value=""><liferay-ui:message key="select" /></option>
											<c:forEach var="designations" items="${designations}">
												<option value="${designations.getKey()}" ${designations.getKey() == secondaryWorkDetail.getDesignationId() ? 'selected="selected"' : ''}>
													<liferay-ui:message key="${designations.getName(themeDisplay.getLocale())}" />
												</option>
											</c:forEach>
										</select>
										<p class="error-container" id="designation-error_2"></p>
									</div>
								</div>
								
								<div class="col-lg-4 col-md-6 d-none" id="designationotherdiv_2">
									<div class="form-group">
										<label class="control-label "><liferay-ui:message key="designation-other" /></label> 
										<input type="text" name="<portlet:namespace/>designationother_2" id="designationother_2" value="${secondaryWorkDetail.getDesignationOther() }" class="form-control">
									</div>
								</div>
								
								<div class="col-lg-12 col-md-12">
									<div class="row">
									  <div class="col-lg-10 col-md-10">
											<div class="form-group">
												<label class="control-label"><liferay-ui:message key="staff-card-id" /></label>
												<div class="omsb-custom-html-file custom-file">
													<input id="staffIdCard_2" name="<portlet:namespace/>staffIdCard_2"   type="file" label="" class="form-control custom-file-input" onchange="validateFile(this.id,'file-size-error_2','<liferay-ui:message key="please-select-pdf-file" />')">
													<label class="custom-file-label" for="staffIdCard_2" id="customStaffIdCard_2">
													 <c:if test="${not empty secondaryWorkDetail.getStaffIdCard()}">
														  ${secondaryWorkDetail.getUploadFileName()}
													 </c:if>
													</label>
													<c:choose>
														<c:when test="${not empty secondaryWorkDetail.getStaffIdCard()}">
															<input type="hidden" id="uploadFile_2" value="${secondaryWorkDetail.getStaffIdCard()}" name="<portlet:namespace/>uploadFile_2" />
														</c:when>
														<c:otherwise>
															<input type="hidden" id="uploadFile_2" value="" name="<portlet:namespace/>uploadFile_2" />
														</c:otherwise>
													</c:choose>
												</div>	
												   <p class="error-container" id="file-size-error_2"></p>
													<p class="error-container"id="errorContainer-work-detail-file_2"></p>
											</div>
										</div>
										<div class="col-lg-2 col-md-2">
											   <div class="form-group">
													<label class="control-label"></label>
														<a class="btn view_btn text-danger"  title="<liferay-ui:message key="view" />" target="_blank" href="${secondaryWorkDetail.getDocumentUrl() }">
															<img src="<%=themeDisplay.getPathThemeImages()%>/svg/view_icon.svg" alt=""> <liferay-ui:message key="view-file" />
														</a>
												</div>
										</div>
									</div>
								 </div>	
								
								</div>
							</div>
						</div>
				</c:otherwise>
</c:choose>
					
								</div>
							</div>
							
							<div class="row mt-4 ${themeDisplay.isSignedIn()?'d-none':''}" id="user-declarations">
								<div class="col-lg-12 col-md-12 col-sm-12">
									<div class="form-group">
										<div class="custom-control custom-checkbox ">
											<input type="checkbox" class="custom-control-input checkbox" id="declare1" name="<portlet:namespace/>declare1" ${isDeclared==true?'checked':''}>
											 <label class="custom-control-label m-0" for="declare1" ><liferay-ui:message key="declaration" /> 
											   <!-- <span class="required" ></span> -->
											 </label>
										</div>
									</div>
								</div>
								<div class="col-lg-12 col-md-12 col-sm-12">
									<div class="form-group">
										<div class="custom-control custom-checkbox ">
											<input type="checkbox" class="custom-control-input checkbox" id="declare2" name="<portlet:namespace/>declare2" ${isAgreed==true?'checked':''}>
											 <label class="custom-control-label m-0" for="declare2"><liferay-ui:message key="agreement" /></label>
										</div>
									</div>
								</div>
							</div>
							<div class="bottom-backbtn-wrap">
								<button class="btn omsb-bc-red-button" type="button" title="<liferay-ui:message key="save-at-this-stage" />" onclick="saveWorkDetail('save')" id="save-at-this-stage"  ${themeDisplay.isSignedIn()?"":"disabled"}>
									<liferay-ui:message key="save-at-this-stage" />
								</button>
								<button class="go-next btn omsb-bc-red-button" type="button" title="<liferay-ui:message key="next" />" onclick="saveWorkDetail('next')" id="workDetailNext" data-next="reg_step4"  ${themeDisplay.isSignedIn()?"":"disabled"}>
									<liferay-ui:message key="next" />
								</button>
								<button id="work-back-button" class="go-pervious btn omsb-btn omsb-bg-red-button"  data-toggle="modal" data-target="#conformationPopUp" type="button" title="<liferay-ui:message key="back" />" data-pervious="reg_step2">
									<i class="fi fi-sr-arrow-left"></i>
									<liferay-ui:message key="back" />
								</button>
							</div>
							<input type="hidden" name="<portlet:namespace/>isNext" id="<portlet:namespace/>isNext" value="false">
						</form>
					</div>

				</div>
			</div>
		</div>
	</div>
	<%@ include file="confirmationPopUp.jsp"%>
	<liferay-ui:success key="success-education-detail" message="education-detail-successfully-added" />
<liferay-ui:success key="success-work-detail" message="work-detail-successfully-added" />
	<script>
		var isEdit = false;
		$( document ).ready(function() {
			
			 $("#workSectorType_1").select2();
			 $("#worksector_1").select2();
			 $("#first-sub-worksector_1").select2();
			 $("#wilayats_1").select2();
			 $("#designations_1").select2();
			 $("#workSectorType_2").select2();
			 $("#worksector_2").select2();
			 $("#first-sub-worksector_2").select2();
			 //$("#worksectorother_2").select2();
			 $("#wilayats_2").select2();
			 $("#designations_2").select2();
			
			 if(!${themeDisplay.isSignedIn()}){
					console.log("inside if");
					console.log($("#declare1").is(":checked"));
		 		  if($("#declare1").is(":checked"))
		 		  {
		 		    $('#save-at-this-stage').removeAttr('disabled');
		 		    $('#workDetailNext').removeAttr('disabled');
		 		  }
		 		  else{
		 			 $('#save-at-this-stage').attr("disabled", true);
		 			 $('#workDetailNext').attr("disabled", true);
		 		  }
				}
	 		  
	 		 var designation_1=$("#designations_1").val();
	 		var designation_2=$("#designations_2").val();
	 		if(designation_1=="other"){
	 			 $('#designationotherdiv_1').removeClass('d-none');
	 		}
	 		else{
	 			  $("#designationother_1").val('');
	 			 $('#designationotherdiv_1').addClass('d-none');
	 		}
	 		if(designation_2=="other"){
	 			 $('#designationotherdiv_2').removeClass('d-none');
	 		}
	 		else{
	 			$("#designationother_2").val('');
	 			 $('#designationotherdiv_2').addClass('d-none');
	 		}
		});
		
		
		function isValidVerificationField(){
			var errorMessages = [];
		   console.log("inside validVerification field function");
			var workSectorTypeId=$("#workSectorType_1").val();
			
			
			if(!workSectorTypeId || workSectorTypeId===""){
				errorMessages.push("<liferay-ui:message key='please-enter-work-sector-type' />");
				$("#work-sector-type-error_1").html("<liferay-ui:message key='please-enter-work-sector-type' />");
			}
			else{
				$("#work-sector-type-error_1").html("");
			}
			
			var workSector=$("#worksector_1").val();
			
			var workSectorparentClass=$('#worksector_1').parent().attr('class');
			//var workSectorparentClass=$('#worksector_1').parent().find('d-none');
			console.log("workSectorparentClass ::::",workSectorparentClass.includes('d-none'));
			
			if(!workSectorparentClass.includes('d-none')){
				console.log("False value");
				if(!workSector || workSector===""){
					console.log("inside if conditon worksector :  location-error_");
					errorMessages.push("<liferay-ui:message key='please-enter-work-sector' />");
					$("#work-sector-error_1").html("<liferay-ui:message key='please-enter-work-sector' />");
				}
				else{
					$("#work-sector-error_1").html("");
				}
			}
			
			var wilayats=$("#wilayats_1").val();
			if(!wilayats || wilayats===""){
				console.log("inside if conditon worksector :  work-sector-error_");
				errorMessages.push("<liferay-ui:message key='please-enter-work-sector-location' />");
				$("#location-error_1").html("<liferay-ui:message key='please-enter-work-sector-location' />");
			}
			else{
				$("#location-error_1").html("");
			}
			
			var designations=$("#designations_1").val();
			if(!designations || designations ===""){
				errorMessages.push("<liferay-ui:message key='please-enter-designation' />");
				$("#designation-error_1").html("<liferay-ui:message key='please-enter-designation' />");
			}
			else{
				$("#designation-error_1").html("");
			}
			
			var staffCardId = document.getElementById("staffIdCard_1");
			if(staffCardId.files[0]){
				if(!isEdit){
			console.log('size : '+staffCardId.files[0].size);	
			 var filename = staffCardId.files[0].name;
		     var extension = filename.substr(filename.lastIndexOf("."));
			  //var allowedExtensionsRegex=new RegExp("(.*?)\.(pdf)$");
			    var allowedExtensionsRegex = /(\.jpg|\.jpeg|\.png|\.pdf)$/i;
			  
			  var isAllowed = allowedExtensionsRegex.test(extension);
			     if(isAllowed){
			    	 console.log("insid is allowed if");
			    	 document.getElementById("file-size-error_1").textContent ="";
			    		const size = (staffCardId.files[0].size / 1024 / 1024).toFixed(2);
						console.log(size);
						if (size > 1) {
							errorMessages.push("<liferay-ui:message key='filesize-must-be-less-than-1-mb' />");
							document.getElementById("file-size-error_1").textContent = "<liferay-ui:message key='filesize-must-be-less-than-1-mb' />";
			            } else {
			            	document.getElementById("file-size-error_1").textContent = "";
			            }
			     }else{
			    	 console.log("inside else conditon");
			    	 document.getElementById("file-size-error_1").textContent ="<liferay-ui:message key='please-select-pdf-file' />";
			    	 errorMessages.push("<liferay-ui:message key='please-select-pdf-file' />");
			     }
			
		}
				else{
					isEdit=false;
					document.getElementById("file-size-error_1").textContent = "";
				}
		}
			else{
				isEdit=false;
				document.getElementById("file-size-error_1").textContent = "";
			}
			
			var staffCardId_2 = document.getElementById("staffIdCard_2");
			console.log("staffCardId :: "+staffCardId_2);
			if(staffCardId_2.files[0]){
				if(!isEdit){
			console.log('size : '+staffCardId_2.files[0].size);	
			 var filename_2 = staffCardId_2.files[0].name;
		     var extension_2 = filename_2.substr(filename_2.lastIndexOf("."));
			  //var allowedExtensionsRegex_2=new RegExp("(.*?)\.(pdf)$");
			   var allowedExtensionsRegex_2 = /(\.jpg|\.jpeg|\.png|\.pdf)$/i;
			  var isAllow = allowedExtensionsRegex_2.test(extension_2);
			     if(isAllow){
			    	 console.log("insid is allowed if");
			    	 document.getElementById("file-size-error_2").textContent ="";
			    		const size = (staffCardId_2.files[0].size / 1024 / 1024).toFixed(2);
						console.log(size);
						if (size > 1) {
							errorMessages.push("<liferay-ui:message key='filesize-must-be-less-than-1-mb' />");
							document.getElementById("file-size-error_2").textContent = "<liferay-ui:message key='filesize-must-be-less-than-1-mb' />";
			            } else {
			            	document.getElementById("file-size-error_2").textContent = "";
			            }
			     }else{
			    	 console.log("inside else conditon");
			    	 document.getElementById("file-size-error_2").textContent ="<liferay-ui:message key='please-select-pdf-file' />";
			    	 errorMessages.push("<liferay-ui:message key='please-select-pdf-file' />");
			     }
			
		}
				else{
					isEdit=false;
					document.getElementById("file-size-error_2").textContent = "";
				}
		}
			else{
				isEdit=false;
				document.getElementById("file-size-error_2").textContent = "";
			}
			
			
			
			let isValid = false;
			if (errorMessages.length == 0) {
				isValid = true;
			}
			return isValid;
		}
		
		
		function saveWorkDetail(button){
			var isEmployed= $("input[name = '<portlet:namespace/>employed']:checked").val();
			if(!${themeDisplay.isSignedIn()}){
			if(isEmployed==1){
			if(isValidVerificationField()){
				if(button=='next'){
					document.getElementById("<portlet:namespace/>isNext").value = "true";
				}
				document.getElementById("work-detail-form").submit();
			}
			else{
				event.preventDefault();
			}
			}
			else{
				if(button=='next'){
					document.getElementById("<portlet:namespace/>isNext").value = "true";
				}
				document.getElementById("work-detail-form").submit();
			}
			}
			else{
				if(button=='next'){
					document.getElementById("<portlet:namespace/>isNext").value = "true";
				}
				document.getElementById("work-detail-form").submit();
			}
			
		}
		
		/* $("#work-back-button").click(function(){
			window.location.href='${educationDetailRenderURL}';
		}); */
		
	
		
		$(document).ready(function() {
			$(function() {
			    $('input:radio[name="<portlet:namespace/>employed"]').change(function() {
			        if ($(this).val() == '1') {
			            $("#work-detail-main").removeClass("d-none");
			        } else {
			            $("#work-detail-main").addClass('d-none');
			        }
			    });
			});
			/* if ( window.history.replaceState ) {
		        window.history.replaceState( null, null, window.location.href );
		    } */
		});
		
		
		/* $(".checkbox" ).on( "click", function() {
	 		  if($(".checkbox:checked" ).length > 1)
	 		  {
	 		    $('#save-at-this-stage').removeAttr('disabled');
	 		    $('#workDetailNext').removeAttr('disabled');
	 		  }
	 		  else{
	 			 $('#save-at-this-stage').attr("disabled", true);
	 			 $('#workDetailNext').attr("disabled", true);
	 		  }
	 	}); */
	 	
	 	$("#declare1" ).on( "click", function() {
			 console.log("test---");
			 if($("#declare1" ).is(":checked"))
	 		  {
	 		    $('#save-at-this-stage').removeAttr('disabled');
	 		    $('#workDetailNext').removeAttr('disabled');
	 		  }
	 		  else{
	 			 $('#save-at-this-stage').attr("disabled", true);
	 			 $('#workDetailNext').attr("disabled", true);
	 		  }
	 	});
		function showDesignationOther(id,errorId,errorMessage){
			 var substring=substring=id.substr ( id.indexOf ( '_' ) + 1 );
			
			 let selectedDesignation= $("#"+id).find('option:selected').val();
			 if(selectedDesignation.trim() === 'other'){
				 $('#designationotherdiv_'+substring).removeClass('d-none');
			 }
			 else{
				 $('#designationotherdiv_'+substring).addClass('d-none');
				}
			// }
		if(id=="designations_1"){
			console.log("inside if condition");
			 validateField(id,errorId,errorMessage);
		}
			 
		}
	        
	        function validateField(elementId,errorId,error){
	        	var fieldValue=$("#"+elementId).val();
	        	console.log(elementId+" ---  "+errorId+ " --- "+error);
	        	if(fieldValue==''){
	        		$("#"+errorId).text(error);
	        	}
	        	else{
	        		$("#"+errorId).html("");
	        	}
	        }
	        $(document).on('change','.custom-file-input', function () {
	        	var fileName = $(this).val().split("\\").pop();
	        	
	        	console.log("fileName ::::",fileName);
	        	$(this).siblings(".custom-file-label").html(fileName);
	        });
	        
	        $(document).on('change','#worksector_1',function(){
				var workSectorValue=$(this).val();
				if(workSectorValue == 'Other'){
				      $("#div-work-other_1").removeClass("d-none");
				}else{
					console.log("workSectorValue",workSectorValue);
					$("#worksectorother_1").val('');
					$("#div-work-other_1").addClass("d-none");
				}
				
			});
	        $(document).on('change','#worksector_2',function(){
				var workSectorValue=$(this).val();
				if(workSectorValue == 'Other'){
				      $("#div-work-other_2").removeClass("d-none");
				}else{
					console.log("workSectorValue",workSectorValue);
					$("#worksectorother_2").val('');
					$("#div-work-other_2").addClass("d-none");
				}
				
			});
	        function validateFile(id,errorId,errorMessage){
	           console.log(errorId);
	            if(id.indexOf("_") !== -1){
	        		var divId=id.substring(id.indexOf("_") + 1);
	        		errorId=errorId.substring(0,errorId.indexOf("_")+1)+divId;
	        	}
	           var file= document.getElementById(id).files[0];
	           if(file){
	        	 var filename = document.getElementById(id).files[0].name;
	        	 console.log(filename);
	             var extension = filename.substr(filename.lastIndexOf("."));
	          //   var allowedExtensionsReg=new RegExp("(.*?)\.(pdf)$");	
	            var allowedExtensionsReg = /(\.jpg|\.jpeg|\.png|\.pdf)$/i;
	             var isAllowed = allowedExtensionsReg.test(extension);
                 console.log(isAllowed);
                 console.log(errorId);
	            if(isAllowed){
	           	 $("#"+errorId).html("");
	            }else{
	           	 $("#"+errorId).text(errorMessage);
	            }
	           }
	        }
	        
	        function getWorkSector(id){
	        	var substring=id.substr ( id.indexOf ( '_' ) + 1 );			
				 var selectedValue= $("#"+id).find('option:selected').val();
				 console.log("selectedvlaue ");
				 console.log(selectedValue);
				 
				 
				 $('#div-o3-work-other_'+substring).addClass('d-none');
				 $('#div-o2-work-other_'+substring).addClass('d-none');
				 
				 if(selectedValue){
					 console.log("selectedValue :: "+selectedValue);
					 //else{
						 $('#worksectorTypediv_'+substring).addClass('d-none'); 
						 
					 $.ajax({
							url: '${getWorkSectorByWorkSectorType}',
							async : false,
							data : {
								<portlet:namespace />workSectorType : selectedValue
							},
							type : 'POST',
							success : function(data) {
								console.log(data);
								var options = JSON.parse(data);
								console.log("options ::::::",options[0].id);
								
								 
								if(options[0].id=="other"){
									 console.log(substring+" --------------");
									 $('#worksectorTypediv_'+substring).removeClass('d-none');
									 $('#work-sector-div_'+substring).addClass('d-none');
									 $('#div-first-sub-sector_'+substring).addClass('d-none');
									 $('#div-o3-work-other_'+substring).addClass('d-none');
									 $('#div-o2-work-other_'+substring).addClass('d-none');
									 
									 //Third level
									  $('#div-second-sub-sector_'+substring).addClass('d-none');
									  $('#div-o3-secons-work-other_'+substring).addClass('d-none');
									  $('#div-first-sub-sector_'+substring).addClass('d-none');
									 
								 }else{
									 updateOtherDropdown(options,"worksector_"+substring);
									 $('#work-sector-div_'+substring).removeClass('d-none'); 
									 
									 //Third level
									  $('#div-second-sub-sector_'+substring).addClass('d-none');
									  $('#div-o3-secons-work-other_'+substring).addClass('d-none');
									  $('#div-first-sub-sector_'+substring).addClass('d-none');
								 }
								
							}
					 });
					 //}
				 }else{
						console.log("inside else ::::"); 
						
						
						
					 var otherDropdown = document.getElementById("worksector_"+substring); 
					  otherDropdown.innerHTML = '';
			            var optElement = document.createElement('option');
			            optElement.value="";
			            optElement.textContent = '<liferay-ui:message key="select" />';
			            otherDropdown.appendChild(optElement);
			            $('#worksectorTypediv_'+substring).addClass('d-none');   
			            $('#work-sector-div_'+substring).removeClass('d-none');   
			            
			            
			            $('#div-first-sub-sector_'+substring).addClass('d-none'); 
			            $('#div-second-sub-sector_'+substring).addClass('d-none'); 
			            $('#div-o3-secons-work-other_'+substring).addClass('d-none'); 
			            
			           
				 }
	        }
	        
	        
	        function updateOtherDropdown(options,field) {
	        	console.log("field : "+field);
	            var otherDropdown = document.getElementById(field);
	            
	            console.log("otherDropdown :::",otherDropdown);
	            
	            otherDropdown.innerHTML = '';
	            var optElement = document.createElement('option');
	            optElement.value="";
	            optElement.textContent = '<liferay-ui:message key="select" />';
	            otherDropdown.appendChild(optElement);
	            options.forEach(function(option) {
	                var optionElement = document.createElement('option');
	                optionElement.value = option.id;
	                optionElement.textContent = option.value;
	                otherDropdown.appendChild(optionElement);
	            });
	        }
	        
	        
	        
	        function getChildWorkSector(id,field){
		    	   var substring=id.substr ( id.indexOf ( '_' ) + 1 );			
					 var selectedValue= $("#"+id).find('option:selected').val();
					 console.log("selectedvlaue ");
					 console.log(selectedValue);
					 console.log("field :::::",field);
					 console.log("selectedValue :: "+selectedValue);
					 console.log("substring :: "+substring);
					 
					
					 if(selectedValue){
						 
						 
						 $("#div-second-sub-sector_"+substring).addClass('d-none');	
						 $("#div-o3-secons-work-other_"+substring).addClass('d-none');
						 
						 
						 if(selectedValue =='other'){
							 console.log("inside other ::::::::");
							 //$('#div-work-other_'+substring).removeClass('d-none'); 
							 //div-work-other_1
							 
							 
							 $("#div-o2-work-other_"+substring).removeClass("d-none");
							 $("#div-first-sub-sector_"+substring).addClass("d-none");
							 $("#div-o3-work-other_"+substring).addClass('d-none');	
						 }else{
							 $.ajax({
									url: '${ getWorkSectorByParentWorkSector}',
									async : false,
									data : {
										<portlet:namespace />parentWorkSectorId : selectedValue
									},
									type : 'POST',
									success : function(data) {
										$("#div-o2-work-other_"+substring).addClass('d-none');
										$("#div-first-sub-sector_"+substring).removeClass("d-none");
										$("#div-o3-work-other_"+substring).addClass('d-none');
										
										console.log(data);
										var options = JSON.parse(data);
										console.log(options);
										if(field=="first"){
											console.log("if");
										updateOtherDropdown(options,"first-sub-worksector_"+substring);
										}
										else if(field=="second"){
											console.log("else");
										updateOtherDropdown(options,"second-sub-worksector_"+substring);	
										}
									}
							 });
						 }
					 
					 }else{
						 
						 $("#div-o3-work-other_"+substring).addClass('d-none');
						 $("#div-o2-work-other_"+substring).addClass('d-none');
						 $("#div-first-sub-sector_"+substring).addClass('d-none');
						 $("#div-second-sub-sector_"+substring).addClass('d-none');
						 $("#div-o3-secons-work-other_"+substring).addClass('d-none');
						 
					 }
					 
		       }
	        
	        
	        
	        //For second child 
	        
	        function getChildWorkSector2(id,field){
	        	//Third level
				  $('#div-second-sub-sector_'+substring).addClass('d-none');
				  $('#div-o3-secons-work-other_'+substring).addClass('d-none');
	        	
		    	   var substring=id.substr ( id.indexOf ( '_' ) + 1 );			
					 var selectedValue= $("#"+id).find('option:selected').val();
					 console.log("selectedvlaue ");
					 console.log(selectedValue);
					 console.log("field :::::",field);
					 console.log("selectedValue :: "+selectedValue);
					 console.log("substring :: "+substring);
					 
					 
					 if(selectedValue){
					 
					 
					 	if(selectedValue =='other'){
							 console.log("inside other ::::::::");
							 //$('#div-work-other_'+substring).removeClass('d-none'); 
							 //div-work-other_1
							 $("#div-o3-work-other_"+substring).removeClass("d-none");
							
							 //$("#div-first-sub-sector_"+substring).addClass("d-none");
							 
							 
							 $("#div-second-sub-sector_"+substring).addClass("d-none");
							 $("#div-o3-secons-work-other_"+substring).addClass("d-none");
							 
							 
							
					 	}else{
						 //$("#div-o3-work-other_"+substring).addClass('d-none');
						  
					 		$.ajax({
								url: '${ getWorkSectorByParentWorkSector}',
								async : false,
								data : {
									<portlet:namespace />parentWorkSectorId : selectedValue
								},
								type : 'POST',
								success : function(data) {
									//$("#div-second-sub-sector_"+substring).addClass('d-none');
									$("#div-second-sub-sector_"+substring).removeClass("d-none");
									$("#div-o3-work-other_"+substring).addClass('d-none');
									
									console.log(data);
									var options = JSON.parse(data);
									console.log(options);
									if(field=="first"){
										console.log("if");
									updateOtherDropdown(options,"first-sub-worksector_"+substring);
									}
									else if(field=="second"){
										console.log("else");
									updateOtherDropdown(options,"second-sub-worksector_"+substring);	
									}
								}
						 });
						 
					 	}
				 	}else{
				 		 $("#div-o3-secons-work-other_"+substring).addClass('d-none');
				 		 $("#div-second-sub-sector_"+substring).addClass('d-none');
				 		 $("#div-o3-work-other_"+substring).addClass('d-none');
				 	}
		       }
	        
	        
	       	//Third child 
	        function getChildWorkSector3(id,field){
		    	   var substring=id.substr ( id.indexOf ( '_' ) + 1 );			
					 var selectedValue= $("#"+id).find('option:selected').val();
					 console.log("selectedvlaue ");
					 console.log(selectedValue);
					 console.log("field :::::",field);
					 if(selectedValue){
					 console.log("selectedValue :: "+selectedValue);
					 console.log("substring :: "+substring);
					 	if(selectedValue =='other'){
							 console.log("inside other ::::::::");
							 $("#div-o3-secons-work-other_"+substring).removeClass("d-none");
					 	}else{
					 		 $("#div-o3-secons-work-other_"+substring).addClass('d-none');
					 	}
				 	}else{
				 		 $("#div-o3-secons-work-other_"+substring).addClass('d-none');
				 	}
		       }
	       	
	        function previousPage(){
	   		 window.location.href='${educationDetailRenderURL}';
	   	 }    	
	        
		</script>