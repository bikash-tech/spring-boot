package in.utrust.response;

import java.util.ArrayList;
import java.util.List;

public class ChecklistMappingResponses {
	private Integer countOfSelectedItem;
	private boolean isFirstTime;
	private List<ChecklistMappingResponse> checklistMappingData = new ArrayList<>();

	public boolean getIsFirstTime() {
		return isFirstTime;
	}

	public void setIsFirstTime(boolean isFirstTime) {
		this.isFirstTime = isFirstTime;
	}

	public Integer getCountOfSelectedItem() {
		return countOfSelectedItem;
	}

	public void setCountOfSelectedItem(Integer countOfSelectedItem) {
		this.countOfSelectedItem = countOfSelectedItem;
	}

	public List<ChecklistMappingResponse> getChecklistMappingData() {
		return checklistMappingData;
	}

	public void setChecklistMappingData(List<ChecklistMappingResponse> checklistMappingData) {
		this.checklistMappingData = checklistMappingData;
	}

}