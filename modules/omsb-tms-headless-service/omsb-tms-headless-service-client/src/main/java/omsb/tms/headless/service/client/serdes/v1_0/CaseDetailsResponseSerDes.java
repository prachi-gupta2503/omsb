package omsb.tms.headless.service.client.serdes.v1_0;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

import omsb.tms.headless.service.client.dto.v1_0.CaseDetailsResponse;
import omsb.tms.headless.service.client.json.BaseJSONParser;

/**
 * @author AftabA
 * @generated
 */
@Generated("")
public class CaseDetailsResponseSerDes {

	public static CaseDetailsResponse toDTO(String json) {
		CaseDetailsResponseJSONParser caseDetailsResponseJSONParser =
			new CaseDetailsResponseJSONParser();

		return caseDetailsResponseJSONParser.parseToDTO(json);
	}

	public static CaseDetailsResponse[] toDTOs(String json) {
		CaseDetailsResponseJSONParser caseDetailsResponseJSONParser =
			new CaseDetailsResponseJSONParser();

		return caseDetailsResponseJSONParser.parseToDTOs(json);
	}

	public static String toJSON(CaseDetailsResponse caseDetailsResponse) {
		if (caseDetailsResponse == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (caseDetailsResponse.getMessage() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"message\": ");

			sb.append("\"");

			sb.append(_escape(caseDetailsResponse.getMessage()));

			sb.append("\"");
		}

		if (caseDetailsResponse.getStatus() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"status\": ");

			sb.append("\"");

			sb.append(_escape(caseDetailsResponse.getStatus()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		CaseDetailsResponseJSONParser caseDetailsResponseJSONParser =
			new CaseDetailsResponseJSONParser();

		return caseDetailsResponseJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		CaseDetailsResponse caseDetailsResponse) {

		if (caseDetailsResponse == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (caseDetailsResponse.getMessage() == null) {
			map.put("message", null);
		}
		else {
			map.put(
				"message", String.valueOf(caseDetailsResponse.getMessage()));
		}

		if (caseDetailsResponse.getStatus() == null) {
			map.put("status", null);
		}
		else {
			map.put("status", String.valueOf(caseDetailsResponse.getStatus()));
		}

		return map;
	}

	public static class CaseDetailsResponseJSONParser
		extends BaseJSONParser<CaseDetailsResponse> {

		@Override
		protected CaseDetailsResponse createDTO() {
			return new CaseDetailsResponse();
		}

		@Override
		protected CaseDetailsResponse[] createDTOArray(int size) {
			return new CaseDetailsResponse[size];
		}

		@Override
		protected void setField(
			CaseDetailsResponse caseDetailsResponse, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "message")) {
				if (jsonParserFieldValue != null) {
					caseDetailsResponse.setMessage(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "status")) {
				if (jsonParserFieldValue != null) {
					caseDetailsResponse.setStatus((String)jsonParserFieldValue);
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