package omsb.tms.headless.service.dto.v1_0;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.util.ObjectMapperUtil;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author AftabA
 * @generated
 */
@Generated("")
@GraphQLName(
	description = "To get the Data Flow Case Number.", value = "CaseDetails"
)
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "CaseDetails")
public class CaseDetails implements Serializable {

	public static CaseDetails toDTO(String json) {
		return ObjectMapperUtil.readValue(CaseDetails.class, json);
	}

	public static CaseDetails unsafeToDTO(String json) {
		return ObjectMapperUtil.unsafeReadValue(CaseDetails.class, json);
	}

	@Schema(description = "example O004-2022-16022022")
	public String getCaseNumber() {
		return caseNumber;
	}

	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}

	@JsonIgnore
	public void setCaseNumber(
		UnsafeSupplier<String, Exception> caseNumberUnsafeSupplier) {

		try {
			caseNumber = caseNumberUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "example O004-2022-16022022")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String caseNumber;

	@Schema(description = "The caseTypeId.")
	public Integer getCaseTypeId() {
		return caseTypeId;
	}

	public void setCaseTypeId(Integer caseTypeId) {
		this.caseTypeId = caseTypeId;
	}

	@JsonIgnore
	public void setCaseTypeId(
		UnsafeSupplier<Integer, Exception> caseTypeIdUnsafeSupplier) {

		try {
			caseTypeId = caseTypeIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The caseTypeId.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Integer caseTypeId;

	@Schema(description = "example CRN-2208-109540")
	public String getCrn() {
		return crn;
	}

	public void setCrn(String crn) {
		this.crn = crn;
	}

	@JsonIgnore
	public void setCrn(UnsafeSupplier<String, Exception> crnUnsafeSupplier) {
		try {
			crn = crnUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "example CRN-2208-109540")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String crn;

	@Schema(description = "The message.")
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@JsonIgnore
	public void setMessage(
		UnsafeSupplier<String, Exception> messageUnsafeSupplier) {

		try {
			message = messageUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The message.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String message;

	@Schema(description = "The stageId.")
	public String getStageId() {
		return stageId;
	}

	public void setStageId(String stageId) {
		this.stageId = stageId;
	}

	@JsonIgnore
	public void setStageId(
		UnsafeSupplier<String, Exception> stageIdUnsafeSupplier) {

		try {
			stageId = stageIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The stageId.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected String stageId;

	@Schema(description = "The status Id.")
	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	@JsonIgnore
	public void setStatusId(
		UnsafeSupplier<Integer, Exception> statusIdUnsafeSupplier) {

		try {
			statusId = statusIdUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The status Id.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Integer statusId;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CaseDetails)) {
			return false;
		}

		CaseDetails caseDetails = (CaseDetails)object;

		return Objects.equals(toString(), caseDetails.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (caseNumber != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"caseNumber\": ");

			sb.append("\"");

			sb.append(_escape(caseNumber));

			sb.append("\"");
		}

		if (caseTypeId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"caseTypeId\": ");

			sb.append(caseTypeId);
		}

		if (crn != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"crn\": ");

			sb.append("\"");

			sb.append(_escape(crn));

			sb.append("\"");
		}

		if (message != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"message\": ");

			sb.append("\"");

			sb.append(_escape(message));

			sb.append("\"");
		}

		if (stageId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"stageId\": ");

			sb.append("\"");

			sb.append(_escape(stageId));

			sb.append("\"");
		}

		if (statusId != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"statusId\": ");

			sb.append(statusId);
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "omsb.tms.headless.service.dto.v1_0.CaseDetails",
		name = "x-class-name"
	)
	public String xClassName;

	private static String _escape(Object object) {
		return StringUtil.replace(
			String.valueOf(object), _JSON_ESCAPE_STRINGS[0],
			_JSON_ESCAPE_STRINGS[1]);
	}

	private static boolean _isArray(Object value) {
		if (value == null) {
			return false;
		}

		Class<?> clazz = value.getClass();

		return clazz.isArray();
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
			sb.append(_escape(entry.getKey()));
			sb.append("\": ");

			Object value = entry.getValue();

			if (_isArray(value)) {
				sb.append("[");

				Object[] valueArray = (Object[])value;

				for (int i = 0; i < valueArray.length; i++) {
					if (valueArray[i] instanceof String) {
						sb.append("\"");
						sb.append(valueArray[i]);
						sb.append("\"");
					}
					else {
						sb.append(valueArray[i]);
					}

					if ((i + 1) < valueArray.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof Map) {
				sb.append(_toJSON((Map<String, ?>)value));
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(value));
				sb.append("\"");
			}
			else {
				sb.append(value);
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

	private static final String[][] _JSON_ESCAPE_STRINGS = {
		{"\\", "\"", "\b", "\f", "\n", "\r", "\t"},
		{"\\\\", "\\\"", "\\b", "\\f", "\\n", "\\r", "\\t"}
	};

}