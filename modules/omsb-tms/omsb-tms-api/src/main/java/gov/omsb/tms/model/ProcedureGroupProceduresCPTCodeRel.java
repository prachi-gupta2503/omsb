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

package gov.omsb.tms.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the ProcedureGroupProceduresCPTCodeRel service. Represents a row in the &quot;proceduregroup_procedures_cptcode_rel&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ProcedureGroupProceduresCPTCodeRelModel
 * @generated
 */
@ImplementationClassName(
	"gov.omsb.tms.model.impl.ProcedureGroupProceduresCPTCodeRelImpl"
)
@ProviderType
public interface ProcedureGroupProceduresCPTCodeRel
	extends PersistedModel, ProcedureGroupProceduresCPTCodeRelModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>gov.omsb.tms.model.impl.ProcedureGroupProceduresCPTCodeRelImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ProcedureGroupProceduresCPTCodeRel, Long>
		PG_PROCEDURE_CPT_CODE_REL_ID_ACCESSOR =
			new Accessor<ProcedureGroupProceduresCPTCodeRel, Long>() {

				@Override
				public Long get(
					ProcedureGroupProceduresCPTCodeRel
						procedureGroupProceduresCPTCodeRel) {

					return procedureGroupProceduresCPTCodeRel.
						getPgProcedureCptCodeRelId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<ProcedureGroupProceduresCPTCodeRel>
					getTypeClass() {

					return ProcedureGroupProceduresCPTCodeRel.class;
				}

			};

}