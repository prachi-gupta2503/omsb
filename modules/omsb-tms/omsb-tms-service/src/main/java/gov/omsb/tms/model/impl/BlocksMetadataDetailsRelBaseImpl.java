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

package gov.omsb.tms.model.impl;

import gov.omsb.tms.model.BlocksMetadataDetailsRel;
import gov.omsb.tms.service.BlocksMetadataDetailsRelLocalServiceUtil;

/**
 * The extended model base implementation for the BlocksMetadataDetailsRel service. Represents a row in the &quot;blocks_metadata_details_rel&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BlocksMetadataDetailsRelImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BlocksMetadataDetailsRelImpl
 * @see BlocksMetadataDetailsRel
 * @generated
 */
public abstract class BlocksMetadataDetailsRelBaseImpl
	extends BlocksMetadataDetailsRelModelImpl
	implements BlocksMetadataDetailsRel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a blocks metadata details rel model instance should use the <code>BlocksMetadataDetailsRel</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			BlocksMetadataDetailsRelLocalServiceUtil.
				addBlocksMetadataDetailsRel(this);
		}
		else {
			BlocksMetadataDetailsRelLocalServiceUtil.
				updateBlocksMetadataDetailsRel(this);
		}
	}

}