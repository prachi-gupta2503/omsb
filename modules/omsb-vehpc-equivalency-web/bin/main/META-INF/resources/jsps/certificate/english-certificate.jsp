<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td align="center">
			<table id="cert-table-english" width="1000" border="0"
				cellspacing="0" cellpadding="0" align="center"
				style="table-layout: fixed;">
				<tr>
					<td height="50">&nbsp;</td>
				</tr>
				<tr>
					<td align="center">
						<table width="100%" border="0" cellspacing="0" cellpadding="0"
							align="center" style="table-layout: fixed;">
							<tr>
								<td valign="top">
									<table width="100%" border="0" cellspacing="0" cellpadding="0"
										align="center">
										<tr>
											<td valign="middle" align="left"><a href="#"
												target="_blank" title=""> <img
													src="${themeDisplay.getPathThemeImages()}/certificate_logo/logo_img1.png"
													alt="logo_img1" style="display: block; max-width: 245px;"
													border="0" />
											</a></td>
											<td valign="middle" align="center"><a href="#"
												target="_blank" title=""> <img
													src="${themeDisplay.getPathThemeImages()}/certificate_logo/logo_img2.png"
													alt="logo_img2" style="display: block; max-width: 245px;"
													border="0" />
											</a></td>
											<td valign="middle" align="right"><a href="#"
												target="_blank" title=""> <img
													src="${themeDisplay.getPathThemeImages()}/certificate_logo/logo_img3.png"
													alt="logo_img1" style="display: block; max-width: 245px;"
													border="0" />
											</a></td>
										</tr>
									</table>
								</td>
							</tr>
						</table>
					</td>
				</tr>

				<tr>
					<td height="50">&nbsp;</td>
				</tr>
				<tr>
					<td>
						<table width="100%" border="0" cellspacing="0" cellpadding="0"
							align="center">
							<tr>
								<td valign="middle" align="left"><liferay-ui:message
										key="date" />:&nbsp;${currentDay} <liferay-ui:message
										key="${currentMonth}" /> ${currentYear}</td>
								<td valign="middle" align="right"><liferay-ui:message
									key="ref-number" />:&nbsp;EQ-${equivalencyRequestId}
								<td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td height="50">&nbsp;</td>
				</tr>
				<tr>
					<td valign="top" align="center">
						<h1
							style="text-decoration: underline; font-size: 40px; font-weight: 700;">
							<liferay-ui:message key="equivalency-certificate" />
						</h1>
					</td>
				</tr>
				<tr>
					<td valign="top" align="center" style="font-size: 18px;"><liferay-ui:message
							key="certificate-sub-heading" />:&nbsp;
					</td>
				</tr>
				<tr>
					<td height="50"></td>
				</tr>
				<tr>
					<td valign="top" align="center">
						<table width="650" class="table-border" border="0" cellspacing="0"
							cellpadding="0" align="center">
							<tr>
								<td width="200" valign="middle" align="center"
									style="font-size: 18px; padding: 10px;"><liferay-ui:message
										key="name" /></td>
								<td valign="middle" align="center"
									style="font-size: 18px; padding: 10px;"
									<c:if test="${evaluatedDocumentList.size()>0}">colspan="${evaluatedDocumentList.size()}"</c:if>>
									<input type="text" class="form-control"
									id="certificateFullName"
									name="<portlet:namespace/>certificateFullName"
									value="${personalDetail.givenNameAsPassport}"
									autocomplete="off">
								</td>
							</tr>
							<tr>
								<td width="200" valign="middle" align="center"
									style="font-size: 18px; padding: 10p7x;"><liferay-ui:message
										key="passport-no" /></td>
								<td valign="middle" align="center"
									style="font-size: 18px; padding: 10px;"
									<c:if test="${evaluatedDocumentList.size()>0}">colspan="${evaluatedDocumentList.size()}"</c:if>>
									<input type="text" class="form-control"
									id="certificatePassportNumber"
									name="<portlet:namespace/>certificatePassportNumber"
									value="${passportNumber}" autocomplete="off">
								</td>
							</tr>
							<tr>
								<td width="200" valign="middle" align="center"
									style="font-size: 18px; padding: 10px;"><liferay-ui:message
										key="date-of-birth" /></td>
								<td valign="middle" align="center"
									style="font-size: 18px; padding: 10px;"
									<c:if test="${evaluatedDocumentList.size()>0}">colspan="${evaluatedDocumentList.size()}"</c:if>>
									<input class="form-control datePicker" placeholder="DD/MM/YYYY"
									id="birthDate" name="<portlet:namespace/>birthDate"
									value="${dateOfBirth}" type="text" autocomplete="off" />
								</td>
							</tr>
							<tr>
								<td width="200" valign="middle" align="center"
									style="font-size: 18px; padding: 10px;"><liferay-ui:message
										key="certificate" /></td>
								<c:forEach var="evaluated" items="${evaluatedDocumentList}"
									varStatus="count">
									<c:set var="count" value="${count.index }"></c:set>
									<td valign="middle" align="center"
										style="font-size: 18px; padding: 10px;"><input
										type="text" id="certificateName${count}"
										name="<portlet:namespace/>certificateName${count}"
										class="form-control" value="${evaluated.documentType}"
										autocomplete="off" onkeyup="updateCertificateName(${count})"></td>
								</c:forEach>

							</tr>
							<tr>
								<td width="200" valign="middle" align="center"
									style="font-size: 18px; padding: 10px;"><liferay-ui:message
										key="issue-country" /></td>
								<c:forEach var="evaluated" items="${evaluatedDocumentList}"
									varStatus="count">
									<c:set var="count" value="${count.index }"></c:set>
									<td valign="middle" align="center"
										style="font-size: 18px; padding: 10px;"><input
										type="text" id="certificateCountry${count}"
										name="<portlet:namespace/>certificateCountry${count}"
										class="form-control" value="${evaluated.issuingAuthorityCountryName}"
										autocomplete="off"
										onkeyup="updateCertificateCountry(${count})"></td>
								</c:forEach>
							</tr>
							<tr>
								<td width="200" valign="middle" align="center"
									style="font-size: 18px; padding: 10px;"><liferay-ui:message
										key="graduate-year" /></td>
								<c:forEach var="evaluated" items="${evaluatedDocumentList}"
									varStatus="count">
									<c:set var="count" value="${count.index }"></c:set>
									<td valign="middle" align="center"
										style="font-size: 18px; padding: 10px;"><input
										type="text" id="certificateYear${count}"
										name="<portlet:namespace/>certificateYear${count}"
										class="form-control" value="${evaluated.yearOfGraduation}"
										autocomplete="off" onkeyup="updateCertificateYear(${count})"></td>
								</c:forEach>
							</tr>
							<tr>
								<td width="200" valign="middle" align="center"
									style="font-size: 18px; padding: 10px;"><liferay-ui:message
										key="decision-of-equivalence" /></td>
								<c:forEach var="evaluated" items="${evaluatedDocumentList}"
									varStatus="count">
									<c:set var="count" value="${count.index }"></c:set>
									<td valign="middle" align="left"
										style="font-size: 18px; padding: 10px;">
									 <span
										id="certificateDecision${count}" class="form-control">
									</span>
									</td>
								</c:forEach>
							</tr>
							<tr>
								<td width="200" valign="middle" align="center"
									style="font-size: 18px; padding: 10px;"><liferay-ui:message
										key="employer" /></td>
								<td valign="middle" align="center"
									style="font-size: 18px; padding: 10px;"
									<c:if test="${evaluatedDocumentList.size()>0}">colspan="${evaluatedDocumentList.size()}"</c:if>>
									<input type="text" class="form-control"
									id="certificateEmployer"
									name="<portlet:namespace/>certificateEmployer"
									value="${focalPoint.name}">
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td height="50"></td>
				</tr>
				<tr>
					<td valign="top" align="left">
						<table width="300" border="0" cellspacing="0" cellpadding="0"
							width="auto">
							<tr>
								<td valign="top" align="center"
									style="font-size: 18px; padding-bottom: 5px;"><liferay-ui:message
										key="dr-hilal-ali-al-sabti" /></td>
							</tr>
							<tr>
								<td valign="top" align="center"
									style="font-size: 18px; padding-bottom: 5px;"><liferay-ui:message
										key="ceo" /></td>
							</tr>
							<tr>
								<td valign="top" align="center" style="font-size: 18px;" s><liferay-ui:message
										key="certificate-signature" /></td>
							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td height="50"></td>
				</tr>
			</table>
		</td>
	</tr>
</table>

<style>
.certificateInEnglish {
	margin: 0 !important;
	padding: 0 !important;
	-webkit-text-size-adjust: 100% !important;
	-ms-text-size-adjust: 100% !important;
	-webkit-font-smoothing: antialiased !important;
	font-family: Arial, Helvetica, sans-serif;
}

img {
	border: 0 !important;
	outline: none !important;
}

p {
	margin: 0px !important;
	padding: 0px !important;
}

table {
	border-collapse: collapse;
	mso-table-lspace: 0px;
	mso-table-rspace: 0px;
}

td, a, span {
	border-collapse: collapse;
	mso-line-height-rule: exactly;
}

.table-border {
	border: 1px solid #c1c1c1;
	border-right: 0;
}

.table-border tr td {
	border-bottom: 1px solid #c1c1c1;
	border-right: 1px solid #c1c1c1;
}

.table-border tr td table tr:last-child td {
	border-bottom: 0;
}

.table-border tr td table tr td:last-child {
	border-right: 0;
}

#cert-table-english .form-control {
	border: none;
}
</style>
