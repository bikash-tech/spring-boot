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
@Table(name = "similar_transaction")
public class SimilarTransaction {

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
	private Date year;

	@Column(name = "date")
	private Date date;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "price_data_id")
	private PricingDataInfo priceDataInfo;


	public PricingDataInfo getPriceDataInfo() {
		return priceDataInfo;
	}

	public void setPriceDataInfo(PricingDataInfo priceDataInfo) {
		this.priceDataInfo = priceDataInfo;
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

	public Date getYear() {
		return year;
	}

	public void setYear(Date year) {
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
		return "SimilarTransaction [id=" + id + ", make=" + make + ", model=" + model + ", price=" + price + ", year="
				+ year + ", date=" + date + ", priceDataInfo=" + priceDataInfo + "]";
	}

	
}
