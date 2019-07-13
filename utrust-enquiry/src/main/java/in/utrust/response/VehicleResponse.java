package in.utrust.response;

import java.util.Date;

public class VehicleResponse {
	private Boolean insurance;
	private Boolean accidental;
	private Boolean detailedInspection;
	private Boolean unRegister; 
	private Boolean isTaxi; 
	private Boolean isUnderWarranty; 

	private String replaceOrExgInfo;
	private String registrationNumber;
	private String vinNo;
	private String fuelType;
	private String transmissionType;
	private String status;

	private Integer previousOwners;
	private Integer mileage;
	private Integer inspectionLevel;
	private Integer month;
	private Integer year;

	private Date purchaseDate;
	private Date insuranceValidityDate;
	private Date warrantyValidityDate; 

	private Integer dealerId;
	private Integer inventoryDays;
	private Integer basePrice;
	private Integer sellingPrice;
	private Integer vehicleStageId;
	
	private ModelResponse modelResponse;
	private VariantResponse variantResponse;
	private ExteriorColorResponse exteriorColorResponse;
	private MakeResponse makeResponse;
	private InsuranceTypeResponse insuranceTypeResponse;

	public Integer getVehicleStageId() {
		return vehicleStageId;
	}

	public void setVehicleStageId(Integer vehicleStageId) {
		this.vehicleStageId = vehicleStageId;
	}

	public MakeResponse getMakeResponse() {
		return makeResponse;
	}

	public void setMakeResponse(MakeResponse makeResponse) {
		this.makeResponse = makeResponse;
	}

	public ModelResponse getModelResponse() {
		return modelResponse;
	}

	public void setModelResponse(ModelResponse modelResponse) {
		this.modelResponse = modelResponse;
	}

	public VariantResponse getVariantResponse() {
		return variantResponse;
	}

	public void setVariantResponse(VariantResponse variantResponse) {
		this.variantResponse = variantResponse;
	}

	public ExteriorColorResponse getExteriorColorResponse() {
		return exteriorColorResponse;
	}

	public void setExteriorColorResponse(ExteriorColorResponse exteriorColorResponse) {
		this.exteriorColorResponse = exteriorColorResponse;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public Integer getInspectionLevel() {
		return inspectionLevel;
	}

	public void setInspectionLevel(Integer inspectionLevel) {
		this.inspectionLevel = inspectionLevel;
	}

	public Boolean isInsurance() {
		return insurance;
	}

	public void setInsurance(Boolean insurance) {
		this.insurance = insurance;
	}

	public Boolean isAccidental() {
		return accidental;
	}

	public void setAccidental(Boolean accidental) {
		this.accidental = accidental;
	}

	public Boolean isDetailedInspection() {
		return detailedInspection;
	}

	public void setDetailedInspection(Boolean detailedInspection) {
		this.detailedInspection = detailedInspection;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getPreviousOwners() {
		return previousOwners;
	}

	public void setPreviousOwners(Integer previousOwners) {
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

	public String getVinNo() {
		return vinNo;
	}

	public void setVinNo(String vinNo) {
		this.vinNo = vinNo;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Boolean getInsurance() {
		return insurance;
	}

	public Boolean getAccidental() {
		return accidental;
	}

	public Boolean getDetailedInspection() {
		return detailedInspection;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
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

	public Date getInsuranceValidityDate() {
		return insuranceValidityDate;
	}

	public void setInsuranceValidityDate(Date insuranceValidityDate) {
		this.insuranceValidityDate = insuranceValidityDate;
	}

	public InsuranceTypeResponse getInsuranceTypeResponse() {
		return insuranceTypeResponse;
	}

	public void setInsuranceTypeResponse(InsuranceTypeResponse insuranceTypeResponse) {
		this.insuranceTypeResponse = insuranceTypeResponse;
	}

	public Boolean getUnRegister() {
		return unRegister;
	}

	public void setUnRegister(Boolean unRegister) {
		this.unRegister = unRegister;
	}

	public Boolean getIsTaxi() {
		return isTaxi;
	}

	public void setIsTaxi(Boolean isTaxi) {
		this.isTaxi = isTaxi;
	}

	public Boolean getIsUnderWarranty() {
		return isUnderWarranty;
	}

	public void setIsUnderWarranty(Boolean isUnderWarranty) {
		this.isUnderWarranty = isUnderWarranty;
	}

	public Date getWarrantyValidityDate() {
		return warrantyValidityDate;
	}

	public void setWarrantyValidityDate(Date warrantyValidityDate) {
		this.warrantyValidityDate = warrantyValidityDate;
	}

}
