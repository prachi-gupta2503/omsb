package omsb.tms.headless.service.internal.graphql.servlet.v1_0;

import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import javax.annotation.Generated;

import omsb.tms.headless.service.internal.graphql.mutation.v1_0.Mutation;
import omsb.tms.headless.service.internal.graphql.query.v1_0.Query;
import omsb.tms.headless.service.resource.v1_0.CaseDetailsResponseResource;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

/**
 * @author AftabA
 * @generated
 */
@Component(immediate = true, service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Mutation.setCaseDetailsResponseResourceComponentServiceObjects(
			_caseDetailsResponseResourceComponentServiceObjects);

		Query.setCaseDetailsResponseResourceComponentServiceObjects(
			_caseDetailsResponseResourceComponentServiceObjects);
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/eportal-service-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<CaseDetailsResponseResource>
		_caseDetailsResponseResourceComponentServiceObjects;

}