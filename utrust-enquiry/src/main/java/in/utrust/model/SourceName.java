package in.utrust.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "master_source_name")
public class SourceName {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer sourceNameId;

	@Column(name = "name")
	private String name;

	public Integer getSourceNameId() {
		return sourceNameId;
	}

	public void setSourceNameId(Integer sourceNameId) {
		this.sourceNameId = sourceNameId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
