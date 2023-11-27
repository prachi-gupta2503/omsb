package gov.omsb.mobile.sdk.headless.client.serdes.v1_0;

import gov.omsb.mobile.sdk.headless.client.dto.v1_0.Response;
import gov.omsb.mobile.sdk.headless.client.json.BaseJSONParser;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

/**
 * @author Niddhi Thacker
 * @generated
 */
@Generated("")
public class ResponseSerDes {

	public static Response toDTO(String json) {
		ResponseJSONParser responseJSONParser = new ResponseJSONParser();

		return responseJSONParser.parseToDTO(json);
	}

	public static Response[] toDTOs(String json) {
		ResponseJSONParser responseJSONParser = new ResponseJSONParser();

		return responseJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Response response) {
		if (response == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (response.getData() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"data\": ");

			if (response.getData() instanceof String) {
				sb.append("\"");
				sb.append((String)response.getData());
				sb.append("\"");
			}
			else {
				sb.append(response.getData());
			}
		}

		if (response.getMessage() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"message\": ");

			sb.append("\"");

			sb.append(_escape(response.getMessage()));

			sb.append("\"");
		}

		if (response.getStatus() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"status\": ");

			sb.append("\"");

			sb.append(_escape(response.getStatus()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ResponseJSONParser responseJSONParser = new ResponseJSONParser();

		return responseJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Response response) {
		if (response == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (response.getData() == null) {
			map.put("data", null);
		}
		else {
			map.put("data", String.valueOf(response.getData()));
		}

		if (response.getMessage() == null) {
			map.put("message", null);
		}
		else {
			map.put("message", String.valueOf(response.getMessage()));
		}

		if (response.getStatus() == null) {
			map.put("status", null);
		}
		else {
			map.put("status", String.valueOf(response.getStatus()));
		}

		return map;
	}

	public static class ResponseJSONParser extends BaseJSONParser<Response> {

		@Override
		protected Response createDTO() {
			return new Response();
		}

		@Override
		protected Response[] createDTOArray(int size) {
			return new Response[size];
		}

		@Override
		protected void setField(
			Response response, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "data")) {
				if (jsonParserFieldValue != null) {
					response.setData((Object)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "message")) {
				if (jsonParserFieldValue != null) {
					response.setMessage((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "status")) {
				if (jsonParserFieldValue != null) {
					response.setStatus((String)jsonParserFieldValue);
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