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
public class ProgramProgramTypeRelPK
	implements Comparable<ProgramProgramTypeRelPK>, Serializable {

	public long programPtId;
	public long programTypeId;

	public ProgramProgramTypeRelPK() {
	}

	public ProgramProgramTypeRelPK(long programPtId, long programTypeId) {
		this.programPtId = programPtId;
		this.programTypeId = programTypeId;
	}

	public long getProgramPtId() {
		return programPtId;
	}

	public void setProgramPtId(long programPtId) {
		this.programPtId = programPtId;
	}

	public long getProgramTypeId() {
		return programTypeId;
	}

	public void setProgramTypeId(long programTypeId) {
		this.programTypeId = programTypeId;
	}

	@Override
	public int compareTo(ProgramProgramTypeRelPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (programPtId < pk.programPtId) {
			value = -1;
		}
		else if (programPtId > pk.programPtId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (programTypeId < pk.programTypeId) {
			value = -1;
		}
		else if (programTypeId > pk.programTypeId) {
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

		if (!(object instanceof ProgramProgramTypeRelPK)) {
			return false;
		}

		ProgramProgramTypeRelPK pk = (ProgramProgramTypeRelPK)object;

		if ((programPtId == pk.programPtId) &&
			(programTypeId == pk.programTypeId)) {

			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, programPtId);
		hashCode = HashUtil.hash(hashCode, programTypeId);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("programPtId=");

		sb.append(programPtId);
		sb.append(", programTypeId=");

		sb.append(programTypeId);

		sb.append("}");

		return sb.toString();
	}

}