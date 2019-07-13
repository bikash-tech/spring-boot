package in.utrust.request;

public class ApprovedRequest {
	private Integer notificationId;
	private Integer notificationFromUser;
	private Integer notificationToUser;
	private String enquiryNumber;
	private Boolean isSuggested;
	private Boolean isApproved;
	private Boolean isAccepted;
	private Boolean isDrop;

	public Integer getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(Integer notificationId) {
		this.notificationId = notificationId;
	}

	public String getEnquiryNumber() {
		return enquiryNumber;
	}

	public void setEnquiryNumber(String enquiryNumber) {
		this.enquiryNumber = enquiryNumber;
	}

	public Boolean getIsSuggested() {
		return isSuggested;
	}

	public void setIsSuggested(Boolean isSuggested) {
		this.isSuggested = isSuggested;
	}

	public Boolean getIsApproved() {
		return isApproved;
	}

	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}

	public Boolean getIsAccepted() {
		return isAccepted;
	}

	public void setIsAccepted(Boolean isAccepted) {
		this.isAccepted = isAccepted;
	}

	public Boolean getIsDrop() {
		return isDrop;
	}

	public void setIsDrop(Boolean isDrop) {
		this.isDrop = isDrop;
	}

	public Integer getNotificationFromUser() {
		return notificationFromUser;
	}

	public void setNotificationFromUser(Integer notificationFromUser) {
		this.notificationFromUser = notificationFromUser;
	}

	public Integer getNotificationToUser() {
		return notificationToUser;
	}

	public void setNotificationToUser(Integer notificationToUser) {
		this.notificationToUser = notificationToUser;
	}


}
