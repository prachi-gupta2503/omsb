package gov.omsb.form.builder.headless.client.serdes.v1_0;

import gov.omsb.form.builder.headless.client.dto.v1_0.FormDataRequest;
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
public class FormDataRequestSerDes {

	public static FormDataRequest toDTO(String json) {
		FormDataRequestJSONParser formDataRequestJSONParser =
			new FormDataRequestJSONParser();

		return formDataRequestJSONParser.parseToDTO(json);
	}

	public static FormDataRequest[] toDTOs(String json) {
		FormDataRequestJSONParser formDataRequestJSONParser =
			new FormDataRequestJSONParser();

		return formDataRequestJSONParser.parseToDTOs(json);
	}

	public static String toJSON(FormDataRequest formDataRequest) {
		if (formDataRequest == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (formDataRequest.getFormDefinitionIds() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"formDefinitionIds\": ");

			sb.append("[");

			for (int i = 0; i < formDataRequest.getFormDefinitionIds().length;
				 i++) {

				sb.append(formDataRequest.getFormDefinitionIds()[i]);

				if ((i + 1) < formDataRequest.getFormDefinitionIds().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (formDataRequest.getRecordIds() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"recordIds\": ");

			sb.append("[");

			for (int i = 0; i < formDataRequest.getRecordIds().length; i++) {
				sb.append(formDataRequest.getRecordIds()[i]);

				if ((i + 1) < formDataRequest.getRecordIds().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		FormDataRequestJSONParser formDataRequestJSONParser =
			new FormDataRequestJSONParser();

		return formDataRequestJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(FormDataRequest formDataRequest) {
		if (formDataRequest == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (formDataRequest.getFormDefinitionIds() == null) {
			map.put("formDefinitionIds", null);
		}
		else {
			map.put(
				"formDefinitionIds",
				String.valueOf(formDataRequest.getFormDefinitionIds()));
		}

		if (formDataRequest.getRecordIds() == null) {
			map.put("recordIds", null);
		}
		else {
			map.put(
				"recordIds", String.valueOf(formDataRequest.getRecordIds()));
		}

		return map;
	}

	public static class FormDataRequestJSONParser
		extends BaseJSONParser<FormDataRequest> {

		@Override
		protected FormDataRequest createDTO() {
			return new FormDataRequest();
		}

		@Override
		protected FormDataRequest[] createDTOArray(int size) {
			return new FormDataRequest[size];
		}

		@Override
		protected void setField(
			FormDataRequest formDataRequest, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "formDefinitionIds")) {
				if (jsonParserFieldValue != null) {
					formDataRequest.setFormDefinitionIds(
						toLongs((Object[])jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "recordIds")) {
				if (jsonParserFieldValue != null) {
					formDataRequest.setRecordIds(
						toLongs((Object[])jsonParserFieldValue));
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