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

package gov.omsb.tms.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import gov.omsb.tms.service.ProgramDutyAssignmentServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>ProgramDutyAssignmentServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProgramDutyAssignmentServiceHttp {

	public static gov.omsb.tms.model.ProgramDutyAssignment
			deleteProgramDutyAssignment(
				HttpPrincipal httpPrincipal, long programDutyAssignmentId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ProgramDutyAssignmentServiceUtil.class,
				"deleteProgramDutyAssignment",
				_deleteProgramDutyAssignmentParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, programDutyAssignmentId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (gov.omsb.tms.model.ProgramDutyAssignment)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static String findDutyTypeAssignmentStatus(
		HttpPrincipal httpPrincipal, long dutyAssignmentId) {

		try {
			MethodKey methodKey = new MethodKey(
				ProgramDutyAssignmentServiceUtil.class,
				"findDutyTypeAssignmentStatus",
				_findDutyTypeAssignmentStatusParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, dutyAssignmentId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (String)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static String findProgramDutyAssignment(
		HttpPrincipal httpPrincipal, long programId, long cohortId,
		long dutyAssignmentId) {

		try {
			MethodKey methodKey = new MethodKey(
				ProgramDutyAssignmentServiceUtil.class,
				"findProgramDutyAssignment",
				_findProgramDutyAssignmentParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, programId, cohortId, dutyAssignmentId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (String)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<gov.omsb.tms.model.TraineeCohortDetails>
		getByProgramId(HttpPrincipal httpPrincipal, long programId) {

		try {
			MethodKey methodKey = new MethodKey(
				ProgramDutyAssignmentServiceUtil.class, "getByProgramId",
				_getByProgramIdParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, programId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<gov.omsb.tms.model.TraineeCohortDetails>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<gov.omsb.tms.custom.dto.UserDTO>
		getByProgramIdAndCohortId(
			HttpPrincipal httpPrincipal, long programId, long cohortId) {

		try {
			MethodKey methodKey = new MethodKey(
				ProgramDutyAssignmentServiceUtil.class,
				"getByProgramIdAndCohortId",
				_getByProgramIdAndCohortIdParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, programId, cohortId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List<gov.omsb.tms.custom.dto.UserDTO>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		ProgramDutyAssignmentServiceHttp.class);

	private static final Class<?>[]
		_deleteProgramDutyAssignmentParameterTypes0 = new Class[] {long.class};
	private static final Class<?>[]
		_findDutyTypeAssignmentStatusParameterTypes1 = new Class[] {long.class};
	private static final Class<?>[] _findProgramDutyAssignmentParameterTypes2 =
		new Class[] {long.class, long.class, long.class};
	private static final Class<?>[] _getByProgramIdParameterTypes3 =
		new Class[] {long.class};
	private static final Class<?>[] _getByProgramIdAndCohortIdParameterTypes4 =
		new Class[] {long.class, long.class};

}