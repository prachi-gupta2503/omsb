package omsb.tms.headless.service.client.dto.v1_0;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

import omsb.tms.headless.service.client.function.UnsafeSupplier;
import omsb.tms.headless.service.client.serdes.v1_0.CaseDetailsResponseSerDes;

/**
 * @author AftabA
 * @generated
 */
@Generated("")
public class CaseDetailsResponse implements Cloneable, Serializable {

	public static CaseDetailsResponse toDTO(String json) {
		return CaseDetailsResponseSerDes.toDTO(json);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setMessage(
		UnsafeSupplier<String, Exception> messageUnsafeSupplier) {

		try {
			message = messageUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String message;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setStatus(
		UnsafeSupplier<String, Exception> statusUnsafeSupplier) {

		try {
			status = statusUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String status;

	@Override
	public CaseDetailsResponse clone() throws CloneNotSupportedException {
		return (CaseDetailsResponse)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CaseDetailsResponse)) {
			return false;
		}

		CaseDetailsResponse caseDetailsResponse = (CaseDetailsResponse)object;

		return Objects.equals(toString(), caseDetailsResponse.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return CaseDetailsResponseSerDes.toJSON(this);
	}

}