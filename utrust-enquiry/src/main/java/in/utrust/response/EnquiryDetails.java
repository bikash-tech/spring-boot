package in.utrust.response;

import javax.persistence.Column;

public class EnquiryDetails {  
	
	private Integer poId;
	private String poName;
	
	private String dealerName;
	private String dealerLocation;
	
	private Integer ptlId;
	private String ptlName;
	
	private Integer ucmId;
	private String ucmName;
	
	private String dealerCode;
	private String branchCode;
	
	
	public String getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}
	public String getDealerCode() {
		return dealerCode;
	}
	public void setDealerCode(String dealerCode) {
		this.dealerCode = dealerCode;
	}
	public Integer getPtlId() {
		return ptlId;
	}
	public void setPtlId(Integer ptlId) {
		this.ptlId = ptlId;
	}
	public String getPtlName() {
		return ptlName;
	}
	public void setPtlName(String ptlName) {
		this.ptlName = ptlName;
	}
	public Integer getUcmId() {
		return ucmId;
	}
	public void setUcmId(Integer ucmId) {
		this.ucmId = ucmId;
	}
	public String getUcmName() {
		return ucmName;
	}
	public void setUcmName(String ucmName) {
		this.ucmName = ucmName;
	}
	public Integer getPoId() {
		return poId;
	}
	public void setPoId(Integer poId) {
		this.poId = poId;
	}
	public String getPoName() {
		return poName;
	}
	public void setPoName(String poName) {
		this.poName = poName;
	}
	public String getDealerName() {
		return dealerName;
	}
	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}
	public String getDealerLocation() {
		return dealerLocation;
	}
	public void setDealerLocation(String dealerLocation) {
		this.dealerLocation = dealerLocation;
	}
}
