package in.utrust.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "temporary_vehicle")
public class TemporaryVehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "temp_registration_number")
	private String tempRegistraionNumber;
	
	@Column(name="created_at")
	private Date createdAt;

	@Column(name="created_by")
	private Integer createdBy;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTempRegistraionNumber() {
		return tempRegistraionNumber;
	}

	public void setTempRegistraionNumber(String tempRegistraionNumber) {
		this.tempRegistraionNumber = tempRegistraionNumber;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
}
