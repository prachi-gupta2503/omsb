<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@ include file="init.jsp"%>

<portlet:actionURL name="/save/emailTemplate" var="saveEmailTemplateURL">
</portlet:actionURL>


<link rel="stylesheet"
	href="<%=request.getContextPath() %>/css/lib/bootstrap-tagsinput.css" />

<section class="inputmask">
	<div class="row">
		<div class="col-12">
			<div class="card">
				<!--card-header-->
				<div class="card-content leads-screen">
					<div class="card-body">
						<div class="alert-message-container">
							<%-- <c:forEach begin="1" end="${attachmentFileUploadLimit}" varStatus="loop">
					    <liferay-ui:error key="file-is-already-exists-with-title-${loop.index}">
					    	<%
					    	String errorExceptionMessage = StringPool.BLANK;
					    		if(Validator.isNotNull(errorException)){
					    			errorExceptionMessage = (String) errorException;	
					    		}
					    		
					    	%>
							<liferay-ui:message key="<%= errorExceptionMessage%>" />
		           		</liferay-ui:error>
					</c:forEach>
					<c:forEach begin="1" end="${attachmentFileUploadLimit}" varStatus="loop">
					    <liferay-ui:error key="file-upload-error-with-title-${loop.index}">
							<%
					    	String errorExceptionMessage = StringPool.BLANK;
					    		if(Validator.isNotNull(errorException)){
					    			errorExceptionMessage = (String) errorException;	
					    		}
					    		
					    	%>
							<liferay-ui:message key="<%= errorExceptionMessage%>" />
		           		</liferay-ui:error>
					</c:forEach> --%>
					    <c:if test="${templateExists == 'true'}">
					    	<liferay-ui:error key="email-template-exists-error-msg"
								message="email-template-exists-error-msg"></liferay-ui:error>
					    </c:if>
					        <liferay-ui:error key="email-template-exists-error-msg"
								message="email-template-exists-error-msg"></liferay-ui:error>
							<liferay-ui:error key="email-template-create-error"
								message="email-template-create-error-msg"></liferay-ui:error>
							<liferay-ui:error key="email-template-update-error"
								message="email-template-update-error-msg"></liferay-ui:error>
							<liferay-ui:error key="email-template-duplicate-error"
								message="email-template-duplicate-error-msg"></liferay-ui:error>
							<liferay-ui:success key="email-template-create-success"
								message="email-template-create-success-msg"></liferay-ui:success>
							<liferay-ui:success key="email-template-update-success"
								message="email-template-update-success-msg"></liferay-ui:success>
						</div>
						<form class="form" name="<portlet:namespace />emailTemplateForm"
							id="<portlet:namespace />emailTemplateForm"
							action="${saveEmailTemplateURL}" method="post"
							enctype="multipart/form-data">
							<input type="hidden" name="<portlet:namespace />redirectURL"
								id="<portlet:namespace />redirectURL" value="${redirectURL}" />
							<input name="<portlet:namespace />templateId"
								id="<portlet:namespace />templateId" type="hidden"
								value="${emailTemplateMaster.templateId}" /> <input
								name="<portlet:namespace />deletedFileEntryIds"
								id="<portlet:namespace />deletedFileEntryIds" type="hidden"
								value="" />
							<div class="row">
								<div class="col-xl-6 col-lg-12">
									<h5>
										<liferay-ui:message key="template-name" />
										<span class="arrow-icon">*</span>
									</h5>
									<div class="form-group">
										<input class="form-control"
											id="<portlet:namespace />templateName"
											name="<portlet:namespace />templateName" type="text"
											value="${emailTemplateMaster.templateName}"
											placeholder='<liferay-ui:message key="template-name" />'
											maxlength="200" />
									</div>
								</div>
								<div class="col-xl-6 col-lg-12">
									<h5>
										<liferay-ui:message key="template-description" />
									</h5>
									<div class="form-group">
										<textarea rows="3"
											id="<portlet:namespace />templateDescription"
											name="<portlet:namespace />templateDescription"
											class="form-control"
											placeholder='<liferay-ui:message key="template-description" />'
											maxlength="500">${emailTemplateMaster.templateDescription}</textarea>
									</div>
								</div>
								<div class="col-xl-6 col-lg-12">
									<h5>
										<liferay-ui:message key="sender-type" />
										<span class="arrow-icon">*</span>
									</h5>
									<div class="form-group">
										<select class="form-control"
											id="<portlet:namespace />senderType"
											name="<portlet:namespace />senderType">
											<option value=""><liferay-ui:message
													key="please-select" /></option>
											<option value="admin"
												${emailTemplateMaster.senderType == 'admin' ? 'selected' : ''}><liferay-ui:message
													key="admin" /></option>
											<!--<option value="user" ${emailTemplateMaster.senderType == 'user' ? 'selected' : ''}><liferay-ui:message key="user" /></option>
							<option value="custom" ${emailTemplateMaster.senderType == 'custom' ? 'selected' : ''}><liferay-ui:message key="custom" /></option>  -->
										</select>
									</div>
								</div>
								<div class="col-xl-6 col-lg-12"
									id="<portlet:namespace />customSenderEmailSection"
									style="display: none;">
									<h5>
										<liferay-ui:message key="sender-email-id" />
									</h5>
									<div class="form-group">
										<input class="form-control"
											id="<portlet:namespace />senderEmailId"
											name="<portlet:namespace />senderEmailId" type="text"
											value="${emailTemplateMaster.senderEmailId}"
											placeholder='<liferay-ui:message key="sender-email-id" />'
											maxlength="75" />
									</div>
								</div>
								<div class="col-xl-6 col-lg-12">
									<h5>
										<liferay-ui:message key="cc" />
									</h5>
									<div class="form-group">
										<select class="select2 form-control"
											id="<portlet:namespace />defaultCC"
											name="<portlet:namespace />defaultCC" multiple="multiple">
											<c:forTokens var="ccAddress"
												items="${emailTemplateMaster.defaultCC}" delims=",">
												<option value="${ccAddress}">${ccAddress}</option>
											</c:forTokens>
										</select>
									</div>
								</div>
								<div class="col-xl-6 col-lg-12">
									<h5>
										<liferay-ui:message key="bcc" />
									</h5>
									<div class="form-group">
										<select class="select2 form-control"
											id="<portlet:namespace />defaultBCC"
											name="<portlet:namespace />defaultBCC" multiple="multiple">
											<c:forTokens var="bccAddress"
												items="${emailTemplateMaster.defaultBCC}" delims=",">
												<option value="${bccAddress}">${bccAddress}</option>
											</c:forTokens>
										</select>

									</div>
								</div>
								<div class="col-xl-4 col-lg-12"></div>
								<div class="col-xl-4 col-lg-12">
									<h5>
										<liferay-ui:message key="subject-tag" />
									</h5>
									<div class="form-group">
										<select class="form-control select2"
											id="<portlet:namespace />subjectTag"
											name="<portlet:namespace />subjectTag">
											<option value=""><liferay-ui:message
													key="please-select" /></option>
											<c:forEach items="${categoryTags}" var="categoryTag">
												<option value="${categoryTag.getTitle(locale)}">${categoryTag.getTitle(locale)}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="col-xl-1 col-lg-12">
									<h5>&nbsp;</h5>
									<div class="form-group">
										<button type="button" class="btn btn-outline-warning mr-1"
											id="<portlet:namespace />addSubjectTag"
											name="<portlet:namespace />addSubjectTag">
											<i class="fa fa-plus"></i>
										</button>
									</div>
								</div>
								<div class="col-xl-7 col-lg-12"></div>
								<div class="col-xl-12 col-lg-12">
									<h5>
										<liferay-ui:message key="subject" />
										<span class="arrow-icon">*</span>
									</h5>
									<div class="form-group" style="width:60%">
										<input class="form-control" id="<portlet:namespace />subject_enUS"
											name="<portlet:namespace />subject_enUS" type="text"
											value="${emailTemplateMaster.subject}"
											placeholder='<liferay-ui:message key="subject" />'
											maxlength="500" />
										<input class="form-control" id="<portlet:namespace />subject_arSA"
											name="<portlet:namespace />subject_arSA" type="text"
											value="${emailTemplateMaster.subject}"
											placeholder='<liferay-ui:message key="subject" />'
											maxlength="500" />
									</div>
									<div class="input-group-append" style="padding-left:20px">
										<button type="button" class="btn btn-outline-secondary dropdown-toggle df-language-selector-btn" 
												id="<portlet:namespace />emailSubjectSelectedLocale"  name="<portlet:namespace />emailSubjectSelectedLocale" 
												data-toggle="dropdown" language-id="en_US"><svg aria-hidden="true" class="lexicon-icon lexicon-icon-en-us" focusable="false"><use href="http://localhost:8080/o/omsb-portal-theme/images/clay/icons.svg#en-us"></use></svg><span class="df-lang-text">en-US</span><span class="df-lang-btn"><i class="fa fa-caret-down"></i></span></button>
										<div class="dropdown-menu df-dropdown-menu">
											<button type="button" class="dropdown-item" onclick="changeEmailTemplateLocale(this, true);" language-id="en_US" 
													reflect-on-field-id="emailSubjectSelectedLocale"><svg aria-hidden="true" class="lexicon-icon lexicon-icon-en-us" focusable="false"><use href="http://localhost:8080/o/omsb-portal-theme/images/clay/icons.svg#en-us"></use></svg><span class="df-lang-text">en-US</span></button>
											<button type="button" class="dropdown-item" onclick="changeEmailTemplateLocale(this, true);" language-id="ar_SA" 
													reflect-on-field-id="emailSubjectSelectedLocale"><svg aria-hidden="true" class="lexicon-icon lexicon-icon-ar-sa" focusable="false"><use href="http://localhost:8080/o/omsb-portal-theme/images/clay/icons.svg#ar-sa"></use></svg><span class="df-lang-text">ar-SA</span></button>
										</div>
									</div>
								</div>
								<div class="col-xl-4 col-lg-12">
									<h5>
										<liferay-ui:message key="body-tag" />
									</h5>
									<div class="form-group">
										<select class="form-control select2"
											id="<portlet:namespace />bodyTag1"
											name="<portlet:namespace />bodyTag1">
											<option value=""><liferay-ui:message
													key="please-select" /></option>
											<c:forEach items="${categoryTags}" var="categoryTag">
												<option value="${categoryTag.getTitle(locale)}">${categoryTag.getTitle(locale)}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="col-xl-1 col-lg-12">
									<h5>&nbsp;</h5>
									<div class="form-group">
										<button type="button" class="btn btn-outline-warning mr-1"
											id="<portlet:namespace />addBodyTag1"
											name="<portlet:namespace />addBodyTag1">
											<i class="fa fa-plus"></i>
										</button>
									</div>
								</div>
								<div class="col-xl-7 col-lg-12"></div>
								<div class="col-xl-12 col-lg-12">
									<h5><liferay-ui:message key="dynamic-body" /><span class="arrow-icon">*</span>
									</h5>
									<div class="form-group" id="<portlet:namespace />body1FormGroup" style="width:90%">
										<input id="<portlet:namespace />dynamicBodyEnUSHidden"
											name="<portlet:namespace />dynamicBodyEnUSHidden" type="hidden"
											value='${emailTemplateMaster.dynamicBody}' />
										<liferay-editor:editor contents="${enUSDynamicBodyVal}"
											editorName='<%= PropsUtil.get("editor.wysiwyg.portal-web.docroot.html.taglib.ui.email_notification_settings.jsp") %>'
											name="dynamicBodyEnUS" onChangeMethod="changeEnUSDynamicBody" />
										<input id="<portlet:namespace />dynamicBodyArSAHidden"
											name="<portlet:namespace />dynamicBodyArSAHidden" type="hidden"
											value='${emailTemplateMaster.dynamicBody}' />
										<liferay-editor:editor contents="${arSADynamicBodyVal}"
											editorName='<%= PropsUtil.get("editor.wysiwyg.portal-web.docroot.html.taglib.ui.email_notification_settings.jsp") %>'
											name="dynamicBodyArSA" onChangeMethod="changeArSADynamicBody" />
										<div class="form-group-field-error"
											id="<portlet:namespace />body1Msg" style="display: none;">
											<span id="<portlet:namespace />body1-error"
												class="has-body-help-block"><liferay-ui:message
													key="this-field-is-required" /></span>
										</div>
									</div>
									<div class="input-group-append" style="padding-left:20px">
										<button type="button" class="btn btn-outline-secondary dropdown-toggle df-language-selector-btn" style="margin-top:23px"
												id="<portlet:namespace />emailDynamicBodySelectedLocale"  name="<portlet:namespace />emailDynamicBodySelectedLocale" 
												data-toggle="dropdown" language-id="en_US"><svg aria-hidden="true" class="lexicon-icon lexicon-icon-en-us" focusable="false"><use href="http://localhost:8080/o/omsb-portal-theme/images/clay/icons.svg#en-us"></use></svg><span class="df-lang-text">en-US</span><span class="df-lang-btn"><i class="fa fa-caret-down"></i></span></button>
										<div class="dropdown-menu df-dropdown-menu">
											<button type="button" class="dropdown-item" onclick="changeEmailTemplateLocale(this, true);" language-id="en_US" 
													reflect-on-field-id="emailDynamicBodySelectedLocale"><svg aria-hidden="true" class="lexicon-icon lexicon-icon-en-us" focusable="false"><use href="http://localhost:8080/o/omsb-portal-theme/images/clay/icons.svg#en-us"></use></svg><span class="df-lang-text">en-US</span></button>
											<button type="button" class="dropdown-item" onclick="changeEmailTemplateLocale(this, true);" language-id="ar_SA" 
													reflect-on-field-id="emailDynamicBodySelectedLocale"><svg aria-hidden="true" class="lexicon-icon lexicon-icon-ar-sa" focusable="false"><use href="http://localhost:8080/o/omsb-portal-theme/images/clay/icons.svg#ar-sa"></use></svg><span class="df-lang-text">ar-SA</span></button>
										</div>
									</div>
								</div>
                    <div class="col-xl-7 col-lg-12">
                      
                    </div>
								<div class="col-xl-12 col-lg-12">
									<h5><liferay-ui:message key="static-body" /></h5>
									<div class="form-group" id="<portlet:namespace />body2FormGroup" style="width:90%">
										<input id="<portlet:namespace />staticBodyEnUSHidden"
											name="<portlet:namespace />staticBodyEnUSHidden" type="hidden"
											value='${emailTemplateMaster.staticBody}' />
										<liferay-editor:editor contents="${enUSStaticBodyVal}"
											editorName='<%= PropsUtil.get("editor.wysiwyg.portal-web.docroot.html.taglib.ui.email_notification_settings.jsp") %>'
											name="staticBodyEnUS" onChangeMethod="changeEnUSStaticBody" />
										<input id="<portlet:namespace />staticBodyArSAHidden"
											name="<portlet:namespace />staticBodyArSAHidden" type="hidden"
											value='${emailTemplateMaster.staticBody}' />
										<liferay-editor:editor contents="${arSAStaticBodyVal}"
											editorName='<%= PropsUtil.get("editor.wysiwyg.portal-web.docroot.html.taglib.ui.email_notification_settings.jsp") %>'
											name="staticBodyArSA" onChangeMethod="changeArSAStaticBody" />
									</div>
									<div class="input-group-append" style="padding-left:20px">
										<button type="button" class="btn btn-outline-secondary dropdown-toggle df-language-selector-btn" style="margin-top:23px"
												id="<portlet:namespace />emailStaticBodySelectedLocale"  name="<portlet:namespace />emailStaticBodySelectedLocale" 
												data-toggle="dropdown" language-id="en_US"><svg aria-hidden="true" class="lexicon-icon lexicon-icon-en-us" focusable="false"><use href="http://localhost:8080/o/omsb-portal-theme/images/clay/icons.svg#en-us"></use></svg><span class="df-lang-text">en-US</span><span class="df-lang-btn"><i class="fa fa-caret-down"></i></span></button>
										<div class="dropdown-menu df-dropdown-menu">
											<button type="button" class="dropdown-item" onclick="changeEmailTemplateLocale(this, true);" language-id="en_US" 
													reflect-on-field-id="emailStaticBodySelectedLocale"><svg aria-hidden="true" class="lexicon-icon lexicon-icon-en-us" focusable="false"><use href="http://localhost:8080/o/omsb-portal-theme/images/clay/icons.svg#en-us"></use></svg><span class="df-lang-text">en-US</span></button>
											<button type="button" class="dropdown-item" onclick="changeEmailTemplateLocale(this, true);" language-id="ar_SA" 
													reflect-on-field-id="emailStaticBodySelectedLocale"><svg aria-hidden="true" class="lexicon-icon lexicon-icon-ar-sa" focusable="false"><use href="http://localhost:8080/o/omsb-portal-theme/images/clay/icons.svg#ar-sa"></use></svg><span class="df-lang-text">ar-SA</span></button>
										</div>
									</div>
								</div>
								<div class="col-xl-4 col-lg-12 attachment-section"
									id="<portlet:namespace />attachmentSection">
									<h5>
										<liferay-ui:message key="attachments" />
									</h5>
									<c:choose>
										<c:when
											test="${action == 'edit' && (fn:length(attachmentFileEntriesMap) gt 0)}">
											<c:forEach items="${attachmentFileEntriesMap}"
												var="attachmentFileEntryMap" varStatus="ind">
												<div class="form-group"
													id="<portlet:namespace />attachmentFormGroup${ind.index + 1}">
													<div class="attachment-view"
														id="<portlet:namespace />attachmentView${ind.index + 1}">
														<a href="${attachmentFileEntryMap['previewURL']}"
															target="blank"><span>${attachmentFileEntryMap['title']}</span></a>
													</div>
													<input class="form-control attachment-input"
														id="<portlet:namespace />attachment${ind.index + 1}"
														name="<portlet:namespace />attachment${ind.index + 1}"
														type="file" style="display: none;" />
												</div>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<div class="form-group"
												id="<portlet:namespace />attachmentFormGroup1">
												<input class="form-control attachment-input"
													id="<portlet:namespace />attachment1"
													name="<portlet:namespace />attachment1" type="file" />
											</div>
										</c:otherwise>
									</c:choose>
								</div>
								<div class="col-xl-2 col-lg-12 attachment-btn-section"
									id="<portlet:namespace />attachmentBtnSection">
									<h5>&nbsp;</h5>

									<c:choose>
										<c:when
											test="${action == 'edit' && (fn:length(attachmentFileEntriesMap) gt 0)}">
											<c:forEach items="${attachmentFileEntriesMap}"
												var="attachmentFileEntryMap" varStatus="ind">
												<div class="form-group"
													id="<portlet:namespace />attachmentActionBtn${ind.index + 1}">
													<button type="button"
														class="btn btn-outline-danger mr-1 delete-btn"
														id="<portlet:namespace />deleteMoreAttachmentBtn${ind.index + 1}"
														name="<portlet:namespace />deleteMoreAttachmentBtn${ind.index + 1}"
														onclick="omsbPortlet.addEditEmailTemplateFc.deleteFileAttachmentInput(${ind.index + 1}, ${attachmentFileEntryMap['fileEntryId']})">
														<i class="fa fa-trash"></i>
													</button>
													<button type="button"
														class="btn btn-outline-warning mr-1 add-btn"
														id="<portlet:namespace />addMoreAttachmentBtn${ind.index + 1}"
														name="<portlet:namespace />addMoreAttachmentBtn${ind.index + 1}"
														onclick="omsbPortlet.addEditEmailTemplateFc.addFileAttachmentInput(true)"
														style="${ind.index + 1 > 1 ? 'display:none;' : ''}">
														<i class="fa fa-plus"></i>
													</button>
													<button type="button"
														class="btn btn-outline-danger mr-1 clear-btn"
														id="<portlet:namespace />clearMoreAttachmentBtn${ind.index + 1}"
														name="<portlet:namespace />clearMoreAttachmentBtn${ind.index + 1}"
														onclick="omsbPortlet.addEditEmailTemplateFc.clearFileAttachmentInput(${ind.index + 1})"
														style="display: none;">
														<i class="fa fa-times"></i>
													</button>
												</div>
											</c:forEach>
										</c:when>
										<c:otherwise>
											<div class="form-group"
												id="<portlet:namespace />attachmentActionBtn1">
												<button type="button"
													class="btn btn-outline-warning mr-1 add-btn"
													id="<portlet:namespace />addMoreAttachmentBtn1"
													name="<portlet:namespace />addMoreAttachmentBtn1"
													onclick="omsbPortlet.addEditEmailTemplateFc.addFileAttachmentInput(false)">
													<i class="fa fa-plus"></i>
												</button>
												<button type="button"
													class="btn btn-outline-danger mr-1 clear-btn"
													id="<portlet:namespace />clearMoreAttachmentBtn1"
													name="<portlet:namespace />clearMoreAttachmentBtn1"
													onclick="omsbPortlet.addEditEmailTemplateFc.clearFileAttachmentInput(1)"
													style="display: none;">
													<i class="fa fa-times"></i>
												</button>
											</div>
										</c:otherwise>
									</c:choose>
								</div>
								<div class="col-xl-6 col-lg-12"></div>
								<div class="col-xl-4 col-lg-12">
									<h5>
										<liferay-ui:message key="signature-tag" />
									</h5>
									<div class="form-group">
										<select class="form-control select2"
											id="<portlet:namespace />signatureTag"
											name="<portlet:namespace />signatureTag">
											<option value=""><liferay-ui:message
													key="please-select" /></option>
											<c:forEach items="${categoryTags}" var="categoryTag">
												<option value="${categoryTag.getTitle(locale)}">${categoryTag.getTitle(locale)}</option>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="col-xl-1 col-lg-12">
									<!--<h5>
					   <span class="arrow-icon">*</span></h5> -->

					  <h5>&nbsp;</h5>
                      <div class="form-group">
                      	<button type="button" class="btn btn-outline-warning mr-1" id="<portlet:namespace />addSignatureTag" 
                      		name="<portlet:namespace />addSignatureTag"><i class="fa fa-plus"></i></button>
                      </div>
                    </div>
                    <div class="col-xl-7 col-lg-12">
                      
                    </div>
                    <div class="col-xl-12 col-lg-12">
	                     <h5><liferay-ui:message key="signature" /> </h5>
		                <div class="form-group" id="<portlet:namespace />signatureFormGroup" style="width:90%">
							<input id="<portlet:namespace />signatureEnUSHidden"
								name="<portlet:namespace />signatureEnUSHidden" type="hidden"
								value='${emailTemplateMaster.signature}' />
							<liferay-editor:editor contents="${enUSSignatureVal}"
								editorName='<%= PropsUtil.get("editor.wysiwyg.portal-web.docroot.html.taglib.ui.email_notification_settings.jsp") %>'
								name="signatureEnUS" onChangeMethod="changeEnUSSignature" />
							<input id="<portlet:namespace />signatureArSAHidden"
								name="<portlet:namespace />signatureArSAHidden" type="hidden"
								value='${emailTemplateMaster.signature}' />
							<liferay-editor:editor contents="${arSASignatureVal}"
								editorName='<%= PropsUtil.get("editor.wysiwyg.portal-web.docroot.html.taglib.ui.email_notification_settings.jsp") %>'
								name="signatureArSA" onChangeMethod="changeArSASignature" />
						</div>
						<div class="input-group-append" style="padding-left:20px">
							<button type="button" class="btn btn-outline-secondary dropdown-toggle df-language-selector-btn" style="margin-top:23px"
									id="<portlet:namespace />emailSignatureSelectedLocale"  name="<portlet:namespace />emailSignatureSelectedLocale" 
									data-toggle="dropdown" language-id="en_US"><svg aria-hidden="true" class="lexicon-icon lexicon-icon-en-us" focusable="false"><use href="http://localhost:8080/o/omsb-portal-theme/images/clay/icons.svg#en-us"></use></svg><span class="df-lang-text">en-US</span><span class="df-lang-btn"><i class="fa fa-caret-down"></i></span></button>
							<div class="dropdown-menu df-dropdown-menu">
								<button type="button" class="dropdown-item" onclick="changeEmailTemplateLocale(this, true);" language-id="en_US" 
										reflect-on-field-id="emailSignatureSelectedLocale"><svg aria-hidden="true" class="lexicon-icon lexicon-icon-en-us" focusable="false"><use href="http://localhost:8080/o/omsb-portal-theme/images/clay/icons.svg#en-us"></use></svg><span class="df-lang-text">en-US</span></button>
								<button type="button" class="dropdown-item" onclick="changeEmailTemplateLocale(this, true);" language-id="ar_SA" 
										reflect-on-field-id="emailSignatureSelectedLocale"><svg aria-hidden="true" class="lexicon-icon lexicon-icon-ar-sa" focusable="false"><use href="http://localhost:8080/o/omsb-portal-theme/images/clay/icons.svg#ar-sa"></use></svg><span class="df-lang-text">ar-SA</span></button>
							</div>
						</div>
                    </div>
                  </div>
                  <!--row-->
                  <!-- User Notification Section -->
                  <div class="row">
					<div class="col-xl-3 col-lg-3">
						<input type="checkbox" id="<portlet:namespace />userNotification" 
						name="<portlet:namespace />userNotification" ${not empty emailTemplateMaster.userNotification ? 'checked' : ''} />
						<label for="<portlet:namespace />userNotification"> <h5><liferay-ui:message key="user-notification" /></h5> </label>
					</div>
				  </div>
				  <div class="row" style="display: none" id="<portlet:namespace />userNotificationRadioRow">
				  	<div class="col-md-6 col-lg-4 col-xl-4 col-sm-12 radio-group-section">
						<input type="radio" class="omsb-radio-field" id="<portlet:namespace />userNotificationEditorRadio" name="<portlet:namespace />userNotificationEl" value="userNotificationEditor"
						${(not empty emailTemplateMaster.userNotification) and  emailTemplateMaster.isRichText ? 'checked' : ''} />
						<label class="pr-2" for="<portlet:namespace />userNotificationEditorRadio"><liferay-ui:message key="html-editor" /></label>
						<input type="radio" class="omsb-radio-field" id="<portlet:namespace />userNotificationTextareaRadio" name="<portlet:namespace />userNotificationEl" value="userNotificationTextarea"
						${(not empty emailTemplateMaster.userNotification) and  !(emailTemplateMaster.isRichText) ? 'checked' : ''} />
						<label for="<portlet:namespace />userNotificationTextareaRadio"><liferay-ui:message key="text-area" /></label>
						<div class="input-group-error"></div>
					</div>
				  </div>
				  <div class="row" id="<portlet:namespace />userNotificationEditorRow" style="display: none">
					  <div class="form-group" style="width:90%" id="<portlet:namespace />userNotificationEditor">
					  	<input id="<portlet:namespace />enUSUserNotificationHidden" name="<portlet:namespace />enUSUserNotificationHidden" 
								type="hidden" value='${enUSUserNotificationVal}' />
					  	<input id="<portlet:namespace />arSAUserNotificationHidden" name="<portlet:namespace />arSAUserNotificationHidden" 
					  			type="hidden" value='${arSAUserNotificationVal}' />
					  	<c:choose>
							<c:when test="${(not empty emailTemplateMaster.userNotification) and emailTemplateMaster.isRichText}">
								<liferay-editor:editor
									contents="${enUSUserNotificationVal}"
									editorName='<%= PropsUtil.get("editor.wysiwyg.portal-web.docroot.html.taglib.ui.email_notification_settings.jsp") %>'
									name="enUSUserNotificationEditorBody" onChangeMethod="changeUserNotificationEditor"
								/>
								
								<liferay-editor:editor contents="${arSAUserNotificationVal}"
									editorName='<%= PropsUtil.get("editor.wysiwyg.portal-web.docroot.html.taglib.ui.email_notification_settings.jsp") %>'
									name="arSAUserNotificationEditorBody" onChangeMethod="changeUserNotificationEditor"
								/>
							</c:when>
							<c:otherwise>
								<liferay-editor:editor contents=""
									editorName='<%= PropsUtil.get("editor.wysiwyg.portal-web.docroot.html.taglib.ui.email_notification_settings.jsp") %>'
									name="enUSUserNotificationEditorBody" onChangeMethod="changeUserNotificationEditor"
								/>
								<liferay-editor:editor contents=""
									editorName='<%= PropsUtil.get("editor.wysiwyg.portal-web.docroot.html.taglib.ui.email_notification_settings.jsp") %>'
									name="arSAUserNotificationEditorBody" onChangeMethod="changeUserNotificationEditor"
								/>
							</c:otherwise>
						</c:choose>
						<div class="form-group-field-error" id="<portlet:namespace />userNotificationEditorMsg" style="display:none;">
							<span id="<portlet:namespace />notification-editor-error" class="has-body-help-block"><liferay-ui:message key="add-user-notification" /></span>
						</div>
					  </div>
					  <div class="input-group-append" style="padding-left:20px">
						<button type="button" class="btn btn-outline-secondary dropdown-toggle df-language-selector-btn" style="margin-top:23px"
								id="<portlet:namespace />userNotificationHTMLSelectedLocale"  name="<portlet:namespace />userNotificationHTMLSelectedLocale" 
								data-toggle="dropdown" language-id="en_US"><svg aria-hidden="true" class="lexicon-icon lexicon-icon-en-us" focusable="false"><use href="http://localhost:8080/o/omsb-portal-theme/images/clay/icons.svg#en-us"></use></svg><span class="df-lang-text">en-US</span><span class="df-lang-btn"><i class="fa fa-caret-down"></i></span></button>
						<div class="dropdown-menu df-dropdown-menu">
							<button type="button" class="dropdown-item" onclick="changeEmailTemplateLocale(this, true);" language-id="en_US" 
									reflect-on-field-id="userNotificationHTMLSelectedLocale"><svg aria-hidden="true" class="lexicon-icon lexicon-icon-en-us" focusable="false"><use href="http://localhost:8080/o/omsb-portal-theme/images/clay/icons.svg#en-us"></use></svg><span class="df-lang-text">en-US</span></button>
							<button type="button" class="dropdown-item" onclick="changeEmailTemplateLocale(this, true);" language-id="ar_SA" 
									reflect-on-field-id="userNotificationHTMLSelectedLocale"><svg aria-hidden="true" class="lexicon-icon lexicon-icon-ar-sa" focusable="false"><use href="http://localhost:8080/o/omsb-portal-theme/images/clay/icons.svg#ar-sa"></use></svg><span class="df-lang-text">ar-SA</span></button>
						</div>
					</div>
				  </div>
				  <div class="row" style="display: none;" id="<portlet:namespace />userNotificationTextareaRow">
					  <div class="form-group" style="width:60%">
						  <c:choose>
							<c:when test="${(not empty emailTemplateMaster.userNotification) and !(emailTemplateMaster.isRichText)}">
								<textarea rows="3" id="<portlet:namespace />enUSUserNotificationTextarea" 
									name="<portlet:namespace />enUSUserNotificationTextarea" class="form-control" 
									placeholder='<liferay-ui:message key="user-notification" />' maxlength="500">
										${enUSUserNotificationVal}
								</textarea>
								<textarea rows="3" id="<portlet:namespace />arSAUserNotificationTextarea" 
									name="<portlet:namespace />arSAUserNotificationTextarea" class="form-control" 
									placeholder='<liferay-ui:message key="user-notification" />' maxlength="500">
										${arSAUserNotificationVal}
								</textarea>
							</c:when>
							<c:otherwise>
								<textarea rows="3" id="<portlet:namespace />enUSUserNotificationTextarea" 
									name="<portlet:namespace />enUSUserNotificationTextarea" class="form-control" 
									placeholder='<liferay-ui:message key="user-notification" />' maxlength="500">
								</textarea>
								<textarea rows="3" id="<portlet:namespace />arSAUserNotificationTextarea" 
									name="<portlet:namespace />arSAUserNotificationTextarea" class="form-control" 
									placeholder='<liferay-ui:message key="user-notification" />' maxlength="500">
								</textarea>
							</c:otherwise>
						  </c:choose>
					  </div>
					  <div class="input-group-append" style="padding-left:20px">
						<button type="button" class="btn btn-outline-secondary dropdown-toggle df-language-selector-btn" 
								id="<portlet:namespace />userNotificationTextareaSelectedLocale"  name="<portlet:namespace />userNotificationTextareaSelectedLocale" 
								data-toggle="dropdown" language-id="en_US"><svg aria-hidden="true" class="lexicon-icon lexicon-icon-en-us" focusable="false"><use href="http://localhost:8080/o/omsb-portal-theme/images/clay/icons.svg#en-us"></use></svg><span class="df-lang-text">en-US</span><span class="df-lang-btn"><i class="fa fa-caret-down"></i></span></button>
						<div class="dropdown-menu df-dropdown-menu">
							<button type="button" class="dropdown-item" onclick="changeEmailTemplateLocale(this, true);" language-id="en_US" 
									reflect-on-field-id="userNotificationTextareaSelectedLocale"><svg aria-hidden="true" class="lexicon-icon lexicon-icon-en-us" focusable="false"><use href="http://localhost:8080/o/omsb-portal-theme/images/clay/icons.svg#en-us"></use></svg><span class="df-lang-text">en-US</span></button>
							<button type="button" class="dropdown-item" onclick="changeEmailTemplateLocale(this, true);" language-id="ar_SA" 
									reflect-on-field-id="userNotificationTextareaSelectedLocale"><svg aria-hidden="true" class="lexicon-icon lexicon-icon-ar-sa" focusable="false"><use href="http://localhost:8080/o/omsb-portal-theme/images/clay/icons.svg#ar-sa"></use></svg><span class="df-lang-text">ar-SA</span></button>
						</div>
					</div>
				  </div>
				  <div class="row">
					<div class="col-md-6 clearfix operationBarleft">
						<button class="btn btn-primary" type="button"
								name="<portlet:namespace />saveButton"
								id="<portlet:namespace />saveButton">
								<i class="fa fa-check-square-o"></i>
								<liferay-ui:message key="save" />
							</button>
					</div>
					<div class="col-md-6 clearfix operationBarright">
						<button class="btn btn-primary float-right" type="button"
								name="<portlet:namespace />backButton"
								id="<portlet:namespace />backButton">
								<i class="fa fa-long-arrow-left"></i>
								<liferay-ui:message key="back" />
						</button>
					</div>
				</div>
              </form>
                <!-- Form Wizard -->
            </div>
            <!--card-body-->
          </div>
          <!--card-content-->
      </div>
      <!--card-->
    </div>
    <!--col-12-->
  </div>
  <!--row-->
