package gov.omsb.form.builder.headless.client.dto.v1_0;

import gov.omsb.form.builder.headless.client.function.UnsafeSupplier;
import gov.omsb.form.builder.headless.client.serdes.v1_0.FormDataRequestSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Jinal Patel
 * @generated
 */
@Generated("")
public class FormDataRequest implements Cloneable, Serializable {

	public static FormDataRequest toDTO(String json) {
		return FormDataRequestSerDes.toDTO(json);
	}

	public Long[] getFormDefinitionIds() {
		return formDefinitionIds;
	}

	public void setFormDefinitionIds(Long[] formDefinitionIds) {
		this.formDefinitionIds = formDefinitionIds;
	}

	public void setFormDefinitionIds(
		UnsafeSupplier<Long[], Exception> formDefinitionIdsUnsafeSupplier) {

		try {
			formDefinitionIds = formDefinitionIdsUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long[] formDefinitionIds;

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
	public FormDataRequest clone() throws CloneNotSupportedException {
		return (FormDataRequest)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FormDataRequest)) {
			return false;
		}

		FormDataRequest formDataRequest = (FormDataRequest)object;

		return Objects.equals(toString(), formDataRequest.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return FormDataRequestSerDes.toJSON(this);
	}

}