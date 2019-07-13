package in.utrust.request;

import java.util.ArrayList;
import java.util.List;

public class ProcurementChecklistAllRequests {
	private List<ProcurementChecklistMappingRequest> checklist = new ArrayList<>();
	private String enquiryNumber;
	private String documentCategory;

	public String getEnquiryNumber() {
		return enquiryNumber;
	}

	public void setEnquiryNumber(String enquiryNumber) {
		this.enquiryNumber = enquiryNumber;
	}

	public String getDocumentCategory() {
		return documentCategory;
	}

	public void setDocumentCategory(String documentCategory) {
		this.documentCategory = documentCategory;
	}

	public List<ProcurementChecklistMappingRequest> getChecklist() {
		return checklist;
	}

	public void setChecklist(List<ProcurementChecklistMappingRequest> checklist) {
		this.checklist = checklist;
	}
}