package in.utrust.request;

import java.util.Date;

public class ActualFollowUpRequest {

	private String followUpRemark;
	private Date followUpDate;
	private String detailFollowUpRemark;
	public String getFollowUpRemark() {
		return followUpRemark;
	}
	public void setFollowUpRemark(String followUpRemark) {
		this.followUpRemark = followUpRemark;
	}
	public Date getFollowUpDate() {
		return followUpDate;
	}
	public void setFollowUpDate(Date followUpDate) {
		this.followUpDate = followUpDate;
	}
	public String getDetailFollowUpRemark() {
		return detailFollowUpRemark;
	}
	public void setDetailFollowUpRemark(String detailFollowUpRemark) {
		this.detailFollowUpRemark = detailFollowUpRemark;
	}


}
