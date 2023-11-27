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

import gov.omsb.tms.model.PatientTypeProgDurationRel;
import gov.omsb.tms.service.PatientTypeProgDurationRelLocalServiceUtil;

/**
 * The extended model base implementation for the PatientTypeProgDurationRel service. Represents a row in the &quot;patient_type_prog_duration_rel&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link PatientTypeProgDurationRelImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PatientTypeProgDurationRelImpl
 * @see PatientTypeProgDurationRel
 * @generated
 */
public abstract class PatientTypeProgDurationRelBaseImpl
	extends PatientTypeProgDurationRelModelImpl
	implements PatientTypeProgDurationRel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a patient type prog duration rel model instance should use the <code>PatientTypeProgDurationRel</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			PatientTypeProgDurationRelLocalServiceUtil.
				addPatientTypeProgDurationRel(this);
		}
		else {
			PatientTypeProgDurationRelLocalServiceUtil.
				updatePatientTypeProgDurationRel(this);
		}
	}

}