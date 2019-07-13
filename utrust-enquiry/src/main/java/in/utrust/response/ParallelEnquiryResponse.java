package in.utrust.response;

import java.util.Date;

public class ParallelEnquiryResponse {

	private String make;
	private String model;
	private String varient;
	private Date enqDate;
	private String enqNumber;
	private String dealerGroup;
	private String dealerLocation;
	private Integer dealerId;
	public Integer getDealerId() {
		return dealerId;
	}
	public void setDealerId(Integer dealerId) {
		this.dealerId = dealerId;
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
	public String getVarient() {
		return varient;
	}
	public void setVarient(String varient) {
		this.varient = varient;
	}
	public Date getEnqDate() {
		return enqDate;
	}
	public void setEnqDate(Date enqDate) {
		this.enqDate = enqDate;
	}
	public String getEnqNumber() {
		return enqNumber;
	}
	public void setEnqNumber(String enqNumber) {
		this.enqNumber = enqNumber;
	}
	public String getDealerGroup() {
		return dealerGroup;
	}
	public void setDealerGroup(String dealerGroup) {
		this.dealerGroup = dealerGroup;
	}
	public String getDealerLocation() {
		return dealerLocation;
	}
	public void setDealerLocation(String dealerLocation) {
		this.dealerLocation = dealerLocation;
	}

	@Override
	public String toString() {
		return "ParallelEnquiryResponse [make=" + make + ", model=" + model + ", varient=" + varient + ", enqDate="
				+ enqDate + ", enqNumber=" + enqNumber + ", dealerGroup=" + dealerGroup + ", dealerLocation="
				+ dealerLocation + ", dealerId=" + dealerId + "]";
	}
}
