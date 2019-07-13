
package in.utrust.model;

import java.io.Serializable;
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
@Table(name = "enquiry")
public class Enquiry implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "enq_number")
	private String enquiryNumber;

	@Column(name = "enq_date")
	private Date enquiryDate;

	@Column(name = "enq_exp_delivery_date")
	private Date enquiryExpDeliveryDate;

	@Column(name = "enq_status")
	private String enquiryStatus;

	@Column(name = "enq_generated_by")
	private String enquiryGeneratedBy;

	@Column(name = "activity_date")
	private Date activityDate;

	@Column(name = "actual_valuation_date")
	private Date actualValuationDate;

	@Column(name = "buyer_enq_number")
	private String buyerEnquiryNo;

	@Column(name = "mobile_number")
	private String mobileNumber;

	@Column(name = "buyer_enq_date")
	private Date buyerEnquiryDate;

	@Column(name = "buyer_enq_last_followup_date")
	private Date buyerEnquiryLastFollowUpDate;

	@Column(name = "buyer_enq_order_date")
	private Date buyerEnquiryOrderDate;

	@Column(name = "contact_name")
	private String contactName;

	@Column(name = "contact_email")
	private String contactEmail;

	@Column(name = "contact_person_title")
	private String contactPersonTitle;

	@Column(name = "new_car_enq_details")
	private String newCarEnquiryDetails;

	@Column(name = "new_car_enq_number")
	private String newCarEnquiryNo;

	@Column(name = "pref_contcact_mode")
	private String preferredContactMode;

	@Column(name = "pref_contcact_address")
	private String preferredContactAddress;

	@Column(name = "suggested_price")
	private Double suggestedPrice;

	@Column(name = "actual_price")
	private Double actualPrice;

	@Column(name = "expected_offer")
	private Double expectedOffer;

	@Column(name = "drop_reason")
	private String dropReason;

	@Column(name = "drop_remark")
	private String dropRemark;

	@Column(name = "drop_detailed_remark")
	private String dropDetailedRemark;

	@Column(name = "booking_date")
	private Date bookingDate;

	@Column(name = "status")
	private String status;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "enquiry", fetch = FetchType.LAZY)
	private List<Valuation> valuationList = new ArrayList<>();

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "vehicle_id")
	private Vehicle vehicle;

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "demand_structure_id")
	private DemandStructure demandStructure;

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "source_name_id")
	private SourceName sourceName;

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "source_type_id")
	private SourceType sourceType;

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "channel_id")
	private Channel channel;

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "status_reasoning_id")
	private StatusReasoning statusReasoning;

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "selling_reasoning_id")
	private SellingReason sellingReasoning;

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "so_id")
	private DealerUser dealerUserSo;

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "stl_id")
	private DealerUser dealerUserStl;

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "enq_type_id")
	private EnquiryType enquiryType;
	
	@Column(name = "assigned_to")
	private Integer assignTo;
	

	@Column(name = "assigned_by")
	private Integer assigenedby;

	@Column(name = "modified_at")
	private Date modifiedat;

	@Column(name = "modified_by")
	private Integer modifiedby;

	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "created_by")
	private Integer createdBy;

	@Column(name = "enq_category")
	private String enquiryCategory;

	@Column(name = "budget_from")
	private Integer budgetFrom;

	@Column(name = "budget_to")
	private Integer budgetTo;
	
	@Column(name = "is_procurement_saved")
	private Boolean isProcurementSaved;
	
	@Column(name = "selling_remark")
	private String sellingRemark;

	@Column(name = "direct_purchase")
	private Boolean directPurchase;
	
	@Column(name = "adhar_number")
	private String aadhaarNumber;

	@Column(name = "purchase_number")
	private String purchaseNumber;

	public String getAadhaarNumber() {
		return aadhaarNumber;
	}

	public void setAadhaarNumber(String aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}

	public Boolean getDirectPurchase() {
		return directPurchase;
	}

	public void setDirectPurchase(Boolean directPurchase) {
		this.directPurchase = directPurchase;
	}

	public String getSellingRemark() {
		return sellingRemark;
	}

	public void setSellingRemark(String sellingRemark) {
		this.sellingRemark = sellingRemark;
	}

	public Boolean getIsProcurementSaved() {
		return isProcurementSaved;
	}

	public void setIsProcurementSaved(Boolean isProcurementSaved) {
		this.isProcurementSaved = isProcurementSaved;
	}

	public Date getBookingDate() {
		return bookingDate;
	}
	
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public DealerUser getDealerUserSo() {
		return dealerUserSo;
	}

	public void setDealerUserSo(DealerUser dealerUserSo) {
		this.dealerUserSo = dealerUserSo;
	}

	public DealerUser getDealerUserStl() {
		return dealerUserStl;
	}

	public void setDealerUserStl(DealerUser dealerUserStl) {
		this.dealerUserStl = dealerUserStl;
	}

	public Integer getBudgetFrom() {
		return budgetFrom;
	}

	public void setBudgetFrom(Integer budgetFrom) {
		this.budgetFrom = budgetFrom;
	}

	public Integer getBudgetTo() {
		return budgetTo;
	}

	public void setBudgetTo(Integer budgetTo) {
		this.budgetTo = budgetTo;
	}

 	
 	
	public String getDropRemark() {
		return dropRemark;
	}

	public void setDropRemark(String dropRemark) {
		this.dropRemark = dropRemark;
	}

	public String getDropDetailedRemark() {
		return dropDetailedRemark;
	}

	public void setDropDetailedRemark(String dropDetailedRemark) {
		this.dropDetailedRemark = dropDetailedRemark;
	}

	
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getEnquiryCategory() {
		return enquiryCategory;
	}

	public void setEnquiryCategory(String enquiryCategory) {
		this.enquiryCategory = enquiryCategory;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(Integer modifiedby) {
		this.modifiedby = modifiedby;
	}

	public Date getModifiedat() {
		return modifiedat;
	}

	public void setModifiedat(Date modifiedat) {
		this.modifiedat = modifiedat;
	}

	public Integer getAssigenedby() {
		return assigenedby;
	}

	public void setAssigenedby(Integer assigenedby) {
		this.assigenedby = assigenedby;
	}
	 

	public Integer getAssignTo() {
		return assignTo;
	}

	public void setAssignTo(Integer assignTo) {
		this.assignTo = assignTo;
	}

	public SellingReason getSellingReasoning() {
		return sellingReasoning;
	}

	public void setSellingReasoning(SellingReason sellingReasoning) {
		this.sellingReasoning = sellingReasoning;
	}

	public String getEnquiryNumber() {
		return enquiryNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setEnquiryNumber(String enquiryNumber) {
		this.enquiryNumber = enquiryNumber;
	}

	public Date getActualValuationDate() {
		return actualValuationDate;
	}

	public void setActualValuationDate(Date actualValuationDate) {
		this.actualValuationDate = actualValuationDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EnquiryType getEnquiryType() {
		return enquiryType;
	}

	public void setEnquiryType(EnquiryType enquiryType) {
		this.enquiryType = enquiryType;
	}

	public String getEnquiryStatus() {
		return enquiryStatus;
	}

	public void setEnquiryStatus(String enquiryStatus) {
		this.enquiryStatus = enquiryStatus;
	}

	public String getEnquiryGeneratedBy() {
		return enquiryGeneratedBy;
	}

	public void setEnquiryGeneratedBy(String enquiryGeneratedBy) {
		this.enquiryGeneratedBy = enquiryGeneratedBy;
	}

	public String getDropReason() {
		return dropReason;
	}

	public void setDropReason(String dropReason) {
		this.dropReason = dropReason;
	}

	public Date getEnquiryDate() {
		return enquiryDate;
	}

	public void setEnquiryDate(Date enquiryDate) {
		this.enquiryDate = enquiryDate;
	}

	public Date getEnquiryExpDeliveryDate() {
		return enquiryExpDeliveryDate;
	}

	public void setEnquiryExpDeliveryDate(Date enquiryExpDeliveryDate) {
		this.enquiryExpDeliveryDate = enquiryExpDeliveryDate;
	}

	public Date getActivityDate() {
		return activityDate;
	}

	public void setActivityDate(Date activityDate) {
		this.activityDate = activityDate;
	}

	public String getBuyerEnquiryNo() {
		return buyerEnquiryNo;
	}

	public void setBuyerEnquiryNo(String buyerEnquiryNo) {
		this.buyerEnquiryNo = buyerEnquiryNo;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Date getBuyerEnquiryDate() {
		return buyerEnquiryDate;
	}

	public void setBuyerEnquiryDate(Date buyerEnquiryDate) {
		this.buyerEnquiryDate = buyerEnquiryDate;
	}

	public Date getBuyerEnquiryLastFollowUpDate() {
		return buyerEnquiryLastFollowUpDate;
	}

	public void setBuyerEnquiryLastFollowUpDate(Date buyerEnquiryLastFollowUpDate) {
		this.buyerEnquiryLastFollowUpDate = buyerEnquiryLastFollowUpDate;
	}

	public Date getBuyerEnquiryOrderDate() {
		return buyerEnquiryOrderDate;
	}

	public void setBuyerEnquiryOrderDate(Date buyerEnquiryOrderDate) {
		this.buyerEnquiryOrderDate = buyerEnquiryOrderDate;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactPersonTitle() {
		return contactPersonTitle;
	}

	public void setContactPersonTitle(String contactPersonTitle) {
		this.contactPersonTitle = contactPersonTitle;
	}

	public DemandStructure getDemandStructure() {
		return demandStructure;
	}

	public void setDemandStructure(DemandStructure demandStructure) {
		this.demandStructure = demandStructure;
	}

	public SourceName getSourceName() {
		return sourceName;
	}

	public void setSourceName(SourceName sourceName) {
		this.sourceName = sourceName;
	}

	public SourceType getSourceType() {
		return sourceType;
	}

	public void setSourceType(SourceType sourceType) {
		this.sourceType = sourceType;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public StatusReasoning getStatusReasoning() {
		return statusReasoning;
	}

	public void setStatusReasoning(StatusReasoning statusReasoning) {
		this.statusReasoning = statusReasoning;
	}

	public String getNewCarEnquiryDetails() {
		return newCarEnquiryDetails;
	}

	public void setNewCarEnquiryDetails(String newCarEnquiryDetails) {
		this.newCarEnquiryDetails = newCarEnquiryDetails;
	}

	public String getNewCarEnquiryNo() {
		return newCarEnquiryNo;
	}

	public void setNewCarEnquiryNo(String newCarEnquiryNo) {
		this.newCarEnquiryNo = newCarEnquiryNo;
	}

	public String getPreferredContactMode() {
		return preferredContactMode;
	}

	public void setPreferredContactMode(String preferredContactMode) {
		this.preferredContactMode = preferredContactMode;
	}

	public String getPreferredContactAddress() {
		return preferredContactAddress;
	}

	public void setPreferredContactAddress(String preferredContactAddress) {
		this.preferredContactAddress = preferredContactAddress;
	}

	public Double getSuggestedPrice() {
		return suggestedPrice;
	}

	public void setSuggestedPrice(Double suggestedPrice) {
		this.suggestedPrice = suggestedPrice;
	}

	public Double getActualPrice() {
		return actualPrice;
	}

	public void setActualPrice(Double actualPrice) {
		this.actualPrice = actualPrice;
	}

	public Double getExpectedOffer() {
		return expectedOffer;
	}

	public void setExpectedOffer(Double expectedOffer) {
		this.expectedOffer = expectedOffer;
	}

	public List<Valuation> getValuationList() {
		return valuationList;
	}

	public void setValuationList(List<Valuation> valuationList) {
		this.valuationList = valuationList;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getPurchaseNumber() {
		return purchaseNumber;
	}

	public void setPurchaseNumber(String purchaseNumber) {
		this.purchaseNumber = purchaseNumber;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Enquiry [id=");
		builder.append(id);
		builder.append(", enquiryNumber=");
		builder.append(enquiryNumber);
		builder.append(", enquiryDate=");
		builder.append(enquiryDate);
		builder.append(", enquiryExpDeliveryDate=");
		builder.append(enquiryExpDeliveryDate);
		builder.append(", enquiryStatus=");
		builder.append(enquiryStatus);
		builder.append(", enquiryGeneratedBy=");
		builder.append(enquiryGeneratedBy);
		builder.append(", activityDate=");
		builder.append(activityDate);
		builder.append(", actualValuationDate=");
		builder.append(actualValuationDate);
		builder.append(", buyerEnquiryNo=");
		builder.append(buyerEnquiryNo);
		builder.append(", mobileNumber=");
		builder.append(mobileNumber);
		builder.append(", buyerEnquiryDate=");
		builder.append(buyerEnquiryDate);
		builder.append(", buyerEnquiryLastFollowUpDate=");
		builder.append(buyerEnquiryLastFollowUpDate);
		builder.append(", buyerEnquiryOrderDate=");
		builder.append(buyerEnquiryOrderDate);
		builder.append(", contactName=");
		builder.append(contactName);
		builder.append(", contactEmail=");
		builder.append(contactEmail);
		builder.append(", contactPersonTitle=");
		builder.append(contactPersonTitle);
		builder.append(", newCarEnquiryDetails=");
		builder.append(newCarEnquiryDetails);
		builder.append(", newCarEnquiryNo=");
		builder.append(newCarEnquiryNo);
		builder.append(", preferredContactMode=");
		builder.append(preferredContactMode);
		builder.append(", preferredContactAddress=");
		builder.append(preferredContactAddress);
		builder.append(", suggestedPrice=");
		builder.append(suggestedPrice);
		builder.append(", actualPrice=");
		builder.append(actualPrice);
		builder.append(", expectedOffer=");
		builder.append(expectedOffer);
		builder.append(", dropReason=");
		builder.append(dropReason);
		builder.append(", dropRemark=");
		builder.append(dropRemark);
		builder.append(", dropDetailedRemark=");
		builder.append(dropDetailedRemark);
		builder.append(", bookingDate=");
		builder.append(bookingDate);
		builder.append(", status=");
		builder.append(status);
		builder.append(", valuationList=");
		builder.append(valuationList);
		builder.append(", vehicle=");
		builder.append(vehicle);
		builder.append(", customer=");
		builder.append(customer);
		builder.append(", demandStructure=");
		builder.append(demandStructure);
		builder.append(", sourceName=");
		builder.append(sourceName);
		builder.append(", sourceType=");
		builder.append(sourceType);
		builder.append(", channel=");
		builder.append(channel);
		builder.append(", statusReasoning=");
		builder.append(statusReasoning);
		builder.append(", sellingReasoning=");
		builder.append(sellingReasoning);
		builder.append(", dealerUserSo=");
		builder.append(dealerUserSo);
		builder.append(", dealerUserStl=");
		builder.append(dealerUserStl);
		builder.append(", enquiryType=");
		builder.append(enquiryType);
		builder.append(", assignTo=");
		builder.append(assignTo);
		builder.append(", assigenedby=");
		builder.append(assigenedby);
		builder.append(", modifiedat=");
		builder.append(modifiedat);
		builder.append(", modifiedby=");
		builder.append(modifiedby);
		builder.append(", createdAt=");
		builder.append(createdAt);
		builder.append(", createdBy=");
		builder.append(createdBy);
		builder.append(", enquiryCategory=");
		builder.append(enquiryCategory);
		builder.append(", budgetFrom=");
		builder.append(budgetFrom);
		builder.append(", budgetTo=");
		builder.append(budgetTo);
		builder.append(", isProcurementSaved=");
		builder.append(isProcurementSaved);
		builder.append(", sellingRemark=");
		builder.append(sellingRemark);
		builder.append(", directPurchase=");
		builder.append(directPurchase);
		builder.append(", aadhaarNumber=");
		builder.append(aadhaarNumber);
		builder.append(", purchaseNumber=");
		builder.append(purchaseNumber);
		builder.append("]");
		return builder.toString();
	}

}