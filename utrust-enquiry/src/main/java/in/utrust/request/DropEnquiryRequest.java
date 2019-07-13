package in.utrust.request;

public class DropEnquiryRequest {
	private String enquiryNumber;
	private String dropReason;
	private String dropRemarks;
	private String dropDetailedRemark;
    private Boolean isDrop;
    
	public String getDropDetailedRemark() {
		return dropDetailedRemark;
	}

	public void setDropDetailedRemark(String dropDetailedRemark) {
		this.dropDetailedRemark = dropDetailedRemark;
	}

	public Boolean getIsDrop() {
		return isDrop;
	}

	public void setIsDrop(Boolean isDrop) {
		this.isDrop = isDrop;
	}

	public String getDropReason() {
		return dropReason;
	}

	public void setDropReason(String dropReason) {
		this.dropReason = dropReason;
	}

	public String getDropRemarks() {
		return dropRemarks;
	}

	public void setDropRemarks(String dropRemarks) {
		this.dropRemarks = dropRemarks;
	}

	public String getEnquiryNumber() {
		return enquiryNumber;
	}

	public void setEnquiryNumber(String enquiryNumber) {
		this.enquiryNumber = enquiryNumber;
	}
}
