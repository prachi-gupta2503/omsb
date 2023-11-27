<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td align="center">
			<table id="cert-table" width="1000" border="0" cellspacing="0" cellpadding="0"
				align="center" style="table-layout: fixed;">
				<tr>
					<td height="50">&nbsp;</td>
				</tr>
				<tr>
					<td align="center">
						<table  width="100%" border="0" cellspacing="0"
							cellpadding="0" align="center" style="table-layout: fixed;">
							<tr>
								<td valign="top">
									<table width="100%" border="0" cellspacing="0" cellpadding="0"
										align="center">
										<tr>
											<td valign="middle" align="left"><a href="#"
												target="_blank" title=""> <img
													src="${themeDisplay.getPathThemeImages()}/certificate_logo/logo_img1.png"
													style="display: block; max-width: 245px;" border="0" />
											</a></td>
											<td valign="middle" align="center"><a href="#"
												target="_blank" title=""> <img
													src="${themeDisplay.getPathThemeImages()}/certificate_logo/logo_img2.png"
													style="display: block; max-width: 245px;" border="0" />
											</a></td>
											<td valign="middle" align="right"><a href="#"
												target="_blank" title=""> <img
													src="${themeDisplay.getPathThemeImages()}/certificate_logo/logo_img3.png"
													style="display: block; max-width: 245px;" border="0" />
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
								<td valign="middle" align="left"><liferay-ui:message key="ref-number-arabic" />: EQ-${equivalencyRequestId}</td>
								<td valign="middle" align="right">${currentYear}&nbsp;<liferay-ui:message
										key="${currentMonth}-arabic" />&nbsp;${currentDay}&nbsp;:<liferay-ui:message key="date-arabic" /></td>

							</tr>
						</table>
					</td>
				</tr>
				<tr>
					<td height="50">&nbsp;</td>
				</tr>
				<tr>
					<td dir="rtl" lang="ar" valign="top" align="center">
						<h1 
							style="text-decoration: underline; font-size: 40px; font-weight: 700;">
							<liferay-ui:message key="equivalency-certificate-arabic" />
						</h1>
					</td>
				</tr>
				<tr>
					<td lang="ar" "top" align="center" style="font-size: 20px;">
						<liferay-ui:message key="certificate-sub-heading-arabic"/></td>
				</tr>
				<tr>
					<td height="50"></td>
				</tr>
				<tr>
					<td valign="top" align="center">
						<table width="650" class="table-border" border="0" cellspacing="0"
							cellpadding="0" align="center">
							<tr>
								<td valign="middle" align="center"
									style="font-size: 18px; padding: 10px;"
									<c:if test="${evaluatedDocumentList.size()>0}">colspan="${evaluatedDocumentList.size()}"</c:if>>
									<span class="form-control"
									id="saveCertificateFullNameArabic"
									name="<portlet:namespace/>saveCertificateFullNameArabic"
									>${personalDetail.givenNameAsPassport}</span>
								</td>
								<td width="200" valign="middle" align="center"
									style="font-size: 18px; padding: 10px;">
									<liferay-ui:message key="name-arabic" />
									</td>
							</tr>
							<tr>
								<td valign="middle" align="center"
									style="font-size: 18px; padding: 10px;"
									<c:if test="${evaluatedDocumentList.size()>0}">colspan="${evaluatedDocumentList.size()}"</c:if>>
									<span class="form-control"
									id="saveCertificatePassportNumberArabic"
									name="<portlet:namespace/>saveCertificatePassportNumberArabic">${passportNumber}</span>
								</td>
								<td width="200" valign="middle" align="center"
									style="font-size: 18px; padding: 10px;"><liferay-ui:message
										key="passport-no-arabic" /></td>
							</tr>
							<tr>
								<td valign="middle" align="center"
									style="font-size: 18px; padding: 10px;"
									<c:if test="${evaluatedDocumentList.size()>0}">colspan="${evaluatedDocumentList.size()}"</c:if>>
									<span class="form-control" id="saveBirthDateArabic"
									name="<portlet:namespace/>saveBirthDateArabic" >${dateOfBirth}</span>
								</td>
								<td width="200" valign="middle" align="center"
									style="font-size: 18px; padding: 10px;"><liferay-ui:message
										key="date-of-birth-arabic" /></td>
							</tr>
							<tr>
								<c:forEach var="evaluated" items="${evaluatedDocumentList}"
									varStatus="count">
									<c:set var="count" value="${count.index }"></c:set>
									<td valign="middle" align="center"
										style="font-size: 18px; padding: 10px;">
										<span
										id="saveCertificateNameArabic${count}"
										name="<portlet:namespace/>saveCertificateNameArabic${count}"
										class="form-control">${evaluated.documentType}</span>
									</td>
								</c:forEach>
								<td width="200" valign="middle" align="center"
									style="font-size: 18px; padding: 10px;"><liferay-ui:message key="equivalency-certificate-arabic" /></td>
							</tr>
							<tr>
								<c:forEach var="evaluated" items="${evaluatedDocumentList}"
									varStatus="count">
									<c:set var="count" value="${count.index }"></c:set>
									<td valign="middle" align="center"
										style="font-size: 18px; padding: 10px;">
										<span
										id="saveCertificateCountryArabic${count}"
										name="<portlet:namespace/>saveCertificateCountryArabic${count}"
										class="form-control">${evaluated.issuingAuthorityCountryName}</span>
									</td>
								</c:forEach>
								<td width="200" valign="middle" align="center"
									style="font-size: 18px; padding: 10px;"><liferay-ui:message
										key="issue-country-arabic" /></td>
							</tr>
							<tr>
								<c:forEach var="evaluated" items="${evaluatedDocumentList}"
									varStatus="count">
									<c:set var="count" value="${count.index }"></c:set>
									<td valign="middle" align="center"
										style="font-size: 18px; padding: 10px;">
										<span
										id="saveCertificateYearArabic${count}"
										name="<portlet:namespace/>saveCertificateYearArabic${count}"
										class="form-control">${evaluated.yearOfGraduation}</span>
									</td>
								</c:forEach>
								<td width="200" valign="middle" align="center"
									style="font-size: 18px; padding: 10px;"><liferay-ui:message
										key="graduate-year-arabic" /></td>
							</tr>
							<tr>
								<c:forEach var="evaluated" items="${evaluatedDocumentList}"
									varStatus="count">
									<c:set var="count" value="${count.index }"></c:set>
									<td valign="middle" align="center"
										style="font-size: 18px; padding: 10px;">
										<span
										id="saveCertificateDecisionArabic${count}"
										name="<portlet:namespace/>saveCertificateDecisionArabic${count}"
										class="form-control"></span>
									</td>
								</c:forEach>
								<td width="200" valign="middle" align="center"
									style="font-size: 18px; padding: 10px;"><liferay-ui:message
										key="decision-of-equivalence-arabic" /></td>
							</tr>
							<tr>
								<td valign="middle" align="center"
									style="font-size: 18px; padding: 10px;"
									<c:if test="${evaluatedDocumentList.size()>0}">colspan="${evaluatedDocumentList.size()}"</c:if>>
									<span class="form-control" id="saveCertificateEmployerArabic"
										name="<portlet:namespace/>saveCertificateEmployerArabic"
									>${focalPoint.name}</span>
								</td>
								<td width="200" width="300" valign="middle" align="center"
									style="font-size: 18px; padding: 10px;"><liferay-ui:message
										key="employer-arabic" /></td>
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
								<td dir="rtl" lang="ar" valign="top" align="center"
									style="font-size: 25px; padding-bottom: 5px;"><liferay-ui:message
										key="dr-hilal-ali-al-sabti-arabic" /></td>
							</tr>
							<tr>
								<td dir="rtl" lang="ar" valign="top" align="center"
									style="font-size: 25px; padding-bottom: 5px;"><liferay-ui:message
										key="ceo-arabic" /></td>
							</tr>
							<tr>
								<td dir="rtl" lang="ar" valign="top" align="center"
									style="font-size: 25px;" s><liferay-ui:message
										key="certificate-signature-arabic" /></td>
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
.certificateInArabic {
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

#cert-table .form-control {
	border: none;
}

#cert-table {
  /* Fallback fonts are supported. */
  font-family: 'handwriting', 'deja-sans', 'cjk', 'arabic', sans-serif, serif;
}
</style>
