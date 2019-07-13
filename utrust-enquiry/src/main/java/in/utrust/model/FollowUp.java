package in.utrust.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "enquiry_followup")
public class FollowUp {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer followUpId;

	@Column(name = "enq_number")
	private String enquiryNumber;

	@Column(name = "actual_remark")
	private String actualRemark;

	@Column(name = "actual_detail_remark")
	private String actualDetailRemark;

	@Column(name = "actual_date")
	private Date actualDate;

	@Column(name = "next_remark")
	private String nextRemark;

	@Column(name = "next_detail_remark")
	private String nextDetailRemark;

	@Column(name = "next_date")
	private Date nextDate;

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

	public String getActualRemark() {
		return actualRemark;
	}

	public void setActualRemark(String actualRemark) {
		this.actualRemark = actualRemark;
	}

	public String getActualDetailRemark() {
		return actualDetailRemark;
	}

	public void setActualDetailRemark(String actualDetailRemark) {
		this.actualDetailRemark = actualDetailRemark;
	}

	public Date getActualDate() {
		return actualDate;
	}

	public void setActualDate(Date actualDate) {
		this.actualDate = actualDate;
	}

	public String getNextRemark() {
		return nextRemark;
	}

	public void setNextRemark(String nextRemark) {
		this.nextRemark = nextRemark;
	}

	public String getNextDetailRemark() {
		return nextDetailRemark;
	}

	public void setNextDetailRemark(String nextDetailRemark) {
		this.nextDetailRemark = nextDetailRemark;
	}

	public Date getNextDate() {
		return nextDate;
	}

	public void setNextDate(Date nextDate) {
		this.nextDate = nextDate;
	}

	@Override
	public String toString() {
		return "FollowUp [followUpId=" + followUpId + ", enquiryNumber=" + enquiryNumber + ", actualRemark="
				+ actualRemark + ", actualDetailRemark=" + actualDetailRemark + ", actualDate=" + actualDate
				+ ", nextRemark=" + nextRemark + ", nextDetailRemark=" + nextDetailRemark + ", nextDate=" + nextDate
				+ "]";
	}

}
