package omsb.tms.headless.service.client.dto.v1_0;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

import omsb.tms.headless.service.client.function.UnsafeSupplier;
import omsb.tms.headless.service.client.serdes.v1_0.CaseDetailsSerDes;

/**
 * @author AftabA
 * @generated
 */
@Generated("")
public class CaseDetails implements Cloneable, Serializable {

	public static CaseDetails toDTO(String json) {
		return CaseDetailsSerDes.toDTO(json);
	}

	public String getCaseNumber() {
		return caseNumber;
	}

	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}

	public void setCaseNumber(
		UnsafeSupplier<String, Exception> caseNumberUnsafeSupplier) {

		try {
			caseNumber = caseNumberUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String caseNumber;

	public Integer getCaseTypeId() {
		return caseTypeId;
	}

	public void setCaseTypeId(Integer caseTypeId) {
		this.caseTypeId = caseTypeId;
	}

	public void setCaseTypeId(
		UnsafeSupplier<Integer, Exception> caseTypeIdUnsafeSupplier) {

		try {
			caseTypeId = caseTypeIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer caseTypeId;

	public String getCrn() {
		return crn;
	}

	public void setCrn(String crn) {
		this.crn = crn;
	}

	public void setCrn(UnsafeSupplier<String, Exception> crnUnsafeSupplier) {
		try {
			crn = crnUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String crn;

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

	public String getStageId() {
		return stageId;
	}

	public void setStageId(String stageId) {
		this.stageId = stageId;
	}

	public void setStageId(
		UnsafeSupplier<String, Exception> stageIdUnsafeSupplier) {

		try {
			stageId = stageIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String stageId;

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public void setStatusId(
		UnsafeSupplier<Integer, Exception> statusIdUnsafeSupplier) {

		try {
			statusId = statusIdUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer statusId;

	@Override
	public CaseDetails clone() throws CloneNotSupportedException {
		return (CaseDetails)super.clone();
	}

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
		return CaseDetailsSerDes.toJSON(this);
	}

}