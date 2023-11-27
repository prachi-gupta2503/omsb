<%@include file = "../init.jsp" %>
<portlet:renderURL var="applicantRequestBackURL">
	<portlet:param name="mvcRenderCommandName" value="/"/>
</portlet:renderURL>


<portlet:renderURL var="backURL">
	<portlet:param name="mvcRenderCommandName" value="/" />
</portlet:renderURL>

<%
	List<String> roles = themeDisplay.getUser().getRoles().stream().map(Role::getName).collect(Collectors.toList());
%>
<div id="wrapper">
				<div class="container">
					<div class="omsb-card">
						<div class="omsb-page-top-info m-0">
							<div class="omsb-page-top-info">
								<div class="pagetitle"><liferay-ui:message key="view-all-applicant-requests" /></div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-12">
								<ul class="nav nav-pills omsb-nav-pills justify-content-center" id="myTab" role="tablist">
								 <%if(roles.contains("Administrator")){ %>	
								 	<li class="nav-item">
									  <a class="nav-link active" id="singledatesingleinstance-tab" data-toggle="tab" href="#singledatesingleinstance" role="tab" aria-controls="singledatesingleinstance" aria-selected="false"><liferay-ui:message
										key="all-appeals" /></a>
									</li>
									<li class="nav-item">
										<a class="nav-link" id="examregistrationrequest-tab" data-toggle="tab" href="#examregistrationrequest" role="tab" aria-controls="examregistrationrequest" aria-selected="false"><liferay-ui:message key="all-exam-registration-request" /></a>
									</li>
								
								<%} else if(roles.contains("OCT Appeal Body")){ %>
									<li class="nav-item">
									  <a class="nav-link active" id="singledatesingleinstance-tab" data-toggle="tab" href="#singledatesingleinstance" role="tab" aria-controls="singledatesingleinstance" aria-selected="false"><liferay-ui:message
										key="all-appeals" /></a>
									</li>
								<% } else if(roles.contains("OCT Admin")){ %>	
									<%-- <li class="nav-item">
									  <a class="nav-link active" id="multipledatemultipleinstance-tab" data-toggle="tab" href="#multipledatemultipleinstance" role="tab" aria-controls="multipledatemultipleinstance" aria-selected="true"><liferay-ui:message key="all-cancellation" /></a>
									</li> --%>
									<%-- <li class="nav-item">
									  <a class="nav-link" id="allreschedule-tab" data-toggle="tab" href="#allreschedule" role="tab" aria-controls="allreschedule" aria-selected="false"><liferay-ui:message key="all-reschedule" /></a>
									</li> --%>
									<li class="nav-item">
										<a class="nav-link active" id="examregistrationrequest-tab" data-toggle="tab" href="#examregistrationrequest" role="tab" aria-controls="examregistrationrequest" aria-selected="false"><liferay-ui:message key="all-exam-registration-request" /></a>
									  </li>
									  <%-- <li class="nav-item">
										<a class="nav-link " id="replacementcertificaterequest-tab" data-toggle="tab" href="#replacementcertificaterequest" role="tab" aria-controls="replacementcertificaterequest" aria-selected="false"><liferay-ui:message key="replacement-certificate-request" /></a>
									  </li> --%>
								<%} %>
								
								  </ul>
							</div>

							<div class="col-lg-12 mt-4">		
								<div class="tab-content" id="v-pills-tabContent">
								<%if(roles.contains("Administrator")){ %>
								 	<div class="tab-pane fade show active" id="singledatesingleinstance" role="tabpanel" aria-labelledby="singledatesingleinstance-tab">
										<%@ include file="appeal/appeal-list.jsp"%>
									</div>
									<div class="tab-pane fade" id="examregistrationrequest" role="tabpanel" aria-labelledby="examregistrationrequest-tab">
										<%@ include file="exam/oct-exam-registration-list.jsp"%>
									</div>
								<%} else if(roles.contains("OCT Appeal Body")){ %>
		                       
		 							<div class="tab-pane fade show active" id="singledatesingleinstance" role="tabpanel" aria-labelledby="singledatesingleinstance-tab">
										<%@ include file="appeal/appeal-list.jsp"%>
									</div>
										
							    <% } else if(roles.contains("OCT Admin")){ %>	
							    
									<%-- <div class="tab-pane fade show active" id="multipledatemultipleinstance" role="tabpanel" aria-labelledby="multipledatemultipleinstance-tab">
										<%@include file="cancellation/cancellation-list.jsp"%>
									</div> --%>
									<%-- <div class="tab-pane fade" id="allreschedule" role="tabpanel" aria-labelledby="allreschedule-tab">
										<%@include file="reschedule/view-all-reschedule.jsp" %>
									</div> --%>
									<div class="tab-pane fade show active" id="examregistrationrequest" role="tabpanel" aria-labelledby="examregistrationrequest-tab">
										<%@ include file="exam/oct-exam-registration-list.jsp"%>
									</div>
								<%} %>
								 
								<%-- <div class="tab-pane fade" id="replacementcertificaterequest" role="tabpanel" aria-labelledby="replacementcertificaterequest-tab">
										<div class="omsb-list-filter">
											<div class="row">
												<div class="col-lg-6 col-md-6 col-sm-12">
													<div class="form-group">
														<label>Exam Title</label>
														<input type="text" name="Exam Title" id="examtitle"  class="form-control">
													</div>
												</div>
												<div class="col-lg-6 col-md-6 col-sm-12">
													<div class="form-group">
														<label>Trainee name</label>
													<input type="text" name="Trainee name" id="traineename"  class="form-control">
													</div>
												</div>
											</div>
											<div class="filter-button-wrap">
												<button class="btn omsb-bc-red-button">Search</button>
											</div>
										</div>
										<div class="omsb-list-view table-responsive">
											<table class="display omsb-datatables">
												<thead>
													<tr>
														<th>Exam Title</th>
														<th>Registration Start DATE</th>
														<th>Registration END DATE</th>
														<th>ACTIONS</th>
													</tr>
												</thead>
												<tbody>
													<tr>
														<td>Oman Examination For Nurses (OEN)</td>
														<td>Nasrain Siddiqui</td>
														<td>13-04-2023</td>
														<td>
															<div class="dropdown ">
																<button class="btn fa fa-ellipsis-v dropdown-toggle" type="button"
																	data-bs-toggle="dropdown" aria-expanded="false">
																	<i class=""></i>
																</button>
																<ul class="dropdown-menu">
																	<li><a href="#" class="dropdown-item"><i class="fa fa-check-square"></i> View</a></li>
																	<li><a href="#" class="dropdown-item"><i class="fa fa-trash-o"></i> Assign to me</a></li>
																</ul>    
															</div>
														</td>
													</tr>
													<tr>
														<td>Oman Examination For Nurses (OEN)</td>
														<td>Nasrain Siddiqui</td>
														<td>13-04-2023</td>
														<td>
															<div class="dropdown ">
																<button class="btn fa fa-ellipsis-v dropdown-toggle" type="button"
																	data-bs-toggle="dropdown" aria-expanded="false">
																	<i class=""></i>
																</button>
																<ul class="dropdown-menu">
																	<li><a href="#" class="dropdown-item"><i class="fa fa-check-square"></i> View</a></li>
																	<li><a href="#" class="dropdown-item"><i class="fa fa-trash-o"></i> Assign to me</a></li>
																</ul>    
															</div>
														</td>
													</tr>
													<tr>
														<td>Oman Examination For Nurses (OEN)</td>
														<td>Nasrain Siddiqui</td>
														<td>13-04-2023</td>
														<td>
															<div class="dropdown ">
																<button class="btn fa fa-ellipsis-v dropdown-toggle" type="button"
																	data-bs-toggle="dropdown" aria-expanded="false">
																	<i class=""></i>
																</button>
																<ul class="dropdown-menu">
																	<li><a href="#" class="dropdown-item"><i class="fa fa-check-square"></i> View</a></li>
																	<li><a href="#" class="dropdown-item"><i class="fa fa-trash-o"></i> Assign to me</a></li>
																</ul>    
															</div>
														</td>
													</tr>
													<tr>
														<td>Oman Examination For Nurses (OEN)</td>
														<td>Nasrain Siddiqui</td>
														<td>13-04-2023</td>
														<td>
															<div class="dropdown ">
																<button class="btn fa fa-ellipsis-v dropdown-toggle" type="button"
																	data-bs-toggle="dropdown" aria-expanded="false">
																	<i class=""></i>
																</button>
																<ul class="dropdown-menu">
																	<li><a href="#" class="dropdown-item"><i class="fa fa-check-square"></i> View</a></li>
																	<li><a href="#" class="dropdown-item"><i class="fa fa-trash-o"></i> Assign to me</a></li>
																</ul>    
															</div>
														</td>
													</tr>
													<tr>
														<td>Oman Examination For Nurses (OEN)</td>
														<td>Nasrain Siddiqui</td>
														<td>13-04-2023</td>
														<td>
															<div class="dropdown ">
																<button class="btn fa fa-ellipsis-v dropdown-toggle" type="button"
																	data-bs-toggle="dropdown" aria-expanded="false">
																	<i class=""></i>
																</button>
																<ul class="dropdown-menu">
																	<li><a href="#" class="dropdown-item"><i class="fa fa-check-square"></i> View</a></li>
																	<li><a href="#" class="dropdown-item"><i class="fa fa-trash-o"></i> Assign to me</a></li>
																</ul>    
															</div>
														</td>
													</tr>
													<tr>
														<td>Oman Examination For Nurses (OEN)</td>
														<td>Nasrain Siddiqui</td>
														<td>13-04-2023</td>
														<td>
															<div class="dropdown ">
																<button class="btn fa fa-ellipsis-v dropdown-toggle" type="button"
																	data-bs-toggle="dropdown" aria-expanded="false">
																	<i class=""></i>
																</button>
																<ul class="dropdown-menu">
																	<li><a href="#" class="dropdown-item"><i class="fa fa-check-square"></i> View</a></li>
																	<li><a href="#" class="dropdown-item"><i class="fa fa-trash-o"></i> Assign to me</a></li>
																</ul>    
															</div>
														</td>
													</tr>
													<tr>
														<td>Oman Examination For Nurses (OEN)</td>
														<td>Nasrain Siddiqui</td>
														<td>13-04-2023</td>
														<td>
															<div class="dropdown ">
																<button class="btn fa fa-ellipsis-v dropdown-toggle" type="button"
																	data-bs-toggle="dropdown" aria-expanded="false">
																	<i class=""></i>
																</button>
																<ul class="dropdown-menu">
																	<li><a href="#" class="dropdown-item"><i class="fa fa-check-square"></i> View</a></li>
																	<li><a href="#" class="dropdown-item"><i class="fa fa-trash-o"></i> Assign to me</a></li>
																</ul>    
															</div>
														</td>
													</tr>
													<tr>
														<td>Oman Examination For Nurses (OEN)</td>
														<td>Nasrain Siddiqui</td>
														<td>13-04-2023</td>
														<td>
															<div class="dropdown ">
																<button class="btn fa fa-ellipsis-v dropdown-toggle" type="button"
																	data-bs-toggle="dropdown" aria-expanded="false">
																	<i class=""></i>
																</button>
																<ul class="dropdown-menu">
																	<li><a href="#" class="dropdown-item"><i class="fa fa-check-square"></i> View</a></li>
																	<li><a href="#" class="dropdown-item"><i class="fa fa-trash-o"></i> Assign to me</a></li>
																</ul>    
															</div>
														</td>
													</tr>
												</tbody>
											</table>
										</div>
										<div class="bottom-backbtn-wrap">
											<a class="btn omsb-btn btn-back" href="${applicantRequestBackURL }"><i class="fi fi-sr-arrow-left"></i>Back</a>
										</div>
									</div> --%>
								
								</div>
							</div>
						</div>
						
					</div>



				</div>
			</div>
			<!--// Inner Wrapper Contents -->
