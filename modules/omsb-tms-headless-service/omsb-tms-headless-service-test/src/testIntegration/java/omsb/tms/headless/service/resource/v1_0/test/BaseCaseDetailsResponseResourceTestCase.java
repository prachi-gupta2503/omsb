package omsb.tms.headless.service.resource.v1_0.test;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;

import java.lang.reflect.Method;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

import omsb.tms.headless.service.client.dto.v1_0.CaseDetailsResponse;
import omsb.tms.headless.service.client.http.HttpInvoker;
import omsb.tms.headless.service.client.pagination.Page;
import omsb.tms.headless.service.client.resource.v1_0.CaseDetailsResponseResource;
import omsb.tms.headless.service.client.serdes.v1_0.CaseDetailsResponseSerDes;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author AftabA
 * @generated
 */
@Generated("")
public abstract class BaseCaseDetailsResponseResourceTestCase {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@BeforeClass
	public static void setUpClass() throws Exception {
		_dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

	@Before
	public void setUp() throws Exception {
		irrelevantGroup = GroupTestUtil.addGroup();
		testGroup = GroupTestUtil.addGroup();

		testCompany = CompanyLocalServiceUtil.getCompany(
			testGroup.getCompanyId());

		_caseDetailsResponseResource.setContextCompany(testCompany);

		CaseDetailsResponseResource.Builder builder =
			CaseDetailsResponseResource.builder();

		caseDetailsResponseResource = builder.authentication(
			"test@liferay.com", "test"
		).locale(
			LocaleUtil.getDefault()
		).build();
	}

	@After
	public void tearDown() throws Exception {
		GroupTestUtil.deleteGroup(irrelevantGroup);
		GroupTestUtil.deleteGroup(testGroup);
	}

	@Test
	public void testClientSerDesToDTO() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				enable(SerializationFeature.INDENT_OUTPUT);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		CaseDetailsResponse caseDetailsResponse1 = randomCaseDetailsResponse();

		String json = objectMapper.writeValueAsString(caseDetailsResponse1);

		CaseDetailsResponse caseDetailsResponse2 =
			CaseDetailsResponseSerDes.toDTO(json);

		Assert.assertTrue(equals(caseDetailsResponse1, caseDetailsResponse2));
	}

	@Test
	public void testClientSerDesToJSON() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		CaseDetailsResponse caseDetailsResponse = randomCaseDetailsResponse();

		String json1 = objectMapper.writeValueAsString(caseDetailsResponse);
		String json2 = CaseDetailsResponseSerDes.toJSON(caseDetailsResponse);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		CaseDetailsResponse caseDetailsResponse = randomCaseDetailsResponse();

		caseDetailsResponse.setMessage(regex);
		caseDetailsResponse.setStatus(regex);

		String json = CaseDetailsResponseSerDes.toJSON(caseDetailsResponse);

		Assert.assertFalse(json.contains(regex));

		caseDetailsResponse = CaseDetailsResponseSerDes.toDTO(json);

