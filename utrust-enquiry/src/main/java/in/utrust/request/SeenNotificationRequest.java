package in.utrust.request;

public class SeenNotificationRequest {
	private Integer notificationId;
	private String enquiryNumber;
	private Boolean isSeen;

	public Integer getNotificationId() {
		return notificationId;
	}

	public void setNottificationId(Integer notificationId) {
		this.notificationId = notificationId;
	}

	public String getEnquiryNumber() {
		return enquiryNumber;
	}

	public void setEnquiryNumber(String enquiryNumber) {
		this.enquiryNumber = enquiryNumber;
	}

	public Boolean getIsSeen() {
		return isSeen;
	}

	public void setIsSeen(Boolean isSeen) {
		this.isSeen = isSeen;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SeenNotificationRequest [nottificationId=");
		builder.append(notificationId);
		builder.append(", enquiryNumber=");
		builder.append(enquiryNumber);
		builder.append(", isSeen=");
		builder.append(isSeen);
		builder.append("]");
		return builder.toString();
	}

}
