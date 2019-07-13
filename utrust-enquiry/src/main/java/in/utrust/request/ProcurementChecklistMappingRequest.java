package in.utrust.request;

import java.util.Date;

public class ProcurementChecklistMappingRequest {

	private int checklistItemId;

	private String status;

	private String[] imageUrls;

	private Date targetDate;

	public int getChecklistItemId() {
		return checklistItemId;
	}

	public void setChecklistItemId(int checklistItemId) {
		this.checklistItemId = checklistItemId;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public String[] getImageUrls() {
		return imageUrls;
	}

	public void setImageUrls(String[] imageUrls) {
		this.imageUrls = imageUrls;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}