		Assert.assertEquals(regex, caseDetailsResponse.getMessage());
		Assert.assertEquals(regex, caseDetailsResponse.getStatus());
	}

	@Test
	public void testGetData() throws Exception {
		Page<CaseDetailsResponse> page = caseDetailsResponseResource.getData();

		long totalCount = page.getTotalCount();

		CaseDetailsResponse caseDetailsResponse1 =
			testGetData_addCaseDetailsResponse(randomCaseDetailsResponse());

		CaseDetailsResponse caseDetailsResponse2 =
			testGetData_addCaseDetailsResponse(randomCaseDetailsResponse());

		page = caseDetailsResponseResource.getData();

		Assert.assertEquals(totalCount + 2, page.getTotalCount());

		assertContains(
			caseDetailsResponse1, (List<CaseDetailsResponse>)page.getItems());
		assertContains(
			caseDetailsResponse2, (List<CaseDetailsResponse>)page.getItems());
		assertValid(page);
	}

	protected CaseDetailsResponse testGetData_addCaseDetailsResponse(
			CaseDetailsResponse caseDetailsResponse)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testAddData() throws Exception {
		CaseDetailsResponse randomCaseDetailsResponse =
			randomCaseDetailsResponse();

		CaseDetailsResponse postCaseDetailsResponse =
			testAddData_addCaseDetailsResponse(randomCaseDetailsResponse);

		assertEquals(randomCaseDetailsResponse, postCaseDetailsResponse);
		assertValid(postCaseDetailsResponse);
	}

	protected CaseDetailsResponse testAddData_addCaseDetailsResponse(
			CaseDetailsResponse caseDetailsResponse)
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertContains(
		CaseDetailsResponse caseDetailsResponse,
		List<CaseDetailsResponse> caseDetailsResponses) {

		boolean contains = false;

		for (CaseDetailsResponse item : caseDetailsResponses) {
			if (equals(caseDetailsResponse, item)) {
				contains = true;

				break;
			}
		}

		Assert.assertTrue(
			caseDetailsResponses + " does not contain " + caseDetailsResponse,
			contains);
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(
		CaseDetailsResponse caseDetailsResponse1,
		CaseDetailsResponse caseDetailsResponse2) {

		Assert.assertTrue(
			caseDetailsResponse1 + " does not equal " + caseDetailsResponse2,
			equals(caseDetailsResponse1, caseDetailsResponse2));
	}

	protected void assertEquals(
		List<CaseDetailsResponse> caseDetailsResponses1,
		List<CaseDetailsResponse> caseDetailsResponses2) {

		Assert.assertEquals(
			caseDetailsResponses1.size(), caseDetailsResponses2.size());

		for (int i = 0; i < caseDetailsResponses1.size(); i++) {
			CaseDetailsResponse caseDetailsResponse1 =
				caseDetailsResponses1.get(i);
			CaseDetailsResponse caseDetailsResponse2 =
				caseDetailsResponses2.get(i);

			assertEquals(caseDetailsResponse1, caseDetailsResponse2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<CaseDetailsResponse> caseDetailsResponses1,
		List<CaseDetailsResponse> caseDetailsResponses2) {

		Assert.assertEquals(
			caseDetailsResponses1.size(), caseDetailsResponses2.size());

		for (CaseDetailsResponse caseDetailsResponse1 : caseDetailsResponses1) {
			boolean contains = false;

			for (CaseDetailsResponse caseDetailsResponse2 :
					caseDetailsResponses2) {

				if (equals(caseDetailsResponse1, caseDetailsResponse2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				caseDetailsResponses2 + " does not contain " +
					caseDetailsResponse1,
				contains);
		}
	}

	protected void assertValid(CaseDetailsResponse caseDetailsResponse)
		throws Exception {

		boolean valid = true;

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("message", additionalAssertFieldName)) {
				if (caseDetailsResponse.getMessage() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("status", additionalAssertFieldName)) {
				if (caseDetailsResponse.getStatus() == null) {
					valid = false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(Page<CaseDetailsResponse> page) {
		boolean valid = false;

		java.util.Collection<CaseDetailsResponse> caseDetailsResponses =
			page.getItems();

		int size = caseDetailsResponses.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected List<GraphQLField> getGraphQLFields() throws Exception {
		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field :
				getDeclaredFields(
					omsb.tms.headless.service.dto.v1_0.CaseDetailsResponse.
						class)) {

			if (!ArrayUtil.contains(
					getAdditionalAssertFieldNames(), field.getName())) {

				continue;
			}

			graphQLFields.addAll(getGraphQLFields(field));
		}

		return graphQLFields;
	}

	protected List<GraphQLField> getGraphQLFields(
			java.lang.reflect.Field... fields)
		throws Exception {

		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (java.lang.reflect.Field field : fields) {
			com.liferay.portal.vulcan.graphql.annotation.GraphQLField
				vulcanGraphQLField = field.getAnnotation(
					com.liferay.portal.vulcan.graphql.annotation.GraphQLField.
						class);

			if (vulcanGraphQLField != null) {
				Class<?> clazz = field.getType();

				if (clazz.isArray()) {
					clazz = clazz.getComponentType();
				}

				List<GraphQLField> childrenGraphQLFields = getGraphQLFields(
					getDeclaredFields(clazz));

				graphQLFields.add(
					new GraphQLField(field.getName(), childrenGraphQLFields));
			}
		}

		return graphQLFields;
	}

	protected String[] getIgnoredEntityFieldNames() {
		return new String[0];
	}

	protected boolean equals(
		CaseDetailsResponse caseDetailsResponse1,
		CaseDetailsResponse caseDetailsResponse2) {

		if (caseDetailsResponse1 == caseDetailsResponse2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("message", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						caseDetailsResponse1.getMessage(),
						caseDetailsResponse2.getMessage())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("status", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						caseDetailsResponse1.getStatus(),
						caseDetailsResponse2.getStatus())) {

					return false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected boolean equals(
		Map<String, Object> map1, Map<String, Object> map2) {

		if (Objects.equals(map1.keySet(), map2.keySet())) {
			for (Map.Entry<String, Object> entry : map1.entrySet()) {
				if (entry.getValue() instanceof Map) {
					if (!equals(
							(Map)entry.getValue(),
							(Map)map2.get(entry.getKey()))) {

						return false;
					}
				}
				else if (!Objects.deepEquals(
							entry.getValue(), map2.get(entry.getKey()))) {

					return false;
				}
			}

			return true;
		}

		return false;
	}

	protected java.lang.reflect.Field[] getDeclaredFields(Class clazz)
		throws Exception {

		Stream<java.lang.reflect.Field> stream = Stream.of(
			ReflectionUtil.getDeclaredFields(clazz));

		return stream.filter(
			field -> !field.isSynthetic()
		).toArray(
			java.lang.reflect.Field[]::new
		);
	}

	protected java.util.Collection<EntityField> getEntityFields()
		throws Exception {

		if (!(_caseDetailsResponseResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_caseDetailsResponseResource;

		EntityModel entityModel = entityModelResource.getEntityModel(
			new MultivaluedHashMap());

		Map<String, EntityField> entityFieldsMap =
			entityModel.getEntityFieldsMap();

		return entityFieldsMap.values();
	}

	protected List<EntityField> getEntityFields(EntityField.Type type)
		throws Exception {

		java.util.Collection<EntityField> entityFields = getEntityFields();

		Stream<EntityField> stream = entityFields.stream();

		return stream.filter(
			entityField ->
				Objects.equals(entityField.getType(), type) &&
				!ArrayUtil.contains(
					getIgnoredEntityFieldNames(), entityField.getName())
		).collect(
			Collectors.toList()
		);
	}

	protected String getFilterString(
		EntityField entityField, String operator,
		CaseDetailsResponse caseDetailsResponse) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("message")) {
			sb.append("'");
			sb.append(String.valueOf(caseDetailsResponse.getMessage()));
			sb.append("'");

			return sb.toString();
		}

		if (entityFieldName.equals("status")) {
			sb.append("'");
			sb.append(String.valueOf(caseDetailsResponse.getStatus()));
			sb.append("'");

			return sb.toString();
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected String invoke(String query) throws Exception {
		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(
			JSONUtil.put(
				"query", query
			).toString(),
			"application/json");
		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);
		httpInvoker.path("http://localhost:8080/o/graphql");
		httpInvoker.userNameAndPassword("test@liferay.com:test");

		HttpInvoker.HttpResponse httpResponse = httpInvoker.invoke();

		return httpResponse.getContent();
	}

	protected JSONObject invokeGraphQLMutation(GraphQLField graphQLField)
		throws Exception {

		GraphQLField mutationGraphQLField = new GraphQLField(
			"mutation", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(mutationGraphQLField.toString()));
	}

	protected JSONObject invokeGraphQLQuery(GraphQLField graphQLField)
		throws Exception {

		GraphQLField queryGraphQLField = new GraphQLField(
			"query", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(queryGraphQLField.toString()));
	}

	protected CaseDetailsResponse randomCaseDetailsResponse() throws Exception {
		return new CaseDetailsResponse() {
			{
				message = StringUtil.toLowerCase(RandomTestUtil.randomString());
				status = StringUtil.toLowerCase(RandomTestUtil.randomString());
			}
		};
	}

	protected CaseDetailsResponse randomIrrelevantCaseDetailsResponse()
		throws Exception {

		CaseDetailsResponse randomIrrelevantCaseDetailsResponse =
			randomCaseDetailsResponse();

		return randomIrrelevantCaseDetailsResponse;
	}

	protected CaseDetailsResponse randomPatchCaseDetailsResponse()
		throws Exception {

		return randomCaseDetailsResponse();
	}

	protected CaseDetailsResponseResource caseDetailsResponseResource;
	protected Group irrelevantGroup;
	protected Company testCompany;
	protected Group testGroup;

	protected static class BeanTestUtil {

		public static void copyProperties(Object source, Object target)
			throws Exception {

			Class<?> sourceClass = _getSuperClass(source.getClass());

			Class<?> targetClass = target.getClass();

			for (java.lang.reflect.Field field :
					sourceClass.getDeclaredFields()) {

				if (field.isSynthetic()) {
					continue;
				}

				Method getMethod = _getMethod(
					sourceClass, field.getName(), "get");

				Method setMethod = _getMethod(
					targetClass, field.getName(), "set",
					getMethod.getReturnType());

				setMethod.invoke(target, getMethod.invoke(source));
			}
		}

		public static boolean hasProperty(Object bean, String name) {
			Method setMethod = _getMethod(
				bean.getClass(), "set" + StringUtil.upperCaseFirstLetter(name));

			if (setMethod != null) {
				return true;
			}

			return false;
		}

		public static void setProperty(Object bean, String name, Object value)
			throws Exception {

			Class<?> clazz = bean.getClass();

			Method setMethod = _getMethod(
				clazz, "set" + StringUtil.upperCaseFirstLetter(name));

			if (setMethod == null) {
				throw new NoSuchMethodException();
			}

			Class<?>[] parameterTypes = setMethod.getParameterTypes();

			setMethod.invoke(bean, _translateValue(parameterTypes[0], value));
		}

		private static Method _getMethod(Class<?> clazz, String name) {
			for (Method method : clazz.getMethods()) {
				if (name.equals(method.getName()) &&
					(method.getParameterCount() == 1) &&
					_parameterTypes.contains(method.getParameterTypes()[0])) {

					return method;
				}
			}

			return null;
		}

		private static Method _getMethod(
				Class<?> clazz, String fieldName, String prefix,
				Class<?>... parameterTypes)
			throws Exception {

			return clazz.getMethod(
				prefix + StringUtil.upperCaseFirstLetter(fieldName),
				parameterTypes);
		}

		private static Class<?> _getSuperClass(Class<?> clazz) {
			Class<?> superClass = clazz.getSuperclass();

			if ((superClass == null) || (superClass == Object.class)) {
				return clazz;
			}

			return superClass;
		}

		private static Object _translateValue(
			Class<?> parameterType, Object value) {

			if ((value instanceof Integer) &&
				parameterType.equals(Long.class)) {

				Integer intValue = (Integer)value;

				return intValue.longValue();
			}

			return value;
		}

		private static final Set<Class<?>> _parameterTypes = new HashSet<>(
			Arrays.asList(
				Boolean.class, Date.class, Double.class, Integer.class,
				Long.class, Map.class, String.class));

	}

	protected class GraphQLField {

		public GraphQLField(String key, GraphQLField... graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(String key, List<GraphQLField> graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			GraphQLField... graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = Arrays.asList(graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			List<GraphQLField> graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = graphQLFields;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder(_key);

			if (!_parameterMap.isEmpty()) {
				sb.append("(");

				for (Map.Entry<String, Object> entry :
						_parameterMap.entrySet()) {

					sb.append(entry.getKey());
					sb.append(": ");
					sb.append(entry.getValue());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append(")");
			}

			if (!_graphQLFields.isEmpty()) {
				sb.append("{");

				for (GraphQLField graphQLField : _graphQLFields) {
					sb.append(graphQLField.toString());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append("}");
			}

			return sb.toString();
		}

		private final List<GraphQLField> _graphQLFields;
		private final String _key;
		private final Map<String, Object> _parameterMap;

	}

	private static final com.liferay.portal.kernel.log.Log _log =
		LogFactoryUtil.getLog(BaseCaseDetailsResponseResourceTestCase.class);

	private static DateFormat _dateFormat;

	@Inject
	private omsb.tms.headless.service.resource.v1_0.CaseDetailsResponseResource
		_caseDetailsResponseResource;

}