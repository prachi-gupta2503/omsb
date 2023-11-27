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

import gov.omsb.tms.exception.NoSuchProgramWorkflowDetailsRelException;
import gov.omsb.tms.model.ProgramWorkflowDetailsRel;
import gov.omsb.tms.model.ProgramWorkflowDetailsRelTable;
import gov.omsb.tms.model.impl.ProgramWorkflowDetailsRelImpl;
import gov.omsb.tms.model.impl.ProgramWorkflowDetailsRelModelImpl;
import gov.omsb.tms.service.persistence.ProgramWorkflowDetailsRelPersistence;
import gov.omsb.tms.service.persistence.ProgramWorkflowDetailsRelUtil;
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
 * The persistence implementation for the program workflow details rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ProgramWorkflowDetailsRelPersistence.class)
public class ProgramWorkflowDetailsRelPersistenceImpl
	extends BasePersistenceImpl<ProgramWorkflowDetailsRel>
	implements ProgramWorkflowDetailsRelPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProgramWorkflowDetailsRelUtil</code> to access the program workflow details rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProgramWorkflowDetailsRelImpl.class.getName();

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
	 * Returns all the program workflow details rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching program workflow details rels
	 */
	@Override
	public List<ProgramWorkflowDetailsRel> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the program workflow details rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramWorkflowDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program workflow details rels
	 * @param end the upper bound of the range of program workflow details rels (not inclusive)
	 * @return the range of matching program workflow details rels
	 */
	@Override
	public List<ProgramWorkflowDetailsRel> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the program workflow details rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramWorkflowDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program workflow details rels
	 * @param end the upper bound of the range of program workflow details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program workflow details rels
	 */
	@Override
	public List<ProgramWorkflowDetailsRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgramWorkflowDetailsRel> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the program workflow details rels where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramWorkflowDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program workflow details rels
	 * @param end the upper bound of the range of program workflow details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program workflow details rels
	 */
	@Override
	public List<ProgramWorkflowDetailsRel> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgramWorkflowDetailsRel> orderByComparator,
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

		List<ProgramWorkflowDetailsRel> list = null;

		if (useFinderCache) {
			list = (List<ProgramWorkflowDetailsRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgramWorkflowDetailsRel programWorkflowDetailsRel :
						list) {

					if (!uuid.equals(programWorkflowDetailsRel.getUuid())) {
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

			sb.append(_SQL_SELECT_PROGRAMWORKFLOWDETAILSREL_WHERE);

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
				sb.append(ProgramWorkflowDetailsRelModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProgramWorkflowDetailsRel>)QueryUtil.list(
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
	 * Returns the first program workflow details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program workflow details rel
	 * @throws NoSuchProgramWorkflowDetailsRelException if a matching program workflow details rel could not be found
	 */
	@Override
	public ProgramWorkflowDetailsRel findByUuid_First(
			String uuid,
			OrderByComparator<ProgramWorkflowDetailsRel> orderByComparator)
		throws NoSuchProgramWorkflowDetailsRelException {

		ProgramWorkflowDetailsRel programWorkflowDetailsRel = fetchByUuid_First(
			uuid, orderByComparator);

		if (programWorkflowDetailsRel != null) {
			return programWorkflowDetailsRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProgramWorkflowDetailsRelException(sb.toString());
	}

	/**
	 * Returns the first program workflow details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program workflow details rel, or <code>null</code> if a matching program workflow details rel could not be found
	 */
	@Override
	public ProgramWorkflowDetailsRel fetchByUuid_First(
		String uuid,
		OrderByComparator<ProgramWorkflowDetailsRel> orderByComparator) {

		List<ProgramWorkflowDetailsRel> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last program workflow details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program workflow details rel
	 * @throws NoSuchProgramWorkflowDetailsRelException if a matching program workflow details rel could not be found
	 */
	@Override
	public ProgramWorkflowDetailsRel findByUuid_Last(
			String uuid,
			OrderByComparator<ProgramWorkflowDetailsRel> orderByComparator)
		throws NoSuchProgramWorkflowDetailsRelException {

		ProgramWorkflowDetailsRel programWorkflowDetailsRel = fetchByUuid_Last(
			uuid, orderByComparator);

		if (programWorkflowDetailsRel != null) {
			return programWorkflowDetailsRel;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProgramWorkflowDetailsRelException(sb.toString());
	}

	/**
	 * Returns the last program workflow details rel in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program workflow details rel, or <code>null</code> if a matching program workflow details rel could not be found
	 */
	@Override
	public ProgramWorkflowDetailsRel fetchByUuid_Last(
		String uuid,
		OrderByComparator<ProgramWorkflowDetailsRel> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ProgramWorkflowDetailsRel> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the program workflow details rels before and after the current program workflow details rel in the ordered set where uuid = &#63;.
	 *
	 * @param programWorkflowDetailsRelId the primary key of the current program workflow details rel
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program workflow details rel
	 * @throws NoSuchProgramWorkflowDetailsRelException if a program workflow details rel with the primary key could not be found
	 */
	@Override
	public ProgramWorkflowDetailsRel[] findByUuid_PrevAndNext(
			long programWorkflowDetailsRelId, String uuid,
			OrderByComparator<ProgramWorkflowDetailsRel> orderByComparator)
		throws NoSuchProgramWorkflowDetailsRelException {

		uuid = Objects.toString(uuid, "");

		ProgramWorkflowDetailsRel programWorkflowDetailsRel = findByPrimaryKey(
			programWorkflowDetailsRelId);

		Session session = null;

		try {
			session = openSession();

			ProgramWorkflowDetailsRel[] array =
				new ProgramWorkflowDetailsRelImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, programWorkflowDetailsRel, uuid, orderByComparator,
				true);

			array[1] = programWorkflowDetailsRel;

			array[2] = getByUuid_PrevAndNext(
				session, programWorkflowDetailsRel, uuid, orderByComparator,
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

	protected ProgramWorkflowDetailsRel getByUuid_PrevAndNext(
		Session session, ProgramWorkflowDetailsRel programWorkflowDetailsRel,
		String uuid,
		OrderByComparator<ProgramWorkflowDetailsRel> orderByComparator,
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

		sb.append(_SQL_SELECT_PROGRAMWORKFLOWDETAILSREL_WHERE);

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
			sb.append(ProgramWorkflowDetailsRelModelImpl.ORDER_BY_JPQL);
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
						programWorkflowDetailsRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgramWorkflowDetailsRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the program workflow details rels where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ProgramWorkflowDetailsRel programWorkflowDetailsRel :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(programWorkflowDetailsRel);
		}
	}

	/**
	 * Returns the number of program workflow details rels where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching program workflow details rels
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROGRAMWORKFLOWDETAILSREL_WHERE);

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
		"programWorkflowDetailsRel.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(programWorkflowDetailsRel.uuid IS NULL OR programWorkflowDetailsRel.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the program workflow details rel where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProgramWorkflowDetailsRelException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching program workflow details rel
	 * @throws NoSuchProgramWorkflowDetailsRelException if a matching program workflow details rel could not be found
	 */
	@Override
	public ProgramWorkflowDetailsRel findByUUID_G(String uuid, long groupId)
		throws NoSuchProgramWorkflowDetailsRelException {

		ProgramWorkflowDetailsRel programWorkflowDetailsRel = fetchByUUID_G(
			uuid, groupId);

		if (programWorkflowDetailsRel == null) {
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

			throw new NoSuchProgramWorkflowDetailsRelException(sb.toString());
		}

		return programWorkflowDetailsRel;
	}

	/**
	 * Returns the program workflow details rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching program workflow details rel, or <code>null</code> if a matching program workflow details rel could not be found
	 */
	@Override
	public ProgramWorkflowDetailsRel fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the program workflow details rel where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching program workflow details rel, or <code>null</code> if a matching program workflow details rel could not be found
	 */
	@Override
	public ProgramWorkflowDetailsRel fetchByUUID_G(
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

		if (result instanceof ProgramWorkflowDetailsRel) {
			ProgramWorkflowDetailsRel programWorkflowDetailsRel =
				(ProgramWorkflowDetailsRel)result;

			if (!Objects.equals(uuid, programWorkflowDetailsRel.getUuid()) ||
				(groupId != programWorkflowDetailsRel.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PROGRAMWORKFLOWDETAILSREL_WHERE);

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

				List<ProgramWorkflowDetailsRel> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ProgramWorkflowDetailsRel programWorkflowDetailsRel =
						list.get(0);

					result = programWorkflowDetailsRel;

					cacheResult(programWorkflowDetailsRel);
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
			return (ProgramWorkflowDetailsRel)result;
		}
	}

	/**
	 * Removes the program workflow details rel where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the program workflow details rel that was removed
	 */
	@Override
	public ProgramWorkflowDetailsRel removeByUUID_G(String uuid, long groupId)
		throws NoSuchProgramWorkflowDetailsRelException {

		ProgramWorkflowDetailsRel programWorkflowDetailsRel = findByUUID_G(
			uuid, groupId);

		return remove(programWorkflowDetailsRel);
	}

	/**
	 * Returns the number of program workflow details rels where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching program workflow details rels
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROGRAMWORKFLOWDETAILSREL_WHERE);

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
		"programWorkflowDetailsRel.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(programWorkflowDetailsRel.uuid IS NULL OR programWorkflowDetailsRel.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"programWorkflowDetailsRel.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the program workflow details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching program workflow details rels
	 */
	@Override
	public List<ProgramWorkflowDetailsRel> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the program workflow details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramWorkflowDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program workflow details rels
	 * @param end the upper bound of the range of program workflow details rels (not inclusive)
	 * @return the range of matching program workflow details rels
	 */
	@Override
	public List<ProgramWorkflowDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the program workflow details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramWorkflowDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program workflow details rels
	 * @param end the upper bound of the range of program workflow details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program workflow details rels
	 */
	@Override
	public List<ProgramWorkflowDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgramWorkflowDetailsRel> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the program workflow details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramWorkflowDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program workflow details rels
	 * @param end the upper bound of the range of program workflow details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program workflow details rels
	 */
	@Override
	public List<ProgramWorkflowDetailsRel> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgramWorkflowDetailsRel> orderByComparator,
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

		List<ProgramWorkflowDetailsRel> list = null;

		if (useFinderCache) {
			list = (List<ProgramWorkflowDetailsRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgramWorkflowDetailsRel programWorkflowDetailsRel :
						list) {

					if (!uuid.equals(programWorkflowDetailsRel.getUuid()) ||
						(companyId !=
							programWorkflowDetailsRel.getCompanyId())) {

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

			sb.append(_SQL_SELECT_PROGRAMWORKFLOWDETAILSREL_WHERE);

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
				sb.append(ProgramWorkflowDetailsRelModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProgramWorkflowDetailsRel>)QueryUtil.list(
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
	 * Returns the first program workflow details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program workflow details rel
	 * @throws NoSuchProgramWorkflowDetailsRelException if a matching program workflow details rel could not be found
	 */
	@Override
	public ProgramWorkflowDetailsRel findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProgramWorkflowDetailsRel> orderByComparator)
		throws NoSuchProgramWorkflowDetailsRelException {

		ProgramWorkflowDetailsRel programWorkflowDetailsRel =
			fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (programWorkflowDetailsRel != null) {
			return programWorkflowDetailsRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProgramWorkflowDetailsRelException(sb.toString());
	}

	/**
	 * Returns the first program workflow details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program workflow details rel, or <code>null</code> if a matching program workflow details rel could not be found
	 */
	@Override
	public ProgramWorkflowDetailsRel fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProgramWorkflowDetailsRel> orderByComparator) {

		List<ProgramWorkflowDetailsRel> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last program workflow details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program workflow details rel
	 * @throws NoSuchProgramWorkflowDetailsRelException if a matching program workflow details rel could not be found
	 */
	@Override
	public ProgramWorkflowDetailsRel findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProgramWorkflowDetailsRel> orderByComparator)
		throws NoSuchProgramWorkflowDetailsRelException {

		ProgramWorkflowDetailsRel programWorkflowDetailsRel =
			fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (programWorkflowDetailsRel != null) {
			return programWorkflowDetailsRel;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProgramWorkflowDetailsRelException(sb.toString());
	}

	/**
	 * Returns the last program workflow details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program workflow details rel, or <code>null</code> if a matching program workflow details rel could not be found
	 */
	@Override
	public ProgramWorkflowDetailsRel fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProgramWorkflowDetailsRel> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ProgramWorkflowDetailsRel> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the program workflow details rels before and after the current program workflow details rel in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param programWorkflowDetailsRelId the primary key of the current program workflow details rel
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program workflow details rel
	 * @throws NoSuchProgramWorkflowDetailsRelException if a program workflow details rel with the primary key could not be found
	 */
	@Override
	public ProgramWorkflowDetailsRel[] findByUuid_C_PrevAndNext(
			long programWorkflowDetailsRelId, String uuid, long companyId,
			OrderByComparator<ProgramWorkflowDetailsRel> orderByComparator)
		throws NoSuchProgramWorkflowDetailsRelException {

		uuid = Objects.toString(uuid, "");

		ProgramWorkflowDetailsRel programWorkflowDetailsRel = findByPrimaryKey(
			programWorkflowDetailsRelId);

		Session session = null;

		try {
			session = openSession();

			ProgramWorkflowDetailsRel[] array =
				new ProgramWorkflowDetailsRelImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, programWorkflowDetailsRel, uuid, companyId,
				orderByComparator, true);

			array[1] = programWorkflowDetailsRel;

			array[2] = getByUuid_C_PrevAndNext(
				session, programWorkflowDetailsRel, uuid, companyId,
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

	protected ProgramWorkflowDetailsRel getByUuid_C_PrevAndNext(
		Session session, ProgramWorkflowDetailsRel programWorkflowDetailsRel,
		String uuid, long companyId,
		OrderByComparator<ProgramWorkflowDetailsRel> orderByComparator,
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

		sb.append(_SQL_SELECT_PROGRAMWORKFLOWDETAILSREL_WHERE);

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
			sb.append(ProgramWorkflowDetailsRelModelImpl.ORDER_BY_JPQL);
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
						programWorkflowDetailsRel)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgramWorkflowDetailsRel> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the program workflow details rels where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ProgramWorkflowDetailsRel programWorkflowDetailsRel :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(programWorkflowDetailsRel);
		}
	}

	/**
	 * Returns the number of program workflow details rels where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching program workflow details rels
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROGRAMWORKFLOWDETAILSREL_WHERE);

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
		"programWorkflowDetailsRel.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(programWorkflowDetailsRel.uuid IS NULL OR programWorkflowDetailsRel.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"programWorkflowDetailsRel.companyId = ?";

	private FinderPath _finderPathFetchByProgramWorkflowByProgramId;
	private FinderPath _finderPathCountByProgramWorkflowByProgramId;

	/**
	 * Returns the program workflow details rel where programId = &#63; or throws a <code>NoSuchProgramWorkflowDetailsRelException</code> if it could not be found.
	 *
	 * @param programId the program ID
	 * @return the matching program workflow details rel
	 * @throws NoSuchProgramWorkflowDetailsRelException if a matching program workflow details rel could not be found
	 */
	@Override
	public ProgramWorkflowDetailsRel findByProgramWorkflowByProgramId(
			long programId)
		throws NoSuchProgramWorkflowDetailsRelException {

		ProgramWorkflowDetailsRel programWorkflowDetailsRel =
			fetchByProgramWorkflowByProgramId(programId);

		if (programWorkflowDetailsRel == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("programId=");
			sb.append(programId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchProgramWorkflowDetailsRelException(sb.toString());
		}

		return programWorkflowDetailsRel;
	}

	/**
	 * Returns the program workflow details rel where programId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param programId the program ID
	 * @return the matching program workflow details rel, or <code>null</code> if a matching program workflow details rel could not be found
	 */
	@Override
	public ProgramWorkflowDetailsRel fetchByProgramWorkflowByProgramId(
		long programId) {

		return fetchByProgramWorkflowByProgramId(programId, true);
	}

	/**
	 * Returns the program workflow details rel where programId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param programId the program ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching program workflow details rel, or <code>null</code> if a matching program workflow details rel could not be found
	 */
	@Override
	public ProgramWorkflowDetailsRel fetchByProgramWorkflowByProgramId(
		long programId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {programId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByProgramWorkflowByProgramId, finderArgs, this);
		}

		if (result instanceof ProgramWorkflowDetailsRel) {
			ProgramWorkflowDetailsRel programWorkflowDetailsRel =
				(ProgramWorkflowDetailsRel)result;

			if (programId != programWorkflowDetailsRel.getProgramId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_PROGRAMWORKFLOWDETAILSREL_WHERE);

			sb.append(_FINDER_COLUMN_PROGRAMWORKFLOWBYPROGRAMID_PROGRAMID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programId);

				List<ProgramWorkflowDetailsRel> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByProgramWorkflowByProgramId,
							finderArgs, list);
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
								"ProgramWorkflowDetailsRelPersistenceImpl.fetchByProgramWorkflowByProgramId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ProgramWorkflowDetailsRel programWorkflowDetailsRel =
						list.get(0);

					result = programWorkflowDetailsRel;

					cacheResult(programWorkflowDetailsRel);
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
			return (ProgramWorkflowDetailsRel)result;
		}
	}

	/**
	 * Removes the program workflow details rel where programId = &#63; from the database.
	 *
	 * @param programId the program ID
	 * @return the program workflow details rel that was removed
	 */
	@Override
	public ProgramWorkflowDetailsRel removeByProgramWorkflowByProgramId(
			long programId)
		throws NoSuchProgramWorkflowDetailsRelException {

		ProgramWorkflowDetailsRel programWorkflowDetailsRel =
			findByProgramWorkflowByProgramId(programId);

		return remove(programWorkflowDetailsRel);
	}

	/**
	 * Returns the number of program workflow details rels where programId = &#63;.
	 *
	 * @param programId the program ID
	 * @return the number of matching program workflow details rels
	 */
	@Override
	public int countByProgramWorkflowByProgramId(long programId) {
		FinderPath finderPath = _finderPathCountByProgramWorkflowByProgramId;

		Object[] finderArgs = new Object[] {programId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROGRAMWORKFLOWDETAILSREL_WHERE);

			sb.append(_FINDER_COLUMN_PROGRAMWORKFLOWBYPROGRAMID_PROGRAMID_2);

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

	private static final String
		_FINDER_COLUMN_PROGRAMWORKFLOWBYPROGRAMID_PROGRAMID_2 =
			"programWorkflowDetailsRel.programId = ?";

	public ProgramWorkflowDetailsRelPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put(
			"programWorkflowDetailsRelId", "program_workflow_details_rel_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("createdBy", "created_by");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("modifiedBy", "modified_by");
		dbColumnNames.put("programId", "program_id");
		dbColumnNames.put("workflowApprovalOrder", "workflow_approval_order");

		setDBColumnNames(dbColumnNames);

		setModelClass(ProgramWorkflowDetailsRel.class);

		setModelImplClass(ProgramWorkflowDetailsRelImpl.class);
		setModelPKClass(long.class);

		setTable(ProgramWorkflowDetailsRelTable.INSTANCE);
	}

	/**
	 * Caches the program workflow details rel in the entity cache if it is enabled.
	 *
	 * @param programWorkflowDetailsRel the program workflow details rel
	 */
	@Override
	public void cacheResult(
		ProgramWorkflowDetailsRel programWorkflowDetailsRel) {

		entityCache.putResult(
			ProgramWorkflowDetailsRelImpl.class,
			programWorkflowDetailsRel.getPrimaryKey(),
			programWorkflowDetailsRel);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				programWorkflowDetailsRel.getUuid(),
				programWorkflowDetailsRel.getGroupId()
			},
			programWorkflowDetailsRel);

		finderCache.putResult(
			_finderPathFetchByProgramWorkflowByProgramId,
			new Object[] {programWorkflowDetailsRel.getProgramId()},
			programWorkflowDetailsRel);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the program workflow details rels in the entity cache if it is enabled.
	 *
	 * @param programWorkflowDetailsRels the program workflow details rels
	 */
	@Override
	public void cacheResult(
		List<ProgramWorkflowDetailsRel> programWorkflowDetailsRels) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (programWorkflowDetailsRels.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ProgramWorkflowDetailsRel programWorkflowDetailsRel :
				programWorkflowDetailsRels) {

			if (entityCache.getResult(
					ProgramWorkflowDetailsRelImpl.class,
					programWorkflowDetailsRel.getPrimaryKey()) == null) {

				cacheResult(programWorkflowDetailsRel);
			}
		}
	}

	/**
	 * Clears the cache for all program workflow details rels.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProgramWorkflowDetailsRelImpl.class);

		finderCache.clearCache(ProgramWorkflowDetailsRelImpl.class);
	}

	/**
	 * Clears the cache for the program workflow details rel.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		ProgramWorkflowDetailsRel programWorkflowDetailsRel) {

		entityCache.removeResult(
			ProgramWorkflowDetailsRelImpl.class, programWorkflowDetailsRel);
	}

	@Override
	public void clearCache(
		List<ProgramWorkflowDetailsRel> programWorkflowDetailsRels) {

		for (ProgramWorkflowDetailsRel programWorkflowDetailsRel :
				programWorkflowDetailsRels) {

			entityCache.removeResult(
				ProgramWorkflowDetailsRelImpl.class, programWorkflowDetailsRel);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ProgramWorkflowDetailsRelImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				ProgramWorkflowDetailsRelImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ProgramWorkflowDetailsRelModelImpl programWorkflowDetailsRelModelImpl) {

		Object[] args = new Object[] {
			programWorkflowDetailsRelModelImpl.getUuid(),
			programWorkflowDetailsRelModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, programWorkflowDetailsRelModelImpl);

		args = new Object[] {programWorkflowDetailsRelModelImpl.getProgramId()};

		finderCache.putResult(
			_finderPathCountByProgramWorkflowByProgramId, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByProgramWorkflowByProgramId, args,
			programWorkflowDetailsRelModelImpl);
	}

	/**
	 * Creates a new program workflow details rel with the primary key. Does not add the program workflow details rel to the database.
	 *
	 * @param programWorkflowDetailsRelId the primary key for the new program workflow details rel
	 * @return the new program workflow details rel
	 */
	@Override
	public ProgramWorkflowDetailsRel create(long programWorkflowDetailsRelId) {
		ProgramWorkflowDetailsRel programWorkflowDetailsRel =
			new ProgramWorkflowDetailsRelImpl();

		programWorkflowDetailsRel.setNew(true);
		programWorkflowDetailsRel.setPrimaryKey(programWorkflowDetailsRelId);

		String uuid = _portalUUID.generate();

		programWorkflowDetailsRel.setUuid(uuid);

		programWorkflowDetailsRel.setCompanyId(
			CompanyThreadLocal.getCompanyId());

		return programWorkflowDetailsRel;
	}

	/**
	 * Removes the program workflow details rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param programWorkflowDetailsRelId the primary key of the program workflow details rel
	 * @return the program workflow details rel that was removed
	 * @throws NoSuchProgramWorkflowDetailsRelException if a program workflow details rel with the primary key could not be found
	 */
	@Override
	public ProgramWorkflowDetailsRel remove(long programWorkflowDetailsRelId)
		throws NoSuchProgramWorkflowDetailsRelException {

		return remove((Serializable)programWorkflowDetailsRelId);
	}

	/**
	 * Removes the program workflow details rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the program workflow details rel
	 * @return the program workflow details rel that was removed
	 * @throws NoSuchProgramWorkflowDetailsRelException if a program workflow details rel with the primary key could not be found
	 */
	@Override
	public ProgramWorkflowDetailsRel remove(Serializable primaryKey)
		throws NoSuchProgramWorkflowDetailsRelException {

		Session session = null;

		try {
			session = openSession();

			ProgramWorkflowDetailsRel programWorkflowDetailsRel =
				(ProgramWorkflowDetailsRel)session.get(
					ProgramWorkflowDetailsRelImpl.class, primaryKey);

			if (programWorkflowDetailsRel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProgramWorkflowDetailsRelException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(programWorkflowDetailsRel);
		}
		catch (NoSuchProgramWorkflowDetailsRelException noSuchEntityException) {
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
	protected ProgramWorkflowDetailsRel removeImpl(
		ProgramWorkflowDetailsRel programWorkflowDetailsRel) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(programWorkflowDetailsRel)) {
				programWorkflowDetailsRel =
					(ProgramWorkflowDetailsRel)session.get(
						ProgramWorkflowDetailsRelImpl.class,
						programWorkflowDetailsRel.getPrimaryKeyObj());
			}

			if (programWorkflowDetailsRel != null) {
				session.delete(programWorkflowDetailsRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (programWorkflowDetailsRel != null) {
			clearCache(programWorkflowDetailsRel);
		}

		return programWorkflowDetailsRel;
	}

	@Override
	public ProgramWorkflowDetailsRel updateImpl(
		ProgramWorkflowDetailsRel programWorkflowDetailsRel) {

		boolean isNew = programWorkflowDetailsRel.isNew();

		if (!(programWorkflowDetailsRel instanceof
				ProgramWorkflowDetailsRelModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(programWorkflowDetailsRel.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					programWorkflowDetailsRel);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in programWorkflowDetailsRel proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProgramWorkflowDetailsRel implementation " +
					programWorkflowDetailsRel.getClass());
		}

		ProgramWorkflowDetailsRelModelImpl programWorkflowDetailsRelModelImpl =
			(ProgramWorkflowDetailsRelModelImpl)programWorkflowDetailsRel;

		if (Validator.isNull(programWorkflowDetailsRel.getUuid())) {
			String uuid = _portalUUID.generate();

			programWorkflowDetailsRel.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (programWorkflowDetailsRel.getCreateDate() == null)) {
			if (serviceContext == null) {
				programWorkflowDetailsRel.setCreateDate(date);
			}
			else {
				programWorkflowDetailsRel.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!programWorkflowDetailsRelModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				programWorkflowDetailsRel.setModifiedDate(date);
			}
			else {
				programWorkflowDetailsRel.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(programWorkflowDetailsRel);
			}
			else {
				programWorkflowDetailsRel =
					(ProgramWorkflowDetailsRel)session.merge(
						programWorkflowDetailsRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProgramWorkflowDetailsRelImpl.class,
			programWorkflowDetailsRelModelImpl, false, true);

		cacheUniqueFindersCache(programWorkflowDetailsRelModelImpl);

		if (isNew) {
			programWorkflowDetailsRel.setNew(false);
		}

		programWorkflowDetailsRel.resetOriginalValues();

		return programWorkflowDetailsRel;
	}

	/**
	 * Returns the program workflow details rel with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the program workflow details rel
	 * @return the program workflow details rel
	 * @throws NoSuchProgramWorkflowDetailsRelException if a program workflow details rel with the primary key could not be found
	 */
	@Override
	public ProgramWorkflowDetailsRel findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProgramWorkflowDetailsRelException {

		ProgramWorkflowDetailsRel programWorkflowDetailsRel = fetchByPrimaryKey(
			primaryKey);

		if (programWorkflowDetailsRel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProgramWorkflowDetailsRelException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return programWorkflowDetailsRel;
	}

	/**
	 * Returns the program workflow details rel with the primary key or throws a <code>NoSuchProgramWorkflowDetailsRelException</code> if it could not be found.
	 *
	 * @param programWorkflowDetailsRelId the primary key of the program workflow details rel
	 * @return the program workflow details rel
	 * @throws NoSuchProgramWorkflowDetailsRelException if a program workflow details rel with the primary key could not be found
	 */
	@Override
	public ProgramWorkflowDetailsRel findByPrimaryKey(
			long programWorkflowDetailsRelId)
		throws NoSuchProgramWorkflowDetailsRelException {

		return findByPrimaryKey((Serializable)programWorkflowDetailsRelId);
	}

	/**
	 * Returns the program workflow details rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param programWorkflowDetailsRelId the primary key of the program workflow details rel
	 * @return the program workflow details rel, or <code>null</code> if a program workflow details rel with the primary key could not be found
	 */
	@Override
	public ProgramWorkflowDetailsRel fetchByPrimaryKey(
		long programWorkflowDetailsRelId) {

		return fetchByPrimaryKey((Serializable)programWorkflowDetailsRelId);
	}

	/**
	 * Returns all the program workflow details rels.
	 *
	 * @return the program workflow details rels
	 */
	@Override
	public List<ProgramWorkflowDetailsRel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the program workflow details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramWorkflowDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program workflow details rels
	 * @param end the upper bound of the range of program workflow details rels (not inclusive)
	 * @return the range of program workflow details rels
	 */
	@Override
	public List<ProgramWorkflowDetailsRel> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the program workflow details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramWorkflowDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program workflow details rels
	 * @param end the upper bound of the range of program workflow details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of program workflow details rels
	 */
	@Override
	public List<ProgramWorkflowDetailsRel> findAll(
		int start, int end,
		OrderByComparator<ProgramWorkflowDetailsRel> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the program workflow details rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramWorkflowDetailsRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program workflow details rels
	 * @param end the upper bound of the range of program workflow details rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of program workflow details rels
	 */
	@Override
	public List<ProgramWorkflowDetailsRel> findAll(
		int start, int end,
		OrderByComparator<ProgramWorkflowDetailsRel> orderByComparator,
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

		List<ProgramWorkflowDetailsRel> list = null;

		if (useFinderCache) {
			list = (List<ProgramWorkflowDetailsRel>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PROGRAMWORKFLOWDETAILSREL);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PROGRAMWORKFLOWDETAILSREL;

				sql = sql.concat(
					ProgramWorkflowDetailsRelModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ProgramWorkflowDetailsRel>)QueryUtil.list(
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
	 * Removes all the program workflow details rels from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProgramWorkflowDetailsRel programWorkflowDetailsRel : findAll()) {
			remove(programWorkflowDetailsRel);
		}
	}

	/**
	 * Returns the number of program workflow details rels.
	 *
	 * @return the number of program workflow details rels
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
					_SQL_COUNT_PROGRAMWORKFLOWDETAILSREL);

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
		return "program_workflow_details_rel_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PROGRAMWORKFLOWDETAILSREL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProgramWorkflowDetailsRelModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the program workflow details rel persistence.
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

		_finderPathFetchByProgramWorkflowByProgramId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByProgramWorkflowByProgramId",
			new String[] {Long.class.getName()}, new String[] {"program_id"},
			true);

		_finderPathCountByProgramWorkflowByProgramId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProgramWorkflowByProgramId",
			new String[] {Long.class.getName()}, new String[] {"program_id"},
			false);

		_setProgramWorkflowDetailsRelUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setProgramWorkflowDetailsRelUtilPersistence(null);

		entityCache.removeCache(ProgramWorkflowDetailsRelImpl.class.getName());
	}

	private void _setProgramWorkflowDetailsRelUtilPersistence(
		ProgramWorkflowDetailsRelPersistence
			programWorkflowDetailsRelPersistence) {

		try {
			Field field = ProgramWorkflowDetailsRelUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, programWorkflowDetailsRelPersistence);
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

	private static final String _SQL_SELECT_PROGRAMWORKFLOWDETAILSREL =
		"SELECT programWorkflowDetailsRel FROM ProgramWorkflowDetailsRel programWorkflowDetailsRel";

	private static final String _SQL_SELECT_PROGRAMWORKFLOWDETAILSREL_WHERE =
		"SELECT programWorkflowDetailsRel FROM ProgramWorkflowDetailsRel programWorkflowDetailsRel WHERE ";

	private static final String _SQL_COUNT_PROGRAMWORKFLOWDETAILSREL =
		"SELECT COUNT(programWorkflowDetailsRel) FROM ProgramWorkflowDetailsRel programWorkflowDetailsRel";

	private static final String _SQL_COUNT_PROGRAMWORKFLOWDETAILSREL_WHERE =
		"SELECT COUNT(programWorkflowDetailsRel) FROM ProgramWorkflowDetailsRel programWorkflowDetailsRel WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"programWorkflowDetailsRel.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProgramWorkflowDetailsRel exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ProgramWorkflowDetailsRel exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProgramWorkflowDetailsRelPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "programWorkflowDetailsRelId", "groupId", "companyId",
			"createDate", "createdBy", "modifiedDate", "modifiedBy",
			"programId", "workflowApprovalOrder"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}