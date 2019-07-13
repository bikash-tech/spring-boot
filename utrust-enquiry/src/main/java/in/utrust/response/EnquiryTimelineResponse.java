package in.utrust.response;

import java.util.Date;

public class EnquiryTimelineResponse {
	private Integer followUpId;
	private String enquiryNumber;
	private String remark;
	private String detailedRemark;
	private Date date;
	private boolean isFollowUp;
	private String followupStatus;

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getDetailedRemark() {
		return detailedRemark;
	}

	public void setDetailedRemark(String detailedRemark) {
		this.detailedRemark = detailedRemark;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getFollowUpId() {
		return followUpId;
	}

	public void setFollowUpId(Integer followUpId) {
		this.followUpId = followUpId;
	}

	public String getEnquiryNumber() {
		return enquiryNumber;
	}

	public void setEnquiryNumber(String enquiryNumber) {
		this.enquiryNumber = enquiryNumber;
	}

	public boolean isFollowUp() {
		return isFollowUp;
	}

	public void setIsFollowUp(boolean isFollowUp) {
		this.isFollowUp = isFollowUp;
	}

	public String getFollowupStatus() {
		return followupStatus;
	}

	public void setFollowupStatus(String followupStatus) {
		this.followupStatus = followupStatus;
	}
}
