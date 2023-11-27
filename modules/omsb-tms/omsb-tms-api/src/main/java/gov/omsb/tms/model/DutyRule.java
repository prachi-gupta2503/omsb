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
 * The extended model interface for the DutyRule service. Represents a row in the &quot;duty_rule_master&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see DutyRuleModel
 * @generated
 */
@ImplementationClassName("gov.omsb.tms.model.impl.DutyRuleImpl")
@ProviderType
public interface DutyRule extends DutyRuleModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>gov.omsb.tms.model.impl.DutyRuleImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<DutyRule, Long> DUTY_RULE_ID_ACCESSOR =
		new Accessor<DutyRule, Long>() {

			@Override
			public Long get(DutyRule dutyRule) {
				return dutyRule.getDutyRuleId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<DutyRule> getTypeClass() {
				return DutyRule.class;
			}

		};

}