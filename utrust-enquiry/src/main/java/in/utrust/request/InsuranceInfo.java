package in.utrust.request;

import java.util.Date;

public class InsuranceInfo {
	private int insuranceId; 
	private Date monthAndYear;
 	private int insuranceCompanyId;// ??
	private double idvValue;
	private double ncb;
	private Double premiumAmount;
	private Boolean noClaimBonus;
	public int getInsuranceId() {
		return insuranceId;
	}
	public void setInsuranceId(int insuranceId) {
		this.insuranceId = insuranceId;
	}
	public Date getMonthAndYear() {
		return monthAndYear;
	}
	public void setMonthAndYear(Date monthAndYear) {
		this.monthAndYear = monthAndYear;
	}
	public int getInsuranceCompanyId() {
		return insuranceCompanyId;
	}
	public void setInsuranceCompanyId(int insuranceCompanyId) {
		this.insuranceCompanyId = insuranceCompanyId;
	}
	public double getIdvValue() {
		return idvValue;
	}
	public void setIdvValue(double idvValue) {
		this.idvValue = idvValue;
	}
	public double getNcb() {
		return ncb;
	}
	public void setNcb(double ncb) {
		this.ncb = ncb;
	}
	public Double getPremiumAmount() {
		return premiumAmount;
	}
	public void setPremiumAmount(Double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}
	public Boolean getNoClaimBonus() {
		return noClaimBonus;
	}
	public void setNoClaimBonus(Boolean noClaimBonus) {
		this.noClaimBonus = noClaimBonus;
	}
	
	
}
