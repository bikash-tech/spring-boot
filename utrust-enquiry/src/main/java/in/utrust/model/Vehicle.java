package in.utrust.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vehicle")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer vehicleId;

	@Column(name = "registration_number")
	private String registrationNumber;

	private Boolean accidental;

	@Column(name = "detailed_inspection")
	private Boolean detailedInspection;

	@Column(name = "fuel_type")
	private String fuelType;

	@Column(name = "inspection_level")
	private Integer inspectionLevel;

	@Column(name = "vehicle_status")
	private String vehicleStatus;

	@Column(name = "dealer_id")
	private Integer dealerId;

	@Column(name = "inventory_days")
	private Integer inventoryDays;

	@Column(name = "base_price")
	private Integer basePrice;

	@Column(name = "selling_price")
	private Integer sellingPrice;

	@Column(name = "insurance")
	private Boolean insurance;

	@Column(name = "mileage")
	private Integer mileage;

	@Column(name = "month")
	private Integer month;
	
	@Column(name = "transmission_type")
	private String transmissionType;

	@Column(name = "vin_num")
	private String vinNo;

	@Column(name = "year")
	private Integer year;

	@Column(name = "purchase_date")
	private Date purchaseDate;

	@Column(name = "previous_owners")
	private Integer previousOwners;

	@Column(name = "replacement_exchange_info")
	private String replaceOrExgInfo;

	@Column(name = "status")
	private String status;

	@Column(name = "branch_code")
	private String branchCode; 

	@Column(name = "unregister")
	private Boolean unRegister; 
	
	@Column(name = "is_taxi")
	private Boolean isTaxi; 
	
	@Column(name = "is_under_warranty")
	private Boolean isUnderWarranty; 
	
	@Column(name = "warranty_validity_date")
	private Date warrantyValidityDate; 

	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "vehicle")
	private List<ServiceHistory> serviceHistoryList = new ArrayList<>();

	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true, mappedBy = "vehicle")
	private List<Enquiry> enquiryList = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "make_id")
	private Make make;

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "model_id")
	private Model model;

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "exterior_colour_id")
	private ExteriorColor exteriorColor;

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "variant_id")
	private Variant variant;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "vehicle_stage_id")
	private VehicleStage vehicleStage;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "insurance_type_id")
	private InsuranceType insuranceType;
	
	@Column(name = "insurance_validity_date")
	private Date insuranceValidityDate;
	
	@Column(name = "collected_date")
	private Date collectedDate;  

	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "vehicle")
	private List<ChecklistMapping> checkListMapping;
	
	public List<ChecklistMapping> getCheckListMapping() {
		return checkListMapping;
	}

	public void setCheckListMapping(List<ChecklistMapping> checkListMapping) {
		this.checkListMapping = checkListMapping;
	}

	public Date getCollectedDate() {
		return collectedDate;
	}

	public void setCollectedDate(Date collectedDate) {
		this.collectedDate = collectedDate;
	}

	public Date getInsuranceValidityDate() {
		return insuranceValidityDate;
	}

	public void setInsuranceValidityDate(Date insuranceValidityDate) {
		this.insuranceValidityDate = insuranceValidityDate;
	}

	public String getVehicleStatus() {
		return vehicleStatus;
	}

	public void setVehicleStatus(String vehicleStatus) {
		this.vehicleStatus = vehicleStatus;
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

	public Make getMake() {
		return make;
	}

	public void setMake(Make make) {
		this.make = make;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public ExteriorColor getExteriorColor() {
		return exteriorColor;
	}

	public void setExteriorColor(ExteriorColor exteriorColor) {
		this.exteriorColor = exteriorColor;
	}

	public Variant getVariant() {
		return variant;
	}

	public void setVariant(Variant variant) {
		this.variant = variant;
	}

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
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

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Boolean getAccidental() {
		return accidental;
	}

	public Boolean getDetailedInspection() {
		return detailedInspection;
	}

	public Boolean isDetailedInspection() {
		return detailedInspection;
	}

	public void setDetailedInspection(Boolean detailedInspection) {
		this.detailedInspection = detailedInspection;
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

	public Boolean getInsurance() {
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

	public Integer getMileage() {
		return mileage;
	}

	public void setMileage(Integer mileage) {
		this.mileage = mileage;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public String getTransmissionType() {
		return transmissionType;
	}

	public void setTransmissionType(String transmissionType) {
		this.transmissionType = transmissionType;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ServiceHistory> getServiceHistoryList() {
		return serviceHistoryList;
	}

	public void setServiceHistoryList(List<ServiceHistory> serviceHistoryList) {
		this.serviceHistoryList = serviceHistoryList;
	}

	public List<Enquiry> getEnquiryList() {
		return enquiryList;
	}

	public void setEnquiryList(List<Enquiry> enquiryList) {
		this.enquiryList = enquiryList;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public VehicleStage getVehicleStage() {
		return vehicleStage;
	}

	public void setVehicleStage(VehicleStage vehicleStage) {
		this.vehicleStage = vehicleStage;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public InsuranceType getInsuranceType() {
		return insuranceType;
	}

	public void setInsuranceType(InsuranceType insuranceType) {
		this.insuranceType = insuranceType;
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