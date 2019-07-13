package in.utrust.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="master_demand_structure")
public class DemandStructure {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 	@Column(name="id")
	private Integer demandStructureId;
	
	private String name;
	
	/*@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true,mappedBy="demandStructure")
	private List<Enquiry> enquiryList;*/
	
	public Integer getDemandStructureId() {
		return demandStructureId;
	}

	public void setDemandStructureId(Integer demandStructureId) {
		this.demandStructureId = demandStructureId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}