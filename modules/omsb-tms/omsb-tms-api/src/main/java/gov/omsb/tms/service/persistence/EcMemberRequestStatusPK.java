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

package gov.omsb.tms.service.persistence;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EcMemberRequestStatusPK
	implements Comparable<EcMemberRequestStatusPK>, Serializable {

	public long ecMemberRequestStatusId;
	public String code;

	public EcMemberRequestStatusPK() {
	}

	public EcMemberRequestStatusPK(long ecMemberRequestStatusId, String code) {
		this.ecMemberRequestStatusId = ecMemberRequestStatusId;
		this.code = code;
	}

	public long getEcMemberRequestStatusId() {
		return ecMemberRequestStatusId;
	}

	public void setEcMemberRequestStatusId(long ecMemberRequestStatusId) {
		this.ecMemberRequestStatusId = ecMemberRequestStatusId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public int compareTo(EcMemberRequestStatusPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (ecMemberRequestStatusId < pk.ecMemberRequestStatusId) {
			value = -1;
		}
		else if (ecMemberRequestStatusId > pk.ecMemberRequestStatusId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = code.compareTo(pk.code);

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EcMemberRequestStatusPK)) {
			return false;
		}

		EcMemberRequestStatusPK pk = (EcMemberRequestStatusPK)object;

		if ((ecMemberRequestStatusId == pk.ecMemberRequestStatusId) &&
			code.equals(pk.code)) {

			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, ecMemberRequestStatusId);
		hashCode = HashUtil.hash(hashCode, code);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("ecMemberRequestStatusId=");

		sb.append(ecMemberRequestStatusId);
		sb.append(", code=");

		sb.append(code);

		sb.append("}");

		return sb.toString();
	}

}