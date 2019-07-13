package in.utrust.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "service_history")
public class ServiceHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 	@Column(name="service_id")
	private Integer serviceId;

	@Column(name = "serial_num")
	private String serialNo;

	@Column(name = "service_typ")
	private String serviceType;

	@Column(name = "service_dt")
	private Date serviceDate;

	@Column(name = "job_ord_num")
	private String jobOrdNo;

	@Column(name = "job_ord_dt")
	private String jobOrdDt;

	@Column(name = "dealer_cd")
	private String dealerCd;

	@Column(name = "dealer_name")
	private String dealerName;

	@Column(name = "branch_cd")
	private String branchCd;

	@Column(name = "dealer_grp")
	private String dealerGroup;

	@Column(name = "mileage_in")
	private String mileageIn;

	@Column(name = "job_nature")
	private String jobNature;

	@Column(name = "cust_req")
	private String custReq;

	@Column(name = "op_desc")
	private String opDesc;

	@Column(name = "part_name")
	private String partName;

	@Column(name = "part_issue_qty")
	private String partIssueQty;

	@Column(name = "lab_cost")
	private String labourCost;

	@Column(name = "part_cost")
	private String partCost;

	@Column(name = "outside_lab_cost")
	private String outsideLabourCost;

	@Column(name = "outside_part_cost")
	private String outsidePartCost;

	@Column(name = "outside_body_cost")
	private String outsidebodyCost;

	@Column(name = "outside_oil_cost")
	private String outsideOilCost;

	@Column(name = "grand_total")
	private String grandTotal;

	@Column(name = "qc_cmnts")
	private String qcComments;

	@ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="vehicle_id")
	private Vehicle vehicle;

	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public Date getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(Date serviceDate) {
		this.serviceDate = serviceDate;
	}

	public String getJobOrdNo() {
		return jobOrdNo;
	}

	public void setJobOrdNo(String jobOrdNo) {
		this.jobOrdNo = jobOrdNo;
	}

	public String getJobOrdDt() {
		return jobOrdDt;
	}

	public void setJobOrdDt(String jobOrdDt) {
		this.jobOrdDt = jobOrdDt;
	}

	public String getDealerCd() {
		return dealerCd;
	}

	public void setDealerCd(String dealerCd) {
		this.dealerCd = dealerCd;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public String getBranchCd() {
		return branchCd;
	}

	public void setBranchCd(String branchCd) {
		this.branchCd = branchCd;
	}

	public String getDealerGroup() {
		return dealerGroup;
	}

	public void setDealerGroup(String dealerGroup) {
		this.dealerGroup = dealerGroup;
	}

	public String getMileageIn() {
		return mileageIn;
	}

	public void setMileageIn(String mileageIn) {
		this.mileageIn = mileageIn;
	}

	public String getJobNature() {
		return jobNature;
	}

	public void setJobNature(String jobNature) {
		this.jobNature = jobNature;
	}

	public String getCustReq() {
		return custReq;
	}

	public void setCustReq(String custReq) {
		this.custReq = custReq;
	}

	public String getOpDesc() {
		return opDesc;
	}

	public void setOpDesc(String opDesc) {
		this.opDesc = opDesc;
	}

	public String getPartName() {
		return partName;
	}

	public void setPartName(String partName) {
		this.partName = partName;
	}

	public String getPartIssueQty() {
		return partIssueQty;
	}

	public void setPartIssueQty(String partIssueQty) {
		this.partIssueQty = partIssueQty;
	}

	public String getLabourCost() {
		return labourCost;
	}

	public void setLabourCost(String labourCost) {
		this.labourCost = labourCost;
	}

	public String getPartCost() {
		return partCost;
	}

	public void setPartCost(String partCost) {
		this.partCost = partCost;
	}

	public String getOutsideLabourCost() {
		return outsideLabourCost;
	}

	public void setOutsideLabourCost(String outsideLabourCost) {
		this.outsideLabourCost = outsideLabourCost;
	}

	public String getOutsidePartCost() {
		return outsidePartCost;
	}

	public void setOutsidePartCost(String outsidePartCost) {
		this.outsidePartCost = outsidePartCost;
	}

	public String getOutsidebodyCost() {
		return outsidebodyCost;
	}

	public void setOutsidebodyCost(String outsidebodyCost) {
		this.outsidebodyCost = outsidebodyCost;
	}

	public String getOutsideOilCost() {
		return outsideOilCost;
	}

	public void setOutsideOilCost(String outsideOilCost) {
		this.outsideOilCost = outsideOilCost;
	}

	public String getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(String grandTotal) {
		this.grandTotal = grandTotal;
	}

	public String getQcComments() {
		return qcComments;
	}

	public void setQcComments(String qcComments) {
		this.qcComments = qcComments;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@Override
	public String toString() {
		return "ServiceHistory [serviceId=" + serviceId + ", serialNo=" + serialNo + ", serviceType=" + serviceType
				+ ", serviceDate=" + serviceDate + ", jobOrdNo=" + jobOrdNo + ", jobOrdDt=" + jobOrdDt + ", dealerCd="
				+ dealerCd + ", dealerName=" + dealerName + ", branchCd=" + branchCd + ", dealerGroup=" + dealerGroup
				+ ", mileageIn=" + mileageIn + ", jobNature=" + jobNature + ", custReq=" + custReq + ", opDesc="
				+ opDesc + ", partName=" + partName + ", partIssueQty=" + partIssueQty + ", labourCost=" + labourCost
				+ ", partCost=" + partCost + ", outsideLabourCost=" + outsideLabourCost + ", outsidePartCost="
				+ outsidePartCost + ", outsidebodyCost=" + outsidebodyCost + ", outsideOilCost=" + outsideOilCost
				+ ", grandTotal=" + grandTotal + ", qcComments=" + qcComments + ", vehicle=" + vehicle + "]";
	}


}