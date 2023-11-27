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
public class EcMemberRequestRotationsPK
	implements Comparable<EcMemberRequestRotationsPK>, Serializable {

	public long ecMemberRequestRotationsId;
	public long ecMemberRequestId;

	public EcMemberRequestRotationsPK() {
	}

	public EcMemberRequestRotationsPK(
		long ecMemberRequestRotationsId, long ecMemberRequestId) {

		this.ecMemberRequestRotationsId = ecMemberRequestRotationsId;
		this.ecMemberRequestId = ecMemberRequestId;
	}

	public long getEcMemberRequestRotationsId() {
		return ecMemberRequestRotationsId;
	}

	public void setEcMemberRequestRotationsId(long ecMemberRequestRotationsId) {
		this.ecMemberRequestRotationsId = ecMemberRequestRotationsId;
	}

	public long getEcMemberRequestId() {
		return ecMemberRequestId;
	}

	public void setEcMemberRequestId(long ecMemberRequestId) {
		this.ecMemberRequestId = ecMemberRequestId;
	}

	@Override
	public int compareTo(EcMemberRequestRotationsPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (ecMemberRequestRotationsId < pk.ecMemberRequestRotationsId) {
			value = -1;
		}
		else if (ecMemberRequestRotationsId > pk.ecMemberRequestRotationsId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (ecMemberRequestId < pk.ecMemberRequestId) {
			value = -1;
		}
		else if (ecMemberRequestId > pk.ecMemberRequestId) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(object instanceof EcMemberRequestRotationsPK)) {
			return false;
		}

		EcMemberRequestRotationsPK pk = (EcMemberRequestRotationsPK)object;

		if ((ecMemberRequestRotationsId == pk.ecMemberRequestRotationsId) &&
			(ecMemberRequestId == pk.ecMemberRequestId)) {

			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, ecMemberRequestRotationsId);
		hashCode = HashUtil.hash(hashCode, ecMemberRequestId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("ecMemberRequestRotationsId=");

		sb.append(ecMemberRequestRotationsId);
		sb.append(", ecMemberRequestId=");

		sb.append(ecMemberRequestId);

		sb.append("}");

		return sb.toString();
	}

}