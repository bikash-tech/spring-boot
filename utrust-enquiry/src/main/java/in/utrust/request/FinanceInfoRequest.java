package in.utrust.request;

import java.util.Date;

public class FinanceInfoRequest {
	private int nocStatusId; 
	// Browse NOC 
	private String hypothecationBankName;
	private double preClosureAmount;
	private String nocStatusDoc;
	public int getNocStatusId() {
		return nocStatusId;
	}
	public void setNocStatusId(int nocStatusId) {
		this.nocStatusId = nocStatusId;
	}
	public String getHypothecationBankName() {
		return hypothecationBankName;
	}
	public void setHypothecationBankName(String hypothecationBankName) {
		this.hypothecationBankName = hypothecationBankName;
	}
	public double getPreClosureAmount() {
		return preClosureAmount;
	}
	public void setPreClosureAmount(double preClosureAmount) {
		this.preClosureAmount = preClosureAmount;
	}
	public String getNocStatusDoc() {
		return nocStatusDoc;
	}
	public void setNocStatusDoc(String nocStatusDoc) {
		this.nocStatusDoc = nocStatusDoc;
	}
	
	

}
