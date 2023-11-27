package gov.omsb.form.builder.headless.client.dto.v1_0;

import gov.omsb.form.builder.headless.client.function.UnsafeSupplier;
import gov.omsb.form.builder.headless.client.serdes.v1_0.PostFormDataRequestSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Jinal Patel
 * @generated
 */
@Generated("")
public class PostFormDataRequest implements Cloneable, Serializable {

	public static PostFormDataRequest toDTO(String json) {
		return PostFormDataRequestSerDes.toDTO(json);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setFirstName(
		UnsafeSupplier<String, Exception> firstNameUnsafeSupplier) {

		try {
			firstName = firstNameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String firstName;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setLastName(
		UnsafeSupplier<String, Exception> lastNameUnsafeSupplier) {

		try {
			lastName = lastNameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String lastName;

	@Override
	public PostFormDataRequest clone() throws CloneNotSupportedException {
		return (PostFormDataRequest)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PostFormDataRequest)) {
			return false;
		}

		PostFormDataRequest postFormDataRequest = (PostFormDataRequest)object;

		return Objects.equals(toString(), postFormDataRequest.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return PostFormDataRequestSerDes.toJSON(this);
	}

}