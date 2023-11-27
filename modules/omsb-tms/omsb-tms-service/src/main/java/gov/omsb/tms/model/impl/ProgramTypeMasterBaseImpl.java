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

import gov.omsb.tms.model.ProgramTypeMaster;
import gov.omsb.tms.service.ProgramTypeMasterLocalServiceUtil;

/**
 * The extended model base implementation for the ProgramTypeMaster service. Represents a row in the &quot;program_type_master&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProgramTypeMasterImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProgramTypeMasterImpl
 * @see ProgramTypeMaster
 * @generated
 */
public abstract class ProgramTypeMasterBaseImpl
	extends ProgramTypeMasterModelImpl implements ProgramTypeMaster {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a program type master model instance should use the <code>ProgramTypeMaster</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			ProgramTypeMasterLocalServiceUtil.addProgramTypeMaster(this);
		}
		else {
			ProgramTypeMasterLocalServiceUtil.updateProgramTypeMaster(this);
		}
	}

}