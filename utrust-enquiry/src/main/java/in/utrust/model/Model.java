package in.utrust.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "master_model")
public class Model {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer modelId;

	@Column(name = "name")
	private String name;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "make_id")
	private Make make;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "model", fetch = FetchType.LAZY)
	private List<Variant> variantList;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "model", fetch = FetchType.LAZY)
	private List<WantList> wantList;

	public Integer getModelId() {
		return modelId;
	}

	public void setModelId(Integer modelId) {
		this.modelId = modelId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Make getMake() {
		return make;
	}

	public void setMake(Make make) {
		this.make = make;
	}

	public List<Variant> getVariantList() {
		return variantList;
	}

	public void setVariantList(List<Variant> variantList) {
		this.variantList = variantList;
	}

}
