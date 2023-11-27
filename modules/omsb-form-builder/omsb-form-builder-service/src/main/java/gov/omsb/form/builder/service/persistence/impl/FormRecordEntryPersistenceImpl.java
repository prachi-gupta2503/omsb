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

package gov.omsb.form.builder.service.persistence.impl;

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

import gov.omsb.form.builder.exception.NoSuchFormRecordEntryException;
import gov.omsb.form.builder.model.FormRecordEntry;
import gov.omsb.form.builder.model.FormRecordEntryTable;
import gov.omsb.form.builder.model.impl.FormRecordEntryImpl;
import gov.omsb.form.builder.model.impl.FormRecordEntryModelImpl;
import gov.omsb.form.builder.service.persistence.FormRecordEntryPersistence;
import gov.omsb.form.builder.service.persistence.FormRecordEntryUtil;
import gov.omsb.form.builder.service.persistence.impl.constants.DF_FORMPersistenceConstants;

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
 * The persistence implementation for the form record entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = FormRecordEntryPersistence.class)
public class FormRecordEntryPersistenceImpl
	extends BasePersistenceImpl<FormRecordEntry>
	implements FormRecordEntryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>FormRecordEntryUtil</code> to access the form record entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		FormRecordEntryImpl.class.getName();

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
	 * Returns all the form record entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching form record entries
	 */
	@Override
	public List<FormRecordEntry> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the form record entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormRecordEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of form record entries
	 * @param end the upper bound of the range of form record entries (not inclusive)
	 * @return the range of matching form record entries
	 */
	@Override
	public List<FormRecordEntry> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the form record entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormRecordEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of form record entries
	 * @param end the upper bound of the range of form record entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching form record entries
	 */
	@Override
	public List<FormRecordEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FormRecordEntry> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the form record entries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormRecordEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of form record entries
	 * @param end the upper bound of the range of form record entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching form record entries
	 */
	@Override
	public List<FormRecordEntry> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<FormRecordEntry> orderByComparator,
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

		List<FormRecordEntry> list = null;

		if (useFinderCache) {
			list = (List<FormRecordEntry>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FormRecordEntry formRecordEntry : list) {
					if (!uuid.equals(formRecordEntry.getUuid())) {
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

			sb.append(_SQL_SELECT_FORMRECORDENTRY_WHERE);

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
				sb.append(FormRecordEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<FormRecordEntry>)QueryUtil.list(
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
	 * Returns the first form record entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form record entry
	 * @throws NoSuchFormRecordEntryException if a matching form record entry could not be found
	 */
	@Override
	public FormRecordEntry findByUuid_First(
			String uuid, OrderByComparator<FormRecordEntry> orderByComparator)
		throws NoSuchFormRecordEntryException {

		FormRecordEntry formRecordEntry = fetchByUuid_First(
			uuid, orderByComparator);

		if (formRecordEntry != null) {
			return formRecordEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFormRecordEntryException(sb.toString());
	}

	/**
	 * Returns the first form record entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form record entry, or <code>null</code> if a matching form record entry could not be found
	 */
	@Override
	public FormRecordEntry fetchByUuid_First(
		String uuid, OrderByComparator<FormRecordEntry> orderByComparator) {

		List<FormRecordEntry> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last form record entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form record entry
	 * @throws NoSuchFormRecordEntryException if a matching form record entry could not be found
	 */
	@Override
	public FormRecordEntry findByUuid_Last(
			String uuid, OrderByComparator<FormRecordEntry> orderByComparator)
		throws NoSuchFormRecordEntryException {

		FormRecordEntry formRecordEntry = fetchByUuid_Last(
			uuid, orderByComparator);

		if (formRecordEntry != null) {
			return formRecordEntry;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchFormRecordEntryException(sb.toString());
	}

	/**
	 * Returns the last form record entry in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form record entry, or <code>null</code> if a matching form record entry could not be found
	 */
	@Override
	public FormRecordEntry fetchByUuid_Last(
		String uuid, OrderByComparator<FormRecordEntry> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<FormRecordEntry> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the form record entries before and after the current form record entry in the ordered set where uuid = &#63;.
	 *
	 * @param formRecordEntryId the primary key of the current form record entry
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next form record entry
	 * @throws NoSuchFormRecordEntryException if a form record entry with the primary key could not be found
	 */
	@Override
	public FormRecordEntry[] findByUuid_PrevAndNext(
			long formRecordEntryId, String uuid,
			OrderByComparator<FormRecordEntry> orderByComparator)
		throws NoSuchFormRecordEntryException {

		uuid = Objects.toString(uuid, "");

		FormRecordEntry formRecordEntry = findByPrimaryKey(formRecordEntryId);

		Session session = null;

		try {
			session = openSession();

			FormRecordEntry[] array = new FormRecordEntryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, formRecordEntry, uuid, orderByComparator, true);

			array[1] = formRecordEntry;

			array[2] = getByUuid_PrevAndNext(
				session, formRecordEntry, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected FormRecordEntry getByUuid_PrevAndNext(
		Session session, FormRecordEntry formRecordEntry, String uuid,
		OrderByComparator<FormRecordEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_FORMRECORDENTRY_WHERE);

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
			sb.append(FormRecordEntryModelImpl.ORDER_BY_JPQL);
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
						formRecordEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FormRecordEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the form record entries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (FormRecordEntry formRecordEntry :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(formRecordEntry);
		}
	}

	/**
	 * Returns the number of form record entries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching form record entries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_FORMRECORDENTRY_WHERE);

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
		"formRecordEntry.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(formRecordEntry.uuid IS NULL OR formRecordEntry.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the form record entry where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchFormRecordEntryException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching form record entry
	 * @throws NoSuchFormRecordEntryException if a matching form record entry could not be found
	 */
	@Override
	public FormRecordEntry findByUUID_G(String uuid, long groupId)
		throws NoSuchFormRecordEntryException {

		FormRecordEntry formRecordEntry = fetchByUUID_G(uuid, groupId);

		if (formRecordEntry == null) {
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

			throw new NoSuchFormRecordEntryException(sb.toString());
		}

		return formRecordEntry;
	}

	/**
	 * Returns the form record entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching form record entry, or <code>null</code> if a matching form record entry could not be found
	 */
	@Override
	public FormRecordEntry fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the form record entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching form record entry, or <code>null</code> if a matching form record entry could not be found
	 */
	@Override
	public FormRecordEntry fetchByUUID_G(
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

		if (result instanceof FormRecordEntry) {
			FormRecordEntry formRecordEntry = (FormRecordEntry)result;

			if (!Objects.equals(uuid, formRecordEntry.getUuid()) ||
				(groupId != formRecordEntry.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_FORMRECORDENTRY_WHERE);

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

				List<FormRecordEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					FormRecordEntry formRecordEntry = list.get(0);

					result = formRecordEntry;

					cacheResult(formRecordEntry);
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
			return (FormRecordEntry)result;
		}
	}

	/**
	 * Removes the form record entry where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the form record entry that was removed
	 */
	@Override
	public FormRecordEntry removeByUUID_G(String uuid, long groupId)
		throws NoSuchFormRecordEntryException {

		FormRecordEntry formRecordEntry = findByUUID_G(uuid, groupId);

		return remove(formRecordEntry);
	}

	/**
	 * Returns the number of form record entries where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching form record entries
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FORMRECORDENTRY_WHERE);

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
		"formRecordEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(formRecordEntry.uuid IS NULL OR formRecordEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"formRecordEntry.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the form record entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching form record entries
	 */
	@Override
	public List<FormRecordEntry> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the form record entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormRecordEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of form record entries
	 * @param end the upper bound of the range of form record entries (not inclusive)
	 * @return the range of matching form record entries
	 */
	@Override
	public List<FormRecordEntry> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the form record entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormRecordEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of form record entries
	 * @param end the upper bound of the range of form record entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching form record entries
	 */
	@Override
	public List<FormRecordEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FormRecordEntry> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the form record entries where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormRecordEntryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of form record entries
	 * @param end the upper bound of the range of form record entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching form record entries
	 */
	@Override
	public List<FormRecordEntry> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<FormRecordEntry> orderByComparator,
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

		List<FormRecordEntry> list = null;

		if (useFinderCache) {
			list = (List<FormRecordEntry>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FormRecordEntry formRecordEntry : list) {
					if (!uuid.equals(formRecordEntry.getUuid()) ||
						(companyId != formRecordEntry.getCompanyId())) {

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

			sb.append(_SQL_SELECT_FORMRECORDENTRY_WHERE);

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
				sb.append(FormRecordEntryModelImpl.ORDER_BY_JPQL);
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

				list = (List<FormRecordEntry>)QueryUtil.list(
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
	 * Returns the first form record entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form record entry
	 * @throws NoSuchFormRecordEntryException if a matching form record entry could not be found
	 */
	@Override
	public FormRecordEntry findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<FormRecordEntry> orderByComparator)
		throws NoSuchFormRecordEntryException {

		FormRecordEntry formRecordEntry = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (formRecordEntry != null) {
			return formRecordEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchFormRecordEntryException(sb.toString());
	}

	/**
	 * Returns the first form record entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form record entry, or <code>null</code> if a matching form record entry could not be found
	 */
	@Override
	public FormRecordEntry fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<FormRecordEntry> orderByComparator) {

		List<FormRecordEntry> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last form record entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form record entry
	 * @throws NoSuchFormRecordEntryException if a matching form record entry could not be found
	 */
	@Override
	public FormRecordEntry findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<FormRecordEntry> orderByComparator)
		throws NoSuchFormRecordEntryException {

		FormRecordEntry formRecordEntry = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (formRecordEntry != null) {
			return formRecordEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchFormRecordEntryException(sb.toString());
	}

	/**
	 * Returns the last form record entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form record entry, or <code>null</code> if a matching form record entry could not be found
	 */
	@Override
	public FormRecordEntry fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<FormRecordEntry> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<FormRecordEntry> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the form record entries before and after the current form record entry in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param formRecordEntryId the primary key of the current form record entry
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next form record entry
	 * @throws NoSuchFormRecordEntryException if a form record entry with the primary key could not be found
	 */
	@Override
	public FormRecordEntry[] findByUuid_C_PrevAndNext(
			long formRecordEntryId, String uuid, long companyId,
			OrderByComparator<FormRecordEntry> orderByComparator)
		throws NoSuchFormRecordEntryException {

		uuid = Objects.toString(uuid, "");

		FormRecordEntry formRecordEntry = findByPrimaryKey(formRecordEntryId);

		Session session = null;

		try {
			session = openSession();

			FormRecordEntry[] array = new FormRecordEntryImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, formRecordEntry, uuid, companyId, orderByComparator,
				true);

			array[1] = formRecordEntry;

			array[2] = getByUuid_C_PrevAndNext(
				session, formRecordEntry, uuid, companyId, orderByComparator,
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

	protected FormRecordEntry getByUuid_C_PrevAndNext(
		Session session, FormRecordEntry formRecordEntry, String uuid,
		long companyId, OrderByComparator<FormRecordEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_FORMRECORDENTRY_WHERE);

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
			sb.append(FormRecordEntryModelImpl.ORDER_BY_JPQL);
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
						formRecordEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FormRecordEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the form record entries where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (FormRecordEntry formRecordEntry :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(formRecordEntry);
		}
	}

	/**
	 * Returns the number of form record entries where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching form record entries
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FORMRECORDENTRY_WHERE);

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
		"formRecordEntry.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(formRecordEntry.uuid IS NULL OR formRecordEntry.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"formRecordEntry.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByStatus;
	private FinderPath _finderPathWithoutPaginationFindByStatus;
	private FinderPath _finderPathCountByStatus;

	/**
	 * Returns all the form record entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the matching form record entries
	 */
	@Override
	public List<FormRecordEntry> findByStatus(long groupId, int status) {
		return findByStatus(
			groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the form record entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormRecordEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of form record entries
	 * @param end the upper bound of the range of form record entries (not inclusive)
	 * @return the range of matching form record entries
	 */
	@Override
	public List<FormRecordEntry> findByStatus(
		long groupId, int status, int start, int end) {

		return findByStatus(groupId, status, start, end, null);
	}

	/**
	 * Returns an ordered range of all the form record entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormRecordEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of form record entries
	 * @param end the upper bound of the range of form record entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching form record entries
	 */
	@Override
	public List<FormRecordEntry> findByStatus(
		long groupId, int status, int start, int end,
		OrderByComparator<FormRecordEntry> orderByComparator) {

		return findByStatus(
			groupId, status, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the form record entries where groupId = &#63; and status = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormRecordEntryModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param start the lower bound of the range of form record entries
	 * @param end the upper bound of the range of form record entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching form record entries
	 */
	@Override
	public List<FormRecordEntry> findByStatus(
		long groupId, int status, int start, int end,
		OrderByComparator<FormRecordEntry> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByStatus;
				finderArgs = new Object[] {groupId, status};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByStatus;
			finderArgs = new Object[] {
				groupId, status, start, end, orderByComparator
			};
		}

		List<FormRecordEntry> list = null;

		if (useFinderCache) {
			list = (List<FormRecordEntry>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (FormRecordEntry formRecordEntry : list) {
					if ((groupId != formRecordEntry.getGroupId()) ||
						(status != formRecordEntry.getStatus())) {

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

			sb.append(_SQL_SELECT_FORMRECORDENTRY_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_GROUPID_2);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(FormRecordEntryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(status);

				list = (List<FormRecordEntry>)QueryUtil.list(
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
	 * Returns the first form record entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form record entry
	 * @throws NoSuchFormRecordEntryException if a matching form record entry could not be found
	 */
	@Override
	public FormRecordEntry findByStatus_First(
			long groupId, int status,
			OrderByComparator<FormRecordEntry> orderByComparator)
		throws NoSuchFormRecordEntryException {

		FormRecordEntry formRecordEntry = fetchByStatus_First(
			groupId, status, orderByComparator);

		if (formRecordEntry != null) {
			return formRecordEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchFormRecordEntryException(sb.toString());
	}

	/**
	 * Returns the first form record entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching form record entry, or <code>null</code> if a matching form record entry could not be found
	 */
	@Override
	public FormRecordEntry fetchByStatus_First(
		long groupId, int status,
		OrderByComparator<FormRecordEntry> orderByComparator) {

		List<FormRecordEntry> list = findByStatus(
			groupId, status, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last form record entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form record entry
	 * @throws NoSuchFormRecordEntryException if a matching form record entry could not be found
	 */
	@Override
	public FormRecordEntry findByStatus_Last(
			long groupId, int status,
			OrderByComparator<FormRecordEntry> orderByComparator)
		throws NoSuchFormRecordEntryException {

		FormRecordEntry formRecordEntry = fetchByStatus_Last(
			groupId, status, orderByComparator);

		if (formRecordEntry != null) {
			return formRecordEntry;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", status=");
		sb.append(status);

		sb.append("}");

		throw new NoSuchFormRecordEntryException(sb.toString());
	}

	/**
	 * Returns the last form record entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching form record entry, or <code>null</code> if a matching form record entry could not be found
	 */
	@Override
	public FormRecordEntry fetchByStatus_Last(
		long groupId, int status,
		OrderByComparator<FormRecordEntry> orderByComparator) {

		int count = countByStatus(groupId, status);

		if (count == 0) {
			return null;
		}

		List<FormRecordEntry> list = findByStatus(
			groupId, status, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the form record entries before and after the current form record entry in the ordered set where groupId = &#63; and status = &#63;.
	 *
	 * @param formRecordEntryId the primary key of the current form record entry
	 * @param groupId the group ID
	 * @param status the status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next form record entry
	 * @throws NoSuchFormRecordEntryException if a form record entry with the primary key could not be found
	 */
	@Override
	public FormRecordEntry[] findByStatus_PrevAndNext(
			long formRecordEntryId, long groupId, int status,
			OrderByComparator<FormRecordEntry> orderByComparator)
		throws NoSuchFormRecordEntryException {

		FormRecordEntry formRecordEntry = findByPrimaryKey(formRecordEntryId);

		Session session = null;

		try {
			session = openSession();

			FormRecordEntry[] array = new FormRecordEntryImpl[3];

			array[0] = getByStatus_PrevAndNext(
				session, formRecordEntry, groupId, status, orderByComparator,
				true);

			array[1] = formRecordEntry;

			array[2] = getByStatus_PrevAndNext(
				session, formRecordEntry, groupId, status, orderByComparator,
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

	protected FormRecordEntry getByStatus_PrevAndNext(
		Session session, FormRecordEntry formRecordEntry, long groupId,
		int status, OrderByComparator<FormRecordEntry> orderByComparator,
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

		sb.append(_SQL_SELECT_FORMRECORDENTRY_WHERE);

		sb.append(_FINDER_COLUMN_STATUS_GROUPID_2);

		sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

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
			sb.append(FormRecordEntryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(status);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						formRecordEntry)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<FormRecordEntry> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the form record entries where groupId = &#63; and status = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 */
	@Override
	public void removeByStatus(long groupId, int status) {
		for (FormRecordEntry formRecordEntry :
				findByStatus(
					groupId, status, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(formRecordEntry);
		}
	}

	/**
	 * Returns the number of form record entries where groupId = &#63; and status = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @return the number of matching form record entries
	 */
	@Override
	public int countByStatus(long groupId, int status) {
		FinderPath finderPath = _finderPathCountByStatus;

		Object[] finderArgs = new Object[] {groupId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FORMRECORDENTRY_WHERE);

			sb.append(_FINDER_COLUMN_STATUS_GROUPID_2);

			sb.append(_FINDER_COLUMN_STATUS_STATUS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(status);

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

	private static final String _FINDER_COLUMN_STATUS_GROUPID_2 =
		"formRecordEntry.groupId = ? AND ";

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 =
		"formRecordEntry.status = ?";

	private FinderPath _finderPathFetchByFormDefinitionIdAndRecordId;
	private FinderPath _finderPathCountByFormDefinitionIdAndRecordId;

	/**
	 * Returns the form record entry where formDefinitionId = &#63; and recordId = &#63; or throws a <code>NoSuchFormRecordEntryException</code> if it could not be found.
	 *
	 * @param formDefinitionId the form definition ID
	 * @param recordId the record ID
	 * @return the matching form record entry
	 * @throws NoSuchFormRecordEntryException if a matching form record entry could not be found
	 */
	@Override
	public FormRecordEntry findByFormDefinitionIdAndRecordId(
			long formDefinitionId, long recordId)
		throws NoSuchFormRecordEntryException {

		FormRecordEntry formRecordEntry = fetchByFormDefinitionIdAndRecordId(
			formDefinitionId, recordId);

		if (formRecordEntry == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("formDefinitionId=");
			sb.append(formDefinitionId);

			sb.append(", recordId=");
			sb.append(recordId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchFormRecordEntryException(sb.toString());
		}

		return formRecordEntry;
	}

	/**
	 * Returns the form record entry where formDefinitionId = &#63; and recordId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param formDefinitionId the form definition ID
	 * @param recordId the record ID
	 * @return the matching form record entry, or <code>null</code> if a matching form record entry could not be found
	 */
	@Override
	public FormRecordEntry fetchByFormDefinitionIdAndRecordId(
		long formDefinitionId, long recordId) {

		return fetchByFormDefinitionIdAndRecordId(
			formDefinitionId, recordId, true);
	}

	/**
	 * Returns the form record entry where formDefinitionId = &#63; and recordId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param formDefinitionId the form definition ID
	 * @param recordId the record ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching form record entry, or <code>null</code> if a matching form record entry could not be found
	 */
	@Override
	public FormRecordEntry fetchByFormDefinitionIdAndRecordId(
		long formDefinitionId, long recordId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {formDefinitionId, recordId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByFormDefinitionIdAndRecordId, finderArgs,
				this);
		}

		if (result instanceof FormRecordEntry) {
			FormRecordEntry formRecordEntry = (FormRecordEntry)result;

			if ((formDefinitionId != formRecordEntry.getFormDefinitionId()) ||
				(recordId != formRecordEntry.getRecordId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_FORMRECORDENTRY_WHERE);

			sb.append(
				_FINDER_COLUMN_FORMDEFINITIONIDANDRECORDID_FORMDEFINITIONID_2);

			sb.append(_FINDER_COLUMN_FORMDEFINITIONIDANDRECORDID_RECORDID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(formDefinitionId);

				queryPos.add(recordId);

				List<FormRecordEntry> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByFormDefinitionIdAndRecordId,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									formDefinitionId, recordId
								};
							}

							_log.warn(
								"FormRecordEntryPersistenceImpl.fetchByFormDefinitionIdAndRecordId(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					FormRecordEntry formRecordEntry = list.get(0);

					result = formRecordEntry;

					cacheResult(formRecordEntry);
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
			return (FormRecordEntry)result;
		}
	}

	/**
	 * Removes the form record entry where formDefinitionId = &#63; and recordId = &#63; from the database.
	 *
	 * @param formDefinitionId the form definition ID
	 * @param recordId the record ID
	 * @return the form record entry that was removed
	 */
	@Override
	public FormRecordEntry removeByFormDefinitionIdAndRecordId(
			long formDefinitionId, long recordId)
		throws NoSuchFormRecordEntryException {

		FormRecordEntry formRecordEntry = findByFormDefinitionIdAndRecordId(
			formDefinitionId, recordId);

		return remove(formRecordEntry);
	}

	/**
	 * Returns the number of form record entries where formDefinitionId = &#63; and recordId = &#63;.
	 *
	 * @param formDefinitionId the form definition ID
	 * @param recordId the record ID
	 * @return the number of matching form record entries
	 */
	@Override
	public int countByFormDefinitionIdAndRecordId(
		long formDefinitionId, long recordId) {

		FinderPath finderPath = _finderPathCountByFormDefinitionIdAndRecordId;

		Object[] finderArgs = new Object[] {formDefinitionId, recordId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_FORMRECORDENTRY_WHERE);

			sb.append(
				_FINDER_COLUMN_FORMDEFINITIONIDANDRECORDID_FORMDEFINITIONID_2);

			sb.append(_FINDER_COLUMN_FORMDEFINITIONIDANDRECORDID_RECORDID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(formDefinitionId);

				queryPos.add(recordId);

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
		_FINDER_COLUMN_FORMDEFINITIONIDANDRECORDID_FORMDEFINITIONID_2 =
			"formRecordEntry.formDefinitionId = ? AND ";

	private static final String
		_FINDER_COLUMN_FORMDEFINITIONIDANDRECORDID_RECORDID_2 =
			"formRecordEntry.recordId = ?";

	public FormRecordEntryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(FormRecordEntry.class);

		setModelImplClass(FormRecordEntryImpl.class);
		setModelPKClass(long.class);

		setTable(FormRecordEntryTable.INSTANCE);
	}

	/**
	 * Caches the form record entry in the entity cache if it is enabled.
	 *
	 * @param formRecordEntry the form record entry
	 */
	@Override
	public void cacheResult(FormRecordEntry formRecordEntry) {
		entityCache.putResult(
			FormRecordEntryImpl.class, formRecordEntry.getPrimaryKey(),
			formRecordEntry);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				formRecordEntry.getUuid(), formRecordEntry.getGroupId()
			},
			formRecordEntry);

		finderCache.putResult(
			_finderPathFetchByFormDefinitionIdAndRecordId,
			new Object[] {
				formRecordEntry.getFormDefinitionId(),
				formRecordEntry.getRecordId()
			},
			formRecordEntry);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the form record entries in the entity cache if it is enabled.
	 *
	 * @param formRecordEntries the form record entries
	 */
	@Override
	public void cacheResult(List<FormRecordEntry> formRecordEntries) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (formRecordEntries.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (FormRecordEntry formRecordEntry : formRecordEntries) {
			if (entityCache.getResult(
					FormRecordEntryImpl.class,
					formRecordEntry.getPrimaryKey()) == null) {

				cacheResult(formRecordEntry);
			}
		}
	}

	/**
	 * Clears the cache for all form record entries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(FormRecordEntryImpl.class);

		finderCache.clearCache(FormRecordEntryImpl.class);
	}

	/**
	 * Clears the cache for the form record entry.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(FormRecordEntry formRecordEntry) {
		entityCache.removeResult(FormRecordEntryImpl.class, formRecordEntry);
	}

	@Override
	public void clearCache(List<FormRecordEntry> formRecordEntries) {
		for (FormRecordEntry formRecordEntry : formRecordEntries) {
			entityCache.removeResult(
				FormRecordEntryImpl.class, formRecordEntry);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FormRecordEntryImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(FormRecordEntryImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		FormRecordEntryModelImpl formRecordEntryModelImpl) {

		Object[] args = new Object[] {
			formRecordEntryModelImpl.getUuid(),
			formRecordEntryModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathCountByUUID_G, args, Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, formRecordEntryModelImpl);

		args = new Object[] {
			formRecordEntryModelImpl.getFormDefinitionId(),
			formRecordEntryModelImpl.getRecordId()
		};

		finderCache.putResult(
			_finderPathCountByFormDefinitionIdAndRecordId, args,
			Long.valueOf(1));
		finderCache.putResult(
			_finderPathFetchByFormDefinitionIdAndRecordId, args,
			formRecordEntryModelImpl);
	}

	/**
	 * Creates a new form record entry with the primary key. Does not add the form record entry to the database.
	 *
	 * @param formRecordEntryId the primary key for the new form record entry
	 * @return the new form record entry
	 */
	@Override
	public FormRecordEntry create(long formRecordEntryId) {
		FormRecordEntry formRecordEntry = new FormRecordEntryImpl();

		formRecordEntry.setNew(true);
		formRecordEntry.setPrimaryKey(formRecordEntryId);

		String uuid = _portalUUID.generate();

		formRecordEntry.setUuid(uuid);

		formRecordEntry.setCompanyId(CompanyThreadLocal.getCompanyId());

		return formRecordEntry;
	}

	/**
	 * Removes the form record entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param formRecordEntryId the primary key of the form record entry
	 * @return the form record entry that was removed
	 * @throws NoSuchFormRecordEntryException if a form record entry with the primary key could not be found
	 */
	@Override
	public FormRecordEntry remove(long formRecordEntryId)
		throws NoSuchFormRecordEntryException {

		return remove((Serializable)formRecordEntryId);
	}

	/**
	 * Removes the form record entry with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the form record entry
	 * @return the form record entry that was removed
	 * @throws NoSuchFormRecordEntryException if a form record entry with the primary key could not be found
	 */
	@Override
	public FormRecordEntry remove(Serializable primaryKey)
		throws NoSuchFormRecordEntryException {

		Session session = null;

		try {
			session = openSession();

			FormRecordEntry formRecordEntry = (FormRecordEntry)session.get(
				FormRecordEntryImpl.class, primaryKey);

			if (formRecordEntry == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchFormRecordEntryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(formRecordEntry);
		}
		catch (NoSuchFormRecordEntryException noSuchEntityException) {
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
	protected FormRecordEntry removeImpl(FormRecordEntry formRecordEntry) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(formRecordEntry)) {
				formRecordEntry = (FormRecordEntry)session.get(
					FormRecordEntryImpl.class,
					formRecordEntry.getPrimaryKeyObj());
			}

			if (formRecordEntry != null) {
				session.delete(formRecordEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (formRecordEntry != null) {
			clearCache(formRecordEntry);
		}

		return formRecordEntry;
	}

	@Override
	public FormRecordEntry updateImpl(FormRecordEntry formRecordEntry) {
		boolean isNew = formRecordEntry.isNew();

		if (!(formRecordEntry instanceof FormRecordEntryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(formRecordEntry.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					formRecordEntry);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in formRecordEntry proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom FormRecordEntry implementation " +
					formRecordEntry.getClass());
		}

		FormRecordEntryModelImpl formRecordEntryModelImpl =
			(FormRecordEntryModelImpl)formRecordEntry;

		if (Validator.isNull(formRecordEntry.getUuid())) {
			String uuid = _portalUUID.generate();

			formRecordEntry.setUuid(uuid);
		}

		if (!formRecordEntryModelImpl.hasSetModifiedDate()) {
			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			Date date = new Date();

			if (serviceContext == null) {
				formRecordEntry.setModifiedDate(date);
			}
			else {
				formRecordEntry.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(formRecordEntry);
			}
			else {
				formRecordEntry = (FormRecordEntry)session.merge(
					formRecordEntry);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			FormRecordEntryImpl.class, formRecordEntryModelImpl, false, true);

		cacheUniqueFindersCache(formRecordEntryModelImpl);

		if (isNew) {
			formRecordEntry.setNew(false);
		}

		formRecordEntry.resetOriginalValues();

		return formRecordEntry;
	}

	/**
	 * Returns the form record entry with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the form record entry
	 * @return the form record entry
	 * @throws NoSuchFormRecordEntryException if a form record entry with the primary key could not be found
	 */
	@Override
	public FormRecordEntry findByPrimaryKey(Serializable primaryKey)
		throws NoSuchFormRecordEntryException {

		FormRecordEntry formRecordEntry = fetchByPrimaryKey(primaryKey);

		if (formRecordEntry == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchFormRecordEntryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return formRecordEntry;
	}

	/**
	 * Returns the form record entry with the primary key or throws a <code>NoSuchFormRecordEntryException</code> if it could not be found.
	 *
	 * @param formRecordEntryId the primary key of the form record entry
	 * @return the form record entry
	 * @throws NoSuchFormRecordEntryException if a form record entry with the primary key could not be found
	 */
	@Override
	public FormRecordEntry findByPrimaryKey(long formRecordEntryId)
		throws NoSuchFormRecordEntryException {

		return findByPrimaryKey((Serializable)formRecordEntryId);
	}

	/**
	 * Returns the form record entry with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param formRecordEntryId the primary key of the form record entry
	 * @return the form record entry, or <code>null</code> if a form record entry with the primary key could not be found
	 */
	@Override
	public FormRecordEntry fetchByPrimaryKey(long formRecordEntryId) {
		return fetchByPrimaryKey((Serializable)formRecordEntryId);
	}

	/**
	 * Returns all the form record entries.
	 *
	 * @return the form record entries
	 */
	@Override
	public List<FormRecordEntry> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the form record entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormRecordEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of form record entries
	 * @param end the upper bound of the range of form record entries (not inclusive)
	 * @return the range of form record entries
	 */
	@Override
	public List<FormRecordEntry> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the form record entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormRecordEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of form record entries
	 * @param end the upper bound of the range of form record entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of form record entries
	 */
	@Override
	public List<FormRecordEntry> findAll(
		int start, int end,
		OrderByComparator<FormRecordEntry> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the form record entries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>FormRecordEntryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of form record entries
	 * @param end the upper bound of the range of form record entries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of form record entries
	 */
	@Override
	public List<FormRecordEntry> findAll(
		int start, int end,
		OrderByComparator<FormRecordEntry> orderByComparator,
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

		List<FormRecordEntry> list = null;

		if (useFinderCache) {
			list = (List<FormRecordEntry>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_FORMRECORDENTRY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_FORMRECORDENTRY;

				sql = sql.concat(FormRecordEntryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<FormRecordEntry>)QueryUtil.list(
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
	 * Removes all the form record entries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (FormRecordEntry formRecordEntry : findAll()) {
			remove(formRecordEntry);
		}
	}

	/**
	 * Returns the number of form record entries.
	 *
	 * @return the number of form record entries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_FORMRECORDENTRY);

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
		return "formRecordEntryId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_FORMRECORDENTRY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return FormRecordEntryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the form record entry persistence.
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
			new String[] {"uuid_", "groupId"}, true);

		_finderPathCountByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, false);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindByStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"groupId", "status"}, true);

		_finderPathWithoutPaginationFindByStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"groupId", "status"}, true);

		_finderPathCountByStatus = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] {Long.class.getName(), Integer.class.getName()},
			new String[] {"groupId", "status"}, false);

		_finderPathFetchByFormDefinitionIdAndRecordId = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByFormDefinitionIdAndRecordId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"formDefinitionId", "recordId"}, true);

		_finderPathCountByFormDefinitionIdAndRecordId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByFormDefinitionIdAndRecordId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"formDefinitionId", "recordId"}, false);

		_setFormRecordEntryUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setFormRecordEntryUtilPersistence(null);

		entityCache.removeCache(FormRecordEntryImpl.class.getName());
	}

	private void _setFormRecordEntryUtilPersistence(
		FormRecordEntryPersistence formRecordEntryPersistence) {

		try {
			Field field = FormRecordEntryUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, formRecordEntryPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = DF_FORMPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = DF_FORMPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = DF_FORMPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_FORMRECORDENTRY =
		"SELECT formRecordEntry FROM FormRecordEntry formRecordEntry";

	private static final String _SQL_SELECT_FORMRECORDENTRY_WHERE =
		"SELECT formRecordEntry FROM FormRecordEntry formRecordEntry WHERE ";

	private static final String _SQL_COUNT_FORMRECORDENTRY =
		"SELECT COUNT(formRecordEntry) FROM FormRecordEntry formRecordEntry";

	private static final String _SQL_COUNT_FORMRECORDENTRY_WHERE =
		"SELECT COUNT(formRecordEntry) FROM FormRecordEntry formRecordEntry WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "formRecordEntry.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No FormRecordEntry exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No FormRecordEntry exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		FormRecordEntryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

	@Reference
	private PortalUUID _portalUUID;

}