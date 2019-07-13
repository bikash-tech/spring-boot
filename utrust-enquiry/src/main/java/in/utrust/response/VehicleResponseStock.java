package in.utrust.response;

import java.util.Date;

public class VehicleResponseStock {
	private String fuelType;
	private Integer inspectionLevel;
	private Boolean insurance;
	private Integer month;
	private String suffix;
	private Integer year;
	private int previousOwners;
	private String replaceOrExgInfo;
	private String registrationNumber;
	private Date purchaseDate;
	private String transmissionType;
	private Integer mileage;
	private boolean accidental;
	private Date insuranceValidityDate;
	private boolean detailedInspection;
	private Integer dealerId;
	private Integer inventoryDays;
	private Integer basePrice;
	private Integer sellingPrice;
	private MakeResponse makeResponse;
	private VariantResponse variantResponse;
	private ExteriorColorResponse colorResponse;
	private ModelResponse modelResponse;
	private Integer vehicleStageId;

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public Integer getInspectionLevel() {
		return inspectionLevel;
	}

	public void setInspectionLevel(Integer inspectionLevel) {
		this.inspectionLevel = inspectionLevel;
	}
 
	public Boolean getInsurance() {
		return insurance;
	}

	public void setInsurance(Boolean insurance) {
		this.insurance = insurance;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public String getSuffix() {
		return suffix;
	}

	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public int getPreviousOwners() {
		return previousOwners;
	}

	public void setPreviousOwners(int previousOwners) {
		this.previousOwners = previousOwners;
	}

	public String getReplaceOrExgInfo() {
		return replaceOrExgInfo;
	}

	public void setReplaceOrExgInfo(String replaceOrExgInfo) {
		this.replaceOrExgInfo = replaceOrExgInfo;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getTransmissionType() {
		return transmissionType;
	}

	public void setTransmissionType(String transmissionType) {
		this.transmissionType = transmissionType;
	}

	public Integer getMileage() {
		return mileage;
	}

	public void setMileage(Integer mileage) {
		this.mileage = mileage;
	}

	public boolean isAccidental() {
		return accidental;
	}

	public void setAccidental(boolean accidental) {
		this.accidental = accidental;
	}

	public Date getInsuranceValidityDate() {
		return insuranceValidityDate;
	}

	public void setInsuranceValidityDate(Date insuranceValidityDate) {
		this.insuranceValidityDate = insuranceValidityDate;
	}

	public boolean isDetailedInspection() {
		return detailedInspection;
	}

	public void setDetailedInspection(boolean detailedInspection) {
		this.detailedInspection = detailedInspection;
	}

	public Integer getDealerId() {
		return dealerId;
	}

	public void setDealerId(Integer dealerId) {
		this.dealerId = dealerId;
	}

	public Integer getInventoryDays() {
		return inventoryDays;
	}

	public void setInventoryDays(Integer inventoryDays) {
		this.inventoryDays = inventoryDays;
	}

	public Integer getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(Integer basePrice) {
		this.basePrice = basePrice;
	}

	public Integer getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(Integer sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public MakeResponse getMakeResponse() {
		return makeResponse;
	}

	public void setMakeResponse(MakeResponse makeResponse) {
		this.makeResponse = makeResponse;
	}

	public VariantResponse getVariantResponse() {
		return variantResponse;
	}

	public void setVariantResponse(VariantResponse variantResponse) {
		this.variantResponse = variantResponse;
	}

	public ExteriorColorResponse getColorResponse() {
		return colorResponse;
	}

	public void setColorResponse(ExteriorColorResponse colorResponse) {
		this.colorResponse = colorResponse;
	}

	public ModelResponse getModelResponse() {
		return modelResponse;
	}

	public void setModelResponse(ModelResponse modelResponse) {
		this.modelResponse = modelResponse;
	}

	public Integer getVehicleStageId() {
		return vehicleStageId;
	}

	public void setVehicleStageId(Integer vehicleStageId) {
		this.vehicleStageId = vehicleStageId;
	}
}
