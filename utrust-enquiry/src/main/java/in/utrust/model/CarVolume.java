package in.utrust.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="car_volume")
public class CarVolume {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "label")
	private Double label;
	
	@Column(name = "volume")
	private Integer volume;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "f_price_data_id")
	private PricingDataInfo priceDataInf;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getLabel() {
		return label;
	}

	public PricingDataInfo getPriceDataInf() {
		return priceDataInf;
	}

	public void setPriceDataInf(PricingDataInfo priceDataInf) {
		this.priceDataInf = priceDataInf;
	}

	public void setLabel(Double label) {
		this.label = label;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "CarVolume [id=" + id + ", label=" + label + ", volume=" + volume + ", priceDataInf=" + priceDataInf
				+ "]";
	}

	
		
	
}
