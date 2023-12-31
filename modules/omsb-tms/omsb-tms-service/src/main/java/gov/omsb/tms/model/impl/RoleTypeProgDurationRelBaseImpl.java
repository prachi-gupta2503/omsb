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

import gov.omsb.tms.model.RoleTypeProgDurationRel;
import gov.omsb.tms.service.RoleTypeProgDurationRelLocalServiceUtil;

/**
 * The extended model base implementation for the RoleTypeProgDurationRel service. Represents a row in the &quot;role_type_prog_duration_rel&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link RoleTypeProgDurationRelImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RoleTypeProgDurationRelImpl
 * @see RoleTypeProgDurationRel
 * @generated
 */
public abstract class RoleTypeProgDurationRelBaseImpl
	extends RoleTypeProgDurationRelModelImpl
	implements RoleTypeProgDurationRel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a role type prog duration rel model instance should use the <code>RoleTypeProgDurationRel</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			RoleTypeProgDurationRelLocalServiceUtil.addRoleTypeProgDurationRel(
				this);
		}
		else {
			RoleTypeProgDurationRelLocalServiceUtil.
				updateRoleTypeProgDurationRel(this);
		}
	}

}