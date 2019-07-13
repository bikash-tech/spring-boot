package in.utrust.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "master_insurance_type")
public class InsuranceType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer insuranceTypeId;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "insuranceType")
	private List<Vehicle> vehicleList;
	
	public Integer getInsuranceTypeId() {
		return insuranceTypeId;
	}

	public void setInsuranceTypeId(Integer insuranceTypeId) {
		this.insuranceTypeId = insuranceTypeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
