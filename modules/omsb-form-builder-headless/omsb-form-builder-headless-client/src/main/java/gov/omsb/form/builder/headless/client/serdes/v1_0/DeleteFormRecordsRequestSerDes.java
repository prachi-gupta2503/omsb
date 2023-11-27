package gov.omsb.form.builder.headless.client.serdes.v1_0;

import gov.omsb.form.builder.headless.client.dto.v1_0.DeleteFormRecordsRequest;
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
public class DeleteFormRecordsRequestSerDes {

	public static DeleteFormRecordsRequest toDTO(String json) {
		DeleteFormRecordsRequestJSONParser deleteFormRecordsRequestJSONParser =
			new DeleteFormRecordsRequestJSONParser();

		return deleteFormRecordsRequestJSONParser.parseToDTO(json);
	}

	public static DeleteFormRecordsRequest[] toDTOs(String json) {
		DeleteFormRecordsRequestJSONParser deleteFormRecordsRequestJSONParser =
			new DeleteFormRecordsRequestJSONParser();

		return deleteFormRecordsRequestJSONParser.parseToDTOs(json);
	}

	public static String toJSON(
		DeleteFormRecordsRequest deleteFormRecordsRequest) {

		if (deleteFormRecordsRequest == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (deleteFormRecordsRequest.getFormDefinitionId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"formDefinitionId\": ");

			sb.append(deleteFormRecordsRequest.getFormDefinitionId());
		}

		if (deleteFormRecordsRequest.getRecordIds() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"recordIds\": ");

			sb.append("[");

			for (int i = 0; i < deleteFormRecordsRequest.getRecordIds().length;
				 i++) {

				sb.append(deleteFormRecordsRequest.getRecordIds()[i]);

				if ((i + 1) < deleteFormRecordsRequest.getRecordIds().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		DeleteFormRecordsRequestJSONParser deleteFormRecordsRequestJSONParser =
			new DeleteFormRecordsRequestJSONParser();

		return deleteFormRecordsRequestJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(
		DeleteFormRecordsRequest deleteFormRecordsRequest) {

		if (deleteFormRecordsRequest == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (deleteFormRecordsRequest.getFormDefinitionId() == null) {
			map.put("formDefinitionId", null);
		}
		else {
			map.put(
				"formDefinitionId",
				String.valueOf(deleteFormRecordsRequest.getFormDefinitionId()));
		}

		if (deleteFormRecordsRequest.getRecordIds() == null) {
			map.put("recordIds", null);
		}
		else {
			map.put(
				"recordIds",
				String.valueOf(deleteFormRecordsRequest.getRecordIds()));
		}

		return map;
	}

	public static class DeleteFormRecordsRequestJSONParser
		extends BaseJSONParser<DeleteFormRecordsRequest> {

		@Override
		protected DeleteFormRecordsRequest createDTO() {
			return new DeleteFormRecordsRequest();
		}

		@Override
		protected DeleteFormRecordsRequest[] createDTOArray(int size) {
			return new DeleteFormRecordsRequest[size];
		}

		@Override
		protected void setField(
			DeleteFormRecordsRequest deleteFormRecordsRequest,
			String jsonParserFieldName, Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "formDefinitionId")) {
				if (jsonParserFieldValue != null) {
					deleteFormRecordsRequest.setFormDefinitionId(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "recordIds")) {
				if (jsonParserFieldValue != null) {
					deleteFormRecordsRequest.setRecordIds(
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