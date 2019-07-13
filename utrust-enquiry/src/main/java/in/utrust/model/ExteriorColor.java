package in.utrust.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "master_exterior_color")
public class ExteriorColor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer exteriorColourId;

	@Column(name = "name")
	private String name;

	public Integer getExteriorColorId() {
		return exteriorColourId;
	}

	public void setExteriorColorId(Integer exteriorColorId) {
		this.exteriorColourId = exteriorColorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
