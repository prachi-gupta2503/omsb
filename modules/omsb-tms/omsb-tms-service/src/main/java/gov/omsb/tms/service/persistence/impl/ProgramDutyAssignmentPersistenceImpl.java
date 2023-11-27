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

package gov.omsb.tms.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUID;

import gov.omsb.tms.exception.NoSuchProgramDutyAssignmentException;
import gov.omsb.tms.model.ProgramDutyAssignment;
import gov.omsb.tms.model.ProgramDutyAssignmentTable;
import gov.omsb.tms.model.impl.ProgramDutyAssignmentImpl;
import gov.omsb.tms.model.impl.ProgramDutyAssignmentModelImpl;
import gov.omsb.tms.service.persistence.ProgramDutyAssignmentPersistence;
import gov.omsb.tms.service.persistence.ProgramDutyAssignmentUtil;
import gov.omsb.tms.service.persistence.impl.constants.OMSBTMSPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the program duty assignment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ProgramDutyAssignmentPersistence.class)
public class ProgramDutyAssignmentPersistenceImpl
	extends BasePersistenceImpl<ProgramDutyAssignment>
	implements ProgramDutyAssignmentPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProgramDutyAssignmentUtil</code> to access the program duty assignment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProgramDutyAssignmentImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the program duty assignments where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching program duty assignments
	 */
	@Override
	public List<ProgramDutyAssignment> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the program duty assignments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @return the range of matching program duty assignments
	 */
	@Override
	public List<ProgramDutyAssignment> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the program duty assignments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program duty assignments
	 */
	@Override
	public List<ProgramDutyAssignment> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgramDutyAssignment> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the program duty assignments where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program duty assignments
	 */
	@Override
	public List<ProgramDutyAssignment> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgramDutyAssignment> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<ProgramDutyAssignment> list = null;

		if (useFinderCache) {
			list = (List<ProgramDutyAssignment>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgramDutyAssignment programDutyAssignment : list) {
					if (!uuid.equals(programDutyAssignment.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_PROGRAMDUTYASSIGNMENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProgramDutyAssignmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<ProgramDutyAssignment>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first program duty assignment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a matching program duty assignment could not be found
	 */
	@Override
	public ProgramDutyAssignment findByUuid_First(
			String uuid,
			OrderByComparator<ProgramDutyAssignment> orderByComparator)
		throws NoSuchProgramDutyAssignmentException {

		ProgramDutyAssignment programDutyAssignment = fetchByUuid_First(
			uuid, orderByComparator);

		if (programDutyAssignment != null) {
			return programDutyAssignment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProgramDutyAssignmentException(sb.toString());
	}

	/**
	 * Returns the first program duty assignment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	@Override
	public ProgramDutyAssignment fetchByUuid_First(
		String uuid,
		OrderByComparator<ProgramDutyAssignment> orderByComparator) {

		List<ProgramDutyAssignment> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last program duty assignment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a matching program duty assignment could not be found
	 */
	@Override
	public ProgramDutyAssignment findByUuid_Last(
			String uuid,
			OrderByComparator<ProgramDutyAssignment> orderByComparator)
		throws NoSuchProgramDutyAssignmentException {

		ProgramDutyAssignment programDutyAssignment = fetchByUuid_Last(
			uuid, orderByComparator);

		if (programDutyAssignment != null) {
			return programDutyAssignment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProgramDutyAssignmentException(sb.toString());
	}

	/**
	 * Returns the last program duty assignment in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	@Override
	public ProgramDutyAssignment fetchByUuid_Last(
		String uuid,
		OrderByComparator<ProgramDutyAssignment> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ProgramDutyAssignment> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the program duty assignments before and after the current program duty assignment in the ordered set where uuid = &#63;.
	 *
	 * @param programDutyAssignmentId the primary key of the current program duty assignment
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a program duty assignment with the primary key could not be found
	 */
	@Override
	public ProgramDutyAssignment[] findByUuid_PrevAndNext(
			long programDutyAssignmentId, String uuid,
			OrderByComparator<ProgramDutyAssignment> orderByComparator)
		throws NoSuchProgramDutyAssignmentException {

		uuid = Objects.toString(uuid, "");

		ProgramDutyAssignment programDutyAssignment = findByPrimaryKey(
			programDutyAssignmentId);

		Session session = null;

		try {
			session = openSession();

			ProgramDutyAssignment[] array = new ProgramDutyAssignmentImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, programDutyAssignment, uuid, orderByComparator, true);

			array[1] = programDutyAssignment;

			array[2] = getByUuid_PrevAndNext(
				session, programDutyAssignment, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProgramDutyAssignment getByUuid_PrevAndNext(
		Session session, ProgramDutyAssignment programDutyAssignment,
		String uuid, OrderByComparator<ProgramDutyAssignment> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PROGRAMDUTYASSIGNMENT_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ProgramDutyAssignmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						programDutyAssignment)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgramDutyAssignment> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the program duty assignments where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ProgramDutyAssignment programDutyAssignment :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(programDutyAssignment);
		}
	}

	/**
	 * Returns the number of program duty assignments where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching program duty assignments
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROGRAMDUTYASSIGNMENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"programDutyAssignment.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(programDutyAssignment.uuid IS NULL OR programDutyAssignment.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the program duty assignment where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProgramDutyAssignmentException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a matching program duty assignment could not be found
	 */
	@Override
	public ProgramDutyAssignment findByUUID_G(String uuid, long groupId)
		throws NoSuchProgramDutyAssignmentException {

		ProgramDutyAssignment programDutyAssignment = fetchByUUID_G(
			uuid, groupId);

		if (programDutyAssignment == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchProgramDutyAssignmentException(sb.toString());
		}

		return programDutyAssignment;
	}

	/**
	 * Returns the program duty assignment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	@Override
	public ProgramDutyAssignment fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the program duty assignment where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	@Override
	public ProgramDutyAssignment fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof ProgramDutyAssignment) {
			ProgramDutyAssignment programDutyAssignment =
				(ProgramDutyAssignment)result;

			if (!Objects.equals(uuid, programDutyAssignment.getUuid()) ||
				(groupId != programDutyAssignment.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PROGRAMDUTYASSIGNMENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<ProgramDutyAssignment> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ProgramDutyAssignment programDutyAssignment = list.get(0);

					result = programDutyAssignment;

					cacheResult(programDutyAssignment);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (ProgramDutyAssignment)result;
		}
	}

	/**
	 * Removes the program duty assignment where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the program duty assignment that was removed
	 */
	@Override
	public ProgramDutyAssignment removeByUUID_G(String uuid, long groupId)
		throws NoSuchProgramDutyAssignmentException {

		ProgramDutyAssignment programDutyAssignment = findByUUID_G(
			uuid, groupId);

		return remove(programDutyAssignment);
	}

	/**
	 * Returns the number of program duty assignments where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching program duty assignments
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROGRAMDUTYASSIGNMENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"programDutyAssignment.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(programDutyAssignment.uuid IS NULL OR programDutyAssignment.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"programDutyAssignment.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the program duty assignments where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching program duty assignments
	 */
	@Override
	public List<ProgramDutyAssignment> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the program duty assignments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @return the range of matching program duty assignments
	 */
	@Override
	public List<ProgramDutyAssignment> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the program duty assignments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program duty assignments
	 */
	@Override
	public List<ProgramDutyAssignment> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgramDutyAssignment> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the program duty assignments where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program duty assignments
	 */
	@Override
	public List<ProgramDutyAssignment> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgramDutyAssignment> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<ProgramDutyAssignment> list = null;

		if (useFinderCache) {
			list = (List<ProgramDutyAssignment>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgramDutyAssignment programDutyAssignment : list) {
					if (!uuid.equals(programDutyAssignment.getUuid()) ||
						(companyId != programDutyAssignment.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_PROGRAMDUTYASSIGNMENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProgramDutyAssignmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<ProgramDutyAssignment>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first program duty assignment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a matching program duty assignment could not be found
	 */
	@Override
	public ProgramDutyAssignment findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProgramDutyAssignment> orderByComparator)
		throws NoSuchProgramDutyAssignmentException {

		ProgramDutyAssignment programDutyAssignment = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (programDutyAssignment != null) {
			return programDutyAssignment;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProgramDutyAssignmentException(sb.toString());
	}

	/**
	 * Returns the first program duty assignment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	@Override
	public ProgramDutyAssignment fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProgramDutyAssignment> orderByComparator) {

		List<ProgramDutyAssignment> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last program duty assignment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a matching program duty assignment could not be found
	 */
	@Override
	public ProgramDutyAssignment findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProgramDutyAssignment> orderByComparator)
		throws NoSuchProgramDutyAssignmentException {

		ProgramDutyAssignment programDutyAssignment = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (programDutyAssignment != null) {
			return programDutyAssignment;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProgramDutyAssignmentException(sb.toString());
	}

	/**
	 * Returns the last program duty assignment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	@Override
	public ProgramDutyAssignment fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProgramDutyAssignment> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ProgramDutyAssignment> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the program duty assignments before and after the current program duty assignment in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param programDutyAssignmentId the primary key of the current program duty assignment
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a program duty assignment with the primary key could not be found
	 */
	@Override
	public ProgramDutyAssignment[] findByUuid_C_PrevAndNext(
			long programDutyAssignmentId, String uuid, long companyId,
			OrderByComparator<ProgramDutyAssignment> orderByComparator)
		throws NoSuchProgramDutyAssignmentException {

		uuid = Objects.toString(uuid, "");

		ProgramDutyAssignment programDutyAssignment = findByPrimaryKey(
			programDutyAssignmentId);

		Session session = null;

		try {
			session = openSession();

			ProgramDutyAssignment[] array = new ProgramDutyAssignmentImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, programDutyAssignment, uuid, companyId,
				orderByComparator, true);

			array[1] = programDutyAssignment;

			array[2] = getByUuid_C_PrevAndNext(
				session, programDutyAssignment, uuid, companyId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProgramDutyAssignment getByUuid_C_PrevAndNext(
		Session session, ProgramDutyAssignment programDutyAssignment,
		String uuid, long companyId,
		OrderByComparator<ProgramDutyAssignment> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_PROGRAMDUTYASSIGNMENT_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ProgramDutyAssignmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						programDutyAssignment)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgramDutyAssignment> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the program duty assignments where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ProgramDutyAssignment programDutyAssignment :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(programDutyAssignment);
		}
	}

	/**
	 * Returns the number of program duty assignments where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching program duty assignments
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROGRAMDUTYASSIGNMENT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"programDutyAssignment.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(programDutyAssignment.uuid IS NULL OR programDutyAssignment.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"programDutyAssignment.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByDutyAssignmentId;
	private FinderPath _finderPathWithoutPaginationFindByDutyAssignmentId;
	private FinderPath _finderPathCountByDutyAssignmentId;

	/**
	 * Returns all the program duty assignments where dutyAssignmentId = &#63;.
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @return the matching program duty assignments
	 */
	@Override
	public List<ProgramDutyAssignment> findByDutyAssignmentId(
		long dutyAssignmentId) {

		return findByDutyAssignmentId(
			dutyAssignmentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the program duty assignments where dutyAssignmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @return the range of matching program duty assignments
	 */
	@Override
	public List<ProgramDutyAssignment> findByDutyAssignmentId(
		long dutyAssignmentId, int start, int end) {

		return findByDutyAssignmentId(dutyAssignmentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the program duty assignments where dutyAssignmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program duty assignments
	 */
	@Override
	public List<ProgramDutyAssignment> findByDutyAssignmentId(
		long dutyAssignmentId, int start, int end,
		OrderByComparator<ProgramDutyAssignment> orderByComparator) {

		return findByDutyAssignmentId(
			dutyAssignmentId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the program duty assignments where dutyAssignmentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program duty assignments
	 */
	@Override
	public List<ProgramDutyAssignment> findByDutyAssignmentId(
		long dutyAssignmentId, int start, int end,
		OrderByComparator<ProgramDutyAssignment> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDutyAssignmentId;
				finderArgs = new Object[] {dutyAssignmentId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDutyAssignmentId;
			finderArgs = new Object[] {
				dutyAssignmentId, start, end, orderByComparator
			};
		}

		List<ProgramDutyAssignment> list = null;

		if (useFinderCache) {
			list = (List<ProgramDutyAssignment>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgramDutyAssignment programDutyAssignment : list) {
					if (dutyAssignmentId !=
							programDutyAssignment.getDutyAssignmentId()) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_PROGRAMDUTYASSIGNMENT_WHERE);

			sb.append(_FINDER_COLUMN_DUTYASSIGNMENTID_DUTYASSIGNMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProgramDutyAssignmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dutyAssignmentId);

				list = (List<ProgramDutyAssignment>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first program duty assignment in the ordered set where dutyAssignmentId = &#63;.
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a matching program duty assignment could not be found
	 */
	@Override
	public ProgramDutyAssignment findByDutyAssignmentId_First(
			long dutyAssignmentId,
			OrderByComparator<ProgramDutyAssignment> orderByComparator)
		throws NoSuchProgramDutyAssignmentException {

		ProgramDutyAssignment programDutyAssignment =
			fetchByDutyAssignmentId_First(dutyAssignmentId, orderByComparator);

		if (programDutyAssignment != null) {
			return programDutyAssignment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dutyAssignmentId=");
		sb.append(dutyAssignmentId);

		sb.append("}");

		throw new NoSuchProgramDutyAssignmentException(sb.toString());
	}

	/**
	 * Returns the first program duty assignment in the ordered set where dutyAssignmentId = &#63;.
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	@Override
	public ProgramDutyAssignment fetchByDutyAssignmentId_First(
		long dutyAssignmentId,
		OrderByComparator<ProgramDutyAssignment> orderByComparator) {

		List<ProgramDutyAssignment> list = findByDutyAssignmentId(
			dutyAssignmentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last program duty assignment in the ordered set where dutyAssignmentId = &#63;.
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a matching program duty assignment could not be found
	 */
	@Override
	public ProgramDutyAssignment findByDutyAssignmentId_Last(
			long dutyAssignmentId,
			OrderByComparator<ProgramDutyAssignment> orderByComparator)
		throws NoSuchProgramDutyAssignmentException {

		ProgramDutyAssignment programDutyAssignment =
			fetchByDutyAssignmentId_Last(dutyAssignmentId, orderByComparator);

		if (programDutyAssignment != null) {
			return programDutyAssignment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dutyAssignmentId=");
		sb.append(dutyAssignmentId);

		sb.append("}");

		throw new NoSuchProgramDutyAssignmentException(sb.toString());
	}

	/**
	 * Returns the last program duty assignment in the ordered set where dutyAssignmentId = &#63;.
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	@Override
	public ProgramDutyAssignment fetchByDutyAssignmentId_Last(
		long dutyAssignmentId,
		OrderByComparator<ProgramDutyAssignment> orderByComparator) {

		int count = countByDutyAssignmentId(dutyAssignmentId);

		if (count == 0) {
			return null;
		}

		List<ProgramDutyAssignment> list = findByDutyAssignmentId(
			dutyAssignmentId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the program duty assignments before and after the current program duty assignment in the ordered set where dutyAssignmentId = &#63;.
	 *
	 * @param programDutyAssignmentId the primary key of the current program duty assignment
	 * @param dutyAssignmentId the duty assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a program duty assignment with the primary key could not be found
	 */
	@Override
	public ProgramDutyAssignment[] findByDutyAssignmentId_PrevAndNext(
			long programDutyAssignmentId, long dutyAssignmentId,
			OrderByComparator<ProgramDutyAssignment> orderByComparator)
		throws NoSuchProgramDutyAssignmentException {

		ProgramDutyAssignment programDutyAssignment = findByPrimaryKey(
			programDutyAssignmentId);

		Session session = null;

		try {
			session = openSession();

			ProgramDutyAssignment[] array = new ProgramDutyAssignmentImpl[3];

			array[0] = getByDutyAssignmentId_PrevAndNext(
				session, programDutyAssignment, dutyAssignmentId,
				orderByComparator, true);

			array[1] = programDutyAssignment;

			array[2] = getByDutyAssignmentId_PrevAndNext(
				session, programDutyAssignment, dutyAssignmentId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProgramDutyAssignment getByDutyAssignmentId_PrevAndNext(
		Session session, ProgramDutyAssignment programDutyAssignment,
		long dutyAssignmentId,
		OrderByComparator<ProgramDutyAssignment> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PROGRAMDUTYASSIGNMENT_WHERE);

		sb.append(_FINDER_COLUMN_DUTYASSIGNMENTID_DUTYASSIGNMENTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ProgramDutyAssignmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(dutyAssignmentId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						programDutyAssignment)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgramDutyAssignment> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the program duty assignments where dutyAssignmentId = &#63; from the database.
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 */
	@Override
	public void removeByDutyAssignmentId(long dutyAssignmentId) {
		for (ProgramDutyAssignment programDutyAssignment :
				findByDutyAssignmentId(
					dutyAssignmentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(programDutyAssignment);
		}
	}

	/**
	 * Returns the number of program duty assignments where dutyAssignmentId = &#63;.
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @return the number of matching program duty assignments
	 */
	@Override
	public int countByDutyAssignmentId(long dutyAssignmentId) {
		FinderPath finderPath = _finderPathCountByDutyAssignmentId;

		Object[] finderArgs = new Object[] {dutyAssignmentId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROGRAMDUTYASSIGNMENT_WHERE);

			sb.append(_FINDER_COLUMN_DUTYASSIGNMENTID_DUTYASSIGNMENTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dutyAssignmentId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_DUTYASSIGNMENTID_DUTYASSIGNMENTID_2 =
			"programDutyAssignment.dutyAssignmentId = ?";

	private FinderPath _finderPathWithPaginationFindByDutyAssignmentIdAndStatus;
	private FinderPath
		_finderPathWithoutPaginationFindByDutyAssignmentIdAndStatus;
	private FinderPath _finderPathCountByDutyAssignmentIdAndStatus;

	/**
	 * Returns all the program duty assignments where dutyAssignmentId = &#63; and status = &#63;.
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param status the status
	 * @return the matching program duty assignments
	 */
	@Override
	public List<ProgramDutyAssignment> findByDutyAssignmentIdAndStatus(
		long dutyAssignmentId, String status) {

		return findByDutyAssignmentIdAndStatus(
			dutyAssignmentId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the program duty assignments where dutyAssignmentId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param status the status
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @return the range of matching program duty assignments
	 */
	@Override
	public List<ProgramDutyAssignment> findByDutyAssignmentIdAndStatus(
		long dutyAssignmentId, String status, int start, int end) {

		return findByDutyAssignmentIdAndStatus(
			dutyAssignmentId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the program duty assignments where dutyAssignmentId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param status the status
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program duty assignments
	 */
	@Override
	public List<ProgramDutyAssignment> findByDutyAssignmentIdAndStatus(
		long dutyAssignmentId, String status, int start, int end,
		OrderByComparator<ProgramDutyAssignment> orderByComparator) {

		return findByDutyAssignmentIdAndStatus(
			dutyAssignmentId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the program duty assignments where dutyAssignmentId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param status the status
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program duty assignments
	 */
	@Override
	public List<ProgramDutyAssignment> findByDutyAssignmentIdAndStatus(
		long dutyAssignmentId, String status, int start, int end,
		OrderByComparator<ProgramDutyAssignment> orderByComparator,
		boolean useFinderCache) {

		status = Objects.toString(status, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByDutyAssignmentIdAndStatus;
				finderArgs = new Object[] {dutyAssignmentId, status};
			}
		}
		else if (useFinderCache) {
			finderPath =
				_finderPathWithPaginationFindByDutyAssignmentIdAndStatus;
			finderArgs = new Object[] {
				dutyAssignmentId, status, start, end, orderByComparator
			};
		}

		List<ProgramDutyAssignment> list = null;

		if (useFinderCache) {
			list = (List<ProgramDutyAssignment>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgramDutyAssignment programDutyAssignment : list) {
					if ((dutyAssignmentId !=
							programDutyAssignment.getDutyAssignmentId()) ||
						!status.equals(programDutyAssignment.getStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_PROGRAMDUTYASSIGNMENT_WHERE);

			sb.append(
				_FINDER_COLUMN_DUTYASSIGNMENTIDANDSTATUS_DUTYASSIGNMENTID_2);

			boolean bindStatus = false;

			if (status.isEmpty()) {
				sb.append(_FINDER_COLUMN_DUTYASSIGNMENTIDANDSTATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				sb.append(_FINDER_COLUMN_DUTYASSIGNMENTIDANDSTATUS_STATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProgramDutyAssignmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dutyAssignmentId);

				if (bindStatus) {
					queryPos.add(status);
				}

				list = (List<ProgramDutyAssignment>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first program duty assignment in the ordered set where dutyAssignmentId = &#63; and status = &#63;.
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a matching program duty assignment could not be found
	 */
	@Override
	public ProgramDutyAssignment findByDutyAssignmentIdAndStatus_First(
			long dutyAssignmentId, String status,
			OrderByComparator<ProgramDutyAssignment> orderByComparator)
		throws NoSuchProgramDutyAssignmentException {

		ProgramDutyAssignment programDutyAssignment =
			fetchByDutyAssignmentIdAndStatus_First(
				dutyAssignmentId, status, orderByComparator);

		if (programDutyAssignment != null) {
			return programDutyAssignment;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dutyAssignmentId=");
		sb.append(dutyAssignmentId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchProgramDutyAssignmentException(sb.toString());
	}

	/**
	 * Returns the first program duty assignment in the ordered set where dutyAssignmentId = &#63; and status = &#63;.
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	@Override
	public ProgramDutyAssignment fetchByDutyAssignmentIdAndStatus_First(
		long dutyAssignmentId, String status,
		OrderByComparator<ProgramDutyAssignment> orderByComparator) {

		List<ProgramDutyAssignment> list = findByDutyAssignmentIdAndStatus(
			dutyAssignmentId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last program duty assignment in the ordered set where dutyAssignmentId = &#63; and status = &#63;.
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a matching program duty assignment could not be found
	 */
	@Override
	public ProgramDutyAssignment findByDutyAssignmentIdAndStatus_Last(
			long dutyAssignmentId, String status,
			OrderByComparator<ProgramDutyAssignment> orderByComparator)
		throws NoSuchProgramDutyAssignmentException {

		ProgramDutyAssignment programDutyAssignment =
			fetchByDutyAssignmentIdAndStatus_Last(
				dutyAssignmentId, status, orderByComparator);

		if (programDutyAssignment != null) {
			return programDutyAssignment;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("dutyAssignmentId=");
		sb.append(dutyAssignmentId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchProgramDutyAssignmentException(sb.toString());
	}

	/**
	 * Returns the last program duty assignment in the ordered set where dutyAssignmentId = &#63; and status = &#63;.
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	@Override
	public ProgramDutyAssignment fetchByDutyAssignmentIdAndStatus_Last(
		long dutyAssignmentId, String status,
		OrderByComparator<ProgramDutyAssignment> orderByComparator) {

		int count = countByDutyAssignmentIdAndStatus(dutyAssignmentId, status);

		if (count == 0) {
			return null;
		}

		List<ProgramDutyAssignment> list = findByDutyAssignmentIdAndStatus(
			dutyAssignmentId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the program duty assignments before and after the current program duty assignment in the ordered set where dutyAssignmentId = &#63; and status = &#63;.
	 *
	 * @param programDutyAssignmentId the primary key of the current program duty assignment
	 * @param dutyAssignmentId the duty assignment ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a program duty assignment with the primary key could not be found
	 */
	@Override
	public ProgramDutyAssignment[] findByDutyAssignmentIdAndStatus_PrevAndNext(
			long programDutyAssignmentId, long dutyAssignmentId, String status,
			OrderByComparator<ProgramDutyAssignment> orderByComparator)
		throws NoSuchProgramDutyAssignmentException {

		status = Objects.toString(status, "");

		ProgramDutyAssignment programDutyAssignment = findByPrimaryKey(
			programDutyAssignmentId);

		Session session = null;

		try {
			session = openSession();

			ProgramDutyAssignment[] array = new ProgramDutyAssignmentImpl[3];

			array[0] = getByDutyAssignmentIdAndStatus_PrevAndNext(
				session, programDutyAssignment, dutyAssignmentId, status,
				orderByComparator, true);

			array[1] = programDutyAssignment;

			array[2] = getByDutyAssignmentIdAndStatus_PrevAndNext(
				session, programDutyAssignment, dutyAssignmentId, status,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProgramDutyAssignment getByDutyAssignmentIdAndStatus_PrevAndNext(
		Session session, ProgramDutyAssignment programDutyAssignment,
		long dutyAssignmentId, String status,
		OrderByComparator<ProgramDutyAssignment> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_PROGRAMDUTYASSIGNMENT_WHERE);

		sb.append(_FINDER_COLUMN_DUTYASSIGNMENTIDANDSTATUS_DUTYASSIGNMENTID_2);

		boolean bindStatus = false;

		if (status.isEmpty()) {
			sb.append(_FINDER_COLUMN_DUTYASSIGNMENTIDANDSTATUS_STATUS_3);
		}
		else {
			bindStatus = true;

			sb.append(_FINDER_COLUMN_DUTYASSIGNMENTIDANDSTATUS_STATUS_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ProgramDutyAssignmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(dutyAssignmentId);

		if (bindStatus) {
			queryPos.add(status);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						programDutyAssignment)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgramDutyAssignment> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the program duty assignments where dutyAssignmentId = &#63; and status = &#63; from the database.
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param status the status
	 */
	@Override
	public void removeByDutyAssignmentIdAndStatus(
		long dutyAssignmentId, String status) {

		for (ProgramDutyAssignment programDutyAssignment :
				findByDutyAssignmentIdAndStatus(
					dutyAssignmentId, status, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(programDutyAssignment);
		}
	}

	/**
	 * Returns the number of program duty assignments where dutyAssignmentId = &#63; and status = &#63;.
	 *
	 * @param dutyAssignmentId the duty assignment ID
	 * @param status the status
	 * @return the number of matching program duty assignments
	 */
	@Override
	public int countByDutyAssignmentIdAndStatus(
		long dutyAssignmentId, String status) {

		status = Objects.toString(status, "");

		FinderPath finderPath = _finderPathCountByDutyAssignmentIdAndStatus;

		Object[] finderArgs = new Object[] {dutyAssignmentId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROGRAMDUTYASSIGNMENT_WHERE);

			sb.append(
				_FINDER_COLUMN_DUTYASSIGNMENTIDANDSTATUS_DUTYASSIGNMENTID_2);

			boolean bindStatus = false;

			if (status.isEmpty()) {
				sb.append(_FINDER_COLUMN_DUTYASSIGNMENTIDANDSTATUS_STATUS_3);
			}
			else {
				bindStatus = true;

				sb.append(_FINDER_COLUMN_DUTYASSIGNMENTIDANDSTATUS_STATUS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(dutyAssignmentId);

				if (bindStatus) {
					queryPos.add(status);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_DUTYASSIGNMENTIDANDSTATUS_DUTYASSIGNMENTID_2 =
			"programDutyAssignment.dutyAssignmentId = ? AND ";

	private static final String
		_FINDER_COLUMN_DUTYASSIGNMENTIDANDSTATUS_STATUS_2 =
			"programDutyAssignment.status = ?";

	private static final String
		_FINDER_COLUMN_DUTYASSIGNMENTIDANDSTATUS_STATUS_3 =
			"(programDutyAssignment.status IS NULL OR programDutyAssignment.status = '')";

	private FinderPath _finderPathWithPaginationFindByProgramId;
	private FinderPath _finderPathWithoutPaginationFindByProgramId;
	private FinderPath _finderPathCountByProgramId;

	/**
	 * Returns all the program duty assignments where programId = &#63;.
	 *
	 * @param programId the program ID
	 * @return the matching program duty assignments
	 */
	@Override
	public List<ProgramDutyAssignment> findByProgramId(long programId) {
		return findByProgramId(
			programId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the program duty assignments where programId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param programId the program ID
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @return the range of matching program duty assignments
	 */
	@Override
	public List<ProgramDutyAssignment> findByProgramId(
		long programId, int start, int end) {

		return findByProgramId(programId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the program duty assignments where programId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param programId the program ID
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program duty assignments
	 */
	@Override
	public List<ProgramDutyAssignment> findByProgramId(
		long programId, int start, int end,
		OrderByComparator<ProgramDutyAssignment> orderByComparator) {

		return findByProgramId(programId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the program duty assignments where programId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param programId the program ID
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program duty assignments
	 */
	@Override
	public List<ProgramDutyAssignment> findByProgramId(
		long programId, int start, int end,
		OrderByComparator<ProgramDutyAssignment> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByProgramId;
				finderArgs = new Object[] {programId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByProgramId;
			finderArgs = new Object[] {
				programId, start, end, orderByComparator
			};
		}

		List<ProgramDutyAssignment> list = null;

		if (useFinderCache) {
			list = (List<ProgramDutyAssignment>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgramDutyAssignment programDutyAssignment : list) {
					if (programId != programDutyAssignment.getProgramId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_PROGRAMDUTYASSIGNMENT_WHERE);

			sb.append(_FINDER_COLUMN_PROGRAMID_PROGRAMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProgramDutyAssignmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programId);

				list = (List<ProgramDutyAssignment>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first program duty assignment in the ordered set where programId = &#63;.
	 *
	 * @param programId the program ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a matching program duty assignment could not be found
	 */
	@Override
	public ProgramDutyAssignment findByProgramId_First(
			long programId,
			OrderByComparator<ProgramDutyAssignment> orderByComparator)
		throws NoSuchProgramDutyAssignmentException {

		ProgramDutyAssignment programDutyAssignment = fetchByProgramId_First(
			programId, orderByComparator);

		if (programDutyAssignment != null) {
			return programDutyAssignment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("programId=");
		sb.append(programId);

		sb.append("}");

		throw new NoSuchProgramDutyAssignmentException(sb.toString());
	}

	/**
	 * Returns the first program duty assignment in the ordered set where programId = &#63;.
	 *
	 * @param programId the program ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	@Override
	public ProgramDutyAssignment fetchByProgramId_First(
		long programId,
		OrderByComparator<ProgramDutyAssignment> orderByComparator) {

		List<ProgramDutyAssignment> list = findByProgramId(
			programId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last program duty assignment in the ordered set where programId = &#63;.
	 *
	 * @param programId the program ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a matching program duty assignment could not be found
	 */
	@Override
	public ProgramDutyAssignment findByProgramId_Last(
			long programId,
			OrderByComparator<ProgramDutyAssignment> orderByComparator)
		throws NoSuchProgramDutyAssignmentException {

		ProgramDutyAssignment programDutyAssignment = fetchByProgramId_Last(
			programId, orderByComparator);

		if (programDutyAssignment != null) {
			return programDutyAssignment;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("programId=");
		sb.append(programId);

		sb.append("}");

		throw new NoSuchProgramDutyAssignmentException(sb.toString());
	}

	/**
	 * Returns the last program duty assignment in the ordered set where programId = &#63;.
	 *
	 * @param programId the program ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	@Override
	public ProgramDutyAssignment fetchByProgramId_Last(
		long programId,
		OrderByComparator<ProgramDutyAssignment> orderByComparator) {

		int count = countByProgramId(programId);

		if (count == 0) {
			return null;
		}

		List<ProgramDutyAssignment> list = findByProgramId(
			programId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the program duty assignments before and after the current program duty assignment in the ordered set where programId = &#63;.
	 *
	 * @param programDutyAssignmentId the primary key of the current program duty assignment
	 * @param programId the program ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a program duty assignment with the primary key could not be found
	 */
	@Override
	public ProgramDutyAssignment[] findByProgramId_PrevAndNext(
			long programDutyAssignmentId, long programId,
			OrderByComparator<ProgramDutyAssignment> orderByComparator)
		throws NoSuchProgramDutyAssignmentException {

		ProgramDutyAssignment programDutyAssignment = findByPrimaryKey(
			programDutyAssignmentId);

		Session session = null;

		try {
			session = openSession();

			ProgramDutyAssignment[] array = new ProgramDutyAssignmentImpl[3];

			array[0] = getByProgramId_PrevAndNext(
				session, programDutyAssignment, programId, orderByComparator,
				true);

			array[1] = programDutyAssignment;

			array[2] = getByProgramId_PrevAndNext(
				session, programDutyAssignment, programId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProgramDutyAssignment getByProgramId_PrevAndNext(
		Session session, ProgramDutyAssignment programDutyAssignment,
		long programId,
		OrderByComparator<ProgramDutyAssignment> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PROGRAMDUTYASSIGNMENT_WHERE);

		sb.append(_FINDER_COLUMN_PROGRAMID_PROGRAMID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ProgramDutyAssignmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(programId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						programDutyAssignment)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgramDutyAssignment> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the program duty assignments where programId = &#63; from the database.
	 *
	 * @param programId the program ID
	 */
	@Override
	public void removeByProgramId(long programId) {
		for (ProgramDutyAssignment programDutyAssignment :
				findByProgramId(
					programId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(programDutyAssignment);
		}
	}

	/**
	 * Returns the number of program duty assignments where programId = &#63;.
	 *
	 * @param programId the program ID
	 * @return the number of matching program duty assignments
	 */
	@Override
	public int countByProgramId(long programId) {
		FinderPath finderPath = _finderPathCountByProgramId;

		Object[] finderArgs = new Object[] {programId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROGRAMDUTYASSIGNMENT_WHERE);

			sb.append(_FINDER_COLUMN_PROGRAMID_PROGRAMID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PROGRAMID_PROGRAMID_2 =
		"programDutyAssignment.programId = ?";

	private FinderPath _finderPathWithPaginationFindByProgramIdAndCohortId;
	private FinderPath _finderPathWithoutPaginationFindByProgramIdAndCohortId;
	private FinderPath _finderPathCountByProgramIdAndCohortId;

	/**
	 * Returns all the program duty assignments where programId = &#63; and cohortId = &#63;.
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @return the matching program duty assignments
	 */
	@Override
	public List<ProgramDutyAssignment> findByProgramIdAndCohortId(
		long programId, long cohortId) {

		return findByProgramIdAndCohortId(
			programId, cohortId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the program duty assignments where programId = &#63; and cohortId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @return the range of matching program duty assignments
	 */
	@Override
	public List<ProgramDutyAssignment> findByProgramIdAndCohortId(
		long programId, long cohortId, int start, int end) {

		return findByProgramIdAndCohortId(
			programId, cohortId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the program duty assignments where programId = &#63; and cohortId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program duty assignments
	 */
	@Override
	public List<ProgramDutyAssignment> findByProgramIdAndCohortId(
		long programId, long cohortId, int start, int end,
		OrderByComparator<ProgramDutyAssignment> orderByComparator) {

		return findByProgramIdAndCohortId(
			programId, cohortId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the program duty assignments where programId = &#63; and cohortId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program duty assignments
	 */
	@Override
	public List<ProgramDutyAssignment> findByProgramIdAndCohortId(
		long programId, long cohortId, int start, int end,
		OrderByComparator<ProgramDutyAssignment> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByProgramIdAndCohortId;
				finderArgs = new Object[] {programId, cohortId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByProgramIdAndCohortId;
			finderArgs = new Object[] {
				programId, cohortId, start, end, orderByComparator
			};
		}

		List<ProgramDutyAssignment> list = null;

		if (useFinderCache) {
			list = (List<ProgramDutyAssignment>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgramDutyAssignment programDutyAssignment : list) {
					if ((programId != programDutyAssignment.getProgramId()) ||
						(cohortId != programDutyAssignment.getCohortId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_PROGRAMDUTYASSIGNMENT_WHERE);

			sb.append(_FINDER_COLUMN_PROGRAMIDANDCOHORTID_PROGRAMID_2);

			sb.append(_FINDER_COLUMN_PROGRAMIDANDCOHORTID_COHORTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProgramDutyAssignmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programId);

				queryPos.add(cohortId);

				list = (List<ProgramDutyAssignment>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first program duty assignment in the ordered set where programId = &#63; and cohortId = &#63;.
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a matching program duty assignment could not be found
	 */
	@Override
	public ProgramDutyAssignment findByProgramIdAndCohortId_First(
			long programId, long cohortId,
			OrderByComparator<ProgramDutyAssignment> orderByComparator)
		throws NoSuchProgramDutyAssignmentException {

		ProgramDutyAssignment programDutyAssignment =
			fetchByProgramIdAndCohortId_First(
				programId, cohortId, orderByComparator);

		if (programDutyAssignment != null) {
			return programDutyAssignment;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("programId=");
		sb.append(programId);

		sb.append(", cohortId=");
		sb.append(cohortId);

		sb.append("}");

		throw new NoSuchProgramDutyAssignmentException(sb.toString());
	}

	/**
	 * Returns the first program duty assignment in the ordered set where programId = &#63; and cohortId = &#63;.
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	@Override
	public ProgramDutyAssignment fetchByProgramIdAndCohortId_First(
		long programId, long cohortId,
		OrderByComparator<ProgramDutyAssignment> orderByComparator) {

		List<ProgramDutyAssignment> list = findByProgramIdAndCohortId(
			programId, cohortId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last program duty assignment in the ordered set where programId = &#63; and cohortId = &#63;.
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a matching program duty assignment could not be found
	 */
	@Override
	public ProgramDutyAssignment findByProgramIdAndCohortId_Last(
			long programId, long cohortId,
			OrderByComparator<ProgramDutyAssignment> orderByComparator)
		throws NoSuchProgramDutyAssignmentException {

		ProgramDutyAssignment programDutyAssignment =
			fetchByProgramIdAndCohortId_Last(
				programId, cohortId, orderByComparator);

		if (programDutyAssignment != null) {
			return programDutyAssignment;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("programId=");
		sb.append(programId);

		sb.append(", cohortId=");
		sb.append(cohortId);

		sb.append("}");

		throw new NoSuchProgramDutyAssignmentException(sb.toString());
	}

	/**
	 * Returns the last program duty assignment in the ordered set where programId = &#63; and cohortId = &#63;.
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	@Override
	public ProgramDutyAssignment fetchByProgramIdAndCohortId_Last(
		long programId, long cohortId,
		OrderByComparator<ProgramDutyAssignment> orderByComparator) {

		int count = countByProgramIdAndCohortId(programId, cohortId);

		if (count == 0) {
			return null;
		}

		List<ProgramDutyAssignment> list = findByProgramIdAndCohortId(
			programId, cohortId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the program duty assignments before and after the current program duty assignment in the ordered set where programId = &#63; and cohortId = &#63;.
	 *
	 * @param programDutyAssignmentId the primary key of the current program duty assignment
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a program duty assignment with the primary key could not be found
	 */
	@Override
	public ProgramDutyAssignment[] findByProgramIdAndCohortId_PrevAndNext(
			long programDutyAssignmentId, long programId, long cohortId,
			OrderByComparator<ProgramDutyAssignment> orderByComparator)
		throws NoSuchProgramDutyAssignmentException {

		ProgramDutyAssignment programDutyAssignment = findByPrimaryKey(
			programDutyAssignmentId);

		Session session = null;

		try {
			session = openSession();

			ProgramDutyAssignment[] array = new ProgramDutyAssignmentImpl[3];

			array[0] = getByProgramIdAndCohortId_PrevAndNext(
				session, programDutyAssignment, programId, cohortId,
				orderByComparator, true);

			array[1] = programDutyAssignment;

			array[2] = getByProgramIdAndCohortId_PrevAndNext(
				session, programDutyAssignment, programId, cohortId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProgramDutyAssignment getByProgramIdAndCohortId_PrevAndNext(
		Session session, ProgramDutyAssignment programDutyAssignment,
		long programId, long cohortId,
		OrderByComparator<ProgramDutyAssignment> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_PROGRAMDUTYASSIGNMENT_WHERE);

		sb.append(_FINDER_COLUMN_PROGRAMIDANDCOHORTID_PROGRAMID_2);

		sb.append(_FINDER_COLUMN_PROGRAMIDANDCOHORTID_COHORTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ProgramDutyAssignmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(programId);

		queryPos.add(cohortId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						programDutyAssignment)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgramDutyAssignment> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the program duty assignments where programId = &#63; and cohortId = &#63; from the database.
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 */
	@Override
	public void removeByProgramIdAndCohortId(long programId, long cohortId) {
		for (ProgramDutyAssignment programDutyAssignment :
				findByProgramIdAndCohortId(
					programId, cohortId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(programDutyAssignment);
		}
	}

	/**
	 * Returns the number of program duty assignments where programId = &#63; and cohortId = &#63;.
	 *
	 * @param programId the program ID
	 * @param cohortId the cohort ID
	 * @return the number of matching program duty assignments
	 */
	@Override
	public int countByProgramIdAndCohortId(long programId, long cohortId) {
		FinderPath finderPath = _finderPathCountByProgramIdAndCohortId;

		Object[] finderArgs = new Object[] {programId, cohortId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROGRAMDUTYASSIGNMENT_WHERE);

			sb.append(_FINDER_COLUMN_PROGRAMIDANDCOHORTID_PROGRAMID_2);

			sb.append(_FINDER_COLUMN_PROGRAMIDANDCOHORTID_COHORTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programId);

				queryPos.add(cohortId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_PROGRAMIDANDCOHORTID_PROGRAMID_2 =
			"programDutyAssignment.programId = ? AND ";

	private static final String _FINDER_COLUMN_PROGRAMIDANDCOHORTID_COHORTID_2 =
		"programDutyAssignment.cohortId = ?";

	private FinderPath _finderPathFetchByProgramIdDutyAssignmentIdCohortId;
	private FinderPath _finderPathCountByProgramIdDutyAssignmentIdCohortId;

	/**
	 * Returns the program duty assignment where programId = &#63; and dutyAssignmentId = &#63; and cohortId = &#63; or throws a <code>NoSuchProgramDutyAssignmentException</code> if it could not be found.
	 *
	 * @param programId the program ID
	 * @param dutyAssignmentId the duty assignment ID
	 * @param cohortId the cohort ID
	 * @return the matching program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a matching program duty assignment could not be found
	 */
	@Override
	public ProgramDutyAssignment findByProgramIdDutyAssignmentIdCohortId(
			long programId, long dutyAssignmentId, long cohortId)
		throws NoSuchProgramDutyAssignmentException {

		ProgramDutyAssignment programDutyAssignment =
			fetchByProgramIdDutyAssignmentIdCohortId(
				programId, dutyAssignmentId, cohortId);

		if (programDutyAssignment == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("programId=");
			sb.append(programId);

			sb.append(", dutyAssignmentId=");
			sb.append(dutyAssignmentId);

			sb.append(", cohortId=");
			sb.append(cohortId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchProgramDutyAssignmentException(sb.toString());
		}

		return programDutyAssignment;
	}

	/**
	 * Returns the program duty assignment where programId = &#63; and dutyAssignmentId = &#63; and cohortId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param programId the program ID
	 * @param dutyAssignmentId the duty assignment ID
	 * @param cohortId the cohort ID
	 * @return the matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	@Override
	public ProgramDutyAssignment fetchByProgramIdDutyAssignmentIdCohortId(
		long programId, long dutyAssignmentId, long cohortId) {

		return fetchByProgramIdDutyAssignmentIdCohortId(
			programId, dutyAssignmentId, cohortId, true);
	}

	/**
	 * Returns the program duty assignment where programId = &#63; and dutyAssignmentId = &#63; and cohortId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param programId the program ID
	 * @param dutyAssignmentId the duty assignment ID
	 * @param cohortId the cohort ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching program duty assignment, or <code>null</code> if a matching program duty assignment could not be found
	 */
	@Override
	public ProgramDutyAssignment fetchByProgramIdDutyAssignmentIdCohortId(
		long programId, long dutyAssignmentId, long cohortId,
		boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {programId, dutyAssignmentId, cohortId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByProgramIdDutyAssignmentIdCohortId, finderArgs,
				this);
		}

		if (result instanceof ProgramDutyAssignment) {
			ProgramDutyAssignment programDutyAssignment =
				(ProgramDutyAssignment)result;

			if ((programId != programDutyAssignment.getProgramId()) ||
				(dutyAssignmentId !=
					programDutyAssignment.getDutyAssignmentId()) ||
				(cohortId != programDutyAssignment.getCohortId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_PROGRAMDUTYASSIGNMENT_WHERE);

			sb.append(
				_FINDER_COLUMN_PROGRAMIDDUTYASSIGNMENTIDCOHORTID_PROGRAMID_2);

			sb.append(
				_FINDER_COLUMN_PROGRAMIDDUTYASSIGNMENTIDCOHORTID_DUTYASSIGNMENTID_2);

			sb.append(
				_FINDER_COLUMN_PROGRAMIDDUTYASSIGNMENTIDCOHORTID_COHORTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programId);

				queryPos.add(dutyAssignmentId);

				queryPos.add(cohortId);

				List<ProgramDutyAssignment> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByProgramIdDutyAssignmentIdCohortId,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									programId, dutyAssignmentId, cohortId
								};
							}

							_log.warn(
								"ProgramDutyAssignmentPersistenceImpl.fetchByProgramIdDutyAssignmentIdCohortId(long, long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ProgramDutyAssignment programDutyAssignment = list.get(0);

					result = programDutyAssignment;

					cacheResult(programDutyAssignment);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (ProgramDutyAssignment)result;
		}
	}

	/**
	 * Removes the program duty assignment where programId = &#63; and dutyAssignmentId = &#63; and cohortId = &#63; from the database.
	 *
	 * @param programId the program ID
	 * @param dutyAssignmentId the duty assignment ID
	 * @param cohortId the cohort ID
	 * @return the program duty assignment that was removed
	 */
	@Override
	public ProgramDutyAssignment removeByProgramIdDutyAssignmentIdCohortId(
			long programId, long dutyAssignmentId, long cohortId)
		throws NoSuchProgramDutyAssignmentException {

		ProgramDutyAssignment programDutyAssignment =
			findByProgramIdDutyAssignmentIdCohortId(
				programId, dutyAssignmentId, cohortId);

		return remove(programDutyAssignment);
	}

	/**
	 * Returns the number of program duty assignments where programId = &#63; and dutyAssignmentId = &#63; and cohortId = &#63;.
	 *
	 * @param programId the program ID
	 * @param dutyAssignmentId the duty assignment ID
	 * @param cohortId the cohort ID
	 * @return the number of matching program duty assignments
	 */
	@Override
	public int countByProgramIdDutyAssignmentIdCohortId(
		long programId, long dutyAssignmentId, long cohortId) {

		FinderPath finderPath =
			_finderPathCountByProgramIdDutyAssignmentIdCohortId;

		Object[] finderArgs = new Object[] {
			programId, dutyAssignmentId, cohortId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_PROGRAMDUTYASSIGNMENT_WHERE);

			sb.append(
				_FINDER_COLUMN_PROGRAMIDDUTYASSIGNMENTIDCOHORTID_PROGRAMID_2);

			sb.append(
				_FINDER_COLUMN_PROGRAMIDDUTYASSIGNMENTIDCOHORTID_DUTYASSIGNMENTID_2);

			sb.append(
				_FINDER_COLUMN_PROGRAMIDDUTYASSIGNMENTIDCOHORTID_COHORTID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programId);

				queryPos.add(dutyAssignmentId);

				queryPos.add(cohortId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_PROGRAMIDDUTYASSIGNMENTIDCOHORTID_PROGRAMID_2 =
			"programDutyAssignment.programId = ? AND ";

	private static final String
		_FINDER_COLUMN_PROGRAMIDDUTYASSIGNMENTIDCOHORTID_DUTYASSIGNMENTID_2 =
			"programDutyAssignment.dutyAssignmentId = ? AND ";

	private static final String
		_FINDER_COLUMN_PROGRAMIDDUTYASSIGNMENTIDCOHORTID_COHORTID_2 =
			"programDutyAssignment.cohortId = ?";

	public ProgramDutyAssignmentPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put(
			"programDutyAssignmentId", "program_duty_assignment_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("modifiedBy", "modified_by");
		dbColumnNames.put("programId", "program_id");
		dbColumnNames.put("dutyAssignmentId", "duty_assignment_id");
		dbColumnNames.put("cohortId", "cohort_id");

		setDBColumnNames(dbColumnNames);

		setModelClass(ProgramDutyAssignment.class);

		setModelImplClass(ProgramDutyAssignmentImpl.class);
		setModelPKClass(long.class);

		setTable(ProgramDutyAssignmentTable.INSTANCE);
	}

	/**
	 * Caches the program duty assignment in the entity cache if it is enabled.
	 *
	 * @param programDutyAssignment the program duty assignment
	 */
	@Override
	public void cacheResult(ProgramDutyAssignment programDutyAssignment) {
		entityCache.putResult(
			ProgramDutyAssignmentImpl.class,
			programDutyAssignment.getPrimaryKey(), programDutyAssignment);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				programDutyAssignment.getUuid(),
				programDutyAssignment.getGroupId()
			},
			programDutyAssignment);

		finderCache.putResult(
			_finderPathFetchByProgramIdDutyAssignmentIdCohortId,
			new Object[] {
				programDutyAssignment.getProgramId(),
				programDutyAssignment.getDutyAssignmentId(),
				programDutyAssignment.getCohortId()
			},
			programDutyAssignment);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the program duty assignments in the entity cache if it is enabled.
	 *
	 * @param programDutyAssignments the program duty assignments
	 */
	@Override
	public void cacheResult(
		List<ProgramDutyAssignment> programDutyAssignments) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (programDutyAssignments.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ProgramDutyAssignment programDutyAssignment :
				programDutyAssignments) {

			if (entityCache.getResult(
					ProgramDutyAssignmentImpl.class,
					programDutyAssignment.getPrimaryKey()) == null) {

				cacheResult(programDutyAssignment);
			}
		}
	}

	/**
	 * Clears the cache for all program duty assignments.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProgramDutyAssignmentImpl.class);

		finderCache.clearCache(ProgramDutyAssignmentImpl.class);
	}

	/**
	 * Clears the cache for the program duty assignment.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProgramDutyAssignment programDutyAssignment) {
		entityCache.removeResult(
			ProgramDutyAssignmentImpl.class, programDutyAssignment);
	}

	@Override
	public void clearCache(List<ProgramDutyAssignment> programDutyAssignments) {
		for (ProgramDutyAssignment programDutyAssignment :
				programDutyAssignments) {

			entityCache.removeResult(
				ProgramDutyAssignmentImpl.class, programDutyAssignment);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ProgramDutyAssignmentImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				ProgramDutyAssignmentImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ProgramDutyAssignmentModelImpl programDutyAssignmentModelImpl) {

		Object[] args = new Object[] {
			programDutyAssignmentModelImpl.getUuid(),
			programDutyAssignmentModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, programDutyAssignmentModelImpl);

		args = new Object[] {
			programDutyAssignmentModelImpl.getProgramId(),
			programDutyAssignmentModelImpl.getDutyAssignmentId(),
			programDutyAssignmentModelImpl.getCohortId()
		};

		finderCache.putResult(
			_finderPathCountByProgramIdDutyAssignmentIdCohortId, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByProgramIdDutyAssignmentIdCohortId, args,
			programDutyAssignmentModelImpl);
	}

	/**
	 * Creates a new program duty assignment with the primary key. Does not add the program duty assignment to the database.
	 *
	 * @param programDutyAssignmentId the primary key for the new program duty assignment
	 * @return the new program duty assignment
	 */
	@Override
	public ProgramDutyAssignment create(long programDutyAssignmentId) {
		ProgramDutyAssignment programDutyAssignment =
			new ProgramDutyAssignmentImpl();

		programDutyAssignment.setNew(true);
		programDutyAssignment.setPrimaryKey(programDutyAssignmentId);

		String uuid = _portalUUID.generate();

		programDutyAssignment.setUuid(uuid);

		programDutyAssignment.setCompanyId(CompanyThreadLocal.getCompanyId());

		return programDutyAssignment;
	}

	/**
	 * Removes the program duty assignment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param programDutyAssignmentId the primary key of the program duty assignment
	 * @return the program duty assignment that was removed
	 * @throws NoSuchProgramDutyAssignmentException if a program duty assignment with the primary key could not be found
	 */
	@Override
	public ProgramDutyAssignment remove(long programDutyAssignmentId)
		throws NoSuchProgramDutyAssignmentException {

		return remove((Serializable)programDutyAssignmentId);
	}

	/**
	 * Removes the program duty assignment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the program duty assignment
	 * @return the program duty assignment that was removed
	 * @throws NoSuchProgramDutyAssignmentException if a program duty assignment with the primary key could not be found
	 */
	@Override
	public ProgramDutyAssignment remove(Serializable primaryKey)
		throws NoSuchProgramDutyAssignmentException {

		Session session = null;

		try {
			session = openSession();

			ProgramDutyAssignment programDutyAssignment =
				(ProgramDutyAssignment)session.get(
					ProgramDutyAssignmentImpl.class, primaryKey);

			if (programDutyAssignment == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProgramDutyAssignmentException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(programDutyAssignment);
		}
		catch (NoSuchProgramDutyAssignmentException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected ProgramDutyAssignment removeImpl(
		ProgramDutyAssignment programDutyAssignment) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(programDutyAssignment)) {
				programDutyAssignment = (ProgramDutyAssignment)session.get(
					ProgramDutyAssignmentImpl.class,
					programDutyAssignment.getPrimaryKeyObj());
			}

			if (programDutyAssignment != null) {
				session.delete(programDutyAssignment);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (programDutyAssignment != null) {
			clearCache(programDutyAssignment);
		}

		return programDutyAssignment;
	}

	@Override
	public ProgramDutyAssignment updateImpl(
		ProgramDutyAssignment programDutyAssignment) {

		boolean isNew = programDutyAssignment.isNew();

		if (!(programDutyAssignment instanceof
				ProgramDutyAssignmentModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(programDutyAssignment.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					programDutyAssignment);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in programDutyAssignment proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProgramDutyAssignment implementation " +
					programDutyAssignment.getClass());
		}

		ProgramDutyAssignmentModelImpl programDutyAssignmentModelImpl =
			(ProgramDutyAssignmentModelImpl)programDutyAssignment;

		if (Validator.isNull(programDutyAssignment.getUuid())) {
			String uuid = _portalUUID.generate();

			programDutyAssignment.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (programDutyAssignment.getCreateDate() == null)) {
			if (serviceContext == null) {
				programDutyAssignment.setCreateDate(date);
			}
			else {
				programDutyAssignment.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!programDutyAssignmentModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				programDutyAssignment.setModifiedDate(date);
			}
			else {
				programDutyAssignment.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(programDutyAssignment);
			}
			else {
				programDutyAssignment = (ProgramDutyAssignment)session.merge(
					programDutyAssignment);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProgramDutyAssignmentImpl.class, programDutyAssignmentModelImpl,
			false, true);

		cacheUniqueFindersCache(programDutyAssignmentModelImpl);

		if (isNew) {
			programDutyAssignment.setNew(false);
		}

		programDutyAssignment.resetOriginalValues();

		return programDutyAssignment;
	}

	/**
	 * Returns the program duty assignment with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the program duty assignment
	 * @return the program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a program duty assignment with the primary key could not be found
	 */
	@Override
	public ProgramDutyAssignment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProgramDutyAssignmentException {

		ProgramDutyAssignment programDutyAssignment = fetchByPrimaryKey(
			primaryKey);

		if (programDutyAssignment == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProgramDutyAssignmentException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return programDutyAssignment;
	}

	/**
	 * Returns the program duty assignment with the primary key or throws a <code>NoSuchProgramDutyAssignmentException</code> if it could not be found.
	 *
	 * @param programDutyAssignmentId the primary key of the program duty assignment
	 * @return the program duty assignment
	 * @throws NoSuchProgramDutyAssignmentException if a program duty assignment with the primary key could not be found
	 */
	@Override
	public ProgramDutyAssignment findByPrimaryKey(long programDutyAssignmentId)
		throws NoSuchProgramDutyAssignmentException {

		return findByPrimaryKey((Serializable)programDutyAssignmentId);
	}

	/**
	 * Returns the program duty assignment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param programDutyAssignmentId the primary key of the program duty assignment
	 * @return the program duty assignment, or <code>null</code> if a program duty assignment with the primary key could not be found
	 */
	@Override
	public ProgramDutyAssignment fetchByPrimaryKey(
		long programDutyAssignmentId) {

		return fetchByPrimaryKey((Serializable)programDutyAssignmentId);
	}

	/**
	 * Returns all the program duty assignments.
	 *
	 * @return the program duty assignments
	 */
	@Override
	public List<ProgramDutyAssignment> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the program duty assignments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @return the range of program duty assignments
	 */
	@Override
	public List<ProgramDutyAssignment> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the program duty assignments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of program duty assignments
	 */
	@Override
	public List<ProgramDutyAssignment> findAll(
		int start, int end,
		OrderByComparator<ProgramDutyAssignment> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the program duty assignments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDutyAssignmentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program duty assignments
	 * @param end the upper bound of the range of program duty assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of program duty assignments
	 */
	@Override
	public List<ProgramDutyAssignment> findAll(
		int start, int end,
		OrderByComparator<ProgramDutyAssignment> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<ProgramDutyAssignment> list = null;

		if (useFinderCache) {
			list = (List<ProgramDutyAssignment>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PROGRAMDUTYASSIGNMENT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PROGRAMDUTYASSIGNMENT;

				sql = sql.concat(ProgramDutyAssignmentModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ProgramDutyAssignment>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the program duty assignments from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProgramDutyAssignment programDutyAssignment : findAll()) {
			remove(programDutyAssignment);
		}
	}

	/**
	 * Returns the number of program duty assignments.
	 *
	 * @return the number of program duty assignments
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_PROGRAMDUTYASSIGNMENT);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "program_duty_assignment_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PROGRAMDUTYASSIGNMENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProgramDutyAssignmentModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the program duty assignment persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "group_id"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "group_id"}, false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "company_id"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "company_id"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "company_id"}, false);

		_finderPathWithPaginationFindByDutyAssignmentId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDutyAssignmentId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"duty_assignment_id"}, true);

		_finderPathWithoutPaginationFindByDutyAssignmentId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDutyAssignmentId",
			new String[] {Long.class.getName()},
			new String[] {"duty_assignment_id"}, true);

		_finderPathCountByDutyAssignmentId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDutyAssignmentId", new String[] {Long.class.getName()},
			new String[] {"duty_assignment_id"}, false);

		_finderPathWithPaginationFindByDutyAssignmentIdAndStatus =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByDutyAssignmentIdAndStatus",
				new String[] {
					Long.class.getName(), String.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				},
				new String[] {"duty_assignment_id", "status"}, true);

		_finderPathWithoutPaginationFindByDutyAssignmentIdAndStatus =
			new FinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByDutyAssignmentIdAndStatus",
				new String[] {Long.class.getName(), String.class.getName()},
				new String[] {"duty_assignment_id", "status"}, true);

		_finderPathCountByDutyAssignmentIdAndStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByDutyAssignmentIdAndStatus",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"duty_assignment_id", "status"}, false);

		_finderPathWithPaginationFindByProgramId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProgramId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"program_id"}, true);

		_finderPathWithoutPaginationFindByProgramId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProgramId",
			new String[] {Long.class.getName()}, new String[] {"program_id"},
			true);

		_finderPathCountByProgramId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProgramId",
			new String[] {Long.class.getName()}, new String[] {"program_id"},
			false);

		_finderPathWithPaginationFindByProgramIdAndCohortId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByProgramIdAndCohortId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"program_id", "cohort_id"}, true);

		_finderPathWithoutPaginationFindByProgramIdAndCohortId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByProgramIdAndCohortId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"program_id", "cohort_id"}, true);

		_finderPathCountByProgramIdAndCohortId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProgramIdAndCohortId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"program_id", "cohort_id"}, false);

		_finderPathFetchByProgramIdDutyAssignmentIdCohortId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY,
			"fetchByProgramIdDutyAssignmentIdCohortId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			new String[] {"program_id", "duty_assignment_id", "cohort_id"},
			true);

		_finderPathCountByProgramIdDutyAssignmentIdCohortId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProgramIdDutyAssignmentIdCohortId",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			new String[] {"program_id", "duty_assignment_id", "cohort_id"},
			false);

		_setProgramDutyAssignmentUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setProgramDutyAssignmentUtilPersistence(null);

		entityCache.removeCache(ProgramDutyAssignmentImpl.class.getName());
	}

	private void _setProgramDutyAssignmentUtilPersistence(
		ProgramDutyAssignmentPersistence programDutyAssignmentPersistence) {

		try {
			Field field = ProgramDutyAssignmentUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, programDutyAssignmentPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = OMSBTMSPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = OMSBTMSPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = OMSBTMSPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_PROGRAMDUTYASSIGNMENT =
		"SELECT programDutyAssignment FROM ProgramDutyAssignment programDutyAssignment";

	private static final String _SQL_SELECT_PROGRAMDUTYASSIGNMENT_WHERE =
		"SELECT programDutyAssignment FROM ProgramDutyAssignment programDutyAssignment WHERE ";

	private static final String _SQL_COUNT_PROGRAMDUTYASSIGNMENT =
		"SELECT COUNT(programDutyAssignment) FROM ProgramDutyAssignment programDutyAssignment";

	private static final String _SQL_COUNT_PROGRAMDUTYASSIGNMENT_WHERE =
		"SELECT COUNT(programDutyAssignment) FROM ProgramDutyAssignment programDutyAssignment WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"programDutyAssignment.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProgramDutyAssignment exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ProgramDutyAssignment exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProgramDutyAssignmentPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "programDutyAssignmentId", "groupId", "companyId",
			"createDate", "createdBy", "modifiedDate", "modifiedBy",
			"programId", "dutyAssignmentId", "cohortId"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}