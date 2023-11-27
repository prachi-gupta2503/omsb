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

import gov.omsb.tms.exception.NoSuchProgramDurationDetailsException;
import gov.omsb.tms.model.ProgramDurationDetails;
import gov.omsb.tms.model.ProgramDurationDetailsTable;
import gov.omsb.tms.model.impl.ProgramDurationDetailsImpl;
import gov.omsb.tms.model.impl.ProgramDurationDetailsModelImpl;
import gov.omsb.tms.service.persistence.ProgramDurationDetailsPersistence;
import gov.omsb.tms.service.persistence.ProgramDurationDetailsUtil;
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
 * The persistence implementation for the program duration details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ProgramDurationDetailsPersistence.class)
public class ProgramDurationDetailsPersistenceImpl
	extends BasePersistenceImpl<ProgramDurationDetails>
	implements ProgramDurationDetailsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProgramDurationDetailsUtil</code> to access the program duration details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProgramDurationDetailsImpl.class.getName();

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
	 * Returns all the program duration detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching program duration detailses
	 */
	@Override
	public List<ProgramDurationDetails> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the program duration detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDurationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program duration detailses
	 * @param end the upper bound of the range of program duration detailses (not inclusive)
	 * @return the range of matching program duration detailses
	 */
	@Override
	public List<ProgramDurationDetails> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the program duration detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDurationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program duration detailses
	 * @param end the upper bound of the range of program duration detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program duration detailses
	 */
	@Override
	public List<ProgramDurationDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgramDurationDetails> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the program duration detailses where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDurationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of program duration detailses
	 * @param end the upper bound of the range of program duration detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program duration detailses
	 */
	@Override
	public List<ProgramDurationDetails> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<ProgramDurationDetails> orderByComparator,
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

		List<ProgramDurationDetails> list = null;

		if (useFinderCache) {
			list = (List<ProgramDurationDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgramDurationDetails programDurationDetails : list) {
					if (!uuid.equals(programDurationDetails.getUuid())) {
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

			sb.append(_SQL_SELECT_PROGRAMDURATIONDETAILS_WHERE);

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
				sb.append(ProgramDurationDetailsModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProgramDurationDetails>)QueryUtil.list(
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
	 * Returns the first program duration details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duration details
	 * @throws NoSuchProgramDurationDetailsException if a matching program duration details could not be found
	 */
	@Override
	public ProgramDurationDetails findByUuid_First(
			String uuid,
			OrderByComparator<ProgramDurationDetails> orderByComparator)
		throws NoSuchProgramDurationDetailsException {

		ProgramDurationDetails programDurationDetails = fetchByUuid_First(
			uuid, orderByComparator);

		if (programDurationDetails != null) {
			return programDurationDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProgramDurationDetailsException(sb.toString());
	}

	/**
	 * Returns the first program duration details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duration details, or <code>null</code> if a matching program duration details could not be found
	 */
	@Override
	public ProgramDurationDetails fetchByUuid_First(
		String uuid,
		OrderByComparator<ProgramDurationDetails> orderByComparator) {

		List<ProgramDurationDetails> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last program duration details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duration details
	 * @throws NoSuchProgramDurationDetailsException if a matching program duration details could not be found
	 */
	@Override
	public ProgramDurationDetails findByUuid_Last(
			String uuid,
			OrderByComparator<ProgramDurationDetails> orderByComparator)
		throws NoSuchProgramDurationDetailsException {

		ProgramDurationDetails programDurationDetails = fetchByUuid_Last(
			uuid, orderByComparator);

		if (programDurationDetails != null) {
			return programDurationDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchProgramDurationDetailsException(sb.toString());
	}

	/**
	 * Returns the last program duration details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duration details, or <code>null</code> if a matching program duration details could not be found
	 */
	@Override
	public ProgramDurationDetails fetchByUuid_Last(
		String uuid,
		OrderByComparator<ProgramDurationDetails> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<ProgramDurationDetails> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the program duration detailses before and after the current program duration details in the ordered set where uuid = &#63;.
	 *
	 * @param progDurationId the primary key of the current program duration details
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program duration details
	 * @throws NoSuchProgramDurationDetailsException if a program duration details with the primary key could not be found
	 */
	@Override
	public ProgramDurationDetails[] findByUuid_PrevAndNext(
			long progDurationId, String uuid,
			OrderByComparator<ProgramDurationDetails> orderByComparator)
		throws NoSuchProgramDurationDetailsException {

		uuid = Objects.toString(uuid, "");

		ProgramDurationDetails programDurationDetails = findByPrimaryKey(
			progDurationId);

		Session session = null;

		try {
			session = openSession();

			ProgramDurationDetails[] array = new ProgramDurationDetailsImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, programDurationDetails, uuid, orderByComparator, true);

			array[1] = programDurationDetails;

			array[2] = getByUuid_PrevAndNext(
				session, programDurationDetails, uuid, orderByComparator,
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

	protected ProgramDurationDetails getByUuid_PrevAndNext(
		Session session, ProgramDurationDetails programDurationDetails,
		String uuid,
		OrderByComparator<ProgramDurationDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_PROGRAMDURATIONDETAILS_WHERE);

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
			sb.append(ProgramDurationDetailsModelImpl.ORDER_BY_JPQL);
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
						programDurationDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgramDurationDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the program duration detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (ProgramDurationDetails programDurationDetails :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(programDurationDetails);
		}
	}

	/**
	 * Returns the number of program duration detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching program duration detailses
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROGRAMDURATIONDETAILS_WHERE);

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
		"programDurationDetails.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(programDurationDetails.uuid IS NULL OR programDurationDetails.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the program duration details where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchProgramDurationDetailsException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching program duration details
	 * @throws NoSuchProgramDurationDetailsException if a matching program duration details could not be found
	 */
	@Override
	public ProgramDurationDetails findByUUID_G(String uuid, long groupId)
		throws NoSuchProgramDurationDetailsException {

		ProgramDurationDetails programDurationDetails = fetchByUUID_G(
			uuid, groupId);

		if (programDurationDetails == null) {
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

			throw new NoSuchProgramDurationDetailsException(sb.toString());
		}

		return programDurationDetails;
	}

	/**
	 * Returns the program duration details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching program duration details, or <code>null</code> if a matching program duration details could not be found
	 */
	@Override
	public ProgramDurationDetails fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the program duration details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching program duration details, or <code>null</code> if a matching program duration details could not be found
	 */
	@Override
	public ProgramDurationDetails fetchByUUID_G(
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

		if (result instanceof ProgramDurationDetails) {
			ProgramDurationDetails programDurationDetails =
				(ProgramDurationDetails)result;

			if (!Objects.equals(uuid, programDurationDetails.getUuid()) ||
				(groupId != programDurationDetails.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PROGRAMDURATIONDETAILS_WHERE);

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

				List<ProgramDurationDetails> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					ProgramDurationDetails programDurationDetails = list.get(0);

					result = programDurationDetails;

					cacheResult(programDurationDetails);
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
			return (ProgramDurationDetails)result;
		}
	}

	/**
	 * Removes the program duration details where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the program duration details that was removed
	 */
	@Override
	public ProgramDurationDetails removeByUUID_G(String uuid, long groupId)
		throws NoSuchProgramDurationDetailsException {

		ProgramDurationDetails programDurationDetails = findByUUID_G(
			uuid, groupId);

		return remove(programDurationDetails);
	}

	/**
	 * Returns the number of program duration detailses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching program duration detailses
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROGRAMDURATIONDETAILS_WHERE);

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
		"programDurationDetails.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(programDurationDetails.uuid IS NULL OR programDurationDetails.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"programDurationDetails.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the program duration detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching program duration detailses
	 */
	@Override
	public List<ProgramDurationDetails> findByUuid_C(
		String uuid, long companyId) {

		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the program duration detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDurationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program duration detailses
	 * @param end the upper bound of the range of program duration detailses (not inclusive)
	 * @return the range of matching program duration detailses
	 */
	@Override
	public List<ProgramDurationDetails> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the program duration detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDurationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program duration detailses
	 * @param end the upper bound of the range of program duration detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program duration detailses
	 */
	@Override
	public List<ProgramDurationDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgramDurationDetails> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the program duration detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDurationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of program duration detailses
	 * @param end the upper bound of the range of program duration detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program duration detailses
	 */
	@Override
	public List<ProgramDurationDetails> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<ProgramDurationDetails> orderByComparator,
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

		List<ProgramDurationDetails> list = null;

		if (useFinderCache) {
			list = (List<ProgramDurationDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgramDurationDetails programDurationDetails : list) {
					if (!uuid.equals(programDurationDetails.getUuid()) ||
						(companyId != programDurationDetails.getCompanyId())) {

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

			sb.append(_SQL_SELECT_PROGRAMDURATIONDETAILS_WHERE);

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
				sb.append(ProgramDurationDetailsModelImpl.ORDER_BY_JPQL);
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

				list = (List<ProgramDurationDetails>)QueryUtil.list(
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
	 * Returns the first program duration details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duration details
	 * @throws NoSuchProgramDurationDetailsException if a matching program duration details could not be found
	 */
	@Override
	public ProgramDurationDetails findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<ProgramDurationDetails> orderByComparator)
		throws NoSuchProgramDurationDetailsException {

		ProgramDurationDetails programDurationDetails = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (programDurationDetails != null) {
			return programDurationDetails;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProgramDurationDetailsException(sb.toString());
	}

	/**
	 * Returns the first program duration details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duration details, or <code>null</code> if a matching program duration details could not be found
	 */
	@Override
	public ProgramDurationDetails fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<ProgramDurationDetails> orderByComparator) {

		List<ProgramDurationDetails> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last program duration details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duration details
	 * @throws NoSuchProgramDurationDetailsException if a matching program duration details could not be found
	 */
	@Override
	public ProgramDurationDetails findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<ProgramDurationDetails> orderByComparator)
		throws NoSuchProgramDurationDetailsException {

		ProgramDurationDetails programDurationDetails = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (programDurationDetails != null) {
			return programDurationDetails;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchProgramDurationDetailsException(sb.toString());
	}

	/**
	 * Returns the last program duration details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duration details, or <code>null</code> if a matching program duration details could not be found
	 */
	@Override
	public ProgramDurationDetails fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<ProgramDurationDetails> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<ProgramDurationDetails> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the program duration detailses before and after the current program duration details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param progDurationId the primary key of the current program duration details
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program duration details
	 * @throws NoSuchProgramDurationDetailsException if a program duration details with the primary key could not be found
	 */
	@Override
	public ProgramDurationDetails[] findByUuid_C_PrevAndNext(
			long progDurationId, String uuid, long companyId,
			OrderByComparator<ProgramDurationDetails> orderByComparator)
		throws NoSuchProgramDurationDetailsException {

		uuid = Objects.toString(uuid, "");

		ProgramDurationDetails programDurationDetails = findByPrimaryKey(
			progDurationId);

		Session session = null;

		try {
			session = openSession();

			ProgramDurationDetails[] array = new ProgramDurationDetailsImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, programDurationDetails, uuid, companyId,
				orderByComparator, true);

			array[1] = programDurationDetails;

			array[2] = getByUuid_C_PrevAndNext(
				session, programDurationDetails, uuid, companyId,
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

	protected ProgramDurationDetails getByUuid_C_PrevAndNext(
		Session session, ProgramDurationDetails programDurationDetails,
		String uuid, long companyId,
		OrderByComparator<ProgramDurationDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_PROGRAMDURATIONDETAILS_WHERE);

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
			sb.append(ProgramDurationDetailsModelImpl.ORDER_BY_JPQL);
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
						programDurationDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgramDurationDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the program duration detailses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (ProgramDurationDetails programDurationDetails :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(programDurationDetails);
		}
	}

	/**
	 * Returns the number of program duration detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching program duration detailses
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROGRAMDURATIONDETAILS_WHERE);

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
		"programDurationDetails.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(programDurationDetails.uuid IS NULL OR programDurationDetails.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"programDurationDetails.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByProgramId;
	private FinderPath _finderPathWithoutPaginationFindByProgramId;
	private FinderPath _finderPathCountByProgramId;

	/**
	 * Returns all the program duration detailses where programId = &#63;.
	 *
	 * @param programId the program ID
	 * @return the matching program duration detailses
	 */
	@Override
	public List<ProgramDurationDetails> findByProgramId(long programId) {
		return findByProgramId(
			programId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the program duration detailses where programId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDurationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param programId the program ID
	 * @param start the lower bound of the range of program duration detailses
	 * @param end the upper bound of the range of program duration detailses (not inclusive)
	 * @return the range of matching program duration detailses
	 */
	@Override
	public List<ProgramDurationDetails> findByProgramId(
		long programId, int start, int end) {

		return findByProgramId(programId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the program duration detailses where programId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDurationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param programId the program ID
	 * @param start the lower bound of the range of program duration detailses
	 * @param end the upper bound of the range of program duration detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching program duration detailses
	 */
	@Override
	public List<ProgramDurationDetails> findByProgramId(
		long programId, int start, int end,
		OrderByComparator<ProgramDurationDetails> orderByComparator) {

		return findByProgramId(programId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the program duration detailses where programId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDurationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param programId the program ID
	 * @param start the lower bound of the range of program duration detailses
	 * @param end the upper bound of the range of program duration detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching program duration detailses
	 */
	@Override
	public List<ProgramDurationDetails> findByProgramId(
		long programId, int start, int end,
		OrderByComparator<ProgramDurationDetails> orderByComparator,
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

		List<ProgramDurationDetails> list = null;

		if (useFinderCache) {
			list = (List<ProgramDurationDetails>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProgramDurationDetails programDurationDetails : list) {
					if (programId != programDurationDetails.getProgramId()) {
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

			sb.append(_SQL_SELECT_PROGRAMDURATIONDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_PROGRAMID_PROGRAMID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProgramDurationDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programId);

				list = (List<ProgramDurationDetails>)QueryUtil.list(
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
	 * Returns the first program duration details in the ordered set where programId = &#63;.
	 *
	 * @param programId the program ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duration details
	 * @throws NoSuchProgramDurationDetailsException if a matching program duration details could not be found
	 */
	@Override
	public ProgramDurationDetails findByProgramId_First(
			long programId,
			OrderByComparator<ProgramDurationDetails> orderByComparator)
		throws NoSuchProgramDurationDetailsException {

		ProgramDurationDetails programDurationDetails = fetchByProgramId_First(
			programId, orderByComparator);

		if (programDurationDetails != null) {
			return programDurationDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("programId=");
		sb.append(programId);

		sb.append("}");

		throw new NoSuchProgramDurationDetailsException(sb.toString());
	}

	/**
	 * Returns the first program duration details in the ordered set where programId = &#63;.
	 *
	 * @param programId the program ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching program duration details, or <code>null</code> if a matching program duration details could not be found
	 */
	@Override
	public ProgramDurationDetails fetchByProgramId_First(
		long programId,
		OrderByComparator<ProgramDurationDetails> orderByComparator) {

		List<ProgramDurationDetails> list = findByProgramId(
			programId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last program duration details in the ordered set where programId = &#63;.
	 *
	 * @param programId the program ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duration details
	 * @throws NoSuchProgramDurationDetailsException if a matching program duration details could not be found
	 */
	@Override
	public ProgramDurationDetails findByProgramId_Last(
			long programId,
			OrderByComparator<ProgramDurationDetails> orderByComparator)
		throws NoSuchProgramDurationDetailsException {

		ProgramDurationDetails programDurationDetails = fetchByProgramId_Last(
			programId, orderByComparator);

		if (programDurationDetails != null) {
			return programDurationDetails;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("programId=");
		sb.append(programId);

		sb.append("}");

		throw new NoSuchProgramDurationDetailsException(sb.toString());
	}

	/**
	 * Returns the last program duration details in the ordered set where programId = &#63;.
	 *
	 * @param programId the program ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching program duration details, or <code>null</code> if a matching program duration details could not be found
	 */
	@Override
	public ProgramDurationDetails fetchByProgramId_Last(
		long programId,
		OrderByComparator<ProgramDurationDetails> orderByComparator) {

		int count = countByProgramId(programId);

		if (count == 0) {
			return null;
		}

		List<ProgramDurationDetails> list = findByProgramId(
			programId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the program duration detailses before and after the current program duration details in the ordered set where programId = &#63;.
	 *
	 * @param progDurationId the primary key of the current program duration details
	 * @param programId the program ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next program duration details
	 * @throws NoSuchProgramDurationDetailsException if a program duration details with the primary key could not be found
	 */
	@Override
	public ProgramDurationDetails[] findByProgramId_PrevAndNext(
			long progDurationId, long programId,
			OrderByComparator<ProgramDurationDetails> orderByComparator)
		throws NoSuchProgramDurationDetailsException {

		ProgramDurationDetails programDurationDetails = findByPrimaryKey(
			progDurationId);

		Session session = null;

		try {
			session = openSession();

			ProgramDurationDetails[] array = new ProgramDurationDetailsImpl[3];

			array[0] = getByProgramId_PrevAndNext(
				session, programDurationDetails, programId, orderByComparator,
				true);

			array[1] = programDurationDetails;

			array[2] = getByProgramId_PrevAndNext(
				session, programDurationDetails, programId, orderByComparator,
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

	protected ProgramDurationDetails getByProgramId_PrevAndNext(
		Session session, ProgramDurationDetails programDurationDetails,
		long programId,
		OrderByComparator<ProgramDurationDetails> orderByComparator,
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

		sb.append(_SQL_SELECT_PROGRAMDURATIONDETAILS_WHERE);

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
			sb.append(ProgramDurationDetailsModelImpl.ORDER_BY_JPQL);
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
						programDurationDetails)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProgramDurationDetails> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the program duration detailses where programId = &#63; from the database.
	 *
	 * @param programId the program ID
	 */
	@Override
	public void removeByProgramId(long programId) {
		for (ProgramDurationDetails programDurationDetails :
				findByProgramId(
					programId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(programDurationDetails);
		}
	}

	/**
	 * Returns the number of program duration detailses where programId = &#63;.
	 *
	 * @param programId the program ID
	 * @return the number of matching program duration detailses
	 */
	@Override
	public int countByProgramId(long programId) {
		FinderPath finderPath = _finderPathCountByProgramId;

		Object[] finderArgs = new Object[] {programId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PROGRAMDURATIONDETAILS_WHERE);

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
		"programDurationDetails.programId = ?";

	private FinderPath _finderPathFetchByProgramIdAndAYApplicableFrom;
	private FinderPath _finderPathCountByProgramIdAndAYApplicableFrom;

	/**
	 * Returns the program duration details where programId = &#63; and ayApplicableForm = &#63; or throws a <code>NoSuchProgramDurationDetailsException</code> if it could not be found.
	 *
	 * @param programId the program ID
	 * @param ayApplicableForm the ay applicable form
	 * @return the matching program duration details
	 * @throws NoSuchProgramDurationDetailsException if a matching program duration details could not be found
	 */
	@Override
	public ProgramDurationDetails findByProgramIdAndAYApplicableFrom(
			long programId, String ayApplicableForm)
		throws NoSuchProgramDurationDetailsException {

		ProgramDurationDetails programDurationDetails =
			fetchByProgramIdAndAYApplicableFrom(programId, ayApplicableForm);

		if (programDurationDetails == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("programId=");
			sb.append(programId);

			sb.append(", ayApplicableForm=");
			sb.append(ayApplicableForm);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchProgramDurationDetailsException(sb.toString());
		}

		return programDurationDetails;
	}

	/**
	 * Returns the program duration details where programId = &#63; and ayApplicableForm = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param programId the program ID
	 * @param ayApplicableForm the ay applicable form
	 * @return the matching program duration details, or <code>null</code> if a matching program duration details could not be found
	 */
	@Override
	public ProgramDurationDetails fetchByProgramIdAndAYApplicableFrom(
		long programId, String ayApplicableForm) {

		return fetchByProgramIdAndAYApplicableFrom(
			programId, ayApplicableForm, true);
	}

	/**
	 * Returns the program duration details where programId = &#63; and ayApplicableForm = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param programId the program ID
	 * @param ayApplicableForm the ay applicable form
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching program duration details, or <code>null</code> if a matching program duration details could not be found
	 */
	@Override
	public ProgramDurationDetails fetchByProgramIdAndAYApplicableFrom(
		long programId, String ayApplicableForm, boolean useFinderCache) {

		ayApplicableForm = Objects.toString(ayApplicableForm, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {programId, ayApplicableForm};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByProgramIdAndAYApplicableFrom, finderArgs,
				this);
		}

		if (result instanceof ProgramDurationDetails) {
			ProgramDurationDetails programDurationDetails =
				(ProgramDurationDetails)result;

			if ((programId != programDurationDetails.getProgramId()) ||
				!Objects.equals(
					ayApplicableForm,
					programDurationDetails.getAyApplicableForm())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_PROGRAMDURATIONDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_PROGRAMIDANDAYAPPLICABLEFROM_PROGRAMID_2);

			boolean bindAyApplicableForm = false;

			if (ayApplicableForm.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_PROGRAMIDANDAYAPPLICABLEFROM_AYAPPLICABLEFORM_3);
			}
			else {
				bindAyApplicableForm = true;

				sb.append(
					_FINDER_COLUMN_PROGRAMIDANDAYAPPLICABLEFROM_AYAPPLICABLEFORM_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programId);

				if (bindAyApplicableForm) {
					queryPos.add(ayApplicableForm);
				}

				List<ProgramDurationDetails> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByProgramIdAndAYApplicableFrom,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									programId, ayApplicableForm
								};
							}

							_log.warn(
								"ProgramDurationDetailsPersistenceImpl.fetchByProgramIdAndAYApplicableFrom(long, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ProgramDurationDetails programDurationDetails = list.get(0);

					result = programDurationDetails;

					cacheResult(programDurationDetails);
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
			return (ProgramDurationDetails)result;
		}
	}

	/**
	 * Removes the program duration details where programId = &#63; and ayApplicableForm = &#63; from the database.
	 *
	 * @param programId the program ID
	 * @param ayApplicableForm the ay applicable form
	 * @return the program duration details that was removed
	 */
	@Override
	public ProgramDurationDetails removeByProgramIdAndAYApplicableFrom(
			long programId, String ayApplicableForm)
		throws NoSuchProgramDurationDetailsException {

		ProgramDurationDetails programDurationDetails =
			findByProgramIdAndAYApplicableFrom(programId, ayApplicableForm);

		return remove(programDurationDetails);
	}

	/**
	 * Returns the number of program duration detailses where programId = &#63; and ayApplicableForm = &#63;.
	 *
	 * @param programId the program ID
	 * @param ayApplicableForm the ay applicable form
	 * @return the number of matching program duration detailses
	 */
	@Override
	public int countByProgramIdAndAYApplicableFrom(
		long programId, String ayApplicableForm) {

		ayApplicableForm = Objects.toString(ayApplicableForm, "");

		FinderPath finderPath = _finderPathCountByProgramIdAndAYApplicableFrom;

		Object[] finderArgs = new Object[] {programId, ayApplicableForm};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PROGRAMDURATIONDETAILS_WHERE);

			sb.append(_FINDER_COLUMN_PROGRAMIDANDAYAPPLICABLEFROM_PROGRAMID_2);

			boolean bindAyApplicableForm = false;

			if (ayApplicableForm.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_PROGRAMIDANDAYAPPLICABLEFROM_AYAPPLICABLEFORM_3);
			}
			else {
				bindAyApplicableForm = true;

				sb.append(
					_FINDER_COLUMN_PROGRAMIDANDAYAPPLICABLEFROM_AYAPPLICABLEFORM_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(programId);

				if (bindAyApplicableForm) {
					queryPos.add(ayApplicableForm);
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
		_FINDER_COLUMN_PROGRAMIDANDAYAPPLICABLEFROM_PROGRAMID_2 =
			"programDurationDetails.programId = ? AND ";

	private static final String
		_FINDER_COLUMN_PROGRAMIDANDAYAPPLICABLEFROM_AYAPPLICABLEFORM_2 =
			"programDurationDetails.ayApplicableForm = ?";

	private static final String
		_FINDER_COLUMN_PROGRAMIDANDAYAPPLICABLEFROM_AYAPPLICABLEFORM_3 =
			"(programDurationDetails.ayApplicableForm IS NULL OR programDurationDetails.ayApplicableForm = '')";

	public ProgramDurationDetailsPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("progDurationId", "prog_duration_id");
		dbColumnNames.put("programId", "program_id");
		dbColumnNames.put("groupId", "group_id");
		dbColumnNames.put("companyId", "company_id");
		dbColumnNames.put("createDate", "create_date");
		dbColumnNames.put("modifiedDate", "modified_date");
		dbColumnNames.put("ayApplicableForm", "ay_applicable_form");
		dbColumnNames.put("noOfBlocks", "no_of_blocks");

		setDBColumnNames(dbColumnNames);

		setModelClass(ProgramDurationDetails.class);

		setModelImplClass(ProgramDurationDetailsImpl.class);
		setModelPKClass(long.class);

		setTable(ProgramDurationDetailsTable.INSTANCE);
	}

	/**
	 * Caches the program duration details in the entity cache if it is enabled.
	 *
	 * @param programDurationDetails the program duration details
	 */
	@Override
	public void cacheResult(ProgramDurationDetails programDurationDetails) {
		entityCache.putResult(
			ProgramDurationDetailsImpl.class,
			programDurationDetails.getPrimaryKey(), programDurationDetails);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				programDurationDetails.getUuid(),
				programDurationDetails.getGroupId()
			},
			programDurationDetails);

		finderCache.putResult(
			_finderPathFetchByProgramIdAndAYApplicableFrom,
			new Object[] {
				programDurationDetails.getProgramId(),
				programDurationDetails.getAyApplicableForm()
			},
			programDurationDetails);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the program duration detailses in the entity cache if it is enabled.
	 *
	 * @param programDurationDetailses the program duration detailses
	 */
	@Override
	public void cacheResult(
		List<ProgramDurationDetails> programDurationDetailses) {

		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (programDurationDetailses.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ProgramDurationDetails programDurationDetails :
				programDurationDetailses) {

			if (entityCache.getResult(
					ProgramDurationDetailsImpl.class,
					programDurationDetails.getPrimaryKey()) == null) {

				cacheResult(programDurationDetails);
			}
		}
	}

	/**
	 * Clears the cache for all program duration detailses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProgramDurationDetailsImpl.class);

		finderCache.clearCache(ProgramDurationDetailsImpl.class);
	}

	/**
	 * Clears the cache for the program duration details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProgramDurationDetails programDurationDetails) {
		entityCache.removeResult(
			ProgramDurationDetailsImpl.class, programDurationDetails);
	}

	@Override
	public void clearCache(
		List<ProgramDurationDetails> programDurationDetailses) {

		for (ProgramDurationDetails programDurationDetails :
				programDurationDetailses) {

			entityCache.removeResult(
				ProgramDurationDetailsImpl.class, programDurationDetails);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ProgramDurationDetailsImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				ProgramDurationDetailsImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ProgramDurationDetailsModelImpl programDurationDetailsModelImpl) {

		Object[] args = new Object[] {
			programDurationDetailsModelImpl.getUuid(),
			programDurationDetailsModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, programDurationDetailsModelImpl);

		args = new Object[] {
			programDurationDetailsModelImpl.getProgramId(),
			programDurationDetailsModelImpl.getAyApplicableForm()
		};

		finderCache.putResult(
			_finderPathCountByProgramIdAndAYApplicableFrom, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByProgramIdAndAYApplicableFrom, args,
			programDurationDetailsModelImpl);
	}

	/**
	 * Creates a new program duration details with the primary key. Does not add the program duration details to the database.
	 *
	 * @param progDurationId the primary key for the new program duration details
	 * @return the new program duration details
	 */
	@Override
	public ProgramDurationDetails create(long progDurationId) {
		ProgramDurationDetails programDurationDetails =
			new ProgramDurationDetailsImpl();

		programDurationDetails.setNew(true);
		programDurationDetails.setPrimaryKey(progDurationId);

		String uuid = _portalUUID.generate();

		programDurationDetails.setUuid(uuid);

		programDurationDetails.setCompanyId(CompanyThreadLocal.getCompanyId());

		return programDurationDetails;
	}

	/**
	 * Removes the program duration details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param progDurationId the primary key of the program duration details
	 * @return the program duration details that was removed
	 * @throws NoSuchProgramDurationDetailsException if a program duration details with the primary key could not be found
	 */
	@Override
	public ProgramDurationDetails remove(long progDurationId)
		throws NoSuchProgramDurationDetailsException {

		return remove((Serializable)progDurationId);
	}

	/**
	 * Removes the program duration details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the program duration details
	 * @return the program duration details that was removed
	 * @throws NoSuchProgramDurationDetailsException if a program duration details with the primary key could not be found
	 */
	@Override
	public ProgramDurationDetails remove(Serializable primaryKey)
		throws NoSuchProgramDurationDetailsException {

		Session session = null;

		try {
			session = openSession();

			ProgramDurationDetails programDurationDetails =
				(ProgramDurationDetails)session.get(
					ProgramDurationDetailsImpl.class, primaryKey);

			if (programDurationDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProgramDurationDetailsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(programDurationDetails);
		}
		catch (NoSuchProgramDurationDetailsException noSuchEntityException) {
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
	protected ProgramDurationDetails removeImpl(
		ProgramDurationDetails programDurationDetails) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(programDurationDetails)) {
				programDurationDetails = (ProgramDurationDetails)session.get(
					ProgramDurationDetailsImpl.class,
					programDurationDetails.getPrimaryKeyObj());
			}

			if (programDurationDetails != null) {
				session.delete(programDurationDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (programDurationDetails != null) {
			clearCache(programDurationDetails);
		}

		return programDurationDetails;
	}

	@Override
	public ProgramDurationDetails updateImpl(
		ProgramDurationDetails programDurationDetails) {

		boolean isNew = programDurationDetails.isNew();

		if (!(programDurationDetails instanceof
				ProgramDurationDetailsModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(programDurationDetails.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					programDurationDetails);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in programDurationDetails proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProgramDurationDetails implementation " +
					programDurationDetails.getClass());
		}

		ProgramDurationDetailsModelImpl programDurationDetailsModelImpl =
			(ProgramDurationDetailsModelImpl)programDurationDetails;

		if (Validator.isNull(programDurationDetails.getUuid())) {
			String uuid = _portalUUID.generate();

			programDurationDetails.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (programDurationDetails.getCreateDate() == null)) {
			if (serviceContext == null) {
				programDurationDetails.setCreateDate(date);
			}
			else {
				programDurationDetails.setCreateDate(
					serviceContext.getCreateDate(date));
			}
		}

		if (!programDurationDetailsModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				programDurationDetails.setModifiedDate(date);
			}
			else {
				programDurationDetails.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(programDurationDetails);
			}
			else {
				programDurationDetails = (ProgramDurationDetails)session.merge(
					programDurationDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProgramDurationDetailsImpl.class, programDurationDetailsModelImpl,
			false, true);

		cacheUniqueFindersCache(programDurationDetailsModelImpl);

		if (isNew) {
			programDurationDetails.setNew(false);
		}

		programDurationDetails.resetOriginalValues();

		return programDurationDetails;
	}

	/**
	 * Returns the program duration details with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the program duration details
	 * @return the program duration details
	 * @throws NoSuchProgramDurationDetailsException if a program duration details with the primary key could not be found
	 */
	@Override
	public ProgramDurationDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProgramDurationDetailsException {

		ProgramDurationDetails programDurationDetails = fetchByPrimaryKey(
			primaryKey);

		if (programDurationDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProgramDurationDetailsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return programDurationDetails;
	}

	/**
	 * Returns the program duration details with the primary key or throws a <code>NoSuchProgramDurationDetailsException</code> if it could not be found.
	 *
	 * @param progDurationId the primary key of the program duration details
	 * @return the program duration details
	 * @throws NoSuchProgramDurationDetailsException if a program duration details with the primary key could not be found
	 */
	@Override
	public ProgramDurationDetails findByPrimaryKey(long progDurationId)
		throws NoSuchProgramDurationDetailsException {

		return findByPrimaryKey((Serializable)progDurationId);
	}

	/**
	 * Returns the program duration details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param progDurationId the primary key of the program duration details
	 * @return the program duration details, or <code>null</code> if a program duration details with the primary key could not be found
	 */
	@Override
	public ProgramDurationDetails fetchByPrimaryKey(long progDurationId) {
		return fetchByPrimaryKey((Serializable)progDurationId);
	}

	/**
	 * Returns all the program duration detailses.
	 *
	 * @return the program duration detailses
	 */
	@Override
	public List<ProgramDurationDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the program duration detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDurationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program duration detailses
	 * @param end the upper bound of the range of program duration detailses (not inclusive)
	 * @return the range of program duration detailses
	 */
	@Override
	public List<ProgramDurationDetails> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the program duration detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDurationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program duration detailses
	 * @param end the upper bound of the range of program duration detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of program duration detailses
	 */
	@Override
	public List<ProgramDurationDetails> findAll(
		int start, int end,
		OrderByComparator<ProgramDurationDetails> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the program duration detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProgramDurationDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of program duration detailses
	 * @param end the upper bound of the range of program duration detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of program duration detailses
	 */
	@Override
	public List<ProgramDurationDetails> findAll(
		int start, int end,
		OrderByComparator<ProgramDurationDetails> orderByComparator,
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

		List<ProgramDurationDetails> list = null;

		if (useFinderCache) {
			list = (List<ProgramDurationDetails>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PROGRAMDURATIONDETAILS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PROGRAMDURATIONDETAILS;

				sql = sql.concat(ProgramDurationDetailsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ProgramDurationDetails>)QueryUtil.list(
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
	 * Removes all the program duration detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProgramDurationDetails programDurationDetails : findAll()) {
			remove(programDurationDetails);
		}
	}

	/**
	 * Returns the number of program duration detailses.
	 *
	 * @return the number of program duration detailses
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
					_SQL_COUNT_PROGRAMDURATIONDETAILS);

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
		return "prog_duration_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PROGRAMDURATIONDETAILS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProgramDurationDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the program duration details persistence.
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

		_finderPathFetchByProgramIdAndAYApplicableFrom = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByProgramIdAndAYApplicableFrom",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"program_id", "ay_applicable_form"}, true);

		_finderPathCountByProgramIdAndAYApplicableFrom = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByProgramIdAndAYApplicableFrom",
			new String[] {Long.class.getName(), String.class.getName()},
			new String[] {"program_id", "ay_applicable_form"}, false);

		_setProgramDurationDetailsUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setProgramDurationDetailsUtilPersistence(null);

		entityCache.removeCache(ProgramDurationDetailsImpl.class.getName());
	}

	private void _setProgramDurationDetailsUtilPersistence(
		ProgramDurationDetailsPersistence programDurationDetailsPersistence) {

		try {
			Field field = ProgramDurationDetailsUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, programDurationDetailsPersistence);
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

	private static final String _SQL_SELECT_PROGRAMDURATIONDETAILS =
		"SELECT programDurationDetails FROM ProgramDurationDetails programDurationDetails";

	private static final String _SQL_SELECT_PROGRAMDURATIONDETAILS_WHERE =
		"SELECT programDurationDetails FROM ProgramDurationDetails programDurationDetails WHERE ";

	private static final String _SQL_COUNT_PROGRAMDURATIONDETAILS =
		"SELECT COUNT(programDurationDetails) FROM ProgramDurationDetails programDurationDetails";

	private static final String _SQL_COUNT_PROGRAMDURATIONDETAILS_WHERE =
		"SELECT COUNT(programDurationDetails) FROM ProgramDurationDetails programDurationDetails WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"programDurationDetails.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProgramDurationDetails exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ProgramDurationDetails exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProgramDurationDetailsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"uuid", "progDurationId", "programId", "groupId", "companyId",
			"createDate", "modifiedDate", "ayApplicableForm", "noOfBlocks"
		});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}