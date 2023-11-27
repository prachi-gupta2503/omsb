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

import gov.omsb.tms.exception.NoSuchProgramEligibilityDegreeRelException;
import gov.omsb.tms.model.ProgramEligibilityDegreeRel;
import gov.omsb.tms.model.ProgramEligibilityDegreeRelTable;
import gov.omsb.tms.model.impl.ProgramEligibilityDegreeRelImpl;
import gov.omsb.tms.model.impl.ProgramEligibilityDegreeRelModelImpl;
import gov.omsb.tms.service.persistence.ProgramEligibilityDegreeRelPersistence;
import gov.omsb.tms.service.persistence.ProgramEligibilityDegreeRelUtil;
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
 * The persistence implementation for the program eligibility degree rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ProgramEligibilityDegreeRelPersistence.class)
public class ProgramEligibilityDegreeRelPersistenceImpl
	extends BasePersistenceImpl<ProgramEligibilityDegreeRel>
	implements ProgramEligibilityDegreeRelPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProgramEligibilityDegreeRelUtil</code> to access the program eligibility degree rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProgramEligibilityDegreeRelImpl.class.getName();

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
	 * Returns all the program eligibility degree rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching program eligibility degree rels
	 */
	@Override
	public List<ProgramEligibilityDegreeRel> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the program eligibility degree rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramEligibilityDegreeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program eligibility degree rels
	 * @param end the upper bound of the range of program eligibility degree rels (not inclusive)
	 * @return the range of matching program eligibility degree rels
	 */
	@Override
	public List<ProgramEligibilityDegreeRel> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the program eligibility degree rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramEligibilityDegreeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program eligibility degree rels
	 * @param end the upper bound of the range of program eligibility degree rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program eligibility degree rels
	 */
	@Override
	public List<ProgramEligibilityDegreeRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgramEligibilityDegreeRel> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the program eligibility degree rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramEligibilityDegreeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program eligibility degree rels
	 * @param end the upper bound of the range of program eligibility degree rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program eligibility degree rels
	 */
	@Override
	public List<ProgramEligibilityDegreeRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgramEligibilityDegreeRel> orderByComparator,
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

		List<ProgramEligibilityDegreeRel> list = null;

		if (useFinderCache) {
			list = (List<ProgramEligibilityDegreeRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgramEligibilityDegreeRel programEligibilityDegreeRel :
						list) {

					if (!uuid.equals(programEligibilityDegreeRel.getUuid())) {
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

			sb.append(_SQL_SELECT_PROGRAMELIGIBILITYDEGREEREL_WHERE);

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
				sb.append(ProgramEligibilityDegreeRelModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProgramEligibilityDegreeRel>)QueryUtil.list(
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
	 * Returns the first program eligibility degree rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program eligibility degree rel
	 * @throws NoSuchProgramEligibilityDegreeRelException if a matching program eligibility degree rel could not be found
	 */
	@Override
	public ProgramEligibilityDegreeRel findByUuid_First(
			String uuid,
			OrderByComparator<ProgramEligibilityDegreeRel> orderByComparator)
		throws NoSuchProgramEligibilityDegreeRelException {

		ProgramEligibilityDegreeRel programEligibilityDegreeRel =
			fetchByUuid_First(uuid, orderByComparator);

		if (programEligibilityDegreeRel != null) {
			return programEligibilityDegreeRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProgramEligibilityDegreeRelException(sb.toString());
	}

	/**
	 * Returns the first program eligibility degree rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program eligibility degree rel, or <code>null</code> if a matching program eligibility degree rel could not be found
	 */
	@Override
	public ProgramEligibilityDegreeRel fetchByUuid_First(
		String uuid,
		OrderByComparator<ProgramEligibilityDegreeRel> orderByComparator) {

		List<ProgramEligibilityDegreeRel> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last program eligibility degree rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program eligibility degree rel
	 * @throws NoSuchProgramEligibilityDegreeRelException if a matching program eligibility degree rel could not be found
	 */
	@Override
	public ProgramEligibilityDegreeRel findByUuid_Last(
			String uuid,
			OrderByComparator<ProgramEligibilityDegreeRel> orderByComparator)
		throws NoSuchProgramEligibilityDegreeRelException {

		ProgramEligibilityDegreeRel programEligibilityDegreeRel =
			fetchByUuid_Last(uuid, orderByComparator);

		if (programEligibilityDegreeRel != null) {
			return programEligibilityDegreeRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProgramEligibilityDegreeRelException(sb.toString());
	}

	/**
	 * Returns the last program eligibility degree rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program eligibility degree rel, or <code>null</code> if a matching program eligibility degree rel could not be found
	 */
	@Override
	public ProgramEligibilityDegreeRel fetchByUuid_Last(
		String uuid,
		OrderByComparator<ProgramEligibilityDegreeRel> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ProgramEligibilityDegreeRel> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the program eligibility degree rels before and after the current program eligibility degree rel in the ordered set where uuid = &#63;.
	 *
	 * @param programEdId the primary key of the current program eligibility degree rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program eligibility degree rel
	 * @throws NoSuchProgramEligibilityDegreeRelException if a program eligibility degree rel with the primary key could not be found
	 */
	@Override
	public ProgramEligibilityDegreeRel[] findByUuid_PrevAndNext(
			long programEdId, String uuid,
			OrderByComparator<ProgramEligibilityDegreeRel> orderByComparator)
		throws NoSuchProgramEligibilityDegreeRelException {

		uuid = Objects.toString(uuid, "");

		ProgramEligibilityDegreeRel programEligibilityDegreeRel =
			findByPrimaryKey(programEdId);

		Session session = null;

		try {
			session = openSession();

			ProgramEligibilityDegreeRel[] array =
				new ProgramEligibilityDegreeRelImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, programEligibilityDegreeRel, uuid, orderByComparator,
				true);

			array[1] = programEligibilityDegreeRel;

			array[2] = getByUuid_PrevAndNext(
				session, programEligibilityDegreeRel, uuid, orderByComparator,
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

	protected ProgramEligibilityDegreeRel getByUuid_PrevAndNext(
		Session session,
		ProgramEligibilityDegreeRel programEligibilityDegreeRel, String uuid,
		OrderByComparator<ProgramEligibilityDegreeRel> orderByComparator,
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

		sb.append(_SQL_SELECT_PROGRAMELIGIBILITYDEGREEREL_WHERE);

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
			sb.append(ProgramEligibilityDegreeRelModelImpl.ORDER_BY_JPQL);
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
						programEligibilityDegreeRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgramEligibilityDegreeRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the program eligibility degree rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ProgramEligibilityDegreeRel programEligibilityDegreeRel :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(programEligibilityDegreeRel);
		}
	}

	/**
	 * Returns the number of program eligibility degree rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching program eligibility degree rels
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROGRAMELIGIBILITYDEGREEREL_WHERE);

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
		"programEligibilityDegreeRel.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(programEligibilityDegreeRel.uuid IS NULL OR programEligibilityDegreeRel.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the program eligibility degree rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProgramEligibilityDegreeRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching program eligibility degree rel
	 * @throws NoSuchProgramEligibilityDegreeRelException if a matching program eligibility degree rel could not be found
	 */
	@Override
	public ProgramEligibilityDegreeRel findByUUID_G(String uuid, long groupId)
		throws NoSuchProgramEligibilityDegreeRelException {

		ProgramEligibilityDegreeRel programEligibilityDegreeRel = fetchByUUID_G(
			uuid, groupId);

		if (programEligibilityDegreeRel == null) {
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

			throw new NoSuchProgramEligibilityDegreeRelException(sb.toString());
		}

		return programEligibilityDegreeRel;
	}

	/**
	 * Returns the program eligibility degree rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching program eligibility degree rel, or <code>null</code> if a matching program eligibility degree rel could not be found
	 */
	@Override
	public ProgramEligibilityDegreeRel fetchByUUID_G(
		String uuid, long groupId) {

		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the program eligibility degree rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching program eligibility degree rel, or <code>null</code> if a matching program eligibility degree rel could not be found
	 */
	@Override
	public ProgramEligibilityDegreeRel fetchByUUID_G(
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

		if (result instanceof ProgramEligibilityDegreeRel) {
			ProgramEligibilityDegreeRel programEligibilityDegreeRel =
				(ProgramEligibilityDegreeRel)result;

			if (!Objects.equals(uuid, programEligibilityDegreeRel.getUuid()) ||
				(groupId != programEligibilityDegreeRel.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PROGRAMELIGIBILITYDEGREEREL_WHERE);

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

				List<ProgramEligibilityDegreeRel> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ProgramEligibilityDegreeRel programEligibilityDegreeRel =
						list.get(0);

					result = programEligibilityDegreeRel;

					cacheResult(programEligibilityDegreeRel);
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
			return (ProgramEligibilityDegreeRel)result;
		}
	}

	/**
	 * Removes the program eligibility degree rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the program eligibility degree rel that was removed
	 */
	@Override
	public ProgramEligibilityDegreeRel removeByUUID_G(String uuid, long groupId)
		throws NoSuchProgramEligibilityDegreeRelException {

		ProgramEligibilityDegreeRel programEligibilityDegreeRel = findByUUID_G(
			uuid, groupId);

		return remove(programEligibilityDegreeRel);
	}

	/**
	 * Returns the number of program eligibility degree rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching program eligibility degree rels
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROGRAMELIGIBILITYDEGREEREL_WHERE);

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
		"programEligibilityDegreeRel.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(programEligibilityDegreeRel.uuid IS NULL OR programEligibilityDegreeRel.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"programEligibilityDegreeRel.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the program eligibility degree rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching program eligibility degree rels
	 */
	@Override
	public List<ProgramEligibilityDegreeRel> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the program eligibility degree rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramEligibilityDegreeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program eligibility degree rels
	 * @param end the upper bound of the range of program eligibility degree rels (not inclusive)
	 * @return the range of matching program eligibility degree rels
	 */
	@Override
	public List<ProgramEligibilityDegreeRel> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the program eligibility degree rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramEligibilityDegreeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program eligibility degree rels
	 * @param end the upper bound of the range of program eligibility degree rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program eligibility degree rels
	 */
	@Override
	public List<ProgramEligibilityDegreeRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgramEligibilityDegreeRel> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the program eligibility degree rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramEligibilityDegreeRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program eligibility degree rels
	 * @param end the upper bound of the range of program eligibility degree rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program eligibility degree rels
	 */
	@Override
	public List<ProgramEligibilityDegreeRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgramEligibilityDegreeRel> orderByComparator,
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

		List<ProgramEligibilityDegreeRel> list = null;

		if (useFinderCache) {
			list = (List<ProgramEligibilityDegreeRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgramEligibilityDegreeRel programEligibilityDegreeRel :
						list) {

					if (!uuid.equals(programEligibilityDegreeRel.getUuid()) ||
						(companyId !=
							programEligibilityDegreeRel.getCompanyId())) {

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

			sb.append(_SQL_SELECT_PROGRAMELIGIBILITYDEGREEREL_WHERE);

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
				sb.append(ProgramEligibilityDegreeRelModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProgramEligibilityDegreeRel>)QueryUtil.list(
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
	 * Returns the first program eligibility degree rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program eligibility degree rel
	 * @throws NoSuchProgramEligibilityDegreeRelException if a matching program eligibility degree rel could not be found
	 */
	@Override
	public ProgramEligibilityDegreeRel findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProgramEligibilityDegreeRel> orderByComparator)
		throws NoSuchProgramEligibilityDegreeRelException {

		ProgramEligibilityDegreeRel programEligibilityDegreeRel =
			fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (programEligibilityDegreeRel != null) {
			return programEligibilityDegreeRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProgramEligibilityDegreeRelException(sb.toString());
	}

	/**
	 * Returns the first program eligibility degree rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program eligibility degree rel, or <code>null</code> if a matching program eligibility degree rel could not be found
	 */
	@Override
	public ProgramEligibilityDegreeRel fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProgramEligibilityDegreeRel> orderByComparator) {

		List<ProgramEligibilityDegreeRel> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last program eligibility degree rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program eligibility degree rel
	 * @throws NoSuchProgramEligibilityDegreeRelException if a matching program eligibility degree rel could not be found
	 */
	@Override
	public ProgramEligibilityDegreeRel findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProgramEligibilityDegreeRel> orderByComparator)
		throws NoSuchProgramEligibilityDegreeRelException {

		ProgramEligibilityDegreeRel programEligibilityDegreeRel =
			fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (programEligibilityDegreeRel != null) {
			return programEligibilityDegreeRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProgramEligibilityDegreeRelException(sb.toString());
	}

	/**
	 * Returns the last program eligibility degree rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program eligibility degree rel, or <code>null</code> if a matching program eligibility degree rel could not be found
	 */
	@Override
	public ProgramEligibilityDegreeRel fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProgramEligibilityDegreeRel> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ProgramEligibilityDegreeRel> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the program eligibility degree rels before and after the current program eligibility degree rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param programEdId the primary key of the current program eligibility degree rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program eligibility degree rel
	 * @throws NoSuchProgramEligibilityDegreeRelException if a program eligibility degree rel with the primary key could not be found
	 */
	@Override
	public ProgramEligibilityDegreeRel[] findByUuid_C_PrevAndNext(
			long programEdId, String uuid, long companyId,
			OrderByComparator<ProgramEligibilityDegreeRel> orderByComparator)
		throws NoSuchProgramEligibilityDegreeRelException {

		uuid = Objects.toString(uuid, "");

		ProgramEligibilityDegreeRel programEligibilityDegreeRel =
			findByPrimaryKey(programEdId);

		Session session = null;

		try {
			session = openSession();

			ProgramEligibilityDegreeRel[] array =
				new ProgramEligibilityDegreeRelImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, programEligibilityDegreeRel, uuid, companyId,
				orderByComparator, true);

			array[1] = programEligibilityDegreeRel;

			array[2] = getByUuid_C_PrevAndNext(
				session, programEligibilityDegreeRel, uuid, companyId,
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

	protected ProgramEligibilityDegreeRel getByUuid_C_PrevAndNext(
		Session session,
		ProgramEligibilityDegreeRel programEligibilityDegreeRel, String uuid,
		long companyId,
		OrderByComparator<ProgramEligibilityDegreeRel> orderByComparator,
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

		sb.append(_SQL_SELECT_PROGRAMELIGIBILITYDEGREEREL_WHERE);

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
			sb.append(ProgramEligibilityDegreeRelModelImpl.ORDER_BY_JPQL);
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
						programEligibilityDegreeRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgramEligibilityDegreeRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the program eligibility degree rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ProgramEligibilityDegreeRel programEligibilityDegreeRel :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(programEligibilityDegreeRel);
		}
	}

	/**
	 * Returns the number of program eligibility degree rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching program eligibility degree rels
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROGRAMELIGIBILITYDEGREEREL_WHERE);

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
		"programEligibilityDegreeRel.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(programEligibilityDegreeRel.uuid IS NULL OR programEligibilityDegreeRel.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"programEligibilityDegreeRel.companyId = ?";

	private FinderPath _finderPathFetchByProgramEligibilityDegreeId;
	private FinderPath _finderPathCountByProgramEligibilityDegreeId;

	/**
	 * Returns the program eligibility degree rel where programId = &#63; and eligibilityDegreeMasterId = &#63; or throws a <code>NoSuchProgramEligibilityDegreeRelException</code> if it could not be found.
	 *
	 * @param programId the program ID
	 * @param eligibilityDegreeMasterId the eligibility degree master ID
	 * @return the matching program eligibility degree rel
	 * @throws NoSuchProgramEligibilityDegreeRelException if a matching program eligibility degree rel could not be found
	 */
	@Override
	public ProgramEligibilityDegreeRel findByProgramEligibilityDegreeId(
			long programId, long eligibilityDegreeMasterId)
		throws NoSuchProgramEligibilityDegreeRelException {

		ProgramEligibilityDegreeRel programEligibilityDegreeRel =
			fetchByProgramEligibilityDegreeId(
				programId, eligibilityDegreeMasterId);

		if (programEligibilityDegreeRel == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("programId=");
			sb.append(programId);

			sb.append(", eligibilityDegreeMasterId=");
			sb.append(eligibilityDegreeMasterId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchProgramEligibilityDegreeRelException(sb.toString());
		}

		return programEligibilityDegreeRel;
	}

	/**
	 * Returns the program eligibility degree rel where programId = &#63; and eligibilityDegreeMasterId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param programId the program ID
	 * @param eligibilityDegreeMasterId the eligibility degree master ID
	 * @return the matching program eligibility degree rel, or <code>null</code> if a matching program eligibility degree rel could not be found
	 */
	@Override
	public ProgramEligibilityDegreeRel fetchByProgramEligibilityDegreeId(
		long programId, long eligibilityDegreeMasterId) {

		return fetchByProgramEligibilityDegreeId(
			programId, eligibilityDegreeMasterId, true);
	}

	/**
	 * Returns the program eligibility degree rel where programId = &#63; and eligibilityDegreeMasterId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param programId the program ID
	 * @param eligibilityDegreeMasterId the eligibility degree master ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching program eligibility degree rel, or <code>null</code> if a matching program eligibility degree rel could not be found
	 */
	@Override
	public ProgramEligibilityDegreeRel fetchByProgramEligibilityDegreeId(
		long programId, long eligibilityDegreeMasterId,
		boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {programId, eligibilityDegreeMasterId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByProgramEligibilityDegreeId, finderArgs, this);
		}

		if (result instanceof ProgramEligibilityDegreeRel) {
			ProgramEligibilityDegreeRel programEligibilityDegreeRel =
				(ProgramEligibilityDegreeRel)result;

			if ((programId != programEligibilityDegreeRel.getProgramId()) ||
				(eligibilityDegreeMasterId !=
					programEligibilityDegreeRel.
						getEligibilityDegreeMasterId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PROGRAMELIGIBILITYDEGREEREL_WHERE);

			sb.append(_FINDER_COLUMN_PROGRAMELIGIBILITYDEGREEID_PROGRAMID_2);

			sb.append(
				_FINDER_COLUMN_PROGRAMELIGIBILITYDEGREEID_ELIGIBILITYDEGREEMASTERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programId);

				queryPos.add(eligibilityDegreeMasterId);

				List<ProgramEligibilityDegreeRel> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByProgramEligibilityDegreeId,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									programId, eligibilityDegreeMasterId
								};
							}

							_log.warn(
								"ProgramEligibilityDegreeRelPersistenceImpl.fetchByProgramEligibilityDegreeId(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ProgramEligibilityDegreeRel programEligibilityDegreeRel =
						list.get(0);

					result = programEligibilityDegreeRel;

					cacheResult(programEligibilityDegreeRel);
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
			return (ProgramEligibilityDegreeRel)result;
		}
	}

	/**
	 * Removes the program eligibility degree rel where programId = &#63; and eligibilityDegreeMasterId = &#63; from the database.
	 *
	 * @param programId the program ID
	 * @param eligibilityDegreeMasterId the eligibility degree master ID
	 * @return the program eligibility degree rel that was removed
	 */
	@Override
	public ProgramEligibilityDegreeRel removeByProgramEligibilityDegreeId(
			long programId, long eligibilityDegreeMasterId)
		throws NoSuchProgramEligibilityDegreeRelException {

		ProgramEligibilityDegreeRel programEligibilityDegreeRel =
			findByProgramEligibilityDegreeId(
				programId, eligibilityDegreeMasterId);

		return remove(programEligibilityDegreeRel);
	}

	/**
	 * Returns the number of program eligibility degree rels where programId = &#63; and eligibilityDegreeMasterId = &#63;.
	 *
	 * @param programId the program ID
	 * @param eligibilityDegreeMasterId the eligibility degree master ID
	 * @return the number of matching program eligibility degree rels
	 */
	@Override
	public int countByProgramEligibilityDegreeId(
		long programId, long eligibilityDegreeMasterId) {

		FinderPath finderPath = _finderPathCountByProgramEligibilityDegreeId;

		Object[] finderArgs = new Object[] {
			programId, eligibilityDegreeMasterId
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROGRAMELIGIBILITYDEGREEREL_WHERE);

			sb.append(_FINDER_COLUMN_PROGRAMELIGIBILITYDEGREEID_PROGRAMID_2);

			sb.append(
				_FINDER_COLUMN_PROGRAMELIGIBILITYDEGREEID_ELIGIBILITYDEGREEMASTERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programId);

				queryPos.add(eligibilityDegreeMasterId);

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
		_FINDER_COLUMN_PROGRAMELIGIBILITYDEGREEID_PROGRAMID_2 =
			"programEligibilityDegreeRel.programId = ? AND ";

	private static final String
		_FINDER_COLUMN_PROGRAMELIGIBILITYDEGREEID_ELIGIBILITYDEGREEMASTERID_2 =
			"programEligibilityDegreeRel.eligibilityDegreeMasterId = ?";

	private FinderPath _finderPathFetchByProgramId;
	private FinderPath _finderPathCountByProgramId;

	/**
	 * Returns the program eligibility degree rel where programId = &#63; or throws a <code>NoSuchProgramEligibilityDegreeRelException</code> if it could not be found.
	 *
	 * @param programId the program ID
	 * @return the matching program eligibility degree rel
	 * @throws NoSuchProgramEligibilityDegreeRelException if a matching program eligibility degree rel could not be found
	 */
	@Override
	public ProgramEligibilityDegreeRel findByProgramId(long programId)
		throws NoSuchProgramEligibilityDegreeRelException {

		ProgramEligibilityDegreeRel programEligibilityDegreeRel =
			fetchByProgramId(programId);

		if (programEligibilityDegreeRel == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("programId=");
			sb.append(programId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchProgramEligibilityDegreeRelException(sb.toString());
		}

		return programEligibilityDegreeRel;
	}

	/**
	 * Returns the program eligibility degree rel where programId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param programId the program ID
	 * @return the matching program eligibility degree rel, or <code>null</code> if a matching program eligibility degree rel could not be found
	 */
	@Override
	public ProgramEligibilityDegreeRel fetchByProgramId(long programId) {
		return fetchByProgramId(programId, true);
	}

	/**
	 * Returns the program eligibility degree rel where programId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param programId the program ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching program eligibility degree rel, or <code>null</code> if a matching program eligibility degree rel could not be found
	 */
	@Override
	public ProgramEligibilityDegreeRel fetchByProgramId(
		long programId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {programId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByProgramId, finderArgs, this);
		}

		if (result instanceof ProgramEligibilityDegreeRel) {
			ProgramEligibilityDegreeRel programEligibilityDegreeRel =
				(ProgramEligibilityDegreeRel)result;

			if (programId != programEligibilityDegreeRel.getProgramId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_PROGRAMELIGIBILITYDEGREEREL_WHERE);

			sb.append(_FINDER_COLUMN_PROGRAMID_PROGRAMID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programId);

				List<ProgramEligibilityDegreeRel> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByProgramId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {programId};
							}

							_log.warn(
								"ProgramEligibilityDegreeRelPersistenceImpl.fetchByProgramId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ProgramEligibilityDegreeRel programEligibilityDegreeRel =
						list.get(0);

					result = programEligibilityDegreeRel;

					cacheResult(programEligibilityDegreeRel);
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
			return (ProgramEligibilityDegreeRel)result;
		}
	}

	/**
	 * Removes the program eligibility degree rel where programId = &#63; from the database.
	 *
	 * @param programId the program ID
	 * @return the program eligibility degree rel that was removed
	 */
	@Override
	public ProgramEligibilityDegreeRel removeByProgramId(long programId)
		throws NoSuchProgramEligibilityDegreeRelException {

		ProgramEligibilityDegreeRel programEligibilityDegreeRel =
			findByProgramId(programId);

		return remove(programEligibilityDegreeRel);
	}

	/**
	 * Returns the number of program eligibility degree rels where programId = &#63;.
	 *
	 * @param programId the program ID
	 * @return the number of matching program eligibility degree rels
	 */
	@Override
	public int countByProgramId(long programId) {
		FinderPath finderPath = _finderPathCountByProgramId;

		Object[] finderArgs = new Object[] {programId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROGRAMELIGIBILITYDEGREEREL_WHERE);

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
		"programEligibilityDegreeRel.programId = ?";

	public ProgramEligibilityDegreeRelPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("programEdId", "program_ed_id");
		dbColumnNames.put("programId", "program_id");
		dbColumnNames.put(
			"eligibilityDegreeMasterId", "eligibility_degree_master_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("modifiedDate", "modified_date");

		setDBColumnNames(dbColumnNames);

		setModelClass(ProgramEligibilityDegreeRel.class);

		setModelImplClass(ProgramEligibilityDegreeRelImpl.class);
		setModelPKClass(long.class);

		setTable(ProgramEligibilityDegreeRelTable.INSTANCE);
	}

	/**
	 * Caches the program eligibility degree rel in the entity cache if it is enabled.
	 *
	 * @param programEligibilityDegreeRel the program eligibility degree rel
	 */
	@Override
	public void cacheResult(
		ProgramEligibilityDegreeRel programEligibilityDegreeRel) {

		entityCache.putResult(
			ProgramEligibilityDegreeRelImpl.class,
			programEligibilityDegreeRel.getPrimaryKey(),
			programEligibilityDegreeRel);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				programEligibilityDegreeRel.getUuid(),
				programEligibilityDegreeRel.getGroupId()
			},
			programEligibilityDegreeRel);

		finderCache.putResult(
			_finderPathFetchByProgramEligibilityDegreeId,
			new Object[] {
				programEligibilityDegreeRel.getProgramId(),
				programEligibilityDegreeRel.getEligibilityDegreeMasterId()
			},
			programEligibilityDegreeRel);

		finderCache.putResult(
			_finderPathFetchByProgramId,
			new Object[] {programEligibilityDegreeRel.getProgramId()},
			programEligibilityDegreeRel);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the program eligibility degree rels in the entity cache if it is enabled.
	 *
	 * @param programEligibilityDegreeRels the program eligibility degree rels
	 */
	@Override
	public void cacheResult(
		List<ProgramEligibilityDegreeRel> programEligibilityDegreeRels) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (programEligibilityDegreeRels.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ProgramEligibilityDegreeRel programEligibilityDegreeRel :
				programEligibilityDegreeRels) {

			if (entityCache.getResult(
					ProgramEligibilityDegreeRelImpl.class,
					programEligibilityDegreeRel.getPrimaryKey()) == null) {

				cacheResult(programEligibilityDegreeRel);
			}
		}
	}

	/**
	 * Clears the cache for all program eligibility degree rels.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProgramEligibilityDegreeRelImpl.class);

		finderCache.clearCache(ProgramEligibilityDegreeRelImpl.class);
	}

	/**
	 * Clears the cache for the program eligibility degree rel.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		ProgramEligibilityDegreeRel programEligibilityDegreeRel) {

		entityCache.removeResult(
			ProgramEligibilityDegreeRelImpl.class, programEligibilityDegreeRel);
	}

	@Override
	public void clearCache(
		List<ProgramEligibilityDegreeRel> programEligibilityDegreeRels) {

		for (ProgramEligibilityDegreeRel programEligibilityDegreeRel :
				programEligibilityDegreeRels) {

			entityCache.removeResult(
				ProgramEligibilityDegreeRelImpl.class,
				programEligibilityDegreeRel);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ProgramEligibilityDegreeRelImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				ProgramEligibilityDegreeRelImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ProgramEligibilityDegreeRelModelImpl
			programEligibilityDegreeRelModelImpl) {

		Object[] args = new Object[] {
			programEligibilityDegreeRelModelImpl.getUuid(),
			programEligibilityDegreeRelModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args,
			programEligibilityDegreeRelModelImpl);

		args = new Object[] {
			programEligibilityDegreeRelModelImpl.getProgramId(),
			programEligibilityDegreeRelModelImpl.getEligibilityDegreeMasterId()
		};

		finderCache.putResult(
			_finderPathCountByProgramEligibilityDegreeId, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByProgramEligibilityDegreeId, args,
			programEligibilityDegreeRelModelImpl);

		args = new Object[] {
			programEligibilityDegreeRelModelImpl.getProgramId()
		};

		finderCache.putResult(
			_finderPathCountByProgramId, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByProgramId, args,
			programEligibilityDegreeRelModelImpl);
	}

	/**
	 * Creates a new program eligibility degree rel with the primary key. Does not add the program eligibility degree rel to the database.
	 *
	 * @param programEdId the primary key for the new program eligibility degree rel
	 * @return the new program eligibility degree rel
	 */
	@Override
	public ProgramEligibilityDegreeRel create(long programEdId) {
		ProgramEligibilityDegreeRel programEligibilityDegreeRel =
			new ProgramEligibilityDegreeRelImpl();

		programEligibilityDegreeRel.setNew(true);
		programEligibilityDegreeRel.setPrimaryKey(programEdId);

		String uuid = _portalUUID.generate();

		programEligibilityDegreeRel.setUuid(uuid);

		programEligibilityDegreeRel.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return programEligibilityDegreeRel;
	}

	/**
	 * Removes the program eligibility degree rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param programEdId the primary key of the program eligibility degree rel
	 * @return the program eligibility degree rel that was removed
	 * @throws NoSuchProgramEligibilityDegreeRelException if a program eligibility degree rel with the primary key could not be found
	 */
	@Override
	public ProgramEligibilityDegreeRel remove(long programEdId)
		throws NoSuchProgramEligibilityDegreeRelException {

		return remove((Serializable)programEdId);
	}

	/**
	 * Removes the program eligibility degree rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the program eligibility degree rel
	 * @return the program eligibility degree rel that was removed
	 * @throws NoSuchProgramEligibilityDegreeRelException if a program eligibility degree rel with the primary key could not be found
	 */
	@Override
	public ProgramEligibilityDegreeRel remove(Serializable primaryKey)
		throws NoSuchProgramEligibilityDegreeRelException {

		Session session = null;

		try {
			session = openSession();

			ProgramEligibilityDegreeRel programEligibilityDegreeRel =
				(ProgramEligibilityDegreeRel)session.get(
					ProgramEligibilityDegreeRelImpl.class, primaryKey);

			if (programEligibilityDegreeRel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProgramEligibilityDegreeRelException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(programEligibilityDegreeRel);
		}
		catch (NoSuchProgramEligibilityDegreeRelException
					noSuchEntityException) {

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
	protected ProgramEligibilityDegreeRel removeImpl(
		ProgramEligibilityDegreeRel programEligibilityDegreeRel) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(programEligibilityDegreeRel)) {
				programEligibilityDegreeRel =
					(ProgramEligibilityDegreeRel)session.get(
						ProgramEligibilityDegreeRelImpl.class,
						programEligibilityDegreeRel.getPrimaryKeyObj());
			}

			if (programEligibilityDegreeRel != null) {
				session.delete(programEligibilityDegreeRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (programEligibilityDegreeRel != null) {
			clearCache(programEligibilityDegreeRel);
		}

		return programEligibilityDegreeRel;
	}

	@Override
	public ProgramEligibilityDegreeRel updateImpl(
		ProgramEligibilityDegreeRel programEligibilityDegreeRel) {

		boolean isNew = programEligibilityDegreeRel.isNew();

		if (!(programEligibilityDegreeRel instanceof
				ProgramEligibilityDegreeRelModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(
					programEligibilityDegreeRel.getClass())) {

				invocationHandler = ProxyUtil.getInvocationHandler(
					programEligibilityDegreeRel);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in programEligibilityDegreeRel proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProgramEligibilityDegreeRel implementation " +
					programEligibilityDegreeRel.getClass());
		}

		ProgramEligibilityDegreeRelModelImpl
			programEligibilityDegreeRelModelImpl =
				(ProgramEligibilityDegreeRelModelImpl)
					programEligibilityDegreeRel;

		if (Validator.isNull(programEligibilityDegreeRel.getUuid())) {
			String uuid = _portalUUID.generate();

			programEligibilityDegreeRel.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (programEligibilityDegreeRel.getCreateDate() == null)) {
			if (serviceContext == null) {
				programEligibilityDegreeRel.setCreateDate(date);
			}
			else {
				programEligibilityDegreeRel.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!programEligibilityDegreeRelModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				programEligibilityDegreeRel.setModifiedDate(date);
			}
			else {
				programEligibilityDegreeRel.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(programEligibilityDegreeRel);
			}
			else {
				programEligibilityDegreeRel =
					(ProgramEligibilityDegreeRel)session.merge(
						programEligibilityDegreeRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProgramEligibilityDegreeRelImpl.class,
			programEligibilityDegreeRelModelImpl, false, true);

		cacheUniqueFindersCache(programEligibilityDegreeRelModelImpl);

		if (isNew) {
			programEligibilityDegreeRel.setNew(false);
		}

		programEligibilityDegreeRel.resetOriginalValues();

		return programEligibilityDegreeRel;
	}

	/**
	 * Returns the program eligibility degree rel with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the program eligibility degree rel
	 * @return the program eligibility degree rel
	 * @throws NoSuchProgramEligibilityDegreeRelException if a program eligibility degree rel with the primary key could not be found
	 */
	@Override
	public ProgramEligibilityDegreeRel findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProgramEligibilityDegreeRelException {

		ProgramEligibilityDegreeRel programEligibilityDegreeRel =
			fetchByPrimaryKey(primaryKey);

		if (programEligibilityDegreeRel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProgramEligibilityDegreeRelException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return programEligibilityDegreeRel;
	}

	/**
	 * Returns the program eligibility degree rel with the primary key or throws a <code>NoSuchProgramEligibilityDegreeRelException</code> if it could not be found.
	 *
	 * @param programEdId the primary key of the program eligibility degree rel
	 * @return the program eligibility degree rel
	 * @throws NoSuchProgramEligibilityDegreeRelException if a program eligibility degree rel with the primary key could not be found
	 */
	@Override
	public ProgramEligibilityDegreeRel findByPrimaryKey(long programEdId)
		throws NoSuchProgramEligibilityDegreeRelException {

		return findByPrimaryKey((Serializable)programEdId);
	}

	/**
	 * Returns the program eligibility degree rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param programEdId the primary key of the program eligibility degree rel
	 * @return the program eligibility degree rel, or <code>null</code> if a program eligibility degree rel with the primary key could not be found
	 */
	@Override
	public ProgramEligibilityDegreeRel fetchByPrimaryKey(long programEdId) {
		return fetchByPrimaryKey((Serializable)programEdId);
	}

	/**
	 * Returns all the program eligibility degree rels.
	 *
	 * @return the program eligibility degree rels
	 */
	@Override
	public List<ProgramEligibilityDegreeRel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the program eligibility degree rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramEligibilityDegreeRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program eligibility degree rels
	 * @param end the upper bound of the range of program eligibility degree rels (not inclusive)
	 * @return the range of program eligibility degree rels
	 */
	@Override
	public List<ProgramEligibilityDegreeRel> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the program eligibility degree rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramEligibilityDegreeRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program eligibility degree rels
	 * @param end the upper bound of the range of program eligibility degree rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of program eligibility degree rels
	 */
	@Override
	public List<ProgramEligibilityDegreeRel> findAll(
		int start, int end,
		OrderByComparator<ProgramEligibilityDegreeRel> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the program eligibility degree rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramEligibilityDegreeRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program eligibility degree rels
	 * @param end the upper bound of the range of program eligibility degree rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of program eligibility degree rels
	 */
	@Override
	public List<ProgramEligibilityDegreeRel> findAll(
		int start, int end,
		OrderByComparator<ProgramEligibilityDegreeRel> orderByComparator,
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

		List<ProgramEligibilityDegreeRel> list = null;

		if (useFinderCache) {
			list = (List<ProgramEligibilityDegreeRel>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PROGRAMELIGIBILITYDEGREEREL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PROGRAMELIGIBILITYDEGREEREL;

				sql = sql.concat(
					ProgramEligibilityDegreeRelModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ProgramEligibilityDegreeRel>)QueryUtil.list(
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
	 * Removes all the program eligibility degree rels from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProgramEligibilityDegreeRel programEligibilityDegreeRel :
				findAll()) {

			remove(programEligibilityDegreeRel);
		}
	}

	/**
	 * Returns the number of program eligibility degree rels.
	 *
	 * @return the number of program eligibility degree rels
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
					_SQL_COUNT_PROGRAMELIGIBILITYDEGREEREL);

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
		return "program_ed_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PROGRAMELIGIBILITYDEGREEREL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProgramEligibilityDegreeRelModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the program eligibility degree rel persistence.
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

		_finderPathFetchByProgramEligibilityDegreeId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByProgramEligibilityDegreeId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"program_id", "eligibility_degree_master_id"}, true);

		_finderPathCountByProgramEligibilityDegreeId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProgramEligibilityDegreeId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"program_id", "eligibility_degree_master_id"}, false);

		_finderPathFetchByProgramId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByProgramId",
			new String[] {Long.class.getName()}, new String[] {"program_id"},
			true);

		_finderPathCountByProgramId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProgramId",
			new String[] {Long.class.getName()}, new String[] {"program_id"},
			false);

		_setProgramEligibilityDegreeRelUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setProgramEligibilityDegreeRelUtilPersistence(null);

		entityCache.removeCache(
			ProgramEligibilityDegreeRelImpl.class.getName());
	}

	private void _setProgramEligibilityDegreeRelUtilPersistence(
		ProgramEligibilityDegreeRelPersistence
			programEligibilityDegreeRelPersistence) {

		try {
			Field field =
				ProgramEligibilityDegreeRelUtil.class.getDeclaredField(
					"_persistence");

			field.setAccessible(true);

			field.set(null, programEligibilityDegreeRelPersistence);
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

	private static final String _SQL_SELECT_PROGRAMELIGIBILITYDEGREEREL =
		"SELECT programEligibilityDegreeRel FROM ProgramEligibilityDegreeRel programEligibilityDegreeRel";

	private static final String _SQL_SELECT_PROGRAMELIGIBILITYDEGREEREL_WHERE =
		"SELECT programEligibilityDegreeRel FROM ProgramEligibilityDegreeRel programEligibilityDegreeRel WHERE ";

	private static final String _SQL_COUNT_PROGRAMELIGIBILITYDEGREEREL =
		"SELECT COUNT(programEligibilityDegreeRel) FROM ProgramEligibilityDegreeRel programEligibilityDegreeRel";

	private static final String _SQL_COUNT_PROGRAMELIGIBILITYDEGREEREL_WHERE =
		"SELECT COUNT(programEligibilityDegreeRel) FROM ProgramEligibilityDegreeRel programEligibilityDegreeRel WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"programEligibilityDegreeRel.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProgramEligibilityDegreeRel exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ProgramEligibilityDegreeRel exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProgramEligibilityDegreeRelPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "programEdId", "programId", "eligibilityDegreeMasterId",
			"groupId", "companyId", "createDate", "modifiedDate"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}