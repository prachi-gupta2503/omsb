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
 * The extended model interface for the ProcedurePgProgdurationRel service. Represents a row in the &quot;procedure_pg_progduration_rel&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ProcedurePgProgdurationRelModel
 * @generated
 */
@ImplementationClassName(
	"gov.omsb.tms.model.impl.ProcedurePgProgdurationRelImpl"
)
@ProviderType
public interface ProcedurePgProgdurationRel
	extends PersistedModel, ProcedurePgProgdurationRelModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>gov.omsb.tms.model.impl.ProcedurePgProgdurationRelImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ProcedurePgProgdurationRel, Long>
		PROCEDURE_PG_PD_REL_ID_ACCESSOR =
			new Accessor<ProcedurePgProgdurationRel, Long>() {

				@Override
				public Long get(
					ProcedurePgProgdurationRel procedurePgProgdurationRel) {

					return procedurePgProgdurationRel.getProcedurePgPdRelId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<ProcedurePgProgdurationRel> getTypeClass() {
					return ProcedurePgProgdurationRel.class;
				}

			};

}