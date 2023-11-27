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
 * The extended model interface for the ProgdurationCompetenciesRequirementsRel service. Represents a row in the &quot;progduration_competencies_requirements_rel&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ProgdurationCompetenciesRequirementsRelModel
 * @generated
 */
@ImplementationClassName(
	"gov.omsb.tms.model.impl.ProgdurationCompetenciesRequirementsRelImpl"
)
@ProviderType
public interface ProgdurationCompetenciesRequirementsRel
	extends PersistedModel, ProgdurationCompetenciesRequirementsRelModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>gov.omsb.tms.model.impl.ProgdurationCompetenciesRequirementsRelImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ProgdurationCompetenciesRequirementsRel, Long>
		PROGDURATION_COMPETENCIES_REL_ID_ACCESSOR =
			new Accessor<ProgdurationCompetenciesRequirementsRel, Long>() {

				@Override
				public Long get(
					ProgdurationCompetenciesRequirementsRel
						progdurationCompetenciesRequirementsRel) {

					return progdurationCompetenciesRequirementsRel.
						getProgdurationCompetenciesRelId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<ProgdurationCompetenciesRequirementsRel>
					getTypeClass() {

					return ProgdurationCompetenciesRequirementsRel.class;
				}

			};

}