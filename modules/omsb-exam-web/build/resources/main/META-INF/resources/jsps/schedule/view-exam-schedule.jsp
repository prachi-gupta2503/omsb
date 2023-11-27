<%@ include file="../../init.jsp"%>

<div class="main-content">
	<section class="omsb-main-wrapper" id="omsb-main-wrapper">
		<!-- Inner Wrapper Contents -->
		<div id="wrapper">
			<div class="container">
				<div class="omsb-card">
					<div class="omsb-page-top-info m-0">
						<div class="pagetitle">
							<liferay-ui:message key="exam-schedule" />
						</div>
					</div>
					<div class="row">
						<div class="col-lg-12">
							<ul class="nav nav-pills omsb-nav-pills justify-content-center"
								id="myTab" role="tablist">
									<c:choose>
										<c:when test="${examSchedule.multiDates}">
											<li class="nav-item"><a class="nav-link active"
												id="multipledatemultipleinstance-tab" data-toggle="tab"
												href="#multipledatemultipleinstance" role="tab"
												aria-controls="multipledatemultipleinstance"
												aria-selected="false">
												<liferay-ui:message key="multiple-dates-single-instance" /></a>
											</li>
										</c:when>
										<c:otherwise>
											<li class="nav-item"><a class="nav-link active"
												id="singledatesingleinstance-tab" data-toggle="tab"
												href="#singledatesingleinstance" role="tab"
												aria-controls="singledatesingleinstance" aria-selected="true">
												<liferay-ui:message key="single-date-single-instance" /></a>
											</li>
										</c:otherwise>
									</c:choose>
							</ul>
						</div>
						<div class="col-lg-12 mt-4">
							<div class="tab-content" id="v-pills-tabContent">
								<c:choose>
									<c:when test="${examSchedule.multiDates}">
										<div class="tab-pane fade show active" id="multipledatemultipleinstance"
											role="tabpanel"
											aria-labelledby="multipledatemultipleinstance-tab">
											<%@ include file="./view-multiple-dates-exam-schedule.jsp"%>
										</div>
									</c:when>
									<c:otherwise>
										<div class="tab-pane fade show active"
											id="singledatesingleinstance" role="tabpanel"
											aria-labelledby="singledatesingleinstance-tab">
											<%@ include file="./view-single-instance-exam-schedule.jsp"%>
										</div>
									</c:otherwise>
								</c:choose>									
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</div>