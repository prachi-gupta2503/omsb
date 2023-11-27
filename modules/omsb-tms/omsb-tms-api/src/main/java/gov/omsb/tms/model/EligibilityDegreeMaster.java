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
 * The extended model interface for the EligibilityDegreeMaster service. Represents a row in the &quot;eligibility_degree_master&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see EligibilityDegreeMasterModel
 * @generated
 */
@ImplementationClassName("gov.omsb.tms.model.impl.EligibilityDegreeMasterImpl")
@ProviderType
public interface EligibilityDegreeMaster
	extends EligibilityDegreeMasterModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>gov.omsb.tms.model.impl.EligibilityDegreeMasterImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<EligibilityDegreeMaster, Long>
		ELIGIBILITY_DEGREE_MASTER_ID_ACCESSOR =
			new Accessor<EligibilityDegreeMaster, Long>() {

				@Override
				public Long get(
					EligibilityDegreeMaster eligibilityDegreeMaster) {

					return eligibilityDegreeMaster.
						getEligibilityDegreeMasterId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<EligibilityDegreeMaster> getTypeClass() {
					return EligibilityDegreeMaster.class;
				}

			};

}