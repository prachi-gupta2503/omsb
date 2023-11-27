package gov.omsb.mobile.sdk.headless.client.dto.v1_0;

import gov.omsb.mobile.sdk.headless.client.function.UnsafeSupplier;
import gov.omsb.mobile.sdk.headless.client.serdes.v1_0.ValidateUserLoginRequestSerDes;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Niddhi Thacker
 * @generated
 */
@Generated("")
public class ValidateUserLoginRequest implements Cloneable, Serializable {

	public static ValidateUserLoginRequest toDTO(String json) {
		return ValidateUserLoginRequestSerDes.toDTO(json);
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPassword(
		UnsafeSupplier<String, Exception> passwordUnsafeSupplier) {

		try {
			password = passwordUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserName(
		UnsafeSupplier<String, Exception> userNameUnsafeSupplier) {

		try {
			userName = userNameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String userName;

	@Override
	public ValidateUserLoginRequest clone() throws CloneNotSupportedException {
		return (ValidateUserLoginRequest)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ValidateUserLoginRequest)) {
			return false;
		}

		ValidateUserLoginRequest validateUserLoginRequest =
			(ValidateUserLoginRequest)object;

		return Objects.equals(toString(), validateUserLoginRequest.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return ValidateUserLoginRequestSerDes.toJSON(this);
	}

}