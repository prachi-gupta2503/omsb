package gov.omsb.form.builder.headless.client.serdes.v1_0;

import gov.omsb.form.builder.headless.client.dto.v1_0.PostFormDataRequest;
import gov.omsb.form.builder.headless.client.json.BaseJSONParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

/**
 * @author Jinal Patel
 * @generated
 */
@Generated("")
public class PostFormDataRequestSerDes {

	public static PostFormDataRequest toDTO(String json) {
		PostFormDataRequestJSONParser postFormDataRequestJSONParser =
			new PostFormDataRequestJSONParser();

		return postFormDataRequestJSONParser.parseToDTO(json);
	}

	public static PostFormDataRequest[] toDTOs(String json) {
		PostFormDataRequestJSONParser postFormDataRequestJSONParser =
			new PostFormDataRequestJSONParser();

		return postFormDataRequestJSONParser.parseToDTOs(json);
	}

	public static String toJSON(PostFormDataRequest postFormDataRequest) {
		if (postFormDataRequest == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (postFormDataRequest.getFirstName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"firstName\": ");

			sb.append("\"");

			sb.append(_escape(postFormDataRequest.getFirstName()));

			sb.append("\"");
		}

		if (postFormDataRequest.getLastName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"lastName\": ");

			sb.append("\"");

			sb.append(_escape(postFormDataRequest.getLastName()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		PostFormDataRequestJSONParser postFormDataRequestJSONParser =
			new PostFormDataRequestJSONParser();

		return postFormDataRequestJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		PostFormDataRequest postFormDataRequest) {

		if (postFormDataRequest == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (postFormDataRequest.getFirstName() == null) {
			map.put("firstName", null);
		}
		else {
			map.put(
				"firstName",
				String.valueOf(postFormDataRequest.getFirstName()));
		}

		if (postFormDataRequest.getLastName() == null) {
			map.put("lastName", null);
		}
		else {
			map.put(
				"lastName", String.valueOf(postFormDataRequest.getLastName()));
		}

		return map;
	}

	public static class PostFormDataRequestJSONParser
		extends BaseJSONParser<PostFormDataRequest> {

		@Override
		protected PostFormDataRequest createDTO() {
			return new PostFormDataRequest();
		}

		@Override
		protected PostFormDataRequest[] createDTOArray(int size) {
			return new PostFormDataRequest[size];
		}

		@Override
		protected void setField(
			PostFormDataRequest postFormDataRequest, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "firstName")) {
				if (jsonParserFieldValue != null) {
					postFormDataRequest.setFirstName(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "lastName")) {
				if (jsonParserFieldValue != null) {
					postFormDataRequest.setLastName(
						(String)jsonParserFieldValue);
				}
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\": ");

			Object value = entry.getValue();

			Class<?> valueClass = value.getClass();

			if (value instanceof Map) {
				sb.append(_toJSON((Map)value));
			}
			else if (valueClass.isArray()) {
				Object[] values = (Object[])value;

				sb.append("[");

				for (int i = 0; i < values.length; i++) {
					sb.append("\"");
					sb.append(_escape(values[i]));
					sb.append("\"");

					if ((i + 1) < values.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(entry.getValue()));
				sb.append("\"");
			}
			else {
				sb.append(String.valueOf(entry.getValue()));
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}