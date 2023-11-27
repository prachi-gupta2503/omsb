package omsb.tms.headless.service.internal.graphql.query.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.pagination.Page;

import java.util.Map;
import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import omsb.tms.headless.service.dto.v1_0.CaseDetailsResponse;
import omsb.tms.headless.service.resource.v1_0.CaseDetailsResponseResource;

import org.osgi.service.component.ComponentServiceObjects;

/**
 * @author AftabA
 * @generated
 */
@Generated("")
public class Query {

	public static void setCaseDetailsResponseResourceComponentServiceObjects(
		ComponentServiceObjects<CaseDetailsResponseResource>
			caseDetailsResponseResourceComponentServiceObjects) {

		_caseDetailsResponseResourceComponentServiceObjects =
			caseDetailsResponseResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {data{items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField(description = "Get DataFlow Data")
	public CaseDetailsResponsePage data() throws Exception {
		return _applyComponentServiceObjects(
			_caseDetailsResponseResourceComponentServiceObjects,
			this::_populateResourceContext,
			caseDetailsResponseResource -> new CaseDetailsResponsePage(
				caseDetailsResponseResource.getData()));
	}

	@GraphQLName("CaseDetailsResponsePage")
	public class CaseDetailsResponsePage {

		public CaseDetailsResponsePage(Page caseDetailsResponsePage) {
			actions = caseDetailsResponsePage.getActions();

			items = caseDetailsResponsePage.getItems();
			lastPage = caseDetailsResponsePage.getLastPage();
			page = caseDetailsResponsePage.getPage();
			pageSize = caseDetailsResponsePage.getPageSize();
			totalCount = caseDetailsResponsePage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<CaseDetailsResponse> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(
			CaseDetailsResponseResource caseDetailsResponseResource)
		throws Exception {

		caseDetailsResponseResource.setContextAcceptLanguage(_acceptLanguage);
		caseDetailsResponseResource.setContextCompany(_company);
		caseDetailsResponseResource.setContextHttpServletRequest(
			_httpServletRequest);
		caseDetailsResponseResource.setContextHttpServletResponse(
			_httpServletResponse);
		caseDetailsResponseResource.setContextUriInfo(_uriInfo);
		caseDetailsResponseResource.setContextUser(_user);
		caseDetailsResponseResource.setGroupLocalService(_groupLocalService);
		caseDetailsResponseResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<CaseDetailsResponseResource>
		_caseDetailsResponseResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private BiFunction<Object, String, Filter> _filterBiFunction;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}