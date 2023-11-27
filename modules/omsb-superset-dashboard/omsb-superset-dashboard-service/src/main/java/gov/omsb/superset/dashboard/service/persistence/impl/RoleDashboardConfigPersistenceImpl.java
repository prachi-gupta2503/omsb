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

package gov.omsb.superset.dashboard.service.persistence.impl;

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

import gov.omsb.superset.dashboard.exception.NoSuchRoleDashboardConfigException;
import gov.omsb.superset.dashboard.model.RoleDashboardConfig;
import gov.omsb.superset.dashboard.model.RoleDashboardConfigTable;
import gov.omsb.superset.dashboard.model.impl.RoleDashboardConfigImpl;
import gov.omsb.superset.dashboard.model.impl.RoleDashboardConfigModelImpl;
import gov.omsb.superset.dashboard.service.persistence.RoleDashboardConfigPersistence;
import gov.omsb.superset.dashboard.service.persistence.RoleDashboardConfigUtil;
import gov.omsb.superset.dashboard.service.persistence.impl.constants.omsb_dashboardPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the role dashboard config service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = RoleDashboardConfigPersistence.class)
public class RoleDashboardConfigPersistenceImpl
	extends BasePersistenceImpl<RoleDashboardConfig>
	implements RoleDashboardConfigPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>RoleDashboardConfigUtil</code> to access the role dashboard config persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		RoleDashboardConfigImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByGroupIdAndCompanyId;
	private FinderPath _finderPathWithoutPaginationFindByGroupIdAndCompanyId;
	private FinderPath _finderPathCountByGroupIdAndCompanyId;

	/**
	 * Returns all the role dashboard configs where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching role dashboard configs
	 */
	@Override
	public List<RoleDashboardConfig> findByGroupIdAndCompanyId(
		long groupId, long companyId) {

		return findByGroupIdAndCompanyId(
			groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the role dashboard configs where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleDashboardConfigModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of role dashboard configs
	 * @param end the upper bound of the range of role dashboard configs (not inclusive)
	 * @return the range of matching role dashboard configs
	 */
	@Override
	public List<RoleDashboardConfig> findByGroupIdAndCompanyId(
		long groupId, long companyId, int start, int end) {

		return findByGroupIdAndCompanyId(groupId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the role dashboard configs where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleDashboardConfigModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of role dashboard configs
	 * @param end the upper bound of the range of role dashboard configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching role dashboard configs
	 */
	@Override
	public List<RoleDashboardConfig> findByGroupIdAndCompanyId(
		long groupId, long companyId, int start, int end,
		OrderByComparator<RoleDashboardConfig> orderByComparator) {

		return findByGroupIdAndCompanyId(
			groupId, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the role dashboard configs where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleDashboardConfigModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of role dashboard configs
	 * @param end the upper bound of the range of role dashboard configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching role dashboard configs
	 */
	@Override
	public List<RoleDashboardConfig> findByGroupIdAndCompanyId(
		long groupId, long companyId, int start, int end,
		OrderByComparator<RoleDashboardConfig> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByGroupIdAndCompanyId;
				finderArgs = new Object[] {groupId, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupIdAndCompanyId;
			finderArgs = new Object[] {
				groupId, companyId, start, end, orderByComparator
			};
		}

		List<RoleDashboardConfig> list = null;

		if (useFinderCache) {
			list = (List<RoleDashboardConfig>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RoleDashboardConfig roleDashboardConfig : list) {
					if ((groupId != roleDashboardConfig.getGroupId()) ||
						(companyId != roleDashboardConfig.getCompanyId())) {

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

			sb.append(_SQL_SELECT_ROLEDASHBOARDCONFIG_WHERE);

			sb.append(_FINDER_COLUMN_GROUPIDANDCOMPANYID_GROUPID_2);

			sb.append(_FINDER_COLUMN_GROUPIDANDCOMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RoleDashboardConfigModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(companyId);

				list = (List<RoleDashboardConfig>)QueryUtil.list(
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
	 * Returns the first role dashboard config in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role dashboard config
	 * @throws NoSuchRoleDashboardConfigException if a matching role dashboard config could not be found
	 */
	@Override
	public RoleDashboardConfig findByGroupIdAndCompanyId_First(
			long groupId, long companyId,
			OrderByComparator<RoleDashboardConfig> orderByComparator)
		throws NoSuchRoleDashboardConfigException {

		RoleDashboardConfig roleDashboardConfig =
			fetchByGroupIdAndCompanyId_First(
				groupId, companyId, orderByComparator);

		if (roleDashboardConfig != null) {
			return roleDashboardConfig;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchRoleDashboardConfigException(sb.toString());
	}

	/**
	 * Returns the first role dashboard config in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role dashboard config, or <code>null</code> if a matching role dashboard config could not be found
	 */
	@Override
	public RoleDashboardConfig fetchByGroupIdAndCompanyId_First(
		long groupId, long companyId,
		OrderByComparator<RoleDashboardConfig> orderByComparator) {

		List<RoleDashboardConfig> list = findByGroupIdAndCompanyId(
			groupId, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last role dashboard config in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role dashboard config
	 * @throws NoSuchRoleDashboardConfigException if a matching role dashboard config could not be found
	 */
	@Override
	public RoleDashboardConfig findByGroupIdAndCompanyId_Last(
			long groupId, long companyId,
			OrderByComparator<RoleDashboardConfig> orderByComparator)
		throws NoSuchRoleDashboardConfigException {

		RoleDashboardConfig roleDashboardConfig =
			fetchByGroupIdAndCompanyId_Last(
				groupId, companyId, orderByComparator);

		if (roleDashboardConfig != null) {
			return roleDashboardConfig;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchRoleDashboardConfigException(sb.toString());
	}

	/**
	 * Returns the last role dashboard config in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role dashboard config, or <code>null</code> if a matching role dashboard config could not be found
	 */
	@Override
	public RoleDashboardConfig fetchByGroupIdAndCompanyId_Last(
		long groupId, long companyId,
		OrderByComparator<RoleDashboardConfig> orderByComparator) {

		int count = countByGroupIdAndCompanyId(groupId, companyId);

		if (count == 0) {
			return null;
		}

		List<RoleDashboardConfig> list = findByGroupIdAndCompanyId(
			groupId, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the role dashboard configs before and after the current role dashboard config in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param configId the primary key of the current role dashboard config
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next role dashboard config
	 * @throws NoSuchRoleDashboardConfigException if a role dashboard config with the primary key could not be found
	 */
	@Override
	public RoleDashboardConfig[] findByGroupIdAndCompanyId_PrevAndNext(
			long configId, long groupId, long companyId,
			OrderByComparator<RoleDashboardConfig> orderByComparator)
		throws NoSuchRoleDashboardConfigException {

		RoleDashboardConfig roleDashboardConfig = findByPrimaryKey(configId);

		Session session = null;

		try {
			session = openSession();

			RoleDashboardConfig[] array = new RoleDashboardConfigImpl[3];

			array[0] = getByGroupIdAndCompanyId_PrevAndNext(
				session, roleDashboardConfig, groupId, companyId,
				orderByComparator, true);

			array[1] = roleDashboardConfig;

			array[2] = getByGroupIdAndCompanyId_PrevAndNext(
				session, roleDashboardConfig, groupId, companyId,
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

	protected RoleDashboardConfig getByGroupIdAndCompanyId_PrevAndNext(
		Session session, RoleDashboardConfig roleDashboardConfig, long groupId,
		long companyId,
		OrderByComparator<RoleDashboardConfig> orderByComparator,
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

		sb.append(_SQL_SELECT_ROLEDASHBOARDCONFIG_WHERE);

		sb.append(_FINDER_COLUMN_GROUPIDANDCOMPANYID_GROUPID_2);

		sb.append(_FINDER_COLUMN_GROUPIDANDCOMPANYID_COMPANYID_2);

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
			sb.append(RoleDashboardConfigModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						roleDashboardConfig)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RoleDashboardConfig> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the role dashboard configs where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	@Override
	public void removeByGroupIdAndCompanyId(long groupId, long companyId) {
		for (RoleDashboardConfig roleDashboardConfig :
				findByGroupIdAndCompanyId(
					groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(roleDashboardConfig);
		}
	}

	/**
	 * Returns the number of role dashboard configs where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching role dashboard configs
	 */
	@Override
	public int countByGroupIdAndCompanyId(long groupId, long companyId) {
		FinderPath finderPath = _finderPathCountByGroupIdAndCompanyId;

		Object[] finderArgs = new Object[] {groupId, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_ROLEDASHBOARDCONFIG_WHERE);

			sb.append(_FINDER_COLUMN_GROUPIDANDCOMPANYID_GROUPID_2);

			sb.append(_FINDER_COLUMN_GROUPIDANDCOMPANYID_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

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

	private static final String _FINDER_COLUMN_GROUPIDANDCOMPANYID_GROUPID_2 =
		"roleDashboardConfig.groupId = ? AND ";

	private static final String _FINDER_COLUMN_GROUPIDANDCOMPANYID_COMPANYID_2 =
		"roleDashboardConfig.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByRoleId;
	private FinderPath _finderPathWithoutPaginationFindByRoleId;
	private FinderPath _finderPathCountByRoleId;

	/**
	 * Returns all the role dashboard configs where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @return the matching role dashboard configs
	 */
	@Override
	public List<RoleDashboardConfig> findByRoleId(long roleId) {
		return findByRoleId(roleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the role dashboard configs where roleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleDashboardConfigModelImpl</code>.
	 * </p>
	 *
	 * @param roleId the role ID
	 * @param start the lower bound of the range of role dashboard configs
	 * @param end the upper bound of the range of role dashboard configs (not inclusive)
	 * @return the range of matching role dashboard configs
	 */
	@Override
	public List<RoleDashboardConfig> findByRoleId(
		long roleId, int start, int end) {

		return findByRoleId(roleId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the role dashboard configs where roleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleDashboardConfigModelImpl</code>.
	 * </p>
	 *
	 * @param roleId the role ID
	 * @param start the lower bound of the range of role dashboard configs
	 * @param end the upper bound of the range of role dashboard configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching role dashboard configs
	 */
	@Override
	public List<RoleDashboardConfig> findByRoleId(
		long roleId, int start, int end,
		OrderByComparator<RoleDashboardConfig> orderByComparator) {

		return findByRoleId(roleId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the role dashboard configs where roleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleDashboardConfigModelImpl</code>.
	 * </p>
	 *
	 * @param roleId the role ID
	 * @param start the lower bound of the range of role dashboard configs
	 * @param end the upper bound of the range of role dashboard configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching role dashboard configs
	 */
	@Override
	public List<RoleDashboardConfig> findByRoleId(
		long roleId, int start, int end,
		OrderByComparator<RoleDashboardConfig> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByRoleId;
				finderArgs = new Object[] {roleId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByRoleId;
			finderArgs = new Object[] {roleId, start, end, orderByComparator};
		}

		List<RoleDashboardConfig> list = null;

		if (useFinderCache) {
			list = (List<RoleDashboardConfig>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (RoleDashboardConfig roleDashboardConfig : list) {
					if (roleId != roleDashboardConfig.getRoleId()) {
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

			sb.append(_SQL_SELECT_ROLEDASHBOARDCONFIG_WHERE);

			sb.append(_FINDER_COLUMN_ROLEID_ROLEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(RoleDashboardConfigModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(roleId);

				list = (List<RoleDashboardConfig>)QueryUtil.list(
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
	 * Returns the first role dashboard config in the ordered set where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role dashboard config
	 * @throws NoSuchRoleDashboardConfigException if a matching role dashboard config could not be found
	 */
	@Override
	public RoleDashboardConfig findByRoleId_First(
			long roleId,
			OrderByComparator<RoleDashboardConfig> orderByComparator)
		throws NoSuchRoleDashboardConfigException {

		RoleDashboardConfig roleDashboardConfig = fetchByRoleId_First(
			roleId, orderByComparator);

		if (roleDashboardConfig != null) {
			return roleDashboardConfig;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("roleId=");
		sb.append(roleId);

		sb.append("}");

		throw new NoSuchRoleDashboardConfigException(sb.toString());
	}

	/**
	 * Returns the first role dashboard config in the ordered set where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching role dashboard config, or <code>null</code> if a matching role dashboard config could not be found
	 */
	@Override
	public RoleDashboardConfig fetchByRoleId_First(
		long roleId, OrderByComparator<RoleDashboardConfig> orderByComparator) {

		List<RoleDashboardConfig> list = findByRoleId(
			roleId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last role dashboard config in the ordered set where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role dashboard config
	 * @throws NoSuchRoleDashboardConfigException if a matching role dashboard config could not be found
	 */
	@Override
	public RoleDashboardConfig findByRoleId_Last(
			long roleId,
			OrderByComparator<RoleDashboardConfig> orderByComparator)
		throws NoSuchRoleDashboardConfigException {

		RoleDashboardConfig roleDashboardConfig = fetchByRoleId_Last(
			roleId, orderByComparator);

		if (roleDashboardConfig != null) {
			return roleDashboardConfig;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("roleId=");
		sb.append(roleId);

		sb.append("}");

		throw new NoSuchRoleDashboardConfigException(sb.toString());
	}

	/**
	 * Returns the last role dashboard config in the ordered set where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching role dashboard config, or <code>null</code> if a matching role dashboard config could not be found
	 */
	@Override
	public RoleDashboardConfig fetchByRoleId_Last(
		long roleId, OrderByComparator<RoleDashboardConfig> orderByComparator) {

		int count = countByRoleId(roleId);

		if (count == 0) {
			return null;
		}

		List<RoleDashboardConfig> list = findByRoleId(
			roleId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the role dashboard configs before and after the current role dashboard config in the ordered set where roleId = &#63;.
	 *
	 * @param configId the primary key of the current role dashboard config
	 * @param roleId the role ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next role dashboard config
	 * @throws NoSuchRoleDashboardConfigException if a role dashboard config with the primary key could not be found
	 */
	@Override
	public RoleDashboardConfig[] findByRoleId_PrevAndNext(
			long configId, long roleId,
			OrderByComparator<RoleDashboardConfig> orderByComparator)
		throws NoSuchRoleDashboardConfigException {

		RoleDashboardConfig roleDashboardConfig = findByPrimaryKey(configId);

		Session session = null;

		try {
			session = openSession();

			RoleDashboardConfig[] array = new RoleDashboardConfigImpl[3];

			array[0] = getByRoleId_PrevAndNext(
				session, roleDashboardConfig, roleId, orderByComparator, true);

			array[1] = roleDashboardConfig;

			array[2] = getByRoleId_PrevAndNext(
				session, roleDashboardConfig, roleId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected RoleDashboardConfig getByRoleId_PrevAndNext(
		Session session, RoleDashboardConfig roleDashboardConfig, long roleId,
		OrderByComparator<RoleDashboardConfig> orderByComparator,
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

		sb.append(_SQL_SELECT_ROLEDASHBOARDCONFIG_WHERE);

		sb.append(_FINDER_COLUMN_ROLEID_ROLEID_2);

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
			sb.append(RoleDashboardConfigModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(roleId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						roleDashboardConfig)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<RoleDashboardConfig> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the role dashboard configs where roleId = &#63; from the database.
	 *
	 * @param roleId the role ID
	 */
	@Override
	public void removeByRoleId(long roleId) {
		for (RoleDashboardConfig roleDashboardConfig :
				findByRoleId(
					roleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(roleDashboardConfig);
		}
	}

	/**
	 * Returns the number of role dashboard configs where roleId = &#63;.
	 *
	 * @param roleId the role ID
	 * @return the number of matching role dashboard configs
	 */
	@Override
	public int countByRoleId(long roleId) {
		FinderPath finderPath = _finderPathCountByRoleId;

		Object[] finderArgs = new Object[] {roleId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ROLEDASHBOARDCONFIG_WHERE);

			sb.append(_FINDER_COLUMN_ROLEID_ROLEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(roleId);

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

	private static final String _FINDER_COLUMN_ROLEID_ROLEID_2 =
		"roleDashboardConfig.roleId = ?";

	public RoleDashboardConfigPersistenceImpl() {
		setModelClass(RoleDashboardConfig.class);

		setModelImplClass(RoleDashboardConfigImpl.class);
		setModelPKClass(long.class);

		setTable(RoleDashboardConfigTable.INSTANCE);
	}

	/**
	 * Caches the role dashboard config in the entity cache if it is enabled.
	 *
	 * @param roleDashboardConfig the role dashboard config
	 */
	@Override
	public void cacheResult(RoleDashboardConfig roleDashboardConfig) {
		entityCache.putResult(
			RoleDashboardConfigImpl.class, roleDashboardConfig.getPrimaryKey(),
			roleDashboardConfig);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the role dashboard configs in the entity cache if it is enabled.
	 *
	 * @param roleDashboardConfigs the role dashboard configs
	 */
	@Override
	public void cacheResult(List<RoleDashboardConfig> roleDashboardConfigs) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (roleDashboardConfigs.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (RoleDashboardConfig roleDashboardConfig : roleDashboardConfigs) {
			if (entityCache.getResult(
					RoleDashboardConfigImpl.class,
					roleDashboardConfig.getPrimaryKey()) == null) {

				cacheResult(roleDashboardConfig);
			}
		}
	}

	/**
	 * Clears the cache for all role dashboard configs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(RoleDashboardConfigImpl.class);

		finderCache.clearCache(RoleDashboardConfigImpl.class);
	}

	/**
	 * Clears the cache for the role dashboard config.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(RoleDashboardConfig roleDashboardConfig) {
		entityCache.removeResult(
			RoleDashboardConfigImpl.class, roleDashboardConfig);
	}

	@Override
	public void clearCache(List<RoleDashboardConfig> roleDashboardConfigs) {
		for (RoleDashboardConfig roleDashboardConfig : roleDashboardConfigs) {
			entityCache.removeResult(
				RoleDashboardConfigImpl.class, roleDashboardConfig);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(RoleDashboardConfigImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(RoleDashboardConfigImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new role dashboard config with the primary key. Does not add the role dashboard config to the database.
	 *
	 * @param configId the primary key for the new role dashboard config
	 * @return the new role dashboard config
	 */
	@Override
	public RoleDashboardConfig create(long configId) {
		RoleDashboardConfig roleDashboardConfig = new RoleDashboardConfigImpl();

		roleDashboardConfig.setNew(true);
		roleDashboardConfig.setPrimaryKey(configId);

		roleDashboardConfig.setCompanyId(CompanyThreadLocal.getCompanyId());

		return roleDashboardConfig;
	}

	/**
	 * Removes the role dashboard config with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param configId the primary key of the role dashboard config
	 * @return the role dashboard config that was removed
	 * @throws NoSuchRoleDashboardConfigException if a role dashboard config with the primary key could not be found
	 */
	@Override
	public RoleDashboardConfig remove(long configId)
		throws NoSuchRoleDashboardConfigException {

		return remove((Serializable)configId);
	}

	/**
	 * Removes the role dashboard config with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the role dashboard config
	 * @return the role dashboard config that was removed
	 * @throws NoSuchRoleDashboardConfigException if a role dashboard config with the primary key could not be found
	 */
	@Override
	public RoleDashboardConfig remove(Serializable primaryKey)
		throws NoSuchRoleDashboardConfigException {

		Session session = null;

		try {
			session = openSession();

			RoleDashboardConfig roleDashboardConfig =
				(RoleDashboardConfig)session.get(
					RoleDashboardConfigImpl.class, primaryKey);

			if (roleDashboardConfig == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRoleDashboardConfigException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(roleDashboardConfig);
		}
		catch (NoSuchRoleDashboardConfigException noSuchEntityException) {
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
	protected RoleDashboardConfig removeImpl(
		RoleDashboardConfig roleDashboardConfig) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(roleDashboardConfig)) {
				roleDashboardConfig = (RoleDashboardConfig)session.get(
					RoleDashboardConfigImpl.class,
					roleDashboardConfig.getPrimaryKeyObj());
			}

			if (roleDashboardConfig != null) {
				session.delete(roleDashboardConfig);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (roleDashboardConfig != null) {
			clearCache(roleDashboardConfig);
		}

		return roleDashboardConfig;
	}

	@Override
	public RoleDashboardConfig updateImpl(
		RoleDashboardConfig roleDashboardConfig) {

		boolean isNew = roleDashboardConfig.isNew();

		if (!(roleDashboardConfig instanceof RoleDashboardConfigModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(roleDashboardConfig.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					roleDashboardConfig);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in roleDashboardConfig proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom RoleDashboardConfig implementation " +
					roleDashboardConfig.getClass());
		}

		RoleDashboardConfigModelImpl roleDashboardConfigModelImpl =
			(RoleDashboardConfigModelImpl)roleDashboardConfig;

		if (!roleDashboardConfigModelImpl.hasSetModifiedDate()) {
			ServiceContext serviceContext =
				ServiceContextThreadLocal.getServiceContext();

			Date date = new Date();

			if (serviceContext == null) {
				roleDashboardConfig.setModifiedDate(date);
			}
			else {
				roleDashboardConfig.setModifiedDate(
					serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(roleDashboardConfig);
			}
			else {
				roleDashboardConfig = (RoleDashboardConfig)session.merge(
					roleDashboardConfig);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			RoleDashboardConfigImpl.class, roleDashboardConfigModelImpl, false,
			true);

		if (isNew) {
			roleDashboardConfig.setNew(false);
		}

		roleDashboardConfig.resetOriginalValues();

		return roleDashboardConfig;
	}

	/**
	 * Returns the role dashboard config with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the role dashboard config
	 * @return the role dashboard config
	 * @throws NoSuchRoleDashboardConfigException if a role dashboard config with the primary key could not be found
	 */
	@Override
	public RoleDashboardConfig findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRoleDashboardConfigException {

		RoleDashboardConfig roleDashboardConfig = fetchByPrimaryKey(primaryKey);

		if (roleDashboardConfig == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRoleDashboardConfigException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return roleDashboardConfig;
	}

	/**
	 * Returns the role dashboard config with the primary key or throws a <code>NoSuchRoleDashboardConfigException</code> if it could not be found.
	 *
	 * @param configId the primary key of the role dashboard config
	 * @return the role dashboard config
	 * @throws NoSuchRoleDashboardConfigException if a role dashboard config with the primary key could not be found
	 */
	@Override
	public RoleDashboardConfig findByPrimaryKey(long configId)
		throws NoSuchRoleDashboardConfigException {

		return findByPrimaryKey((Serializable)configId);
	}

	/**
	 * Returns the role dashboard config with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param configId the primary key of the role dashboard config
	 * @return the role dashboard config, or <code>null</code> if a role dashboard config with the primary key could not be found
	 */
	@Override
	public RoleDashboardConfig fetchByPrimaryKey(long configId) {
		return fetchByPrimaryKey((Serializable)configId);
	}

	/**
	 * Returns all the role dashboard configs.
	 *
	 * @return the role dashboard configs
	 */
	@Override
	public List<RoleDashboardConfig> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the role dashboard configs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleDashboardConfigModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of role dashboard configs
	 * @param end the upper bound of the range of role dashboard configs (not inclusive)
	 * @return the range of role dashboard configs
	 */
	@Override
	public List<RoleDashboardConfig> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the role dashboard configs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleDashboardConfigModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of role dashboard configs
	 * @param end the upper bound of the range of role dashboard configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of role dashboard configs
	 */
	@Override
	public List<RoleDashboardConfig> findAll(
		int start, int end,
		OrderByComparator<RoleDashboardConfig> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the role dashboard configs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>RoleDashboardConfigModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of role dashboard configs
	 * @param end the upper bound of the range of role dashboard configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of role dashboard configs
	 */
	@Override
	public List<RoleDashboardConfig> findAll(
		int start, int end,
		OrderByComparator<RoleDashboardConfig> orderByComparator,
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

		List<RoleDashboardConfig> list = null;

		if (useFinderCache) {
			list = (List<RoleDashboardConfig>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ROLEDASHBOARDCONFIG);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ROLEDASHBOARDCONFIG;

				sql = sql.concat(RoleDashboardConfigModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<RoleDashboardConfig>)QueryUtil.list(
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
	 * Removes all the role dashboard configs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (RoleDashboardConfig roleDashboardConfig : findAll()) {
			remove(roleDashboardConfig);
		}
	}

	/**
	 * Returns the number of role dashboard configs.
	 *
	 * @return the number of role dashboard configs
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
					_SQL_COUNT_ROLEDASHBOARDCONFIG);

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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "configId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ROLEDASHBOARDCONFIG;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return RoleDashboardConfigModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the role dashboard config persistence.
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

		_finderPathWithPaginationFindByGroupIdAndCompanyId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupIdAndCompanyId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"groupId", "companyId"}, true);

		_finderPathWithoutPaginationFindByGroupIdAndCompanyId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByGroupIdAndCompanyId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"groupId", "companyId"}, true);

		_finderPathCountByGroupIdAndCompanyId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByGroupIdAndCompanyId",
			new String[] {Long.class.getName(), Long.class.getName()},
			new String[] {"groupId", "companyId"}, false);

		_finderPathWithPaginationFindByRoleId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRoleId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"roleId"}, true);

		_finderPathWithoutPaginationFindByRoleId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRoleId",
			new String[] {Long.class.getName()}, new String[] {"roleId"}, true);

		_finderPathCountByRoleId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRoleId",
			new String[] {Long.class.getName()}, new String[] {"roleId"},
			false);

		_setRoleDashboardConfigUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setRoleDashboardConfigUtilPersistence(null);

		entityCache.removeCache(RoleDashboardConfigImpl.class.getName());
	}

	private void _setRoleDashboardConfigUtilPersistence(
		RoleDashboardConfigPersistence roleDashboardConfigPersistence) {

		try {
			Field field = RoleDashboardConfigUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, roleDashboardConfigPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = omsb_dashboardPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = omsb_dashboardPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = omsb_dashboardPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_ROLEDASHBOARDCONFIG =
		"SELECT roleDashboardConfig FROM RoleDashboardConfig roleDashboardConfig";

	private static final String _SQL_SELECT_ROLEDASHBOARDCONFIG_WHERE =
		"SELECT roleDashboardConfig FROM RoleDashboardConfig roleDashboardConfig WHERE ";

	private static final String _SQL_COUNT_ROLEDASHBOARDCONFIG =
		"SELECT COUNT(roleDashboardConfig) FROM RoleDashboardConfig roleDashboardConfig";

	private static final String _SQL_COUNT_ROLEDASHBOARDCONFIG_WHERE =
		"SELECT COUNT(roleDashboardConfig) FROM RoleDashboardConfig roleDashboardConfig WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "roleDashboardConfig.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No RoleDashboardConfig exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No RoleDashboardConfig exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		RoleDashboardConfigPersistenceImpl.class);

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}