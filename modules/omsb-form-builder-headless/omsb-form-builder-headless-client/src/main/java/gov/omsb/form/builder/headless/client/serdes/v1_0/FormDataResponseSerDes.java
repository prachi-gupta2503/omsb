package gov.omsb.form.builder.headless.client.serdes.v1_0;

import gov.omsb.form.builder.headless.client.dto.v1_0.FormDataResponse;
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
public class FormDataResponseSerDes {

	public static FormDataResponse toDTO(String json) {
		FormDataResponseJSONParser formDataResponseJSONParser =
			new FormDataResponseJSONParser();

		return formDataResponseJSONParser.parseToDTO(json);
	}

	public static FormDataResponse[] toDTOs(String json) {
		FormDataResponseJSONParser formDataResponseJSONParser =
			new FormDataResponseJSONParser();

		return formDataResponseJSONParser.parseToDTOs(json);
	}

	public static String toJSON(FormDataResponse formDataResponse) {
		if (formDataResponse == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (formDataResponse.getData() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"data\": ");

			if (formDataResponse.getData() instanceof String) {
				sb.append("\"");
				sb.append((String)formDataResponse.getData());
				sb.append("\"");
			}
			else {
				sb.append(formDataResponse.getData());
			}
		}

		if (formDataResponse.getMessage() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"message\": ");

			sb.append("\"");

			sb.append(_escape(formDataResponse.getMessage()));

			sb.append("\"");
		}

		if (formDataResponse.getStatus() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"status\": ");

			sb.append("\"");

			sb.append(_escape(formDataResponse.getStatus()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		FormDataResponseJSONParser formDataResponseJSONParser =
			new FormDataResponseJSONParser();

		return formDataResponseJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(FormDataResponse formDataResponse) {
		if (formDataResponse == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (formDataResponse.getData() == null) {
			map.put("data", null);
		}
		else {
			map.put("data", String.valueOf(formDataResponse.getData()));
		}

		if (formDataResponse.getMessage() == null) {
			map.put("message", null);
		}
		else {
			map.put("message", String.valueOf(formDataResponse.getMessage()));
		}

		if (formDataResponse.getStatus() == null) {
			map.put("status", null);
		}
		else {
			map.put("status", String.valueOf(formDataResponse.getStatus()));
		}

		return map;
	}

	public static class FormDataResponseJSONParser
		extends BaseJSONParser<FormDataResponse> {

		@Override
		protected FormDataResponse createDTO() {
			return new FormDataResponse();
		}

		@Override
		protected FormDataResponse[] createDTOArray(int size) {
			return new FormDataResponse[size];
		}

		@Override
		protected void setField(
			FormDataResponse formDataResponse, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "data")) {
				if (jsonParserFieldValue != null) {
					formDataResponse.setData((Object)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "message")) {
				if (jsonParserFieldValue != null) {
					formDataResponse.setMessage((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "status")) {
				if (jsonParserFieldValue != null) {
					formDataResponse.setStatus((String)jsonParserFieldValue);
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