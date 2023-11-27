package gov.omsb.mobile.sdk.headless.client.serdes.v1_0;

import gov.omsb.mobile.sdk.headless.client.dto.v1_0.ValidateUserLoginRequest;
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
public class ValidateUserLoginRequestSerDes {

	public static ValidateUserLoginRequest toDTO(String json) {
		ValidateUserLoginRequestJSONParser validateUserLoginRequestJSONParser =
			new ValidateUserLoginRequestJSONParser();

		return validateUserLoginRequestJSONParser.parseToDTO(json);
	}

	public static ValidateUserLoginRequest[] toDTOs(String json) {
		ValidateUserLoginRequestJSONParser validateUserLoginRequestJSONParser =
			new ValidateUserLoginRequestJSONParser();

		return validateUserLoginRequestJSONParser.parseToDTOs(json);
	}

	public static String toJSON(
		ValidateUserLoginRequest validateUserLoginRequest) {

		if (validateUserLoginRequest == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (validateUserLoginRequest.getPassword() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"password\": ");

			sb.append("\"");

			sb.append(_escape(validateUserLoginRequest.getPassword()));

			sb.append("\"");
		}

		if (validateUserLoginRequest.getUserName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"userName\": ");

			sb.append("\"");

			sb.append(_escape(validateUserLoginRequest.getUserName()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ValidateUserLoginRequestJSONParser validateUserLoginRequestJSONParser =
			new ValidateUserLoginRequestJSONParser();

		return validateUserLoginRequestJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		ValidateUserLoginRequest validateUserLoginRequest) {

		if (validateUserLoginRequest == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (validateUserLoginRequest.getPassword() == null) {
			map.put("password", null);
		}
		else {
			map.put(
				"password",
				String.valueOf(validateUserLoginRequest.getPassword()));
		}

		if (validateUserLoginRequest.getUserName() == null) {
			map.put("userName", null);
		}
		else {
			map.put(
				"userName",
				String.valueOf(validateUserLoginRequest.getUserName()));
		}

		return map;
	}

	public static class ValidateUserLoginRequestJSONParser
		extends BaseJSONParser<ValidateUserLoginRequest> {

		@Override
		protected ValidateUserLoginRequest createDTO() {
			return new ValidateUserLoginRequest();
		}

		@Override
		protected ValidateUserLoginRequest[] createDTOArray(int size) {
			return new ValidateUserLoginRequest[size];
		}

		@Override
		protected void setField(
			ValidateUserLoginRequest validateUserLoginRequest,
			String jsonParserFieldName, Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "password")) {
				if (jsonParserFieldValue != null) {
					validateUserLoginRequest.setPassword(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "userName")) {
				if (jsonParserFieldValue != null) {
					validateUserLoginRequest.setUserName(
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