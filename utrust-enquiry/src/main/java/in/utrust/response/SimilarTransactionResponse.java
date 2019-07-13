package in.utrust.response;

import java.util.Date;

public class SimilarTransactionResponse {

	private String make;
	
	private String model;
	
	private Double price;
	
	private Integer year;
	
	private Date date;

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
		return "SimilarTransactionResponse [make=" + make + ", model=" + model + ", price=" + price + ", year=" + year
				+ ", date=" + date + "]";
	}
	
	
	
}
