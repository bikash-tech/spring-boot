package in.utrust.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "master_status_reasoning")
public class StatusReasoning {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer statusReasoningId;

	@Column(name = "name")
	private String name;

	public Integer getStatusReasoningId() {
		return statusReasoningId;
	}

	public void setStatusReasoningId(Integer statusReasoningId) {
		this.statusReasoningId = statusReasoningId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
