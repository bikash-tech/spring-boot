package in.utrust.request;

public class MapCheckListRequest {
	private String enquiryNumber;
	private Integer checklistItemId;
	private String documentUrl;
	public String getEnquiryNumber() {
		return enquiryNumber;
	}
	public void setEnquiryNumber(String enquiryNumber) {
		this.enquiryNumber = enquiryNumber;
	}
	public Integer getChecklistItemId() {
		return checklistItemId;
	}
	public void setChecklistItemId(Integer checklistItemId) {
		this.checklistItemId = checklistItemId;
	}
	public String getDocumentUrl() {
		return documentUrl;
	}
	public void setDocumentUrl(String documentUrl) {
		this.documentUrl = documentUrl;
	}
	@Override
	public String toString() {
		return "MapCheckListRequest [enquiryNumber=" + enquiryNumber + ", checklistItemId=" + checklistItemId
				+ ", documentUrl=" + documentUrl + "]";
	}

	
	
}
