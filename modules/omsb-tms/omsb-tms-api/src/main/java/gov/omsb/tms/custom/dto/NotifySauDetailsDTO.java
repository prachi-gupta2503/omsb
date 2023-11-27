package gov.omsb.tms.custom.dto;

import java.util.Arrays;

public class NotifySauDetailsDTO {

	private long[] sauUserIds;
	private int currentCapacity;
	private int requiredCapacity;
	private long fromUserId;
	private long trainingSiteId;

	public long[] getSauUserIds() {
		return sauUserIds;
	}

	public void setSauUserIds(long[] sauUserIds) {
		this.sauUserIds = sauUserIds;
	}

	public int getCurrentCapacity() {
		return currentCapacity;
	}

	public void setCurrentCapacity(int currentCapacity) {
		this.currentCapacity = currentCapacity;
	}

	public int getRequiredCapacity() {
		return requiredCapacity;
	}

	public void setRequiredCapacity(int requiredCapacity) {
		this.requiredCapacity = requiredCapacity;
	}

	public long getFromUserId() {
		return fromUserId;
	}

	public void setFromUserId(long fromUserId) {
		this.fromUserId = fromUserId;
	}

	public long getTrainingSiteId() {
		return trainingSiteId;
	}

	public void setTrainingSiteId(long trainingSiteId) {
		this.trainingSiteId = trainingSiteId;
	}

	@Override
	public String toString() {
		return "NotifySauDetailsDTO [sauUserIds=" + Arrays.toString(sauUserIds) + ", currentCapacity=" + currentCapacity
				+ ", requiredCapacity=" + requiredCapacity + ", fromUserId=" + fromUserId + ", trainingSiteId="
				+ trainingSiteId + "]";
	}

}
