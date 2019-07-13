package in.utrust.response;

public class FollowUpResponse {
	private Integer followUpId;
	private String enquiryNumber;
	private ActualFollowUpResponse actualFollowUp;
	private NextFollowUpResponse nextFollowUp;
	private boolean isFollowUp;

	public Integer getFollowUpId() {
		return followUpId;
	}

	public void setFollowUpId(Integer followUpId) {
		this.followUpId = followUpId;
	}

	public ActualFollowUpResponse getActualFollowUp() {
		return actualFollowUp;
	}

	public String getEnquiryNumber() {
		return enquiryNumber;
	}

	public void setEnquiryNumber(String enquiryNumber) {
		this.enquiryNumber = enquiryNumber;
	}

	public void setActualFollowUp(ActualFollowUpResponse actualFollowUp) {
		this.actualFollowUp = actualFollowUp;
	}

	public NextFollowUpResponse getNextFollowUp() {
		return nextFollowUp;
	}

	public void setNextFollowUp(NextFollowUpResponse nextFollowUp) {
		this.nextFollowUp = nextFollowUp;
	}

	public boolean isFollowUp() {
		return isFollowUp;
	}

	public void setFollowUp(boolean isFollowUp) {
		this.isFollowUp = isFollowUp;
	}

}
