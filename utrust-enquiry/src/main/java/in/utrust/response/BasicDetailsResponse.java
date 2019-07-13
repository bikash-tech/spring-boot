package in.utrust.response;

import java.util.Date;

public class BasicDetailsResponse {
	private String enquiryNumber;
	private String dropReason;
	private String dropRemarks;
	private String preferredContactAddress;
	private String contactEmail;
	private String preferredContactMode;
	private String newCarEnquiryNo;
	private String newCarEnquiryDetails;
	private String contactName;
	private String contactPersonTitle;
	private String enquiryStatus;
	private String enquiryGeneratedBy;
	private String mobileNumber;
	private String buyerEnquiryNo;
	private String sellingRemark;
	private String purchaseNumber;
	private Date enquiryExpDeliveryDate;
	private Date enquiryDate;
	private Date activityDate;
	private Date actualValuationDate;
	private Date bookingDate;
	private Integer budgetFrom = 200000;
	private Integer budgetTo = 700000;
	private Integer soId = 2;
	private String soName = "Anshuman";
	private Integer stlId = 1;
	private String stlName = "Ram";
	private Boolean directPurchase;
	private boolean newFollowup;
	private SourceTypeResponse sourceType;
	private SourceNameResponse sourceName;
	private StatusReasoningResponse statusReasoning;
	private DemandStructureResponse demandStructure;
	private ChannelResponse channel;
	private SellingReasonResponse sellingReason;
	private DealerResponse dealerResponse;
	private CustomerResponse customer;
	private EnquiryTypeResponse enquiryType;

	
	public Boolean getDirectPurchase() {
		return directPurchase;
	}

	public void setDirectPurchase(Boolean directPurchase) {
		this.directPurchase = directPurchase;
	}

	public SellingReasonResponse getSellingReason() {
		return sellingReason;
	}

	public void setSellingReason(SellingReasonResponse sellingReason) {
		this.sellingReason = sellingReason;
	}

	public SourceTypeResponse getSourceType() {
		return sourceType;
	}

	public void setSourceType(SourceTypeResponse sourceType) {
		this.sourceType = sourceType;
	}

	public SourceNameResponse getSourceName() {
		return sourceName;
	}

	public void setSourceName(SourceNameResponse sourceName) {
		this.sourceName = sourceName;
	}

	public StatusReasoningResponse getStatusReasoning() {
		return statusReasoning;
	}

	public void setStatusReasoning(StatusReasoningResponse statusReasoning) {
		this.statusReasoning = statusReasoning;
	}

	public DemandStructureResponse getDemandStructure() {
		return demandStructure;
	}

	public void setDemandStructure(DemandStructureResponse demandStructure) {
		this.demandStructure = demandStructure;
	}

	public ChannelResponse getChannel() {
		return channel;
	}

	public void setChannel(ChannelResponse channel) {
		this.channel = channel;
	}

	public DealerResponse getDealerResponse() {
		return dealerResponse;
	}

	public void setDealerResponse(DealerResponse dealerResponse) {
		this.dealerResponse = dealerResponse;
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

	public Integer getSoId() {
		return soId;
	}

	public void setSoId(Integer soId) {
		this.soId = soId;
	}

	public String getSoName() {
		return soName;
	}

	public void setSoName(String soName) {
		this.soName = soName;
	}

	public Integer getStlId() {
		return stlId;
	}

	public void setStlId(Integer stlId) {
		this.stlId = stlId;
	}

	public String getStlName() {
		return stlName;
	}

	public void setStlName(String stlName) {
		this.stlName = stlName;
	}

	public CustomerResponse getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerResponse customer) {
		this.customer = customer;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getEnquiryNumber() {
		return enquiryNumber;
	}

	public void setEnquiryNumber(String enquiryNumber) {
		this.enquiryNumber = enquiryNumber;
	}

	public String getDropReason() {
		return dropReason;
	}

	public void setDropReason(String dropReason) {
		this.dropReason = dropReason;
	}

	public String getDropRemarks() {
		return dropRemarks;
	}

	public void setDropRemarks(String dropRemarks) {
		this.dropRemarks = dropRemarks;
	}

	public String getPreferredContactAddress() {
		return preferredContactAddress;
	}

	public void setPreferredContactAddress(String preferredContactAddress) {
		this.preferredContactAddress = preferredContactAddress;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getPreferredContactMode() {
		return preferredContactMode;
	}

	public void setPreferredContactMode(String preferredContactMode) {
		this.preferredContactMode = preferredContactMode;
	}

	public String getNewCarEnquiryNo() {
		return newCarEnquiryNo;
	}

	public void setNewCarEnquiryNo(String newCarEnquiryNo) {
		this.newCarEnquiryNo = newCarEnquiryNo;
	}

	public String getNewCarEnquiryDetails() {
		return newCarEnquiryDetails;
	}

	public void setNewCarEnquiryDetails(String newCarEnquiryDetails) {
		this.newCarEnquiryDetails = newCarEnquiryDetails;
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

	public String getEnquiryStatus() {
		return enquiryStatus;
	}

	public void setEnquiryStatus(String enquiryStatus) {
		this.enquiryStatus = enquiryStatus;
	}

	public EnquiryTypeResponse getEnquiryType() {
		return enquiryType;
	}

	public void setEnquiryType(EnquiryTypeResponse enquiryType) {
		this.enquiryType = enquiryType;
	}

	public Date getEnquiryExpDeliveryDate() {
		return enquiryExpDeliveryDate;
	}

	public void setEnquiryExpDeliveryDate(Date enquiryExpDeliveryDate) {
		this.enquiryExpDeliveryDate = enquiryExpDeliveryDate;
	}

	public Date getEnquiryDate() {
		return enquiryDate;
	}

	public void setEnquiryDate(Date enquiryDate) {
		this.enquiryDate = enquiryDate;
	}

	public Date getActivityDate() {
		return activityDate;
	}

	public void setActivityDate(Date activityDate) {
		this.activityDate = activityDate;
	}

	public Date getActualValuationDate() {
		return actualValuationDate;
	}

	public void setActualValuationDate(Date actualValuationDate) {
		this.actualValuationDate = actualValuationDate;
	}

	public boolean isNewFollowup() {
		return newFollowup;
	}

	public void setNewFollowup(boolean newFollowup) {
		this.newFollowup = newFollowup;
	}

	public String getEnquiryGeneratedBy() {
		return enquiryGeneratedBy;
	}

	public void setEnquiryGeneratedBy(String enquiryGeneratedBy) {
		this.enquiryGeneratedBy = enquiryGeneratedBy;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getBuyerEnquiryNo() {
		return buyerEnquiryNo;
	}

	public void setBuyerEnquiryNo(String buyerEnquiryNo) {
		this.buyerEnquiryNo = buyerEnquiryNo;
	}

	public String getSellingRemark() {
		return sellingRemark;
	}

	public void setSellingRemark(String sellingRemark) {
		this.sellingRemark = sellingRemark;
	}

	public String getPurchaseNumber() {
		return purchaseNumber;
	}

	public void setPurchaseNumber(String purchaseNumber) {
		this.purchaseNumber = purchaseNumber;
	}
	
}
