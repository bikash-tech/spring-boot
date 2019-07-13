package in.utrust.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "procurement_checklist")
public class Checklist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int checklistId;

	@Column(name = "checklist_item")
	private String checklist;

	@Column(name = "description")
	private String description;

	@Column(name = "category")
	private String documentCategory;

	public int getChecklistId() {
		return checklistId;
	}

	public void setChecklistId(int checklistId) {
		this.checklistId = checklistId;
	}

	public String getDocumentCategory() {
		return documentCategory;
	}

	public void setDocumentCategory(String documentCategory) {
		this.documentCategory = documentCategory;
	}

	public String getChecklist() {
		return checklist;
	}

	public void setChecklist(String checklist) { 
		this.checklist = checklist;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}