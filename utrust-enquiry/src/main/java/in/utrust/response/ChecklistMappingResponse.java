package in.utrust.response;

import java.util.Date;
import java.util.List;

public class ChecklistMappingResponse {
	ChecklistResponse checklist;
	List<String> imageUrls;
	Date targetDate;

	public List<String> getImageUrls() {
		return imageUrls;
	}

	public void setImageUrls(List<String> imageUrls) {
		this.imageUrls = imageUrls;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public ChecklistResponse getChecklist() {
		return checklist;
	}

	public void setChecklist(ChecklistResponse checklist) {
		this.checklist = checklist;
	}
}