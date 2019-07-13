package in.utrust.request;

import java.util.Date;

public class VehicleRequest {
	
	private Integer vehicleId;
 	private Integer exteriorColourId;
	private String fuelType;
 	private Integer inspectionLevel;
	private Integer insuranceTypeId;
 	private Integer month;
	private Integer year;
	private int previousOwners;
	private String replaceOrExgInfo;
 	private String registrationNumber;
	private String vinNo;
	private Date purchaseDate;
	private int makeId;
	private int modelId;
	private int variantId;
 	private String transmissionType;
	private String colour;
	private Integer mileage;
	private boolean accidental;
 	private Date insuranceValidityDate;
	private boolean detailedInspection;
	private int qualityLevel;
	private Boolean unRegister; 
	private Boolean isTaxi; 
	private Boolean isUnderWarranty; 
	private Date warrantyValidityDate; 
  	private Boolean isUpdate=false;

	public Boolean getIsUpdate() {
		return isUpdate;
	}
	public void setIsUpdate(Boolean isUpdate) {
		this.isUpdate = isUpdate;
	}
	public Integer getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}
	public Integer getExteriorColourId() {
		return exteriorColourId;
	}
	public void setExteriorColourId(Integer exteriorColourId) {
		this.exteriorColourId = exteriorColourId;
	}
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
	public Integer getInsuranceTypeId() {
		return insuranceTypeId;
	}
	public void setInsuranceTypeId(Integer insuranceTypeId) {
		this.insuranceTypeId = insuranceTypeId;
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
	public int getMakeId() {
		return makeId;
	}
	public void setMakeId(int makeId) {
		this.makeId = makeId;
	}
	public int getModelId() {
		return modelId;
	}
	public void setModelId(int modelId) {
		this.modelId = modelId;
	}
	public int getVariantId() {
		return variantId;
	}
	public void setVariantId(int variantId) {
		this.variantId = variantId;
	}
	 
	public String getTransmissionType() {
		return transmissionType;
	}
	public void setTransmissionType(String transmissionType) {
		this.transmissionType = transmissionType;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
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
	
	public boolean isDetailedInspection() {
		return detailedInspection;
	}
	public void setDetailedInspection(boolean detailedInspection) {
		this.detailedInspection = detailedInspection;
	}
	public int getQualityLevel() {
		return qualityLevel;
	}
	public void setQualityLevel(int qualityLevel) {
		this.qualityLevel = qualityLevel;
	}
	public Date getInsuranceValidityDate() {
		return insuranceValidityDate;
	}
	public void setInsuranceValidityDate(Date insuranceValidityDate) {
		this.insuranceValidityDate = insuranceValidityDate;
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
