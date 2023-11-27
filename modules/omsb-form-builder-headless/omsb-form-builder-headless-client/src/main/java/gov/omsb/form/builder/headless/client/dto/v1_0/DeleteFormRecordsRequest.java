package gov.omsb.form.builder.headless.client.dto.v1_0;

import gov.omsb.form.builder.headless.client.function.UnsafeSupplier;
import gov.omsb.form.builder.headless.client.serdes.v1_0.DeleteFormRecordsRequestSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Jinal Patel
 * @generated
 */
@Generated("")
public class DeleteFormRecordsRequest implements Cloneable, Serializable {

	public static DeleteFormRecordsRequest toDTO(String json) {
		return DeleteFormRecordsRequestSerDes.toDTO(json);
	}

	public Long getFormDefinitionId() {
		return formDefinitionId;
	}

	public void setFormDefinitionId(Long formDefinitionId) {
		this.formDefinitionId = formDefinitionId;
	}

	public void setFormDefinitionId(
		UnsafeSupplier<Long, Exception> formDefinitionIdUnsafeSupplier) {

		try {
			formDefinitionId = formDefinitionIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long formDefinitionId;

	public Long[] getRecordIds() {
		return recordIds;
	}

	public void setRecordIds(Long[] recordIds) {
		this.recordIds = recordIds;
	}

	public void setRecordIds(
		UnsafeSupplier<Long[], Exception> recordIdsUnsafeSupplier) {

		try {
			recordIds = recordIdsUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long[] recordIds;

	@Override
	public DeleteFormRecordsRequest clone() throws CloneNotSupportedException {
		return (DeleteFormRecordsRequest)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof DeleteFormRecordsRequest)) {
			return false;
		}

		DeleteFormRecordsRequest deleteFormRecordsRequest =
			(DeleteFormRecordsRequest)object;

		return Objects.equals(toString(), deleteFormRecordsRequest.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return DeleteFormRecordsRequestSerDes.toJSON(this);
	}

}