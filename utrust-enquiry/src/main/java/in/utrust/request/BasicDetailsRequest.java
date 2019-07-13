package in.utrust.request;

import java.util.Date;

public class BasicDetailsRequest {
	private String enquiryNumber;
	private String dropReason;
	private String dropRemarks;
  	private Integer sourceTypeId;
	private Integer sourceNameId;
	private Integer statusReasoningId;
	private Integer demandStructureId;
	private Integer channelId;
	private Integer enquiryTypeId;
	private Integer sellingReasonId;

	private Date activityDate;
	private Date actualValuationDate;
	private Date enquiryExpDeliveryDate;
	private Date enquiryDate;
	
	private String preferredContactAddress;
	private String contactEmail;
	private String sellingRemark;
	private String preferredContactMode;
	private String newCarEnquiryNo;
	private String newCarEnquiryDetails;
	private String contactName;
	private String contactPersonTitle;
	private String enquiryStatus;
	private String mobileNumber;
	private String buyerEnquiryNo;
	private String enquiryGeneratedBy;
	private Boolean directPurchase;
  	private Boolean isUpdate=false; 

	private CustomerRequest customer;
  	
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
	public Boolean getIsUpdate() {
		return isUpdate;
	}
	public void setIsUpdate(Boolean isUpdate) {
		this.isUpdate = isUpdate;
	}
	public CustomerRequest getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerRequest customer) {
		this.customer = customer;
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
	public Integer getSourceTypeId() {
		return sourceTypeId;
	}
	public void setSourceTypeId(Integer sourceTypeId) {
		this.sourceTypeId = sourceTypeId;
	}
	public Integer getSourceNameId() {
		return sourceNameId;
	}
	public void setSourceNameId(Integer sourceNameId) {
		this.sourceNameId = sourceNameId;
	}
	public Integer getStatusReasoningId() {
		return statusReasoningId;
	}
	public void setStatusReasoningId(Integer statusReasoningId) {
		this.statusReasoningId = statusReasoningId;
	}
	public Integer getDemandStructureId() {
		return demandStructureId;
	}
	public void setDemandStructureId(Integer demandStructureId) {
		this.demandStructureId = demandStructureId;
	}
	public Integer getChannelId() {
		return channelId;
	}
	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
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
	public Integer getSellingReasonId() {
		return sellingReasonId;
	}
	public void setSellingReasonId(Integer sellingReasonId) {
		this.sellingReasonId = sellingReasonId;
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
	public Date getEnquiryExpDeliveryDate() {
		return enquiryExpDeliveryDate;
	}
	public void setEnquiryExpDeliveryDate(Date enquiryExpDeliveryDate) {
		this.enquiryExpDeliveryDate = enquiryExpDeliveryDate;
	}
	public Integer getEnquiryTypeId() {
		return enquiryTypeId;
	}
	public void setEnquiryTypeId(Integer enquiryTypeId) {
		this.enquiryTypeId = enquiryTypeId;
	}
	public Date getEnquiryDate() {
		return enquiryDate;
	}
	public void setEnquiryDate(Date enquiryDate) {
		this.enquiryDate = enquiryDate;
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
	public String getEnquiryGeneratedBy() {
		return enquiryGeneratedBy;
	}
	public void setEnquiryGeneratedBy(String enquiryGeneratedBy) {
		this.enquiryGeneratedBy = enquiryGeneratedBy;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BasicDetailsRequest [enquiryNumber=");
		builder.append(enquiryNumber);
		builder.append(", dropReason=");
		builder.append(dropReason);
		builder.append(", dropRemarks=");
		builder.append(dropRemarks);
		builder.append(", sourceTypeId=");
		builder.append(sourceTypeId);
		builder.append(", sourceNameId=");
		builder.append(sourceNameId);
		builder.append(", statusReasoningId=");
		builder.append(statusReasoningId);
		builder.append(", demandStructureId=");
		builder.append(demandStructureId);
		builder.append(", channelId=");
		builder.append(channelId);
		builder.append(", enquiryTypeId=");
		builder.append(enquiryTypeId);
		builder.append(", sellingReasonId=");
		builder.append(sellingReasonId);
		builder.append(", activityDate=");
		builder.append(activityDate);
		builder.append(", actualValuationDate=");
		builder.append(actualValuationDate);
		builder.append(", enquiryExpDeliveryDate=");
		builder.append(enquiryExpDeliveryDate);
		builder.append(", enquiryDate=");
		builder.append(enquiryDate);
		builder.append(", preferredContactAddress=");
		builder.append(preferredContactAddress);
		builder.append(", contactEmail=");
		builder.append(contactEmail);
		builder.append(", sellingRemark=");
		builder.append(sellingRemark);
		builder.append(", preferredContactMode=");
		builder.append(preferredContactMode);
		builder.append(", newCarEnquiryNo=");
		builder.append(newCarEnquiryNo);
		builder.append(", newCarEnquiryDetails=");
		builder.append(newCarEnquiryDetails);
		builder.append(", contactName=");
		builder.append(contactName);
		builder.append(", contactPersonTitle=");
		builder.append(contactPersonTitle);
		builder.append(", enquiryStatus=");
		builder.append(enquiryStatus);
		builder.append(", mobileNumber=");
		builder.append(mobileNumber);
		builder.append(", buyerEnquiryNo=");
		builder.append(buyerEnquiryNo);
		builder.append(", enquiryGeneratedBy=");
		builder.append(enquiryGeneratedBy);
		builder.append(", directPurchase=");
		builder.append(directPurchase);
		builder.append(", isUpdate=");
		builder.append(isUpdate);
		builder.append(", customer=");
		builder.append(customer);
		builder.append("]");
		return builder.toString();
	}
	
}