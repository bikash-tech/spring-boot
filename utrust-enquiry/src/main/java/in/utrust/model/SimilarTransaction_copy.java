package in.utrust.model;

import java.util.Date;

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
@Table(name = "similar_transaction_copy")
public class SimilarTransaction_copy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "make")
	private String make;

	@Column(name = "model")
	private String model;

	@Column(name = "price")
	private Double price;

	@Column(name = "year")
	private Integer year;

	@Column(name = "date")
	private Date date;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "price_chart_data_id")
	private PricingChartDataInfo pricingChartDataInfo;

	public PricingChartDataInfo getPricingChartDataInfo() {
		return pricingChartDataInfo;
	}
	
	public void setPricingChartDataInfo(PricingChartDataInfo pricingChartDataInfo) {
		this.pricingChartDataInfo = pricingChartDataInfo;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SimilarTransaction [id=");
		builder.append(id);
		builder.append(", make=");
		builder.append(make);
		builder.append(", model=");
		builder.append(model);
		builder.append(", price=");
		builder.append(price);
		builder.append(", year=");
		builder.append(year);
		builder.append(", date=");
		builder.append(date);
		builder.append(", pricingChartDataInfo=");
		builder.append(pricingChartDataInfo);
		builder.append("]");
		return builder.toString();
	}

}
