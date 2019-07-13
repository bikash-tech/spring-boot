package in.utrust.request;

import java.util.Date;

public class RCInfoRequest {
	private Boolean rcAvailable;
	private Date regDate;
	private int rcTypeId;
	private String rcCopy;
	private Boolean duplicateRC;
	private Boolean freshRC;
	private Boolean oneTimeTaxPaid;
	private Boolean reRegister;
	private int emmisionId;// ??
	private Boolean colourChanged;
	public Boolean getRcAvailable() {
		return rcAvailable;
	}
	public void setRcAvailable(Boolean rcAvailable) {
		this.rcAvailable = rcAvailable;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getRcTypeId() {
		return rcTypeId;
	}
	public void setRcTypeId(int rcTypeId) {
		this.rcTypeId = rcTypeId;
	}
	public String getRcCopy() {
		return rcCopy;
	}
	public void setRcCopy(String rcCopy) {
		this.rcCopy = rcCopy;
	}
	public Boolean getDuplicateRC() {
		return duplicateRC;
	}
	public void setDuplicateRC(Boolean duplicateRC) {
		this.duplicateRC = duplicateRC;
	}
	public Boolean getFreshRC() {
		return freshRC;
	}
	public void setFreshRC(Boolean freshRC) {
		this.freshRC = freshRC;
	}
	public Boolean getOneTimeTaxPaid() {
		return oneTimeTaxPaid;
	}
	public void setOneTimeTaxPaid(Boolean oneTimeTaxPaid) {
		this.oneTimeTaxPaid = oneTimeTaxPaid;
	}
	public Boolean getReRegister() {
		return reRegister;
	}
	public void setReRegister(Boolean reRegister) {
		this.reRegister = reRegister;
	}
	public int getEmmisionId() {
		return emmisionId;
	}
	public void setEmmisionId(int emmisionId) {
		this.emmisionId = emmisionId;
	}
	public Boolean getColourChanged() {
		return colourChanged;
	}
	public void setColourChanged(Boolean colourChanged) {
		this.colourChanged = colourChanged;
	}
	
	
}