</section>
<!--inputmask-->

<div class="modal fade text-left add-more-attachment-error-dialog"
	id="<portlet:namespace />addMoreAttachmentErrorDialog"
	aria-labelledby="<portlet:namespace />addMoreAttachmentErrorDialog"
	tabindex="-1" role="dialog" aria-hidden="true" style="display: none;">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="addMoreAttachmentErrorDialogLabel">
					<liferay-ui:message key="error" />
				</h4>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<p><%= LanguageUtil.format(request, "add-more-attachments-error-msg-x", 
				String.valueOf(renderRequest.getAttribute("attachmentFileUploadLimit")), false) %></p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn grey btn-outline-primary"
					data-dismiss="modal">
					<liferay-ui:message key="close" />
				</button>
			</div>
		</div>
	</div>
</div>
<div class="modal fade text-left delete-modal"
	id="<portlet:namespace />deleteAttachmentFileConformationModal"
	aria-labelledby="deleteAttachmentFileConformationModalLabel"
	tabindex="-1" role="dialog" aria-hidden="true" style="display: none;">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title"
					id="deleteAttachmentFileConformationModalLabel">
					<liferay-ui:message key="delete" />
				</h4>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<p>
					<liferay-ui:message
						key="are-you-sure-you-want-to-delete-this-file-attachment" />
				</p>
				<input type="hidden"
					name="<portlet:namespace />deletingFileAttachmentId"
					id="<portlet:namespace />deletingFileAttachmentId" /> <input
					type="hidden" name="<portlet:namespace />deletingFileAttachmentInd"
					id="<portlet:namespace />deletingFileAttachmentInd" />
			</div>
			<div class="modal-footer">
				<button type="button" class="btn grey btn-outline-primary"
					data-dismiss="modal">
					<liferay-ui:message key="close" />
				</button>
				<button type="button" class="btn btn-primary"
					name="<portlet:namespace />deleteFileAttachmentButton"
					id="<portlet:namespace />deleteFileAttachmentButton">
					<liferay-ui:message key="delete" />
				</button>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
