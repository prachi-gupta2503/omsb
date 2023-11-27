<%@ include file="../init.jsp"%>

<!-- Inner Wrapper Contents -->

		<div class="omsb-card">
			<div class="omsb-page-top-info mb-4">
				<div class="pagetitle">View EC Membership Request</div>
			</div>
			<h4 class="omsb-card-title">Comments</h4>
			<ul class="omsb-comments-list pb-3">
				<li>
					<div class="omsb-comment-box">
						<div class="omsb-comment-box-header">
							<h3 class="comment-title">
								<span class="comment-author-name">Abdul Al Haq </span>Employer
							</h3>
							<span class="posted-date">May 25 at 02:00 p.m.</span>
						</div>
						<div class="omsb-comment-body">
							<p>Yes we are going to attach the suggested documents.</p>
						</div>
					</div>
					<div class="colspan-child">Expand</div>
					<ul>
						<li>
							<div class="omsb-comment-box">
								<div class="omsb-comment-box-header">
									<h3 class="comment-title">
										<span class="comment-author-name">Abdul Al Haq </span>Employer
									</h3>
									<span class="posted-date">May 25 at 02:00 p.m.</span>
								</div>
								<div class="omsb-comment-body">
									<p>Yes we are going to attach the suggested documents.</p>
								</div>
							</div>
						</li>
						<li>
							<div class="omsb-comment-box">
								<div class="omsb-comment-box-header">
									<h3 class="comment-title">
										<span class="comment-author-name">Abdul Al Haq </span>Employer
									</h3>
									<span class="posted-date">May 25 at 02:00 p.m.</span>
								</div>
								<div class="omsb-comment-body">
									<p>Yes we are going to attach the suggested documents.</p>
								</div>
							</div>
						</li>
						<li>
							<div class="omsb-comment-box">
								<div class="omsb-comment-box-header">
									<h3 class="comment-title">
										<span class="comment-author-name">Abdul Al Haq </span>Employer
									</h3>
									<span class="posted-date">May 25 at 02:00 p.m.</span>
								</div>
								<div class="omsb-comment-body">
									<p>Yes we are going to attach the suggested documents.</p>
								</div>
							</div>
						</li>
						<li>
							<div class="omsb-comment-box">
								<div class="omsb-comment-box-header">
									<h3 class="comment-title">
										<span class="comment-author-name">Abdul Al Haq </span>Employer
									</h3>
									<span class="posted-date">May 25 at 02:00 p.m.</span>
								</div>
								<div class="omsb-comment-body">
									<p>Yes we are going to attach the suggested documents.</p>
								</div>
							</div>
						</li>
					</ul>
				</li>
			</ul>

			<h4 class="omsb-card-title pt-4">Request Details</h4>
			<div class="row">
				<div class="col-md-4 col-sm-6 col-xs-6">
					<div class="form-group-view">
						<div class="label-name">Program</div>
						<div class="label-content">${ecMemberRequestDetails.programName}</div>
					</div>
				</div>
				<div class="col-md-4 col-sm-6 col-xs-6">
					<div class="form-group-view">
						<div class="label-name">Training Site</div>
						<div class="label-content">${ecMemberRequestDetails.trainingSiteName}</div>
					</div>
				</div>
				<div class="col-md-4 col-sm-6 col-xs-6">
					<div class="form-group-view">
						<div class="label-name">Rotation</div>
						<div class="label-content">${ecMemberRequestDetails.rotationName}</div>
					</div>
				</div>
				<div class="col-md-4 col-sm-6 col-xs-6">
					<div class="form-group-view">
						<div class="label-name">Potential Member name</div>
						<div class="label-content">${ecMemberRequestDetails.givenNameAsPassport}</div>
					</div>
				</div>
				<div class="col-md-4 col-sm-6 col-xs-6">
					<div class="form-group-view">
						<div class="label-name">Membership role</div>
						<div class="label-content">${ecMemberRequestDetails.membershipRoleName}</div>
					</div>
				</div>
				<div class="col-md-4 col-sm-6 col-xs-6">
					<div class="form-group-view">
						<div class="label-name">CV</div>
						<div class="label-content">${ecMemberRequestDetails.cvName}</div>
					</div>
				</div>
				<div class="col-md-4 col-sm-6 col-xs-6">
					<div class="form-group-view">
						<div class="label-name">Civil ID</div>
						<div class="label-content">${ecMemberRequestDetails.civilId}</div>
					</div>
				</div>
				<div class="col-md-4 col-sm-6 col-xs-6">
					<div class="form-group-view">
						<div class="label-name">Passport No</div>
						<div class="label-content">${ecMemberRequestDetails.passportNumber}</div>
					</div>
				</div>
				<div class="col-md-4 col-sm-6 col-xs-6">
					<div class="form-group-view">
						<div class="label-name">Date of birth</div>
						<div class="label-content">${ecMemberRequestDetails.dateOfBirth}</div>
					</div>
				</div>
				<div class="col-md-4 col-sm-6 col-xs-6">
					<div class="form-group-view">
						<div class="label-name">Qarar</div>
						<div class="label-content">Habib@gmail.com</div>
					</div>
				</div>
				<div class="col-md-4 col-sm-6 col-xs-6">
					<div class="form-group-view">
						<div class="label-name">Covering letter</div>
						<div class="label-content">${ecMemberRequestDetails.coveringLetterName}</div>
					</div>
				</div>
				<div class="col-md-4 col-sm-6 col-xs-6">
					<div class="form-group-view">
						<div class="label-name">No objection letter</div>
						<div class="label-content">Male</div>
					</div>
				</div>


			</div>
			<h4 class="omsb-card-title pt-3">Potential Member Bank Details</h4>
			<div class="row">
				<div class="col-md-4 col-sm-6 col-xs-6">
					<div class="form-group-view">
						<div class="label-name">Bank name</div>
						<div class="label-content">${ecMemberRequestDetails.bankName}</div>
					</div>
				</div>
				<div class="col-md-4 col-sm-6 col-xs-6">
					<div class="form-group-view">
						<div class="label-name">Account No</div>
						<div class="label-content">${ecMemberRequestDetails.accountNo}</div>
					</div>
				</div>
				<div class="col-md-4 col-sm-6 col-xs-6">
					<div class="form-group-view">
						<div class="label-name">Bank Branch</div>
						<div class="label-content">${ecMemberRequestDetails.bankBranch}</div>
					</div>
				</div>
			</div>
			<h4 class="omsb-card-title pt-3">Potential Member ID Details</h4>
			<div class="row">
				<div class="col-md-4 col-sm-6 col-xs-6">
					<div class="form-group-view">
						<div class="label-name">Passport</div>
						<div class="label-content">${ecMemberRequestDetails.passportNumber}</div>
					</div>
				</div>
				<div class="col-md-4 col-sm-6 col-xs-6">
					<div class="form-group-view">
						<div class="label-name">National ID</div>
						<div class="label-content">123456</div>
					</div>
				</div>
			</div>
			<h4 class="omsb-card-title pt-3">Potential Member Education
				Details</h4>
			<div class="omsb-card-graybg omsb-card omsb-BorderRadius-4 pb-0">
				<div class="row">
					<div class="col-md-4 col-sm-6 col-xs-6">
						<div class="form-group-view">
							<div class="label-name">Title</div>
							<div class="label-content">123456</div>
						</div>
					</div>
					<div class="col-md-4 col-sm-6 col-xs-6">
						<div class="form-group-view">
							<div class="label-name">Instituion</div>
							<div class="label-content">SQBH</div>
						</div>
					</div>
					<div class="col-md-4 col-sm-6 col-xs-6">
						<div class="form-group-view">
							<div class="label-name">Country of Instituion</div>
							<div class="label-content">SQBH</div>
						</div>
					</div>
					<div class="col-md-4 col-sm-6 col-xs-6">
						<div class="form-group-view">
							<div class="label-name">GPA</div>
							<div class="label-content">123456</div>
						</div>
					</div>
					<div class="col-md-4 col-sm-6 col-xs-6">
						<div class="form-group-view">
							<div class="label-name">Year Of graduation</div>
							<div class="label-content">SQBH</div>
						</div>
					</div>
					<div class="col-md-4 col-sm-6 col-xs-6">
						<div class="form-group-view">
							<div class="label-name">Qualification Document</div>
							<div class="label-content">SQBH</div>
						</div>
					</div>
				</div>
			</div>
			<h4 class="omsb-card-title pt-3">Potential Member Existing
				Affiliations</h4>
			<div class="omsb-list-view table-responsive">
				<table class="display omsb-datatables">
					<thead>
						<tr>
							<th>Program</th>
							<th>Role</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>Adult Cardiology</td>
							<td>Chairperson</td>
						</tr>
						<tr>
							<td>Adult Cardiology</td>
							<td>Program Director</td>
						</tr>
						<tr>
							<td>Adult Cardiology</td>
							<td>member</td>
						</tr>

					</tbody>
				</table>
			</div>
			<div class="bottom-backbtn-wrap mt-4">
				<a class="btn omsb-btn btn-back" href="#"><i
					class="fi fi-sr-arrow-left"></i>Back</a>
			</div>

		</div>

<!--// Inner Wrapper Contents -->


