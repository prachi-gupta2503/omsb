package omsb.tms.headless.service.client.serdes.v1_0;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

import omsb.tms.headless.service.client.dto.v1_0.CaseDetails;
import omsb.tms.headless.service.client.json.BaseJSONParser;

/**
 * @author AftabA
 * @generated
 */
@Generated("")
public class CaseDetailsSerDes {

	public static CaseDetails toDTO(String json) {
		CaseDetailsJSONParser caseDetailsJSONParser =
			new CaseDetailsJSONParser();

		return caseDetailsJSONParser.parseToDTO(json);
	}

	public static CaseDetails[] toDTOs(String json) {
		CaseDetailsJSONParser caseDetailsJSONParser =
			new CaseDetailsJSONParser();

		return caseDetailsJSONParser.parseToDTOs(json);
	}

	public static String toJSON(CaseDetails caseDetails) {
		if (caseDetails == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (caseDetails.getCaseNumber() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"caseNumber\": ");

			sb.append("\"");

			sb.append(_escape(caseDetails.getCaseNumber()));

			sb.append("\"");
		}

		if (caseDetails.getCaseTypeId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"caseTypeId\": ");

			sb.append(caseDetails.getCaseTypeId());
		}

		if (caseDetails.getCrn() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"crn\": ");

			sb.append("\"");

			sb.append(_escape(caseDetails.getCrn()));

			sb.append("\"");
		}

		if (caseDetails.getMessage() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"message\": ");

			sb.append("\"");

			sb.append(_escape(caseDetails.getMessage()));

			sb.append("\"");
		}

		if (caseDetails.getStageId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"stageId\": ");

			sb.append("\"");

			sb.append(_escape(caseDetails.getStageId()));

			sb.append("\"");
		}

		if (caseDetails.getStatusId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"statusId\": ");

			sb.append(caseDetails.getStatusId());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		CaseDetailsJSONParser caseDetailsJSONParser =
			new CaseDetailsJSONParser();

		return caseDetailsJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(CaseDetails caseDetails) {
		if (caseDetails == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (caseDetails.getCaseNumber() == null) {
			map.put("caseNumber", null);
		}
		else {
			map.put("caseNumber", String.valueOf(caseDetails.getCaseNumber()));
		}

		if (caseDetails.getCaseTypeId() == null) {
			map.put("caseTypeId", null);
		}
		else {
			map.put("caseTypeId", String.valueOf(caseDetails.getCaseTypeId()));
		}

		if (caseDetails.getCrn() == null) {
			map.put("crn", null);
		}
		else {
			map.put("crn", String.valueOf(caseDetails.getCrn()));
		}

		if (caseDetails.getMessage() == null) {
			map.put("message", null);
		}
		else {
			map.put("message", String.valueOf(caseDetails.getMessage()));
		}

		if (caseDetails.getStageId() == null) {
			map.put("stageId", null);
		}
		else {
			map.put("stageId", String.valueOf(caseDetails.getStageId()));
		}

		if (caseDetails.getStatusId() == null) {
			map.put("statusId", null);
		}
		else {
			map.put("statusId", String.valueOf(caseDetails.getStatusId()));
		}

		return map;
	}

	public static class CaseDetailsJSONParser
		extends BaseJSONParser<CaseDetails> {

		@Override
		protected CaseDetails createDTO() {
			return new CaseDetails();
		}

		@Override
		protected CaseDetails[] createDTOArray(int size) {
			return new CaseDetails[size];
		}

		@Override
		protected void setField(
			CaseDetails caseDetails, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "caseNumber")) {
				if (jsonParserFieldValue != null) {
					caseDetails.setCaseNumber((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "caseTypeId")) {
				if (jsonParserFieldValue != null) {
					caseDetails.setCaseTypeId(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "crn")) {
				if (jsonParserFieldValue != null) {
					caseDetails.setCrn((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "message")) {
				if (jsonParserFieldValue != null) {
					caseDetails.setMessage((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "stageId")) {
				if (jsonParserFieldValue != null) {
					caseDetails.setStageId((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "statusId")) {
				if (jsonParserFieldValue != null) {
					caseDetails.setStatusId(
						Integer.valueOf((String)jsonParserFieldValue));
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