$(document).ready(function () {
	
	var config = new Object({}),
		namespace = '<portlet:namespace />',
		contextPath = '<%=request.getContextPath()%>',
		themeImagesPath = '<%= themeDisplay.getPathThemeImages()%>',
		getCategoryTagsURL = '${getCategoryTagsURL}',
		emailTemplateFormJEl = '#' + namespace + 'emailTemplateForm',
		templateIdJEl = '#' + namespace + 'templateId',
		templateNameJEl = '#' + namespace + 'templateName',
		senderTypeJEl = '#' + namespace + 'senderType',
		customSenderEmailSectionJEl = '#' + namespace + 'customSenderEmailSection',
		senderEmailIdJEl = '#' + namespace + 'senderEmailId',
		defaultCCJEl = '#' + namespace + 'defaultCC',
		defaultBCCJEl = '#' + namespace + 'defaultBCC',
		bodyType1JEl = '#' + namespace + 'bodyType1',
		bodyType2JEl = '#' + namespace + 'bodyType2',
		dynamicBodyEnUSJEl = namespace + 'dynamicBodyEnUS',
		dynamicBodyArSAJEl = namespace + 'dynamicBodyArSA',
		dynamicBodyEnUSContainerJEl = '#' + namespace + 'dynamicBodyEnUSContainer',
		dynamicBodyArSAContainerJEl = '#' + namespace + 'dynamicBodyArSAContainer',
		dynamicBodyArSAHiddenJEl = '#' + namespace + 'dynamicBodyArSAHidden',
		dynamicBodyEnUSHiddenJEl = '#' + namespace + 'dynamicBodyEnUSHidden',
		staticBodyEnUSJEl = namespace + 'staticBodyEnUS',
		staticBodyArSAJEl = namespace + 'staticBodyArSA',
		staticBodyEnUSContainerJEl = '#' + namespace + 'staticBodyEnUSContainer',
		staticBodyArSAContainerJEl = '#' + namespace + 'staticBodyArSAContainer',
		staticBodyArSAHiddenJEl = '#' + namespace + 'staticBodyArSAHidden',
		staticBodyEnUSHiddenJEl = '#' + namespace + 'staticBodyEnUSHidden',
		signatureEnUSJEl = namespace + 'signatureEnUS',
		signatureArSAJEl = namespace + 'signatureArSA',
		signatureEnUSContainerJEl = '#' + namespace + 'signatureEnUSContainer',
		signatureArSAContainerJEl = '#' + namespace + 'signatureArSAContainer',
		signatureArSAHiddenJEl = '#' + namespace + 'signatureArSAHidden',
		signatureEnUSHiddenJEl = '#' + namespace + 'signatureEnUSHidden',
		subjectAR_SAJEl = '#' + namespace + 'subject_arSA',
		subjectEN_USJEl = '#' + namespace + 'subject_enUS',
		subjectJEl = '#' + namespace + 'subject_',
		body1MsgJEl = '#' + namespace + 'body1Msg',
		body1FormGroupJEl = '#' + namespace + 'body1FormGroup',
		body2FormGroupJEl = '#' + namespace + 'body2FormGroup',
		signatureHiddenJEl = '#' + namespace + 'signatureHidden',
		signatureMsgJEl = '#' + namespace + 'signatureMsg',
		signatureFormGroupJEl = '#' + namespace + 'signatureFormGroup',
		templateNameVaildator = namespace + 'templateName',
		senderTypeValidator = namespace + 'senderType',
		bodyType1Vaildator = namespace + 'bodyType1',
		body1Vaildator = namespace + 'dynamicBodyEnUS',
		subjectVaildator = namespace + 'subject_enUS',
		emailSubjectSelectedLocaleJEl = '#' + namespace + 'emailSubjectSelectedLocale',
		emailDynamicBodySelectedLocaleJEl = '#' + namespace + 'emailDynamicBodySelectedLocale',
		emailStaticBodySelectedLocaleJEl = '#' + namespace + 'emailStaticBodySelectedLocale',
		emailSignatureSelectedLocaleJEl = '#' + namespace + 'emailSignatureSelectedLocale',
		userNotificationHTMLSelectedLocaleJEl = '#' + namespace + 'userNotificationHTMLSelectedLocale',
		userNotificationTextareaSelectedLocaleJEl = '#' + namespace + 'userNotificationTextareaSelectedLocale',
		defaultCCVaildator = namespace + 'defaultCC',
		defaultBCCVaildator = namespace + 'defaultBCC',
		saveButtonJEl = '#' + namespace + 'saveButton',
		backButtonJEl = '#' + namespace + 'backButton',
		attachmentSectionJEl = '#' + namespace + 'attachmentSection',
		attachmentFormGroup1JEl = '#' + namespace + 'attachmentFormGroup1',
		attachmentBtnSectionJEl = '#' + namespace + 'attachmentBtnSection',
		attachmentActionBtn1JEl = '#' + namespace + 'attachmentActionBtn1',
		addMoreAttachmentBtn1JEl = '#' + namespace + 'addMoreAttachmentBtn1',
		clearMoreAttachmentBtn1JEl = '#' + namespace + 'clearMoreAttachmentBtn1',
		addMoreAttachmentErrorDialogJEl = '#' + namespace + 'addMoreAttachmentErrorDialog',
		deleteAttachmentFileConformationModalJEl = '#' + namespace + 'deleteAttachmentFileConformationModal',
		deletingFileAttachmentIndJEl = '#' + namespace + 'deletingFileAttachmentInd',
		deletingFileAttachmentIdJEl = '#' + namespace + 'deletingFileAttachmentId',
		deleteFileAttachmentButtonJEl = '#' + namespace + 'deleteFileAttachmentButton',
		deletedFileEntryIdsJEl = '#' + namespace + 'deletedFileEntryIds',
		bodyTag1JEl = '#' + namespace + 'bodyTag1',
		bodyTag2JEl = '#' + namespace + 'bodyTag2',
		subjectTagJEl = '#' + namespace + 'subjectTag',
		signatureTagJEl = '#' + namespace + 'signatureTag',
		addBodyTag1JEl = '#' + namespace + 'addBodyTag1',
		addBodyTag2JEl = '#' + namespace + 'addBodyTag2',
		addSubjectTagJEl = '#' + namespace + 'addSubjectTag',
		addSignatureTagJEl = '#' + namespace + 'addSignatureTag',
		attachmentFileUploadLimit = '${attachmentFileUploadLimit}',
		emailTemplateMasterCCVal = encodeURI('${emailTemplateMaster.defaultCC}'),
		emailTemplateMasterBCCVal = encodeURI('${emailTemplateMaster.defaultBCC}'),
		attachmentFileEntriesMapLen = '${fn:length(attachmentFileEntriesMap)}',
		allowedFileExtensions = encodeURI('${allowedFileExtensions}'),
		isEdit = '${isEdit}',
		userNotificationJEl = '#' + namespace + 'userNotification',
		userNotificationRadioRowJEl = '#' + namespace + 'userNotificationRadioRow',
		userNotificationEditorRadioJEl = '#' + namespace + 'userNotificationEditorRadio',
		userNotificationTextareaRadioJEl = '#' + namespace + 'userNotificationTextareaRadio',
		userNotificationElJEl = namespace + 'userNotificationEl',
		userNotificationEditorRowJEl = '#' + namespace + 'userNotificationEditorRow',
		userNotificationEditorJEl = '#' + namespace + 'userNotificationEditor',
		userNotificationTextareaRowJEl = '#' + namespace + 'userNotificationTextareaRow',
		userNotificationTextareaJEl = '#' + namespace + 'userNotificationTextarea',
		userNotificationTextareaValidator = namespace + 'userNotificationTextarea',
		userNotificationEditorHiddenJEl = '#' + namespace + 'userNotificationEditorHidden',
		userNotificationEditorMsgJEl = '#' + namespace + 'userNotificationEditorMsg',
		enUSUserNotificationEditorBodyJEl = '#' + namespace + 'enUSUserNotificationEditorBody',
		arSAUserNotificationEditorBodyJEl = '#' + namespace + 'arSAUserNotificationEditorBody',
		enUSUserNotificationTextareaJEl = '#' + namespace + 'enUSUserNotificationTextarea',
		arSAUserNotificationTextareaJEl = '#' + namespace + 'arSAUserNotificationTextarea',
		enUSUserNotificationEditorBodyContainerJEl = '#' + namespace + 'enUSUserNotificationEditorBodyContainer',
		arSAUserNotificationEditorBodyContainerJEl = '#' + namespace + 'arSAUserNotificationEditorBodyContainer',
		
		emailTemplateSubject, emailTemplateDynamicBody, emailTemplateStaticBody, emailTemplateSignature;
		
		if(isEdit){
			emailTemplateSubject = '${emailTemplateMaster.subject}';
		}

	config.namespace = namespace;
	config.contextPath = contextPath;
	config.getCategoryTagsURL = getCategoryTagsURL;
	config.themeImagesPath = themeImagesPath;
	config.emailTemplateFormJEl = emailTemplateFormJEl;
	config.templateIdJEl = templateIdJEl;
	config.senderTypeJEl = senderTypeJEl;
	config.senderEmailIdJEl = senderEmailIdJEl;
	config.defaultCCJEl = defaultCCJEl;
	config.defaultBCCJEl = defaultBCCJEl;
	config.bodyType1JEl = bodyType1JEl;
	config.bodyType2JEl = bodyType2JEl;
	config.dynamicBodyEnUSJEl = dynamicBodyEnUSJEl;
	config.dynamicBodyArSAJEl = dynamicBodyArSAJEl; 
	config.dynamicBodyEnUSContainerJEl = dynamicBodyEnUSContainerJEl;
	config.dynamicBodyArSAContainerJEl = dynamicBodyArSAContainerJEl;
	config.dynamicBodyEnUSHiddenJEl = dynamicBodyEnUSHiddenJEl;
	config.dynamicBodyArSAHiddenJEl = dynamicBodyArSAHiddenJEl;
	config.staticBodyEnUSJEl = staticBodyEnUSJEl;
	config.staticBodyArSAJEl = staticBodyArSAJEl; 
	config.staticBodyEnUSContainerJEl = staticBodyEnUSContainerJEl;
	config.staticBodyArSAContainerJEl = staticBodyArSAContainerJEl;
	config.staticBodyEnUSHiddenJEl = staticBodyEnUSHiddenJEl;
	config.staticBodyArSAHiddenJEl = staticBodyArSAHiddenJEl;
	config.signatureEnUSJEl = signatureEnUSJEl;
	config.signatureArSAJEl = signatureArSAJEl; 
	config.signatureEnUSContainerJEl = signatureEnUSContainerJEl;
	config.signatureArSAContainerJEl = signatureArSAContainerJEl;
	config.signatureEnUSHiddenJEl = signatureEnUSHiddenJEl;
	config.signatureArSAHiddenJEl = signatureArSAHiddenJEl;
	config.subjectEN_USJEl = subjectEN_USJEl;
	config.subjectAR_SAJEl = subjectAR_SAJEl;
	config.subjectJEl = subjectJEl;
	config.body1MsgJEl = body1MsgJEl;
	config.body1FormGroupJEl = body1FormGroupJEl;
	config.signatureMsgJEl = signatureMsgJEl;
	config.body2FormGroupJEl = body2FormGroupJEl;
	config.signatureFormGroupJEl = signatureFormGroupJEl;
	config.signatureHiddenJEl = signatureHiddenJEl;
	config.customSenderEmailSectionJEl = customSenderEmailSectionJEl;
	config.templateNameVaildator = templateNameVaildator;
	config.senderTypeValidator = senderTypeValidator;
	config.bodyType1Vaildator = bodyType1Vaildator;
	config.body1Vaildator = body1Vaildator;
	config.subjectVaildator = subjectVaildator;
	config.defaultCCVaildator = defaultCCVaildator;
	config.defaultBCCVaildator = defaultBCCVaildator;
	config.saveButtonJEl = saveButtonJEl;
	config.backButtonJEl = backButtonJEl;
	config.emailSubjectSelectedLocaleJEl = emailSubjectSelectedLocaleJEl;
	config.emailDynamicBodySelectedLocaleJEl = emailDynamicBodySelectedLocaleJEl;
	config.emailStaticBodySelectedLocaleJEl = emailStaticBodySelectedLocaleJEl;
	config.emailSignatureSelectedLocaleJEl = emailSignatureSelectedLocaleJEl;
	config.attachmentFileUploadLimit = attachmentFileUploadLimit;
	config.attachmentSectionJEl = attachmentSectionJEl;
	config.attachmentFormGroup1JEl = attachmentFormGroup1JEl;
	config.attachmentBtnSectionJEl = attachmentBtnSectionJEl;
	config.attachmentActionBtn1JEl = attachmentActionBtn1JEl;
	config.addMoreAttachmentBtn1JEl = addMoreAttachmentBtn1JEl;
	config.clearMoreAttachmentBtn1JEl = clearMoreAttachmentBtn1JEl;
	config.addMoreAttachmentErrorDialogJEl = addMoreAttachmentErrorDialogJEl;
	config.deleteAttachmentFileConformationModalJEl = deleteAttachmentFileConformationModalJEl;
	config.deletingFileAttachmentIdJEl = deletingFileAttachmentIdJEl;
	config.deletingFileAttachmentIndJEl = deletingFileAttachmentIndJEl;
	config.deleteFileAttachmentButtonJEl = deleteFileAttachmentButtonJEl;
	config.deletedFileEntryIdsJEl = deletedFileEntryIdsJEl;
	config.bodyTag1JEl = bodyTag1JEl;
	config.bodyTag2JEl = bodyTag2JEl;
	config.subjectTagJEl = subjectTagJEl;
	config.signatureTagJEl = signatureTagJEl;
	config.addBodyTag1JEl = addBodyTag1JEl;
	config.addBodyTag2JEl = addBodyTag2JEl;
	config.addSubjectTagJEl = addSubjectTagJEl;
	config.addSignatureTagJEl = addSignatureTagJEl;
	config.emailTemplateMasterCCVal = emailTemplateMasterCCVal,
	config.emailTemplateMasterBCCVal = emailTemplateMasterBCCVal;
	config.allowedFileExtensions = allowedFileExtensions;
	config.attachmentFileEntriesMapLen = attachmentFileEntriesMapLen;
	config.userNotificationJEl = userNotificationJEl;
	config.userNotificationRadioRowJEl = userNotificationRadioRowJEl;
	config.userNotificationEditorRadioJEl = userNotificationEditorRadioJEl;
	config.userNotificationTextareaRadioJEl = userNotificationTextareaRadioJEl;
	config.userNotificationElJEl = userNotificationElJEl;
	config.userNotificationEditorRowJEl = userNotificationEditorRowJEl;
	config.userNotificationEditorJEl = userNotificationEditorJEl;
	config.userNotificationTextareaRowJEl = userNotificationTextareaRowJEl;
	config.userNotificationTextareaJEl = userNotificationTextareaJEl;
	config.userNotificationTextareaValidator = userNotificationTextareaValidator;
	config.userNotificationEditorHiddenJEl = userNotificationEditorHiddenJEl;
	config.userNotificationEditorMsgJEl = userNotificationEditorMsgJEl;
	config.userNotificationHTMLSelectedLocaleJEl = userNotificationHTMLSelectedLocaleJEl;
	config.userNotificationTextareaSelectedLocaleJEl = userNotificationTextareaSelectedLocaleJEl;
	config.enUSUserNotificationEditorBodyJEl = enUSUserNotificationEditorBodyJEl;
	config.arSAUserNotificationEditorBodyJEl = arSAUserNotificationEditorBodyJEl;
	config.enUSUserNotificationTextareaJEl = enUSUserNotificationTextareaJEl;
	config.arSAUserNotificationTextareaJEl = arSAUserNotificationTextareaJEl;
	config.enUSUserNotificationEditorBodyContainerJEl = enUSUserNotificationEditorBodyContainerJEl;
	config.arSAUserNotificationEditorBodyContainerJEl = arSAUserNotificationEditorBodyContainerJEl;
	config.isEdit = isEdit;
	if(isEdit){
		config.emailTemplateSubject = emailTemplateSubject;
		config.emailTemplateDynamicBody = emailTemplateDynamicBody;
		config.emailTemplateStaticBody = emailTemplateStaticBody;
		config.emailTemplateSignature = emailTemplateSignature;
	}
	
	omsbPortlet.addEditEmailTemplateFc(config);
	
});
</script>
<aui:script>
	function <portlet:namespace />changeEnUSDynamicBody(html) {
		$('#<portlet:namespace />dynamicBodyEnUSHidden').val(html);
		if(html){
			if($('#<portlet:namespace />body1FormGroup').hasClass('has-body-error')){
				$('#<portlet:namespace />body1FormGroup').removeClass('has-body-error');
			}
			$('#<portlet:namespace />body1Msg').hide();
		}
	}
	function <portlet:namespace />changeArSADynamicBody(html) {
		$('#<portlet:namespace />dynamicBodyArSAHidden').val(html);
		if(html){
			if($('#<portlet:namespace />body1FormGroup').hasClass('has-body-error')){
				$('#<portlet:namespace />body1FormGroup').removeClass('has-body-error');
			}
			$('#<portlet:namespace />body1Msg').hide();
		}
	}
	function <portlet:namespace />changeEnUSSignature(html) {
		$('#<portlet:namespace />signatureEnUSHidden').val(html);
		if(html){
			if($('#<portlet:namespace />signatureFormGroup').hasClass('has-body-error')){
				$('#<portlet:namespace />signatureFormGroup').removeClass('has-body-error');
			}
			$('#<portlet:namespace />signatureMsg').hide();
		}
	}
	function <portlet:namespace />changeArSASignature(html) {
		$('#<portlet:namespace />signatureArSAHidden').val(html);
		if(html){
			if($('#<portlet:namespace />signatureFormGroup').hasClass('has-body-error')){
				$('#<portlet:namespace />signatureFormGroup').removeClass('has-body-error');
			}
			$('#<portlet:namespace />signatureMsg').hide();
		}
	}
	function <portlet:namespace />changeUserNotificationEditor(html) {
		$('#<portlet:namespace />userNotificationEditorHidden').val(html);
		var value = $('input[type=radio][name="<portlet:namespace />userNotificationEl"]:checked').val();
		if(html || value =='userNotificationTextarea'){
			if($('#<portlet:namespace />userNotificationEditor').hasClass('has-body-error')){
				$('#<portlet:namespace />userNotificationEditor').removeClass('has-body-error');
			}
			$('#<portlet:namespace />userNotificationEditorMsg').hide();
		}
	}
</aui:script>
