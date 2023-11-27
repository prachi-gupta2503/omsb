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
 * The extended model interface for the VisitTypeProgDurationRel service. Represents a row in the &quot;visit_type_prog_duration_rel&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see VisitTypeProgDurationRelModel
 * @generated
 */
@ImplementationClassName("gov.omsb.tms.model.impl.VisitTypeProgDurationRelImpl")
@ProviderType
public interface VisitTypeProgDurationRel
	extends PersistedModel, VisitTypeProgDurationRelModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>gov.omsb.tms.model.impl.VisitTypeProgDurationRelImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<VisitTypeProgDurationRel, Long>
		VISIT_TYPE_PROG_DURATION_REL_ID_ACCESSOR =
			new Accessor<VisitTypeProgDurationRel, Long>() {

				@Override
				public Long get(
					VisitTypeProgDurationRel visitTypeProgDurationRel) {

					return visitTypeProgDurationRel.
						getVisitTypeProgDurationRelId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<VisitTypeProgDurationRel> getTypeClass() {
					return VisitTypeProgDurationRel.class;
				}

			};

}