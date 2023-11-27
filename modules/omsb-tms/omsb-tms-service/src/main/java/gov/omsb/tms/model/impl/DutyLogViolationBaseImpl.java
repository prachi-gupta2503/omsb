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

import gov.omsb.tms.model.DutyLogViolation;
import gov.omsb.tms.service.DutyLogViolationLocalServiceUtil;

/**
 * The extended model base implementation for the DutyLogViolation service. Represents a row in the &quot;duty_log_violation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DutyLogViolationImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DutyLogViolationImpl
 * @see DutyLogViolation
 * @generated
 */
public abstract class DutyLogViolationBaseImpl
	extends DutyLogViolationModelImpl implements DutyLogViolation {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a duty log violation model instance should use the <code>DutyLogViolation</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			DutyLogViolationLocalServiceUtil.addDutyLogViolation(this);
		}
		else {
			DutyLogViolationLocalServiceUtil.updateDutyLogViolation(this);
		}
	}

}