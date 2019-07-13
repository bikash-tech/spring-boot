package in.utrust.response;

import java.util.Date;
import java.util.List;

public class CollectedVehicleResponse {

	private String regNumber; 
	private String make;
	private String model;
	private String variant; 
	private Integer year;
	private String transmission;
	private String fuel;
	private Integer  odoMeter;
	private String color;
	private Integer vehicleStageId;
	private Date collecteddate;
	private String enquiryNumber;
	private String poName;
	private List<String> signOff;
	private Integer pendingDocument;
	private Integer totalDocuments;
	
	/// TODO -start - change the static values
	private int vehicleRating=3;
	private Double purchaseAmt;
	private int retailEligibilityDecision=1;
	private String valuationNumber="VL1802121";
	
	/// TODO -end
	
	public Double getPurchaseAmt() {
		return purchaseAmt;
	}
	public int getRetailEligibilityDecision() {
		return retailEligibilityDecision;
	}
	public void setRetailEligibilityDecision(int retailEligibilityDecision) {
		this.retailEligibilityDecision = retailEligibilityDecision;
	}
	public String getValuationNumber() {
		return valuationNumber;
	}
	public void setValuationNumber(String valuationNumber) {
		this.valuationNumber = valuationNumber;
	}
	public void setPurchaseAmt(Double purchaseAmt) {
		this.purchaseAmt = purchaseAmt;
	}
	public int getVehicleRating() {
		return vehicleRating;
	}
	public void setVehicleRating(int vehicleRating) {
		this.vehicleRating = vehicleRating;
	}
	public Integer getTotalDocuments() {
		return totalDocuments;
	}
	public void setTotalDocuments(Integer totalDocuments) {
		this.totalDocuments = totalDocuments;
	}
	public String getEnquiryNumber() {
		return enquiryNumber;
	}
	public void setEnquiryNumber(String enquiryNumber) {
		this.enquiryNumber = enquiryNumber;
	}
	public String getRegNumber() {
		return regNumber;
	}
	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
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
	public String getVariant() {
		return variant;
	}
	public void setVariant(String variant) {
		this.variant = variant;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public String getTransmission() {
		return transmission;
	}
	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}
	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	public Integer getOdoMeter() {
		return odoMeter;
	}
	public void setOdoMeter(Integer odoMeter) {
		this.odoMeter = odoMeter;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Integer getVehicleStageId() {
		return vehicleStageId;
	}
	public void setVehicleStageId(Integer vehicleStageId) {
		this.vehicleStageId = vehicleStageId;
	}
	public Date getCollecteddate() {
		return collecteddate;
	}
	public void setCollecteddate(Date collecteddate) {
		this.collecteddate = collecteddate;
	}
	public String getPoName() {
		return poName;
	}
	public void setPoName(String poName) {
		this.poName = poName;
	}
	public List<String> getSignOff() {
		return signOff;
	}
	public void setSignOff(List<String> signOff) {
		this.signOff = signOff;
	}
	public Integer getPendingDocument() {
		return pendingDocument;
	}
	public void setPendingDocument(Integer pendingDocument) {
		this.pendingDocument = pendingDocument;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CollectedVehicleResponse [regNumber=");
		builder.append(regNumber);
		builder.append(", make=");
		builder.append(make);
		builder.append(", model=");
		builder.append(model);
		builder.append(", variant=");
		builder.append(variant);
		builder.append(", year=");
		builder.append(year);
		builder.append(", transmission=");
		builder.append(transmission);
		builder.append(", fuel=");
		builder.append(fuel);
		builder.append(", odoMeter=");
		builder.append(odoMeter);
		builder.append(", color=");
		builder.append(color);
		builder.append(", vehicleStageId=");
		builder.append(vehicleStageId);
		builder.append(", collecteddate=");
		builder.append(collecteddate);
		builder.append(", enquiryNumber=");
		builder.append(enquiryNumber);
		builder.append(", poName=");
		builder.append(poName);
		builder.append(", signOff=");
		builder.append(signOff);
		builder.append(", pendingDocument=");
		builder.append(pendingDocument);
		builder.append("]");
		return builder.toString();
	}

}
