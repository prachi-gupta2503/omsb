package gov.omsb.form.builder.headless.internal.resource.v1_0;

import com.liferay.portal.vulcan.resource.OpenAPIResource;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

import java.lang.reflect.Method;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jinal Patel
 * @generated
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/openapi.properties",
	service = OpenAPIResourceImpl.class
)
@Generated("")
@OpenAPIDefinition(
	info = @Info(description = "FormBuilderHeadless REST API", license = @License(name = "Apache 2.0", url = "http://www.apache.org/licenses/LICENSE-2.0.html"), title = "FormBuilderHeadless", version = "v1.0")
)
@Path("/v1.0")
public class OpenAPIResourceImpl {

	@GET
	@Path("/openapi.{type:json|yaml}")
	@Produces({MediaType.APPLICATION_JSON, "application/yaml"})
	public Response getOpenAPI(@PathParam("type") String type)
		throws Exception {

		Class<? extends OpenAPIResource> clazz = openAPIResource.getClass();

		try {
			Method method = clazz.getMethod(
				"getOpenAPI", HttpServletRequest.class, Set.class, String.class,
				UriInfo.class);

			return (Response)method.invoke(
					openAPIResource, httpServletRequest, resourceClasses, type,
					uriInfo);
		}
		catch (NoSuchMethodException noSuchMethodException1) {
			try {
				Method method = clazz.getMethod(
					"getOpenAPI", Set.class, String.class, UriInfo.class);

				return (Response)method.invoke(
						openAPIResource, resourceClasses, type, uriInfo);
			}
			catch (NoSuchMethodException noSuchMethodException2) {
				return openAPIResource.getOpenAPI(resourceClasses, type);
			}
		}
	}

	@Context
	private HttpServletRequest httpServletRequest;

	@Reference
	private OpenAPIResource openAPIResource;

	@Context
	private UriInfo uriInfo;

	private final Set<Class<?>> resourceClasses = new HashSet<Class<?>>() {
		{
			add(DeleteFormRecordsResourceImpl.class);

			add(GetFormDataResourceImpl.class);

			add(PostFormDataResourceImpl.class);

			add(OpenAPIResourceImpl.class);
		}
	};

}