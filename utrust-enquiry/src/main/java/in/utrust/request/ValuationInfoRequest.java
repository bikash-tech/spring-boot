package in.utrust.request;

public class ValuationInfoRequest {
	private int valuationId;
  	private Boolean isUpdate=false; 

	RCInfoRequest rcInformation= new RCInfoRequest();
	VehicleInfoRequest vehicleInfo = new VehicleInfoRequest();
	FinanceInfoRequest  financeInfo  = new FinanceInfoRequest();
	InsuranceInfo insuranceInfo  = new InsuranceInfo();
	OtherInfo otherInfo = new OtherInfo();
	Assessment assessment = new Assessment();
	
	
	public int getValuationId() {
		return valuationId;
	}
	public void setValuationId(int valuationId) {
		this.valuationId = valuationId;
	}
	public Boolean getIsUpdate() {
		return isUpdate;
	}
	public void setIsUpdate(Boolean isUpdate) {
		this.isUpdate = isUpdate;
	}
	public RCInfoRequest getRcInformation() {
		return rcInformation;
	}
	public void setRcInformation(RCInfoRequest rcInformation) {
		this.rcInformation = rcInformation;
	}
	public VehicleInfoRequest getVehicleInfo() {
		return vehicleInfo;
	}
	public void setVehicleInfo(VehicleInfoRequest vehicleInfo) {
		this.vehicleInfo = vehicleInfo;
	}
	public FinanceInfoRequest getFinanceInfo() {
		return financeInfo;
	}
	public void setFinanceInfo(FinanceInfoRequest financeInfo) {
		this.financeInfo = financeInfo;
	}
	public InsuranceInfo getInsuranceInfo() {
		return insuranceInfo;
	}
	public void setInsuranceInfo(InsuranceInfo insuranceInfo) {
		this.insuranceInfo = insuranceInfo;
	}
	public OtherInfo getOtherInfo() {
		return otherInfo;
	}
	public void setOtherInfo(OtherInfo otherInfo) {
		this.otherInfo = otherInfo;
	}
	public Assessment getAssessment() {
		return assessment;
	}
	public void setAssessment(Assessment assessment) {
		this.assessment = assessment;
	}
 	
}
