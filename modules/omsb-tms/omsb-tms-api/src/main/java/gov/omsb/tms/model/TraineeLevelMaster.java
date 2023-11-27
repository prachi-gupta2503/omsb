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
 * The extended model interface for the TraineeLevelMaster service. Represents a row in the &quot;trainee_level_master&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see TraineeLevelMasterModel
 * @generated
 */
@ImplementationClassName("gov.omsb.tms.model.impl.TraineeLevelMasterImpl")
@ProviderType
public interface TraineeLevelMaster
	extends PersistedModel, TraineeLevelMasterModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>gov.omsb.tms.model.impl.TraineeLevelMasterImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<TraineeLevelMaster, Long>
		TRAINEE_LEVEL_MASTER_ID_ACCESSOR =
			new Accessor<TraineeLevelMaster, Long>() {

				@Override
				public Long get(TraineeLevelMaster traineeLevelMaster) {
					return traineeLevelMaster.getTraineeLevelMasterId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<TraineeLevelMaster> getTypeClass() {
					return TraineeLevelMaster.class;
				}

			};

}