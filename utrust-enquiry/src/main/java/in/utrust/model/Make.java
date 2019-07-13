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
@Table(name = "master_make")
public class Make {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer makeId;

	@Column(name = "name")
	private String name;

	@Column(name = "icon_url")
	private String iconUrl;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "make", fetch = FetchType.LAZY)
	private List<Model> modelList;
	

	public Integer getMakeId() {
		return makeId;
	}

	public void setMakeId(Integer makeId) {
		this.makeId = makeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public List<Model> getModelList() {
		return modelList;
	}

	public void setModelList(List<Model> modelList) {
		this.modelList = modelList;
	}

}
