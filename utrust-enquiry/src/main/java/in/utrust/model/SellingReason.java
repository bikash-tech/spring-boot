package in.utrust.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "master_selling_reason")
public class SellingReason {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer selllingReasonId;

	@Column(name = "name")
	private String name;

	public Integer getSelllingReasonId() {
		return selllingReasonId;
	}

	public void setSelllingReasonId(Integer selllingReasonId) {
		this.selllingReasonId = selllingReasonId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
