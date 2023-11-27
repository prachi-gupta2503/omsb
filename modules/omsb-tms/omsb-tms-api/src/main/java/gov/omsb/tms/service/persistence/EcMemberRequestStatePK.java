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
public class EcMemberRequestStatePK
	implements Comparable<EcMemberRequestStatePK>, Serializable {

	public long ecMemberRequestStateId;
	public String comments;

	public EcMemberRequestStatePK() {
	}

	public EcMemberRequestStatePK(
		long ecMemberRequestStateId, String comments) {

		this.ecMemberRequestStateId = ecMemberRequestStateId;
		this.comments = comments;
	}

	public long getEcMemberRequestStateId() {
		return ecMemberRequestStateId;
	}

	public void setEcMemberRequestStateId(long ecMemberRequestStateId) {
		this.ecMemberRequestStateId = ecMemberRequestStateId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public int compareTo(EcMemberRequestStatePK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (ecMemberRequestStateId < pk.ecMemberRequestStateId) {
			value = -1;
		}
		else if (ecMemberRequestStateId > pk.ecMemberRequestStateId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = comments.compareTo(pk.comments);

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

		if (!(object instanceof EcMemberRequestStatePK)) {
			return false;
		}

		EcMemberRequestStatePK pk = (EcMemberRequestStatePK)object;

		if ((ecMemberRequestStateId == pk.ecMemberRequestStateId) &&
			comments.equals(pk.comments)) {

			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, ecMemberRequestStateId);
		hashCode = HashUtil.hash(hashCode, comments);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("ecMemberRequestStateId=");

		sb.append(ecMemberRequestStateId);
		sb.append(", comments=");

		sb.append(comments);

		sb.append("}");

		return sb.toString();
	}

}