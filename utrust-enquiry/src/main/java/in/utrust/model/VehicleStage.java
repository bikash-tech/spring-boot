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
@Table(name = "master_vehicle_stage")
public class VehicleStage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 	@Column(name = "id")
	private Integer stageId;
	@Column(name = "stage_name")
	private String stageName;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="vehicleStage",fetch=FetchType.LAZY)
	private List<Vehicle> vehicle;


	public Integer getStageId() {
		return stageId;
	}

	public void setStageId(Integer stageId) {
		this.stageId = stageId;
	}

	public String getStageName() {
		return stageName;
	}

	public void setStageName(String stageName) {
		this.stageName = stageName;
	}
	
	public List<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(List<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VehicleStage [id=");
		builder.append(", stageId=");
		builder.append(", stageName=");
		builder.append(stageName);
		builder.append("]");
		return builder.toString();
	}
}
