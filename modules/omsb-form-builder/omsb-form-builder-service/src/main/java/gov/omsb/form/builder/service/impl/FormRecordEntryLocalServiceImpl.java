/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package gov.omsb.form.builder.service.impl;

import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

import gov.omsb.form.builder.exception.NoSuchFormRecordEntryException;
import gov.omsb.form.builder.model.FormRecordEntry;
import gov.omsb.form.builder.service.base.FormRecordEntryLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=gov.omsb.form.builder.model.FormRecordEntry",
	service = AopService.class
)
public class FormRecordEntryLocalServiceImpl
	extends FormRecordEntryLocalServiceBaseImpl {
	
	public FormRecordEntry findFormRecordEntryByFormDefinitionIdAndRecordId(long formDefinitionId, long recordId) throws NoSuchFormRecordEntryException  {
		return formRecordEntryPersistence.findByFormDefinitionIdAndRecordId(formDefinitionId, recordId);
	}
	
	public List<FormRecordEntry> getFormDefinitionByStatus(long groupId, int status){
		return formRecordEntryPersistence.findByStatus(groupId, status);
	}
	
	public List<FormRecordEntry> getFormDefinitionByStatus(long groupId, int status, int start, int end){
		return formRecordEntryPersistence.findByStatus(groupId, status, start, end);
	}
}
