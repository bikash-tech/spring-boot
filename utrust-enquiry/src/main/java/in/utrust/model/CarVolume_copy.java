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
@Table(name="car_volume_copy")
public class CarVolume_copy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "label")
	private Double label;
	
	@Column(name = "volume")
	private Integer volume;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "price_chart_data_id")
	private PricingChartDataInfo pricingChartDataInfo;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getLabel() {
		return label;
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

	public PricingChartDataInfo getPricingChartDataInfo() {
		return pricingChartDataInfo;
	}

	public void setPricingChartDataInfo(PricingChartDataInfo pricingChartDataInfo) {
		this.pricingChartDataInfo = pricingChartDataInfo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CarVolume [id=");
		builder.append(id);
		builder.append(", label=");
		builder.append(label);
		builder.append(", volume=");
		builder.append(volume);
		builder.append(", pricingChartDataInfo=");
		builder.append(pricingChartDataInfo);
		builder.append("]");
		return builder.toString();
	}
}
